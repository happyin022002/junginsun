/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FtpInfoVO.java
*@FileTitle : FtpInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.19
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.10.19 이도형 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

import java.lang.reflect.Field;
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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FtpInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FtpInfoVO> models = new ArrayList<FtpInfoVO>();
	
	/* Column Info */
	private String fileType = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String ftpPath = null;
	/* Column Info */
	private String endDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ftpAddr = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ldfDlDt = null;
	/* Column Info */
	private String userPw = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String fileDlNm = null;
	/* Column Info */
	private String zipYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FtpInfoVO() {}

	public FtpInfoVO(String ibflag, String pagerows, String ofcCd, String ftpAddr, String userId, String userPw, String fileType, String ftpPath, String zipYn, String fromDt, String endDt, String fileDlNm, String fileSeq, String ldfDlDt) {
		this.fileType = fileType;
		this.fromDt = fromDt;
		this.ftpPath = ftpPath;
		this.endDt = endDt;
		this.pagerows = pagerows;
		this.ftpAddr = ftpAddr;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ldfDlDt = ldfDlDt;
		this.userPw = userPw;
		this.userId = userId;
		this.fileSeq = fileSeq;
		this.fileDlNm = fileDlNm;
		this.zipYn = zipYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_type", getFileType());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("ftp_path", getFtpPath());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ftp_addr", getFtpAddr());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ldf_dl_dt", getLdfDlDt());
		this.hashColumns.put("user_pw", getUserPw());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("file_dl_nm", getFileDlNm());
		this.hashColumns.put("zip_yn", getZipYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_type", "fileType");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("ftp_path", "ftpPath");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ftp_addr", "ftpAddr");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ldf_dl_dt", "ldfDlDt");
		this.hashFields.put("user_pw", "userPw");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("file_dl_nm", "fileDlNm");
		this.hashFields.put("zip_yn", "zipYn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileType
	 */
	public String getFileType() {
		return this.fileType;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return ftpPath
	 */
	public String getFtpPath() {
		return this.ftpPath;
	}
	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
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
	 * @return ftpAddr
	 */
	public String getFtpAddr() {
		return this.ftpAddr;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ldfDlDt
	 */
	public String getLdfDlDt() {
		return this.ldfDlDt;
	}
	
	/**
	 * Column Info
	 * @return userPw
	 */
	public String getUserPw() {
		return this.userPw;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return fileDlNm
	 */
	public String getFileDlNm() {
		return this.fileDlNm;
	}
	
	/**
	 * Column Info
	 * @return zipYn
	 */
	public String getZipYn() {
		return this.zipYn;
	}
	

	/**
	 * Column Info
	 * @param fileType
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param ftpPath
	 */
	public void setFtpPath(String ftpPath) {
		this.ftpPath = ftpPath;
	}
	
	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
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
	 * @param ftpAddr
	 */
	public void setFtpAddr(String ftpAddr) {
		this.ftpAddr = ftpAddr;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ldfDlDt
	 */
	public void setLdfDlDt(String ldfDlDt) {
		this.ldfDlDt = ldfDlDt;
	}
	
	/**
	 * Column Info
	 * @param userPw
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param fileDlNm
	 */
	public void setFileDlNm(String fileDlNm) {
		this.fileDlNm = fileDlNm;
	}
	
	/**
	 * Column Info
	 * @param zipYn
	 */
	public void setZipYn(String zipYn) {
		this.zipYn = zipYn;
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
		setFileType(JSPUtil.getParameter(request, prefix + "file_type", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setFtpPath(JSPUtil.getParameter(request, prefix + "ftp_path", ""));
		setEndDt(JSPUtil.getParameter(request, prefix + "end_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFtpAddr(JSPUtil.getParameter(request, prefix + "ftp_addr", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLdfDlDt(JSPUtil.getParameter(request, prefix + "ldf_dl_dt", ""));
		setUserPw(JSPUtil.getParameter(request, prefix + "user_pw", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setFileDlNm(JSPUtil.getParameter(request, prefix + "file_dl_nm", ""));
		setZipYn(JSPUtil.getParameter(request, prefix + "zip_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FtpInfoVO[]
	 */
	public FtpInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FtpInfoVO[]
	 */
	public FtpInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FtpInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileType = (JSPUtil.getParameter(request, prefix	+ "file_type", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] ftpPath = (JSPUtil.getParameter(request, prefix	+ "ftp_path", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ftpAddr = (JSPUtil.getParameter(request, prefix	+ "ftp_addr", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ldfDlDt = (JSPUtil.getParameter(request, prefix	+ "ldf_dl_dt", length));
			String[] userPw = (JSPUtil.getParameter(request, prefix	+ "user_pw", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] fileDlNm = (JSPUtil.getParameter(request, prefix	+ "file_dl_nm", length));
			String[] zipYn = (JSPUtil.getParameter(request, prefix	+ "zip_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new FtpInfoVO();
				if (fileType[i] != null)
					model.setFileType(fileType[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (ftpPath[i] != null)
					model.setFtpPath(ftpPath[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ftpAddr[i] != null)
					model.setFtpAddr(ftpAddr[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ldfDlDt[i] != null)
					model.setLdfDlDt(ldfDlDt[i]);
				if (userPw[i] != null)
					model.setUserPw(userPw[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fileDlNm[i] != null)
					model.setFileDlNm(fileDlNm[i]);
				if (zipYn[i] != null)
					model.setZipYn(zipYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFtpInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FtpInfoVO[]
	 */
	public FtpInfoVO[] getFtpInfoVOs(){
		FtpInfoVO[] vos = (FtpInfoVO[])models.toArray(new FtpInfoVO[models.size()]);
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
		this.fileType = this.fileType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpPath = this.ftpPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftpAddr = this.ftpAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfDlDt = this.ldfDlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userPw = this.userPw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDlNm = this.fileDlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipYn = this.zipYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
