/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgWebServiceVO.java
*@FileTitle : BkgWebServiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.02
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.09.02 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgWebServiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgWebServiceVO> models = new ArrayList<BkgWebServiceVO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String xterSndrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlExptFlg = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String sysUpldFlg = null;
	/* Column Info */
	private String bkgBlckFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String jobTp = null;
	/* Column Info */
	private String manualFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgWebServiceVO() {}

	public BkgWebServiceVO(String ibflag, String pagerows, String xterSndrId, String xterRqstNo, String xterRqstSeq, String result, String pctlExptFlg, String bkgUpldStsCd,String sysUpldFlg,String bkgBlckFlg, String jobTp, String manualFlg, String bkgNo) {
		this.result = result;
		this.xterSndrId = xterSndrId;
		this.ibflag = ibflag;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.pagerows = pagerows;
		this.pctlExptFlg = pctlExptFlg;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.sysUpldFlg = sysUpldFlg;
		this.bkgBlckFlg = bkgBlckFlg;
		this.jobTp = jobTp;
		this.manualFlg = manualFlg;
		this.bkgNo = bkgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_expt_flg", getPctlExptFlg());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("sys_upld_flg", getSysUpldFlg());
		this.hashColumns.put("bkg_blck_flg", getBkgBlckFlg());
		this.hashColumns.put("job_tp", getJobTp());
		this.hashColumns.put("manual_flg", getManualFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_expt_flg", "pctlExptFlg");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("sys_upld_flg", "sysUpldFlg");
		this.hashFields.put("bkg_blck_flg", "bkgBlckFlg");
		this.hashFields.put("job_tp", "jobTp");
		this.hashFields.put("manual_flg", "manualFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
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
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
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
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
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
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getPctlExptFlg() {
		return pctlExptFlg;
	}

	public void setPctlExptFlg(String pctlExptFlg) {
		this.pctlExptFlg = pctlExptFlg;
	}

	public String getBkgUpldStsCd() {
		return bkgUpldStsCd;
	}

	public void setBkgUpldStsCd(String bkgUpldStsCd) {
		this.bkgUpldStsCd = bkgUpldStsCd;
	}

	public String getSysUpldFlg() {
		return sysUpldFlg;
	}

	public void setSysUpldFlg(String sysUpldFlg) {
		this.sysUpldFlg = sysUpldFlg;
	}

	public String getBkgBlckFlg() {
		return bkgBlckFlg;
	}

	public void setBkgBlckFlg(String bkgBlckFlg) {
		this.bkgBlckFlg = bkgBlckFlg;
	}

	public String getJobTp() {
		return jobTp;
	}

	public void setJobTp(String jobTp) {
		this.jobTp = jobTp;
	}

	public String getManualFlg() {
		return manualFlg;
	}

	public void setManualFlg(String manualFlg) {
		this.manualFlg = manualFlg;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlExptFlg(JSPUtil.getParameter(request, prefix + "pctl_expt_flg", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
		setSysUpldFlg(JSPUtil.getParameter(request, prefix + "sys_upld_flg", ""));
		setBkgBlckFlg(JSPUtil.getParameter(request, prefix + "bkg_blck_flg", ""));
		setJobTp(JSPUtil.getParameter(request, prefix + "job_tp", ""));
		setManualFlg(JSPUtil.getParameter(request, prefix + "manual_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgWebServiceVO[]
	 */
	public BkgWebServiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgWebServiceVO[]
	 */
	public BkgWebServiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgWebServiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlExptFlg = (JSPUtil.getParameter(request, prefix	+ "pctl_expt_flg", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] sysUpldFlg = (JSPUtil.getParameter(request, prefix	+ "sys_upld_flg", length));
			String[] bkgBlckFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_blck_flg", length));
			String[] jobTp = (JSPUtil.getParameter(request, prefix	+ "job_tp", length));
			String[] manualFlg = (JSPUtil.getParameter(request, prefix	+ "manual_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgWebServiceVO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlExptFlg[i] != null)
					model.setPctlExptFlg(pctlExptFlg[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (sysUpldFlg[i] != null)
					model.setSysUpldFlg(sysUpldFlg[i]);
				if (bkgBlckFlg[i] != null)
					model.setBkgBlckFlg(bkgBlckFlg[i]);
				if (jobTp[i] != null)
					model.setJobTp(jobTp[i]);
				if (manualFlg[i] != null)
					model.setManualFlg(manualFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgWebServiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgWebServiceVO[]
	 */
	public BkgWebServiceVO[] getBkgWebServiceVOs(){
		BkgWebServiceVO[] vos = (BkgWebServiceVO[])models.toArray(new BkgWebServiceVO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlExptFlg = this.pctlExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysUpldFlg = this.sysUpldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlckFlg = this.bkgBlckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobTp = this.jobTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualFlg = this.manualFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
