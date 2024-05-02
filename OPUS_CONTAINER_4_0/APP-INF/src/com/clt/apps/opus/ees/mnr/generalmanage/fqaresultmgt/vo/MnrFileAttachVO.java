/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchFileVO.java
*@FileTitle : searchFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.29 성덕경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 성덕경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrFileAttachVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrFileAttachVO> models = new ArrayList<MnrFileAttachVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileDownload = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgFileNm = null;
	/* Column Info */
	private String filePathNm = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String fileDtlSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrFileAttachVO() {}
	/**
	 * Table Column name 으로 맴버변수 선언한다.
	 * @return HashMap
	 */
	public MnrFileAttachVO(String ibflag, String pagerows, String orgFileNm, String filePathNm, String creUsrId, String creDt, String updUsrId, String updDt, String fileDownload, String fileSeq, String fileDtlSeq, String mnrGrpTpCd) {
		this.updDt = updDt;
		this.fileDownload = fileDownload;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.orgFileNm = orgFileNm;		
		this.filePathNm = filePathNm;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.creDt = creDt;
		this.fileSeq = fileSeq;
		this.fileDtlSeq = fileDtlSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_download", getFileDownload());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_file_nm", getOrgFileNm());
		this.hashColumns.put("file_path_nm", getFilePathNm());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("file_dtl_seq", getFileDtlSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_download", "fileDownload");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_file_nm", "orgFileNm");
		this.hashFields.put("file_path_nm", "filePathNm");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("file_dtl_seq", "fileDtlSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return fileDownload
	 */
	public String getFileDownload() {
		return this.fileDownload;
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
	 * @return orgFileNm
	 */
	public String getOrgFileNm() {
		return this.orgFileNm;
	}
	
	/**
	 * Column Info
	 * @return filePathNm
	 */
	public String getFilePathNm() {
		return this.filePathNm;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
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
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return fileDtlSeq
	 */
	public String getFileDtlSeq() {
		return this.fileDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param fileDownload
	 */
	public void setFileDownload(String fileDownload) {
		this.fileDownload = fileDownload;
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
	 * @param orgFileNm
	 */
	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}
	
	/**
	 * Column Info
	 * @param filePathNm
	 */
	public void setFilePathNm(String filePathNm) {
		this.filePathNm = filePathNm;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
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
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param fileDtlSeq
	 */
	public void setFileDtlSeq(String fileDtlSeq) {
		this.fileDtlSeq = fileDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setFileDownload(JSPUtil.getParameter(request, "file_download", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgFileNm(JSPUtil.getParameter(request, "org_file_nm", ""));
		setFilePathNm(JSPUtil.getParameter(request, "file_path_nm", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setFileDtlSeq(JSPUtil.getParameter(request, "file_dtl_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchFileVO[]
	 */
	public MnrFileAttachVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchFileVO[]
	 */
	public MnrFileAttachVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrFileAttachVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] fileDownload = (JSPUtil.getParameter(request, prefix	+ "file_download".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] orgFileNm = (JSPUtil.getParameter(request, prefix	+ "org_file_nm".trim(), length));
			String[] filePathNm = (JSPUtil.getParameter(request, prefix	+ "file_path_nm".trim(), length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq".trim(), length));
			String[] fileDtlSeq = (JSPUtil.getParameter(request, prefix	+ "file_dtl_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrFileAttachVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileDownload[i] != null)
					model.setFileDownload(fileDownload[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgFileNm[i] != null)
					model.setOrgFileNm(orgFileNm[i]);
				if (filePathNm[i] != null)
					model.setFilePathNm(filePathNm[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fileDtlSeq[i] != null)
					model.setFileDtlSeq(fileDtlSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrFileAttachVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrFileAttachVO[]
	 */
	public MnrFileAttachVO[] getMnrFileAttachVOs(){
		MnrFileAttachVO[] vos = (MnrFileAttachVO[])models.toArray(new MnrFileAttachVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDownload = this.fileDownload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFileNm = this.orgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathNm = this.filePathNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDtlSeq = this.fileDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
