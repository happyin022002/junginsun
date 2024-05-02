/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimPortListVO.java
*@FileTitle : SearchSimPortListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.09 윤진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimPortListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimPortListVO> models = new ArrayList<SearchSimPortListVO>();
	
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String stndSvcSpd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String actWrkHrs = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String vslCnt = null;
	/* Column Info */
	private String etdDyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String tmnlName = null;
	/* Column Info */
	private String vslDblCallSeq = null;
	/* Column Info */
	private String svcDurDys = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String etdDyNo = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String volCnt = null;
	/* Column Info */
	private String brthItvalDys = null;
	/* Column Info */
	private String etdTmHrmnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String maxSpeed = null;
	/* Column Info */
	private String etbDyNo = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String seaBufSpd = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String extdLaneFlg = null;
	/* Column Info */
	private String zd = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String portYd = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String minSpeed = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crnKnt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String portUsdAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String etbTmHrmnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimPortListVO() {}

	public SearchSimPortListVO(String ibflag, String pagerows, String delChk, String stsCd, String portSeq, String slanCd, String skdDirCd, String portCd, String portYd, String tmnlName, String turnPortIndCd, String portDys, String seaDys, String portUsdAmt, String etbDyNo, String etbDyCd, String etbTmHrmnt, String etdDyNo, String etdDyCd, String etdTmHrmnt, String lnkDist, String mnvrInHrs, String mnvrOutHrs, String lnkSpd, String tztmHrs, String seaBufHrs, String actWrkHrs, String portBufHrs, String ibIpcgoQty, String obIpcgoQty, String ibOcnCgoQty, String obOcnCgoQty, String tmlProdQty, String crnKnt, String vslDblCallSeq, String zd, String simDt, String simNo, String volCnt, String extdLaneFlg, String stndSvcSpd, String turnPortFlg, String callYdIndSeq, String seaBufSpd, String rowNum, String tmlCd, String creUsrId, String updUsrId, String svcDurDys, String brthItvalDys, String vslClssCapa, String vslCnt, String maxSpeed, String minSpeed) {
		this.lnkSpd = lnkSpd;
		this.stndSvcSpd = stndSvcSpd;
		this.seaBufHrs = seaBufHrs;
		this.actWrkHrs = actWrkHrs;
		this.simNo = simNo;
		this.portBufHrs = portBufHrs;
		this.tztmHrs = tztmHrs;
		this.tmlCd = tmlCd;
		this.vslCnt = vslCnt;
		this.etdDyCd = etdDyCd;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.turnPortIndCd = turnPortIndCd;
		this.tmnlName = tmnlName;
		this.vslDblCallSeq = vslDblCallSeq;
		this.svcDurDys = svcDurDys;
		this.ibIpcgoQty = ibIpcgoQty;
		this.obIpcgoQty = obIpcgoQty;
		this.updUsrId = updUsrId;
		this.lnkDist = lnkDist;
		this.etdDyNo = etdDyNo;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.volCnt = volCnt;
		this.brthItvalDys = brthItvalDys;
		this.etdTmHrmnt = etdTmHrmnt;
		this.creUsrId = creUsrId;
		this.maxSpeed = maxSpeed;
		this.etbDyNo = etbDyNo;
		this.vslClssCapa = vslClssCapa;
		this.rowNum = rowNum;
		this.seaBufSpd = seaBufSpd;
		this.mnvrOutHrs = mnvrOutHrs;
		this.etbDyCd = etbDyCd;
		this.extdLaneFlg = extdLaneFlg;
		this.zd = zd;
		this.turnPortFlg = turnPortFlg;
		this.portYd = portYd;
		this.simDt = simDt;
		this.tmlProdQty = tmlProdQty;
		this.minSpeed = minSpeed;
		this.ibflag = ibflag;
		this.crnKnt = crnKnt;
		this.portCd = portCd;
		this.callYdIndSeq = callYdIndSeq;
		this.obOcnCgoQty = obOcnCgoQty;
		this.portDys = portDys;
		this.portUsdAmt = portUsdAmt;
		this.skdDirCd = skdDirCd;
		this.mnvrInHrs = mnvrInHrs;
		this.seaDys = seaDys;
		this.delChk = delChk;
		this.portSeq = portSeq;
		this.slanCd = slanCd;
		this.etbTmHrmnt = etbTmHrmnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("stnd_svc_spd", getStndSvcSpd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("vsl_cnt", getVslCnt());
		this.hashColumns.put("etd_dy_cd", getEtdDyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("tmnl_name", getTmnlName());
		this.hashColumns.put("vsl_dbl_call_seq", getVslDblCallSeq());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("etd_dy_no", getEtdDyNo());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("vol_cnt", getVolCnt());
		this.hashColumns.put("brth_itval_dys", getBrthItvalDys());
		this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("max_speed", getMaxSpeed());
		this.hashColumns.put("etb_dy_no", getEtbDyNo());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("extd_lane_flg", getExtdLaneFlg());
		this.hashColumns.put("zd", getZd());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("port_yd", getPortYd());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("min_speed", getMinSpeed());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crn_knt", getCrnKnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("port_usd_amt", getPortUsdAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("stnd_svc_spd", "stndSvcSpd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("vsl_cnt", "vslCnt");
		this.hashFields.put("etd_dy_cd", "etdDyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("tmnl_name", "tmnlName");
		this.hashFields.put("vsl_dbl_call_seq", "vslDblCallSeq");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("etd_dy_no", "etdDyNo");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("vol_cnt", "volCnt");
		this.hashFields.put("brth_itval_dys", "brthItvalDys");
		this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("max_speed", "maxSpeed");
		this.hashFields.put("etb_dy_no", "etbDyNo");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("sea_buf_spd", "seaBufSpd");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("extd_lane_flg", "extdLaneFlg");
		this.hashFields.put("zd", "zd");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("port_yd", "portYd");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("min_speed", "minSpeed");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crn_knt", "crnKnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("port_usd_amt", "portUsdAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
		return this.hashFields;
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
	 * @return stndSvcSpd
	 */
	public String getStndSvcSpd() {
		return this.stndSvcSpd;
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
	 * @return actWrkHrs
	 */
	public String getActWrkHrs() {
		return this.actWrkHrs;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return tztmHrs
	 */
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return vslCnt
	 */
	public String getVslCnt() {
		return this.vslCnt;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return tmnlName
	 */
	public String getTmnlName() {
		return this.tmnlName;
	}
	
	/**
	 * Column Info
	 * @return vslDblCallSeq
	 */
	public String getVslDblCallSeq() {
		return this.vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @return svcDurDys
	 */
	public String getSvcDurDys() {
		return this.svcDurDys;
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
	 * @return obIpcgoQty
	 */
	public String getObIpcgoQty() {
		return this.obIpcgoQty;
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
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
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
	 * @return ibOcnCgoQty
	 */
	public String getIbOcnCgoQty() {
		return this.ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @return volCnt
	 */
	public String getVolCnt() {
		return this.volCnt;
	}
	
	/**
	 * Column Info
	 * @return brthItvalDys
	 */
	public String getBrthItvalDys() {
		return this.brthItvalDys;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return maxSpeed
	 */
	public String getMaxSpeed() {
		return this.maxSpeed;
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
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
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
	 * @return extdLaneFlg
	 */
	public String getExtdLaneFlg() {
		return this.extdLaneFlg;
	}
	
	/**
	 * Column Info
	 * @return zd
	 */
	public String getZd() {
		return this.zd;
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
	 * @return portYd
	 */
	public String getPortYd() {
		return this.portYd;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
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
	 * @return minSpeed
	 */
	public String getMinSpeed() {
		return this.minSpeed;
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
	 * @return crnKnt
	 */
	public String getCrnKnt() {
		return this.crnKnt;
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
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
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
	 * @return portDys
	 */
	public String getPortDys() {
		return this.portDys;
	}
	
	/**
	 * Column Info
	 * @return portUsdAmt
	 */
	public String getPortUsdAmt() {
		return this.portUsdAmt;
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
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param lnkSpd
	 */
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
	}
	
	/**
	 * Column Info
	 * @param stndSvcSpd
	 */
	public void setStndSvcSpd(String stndSvcSpd) {
		this.stndSvcSpd = stndSvcSpd;
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
	 * @param actWrkHrs
	 */
	public void setActWrkHrs(String actWrkHrs) {
		this.actWrkHrs = actWrkHrs;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param tztmHrs
	 */
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param vslCnt
	 */
	public void setVslCnt(String vslCnt) {
		this.vslCnt = vslCnt;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param tmnlName
	 */
	public void setTmnlName(String tmnlName) {
		this.tmnlName = tmnlName;
	}
	
	/**
	 * Column Info
	 * @param vslDblCallSeq
	 */
	public void setVslDblCallSeq(String vslDblCallSeq) {
		this.vslDblCallSeq = vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @param svcDurDys
	 */
	public void setSvcDurDys(String svcDurDys) {
		this.svcDurDys = svcDurDys;
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
	 * @param obIpcgoQty
	 */
	public void setObIpcgoQty(String obIpcgoQty) {
		this.obIpcgoQty = obIpcgoQty;
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
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
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
	 * @param ibOcnCgoQty
	 */
	public void setIbOcnCgoQty(String ibOcnCgoQty) {
		this.ibOcnCgoQty = ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param volCnt
	 */
	public void setVolCnt(String volCnt) {
		this.volCnt = volCnt;
	}
	
	/**
	 * Column Info
	 * @param brthItvalDys
	 */
	public void setBrthItvalDys(String brthItvalDys) {
		this.brthItvalDys = brthItvalDys;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param maxSpeed
	 */
	public void setMaxSpeed(String maxSpeed) {
		this.maxSpeed = maxSpeed;
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
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
	 * @param extdLaneFlg
	 */
	public void setExtdLaneFlg(String extdLaneFlg) {
		this.extdLaneFlg = extdLaneFlg;
	}
	
	/**
	 * Column Info
	 * @param zd
	 */
	public void setZd(String zd) {
		this.zd = zd;
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
	 * @param portYd
	 */
	public void setPortYd(String portYd) {
		this.portYd = portYd;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
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
	 * @param minSpeed
	 */
	public void setMinSpeed(String minSpeed) {
		this.minSpeed = minSpeed;
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
	 * @param crnKnt
	 */
	public void setCrnKnt(String crnKnt) {
		this.crnKnt = crnKnt;
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
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
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
	 * @param portDys
	 */
	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}
	
	/**
	 * Column Info
	 * @param portUsdAmt
	 */
	public void setPortUsdAmt(String portUsdAmt) {
		this.portUsdAmt = portUsdAmt;
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
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setEtbTmHrmnt(String etbTmHrmnt) {
		this.etbTmHrmnt = etbTmHrmnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLnkSpd(JSPUtil.getParameter(request, "lnk_spd", ""));
		setStndSvcSpd(JSPUtil.getParameter(request, "stnd_svc_spd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setActWrkHrs(JSPUtil.getParameter(request, "act_wrk_hrs", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setVslCnt(JSPUtil.getParameter(request, "vsl_cnt", ""));
		setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setTmnlName(JSPUtil.getParameter(request, "tmnl_name", ""));
		setVslDblCallSeq(JSPUtil.getParameter(request, "vsl_dbl_call_seq", ""));
		setSvcDurDys(JSPUtil.getParameter(request, "f_svc_dur_dys", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setEtdDyNo(JSPUtil.getParameter(request, "etd_dy_no", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setVolCnt(JSPUtil.getParameter(request, "vol_cnt", ""));
		setBrthItvalDys(JSPUtil.getParameter(request, "f_brth_itval_dys", ""));
		setEtdTmHrmnt(JSPUtil.getParameter(request, "etd_tm_hrmnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMaxSpeed(JSPUtil.getParameter(request, "f_max_speed", ""));
		setEtbDyNo(JSPUtil.getParameter(request, "etb_dy_no", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
		setSeaBufSpd(JSPUtil.getParameter(request, "sea_buf_spd", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
		setExtdLaneFlg(JSPUtil.getParameter(request, "extd_lane_flg", ""));
		setZd(JSPUtil.getParameter(request, "zd", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setPortYd(JSPUtil.getParameter(request, "port_yd", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setMinSpeed(JSPUtil.getParameter(request, "f_min_speed", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrnKnt(JSPUtil.getParameter(request, "crn_knt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setPortDys(JSPUtil.getParameter(request, "port_dys", ""));
		setPortUsdAmt(JSPUtil.getParameter(request, "port_usd_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setSeaDys(JSPUtil.getParameter(request, "sea_dys", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setEtbTmHrmnt(JSPUtil.getParameter(request, "etb_tm_hrmnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimPortListVO[]
	 */
	public SearchSimPortListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimPortListVO[]
	 */
	public SearchSimPortListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimPortListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd", length));
			String[] stndSvcSpd = (JSPUtil.getParameter(request, prefix	+ "stnd_svc_spd", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] vslCnt = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt", length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] tmnlName = (JSPUtil.getParameter(request, prefix	+ "tmnl_name", length));
			String[] vslDblCallSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_dbl_call_seq", length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix	+ "f_svc_dur_dys", length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty", length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] etdDyNo = (JSPUtil.getParameter(request, prefix	+ "etd_dy_no", length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty", length));
			String[] volCnt = (JSPUtil.getParameter(request, prefix	+ "vol_cnt", length));
			String[] brthItvalDys = (JSPUtil.getParameter(request, prefix	+ "f_brth_itval_dys", length));
			String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_tm_hrmnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] maxSpeed = (JSPUtil.getParameter(request, prefix	+ "f_max_speed", length));
			String[] etbDyNo = (JSPUtil.getParameter(request, prefix	+ "etb_dy_no", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] seaBufSpd = (JSPUtil.getParameter(request, prefix	+ "sea_buf_spd", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd", length));
			String[] extdLaneFlg = (JSPUtil.getParameter(request, prefix	+ "extd_lane_flg", length));
			String[] zd = (JSPUtil.getParameter(request, prefix	+ "zd", length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg", length));
			String[] portYd = (JSPUtil.getParameter(request, prefix	+ "port_yd", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty", length));
			String[] minSpeed = (JSPUtil.getParameter(request, prefix	+ "f_min_speed", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty", length));
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] portUsdAmt = (JSPUtil.getParameter(request, prefix	+ "port_usd_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etb_tm_hrmnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimPortListVO();
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (stndSvcSpd[i] != null)
					model.setStndSvcSpd(stndSvcSpd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (vslCnt[i] != null)
					model.setVslCnt(vslCnt[i]);
				if (etdDyCd[i] != null)
					model.setEtdDyCd(etdDyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (tmnlName[i] != null)
					model.setTmnlName(tmnlName[i]);
				if (vslDblCallSeq[i] != null)
					model.setVslDblCallSeq(vslDblCallSeq[i]);
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (etdDyNo[i] != null)
					model.setEtdDyNo(etdDyNo[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (volCnt[i] != null)
					model.setVolCnt(volCnt[i]);
				if (brthItvalDys[i] != null)
					model.setBrthItvalDys(brthItvalDys[i]);
				if (etdTmHrmnt[i] != null)
					model.setEtdTmHrmnt(etdTmHrmnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (maxSpeed[i] != null)
					model.setMaxSpeed(maxSpeed[i]);
				if (etbDyNo[i] != null)
					model.setEtbDyNo(etbDyNo[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (seaBufSpd[i] != null)
					model.setSeaBufSpd(seaBufSpd[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (extdLaneFlg[i] != null)
					model.setExtdLaneFlg(extdLaneFlg[i]);
				if (zd[i] != null)
					model.setZd(zd[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (portYd[i] != null)
					model.setPortYd(portYd[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (minSpeed[i] != null)
					model.setMinSpeed(minSpeed[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crnKnt[i] != null)
					model.setCrnKnt(crnKnt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (portUsdAmt[i] != null)
					model.setPortUsdAmt(portUsdAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (etbTmHrmnt[i] != null)
					model.setEtbTmHrmnt(etbTmHrmnt[i]);
				models.add(model);
				
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimPortListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimPortListVO[]
	 */
	public SearchSimPortListVO[] getSearchSimPortListVOs(){
		SearchSimPortListVO[] vos = (SearchSimPortListVO[])models.toArray(new SearchSimPortListVO[models.size()]);
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
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndSvcSpd = this.stndSvcSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCnt = this.vslCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyCd = this.etdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlName = this.tmnlName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDblCallSeq = this.vslDblCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty = this.ibIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyNo = this.etdDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volCnt = this.volCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthItvalDys = this.brthItvalDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTmHrmnt = this.etdTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpeed = this.maxSpeed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyNo = this.etbDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufSpd = this.seaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.extdLaneFlg = this.extdLaneFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zd = this.zd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portYd = this.portYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minSpeed = this.minSpeed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnKnt = this.crnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portUsdAmt = this.portUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTmHrmnt = this.etbTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	//추가  부분 [Start]
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;
	
	/* DB RowSet 객체  */
	private DBRowSet[] rowSetArray = null;	
	
	/* DB List 객체  */
	List<SearchSimPortListVO> list = null;	
	
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	/** DBRowSet Array Getter */
	public DBRowSet[] getRowSetArray() {
		return rowSetArray;
	}
	/** DBRowSet Array Setter */
	public void setRowSetArray(DBRowSet[] rowSetArray) {
		this.rowSetArray = rowSetArray;
	}	
	
	/** DB List Getter */
	public List<SearchSimPortListVO> getListSet() {
		return list;
	}

	/** DB List Setter */
	public void setListSet(List<SearchSimPortListVO> list) {
		this.list = list;
	}		
	//추가  부분 [End]	
}
