/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtc1VO.java
*@FileTitle : ArrNtc1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class ArrNtc1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtc1VO> models = new ArrayList<ArrNtc1VO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String anFomCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String chnAgnCd = null;
	/* Column Info */
	private String ntcRvisFlg = null;
	/* Column Info */
	private String podFirms = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String pkupFirms = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String pkupFreeDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String delArrDt = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String isValidated = null;
	/* Column Info */
	private String podArrDt = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtc1VO() {}

	public ArrNtc1VO(String ibflag, String pagerows, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd, String vslNm, String blNo, String deTermCd, String delCd, String hubLocCd, String podArrDt, String delArrDt, String pkupAvalDt, String pkupFreeDt, String podFirms, String pkupYdCd, String pkupFirms, String rtnYdCd, String anFomCd, String diffRmk, String chnAgnCd, String ntcRvisFlg, String isValidated, String vvd, String cntrType, String seq, String podCd) {
		this.vslCd = vslCd;
		this.anFomCd = anFomCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pkupYdCd = pkupYdCd;
		this.ibflag = ibflag;
		this.pkupAvalDt = pkupAvalDt;
		this.chnAgnCd = chnAgnCd;
		this.ntcRvisFlg = ntcRvisFlg;
		this.podFirms = podFirms;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.pkupFirms = pkupFirms;
		this.rtnYdCd = rtnYdCd;
		this.skdDirCd = skdDirCd;
		this.cntrType = cntrType;
		this.podCd = podCd;
		this.vvd = vvd;
		this.deTermCd = deTermCd;
		this.pkupFreeDt = pkupFreeDt;
		this.bkgNo = bkgNo;
		this.delArrDt = delArrDt;
		this.diffRmk = diffRmk;
		this.seq = seq;
		this.isValidated = isValidated;
		this.podArrDt = podArrDt;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("an_fom_cd", getAnFomCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("chn_agn_cd", getChnAgnCd());
		this.hashColumns.put("ntc_rvis_flg", getNtcRvisFlg());
		this.hashColumns.put("pod_firms", getPodFirms());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("pkup_firms", getPkupFirms());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pkup_free_dt", getPkupFreeDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("del_arr_dt", getDelArrDt());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("is_validated", getIsValidated());
		this.hashColumns.put("pod_arr_dt", getPodArrDt());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("an_fom_cd", "anFomCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("chn_agn_cd", "chnAgnCd");
		this.hashFields.put("ntc_rvis_flg", "ntcRvisFlg");
		this.hashFields.put("pod_firms", "podFirms");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("pkup_firms", "pkupFirms");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pkup_free_dt", "pkupFreeDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("del_arr_dt", "delArrDt");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("pod_arr_dt", "podArrDt");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
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
	 * @return anFomCd
	 */
	public String getAnFomCd() {
		return this.anFomCd;
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
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @return chnAgnCd
	 */
	public String getChnAgnCd() {
		return this.chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @return ntcRvisFlg
	 */
	public String getNtcRvisFlg() {
		return this.ntcRvisFlg;
	}
	
	/**
	 * Column Info
	 * @return podFirms
	 */
	public String getPodFirms() {
		return this.podFirms;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return pkupFirms
	 */
	public String getPkupFirms() {
		return this.pkupFirms;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return pkupFreeDt
	 */
	public String getPkupFreeDt() {
		return this.pkupFreeDt;
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
	 * @return delArrDt
	 */
	public String getDelArrDt() {
		return this.delArrDt;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return isValidated
	 */
	public String getIsValidated() {
		return this.isValidated;
	}
	
	/**
	 * Column Info
	 * @return podArrDt
	 */
	public String getPodArrDt() {
		return this.podArrDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param anFomCd
	 */
	public void setAnFomCd(String anFomCd) {
		this.anFomCd = anFomCd;
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
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @param chnAgnCd
	 */
	public void setChnAgnCd(String chnAgnCd) {
		this.chnAgnCd = chnAgnCd;
	}
	
	/**
	 * Column Info
	 * @param ntcRvisFlg
	 */
	public void setNtcRvisFlg(String ntcRvisFlg) {
		this.ntcRvisFlg = ntcRvisFlg;
	}
	
	/**
	 * Column Info
	 * @param podFirms
	 */
	public void setPodFirms(String podFirms) {
		this.podFirms = podFirms;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param pkupFirms
	 */
	public void setPkupFirms(String pkupFirms) {
		this.pkupFirms = pkupFirms;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param pkupFreeDt
	 */
	public void setPkupFreeDt(String pkupFreeDt) {
		this.pkupFreeDt = pkupFreeDt;
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
	 * @param delArrDt
	 */
	public void setDelArrDt(String delArrDt) {
		this.delArrDt = delArrDt;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param isValidated
	 */
	public void setIsValidated(String isValidated) {
		this.isValidated = isValidated;
	}
	
	/**
	 * Column Info
	 * @param podArrDt
	 */
	public void setPodArrDt(String podArrDt) {
		this.podArrDt = podArrDt;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAnFomCd(JSPUtil.getParameter(request, "an_fom_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPkupYdCd(JSPUtil.getParameter(request, "pkup_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, "pkup_aval_dt", ""));
		setChnAgnCd(JSPUtil.getParameter(request, "chn_agn_cd", ""));
		setNtcRvisFlg(JSPUtil.getParameter(request, "ntc_rvis_flg", ""));
		setPodFirms(JSPUtil.getParameter(request, "pod_firms", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setPkupFirms(JSPUtil.getParameter(request, "pkup_firms", ""));
		setRtnYdCd(JSPUtil.getParameter(request, "rtn_yd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setPkupFreeDt(JSPUtil.getParameter(request, "pkup_free_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDelArrDt(JSPUtil.getParameter(request, "del_arr_dt", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setIsValidated(JSPUtil.getParameter(request, "is_validated", ""));
		setPodArrDt(JSPUtil.getParameter(request, "pod_arr_dt", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtc1VO[]
	 */
	public ArrNtc1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtc1VO[]
	 */
	public ArrNtc1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtc1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] anFomCd = (JSPUtil.getParameter(request, prefix	+ "an_fom_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] chnAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_agn_cd", length));
			String[] ntcRvisFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_rvis_flg", length));
			String[] podFirms = (JSPUtil.getParameter(request, prefix	+ "pod_firms", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] pkupFirms = (JSPUtil.getParameter(request, prefix	+ "pkup_firms", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] pkupFreeDt = (JSPUtil.getParameter(request, prefix	+ "pkup_free_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] delArrDt = (JSPUtil.getParameter(request, prefix	+ "del_arr_dt", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] isValidated = (JSPUtil.getParameter(request, prefix	+ "is_validated", length));
			String[] podArrDt = (JSPUtil.getParameter(request, prefix	+ "pod_arr_dt", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtc1VO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (anFomCd[i] != null)
					model.setAnFomCd(anFomCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (chnAgnCd[i] != null)
					model.setChnAgnCd(chnAgnCd[i]);
				if (ntcRvisFlg[i] != null)
					model.setNtcRvisFlg(ntcRvisFlg[i]);
				if (podFirms[i] != null)
					model.setPodFirms(podFirms[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (pkupFirms[i] != null)
					model.setPkupFirms(pkupFirms[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (pkupFreeDt[i] != null)
					model.setPkupFreeDt(pkupFreeDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (delArrDt[i] != null)
					model.setDelArrDt(delArrDt[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (isValidated[i] != null)
					model.setIsValidated(isValidated[i]);
				if (podArrDt[i] != null)
					model.setPodArrDt(podArrDt[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtc1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtc1VO[]
	 */
	public ArrNtc1VO[] getArrNtc1VOs(){
		ArrNtc1VO[] vos = (ArrNtc1VO[])models.toArray(new ArrNtc1VO[models.size()]);
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
		this.anFomCd = this.anFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnAgnCd = this.chnAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcRvisFlg = this.ntcRvisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFirms = this.podFirms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupFirms = this.pkupFirms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupFreeDt = this.pkupFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delArrDt = this.delArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated = this.isValidated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podArrDt = this.podArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
