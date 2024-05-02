/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315PrefixIrgInfoVO.java
*@FileTitle : Edi315PrefixIrgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.17 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixIrgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixIrgInfoVO> models = new ArrayList<Edi315PrefixIrgInfoVO>();
	
	/* Column Info */
	private String fromLoc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toArvDtGmt = null;
	/* Column Info */
	private String toArvDt = null;
	/* Column Info */
	private String fromDptDt = null;
	/* Column Info */
	private String fromArvDt = null;
	/* Column Info */
	private String vendor = null;
	/* Column Info */
	private String fromDptDtGmt = null;
	/* Column Info */
	private String toLoc = null;
	/* Column Info */
	private String fromArvDtGmt = null;
	/* Column Info */
	private String mode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixIrgInfoVO() {}

	public Edi315PrefixIrgInfoVO(String ibflag, String pagerows, String mode, String vendor, String fromLoc, String fromArvDt, String fromArvDtGmt, String fromDptDt, String fromDptDtGmt, String toLoc, String toArvDt, String toArvDtGmt) {
		this.fromLoc = fromLoc;
		this.ibflag = ibflag;
		this.toArvDtGmt = toArvDtGmt;
		this.toArvDt = toArvDt;
		this.fromDptDt = fromDptDt;
		this.fromArvDt = fromArvDt;
		this.vendor = vendor;
		this.fromDptDtGmt = fromDptDtGmt;
		this.toLoc = toLoc;
		this.fromArvDtGmt = fromArvDtGmt;
		this.mode = mode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_loc", getFromLoc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_arv_dt_gmt", getToArvDtGmt());
		this.hashColumns.put("to_arv_dt", getToArvDt());
		this.hashColumns.put("from_dpt_dt", getFromDptDt());
		this.hashColumns.put("from_arv_dt", getFromArvDt());
		this.hashColumns.put("vendor", getVendor());
		this.hashColumns.put("from_dpt_dt_gmt", getFromDptDtGmt());
		this.hashColumns.put("to_loc", getToLoc());
		this.hashColumns.put("from_arv_dt_gmt", getFromArvDtGmt());
		this.hashColumns.put("mode", getMode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_loc", "fromLoc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_arv_dt_gmt", "toArvDtGmt");
		this.hashFields.put("to_arv_dt", "toArvDt");
		this.hashFields.put("from_dpt_dt", "fromDptDt");
		this.hashFields.put("from_arv_dt", "fromArvDt");
		this.hashFields.put("vendor", "vendor");
		this.hashFields.put("from_dpt_dt_gmt", "fromDptDtGmt");
		this.hashFields.put("to_loc", "toLoc");
		this.hashFields.put("from_arv_dt_gmt", "fromArvDtGmt");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromLoc
	 */
	public String getFromLoc() {
		return this.fromLoc;
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
	 * @return toArvDtGmt
	 */
	public String getToArvDtGmt() {
		return this.toArvDtGmt;
	}
	
	/**
	 * Column Info
	 * @return toArvDt
	 */
	public String getToArvDt() {
		return this.toArvDt;
	}
	
	/**
	 * Column Info
	 * @return fromDptDt
	 */
	public String getFromDptDt() {
		return this.fromDptDt;
	}
	
	/**
	 * Column Info
	 * @return fromArvDt
	 */
	public String getFromArvDt() {
		return this.fromArvDt;
	}
	
	/**
	 * Column Info
	 * @return vendor
	 */
	public String getVendor() {
		return this.vendor;
	}
	
	/**
	 * Column Info
	 * @return fromDptDtGmt
	 */
	public String getFromDptDtGmt() {
		return this.fromDptDtGmt;
	}
	
	/**
	 * Column Info
	 * @return toLoc
	 */
	public String getToLoc() {
		return this.toLoc;
	}
	
	/**
	 * Column Info
	 * @return fromArvDtGmt
	 */
	public String getFromArvDtGmt() {
		return this.fromArvDtGmt;
	}
	
	/**
	 * Column Info
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
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
	 * @param fromLoc
	 */
	public void setFromLoc(String fromLoc) {
		this.fromLoc = fromLoc;
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
	 * @param toArvDtGmt
	 */
	public void setToArvDtGmt(String toArvDtGmt) {
		this.toArvDtGmt = toArvDtGmt;
	}
	
	/**
	 * Column Info
	 * @param toArvDt
	 */
	public void setToArvDt(String toArvDt) {
		this.toArvDt = toArvDt;
	}
	
	/**
	 * Column Info
	 * @param fromDptDt
	 */
	public void setFromDptDt(String fromDptDt) {
		this.fromDptDt = fromDptDt;
	}
	
	/**
	 * Column Info
	 * @param fromArvDt
	 */
	public void setFromArvDt(String fromArvDt) {
		this.fromArvDt = fromArvDt;
	}
	
	/**
	 * Column Info
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * Column Info
	 * @param fromDptDtGmt
	 */
	public void setFromDptDtGmt(String fromDptDtGmt) {
		this.fromDptDtGmt = fromDptDtGmt;
	}
	
	/**
	 * Column Info
	 * @param toLoc
	 */
	public void setToLoc(String toLoc) {
		this.toLoc = toLoc;
	}
	
	/**
	 * Column Info
	 * @param fromArvDtGmt
	 */
	public void setFromArvDtGmt(String fromArvDtGmt) {
		this.fromArvDtGmt = fromArvDtGmt;
	}
	
	/**
	 * Column Info
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
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
		setFromLoc(JSPUtil.getParameter(request, "from_loc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToArvDtGmt(JSPUtil.getParameter(request, "to_arv_dt_gmt", ""));
		setToArvDt(JSPUtil.getParameter(request, "to_arv_dt", ""));
		setFromDptDt(JSPUtil.getParameter(request, "from_dpt_dt", ""));
		setFromArvDt(JSPUtil.getParameter(request, "from_arv_dt", ""));
		setVendor(JSPUtil.getParameter(request, "vendor", ""));
		setFromDptDtGmt(JSPUtil.getParameter(request, "from_dpt_dt_gmt", ""));
		setToLoc(JSPUtil.getParameter(request, "to_loc", ""));
		setFromArvDtGmt(JSPUtil.getParameter(request, "from_arv_dt_gmt", ""));
		setMode(JSPUtil.getParameter(request, "mode", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixIrgInfoVO[]
	 */
	public Edi315PrefixIrgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixIrgInfoVO[]
	 */
	public Edi315PrefixIrgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixIrgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromLoc = (JSPUtil.getParameter(request, prefix	+ "from_loc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toArvDtGmt = (JSPUtil.getParameter(request, prefix	+ "to_arv_dt_gmt", length));
			String[] toArvDt = (JSPUtil.getParameter(request, prefix	+ "to_arv_dt", length));
			String[] fromDptDt = (JSPUtil.getParameter(request, prefix	+ "from_dpt_dt", length));
			String[] fromArvDt = (JSPUtil.getParameter(request, prefix	+ "from_arv_dt", length));
			String[] vendor = (JSPUtil.getParameter(request, prefix	+ "vendor", length));
			String[] fromDptDtGmt = (JSPUtil.getParameter(request, prefix	+ "from_dpt_dt_gmt", length));
			String[] toLoc = (JSPUtil.getParameter(request, prefix	+ "to_loc", length));
			String[] fromArvDtGmt = (JSPUtil.getParameter(request, prefix	+ "from_arv_dt_gmt", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixIrgInfoVO();
				if (fromLoc[i] != null)
					model.setFromLoc(fromLoc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toArvDtGmt[i] != null)
					model.setToArvDtGmt(toArvDtGmt[i]);
				if (toArvDt[i] != null)
					model.setToArvDt(toArvDt[i]);
				if (fromDptDt[i] != null)
					model.setFromDptDt(fromDptDt[i]);
				if (fromArvDt[i] != null)
					model.setFromArvDt(fromArvDt[i]);
				if (vendor[i] != null)
					model.setVendor(vendor[i]);
				if (fromDptDtGmt[i] != null)
					model.setFromDptDtGmt(fromDptDtGmt[i]);
				if (toLoc[i] != null)
					model.setToLoc(toLoc[i]);
				if (fromArvDtGmt[i] != null)
					model.setFromArvDtGmt(fromArvDtGmt[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixIrgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixIrgInfoVO[]
	 */
	public Edi315PrefixIrgInfoVO[] getEdi315PrefixIrgInfoVOs(){
		Edi315PrefixIrgInfoVO[] vos = (Edi315PrefixIrgInfoVO[])models.toArray(new Edi315PrefixIrgInfoVO[models.size()]);
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
		this.fromLoc = this.fromLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toArvDtGmt = this.toArvDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toArvDt = this.toArvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDptDt = this.fromDptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromArvDt = this.fromArvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendor = this.vendor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDptDtGmt = this.fromDptDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoc = this.toLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromArvDtGmt = this.fromArvDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
