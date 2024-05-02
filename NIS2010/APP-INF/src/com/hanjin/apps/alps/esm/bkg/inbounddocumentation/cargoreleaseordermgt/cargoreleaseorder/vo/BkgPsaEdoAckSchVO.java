/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgPsaEdoAckSchVO.java
*@FileTitle : BkgPsaEdoAckSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class BkgPsaEdoAckSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgPsaEdoAckSchVO> models = new ArrayList<BkgPsaEdoAckSchVO>();
	
	/* Column Info */
	private String doVslNm = null;
	/* Column Info */
	private String psaDoRcvStsCd = null;
	/* Column Info */
	private String psaAuthNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String doVslCd = null;
	/* Column Info */
	private String errLogCtnt = null;
	/* Column Info */
	private String doSkdVoyNo = null;
	/* Column Info */
	private String doSkdDirCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String psaDoRcvStsNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgPsaEdoAckSchVO() {}

	public BkgPsaEdoAckSchVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String doVslNm, String doVslCd, String doSkdVoyNo, String doSkdDirCd, String psaDoRcvStsCd, String psaDoRcvStsNm, String psaAuthNo, String errLogCtnt, String rcvDt) {
		this.doVslNm = doVslNm;
		this.psaDoRcvStsCd = psaDoRcvStsCd;
		this.psaAuthNo = psaAuthNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.doVslCd = doVslCd;
		this.errLogCtnt = errLogCtnt;
		this.doSkdVoyNo = doSkdVoyNo;
		this.doSkdDirCd = doSkdDirCd;
		this.rcvDt = rcvDt;
		this.cntrNo = cntrNo;
		this.psaDoRcvStsNm = psaDoRcvStsNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_vsl_nm", getDoVslNm());
		this.hashColumns.put("psa_do_rcv_sts_cd", getPsaDoRcvStsCd());
		this.hashColumns.put("psa_auth_no", getPsaAuthNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("do_vsl_cd", getDoVslCd());
		this.hashColumns.put("err_log_ctnt", getErrLogCtnt());
		this.hashColumns.put("do_skd_voy_no", getDoSkdVoyNo());
		this.hashColumns.put("do_skd_dir_cd", getDoSkdDirCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("psa_do_rcv_sts_nm", getPsaDoRcvStsNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_vsl_nm", "doVslNm");
		this.hashFields.put("psa_do_rcv_sts_cd", "psaDoRcvStsCd");
		this.hashFields.put("psa_auth_no", "psaAuthNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("do_vsl_cd", "doVslCd");
		this.hashFields.put("err_log_ctnt", "errLogCtnt");
		this.hashFields.put("do_skd_voy_no", "doSkdVoyNo");
		this.hashFields.put("do_skd_dir_cd", "doSkdDirCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("psa_do_rcv_sts_nm", "psaDoRcvStsNm");
		return this.hashFields;
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
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @return psaDoRcvStsNm
	 */
	public String getPsaDoRcvStsNm() {
		return this.psaDoRcvStsNm;
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
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
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
	 * @param psaDoRcvStsNm
	 */
	public void setPsaDoRcvStsNm(String psaDoRcvStsNm) {
		this.psaDoRcvStsNm = psaDoRcvStsNm;
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
		setDoVslNm(JSPUtil.getParameter(request, prefix + "do_vsl_nm", ""));
		setPsaDoRcvStsCd(JSPUtil.getParameter(request, prefix + "psa_do_rcv_sts_cd", ""));
		setPsaAuthNo(JSPUtil.getParameter(request, prefix + "psa_auth_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDoVslCd(JSPUtil.getParameter(request, prefix + "do_vsl_cd", ""));
		setErrLogCtnt(JSPUtil.getParameter(request, prefix + "err_log_ctnt", ""));
		setDoSkdVoyNo(JSPUtil.getParameter(request, prefix + "do_skd_voy_no", ""));
		setDoSkdDirCd(JSPUtil.getParameter(request, prefix + "do_skd_dir_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPsaDoRcvStsNm(JSPUtil.getParameter(request, prefix + "psa_do_rcv_sts_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgPsaEdoAckSchVO[]
	 */
	public BkgPsaEdoAckSchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgPsaEdoAckSchVO[]
	 */
	public BkgPsaEdoAckSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgPsaEdoAckSchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doVslNm = (JSPUtil.getParameter(request, prefix	+ "do_vsl_nm", length));
			String[] psaDoRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "psa_do_rcv_sts_cd", length));
			String[] psaAuthNo = (JSPUtil.getParameter(request, prefix	+ "psa_auth_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] doVslCd = (JSPUtil.getParameter(request, prefix	+ "do_vsl_cd", length));
			String[] errLogCtnt = (JSPUtil.getParameter(request, prefix	+ "err_log_ctnt", length));
			String[] doSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "do_skd_voy_no", length));
			String[] doSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "do_skd_dir_cd", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] psaDoRcvStsNm = (JSPUtil.getParameter(request, prefix	+ "psa_do_rcv_sts_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgPsaEdoAckSchVO();
				if (doVslNm[i] != null)
					model.setDoVslNm(doVslNm[i]);
				if (psaDoRcvStsCd[i] != null)
					model.setPsaDoRcvStsCd(psaDoRcvStsCd[i]);
				if (psaAuthNo[i] != null)
					model.setPsaAuthNo(psaAuthNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (doVslCd[i] != null)
					model.setDoVslCd(doVslCd[i]);
				if (errLogCtnt[i] != null)
					model.setErrLogCtnt(errLogCtnt[i]);
				if (doSkdVoyNo[i] != null)
					model.setDoSkdVoyNo(doSkdVoyNo[i]);
				if (doSkdDirCd[i] != null)
					model.setDoSkdDirCd(doSkdDirCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (psaDoRcvStsNm[i] != null)
					model.setPsaDoRcvStsNm(psaDoRcvStsNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgPsaEdoAckSchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgPsaEdoAckSchVO[]
	 */
	public BkgPsaEdoAckSchVO[] getBkgPsaEdoAckSchVOs(){
		BkgPsaEdoAckSchVO[] vos = (BkgPsaEdoAckSchVO[])models.toArray(new BkgPsaEdoAckSchVO[models.size()]);
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
		this.doVslNm = this.doVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaDoRcvStsCd = this.psaDoRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaAuthNo = this.psaAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doVslCd = this.doVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLogCtnt = this.errLogCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSkdVoyNo = this.doSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doSkdDirCd = this.doSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaDoRcvStsNm = this.psaDoRcvStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
