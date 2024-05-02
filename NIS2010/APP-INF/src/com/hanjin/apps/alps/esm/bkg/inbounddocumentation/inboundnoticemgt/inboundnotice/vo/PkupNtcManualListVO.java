/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PkupNtcManualListVO.java
*@FileTitle : PkupNtcManualListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.05.11 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PkupNtcManualListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PkupNtcManualListVO> models = new ArrayList<PkupNtcManualListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String railDepDt = null;
	/* Column Info */
	private String oblCltFlg = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String railArrDt = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String ibdTrspHubCd = null;
	/* Column Info */
	private String pkupNtcSndKnt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String errFlag = null;
	/* Column Info */
	private String cstmsClrFlg = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PkupNtcManualListVO() {}

	public PkupNtcManualListVO(String ibflag, String pagerows, String errFlag, String blNo, String bkgNo, String cntrNo, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String frtCltFlg, String oblCltFlg, String cstmsClrFlg, String podCd, String delCd, String deTermCd, String eqCtrlOfcCd, String pkupNo, String pkupAvalDt, String lstFreeDt, String pkupYdCd, String rtnYdCd, String ibdTrspHubCd, String pkupNtcSndKnt, String railArrDt, String railDepDt) {
		this.vslCd = vslCd;
		this.railDepDt = railDepDt;
		this.oblCltFlg = oblCltFlg;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pkupYdCd = pkupYdCd;
		this.ibflag = ibflag;
		this.frtCltFlg = frtCltFlg;
		this.pkupAvalDt = pkupAvalDt;
		this.railArrDt = railArrDt;
		this.lstFreeDt = lstFreeDt;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.rtnYdCd = rtnYdCd;
		this.ibdTrspHubCd = ibdTrspHubCd;
		this.pkupNtcSndKnt = pkupNtcSndKnt;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.errFlag = errFlag;
		this.cstmsClrFlg = cstmsClrFlg;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rail_dep_dt", getRailDepDt());
		this.hashColumns.put("obl_clt_flg", getOblCltFlg());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("rail_arr_dt", getRailArrDt());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("ibd_trsp_hub_cd", getIbdTrspHubCd());
		this.hashColumns.put("pkup_ntc_snd_knt", getPkupNtcSndKnt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("err_flag", getErrFlag());
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rail_dep_dt", "railDepDt");
		this.hashFields.put("obl_clt_flg", "oblCltFlg");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("rail_arr_dt", "railArrDt");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("ibd_trsp_hub_cd", "ibdTrspHubCd");
		this.hashFields.put("pkup_ntc_snd_knt", "pkupNtcSndKnt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("err_flag", "errFlag");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
		this.hashFields.put("pkup_no", "pkupNo");
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
	 * @return railDepDt
	 */
	public String getRailDepDt() {
		return this.railDepDt;
	}
	
	/**
	 * Column Info
	 * @return oblCltFlg
	 */
	public String getOblCltFlg() {
		return this.oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @return railArrDt
	 */
	public String getRailArrDt() {
		return this.railArrDt;
	}
	
	/**
	 * Column Info
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspHubCd
	 */
	public String getIbdTrspHubCd() {
		return this.ibdTrspHubCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNtcSndKnt
	 */
	public String getPkupNtcSndKnt() {
		return this.pkupNtcSndKnt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return errFlag
	 */
	public String getErrFlag() {
		return this.errFlag;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrFlg
	 */
	public String getCstmsClrFlg() {
		return this.cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
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
	 * @param railDepDt
	 */
	public void setRailDepDt(String railDepDt) {
		this.railDepDt = railDepDt;
	}
	
	/**
	 * Column Info
	 * @param oblCltFlg
	 */
	public void setOblCltFlg(String oblCltFlg) {
		this.oblCltFlg = oblCltFlg;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @param railArrDt
	 */
	public void setRailArrDt(String railArrDt) {
		this.railArrDt = railArrDt;
	}
	
	/**
	 * Column Info
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspHubCd
	 */
	public void setIbdTrspHubCd(String ibdTrspHubCd) {
		this.ibdTrspHubCd = ibdTrspHubCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNtcSndKnt
	 */
	public void setPkupNtcSndKnt(String pkupNtcSndKnt) {
		this.pkupNtcSndKnt = pkupNtcSndKnt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param errFlag
	 */
	public void setErrFlag(String errFlag) {
		this.errFlag = errFlag;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrFlg
	 */
	public void setCstmsClrFlg(String cstmsClrFlg) {
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
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
		setRailDepDt(JSPUtil.getParameter(request, prefix + "rail_dep_dt", ""));
		setOblCltFlg(JSPUtil.getParameter(request, prefix + "obl_clt_flg", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, prefix + "pkup_aval_dt", ""));
		setRailArrDt(JSPUtil.getParameter(request, prefix + "rail_arr_dt", ""));
		setLstFreeDt(JSPUtil.getParameter(request, prefix + "lst_free_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setIbdTrspHubCd(JSPUtil.getParameter(request, prefix + "ibd_trsp_hub_cd", ""));
		setPkupNtcSndKnt(JSPUtil.getParameter(request, prefix + "pkup_ntc_snd_knt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setErrFlag(JSPUtil.getParameter(request, prefix + "err_flag", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request, prefix + "cstms_clr_flg", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PkupNtcManualListVO[]
	 */
	public PkupNtcManualListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PkupNtcManualListVO[]
	 */
	public PkupNtcManualListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PkupNtcManualListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] railDepDt = (JSPUtil.getParameter(request, prefix	+ "rail_dep_dt", length));
			String[] oblCltFlg = (JSPUtil.getParameter(request, prefix	+ "obl_clt_flg", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] railArrDt = (JSPUtil.getParameter(request, prefix	+ "rail_arr_dt", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix	+ "lst_free_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] ibdTrspHubCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_hub_cd", length));
			String[] pkupNtcSndKnt = (JSPUtil.getParameter(request, prefix	+ "pkup_ntc_snd_knt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] errFlag = (JSPUtil.getParameter(request, prefix	+ "err_flag", length));
			String[] cstmsClrFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_flg", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PkupNtcManualListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (railDepDt[i] != null)
					model.setRailDepDt(railDepDt[i]);
				if (oblCltFlg[i] != null)
					model.setOblCltFlg(oblCltFlg[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (railArrDt[i] != null)
					model.setRailArrDt(railArrDt[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (ibdTrspHubCd[i] != null)
					model.setIbdTrspHubCd(ibdTrspHubCd[i]);
				if (pkupNtcSndKnt[i] != null)
					model.setPkupNtcSndKnt(pkupNtcSndKnt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (errFlag[i] != null)
					model.setErrFlag(errFlag[i]);
				if (cstmsClrFlg[i] != null)
					model.setCstmsClrFlg(cstmsClrFlg[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPkupNtcManualListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PkupNtcManualListVO[]
	 */
	public PkupNtcManualListVO[] getPkupNtcManualListVOs(){
		PkupNtcManualListVO[] vos = (PkupNtcManualListVO[])models.toArray(new PkupNtcManualListVO[models.size()]);
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
		this.railDepDt = this.railDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblCltFlg = this.oblCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railArrDt = this.railArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspHubCd = this.ibdTrspHubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNtcSndKnt = this.pkupNtcSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlag = this.errFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg = this.cstmsClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
