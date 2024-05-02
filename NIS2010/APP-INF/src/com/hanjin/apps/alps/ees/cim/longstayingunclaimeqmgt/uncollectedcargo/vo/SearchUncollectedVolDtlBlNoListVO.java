/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : SearchUncollectedVolDtlBlNoListVO.java
*@FileTitle : SearchUncollectedVolDtlBlNoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchUncollectedVolDtlBlNoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUncollectedVolDtlBlNoListVO> models = new ArrayList<SearchUncollectedVolDtlBlNoListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ucCsNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String volDtlGb = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sel = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchUncollectedVolDtlBlNoListVO() {}

	public SearchUncollectedVolDtlBlNoListVO(String ibflag, String pagerows, String sel, String blNo, String cntrNo, String cntrTpszCd, String volDtlGb, String ucCsNo) {
		this.ibflag = ibflag;
		this.ucCsNo = ucCsNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.volDtlGb = volDtlGb;
		this.blNo = blNo;
		this.sel = sel;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uc_cs_no", getUcCsNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("vol_dtl_gb", getVolDtlGb());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uc_cs_no", "ucCsNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("vol_dtl_gb", "volDtlGb");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ucCsNo
	 */
	public String getUcCsNo() {
		return this.ucCsNo;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return volDtlGb
	 */
	public String getVolDtlGb() {
		return this.volDtlGb;
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
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param ucCsNo
	 */
	public void setUcCsNo(String ucCsNo) {
		this.ucCsNo = ucCsNo;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param volDtlGb
	 */
	public void setVolDtlGb(String volDtlGb) {
		this.volDtlGb = volDtlGb;
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
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUcCsNo(JSPUtil.getParameter(request, prefix + "uc_cs_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setVolDtlGb(JSPUtil.getParameter(request, prefix + "vol_dtl_gb", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUncollectedVolDtlBlNoListVO[]
	 */
	public SearchUncollectedVolDtlBlNoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUncollectedVolDtlBlNoListVO[]
	 */
	public SearchUncollectedVolDtlBlNoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUncollectedVolDtlBlNoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ucCsNo = (JSPUtil.getParameter(request, prefix	+ "uc_cs_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] volDtlGb = (JSPUtil.getParameter(request, prefix	+ "vol_dtl_gb", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUncollectedVolDtlBlNoListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ucCsNo[i] != null)
					model.setUcCsNo(ucCsNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (volDtlGb[i] != null)
					model.setVolDtlGb(volDtlGb[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUncollectedVolDtlBlNoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUncollectedVolDtlBlNoListVO[]
	 */
	public SearchUncollectedVolDtlBlNoListVO[] getSearchUncollectedVolDtlBlNoListVOs(){
		SearchUncollectedVolDtlBlNoListVO[] vos = (SearchUncollectedVolDtlBlNoListVO[])models.toArray(new SearchUncollectedVolDtlBlNoListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCsNo = this.ucCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volDtlGb = this.volDtlGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
