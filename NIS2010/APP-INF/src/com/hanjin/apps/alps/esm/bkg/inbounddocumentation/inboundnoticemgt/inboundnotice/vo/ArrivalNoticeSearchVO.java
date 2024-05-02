/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrivalNoticeSearchVO.java
*@FileTitle : ArrivalNoticeSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.04.16 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class ArrivalNoticeSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrivalNoticeSearchVO> models = new ArrayList<ArrivalNoticeSearchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String vpsEtaDtEnd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String vpsEtaDtStart = null;
	/* Column Info */
	private String sndDtTo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String sndDtFm = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String isValidated = null;
	/* Column Info */
	private String bkgNtcSndRsltCd = null;
	/* Column Info */
	private String ntcTpCd = null;
	/* Column Info */
	private String isCheck = null;
	/* Column Info */
	private String frtTermCd = null;
	
	private String anSntSts = null; //an sent status
	private String cntcInfoAval = null;//contatc info available
	private String donotSndFlg = null;//do not send
	
	private String hubLocCd = null;//Hub
	private String cstmsLocCd = null;//Customs Loc
	private String entrTp = null; //Entry Type
	private String sNo = null; //S/C No.
	private String cNo = null; //S/C No.

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrivalNoticeSearchVO() {}

	public ArrivalNoticeSearchVO(String ibflag, String pagerows, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String vpsEtaDtStart, String vpsEtaDtEnd, String podEtaDt, String podCd, String delCd, String blNo, String custCntCd, String custSeq, String schTp, String usrId, String bkgNtcSndRsltCd, String ntcTpCd, String ntcKndCd, String ofcCd, String sndDtFm, String sndDtTo, String sndUsrId, String eqCtrlOfcCd, String pageNo, String excelFlg, String tsFlg, String isValidated, String custRefNo, String cntrNo, String custNm, String polCd, String isCheck, String frtTermCd,String anSntSts, String cntcInfoAval,String donotSndFlg,String hubLocCd,String cstmsLocCd,String entrTp,String sNo,String cNo) {
		this.vslCd = vslCd;
		this.custNm = custNm;
		this.vpsEtaDtEnd = vpsEtaDtEnd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.tsFlg = tsFlg;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.vpsEtaDtStart = vpsEtaDtStart;
		this.sndDtTo = sndDtTo;
		this.custCntCd = custCntCd;
		this.sndDtFm = sndDtFm;
		this.custRefNo = custRefNo;
		this.ntcKndCd = ntcKndCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.podEtaDt = podEtaDt;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.schTp = schTp;
		this.ofcCd = ofcCd;
		this.sndUsrId = sndUsrId;
		this.excelFlg = excelFlg;
		this.cntrNo = cntrNo;
		this.pageNo = pageNo;
		this.isValidated = isValidated;
		this.bkgNtcSndRsltCd = bkgNtcSndRsltCd;
		this.ntcTpCd = ntcTpCd;
		this.isCheck = isCheck;
		this.frtTermCd = frtTermCd;
		this.anSntSts = anSntSts;
		this.cntcInfoAval = cntcInfoAval;
		this.donotSndFlg = donotSndFlg;
		this.hubLocCd = hubLocCd;
		this.cstmsLocCd = cstmsLocCd;
		this.entrTp = entrTp;
		this.sNo = sNo;
		this.cNo = cNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("vps_eta_dt_end", getVpsEtaDtEnd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("vps_eta_dt_start", getVpsEtaDtStart());
		this.hashColumns.put("snd_dt_to", getSndDtTo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("snd_dt_fm", getSndDtFm());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("is_validated", getIsValidated());
		this.hashColumns.put("bkg_ntc_snd_rslt_cd", getBkgNtcSndRsltCd());
		this.hashColumns.put("ntc_tp_cd", getNtcTpCd());
		this.hashColumns.put("is_check", getIsCheck());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("an_snt_sts", getAnSntSts());
		this.hashColumns.put("cntc_info_aval", getCntcInfoAval());
		this.hashColumns.put("donot_snd_flg", getDonotSndFlg());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("entr_tp", getEntrTp());
		this.hashColumns.put("s_no", getSNo());
		this.hashColumns.put("c_no", getCNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("vps_eta_dt_end", "vpsEtaDtEnd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("vps_eta_dt_start", "vpsEtaDtStart");
		this.hashFields.put("snd_dt_to", "sndDtTo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("snd_dt_fm", "sndDtFm");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("bkg_ntc_snd_rslt_cd", "bkgNtcSndRsltCd");
		this.hashFields.put("ntc_tp_cd", "ntcTpCd");
		this.hashFields.put("is_check", "isCheck");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("an_snt_sts", "anSntSts");
		this.hashFields.put("cntc_info_aval", "cntcInfoAval");
		this.hashFields.put("donot_snd_flg", "donotSndFlg");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("entr_tp", "entrTp");
		this.hashFields.put("s_no", "sNo");
		this.hashFields.put("c_no", "cNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return vpsEtaDtEnd
	 */
	public String getVpsEtaDtEnd() {
		return this.vpsEtaDtEnd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
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
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtStart
	 */
	public String getVpsEtaDtStart() {
		return this.vpsEtaDtStart;
	}
	
	/**
	 * Column Info
	 * @return sndDtTo
	 */
	public String getSndDtTo() {
		return this.sndDtTo;
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
	 * @return sndDtFm
	 */
	public String getSndDtFm() {
		return this.sndDtFm;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return podEtaDt
	 */
	public String getPodEtaDt() {
		return this.podEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return schTp
	 */
	public String getSchTp() {
		return this.schTp;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return isValidated
	 */
	public String getIsValidated() {
		return this.isValidated;
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
	 * @return ntcTpCd
	 */
	public String getNtcTpCd() {
		return this.ntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return isCheck
	 */
	public String getIsCheck() {
		return this.isCheck;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param vpsEtaDtEnd
	 */
	public void setVpsEtaDtEnd(String vpsEtaDtEnd) {
		this.vpsEtaDtEnd = vpsEtaDtEnd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
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
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtStart
	 */
	public void setVpsEtaDtStart(String vpsEtaDtStart) {
		this.vpsEtaDtStart = vpsEtaDtStart;
	}
	
	/**
	 * Column Info
	 * @param sndDtTo
	 */
	public void setSndDtTo(String sndDtTo) {
		this.sndDtTo = sndDtTo;
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
	 * @param sndDtFm
	 */
	public void setSndDtFm(String sndDtFm) {
		this.sndDtFm = sndDtFm;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param podEtaDt
	 */
	public void setPodEtaDt(String podEtaDt) {
		this.podEtaDt = podEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param schTp
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated) {
		this.isValidated = isValidated;
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
	 * @param ntcTpCd
	 */
	public void setNtcTpCd(String ntcTpCd) {
		this.ntcTpCd = ntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param isCheck
	 */
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setVpsEtaDtEnd(JSPUtil.getParameter(request, prefix + "vps_eta_dt_end", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setVpsEtaDtStart(JSPUtil.getParameter(request, prefix + "vps_eta_dt_start", ""));
		setSndDtTo(JSPUtil.getParameter(request, prefix + "snd_dt_to", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setSndDtFm(JSPUtil.getParameter(request, prefix + "snd_dt_fm", ""));
		setCustRefNo(JSPUtil.getParameter(request, prefix + "cust_ref_no", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPodEtaDt(JSPUtil.getParameter(request, prefix + "pod_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSchTp(JSPUtil.getParameter(request, prefix + "sch_tp", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setExcelFlg(JSPUtil.getParameter(request, prefix + "excel_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setIsValidated(JSPUtil.getParameter(request, prefix + "is_validated", ""));
		setBkgNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "bkg_ntc_snd_rslt_cd", ""));
		setNtcTpCd(JSPUtil.getParameter(request, prefix + "ntc_tp_cd", ""));
		setIsCheck(JSPUtil.getParameter(request, prefix + "is_check", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setAnSntSts(JSPUtil.getParameter(request, prefix + "an_snt_sts", ""));
		setCntcInfoAval(JSPUtil.getParameter(request, prefix + "cntc_info_aval", ""));
		setDonotSndFlg(JSPUtil.getParameter(request, prefix + "donot_snd_flg", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setEntrTp(JSPUtil.getParameter(request, prefix + "entr_tp", ""));
		setSNo(JSPUtil.getParameter(request, prefix + "s_no", ""));
		setCNo(JSPUtil.getParameter(request, prefix + "c_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrivalNoticeSearchVO[]
	 */
	public ArrivalNoticeSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrivalNoticeSearchVO[]
	 */
	public ArrivalNoticeSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrivalNoticeSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] vpsEtaDtEnd = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_end", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] vpsEtaDtStart = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_start", length));
			String[] sndDtTo = (JSPUtil.getParameter(request, prefix	+ "snd_dt_to", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] sndDtFm = (JSPUtil.getParameter(request, prefix	+ "snd_dt_fm", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix	+ "sch_tp", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] isValidated = (JSPUtil.getParameter(request, prefix	+ "is_validated", length));
			String[] bkgNtcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ntc_snd_rslt_cd", length));
			String[] ntcTpCd = (JSPUtil.getParameter(request, prefix	+ "ntc_tp_cd", length));
			String[] isCheck = (JSPUtil.getParameter(request, prefix	+ "is_check", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] anSntSts = (JSPUtil.getParameter(request, prefix	+ "an_snt_sts", length));
			String[] cntcInfoAval = (JSPUtil.getParameter(request, prefix	+ "cntc_info_aval", length));
			String[] donotSndFlg = (JSPUtil.getParameter(request, prefix	+ "donot_snd_flg", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] entrTp = (JSPUtil.getParameter(request, prefix	+ "entr_tp", length));
			String[] sNo = (JSPUtil.getParameter(request, prefix	+ "s_no", length));
			String[] cNo = (JSPUtil.getParameter(request, prefix	+ "c_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrivalNoticeSearchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (vpsEtaDtEnd[i] != null)
					model.setVpsEtaDtEnd(vpsEtaDtEnd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (vpsEtaDtStart[i] != null)
					model.setVpsEtaDtStart(vpsEtaDtStart[i]);
				if (sndDtTo[i] != null)
					model.setSndDtTo(sndDtTo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (sndDtFm[i] != null)
					model.setSndDtFm(sndDtFm[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (isValidated[i] != null)
					model.setIsValidated(isValidated[i]);
				if (bkgNtcSndRsltCd[i] != null)
					model.setBkgNtcSndRsltCd(bkgNtcSndRsltCd[i]);
				if (ntcTpCd[i] != null)
					model.setNtcTpCd(ntcTpCd[i]);
				if (isCheck[i] != null)
					model.setIsCheck(isCheck[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (anSntSts[i] != null)
					model.setAnSntSts(anSntSts[i]);
				if (cntcInfoAval[i] != null)
					model.setCntcInfoAval(cntcInfoAval[i]);
				if (donotSndFlg[i] != null)
					model.setDonotSndFlg(donotSndFlg[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (entrTp[i] != null)
					model.setEntrTp(entrTp[i]);
				if (sNo[i] != null)
					model.setSNo(sNo[i]);
				if (cNo[i] != null)
					model.setCNo(cNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrivalNoticeSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrivalNoticeSearchVO[]
	 */
	public ArrivalNoticeSearchVO[] getArrivalNoticeSearchVOs(){
		ArrivalNoticeSearchVO[] vos = (ArrivalNoticeSearchVO[])models.toArray(new ArrivalNoticeSearchVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtEnd = this.vpsEtaDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtStart = this.vpsEtaDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtTo = this.sndDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFm = this.sndDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated = this.isValidated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtcSndRsltCd = this.bkgNtcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTpCd = this.ntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCheck = this.isCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anSntSts = this.anSntSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcInfoAval = this.cntcInfoAval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donotSndFlg = this.donotSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrTp = this.entrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNo = this.sNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNo = this.cNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getAnSntSts() {
		return anSntSts;
	}

	public void setAnSntSts(String anSntSts) {
		this.anSntSts = anSntSts;
	}

	public String getCntcInfoAval() {
		return cntcInfoAval;
	}

	public void setCntcInfoAval(String cntcInfoAval) {
		this.cntcInfoAval = cntcInfoAval;
	}

	public String getDonotSndFlg() {
		return donotSndFlg;
	}

	public void setDonotSndFlg(String donotSndFlg) {
		this.donotSndFlg = donotSndFlg;
	}

	public String getHubLocCd() {
		return hubLocCd;
	}

	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}

	public String getCstmsLocCd() {
		return cstmsLocCd;
	}

	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
	}

	public String getEntrTp() {
		return entrTp;
	}

	public void setEntrTp(String entrTp) {
		this.entrTp = entrTp;
	}

	public String getSNo() {
		return sNo;
	}

	public void setSNo(String sNo) {
		this.sNo = sNo;
	}

	public String getCNo() {
		return cNo;
	}

	public void setCNo(String cNo) {
		this.cNo = cNo;
	}
}
