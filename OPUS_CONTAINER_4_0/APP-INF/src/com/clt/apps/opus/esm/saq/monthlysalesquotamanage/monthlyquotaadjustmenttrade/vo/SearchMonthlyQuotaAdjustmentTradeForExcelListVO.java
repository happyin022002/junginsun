/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchMonthlyQuotaAdjustmentTradeForExcelListVO.java
*@FileTitle : SearchMonthlyQuotaAdjustmentTradeForExcelListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.05.03 이상용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo;

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
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaAdjustmentTradeForExcelListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaAdjustmentTradeForExcelListVO> models = new ArrayList<SearchMonthlyQuotaAdjustmentTradeForExcelListVO>();
	
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String opb = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String mqtaStepCd = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mqtaVerNo = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String raOpfitUcAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String laneGrp = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String editable = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String unit = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String voyage = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO() {}

	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO(String ibflag, String pagerows, String rn, String editable, String mqtaStepCd, String bseYr, String bseQtrCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String mqtaVerNo, String laneGrp, String bseMon, String polCd, String podCd, String voyage, String bsa, String rhqCd, String unit, String lodQty, String grsRev, String grsRpbRev, String raCmUcAmt, String cmpb, String raOpfitUcAmt, String opb) {
		this.rn = rn;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.opb = opb;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.mqtaStepCd = mqtaStepCd;
		this.grsRpbRev = grsRpbRev;
		this.dirCd = dirCd;
		this.mqtaVerNo = mqtaVerNo;
		this.lodQty = lodQty;
		this.raOpfitUcAmt = raOpfitUcAmt;
		this.rhqCd = rhqCd;
		this.laneGrp = laneGrp;
		this.bseYr = bseYr;
		this.cmpb = cmpb;
		this.editable = editable;
		this.podCd = podCd;
		this.unit = unit;
		this.raCmUcAmt = raCmUcAmt;
		this.voyage = voyage;
		this.grsRev = grsRev;
		this.bsa = bsa;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("mqta_step_cd", getMqtaStepCd());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mqta_ver_no", getMqtaVerNo());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("ra_opfit_uc_amt", getRaOpfitUcAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("lane_grp", getLaneGrp());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("editable", getEditable());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("voyage", getVoyage());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rn", "rn");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("mqta_step_cd", "mqtaStepCd");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mqta_ver_no", "mqtaVerNo");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("ra_opfit_uc_amt", "raOpfitUcAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("lane_grp", "laneGrp");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("editable", "editable");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("voyage", "voyage");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return opb
	 */
	public String getOpb() {
		return this.opb;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return mqtaStepCd
	 */
	public String getMqtaStepCd() {
		return this.mqtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return mqtaVerNo
	 */
	public String getMqtaVerNo() {
		return this.mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return raOpfitUcAmt
	 */
	public String getRaOpfitUcAmt() {
		return this.raOpfitUcAmt;
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
	 * @return laneGrp
	 */
	public String getLaneGrp() {
		return this.laneGrp;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return editable
	 */
	public String getEditable() {
		return this.editable;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Column Info
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return voyage
	 */
	public String getVoyage() {
		return this.voyage;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param opb
	 */
	public void setOpb(String opb) {
		this.opb = opb;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param mqtaStepCd
	 */
	public void setMqtaStepCd(String mqtaStepCd) {
		this.mqtaStepCd = mqtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param mqtaVerNo
	 */
	public void setMqtaVerNo(String mqtaVerNo) {
		this.mqtaVerNo = mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param raOpfitUcAmt
	 */
	public void setRaOpfitUcAmt(String raOpfitUcAmt) {
		this.raOpfitUcAmt = raOpfitUcAmt;
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
	 * @param laneGrp
	 */
	public void setLaneGrp(String laneGrp) {
		this.laneGrp = laneGrp;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param editable
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	/**
	 * Column Info
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param voyage
	 */
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOpb(JSPUtil.getParameter(request, prefix + "opb", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setMqtaStepCd(JSPUtil.getParameter(request, prefix + "mqta_step_cd", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, prefix + "grs_rpb_rev", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setMqtaVerNo(JSPUtil.getParameter(request, prefix + "mqta_ver_no", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRaOpfitUcAmt(JSPUtil.getParameter(request, prefix + "ra_opfit_uc_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setLaneGrp(JSPUtil.getParameter(request, prefix + "lane_grp", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setEditable(JSPUtil.getParameter(request, prefix + "editable", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setUnit(JSPUtil.getParameter(request, prefix + "unit", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setVoyage(JSPUtil.getParameter(request, prefix + "voyage", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaAdjustmentTradeForExcelListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaAdjustmentTradeForExcelListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaAdjustmentTradeForExcelListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] mqtaStepCd = (JSPUtil.getParameter(request, prefix	+ "mqta_step_cd", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_no", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] raOpfitUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_opfit_uc_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] laneGrp = (JSPUtil.getParameter(request, prefix	+ "lane_grp", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] editable = (JSPUtil.getParameter(request, prefix	+ "editable", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] voyage = (JSPUtil.getParameter(request, prefix	+ "voyage", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaAdjustmentTradeForExcelListVO();
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (opb[i] != null)
					model.setOpb(opb[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (mqtaStepCd[i] != null)
					model.setMqtaStepCd(mqtaStepCd[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mqtaVerNo[i] != null)
					model.setMqtaVerNo(mqtaVerNo[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (raOpfitUcAmt[i] != null)
					model.setRaOpfitUcAmt(raOpfitUcAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (laneGrp[i] != null)
					model.setLaneGrp(laneGrp[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (editable[i] != null)
					model.setEditable(editable[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (voyage[i] != null)
					model.setVoyage(voyage[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaAdjustmentTradeForExcelListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaAdjustmentTradeForExcelListVO[]
	 */
	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] getSearchMonthlyQuotaAdjustmentTradeForExcelListVOs(){
		SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] vos = (SearchMonthlyQuotaAdjustmentTradeForExcelListVO[])models.toArray(new SearchMonthlyQuotaAdjustmentTradeForExcelListVO[models.size()]);
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
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaStepCd = this.mqtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerNo = this.mqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raOpfitUcAmt = this.raOpfitUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrp = this.laneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editable = this.editable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyage = this.voyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
