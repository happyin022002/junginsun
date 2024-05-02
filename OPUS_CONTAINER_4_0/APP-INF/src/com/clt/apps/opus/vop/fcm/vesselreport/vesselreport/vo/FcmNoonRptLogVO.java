/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmNoonRptLogVO.java
*@FileTitle : FcmNoonRptLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.11 진마리아 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmNoonRptLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmNoonRptLogVO> models = new ArrayList<FcmNoonRptLogVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String noonRptDt = null;
	/* Column Info */
	private String mnLowSulpDoilCsmQty = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sailHrmnt = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String nvgtMlDist = null;
	/* Column Info */
	private String hldTempChkFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dgSailFlg = null;
	/* Column Info */
	private String visRngNo = null;
	/* Column Info */
	private String mnDoilCsmQty = null;
	/* Column Info */
	private String lodIndQty = null;
	/* Column Info */
	private String noonRptLon = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String rmnDist = null;
	/* Column Info */
	private String engMlDist = null;
	/* Column Info */
	private String hldGasChkFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String nxtPortEtaDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String rmnAvgSpd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String blstXchFlg = null;
	/* Column Info */
	private String eaiIfRmk = null;
	/* Column Info */
	private String gnrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String dgSailRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnLowSulpFoilCsmQty = null;
	/* Column Info */
	private String voyDirCd = null;
	/* Column Info */
	private String gnrFoilCsmQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slpRt = null;
	/* Column Info */
	private String bilgeChkFlg = null;
	/* Column Info */
	private String crsNo = null;
	/* Column Info */
	private String blrFoilCsmQty = null;
	/* Column Info */
	private String blrLowSulpFoilCsmQty = null;
	/* Column Info */
	private String pscPrprFlg = null;
	/* Column Info */
	private String mnPwr = null;
	/* Column Info */
	private String mnFoilCsmQty = null;
	/* Column Info */
	private String sailAvgRpmPwr = null;
	/* Column Info */
	private String noonRptLat = null;
	/* Column Info */
	private String hldClnFlg = null;
	/* Column Info */
	private String noonRptRmk = null;
	/* Column Info */
	private String sailAvgSpd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String wndFrc = null;
	/* Column Info */
	private String seaFrc = null;
	/* Column Info */
	private String vslRptTjTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmNoonRptLogVO() {}

	public FcmNoonRptLogVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String vslCd, String voyDirCd, String vslSlanCd, String refNo, String noonRptDt, String noonRptLat, String noonRptLon, String wndFrc, String seaFrc, String visRngNo, String sailHrmnt, String nvgtMlDist, String sailAvgSpd, String mnPwr, String engMlDist, String sailAvgRpmPwr, String slpRt, String lodIndQty, String rmnDist, String rmnAvgSpd, String crsNo, String mnFoilCsmQty, String mnLowSulpFoilCsmQty, String gnrFoilCsmQty, String gnrLowSulpFoilCsmQty, String blrFoilCsmQty, String blrLowSulpFoilCsmQty, String mnDoilCsmQty, String mnLowSulpDoilCsmQty, String nxtPortCd, String nxtPortEtaDt, String bilgeChkFlg, String hldGasChkFlg, String hldTempChkFlg, String blstXchFlg, String hldClnFlg, String pscPrprFlg, String dgSailFlg, String dgSailRmk, String noonRptRmk, String eaiIfId, String ifFlg, String eaiIfRmk, String creUsrId, String creDt, String updUsrId, String updDt, String vslRptTjTpCd) {
		this.vslCd = vslCd;
		this.noonRptDt = noonRptDt;
		this.mnLowSulpDoilCsmQty = mnLowSulpDoilCsmQty;
		this.nxtPortCd = nxtPortCd;
		this.pagerows = pagerows;
		this.sailHrmnt = sailHrmnt;
		this.rcvDt = rcvDt;
		this.nvgtMlDist = nvgtMlDist;
		this.hldTempChkFlg = hldTempChkFlg;
		this.updUsrId = updUsrId;
		this.dgSailFlg = dgSailFlg;
		this.visRngNo = visRngNo;
		this.mnDoilCsmQty = mnDoilCsmQty;
		this.lodIndQty = lodIndQty;
		this.noonRptLon = noonRptLon;
		this.ifFlg = ifFlg;
		this.rmnDist = rmnDist;
		this.engMlDist = engMlDist;
		this.hldGasChkFlg = hldGasChkFlg;
		this.creUsrId = creUsrId;
		this.nxtPortEtaDt = nxtPortEtaDt;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.rcvSeq = rcvSeq;
		this.rmnAvgSpd = rmnAvgSpd;
		this.vslSlanCd = vslSlanCd;
		this.blstXchFlg = blstXchFlg;
		this.eaiIfRmk = eaiIfRmk;
		this.gnrLowSulpFoilCsmQty = gnrLowSulpFoilCsmQty;
		this.dgSailRmk = dgSailRmk;
		this.ibflag = ibflag;
		this.mnLowSulpFoilCsmQty = mnLowSulpFoilCsmQty;
		this.voyDirCd = voyDirCd;
		this.gnrFoilCsmQty = gnrFoilCsmQty;
		this.updDt = updDt;
		this.slpRt = slpRt;
		this.bilgeChkFlg = bilgeChkFlg;
		this.crsNo = crsNo;
		this.blrFoilCsmQty = blrFoilCsmQty;
		this.blrLowSulpFoilCsmQty = blrLowSulpFoilCsmQty;
		this.pscPrprFlg = pscPrprFlg;
		this.mnPwr = mnPwr;
		this.mnFoilCsmQty = mnFoilCsmQty;
		this.sailAvgRpmPwr = sailAvgRpmPwr;
		this.noonRptLat = noonRptLat;
		this.hldClnFlg = hldClnFlg;
		this.noonRptRmk = noonRptRmk;
		this.sailAvgSpd = sailAvgSpd;
		this.refNo = refNo;
		this.wndFrc = wndFrc;
		this.seaFrc = seaFrc;
		this.vslRptTjTpCd = vslRptTjTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("noon_rpt_dt", getNoonRptDt());
		this.hashColumns.put("mn_low_sulp_doil_csm_qty", getMnLowSulpDoilCsmQty());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sail_hrmnt", getSailHrmnt());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("nvgt_ml_dist", getNvgtMlDist());
		this.hashColumns.put("hld_temp_chk_flg", getHldTempChkFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dg_sail_flg", getDgSailFlg());
		this.hashColumns.put("vis_rng_no", getVisRngNo());
		this.hashColumns.put("mn_doil_csm_qty", getMnDoilCsmQty());
		this.hashColumns.put("lod_ind_qty", getLodIndQty());
		this.hashColumns.put("noon_rpt_lon", getNoonRptLon());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("rmn_dist", getRmnDist());
		this.hashColumns.put("eng_ml_dist", getEngMlDist());
		this.hashColumns.put("hld_gas_chk_flg", getHldGasChkFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("nxt_port_eta_dt", getNxtPortEtaDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("rmn_avg_spd", getRmnAvgSpd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("blst_xch_flg", getBlstXchFlg());
		this.hashColumns.put("eai_if_rmk", getEaiIfRmk());
		this.hashColumns.put("gnr_low_sulp_foil_csm_qty", getGnrLowSulpFoilCsmQty());
		this.hashColumns.put("dg_sail_rmk", getDgSailRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mn_low_sulp_foil_csm_qty", getMnLowSulpFoilCsmQty());
		this.hashColumns.put("voy_dir_cd", getVoyDirCd());
		this.hashColumns.put("gnr_foil_csm_qty", getGnrFoilCsmQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("slp_rt", getSlpRt());
		this.hashColumns.put("bilge_chk_flg", getBilgeChkFlg());
		this.hashColumns.put("crs_no", getCrsNo());
		this.hashColumns.put("blr_foil_csm_qty", getBlrFoilCsmQty());
		this.hashColumns.put("blr_low_sulp_foil_csm_qty", getBlrLowSulpFoilCsmQty());
		this.hashColumns.put("psc_prpr_flg", getPscPrprFlg());
		this.hashColumns.put("mn_pwr", getMnPwr());
		this.hashColumns.put("mn_foil_csm_qty", getMnFoilCsmQty());
		this.hashColumns.put("sail_avg_rpm_pwr", getSailAvgRpmPwr());
		this.hashColumns.put("noon_rpt_lat", getNoonRptLat());
		this.hashColumns.put("hld_cln_flg", getHldClnFlg());
		this.hashColumns.put("noon_rpt_rmk", getNoonRptRmk());
		this.hashColumns.put("sail_avg_spd", getSailAvgSpd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("wnd_frc", getWndFrc());
		this.hashColumns.put("sea_frc", getSeaFrc());
		this.hashColumns.put("vsl_rpt_tj_tp_cd", getVslRptTjTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("noon_rpt_dt", "noonRptDt");
		this.hashFields.put("mn_low_sulp_doil_csm_qty", "mnLowSulpDoilCsmQty");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sail_hrmnt", "sailHrmnt");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("nvgt_ml_dist", "nvgtMlDist");
		this.hashFields.put("hld_temp_chk_flg", "hldTempChkFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dg_sail_flg", "dgSailFlg");
		this.hashFields.put("vis_rng_no", "visRngNo");
		this.hashFields.put("mn_doil_csm_qty", "mnDoilCsmQty");
		this.hashFields.put("lod_ind_qty", "lodIndQty");
		this.hashFields.put("noon_rpt_lon", "noonRptLon");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("rmn_dist", "rmnDist");
		this.hashFields.put("eng_ml_dist", "engMlDist");
		this.hashFields.put("hld_gas_chk_flg", "hldGasChkFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("nxt_port_eta_dt", "nxtPortEtaDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("rmn_avg_spd", "rmnAvgSpd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("blst_xch_flg", "blstXchFlg");
		this.hashFields.put("eai_if_rmk", "eaiIfRmk");
		this.hashFields.put("gnr_low_sulp_foil_csm_qty", "gnrLowSulpFoilCsmQty");
		this.hashFields.put("dg_sail_rmk", "dgSailRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mn_low_sulp_foil_csm_qty", "mnLowSulpFoilCsmQty");
		this.hashFields.put("voy_dir_cd", "voyDirCd");
		this.hashFields.put("gnr_foil_csm_qty", "gnrFoilCsmQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("slp_rt", "slpRt");
		this.hashFields.put("bilge_chk_flg", "bilgeChkFlg");
		this.hashFields.put("crs_no", "crsNo");
		this.hashFields.put("blr_foil_csm_qty", "blrFoilCsmQty");
		this.hashFields.put("blr_low_sulp_foil_csm_qty", "blrLowSulpFoilCsmQty");
		this.hashFields.put("psc_prpr_flg", "pscPrprFlg");
		this.hashFields.put("mn_pwr", "mnPwr");
		this.hashFields.put("mn_foil_csm_qty", "mnFoilCsmQty");
		this.hashFields.put("sail_avg_rpm_pwr", "sailAvgRpmPwr");
		this.hashFields.put("noon_rpt_lat", "noonRptLat");
		this.hashFields.put("hld_cln_flg", "hldClnFlg");
		this.hashFields.put("noon_rpt_rmk", "noonRptRmk");
		this.hashFields.put("sail_avg_spd", "sailAvgSpd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("wnd_frc", "wndFrc");
		this.hashFields.put("sea_frc", "seaFrc");
		this.hashFields.put("vsl_rpt_tj_tp_cd", "vslRptTjTpCd");
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
	 * @return noonRptDt
	 */
	public String getNoonRptDt() {
		return this.noonRptDt;
	}
	
	/**
	 * Column Info
	 * @return mnLowSulpDoilCsmQty
	 */
	public String getMnLowSulpDoilCsmQty() {
		return this.mnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
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
	 * @return sailHrmnt
	 */
	public String getSailHrmnt() {
		return this.sailHrmnt;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return nvgtMlDist
	 */
	public String getNvgtMlDist() {
		return this.nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @return hldTempChkFlg
	 */
	public String getHldTempChkFlg() {
		return this.hldTempChkFlg;
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
	 * @return dgSailFlg
	 */
	public String getDgSailFlg() {
		return this.dgSailFlg;
	}
	
	/**
	 * Column Info
	 * @return visRngNo
	 */
	public String getVisRngNo() {
		return this.visRngNo;
	}
	
	/**
	 * Column Info
	 * @return mnDoilCsmQty
	 */
	public String getMnDoilCsmQty() {
		return this.mnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return lodIndQty
	 */
	public String getLodIndQty() {
		return this.lodIndQty;
	}
	
	/**
	 * Column Info
	 * @return noonRptLon
	 */
	public String getNoonRptLon() {
		return this.noonRptLon;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return rmnDist
	 */
	public String getRmnDist() {
		return this.rmnDist;
	}
	
	/**
	 * Column Info
	 * @return engMlDist
	 */
	public String getEngMlDist() {
		return this.engMlDist;
	}
	
	/**
	 * Column Info
	 * @return hldGasChkFlg
	 */
	public String getHldGasChkFlg() {
		return this.hldGasChkFlg;
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
	 * @return nxtPortEtaDt
	 */
	public String getNxtPortEtaDt() {
		return this.nxtPortEtaDt;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return rmnAvgSpd
	 */
	public String getRmnAvgSpd() {
		return this.rmnAvgSpd;
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
	 * @return blstXchFlg
	 */
	public String getBlstXchFlg() {
		return this.blstXchFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiIfRmk
	 */
	public String getEaiIfRmk() {
		return this.eaiIfRmk;
	}
	
	/**
	 * Column Info
	 * @return gnrLowSulpFoilCsmQty
	 */
	public String getGnrLowSulpFoilCsmQty() {
		return this.gnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return dgSailRmk
	 */
	public String getDgSailRmk() {
		return this.dgSailRmk;
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
	 * @return mnLowSulpFoilCsmQty
	 */
	public String getMnLowSulpFoilCsmQty() {
		return this.mnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return voyDirCd
	 */
	public String getVoyDirCd() {
		return this.voyDirCd;
	}
	
	/**
	 * Column Info
	 * @return gnrFoilCsmQty
	 */
	public String getGnrFoilCsmQty() {
		return this.gnrFoilCsmQty;
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
	 * @return slpRt
	 */
	public String getSlpRt() {
		return this.slpRt;
	}
	
	/**
	 * Column Info
	 * @return bilgeChkFlg
	 */
	public String getBilgeChkFlg() {
		return this.bilgeChkFlg;
	}
	
	/**
	 * Column Info
	 * @return crsNo
	 */
	public String getCrsNo() {
		return this.crsNo;
	}
	
	/**
	 * Column Info
	 * @return blrFoilCsmQty
	 */
	public String getBlrFoilCsmQty() {
		return this.blrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return blrLowSulpFoilCsmQty
	 */
	public String getBlrLowSulpFoilCsmQty() {
		return this.blrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return pscPrprFlg
	 */
	public String getPscPrprFlg() {
		return this.pscPrprFlg;
	}
	
	/**
	 * Column Info
	 * @return mnPwr
	 */
	public String getMnPwr() {
		return this.mnPwr;
	}
	
	/**
	 * Column Info
	 * @return mnFoilCsmQty
	 */
	public String getMnFoilCsmQty() {
		return this.mnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @return sailAvgRpmPwr
	 */
	public String getSailAvgRpmPwr() {
		return this.sailAvgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return noonRptLat
	 */
	public String getNoonRptLat() {
		return this.noonRptLat;
	}
	
	/**
	 * Column Info
	 * @return hldClnFlg
	 */
	public String getHldClnFlg() {
		return this.hldClnFlg;
	}
	
	/**
	 * Column Info
	 * @return noonRptRmk
	 */
	public String getNoonRptRmk() {
		return this.noonRptRmk;
	}
	
	/**
	 * Column Info
	 * @return sailAvgSpd
	 */
	public String getSailAvgSpd() {
		return this.sailAvgSpd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return wndFrc
	 */
	public String getWndFrc() {
		return this.wndFrc;
	}
	
	/**
	 * Column Info
	 * @return seaFrc
	 */
	public String getSeaFrc() {
		return this.seaFrc;
	}
	
	/**
	 * Column Info
	 * @return vslRptTjTpCd
	 */
	public String getVslRptTjTpCd() {
		return this.vslRptTjTpCd;
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
	 * @param noonRptDt
	 */
	public void setNoonRptDt(String noonRptDt) {
		this.noonRptDt = noonRptDt;
	}
	
	/**
	 * Column Info
	 * @param mnLowSulpDoilCsmQty
	 */
	public void setMnLowSulpDoilCsmQty(String mnLowSulpDoilCsmQty) {
		this.mnLowSulpDoilCsmQty = mnLowSulpDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
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
	 * @param sailHrmnt
	 */
	public void setSailHrmnt(String sailHrmnt) {
		this.sailHrmnt = sailHrmnt;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param nvgtMlDist
	 */
	public void setNvgtMlDist(String nvgtMlDist) {
		this.nvgtMlDist = nvgtMlDist;
	}
	
	/**
	 * Column Info
	 * @param hldTempChkFlg
	 */
	public void setHldTempChkFlg(String hldTempChkFlg) {
		this.hldTempChkFlg = hldTempChkFlg;
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
	 * @param dgSailFlg
	 */
	public void setDgSailFlg(String dgSailFlg) {
		this.dgSailFlg = dgSailFlg;
	}
	
	/**
	 * Column Info
	 * @param visRngNo
	 */
	public void setVisRngNo(String visRngNo) {
		this.visRngNo = visRngNo;
	}
	
	/**
	 * Column Info
	 * @param mnDoilCsmQty
	 */
	public void setMnDoilCsmQty(String mnDoilCsmQty) {
		this.mnDoilCsmQty = mnDoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param lodIndQty
	 */
	public void setLodIndQty(String lodIndQty) {
		this.lodIndQty = lodIndQty;
	}
	
	/**
	 * Column Info
	 * @param noonRptLon
	 */
	public void setNoonRptLon(String noonRptLon) {
		this.noonRptLon = noonRptLon;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param rmnDist
	 */
	public void setRmnDist(String rmnDist) {
		this.rmnDist = rmnDist;
	}
	
	/**
	 * Column Info
	 * @param engMlDist
	 */
	public void setEngMlDist(String engMlDist) {
		this.engMlDist = engMlDist;
	}
	
	/**
	 * Column Info
	 * @param hldGasChkFlg
	 */
	public void setHldGasChkFlg(String hldGasChkFlg) {
		this.hldGasChkFlg = hldGasChkFlg;
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
	 * @param nxtPortEtaDt
	 */
	public void setNxtPortEtaDt(String nxtPortEtaDt) {
		this.nxtPortEtaDt = nxtPortEtaDt;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param rmnAvgSpd
	 */
	public void setRmnAvgSpd(String rmnAvgSpd) {
		this.rmnAvgSpd = rmnAvgSpd;
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
	 * @param blstXchFlg
	 */
	public void setBlstXchFlg(String blstXchFlg) {
		this.blstXchFlg = blstXchFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiIfRmk
	 */
	public void setEaiIfRmk(String eaiIfRmk) {
		this.eaiIfRmk = eaiIfRmk;
	}
	
	/**
	 * Column Info
	 * @param gnrLowSulpFoilCsmQty
	 */
	public void setGnrLowSulpFoilCsmQty(String gnrLowSulpFoilCsmQty) {
		this.gnrLowSulpFoilCsmQty = gnrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param dgSailRmk
	 */
	public void setDgSailRmk(String dgSailRmk) {
		this.dgSailRmk = dgSailRmk;
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
	 * @param mnLowSulpFoilCsmQty
	 */
	public void setMnLowSulpFoilCsmQty(String mnLowSulpFoilCsmQty) {
		this.mnLowSulpFoilCsmQty = mnLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param voyDirCd
	 */
	public void setVoyDirCd(String voyDirCd) {
		this.voyDirCd = voyDirCd;
	}
	
	/**
	 * Column Info
	 * @param gnrFoilCsmQty
	 */
	public void setGnrFoilCsmQty(String gnrFoilCsmQty) {
		this.gnrFoilCsmQty = gnrFoilCsmQty;
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
	 * @param slpRt
	 */
	public void setSlpRt(String slpRt) {
		this.slpRt = slpRt;
	}
	
	/**
	 * Column Info
	 * @param bilgeChkFlg
	 */
	public void setBilgeChkFlg(String bilgeChkFlg) {
		this.bilgeChkFlg = bilgeChkFlg;
	}
	
	/**
	 * Column Info
	 * @param crsNo
	 */
	public void setCrsNo(String crsNo) {
		this.crsNo = crsNo;
	}
	
	/**
	 * Column Info
	 * @param blrFoilCsmQty
	 */
	public void setBlrFoilCsmQty(String blrFoilCsmQty) {
		this.blrFoilCsmQty = blrFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param blrLowSulpFoilCsmQty
	 */
	public void setBlrLowSulpFoilCsmQty(String blrLowSulpFoilCsmQty) {
		this.blrLowSulpFoilCsmQty = blrLowSulpFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param pscPrprFlg
	 */
	public void setPscPrprFlg(String pscPrprFlg) {
		this.pscPrprFlg = pscPrprFlg;
	}
	
	/**
	 * Column Info
	 * @param mnPwr
	 */
	public void setMnPwr(String mnPwr) {
		this.mnPwr = mnPwr;
	}
	
	/**
	 * Column Info
	 * @param mnFoilCsmQty
	 */
	public void setMnFoilCsmQty(String mnFoilCsmQty) {
		this.mnFoilCsmQty = mnFoilCsmQty;
	}
	
	/**
	 * Column Info
	 * @param sailAvgRpmPwr
	 */
	public void setSailAvgRpmPwr(String sailAvgRpmPwr) {
		this.sailAvgRpmPwr = sailAvgRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param noonRptLat
	 */
	public void setNoonRptLat(String noonRptLat) {
		this.noonRptLat = noonRptLat;
	}
	
	/**
	 * Column Info
	 * @param hldClnFlg
	 */
	public void setHldClnFlg(String hldClnFlg) {
		this.hldClnFlg = hldClnFlg;
	}
	
	/**
	 * Column Info
	 * @param noonRptRmk
	 */
	public void setNoonRptRmk(String noonRptRmk) {
		this.noonRptRmk = noonRptRmk;
	}
	
	/**
	 * Column Info
	 * @param sailAvgSpd
	 */
	public void setSailAvgSpd(String sailAvgSpd) {
		this.sailAvgSpd = sailAvgSpd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param wndFrc
	 */
	public void setWndFrc(String wndFrc) {
		this.wndFrc = wndFrc;
	}
	
	/**
	 * Column Info
	 * @param seaFrc
	 */
	public void setSeaFrc(String seaFrc) {
		this.seaFrc = seaFrc;
	}
	
	/**
	 * Column Info
	 * @param vslRptTjTpCd
	 */
	public void setVslRptTjTpCd(String vslRptTjTpCd) {
		this.vslRptTjTpCd = vslRptTjTpCd;
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
		setNoonRptDt(JSPUtil.getParameter(request, prefix + "noon_rpt_dt", ""));
		setMnLowSulpDoilCsmQty(JSPUtil.getParameter(request, prefix + "mn_low_sulp_doil_csm_qty", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSailHrmnt(JSPUtil.getParameter(request, prefix + "sail_hrmnt", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setNvgtMlDist(JSPUtil.getParameter(request, prefix + "nvgt_ml_dist", ""));
		setHldTempChkFlg(JSPUtil.getParameter(request, prefix + "hld_temp_chk_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDgSailFlg(JSPUtil.getParameter(request, prefix + "dg_sail_flg", ""));
		setVisRngNo(JSPUtil.getParameter(request, prefix + "vis_rng_no", ""));
		setMnDoilCsmQty(JSPUtil.getParameter(request, prefix + "mn_doil_csm_qty", ""));
		setLodIndQty(JSPUtil.getParameter(request, prefix + "lod_ind_qty", ""));
		setNoonRptLon(JSPUtil.getParameter(request, prefix + "noon_rpt_lon", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setRmnDist(JSPUtil.getParameter(request, prefix + "rmn_dist", ""));
		setEngMlDist(JSPUtil.getParameter(request, prefix + "eng_ml_dist", ""));
		setHldGasChkFlg(JSPUtil.getParameter(request, prefix + "hld_gas_chk_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setNxtPortEtaDt(JSPUtil.getParameter(request, prefix + "nxt_port_eta_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setRmnAvgSpd(JSPUtil.getParameter(request, prefix + "rmn_avg_spd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBlstXchFlg(JSPUtil.getParameter(request, prefix + "blst_xch_flg", ""));
		setEaiIfRmk(JSPUtil.getParameter(request, prefix + "eai_if_rmk", ""));
		setGnrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "gnr_low_sulp_foil_csm_qty", ""));
		setDgSailRmk(JSPUtil.getParameter(request, prefix + "dg_sail_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "mn_low_sulp_foil_csm_qty", ""));
		setVoyDirCd(JSPUtil.getParameter(request, prefix + "voy_dir_cd", ""));
		setGnrFoilCsmQty(JSPUtil.getParameter(request, prefix + "gnr_foil_csm_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSlpRt(JSPUtil.getParameter(request, prefix + "slp_rt", ""));
		setBilgeChkFlg(JSPUtil.getParameter(request, prefix + "bilge_chk_flg", ""));
		setCrsNo(JSPUtil.getParameter(request, prefix + "crs_no", ""));
		setBlrFoilCsmQty(JSPUtil.getParameter(request, prefix + "blr_foil_csm_qty", ""));
		setBlrLowSulpFoilCsmQty(JSPUtil.getParameter(request, prefix + "blr_low_sulp_foil_csm_qty", ""));
		setPscPrprFlg(JSPUtil.getParameter(request, prefix + "psc_prpr_flg", ""));
		setMnPwr(JSPUtil.getParameter(request, prefix + "mn_pwr", ""));
		setMnFoilCsmQty(JSPUtil.getParameter(request, prefix + "mn_foil_csm_qty", ""));
		setSailAvgRpmPwr(JSPUtil.getParameter(request, prefix + "sail_avg_rpm_pwr", ""));
		setNoonRptLat(JSPUtil.getParameter(request, prefix + "noon_rpt_lat", ""));
		setHldClnFlg(JSPUtil.getParameter(request, prefix + "hld_cln_flg", ""));
		setNoonRptRmk(JSPUtil.getParameter(request, prefix + "noon_rpt_rmk", ""));
		setSailAvgSpd(JSPUtil.getParameter(request, prefix + "sail_avg_spd", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setWndFrc(JSPUtil.getParameter(request, prefix + "wnd_frc", ""));
		setSeaFrc(JSPUtil.getParameter(request, prefix + "sea_frc", ""));
		setVslRptTjTpCd(JSPUtil.getParameter(request, prefix + "vsl_rpt_tj_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmNoonRptLogVO[]
	 */
	public FcmNoonRptLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmNoonRptLogVO[]
	 */
	public FcmNoonRptLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmNoonRptLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] noonRptDt = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_dt", length));
			String[] mnLowSulpDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "mn_low_sulp_doil_csm_qty", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sailHrmnt = (JSPUtil.getParameter(request, prefix	+ "sail_hrmnt", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] nvgtMlDist = (JSPUtil.getParameter(request, prefix	+ "nvgt_ml_dist", length));
			String[] hldTempChkFlg = (JSPUtil.getParameter(request, prefix	+ "hld_temp_chk_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dgSailFlg = (JSPUtil.getParameter(request, prefix	+ "dg_sail_flg", length));
			String[] visRngNo = (JSPUtil.getParameter(request, prefix	+ "vis_rng_no", length));
			String[] mnDoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "mn_doil_csm_qty", length));
			String[] lodIndQty = (JSPUtil.getParameter(request, prefix	+ "lod_ind_qty", length));
			String[] noonRptLon = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_lon", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] rmnDist = (JSPUtil.getParameter(request, prefix	+ "rmn_dist", length));
			String[] engMlDist = (JSPUtil.getParameter(request, prefix	+ "eng_ml_dist", length));
			String[] hldGasChkFlg = (JSPUtil.getParameter(request, prefix	+ "hld_gas_chk_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] nxtPortEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_port_eta_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] rmnAvgSpd = (JSPUtil.getParameter(request, prefix	+ "rmn_avg_spd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] blstXchFlg = (JSPUtil.getParameter(request, prefix	+ "blst_xch_flg", length));
			String[] eaiIfRmk = (JSPUtil.getParameter(request, prefix	+ "eai_if_rmk", length));
			String[] gnrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "gnr_low_sulp_foil_csm_qty", length));
			String[] dgSailRmk = (JSPUtil.getParameter(request, prefix	+ "dg_sail_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "mn_low_sulp_foil_csm_qty", length));
			String[] voyDirCd = (JSPUtil.getParameter(request, prefix	+ "voy_dir_cd", length));
			String[] gnrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "gnr_foil_csm_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slpRt = (JSPUtil.getParameter(request, prefix	+ "slp_rt", length));
			String[] bilgeChkFlg = (JSPUtil.getParameter(request, prefix	+ "bilge_chk_flg", length));
			String[] crsNo = (JSPUtil.getParameter(request, prefix	+ "crs_no", length));
			String[] blrFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "blr_foil_csm_qty", length));
			String[] blrLowSulpFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "blr_low_sulp_foil_csm_qty", length));
			String[] pscPrprFlg = (JSPUtil.getParameter(request, prefix	+ "psc_prpr_flg", length));
			String[] mnPwr = (JSPUtil.getParameter(request, prefix	+ "mn_pwr", length));
			String[] mnFoilCsmQty = (JSPUtil.getParameter(request, prefix	+ "mn_foil_csm_qty", length));
			String[] sailAvgRpmPwr = (JSPUtil.getParameter(request, prefix	+ "sail_avg_rpm_pwr", length));
			String[] noonRptLat = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_lat", length));
			String[] hldClnFlg = (JSPUtil.getParameter(request, prefix	+ "hld_cln_flg", length));
			String[] noonRptRmk = (JSPUtil.getParameter(request, prefix	+ "noon_rpt_rmk", length));
			String[] sailAvgSpd = (JSPUtil.getParameter(request, prefix	+ "sail_avg_spd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] wndFrc = (JSPUtil.getParameter(request, prefix	+ "wnd_frc", length));
			String[] seaFrc = (JSPUtil.getParameter(request, prefix	+ "sea_frc", length));
			String[] vslRptTjTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rpt_tj_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmNoonRptLogVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (noonRptDt[i] != null)
					model.setNoonRptDt(noonRptDt[i]);
				if (mnLowSulpDoilCsmQty[i] != null)
					model.setMnLowSulpDoilCsmQty(mnLowSulpDoilCsmQty[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sailHrmnt[i] != null)
					model.setSailHrmnt(sailHrmnt[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (nvgtMlDist[i] != null)
					model.setNvgtMlDist(nvgtMlDist[i]);
				if (hldTempChkFlg[i] != null)
					model.setHldTempChkFlg(hldTempChkFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dgSailFlg[i] != null)
					model.setDgSailFlg(dgSailFlg[i]);
				if (visRngNo[i] != null)
					model.setVisRngNo(visRngNo[i]);
				if (mnDoilCsmQty[i] != null)
					model.setMnDoilCsmQty(mnDoilCsmQty[i]);
				if (lodIndQty[i] != null)
					model.setLodIndQty(lodIndQty[i]);
				if (noonRptLon[i] != null)
					model.setNoonRptLon(noonRptLon[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (rmnDist[i] != null)
					model.setRmnDist(rmnDist[i]);
				if (engMlDist[i] != null)
					model.setEngMlDist(engMlDist[i]);
				if (hldGasChkFlg[i] != null)
					model.setHldGasChkFlg(hldGasChkFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (nxtPortEtaDt[i] != null)
					model.setNxtPortEtaDt(nxtPortEtaDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (rmnAvgSpd[i] != null)
					model.setRmnAvgSpd(rmnAvgSpd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (blstXchFlg[i] != null)
					model.setBlstXchFlg(blstXchFlg[i]);
				if (eaiIfRmk[i] != null)
					model.setEaiIfRmk(eaiIfRmk[i]);
				if (gnrLowSulpFoilCsmQty[i] != null)
					model.setGnrLowSulpFoilCsmQty(gnrLowSulpFoilCsmQty[i]);
				if (dgSailRmk[i] != null)
					model.setDgSailRmk(dgSailRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnLowSulpFoilCsmQty[i] != null)
					model.setMnLowSulpFoilCsmQty(mnLowSulpFoilCsmQty[i]);
				if (voyDirCd[i] != null)
					model.setVoyDirCd(voyDirCd[i]);
				if (gnrFoilCsmQty[i] != null)
					model.setGnrFoilCsmQty(gnrFoilCsmQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slpRt[i] != null)
					model.setSlpRt(slpRt[i]);
				if (bilgeChkFlg[i] != null)
					model.setBilgeChkFlg(bilgeChkFlg[i]);
				if (crsNo[i] != null)
					model.setCrsNo(crsNo[i]);
				if (blrFoilCsmQty[i] != null)
					model.setBlrFoilCsmQty(blrFoilCsmQty[i]);
				if (blrLowSulpFoilCsmQty[i] != null)
					model.setBlrLowSulpFoilCsmQty(blrLowSulpFoilCsmQty[i]);
				if (pscPrprFlg[i] != null)
					model.setPscPrprFlg(pscPrprFlg[i]);
				if (mnPwr[i] != null)
					model.setMnPwr(mnPwr[i]);
				if (mnFoilCsmQty[i] != null)
					model.setMnFoilCsmQty(mnFoilCsmQty[i]);
				if (sailAvgRpmPwr[i] != null)
					model.setSailAvgRpmPwr(sailAvgRpmPwr[i]);
				if (noonRptLat[i] != null)
					model.setNoonRptLat(noonRptLat[i]);
				if (hldClnFlg[i] != null)
					model.setHldClnFlg(hldClnFlg[i]);
				if (noonRptRmk[i] != null)
					model.setNoonRptRmk(noonRptRmk[i]);
				if (sailAvgSpd[i] != null)
					model.setSailAvgSpd(sailAvgSpd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (wndFrc[i] != null)
					model.setWndFrc(wndFrc[i]);
				if (seaFrc[i] != null)
					model.setSeaFrc(seaFrc[i]);
				if (vslRptTjTpCd[i] != null)
					model.setVslRptTjTpCd(vslRptTjTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmNoonRptLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmNoonRptLogVO[]
	 */
	public FcmNoonRptLogVO[] getFcmNoonRptLogVOs(){
		FcmNoonRptLogVO[] vos = (FcmNoonRptLogVO[])models.toArray(new FcmNoonRptLogVO[models.size()]);
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
		this.noonRptDt = this.noonRptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnLowSulpDoilCsmQty = this.mnLowSulpDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailHrmnt = this.sailHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvgtMlDist = this.nvgtMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldTempChkFlg = this.hldTempChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSailFlg = this.dgSailFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.visRngNo = this.visRngNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnDoilCsmQty = this.mnDoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodIndQty = this.lodIndQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptLon = this.noonRptLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnDist = this.rmnDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engMlDist = this.engMlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldGasChkFlg = this.hldGasChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortEtaDt = this.nxtPortEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmnAvgSpd = this.rmnAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blstXchFlg = this.blstXchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfRmk = this.eaiIfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrLowSulpFoilCsmQty = this.gnrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSailRmk = this.dgSailRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnLowSulpFoilCsmQty = this.mnLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDirCd = this.voyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrFoilCsmQty = this.gnrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpRt = this.slpRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilgeChkFlg = this.bilgeChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsNo = this.crsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrFoilCsmQty = this.blrFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrLowSulpFoilCsmQty = this.blrLowSulpFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pscPrprFlg = this.pscPrprFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnPwr = this.mnPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnFoilCsmQty = this.mnFoilCsmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailAvgRpmPwr = this.sailAvgRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptLat = this.noonRptLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldClnFlg = this.hldClnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noonRptRmk = this.noonRptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailAvgSpd = this.sailAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wndFrc = this.wndFrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaFrc = this.seaFrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRptTjTpCd = this.vslRptTjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
