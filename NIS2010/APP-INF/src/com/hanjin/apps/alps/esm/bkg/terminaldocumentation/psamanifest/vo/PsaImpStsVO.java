/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsaImpStsVO.java
*@FileTitle : PsaImpStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.11 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaImpStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaImpStsVO> models = new ArrayList<PsaImpStsVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String cop = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String nextSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String batchNo = null;
	/* Column Info */
	private String receiverId = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String udtFlag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String fmCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String spc = null;
	/* Column Info */
	private String nextSkdVoyNo = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String nextVslCd = null;
	/* Column Info */
	private String iop = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sav = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String oop = null;
	/* Column Info */
	private String vgmInd = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vgmVrfySigCtnt = null;
	/* Column Info */
	private String vgmRefNo = null;
	/* Column Info */
	private String vgmVrfyDt = null;	
	/* Column Info */
	private String vgmWgt = null;
	
    private PsaVvdVO psaVvdVO = null;
    private PsaImpStsVO[] psaImpStsInfos = null;
	private List<PsaImpStsVO> listPsaImpStsVO = null;

	/**
	 * @return the psaVvdVO
	 */
	public PsaVvdVO getPsaVvdVO() {
		return psaVvdVO;
	}

	/**
	 * @param psaVvdVO the psaVvdVO to set
	 */
	public void setPsaVvdVO(PsaVvdVO psaVvdVO) {
		this.psaVvdVO = psaVvdVO;
	}

	/**
	 * @return the psaImpStsInfos
	 */
	public PsaImpStsVO[] getPsaImpStsInfos() {
		return psaImpStsInfos;
	}

	/**
	 * @param psaImpStsInfos the psaImpStsInfos to set
	 */
	public void setPsaImpStsInfos(PsaImpStsVO[] psaImpStsInfos) {
		this.psaImpStsInfos = psaImpStsInfos;
	}

	/**
	 * @return the listPsaImpStsVO
	 */
	public List<PsaImpStsVO> getListPsaImpStsVO() {
		return listPsaImpStsVO;
	}

	/**
	 * @param listPsaImpStsVO the listPsaImpStsVO to set
	 */
	public void setListPsaImpStsVO(List<PsaImpStsVO> listPsaImpStsVO) {
		this.listPsaImpStsVO = listPsaImpStsVO;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaImpStsVO() {}

	public PsaImpStsVO(String ibflag, String pagerows, String sav, String vslCd, String skdVoyNo, String skdDirCd, String cntrNo, String polCd, String podCd, String cntrWgt, String tsTpCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String fmCd, String nextVslCd, String nextSkdVoyNo, String nextSkdDirCd, String portCd, String cop, String iop, String oop, String batchNo, String sndDt, String sealNo, String bkgNo, String cntrTpszCd, String spc, String udtFlag, String psaVoyDirCd, String psaVslNm, String userId, String typeCd, String receiverId, String vgmInd, String vgmMzdTpCd,  String vgmVrfySigCtnt, String vgmRefNo, String vgmVrfyDt, String vgmWgt) {
		this.vslCd = vslCd;
		this.psaVslNm = psaVslNm;
		this.rdCgoFlg = rdCgoFlg;
		this.cop = cop;
		this.sndDt = sndDt;
		this.nextSkdDirCd = nextSkdDirCd;
		this.pagerows = pagerows;
		this.tsTpCd = tsTpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.batchNo = batchNo;
		this.receiverId = receiverId;
		this.bbCgoFlg = bbCgoFlg;
		this.userId = userId;
		this.udtFlag = udtFlag;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.fmCd = fmCd;
		this.portCd = portCd;
		this.spc = spc;
		this.nextSkdVoyNo = nextSkdVoyNo;
		this.sealNo = sealNo;
		this.psaVoyDirCd = psaVoyDirCd;
		this.cntrWgt = cntrWgt;
		this.nextVslCd = nextVslCd;
		this.iop = iop;
		this.awkCgoFlg = awkCgoFlg;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.sav = sav;
		this.rcFlg = rcFlg;
		this.typeCd = typeCd;
		this.oop = oop;
		this.vgmInd = vgmInd;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
		this.vgmRefNo = vgmRefNo;
		this.vgmVrfyDt = vgmVrfyDt;	
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("cop", getCop());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("next_skd_dir_cd", getNextSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("batch_no", getBatchNo());
		this.hashColumns.put("receiver_id", getReceiverId());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("udt_flag", getUdtFlag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("fm_cd", getFmCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("spc", getSpc());
		this.hashColumns.put("next_skd_voy_no", getNextSkdVoyNo());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("next_vsl_cd", getNextVslCd());
		this.hashColumns.put("iop", getIop());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sav", getSav());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("oop", getOop());
		this.hashColumns.put("vgm_ind",getVgmInd());
		this.hashColumns.put("vgm_mzd_tp_cd",getVgmMethod());
		this.hashColumns.put("vgm_vrfy_sig_ctnt",getVgmVrfySigCtnt());
		this.hashColumns.put("vgm_ref_no",getVgmRefNo());
		this.hashColumns.put("vgm_vrfy_dt",getVgmVrfyDt());		
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("cop", "cop");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("next_skd_dir_cd", "nextSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("batch_no", "batchNo");
		this.hashFields.put("receiver_id", "receiverId");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("udt_flag", "udtFlag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("fm_cd", "fmCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("spc", "spc");
		this.hashFields.put("next_skd_voy_no", "nextSkdVoyNo");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("next_vsl_cd", "nextVslCd");
		this.hashFields.put("iop", "iop");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sav", "sav");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("oop", "oop");
		this.hashFields.put("vgm_ind","vgmInd");
		this.hashFields.put("vgm_mzd_tp_cd","vgmMzdTpCd");
		this.hashFields.put("vgm_vrfy_sig_ctnt","vgmVrfySigCtnt");
		this.hashFields.put("vgm_ref_no","vgmRefNo");
		this.hashFields.put("vgm_vrfy_dt","vgmVrfyDt");
		this.hashFields.put("vgm_wgt", "vgmWgt");
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
	 * @return psaVslNm
	 */
	public String getPsaVslNm() {
		return this.psaVslNm;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cop
	 */
	public String getCop() {
		return this.cop;
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
	 * @return nextSkdDirCd
	 */
	public String getNextSkdDirCd() {
		return this.nextSkdDirCd;
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
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
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
	 * @return batchNo
	 */
	public String getBatchNo() {
		return this.batchNo;
	}
	
	/**
	 * Column Info
	 * @return receiverId
	 */
	public String getReceiverId() {
		return this.receiverId;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return udtFlag
	 */
	public String getUdtFlag() {
		return this.udtFlag;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return fmCd
	 */
	public String getFmCd() {
		return this.fmCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return spc
	 */
	public String getSpc() {
		return this.spc;
	}
	
	/**
	 * Column Info
	 * @return nextSkdVoyNo
	 */
	public String getNextSkdVoyNo() {
		return this.nextSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return psaVoyDirCd
	 */
	public String getPsaVoyDirCd() {
		return this.psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return nextVslCd
	 */
	public String getNextVslCd() {
		return this.nextVslCd;
	}
	
	/**
	 * Column Info
	 * @return iop
	 */
	public String getIop() {
		return this.iop;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return sav
	 */
	public String getSav() {
		return this.sav;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	
	/**
	 * Column Info
	 * @return oop
	 */
	public String getOop() {
		return this.oop;
	}
	
	/**
	 * Column Info
	 * @return vgmInd
	 */
	public String getVgmInd() {
		return this.vgmInd;
	}
	
	/**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
	public String getVgmMethod() {
		return this.vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfySigCtnt
	 */
	public String getVgmVrfySigCtnt() {
		return this.vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @return vgmRefNo
	 */
	public String getVgmRefNo() {
		return this.vgmRefNo;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
	}

	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
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
	 * @param psaVslNm
	 */
	public void setPsaVslNm(String psaVslNm) {
		this.psaVslNm = psaVslNm;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cop
	 */
	public void setCop(String cop) {
		this.cop = cop;
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
	 * @param nextSkdDirCd
	 */
	public void setNextSkdDirCd(String nextSkdDirCd) {
		this.nextSkdDirCd = nextSkdDirCd;
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
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
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
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	/**
	 * Column Info
	 * @param receiverId
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param udtFlag
	 */
	public void setUdtFlag(String udtFlag) {
		this.udtFlag = udtFlag;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param fmCd
	 */
	public void setFmCd(String fmCd) {
		this.fmCd = fmCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param spc
	 */
	public void setSpc(String spc) {
		this.spc = spc;
	}
	
	/**
	 * Column Info
	 * @param nextSkdVoyNo
	 */
	public void setNextSkdVoyNo(String nextSkdVoyNo) {
		this.nextSkdVoyNo = nextSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param psaVoyDirCd
	 */
	public void setPsaVoyDirCd(String psaVoyDirCd) {
		this.psaVoyDirCd = psaVoyDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param nextVslCd
	 */
	public void setNextVslCd(String nextVslCd) {
		this.nextVslCd = nextVslCd;
	}
	
	/**
	 * Column Info
	 * @param iop
	 */
	public void setIop(String iop) {
		this.iop = iop;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param sav
	 */
	public void setSav(String sav) {
		this.sav = sav;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	
	/**
	 * Column Info
	 * @param oop
	 */
	public void setOop(String oop) {
		this.oop = oop;
	}
	
	/**
	 * Column Info
	 * @param vgmInd
	 */
	public void setVgmInd(String vgmInd) {
		this.vgmInd = vgmInd;
	}
	
	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMethod(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfySigCtnt
	 */
	public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
		this.vgmVrfySigCtnt = vgmVrfySigCtnt;
	}
	
	/**
	 * Column Info
	 * @param vgmRefNo
	 */
	public void setVgmRefNo(String vgmRefNo) {
		this.vgmRefNo = vgmRefNo;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
	}	
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPsaVslNm(JSPUtil.getParameter(request, "psa_vsl_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setCop(JSPUtil.getParameter(request, "cop", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setNextSkdDirCd(JSPUtil.getParameter(request, "next_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTsTpCd(JSPUtil.getParameter(request, "ts_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBatchNo(JSPUtil.getParameter(request, "batch_no", ""));
		setReceiverId(JSPUtil.getParameter(request, "receiver_id", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setUdtFlag(JSPUtil.getParameter(request, "udt_flag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setFmCd(JSPUtil.getParameter(request, "fm_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setSpc(JSPUtil.getParameter(request, "spc", ""));
		setNextSkdVoyNo(JSPUtil.getParameter(request, "next_skd_voy_no", ""));
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setPsaVoyDirCd(JSPUtil.getParameter(request, "psa_voy_dir_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setNextVslCd(JSPUtil.getParameter(request, "next_vsl_cd", ""));
		setIop(JSPUtil.getParameter(request, "iop", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSav(JSPUtil.getParameter(request, "sav", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setTypeCd(JSPUtil.getParameter(request, "type_cd", ""));
		setOop(JSPUtil.getParameter(request, "oop", ""));
		setVgmInd(JSPUtil.getParameter(request, "vgm_ind", ""));
		setVgmMethod(JSPUtil.getParameter(request, "vgm_mzd_tp_cd", ""));
		setVgmVrfySigCtnt(JSPUtil.getParameter(request, "vgm_vrfy_sig_ctnt", ""));
		setVgmRefNo(JSPUtil.getParameter(request, "vgm_ref_no", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, "vgm_vrfy_dt", ""));	
		setVgmWgt(JSPUtil.getParameter(request, "vgm_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaImpStsVO[]
	 */
	public PsaImpStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaImpStsVO[]
	 */
	public PsaImpStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaImpStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] cop = (JSPUtil.getParameter(request, prefix	+ "cop", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] nextSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "next_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] batchNo = (JSPUtil.getParameter(request, prefix	+ "batch_no", length));
			String[] receiverId = (JSPUtil.getParameter(request, prefix	+ "receiver_id", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] udtFlag = (JSPUtil.getParameter(request, prefix	+ "udt_flag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] fmCd = (JSPUtil.getParameter(request, prefix	+ "fm_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] spc = (JSPUtil.getParameter(request, prefix	+ "spc", length));
			String[] nextSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "next_skd_voy_no", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] nextVslCd = (JSPUtil.getParameter(request, prefix	+ "next_vsl_cd", length));
			String[] iop = (JSPUtil.getParameter(request, prefix	+ "iop", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sav = (JSPUtil.getParameter(request, prefix	+ "sav", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] oop = (JSPUtil.getParameter(request, prefix	+ "oop", length));
			String[] vgmInd = (JSPUtil.getParameter(request, prefix	+ "vgm_ind", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_sig_ctnt", length));
			String[] vgmRefNo = (JSPUtil.getParameter(request, prefix	+ "vgm_ref_no", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaImpStsVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (cop[i] != null)
					model.setCop(cop[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (nextSkdDirCd[i] != null)
					model.setNextSkdDirCd(nextSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (batchNo[i] != null)
					model.setBatchNo(batchNo[i]);
				if (receiverId[i] != null)
					model.setReceiverId(receiverId[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (udtFlag[i] != null)
					model.setUdtFlag(udtFlag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (fmCd[i] != null)
					model.setFmCd(fmCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (spc[i] != null)
					model.setSpc(spc[i]);
				if (nextSkdVoyNo[i] != null)
					model.setNextSkdVoyNo(nextSkdVoyNo[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (nextVslCd[i] != null)
					model.setNextVslCd(nextVslCd[i]);
				if (iop[i] != null)
					model.setIop(iop[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sav[i] != null)
					model.setSav(sav[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (oop[i] != null)
					model.setOop(oop[i]);
				if (vgmInd[i] != null)
					model.setVgmInd(vgmInd[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMethod(vgmMzdTpCd[i]);
				if (vgmVrfySigCtnt[i] != null)
					model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
				if (vgmRefNo[i] != null)
					model.setVgmRefNo(vgmRefNo[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);		
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaImpStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaImpStsVO[]
	 */
	public PsaImpStsVO[] getPsaImpStsVOs(){
		PsaImpStsVO[] vos = (PsaImpStsVO[])models.toArray(new PsaImpStsVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cop = this.cop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdDirCd = this.nextSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchNo = this.batchNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverId = this.receiverId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udtFlag = this.udtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCd = this.fmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spc = this.spc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdVoyNo = this.nextSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVslCd = this.nextVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iop = this.iop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sav = this.sav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oop = this.oop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmInd = this.vgmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfySigCtnt = this.vgmVrfySigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRefNo = this.vgmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
