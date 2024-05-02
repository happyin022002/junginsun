/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaCgoRlseBkbcFlatFileVO.java
*@FileTitle : CaCgoRlseBkbcFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.10.16 김태경
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaCgoRlseBkbcFlatFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaCgoRlseBkbcFlatFileVO> models = new ArrayList<CaCgoRlseBkbcFlatFileVO>();
	
	/* Column Info */
	private String flatFileBody = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flatFileHeader = null;
	/* Column Info */
	private String dupFlatFileHeader = null;
	/* Column Info */
	private String snpFileHeader = null;
	/* Column Info */
	private String flatFileVvd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaCgoRlseBkbcFlatFileVO() {}

	public CaCgoRlseBkbcFlatFileVO(String ibflag, String pagerows, String flatFileHeader, String dupFlatFileHeader, String snpFileHeader, String flatFileBody, String flatFileVvd) {
		this.flatFileBody = flatFileBody;
		this.ibflag = ibflag;
		this.flatFileHeader = flatFileHeader;
		this.dupFlatFileHeader = dupFlatFileHeader;
		this.snpFileHeader = snpFileHeader;
		this.flatFileVvd = flatFileVvd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flat_file_body", getFlatFileBody());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flat_file_header", getFlatFileHeader());
		this.hashColumns.put("dup_flat_file_header", getDupFlatFileHeader());
		this.hashColumns.put("snp_file_header", getSnpFileHeader());
		this.hashColumns.put("flat_file_vvd", getFlatFileVvd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flat_file_body", "flatFileBody");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flat_file_header", "flatFileHeader");
		this.hashFields.put("dup_flat_file_header", "dupFlatFileHeader");
		this.hashFields.put("snp_file_header", "snpFileHeader");
		this.hashFields.put("flat_file_vvd", "flatFileVvd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return flatFileBody
	 */
	public String getFlatFileBody() {
		return this.flatFileBody;
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
	 * @return flatFileHeader
	 */
	public String getFlatFileHeader() {
		return this.flatFileHeader;
	}
	
	/**
	 * Column Info
	 * @return dupFlatFileHeader
	 */
	public String getDupFlatFileHeader() {
		return this.dupFlatFileHeader;
	}
	
	/**
	 * Column Info
	 * @return snpFileHeader
	 */
	public String getSnpFileHeader() {
		return this.snpFileHeader;
	}
	
	/**
	 * Column Info
	 * @return flatFileVvd
	 */
	public String getFlatFileVvd() {
		return this.flatFileVvd;
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
	 * @param flatFileBody
	 */
	public void setFlatFileBody(String flatFileBody) {
		this.flatFileBody = flatFileBody;
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
	 * @param flatFileHeader
	 */
	public void setFlatFileHeader(String flatFileHeader) {
		this.flatFileHeader = flatFileHeader;
	}
	
	/**
	 * Column Info
	 * @param dupFlatFileHeader
	 */
	public void setDupFlatFileHeader(String dupFlatFileHeader) {
		this.dupFlatFileHeader = dupFlatFileHeader;
	}
	
	/**
	 * Column Info
	 * @param snpFileHeader
	 */
	public void setSnpFileHeader(String snpFileHeader) {
		this.snpFileHeader = snpFileHeader;
	}
	
	/**
	 * Column Info
	 * @param flatFileVvd
	 */
	public void setFlatFileVvd(String flatFileVvd) {
		this.flatFileVvd = flatFileVvd;
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
		setFlatFileBody(JSPUtil.getParameter(request, "flat_file_body", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFlatFileHeader(JSPUtil.getParameter(request, "flat_file_header", ""));
		setDupFlatFileHeader(JSPUtil.getParameter(request, "dup_flat_file_header", ""));
		setSnpFileHeader(JSPUtil.getParameter(request, "snp_file_header", ""));
		setFlatFileVvd(JSPUtil.getParameter(request, "flat_file_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaCgoRlseBkbcFlatFileVO[]
	 */
	public CaCgoRlseBkbcFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaCgoRlseBkbcFlatFileVO[]
	 */
	public CaCgoRlseBkbcFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaCgoRlseBkbcFlatFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] flatFileBody = (JSPUtil.getParameter(request, prefix	+ "flat_file_body", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flatFileHeader = (JSPUtil.getParameter(request, prefix	+ "flat_file_header", length));
			String[] dupFlatFileHeader = (JSPUtil.getParameter(request, prefix	+ "dup_flat_file_header", length));
			String[] snpFileHeader = (JSPUtil.getParameter(request, prefix	+ "snp_file_header", length));
			String[] flatFileVvd = (JSPUtil.getParameter(request, prefix	+ "flat_file_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaCgoRlseBkbcFlatFileVO();
				if (flatFileBody[i] != null)
					model.setFlatFileBody(flatFileBody[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flatFileHeader[i] != null)
					model.setFlatFileHeader(flatFileHeader[i]);
				if (dupFlatFileHeader[i] != null)
					model.setDupFlatFileHeader(dupFlatFileHeader[i]);
				if (snpFileHeader[i] != null)
					model.setSnpFileHeader(snpFileHeader[i]);
				if (flatFileVvd[i] != null)
					model.setFlatFileVvd(flatFileVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaCgoRlseBkbcFlatFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaCgoRlseBkbcFlatFileVO[]
	 */
	public CaCgoRlseBkbcFlatFileVO[] getCaCgoRlseBkbcFlatFileVOs(){
		CaCgoRlseBkbcFlatFileVO[] vos = (CaCgoRlseBkbcFlatFileVO[])models.toArray(new CaCgoRlseBkbcFlatFileVO[models.size()]);
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
		this.flatFileBody = this.flatFileBody .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFileHeader = this.flatFileHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlatFileHeader = this.dupFlatFileHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snpFileHeader = this.snpFileHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFileVvd = this.flatFileVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
