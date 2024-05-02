/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgRfCgoVO.java
*@FileTitle : BkgRfCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2010.02.26 이병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgRfCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRfCgoVO> models = new ArrayList<BkgRfCgoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String pwrSplCblFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clngTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfDcgoSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ctrlAtmsFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String cntrDrnCd = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String ventRto = null;
	/* Column Info */
	private String humidNo = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cntrVentTpCd = null;
	/* Column Info */
	private String aplyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vltgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cbmPerHrQty = null;
	/* Column Info */
	private String modiAtmsFlg = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String humidCtrlFlg = null;
	/* Column Info */
	private String atfcAtmsFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String eqTpsz = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgRfCgoVO() {}

	public BkgRfCgoVO(String ibflag, String pagerows, String cntrVolQty, String cbmPerHrQty, String bkgNo, String rcSeq, String cntrTpszCd, String cntrNo, String pckTpCd, String pckQty, String netWgt, String grsWgt, String wgtUtCd, String cmdtCd, String cmdtDesc, String fdoTemp, String cdoTemp, String cntrVentTpCd, String ventRto, String humidNo, String diffRmk, String rfDcgoSeq, String pwrSplCblFlg, String vltgNo, String ctrlAtmsFlg, String modiAtmsFlg, String humidCtrlFlg, String atfcAtmsFlg, String cntrDrnCd, String clngTpCd, String rqstDt, String rqstUsrId, String spclCgoAproCd, String creUsrId, String creDt, String updUsrId, String updDt, String porCd, String delCd, String rcvTermCd, String deTermCd, String cntrCgoSeq, String aplyNo, String vslCd, String eqTpsz) {
		this.porCd = porCd;
		this.rcSeq = rcSeq;
		this.rqstUsrId = rqstUsrId;
		this.pwrSplCblFlg = pwrSplCblFlg;
		this.creDt = creDt;
		this.clngTpCd = clngTpCd;
		this.pagerows = pagerows;
		this.rfDcgoSeq = rfDcgoSeq;
		this.ibflag = ibflag;
		this.spclCgoAproCd = spclCgoAproCd;
		this.cmdtCd = cmdtCd;
		this.ctrlAtmsFlg = ctrlAtmsFlg;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.cntrDrnCd = cntrDrnCd;
		this.netWgt = netWgt;
		this.delCd = delCd;
		this.fdoTemp = fdoTemp;
		this.cntrCgoSeq = cntrCgoSeq;
		this.ventRto = ventRto;
		this.humidNo = humidNo;
		this.deTermCd = deTermCd;
		this.cntrVentTpCd = cntrVentTpCd;
		this.aplyNo = aplyNo;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.vltgNo = vltgNo;
		this.diffRmk = diffRmk;
		this.cdoTemp = cdoTemp;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.cbmPerHrQty = cbmPerHrQty;
		this.modiAtmsFlg = modiAtmsFlg;
		this.cntrVolQty = cntrVolQty;
		this.grsWgt = grsWgt;
		this.humidCtrlFlg = humidCtrlFlg;
		this.atfcAtmsFlg = atfcAtmsFlg;
		this.vslCd = vslCd;
		this.eqTpsz = eqTpsz;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clng_tp_cd", getClngTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rf_dcgo_seq", getRfDcgoSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ctrl_atms_flg", getCtrlAtmsFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("cntr_drn_cd", getCntrDrnCd());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("vent_rto", getVentRto());
		this.hashColumns.put("humid_no", getHumidNo());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
		this.hashColumns.put("aply_no", getAplyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vltg_no", getVltgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cbm_per_hr_qty", getCbmPerHrQty());
		this.hashColumns.put("modi_atms_flg", getModiAtmsFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("humid_ctrl_flg", getHumidCtrlFlg());
		this.hashColumns.put("atfc_atms_flg", getAtfcAtmsFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eq_tpsz", getEqTpsz());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clng_tp_cd", "clngTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rf_dcgo_seq", "rfDcgoSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ctrl_atms_flg", "ctrlAtmsFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("cntr_drn_cd", "cntrDrnCd");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("vent_rto", "ventRto");
		this.hashFields.put("humid_no", "humidNo");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
		this.hashFields.put("aply_no", "aplyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vltg_no", "vltgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cbm_per_hr_qty", "cbmPerHrQty");
		this.hashFields.put("modi_atms_flg", "modiAtmsFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("humid_ctrl_flg", "humidCtrlFlg");
		this.hashFields.put("atfc_atms_flg", "atfcAtmsFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eq_tpsz", "eqTpsz");
		return this.hashFields;
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
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return pwrSplCblFlg
	 */
	public String getPwrSplCblFlg() {
		return this.pwrSplCblFlg;
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
	 * @return clngTpCd
	 */
	public String getClngTpCd() {
		return this.clngTpCd;
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
	 * @return rfDcgoSeq
	 */
	public String getRfDcgoSeq() {
		return this.rfDcgoSeq;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
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
	 * @return ctrlAtmsFlg
	 */
	public String getCtrlAtmsFlg() {
		return this.ctrlAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return cntrDrnCd
	 */
	public String getCntrDrnCd() {
		return this.cntrDrnCd;
	}
	
	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
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
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return ventRto
	 */
	public String getVentRto() {
		return this.ventRto;
	}
	
	/**
	 * Column Info
	 * @return humidNo
	 */
	public String getHumidNo() {
		return this.humidNo;
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
	 * @return cntrVentTpCd
	 */
	public String getCntrVentTpCd() {
		return this.cntrVentTpCd;
	}
	
	/**
	 * Column Info
	 * @return aplyNo
	 */
	public String getAplyNo() {
		return this.aplyNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return vltgNo
	 */
	public String getVltgNo() {
		return this.vltgNo;
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
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return cbmPerHrQty
	 */
	public String getCbmPerHrQty() {
		return this.cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @return modiAtmsFlg
	 */
	public String getModiAtmsFlg() {
		return this.modiAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return humidCtrlFlg
	 */
	public String getHumidCtrlFlg() {
		return this.humidCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @return atfcAtmsFlg
	 */
	public String getAtfcAtmsFlg() {
		return this.atfcAtmsFlg;
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
	 * @return eqTpsz
	 */
	public String getEqTpsz() {
		return this.eqTpsz;
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
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param pwrSplCblFlg
	 */
	public void setPwrSplCblFlg(String pwrSplCblFlg) {
		this.pwrSplCblFlg = pwrSplCblFlg;
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
	 * @param clngTpCd
	 */
	public void setClngTpCd(String clngTpCd) {
		this.clngTpCd = clngTpCd;
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
	 * @param rfDcgoSeq
	 */
	public void setRfDcgoSeq(String rfDcgoSeq) {
		this.rfDcgoSeq = rfDcgoSeq;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
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
	 * @param ctrlAtmsFlg
	 */
	public void setCtrlAtmsFlg(String ctrlAtmsFlg) {
		this.ctrlAtmsFlg = ctrlAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param cntrDrnCd
	 */
	public void setCntrDrnCd(String cntrDrnCd) {
		this.cntrDrnCd = cntrDrnCd;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
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
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param ventRto
	 */
	public void setVentRto(String ventRto) {
		this.ventRto = ventRto;
	}
	
	/**
	 * Column Info
	 * @param humidNo
	 */
	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
	 * @param cntrVentTpCd
	 */
	public void setCntrVentTpCd(String cntrVentTpCd) {
		this.cntrVentTpCd = cntrVentTpCd;
	}
	
	/**
	 * Column Info
	 * @param aplyNo
	 */
	public void setAplyNo(String aplyNo) {
		this.aplyNo = aplyNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param vltgNo
	 */
	public void setVltgNo(String vltgNo) {
		this.vltgNo = vltgNo;
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
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param cbmPerHrQty
	 */
	public void setCbmPerHrQty(String cbmPerHrQty) {
		this.cbmPerHrQty = cbmPerHrQty;
	}
	
	/**
	 * Column Info
	 * @param modiAtmsFlg
	 */
	public void setModiAtmsFlg(String modiAtmsFlg) {
		this.modiAtmsFlg = modiAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param humidCtrlFlg
	 */
	public void setHumidCtrlFlg(String humidCtrlFlg) {
		this.humidCtrlFlg = humidCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @param atfcAtmsFlg
	 */
	public void setAtfcAtmsFlg(String atfcAtmsFlg) {
		this.atfcAtmsFlg = atfcAtmsFlg;
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
	 * @param eqTpsz
	 */
	public void setEqTpsz(String eqTpsz) {
		this.eqTpsz = eqTpsz;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setPwrSplCblFlg(JSPUtil.getParameter(request, prefix + "pwr_spl_cbl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setClngTpCd(JSPUtil.getParameter(request, prefix + "clng_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfDcgoSeq(JSPUtil.getParameter(request, prefix + "rf_dcgo_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCtrlAtmsFlg(JSPUtil.getParameter(request, prefix + "ctrl_atms_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setCntrDrnCd(JSPUtil.getParameter(request, prefix + "cntr_drn_cd", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setFdoTemp(JSPUtil.getParameter(request, prefix + "fdo_temp", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setVentRto(JSPUtil.getParameter(request, prefix + "vent_rto", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setCntrVentTpCd(JSPUtil.getParameter(request, prefix + "cntr_vent_tp_cd", ""));
		setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVltgNo(JSPUtil.getParameter(request, prefix + "vltg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setCdoTemp(JSPUtil.getParameter(request, prefix + "cdo_temp", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCbmPerHrQty(JSPUtil.getParameter(request, prefix + "cbm_per_hr_qty", ""));
		setModiAtmsFlg(JSPUtil.getParameter(request, prefix + "modi_atms_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setHumidCtrlFlg(JSPUtil.getParameter(request, prefix + "humid_ctrl_flg", ""));
		setAtfcAtmsFlg(JSPUtil.getParameter(request, prefix + "atfc_atms_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEqTpsz(JSPUtil.getParameter(request, prefix + "eq_tpsz", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRfCgoVO[]
	 */
	public BkgRfCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRfCgoVO[]
	 */
	public BkgRfCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRfCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix	+ "pwr_spl_cbl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clngTpCd = (JSPUtil.getParameter(request, prefix	+ "clng_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfDcgoSeq = (JSPUtil.getParameter(request, prefix	+ "rf_dcgo_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ctrlAtmsFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_atms_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] cntrDrnCd = (JSPUtil.getParameter(request, prefix	+ "cntr_drn_cd", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix	+ "fdo_temp", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] ventRto = (JSPUtil.getParameter(request, prefix	+ "vent_rto", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_tp_cd", length));
			String[] aplyNo = (JSPUtil.getParameter(request, prefix	+ "aply_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vltgNo = (JSPUtil.getParameter(request, prefix	+ "vltg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cbmPerHrQty = (JSPUtil.getParameter(request, prefix	+ "cbm_per_hr_qty", length));
			String[] modiAtmsFlg = (JSPUtil.getParameter(request, prefix	+ "modi_atms_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] humidCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "humid_ctrl_flg", length));
			String[] atfcAtmsFlg = (JSPUtil.getParameter(request, prefix	+ "atfc_atms_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] eqTpsz = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgRfCgoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (pwrSplCblFlg[i] != null)
					model.setPwrSplCblFlg(pwrSplCblFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clngTpCd[i] != null)
					model.setClngTpCd(clngTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfDcgoSeq[i] != null)
					model.setRfDcgoSeq(rfDcgoSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ctrlAtmsFlg[i] != null)
					model.setCtrlAtmsFlg(ctrlAtmsFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (cntrDrnCd[i] != null)
					model.setCntrDrnCd(cntrDrnCd[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (ventRto[i] != null)
					model.setVentRto(ventRto[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cntrVentTpCd[i] != null)
					model.setCntrVentTpCd(cntrVentTpCd[i]);
				if (aplyNo[i] != null)
					model.setAplyNo(aplyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vltgNo[i] != null)
					model.setVltgNo(vltgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cbmPerHrQty[i] != null)
					model.setCbmPerHrQty(cbmPerHrQty[i]);
				if (modiAtmsFlg[i] != null)
					model.setModiAtmsFlg(modiAtmsFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (humidCtrlFlg[i] != null)
					model.setHumidCtrlFlg(humidCtrlFlg[i]);
				if (atfcAtmsFlg[i] != null)
					model.setAtfcAtmsFlg(atfcAtmsFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (eqTpsz[i] != null)
					model.setEqTpsz(eqTpsz[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRfCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRfCgoVO[]
	 */
	public BkgRfCgoVO[] getBkgRfCgoVOs(){
		BkgRfCgoVO[] vos = (BkgRfCgoVO[])models.toArray(new BkgRfCgoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwrSplCblFlg = this.pwrSplCblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clngTpCd = this.clngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfDcgoSeq = this.rfDcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAtmsFlg = this.ctrlAtmsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrnCd = this.cntrDrnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ventRto = this.ventRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentTpCd = this.cntrVentTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyNo = this.aplyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vltgNo = this.vltgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbmPerHrQty = this.cbmPerHrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiAtmsFlg = this.modiAtmsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidCtrlFlg = this.humidCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfcAtmsFlg = this.atfcAtmsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpsz = this.eqTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
