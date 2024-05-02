/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriSgBlplExcelVO.java
*@FileTitle : PriSgBlplExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.23 문동규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSgBlplExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSgBlplExcelVO> models = new ArrayList<PriSgBlplExcelVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blplTitNm = null;
	/* Column Info */
	private String blplCtnt = null;
	/* Column Info */
	private String blplRefYr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSgBlplExcelVO() {}

	public PriSgBlplExcelVO(String ibflag, String pagerows, String blplRefYr, String blplTitNm, String blplCtnt) {
		this.ibflag = ibflag;
		this.blplTitNm = blplTitNm;
		this.blplCtnt = blplCtnt;
		this.blplRefYr = blplRefYr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("blpl_tit_nm", getBlplTitNm());
		this.hashColumns.put("blpl_ctnt", getBlplCtnt());
		this.hashColumns.put("blpl_ref_yr", getBlplRefYr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("blpl_tit_nm", "blplTitNm");
		this.hashFields.put("blpl_ctnt", "blplCtnt");
		this.hashFields.put("blpl_ref_yr", "blplRefYr");
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
	 * @return blplTitNm
	 */
	public String getBlplTitNm() {
		return this.blplTitNm;
	}
	
	/**
	 * Column Info
	 * @return blplCtnt
	 */
	public String getBlplCtnt() {
		return this.blplCtnt;
	}
	
	/**
	 * Column Info
	 * @return blplRefYr
	 */
	public String getBlplRefYr() {
		return this.blplRefYr;
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
	 * @param blplTitNm
	 */
	public void setBlplTitNm(String blplTitNm) {
		this.blplTitNm = blplTitNm;
	}
	
	/**
	 * Column Info
	 * @param blplCtnt
	 */
	public void setBlplCtnt(String blplCtnt) {
		this.blplCtnt = blplCtnt;
	}
	
	/**
	 * Column Info
	 * @param blplRefYr
	 */
	public void setBlplRefYr(String blplRefYr) {
		this.blplRefYr = blplRefYr;
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
		setBlplTitNm(JSPUtil.getParameter(request, prefix + "blpl_tit_nm", ""));
		setBlplCtnt(JSPUtil.getParameter(request, prefix + "blpl_ctnt", ""));
		setBlplRefYr(JSPUtil.getParameter(request, prefix + "blpl_ref_yr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSgBlplExcelVO[]
	 */
	public PriSgBlplExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSgBlplExcelVO[]
	 */
	public PriSgBlplExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSgBlplExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blplTitNm = (JSPUtil.getParameter(request, prefix	+ "blpl_tit_nm", length));
			String[] blplCtnt = (JSPUtil.getParameter(request, prefix	+ "blpl_ctnt", length));
			String[] blplRefYr = (JSPUtil.getParameter(request, prefix	+ "blpl_ref_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSgBlplExcelVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blplTitNm[i] != null)
					model.setBlplTitNm(blplTitNm[i]);
				if (blplCtnt[i] != null)
					model.setBlplCtnt(blplCtnt[i]);
				if (blplRefYr[i] != null)
					model.setBlplRefYr(blplRefYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSgBlplExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSgBlplExcelVO[]
	 */
	public PriSgBlplExcelVO[] getPriSgBlplExcelVOs(){
		PriSgBlplExcelVO[] vos = (PriSgBlplExcelVO[])models.toArray(new PriSgBlplExcelVO[models.size()]);
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
		this.blplTitNm = this.blplTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplCtnt = this.blplCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplRefYr = this.blplRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
