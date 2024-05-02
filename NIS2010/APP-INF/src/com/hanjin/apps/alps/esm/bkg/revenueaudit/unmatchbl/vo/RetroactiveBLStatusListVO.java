/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RetroactiveBLStatusListVO.java
*@FileTitle : RetroactiveBLStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.07.28 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RetroactiveBLStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RetroactiveBLStatusListVO> models = new ArrayList<RetroactiveBLStatusListVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String n2wkCtrtCnt = null;
	/* Column Info */
	private String n4wkBkgCnt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String ttlCtrtCnt = null;
	/* Column Info */
	private String n6wkBkgCnt = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String n1wkCtrtCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ttlBkgCnt = null;
	/* Column Info */
	private String n5wkBkgCnt = null;
	/* Column Info */
	private String n1wkBkgCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3wkCtrtCnt = null;
	/* Column Info */
	private String n3wkBkgCnt = null;
	/* Column Info */
	private String n2wkBkgCnt = null;
	/* Column Info */
	private String n5wkCtrtCnt = null;
	/* Column Info */
	private String n4wkCtrtCnt = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String n6wkCtrtCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RetroactiveBLStatusListVO() {}

	public RetroactiveBLStatusListVO(String ibflag, String pagerows, String rhqCd, String bkgOfcCd, String n1wkCtrtCnt, String n1wkBkgCnt, String n2wkCtrtCnt, String n2wkBkgCnt, String n3wkCtrtCnt, String n3wkBkgCnt, String n4wkCtrtCnt, String n4wkBkgCnt, String n5wkCtrtCnt, String n5wkBkgCnt, String n6wkCtrtCnt, String n6wkBkgCnt, String ttlBkgCnt, String ttlCtrtCnt, String bkgCtrtTpCd, String ofcTpCd, String bkgRhqCd, String fmDt, String toDt, String dateType) {
		this.bkgOfcCd = bkgOfcCd;
		this.n2wkCtrtCnt = n2wkCtrtCnt;
		this.n4wkBkgCnt = n4wkBkgCnt;
		this.fmDt = fmDt;
		this.rhqCd = rhqCd;
		this.bkgRhqCd = bkgRhqCd;
		this.ttlCtrtCnt = ttlCtrtCnt;
		this.n6wkBkgCnt = n6wkBkgCnt;
		this.dateType = dateType;
		this.n1wkCtrtCnt = n1wkCtrtCnt;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ttlBkgCnt = ttlBkgCnt;
		this.n5wkBkgCnt = n5wkBkgCnt;
		this.n1wkBkgCnt = n1wkBkgCnt;
		this.ibflag = ibflag;
		this.n3wkCtrtCnt = n3wkCtrtCnt;
		this.n3wkBkgCnt = n3wkBkgCnt;
		this.n2wkBkgCnt = n2wkBkgCnt;
		this.n5wkCtrtCnt = n5wkCtrtCnt;
		this.n4wkCtrtCnt = n4wkCtrtCnt;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.ofcTpCd = ofcTpCd;
		this.n6wkCtrtCnt = n6wkCtrtCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("n2wk_ctrt_cnt", getN2wkCtrtCnt());
		this.hashColumns.put("n4wk_bkg_cnt", getN4wkBkgCnt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("ttl_ctrt_cnt", getTtlCtrtCnt());
		this.hashColumns.put("n6wk_bkg_cnt", getN6wkBkgCnt());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("n1wk_ctrt_cnt", getN1wkCtrtCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ttl_bkg_cnt", getTtlBkgCnt());
		this.hashColumns.put("n5wk_bkg_cnt", getN5wkBkgCnt());
		this.hashColumns.put("n1wk_bkg_cnt", getN1wkBkgCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3wk_ctrt_cnt", getN3wkCtrtCnt());
		this.hashColumns.put("n3wk_bkg_cnt", getN3wkBkgCnt());
		this.hashColumns.put("n2wk_bkg_cnt", getN2wkBkgCnt());
		this.hashColumns.put("n5wk_ctrt_cnt", getN5wkCtrtCnt());
		this.hashColumns.put("n4wk_ctrt_cnt", getN4wkCtrtCnt());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("n6wk_ctrt_cnt", getN6wkCtrtCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("n2wk_ctrt_cnt", "n2wkCtrtCnt");
		this.hashFields.put("n4wk_bkg_cnt", "n4wkBkgCnt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("ttl_ctrt_cnt", "ttlCtrtCnt");
		this.hashFields.put("n6wk_bkg_cnt", "n6wkBkgCnt");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("n1wk_ctrt_cnt", "n1wkCtrtCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ttl_bkg_cnt", "ttlBkgCnt");
		this.hashFields.put("n5wk_bkg_cnt", "n5wkBkgCnt");
		this.hashFields.put("n1wk_bkg_cnt", "n1wkBkgCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3wk_ctrt_cnt", "n3wkCtrtCnt");
		this.hashFields.put("n3wk_bkg_cnt", "n3wkBkgCnt");
		this.hashFields.put("n2wk_bkg_cnt", "n2wkBkgCnt");
		this.hashFields.put("n5wk_ctrt_cnt", "n5wkCtrtCnt");
		this.hashFields.put("n4wk_ctrt_cnt", "n4wkCtrtCnt");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("n6wk_ctrt_cnt", "n6wkCtrtCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n2wkCtrtCnt
	 */
	public String getN2wkCtrtCnt() {
		return this.n2wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return n4wkBkgCnt
	 */
	public String getN4wkBkgCnt() {
		return this.n4wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return ttlCtrtCnt
	 */
	public String getTtlCtrtCnt() {
		return this.ttlCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return n6wkBkgCnt
	 */
	public String getN6wkBkgCnt() {
		return this.n6wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
	}
	
	/**
	 * Column Info
	 * @return n1wkCtrtCnt
	 */
	public String getN1wkCtrtCnt() {
		return this.n1wkCtrtCnt;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ttlBkgCnt
	 */
	public String getTtlBkgCnt() {
		return this.ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return n5wkBkgCnt
	 */
	public String getN5wkBkgCnt() {
		return this.n5wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return n1wkBkgCnt
	 */
	public String getN1wkBkgCnt() {
		return this.n1wkBkgCnt;
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
	 * @return n3wkCtrtCnt
	 */
	public String getN3wkCtrtCnt() {
		return this.n3wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return n3wkBkgCnt
	 */
	public String getN3wkBkgCnt() {
		return this.n3wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return n2wkBkgCnt
	 */
	public String getN2wkBkgCnt() {
		return this.n2wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return n5wkCtrtCnt
	 */
	public String getN5wkCtrtCnt() {
		return this.n5wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return n4wkCtrtCnt
	 */
	public String getN4wkCtrtCnt() {
		return this.n4wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return n6wkCtrtCnt
	 */
	public String getN6wkCtrtCnt() {
		return this.n6wkCtrtCnt;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n2wkCtrtCnt
	 */
	public void setN2wkCtrtCnt(String n2wkCtrtCnt) {
		this.n2wkCtrtCnt = n2wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param n4wkBkgCnt
	 */
	public void setN4wkBkgCnt(String n4wkBkgCnt) {
		this.n4wkBkgCnt = n4wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param ttlCtrtCnt
	 */
	public void setTtlCtrtCnt(String ttlCtrtCnt) {
		this.ttlCtrtCnt = ttlCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param n6wkBkgCnt
	 */
	public void setN6wkBkgCnt(String n6wkBkgCnt) {
		this.n6wkBkgCnt = n6wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	/**
	 * Column Info
	 * @param n1wkCtrtCnt
	 */
	public void setN1wkCtrtCnt(String n1wkCtrtCnt) {
		this.n1wkCtrtCnt = n1wkCtrtCnt;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ttlBkgCnt
	 */
	public void setTtlBkgCnt(String ttlBkgCnt) {
		this.ttlBkgCnt = ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param n5wkBkgCnt
	 */
	public void setN5wkBkgCnt(String n5wkBkgCnt) {
		this.n5wkBkgCnt = n5wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param n1wkBkgCnt
	 */
	public void setN1wkBkgCnt(String n1wkBkgCnt) {
		this.n1wkBkgCnt = n1wkBkgCnt;
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
	 * @param n3wkCtrtCnt
	 */
	public void setN3wkCtrtCnt(String n3wkCtrtCnt) {
		this.n3wkCtrtCnt = n3wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param n3wkBkgCnt
	 */
	public void setN3wkBkgCnt(String n3wkBkgCnt) {
		this.n3wkBkgCnt = n3wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param n2wkBkgCnt
	 */
	public void setN2wkBkgCnt(String n2wkBkgCnt) {
		this.n2wkBkgCnt = n2wkBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param n5wkCtrtCnt
	 */
	public void setN5wkCtrtCnt(String n5wkCtrtCnt) {
		this.n5wkCtrtCnt = n5wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param n4wkCtrtCnt
	 */
	public void setN4wkCtrtCnt(String n4wkCtrtCnt) {
		this.n4wkCtrtCnt = n4wkCtrtCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param n6wkCtrtCnt
	 */
	public void setN6wkCtrtCnt(String n6wkCtrtCnt) {
		this.n6wkCtrtCnt = n6wkCtrtCnt;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setN2wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n2wk_ctrt_cnt", ""));
		setN4wkBkgCnt(JSPUtil.getParameter(request, prefix + "n4wk_bkg_cnt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setTtlCtrtCnt(JSPUtil.getParameter(request, prefix + "ttl_ctrt_cnt", ""));
		setN6wkBkgCnt(JSPUtil.getParameter(request, prefix + "n6wk_bkg_cnt", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setN1wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n1wk_ctrt_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTtlBkgCnt(JSPUtil.getParameter(request, prefix + "ttl_bkg_cnt", ""));
		setN5wkBkgCnt(JSPUtil.getParameter(request, prefix + "n5wk_bkg_cnt", ""));
		setN1wkBkgCnt(JSPUtil.getParameter(request, prefix + "n1wk_bkg_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN3wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n3wk_ctrt_cnt", ""));
		setN3wkBkgCnt(JSPUtil.getParameter(request, prefix + "n3wk_bkg_cnt", ""));
		setN2wkBkgCnt(JSPUtil.getParameter(request, prefix + "n2wk_bkg_cnt", ""));
		setN5wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n5wk_ctrt_cnt", ""));
		setN4wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n4wk_ctrt_cnt", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setN6wkCtrtCnt(JSPUtil.getParameter(request, prefix + "n6wk_ctrt_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RetroactiveBLStatusListVO[]
	 */
	public RetroactiveBLStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RetroactiveBLStatusListVO[]
	 */
	public RetroactiveBLStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RetroactiveBLStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] n2wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n2wk_ctrt_cnt", length));
			String[] n4wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n4wk_bkg_cnt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] ttlCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_ctrt_cnt", length));
			String[] n6wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n6wk_bkg_cnt", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] n1wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n1wk_ctrt_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ttlBkgCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg_cnt", length));
			String[] n5wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n5wk_bkg_cnt", length));
			String[] n1wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n1wk_bkg_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n3wk_ctrt_cnt", length));
			String[] n3wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n3wk_bkg_cnt", length));
			String[] n2wkBkgCnt = (JSPUtil.getParameter(request, prefix	+ "n2wk_bkg_cnt", length));
			String[] n5wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n5wk_ctrt_cnt", length));
			String[] n4wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n4wk_ctrt_cnt", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] n6wkCtrtCnt = (JSPUtil.getParameter(request, prefix	+ "n6wk_ctrt_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RetroactiveBLStatusListVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (n2wkCtrtCnt[i] != null)
					model.setN2wkCtrtCnt(n2wkCtrtCnt[i]);
				if (n4wkBkgCnt[i] != null)
					model.setN4wkBkgCnt(n4wkBkgCnt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (ttlCtrtCnt[i] != null)
					model.setTtlCtrtCnt(ttlCtrtCnt[i]);
				if (n6wkBkgCnt[i] != null)
					model.setN6wkBkgCnt(n6wkBkgCnt[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (n1wkCtrtCnt[i] != null)
					model.setN1wkCtrtCnt(n1wkCtrtCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ttlBkgCnt[i] != null)
					model.setTtlBkgCnt(ttlBkgCnt[i]);
				if (n5wkBkgCnt[i] != null)
					model.setN5wkBkgCnt(n5wkBkgCnt[i]);
				if (n1wkBkgCnt[i] != null)
					model.setN1wkBkgCnt(n1wkBkgCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3wkCtrtCnt[i] != null)
					model.setN3wkCtrtCnt(n3wkCtrtCnt[i]);
				if (n3wkBkgCnt[i] != null)
					model.setN3wkBkgCnt(n3wkBkgCnt[i]);
				if (n2wkBkgCnt[i] != null)
					model.setN2wkBkgCnt(n2wkBkgCnt[i]);
				if (n5wkCtrtCnt[i] != null)
					model.setN5wkCtrtCnt(n5wkCtrtCnt[i]);
				if (n4wkCtrtCnt[i] != null)
					model.setN4wkCtrtCnt(n4wkCtrtCnt[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (n6wkCtrtCnt[i] != null)
					model.setN6wkCtrtCnt(n6wkCtrtCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRetroactiveBLStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RetroactiveBLStatusListVO[]
	 */
	public RetroactiveBLStatusListVO[] getRetroactiveBLStatusListVOs(){
		RetroactiveBLStatusListVO[] vos = (RetroactiveBLStatusListVO[])models.toArray(new RetroactiveBLStatusListVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2wkCtrtCnt = this.n2wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4wkBkgCnt = this.n4wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCtrtCnt = this.ttlCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6wkBkgCnt = this.n6wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1wkCtrtCnt = this.n1wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkgCnt = this.ttlBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5wkBkgCnt = this.n5wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1wkBkgCnt = this.n1wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3wkCtrtCnt = this.n3wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3wkBkgCnt = this.n3wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2wkBkgCnt = this.n2wkBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5wkCtrtCnt = this.n5wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4wkCtrtCnt = this.n4wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6wkCtrtCnt = this.n6wkCtrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
