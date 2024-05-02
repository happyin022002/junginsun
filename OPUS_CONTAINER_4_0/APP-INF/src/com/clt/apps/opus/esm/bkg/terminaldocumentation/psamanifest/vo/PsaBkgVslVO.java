/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PsaBkgVslVO.java
*@FileTitle : PsaBkgVslVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class PsaBkgVslVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaBkgVslVO> models = new ArrayList<PsaBkgVslVO>();
	
	/* Column Info */
	private String shprNm1 = null;
	/* Column Info */
	private String shprNm2 = null;
	/* Column Info */
	private String pvConVoyDir = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String pvVoyDir = null;
	/* Column Info */
	private String ucrNo = null;
	/* Column Info */
	private String soCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podLoc3 = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String podLoc2 = null;
	/* Column Info */
	private String podLoc1 = null;
	/* Column Info */
	private String pvVslNm = null;
	/* Column Info */
	private String bkgPod = null;
	/* Column Info */
	private String bkgFi = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PsaBkgVslVO() {}

	public PsaBkgVslVO(String ibflag, String pagerows, String shprNm1, String shprNm2, String bkgSeq, String pvVoyDir, String ucrNo, String soCd, String bkgNo, String podLoc3, String opCd, String podLoc2, String pvVslNm, String podLoc1, String bkgPod, String bkgFi, String pvConVoyDir) {
		this.shprNm1 = shprNm1;
		this.shprNm2 = shprNm2;
		this.pvConVoyDir = pvConVoyDir;
		this.pagerows = pagerows;
		this.bkgSeq = bkgSeq;
		this.pvVoyDir = pvVoyDir;
		this.ucrNo = ucrNo;
		this.soCd = soCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.podLoc3 = podLoc3;
		this.opCd = opCd;
		this.podLoc2 = podLoc2;
		this.podLoc1 = podLoc1;
		this.pvVslNm = pvVslNm;
		this.bkgPod = bkgPod;
		this.bkgFi = bkgFi;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("shpr_nm1", getShprNm1());
		this.hashColumns.put("shpr_nm2", getShprNm2());
		this.hashColumns.put("pv_con_voy_dir", getPvConVoyDir());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pv_voy_dir", getPvVoyDir());
		this.hashColumns.put("ucr_no", getUcrNo());
		this.hashColumns.put("so_cd", getSoCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_loc3", getPodLoc3());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("pod_loc2", getPodLoc2());
		this.hashColumns.put("pod_loc1", getPodLoc1());
		this.hashColumns.put("pv_vsl_nm", getPvVslNm());
		this.hashColumns.put("bkg_pod", getBkgPod());
		this.hashColumns.put("bkg_fi", getBkgFi());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("shpr_nm1", "shprNm1");
		this.hashFields.put("shpr_nm2", "shprNm2");
		this.hashFields.put("pv_con_voy_dir", "pvConVoyDir");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pv_voy_dir", "pvVoyDir");
		this.hashFields.put("ucr_no", "ucrNo");
		this.hashFields.put("so_cd", "soCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_loc3", "podLoc3");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("pod_loc2", "podLoc2");
		this.hashFields.put("pod_loc1", "podLoc1");
		this.hashFields.put("pv_vsl_nm", "pvVslNm");
		this.hashFields.put("bkg_pod", "bkgPod");
		this.hashFields.put("bkg_fi", "bkgFi");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return shprNm1
	 */
	public String getShprNm1() {
		return this.shprNm1;
	}
	
	/**
	 * Column Info
	 * @return shprNm2
	 */
	public String getShprNm2() {
		return this.shprNm2;
	}
	
	/**
	 * Column Info
	 * @return pvConVoyDir
	 */
	public String getPvConVoyDir() {
		return this.pvConVoyDir;
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
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
	}
	
	/**
	 * Column Info
	 * @return pvVoyDir
	 */
	public String getPvVoyDir() {
		return this.pvVoyDir;
	}
	
	/**
	 * Column Info
	 * @return ucrNo
	 */
	public String getUcrNo() {
		return this.ucrNo;
	}
	
	/**
	 * Column Info
	 * @return soCd
	 */
	public String getSoCd() {
		return this.soCd;
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
	 * @return podLoc3
	 */
	public String getPodLoc3() {
		return this.podLoc3;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return podLoc2
	 */
	public String getPodLoc2() {
		return this.podLoc2;
	}
	
	/**
	 * Column Info
	 * @return podLoc1
	 */
	public String getPodLoc1() {
		return this.podLoc1;
	}
	
	/**
	 * Column Info
	 * @return pvVslNm
	 */
	public String getPvVslNm() {
		return this.pvVslNm;
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
	 * @return bkgFi
	 */
	public String getBkgFi() {
		return this.bkgFi;
	}
	

	/**
	 * Column Info
	 * @param shprNm1
	 */
	public void setShprNm1(String shprNm1) {
		this.shprNm1 = shprNm1;
	}
	
	/**
	 * Column Info
	 * @param shprNm2
	 */
	public void setShprNm2(String shprNm2) {
		this.shprNm2 = shprNm2;
	}
	
	/**
	 * Column Info
	 * @param pvConVoyDir
	 */
	public void setPvConVoyDir(String pvConVoyDir) {
		this.pvConVoyDir = pvConVoyDir;
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
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
	}
	
	/**
	 * Column Info
	 * @param pvVoyDir
	 */
	public void setPvVoyDir(String pvVoyDir) {
		this.pvVoyDir = pvVoyDir;
	}
	
	/**
	 * Column Info
	 * @param ucrNo
	 */
	public void setUcrNo(String ucrNo) {
		this.ucrNo = ucrNo;
	}
	
	/**
	 * Column Info
	 * @param soCd
	 */
	public void setSoCd(String soCd) {
		this.soCd = soCd;
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
	 * @param podLoc3
	 */
	public void setPodLoc3(String podLoc3) {
		this.podLoc3 = podLoc3;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param podLoc2
	 */
	public void setPodLoc2(String podLoc2) {
		this.podLoc2 = podLoc2;
	}
	
	/**
	 * Column Info
	 * @param podLoc1
	 */
	public void setPodLoc1(String podLoc1) {
		this.podLoc1 = podLoc1;
	}
	
	/**
	 * Column Info
	 * @param pvVslNm
	 */
	public void setPvVslNm(String pvVslNm) {
		this.pvVslNm = pvVslNm;
	}
	
	/**
	 * Column Info
	 * @param bkgPod
	 */
	public void setBkgPod(String bkgPod) {
		this.bkgPod = bkgPod;
	}
	
	/**
	 * Column Info
	 * @param bkgFi
	 */
	public void setBkgFi(String bkgFi) {
		this.bkgFi = bkgFi;
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
		setShprNm1(JSPUtil.getParameter(request, prefix + "shpr_nm1", ""));
		setShprNm2(JSPUtil.getParameter(request, prefix + "shpr_nm2", ""));
		setPvConVoyDir(JSPUtil.getParameter(request, prefix + "pv_con_voy_dir", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setPvVoyDir(JSPUtil.getParameter(request, prefix + "pv_voy_dir", ""));
		setUcrNo(JSPUtil.getParameter(request, prefix + "ucr_no", ""));
		setSoCd(JSPUtil.getParameter(request, prefix + "so_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodLoc3(JSPUtil.getParameter(request, prefix + "pod_loc3", ""));
		setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
		setPodLoc2(JSPUtil.getParameter(request, prefix + "pod_loc2", ""));
		setPodLoc1(JSPUtil.getParameter(request, prefix + "pod_loc1", ""));
		setPvVslNm(JSPUtil.getParameter(request, prefix + "pv_vsl_nm", ""));
		setBkgPod(JSPUtil.getParameter(request, prefix + "bkg_pod", ""));
		setBkgFi(JSPUtil.getParameter(request, prefix + "bkg_fi", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgVslVO[]
	 */
	public PsaBkgVslVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaBkgVslVO[]
	 */
	public PsaBkgVslVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgVslVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] shprNm1 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm1", length));
			String[] shprNm2 = (JSPUtil.getParameter(request, prefix	+ "shpr_nm2", length));
			String[] pvConVoyDir = (JSPUtil.getParameter(request, prefix	+ "pv_con_voy_dir", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pvVoyDir = (JSPUtil.getParameter(request, prefix	+ "pv_voy_dir", length));
			String[] ucrNo = (JSPUtil.getParameter(request, prefix	+ "ucr_no", length));
			String[] soCd = (JSPUtil.getParameter(request, prefix	+ "so_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podLoc3 = (JSPUtil.getParameter(request, prefix	+ "pod_loc3", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] podLoc2 = (JSPUtil.getParameter(request, prefix	+ "pod_loc2", length));
			String[] podLoc1 = (JSPUtil.getParameter(request, prefix	+ "pod_loc1", length));
			String[] pvVslNm = (JSPUtil.getParameter(request, prefix	+ "pv_vsl_nm", length));
			String[] bkgPod = (JSPUtil.getParameter(request, prefix	+ "bkg_pod", length));
			String[] bkgFi = (JSPUtil.getParameter(request, prefix	+ "bkg_fi", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaBkgVslVO();
				if (shprNm1[i] != null)
					model.setShprNm1(shprNm1[i]);
				if (shprNm2[i] != null)
					model.setShprNm2(shprNm2[i]);
				if (pvConVoyDir[i] != null)
					model.setPvConVoyDir(pvConVoyDir[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pvVoyDir[i] != null)
					model.setPvVoyDir(pvVoyDir[i]);
				if (ucrNo[i] != null)
					model.setUcrNo(ucrNo[i]);
				if (soCd[i] != null)
					model.setSoCd(soCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podLoc3[i] != null)
					model.setPodLoc3(podLoc3[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (podLoc2[i] != null)
					model.setPodLoc2(podLoc2[i]);
				if (podLoc1[i] != null)
					model.setPodLoc1(podLoc1[i]);
				if (pvVslNm[i] != null)
					model.setPvVslNm(pvVslNm[i]);
				if (bkgPod[i] != null)
					model.setBkgPod(bkgPod[i]);
				if (bkgFi[i] != null)
					model.setBkgFi(bkgFi[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgVslVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgVslVO[]
	 */
	public PsaBkgVslVO[] getPsaBkgVslVOs(){
		PsaBkgVslVO[] vos = (PsaBkgVslVO[])models.toArray(new PsaBkgVslVO[models.size()]);
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
		this.shprNm1 = this.shprNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm2 = this.shprNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pvConVoyDir = this.pvConVoyDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pvVoyDir = this.pvVoyDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucrNo = this.ucrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCd = this.soCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc3 = this.podLoc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc2 = this.podLoc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc1 = this.podLoc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pvVslNm = this.pvVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPod = this.bkgPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFi = this.bkgFi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
