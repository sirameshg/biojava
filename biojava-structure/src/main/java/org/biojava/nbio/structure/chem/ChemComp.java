package org.biojava.nbio.structure.chem;

import org.biojava.nbio.structure.io.cif.CifBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Properties of a chemical component.
 */
public class ChemComp implements CifBean<org.rcsb.cif.schema.mm.ChemComp>, Comparable<ChemComp> {
    private static final long serialVersionUID = -4736341142030215915L;

    private String id;
    private String name;
    private String type;
    private String pdbxType;
    private String formula;
    private String monNstdParentCompId;
    private String pdbxSynonyms;
    private String pdbxFormalCharge;
    private String pdbxInitialDate;
    private String pdbxModifiedDate;
    private String pdbxAmbiguousFlag;
    private String pdbxReleaseStatus;
    private String pdbxReplacedBy;
    private String pdbxReplaces;
    private String formulaWeight;
    private String oneLetterCode;
    private String threeLetterCode;
    private String pdbxModelCoordinatesDetails;
    private String pdbxModelCoordinatesMissingFlag;
    private String pdbxIdealCoordinatesDetails;
    private String pdbxIdealCoordinatesMissingFlag;
    private String pdbxModelCoordinatesDbCode;
    private String pdbxSubcomponentList;
    private String pdbxProcessingSite;
    private String monNstdFlag;

    private List<ChemCompDescriptor> descriptors = new ArrayList<>();
    private List<ChemCompBond> bonds = new ArrayList<>();
    private List<ChemCompAtom> atoms = new ArrayList<>();

    // and some derived data for easier processing...
    private ResidueType residueType;
    private PolymerType polymerType;
    private boolean standard;

    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer("ChemComp ");
        buf.append(id)
                .append(" ")
                .append(oneLetterCode)
                .append(" ")
                .append(threeLetterCode)
                .append(" poly:")
                .append(getPolymerType())
                .append(" resi:")
                .append(getResidueType())
                .append(isStandard() ? " standard" : " modified")
                .append(" ")
                .append(name)
                .append(" ")
                .append(pdbxType)
                .append(" ")
                .append(formula)
                .append(" parent:")
                .append(monNstdParentCompId);
        return buf.toString();
    }

    public boolean hasParent(){
        String pid = monNstdParentCompId;
        return (pid != null) && (!pid.equals("?"));
    }

    public boolean isStandard(){
        return standard;
    }

    private void setStandardFlag(){
        standard = ChemCompTools.isStandardChemComp(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        this.residueType = ResidueType.getResidueTypeFromString(type);
        if (residueType != null) {
            polymerType = residueType.polymerType;
        }
    }

    public ResidueType getResidueType() {
        return residueType;
    }

    public void setResidueType(ResidueType residueType) {
        this.residueType = residueType;
    }

    public PolymerType getPolymerType() {
        return polymerType;
    }

    public void setPolymerType(PolymerType polymerType) {
        this.polymerType = polymerType;
    }

    public String getPdbxType() {
        return pdbxType;
    }

    public void setPdbxType(String pdbxType) {
        this.pdbxType = pdbxType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getMonNstdParentCompId() {
        return monNstdParentCompId;
    }

    public void setMonNstdParentCompId(String monNstdParentCompId) {
        this.monNstdParentCompId = monNstdParentCompId;
        setStandardFlag();
    }

    public String getPdbxSynonyms() {
        return pdbxSynonyms;
    }

    public void setPdbxSynonyms(String pdbxSynonyms) {
        this.pdbxSynonyms = pdbxSynonyms;
    }

    public String getPdbxFormalCharge() {
        return pdbxFormalCharge;
    }

    public void setPdbxFormalCharge(String pdbxFormalCharge) {
        this.pdbxFormalCharge = pdbxFormalCharge;
    }

    public String getPdbxInitialDate() {
        return pdbxInitialDate;
    }

    public void setPdbxInitialDate(String pdbxInitialDate) {
        this.pdbxInitialDate = pdbxInitialDate;
    }

    public String getPdbxModifiedDate() {
        return pdbxModifiedDate;
    }

    public void setPdbxModifiedDate(String pdbxModifiedDate) {
        this.pdbxModifiedDate = pdbxModifiedDate;
    }

    public String getPdbxAmbiguousFlag() {
        return pdbxAmbiguousFlag;
    }

    public void setPdbxAmbiguousFlag(String pdbxAmbiguousFlag) {
        this.pdbxAmbiguousFlag = pdbxAmbiguousFlag;
    }

    public String getPdbxReleaseStatus() {
        return pdbxReleaseStatus;
    }

    public void setPdbxReleaseStatus(String pdbxReleaseStatus) {
        this.pdbxReleaseStatus = pdbxReleaseStatus;
    }

    public String getPdbxReplacedBy() {
        return pdbxReplacedBy;
    }

    public void setPdbxReplacedBy(String pdbxReplacedBy) {
        this.pdbxReplacedBy = pdbxReplacedBy;
    }

    public String getPdbxReplaces() {
        return pdbxReplaces;
    }

    public void setPdbxReplaces(String pdbxReplaces) {
        this.pdbxReplaces = pdbxReplaces;
    }

    public String getFormulaWeight() {
        return formulaWeight;
    }

    public void setFormulaWeight(String formulaWeight) {
        this.formulaWeight = formulaWeight;
    }

    public String getOneLetterCode() {
        return oneLetterCode;
    }

    public void setOneLetterCode(String oneLetterCode) {
        this.oneLetterCode = oneLetterCode;
        setStandardFlag();
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public void setThreeLetterCode(String threeLetterCode) {
        this.threeLetterCode = threeLetterCode;
    }

    public String getPdbxModelCoordinatesDetails() {
        return pdbxModelCoordinatesDetails;
    }

    public void setPdbxModelCoordinatesDetails(String pdbxModelCoordinatesDetails) {
        this.pdbxModelCoordinatesDetails = pdbxModelCoordinatesDetails;
    }

    public String getPdbxModelCoordinatesMissingFlag() {
        return pdbxModelCoordinatesMissingFlag;
    }

    public void setPdbxModelCoordinatesMissingFlag(String pdbxModelCoordinatesMissingFlag) {
        this.pdbxModelCoordinatesMissingFlag = pdbxModelCoordinatesMissingFlag;
    }

    public String getPdbxIdealCoordinatesDetails() {
        return pdbxIdealCoordinatesDetails;
    }

    public void setPdbxIdealCoordinatesDetails(String pdbxIdealCoordinatesDetails) {
        this.pdbxIdealCoordinatesDetails = pdbxIdealCoordinatesDetails;
    }

    public String getPdbxIdealCoordinatesMissingFlag() {
        return pdbxIdealCoordinatesMissingFlag;
    }

    public void setPdbxIdealCoordinatesMissingFlag(String pdbxIdealCoordinatesMissingFlag) {
        this.pdbxIdealCoordinatesMissingFlag = pdbxIdealCoordinatesMissingFlag;
    }

    public String getPdbxModelCoordinatesDbCode() {
        return pdbxModelCoordinatesDbCode;
    }

    public void setPdbxModelCoordinatesDbCode(String pdbxModelCoordinatesDbCode) {
        this.pdbxModelCoordinatesDbCode = pdbxModelCoordinatesDbCode;
    }

    public String getPdbxSubcomponentList() {
        return pdbxSubcomponentList;
    }

    public void setPdbxSubcomponentList(String pdbxSubcomponentList) {
        this.pdbxSubcomponentList = pdbxSubcomponentList;
    }

    public String getPdbxProcessingSite() {
        return pdbxProcessingSite;
    }

    public void setPdbxProcessingSite(String pdbxProcessingSite) {
        this.pdbxProcessingSite = pdbxProcessingSite;
    }

    public String getMonNstdFlag() {
        return monNstdFlag;
    }

    public void setMonNstdFlag(String monNstdFlag) {
        this.monNstdFlag = monNstdFlag;
    }

    public List<ChemCompDescriptor> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<ChemCompDescriptor> descriptors) {
        this.descriptors = descriptors;
    }

    public List<ChemCompBond> getBonds() {
        return bonds;
    }

    public void setBonds(List<ChemCompBond> bonds) {
        this.bonds = bonds;
    }

    public List<ChemCompAtom> getAtoms() {
        return atoms;
    }

    public void setAtoms(List<ChemCompAtom> atoms) {
        this.atoms = atoms;
    }

    @Override
    public int compareTo(ChemComp arg0) {
        if (this.equals(arg0))
            return 0;
        return this.getId().compareTo(arg0.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChemComp chemComp = (ChemComp) o;
        return standard == chemComp.standard &&
                Objects.equals(id, chemComp.id) &&
                Objects.equals(name, chemComp.name) &&
                Objects.equals(type, chemComp.type) &&
                Objects.equals(pdbxType, chemComp.pdbxType) &&
                Objects.equals(formula, chemComp.formula) &&
                Objects.equals(monNstdParentCompId, chemComp.monNstdParentCompId) &&
                Objects.equals(pdbxSynonyms, chemComp.pdbxSynonyms) &&
                Objects.equals(pdbxFormalCharge, chemComp.pdbxFormalCharge) &&
                Objects.equals(pdbxInitialDate, chemComp.pdbxInitialDate) &&
                Objects.equals(pdbxModifiedDate, chemComp.pdbxModifiedDate) &&
                Objects.equals(pdbxAmbiguousFlag, chemComp.pdbxAmbiguousFlag) &&
                Objects.equals(pdbxReleaseStatus, chemComp.pdbxReleaseStatus) &&
                Objects.equals(pdbxReplacedBy, chemComp.pdbxReplacedBy) &&
                Objects.equals(pdbxReplaces, chemComp.pdbxReplaces) &&
                Objects.equals(formulaWeight, chemComp.formulaWeight) &&
                Objects.equals(oneLetterCode, chemComp.oneLetterCode) &&
                Objects.equals(threeLetterCode, chemComp.threeLetterCode) &&
                Objects.equals(pdbxModelCoordinatesDetails, chemComp.pdbxModelCoordinatesDetails) &&
                Objects.equals(pdbxModelCoordinatesMissingFlag, chemComp.pdbxModelCoordinatesMissingFlag) &&
                Objects.equals(pdbxIdealCoordinatesDetails, chemComp.pdbxIdealCoordinatesDetails) &&
                Objects.equals(pdbxIdealCoordinatesMissingFlag, chemComp.pdbxIdealCoordinatesMissingFlag) &&
                Objects.equals(pdbxModelCoordinatesDbCode, chemComp.pdbxModelCoordinatesDbCode) &&
                Objects.equals(pdbxSubcomponentList, chemComp.pdbxSubcomponentList) &&
                Objects.equals(pdbxProcessingSite, chemComp.pdbxProcessingSite) &&
                Objects.equals(monNstdFlag, chemComp.monNstdFlag) &&
                Objects.equals(descriptors, chemComp.descriptors) &&
                Objects.equals(bonds, chemComp.bonds) &&
                Objects.equals(atoms, chemComp.atoms) &&
                residueType == chemComp.residueType &&
                polymerType == chemComp.polymerType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, pdbxType, formula, monNstdParentCompId, pdbxSynonyms, pdbxFormalCharge, pdbxInitialDate, pdbxModifiedDate, pdbxAmbiguousFlag, pdbxReleaseStatus, pdbxReplacedBy, pdbxReplaces, formulaWeight, oneLetterCode, threeLetterCode, pdbxModelCoordinatesDetails, pdbxModelCoordinatesMissingFlag, pdbxIdealCoordinatesDetails, pdbxIdealCoordinatesMissingFlag, pdbxModelCoordinatesDbCode, pdbxSubcomponentList, pdbxProcessingSite, monNstdFlag, descriptors, bonds, atoms, residueType, polymerType, standard);
    }

    /**
     * Creates a new instance of the dummy empty ChemComp.
     * @return a ChemComp
     */
    public static ChemComp getEmptyChemComp() {
        ChemComp comp = new ChemComp();

        comp.setOneLetterCode("?");
        comp.setThreeLetterCode("???"); // Main signal for isEmpty()
        comp.setPolymerType(PolymerType.unknown);
        comp.setResidueType(ResidueType.atomn);
        return comp;
    }

    /**
     * Indicates whether this compound was created with
     * @return a boolean
     */
    public boolean isEmpty() {
        // Is this the best flag for it being empty?
        return id == null || getThreeLetterCode() == null || getThreeLetterCode().equals("???");
    }
}
