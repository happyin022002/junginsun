/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEdiSummaryReportOptionsVO.java
*@FileTitle : SearchEdiSummaryReportOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.15 전병석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEdiSummaryReportOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEdiSummaryReportOptionsVO> models = new ArrayList<SearchEdiSummaryReportOptionsVO>();
	
	/* Column Info */
	private String podetadate1 = null;
	/* Column Info */
	private String podetadate2 = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String podetadate2Hidden = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vEndpart = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsMode = null;
	/* Column Info */
	private String podetadate1Hidden = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String csGrpId = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String poletddate2 = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String poletddate1Hidden = null;
	/* Column Info */
	private String copStatus = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String poletddate1 = null;
	/* Column Info */
	private String tpId = null;
	/* Column Info */
	private String poletddate2Hidden = null;
	/* Column Info */
	private String vStartpart = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEdiSummaryReportOptionsVO() {}

	public SearchEdiSummaryReportOptionsVO(String ibflag, String pagerows, String userId, String csGrpId, String ediGrpCd, String tpId, String ediSts, String trsMode, String custCd, String vvd, String por, String pol, String pod, String del, String bkgNo, String blNo, String cntrNo, String copStatus, String poletddate1, String poletddate2, String podetadate1, String podetadate2, String poletddate1Hidden, String poletddate2Hidden, String podetadate1Hidden, String podetadate2Hidden, String iPage, String vStartpart, String vEndpart) {
		this.podetadate1 = podetadate1;
		this.podetadate2 = podetadate2;
		this.por = por;
		this.podetadate2Hidden = podetadate2Hidden;
		this.blNo = blNo;
		this.vEndpart = vEndpart;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.trsMode = trsMode;
		this.podetadate1Hidden = podetadate1Hidden;
		this.pol = pol;
		this.userId = userId;
		this.iPage = iPage;
		this.del = del;
		this.pod = pod;
		this.ediGrpCd = ediGrpCd;
		this.csGrpId = csGrpId;
		this.vvd = vvd;
		this.poletddate2 = poletddate2;
		this.ediSts = ediSts;
		this.bkgNo = bkgNo;
		this.poletddate1Hidden = poletddate1Hidden;
		this.copStatus = copStatus;
		this.custCd = custCd;
		this.cntrNo = cntrNo;
		this.poletddate1 = poletddate1;
		this.tpId = tpId;
		this.poletddate2Hidden = poletddate2Hidden;
		this.vStartpart = vStartpart;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("podetadate1", getPodetadate1());
		this.hashColumns.put("podetadate2", getPodetadate2());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("podetadate2_hidden", getPodetadate2Hidden());
		this.hashColumns.put("bl_no_", getBlNo());
		this.hashColumns.put("v_endpart", getVEndpart());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trs_mode_", getTrsMode());
		this.hashColumns.put("podetadate1_hidden", getPodetadate1Hidden());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("poletddate2", getPoletddate2());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("bkg_no_", getBkgNo());
		this.hashColumns.put("poletddate1_hidden", getPoletddate1Hidden());
		this.hashColumns.put("cop_status", getCopStatus());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_no_", getCntrNo());
		this.hashColumns.put("poletddate1", getPoletddate1());
		this.hashColumns.put("tp_id", getTpId());
		this.hashColumns.put("poletddate2_hidden", getPoletddate2Hidden());
		this.hashColumns.put("v_startpart", getVStartpart());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("podetadate1", "podetadate1");
		this.hashFields.put("podetadate2", "podetadate2");
		this.hashFields.put("por", "por");
		this.hashFields.put("podetadate2_hidden", "podetadate2Hidden");
		this.hashFields.put("bl_no_", "blNo");
		this.hashFields.put("v_endpart", "vEndpart");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trs_mode_", "trsMode");
		this.hashFields.put("podetadate1_hidden", "podetadate1Hidden");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("poletddate2", "poletddate2");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("bkg_no_", "bkgNo");
		this.hashFields.put("poletddate1_hidden", "poletddate1Hidden");
		this.hashFields.put("cop_status", "copStatus");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_no_", "cntrNo");
		this.hashFields.put("poletddate1", "poletddate1");
		this.hashFields.put("tp_id", "tpId");
		this.hashFields.put("poletddate2_hidden", "poletddate2Hidden");
		this.hashFields.put("v_startpart", "vStartpart");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podetadate1
	 */
	public String getPodetadate1() {
		return this.podetadate1;
	}
	
	/**
	 * Column Info
	 * @return podetadate2
	 */
	public String getPodetadate2() {
		return this.podetadate2;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return podetadate2Hidden
	 */
	public String getPodetadate2Hidden() {
		return this.podetadate2Hidden;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return vEndpart
	 */
	public String getVEndpart() {
		return this.vEndpart;
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
	 * @return trsMode
	 */
	public String getTrsMode() {
		return this.trsMode;
	}
	
	/**
	 * Column Info
	 * @return podetadate1Hidden
	 */
	public String getPodetadate1Hidden() {
		return this.podetadate1Hidden;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return poletddate2
	 */
	public String getPoletddate2() {
		return this.poletddate2;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return poletddate1Hidden
	 */
	public String getPoletddate1Hidden() {
		return this.poletddate1Hidden;
	}
	
	/**
	 * Column Info
	 * @return copStatus
	 */
	public String getCopStatus() {
		return this.copStatus;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return poletddate1
	 */
	public String getPoletddate1() {
		return this.poletddate1;
	}
	
	/**
	 * Column Info
	 * @return tpId
	 */
	public String getTpId() {
		return this.tpId;
	}
	
	/**
	 * Column Info
	 * @return poletddate2Hidden
	 */
	public String getPoletddate2Hidden() {
		return this.poletddate2Hidden;
	}
	
	/**
	 * Column Info
	 * @return vStartpart
	 */
	public String getVStartpart() {
		return this.vStartpart;
	}
	

	/**
	 * Column Info
	 * @param podetadate1
	 */
	public void setPodetadate1(String podetadate1) {
		this.podetadate1 = podetadate1;
	}
	
	/**
	 * Column Info
	 * @param podetadate2
	 */
	public void setPodetadate2(String podetadate2) {
		this.podetadate2 = podetadate2;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param podetadate2Hidden
	 */
	public void setPodetadate2Hidden(String podetadate2Hidden) {
		this.podetadate2Hidden = podetadate2Hidden;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param vEndpart
	 */
	public void setVEndpart(String vEndpart) {
		this.vEndpart = vEndpart;
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
	 * @param trsMode
	 */
	public void setTrsMode(String trsMode) {
		this.trsMode = trsMode;
	}
	
	/**
	 * Column Info
	 * @param podetadate1Hidden
	 */
	public void setPodetadate1Hidden(String podetadate1Hidden) {
		this.podetadate1Hidden = podetadate1Hidden;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param poletddate2
	 */
	public void setPoletddate2(String poletddate2) {
		this.poletddate2 = poletddate2;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param poletddate1Hidden
	 */
	public void setPoletddate1Hidden(String poletddate1Hidden) {
		this.poletddate1Hidden = poletddate1Hidden;
	}
	
	/**
	 * Column Info
	 * @param copStatus
	 */
	public void setCopStatus(String copStatus) {
		this.copStatus = copStatus;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param poletddate1
	 */
	public void setPoletddate1(String poletddate1) {
		this.poletddate1 = poletddate1;
	}
	
	/**
	 * Column Info
	 * @param tpId
	 */
	public void setTpId(String tpId) {
		this.tpId = tpId;
	}
	
	/**
	 * Column Info
	 * @param poletddate2Hidden
	 */
	public void setPoletddate2Hidden(String poletddate2Hidden) {
		this.poletddate2Hidden = poletddate2Hidden;
	}
	
	/**
	 * Column Info
	 * @param vStartpart
	 */
	public void setVStartpart(String vStartpart) {
		this.vStartpart = vStartpart;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodetadate1(JSPUtil.getParameter(request, "podetadate1", ""));
		setPodetadate2(JSPUtil.getParameter(request, "podetadate2", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setPodetadate2Hidden(JSPUtil.getParameter(request, "podetadate2_hidden", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no_", ""));
		setVEndpart(JSPUtil.getParameter(request, "v_endpart", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrsMode(JSPUtil.getParameter(request, "trs_mode_", ""));
		setPodetadate1Hidden(JSPUtil.getParameter(request, "podetadate1_hidden", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setIPage(JSPUtil.getParameter(request, "i_page", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPoletddate2(JSPUtil.getParameter(request, "poletddate2", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no_", ""));
		setPoletddate1Hidden(JSPUtil.getParameter(request, "poletddate1_hidden", ""));
		setCopStatus(JSPUtil.getParameter(request, "cop_status", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no_", ""));
		setPoletddate1(JSPUtil.getParameter(request, "poletddate1", ""));
		setTpId(JSPUtil.getParameter(request, "tp_id", ""));
		setPoletddate2Hidden(JSPUtil.getParameter(request, "poletddate2_hidden", ""));
		setVStartpart(JSPUtil.getParameter(request, "v_startpart", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdiSummaryReportOptionsVO[]
	 */
	public SearchEdiSummaryReportOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEdiSummaryReportOptionsVO[]
	 */
	public SearchEdiSummaryReportOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEdiSummaryReportOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podetadate1 = (JSPUtil.getParameter(request, prefix	+ "podetadate1", length));
			String[] podetadate2 = (JSPUtil.getParameter(request, prefix	+ "podetadate2", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] podetadate2Hidden = (JSPUtil.getParameter(request, prefix	+ "podetadate2_hidden", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no_", length));
			String[] vEndpart = (JSPUtil.getParameter(request, prefix	+ "v_endpart", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsMode = (JSPUtil.getParameter(request, prefix	+ "trs_mode_", length));
			String[] podetadate1Hidden = (JSPUtil.getParameter(request, prefix	+ "podetadate1_hidden", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] poletddate2 = (JSPUtil.getParameter(request, prefix	+ "poletddate2", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no_", length));
			String[] poletddate1Hidden = (JSPUtil.getParameter(request, prefix	+ "poletddate1_hidden", length));
			String[] copStatus = (JSPUtil.getParameter(request, prefix	+ "cop_status", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no_", length));
			String[] poletddate1 = (JSPUtil.getParameter(request, prefix	+ "poletddate1", length));
			String[] tpId = (JSPUtil.getParameter(request, prefix	+ "tp_id", length));
			String[] poletddate2Hidden = (JSPUtil.getParameter(request, prefix	+ "poletddate2_hidden", length));
			String[] vStartpart = (JSPUtil.getParameter(request, prefix	+ "v_startpart", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEdiSummaryReportOptionsVO();
				if (podetadate1[i] != null)
					model.setPodetadate1(podetadate1[i]);
				if (podetadate2[i] != null)
					model.setPodetadate2(podetadate2[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (podetadate2Hidden[i] != null)
					model.setPodetadate2Hidden(podetadate2Hidden[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vEndpart[i] != null)
					model.setVEndpart(vEndpart[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsMode[i] != null)
					model.setTrsMode(trsMode[i]);
				if (podetadate1Hidden[i] != null)
					model.setPodetadate1Hidden(podetadate1Hidden[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (poletddate2[i] != null)
					model.setPoletddate2(poletddate2[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (poletddate1Hidden[i] != null)
					model.setPoletddate1Hidden(poletddate1Hidden[i]);
				if (copStatus[i] != null)
					model.setCopStatus(copStatus[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (poletddate1[i] != null)
					model.setPoletddate1(poletddate1[i]);
				if (tpId[i] != null)
					model.setTpId(tpId[i]);
				if (poletddate2Hidden[i] != null)
					model.setPoletddate2Hidden(poletddate2Hidden[i]);
				if (vStartpart[i] != null)
					model.setVStartpart(vStartpart[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEdiSummaryReportOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEdiSummaryReportOptionsVO[]
	 */
	public SearchEdiSummaryReportOptionsVO[] getSearchEdiSummaryReportOptionsVOs(){
		SearchEdiSummaryReportOptionsVO[] vos = (SearchEdiSummaryReportOptionsVO[])models.toArray(new SearchEdiSummaryReportOptionsVO[models.size()]);
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
		this.podetadate1 = this.podetadate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetadate2 = this.podetadate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetadate2Hidden = this.podetadate2Hidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vEndpart = this.vEndpart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsMode = this.trsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetadate1Hidden = this.podetadate1Hidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletddate2 = this.poletddate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletddate1Hidden = this.poletddate1Hidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStatus = this.copStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletddate1 = this.poletddate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpId = this.tpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletddate2Hidden = this.poletddate2Hidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vStartpart = this.vStartpart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
