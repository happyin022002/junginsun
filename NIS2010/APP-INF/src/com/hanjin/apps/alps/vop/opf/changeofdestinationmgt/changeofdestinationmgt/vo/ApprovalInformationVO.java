/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ApprovalInformationVO.java
*@FileTitle : ApprovalInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.23
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.08.23 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ApprovalInformationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApprovalInformationVO> models = new ArrayList<ApprovalInformationVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String oldVslCd = null;
	/* Column Info */
	private String trkNewPodCd = null;
	/* Column Info */
	private String newPodFullNm = null;
	/* Column Info */
	private String codStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String oldPod = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldPolYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codRhndPortCd = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String oldPodFullNm = null;
	/* Column Info */
	private String trkNewPodFullNm = null;
	/* Column Info */
	private String codRqstRsnCd = null;
	/* Column Info */
	private String newSkdVoyNo = null;
	/* Column Info */
	private String polFullNm = null;
	/* Column Info */
	private String newPor = null;
	/* Column Info */
	private String trkOldPodCd = null;
	/* Column Info */
	private String newVslCd = null;
	/* Column Info */
	private String oldPodYdCd = null;
	/* Column Info */
	private String oldVvd = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String codRjctCd = null;
	/* Column Info */
	private String oldSkdVoyNo = null;
	/* Column Info */
	private String newSkdDirCd = null;
	/* Column Info */
	private String oldDel = null;
	/* Column Info */
	private String newPolYdCd = null;
	/* Column Info */
	private String trkOldPodFullNm = null;
	/* Column Info */
	private String oldPol = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String oldSkdDirCd = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Column Info */
	private String oldPor = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String newPol = null;
	/* Column Info */
	private String newDel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ApprovalInformationVO() {}

	public ApprovalInformationVO(String ibflag, String pagerows, String rgnCd, String oldPor, String oldPol, String oldPod, String oldDel, String newPor, String newPol, String newPod, String newDel, String oldVslCd, String oldSkdVoyNo, String oldSkdDirCd, String oldVvd, String newVslCd, String newSkdVoyNo, String newSkdDirCd, String newVvd, String oldPolYdCd, String oldPodYdCd, String newPolYdCd, String newPodYdCd, String diffRmk, String codRqstRsnCd, String codRqstSeq, String codRhndPortCd, String codStsCd, String codRjctCd, String bkgNo, String creUsrId, String creUsrNm, String polFullNm, String oldPodFullNm, String newPodFullNm, String creDt, String vslEngNm, String trkOldPodCd, String trkOldPodFullNm, String trkNewPodCd, String trkNewPodFullNm) {
		this.rgnCd = rgnCd;
		this.oldVslCd = oldVslCd;
		this.trkNewPodCd = trkNewPodCd;
		this.newPodFullNm = newPodFullNm;
		this.codStsCd = codStsCd;
		this.creDt = creDt;
		this.oldPod = oldPod;
		this.pagerows = pagerows;
		this.oldPolYdCd = oldPolYdCd;
		this.ibflag = ibflag;
		this.codRhndPortCd = codRhndPortCd;
		this.codRqstSeq = codRqstSeq;
		this.vslEngNm = vslEngNm;
		this.oldPodFullNm = oldPodFullNm;
		this.trkNewPodFullNm = trkNewPodFullNm;
		this.codRqstRsnCd = codRqstRsnCd;
		this.newSkdVoyNo = newSkdVoyNo;
		this.polFullNm = polFullNm;
		this.newPor = newPor;
		this.trkOldPodCd = trkOldPodCd;
		this.newVslCd = newVslCd;
		this.oldPodYdCd = oldPodYdCd;
		this.oldVvd = oldVvd;
		this.creUsrNm = creUsrNm;
		this.codRjctCd = codRjctCd;
		this.oldSkdVoyNo = oldSkdVoyNo;
		this.newSkdDirCd = newSkdDirCd;
		this.oldDel = oldDel;
		this.newPolYdCd = newPolYdCd;
		this.trkOldPodFullNm = trkOldPodFullNm;
		this.oldPol = oldPol;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.newPod = newPod;
		this.oldSkdDirCd = oldSkdDirCd;
		this.newPodYdCd = newPodYdCd;
		this.oldPor = oldPor;
		this.newVvd = newVvd;
		this.newPol = newPol;
		this.newDel = newDel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("old_vsl_cd", getOldVslCd());
		this.hashColumns.put("trk_new_pod_cd", getTrkNewPodCd());
		this.hashColumns.put("new_pod_full_nm", getNewPodFullNm());
		this.hashColumns.put("cod_sts_cd", getCodStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("old_pod", getOldPod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_pol_yd_cd", getOldPolYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cod_rhnd_port_cd", getCodRhndPortCd());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("old_pod_full_nm", getOldPodFullNm());
		this.hashColumns.put("trk_new_pod_full_nm", getTrkNewPodFullNm());
		this.hashColumns.put("cod_rqst_rsn_cd", getCodRqstRsnCd());
		this.hashColumns.put("new_skd_voy_no", getNewSkdVoyNo());
		this.hashColumns.put("pol_full_nm", getPolFullNm());
		this.hashColumns.put("new_por", getNewPor());
		this.hashColumns.put("trk_old_pod_cd", getTrkOldPodCd());
		this.hashColumns.put("new_vsl_cd", getNewVslCd());
		this.hashColumns.put("old_pod_yd_cd", getOldPodYdCd());
		this.hashColumns.put("old_vvd", getOldVvd());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("cod_rjct_cd", getCodRjctCd());
		this.hashColumns.put("old_skd_voy_no", getOldSkdVoyNo());
		this.hashColumns.put("new_skd_dir_cd", getNewSkdDirCd());
		this.hashColumns.put("old_del", getOldDel());
		this.hashColumns.put("new_pol_yd_cd", getNewPolYdCd());
		this.hashColumns.put("trk_old_pod_full_nm", getTrkOldPodFullNm());
		this.hashColumns.put("old_pol", getOldPol());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("old_skd_dir_cd", getOldSkdDirCd());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("old_por", getOldPor());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("new_pol", getNewPol());
		this.hashColumns.put("new_del", getNewDel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("old_vsl_cd", "oldVslCd");
		this.hashFields.put("trk_new_pod_cd", "trkNewPodCd");
		this.hashFields.put("new_pod_full_nm", "newPodFullNm");
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_pol_yd_cd", "oldPolYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cod_rhnd_port_cd", "codRhndPortCd");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("old_pod_full_nm", "oldPodFullNm");
		this.hashFields.put("trk_new_pod_full_nm", "trkNewPodFullNm");
		this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
		this.hashFields.put("new_skd_voy_no", "newSkdVoyNo");
		this.hashFields.put("pol_full_nm", "polFullNm");
		this.hashFields.put("new_por", "newPor");
		this.hashFields.put("trk_old_pod_cd", "trkOldPodCd");
		this.hashFields.put("new_vsl_cd", "newVslCd");
		this.hashFields.put("old_pod_yd_cd", "oldPodYdCd");
		this.hashFields.put("old_vvd", "oldVvd");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("cod_rjct_cd", "codRjctCd");
		this.hashFields.put("old_skd_voy_no", "oldSkdVoyNo");
		this.hashFields.put("new_skd_dir_cd", "newSkdDirCd");
		this.hashFields.put("old_del", "oldDel");
		this.hashFields.put("new_pol_yd_cd", "newPolYdCd");
		this.hashFields.put("trk_old_pod_full_nm", "trkOldPodFullNm");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("old_skd_dir_cd", "oldSkdDirCd");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("old_por", "oldPor");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("new_del", "newDel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return oldVslCd
	 */
	public String getOldVslCd() {
		return this.oldVslCd;
	}
	
	/**
	 * Column Info
	 * @return trkNewPodCd
	 */
	public String getTrkNewPodCd() {
		return this.trkNewPodCd;
	}
	
	/**
	 * Column Info
	 * @return newPodFullNm
	 */
	public String getNewPodFullNm() {
		return this.newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return codStsCd
	 */
	public String getCodStsCd() {
		return this.codStsCd;
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
	 * @return oldPod
	 */
	public String getOldPod() {
		return this.oldPod;
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
	 * @return oldPolYdCd
	 */
	public String getOldPolYdCd() {
		return this.oldPolYdCd;
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
	 * @return codRhndPortCd
	 */
	public String getCodRhndPortCd() {
		return this.codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return oldPodFullNm
	 */
	public String getOldPodFullNm() {
		return this.oldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return trkNewPodFullNm
	 */
	public String getTrkNewPodFullNm() {
		return this.trkNewPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return codRqstRsnCd
	 */
	public String getCodRqstRsnCd() {
		return this.codRqstRsnCd;
	}
	
	/**
	 * Column Info
	 * @return newSkdVoyNo
	 */
	public String getNewSkdVoyNo() {
		return this.newSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return polFullNm
	 */
	public String getPolFullNm() {
		return this.polFullNm;
	}
	
	/**
	 * Column Info
	 * @return newPor
	 */
	public String getNewPor() {
		return this.newPor;
	}
	
	/**
	 * Column Info
	 * @return trkOldPodCd
	 */
	public String getTrkOldPodCd() {
		return this.trkOldPodCd;
	}
	
	/**
	 * Column Info
	 * @return newVslCd
	 */
	public String getNewVslCd() {
		return this.newVslCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodYdCd
	 */
	public String getOldPodYdCd() {
		return this.oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return oldVvd
	 */
	public String getOldVvd() {
		return this.oldVvd;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return codRjctCd
	 */
	public String getCodRjctCd() {
		return this.codRjctCd;
	}
	
	/**
	 * Column Info
	 * @return oldSkdVoyNo
	 */
	public String getOldSkdVoyNo() {
		return this.oldSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return newSkdDirCd
	 */
	public String getNewSkdDirCd() {
		return this.newSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return oldDel
	 */
	public String getOldDel() {
		return this.oldDel;
	}
	
	/**
	 * Column Info
	 * @return newPolYdCd
	 */
	public String getNewPolYdCd() {
		return this.newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return trkOldPodFullNm
	 */
	public String getTrkOldPodFullNm() {
		return this.trkOldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return oldPol
	 */
	public String getOldPol() {
		return this.oldPol;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}
	
	/**
	 * Column Info
	 * @return oldSkdDirCd
	 */
	public String getOldSkdDirCd() {
		return this.oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return oldPor
	 */
	public String getOldPor() {
		return this.oldPor;
	}
	
	/**
	 * Column Info
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
	}
	
	/**
	 * Column Info
	 * @return newPol
	 */
	public String getNewPol() {
		return this.newPol;
	}
	
	/**
	 * Column Info
	 * @return newDel
	 */
	public String getNewDel() {
		return this.newDel;
	}
	

	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param oldVslCd
	 */
	public void setOldVslCd(String oldVslCd) {
		this.oldVslCd = oldVslCd;
	}
	
	/**
	 * Column Info
	 * @param trkNewPodCd
	 */
	public void setTrkNewPodCd(String trkNewPodCd) {
		this.trkNewPodCd = trkNewPodCd;
	}
	
	/**
	 * Column Info
	 * @param newPodFullNm
	 */
	public void setNewPodFullNm(String newPodFullNm) {
		this.newPodFullNm = newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param codStsCd
	 */
	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
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
	 * @param oldPod
	 */
	public void setOldPod(String oldPod) {
		this.oldPod = oldPod;
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
	 * @param oldPolYdCd
	 */
	public void setOldPolYdCd(String oldPolYdCd) {
		this.oldPolYdCd = oldPolYdCd;
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
	 * @param codRhndPortCd
	 */
	public void setCodRhndPortCd(String codRhndPortCd) {
		this.codRhndPortCd = codRhndPortCd;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param oldPodFullNm
	 */
	public void setOldPodFullNm(String oldPodFullNm) {
		this.oldPodFullNm = oldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param trkNewPodFullNm
	 */
	public void setTrkNewPodFullNm(String trkNewPodFullNm) {
		this.trkNewPodFullNm = trkNewPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param codRqstRsnCd
	 */
	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
	}
	
	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setNewSkdVoyNo(String newSkdVoyNo) {
		this.newSkdVoyNo = newSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param polFullNm
	 */
	public void setPolFullNm(String polFullNm) {
		this.polFullNm = polFullNm;
	}
	
	/**
	 * Column Info
	 * @param newPor
	 */
	public void setNewPor(String newPor) {
		this.newPor = newPor;
	}
	
	/**
	 * Column Info
	 * @param trkOldPodCd
	 */
	public void setTrkOldPodCd(String trkOldPodCd) {
		this.trkOldPodCd = trkOldPodCd;
	}
	
	/**
	 * Column Info
	 * @param newVslCd
	 */
	public void setNewVslCd(String newVslCd) {
		this.newVslCd = newVslCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodYdCd
	 */
	public void setOldPodYdCd(String oldPodYdCd) {
		this.oldPodYdCd = oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param oldVvd
	 */
	public void setOldVvd(String oldVvd) {
		this.oldVvd = oldVvd;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param codRjctCd
	 */
	public void setCodRjctCd(String codRjctCd) {
		this.codRjctCd = codRjctCd;
	}
	
	/**
	 * Column Info
	 * @param oldSkdVoyNo
	 */
	public void setOldSkdVoyNo(String oldSkdVoyNo) {
		this.oldSkdVoyNo = oldSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param newSkdDirCd
	 */
	public void setNewSkdDirCd(String newSkdDirCd) {
		this.newSkdDirCd = newSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param oldDel
	 */
	public void setOldDel(String oldDel) {
		this.oldDel = oldDel;
	}
	
	/**
	 * Column Info
	 * @param newPolYdCd
	 */
	public void setNewPolYdCd(String newPolYdCd) {
		this.newPolYdCd = newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param trkOldPodFullNm
	 */
	public void setTrkOldPodFullNm(String trkOldPodFullNm) {
		this.trkOldPodFullNm = trkOldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param oldPol
	 */
	public void setOldPol(String oldPol) {
		this.oldPol = oldPol;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}
	
	/**
	 * Column Info
	 * @param oldSkdDirCd
	 */
	public void setOldSkdDirCd(String oldSkdDirCd) {
		this.oldSkdDirCd = oldSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param oldPor
	 */
	public void setOldPor(String oldPor) {
		this.oldPor = oldPor;
	}
	
	/**
	 * Column Info
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}
	
	/**
	 * Column Info
	 * @param newPol
	 */
	public void setNewPol(String newPol) {
		this.newPol = newPol;
	}
	
	/**
	 * Column Info
	 * @param newDel
	 */
	public void setNewDel(String newDel) {
		this.newDel = newDel;
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
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setOldVslCd(JSPUtil.getParameter(request, prefix + "old_vsl_cd", ""));
		setTrkNewPodCd(JSPUtil.getParameter(request, prefix + "trk_new_pod_cd", ""));
		setNewPodFullNm(JSPUtil.getParameter(request, prefix + "new_pod_full_nm", ""));
		setCodStsCd(JSPUtil.getParameter(request, prefix + "cod_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOldPod(JSPUtil.getParameter(request, prefix + "old_pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOldPolYdCd(JSPUtil.getParameter(request, prefix + "old_pol_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCodRhndPortCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_cd", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setOldPodFullNm(JSPUtil.getParameter(request, prefix + "old_pod_full_nm", ""));
		setTrkNewPodFullNm(JSPUtil.getParameter(request, prefix + "trk_new_pod_full_nm", ""));
		setCodRqstRsnCd(JSPUtil.getParameter(request, prefix + "cod_rqst_rsn_cd", ""));
		setNewSkdVoyNo(JSPUtil.getParameter(request, prefix + "new_skd_voy_no", ""));
		setPolFullNm(JSPUtil.getParameter(request, prefix + "pol_full_nm", ""));
		setNewPor(JSPUtil.getParameter(request, prefix + "new_por", ""));
		setTrkOldPodCd(JSPUtil.getParameter(request, prefix + "trk_old_pod_cd", ""));
		setNewVslCd(JSPUtil.getParameter(request, prefix + "new_vsl_cd", ""));
		setOldPodYdCd(JSPUtil.getParameter(request, prefix + "old_pod_yd_cd", ""));
		setOldVvd(JSPUtil.getParameter(request, prefix + "old_vvd", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setCodRjctCd(JSPUtil.getParameter(request, prefix + "cod_rjct_cd", ""));
		setOldSkdVoyNo(JSPUtil.getParameter(request, prefix + "old_skd_voy_no", ""));
		setNewSkdDirCd(JSPUtil.getParameter(request, prefix + "new_skd_dir_cd", ""));
		setOldDel(JSPUtil.getParameter(request, prefix + "old_del", ""));
		setNewPolYdCd(JSPUtil.getParameter(request, prefix + "new_pol_yd_cd", ""));
		setTrkOldPodFullNm(JSPUtil.getParameter(request, prefix + "trk_old_pod_full_nm", ""));
		setOldPol(JSPUtil.getParameter(request, prefix + "old_pol", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
		setOldSkdDirCd(JSPUtil.getParameter(request, prefix + "old_skd_dir_cd", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setOldPor(JSPUtil.getParameter(request, prefix + "old_por", ""));
		setNewVvd(JSPUtil.getParameter(request, prefix + "new_vvd", ""));
		setNewPol(JSPUtil.getParameter(request, prefix + "new_pol", ""));
		setNewDel(JSPUtil.getParameter(request, prefix + "new_del", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApprovalInformationVO[]
	 */
	public ApprovalInformationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApprovalInformationVO[]
	 */
	public ApprovalInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApprovalInformationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] oldVslCd = (JSPUtil.getParameter(request, prefix	+ "old_vsl_cd", length));
			String[] trkNewPodCd = (JSPUtil.getParameter(request, prefix	+ "trk_new_pod_cd", length));
			String[] newPodFullNm = (JSPUtil.getParameter(request, prefix	+ "new_pod_full_nm", length));
			String[] codStsCd = (JSPUtil.getParameter(request, prefix	+ "cod_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] oldPod = (JSPUtil.getParameter(request, prefix	+ "old_pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldPolYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codRhndPortCd = (JSPUtil.getParameter(request, prefix	+ "cod_rhnd_port_cd", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] oldPodFullNm = (JSPUtil.getParameter(request, prefix	+ "old_pod_full_nm", length));
			String[] trkNewPodFullNm = (JSPUtil.getParameter(request, prefix	+ "trk_new_pod_full_nm", length));
			String[] codRqstRsnCd = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_rsn_cd", length));
			String[] newSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "new_skd_voy_no", length));
			String[] polFullNm = (JSPUtil.getParameter(request, prefix	+ "pol_full_nm", length));
			String[] newPor = (JSPUtil.getParameter(request, prefix	+ "new_por", length));
			String[] trkOldPodCd = (JSPUtil.getParameter(request, prefix	+ "trk_old_pod_cd", length));
			String[] newVslCd = (JSPUtil.getParameter(request, prefix	+ "new_vsl_cd", length));
			String[] oldPodYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_yd_cd", length));
			String[] oldVvd = (JSPUtil.getParameter(request, prefix	+ "old_vvd", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] codRjctCd = (JSPUtil.getParameter(request, prefix	+ "cod_rjct_cd", length));
			String[] oldSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "old_skd_voy_no", length));
			String[] newSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "new_skd_dir_cd", length));
			String[] oldDel = (JSPUtil.getParameter(request, prefix	+ "old_del", length));
			String[] newPolYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_yd_cd", length));
			String[] trkOldPodFullNm = (JSPUtil.getParameter(request, prefix	+ "trk_old_pod_full_nm", length));
			String[] oldPol = (JSPUtil.getParameter(request, prefix	+ "old_pol", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix	+ "new_pod", length));
			String[] oldSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "old_skd_dir_cd", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] oldPor = (JSPUtil.getParameter(request, prefix	+ "old_por", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] newPol = (JSPUtil.getParameter(request, prefix	+ "new_pol", length));
			String[] newDel = (JSPUtil.getParameter(request, prefix	+ "new_del", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApprovalInformationVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (oldVslCd[i] != null)
					model.setOldVslCd(oldVslCd[i]);
				if (trkNewPodCd[i] != null)
					model.setTrkNewPodCd(trkNewPodCd[i]);
				if (newPodFullNm[i] != null)
					model.setNewPodFullNm(newPodFullNm[i]);
				if (codStsCd[i] != null)
					model.setCodStsCd(codStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (oldPod[i] != null)
					model.setOldPod(oldPod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldPolYdCd[i] != null)
					model.setOldPolYdCd(oldPolYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codRhndPortCd[i] != null)
					model.setCodRhndPortCd(codRhndPortCd[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (oldPodFullNm[i] != null)
					model.setOldPodFullNm(oldPodFullNm[i]);
				if (trkNewPodFullNm[i] != null)
					model.setTrkNewPodFullNm(trkNewPodFullNm[i]);
				if (codRqstRsnCd[i] != null)
					model.setCodRqstRsnCd(codRqstRsnCd[i]);
				if (newSkdVoyNo[i] != null)
					model.setNewSkdVoyNo(newSkdVoyNo[i]);
				if (polFullNm[i] != null)
					model.setPolFullNm(polFullNm[i]);
				if (newPor[i] != null)
					model.setNewPor(newPor[i]);
				if (trkOldPodCd[i] != null)
					model.setTrkOldPodCd(trkOldPodCd[i]);
				if (newVslCd[i] != null)
					model.setNewVslCd(newVslCd[i]);
				if (oldPodYdCd[i] != null)
					model.setOldPodYdCd(oldPodYdCd[i]);
				if (oldVvd[i] != null)
					model.setOldVvd(oldVvd[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (codRjctCd[i] != null)
					model.setCodRjctCd(codRjctCd[i]);
				if (oldSkdVoyNo[i] != null)
					model.setOldSkdVoyNo(oldSkdVoyNo[i]);
				if (newSkdDirCd[i] != null)
					model.setNewSkdDirCd(newSkdDirCd[i]);
				if (oldDel[i] != null)
					model.setOldDel(oldDel[i]);
				if (newPolYdCd[i] != null)
					model.setNewPolYdCd(newPolYdCd[i]);
				if (trkOldPodFullNm[i] != null)
					model.setTrkOldPodFullNm(trkOldPodFullNm[i]);
				if (oldPol[i] != null)
					model.setOldPol(oldPol[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (oldSkdDirCd[i] != null)
					model.setOldSkdDirCd(oldSkdDirCd[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (oldPor[i] != null)
					model.setOldPor(oldPor[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (newPol[i] != null)
					model.setNewPol(newPol[i]);
				if (newDel[i] != null)
					model.setNewDel(newDel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApprovalInformationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApprovalInformationVO[]
	 */
	public ApprovalInformationVO[] getApprovalInformationVOs(){
		ApprovalInformationVO[] vos = (ApprovalInformationVO[])models.toArray(new ApprovalInformationVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVslCd = this.oldVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkNewPodCd = this.trkNewPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodFullNm = this.newPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codStsCd = this.codStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPod = this.oldPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolYdCd = this.oldPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRhndPortCd = this.codRhndPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodFullNm = this.oldPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkNewPodFullNm = this.trkNewPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstRsnCd = this.codRqstRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdVoyNo = this.newSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullNm = this.polFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPor = this.newPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkOldPodCd = this.trkOldPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVslCd = this.newVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodYdCd = this.oldPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVvd = this.oldVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRjctCd = this.codRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdVoyNo = this.oldSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdDirCd = this.newSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDel = this.oldDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolYdCd = this.newPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkOldPodFullNm = this.trkOldPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPol = this.oldPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSkdDirCd = this.oldSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPor = this.oldPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPol = this.newPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDel = this.newDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
