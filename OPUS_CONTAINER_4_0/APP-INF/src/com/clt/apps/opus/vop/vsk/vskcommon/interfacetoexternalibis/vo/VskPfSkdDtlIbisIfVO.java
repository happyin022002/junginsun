/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskPfSkdDtlIbisIfVO.java
*@FileTitle : VskPfSkdDtlIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class VskPfSkdDtlIbisIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPfSkdDtlIbisIfVO> models = new ArrayList<VskPfSkdDtlIbisIfVO>();
	
	/* Column Info */
	private String lonUtCd = null;
	/* Column Info */
	private String seaBufSpd = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String scrnLocLon = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actWrkHrs = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String etdDyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String crnKnt = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String scrnLocLat = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String etdDyNo = null;
	/* Column Info */
	private String etdTmHrmnt = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String latUtCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String locLon = null;
	/* Column Info */
	private String etbDyNo = null;
	/* Column Info */
	private String etbTmHrmnt = null;
	/* Column Info */
	private String locLat = null;
	/* Column Info */
	private String ibisIfSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskPfSkdDtlIbisIfVO() {}

	public VskPfSkdDtlIbisIfVO(String ibflag, String pagerows, String vslSlanCd, String pfSvcTpCd, String portCd, String skdDirCd, String clptSeq, String portRotnSeq, String ydCd, String callYdIndSeq, String turnPortFlg, String turnPortIndCd, String etbDyCd, String etbDyNo, String etbTmHrmnt, String etdDyCd, String etdDyNo, String etdTmHrmnt, String lnkDist, String lnkSpd, String tztmHrs, String seaBufHrs, String seaBufSpd, String mnvrInHrs, String mnvrOutHrs, String ibIpcgoQty, String ibOcnCgoQty, String obIpcgoQty, String obOcnCgoQty, String tmlProdQty, String crnKnt, String actWrkHrs, String portBufHrs, String locLat, String locLon, String latUtCd, String lonUtCd, String scrnLocLat, String scrnLocLon, String creUsrId, String creDt, String updUsrId, String updDt, String ibisIfSeq) {
		this.lonUtCd = lonUtCd;
		this.seaBufSpd = seaBufSpd;
		this.mnvrOutHrs = mnvrOutHrs;
		this.etbDyCd = etbDyCd;
		this.scrnLocLon = scrnLocLon;
		this.lnkSpd = lnkSpd;
		this.skdDirCd = skdDirCd;
		this.seaBufHrs = seaBufHrs;
		this.turnPortFlg = turnPortFlg;
		this.creDt = creDt;
		this.actWrkHrs = actWrkHrs;
		this.tmlProdQty = tmlProdQty;
		this.portBufHrs = portBufHrs;
		this.vslSlanCd = vslSlanCd;
		this.tztmHrs = tztmHrs;
		this.etdDyCd = etdDyCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.clptSeq = clptSeq;
		this.ibflag = ibflag;
		this.pfSvcTpCd = pfSvcTpCd;
		this.crnKnt = crnKnt;
		this.portRotnSeq = portRotnSeq;
		this.ibIpcgoQty = ibIpcgoQty;
		this.portCd = portCd;
		this.scrnLocLat = scrnLocLat;
		this.obIpcgoQty = obIpcgoQty;
		this.callYdIndSeq = callYdIndSeq;
		this.updUsrId = updUsrId;
		this.obOcnCgoQty = obOcnCgoQty;
		this.updDt = updDt;
		this.lnkDist = lnkDist;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.etdDyNo = etdDyNo;
		this.etdTmHrmnt = etdTmHrmnt;
		this.mnvrInHrs = mnvrInHrs;
		this.latUtCd = latUtCd;
		this.creUsrId = creUsrId;
		this.ydCd = ydCd;
		this.locLon = locLon;
		this.etbDyNo = etbDyNo;
		this.etbTmHrmnt = etbTmHrmnt;
		this.locLat = locLat;
		this.ibisIfSeq = ibisIfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lon_ut_cd", getLonUtCd());
		this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("scrn_loc_lon", getScrnLocLon());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("etd_dy_cd", getEtdDyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("crn_knt", getCrnKnt());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("scrn_loc_lat", getScrnLocLat());
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("etd_dy_no", getEtdDyNo());
		this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("lat_ut_cd", getLatUtCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("loc_lon", getLocLon());
		this.hashColumns.put("etb_dy_no", getEtbDyNo());
		this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
		this.hashColumns.put("loc_lat", getLocLat());
		this.hashColumns.put("ibis_if_seq", getIbisIfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lon_ut_cd", "lonUtCd");
		this.hashFields.put("sea_buf_spd", "seaBufSpd");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("scrn_loc_lon", "scrnLocLon");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("etd_dy_cd", "etdDyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("crn_knt", "crnKnt");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("scrn_loc_lat", "scrnLocLat");
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("etd_dy_no", "etdDyNo");
		this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("lat_ut_cd", "latUtCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("loc_lon", "locLon");
		this.hashFields.put("etb_dy_no", "etbDyNo");
		this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
		this.hashFields.put("loc_lat", "locLat");
		this.hashFields.put("ibis_if_seq", "ibisIfSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lonUtCd
	 */
	public String getLonUtCd() {
		return this.lonUtCd;
	}
	
	/**
	 * Column Info
	 * @return seaBufSpd
	 */
	public String getSeaBufSpd() {
		return this.seaBufSpd;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @return etbDyCd
	 */
	public String getEtbDyCd() {
		return this.etbDyCd;
	}
	
	/**
	 * Column Info
	 * @return scrnLocLon
	 */
	public String getScrnLocLon() {
		return this.scrnLocLon;
	}
	
	/**
	 * Column Info
	 * @return lnkSpd
	 */
	public String getLnkSpd() {
		return this.lnkSpd;
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
	 * @return seaBufHrs
	 */
	public String getSeaBufHrs() {
		return this.seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @return turnPortFlg
	 */
	public String getTurnPortFlg() {
		return this.turnPortFlg;
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
	 * @return actWrkHrs
	 */
	public String getActWrkHrs() {
		return this.actWrkHrs;
	}
	
	/**
	 * Column Info
	 * @return tmlProdQty
	 */
	public String getTmlProdQty() {
		return this.tmlProdQty;
	}
	
	/**
	 * Column Info
	 * @return portBufHrs
	 */
	public String getPortBufHrs() {
		return this.portBufHrs;
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
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return etdDyCd
	 */
	public String getEtdDyCd() {
		return this.etdDyCd;
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
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
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
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return crnKnt
	 */
	public String getCrnKnt() {
		return this.crnKnt;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getPortRotnSeq() {
		return this.portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @return ibIpcgoQty
	 */
	public String getIbIpcgoQty() {
		return this.ibIpcgoQty;
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
	 * @return scrnLocLat
	 */
	public String getScrnLocLat() {
		return this.scrnLocLat;
	}
	
	/**
	 * Column Info
	 * @return obIpcgoQty
	 */
	public String getObIpcgoQty() {
		return this.obIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
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
	 * @return obOcnCgoQty
	 */
	public String getObOcnCgoQty() {
		return this.obOcnCgoQty;
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
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return ibOcnCgoQty
	 */
	public String getIbOcnCgoQty() {
		return this.ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @return etdDyNo
	 */
	public String getEtdDyNo() {
		return this.etdDyNo;
	}
	
	/**
	 * Column Info
	 * @return etdTmHrmnt
	 */
	public String getEtdTmHrmnt() {
		return this.etdTmHrmnt;
	}
	
	/**
	 * Column Info
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return latUtCd
	 */
	public String getLatUtCd() {
		return this.latUtCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return locLon
	 */
	public String getLocLon() {
		return this.locLon;
	}
	
	/**
	 * Column Info
	 * @return etbDyNo
	 */
	public String getEtbDyNo() {
		return this.etbDyNo;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getEtbTmHrmnt() {
		return this.etbTmHrmnt;
	}

	/**
	 * Column Info
	 * @return locLat
	 */
	public String getLocLat() {
		return this.locLat;
	}
	
	/**
	 * Column Info
	 * @return ibisIfSeq
	 */
	public String getIbisIfSeq() {
		return this.ibisIfSeq;
	}

	/**
	 * Column Info
	 * @param lonUtCd
	 */
	public void setLonUtCd(String lonUtCd) {
		this.lonUtCd = lonUtCd;
	}
	
	/**
	 * Column Info
	 * @param seaBufSpd
	 */
	public void setSeaBufSpd(String seaBufSpd) {
		this.seaBufSpd = seaBufSpd;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
	}
	
	/**
	 * Column Info
	 * @param etbDyCd
	 */
	public void setEtbDyCd(String etbDyCd) {
		this.etbDyCd = etbDyCd;
	}
	
	/**
	 * Column Info
	 * @param scrnLocLon
	 */
	public void setScrnLocLon(String scrnLocLon) {
		this.scrnLocLon = scrnLocLon;
	}
	
	/**
	 * Column Info
	 * @param lnkSpd
	 */
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
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
	 * @param seaBufHrs
	 */
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @param turnPortFlg
	 */
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
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
	 * @param actWrkHrs
	 */
	public void setActWrkHrs(String actWrkHrs) {
		this.actWrkHrs = actWrkHrs;
	}
	
	/**
	 * Column Info
	 * @param tmlProdQty
	 */
	public void setTmlProdQty(String tmlProdQty) {
		this.tmlProdQty = tmlProdQty;
	}
	
	/**
	 * Column Info
	 * @param portBufHrs
	 */
	public void setPortBufHrs(String portBufHrs) {
		this.portBufHrs = portBufHrs;
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
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param etdDyCd
	 */
	public void setEtdDyCd(String etdDyCd) {
		this.etdDyCd = etdDyCd;
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
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
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
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param crnKnt
	 */
	public void setCrnKnt(String crnKnt) {
		this.crnKnt = crnKnt;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @param ibIpcgoQty
	 */
	public void setIbIpcgoQty(String ibIpcgoQty) {
		this.ibIpcgoQty = ibIpcgoQty;
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
	 * @param scrnLocLat
	 */
	public void setScrnLocLat(String scrnLocLat) {
		this.scrnLocLat = scrnLocLat;
	}
	
	/**
	 * Column Info
	 * @param obIpcgoQty
	 */
	public void setObIpcgoQty(String obIpcgoQty) {
		this.obIpcgoQty = obIpcgoQty;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
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
	 * @param obOcnCgoQty
	 */
	public void setObOcnCgoQty(String obOcnCgoQty) {
		this.obOcnCgoQty = obOcnCgoQty;
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
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param ibOcnCgoQty
	 */
	public void setIbOcnCgoQty(String ibOcnCgoQty) {
		this.ibOcnCgoQty = ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param etdDyNo
	 */
	public void setEtdDyNo(String etdDyNo) {
		this.etdDyNo = etdDyNo;
	}
	
	/**
	 * Column Info
	 * @param etdTmHrmnt
	 */
	public void setEtdTmHrmnt(String etdTmHrmnt) {
		this.etdTmHrmnt = etdTmHrmnt;
	}
	
	/**
	 * Column Info
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param latUtCd
	 */
	public void setLatUtCd(String latUtCd) {
		this.latUtCd = latUtCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param locLon
	 */
	public void setLocLon(String locLon) {
		this.locLon = locLon;
	}
	
	/**
	 * Column Info
	 * @param etbDyNo
	 */
	public void setEtbDyNo(String etbDyNo) {
		this.etbDyNo = etbDyNo;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setEtbTmHrmnt(String etbTmHrmnt) {
		this.etbTmHrmnt = etbTmHrmnt;
	}
	
	/**
	 * Column Info
	 * @param locLat
	 */
	public void setLocLat(String locLat) {
		this.locLat = locLat;
	}
	
	/**
	 * Column Info
	 * @param ibisIfSeq
	 */
	public void setIbisIfSeq(String ibisIfSeq) {
		this.ibisIfSeq = ibisIfSeq;
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
		setLonUtCd(JSPUtil.getParameter(request, prefix + "lon_ut_cd", ""));
		setSeaBufSpd(JSPUtil.getParameter(request, prefix + "sea_buf_spd", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
		setEtbDyCd(JSPUtil.getParameter(request, prefix + "etb_dy_cd", ""));
		setScrnLocLon(JSPUtil.getParameter(request, prefix + "scrn_loc_lon", ""));
		setLnkSpd(JSPUtil.getParameter(request, prefix + "lnk_spd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, prefix + "turn_port_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setActWrkHrs(JSPUtil.getParameter(request, prefix + "act_wrk_hrs", ""));
		setTmlProdQty(JSPUtil.getParameter(request, prefix + "tml_prod_qty", ""));
		setPortBufHrs(JSPUtil.getParameter(request, prefix + "port_buf_hrs", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, prefix + "tztm_hrs", ""));
		setEtdDyCd(JSPUtil.getParameter(request, prefix + "etd_dy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, prefix + "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
		setCrnKnt(JSPUtil.getParameter(request, prefix + "crn_knt", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, prefix + "port_rotn_seq", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, prefix + "ib_ipcgo_qty", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setScrnLocLat(JSPUtil.getParameter(request, prefix + "scrn_loc_lat", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, prefix + "ob_ipcgo_qty", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, prefix + "call_yd_ind_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, prefix + "ob_ocn_cgo_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, prefix + "ib_ocn_cgo_qty", ""));
		setEtdDyNo(JSPUtil.getParameter(request, prefix + "etd_dy_no", ""));
		setEtdTmHrmnt(JSPUtil.getParameter(request, prefix + "etd_tm_hrmnt", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
		setLatUtCd(JSPUtil.getParameter(request, prefix + "lat_ut_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setLocLon(JSPUtil.getParameter(request, prefix + "loc_lon", ""));
		setEtbDyNo(JSPUtil.getParameter(request, prefix + "etb_dy_no", ""));
		setEtbTmHrmnt(JSPUtil.getParameter(request, prefix + "etb_tm_hrmnt", ""));
		setLocLat(JSPUtil.getParameter(request, prefix + "loc_lat", ""));
		setIbisIfSeq(JSPUtil.getParameter(request, prefix + "ibis_if_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPfSkdDtlIbisIfVO[]
	 */
	public VskPfSkdDtlIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPfSkdDtlIbisIfVO[]
	 */
	public VskPfSkdDtlIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPfSkdDtlIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lonUtCd = (JSPUtil.getParameter(request, prefix	+ "lon_ut_cd", length));
			String[] seaBufSpd = (JSPUtil.getParameter(request, prefix	+ "sea_buf_spd", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd", length));
			String[] scrnLocLon = (JSPUtil.getParameter(request, prefix	+ "scrn_loc_lon", length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs", length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty", length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt", length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq", length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] scrnLocLat = (JSPUtil.getParameter(request, prefix	+ "scrn_loc_lat", length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty", length));
			String[] etdDyNo = (JSPUtil.getParameter(request, prefix	+ "etd_dy_no", length));
			String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_tm_hrmnt", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] latUtCd = (JSPUtil.getParameter(request, prefix	+ "lat_ut_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] locLon = (JSPUtil.getParameter(request, prefix	+ "loc_lon", length));
			String[] etbDyNo = (JSPUtil.getParameter(request, prefix	+ "etb_dy_no", length));
			String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etb_tm_hrmnt", length));
			String[] locLat = (JSPUtil.getParameter(request, prefix	+ "loc_lat", length));
			String[] ibisIfSeq = (JSPUtil.getParameter(request, prefix	+ "ibis_if_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPfSkdDtlIbisIfVO();
				if (lonUtCd[i] != null)
					model.setLonUtCd(lonUtCd[i]);
				if (seaBufSpd[i] != null)
					model.setSeaBufSpd(seaBufSpd[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (scrnLocLon[i] != null)
					model.setScrnLocLon(scrnLocLon[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (etdDyCd[i] != null)
					model.setEtdDyCd(etdDyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (crnKnt[i] != null)
					model.setCrnKnt(crnKnt[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (scrnLocLat[i] != null)
					model.setScrnLocLat(scrnLocLat[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (etdDyNo[i] != null)
					model.setEtdDyNo(etdDyNo[i]);
				if (etdTmHrmnt[i] != null)
					model.setEtdTmHrmnt(etdTmHrmnt[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (latUtCd[i] != null)
					model.setLatUtCd(latUtCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (locLon[i] != null)
					model.setLocLon(locLon[i]);
				if (etbDyNo[i] != null)
					model.setEtbDyNo(etbDyNo[i]);
				if (etbTmHrmnt[i] != null)
					model.setEtbTmHrmnt(etbTmHrmnt[i]);
				if (locLat[i] != null)
					model.setLocLat(locLat[i]);
				if (ibisIfSeq[i] != null)
					model.setIbisIfSeq(ibisIfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPfSkdDtlIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPfSkdDtlIbisIfVO[]
	 */
	public VskPfSkdDtlIbisIfVO[] getVskPfSkdDtlIbisIfVOs(){
		VskPfSkdDtlIbisIfVO[] vos = (VskPfSkdDtlIbisIfVO[])models.toArray(new VskPfSkdDtlIbisIfVO[models.size()]);
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
		this.lonUtCd = this.lonUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufSpd = this.seaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnLocLon = this.scrnLocLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyCd = this.etdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnKnt = this.crnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty = this.ibIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnLocLat = this.scrnLocLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyNo = this.etdDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTmHrmnt = this.etdTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.latUtCd = this.latUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLon = this.locLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyNo = this.etbDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTmHrmnt = this.etbTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locLat = this.locLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibisIfSeq = this.ibisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
