/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrManifestTransmitVO.java
*@FileTitle : BrManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
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

public class BrManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrManifestTransmitVO> models = new ArrayList<BrManifestTransmitVO>();
	
	/* Column Info */
	private String compId = null;
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
	private String hideCheck = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String hiddenRateType = null;
	/* Column Info */
	private String searchBkgCgoTpCd = null;
	/* Column Info */
	private String ediSendId = null;
	/* Column Info */
	private String ioType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrManifestTransmitVO() {}

	public BrManifestTransmitVO(String ibflag, String pagerows, String podCd, String compId, String polCd, String bkgNo, String vvdCd, String cntrNo, String hiddenRateType, String hideCheck, String blNo, String ediSendId, String searchBkgCgoTpCd, String ioType) {
		this.compId = compId;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.hideCheck = hideCheck;
		this.vvdCd = vvdCd;
		this.cntrNo = cntrNo;
		this.hiddenRateType = hiddenRateType;
		this.searchBkgCgoTpCd = searchBkgCgoTpCd;
		this.ediSendId = ediSendId;
		this.ioType = ioType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comp_id", getCompId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hide_check", getHideCheck());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("hidden_rate_type", getHiddenRateType());
		this.hashColumns.put("search_bkg_cgo_tp_cd", getSearchBkgCgoTpCd());
		this.hashColumns.put("edi_send_id", getEdiSendId());
		this.hashColumns.put("io_type", getIoType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comp_id", "compId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hide_check", "hideCheck");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("hidden_rate_type", "hiddenRateType");
		this.hashFields.put("search_bkg_cgo_tp_cd", "searchBkgCgoTpCd");
		this.hashFields.put("edi_send_id", "ediSendId");
		this.hashFields.put("io_type", "ioType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return compId
	 */
	public String getCompId() {
		return this.compId;
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
	 * @return hideCheck
	 */
	public String getHideCheck() {
		return this.hideCheck;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return hiddenRateType
	 */
	public String getHiddenRateType() {
		return this.hiddenRateType;
	}
	
	/**
	 * Column Info
	 * @return searchBkgCgoTpCd
	 */
	public String getSearchBkgCgoTpCd() {
		return this.searchBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediSendId
	 */
	public String getEdiSendId() {
		return this.ediSendId;
	}
	
	/**
	 * Column Info
	 * @return ioType
	 */
	public String getIoType() {
		return this.ioType;
	}

	/**
	 * Column Info
	 * @param compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
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
	 * @param hideCheck
	 */
	public void setHideCheck(String hideCheck) {
		this.hideCheck = hideCheck;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param hiddenRateType
	 */
	public void setHiddenRateType(String hiddenRateType) {
		this.hiddenRateType = hiddenRateType;
	}
	
	/**
	 * Column Info
	 * @param searchBkgCgoTpCd
	 */
	public void setSearchBkgCgoTpCd(String searchBkgCgoTpCd) {
		this.searchBkgCgoTpCd = searchBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediSendId
	 */
	public void setEdiSendId(String ediSendId) {
		this.ediSendId = ediSendId;
	}
	
	/**
	 * Column Info
	 * @param ioType
	 */
	public void setIoType(String ioType) {
		this.ioType = ioType;
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
		setCompId(JSPUtil.getParameter(request, prefix + "comp_id", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHideCheck(JSPUtil.getParameter(request, prefix + "hide_check", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setHiddenRateType(JSPUtil.getParameter(request, prefix + "hidden_rate_type", ""));
		setSearchBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "search_bkg_cgo_tp_cd", ""));
		setEdiSendId(JSPUtil.getParameter(request, prefix + "edi_send_id", ""));
		setIoType(JSPUtil.getParameter(request, prefix + "io_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrManifestTransmitVO[]
	 */
	public BrManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrManifestTransmitVO[]
	 */
	public BrManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hideCheck = (JSPUtil.getParameter(request, prefix	+ "hide_check", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] hiddenRateType = (JSPUtil.getParameter(request, prefix	+ "hidden_rate_type", length));
			String[] searchBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "search_bkg_cgo_tp_cd", length));
			String[] ediSendId = (JSPUtil.getParameter(request, prefix	+ "edi_send_id", length));
			String[] ioType = (JSPUtil.getParameter(request, prefix	+ "io_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrManifestTransmitVO();
				if (compId[i] != null)
					model.setCompId(compId[i]);
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
				if (hideCheck[i] != null)
					model.setHideCheck(hideCheck[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (hiddenRateType[i] != null)
					model.setHiddenRateType(hiddenRateType[i]);
				if (searchBkgCgoTpCd[i] != null)
					model.setSearchBkgCgoTpCd(searchBkgCgoTpCd[i]);
				if (ediSendId[i] != null)
					model.setEdiSendId(ediSendId[i]);
				if (ioType[i] != null)
					model.setIoType(ioType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrManifestTransmitVO[]
	 */
	public BrManifestTransmitVO[] getBrManifestTransmitVOs(){
		BrManifestTransmitVO[] vos = (BrManifestTransmitVO[])models.toArray(new BrManifestTransmitVO[models.size()]);
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
		this.compId = this.compId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hideCheck = this.hideCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenRateType = this.hiddenRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchBkgCgoTpCd = this.searchBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSendId = this.ediSendId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioType = this.ioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
