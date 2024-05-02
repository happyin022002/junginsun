/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOceanLinkVO.java
*@FileTitle : SearchOceanLinkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.09.14 김귀진 
* 1.0 Creation
=========================================================*/
/*
 * 2010.10.22 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청(source, lnk_rmk 추가)
 */

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOceanLinkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOceanLinkVO> models = new ArrayList<SearchOceanLinkVO>();
	
	/* Column Info */
	private String fmPortEtdDyCd = null;
	/* Column Info */
	private String fmtTztmHrs = null;
	/* Column Info */
	private String delOp = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String toPortEtbDyCd = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String tsIndCd = null;
	/* Column Info */
	private String tztmHrs = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String rnllws = null;
	/* Column Info */
	private String updIndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String ocnLnkMnlFlg = null;
	/* Column Info */
	private String toPortEtdDyCd = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ocnRoutRmk = null;
	/* Column Info */
	private String fmPortEtbDyCd = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String lnkRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String backEndJobKey = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOceanLinkVO() {}

	public SearchOceanLinkVO(String ibflag, String pagerows, String vslSlanCd, String skdDirCd, String fmPortCd, String fmPortEtbDyCd, String fmPortEtdDyCd, String toPortCd, String toPortEtbDyCd, String toPortEtdDyCd, String tztmHrs, String ocnLnkMnlFlg, String fmtTztmHrs, String routSeq, String tsIndCd, String ocnRoutRmk, String updIndCd, String rnllws, String status, String delOp, String vslLaneCd, String creUsrId, String updUsrId, String creOfcCd, String source, String lnkRmk, String deltFlg, String backEndJobKey) {
		this.fmPortEtdDyCd = fmPortEtdDyCd;
		this.fmtTztmHrs = fmtTztmHrs;
		this.delOp = delOp;
		this.status = status;
		this.toPortEtbDyCd = toPortEtbDyCd;
		this.fmPortCd = fmPortCd;
		this.vslSlanCd = vslSlanCd;
		this.tsIndCd = tsIndCd;
		this.tztmHrs = tztmHrs;
		this.skdDirCd = skdDirCd;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
		this.vslLaneCd = vslLaneCd;
		this.rnllws = rnllws;
		this.updIndCd = updIndCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.ocnLnkMnlFlg = ocnLnkMnlFlg;
		this.toPortEtdDyCd = toPortEtdDyCd;
		this.toPortCd = toPortCd;
		this.updUsrId = updUsrId;
		this.ocnRoutRmk = ocnRoutRmk;
		this.fmPortEtbDyCd = fmPortEtbDyCd;
		this.source = source;
		this.lnkRmk = lnkRmk;
		this.deltFlg = deltFlg;
		this.backEndJobKey = backEndJobKey;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_port_etd_dy_cd", getFmPortEtdDyCd());
		this.hashColumns.put("fmt_tztm_hrs", getFmtTztmHrs());
		this.hashColumns.put("del_op", getDelOp());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("to_port_etb_dy_cd", getToPortEtbDyCd());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("ts_ind_cd", getTsIndCd());
		this.hashColumns.put("tztm_hrs", getTztmHrs());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("rnllws", getRnllws());
		this.hashColumns.put("upd_ind_cd", getUpdIndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("ocn_lnk_mnl_flg", getOcnLnkMnlFlg());
		this.hashColumns.put("to_port_etd_dy_cd", getToPortEtdDyCd());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ocn_rout_rmk", getOcnRoutRmk());
		this.hashColumns.put("fm_port_etb_dy_cd", getFmPortEtbDyCd());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("lnk_rmk", getLnkRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("back_end_job_key", getBackEndJobKey());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_port_etd_dy_cd", "fmPortEtdDyCd");
		this.hashFields.put("fmt_tztm_hrs", "fmtTztmHrs");
		this.hashFields.put("del_op", "delOp");
		this.hashFields.put("status", "status");
		this.hashFields.put("to_port_etb_dy_cd", "toPortEtbDyCd");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("ts_ind_cd", "tsIndCd");
		this.hashFields.put("tztm_hrs", "tztmHrs");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("rnllws", "rnllws");
		this.hashFields.put("upd_ind_cd", "updIndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("ocn_lnk_mnl_flg", "ocnLnkMnlFlg");
		this.hashFields.put("to_port_etd_dy_cd", "toPortEtdDyCd");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ocn_rout_rmk", "ocnRoutRmk");
		this.hashFields.put("fm_port_etb_dy_cd", "fmPortEtbDyCd");
		this.hashFields.put("source", "source");
		this.hashFields.put("lnk_rmk", "lnkRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("back_end_job_key", "backEndJobKey");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmPortEtdDyCd
	 */
	public String getFmPortEtdDyCd() {
		return this.fmPortEtdDyCd;
	}
	
	/**
	 * Column Info
	 * @return fmtTztmHrs
	 */
	public String getFmtTztmHrs() {
		return this.fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return delOp
	 */
	public String getDelOp() {
		return this.delOp;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return toPortEtbDyCd
	 */
	public String getToPortEtbDyCd() {
		return this.toPortEtbDyCd;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
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
	 * @return tsIndCd
	 */
	public String getTsIndCd() {
		return this.tsIndCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return rnllws
	 */
	public String getRnllws() {
		return this.rnllws;
	}
	
	/**
	 * Column Info
	 * @return updIndCd
	 */
	public String getUpdIndCd() {
		return this.updIndCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ocnLnkMnlFlg
	 */
	public String getOcnLnkMnlFlg() {
		return this.ocnLnkMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return toPortEtdDyCd
	 */
	public String getToPortEtdDyCd() {
		return this.toPortEtdDyCd;
	}
	
	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return this.toPortCd;
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
	 * @return ocnRoutRmk
	 */
	public String getOcnRoutRmk() {
		return this.ocnRoutRmk;
	}
	
	/**
	 * Column Info
	 * @return fmPortEtbDyCd
	 */
	public String getFmPortEtbDyCd() {
		return this.fmPortEtbDyCd;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return lnkRmk
	 */
	public String getLnkRmk() {
		return this.lnkRmk;
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
	 * @return deltFlg
	 */
	public String getBackEndJobKey() {
		return this.backEndJobKey;
	}	

	/**
	 * Column Info
	 * @param fmPortEtdDyCd
	 */
	public void setFmPortEtdDyCd(String fmPortEtdDyCd) {
		this.fmPortEtdDyCd = fmPortEtdDyCd;
	}
	
	/**
	 * Column Info
	 * @param fmtTztmHrs
	 */
	public void setFmtTztmHrs(String fmtTztmHrs) {
		this.fmtTztmHrs = fmtTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param delOp
	 */
	public void setDelOp(String delOp) {
		this.delOp = delOp;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param toPortEtbDyCd
	 */
	public void setToPortEtbDyCd(String toPortEtbDyCd) {
		this.toPortEtbDyCd = toPortEtbDyCd;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
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
	 * @param tsIndCd
	 */
	public void setTsIndCd(String tsIndCd) {
		this.tsIndCd = tsIndCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param rnllws
	 */
	public void setRnllws(String rnllws) {
		this.rnllws = rnllws;
	}
	
	/**
	 * Column Info
	 * @param updIndCd
	 */
	public void setUpdIndCd(String updIndCd) {
		this.updIndCd = updIndCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ocnLnkMnlFlg
	 */
	public void setOcnLnkMnlFlg(String ocnLnkMnlFlg) {
		this.ocnLnkMnlFlg = ocnLnkMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param toPortEtdDyCd
	 */
	public void setToPortEtdDyCd(String toPortEtdDyCd) {
		this.toPortEtdDyCd = toPortEtdDyCd;
	}
	
	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
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
	 * @param ocnRoutRmk
	 */
	public void setOcnRoutRmk(String ocnRoutRmk) {
		this.ocnRoutRmk = ocnRoutRmk;
	}
	
	/**
	 * Column Info
	 * @param fmPortEtbDyCd
	 */
	public void setFmPortEtbDyCd(String fmPortEtbDyCd) {
		this.fmPortEtbDyCd = fmPortEtbDyCd;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param lnkRmk
	 */
	public void setLnkRmk(String lnkRmk) {
		this.lnkRmk = lnkRmk;
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
	 * @param deltFlg
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmPortEtdDyCd(JSPUtil.getParameter(request, "fm_port_etd_dy_cd", ""));
		setFmtTztmHrs(JSPUtil.getParameter(request, "fmt_tztm_hrs", ""));
		setDelOp(JSPUtil.getParameter(request, "del_op", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setToPortEtbDyCd(JSPUtil.getParameter(request, "to_port_etb_dy_cd", ""));
		setFmPortCd(JSPUtil.getParameter(request, "fm_port_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setTsIndCd(JSPUtil.getParameter(request, "ts_ind_cd", ""));
		setTztmHrs(JSPUtil.getParameter(request, "tztm_hrs", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setRnllws(JSPUtil.getParameter(request, "rnllws", ""));
		setUpdIndCd(JSPUtil.getParameter(request, "upd_ind_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setOcnLnkMnlFlg(JSPUtil.getParameter(request, "ocn_lnk_mnl_flg", ""));
		setToPortEtdDyCd(JSPUtil.getParameter(request, "to_port_etd_dy_cd", ""));
		setToPortCd(JSPUtil.getParameter(request, "to_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOcnRoutRmk(JSPUtil.getParameter(request, "ocn_rout_rmk", ""));
		setFmPortEtbDyCd(JSPUtil.getParameter(request, "fm_port_etb_dy_cd", ""));
		setSource(JSPUtil.getParameter(request, "source", ""));
		setLnkRmk(JSPUtil.getParameter(request, "lnk_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setBackEndJobKey(JSPUtil.getParameter(request, "back_end_job_key", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOceanLinkVO[]
	 */
	public SearchOceanLinkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOceanLinkVO[]
	 */
	public SearchOceanLinkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOceanLinkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmPortEtdDyCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_etd_dy_cd", length));
			String[] fmtTztmHrs = (JSPUtil.getParameter(request, prefix	+ "fmt_tztm_hrs", length));
			String[] delOp = (JSPUtil.getParameter(request, prefix	+ "del_op", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] toPortEtbDyCd = (JSPUtil.getParameter(request, prefix	+ "to_port_etb_dy_cd", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] tsIndCd = (JSPUtil.getParameter(request, prefix	+ "ts_ind_cd", length));
			String[] tztmHrs = (JSPUtil.getParameter(request, prefix	+ "tztm_hrs", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] rnllws = (JSPUtil.getParameter(request, prefix	+ "rnllws", length));
			String[] updIndCd = (JSPUtil.getParameter(request, prefix	+ "upd_ind_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] ocnLnkMnlFlg = (JSPUtil.getParameter(request, prefix	+ "ocn_lnk_mnl_flg", length));
			String[] toPortEtdDyCd = (JSPUtil.getParameter(request, prefix	+ "to_port_etd_dy_cd", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ocnRoutRmk = (JSPUtil.getParameter(request, prefix	+ "ocn_rout_rmk", length));
			String[] fmPortEtbDyCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_etb_dy_cd", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] lnkRmk = (JSPUtil.getParameter(request, prefix	+ "lnk_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] backEndJobKey = (JSPUtil.getParameter(request, prefix	+ "back_end_job_key", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOceanLinkVO();
				if (fmPortEtdDyCd[i] != null)
					model.setFmPortEtdDyCd(fmPortEtdDyCd[i]);
				if (fmtTztmHrs[i] != null)
					model.setFmtTztmHrs(fmtTztmHrs[i]);
				if (delOp[i] != null)
					model.setDelOp(delOp[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (toPortEtbDyCd[i] != null)
					model.setToPortEtbDyCd(toPortEtbDyCd[i]);
				if (fmPortCd[i] != null)
					model.setFmPortCd(fmPortCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (tsIndCd[i] != null)
					model.setTsIndCd(tsIndCd[i]);
				if (tztmHrs[i] != null)
					model.setTztmHrs(tztmHrs[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (rnllws[i] != null)
					model.setRnllws(rnllws[i]);
				if (updIndCd[i] != null)
					model.setUpdIndCd(updIndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (ocnLnkMnlFlg[i] != null)
					model.setOcnLnkMnlFlg(ocnLnkMnlFlg[i]);
				if (toPortEtdDyCd[i] != null)
					model.setToPortEtdDyCd(toPortEtdDyCd[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ocnRoutRmk[i] != null)
					model.setOcnRoutRmk(ocnRoutRmk[i]);
				if (fmPortEtbDyCd[i] != null)
					model.setFmPortEtbDyCd(fmPortEtbDyCd[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (lnkRmk[i] != null)
					model.setLnkRmk(lnkRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (backEndJobKey[i] != null)
					model.setBackEndJobKey(backEndJobKey[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOceanLinkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOceanLinkVO[]
	 */
	public SearchOceanLinkVO[] getSearchOceanLinkVOs(){
		SearchOceanLinkVO[] vos = (SearchOceanLinkVO[])models.toArray(new SearchOceanLinkVO[models.size()]);
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
		this.fmPortEtdDyCd = this.fmPortEtdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTztmHrs = this.fmtTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOp = this.delOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortEtbDyCd = this.toPortEtbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsIndCd = this.tsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tztmHrs = this.tztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnllws = this.rnllws .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updIndCd = this.updIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnLnkMnlFlg = this.ocnLnkMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortEtdDyCd = this.toPortEtdDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnRoutRmk = this.ocnRoutRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortEtbDyCd = this.fmPortEtbDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkRmk = this.lnkRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backEndJobKey = this.backEndJobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
