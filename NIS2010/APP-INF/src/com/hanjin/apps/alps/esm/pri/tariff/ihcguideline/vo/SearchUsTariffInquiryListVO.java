/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchUsTariffInquiryListVO.java
*@FileTitle : SearchUsTariffInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.20 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUsTariffInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUsTariffInquiryListVO> models = new ArrayList<SearchUsTariffInquiryListVO>();
	
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String gline20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String accDt = null;
	/* Column Info */
	private String cost20ftRailFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pntLocNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cost20ftTrkFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String gline20ftRailFrtRtAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String cost40ftTrkFrtRtAmt = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String gline40ftRailFrtRtAmt = null;
	/* Column Info */
	private String cost40ftFrtRtAmt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String cost40ftRailFrtRtAmt = null;
	/* Column Info */
	private String cost20ftFrtRtAmt = null;
	/* Column Info */
	private String gline40ftTrkFrtRtAmt = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUsTariffInquiryListVO() {}

	public SearchUsTariffInquiryListVO(String ibflag, String pagerows, String pntLocCd, String pntLocNm, String hubLocCd, String bsePortLocCd, String rcvDeTermCd, String prcTrspModCd, String gline20ftRailFrtRtAmt, String gline40ftRailFrtRtAmt, String gline20ftTrkFrtRtAmt, String gline40ftTrkFrtRtAmt, String gline20ftFrtRtAmt, String gline40ftFrtRtAmt, String cost20ftRailFrtRtAmt, String cost40ftRailFrtRtAmt, String cost20ftTrkFrtRtAmt, String cost40ftTrkFrtRtAmt, String cost20ftFrtRtAmt, String cost40ftFrtRtAmt, String mb20ftRto, String mb40ftRto, String svcScpCd, String ihcTrfNo, String orgDestTpCd, String accDt) {
		this.mb20ftRto = mb20ftRto;
		this.gline20ftTrkFrtRtAmt = gline20ftTrkFrtRtAmt;
		this.pntLocCd = pntLocCd;
		this.svcScpCd = svcScpCd;
		this.accDt = accDt;
		this.cost20ftRailFrtRtAmt = cost20ftRailFrtRtAmt;
		this.pagerows = pagerows;
		this.pntLocNm = pntLocNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.cost20ftTrkFrtRtAmt = cost20ftTrkFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.gline20ftRailFrtRtAmt = gline20ftRailFrtRtAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.cost40ftTrkFrtRtAmt = cost40ftTrkFrtRtAmt;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.ihcTrfNo = ihcTrfNo;
		this.gline40ftRailFrtRtAmt = gline40ftRailFrtRtAmt;
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
		this.orgDestTpCd = orgDestTpCd;
		this.cost40ftRailFrtRtAmt = cost40ftRailFrtRtAmt;
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
		this.gline40ftTrkFrtRtAmt = gline40ftTrkFrtRtAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.prcTrspModCd = prcTrspModCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("gline_20ft_trk_frt_rt_amt", getGline20ftTrkFrtRtAmt());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("acc_dt", getAccDt());
		this.hashColumns.put("cost_20ft_rail_frt_rt_amt", getCost20ftRailFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pnt_loc_nm", getPntLocNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_20ft_trk_frt_rt_amt", getCost20ftTrkFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("gline_20ft_rail_frt_rt_amt", getGline20ftRailFrtRtAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("cost_40ft_trk_frt_rt_amt", getCost40ftTrkFrtRtAmt());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("gline_40ft_rail_frt_rt_amt", getGline40ftRailFrtRtAmt());
		this.hashColumns.put("cost_40ft_frt_rt_amt", getCost40ftFrtRtAmt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("cost_40ft_rail_frt_rt_amt", getCost40ftRailFrtRtAmt());
		this.hashColumns.put("cost_20ft_frt_rt_amt", getCost20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_trk_frt_rt_amt", getGline40ftTrkFrtRtAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("gline_20ft_trk_frt_rt_amt", "gline20ftTrkFrtRtAmt");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("acc_dt", "accDt");
		this.hashFields.put("cost_20ft_rail_frt_rt_amt", "cost20ftRailFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pnt_loc_nm", "pntLocNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_20ft_trk_frt_rt_amt", "cost20ftTrkFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("gline_20ft_rail_frt_rt_amt", "gline20ftRailFrtRtAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("cost_40ft_trk_frt_rt_amt", "cost40ftTrkFrtRtAmt");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("gline_40ft_rail_frt_rt_amt", "gline40ftRailFrtRtAmt");
		this.hashFields.put("cost_40ft_frt_rt_amt", "cost40ftFrtRtAmt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("cost_40ft_rail_frt_rt_amt", "cost40ftRailFrtRtAmt");
		this.hashFields.put("cost_20ft_frt_rt_amt", "cost20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_trk_frt_rt_amt", "gline40ftTrkFrtRtAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mb20ftRto
	 */
	public String getMb20ftRto() {
		return this.mb20ftRto;
	}
	
	/**
	 * Column Info
	 * @return gline20ftTrkFrtRtAmt
	 */
	public String getGline20ftTrkFrtRtAmt() {
		return this.gline20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
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
	 * @return accDt
	 */
	public String getAccDt() {
		return this.accDt;
	}
	
	/**
	 * Column Info
	 * @return cost20ftRailFrtRtAmt
	 */
	public String getCost20ftRailFrtRtAmt() {
		return this.cost20ftRailFrtRtAmt;
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
	 * @return pntLocNm
	 */
	public String getPntLocNm() {
		return this.pntLocNm;
	}
	
	/**
	 * Column Info
	 * @return mb40ftRto
	 */
	public String getMb40ftRto() {
		return this.mb40ftRto;
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
	 * @return cost20ftTrkFrtRtAmt
	 */
	public String getCost20ftTrkFrtRtAmt() {
		return this.cost20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return gline20ftRailFrtRtAmt
	 */
	public String getGline20ftRailFrtRtAmt() {
		return this.gline20ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return cost40ftTrkFrtRtAmt
	 */
	public String getCost40ftTrkFrtRtAmt() {
		return this.cost40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline20ftFrtRtAmt
	 */
	public String getGline20ftFrtRtAmt() {
		return this.gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return gline40ftRailFrtRtAmt
	 */
	public String getGline40ftRailFrtRtAmt() {
		return this.gline40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cost40ftFrtRtAmt
	 */
	public String getCost40ftFrtRtAmt() {
		return this.cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return cost40ftRailFrtRtAmt
	 */
	public String getCost40ftRailFrtRtAmt() {
		return this.cost40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cost20ftFrtRtAmt
	 */
	public String getCost20ftFrtRtAmt() {
		return this.cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline40ftTrkFrtRtAmt
	 */
	public String getGline40ftTrkFrtRtAmt() {
		return this.gline40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline40ftFrtRtAmt
	 */
	public String getGline40ftFrtRtAmt() {
		return this.gline40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	

	/**
	 * Column Info
	 * @param mb20ftRto
	 */
	public void setMb20ftRto(String mb20ftRto) {
		this.mb20ftRto = mb20ftRto;
	}
	
	/**
	 * Column Info
	 * @param gline20ftTrkFrtRtAmt
	 */
	public void setGline20ftTrkFrtRtAmt(String gline20ftTrkFrtRtAmt) {
		this.gline20ftTrkFrtRtAmt = gline20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
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
	 * @param accDt
	 */
	public void setAccDt(String accDt) {
		this.accDt = accDt;
	}
	
	/**
	 * Column Info
	 * @param cost20ftRailFrtRtAmt
	 */
	public void setCost20ftRailFrtRtAmt(String cost20ftRailFrtRtAmt) {
		this.cost20ftRailFrtRtAmt = cost20ftRailFrtRtAmt;
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
	 * @param pntLocNm
	 */
	public void setPntLocNm(String pntLocNm) {
		this.pntLocNm = pntLocNm;
	}
	
	/**
	 * Column Info
	 * @param mb40ftRto
	 */
	public void setMb40ftRto(String mb40ftRto) {
		this.mb40ftRto = mb40ftRto;
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
	 * @param cost20ftTrkFrtRtAmt
	 */
	public void setCost20ftTrkFrtRtAmt(String cost20ftTrkFrtRtAmt) {
		this.cost20ftTrkFrtRtAmt = cost20ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param gline20ftRailFrtRtAmt
	 */
	public void setGline20ftRailFrtRtAmt(String gline20ftRailFrtRtAmt) {
		this.gline20ftRailFrtRtAmt = gline20ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param cost40ftTrkFrtRtAmt
	 */
	public void setCost40ftTrkFrtRtAmt(String cost40ftTrkFrtRtAmt) {
		this.cost40ftTrkFrtRtAmt = cost40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline20ftFrtRtAmt
	 */
	public void setGline20ftFrtRtAmt(String gline20ftFrtRtAmt) {
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param gline40ftRailFrtRtAmt
	 */
	public void setGline40ftRailFrtRtAmt(String gline40ftRailFrtRtAmt) {
		this.gline40ftRailFrtRtAmt = gline40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cost40ftFrtRtAmt
	 */
	public void setCost40ftFrtRtAmt(String cost40ftFrtRtAmt) {
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param cost40ftRailFrtRtAmt
	 */
	public void setCost40ftRailFrtRtAmt(String cost40ftRailFrtRtAmt) {
		this.cost40ftRailFrtRtAmt = cost40ftRailFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cost20ftFrtRtAmt
	 */
	public void setCost20ftFrtRtAmt(String cost20ftFrtRtAmt) {
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline40ftTrkFrtRtAmt
	 */
	public void setGline40ftTrkFrtRtAmt(String gline40ftTrkFrtRtAmt) {
		this.gline40ftTrkFrtRtAmt = gline40ftTrkFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline40ftFrtRtAmt
	 */
	public void setGline40ftFrtRtAmt(String gline40ftFrtRtAmt) {
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setGline20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_trk_frt_rt_amt", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setAccDt(JSPUtil.getParameter(request, prefix + "acc_dt", ""));
		setCost20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_rail_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPntLocNm(JSPUtil.getParameter(request, prefix + "pnt_loc_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCost20ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_trk_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setGline20ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_rail_frt_rt_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setCost40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_trk_frt_rt_amt", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setGline40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_rail_frt_rt_amt", ""));
		setCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_frt_rt_amt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setCost40ftRailFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_rail_frt_rt_amt", ""));
		setCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_frt_rt_amt", ""));
		setGline40ftTrkFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_trk_frt_rt_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUsTariffInquiryListVO[]
	 */
	public SearchUsTariffInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUsTariffInquiryListVO[]
	 */
	public SearchUsTariffInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUsTariffInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] gline20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_trk_frt_rt_amt", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] accDt = (JSPUtil.getParameter(request, prefix	+ "acc_dt", length));
			String[] cost20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_rail_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pntLocNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cost20ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_trk_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] gline20ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_rail_frt_rt_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] cost40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_trk_frt_rt_amt", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] gline40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_rail_frt_rt_amt", length));
			String[] cost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_frt_rt_amt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] cost40ftRailFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_rail_frt_rt_amt", length));
			String[] cost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_frt_rt_amt", length));
			String[] gline40ftTrkFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_trk_frt_rt_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUsTariffInquiryListVO();
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (gline20ftTrkFrtRtAmt[i] != null)
					model.setGline20ftTrkFrtRtAmt(gline20ftTrkFrtRtAmt[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (accDt[i] != null)
					model.setAccDt(accDt[i]);
				if (cost20ftRailFrtRtAmt[i] != null)
					model.setCost20ftRailFrtRtAmt(cost20ftRailFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pntLocNm[i] != null)
					model.setPntLocNm(pntLocNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cost20ftTrkFrtRtAmt[i] != null)
					model.setCost20ftTrkFrtRtAmt(cost20ftTrkFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (gline20ftRailFrtRtAmt[i] != null)
					model.setGline20ftRailFrtRtAmt(gline20ftRailFrtRtAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (cost40ftTrkFrtRtAmt[i] != null)
					model.setCost40ftTrkFrtRtAmt(cost40ftTrkFrtRtAmt[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (gline40ftRailFrtRtAmt[i] != null)
					model.setGline40ftRailFrtRtAmt(gline40ftRailFrtRtAmt[i]);
				if (cost40ftFrtRtAmt[i] != null)
					model.setCost40ftFrtRtAmt(cost40ftFrtRtAmt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (cost40ftRailFrtRtAmt[i] != null)
					model.setCost40ftRailFrtRtAmt(cost40ftRailFrtRtAmt[i]);
				if (cost20ftFrtRtAmt[i] != null)
					model.setCost20ftFrtRtAmt(cost20ftFrtRtAmt[i]);
				if (gline40ftTrkFrtRtAmt[i] != null)
					model.setGline40ftTrkFrtRtAmt(gline40ftTrkFrtRtAmt[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUsTariffInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUsTariffInquiryListVO[]
	 */
	public SearchUsTariffInquiryListVO[] getSearchUsTariffInquiryListVOs(){
		SearchUsTariffInquiryListVO[] vos = (SearchUsTariffInquiryListVO[])models.toArray(new SearchUsTariffInquiryListVO[models.size()]);
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
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftTrkFrtRtAmt = this.gline20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accDt = this.accDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftRailFrtRtAmt = this.cost20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocNm = this.pntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftTrkFrtRtAmt = this.cost20ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftRailFrtRtAmt = this.gline20ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftTrkFrtRtAmt = this.cost40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftRailFrtRtAmt = this.gline40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftFrtRtAmt = this.cost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftRailFrtRtAmt = this.cost40ftRailFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftFrtRtAmt = this.cost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftTrkFrtRtAmt = this.gline40ftTrkFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
