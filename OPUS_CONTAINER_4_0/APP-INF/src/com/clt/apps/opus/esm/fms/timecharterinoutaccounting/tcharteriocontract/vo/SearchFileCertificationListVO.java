/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFileCertificationListVO.java
*@FileTitle : SearchFileCertificationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFileCertificationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFileCertificationListVO> models = new ArrayList<SearchFileCertificationListVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileDownload = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileDesc = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String fletFileTpCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String fileNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFileCertificationListVO() {}

	public SearchFileCertificationListVO(String ibflag, String pagerows, String fileSeq, String fletFileTpCd, String fileNm, String fileDesc, String fileDownload, String fileSavId, String effDt, String expDt) {
		this.fileSavId = fileSavId;
		this.fileDownload = fileDownload;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.fileDesc = fileDesc;
		this.fileSeq = fileSeq;
		this.fletFileTpCd = fletFileTpCd;
		this.expDt = expDt;
		this.fileNm = fileNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_download", getFileDownload());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("flet_file_tp_cd", getFletFileTpCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("file_download", "fileDownload");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("flet_file_tp_cd", "fletFileTpCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return fileDownload
	 */
	public String getFileDownload() {
		return this.fileDownload;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return fileDesc
	 */
	public String getFileDesc() {
		return this.fileDesc;
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
	 * @return fletFileTpCd
	 */
	public String getFletFileTpCd() {
		return this.fletFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param fileDesc
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	 * @param fletFileTpCd
	 */
	public void setFletFileTpCd(String fletFileTpCd) {
		this.fletFileTpCd = fletFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
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
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setFileDownload(JSPUtil.getParameter(request, "file_download", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFileDesc(JSPUtil.getParameter(request, "file_desc", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setFletFileTpCd(JSPUtil.getParameter(request, "flet_file_tp_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFileCertificationListVO[]
	 */
	public SearchFileCertificationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFileCertificationListVO[]
	 */
	public SearchFileCertificationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFileCertificationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] fletFileTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_file_tp_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFileCertificationListVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fletFileTpCd[i] != null)
					model.setFletFileTpCd(fletFileTpCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFileCertificationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFileCertificationListVO[]
	 */
	public SearchFileCertificationListVO[] getSearchFileCertificationListVOs(){
		SearchFileCertificationListVO[] vos = (SearchFileCertificationListVO[])models.toArray(new SearchFileCertificationListVO[models.size()]);
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
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletFileTpCd = this.fletFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
