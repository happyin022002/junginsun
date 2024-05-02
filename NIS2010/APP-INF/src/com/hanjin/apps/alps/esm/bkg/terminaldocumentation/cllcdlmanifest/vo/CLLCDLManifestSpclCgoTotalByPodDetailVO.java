/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestSpclCgoTotalByPodDetailVO.java
*@FileTitle : CLLCDLManifestSpclCgoTotalByPodDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.11.26 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestSpclCgoTotalByPodDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CLLCDLManifestSpclCgoTotalByPodDetailVO> models = new ArrayList<CLLCDLManifestSpclCgoTotalByPodDetailVO>();
	
	/* Column Info */
	private String bb45 = null;
	/* Column Info */
	private String rf40 = null;
	/* Column Info */
	private String rf45 = null;
	/* Column Info */
	private String dg40 = null;
	/* Column Info */
	private String bb4 = null;
	/* Column Info */
	private String bb2 = null;
	/* Column Info */
	private String rf20 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ak40 = null;
	/* Column Info */
	private String ak45 = null;
	/* Column Info */
	private String ak20 = null;
	/* Column Info */
	private String dg45 = null;
	/* Column Info */
	private String dg20 = null;
	/* Column Info */
	private String bkgBs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CLLCDLManifestSpclCgoTotalByPodDetailVO() {}

	public CLLCDLManifestSpclCgoTotalByPodDetailVO(String ibflag, String pagerows, String podCd, String dg20, String dg40, String dg45, String rf20, String rf40, String rf45, String ak20, String ak40, String ak45, String bb2, String bb4, String bb45, String bkgBs) {
		this.bb45 = bb45;
		this.rf40 = rf40;
		this.rf45 = rf45;
		this.dg40 = dg40;
		this.bb4 = bb4;
		this.bb2 = bb2;
		this.rf20 = rf20;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.ak40 = ak40;
		this.ak45 = ak45;
		this.ak20 = ak20;
		this.dg45 = dg45;
		this.dg20 = dg20;
		this.bkgBs = bkgBs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bb45", getBb45());
		this.hashColumns.put("rf_40", getRf40());
		this.hashColumns.put("rf_45", getRf45());
		this.hashColumns.put("dg_40", getDg40());
		this.hashColumns.put("bb4", getBb4());
		this.hashColumns.put("bb2", getBb2());
		this.hashColumns.put("rf_20", getRf20());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ak_40", getAk40());
		this.hashColumns.put("ak_45", getAk45());
		this.hashColumns.put("ak_20", getAk20());
		this.hashColumns.put("dg_45", getDg45());
		this.hashColumns.put("dg_20", getDg20());
		this.hashColumns.put("bkg_bs", getBkgBs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bb45", "bb45");
		this.hashFields.put("rf_40", "rf40");
		this.hashFields.put("rf_45", "rf45");
		this.hashFields.put("dg_40", "dg40");
		this.hashFields.put("bb4", "bb4");
		this.hashFields.put("bb2", "bb2");
		this.hashFields.put("rf_20", "rf20");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ak_40", "ak40");
		this.hashFields.put("ak_45", "ak45");
		this.hashFields.put("ak_20", "ak20");
		this.hashFields.put("dg_45", "dg45");
		this.hashFields.put("dg_20", "dg20");
		this.hashFields.put("bkg_bs", "bkgBs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bb45
	 */
	public String getBb45() {
		return this.bb45;
	}
	
	/**
	 * Column Info
	 * @return rf40
	 */
	public String getRf40() {
		return this.rf40;
	}
	
	/**
	 * Column Info
	 * @return rf45
	 */
	public String getRf45() {
		return this.rf45;
	}
	
	/**
	 * Column Info
	 * @return dg40
	 */
	public String getDg40() {
		return this.dg40;
	}
	
	/**
	 * Column Info
	 * @return bb4
	 */
	public String getBb4() {
		return this.bb4;
	}
	
	/**
	 * Column Info
	 * @return bb2
	 */
	public String getBb2() {
		return this.bb2;
	}
	
	/**
	 * Column Info
	 * @return rf20
	 */
	public String getRf20() {
		return this.rf20;
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
	 * @return ak40
	 */
	public String getAk40() {
		return this.ak40;
	}
	
	/**
	 * Column Info
	 * @return ak45
	 */
	public String getAk45() {
		return this.ak45;
	}
	
	/**
	 * Column Info
	 * @return ak20
	 */
	public String getAk20() {
		return this.ak20;
	}
	
	/**
	 * Column Info
	 * @return dg45
	 */
	public String getDg45() {
		return this.dg45;
	}
	
	/**
	 * Column Info
	 * @return dg20
	 */
	public String getDg20() {
		return this.dg20;
	}
	
	/**
	 * Column Info
	 * @return bkgBs
	 */
	public String getBkgBs() {
		return this.bkgBs;
	}
	

	/**
	 * Column Info
	 * @param bb45
	 */
	public void setBb45(String bb45) {
		this.bb45 = bb45;
	}
	
	/**
	 * Column Info
	 * @param rf40
	 */
	public void setRf40(String rf40) {
		this.rf40 = rf40;
	}
	
	/**
	 * Column Info
	 * @param rf45
	 */
	public void setRf45(String rf45) {
		this.rf45 = rf45;
	}
	
	/**
	 * Column Info
	 * @param dg40
	 */
	public void setDg40(String dg40) {
		this.dg40 = dg40;
	}
	
	/**
	 * Column Info
	 * @param bb4
	 */
	public void setBb4(String bb4) {
		this.bb4 = bb4;
	}
	
	/**
	 * Column Info
	 * @param bb2
	 */
	public void setBb2(String bb2) {
		this.bb2 = bb2;
	}
	
	/**
	 * Column Info
	 * @param rf20
	 */
	public void setRf20(String rf20) {
		this.rf20 = rf20;
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
	 * @param ak40
	 */
	public void setAk40(String ak40) {
		this.ak40 = ak40;
	}
	
	/**
	 * Column Info
	 * @param ak45
	 */
	public void setAk45(String ak45) {
		this.ak45 = ak45;
	}
	
	/**
	 * Column Info
	 * @param ak20
	 */
	public void setAk20(String ak20) {
		this.ak20 = ak20;
	}
	
	/**
	 * Column Info
	 * @param dg45
	 */
	public void setDg45(String dg45) {
		this.dg45 = dg45;
	}
	
	/**
	 * Column Info
	 * @param dg20
	 */
	public void setDg20(String dg20) {
		this.dg20 = dg20;
	}
	
	/**
	 * Column Info
	 * @param bkgBs
	 */
	public void setBkgBs(String bkgBs) {
		this.bkgBs = bkgBs;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBb45(JSPUtil.getParameter(request, "bb45", ""));
		setRf40(JSPUtil.getParameter(request, "rf_40", ""));
		setRf45(JSPUtil.getParameter(request, "rf_45", ""));
		setDg40(JSPUtil.getParameter(request, "dg_40", ""));
		setBb4(JSPUtil.getParameter(request, "bb4", ""));
		setBb2(JSPUtil.getParameter(request, "bb2", ""));
		setRf20(JSPUtil.getParameter(request, "rf_20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAk40(JSPUtil.getParameter(request, "ak_40", ""));
		setAk45(JSPUtil.getParameter(request, "ak_45", ""));
		setAk20(JSPUtil.getParameter(request, "ak_20", ""));
		setDg45(JSPUtil.getParameter(request, "dg_45", ""));
		setDg20(JSPUtil.getParameter(request, "dg_20", ""));
		setBkgBs(JSPUtil.getParameter(request, "bkg_bs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestSpclCgoTotalByPodDetailVO[]
	 */
	public CLLCDLManifestSpclCgoTotalByPodDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestSpclCgoTotalByPodDetailVO[]
	 */
	public CLLCDLManifestSpclCgoTotalByPodDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestSpclCgoTotalByPodDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bb45 = (JSPUtil.getParameter(request, prefix	+ "bb45", length));
			String[] rf40 = (JSPUtil.getParameter(request, prefix	+ "rf_40", length));
			String[] rf45 = (JSPUtil.getParameter(request, prefix	+ "rf_45", length));
			String[] dg40 = (JSPUtil.getParameter(request, prefix	+ "dg_40", length));
			String[] bb4 = (JSPUtil.getParameter(request, prefix	+ "bb4", length));
			String[] bb2 = (JSPUtil.getParameter(request, prefix	+ "bb2", length));
			String[] rf20 = (JSPUtil.getParameter(request, prefix	+ "rf_20", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ak40 = (JSPUtil.getParameter(request, prefix	+ "ak_40", length));
			String[] ak45 = (JSPUtil.getParameter(request, prefix	+ "ak_45", length));
			String[] ak20 = (JSPUtil.getParameter(request, prefix	+ "ak_20", length));
			String[] dg45 = (JSPUtil.getParameter(request, prefix	+ "dg_45", length));
			String[] dg20 = (JSPUtil.getParameter(request, prefix	+ "dg_20", length));
			String[] bkgBs = (JSPUtil.getParameter(request, prefix	+ "bkg_bs", length));
			
			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestSpclCgoTotalByPodDetailVO();
				if (bb45[i] != null)
					model.setBb45(bb45[i]);
				if (rf40[i] != null)
					model.setRf40(rf40[i]);
				if (rf45[i] != null)
					model.setRf45(rf45[i]);
				if (dg40[i] != null)
					model.setDg40(dg40[i]);
				if (bb4[i] != null)
					model.setBb4(bb4[i]);
				if (bb2[i] != null)
					model.setBb2(bb2[i]);
				if (rf20[i] != null)
					model.setRf20(rf20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ak40[i] != null)
					model.setAk40(ak40[i]);
				if (ak45[i] != null)
					model.setAk45(ak45[i]);
				if (ak20[i] != null)
					model.setAk20(ak20[i]);
				if (dg45[i] != null)
					model.setDg45(dg45[i]);
				if (dg20[i] != null)
					model.setDg20(dg20[i]);
				if (bkgBs[i] != null)
					model.setBkgBs(bkgBs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestSpclCgoTotalByPodDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestSpclCgoTotalByPodDetailVO[]
	 */
	public CLLCDLManifestSpclCgoTotalByPodDetailVO[] getCLLCDLManifestSpclCgoTotalByPodDetailVOs(){
		CLLCDLManifestSpclCgoTotalByPodDetailVO[] vos = (CLLCDLManifestSpclCgoTotalByPodDetailVO[])models.toArray(new CLLCDLManifestSpclCgoTotalByPodDetailVO[models.size()]);
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
		this.bb45 = this.bb45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40 = this.rf40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45 = this.rf45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40 = this.dg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4 = this.bb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2 = this.bb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20 = this.rf20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40 = this.ak40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45 = this.ak45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20 = this.ak20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45 = this.dg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20 = this.dg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBs = this.bkgBs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
