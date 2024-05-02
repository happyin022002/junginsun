/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaIssueDateOutVO.java
*@FileTitle : CaIssueDateOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.12.01 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaIssueDateOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaIssueDateOutVO> models = new ArrayList<CaIssueDateOutVO>();
	
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String kindJ = null;
	/* Column Info */
	private String kindK = null;
	/* Column Info */
	private String kindH = null;
	/* Column Info */
	private String kindI = null;
	/* Column Info */
	private String kindF = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String kindG = null;
	/* Column Info */
	private String kindD = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String kindE = null;
	/* Column Info */
	private String kindC = null;
	/* Column Info */
	private String kindB = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String kindA = null;
	/* Column Info */
	private String bkgCorrRmk = null;
	/* Column Info */
	private String corrOfcCd = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String ratFlg = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String caRsnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaIssueDateOutVO() {}

	public CaIssueDateOutVO(String ibflag, String pagerows, String bkgNo, String usaCstmsFileCd, String vvd, String blNo, String blTpCd, String polCd, String podCd, String corrNo, String corrDt, String corrOfcCd, String caRsnCd, String caRsnNm, String ratFlg, String kindA, String kindB, String kindC, String kindD, String kindE, String kindF, String kindG, String kindH, String kindI, String kindJ, String kindK, String bkgCorrRmk) {
		this.corrDt = corrDt;
		this.kindJ = kindJ;
		this.kindK = kindK;
		this.kindH = kindH;
		this.kindI = kindI;
		this.kindF = kindF;
		this.blNo = blNo;
		this.kindG = kindG;
		this.kindD = kindD;
		this.pagerows = pagerows;
		this.kindE = kindE;
		this.kindC = kindC;
		this.kindB = kindB;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.kindA = kindA;
		this.bkgCorrRmk = bkgCorrRmk;
		this.corrOfcCd = corrOfcCd;
		this.caRsnCd = caRsnCd;
		this.corrNo = corrNo;
		this.ratFlg = ratFlg;
		this.blTpCd = blTpCd;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.caRsnNm = caRsnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("kind_j", getKindJ());
		this.hashColumns.put("kind_k", getKindK());
		this.hashColumns.put("kind_h", getKindH());
		this.hashColumns.put("kind_i", getKindI());
		this.hashColumns.put("kind_f", getKindF());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("kind_g", getKindG());
		this.hashColumns.put("kind_d", getKindD());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kind_e", getKindE());
		this.hashColumns.put("kind_c", getKindC());
		this.hashColumns.put("kind_b", getKindB());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kind_a", getKindA());
		this.hashColumns.put("bkg_corr_rmk", getBkgCorrRmk());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("rat_flg", getRatFlg());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ca_rsn_nm", getCaRsnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("kind_j", "kindJ");
		this.hashFields.put("kind_k", "kindK");
		this.hashFields.put("kind_h", "kindH");
		this.hashFields.put("kind_i", "kindI");
		this.hashFields.put("kind_f", "kindF");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("kind_g", "kindG");
		this.hashFields.put("kind_d", "kindD");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kind_e", "kindE");
		this.hashFields.put("kind_c", "kindC");
		this.hashFields.put("kind_b", "kindB");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kind_a", "kindA");
		this.hashFields.put("bkg_corr_rmk", "bkgCorrRmk");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("rat_flg", "ratFlg");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ca_rsn_nm", "caRsnNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
	}
	
	/**
	 * Column Info
	 * @return kindJ
	 */
	public String getKindJ() {
		return this.kindJ;
	}
	
	/**
	 * Column Info
	 * @return kindK
	 */
	public String getKindK() {
		return this.kindK;
	}
	
	/**
	 * Column Info
	 * @return kindH
	 */
	public String getKindH() {
		return this.kindH;
	}
	
	/**
	 * Column Info
	 * @return kindI
	 */
	public String getKindI() {
		return this.kindI;
	}
	
	/**
	 * Column Info
	 * @return kindF
	 */
	public String getKindF() {
		return this.kindF;
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
	 * @return kindG
	 */
	public String getKindG() {
		return this.kindG;
	}
	
	/**
	 * Column Info
	 * @return kindD
	 */
	public String getKindD() {
		return this.kindD;
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
	 * @return kindE
	 */
	public String getKindE() {
		return this.kindE;
	}
	
	/**
	 * Column Info
	 * @return kindC
	 */
	public String getKindC() {
		return this.kindC;
	}
	
	/**
	 * Column Info
	 * @return kindB
	 */
	public String getKindB() {
		return this.kindB;
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
	 * @return kindA
	 */
	public String getKindA() {
		return this.kindA;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return this.bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return ratFlg
	 */
	public String getRatFlg() {
		return this.ratFlg;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return caRsnNm
	 */
	public String getCaRsnNm() {
		return this.caRsnNm;
	}
	

	/**
	 * Column Info
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
	}
	
	/**
	 * Column Info
	 * @param kindJ
	 */
	public void setKindJ(String kindJ) {
		this.kindJ = kindJ;
	}
	
	/**
	 * Column Info
	 * @param kindK
	 */
	public void setKindK(String kindK) {
		this.kindK = kindK;
	}
	
	/**
	 * Column Info
	 * @param kindH
	 */
	public void setKindH(String kindH) {
		this.kindH = kindH;
	}
	
	/**
	 * Column Info
	 * @param kindI
	 */
	public void setKindI(String kindI) {
		this.kindI = kindI;
	}
	
	/**
	 * Column Info
	 * @param kindF
	 */
	public void setKindF(String kindF) {
		this.kindF = kindF;
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
	 * @param kindG
	 */
	public void setKindG(String kindG) {
		this.kindG = kindG;
	}
	
	/**
	 * Column Info
	 * @param kindD
	 */
	public void setKindD(String kindD) {
		this.kindD = kindD;
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
	 * @param kindE
	 */
	public void setKindE(String kindE) {
		this.kindE = kindE;
	}
	
	/**
	 * Column Info
	 * @param kindC
	 */
	public void setKindC(String kindC) {
		this.kindC = kindC;
	}
	
	/**
	 * Column Info
	 * @param kindB
	 */
	public void setKindB(String kindB) {
		this.kindB = kindB;
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
	 * @param kindA
	 */
	public void setKindA(String kindA) {
		this.kindA = kindA;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrRmk
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param ratFlg
	 */
	public void setRatFlg(String ratFlg) {
		this.ratFlg = ratFlg;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param caRsnNm
	 */
	public void setCaRsnNm(String caRsnNm) {
		this.caRsnNm = caRsnNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCorrDt(JSPUtil.getParameter(request, "corr_dt", ""));
		setKindJ(JSPUtil.getParameter(request, "kind_j", ""));
		setKindK(JSPUtil.getParameter(request, "kind_k", ""));
		setKindH(JSPUtil.getParameter(request, "kind_h", ""));
		setKindI(JSPUtil.getParameter(request, "kind_i", ""));
		setKindF(JSPUtil.getParameter(request, "kind_f", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setKindG(JSPUtil.getParameter(request, "kind_g", ""));
		setKindD(JSPUtil.getParameter(request, "kind_d", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKindE(JSPUtil.getParameter(request, "kind_e", ""));
		setKindC(JSPUtil.getParameter(request, "kind_c", ""));
		setKindB(JSPUtil.getParameter(request, "kind_b", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKindA(JSPUtil.getParameter(request, "kind_a", ""));
		setBkgCorrRmk(JSPUtil.getParameter(request, "bkg_corr_rmk", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, "corr_ofc_cd", ""));
		setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setRatFlg(JSPUtil.getParameter(request, "rat_flg", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, "usa_cstms_file_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCaRsnNm(JSPUtil.getParameter(request, "ca_rsn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaIssueDateOutVO[]
	 */
	public CaIssueDateOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaIssueDateOutVO[]
	 */
	public CaIssueDateOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaIssueDateOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] kindJ = (JSPUtil.getParameter(request, prefix	+ "kind_j", length));
			String[] kindK = (JSPUtil.getParameter(request, prefix	+ "kind_k", length));
			String[] kindH = (JSPUtil.getParameter(request, prefix	+ "kind_h", length));
			String[] kindI = (JSPUtil.getParameter(request, prefix	+ "kind_i", length));
			String[] kindF = (JSPUtil.getParameter(request, prefix	+ "kind_f", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] kindG = (JSPUtil.getParameter(request, prefix	+ "kind_g", length));
			String[] kindD = (JSPUtil.getParameter(request, prefix	+ "kind_d", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kindE = (JSPUtil.getParameter(request, prefix	+ "kind_e", length));
			String[] kindC = (JSPUtil.getParameter(request, prefix	+ "kind_c", length));
			String[] kindB = (JSPUtil.getParameter(request, prefix	+ "kind_b", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] kindA = (JSPUtil.getParameter(request, prefix	+ "kind_a", length));
			String[] bkgCorrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_rmk", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] ratFlg = (JSPUtil.getParameter(request, prefix	+ "rat_flg", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] caRsnNm = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaIssueDateOutVO();
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (kindJ[i] != null)
					model.setKindJ(kindJ[i]);
				if (kindK[i] != null)
					model.setKindK(kindK[i]);
				if (kindH[i] != null)
					model.setKindH(kindH[i]);
				if (kindI[i] != null)
					model.setKindI(kindI[i]);
				if (kindF[i] != null)
					model.setKindF(kindF[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (kindG[i] != null)
					model.setKindG(kindG[i]);
				if (kindD[i] != null)
					model.setKindD(kindD[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kindE[i] != null)
					model.setKindE(kindE[i]);
				if (kindC[i] != null)
					model.setKindC(kindC[i]);
				if (kindB[i] != null)
					model.setKindB(kindB[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (kindA[i] != null)
					model.setKindA(kindA[i]);
				if (bkgCorrRmk[i] != null)
					model.setBkgCorrRmk(bkgCorrRmk[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (ratFlg[i] != null)
					model.setRatFlg(ratFlg[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (caRsnNm[i] != null)
					model.setCaRsnNm(caRsnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaIssueDateOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaIssueDateOutVO[]
	 */
	public CaIssueDateOutVO[] getCaIssueDateOutVOs(){
		CaIssueDateOutVO[] vos = (CaIssueDateOutVO[])models.toArray(new CaIssueDateOutVO[models.size()]);
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
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindJ = this.kindJ .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindK = this.kindK .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindH = this.kindH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindI = this.kindI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindF = this.kindF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindG = this.kindG .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindD = this.kindD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindE = this.kindE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindC = this.kindC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindB = this.kindB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindA = this.kindA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrRmk = this.bkgCorrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratFlg = this.ratFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnNm = this.caRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
