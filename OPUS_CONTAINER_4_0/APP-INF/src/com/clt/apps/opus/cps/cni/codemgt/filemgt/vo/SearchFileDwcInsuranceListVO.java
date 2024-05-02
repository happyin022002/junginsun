/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFileDwcInsuranceListVO.java
*@FileTitle : SearchFileDwcInsuranceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.21 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.filemgt.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFileDwcInsuranceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFileDwcInsuranceListVO> models = new ArrayList<SearchFileDwcInsuranceListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String clmFileSeq = null;
	/* Column Info */
	private String fileDownload = null;
	/* Column Info */
	private String fileSavId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clmBztpCd = null;
	/* Column Info */
	private String fileDesc = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String clmFileTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dwClmNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFileDwcInsuranceListVO() {}

	public SearchFileDwcInsuranceListVO(String ibflag, String pagerows, String clmFileSeq, String clmFileTpCd, String clmBztpCd, String fileSavId, String fileNm, String fileDesc, String dwClmNo, String fileDownload, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.clmFileSeq = clmFileSeq;
		this.fileDownload = fileDownload;
		this.fileSavId = fileSavId;
		this.ibflag = ibflag;
		this.clmBztpCd = clmBztpCd;
		this.fileDesc = fileDesc;
		this.fileNm = fileNm;
		this.clmFileTpCd = clmFileTpCd;
		this.updUsrId = updUsrId;
		this.dwClmNo = dwClmNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("clm_file_seq", getClmFileSeq());
		this.hashColumns.put("file_download", getFileDownload());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clm_bztp_cd", getClmBztpCd());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("clm_file_tp_cd", getClmFileTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("clm_file_seq", "clmFileSeq");
		this.hashFields.put("file_download", "fileDownload");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clm_bztp_cd", "clmBztpCd");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("clm_file_tp_cd", "clmFileTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dw_clm_no", "dwClmNo");
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
	 * @return clmFileSeq
	 */
	public String getClmFileSeq() {
		return this.clmFileSeq;
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
	 * @return clmBztpCd
	 */
	public String getClmBztpCd() {
		return this.clmBztpCd;
	}
	
	/**
	 * Column Info
	 * @return fileDesc
	 */
	public String getFileDesc() {
		return this.fileDesc;
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
	 * @return clmFileTpCd
	 */
	public String getClmFileTpCd() {
		return this.clmFileTpCd;
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
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
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
	 * @param clmFileSeq
	 */
	public void setClmFileSeq(String clmFileSeq) {
		this.clmFileSeq = clmFileSeq;
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
	 * @param clmBztpCd
	 */
	public void setClmBztpCd(String clmBztpCd) {
		this.clmBztpCd = clmBztpCd;
	}
	
	/**
	 * Column Info
	 * @param fileDesc
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	 * @param clmFileTpCd
	 */
	public void setClmFileTpCd(String clmFileTpCd) {
		this.clmFileTpCd = clmFileTpCd;
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
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setClmFileSeq(JSPUtil.getParameter(request, "clm_file_seq", ""));
		setFileDownload(JSPUtil.getParameter(request, "file_download", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClmBztpCd(JSPUtil.getParameter(request, "clm_bztp_cd", ""));
		setFileDesc(JSPUtil.getParameter(request, "file_desc", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setClmFileTpCd(JSPUtil.getParameter(request, "clm_file_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDwClmNo(JSPUtil.getParameter(request, "dw_clm_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFileDwcInsuranceListVO[]
	 */
	public SearchFileDwcInsuranceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFileDwcInsuranceListVO[]
	 */
	public SearchFileDwcInsuranceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFileDwcInsuranceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] clmFileSeq = (JSPUtil.getParameter(request, prefix	+ "clm_file_seq", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clmBztpCd = (JSPUtil.getParameter(request, prefix	+ "clm_bztp_cd", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] clmFileTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_file_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFileDwcInsuranceListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (clmFileSeq[i] != null)
					model.setClmFileSeq(clmFileSeq[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clmBztpCd[i] != null)
					model.setClmBztpCd(clmBztpCd[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (clmFileTpCd[i] != null)
					model.setClmFileTpCd(clmFileTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFileDwcInsuranceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFileDwcInsuranceListVO[]
	 */
	public SearchFileDwcInsuranceListVO[] getSearchFileDwcInsuranceListVOs(){
		SearchFileDwcInsuranceListVO[] vos = (SearchFileDwcInsuranceListVO[])models.toArray(new SearchFileDwcInsuranceListVO[models.size()]);
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
		this.clmFileSeq = this.clmFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmBztpCd = this.clmBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmFileTpCd = this.clmFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
