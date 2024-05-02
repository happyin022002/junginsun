/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchAllBKGVO.java
*@FileTitle : SearchAllBKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchAllBKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAllBKGVO> models = new ArrayList<SearchAllBKGVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String etdEta = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String pDate2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAllBKGVO() {}

	public SearchAllBKGVO(String ibflag, String pagerows, String bkgCgoTpCd, String bkgNo, String blNo, String repoPlnId, String vvd, String polCd, String etdDt, String podCd, String etaDt, String pDate1, String pDate2, String etdEta, String fmEccCd, String toEccCd, String fmLocCd, String toLocCd, String cgoTpCd) {
		this.pagerows = pagerows;
		this.etdDt = etdDt;
		this.ibflag = ibflag;
		this.fmLocCd = fmLocCd;
		this.blNo = blNo;
		this.vvd = vvd;
		this.etaDt = etaDt;
		this.bkgNo = bkgNo;
		this.fmEccCd = fmEccCd;
		this.polCd = polCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.repoPlnId = repoPlnId;
		this.etdEta = etdEta;
		this.podCd = podCd;
		this.cgoTpCd = cgoTpCd;
		this.pDate1 = pDate1;
		this.toLocCd = toLocCd;
		this.toEccCd = toEccCd;
		this.pDate2 = pDate2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("etd_eta", getEtdEta());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("p_date2", getPDate2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("etd_eta", "etdEta");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("p_date2", "pDate2");
		return this.hashFields;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return etdEta
	 */
	public String getEtdEta() {
		return this.etdEta;
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
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param etdEta
	 */
	public void setEtdEta(String etdEta) {
		this.etdEta = etdEta;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFmEccCd(JSPUtil.getParameter(request, prefix + "fm_ecc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, prefix + "repo_pln_id", ""));
		setEtdEta(JSPUtil.getParameter(request, prefix + "etd_eta", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setToEccCd(JSPUtil.getParameter(request, prefix + "to_ecc_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAllBKGVO[]
	 */
	public SearchAllBKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAllBKGVO[]
	 */
	public SearchAllBKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAllBKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] etdEta = (JSPUtil.getParameter(request, prefix	+ "etd_eta", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAllBKGVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (etdEta[i] != null)
					model.setEtdEta(etdEta[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAllBKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAllBKGVO[]
	 */
	public SearchAllBKGVO[] getSearchAllBKGVOs(){
		SearchAllBKGVO[] vos = (SearchAllBKGVO[])models.toArray(new SearchAllBKGVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEta = this.etdEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
