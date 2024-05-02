/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementFileUploadVO.java
*@FileTitle : AgreementFileUploadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.31  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

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

public class AgreementFileUploadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgreementFileUploadVO> models = new ArrayList<AgreementFileUploadVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String filePathUrl = null;
	/* Column Info */
	private String fileDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String filePathNm = null;
	/* Column Info */
	private String orgFileNm = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fileSzCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AgreementFileUploadVO() {}

	public AgreementFileUploadVO(String ibflag, String pagerows, String agmtSeq, String agmtCtyCd, String fileDtlSeq, String filePathNm, String orgFileNm, String creUsrId, String updUsrId, String fileSavId, String fileUpldNm, String fileSzCapa, String filePathUrl, String seq) {
		this.fileSavId = fileSavId;
		this.fileUpldNm = fileUpldNm;
		this.agmtSeq = agmtSeq;
		this.filePathUrl = filePathUrl;
		this.fileDtlSeq = fileDtlSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.filePathNm = filePathNm;
		this.orgFileNm = orgFileNm;
		this.agmtCtyCd = agmtCtyCd;
		this.updUsrId = updUsrId;
		this.fileSzCapa = fileSzCapa;
		this.creUsrId = creUsrId;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("file_path_url", getFilePathUrl());
		this.hashColumns.put("file_dtl_seq", getFileDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_path_nm", getFilePathNm());
		this.hashColumns.put("org_file_nm", getOrgFileNm());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("upd_usr_id", getUpdusrid());
		this.hashColumns.put("file_sz_capa", getFileSzCapa());
		this.hashColumns.put("cre_usr_id", getCreusrid());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("file_path_url", "filePathUrl");
		this.hashFields.put("file_dtl_seq", "fileDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_path_nm", "filePathNm");
		this.hashFields.put("org_file_nm", "orgFileNm");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("file_sz_capa", "fileSzCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
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
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return fileDtlSeq
	 */
	public String getFileDtlSeq() {
		return this.fileDtlSeq;
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
	 * @return orgFileNm
	 */
	public String getOrgFileNm() {
		return this.orgFileNm;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return updusrid
	 */
	public String getUpdusrid() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return fileSzCapa
	 */
	public String getFileSzCapa() {
		return this.fileSzCapa;
	}
	
	/**
	 * Column Info
	 * @return creusrid
	 */
	public String getCreusrid() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param fileDtlSeq
	 */
	public void setFileDtlSeq(String fileDtlSeq) {
		this.fileDtlSeq = fileDtlSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param orgFileNm
	 */
	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdusrid(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param fileSzCapa
	 */
	public void setFileSzCapa(String fileSzCapa) {
		this.fileSzCapa = fileSzCapa;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreusrid(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setFilePathUrl(JSPUtil.getParameter(request, prefix + "file_path_url", ""));
		setFileDtlSeq(JSPUtil.getParameter(request, prefix + "file_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFilePathNm(JSPUtil.getParameter(request, prefix + "file_path_nm", ""));
		setOrgFileNm(JSPUtil.getParameter(request, prefix + "org_file_nm", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setUpdusrid(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFileSzCapa(JSPUtil.getParameter(request, prefix + "file_sz_capa", ""));
		setCreusrid(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementFileUploadVO[]
	 */
	public AgreementFileUploadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementFileUploadVO[]
	 */
	public AgreementFileUploadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementFileUploadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] filePathUrl = (JSPUtil.getParameter(request, prefix	+ "file_path_url", length));
			String[] fileDtlSeq = (JSPUtil.getParameter(request, prefix	+ "file_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] filePathNm = (JSPUtil.getParameter(request, prefix	+ "file_path_nm", length));
			String[] orgFileNm = (JSPUtil.getParameter(request, prefix	+ "org_file_nm", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fileSzCapa = (JSPUtil.getParameter(request, prefix	+ "file_sz_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgreementFileUploadVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (filePathUrl[i] != null)
					model.setFilePathUrl(filePathUrl[i]);
				if (fileDtlSeq[i] != null)
					model.setFileDtlSeq(fileDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (filePathNm[i] != null)
					model.setFilePathNm(filePathNm[i]);
				if (orgFileNm[i] != null)
					model.setOrgFileNm(orgFileNm[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (updUsrId[i] != null)
					model.setUpdusrid(updUsrId[i]);
				if (fileSzCapa[i] != null)
					model.setFileSzCapa(fileSzCapa[i]);
				if (creUsrId[i] != null)
					model.setCreusrid(creUsrId[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementFileUploadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementFileUploadVO[]
	 */
	public AgreementFileUploadVO[] getAgreementFileUploadVOs(){
		AgreementFileUploadVO[] vos = (AgreementFileUploadVO[])models.toArray(new AgreementFileUploadVO[models.size()]);
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
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathUrl = this.filePathUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDtlSeq = this.fileDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathNm = this.filePathNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFileNm = this.orgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSzCapa = this.fileSzCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
