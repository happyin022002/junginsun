/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThailandManifestListCondVO.java
*@FileTitle : ThailandManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ThailandManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<ThailandManifestListCondVO> models = new ArrayList<ThailandManifestListCondVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String sDelNodCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String subtotal = null;
	/* Column Info */
	private String sDelCd = null;
	/* Column Info */
	private String feeder = null;
	/* Column Info */
	private String trnkVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ThailandManifestListCondVO() {}

	public ThailandManifestListCondVO(String ibflag, String pagerows, String trnkVvd, String feeder, String polCd, String podCd, String etaDt, String subtotal, String sVvd, String sDelCd, String sDelNodCd, String sPolCd) {
		this.podCd = podCd;
		this.sDelNodCd = sDelNodCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.etaDt = etaDt;
		this.sPolCd = sPolCd;
		this.sVvd = sVvd;
		this.subtotal = subtotal;
		this.sDelCd = sDelCd;
		this.feeder = feeder;
		this.trnkVvd = trnkVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("s_del_nod_cd", getSDelNodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("subtotal", getSubtotal());
		this.hashColumns.put("s_del_cd", getSDelCd());
		this.hashColumns.put("feeder", getFeeder());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("s_del_nod_cd", "sDelNodCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("subtotal", "subtotal");
		this.hashFields.put("s_del_cd", "sDelCd");
		this.hashFields.put("feeder", "feeder");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return sDelNodCd
	 */
	public String getSDelNodCd() {
		return this.sDelNodCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return subtotal
	 */
	public String getSubtotal() {
		return this.subtotal;
	}
	
	/**
	 * Column Info
	 * @return sDelCd
	 */
	public String getSDelCd() {
		return this.sDelCd;
	}
	
	/**
	 * Column Info
	 * @return feeder
	 */
	public String getFeeder() {
		return this.feeder;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param sDelNodCd
	 */
	public void setSDelNodCd(String sDelNodCd) {
		this.sDelNodCd = sDelNodCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param subtotal
	 */
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
	/**
	 * Column Info
	 * @param sDelCd
	 */
	public void setSDelCd(String sDelCd) {
		this.sDelCd = sDelCd;
	}
	
	/**
	 * Column Info
	 * @param feeder
	 */
	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setSDelNodCd(JSPUtil.getParameter(request, prefix + "s_del_nod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSubtotal(JSPUtil.getParameter(request, prefix + "subtotal", ""));
		setSDelCd(JSPUtil.getParameter(request, prefix + "s_del_cd", ""));
		setFeeder(JSPUtil.getParameter(request, prefix + "feeder", ""));
		setTrnkVvd(JSPUtil.getParameter(request, prefix + "trnk_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ThailandVvdInfoVO[]
	 */
	public ThailandManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ThailandManifestListCondVO[]
	 */
	public ThailandManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ThailandManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] sDelNodCd = (JSPUtil.getParameter(request, prefix	+ "s_del_nod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] subtotal = (JSPUtil.getParameter(request, prefix	+ "subtotal", length));
			String[] sDelCd = (JSPUtil.getParameter(request, prefix	+ "s_del_cd", length));
			String[] feeder = (JSPUtil.getParameter(request, prefix	+ "feeder", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ThailandManifestListCondVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (sDelNodCd[i] != null)
					model.setSDelNodCd(sDelNodCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (subtotal[i] != null)
					model.setSubtotal(subtotal[i]);
				if (sDelCd[i] != null)
					model.setSDelCd(sDelCd[i]);
				if (feeder[i] != null)
					model.setFeeder(feeder[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getThailandManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ThailandManifestListCondVO[]
	 */
	public ThailandManifestListCondVO[] getThailandManifestListCondVOs(){
		ThailandManifestListCondVO[] vos = (ThailandManifestListCondVO[])models.toArray(new ThailandManifestListCondVO[models.size()]);
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
		this.sDelNodCd = this.sDelNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtotal = this.subtotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDelCd = this.sDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feeder = this.feeder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
