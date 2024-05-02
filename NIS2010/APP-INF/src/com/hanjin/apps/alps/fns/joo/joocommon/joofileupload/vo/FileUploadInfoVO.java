/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : FileUploadInfoVO.java
*@FileTitle : FileUploadInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.vo;

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

public class FileUploadInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FileUploadInfoVO> models = new ArrayList<FileUploadInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String colVal7 = null;
	/* Column Info */
	private String colVal5 = null;
	/* Column Info */
	private String colVal6 = null;
	/* Column Info */
	private String colVal3 = null;
	/* Column Info */
	private String pageRows = null;
	/* Column Info */
	private String colVal4 = null;
	/* Column Info */
	private String colNm7 = null;
	/* Column Info */
	private String colVal1 = null;
	/* Column Info */
	private String colVal2 = null;
	/* Column Info */
	private String colNm5 = null;
	/* Column Info */
	private String colNm6 = null;
	/* Column Info */
	private String ibFlag = null;
	/* Column Info */
	private String colNm3 = null;
	/* Column Info */
	private String colNm4 = null;
	/* Column Info */
	private String colNm1 = null;
	/* Column Info */
	private String colNm2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileDownload = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tblNm = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fileSaveId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FileUploadInfoVO() {}

	public FileUploadInfoVO(String ibflag, String pagerows, String tblNm, String colNm1, String colNm2, String colNm3, String colNm4, String colNm5, String colNm6, String colNm7, String colVal1, String colVal2, String colVal3, String colVal4, String colVal5, String colVal6, String colVal7, String ibFlag, String fileDownload, String fileSaveId, String fileNm, String updDt, String updUsrId, String pageRows) {
		this.updDt = updDt;
		this.colVal7 = colVal7;
		this.colVal5 = colVal5;
		this.colVal6 = colVal6;
		this.colVal3 = colVal3;
		this.pageRows = pageRows;
		this.colVal4 = colVal4;
		this.colNm7 = colNm7;
		this.colVal1 = colVal1;
		this.colVal2 = colVal2;
		this.colNm5 = colNm5;
		this.colNm6 = colNm6;
		this.ibFlag = ibFlag;
		this.colNm3 = colNm3;
		this.colNm4 = colNm4;
		this.colNm1 = colNm1;
		this.colNm2 = colNm2;
		this.pagerows = pagerows;
		this.fileDownload = fileDownload;
		this.ibflag = ibflag;
		this.tblNm = tblNm;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.fileSaveId = fileSaveId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("col_val7", getColVal7());
		this.hashColumns.put("col_val5", getColVal5());
		this.hashColumns.put("col_val6", getColVal6());
		this.hashColumns.put("col_val3", getColVal3());
		this.hashColumns.put("page_rows", getPageRows());
		this.hashColumns.put("col_val4", getColVal4());
		this.hashColumns.put("col_nm7", getColNm7());
		this.hashColumns.put("col_val1", getColVal1());
		this.hashColumns.put("col_val2", getColVal2());
		this.hashColumns.put("col_nm5", getColNm5());
		this.hashColumns.put("col_nm6", getColNm6());
		this.hashColumns.put("ib_flag", getIbFlag());
		this.hashColumns.put("col_nm3", getColNm3());
		this.hashColumns.put("col_nm4", getColNm4());
		this.hashColumns.put("col_nm1", getColNm1());
		this.hashColumns.put("col_nm2", getColNm2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_download", getFileDownload());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tbl_nm", getTblNm());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("file_save_id", getFileSaveId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("col_val7", "colVal7");
		this.hashFields.put("col_val5", "colVal5");
		this.hashFields.put("col_val6", "colVal6");
		this.hashFields.put("col_val3", "colVal3");
		this.hashFields.put("page_rows", "pageRows");
		this.hashFields.put("col_val4", "colVal4");
		this.hashFields.put("col_nm7", "colNm7");
		this.hashFields.put("col_val1", "colVal1");
		this.hashFields.put("col_val2", "colVal2");
		this.hashFields.put("col_nm5", "colNm5");
		this.hashFields.put("col_nm6", "colNm6");
		this.hashFields.put("ib_flag", "ibFlag");
		this.hashFields.put("col_nm3", "colNm3");
		this.hashFields.put("col_nm4", "colNm4");
		this.hashFields.put("col_nm1", "colNm1");
		this.hashFields.put("col_nm2", "colNm2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_download", "fileDownload");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tbl_nm", "tblNm");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("file_save_id", "fileSaveId");
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
	 * @return colVal7
	 */
	public String getColVal7() {
		return this.colVal7;
	}
	
	/**
	 * Column Info
	 * @return colVal5
	 */
	public String getColVal5() {
		return this.colVal5;
	}
	
	/**
	 * Column Info
	 * @return colVal6
	 */
	public String getColVal6() {
		return this.colVal6;
	}
	
	/**
	 * Column Info
	 * @return colVal3
	 */
	public String getColVal3() {
		return this.colVal3;
	}
	
	/**
	 * Column Info
	 * @return pageRows
	 */
	public String getPageRows() {
		return this.pageRows;
	}
	
	/**
	 * Column Info
	 * @return colVal4
	 */
	public String getColVal4() {
		return this.colVal4;
	}
	
	/**
	 * Column Info
	 * @return colNm7
	 */
	public String getColNm7() {
		return this.colNm7;
	}
	
	/**
	 * Column Info
	 * @return colVal1
	 */
	public String getColVal1() {
		return this.colVal1;
	}
	
	/**
	 * Column Info
	 * @return colVal2
	 */
	public String getColVal2() {
		return this.colVal2;
	}
	
	/**
	 * Column Info
	 * @return colNm5
	 */
	public String getColNm5() {
		return this.colNm5;
	}
	
	/**
	 * Column Info
	 * @return colNm6
	 */
	public String getColNm6() {
		return this.colNm6;
	}
	
	/**
	 * Column Info
	 * @return ibFlag
	 */
	public String getIbFlag() {
		return this.ibFlag;
	}
	
	/**
	 * Column Info
	 * @return colNm3
	 */
	public String getColNm3() {
		return this.colNm3;
	}
	
	/**
	 * Column Info
	 * @return colNm4
	 */
	public String getColNm4() {
		return this.colNm4;
	}
	
	/**
	 * Column Info
	 * @return colNm1
	 */
	public String getColNm1() {
		return this.colNm1;
	}
	
	/**
	 * Column Info
	 * @return colNm2
	 */
	public String getColNm2() {
		return this.colNm2;
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
	 * @return fileDownload
	 */
	public String getFileDownload() {
		return this.fileDownload;
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
	 * @return tblNm
	 */
	public String getTblNm() {
		return this.tblNm;
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
	 * @return fileSaveId
	 */
	public String getFileSaveId() {
		return this.fileSaveId;
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
	 * @param colVal7
	 */
	public void setColVal7(String colVal7) {
		this.colVal7 = colVal7;
	}
	
	/**
	 * Column Info
	 * @param colVal5
	 */
	public void setColVal5(String colVal5) {
		this.colVal5 = colVal5;
	}
	
	/**
	 * Column Info
	 * @param colVal6
	 */
	public void setColVal6(String colVal6) {
		this.colVal6 = colVal6;
	}
	
	/**
	 * Column Info
	 * @param colVal3
	 */
	public void setColVal3(String colVal3) {
		this.colVal3 = colVal3;
	}
	
	/**
	 * Column Info
	 * @param pageRows
	 */
	public void setPageRows(String pageRows) {
		this.pageRows = pageRows;
	}
	
	/**
	 * Column Info
	 * @param colVal4
	 */
	public void setColVal4(String colVal4) {
		this.colVal4 = colVal4;
	}
	
	/**
	 * Column Info
	 * @param colNm7
	 */
	public void setColNm7(String colNm7) {
		this.colNm7 = colNm7;
	}
	
	/**
	 * Column Info
	 * @param colVal1
	 */
	public void setColVal1(String colVal1) {
		this.colVal1 = colVal1;
	}
	
	/**
	 * Column Info
	 * @param colVal2
	 */
	public void setColVal2(String colVal2) {
		this.colVal2 = colVal2;
	}
	
	/**
	 * Column Info
	 * @param colNm5
	 */
	public void setColNm5(String colNm5) {
		this.colNm5 = colNm5;
	}
	
	/**
	 * Column Info
	 * @param colNm6
	 */
	public void setColNm6(String colNm6) {
		this.colNm6 = colNm6;
	}
	
	/**
	 * Column Info
	 * @param ibFlag
	 */
	public void setIbFlag(String ibFlag) {
		this.ibFlag = ibFlag;
	}
	
	/**
	 * Column Info
	 * @param colNm3
	 */
	public void setColNm3(String colNm3) {
		this.colNm3 = colNm3;
	}
	
	/**
	 * Column Info
	 * @param colNm4
	 */
	public void setColNm4(String colNm4) {
		this.colNm4 = colNm4;
	}
	
	/**
	 * Column Info
	 * @param colNm1
	 */
	public void setColNm1(String colNm1) {
		this.colNm1 = colNm1;
	}
	
	/**
	 * Column Info
	 * @param colNm2
	 */
	public void setColNm2(String colNm2) {
		this.colNm2 = colNm2;
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
	 * @param fileDownload
	 */
	public void setFileDownload(String fileDownload) {
		this.fileDownload = fileDownload;
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
	 * @param tblNm
	 */
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
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
	 * Column Info
	 * @param fileSaveId
	 */
	public void setFileSaveId(String fileSaveId) {
		this.fileSaveId = fileSaveId;
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
		setColVal7(JSPUtil.getParameter(request, prefix + "col_val7", ""));
		setColVal5(JSPUtil.getParameter(request, prefix + "col_val5", ""));
		setColVal6(JSPUtil.getParameter(request, prefix + "col_val6", ""));
		setColVal3(JSPUtil.getParameter(request, prefix + "col_val3", ""));
		setPageRows(JSPUtil.getParameter(request, prefix + "page_rows", ""));
		setColVal4(JSPUtil.getParameter(request, prefix + "col_val4", ""));
		setColNm7(JSPUtil.getParameter(request, prefix + "col_nm7", ""));
		setColVal1(JSPUtil.getParameter(request, prefix + "col_val1", ""));
		setColVal2(JSPUtil.getParameter(request, prefix + "col_val2", ""));
		setColNm5(JSPUtil.getParameter(request, prefix + "col_nm5", ""));
		setColNm6(JSPUtil.getParameter(request, prefix + "col_nm6", ""));
		setIbFlag(JSPUtil.getParameter(request, prefix + "ib_flag", ""));
		setColNm3(JSPUtil.getParameter(request, prefix + "col_nm3", ""));
		setColNm4(JSPUtil.getParameter(request, prefix + "col_nm4", ""));
		setColNm1(JSPUtil.getParameter(request, prefix + "col_nm1", ""));
		setColNm2(JSPUtil.getParameter(request, prefix + "col_nm2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileDownload(JSPUtil.getParameter(request, prefix + "file_download", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTblNm(JSPUtil.getParameter(request, prefix + "tbl_nm", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFileSaveId(JSPUtil.getParameter(request, prefix + "file_save_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FileUploadInfoVO[]
	 */
	public FileUploadInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FileUploadInfoVO[]
	 */
	public FileUploadInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FileUploadInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] colVal7 = (JSPUtil.getParameter(request, prefix	+ "col_val7", length));
			String[] colVal5 = (JSPUtil.getParameter(request, prefix	+ "col_val5", length));
			String[] colVal6 = (JSPUtil.getParameter(request, prefix	+ "col_val6", length));
			String[] colVal3 = (JSPUtil.getParameter(request, prefix	+ "col_val3", length));
			String[] pageRows = (JSPUtil.getParameter(request, prefix	+ "page_rows", length));
			String[] colVal4 = (JSPUtil.getParameter(request, prefix	+ "col_val4", length));
			String[] colNm7 = (JSPUtil.getParameter(request, prefix	+ "col_nm7", length));
			String[] colVal1 = (JSPUtil.getParameter(request, prefix	+ "col_val1", length));
			String[] colVal2 = (JSPUtil.getParameter(request, prefix	+ "col_val2", length));
			String[] colNm5 = (JSPUtil.getParameter(request, prefix	+ "col_nm5", length));
			String[] colNm6 = (JSPUtil.getParameter(request, prefix	+ "col_nm6", length));
			String[] ibFlag = (JSPUtil.getParameter(request, prefix	+ "ib_flag", length));
			String[] colNm3 = (JSPUtil.getParameter(request, prefix	+ "col_nm3", length));
			String[] colNm4 = (JSPUtil.getParameter(request, prefix	+ "col_nm4", length));
			String[] colNm1 = (JSPUtil.getParameter(request, prefix	+ "col_nm1", length));
			String[] colNm2 = (JSPUtil.getParameter(request, prefix	+ "col_nm2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tblNm = (JSPUtil.getParameter(request, prefix	+ "tbl_nm", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fileSaveId = (JSPUtil.getParameter(request, prefix	+ "file_save_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FileUploadInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (colVal7[i] != null)
					model.setColVal7(colVal7[i]);
				if (colVal5[i] != null)
					model.setColVal5(colVal5[i]);
				if (colVal6[i] != null)
					model.setColVal6(colVal6[i]);
				if (colVal3[i] != null)
					model.setColVal3(colVal3[i]);
				if (pageRows[i] != null)
					model.setPageRows(pageRows[i]);
				if (colVal4[i] != null)
					model.setColVal4(colVal4[i]);
				if (colNm7[i] != null)
					model.setColNm7(colNm7[i]);
				if (colVal1[i] != null)
					model.setColVal1(colVal1[i]);
				if (colVal2[i] != null)
					model.setColVal2(colVal2[i]);
				if (colNm5[i] != null)
					model.setColNm5(colNm5[i]);
				if (colNm6[i] != null)
					model.setColNm6(colNm6[i]);
				if (ibFlag[i] != null)
					model.setIbFlag(ibFlag[i]);
				if (colNm3[i] != null)
					model.setColNm3(colNm3[i]);
				if (colNm4[i] != null)
					model.setColNm4(colNm4[i]);
				if (colNm1[i] != null)
					model.setColNm1(colNm1[i]);
				if (colNm2[i] != null)
					model.setColNm2(colNm2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tblNm[i] != null)
					model.setTblNm(tblNm[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fileSaveId[i] != null)
					model.setFileSaveId(fileSaveId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFileUploadInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FileUploadInfoVO[]
	 */
	public FileUploadInfoVO[] getFileUploadInfoVOs(){
		FileUploadInfoVO[] vos = (FileUploadInfoVO[])models.toArray(new FileUploadInfoVO[models.size()]);
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
		this.colVal7 = this.colVal7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal5 = this.colVal5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal6 = this.colVal6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal3 = this.colVal3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageRows = this.pageRows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal4 = this.colVal4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm7 = this.colNm7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal1 = this.colVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colVal2 = this.colVal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm5 = this.colNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm6 = this.colNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFlag = this.ibFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm3 = this.colNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm4 = this.colNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm1 = this.colNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm2 = this.colNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm = this.tblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSaveId = this.fileSaveId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
