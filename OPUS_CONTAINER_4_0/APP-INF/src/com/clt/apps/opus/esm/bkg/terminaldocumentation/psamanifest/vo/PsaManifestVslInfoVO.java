/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PsaManifestVslInfoVO.java
*@FileTitle : PsaManifestVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class PsaManifestVslInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaManifestVslInfoVO> models = new ArrayList<PsaManifestVslInfoVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslFullname = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsInd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String vslNationCd = null;
	/* Column Info */
	private String conVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PsaManifestVslInfoVO() {}

	public PsaManifestVslInfoVO(String ibflag, String pagerows, String status, String vvd, String conVvd, String vslFullname, String vslNationCd, String eta, String etd, String tsInd) {
		this.vvd = vvd;
		this.eta = eta;
		this.vslFullname = vslFullname;
		this.ibflag = ibflag;
		this.tsInd = tsInd;
		this.status = status;
		this.etd = etd;
		this.vslNationCd = vslNationCd;
		this.conVvd = conVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_ind", getTsInd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("vsl_nation_cd", getVslNationCd());
		this.hashColumns.put("con_vvd", getConVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_ind", "tsInd");
		this.hashFields.put("status", "status");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("vsl_nation_cd", "vslNationCd");
		this.hashFields.put("con_vvd", "conVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
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
	 * @return tsInd
	 */
	public String getTsInd() {
		return this.tsInd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return vslNationCd
	 */
	public String getVslNationCd() {
		return this.vslNationCd;
	}
	
	/**
	 * Column Info
	 * @return conVvd
	 */
	public String getConVvd() {
		return this.conVvd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
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
	 * @param tsInd
	 */
	public void setTsInd(String tsInd) {
		this.tsInd = tsInd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param vslNationCd
	 */
	public void setVslNationCd(String vslNationCd) {
		this.vslNationCd = vslNationCd;
	}
	
	/**
	 * Column Info
	 * @param conVvd
	 */
	public void setConVvd(String conVvd) {
		this.conVvd = conVvd;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsInd(JSPUtil.getParameter(request, prefix + "ts_ind", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setVslNationCd(JSPUtil.getParameter(request, prefix + "vsl_nation_cd", ""));
		setConVvd(JSPUtil.getParameter(request, prefix + "con_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaManifestVslInfoVO[]
	 */
	public PsaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaManifestVslInfoVO[]
	 */
	public PsaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaManifestVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsInd = (JSPUtil.getParameter(request, prefix	+ "ts_ind", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] vslNationCd = (JSPUtil.getParameter(request, prefix	+ "vsl_nation_cd", length));
			String[] conVvd = (JSPUtil.getParameter(request, prefix	+ "con_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaManifestVslInfoVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsInd[i] != null)
					model.setTsInd(tsInd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (vslNationCd[i] != null)
					model.setVslNationCd(vslNationCd[i]);
				if (conVvd[i] != null)
					model.setConVvd(conVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaManifestVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaManifestVslInfoVO[]
	 */
	public PsaManifestVslInfoVO[] getPsaManifestVslInfoVOs(){
		PsaManifestVslInfoVO[] vos = (PsaManifestVslInfoVO[])models.toArray(new PsaManifestVslInfoVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsInd = this.tsInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNationCd = this.vslNationCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conVvd = this.conVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
