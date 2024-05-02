/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FdrBlInVO.java
*@FileTitle : FdrBlInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.07.15 조원주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo;

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
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FdrBlInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FdrBlInVO> models = new ArrayList<FdrBlInVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blObrdDtFrom = null;
	/* Column Info */
	private String oblIssDtFrom = null;
	/* Column Info */
	private String oblIssDtTo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String blObrdDtTo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FdrBlInVO() {}

	public FdrBlInVO(String ibflag, String pagerows, String tpCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String bkgNo, String blNo, String obSlsOfcCd, String obSrepCd, String blObrdDtFrom, String blObrdDtTo, String oblIssDtFrom, String oblIssDtTo) {
		this.vslCd = vslCd;
		this.blObrdDtFrom = blObrdDtFrom;
		this.oblIssDtFrom = oblIssDtFrom;
		this.oblIssDtTo = oblIssDtTo;
		this.skdVoyNo = skdVoyNo;
		this.blObrdDtTo = blObrdDtTo;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.obSrepCd = obSrepCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.tpCd = tpCd;
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("obl_iss_dt_from", getOblIssDtFrom());
		this.hashColumns.put("obl_iss_dt_to", getOblIssDtTo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("obl_iss_dt_from", "oblIssDtFrom");
		this.hashFields.put("obl_iss_dt_to", "oblIssDtTo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
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
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @return oblIssDtFrom
	 */
	public String getOblIssDtFrom() {
		return this.oblIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @return oblIssDtTo
	 */
	public String getOblIssDtTo() {
		return this.oblIssDtTo;
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
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
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
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @param oblIssDtFrom
	 */
	public void setOblIssDtFrom(String oblIssDtFrom) {
		this.oblIssDtFrom = oblIssDtFrom;
	}
	
	/**
	 * Column Info
	 * @param oblIssDtTo
	 */
	public void setOblIssDtTo(String oblIssDtTo) {
		this.oblIssDtTo = oblIssDtTo;
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
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
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
		setBlObrdDtFrom(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_from", ""));
		setOblIssDtFrom(JSPUtil.getParameter(request, prefix + "obl_iss_dt_from", ""));
		setOblIssDtTo(JSPUtil.getParameter(request, prefix + "obl_iss_dt_to", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_to", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FdrBlInVO[]
	 */
	public FdrBlInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FdrBlInVO[]
	 */
	public FdrBlInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FdrBlInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_from", length));
			String[] oblIssDtFrom = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_from", length));
			String[] oblIssDtTo = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_to", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_to", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FdrBlInVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (oblIssDtFrom[i] != null)
					model.setOblIssDtFrom(oblIssDtFrom[i]);
				if (oblIssDtTo[i] != null)
					model.setOblIssDtTo(oblIssDtTo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFdrBlInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FdrBlInVO[]
	 */
	public FdrBlInVO[] getFdrBlInVOs(){
		FdrBlInVO[] vos = (FdrBlInVO[])models.toArray(new FdrBlInVO[models.size()]);
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
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtFrom = this.oblIssDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtTo = this.oblIssDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
