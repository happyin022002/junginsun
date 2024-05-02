/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNoMnlUpldVO.java
*@FileTitle : PkupNoMnlUpldVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.04.30 박미옥 
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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNoMnlUpldVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNoMnlUpldVO> models = new ArrayList<PkupNoMnlUpldVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String railDepDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String railMove = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String pkupUpdUsrId = null;
	/* Column Info */
	private String truckMove = null;
	/* Column Info */
	private String pkupUpdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupCreUsrId = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String railArrDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ataDt = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String routeGuide = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String pkupNtcSndYn = null;
	/* Column Info */
	private String pkupNtcSndKnt = null;
	/* Column Info */
	private String ibdTrspHubCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chkYn = null;
	/* Column Info */
	private String pkupCreDt = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrPrtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNoMnlUpldVO() {}

	public PkupNoMnlUpldVO(String ibflag, String pagerows, String chkYn, String bkgNo, String blNo, String cntrNo, String cntrTpszCd, String eqCtrlOfcCd, String frtCltFlg, String oblRdemFlg, String cstmsClrCd, String podCd, String ibdTrspHubCd, String delCd, String usaCstmsFileCd, String deTermCd, String eqTpszCd, String toNodCd, String routeGuide, String railMove, String truckMove, String ataDt, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String railArrDt, String pkupAvalDt, String lstFreeDt, String pkupNo, String pkupYdCd, String pkupCreDt, String pkupUpdDt, String ofcCd, String pkupCreUsrId, String pkupUpdUsrId, String pkupNtcSndKnt, String pkupNtcSndYn, String railDepDt, String deltFlg, String rtnYdCd, String rowCount,String cntrPrtFlg) {
		this.toNodCd = toNodCd;
		this.vslCd = vslCd;
		this.railDepDt = railDepDt;
		this.deltFlg = deltFlg;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.railMove = railMove;
		this.rowCount = rowCount;
		this.pkupUpdUsrId = pkupUpdUsrId;
		this.truckMove = truckMove;
		this.pkupUpdDt = pkupUpdDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pkupCreUsrId = pkupCreUsrId;
		this.pkupYdCd = pkupYdCd;
		this.ibflag = ibflag;
		this.pkupAvalDt = pkupAvalDt;
		this.frtCltFlg = frtCltFlg;
		this.railArrDt = railArrDt;
		this.cntrTpszCd = cntrTpszCd;
		this.ataDt = ataDt;
		this.lstFreeDt = lstFreeDt;
		this.routeGuide = routeGuide;
		this.cstmsClrCd = cstmsClrCd;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.skdVoyNo = skdVoyNo;
		this.rtnYdCd = rtnYdCd;
		this.pkupNtcSndYn = pkupNtcSndYn;
		this.pkupNtcSndKnt = pkupNtcSndKnt;
		this.ibdTrspHubCd = ibdTrspHubCd;
		this.skdDirCd = skdDirCd;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.eqTpszCd = eqTpszCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.chkYn = chkYn;
		this.pkupCreDt = pkupCreDt;
		this.pkupNo = pkupNo;
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rail_dep_dt", getRailDepDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("rail_move", getRailMove());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("pkup_upd_usr_id", getPkupUpdUsrId());
		this.hashColumns.put("truck_move", getTruckMove());
		this.hashColumns.put("pkup_upd_dt", getPkupUpdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_cre_usr_id", getPkupCreUsrId());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("rail_arr_dt", getRailArrDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ata_dt", getAtaDt());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("route_guide", getRouteGuide());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("pkup_ntc_snd_yn", getPkupNtcSndYn());
		this.hashColumns.put("pkup_ntc_snd_knt", getPkupNtcSndKnt());
		this.hashColumns.put("ibd_trsp_hub_cd", getIbdTrspHubCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chk_yn", getChkYn());
		this.hashColumns.put("pkup_cre_dt", getPkupCreDt());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		return this.hashColumns;
	}
	
	

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rail_dep_dt", "railDepDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("rail_move", "railMove");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("pkup_upd_usr_id", "pkupUpdUsrId");
		this.hashFields.put("truck_move", "truckMove");
		this.hashFields.put("pkup_upd_dt", "pkupUpdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_cre_usr_id", "pkupCreUsrId");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("rail_arr_dt", "railArrDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ata_dt", "ataDt");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("route_guide", "routeGuide");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("pkup_ntc_snd_yn", "pkupNtcSndYn");
		this.hashFields.put("pkup_ntc_snd_knt", "pkupNtcSndKnt");
		this.hashFields.put("ibd_trsp_hub_cd", "ibdTrspHubCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chk_yn", "chkYn");
		this.hashFields.put("pkup_cre_dt", "pkupCreDt");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return railDepDt
	 */
	public String getRailDepDt() {
		return this.railDepDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return railMove
	 */
	public String getRailMove() {
		return this.railMove;
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
	 * @return pkupUpdUsrId
	 */
	public String getPkupUpdUsrId() {
		return this.pkupUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return truckMove
	 */
	public String getTruckMove() {
		return this.truckMove;
	}
	
	/**
	 * Column Info
	 * @return pkupUpdDt
	 */
	public String getPkupUpdDt() {
		return this.pkupUpdDt;
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
	 * @return pkupCreUsrId
	 */
	public String getPkupCreUsrId() {
		return this.pkupCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
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
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
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
	 * @return railArrDt
	 */
	public String getRailArrDt() {
		return this.railArrDt;
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
	 * @return ataDt
	 */
	public String getAtaDt() {
		return this.ataDt;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return routeGuide
	 */
	public String getRouteGuide() {
		return this.routeGuide;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
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
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSndYn
	 */
	public String getPkupNtcSndYn() {
		return this.pkupNtcSndYn;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSndKnt
	 */
	public String getPkupNtcSndKnt() {
		return this.pkupNtcSndKnt;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspHubCd
	 */
	public String getIbdTrspHubCd() {
		return this.ibdTrspHubCd;
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
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return chkYn
	 */
	public String getChkYn() {
		return this.chkYn;
	}
	
	/**
	 * Column Info
	 * @return pkupCreDt
	 */
	public String getPkupCreDt() {
		return this.pkupCreDt;
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
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param railDepDt
	 */
	public void setRailDepDt(String railDepDt) {
		this.railDepDt = railDepDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param railMove
	 */
	public void setRailMove(String railMove) {
		this.railMove = railMove;
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
	 * @param pkupUpdUsrId
	 */
	public void setPkupUpdUsrId(String pkupUpdUsrId) {
		this.pkupUpdUsrId = pkupUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param truckMove
	 */
	public void setTruckMove(String truckMove) {
		this.truckMove = truckMove;
	}
	
	/**
	 * Column Info
	 * @param pkupUpdDt
	 */
	public void setPkupUpdDt(String pkupUpdDt) {
		this.pkupUpdDt = pkupUpdDt;
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
	 * @param pkupCreUsrId
	 */
	public void setPkupCreUsrId(String pkupCreUsrId) {
		this.pkupCreUsrId = pkupCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
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
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
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
	 * @param railArrDt
	 */
	public void setRailArrDt(String railArrDt) {
		this.railArrDt = railArrDt;
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
	 * @param ataDt
	 */
	public void setAtaDt(String ataDt) {
		this.ataDt = ataDt;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param routeGuide
	 */
	public void setRouteGuide(String routeGuide) {
		this.routeGuide = routeGuide;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
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
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSndYn
	 */
	public void setPkupNtcSndYn(String pkupNtcSndYn) {
		this.pkupNtcSndYn = pkupNtcSndYn;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSndKnt
	 */
	public void setPkupNtcSndKnt(String pkupNtcSndKnt) {
		this.pkupNtcSndKnt = pkupNtcSndKnt;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspHubCd
	 */
	public void setIbdTrspHubCd(String ibdTrspHubCd) {
		this.ibdTrspHubCd = ibdTrspHubCd;
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
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param chkYn
	 */
	public void setChkYn(String chkYn) {
		this.chkYn = chkYn;
	}
	
	/**
	 * Column Info
	 * @param pkupCreDt
	 */
	public void setPkupCreDt(String pkupCreDt) {
		this.pkupCreDt = pkupCreDt;
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
	 * @param cntrPrtFlg
	 */
	public void setcntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRailDepDt(JSPUtil.getParameter(request, prefix + "rail_dep_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setRailMove(JSPUtil.getParameter(request, prefix + "rail_move", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setPkupUpdUsrId(JSPUtil.getParameter(request, prefix + "pkup_upd_usr_id", ""));
		setTruckMove(JSPUtil.getParameter(request, prefix + "truck_move", ""));
		setPkupUpdDt(JSPUtil.getParameter(request, prefix + "pkup_upd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkupCreUsrId(JSPUtil.getParameter(request, prefix + "pkup_cre_usr_id", ""));
		setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, prefix + "pkup_aval_dt", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setRailArrDt(JSPUtil.getParameter(request, prefix + "rail_arr_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAtaDt(JSPUtil.getParameter(request, prefix + "ata_dt", ""));
		setLstFreeDt(JSPUtil.getParameter(request, prefix + "lst_free_dt", ""));
		setRouteGuide(JSPUtil.getParameter(request, prefix + "route_guide", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setPkupNtcSndYn(JSPUtil.getParameter(request, prefix + "pkup_ntc_snd_yn", ""));
		setPkupNtcSndKnt(JSPUtil.getParameter(request, prefix + "pkup_ntc_snd_knt", ""));
		setIbdTrspHubCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_hub_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setChkYn(JSPUtil.getParameter(request, prefix + "chk_yn", ""));
		setPkupCreDt(JSPUtil.getParameter(request, prefix + "pkup_cre_dt", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setcntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNoMnlUpldVO[]
	 */
	public PkupNoMnlUpldVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNoMnlUpldVO[]
	 */
	public PkupNoMnlUpldVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNoMnlUpldVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] railDepDt = (JSPUtil.getParameter(request, prefix	+ "rail_dep_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] railMove = (JSPUtil.getParameter(request, prefix	+ "rail_move", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] pkupUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "pkup_upd_usr_id", length));
			String[] truckMove = (JSPUtil.getParameter(request, prefix	+ "truck_move", length));
			String[] pkupUpdDt = (JSPUtil.getParameter(request, prefix	+ "pkup_upd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupCreUsrId = (JSPUtil.getParameter(request, prefix	+ "pkup_cre_usr_id", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] railArrDt = (JSPUtil.getParameter(request, prefix	+ "rail_arr_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ataDt = (JSPUtil.getParameter(request, prefix	+ "ata_dt", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] routeGuide = (JSPUtil.getParameter(request, prefix	+ "route_guide", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] pkupNtcSndYn = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_yn", length));
			String[] pkupNtcSndKnt = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_knt", length));
			String[] ibdTrspHubCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_hub_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chkYn = (JSPUtil.getParameter(request, prefix	+ "chk_yn", length));
			String[] pkupCreDt = (JSPUtil.getParameter(request, prefix	+ "pkup_cre_dt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNoMnlUpldVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (railDepDt[i] != null)
					model.setRailDepDt(railDepDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (railMove[i] != null)
					model.setRailMove(railMove[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (pkupUpdUsrId[i] != null)
					model.setPkupUpdUsrId(pkupUpdUsrId[i]);
				if (truckMove[i] != null)
					model.setTruckMove(truckMove[i]);
				if (pkupUpdDt[i] != null)
					model.setPkupUpdDt(pkupUpdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupCreUsrId[i] != null)
					model.setPkupCreUsrId(pkupCreUsrId[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (railArrDt[i] != null)
					model.setRailArrDt(railArrDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ataDt[i] != null)
					model.setAtaDt(ataDt[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (routeGuide[i] != null)
					model.setRouteGuide(routeGuide[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (pkupNtcSndYn[i] != null)
					model.setPkupNtcSndYn(pkupNtcSndYn[i]);
				if (pkupNtcSndKnt[i] != null)
					model.setPkupNtcSndKnt(pkupNtcSndKnt[i]);
				if (ibdTrspHubCd[i] != null)
					model.setIbdTrspHubCd(ibdTrspHubCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chkYn[i] != null)
					model.setChkYn(chkYn[i]);
				if (pkupCreDt[i] != null)
					model.setPkupCreDt(pkupCreDt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrPrtFlg[i] != null)
					model.setcntrPrtFlg(cntrPrtFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNoMnlUpldVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNoMnlUpldVO[]
	 */
	public PkupNoMnlUpldVO[] getPkupNoMnlUpldVOs(){
		PkupNoMnlUpldVO[] vos = (PkupNoMnlUpldVO[])models.toArray(new PkupNoMnlUpldVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDepDt = this.railDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railMove = this.railMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupUpdUsrId = this.pkupUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truckMove = this.truckMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupUpdDt = this.pkupUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupCreUsrId = this.pkupCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railArrDt = this.railArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataDt = this.ataDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeGuide = this.routeGuide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndYn = this.pkupNtcSndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndKnt = this.pkupNtcSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspHubCd = this.ibdTrspHubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkYn = this.chkYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupCreDt = this.pkupCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
