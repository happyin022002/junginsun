/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FileUploadListVO.java
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.15 이준범 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.joocommon.joofileupload.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FileUploadListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FileUploadListVO> models = new ArrayList<FileUploadListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileDownload = null;
	/* Column Info */
	private String fileSavId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crrCntcSeq = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FileUploadListVO() {}

	public FileUploadListVO(String ibflag, String pagerows, String joCrrCd, String crrCntcSeq, String fileSavId, String fileNm, String fileDownload, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.fileDownload = fileDownload;
		this.fileSavId = fileSavId;
		this.ibflag = ibflag;
		this.crrCntcSeq = crrCntcSeq;
		this.joCrrCd = joCrrCd;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_download", getFileDownload());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_cntc_seq", getCrrCntcSeq());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_download", "fileDownload");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_cntc_seq", "crrCntcSeq");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return fileDownload
	 */
	public String getFileDownload() {
		return this.fileDownload;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return crrCntcSeq
	 */
	public String getCrrCntcSeq() {
		return this.crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param fileDownload
	 */
	public void setFileDownload(String fileDownload) {
		this.fileDownload = fileDownload;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param crrCntcSeq
	 */
	public void setCrrCntcSeq(String crrCntcSeq) {
		this.crrCntcSeq = crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFileDownload(JSPUtil.getParameter(request, prefix + "file_download", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCrrCntcSeq(JSPUtil.getParameter(request, prefix + "crr_cntc_seq", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FileUploadListVO[]
	 */
	public FileUploadListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FileUploadListVO[]
	 */
	public FileUploadListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FileUploadListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crrCntcSeq = (JSPUtil.getParameter(request, prefix	+ "crr_cntc_seq", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FileUploadListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrCntcSeq[i] != null)
					model.setCrrCntcSeq(crrCntcSeq[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFileUploadListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FileUploadListVO[]
	 */
	public FileUploadListVO[] getFileUploadListVOs(){
		FileUploadListVO[] vos = (FileUploadListVO[])models.toArray(new FileUploadListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCntcSeq = this.crrCntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
