/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaAmsReportIsf5ListVO.java
*@FileTitle : UsaAmsReportIsf5ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.14 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaAmsReportIsf5ListVO extends AmsReportListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaAmsReportIsf5ListVO> models = new ArrayList<UsaAmsReportIsf5ListVO>();
	
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String amsFileNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String isfRsltCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String isfRsltDesc = null;
	/* Column Info */
	private String isfRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String isfActCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String mh = null;
	/* Column Info */
	private String bkgCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaAmsReportIsf5ListVO() {}

	public UsaAmsReportIsf5ListVO(String ibflag, String pagerows, String cntCd, String bkgNo, String mblNo, String amsFileNo, String filer, String mh, String polCd, String podCd, String isfActCd, String isfRsltCd, String isfRsltDesc, String isfRmk, String sndDt, String rcvDt, String vvd, String rnum, String bkgCustTpCd, String custNm) {
		this.filer = filer;
		this.amsFileNo = amsFileNo;
		this.custNm = custNm;
		this.isfRsltCd = isfRsltCd;
		this.sndDt = sndDt;
		this.isfRsltDesc = isfRsltDesc;
		this.isfRmk = isfRmk;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.isfActCd = isfActCd;
		this.rnum = rnum;
		this.rcvDt = rcvDt;
		this.cntCd = cntCd;
		this.mblNo = mblNo;
		this.mh = mh;
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("ams_file_no", getAmsFileNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("isf_rslt_cd", getIsfRsltCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("isf_rslt_desc", getIsfRsltDesc());
		this.hashColumns.put("isf_rmk", getIsfRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("isf_act_cd", getIsfActCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("mh", getMh());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("filer", "filer");
		this.hashFields.put("ams_file_no", "amsFileNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("isf_rslt_cd", "isfRsltCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("isf_rslt_desc", "isfRsltDesc");
		this.hashFields.put("isf_rmk", "isfRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("isf_act_cd", "isfActCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("mh", "mh");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return amsFileNo
	 */
	public String getAmsFileNo() {
		return this.amsFileNo;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return isfRsltCd
	 */
	public String getIsfRsltCd() {
		return this.isfRsltCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return isfRsltDesc
	 */
	public String getIsfRsltDesc() {
		return this.isfRsltDesc;
	}
	
	/**
	 * Column Info
	 * @return isfRmk
	 */
	public String getIsfRmk() {
		return this.isfRmk;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return isfActCd
	 */
	public String getIsfActCd() {
		return this.isfActCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return mh
	 */
	public String getMh() {
		return this.mh;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	

	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param amsFileNo
	 */
	public void setAmsFileNo(String amsFileNo) {
		this.amsFileNo = amsFileNo;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param isfRsltCd
	 */
	public void setIsfRsltCd(String isfRsltCd) {
		this.isfRsltCd = isfRsltCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param isfRsltDesc
	 */
	public void setIsfRsltDesc(String isfRsltDesc) {
		this.isfRsltDesc = isfRsltDesc;
	}
	
	/**
	 * Column Info
	 * @param isfRmk
	 */
	public void setIsfRmk(String isfRmk) {
		this.isfRmk = isfRmk;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param isfActCd
	 */
	public void setIsfActCd(String isfActCd) {
		this.isfActCd = isfActCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param mh
	 */
	public void setMh(String mh) {
		this.mh = mh;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
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
		setFiler(JSPUtil.getParameter(request, prefix + "filer", ""));
		setAmsFileNo(JSPUtil.getParameter(request, prefix + "ams_file_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setIsfRsltCd(JSPUtil.getParameter(request, prefix + "isf_rslt_cd", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setIsfRsltDesc(JSPUtil.getParameter(request, prefix + "isf_rslt_desc", ""));
		setIsfRmk(JSPUtil.getParameter(request, prefix + "isf_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIsfActCd(JSPUtil.getParameter(request, prefix + "isf_act_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setMh(JSPUtil.getParameter(request, prefix + "mh", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaAmsReportIsf5ListVO[]
	 */
	public UsaAmsReportIsf5ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaAmsReportIsf5ListVO[]
	 */
	public UsaAmsReportIsf5ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaAmsReportIsf5ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] amsFileNo = (JSPUtil.getParameter(request, prefix	+ "ams_file_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] isfRsltCd = (JSPUtil.getParameter(request, prefix	+ "isf_rslt_cd", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] isfRsltDesc = (JSPUtil.getParameter(request, prefix	+ "isf_rslt_desc", length));
			String[] isfRmk = (JSPUtil.getParameter(request, prefix	+ "isf_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] isfActCd = (JSPUtil.getParameter(request, prefix	+ "isf_act_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] mh = (JSPUtil.getParameter(request, prefix	+ "mh", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaAmsReportIsf5ListVO();
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (amsFileNo[i] != null)
					model.setAmsFileNo(amsFileNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (isfRsltCd[i] != null)
					model.setIsfRsltCd(isfRsltCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (isfRsltDesc[i] != null)
					model.setIsfRsltDesc(isfRsltDesc[i]);
				if (isfRmk[i] != null)
					model.setIsfRmk(isfRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (isfActCd[i] != null)
					model.setIsfActCd(isfActCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (mh[i] != null)
					model.setMh(mh[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaAmsReportIsf5ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaAmsReportIsf5ListVO[]
	 */
	public UsaAmsReportIsf5ListVO[] getUsaAmsReportIsf5ListVOs(){
		UsaAmsReportIsf5ListVO[] vos = (UsaAmsReportIsf5ListVO[])models.toArray(new UsaAmsReportIsf5ListVO[models.size()]);
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
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsFileNo = this.amsFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfRsltCd = this.isfRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfRsltDesc = this.isfRsltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfRmk = this.isfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfActCd = this.isfActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mh = this.mh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
