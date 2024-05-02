/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomMnrThumbnailFileAtchVO.java
*@FileTitle : CustomMnrThumbnailFileAtchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.12
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.10.12 이율규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * @author 이율규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrThumbnailFileAtchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrThumbnailFileAtchVO> models = new ArrayList<CustomMnrThumbnailFileAtchVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String filePathNm = null;
	/* Column Info */
	private String fileDtlExtrSeq = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String fileDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String thmFilePathNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrThumbnailFileAtchVO() {}

	public CustomMnrThumbnailFileAtchVO(String ibflag, String pagerows, String fileSeq, String fileDtlSeq, String fileDtlExtrSeq, String filePathNm, String thmFilePathNm, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.filePathNm = filePathNm;
		this.fileDtlExtrSeq = fileDtlExtrSeq;
		this.fileSeq = fileSeq;
		this.fileDtlSeq = fileDtlSeq;
		this.updUsrId = updUsrId;
		this.thmFilePathNm = thmFilePathNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_path_nm", getFilePathNm());
		this.hashColumns.put("file_dtl_extr_seq", getFileDtlExtrSeq());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("file_dtl_seq", getFileDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("thm_file_path_nm", getThmFilePathNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_path_nm", "filePathNm");
		this.hashFields.put("file_dtl_extr_seq", "fileDtlExtrSeq");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("file_dtl_seq", "fileDtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("thm_file_path_nm", "thmFilePathNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return filePathNm
	 */
	public String getFilePathNm() {
		return this.filePathNm;
	}
	
	/**
	 * Column Info
	 * @return fileDtlExtrSeq
	 */
	public String getFileDtlExtrSeq() {
		return this.fileDtlExtrSeq;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return fileDtlSeq
	 */
	public String getFileDtlSeq() {
		return this.fileDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return thmFilePathNm
	 */
	public String getThmFilePathNm() {
		return this.thmFilePathNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param filePathNm
	 */
	public void setFilePathNm(String filePathNm) {
		this.filePathNm = filePathNm;
	}
	
	/**
	 * Column Info
	 * @param fileDtlExtrSeq
	 */
	public void setFileDtlExtrSeq(String fileDtlExtrSeq) {
		this.fileDtlExtrSeq = fileDtlExtrSeq;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param fileDtlSeq
	 */
	public void setFileDtlSeq(String fileDtlSeq) {
		this.fileDtlSeq = fileDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param thmFilePathNm
	 */
	public void setThmFilePathNm(String thmFilePathNm) {
		this.thmFilePathNm = thmFilePathNm;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFilePathNm(JSPUtil.getParameter(request, prefix + "file_path_nm", ""));
		setFileDtlExtrSeq(JSPUtil.getParameter(request, prefix + "file_dtl_extr_seq", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setFileDtlSeq(JSPUtil.getParameter(request, prefix + "file_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setThmFilePathNm(JSPUtil.getParameter(request, prefix + "thm_file_path_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrThumbnailFileAtchVO[]
	 */
	public CustomMnrThumbnailFileAtchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrThumbnailFileAtchVO[]
	 */
	public CustomMnrThumbnailFileAtchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrThumbnailFileAtchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] filePathNm = (JSPUtil.getParameter(request, prefix	+ "file_path_nm", length));
			String[] fileDtlExtrSeq = (JSPUtil.getParameter(request, prefix	+ "file_dtl_extr_seq", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] fileDtlSeq = (JSPUtil.getParameter(request, prefix	+ "file_dtl_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] thmFilePathNm = (JSPUtil.getParameter(request, prefix	+ "thm_file_path_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrThumbnailFileAtchVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (filePathNm[i] != null)
					model.setFilePathNm(filePathNm[i]);
				if (fileDtlExtrSeq[i] != null)
					model.setFileDtlExtrSeq(fileDtlExtrSeq[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fileDtlSeq[i] != null)
					model.setFileDtlSeq(fileDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (thmFilePathNm[i] != null)
					model.setThmFilePathNm(thmFilePathNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrThumbnailFileAtchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrThumbnailFileAtchVO[]
	 */
	public CustomMnrThumbnailFileAtchVO[] getCustomMnrThumbnailFileAtchVOs(){
		CustomMnrThumbnailFileAtchVO[] vos = (CustomMnrThumbnailFileAtchVO[])models.toArray(new CustomMnrThumbnailFileAtchVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathNm = this.filePathNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDtlExtrSeq = this.fileDtlExtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDtlSeq = this.fileDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thmFilePathNm = this.thmFilePathNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
