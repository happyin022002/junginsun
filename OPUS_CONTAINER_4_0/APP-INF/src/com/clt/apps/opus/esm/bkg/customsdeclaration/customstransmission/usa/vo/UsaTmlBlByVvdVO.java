/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaTmlBlByVvdVO.java
*@FileTitle : UsaTmlBlByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.19 김민정 
* 1.0 Creation
* 
* 2011.12.16 민정호 [CLT-111209300] [BKG] Empty Repo BOOKING EDI - 비정상 COPRAR FF 생성
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaTmlBlByVvdVO extends BlInfoVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaTmlBlByVvdVO> models = new ArrayList<UsaTmlBlByVvdVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cstmsPolCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String sndId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcvId = null;
	/* Column Info */
	private String cstmsPodCd = null;
	private String mfStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaTmlBlByVvdVO() {}

	public UsaTmlBlByVvdVO(String ibflag, String pagerows, String blNo, String bkgNo, String vslCd, String skdVoyNo, String skdDirCd, String cstmsPolCd, String cstmsPodCd, String polCd, String podCd, String podNodCd, String cntrNo, String bkgCgoTpCd, String sndId, String ediId, String rnum, String ydCd, String rcvId, String mfStsCd) {
		this.vslCd = vslCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cstmsPolCd = cstmsPolCd;
		this.skdVoyNo = skdVoyNo;
		this.ediId = ediId;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.podNodCd = podNodCd;
		this.sndId = sndId;
		this.ydCd = ydCd;
		this.rnum = rnum;
		this.cntrNo = cntrNo;
		this.rcvId = rcvId;
		this.cstmsPodCd = cstmsPodCd;
		this.mfStsCd = mfStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cstms_pol_cd", getCstmsPolCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("snd_id", getSndId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rcv_id", getRcvId());
		this.hashColumns.put("cstms_pod_cd", getCstmsPodCd());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cstms_pol_cd", "cstmsPolCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("snd_id", "sndId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rcv_id", "rcvId");
		this.hashFields.put("cstms_pod_cd", "cstmsPodCd");
		this.hashFields.put("mf_sts_cd", "mfStsCd");		
		return this.hashFields;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPolCd
	 */
	public String getCstmsPolCd() {
		return this.cstmsPolCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return sndId
	 */
	public String getSndId() {
		return this.sndId;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rcvId
	 */
	public String getRcvId() {
		return this.rcvId;
	}
	
	/**
	 * Column Info
	 * @return cstmsPodCd
	 */
	public String getCstmsPodCd() {
		return this.cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPolCd
	 */
	public void setCstmsPolCd(String cstmsPolCd) {
		this.cstmsPolCd = cstmsPolCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param sndId
	 */
	public void setSndId(String sndId) {
		this.sndId = sndId;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rcvId
	 */
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}
	
	/**
	 * Column Info
	 * @param cstmsPodCd
	 */
	public void setCstmsPodCd(String cstmsPodCd) {
		this.cstmsPodCd = cstmsPodCd;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCstmsPolCd(JSPUtil.getParameter(request, prefix + "cstms_pol_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setSndId(JSPUtil.getParameter(request, prefix + "snd_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRcvId(JSPUtil.getParameter(request, prefix + "rcv_id", ""));
		setCstmsPodCd(JSPUtil.getParameter(request, prefix + "cstms_pod_cd", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaTmlBlByVvdVO[]
	 */
	public UsaTmlBlByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaTmlBlByVvdVO[]
	 */
	public UsaTmlBlByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaTmlBlByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cstmsPolCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pol_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] sndId = (JSPUtil.getParameter(request, prefix	+ "snd_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcvId = (JSPUtil.getParameter(request, prefix	+ "rcv_id", length));
			String[] cstmsPodCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pod_cd", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new UsaTmlBlByVvdVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cstmsPolCd[i] != null)
					model.setCstmsPolCd(cstmsPolCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (sndId[i] != null)
					model.setSndId(sndId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcvId[i] != null)
					model.setRcvId(rcvId[i]);
				if (cstmsPodCd[i] != null)
					model.setCstmsPodCd(cstmsPodCd[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaTmlBlByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaTmlBlByVvdVO[]
	 */
	public UsaTmlBlByVvdVO[] getUsaTmlBlByVvdVOs(){
		UsaTmlBlByVvdVO[] vos = (UsaTmlBlByVvdVO[])models.toArray(new UsaTmlBlByVvdVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPolCd = this.cstmsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndId = this.sndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvId = this.rcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPodCd = this.cstmsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
