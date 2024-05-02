/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CllDetailVO.java
*@FileTitle : CllDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier :
*@LastVersion : 1.0
* 2010.01.15
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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

public class CllDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CllDetailVO> models = new ArrayList<CllDetailVO>();

	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String tsCgoCd = null;
	/* Column Info */
	private String cntrVentRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ovrPortLen = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String grsWgtUtCd = null;
	/* Column Info */
	private String cntrMeasUtCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String teuCntrQty = null;
	/* Column Info */
	private String feuCntrQty = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String bkgCount = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String wgtTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvStsCd = null;
	/* Column Info */
	private String blRmk = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String grsCntrWgt = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String bkgNo2 = null;
	/* Column Info */
	private String ovrCntrWgt = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ovrSdLen = null;
	/* Column Info */
	private String cntrCount = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String ovrWgtUtCd = null;
	/* Column Info */
	private String cntrLodgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CllDetailVO() {}

	public CllDetailVO(String ibflag, String pagerows, String vvdCd, String portCd, String cntrLodgNo, String etaDt, String etdDt, String bkgNo, String bkgNo2, String cntrNo, String tsCgoCd, String cntrTpszCd, String porCd, String polCd, String podCd, String delCd, String socFlg, String fullMtyCd, String rcvDeTermCd, String cntrSealNo, String cntrWgt, String wgtTpCd, String cfmFlg, String teuCntrQty, String feuCntrQty, String rcFlg, String dcgoFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String blRmk, String ediRcvStsCd, String updUsrId, String inVvdCd, String inPolCd, String pckQty, String pckTpCd, String grsCntrWgt, String grsWgtUtCd, String measQty, String cntrMeasUtCd, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrPortLen, String ovrSdLen, String ovrWgtUtCd, String ovrCntrWgt, String fdoTemp, String cdoTemp, String cntrVentRto, String cntrCount, String bkgCount, String vgmWgt, String vgmWgtUtCd) {
		this.etaDt = etaDt;
		this.tsCgoCd = tsCgoCd;
		this.cntrVentRto = cntrVentRto;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ovrHgt = ovrHgt;
		this.vvdCd = vvdCd;
		this.ovrPortLen = ovrPortLen;
		this.cntrTpszCd = cntrTpszCd;
		this.grsWgtUtCd = grsWgtUtCd;
		this.cntrMeasUtCd = cntrMeasUtCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.updUsrId = updUsrId;
		this.teuCntrQty = teuCntrQty;
		this.feuCntrQty = feuCntrQty;
		this.cntrWgt = cntrWgt;
		this.bkgCount = bkgCount;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.wgtTpCd = wgtTpCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.inVvdCd = inVvdCd;
		this.fullMtyCd = fullMtyCd;
		this.rcFlg = rcFlg;
		this.ovrFwrdLen = ovrFwrdLen;
		this.porCd = porCd;
		this.rdCgoFlg = rdCgoFlg;
		this.ibflag = ibflag;
		this.ediRcvStsCd = ediRcvStsCd;
		this.blRmk = blRmk;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.grsCntrWgt = grsCntrWgt;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.portCd = portCd;
		this.bkgNo2 = bkgNo2;
		this.ovrCntrWgt = ovrCntrWgt;
		this.pckTpCd = pckTpCd;
		this.ovrSdLen = ovrSdLen;
		this.cntrCount = cntrCount;
		this.fdoTemp = fdoTemp;
		this.etdDt = etdDt;
		this.cfmFlg = cfmFlg;
		this.socFlg = socFlg;
		this.cdoTemp = cdoTemp;
		this.ovrWgtUtCd = ovrWgtUtCd;
		this.cntrLodgNo = cntrLodgNo;
		this.cntrNo = cntrNo;
		this.ovrBkwdLen = ovrBkwdLen;
		this.inPolCd = inPolCd;
		this.cntrSealNo = cntrSealNo;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("ts_cgo_cd", getTsCgoCd());
		this.hashColumns.put("cntr_vent_rto", getCntrVentRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ovr_port_len", getOvrPortLen());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("grs_wgt_ut_cd", getGrsWgtUtCd());
		this.hashColumns.put("cntr_meas_ut_cd", getCntrMeasUtCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("teu_cntr_qty", getTeuCntrQty());
		this.hashColumns.put("feu_cntr_qty", getFeuCntrQty());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("bkg_count", getBkgCount());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("wgt_tp_cd", getWgtTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_sts_cd", getEdiRcvStsCd());
		this.hashColumns.put("bl_rmk", getBlRmk());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("grs_cntr_wgt", getGrsCntrWgt());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("bkg_no2", getBkgNo2());
		this.hashColumns.put("ovr_cntr_wgt", getOvrCntrWgt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ovr_sd_len", getOvrSdLen());
		this.hashColumns.put("cntr_count", getCntrCount());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("ovr_wgt_ut_cd", getOvrWgtUtCd());
		this.hashColumns.put("cntr_lodg_no", getCntrLodgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("ts_cgo_cd", "tsCgoCd");
		this.hashFields.put("cntr_vent_rto", "cntrVentRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ovr_port_len", "ovrPortLen");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("grs_wgt_ut_cd", "grsWgtUtCd");
		this.hashFields.put("cntr_meas_ut_cd", "cntrMeasUtCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("teu_cntr_qty", "teuCntrQty");
		this.hashFields.put("feu_cntr_qty", "feuCntrQty");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("bkg_count", "bkgCount");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("wgt_tp_cd", "wgtTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_sts_cd", "ediRcvStsCd");
		this.hashFields.put("bl_rmk", "blRmk");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("grs_cntr_wgt", "grsCntrWgt");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("ovr_cntr_wgt", "ovrCntrWgt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ovr_sd_len", "ovrSdLen");
		this.hashFields.put("cntr_count", "cntrCount");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("ovr_wgt_ut_cd", "ovrWgtUtCd");
		this.hashFields.put("cntr_lodg_no", "cntrLodgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return tsCgoCd
	 */
	public String getTsCgoCd() {
		return this.tsCgoCd;
	}

	/**
	 * Column Info
	 * @return cntrVentRto
	 */
	public String getCntrVentRto() {
		return this.cntrVentRto;
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
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return ovrPortLen
	 */
	public String getOvrPortLen() {
		return this.ovrPortLen;
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
	 * @return grsWgtUtCd
	 */
	public String getGrsWgtUtCd() {
		return this.grsWgtUtCd;
	}

	/**
	 * Column Info
	 * @return cntrMeasUtCd
	 */
	public String getCntrMeasUtCd() {
		return this.cntrMeasUtCd;
	}

	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return teuCntrQty
	 */
	public String getTeuCntrQty() {
		return this.teuCntrQty;
	}

	/**
	 * Column Info
	 * @return feuCntrQty
	 */
	public String getFeuCntrQty() {
		return this.feuCntrQty;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return bkgCount
	 */
	public String getBkgCount() {
		return this.bkgCount;
	}

	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return wgtTpCd
	 */
	public String getWgtTpCd() {
		return this.wgtTpCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}

	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}

	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return ediRcvStsCd
	 */
	public String getEdiRcvStsCd() {
		return this.ediRcvStsCd;
	}

	/**
	 * Column Info
	 * @return blRmk
	 */
	public String getBlRmk() {
		return this.blRmk;
	}

	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}

	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}

	/**
	 * Column Info
	 * @return grsCntrWgt
	 */
	public String getGrsCntrWgt() {
		return this.grsCntrWgt;
	}

	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return bkgNo2
	 */
	public String getBkgNo2() {
		return this.bkgNo2;
	}

	/**
	 * Column Info
	 * @return ovrCntrWgt
	 */
	public String getOvrCntrWgt() {
		return this.ovrCntrWgt;
	}

	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return ovrSdLen
	 */
	public String getOvrSdLen() {
		return this.ovrSdLen;
	}

	/**
	 * Column Info
	 * @return cntrCount
	 */
	public String getCntrCount() {
		return this.cntrCount;
	}

	/**
	 * Column Info
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}

	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}

	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}

	/**
	 * Column Info
	 * @return ovrWgtUtCd
	 */
	public String getOvrWgtUtCd() {
		return this.ovrWgtUtCd;
	}

	/**
	 * Column Info
	 * @return cntrLodgNo
	 */
	public String getCntrLodgNo() {
		return this.cntrLodgNo;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}


	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param tsCgoCd
	 */
	public void setTsCgoCd(String tsCgoCd) {
		this.tsCgoCd = tsCgoCd;
	}

	/**
	 * Column Info
	 * @param cntrVentRto
	 */
	public void setCntrVentRto(String cntrVentRto) {
		this.cntrVentRto = cntrVentRto;
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
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param ovrPortLen
	 */
	public void setOvrPortLen(String ovrPortLen) {
		this.ovrPortLen = ovrPortLen;
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
	 * @param grsWgtUtCd
	 */
	public void setGrsWgtUtCd(String grsWgtUtCd) {
		this.grsWgtUtCd = grsWgtUtCd;
	}

	/**
	 * Column Info
	 * @param cntrMeasUtCd
	 */
	public void setCntrMeasUtCd(String cntrMeasUtCd) {
		this.cntrMeasUtCd = cntrMeasUtCd;
	}

	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param teuCntrQty
	 */
	public void setTeuCntrQty(String teuCntrQty) {
		this.teuCntrQty = teuCntrQty;
	}

	/**
	 * Column Info
	 * @param feuCntrQty
	 */
	public void setFeuCntrQty(String feuCntrQty) {
		this.feuCntrQty = feuCntrQty;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param bkgCount
	 */
	public void setBkgCount(String bkgCount) {
		this.bkgCount = bkgCount;
	}

	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param wgtTpCd
	 */
	public void setWgtTpCd(String wgtTpCd) {
		this.wgtTpCd = wgtTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}

	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}

	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
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
	 * @param ediRcvStsCd
	 */
	public void setEdiRcvStsCd(String ediRcvStsCd) {
		this.ediRcvStsCd = ediRcvStsCd;
	}

	/**
	 * Column Info
	 * @param blRmk
	 */
	public void setBlRmk(String blRmk) {
		this.blRmk = blRmk;
	}

	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}

	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}

	/**
	 * Column Info
	 * @param grsCntrWgt
	 */
	public void setGrsCntrWgt(String grsCntrWgt) {
		this.grsCntrWgt = grsCntrWgt;
	}

	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param bkgNo2
	 */
	public void setBkgNo2(String bkgNo2) {
		this.bkgNo2 = bkgNo2;
	}

	/**
	 * Column Info
	 * @param ovrCntrWgt
	 */
	public void setOvrCntrWgt(String ovrCntrWgt) {
		this.ovrCntrWgt = ovrCntrWgt;
	}

	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param ovrSdLen
	 */
	public void setOvrSdLen(String ovrSdLen) {
		this.ovrSdLen = ovrSdLen;
	}

	/**
	 * Column Info
	 * @param cntrCount
	 */
	public void setCntrCount(String cntrCount) {
		this.cntrCount = cntrCount;
	}

	/**
	 * Column Info
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}

	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}

	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}

	/**
	 * Column Info
	 * @param ovrWgtUtCd
	 */
	public void setOvrWgtUtCd(String ovrWgtUtCd) {
		this.ovrWgtUtCd = ovrWgtUtCd;
	}

	/**
	 * Column Info
	 * @param cntrLodgNo
	 */
	public void setCntrLodgNo(String cntrLodgNo) {
		this.cntrLodgNo = cntrLodgNo;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setTsCgoCd(JSPUtil.getParameter(request, prefix + "ts_cgo_cd", ""));
		setCntrVentRto(JSPUtil.getParameter(request, prefix + "cntr_vent_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setOvrPortLen(JSPUtil.getParameter(request, prefix + "ovr_port_len", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setGrsWgtUtCd(JSPUtil.getParameter(request, prefix + "grs_wgt_ut_cd", ""));
		setCntrMeasUtCd(JSPUtil.getParameter(request, prefix + "cntr_meas_ut_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTeuCntrQty(JSPUtil.getParameter(request, prefix + "teu_cntr_qty", ""));
		setFeuCntrQty(JSPUtil.getParameter(request, prefix + "feu_cntr_qty", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setBkgCount(JSPUtil.getParameter(request, prefix + "bkg_count", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setWgtTpCd(JSPUtil.getParameter(request, prefix + "wgt_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiRcvStsCd(JSPUtil.getParameter(request, prefix + "edi_rcv_sts_cd", ""));
		setBlRmk(JSPUtil.getParameter(request, prefix + "bl_rmk", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setGrsCntrWgt(JSPUtil.getParameter(request, prefix + "grs_cntr_wgt", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setBkgNo2(JSPUtil.getParameter(request, prefix + "bkg_no2", ""));
		setOvrCntrWgt(JSPUtil.getParameter(request, prefix + "ovr_cntr_wgt", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setOvrSdLen(JSPUtil.getParameter(request, prefix + "ovr_sd_len", ""));
		setCntrCount(JSPUtil.getParameter(request, prefix + "cntr_count", ""));
		setFdoTemp(JSPUtil.getParameter(request, prefix + "fdo_temp", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setOvrWgtUtCd(JSPUtil.getParameter(request, prefix + "ovr_wgt_ut_cd", ""));
		setCntrLodgNo(JSPUtil.getParameter(request, prefix + "cntr_lodg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllDetailVO[]
	 */
	public CllDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CllDetailVO[]
	 */
	public CllDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] tsCgoCd = (JSPUtil.getParameter(request, prefix	+ "ts_cgo_cd", length));
			String[] cntrVentRto = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ovrPortLen = (JSPUtil.getParameter(request, prefix	+ "ovr_port_len", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] grsWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_ut_cd", length));
			String[] cntrMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_meas_ut_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] teuCntrQty = (JSPUtil.getParameter(request, prefix	+ "teu_cntr_qty", length));
			String[] feuCntrQty = (JSPUtil.getParameter(request, prefix	+ "feu_cntr_qty", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] wgtTpCd = (JSPUtil.getParameter(request, prefix	+ "wgt_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_sts_cd", length));
			String[] blRmk = (JSPUtil.getParameter(request, prefix	+ "bl_rmk", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] grsCntrWgt = (JSPUtil.getParameter(request, prefix	+ "grs_cntr_wgt", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] bkgNo2 = (JSPUtil.getParameter(request, prefix	+ "bkg_no2", length));
			String[] ovrCntrWgt = (JSPUtil.getParameter(request, prefix	+ "ovr_cntr_wgt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ovrSdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_sd_len", length));
			String[] cntrCount = (JSPUtil.getParameter(request, prefix	+ "cntr_count", length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix	+ "fdo_temp", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] ovrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_ut_cd", length));
			String[] cntrLodgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_lodg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));

			for (int i = 0; i < length; i++) {
				model = new CllDetailVO();
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (tsCgoCd[i] != null)
					model.setTsCgoCd(tsCgoCd[i]);
				if (cntrVentRto[i] != null)
					model.setCntrVentRto(cntrVentRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ovrPortLen[i] != null)
					model.setOvrPortLen(ovrPortLen[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (grsWgtUtCd[i] != null)
					model.setGrsWgtUtCd(grsWgtUtCd[i]);
				if (cntrMeasUtCd[i] != null)
					model.setCntrMeasUtCd(cntrMeasUtCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (teuCntrQty[i] != null)
					model.setTeuCntrQty(teuCntrQty[i]);
				if (feuCntrQty[i] != null)
					model.setFeuCntrQty(feuCntrQty[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (bkgCount[i] != null)
					model.setBkgCount(bkgCount[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (wgtTpCd[i] != null)
					model.setWgtTpCd(wgtTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvStsCd[i] != null)
					model.setEdiRcvStsCd(ediRcvStsCd[i]);
				if (blRmk[i] != null)
					model.setBlRmk(blRmk[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (grsCntrWgt[i] != null)
					model.setGrsCntrWgt(grsCntrWgt[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (bkgNo2[i] != null)
					model.setBkgNo2(bkgNo2[i]);
				if (ovrCntrWgt[i] != null)
					model.setOvrCntrWgt(ovrCntrWgt[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ovrSdLen[i] != null)
					model.setOvrSdLen(ovrSdLen[i]);
				if (cntrCount[i] != null)
					model.setCntrCount(cntrCount[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (ovrWgtUtCd[i] != null)
					model.setOvrWgtUtCd(ovrWgtUtCd[i]);
				if (cntrLodgNo[i] != null)
					model.setCntrLodgNo(cntrLodgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllDetailVO[]
	 */
	public CllDetailVO[] getCllDetailVOs(){
		CllDetailVO[] vos = (CllDetailVO[])models.toArray(new CllDetailVO[models.size()]);
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
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCgoCd = this.tsCgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentRto = this.cntrVentRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrPortLen = this.ovrPortLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtUtCd = this.grsWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeasUtCd = this.cntrMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuCntrQty = this.teuCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuCntrQty = this.feuCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtTpCd = this.wgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvStsCd = this.ediRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRmk = this.blRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCntrWgt = this.grsCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 = this.bkgNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrCntrWgt = this.ovrCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrSdLen = this.ovrSdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCount = this.cntrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtUtCd = this.ovrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodgNo = this.cntrLodgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
