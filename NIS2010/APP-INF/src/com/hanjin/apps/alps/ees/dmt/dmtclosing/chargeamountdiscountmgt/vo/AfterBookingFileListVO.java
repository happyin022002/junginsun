/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingFileListVO.java
*@FileTitle : AfterBookingFileListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingFileListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingFileListVO> models = new ArrayList<AfterBookingFileListVO>();
	
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aftBkgFileDivCd = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String filePath = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aftBkgRmkLvl = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileLvl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingFileListVO() {}

	public AfterBookingFileListVO(String ibflag, String pagerows, String aftExptDarNo, String aftBkgFileDivCd, String fileSavId, String creUsrId, String creDt, String updUsrId, String updDt, String aftBkgRmkLvl, String fileNm, String fileSize, String filePath, String fileLvl) {
		this.fileSize = fileSize;
		this.updDt = updDt;
		this.aftBkgFileDivCd = aftBkgFileDivCd;
		this.fileSavId = fileSavId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.filePath = filePath;
		this.creDt = creDt;
		this.aftBkgRmkLvl = aftBkgRmkLvl;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.fileLvl = fileLvl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aft_bkg_file_div_cd", getAftBkgFileDivCd());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("file_path", getFilePath());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aft_bkg_rmk_lvl", getAftBkgRmkLvl());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_lvl", getFileLvl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("aft_bkg_file_div_cd", "aftBkgFileDivCd");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("file_path", "filePath");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aft_bkg_rmk_lvl", "aftBkgRmkLvl");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_lvl", "fileLvl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
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
	 * @return aftBkgFileDivCd
	 */
	public String getAftBkgFileDivCd() {
		return this.aftBkgFileDivCd;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return filePath
	 */
	public String getFilePath() {
		return this.filePath;
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
	 * @return aftBkgRmkLvl
	 */
	public String getAftBkgRmkLvl() {
		return this.aftBkgRmkLvl;
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
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
	 * @param aftBkgFileDivCd
	 */
	public void setAftBkgFileDivCd(String aftBkgFileDivCd) {
		this.aftBkgFileDivCd = aftBkgFileDivCd;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	 * @param aftBkgRmkLvl
	 */
	public void setAftBkgRmkLvl(String aftBkgRmkLvl) {
		this.aftBkgRmkLvl = aftBkgRmkLvl;
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
	
	public String getFileLvl() {
		return fileLvl;
	}

	public void setFileLvl(String fileLvl) {
		this.fileLvl = fileLvl;
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
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAftBkgFileDivCd(JSPUtil.getParameter(request, prefix + "aft_bkg_file_div_cd", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setFilePath(JSPUtil.getParameter(request, prefix + "file_path", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAftBkgRmkLvl(JSPUtil.getParameter(request, prefix + "aft_bkg_rmk_lvl", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileLvl(JSPUtil.getParameter(request, prefix + "file_Lvl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingFileListVO[]
	 */
	public AfterBookingFileListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingFileListVO[]
	 */
	public AfterBookingFileListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingFileListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aftBkgFileDivCd = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_file_div_cd", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] filePath = (JSPUtil.getParameter(request, prefix	+ "file_path", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aftBkgRmkLvl = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_rmk_lvl", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileLvl = (JSPUtil.getParameter(request, prefix	+ "file_lvl", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingFileListVO();
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aftBkgFileDivCd[i] != null)
					model.setAftBkgFileDivCd(aftBkgFileDivCd[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (filePath[i] != null)
					model.setFilePath(filePath[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aftBkgRmkLvl[i] != null)
					model.setAftBkgRmkLvl(aftBkgRmkLvl[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileLvl[i] != null)
					model.setFileLvl(fileLvl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingFileListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingFileListVO[]
	 */
	public AfterBookingFileListVO[] getAfterBookingFileListVOs(){
		AfterBookingFileListVO[] vos = (AfterBookingFileListVO[])models.toArray(new AfterBookingFileListVO[models.size()]);
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
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgFileDivCd = this.aftBkgFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePath = this.filePath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgRmkLvl = this.aftBkgRmkLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileLvl = this.fileLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
