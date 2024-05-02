/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaVesselVO.java
*@FileTitle : PanamaVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.24 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
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

public class PanamaVesselVO extends VesselVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<PanamaVesselVO> models = new ArrayList<PanamaVesselVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ediSndUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String shpIdNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslCdTemp = null;
	/* Column Info */
	private String mvmtSeq = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String pnmVslOprCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ediSndSeq = null;
	/* Column Info */
	private String pnmDestCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pnmOrgCd = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PanamaVesselVO() {}

	public PanamaVesselVO(String ibflag, String pagerows, String vvdCd, String vslCd, String skdVoyNo, String skdDirCd, String slanCd, String vpsEtaDt, String polCd, String podCd, String shpIdNo, String vstNo, String mvmtSeq, String pnmVslOprCd, String pnmOrgCd, String pnmDestCd, String vslCdTemp, String updUsrId, String updDt, String creUsrId, String creDt, String ediSndDt, String ediSndSeq, String ediSndUsrId) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.ediSndUsrId = ediSndUsrId;
		this.creDt = creDt;
		this.shpIdNo = shpIdNo;
		this.skdVoyNo = skdVoyNo;
		this.vslCdTemp = vslCdTemp;
		this.mvmtSeq = mvmtSeq;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.pnmVslOprCd = pnmVslOprCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.ediSndSeq = ediSndSeq;
		this.pnmDestCd = pnmDestCd;
		this.slanCd = slanCd;
		this.vvdCd = vvdCd;
		this.pnmOrgCd = pnmOrgCd;
		this.ediSndDt = ediSndDt;
		this.updUsrId = updUsrId;
		this.vstNo = vstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("edi_snd_usr_id", getEdiSndUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("shp_id_no", getShpIdNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_cd_temp", getVslCdTemp());
		this.hashColumns.put("mvmt_seq", getMvmtSeq());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pnm_vsl_opr_cd", getPnmVslOprCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("edi_snd_seq", getEdiSndSeq());
		this.hashColumns.put("pnm_dest_cd", getPnmDestCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pnm_org_cd", getPnmOrgCd());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vst_no", getVstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("edi_snd_usr_id", "ediSndUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("shp_id_no", "shpIdNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_cd_temp", "vslCdTemp");
		this.hashFields.put("mvmt_seq", "mvmtSeq");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pnm_vsl_opr_cd", "pnmVslOprCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("edi_snd_seq", "ediSndSeq");
		this.hashFields.put("pnm_dest_cd", "pnmDestCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pnm_org_cd", "pnmOrgCd");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vst_no", "vstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return ediSndUsrId
	 */
	public String getEdiSndUsrId() {
		return this.ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return shpIdNo
	 */
	public String getShpIdNo() {
		return this.shpIdNo;
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
	 * @return vslCdTemp
	 */
	public String getVslCdTemp() {
		return this.vslCdTemp;
	}
	
	/**
	 * Column Info
	 * @return mvmtSeq
	 */
	public String getMvmtSeq() {
		return this.mvmtSeq;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return pnmVslOprCd
	 */
	public String getPnmVslOprCd() {
		return this.pnmVslOprCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ediSndSeq
	 */
	public String getEdiSndSeq() {
		return this.ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @return pnmDestCd
	 */
	public String getPnmDestCd() {
		return this.pnmDestCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return pnmOrgCd
	 */
	public String getPnmOrgCd() {
		return this.pnmOrgCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return vstNo
	 */
	public String getVstNo() {
		return this.vstNo;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param ediSndUsrId
	 */
	public void setEdiSndUsrId(String ediSndUsrId) {
		this.ediSndUsrId = ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param shpIdNo
	 */
	public void setShpIdNo(String shpIdNo) {
		this.shpIdNo = shpIdNo;
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
	 * @param vslCdTemp
	 */
	public void setVslCdTemp(String vslCdTemp) {
		this.vslCdTemp = vslCdTemp;
	}
	
	/**
	 * Column Info
	 * @param mvmtSeq
	 */
	public void setMvmtSeq(String mvmtSeq) {
		this.mvmtSeq = mvmtSeq;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param pnmVslOprCd
	 */
	public void setPnmVslOprCd(String pnmVslOprCd) {
		this.pnmVslOprCd = pnmVslOprCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ediSndSeq
	 */
	public void setEdiSndSeq(String ediSndSeq) {
		this.ediSndSeq = ediSndSeq;
	}
	
	/**
	 * Column Info
	 * @param pnmDestCd
	 */
	public void setPnmDestCd(String pnmDestCd) {
		this.pnmDestCd = pnmDestCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param pnmOrgCd
	 */
	public void setPnmOrgCd(String pnmOrgCd) {
		this.pnmOrgCd = pnmOrgCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param vstNo
	 */
	public void setVstNo(String vstNo) {
		this.vstNo = vstNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEdiSndUsrId(JSPUtil.getParameter(request, "edi_snd_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setShpIdNo(JSPUtil.getParameter(request, "shp_id_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslCdTemp(JSPUtil.getParameter(request, "vsl_cd_temp", ""));
		setMvmtSeq(JSPUtil.getParameter(request, "mvmt_seq", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPnmVslOprCd(JSPUtil.getParameter(request, "pnm_vsl_opr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setEdiSndSeq(JSPUtil.getParameter(request, "edi_snd_seq", ""));
		setPnmDestCd(JSPUtil.getParameter(request, "pnm_dest_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPnmOrgCd(JSPUtil.getParameter(request, "pnm_org_cd", ""));
		setEdiSndDt(JSPUtil.getParameter(request, "edi_snd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVstNo(JSPUtil.getParameter(request, "vst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PanamaVesselVO[]
	 */
	public PanamaVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PanamaVesselVO[]
	 */
	public PanamaVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PanamaVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ediSndUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] shpIdNo = (JSPUtil.getParameter(request, prefix	+ "shp_id_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslCdTemp = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_temp", length));
			String[] mvmtSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_seq", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pnmVslOprCd = (JSPUtil.getParameter(request, prefix	+ "pnm_vsl_opr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ediSndSeq = (JSPUtil.getParameter(request, prefix	+ "edi_snd_seq", length));
			String[] pnmDestCd = (JSPUtil.getParameter(request, prefix	+ "pnm_dest_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pnmOrgCd = (JSPUtil.getParameter(request, prefix	+ "pnm_org_cd", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vstNo = (JSPUtil.getParameter(request, prefix	+ "vst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PanamaVesselVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ediSndUsrId[i] != null)
					model.setEdiSndUsrId(ediSndUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (shpIdNo[i] != null)
					model.setShpIdNo(shpIdNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslCdTemp[i] != null)
					model.setVslCdTemp(vslCdTemp[i]);
				if (mvmtSeq[i] != null)
					model.setMvmtSeq(mvmtSeq[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pnmVslOprCd[i] != null)
					model.setPnmVslOprCd(pnmVslOprCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ediSndSeq[i] != null)
					model.setEdiSndSeq(ediSndSeq[i]);
				if (pnmDestCd[i] != null)
					model.setPnmDestCd(pnmDestCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pnmOrgCd[i] != null)
					model.setPnmOrgCd(pnmOrgCd[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vstNo[i] != null)
					model.setVstNo(vstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPanamaVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PanamaVesselVO[]
	 */
	public PanamaVesselVO[] getPanamaVesselVOs(){
		PanamaVesselVO[] vos = (PanamaVesselVO[])models.toArray(new PanamaVesselVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndUsrId = this.ediSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpIdNo = this.shpIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdTemp = this.vslCdTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSeq = this.mvmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmVslOprCd = this.pnmVslOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndSeq = this.ediSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmDestCd = this.pnmDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmOrgCd = this.pnmOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstNo = this.vstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
