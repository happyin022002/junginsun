/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PositionPollingDetailVO.java
*@FileTitle : PositionPollingDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo;

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

public class PositionPollingDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PositionPollingDetailVO> models = new ArrayList<PositionPollingDetailVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslLon = null;
	/* Column Info */
	private String vslLat = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslPreLat = null;
	/* Column Info */
	private String plngGenLoclDt = null;
	/* Column Info */
	private String vslPreProgDirCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslSpd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String vslPreSpd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslPreLon = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ifRcvSeq = null;
	/* Column Info */
	private String dlyRcvSeq = null;
	/* Column Info */
	private String vslProgDirCtnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String plngGenGdt = null;
	/* Column Info */
	private String vslPlngDist = null;
	/* Column Info */
	private String plngGenDiffHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PositionPollingDetailVO() {}

	public PositionPollingDetailVO(String ibflag, String pagerows, String rcvDt, String dlyRcvSeq, String ifRcvSeq, String plngGenGdt, String plngGenLoclDt, String vslCd, String vslEngNm, String callSgnNo, String lloydNo, String skdVoyNo, String skdDirCd, String vslLat, String vslLon, String vslSpd, String vslProgDirCtnt, String plngGenDiffHrs, String vslPreLat, String vslPreLon, String vslPlngDist, String vslPreSpd, String vslPreProgDirCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.vslLon = vslLon;
		this.vslLat = vslLat;
		this.creDt = creDt;
		this.vslPreLat = vslPreLat;
		this.plngGenLoclDt = plngGenLoclDt;
		this.vslPreProgDirCtnt = vslPreProgDirCtnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.vslSpd = vslSpd;
		this.rcvDt = rcvDt;
		this.vslPreSpd = vslPreSpd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.callSgnNo = callSgnNo;
		this.skdVoyNo = skdVoyNo;
		this.vslPreLon = vslPreLon;
		this.skdDirCd = skdDirCd;
		this.ifRcvSeq = ifRcvSeq;
		this.dlyRcvSeq = dlyRcvSeq;
		this.vslProgDirCtnt = vslProgDirCtnt;
		this.creUsrId = creUsrId;
		this.lloydNo = lloydNo;
		this.plngGenGdt = plngGenGdt;
		this.vslPlngDist = vslPlngDist;
		this.plngGenDiffHrs = plngGenDiffHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_lon", getVslLon());
		this.hashColumns.put("vsl_lat", getVslLat());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_pre_lat", getVslPreLat());
		this.hashColumns.put("plng_gen_locl_dt", getPlngGenLoclDt());
		this.hashColumns.put("vsl_pre_prog_dir_ctnt", getVslPreProgDirCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_spd", getVslSpd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("vsl_pre_spd", getVslPreSpd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_pre_lon", getVslPreLon());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("if_rcv_seq", getIfRcvSeq());
		this.hashColumns.put("dly_rcv_seq", getDlyRcvSeq());
		this.hashColumns.put("vsl_prog_dir_ctnt", getVslProgDirCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("plng_gen_gdt", getPlngGenGdt());
		this.hashColumns.put("vsl_plng_dist", getVslPlngDist());
		this.hashColumns.put("plng_gen_diff_hrs", getPlngGenDiffHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_lon", "vslLon");
		this.hashFields.put("vsl_lat", "vslLat");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_pre_lat", "vslPreLat");
		this.hashFields.put("plng_gen_locl_dt", "plngGenLoclDt");
		this.hashFields.put("vsl_pre_prog_dir_ctnt", "vslPreProgDirCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_spd", "vslSpd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("vsl_pre_spd", "vslPreSpd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_pre_lon", "vslPreLon");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("if_rcv_seq", "ifRcvSeq");
		this.hashFields.put("dly_rcv_seq", "dlyRcvSeq");
		this.hashFields.put("vsl_prog_dir_ctnt", "vslProgDirCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("plng_gen_gdt", "plngGenGdt");
		this.hashFields.put("vsl_plng_dist", "vslPlngDist");
		this.hashFields.put("plng_gen_diff_hrs", "plngGenDiffHrs");
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
	 * @return vslLon
	 */
	public String getVslLon() {
		return this.vslLon;
	}
	
	/**
	 * Column Info
	 * @return vslLat
	 */
	public String getVslLat() {
		return this.vslLat;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return vslPreLat
	 */
	public String getVslPreLat() {
		return this.vslPreLat;
	}
	
	/**
	 * Column Info
	 * @return plngGenLoclDt
	 */
	public String getPlngGenLoclDt() {
		return this.plngGenLoclDt;
	}
	
	/**
	 * Column Info
	 * @return vslPreProgDirCtnt
	 */
	public String getVslPreProgDirCtnt() {
		return this.vslPreProgDirCtnt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslSpd
	 */
	public String getVslSpd() {
		return this.vslSpd;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return vslPreSpd
	 */
	public String getVslPreSpd() {
		return this.vslPreSpd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslPreLon
	 */
	public String getVslPreLon() {
		return this.vslPreLon;
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
	 * @return ifRcvSeq
	 */
	public String getIfRcvSeq() {
		return this.ifRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return dlyRcvSeq
	 */
	public String getDlyRcvSeq() {
		return this.dlyRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return vslProgDirCtnt
	 */
	public String getVslProgDirCtnt() {
		return this.vslProgDirCtnt;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return plngGenGdt
	 */
	public String getPlngGenGdt() {
		return this.plngGenGdt;
	}
	
	/**
	 * Column Info
	 * @return vslPlngDist
	 */
	public String getVslPlngDist() {
		return this.vslPlngDist;
	}
	
	/**
	 * Column Info
	 * @return plngGenDiffHrs
	 */
	public String getPlngGenDiffHrs() {
		return this.plngGenDiffHrs;
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
	 * @param vslLon
	 */
	public void setVslLon(String vslLon) {
		this.vslLon = vslLon;
	}
	
	/**
	 * Column Info
	 * @param vslLat
	 */
	public void setVslLat(String vslLat) {
		this.vslLat = vslLat;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param vslPreLat
	 */
	public void setVslPreLat(String vslPreLat) {
		this.vslPreLat = vslPreLat;
	}
	
	/**
	 * Column Info
	 * @param plngGenLoclDt
	 */
	public void setPlngGenLoclDt(String plngGenLoclDt) {
		this.plngGenLoclDt = plngGenLoclDt;
	}
	
	/**
	 * Column Info
	 * @param vslPreProgDirCtnt
	 */
	public void setVslPreProgDirCtnt(String vslPreProgDirCtnt) {
		this.vslPreProgDirCtnt = vslPreProgDirCtnt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslSpd
	 */
	public void setVslSpd(String vslSpd) {
		this.vslSpd = vslSpd;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param vslPreSpd
	 */
	public void setVslPreSpd(String vslPreSpd) {
		this.vslPreSpd = vslPreSpd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslPreLon
	 */
	public void setVslPreLon(String vslPreLon) {
		this.vslPreLon = vslPreLon;
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
	 * @param ifRcvSeq
	 */
	public void setIfRcvSeq(String ifRcvSeq) {
		this.ifRcvSeq = ifRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param dlyRcvSeq
	 */
	public void setDlyRcvSeq(String dlyRcvSeq) {
		this.dlyRcvSeq = dlyRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param vslProgDirCtnt
	 */
	public void setVslProgDirCtnt(String vslProgDirCtnt) {
		this.vslProgDirCtnt = vslProgDirCtnt;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param plngGenGdt
	 */
	public void setPlngGenGdt(String plngGenGdt) {
		this.plngGenGdt = plngGenGdt;
	}
	
	/**
	 * Column Info
	 * @param vslPlngDist
	 */
	public void setVslPlngDist(String vslPlngDist) {
		this.vslPlngDist = vslPlngDist;
	}
	
	/**
	 * Column Info
	 * @param plngGenDiffHrs
	 */
	public void setPlngGenDiffHrs(String plngGenDiffHrs) {
		this.plngGenDiffHrs = plngGenDiffHrs;
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
		setVslLon(JSPUtil.getParameter(request, prefix + "vsl_lon", ""));
		setVslLat(JSPUtil.getParameter(request, prefix + "vsl_lat", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslPreLat(JSPUtil.getParameter(request, prefix + "vsl_pre_lat", ""));
		setPlngGenLoclDt(JSPUtil.getParameter(request, prefix + "plng_gen_locl_dt", ""));
		setVslPreProgDirCtnt(JSPUtil.getParameter(request, prefix + "vsl_pre_prog_dir_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setVslSpd(JSPUtil.getParameter(request, prefix + "vsl_spd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setVslPreSpd(JSPUtil.getParameter(request, prefix + "vsl_pre_spd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslPreLon(JSPUtil.getParameter(request, prefix + "vsl_pre_lon", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setIfRcvSeq(JSPUtil.getParameter(request, prefix + "if_rcv_seq", ""));
		setDlyRcvSeq(JSPUtil.getParameter(request, prefix + "dly_rcv_seq", ""));
		setVslProgDirCtnt(JSPUtil.getParameter(request, prefix + "vsl_prog_dir_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setPlngGenGdt(JSPUtil.getParameter(request, prefix + "plng_gen_gdt", ""));
		setVslPlngDist(JSPUtil.getParameter(request, prefix + "vsl_plng_dist", ""));
		setPlngGenDiffHrs(JSPUtil.getParameter(request, prefix + "plng_gen_diff_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PositionPollingDetailVO[]
	 */
	public PositionPollingDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PositionPollingDetailVO[]
	 */
	public PositionPollingDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PositionPollingDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vslLon = (JSPUtil.getParameter(request, prefix	+ "vsl_lon", length));
			String[] vslLat = (JSPUtil.getParameter(request, prefix	+ "vsl_lat", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslPreLat = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_lat", length));
			String[] plngGenLoclDt = (JSPUtil.getParameter(request, prefix	+ "plng_gen_locl_dt", length));
			String[] vslPreProgDirCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_prog_dir_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslSpd = (JSPUtil.getParameter(request, prefix	+ "vsl_spd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] vslPreSpd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_spd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslPreLon = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_lon", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ifRcvSeq = (JSPUtil.getParameter(request, prefix	+ "if_rcv_seq", length));
			String[] dlyRcvSeq = (JSPUtil.getParameter(request, prefix	+ "dly_rcv_seq", length));
			String[] vslProgDirCtnt = (JSPUtil.getParameter(request, prefix	+ "vsl_prog_dir_ctnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] plngGenGdt = (JSPUtil.getParameter(request, prefix	+ "plng_gen_gdt", length));
			String[] vslPlngDist = (JSPUtil.getParameter(request, prefix	+ "vsl_plng_dist", length));
			String[] plngGenDiffHrs = (JSPUtil.getParameter(request, prefix	+ "plng_gen_diff_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new PositionPollingDetailVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslLon[i] != null)
					model.setVslLon(vslLon[i]);
				if (vslLat[i] != null)
					model.setVslLat(vslLat[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslPreLat[i] != null)
					model.setVslPreLat(vslPreLat[i]);
				if (plngGenLoclDt[i] != null)
					model.setPlngGenLoclDt(plngGenLoclDt[i]);
				if (vslPreProgDirCtnt[i] != null)
					model.setVslPreProgDirCtnt(vslPreProgDirCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslSpd[i] != null)
					model.setVslSpd(vslSpd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (vslPreSpd[i] != null)
					model.setVslPreSpd(vslPreSpd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslPreLon[i] != null)
					model.setVslPreLon(vslPreLon[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ifRcvSeq[i] != null)
					model.setIfRcvSeq(ifRcvSeq[i]);
				if (dlyRcvSeq[i] != null)
					model.setDlyRcvSeq(dlyRcvSeq[i]);
				if (vslProgDirCtnt[i] != null)
					model.setVslProgDirCtnt(vslProgDirCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (plngGenGdt[i] != null)
					model.setPlngGenGdt(plngGenGdt[i]);
				if (vslPlngDist[i] != null)
					model.setVslPlngDist(vslPlngDist[i]);
				if (plngGenDiffHrs[i] != null)
					model.setPlngGenDiffHrs(plngGenDiffHrs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPositionPollingDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PositionPollingDetailVO[]
	 */
	public PositionPollingDetailVO[] getPositionPollingDetailVOs(){
		PositionPollingDetailVO[] vos = (PositionPollingDetailVO[])models.toArray(new PositionPollingDetailVO[models.size()]);
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
		this.vslLon = this.vslLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLat = this.vslLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPreLat = this.vslPreLat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plngGenLoclDt = this.plngGenLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPreProgDirCtnt = this.vslPreProgDirCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSpd = this.vslSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPreSpd = this.vslPreSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPreLon = this.vslPreLon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRcvSeq = this.ifRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlyRcvSeq = this.dlyRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslProgDirCtnt = this.vslProgDirCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plngGenGdt = this.plngGenGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPlngDist = this.vslPlngDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plngGenDiffHrs = this.plngGenDiffHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
