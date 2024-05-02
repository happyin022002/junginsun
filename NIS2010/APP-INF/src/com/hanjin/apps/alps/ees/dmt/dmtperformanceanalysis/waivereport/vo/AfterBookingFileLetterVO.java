/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AfterBookingFileLetterVO.java
*@FileTitle : AfterBookingFileLetterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo;

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

public class AfterBookingFileLetterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingFileLetterVO> models = new ArrayList<AfterBookingFileLetterVO>();
	
	/* Column Info */
	private String aftBkgFileDivCd = null;
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String fileSavId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gnteLtrNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String filePath = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingFileLetterVO() {}

	public AfterBookingFileLetterVO(String ibflag, String pagerows, String custCd, String custNm, String darNo, String aproDt, String gnteLtrNm, String fileNm, String fileSize, String filePath, String aftBkgFileDivCd, String fileSavId) {
		this.aftBkgFileDivCd = aftBkgFileDivCd;
		this.fileSize = fileSize;
		this.fileSavId = fileSavId;
		this.ibflag = ibflag;
		this.gnteLtrNm = gnteLtrNm;
		this.custNm = custNm;
		this.filePath = filePath;
		this.darNo = darNo;
		this.custCd = custCd;
		this.fileNm = fileNm;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aft_bkg_file_div_cd", getAftBkgFileDivCd());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gnte_ltr_nm", getGnteLtrNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("file_path", getFilePath());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aft_bkg_file_div_cd", "aftBkgFileDivCd");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gnte_ltr_nm", "gnteLtrNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("file_path", "filePath");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
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
	 * @return gnteLtrNm
	 */
	public String getGnteLtrNm() {
		return this.gnteLtrNm;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @param aftBkgFileDivCd
	 */
	public void setAftBkgFileDivCd(String aftBkgFileDivCd) {
		this.aftBkgFileDivCd = aftBkgFileDivCd;
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
	 * @param gnteLtrNm
	 */
	public void setGnteLtrNm(String gnteLtrNm) {
		this.gnteLtrNm = gnteLtrNm;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
		setAftBkgFileDivCd(JSPUtil.getParameter(request, prefix + "aft_bkg_file_div_cd", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGnteLtrNm(JSPUtil.getParameter(request, prefix + "gnte_ltr_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setFilePath(JSPUtil.getParameter(request, prefix + "file_path", ""));
		setDarNo(JSPUtil.getParameter(request, prefix + "dar_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingFileLetterVO[]
	 */
	public AfterBookingFileLetterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingFileLetterVO[]
	 */
	public AfterBookingFileLetterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingFileLetterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aftBkgFileDivCd = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_file_div_cd", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gnteLtrNm = (JSPUtil.getParameter(request, prefix	+ "gnte_ltr_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] filePath = (JSPUtil.getParameter(request, prefix	+ "file_path", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingFileLetterVO();
				if (aftBkgFileDivCd[i] != null)
					model.setAftBkgFileDivCd(aftBkgFileDivCd[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gnteLtrNm[i] != null)
					model.setGnteLtrNm(gnteLtrNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (filePath[i] != null)
					model.setFilePath(filePath[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingFileLetterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingFileLetterVO[]
	 */
	public AfterBookingFileLetterVO[] getAfterBookingFileLetterVOs(){
		AfterBookingFileLetterVO[] vos = (AfterBookingFileLetterVO[])models.toArray(new AfterBookingFileLetterVO[models.size()]);
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
		this.aftBkgFileDivCd = this.aftBkgFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteLtrNm = this.gnteLtrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePath = this.filePath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
