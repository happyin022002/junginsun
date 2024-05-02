/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODCollectionParmVO.java
*@FileTitle : DODCollectionParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DODCollectionParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DODCollectionParmVO> models = new ArrayList<DODCollectionParmVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fmArIfDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String doLoc = null;
	/* Column Info */
	private String toArIfDt = null;
	/* Column Info */
	private String delCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String creOfcCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DODCollectionParmVO() {}

	public DODCollectionParmVO(String ibflag, String pagerows, String fmArIfDt, String toArIfDt, String doLoc, String porCd, String polCd, String podCd, String delCd, String contiCd, String creOfcCd) {
		this.podCd = podCd;
		this.porCd = porCd;
		this.fmArIfDt = fmArIfDt;
		this.polCd = polCd;
		this.ibflag = ibflag; 
		this.doLoc = doLoc;
		this.toArIfDt = toArIfDt;
		this.delCd = delCd;
		this.pagerows = pagerows;
		this.contiCd = contiCd;
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fm_ar_if_dt", getFmArIfDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("do_loc", getDoLoc());
		this.hashColumns.put("to_ar_if_dt", getToArIfDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fm_ar_if_dt", "fmArIfDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("do_loc", "doLoc");
		this.hashFields.put("to_ar_if_dt", "toArIfDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return fmArIfDt
	 */
	public String getFmArIfDt() {
		return this.fmArIfDt;
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
	 * @return doLoc
	 */
	public String getDoLoc() {
		return this.doLoc;
	}
	
	/**
	 * Column Info
	 * @return toArIfDt
	 */
	public String getToArIfDt() {
		return this.toArIfDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getContiCd() {
		return contiCd;
	}
	
	/**
	 * Page Number
	 * @return creofccd
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}	

	/**
	 * Page Number
	 * @return pagerows
	 */	
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param fmArIfDt
	 */
	public void setFmArIfDt(String fmArIfDt) {
		this.fmArIfDt = fmArIfDt;
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
	 * @param doLoc
	 */
	public void setDoLoc(String doLoc) {
		this.doLoc = doLoc;
	}
	
	/**
	 * Column Info
	 * @param toArIfDt
	 */
	public void setToArIfDt(String toArIfDt) {
		this.toArIfDt = toArIfDt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFmArIfDt(JSPUtil.getParameter(request, prefix + "fm_ar_if_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDoLoc(JSPUtil.getParameter(request, prefix + "do_loc", ""));
		setToArIfDt(JSPUtil.getParameter(request, prefix + "to_ar_if_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DODCollectionParmVO[]
	 */
	public DODCollectionParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DODCollectionParmVO[]
	 */
	public DODCollectionParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DODCollectionParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fmArIfDt = (JSPUtil.getParameter(request, prefix	+ "fm_ar_if_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] doLoc = (JSPUtil.getParameter(request, prefix	+ "do_loc", length));
			String[] toArIfDt = (JSPUtil.getParameter(request, prefix	+ "to_ar_if_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DODCollectionParmVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fmArIfDt[i] != null)
					model.setFmArIfDt(fmArIfDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (doLoc[i] != null)
					model.setDoLoc(doLoc[i]);
				if (toArIfDt[i] != null)
					model.setToArIfDt(toArIfDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDODCollectionParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DODCollectionParmVO[]
	 */
	public DODCollectionParmVO[] getDODCollectionParmVOs(){
		DODCollectionParmVO[] vos = (DODCollectionParmVO[])models.toArray(new DODCollectionParmVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmArIfDt = this.fmArIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doLoc = this.doLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toArIfDt = this.toArIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}