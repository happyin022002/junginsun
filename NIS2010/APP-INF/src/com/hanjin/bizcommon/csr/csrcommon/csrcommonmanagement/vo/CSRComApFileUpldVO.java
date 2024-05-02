/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRComApFileUpldVO.java
*@FileTitle : CSRComApFileUpldVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo;

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

public class CSRComApFileUpldVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CSRComApFileUpldVO> models = new ArrayList<CSRComApFileUpldVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String errRmk = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String csrFileUpldTpCd = null;
	/* Column Info */
	private String atchFileId = null;
	/* Column Info */
	private String apFileDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileRmk = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subSysId = null;
	/* Column Info */
	private String deltUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CSRComApFileUpldVO() {}

	public CSRComApFileUpldVO(String ibflag, String pagerows, String atchFileId, String apFileDivCd, String csrNo, String subSysId, String invVndrSeq, String invNo, String csrFileUpldTpCd, String fileSavId, String fileNm, String fileRmk, String errRmk, String deltFlg, String deltUsrId, String deltDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.errRmk = errRmk;
		this.csrNo = csrNo;
		this.fileSavId = fileSavId;
		this.invVndrSeq = invVndrSeq;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.deltDt = deltDt;
		this.csrFileUpldTpCd = csrFileUpldTpCd;
		this.atchFileId = atchFileId;
		this.apFileDivCd = apFileDivCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fileRmk = fileRmk;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.subSysId = subSysId;
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("err_rmk", getErrRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("csr_file_upld_tp_cd", getCsrFileUpldTpCd());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("ap_file_div_cd", getApFileDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_rmk", getFileRmk());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_sys_id", getSubSysId());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("err_rmk", "errRmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("csr_file_upld_tp_cd", "csrFileUpldTpCd");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("ap_file_div_cd", "apFileDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_rmk", "fileRmk");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_sys_id", "subSysId");
		this.hashFields.put("delt_usr_id", "deltUsrId");
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
	 * @return errRmk
	 */
	public String getErrRmk() {
		return this.errRmk;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return csrFileUpldTpCd
	 */
	public String getCsrFileUpldTpCd() {
		return this.csrFileUpldTpCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileId
	 */
	public String getAtchFileId() {
		return this.atchFileId;
	}
	
	/**
	 * Column Info
	 * @return apFileDivCd
	 */
	public String getApFileDivCd() {
		return this.apFileDivCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return fileRmk
	 */
	public String getFileRmk() {
		return this.fileRmk;
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
	 * @return subSysId
	 */
	public String getSubSysId() {
		return this.subSysId;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
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
	 * @param errRmk
	 */
	public void setErrRmk(String errRmk) {
		this.errRmk = errRmk;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param csrFileUpldTpCd
	 */
	public void setCsrFileUpldTpCd(String csrFileUpldTpCd) {
		this.csrFileUpldTpCd = csrFileUpldTpCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileId
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	/**
	 * Column Info
	 * @param apFileDivCd
	 */
	public void setApFileDivCd(String apFileDivCd) {
		this.apFileDivCd = apFileDivCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param fileRmk
	 */
	public void setFileRmk(String fileRmk) {
		this.fileRmk = fileRmk;
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
	 * @param subSysId
	 */
	public void setSubSysId(String subSysId) {
		this.subSysId = subSysId;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
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
		setErrRmk(JSPUtil.getParameter(request, prefix + "err_rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setCsrFileUpldTpCd(JSPUtil.getParameter(request, prefix + "csr_file_upld_tp_cd", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setApFileDivCd(JSPUtil.getParameter(request, prefix + "ap_file_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileRmk(JSPUtil.getParameter(request, prefix + "file_rmk", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubSysId(JSPUtil.getParameter(request, prefix + "sub_sys_id", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRComApFileUpldVO[]
	 */
	public CSRComApFileUpldVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSRComApFileUpldVO[]
	 */
	public CSRComApFileUpldVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRComApFileUpldVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] errRmk = (JSPUtil.getParameter(request, prefix	+ "err_rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] csrFileUpldTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_file_upld_tp_cd", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] apFileDivCd = (JSPUtil.getParameter(request, prefix	+ "ap_file_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileRmk = (JSPUtil.getParameter(request, prefix	+ "file_rmk", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subSysId = (JSPUtil.getParameter(request, prefix	+ "sub_sys_id", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CSRComApFileUpldVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (errRmk[i] != null)
					model.setErrRmk(errRmk[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (csrFileUpldTpCd[i] != null)
					model.setCsrFileUpldTpCd(csrFileUpldTpCd[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (apFileDivCd[i] != null)
					model.setApFileDivCd(apFileDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileRmk[i] != null)
					model.setFileRmk(fileRmk[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subSysId[i] != null)
					model.setSubSysId(subSysId[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRComApFileUpldVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRComApFileUpldVO[]
	 */
	public CSRComApFileUpldVO[] getCSRComApFileUpldVOs(){
		CSRComApFileUpldVO[] vos = (CSRComApFileUpldVO[])models.toArray(new CSRComApFileUpldVO[models.size()]);
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
		this.errRmk = this.errRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrFileUpldTpCd = this.csrFileUpldTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apFileDivCd = this.apFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileRmk = this.fileRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysId = this.subSysId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
