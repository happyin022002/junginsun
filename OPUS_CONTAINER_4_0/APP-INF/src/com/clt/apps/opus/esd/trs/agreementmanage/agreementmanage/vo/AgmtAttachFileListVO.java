/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgmtAttachFileListVO.java
*@FileTitle : AgmtAttachFileListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.06
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2015.10.06 박찬우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박찬우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgmtAttachFileListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgmtAttachFileListVO> models = new ArrayList<AgmtAttachFileListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String imgSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileSize = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String filePathRmk = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AgmtAttachFileListVO() {}

	public AgmtAttachFileListVO(String ibflag, String pagerows, String agmtNo, String imgSeq, String fileNm, String fileSize, String filePathRmk, String fileSavId, String rgstOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.imgSeq = imgSeq;
		this.agmtNo = agmtNo;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.fileSize = fileSize;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rgstOfcCd = rgstOfcCd;
		this.filePathRmk = filePathRmk;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("img_seq", getImgSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("file_path_rmk", getFilePathRmk());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("img_seq", "imgSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("file_path_rmk", "filePathRmk");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return imgSeq
	 */
	public String getImgSeq() {
		return this.imgSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
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
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return filePathRmk
	 */
	public String getFilePathRmk() {
		return this.filePathRmk;
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
	 * @param imgSeq
	 */
	public void setImgSeq(String imgSeq) {
		this.imgSeq = imgSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param filePathRmk
	 */
	public void setFilePathRmk(String filePathRmk) {
		this.filePathRmk = filePathRmk;
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
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setImgSeq(JSPUtil.getParameter(request, prefix + "img_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, prefix + "rgst_ofc_cd", ""));
		setFilePathRmk(JSPUtil.getParameter(request, prefix + "file_path_rmk", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgmtAttachFileListVO[]
	 */
	public AgmtAttachFileListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgmtAttachFileListVO[]
	 */
	public AgmtAttachFileListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgmtAttachFileListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] imgSeq = (JSPUtil.getParameter(request, prefix	+ "img_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] filePathRmk = (JSPUtil.getParameter(request, prefix	+ "file_path_rmk", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgmtAttachFileListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (imgSeq[i] != null)
					model.setImgSeq(imgSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (filePathRmk[i] != null)
					model.setFilePathRmk(filePathRmk[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgmtAttachFileListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgmtAttachFileListVO[]
	 */
	public AgmtAttachFileListVO[] getAgmtAttachFileListVOs(){
		AgmtAttachFileListVO[] vos = (AgmtAttachFileListVO[])models.toArray(new AgmtAttachFileListVO[models.size()]);
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
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgSeq = this.imgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathRmk = this.filePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
