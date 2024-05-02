/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchGuidelineRoutePopupListVO.java
*@FileTitle : SearchGuidelineRoutePopupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.10.26 이은섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchGuidelineRoutePopupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchGuidelineRoutePopupListVO> models = new ArrayList<SearchGuidelineRoutePopupListVO>();
	
	/* Column Info */
	private String ihcCostLocGrpNo = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String pntLocCdNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String rcvDeTermCdNm = null;
	/* Column Info */
	private String prcTrspModCdNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String svcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String glineDg20ftFrtRtAmt = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String glineDg40ftFrtRtAmt = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String bsePortLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchGuidelineRoutePopupListVO() {}

	public SearchGuidelineRoutePopupListVO(String ibflag, String pagerows, String svcTpCd, String svcScpCd, String pntLocCd, String ihcCostLocGrpNo, String pntLocCdNm, String hubLocCd, String bsePortLocCd, String prcTrspModCd, String prcTrspModCdNm, String rcvDeTermCd, String rcvDeTermCdNm, String gline20ftFrtRtAmt, String gline40ftFrtRtAmt, String glineDg20ftFrtRtAmt, String glineDg40ftFrtRtAmt, String orgDestTpCd, String ihcCgoTpCd) {
		this.ihcCostLocGrpNo = ihcCostLocGrpNo;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.pntLocCdNm = pntLocCdNm;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.orgDestTpCd = orgDestTpCd;
		this.rcvDeTermCdNm = rcvDeTermCdNm;
		this.prcTrspModCdNm = prcTrspModCdNm;
		this.pagerows = pagerows;
		this.svcTpCd = svcTpCd;
		this.ibflag = ibflag;
		this.glineDg20ftFrtRtAmt = glineDg20ftFrtRtAmt;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.glineDg40ftFrtRtAmt = glineDg40ftFrtRtAmt;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.hubLocCd = hubLocCd;
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ihc_cost_loc_grp_no", getIhcCostLocGrpNo());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("pnt_loc_cd_nm", getPntLocCdNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rcv_de_term_cd_nm", getRcvDeTermCdNm());
		this.hashColumns.put("prc_trsp_mod_cd_nm", getPrcTrspModCdNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svc_tp_cd", getSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_dg_20ft_frt_rt_amt", getGlineDg20ftFrtRtAmt());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("gline_dg_40ft_frt_rt_amt", getGlineDg40ftFrtRtAmt());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ihc_cost_loc_grp_no", "ihcCostLocGrpNo");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("pnt_loc_cd_nm", "pntLocCdNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rcv_de_term_cd_nm", "rcvDeTermCdNm");
		this.hashFields.put("prc_trsp_mod_cd_nm", "prcTrspModCdNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svc_tp_cd", "svcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_dg_20ft_frt_rt_amt", "glineDg20ftFrtRtAmt");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("gline_dg_40ft_frt_rt_amt", "glineDg40ftFrtRtAmt");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		return this.hashFields;
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
	 * @return gline20ftFrtRtAmt
	 */
	public String getGline20ftFrtRtAmt() {
		return this.gline20ftFrtRtAmt;
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
	 * @return prcTrspModCdNm
	 */
	public String getPrcTrspModCdNm() {
		return this.prcTrspModCdNm;
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
	 * @return svcTpCd
	 */
	public String getSvcTpCd() {
		return this.svcTpCd;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
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
	 * @param gline20ftFrtRtAmt
	 */
	public void setGline20ftFrtRtAmt(String gline20ftFrtRtAmt) {
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
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
	 * @param prcTrspModCdNm
	 */
	public void setPrcTrspModCdNm(String prcTrspModCdNm) {
		this.prcTrspModCdNm = prcTrspModCdNm;
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
	 * @param svcTpCd
	 */
	public void setSvcTpCd(String svcTpCd) {
		this.svcTpCd = svcTpCd;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
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
		setIhcCostLocGrpNo(JSPUtil.getParameter(request, prefix + "ihc_cost_loc_grp_no", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setPntLocCdNm(JSPUtil.getParameter(request, prefix + "pnt_loc_cd_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setRcvDeTermCdNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd_nm", ""));
		setPrcTrspModCdNm(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvcTpCd(JSPUtil.getParameter(request, prefix + "svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlineDg20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_20ft_frt_rt_amt", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setGlineDg40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_dg_40ft_frt_rt_amt", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setHubLocCd(JSPUtil.getParameter(request, prefix + "hub_loc_cd", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchGuidelineRoutePopupListVO[]
	 */
	public SearchGuidelineRoutePopupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchGuidelineRoutePopupListVO[]
	 */
	public SearchGuidelineRoutePopupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchGuidelineRoutePopupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ihcCostLocGrpNo = (JSPUtil.getParameter(request, prefix	+ "ihc_cost_loc_grp_no", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] pntLocCdNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd_nm", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] rcvDeTermCdNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd_nm", length));
			String[] prcTrspModCdNm = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svcTpCd = (JSPUtil.getParameter(request, prefix	+ "svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] glineDg20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_20ft_frt_rt_amt", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_trsp_mod_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] glineDg40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_dg_40ft_frt_rt_amt", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchGuidelineRoutePopupListVO();
				if (ihcCostLocGrpNo[i] != null)
					model.setIhcCostLocGrpNo(ihcCostLocGrpNo[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (pntLocCdNm[i] != null)
					model.setPntLocCdNm(pntLocCdNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (rcvDeTermCdNm[i] != null)
					model.setRcvDeTermCdNm(rcvDeTermCdNm[i]);
				if (prcTrspModCdNm[i] != null)
					model.setPrcTrspModCdNm(prcTrspModCdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svcTpCd[i] != null)
					model.setSvcTpCd(svcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineDg20ftFrtRtAmt[i] != null)
					model.setGlineDg20ftFrtRtAmt(glineDg20ftFrtRtAmt[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (glineDg40ftFrtRtAmt[i] != null)
					model.setGlineDg40ftFrtRtAmt(glineDg40ftFrtRtAmt[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchGuidelineRoutePopupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchGuidelineRoutePopupListVO[]
	 */
	public SearchGuidelineRoutePopupListVO[] getSearchGuidelineRoutePopupListVOs(){
		SearchGuidelineRoutePopupListVO[] vos = (SearchGuidelineRoutePopupListVO[])models.toArray(new SearchGuidelineRoutePopupListVO[models.size()]);
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
		this.ihcCostLocGrpNo = this.ihcCostLocGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCdNm = this.pntLocCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCdNm = this.rcvDeTermCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCdNm = this.prcTrspModCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcTpCd = this.svcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg20ftFrtRtAmt = this.glineDg20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineDg40ftFrtRtAmt = this.glineDg40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
