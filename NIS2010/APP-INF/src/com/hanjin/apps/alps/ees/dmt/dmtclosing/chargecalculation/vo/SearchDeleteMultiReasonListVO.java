/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchDeleteMultiReasonListVO.java
*@FileTitle : SearchDeleteMultiReasonListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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

public class SearchDeleteMultiReasonListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDeleteMultiReasonListVO> models = new ArrayList<SearchDeleteMultiReasonListVO>();
	
	/* Column Info */
	private String fileAtchMdtYn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String specRsnCd = null;
	/* Column Info */
	private String rsnCd = null;
	/* Column Info */
	private String specRsnDesc = null;
	/* Column Info */
	private String rsnDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchDeleteMultiReasonListVO() {}

	public SearchDeleteMultiReasonListVO(String ibflag, String pagerows, String rsnCd, String rsnDesc, String specRsnCd, String specRsnDesc, String fileAtchMdtYn) {
		this.fileAtchMdtYn = fileAtchMdtYn;
		this.ibflag = ibflag;
		this.specRsnCd = specRsnCd;
		this.rsnCd = rsnCd;
		this.specRsnDesc = specRsnDesc;
		this.rsnDesc = rsnDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_atch_mdt_yn", getFileAtchMdtYn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spec_rsn_cd", getSpecRsnCd());
		this.hashColumns.put("rsn_cd", getRsnCd());
		this.hashColumns.put("spec_rsn_desc", getSpecRsnDesc());
		this.hashColumns.put("rsn_desc", getRsnDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_atch_mdt_yn", "fileAtchMdtYn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spec_rsn_cd", "specRsnCd");
		this.hashFields.put("rsn_cd", "rsnCd");
		this.hashFields.put("spec_rsn_desc", "specRsnDesc");
		this.hashFields.put("rsn_desc", "rsnDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileAtchMdtYn
	 */
	public String getFileAtchMdtYn() {
		return this.fileAtchMdtYn;
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
	 * @return specRsnCd
	 */
	public String getSpecRsnCd() {
		return this.specRsnCd;
	}
	
	/**
	 * Column Info
	 * @return rsnCd
	 */
	public String getRsnCd() {
		return this.rsnCd;
	}
	
	/**
	 * Column Info
	 * @return specRsnDesc
	 */
	public String getSpecRsnDesc() {
		return this.specRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return rsnDesc
	 */
	public String getRsnDesc() {
		return this.rsnDesc;
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
	 * @param fileAtchMdtYn
	 */
	public void setFileAtchMdtYn(String fileAtchMdtYn) {
		this.fileAtchMdtYn = fileAtchMdtYn;
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
	 * @param specRsnCd
	 */
	public void setSpecRsnCd(String specRsnCd) {
		this.specRsnCd = specRsnCd;
	}
	
	/**
	 * Column Info
	 * @param rsnCd
	 */
	public void setRsnCd(String rsnCd) {
		this.rsnCd = rsnCd;
	}
	
	/**
	 * Column Info
	 * @param specRsnDesc
	 */
	public void setSpecRsnDesc(String specRsnDesc) {
		this.specRsnDesc = specRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param rsnDesc
	 */
	public void setRsnDesc(String rsnDesc) {
		this.rsnDesc = rsnDesc;
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
		setFileAtchMdtYn(JSPUtil.getParameter(request, prefix + "file_atch_mdt_yn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpecRsnCd(JSPUtil.getParameter(request, prefix + "spec_rsn_cd", ""));
		setRsnCd(JSPUtil.getParameter(request, prefix + "rsn_cd", ""));
		setSpecRsnDesc(JSPUtil.getParameter(request, prefix + "spec_rsn_desc", ""));
		setRsnDesc(JSPUtil.getParameter(request, prefix + "rsn_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDeleteMultiReasonListVO[]
	 */
	public SearchDeleteMultiReasonListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDeleteMultiReasonListVO[]
	 */
	public SearchDeleteMultiReasonListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDeleteMultiReasonListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileAtchMdtYn = (JSPUtil.getParameter(request, prefix	+ "file_atch_mdt_yn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] specRsnCd = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_cd", length));
			String[] rsnCd = (JSPUtil.getParameter(request, prefix	+ "rsn_cd", length));
			String[] specRsnDesc = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_desc", length));
			String[] rsnDesc = (JSPUtil.getParameter(request, prefix	+ "rsn_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDeleteMultiReasonListVO();
				if (fileAtchMdtYn[i] != null)
					model.setFileAtchMdtYn(fileAtchMdtYn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (specRsnCd[i] != null)
					model.setSpecRsnCd(specRsnCd[i]);
				if (rsnCd[i] != null)
					model.setRsnCd(rsnCd[i]);
				if (specRsnDesc[i] != null)
					model.setSpecRsnDesc(specRsnDesc[i]);
				if (rsnDesc[i] != null)
					model.setRsnDesc(rsnDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDeleteMultiReasonListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDeleteMultiReasonListVO[]
	 */
	public SearchDeleteMultiReasonListVO[] getSearchDeleteMultiReasonListVOs(){
		SearchDeleteMultiReasonListVO[] vos = (SearchDeleteMultiReasonListVO[])models.toArray(new SearchDeleteMultiReasonListVO[models.size()]);
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
		this.fileAtchMdtYn = this.fileAtchMdtYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnCd = this.specRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCd = this.rsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnDesc = this.specRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnDesc = this.rsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
