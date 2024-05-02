/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBookingVO.java
*@FileTitle : MtyBookingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.28 김병규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyBookingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBookingVO> models = new ArrayList<MtyBookingVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String mtyBkgStsCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String bkgRmk = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String mtySplitAvalCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String udtFlag = null;
	/* Column Info */
	private String bkgCreSvrCd = null;
	/* Column Info */
	private String compInd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String mtyPodFlg = null;
	/* Column Info */
	private String mtyPreVvdFlg = null;
	/* Column Info */
	private String mtyPortFlg = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBookingVO() {}

	public MtyBookingVO(String ibflag, String pagerows, String bkgCreSvrCd, String bkgOfcCd, String bkgRmk, String compInd, String mtyBkgStsCd, String mtySplitAvalCd, String pkupYdCd, String podCd, String podYdCd, String polCd, String polYdCd, String preRlyPortCd, String pstRlyPortCd, String skdDirCd, String skdVoyNo, String udtFlag, String usrId, String vslCd, String mtyPodFlg, String mtyPreVvdFlg, String mtyPortFlg) {
		this.bkgOfcCd = bkgOfcCd;
		this.vslCd = vslCd;
		this.mtyBkgStsCd = mtyBkgStsCd;
		this.preRlyPortCd = preRlyPortCd;
		this.bkgRmk = bkgRmk;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.pkupYdCd = pkupYdCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.mtySplitAvalCd = mtySplitAvalCd;
		this.usrId = usrId;
		this.polYdCd = polYdCd;
		this.udtFlag = udtFlag;
		this.bkgCreSvrCd = bkgCreSvrCd;
		this.compInd = compInd;
		this.podYdCd = podYdCd;
		this.pstRlyPortCd = pstRlyPortCd;
 		this.mtyPodFlg = mtyPodFlg;
		this.mtyPreVvdFlg = mtyPreVvdFlg;
		this.mtyPortFlg = mtyPortFlg;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mty_bkg_sts_cd", getMtyBkgStsCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bkg_rmk", getBkgRmk());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("mty_split_aval_cd", getMtySplitAvalCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("udt_flag", getUdtFlag());
		this.hashColumns.put("bkg_cre_svr_cd", getBkgCreSvrCd());
		this.hashColumns.put("comp_ind", getCompInd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("mty_pod_flg", getMtyPodFlg());
		this.hashColumns.put("mty_pre_vvd_flg", getMtyPreVvdFlg());
		this.hashColumns.put("mty_port_flg", getMtyPortFlg());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mty_bkg_sts_cd", "mtyBkgStsCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bkg_rmk", "bkgRmk");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("mty_split_aval_cd", "mtySplitAvalCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("udt_flag", "udtFlag");
		this.hashFields.put("bkg_cre_svr_cd", "bkgCreSvrCd");
		this.hashFields.put("comp_ind", "compInd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("mty_pod_flg", "mtyPodFlg");
		this.hashFields.put("mty_pre_vvd_flg", "mtyPreVvdFlg");
		this.hashFields.put("mty_port_flg", "mtyPortFlg");				
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return mtyBkgStsCd
	 */
	public String getMtyBkgStsCd() {
		return this.mtyBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRmk
	 */
	public String getBkgRmk() {
		return this.bkgRmk;
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
	 * Column Info
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
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
	 * @return mtySplitAvalCd
	 */
	public String getMtySplitAvalCd() {
		return this.mtySplitAvalCd;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return udtFlag
	 */
	public String getUdtFlag() {
		return this.udtFlag;
	}
	
	/**
	 * Column Info
	 * @return bkgCreSvrCd
	 */
	public String getBkgCreSvrCd() {
		return this.bkgCreSvrCd;
	}
	
	/**
	 * Column Info
	 * @return compInd
	 */
	public String getCompInd() {
		return this.compInd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPodFlg
	 */
	public String getMtyPodFlg() {
		return this.mtyPodFlg;
	}
	
	/**
	 * Column Info
	 * @return mtyPreVvdFlg
	 */
	public String getMtyPreVvdFlg() {
		return this.mtyPreVvdFlg;
	}
	
	/**
	 * Column Info
	 * @return mtyPortFlg
	 */
	public String getMtyPortFlg() {
		return this.mtyPortFlg;
	}
		
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param mtyBkgStsCd
	 */
	public void setMtyBkgStsCd(String mtyBkgStsCd) {
		this.mtyBkgStsCd = mtyBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRmk
	 */
	public void setBkgRmk(String bkgRmk) {
		this.bkgRmk = bkgRmk;
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
	 * Column Info
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
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
	 * @param mtySplitAvalCd
	 */
	public void setMtySplitAvalCd(String mtySplitAvalCd) {
		this.mtySplitAvalCd = mtySplitAvalCd;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param udtFlag
	 */
	public void setUdtFlag(String udtFlag) {
		this.udtFlag = udtFlag;
	}
	
	/**
	 * Column Info
	 * @param bkgCreSvrCd
	 */
	public void setBkgCreSvrCd(String bkgCreSvrCd) {
		this.bkgCreSvrCd = bkgCreSvrCd;
	}
	
	/**
	 * Column Info
	 * @param compInd
	 */
	public void setCompInd(String compInd) {
		this.compInd = compInd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPodFlg
	 */
	public void setMtyPodFlg(String mtyPodFlg) {
		this.mtyPodFlg = mtyPodFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyPreVvdFlg
	 */
	public void setMtyPreVvdFlg(String mtyPreVvdFlg) {
		this.mtyPreVvdFlg = mtyPreVvdFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyPortFlg
	 */
	public void setMtyPortFlg(String mtyPortFlg) {
		this.mtyPortFlg = mtyPortFlg;
	}
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMtyBkgStsCd(JSPUtil.getParameter(request, "mty_bkg_sts_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setBkgRmk(JSPUtil.getParameter(request, "bkg_rmk", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPkupYdCd(JSPUtil.getParameter(request, "pkup_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setMtySplitAvalCd(JSPUtil.getParameter(request, "mty_split_aval_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setUdtFlag(JSPUtil.getParameter(request, "udt_flag", ""));
		setBkgCreSvrCd(JSPUtil.getParameter(request, "bkg_cre_svr_cd", ""));
		setCompInd(JSPUtil.getParameter(request, "comp_ind", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setMtyPodFlg(JSPUtil.getParameter(request, "mty_pod_flg", ""));
		setMtyPreVvdFlg(JSPUtil.getParameter(request, "mty_pre_vvd_flg", ""));
		setMtyPortFlg(JSPUtil.getParameter(request, "mty_port_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBookingVO[]
	 */
	public MtyBookingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBookingVO[]
	 */
	public MtyBookingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBookingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] mtyBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_sts_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] bkgRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_rmk", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] mtySplitAvalCd = (JSPUtil.getParameter(request, prefix	+ "mty_split_aval_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] udtFlag = (JSPUtil.getParameter(request, prefix	+ "udt_flag", length));
			String[] bkgCreSvrCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_svr_cd", length));
			String[] compInd = (JSPUtil.getParameter(request, prefix	+ "comp_ind", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] mtyPodFlg = (JSPUtil.getParameter(request, prefix	+ "mty_pod_flg", length));
			String[] mtyPreVvdFlg = (JSPUtil.getParameter(request, prefix	+ "mty_pre_vvd_flg", length));
			String[] mtyPortFlg = (JSPUtil.getParameter(request, prefix	+ "mty_port_flg", length));			
			
			for (int i = 0; i < length; i++) {
				model = new MtyBookingVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (mtyBkgStsCd[i] != null)
					model.setMtyBkgStsCd(mtyBkgStsCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (bkgRmk[i] != null)
					model.setBkgRmk(bkgRmk[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (mtySplitAvalCd[i] != null)
					model.setMtySplitAvalCd(mtySplitAvalCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (udtFlag[i] != null)
					model.setUdtFlag(udtFlag[i]);
				if (bkgCreSvrCd[i] != null)
					model.setBkgCreSvrCd(bkgCreSvrCd[i]);
				if (compInd[i] != null)
					model.setCompInd(compInd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (mtyPodFlg[i] != null)
					model.setMtyPodFlg(mtyPodFlg[i]);
				if (mtyPreVvdFlg[i] != null)
					model.setMtyPreVvdFlg(mtyPreVvdFlg[i]);
				if (mtyPortFlg[i] != null)
					model.setMtyPortFlg(mtyPortFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBookingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBookingVO[]
	 */
	public MtyBookingVO[] getMtyBookingVOs(){
		MtyBookingVO[] vos = (MtyBookingVO[])models.toArray(new MtyBookingVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgStsCd = this.mtyBkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRmk = this.bkgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtySplitAvalCd = this.mtySplitAvalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udtFlag = this.udtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreSvrCd = this.bkgCreSvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compInd = this.compInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPodFlg = this.mtyPodFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPreVvdFlg = this.mtyPreVvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPortFlg = this.mtyPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
