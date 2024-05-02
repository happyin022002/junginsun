/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AusResultCuscarVO.java
*@FileTitle : AusResultCuscarVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusResultCuscarVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusResultCuscarVO> models = new ArrayList<AusResultCuscarVO>();
	
	/* Column Info */
	private String vvdPol = null;
	/* Column Info */
	private String vvdPod = null;
	/* Column Info */
	private String bkgDel = null;
	/* Column Info */
	private String ediRefId = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrCgoInd = null;
	/* Column Info */
	private String rcvRslt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusResultCuscarVO() {}

	public AusResultCuscarVO(String ibflag, String pagerows, String bkgDel, String bkgNo, String bkgPod, String blNo, String cntrCgoInd, String cntrNo, String deTermCd, String ediRefId, String rcvRslt, String sndDt, String usrId, String vvdPod, String vvdPol) {
		this.vvdPol = vvdPol;
		this.vvdPod = vvdPod;
		this.bkgDel = bkgDel;
		this.ediRefId = ediRefId;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrCgoInd = cntrCgoInd;
		this.rcvRslt = rcvRslt;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.bkgPod = bkgPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_pol", getVvdPol());
		this.hashColumns.put("vvd_pod", getVvdPod());
		this.hashColumns.put("bkg_del", getBkgDel());
		this.hashColumns.put("edi_ref_id", getEdiRefId());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_cgo_ind", getCntrCgoInd());
		this.hashColumns.put("rcv_rslt", getRcvRslt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_pod", getBkgPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_pol", "vvdPol");
		this.hashFields.put("vvd_pod", "vvdPod");
		this.hashFields.put("bkg_del", "bkgDel");
		this.hashFields.put("edi_ref_id", "ediRefId");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_cgo_ind", "cntrCgoInd");
		this.hashFields.put("rcv_rslt", "rcvRslt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_pod", "bkgPod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdPol
	 */
	public String getVvdPol() {
		return this.vvdPol;
	}
	
	/**
	 * Column Info
	 * @return vvdPod
	 */
	public String getVvdPod() {
		return this.vvdPod;
	}
	
	/**
	 * Column Info
	 * @return bkgDel
	 */
	public String getBkgDel() {
		return this.bkgDel;
	}
	
	/**
	 * Column Info
	 * @return ediRefId
	 */
	public String getEdiRefId() {
		return this.ediRefId;
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
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return cntrCgoInd
	 */
	public String getCntrCgoInd() {
		return this.cntrCgoInd;
	}
	
	/**
	 * Column Info
	 * @return rcvRslt
	 */
	public String getRcvRslt() {
		return this.rcvRslt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return bkgPod
	 */
	public String getBkgPod() {
		return this.bkgPod;
	}
	

	/**
	 * Column Info
	 * @param vvdPol
	 */
	public void setVvdPol(String vvdPol) {
		this.vvdPol = vvdPol;
	}
	
	/**
	 * Column Info
	 * @param vvdPod
	 */
	public void setVvdPod(String vvdPod) {
		this.vvdPod = vvdPod;
	}
	
	/**
	 * Column Info
	 * @param bkgDel
	 */
	public void setBkgDel(String bkgDel) {
		this.bkgDel = bkgDel;
	}
	
	/**
	 * Column Info
	 * @param ediRefId
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
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
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param cntrCgoInd
	 */
	public void setCntrCgoInd(String cntrCgoInd) {
		this.cntrCgoInd = cntrCgoInd;
	}
	
	/**
	 * Column Info
	 * @param rcvRslt
	 */
	public void setRcvRslt(String rcvRslt) {
		this.rcvRslt = rcvRslt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param bkgPod
	 */
	public void setBkgPod(String bkgPod) {
		this.bkgPod = bkgPod;
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
		setVvdPol(JSPUtil.getParameter(request, prefix + "vvd_pol", ""));
		setVvdPod(JSPUtil.getParameter(request, prefix + "vvd_pod", ""));
		setBkgDel(JSPUtil.getParameter(request, prefix + "bkg_del", ""));
		setEdiRefId(JSPUtil.getParameter(request, prefix + "edi_ref_id", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrCgoInd(JSPUtil.getParameter(request, prefix + "cntr_cgo_ind", ""));
		setRcvRslt(JSPUtil.getParameter(request, prefix + "rcv_rslt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgPod(JSPUtil.getParameter(request, prefix + "bkg_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusResultCuscarVO[]
	 */
	public AusResultCuscarVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusResultCuscarVO[]
	 */
	public AusResultCuscarVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusResultCuscarVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdPol = (JSPUtil.getParameter(request, prefix	+ "vvd_pol", length));
			String[] vvdPod = (JSPUtil.getParameter(request, prefix	+ "vvd_pod", length));
			String[] bkgDel = (JSPUtil.getParameter(request, prefix	+ "bkg_del", length));
			String[] ediRefId = (JSPUtil.getParameter(request, prefix	+ "edi_ref_id", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrCgoInd = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_ind", length));
			String[] rcvRslt = (JSPUtil.getParameter(request, prefix	+ "rcv_rslt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgPod = (JSPUtil.getParameter(request, prefix	+ "bkg_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusResultCuscarVO();
				if (vvdPol[i] != null)
					model.setVvdPol(vvdPol[i]);
				if (vvdPod[i] != null)
					model.setVvdPod(vvdPod[i]);
				if (bkgDel[i] != null)
					model.setBkgDel(bkgDel[i]);
				if (ediRefId[i] != null)
					model.setEdiRefId(ediRefId[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrCgoInd[i] != null)
					model.setCntrCgoInd(cntrCgoInd[i]);
				if (rcvRslt[i] != null)
					model.setRcvRslt(rcvRslt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgPod[i] != null)
					model.setBkgPod(bkgPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusResultCuscarVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusResultCuscarVO[]
	 */
	public AusResultCuscarVO[] getAusResultCuscarVOs(){
		AusResultCuscarVO[] vos = (AusResultCuscarVO[])models.toArray(new AusResultCuscarVO[models.size()]);
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
		this.vvdPol = this.vvdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPod = this.vvdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDel = this.bkgDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefId = this.ediRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoInd = this.cntrCgoInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRslt = this.rcvRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPod = this.bkgPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
