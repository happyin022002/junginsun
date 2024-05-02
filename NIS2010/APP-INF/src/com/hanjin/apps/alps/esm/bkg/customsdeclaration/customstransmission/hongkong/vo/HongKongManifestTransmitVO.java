/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongManifestTransmitVO.java
*@FileTitle : HongKongManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.07 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HongKongManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongManifestTransmitVO> models = new ArrayList<HongKongManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String amendBl = null;
	/* Column Info */
	private String cmdtdesc = null;
	/* Column Info */
	private String bkgspedg = null;
	/* Column Info */
	private String bkgcgotp = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String amendVvd = null;
	/* Column Info */
	private String bkgspebb = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgspeak = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String bkgsperd = null;
	/* Column Info */
	private String bkgsperf = null;
	/* Column Info */
	private String cmdtcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HongKongManifestTransmitVO() {}

	public HongKongManifestTransmitVO(String ibflag, String pagerows, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String userId, String ofcCd, String polCd, String podCd, String bkgNo, String amendBl, String bkgQty, String cntrNo, String bkgcgotp, String bkgsperf, String bkgspedg, String bkgspeak, String bkgspebb, String cmdtdesc, String cmdtcd, String bkgsperd, String amendVvd, String mfSndDt) {
		this.vslCd = vslCd;
		this.amendBl = amendBl;
		this.cmdtdesc = cmdtdesc;
		this.bkgspedg = bkgspedg;
		this.bkgcgotp = bkgcgotp;
		this.skdVoyNo = skdVoyNo;
		this.amendVvd = amendVvd;
		this.bkgspebb = bkgspebb;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.bkgspeak = bkgspeak;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.mfSndDt = mfSndDt;
		this.cntrNo = cntrNo;
		this.bkgQty = bkgQty;
		this.userId = userId;
		this.bkgsperd = bkgsperd;
		this.bkgsperf = bkgsperf;
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("amend_bl", getAmendBl());
		this.hashColumns.put("cmdtdesc", getCmdtdesc());
		this.hashColumns.put("bkgspedg", getBkgspedg());
		this.hashColumns.put("bkgcgotp", getBkgcgotp());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("amend_vvd", getAmendVvd());
		this.hashColumns.put("bkgspebb", getBkgspebb());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkgspeak", getBkgspeak());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("bkgsperd", getBkgsperd());
		this.hashColumns.put("bkgsperf", getBkgsperf());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("amend_bl", "amendBl");
		this.hashFields.put("cmdtdesc", "cmdtdesc");
		this.hashFields.put("bkgspedg", "bkgspedg");
		this.hashFields.put("bkgcgotp", "bkgcgotp");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("amend_vvd", "amendVvd");
		this.hashFields.put("bkgspebb", "bkgspebb");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkgspeak", "bkgspeak");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("bkgsperd", "bkgsperd");
		this.hashFields.put("bkgsperf", "bkgsperf");
		this.hashFields.put("cmdtcd", "cmdtcd");
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
	 * @return amendBl
	 */
	public String getAmendBl() {
		return this.amendBl;
	}
	
	/**
	 * Column Info
	 * @return cmdtdesc
	 */
	public String getCmdtdesc() {
		return this.cmdtdesc;
	}
	
	/**
	 * Column Info
	 * @return bkgspedg
	 */
	public String getBkgspedg() {
		return this.bkgspedg;
	}
	
	/**
	 * Column Info
	 * @return bkgcgotp
	 */
	public String getBkgcgotp() {
		return this.bkgcgotp;
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
	 * @return amendVvd
	 */
	public String getAmendVvd() {
		return this.amendVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgspebb
	 */
	public String getBkgspebb() {
		return this.bkgspebb;
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
	 * @return bkgspeak
	 */
	public String getBkgspeak() {
		return this.bkgspeak;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
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
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return bkgsperd
	 */
	public String getBkgsperd() {
		return this.bkgsperd;
	}
	
	/**
	 * Column Info
	 * @return bkgsperf
	 */
	public String getBkgsperf() {
		return this.bkgsperf;
	}
	
	/**
	 * Column Info
	 * @return cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
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
	 * @param amendBl
	 */
	public void setAmendBl(String amendBl) {
		this.amendBl = amendBl;
	}
	
	/**
	 * Column Info
	 * @param cmdtdesc
	 */
	public void setCmdtdesc(String cmdtdesc) {
		this.cmdtdesc = cmdtdesc;
	}
	
	/**
	 * Column Info
	 * @param bkgspedg
	 */
	public void setBkgspedg(String bkgspedg) {
		this.bkgspedg = bkgspedg;
	}
	
	/**
	 * Column Info
	 * @param bkgcgotp
	 */
	public void setBkgcgotp(String bkgcgotp) {
		this.bkgcgotp = bkgcgotp;
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
	 * @param amendVvd
	 */
	public void setAmendVvd(String amendVvd) {
		this.amendVvd = amendVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgspebb
	 */
	public void setBkgspebb(String bkgspebb) {
		this.bkgspebb = bkgspebb;
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
	 * @param bkgspeak
	 */
	public void setBkgspeak(String bkgspeak) {
		this.bkgspeak = bkgspeak;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
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
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param bkgsperd
	 */
	public void setBkgsperd(String bkgsperd) {
		this.bkgsperd = bkgsperd;
	}
	
	/**
	 * Column Info
	 * @param bkgsperf
	 */
	public void setBkgsperf(String bkgsperf) {
		this.bkgsperf = bkgsperf;
	}
	
	/**
	 * Column Info
	 * @param cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAmendBl(JSPUtil.getParameter(request, "amend_bl", ""));
		setCmdtdesc(JSPUtil.getParameter(request, "cmdtdesc", ""));
		setBkgspedg(JSPUtil.getParameter(request, "bkgspedg", ""));
		setBkgcgotp(JSPUtil.getParameter(request, "bkgcgotp", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setAmendVvd(JSPUtil.getParameter(request, "amend_vvd", ""));
		setBkgspebb(JSPUtil.getParameter(request, "bkgspebb", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgspeak(JSPUtil.getParameter(request, "bkgspeak", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMfSndDt(JSPUtil.getParameter(request, "mf_snd_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setBkgsperd(JSPUtil.getParameter(request, "bkgsperd", ""));
		setBkgsperf(JSPUtil.getParameter(request, "bkgsperf", ""));
		setCmdtcd(JSPUtil.getParameter(request, "cmdtcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongManifestTransmitVO[]
	 */
	public HongKongManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongManifestTransmitVO[]
	 */
	public HongKongManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] amendBl = (JSPUtil.getParameter(request, prefix	+ "amend_bl", length));
			String[] cmdtdesc = (JSPUtil.getParameter(request, prefix	+ "cmdtdesc", length));
			String[] bkgspedg = (JSPUtil.getParameter(request, prefix	+ "bkgspedg", length));
			String[] bkgcgotp = (JSPUtil.getParameter(request, prefix	+ "bkgcgotp", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] amendVvd = (JSPUtil.getParameter(request, prefix	+ "amend_vvd", length));
			String[] bkgspebb = (JSPUtil.getParameter(request, prefix	+ "bkgspebb", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgspeak = (JSPUtil.getParameter(request, prefix	+ "bkgspeak", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] bkgsperd = (JSPUtil.getParameter(request, prefix	+ "bkgsperd", length));
			String[] bkgsperf = (JSPUtil.getParameter(request, prefix	+ "bkgsperf", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (amendBl[i] != null)
					model.setAmendBl(amendBl[i]);
				if (cmdtdesc[i] != null)
					model.setCmdtdesc(cmdtdesc[i]);
				if (bkgspedg[i] != null)
					model.setBkgspedg(bkgspedg[i]);
				if (bkgcgotp[i] != null)
					model.setBkgcgotp(bkgcgotp[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (amendVvd[i] != null)
					model.setAmendVvd(amendVvd[i]);
				if (bkgspebb[i] != null)
					model.setBkgspebb(bkgspebb[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgspeak[i] != null)
					model.setBkgspeak(bkgspeak[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (bkgsperd[i] != null)
					model.setBkgsperd(bkgsperd[i]);
				if (bkgsperf[i] != null)
					model.setBkgsperf(bkgsperf[i]);
				if (cmdtcd[i] != null)
					model.setCmdtcd(cmdtcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHongKongManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongManifestTransmitVO[]
	 */
	public HongKongManifestTransmitVO[] getHongKongManifestTransmitVOs(){
		HongKongManifestTransmitVO[] vos = (HongKongManifestTransmitVO[])models.toArray(new HongKongManifestTransmitVO[models.size()]);
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
		this.amendBl = this.amendBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtdesc = this.cmdtdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspedg = this.bkgspedg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgcgotp = this.bkgcgotp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendVvd = this.amendVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspebb = this.bkgspebb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspeak = this.bkgspeak .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsperd = this.bkgsperd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsperf = this.bkgsperf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
