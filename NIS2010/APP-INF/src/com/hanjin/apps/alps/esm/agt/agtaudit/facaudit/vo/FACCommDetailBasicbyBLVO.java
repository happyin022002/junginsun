/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FACCommDetailBasicbyBLVO.java
*@FileTitle : FACCommDetailBasicbyBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.09 이호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FACCommDetailBasicbyBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FACCommDetailBasicbyBLVO> models = new ArrayList<FACCommDetailBasicbyBLVO>();
	
	/* Column Info */
	private String frtFwrdCntSeq = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String frtFwrdNm = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String fmcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String commVsl = null;
	/* Column Info */
	private String shprCntSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FACCommDetailBasicbyBLVO() {}

	public FACCommDetailBasicbyBLVO(String ibflag, String pagerows, String vslDepDt, String bkgNo, String blNo, String shprCntSeq, String shprNm, String frtFwrdCntSeq, String frtFwrdNm, String commVsl, String bkgPorCd, String bkgPolCd, String bkgPodCd, String bkgDelCd, String fmcNo, String scNo, String rfaNo) {
		this.frtFwrdCntSeq = frtFwrdCntSeq;
		this.bkgPorCd = bkgPorCd;
		this.bkgPolCd = bkgPolCd;
		this.frtFwrdNm = frtFwrdNm;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.fmcNo = fmcNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.bkgPodCd = bkgPodCd;
		this.bkgDelCd = bkgDelCd;
		this.scNo = scNo;
		this.vslDepDt = vslDepDt;
		this.shprNm = shprNm;
		this.commVsl = commVsl;
		this.shprCntSeq = shprCntSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frt_fwrd_cnt_seq", getFrtFwrdCntSeq());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("frt_fwrd_nm", getFrtFwrdNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("comm_vsl", getCommVsl());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frt_fwrd_cnt_seq", "frtFwrdCntSeq");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("frt_fwrd_nm", "frtFwrdNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("comm_vsl", "commVsl");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntSeq
	 */
	public String getFrtFwrdCntSeq() {
		return this.frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdNm
	 */
	public String getFrtFwrdNm() {
		return this.frtFwrdNm;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return vslDepDt
	 */
	public String getVslDepDt() {
		return this.vslDepDt;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return commVsl
	 */
	public String getCommVsl() {
		return this.commVsl;
	}
	
	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
	}
	

	/**
	 * Column Info
	 * @param frtFwrdCntSeq
	 */
	public void setFrtFwrdCntSeq(String frtFwrdCntSeq) {
		this.frtFwrdCntSeq = frtFwrdCntSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdNm
	 */
	public void setFrtFwrdNm(String frtFwrdNm) {
		this.frtFwrdNm = frtFwrdNm;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param vslDepDt
	 */
	public void setVslDepDt(String vslDepDt) {
		this.vslDepDt = vslDepDt;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param commVsl
	 */
	public void setCommVsl(String commVsl) {
		this.commVsl = commVsl;
	}
	
	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrtFwrdCntSeq(JSPUtil.getParameter(request, "frt_fwrd_cnt_seq", ""));
		setBkgPorCd(JSPUtil.getParameter(request, "bkg_por_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setFrtFwrdNm(JSPUtil.getParameter(request, "frt_fwrd_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setFmcNo(JSPUtil.getParameter(request, "fmc_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request, "bkg_del_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setVslDepDt(JSPUtil.getParameter(request, "vsl_dep_dt", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setCommVsl(JSPUtil.getParameter(request, "comm_vsl", ""));
		setShprCntSeq(JSPUtil.getParameter(request, "shpr_cnt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACCommDetailBasicbyBLVO[]
	 */
	public FACCommDetailBasicbyBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FACCommDetailBasicbyBLVO[]
	 */
	public FACCommDetailBasicbyBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FACCommDetailBasicbyBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frtFwrdCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_seq", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] frtFwrdNm = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] commVsl = (JSPUtil.getParameter(request, prefix	+ "comm_vsl", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new FACCommDetailBasicbyBLVO();
				if (frtFwrdCntSeq[i] != null)
					model.setFrtFwrdCntSeq(frtFwrdCntSeq[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (frtFwrdNm[i] != null)
					model.setFrtFwrdNm(frtFwrdNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (commVsl[i] != null)
					model.setCommVsl(commVsl[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFACCommDetailBasicbyBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FACCommDetailBasicbyBLVO[]
	 */
	public FACCommDetailBasicbyBLVO[] getFACCommDetailBasicbyBLVOs(){
		FACCommDetailBasicbyBLVO[] vos = (FACCommDetailBasicbyBLVO[])models.toArray(new FACCommDetailBasicbyBLVO[models.size()]);
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
		this.frtFwrdCntSeq = this.frtFwrdCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdNm = this.frtFwrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVsl = this.commVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
