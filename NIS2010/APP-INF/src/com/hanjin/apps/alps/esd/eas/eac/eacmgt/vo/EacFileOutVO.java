/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacFileOutVO.java
*@FileTitle : EacFileOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.12
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.12 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */


public class EacFileOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EacFileOutVO> models = new ArrayList<EacFileOutVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String eacFileSeq = null;
	/* Column Info */
	private String eacCmplCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String eacNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String filePathDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EacFileOutVO() {}

	public EacFileOutVO(String ibflag, String pagerows, String eacCmplCd, String fileNm, String fileSize, String rgstDt, String eacNo, String eacFileSeq, String fileSavId, String filePathDesc, String creUsrId, String rgstOfcCd, String updUsrId) {
		this.fileSavId = fileSavId;
		this.eacFileSeq = eacFileSeq;
		this.eacCmplCd = eacCmplCd;
		this.pagerows = pagerows;
		this.fileSize = fileSize;
		this.eacNo = eacNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rgstOfcCd = rgstOfcCd;
		this.fileNm = fileNm;
		this.rgstDt = rgstDt;
		this.updUsrId = updUsrId;
		this.filePathDesc = filePathDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("eac_file_seq", getEacFileSeq());
		this.hashColumns.put("eac_cmpl_cd", getEacCmplCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("file_path_desc", getFilePathDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("eac_file_seq", "eacFileSeq");
		this.hashFields.put("eac_cmpl_cd", "eacCmplCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("file_path_desc", "filePathDesc");
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
	 * @return eacFileSeq
	 */
	public String getEacFileSeq() {
		return this.eacFileSeq;
	}
	
	/**
	 * Column Info
	 * @return eacCmplCd
	 */
	public String getEacCmplCd() {
		return this.eacCmplCd;
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
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
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
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
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
	 * @return filePathDesc
	 */
	public String getFilePathDesc() {
		return this.filePathDesc;
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
	 * @param eacFileSeq
	 */
	public void setEacFileSeq(String eacFileSeq) {
		this.eacFileSeq = eacFileSeq;
	}
	
	/**
	 * Column Info
	 * @param eacCmplCd
	 */
	public void setEacCmplCd(String eacCmplCd) {
		this.eacCmplCd = eacCmplCd;
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
	 * Column Info
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
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
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
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
	 * @param filePathDesc
	 */
	public void setFilePathDesc(String filePathDesc) {
		this.filePathDesc = filePathDesc;
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
		setEacFileSeq(JSPUtil.getParameter(request, prefix + "eac_file_seq", ""));
		setEacCmplCd(JSPUtil.getParameter(request, prefix + "eac_cmpl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, prefix + "rgst_ofc_cd", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFilePathDesc(JSPUtil.getParameter(request, prefix + "file_path_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EacFileOutVO[]
	 */
	public EacFileOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EacFileOutVO[]
	 */
	public EacFileOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EacFileOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] eacFileSeq = (JSPUtil.getParameter(request, prefix	+ "eac_file_seq", length));
			String[] eacCmplCd = (JSPUtil.getParameter(request, prefix	+ "eac_cmpl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] filePathDesc = (JSPUtil.getParameter(request, prefix	+ "file_path_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new EacFileOutVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (eacFileSeq[i] != null)
					model.setEacFileSeq(eacFileSeq[i]);
				if (eacCmplCd[i] != null)
					model.setEacCmplCd(eacCmplCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (filePathDesc[i] != null)
					model.setFilePathDesc(filePathDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEacFileOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EacFileOutVO[]
	 */
	public EacFileOutVO[] getEacFileOutVOs(){
		EacFileOutVO[] vos = (EacFileOutVO[])models.toArray(new EacFileOutVO[models.size()]);
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
		this.eacFileSeq = this.eacFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCmplCd = this.eacCmplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathDesc = this.filePathDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

