/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTFACRateInfoVO.java
*@FileTitle : AGTFACRateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.09 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo;

import java.lang.reflect.Field;
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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AGTFACRateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AGTFACRateInfoVO> models = new ArrayList<AGTFACRateInfoVO>();
	
	/* Column Info */
	private String frtFwrdCntNm = null;
	/* Column Info */
	private String bkgFacBlAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String facFeuRt = null;
	/* Column Info */
	private String porGrpTpCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Column Info */
	private String facBxRt = null;
	/* Column Info */
	private String grsNetDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podRoutCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String frtFwrdCntCdSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFacRt = null;
	/* Column Info */
	private String facSglFlg = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String shprCntNm = null;
	/* Column Info */
	private String facTeuRt = null;
	/* Column Info */
	private String facDivCd = null;
	/* Column Info */
	private String delGrpTpCd = null;
	/* Column Info */
	private String delRoutCd = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String facRtSeq = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String facRfTeuRt = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cmdtTpCd = null;
	/* Column Info */
	private String facChgCtnt = null;
	/* Column Info */
	private String shprCntCdSeq = null;
	/* Column Info */
	private String facRfFeuRt = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AGTFACRateInfoVO() {}

	public AGTFACRateInfoVO(String ibflag, String pagerows, String frtFwrdCntCdSeq, String frtFwrdCntNm, String shprCntCdSeq, String shprCntNm, String porGrpTpCd, String porRoutCd, String polGrpTpCd, String polRoutCd, String podGrpTpCd, String podRoutCd, String delGrpTpCd, String delRoutCd, String bkgRcvTermCd, String bkgDeTermCd, String facSglFlg, String grsNetDivCd, String svcScpCd, String fmEffDt, String toEffDt, String scNo, String rfaNo, String cmdtTpCd, String cmdtCd, String cmdtNm, String facDivCd, String bkgFacRt, String bkgFacBlAmt, String facBxRt, String facTeuRt, String facFeuRt, String facRfTeuRt, String facRfFeuRt, String facChgCtnt, String facOfcCd, String frtFwrdCntCd, String frtFwrdCustSeq, String facRtSeq) {
		this.frtFwrdCntNm = frtFwrdCntNm;
		this.bkgFacBlAmt = bkgFacBlAmt;
		this.svcScpCd = svcScpCd;
		this.facFeuRt = facFeuRt;
		this.porGrpTpCd = porGrpTpCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.facOfcCd = facOfcCd;
		this.facBxRt = facBxRt;
		this.grsNetDivCd = grsNetDivCd;
		this.pagerows = pagerows;
		this.podRoutCd = podRoutCd;
		this.rfaNo = rfaNo;
		this.frtFwrdCntCdSeq = frtFwrdCntCdSeq;
		this.ibflag = ibflag;
		this.bkgFacRt = bkgFacRt;
		this.facSglFlg = facSglFlg;
		this.cmdtCd = cmdtCd;
		this.scNo = scNo;
		this.fmEffDt = fmEffDt;
		this.porRoutCd = porRoutCd;
		this.shprCntNm = shprCntNm;
		this.facTeuRt = facTeuRt;
		this.facDivCd = facDivCd;
		this.delGrpTpCd = delGrpTpCd;
		this.delRoutCd = delRoutCd;
		this.polRoutCd = polRoutCd;
		this.facRtSeq = facRtSeq;
		this.polGrpTpCd = polGrpTpCd;
		this.facRfTeuRt = facRfTeuRt;
		this.toEffDt = toEffDt;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.cmdtNm = cmdtNm;
		this.cmdtTpCd = cmdtTpCd;
		this.facChgCtnt = facChgCtnt;
		this.shprCntCdSeq = shprCntCdSeq;
		this.facRfFeuRt = facRfFeuRt;
		this.podGrpTpCd = podGrpTpCd;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frt_fwrd_cnt_nm", getFrtFwrdCntNm());
		this.hashColumns.put("bkg_fac_bl_amt", getBkgFacBlAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("fac_feu_rt", getFacFeuRt());
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("fac_bx_rt", getFacBxRt());
		this.hashColumns.put("grs_net_div_cd", getGrsNetDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("frt_fwrd_cnt_cd_seq", getFrtFwrdCntCdSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_fac_rt", getBkgFacRt());
		this.hashColumns.put("fac_sgl_flg", getFacSglFlg());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("shpr_cnt_nm", getShprCntNm());
		this.hashColumns.put("fac_teu_rt", getFacTeuRt());
		this.hashColumns.put("fac_div_cd", getFacDivCd());
		this.hashColumns.put("del_grp_tp_cd", getDelGrpTpCd());
		this.hashColumns.put("del_rout_cd", getDelRoutCd());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("fac_rt_seq", getFacRtSeq());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("fac_rf_teu_rt", getFacRfTeuRt());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cmdt_tp_cd", getCmdtTpCd());
		this.hashColumns.put("fac_chg_ctnt", getFacChgCtnt());
		this.hashColumns.put("shpr_cnt_cd_seq", getShprCntCdSeq());
		this.hashColumns.put("fac_rf_feu_rt", getFacRfFeuRt());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frt_fwrd_cnt_nm", "frtFwrdCntNm");
		this.hashFields.put("bkg_fac_bl_amt", "bkgFacBlAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("fac_feu_rt", "facFeuRt");
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("fac_bx_rt", "facBxRt");
		this.hashFields.put("grs_net_div_cd", "grsNetDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("frt_fwrd_cnt_cd_seq", "frtFwrdCntCdSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_fac_rt", "bkgFacRt");
		this.hashFields.put("fac_sgl_flg", "facSglFlg");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("shpr_cnt_nm", "shprCntNm");
		this.hashFields.put("fac_teu_rt", "facTeuRt");
		this.hashFields.put("fac_div_cd", "facDivCd");
		this.hashFields.put("del_grp_tp_cd", "delGrpTpCd");
		this.hashFields.put("del_rout_cd", "delRoutCd");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("fac_rt_seq", "facRtSeq");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("fac_rf_teu_rt", "facRfTeuRt");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cmdt_tp_cd", "cmdtTpCd");
		this.hashFields.put("fac_chg_ctnt", "facChgCtnt");
		this.hashFields.put("shpr_cnt_cd_seq", "shprCntCdSeq");
		this.hashFields.put("fac_rf_feu_rt", "facRfFeuRt");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntNm
	 */
	public String getFrtFwrdCntNm() {
		return this.frtFwrdCntNm;
	}
	
	/**
	 * Column Info
	 * @return bkgFacBlAmt
	 */
	public String getBkgFacBlAmt() {
		return this.bkgFacBlAmt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return facFeuRt
	 */
	public String getFacFeuRt() {
		return this.facFeuRt;
	}
	
	/**
	 * Column Info
	 * @return porGrpTpCd
	 */
	public String getPorGrpTpCd() {
		return this.porGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
	}
	
	/**
	 * Column Info
	 * @return facBxRt
	 */
	public String getFacBxRt() {
		return this.facBxRt;
	}
	
	/**
	 * Column Info
	 * @return grsNetDivCd
	 */
	public String getGrsNetDivCd() {
		return this.grsNetDivCd;
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
	 * @return podRoutCd
	 */
	public String getPodRoutCd() {
		return this.podRoutCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCdSeq
	 */
	public String getFrtFwrdCntCdSeq() {
		return this.frtFwrdCntCdSeq;
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
	 * @return bkgFacRt
	 */
	public String getBkgFacRt() {
		return this.bkgFacRt;
	}
	
	/**
	 * Column Info
	 * @return facSglFlg
	 */
	public String getFacSglFlg() {
		return this.facSglFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}
	
	/**
	 * Column Info
	 * @return porRoutCd
	 */
	public String getPorRoutCd() {
		return this.porRoutCd;
	}
	
	/**
	 * Column Info
	 * @return shprCntNm
	 */
	public String getShprCntNm() {
		return this.shprCntNm;
	}
	
	/**
	 * Column Info
	 * @return facTeuRt
	 */
	public String getFacTeuRt() {
		return this.facTeuRt;
	}
	
	/**
	 * Column Info
	 * @return facDivCd
	 */
	public String getFacDivCd() {
		return this.facDivCd;
	}
	
	/**
	 * Column Info
	 * @return delGrpTpCd
	 */
	public String getDelGrpTpCd() {
		return this.delGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return delRoutCd
	 */
	public String getDelRoutCd() {
		return this.delRoutCd;
	}
	
	/**
	 * Column Info
	 * @return polRoutCd
	 */
	public String getPolRoutCd() {
		return this.polRoutCd;
	}
	
	/**
	 * Column Info
	 * @return facRtSeq
	 */
	public String getFacRtSeq() {
		return this.facRtSeq;
	}
	
	/**
	 * Column Info
	 * @return polGrpTpCd
	 */
	public String getPolGrpTpCd() {
		return this.polGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return facRfTeuRt
	 */
	public String getFacRfTeuRt() {
		return this.facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCustSeq
	 */
	public String getFrtFwrdCustSeq() {
		return this.frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpCd
	 */
	public String getCmdtTpCd() {
		return this.cmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return facChgCtnt
	 */
	public String getFacChgCtnt() {
		return this.facChgCtnt;
	}
	
	/**
	 * Column Info
	 * @return shprCntCdSeq
	 */
	public String getShprCntCdSeq() {
		return this.shprCntCdSeq;
	}
	
	/**
	 * Column Info
	 * @return facRfFeuRt
	 */
	public String getFacRfFeuRt() {
		return this.facRfFeuRt;
	}
	
	/**
	 * Column Info
	 * @return podGrpTpCd
	 */
	public String getPodGrpTpCd() {
		return this.podGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	

	/**
	 * Column Info
	 * @param frtFwrdCntNm
	 */
	public void setFrtFwrdCntNm(String frtFwrdCntNm) {
		this.frtFwrdCntNm = frtFwrdCntNm;
	}
	
	/**
	 * Column Info
	 * @param bkgFacBlAmt
	 */
	public void setBkgFacBlAmt(String bkgFacBlAmt) {
		this.bkgFacBlAmt = bkgFacBlAmt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param facFeuRt
	 */
	public void setFacFeuRt(String facFeuRt) {
		this.facFeuRt = facFeuRt;
	}
	
	/**
	 * Column Info
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
	}
	
	/**
	 * Column Info
	 * @param facBxRt
	 */
	public void setFacBxRt(String facBxRt) {
		this.facBxRt = facBxRt;
	}
	
	/**
	 * Column Info
	 * @param grsNetDivCd
	 */
	public void setGrsNetDivCd(String grsNetDivCd) {
		this.grsNetDivCd = grsNetDivCd;
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
	 * @param podRoutCd
	 */
	public void setPodRoutCd(String podRoutCd) {
		this.podRoutCd = podRoutCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCdSeq
	 */
	public void setFrtFwrdCntCdSeq(String frtFwrdCntCdSeq) {
		this.frtFwrdCntCdSeq = frtFwrdCntCdSeq;
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
	 * @param bkgFacRt
	 */
	public void setBkgFacRt(String bkgFacRt) {
		this.bkgFacRt = bkgFacRt;
	}
	
	/**
	 * Column Info
	 * @param facSglFlg
	 */
	public void setFacSglFlg(String facSglFlg) {
		this.facSglFlg = facSglFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}
	
	/**
	 * Column Info
	 * @param porRoutCd
	 */
	public void setPorRoutCd(String porRoutCd) {
		this.porRoutCd = porRoutCd;
	}
	
	/**
	 * Column Info
	 * @param shprCntNm
	 */
	public void setShprCntNm(String shprCntNm) {
		this.shprCntNm = shprCntNm;
	}
	
	/**
	 * Column Info
	 * @param facTeuRt
	 */
	public void setFacTeuRt(String facTeuRt) {
		this.facTeuRt = facTeuRt;
	}
	
	/**
	 * Column Info
	 * @param facDivCd
	 */
	public void setFacDivCd(String facDivCd) {
		this.facDivCd = facDivCd;
	}
	
	/**
	 * Column Info
	 * @param delGrpTpCd
	 */
	public void setDelGrpTpCd(String delGrpTpCd) {
		this.delGrpTpCd = delGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param delRoutCd
	 */
	public void setDelRoutCd(String delRoutCd) {
		this.delRoutCd = delRoutCd;
	}
	
	/**
	 * Column Info
	 * @param polRoutCd
	 */
	public void setPolRoutCd(String polRoutCd) {
		this.polRoutCd = polRoutCd;
	}
	
	/**
	 * Column Info
	 * @param facRtSeq
	 */
	public void setFacRtSeq(String facRtSeq) {
		this.facRtSeq = facRtSeq;
	}
	
	/**
	 * Column Info
	 * @param polGrpTpCd
	 */
	public void setPolGrpTpCd(String polGrpTpCd) {
		this.polGrpTpCd = polGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param facRfTeuRt
	 */
	public void setFacRfTeuRt(String facRfTeuRt) {
		this.facRfTeuRt = facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCustSeq
	 */
	public void setFrtFwrdCustSeq(String frtFwrdCustSeq) {
		this.frtFwrdCustSeq = frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtTpCd
	 */
	public void setCmdtTpCd(String cmdtTpCd) {
		this.cmdtTpCd = cmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param facChgCtnt
	 */
	public void setFacChgCtnt(String facChgCtnt) {
		this.facChgCtnt = facChgCtnt;
	}
	
	/**
	 * Column Info
	 * @param shprCntCdSeq
	 */
	public void setShprCntCdSeq(String shprCntCdSeq) {
		this.shprCntCdSeq = shprCntCdSeq;
	}
	
	/**
	 * Column Info
	 * @param facRfFeuRt
	 */
	public void setFacRfFeuRt(String facRfFeuRt) {
		this.facRfFeuRt = facRfFeuRt;
	}
	
	/**
	 * Column Info
	 * @param podGrpTpCd
	 */
	public void setPodGrpTpCd(String podGrpTpCd) {
		this.podGrpTpCd = podGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrtFwrdCntNm(JSPUtil.getParameter(request, "frt_fwrd_cnt_nm", ""));
		setBkgFacBlAmt(JSPUtil.getParameter(request, "bkg_fac_bl_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setFacFeuRt(JSPUtil.getParameter(request, "fac_feu_rt", ""));
		setPorGrpTpCd(JSPUtil.getParameter(request, "por_grp_tp_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, "bkg_rcv_term_cd", ""));
		setFacOfcCd(JSPUtil.getParameter(request, "fac_ofc_cd", ""));
		setFacBxRt(JSPUtil.getParameter(request, "fac_bx_rt", ""));
		setGrsNetDivCd(JSPUtil.getParameter(request, "grs_net_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodRoutCd(JSPUtil.getParameter(request, "pod_rout_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setFrtFwrdCntCdSeq(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgFacRt(JSPUtil.getParameter(request, "bkg_fac_rt", ""));
		setFacSglFlg(JSPUtil.getParameter(request, "fac_sgl_flg", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setFmEffDt(JSPUtil.getParameter(request, "fm_eff_dt", ""));
		setPorRoutCd(JSPUtil.getParameter(request, "por_rout_cd", ""));
		setShprCntNm(JSPUtil.getParameter(request, "shpr_cnt_nm", ""));
		setFacTeuRt(JSPUtil.getParameter(request, "fac_teu_rt", ""));
		setFacDivCd(JSPUtil.getParameter(request, "fac_div_cd", ""));
		setDelGrpTpCd(JSPUtil.getParameter(request, "del_grp_tp_cd", ""));
		setDelRoutCd(JSPUtil.getParameter(request, "del_rout_cd", ""));
		setPolRoutCd(JSPUtil.getParameter(request, "pol_rout_cd", ""));
		setFacRtSeq(JSPUtil.getParameter(request, "fac_rt_seq", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, "pol_grp_tp_cd", ""));
		setFacRfTeuRt(JSPUtil.getParameter(request, "fac_rf_teu_rt", ""));
		setToEffDt(JSPUtil.getParameter(request, "to_eff_dt", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, "frt_fwrd_cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setCmdtTpCd(JSPUtil.getParameter(request, "cmdt_tp_cd", ""));
		setFacChgCtnt(JSPUtil.getParameter(request, "fac_chg_ctnt", ""));
		setShprCntCdSeq(JSPUtil.getParameter(request, "shpr_cnt_cd_seq", ""));
		setFacRfFeuRt(JSPUtil.getParameter(request, "fac_rf_feu_rt", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, "pod_grp_tp_cd", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, "frt_fwrd_cnt_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, "bkg_de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGTFACRateInfoVO[]
	 */
	public AGTFACRateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AGTFACRateInfoVO[]
	 */
	public AGTFACRateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AGTFACRateInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frtFwrdCntNm = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_nm", length));
			String[] bkgFacBlAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_fac_bl_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] facFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_feu_rt", length));
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] facBxRt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_rt", length));
			String[] grsNetDivCd = (JSPUtil.getParameter(request, prefix	+ "grs_net_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] frtFwrdCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFacRt = (JSPUtil.getParameter(request, prefix	+ "bkg_fac_rt", length));
			String[] facSglFlg = (JSPUtil.getParameter(request, prefix	+ "fac_sgl_flg", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] shprCntNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_nm", length));
			String[] facTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_teu_rt", length));
			String[] facDivCd = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd", length));
			String[] delGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "del_grp_tp_cd", length));
			String[] delRoutCd = (JSPUtil.getParameter(request, prefix	+ "del_rout_cd", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] facRtSeq = (JSPUtil.getParameter(request, prefix	+ "fac_rt_seq", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] facRfTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_rt", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp_cd", length));
			String[] facChgCtnt = (JSPUtil.getParameter(request, prefix	+ "fac_chg_ctnt", length));
			String[] shprCntCdSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd_seq", length));
			String[] facRfFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_rt", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AGTFACRateInfoVO();
				if (frtFwrdCntNm[i] != null)
					model.setFrtFwrdCntNm(frtFwrdCntNm[i]);
				if (bkgFacBlAmt[i] != null)
					model.setBkgFacBlAmt(bkgFacBlAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (facFeuRt[i] != null)
					model.setFacFeuRt(facFeuRt[i]);
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (facBxRt[i] != null)
					model.setFacBxRt(facBxRt[i]);
				if (grsNetDivCd[i] != null)
					model.setGrsNetDivCd(grsNetDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (frtFwrdCntCdSeq[i] != null)
					model.setFrtFwrdCntCdSeq(frtFwrdCntCdSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFacRt[i] != null)
					model.setBkgFacRt(bkgFacRt[i]);
				if (facSglFlg[i] != null)
					model.setFacSglFlg(facSglFlg[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (shprCntNm[i] != null)
					model.setShprCntNm(shprCntNm[i]);
				if (facTeuRt[i] != null)
					model.setFacTeuRt(facTeuRt[i]);
				if (facDivCd[i] != null)
					model.setFacDivCd(facDivCd[i]);
				if (delGrpTpCd[i] != null)
					model.setDelGrpTpCd(delGrpTpCd[i]);
				if (delRoutCd[i] != null)
					model.setDelRoutCd(delRoutCd[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (facRtSeq[i] != null)
					model.setFacRtSeq(facRtSeq[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (facRfTeuRt[i] != null)
					model.setFacRfTeuRt(facRfTeuRt[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cmdtTpCd[i] != null)
					model.setCmdtTpCd(cmdtTpCd[i]);
				if (facChgCtnt[i] != null)
					model.setFacChgCtnt(facChgCtnt[i]);
				if (shprCntCdSeq[i] != null)
					model.setShprCntCdSeq(shprCntCdSeq[i]);
				if (facRfFeuRt[i] != null)
					model.setFacRfFeuRt(facRfFeuRt[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAGTFACRateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AGTFACRateInfoVO[]
	 */
	public AGTFACRateInfoVO[] getAGTFACRateInfoVOs(){
		AGTFACRateInfoVO[] vos = (AGTFACRateInfoVO[])models.toArray(new AGTFACRateInfoVO[models.size()]);
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
		this.frtFwrdCntNm = this.frtFwrdCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFacBlAmt = this.bkgFacBlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facFeuRt = this.facFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBxRt = this.facBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsNetDivCd = this.grsNetDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCdSeq = this.frtFwrdCntCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFacRt = this.bkgFacRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSglFlg = this.facSglFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntNm = this.shprCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facTeuRt = this.facTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd = this.facDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delGrpTpCd = this.delGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRoutCd = this.delRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRtSeq = this.facRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuRt = this.facRfTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpCd = this.cmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facChgCtnt = this.facChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCdSeq = this.shprCntCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuRt = this.facRfFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
