/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCTariffInquiryListVO.java
*@FileTitle : IHCTariffInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.03.09 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IHCTariffInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IHCTariffInquiryListVO> models = new ArrayList<IHCTariffInquiryListVO>();
	
	/* Column Info */
	private String glineLoclCurrDg45ftAmt = null;
	/* Column Info */
	private String ihcCostLocGrpNo = null;
	/* Column Info */
	private String pntLocCdNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String prcTrspModCdNm = null;
	/* Column Info */
	private String glineLoclCurr20ftAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String glineRf20ftFrtRtAmt = null;
	/* Column Info */
	private String glineRf40ftFrtRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String glineDg20ftFrtRtAmt = null;
	/* Column Info */
	private String trsp45ftAgmtWgt = null;
	/* Column Info */
	private String gline45ftFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String ovrWgtCgoSvcFlg = null;
	/* Column Info */
	private String trsp20ftAgmtWgt = null;
	/* Column Info */
	private String glineLoclCurr45ftAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String glineLoclCurrDg40ftAmt = null;
	/* Column Info */
	private String glineLoclCurrDg20ftAmt = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String trsp40ftAgmtWgt = null;
	/* Column Info */
	private String glineDg45ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String rcvDeTermCdNm = null;
	/* Column Info */
	private String glineLoclCurr40ftAmt = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String glineLoclCurrRf40ftAmt = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String glineLoclCurrRf20ftAmt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String glineDg40ftFrtRtAmt = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IHCTariffInquiryListVO() {}

	public IHCTariffInquiryListVO(String ibflag, String pagerows, String ihcCostLocGrpNo, String pntLocCdNm, String pntLocCd, String svcScpCd, String prcTrspModCdNm, String glineLoclCurr20ftAmt, String glineRf20ftFrtRtAmt, String glineRf40ftFrtRtAmt, String glineDg20ftFrtRtAmt, String rcvDeTermCd, String trsp20ftAgmtWgt, String bsePortLocCd, String glineLoclCurrDg40ftAmt, String glineLoclCurrDg20ftAmt, String gline20ftFrtRtAmt, String ihcTrfNo, String trsp40ftAgmtWgt, String loclCurrCd, String orgDestTpCd, String rcvDeTermCdNm, String glineLoclCurr40ftAmt, String gline40ftFrtRtAmt, String glineLoclCurrRf40ftAmt, String zipCd, String glineLoclCurrRf20ftAmt, String prcTrspModCd, String glineDg40ftFrtRtAmt, String ihcCgoTpCd, String hubLocCd, String ovrWgtCgoSvcFlg, String trsp45ftAgmtWgt, String glineLoclCurr45ftAmt, String glineLoclCurrDg45ftAmt, String gline45ftFrtRtAmt, String glineDg45ftFrtRtAmt) {
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
		this.pntLocCdNm = pntLocCdNm;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.prcTrspModCdNm = prcTrspModCdNm;
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
		this.pagerows = pagerows;
		this.glineRf20ftFrtRtAmt = glineRf20ftFrtRtAmt;
		this.glineRf40ftFrtRtAmt = glineRf40ftFrtRtAmt;
		this.ibflag = ibflag;
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
		this.trsp45ftAgmtWgt = trsp45ftAgmtWgt;
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ovrWgtCgoSvcFlg = ovrWgtCgoSvcFlg;
		this.trsp20ftAgmtWgt = trsp20ftAgmtWgt;
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.glineLoclCurrDg40ftAmt = glineLoclCurrDg40ftAmt;
		this.glineLoclCurrDg20ftAmt = glineLoclCurrDg20ftAmt;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.ihcTrfNo = ihcTrfNo;
		this.trsp40ftAgmtWgt = trsp40ftAgmtWgt;
		this.glineDg45ftFrtRtAmt = glineDg45ftFrtRtAmt;
		this.loclCurrCd = loclCurrCd;
		this.orgDestTpCd = orgDestTpCd;
		this.rcvDeTermCdNm = rcvDeTermCdNm;
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.glineLoclCurrRf40ftAmt = glineLoclCurrRf40ftAmt;
		this.zipCd = zipCd;
		this.glineLoclCurrRf20ftAmt = glineLoclCurrRf20ftAmt;
		this.prcTrspModCd = prcTrspModCd;
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gline_locl_curr_dg_45ft_amt", getGlineLoclCurrDg45ftAmt());
		this.hashColumns.put("ihc_cost_loc_grp_no", getIhcCostLocGrpNo());
		this.hashColumns.put("pnt_loc_cd_nm", getPntLocCdNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("prc_trsp_mod_cd_nm", getPrcTrspModCdNm());
		this.hashColumns.put("gline_locl_curr_20ft_amt", getGlineLoclCurr20ftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gline_rf_20ft_frt_rt_amt", getGlineRf20ftFrtRtAmt());
		this.hashColumns.put("gline_rf_40ft_frt_rt_amt", getGlineRf40ftFrtRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_dg_20ft_frt_rt_amt", getGlineDg20ftFrtRtAmt());
		this.hashColumns.put("trsp_45ft_agmt_wgt", getTrsp45ftAgmtWgt());
		this.hashColumns.put("gline_45ft_frt_rt_amt", getGline45ftFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("ovr_wgt_cgo_svc_flg", getOvrWgtCgoSvcFlg());
		this.hashColumns.put("trsp_20ft_agmt_wgt", getTrsp20ftAgmtWgt());
		this.hashColumns.put("gline_locl_curr_45ft_amt", getGlineLoclCurr45ftAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("gline_locl_curr_dg_40ft_amt", getGlineLoclCurrDg40ftAmt());
		this.hashColumns.put("gline_locl_curr_dg_20ft_amt", getGlineLoclCurrDg20ftAmt());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("trsp_40ft_agmt_wgt", getTrsp40ftAgmtWgt());
		this.hashColumns.put("gline_dg_45ft_frt_rt_amt", getGlineDg45ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rcv_de_term_cd_nm", getRcvDeTermCdNm());
		this.hashColumns.put("gline_locl_curr_40ft_amt", getGlineLoclCurr40ftAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("gline_locl_curr_rf_40ft_amt", getGlineLoclCurrRf40ftAmt());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("gline_locl_curr_rf_20ft_amt", getGlineLoclCurrRf20ftAmt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("gline_dg_40ft_frt_rt_amt", getGlineDg40ftFrtRtAmt());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gline_locl_curr_dg_45ft_amt", "glineLoclCurrDg45ftAmt");
		this.hashFields.put("ihc_cost_loc_grp_no", "ihcCostLocGrpNo");
		this.hashFields.put("pnt_loc_cd_nm", "pntLocCdNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("prc_trsp_mod_cd_nm", "prcTrspModCdNm");
		this.hashFields.put("gline_locl_curr_20ft_amt", "glineLoclCurr20ftAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gline_rf_20ft_frt_rt_amt", "glineRf20ftFrtRtAmt");
		this.hashFields.put("gline_rf_40ft_frt_rt_amt", "glineRf40ftFrtRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_dg_20ft_frt_rt_amt", "glineDg20ftFrtRtAmt");
		this.hashFields.put("trsp_45ft_agmt_wgt", "trsp45ftAgmtWgt");
		this.hashFields.put("gline_45ft_frt_rt_amt", "gline45ftFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ovr_wgt_cgo_svc_flg", "ovrWgtCgoSvcFlg");
		this.hashFields.put("trsp_20ft_agmt_wgt", "trsp20ftAgmtWgt");
		this.hashFields.put("gline_locl_curr_45ft_amt", "glineLoclCurr45ftAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("gline_locl_curr_dg_40ft_amt", "glineLoclCurrDg40ftAmt");
		this.hashFields.put("gline_locl_curr_dg_20ft_amt", "glineLoclCurrDg20ftAmt");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("trsp_40ft_agmt_wgt", "trsp40ftAgmtWgt");
		this.hashFields.put("gline_dg_45ft_frt_rt_amt", "glineDg45ftFrtRtAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rcv_de_term_cd_nm", "rcvDeTermCdNm");
		this.hashFields.put("gline_locl_curr_40ft_amt", "glineLoclCurr40ftAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("gline_locl_curr_rf_40ft_amt", "glineLoclCurrRf40ftAmt");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("gline_locl_curr_rf_20ft_amt", "glineLoclCurrRf20ftAmt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("gline_dg_40ft_frt_rt_amt", "glineDg40ftFrtRtAmt");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrDg45ftAmt
	 */
	public String getGlineLoclCurrDg45ftAmt() {
		return this.glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcCostLocGrpNo
	 */
	public String getIhcCostLocGrpNo() {
		return this.ihcCostLocGrpNo;
	}
	
	/**
	 * Column Info
	 * @return pntLocCdNm
	 */
	public String getPntLocCdNm() {
		return this.pntLocCdNm;
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
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
	}
	
	/**
	 * Column Info
	 * @return prcTrspModCdNm
	 */
	public String getPrcTrspModCdNm() {
		return this.prcTrspModCdNm;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr20ftAmt
	 */
	public String getGlineLoclCurr20ftAmt() {
		return this.glineLoclCurr20ftAmt;
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
	 * @return glineRf20ftFrtRtAmt
	 */
	public String getGlineRf20ftFrtRtAmt() {
		return this.glineRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return glineRf40ftFrtRtAmt
	 */
	public String getGlineRf40ftFrtRtAmt() {
		return this.glineRf40ftFrtRtAmt;
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
	 * @return glineDg20ftFrtRtAmt
	 */
	public String getGlineDg20ftFrtRtAmt() {
		return this.glineDg20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp45ftAgmtWgt
	 */
	public String getTrsp45ftAgmtWgt() {
		return this.trsp45ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return gline45ftFrtRtAmt
	 */
	public String getGline45ftFrtRtAmt() {
		return this.gline45ftFrtRtAmt;
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
	 * @return ovrWgtCgoSvcFlg
	 */
	public String getOvrWgtCgoSvcFlg() {
		return this.ovrWgtCgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftAgmtWgt
	 */
	public String getTrsp20ftAgmtWgt() {
		return this.trsp20ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr45ftAmt
	 */
	public String getGlineLoclCurr45ftAmt() {
		return this.glineLoclCurr45ftAmt;
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
	 * @return glineLoclCurrDg40ftAmt
	 */
	public String getGlineLoclCurrDg40ftAmt() {
		return this.glineLoclCurrDg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrDg20ftAmt
	 */
	public String getGlineLoclCurrDg20ftAmt() {
		return this.glineLoclCurrDg20ftAmt;
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
	 * @return trsp40ftAgmtWgt
	 */
	public String getTrsp40ftAgmtWgt() {
		return this.trsp40ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return glineDg45ftFrtRtAmt
	 */
	public String getGlineDg45ftFrtRtAmt() {
		return this.glineDg45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return rcvDeTermCdNm
	 */
	public String getRcvDeTermCdNm() {
		return this.rcvDeTermCdNm;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurr40ftAmt
	 */
	public String getGlineLoclCurr40ftAmt() {
		return this.glineLoclCurr40ftAmt;
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
	 * @return glineLoclCurrRf40ftAmt
	 */
	public String getGlineLoclCurrRf40ftAmt() {
		return this.glineLoclCurrRf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return glineLoclCurrRf20ftAmt
	 */
	public String getGlineLoclCurrRf20ftAmt() {
		return this.glineLoclCurrRf20ftAmt;
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
	 * @return glineDg40ftFrtRtAmt
	 */
	public String getGlineDg40ftFrtRtAmt() {
		return this.glineDg40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ihcCgoTpCd
	 */
	public String getIhcCgoTpCd() {
		return this.ihcCgoTpCd;
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
	 * @param glineLoclCurrDg45ftAmt
	 */
	public void setGlineLoclCurrDg45ftAmt(String glineLoclCurrDg45ftAmt) {
		this.glineLoclCurrDg45ftAmt = glineLoclCurrDg45ftAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcCostLocGrpNo
	 */
	public void setIhcCostLocGrpNo(String ihcCostLocGrpNo) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
	}
	
	/**
	 * Column Info
	 * @param pntLocCdNm
	 */
	public void setPntLocCdNm(String pntLocCdNm) {
		this.pntLocCdNm = pntLocCdNm;
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
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	
	/**
	 * Column Info
	 * @param prcTrspModCdNm
	 */
	public void setPrcTrspModCdNm(String prcTrspModCdNm) {
		this.prcTrspModCdNm = prcTrspModCdNm;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr20ftAmt
	 */
	public void setGlineLoclCurr20ftAmt(String glineLoclCurr20ftAmt) {
		this.glineLoclCurr20ftAmt = glineLoclCurr20ftAmt;
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
	 * @param glineRf20ftFrtRtAmt
	 */
	public void setGlineRf20ftFrtRtAmt(String glineRf20ftFrtRtAmt) {
		this.glineRf20ftFrtRtAmt = glineRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param glineRf40ftFrtRtAmt
	 */
	public void setGlineRf40ftFrtRtAmt(String glineRf40ftFrtRtAmt) {
		this.glineRf40ftFrtRtAmt = glineRf40ftFrtRtAmt;
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
	 * @param glineDg20ftFrtRtAmt
	 */
	public void setGlineDg20ftFrtRtAmt(String glineDg20ftFrtRtAmt) {
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp45ftAgmtWgt
	 */
	public void setTrsp45ftAgmtWgt(String trsp45ftAgmtWgt) {
		this.trsp45ftAgmtWgt = trsp45ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param gline45ftFrtRtAmt
	 */
	public void setGline45ftFrtRtAmt(String gline45ftFrtRtAmt) {
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
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
	 * @param ovrWgtCgoSvcFlg
	 */
	public void setOvrWgtCgoSvcFlg(String ovrWgtCgoSvcFlg) {
		this.ovrWgtCgoSvcFlg = ovrWgtCgoSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftAgmtWgt
	 */
	public void setTrsp20ftAgmtWgt(String trsp20ftAgmtWgt) {
		this.trsp20ftAgmtWgt = trsp20ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr45ftAmt
	 */
	public void setGlineLoclCurr45ftAmt(String glineLoclCurr45ftAmt) {
		this.glineLoclCurr45ftAmt = glineLoclCurr45ftAmt;
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
	 * @param glineLoclCurrDg40ftAmt
	 */
	public void setGlineLoclCurrDg40ftAmt(String glineLoclCurrDg40ftAmt) {
		this.glineLoclCurrDg40ftAmt = glineLoclCurrDg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrDg20ftAmt
	 */
	public void setGlineLoclCurrDg20ftAmt(String glineLoclCurrDg20ftAmt) {
		this.glineLoclCurrDg20ftAmt = glineLoclCurrDg20ftAmt;
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
	 * @param trsp40ftAgmtWgt
	 */
	public void setTrsp40ftAgmtWgt(String trsp40ftAgmtWgt) {
		this.trsp40ftAgmtWgt = trsp40ftAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param glineDg45ftFrtRtAmt
	 */
	public void setGlineDg45ftFrtRtAmt(String glineDg45ftFrtRtAmt) {
		this.glineDg45ftFrtRtAmt = glineDg45ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param rcvDeTermCdNm
	 */
	public void setRcvDeTermCdNm(String rcvDeTermCdNm) {
		this.rcvDeTermCdNm = rcvDeTermCdNm;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurr40ftAmt
	 */
	public void setGlineLoclCurr40ftAmt(String glineLoclCurr40ftAmt) {
		this.glineLoclCurr40ftAmt = glineLoclCurr40ftAmt;
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
	 * @param glineLoclCurrRf40ftAmt
	 */
	public void setGlineLoclCurrRf40ftAmt(String glineLoclCurrRf40ftAmt) {
		this.glineLoclCurrRf40ftAmt = glineLoclCurrRf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param glineLoclCurrRf20ftAmt
	 */
	public void setGlineLoclCurrRf20ftAmt(String glineLoclCurrRf20ftAmt) {
		this.glineLoclCurrRf20ftAmt = glineLoclCurrRf20ftAmt;
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
	 * @param glineDg40ftFrtRtAmt
	 */
	public void setGlineDg40ftFrtRtAmt(String glineDg40ftFrtRtAmt) {
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ihcCgoTpCd
	 */
	public void setIhcCgoTpCd(String ihcCgoTpCd) {
		this.ihcCgoTpCd = ihcCgoTpCd;
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
		setGlineLoclCurrDg45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_45ft_amt", ""));
		setIhcCostLocGrpNo(JSPUtil.getParameter(request, prefix + "ihc_cost_loc_grp_no", ""));
		setPntLocCdNm(JSPUtil.getParameter(request, prefix + "pnt_loc_cd_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setPrcTrspModCdNm(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd_nm", ""));
		setGlineLoclCurr20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_20ft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGlineRf20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_rf_20ft_frt_rt_amt", ""));
		setGlineRf40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_rf_40ft_frt_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlineDg20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_20ft_frt_rt_amt", ""));
		setTrsp45ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_45ft_agmt_wgt", ""));
		setGline45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setOvrWgtCgoSvcFlg(JSPUtil.getParameter(request, prefix + "ovr_wgt_cgo_svc_flg", ""));
		setTrsp20ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_20ft_agmt_wgt", ""));
		setGlineLoclCurr45ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_45ft_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setGlineLoclCurrDg40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_40ft_amt", ""));
		setGlineLoclCurrDg20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_dg_20ft_amt", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setTrsp40ftAgmtWgt(JSPUtil.getParameter(request, prefix + "trsp_40ft_agmt_wgt", ""));
		setGlineDg45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_45ft_frt_rt_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setRcvDeTermCdNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd_nm", ""));
		setGlineLoclCurr40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_40ft_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setGlineLoclCurrRf40ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_rf_40ft_amt", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setGlineLoclCurrRf20ftAmt(JSPUtil.getParameter(request, prefix + "gline_locl_curr_rf_20ft_amt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setGlineDg40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_40ft_frt_rt_amt", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IHCTariffInquiryListVO[]
	 */
	public IHCTariffInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IHCTariffInquiryListVO[]
	 */
	public IHCTariffInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IHCTariffInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glineLoclCurrDg45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_45ft_amt", length));
			String[] ihcCostLocGrpNo = (JSPUtil.getParameter(request, prefix	+ "ihc_cost_loc_grp_no", length));
			String[] pntLocCdNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] prcTrspModCdNm = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd_nm", length));
			String[] glineLoclCurr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_20ft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] glineRf20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_rf_20ft_frt_rt_amt", length));
			String[] glineRf40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_rf_40ft_frt_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] glineDg20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_20ft_frt_rt_amt", length));
			String[] trsp45ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_agmt_wgt", length));
			String[] gline45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ovrWgtCgoSvcFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_cgo_svc_flg", length));
			String[] trsp20ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_agmt_wgt", length));
			String[] glineLoclCurr45ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_45ft_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] glineLoclCurrDg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_40ft_amt", length));
			String[] glineLoclCurrDg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_dg_20ft_amt", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] trsp40ftAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_agmt_wgt", length));
			String[] glineDg45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_45ft_frt_rt_amt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] rcvDeTermCdNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd_nm", length));
			String[] glineLoclCurr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_40ft_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] glineLoclCurrRf40ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_rf_40ft_amt", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] glineLoclCurrRf20ftAmt = (JSPUtil.getParameter(request, prefix	+ "gline_locl_curr_rf_20ft_amt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] glineDg40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_40ft_frt_rt_amt", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IHCTariffInquiryListVO();
				if (glineLoclCurrDg45ftAmt[i] != null)
					model.setGlineLoclCurrDg45ftAmt(glineLoclCurrDg45ftAmt[i]);
				if (ihcCostLocGrpNo[i] != null)
					model.setIhcCostLocGrpNo(ihcCostLocGrpNo[i]);
				if (pntLocCdNm[i] != null)
					model.setPntLocCdNm(pntLocCdNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (prcTrspModCdNm[i] != null)
					model.setPrcTrspModCdNm(prcTrspModCdNm[i]);
				if (glineLoclCurr20ftAmt[i] != null)
					model.setGlineLoclCurr20ftAmt(glineLoclCurr20ftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (glineRf20ftFrtRtAmt[i] != null)
					model.setGlineRf20ftFrtRtAmt(glineRf20ftFrtRtAmt[i]);
				if (glineRf40ftFrtRtAmt[i] != null)
					model.setGlineRf40ftFrtRtAmt(glineRf40ftFrtRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineDg20ftFrtRtAmt[i] != null)
					model.setGlineDg20ftFrtRtAmt(glineDg20ftFrtRtAmt[i]);
				if (trsp45ftAgmtWgt[i] != null)
					model.setTrsp45ftAgmtWgt(trsp45ftAgmtWgt[i]);
				if (gline45ftFrtRtAmt[i] != null)
					model.setGline45ftFrtRtAmt(gline45ftFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (ovrWgtCgoSvcFlg[i] != null)
					model.setOvrWgtCgoSvcFlg(ovrWgtCgoSvcFlg[i]);
				if (trsp20ftAgmtWgt[i] != null)
					model.setTrsp20ftAgmtWgt(trsp20ftAgmtWgt[i]);
				if (glineLoclCurr45ftAmt[i] != null)
					model.setGlineLoclCurr45ftAmt(glineLoclCurr45ftAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (glineLoclCurrDg40ftAmt[i] != null)
					model.setGlineLoclCurrDg40ftAmt(glineLoclCurrDg40ftAmt[i]);
				if (glineLoclCurrDg20ftAmt[i] != null)
					model.setGlineLoclCurrDg20ftAmt(glineLoclCurrDg20ftAmt[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (trsp40ftAgmtWgt[i] != null)
					model.setTrsp40ftAgmtWgt(trsp40ftAgmtWgt[i]);
				if (glineDg45ftFrtRtAmt[i] != null)
					model.setGlineDg45ftFrtRtAmt(glineDg45ftFrtRtAmt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (rcvDeTermCdNm[i] != null)
					model.setRcvDeTermCdNm(rcvDeTermCdNm[i]);
				if (glineLoclCurr40ftAmt[i] != null)
					model.setGlineLoclCurr40ftAmt(glineLoclCurr40ftAmt[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (glineLoclCurrRf40ftAmt[i] != null)
					model.setGlineLoclCurrRf40ftAmt(glineLoclCurrRf40ftAmt[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (glineLoclCurrRf20ftAmt[i] != null)
					model.setGlineLoclCurrRf20ftAmt(glineLoclCurrRf20ftAmt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (glineDg40ftFrtRtAmt[i] != null)
					model.setGlineDg40ftFrtRtAmt(glineDg40ftFrtRtAmt[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIHCTariffInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IHCTariffInquiryListVO[]
	 */
	public IHCTariffInquiryListVO[] getIHCTariffInquiryListVOs(){
		IHCTariffInquiryListVO[] vos = (IHCTariffInquiryListVO[])models.toArray(new IHCTariffInquiryListVO[models.size()]);
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
		this.glineLoclCurrDg45ftAmt = this.glineLoclCurrDg45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCostLocGrpNo = this.ihcCostLocGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCdNm = this.pntLocCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCdNm = this.prcTrspModCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr20ftAmt = this.glineLoclCurr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRf20ftFrtRtAmt = this.glineRf20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRf40ftFrtRtAmt = this.glineRf40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg20ftFrtRtAmt = this.glineDg20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftAgmtWgt = this.trsp45ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftFrtRtAmt = this.gline45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtCgoSvcFlg = this.ovrWgtCgoSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAgmtWgt = this.trsp20ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr45ftAmt = this.glineLoclCurr45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg40ftAmt = this.glineLoclCurrDg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrDg20ftAmt = this.glineLoclCurrDg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAgmtWgt = this.trsp40ftAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg45ftFrtRtAmt = this.glineDg45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCdNm = this.rcvDeTermCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurr40ftAmt = this.glineLoclCurr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrRf40ftAmt = this.glineLoclCurrRf40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineLoclCurrRf20ftAmt = this.glineLoclCurrRf20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg40ftFrtRtAmt = this.glineDg40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
