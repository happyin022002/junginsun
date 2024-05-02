/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfSkdRequestVO.java
*@FileTitle : PfSkdRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.17 서창열 
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

public class PfSkdRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfSkdRequestVO> models = new ArrayList<PfSkdRequestVO>();
	
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String n1stVslClssKnt = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String stndSvcSpd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String actWrkHrs = null;
	/* Column Info */
	private String portBufRat = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
	private String totAvgSpd = null;
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
	/* Column Info */
	private String svcDurDys = null;
	/* Column Info */
	private String mmlUsdFlg = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String seaBufRat = null;
	/* Column Info */
	private String etdDyNo = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String brthItvalDys = null;
	/* Column Info */
	private String etdTmHrmnt = null;
	/* Column Info */
	private String n3rdVslClssKnt = null;
	/* Column Info */
	private String etbDyNo = null;
	/* Column Info */
	private String seaBufSpd = null;
	/* Column Info */
	private String totBufRat = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String zd = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String maxSpd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String minMaxSpd = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String pfSkdRmk = null;
	/* Column Info */
	private String crnKnt = null;
	/* Column Info */
	private String slanStndFlg = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String totMaxSpd = null;
	/* Column Info */
	private String bufSpdRat = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pfSpdRat = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String dur = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String etbTmHrmnt = null;
	/* Column Info */
	private String avgSpd = null;
	/* Column Info */
	private String n2ndVslClssKnt = null;
	/* Column Info */
	private String bufSpd = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String clptKnt = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String checkWkTm = null;
	/* Column Info */
	private String craneWkTm = null;
	/* Column Info */
	private String mdmSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfSkdRequestVO() {}

	public PfSkdRequestVO(String ibflag, String pagerows, String vslSlanCd, String pfSvcTpCd, String portCd, String skdDirCd, String clptSeq, String portRotnSeq, String ydCd, String callYdIndSeq, String turnPortFlg, String turnPortIndCd, String etbDyCd, String etbDyNo, String etbTmHrmnt, String etdDyCd, String etdDyNo, String etdTmHrmnt, String lnkDist, String lnkSpd, String tztmHrs, String seaBufHrs, String seaBufSpd, String mnvrInHrs, String mnvrOutHrs, String ibIpcgoQty, String ibOcnCgoQty, String obIpcgoQty, String obOcnCgoQty, String tmlProdQty, String crnKnt, String actWrkHrs, String portBufHrs, String zd, String slanStndFlg, String svcDurDys, String stndSvcSpd, String brthItvalDys, String mmlUsdFlg, String simDt, String simNo, String n1stVslClssCd, String n1stVslClssKnt, String n2ndVslClssCd, String n2ndVslClssKnt, String n3rdVslClssCd, String n3rdVslClssKnt, String clptKnt, String ttlDist, String maxSpd, String avgSpd, String deltFlg, String pfSkdRmk, String totMaxSpd, String totAvgSpd, String bufSpd, String dur, String totBufRat, String seaBufRat, String portBufRat, String pfSpdRat, String bufSpdRat, String minMaxSpd, String vslSvcTpCd, String creDt, String updDt, String rowSeq, String checkWkTm, String craneWkTm, String mdmSkdDirCd) {
		this.ttlDist = ttlDist;
		this.n1stVslClssKnt = n1stVslClssKnt;
		this.lnkSpd = lnkSpd;
		this.stndSvcSpd = stndSvcSpd;
		this.seaBufHrs = seaBufHrs;
		this.actWrkHrs = actWrkHrs;
		this.portBufRat = portBufRat;
		this.simNo = simNo;
		this.portBufHrs = portBufHrs;
		this.totAvgSpd = totAvgSpd;
		this.tztmHrs = tztmHrs;
		this.etdDyCd = etdDyCd;
		this.pagerows = pagerows;
		this.turnPortIndCd = turnPortIndCd;
		this.clptSeq = clptSeq;
		this.svcDurDys = svcDurDys;
		this.mmlUsdFlg = mmlUsdFlg;
		this.ibIpcgoQty = ibIpcgoQty;
		this.obIpcgoQty = obIpcgoQty;
		this.lnkDist = lnkDist;
		this.seaBufRat = seaBufRat;
		this.etdDyNo = etdDyNo;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.brthItvalDys = brthItvalDys;
		this.etdTmHrmnt = etdTmHrmnt;
		this.n3rdVslClssKnt = n3rdVslClssKnt;
		this.etbDyNo = etbDyNo;
		this.seaBufSpd = seaBufSpd;
		this.totBufRat = totBufRat;
		this.mnvrOutHrs = mnvrOutHrs;
		this.etbDyCd = etbDyCd;
		this.deltFlg = deltFlg;
		this.zd = zd;
		this.turnPortFlg = turnPortFlg;
		this.simDt = simDt;
		this.tmlProdQty = tmlProdQty;
		this.vslSlanCd = vslSlanCd;
		this.maxSpd = maxSpd;
		this.ibflag = ibflag;
		this.minMaxSpd = minMaxSpd;
		this.pfSvcTpCd = pfSvcTpCd;
		this.pfSkdRmk = pfSkdRmk;
		this.crnKnt = crnKnt;
		this.slanStndFlg = slanStndFlg;
		this.portRotnSeq = portRotnSeq;
		this.portCd = portCd;
		this.callYdIndSeq = callYdIndSeq;
		this.n3rdVslClssCd = n3rdVslClssCd;
		this.obOcnCgoQty = obOcnCgoQty;
		this.totMaxSpd = totMaxSpd;
		this.bufSpdRat = bufSpdRat;
		this.skdDirCd = skdDirCd;
		this.pfSpdRat = pfSpdRat;
		this.mnvrInHrs = mnvrInHrs;
		this.dur = dur;
		this.ydCd = ydCd;
		this.etbTmHrmnt = etbTmHrmnt;
		this.avgSpd = avgSpd;
		this.n2ndVslClssKnt = n2ndVslClssKnt;
		this.bufSpd = bufSpd;
		this.n2ndVslClssCd = n2ndVslClssCd;
		this.n1stVslClssCd = n1stVslClssCd;
		this.clptKnt = clptKnt;
		this.vslSvcTpCd = vslSvcTpCd;
		this.creDt = creDt;
		this.updDt = updDt;
		this.rowSeq = rowSeq;
		this.checkWkTm = checkWkTm;
		this.craneWkTm = craneWkTm;
		this.mdmSkdDirCd = mdmSkdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("n1st_vsl_clss_knt", getN1stVslClssKnt());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("stnd_svc_spd", getStndSvcSpd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		this.hashColumns.put("port_buf_rat", getPortBufRat());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("tot_avg_spd", getTotAvgSpd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("etd_dy_cd", getEtdDyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("mml_usd_flg", getMmlUsdFlg());
		this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("sea_buf_rat", getSeaBufRat());
		this.hashColumns.put("etd_dy_no", getEtdDyNo());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("brth_itval_dys", getBrthItvalDys());
		this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
		this.hashColumns.put("n3rd_vsl_clss_knt", getN3rdVslClssKnt());
		this.hashColumns.put("etb_dy_no", getEtbDyNo());
		this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
		this.hashColumns.put("tot_buf_rat", getTotBufRat());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("zd", getZd());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("max_spd", getMaxSpd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("min_max_spd", getMinMaxSpd());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("pf_skd_rmk", getPfSkdRmk());
		this.hashColumns.put("crn_knt", getCrnKnt());
		this.hashColumns.put("slan_stnd_flg", getSlanStndFlg());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("n3rd_vsl_clss_cd", getN3rdVslClssCd());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("tot_max_spd", getTotMaxSpd());
		this.hashColumns.put("buf_spd_rat", getBufSpdRat());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pf_spd_rat", getPfSpdRat());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("dur", getDur());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
		this.hashColumns.put("avg_spd", getAvgSpd());
		this.hashColumns.put("n2nd_vsl_clss_knt", getN2ndVslClssKnt());
		this.hashColumns.put("buf_spd", getBufSpd());
		this.hashColumns.put("n2nd_vsl_clss_cd", getN2ndVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_cd", getN1stVslClssCd());
		this.hashColumns.put("clpt_knt", getClptKnt());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("check_wk_tm", getCheckWkTm());
		this.hashColumns.put("crane_wk_tm", getCraneWkTm());
		this.hashColumns.put("mdm_skd_dir_cd", getMdmSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("n1st_vsl_clss_knt", "n1stVslClssKnt");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("stnd_svc_spd", "stndSvcSpd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		this.hashFields.put("port_buf_rat", "portBufRat");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("tot_avg_spd", "totAvgSpd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("etd_dy_cd", "etdDyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("mml_usd_flg", "mmlUsdFlg");
		this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("sea_buf_rat", "seaBufRat");
		this.hashFields.put("etd_dy_no", "etdDyNo");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("brth_itval_dys", "brthItvalDys");
		this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
		this.hashFields.put("n3rd_vsl_clss_knt", "n3rdVslClssKnt");
		this.hashFields.put("etb_dy_no", "etbDyNo");
		this.hashFields.put("sea_buf_spd", "seaBufSpd");
		this.hashFields.put("tot_buf_rat", "totBufRat");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("zd", "zd");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("max_spd", "maxSpd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("min_max_spd", "minMaxSpd");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("pf_skd_rmk", "pfSkdRmk");
		this.hashFields.put("crn_knt", "crnKnt");
		this.hashFields.put("slan_stnd_flg", "slanStndFlg");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("tot_max_spd", "totMaxSpd");
		this.hashFields.put("buf_spd_rat", "bufSpdRat");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pf_spd_rat", "pfSpdRat");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("dur", "dur");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
		this.hashFields.put("avg_spd", "avgSpd");
		this.hashFields.put("n2nd_vsl_clss_knt", "n2ndVslClssKnt");
		this.hashFields.put("buf_spd", "bufSpd");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("clpt_knt", "clptKnt");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("check_wk_tm", "checkWkTm");
		this.hashFields.put("crane_wk_tm", "craneWkTm");
		this.hashFields.put("mdm_skd_dir_cd", "mdmSkdDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlDist
	 */
	public String getTtlDist() {
		return this.ttlDist;
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
	 * @return portBufRat
	 */
	public String getPortBufRat() {
		return this.portBufRat;
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
	 * @return totAvgSpd
	 */
	public String getTotAvgSpd() {
		return this.totAvgSpd;
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
	 * Column Info
	 * @return svcDurDys
	 */
	public String getSvcDurDys() {
		return this.svcDurDys;
	}
	
	/**
	 * Column Info
	 * @return mmlUsdFlg
	 */
	public String getMmlUsdFlg() {
		return this.mmlUsdFlg;
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
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return seaBufRat
	 */
	public String getSeaBufRat() {
		return this.seaBufRat;
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
	 * @return n3rdVslClssKnt
	 */
	public String getN3rdVslClssKnt() {
		return this.n3rdVslClssKnt;
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
	 * @return seaBufSpd
	 */
	public String getSeaBufSpd() {
		return this.seaBufSpd;
	}
	
	/**
	 * Column Info
	 * @return totBufRat
	 */
	public String getTotBufRat() {
		return this.totBufRat;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return maxSpd
	 */
	public String getMaxSpd() {
		return this.maxSpd;
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
	 * @return minMaxSpd
	 */
	public String getMinMaxSpd() {
		return this.minMaxSpd;
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
	 * @return pfSkdRmk
	 */
	public String getPfSkdRmk() {
		return this.pfSkdRmk;
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
	 * @return slanStndFlg
	 */
	public String getSlanStndFlg() {
		return this.slanStndFlg;
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
	 * @return n3rdVslClssCd
	 */
	public String getN3rdVslClssCd() {
		return this.n3rdVslClssCd;
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
	 * @return totMaxSpd
	 */
	public String getTotMaxSpd() {
		return this.totMaxSpd;
	}
	
	/**
	 * Column Info
	 * @return bufSpdRat
	 */
	public String getBufSpdRat() {
		return this.bufSpdRat;
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
	 * @return pfSpdRat
	 */
	public String getPfSpdRat() {
		return this.pfSpdRat;
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
	 * @return dur
	 */
	public String getDur() {
		return this.dur;
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
	 * @return etbTmHrmnt
	 */
	public String getEtbTmHrmnt() {
		return this.etbTmHrmnt;
	}
	
	/**
	 * Column Info
	 * @return avgSpd
	 */
	public String getAvgSpd() {
		return this.avgSpd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssKnt
	 */
	public String getN2ndVslClssKnt() {
		return this.n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @return bufSpd
	 */
	public String getBufSpd() {
		return this.bufSpd;
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
	 * @return n1stVslClssCd
	 */
	public String getN1stVslClssCd() {
		return this.n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getClptKnt() {
		return this.clptKnt;
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
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getRowSeq() {
		return this.rowSeq;
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
	 * @return mdmSkdDirCd
	 */
	public String getMdmSkdDirCd(){
		return this.mdmSkdDirCd;
	}
	

	/**
	 * Column Info
	 * @param ttlDist
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
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
	 * @param portBufRat
	 */
	public void setPortBufRat(String portBufRat) {
		this.portBufRat = portBufRat;
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
	 * @param totAvgSpd
	 */
	public void setTotAvgSpd(String totAvgSpd) {
		this.totAvgSpd = totAvgSpd;
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
	 * Column Info
	 * @param svcDurDys
	 */
	public void setSvcDurDys(String svcDurDys) {
		this.svcDurDys = svcDurDys;
	}
	
	/**
	 * Column Info
	 * @param mmlUsdFlg
	 */
	public void setMmlUsdFlg(String mmlUsdFlg) {
		this.mmlUsdFlg = mmlUsdFlg;
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
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param seaBufRat
	 */
	public void setSeaBufRat(String seaBufRat) {
		this.seaBufRat = seaBufRat;
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
	 * @param n3rdVslClssKnt
	 */
	public void setN3rdVslClssKnt(String n3rdVslClssKnt) {
		this.n3rdVslClssKnt = n3rdVslClssKnt;
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
	 * @param seaBufSpd
	 */
	public void setSeaBufSpd(String seaBufSpd) {
		this.seaBufSpd = seaBufSpd;
	}
	
	/**
	 * Column Info
	 * @param totBufRat
	 */
	public void setTotBufRat(String totBufRat) {
		this.totBufRat = totBufRat;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param maxSpd
	 */
	public void setMaxSpd(String maxSpd) {
		this.maxSpd = maxSpd;
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
	 * @param minMaxSpd
	 */
	public void setMinMaxSpd(String minMaxSpd) {
		this.minMaxSpd = minMaxSpd;
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
	 * @param pfSkdRmk
	 */
	public void setPfSkdRmk(String pfSkdRmk) {
		this.pfSkdRmk = pfSkdRmk;
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
	 * @param slanStndFlg
	 */
	public void setSlanStndFlg(String slanStndFlg) {
		this.slanStndFlg = slanStndFlg;
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
	 * @param n3rdVslClssCd
	 */
	public void setN3rdVslClssCd(String n3rdVslClssCd) {
		this.n3rdVslClssCd = n3rdVslClssCd;
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
	 * @param totMaxSpd
	 */
	public void setTotMaxSpd(String totMaxSpd) {
		this.totMaxSpd = totMaxSpd;
	}
	
	/**
	 * Column Info
	 * @param bufSpdRat
	 */
	public void setBufSpdRat(String bufSpdRat) {
		this.bufSpdRat = bufSpdRat;
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
	 * @param pfSpdRat
	 */
	public void setPfSpdRat(String pfSpdRat) {
		this.pfSpdRat = pfSpdRat;
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
	 * @param dur
	 */
	public void setDur(String dur) {
		this.dur = dur;
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
	 * @param etbTmHrmnt
	 */
	public void setEtbTmHrmnt(String etbTmHrmnt) {
		this.etbTmHrmnt = etbTmHrmnt;
	}
	
	/**
	 * Column Info
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssKnt
	 */
	public void setN2ndVslClssKnt(String n2ndVslClssKnt) {
		this.n2ndVslClssKnt = n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @param bufSpd
	 */
	public void setBufSpd(String bufSpd) {
		this.bufSpd = bufSpd;
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
	 * @param n1stVslClssCd
	 */
	public void setN1stVslClssCd(String n1stVslClssCd) {
		this.n1stVslClssCd = n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setClptKnt(String clptKnt) {
		this.clptKnt = clptKnt;
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
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
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
	 * @param mdmSkdDirCd
	 */
	public void setMdmSkdDirCd(String mdmSkdDirCd){
		this.mdmSkdDirCd = mdmSkdDirCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTtlDist(JSPUtil.getParameter(request, "ttl_dist", ""));
		setN1stVslClssKnt(JSPUtil.getParameter(request, "n1st_vsl_clss_knt", ""));
		setLnkSpd(JSPUtil.getParameter(request, "lnk_spd", ""));
		setStndSvcSpd(JSPUtil.getParameter(request, "stnd_svc_spd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setActWrkHrs(JSPUtil.getParameter(request, "act_wrk_hrs", ""));
		setPortBufRat(JSPUtil.getParameter(request, "port_buf_rat", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
		setTotAvgSpd(JSPUtil.getParameter(request, "tot_avg_spd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setSvcDurDys(JSPUtil.getParameter(request, "svc_dur_dys", ""));
		setMmlUsdFlg(JSPUtil.getParameter(request, "mml_usd_flg", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setSeaBufRat(JSPUtil.getParameter(request, "sea_buf_rat", ""));
		setEtdDyNo(JSPUtil.getParameter(request, "etd_dy_no", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setBrthItvalDys(JSPUtil.getParameter(request, "brth_itval_dys", ""));
		setEtdTmHrmnt(JSPUtil.getParameter(request, "etd_tm_hrmnt", ""));
		setN3rdVslClssKnt(JSPUtil.getParameter(request, "n3rd_vsl_clss_knt", ""));
		setEtbDyNo(JSPUtil.getParameter(request, "etb_dy_no", ""));
		setSeaBufSpd(JSPUtil.getParameter(request, "sea_buf_spd", ""));
		setTotBufRat(JSPUtil.getParameter(request, "tot_buf_rat", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setZd(JSPUtil.getParameter(request, "zd", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setMaxSpd(JSPUtil.getParameter(request, "max_spd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMinMaxSpd(JSPUtil.getParameter(request, "min_max_spd", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
		setPfSkdRmk(JSPUtil.getParameter(request, "pf_skd_rmk", ""));
		setCrnKnt(JSPUtil.getParameter(request, "crn_knt", ""));
		setSlanStndFlg(JSPUtil.getParameter(request, "slan_stnd_flg", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setN3rdVslClssCd(JSPUtil.getParameter(request, "n3rd_vsl_clss_cd", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setTotMaxSpd(JSPUtil.getParameter(request, "tot_max_spd", ""));
		setBufSpdRat(JSPUtil.getParameter(request, "buf_spd_rat", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPfSpdRat(JSPUtil.getParameter(request, "pf_spd_rat", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setDur(JSPUtil.getParameter(request, "dur", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setEtbTmHrmnt(JSPUtil.getParameter(request, "etb_tm_hrmnt", ""));
		setAvgSpd(JSPUtil.getParameter(request, "avg_spd", ""));
		setN2ndVslClssKnt(JSPUtil.getParameter(request, "n2nd_vsl_clss_knt", ""));
		setBufSpd(JSPUtil.getParameter(request, "buf_spd", ""));
		setN2ndVslClssCd(JSPUtil.getParameter(request, "n2nd_vsl_clss_cd", ""));
		setN1stVslClssCd(JSPUtil.getParameter(request, "n1st_vsl_clss_cd", ""));
		setClptKnt(JSPUtil.getParameter(request, "clpt_knt", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRowSeq(JSPUtil.getParameter(request, "row_seq", ""));
		setCheckWkTm(JSPUtil.getParameter(request, "check_wk_tm", ""));
		setCraneWkTm(JSPUtil.getParameter(request, "crane_wk_tm", ""));
		setMdmSkdDirCd(JSPUtil.getParameter(request, "mdm_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PfSkdRequestVO[]
	 */
	public PfSkdRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PfSkdRequestVO[]
	 */
	public PfSkdRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfSkdRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist".trim(), length));
			String[] n1stVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_knt".trim(), length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd".trim(), length));
			String[] stndSvcSpd = (JSPUtil.getParameter(request, prefix	+ "stnd_svc_spd".trim(), length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs".trim(), length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs".trim(), length));
			String[] portBufRat = (JSPUtil.getParameter(request, prefix	+ "port_buf_rat".trim(), length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no".trim(), length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs".trim(), length));
			String[] totAvgSpd = (JSPUtil.getParameter(request, prefix	+ "tot_avg_spd".trim(), length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs".trim(), length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd".trim(), length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq".trim(), length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix	+ "svc_dur_dys".trim(), length));
			String[] mmlUsdFlg = (JSPUtil.getParameter(request, prefix	+ "mml_usd_flg".trim(), length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty".trim(), length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty".trim(), length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist".trim(), length));
			String[] seaBufRat = (JSPUtil.getParameter(request, prefix	+ "sea_buf_rat".trim(), length));
			String[] etdDyNo = (JSPUtil.getParameter(request, prefix	+ "etd_dy_no".trim(), length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty".trim(), length));
			String[] brthItvalDys = (JSPUtil.getParameter(request, prefix	+ "brth_itval_dys".trim(), length));
			String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_tm_hrmnt".trim(), length));
			String[] n3rdVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_knt".trim(), length));
			String[] etbDyNo = (JSPUtil.getParameter(request, prefix	+ "etb_dy_no".trim(), length));
			String[] seaBufSpd = (JSPUtil.getParameter(request, prefix	+ "sea_buf_spd".trim(), length));
			String[] totBufRat = (JSPUtil.getParameter(request, prefix	+ "tot_buf_rat".trim(), length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs".trim(), length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] zd = (JSPUtil.getParameter(request, prefix	+ "zd".trim(), length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg".trim(), length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt".trim(), length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] maxSpd = (JSPUtil.getParameter(request, prefix	+ "max_spd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] minMaxSpd = (JSPUtil.getParameter(request, prefix	+ "min_max_spd".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			String[] pfSkdRmk = (JSPUtil.getParameter(request, prefix	+ "pf_skd_rmk".trim(), length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt".trim(), length));
			String[] slanStndFlg = (JSPUtil.getParameter(request, prefix	+ "slan_stnd_flg".trim(), length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq".trim(), length));
			String[] n3rdVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd".trim(), length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty".trim(), length));
			String[] totMaxSpd = (JSPUtil.getParameter(request, prefix	+ "tot_max_spd".trim(), length));
			String[] bufSpdRat = (JSPUtil.getParameter(request, prefix	+ "buf_spd_rat".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pfSpdRat = (JSPUtil.getParameter(request, prefix	+ "pf_spd_rat".trim(), length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs".trim(), length));
			String[] dur = (JSPUtil.getParameter(request, prefix	+ "dur".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etb_tm_hrmnt".trim(), length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd".trim(), length));
			String[] n2ndVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_knt".trim(), length));
			String[] bufSpd = (JSPUtil.getParameter(request, prefix	+ "buf_spd".trim(), length));
			String[] n2ndVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd".trim(), length));
			String[] n1stVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd".trim(), length));
			String[] clptKnt = (JSPUtil.getParameter(request, prefix	+ "clpt_knt".trim(), length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq".trim(), length));
			String[] checkWkTm = (JSPUtil.getParameter(request, prefix	+ "check_wk_tm".trim(), length));
			String[] craneWkTm = (JSPUtil.getParameter(request, prefix	+ "crane_wk_tm".trim(), length));
			String[] mdmSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "mdm_skd_dir_cd".trim(), length));
			
			
			for (int i = 0; i < length; i++) {
				model = new PfSkdRequestVO();
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (n1stVslClssKnt[i] != null)
					model.setN1stVslClssKnt(n1stVslClssKnt[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (stndSvcSpd[i] != null)
					model.setStndSvcSpd(stndSvcSpd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				if (portBufRat[i] != null)
					model.setPortBufRat(portBufRat[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (totAvgSpd[i] != null)
					model.setTotAvgSpd(totAvgSpd[i]);
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
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (mmlUsdFlg[i] != null)
					model.setMmlUsdFlg(mmlUsdFlg[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (seaBufRat[i] != null)
					model.setSeaBufRat(seaBufRat[i]);
				if (etdDyNo[i] != null)
					model.setEtdDyNo(etdDyNo[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (brthItvalDys[i] != null)
					model.setBrthItvalDys(brthItvalDys[i]);
				if (etdTmHrmnt[i] != null)
					model.setEtdTmHrmnt(etdTmHrmnt[i]);
				if (n3rdVslClssKnt[i] != null)
					model.setN3rdVslClssKnt(n3rdVslClssKnt[i]);
				if (etbDyNo[i] != null)
					model.setEtbDyNo(etbDyNo[i]);
				if (seaBufSpd[i] != null)
					model.setSeaBufSpd(seaBufSpd[i]);
				if (totBufRat[i] != null)
					model.setTotBufRat(totBufRat[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (zd[i] != null)
					model.setZd(zd[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (maxSpd[i] != null)
					model.setMaxSpd(maxSpd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (minMaxSpd[i] != null)
					model.setMinMaxSpd(minMaxSpd[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (pfSkdRmk[i] != null)
					model.setPfSkdRmk(pfSkdRmk[i]);
				if (crnKnt[i] != null)
					model.setCrnKnt(crnKnt[i]);
				if (slanStndFlg[i] != null)
					model.setSlanStndFlg(slanStndFlg[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (n3rdVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (totMaxSpd[i] != null)
					model.setTotMaxSpd(totMaxSpd[i]);
				if (bufSpdRat[i] != null)
					model.setBufSpdRat(bufSpdRat[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pfSpdRat[i] != null)
					model.setPfSpdRat(pfSpdRat[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (dur[i] != null)
					model.setDur(dur[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (etbTmHrmnt[i] != null)
					model.setEtbTmHrmnt(etbTmHrmnt[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				if (n2ndVslClssKnt[i] != null)
					model.setN2ndVslClssKnt(n2ndVslClssKnt[i]);
				if (bufSpd[i] != null)
					model.setBufSpd(bufSpd[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (clptKnt[i] != null)
					model.setClptKnt(clptKnt[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (checkWkTm[i] != null)
					model.setCheckWkTm(checkWkTm[i]);
				if (craneWkTm[i] != null)
					model.setCraneWkTm(craneWkTm[i]);
				if (mdmSkdDirCd[i] != null)
					model.setMdmSkdDirCd(mdmSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPfSkdRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PfSkdRequestVO[]
	 */
	public PfSkdRequestVO[] getPfSkdRequestVOs(){
		PfSkdRequestVO[] vos = (PfSkdRequestVO[])models.toArray(new PfSkdRequestVO[models.size()]);
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
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssKnt = this.n1stVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndSvcSpd = this.stndSvcSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufRat = this.portBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAvgSpd = this.totAvgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyCd = this.etdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mmlUsdFlg = this.mmlUsdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty = this.ibIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufRat = this.seaBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyNo = this.etdDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthItvalDys = this.brthItvalDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTmHrmnt = this.etdTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssKnt = this.n3rdVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyNo = this.etbDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufSpd = this.seaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBufRat = this.totBufRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zd = this.zd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpd = this.maxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minMaxSpd = this.minMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdRmk = this.pfSkdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnKnt = this.crnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanStndFlg = this.slanStndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd = this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMaxSpd = this.totMaxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bufSpdRat = this.bufSpdRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSpdRat = this.pfSpdRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dur = this.dur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTmHrmnt = this.etbTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssKnt = this.n2ndVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bufSpd = this.bufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd = this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssCd = this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptKnt = this.clptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkWkTm = this.checkWkTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.craneWkTm = this.craneWkTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmSkdDirCd = this.mdmSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
