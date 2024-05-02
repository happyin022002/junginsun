/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNtcSentHisListVO.java
*@FileTitle : PkupNtcSentHisListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNtcSentHisListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcSentHisListVO> models = new ArrayList<PkupNtcSentHisListVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String sndRqstDt = null;
	/* Column Info */
	private String oblCltFlg = null;
	/* Column Info */
	private String pkupNtcEvntDt = null;
	/* Column Info */
	private String ntcKndCdDesc = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String edi322MvmtCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgNtcSndRsltCtnt = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String sndGdt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ntcSeq = null;
	/* Column Info */
	private String ntcFaxNoEml = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String cstmsClrFlg = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String mnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcSentHisListVO() {}

	public PkupNtcSentHisListVO(String ibflag, String pagerows, String ntcKndCdDesc, String blNo, String cntrNo, String bkgNtcSndRsltCd, String bkgNtcSndRsltCtnt, String ntcFaxNoEml, String pkupNo, String edi322MvmtCd, String pkupNtcEvntDt, String frtCltFlg, String oblCltFlg, String cstmsClrFlg, String mnlFlg, String custTpCd, String custCntCd, String custSeq, String custCd, String custNm, String sndRqstDt, String sndDt, String sndGdt, String sndOfcCd, String sndUsrId, String usrNm, String bkgNo, String ntcSeq, String rowCount) {
		this.custNm = custNm;
		this.sndRqstDt = sndRqstDt;
		this.oblCltFlg = oblCltFlg;
		this.pkupNtcEvntDt = pkupNtcEvntDt;
		this.ntcKndCdDesc = ntcKndCdDesc;
		this.rowCount = rowCount;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.frtCltFlg = frtCltFlg;
		this.edi322MvmtCd = edi322MvmtCd;
		this.usrNm = usrNm;
		this.custTpCd = custTpCd;
		this.custCntCd = custCntCd;
		this.bkgNtcSndRsltCtnt = bkgNtcSndRsltCtnt;
		this.sndOfcCd = sndOfcCd;
		this.sndGdt = sndGdt;
		this.custSeq = custSeq;
		this.ntcSeq = ntcSeq;
		this.ntcFaxNoEml = ntcFaxNoEml;
		this.bkgNo = bkgNo;
		this.sndUsrId = sndUsrId;
		this.cntrNo = cntrNo;
		this.custCd = custCd;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.cstmsClrFlg = cstmsClrFlg;
		this.pkupNo = pkupNo;
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("snd_rqst_dt", getSndRqstDt());
		this.hashColumns.put("obl_clt_flg", getOblCltFlg());
		this.hashColumns.put("pkup_ntc_evnt_dt", getPkupNtcEvntDt());
		this.hashColumns.put("ntc_knd_cd_desc", getNtcKndCdDesc());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("edi_322_mvmt_cd", getEdi322MvmtCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ntc_snd_rslt_ctnt", getBkgNtcSndRsltCtnt());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("snd_gdt", getSndGdt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ntc_seq", getNtcSeq());
		this.hashColumns.put("ntc_fax_no_eml", getNtcFaxNoEml());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("snd_rqst_dt", "sndRqstDt");
		this.hashFields.put("obl_clt_flg", "oblCltFlg");
		this.hashFields.put("pkup_ntc_evnt_dt", "pkupNtcEvntDt");
		this.hashFields.put("ntc_knd_cd_desc", "ntcKndCdDesc");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("edi_322_mvmt_cd", "edi322MvmtCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ntc_snd_rslt_ctnt", "bkgNtcSndRsltCtnt");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("snd_gdt", "sndGdt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ntc_seq", "ntcSeq");
		this.hashFields.put("ntc_fax_no_eml", "ntcFaxNoEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("mnl_flg", "mnlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return sndRqstDt
	 */
	public String getSndRqstDt() {
		return this.sndRqstDt;
	}
	
	/**
	 * Column Info
	 * @return oblCltFlg
	 */
	public String getOblCltFlg() {
		return this.oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcEvntDt
	 */
	public String getPkupNtcEvntDt() {
		return this.pkupNtcEvntDt;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCdDesc
	 */
	public String getNtcKndCdDesc() {
		return this.ntcKndCdDesc;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return edi322MvmtCd
	 */
	public String getEdi322MvmtCd() {
		return this.edi322MvmtCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
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
	 * @return bkgNtcSndRsltCtnt
	 */
	public String getBkgNtcSndRsltCtnt() {
		return this.bkgNtcSndRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sndGdt
	 */
	public String getSndGdt() {
		return this.sndGdt;
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
	 * @return ntcSeq
	 */
	public String getNtcSeq() {
		return this.ntcSeq;
	}
	
	/**
	 * Column Info
	 * @return ntcFaxNoEml
	 */
	public String getNtcFaxNoEml() {
		return this.ntcFaxNoEml;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNtcSndRsltCd
	 */
	public String getBkgNtcSndRsltCd() {
		return this.bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrFlg
	 */
	public String getCstmsClrFlg() {
		return this.cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param sndRqstDt
	 */
	public void setSndRqstDt(String sndRqstDt) {
		this.sndRqstDt = sndRqstDt;
	}
	
	/**
	 * Column Info
	 * @param oblCltFlg
	 */
	public void setOblCltFlg(String oblCltFlg) {
		this.oblCltFlg = oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcEvntDt
	 */
	public void setPkupNtcEvntDt(String pkupNtcEvntDt) {
		this.pkupNtcEvntDt = pkupNtcEvntDt;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCdDesc
	 */
	public void setNtcKndCdDesc(String ntcKndCdDesc) {
		this.ntcKndCdDesc = ntcKndCdDesc;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param edi322MvmtCd
	 */
	public void setEdi322MvmtCd(String edi322MvmtCd) {
		this.edi322MvmtCd = edi322MvmtCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
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
	 * @param bkgNtcSndRsltCtnt
	 */
	public void setBkgNtcSndRsltCtnt(String bkgNtcSndRsltCtnt) {
		this.bkgNtcSndRsltCtnt = bkgNtcSndRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sndGdt
	 */
	public void setSndGdt(String sndGdt) {
		this.sndGdt = sndGdt;
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
	 * @param ntcSeq
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
	}
	
	/**
	 * Column Info
	 * @param ntcFaxNoEml
	 */
	public void setNtcFaxNoEml(String ntcFaxNoEml) {
		this.ntcFaxNoEml = ntcFaxNoEml;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNtcSndRsltCd
	 */
	public void setBkgNtcSndRsltCd(String bkgNtcSndRsltCd) {
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrFlg
	 */
	public void setCstmsClrFlg(String cstmsClrFlg) {
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSndRqstDt(JSPUtil.getParameter(request, prefix + "snd_rqst_dt", ""));
		setOblCltFlg(JSPUtil.getParameter(request, prefix + "obl_clt_flg", ""));
		setPkupNtcEvntDt(JSPUtil.getParameter(request, prefix + "pkup_ntc_evnt_dt", ""));
		setNtcKndCdDesc(JSPUtil.getParameter(request, prefix + "ntc_knd_cd_desc", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setEdi322MvmtCd(JSPUtil.getParameter(request, prefix + "edi_322_mvmt_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgNtcSndRsltCtnt(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_ctnt", ""));
		setSndOfcCd(JSPUtil.getParameter(request, prefix + "snd_ofc_cd", ""));
		setSndGdt(JSPUtil.getParameter(request, prefix + "snd_gdt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setNtcSeq(JSPUtil.getParameter(request, prefix + "ntc_seq", ""));
		setNtcFaxNoEml(JSPUtil.getParameter(request, prefix + "ntc_fax_no_eml", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request, prefix + "cstms_clr_flg", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcSentHisListVO[]
	 */
	public PkupNtcSentHisListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcSentHisListVO[]
	 */
	public PkupNtcSentHisListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcSentHisListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] sndRqstDt = (JSPUtil.getParameter(request, prefix	+ "snd_rqst_dt", length));
			String[] oblCltFlg = (JSPUtil.getParameter(request, prefix	+ "obl_clt_flg", length));
			String[] pkupNtcEvntDt = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_evnt_dt", length));
			String[] ntcKndCdDesc = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd_desc", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] edi322MvmtCd = (JSPUtil.getParameter(request, prefix	+ "edi_322_mvmt_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgNtcSndRsltCtnt = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_ctnt", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] sndGdt = (JSPUtil.getParameter(request, prefix	+ "snd_gdt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ntcSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_seq", length));
			String[] ntcFaxNoEml = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no_eml", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] cstmsClrFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_flg", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcSentHisListVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (sndRqstDt[i] != null)
					model.setSndRqstDt(sndRqstDt[i]);
				if (oblCltFlg[i] != null)
					model.setOblCltFlg(oblCltFlg[i]);
				if (pkupNtcEvntDt[i] != null)
					model.setPkupNtcEvntDt(pkupNtcEvntDt[i]);
				if (ntcKndCdDesc[i] != null)
					model.setNtcKndCdDesc(ntcKndCdDesc[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (edi322MvmtCd[i] != null)
					model.setEdi322MvmtCd(edi322MvmtCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgNtcSndRsltCtnt[i] != null)
					model.setBkgNtcSndRsltCtnt(bkgNtcSndRsltCtnt[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (sndGdt[i] != null)
					model.setSndGdt(sndGdt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ntcSeq[i] != null)
					model.setNtcSeq(ntcSeq[i]);
				if (ntcFaxNoEml[i] != null)
					model.setNtcFaxNoEml(ntcFaxNoEml[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (cstmsClrFlg[i] != null)
					model.setCstmsClrFlg(cstmsClrFlg[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcSentHisListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcSentHisListVO[]
	 */
	public PkupNtcSentHisListVO[] getPkupNtcSentHisListVOs(){
		PkupNtcSentHisListVO[] vos = (PkupNtcSentHisListVO[])models.toArray(new PkupNtcSentHisListVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndRqstDt = this.sndRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCltFlg = this.oblCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcEvntDt = this.pkupNtcEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCdDesc = this.ntcKndCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi322MvmtCd = this.edi322MvmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCtnt = this.bkgNtcSndRsltCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndGdt = this.sndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSeq = this.ntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNoEml = this.ntcFaxNoEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg = this.cstmsClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
