/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PfSkdEotpSummaryVO.java
*@FileTitle : PfSkdEotpSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.08.07 서창열 
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

public class PfSkdEotpSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PfSkdEotpSumVO> models = new ArrayList<PfSkdEotpSumVO>();
	
	/* Column Info */
	private String histYr = null;
	/* Column Info */
	private String lnkSpd = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String portcd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String ibOcnCgoQty = null;
	/* Column Info */
	private String eotpRt01 = null;
	/* Column Info */
	private String bfPortCd = null;
	/* Column Info */
	private String onTmCnt = null;
	/* Column Info */
	private String onTmRt = null;
	/* Column Info */
	private String eotpCnt = null;
	/* Column Info */
	private String eotpRt02 = null;
	/* Column Info */
	private String tmlProdQty = null;
	/* Column Info */
	private String portBufHrs = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlCnt = null;
	/* Column Info */
	private String toPortCd = null;
	/* Column Info */
	private String ibIpcgoQty = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String obIpcgoQty = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String obOcnCgoQty = null;
	/* Column Info */
	private String actWrkHrs = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PfSkdEotpSumVO() {}

	public PfSkdEotpSumVO(String ibflag, String pagerows, String ttlCnt, String onTmCnt, String onTmRt, String eotpCnt, String eotpRt01, String eotpRt02, String toPortCd, String tmlProdQty, String ibIpcgoQty, String obIpcgoQty, String ibOcnCgoQty, String obOcnCgoQty, String lnkDist, String lnkSpd, String seaBufHrs, String n1stVslClssCd, String n2ndVslClssCd, String n3rdVslClssCd, String bfPortCd, String histYr, String portcd, String portBufHrs, String actWrkHrs) {
		this.histYr = histYr;
		this.lnkSpd = lnkSpd;
		this.lnkDist = lnkDist;
		this.portcd = portcd;
		this.seaBufHrs = seaBufHrs;
		this.ibOcnCgoQty = ibOcnCgoQty;
		this.eotpRt01 = eotpRt01;
		this.bfPortCd = bfPortCd;
		this.onTmCnt = onTmCnt;
		this.onTmRt = onTmRt;
		this.eotpCnt = eotpCnt;
		this.eotpRt02 = eotpRt02;
		this.tmlProdQty = tmlProdQty;
		this.portBufHrs = portBufHrs;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ttlCnt = ttlCnt;
		this.toPortCd = toPortCd;
		this.ibIpcgoQty = ibIpcgoQty;
		this.n3rdVslClssCd = n3rdVslClssCd;
		this.obIpcgoQty = obIpcgoQty;
		this.n2ndVslClssCd = n2ndVslClssCd;
		this.n1stVslClssCd = n1stVslClssCd;
		this.obOcnCgoQty = obOcnCgoQty;
		this.actWrkHrs = actWrkHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hist_yr", getHistYr());
		this.hashColumns.put("lnk_spd", getLnkSpd());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("portcd", getPortcd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("ib_ocn_cgo_qty", getIbOcnCgoQty());
		this.hashColumns.put("eotp_rt01", getEotpRt01());
		this.hashColumns.put("bf_port_cd", getBfPortCd());
		this.hashColumns.put("on_tm_cnt", getOnTmCnt());
		this.hashColumns.put("on_tm_rt", getOnTmRt());
		this.hashColumns.put("eotp_cnt", getEotpCnt());
		this.hashColumns.put("eotp_rt02", getEotpRt02());
		this.hashColumns.put("tml_prod_qty", getTmlProdQty());
		this.hashColumns.put("port_buf_hrs", getPortBufHrs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_cnt", getTtlCnt());
		this.hashColumns.put("to_port_cd", getToPortCd());
		this.hashColumns.put("ib_ipcgo_qty", getIbIpcgoQty());
		this.hashColumns.put("n3rd_vsl_clss_cd", getN3rdVslClssCd());
		this.hashColumns.put("ob_ipcgo_qty", getObIpcgoQty());
		this.hashColumns.put("n2nd_vsl_clss_cd", getN2ndVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_cd", getN1stVslClssCd());
		this.hashColumns.put("ob_ocn_cgo_qty", getObOcnCgoQty());
		this.hashColumns.put("act_wrk_hrs", getActWrkHrs());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hist_yr", "histYr");
		this.hashFields.put("lnk_spd", "lnkSpd");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("portcd", "portcd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("ib_ocn_cgo_qty", "ibOcnCgoQty");
		this.hashFields.put("eotp_rt01", "eotpRt01");
		this.hashFields.put("bf_port_cd", "bfPortCd");
		this.hashFields.put("on_tm_cnt", "onTmCnt");
		this.hashFields.put("on_tm_rt", "onTmRt");
		this.hashFields.put("eotp_cnt", "eotpCnt");
		this.hashFields.put("eotp_rt02", "eotpRt02");
		this.hashFields.put("tml_prod_qty", "tmlProdQty");
		this.hashFields.put("port_buf_hrs", "portBufHrs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_cnt", "ttlCnt");
		this.hashFields.put("to_port_cd", "toPortCd");
		this.hashFields.put("ib_ipcgo_qty", "ibIpcgoQty");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("ob_ipcgo_qty", "obIpcgoQty");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("ob_ocn_cgo_qty", "obOcnCgoQty");
		this.hashFields.put("act_wrk_hrs", "actWrkHrs");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return histYr
	 */
	public String getHistYr() {
		return this.histYr;
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
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return portcd
	 */
	public String getPortcd() {
		return this.portcd;
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
	 * @return ibOcnCgoQty
	 */
	public String getIbOcnCgoQty() {
		return this.ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @return eotpRt01
	 */
	public String getEotpRt01() {
		return this.eotpRt01;
	}
	
	/**
	 * Column Info
	 * @return bfPortCd
	 */
	public String getBfPortCd() {
		return this.bfPortCd;
	}
	
	/**
	 * Column Info
	 * @return onTmCnt
	 */
	public String getOnTmCnt() {
		return this.onTmCnt;
	}
	
	/**
	 * Column Info
	 * @return onTmRt
	 */
	public String getOnTmRt() {
		return this.onTmRt;
	}
	
	/**
	 * Column Info
	 * @return eotpCnt
	 */
	public String getEotpCnt() {
		return this.eotpCnt;
	}
	
	/**
	 * Column Info
	 * @return eotpRt02
	 */
	public String getEotpRt02() {
		return this.eotpRt02;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ttlCnt
	 */
	public String getTtlCnt() {
		return this.ttlCnt;
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
	 * @return ibIpcgoQty
	 */
	public String getIbIpcgoQty() {
		return this.ibIpcgoQty;
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
	 * @return obIpcgoQty
	 */
	public String getObIpcgoQty() {
		return this.obIpcgoQty;
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
	 * @return obOcnCgoQty
	 */
	public String getObOcnCgoQty() {
		return this.obOcnCgoQty;
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
	 * @param histYr
	 */
	public void setHistYr(String histYr) {
		this.histYr = histYr;
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
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param portcd
	 */
	public void setPortcd(String portcd) {
		this.portcd = portcd;
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
	 * @param ibOcnCgoQty
	 */
	public void setIbOcnCgoQty(String ibOcnCgoQty) {
		this.ibOcnCgoQty = ibOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param eotpRt01
	 */
	public void setEotpRt01(String eotpRt01) {
		this.eotpRt01 = eotpRt01;
	}
	
	/**
	 * Column Info
	 * @param bfPortCd
	 */
	public void setBfPortCd(String bfPortCd) {
		this.bfPortCd = bfPortCd;
	}
	
	/**
	 * Column Info
	 * @param onTmCnt
	 */
	public void setOnTmCnt(String onTmCnt) {
		this.onTmCnt = onTmCnt;
	}
	
	/**
	 * Column Info
	 * @param onTmRt
	 */
	public void setOnTmRt(String onTmRt) {
		this.onTmRt = onTmRt;
	}
	
	/**
	 * Column Info
	 * @param eotpCnt
	 */
	public void setEotpCnt(String eotpCnt) {
		this.eotpCnt = eotpCnt;
	}
	
	/**
	 * Column Info
	 * @param eotpRt02
	 */
	public void setEotpRt02(String eotpRt02) {
		this.eotpRt02 = eotpRt02;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ttlCnt
	 */
	public void setTtlCnt(String ttlCnt) {
		this.ttlCnt = ttlCnt;
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
	 * @param ibIpcgoQty
	 */
	public void setIbIpcgoQty(String ibIpcgoQty) {
		this.ibIpcgoQty = ibIpcgoQty;
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
	 * @param obIpcgoQty
	 */
	public void setObIpcgoQty(String obIpcgoQty) {
		this.obIpcgoQty = obIpcgoQty;
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
	 * @param obOcnCgoQty
	 */
	public void setObOcnCgoQty(String obOcnCgoQty) {
		this.obOcnCgoQty = obOcnCgoQty;
	}
	
	/**
	 * Column Info
	 * @param actWrkHrs
	 */
	public void setActWrkHrs(String actWrkHrs) {
		this.actWrkHrs = actWrkHrs;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHistYr(JSPUtil.getParameter(request, "hist_yr", ""));
		setLnkSpd(JSPUtil.getParameter(request, "lnk_spd", ""));
		setLnkDist(JSPUtil.getParameter(request, "lnk_dist", ""));
		setPortcd(JSPUtil.getParameter(request, "portcd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, "sea_buf_hrs", ""));
		setIbOcnCgoQty(JSPUtil.getParameter(request, "ib_ocn_cgo_qty", ""));
		setEotpRt01(JSPUtil.getParameter(request, "eotp_rt01", ""));
		setBfPortCd(JSPUtil.getParameter(request, "bf_port_cd", ""));
		setOnTmCnt(JSPUtil.getParameter(request, "on_tm_cnt", ""));
		setOnTmRt(JSPUtil.getParameter(request, "on_tm_rt", ""));
		setEotpCnt(JSPUtil.getParameter(request, "eotp_cnt", ""));
		setEotpRt02(JSPUtil.getParameter(request, "eotp_rt02", ""));
		setTmlProdQty(JSPUtil.getParameter(request, "tml_prod_qty", ""));
		setPortBufHrs(JSPUtil.getParameter(request, "port_buf_hrs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTtlCnt(JSPUtil.getParameter(request, "ttl_cnt", ""));
		setToPortCd(JSPUtil.getParameter(request, "to_port_cd", ""));
		setIbIpcgoQty(JSPUtil.getParameter(request, "ib_ipcgo_qty", ""));
		setN3rdVslClssCd(JSPUtil.getParameter(request, "n3rd_vsl_clss_cd", ""));
		setObIpcgoQty(JSPUtil.getParameter(request, "ob_ipcgo_qty", ""));
		setN2ndVslClssCd(JSPUtil.getParameter(request, "n2nd_vsl_clss_cd", ""));
		setN1stVslClssCd(JSPUtil.getParameter(request, "n1st_vsl_clss_cd", ""));
		setObOcnCgoQty(JSPUtil.getParameter(request, "ob_ocn_cgo_qty", ""));
		setActWrkHrs(JSPUtil.getParameter(request, "act_wrk_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PfSkdEotpSummaryVO[]
	 */
	public PfSkdEotpSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PfSkdEotpSummaryVO[]
	 */
	public PfSkdEotpSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PfSkdEotpSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] histYr = (JSPUtil.getParameter(request, prefix	+ "hist_yr", length));
			String[] lnkSpd = (JSPUtil.getParameter(request, prefix	+ "lnk_spd", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] portcd = (JSPUtil.getParameter(request, prefix	+ "portcd", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] ibOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ocn_cgo_qty", length));
			String[] eotpRt01 = (JSPUtil.getParameter(request, prefix	+ "eotp_rt01", length));
			String[] bfPortCd = (JSPUtil.getParameter(request, prefix	+ "bf_port_cd", length));
			String[] onTmCnt = (JSPUtil.getParameter(request, prefix	+ "on_tm_cnt", length));
			String[] onTmRt = (JSPUtil.getParameter(request, prefix	+ "on_tm_rt", length));
			String[] eotpCnt = (JSPUtil.getParameter(request, prefix	+ "eotp_cnt", length));
			String[] eotpRt02 = (JSPUtil.getParameter(request, prefix	+ "eotp_rt02", length));
			String[] tmlProdQty = (JSPUtil.getParameter(request, prefix	+ "tml_prod_qty", length));
			String[] portBufHrs = (JSPUtil.getParameter(request, prefix	+ "port_buf_hrs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_cnt", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			String[] ibIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ib_ipcgo_qty", length));
			String[] n3rdVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd", length));
			String[] obIpcgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ipcgo_qty", length));
			String[] n2ndVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd", length));
			String[] n1stVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd", length));
			String[] obOcnCgoQty = (JSPUtil.getParameter(request, prefix	+ "ob_ocn_cgo_qty", length));
			String[] actWrkHrs = (JSPUtil.getParameter(request, prefix	+ "act_wrk_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new PfSkdEotpSumVO();
				if (histYr[i] != null)
					model.setHistYr(histYr[i]);
				if (lnkSpd[i] != null)
					model.setLnkSpd(lnkSpd[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (portcd[i] != null)
					model.setPortcd(portcd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (ibOcnCgoQty[i] != null)
					model.setIbOcnCgoQty(ibOcnCgoQty[i]);
				if (eotpRt01[i] != null)
					model.setEotpRt01(eotpRt01[i]);
				if (bfPortCd[i] != null)
					model.setBfPortCd(bfPortCd[i]);
				if (onTmCnt[i] != null)
					model.setOnTmCnt(onTmCnt[i]);
				if (onTmRt[i] != null)
					model.setOnTmRt(onTmRt[i]);
				if (eotpCnt[i] != null)
					model.setEotpCnt(eotpCnt[i]);
				if (eotpRt02[i] != null)
					model.setEotpRt02(eotpRt02[i]);
				if (tmlProdQty[i] != null)
					model.setTmlProdQty(tmlProdQty[i]);
				if (portBufHrs[i] != null)
					model.setPortBufHrs(portBufHrs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlCnt[i] != null)
					model.setTtlCnt(ttlCnt[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				if (ibIpcgoQty[i] != null)
					model.setIbIpcgoQty(ibIpcgoQty[i]);
				if (n3rdVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (obIpcgoQty[i] != null)
					model.setObIpcgoQty(obIpcgoQty[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (obOcnCgoQty[i] != null)
					model.setObOcnCgoQty(obOcnCgoQty[i]);
				if (actWrkHrs[i] != null)
					model.setActWrkHrs(actWrkHrs[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPfSkdEotpSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PfSkdEotpSummaryVO[]
	 */
	public PfSkdEotpSumVO[] getPfSkdEotpSummaryVOs(){
		PfSkdEotpSumVO[] vos = (PfSkdEotpSumVO[])models.toArray(new PfSkdEotpSumVO[models.size()]);
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
		this.histYr = this.histYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkSpd = this.lnkSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portcd = this.portcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibOcnCgoQty = this.ibOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eotpRt01 = this.eotpRt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfPortCd = this.bfPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmCnt = this.onTmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmRt = this.onTmRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eotpCnt = this.eotpCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eotpRt02 = this.eotpRt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdQty = this.tmlProdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBufHrs = this.portBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCnt = this.ttlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIpcgoQty = this.ibIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd = this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obIpcgoQty = this.obIpcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd = this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssCd = this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obOcnCgoQty = this.obOcnCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWrkHrs = this.actWrkHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
