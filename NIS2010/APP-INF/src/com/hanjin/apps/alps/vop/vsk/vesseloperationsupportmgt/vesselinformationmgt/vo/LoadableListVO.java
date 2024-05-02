/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LoadableListVO.java
*@FileTitle : LoadableListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07  
* 1.0 Creation
*
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LoadableListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadableListVO> models = new ArrayList<LoadableListVO>();
	
	/* Column Info */
	private String hdHulTtlWgt = null;
	/* Column Info */
	private String hcXcldBsaQty = null;
	/* Column Info */
	private String ttlBsaWgt = null;
	/* Column Info */
	private String hdHulHcDeckQty = null;
	/* Column Info */
	private String hdHulHcXcldQty = null;
	/* Column Info */
	private String bakHulHcInclQty = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String bakHulTtlWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bakHulActUtWgt = null;
	/* Column Info */
	private String ctrtBsaUtWgt = null;
	/* Column Info */
	private String actBsaUtWgt = null;
	/* Column Info */
	private String hcInclBsaQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bakHulHcDeckQty = null;
	/* Column Info */
	private String bakHulHcXcldQty = null;
	/* Column Info */
	private String hdHulHcInclQty = null;
	/* Column Info */
	private String hdHulHcHldQty = null;
	/* Column Info */
	private String hdHulActUtWgt = null;
	/* Column Info */
	private String bakHulHcHldQty = null;
	/* Column Info */
	private String vslSlanCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadableListVO() {}

	public LoadableListVO(String ibflag, String pagerows, String vslSlanCd, String hcInclBsaQty, String hcXcldBsaQty, String ctrtBsaUtWgt, String actBsaUtWgt, String ttlBsaWgt, String hdHulHcHldQty, String hdHulHcDeckQty, String hdHulHcInclQty, String hdHulHcXcldQty, String hdHulActUtWgt, String hdHulTtlWgt, String bakHulHcHldQty, String bakHulHcDeckQty, String bakHulHcInclQty, String bakHulHcXcldQty, String bakHulActUtWgt, String bakHulTtlWgt, String vslSlanCtnt) {
		this.hdHulTtlWgt = hdHulTtlWgt;
		this.hcXcldBsaQty = hcXcldBsaQty;
		this.ttlBsaWgt = ttlBsaWgt;
		this.hdHulHcDeckQty = hdHulHcDeckQty;
		this.hdHulHcXcldQty = hdHulHcXcldQty;
		this.bakHulHcInclQty = bakHulHcInclQty;
		this.vslSlanCd = vslSlanCd;
		this.bakHulTtlWgt = bakHulTtlWgt;
		this.pagerows = pagerows;
		this.bakHulActUtWgt = bakHulActUtWgt;
		this.ctrtBsaUtWgt = ctrtBsaUtWgt;
		this.actBsaUtWgt = actBsaUtWgt;
		this.hcInclBsaQty = hcInclBsaQty;
		this.ibflag = ibflag;
		this.bakHulHcDeckQty = bakHulHcDeckQty;
		this.bakHulHcXcldQty = bakHulHcXcldQty;
		this.hdHulHcInclQty = hdHulHcInclQty;
		this.hdHulHcHldQty = hdHulHcHldQty;
		this.hdHulActUtWgt = hdHulActUtWgt;
		this.bakHulHcHldQty = bakHulHcHldQty;
		this.vslSlanCtnt = vslSlanCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hd_hul_ttl_wgt", getHdHulTtlWgt());
		this.hashColumns.put("hc_xcld_bsa_qty", getHcXcldBsaQty());
		this.hashColumns.put("ttl_bsa_wgt", getTtlBsaWgt());
		this.hashColumns.put("hd_hul_hc_deck_qty", getHdHulHcDeckQty());
		this.hashColumns.put("hd_hul_hc_xcld_qty", getHdHulHcXcldQty());
		this.hashColumns.put("bak_hul_hc_incl_qty", getBakHulHcInclQty());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("bak_hul_ttl_wgt", getBakHulTtlWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bak_hul_act_ut_wgt", getBakHulActUtWgt());
		this.hashColumns.put("ctrt_bsa_ut_wgt", getCtrtBsaUtWgt());
		this.hashColumns.put("act_bsa_ut_wgt", getActBsaUtWgt());
		this.hashColumns.put("hc_incl_bsa_qty", getHcInclBsaQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bak_hul_hc_deck_qty", getBakHulHcDeckQty());
		this.hashColumns.put("bak_hul_hc_xcld_qty", getBakHulHcXcldQty());
		this.hashColumns.put("hd_hul_hc_incl_qty", getHdHulHcInclQty());
		this.hashColumns.put("hd_hul_hc_hld_qty", getHdHulHcHldQty());
		this.hashColumns.put("hd_hul_act_ut_wgt", getHdHulActUtWgt());
		this.hashColumns.put("bak_hul_hc_hld_qty", getBakHulHcHldQty());
		this.hashColumns.put("vsl_slan_ctnt", getVslSlanCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hd_hul_ttl_wgt", "hdHulTtlWgt");
		this.hashFields.put("hc_xcld_bsa_qty", "hcXcldBsaQty");
		this.hashFields.put("ttl_bsa_wgt", "ttlBsaWgt");
		this.hashFields.put("hd_hul_hc_deck_qty", "hdHulHcDeckQty");
		this.hashFields.put("hd_hul_hc_xcld_qty", "hdHulHcXcldQty");
		this.hashFields.put("bak_hul_hc_incl_qty", "bakHulHcInclQty");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("bak_hul_ttl_wgt", "bakHulTtlWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bak_hul_act_ut_wgt", "bakHulActUtWgt");
		this.hashFields.put("ctrt_bsa_ut_wgt", "ctrtBsaUtWgt");
		this.hashFields.put("act_bsa_ut_wgt", "actBsaUtWgt");
		this.hashFields.put("hc_incl_bsa_qty", "hcInclBsaQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bak_hul_hc_deck_qty", "bakHulHcDeckQty");
		this.hashFields.put("bak_hul_hc_xcld_qty", "bakHulHcXcldQty");
		this.hashFields.put("hd_hul_hc_incl_qty", "hdHulHcInclQty");
		this.hashFields.put("hd_hul_hc_hld_qty", "hdHulHcHldQty");
		this.hashFields.put("hd_hul_act_ut_wgt", "hdHulActUtWgt");
		this.hashFields.put("bak_hul_hc_hld_qty", "bakHulHcHldQty");
		this.hashFields.put("vsl_slan_ctnt", "vslSlanCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdHulTtlWgt
	 */
	public String getHdHulTtlWgt() {
		return this.hdHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return hcXcldBsaQty
	 */
	public String getHcXcldBsaQty() {
		return this.hcXcldBsaQty;
	}
	
	/**
	 * Column Info
	 * @return ttlBsaWgt
	 */
	public String getTtlBsaWgt() {
		return this.ttlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcDeckQty
	 */
	public String getHdHulHcDeckQty() {
		return this.hdHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcXcldQty
	 */
	public String getHdHulHcXcldQty() {
		return this.hdHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulHcInclQty
	 */
	public String getBakHulHcInclQty() {
		return this.bakHulHcInclQty;
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
	 * @return bakHulTtlWgt
	 */
	public String getBakHulTtlWgt() {
		return this.bakHulTtlWgt;
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
	 * @return bakHulActUtWgt
	 */
	public String getBakHulActUtWgt() {
		return this.bakHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @return ctrtBsaUtWgt
	 */
	public String getCtrtBsaUtWgt() {
		return this.ctrtBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @return actBsaUtWgt
	 */
	public String getActBsaUtWgt() {
		return this.actBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @return hcInclBsaQty
	 */
	public String getHcInclBsaQty() {
		return this.hcInclBsaQty;
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
	 * @return bakHulHcDeckQty
	 */
	public String getBakHulHcDeckQty() {
		return this.bakHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @return bakHulHcXcldQty
	 */
	public String getBakHulHcXcldQty() {
		return this.bakHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcInclQty
	 */
	public String getHdHulHcInclQty() {
		return this.hdHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulHcHldQty
	 */
	public String getHdHulHcHldQty() {
		return this.hdHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @return hdHulActUtWgt
	 */
	public String getHdHulActUtWgt() {
		return this.hdHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @return bakHulHcHldQty
	 */
	public String getBakHulHcHldQty() {
		return this.bakHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCtnt
	 */
	public String getVslSlanCtnt() {
		return this.vslSlanCtnt;
	}
	

	/**
	 * Column Info
	 * @param hdHulTtlWgt
	 */
	public void setHdHulTtlWgt(String hdHulTtlWgt) {
		this.hdHulTtlWgt = hdHulTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param hcXcldBsaQty
	 */
	public void setHcXcldBsaQty(String hcXcldBsaQty) {
		this.hcXcldBsaQty = hcXcldBsaQty;
	}
	
	/**
	 * Column Info
	 * @param ttlBsaWgt
	 */
	public void setTtlBsaWgt(String ttlBsaWgt) {
		this.ttlBsaWgt = ttlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcDeckQty
	 */
	public void setHdHulHcDeckQty(String hdHulHcDeckQty) {
		this.hdHulHcDeckQty = hdHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcXcldQty
	 */
	public void setHdHulHcXcldQty(String hdHulHcXcldQty) {
		this.hdHulHcXcldQty = hdHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulHcInclQty
	 */
	public void setBakHulHcInclQty(String bakHulHcInclQty) {
		this.bakHulHcInclQty = bakHulHcInclQty;
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
	 * @param bakHulTtlWgt
	 */
	public void setBakHulTtlWgt(String bakHulTtlWgt) {
		this.bakHulTtlWgt = bakHulTtlWgt;
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
	 * @param bakHulActUtWgt
	 */
	public void setBakHulActUtWgt(String bakHulActUtWgt) {
		this.bakHulActUtWgt = bakHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @param ctrtBsaUtWgt
	 */
	public void setCtrtBsaUtWgt(String ctrtBsaUtWgt) {
		this.ctrtBsaUtWgt = ctrtBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @param actBsaUtWgt
	 */
	public void setActBsaUtWgt(String actBsaUtWgt) {
		this.actBsaUtWgt = actBsaUtWgt;
	}
	
	/**
	 * Column Info
	 * @param hcInclBsaQty
	 */
	public void setHcInclBsaQty(String hcInclBsaQty) {
		this.hcInclBsaQty = hcInclBsaQty;
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
	 * @param bakHulHcDeckQty
	 */
	public void setBakHulHcDeckQty(String bakHulHcDeckQty) {
		this.bakHulHcDeckQty = bakHulHcDeckQty;
	}
	
	/**
	 * Column Info
	 * @param bakHulHcXcldQty
	 */
	public void setBakHulHcXcldQty(String bakHulHcXcldQty) {
		this.bakHulHcXcldQty = bakHulHcXcldQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcInclQty
	 */
	public void setHdHulHcInclQty(String hdHulHcInclQty) {
		this.hdHulHcInclQty = hdHulHcInclQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulHcHldQty
	 */
	public void setHdHulHcHldQty(String hdHulHcHldQty) {
		this.hdHulHcHldQty = hdHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @param hdHulActUtWgt
	 */
	public void setHdHulActUtWgt(String hdHulActUtWgt) {
		this.hdHulActUtWgt = hdHulActUtWgt;
	}
	
	/**
	 * Column Info
	 * @param bakHulHcHldQty
	 */
	public void setBakHulHcHldQty(String bakHulHcHldQty) {
		this.bakHulHcHldQty = bakHulHcHldQty;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCtnt
	 */
	public void setVslSlanCtnt(String vslSlanCtnt) {
		this.vslSlanCtnt = vslSlanCtnt;
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
		setHdHulTtlWgt(JSPUtil.getParameter(request, prefix + "hd_hul_ttl_wgt", ""));
		setHcXcldBsaQty(JSPUtil.getParameter(request, prefix + "hc_xcld_bsa_qty", ""));
		setTtlBsaWgt(JSPUtil.getParameter(request, prefix + "ttl_bsa_wgt", ""));
		setHdHulHcDeckQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_deck_qty", ""));
		setHdHulHcXcldQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_xcld_qty", ""));
		setBakHulHcInclQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_incl_qty", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setBakHulTtlWgt(JSPUtil.getParameter(request, prefix + "bak_hul_ttl_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBakHulActUtWgt(JSPUtil.getParameter(request, prefix + "bak_hul_act_ut_wgt", ""));
		setCtrtBsaUtWgt(JSPUtil.getParameter(request, prefix + "ctrt_bsa_ut_wgt", ""));
		setActBsaUtWgt(JSPUtil.getParameter(request, prefix + "act_bsa_ut_wgt", ""));
		setHcInclBsaQty(JSPUtil.getParameter(request, prefix + "hc_incl_bsa_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBakHulHcDeckQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_deck_qty", ""));
		setBakHulHcXcldQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_xcld_qty", ""));
		setHdHulHcInclQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_incl_qty", ""));
		setHdHulHcHldQty(JSPUtil.getParameter(request, prefix + "hd_hul_hc_hld_qty", ""));
		setHdHulActUtWgt(JSPUtil.getParameter(request, prefix + "hd_hul_act_ut_wgt", ""));
		setBakHulHcHldQty(JSPUtil.getParameter(request, prefix + "bak_hul_hc_hld_qty", ""));
		setVslSlanCtnt(JSPUtil.getParameter(request, prefix + "vsl_slan_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadableListVO[]
	 */
	public LoadableListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadableListVO[]
	 */
	public LoadableListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadableListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdHulTtlWgt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_ttl_wgt", length));
			String[] hcXcldBsaQty = (JSPUtil.getParameter(request, prefix	+ "hc_xcld_bsa_qty", length));
			String[] ttlBsaWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_bsa_wgt", length));
			String[] hdHulHcDeckQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_deck_qty", length));
			String[] hdHulHcXcldQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_xcld_qty", length));
			String[] bakHulHcInclQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_incl_qty", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] bakHulTtlWgt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_ttl_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bakHulActUtWgt = (JSPUtil.getParameter(request, prefix	+ "bak_hul_act_ut_wgt", length));
			String[] ctrtBsaUtWgt = (JSPUtil.getParameter(request, prefix	+ "ctrt_bsa_ut_wgt", length));
			String[] actBsaUtWgt = (JSPUtil.getParameter(request, prefix	+ "act_bsa_ut_wgt", length));
			String[] hcInclBsaQty = (JSPUtil.getParameter(request, prefix	+ "hc_incl_bsa_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bakHulHcDeckQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_deck_qty", length));
			String[] bakHulHcXcldQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_xcld_qty", length));
			String[] hdHulHcInclQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_incl_qty", length));
			String[] hdHulHcHldQty = (JSPUtil.getParameter(request, prefix	+ "hd_hul_hc_hld_qty", length));
			String[] hdHulActUtWgt = (JSPUtil.getParameter(request, prefix	+ "hd_hul_act_ut_wgt", length));
			String[] bakHulHcHldQty = (JSPUtil.getParameter(request, prefix	+ "bak_hul_hc_hld_qty", length));
			String[] vslSlanCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadableListVO();
				if (hdHulTtlWgt[i] != null)
					model.setHdHulTtlWgt(hdHulTtlWgt[i]);
				if (hcXcldBsaQty[i] != null)
					model.setHcXcldBsaQty(hcXcldBsaQty[i]);
				if (ttlBsaWgt[i] != null)
					model.setTtlBsaWgt(ttlBsaWgt[i]);
				if (hdHulHcDeckQty[i] != null)
					model.setHdHulHcDeckQty(hdHulHcDeckQty[i]);
				if (hdHulHcXcldQty[i] != null)
					model.setHdHulHcXcldQty(hdHulHcXcldQty[i]);
				if (bakHulHcInclQty[i] != null)
					model.setBakHulHcInclQty(bakHulHcInclQty[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (bakHulTtlWgt[i] != null)
					model.setBakHulTtlWgt(bakHulTtlWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bakHulActUtWgt[i] != null)
					model.setBakHulActUtWgt(bakHulActUtWgt[i]);
				if (ctrtBsaUtWgt[i] != null)
					model.setCtrtBsaUtWgt(ctrtBsaUtWgt[i]);
				if (actBsaUtWgt[i] != null)
					model.setActBsaUtWgt(actBsaUtWgt[i]);
				if (hcInclBsaQty[i] != null)
					model.setHcInclBsaQty(hcInclBsaQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bakHulHcDeckQty[i] != null)
					model.setBakHulHcDeckQty(bakHulHcDeckQty[i]);
				if (bakHulHcXcldQty[i] != null)
					model.setBakHulHcXcldQty(bakHulHcXcldQty[i]);
				if (hdHulHcInclQty[i] != null)
					model.setHdHulHcInclQty(hdHulHcInclQty[i]);
				if (hdHulHcHldQty[i] != null)
					model.setHdHulHcHldQty(hdHulHcHldQty[i]);
				if (hdHulActUtWgt[i] != null)
					model.setHdHulActUtWgt(hdHulActUtWgt[i]);
				if (bakHulHcHldQty[i] != null)
					model.setBakHulHcHldQty(bakHulHcHldQty[i]);
				if (vslSlanCtnt[i] != null)
					model.setVslSlanCtnt(vslSlanCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadableListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadableListVO[]
	 */
	public LoadableListVO[] getLoadableListVOs(){
		LoadableListVO[] vos = (LoadableListVO[])models.toArray(new LoadableListVO[models.size()]);
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
		this.hdHulTtlWgt = this.hdHulTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcXcldBsaQty = this.hcXcldBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBsaWgt = this.ttlBsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcDeckQty = this.hdHulHcDeckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcXcldQty = this.hdHulHcXcldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcInclQty = this.bakHulHcInclQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulTtlWgt = this.bakHulTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulActUtWgt = this.bakHulActUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtBsaUtWgt = this.ctrtBsaUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaUtWgt = this.actBsaUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcInclBsaQty = this.hcInclBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcDeckQty = this.bakHulHcDeckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcXcldQty = this.bakHulHcXcldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcInclQty = this.hdHulHcInclQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulHcHldQty = this.hdHulHcHldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdHulActUtWgt = this.hdHulActUtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bakHulHcHldQty = this.bakHulHcHldQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCtnt = this.vslSlanCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
