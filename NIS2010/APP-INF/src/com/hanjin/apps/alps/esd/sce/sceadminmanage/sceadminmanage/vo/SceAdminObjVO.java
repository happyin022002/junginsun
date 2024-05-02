/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceAdminObjVO.java
*@FileTitle : SceAdminObjVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2011.01.04 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceAdminObjVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceAdminObjVO> models = new ArrayList<SceAdminObjVO>();
	
	/* Column Info */
	private String actBkgNo = null;
	/* Column Info */
	private String rplnCntrNo = null;
	/* Column Info */
	private String cdiffToDt = null;
	/* Column Info */
	private String cdiffBlNo = null;
	/* Column Info */
	private String actCntrNo = null;
	/* Column Info */
	private String cdiffFmDt = null;
	/* Column Info */
	private String rplnCopNo = null;
	/* Column Info */
	private String actBlNo = null;
	/* Column Info */
	private String actUmchTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actFmDt = null;
	/* Column Info */
	private String tmlFmDt = null;
	/* Column Info */
	private String actToDt = null;
	/* Column Info */
	private String cdiffCopNo = null;
	/* Column Info */
	private String rplnToDt = null;
	/* Column Info */
	private String mstFmDt = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String rplnFmDt = null;
	/* Column Info */
	private String cdiffBkgNo = null;
	/* Column Info */
	private String mstToDt = null;
	/* Column Info */
	private String tmlToDt = null;
	/* Column Info */
	private String rplnBkgNo = null;
	/* Column Info */
	private String rplnBlNo = null;
	/* Column Info */
	private String actCopNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceAdminObjVO() {}

	public SceAdminObjVO(String ibflag, String pagerows, String tmlFmDt, String tmlToDt, String rplnFmDt, String rplnToDt, String mstFmDt, String mstToDt, String rplnBkgNo, String rplnBlNo, String rplnCntrNo, String rplnCopNo, String cdiffBkgNo, String cdiffBlNo, String cdiffCopNo, String cdiffFmDt, String cdiffToDt, String actFmDt, String actToDt, String actBkgNo, String actCntrNo, String actBlNo, String actCopNo, String actUmchTpCd, String actRcvTpCd) {
		this.actBkgNo = actBkgNo;
		this.rplnCntrNo = rplnCntrNo;
		this.cdiffToDt = cdiffToDt;
		this.cdiffBlNo = cdiffBlNo;
		this.actCntrNo = actCntrNo;
		this.cdiffFmDt = cdiffFmDt;
		this.rplnCopNo = rplnCopNo;
		this.actBlNo = actBlNo;
		this.actUmchTpCd = actUmchTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.actFmDt = actFmDt;
		this.tmlFmDt = tmlFmDt;
		this.actToDt = actToDt;
		this.cdiffCopNo = cdiffCopNo;
		this.rplnToDt = rplnToDt;
		this.mstFmDt = mstFmDt;
		this.actRcvTpCd = actRcvTpCd;
		this.rplnFmDt = rplnFmDt;
		this.cdiffBkgNo = cdiffBkgNo;
		this.mstToDt = mstToDt;
		this.tmlToDt = tmlToDt;
		this.rplnBkgNo = rplnBkgNo;
		this.rplnBlNo = rplnBlNo;
		this.actCopNo = actCopNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_bkg_no", getActBkgNo());
		this.hashColumns.put("rpln_cntr_no", getRplnCntrNo());
		this.hashColumns.put("cdiff_to_dt", getCdiffToDt());
		this.hashColumns.put("cdiff_bl_no", getCdiffBlNo());
		this.hashColumns.put("act_cntr_no", getActCntrNo());
		this.hashColumns.put("cdiff_fm_dt", getCdiffFmDt());
		this.hashColumns.put("rpln_cop_no", getRplnCopNo());
		this.hashColumns.put("act_bl_no", getActBlNo());
		this.hashColumns.put("act_umch_tp_cd", getActUmchTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_fm_dt", getActFmDt());
		this.hashColumns.put("tml_fm_dt", getTmlFmDt());
		this.hashColumns.put("act_to_dt", getActToDt());
		this.hashColumns.put("cdiff_cop_no", getCdiffCopNo());
		this.hashColumns.put("rpln_to_dt", getRplnToDt());
		this.hashColumns.put("mst_fm_dt", getMstFmDt());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("rpln_fm_dt", getRplnFmDt());
		this.hashColumns.put("cdiff_bkg_no", getCdiffBkgNo());
		this.hashColumns.put("mst_to_dt", getMstToDt());
		this.hashColumns.put("tml_to_dt", getTmlToDt());
		this.hashColumns.put("rpln_bkg_no", getRplnBkgNo());
		this.hashColumns.put("rpln_bl_no", getRplnBlNo());
		this.hashColumns.put("act_cop_no", getActCopNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_bkg_no", "actBkgNo");
		this.hashFields.put("rpln_cntr_no", "rplnCntrNo");
		this.hashFields.put("cdiff_to_dt", "cdiffToDt");
		this.hashFields.put("cdiff_bl_no", "cdiffBlNo");
		this.hashFields.put("act_cntr_no", "actCntrNo");
		this.hashFields.put("cdiff_fm_dt", "cdiffFmDt");
		this.hashFields.put("rpln_cop_no", "rplnCopNo");
		this.hashFields.put("act_bl_no", "actBlNo");
		this.hashFields.put("act_umch_tp_cd", "actUmchTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_fm_dt", "actFmDt");
		this.hashFields.put("tml_fm_dt", "tmlFmDt");
		this.hashFields.put("act_to_dt", "actToDt");
		this.hashFields.put("cdiff_cop_no", "cdiffCopNo");
		this.hashFields.put("rpln_to_dt", "rplnToDt");
		this.hashFields.put("mst_fm_dt", "mstFmDt");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("rpln_fm_dt", "rplnFmDt");
		this.hashFields.put("cdiff_bkg_no", "cdiffBkgNo");
		this.hashFields.put("mst_to_dt", "mstToDt");
		this.hashFields.put("tml_to_dt", "tmlToDt");
		this.hashFields.put("rpln_bkg_no", "rplnBkgNo");
		this.hashFields.put("rpln_bl_no", "rplnBlNo");
		this.hashFields.put("act_cop_no", "actCopNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actBkgNo
	 */
	public String getActBkgNo() {
		return this.actBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rplnCntrNo
	 */
	public String getRplnCntrNo() {
		return this.rplnCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cdiffToDt
	 */
	public String getCdiffToDt() {
		return this.cdiffToDt;
	}
	
	/**
	 * Column Info
	 * @return cdiffBlNo
	 */
	public String getCdiffBlNo() {
		return this.cdiffBlNo;
	}
	
	/**
	 * Column Info
	 * @return actCntrNo
	 */
	public String getActCntrNo() {
		return this.actCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cdiffFmDt
	 */
	public String getCdiffFmDt() {
		return this.cdiffFmDt;
	}
	
	/**
	 * Column Info
	 * @return rplnCopNo
	 */
	public String getRplnCopNo() {
		return this.rplnCopNo;
	}
	
	/**
	 * Column Info
	 * @return actBlNo
	 */
	public String getActBlNo() {
		return this.actBlNo;
	}
	
	/**
	 * Column Info
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
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
	 * @return actFmDt
	 */
	public String getActFmDt() {
		return this.actFmDt;
	}
	
	/**
	 * Column Info
	 * @return tmlFmDt
	 */
	public String getTmlFmDt() {
		return this.tmlFmDt;
	}
	
	/**
	 * Column Info
	 * @return actToDt
	 */
	public String getActToDt() {
		return this.actToDt;
	}
	
	/**
	 * Column Info
	 * @return cdiffCopNo
	 */
	public String getCdiffCopNo() {
		return this.cdiffCopNo;
	}
	
	/**
	 * Column Info
	 * @return rplnToDt
	 */
	public String getRplnToDt() {
		return this.rplnToDt;
	}
	
	/**
	 * Column Info
	 * @return mstFmDt
	 */
	public String getMstFmDt() {
		return this.mstFmDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rplnFmDt
	 */
	public String getRplnFmDt() {
		return this.rplnFmDt;
	}
	
	/**
	 * Column Info
	 * @return cdiffBkgNo
	 */
	public String getCdiffBkgNo() {
		return this.cdiffBkgNo;
	}
	
	/**
	 * Column Info
	 * @return mstToDt
	 */
	public String getMstToDt() {
		return this.mstToDt;
	}
	
	/**
	 * Column Info
	 * @return tmlToDt
	 */
	public String getTmlToDt() {
		return this.tmlToDt;
	}
	
	/**
	 * Column Info
	 * @return rplnBkgNo
	 */
	public String getRplnBkgNo() {
		return this.rplnBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rplnBlNo
	 */
	public String getRplnBlNo() {
		return this.rplnBlNo;
	}
	
	/**
	 * Column Info
	 * @return actCopNo
	 */
	public String getActCopNo() {
		return this.actCopNo;
	}
	

	/**
	 * Column Info
	 * @param actBkgNo
	 */
	public void setActBkgNo(String actBkgNo) {
		this.actBkgNo = actBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rplnCntrNo
	 */
	public void setRplnCntrNo(String rplnCntrNo) {
		this.rplnCntrNo = rplnCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cdiffToDt
	 */
	public void setCdiffToDt(String cdiffToDt) {
		this.cdiffToDt = cdiffToDt;
	}
	
	/**
	 * Column Info
	 * @param cdiffBlNo
	 */
	public void setCdiffBlNo(String cdiffBlNo) {
		this.cdiffBlNo = cdiffBlNo;
	}
	
	/**
	 * Column Info
	 * @param actCntrNo
	 */
	public void setActCntrNo(String actCntrNo) {
		this.actCntrNo = actCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cdiffFmDt
	 */
	public void setCdiffFmDt(String cdiffFmDt) {
		this.cdiffFmDt = cdiffFmDt;
	}
	
	/**
	 * Column Info
	 * @param rplnCopNo
	 */
	public void setRplnCopNo(String rplnCopNo) {
		this.rplnCopNo = rplnCopNo;
	}
	
	/**
	 * Column Info
	 * @param actBlNo
	 */
	public void setActBlNo(String actBlNo) {
		this.actBlNo = actBlNo;
	}
	
	/**
	 * Column Info
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
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
	 * @param actFmDt
	 */
	public void setActFmDt(String actFmDt) {
		this.actFmDt = actFmDt;
	}
	
	/**
	 * Column Info
	 * @param tmlFmDt
	 */
	public void setTmlFmDt(String tmlFmDt) {
		this.tmlFmDt = tmlFmDt;
	}
	
	/**
	 * Column Info
	 * @param actToDt
	 */
	public void setActToDt(String actToDt) {
		this.actToDt = actToDt;
	}
	
	/**
	 * Column Info
	 * @param cdiffCopNo
	 */
	public void setCdiffCopNo(String cdiffCopNo) {
		this.cdiffCopNo = cdiffCopNo;
	}
	
	/**
	 * Column Info
	 * @param rplnToDt
	 */
	public void setRplnToDt(String rplnToDt) {
		this.rplnToDt = rplnToDt;
	}
	
	/**
	 * Column Info
	 * @param mstFmDt
	 */
	public void setMstFmDt(String mstFmDt) {
		this.mstFmDt = mstFmDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rplnFmDt
	 */
	public void setRplnFmDt(String rplnFmDt) {
		this.rplnFmDt = rplnFmDt;
	}
	
	/**
	 * Column Info
	 * @param cdiffBkgNo
	 */
	public void setCdiffBkgNo(String cdiffBkgNo) {
		this.cdiffBkgNo = cdiffBkgNo;
	}
	
	/**
	 * Column Info
	 * @param mstToDt
	 */
	public void setMstToDt(String mstToDt) {
		this.mstToDt = mstToDt;
	}
	
	/**
	 * Column Info
	 * @param tmlToDt
	 */
	public void setTmlToDt(String tmlToDt) {
		this.tmlToDt = tmlToDt;
	}
	
	/**
	 * Column Info
	 * @param rplnBkgNo
	 */
	public void setRplnBkgNo(String rplnBkgNo) {
		this.rplnBkgNo = rplnBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rplnBlNo
	 */
	public void setRplnBlNo(String rplnBlNo) {
		this.rplnBlNo = rplnBlNo;
	}
	
	/**
	 * Column Info
	 * @param actCopNo
	 */
	public void setActCopNo(String actCopNo) {
		this.actCopNo = actCopNo;
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
		setActBkgNo(JSPUtil.getParameter(request, prefix + "act_bkg_no", ""));
		setRplnCntrNo(JSPUtil.getParameter(request, prefix + "rpln_cntr_no", ""));
		setCdiffToDt(JSPUtil.getParameter(request, prefix + "cdiff_to_dt", ""));
		setCdiffBlNo(JSPUtil.getParameter(request, prefix + "cdiff_bl_no", ""));
		setActCntrNo(JSPUtil.getParameter(request, prefix + "act_cntr_no", ""));
		setCdiffFmDt(JSPUtil.getParameter(request, prefix + "cdiff_fm_dt", ""));
		setRplnCopNo(JSPUtil.getParameter(request, prefix + "rpln_cop_no", ""));
		setActBlNo(JSPUtil.getParameter(request, prefix + "act_bl_no", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, prefix + "act_umch_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActFmDt(JSPUtil.getParameter(request, prefix + "act_fm_dt", ""));
		setTmlFmDt(JSPUtil.getParameter(request, prefix + "tml_fm_dt", ""));
		setActToDt(JSPUtil.getParameter(request, prefix + "act_to_dt", ""));
		setCdiffCopNo(JSPUtil.getParameter(request, prefix + "cdiff_cop_no", ""));
		setRplnToDt(JSPUtil.getParameter(request, prefix + "rpln_to_dt", ""));
		setMstFmDt(JSPUtil.getParameter(request, prefix + "mst_fm_dt", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setRplnFmDt(JSPUtil.getParameter(request, prefix + "rpln_fm_dt", ""));
		setCdiffBkgNo(JSPUtil.getParameter(request, prefix + "cdiff_bkg_no", ""));
		setMstToDt(JSPUtil.getParameter(request, prefix + "mst_to_dt", ""));
		setTmlToDt(JSPUtil.getParameter(request, prefix + "tml_to_dt", ""));
		setRplnBkgNo(JSPUtil.getParameter(request, prefix + "rpln_bkg_no", ""));
		setRplnBlNo(JSPUtil.getParameter(request, prefix + "rpln_bl_no", ""));
		setActCopNo(JSPUtil.getParameter(request, prefix + "act_cop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceAdminObjVO[]
	 */
	public SceAdminObjVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceAdminObjVO[]
	 */
	public SceAdminObjVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceAdminObjVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actBkgNo = (JSPUtil.getParameter(request, prefix	+ "act_bkg_no", length));
			String[] rplnCntrNo = (JSPUtil.getParameter(request, prefix	+ "rpln_cntr_no", length));
			String[] cdiffToDt = (JSPUtil.getParameter(request, prefix	+ "cdiff_to_dt", length));
			String[] cdiffBlNo = (JSPUtil.getParameter(request, prefix	+ "cdiff_bl_no", length));
			String[] actCntrNo = (JSPUtil.getParameter(request, prefix	+ "act_cntr_no", length));
			String[] cdiffFmDt = (JSPUtil.getParameter(request, prefix	+ "cdiff_fm_dt", length));
			String[] rplnCopNo = (JSPUtil.getParameter(request, prefix	+ "rpln_cop_no", length));
			String[] actBlNo = (JSPUtil.getParameter(request, prefix	+ "act_bl_no", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "act_umch_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actFmDt = (JSPUtil.getParameter(request, prefix	+ "act_fm_dt", length));
			String[] tmlFmDt = (JSPUtil.getParameter(request, prefix	+ "tml_fm_dt", length));
			String[] actToDt = (JSPUtil.getParameter(request, prefix	+ "act_to_dt", length));
			String[] cdiffCopNo = (JSPUtil.getParameter(request, prefix	+ "cdiff_cop_no", length));
			String[] rplnToDt = (JSPUtil.getParameter(request, prefix	+ "rpln_to_dt", length));
			String[] mstFmDt = (JSPUtil.getParameter(request, prefix	+ "mst_fm_dt", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] rplnFmDt = (JSPUtil.getParameter(request, prefix	+ "rpln_fm_dt", length));
			String[] cdiffBkgNo = (JSPUtil.getParameter(request, prefix	+ "cdiff_bkg_no", length));
			String[] mstToDt = (JSPUtil.getParameter(request, prefix	+ "mst_to_dt", length));
			String[] tmlToDt = (JSPUtil.getParameter(request, prefix	+ "tml_to_dt", length));
			String[] rplnBkgNo = (JSPUtil.getParameter(request, prefix	+ "rpln_bkg_no", length));
			String[] rplnBlNo = (JSPUtil.getParameter(request, prefix	+ "rpln_bl_no", length));
			String[] actCopNo = (JSPUtil.getParameter(request, prefix	+ "act_cop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceAdminObjVO();
				if (actBkgNo[i] != null)
					model.setActBkgNo(actBkgNo[i]);
				if (rplnCntrNo[i] != null)
					model.setRplnCntrNo(rplnCntrNo[i]);
				if (cdiffToDt[i] != null)
					model.setCdiffToDt(cdiffToDt[i]);
				if (cdiffBlNo[i] != null)
					model.setCdiffBlNo(cdiffBlNo[i]);
				if (actCntrNo[i] != null)
					model.setActCntrNo(actCntrNo[i]);
				if (cdiffFmDt[i] != null)
					model.setCdiffFmDt(cdiffFmDt[i]);
				if (rplnCopNo[i] != null)
					model.setRplnCopNo(rplnCopNo[i]);
				if (actBlNo[i] != null)
					model.setActBlNo(actBlNo[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actFmDt[i] != null)
					model.setActFmDt(actFmDt[i]);
				if (tmlFmDt[i] != null)
					model.setTmlFmDt(tmlFmDt[i]);
				if (actToDt[i] != null)
					model.setActToDt(actToDt[i]);
				if (cdiffCopNo[i] != null)
					model.setCdiffCopNo(cdiffCopNo[i]);
				if (rplnToDt[i] != null)
					model.setRplnToDt(rplnToDt[i]);
				if (mstFmDt[i] != null)
					model.setMstFmDt(mstFmDt[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (rplnFmDt[i] != null)
					model.setRplnFmDt(rplnFmDt[i]);
				if (cdiffBkgNo[i] != null)
					model.setCdiffBkgNo(cdiffBkgNo[i]);
				if (mstToDt[i] != null)
					model.setMstToDt(mstToDt[i]);
				if (tmlToDt[i] != null)
					model.setTmlToDt(tmlToDt[i]);
				if (rplnBkgNo[i] != null)
					model.setRplnBkgNo(rplnBkgNo[i]);
				if (rplnBlNo[i] != null)
					model.setRplnBlNo(rplnBlNo[i]);
				if (actCopNo[i] != null)
					model.setActCopNo(actCopNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceAdminObjVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceAdminObjVO[]
	 */
	public SceAdminObjVO[] getSceAdminObjVOs(){
		SceAdminObjVO[] vos = (SceAdminObjVO[])models.toArray(new SceAdminObjVO[models.size()]);
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
		this.actBkgNo = this.actBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnCntrNo = this.rplnCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdiffToDt = this.cdiffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdiffBlNo = this.cdiffBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntrNo = this.actCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdiffFmDt = this.cdiffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnCopNo = this.rplnCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBlNo = this.actBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFmDt = this.actFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlFmDt = this.tmlFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actToDt = this.actToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdiffCopNo = this.cdiffCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnToDt = this.rplnToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstFmDt = this.mstFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnFmDt = this.rplnFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdiffBkgNo = this.cdiffBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstToDt = this.mstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlToDt = this.tmlToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnBkgNo = this.rplnBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnBlNo = this.rplnBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCopNo = this.actCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
