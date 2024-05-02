/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportSummaryOutVO.java
*@FileTitle : StatusReportSummaryOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.02.23 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusReportSummaryOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusReportSummaryOutVO> models = new ArrayList<StatusReportSummaryOutVO>();
	
	/* Column Info */
	private String rBkgQty = null;
	/* Column Info */
	private String grdRTeu = null;
	/* Column Info */
	private String subPBkgQty = null;
	/* Column Info */
	private String pBkgQty = null;
	/* Column Info */
	private String fBkgQty = null;
	/* Column Info */
	private String subTBkgQty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String subRTeu = null;
	/* Column Info */
	private String subFTeu = null;
	/* Column Info */
	private String fTeu = null;
	/* Column Info */
	private String subRBkgQty = null;
	/* Column Info */
	private String pTeu = null;
	/* Column Info */
	private String grdFTeu = null;
	/* Column Info */
	private String orderbyTitle = null;
	/* Column Info */
	private String grdPBkgQty = null;
	/* Column Info */
	private String rTeu = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String subPTeu = null;
	/* Column Info */
	private String grdTTeu = null;
	/* Column Info */
	private String grdPTeu = null;
	/* Column Info */
	private String subTTeu = null;
	/* Column Info */
	private String tTeu = null;
	/* Column Info */
	private String subBkgCnt = null;
	/* Column Info */
	private String grdTBkgQty = null;
	/* Column Info */
	private String grdBkgCnt = null;
	/* Column Info */
	private String subFBkgQty = null;
	/* Column Info */
	private String grdRBkgQty = null;
	/* Column Info */
	private String grdFBkgQty = null;
	/* Column Info */
	private String tBkgQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusReportSummaryOutVO() {}

	public StatusReportSummaryOutVO(String ibflag, String pagerows, String orderbyTitle, String subFBkgQty, String subFTeu, String subPBkgQty, String subPTeu, String subRBkgQty, String subRTeu, String subTBkgQty, String subTTeu, String subBkgCnt, String grdFBkgQty, String grdFTeu, String grdPBkgQty, String grdPTeu, String grdRBkgQty, String grdRTeu, String grdTBkgQty, String grdTTeu, String grdBkgCnt, String polCd, String tpSz, String fBkgQty, String fTeu, String pBkgQty, String pTeu, String rBkgQty, String rTeu, String tBkgQty, String tTeu, String bkgCnt) {
		this.rBkgQty = rBkgQty;
		this.grdRTeu = grdRTeu;
		this.subPBkgQty = subPBkgQty;
		this.pBkgQty = pBkgQty;
		this.fBkgQty = fBkgQty;
		this.subTBkgQty = subTBkgQty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.subRTeu = subRTeu;
		this.subFTeu = subFTeu;
		this.fTeu = fTeu;
		this.subRBkgQty = subRBkgQty;
		this.pTeu = pTeu;
		this.grdFTeu = grdFTeu;
		this.orderbyTitle = orderbyTitle;
		this.grdPBkgQty = grdPBkgQty;
		this.rTeu = rTeu;
		this.tpSz = tpSz;
		this.bkgCnt = bkgCnt;
		this.subPTeu = subPTeu;
		this.grdTTeu = grdTTeu;
		this.grdPTeu = grdPTeu;
		this.subTTeu = subTTeu;
		this.tTeu = tTeu;
		this.subBkgCnt = subBkgCnt;
		this.grdTBkgQty = grdTBkgQty;
		this.grdBkgCnt = grdBkgCnt;
		this.subFBkgQty = subFBkgQty;
		this.grdRBkgQty = grdRBkgQty;
		this.grdFBkgQty = grdFBkgQty;
		this.tBkgQty = tBkgQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_bkg_qty", getRBkgQty());
		this.hashColumns.put("grd_r_teu", getGrdRTeu());
		this.hashColumns.put("sub_p_bkg_qty", getSubPBkgQty());
		this.hashColumns.put("p_bkg_qty", getPBkgQty());
		this.hashColumns.put("f_bkg_qty", getFBkgQty());
		this.hashColumns.put("sub_t_bkg_qty", getSubTBkgQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sub_r_teu", getSubRTeu());
		this.hashColumns.put("sub_f_teu", getSubFTeu());
		this.hashColumns.put("f_teu", getFTeu());
		this.hashColumns.put("sub_r_bkg_qty", getSubRBkgQty());
		this.hashColumns.put("p_teu", getPTeu());
		this.hashColumns.put("grd_f_teu", getGrdFTeu());
		this.hashColumns.put("orderby_title", getOrderbyTitle());
		this.hashColumns.put("grd_p_bkg_qty", getGrdPBkgQty());
		this.hashColumns.put("r_teu", getRTeu());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("sub_p_teu", getSubPTeu());
		this.hashColumns.put("grd_t_teu", getGrdTTeu());
		this.hashColumns.put("grd_p_teu", getGrdPTeu());
		this.hashColumns.put("sub_t_teu", getSubTTeu());
		this.hashColumns.put("t_teu", getTTeu());
		this.hashColumns.put("sub_bkg_cnt", getSubBkgCnt());
		this.hashColumns.put("grd_t_bkg_qty", getGrdTBkgQty());
		this.hashColumns.put("grd_bkg_cnt", getGrdBkgCnt());
		this.hashColumns.put("sub_f_bkg_qty", getSubFBkgQty());
		this.hashColumns.put("grd_r_bkg_qty", getGrdRBkgQty());
		this.hashColumns.put("grd_f_bkg_qty", getGrdFBkgQty());
		this.hashColumns.put("t_bkg_qty", getTBkgQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_bkg_qty", "rBkgQty");
		this.hashFields.put("grd_r_teu", "grdRTeu");
		this.hashFields.put("sub_p_bkg_qty", "subPBkgQty");
		this.hashFields.put("p_bkg_qty", "pBkgQty");
		this.hashFields.put("f_bkg_qty", "fBkgQty");
		this.hashFields.put("sub_t_bkg_qty", "subTBkgQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sub_r_teu", "subRTeu");
		this.hashFields.put("sub_f_teu", "subFTeu");
		this.hashFields.put("f_teu", "fTeu");
		this.hashFields.put("sub_r_bkg_qty", "subRBkgQty");
		this.hashFields.put("p_teu", "pTeu");
		this.hashFields.put("grd_f_teu", "grdFTeu");
		this.hashFields.put("orderby_title", "orderbyTitle");
		this.hashFields.put("grd_p_bkg_qty", "grdPBkgQty");
		this.hashFields.put("r_teu", "rTeu");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("sub_p_teu", "subPTeu");
		this.hashFields.put("grd_t_teu", "grdTTeu");
		this.hashFields.put("grd_p_teu", "grdPTeu");
		this.hashFields.put("sub_t_teu", "subTTeu");
		this.hashFields.put("t_teu", "tTeu");
		this.hashFields.put("sub_bkg_cnt", "subBkgCnt");
		this.hashFields.put("grd_t_bkg_qty", "grdTBkgQty");
		this.hashFields.put("grd_bkg_cnt", "grdBkgCnt");
		this.hashFields.put("sub_f_bkg_qty", "subFBkgQty");
		this.hashFields.put("grd_r_bkg_qty", "grdRBkgQty");
		this.hashFields.put("grd_f_bkg_qty", "grdFBkgQty");
		this.hashFields.put("t_bkg_qty", "tBkgQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rBkgQty
	 */
	public String getRBkgQty() {
		return this.rBkgQty;
	}
	
	/**
	 * Column Info
	 * @return grdRTeu
	 */
	public String getGrdRTeu() {
		return this.grdRTeu;
	}
	
	/**
	 * Column Info
	 * @return subPBkgQty
	 */
	public String getSubPBkgQty() {
		return this.subPBkgQty;
	}
	
	/**
	 * Column Info
	 * @return pBkgQty
	 */
	public String getPBkgQty() {
		return this.pBkgQty;
	}
	
	/**
	 * Column Info
	 * @return fBkgQty
	 */
	public String getFBkgQty() {
		return this.fBkgQty;
	}
	
	/**
	 * Column Info
	 * @return subTBkgQty
	 */
	public String getSubTBkgQty() {
		return this.subTBkgQty;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return subRTeu
	 */
	public String getSubRTeu() {
		return this.subRTeu;
	}
	
	/**
	 * Column Info
	 * @return subFTeu
	 */
	public String getSubFTeu() {
		return this.subFTeu;
	}
	
	/**
	 * Column Info
	 * @return fTeu
	 */
	public String getFTeu() {
		return this.fTeu;
	}
	
	/**
	 * Column Info
	 * @return subRBkgQty
	 */
	public String getSubRBkgQty() {
		return this.subRBkgQty;
	}
	
	/**
	 * Column Info
	 * @return pTeu
	 */
	public String getPTeu() {
		return this.pTeu;
	}
	
	/**
	 * Column Info
	 * @return grdFTeu
	 */
	public String getGrdFTeu() {
		return this.grdFTeu;
	}
	
	/**
	 * Column Info
	 * @return orderbyTitle
	 */
	public String getOrderbyTitle() {
		return this.orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @return grdPBkgQty
	 */
	public String getGrdPBkgQty() {
		return this.grdPBkgQty;
	}
	
	/**
	 * Column Info
	 * @return rTeu
	 */
	public String getRTeu() {
		return this.rTeu;
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
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return subPTeu
	 */
	public String getSubPTeu() {
		return this.subPTeu;
	}
	
	/**
	 * Column Info
	 * @return grdTTeu
	 */
	public String getGrdTTeu() {
		return this.grdTTeu;
	}
	
	/**
	 * Column Info
	 * @return grdPTeu
	 */
	public String getGrdPTeu() {
		return this.grdPTeu;
	}
	
	/**
	 * Column Info
	 * @return subTTeu
	 */
	public String getSubTTeu() {
		return this.subTTeu;
	}
	
	/**
	 * Column Info
	 * @return tTeu
	 */
	public String getTTeu() {
		return this.tTeu;
	}
	
	/**
	 * Column Info
	 * @return subBkgCnt
	 */
	public String getSubBkgCnt() {
		return this.subBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return grdTBkgQty
	 */
	public String getGrdTBkgQty() {
		return this.grdTBkgQty;
	}
	
	/**
	 * Column Info
	 * @return grdBkgCnt
	 */
	public String getGrdBkgCnt() {
		return this.grdBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return subFBkgQty
	 */
	public String getSubFBkgQty() {
		return this.subFBkgQty;
	}
	
	/**
	 * Column Info
	 * @return grdRBkgQty
	 */
	public String getGrdRBkgQty() {
		return this.grdRBkgQty;
	}
	
	/**
	 * Column Info
	 * @return grdFBkgQty
	 */
	public String getGrdFBkgQty() {
		return this.grdFBkgQty;
	}
	
	/**
	 * Column Info
	 * @return tBkgQty
	 */
	public String getTBkgQty() {
		return this.tBkgQty;
	}
	

	/**
	 * Column Info
	 * @param rBkgQty
	 */
	public void setRBkgQty(String rBkgQty) {
		this.rBkgQty = rBkgQty;
	}
	
	/**
	 * Column Info
	 * @param grdRTeu
	 */
	public void setGrdRTeu(String grdRTeu) {
		this.grdRTeu = grdRTeu;
	}
	
	/**
	 * Column Info
	 * @param subPBkgQty
	 */
	public void setSubPBkgQty(String subPBkgQty) {
		this.subPBkgQty = subPBkgQty;
	}
	
	/**
	 * Column Info
	 * @param pBkgQty
	 */
	public void setPBkgQty(String pBkgQty) {
		this.pBkgQty = pBkgQty;
	}
	
	/**
	 * Column Info
	 * @param fBkgQty
	 */
	public void setFBkgQty(String fBkgQty) {
		this.fBkgQty = fBkgQty;
	}
	
	/**
	 * Column Info
	 * @param subTBkgQty
	 */
	public void setSubTBkgQty(String subTBkgQty) {
		this.subTBkgQty = subTBkgQty;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param subRTeu
	 */
	public void setSubRTeu(String subRTeu) {
		this.subRTeu = subRTeu;
	}
	
	/**
	 * Column Info
	 * @param subFTeu
	 */
	public void setSubFTeu(String subFTeu) {
		this.subFTeu = subFTeu;
	}
	
	/**
	 * Column Info
	 * @param fTeu
	 */
	public void setFTeu(String fTeu) {
		this.fTeu = fTeu;
	}
	
	/**
	 * Column Info
	 * @param subRBkgQty
	 */
	public void setSubRBkgQty(String subRBkgQty) {
		this.subRBkgQty = subRBkgQty;
	}
	
	/**
	 * Column Info
	 * @param pTeu
	 */
	public void setPTeu(String pTeu) {
		this.pTeu = pTeu;
	}
	
	/**
	 * Column Info
	 * @param grdFTeu
	 */
	public void setGrdFTeu(String grdFTeu) {
		this.grdFTeu = grdFTeu;
	}
	
	/**
	 * Column Info
	 * @param orderbyTitle
	 */
	public void setOrderbyTitle(String orderbyTitle) {
		this.orderbyTitle = orderbyTitle;
	}
	
	/**
	 * Column Info
	 * @param grdPBkgQty
	 */
	public void setGrdPBkgQty(String grdPBkgQty) {
		this.grdPBkgQty = grdPBkgQty;
	}
	
	/**
	 * Column Info
	 * @param rTeu
	 */
	public void setRTeu(String rTeu) {
		this.rTeu = rTeu;
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
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param subPTeu
	 */
	public void setSubPTeu(String subPTeu) {
		this.subPTeu = subPTeu;
	}
	
	/**
	 * Column Info
	 * @param grdTTeu
	 */
	public void setGrdTTeu(String grdTTeu) {
		this.grdTTeu = grdTTeu;
	}
	
	/**
	 * Column Info
	 * @param grdPTeu
	 */
	public void setGrdPTeu(String grdPTeu) {
		this.grdPTeu = grdPTeu;
	}
	
	/**
	 * Column Info
	 * @param subTTeu
	 */
	public void setSubTTeu(String subTTeu) {
		this.subTTeu = subTTeu;
	}
	
	/**
	 * Column Info
	 * @param tTeu
	 */
	public void setTTeu(String tTeu) {
		this.tTeu = tTeu;
	}
	
	/**
	 * Column Info
	 * @param subBkgCnt
	 */
	public void setSubBkgCnt(String subBkgCnt) {
		this.subBkgCnt = subBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param grdTBkgQty
	 */
	public void setGrdTBkgQty(String grdTBkgQty) {
		this.grdTBkgQty = grdTBkgQty;
	}
	
	/**
	 * Column Info
	 * @param grdBkgCnt
	 */
	public void setGrdBkgCnt(String grdBkgCnt) {
		this.grdBkgCnt = grdBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param subFBkgQty
	 */
	public void setSubFBkgQty(String subFBkgQty) {
		this.subFBkgQty = subFBkgQty;
	}
	
	/**
	 * Column Info
	 * @param grdRBkgQty
	 */
	public void setGrdRBkgQty(String grdRBkgQty) {
		this.grdRBkgQty = grdRBkgQty;
	}
	
	/**
	 * Column Info
	 * @param grdFBkgQty
	 */
	public void setGrdFBkgQty(String grdFBkgQty) {
		this.grdFBkgQty = grdFBkgQty;
	}
	
	/**
	 * Column Info
	 * @param tBkgQty
	 */
	public void setTBkgQty(String tBkgQty) {
		this.tBkgQty = tBkgQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRBkgQty(JSPUtil.getParameter(request, "r_bkg_qty", ""));
		setGrdRTeu(JSPUtil.getParameter(request, "grd_r_teu", ""));
		setSubPBkgQty(JSPUtil.getParameter(request, "sub_p_bkg_qty", ""));
		setPBkgQty(JSPUtil.getParameter(request, "p_bkg_qty", ""));
		setFBkgQty(JSPUtil.getParameter(request, "f_bkg_qty", ""));
		setSubTBkgQty(JSPUtil.getParameter(request, "sub_t_bkg_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSubRTeu(JSPUtil.getParameter(request, "sub_r_teu", ""));
		setSubFTeu(JSPUtil.getParameter(request, "sub_f_teu", ""));
		setFTeu(JSPUtil.getParameter(request, "f_teu", ""));
		setSubRBkgQty(JSPUtil.getParameter(request, "sub_r_bkg_qty", ""));
		setPTeu(JSPUtil.getParameter(request, "p_teu", ""));
		setGrdFTeu(JSPUtil.getParameter(request, "grd_f_teu", ""));
		setOrderbyTitle(JSPUtil.getParameter(request, "orderby_title", ""));
		setGrdPBkgQty(JSPUtil.getParameter(request, "grd_p_bkg_qty", ""));
		setRTeu(JSPUtil.getParameter(request, "r_teu", ""));
		setTpSz(JSPUtil.getParameter(request, "tp_sz", ""));
		setBkgCnt(JSPUtil.getParameter(request, "bkg_cnt", ""));
		setSubPTeu(JSPUtil.getParameter(request, "sub_p_teu", ""));
		setGrdTTeu(JSPUtil.getParameter(request, "grd_t_teu", ""));
		setGrdPTeu(JSPUtil.getParameter(request, "grd_p_teu", ""));
		setSubTTeu(JSPUtil.getParameter(request, "sub_t_teu", ""));
		setTTeu(JSPUtil.getParameter(request, "t_teu", ""));
		setSubBkgCnt(JSPUtil.getParameter(request, "sub_bkg_cnt", ""));
		setGrdTBkgQty(JSPUtil.getParameter(request, "grd_t_bkg_qty", ""));
		setGrdBkgCnt(JSPUtil.getParameter(request, "grd_bkg_cnt", ""));
		setSubFBkgQty(JSPUtil.getParameter(request, "sub_f_bkg_qty", ""));
		setGrdRBkgQty(JSPUtil.getParameter(request, "grd_r_bkg_qty", ""));
		setGrdFBkgQty(JSPUtil.getParameter(request, "grd_f_bkg_qty", ""));
		setTBkgQty(JSPUtil.getParameter(request, "t_bkg_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusReportSummaryOutVO[]
	 */
	public StatusReportSummaryOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusReportSummaryOutVO[]
	 */
	public StatusReportSummaryOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusReportSummaryOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rBkgQty = (JSPUtil.getParameter(request, prefix	+ "r_bkg_qty", length));
			String[] grdRTeu = (JSPUtil.getParameter(request, prefix	+ "grd_r_teu", length));
			String[] subPBkgQty = (JSPUtil.getParameter(request, prefix	+ "sub_p_bkg_qty", length));
			String[] pBkgQty = (JSPUtil.getParameter(request, prefix	+ "p_bkg_qty", length));
			String[] fBkgQty = (JSPUtil.getParameter(request, prefix	+ "f_bkg_qty", length));
			String[] subTBkgQty = (JSPUtil.getParameter(request, prefix	+ "sub_t_bkg_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] subRTeu = (JSPUtil.getParameter(request, prefix	+ "sub_r_teu", length));
			String[] subFTeu = (JSPUtil.getParameter(request, prefix	+ "sub_f_teu", length));
			String[] fTeu = (JSPUtil.getParameter(request, prefix	+ "f_teu", length));
			String[] subRBkgQty = (JSPUtil.getParameter(request, prefix	+ "sub_r_bkg_qty", length));
			String[] pTeu = (JSPUtil.getParameter(request, prefix	+ "p_teu", length));
			String[] grdFTeu = (JSPUtil.getParameter(request, prefix	+ "grd_f_teu", length));
			String[] orderbyTitle = (JSPUtil.getParameter(request, prefix	+ "orderby_title", length));
			String[] grdPBkgQty = (JSPUtil.getParameter(request, prefix	+ "grd_p_bkg_qty", length));
			String[] rTeu = (JSPUtil.getParameter(request, prefix	+ "r_teu", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] subPTeu = (JSPUtil.getParameter(request, prefix	+ "sub_p_teu", length));
			String[] grdTTeu = (JSPUtil.getParameter(request, prefix	+ "grd_t_teu", length));
			String[] grdPTeu = (JSPUtil.getParameter(request, prefix	+ "grd_p_teu", length));
			String[] subTTeu = (JSPUtil.getParameter(request, prefix	+ "sub_t_teu", length));
			String[] tTeu = (JSPUtil.getParameter(request, prefix	+ "t_teu", length));
			String[] subBkgCnt = (JSPUtil.getParameter(request, prefix	+ "sub_bkg_cnt", length));
			String[] grdTBkgQty = (JSPUtil.getParameter(request, prefix	+ "grd_t_bkg_qty", length));
			String[] grdBkgCnt = (JSPUtil.getParameter(request, prefix	+ "grd_bkg_cnt", length));
			String[] subFBkgQty = (JSPUtil.getParameter(request, prefix	+ "sub_f_bkg_qty", length));
			String[] grdRBkgQty = (JSPUtil.getParameter(request, prefix	+ "grd_r_bkg_qty", length));
			String[] grdFBkgQty = (JSPUtil.getParameter(request, prefix	+ "grd_f_bkg_qty", length));
			String[] tBkgQty = (JSPUtil.getParameter(request, prefix	+ "t_bkg_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusReportSummaryOutVO();
				if (rBkgQty[i] != null)
					model.setRBkgQty(rBkgQty[i]);
				if (grdRTeu[i] != null)
					model.setGrdRTeu(grdRTeu[i]);
				if (subPBkgQty[i] != null)
					model.setSubPBkgQty(subPBkgQty[i]);
				if (pBkgQty[i] != null)
					model.setPBkgQty(pBkgQty[i]);
				if (fBkgQty[i] != null)
					model.setFBkgQty(fBkgQty[i]);
				if (subTBkgQty[i] != null)
					model.setSubTBkgQty(subTBkgQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (subRTeu[i] != null)
					model.setSubRTeu(subRTeu[i]);
				if (subFTeu[i] != null)
					model.setSubFTeu(subFTeu[i]);
				if (fTeu[i] != null)
					model.setFTeu(fTeu[i]);
				if (subRBkgQty[i] != null)
					model.setSubRBkgQty(subRBkgQty[i]);
				if (pTeu[i] != null)
					model.setPTeu(pTeu[i]);
				if (grdFTeu[i] != null)
					model.setGrdFTeu(grdFTeu[i]);
				if (orderbyTitle[i] != null)
					model.setOrderbyTitle(orderbyTitle[i]);
				if (grdPBkgQty[i] != null)
					model.setGrdPBkgQty(grdPBkgQty[i]);
				if (rTeu[i] != null)
					model.setRTeu(rTeu[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (subPTeu[i] != null)
					model.setSubPTeu(subPTeu[i]);
				if (grdTTeu[i] != null)
					model.setGrdTTeu(grdTTeu[i]);
				if (grdPTeu[i] != null)
					model.setGrdPTeu(grdPTeu[i]);
				if (subTTeu[i] != null)
					model.setSubTTeu(subTTeu[i]);
				if (tTeu[i] != null)
					model.setTTeu(tTeu[i]);
				if (subBkgCnt[i] != null)
					model.setSubBkgCnt(subBkgCnt[i]);
				if (grdTBkgQty[i] != null)
					model.setGrdTBkgQty(grdTBkgQty[i]);
				if (grdBkgCnt[i] != null)
					model.setGrdBkgCnt(grdBkgCnt[i]);
				if (subFBkgQty[i] != null)
					model.setSubFBkgQty(subFBkgQty[i]);
				if (grdRBkgQty[i] != null)
					model.setGrdRBkgQty(grdRBkgQty[i]);
				if (grdFBkgQty[i] != null)
					model.setGrdFBkgQty(grdFBkgQty[i]);
				if (tBkgQty[i] != null)
					model.setTBkgQty(tBkgQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusReportSummaryOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusReportSummaryOutVO[]
	 */
	public StatusReportSummaryOutVO[] getStatusReportSummaryOutVOs(){
		StatusReportSummaryOutVO[] vos = (StatusReportSummaryOutVO[])models.toArray(new StatusReportSummaryOutVO[models.size()]);
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
		this.rBkgQty = this.rBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdRTeu = this.grdRTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPBkgQty = this.subPBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgQty = this.pBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgQty = this.fBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTBkgQty = this.subTBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRTeu = this.subRTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subFTeu = this.subFTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTeu = this.fTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRBkgQty = this.subRBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTeu = this.pTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdFTeu = this.grdFTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderbyTitle = this.orderbyTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdPBkgQty = this.grdPBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTeu = this.rTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPTeu = this.subPTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdTTeu = this.grdTTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdPTeu = this.grdPTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTTeu = this.subTTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tTeu = this.tTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subBkgCnt = this.subBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdTBkgQty = this.grdTBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdBkgCnt = this.grdBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subFBkgQty = this.subFBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdRBkgQty = this.grdRBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grdFBkgQty = this.grdFBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tBkgQty = this.tBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
