/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FdrBlVO.java
*@FileTitle : FdrBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.16
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.07.16 조원주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FdrBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FdrBlVO> models = new ArrayList<FdrBlVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String exCustNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FdrBlVO() {}

	public FdrBlVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String blNo, String shprCd, String shprNm, String shprAddr, String cneeCd, String cneeNm, String cneeAddr, String ntfyCd, String ntfyNm, String ntfyAddr, String vvd, String polCd, String podCd, String porCd, String delCd, String bkgCustTpCd, String custNm, String custAddr, String exCustNm) {
		this.porCd = porCd;
		this.cneeCd = cneeCd;
		this.cneeAddr = cneeAddr;
		this.custNm = custNm;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.custAddr = custAddr;
		this.blNo = blNo;
		this.ntfyNm = ntfyNm;
		this.ntfyCd = ntfyCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.shprAddr = shprAddr;
		this.shprNm = shprNm;
		this.bkgCustTpCd = bkgCustTpCd;
		this.shprCd = shprCd;
		this.ntfyAddr = ntfyAddr;
		this.exCustNm = exCustNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("ex_cust_nm", getExCustNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("ex_cust_nm", "exCustNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
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
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return exCustNm
	 */
	public String getExCustNm() {
		return this.exCustNm;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
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
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param exCustNm
	 */
	public void setExCustNm(String exCustNm) {
		this.exCustNm = exCustNm;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setExCustNm(JSPUtil.getParameter(request, prefix + "ex_cust_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FdrBlVO[]
	 */
	public FdrBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FdrBlVO[]
	 */
	public FdrBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FdrBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] exCustNm = (JSPUtil.getParameter(request, prefix	+ "ex_cust_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new FdrBlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (exCustNm[i] != null)
					model.setExCustNm(exCustNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFdrBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FdrBlVO[]
	 */
	public FdrBlVO[] getFdrBlVOs(){
		FdrBlVO[] vos = (FdrBlVO[])models.toArray(new FdrBlVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exCustNm = this.exCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
