/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriPrsCostDetailVO.java
*@FileTitle : RsltPriPrsCostDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.02 송민석 
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

public class RsltPriPrsCostDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriPrsCostDetailVO> models = new ArrayList<RsltPriPrsCostDetailVO>();
	
	/* Column Info */
	private String ctrtFlg = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String avgFlg = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String rowProperties = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String costTp = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String routCsSrcDt = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String sgrpCostCdDesc = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String routCsNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriPrsCostDetailVO() {}

	public RsltPriPrsCostDetailVO(String ibflag, String pagerows, String nodCd, String costActGrpSeq, String grp, String sgrpCostCdDesc, String stndCostNm, String amt, String wtrRcvTermCd, String wtrDeTermCd, String lvl, String ctrtFlg, String avgFlg, String rowProperties, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String routCsNo, String routCsSrcDt, String costTp) {
		this.ctrtFlg = ctrtFlg;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.avgFlg = avgFlg;
		this.stndCostNm = stndCostNm;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.pagerows = pagerows;
		this.amt = amt;
		this.rowProperties = rowProperties;
		this.ibflag = ibflag;
		this.grp = grp;
		this.lvl = lvl;
		this.costTp = costTp;
		this.propNo = propNo;
		this.costActGrpSeq = costActGrpSeq;
		this.routCsSrcDt = routCsSrcDt;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.nodCd = nodCd;
		this.sgrpCostCdDesc = sgrpCostCdDesc;
		this.wtrDeTermCd = wtrDeTermCd;
		this.routCsNo = routCsNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_flg", getCtrtFlg());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("avg_flg", getAvgFlg());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("cost_tp", getCostTp());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("rout_cs_src_dt", getRoutCsSrcDt());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("sgrp_cost_cd_desc", getSgrpCostCdDesc());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("rout_cs_no", getRoutCsNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_flg", "ctrtFlg");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("avg_flg", "avgFlg");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("cost_tp", "costTp");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("rout_cs_src_dt", "routCsSrcDt");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("sgrp_cost_cd_desc", "sgrpCostCdDesc");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("rout_cs_no", "routCsNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtFlg
	 */
	public String getCtrtFlg() {
		return this.ctrtFlg;
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
	 * @return avgFlg
	 */
	public String getAvgFlg() {
		return this.avgFlg;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
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
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
	}
	
	/**
	 * Column Info
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
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
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
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
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
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
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return sgrpCostCdDesc
	 */
	public String getSgrpCostCdDesc() {
		return this.sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
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
	 * @param ctrtFlg
	 */
	public void setCtrtFlg(String ctrtFlg) {
		this.ctrtFlg = ctrtFlg;
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
	 * @param avgFlg
	 */
	public void setAvgFlg(String avgFlg) {
		this.avgFlg = avgFlg;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
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
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	/**
	 * Column Info
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
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
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
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
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param sgrpCostCdDesc
	 */
	public void setSgrpCostCdDesc(String sgrpCostCdDesc) {
		this.sgrpCostCdDesc = sgrpCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
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
		setCtrtFlg(JSPUtil.getParameter(request, "ctrt_flg", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setAvgFlg(JSPUtil.getParameter(request, "avg_flg", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAmt(JSPUtil.getParameter(request, "amt", ""));
		setRowProperties(JSPUtil.getParameter(request, "row_properties", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setCostTp(JSPUtil.getParameter(request, "cost_tp", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setRoutCsSrcDt(JSPUtil.getParameter(request, "rout_cs_src_dt", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, "wtr_rcv_term_cd", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setSgrpCostCdDesc(JSPUtil.getParameter(request, "sgrp_cost_cd_desc", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, "wtr_de_term_cd", ""));
		setRoutCsNo(JSPUtil.getParameter(request, "rout_cs_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriPrsCostDetailVO[]
	 */
	public RsltPriPrsCostDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriPrsCostDetailVO[]
	 */
	public RsltPriPrsCostDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriPrsCostDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_flg", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] avgFlg = (JSPUtil.getParameter(request, prefix	+ "avg_flg", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] costTp = (JSPUtil.getParameter(request, prefix	+ "cost_tp", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] routCsSrcDt = (JSPUtil.getParameter(request, prefix	+ "rout_cs_src_dt", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] sgrpCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "sgrp_cost_cd_desc", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] routCsNo = (JSPUtil.getParameter(request, prefix	+ "rout_cs_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriPrsCostDetailVO();
				if (ctrtFlg[i] != null)
					model.setCtrtFlg(ctrtFlg[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (avgFlg[i] != null)
					model.setAvgFlg(avgFlg[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (costTp[i] != null)
					model.setCostTp(costTp[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (routCsSrcDt[i] != null)
					model.setRoutCsSrcDt(routCsSrcDt[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (sgrpCostCdDesc[i] != null)
					model.setSgrpCostCdDesc(sgrpCostCdDesc[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (routCsNo[i] != null)
					model.setRoutCsNo(routCsNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriPrsCostDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriPrsCostDetailVO[]
	 */
	public RsltPriPrsCostDetailVO[] getRsltPriPrsCostDetailVOs(){
		RsltPriPrsCostDetailVO[] vos = (RsltPriPrsCostDetailVO[])models.toArray(new RsltPriPrsCostDetailVO[models.size()]);
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
		this.ctrtFlg = this.ctrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgFlg = this.avgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTp = this.costTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsSrcDt = this.routCsSrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgrpCostCdDesc = this.sgrpCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCsNo = this.routCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
