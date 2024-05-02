/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNotePreviewEtcVO.java
*@FileTitle : DemandNotePreviewEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.08 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemandNotePreviewEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNotePreviewEtcVO> models = new ArrayList<DemandNotePreviewEtcVO>();
	
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String bkgDelTermNm = null;
	/* Column Info */
	private String arr = null;
	/* Column Info */
	private String bkgRcvTermNm = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String dmdtTrfNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trucker = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String bkgDelTermCd = null;
	/* Column Info */
	private String dep = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNotePreviewEtcVO() {}

	public DemandNotePreviewEtcVO(String ibflag, String pagerows, String vvdCd, String vvdNm, String arr, String dep, String blNo, String bkgNo, String cmdtCd, String cmdtNm, String dmdtTrfCd, String dmdtTrfNm, String bkgRcvTermCd, String bkgRcvTermNm, String bkgDelTermCd, String bkgDelTermNm, String pod, String podNm, String del, String delNm, String trucker, String vndrSeq) {
		this.podNm = podNm;
		this.delNm = delNm;
		this.bkgDelTermNm = bkgDelTermNm;
		this.arr = arr;
		this.bkgRcvTermNm = bkgRcvTermNm;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.dmdtTrfNm = dmdtTrfNm;
		this.blNo = blNo;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.vvdNm = vvdNm;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.trucker = trucker;
		this.vvdCd = vvdCd;
		this.cmdtCd = cmdtCd;
		this.vndrSeq = vndrSeq;
		this.del = del;
		this.bkgDelTermCd = bkgDelTermCd;
		this.dep = dep;
		this.dmdtTrfCd = dmdtTrfCd;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("bkg_del_term_nm", getBkgDelTermNm());
		this.hashColumns.put("arr", getArr());
		this.hashColumns.put("bkg_rcv_term_nm", getBkgRcvTermNm());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("dmdt_trf_nm", getDmdtTrfNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trucker", getTrucker());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("bkg_del_term_cd", getBkgDelTermCd());
		this.hashColumns.put("dep", getDep());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("bkg_del_term_nm", "bkgDelTermNm");
		this.hashFields.put("arr", "arr");
		this.hashFields.put("bkg_rcv_term_nm", "bkgRcvTermNm");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("dmdt_trf_nm", "dmdtTrfNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trucker", "trucker");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("del", "del");
		this.hashFields.put("bkg_del_term_cd", "bkgDelTermCd");
		this.hashFields.put("dep", "dep");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return bkgDelTermNm
	 */
	public String getBkgDelTermNm() {
		return this.bkgDelTermNm;
	}
	
	/**
	 * Column Info
	 * @return arr
	 */
	public String getArr() {
		return this.arr;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermNm
	 */
	public String getBkgRcvTermNm() {
		return this.bkgRcvTermNm;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfNm
	 */
	public String getDmdtTrfNm() {
		return this.dmdtTrfNm;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @return trucker
	 */
	public String getTrucker() {
		return this.trucker;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return bkgDelTermCd
	 */
	public String getBkgDelTermCd() {
		return this.bkgDelTermCd;
	}
	
	/**
	 * Column Info
	 * @return dep
	 */
	public String getDep() {
		return this.dep;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param bkgDelTermNm
	 */
	public void setBkgDelTermNm(String bkgDelTermNm) {
		this.bkgDelTermNm = bkgDelTermNm;
	}
	
	/**
	 * Column Info
	 * @param arr
	 */
	public void setArr(String arr) {
		this.arr = arr;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermNm
	 */
	public void setBkgRcvTermNm(String bkgRcvTermNm) {
		this.bkgRcvTermNm = bkgRcvTermNm;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfNm
	 */
	public void setDmdtTrfNm(String dmdtTrfNm) {
		this.dmdtTrfNm = dmdtTrfNm;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
	 * @param trucker
	 */
	public void setTrucker(String trucker) {
		this.trucker = trucker;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param bkgDelTermCd
	 */
	public void setBkgDelTermCd(String bkgDelTermCd) {
		this.bkgDelTermCd = bkgDelTermCd;
	}
	
	/**
	 * Column Info
	 * @param dep
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
		setDelNm(JSPUtil.getParameter(request, "del_nm", ""));
		setBkgDelTermNm(JSPUtil.getParameter(request, "bkg_del_term_nm", ""));
		setArr(JSPUtil.getParameter(request, "arr", ""));
		setBkgRcvTermNm(JSPUtil.getParameter(request, "bkg_rcv_term_nm", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, "bkg_rcv_term_cd", ""));
		setDmdtTrfNm(JSPUtil.getParameter(request, "dmdt_trf_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdNm(JSPUtil.getParameter(request, "vvd_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrucker(JSPUtil.getParameter(request, "trucker", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setBkgDelTermCd(JSPUtil.getParameter(request, "bkg_del_term_cd", ""));
		setDep(JSPUtil.getParameter(request, "dep", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNotePreviewEtcVO[]
	 */
	public DemandNotePreviewEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNotePreviewEtcVO[]
	 */
	public DemandNotePreviewEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNotePreviewEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] bkgDelTermNm = (JSPUtil.getParameter(request, prefix	+ "bkg_del_term_nm", length));
			String[] arr = (JSPUtil.getParameter(request, prefix	+ "arr", length));
			String[] bkgRcvTermNm = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_nm", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] dmdtTrfNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trucker = (JSPUtil.getParameter(request, prefix	+ "trucker", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] bkgDelTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_term_cd", length));
			String[] dep = (JSPUtil.getParameter(request, prefix	+ "dep", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNotePreviewEtcVO();
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (bkgDelTermNm[i] != null)
					model.setBkgDelTermNm(bkgDelTermNm[i]);
				if (arr[i] != null)
					model.setArr(arr[i]);
				if (bkgRcvTermNm[i] != null)
					model.setBkgRcvTermNm(bkgRcvTermNm[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (dmdtTrfNm[i] != null)
					model.setDmdtTrfNm(dmdtTrfNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trucker[i] != null)
					model.setTrucker(trucker[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (bkgDelTermCd[i] != null)
					model.setBkgDelTermCd(bkgDelTermCd[i]);
				if (dep[i] != null)
					model.setDep(dep[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNotePreviewEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNotePreviewEtcVO[]
	 */
	public DemandNotePreviewEtcVO[] getDemandNotePreviewEtcVOs(){
		DemandNotePreviewEtcVO[] vos = (DemandNotePreviewEtcVO[])models.toArray(new DemandNotePreviewEtcVO[models.size()]);
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
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelTermNm = this.bkgDelTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arr = this.arr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermNm = this.bkgRcvTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfNm = this.dmdtTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trucker = this.trucker .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelTermCd = this.bkgDelTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dep = this.dep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
