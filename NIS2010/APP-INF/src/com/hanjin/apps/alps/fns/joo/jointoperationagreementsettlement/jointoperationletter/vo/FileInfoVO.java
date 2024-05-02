/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileInfoVO.java
*@FileTitle : FileInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.23 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FileInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FileInfoVO> models = new ArrayList<FileInfoVO>();
	
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String joLtrSeq = null;
	/* Column Info */
	private String fileName = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlFilePathUrlCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FileInfoVO() {}

	public FileInfoVO(String ibflag, String pagerows, String joLtrSeq, String fileSavId, String creDt, String creUsrId, String usrNm, String fileName, String emlFilePathUrlCtnt) {
		this.fileSavId = fileSavId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.joLtrSeq = joLtrSeq;
		this.fileName = fileName;
		this.creDt = creDt;
		this.emlFilePathUrlCtnt = emlFilePathUrlCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("jo_ltr_seq", getJoLtrSeq());
		this.hashColumns.put("file_name", getFileName());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_file_path_url_ctnt", getEmlFilePathUrlCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("jo_ltr_seq", "joLtrSeq");
		this.hashFields.put("file_name", "fileName");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_file_path_url_ctnt", "emlFilePathUrlCtnt");
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return joLtrSeq
	 */
	public String getJoLtrSeq() {
		return this.joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @return fileName
	 */
	public String getFileName() {
		return this.fileName;
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
	 * @return emlFilePathUrlCtnt
	 */
	public String getEmlFilePathUrlCtnt() {
		return this.emlFilePathUrlCtnt;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param joLtrSeq
	 */
	public void setJoLtrSeq(String joLtrSeq) {
		this.joLtrSeq = joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	 * @param emlFilePathUrlCtnt
	 */
	public void setEmlFilePathUrlCtnt(String emlFilePathUrlCtnt) {
		this.emlFilePathUrlCtnt = emlFilePathUrlCtnt;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setJoLtrSeq(JSPUtil.getParameter(request, "jo_ltr_seq", ""));
		setFileName(JSPUtil.getParameter(request, "file_name", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEmlFilePathUrlCtnt(JSPUtil.getParameter(request, "eml_file_path_url_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FileInfoVO[]
	 */
	public FileInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FileInfoVO[]
	 */
	public FileInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FileInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] joLtrSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_seq", length));
			String[] fileName = (JSPUtil.getParameter(request, prefix	+ "file_name", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlFilePathUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_file_path_url_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new FileInfoVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (joLtrSeq[i] != null)
					model.setJoLtrSeq(joLtrSeq[i]);
				if (fileName[i] != null)
					model.setFileName(fileName[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlFilePathUrlCtnt[i] != null)
					model.setEmlFilePathUrlCtnt(emlFilePathUrlCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFileInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FileInfoVO[]
	 */
	public FileInfoVO[] getFileInfoVOs(){
		FileInfoVO[] vos = (FileInfoVO[])models.toArray(new FileInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrSeq = this.joLtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileName = this.fileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFilePathUrlCtnt = this.emlFilePathUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
