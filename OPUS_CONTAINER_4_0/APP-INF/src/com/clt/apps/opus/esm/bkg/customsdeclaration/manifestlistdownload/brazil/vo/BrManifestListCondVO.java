/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrManifestListCondVO.java
*@FileTitle : BrManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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

public class BrManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrManifestListCondVO> models = new ArrayList<BrManifestListCondVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String errorType = null;
	/* Column Info */
	private String ioType = null;
	/* Column Info */
	private String isHiddenRate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String brDuv = null;
	/* Column Info */
	private String brMid = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cnpjNo = null;
	/* Column Info */
	private String updUsrId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrManifestListCondVO() {}

	public BrManifestListCondVO(String ibflag, String pagerows, String podCd, String polCd, String delCd, String brzCmdtCd, String errorType, String vvdCd, String ioType, String isHiddenRate, String bkgCgoTpCd, String brDuv, String brMid, String blNo, String cnpjNo, String updUsrId) {
		this.podCd = podCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.polCd = polCd;
		this.delCd = delCd;
		this.ibflag = ibflag;
		this.brzCmdtCd = brzCmdtCd;
		this.vvdCd = vvdCd;
		this.errorType = errorType;
		this.ioType = ioType;
		this.isHiddenRate = isHiddenRate;
		this.pagerows = pagerows;
		this.brDuv = brDuv;
		this.brMid = brMid;
		this.blNo = blNo;
		this.cnpjNo = cnpjNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("error_type", getErrorType());
		this.hashColumns.put("io_type", getIoType());
		this.hashColumns.put("is_hidden_rate", getIsHiddenRate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("br_duv", getBrDuv());
		this.hashColumns.put("br_mid", getBrMid());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnpj_no", getCnpjNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("error_type", "errorType");
		this.hashFields.put("io_type", "ioType");
		this.hashFields.put("is_hidden_rate", "isHiddenRate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("br_duv", "brDuv");
		this.hashFields.put("br_mid", "brMid");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnpj_no", "cnpjNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return brzCmdtCd
	 */
	public String getBrzCmdtCd() {
		return this.brzCmdtCd;
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
	 * @return errorType
	 */
	public String getErrorType() {
		return this.errorType;
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
	 * @return isHiddenRate
	 */
	public String getIsHiddenRate() {
		return this.isHiddenRate;
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
	 * @return brDuv
	 */
	public String getBrDuv() {
		return this.brDuv;
	}
	
	/**
	 * Column Info
	 * @return brMid
	 */
	public String getBrMid() {
		return this.brMid;
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
	 * @return cnpjNo
	 */
	public String getCnpjNo() {
		return this.cnpjNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
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
	 * @param errorType
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	/**
	 * Column Info
	 * @param ioType
	 */
	public void setIoType(String ioType) {
		this.ioType = ioType;
	}
	
	/**
	 * Column Info
	 * @param isHiddenRate
	 */
	public void setIsHiddenRate(String isHiddenRate) {
		this.isHiddenRate = isHiddenRate;
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
	 * @param brDuv
	 */
	public void setBrDuv(String brDuv) {
		this.brDuv = brDuv;
	}
	
	/**
	 * Column Info
	 * @param brMid
	 */
	public void setBrMid(String brMid) {
		this.brMid = brMid;
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
	 * @param cnpjNo
	 */
	public void setCnpjNo(String cnpjNo) {
		this.cnpjNo = cnpjNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, prefix + "brz_cmdt_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setErrorType(JSPUtil.getParameter(request, prefix + "error_type", ""));
		setIoType(JSPUtil.getParameter(request, prefix + "io_type", ""));
		setIsHiddenRate(JSPUtil.getParameter(request, prefix + "is_hidden_rate", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBrDuv(JSPUtil.getParameter(request, prefix + "br_duv", ""));
		setBrMid(JSPUtil.getParameter(request, prefix + "br_mid", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCnpjNo(JSPUtil.getParameter(request, prefix + "cnpj_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrManifestListCondVO[]
	 */
	public BrManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrManifestListCondVO[]
	 */
	public BrManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] errorType = (JSPUtil.getParameter(request, prefix	+ "error_type", length));
			String[] ioType = (JSPUtil.getParameter(request, prefix	+ "io_type", length));
			String[] isHiddenRate = (JSPUtil.getParameter(request, prefix	+ "is_hidden_rate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] brDuv = (JSPUtil.getParameter(request, prefix	+ "br_duv", length));
			String[] brMid = (JSPUtil.getParameter(request, prefix	+ "br_mid", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cnpjNo = (JSPUtil.getParameter(request, prefix	+ "cnpj_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrManifestListCondVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delCd[i] != null)
					model.setPolCd(delCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (errorType[i] != null)
					model.setErrorType(errorType[i]);
				if (ioType[i] != null)
					model.setIoType(ioType[i]);
				if (isHiddenRate[i] != null)
					model.setIsHiddenRate(isHiddenRate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (brDuv[i] != null)
					model.setBrDuv(brDuv[i]);
				if (brMid[i] != null)
					model.setBrMid(brMid[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cnpjNo[i] != null)
					model.setCnpjNo(cnpjNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrManifestListCondVO[]
	 */
	public BrManifestListCondVO[] getBrManifestListCondVOs(){
		BrManifestListCondVO[] vos = (BrManifestListCondVO[])models.toArray(new BrManifestListCondVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorType = this.errorType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioType = this.ioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isHiddenRate = this.isHiddenRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brDuv = this.brDuv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brMid = this.brMid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnpjNo = this.cnpjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
