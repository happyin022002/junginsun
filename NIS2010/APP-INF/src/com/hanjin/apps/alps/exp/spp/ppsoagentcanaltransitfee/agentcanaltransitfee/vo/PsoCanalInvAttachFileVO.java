/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PsoCanalInvAttachFileVO.java
*@FileTitle : PsoCanalInvAttachFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.03.06 Park Yeon-Jin 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Park Yeon-Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsoCanalInvAttachFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsoCanalInvAttachFileVO> models = new ArrayList<PsoCanalInvAttachFileVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileUpldNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileSzCapa = null;
	/* Column Info */
	private String filePathUrl = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsoCanalInvAttachFileVO() {}

	public PsoCanalInvAttachFileVO(String ibflag, String pagerows, String fileSavId, String fileUpldNm, String filePathUrl, String fileSzCapa) {
		this.fileSavId = fileSavId;
		this.fileUpldNm = fileUpldNm;
		this.ibflag = ibflag;
		this.fileSzCapa = fileSzCapa;
		this.filePathUrl = filePathUrl;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_sz_capa", getFileSzCapa());
		this.hashColumns.put("file_path_url", getFilePathUrl());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_sz_capa", "fileSzCapa");
		this.hashFields.put("file_path_url", "filePathUrl");
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
	 * @return fileUpldNm
	 */
	public String getFileUpldNm() {
		return this.fileUpldNm;
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
	 * @return fileSzCapa
	 */
	public String getFileSzCapa() {
		return this.fileSzCapa;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param fileUpldNm
	 */
	public void setFileUpldNm(String fileUpldNm) {
		this.fileUpldNm = fileUpldNm;
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
	 * @param fileSzCapa
	 */
	public void setFileSzCapa(String fileSzCapa) {
		this.fileSzCapa = fileSzCapa;
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
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileSzCapa(JSPUtil.getParameter(request, prefix + "file_sz_capa", ""));
		setFilePathUrl(JSPUtil.getParameter(request, prefix + "file_path_url", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoCanalInvAttachFileVO[]
	 */
	public PsoCanalInvAttachFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoCanalInvAttachFileVO[]
	 */
	public PsoCanalInvAttachFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsoCanalInvAttachFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileSzCapa = (JSPUtil.getParameter(request, prefix	+ "file_sz_capa", length));
			String[] filePathUrl = (JSPUtil.getParameter(request, prefix	+ "file_path_url", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsoCanalInvAttachFileVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileSzCapa[i] != null)
					model.setFileSzCapa(fileSzCapa[i]);
				if (filePathUrl[i] != null)
					model.setFilePathUrl(filePathUrl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsoCanalInvAttachFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsoCanalInvAttachFileVO[]
	 */
	public PsoCanalInvAttachFileVO[] getPsoCanalInvAttachFileVOs(){
		PsoCanalInvAttachFileVO[] vos = (PsoCanalInvAttachFileVO[])models.toArray(new PsoCanalInvAttachFileVO[models.size()]);
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
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSzCapa = this.fileSzCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathUrl = this.filePathUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
