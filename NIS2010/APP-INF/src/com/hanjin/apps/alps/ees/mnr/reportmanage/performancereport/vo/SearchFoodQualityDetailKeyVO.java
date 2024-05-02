/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchFoodQualityDetailKeyVO.java
*@FileTitle : SearchFoodQualityDetailKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFoodQualityDetailKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFoodQualityDetailKeyVO> models = new ArrayList<SearchFoodQualityDetailKeyVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String mrdQty = null;
	/* Column Info */
	private String lcc = null;
	/* Column Info */
	private String mrdHour = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String containerNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String division = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String component = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String mrdType = null;
	/* Column Info */
	private String repair = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String serviceProviderName = null;
	/* Column Info */
	private String damage = null;
	/* Column Info */
	private String mrdAmount = null;
	/* Column Info */
	private String material = null;
	/* Column Info */
	private String scc = null;
	/* Column Info */
	private String mrdCost = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String mrdSizeSquare = null;
	/* Column Info */
	private String rcc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchFoodQualityDetailKeyVO() {}

	public SearchFoodQualityDetailKeyVO(String ibflag, String pagerows, String rqstEqNo, String rprRqstSeq, String rprRqstVerNo, String seq, String woNo, String serviceProviderName, String containerNo, String tpSz, String term, String rcc, String lcc, String scc, String yard, String location, String component, String damage, String repair, String division, String mrdType, String mrdQty, String mrdSizeSquare, String mrdHour, String rate, String mrdCost, String material, String mrdAmount, String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.yard = yard;
		this.rprRqstVerNo = rprRqstVerNo;
		this.location = location;
		this.mrdQty = mrdQty;
		this.lcc = lcc;
		this.mrdHour = mrdHour;
		this.pagerows = pagerows;
		this.containerNo = containerNo;
		this.ibflag = ibflag;
		this.division = division;
		this.rate = rate;
		this.rqstEqNo = rqstEqNo;
		this.component = component;
		this.woNo = woNo;
		this.mrdType = mrdType;
		this.repair = repair;
		this.rprRqstSeq = rprRqstSeq;
		this.tpSz = tpSz;
		this.serviceProviderName = serviceProviderName;
		this.damage = damage;
		this.mrdAmount = mrdAmount;
		this.material = material;
		this.scc = scc;
		this.mrdCost = mrdCost;
		this.term = term;
		this.seq = seq;
		this.mrdSizeSquare = mrdSizeSquare;
		this.rcc = rcc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("mrd_qty", getMrdQty());
		this.hashColumns.put("lcc", getLcc());
		this.hashColumns.put("mrd_hour", getMrdHour());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("container_no", getContainerNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("division", getDivision());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("component", getComponent());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("mrd_type", getMrdType());
		this.hashColumns.put("repair", getRepair());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("service_provider_name", getServiceProviderName());
		this.hashColumns.put("damage", getDamage());
		this.hashColumns.put("mrd_amount", getMrdAmount());
		this.hashColumns.put("material", getMaterial());
		this.hashColumns.put("scc", getScc());
		this.hashColumns.put("mrd_cost", getMrdCost());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("mrd_size_square", getMrdSizeSquare());
		this.hashColumns.put("rcc", getRcc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("location", "location");
		this.hashFields.put("mrd_qty", "mrdQty");
		this.hashFields.put("lcc", "lcc");
		this.hashFields.put("mrd_hour", "mrdHour");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("container_no", "containerNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("division", "division");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("component", "component");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mrd_type", "mrdType");
		this.hashFields.put("repair", "repair");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("service_provider_name", "serviceProviderName");
		this.hashFields.put("damage", "damage");
		this.hashFields.put("mrd_amount", "mrdAmount");
		this.hashFields.put("material", "material");
		this.hashFields.put("scc", "scc");
		this.hashFields.put("mrd_cost", "mrdCost");
		this.hashFields.put("term", "term");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("mrd_size_square", "mrdSizeSquare");
		this.hashFields.put("rcc", "rcc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return mrdQty
	 */
	public String getMrdQty() {
		return this.mrdQty;
	}
	
	/**
	 * Column Info
	 * @return lcc
	 */
	public String getLcc() {
		return this.lcc;
	}
	
	/**
	 * Column Info
	 * @return mrdHour
	 */
	public String getMrdHour() {
		return this.mrdHour;
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
	 * @return containerNo
	 */
	public String getContainerNo() {
		return this.containerNo;
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
	 * @return division
	 */
	public String getDivision() {
		return this.division;
	}
	
	/**
	 * Column Info
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return component
	 */
	public String getComponent() {
		return this.component;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return mrdType
	 */
	public String getMrdType() {
		return this.mrdType;
	}
	
	/**
	 * Column Info
	 * @return repair
	 */
	public String getRepair() {
		return this.repair;
	}
	
	/**
	 * Column Info
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return serviceProviderName
	 */
	public String getServiceProviderName() {
		return this.serviceProviderName;
	}
	
	/**
	 * Column Info
	 * @return damage
	 */
	public String getDamage() {
		return this.damage;
	}
	
	/**
	 * Column Info
	 * @return mrdAmount
	 */
	public String getMrdAmount() {
		return this.mrdAmount;
	}
	
	/**
	 * Column Info
	 * @return material
	 */
	public String getMaterial() {
		return this.material;
	}
	
	/**
	 * Column Info
	 * @return scc
	 */
	public String getScc() {
		return this.scc;
	}
	
	/**
	 * Column Info
	 * @return mrdCost
	 */
	public String getMrdCost() {
		return this.mrdCost;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return mrdSizeSquare
	 */
	public String getMrdSizeSquare() {
		return this.mrdSizeSquare;
	}
	
	/**
	 * Column Info
	 * @return rcc
	 */
	public String getRcc() {
		return this.rcc;
	}
	

	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param mrdQty
	 */
	public void setMrdQty(String mrdQty) {
		this.mrdQty = mrdQty;
	}
	
	/**
	 * Column Info
	 * @param lcc
	 */
	public void setLcc(String lcc) {
		this.lcc = lcc;
	}
	
	/**
	 * Column Info
	 * @param mrdHour
	 */
	public void setMrdHour(String mrdHour) {
		this.mrdHour = mrdHour;
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
	 * @param containerNo
	 */
	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
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
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * Column Info
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param component
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param mrdType
	 */
	public void setMrdType(String mrdType) {
		this.mrdType = mrdType;
	}
	
	/**
	 * Column Info
	 * @param repair
	 */
	public void setRepair(String repair) {
		this.repair = repair;
	}
	
	/**
	 * Column Info
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param serviceProviderName
	 */
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	
	/**
	 * Column Info
	 * @param damage
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}
	
	/**
	 * Column Info
	 * @param mrdAmount
	 */
	public void setMrdAmount(String mrdAmount) {
		this.mrdAmount = mrdAmount;
	}
	
	/**
	 * Column Info
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	
	/**
	 * Column Info
	 * @param scc
	 */
	public void setScc(String scc) {
		this.scc = scc;
	}
	
	/**
	 * Column Info
	 * @param mrdCost
	 */
	public void setMrdCost(String mrdCost) {
		this.mrdCost = mrdCost;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param mrdSizeSquare
	 */
	public void setMrdSizeSquare(String mrdSizeSquare) {
		this.mrdSizeSquare = mrdSizeSquare;
	}
	
	/**
	 * Column Info
	 * @param rcc
	 */
	public void setRcc(String rcc) {
		this.rcc = rcc;
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
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setYard(JSPUtil.getParameter(request, prefix + "yard", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setMrdQty(JSPUtil.getParameter(request, prefix + "mrd_qty", ""));
		setLcc(JSPUtil.getParameter(request, prefix + "lcc", ""));
		setMrdHour(JSPUtil.getParameter(request, prefix + "mrd_hour", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setContainerNo(JSPUtil.getParameter(request, prefix + "container_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDivision(JSPUtil.getParameter(request, prefix + "division", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setComponent(JSPUtil.getParameter(request, prefix + "component", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMrdType(JSPUtil.getParameter(request, prefix + "mrd_type", ""));
		setRepair(JSPUtil.getParameter(request, prefix + "repair", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setServiceProviderName(JSPUtil.getParameter(request, prefix + "service_provider_name", ""));
		setDamage(JSPUtil.getParameter(request, prefix + "damage", ""));
		setMrdAmount(JSPUtil.getParameter(request, prefix + "mrd_amount", ""));
		setMaterial(JSPUtil.getParameter(request, prefix + "material", ""));
		setScc(JSPUtil.getParameter(request, prefix + "scc", ""));
		setMrdCost(JSPUtil.getParameter(request, prefix + "mrd_cost", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setMrdSizeSquare(JSPUtil.getParameter(request, prefix + "mrd_size_square", ""));
		setRcc(JSPUtil.getParameter(request, prefix + "rcc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFoodQualityDetailKeyVO[]
	 */
	public SearchFoodQualityDetailKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFoodQualityDetailKeyVO[]
	 */
	public SearchFoodQualityDetailKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFoodQualityDetailKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] mrdQty = (JSPUtil.getParameter(request, prefix	+ "mrd_qty", length));
			String[] lcc = (JSPUtil.getParameter(request, prefix	+ "lcc", length));
			String[] mrdHour = (JSPUtil.getParameter(request, prefix	+ "mrd_hour", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] containerNo = (JSPUtil.getParameter(request, prefix	+ "container_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] division = (JSPUtil.getParameter(request, prefix	+ "division", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] component = (JSPUtil.getParameter(request, prefix	+ "component", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] mrdType = (JSPUtil.getParameter(request, prefix	+ "mrd_type", length));
			String[] repair = (JSPUtil.getParameter(request, prefix	+ "repair", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] serviceProviderName = (JSPUtil.getParameter(request, prefix	+ "service_provider_name", length));
			String[] damage = (JSPUtil.getParameter(request, prefix	+ "damage", length));
			String[] mrdAmount = (JSPUtil.getParameter(request, prefix	+ "mrd_amount", length));
			String[] material = (JSPUtil.getParameter(request, prefix	+ "material", length));
			String[] scc = (JSPUtil.getParameter(request, prefix	+ "scc", length));
			String[] mrdCost = (JSPUtil.getParameter(request, prefix	+ "mrd_cost", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] mrdSizeSquare = (JSPUtil.getParameter(request, prefix	+ "mrd_size_square", length));
			String[] rcc = (JSPUtil.getParameter(request, prefix	+ "rcc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFoodQualityDetailKeyVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (mrdQty[i] != null)
					model.setMrdQty(mrdQty[i]);
				if (lcc[i] != null)
					model.setLcc(lcc[i]);
				if (mrdHour[i] != null)
					model.setMrdHour(mrdHour[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (containerNo[i] != null)
					model.setContainerNo(containerNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (division[i] != null)
					model.setDivision(division[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (component[i] != null)
					model.setComponent(component[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (mrdType[i] != null)
					model.setMrdType(mrdType[i]);
				if (repair[i] != null)
					model.setRepair(repair[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (serviceProviderName[i] != null)
					model.setServiceProviderName(serviceProviderName[i]);
				if (damage[i] != null)
					model.setDamage(damage[i]);
				if (mrdAmount[i] != null)
					model.setMrdAmount(mrdAmount[i]);
				if (material[i] != null)
					model.setMaterial(material[i]);
				if (scc[i] != null)
					model.setScc(scc[i]);
				if (mrdCost[i] != null)
					model.setMrdCost(mrdCost[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (mrdSizeSquare[i] != null)
					model.setMrdSizeSquare(mrdSizeSquare[i]);
				if (rcc[i] != null)
					model.setRcc(rcc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFoodQualityDetailKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFoodQualityDetailKeyVO[]
	 */
	public SearchFoodQualityDetailKeyVO[] getSearchFoodQualityDetailKeyVOs(){
		SearchFoodQualityDetailKeyVO[] vos = (SearchFoodQualityDetailKeyVO[])models.toArray(new SearchFoodQualityDetailKeyVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdQty = this.mrdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcc = this.lcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdHour = this.mrdHour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.containerNo = this.containerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.division = this.division .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.component = this.component .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdType = this.mrdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repair = this.repair .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceProviderName = this.serviceProviderName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damage = this.damage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdAmount = this.mrdAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.material = this.material .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scc = this.scc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdCost = this.mrdCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdSizeSquare = this.mrdSizeSquare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcc = this.rcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
