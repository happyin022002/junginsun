/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgCodInfoVO.java
*@FileTitle : BkgCodInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2015.10.15 문경일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 문경일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCodInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCodInfoVO> models = new ArrayList<BkgCodInfoVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obCssmVoyNo = null;
	/* Column Info */
	private String oldPodFullNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String carrierCd = null;
	/* Column Info */
	private String oldPolFullNm = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String newPodFullNm = null;
	/* Column Info */
	private String emlDt = null;
	/* Column Info */
	private String picEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCodInfoVO() {}

	public BkgCodInfoVO(String ibflag, String pagerows, String newPodFullNm, String oldPodFullNm, String oldPolFullNm, String obCssmVoyNo, String vslEngNm, String carrierCd, String emlDt, String picEml) {
		this.pagerows = pagerows;
		this.obCssmVoyNo = obCssmVoyNo;
		this.oldPodFullNm = oldPodFullNm;
		this.ibflag = ibflag;
		this.carrierCd = carrierCd;
		this.oldPolFullNm = oldPolFullNm;
		this.vslEngNm = vslEngNm;
		this.newPodFullNm = newPodFullNm;
		this.emlDt = emlDt;
		this.picEml = picEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		this.hashColumns.put("old_pod_full_nm", getOldPodFullNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("old_pol_full_nm", getOldPolFullNm());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("new_pod_full_nm", getNewPodFullNm());
		this.hashColumns.put("eml_dt", getEmlDt());
		this.hashColumns.put("pic_eml", getPicEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		this.hashFields.put("old_pod_full_nm", "oldPodFullNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("old_pol_full_nm", "oldPolFullNm");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("new_pod_full_nm", "newPodFullNm");
		this.hashFields.put("eml_dt", "emlDt");
		this.hashFields.put("pic_eml", "picEml");
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
	 * @return obCssmVoyNo
	 */
	public String getObCssmVoyNo() {
		return this.obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return oldPodFullNm
	 */
	public String getOldPodFullNm() {
		return this.oldPodFullNm;
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
	 * @return carrierCd
	 */
	public String getCarrierCd() {
		return this.carrierCd;
	}
	
	/**
	 * Column Info
	 * @return oldPolFullNm
	 */
	public String getOldPolFullNm() {
		return this.oldPolFullNm;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return newPodFullNm
	 */
	public String getNewPodFullNm() {
		return this.newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return emlDt
	 */
	public String getEmlDt() {
		return this.emlDt;
	}
	
	/**
	 * Column Info
	 * @return picEml
	 */
	public String getPicEml() {
		return this.picEml;
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
	 * @param obCssmVoyNo
	 */
	public void setObCssmVoyNo(String obCssmVoyNo) {
		this.obCssmVoyNo = obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param oldPodFullNm
	 */
	public void setOldPodFullNm(String oldPodFullNm) {
		this.oldPodFullNm = oldPodFullNm;
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
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
	}
	
	/**
	 * Column Info
	 * @param oldPolFullNm
	 */
	public void setOldPolFullNm(String oldPolFullNm) {
		this.oldPolFullNm = oldPolFullNm;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param newPodFullNm
	 */
	public void setNewPodFullNm(String newPodFullNm) {
		this.newPodFullNm = newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param emlDt
	 */
	public void setEmlDt(String emlDt) {
		this.emlDt = emlDt;
	}
	
	/**
	 * Column Info
	 * @param picEml
	 */
	public void setPicEml(String picEml) {
		this.picEml = picEml;
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
		setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
		setOldPodFullNm(JSPUtil.getParameter(request, prefix + "old_pod_full_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setOldPolFullNm(JSPUtil.getParameter(request, prefix + "old_pol_full_nm", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setNewPodFullNm(JSPUtil.getParameter(request, prefix + "new_pod_full_nm", ""));
		setEmlDt(JSPUtil.getParameter(request, prefix + "eml_dt"));
		setPicEml(JSPUtil.getParameter(request, prefix + "pic_eml"));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCodInfoVO[]
	 */
	public BkgCodInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCodInfoVO[]
	 */
	public BkgCodInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCodInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_cssm_voy_no", length));
			String[] oldPodFullNm = (JSPUtil.getParameter(request, prefix	+ "old_pod_full_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] oldPolFullNm = (JSPUtil.getParameter(request, prefix	+ "old_pol_full_nm", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] newPodFullNm = (JSPUtil.getParameter(request, prefix	+ "new_pod_full_nm", length));
			String[] emlDt = (JSPUtil.getParameter(request, prefix + "eml_dt", length));
			String[] picEml = (JSPUtil.getParameter(request, prefix + "pic_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCodInfoVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obCssmVoyNo[i] != null)
					model.setObCssmVoyNo(obCssmVoyNo[i]);
				if (oldPodFullNm[i] != null)
					model.setOldPodFullNm(oldPodFullNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (oldPolFullNm[i] != null)
					model.setOldPolFullNm(oldPolFullNm[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (newPodFullNm[i] != null)
					model.setNewPodFullNm(newPodFullNm[i]);
				if (emlDt[i] != null)
					model.setEmlDt(emlDt[i]);
				if (picEml[i] != null)
					model.setPicEml(picEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCodInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCodInfoVO[]
	 */
	public BkgCodInfoVO[] getBkgCodInfoVOs(){
		BkgCodInfoVO[] vos = (BkgCodInfoVO[])models.toArray(new BkgCodInfoVO[models.size()]);
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
		this.obCssmVoyNo = this.obCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodFullNm = this.oldPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolFullNm = this.oldPolFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodFullNm = this.newPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDt = this.emlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picEml = this.picEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
