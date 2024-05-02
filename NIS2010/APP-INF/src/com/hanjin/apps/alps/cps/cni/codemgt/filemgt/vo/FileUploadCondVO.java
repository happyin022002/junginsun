/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileUploadCondVO.java
*@FileTitle : FileUploadCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.11 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FileUploadCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FileUploadCondVO> models = new ArrayList<FileUploadCondVO>();
	
	/* Column Info */
	private String clmFileSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoClmRefNo = null;
	/* Column Info */
	private String clmFileTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FileUploadCondVO() {}

	public FileUploadCondVO(String ibflag, String pagerows, String clmFileSeq, String clmFileTpCd, String cgoClmRefNo) {
		this.clmFileSeq = clmFileSeq;
		this.ibflag = ibflag;
		this.cgoClmRefNo = cgoClmRefNo;
		this.clmFileTpCd = clmFileTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clm_file_seq", getClmFileSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_clm_ref_no", getCgoClmRefNo());
		this.hashColumns.put("clm_file_tp_cd", getClmFileTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clm_file_seq", "clmFileSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_clm_ref_no", "cgoClmRefNo");
		this.hashFields.put("clm_file_tp_cd", "clmFileTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clmFileSeq
	 */
	public String getClmFileSeq() {
		return this.clmFileSeq;
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
	 * @return cgoClmRefNo
	 */
	public String getCgoClmRefNo() {
		return this.cgoClmRefNo;
	}
	
	/**
	 * Column Info
	 * @return clmFileTpCd
	 */
	public String getClmFileTpCd() {
		return this.clmFileTpCd;
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
	 * @param clmFileSeq
	 */
	public void setClmFileSeq(String clmFileSeq) {
		this.clmFileSeq = clmFileSeq;
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
	 * @param cgoClmRefNo
	 */
	public void setCgoClmRefNo(String cgoClmRefNo) {
		this.cgoClmRefNo = cgoClmRefNo;
	}
	
	/**
	 * Column Info
	 * @param clmFileTpCd
	 */
	public void setClmFileTpCd(String clmFileTpCd) {
		this.clmFileTpCd = clmFileTpCd;
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
		setClmFileSeq(JSPUtil.getParameter(request, "clm_file_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoClmRefNo(JSPUtil.getParameter(request, "cgo_clm_ref_no", ""));
		setClmFileTpCd(JSPUtil.getParameter(request, "clm_file_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FileUploadCondVO[]
	 */
	public FileUploadCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FileUploadCondVO[]
	 */
	public FileUploadCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FileUploadCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clmFileSeq = (JSPUtil.getParameter(request, prefix	+ "clm_file_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoClmRefNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_no", length));
			String[] clmFileTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_file_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FileUploadCondVO();
				if (clmFileSeq[i] != null)
					model.setClmFileSeq(clmFileSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoClmRefNo[i] != null)
					model.setCgoClmRefNo(cgoClmRefNo[i]);
				if (clmFileTpCd[i] != null)
					model.setClmFileTpCd(clmFileTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFileUploadCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FileUploadCondVO[]
	 */
	public FileUploadCondVO[] getFileUploadCondVOs(){
		FileUploadCondVO[] vos = (FileUploadCondVO[])models.toArray(new FileUploadCondVO[models.size()]);
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
		this.clmFileSeq = this.clmFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefNo = this.cgoClmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmFileTpCd = this.clmFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
