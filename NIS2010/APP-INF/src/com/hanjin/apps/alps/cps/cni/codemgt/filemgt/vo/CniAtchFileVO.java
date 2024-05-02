/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniAtchFileVO.java
*@FileTitle : CniAtchFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.11 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniAtchFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniAtchFileVO> models = new ArrayList<CniAtchFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String clmFileSeq = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String insurTpCd = null;
	/* Column Info */
	private String fileDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String instInsurTpCd = null;
	/* Column Info */
	private String clmFileTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoClmRefNo = null;
	/* Column Info */
	private String clmBztpCd = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String clmFileDpSeq = null;
	/* Column Info */
	private String instInsurPlcyYr = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String instPrmInsurTpCd = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniAtchFileVO() {}

	public CniAtchFileVO(String ibflag, String pagerows, String clmFileSeq, String clmFileTpCd, String clmBztpCd, String fileSavId, String fileNm, String fileDesc, String dwClmNo, String insurTpCd, String insurPlcyYr, String instInsurTpCd, String instInsurPlcyYr, String instPrmInsurTpCd, String cgoClmRefNo, String clmFileDpSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.clmFileSeq = clmFileSeq;
		this.fileSavId = fileSavId;
		this.insurTpCd = insurTpCd;
		this.fileDesc = fileDesc;
		this.creDt = creDt;
		this.instInsurTpCd = instInsurTpCd;
		this.clmFileTpCd = clmFileTpCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cgoClmRefNo = cgoClmRefNo;
		this.clmBztpCd = clmBztpCd;
		this.insurPlcyYr = insurPlcyYr;
		this.clmFileDpSeq = clmFileDpSeq;
		this.instInsurPlcyYr = instInsurPlcyYr;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.instPrmInsurTpCd = instPrmInsurTpCd;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("clm_file_seq", getClmFileSeq());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("insur_tp_cd", getInsurTpCd());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inst_insur_tp_cd", getInstInsurTpCd());
		this.hashColumns.put("clm_file_tp_cd", getClmFileTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_clm_ref_no", getCgoClmRefNo());
		this.hashColumns.put("clm_bztp_cd", getClmBztpCd());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("clm_file_dp_seq", getClmFileDpSeq());
		this.hashColumns.put("inst_insur_plcy_yr", getInstInsurPlcyYr());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inst_prm_insur_tp_cd", getInstPrmInsurTpCd());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("clm_file_seq", "clmFileSeq");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("insur_tp_cd", "insurTpCd");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inst_insur_tp_cd", "instInsurTpCd");
		this.hashFields.put("clm_file_tp_cd", "clmFileTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_clm_ref_no", "cgoClmRefNo");
		this.hashFields.put("clm_bztp_cd", "clmBztpCd");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("clm_file_dp_seq", "clmFileDpSeq");
		this.hashFields.put("inst_insur_plcy_yr", "instInsurPlcyYr");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inst_prm_insur_tp_cd", "instPrmInsurTpCd");
		this.hashFields.put("dw_clm_no", "dwClmNo");
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
	 * @return clmFileSeq
	 */
	public String getClmFileSeq() {
		return this.clmFileSeq;
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
	 * @return insurTpCd
	 */
	public String getInsurTpCd() {
		return this.insurTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return instInsurTpCd
	 */
	public String getInstInsurTpCd() {
		return this.instInsurTpCd;
	}
	
	/**
	 * Column Info
	 * @return clmFileTpCd
	 */
	public String getClmFileTpCd() {
		return this.clmFileTpCd;
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
	 * @return cgoClmRefNo
	 */
	public String getCgoClmRefNo() {
		return this.cgoClmRefNo;
	}
	
	/**
	 * Column Info
	 * @return clmBztpCd
	 */
	public String getClmBztpCd() {
		return this.clmBztpCd;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return clmFileDpSeq
	 */
	public String getClmFileDpSeq() {
		return this.clmFileDpSeq;
	}
	
	/**
	 * Column Info
	 * @return instInsurPlcyYr
	 */
	public String getInstInsurPlcyYr() {
		return this.instInsurPlcyYr;
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
	 * @return instPrmInsurTpCd
	 */
	public String getInstPrmInsurTpCd() {
		return this.instPrmInsurTpCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
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
	 * @param clmFileSeq
	 */
	public void setClmFileSeq(String clmFileSeq) {
		this.clmFileSeq = clmFileSeq;
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
	 * @param insurTpCd
	 */
	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param instInsurTpCd
	 */
	public void setInstInsurTpCd(String instInsurTpCd) {
		this.instInsurTpCd = instInsurTpCd;
	}
	
	/**
	 * Column Info
	 * @param clmFileTpCd
	 */
	public void setClmFileTpCd(String clmFileTpCd) {
		this.clmFileTpCd = clmFileTpCd;
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
	 * @param cgoClmRefNo
	 */
	public void setCgoClmRefNo(String cgoClmRefNo) {
		this.cgoClmRefNo = cgoClmRefNo;
	}
	
	/**
	 * Column Info
	 * @param clmBztpCd
	 */
	public void setClmBztpCd(String clmBztpCd) {
		this.clmBztpCd = clmBztpCd;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param clmFileDpSeq
	 */
	public void setClmFileDpSeq(String clmFileDpSeq) {
		this.clmFileDpSeq = clmFileDpSeq;
	}
	
	/**
	 * Column Info
	 * @param instInsurPlcyYr
	 */
	public void setInstInsurPlcyYr(String instInsurPlcyYr) {
		this.instInsurPlcyYr = instInsurPlcyYr;
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
	 * @param instPrmInsurTpCd
	 */
	public void setInstPrmInsurTpCd(String instPrmInsurTpCd) {
		this.instPrmInsurTpCd = instPrmInsurTpCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setClmFileSeq(JSPUtil.getParameter(request, "clm_file_seq", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setInsurTpCd(JSPUtil.getParameter(request, "insur_tp_cd", ""));
		setFileDesc(JSPUtil.getParameter(request, "file_desc", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInstInsurTpCd(JSPUtil.getParameter(request, "inst_insur_tp_cd", ""));
		setClmFileTpCd(JSPUtil.getParameter(request, "clm_file_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCgoClmRefNo(JSPUtil.getParameter(request, "cgo_clm_ref_no", ""));
		setClmBztpCd(JSPUtil.getParameter(request, "clm_bztp_cd", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setClmFileDpSeq(JSPUtil.getParameter(request, "clm_file_dp_seq", ""));
		setInstInsurPlcyYr(JSPUtil.getParameter(request, "inst_insur_plcy_yr", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInstPrmInsurTpCd(JSPUtil.getParameter(request, "inst_prm_insur_tp_cd", ""));
		setDwClmNo(JSPUtil.getParameter(request, "dw_clm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniAtchFileVO[]
	 */
	public CniAtchFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniAtchFileVO[]
	 */
	public CniAtchFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniAtchFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] clmFileSeq = (JSPUtil.getParameter(request, prefix	+ "clm_file_seq", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] insurTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_tp_cd", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] instInsurTpCd = (JSPUtil.getParameter(request, prefix	+ "inst_insur_tp_cd", length));
			String[] clmFileTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_file_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoClmRefNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_no", length));
			String[] clmBztpCd = (JSPUtil.getParameter(request, prefix	+ "clm_bztp_cd", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] clmFileDpSeq = (JSPUtil.getParameter(request, prefix	+ "clm_file_dp_seq", length));
			String[] instInsurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "inst_insur_plcy_yr", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] instPrmInsurTpCd = (JSPUtil.getParameter(request, prefix	+ "inst_prm_insur_tp_cd", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniAtchFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (clmFileSeq[i] != null)
					model.setClmFileSeq(clmFileSeq[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (insurTpCd[i] != null)
					model.setInsurTpCd(insurTpCd[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (instInsurTpCd[i] != null)
					model.setInstInsurTpCd(instInsurTpCd[i]);
				if (clmFileTpCd[i] != null)
					model.setClmFileTpCd(clmFileTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoClmRefNo[i] != null)
					model.setCgoClmRefNo(cgoClmRefNo[i]);
				if (clmBztpCd[i] != null)
					model.setClmBztpCd(clmBztpCd[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (clmFileDpSeq[i] != null)
					model.setClmFileDpSeq(clmFileDpSeq[i]);
				if (instInsurPlcyYr[i] != null)
					model.setInstInsurPlcyYr(instInsurPlcyYr[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (instPrmInsurTpCd[i] != null)
					model.setInstPrmInsurTpCd(instPrmInsurTpCd[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniAtchFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniAtchFileVO[]
	 */
	public CniAtchFileVO[] getCniAtchFileVOs(){
		CniAtchFileVO[] vos = (CniAtchFileVO[])models.toArray(new CniAtchFileVO[models.size()]);
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
		this.clmFileSeq = this.clmFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurTpCd = this.insurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instInsurTpCd = this.instInsurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmFileTpCd = this.clmFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefNo = this.cgoClmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmBztpCd = this.clmBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmFileDpSeq = this.clmFileDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instInsurPlcyYr = this.instInsurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instPrmInsurTpCd = this.instPrmInsurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
