/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LoadFactorListVO.java
*@FileTitle : LoadFactorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.06  
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo;

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

public class LoadFactorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LoadFactorListVO> models = new ArrayList<LoadFactorListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String avgLoadFactRatio = null;
	/* Column Info */
	private String avgBsaCapaQty = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String avgLastPortDrftQty = null;
	/* Column Info */
	private String avgTtlLoadTeuQty = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vslSlanDirSeq = null;
	/* Column Info */
	private String avgLastPortBlstQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LoadFactorListVO() {}

	public LoadFactorListVO(String ibflag, String pagerows, String vslSlanCd, String pfSkdTpCd, String vslSlanDirCd, String vslSlanDirSeq, String vslCd, String avgBsaCapaQty, String avgTtlLoadTeuQty, String avgLoadFactRatio, String avgLastPortBlstQty, String avgLastPortDrftQty) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.avgLoadFactRatio = avgLoadFactRatio;
		this.avgBsaCapaQty = avgBsaCapaQty;
		this.pfSkdTpCd = pfSkdTpCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.avgLastPortDrftQty = avgLastPortDrftQty;
		this.avgTtlLoadTeuQty = avgTtlLoadTeuQty;
		this.vslSlanCd = vslSlanCd;
		this.vslSlanDirSeq = vslSlanDirSeq;
		this.avgLastPortBlstQty = avgLastPortBlstQty;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("avg_load_fact_ratio", getAvgLoadFactRatio());
		this.hashColumns.put("avg_bsa_capa_qty", getAvgBsaCapaQty());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("avg_last_port_drft_qty", getAvgLastPortDrftQty());
		this.hashColumns.put("avg_ttl_load_teu_qty", getAvgTtlLoadTeuQty());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_slan_dir_seq", getVslSlanDirSeq());
		this.hashColumns.put("avg_last_port_blst_qty", getAvgLastPortBlstQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("avg_load_fact_ratio", "avgLoadFactRatio");
		this.hashFields.put("avg_bsa_capa_qty", "avgBsaCapaQty");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("avg_last_port_drft_qty", "avgLastPortDrftQty");
		this.hashFields.put("avg_ttl_load_teu_qty", "avgTtlLoadTeuQty");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_slan_dir_seq", "vslSlanDirSeq");
		this.hashFields.put("avg_last_port_blst_qty", "avgLastPortBlstQty");
		this.hashFields.put("pagerows", "pagerows");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return avgLoadFactRatio
	 */
	public String getAvgLoadFactRatio() {
		return this.avgLoadFactRatio;
	}
	
	/**
	 * Column Info
	 * @return avgBsaCapaQty
	 */
	public String getAvgBsaCapaQty() {
		return this.avgBsaCapaQty;
	}
	
	/**
	 * Column Info
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @return avgLastPortDrftQty
	 */
	public String getAvgLastPortDrftQty() {
		return this.avgLastPortDrftQty;
	}
	
	/**
	 * Column Info
	 * @return avgTtlLoadTeuQty
	 */
	public String getAvgTtlLoadTeuQty() {
		return this.avgTtlLoadTeuQty;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanDirSeq
	 */
	public String getVslSlanDirSeq() {
		return this.vslSlanDirSeq;
	}
	
	/**
	 * Column Info
	 * @return avgLastPortBlstQty
	 */
	public String getAvgLastPortBlstQty() {
		return this.avgLastPortBlstQty;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param avgLoadFactRatio
	 */
	public void setAvgLoadFactRatio(String avgLoadFactRatio) {
		this.avgLoadFactRatio = avgLoadFactRatio;
	}
	
	/**
	 * Column Info
	 * @param avgBsaCapaQty
	 */
	public void setAvgBsaCapaQty(String avgBsaCapaQty) {
		this.avgBsaCapaQty = avgBsaCapaQty;
	}
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
	}
	
	/**
	 * Column Info
	 * @param avgLastPortDrftQty
	 */
	public void setAvgLastPortDrftQty(String avgLastPortDrftQty) {
		this.avgLastPortDrftQty = avgLastPortDrftQty;
	}
	
	/**
	 * Column Info
	 * @param avgTtlLoadTeuQty
	 */
	public void setAvgTtlLoadTeuQty(String avgTtlLoadTeuQty) {
		this.avgTtlLoadTeuQty = avgTtlLoadTeuQty;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanDirSeq
	 */
	public void setVslSlanDirSeq(String vslSlanDirSeq) {
		this.vslSlanDirSeq = vslSlanDirSeq;
	}
	
	/**
	 * Column Info
	 * @param avgLastPortBlstQty
	 */
	public void setAvgLastPortBlstQty(String avgLastPortBlstQty) {
		this.avgLastPortBlstQty = avgLastPortBlstQty;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAvgLoadFactRatio(JSPUtil.getParameter(request, prefix + "avg_load_fact_ratio", ""));
		setAvgBsaCapaQty(JSPUtil.getParameter(request, prefix + "avg_bsa_capa_qty", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_cd", ""));
		setAvgLastPortDrftQty(JSPUtil.getParameter(request, prefix + "avg_last_port_drft_qty", ""));
		setAvgTtlLoadTeuQty(JSPUtil.getParameter(request, prefix + "avg_ttl_load_teu_qty", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVslSlanDirSeq(JSPUtil.getParameter(request, prefix + "vsl_slan_dir_seq", ""));
		setAvgLastPortBlstQty(JSPUtil.getParameter(request, prefix + "avg_last_port_blst_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LoadFactorListVO[]
	 */
	public LoadFactorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LoadFactorListVO[]
	 */
	public LoadFactorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LoadFactorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] avgLoadFactRatio = (JSPUtil.getParameter(request, prefix	+ "avg_load_fact_ratio", length));
			String[] avgBsaCapaQty = (JSPUtil.getParameter(request, prefix	+ "avg_bsa_capa_qty", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] avgLastPortDrftQty = (JSPUtil.getParameter(request, prefix	+ "avg_last_port_drft_qty", length));
			String[] avgTtlLoadTeuQty = (JSPUtil.getParameter(request, prefix	+ "avg_ttl_load_teu_qty", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vslSlanDirSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_seq", length));
			String[] avgLastPortBlstQty = (JSPUtil.getParameter(request, prefix	+ "avg_last_port_blst_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LoadFactorListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (avgLoadFactRatio[i] != null)
					model.setAvgLoadFactRatio(avgLoadFactRatio[i]);
				if (avgBsaCapaQty[i] != null)
					model.setAvgBsaCapaQty(avgBsaCapaQty[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (avgLastPortDrftQty[i] != null)
					model.setAvgLastPortDrftQty(avgLastPortDrftQty[i]);
				if (avgTtlLoadTeuQty[i] != null)
					model.setAvgTtlLoadTeuQty(avgTtlLoadTeuQty[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslSlanDirSeq[i] != null)
					model.setVslSlanDirSeq(vslSlanDirSeq[i]);
				if (avgLastPortBlstQty[i] != null)
					model.setAvgLastPortBlstQty(avgLastPortBlstQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLoadFactorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LoadFactorListVO[]
	 */
	public LoadFactorListVO[] getLoadFactorListVOs(){
		LoadFactorListVO[] vos = (LoadFactorListVO[])models.toArray(new LoadFactorListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgLoadFactRatio = this.avgLoadFactRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgBsaCapaQty = this.avgBsaCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgLastPortDrftQty = this.avgLastPortDrftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgTtlLoadTeuQty = this.avgTtlLoadTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirSeq = this.vslSlanDirSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgLastPortBlstQty = this.avgLastPortBlstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
