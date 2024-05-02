/*=========================================================
*Copyright(c) 2014 CyberLogitec 
*@FileName : SearchUncollectedCargoFileVO.java
*@FileTitle : SearchUncollectedCargoFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.14
*@LastModifier : DO-HYUN KIM 
*@LastVersion : 1.0
* 2014.07.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo;

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

public class SearchUncollectedCargoFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUncollectedCargoFileVO> models = new ArrayList<SearchUncollectedCargoFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileNoSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sUcCsNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ucCgoFileId = null;
	/* Column Info */
	private String fileCnt = null;
	/* Column Info */
	private String ucCsNo = null;
	/* Column Info */
	private String imgFileNo = null;
	/* Column Info */
	private String sUcCgoFileId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchUncollectedCargoFileVO() {}

	public SearchUncollectedCargoFileVO(String ibflag, String pagerows, String ucCsNo, String ucCgoFileId, String fileNoSeq, String fileDesc, String ofcCd, String updUsrId, String imgFileNo, String updDt, String fileCnt, String fileSavId, String sUcCsNo, String sUcCgoFileId, String creUsrId) {
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.fileDesc = fileDesc;
		this.pagerows = pagerows;
		this.fileNoSeq = fileNoSeq;
		this.ofcCd = ofcCd;
		this.sUcCsNo = sUcCsNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ucCgoFileId = ucCgoFileId;
		this.fileCnt = fileCnt;
		this.ucCsNo = ucCsNo;
		this.imgFileNo = imgFileNo;
		this.sUcCgoFileId = sUcCgoFileId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_no_seq", getFileNoSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_uc_cs_no", getSUcCsNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uc_cgo_file_id", getUcCgoFileId());
		this.hashColumns.put("file_cnt", getFileCnt());
		this.hashColumns.put("uc_cs_no", getUcCsNo());
		this.hashColumns.put("img_file_no", getImgFileNo());
		this.hashColumns.put("s_uc_cgo_file_id", getSUcCgoFileId());
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
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_no_seq", "fileNoSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_uc_cs_no", "sUcCsNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uc_cgo_file_id", "ucCgoFileId");
		this.hashFields.put("file_cnt", "fileCnt");
		this.hashFields.put("uc_cs_no", "ucCsNo");
		this.hashFields.put("img_file_no", "imgFileNo");
		this.hashFields.put("s_uc_cgo_file_id", "sUcCgoFileId");
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
	 * @return fileDesc
	 */
	public String getFileDesc() {
		return this.fileDesc;
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
	 * @return fileNoSeq
	 */
	public String getFileNoSeq() {
		return this.fileNoSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sUcCsNo
	 */
	public String getSUcCsNo() {
		return this.sUcCsNo;
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
	 * @return ucCgoFileId
	 */
	public String getUcCgoFileId() {
		return this.ucCgoFileId;
	}
	
	/**
	 * Column Info
	 * @return fileCnt
	 */
	public String getFileCnt() {
		return this.fileCnt;
	}
	
	/**
	 * Column Info
	 * @return ucCsNo
	 */
	public String getUcCsNo() {
		return this.ucCsNo;
	}
	
	/**
	 * Column Info
	 * @return imgFileNo
	 */
	public String getImgFileNo() {
		return this.imgFileNo;
	}
	
	/**
	 * Column Info
	 * @return sUcCgoFileId
	 */
	public String getSUcCgoFileId() {
		return this.sUcCgoFileId;
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
	 * @param fileDesc
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	 * @param fileNoSeq
	 */
	public void setFileNoSeq(String fileNoSeq) {
		this.fileNoSeq = fileNoSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sUcCsNo
	 */
	public void setSUcCsNo(String sUcCsNo) {
		this.sUcCsNo = sUcCsNo;
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
	 * @param ucCgoFileId
	 */
	public void setUcCgoFileId(String ucCgoFileId) {
		this.ucCgoFileId = ucCgoFileId;
	}
	
	/**
	 * Column Info
	 * @param fileCnt
	 */
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}
	
	/**
	 * Column Info
	 * @param ucCsNo
	 */
	public void setUcCsNo(String ucCsNo) {
		this.ucCsNo = ucCsNo;
	}
	
	/**
	 * Column Info
	 * @param imgFileNo
	 */
	public void setImgFileNo(String imgFileNo) {
		this.imgFileNo = imgFileNo;
	}
	
	/**
	 * Column Info
	 * @param sUcCgoFileId
	 */
	public void setSUcCgoFileId(String sUcCgoFileId) {
		this.sUcCgoFileId = sUcCgoFileId;
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
		setFileDesc(JSPUtil.getParameter(request, prefix + "file_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileNoSeq(JSPUtil.getParameter(request, prefix + "file_no_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSUcCsNo(JSPUtil.getParameter(request, prefix + "s_uc_cs_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUcCgoFileId(JSPUtil.getParameter(request, prefix + "uc_cgo_file_id", ""));
		setFileCnt(JSPUtil.getParameter(request, prefix + "file_cnt", ""));
		setUcCsNo(JSPUtil.getParameter(request, prefix + "uc_cs_no", ""));
		setImgFileNo(JSPUtil.getParameter(request, prefix + "img_file_no", ""));
		setSUcCgoFileId(JSPUtil.getParameter(request, prefix + "s_uc_cgo_file_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUncollectedCargoFileVO[]
	 */
	public SearchUncollectedCargoFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUncollectedCargoFileVO[]
	 */
	public SearchUncollectedCargoFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUncollectedCargoFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileNoSeq = (JSPUtil.getParameter(request, prefix	+ "file_no_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sUcCsNo = (JSPUtil.getParameter(request, prefix	+ "s_uc_cs_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ucCgoFileId = (JSPUtil.getParameter(request, prefix	+ "uc_cgo_file_id", length));
			String[] fileCnt = (JSPUtil.getParameter(request, prefix	+ "file_cnt", length));
			String[] ucCsNo = (JSPUtil.getParameter(request, prefix	+ "uc_cs_no", length));
			String[] imgFileNo = (JSPUtil.getParameter(request, prefix	+ "img_file_no", length));
			String[] sUcCgoFileId = (JSPUtil.getParameter(request, prefix	+ "s_uc_cgo_file_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUncollectedCargoFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileNoSeq[i] != null)
					model.setFileNoSeq(fileNoSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sUcCsNo[i] != null)
					model.setSUcCsNo(sUcCsNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ucCgoFileId[i] != null)
					model.setUcCgoFileId(ucCgoFileId[i]);
				if (fileCnt[i] != null)
					model.setFileCnt(fileCnt[i]);
				if (ucCsNo[i] != null)
					model.setUcCsNo(ucCsNo[i]);
				if (imgFileNo[i] != null)
					model.setImgFileNo(imgFileNo[i]);
				if (sUcCgoFileId[i] != null)
					model.setSUcCgoFileId(sUcCgoFileId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUncollectedCargoFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUncollectedCargoFileVO[]
	 */
	public SearchUncollectedCargoFileVO[] getSearchUncollectedCargoFileVOs(){
		SearchUncollectedCargoFileVO[] vos = (SearchUncollectedCargoFileVO[])models.toArray(new SearchUncollectedCargoFileVO[models.size()]);
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
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNoSeq = this.fileNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUcCsNo = this.sUcCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCgoFileId = this.ucCgoFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCnt = this.fileCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCsNo = this.ucCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNo = this.imgFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUcCgoFileId = this.sUcCgoFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
