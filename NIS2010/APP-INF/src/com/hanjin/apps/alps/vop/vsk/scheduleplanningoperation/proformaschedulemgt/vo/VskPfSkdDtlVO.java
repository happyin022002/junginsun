/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPfSkdDtlVO.java
*@FileTitle : VskPfSkdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.09 서창열 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPfSkdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPfSkdDtlVO> models = new ArrayList<VskPfSkdDtlVO>();
	
	/* Column Info */
	private String seaBufSpd = null;
	/* Column Info */
	private String avgSeaBufSpd = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String zd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String turnPortFlg = null;
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
	private String obIpcgoQty = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String etdDyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String etdTmHrmnt = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;		//Added Tooltip
	/* Column Info */
	private String etbDyNo = null;
	/* Column Info */
	private String etbTmHrmnt = null;
	
	/* Column Info */
	private String totMaxSpd = null;
	/* Column Info */
	private String totAvgSpd = null;
	/* Column Info */
	private String bufSpd = null;
	/* Column Info */
	private String dur = null;
	/* Column Info */
	private String totBufRat = null;
	/* Column Info */
	private String seaBufRat = null;
	/* Column Info */
	private String portBufRat = null;
	/* Column Info */
	private String pfSpdRat = null;
	/* Column Info */
	private String bufSpdRat = null;
	/* Column Info */
	private String minMaxSpd = null;
	/* Column Info */
	private String mnvrTmHrs = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eventNav = null;
	/* Column Info */
	private String fmZd = null;
	/* Column Info */
	private String toZd = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String currPos = null;
	/* Column Info */
	private String checkWkTm = null;
	/* Column Info */
	private String craneWkTm = null;
	/* Column Info */
	private String checkVslSkd = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String newSimData = null;
	/* Column Info */
	private String pfSkdStsCd = null;
	/* Column Info */
	private String uiEvent = null;
	/* Column Info */
	private String mdmSkdDirCd = null;
	/* Column Info */
	private String svcDurDys = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String n1stVslClssKnt = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n2ndVslClssKnt = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String n3rdVslClssKnt = null;

	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPfSkdDtlVO() {}

	public VskPfSkdDtlVO(String ibflag, String pagerows, String zd, String vslSlanCd, String pfSvcTpCd, String portCd, String skdDirCd, String clptSeq, String portRotnSeq, String ydCd, String ydNm, String callYdIndSeq, String turnPortFlg, String turnPortIndCd, String etbDyCd, String etbDyNo, String etbTmHrmnt, String etdDyCd, String etdDyNo, String etdTmHrmnt, String lnkDist, String lnkSpd, String tztmHrs, String seaBufHrs, String seaBufSpd, String avgSeaBufSpd, String mnvrInHrs, String mnvrOutHrs, String ibIpcgoQty, String ibOcnCgoQty, String obIpcgoQty, String obOcnCgoQty, String tmlProdQty, String crnKnt, String actWrkHrs, String portBufHrs, String totMaxSpd, String totAvgSpd, String bufSpd, String dur, String totBufRat, String seaBufRat, String portBufRat, String pfSpdRat, String bufSpdRat, String minMaxSpd, String mnvrTmHrs, String creDt, String updDt, String creUsrId, String updUsrId, String eventNav, String fmZd, String toZd, String rowSeq, String currPos, String checkWkTm, String craneWkTm, String checkVslSkd, String vslSvcTpCd, String newSimData, String pfSkdStsCd, String uiEvent, String mdmSkdDirCd) {
		this.seaBufSpd = seaBufSpd;
		this.avgSeaBufSpd = avgSeaBufSpd;
		this.mnvrOutHrs = mnvrOutHrs;
		this.etbDyCd = etbDyCd;
		this.lnkSpd = lnkSpd;
		this.zd = zd;
		this.seaBufHrs = seaBufHrs;
		this.turnPortFlg = turnPortFlg;
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
		this.obIpcgoQty = obIpcgoQty;
		this.callYdIndSeq = callYdIndSeq;
		this.obOcnCgoQty = obOcnCgoQty;
		this.lnkDist = lnkDist;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.etdDyNo = etdDyNo;
		this.skdDirCd = skdDirCd;
		this.etdTmHrmnt = etdTmHrmnt;
		this.mnvrInHrs = mnvrInHrs;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.etbDyNo = etbDyNo;
		this.etbTmHrmnt = etbTmHrmnt;
		this.totMaxSpd = totMaxSpd;
		this.totAvgSpd = totAvgSpd;
		this.bufSpd = bufSpd;
		this.dur = dur;
		this.totBufRat = totBufRat;
		this.seaBufRat = seaBufRat;
		this.portBufRat = portBufRat;
		this.pfSpdRat = pfSpdRat;
		this.bufSpdRat = bufSpdRat;
		this.minMaxSpd = minMaxSpd;
		this.mnvrTmHrs = mnvrTmHrs;
		this.creDt = creDt;
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.eventNav = eventNav;
		this.fmZd = fmZd;
		this.toZd = toZd;
		this.rowSeq = rowSeq;
		this.currPos = currPos;
		this.checkWkTm = checkWkTm;
		this.craneWkTm = craneWkTm;
		this.checkVslSkd = checkVslSkd;
		this.vslSvcTpCd = vslSvcTpCd;
		this.newSimData = newSimData;
		this.pfSkdStsCd = pfSkdStsCd;
		this.uiEvent = uiEvent;
		this.mdmSkdDirCd = mdmSkdDirCd;
		this.svcDurDys = svcDurDys;
		this.n1stVslClssCd = n1stVslClssCd;
		this.n1stVslClssKnt= n1stVslClssKnt;
		this.n2ndVslClssCd = n2ndVslClssCd;
		this.n2ndVslClssKnt= n2ndVslClssKnt;
		this.n3rdVslClssCd = n3rdVslClssCd;
		this.n3rdVslClssKnt= n3rdVslClssKnt;

		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
		this.hashColumns.put("avg_sea_buf_spd", getAvgSeaBufSpd());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("zd", getZd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
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
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("etd_dy_no", getEtdDyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("etb_dy_no", getEtbDyNo());
		this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
		this.hashColumns.put("tot_max_spd", getTotMaxSpd());
		this.hashColumns.put("tot_avg_spd", getTotAvgSpd());
		this.hashColumns.put("buf_spd", getBufSpd());
		this.hashColumns.put("dur", getDur());
		this.hashColumns.put("tot_buf_rat", getTotBufRat());
		this.hashColumns.put("sea_buf_rat", getSeaBufRat());
		this.hashColumns.put("port_buf_rat", getPortBufRat());
		this.hashColumns.put("pf_spd_rat", getPfSpdRat());
		this.hashColumns.put("buf_spd_rat", getBufSpdRat());
		this.hashColumns.put("min_max_spd", getMinMaxSpd());
		this.hashColumns.put("mnvr_tm_hrs", getMnvrTmHrs());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eventNav", getEventNav());
		this.hashColumns.put("fm_zd", getFmZd());
		this.hashColumns.put("to_zd", getToZd());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("currPos", getCurrPos());
		this.hashColumns.put("check_wk_tm", getCheckWkTm());
		this.hashColumns.put("crane_wk_tm", getCraneWkTm());
		this.hashColumns.put("check_vsl_skd", getCheckVslSkd());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("new_sim_data", getNewSimData());
		this.hashColumns.put("pf_skd_sts_cd", getPfSkdStsCd());
		this.hashColumns.put("ui_event", getUiEvent());
		this.hashColumns.put("mdm_skd_dir_cd", getMdmSkdDirCd());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("n1st_vsl_clss_cd", getN1stVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_knt", getN1stVslClssKnt());
		this.hashColumns.put("n2nd_vsl_clss_cd", getN2ndVslClssCd());
		this.hashColumns.put("n2nd_vsl_clss_knt", getN2ndVslClssKnt());
		this.hashColumns.put("n3rd_vsl_clss_cd", getN3rdVslClssCd());
		this.hashColumns.put("n3rd_vsl_clss_knt", getN3rdVslClssKnt());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sea_buf_spd", "seaBufSpd");
		this.hashFields.put("avg_sea_buf_spd", "avgSeaBufSpd");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("zd", "zd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
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
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("etd_dy_no", "etdDyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("etb_dy_no", "etbDyNo");
		this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
		this.hashFields.put("tot_max_spd", "totMaxSpd");
		this.hashFields.put("tot_avg_spd", "totAvgSpd");
		this.hashFields.put("buf_spd", "bufSpd");
		this.hashFields.put("dur", "dur");
		this.hashFields.put("tot_buf_rat", "totBufRat");
		this.hashFields.put("sea_buf_rat", "seaBufRat");
		this.hashFields.put("port_buf_rat", "portBufRat");
		this.hashFields.put("pf_spd_rat", "pfSpdRat");
		this.hashFields.put("buf_spd_rat", "bufSpdRat");
		this.hashFields.put("min_max_spd", "minMaxSpd");
		this.hashFields.put("mnvr_tm_hrs", "mnvrTmHrs");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eventNav", "eventNav");
		this.hashFields.put("fm_zd", "fmZd");
		this.hashFields.put("to_zd", "toZd");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("currPos", "currPos");
		this.hashFields.put("check_wk_tm", "checkWkTm");
		this.hashFields.put("crane_wk_tm", "craneWkTm");
		this.hashFields.put("check_vsl_skd", "checkVslSkd");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("new_sim_data", "newSimData");
		this.hashFields.put("pf_skd_sts_cd", "pfSkdStsCd");
		this.hashFields.put("ui_event", "uiEvent");
		this.hashFields.put("mdm_skd_dir_cd", "mdmSkdDirCd");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("n1st_vsl_clss_knt", "n1stVslClssKnt");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n2nd_vsl_clss_knt", "n2ndVslClssKnt");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("n3rd_vsl_clss_knt", "n3rdVslClssKnt");

		return this.hashFields;
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
	 * @return avgSeaBufSpd
	 */
	public String getAvgSeaBufSpd() {
		return this.avgSeaBufSpd;
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
	 * @return lnkSpd
	 */
	public String getLnkSpd() {
		return this.lnkSpd;
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
	 * @return obOcnCgoQty
	 */
	public String getObOcnCgoQty() {
		return this.obOcnCgoQty;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return etbTmHrmnt
	 */
	public String getTotMaxSpd() {
		return this.totMaxSpd;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getTotAvgSpd() {
		return this.totAvgSpd;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getBufSpd() {
		return this.bufSpd;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getDur() {
		return this.dur;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getTotBufRat() {
		return this.totBufRat;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getSeaBufRat() {
		return this.seaBufRat;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getPortBufRat() {
		return this.portBufRat;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getPfSpdRat() {
		return this.pfSpdRat;
	}
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getBufSpdRat() {
		return this.bufSpdRat;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getMinMaxSpd() {
		return this.minMaxSpd;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getMnvrTmHrs() {
		return this.mnvrTmHrs;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getEventNav() {
		return this.eventNav;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getFmZd() {
		return this.fmZd;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getToZd() {
		return this.toZd;
	}
	
	/**
	 * Column Info
	 * @return etbTmHrmnt
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}
	
	/**
	 * Column Info
	 * @return currPos
	 */
	public String getCurrPos() {
		return this.currPos;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getCheckWkTm() {
		return this.checkWkTm;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getCraneWkTm() {
		return this.craneWkTm;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getCheckVslSkd() {
		return this.checkVslSkd;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getNewSimData() {
		return this.newSimData;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getPfSkdStsCd() {
		return this.pfSkdStsCd;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getUiEvent() {
		return this.uiEvent;
	}
	
	/**
	 * Column Info
	 * @return mdmSkdDirCd
	 */
	public String getMdmSkdDirCd(){
		return this.mdmSkdDirCd;
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
	 * @return n1stVslClssCd
	 */
	public String getN1stVslClssCd() {
		return this.n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssKnt
	 */
	public String getN1stVslClssKnt() {
		return this.n1stVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssCd
	 */
	public String getN2ndVslClssCd() {
		return this.n2ndVslClssCd;
	}	
	
	/**
	 * Column Info
	 * @return n2ndtVslClssKnt
	 */
	public String getN2ndVslClssKnt() {
		return this.n2ndVslClssKnt;
	}	
	
	/**
	 * Column Info
	 * @return n3rdVslClssCd
	 */
	public String getN3rdVslClssCd() {
		return this.n3rdVslClssCd;
	}	
	
	/**
	 * Column Info
	 * @return n3rdVslClssKnt
	 */
	public String getN3rdVslClssKnt() {
		return this.n3rdVslClssKnt;
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
	 * @param avgSeaBufSpd
	 */
	public void setAvgSeaBufSpd(String avgSeaBufSpd) {
		this.avgSeaBufSpd = avgSeaBufSpd;
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
	 * @param lnkSpd
	 */
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
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
	 * @param obOcnCgoQty
	 */
	public void setObOcnCgoQty(String obOcnCgoQty) {
		this.obOcnCgoQty = obOcnCgoQty;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param etbTmHrmnt
	 */
	public void setTotMaxSpd(String totMaxSpd) {
		this.totMaxSpd = totMaxSpd;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setTotAvgSpd(String totAvgSpd) {
		this.totAvgSpd = totAvgSpd;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setBufSpd(String bufSpd) {
		this.bufSpd = bufSpd;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setDur(String dur) {
		this.dur = dur;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setTotBufRat(String totBufRat) {
		this.totBufRat = totBufRat;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setSeaBufRat(String seaBufRat) {
		this.seaBufRat = seaBufRat;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setPortBufRat(String portBufRat) {
		this.portBufRat = portBufRat;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setPfSpdRat(String pfSpdRat) {
		this.pfSpdRat = pfSpdRat;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setBufSpdRat(String bufSpdRat) {
		this.bufSpdRat = bufSpdRat;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setMinMaxSpd(String minMaxSpd) {
		this.minMaxSpd = minMaxSpd;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setMnvrTmHrs(String mnvrTmHrs) {
		this.mnvrTmHrs = mnvrTmHrs;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setEventNav(String eventNav) {
		this.eventNav = eventNav;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setFmZd(String fmZd) {
		this.fmZd = fmZd;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setToZd(String toZd) {
		this.toZd = toZd;
	}
	
	/**
	 * Column Info
	 * @param etbTmHrmnt
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}
	
	/**
	 * Column Info
	 * @param currPos
	 */
	public void setCurrPos(String currPos) {
		this.currPos = currPos;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setCheckWkTm(String checkWkTm) {
		this.checkWkTm = checkWkTm;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setCraneWkTm(String craneWkTm) {
		this.craneWkTm = craneWkTm;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setCheckVslSkd(String checkVslSkd) {
		this.checkVslSkd = checkVslSkd;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setNewSimData(String newSimData) {
		this.newSimData = newSimData;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setPfSkdStsCd(String pfSkdStsCd) {
		this.pfSkdStsCd = pfSkdStsCd;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setUiEvent(String uiEvent) {
		this.uiEvent = uiEvent;
	}
	
	/**
	 * Column Info
	 * @param mdmSkdDirCd
	 */
	public void setMdmSkdDirCd(String mdmSkdDirCd){
		this.mdmSkdDirCd = mdmSkdDirCd;
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
	 * @param n1stVslClssCd
	 */
	public void setN1stVslClssCd(String n1stVslClssCd) {
		this.n1stVslClssCd = n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssKnt
	 */
	public void setN1stVslClssKnt(String n1stVslClssKnt) {
		this.n1stVslClssKnt = n1stVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssCd
	 */
	public void setN2ndVslClssCd(String n2ndVslClssCd) {
		this.n2ndVslClssCd = n2ndVslClssCd;
	}	
	
	/**
	 * Column Info
	 * @param n2ndtVslClssKnt
	 */
	public void setN2ndVslClssKnt(String n2ndVslClssKnt) {
		this.n2ndVslClssKnt = n2ndVslClssKnt;
	}	
	
	/**
	 * Column Info
	 * @param n3rdVslClssCd
	 */
	public void setN3rdVslClssCd(String n3rdVslClssCd) {
		this.n3rdVslClssCd = n3rdVslClssCd;
	}	
	
	/**
	 * Column Info
	 * @param n3rdVslClssKnt
	 */
	public void setN3rdVslClssKnt(String n3rdVslClssKnt) {
		this.n3rdVslClssKnt = n3rdVslClssKnt;
	}	
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSeaBufSpd(JSPUtil.getParameter(request, "sea_buf_spd", ""));
		setAvgSeaBufSpd(JSPUtil.getParameter(request, "avg_sea_buf_spd", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
		setLnkSpd(JSPUtil.getParameter(request, "lnk_spd", ""));
		setZd(JSPUtil.getParameter(request, "zd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setActWrkHrs(JSPUtil.getParameter(request, "act_wrk_hrs", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setCrnKnt(JSPUtil.getParameter(request, "crn_knt", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setEtdDyNo(JSPUtil.getParameter(request, "etd_dy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setEtdTmHrmnt(JSPUtil.getParameter(request, "etd_tm_hrmnt", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_Nm", ""));
		setEtbDyNo(JSPUtil.getParameter(request, "etb_dy_no", ""));
		setEtbTmHrmnt(JSPUtil.getParameter(request, "etb_tm_hrmnt", ""));
		
		setTotMaxSpd(JSPUtil.getParameter(request, "tot_max_spd", ""));
		setTotAvgSpd(JSPUtil.getParameter(request, "tot_avg_spd", ""));
		setBufSpd(JSPUtil.getParameter(request, "buf_spd", ""));
		setDur(JSPUtil.getParameter(request, "dur", ""));
		setTotBufRat(JSPUtil.getParameter(request, "tot_buf_rat", ""));
		setSeaBufRat(JSPUtil.getParameter(request, "sea_buf_rat", ""));
		setPortBufRat(JSPUtil.getParameter(request, "port_buf_rat", ""));
		setPfSpdRat(JSPUtil.getParameter(request, "pf_spd_rat", ""));
		setBufSpdRat(JSPUtil.getParameter(request, "buf_spd_rat", ""));
		setMinMaxSpd(JSPUtil.getParameter(request, "min_max_spd", ""));
		
		setMnvrTmHrs(JSPUtil.getParameter(request, "mnvr_tm_hrs", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEventNav(JSPUtil.getParameter(request, "eventNav", ""));
		setFmZd(JSPUtil.getParameter(request, "fm_zd", ""));
		setToZd(JSPUtil.getParameter(request, "to_zd", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setCurrPos(JSPUtil.getParameter(request, "currPos", ""));
		setCheckWkTm(JSPUtil.getParameter(request, "check_wk_tm", ""));
		setCraneWkTm(JSPUtil.getParameter(request, "crane_wk_tm", ""));
		setCheckVslSkd(JSPUtil.getParameter(request, "check_vsl_skd", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setNewSimData(JSPUtil.getParameter(request, "new_sim_data", ""));
		setPfSkdStsCd(JSPUtil.getParameter(request, "pf_skd_sts_cd", ""));
		setUiEvent(JSPUtil.getParameter(request, "ui_event", ""));
		setMdmSkdDirCd(JSPUtil.getParameter(request, "mdm_skd_dir_cd", ""));
		setSvcDurDys(JSPUtil.getParameter(request, "svc_dur_dys", ""));

		setN1stVslClssCd(JSPUtil.getParameter(request, "n1st_vsl_clss_cd", ""));
		setN1stVslClssKnt(JSPUtil.getParameter(request, "n1st_vsl_clss_knt", ""));
		setN2ndVslClssCd(JSPUtil.getParameter(request, "n2nd_vsl_clss_cd", ""));
		setN2ndVslClssKnt(JSPUtil.getParameter(request, "n2nd_vsl_clss_knt", ""));
		setN3rdVslClssCd(JSPUtil.getParameter(request, "n3rd_vsl_clss_cd", ""));
		setN3rdVslClssKnt(JSPUtil.getParameter(request, "n3rd_vsl_clss_knt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPfSkdDtlVO[]
	 */
	public VskPfSkdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPfSkdDtlVO[]
	 */
	public VskPfSkdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPfSkdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] seaBufSpd = (JSPUtil.getParameter(request, prefix	+ "sea_buf_spd".trim(), length));
			String[] avgSeaBufSpd = (JSPUtil.getParameter(request, prefix	+ "avg_sea_buf_spd".trim(), length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs".trim(), length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd".trim(), length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd".trim(), length));
			String[] zd = (JSPUtil.getParameter(request, prefix	+ "zd".trim(), length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs".trim(), length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg".trim(), length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs".trim(), length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty".trim(), length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs".trim(), length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd".trim(), length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt".trim(), length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq".trim(), length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty".trim(), length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq".trim(), length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty".trim(), length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist".trim(), length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty".trim(), length));
			String[] etdDyNo = (JSPUtil.getParameter(request, prefix	+ "etd_dy_no".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_tm_hrmnt".trim(), length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm".trim(), length));

			String[] etbDyNo = (JSPUtil.getParameter(request, prefix	+ "etb_dy_no".trim(), length));
			String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etb_tm_hrmnt".trim(), length));
			String[] totMaxSpd = (JSPUtil.getParameter(request, prefix	+ "tot_max_spd".trim(), length));
			String[] totAvgSpd = (JSPUtil.getParameter(request, prefix	+ "tot_avg_spd".trim(), length));
			String[] bufSpd = (JSPUtil.getParameter(request, prefix	+ "buf_spd".trim(), length));
			String[] dur = (JSPUtil.getParameter(request, prefix	+ "dur".trim(), length));
			String[] totBufRat = (JSPUtil.getParameter(request, prefix	+ "tot_buf_rat".trim(), length));
			String[] seaBufRat = (JSPUtil.getParameter(request, prefix	+ "sea_buf_rat".trim(), length));
			String[] portBufRat = (JSPUtil.getParameter(request, prefix	+ "port_buf_rat".trim(), length));
			String[] pfSpdRat = (JSPUtil.getParameter(request, prefix	+ "pf_spd_rat".trim(), length));
			String[] bufSpdRat = (JSPUtil.getParameter(request, prefix	+ "buf_spd_rat".trim(), length));
			String[] minMaxSpd = (JSPUtil.getParameter(request, prefix	+ "min_max_spd".trim(), length));
			String[] mnvrTmHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_tm_hrs".trim(), length));
			
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] eventNav = (JSPUtil.getParameter(request, prefix	+ "eventNav".trim(), length));
			String[] fmZd = (JSPUtil.getParameter(request, prefix	+ "fm_zd".trim(), length));
			String[] toZd = (JSPUtil.getParameter(request, prefix	+ "to_zd".trim(), length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq".trim(), length));
			String[] currPos = (JSPUtil.getParameter(request, prefix	+ "currPos".trim(), length));
			String[] checkWkTm = (JSPUtil.getParameter(request, prefix	+ "check_wk_tm".trim(), length));
			String[] craneWkTm = (JSPUtil.getParameter(request, prefix	+ "crane_wk_tm".trim(), length));
			String[] checkVslSkd = (JSPUtil.getParameter(request, prefix	+ "check_vsl_skd".trim(), length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd".trim(), length));
			String[] newSimData = (JSPUtil.getParameter(request, prefix	+ "new_sim_data".trim(), length));
			String[] pfSkdStsCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_sts_cd".trim(), length));
			String[] uiEvent = (JSPUtil.getParameter(request, prefix	+ "ui_event".trim(), length));
			String[] mdmSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "mdm_skd_dir_cd".trim(), length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix	+ "svc_dur_dys", length));

			String[] n1stVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd", length));
			String[] n1stVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_knt", length));
			String[] n2ndVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd", length));
			String[] n2ndVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_knt", length));
			String[] n3rdVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd", length));
			String[] n3rdVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_knt", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new VskPfSkdDtlVO();
				if (seaBufSpd[i] != null)
					model.setSeaBufSpd(seaBufSpd[i]);
				if (avgSeaBufSpd[i] != null)
					model.setAvgSeaBufSpd(avgSeaBufSpd[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (zd[i] != null)
					model.setZd(zd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
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
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (etdDyNo[i] != null)
					model.setEtdDyNo(etdDyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (etdTmHrmnt[i] != null)
					model.setEtdTmHrmnt(etdTmHrmnt[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (etbDyNo[i] != null)
					model.setEtbDyNo(etbDyNo[i]);
				if (etbTmHrmnt[i] != null)
					model.setEtbTmHrmnt(etbTmHrmnt[i]);
				if (totMaxSpd[i] != null)
					model.setTotMaxSpd(totMaxSpd[i]);
				if (totAvgSpd[i] != null)
					model.setTotAvgSpd(totAvgSpd[i]);
				if (bufSpd[i] != null)
					model.setBufSpd(bufSpd[i]);
				if (dur[i] != null)
					model.setDur(dur[i]);
				if (totBufRat[i] != null)
					model.setTotBufRat(totBufRat[i]);
				if (seaBufRat[i] != null)
					model.setSeaBufRat(seaBufRat[i]);
				if (portBufRat[i] != null)
					model.setPortBufRat(portBufRat[i]);
				if (pfSpdRat[i] != null)
					model.setPfSpdRat(pfSpdRat[i]);
				if (bufSpdRat[i] != null)
					model.setBufSpdRat(bufSpdRat[i]);
				if (minMaxSpd[i] != null)
					model.setMinMaxSpd(minMaxSpd[i]);
				if (mnvrTmHrs[i] != null)
					model.setMnvrTmHrs(mnvrTmHrs[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eventNav[i] != null)
					model.setEventNav(eventNav[i]);
				if (fmZd[i] != null)
					model.setFmZd(fmZd[i]);
				if (toZd[i] != null)
					model.setToZd(toZd[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (currPos[i] != null)
					model.setCurrPos(currPos[i]);
				if (checkWkTm[i] != null)
					model.setCheckWkTm(checkWkTm[i]);
				if (craneWkTm[i] != null)
					model.setCraneWkTm(craneWkTm[i]);
				if (checkVslSkd[i] != null)
					model.setCheckVslSkd(checkVslSkd[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (newSimData[i] != null)
					model.setNewSimData(newSimData[i]);
				if (pfSkdStsCd[i] != null)
					model.setPfSkdStsCd(pfSkdStsCd[i]);
				if (uiEvent[i] != null)
					model.setUiEvent(uiEvent[i]);
				if (mdmSkdDirCd[i] != null)
					model.setMdmSkdDirCd(mdmSkdDirCd[i]);
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (n1stVslClssKnt[i] != null)
					model.setN1stVslClssKnt(n1stVslClssKnt[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n2ndVslClssKnt[i] != null)
					model.setN2ndVslClssKnt(n2ndVslClssKnt[i]);
				if (n1stVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (n1stVslClssKnt[i] != null)
					model.setN3rdVslClssKnt(n3rdVslClssKnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPfSkdDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPfSkdDtlVO[]
	 */
	public VskPfSkdDtlVO[] getVskPfSkdDtlVOs(){
		VskPfSkdDtlVO[] vos = (VskPfSkdDtlVO[])models.toArray(new VskPfSkdDtlVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.seaBufSpd = this.seaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSeaBufSpd = this.avgSeaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zd = this.zd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyNo = this.etdDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTmHrmnt = this.etdTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.etbDyNo = this.etbDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTmHrmnt = this.etbTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMaxSpd = this.totMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgSpd = this.totAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bufSpd = this.bufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dur = this.dur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBufRat = this.totBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufRat = this.seaBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufRat = this.portBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSpdRat = this.pfSpdRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bufSpdRat = this.bufSpdRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minMaxSpd = this.minMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrTmHrs = this.mnvrTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventNav = this.eventNav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmZd = this.fmZd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toZd = this.toZd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPos = this.currPos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkWkTm = this.checkWkTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.craneWkTm = this.craneWkTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVslSkd = this.checkVslSkd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSimData = this.newSimData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdStsCd = this.pfSkdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiEvent = this.uiEvent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmSkdDirCd = this.mdmSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.n1stVslClssCd = this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssKnt = this.n1stVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd = this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssKnt = this.n2ndVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd = this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssKnt = this.n3rdVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
