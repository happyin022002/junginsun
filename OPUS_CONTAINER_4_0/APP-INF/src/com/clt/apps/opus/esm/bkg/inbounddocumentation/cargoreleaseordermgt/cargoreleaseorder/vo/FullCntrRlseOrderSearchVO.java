/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCntrRlseOrderSerchVO.java
*@FileTitle : FullCntrRlseOrderSerchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.04 손윤석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FullCntrRlseOrderSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderSearchVO> models = new ArrayList<FullCntrRlseOrderSearchVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String pCustNm = null;
	/* Column Info */
	private String pErr = null;
	/* Column Info */
	private String pSendDate = null;
	/* Column Info */
	private String inChecktype = null;
	/* Column Info */
	private String pLocNm = null;
	/* Column Info */
	private String pDoNo = null;
	/* Column Info */
	private String pYdCd = null;
	/* Column Info */
	private String pDiffRmk = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inBlNo = null;
	/* Column Info */
	private String pYdNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pBlNo = null;
	/* Column Info */
	private String pDestTrnsModCd = null;
	/* Column Info */
	private String inOption = null;
	/* Column Info */
	private String pDeTermCd = null;
	/* Column Info */
	private String pPolCd = null;
	/* Column Info */
	private String pCntrNo = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String pSentFlg = null;
	/* Column Info */
	private String pCxlFlg = null;
	/* Column Info */
	private String pYdEml = null;
	/* Column Info */
	private String inDoNo = null;
	/* Column Info */
	private String pFaxNo = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String pCgoPkupDt = null;
	/* Column Info */
	private String pDoNoYn = null;
	/* Column Info */
	private String pVslNm = null;
	/* Column Info */
	private String pPhnNo = null;
	/* Column Info */
	private String pCntrTpszCd = null;
	/* Column Info */
	private String pBkgNo = null;
	
	/* Login 사용자 ID */
	private String usrId = null;
	
	/* Login 사용자 Office 코드 */
	private String usrOfcCd = null;
	
	/* Login 사용자 국가 코드 */
	private String cntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseOrderSearchVO() {}

	public FullCntrRlseOrderSearchVO(String ibflag, String pagerows, String inCntrNo, String inVvd, String inPod, String inBlNo, String inDoNo, String inOption, String inChecktype, String pDiffRmk, String pErr, String pBlNo, String pBkgNo, String pCntrNo, String pCntrTpszCd, String pCustNm, String pYdCd, String pVvd, String pPolCd, String pPodCd, String pDoNoYn, String pDoNo, String pFaxNo, String pDestTrnsModCd, String pCgoPkupDt, String pCxlFlg, String pDeTermCd, String pSentFlg, String pSendDate, String pYdNm, String pYdEml, String pPhnNo, String pVslNm, String pLocNm,String usrId,String usrOfcCd,String cntCd) {
		this.inVvd = inVvd;
		this.inPod = inPod;
		this.pCustNm = pCustNm;
		this.pErr = pErr;
		this.pSendDate = pSendDate;
		this.inChecktype = inChecktype;
		this.pLocNm = pLocNm;
		this.pDoNo = pDoNo;
		this.pYdCd = pYdCd;
		this.pDiffRmk = pDiffRmk;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
		this.inBlNo = inBlNo;
		this.pYdNm = pYdNm;
		this.ibflag = ibflag;
		this.pBlNo = pBlNo;
		this.pDestTrnsModCd = pDestTrnsModCd;
		this.inOption = inOption;
		this.pDeTermCd = pDeTermCd;
		this.pPolCd = pPolCd;
		this.pCntrNo = pCntrNo;
		this.pVvd = pVvd;
		this.pSentFlg = pSentFlg;
		this.pCxlFlg = pCxlFlg;
		this.pYdEml = pYdEml;
		this.inDoNo = inDoNo;
		this.pFaxNo = pFaxNo;
		this.pPodCd = pPodCd;
		this.pCgoPkupDt = pCgoPkupDt;
		this.pDoNoYn = pDoNoYn;
		this.pVslNm = pVslNm;
		this.pPhnNo = pPhnNo;
		this.pCntrTpszCd = pCntrTpszCd;
		this.pBkgNo = pBkgNo;
		this.usrId = usrId;
		this.usrOfcCd = usrOfcCd;
		this.cntCd = cntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("p_cust_nm", getPCustNm());
		this.hashColumns.put("p_err", getPErr());
		this.hashColumns.put("p_send_date", getPSendDate());
		this.hashColumns.put("in_checktype", getInChecktype());
		this.hashColumns.put("p_loc_nm", getPLocNm());
		this.hashColumns.put("p_do_no", getPDoNo());
		this.hashColumns.put("p_yd_cd", getPYdCd());
		this.hashColumns.put("p_diff_rmk", getPDiffRmk());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_bl_no", getInBlNo());
		this.hashColumns.put("p_yd_nm", getPYdNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_bl_no", getPBlNo());
		this.hashColumns.put("p_dest_trns_mod_cd", getPDestTrnsModCd());
		this.hashColumns.put("in_option", getInOption());
		this.hashColumns.put("p_de_term_cd", getPDeTermCd());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		this.hashColumns.put("p_cntr_no", getPCntrNo());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("p_sent_flg", getPSentFlg());
		this.hashColumns.put("p_cxl_flg", getPCxlFlg());
		this.hashColumns.put("p_yd_eml", getPYdEml());
		this.hashColumns.put("in_do_no", getInDoNo());
		this.hashColumns.put("p_fax_no", getPFaxNo());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("p_cgo_pkup_dt", getPCgoPkupDt());
		this.hashColumns.put("p_do_no_yn", getPDoNoYn());
		this.hashColumns.put("p_vsl_nm", getPVslNm());
		this.hashColumns.put("p_phn_no", getPPhnNo());
		this.hashColumns.put("p_cntr_tpsz_cd", getPCntrTpszCd());
		this.hashColumns.put("p_bkg_no", getPBkgNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("p_cust_nm", "pCustNm");
		this.hashFields.put("p_err", "pErr");
		this.hashFields.put("p_send_date", "pSendDate");
		this.hashFields.put("in_checktype", "inChecktype");
		this.hashFields.put("p_loc_nm", "pLocNm");
		this.hashFields.put("p_do_no", "pDoNo");
		this.hashFields.put("p_yd_cd", "pYdCd");
		this.hashFields.put("p_diff_rmk", "pDiffRmk");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_bl_no", "inBlNo");
		this.hashFields.put("p_yd_nm", "pYdNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_bl_no", "pBlNo");
		this.hashFields.put("p_dest_trns_mod_cd", "pDestTrnsModCd");
		this.hashFields.put("in_option", "inOption");
		this.hashFields.put("p_de_term_cd", "pDeTermCd");
		this.hashFields.put("p_pol_cd", "pPolCd");
		this.hashFields.put("p_cntr_no", "pCntrNo");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("p_sent_flg", "pSentFlg");
		this.hashFields.put("p_cxl_flg", "pCxlFlg");
		this.hashFields.put("p_yd_eml", "pYdEml");
		this.hashFields.put("in_do_no", "inDoNo");
		this.hashFields.put("p_fax_no", "pFaxNo");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("p_cgo_pkup_dt", "pCgoPkupDt");
		this.hashFields.put("p_do_no_yn", "pDoNoYn");
		this.hashFields.put("p_vsl_nm", "pVslNm");
		this.hashFields.put("p_phn_no", "pPhnNo");
		this.hashFields.put("p_cntr_tpsz_cd", "pCntrTpszCd");
		this.hashFields.put("p_bkg_no", "pBkgNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}
	
	/**
	 * Column Info
	 * @return pCustNm
	 */
	public String getPCustNm() {
		return this.pCustNm;
	}
	
	/**
	 * Column Info
	 * @return pErr
	 */
	public String getPErr() {
		return this.pErr;
	}
	
	/**
	 * Column Info
	 * @return pSendDate
	 */
	public String getPSendDate() {
		return this.pSendDate;
	}
	
	/**
	 * Column Info
	 * @return inChecktype
	 */
	public String getInChecktype() {
		return this.inChecktype;
	}
	
	/**
	 * Column Info
	 * @return pLocNm
	 */
	public String getPLocNm() {
		return this.pLocNm;
	}
	
	/**
	 * Column Info
	 * @return pDoNo
	 */
	public String getPDoNo() {
		return this.pDoNo;
	}
	
	/**
	 * Column Info
	 * @return pYdCd
	 */
	public String getPYdCd() {
		return this.pYdCd;
	}
	
	/**
	 * Column Info
	 * @return pDiffRmk
	 */
	public String getPDiffRmk() {
		return this.pDiffRmk;
	}
	
	/**
	 * Column Info
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return inBlNo
	 */
	public String getInBlNo() {
		return this.inBlNo;
	}
	
	/**
	 * Column Info
	 * @return pYdNm
	 */
	public String getPYdNm() {
		return this.pYdNm;
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
	 * @return pBlNo
	 */
	public String getPBlNo() {
		return this.pBlNo;
	}
	
	/**
	 * Column Info
	 * @return pDestTrnsModCd
	 */
	public String getPDestTrnsModCd() {
		return this.pDestTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return inOption
	 */
	public String getInOption() {
		return this.inOption;
	}
	
	/**
	 * Column Info
	 * @return pDeTermCd
	 */
	public String getPDeTermCd() {
		return this.pDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	
	/**
	 * Column Info
	 * @return pCntrNo
	 */
	public String getPCntrNo() {
		return this.pCntrNo;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return pSentFlg
	 */
	public String getPSentFlg() {
		return this.pSentFlg;
	}
	
	/**
	 * Column Info
	 * @return pCxlFlg
	 */
	public String getPCxlFlg() {
		return this.pCxlFlg;
	}
	
	/**
	 * Column Info
	 * @return pYdEml
	 */
	public String getPYdEml() {
		return this.pYdEml;
	}
	
	/**
	 * Column Info
	 * @return inDoNo
	 */
	public String getInDoNo() {
		return this.inDoNo;
	}
	
	/**
	 * Column Info
	 * @return pFaxNo
	 */
	public String getPFaxNo() {
		return this.pFaxNo;
	}
	
	/**
	 * Column Info
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return pCgoPkupDt
	 */
	public String getPCgoPkupDt() {
		return this.pCgoPkupDt;
	}
	
	/**
	 * Column Info
	 * @return pDoNoYn
	 */
	public String getPDoNoYn() {
		return this.pDoNoYn;
	}
	
	/**
	 * Column Info
	 * @return pVslNm
	 */
	public String getPVslNm() {
		return this.pVslNm;
	}
	
	/**
	 * Column Info
	 * @return pPhnNo
	 */
	public String getPPhnNo() {
		return this.pPhnNo;
	}
	
	/**
	 * Column Info
	 * @return pCntrTpszCd
	 */
	public String getPCntrTpszCd() {
		return this.pCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pBkgNo
	 */
	public String getPBkgNo() {
		return this.pBkgNo;
	}
	/**
	 * 로그인 사용자 아이디
	 * @return inVvd
	 */
	public String getUsrId() {
		return this.usrId;
	}
	/**
	 * 로그인 사용자 Office 코드
	 * @return inVvd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	/**
	 * 로그인 사용자 국가 코드
	 * @return inVvd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	
	
	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}
	
	/**
	 * Column Info
	 * @param pCustNm
	 */
	public void setPCustNm(String pCustNm) {
		this.pCustNm = pCustNm;
	}
	
	/**
	 * Column Info
	 * @param pErr
	 */
	public void setPErr(String pErr) {
		this.pErr = pErr;
	}
	
	/**
	 * Column Info
	 * @param pSendDate
	 */
	public void setPSendDate(String pSendDate) {
		this.pSendDate = pSendDate;
	}
	
	/**
	 * Column Info
	 * @param inChecktype
	 */
	public void setInChecktype(String inChecktype) {
		this.inChecktype = inChecktype;
	}
	
	/**
	 * Column Info
	 * @param pLocNm
	 */
	public void setPLocNm(String pLocNm) {
		this.pLocNm = pLocNm;
	}
	
	/**
	 * Column Info
	 * @param pDoNo
	 */
	public void setPDoNo(String pDoNo) {
		this.pDoNo = pDoNo;
	}
	
	/**
	 * Column Info
	 * @param pYdCd
	 */
	public void setPYdCd(String pYdCd) {
		this.pYdCd = pYdCd;
	}
	
	/**
	 * Column Info
	 * @param pDiffRmk
	 */
	public void setPDiffRmk(String pDiffRmk) {
		this.pDiffRmk = pDiffRmk;
	}
	
	/**
	 * Column Info
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param inBlNo
	 */
	public void setInBlNo(String inBlNo) {
		this.inBlNo = inBlNo;
	}
	
	/**
	 * Column Info
	 * @param pYdNm
	 */
	public void setPYdNm(String pYdNm) {
		this.pYdNm = pYdNm;
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
	 * @param pBlNo
	 */
	public void setPBlNo(String pBlNo) {
		this.pBlNo = pBlNo;
	}
	
	/**
	 * Column Info
	 * @param pDestTrnsModCd
	 */
	public void setPDestTrnsModCd(String pDestTrnsModCd) {
		this.pDestTrnsModCd = pDestTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param inOption
	 */
	public void setInOption(String inOption) {
		this.inOption = inOption;
	}
	
	/**
	 * Column Info
	 * @param pDeTermCd
	 */
	public void setPDeTermCd(String pDeTermCd) {
		this.pDeTermCd = pDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
	}
	
	/**
	 * Column Info
	 * @param pCntrNo
	 */
	public void setPCntrNo(String pCntrNo) {
		this.pCntrNo = pCntrNo;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param pSentFlg
	 */
	public void setPSentFlg(String pSentFlg) {
		this.pSentFlg = pSentFlg;
	}
	
	/**
	 * Column Info
	 * @param pCxlFlg
	 */
	public void setPCxlFlg(String pCxlFlg) {
		this.pCxlFlg = pCxlFlg;
	}
	
	/**
	 * Column Info
	 * @param pYdEml
	 */
	public void setPYdEml(String pYdEml) {
		this.pYdEml = pYdEml;
	}
	
	/**
	 * Column Info
	 * @param inDoNo
	 */
	public void setInDoNo(String inDoNo) {
		this.inDoNo = inDoNo;
	}
	
	/**
	 * Column Info
	 * @param pFaxNo
	 */
	public void setPFaxNo(String pFaxNo) {
		this.pFaxNo = pFaxNo;
	}
	
	/**
	 * Column Info
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param pCgoPkupDt
	 */
	public void setPCgoPkupDt(String pCgoPkupDt) {
		this.pCgoPkupDt = pCgoPkupDt;
	}
	
	/**
	 * Column Info
	 * @param pDoNoYn
	 */
	public void setPDoNoYn(String pDoNoYn) {
		this.pDoNoYn = pDoNoYn;
	}
	
	/**
	 * Column Info
	 * @param pVslNm
	 */
	public void setPVslNm(String pVslNm) {
		this.pVslNm = pVslNm;
	}
	
	/**
	 * Column Info
	 * @param pPhnNo
	 */
	public void setPPhnNo(String pPhnNo) {
		this.pPhnNo = pPhnNo;
	}
	
	/**
	 * Column Info
	 * @param pCntrTpszCd
	 */
	public void setPCntrTpszCd(String pCntrTpszCd) {
		this.pCntrTpszCd = pCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pBkgNo
	 */
	public void setPBkgNo(String pBkgNo) {
		this.pBkgNo = pBkgNo;
	}
	
	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	/**
	 * Column cntCd
	 * @param inVvd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setInPod(JSPUtil.getParameter(request, "in_pod", ""));
		setPCustNm(JSPUtil.getParameter(request, "p_cust_nm", ""));
		setPErr(JSPUtil.getParameter(request, "p_err", ""));
		setPSendDate(JSPUtil.getParameter(request, "p_send_date", ""));
		setInChecktype(JSPUtil.getParameter(request, "in_checktype", ""));
		setPLocNm(JSPUtil.getParameter(request, "p_loc_nm", ""));
		setPDoNo(JSPUtil.getParameter(request, "p_do_no", ""));
		setPYdCd(JSPUtil.getParameter(request, "p_yd_cd", ""));
		setPDiffRmk(JSPUtil.getParameter(request, "p_diff_rmk", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInBlNo(JSPUtil.getParameter(request, "in_bl_no", ""));
		setPYdNm(JSPUtil.getParameter(request, "p_yd_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPBlNo(JSPUtil.getParameter(request, "p_bl_no", ""));
		setPDestTrnsModCd(JSPUtil.getParameter(request, "p_dest_trns_mod_cd", ""));
		setInOption(JSPUtil.getParameter(request, "in_option", ""));
		setPDeTermCd(JSPUtil.getParameter(request, "p_de_term_cd", ""));
		setPPolCd(JSPUtil.getParameter(request, "p_pol_cd", ""));
		setPCntrNo(JSPUtil.getParameter(request, "p_cntr_no", ""));
		setPVvd(JSPUtil.getParameter(request, "p_vvd", ""));
		setPSentFlg(JSPUtil.getParameter(request, "p_sent_flg", ""));
		setPCxlFlg(JSPUtil.getParameter(request, "p_cxl_flg", ""));
		setPYdEml(JSPUtil.getParameter(request, "p_yd_eml", ""));
		setInDoNo(JSPUtil.getParameter(request, "in_do_no", ""));
		setPFaxNo(JSPUtil.getParameter(request, "p_fax_no", ""));
		setPPodCd(JSPUtil.getParameter(request, "p_pod_cd", ""));
		setPCgoPkupDt(JSPUtil.getParameter(request, "p_cgo_pkup_dt", ""));
		setPDoNoYn(JSPUtil.getParameter(request, "p_do_no_yn", ""));
		setPVslNm(JSPUtil.getParameter(request, "p_vsl_nm", ""));
		setPPhnNo(JSPUtil.getParameter(request, "p_phn_no", ""));
		setPCntrTpszCd(JSPUtil.getParameter(request, "p_cntr_tpsz_cd", ""));
		setPBkgNo(JSPUtil.getParameter(request, "p_bkg_no", ""));		
		setPPhnNo(JSPUtil.getParameter(request, "usr_id", ""));
		setPCntrTpszCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setPBkgNo(JSPUtil.getParameter(request, "cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseOrderSearchVO[]
	 */
	public FullCntrRlseOrderSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseOrderSearchVO[]
	 */
	public FullCntrRlseOrderSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrderSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] pCustNm = (JSPUtil.getParameter(request, prefix	+ "p_cust_nm", length));
			String[] pErr = (JSPUtil.getParameter(request, prefix	+ "p_err", length));
			String[] pSendDate = (JSPUtil.getParameter(request, prefix	+ "p_send_date", length));
			String[] inChecktype = (JSPUtil.getParameter(request, prefix	+ "in_checktype", length));
			String[] pLocNm = (JSPUtil.getParameter(request, prefix	+ "p_loc_nm", length));
			String[] pDoNo = (JSPUtil.getParameter(request, prefix	+ "p_do_no", length));
			String[] pYdCd = (JSPUtil.getParameter(request, prefix	+ "p_yd_cd", length));
			String[] pDiffRmk = (JSPUtil.getParameter(request, prefix	+ "p_diff_rmk", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inBlNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_no", length));
			String[] pYdNm = (JSPUtil.getParameter(request, prefix	+ "p_yd_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pBlNo = (JSPUtil.getParameter(request, prefix	+ "p_bl_no", length));
			String[] pDestTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "p_dest_trns_mod_cd", length));
			String[] inOption = (JSPUtil.getParameter(request, prefix	+ "in_option", length));
			String[] pDeTermCd = (JSPUtil.getParameter(request, prefix	+ "p_de_term_cd", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			String[] pCntrNo = (JSPUtil.getParameter(request, prefix	+ "p_cntr_no", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] pSentFlg = (JSPUtil.getParameter(request, prefix	+ "p_sent_flg", length));
			String[] pCxlFlg = (JSPUtil.getParameter(request, prefix	+ "p_cxl_flg", length));
			String[] pYdEml = (JSPUtil.getParameter(request, prefix	+ "p_yd_eml", length));
			String[] inDoNo = (JSPUtil.getParameter(request, prefix	+ "in_do_no", length));
			String[] pFaxNo = (JSPUtil.getParameter(request, prefix	+ "p_fax_no", length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd", length));
			String[] pCgoPkupDt = (JSPUtil.getParameter(request, prefix	+ "p_cgo_pkup_dt", length));
			String[] pDoNoYn = (JSPUtil.getParameter(request, prefix	+ "p_do_no_yn", length));
			String[] pVslNm = (JSPUtil.getParameter(request, prefix	+ "p_vsl_nm", length));
			String[] pPhnNo = (JSPUtil.getParameter(request, prefix	+ "p_phn_no", length));
			String[] pCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_cntr_tpsz_cd", length));
			String[] pBkgNo = (JSPUtil.getParameter(request, prefix	+ "p_bkg_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrderSearchVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (pCustNm[i] != null)
					model.setPCustNm(pCustNm[i]);
				if (pErr[i] != null)
					model.setPErr(pErr[i]);
				if (pSendDate[i] != null)
					model.setPSendDate(pSendDate[i]);
				if (inChecktype[i] != null)
					model.setInChecktype(inChecktype[i]);
				if (pLocNm[i] != null)
					model.setPLocNm(pLocNm[i]);
				if (pDoNo[i] != null)
					model.setPDoNo(pDoNo[i]);
				if (pYdCd[i] != null)
					model.setPYdCd(pYdCd[i]);
				if (pDiffRmk[i] != null)
					model.setPDiffRmk(pDiffRmk[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inBlNo[i] != null)
					model.setInBlNo(inBlNo[i]);
				if (pYdNm[i] != null)
					model.setPYdNm(pYdNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pBlNo[i] != null)
					model.setPBlNo(pBlNo[i]);
				if (pDestTrnsModCd[i] != null)
					model.setPDestTrnsModCd(pDestTrnsModCd[i]);
				if (inOption[i] != null)
					model.setInOption(inOption[i]);
				if (pDeTermCd[i] != null)
					model.setPDeTermCd(pDeTermCd[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				if (pCntrNo[i] != null)
					model.setPCntrNo(pCntrNo[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (pSentFlg[i] != null)
					model.setPSentFlg(pSentFlg[i]);
				if (pCxlFlg[i] != null)
					model.setPCxlFlg(pCxlFlg[i]);
				if (pYdEml[i] != null)
					model.setPYdEml(pYdEml[i]);
				if (inDoNo[i] != null)
					model.setInDoNo(inDoNo[i]);
				if (pFaxNo[i] != null)
					model.setPFaxNo(pFaxNo[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (pCgoPkupDt[i] != null)
					model.setPCgoPkupDt(pCgoPkupDt[i]);
				if (pDoNoYn[i] != null)
					model.setPDoNoYn(pDoNoYn[i]);
				if (pVslNm[i] != null)
					model.setPVslNm(pVslNm[i]);
				if (pPhnNo[i] != null)
					model.setPPhnNo(pPhnNo[i]);
				if (pCntrTpszCd[i] != null)
					model.setPCntrTpszCd(pCntrTpszCd[i]);
				if (pBkgNo[i] != null)
					model.setPBkgNo(pBkgNo[i]);				
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseOrderSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseOrderSearchVO[]
	 */
	public FullCntrRlseOrderSearchVO[] getFullCntrRlseOrderSearchVOs(){
		FullCntrRlseOrderSearchVO[] vos = (FullCntrRlseOrderSearchVO[])models.toArray(new FullCntrRlseOrderSearchVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustNm = this.pCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErr = this.pErr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSendDate = this.pSendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChecktype = this.inChecktype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocNm = this.pLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDoNo = this.pDoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYdCd = this.pYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDiffRmk = this.pDiffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlNo = this.inBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYdNm = this.pYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBlNo = this.pBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDestTrnsModCd = this.pDestTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOption = this.inOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDeTermCd = this.pDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrNo = this.pCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSentFlg = this.pSentFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCxlFlg = this.pCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYdEml = this.pYdEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDoNo = this.inDoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFaxNo = this.pFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCgoPkupDt = this.pCgoPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDoNoYn = this.pDoNoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVslNm = this.pVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPhnNo = this.pPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrTpszCd = this.pCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgNo = this.pBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
