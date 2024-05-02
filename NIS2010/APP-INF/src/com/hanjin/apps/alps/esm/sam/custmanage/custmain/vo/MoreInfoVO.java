/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : MoreInfoVO.java
*@FileTitle : MoreInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.11 박찬민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박찬민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MoreInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MoreInfoVO> models = new ArrayList<MoreInfoVO>();
	
	/* Column Info */
	private String mjrN1stTrdCd = null;
	/* Column Info */
	private String indusTpN2ndDesc = null;
	/* Column Info */
	private String prfCntrTpszCd = null;
	/* Column Info */
	private String custSlaFlg = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String nvoccBdEndEffDt = null;
	/* Column Info */
	private String nvoccCoScacCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nvoccBdAmt = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String bkgAltToDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String mjrN2ndTrdCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String indusTpN1stDesc = null;
	/* Column Info */
	private String chkCmdtCd = null;
	/* Column Info */
	private String cmptDesc = null;
	/* Column Info */
	private String prfN1stRepCmdtCd = null;
	/* Column Info */
	private String nvoccLicNo = null;
	/* Column Info */
	private String nvoccBdStEffDt = null;
	/* Column Info */
	private String custRmk = null;
	/* Column Info */
	private String bkgAltMsg = null;
	/* Column Info */
	private String custUrl = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String nvoccBdNo = null;
	/* Column Info */
	private String prfN2ndCmdtGrpDtl = null;
	/* Column Info */
	private String spclReqDesc = null;
	/* Column Info */
	private String prfN2ndRepCmdtCd = null;
	/* Column Info */
	private String yryVolQty = null;
	/* Column Info */
	private String bkgAltFmDt = null;
	/* Column Info */
	private String bkgAltRsn = null;
	/* Column Info */
	private String prfN1stCmdtGrpDtl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MoreInfoVO() {}

	public MoreInfoVO(String ibflag, String pagerows, String nvoccCoScacCd, String nvoccLicNo, String nvoccBdNo, String nvoccBdAmt, String nvoccBdStEffDt, String nvoccBdEndEffDt, String crAmt, String crCltOfcCd, String ibCrTermDys, String obCrTermDys, String indusTpN1stDesc, String mjrN1stTrdCd, String mjrN2ndTrdCd, String indusTpN2ndDesc, String prfN1stRepCmdtCd, String prfN1stCmdtGrpDtl, String cmptDesc, String prfN2ndRepCmdtCd, String prfN2ndCmdtGrpDtl, String spclReqDesc, String custRmk, String prfCntrTpszCd, String yryVolQty, String custSlaFlg, String bkgAltRsn, String custUrl, String bkgAltMsg, String bkgAltFmDt, String bkgAltToDt, String userId, String custCd, String chkCmdtCd) {
		this.mjrN1stTrdCd = mjrN1stTrdCd;
		this.indusTpN2ndDesc = indusTpN2ndDesc;
		this.prfCntrTpszCd = prfCntrTpszCd;
		this.custSlaFlg = custSlaFlg;
		this.obCrTermDys = obCrTermDys;
		this.crCltOfcCd = crCltOfcCd;
		this.nvoccBdEndEffDt = nvoccBdEndEffDt;
		this.nvoccCoScacCd = nvoccCoScacCd;
		this.pagerows = pagerows;
		this.nvoccBdAmt = nvoccBdAmt;
		this.ibCrTermDys = ibCrTermDys;
		this.bkgAltToDt = bkgAltToDt;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.mjrN2ndTrdCd = mjrN2ndTrdCd;
		this.userId = userId;
		this.indusTpN1stDesc = indusTpN1stDesc;
		this.chkCmdtCd = chkCmdtCd;
		this.cmptDesc = cmptDesc;
		this.prfN1stRepCmdtCd = prfN1stRepCmdtCd;
		this.nvoccLicNo = nvoccLicNo;
		this.nvoccBdStEffDt = nvoccBdStEffDt;
		this.custRmk = custRmk;
		this.bkgAltMsg = bkgAltMsg;
		this.custUrl = custUrl;
		this.custCd = custCd;
		this.nvoccBdNo = nvoccBdNo;
		this.prfN2ndCmdtGrpDtl = prfN2ndCmdtGrpDtl;
		this.spclReqDesc = spclReqDesc;
		this.prfN2ndRepCmdtCd = prfN2ndRepCmdtCd;
		this.yryVolQty = yryVolQty;
		this.bkgAltFmDt = bkgAltFmDt;
		this.bkgAltRsn = bkgAltRsn;
		this.prfN1stCmdtGrpDtl = prfN1stCmdtGrpDtl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mjr_n1st_trd_cd", getMjrN1stTrdCd());
		this.hashColumns.put("indus_tp_n2nd_desc", getIndusTpN2ndDesc());
		this.hashColumns.put("prf_cntr_tpsz_cd", getPrfCntrTpszCd());
		this.hashColumns.put("cust_sla_flg", getCustSlaFlg());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("nvocc_bd_end_eff_dt", getNvoccBdEndEffDt());
		this.hashColumns.put("nvocc_co_scac_cd", getNvoccCoScacCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nvocc_bd_amt", getNvoccBdAmt());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("bkg_alt_to_dt", getBkgAltToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("mjr_n2nd_trd_cd", getMjrN2ndTrdCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("indus_tp_n1st_desc", getIndusTpN1stDesc());
		this.hashColumns.put("chk_cmdt_cd", getChkCmdtCd());
		this.hashColumns.put("cmpt_desc", getCmptDesc());
		this.hashColumns.put("prf_n1st_rep_cmdt_cd", getPrfN1stRepCmdtCd());
		this.hashColumns.put("nvocc_lic_no", getNvoccLicNo());
		this.hashColumns.put("nvocc_bd_st_eff_dt", getNvoccBdStEffDt());
		this.hashColumns.put("cust_rmk", getCustRmk());
		this.hashColumns.put("bkg_alt_msg", getBkgAltMsg());
		this.hashColumns.put("cust_url", getCustUrl());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("nvocc_bd_no", getNvoccBdNo());
		this.hashColumns.put("prf_n2nd_cmdt_grp_dtl", getPrfN2ndCmdtGrpDtl());
		this.hashColumns.put("spcl_req_desc", getSpclReqDesc());
		this.hashColumns.put("prf_n2nd_rep_cmdt_cd", getPrfN2ndRepCmdtCd());
		this.hashColumns.put("yry_vol_qty", getYryVolQty());
		this.hashColumns.put("bkg_alt_fm_dt", getBkgAltFmDt());
		this.hashColumns.put("bkg_alt_rsn", getBkgAltRsn());
		this.hashColumns.put("prf_n1st_cmdt_grp_dtl", getPrfN1stCmdtGrpDtl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mjr_n1st_trd_cd", "mjrN1stTrdCd");
		this.hashFields.put("indus_tp_n2nd_desc", "indusTpN2ndDesc");
		this.hashFields.put("prf_cntr_tpsz_cd", "prfCntrTpszCd");
		this.hashFields.put("cust_sla_flg", "custSlaFlg");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("nvocc_bd_end_eff_dt", "nvoccBdEndEffDt");
		this.hashFields.put("nvocc_co_scac_cd", "nvoccCoScacCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nvocc_bd_amt", "nvoccBdAmt");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("bkg_alt_to_dt", "bkgAltToDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("mjr_n2nd_trd_cd", "mjrN2ndTrdCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("indus_tp_n1st_desc", "indusTpN1stDesc");
		this.hashFields.put("chk_cmdt_cd", "chkCmdtCd");
		this.hashFields.put("cmpt_desc", "cmptDesc");
		this.hashFields.put("prf_n1st_rep_cmdt_cd", "prfN1stRepCmdtCd");
		this.hashFields.put("nvocc_lic_no", "nvoccLicNo");
		this.hashFields.put("nvocc_bd_st_eff_dt", "nvoccBdStEffDt");
		this.hashFields.put("cust_rmk", "custRmk");
		this.hashFields.put("bkg_alt_msg", "bkgAltMsg");
		this.hashFields.put("cust_url", "custUrl");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("nvocc_bd_no", "nvoccBdNo");
		this.hashFields.put("prf_n2nd_cmdt_grp_dtl", "prfN2ndCmdtGrpDtl");
		this.hashFields.put("spcl_req_desc", "spclReqDesc");
		this.hashFields.put("prf_n2nd_rep_cmdt_cd", "prfN2ndRepCmdtCd");
		this.hashFields.put("yry_vol_qty", "yryVolQty");
		this.hashFields.put("bkg_alt_fm_dt", "bkgAltFmDt");
		this.hashFields.put("bkg_alt_rsn", "bkgAltRsn");
		this.hashFields.put("prf_n1st_cmdt_grp_dtl", "prfN1stCmdtGrpDtl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mjrN1stTrdCd
	 */
	public String getMjrN1stTrdCd() {
		return this.mjrN1stTrdCd;
	}
	
	/**
	 * Column Info
	 * @return indusTpN2ndDesc
	 */
	public String getIndusTpN2ndDesc() {
		return this.indusTpN2ndDesc;
	}
	
	/**
	 * Column Info
	 * @return prfCntrTpszCd
	 */
	public String getPrfCntrTpszCd() {
		return this.prfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return custSlaFlg
	 */
	public String getCustSlaFlg() {
		return this.custSlaFlg;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdEndEffDt
	 */
	public String getNvoccBdEndEffDt() {
		return this.nvoccBdEndEffDt;
	}
	
	/**
	 * Column Info
	 * @return nvoccCoScacCd
	 */
	public String getNvoccCoScacCd() {
		return this.nvoccCoScacCd;
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
	 * @return nvoccBdAmt
	 */
	public String getNvoccBdAmt() {
		return this.nvoccBdAmt;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return bkgAltToDt
	 */
	public String getBkgAltToDt() {
		return this.bkgAltToDt;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return mjrN2ndTrdCd
	 */
	public String getMjrN2ndTrdCd() {
		return this.mjrN2ndTrdCd;
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
	 * @return indusTpN1stDesc
	 */
	public String getIndusTpN1stDesc() {
		return this.indusTpN1stDesc;
	}
	
	/**
	 * Column Info
	 * @return chkCmdtCd
	 */
	public String getChkCmdtCd() {
		return this.chkCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmptDesc
	 */
	public String getCmptDesc() {
		return this.cmptDesc;
	}
	
	/**
	 * Column Info
	 * @return prfN1stRepCmdtCd
	 */
	public String getPrfN1stRepCmdtCd() {
		return this.prfN1stRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccLicNo
	 */
	public String getNvoccLicNo() {
		return this.nvoccLicNo;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdStEffDt
	 */
	public String getNvoccBdStEffDt() {
		return this.nvoccBdStEffDt;
	}
	
	/**
	 * Column Info
	 * @return custRmk
	 */
	public String getCustRmk() {
		return this.custRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgAltMsg
	 */
	public String getBkgAltMsg() {
		return this.bkgAltMsg;
	}
	
	/**
	 * Column Info
	 * @return custUrl
	 */
	public String getCustUrl() {
		return this.custUrl;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return nvoccBdNo
	 */
	public String getNvoccBdNo() {
		return this.nvoccBdNo;
	}
	
	/**
	 * Column Info
	 * @return prfN2ndCmdtGrpDtl
	 */
	public String getPrfN2ndCmdtGrpDtl() {
		return this.prfN2ndCmdtGrpDtl;
	}
	
	/**
	 * Column Info
	 * @return spclReqDesc
	 */
	public String getSpclReqDesc() {
		return this.spclReqDesc;
	}
	
	/**
	 * Column Info
	 * @return prfN2ndRepCmdtCd
	 */
	public String getPrfN2ndRepCmdtCd() {
		return this.prfN2ndRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return yryVolQty
	 */
	public String getYryVolQty() {
		return this.yryVolQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAltFmDt
	 */
	public String getBkgAltFmDt() {
		return this.bkgAltFmDt;
	}
	
	/**
	 * Column Info
	 * @return bkgAltRsn
	 */
	public String getBkgAltRsn() {
		return this.bkgAltRsn;
	}
	
	/**
	 * Column Info
	 * @return prfN1stCmdtGrpDtl
	 */
	public String getPrfN1stCmdtGrpDtl() {
		return this.prfN1stCmdtGrpDtl;
	}
	

	/**
	 * Column Info
	 * @param mjrN1stTrdCd
	 */
	public void setMjrN1stTrdCd(String mjrN1stTrdCd) {
		this.mjrN1stTrdCd = mjrN1stTrdCd;
	}
	
	/**
	 * Column Info
	 * @param indusTpN2ndDesc
	 */
	public void setIndusTpN2ndDesc(String indusTpN2ndDesc) {
		this.indusTpN2ndDesc = indusTpN2ndDesc;
	}
	
	/**
	 * Column Info
	 * @param prfCntrTpszCd
	 */
	public void setPrfCntrTpszCd(String prfCntrTpszCd) {
		this.prfCntrTpszCd = prfCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param custSlaFlg
	 */
	public void setCustSlaFlg(String custSlaFlg) {
		this.custSlaFlg = custSlaFlg;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param nvoccBdEndEffDt
	 */
	public void setNvoccBdEndEffDt(String nvoccBdEndEffDt) {
		this.nvoccBdEndEffDt = nvoccBdEndEffDt;
	}
	
	/**
	 * Column Info
	 * @param nvoccCoScacCd
	 */
	public void setNvoccCoScacCd(String nvoccCoScacCd) {
		this.nvoccCoScacCd = nvoccCoScacCd;
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
	 * @param nvoccBdAmt
	 */
	public void setNvoccBdAmt(String nvoccBdAmt) {
		this.nvoccBdAmt = nvoccBdAmt;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param bkgAltToDt
	 */
	public void setBkgAltToDt(String bkgAltToDt) {
		this.bkgAltToDt = bkgAltToDt;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param mjrN2ndTrdCd
	 */
	public void setMjrN2ndTrdCd(String mjrN2ndTrdCd) {
		this.mjrN2ndTrdCd = mjrN2ndTrdCd;
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
	 * @param indusTpN1stDesc
	 */
	public void setIndusTpN1stDesc(String indusTpN1stDesc) {
		this.indusTpN1stDesc = indusTpN1stDesc;
	}
	
	/**
	 * Column Info
	 * @param chkCmdtCd
	 */
	public void setChkCmdtCd(String chkCmdtCd) {
		this.chkCmdtCd = chkCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmptDesc
	 */
	public void setCmptDesc(String cmptDesc) {
		this.cmptDesc = cmptDesc;
	}
	
	/**
	 * Column Info
	 * @param prfN1stRepCmdtCd
	 */
	public void setPrfN1stRepCmdtCd(String prfN1stRepCmdtCd) {
		this.prfN1stRepCmdtCd = prfN1stRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param nvoccLicNo
	 */
	public void setNvoccLicNo(String nvoccLicNo) {
		this.nvoccLicNo = nvoccLicNo;
	}
	
	/**
	 * Column Info
	 * @param nvoccBdStEffDt
	 */
	public void setNvoccBdStEffDt(String nvoccBdStEffDt) {
		this.nvoccBdStEffDt = nvoccBdStEffDt;
	}
	
	/**
	 * Column Info
	 * @param custRmk
	 */
	public void setCustRmk(String custRmk) {
		this.custRmk = custRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgAltMsg
	 */
	public void setBkgAltMsg(String bkgAltMsg) {
		this.bkgAltMsg = bkgAltMsg;
	}
	
	/**
	 * Column Info
	 * @param custUrl
	 */
	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param nvoccBdNo
	 */
	public void setNvoccBdNo(String nvoccBdNo) {
		this.nvoccBdNo = nvoccBdNo;
	}
	
	/**
	 * Column Info
	 * @param prfN2ndCmdtGrpDtl
	 */
	public void setPrfN2ndCmdtGrpDtl(String prfN2ndCmdtGrpDtl) {
		this.prfN2ndCmdtGrpDtl = prfN2ndCmdtGrpDtl;
	}
	
	/**
	 * Column Info
	 * @param spclReqDesc
	 */
	public void setSpclReqDesc(String spclReqDesc) {
		this.spclReqDesc = spclReqDesc;
	}
	
	/**
	 * Column Info
	 * @param prfN2ndRepCmdtCd
	 */
	public void setPrfN2ndRepCmdtCd(String prfN2ndRepCmdtCd) {
		this.prfN2ndRepCmdtCd = prfN2ndRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param yryVolQty
	 */
	public void setYryVolQty(String yryVolQty) {
		this.yryVolQty = yryVolQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAltFmDt
	 */
	public void setBkgAltFmDt(String bkgAltFmDt) {
		this.bkgAltFmDt = bkgAltFmDt;
	}
	
	/**
	 * Column Info
	 * @param bkgAltRsn
	 */
	public void setBkgAltRsn(String bkgAltRsn) {
		this.bkgAltRsn = bkgAltRsn;
	}
	
	/**
	 * Column Info
	 * @param prfN1stCmdtGrpDtl
	 */
	public void setPrfN1stCmdtGrpDtl(String prfN1stCmdtGrpDtl) {
		this.prfN1stCmdtGrpDtl = prfN1stCmdtGrpDtl;
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
		setMjrN1stTrdCd(JSPUtil.getParameter(request, prefix + "mjr_n1st_trd_cd", ""));
		setIndusTpN2ndDesc(JSPUtil.getParameter(request, prefix + "indus_tp_n2nd_desc", ""));
		setPrfCntrTpszCd(JSPUtil.getParameter(request, prefix + "prf_cntr_tpsz_cd", ""));
		setCustSlaFlg(JSPUtil.getParameter(request, prefix + "cust_sla_flg", ""));
		setObCrTermDys(JSPUtil.getParameter(request, prefix + "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, prefix + "cr_clt_ofc_cd", ""));
		setNvoccBdEndEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_end_eff_dt", ""));
		setNvoccCoScacCd(JSPUtil.getParameter(request, prefix + "nvocc_co_scac_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNvoccBdAmt(JSPUtil.getParameter(request, prefix + "nvocc_bd_amt", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, prefix + "ib_cr_term_dys", ""));
		setBkgAltToDt(JSPUtil.getParameter(request, prefix + "bkg_alt_to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, prefix + "cr_amt", ""));
		setMjrN2ndTrdCd(JSPUtil.getParameter(request, prefix + "mjr_n2nd_trd_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setIndusTpN1stDesc(JSPUtil.getParameter(request, prefix + "indus_tp_n1st_desc", ""));
		setChkCmdtCd(JSPUtil.getParameter(request, prefix + "chk_cmdt_cd", ""));
		setCmptDesc(JSPUtil.getParameter(request, prefix + "cmpt_desc", ""));
		setPrfN1stRepCmdtCd(JSPUtil.getParameter(request, prefix + "prf_n1st_rep_cmdt_cd", ""));
		setNvoccLicNo(JSPUtil.getParameter(request, prefix + "nvocc_lic_no", ""));
		setNvoccBdStEffDt(JSPUtil.getParameter(request, prefix + "nvocc_bd_st_eff_dt", ""));
		setCustRmk(JSPUtil.getParameter(request, prefix + "cust_rmk", ""));
		setBkgAltMsg(JSPUtil.getParameter(request, prefix + "bkg_alt_msg", ""));
		setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setNvoccBdNo(JSPUtil.getParameter(request, prefix + "nvocc_bd_no", ""));
		setPrfN2ndCmdtGrpDtl(JSPUtil.getParameter(request, prefix + "prf_n2nd_cmdt_grp_dtl", ""));
		setSpclReqDesc(JSPUtil.getParameter(request, prefix + "spcl_req_desc", ""));
		setPrfN2ndRepCmdtCd(JSPUtil.getParameter(request, prefix + "prf_n2nd_rep_cmdt_cd", ""));
		setYryVolQty(JSPUtil.getParameter(request, prefix + "yry_vol_qty", ""));
		setBkgAltFmDt(JSPUtil.getParameter(request, prefix + "bkg_alt_fm_dt", ""));
		setBkgAltRsn(JSPUtil.getParameter(request, prefix + "bkg_alt_rsn", ""));
		setPrfN1stCmdtGrpDtl(JSPUtil.getParameter(request, prefix + "prf_n1st_cmdt_grp_dtl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MoreInfoVO[]
	 */
	public MoreInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MoreInfoVO[]
	 */
	public MoreInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MoreInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mjrN1stTrdCd = (JSPUtil.getParameter(request, prefix	+ "mjr_n1st_trd_cd", length));
			String[] indusTpN2ndDesc = (JSPUtil.getParameter(request, prefix	+ "indus_tp_n2nd_desc", length));
			String[] prfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "prf_cntr_tpsz_cd", length));
			String[] custSlaFlg = (JSPUtil.getParameter(request, prefix	+ "cust_sla_flg", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] nvoccBdEndEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_end_eff_dt", length));
			String[] nvoccCoScacCd = (JSPUtil.getParameter(request, prefix	+ "nvocc_co_scac_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nvoccBdAmt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_amt", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] bkgAltToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] mjrN2ndTrdCd = (JSPUtil.getParameter(request, prefix	+ "mjr_n2nd_trd_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] indusTpN1stDesc = (JSPUtil.getParameter(request, prefix	+ "indus_tp_n1st_desc", length));
			String[] chkCmdtCd = (JSPUtil.getParameter(request, prefix	+ "chk_cmdt_cd", length));
			String[] cmptDesc = (JSPUtil.getParameter(request, prefix	+ "cmpt_desc", length));
			String[] prfN1stRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_n1st_rep_cmdt_cd", length));
			String[] nvoccLicNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_lic_no", length));
			String[] nvoccBdStEffDt = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_st_eff_dt", length));
			String[] custRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rmk", length));
			String[] bkgAltMsg = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_msg", length));
			String[] custUrl = (JSPUtil.getParameter(request, prefix	+ "cust_url", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] nvoccBdNo = (JSPUtil.getParameter(request, prefix	+ "nvocc_bd_no", length));
			String[] prfN2ndCmdtGrpDtl = (JSPUtil.getParameter(request, prefix	+ "prf_n2nd_cmdt_grp_dtl", length));
			String[] spclReqDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_req_desc", length));
			String[] prfN2ndRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "prf_n2nd_rep_cmdt_cd", length));
			String[] yryVolQty = (JSPUtil.getParameter(request, prefix	+ "yry_vol_qty", length));
			String[] bkgAltFmDt = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_fm_dt", length));
			String[] bkgAltRsn = (JSPUtil.getParameter(request, prefix	+ "bkg_alt_rsn", length));
			String[] prfN1stCmdtGrpDtl = (JSPUtil.getParameter(request, prefix	+ "prf_n1st_cmdt_grp_dtl", length));
			
			for (int i = 0; i < length; i++) {
				model = new MoreInfoVO();
				if (mjrN1stTrdCd[i] != null)
					model.setMjrN1stTrdCd(mjrN1stTrdCd[i]);
				if (indusTpN2ndDesc[i] != null)
					model.setIndusTpN2ndDesc(indusTpN2ndDesc[i]);
				if (prfCntrTpszCd[i] != null)
					model.setPrfCntrTpszCd(prfCntrTpszCd[i]);
				if (custSlaFlg[i] != null)
					model.setCustSlaFlg(custSlaFlg[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (nvoccBdEndEffDt[i] != null)
					model.setNvoccBdEndEffDt(nvoccBdEndEffDt[i]);
				if (nvoccCoScacCd[i] != null)
					model.setNvoccCoScacCd(nvoccCoScacCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nvoccBdAmt[i] != null)
					model.setNvoccBdAmt(nvoccBdAmt[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (bkgAltToDt[i] != null)
					model.setBkgAltToDt(bkgAltToDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (mjrN2ndTrdCd[i] != null)
					model.setMjrN2ndTrdCd(mjrN2ndTrdCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (indusTpN1stDesc[i] != null)
					model.setIndusTpN1stDesc(indusTpN1stDesc[i]);
				if (chkCmdtCd[i] != null)
					model.setChkCmdtCd(chkCmdtCd[i]);
				if (cmptDesc[i] != null)
					model.setCmptDesc(cmptDesc[i]);
				if (prfN1stRepCmdtCd[i] != null)
					model.setPrfN1stRepCmdtCd(prfN1stRepCmdtCd[i]);
				if (nvoccLicNo[i] != null)
					model.setNvoccLicNo(nvoccLicNo[i]);
				if (nvoccBdStEffDt[i] != null)
					model.setNvoccBdStEffDt(nvoccBdStEffDt[i]);
				if (custRmk[i] != null)
					model.setCustRmk(custRmk[i]);
				if (bkgAltMsg[i] != null)
					model.setBkgAltMsg(bkgAltMsg[i]);
				if (custUrl[i] != null)
					model.setCustUrl(custUrl[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (nvoccBdNo[i] != null)
					model.setNvoccBdNo(nvoccBdNo[i]);
				if (prfN2ndCmdtGrpDtl[i] != null)
					model.setPrfN2ndCmdtGrpDtl(prfN2ndCmdtGrpDtl[i]);
				if (spclReqDesc[i] != null)
					model.setSpclReqDesc(spclReqDesc[i]);
				if (prfN2ndRepCmdtCd[i] != null)
					model.setPrfN2ndRepCmdtCd(prfN2ndRepCmdtCd[i]);
				if (yryVolQty[i] != null)
					model.setYryVolQty(yryVolQty[i]);
				if (bkgAltFmDt[i] != null)
					model.setBkgAltFmDt(bkgAltFmDt[i]);
				if (bkgAltRsn[i] != null)
					model.setBkgAltRsn(bkgAltRsn[i]);
				if (prfN1stCmdtGrpDtl[i] != null)
					model.setPrfN1stCmdtGrpDtl(prfN1stCmdtGrpDtl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMoreInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MoreInfoVO[]
	 */
	public MoreInfoVO[] getMoreInfoVOs(){
		MoreInfoVO[] vos = (MoreInfoVO[])models.toArray(new MoreInfoVO[models.size()]);
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
		this.mjrN1stTrdCd = this.mjrN1stTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indusTpN2ndDesc = this.indusTpN2ndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfCntrTpszCd = this.prfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSlaFlg = this.custSlaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdEndEffDt = this.nvoccBdEndEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccCoScacCd = this.nvoccCoScacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdAmt = this.nvoccBdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltToDt = this.bkgAltToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrN2ndTrdCd = this.mjrN2ndTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indusTpN1stDesc = this.indusTpN1stDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCmdtCd = this.chkCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmptDesc = this.cmptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfN1stRepCmdtCd = this.prfN1stRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccLicNo = this.nvoccLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdStEffDt = this.nvoccBdStEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRmk = this.custRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltMsg = this.bkgAltMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custUrl = this.custUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccBdNo = this.nvoccBdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfN2ndCmdtGrpDtl = this.prfN2ndCmdtGrpDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclReqDesc = this.spclReqDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfN2ndRepCmdtCd = this.prfN2ndRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yryVolQty = this.yryVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltFmDt = this.bkgAltFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAltRsn = this.bkgAltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prfN1stCmdtGrpDtl = this.prfN1stCmdtGrpDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
