/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EqrCtrlRepoSnapVO.java
*@FileTitle : EqrCtrlRepoSnapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.03  
* 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqrCtrlRepoSnapVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrCtrlRepoSnapVO> models = new ArrayList<EqrCtrlRepoSnapVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String d7FcastQty = null;
	/* Column Info */
	private String a2FcastQty = null;
	/* Column Info */
	private String r9FcastQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String d5FcastQty = null;
	/* Column Info */
	private String r2FcastQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String o2FcastQty = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String codCfmDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String o5FcastQty = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String a4FcastQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String d2FcastQty = null;
	/* Column Info */
	private String r5FcastQty = null;
	/* Column Info */
	private String s4FcastQty = null;
	/* Column Info */
	private String s2FcastQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String f4FcastQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String f5FcastQty = null;
	/* Column Info */
	private String o4FcastQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String d4FcastQty = null;
	/* Column Info */
	private String f2FcastQty = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqrCtrlRepoSnapVO() {}

	public EqrCtrlRepoSnapVO(String ibflag, String pagerows, String vslLaneCd, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String etbDt, String d2FcastQty, String d4FcastQty, String d5FcastQty, String d7FcastQty, String r2FcastQty, String r5FcastQty, String r9FcastQty, String o2FcastQty, String s2FcastQty, String o4FcastQty, String s4FcastQty, String o5FcastQty, String f2FcastQty, String a2FcastQty, String f4FcastQty, String a4FcastQty, String f5FcastQty, String codCfmDivCd, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.d7FcastQty = d7FcastQty;
		this.a2FcastQty = a2FcastQty;
		this.r9FcastQty = r9FcastQty;
		this.creDt = creDt;
		this.d5FcastQty = d5FcastQty;
		this.r2FcastQty = r2FcastQty;
		this.pagerows = pagerows;
		this.o2FcastQty = o2FcastQty;
		this.vslLaneCd = vslLaneCd;
		this.codCfmDivCd = codCfmDivCd;
		this.ibflag = ibflag;
		this.o5FcastQty = o5FcastQty;
		this.etbDt = etbDt;
		this.a4FcastQty = a4FcastQty;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.d2FcastQty = d2FcastQty;
		this.r5FcastQty = r5FcastQty;
		this.s4FcastQty = s4FcastQty;
		this.s2FcastQty = s2FcastQty;
		this.skdVoyNo = skdVoyNo;
		this.f4FcastQty = f4FcastQty;
		this.skdDirCd = skdDirCd;
		this.f5FcastQty = f5FcastQty;
		this.o4FcastQty = o4FcastQty;
		this.creUsrId = creUsrId;
		this.d4FcastQty = d4FcastQty;
		this.f2FcastQty = f2FcastQty;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("d7_fcast_qty", getD7FcastQty());
		this.hashColumns.put("a2_fcast_qty", getA2FcastQty());
		this.hashColumns.put("r9_fcast_qty", getR9FcastQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("d5_fcast_qty", getD5FcastQty());
		this.hashColumns.put("r2_fcast_qty", getR2FcastQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("o2_fcast_qty", getO2FcastQty());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("cod_cfm_div_cd", getCodCfmDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("o5_fcast_qty", getO5FcastQty());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("a4_fcast_qty", getA4FcastQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("d2_fcast_qty", getD2FcastQty());
		this.hashColumns.put("r5_fcast_qty", getR5FcastQty());
		this.hashColumns.put("s4_fcast_qty", getS4FcastQty());
		this.hashColumns.put("s2_fcast_qty", getS2FcastQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("f4_fcast_qty", getF4FcastQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("f5_fcast_qty", getF5FcastQty());
		this.hashColumns.put("o4_fcast_qty", getO4FcastQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("d4_fcast_qty", getD4FcastQty());
		this.hashColumns.put("f2_fcast_qty", getF2FcastQty());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("d7_fcast_qty", "d7FcastQty");
		this.hashFields.put("a2_fcast_qty", "a2FcastQty");
		this.hashFields.put("r9_fcast_qty", "r9FcastQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("d5_fcast_qty", "d5FcastQty");
		this.hashFields.put("r2_fcast_qty", "r2FcastQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("o2_fcast_qty", "o2FcastQty");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("cod_cfm_div_cd", "codCfmDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("o5_fcast_qty", "o5FcastQty");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("a4_fcast_qty", "a4FcastQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("d2_fcast_qty", "d2FcastQty");
		this.hashFields.put("r5_fcast_qty", "r5FcastQty");
		this.hashFields.put("s4_fcast_qty", "s4FcastQty");
		this.hashFields.put("s2_fcast_qty", "s2FcastQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("f4_fcast_qty", "f4FcastQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("f5_fcast_qty", "f5FcastQty");
		this.hashFields.put("o4_fcast_qty", "o4FcastQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("d4_fcast_qty", "d4FcastQty");
		this.hashFields.put("f2_fcast_qty", "f2FcastQty");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
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
	 * @return d7FcastQty
	 */
	public String getD7FcastQty() {
		return this.d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @return a2FcastQty
	 */
	public String getA2FcastQty() {
		return this.a2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return r9FcastQty
	 */
	public String getR9FcastQty() {
		return this.r9FcastQty;
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
	 * @return d5FcastQty
	 */
	public String getD5FcastQty() {
		return this.d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return r2FcastQty
	 */
	public String getR2FcastQty() {
		return this.r2FcastQty;
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
	 * @return o2FcastQty
	 */
	public String getO2FcastQty() {
		return this.o2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return codCfmDivCd
	 */
	public String getCodCfmDivCd() {
		return this.codCfmDivCd;
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
	 * @return o5FcastQty
	 */
	public String getO5FcastQty() {
		return this.o5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return a4FcastQty
	 */
	public String getA4FcastQty() {
		return this.a4FcastQty;
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
	 * @return d2FcastQty
	 */
	public String getD2FcastQty() {
		return this.d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return r5FcastQty
	 */
	public String getR5FcastQty() {
		return this.r5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return s4FcastQty
	 */
	public String getS4FcastQty() {
		return this.s4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return s2FcastQty
	 */
	public String getS2FcastQty() {
		return this.s2FcastQty;
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
	 * @return f4FcastQty
	 */
	public String getF4FcastQty() {
		return this.f4FcastQty;
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
	 * @return f5FcastQty
	 */
	public String getF5FcastQty() {
		return this.f5FcastQty;
	}
	
	/**
	 * Column Info
	 * @return o4FcastQty
	 */
	public String getO4FcastQty() {
		return this.o4FcastQty;
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
	 * @return d4FcastQty
	 */
	public String getD4FcastQty() {
		return this.d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @return f2FcastQty
	 */
	public String getF2FcastQty() {
		return this.f2FcastQty;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @param d7FcastQty
	 */
	public void setD7FcastQty(String d7FcastQty) {
		this.d7FcastQty = d7FcastQty;
	}
	
	/**
	 * Column Info
	 * @param a2FcastQty
	 */
	public void setA2FcastQty(String a2FcastQty) {
		this.a2FcastQty = a2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param r9FcastQty
	 */
	public void setR9FcastQty(String r9FcastQty) {
		this.r9FcastQty = r9FcastQty;
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
	 * @param d5FcastQty
	 */
	public void setD5FcastQty(String d5FcastQty) {
		this.d5FcastQty = d5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param r2FcastQty
	 */
	public void setR2FcastQty(String r2FcastQty) {
		this.r2FcastQty = r2FcastQty;
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
	 * @param o2FcastQty
	 */
	public void setO2FcastQty(String o2FcastQty) {
		this.o2FcastQty = o2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param codCfmDivCd
	 */
	public void setCodCfmDivCd(String codCfmDivCd) {
		this.codCfmDivCd = codCfmDivCd;
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
	 * @param o5FcastQty
	 */
	public void setO5FcastQty(String o5FcastQty) {
		this.o5FcastQty = o5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param a4FcastQty
	 */
	public void setA4FcastQty(String a4FcastQty) {
		this.a4FcastQty = a4FcastQty;
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
	 * @param d2FcastQty
	 */
	public void setD2FcastQty(String d2FcastQty) {
		this.d2FcastQty = d2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param r5FcastQty
	 */
	public void setR5FcastQty(String r5FcastQty) {
		this.r5FcastQty = r5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param s4FcastQty
	 */
	public void setS4FcastQty(String s4FcastQty) {
		this.s4FcastQty = s4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param s2FcastQty
	 */
	public void setS2FcastQty(String s2FcastQty) {
		this.s2FcastQty = s2FcastQty;
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
	 * @param f4FcastQty
	 */
	public void setF4FcastQty(String f4FcastQty) {
		this.f4FcastQty = f4FcastQty;
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
	 * @param f5FcastQty
	 */
	public void setF5FcastQty(String f5FcastQty) {
		this.f5FcastQty = f5FcastQty;
	}
	
	/**
	 * Column Info
	 * @param o4FcastQty
	 */
	public void setO4FcastQty(String o4FcastQty) {
		this.o4FcastQty = o4FcastQty;
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
	 * @param d4FcastQty
	 */
	public void setD4FcastQty(String d4FcastQty) {
		this.d4FcastQty = d4FcastQty;
	}
	
	/**
	 * Column Info
	 * @param f2FcastQty
	 */
	public void setF2FcastQty(String f2FcastQty) {
		this.f2FcastQty = f2FcastQty;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
		setD7FcastQty(JSPUtil.getParameter(request, prefix + "d7_fcast_qty", ""));
		setA2FcastQty(JSPUtil.getParameter(request, prefix + "a2_fcast_qty", ""));
		setR9FcastQty(JSPUtil.getParameter(request, prefix + "r9_fcast_qty", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setD5FcastQty(JSPUtil.getParameter(request, prefix + "d5_fcast_qty", ""));
		setR2FcastQty(JSPUtil.getParameter(request, prefix + "r2_fcast_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setO2FcastQty(JSPUtil.getParameter(request, prefix + "o2_fcast_qty", ""));
		setVslLaneCd(JSPUtil.getParameter(request, prefix + "vsl_lane_cd", ""));
		setCodCfmDivCd(JSPUtil.getParameter(request, prefix + "cod_cfm_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setO5FcastQty(JSPUtil.getParameter(request, prefix + "o5_fcast_qty", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setA4FcastQty(JSPUtil.getParameter(request, prefix + "a4_fcast_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setD2FcastQty(JSPUtil.getParameter(request, prefix + "d2_fcast_qty", ""));
		setR5FcastQty(JSPUtil.getParameter(request, prefix + "r5_fcast_qty", ""));
		setS4FcastQty(JSPUtil.getParameter(request, prefix + "s4_fcast_qty", ""));
		setS2FcastQty(JSPUtil.getParameter(request, prefix + "s2_fcast_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setF4FcastQty(JSPUtil.getParameter(request, prefix + "f4_fcast_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setF5FcastQty(JSPUtil.getParameter(request, prefix + "f5_fcast_qty", ""));
		setO4FcastQty(JSPUtil.getParameter(request, prefix + "o4_fcast_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setD4FcastQty(JSPUtil.getParameter(request, prefix + "d4_fcast_qty", ""));
		setF2FcastQty(JSPUtil.getParameter(request, prefix + "f2_fcast_qty", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrCtrlRepoSnapVO[]
	 */
	public EqrCtrlRepoSnapVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrCtrlRepoSnapVO[]
	 */
	public EqrCtrlRepoSnapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrCtrlRepoSnapVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] d7FcastQty = (JSPUtil.getParameter(request, prefix	+ "d7_fcast_qty", length));
			String[] a2FcastQty = (JSPUtil.getParameter(request, prefix	+ "a2_fcast_qty", length));
			String[] r9FcastQty = (JSPUtil.getParameter(request, prefix	+ "r9_fcast_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] d5FcastQty = (JSPUtil.getParameter(request, prefix	+ "d5_fcast_qty", length));
			String[] r2FcastQty = (JSPUtil.getParameter(request, prefix	+ "r2_fcast_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] o2FcastQty = (JSPUtil.getParameter(request, prefix	+ "o2_fcast_qty", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] codCfmDivCd = (JSPUtil.getParameter(request, prefix	+ "cod_cfm_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] o5FcastQty = (JSPUtil.getParameter(request, prefix	+ "o5_fcast_qty", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] a4FcastQty = (JSPUtil.getParameter(request, prefix	+ "a4_fcast_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] d2FcastQty = (JSPUtil.getParameter(request, prefix	+ "d2_fcast_qty", length));
			String[] r5FcastQty = (JSPUtil.getParameter(request, prefix	+ "r5_fcast_qty", length));
			String[] s4FcastQty = (JSPUtil.getParameter(request, prefix	+ "s4_fcast_qty", length));
			String[] s2FcastQty = (JSPUtil.getParameter(request, prefix	+ "s2_fcast_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] f4FcastQty = (JSPUtil.getParameter(request, prefix	+ "f4_fcast_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] f5FcastQty = (JSPUtil.getParameter(request, prefix	+ "f5_fcast_qty", length));
			String[] o4FcastQty = (JSPUtil.getParameter(request, prefix	+ "o4_fcast_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] d4FcastQty = (JSPUtil.getParameter(request, prefix	+ "d4_fcast_qty", length));
			String[] f2FcastQty = (JSPUtil.getParameter(request, prefix	+ "f2_fcast_qty", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrCtrlRepoSnapVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (d7FcastQty[i] != null)
					model.setD7FcastQty(d7FcastQty[i]);
				if (a2FcastQty[i] != null)
					model.setA2FcastQty(a2FcastQty[i]);
				if (r9FcastQty[i] != null)
					model.setR9FcastQty(r9FcastQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (d5FcastQty[i] != null)
					model.setD5FcastQty(d5FcastQty[i]);
				if (r2FcastQty[i] != null)
					model.setR2FcastQty(r2FcastQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (o2FcastQty[i] != null)
					model.setO2FcastQty(o2FcastQty[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (codCfmDivCd[i] != null)
					model.setCodCfmDivCd(codCfmDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (o5FcastQty[i] != null)
					model.setO5FcastQty(o5FcastQty[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (a4FcastQty[i] != null)
					model.setA4FcastQty(a4FcastQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (d2FcastQty[i] != null)
					model.setD2FcastQty(d2FcastQty[i]);
				if (r5FcastQty[i] != null)
					model.setR5FcastQty(r5FcastQty[i]);
				if (s4FcastQty[i] != null)
					model.setS4FcastQty(s4FcastQty[i]);
				if (s2FcastQty[i] != null)
					model.setS2FcastQty(s2FcastQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (f4FcastQty[i] != null)
					model.setF4FcastQty(f4FcastQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (f5FcastQty[i] != null)
					model.setF5FcastQty(f5FcastQty[i]);
				if (o4FcastQty[i] != null)
					model.setO4FcastQty(o4FcastQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (d4FcastQty[i] != null)
					model.setD4FcastQty(d4FcastQty[i]);
				if (f2FcastQty[i] != null)
					model.setF2FcastQty(f2FcastQty[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrCtrlRepoSnapVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqrCtrlRepoSnapVO[]
	 */
	public EqrCtrlRepoSnapVO[] getEqrCtrlRepoSnapVOs(){
		EqrCtrlRepoSnapVO[] vos = (EqrCtrlRepoSnapVO[])models.toArray(new EqrCtrlRepoSnapVO[models.size()]);
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
		this.d7FcastQty = this.d7FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2FcastQty = this.a2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9FcastQty = this.r9FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5FcastQty = this.d5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2FcastQty = this.r2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2FcastQty = this.o2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codCfmDivCd = this.codCfmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5FcastQty = this.o5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4FcastQty = this.a4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2FcastQty = this.d2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5FcastQty = this.r5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4FcastQty = this.s4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2FcastQty = this.s2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4FcastQty = this.f4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5FcastQty = this.f5FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4FcastQty = this.o4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4FcastQty = this.d4FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2FcastQty = this.f2FcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
