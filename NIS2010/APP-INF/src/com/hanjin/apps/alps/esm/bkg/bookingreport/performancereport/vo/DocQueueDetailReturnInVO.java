/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueDetailReturnInVO.java
*@FileTitle : DocQueueDetailReturnInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.13 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueDetailReturnInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueDetailReturnInVO> models = new ArrayList<DocQueueDetailReturnInVO>();
	
	/* Column Info */
	private String emlCpyToCustFlg = null;
	/* Column Info */
	private String grpCd = null;
	/* Column Info */
	private String rsnCustInfoFlg = null;
	/* Column Info */
	private String rsnBbCgoFlg = null;
	/* Column Info */
	private String rsnCntrFlg = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String foRcvEml = null;
	/* Column Info */
	private String raterEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String foInclEmlFlg = null;
	/* Column Info */
	private String uiGrpCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rsnFrtChgFlg = null;
	/* Column Info */
	private String rsnNewBkgFlg = null;
	/* Column Info */
	private String rsnCntrMfFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rsnBlInfoFlg = null;
	/* Column Info */
	private String srProcStsCd = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String emlSndYn = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String rsnRlyPortFlg = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String upDt = null;
	/* Column Info */
	private String rsnRcFlg = null;
	/* Column Info */
	private String rtnToUsrEml = null;
	/* Column Info */
	private String stDt = null;
	/* Column Info */
	private String rsnBkgMnFlg = null;
	/* Column Info */
	private String rsnHblFlg = null;
	/* Column Info */
	private String custEml = null;
	/* Column Info */
	private String rsnAwkCgoFlg = null;
	/* Column Info */
	private String rtnFreq = null;
	/* Column Info */
	private String fntOfcEml = null;
	/* Column Info */
	private String srHisSeq = null;
	/* Column Info */
	private String message = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custVerifFlg = null;
	/* Column Info */
	private String inputerEml = null;
	/* Column Info */
	private String rsnDcgoFlg = null;
	/* Column Info */
	private String rtnSubject = null;
	/* Column Info */
	private String rsnSplitFlg = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String wrkStTm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueDetailReturnInVO() {}

	public DocQueueDetailReturnInVO(String ibflag, String pagerows, String srcCd, String srNo, String bkgNo, String srKndCd, String grpCd, String usrId, String uiGrpCd, String message, String rsnBkgMnFlg, String rsnCustInfoFlg, String rsnFrtChgFlg, String rsnCntrFlg, String rsnCntrMfFlg, String rsnDcgoFlg, String rsnAwkCgoFlg, String rsnRcFlg, String rsnBbCgoFlg, String rsnRlyPortFlg, String rsnNewBkgFlg, String rsnSplitFlg, String rsnBlInfoFlg, String rsnHblFlg, String custVerifFlg, String srHisSeq, String upDt, String rtnToUsrEml, String fntOfcEml, String inputerEml, String raterEml, String custEml, String emlSndYn, String rtnSubject, String emlSubjCtnt, String wrkStTm, String emlCpyToCustFlg, String stDt, String srStsCd, String srProcStsCd, String foInclEmlFlg, String rtnFreq, String foRcvEml, String srepEml) {
		this.emlCpyToCustFlg = emlCpyToCustFlg;
		this.grpCd = grpCd;
		this.rsnCustInfoFlg = rsnCustInfoFlg;
		this.rsnBbCgoFlg = rsnBbCgoFlg;
		this.rsnCntrFlg = rsnCntrFlg;
		this.srepEml = srepEml;
		this.foRcvEml = foRcvEml;
		this.raterEml = raterEml;
		this.pagerows = pagerows;
		this.foInclEmlFlg = foInclEmlFlg;
		this.uiGrpCd = uiGrpCd;
		this.srKndCd = srKndCd;
		this.ibflag = ibflag;
		this.rsnFrtChgFlg = rsnFrtChgFlg;
		this.rsnNewBkgFlg = rsnNewBkgFlg;
		this.rsnCntrMfFlg = rsnCntrMfFlg;
		this.usrId = usrId;
		this.rsnBlInfoFlg = rsnBlInfoFlg;
		this.srProcStsCd = srProcStsCd;
		this.srNo = srNo;
		this.emlSndYn = emlSndYn;
		this.srcCd = srcCd;
		this.rsnRlyPortFlg = rsnRlyPortFlg;
		this.srStsCd = srStsCd;
		this.upDt = upDt;
		this.rsnRcFlg = rsnRcFlg;
		this.rtnToUsrEml = rtnToUsrEml;
		this.stDt = stDt;
		this.rsnBkgMnFlg = rsnBkgMnFlg;
		this.rsnHblFlg = rsnHblFlg;
		this.custEml = custEml;
		this.rsnAwkCgoFlg = rsnAwkCgoFlg;
		this.rtnFreq = rtnFreq;
		this.fntOfcEml = fntOfcEml;
		this.srHisSeq = srHisSeq;
		this.message = message;
		this.bkgNo = bkgNo;
		this.custVerifFlg = custVerifFlg;
		this.inputerEml = inputerEml;
		this.rsnDcgoFlg = rsnDcgoFlg;
		this.rtnSubject = rtnSubject;
		this.rsnSplitFlg = rsnSplitFlg;
		this.emlSubjCtnt = emlSubjCtnt;
		this.wrkStTm = wrkStTm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml_cpy_to_cust_flg", getEmlCpyToCustFlg());
		this.hashColumns.put("grp_cd", getGrpCd());
		this.hashColumns.put("rsn_cust_info_flg", getRsnCustInfoFlg());
		this.hashColumns.put("rsn_bb_cgo_flg", getRsnBbCgoFlg());
		this.hashColumns.put("rsn_cntr_flg", getRsnCntrFlg());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("fo_rcv_eml", getFoRcvEml());
		this.hashColumns.put("rater_eml", getRaterEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fo_incl_eml_flg", getFoInclEmlFlg());
		this.hashColumns.put("ui_grp_cd", getUiGrpCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rsn_frt_chg_flg", getRsnFrtChgFlg());
		this.hashColumns.put("rsn_new_bkg_flg", getRsnNewBkgFlg());
		this.hashColumns.put("rsn_cntr_mf_flg", getRsnCntrMfFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rsn_bl_info_flg", getRsnBlInfoFlg());
		this.hashColumns.put("sr_proc_sts_cd", getSrProcStsCd());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("eml_snd_yn", getEmlSndYn());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("rsn_rly_port_flg", getRsnRlyPortFlg());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("up_dt", getUpDt());
		this.hashColumns.put("rsn_rc_flg", getRsnRcFlg());
		this.hashColumns.put("rtn_to_usr_eml", getRtnToUsrEml());
		this.hashColumns.put("st_dt", getStDt());
		this.hashColumns.put("rsn_bkg_mn_flg", getRsnBkgMnFlg());
		this.hashColumns.put("rsn_hbl_flg", getRsnHblFlg());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("rsn_awk_cgo_flg", getRsnAwkCgoFlg());
		this.hashColumns.put("rtn_freq", getRtnFreq());
		this.hashColumns.put("fnt_ofc_eml", getFntOfcEml());
		this.hashColumns.put("sr_his_seq", getSrHisSeq());
		this.hashColumns.put("message", getMessage());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_verif_flg", getCustVerifFlg());
		this.hashColumns.put("inputer_eml", getInputerEml());
		this.hashColumns.put("rsn_dcgo_flg", getRsnDcgoFlg());
		this.hashColumns.put("rtn_subject", getRtnSubject());
		this.hashColumns.put("rsn_split_flg", getRsnSplitFlg());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("wrk_st_tm", getWrkStTm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml_cpy_to_cust_flg", "emlCpyToCustFlg");
		this.hashFields.put("grp_cd", "grpCd");
		this.hashFields.put("rsn_cust_info_flg", "rsnCustInfoFlg");
		this.hashFields.put("rsn_bb_cgo_flg", "rsnBbCgoFlg");
		this.hashFields.put("rsn_cntr_flg", "rsnCntrFlg");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("fo_rcv_eml", "foRcvEml");
		this.hashFields.put("rater_eml", "raterEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fo_incl_eml_flg", "foInclEmlFlg");
		this.hashFields.put("ui_grp_cd", "uiGrpCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rsn_frt_chg_flg", "rsnFrtChgFlg");
		this.hashFields.put("rsn_new_bkg_flg", "rsnNewBkgFlg");
		this.hashFields.put("rsn_cntr_mf_flg", "rsnCntrMfFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rsn_bl_info_flg", "rsnBlInfoFlg");
		this.hashFields.put("sr_proc_sts_cd", "srProcStsCd");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("eml_snd_yn", "emlSndYn");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("rsn_rly_port_flg", "rsnRlyPortFlg");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("up_dt", "upDt");
		this.hashFields.put("rsn_rc_flg", "rsnRcFlg");
		this.hashFields.put("rtn_to_usr_eml", "rtnToUsrEml");
		this.hashFields.put("st_dt", "stDt");
		this.hashFields.put("rsn_bkg_mn_flg", "rsnBkgMnFlg");
		this.hashFields.put("rsn_hbl_flg", "rsnHblFlg");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("rsn_awk_cgo_flg", "rsnAwkCgoFlg");
		this.hashFields.put("rtn_freq", "rtnFreq");
		this.hashFields.put("fnt_ofc_eml", "fntOfcEml");
		this.hashFields.put("sr_his_seq", "srHisSeq");
		this.hashFields.put("message", "message");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_verif_flg", "custVerifFlg");
		this.hashFields.put("inputer_eml", "inputerEml");
		this.hashFields.put("rsn_dcgo_flg", "rsnDcgoFlg");
		this.hashFields.put("rtn_subject", "rtnSubject");
		this.hashFields.put("rsn_split_flg", "rsnSplitFlg");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("wrk_st_tm", "wrkStTm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return emlCpyToCustFlg
	 */
	public String getEmlCpyToCustFlg() {
		return this.emlCpyToCustFlg;
	}
	
	/**
	 * Column Info
	 * @return grpCd
	 */
	public String getGrpCd() {
		return this.grpCd;
	}
	
	/**
	 * Column Info
	 * @return rsnCustInfoFlg
	 */
	public String getRsnCustInfoFlg() {
		return this.rsnCustInfoFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnBbCgoFlg
	 */
	public String getRsnBbCgoFlg() {
		return this.rsnBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnCntrFlg
	 */
	public String getRsnCntrFlg() {
		return this.rsnCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
	}
	
	/**
	 * Column Info
	 * @return foRcvEml
	 */
	public String getFoRcvEml() {
		return this.foRcvEml;
	}
	
	/**
	 * Column Info
	 * @return raterEml
	 */
	public String getRaterEml() {
		return this.raterEml;
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
	 * @return foInclEmlFlg
	 */
	public String getFoInclEmlFlg() {
		return this.foInclEmlFlg;
	}
	
	/**
	 * Column Info
	 * @return uiGrpCd
	 */
	public String getUiGrpCd() {
		return this.uiGrpCd;
	}
	
	/**
	 * Column Info
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return rsnFrtChgFlg
	 */
	public String getRsnFrtChgFlg() {
		return this.rsnFrtChgFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnNewBkgFlg
	 */
	public String getRsnNewBkgFlg() {
		return this.rsnNewBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnCntrMfFlg
	 */
	public String getRsnCntrMfFlg() {
		return this.rsnCntrMfFlg;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return rsnBlInfoFlg
	 */
	public String getRsnBlInfoFlg() {
		return this.rsnBlInfoFlg;
	}
	
	/**
	 * Column Info
	 * @return srProcStsCd
	 */
	public String getSrProcStsCd() {
		return this.srProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Column Info
	 * @return emlSndYn
	 */
	public String getEmlSndYn() {
		return this.emlSndYn;
	}
	
	/**
	 * Column Info
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return rsnRlyPortFlg
	 */
	public String getRsnRlyPortFlg() {
		return this.rsnRlyPortFlg;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return upDt
	 */
	public String getUpDt() {
		return this.upDt;
	}
	
	/**
	 * Column Info
	 * @return rsnRcFlg
	 */
	public String getRsnRcFlg() {
		return this.rsnRcFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnToUsrEml
	 */
	public String getRtnToUsrEml() {
		return this.rtnToUsrEml;
	}
	
	/**
	 * Column Info
	 * @return stDt
	 */
	public String getStDt() {
		return this.stDt;
	}
	
	/**
	 * Column Info
	 * @return rsnBkgMnFlg
	 */
	public String getRsnBkgMnFlg() {
		return this.rsnBkgMnFlg;
	}
	
	/**
	 * Column Info
	 * @return rsnHblFlg
	 */
	public String getRsnHblFlg() {
		return this.rsnHblFlg;
	}
	
	/**
	 * Column Info
	 * @return custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 * Column Info
	 * @return rsnAwkCgoFlg
	 */
	public String getRsnAwkCgoFlg() {
		return this.rsnAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnFreq
	 */
	public String getRtnFreq() {
		return this.rtnFreq;
	}
	
	/**
	 * Column Info
	 * @return fntOfcEml
	 */
	public String getFntOfcEml() {
		return this.fntOfcEml;
	}
	
	/**
	 * Column Info
	 * @return srHisSeq
	 */
	public String getSrHisSeq() {
		return this.srHisSeq;
	}
	
	/**
	 * Column Info
	 * @return message
	 */
	public String getMessage() {
		return this.message;
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
	 * @return custVerifFlg
	 */
	public String getCustVerifFlg() {
		return this.custVerifFlg;
	}
	
	/**
	 * Column Info
	 * @return inputerEml
	 */
	public String getInputerEml() {
		return this.inputerEml;
	}
	
	/**
	 * Column Info
	 * @return rsnDcgoFlg
	 */
	public String getRsnDcgoFlg() {
		return this.rsnDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnSubject
	 */
	public String getRtnSubject() {
		return this.rtnSubject;
	}
	
	/**
	 * Column Info
	 * @return rsnSplitFlg
	 */
	public String getRsnSplitFlg() {
		return this.rsnSplitFlg;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return wrkStTm
	 */
	public String getWrkStTm() {
		return this.wrkStTm;
	}
	

	/**
	 * Column Info
	 * @param emlCpyToCustFlg
	 */
	public void setEmlCpyToCustFlg(String emlCpyToCustFlg) {
		this.emlCpyToCustFlg = emlCpyToCustFlg;
	}
	
	/**
	 * Column Info
	 * @param grpCd
	 */
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	
	/**
	 * Column Info
	 * @param rsnCustInfoFlg
	 */
	public void setRsnCustInfoFlg(String rsnCustInfoFlg) {
		this.rsnCustInfoFlg = rsnCustInfoFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnBbCgoFlg
	 */
	public void setRsnBbCgoFlg(String rsnBbCgoFlg) {
		this.rsnBbCgoFlg = rsnBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnCntrFlg
	 */
	public void setRsnCntrFlg(String rsnCntrFlg) {
		this.rsnCntrFlg = rsnCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}
	
	/**
	 * Column Info
	 * @param foRcvEml
	 */
	public void setFoRcvEml(String foRcvEml) {
		this.foRcvEml = foRcvEml;
	}
	
	/**
	 * Column Info
	 * @param raterEml
	 */
	public void setRaterEml(String raterEml) {
		this.raterEml = raterEml;
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
	 * @param foInclEmlFlg
	 */
	public void setFoInclEmlFlg(String foInclEmlFlg) {
		this.foInclEmlFlg = foInclEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param uiGrpCd
	 */
	public void setUiGrpCd(String uiGrpCd) {
		this.uiGrpCd = uiGrpCd;
	}
	
	/**
	 * Column Info
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param rsnFrtChgFlg
	 */
	public void setRsnFrtChgFlg(String rsnFrtChgFlg) {
		this.rsnFrtChgFlg = rsnFrtChgFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnNewBkgFlg
	 */
	public void setRsnNewBkgFlg(String rsnNewBkgFlg) {
		this.rsnNewBkgFlg = rsnNewBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnCntrMfFlg
	 */
	public void setRsnCntrMfFlg(String rsnCntrMfFlg) {
		this.rsnCntrMfFlg = rsnCntrMfFlg;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param rsnBlInfoFlg
	 */
	public void setRsnBlInfoFlg(String rsnBlInfoFlg) {
		this.rsnBlInfoFlg = rsnBlInfoFlg;
	}
	
	/**
	 * Column Info
	 * @param srProcStsCd
	 */
	public void setSrProcStsCd(String srProcStsCd) {
		this.srProcStsCd = srProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Column Info
	 * @param emlSndYn
	 */
	public void setEmlSndYn(String emlSndYn) {
		this.emlSndYn = emlSndYn;
	}
	
	/**
	 * Column Info
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param rsnRlyPortFlg
	 */
	public void setRsnRlyPortFlg(String rsnRlyPortFlg) {
		this.rsnRlyPortFlg = rsnRlyPortFlg;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param upDt
	 */
	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}
	
	/**
	 * Column Info
	 * @param rsnRcFlg
	 */
	public void setRsnRcFlg(String rsnRcFlg) {
		this.rsnRcFlg = rsnRcFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnToUsrEml
	 */
	public void setRtnToUsrEml(String rtnToUsrEml) {
		this.rtnToUsrEml = rtnToUsrEml;
	}
	
	/**
	 * Column Info
	 * @param stDt
	 */
	public void setStDt(String stDt) {
		this.stDt = stDt;
	}
	
	/**
	 * Column Info
	 * @param rsnBkgMnFlg
	 */
	public void setRsnBkgMnFlg(String rsnBkgMnFlg) {
		this.rsnBkgMnFlg = rsnBkgMnFlg;
	}
	
	/**
	 * Column Info
	 * @param rsnHblFlg
	 */
	public void setRsnHblFlg(String rsnHblFlg) {
		this.rsnHblFlg = rsnHblFlg;
	}
	
	/**
	 * Column Info
	 * @param custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * Column Info
	 * @param rsnAwkCgoFlg
	 */
	public void setRsnAwkCgoFlg(String rsnAwkCgoFlg) {
		this.rsnAwkCgoFlg = rsnAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnFreq
	 */
	public void setRtnFreq(String rtnFreq) {
		this.rtnFreq = rtnFreq;
	}
	
	/**
	 * Column Info
	 * @param fntOfcEml
	 */
	public void setFntOfcEml(String fntOfcEml) {
		this.fntOfcEml = fntOfcEml;
	}
	
	/**
	 * Column Info
	 * @param srHisSeq
	 */
	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
	}
	
	/**
	 * Column Info
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @param custVerifFlg
	 */
	public void setCustVerifFlg(String custVerifFlg) {
		this.custVerifFlg = custVerifFlg;
	}
	
	/**
	 * Column Info
	 * @param inputerEml
	 */
	public void setInputerEml(String inputerEml) {
		this.inputerEml = inputerEml;
	}
	
	/**
	 * Column Info
	 * @param rsnDcgoFlg
	 */
	public void setRsnDcgoFlg(String rsnDcgoFlg) {
		this.rsnDcgoFlg = rsnDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnSubject
	 */
	public void setRtnSubject(String rtnSubject) {
		this.rtnSubject = rtnSubject;
	}
	
	/**
	 * Column Info
	 * @param rsnSplitFlg
	 */
	public void setRsnSplitFlg(String rsnSplitFlg) {
		this.rsnSplitFlg = rsnSplitFlg;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param wrkStTm
	 */
	public void setWrkStTm(String wrkStTm) {
		this.wrkStTm = wrkStTm;
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
		setEmlCpyToCustFlg(JSPUtil.getParameter(request, prefix + "eml_cpy_to_cust_flg", ""));
		setGrpCd(JSPUtil.getParameter(request, prefix + "grp_cd", ""));
		setRsnCustInfoFlg(JSPUtil.getParameter(request, prefix + "rsn_cust_info_flg", ""));
		setRsnBbCgoFlg(JSPUtil.getParameter(request, prefix + "rsn_bb_cgo_flg", ""));
		setRsnCntrFlg(JSPUtil.getParameter(request, prefix + "rsn_cntr_flg", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setFoRcvEml(JSPUtil.getParameter(request, prefix + "fo_rcv_eml", ""));
		setRaterEml(JSPUtil.getParameter(request, prefix + "rater_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFoInclEmlFlg(JSPUtil.getParameter(request, prefix + "fo_incl_eml_flg", ""));
		setUiGrpCd(JSPUtil.getParameter(request, prefix + "ui_grp_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRsnFrtChgFlg(JSPUtil.getParameter(request, prefix + "rsn_frt_chg_flg", ""));
		setRsnNewBkgFlg(JSPUtil.getParameter(request, prefix + "rsn_new_bkg_flg", ""));
		setRsnCntrMfFlg(JSPUtil.getParameter(request, prefix + "rsn_cntr_mf_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRsnBlInfoFlg(JSPUtil.getParameter(request, prefix + "rsn_bl_info_flg", ""));
		setSrProcStsCd(JSPUtil.getParameter(request, prefix + "sr_proc_sts_cd", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setEmlSndYn(JSPUtil.getParameter(request, prefix + "eml_snd_yn", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setRsnRlyPortFlg(JSPUtil.getParameter(request, prefix + "rsn_rly_port_flg", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setUpDt(JSPUtil.getParameter(request, prefix + "up_dt", ""));
		setRsnRcFlg(JSPUtil.getParameter(request, prefix + "rsn_rc_flg", ""));
		setRtnToUsrEml(JSPUtil.getParameter(request, prefix + "rtn_to_usr_eml", ""));
		setStDt(JSPUtil.getParameter(request, prefix + "st_dt", ""));
		setRsnBkgMnFlg(JSPUtil.getParameter(request, prefix + "rsn_bkg_mn_flg", ""));
		setRsnHblFlg(JSPUtil.getParameter(request, prefix + "rsn_hbl_flg", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setRsnAwkCgoFlg(JSPUtil.getParameter(request, prefix + "rsn_awk_cgo_flg", ""));
		setRtnFreq(JSPUtil.getParameter(request, prefix + "rtn_freq", ""));
		setFntOfcEml(JSPUtil.getParameter(request, prefix + "fnt_ofc_eml", ""));
		setSrHisSeq(JSPUtil.getParameter(request, prefix + "sr_his_seq", ""));
		setMessage(JSPUtil.getParameter(request, prefix + "message", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustVerifFlg(JSPUtil.getParameter(request, prefix + "cust_verif_flg", ""));
		setInputerEml(JSPUtil.getParameter(request, prefix + "inputer_eml", ""));
		setRsnDcgoFlg(JSPUtil.getParameter(request, prefix + "rsn_dcgo_flg", ""));
		setRtnSubject(JSPUtil.getParameter(request, prefix + "rtn_subject", ""));
		setRsnSplitFlg(JSPUtil.getParameter(request, prefix + "rsn_split_flg", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setWrkStTm(JSPUtil.getParameter(request, prefix + "wrk_st_tm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueDetailReturnInVO[]
	 */
	public DocQueueDetailReturnInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueDetailReturnInVO[]
	 */
	public DocQueueDetailReturnInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueDetailReturnInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emlCpyToCustFlg = (JSPUtil.getParameter(request, prefix	+ "eml_cpy_to_cust_flg", length));
			String[] grpCd = (JSPUtil.getParameter(request, prefix	+ "grp_cd", length));
			String[] rsnCustInfoFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_cust_info_flg", length));
			String[] rsnBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_bb_cgo_flg", length));
			String[] rsnCntrFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_cntr_flg", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] foRcvEml = (JSPUtil.getParameter(request, prefix	+ "fo_rcv_eml", length));
			String[] raterEml = (JSPUtil.getParameter(request, prefix	+ "rater_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] foInclEmlFlg = (JSPUtil.getParameter(request, prefix	+ "fo_incl_eml_flg", length));
			String[] uiGrpCd = (JSPUtil.getParameter(request, prefix	+ "ui_grp_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rsnFrtChgFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_frt_chg_flg", length));
			String[] rsnNewBkgFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_new_bkg_flg", length));
			String[] rsnCntrMfFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_cntr_mf_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rsnBlInfoFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_bl_info_flg", length));
			String[] srProcStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_proc_sts_cd", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] emlSndYn = (JSPUtil.getParameter(request, prefix	+ "eml_snd_yn", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] rsnRlyPortFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_rly_port_flg", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] upDt = (JSPUtil.getParameter(request, prefix	+ "up_dt", length));
			String[] rsnRcFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_rc_flg", length));
			String[] rtnToUsrEml = (JSPUtil.getParameter(request, prefix	+ "rtn_to_usr_eml", length));
			String[] stDt = (JSPUtil.getParameter(request, prefix	+ "st_dt", length));
			String[] rsnBkgMnFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_bkg_mn_flg", length));
			String[] rsnHblFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_hbl_flg", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] rsnAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_awk_cgo_flg", length));
			String[] rtnFreq = (JSPUtil.getParameter(request, prefix	+ "rtn_freq", length));
			String[] fntOfcEml = (JSPUtil.getParameter(request, prefix	+ "fnt_ofc_eml", length));
			String[] srHisSeq = (JSPUtil.getParameter(request, prefix	+ "sr_his_seq", length));
			String[] message = (JSPUtil.getParameter(request, prefix	+ "message", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custVerifFlg = (JSPUtil.getParameter(request, prefix	+ "cust_verif_flg", length));
			String[] inputerEml = (JSPUtil.getParameter(request, prefix	+ "inputer_eml", length));
			String[] rsnDcgoFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_dcgo_flg", length));
			String[] rtnSubject = (JSPUtil.getParameter(request, prefix	+ "rtn_subject", length));
			String[] rsnSplitFlg = (JSPUtil.getParameter(request, prefix	+ "rsn_split_flg", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] wrkStTm = (JSPUtil.getParameter(request, prefix	+ "wrk_st_tm", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueDetailReturnInVO();
				if (emlCpyToCustFlg[i] != null)
					model.setEmlCpyToCustFlg(emlCpyToCustFlg[i]);
				if (grpCd[i] != null)
					model.setGrpCd(grpCd[i]);
				if (rsnCustInfoFlg[i] != null)
					model.setRsnCustInfoFlg(rsnCustInfoFlg[i]);
				if (rsnBbCgoFlg[i] != null)
					model.setRsnBbCgoFlg(rsnBbCgoFlg[i]);
				if (rsnCntrFlg[i] != null)
					model.setRsnCntrFlg(rsnCntrFlg[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (foRcvEml[i] != null)
					model.setFoRcvEml(foRcvEml[i]);
				if (raterEml[i] != null)
					model.setRaterEml(raterEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (foInclEmlFlg[i] != null)
					model.setFoInclEmlFlg(foInclEmlFlg[i]);
				if (uiGrpCd[i] != null)
					model.setUiGrpCd(uiGrpCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rsnFrtChgFlg[i] != null)
					model.setRsnFrtChgFlg(rsnFrtChgFlg[i]);
				if (rsnNewBkgFlg[i] != null)
					model.setRsnNewBkgFlg(rsnNewBkgFlg[i]);
				if (rsnCntrMfFlg[i] != null)
					model.setRsnCntrMfFlg(rsnCntrMfFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rsnBlInfoFlg[i] != null)
					model.setRsnBlInfoFlg(rsnBlInfoFlg[i]);
				if (srProcStsCd[i] != null)
					model.setSrProcStsCd(srProcStsCd[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (emlSndYn[i] != null)
					model.setEmlSndYn(emlSndYn[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (rsnRlyPortFlg[i] != null)
					model.setRsnRlyPortFlg(rsnRlyPortFlg[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (upDt[i] != null)
					model.setUpDt(upDt[i]);
				if (rsnRcFlg[i] != null)
					model.setRsnRcFlg(rsnRcFlg[i]);
				if (rtnToUsrEml[i] != null)
					model.setRtnToUsrEml(rtnToUsrEml[i]);
				if (stDt[i] != null)
					model.setStDt(stDt[i]);
				if (rsnBkgMnFlg[i] != null)
					model.setRsnBkgMnFlg(rsnBkgMnFlg[i]);
				if (rsnHblFlg[i] != null)
					model.setRsnHblFlg(rsnHblFlg[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (rsnAwkCgoFlg[i] != null)
					model.setRsnAwkCgoFlg(rsnAwkCgoFlg[i]);
				if (rtnFreq[i] != null)
					model.setRtnFreq(rtnFreq[i]);
				if (fntOfcEml[i] != null)
					model.setFntOfcEml(fntOfcEml[i]);
				if (srHisSeq[i] != null)
					model.setSrHisSeq(srHisSeq[i]);
				if (message[i] != null)
					model.setMessage(message[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custVerifFlg[i] != null)
					model.setCustVerifFlg(custVerifFlg[i]);
				if (inputerEml[i] != null)
					model.setInputerEml(inputerEml[i]);
				if (rsnDcgoFlg[i] != null)
					model.setRsnDcgoFlg(rsnDcgoFlg[i]);
				if (rtnSubject[i] != null)
					model.setRtnSubject(rtnSubject[i]);
				if (rsnSplitFlg[i] != null)
					model.setRsnSplitFlg(rsnSplitFlg[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (wrkStTm[i] != null)
					model.setWrkStTm(wrkStTm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueDetailReturnInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueDetailReturnInVO[]
	 */
	public DocQueueDetailReturnInVO[] getDocQueueDetailReturnInVOs(){
		DocQueueDetailReturnInVO[] vos = (DocQueueDetailReturnInVO[])models.toArray(new DocQueueDetailReturnInVO[models.size()]);
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
		this.emlCpyToCustFlg = this.emlCpyToCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCd = this.grpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCustInfoFlg = this.rsnCustInfoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnBbCgoFlg = this.rsnBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCntrFlg = this.rsnCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foRcvEml = this.foRcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raterEml = this.raterEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foInclEmlFlg = this.foInclEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiGrpCd = this.uiGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnFrtChgFlg = this.rsnFrtChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnNewBkgFlg = this.rsnNewBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCntrMfFlg = this.rsnCntrMfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnBlInfoFlg = this.rsnBlInfoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srProcStsCd = this.srProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndYn = this.emlSndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnRlyPortFlg = this.rsnRlyPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upDt = this.upDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnRcFlg = this.rsnRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnToUsrEml = this.rtnToUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDt = this.stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnBkgMnFlg = this.rsnBkgMnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnHblFlg = this.rsnHblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnAwkCgoFlg = this.rsnAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFreq = this.rtnFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntOfcEml = this.fntOfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srHisSeq = this.srHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.message = this.message .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVerifFlg = this.custVerifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputerEml = this.inputerEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnDcgoFlg = this.rsnDcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnSubject = this.rtnSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnSplitFlg = this.rsnSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkStTm = this.wrkStTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
