/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FileUploadListVO.java
*@FileTitle : FileUploadListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.03.24 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FileUploadListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FileUploadListVO> models = new ArrayList<FileUploadListVO>();
	
	/* Column Info */
	private String pgmSubSysCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String drpOffChgSeq = null;
	/* Column Info */
	private String drpOffChgTrfSeq = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String filePathUrl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fileSzCapa = null;
	/* Column Info */
	private String atchFileLnkSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fileDownload = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FileUploadListVO() {}

	public FileUploadListVO(String ibflag, String pagerows, String atchFileLnkId, String atchFileLnkSeq, String fileSavId, String fileUpldNm, String fileSzCapa, String filePathUrl, String pgmSubSysCd, String creUsrId, String creDt, String updUsrId, String updDt, String bkgNo, String cntrNo, String drpOffChgSeq, String drpOffChgTrfSeq, String fileDownload) {
		this.pgmSubSysCd = pgmSubSysCd;
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.drpOffChgSeq = drpOffChgSeq;
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
		this.fileUpldNm = fileUpldNm;
		this.creDt = creDt;
		this.filePathUrl = filePathUrl;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.fileSzCapa = fileSzCapa;
		this.atchFileLnkSeq = atchFileLnkSeq;
		this.updUsrId = updUsrId;
		this.fileDownload = fileDownload;		
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pgm_sub_sys_cd", getPgmSubSysCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("drp_off_chg_seq", getDrpOffChgSeq());
		this.hashColumns.put("drp_off_chg_trf_seq", getDrpOffChgTrfSeq());
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("file_path_url", getFilePathUrl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("file_sz_capa", getFileSzCapa());
		this.hashColumns.put("atch_file_lnk_seq", getAtchFileLnkSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("file_download", getFileDownload());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pgm_sub_sys_cd", "pgmSubSysCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("drp_off_chg_seq", "drpOffChgSeq");
		this.hashFields.put("drp_off_chg_trf_seq", "drpOffChgTrfSeq");
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("file_path_url", "filePathUrl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("file_sz_capa", "fileSzCapa");
		this.hashFields.put("atch_file_lnk_seq", "atchFileLnkSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("file_download", "fileDownload");		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pgmSubSysCd
	 */
	public String getPgmSubSysCd() {
		return this.pgmSubSysCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * Column Info
	 * @return drpOffChgSeq
	 */
	public String getDrpOffChgSeq() {
		return drpOffChgSeq;
	}

	/**
	 * Column Info
	 * @return drpOffChgTrfSeq
	 */
	public String getDrpOffChgTrfSeq() {
		return drpOffChgTrfSeq;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return filePathUrl
	 */
	public String getFilePathUrl() {
		return this.filePathUrl;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return fileDownload
	 */
	public String getFileDownload() {
		return this.fileDownload;
	}

	/**
	 * Column Info
	 * @param pgmSubSysCd
	 */
	public void setPgmSubSysCd(String pgmSubSysCd) {
		this.pgmSubSysCd = pgmSubSysCd;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param drpOffChgSeq
	 */
	public void setDrpOffChgSeq(String drpOffChgSeq) {
		this.drpOffChgSeq = drpOffChgSeq;
	}

	/**
	 * Column Info
	 * @param drpOffChgTrfSeq
	 */
	public void setDrpOffChgTrfSeq(String drpOffChgTrfSeq) {
		this.drpOffChgTrfSeq = drpOffChgTrfSeq;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param filePathUrl
	 */
	public void setFilePathUrl(String filePathUrl) {
		this.filePathUrl = filePathUrl;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param fileDownload
	 */
	public void setFileDownload(String fileDownload) {
		this.fileDownload = fileDownload;
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
		setPgmSubSysCd(JSPUtil.getParameter(request, prefix + "pgm_sub_sys_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDrpOffChgSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_seq", ""));
		setDrpOffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drp_off_chg_trf_seq", ""));
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFilePathUrl(JSPUtil.getParameter(request, prefix + "file_path_url", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFileSzCapa(JSPUtil.getParameter(request, prefix + "file_sz_capa", ""));
		setAtchFileLnkSeq(JSPUtil.getParameter(request, prefix + "atch_file_lnk_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFileDownload(JSPUtil.getParameter(request, prefix + "file_download", ""));		
		
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
			String[] pgmSubSysCd = (JSPUtil.getParameter(request, prefix	+ "pgm_sub_sys_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] drpOffChgSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_seq", length));
			String[] drpOffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drp_off_chg_trf_seq", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] filePathUrl = (JSPUtil.getParameter(request, prefix	+ "file_path_url", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fileSzCapa = (JSPUtil.getParameter(request, prefix	+ "file_sz_capa", length));
			String[] atchFileLnkSeq = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new FileUploadListVO();
				if (pgmSubSysCd[i] != null)
					model.setPgmSubSysCd(pgmSubSysCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (drpOffChgSeq[i] != null)
					model.setDrpOffChgSeq(drpOffChgSeq[i]);
				if (drpOffChgTrfSeq[i] != null)
					model.setDrpOffChgTrfSeq(drpOffChgTrfSeq[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (filePathUrl[i] != null)
					model.setFilePathUrl(filePathUrl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fileSzCapa[i] != null)
					model.setFileSzCapa(fileSzCapa[i]);
				if (atchFileLnkSeq[i] != null)
					model.setAtchFileLnkSeq(atchFileLnkSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				
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
		this.pgmSubSysCd = this.pgmSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgSeq = this.drpOffChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSeq = this.drpOffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathUrl = this.filePathUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSzCapa = this.fileSzCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkSeq = this.atchFileLnkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
