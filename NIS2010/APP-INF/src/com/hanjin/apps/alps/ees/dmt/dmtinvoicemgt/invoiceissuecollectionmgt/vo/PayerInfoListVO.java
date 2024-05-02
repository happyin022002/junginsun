/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayerInfoListVO.java
*@FileTitle : PayerInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.04.19 김기태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김기태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayerInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayerInfoListVO> models = new ArrayList<PayerInfoListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sndCycDesc = null;
	/* Column Info */
	private String sndCycCd = null;
	/* Column Info */
	private String payrNm = null;
	/* Column Info */
	private String payrCd = null;
	/* Column Info */
	private String payrTp = null;
	/* Column Info */
	private String otsShGrpDesc = null;
	/* Column Info */
	private String sndCntrListFlg = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String sndInvFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spYn = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String otsShGrpCd = null;
	/* Column Info */
	private String emlExistFlg = null;
	/* Column Info */
	private String payrCntcPntNm = null;
	/* Column Info */
	private String payrCntcPntPhnNo = null;
	/* Column Info */
	private String payrCntcPntFaxNo = null;
	/* Column Info */
	private String payrCntcPntEml = null;
	/* Column Info */
	private String sheet = null;
	/* Column Info */
	private String otsSndFlg = null;
	/* Column Info */
	private String otsEmailFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PayerInfoListVO() {}

	public PayerInfoListVO(String ibflag, String pagerows, String sysAreaGrpId, String custCntCd, String custSeq, String payrCd, String spYn, String payrTp, String payrNm, String sndCycCd, String sndCycDesc, String otsShGrpCd, String otsShGrpDesc, String sndCntrListFlg, String sndInvFlg, String updUsrId, String updDt, String updOfcCd, String emlExistFlg, String payrCntcPntNm, String payrCntcPntPhnNo, String payrCntcPntFaxNo, String payrCntcPntEml, String sheet, String otsSndFlg, String otsEmailFlg) {
		this.updDt = updDt;
		this.sndCycDesc = sndCycDesc;
		this.sndCycCd = sndCycCd;
		this.payrNm = payrNm;
		this.payrCd = payrCd;
		this.payrTp = payrTp;
		this.otsShGrpDesc = otsShGrpDesc;
		this.sndCntrListFlg = sndCntrListFlg;
		this.sysAreaGrpId = sysAreaGrpId;
		this.custSeq = custSeq;
		this.sndInvFlg = sndInvFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.spYn = spYn;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.otsShGrpCd = otsShGrpCd;
		this.emlExistFlg = emlExistFlg;
		this.payrCntcPntNm = payrCntcPntNm;
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
		this.payrCntcPntEml = payrCntcPntEml;
		this.sheet = sheet;
		this.otsSndFlg = otsSndFlg;
		this.otsEmailFlg = otsEmailFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("snd_cyc_desc", getSndCycDesc());
		this.hashColumns.put("snd_cyc_cd", getSndCycCd());
		this.hashColumns.put("payr_nm", getPayrNm());
		this.hashColumns.put("payr_cd", getPayrCd());
		this.hashColumns.put("payr_tp", getPayrTp());
		this.hashColumns.put("ots_sh_grp_desc", getOtsShGrpDesc());
		this.hashColumns.put("snd_cntr_list_flg", getSndCntrListFlg());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("snd_inv_flg", getSndInvFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sp_yn", getSpYn());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ots_sh_grp_cd", getOtsShGrpCd());
		this.hashColumns.put("eml_exist_flg", getEmlExistFlg());
		
		this.hashColumns.put("payr_cntc_pnt_nm", getPayrCntcPntNm());
		this.hashColumns.put("payr_cntc_pnt_phn_no", getPayrCntcPntPhnNo());
		this.hashColumns.put("payr_cntc_pnt_fax_no", getPayrCntcPntFaxNo());
		this.hashColumns.put("payr_cntc_pnt_eml", getPayrCntcPntEml());
		this.hashColumns.put("sheet", getSheet());
		this.hashColumns.put("ots_snd_flg", getOtsSndFlg());
		this.hashColumns.put("ots_email_flg", getOtsEmailFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("snd_cyc_desc", "sndCycDesc");
		this.hashFields.put("snd_cyc_cd", "sndCycCd");
		this.hashFields.put("payr_nm", "payrNm");
		this.hashFields.put("payr_cd", "payrCd");
		this.hashFields.put("payr_tp", "payrTp");
		this.hashFields.put("ots_sh_grp_desc", "otsShGrpDesc");
		this.hashFields.put("snd_cntr_list_flg", "sndCntrListFlg");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("snd_inv_flg", "sndInvFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sp_yn", "spYn");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ots_sh_grp_cd", "otsShGrpCd");
		this.hashFields.put("eml_exist_flg", "emlExistFlg");
		
		this.hashFields.put("payr_cntc_pnt_nm", "payrCntcPntNm");
		this.hashFields.put("payr_cntc_pnt_phn_no", "payrCntcPntPhnNo");
		this.hashFields.put("payr_cntc_pnt_fax_no", "payrCntcPntFaxNo");
		this.hashFields.put("payr_cntc_pnt_eml", "payrCntcPntEml");
		this.hashFields.put("sheet", "sheet");
		this.hashFields.put("ots_snd_flg", "otsSndFlg");
		this.hashFields.put("ots_email_flg", "otsEmailflg");
		return this.hashFields;
	}
	
	
	
	public String getEmlExistFlg() {
		return emlExistFlg;
	}

	public void setEmlExistFlg(String emlExistFlg) {
		this.emlExistFlg = emlExistFlg;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return sndCycDesc
	 */
	public String getSndCycDesc() {
		return this.sndCycDesc;
	}
	
	/**
	 * Column Info
	 * @return sndCycCd
	 */
	public String getSndCycCd() {
		return this.sndCycCd;
	}
	
	/**
	 * Column Info
	 * @return payrNm
	 */
	public String getPayrNm() {
		return this.payrNm;
	}
	
	/**
	 * Column Info
	 * @return payrCd
	 */
	public String getPayrCd() {
		return this.payrCd;
	}
	
	/**
	 * Column Info
	 * @return payrTp
	 */
	public String getPayrTp() {
		return this.payrTp;
	}
	
	/**
	 * Column Info
	 * @return otsShGrpDesc
	 */
	public String getOtsShGrpDesc() {
		return this.otsShGrpDesc;
	}
	
	/**
	 * Column Info
	 * @return sndCntrListFlg
	 */
	public String getSndCntrListFlg() {
		return this.sndCntrListFlg;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return sndInvFlg
	 */
	public String getSndInvFlg() {
		return this.sndInvFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return spYn
	 */
	public String getSpYn() {
		return this.spYn;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return otsShGrpCd
	 */
	public String getOtsShGrpCd() {
		return this.otsShGrpCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sndCycDesc
	 */
	public void setSndCycDesc(String sndCycDesc) {
		this.sndCycDesc = sndCycDesc;
	}
	
	/**
	 * Column Info
	 * @param sndCycCd
	 */
	public void setSndCycCd(String sndCycCd) {
		this.sndCycCd = sndCycCd;
	}
	
	/**
	 * Column Info
	 * @param payrNm
	 */
	public void setPayrNm(String payrNm) {
		this.payrNm = payrNm;
	}
	
	/**
	 * Column Info
	 * @param payrCd
	 */
	public void setPayrCd(String payrCd) {
		this.payrCd = payrCd;
	}
	
	/**
	 * Column Info
	 * @param payrTp
	 */
	public void setPayrTp(String payrTp) {
		this.payrTp = payrTp;
	}
	
	/**
	 * Column Info
	 * @param otsShGrpDesc
	 */
	public void setOtsShGrpDesc(String otsShGrpDesc) {
		this.otsShGrpDesc = otsShGrpDesc;
	}
	
	/**
	 * Column Info
	 * @param sndCntrListFlg
	 */
	public void setSndCntrListFlg(String sndCntrListFlg) {
		this.sndCntrListFlg = sndCntrListFlg;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param sndInvFlg
	 */
	public void setSndInvFlg(String sndInvFlg) {
		this.sndInvFlg = sndInvFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param spYn
	 */
	public void setSpYn(String spYn) {
		this.spYn = spYn;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param otsShGrpCd
	 */
	public void setOtsShGrpCd(String otsShGrpCd) {
		this.otsShGrpCd = otsShGrpCd;
	}
	
	public String getPayrCntcPntNm() {
		return payrCntcPntNm;
	}

	public void setPayrCntcPntNm(String payrCntcPntNm) {
		this.payrCntcPntNm = payrCntcPntNm;
	}

	public String getPayrCntcPntPhnNo() {
		return payrCntcPntPhnNo;
	}

	public void setPayrCntcPntPhnNo(String payrCntcPntPhnNo) {
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
	}

	public String getPayrCntcPntFaxNo() {
		return payrCntcPntFaxNo;
	}

	public void setPayrCntcPntFaxNo(String payrCntcPntFaxNo) {
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
	}

	public String getPayrCntcPntEml() {
		return payrCntcPntEml;
	}

	public void setPayrCntcPntEml(String payrCntcPntEml) {
		this.payrCntcPntEml = payrCntcPntEml;
	}

	public String getSheet() {
		return sheet;
	}

	public void setSheet(String sheet) {
		this.sheet = sheet;
	}

	public String getOtsSndFlg() {
		return otsSndFlg;
	}

	public void setOtsSndFlg(String otsSndFlg) {
		this.otsSndFlg = otsSndFlg;
	}

	public String getOtsEmailFlg() {
		return otsEmailFlg;
	}

	public void setOtsEmailFlg(String otsEmailFlg) {
		this.otsEmailFlg = otsEmailFlg;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSndCycDesc(JSPUtil.getParameter(request, prefix + "snd_cyc_desc", ""));
		setSndCycCd(JSPUtil.getParameter(request, prefix + "snd_cyc_cd", ""));
		setPayrNm(JSPUtil.getParameter(request, prefix + "payr_nm", ""));
		setPayrCd(JSPUtil.getParameter(request, prefix + "payr_cd", ""));
		setPayrTp(JSPUtil.getParameter(request, prefix + "payr_tp", ""));
		setOtsShGrpDesc(JSPUtil.getParameter(request, prefix + "ots_sh_grp_desc", ""));
		setSndCntrListFlg(JSPUtil.getParameter(request, prefix + "snd_cntr_list_flg", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, prefix + "sys_area_grp_id", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSndInvFlg(JSPUtil.getParameter(request, prefix + "snd_inv_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpYn(JSPUtil.getParameter(request, prefix + "sp_yn", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setOtsShGrpCd(JSPUtil.getParameter(request, prefix + "ots_sh_grp_cd", ""));
		setEmlExistFlg(JSPUtil.getParameter(request, prefix + "eml_exist_flg", ""));		

		setPayrCntcPntNm(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_nm", ""));
		setPayrCntcPntPhnNo(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_phn_no", ""));
		setPayrCntcPntFaxNo(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_fax_no", ""));
		setPayrCntcPntEml(JSPUtil.getParameter(request, prefix + "payr_cntc_pnt_eml", ""));
		setSheet(JSPUtil.getParameter(request, prefix + "sheet", ""));
		setOtsSndFlg(JSPUtil.getParameter(request, prefix + "ots_snd_flg", ""));
		setOtsEmailFlg(JSPUtil.getParameter(request, prefix + "ots_email_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayerInfoListVO[]
	 */
	public PayerInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayerInfoListVO[]
	 */
	public PayerInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayerInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sndCycDesc = (JSPUtil.getParameter(request, prefix	+ "snd_cyc_desc", length));
			String[] sndCycCd = (JSPUtil.getParameter(request, prefix	+ "snd_cyc_cd", length));
			String[] payrNm = (JSPUtil.getParameter(request, prefix	+ "payr_nm", length));
			String[] payrCd = (JSPUtil.getParameter(request, prefix	+ "payr_cd", length));
			String[] payrTp = (JSPUtil.getParameter(request, prefix	+ "payr_tp", length));
			String[] otsShGrpDesc = (JSPUtil.getParameter(request, prefix	+ "ots_sh_grp_desc", length));
			String[] sndCntrListFlg = (JSPUtil.getParameter(request, prefix	+ "snd_cntr_list_flg", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] sndInvFlg = (JSPUtil.getParameter(request, prefix	+ "snd_inv_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spYn = (JSPUtil.getParameter(request, prefix	+ "sp_yn", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] otsShGrpCd = (JSPUtil.getParameter(request, prefix	+ "ots_sh_grp_cd", length));
			String[] emlExistFlg = (JSPUtil.getParameter(request, prefix	+ "eml_exist_flg", length));

			String[] payrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_nm", length));
			String[] payrCntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_phn_no", length));
			String[] payrCntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_fax_no", length));
			String[] payrCntcPntEml = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_eml", length));
			String[] sheet = (JSPUtil.getParameter(request, prefix	+ "sheet", length));
			String[] otsSndFlg = (JSPUtil.getParameter(request, prefix	+ "ots_snd_flg", length));
			String[] otsEmailFlg = (JSPUtil.getParameter(request, prefix	+ "ots_email_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayerInfoListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sndCycDesc[i] != null)
					model.setSndCycDesc(sndCycDesc[i]);
				if (sndCycCd[i] != null)
					model.setSndCycCd(sndCycCd[i]);
				if (payrNm[i] != null)
					model.setPayrNm(payrNm[i]);
				if (payrCd[i] != null)
					model.setPayrCd(payrCd[i]);
				if (payrTp[i] != null)
					model.setPayrTp(payrTp[i]);
				if (otsShGrpDesc[i] != null)
					model.setOtsShGrpDesc(otsShGrpDesc[i]);
				if (sndCntrListFlg[i] != null)
					model.setSndCntrListFlg(sndCntrListFlg[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (sndInvFlg[i] != null)
					model.setSndInvFlg(sndInvFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spYn[i] != null)
					model.setSpYn(spYn[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (otsShGrpCd[i] != null)
					model.setOtsShGrpCd(otsShGrpCd[i]);
				if (emlExistFlg[i] != null)
					model.setEmlExistFlg(emlExistFlg[i]);				

				if (payrCntcPntNm[i] != null)
					model.setPayrCntcPntNm(payrCntcPntNm[i]);
				if (payrCntcPntPhnNo[i] != null)
					model.setPayrCntcPntPhnNo(payrCntcPntPhnNo[i]);
				if (payrCntcPntFaxNo[i] != null)
					model.setPayrCntcPntFaxNo(payrCntcPntFaxNo[i]);
				if (payrCntcPntEml[i] != null)
					model.setPayrCntcPntEml(payrCntcPntEml[i]);
				if (sheet[i] != null)
					model.setSheet(sheet[i]);
				if (otsSndFlg[i] != null)
					model.setOtsSndFlg(otsSndFlg[i]);
				if (otsEmailFlg[i] != null)
					model.setOtsEmailFlg(otsEmailFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayerInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayerInfoListVO[]
	 */
	public PayerInfoListVO[] getPayerInfoListVOs(){
		PayerInfoListVO[] vos = (PayerInfoListVO[])models.toArray(new PayerInfoListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCycDesc = this.sndCycDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCycCd = this.sndCycCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrNm = this.payrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCd = this.payrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrTp = this.payrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsShGrpDesc = this.otsShGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndCntrListFlg = this.sndCntrListFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndInvFlg = this.sndInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spYn = this.spYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsShGrpCd = this.otsShGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlExistFlg = this.emlExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.payrCntcPntNm = this.payrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntPhnNo = this.payrCntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntFaxNo = this.payrCntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntEml = this.payrCntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheet = this.sheet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSndFlg = this.otsSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsEmailFlg = this.otsEmailFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
