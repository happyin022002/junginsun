/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CaSummaryReportInVO.java
*@FileTitle : CaSummaryReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.03.26 김경섭 
* 1.0 Creation
* 
* History
* 2010.12.29 진마리아  CHM-201007773-01 C/A Summary 화면 변경 (GSO Office 추가)
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaSummaryReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaSummaryReportInVO> models = new ArrayList<CaSummaryReportInVO>();
	
	/* Column Info */
	private String caReasonG = null;
	/* Column Info */
	private String caReasonC = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String caReasonO = null;
	/* Column Info */
	private String caReasonM = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String caReason = null;
	/* Column Info */
	private String caClass2 = null;
	/* Column Info */
	private String caClass3 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String contractOff = null;
	/* Column Info */
	private String caClass1 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String caKind = null;
	/* Column Info */
	private String corrFromDt = null;
	/* Column Info */
	private String corrToDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String offDisOp = null;
	/* Column Info */
	private String delOff = null;
	/* Column Info */
	private String creFromDt = null;
	/* Column Info */
	private String caIssueOff = null;
	/* Column Info */
	private String otherOp3 = null;
	/* Column Info */
	private String bkgOff = null;
	/* Column Info */
	private String otherOp1 = null;
	/* Column Info */
	private String otherOp2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String caKindA = null;
	/* Column Info */
	private String caClass = null;
	/* Column Info */
	private String caKindI = null;
	/* Column Info */
	private String caKindH = null;
	/* Column Info */
	private String caKindG = null;
	/* Column Info */
	private String caKindF = null;
	/* Column Info */
	private String caKindE = null;
	/* Column Info */
	private String caKindD = null;
	/* Column Info */
	private String caIssueStaff = null;
	/* Column Info */
	private String caKindC = null;
	/* Column Info */
	private String otherOp = null;
	/* Column Info */
	private String caKindB = null;
	/* Column Info */
	private String offDisOp6 = null;
	/* Column Info */
	private String offDisOp5 = null;
	/* Column Info */
	private String offDisOp4 = null;
	/* Column Info */
	private String part = null;
	/* Column Info */
	private String offDisOp3 = null;
	/* Column Info */
	private String dlvCtntCd = null;
	/* Column Info */
	private String offDisOp2 = null;
	/* Column Info */
	private String caReasonA = null;
	/* Column Info */
	private String caKindK = null;
	/* Column Info */
	private String offDisOp1 = null;
	/* Column Info */
	private String caKindJ = null;
	/* Column Info */
	private String gsoOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaSummaryReportInVO() {}

	public CaSummaryReportInVO(String ibflag, String pagerows, String corrFromDt, String corrToDt, String creFromDt, String creToDt, String vvd, String caReason, String caReasonM, String caReasonC, String caReasonG, String caReasonA, String caReasonO, String caClass, String caClass1, String caClass2, String caClass3, String caKind, String caKindA, String caKindB, String caKindC, String caKindD, String caKindE, String caKindF, String caKindG, String caKindH, String caKindI, String caKindJ, String caKindK, String caIssueOff, String bkgOff, String delOff, String part, String contractOff, String caIssueStaff, String offDisOp, String offDisOp1, String offDisOp2, String offDisOp3, String offDisOp4, String offDisOp5, String offDisOp6, String por, String pol, String pod, String del, String otherOp, String otherOp1, String otherOp2, String otherOp3, String dlvCtntCd, String gsoOfcCd) {
		this.caReasonG = caReasonG;
		this.caReasonC = caReasonC;
		this.por = por;
		this.caReasonO = caReasonO;
		this.caReasonM = caReasonM;
		this.pagerows = pagerows;
		this.caReason = caReason;
		this.caClass2 = caClass2;
		this.caClass3 = caClass3;
		this.pol = pol;
		this.contractOff = contractOff;
		this.caClass1 = caClass1;
		this.pod = pod;
		this.caKind = caKind;
		this.corrFromDt = corrFromDt;
		this.corrToDt = corrToDt;
		this.vvd = vvd;
		this.offDisOp = offDisOp;
		this.delOff = delOff;
		this.creFromDt = creFromDt;
		this.caIssueOff = caIssueOff;
		this.otherOp3 = otherOp3;
		this.bkgOff = bkgOff;
		this.otherOp1 = otherOp1;
		this.otherOp2 = otherOp2;
		this.ibflag = ibflag;
		this.del = del;
		this.creToDt = creToDt;
		this.caKindA = caKindA;
		this.caClass = caClass;
		this.caKindI = caKindI;
		this.caKindH = caKindH;
		this.caKindG = caKindG;
		this.caKindF = caKindF;
		this.caKindE = caKindE;
		this.caKindD = caKindD;
		this.caIssueStaff = caIssueStaff;
		this.caKindC = caKindC;
		this.otherOp = otherOp;
		this.caKindB = caKindB;
		this.offDisOp6 = offDisOp6;
		this.offDisOp5 = offDisOp5;
		this.offDisOp4 = offDisOp4;
		this.part = part;
		this.offDisOp3 = offDisOp3;
		this.dlvCtntCd = dlvCtntCd;
		this.offDisOp2 = offDisOp2;
		this.caReasonA = caReasonA;
		this.caKindK = caKindK;
		this.offDisOp1 = offDisOp1;
		this.caKindJ = caKindJ;
		this.gsoOfcCd = gsoOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ca_reason_g", getCaReasonG());
		this.hashColumns.put("ca_reason_c", getCaReasonC());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("ca_reason_o", getCaReasonO());
		this.hashColumns.put("ca_reason_m", getCaReasonM());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ca_reason", getCaReason());
		this.hashColumns.put("ca_class_2", getCaClass2());
		this.hashColumns.put("ca_class_3", getCaClass3());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("contract_off", getContractOff());
		this.hashColumns.put("ca_class_1", getCaClass1());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("ca_kind", getCaKind());
		this.hashColumns.put("corr_from_dt", getCorrFromDt());
		this.hashColumns.put("corr_to_dt", getCorrToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("off_dis_op", getOffDisOp());
		this.hashColumns.put("del_off", getDelOff());
		this.hashColumns.put("cre_from_dt", getCreFromDt());
		this.hashColumns.put("ca_issue_off", getCaIssueOff());
		this.hashColumns.put("other_op_3", getOtherOp3());
		this.hashColumns.put("bkg_off", getBkgOff());
		this.hashColumns.put("other_op_1", getOtherOp1());
		this.hashColumns.put("other_op_2", getOtherOp2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("ca_kind_a", getCaKindA());
		this.hashColumns.put("ca_class", getCaClass());
		this.hashColumns.put("ca_kind_i", getCaKindI());
		this.hashColumns.put("ca_kind_h", getCaKindH());
		this.hashColumns.put("ca_kind_g", getCaKindG());
		this.hashColumns.put("ca_kind_f", getCaKindF());
		this.hashColumns.put("ca_kind_e", getCaKindE());
		this.hashColumns.put("ca_kind_d", getCaKindD());
		this.hashColumns.put("ca_issue_staff", getCaIssueStaff());
		this.hashColumns.put("ca_kind_c", getCaKindC());
		this.hashColumns.put("other_op", getOtherOp());
		this.hashColumns.put("ca_kind_b", getCaKindB());
		this.hashColumns.put("off_dis_op_6", getOffDisOp6());
		this.hashColumns.put("off_dis_op_5", getOffDisOp5());
		this.hashColumns.put("off_dis_op_4", getOffDisOp4());
		this.hashColumns.put("part", getPart());
		this.hashColumns.put("off_dis_op_3", getOffDisOp3());
		this.hashColumns.put("dlv_ctnt_cd", getDlvCtntCd());
		this.hashColumns.put("off_dis_op_2", getOffDisOp2());
		this.hashColumns.put("ca_reason_a", getCaReasonA());
		this.hashColumns.put("ca_kind_k", getCaKindK());
		this.hashColumns.put("off_dis_op_1", getOffDisOp1());
		this.hashColumns.put("ca_kind_j", getCaKindJ());
		this.hashColumns.put("gso_ofc_cd", getGsoOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ca_reason_g", "caReasonG");
		this.hashFields.put("ca_reason_c", "caReasonC");
		this.hashFields.put("por", "por");
		this.hashFields.put("ca_reason_o", "caReasonO");
		this.hashFields.put("ca_reason_m", "caReasonM");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ca_reason", "caReason");
		this.hashFields.put("ca_class_2", "caClass2");
		this.hashFields.put("ca_class_3", "caClass3");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("contract_off", "contractOff");
		this.hashFields.put("ca_class_1", "caClass1");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("ca_kind", "caKind");
		this.hashFields.put("corr_from_dt", "corrFromDt");
		this.hashFields.put("corr_to_dt", "corrToDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("off_dis_op", "offDisOp");
		this.hashFields.put("del_off", "delOff");
		this.hashFields.put("cre_from_dt", "creFromDt");
		this.hashFields.put("ca_issue_off", "caIssueOff");
		this.hashFields.put("other_op_3", "otherOp3");
		this.hashFields.put("bkg_off", "bkgOff");
		this.hashFields.put("other_op_1", "otherOp1");
		this.hashFields.put("other_op_2", "otherOp2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del", "del");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("ca_kind_a", "caKindA");
		this.hashFields.put("ca_class", "caClass");
		this.hashFields.put("ca_kind_i", "caKindI");
		this.hashFields.put("ca_kind_h", "caKindH");
		this.hashFields.put("ca_kind_g", "caKindG");
		this.hashFields.put("ca_kind_f", "caKindF");
		this.hashFields.put("ca_kind_e", "caKindE");
		this.hashFields.put("ca_kind_d", "caKindD");
		this.hashFields.put("ca_issue_staff", "caIssueStaff");
		this.hashFields.put("ca_kind_c", "caKindC");
		this.hashFields.put("other_op", "otherOp");
		this.hashFields.put("ca_kind_b", "caKindB");
		this.hashFields.put("off_dis_op_6", "offDisOp6");
		this.hashFields.put("off_dis_op_5", "offDisOp5");
		this.hashFields.put("off_dis_op_4", "offDisOp4");
		this.hashFields.put("part", "part");
		this.hashFields.put("off_dis_op_3", "offDisOp3");
		this.hashFields.put("dlv_ctnt_cd", "dlvCtntCd");
		this.hashFields.put("off_dis_op_2", "offDisOp2");
		this.hashFields.put("ca_reason_a", "caReasonA");
		this.hashFields.put("ca_kind_k", "caKindK");
		this.hashFields.put("off_dis_op_1", "offDisOp1");
		this.hashFields.put("ca_kind_j", "caKindJ");
		this.hashFields.put("gso_ofc_cd", "gsoOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return caReasonG
	 */
	public String getCaReasonG() {
		return this.caReasonG;
	}
	
	/**
	 * Column Info
	 * @return caReasonC
	 */
	public String getCaReasonC() {
		return this.caReasonC;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return caReasonO
	 */
	public String getCaReasonO() {
		return this.caReasonO;
	}
	
	/**
	 * Column Info
	 * @return caReasonM
	 */
	public String getCaReasonM() {
		return this.caReasonM;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return caReason
	 */
	public String getCaReason() {
		return this.caReason;
	}
	
	/**
	 * Column Info
	 * @return caClass2
	 */
	public String getCaClass2() {
		return this.caClass2;
	}
	
	/**
	 * Column Info
	 * @return caClass3
	 */
	public String getCaClass3() {
		return this.caClass3;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return contractOff
	 */
	public String getContractOff() {
		return this.contractOff;
	}
	
	/**
	 * Column Info
	 * @return caClass1
	 */
	public String getCaClass1() {
		return this.caClass1;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return caKind
	 */
	public String getCaKind() {
		return this.caKind;
	}
	
	/**
	 * Column Info
	 * @return corrFromDt
	 */
	public String getCorrFromDt() {
		return this.corrFromDt;
	}
	
	/**
	 * Column Info
	 * @return corrToDt
	 */
	public String getCorrToDt() {
		return this.corrToDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return offDisOp
	 */
	public String getOffDisOp() {
		return this.offDisOp;
	}
	
	/**
	 * Column Info
	 * @return delOff
	 */
	public String getDelOff() {
		return this.delOff;
	}
	
	/**
	 * Column Info
	 * @return creFromDt
	 */
	public String getCreFromDt() {
		return this.creFromDt;
	}
	
	/**
	 * Column Info
	 * @return caIssueOff
	 */
	public String getCaIssueOff() {
		return this.caIssueOff;
	}
	
	/**
	 * Column Info
	 * @return otherOp3
	 */
	public String getOtherOp3() {
		return this.otherOp3;
	}
	
	/**
	 * Column Info
	 * @return bkgOff
	 */
	public String getBkgOff() {
		return this.bkgOff;
	}
	
	/**
	 * Column Info
	 * @return otherOp1
	 */
	public String getOtherOp1() {
		return this.otherOp1;
	}
	
	/**
	 * Column Info
	 * @return otherOp2
	 */
	public String getOtherOp2() {
		return this.otherOp2;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
	}
	
	/**
	 * Column Info
	 * @return caKindA
	 */
	public String getCaKindA() {
		return this.caKindA;
	}
	
	/**
	 * Column Info
	 * @return caClass
	 */
	public String getCaClass() {
		return this.caClass;
	}
	
	/**
	 * Column Info
	 * @return caKindI
	 */
	public String getCaKindI() {
		return this.caKindI;
	}
	
	/**
	 * Column Info
	 * @return caKindH
	 */
	public String getCaKindH() {
		return this.caKindH;
	}
	
	/**
	 * Column Info
	 * @return caKindG
	 */
	public String getCaKindG() {
		return this.caKindG;
	}
	
	/**
	 * Column Info
	 * @return caKindF
	 */
	public String getCaKindF() {
		return this.caKindF;
	}
	
	/**
	 * Column Info
	 * @return caKindE
	 */
	public String getCaKindE() {
		return this.caKindE;
	}
	
	/**
	 * Column Info
	 * @return caKindD
	 */
	public String getCaKindD() {
		return this.caKindD;
	}
	
	/**
	 * Column Info
	 * @return caIssueStaff
	 */
	public String getCaIssueStaff() {
		return this.caIssueStaff;
	}
	
	/**
	 * Column Info
	 * @return caKindC
	 */
	public String getCaKindC() {
		return this.caKindC;
	}
	
	/**
	 * Column Info
	 * @return otherOp
	 */
	public String getOtherOp() {
		return this.otherOp;
	}
	
	/**
	 * Column Info
	 * @return caKindB
	 */
	public String getCaKindB() {
		return this.caKindB;
	}
	
	/**
	 * Column Info
	 * @return offDisOp6
	 */
	public String getOffDisOp6() {
		return this.offDisOp6;
	}
	
	/**
	 * Column Info
	 * @return offDisOp5
	 */
	public String getOffDisOp5() {
		return this.offDisOp5;
	}
	
	/**
	 * Column Info
	 * @return offDisOp4
	 */
	public String getOffDisOp4() {
		return this.offDisOp4;
	}
	
	/**
	 * Column Info
	 * @return part
	 */
	public String getPart() {
		return this.part;
	}
	
	/**
	 * Column Info
	 * @return offDisOp3
	 */
	public String getOffDisOp3() {
		return this.offDisOp3;
	}
	
	/**
	 * Column Info
	 * @return dlvCtntCd
	 */
	public String getDlvCtntCd() {
		return this.dlvCtntCd;
	}
	
	/**
	 * Column Info
	 * @return offDisOp2
	 */
	public String getOffDisOp2() {
		return this.offDisOp2;
	}
	
	/**
	 * Column Info
	 * @return caReasonA
	 */
	public String getCaReasonA() {
		return this.caReasonA;
	}
	
	/**
	 * Column Info
	 * @return caKindK
	 */
	public String getCaKindK() {
		return this.caKindK;
	}
	
	/**
	 * Column Info
	 * @return offDisOp1
	 */
	public String getOffDisOp1() {
		return this.offDisOp1;
	}
	
	/**
	 * Column Info
	 * @return caKindJ
	 */
	public String getCaKindJ() {
		return this.caKindJ;
	}
	
	/**
	 * Column Info
	 * @return gsoOfcCd
	 */
	public String getGsoOfcCd() {
		return this.gsoOfcCd;
	}
	

	/**
	 * Column Info
	 * @param caReasonG
	 */
	public void setCaReasonG(String caReasonG) {
		this.caReasonG = caReasonG;
	}
	
	/**
	 * Column Info
	 * @param caReasonC
	 */
	public void setCaReasonC(String caReasonC) {
		this.caReasonC = caReasonC;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param caReasonO
	 */
	public void setCaReasonO(String caReasonO) {
		this.caReasonO = caReasonO;
	}
	
	/**
	 * Column Info
	 * @param caReasonM
	 */
	public void setCaReasonM(String caReasonM) {
		this.caReasonM = caReasonM;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param caReason
	 */
	public void setCaReason(String caReason) {
		this.caReason = caReason;
	}
	
	/**
	 * Column Info
	 * @param caClass2
	 */
	public void setCaClass2(String caClass2) {
		this.caClass2 = caClass2;
	}
	
	/**
	 * Column Info
	 * @param caClass3
	 */
	public void setCaClass3(String caClass3) {
		this.caClass3 = caClass3;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param contractOff
	 */
	public void setContractOff(String contractOff) {
		this.contractOff = contractOff;
	}
	
	/**
	 * Column Info
	 * @param caClass1
	 */
	public void setCaClass1(String caClass1) {
		this.caClass1 = caClass1;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param caKind
	 */
	public void setCaKind(String caKind) {
		this.caKind = caKind;
	}
	
	/**
	 * Column Info
	 * @param corrFromDt
	 */
	public void setCorrFromDt(String corrFromDt) {
		this.corrFromDt = corrFromDt;
	}
	
	/**
	 * Column Info
	 * @param corrToDt
	 */
	public void setCorrToDt(String corrToDt) {
		this.corrToDt = corrToDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param offDisOp
	 */
	public void setOffDisOp(String offDisOp) {
		this.offDisOp = offDisOp;
	}
	
	/**
	 * Column Info
	 * @param delOff
	 */
	public void setDelOff(String delOff) {
		this.delOff = delOff;
	}
	
	/**
	 * Column Info
	 * @param creFromDt
	 */
	public void setCreFromDt(String creFromDt) {
		this.creFromDt = creFromDt;
	}
	
	/**
	 * Column Info
	 * @param caIssueOff
	 */
	public void setCaIssueOff(String caIssueOff) {
		this.caIssueOff = caIssueOff;
	}
	
	/**
	 * Column Info
	 * @param otherOp3
	 */
	public void setOtherOp3(String otherOp3) {
		this.otherOp3 = otherOp3;
	}
	
	/**
	 * Column Info
	 * @param bkgOff
	 */
	public void setBkgOff(String bkgOff) {
		this.bkgOff = bkgOff;
	}
	
	/**
	 * Column Info
	 * @param otherOp1
	 */
	public void setOtherOp1(String otherOp1) {
		this.otherOp1 = otherOp1;
	}
	
	/**
	 * Column Info
	 * @param otherOp2
	 */
	public void setOtherOp2(String otherOp2) {
		this.otherOp2 = otherOp2;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
	}
	
	/**
	 * Column Info
	 * @param caKindA
	 */
	public void setCaKindA(String caKindA) {
		this.caKindA = caKindA;
	}
	
	/**
	 * Column Info
	 * @param caClass
	 */
	public void setCaClass(String caClass) {
		this.caClass = caClass;
	}
	
	/**
	 * Column Info
	 * @param caKindI
	 */
	public void setCaKindI(String caKindI) {
		this.caKindI = caKindI;
	}
	
	/**
	 * Column Info
	 * @param caKindH
	 */
	public void setCaKindH(String caKindH) {
		this.caKindH = caKindH;
	}
	
	/**
	 * Column Info
	 * @param caKindG
	 */
	public void setCaKindG(String caKindG) {
		this.caKindG = caKindG;
	}
	
	/**
	 * Column Info
	 * @param caKindF
	 */
	public void setCaKindF(String caKindF) {
		this.caKindF = caKindF;
	}
	
	/**
	 * Column Info
	 * @param caKindE
	 */
	public void setCaKindE(String caKindE) {
		this.caKindE = caKindE;
	}
	
	/**
	 * Column Info
	 * @param caKindD
	 */
	public void setCaKindD(String caKindD) {
		this.caKindD = caKindD;
	}
	
	/**
	 * Column Info
	 * @param caIssueStaff
	 */
	public void setCaIssueStaff(String caIssueStaff) {
		this.caIssueStaff = caIssueStaff;
	}
	
	/**
	 * Column Info
	 * @param caKindC
	 */
	public void setCaKindC(String caKindC) {
		this.caKindC = caKindC;
	}
	
	/**
	 * Column Info
	 * @param otherOp
	 */
	public void setOtherOp(String otherOp) {
		this.otherOp = otherOp;
	}
	
	/**
	 * Column Info
	 * @param caKindB
	 */
	public void setCaKindB(String caKindB) {
		this.caKindB = caKindB;
	}
	
	/**
	 * Column Info
	 * @param offDisOp6
	 */
	public void setOffDisOp6(String offDisOp6) {
		this.offDisOp6 = offDisOp6;
	}
	
	/**
	 * Column Info
	 * @param offDisOp5
	 */
	public void setOffDisOp5(String offDisOp5) {
		this.offDisOp5 = offDisOp5;
	}
	
	/**
	 * Column Info
	 * @param offDisOp4
	 */
	public void setOffDisOp4(String offDisOp4) {
		this.offDisOp4 = offDisOp4;
	}
	
	/**
	 * Column Info
	 * @param part
	 */
	public void setPart(String part) {
		this.part = part;
	}
	
	/**
	 * Column Info
	 * @param offDisOp3
	 */
	public void setOffDisOp3(String offDisOp3) {
		this.offDisOp3 = offDisOp3;
	}
	
	/**
	 * Column Info
	 * @param dlvCtntCd
	 */
	public void setDlvCtntCd(String dlvCtntCd) {
		this.dlvCtntCd = dlvCtntCd;
	}
	
	/**
	 * Column Info
	 * @param offDisOp2
	 */
	public void setOffDisOp2(String offDisOp2) {
		this.offDisOp2 = offDisOp2;
	}
	
	/**
	 * Column Info
	 * @param caReasonA
	 */
	public void setCaReasonA(String caReasonA) {
		this.caReasonA = caReasonA;
	}
	
	/**
	 * Column Info
	 * @param caKindK
	 */
	public void setCaKindK(String caKindK) {
		this.caKindK = caKindK;
	}
	
	/**
	 * Column Info
	 * @param offDisOp1
	 */
	public void setOffDisOp1(String offDisOp1) {
		this.offDisOp1 = offDisOp1;
	}
	
	/**
	 * Column Info
	 * @param caKindJ
	 */
	public void setCaKindJ(String caKindJ) {
		this.caKindJ = caKindJ;
	}
	
	/**
	 * Column Info
	 * @param gsoOfcCd
	 */
	public void setGsoOfcCd(String gsoOfcCd) {
		this.gsoOfcCd = gsoOfcCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCaReasonG(JSPUtil.getParameter(request, prefix + "ca_reason_g", ""));
		setCaReasonC(JSPUtil.getParameter(request, prefix + "ca_reason_c", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setCaReasonO(JSPUtil.getParameter(request, prefix + "ca_reason_o", ""));
		setCaReasonM(JSPUtil.getParameter(request, prefix + "ca_reason_m", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCaReason(JSPUtil.getParameter(request, prefix + "ca_reason", ""));
		setCaClass2(JSPUtil.getParameter(request, prefix + "ca_class_2", ""));
		setCaClass3(JSPUtil.getParameter(request, prefix + "ca_class_3", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setContractOff(JSPUtil.getParameter(request, prefix + "contract_off", ""));
		setCaClass1(JSPUtil.getParameter(request, prefix + "ca_class_1", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCaKind(JSPUtil.getParameter(request, prefix + "ca_kind", ""));
		setCorrFromDt(JSPUtil.getParameter(request, prefix + "corr_from_dt", ""));
		setCorrToDt(JSPUtil.getParameter(request, prefix + "corr_to_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOffDisOp(JSPUtil.getParameter(request, prefix + "off_dis_op", ""));
		setDelOff(JSPUtil.getParameter(request, prefix + "del_off", ""));
		setCreFromDt(JSPUtil.getParameter(request, prefix + "cre_from_dt", ""));
		setCaIssueOff(JSPUtil.getParameter(request, prefix + "ca_issue_off", ""));
		setOtherOp3(JSPUtil.getParameter(request, prefix + "other_op_3", ""));
		setBkgOff(JSPUtil.getParameter(request, prefix + "bkg_off", ""));
		setOtherOp1(JSPUtil.getParameter(request, prefix + "other_op_1", ""));
		setOtherOp2(JSPUtil.getParameter(request, prefix + "other_op_2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setCreToDt(JSPUtil.getParameter(request, prefix + "cre_to_dt", ""));
		setCaKindA(JSPUtil.getParameter(request, prefix + "ca_kind_a", ""));
		setCaClass(JSPUtil.getParameter(request, prefix + "ca_class", ""));
		setCaKindI(JSPUtil.getParameter(request, prefix + "ca_kind_i", ""));
		setCaKindH(JSPUtil.getParameter(request, prefix + "ca_kind_h", ""));
		setCaKindG(JSPUtil.getParameter(request, prefix + "ca_kind_g", ""));
		setCaKindF(JSPUtil.getParameter(request, prefix + "ca_kind_f", ""));
		setCaKindE(JSPUtil.getParameter(request, prefix + "ca_kind_e", ""));
		setCaKindD(JSPUtil.getParameter(request, prefix + "ca_kind_d", ""));
		setCaIssueStaff(JSPUtil.getParameter(request, prefix + "ca_issue_staff", ""));
		setCaKindC(JSPUtil.getParameter(request, prefix + "ca_kind_c", ""));
		setOtherOp(JSPUtil.getParameter(request, prefix + "other_op", ""));
		setCaKindB(JSPUtil.getParameter(request, prefix + "ca_kind_b", ""));
		setOffDisOp6(JSPUtil.getParameter(request, prefix + "off_dis_op_6", ""));
		setOffDisOp5(JSPUtil.getParameter(request, prefix + "off_dis_op_5", ""));
		setOffDisOp4(JSPUtil.getParameter(request, prefix + "off_dis_op_4", ""));
		setPart(JSPUtil.getParameter(request, prefix + "part", ""));
		setOffDisOp3(JSPUtil.getParameter(request, prefix + "off_dis_op_3", ""));
		setDlvCtntCd(JSPUtil.getParameter(request, prefix + "dlv_ctnt_cd", ""));
		setOffDisOp2(JSPUtil.getParameter(request, prefix + "off_dis_op_2", ""));
		setCaReasonA(JSPUtil.getParameter(request, prefix + "ca_reason_a", ""));
		setCaKindK(JSPUtil.getParameter(request, prefix + "ca_kind_k", ""));
		setOffDisOp1(JSPUtil.getParameter(request, prefix + "off_dis_op_1", ""));
		setCaKindJ(JSPUtil.getParameter(request, prefix + "ca_kind_j", ""));
		setGsoOfcCd(JSPUtil.getParameter(request, prefix + "gso_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaSummaryReportInVO[]
	 */
	public CaSummaryReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaSummaryReportInVO[]
	 */
	public CaSummaryReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaSummaryReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] caReasonG = (JSPUtil.getParameter(request, prefix	+ "ca_reason_g", length));
			String[] caReasonC = (JSPUtil.getParameter(request, prefix	+ "ca_reason_c", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] caReasonO = (JSPUtil.getParameter(request, prefix	+ "ca_reason_o", length));
			String[] caReasonM = (JSPUtil.getParameter(request, prefix	+ "ca_reason_m", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] caReason = (JSPUtil.getParameter(request, prefix	+ "ca_reason", length));
			String[] caClass2 = (JSPUtil.getParameter(request, prefix	+ "ca_class_2", length));
			String[] caClass3 = (JSPUtil.getParameter(request, prefix	+ "ca_class_3", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] contractOff = (JSPUtil.getParameter(request, prefix	+ "contract_off", length));
			String[] caClass1 = (JSPUtil.getParameter(request, prefix	+ "ca_class_1", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] caKind = (JSPUtil.getParameter(request, prefix	+ "ca_kind", length));
			String[] corrFromDt = (JSPUtil.getParameter(request, prefix	+ "corr_from_dt", length));
			String[] corrToDt = (JSPUtil.getParameter(request, prefix	+ "corr_to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] offDisOp = (JSPUtil.getParameter(request, prefix	+ "off_dis_op", length));
			String[] delOff = (JSPUtil.getParameter(request, prefix	+ "del_off", length));
			String[] creFromDt = (JSPUtil.getParameter(request, prefix	+ "cre_from_dt", length));
			String[] caIssueOff = (JSPUtil.getParameter(request, prefix	+ "ca_issue_off", length));
			String[] otherOp3 = (JSPUtil.getParameter(request, prefix	+ "other_op_3", length));
			String[] bkgOff = (JSPUtil.getParameter(request, prefix	+ "bkg_off", length));
			String[] otherOp1 = (JSPUtil.getParameter(request, prefix	+ "other_op_1", length));
			String[] otherOp2 = (JSPUtil.getParameter(request, prefix	+ "other_op_2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] caKindA = (JSPUtil.getParameter(request, prefix	+ "ca_kind_a", length));
			String[] caClass = (JSPUtil.getParameter(request, prefix	+ "ca_class", length));
			String[] caKindI = (JSPUtil.getParameter(request, prefix	+ "ca_kind_i", length));
			String[] caKindH = (JSPUtil.getParameter(request, prefix	+ "ca_kind_h", length));
			String[] caKindG = (JSPUtil.getParameter(request, prefix	+ "ca_kind_g", length));
			String[] caKindF = (JSPUtil.getParameter(request, prefix	+ "ca_kind_f", length));
			String[] caKindE = (JSPUtil.getParameter(request, prefix	+ "ca_kind_e", length));
			String[] caKindD = (JSPUtil.getParameter(request, prefix	+ "ca_kind_d", length));
			String[] caIssueStaff = (JSPUtil.getParameter(request, prefix	+ "ca_issue_staff", length));
			String[] caKindC = (JSPUtil.getParameter(request, prefix	+ "ca_kind_c", length));
			String[] otherOp = (JSPUtil.getParameter(request, prefix	+ "other_op", length));
			String[] caKindB = (JSPUtil.getParameter(request, prefix	+ "ca_kind_b", length));
			String[] offDisOp6 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_6", length));
			String[] offDisOp5 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_5", length));
			String[] offDisOp4 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_4", length));
			String[] part = (JSPUtil.getParameter(request, prefix	+ "part", length));
			String[] offDisOp3 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_3", length));
			String[] dlvCtntCd = (JSPUtil.getParameter(request, prefix	+ "dlv_ctnt_cd", length));
			String[] offDisOp2 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_2", length));
			String[] caReasonA = (JSPUtil.getParameter(request, prefix	+ "ca_reason_a", length));
			String[] caKindK = (JSPUtil.getParameter(request, prefix	+ "ca_kind_k", length));
			String[] offDisOp1 = (JSPUtil.getParameter(request, prefix	+ "off_dis_op_1", length));
			String[] caKindJ = (JSPUtil.getParameter(request, prefix	+ "ca_kind_j", length));
			String[] gsoOfcCd = (JSPUtil.getParameter(request, prefix	+ "gso_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaSummaryReportInVO();
				if (caReasonG[i] != null)
					model.setCaReasonG(caReasonG[i]);
				if (caReasonC[i] != null)
					model.setCaReasonC(caReasonC[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (caReasonO[i] != null)
					model.setCaReasonO(caReasonO[i]);
				if (caReasonM[i] != null)
					model.setCaReasonM(caReasonM[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (caReason[i] != null)
					model.setCaReason(caReason[i]);
				if (caClass2[i] != null)
					model.setCaClass2(caClass2[i]);
				if (caClass3[i] != null)
					model.setCaClass3(caClass3[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (contractOff[i] != null)
					model.setContractOff(contractOff[i]);
				if (caClass1[i] != null)
					model.setCaClass1(caClass1[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (caKind[i] != null)
					model.setCaKind(caKind[i]);
				if (corrFromDt[i] != null)
					model.setCorrFromDt(corrFromDt[i]);
				if (corrToDt[i] != null)
					model.setCorrToDt(corrToDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (offDisOp[i] != null)
					model.setOffDisOp(offDisOp[i]);
				if (delOff[i] != null)
					model.setDelOff(delOff[i]);
				if (creFromDt[i] != null)
					model.setCreFromDt(creFromDt[i]);
				if (caIssueOff[i] != null)
					model.setCaIssueOff(caIssueOff[i]);
				if (otherOp3[i] != null)
					model.setOtherOp3(otherOp3[i]);
				if (bkgOff[i] != null)
					model.setBkgOff(bkgOff[i]);
				if (otherOp1[i] != null)
					model.setOtherOp1(otherOp1[i]);
				if (otherOp2[i] != null)
					model.setOtherOp2(otherOp2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (caKindA[i] != null)
					model.setCaKindA(caKindA[i]);
				if (caClass[i] != null)
					model.setCaClass(caClass[i]);
				if (caKindI[i] != null)
					model.setCaKindI(caKindI[i]);
				if (caKindH[i] != null)
					model.setCaKindH(caKindH[i]);
				if (caKindG[i] != null)
					model.setCaKindG(caKindG[i]);
				if (caKindF[i] != null)
					model.setCaKindF(caKindF[i]);
				if (caKindE[i] != null)
					model.setCaKindE(caKindE[i]);
				if (caKindD[i] != null)
					model.setCaKindD(caKindD[i]);
				if (caIssueStaff[i] != null)
					model.setCaIssueStaff(caIssueStaff[i]);
				if (caKindC[i] != null)
					model.setCaKindC(caKindC[i]);
				if (otherOp[i] != null)
					model.setOtherOp(otherOp[i]);
				if (caKindB[i] != null)
					model.setCaKindB(caKindB[i]);
				if (offDisOp6[i] != null)
					model.setOffDisOp6(offDisOp6[i]);
				if (offDisOp5[i] != null)
					model.setOffDisOp5(offDisOp5[i]);
				if (offDisOp4[i] != null)
					model.setOffDisOp4(offDisOp4[i]);
				if (part[i] != null)
					model.setPart(part[i]);
				if (offDisOp3[i] != null)
					model.setOffDisOp3(offDisOp3[i]);
				if (dlvCtntCd[i] != null)
					model.setDlvCtntCd(dlvCtntCd[i]);
				if (offDisOp2[i] != null)
					model.setOffDisOp2(offDisOp2[i]);
				if (caReasonA[i] != null)
					model.setCaReasonA(caReasonA[i]);
				if (caKindK[i] != null)
					model.setCaKindK(caKindK[i]);
				if (offDisOp1[i] != null)
					model.setOffDisOp1(offDisOp1[i]);
				if (caKindJ[i] != null)
					model.setCaKindJ(caKindJ[i]);
				if (gsoOfcCd[i] != null)
					model.setGsoOfcCd(gsoOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaSummaryReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaSummaryReportInVO[]
	 */
	public CaSummaryReportInVO[] getCaSummaryReportInVOs(){
		CaSummaryReportInVO[] vos = (CaSummaryReportInVO[])models.toArray(new CaSummaryReportInVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.caReasonG = this.caReasonG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caReasonC = this.caReasonC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caReasonO = this.caReasonO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caReasonM = this.caReasonM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caReason = this.caReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caClass2 = this.caClass2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caClass3 = this.caClass3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractOff = this.contractOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caClass1 = this.caClass1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKind = this.caKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrFromDt = this.corrFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrToDt = this.corrToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp = this.offDisOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOff = this.delOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFromDt = this.creFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caIssueOff = this.caIssueOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherOp3 = this.otherOp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOff = this.bkgOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherOp1 = this.otherOp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherOp2 = this.otherOp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindA = this.caKindA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caClass = this.caClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindI = this.caKindI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindH = this.caKindH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindG = this.caKindG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindF = this.caKindF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindE = this.caKindE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindD = this.caKindD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caIssueStaff = this.caIssueStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindC = this.caKindC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherOp = this.otherOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindB = this.caKindB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp6 = this.offDisOp6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp5 = this.offDisOp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp4 = this.offDisOp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.part = this.part .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp3 = this.offDisOp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvCtntCd = this.dlvCtntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp2 = this.offDisOp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caReasonA = this.caReasonA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindK = this.caKindK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDisOp1 = this.offDisOp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKindJ = this.caKindJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gsoOfcCd = this.gsoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
