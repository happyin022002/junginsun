/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeSkdVO.java
*@FileTitle : LongRangeSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.24 유혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 유혁
 * @since J2EE 1.5
 */

public class LongRangeSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LongRangeSkdVO> models = new ArrayList<LongRangeSkdVO>();
	
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String crnKnt = null;
	/* Column Info */
	private String etbDyCd = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
//	private String etdTmHrmnt = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String seaBufSpd = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String initEtbDate = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String initEtdDate = null;
	/* Column Info */
	private String turnPortFlg = null;
	/* Column Info */
	private String actWrkHrs = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String etdDyNo = null;
	/* Column Info */
	private String etdDyCd = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Column Info */
//	private String etbTmHrmnt = null;
	/* Column Info */
	private String initEtdDay = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String etbDyNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String initEtbDay = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String skdCngStsCd = null;
	/* Column Info */
	private String sheetObjNo = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	
	/* Column Info */
	private boolean skip = false;

	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LongRangeSkdVO() {}

	public LongRangeSkdVO(String ibflag, String pagerows, String portCd, String skdDirCd, String clptSeq, String portRotnSeq, String turnPortFlg, String turnPortIndCd, String etbDyCd, String etbDyNo, String etbTmHrmnt, String etdDyCd, String etdDyNo, String etdTmHrmnt, String lnkDist, String lnkSpd, String tztmHrs, String seaBufHrs, String seaBufSpd, String mnvrInHrs, String mnvrOutHrs, String ibIpcgoQty, String ibOcnCgoQty, String obIpcgoQty, String obOcnCgoQty, String tmlProdQty, String crnKnt, String actWrkHrs, String portBufHrs, String vslCd, String voyNo, String initEtbDate, String initEtdDate, String initEtdDay, String initEtbDay, String skdCngStsCd, String sheetObjNo, String pfSvcTpCd) {
		this.voyNo = voyNo;
		this.tmlProdQty = tmlProdQty;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.crnKnt = crnKnt;
		this.etbDyCd = etbDyCd;
		this.turnPortIndCd = turnPortIndCd;
//		this.etdTmHrmnt = etdTmHrmnt;
		this.ibIpcgoQty = ibIpcgoQty;
		this.seaBufSpd = seaBufSpd;
		this.mnvrOutHrs = mnvrOutHrs;
		this.portRotnSeq = portRotnSeq;
		this.obOcnCgoQty = obOcnCgoQty;
		this.vslCd = vslCd;
		this.initEtbDate = initEtbDate;
		this.ibflag = ibflag;
		this.obIpcgoQty = obIpcgoQty;
		this.clptSeq = clptSeq;
		this.skdDirCd = skdDirCd;
		this.lnkSpd = lnkSpd;
		this.initEtdDate = initEtdDate;
		this.turnPortFlg = turnPortFlg;
		this.actWrkHrs = actWrkHrs;
		this.lnkDist = lnkDist;
		this.tztmHrs = tztmHrs;
		this.etdDyNo = etdDyNo;
		this.etdDyCd = etdDyCd;
		this.portBufHrs = portBufHrs;
//		this.etbTmHrmnt = etbTmHrmnt;
		this.initEtdDay = initEtdDay;
		this.mnvrInHrs = mnvrInHrs;
		this.etbDyNo = etbDyNo;
		this.portCd = portCd;
		this.initEtbDay = initEtbDay;
		this.pagerows = pagerows;
		this.seaBufHrs = seaBufHrs;
		this.skdCngStsCd = skdCngStsCd;
		this.sheetObjNo = sheetObjNo;
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("crn_knt", getCrnKnt());
		this.hashColumns.put("etb_dy_cd", getEtbDyCd());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
//		this.hashColumns.put("etd_tm_hrmnt", getEtdTmHrmnt());
		this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
		this.hashColumns.put("sea_buf_spd", getSeaBufSpd());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("init_etb_date", getInitEtbDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("init_etd_date", getInitEtdDate());
		this.hashColumns.put("turn_port_flg", getTurnPortFlg());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("etd_dy_no", getEtdDyNo());
		this.hashColumns.put("etd_dy_cd", getEtdDyCd());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
//		this.hashColumns.put("etb_tm_hrmnt", getEtbTmHrmnt());
		this.hashColumns.put("init_etd_day", getInitEtdDay());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("etb_dy_no", getEtbDyNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("init_etb_day", getInitEtbDay());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("skd_cng_sts_cd", getSkdCngStsCd());
		this.hashColumns.put("sheet_obj_no", getSheetObjNo());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("crn_knt", "crnKnt");
		this.hashFields.put("etb_dy_cd", "etbDyCd");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
//		this.hashFields.put("etd_tm_hrmnt", "etdTmHrmnt");
		this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
		this.hashFields.put("sea_buf_spd", "seaBufSpd");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("init_etb_date", "initEtbDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("init_etd_date", "initEtdDate");
		this.hashFields.put("turn_port_flg", "turnPortFlg");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("etd_dy_no", "etdDyNo");
		this.hashFields.put("etd_dy_cd", "etdDyCd");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
//		this.hashFields.put("etb_tm_hrmnt", "etbTmHrmnt");
		this.hashFields.put("init_etd_day", "initEtdDay");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("etb_dy_no", "etbDyNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("init_etb_day", "initEtbDay");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("skd_cng_sts_cd", "skdCngStsCd");
		this.hashFields.put("sheet_obj_no", "sheetObjNo");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		return this.hashFields;
	}
	
	public String getVoyNo() {
		return this.voyNo;
	}
	public String getTmlProdQty() {
		return this.tmlProdQty;
	}
	public String getIbOcnCgoQty() {
		return this.ibOcnCgoQty;
	}
	public String getCrnKnt() {
		return this.crnKnt;
	}
	public String getEtbDyCd() {
		return this.etbDyCd;
	}
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
//	public String getEtdTmHrmnt() {
//		return this.etdTmHrmnt;
//	}
	public String getIbIpcgoQty() {
		return this.ibIpcgoQty;
	}
	public String getSeaBufSpd() {
		return this.seaBufSpd;
	}
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
	}
	public String getPortRotnSeq() {
		return this.portRotnSeq;
	}
	public String getObOcnCgoQty() {
		return this.obOcnCgoQty;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getInitEtbDate() {
		
		if(skip){
			return " SKIP";
		}
		
		if(initEtbDate==null || initEtbDate.length()==0){
			return "";
		}
		
		if(initEtbDate.length()<8){
			return initEtbDate;
		}
		
		SimpleDateFormat sf = null;
		Calendar cal = Calendar.getInstance();
		
		if(initEtbDate.length()==8){
			cal.set(
					Integer.parseInt(initEtbDate.substring(0,4)),
					Integer.parseInt(initEtbDate.substring(4,6))-1,
					Integer.parseInt(initEtbDate.substring(6,8))
			);
			sf = new SimpleDateFormat("MM/ddyyyy");	
		}else if(initEtbDate.length()==12){
			cal.set(
					Integer.parseInt(initEtbDate.substring(0,4)),
					Integer.parseInt(initEtbDate.substring(4,6))-1,
					Integer.parseInt(initEtbDate.substring(6,8)),
					Integer.parseInt(initEtbDate.substring(8,10)),
					Integer.parseInt(initEtbDate.substring(10,12))
			);
			sf = new SimpleDateFormat("MM/ddyyyyHHmm");
		}else{
			return initEtbDate;
		}
		
		return sf.format(cal.getTime());
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getObIpcgoQty() {
		return this.obIpcgoQty;
	}
	public String getClptSeq() {
		return this.clptSeq;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getLnkSpd() {
		return this.lnkSpd;
	}
	public String getInitEtdDate() {
		
		if(skip){
			return " SKIP";
		}
		
		if(initEtdDate==null || initEtdDate.length()==0){
			return "";
		}
		
		if(initEtdDate.length()<8){
			return initEtdDate;
		}
		
		SimpleDateFormat sf = null;
		Calendar cal = Calendar.getInstance();
		
		if(initEtdDate.length()==8){
			cal.set(
					Integer.parseInt(initEtdDate.substring(0,4)),
					Integer.parseInt(initEtdDate.substring(4,6))-1,
					Integer.parseInt(initEtdDate.substring(6,8))
			);
			sf = new SimpleDateFormat("MM/ddyyyy");	
		}else if(initEtdDate.length()==12){
			cal.set(
					Integer.parseInt(initEtdDate.substring(0,4)),
					Integer.parseInt(initEtdDate.substring(4,6))-1,
					Integer.parseInt(initEtdDate.substring(6,8)),
					Integer.parseInt(initEtdDate.substring(8,10)),
					Integer.parseInt(initEtdDate.substring(10,12))
			);
			sf = new SimpleDateFormat("MM/ddyyyyHHmm");
		}else{
			return initEtdDate;
		}
		
		return sf.format(cal.getTime());
	}
	public String getTurnPortFlg() {
		return this.turnPortFlg;
	}
	public String getActWrkHrs() {
		return this.actWrkHrs;
	}
	public String getLnkDist() {
		return this.lnkDist;
	}
	public String getTztmHrs() {
		return this.tztmHrs;
	}
	public String getEtdDyNo() {
		return this.etdDyNo;
	}
	public String getEtdDyCd() {
		return this.etdDyCd;
	}
	public String getPortBufHrs() {
		return this.portBufHrs;
	}
//	public String getEtbTmHrmnt() {
//		return this.etbTmHrmnt;
//	}
	public String getInitEtdDay() {
		return this.initEtdDay;
	}
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	public String getEtbDyNo() {
		return this.etbDyNo;
	}
	public String getPortCd() {
		return this.portCd;
	}
	public String getInitEtbDay() {
		return this.initEtbDay;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getSeaBufHrs() {
		return this.seaBufHrs;
	}
	public String getSkdCngStsCd() {
		return this.skdCngStsCd;
	}
	public String getSheetObjNo() {
		return this.sheetObjNo;
	}
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}

	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
		//this.voyNo=true;
	}
	public void setTmlProdQty(String tmlProdQty) {
		this.tmlProdQty = tmlProdQty;
		//this.tmlProdQty=true;
	}
	public void setIbOcnCgoQty(String ibOcnCgoQty) {
		this.ibOcnCgoQty = ibOcnCgoQty;
		//this.ibOcnCgoQty=true;
	}
	public void setCrnKnt(String crnKnt) {
		this.crnKnt = crnKnt;
		//this.crnKnt=true;
	}
	public void setEtbDyCd(String etbDyCd) {
		this.etbDyCd = etbDyCd;
		//this.etbDyCd=true;
	}
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
		//this.turnPortIndCd=true;
	}
//	public void setEtdTmHrmnt(String etdTmHrmnt) {
//		this.etdTmHrmnt = etdTmHrmnt;
//		//this.etdTmHrmnt=true;
//	}
	public void setIbIpcgoQty(String ibIpcgoQty) {
		this.ibIpcgoQty = ibIpcgoQty;
		//this.ibIpcgoQty=true;
	}
	public void setSeaBufSpd(String seaBufSpd) {
		this.seaBufSpd = seaBufSpd;
		//this.seaBufSpd=true;
	}
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
		//this.mnvrOutHrs=true;
	}
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
		//this.portRotnSeq=true;
	}
	public void setObOcnCgoQty(String obOcnCgoQty) {
		this.obOcnCgoQty = obOcnCgoQty;
		//this.obOcnCgoQty=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setInitEtbDate(String initEtbDate) {
		this.initEtbDate = initEtbDate;
		//this.initEtbDate=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setObIpcgoQty(String obIpcgoQty) {
		this.obIpcgoQty = obIpcgoQty;
		//this.obIpcgoQty=true;
	}
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
		//this.clptSeq=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setLnkSpd(String lnkSpd) {
		this.lnkSpd = lnkSpd;
		//this.lnkSpd=true;
	}
	public void setInitEtdDate(String initEtdDate) {
		this.initEtdDate = initEtdDate;
		//this.initEtdDate=true;
	}
	public void setTurnPortFlg(String turnPortFlg) {
		this.turnPortFlg = turnPortFlg;
		//this.turnPortFlg=true;
	}
	public void setActWrkHrs(String actWrkHrs) {
		this.actWrkHrs = actWrkHrs;
		//this.actWrkHrs=true;
	}
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
		//this.lnkDist=true;
	}
	public void setTztmHrs(String tztmHrs) {
		this.tztmHrs = tztmHrs;
		//this.tztmHrs=true;
	}
	public void setEtdDyNo(String etdDyNo) {
		this.etdDyNo = etdDyNo;
		//this.etdDyNo=true;
	}
	public void setEtdDyCd(String etdDyCd) {
		this.etdDyCd = etdDyCd;
		//this.etdDyCd=true;
	}
	public void setPortBufHrs(String portBufHrs) {
		this.portBufHrs = portBufHrs;
		//this.portBufHrs=true;
	}
//	public void setEtbTmHrmnt(String etbTmHrmnt) {
//		this.etbTmHrmnt = etbTmHrmnt;
//		//this.etbTmHrmnt=true;
//	}
	public void setInitEtdDay(String initEtdDay) {
		this.initEtdDay = initEtdDay;
		//this.initEtdDay=true;
	}
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
		//this.mnvrInHrs=true;
	}
	public void setEtbDyNo(String etbDyNo) {
		this.etbDyNo = etbDyNo;
		//this.etbDyNo=true;
	}
	public void setPortCd(String portCd) {
		this.portCd = portCd;
		//this.portCd=true;
	}
	public void setInitEtbDay(String initEtbDay) {
		this.initEtbDay = initEtbDay;
		//this.initEtbDay=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
		//this.seaBufHrs=true;
	}
	public void setSkdCngStsCd(String skdCngStsCd){
		this.skdCngStsCd = skdCngStsCd;
	}
	public void setSheetObjNo(String sheetObjNo){
		this.sheetObjNo = sheetObjNo;
	}
	public void setPfSvcTpCd(String pfSvcTpCd){
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	public void fromRequest(HttpServletRequest request) {
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setCrnKnt(JSPUtil.getParameter(request, "crn_knt", ""));
		setEtbDyCd(JSPUtil.getParameter(request, "etb_dy_cd", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
//		setEtdTmHrmnt(JSPUtil.getParameter(request, "etd_tm_hrmnt", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setSeaBufSpd(JSPUtil.getParameter(request, "sea_buf_spd", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, "mnvr_out_hrs", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setInitEtbDate(JSPUtil.getParameter(request, "init_etb_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setLnkSpd(JSPUtil.getParameter(request, "lnk_spd", ""));
		setInitEtdDate(JSPUtil.getParameter(request, "init_etd_date", ""));
		setTurnPortFlg(JSPUtil.getParameter(request, "turn_port_flg", ""));
		setActWrkHrs(JSPUtil.getParameter(request, "act_wrk_hrs", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setEtdDyNo(JSPUtil.getParameter(request, "etd_dy_no", ""));
		setEtdDyCd(JSPUtil.getParameter(request, "etd_dy_cd", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
//		setEtbTmHrmnt(JSPUtil.getParameter(request, "etb_tm_hrmnt", ""));
		setInitEtdDay(JSPUtil.getParameter(request, "init_etd_day", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, "mnvr_in_hrs", ""));
		setEtbDyNo(JSPUtil.getParameter(request, "etb_dy_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setInitEtbDay(JSPUtil.getParameter(request, "init_etb_day", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setSkdCngStsCd(JSPUtil.getParameter(request, "skd_cng_sts_cd", ""));
		setSheetObjNo(JSPUtil.getParameter(request, "sheet_obj_no", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, "pf_svc_tp_cd", ""));
	}

	public LongRangeSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public LongRangeSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LongRangeSkdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no".trim(), length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty".trim(), length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty".trim(), length));
			String[] crnKnt = (JSPUtil.getParameter(request, prefix	+ "crn_knt".trim(), length));
			String[] etbDyCd = (JSPUtil.getParameter(request, prefix	+ "etb_dy_cd".trim(), length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd".trim(), length));
//			String[] etdTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etd_tm_hrmnt".trim(), length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty".trim(), length));
			String[] seaBufSpd = (JSPUtil.getParameter(request, prefix	+ "sea_buf_spd".trim(), length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs".trim(), length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq".trim(), length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] initEtbDate = (JSPUtil.getParameter(request, prefix	+ "init_etb_date".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty".trim(), length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd".trim(), length));
			String[] initEtdDate = (JSPUtil.getParameter(request, prefix	+ "init_etd_date".trim(), length));
			String[] turnPortFlg = (JSPUtil.getParameter(request, prefix	+ "turn_port_flg".trim(), length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs".trim(), length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist".trim(), length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs".trim(), length));
			String[] etdDyNo = (JSPUtil.getParameter(request, prefix	+ "etd_dy_no".trim(), length));
			String[] etdDyCd = (JSPUtil.getParameter(request, prefix	+ "etd_dy_cd".trim(), length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs".trim(), length));
//			String[] etbTmHrmnt = (JSPUtil.getParameter(request, prefix	+ "etb_tm_hrmnt".trim(), length));
			String[] initEtdDay = (JSPUtil.getParameter(request, prefix	+ "init_etd_day".trim(), length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs".trim(), length));
			String[] etbDyNo = (JSPUtil.getParameter(request, prefix	+ "etb_dy_no".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] initEtbDay = (JSPUtil.getParameter(request, prefix	+ "init_etb_day".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs".trim(), length));
			String[] skdCngStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_sts_cd".trim(), length));
			String[] sheetObjNo = (JSPUtil.getParameter(request, prefix	+ "sheet_obj_no".trim(), length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new LongRangeSkdVO();
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (crnKnt[i] != null)
					model.setCrnKnt(crnKnt[i]);
				if (etbDyCd[i] != null)
					model.setEtbDyCd(etbDyCd[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
//				if (etdTmHrmnt[i] != null)
//					model.setEtdTmHrmnt(etdTmHrmnt[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (seaBufSpd[i] != null)
					model.setSeaBufSpd(seaBufSpd[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (initEtbDate[i] != null)
					model.setInitEtbDate(initEtbDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (initEtdDate[i] != null)
					model.setInitEtdDate(initEtdDate[i]);
				if (turnPortFlg[i] != null)
					model.setTurnPortFlg(turnPortFlg[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (etdDyNo[i] != null)
					model.setEtdDyNo(etdDyNo[i]);
				if (etdDyCd[i] != null)
					model.setEtdDyCd(etdDyCd[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
//				if (etbTmHrmnt[i] != null)
//					model.setEtbTmHrmnt(etbTmHrmnt[i]);
				if (initEtdDay[i] != null)
					model.setInitEtdDay(initEtdDay[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (etbDyNo[i] != null)
					model.setEtbDyNo(etbDyNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (initEtbDay[i] != null)
					model.setInitEtbDay(initEtbDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (skdCngStsCd[i] != null)
					model.setSeaBufHrs(skdCngStsCd[i]);
				if (sheetObjNo[i] != null)
					model.setSheetObjNo(sheetObjNo[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getLongRangeSkdVOs();
	}

	public LongRangeSkdVO[] getLongRangeSkdVOs(){
		LongRangeSkdVO[] vos = (LongRangeSkdVO[])models.toArray(new LongRangeSkdVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnKnt = this.crnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyCd = this.etbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.etdTmHrmnt = this.etdTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty = this.ibIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufSpd = this.seaBufSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDate = this.initEtbDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDate = this.initEtdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortFlg = this.turnPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyNo = this.etdDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDyCd = this.etdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.etbTmHrmnt = this.etbTmHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtdDay = this.initEtdDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDyNo = this.etbDyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initEtbDay = this.initEtbDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngStsCd = this.skdCngStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetObjNo = this.sheetObjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	public boolean compareEtbDay(){
		if(etbDyCd==null){
			etbDyCd = null;
		}
		if(etbDyCd.equals(initEtbDay)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean compareEtdDay(){
		if(etdDyCd.equals(initEtdDay)){
			return true;
		}else{
			return false;
		}
	}
}
