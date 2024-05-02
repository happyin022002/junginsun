/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchInputListVO.java
*@FileTitle : SearchInputListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

@SuppressWarnings("unused")
public class SearchInputListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInputListVO> models = new ArrayList<SearchInputListVO>();
	
	/* Column Info */
	private String fSvcCateCd = null;
	/* Column Info */
	private String fEgCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fEgId = null;
	/* Column Info */
	private String fVndrSeq = null;
	/* Column Info */
	private String fEgRhqCd = null;
	/* Column Info */
	private String fMappingDiv = null;
	/* Column Info */
	private String fEvYr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInputListVO() {}

	public SearchInputListVO(String ibflag, String pagerows, String fEvYr, String fEgId, String fEgRhqCd, String fEgCtyCd, String fSvcCateCd, String fMappingDiv, String fVndrSeq) {
		this.fSvcCateCd = fSvcCateCd;
		this.fEgCtyCd = fEgCtyCd;
		this.ibflag = ibflag;
		this.fEgId = fEgId;
		this.fVndrSeq = fVndrSeq;
		this.fEgRhqCd = fEgRhqCd;
		this.fMappingDiv = fMappingDiv;
		this.fEvYr = fEvYr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_svc_cate_cd", getFSvcCateCd());
		this.hashColumns.put("f_eg_cty_cd", getFEgCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_eg_id", getFEgId());
		this.hashColumns.put("f_vndr_seq", getFVndrSeq());
		this.hashColumns.put("f_eg_rhq_cd", getFEgRhqCd());
		this.hashColumns.put("f_mapping_div", getFMappingDiv());
		this.hashColumns.put("f_ev_yr", getFEvYr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_svc_cate_cd", "fSvcCateCd");
		this.hashFields.put("f_eg_cty_cd", "fEgCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_eg_id", "fEgId");
		this.hashFields.put("f_vndr_seq", "fVndrSeq");
		this.hashFields.put("f_eg_rhq_cd", "fEgRhqCd");
		this.hashFields.put("f_mapping_div", "fMappingDiv");
		this.hashFields.put("f_ev_yr", "fEvYr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fSvcCateCd
	 */
	public String getFSvcCateCd() {
		return this.fSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @return fEgCtyCd
	 */
	public String getFEgCtyCd() {
		return this.fEgCtyCd;
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
	 * @return fEgId
	 */
	public String getFEgId() {
		return this.fEgId;
	}
	
	/**
	 * Column Info
	 * @return fVndrSeq
	 */
	public String getFVndrSeq() {
		return this.fVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fEgRhqCd
	 */
	public String getFEgRhqCd() {
		return this.fEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fMappingDiv
	 */
	public String getFMappingDiv() {
		return this.fMappingDiv;
	}
	
	/**
	 * Column Info
	 * @return fEvYr
	 */
	public String getFEvYr() {
		return this.fEvYr;
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
	 * @param fSvcCateCd
	 */
	public void setFSvcCateCd(String fSvcCateCd) {
		this.fSvcCateCd = fSvcCateCd;
	}
	
	/**
	 * Column Info
	 * @param fEgCtyCd
	 */
	public void setFEgCtyCd(String fEgCtyCd) {
		this.fEgCtyCd = fEgCtyCd;
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
	 * @param fEgId
	 */
	public void setFEgId(String fEgId) {
		this.fEgId = fEgId;
	}
	
	/**
	 * Column Info
	 * @param fVndrSeq
	 */
	public void setFVndrSeq(String fVndrSeq) {
		this.fVndrSeq = fVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fEgRhqCd
	 */
	public void setFEgRhqCd(String fEgRhqCd) {
		this.fEgRhqCd = fEgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fMappingDiv
	 */
	public void setFMappingDiv(String fMappingDiv) {
		this.fMappingDiv = fMappingDiv;
	}
	
	/**
	 * Column Info
	 * @param fEvYr
	 */
	public void setFEvYr(String fEvYr) {
		this.fEvYr = fEvYr;
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
		setFSvcCateCd(JSPUtil.getParameter(request, prefix + "f_svc_cate_cd", ""));
		setFEgCtyCd(JSPUtil.getParameter(request, prefix + "f_eg_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFEgId(JSPUtil.getParameter(request, prefix + "f_eg_id", ""));
		setFVndrSeq(JSPUtil.getParameter(request, prefix + "f_vndr_seq", ""));
		setFEgRhqCd(JSPUtil.getParameter(request, prefix + "f_eg_rhq_cd", ""));
		setFMappingDiv(JSPUtil.getParameter(request, prefix + "f_mapping_div", ""));
		setFEvYr(JSPUtil.getParameter(request, prefix + "f_ev_yr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInputListVO[]
	 */
	public SearchInputListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInputListVO[]
	 */
	public SearchInputListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInputListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fSvcCateCd = (JSPUtil.getParameter(request, prefix	+ "f_svc_cate_cd", length));
			String[] fEgCtyCd = (JSPUtil.getParameter(request, prefix	+ "f_eg_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fEgId = (JSPUtil.getParameter(request, prefix	+ "f_eg_id", length));
			String[] fVndrSeq = (JSPUtil.getParameter(request, prefix	+ "f_vndr_seq", length));
			String[] fEgRhqCd = (JSPUtil.getParameter(request, prefix	+ "f_eg_rhq_cd", length));
			String[] fMappingDiv = (JSPUtil.getParameter(request, prefix	+ "f_mapping_div", length));
			String[] fEvYr = (JSPUtil.getParameter(request, prefix	+ "f_ev_yr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInputListVO();
				if (fSvcCateCd[i] != null)
					model.setFSvcCateCd(fSvcCateCd[i]);
				if (fEgCtyCd[i] != null)
					model.setFEgCtyCd(fEgCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fEgId[i] != null)
					model.setFEgId(fEgId[i]);
				if (fVndrSeq[i] != null)
					model.setFVndrSeq(fVndrSeq[i]);
				if (fEgRhqCd[i] != null)
					model.setFEgRhqCd(fEgRhqCd[i]);
				if (fMappingDiv[i] != null)
					model.setFMappingDiv(fMappingDiv[i]);
				if (fEvYr[i] != null)
					model.setFEvYr(fEvYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInputListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInputListVO[]
	 */
	public SearchInputListVO[] getSearchInputListVOs(){
		SearchInputListVO[] vos = (SearchInputListVO[])models.toArray(new SearchInputListVO[models.size()]);
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
		this.fSvcCateCd = this.fSvcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEgCtyCd = this.fEgCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEgId = this.fEgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVndrSeq = this.fVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEgRhqCd = this.fEgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMappingDiv = this.fMappingDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEvYr = this.fEvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
