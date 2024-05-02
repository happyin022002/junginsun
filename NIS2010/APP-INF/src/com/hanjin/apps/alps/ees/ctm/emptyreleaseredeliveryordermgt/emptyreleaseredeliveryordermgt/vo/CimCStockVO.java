/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CimCStockVO.java
*@FileTitle : CimCStockVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.04.24 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CimCStockVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CimCStockVO> models = new ArrayList<CimCStockVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String cb = null;
	/* Column Info */
	private String tp = null;
	/* Column Info */
	private String issueType = null;
	/* Column Info */
	private String iType = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rowCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oQty = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String spclInst = null;
	/* Column Info */
	private String bdDisp = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String stChk = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String bd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String userLoc = null;
	/* Column Info */
	private String firstPagerows = null;
	/* Column Info */
	private String userCnt = null;
	/* Column Info */
	private String issued = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String deleted = null;
	/* Column Info */
	private String mhChk = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String stkJbDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String userOfc = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String deletedDt = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sP = null;
	/* Column Info */
	private String issueFlag = null;
	/* Column Info */
	private String territory = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String sendKey = null;
	/* Column Info */
	private String modeCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mvmtCntrNo = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String jobSeq = null;
	/* Column Info */
	private String shipOpr = null;
	/* Column Info */
	private String pdDate = null;
	/* Column Info */
	private String emptyCy = null;
	/* Column Info */
	private String issueDt = null;
	/* Column Info */
	private String typeDisp = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String faxEmailRst = null;
	/* Column Info */
	private String soOfcCtyCd = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String orgEmptyCy = null;
	/* Column Info */
	private String emptyDest = null;
	/* Column Info */
	private String troChk = null;
	/* Column Info */
	private String mtRepoChk = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String pdDateDisp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgChk = null;
	/* Column Info */
	private String iOffice = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String typeCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CimCStockVO() {}

	public CimCStockVO(String ibflag, String pagerows, String ntfy, String cb, String tp, String issueType, String iType, String type, String blNo, String oQty, String pDate1, String spclInst, String bdDisp, String pDate2, String scNo, String cntrTpszCd, String pol, String userId, String lstmCd, String bd, String pod, String userLoc, String userCnt, String issued, String qty, String deleted, String vvd, String stkJbDt, String bkgNo, String userOfc, String email, String deletedDt, String pYard2, String faxNo, String pYard1, String sP, String issueFlag, String territory, String soSeq, String vndrLglEngNm, String sendKey, String modeCd, String rfaNo, String eqNo, String mvmtCntrNo, String woNo, String jobSeq, String pdDate, String emptyCy, String issueDt, String office, String typeDisp, String faxEmailRst, String soOfcCtyCd, String troSeq, String orgEmptyCy, String emptyDest, String invNo, String lccCd, String pdDateDisp, String cntrNo, String cnee, String iOffice, String shpr, String typeCd, String shipOpr, String porCd, String delCd, String dorNodCd, String bkgChk, String troChk, String mhChk, String mtRepoChk, String stChk, String pageNo, String totalCnt, String rowCnt, String firstPagerows, String iPage) {
		this.ntfy = ntfy;
		this.cb = cb;
		this.tp = tp;
		this.issueType = issueType;
		this.iType = iType;
		this.type = type;
		this.blNo = blNo;
		this.rowCnt = rowCnt;
		this.pagerows = pagerows;
		this.oQty = oQty;
		this.pDate1 = pDate1;
		this.spclInst = spclInst;
		this.bdDisp = bdDisp;
		this.pDate2 = pDate2;
		this.scNo = scNo;
		this.userId = userId;
		this.pol = pol;
		this.cntrTpszCd = cntrTpszCd;
		this.iPage = iPage;
		this.stChk = stChk;
		this.lstmCd = lstmCd;
		this.totalCnt = totalCnt;
		this.bd = bd;
		this.pod = pod;
		this.userLoc = userLoc;
		this.firstPagerows = firstPagerows;
		this.userCnt = userCnt;
		this.issued = issued;
		this.delCd = delCd;
		this.qty = qty;
		this.deleted = deleted;
		this.mhChk = mhChk;
		this.vvd = vvd;
		this.stkJbDt = stkJbDt;
		this.bkgNo = bkgNo;
		this.userOfc = userOfc;
		this.email = email;
		this.pageNo = pageNo;
		this.deletedDt = deletedDt;
		this.pYard2 = pYard2;
		this.faxNo = faxNo;
		this.pYard1 = pYard1;
		this.porCd = porCd;
		this.sP = sP;
		this.issueFlag = issueFlag;
		this.territory = territory;
		this.soSeq = soSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.sendKey = sendKey;
		this.modeCd = modeCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.mvmtCntrNo = mvmtCntrNo;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.jobSeq = jobSeq;
		this.shipOpr = shipOpr;
		this.pdDate = pdDate;
		this.emptyCy = emptyCy;
		this.issueDt = issueDt;
		this.typeDisp = typeDisp;
		this.office = office;
		this.faxEmailRst = faxEmailRst;
		this.soOfcCtyCd = soOfcCtyCd;
		this.troSeq = troSeq;
		this.orgEmptyCy = orgEmptyCy;
		this.emptyDest = emptyDest;
		this.troChk = troChk;
		this.mtRepoChk = mtRepoChk;
		this.invNo = invNo;
		this.lccCd = lccCd;
		this.pdDateDisp = pdDateDisp;
		this.cntrNo = cntrNo;
		this.bkgChk = bkgChk;
		this.iOffice = iOffice;
		this.cnee = cnee;
		this.shpr = shpr;
		this.typeCd = typeCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("cb", getCb());
		this.hashColumns.put("tp", getTp());
		this.hashColumns.put("issue_type", getIssueType());
		this.hashColumns.put("i_type", getIType());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("o_qty", getOQty());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("spcl_inst", getSpclInst());
		this.hashColumns.put("bd_disp", getBdDisp());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("st_chk", getStChk());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("bd", getBd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("user_loc", getUserLoc());
		this.hashColumns.put("first_pagerows", getFirstPagerows());
		this.hashColumns.put("user_cnt", getUserCnt());
		this.hashColumns.put("issued", getIssued());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("deleted", getDeleted());
		this.hashColumns.put("mh_chk", getMhChk());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("stk_jb_dt", getStkJbDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("user_ofc", getUserOfc());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("deleted_dt", getDeletedDt());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_p", getSP());
		this.hashColumns.put("issue_flag", getIssueFlag());
		this.hashColumns.put("territory", getTerritory());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("send_key", getSendKey());
		this.hashColumns.put("mode_cd", getModeCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mvmt_cntr_no", getMvmtCntrNo());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("job_seq", getJobSeq());
		this.hashColumns.put("ship_opr", getShipOpr());
		this.hashColumns.put("pd_date", getPdDate());
		this.hashColumns.put("empty_cy", getEmptyCy());
		this.hashColumns.put("issue_dt", getIssueDt());
		this.hashColumns.put("type_disp", getTypeDisp());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("fax_email_rst", getFaxEmailRst());
		this.hashColumns.put("so_ofc_cty_cd", getSoOfcCtyCd());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("org_empty_cy", getOrgEmptyCy());
		this.hashColumns.put("empty_dest", getEmptyDest());
		this.hashColumns.put("tro_chk", getTroChk());
		this.hashColumns.put("mt_repo_chk", getMtRepoChk());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("pd_date_disp", getPdDateDisp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_chk", getBkgChk());
		this.hashColumns.put("i_office", getIOffice());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("type_cd", getTypeCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("cb", "cb");
		this.hashFields.put("tp", "tp");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("i_type", "iType");
		this.hashFields.put("type", "type");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("o_qty", "oQty");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("spcl_inst", "spclInst");
		this.hashFields.put("bd_disp", "bdDisp");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("st_chk", "stChk");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("bd", "bd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("user_loc", "userLoc");
		this.hashFields.put("first_pagerows", "firstPagerows");
		this.hashFields.put("user_cnt", "userCnt");
		this.hashFields.put("issued", "issued");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("deleted", "deleted");
		this.hashFields.put("mh_chk", "mhChk");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("stk_jb_dt", "stkJbDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("user_ofc", "userOfc");
		this.hashFields.put("email", "email");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("deleted_dt", "deletedDt");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_p", "sP");
		this.hashFields.put("issue_flag", "issueFlag");
		this.hashFields.put("territory", "territory");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("send_key", "sendKey");
		this.hashFields.put("mode_cd", "modeCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mvmt_cntr_no", "mvmtCntrNo");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("job_seq", "jobSeq");
		this.hashFields.put("ship_opr", "shipOpr");
		this.hashFields.put("pd_date", "pdDate");
		this.hashFields.put("empty_cy", "emptyCy");
		this.hashFields.put("issue_dt", "issueDt");
		this.hashFields.put("type_disp", "typeDisp");
		this.hashFields.put("office", "office");
		this.hashFields.put("fax_email_rst", "faxEmailRst");
		this.hashFields.put("so_ofc_cty_cd", "soOfcCtyCd");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("org_empty_cy", "orgEmptyCy");
		this.hashFields.put("empty_dest", "emptyDest");
		this.hashFields.put("tro_chk", "troChk");
		this.hashFields.put("mt_repo_chk", "mtRepoChk");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("pd_date_disp", "pdDateDisp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_chk", "bkgChk");
		this.hashFields.put("i_office", "iOffice");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("type_cd", "typeCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return cb
	 */
	public String getCb() {
		return this.cb;
	}
	
	/**
	 * Column Info
	 * @return tp
	 */
	public String getTp() {
		return this.tp;
	}
	
	/**
	 * Column Info
	 * @return issueType
	 */
	public String getIssueType() {
		return this.issueType;
	}
	
	/**
	 * Column Info
	 * @return iType
	 */
	public String getIType() {
		return this.iType;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return rowCnt
	 */
	public String getRowCnt() {
		return this.rowCnt;
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
	 * @return oQty
	 */
	public String getOQty() {
		return this.oQty;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return spclInst
	 */
	public String getSpclInst() {
		return this.spclInst;
	}
	
	/**
	 * Column Info
	 * @return bdDisp
	 */
	public String getBdDisp() {
		return this.bdDisp;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return stChk
	 */
	public String getStChk() {
		return this.stChk;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return bd
	 */
	public String getBd() {
		return this.bd;
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
	 * @return userLoc
	 */
	public String getUserLoc() {
		return this.userLoc;
	}
	
	/**
	 * Column Info
	 * @return firstPagerows
	 */
	public String getFirstPagerows() {
		return this.firstPagerows;
	}
	
	/**
	 * Column Info
	 * @return userCnt
	 */
	public String getUserCnt() {
		return this.userCnt;
	}
	
	/**
	 * Column Info
	 * @return issued
	 */
	public String getIssued() {
		return this.issued;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return deleted
	 */
	public String getDeleted() {
		return this.deleted;
	}
	
	/**
	 * Column Info
	 * @return mhChk
	 */
	public String getMhChk() {
		return this.mhChk;
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
	 * @return stkJbDt
	 */
	public String getStkJbDt() {
		return this.stkJbDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return userOfc
	 */
	public String getUserOfc() {
		return this.userOfc;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
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
	 * @return deletedDt
	 */
	public String getDeletedDt() {
		return this.deletedDt;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return sP
	 */
	public String getSP() {
		return this.sP;
	}
	
	/**
	 * Column Info
	 * @return issueFlag
	 */
	public String getIssueFlag() {
		return this.issueFlag;
	}
	
	/**
	 * Column Info
	 * @return territory
	 */
	public String getTerritory() {
		return this.territory;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return sendKey
	 */
	public String getSendKey() {
		return this.sendKey;
	}
	
	/**
	 * Column Info
	 * @return modeCd
	 */
	public String getModeCd() {
		return this.modeCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtCntrNo
	 */
	public String getMvmtCntrNo() {
		return this.mvmtCntrNo;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return jobSeq
	 */
	public String getJobSeq() {
		return this.jobSeq;
	}
	
	/**
	 * Column Info
	 * @return shipOpr
	 */
	public String getShipOpr() {
		return this.shipOpr;
	}
	
	/**
	 * Column Info
	 * @return pdDate
	 */
	public String getPdDate() {
		return this.pdDate;
	}
	
	/**
	 * Column Info
	 * @return emptyCy
	 */
	public String getEmptyCy() {
		return this.emptyCy;
	}
	
	/**
	 * Column Info
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
	}
	
	/**
	 * Column Info
	 * @return typeDisp
	 */
	public String getTypeDisp() {
		return this.typeDisp;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return faxEmailRst
	 */
	public String getFaxEmailRst() {
		return this.faxEmailRst;
	}
	
	/**
	 * Column Info
	 * @return soOfcCtyCd
	 */
	public String getSoOfcCtyCd() {
		return this.soOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return orgEmptyCy
	 */
	public String getOrgEmptyCy() {
		return this.orgEmptyCy;
	}
	
	/**
	 * Column Info
	 * @return emptyDest
	 */
	public String getEmptyDest() {
		return this.emptyDest;
	}
	
	/**
	 * Column Info
	 * @return troChk
	 */
	public String getTroChk() {
		return this.troChk;
	}
	
	/**
	 * Column Info
	 * @return mtRepoChk
	 */
	public String getMtRepoChk() {
		return this.mtRepoChk;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return pdDateDisp
	 */
	public String getPdDateDisp() {
		return this.pdDateDisp;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgChk
	 */
	public String getBkgChk() {
		return this.bkgChk;
	}
	
	/**
	 * Column Info
	 * @return iOffice
	 */
	public String getIOffice() {
		return this.iOffice;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	

	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param cb
	 */
	public void setCb(String cb) {
		this.cb = cb;
	}
	
	/**
	 * Column Info
	 * @param tp
	 */
	public void setTp(String tp) {
		this.tp = tp;
	}
	
	/**
	 * Column Info
	 * @param issueType
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	/**
	 * Column Info
	 * @param iType
	 */
	public void setIType(String iType) {
		this.iType = iType;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param rowCnt
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
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
	 * @param oQty
	 */
	public void setOQty(String oQty) {
		this.oQty = oQty;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param spclInst
	 */
	public void setSpclInst(String spclInst) {
		this.spclInst = spclInst;
	}
	
	/**
	 * Column Info
	 * @param bdDisp
	 */
	public void setBdDisp(String bdDisp) {
		this.bdDisp = bdDisp;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param stChk
	 */
	public void setStChk(String stChk) {
		this.stChk = stChk;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param bd
	 */
	public void setBd(String bd) {
		this.bd = bd;
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
	 * @param userLoc
	 */
	public void setUserLoc(String userLoc) {
		this.userLoc = userLoc;
	}
	
	/**
	 * Column Info
	 * @param firstPagerows
	 */
	public void setFirstPagerows(String firstPagerows) {
		this.firstPagerows = firstPagerows;
	}
	
	/**
	 * Column Info
	 * @param userCnt
	 */
	public void setUserCnt(String userCnt) {
		this.userCnt = userCnt;
	}
	
	/**
	 * Column Info
	 * @param issued
	 */
	public void setIssued(String issued) {
		this.issued = issued;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param deleted
	 */
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	/**
	 * Column Info
	 * @param mhChk
	 */
	public void setMhChk(String mhChk) {
		this.mhChk = mhChk;
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
	 * @param stkJbDt
	 */
	public void setStkJbDt(String stkJbDt) {
		this.stkJbDt = stkJbDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param userOfc
	 */
	public void setUserOfc(String userOfc) {
		this.userOfc = userOfc;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @param deletedDt
	 */
	public void setDeletedDt(String deletedDt) {
		this.deletedDt = deletedDt;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param sP
	 */
	public void setSP(String sP) {
		this.sP = sP;
	}
	
	/**
	 * Column Info
	 * @param issueFlag
	 */
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}
	
	/**
	 * Column Info
	 * @param territory
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param sendKey
	 */
	public void setSendKey(String sendKey) {
		this.sendKey = sendKey;
	}
	
	/**
	 * Column Info
	 * @param modeCd
	 */
	public void setModeCd(String modeCd) {
		this.modeCd = modeCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtCntrNo
	 */
	public void setMvmtCntrNo(String mvmtCntrNo) {
		this.mvmtCntrNo = mvmtCntrNo;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param jobSeq
	 */
	public void setJobSeq(String jobSeq) {
		this.jobSeq = jobSeq;
	}
	
	/**
	 * Column Info
	 * @param shipOpr
	 */
	public void setShipOpr(String shipOpr) {
		this.shipOpr = shipOpr;
	}
	
	/**
	 * Column Info
	 * @param pdDate
	 */
	public void setPdDate(String pdDate) {
		this.pdDate = pdDate;
	}
	
	/**
	 * Column Info
	 * @param emptyCy
	 */
	public void setEmptyCy(String emptyCy) {
		this.emptyCy = emptyCy;
	}
	
	/**
	 * Column Info
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	
	/**
	 * Column Info
	 * @param typeDisp
	 */
	public void setTypeDisp(String typeDisp) {
		this.typeDisp = typeDisp;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param faxEmailRst
	 */
	public void setFaxEmailRst(String faxEmailRst) {
		this.faxEmailRst = faxEmailRst;
	}
	
	/**
	 * Column Info
	 * @param soOfcCtyCd
	 */
	public void setSoOfcCtyCd(String soOfcCtyCd) {
		this.soOfcCtyCd = soOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param orgEmptyCy
	 */
	public void setOrgEmptyCy(String orgEmptyCy) {
		this.orgEmptyCy = orgEmptyCy;
	}
	
	/**
	 * Column Info
	 * @param emptyDest
	 */
	public void setEmptyDest(String emptyDest) {
		this.emptyDest = emptyDest;
	}
	
	/**
	 * Column Info
	 * @param troChk
	 */
	public void setTroChk(String troChk) {
		this.troChk = troChk;
	}
	
	/**
	 * Column Info
	 * @param mtRepoChk
	 */
	public void setMtRepoChk(String mtRepoChk) {
		this.mtRepoChk = mtRepoChk;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param pdDateDisp
	 */
	public void setPdDateDisp(String pdDateDisp) {
		this.pdDateDisp = pdDateDisp;
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
	 * @param bkgChk
	 */
	public void setBkgChk(String bkgChk) {
		this.bkgChk = bkgChk;
	}
	
	/**
	 * Column Info
	 * @param iOffice
	 */
	public void setIOffice(String iOffice) {
		this.iOffice = iOffice;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
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
		setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
		setCb(JSPUtil.getParameter(request, prefix + "cb", ""));
		setTp(JSPUtil.getParameter(request, prefix + "tp", ""));
		setIssueType(JSPUtil.getParameter(request, prefix + "issue_type", ""));
		setIType(JSPUtil.getParameter(request, prefix + "i_type", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRowCnt(JSPUtil.getParameter(request, prefix + "row_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOQty(JSPUtil.getParameter(request, prefix + "o_qty", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setSpclInst(JSPUtil.getParameter(request, prefix + "spcl_inst", ""));
		setBdDisp(JSPUtil.getParameter(request, prefix + "bd_disp", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setStChk(JSPUtil.getParameter(request, prefix + "st_chk", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setBd(JSPUtil.getParameter(request, prefix + "bd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setUserLoc(JSPUtil.getParameter(request, prefix + "user_loc", ""));
		setFirstPagerows(JSPUtil.getParameter(request, prefix + "first_pagerows", ""));
		setUserCnt(JSPUtil.getParameter(request, prefix + "user_cnt", ""));
		setIssued(JSPUtil.getParameter(request, prefix + "issued", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setDeleted(JSPUtil.getParameter(request, prefix + "deleted", ""));
		setMhChk(JSPUtil.getParameter(request, prefix + "mh_chk", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setStkJbDt(JSPUtil.getParameter(request, prefix + "stk_jb_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUserOfc(JSPUtil.getParameter(request, prefix + "user_ofc", ""));
		setEmail(JSPUtil.getParameter(request, prefix + "email", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setDeletedDt(JSPUtil.getParameter(request, prefix + "deleted_dt", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSP(JSPUtil.getParameter(request, prefix + "s_p", ""));
		setIssueFlag(JSPUtil.getParameter(request, prefix + "issue_flag", ""));
		setTerritory(JSPUtil.getParameter(request, prefix + "territory", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setSendKey(JSPUtil.getParameter(request, prefix + "send_key", ""));
		setModeCd(JSPUtil.getParameter(request, prefix + "mode_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setMvmtCntrNo(JSPUtil.getParameter(request, prefix + "mvmt_cntr_no", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setJobSeq(JSPUtil.getParameter(request, prefix + "job_seq", ""));
		setShipOpr(JSPUtil.getParameter(request, prefix + "ship_opr", ""));
		setPdDate(JSPUtil.getParameter(request, prefix + "pd_date", ""));
		setEmptyCy(JSPUtil.getParameter(request, prefix + "empty_cy", ""));
		setIssueDt(JSPUtil.getParameter(request, prefix + "issue_dt", ""));
		setTypeDisp(JSPUtil.getParameter(request, prefix + "type_disp", ""));
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setFaxEmailRst(JSPUtil.getParameter(request, prefix + "fax_email_rst", ""));
		setSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "so_ofc_cty_cd", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setOrgEmptyCy(JSPUtil.getParameter(request, prefix + "org_empty_cy", ""));
		setEmptyDest(JSPUtil.getParameter(request, prefix + "empty_dest", ""));
		setTroChk(JSPUtil.getParameter(request, prefix + "tro_chk", ""));
		setMtRepoChk(JSPUtil.getParameter(request, prefix + "mt_repo_chk", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setPdDateDisp(JSPUtil.getParameter(request, prefix + "pd_date_disp", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgChk(JSPUtil.getParameter(request, prefix + "bkg_chk", ""));
		setIOffice(JSPUtil.getParameter(request, prefix + "i_office", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CimCStockVO[]
	 */
	public CimCStockVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CimCStockVO[]
	 */
	public CimCStockVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CimCStockVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] cb = (JSPUtil.getParameter(request, prefix	+ "cb", length));
			String[] tp = (JSPUtil.getParameter(request, prefix	+ "tp", length));
			String[] issueType = (JSPUtil.getParameter(request, prefix	+ "issue_type", length));
			String[] iType = (JSPUtil.getParameter(request, prefix	+ "i_type", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oQty = (JSPUtil.getParameter(request, prefix	+ "o_qty", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] spclInst = (JSPUtil.getParameter(request, prefix	+ "spcl_inst", length));
			String[] bdDisp = (JSPUtil.getParameter(request, prefix	+ "bd_disp", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] stChk = (JSPUtil.getParameter(request, prefix	+ "st_chk", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] bd = (JSPUtil.getParameter(request, prefix	+ "bd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] userLoc = (JSPUtil.getParameter(request, prefix	+ "user_loc", length));
			String[] firstPagerows = (JSPUtil.getParameter(request, prefix	+ "first_pagerows", length));
			String[] userCnt = (JSPUtil.getParameter(request, prefix	+ "user_cnt", length));
			String[] issued = (JSPUtil.getParameter(request, prefix	+ "issued", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] deleted = (JSPUtil.getParameter(request, prefix	+ "deleted", length));
			String[] mhChk = (JSPUtil.getParameter(request, prefix	+ "mh_chk", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] stkJbDt = (JSPUtil.getParameter(request, prefix	+ "stk_jb_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] userOfc = (JSPUtil.getParameter(request, prefix	+ "user_ofc", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] deletedDt = (JSPUtil.getParameter(request, prefix	+ "deleted_dt", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sP = (JSPUtil.getParameter(request, prefix	+ "s_p", length));
			String[] issueFlag = (JSPUtil.getParameter(request, prefix	+ "issue_flag", length));
			String[] territory = (JSPUtil.getParameter(request, prefix	+ "territory", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] sendKey = (JSPUtil.getParameter(request, prefix	+ "send_key", length));
			String[] modeCd = (JSPUtil.getParameter(request, prefix	+ "mode_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mvmtCntrNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_cntr_no", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] jobSeq = (JSPUtil.getParameter(request, prefix	+ "job_seq", length));
			String[] shipOpr = (JSPUtil.getParameter(request, prefix	+ "ship_opr", length));
			String[] pdDate = (JSPUtil.getParameter(request, prefix	+ "pd_date", length));
			String[] emptyCy = (JSPUtil.getParameter(request, prefix	+ "empty_cy", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			String[] typeDisp = (JSPUtil.getParameter(request, prefix	+ "type_disp", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] faxEmailRst = (JSPUtil.getParameter(request, prefix	+ "fax_email_rst", length));
			String[] soOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cty_cd", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] orgEmptyCy = (JSPUtil.getParameter(request, prefix	+ "org_empty_cy", length));
			String[] emptyDest = (JSPUtil.getParameter(request, prefix	+ "empty_dest", length));
			String[] troChk = (JSPUtil.getParameter(request, prefix	+ "tro_chk", length));
			String[] mtRepoChk = (JSPUtil.getParameter(request, prefix	+ "mt_repo_chk", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] pdDateDisp = (JSPUtil.getParameter(request, prefix	+ "pd_date_disp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgChk = (JSPUtil.getParameter(request, prefix	+ "bkg_chk", length));
			String[] iOffice = (JSPUtil.getParameter(request, prefix	+ "i_office", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CimCStockVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (cb[i] != null)
					model.setCb(cb[i]);
				if (tp[i] != null)
					model.setTp(tp[i]);
				if (issueType[i] != null)
					model.setIssueType(issueType[i]);
				if (iType[i] != null)
					model.setIType(iType[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rowCnt[i] != null)
					model.setRowCnt(rowCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oQty[i] != null)
					model.setOQty(oQty[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (spclInst[i] != null)
					model.setSpclInst(spclInst[i]);
				if (bdDisp[i] != null)
					model.setBdDisp(bdDisp[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (stChk[i] != null)
					model.setStChk(stChk[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (bd[i] != null)
					model.setBd(bd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (userLoc[i] != null)
					model.setUserLoc(userLoc[i]);
				if (firstPagerows[i] != null)
					model.setFirstPagerows(firstPagerows[i]);
				if (userCnt[i] != null)
					model.setUserCnt(userCnt[i]);
				if (issued[i] != null)
					model.setIssued(issued[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (deleted[i] != null)
					model.setDeleted(deleted[i]);
				if (mhChk[i] != null)
					model.setMhChk(mhChk[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (stkJbDt[i] != null)
					model.setStkJbDt(stkJbDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (userOfc[i] != null)
					model.setUserOfc(userOfc[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (deletedDt[i] != null)
					model.setDeletedDt(deletedDt[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sP[i] != null)
					model.setSP(sP[i]);
				if (issueFlag[i] != null)
					model.setIssueFlag(issueFlag[i]);
				if (territory[i] != null)
					model.setTerritory(territory[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (sendKey[i] != null)
					model.setSendKey(sendKey[i]);
				if (modeCd[i] != null)
					model.setModeCd(modeCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mvmtCntrNo[i] != null)
					model.setMvmtCntrNo(mvmtCntrNo[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (jobSeq[i] != null)
					model.setJobSeq(jobSeq[i]);
				if (shipOpr[i] != null)
					model.setShipOpr(shipOpr[i]);
				if (pdDate[i] != null)
					model.setPdDate(pdDate[i]);
				if (emptyCy[i] != null)
					model.setEmptyCy(emptyCy[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				if (typeDisp[i] != null)
					model.setTypeDisp(typeDisp[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (faxEmailRst[i] != null)
					model.setFaxEmailRst(faxEmailRst[i]);
				if (soOfcCtyCd[i] != null)
					model.setSoOfcCtyCd(soOfcCtyCd[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (orgEmptyCy[i] != null)
					model.setOrgEmptyCy(orgEmptyCy[i]);
				if (emptyDest[i] != null)
					model.setEmptyDest(emptyDest[i]);
				if (troChk[i] != null)
					model.setTroChk(troChk[i]);
				if (mtRepoChk[i] != null)
					model.setMtRepoChk(mtRepoChk[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (pdDateDisp[i] != null)
					model.setPdDateDisp(pdDateDisp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgChk[i] != null)
					model.setBkgChk(bkgChk[i]);
				if (iOffice[i] != null)
					model.setIOffice(iOffice[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCimCStockVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CimCStockVO[]
	 */
	public CimCStockVO[] getCimCStockVOs(){
		CimCStockVO[] vos = (CimCStockVO[])models.toArray(new CimCStockVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cb = this.cb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tp = this.tp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType = this.issueType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iType = this.iType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oQty = this.oQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInst = this.spclInst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdDisp = this.bdDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stChk = this.stChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bd = this.bd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userLoc = this.userLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPagerows = this.firstPagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userCnt = this.userCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issued = this.issued .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleted = this.deleted .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mhChk = this.mhChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkJbDt = this.stkJbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfc = this.userOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deletedDt = this.deletedDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sP = this.sP .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueFlag = this.issueFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.territory = this.territory .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendKey = this.sendKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeCd = this.modeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCntrNo = this.mvmtCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobSeq = this.jobSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipOpr = this.shipOpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdDate = this.pdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyCy = this.emptyCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeDisp = this.typeDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEmailRst = this.faxEmailRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCtyCd = this.soOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEmptyCy = this.orgEmptyCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyDest = this.emptyDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troChk = this.troChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRepoChk = this.mtRepoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdDateDisp = this.pdDateDisp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChk = this.bkgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOffice = this.iOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
