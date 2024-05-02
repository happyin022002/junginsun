/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgChemHistoryFileVO.java
*@FileTitle : ScgChemHistoryFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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

public class ScgChemHistoryFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgChemHistoryFileVO> models = new ArrayList<ScgChemHistoryFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chemSeq = null;
	/* Column Info */
	private String atchFileDivCd = null;
	/* Column Info */
	private String atchFileSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileSetYn = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgChemHistoryFileVO() {}

	public ScgChemHistoryFileVO(String ibflag, String pagerows, String chemSeq, String atchFileDivCd, String atchFileSeq, String fileNm, String fileSavId, String creUsrId, String updUsrId, String creDt, String updDt, String fileSetYn) {
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chemSeq = chemSeq;
		this.atchFileDivCd = atchFileDivCd;
		this.atchFileSeq = atchFileSeq;
		this.creDt = creDt;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.fileSetYn = fileSetYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chem_seq", getChemSeq());
		this.hashColumns.put("atch_file_div_cd", getAtchFileDivCd());
		this.hashColumns.put("atch_file_seq", getAtchFileSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_set_yn", getFileSetYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chem_seq", "chemSeq");
		this.hashFields.put("atch_file_div_cd", "atchFileDivCd");
		this.hashFields.put("atch_file_seq", "atchFileSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("file_set_yn", "fileSetYn");
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
	 * @return chemSeq
	 */
	public String getChemSeq() {
		return this.chemSeq;
	}
	
	/**
	 * Column Info
	 * @return fileSetYn
	 */
	public String getFileSetYn() {
		return this.fileSetYn;
	}
	
	/**
	 * Column Info
	 * @return atchFileDivCd
	 */
	public String getAtchFileDivCd() {
		return this.atchFileDivCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileSeq
	 */
	public String getAtchFileSeq() {
		return this.atchFileSeq;
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
	 * @param fileSetYn
	 */
	public void setFileSetYn(String fileSetYn) {
		this.fileSetYn = fileSetYn;
	}
	
	/**
	 * Column Info
	 * @param chemSeq
	 */
	public void setChemSeq(String chemSeq) {
		this.chemSeq = chemSeq;
	}
	
	/**
	 * Column Info
	 * @param atchFileDivCd
	 */
	public void setAtchFileDivCd(String atchFileDivCd) {
		this.atchFileDivCd = atchFileDivCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileSeq
	 */
	public void setAtchFileSeq(String atchFileSeq) {
		this.atchFileSeq = atchFileSeq;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChemSeq(JSPUtil.getParameter(request, prefix + "chem_seq", ""));
		setAtchFileDivCd(JSPUtil.getParameter(request, prefix + "atch_file_div_cd", ""));
		setAtchFileSeq(JSPUtil.getParameter(request, prefix + "atch_file_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileSetYn(JSPUtil.getParameter(request, prefix + "file_set_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgChemHistoryFileVO[]
	 */
	public ScgChemHistoryFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgChemHistoryFileVO[]
	 */
	public ScgChemHistoryFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgChemHistoryFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chemSeq = (JSPUtil.getParameter(request, prefix	+ "chem_seq", length));
			String[] atchFileDivCd = (JSPUtil.getParameter(request, prefix	+ "atch_file_div_cd", length));
			String[] atchFileSeq = (JSPUtil.getParameter(request, prefix	+ "atch_file_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fileSetYn = (JSPUtil.getParameter(request, prefix	+ "file_set_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgChemHistoryFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chemSeq[i] != null)
					model.setChemSeq(chemSeq[i]);
				if (atchFileDivCd[i] != null)
					model.setAtchFileDivCd(atchFileDivCd[i]);
				if (atchFileSeq[i] != null)
					model.setAtchFileSeq(atchFileSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (fileSetYn[i] != null)
					model.setFileSetYn(fileSetYn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgChemHistoryFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgChemHistoryFileVO[]
	 */
	public ScgChemHistoryFileVO[] getScgChemHistoryFileVOs(){
		ScgChemHistoryFileVO[] vos = (ScgChemHistoryFileVO[])models.toArray(new ScgChemHistoryFileVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chemSeq = this.chemSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileDivCd = this.atchFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSeq = this.atchFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSetYn = this.fileSetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
