/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfVnorAtchFileVO.java
*@FileTitle : OpfVnorAtchFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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

public class OpfVnorAtchFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfVnorAtchFileVO> models = new ArrayList<OpfVnorAtchFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileDownload = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String filePathUrl = null;
	/* Column Info */
	private String atchFileLnkSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfVnorAtchFileVO() {}

	public OpfVnorAtchFileVO(String ibflag, String pagerows, String atchFileLnkId, String atchFileLnkSeq, String fileSavId, String fileUpldNm, String filePathUrl, String updUsrId, String updDt, String fileDownload) {
		this.updDt = updDt;
		this.fileDownload = fileDownload;
		this.fileSavId = fileSavId;
		this.fileUpldNm = fileUpldNm;
		this.ibflag = ibflag;
		this.filePathUrl = filePathUrl;
		this.atchFileLnkSeq = atchFileLnkSeq;
		this.updUsrId = updUsrId;
		this.atchFileLnkId = atchFileLnkId;
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
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_path_url", getFilePathUrl());
		this.hashColumns.put("atch_file_lnk_seq", getAtchFileLnkSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
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
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_path_url", "filePathUrl");
		this.hashFields.put("atch_file_lnk_seq", "atchFileLnkSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
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
	 * Column Info
	 * @return fileUpldNm
	 */
	public String getFileUpldNm() {
		return this.fileUpldNm;
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
	 * @return filePathUrl
	 */
	public String getFilePathUrl() {
		return this.filePathUrl;
	}
	
	/**
	 * Column Info
	 * @return atchFileLnkSeq
	 */
	public String getAtchFileLnkSeq() {
		return this.atchFileLnkSeq;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * Column Info
	 * @param fileUpldNm
	 */
	public void setFileUpldNm(String fileUpldNm) {
		this.fileUpldNm = fileUpldNm;
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
	 * @param filePathUrl
	 */
	public void setFilePathUrl(String filePathUrl) {
		this.filePathUrl = filePathUrl;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkSeq
	 */
	public void setAtchFileLnkSeq(String atchFileLnkSeq) {
		this.atchFileLnkSeq = atchFileLnkSeq;
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
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFilePathUrl(JSPUtil.getParameter(request, prefix + "file_path_url", ""));
		setAtchFileLnkSeq(JSPUtil.getParameter(request, prefix + "atch_file_lnk_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfVnorAtchFileVO[]
	 */
	public OpfVnorAtchFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfVnorAtchFileVO[]
	 */
	public OpfVnorAtchFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfVnorAtchFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] filePathUrl = (JSPUtil.getParameter(request, prefix	+ "file_path_url", length));
			String[] atchFileLnkSeq = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfVnorAtchFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (filePathUrl[i] != null)
					model.setFilePathUrl(filePathUrl[i]);
				if (atchFileLnkSeq[i] != null)
					model.setAtchFileLnkSeq(atchFileLnkSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfVnorAtchFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfVnorAtchFileVO[]
	 */
	public OpfVnorAtchFileVO[] getOpfVnorAtchFileVOs(){
		OpfVnorAtchFileVO[] vos = (OpfVnorAtchFileVO[])models.toArray(new OpfVnorAtchFileVO[models.size()]);
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
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathUrl = this.filePathUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkSeq = this.atchFileLnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
