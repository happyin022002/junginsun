/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCntrRlseOrdVO.java
*@FileTitle : FullCntrRlseOrdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class FullCntrRlseOrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrdVO> models = new ArrayList<FullCntrRlseOrdVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String sentFlg = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNoYn = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String doIssDt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String err = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ydEml = null;
	/* Column Info */
	private String bkgCgoTpCd  = null;
	
	/* Column Info */
	private String sendDate  = null;
	/* Column Info */
	private String cgoPkupDt  = null;
	/* Column Info */
	private String bkgTrspModCd  = null;
	
	/* Column Info */
	private String ntcSndId = null;	
	
	/* Column Info */
	private String pinNo = null;

	/* Column Info */
	private String sndFlg = null;
	
	/* Column Info */
	private String rlseOrdSeq = null;	
	
	/* Column Info */
	private String msgAcptRefNo = null;	

	/* Column Info */
	private String cntrSltNo = null;	
	/* Column Info */
	private String cstmsVoyNo = null;
	/* Column Info */
	private String rlseExpDt = null;	
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseOrdVO() {}

	public FullCntrRlseOrdVO(String ibflag, String pagerows, String blNo, String bkgNo, String vvd, String polCd, String podCd, String cntrNo, String cntrTpszCd, String deTermCd, String crntYdCd, String svrId, String err, String custNm, String sentFlg, String ydCd, String faxNo, String ydNm, String ydEml, String phnNo, String vslNm, String locNm, String doNoYn, String cxlFlg, String doNo, String diffRmk, String doIssDt,String bkgCgoTpCd, String sendDate, String cgoPkupDt, String bkgTrspModCd,String ntcSndId, String pinNo, String sndFlg, String msgAcptRefNo, String rlseOrdSeq, String cntrSltNo, String cstmsVoyNo, String rlseExpDt, String podNm, String mtyRtnYdCd) {
		this.custNm = custNm;
		this.sentFlg = sentFlg;
		this.cxlFlg = cxlFlg;
		this.crntYdCd = crntYdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.doNoYn = doNoYn;
		this.svrId = svrId;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.phnNo = phnNo;
		this.vslNm = vslNm;
		this.locNm = locNm;
		this.podCd = podCd;
		this.vvd = vvd;
		this.doNo = doNo;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.doIssDt = doIssDt;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.err = err;
		this.ydNm = ydNm;
		this.faxNo = faxNo;
		this.ydEml = ydEml;
		this.bkgCgoTpCd = bkgCgoTpCd;		
		this.sendDate = sendDate;		
		this.cgoPkupDt = cgoPkupDt;		
		this.bkgTrspModCd = bkgTrspModCd;	
		this.ntcSndId	 = ntcSndId;
		this.pinNo = pinNo;
		this.sndFlg = sndFlg;
		this.msgAcptRefNo = msgAcptRefNo;
		this.rlseOrdSeq = rlseOrdSeq;		
		this.cntrSltNo = cntrSltNo;		
		this.cstmsVoyNo = cstmsVoyNo;	
		this.rlseExpDt = rlseExpDt;
		this.podNm = podNm;
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sent_flg", getSentFlg());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no_yn", getDoNoYn());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("do_iss_dt", getDoIssDt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("err", getErr());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("yd_eml", getYdEml());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("send_date", getSendDate());
		this.hashColumns.put("cgo_pkup_dt", getCgoPkupDt());
		this.hashColumns.put("bkg_trsp_mod_cd", getBkgTrspModCd());
		this.hashColumns.put("ntc_snd_id", getNtcSndId());	
		this.hashColumns.put("pin_no", getPinNo());
		this.hashColumns.put("snd_flg", getSndFlg());
		this.hashColumns.put("msg_acpt_ref_no", getMsgAcptRefNo());
		this.hashColumns.put("rlse_ord_seq", getRlseOrdSeq());	
		
		this.hashColumns.put("cntr_slt_no", getCntrSltNo());	
		this.hashColumns.put("cstms_voy_no", getCstmsVoyNo());	
		this.hashColumns.put("rlse_exp_dt", getRlseExpDt());	
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sent_flg", "sentFlg");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no_yn", "doNoYn");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("do_iss_dt", "doIssDt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("err", "err");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("yd_eml", "ydEml");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("send_date", "sendDate");
		this.hashFields.put("cgo_pkup_dt", "cgoPkupDt");
		this.hashFields.put("bkg_trsp_mod_cd", "bkgTrspModCd");
		this.hashFields.put("ntc_snd_id", "ntcSndId");		
		this.hashFields.put("pin_no", "pinNo");
		this.hashFields.put("snd_flg", "sndFlg");
		this.hashFields.put("msg_acpt_ref_no", "msgAcptRefNo");
		this.hashFields.put("rlse_ord_seq", "rlseOrdSeq");

		this.hashFields.put("cntr_slt_no", "cntrSltNo");
		this.hashFields.put("cstms_voy_no", "cstmsVoyNo");
		this.hashFields.put("rlse_exp_dt", "rlseExpDt");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		
		return this.hashFields;
	}
	
	public String getNtcSndId() {
		return this.ntcSndId;
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
	 * @return sendDate
	 */
	public String getSendDate() {
		return this.sendDate;
	}
	
	/**
	 * Column Info
	 * @return cgoPkupDt
	 */
	public String getCgoPkupDt() {
		return this.cgoPkupDt;
	}

	/**
	 * Column Info
	 * @return bkgTrspModCd
	 */
	public String getBkgTrspModCd() {
		return this.bkgTrspModCd;
	}	
	
	
	/**
	 * Column Info
	 * @return sentFlg
	 */
	public String getSentFlg() {
		return this.sentFlg;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return doNoYn
	 */
	public String getDoNoYn() {
		return this.doNoYn;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return doIssDt
	 */
	public String getDoIssDt() {
		return this.doIssDt;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return err
	 */
	public String getErr() {
		return this.err;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return ydEml
	 */
	public String getYdEml() {
		return this.ydEml;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}	
	
	/**
	 * Column Info
	 * @return pinNo
	 */
	public String getPinNo() {
		return this.pinNo;
	}	

	/**
	 * Column Info
	 * @return sndFlg
	 */
	public String getSndFlg() {
		return this.sndFlg;
	}		

	/**
	 * Column Info
	 * @return rlseOrdSeq
	 */
	public String getRlseOrdSeq() {
		return this.rlseOrdSeq;
	}		
	
	/**
	 * Column Info
	 * @return msgAcptRefNo
	 */
	public String getMsgAcptRefNo() {
		return this.msgAcptRefNo;
	}

	
	/**
	 * Column Info
	 * @return cntrSltNo
	 */
	public String getCntrSltNo() {
		return this.cntrSltNo;
	}

	/**
	 * Column Info
	 * @return cstmsVoyNo
	 */
	public String getCstmsVoyNo() {
		return this.cstmsVoyNo;
	}
	
	/**
	 * Column Info
	 * @return rlseExpDt
	 */
	public String getRlseExpDt() {
		return this.rlseExpDt;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
	}
	
	
	/**
	 * Column Info
	 * @param cntrSltNo
	 */
	public void setCntrSltNo(String cntrSltNo) {
		this.cntrSltNo = cntrSltNo;
	}

	/**
	 * Column Info
	 * @param cstmsVoyNo
	 */
	public void setCstmsVoyNo(String cstmsVoyNo) {
		this.cstmsVoyNo = cstmsVoyNo;
	}	
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setNtcSndId(String ntcSndId) {
		this.ntcSndId = ntcSndId;
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
	 * @param sentFlg
	 */
	public void setSentFlg(String sentFlg) {
		this.sentFlg = sentFlg;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
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
	 * @param doNoYn
	 */
	public void setDoNoYn(String doNoYn) {
		this.doNoYn = doNoYn;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param doIssDt
	 */
	public void setDoIssDt(String doIssDt) {
		this.doIssDt = doIssDt;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param err
	 */
	public void setErr(String err) {
		this.err = err;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
	 * @param ydEml
	 */
	public void setYdEml(String ydEml) {
		this.ydEml = ydEml;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	

	/**
	 * Column Info
	 * @param sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	/**
	 * Column Info
	 * @param cgoPkupDt
	 */
	public void setCgoPkupDt(String cgoPkupDt) {
		this.cgoPkupDt = cgoPkupDt;
	}

	/**
	 * Column Info
	 * @param bkgTrspModCd
	 */
	public void setBkgTrspModCd(String bkgTrspModCd) {
		this.bkgTrspModCd = bkgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param pinNo
	 */
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	/**
	 * Column Info
	 * @param sndFlg
	 */
	public void setSndFlg(String sndFlg) {
		this.sndFlg = sndFlg;
	}	
	
	/**
	 * Column Info
	 * @param rlseOrdSeq
	 */
	public void setRlseOrdSeq(String rlseOrdSeq) {
		this.rlseOrdSeq = rlseOrdSeq;
	}	
		
	/**
	 * Column Info
	 * @param msgAcptRefNo
	 */
	public void setMsgAcptRefNo(String msgAcptRefNo) {
		this.msgAcptRefNo = msgAcptRefNo;
	}
	
	/**
	 * Column Info
	 * @param rlseExpDt
	 */
	public void setRlseExpDt(String rlseExpDt) {
		this.rlseExpDt = rlseExpDt;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setSentFlg(JSPUtil.getParameter(request, "sent_flg", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNoYn(JSPUtil.getParameter(request, "do_no_yn", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setDoIssDt(JSPUtil.getParameter(request, "do_iss_dt", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setErr(JSPUtil.getParameter(request, "err", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setYdEml(JSPUtil.getParameter(request, "yd_eml", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setSendDate(JSPUtil.getParameter(request, "send_date", ""));
		setCgoPkupDt(JSPUtil.getParameter(request, "cgo_pkup_dt", ""));
		setBkgTrspModCd(JSPUtil.getParameter(request, "bkg_trsp_mod_cd", ""));
		setNtcSndId(JSPUtil.getParameter(request, "ntc_snd_id", ""));
		setPinNo(JSPUtil.getParameter(request, "pin_no", ""));
		setSndFlg(JSPUtil.getParameter(request, "snd_flg", ""));
		setRlseOrdSeq(JSPUtil.getParameter(request, "rlse_ord_seq", ""));
		setMsgAcptRefNo(JSPUtil.getParameter(request, "msg_acpt_ref_no", ""));

		setCntrSltNo(JSPUtil.getParameter(request, "cntr_slt_no", ""));
		setCstmsVoyNo(JSPUtil.getParameter(request, "cstms_voy_no", ""));
		
		setRlseExpDt(JSPUtil.getParameter(request, "rlse_exp_dt", ""));
		setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, "mty_rtn_yd_cd", ""));
	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseOrdVO[]
	 */
	public FullCntrRlseOrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseOrdVO[]
	 */
	public FullCntrRlseOrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] sentFlg = (JSPUtil.getParameter(request, prefix	+ "sent_flg", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNoYn = (JSPUtil.getParameter(request, prefix	+ "do_no_yn", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] doIssDt = (JSPUtil.getParameter(request, prefix	+ "do_iss_dt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] err = (JSPUtil.getParameter(request, prefix	+ "err", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ydEml = (JSPUtil.getParameter(request, prefix	+ "yd_eml", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] sendDate = (JSPUtil.getParameter(request, prefix	+ "send_date", length));
			String[] cgoPkupDt = (JSPUtil.getParameter(request, prefix	+ "cgo_pkup_dt", length));
			String[] bkgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_mod_cd", length));
			String[] ntcSndId = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_id", length));	
			String[] pinNo = (JSPUtil.getParameter(request, prefix	+ "pin_no", length));
			String[] sndFlg = (JSPUtil.getParameter(request, prefix	+ "snd_flg", length));
			String[] rlseOrdSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_ord_seq", length));
			String[] msgAcptRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_acpt_ref_no", length));
			String[] cntrSltNo = (JSPUtil.getParameter(request, prefix	+ "cntr_slt_no", length));
			String[] cstmsVoyNo = (JSPUtil.getParameter(request, prefix	+ "cstms_voy_no", length));
			String[] rlseExpDt = (JSPUtil.getParameter(request, prefix	+ "rlse_exp_dt", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrdVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (sentFlg[i] != null)
					model.setSentFlg(sentFlg[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNoYn[i] != null)
					model.setDoNoYn(doNoYn[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (doIssDt[i] != null)
					model.setDoIssDt(doIssDt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (err[i] != null)
					model.setErr(err[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ydEml[i] != null)
					model.setYdEml(ydEml[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (sendDate[i] != null)
					model.setSendDate(sendDate[i]);
				if (cgoPkupDt[i] != null)
					model.setCgoPkupDt(cgoPkupDt[i]);
				if (bkgTrspModCd[i] != null)
					model.setBkgTrspModCd(bkgTrspModCd[i]);
				if (ntcSndId[i] != null)
					model.setNtcSndId(ntcSndId[i]);		
				if (pinNo[i] != null)
					model.setPinNo(pinNo[i]);
				if (sndFlg[i] != null)
					model.setSndFlg(sndFlg[i]);
				if (rlseOrdSeq[i] != null)
					model.setRlseOrdSeq(rlseOrdSeq[i]);
				if (msgAcptRefNo[i] != null)
					model.setMsgAcptRefNo(msgAcptRefNo[i]);
				if (cntrSltNo[i] != null)
					model.setCntrSltNo(cntrSltNo[i]);
				if (cstmsVoyNo[i] != null)
					model.setCstmsVoyNo(cstmsVoyNo[i]);
				
				if (rlseExpDt[i] != null)
					model.setRlseExpDt(rlseExpDt[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseOrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseOrdVO[]
	 */
	public FullCntrRlseOrdVO[] getFullCntrRlseOrdVOs(){
		FullCntrRlseOrdVO[] vos = (FullCntrRlseOrdVO[])models.toArray(new FullCntrRlseOrdVO[models.size()]);
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
		this.sentFlg = this.sentFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoYn = this.doNoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssDt = this.doIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err = this.err .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydEml = this.ydEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDate = this.sendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoPkupDt = this.cgoPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspModCd = this.bkgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndId = this.ntcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pinNo = this.pinNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg = this.sndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseOrdSeq = this.rlseOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcptRefNo = this.msgAcptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSltNo = this.cntrSltNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVoyNo = this.cstmsVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseExpDt = this.rlseExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
