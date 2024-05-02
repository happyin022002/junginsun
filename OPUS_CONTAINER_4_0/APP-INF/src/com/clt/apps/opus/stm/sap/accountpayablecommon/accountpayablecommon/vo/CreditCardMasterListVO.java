/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CreditCardMasterListVO.java
*@FileTitle : CreditCardMasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class CreditCardMasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditCardMasterListVO> models = new ArrayList<CreditCardMasterListVO>();
	
	/* Column Info */
	private String crdDeptNm = null;
	/* Column Info */
	private String crdNo = null;
	/* Column Info */
	private String crdEmpeNo = null;
	/* Column Info */
	private String coaAcctCd = null;
	/* Column Info */
	private String coaInterCoCd = null;
	/* Column Info */
	private String crdSeq = null;
	/* Column Info */
	private String coaRgnCd = null;
	/* Column Info */
	private String crdCdCmbSeq = null;
	/* Column Info */
	private String crdBrndLuCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crdPgmCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String crdDtrbOfcCd = null;
	/* Column Info */
	private String crdTpLuCd = null;
	/* Column Info */
	private String crdPgmNm = null;
	/* Column Info */
	private String crdExpDt = null;
	/* Column Info */
	private String coaCtrCd = null;
	/* Column Info */
	private String crdMbrNm = null;
	/* Column Info */
	private String crdInactDt = null;
	/* Column Info */
	private String coaVvdCd = null;
	/* Column Info */
	private String coaCoCd = null;
	/* Column Info */
	private String crdDtrbDt = null;
	/* Column Info */
	private String crdDesc = null;
	/* Column Info */
	private String crdPgmCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CreditCardMasterListVO() {}

	public CreditCardMasterListVO(String ibflag, String pagerows, String crdSeq, String crdNo, String crdPgmNm, String crdPgmCd, String crdTpLuCd, String crdPgmCurrCd, String vndrNo, String vndrNm, String crdBrndLuCd, String crdCdCmbSeq, String coaCoCd, String coaRgnCd, String coaCtrCd, String coaAcctCd, String coaInterCoCd, String coaVvdCd, String crdMbrNm, String crdDeptNm, String crdDtrbOfcCd, String crdDtrbDt, String crdInactDt, String crdExpDt, String crdDesc, String crdEmpeNo, String usrId) {
		this.crdDeptNm = crdDeptNm;
		this.crdNo = crdNo;
		this.crdEmpeNo = crdEmpeNo;
		this.coaAcctCd = coaAcctCd;
		this.coaInterCoCd = coaInterCoCd;
		this.crdSeq = crdSeq;
		this.coaRgnCd = coaRgnCd;
		this.crdCdCmbSeq = crdCdCmbSeq;
		this.crdBrndLuCd = crdBrndLuCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.vndrNo = vndrNo;
		this.ibflag = ibflag;
		this.crdPgmCd = crdPgmCd;
		this.usrId = usrId;
		this.crdDtrbOfcCd = crdDtrbOfcCd;
		this.crdTpLuCd = crdTpLuCd;
		this.crdPgmNm = crdPgmNm;
		this.crdExpDt = crdExpDt;
		this.coaCtrCd = coaCtrCd;
		this.crdMbrNm = crdMbrNm;
		this.crdInactDt = crdInactDt;
		this.coaVvdCd = coaVvdCd;
		this.coaCoCd = coaCoCd;
		this.crdDtrbDt = crdDtrbDt;
		this.crdDesc = crdDesc;
		this.crdPgmCurrCd = crdPgmCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crd_dept_nm", getCrdDeptNm());
		this.hashColumns.put("crd_no", getCrdNo());
		this.hashColumns.put("crd_empe_no", getCrdEmpeNo());
		this.hashColumns.put("coa_acct_cd", getCoaAcctCd());
		this.hashColumns.put("coa_inter_co_cd", getCoaInterCoCd());
		this.hashColumns.put("crd_seq", getCrdSeq());
		this.hashColumns.put("coa_rgn_cd", getCoaRgnCd());
		this.hashColumns.put("crd_cd_cmb_seq", getCrdCdCmbSeq());
		this.hashColumns.put("crd_brnd_lu_cd", getCrdBrndLuCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crd_pgm_cd", getCrdPgmCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("crd_dtrb_ofc_cd", getCrdDtrbOfcCd());
		this.hashColumns.put("crd_tp_lu_cd", getCrdTpLuCd());
		this.hashColumns.put("crd_pgm_nm", getCrdPgmNm());
		this.hashColumns.put("crd_exp_dt", getCrdExpDt());
		this.hashColumns.put("coa_ctr_cd", getCoaCtrCd());
		this.hashColumns.put("crd_mbr_nm", getCrdMbrNm());
		this.hashColumns.put("crd_inact_dt", getCrdInactDt());
		this.hashColumns.put("coa_vvd_cd", getCoaVvdCd());
		this.hashColumns.put("coa_co_cd", getCoaCoCd());
		this.hashColumns.put("crd_dtrb_dt", getCrdDtrbDt());
		this.hashColumns.put("crd_desc", getCrdDesc());
		this.hashColumns.put("crd_pgm_curr_cd", getCrdPgmCurrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crd_dept_nm", "crdDeptNm");
		this.hashFields.put("crd_no", "crdNo");
		this.hashFields.put("crd_empe_no", "crdEmpeNo");
		this.hashFields.put("coa_acct_cd", "coaAcctCd");
		this.hashFields.put("coa_inter_co_cd", "coaInterCoCd");
		this.hashFields.put("crd_seq", "crdSeq");
		this.hashFields.put("coa_rgn_cd", "coaRgnCd");
		this.hashFields.put("crd_cd_cmb_seq", "crdCdCmbSeq");
		this.hashFields.put("crd_brnd_lu_cd", "crdBrndLuCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crd_pgm_cd", "crdPgmCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("crd_dtrb_ofc_cd", "crdDtrbOfcCd");
		this.hashFields.put("crd_tp_lu_cd", "crdTpLuCd");
		this.hashFields.put("crd_pgm_nm", "crdPgmNm");
		this.hashFields.put("crd_exp_dt", "crdExpDt");
		this.hashFields.put("coa_ctr_cd", "coaCtrCd");
		this.hashFields.put("crd_mbr_nm", "crdMbrNm");
		this.hashFields.put("crd_inact_dt", "crdInactDt");
		this.hashFields.put("coa_vvd_cd", "coaVvdCd");
		this.hashFields.put("coa_co_cd", "coaCoCd");
		this.hashFields.put("crd_dtrb_dt", "crdDtrbDt");
		this.hashFields.put("crd_desc", "crdDesc");
		this.hashFields.put("crd_pgm_curr_cd", "crdPgmCurrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crdDeptNm
	 */
	public String getCrdDeptNm() {
		return this.crdDeptNm;
	}
	
	/**
	 * Column Info
	 * @return crdNo
	 */
	public String getCrdNo() {
		return this.crdNo;
	}
	
	/**
	 * Column Info
	 * @return crdEmpeNo
	 */
	public String getCrdEmpeNo() {
		return this.crdEmpeNo;
	}
	
	/**
	 * Column Info
	 * @return coaAcctCd
	 */
	public String getCoaAcctCd() {
		return this.coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return coaInterCoCd
	 */
	public String getCoaInterCoCd() {
		return this.coaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return crdSeq
	 */
	public String getCrdSeq() {
		return this.crdSeq;
	}
	
	/**
	 * Column Info
	 * @return coaRgnCd
	 */
	public String getCoaRgnCd() {
		return this.coaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return crdCdCmbSeq
	 */
	public String getCrdCdCmbSeq() {
		return this.crdCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return crdBrndLuCd
	 */
	public String getCrdBrndLuCd() {
		return this.crdBrndLuCd;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return crdPgmCd
	 */
	public String getCrdPgmCd() {
		return this.crdPgmCd;
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
	 * @return crdDtrbOfcCd
	 */
	public String getCrdDtrbOfcCd() {
		return this.crdDtrbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return crdTpLuCd
	 */
	public String getCrdTpLuCd() {
		return this.crdTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return crdPgmNm
	 */
	public String getCrdPgmNm() {
		return this.crdPgmNm;
	}
	
	/**
	 * Column Info
	 * @return crdExpDt
	 */
	public String getCrdExpDt() {
		return this.crdExpDt;
	}
	
	/**
	 * Column Info
	 * @return coaCtrCd
	 */
	public String getCoaCtrCd() {
		return this.coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return crdMbrNm
	 */
	public String getCrdMbrNm() {
		return this.crdMbrNm;
	}
	
	/**
	 * Column Info
	 * @return crdInactDt
	 */
	public String getCrdInactDt() {
		return this.crdInactDt;
	}
	
	/**
	 * Column Info
	 * @return coaVvdCd
	 */
	public String getCoaVvdCd() {
		return this.coaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return coaCoCd
	 */
	public String getCoaCoCd() {
		return this.coaCoCd;
	}
	
	/**
	 * Column Info
	 * @return crdDtrbDt
	 */
	public String getCrdDtrbDt() {
		return this.crdDtrbDt;
	}
	
	/**
	 * Column Info
	 * @return crdDesc
	 */
	public String getCrdDesc() {
		return this.crdDesc;
	}
	
	/**
	 * Column Info
	 * @return crdPgmCurrCd
	 */
	public String getCrdPgmCurrCd() {
		return this.crdPgmCurrCd;
	}
	

	/**
	 * Column Info
	 * @param crdDeptNm
	 */
	public void setCrdDeptNm(String crdDeptNm) {
		this.crdDeptNm = crdDeptNm;
	}
	
	/**
	 * Column Info
	 * @param crdNo
	 */
	public void setCrdNo(String crdNo) {
		this.crdNo = crdNo;
	}
	
	/**
	 * Column Info
	 * @param crdEmpeNo
	 */
	public void setCrdEmpeNo(String crdEmpeNo) {
		this.crdEmpeNo = crdEmpeNo;
	}
	
	/**
	 * Column Info
	 * @param coaAcctCd
	 */
	public void setCoaAcctCd(String coaAcctCd) {
		this.coaAcctCd = coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param coaInterCoCd
	 */
	public void setCoaInterCoCd(String coaInterCoCd) {
		this.coaInterCoCd = coaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param crdSeq
	 */
	public void setCrdSeq(String crdSeq) {
		this.crdSeq = crdSeq;
	}
	
	/**
	 * Column Info
	 * @param coaRgnCd
	 */
	public void setCoaRgnCd(String coaRgnCd) {
		this.coaRgnCd = coaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param crdCdCmbSeq
	 */
	public void setCrdCdCmbSeq(String crdCdCmbSeq) {
		this.crdCdCmbSeq = crdCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param crdBrndLuCd
	 */
	public void setCrdBrndLuCd(String crdBrndLuCd) {
		this.crdBrndLuCd = crdBrndLuCd;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param crdPgmCd
	 */
	public void setCrdPgmCd(String crdPgmCd) {
		this.crdPgmCd = crdPgmCd;
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
	 * @param crdDtrbOfcCd
	 */
	public void setCrdDtrbOfcCd(String crdDtrbOfcCd) {
		this.crdDtrbOfcCd = crdDtrbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param crdTpLuCd
	 */
	public void setCrdTpLuCd(String crdTpLuCd) {
		this.crdTpLuCd = crdTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param crdPgmNm
	 */
	public void setCrdPgmNm(String crdPgmNm) {
		this.crdPgmNm = crdPgmNm;
	}
	
	/**
	 * Column Info
	 * @param crdExpDt
	 */
	public void setCrdExpDt(String crdExpDt) {
		this.crdExpDt = crdExpDt;
	}
	
	/**
	 * Column Info
	 * @param coaCtrCd
	 */
	public void setCoaCtrCd(String coaCtrCd) {
		this.coaCtrCd = coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param crdMbrNm
	 */
	public void setCrdMbrNm(String crdMbrNm) {
		this.crdMbrNm = crdMbrNm;
	}
	
	/**
	 * Column Info
	 * @param crdInactDt
	 */
	public void setCrdInactDt(String crdInactDt) {
		this.crdInactDt = crdInactDt;
	}
	
	/**
	 * Column Info
	 * @param coaVvdCd
	 */
	public void setCoaVvdCd(String coaVvdCd) {
		this.coaVvdCd = coaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param coaCoCd
	 */
	public void setCoaCoCd(String coaCoCd) {
		this.coaCoCd = coaCoCd;
	}
	
	/**
	 * Column Info
	 * @param crdDtrbDt
	 */
	public void setCrdDtrbDt(String crdDtrbDt) {
		this.crdDtrbDt = crdDtrbDt;
	}
	
	/**
	 * Column Info
	 * @param crdDesc
	 */
	public void setCrdDesc(String crdDesc) {
		this.crdDesc = crdDesc;
	}
	
	/**
	 * Column Info
	 * @param crdPgmCurrCd
	 */
	public void setCrdPgmCurrCd(String crdPgmCurrCd) {
		this.crdPgmCurrCd = crdPgmCurrCd;
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
		setCrdDeptNm(JSPUtil.getParameter(request, prefix + "crd_dept_nm", ""));
		setCrdNo(JSPUtil.getParameter(request, prefix + "crd_no", ""));
		setCrdEmpeNo(JSPUtil.getParameter(request, prefix + "crd_empe_no", ""));
		setCoaAcctCd(JSPUtil.getParameter(request, prefix + "coa_acct_cd", ""));
		setCoaInterCoCd(JSPUtil.getParameter(request, prefix + "coa_inter_co_cd", ""));
		setCrdSeq(JSPUtil.getParameter(request, prefix + "crd_seq", ""));
		setCoaRgnCd(JSPUtil.getParameter(request, prefix + "coa_rgn_cd", ""));
		setCrdCdCmbSeq(JSPUtil.getParameter(request, prefix + "crd_cd_cmb_seq", ""));
		setCrdBrndLuCd(JSPUtil.getParameter(request, prefix + "crd_brnd_lu_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrdPgmCd(JSPUtil.getParameter(request, prefix + "crd_pgm_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCrdDtrbOfcCd(JSPUtil.getParameter(request, prefix + "crd_dtrb_ofc_cd", ""));
		setCrdTpLuCd(JSPUtil.getParameter(request, prefix + "crd_tp_lu_cd", ""));
		setCrdPgmNm(JSPUtil.getParameter(request, prefix + "crd_pgm_nm", ""));
		setCrdExpDt(JSPUtil.getParameter(request, prefix + "crd_exp_dt", ""));
		setCoaCtrCd(JSPUtil.getParameter(request, prefix + "coa_ctr_cd", ""));
		setCrdMbrNm(JSPUtil.getParameter(request, prefix + "crd_mbr_nm", ""));
		setCrdInactDt(JSPUtil.getParameter(request, prefix + "crd_inact_dt", ""));
		setCoaVvdCd(JSPUtil.getParameter(request, prefix + "coa_vvd_cd", ""));
		setCoaCoCd(JSPUtil.getParameter(request, prefix + "coa_co_cd", ""));
		setCrdDtrbDt(JSPUtil.getParameter(request, prefix + "crd_dtrb_dt", ""));
		setCrdDesc(JSPUtil.getParameter(request, prefix + "crd_desc", ""));
		setCrdPgmCurrCd(JSPUtil.getParameter(request, prefix + "crd_pgm_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditCardMasterListVO[]
	 */
	public CreditCardMasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditCardMasterListVO[]
	 */
	public CreditCardMasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditCardMasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crdDeptNm = (JSPUtil.getParameter(request, prefix	+ "crd_dept_nm", length));
			String[] crdNo = (JSPUtil.getParameter(request, prefix	+ "crd_no", length));
			String[] crdEmpeNo = (JSPUtil.getParameter(request, prefix	+ "crd_empe_no", length));
			String[] coaAcctCd = (JSPUtil.getParameter(request, prefix	+ "coa_acct_cd", length));
			String[] coaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "coa_inter_co_cd", length));
			String[] crdSeq = (JSPUtil.getParameter(request, prefix	+ "crd_seq", length));
			String[] coaRgnCd = (JSPUtil.getParameter(request, prefix	+ "coa_rgn_cd", length));
			String[] crdCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "crd_cd_cmb_seq", length));
			String[] crdBrndLuCd = (JSPUtil.getParameter(request, prefix	+ "crd_brnd_lu_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crdPgmCd = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] crdDtrbOfcCd = (JSPUtil.getParameter(request, prefix	+ "crd_dtrb_ofc_cd", length));
			String[] crdTpLuCd = (JSPUtil.getParameter(request, prefix	+ "crd_tp_lu_cd", length));
			String[] crdPgmNm = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_nm", length));
			String[] crdExpDt = (JSPUtil.getParameter(request, prefix	+ "crd_exp_dt", length));
			String[] coaCtrCd = (JSPUtil.getParameter(request, prefix	+ "coa_ctr_cd", length));
			String[] crdMbrNm = (JSPUtil.getParameter(request, prefix	+ "crd_mbr_nm", length));
			String[] crdInactDt = (JSPUtil.getParameter(request, prefix	+ "crd_inact_dt", length));
			String[] coaVvdCd = (JSPUtil.getParameter(request, prefix	+ "coa_vvd_cd", length));
			String[] coaCoCd = (JSPUtil.getParameter(request, prefix	+ "coa_co_cd", length));
			String[] crdDtrbDt = (JSPUtil.getParameter(request, prefix	+ "crd_dtrb_dt", length));
			String[] crdDesc = (JSPUtil.getParameter(request, prefix	+ "crd_desc", length));
			String[] crdPgmCurrCd = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreditCardMasterListVO();
				if (crdDeptNm[i] != null)
					model.setCrdDeptNm(crdDeptNm[i]);
				if (crdNo[i] != null)
					model.setCrdNo(crdNo[i]);
				if (crdEmpeNo[i] != null)
					model.setCrdEmpeNo(crdEmpeNo[i]);
				if (coaAcctCd[i] != null)
					model.setCoaAcctCd(coaAcctCd[i]);
				if (coaInterCoCd[i] != null)
					model.setCoaInterCoCd(coaInterCoCd[i]);
				if (crdSeq[i] != null)
					model.setCrdSeq(crdSeq[i]);
				if (coaRgnCd[i] != null)
					model.setCoaRgnCd(coaRgnCd[i]);
				if (crdCdCmbSeq[i] != null)
					model.setCrdCdCmbSeq(crdCdCmbSeq[i]);
				if (crdBrndLuCd[i] != null)
					model.setCrdBrndLuCd(crdBrndLuCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crdPgmCd[i] != null)
					model.setCrdPgmCd(crdPgmCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (crdDtrbOfcCd[i] != null)
					model.setCrdDtrbOfcCd(crdDtrbOfcCd[i]);
				if (crdTpLuCd[i] != null)
					model.setCrdTpLuCd(crdTpLuCd[i]);
				if (crdPgmNm[i] != null)
					model.setCrdPgmNm(crdPgmNm[i]);
				if (crdExpDt[i] != null)
					model.setCrdExpDt(crdExpDt[i]);
				if (coaCtrCd[i] != null)
					model.setCoaCtrCd(coaCtrCd[i]);
				if (crdMbrNm[i] != null)
					model.setCrdMbrNm(crdMbrNm[i]);
				if (crdInactDt[i] != null)
					model.setCrdInactDt(crdInactDt[i]);
				if (coaVvdCd[i] != null)
					model.setCoaVvdCd(coaVvdCd[i]);
				if (coaCoCd[i] != null)
					model.setCoaCoCd(coaCoCd[i]);
				if (crdDtrbDt[i] != null)
					model.setCrdDtrbDt(crdDtrbDt[i]);
				if (crdDesc[i] != null)
					model.setCrdDesc(crdDesc[i]);
				if (crdPgmCurrCd[i] != null)
					model.setCrdPgmCurrCd(crdPgmCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditCardMasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditCardMasterListVO[]
	 */
	public CreditCardMasterListVO[] getCreditCardMasterListVOs(){
		CreditCardMasterListVO[] vos = (CreditCardMasterListVO[])models.toArray(new CreditCardMasterListVO[models.size()]);
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
		this.crdDeptNm = this.crdDeptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdNo = this.crdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdEmpeNo = this.crdEmpeNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaAcctCd = this.coaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaInterCoCd = this.coaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdSeq = this.crdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaRgnCd = this.coaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdCdCmbSeq = this.crdCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdBrndLuCd = this.crdBrndLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmCd = this.crdPgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDtrbOfcCd = this.crdDtrbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdTpLuCd = this.crdTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmNm = this.crdPgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdExpDt = this.crdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCtrCd = this.coaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdMbrNm = this.crdMbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdInactDt = this.crdInactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaVvdCd = this.coaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCoCd = this.coaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDtrbDt = this.crdDtrbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDesc = this.crdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmCurrCd = this.crdPgmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
