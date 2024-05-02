/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductionRatioVO.java
*@FileTitle : ProductionRatioVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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

public class ProductionRatioVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProductionRatioVO> models = new ArrayList<ProductionRatioVO>();
	
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String inpExclPndRto = null;
	/* Column Info */
	private String rtExclPndCnt = null;
	/* Column Info */
	private String audExclPndCnt = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String fmTm = null;
	/* Column Info */
	private String inpInclPndRto = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String audInclPndCnt = null;
	/* Column Info */
	private String rtInclPndCnt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String ttlPndRto = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String audExclPndRto = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String toTm = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String inpInclPndCnt = null;
	/* Column Info */
	private String ttlBlCnt = null;
	/* Column Info */
	private String rtInclPndRto = null;
	/* Column Info */
	private String audInclPndRto = null;
	/* Column Info */
	private String rtExclPndRto = null;
	/* Column Info */
	private String inpExclPndCnt = null;
	/* Column Info */
	private String ttlPndCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ProductionRatioVO() {}

	public ProductionRatioVO(String ibflag, String pagerows, String rgnOfcCd, String bkgOfcCd, String inpInclPndCnt, String inpInclPndRto, String rtInclPndCnt, String rtInclPndRto, String audInclPndCnt, String audInclPndRto, String inpExclPndCnt, String inpExclPndRto, String rtExclPndCnt, String rtExclPndRto, String audExclPndCnt, String audExclPndRto, String ttlBlCnt, String ttlPndCnt, String ttlPndRto, String fmDt, String toDt, String fmTm, String toTm, String srAmdTpCd, String blDocInpFlg, String blRtFlg, String blAudFlg) {
		this.blAudFlg = blAudFlg;
		this.inpExclPndRto = inpExclPndRto;
		this.rtExclPndCnt = rtExclPndCnt;
		this.audExclPndCnt = audExclPndCnt;
		this.blRtFlg = blRtFlg;
		this.fmTm = fmTm;
		this.inpInclPndRto = inpInclPndRto;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.audInclPndCnt = audInclPndCnt;
		this.rtInclPndCnt = rtInclPndCnt;
		this.srAmdTpCd = srAmdTpCd;
		this.ttlPndRto = ttlPndRto;
		this.rgnOfcCd = rgnOfcCd;
		this.bkgOfcCd = bkgOfcCd;
		this.blDocInpFlg = blDocInpFlg;
		this.audExclPndRto = audExclPndRto;
		this.fmDt = fmDt;
		this.toTm = toTm;
		this.toDt = toDt;
		this.inpInclPndCnt = inpInclPndCnt;
		this.ttlBlCnt = ttlBlCnt;
		this.rtInclPndRto = rtInclPndRto;
		this.audInclPndRto = audInclPndRto;
		this.rtExclPndRto = rtExclPndRto;
		this.inpExclPndCnt = inpExclPndCnt;
		this.ttlPndCnt = ttlPndCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("inp_excl_pnd_rto", getInpExclPndRto());
		this.hashColumns.put("rt_excl_pnd_cnt", getRtExclPndCnt());
		this.hashColumns.put("aud_excl_pnd_cnt", getAudExclPndCnt());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("fm_tm", getFmTm());
		this.hashColumns.put("inp_incl_pnd_rto", getInpInclPndRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aud_incl_pnd_cnt", getAudInclPndCnt());
		this.hashColumns.put("rt_incl_pnd_cnt", getRtInclPndCnt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("ttl_pnd_rto", getTtlPndRto());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("aud_excl_pnd_rto", getAudExclPndRto());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_tm", getToTm());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("inp_incl_pnd_cnt", getInpInclPndCnt());
		this.hashColumns.put("ttl_bl_cnt", getTtlBlCnt());
		this.hashColumns.put("rt_incl_pnd_rto", getRtInclPndRto());
		this.hashColumns.put("aud_incl_pnd_rto", getAudInclPndRto());
		this.hashColumns.put("rt_excl_pnd_rto", getRtExclPndRto());
		this.hashColumns.put("inp_excl_pnd_cnt", getInpExclPndCnt());
		this.hashColumns.put("ttl_pnd_cnt", getTtlPndCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("inp_excl_pnd_rto", "inpExclPndRto");
		this.hashFields.put("rt_excl_pnd_cnt", "rtExclPndCnt");
		this.hashFields.put("aud_excl_pnd_cnt", "audExclPndCnt");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("fm_tm", "fmTm");
		this.hashFields.put("inp_incl_pnd_rto", "inpInclPndRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aud_incl_pnd_cnt", "audInclPndCnt");
		this.hashFields.put("rt_incl_pnd_cnt", "rtInclPndCnt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("ttl_pnd_rto", "ttlPndRto");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("aud_excl_pnd_rto", "audExclPndRto");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_tm", "toTm");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("inp_incl_pnd_cnt", "inpInclPndCnt");
		this.hashFields.put("ttl_bl_cnt", "ttlBlCnt");
		this.hashFields.put("rt_incl_pnd_rto", "rtInclPndRto");
		this.hashFields.put("aud_incl_pnd_rto", "audInclPndRto");
		this.hashFields.put("rt_excl_pnd_rto", "rtExclPndRto");
		this.hashFields.put("inp_excl_pnd_cnt", "inpExclPndCnt");
		this.hashFields.put("ttl_pnd_cnt", "ttlPndCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
	}
	
	/**
	 * Column Info
	 * @return inpExclPndRto
	 */
	public String getInpExclPndRto() {
		return this.inpExclPndRto;
	}
	
	/**
	 * Column Info
	 * @return rtExclPndCnt
	 */
	public String getRtExclPndCnt() {
		return this.rtExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return audExclPndCnt
	 */
	public String getAudExclPndCnt() {
		return this.audExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
	}
	
	/**
	 * Column Info
	 * @return fmTm
	 */
	public String getFmTm() {
		return this.fmTm;
	}
	
	/**
	 * Column Info
	 * @return inpInclPndRto
	 */
	public String getInpInclPndRto() {
		return this.inpInclPndRto;
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
	 * @return audInclPndCnt
	 */
	public String getAudInclPndCnt() {
		return this.audInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return rtInclPndCnt
	 */
	public String getRtInclPndCnt() {
		return this.rtInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return ttlPndRto
	 */
	public String getTtlPndRto() {
		return this.ttlPndRto;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
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
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @return audExclPndRto
	 */
	public String getAudExclPndRto() {
		return this.audExclPndRto;
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
	 * @return toTm
	 */
	public String getToTm() {
		return this.toTm;
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
	 * @return inpInclPndCnt
	 */
	public String getInpInclPndCnt() {
		return this.inpInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlBlCnt
	 */
	public String getTtlBlCnt() {
		return this.ttlBlCnt;
	}
	
	/**
	 * Column Info
	 * @return rtInclPndRto
	 */
	public String getRtInclPndRto() {
		return this.rtInclPndRto;
	}
	
	/**
	 * Column Info
	 * @return audInclPndRto
	 */
	public String getAudInclPndRto() {
		return this.audInclPndRto;
	}
	
	/**
	 * Column Info
	 * @return rtExclPndRto
	 */
	public String getRtExclPndRto() {
		return this.rtExclPndRto;
	}
	
	/**
	 * Column Info
	 * @return inpExclPndCnt
	 */
	public String getInpExclPndCnt() {
		return this.inpExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @return ttlPndCnt
	 */
	public String getTtlPndCnt() {
		return this.ttlPndCnt;
	}
	

	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
	}
	
	/**
	 * Column Info
	 * @param inpExclPndRto
	 */
	public void setInpExclPndRto(String inpExclPndRto) {
		this.inpExclPndRto = inpExclPndRto;
	}
	
	/**
	 * Column Info
	 * @param rtExclPndCnt
	 */
	public void setRtExclPndCnt(String rtExclPndCnt) {
		this.rtExclPndCnt = rtExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param audExclPndCnt
	 */
	public void setAudExclPndCnt(String audExclPndCnt) {
		this.audExclPndCnt = audExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
	}
	
	/**
	 * Column Info
	 * @param fmTm
	 */
	public void setFmTm(String fmTm) {
		this.fmTm = fmTm;
	}
	
	/**
	 * Column Info
	 * @param inpInclPndRto
	 */
	public void setInpInclPndRto(String inpInclPndRto) {
		this.inpInclPndRto = inpInclPndRto;
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
	 * @param audInclPndCnt
	 */
	public void setAudInclPndCnt(String audInclPndCnt) {
		this.audInclPndCnt = audInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param rtInclPndCnt
	 */
	public void setRtInclPndCnt(String rtInclPndCnt) {
		this.rtInclPndCnt = rtInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param ttlPndRto
	 */
	public void setTtlPndRto(String ttlPndRto) {
		this.ttlPndRto = ttlPndRto;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
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
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
	}
	
	/**
	 * Column Info
	 * @param audExclPndRto
	 */
	public void setAudExclPndRto(String audExclPndRto) {
		this.audExclPndRto = audExclPndRto;
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
	 * @param toTm
	 */
	public void setToTm(String toTm) {
		this.toTm = toTm;
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
	 * @param inpInclPndCnt
	 */
	public void setInpInclPndCnt(String inpInclPndCnt) {
		this.inpInclPndCnt = inpInclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlBlCnt
	 */
	public void setTtlBlCnt(String ttlBlCnt) {
		this.ttlBlCnt = ttlBlCnt;
	}
	
	/**
	 * Column Info
	 * @param rtInclPndRto
	 */
	public void setRtInclPndRto(String rtInclPndRto) {
		this.rtInclPndRto = rtInclPndRto;
	}
	
	/**
	 * Column Info
	 * @param audInclPndRto
	 */
	public void setAudInclPndRto(String audInclPndRto) {
		this.audInclPndRto = audInclPndRto;
	}
	
	/**
	 * Column Info
	 * @param rtExclPndRto
	 */
	public void setRtExclPndRto(String rtExclPndRto) {
		this.rtExclPndRto = rtExclPndRto;
	}
	
	/**
	 * Column Info
	 * @param inpExclPndCnt
	 */
	public void setInpExclPndCnt(String inpExclPndCnt) {
		this.inpExclPndCnt = inpExclPndCnt;
	}
	
	/**
	 * Column Info
	 * @param ttlPndCnt
	 */
	public void setTtlPndCnt(String ttlPndCnt) {
		this.ttlPndCnt = ttlPndCnt;
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
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setInpExclPndRto(JSPUtil.getParameter(request, prefix + "inp_excl_pnd_rto", ""));
		setRtExclPndCnt(JSPUtil.getParameter(request, prefix + "rt_excl_pnd_cnt", ""));
		setAudExclPndCnt(JSPUtil.getParameter(request, prefix + "aud_excl_pnd_cnt", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setFmTm(JSPUtil.getParameter(request, prefix + "fm_tm", ""));
		setInpInclPndRto(JSPUtil.getParameter(request, prefix + "inp_incl_pnd_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAudInclPndCnt(JSPUtil.getParameter(request, prefix + "aud_incl_pnd_cnt", ""));
		setRtInclPndCnt(JSPUtil.getParameter(request, prefix + "rt_incl_pnd_cnt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setTtlPndRto(JSPUtil.getParameter(request, prefix + "ttl_pnd_rto", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setAudExclPndRto(JSPUtil.getParameter(request, prefix + "aud_excl_pnd_rto", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setToTm(JSPUtil.getParameter(request, prefix + "to_tm", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setInpInclPndCnt(JSPUtil.getParameter(request, prefix + "inp_incl_pnd_cnt", ""));
		setTtlBlCnt(JSPUtil.getParameter(request, prefix + "ttl_bl_cnt", ""));
		setRtInclPndRto(JSPUtil.getParameter(request, prefix + "rt_incl_pnd_rto", ""));
		setAudInclPndRto(JSPUtil.getParameter(request, prefix + "aud_incl_pnd_rto", ""));
		setRtExclPndRto(JSPUtil.getParameter(request, prefix + "rt_excl_pnd_rto", ""));
		setInpExclPndCnt(JSPUtil.getParameter(request, prefix + "inp_excl_pnd_cnt", ""));
		setTtlPndCnt(JSPUtil.getParameter(request, prefix + "ttl_pnd_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProductionRatioVO[]
	 */
	public ProductionRatioVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProductionRatioVO[]
	 */
	public ProductionRatioVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProductionRatioVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] inpExclPndRto = (JSPUtil.getParameter(request, prefix	+ "inp_excl_pnd_rto", length));
			String[] rtExclPndCnt = (JSPUtil.getParameter(request, prefix	+ "rt_excl_pnd_cnt", length));
			String[] audExclPndCnt = (JSPUtil.getParameter(request, prefix	+ "aud_excl_pnd_cnt", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] fmTm = (JSPUtil.getParameter(request, prefix	+ "fm_tm", length));
			String[] inpInclPndRto = (JSPUtil.getParameter(request, prefix	+ "inp_incl_pnd_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] audInclPndCnt = (JSPUtil.getParameter(request, prefix	+ "aud_incl_pnd_cnt", length));
			String[] rtInclPndCnt = (JSPUtil.getParameter(request, prefix	+ "rt_incl_pnd_cnt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] ttlPndRto = (JSPUtil.getParameter(request, prefix	+ "ttl_pnd_rto", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] audExclPndRto = (JSPUtil.getParameter(request, prefix	+ "aud_excl_pnd_rto", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] toTm = (JSPUtil.getParameter(request, prefix	+ "to_tm", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] inpInclPndCnt = (JSPUtil.getParameter(request, prefix	+ "inp_incl_pnd_cnt", length));
			String[] ttlBlCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bl_cnt", length));
			String[] rtInclPndRto = (JSPUtil.getParameter(request, prefix	+ "rt_incl_pnd_rto", length));
			String[] audInclPndRto = (JSPUtil.getParameter(request, prefix	+ "aud_incl_pnd_rto", length));
			String[] rtExclPndRto = (JSPUtil.getParameter(request, prefix	+ "rt_excl_pnd_rto", length));
			String[] inpExclPndCnt = (JSPUtil.getParameter(request, prefix	+ "inp_excl_pnd_cnt", length));
			String[] ttlPndCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_pnd_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProductionRatioVO();
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (inpExclPndRto[i] != null)
					model.setInpExclPndRto(inpExclPndRto[i]);
				if (rtExclPndCnt[i] != null)
					model.setRtExclPndCnt(rtExclPndCnt[i]);
				if (audExclPndCnt[i] != null)
					model.setAudExclPndCnt(audExclPndCnt[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (fmTm[i] != null)
					model.setFmTm(fmTm[i]);
				if (inpInclPndRto[i] != null)
					model.setInpInclPndRto(inpInclPndRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (audInclPndCnt[i] != null)
					model.setAudInclPndCnt(audInclPndCnt[i]);
				if (rtInclPndCnt[i] != null)
					model.setRtInclPndCnt(rtInclPndCnt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (ttlPndRto[i] != null)
					model.setTtlPndRto(ttlPndRto[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (audExclPndRto[i] != null)
					model.setAudExclPndRto(audExclPndRto[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (toTm[i] != null)
					model.setToTm(toTm[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (inpInclPndCnt[i] != null)
					model.setInpInclPndCnt(inpInclPndCnt[i]);
				if (ttlBlCnt[i] != null)
					model.setTtlBlCnt(ttlBlCnt[i]);
				if (rtInclPndRto[i] != null)
					model.setRtInclPndRto(rtInclPndRto[i]);
				if (audInclPndRto[i] != null)
					model.setAudInclPndRto(audInclPndRto[i]);
				if (rtExclPndRto[i] != null)
					model.setRtExclPndRto(rtExclPndRto[i]);
				if (inpExclPndCnt[i] != null)
					model.setInpExclPndCnt(inpExclPndCnt[i]);
				if (ttlPndCnt[i] != null)
					model.setTtlPndCnt(ttlPndCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProductionRatioVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProductionRatioVO[]
	 */
	public ProductionRatioVO[] getProductionRatioVOs(){
		ProductionRatioVO[] vos = (ProductionRatioVO[])models.toArray(new ProductionRatioVO[models.size()]);
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
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpExclPndRto = this.inpExclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtExclPndCnt = this.rtExclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audExclPndCnt = this.audExclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTm = this.fmTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpInclPndRto = this.inpInclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audInclPndCnt = this.audInclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtInclPndCnt = this.rtInclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPndRto = this.ttlPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audExclPndRto = this.audExclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTm = this.toTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpInclPndCnt = this.inpInclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBlCnt = this.ttlBlCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtInclPndRto = this.rtInclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audInclPndRto = this.audInclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtExclPndRto = this.rtExclPndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpExclPndCnt = this.inpExclPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPndCnt = this.ttlPndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
