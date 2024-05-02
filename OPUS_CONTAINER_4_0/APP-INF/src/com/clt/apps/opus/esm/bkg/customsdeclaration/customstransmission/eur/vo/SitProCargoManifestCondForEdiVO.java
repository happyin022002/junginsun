/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SitProCargoManifestCondForEdiVO.java
*@FileTitle : SitProCargoManifestCondForEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.19 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProCargoManifestCondForEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProCargoManifestCondForEdiVO> models = new ArrayList<SitProCargoManifestCondForEdiVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pOption = null;
	/* Column Info */
	private String pPolYardCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String tsSearchFlag = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String pSearchPofeYardCd = null;
	/* Column Info */
	private String pPolCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProCargoManifestCondForEdiVO() {}

	public SitProCargoManifestCondForEdiVO(String ibflag, String pagerows, String vvdCd, String polCd, String podCd, String porCd, String delCd, String bkgNo, String blNo, String bkgOfcCd, String bkgStsCd, String tsSearchFlag, String bkgCgoTpCd, String pPolCd, String pPolYardCd, String pSearchPofeYardCd, String pOption, String polYdCd, String podYdCd) {
		this.porCd = porCd;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.pOption = pOption;
		this.pPolYardCd = pPolYardCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.vvdCd = vvdCd;
		this.polYdCd = polYdCd;
		this.tsSearchFlag = tsSearchFlag;
		this.podYdCd = podYdCd;
		this.pSearchPofeYardCd = pSearchPofeYardCd;
		this.pPolCd = pPolCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("p_option", getPOption());
		this.hashColumns.put("p_pol_yard_cd", getPPolYardCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ts_search_flag", getTsSearchFlag());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("p_search_pofe_yard_cd", getPSearchPofeYardCd());
		this.hashColumns.put("p_pol_cd", getPPolCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("p_option", "pOption");
		this.hashFields.put("p_pol_yard_cd", "pPolYardCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("ts_search_flag", "tsSearchFlag");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("p_search_pofe_yard_cd", "pSearchPofeYardCd");
		this.hashFields.put("p_pol_cd", "pPolCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return pOption
	 */
	public String getPOption() {
		return this.pOption;
	}
	
	/**
	 * Column Info
	 * @return pPolYardCd
	 */
	public String getPPolYardCd() {
		return this.pPolYardCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return tsSearchFlag
	 */
	public String getTsSearchFlag() {
		return this.tsSearchFlag;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return pSearchPofeYardCd
	 */
	public String getPSearchPofeYardCd() {
		return this.pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @return pPolCd
	 */
	public String getPPolCd() {
		return this.pPolCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param pOption
	 */
	public void setPOption(String pOption) {
		this.pOption = pOption;
	}
	
	/**
	 * Column Info
	 * @param pPolYardCd
	 */
	public void setPPolYardCd(String pPolYardCd) {
		this.pPolYardCd = pPolYardCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param tsSearchFlag
	 */
	public void setTsSearchFlag(String tsSearchFlag) {
		this.tsSearchFlag = tsSearchFlag;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param pSearchPofeYardCd
	 */
	public void setPSearchPofeYardCd(String pSearchPofeYardCd) {
		this.pSearchPofeYardCd = pSearchPofeYardCd;
	}
	
	/**
	 * Column Info
	 * @param pPolCd
	 */
	public void setPPolCd(String pPolCd) {
		this.pPolCd = pPolCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPOption(JSPUtil.getParameter(request, prefix + "p_option", ""));
		setPPolYardCd(JSPUtil.getParameter(request, prefix + "p_pol_yard_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setTsSearchFlag(JSPUtil.getParameter(request, prefix + "ts_search_flag", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setPSearchPofeYardCd(JSPUtil.getParameter(request, prefix + "p_search_pofe_yard_cd", ""));
		setPPolCd(JSPUtil.getParameter(request, prefix + "p_pol_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProCargoManifestCondForEdiVO[]
	 */
	public SitProCargoManifestCondForEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProCargoManifestCondForEdiVO[]
	 */
	public SitProCargoManifestCondForEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProCargoManifestCondForEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pOption = (JSPUtil.getParameter(request, prefix	+ "p_option", length));
			String[] pPolYardCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_yard_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] tsSearchFlag = (JSPUtil.getParameter(request, prefix	+ "ts_search_flag", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] pSearchPofeYardCd = (JSPUtil.getParameter(request, prefix	+ "p_search_pofe_yard_cd", length));
			String[] pPolCd = (JSPUtil.getParameter(request, prefix	+ "p_pol_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProCargoManifestCondForEdiVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pOption[i] != null)
					model.setPOption(pOption[i]);
				if (pPolYardCd[i] != null)
					model.setPPolYardCd(pPolYardCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (tsSearchFlag[i] != null)
					model.setTsSearchFlag(tsSearchFlag[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (pSearchPofeYardCd[i] != null)
					model.setPSearchPofeYardCd(pSearchPofeYardCd[i]);
				if (pPolCd[i] != null)
					model.setPPolCd(pPolCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProCargoManifestCondForEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProCargoManifestCondForEdiVO[]
	 */
	public SitProCargoManifestCondForEdiVO[] getSitProCargoManifestCondForEdiVOs(){
		SitProCargoManifestCondForEdiVO[] vos = (SitProCargoManifestCondForEdiVO[])models.toArray(new SitProCargoManifestCondForEdiVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOption = this.pOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolYardCd = this.pPolYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSearchFlag = this.tsSearchFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSearchPofeYardCd = this.pSearchPofeYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPolCd = this.pPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
