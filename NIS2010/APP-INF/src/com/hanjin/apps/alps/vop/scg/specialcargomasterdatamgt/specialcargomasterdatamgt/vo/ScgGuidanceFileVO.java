/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScgGuidanceFileVO.java
*@FileTitle : ScgGuidanceFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.15 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgGuidanceFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgGuidanceFileVO> models = new ArrayList<ScgGuidanceFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String ftrCtnt = null;
	/* Column Info */
	private String iudFlg = null;
	/* Column Info */
	private String spclCgoGuidSeq = null;
	/* Column Info */
	private String hdrCtnt = null;
	/* Column Info */
	private String spclCgoGuidCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String spclCgoGuidAtchFileSeq = null;
	/* Column Info */
	private String fileSetYn = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgGuidanceFileVO() {}

	public ScgGuidanceFileVO(String ibflag, String pagerows, String hdrCtnt, String spclCgoGuidCd, String spclCgoGuidSeq, String spclCgoGuidAtchFileSeq, String fileNm, String fileSavId, String ftrCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String scgFlg, String iudFlg, String fileSetYn) {
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.ftrCtnt = ftrCtnt;
		this.iudFlg = iudFlg;
		this.spclCgoGuidSeq = spclCgoGuidSeq;
		this.hdrCtnt = hdrCtnt;
		this.spclCgoGuidCd = spclCgoGuidCd;
		this.creDt = creDt;
		this.scgFlg = scgFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.spclCgoGuidAtchFileSeq = spclCgoGuidAtchFileSeq;
		this.fileSetYn = fileSetYn;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ftr_ctnt", getFtrCtnt());
		this.hashColumns.put("iud_flg", getIudFlg());
		this.hashColumns.put("spcl_cgo_guid_seq", getSpclCgoGuidSeq());
		this.hashColumns.put("hdr_ctnt", getHdrCtnt());
		this.hashColumns.put("spcl_cgo_guid_cd", getSpclCgoGuidCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spcl_cgo_guid_atch_file_seq", getSpclCgoGuidAtchFileSeq());
		this.hashColumns.put("file_set_yn", getFileSetYn());
		this.hashColumns.put("file_nm", getFileNm());
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
		this.hashFields.put("ftr_ctnt", "ftrCtnt");
		this.hashFields.put("iud_flg", "iudFlg");
		this.hashFields.put("spcl_cgo_guid_seq", "spclCgoGuidSeq");
		this.hashFields.put("hdr_ctnt", "hdrCtnt");
		this.hashFields.put("spcl_cgo_guid_cd", "spclCgoGuidCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spcl_cgo_guid_atch_file_seq", "spclCgoGuidAtchFileSeq");
		this.hashFields.put("file_set_yn", "fileSetYn");
		this.hashFields.put("file_nm", "fileNm");
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
	 * @return ftrCtnt
	 */
	public String getFtrCtnt() {
		return this.ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @return iudFlg
	 */
	public String getIudFlg() {
		return this.iudFlg;
	}
	
	/**
	 * Column Info
	 * @return spclCgoGuidSeq
	 */
	public String getSpclCgoGuidSeq() {
		return this.spclCgoGuidSeq;
	}
	
	/**
	 * Column Info
	 * @return hdrCtnt
	 */
	public String getHdrCtnt() {
		return this.hdrCtnt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoGuidCd
	 */
	public String getSpclCgoGuidCd() {
		return this.spclCgoGuidCd;
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
	 * @return scgFlg
	 */
	public String getScgFlg() {
		return this.scgFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return spclCgoGuidAtchFileSeq
	 */
	public String getSpclCgoGuidAtchFileSeq() {
		return this.spclCgoGuidAtchFileSeq;
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
	 * @param ftrCtnt
	 */
	public void setFtrCtnt(String ftrCtnt) {
		this.ftrCtnt = ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @param iudFlg
	 */
	public void setIudFlg(String iudFlg) {
		this.iudFlg = iudFlg;
	}
	
	/**
	 * Column Info
	 * @param spclCgoGuidSeq
	 */
	public void setSpclCgoGuidSeq(String spclCgoGuidSeq) {
		this.spclCgoGuidSeq = spclCgoGuidSeq;
	}
	
	/**
	 * Column Info
	 * @param hdrCtnt
	 */
	public void setHdrCtnt(String hdrCtnt) {
		this.hdrCtnt = hdrCtnt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoGuidCd
	 */
	public void setSpclCgoGuidCd(String spclCgoGuidCd) {
		this.spclCgoGuidCd = spclCgoGuidCd;
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
	 * @param scgFlg
	 */
	public void setScgFlg(String scgFlg) {
		this.scgFlg = scgFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param spclCgoGuidAtchFileSeq
	 */
	public void setSpclCgoGuidAtchFileSeq(String spclCgoGuidAtchFileSeq) {
		this.spclCgoGuidAtchFileSeq = spclCgoGuidAtchFileSeq;
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
		setFtrCtnt(JSPUtil.getParameter(request, prefix + "ftr_ctnt", ""));
		setIudFlg(JSPUtil.getParameter(request, prefix + "iud_flg", ""));
		setSpclCgoGuidSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_guid_seq", ""));
		setHdrCtnt(JSPUtil.getParameter(request, prefix + "hdr_ctnt", ""));
		setSpclCgoGuidCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_guid_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSpclCgoGuidAtchFileSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_guid_atch_file_seq", ""));
		setFileSetYn(JSPUtil.getParameter(request, prefix + "file_set_yn", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgGuidanceFileVO[]
	 */
	public ScgGuidanceFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgGuidanceFileVO[]
	 */
	public ScgGuidanceFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgGuidanceFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ftrCtnt = (JSPUtil.getParameter(request, prefix	+ "ftr_ctnt", length));
			String[] iudFlg = (JSPUtil.getParameter(request, prefix	+ "iud_flg", length));
			String[] spclCgoGuidSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_guid_seq", length));
			String[] hdrCtnt = (JSPUtil.getParameter(request, prefix	+ "hdr_ctnt", length));
			String[] spclCgoGuidCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_guid_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scgFlg = (JSPUtil.getParameter(request, prefix	+ "scg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] spclCgoGuidAtchFileSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_guid_atch_file_seq", length));
			String[] fileSetYn = (JSPUtil.getParameter(request, prefix	+ "file_set_yn", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgGuidanceFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ftrCtnt[i] != null)
					model.setFtrCtnt(ftrCtnt[i]);
				if (iudFlg[i] != null)
					model.setIudFlg(iudFlg[i]);
				if (spclCgoGuidSeq[i] != null)
					model.setSpclCgoGuidSeq(spclCgoGuidSeq[i]);
				if (hdrCtnt[i] != null)
					model.setHdrCtnt(hdrCtnt[i]);
				if (spclCgoGuidCd[i] != null)
					model.setSpclCgoGuidCd(spclCgoGuidCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scgFlg[i] != null)
					model.setScgFlg(scgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (spclCgoGuidAtchFileSeq[i] != null)
					model.setSpclCgoGuidAtchFileSeq(spclCgoGuidAtchFileSeq[i]);
				if (fileSetYn[i] != null)
					model.setFileSetYn(fileSetYn[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgGuidanceFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgGuidanceFileVO[]
	 */
	public ScgGuidanceFileVO[] getScgGuidanceFileVOs(){
		ScgGuidanceFileVO[] vos = (ScgGuidanceFileVO[])models.toArray(new ScgGuidanceFileVO[models.size()]);
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
		this.ftrCtnt = this.ftrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iudFlg = this.iudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoGuidSeq = this.spclCgoGuidSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCtnt = this.hdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoGuidCd = this.spclCgoGuidCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg = this.scgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoGuidAtchFileSeq = this.spclCgoGuidAtchFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSetYn = this.fileSetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
