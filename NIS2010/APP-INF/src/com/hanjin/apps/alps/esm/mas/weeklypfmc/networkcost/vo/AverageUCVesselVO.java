/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AverageUCVesselVO.java
*@FileTitle : AverageUCVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.04.08 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AverageUCVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageUCVesselVO> models = new ArrayList<AverageUCVesselVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String depAmt = null;
	/* Column Info */
	private String insAmt = null;
	/* Column Info */
	private String lubAmt = null;
	/* Column Info */
	private String stoAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String otrAmt = null;
	/* Column Info */
	private String vslKnt = null;
	/* Column Info */
	private String telAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fFmyearmonth = null;
	/* Column Info */
	private String dhirAmt = null;
	/* Column Info */
	private String mnrAmt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String creAmt = null;
	/* Column Info */
	private String fToyearmonth = null;
	/* Column Info */
	private String preDhirAmt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String vslAmt = null;
	/* Column Info */
	private String timAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageUCVesselVO() {}

	public AverageUCVesselVO(String ibflag, String pagerows, String dhirAmt, String vslCd, String costYrmon, String preDhirAmt, String vslClssCapa, String vslKnt, String updUsrId, String stndCostCd, String creAmt, String insAmt, String stoAmt, String lubAmt, String mnrAmt, String depAmt, String telAmt, String vslAmt, String otrAmt, String timAmt, String ttlAmt, String fFmyearmonth, String fToyearmonth) {
		this.vslCd = vslCd;
		this.depAmt = depAmt;
		this.insAmt = insAmt;
		this.lubAmt = lubAmt;
		this.stoAmt = stoAmt;
		this.ttlAmt = ttlAmt;
		this.otrAmt = otrAmt;
		this.vslKnt = vslKnt;
		this.telAmt = telAmt;
		this.pagerows = pagerows;
		this.fFmyearmonth = fFmyearmonth;
		this.dhirAmt = dhirAmt;
		this.mnrAmt = mnrAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.creAmt = creAmt;
		this.fToyearmonth = fToyearmonth;
		this.preDhirAmt = preDhirAmt;
		this.vslClssCapa = vslClssCapa;
		this.vslAmt = vslAmt;
		this.timAmt = timAmt;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dep_amt", getDepAmt());
		this.hashColumns.put("ins_amt", getInsAmt());
		this.hashColumns.put("lub_amt", getLubAmt());
		this.hashColumns.put("sto_amt", getStoAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("otr_amt", getOtrAmt());
		this.hashColumns.put("vsl_knt", getVslKnt());
		this.hashColumns.put("tel_amt", getTelAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_fmyearmonth", getFFmyearmonth());
		this.hashColumns.put("dhir_amt", getDhirAmt());
		this.hashColumns.put("mnr_amt", getMnrAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cre_amt", getCreAmt());
		this.hashColumns.put("f_toyearmonth", getFToyearmonth());
		this.hashColumns.put("pre_dhir_amt", getPreDhirAmt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("vsl_amt", getVslAmt());
		this.hashColumns.put("tim_amt", getTimAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dep_amt", "depAmt");
		this.hashFields.put("ins_amt", "insAmt");
		this.hashFields.put("lub_amt", "lubAmt");
		this.hashFields.put("sto_amt", "stoAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("otr_amt", "otrAmt");
		this.hashFields.put("vsl_knt", "vslKnt");
		this.hashFields.put("tel_amt", "telAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_fmyearmonth", "fFmyearmonth");
		this.hashFields.put("dhir_amt", "dhirAmt");
		this.hashFields.put("mnr_amt", "mnrAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cre_amt", "creAmt");
		this.hashFields.put("f_toyearmonth", "fToyearmonth");
		this.hashFields.put("pre_dhir_amt", "preDhirAmt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("vsl_amt", "vslAmt");
		this.hashFields.put("tim_amt", "timAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
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
	 * @return depAmt
	 */
	public String getDepAmt() {
		return this.depAmt;
	}
	
	/**
	 * Column Info
	 * @return insAmt
	 */
	public String getInsAmt() {
		return this.insAmt;
	}
	
	/**
	 * Column Info
	 * @return lubAmt
	 */
	public String getLubAmt() {
		return this.lubAmt;
	}
	
	/**
	 * Column Info
	 * @return stoAmt
	 */
	public String getStoAmt() {
		return this.stoAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return otrAmt
	 */
	public String getOtrAmt() {
		return this.otrAmt;
	}
	
	/**
	 * Column Info
	 * @return vslKnt
	 */
	public String getVslKnt() {
		return this.vslKnt;
	}
	
	/**
	 * Column Info
	 * @return telAmt
	 */
	public String getTelAmt() {
		return this.telAmt;
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
	 * @return fFmyearmonth
	 */
	public String getFFmyearmonth() {
		return this.fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @return dhirAmt
	 */
	public String getDhirAmt() {
		return this.dhirAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrAmt
	 */
	public String getMnrAmt() {
		return this.mnrAmt;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return creAmt
	 */
	public String getCreAmt() {
		return this.creAmt;
	}
	
	/**
	 * Column Info
	 * @return fToyearmonth
	 */
	public String getFToyearmonth() {
		return this.fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @return preDhirAmt
	 */
	public String getPreDhirAmt() {
		return this.preDhirAmt;
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
	 * @return vslAmt
	 */
	public String getVslAmt() {
		return this.vslAmt;
	}
	
	/**
	 * Column Info
	 * @return timAmt
	 */
	public String getTimAmt() {
		return this.timAmt;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @param depAmt
	 */
	public void setDepAmt(String depAmt) {
		this.depAmt = depAmt;
	}
	
	/**
	 * Column Info
	 * @param insAmt
	 */
	public void setInsAmt(String insAmt) {
		this.insAmt = insAmt;
	}
	
	/**
	 * Column Info
	 * @param lubAmt
	 */
	public void setLubAmt(String lubAmt) {
		this.lubAmt = lubAmt;
	}
	
	/**
	 * Column Info
	 * @param stoAmt
	 */
	public void setStoAmt(String stoAmt) {
		this.stoAmt = stoAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param otrAmt
	 */
	public void setOtrAmt(String otrAmt) {
		this.otrAmt = otrAmt;
	}
	
	/**
	 * Column Info
	 * @param vslKnt
	 */
	public void setVslKnt(String vslKnt) {
		this.vslKnt = vslKnt;
	}
	
	/**
	 * Column Info
	 * @param telAmt
	 */
	public void setTelAmt(String telAmt) {
		this.telAmt = telAmt;
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
	 * @param fFmyearmonth
	 */
	public void setFFmyearmonth(String fFmyearmonth) {
		this.fFmyearmonth = fFmyearmonth;
	}
	
	/**
	 * Column Info
	 * @param dhirAmt
	 */
	public void setDhirAmt(String dhirAmt) {
		this.dhirAmt = dhirAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrAmt
	 */
	public void setMnrAmt(String mnrAmt) {
		this.mnrAmt = mnrAmt;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param creAmt
	 */
	public void setCreAmt(String creAmt) {
		this.creAmt = creAmt;
	}
	
	/**
	 * Column Info
	 * @param fToyearmonth
	 */
	public void setFToyearmonth(String fToyearmonth) {
		this.fToyearmonth = fToyearmonth;
	}
	
	/**
	 * Column Info
	 * @param preDhirAmt
	 */
	public void setPreDhirAmt(String preDhirAmt) {
		this.preDhirAmt = preDhirAmt;
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
	 * @param vslAmt
	 */
	public void setVslAmt(String vslAmt) {
		this.vslAmt = vslAmt;
	}
	
	/**
	 * Column Info
	 * @param timAmt
	 */
	public void setTimAmt(String timAmt) {
		this.timAmt = timAmt;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDepAmt(JSPUtil.getParameter(request, prefix + "dep_amt", ""));
		setInsAmt(JSPUtil.getParameter(request, prefix + "ins_amt", ""));
		setLubAmt(JSPUtil.getParameter(request, prefix + "lub_amt", ""));
		setStoAmt(JSPUtil.getParameter(request, prefix + "sto_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setOtrAmt(JSPUtil.getParameter(request, prefix + "otr_amt", ""));
		setVslKnt(JSPUtil.getParameter(request, prefix + "vsl_knt", ""));
		setTelAmt(JSPUtil.getParameter(request, prefix + "tel_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFFmyearmonth(JSPUtil.getParameter(request, prefix + "f_fmyearmonth", ""));
		setDhirAmt(JSPUtil.getParameter(request, prefix + "dhir_amt", ""));
		setMnrAmt(JSPUtil.getParameter(request, prefix + "mnr_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCreAmt(JSPUtil.getParameter(request, prefix + "cre_amt", ""));
		setFToyearmonth(JSPUtil.getParameter(request, prefix + "f_toyearmonth", ""));
		setPreDhirAmt(JSPUtil.getParameter(request, prefix + "pre_dhir_amt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setVslAmt(JSPUtil.getParameter(request, prefix + "vsl_amt", ""));
		setTimAmt(JSPUtil.getParameter(request, prefix + "tim_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageUCVesselVO[]
	 */
	public AverageUCVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageUCVesselVO[]
	 */
	public AverageUCVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageUCVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] depAmt = (JSPUtil.getParameter(request, prefix	+ "dep_amt", length));
			String[] insAmt = (JSPUtil.getParameter(request, prefix	+ "ins_amt", length));
			String[] lubAmt = (JSPUtil.getParameter(request, prefix	+ "lub_amt", length));
			String[] stoAmt = (JSPUtil.getParameter(request, prefix	+ "sto_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] otrAmt = (JSPUtil.getParameter(request, prefix	+ "otr_amt", length));
			String[] vslKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_knt", length));
			String[] telAmt = (JSPUtil.getParameter(request, prefix	+ "tel_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fFmyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_fmyearmonth", length));
			String[] dhirAmt = (JSPUtil.getParameter(request, prefix	+ "dhir_amt", length));
			String[] mnrAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] creAmt = (JSPUtil.getParameter(request, prefix	+ "cre_amt", length));
			String[] fToyearmonth = (JSPUtil.getParameter(request, prefix	+ "f_toyearmonth", length));
			String[] preDhirAmt = (JSPUtil.getParameter(request, prefix	+ "pre_dhir_amt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] vslAmt = (JSPUtil.getParameter(request, prefix	+ "vsl_amt", length));
			String[] timAmt = (JSPUtil.getParameter(request, prefix	+ "tim_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageUCVesselVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (depAmt[i] != null)
					model.setDepAmt(depAmt[i]);
				if (insAmt[i] != null)
					model.setInsAmt(insAmt[i]);
				if (lubAmt[i] != null)
					model.setLubAmt(lubAmt[i]);
				if (stoAmt[i] != null)
					model.setStoAmt(stoAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (otrAmt[i] != null)
					model.setOtrAmt(otrAmt[i]);
				if (vslKnt[i] != null)
					model.setVslKnt(vslKnt[i]);
				if (telAmt[i] != null)
					model.setTelAmt(telAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fFmyearmonth[i] != null)
					model.setFFmyearmonth(fFmyearmonth[i]);
				if (dhirAmt[i] != null)
					model.setDhirAmt(dhirAmt[i]);
				if (mnrAmt[i] != null)
					model.setMnrAmt(mnrAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (creAmt[i] != null)
					model.setCreAmt(creAmt[i]);
				if (fToyearmonth[i] != null)
					model.setFToyearmonth(fToyearmonth[i]);
				if (preDhirAmt[i] != null)
					model.setPreDhirAmt(preDhirAmt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (vslAmt[i] != null)
					model.setVslAmt(vslAmt[i]);
				if (timAmt[i] != null)
					model.setTimAmt(timAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageUCVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageUCVesselVO[]
	 */
	public AverageUCVesselVO[] getAverageUCVesselVOs(){
		AverageUCVesselVO[] vos = (AverageUCVesselVO[])models.toArray(new AverageUCVesselVO[models.size()]);
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
		this.depAmt = this.depAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insAmt = this.insAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lubAmt = this.lubAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoAmt = this.stoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrAmt = this.otrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKnt = this.vslKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telAmt = this.telAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmyearmonth = this.fFmyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhirAmt = this.dhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAmt = this.mnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creAmt = this.creAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToyearmonth = this.fToyearmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDhirAmt = this.preDhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAmt = this.vslAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.timAmt = this.timAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
