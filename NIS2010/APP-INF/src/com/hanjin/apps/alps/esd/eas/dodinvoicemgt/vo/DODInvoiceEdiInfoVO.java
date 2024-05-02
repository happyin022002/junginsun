/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DODInvoiceEdiInfoVO.java
*@FileTitle : DODInvoiceEdiInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : Jeong-Seon, AN
*@LastVersion : 1.0
* 2014.04.28 Jeong-Seon, AN 
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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
 * @author Jeong-Seon, AN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DODInvoiceEdiInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DODInvoiceEdiInfoVO> models = new ArrayList<DODInvoiceEdiInfoVO>();
	
	/* Column Info */
	private String delLoc = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vslVoyDir = null;
	/* Column Info */
	private String mrnmsnNo = null;
	/* Column Info */
	private String imexCd = null;
	/* Column Info */
	private String curRate = null;
	/* Column Info */
	private String curDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DODInvoiceEdiInfoVO() {}

	public DODInvoiceEdiInfoVO(String ibflag, String pagerows, String imexCd, String mrnmsnNo, String blNo, String bkgNo, String vslCd, String vslVoyDir, String polLoc, String podLoc, String delLoc, String eta, String etd, String curRate, String curDt) {
		this.delLoc = delLoc;
		this.vslCd = vslCd;
		this.eta = eta;
		this.polLoc = polLoc;
		this.etd = etd;
		this.podLoc = podLoc;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.vslVoyDir = vslVoyDir;
		this.mrnmsnNo = mrnmsnNo;
		this.imexCd = imexCd;
		this.curRate = curRate;
		this.curDt = curDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_loc", getDelLoc());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vsl_voy_dir", getVslVoyDir());
		this.hashColumns.put("mrnmsn_no", getMrnmsnNo());
		this.hashColumns.put("imex_cd", getImexCd());
		this.hashColumns.put("cur_rate", getCurRate());
		this.hashColumns.put("cur_dt", getCurDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_loc", "delLoc");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vsl_voy_dir", "vslVoyDir");
		this.hashFields.put("mrnmsn_no", "mrnmsnNo");
		this.hashFields.put("imex_cd", "imexCd");
		this.hashFields.put("cur_rate", "curRate");
		this.hashFields.put("cur_dt", "curDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delLoc
	 */
	public String getDelLoc() {
		return this.delLoc;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
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
	 * @return vslVoyDir
	 */
	public String getVslVoyDir() {
		return this.vslVoyDir;
	}
	
	/**
	 * Column Info
	 * @return mrnmsnNo
	 */
	public String getMrnmsnNo() {
		return this.mrnmsnNo;
	}
	
	/**
	 * Column Info
	 * @return imexCd
	 */
	public String getImexCd() {
		return this.imexCd;
	}
	
	/**
	 * Column Info
	 * @return curRate
	 */
	public String getCurRate() {
		return this.curRate;
	}	
	
	/**
	 * Column Info
	 * @return curDt
	 */
	public String getCurDt() {
		return this.curDt;
	}	
	
	/**
	 * Column Info
	 * @param delLoc
	 */
	public void setDelLoc(String delLoc) {
		this.delLoc = delLoc;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
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
	 * @param vslVoyDir
	 */
	public void setVslVoyDir(String vslVoyDir) {
		this.vslVoyDir = vslVoyDir;
	}
	
	/**
	 * Column Info
	 * @param mrnmsnNo
	 */
	public void setMrnmsnNo(String mrnmsnNo) {
		this.mrnmsnNo = mrnmsnNo;
	}
	
	/**
	 * Column Info
	 * @param imexCd
	 */
	public void setImexCd(String imexCd) {
		this.imexCd = imexCd;
	}
	
	/**
	 * Column Info
	 * @param curRate
	 */
	public void setCurRate(String curRate) {
		this.curRate = curRate;
	}
	
	/**
	 * Column Info
	 * @param curDt
	 */
	public void setCurDt(String curDt) {
		this.curDt = curDt;
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
		setDelLoc(JSPUtil.getParameter(request, prefix + "del_loc", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setPolLoc(JSPUtil.getParameter(request, prefix + "pol_loc", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setPodLoc(JSPUtil.getParameter(request, prefix + "pod_loc", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVslVoyDir(JSPUtil.getParameter(request, prefix + "vsl_voy_dir", ""));
		setMrnmsnNo(JSPUtil.getParameter(request, prefix + "mrnmsn_no", ""));
		setImexCd(JSPUtil.getParameter(request, prefix + "imex_cd", ""));
		setCurRate(JSPUtil.getParameter(request, prefix + "cur_rate", ""));
		setCurDt(JSPUtil.getParameter(request, prefix + "cur_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DODInvoiceEdiInfoVO[]
	 */
	public DODInvoiceEdiInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DODInvoiceEdiInfoVO[]
	 */
	public DODInvoiceEdiInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DODInvoiceEdiInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delLoc = (JSPUtil.getParameter(request, prefix	+ "del_loc", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vslVoyDir = (JSPUtil.getParameter(request, prefix	+ "vsl_voy_dir", length));
			String[] mrnmsnNo = (JSPUtil.getParameter(request, prefix	+ "mrnmsn_no", length));
			String[] imexCd = (JSPUtil.getParameter(request, prefix	+ "imex_cd", length));
			String[] curRate = (JSPUtil.getParameter(request, prefix	+ "cur_rate", length));
			String[] curDt = (JSPUtil.getParameter(request, prefix	+ "cur_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DODInvoiceEdiInfoVO();
				if (delLoc[i] != null)
					model.setDelLoc(delLoc[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vslVoyDir[i] != null)
					model.setVslVoyDir(vslVoyDir[i]);
				if (mrnmsnNo[i] != null)
					model.setMrnmsnNo(mrnmsnNo[i]);
				if (imexCd[i] != null)
					model.setImexCd(imexCd[i]);
				if (curRate[i] != null)
					model.setCurRate(curRate[i]);
				if (curDt[i] != null)
					model.setCurDt(curDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDODInvoiceEdiInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DODInvoiceEdiInfoVO[]
	 */
	public DODInvoiceEdiInfoVO[] getDODInvoiceEdiInfoVOs(){
		DODInvoiceEdiInfoVO[] vos = (DODInvoiceEdiInfoVO[])models.toArray(new DODInvoiceEdiInfoVO[models.size()]);
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
		this.delLoc = this.delLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslVoyDir = this.vslVoyDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnmsnNo = this.mrnmsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imexCd = this.imexCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curRate = this.curRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curDt = this.curDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
