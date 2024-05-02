/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaAmsReportListCondVO.java
*@FileTitle : UsaAmsReportListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.19 김민정 
* 1.0 Creation
* 
* 2011.11.15 민정호 [CHM-201114280] AMS Report 조회 기능 변경
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaAmsReportListCondVO extends AmsReportListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaAmsReportListCondVO> models = new ArrayList<UsaAmsReportListCondVO>();
	
	/* Column Info */
	private String tod = null;
	/* Column Info */
	private String endNo = null;
	/* Column Info */
	private String fromd = null;
	/* Column Info */
	private String customsResultCode = null;
	/* Column Info */
	private String generalOrRail = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String fromt = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String startNo = null;
	/* Column Info */
	private String dateSearch = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lastBl = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String pmibTp = null;
	/* Column Info */
	private String bStf = null;
	/* Column Info */
	private String lastPol = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String custArrExp = null;
	/* Column Info */
	private String eqOfc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String amsFileNo = null;
	/* Column Info */
	private String exclRls = null;
	/* Column Info */
	private String lastRnum = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp4 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String tmp5 = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String customsResultCodeGrp = null;
	/* Column Info */
	private String lRep = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String customerCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rbillingYn = null;
	/* Column Info */
	private String del = null;
	private String rhq = null;
	private String finalFlg = null;
	/* Column Info */
	private String contractType = null;
	/* Column Info */
	private String errType = null;	
	/* Column Info */
	private String searchDiscrepancy = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaAmsReportListCondVO() {}

	public UsaAmsReportListCondVO(String ibflag, String pagerows, String vvd, String lastPol, String pol, String pod, String hub, String eqOfc, String bStf, String lRep, String rcvTermCd, String deTermCd, String pmibTp, String filer, String customsResultCodeGrp, String customsResultCode, String custArrExp, String fromd, String tod, String fromt, String tot, String mblNo, String amsFileNo, String pgmNo, String dateSearch, String generalOrRail, String tmp1, String tmp2, String tmp3, String tmp4, String tmp5, String startNo, String endNo, String pageNo, String exclRls, String lastBl, String lastRnum, String cntrPrtFlg, String rhq, String finalFlg, String customerCd, String scNo, String cntrTp, String cntrNo, String rbillingYn, String del, String contractType , String errType, String searchDiscrepancy) {
		this.tod = tod;
		this.endNo = endNo;
		this.fromd = fromd;
		this.customsResultCode = customsResultCode;
		this.generalOrRail = generalOrRail;
		this.hub = hub;
		this.fromt = fromt;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.startNo = startNo;
		this.dateSearch = dateSearch;
		this.ibflag = ibflag;
		this.lastBl = lastBl;
		this.tot = tot;
		this.pmibTp = pmibTp;
		this.bStf = bStf;
		this.lastPol = lastPol;
		this.pol = pol;
		this.rcvTermCd = rcvTermCd;
		this.custArrExp = custArrExp;
		this.eqOfc = eqOfc;
		this.pod = pod;
		this.filer = filer;
		this.amsFileNo = amsFileNo;
		this.exclRls = exclRls;
		this.lastRnum = lastRnum;
		this.vvd = vvd;
		this.deTermCd = deTermCd;
		this.tmp2 = tmp2;
		this.tmp1 = tmp1;
		this.tmp4 = tmp4;
		this.tmp3 = tmp3;
		this.pageNo = pageNo;
		this.tmp5 = tmp5;
		this.mblNo = mblNo;
		this.customsResultCodeGrp = customsResultCodeGrp;
		this.lRep = lRep;
		this.cntrPrtFlg = cntrPrtFlg;
		this.rhq = rhq;
		this.finalFlg = finalFlg;
		this.customerCd = customerCd;
		this.scNo = scNo;
		this.cntrTp = cntrTp;
		this.cntrNo = cntrNo;
		this.rbillingYn = rbillingYn;
		this.del = del;
		this.contractType = contractType;
		this.errType = errType;
		this.searchDiscrepancy = searchDiscrepancy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tod", getTod());
		this.hashColumns.put("end_no", getEndNo());
		this.hashColumns.put("fromd", getFromd());
		this.hashColumns.put("customs_result_code", getCustomsResultCode());
		this.hashColumns.put("general_or_rail", getGeneralOrRail());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("fromt", getFromt());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("start_no", getStartNo());
		this.hashColumns.put("date_search", getDateSearch());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("last_bl", getLastBl());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("pmib_tp", getPmibTp());
		this.hashColumns.put("b_stf", getBStf());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("cust_arr_exp", getCustArrExp());
		this.hashColumns.put("eq_ofc", getEqOfc());
		this.hashColumns.put("last_pol", getLastPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("ams_file_no", getAmsFileNo());
		this.hashColumns.put("excl_rls", getExclRls());
		this.hashColumns.put("last_rnum", getLastRnum());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp4", getTmp4());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("tmp5", getTmp5());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("customs_result_code_grp", getCustomsResultCodeGrp());
		this.hashColumns.put("l_rep", getLRep());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("final_flg", getFinalFlg());		
		this.hashColumns.put("customer_cd", getCustomerCd());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("cntr_tp", getCntrTp());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("rbilling_yn", getRbillingYn());		
		this.hashColumns.put("del", getDel());		
		this.hashColumns.put("contract_type", getContractType());		
		this.hashColumns.put("err_type", getErrType());		
		this.hashColumns.put("search_discrepancy", getSearchDiscrepancy());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tod", "tod");
		this.hashFields.put("end_no", "endNo");
		this.hashFields.put("fromd", "fromd");
		this.hashFields.put("customs_result_code", "customsResultCode");
		this.hashFields.put("general_or_rail", "generalOrRail");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("fromt", "fromt");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("start_no", "startNo");
		this.hashFields.put("date_search", "dateSearch");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("last_bl", "lastBl");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("pmib_tp", "pmibTp");
		this.hashFields.put("b_stf", "bStf");
		this.hashFields.put("last_pol", "lastPol");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cust_arr_exp", "custArrExp");
		this.hashFields.put("eq_ofc", "eqOfc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("ams_file_no", "amsFileNo");
		this.hashFields.put("excl_rls", "exclRls");
		this.hashFields.put("last_rnum", "lastRnum");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp4", "tmp4");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("tmp5", "tmp5");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("customs_result_code_grp", "customsResultCodeGrp");
		this.hashFields.put("l_rep", "lRep");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("final_flg", "finalFlg");		
		this.hashFields.put("customer_cd", "customerCd");		
		this.hashFields.put("sc_no", "scNo");		
		this.hashFields.put("cntr_tp", "cntrTp");		
		this.hashFields.put("cntr_no", "cntrNo");		
		this.hashFields.put("rbilling_yn", "rbillingYn");		
		this.hashFields.put("del", "del");
		this.hashFields.put("contract_type", "contractType");	
		this.hashFields.put("err_type", "errType");		
		this.hashFields.put("search_discrepancy", "searchDiscrepancy");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tod
	 */
	public String getTod() {
		return this.tod;
	}
	
	/**
	 * Column Info
	 * @return endNo
	 */
	public String getEndNo() {
		return this.endNo;
	}
	
	/**
	 * Column Info
	 * @return fromd
	 */
	public String getFromd() {
		return this.fromd;
	}
	
	/**
	 * Column Info
	 * @return customsResultCode
	 */
	public String getCustomsResultCode() {
		return this.customsResultCode;
	}
	
	/**
	 * Column Info
	 * @return generalOrRail
	 */
	public String getGeneralOrRail() {
		return this.generalOrRail;
	}
	
	/**
	 * Column Info
	 * @return hub
	 */
	public String getHub() {
		return this.hub;
	}
	
	/**
	 * Column Info
	 * @return fromt
	 */
	public String getFromt() {
		return this.fromt;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
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
	 * @return startNo
	 */
	public String getStartNo() {
		return this.startNo;
	}
	
	/**
	 * Column Info
	 * @return dateSearch
	 */
	public String getDateSearch() {
		return this.dateSearch;
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
	 * @return lastBl
	 */
	public String getLastBl() {
		return this.lastBl;
	}
	
	/**
	 * Column Info
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	
	/**
	 * Column Info
	 * @return pmibTp
	 */
	public String getPmibTp() {
		return this.pmibTp;
	}
	
	/**
	 * Column Info
	 * @return bStf
	 */
	public String getBStf() {
		return this.bStf;
	}
	
	/**
	 * Column Info
	 * @return lastPol
	 */
	public String getLastPol() {
		return this.lastPol;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return custArrExp
	 */
	public String getCustArrExp() {
		return this.custArrExp;
	}
	
	/**
	 * Column Info
	 * @return eqOfc
	 */
	public String getEqOfc() {
		return this.eqOfc;
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
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return amsFileNo
	 */
	public String getAmsFileNo() {
		return this.amsFileNo;
	}
	
	/**
	 * Column Info
	 * @return exclRls
	 */
	public String getExclRls() {
		return this.exclRls;
	}
	
	/**
	 * Column Info
	 * @return lastRnum
	 */
	public String getLastRnum() {
		return this.lastRnum;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp4
	 */
	public String getTmp4() {
		return this.tmp4;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return tmp5
	 */
	public String getTmp5() {
		return this.tmp5;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return customsResultCodeGrp
	 */
	public String getCustomsResultCodeGrp() {
		return this.customsResultCodeGrp;
	}
	
	/**
	 * Column Info
	 * @return lRep
	 */
	public String getLRep() {
		return this.lRep;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}	

	/**
	 * Column Info
	 * @return finalFlg
	 */
	public String getFinalFlg() {
		return this.finalFlg;
	}		
		
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return contractType
	 */
	public String getContractType() {
		return contractType;
	}	

	
	/**
	 * Column Info
	 * @return errType
	 */
	public String getErrType() {
		return errType;
	}	
	
	/**
	 * Column Info
	 * @return searchDiscrepancy
	 */
	public String getSearchDiscrepancy() {
		return searchDiscrepancy;
	}	
	

	/**
	 * Column Info
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param tod
	 */
	public void setTod(String tod) {
		this.tod = tod;
	}
	
	/**
	 * Column Info
	 * @param endNo
	 */
	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}
	
	/**
	 * Column Info
	 * @param fromd
	 */
	public void setFromd(String fromd) {
		this.fromd = fromd;
	}
	
	/**
	 * Column Info
	 * @param customsResultCode
	 */
	public void setCustomsResultCode(String customsResultCode) {
		this.customsResultCode = customsResultCode;
	}
	
	/**
	 * Column Info
	 * @param generalOrRail
	 */
	public void setGeneralOrRail(String generalOrRail) {
		this.generalOrRail = generalOrRail;
	}
	
	/**
	 * Column Info
	 * @param hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * Column Info
	 * @param fromt
	 */
	public void setFromt(String fromt) {
		this.fromt = fromt;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
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
	 * @param startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
	}
	
	/**
	 * Column Info
	 * @param dateSearch
	 */
	public void setDateSearch(String dateSearch) {
		this.dateSearch = dateSearch;
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
	 * @param lastBl
	 */
	public void setLastBl(String lastBl) {
		this.lastBl = lastBl;
	}
	
	/**
	 * Column Info
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Column Info
	 * @param pmibTp
	 */
	public void setPmibTp(String pmibTp) {
		this.pmibTp = pmibTp;
	}
	
	/**
	 * Column Info
	 * @param bStf
	 */
	public void setBStf(String bStf) {
		this.bStf = bStf;
	}
	
	/**
	 * Column Info
	 * @param lastPol
	 */
	public void setLastPol(String lastPol) {
		this.lastPol = lastPol;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param custArrExp
	 */
	public void setCustArrExp(String custArrExp) {
		this.custArrExp = custArrExp;
	}
	
	/**
	 * Column Info
	 * @param eqOfc
	 */
	public void setEqOfc(String eqOfc) {
		this.eqOfc = eqOfc;
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
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param amsFileNo
	 */
	public void setAmsFileNo(String amsFileNo) {
		this.amsFileNo = amsFileNo;
	}
	
	/**
	 * Column Info
	 * @param exclRls
	 */
	public void setExclRls(String exclRls) {
		this.exclRls = exclRls;
	}
	
	/**
	 * Column Info
	 * @param lastRnum
	 */
	public void setLastRnum(String lastRnum) {
		this.lastRnum = lastRnum;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp4
	 */
	public void setTmp4(String tmp4) {
		this.tmp4 = tmp4;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param tmp5
	 */
	public void setTmp5(String tmp5) {
		this.tmp5 = tmp5;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param customsResultCodeGrp
	 */
	public void setCustomsResultCodeGrp(String customsResultCodeGrp) {
		this.customsResultCodeGrp = customsResultCodeGrp;
	}
	
	/**
	 * Column Info
	 * @param lRep
	 */
	public void setLRep(String lRep) {
		this.lRep = lRep;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}	
	
	/**
	 * Column Info
	 * @param finalFlg
	 */
	public void setFinalFlg(String finalFlg) {
		this.finalFlg = finalFlg;
	}
	
	/**
	 * Column Info
	 * @return customerCd
	 */
	public String getCustomerCd() {
		return customerCd;
	}
	
	/**
	 * Column Info
	 * @param customerCd
	 */
	public void setCustomerCd(String customerCd) {
		this.customerCd = customerCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return scNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return cntrTp;
	}
	
	/**
	 * Column Info
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rbillingYn
	 */
	public String getRbillingYn() {
		return rbillingYn;
	}
	
	/**
	 * Column Info
	 * @param rbillingYn
	 */
	public void setRbillingYn(String rbillingYn) {
		this.rbillingYn = rbillingYn;
	}
	
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return del;
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
	 * @param contractType
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	/**
	 * Column Info
	 * @param errType
	 */
	public void setErrType(String errType) {
		this.errType = errType;
	}

	/**
	 * Column Info
	 * @param searchDiscrepancy
	 */
	public void setSearchDiscrepancy(String searchDiscrepancy) {
		this.searchDiscrepancy = searchDiscrepancy;
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
		setTod(JSPUtil.getParameter(request, prefix + "tod", ""));
		setEndNo(JSPUtil.getParameter(request, prefix + "end_no", ""));
		setFromd(JSPUtil.getParameter(request, prefix + "fromd", ""));
		setCustomsResultCode(JSPUtil.getParameter(request, prefix + "customs_result_code", ""));
		setGeneralOrRail(JSPUtil.getParameter(request, prefix + "general_or_rail", ""));
		setHub(JSPUtil.getParameter(request, prefix + "hub", ""));
		setFromt(JSPUtil.getParameter(request, prefix + "fromt", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStartNo(JSPUtil.getParameter(request, prefix + "start_no", ""));
		setDateSearch(JSPUtil.getParameter(request, prefix + "date_search", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLastBl(JSPUtil.getParameter(request, prefix + "last_bl", ""));
		setTot(JSPUtil.getParameter(request, prefix + "tot", ""));
		setPmibTp(JSPUtil.getParameter(request, prefix + "pmib_tp", ""));
		setBStf(JSPUtil.getParameter(request, prefix + "b_stf", ""));
		setLastPol(JSPUtil.getParameter(request, prefix + "last_pol", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setCustArrExp(JSPUtil.getParameter(request, prefix + "cust_arr_exp", ""));
		setEqOfc(JSPUtil.getParameter(request, prefix + "eq_ofc", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setFiler(JSPUtil.getParameter(request, prefix + "filer", ""));
		setAmsFileNo(JSPUtil.getParameter(request, prefix + "ams_file_no", ""));
		setExclRls(JSPUtil.getParameter(request, prefix + "excl_rls", ""));
		setLastRnum(JSPUtil.getParameter(request, prefix + "last_rnum", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setTmp2(JSPUtil.getParameter(request, prefix + "tmp2", ""));
		setTmp1(JSPUtil.getParameter(request, prefix + "tmp1", ""));
		setTmp4(JSPUtil.getParameter(request, prefix + "tmp4", ""));
		setTmp3(JSPUtil.getParameter(request, prefix + "tmp3", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setTmp5(JSPUtil.getParameter(request, prefix + "tmp5", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setCustomsResultCodeGrp(JSPUtil.getParameter(request, prefix + "customs_result_code_grp", ""));
		setLRep(JSPUtil.getParameter(request, prefix + "l_rep", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setFinalFlg(JSPUtil.getParameter(request, prefix + "final_flg", ""));		
		setCustomerCd(JSPUtil.getParameter(request, prefix + "customer_cd", ""));		
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));		
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));		
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));		
		setRbillingYn(JSPUtil.getParameter(request, prefix + "rbilling_yn", ""));		
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));		
		setContractType(JSPUtil.getParameter(request, prefix + "contract_type", ""));		
		setErrType(JSPUtil.getParameter(request, prefix + "err_type", ""));
		setSearchDiscrepancy(JSPUtil.getParameter(request, prefix + "search_discrepancy", ""));
		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaAmsReportListCondVO[]
	 */
	public UsaAmsReportListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaAmsReportListCondVO[]
	 */
	public UsaAmsReportListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaAmsReportListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tod = (JSPUtil.getParameter(request, prefix	+ "tod", length));
			String[] endNo = (JSPUtil.getParameter(request, prefix	+ "end_no", length));
			String[] fromd = (JSPUtil.getParameter(request, prefix	+ "fromd", length));
			String[] customsResultCode = (JSPUtil.getParameter(request, prefix	+ "customs_result_code", length));
			String[] generalOrRail = (JSPUtil.getParameter(request, prefix	+ "general_or_rail", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] fromt = (JSPUtil.getParameter(request, prefix	+ "fromt", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] startNo = (JSPUtil.getParameter(request, prefix	+ "start_no", length));
			String[] dateSearch = (JSPUtil.getParameter(request, prefix	+ "date_search", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lastBl = (JSPUtil.getParameter(request, prefix	+ "last_bl", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] pmibTp = (JSPUtil.getParameter(request, prefix	+ "pmib_tp", length));
			String[] bStf = (JSPUtil.getParameter(request, prefix	+ "b_stf", length));
			String[] lastPol = (JSPUtil.getParameter(request, prefix	+ "last_pol", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] custArrExp = (JSPUtil.getParameter(request, prefix	+ "cust_arr_exp", length));
			String[] eqOfc = (JSPUtil.getParameter(request, prefix	+ "eq_ofc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] amsFileNo = (JSPUtil.getParameter(request, prefix	+ "ams_file_no", length));
			String[] exclRls = (JSPUtil.getParameter(request, prefix	+ "excl_rls", length));
			String[] lastRnum = (JSPUtil.getParameter(request, prefix	+ "last_rnum", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp4 = (JSPUtil.getParameter(request, prefix	+ "tmp4", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] tmp5 = (JSPUtil.getParameter(request, prefix	+ "tmp5", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] customsResultCodeGrp = (JSPUtil.getParameter(request, prefix	+ "customs_result_code_grp", length));
			String[] lRep = (JSPUtil.getParameter(request, prefix	+ "l_rep", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] finalFlg = (JSPUtil.getParameter(request, prefix	+ "final_flg", length));			
			String[] customerCd = (JSPUtil.getParameter(request, prefix	+ "customer_cd", length));			
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));			
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));			
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));			
			String[] rbillingYn = (JSPUtil.getParameter(request, prefix	+ "rbilling_yn", length));			
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));		
			String[] contractType = (JSPUtil.getParameter(request, prefix	+ "contract_type", length));		
			String[] errType = (JSPUtil.getParameter(request, prefix	+ "err_type", length));			
			String[] searchDiscrepancy = (JSPUtil.getParameter(request, prefix	+ "search_discrepancy", length));
			
						
			for (int i = 0; i < length; i++) {
				model = new UsaAmsReportListCondVO();
				if (tod[i] != null)
					model.setTod(tod[i]);
				if (endNo[i] != null)
					model.setEndNo(endNo[i]);
				if (fromd[i] != null)
					model.setFromd(fromd[i]);
				if (customsResultCode[i] != null)
					model.setCustomsResultCode(customsResultCode[i]);
				if (generalOrRail[i] != null)
					model.setGeneralOrRail(generalOrRail[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (fromt[i] != null)
					model.setFromt(fromt[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (startNo[i] != null)
					model.setStartNo(startNo[i]);
				if (dateSearch[i] != null)
					model.setDateSearch(dateSearch[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lastBl[i] != null)
					model.setLastBl(lastBl[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (pmibTp[i] != null)
					model.setPmibTp(pmibTp[i]);
				if (bStf[i] != null)
					model.setBStf(bStf[i]);
				if (lastPol[i] != null)
					model.setLastPol(lastPol[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (custArrExp[i] != null)
					model.setCustArrExp(custArrExp[i]);
				if (eqOfc[i] != null)
					model.setEqOfc(eqOfc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (amsFileNo[i] != null)
					model.setAmsFileNo(amsFileNo[i]);
				if (exclRls[i] != null)
					model.setExclRls(exclRls[i]);
				if (lastRnum[i] != null)
					model.setLastRnum(lastRnum[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp4[i] != null)
					model.setTmp4(tmp4[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (tmp5[i] != null)
					model.setTmp5(tmp5[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (customsResultCodeGrp[i] != null)
					model.setCustomsResultCodeGrp(customsResultCodeGrp[i]);
				if (lRep[i] != null)
					model.setLRep(lRep[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);				
				if (finalFlg[i] != null)
					model.setFinalFlg(finalFlg[i]);				
				if (customerCd[i] != null)
					model.setCustomerCd(customerCd[i]);				
				if (scNo[i] != null)
					model.setScNo(scNo[i]);				
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);				
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);				
				if (rbillingYn[i] != null)
					model.setRbillingYn(rbillingYn[i]);				
				if (del[i] != null)
					model.setDel(del[i]);		
				if (contractType[i] != null)
					model.setContractType(contractType[i]);
				if (errType[i] != null)
					model.setErrType(errType[i]);
				if (searchDiscrepancy[i] != null)
					model.setSearchDiscrepancy(searchDiscrepancy[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaAmsReportListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaAmsReportListCondVO[]
	 */
	public UsaAmsReportListCondVO[] getUsaAmsReportListCondVOs(){
		UsaAmsReportListCondVO[] vos = (UsaAmsReportListCondVO[])models.toArray(new UsaAmsReportListCondVO[models.size()]);
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
		this.tod = this.tod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNo = this.endNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromd = this.fromd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsResultCode = this.customsResultCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.generalOrRail = this.generalOrRail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromt = this.fromt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNo = this.startNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateSearch = this.dateSearch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastBl = this.lastBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmibTp = this.pmibTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bStf = this.bStf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPol = this.lastPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custArrExp = this.custArrExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfc = this.eqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsFileNo = this.amsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclRls = this.exclRls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastRnum = this.lastRnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp4 = this.tmp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp5 = this.tmp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsResultCodeGrp = this.customsResultCodeGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lRep = this.lRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalFlg = this.finalFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.customerCd = this.customerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.rbillingYn = this.rbillingYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");				
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");			
		this.contractType = this.contractType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.errType = this.errType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.searchDiscrepancy = this.searchDiscrepancy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
