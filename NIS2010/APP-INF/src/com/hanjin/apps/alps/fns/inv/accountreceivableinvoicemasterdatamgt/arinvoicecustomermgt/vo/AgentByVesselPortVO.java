/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentByVesselPortVO.java
*@FileTitle : AgentByVesselPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.21 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgentByVesselPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgentByVesselPortVO> models = new ArrayList<AgentByVesselPortVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String vndrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agnNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String portCd1 = null;
	/* Column Info */
	private String arAgnStlCd = null;
	/* Column Info */
	private String repCustSeq = null;
	/* Column Info */
	private String fdrPodCd = null;
	/* Column Info */
	private String agnCd1 = null;
	/* Column Info */
	private String repCustBar = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgentByVesselPortVO() {}

	public AgentByVesselPortVO(String ibflag, String pagerows, String laneCd, String vndrCntCd, String vslCd, String deltFlg, String creDt, String agnCd, String repCustCntCd, String vslEngNm, String portCd, String custCntCd, String updUsrId, String updDt, String custSeq, String arOfcCd, String vndrCd, String creUsrId, String agnNm, String custCd, String vndrSeq, String arAgnStlCd, String repCustSeq, String fdrPodCd, String agnCd1, String repCustBar, String portCd1, String ioBndCd, String porCd, String polCd, String podCd, String delCd) {
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.laneCd = laneCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.repCustCntCd = repCustCntCd;
		this.vslEngNm = vslEngNm;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.vndrCd = vndrCd;
		this.creUsrId = creUsrId;
		this.agnNm = agnNm;
		this.custCd = custCd;
		this.vndrSeq = vndrSeq;
		this.portCd1 = portCd1;
		this.arAgnStlCd = arAgnStlCd;
		this.repCustSeq = repCustSeq;
		this.fdrPodCd = fdrPodCd;
		this.agnCd1 = agnCd1;
		this.repCustBar = repCustBar;
		this.ioBndCd = ioBndCd;
		this.porCd = porCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("vndr_cd", getVndrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agn_nm", getAgnNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("port_cd1", getPortCd1());
		this.hashColumns.put("ar_agn_stl_cd", getArAgnStlCd());
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());
		this.hashColumns.put("fdr_pod_cd", getFdrPodCd());
		this.hashColumns.put("agn_cd1", getAgnCd1());
		this.hashColumns.put("rep_cust_bar", getRepCustBar());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("vndr_cd", "vndrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agn_nm", "agnNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("port_cd1", "portCd1");
		this.hashFields.put("ar_agn_stl_cd", "arAgnStlCd");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("fdr_pod_cd", "fdrPodCd");
		this.hashFields.put("agn_cd1", "agnCd1");
		this.hashFields.put("rep_cust_bar", "repCustBar");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		
		return this.hashFields;
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCd
	 */
	public String getVndrCd() {
		return this.vndrCd;
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
	 * @return agnNm
	 */
	public String getAgnNm() {
		return this.agnNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return portCd1
	 */
	public String getPortCd1() {
		return this.portCd1;
	}
	
	/**
	 * Column Info
	 * @return arAgnStlCd
	 */
	public String getArAgnStlCd() {
		return this.arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @return repCustSeq
	 */
	public String getRepCustSeq() {
		return this.repCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fdrPodCd
	 */
	public String getFdrPodCd() {
		return this.fdrPodCd;
	}
	
	/**
	 * Column Info
	 * @return agnCd1
	 */
	public String getAgnCd1() {
		return this.agnCd1;
	}
	
	/**
	 * Column Info
	 * @return repCustBar
	 */
	public String getRepCustBar() {
		return this.repCustBar;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCd
	 */
	public void setVndrCd(String vndrCd) {
		this.vndrCd = vndrCd;
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
	 * @param agnNm
	 */
	public void setAgnNm(String agnNm) {
		this.agnNm = agnNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param portCd1
	 */
	public void setPortCd1(String portCd1) {
		this.portCd1 = portCd1;
	}
	
	/**
	 * Column Info
	 * @param arAgnStlCd
	 */
	public void setArAgnStlCd(String arAgnStlCd) {
		this.arAgnStlCd = arAgnStlCd;
	}
	
	/**
	 * Column Info
	 * @param repCustSeq
	 */
	public void setRepCustSeq(String repCustSeq) {
		this.repCustSeq = repCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fdrPodCd
	 */
	public void setFdrPodCd(String fdrPodCd) {
		this.fdrPodCd = fdrPodCd;
	}
	
	/**
	 * Column Info
	 * @param agnCd1
	 */
	public void setAgnCd1(String agnCd1) {
		this.agnCd1 = agnCd1;
	}
	
	/**
	 * Column Info
	 * @param repCustBar
	 */
	public void setRepCustBar(String repCustBar) {
		this.repCustBar = repCustBar;
	}
	
	/**
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @param ioBndCd the ioBndCd to set
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * @return the porCd
	 */
	public String getPorCd() {
		return porCd;
	}

	/**
	 * @param porCd the porCd to set
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, "rep_cust_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setVndrCd(JSPUtil.getParameter(request, "vndr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAgnNm(JSPUtil.getParameter(request, "agn_nm", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPortCd1(JSPUtil.getParameter(request, "port_cd1", ""));
		setArAgnStlCd(JSPUtil.getParameter(request, "ar_agn_stl_cd", ""));
		setRepCustSeq(JSPUtil.getParameter(request, "rep_cust_seq", ""));
		setFdrPodCd(JSPUtil.getParameter(request, "fdr_pod_cd", ""));
		setAgnCd1(JSPUtil.getParameter(request, "agn_cd1", ""));
		setRepCustBar(JSPUtil.getParameter(request, "rep_cust_bar", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgentByVesselPortVO[]
	 */
	public AgentByVesselPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgentByVesselPortVO[]
	 */
	public AgentByVesselPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgentByVesselPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] vndrCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agnNm = (JSPUtil.getParameter(request, prefix	+ "agn_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] portCd1 = (JSPUtil.getParameter(request, prefix	+ "port_cd1", length));
			String[] arAgnStlCd = (JSPUtil.getParameter(request, prefix	+ "ar_agn_stl_cd", length));
			String[] repCustSeq = (JSPUtil.getParameter(request, prefix	+ "rep_cust_seq", length));
			String[] fdrPodCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pod_cd", length));
			String[] agnCd1 = (JSPUtil.getParameter(request, prefix	+ "agn_cd1", length));
			String[] repCustBar = (JSPUtil.getParameter(request, prefix	+ "rep_cust_bar", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgentByVesselPortVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (vndrCd[i] != null)
					model.setVndrCd(vndrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agnNm[i] != null)
					model.setAgnNm(agnNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (portCd1[i] != null)
					model.setPortCd1(portCd1[i]);
				if (arAgnStlCd[i] != null)
					model.setArAgnStlCd(arAgnStlCd[i]);
				if (repCustSeq[i] != null)
					model.setRepCustSeq(repCustSeq[i]);
				if (fdrPodCd[i] != null)
					model.setFdrPodCd(fdrPodCd[i]);
				if (agnCd1[i] != null)
					model.setAgnCd1(agnCd1[i]);
				if (repCustBar[i] != null)
					model.setRepCustBar(repCustBar[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgentByVesselPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgentByVesselPortVO[]
	 */
	public AgentByVesselPortVO[] getAgentByVesselPortVOs(){
		AgentByVesselPortVO[] vos = (AgentByVesselPortVO[])models.toArray(new AgentByVesselPortVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCd = this.vndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnNm = this.agnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd1 = this.portCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAgnStlCd = this.arAgnStlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq = this.repCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPodCd = this.fdrPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd1 = this.agnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustBar = this.repCustBar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
