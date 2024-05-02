/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CreditCardListVO.java
*@FileTitle : CreditCardListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.08  
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

public class CreditCardListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreditCardListVO> models = new ArrayList<CreditCardListVO>();
	
	/* Column Info */
	private String crdDeptNm = null;
	/* Column Info */
	private String crdNo = null;
	/* Column Info */
	private String centerCode = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crdSeq = null;
	/* Column Info */
	private String intercompanycode = null;
	/* Column Info */
	private String crdBrndLuCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crdCdCmbSeq = null;
	/* Column Info */
	private String accountCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String crdPgmCd = null;
	/* Column Info */
	private String crdDtrbOfcCd = null;
	/* Column Info */
	private String vvdcode = null;
	/* Column Info */
	private String crdPgmNm = null;
	/* Column Info */
	private String crdTpLuCd = null;
	/* Column Info */
	private String regionCode = null;
	/* Column Info */
	private String crdExpDt = null;
	/* Column Info */
	private String crdMbrNm = null;
	/* Column Info */
	private String crdInactDt = null;
	/* Column Info */
	private String crdDtrbDt = null;
	/* Column Info */
	private String crdDesc = null;
	/* Column Info */
	private String companyCode = null;
	/* Column Info */
	private String crdPgmCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CreditCardListVO() {}

	public CreditCardListVO(String ibflag, String pagerows, String crdSeq, String crdNo, String crdPgmNm, String crdPgmCd, String crdPgmCurrCd, String crdBrndLuCd, String crdMbrNm, String crdDeptNm, String crdDtrbDt, String crdDtrbOfcCd, String crdInactDt, String crdTpLuCd, String vndrNo, String vndrLglEngNm, String crdCdCmbSeq, String companyCode, String regionCode, String centerCode, String accountCode, String intercompanycode, String vvdcode, String crdDesc, String crdExpDt) {
		this.crdDeptNm = crdDeptNm;
		this.crdNo = crdNo;
		this.centerCode = centerCode;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crdSeq = crdSeq;
		this.intercompanycode = intercompanycode;
		this.crdBrndLuCd = crdBrndLuCd;
		this.pagerows = pagerows;
		this.crdCdCmbSeq = crdCdCmbSeq;
		this.accountCode = accountCode;
		this.ibflag = ibflag;
		this.vndrNo = vndrNo;
		this.crdPgmCd = crdPgmCd;
		this.crdDtrbOfcCd = crdDtrbOfcCd;
		this.vvdcode = vvdcode;
		this.crdPgmNm = crdPgmNm;
		this.crdTpLuCd = crdTpLuCd;
		this.regionCode = regionCode;
		this.crdExpDt = crdExpDt;
		this.crdMbrNm = crdMbrNm;
		this.crdInactDt = crdInactDt;
		this.crdDtrbDt = crdDtrbDt;
		this.crdDesc = crdDesc;
		this.companyCode = companyCode;
		this.crdPgmCurrCd = crdPgmCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crd_dept_nm", getCrdDeptNm());
		this.hashColumns.put("crd_no", getCrdNo());
		this.hashColumns.put("center_code", getCenterCode());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crd_seq", getCrdSeq());
		this.hashColumns.put("intercompanycode", getIntercompanycode());
		this.hashColumns.put("crd_brnd_lu_cd", getCrdBrndLuCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crd_cd_cmb_seq", getCrdCdCmbSeq());
		this.hashColumns.put("account_code", getAccountCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("crd_pgm_cd", getCrdPgmCd());
		this.hashColumns.put("crd_dtrb_ofc_cd", getCrdDtrbOfcCd());
		this.hashColumns.put("vvdcode", getVvdcode());
		this.hashColumns.put("crd_pgm_nm", getCrdPgmNm());
		this.hashColumns.put("crd_tp_lu_cd", getCrdTpLuCd());
		this.hashColumns.put("region_code", getRegionCode());
		this.hashColumns.put("crd_exp_dt", getCrdExpDt());
		this.hashColumns.put("crd_mbr_nm", getCrdMbrNm());
		this.hashColumns.put("crd_inact_dt", getCrdInactDt());
		this.hashColumns.put("crd_dtrb_dt", getCrdDtrbDt());
		this.hashColumns.put("crd_desc", getCrdDesc());
		this.hashColumns.put("company_code", getCompanyCode());
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
		this.hashFields.put("center_code", "centerCode");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crd_seq", "crdSeq");
		this.hashFields.put("intercompanycode", "intercompanycode");
		this.hashFields.put("crd_brnd_lu_cd", "crdBrndLuCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crd_cd_cmb_seq", "crdCdCmbSeq");
		this.hashFields.put("account_code", "accountCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("crd_pgm_cd", "crdPgmCd");
		this.hashFields.put("crd_dtrb_ofc_cd", "crdDtrbOfcCd");
		this.hashFields.put("vvdcode", "vvdcode");
		this.hashFields.put("crd_pgm_nm", "crdPgmNm");
		this.hashFields.put("crd_tp_lu_cd", "crdTpLuCd");
		this.hashFields.put("region_code", "regionCode");
		this.hashFields.put("crd_exp_dt", "crdExpDt");
		this.hashFields.put("crd_mbr_nm", "crdMbrNm");
		this.hashFields.put("crd_inact_dt", "crdInactDt");
		this.hashFields.put("crd_dtrb_dt", "crdDtrbDt");
		this.hashFields.put("crd_desc", "crdDesc");
		this.hashFields.put("company_code", "companyCode");
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
	 * @return centerCode
	 */
	public String getCenterCode() {
		return this.centerCode;
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
	 * @return crdSeq
	 */
	public String getCrdSeq() {
		return this.crdSeq;
	}
	
	/**
	 * Column Info
	 * @return intercompanycode
	 */
	public String getIntercompanycode() {
		return this.intercompanycode;
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
	 * @return crdCdCmbSeq
	 */
	public String getCrdCdCmbSeq() {
		return this.crdCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return accountCode
	 */
	public String getAccountCode() {
		return this.accountCode;
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
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return crdDtrbOfcCd
	 */
	public String getCrdDtrbOfcCd() {
		return this.crdDtrbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvdcode
	 */
	public String getVvdcode() {
		return this.vvdcode;
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
	 * @return crdTpLuCd
	 */
	public String getCrdTpLuCd() {
		return this.crdTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return regionCode
	 */
	public String getRegionCode() {
		return this.regionCode;
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
	 * @return companyCode
	 */
	public String getCompanyCode() {
		return this.companyCode;
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
	 * @param centerCode
	 */
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
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
	 * @param crdSeq
	 */
	public void setCrdSeq(String crdSeq) {
		this.crdSeq = crdSeq;
	}
	
	/**
	 * Column Info
	 * @param intercompanycode
	 */
	public void setIntercompanycode(String intercompanycode) {
		this.intercompanycode = intercompanycode;
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
	 * @param crdCdCmbSeq
	 */
	public void setCrdCdCmbSeq(String crdCdCmbSeq) {
		this.crdCdCmbSeq = crdCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param accountCode
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
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
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param crdDtrbOfcCd
	 */
	public void setCrdDtrbOfcCd(String crdDtrbOfcCd) {
		this.crdDtrbOfcCd = crdDtrbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvdcode
	 */
	public void setVvdcode(String vvdcode) {
		this.vvdcode = vvdcode;
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
	 * @param crdTpLuCd
	 */
	public void setCrdTpLuCd(String crdTpLuCd) {
		this.crdTpLuCd = crdTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param regionCode
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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
	 * @param companyCode
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
		setCenterCode(JSPUtil.getParameter(request, prefix + "center_code", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCrdSeq(JSPUtil.getParameter(request, prefix + "crd_seq", ""));
		setIntercompanycode(JSPUtil.getParameter(request, prefix + "intercompanycode", ""));
		setCrdBrndLuCd(JSPUtil.getParameter(request, prefix + "crd_brnd_lu_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCrdCdCmbSeq(JSPUtil.getParameter(request, prefix + "crd_cd_cmb_seq", ""));
		setAccountCode(JSPUtil.getParameter(request, prefix + "account_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setCrdPgmCd(JSPUtil.getParameter(request, prefix + "crd_pgm_cd", ""));
		setCrdDtrbOfcCd(JSPUtil.getParameter(request, prefix + "crd_dtrb_ofc_cd", ""));
		setVvdcode(JSPUtil.getParameter(request, prefix + "vvdcode", ""));
		setCrdPgmNm(JSPUtil.getParameter(request, prefix + "crd_pgm_nm", ""));
		setCrdTpLuCd(JSPUtil.getParameter(request, prefix + "crd_tp_lu_cd", ""));
		setRegionCode(JSPUtil.getParameter(request, prefix + "region_code", ""));
		setCrdExpDt(JSPUtil.getParameter(request, prefix + "crd_exp_dt", ""));
		setCrdMbrNm(JSPUtil.getParameter(request, prefix + "crd_mbr_nm", ""));
		setCrdInactDt(JSPUtil.getParameter(request, prefix + "crd_inact_dt", ""));
		setCrdDtrbDt(JSPUtil.getParameter(request, prefix + "crd_dtrb_dt", ""));
		setCrdDesc(JSPUtil.getParameter(request, prefix + "crd_desc", ""));
		setCompanyCode(JSPUtil.getParameter(request, prefix + "company_code", ""));
		setCrdPgmCurrCd(JSPUtil.getParameter(request, prefix + "crd_pgm_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreditCardListVO[]
	 */
	public CreditCardListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreditCardListVO[]
	 */
	public CreditCardListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreditCardListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crdDeptNm = (JSPUtil.getParameter(request, prefix	+ "crd_dept_nm", length));
			String[] crdNo = (JSPUtil.getParameter(request, prefix	+ "crd_no", length));
			String[] centerCode = (JSPUtil.getParameter(request, prefix	+ "center_code", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crdSeq = (JSPUtil.getParameter(request, prefix	+ "crd_seq", length));
			String[] intercompanycode = (JSPUtil.getParameter(request, prefix	+ "intercompanycode", length));
			String[] crdBrndLuCd = (JSPUtil.getParameter(request, prefix	+ "crd_brnd_lu_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crdCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "crd_cd_cmb_seq", length));
			String[] accountCode = (JSPUtil.getParameter(request, prefix	+ "account_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] crdPgmCd = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_cd", length));
			String[] crdDtrbOfcCd = (JSPUtil.getParameter(request, prefix	+ "crd_dtrb_ofc_cd", length));
			String[] vvdcode = (JSPUtil.getParameter(request, prefix	+ "vvdcode", length));
			String[] crdPgmNm = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_nm", length));
			String[] crdTpLuCd = (JSPUtil.getParameter(request, prefix	+ "crd_tp_lu_cd", length));
			String[] regionCode = (JSPUtil.getParameter(request, prefix	+ "region_code", length));
			String[] crdExpDt = (JSPUtil.getParameter(request, prefix	+ "crd_exp_dt", length));
			String[] crdMbrNm = (JSPUtil.getParameter(request, prefix	+ "crd_mbr_nm", length));
			String[] crdInactDt = (JSPUtil.getParameter(request, prefix	+ "crd_inact_dt", length));
			String[] crdDtrbDt = (JSPUtil.getParameter(request, prefix	+ "crd_dtrb_dt", length));
			String[] crdDesc = (JSPUtil.getParameter(request, prefix	+ "crd_desc", length));
			String[] companyCode = (JSPUtil.getParameter(request, prefix	+ "company_code", length));
			String[] crdPgmCurrCd = (JSPUtil.getParameter(request, prefix	+ "crd_pgm_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreditCardListVO();
				if (crdDeptNm[i] != null)
					model.setCrdDeptNm(crdDeptNm[i]);
				if (crdNo[i] != null)
					model.setCrdNo(crdNo[i]);
				if (centerCode[i] != null)
					model.setCenterCode(centerCode[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crdSeq[i] != null)
					model.setCrdSeq(crdSeq[i]);
				if (intercompanycode[i] != null)
					model.setIntercompanycode(intercompanycode[i]);
				if (crdBrndLuCd[i] != null)
					model.setCrdBrndLuCd(crdBrndLuCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crdCdCmbSeq[i] != null)
					model.setCrdCdCmbSeq(crdCdCmbSeq[i]);
				if (accountCode[i] != null)
					model.setAccountCode(accountCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (crdPgmCd[i] != null)
					model.setCrdPgmCd(crdPgmCd[i]);
				if (crdDtrbOfcCd[i] != null)
					model.setCrdDtrbOfcCd(crdDtrbOfcCd[i]);
				if (vvdcode[i] != null)
					model.setVvdcode(vvdcode[i]);
				if (crdPgmNm[i] != null)
					model.setCrdPgmNm(crdPgmNm[i]);
				if (crdTpLuCd[i] != null)
					model.setCrdTpLuCd(crdTpLuCd[i]);
				if (regionCode[i] != null)
					model.setRegionCode(regionCode[i]);
				if (crdExpDt[i] != null)
					model.setCrdExpDt(crdExpDt[i]);
				if (crdMbrNm[i] != null)
					model.setCrdMbrNm(crdMbrNm[i]);
				if (crdInactDt[i] != null)
					model.setCrdInactDt(crdInactDt[i]);
				if (crdDtrbDt[i] != null)
					model.setCrdDtrbDt(crdDtrbDt[i]);
				if (crdDesc[i] != null)
					model.setCrdDesc(crdDesc[i]);
				if (companyCode[i] != null)
					model.setCompanyCode(companyCode[i]);
				if (crdPgmCurrCd[i] != null)
					model.setCrdPgmCurrCd(crdPgmCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreditCardListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreditCardListVO[]
	 */
	public CreditCardListVO[] getCreditCardListVOs(){
		CreditCardListVO[] vos = (CreditCardListVO[])models.toArray(new CreditCardListVO[models.size()]);
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
		this.centerCode = this.centerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdSeq = this.crdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intercompanycode = this.intercompanycode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdBrndLuCd = this.crdBrndLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdCdCmbSeq = this.crdCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCode = this.accountCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmCd = this.crdPgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDtrbOfcCd = this.crdDtrbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcode = this.vvdcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmNm = this.crdPgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdTpLuCd = this.crdTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCode = this.regionCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdExpDt = this.crdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdMbrNm = this.crdMbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdInactDt = this.crdInactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDtrbDt = this.crdDtrbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdDesc = this.crdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.companyCode = this.companyCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crdPgmCurrCd = this.crdPgmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
