/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgPsaEdoRcvLogVO.java
*@FileTitle : BkgPsaEdoRcvLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgPsaEdoRcvLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgPsaEdoRcvLogVO> models = new ArrayList<BkgPsaEdoRcvLogVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvGdt = null;
	/* Column Info */
	private String doVslNm = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String psaDoRcvStsCd = null;
	/* Column Info */
	private String psaAuthNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String doVslCd = null;
	/* Column Info */
	private String errLogCtnt = null;
	/* Column Info */
	private String doSkdVoyNo = null;
	/* Column Info */
	private String doSkdDirCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgPsaEdoRcvLogVO() {}

	public BkgPsaEdoRcvLogVO(String ibflag, String pagerows, String blNo, String cntrNo, String rcvSeq, String doVslNm, String doVslCd, String doSkdVoyNo, String doSkdDirCd, String psaDoRcvStsCd, String psaAuthNo, String errLogCtnt, String rcvDt, String rcvGdt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.rcvGdt = rcvGdt;
		this.doVslNm = doVslNm;
		this.rcvSeq = rcvSeq;
		this.psaDoRcvStsCd = psaDoRcvStsCd;
		this.psaAuthNo = psaAuthNo;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.blNo = blNo;
		this.doVslCd = doVslCd;
		this.errLogCtnt = errLogCtnt;
		this.doSkdVoyNo = doSkdVoyNo;
		this.doSkdDirCd = doSkdDirCd;
		this.cntrNo = cntrNo;
		this.rcvDt = rcvDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcv_gdt", getRcvGdt());
		this.hashColumns.put("do_vsl_nm", getDoVslNm());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("psa_do_rcv_sts_cd", getPsaDoRcvStsCd());
		this.hashColumns.put("psa_auth_no", getPsaAuthNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("do_vsl_cd", getDoVslCd());
		this.hashColumns.put("err_log_ctnt", getErrLogCtnt());
		this.hashColumns.put("do_skd_voy_no", getDoSkdVoyNo());
		this.hashColumns.put("do_skd_dir_cd", getDoSkdDirCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_gdt", "rcvGdt");
		this.hashFields.put("do_vsl_nm", "doVslNm");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("psa_do_rcv_sts_cd", "psaDoRcvStsCd");
		this.hashFields.put("psa_auth_no", "psaAuthNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("do_vsl_cd", "doVslCd");
		this.hashFields.put("err_log_ctnt", "errLogCtnt");
		this.hashFields.put("do_skd_voy_no", "doSkdVoyNo");
		this.hashFields.put("do_skd_dir_cd", "doSkdDirCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rcv_dt", "rcvDt");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return rcvGdt
	 */
	public String getRcvGdt() {
		return this.rcvGdt;
	}
	
	/**
	 * Column Info
	 * @return doVslNm
	 */
	public String getDoVslNm() {
		return this.doVslNm;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return psaDoRcvStsCd
	 */
	public String getPsaDoRcvStsCd() {
		return this.psaDoRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @return psaAuthNo
	 */
	public String getPsaAuthNo() {
		return this.psaAuthNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return doVslCd
	 */
	public String getDoVslCd() {
		return this.doVslCd;
	}
	
	/**
	 * Column Info
	 * @return errLogCtnt
	 */
	public String getErrLogCtnt() {
		return this.errLogCtnt;
	}
	
	/**
	 * Column Info
	 * @return doSkdVoyNo
	 */
	public String getDoSkdVoyNo() {
		return this.doSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return doSkdDirCd
	 */
	public String getDoSkdDirCd() {
		return this.doSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param rcvGdt
	 */
	public void setRcvGdt(String rcvGdt) {
		this.rcvGdt = rcvGdt;
	}
	
	/**
	 * Column Info
	 * @param doVslNm
	 */
	public void setDoVslNm(String doVslNm) {
		this.doVslNm = doVslNm;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param psaDoRcvStsCd
	 */
	public void setPsaDoRcvStsCd(String psaDoRcvStsCd) {
		this.psaDoRcvStsCd = psaDoRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @param psaAuthNo
	 */
	public void setPsaAuthNo(String psaAuthNo) {
		this.psaAuthNo = psaAuthNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param doVslCd
	 */
	public void setDoVslCd(String doVslCd) {
		this.doVslCd = doVslCd;
	}
	
	/**
	 * Column Info
	 * @param errLogCtnt
	 */
	public void setErrLogCtnt(String errLogCtnt) {
		this.errLogCtnt = errLogCtnt;
	}
	
	/**
	 * Column Info
	 * @param doSkdVoyNo
	 */
	public void setDoSkdVoyNo(String doSkdVoyNo) {
		this.doSkdVoyNo = doSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param doSkdDirCd
	 */
	public void setDoSkdDirCd(String doSkdDirCd) {
		this.doSkdDirCd = doSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRcvGdt(JSPUtil.getParameter(request, prefix + "rcv_gdt", ""));
		setDoVslNm(JSPUtil.getParameter(request, prefix + "do_vsl_nm", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setPsaDoRcvStsCd(JSPUtil.getParameter(request, prefix + "psa_do_rcv_sts_cd", ""));
		setPsaAuthNo(JSPUtil.getParameter(request, prefix + "psa_auth_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDoVslCd(JSPUtil.getParameter(request, prefix + "do_vsl_cd", ""));
		setErrLogCtnt(JSPUtil.getParameter(request, prefix + "err_log_ctnt", ""));
		setDoSkdVoyNo(JSPUtil.getParameter(request, prefix + "do_skd_voy_no", ""));
		setDoSkdDirCd(JSPUtil.getParameter(request, prefix + "do_skd_dir_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgPsaEdoRcvLogVO[]
	 */
	public BkgPsaEdoRcvLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgPsaEdoRcvLogVO[]
	 */
	public BkgPsaEdoRcvLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgPsaEdoRcvLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvGdt = (JSPUtil.getParameter(request, prefix	+ "rcv_gdt", length));
			String[] doVslNm = (JSPUtil.getParameter(request, prefix	+ "do_vsl_nm", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] psaDoRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "psa_do_rcv_sts_cd", length));
			String[] psaAuthNo = (JSPUtil.getParameter(request, prefix	+ "psa_auth_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] doVslCd = (JSPUtil.getParameter(request, prefix	+ "do_vsl_cd", length));
			String[] errLogCtnt = (JSPUtil.getParameter(request, prefix	+ "err_log_ctnt", length));
			String[] doSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "do_skd_voy_no", length));
			String[] doSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "do_skd_dir_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgPsaEdoRcvLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvGdt[i] != null)
					model.setRcvGdt(rcvGdt[i]);
				if (doVslNm[i] != null)
					model.setDoVslNm(doVslNm[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (psaDoRcvStsCd[i] != null)
					model.setPsaDoRcvStsCd(psaDoRcvStsCd[i]);
				if (psaAuthNo[i] != null)
					model.setPsaAuthNo(psaAuthNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (doVslCd[i] != null)
					model.setDoVslCd(doVslCd[i]);
				if (errLogCtnt[i] != null)
					model.setErrLogCtnt(errLogCtnt[i]);
				if (doSkdVoyNo[i] != null)
					model.setDoSkdVoyNo(doSkdVoyNo[i]);
				if (doSkdDirCd[i] != null)
					model.setDoSkdDirCd(doSkdDirCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgPsaEdoRcvLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgPsaEdoRcvLogVO[]
	 */
	public BkgPsaEdoRcvLogVO[] getBkgPsaEdoRcvLogVOs(){
		BkgPsaEdoRcvLogVO[] vos = (BkgPsaEdoRcvLogVO[])models.toArray(new BkgPsaEdoRcvLogVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvGdt = this.rcvGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doVslNm = this.doVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaDoRcvStsCd = this.psaDoRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaAuthNo = this.psaAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doVslCd = this.doVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLogCtnt = this.errLogCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSkdVoyNo = this.doSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSkdDirCd = this.doSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
