/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriPrsCostListVO.java
*@FileTitle : RsltPriPrsCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.12.07 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriPrsCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriPrsCostListVO> models = new ArrayList<RsltPriPrsCostListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rdterm = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String respbUsdTtlAmt = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String svcLane = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String tsRoute = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String costTp = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String usdRoutCsSelFlg = null;
	/* Column Info */
	private String routCsSrcDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routCsNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriPrsCostListVO() {}

	public RsltPriPrsCostListVO(String ibflag, String pagerows, String porCd, String obItchgCtnt, String polCd, String tsRoute, String podCd, String ibItchgCtnt, String delCd, String rdterm, String svcLane, String ttlTztmHrs, String respbUsdTtlAmt, String routCsNo, String routCsSrcDt, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String costTp, String updUsrId, String usdRoutCsSelFlg) {
		this.porCd = porCd;
		this.rdterm = rdterm;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.delCd = delCd;
		this.respbUsdTtlAmt = respbUsdTtlAmt;
		this.ibItchgCtnt = ibItchgCtnt;
		this.svcLane = svcLane;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
		this.obItchgCtnt = obItchgCtnt;
		this.tsRoute = tsRoute;
		this.podCd = podCd;
		this.ttlTztmHrs = ttlTztmHrs;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.costTp = costTp;
		this.propNo = propNo;
		this.usdRoutCsSelFlg = usdRoutCsSelFlg;
		this.routCsSrcDt = routCsSrcDt;
		this.updUsrId = updUsrId;
		this.routCsNo = routCsNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rdterm", getRdterm());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("respb_usd_ttl_amt", getRespbUsdTtlAmt());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("svc_lane", getSvcLane());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("ts_route", getTsRoute());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cost_tp", getCostTp());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("usd_rout_cs_sel_flg", getUsdRoutCsSelFlg());
		this.hashColumns.put("rout_cs_src_dt", getRoutCsSrcDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rout_cs_no", getRoutCsNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rdterm", "rdterm");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("respb_usd_ttl_amt", "respbUsdTtlAmt");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("svc_lane", "svcLane");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("ts_route", "tsRoute");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cost_tp", "costTp");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("usd_rout_cs_sel_flg", "usdRoutCsSelFlg");
		this.hashFields.put("rout_cs_src_dt", "routCsSrcDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rout_cs_no", "routCsNo");
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
	 * @return rdterm
	 */
	public String getRdterm() {
		return this.rdterm;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return respbUsdTtlAmt
	 */
	public String getRespbUsdTtlAmt() {
		return this.respbUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return svcLane
	 */
	public String getSvcLane() {
		return this.svcLane;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return tsRoute
	 */
	public String getTsRoute() {
		return this.tsRoute;
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
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return costTp
	 */
	public String getCostTp() {
		return this.costTp;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return usdRoutCsSelFlg
	 */
	public String getUsdRoutCsSelFlg() {
		return this.usdRoutCsSelFlg;
	}
	
	/**
	 * Column Info
	 * @return routCsSrcDt
	 */
	public String getRoutCsSrcDt() {
		return this.routCsSrcDt;
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
	 * @return routCsNo
	 */
	public String getRoutCsNo() {
		return this.routCsNo;
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
	 * @param rdterm
	 */
	public void setRdterm(String rdterm) {
		this.rdterm = rdterm;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param respbUsdTtlAmt
	 */
	public void setRespbUsdTtlAmt(String respbUsdTtlAmt) {
		this.respbUsdTtlAmt = respbUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param svcLane
	 */
	public void setSvcLane(String svcLane) {
		this.svcLane = svcLane;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param tsRoute
	 */
	public void setTsRoute(String tsRoute) {
		this.tsRoute = tsRoute;
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
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param costTp
	 */
	public void setCostTp(String costTp) {
		this.costTp = costTp;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param usdRoutCsSelFlg
	 */
	public void setUsdRoutCsSelFlg(String usdRoutCsSelFlg) {
		this.usdRoutCsSelFlg = usdRoutCsSelFlg;
	}
	
	/**
	 * Column Info
	 * @param routCsSrcDt
	 */
	public void setRoutCsSrcDt(String routCsSrcDt) {
		this.routCsSrcDt = routCsSrcDt;
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
	 * @param routCsNo
	 */
	public void setRoutCsNo(String routCsNo) {
		this.routCsNo = routCsNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setRdterm(JSPUtil.getParameter(request, "rdterm", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRespbUsdTtlAmt(JSPUtil.getParameter(request, "respb_usd_ttl_amt", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setSvcLane(JSPUtil.getParameter(request, "svc_lane", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setTsRoute(JSPUtil.getParameter(request, "ts_route", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, "ttl_tztm_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCostTp(JSPUtil.getParameter(request, "cost_tp", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setUsdRoutCsSelFlg(JSPUtil.getParameter(request, "usd_rout_cs_sel_flg", ""));
		setRoutCsSrcDt(JSPUtil.getParameter(request, "rout_cs_src_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRoutCsNo(JSPUtil.getParameter(request, "rout_cs_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriPrsCostListVO[]
	 */
	public RsltPriPrsCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriPrsCostListVO[]
	 */
	public RsltPriPrsCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriPrsCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rdterm = (JSPUtil.getParameter(request, prefix	+ "rdterm", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] respbUsdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "respb_usd_ttl_amt", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] svcLane = (JSPUtil.getParameter(request, prefix	+ "svc_lane", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] tsRoute = (JSPUtil.getParameter(request, prefix	+ "ts_route", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_tztm_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] costTp = (JSPUtil.getParameter(request, prefix	+ "cost_tp", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] usdRoutCsSelFlg = (JSPUtil.getParameter(request, prefix	+ "usd_rout_cs_sel_flg", length));
			String[] routCsSrcDt = (JSPUtil.getParameter(request, prefix	+ "rout_cs_src_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] routCsNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriPrsCostListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rdterm[i] != null)
					model.setRdterm(rdterm[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (respbUsdTtlAmt[i] != null)
					model.setRespbUsdTtlAmt(respbUsdTtlAmt[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (svcLane[i] != null)
					model.setSvcLane(svcLane[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (tsRoute[i] != null)
					model.setTsRoute(tsRoute[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (costTp[i] != null)
					model.setCostTp(costTp[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (usdRoutCsSelFlg[i] != null)
					model.setUsdRoutCsSelFlg(usdRoutCsSelFlg[i]);
				if (routCsSrcDt[i] != null)
					model.setRoutCsSrcDt(routCsSrcDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routCsNo[i] != null)
					model.setRoutCsNo(routCsNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriPrsCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriPrsCostListVO[]
	 */
	public RsltPriPrsCostListVO[] getRsltPriPrsCostListVOs(){
		RsltPriPrsCostListVO[] vos = (RsltPriPrsCostListVO[])models.toArray(new RsltPriPrsCostListVO[models.size()]);
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
		this.rdterm = this.rdterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbUsdTtlAmt = this.respbUsdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcLane = this.svcLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRoute = this.tsRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTp = this.costTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdRoutCsSelFlg = this.usdRoutCsSelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsSrcDt = this.routCsSrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsNo = this.routCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
