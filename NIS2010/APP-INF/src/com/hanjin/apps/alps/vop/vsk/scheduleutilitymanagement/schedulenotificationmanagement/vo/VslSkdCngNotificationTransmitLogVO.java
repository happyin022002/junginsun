/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VslSkdCngNotificationTransmitLogVO.java
*@FileTitle : VslSkdCngNotificationTransmitLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.08.02 정상기 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.vo;

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
 * @author 정상기
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngNotificationTransmitLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdCngNotificationTransmitLogVO> models = new ArrayList<VslSkdCngNotificationTransmitLogVO>();
	
	/* Column Info */
	private String trsmDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ntfcTrsmHisSeq = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pairRvsPortCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String portSkpTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pairRvsClptIndSeq = null;
	/* Column Info */
	private String trsmMzdCd = null;
	/* Column Info */
	private String hisDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ntfcTrsmTpCd = null;
	/* Column Info */
	private String vvdHisSeq = null;
	/* Column Info */
	private String pfEtdDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String bfrYdCd = null;
	/* Column Info */
	private String pfEtaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String pfEtbDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String clptIndSeq = null;
	
	/* Column Info */
	private String etaDelayHrs = null;
	/* Column Info */
	private String etbDelayHrs = null;
	/* Column Info */
	private String etdDelayHrs = null;	
	
	/* Column Info */
	private String hisCreUsrId = null;
	
	/* Column Info */
	private String etaDlayFmHrs = null;
	/* Column Info */
	private String etaDlayToHrs = null;
	/* Column Info */
	private String etbDlayFmHrs = null;
	/* Column Info */
	private String etbDlayToHrs = null;
	/* Column Info */
	private String etdDlayFmHrs = null;
	/* Column Info */
	private String etdDlayToHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdCngNotificationTransmitLogVO() {}

	public VslSkdCngNotificationTransmitLogVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String usrId, String ntfcTrsmHisSeq, String vvdHisSeq, String hisDtlSeq, String vslSlanCd, String trsmMzdCd, String ntfcTrsmTpCd, String pfEtaDt, String pfEtbDt, String pfEtdDt, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String portSkpTpCd, String bfrYdCd, String crntYdCd, String pairRvsPortCd, String pairRvsClptIndSeq, String sndrEml, String rcvrEml, String emlSndNo, String trsmDt, String creUsrId, String creDt, String updUsrId, String updDt, String etaDelayHrs, String etbDelayHrs, String etdDelayHrs, String hisCreUsrId, String etaDlayFmHrs, String etaDlayToHrs, String etbDlayFmHrs, String etbDlayToHrs, String etdDlayFmHrs, String etdDlayToHrs) {
		this.trsmDt = trsmDt;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.creDt = creDt;
		this.ntfcTrsmHisSeq = ntfcTrsmHisSeq;
		this.sndrEml = sndrEml;
		this.crntYdCd = crntYdCd;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.pairRvsPortCd = pairRvsPortCd;
		this.vpsPortCd = vpsPortCd;
		this.portSkpTpCd = portSkpTpCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.pairRvsClptIndSeq = pairRvsClptIndSeq;
		this.trsmMzdCd = trsmMzdCd;
		this.hisDtlSeq = hisDtlSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ntfcTrsmTpCd = ntfcTrsmTpCd;
		this.vvdHisSeq = vvdHisSeq;
		this.pfEtdDt = pfEtdDt;
		this.vpsEtdDt = vpsEtdDt;
		this.bfrYdCd = bfrYdCd;
		this.pfEtaDt = pfEtaDt;
		this.skdVoyNo = skdVoyNo;
		this.emlSndNo = emlSndNo;
		this.pfEtbDt = pfEtbDt;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.rcvrEml = rcvrEml;
		this.clptIndSeq = clptIndSeq;
		
		this.etaDelayHrs = etaDelayHrs;
		this.etbDelayHrs = etbDelayHrs;
		this.etdDelayHrs = etdDelayHrs;
		
		this.hisCreUsrId = hisCreUsrId;
		
		this.etaDlayFmHrs = etaDlayFmHrs;
		this.etaDlayToHrs = etaDlayToHrs;
		this.etbDlayFmHrs = etbDlayFmHrs;
		this.etbDlayToHrs = etbDlayToHrs;
		this.etdDlayFmHrs = etdDlayFmHrs;
		this.etdDlayToHrs = etdDlayToHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsm_dt", getTrsmDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ntfc_trsm_his_seq", getNtfcTrsmHisSeq());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pair_rvs_port_cd", getPairRvsPortCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("port_skp_tp_cd", getPortSkpTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pair_rvs_clpt_ind_seq", getPairRvsClptIndSeq());
		this.hashColumns.put("trsm_mzd_cd", getTrsmMzdCd());
		this.hashColumns.put("his_dtl_seq", getHisDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ntfc_trsm_tp_cd", getNtfcTrsmTpCd());
		this.hashColumns.put("vvd_his_seq", getVvdHisSeq());
		this.hashColumns.put("pf_etd_dt", getPfEtdDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("bfr_yd_cd", getBfrYdCd());
		this.hashColumns.put("pf_eta_dt", getPfEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("pf_etb_dt", getPfEtbDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		
		this.hashColumns.put("eta_delay_hrs", getEtaDelayHrs());
		this.hashColumns.put("etb_delay_hrs", getEtbDelayHrs());
		this.hashColumns.put("etd_delay_hrs", getEtdDelayHrs());
		
		this.hashColumns.put("his_cre_usr_id", getHisCreUsrId());
		
		this.hashColumns.put("eta_dlay_fm_hrs", getEtaDlayFmHrs());
		this.hashColumns.put("eta_dlay_to_hrs", getEtaDlayToHrs());
		this.hashColumns.put("etb_dlay_fm_hrs", getEtbDlayFmHrs());
		this.hashColumns.put("etb_dlay_to_hrs", getEtbDlayToHrs());
		this.hashColumns.put("etd_dlay_fm_hrs", getEtdDlayFmHrs());
		this.hashColumns.put("etd_dlay_to_hrs", getEtdDlayToHrs());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsm_dt", "trsmDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ntfc_trsm_his_seq", "ntfcTrsmHisSeq");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pair_rvs_port_cd", "pairRvsPortCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("port_skp_tp_cd", "portSkpTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pair_rvs_clpt_ind_seq", "pairRvsClptIndSeq");
		this.hashFields.put("trsm_mzd_cd", "trsmMzdCd");
		this.hashFields.put("his_dtl_seq", "hisDtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ntfc_trsm_tp_cd", "ntfcTrsmTpCd");
		this.hashFields.put("vvd_his_seq", "vvdHisSeq");
		this.hashFields.put("pf_etd_dt", "pfEtdDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("bfr_yd_cd", "bfrYdCd");
		this.hashFields.put("pf_eta_dt", "pfEtaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("pf_etb_dt", "pfEtbDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		
		this.hashFields.put("eta_delay_hrs", "etaDelayHrs");
		this.hashFields.put("etb_delay_hrs", "etbDelayHrs");
		this.hashFields.put("etd_delay_hrs", "etdDelayHrs");
		
		this.hashFields.put("his_cre_usr_id", "hisCreUsrId");
		
		this.hashFields.put("eta_dlay_fm_hrs", "etaDlayFmHrs");
		this.hashFields.put("eta_dlay_to_hrs", "etaDlayToHrs");
		this.hashFields.put("etb_dlay_fm_hrs", "etbDlayFmHrs");
		this.hashFields.put("etb_dlay_to_hrs", "etbDlayToHrs");
		this.hashFields.put("etd_dlay_fm_hrs", "etdDlayFmHrs");
		this.hashFields.put("etd_dlay_to_hrs", "etdDlayToHrs");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trsmDt
	 */
	public String getTrsmDt() {
		return this.trsmDt;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ntfcTrsmHisSeq
	 */
	public String getNtfcTrsmHisSeq() {
		return this.ntfcTrsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return pairRvsPortCd
	 */
	public String getPairRvsPortCd() {
		return this.pairRvsPortCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return portSkpTpCd
	 */
	public String getPortSkpTpCd() {
		return this.portSkpTpCd;
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
	 * @return pairRvsClptIndSeq
	 */
	public String getPairRvsClptIndSeq() {
		return this.pairRvsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return trsmMzdCd
	 */
	public String getTrsmMzdCd() {
		return this.trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @return hisDtlSeq
	 */
	public String getHisDtlSeq() {
		return this.hisDtlSeq;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ntfcTrsmTpCd
	 */
	public String getNtfcTrsmTpCd() {
		return this.ntfcTrsmTpCd;
	}
	
	/**
	 * Column Info
	 * @return vvdHisSeq
	 */
	public String getVvdHisSeq() {
		return this.vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @return pfEtdDt
	 */
	public String getPfEtdDt() {
		return this.pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return bfrYdCd
	 */
	public String getBfrYdCd() {
		return this.bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @return pfEtaDt
	 */
	public String getPfEtaDt() {
		return this.pfEtaDt;
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
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return pfEtbDt
	 */
	public String getPfEtbDt() {
		return this.pfEtbDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	
	/**
	 * Column Info
	 * @return etaDelayHrs
	 */
	public String getEtaDelayHrs() {
		return this.etaDelayHrs;
	}
	/**
	 * Column Info
	 * @return etbDelayHrs
	 */
	public String getEtbDelayHrs() {
		return this.etbDelayHrs;
	}
	/**
	 * Column Info
	 * @return etdDelayHrs
	 */
	public String getEtdDelayHrs() {
		return this.etdDelayHrs;
	}
	
	/**
	 * Column Info
	 * @return hisCreUsrId
	 */
	public String getHisCreUsrId() {
		return this.hisCreUsrId;
	}

	
	/**
	 * Column Info
	 * @return etaDlayFmHrs
	 */
	public String getEtaDlayFmHrs() {
		return this.etaDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @return etaDlayToHrs
	 */
	public String getEtaDlayToHrs() {
		return this.etaDlayToHrs;
	}
	
	/**
	 * Column Info
	 * @return etbDlayFmHrs
	 */
	public String getEtbDlayFmHrs() {
		return this.etbDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @return etbDlayToHrs
	 */
	public String getEtbDlayToHrs() {
		return this.etbDlayToHrs;
	}
	
	/**
	 * Column Info
	 * @return etdDlayFmHrs
	 */
	public String getEtdDlayFmHrs() {
		return this.etdDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @return etdDlayToHrs
	 */
	public String getEtdDlayToHrs() {
		return this.etdDlayToHrs;
	}
	
	/**
	 * Column Info
	 * @param trsmDt
	 */
	public void setTrsmDt(String trsmDt) {
		this.trsmDt = trsmDt;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ntfcTrsmHisSeq
	 */
	public void setNtfcTrsmHisSeq(String ntfcTrsmHisSeq) {
		this.ntfcTrsmHisSeq = ntfcTrsmHisSeq;
	}
	
	/**
	 * Column Info
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param pairRvsPortCd
	 */
	public void setPairRvsPortCd(String pairRvsPortCd) {
		this.pairRvsPortCd = pairRvsPortCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param portSkpTpCd
	 */
	public void setPortSkpTpCd(String portSkpTpCd) {
		this.portSkpTpCd = portSkpTpCd;
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
	 * @param pairRvsClptIndSeq
	 */
	public void setPairRvsClptIndSeq(String pairRvsClptIndSeq) {
		this.pairRvsClptIndSeq = pairRvsClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param trsmMzdCd
	 */
	public void setTrsmMzdCd(String trsmMzdCd) {
		this.trsmMzdCd = trsmMzdCd;
	}
	
	/**
	 * Column Info
	 * @param hisDtlSeq
	 */
	public void setHisDtlSeq(String hisDtlSeq) {
		this.hisDtlSeq = hisDtlSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ntfcTrsmTpCd
	 */
	public void setNtfcTrsmTpCd(String ntfcTrsmTpCd) {
		this.ntfcTrsmTpCd = ntfcTrsmTpCd;
	}
	
	/**
	 * Column Info
	 * @param vvdHisSeq
	 */
	public void setVvdHisSeq(String vvdHisSeq) {
		this.vvdHisSeq = vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @param pfEtdDt
	 */
	public void setPfEtdDt(String pfEtdDt) {
		this.pfEtdDt = pfEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param bfrYdCd
	 */
	public void setBfrYdCd(String bfrYdCd) {
		this.bfrYdCd = bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @param pfEtaDt
	 */
	public void setPfEtaDt(String pfEtaDt) {
		this.pfEtaDt = pfEtaDt;
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
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param pfEtbDt
	 */
	public void setPfEtbDt(String pfEtbDt) {
		this.pfEtbDt = pfEtbDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param etaDelayHrs
	 */
	public void setEtaDelayHrs(String etaDelayHrs) {
		this.etaDelayHrs = etaDelayHrs;
	}
	/**
	 * Column Info
	 * @param etbDelayHrs
	 */
	public void setEtbDelayHrs(String etbDelayHrs) {
		this.etbDelayHrs = etbDelayHrs;
	}
	/**
	 * Column Info
	 * @param etdDelayHrs
	 */
	public void setEtdDelayHrs(String etdDelayHrs) {
		this.etdDelayHrs = etdDelayHrs;
	}
	
	/**
	 * Column Info
	 * @param hisCreUsrId
	 */
	public void setHisCreUsrId(String hisCreUsrId) {
		this.hisCreUsrId = hisCreUsrId;
	}
	
	
	/**
	 * Column Info
	 * @param etaDlayFmHrs
	 */
	public void setEtaDlayFmHrs(String etaDlayFmHrs) {
		this.etaDlayFmHrs = etaDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @param etaDlayToHrs
	 */
	public void setEtaDlayToHrs(String etaDlayToHrs) {
		this.etaDlayToHrs = etaDlayToHrs;
	}
	
	/**
	 * Column Info
	 * @param etbDlayFmHrs
	 */
	public void setEtbDlayFmHrs(String etbDlayFmHrs) {
		this.etbDlayFmHrs = etbDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @param etbDlayToHrs
	 */
	public void setEtbDlayToHrs(String etbDlayToHrs) {
		this.etbDlayToHrs = etbDlayToHrs;
	}
	
	/**
	 * Column Info
	 * @param etdDlayFmHrs
	 */
	public void setEtdDlayFmHrs(String etdDlayFmHrs) {
		this.etdDlayFmHrs = etdDlayFmHrs;
	}
	
	/**
	 * Column Info
	 * @param etdDlayToHrs
	 */
	public void setEtdDlayToHrs(String etdDlayToHrs) {
		this.etdDlayToHrs = etdDlayToHrs;
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
		setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNtfcTrsmHisSeq(JSPUtil.getParameter(request, prefix + "ntfc_trsm_his_seq", ""));
		setSndrEml(JSPUtil.getParameter(request, prefix + "sndr_eml", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPairRvsPortCd(JSPUtil.getParameter(request, prefix + "pair_rvs_port_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setPortSkpTpCd(JSPUtil.getParameter(request, prefix + "port_skp_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPairRvsClptIndSeq(JSPUtil.getParameter(request, prefix + "pair_rvs_clpt_ind_seq", ""));
		setTrsmMzdCd(JSPUtil.getParameter(request, prefix + "trsm_mzd_cd", ""));
		setHisDtlSeq(JSPUtil.getParameter(request, prefix + "his_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNtfcTrsmTpCd(JSPUtil.getParameter(request, prefix + "ntfc_trsm_tp_cd", ""));
		setVvdHisSeq(JSPUtil.getParameter(request, prefix + "vvd_his_seq", ""));
		setPfEtdDt(JSPUtil.getParameter(request, prefix + "pf_etd_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setBfrYdCd(JSPUtil.getParameter(request, prefix + "bfr_yd_cd", ""));
		setPfEtaDt(JSPUtil.getParameter(request, prefix + "pf_eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setPfEtbDt(JSPUtil.getParameter(request, prefix + "pf_etb_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		
		setEtaDelayHrs(JSPUtil.getParameter(request, prefix + "eta_delay_hrs", ""));
		setEtbDelayHrs(JSPUtil.getParameter(request, prefix + "etb_delay_hrs", ""));
		setEtdDelayHrs(JSPUtil.getParameter(request, prefix + "etd_delay_hrs", ""));
		
		setHisCreUsrId(JSPUtil.getParameter(request, prefix + "his_cre_usr_id", ""));	
		
		setEtaDlayFmHrs(JSPUtil.getParameter(request, prefix + "eta_dlay_fm_hrs", ""));
		setEtaDlayToHrs(JSPUtil.getParameter(request, prefix + "eta_dlay_to_hrs", ""));
		setEtbDlayFmHrs(JSPUtil.getParameter(request, prefix + "etb_dlay_fm_hrs", ""));
		setEtbDlayToHrs(JSPUtil.getParameter(request, prefix + "etb_dlay_to_hrs", ""));
		setEtdDlayFmHrs(JSPUtil.getParameter(request, prefix + "etd_dlay_fm_hrs", ""));
		setEtdDlayToHrs(JSPUtil.getParameter(request, prefix + "etd_dlay_to_hrs", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdCngNotificationTransmitLogVO[]
	 */
	public VslSkdCngNotificationTransmitLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdCngNotificationTransmitLogVO[]
	 */
	public VslSkdCngNotificationTransmitLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdCngNotificationTransmitLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trsmDt = (JSPUtil.getParameter(request, prefix	+ "trsm_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ntfcTrsmHisSeq = (JSPUtil.getParameter(request, prefix	+ "ntfc_trsm_his_seq", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pairRvsPortCd = (JSPUtil.getParameter(request, prefix	+ "pair_rvs_port_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] portSkpTpCd = (JSPUtil.getParameter(request, prefix	+ "port_skp_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pairRvsClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pair_rvs_clpt_ind_seq", length));
			String[] trsmMzdCd = (JSPUtil.getParameter(request, prefix	+ "trsm_mzd_cd", length));
			String[] hisDtlSeq = (JSPUtil.getParameter(request, prefix	+ "his_dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ntfcTrsmTpCd = (JSPUtil.getParameter(request, prefix	+ "ntfc_trsm_tp_cd", length));
			String[] vvdHisSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_his_seq", length));
			String[] pfEtdDt = (JSPUtil.getParameter(request, prefix	+ "pf_etd_dt", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] bfrYdCd = (JSPUtil.getParameter(request, prefix	+ "bfr_yd_cd", length));
			String[] pfEtaDt = (JSPUtil.getParameter(request, prefix	+ "pf_eta_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] pfEtbDt = (JSPUtil.getParameter(request, prefix	+ "pf_etb_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			
			String[] etaDelayHrs = (JSPUtil.getParameter(request, prefix	+ "eta_delay_hrs", length));
			String[] etbDelayHrs = (JSPUtil.getParameter(request, prefix	+ "etb_delay_hrs", length));
			String[] etdDelayHrs = (JSPUtil.getParameter(request, prefix	+ "etd_delay_hrs", length));
			
			String[] hisCreUsrId = (JSPUtil.getParameter(request, prefix	+ "his_cre_usr_id", length));
			
			String[] etaDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_fm_hrs", length));
			String[] etaDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "eta_dlay_to_hrs", length));
			String[] etbDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_fm_hrs", length));
			String[] etbDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "etb_dlay_to_hrs", length));
			String[] etdDlayFmHrs = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_fm_hrs", length));
			String[] etdDlayToHrs = (JSPUtil.getParameter(request, prefix	+ "etd_dlay_to_hrs", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdCngNotificationTransmitLogVO();
				if (trsmDt[i] != null)
					model.setTrsmDt(trsmDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ntfcTrsmHisSeq[i] != null)
					model.setNtfcTrsmHisSeq(ntfcTrsmHisSeq[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pairRvsPortCd[i] != null)
					model.setPairRvsPortCd(pairRvsPortCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (portSkpTpCd[i] != null)
					model.setPortSkpTpCd(portSkpTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pairRvsClptIndSeq[i] != null)
					model.setPairRvsClptIndSeq(pairRvsClptIndSeq[i]);
				if (trsmMzdCd[i] != null)
					model.setTrsmMzdCd(trsmMzdCd[i]);
				if (hisDtlSeq[i] != null)
					model.setHisDtlSeq(hisDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ntfcTrsmTpCd[i] != null)
					model.setNtfcTrsmTpCd(ntfcTrsmTpCd[i]);
				if (vvdHisSeq[i] != null)
					model.setVvdHisSeq(vvdHisSeq[i]);
				if (pfEtdDt[i] != null)
					model.setPfEtdDt(pfEtdDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (bfrYdCd[i] != null)
					model.setBfrYdCd(bfrYdCd[i]);
				if (pfEtaDt[i] != null)
					model.setPfEtaDt(pfEtaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (pfEtbDt[i] != null)
					model.setPfEtbDt(pfEtbDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				
				if (etaDelayHrs[i] != null)
					model.setEtaDelayHrs(etaDelayHrs[i]);
				if (etbDelayHrs[i] != null)
					model.setEtbDelayHrs(etbDelayHrs[i]);
				if (etdDelayHrs[i] != null)
					model.setEtdDelayHrs(etdDelayHrs[i]);
				
				if (hisCreUsrId[i] != null)
					model.setHisCreUsrId(hisCreUsrId[i]);
				
				if (etaDlayFmHrs[i] != null)
					model.setEtaDlayFmHrs(etaDlayFmHrs[i]);
				if (etaDlayToHrs[i] != null)
					model.setEtaDlayToHrs(etaDlayToHrs[i]);
				if (etbDlayFmHrs[i] != null)
					model.setEtbDlayFmHrs(etbDlayFmHrs[i]);
				if (etbDlayToHrs[i] != null)
					model.setEtbDlayToHrs(etbDlayToHrs[i]);
				if (etdDlayFmHrs[i] != null)
					model.setEtdDlayFmHrs(etdDlayFmHrs[i]);
				if (etdDlayToHrs[i] != null)
					model.setEtdDlayToHrs(etdDlayToHrs[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdCngNotificationTransmitLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdCngNotificationTransmitLogVO[]
	 */
	public VslSkdCngNotificationTransmitLogVO[] getVslSkdCngNotificationTransmitLogVOs(){
		VslSkdCngNotificationTransmitLogVO[] vos = (VslSkdCngNotificationTransmitLogVO[])models.toArray(new VslSkdCngNotificationTransmitLogVO[models.size()]);
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
		this.trsmDt = this.trsmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcTrsmHisSeq = this.ntfcTrsmHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairRvsPortCd = this.pairRvsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpTpCd = this.portSkpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pairRvsClptIndSeq = this.pairRvsClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMzdCd = this.trsmMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlSeq = this.hisDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfcTrsmTpCd = this.ntfcTrsmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHisSeq = this.vvdHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtdDt = this.pfEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrYdCd = this.bfrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtaDt = this.pfEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfEtbDt = this.pfEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	
		this.etaDelayHrs = this.etaDelayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDelayHrs = this.etbDelayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDelayHrs = this.etdDelayHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.hisCreUsrId = this.hisCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.etaDlayFmHrs = this.etaDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDlayToHrs = this.etaDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDlayFmHrs = this.etbDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDlayToHrs = this.etbDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDlayFmHrs = this.etdDlayFmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDlayToHrs = this.etdDlayToHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}

