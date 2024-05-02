/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaImpStsVO.java
*@FileTitle : MalaysiaImpStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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

public class MalaysiaImpStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaImpStsVO> models = new ArrayList<MalaysiaImpStsVO>();



	private MalaysiaVvdVO malaysiaVvdVO = null;
	private MalaysiaImpStsVO[] malaysiaImpStsInfos = null;
	private List<MalaysiaImpStsVO> listMalaysiaImpStsVO = null;

	/**
	 * @return the malaysiaVvdVO
	 */
	public MalaysiaVvdVO getMalaysiaVvdVO() {
		return malaysiaVvdVO;
	}

	/**
	 * @param malaysiaVvdVO the malaysiaVvdVO to set
	 */
	public void setMalaysiaVvdVO(MalaysiaVvdVO malaysiaVvdVO) {
		this.malaysiaVvdVO = malaysiaVvdVO;
	}

	/**
	 * @return the malaysiaImpStsInfos
	 */
	public MalaysiaImpStsVO[] getMalaysiaImpStsInfos() {
		return malaysiaImpStsInfos;
	}

	/**
	 * @param malaysiaImpStsInfos the malaysiaImpStsInfos to set
	 */
	public void setMalaysiaImpStsInfos(MalaysiaImpStsVO[] malaysiaImpStsInfos) {
		this.malaysiaImpStsInfos = malaysiaImpStsInfos;
	}

	/**
	 * @return the listMalaysiaImpStsVO
	 */
	public List<MalaysiaImpStsVO> getListMalaysiaImpStsVO() {
		return listMalaysiaImpStsVO;
	}

	/**
	 * @param listMalaysiaImpStsVO the listMalaysiaImpStsVO to set
	 */
	public void setListMalaysiaImpStsVO(List<MalaysiaImpStsVO> listMalaysiaImpStsVO) {
		this.listMalaysiaImpStsVO = listMalaysiaImpStsVO;
	}



	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String psaVslNm = null;
	/* Column Info */
	private String cop = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String nextSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
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
	private String dcgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fmCd = null;
	/* Column Info */
	private String ldIns = null;
	/* Column Info */
	private String spc = null;
	/* Column Info */
	private String nextSkdVoyNo = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String delCntrYn = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String psaVoyDirCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String iop = null;
	/* Column Info */
	private String nextVslCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String n3rdPodCd = null;
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
	private String sel = null;
	/* Column Info */
	private String psaCreTpCd = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String oop = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MalaysiaImpStsVO() {}

	public MalaysiaImpStsVO(String ibflag, String pagerows, String awkCgoFlg, String batchNo, String bbCgoFlg, String bkgNo, String cntrNo, String cntrTpszCd, String cntrWgt, String cop, String dcgoFlg, String delCntrYn, String fmCd, String iop, String ldIns, String n1stPodCd, String n2ndPodCd, String n3rdPodCd, String nextSkdDirCd, String nextSkdVoyNo, String nextVslCd, String oop, String podCd, String polCd, String psaCreTpCd, String psaVoyDirCd, String psaVslNm, String rcFlg, String rdCgoFlg, String receiverId, String sav, String sealNo, String sel, String skdDirCd, String skdVoyNo, String sndDt, String spc, String tsTpCd, String typeCd, String udtFlag, String userId, String vgmWgt, String vslCd) {
		this.vslCd = vslCd;
		this.rdCgoFlg = rdCgoFlg;
		this.psaVslNm = psaVslNm;
		this.cop = cop;
		this.n2ndPodCd = n2ndPodCd;
		this.vgmWgt = vgmWgt;
		this.sndDt = sndDt;
		this.nextSkdDirCd = nextSkdDirCd;
		this.pagerows = pagerows;
		this.tsTpCd = tsTpCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.batchNo = batchNo;
		this.receiverId = receiverId;
		this.bbCgoFlg = bbCgoFlg;
		this.userId = userId;
		this.udtFlag = udtFlag;
		this.dcgoFlg = dcgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.fmCd = fmCd;
		this.ldIns = ldIns;
		this.spc = spc;
		this.nextSkdVoyNo = nextSkdVoyNo;
		this.sealNo = sealNo;
		this.delCntrYn = delCntrYn;
		this.n1stPodCd = n1stPodCd;
		this.psaVoyDirCd = psaVoyDirCd;
		this.cntrWgt = cntrWgt;
		this.iop = iop;
		this.nextVslCd = nextVslCd;
		this.awkCgoFlg = awkCgoFlg;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.n3rdPodCd = n3rdPodCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.sav = sav;
		this.rcFlg = rcFlg;
		this.sel = sel;
		this.psaCreTpCd = psaCreTpCd;
		this.typeCd = typeCd;
		this.oop = oop;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("psa_vsl_nm", getPsaVslNm());
		this.hashColumns.put("cop", getCop());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("next_skd_dir_cd", getNextSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("batch_no", getBatchNo());
		this.hashColumns.put("receiver_id", getReceiverId());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("udt_flag", getUdtFlag());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fm_cd", getFmCd());
		this.hashColumns.put("ld_ins", getLdIns());
		this.hashColumns.put("spc", getSpc());
		this.hashColumns.put("next_skd_voy_no", getNextSkdVoyNo());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("del_cntr_yn", getDelCntrYn());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("psa_voy_dir_cd", getPsaVoyDirCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("iop", getIop());
		this.hashColumns.put("next_vsl_cd", getNextVslCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sav", getSav());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("psa_cre_tp_cd", getPsaCreTpCd());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("oop", getOop());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("psa_vsl_nm", "psaVslNm");
		this.hashFields.put("cop", "cop");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("next_skd_dir_cd", "nextSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("batch_no", "batchNo");
		this.hashFields.put("receiver_id", "receiverId");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("udt_flag", "udtFlag");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fm_cd", "fmCd");
		this.hashFields.put("ld_ins", "ldIns");
		this.hashFields.put("spc", "spc");
		this.hashFields.put("next_skd_voy_no", "nextSkdVoyNo");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("del_cntr_yn", "delCntrYn");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("psa_voy_dir_cd", "psaVoyDirCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("iop", "iop");
		this.hashFields.put("next_vsl_cd", "nextVslCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sav", "sav");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("psa_cre_tp_cd", "psaCreTpCd");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("oop", "oop");
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
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
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
	 * @return cop
	 */
	public String getCop() {
		return this.cop;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return fmCd
	 */
	public String getFmCd() {
		return this.fmCd;
	}
	
	/**
	 * Column Info
	 * @return ldIns
	 */
	public String getLdIns() {
		return this.ldIns;
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
	 * @return delCntrYn
	 */
	public String getDelCntrYn() {
		return this.delCntrYn;
	}
	
	/**
	 * Column Info
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
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
	 * @return iop
	 */
	public String getIop() {
		return this.iop;
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
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
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
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	
	/**
	 * Column Info
	 * @return psaCreTpCd
	 */
	public String getPsaCreTpCd() {
		return this.psaCreTpCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param psaVslNm
	 */
	public void setPsaVslNm(String psaVslNm) {
		this.psaVslNm = psaVslNm;
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
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param fmCd
	 */
	public void setFmCd(String fmCd) {
		this.fmCd = fmCd;
	}
	
	/**
	 * Column Info
	 * @param ldIns
	 */
	public void setLdIns(String ldIns) {
		this.ldIns = ldIns;
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
	 * @param delCntrYn
	 */
	public void setDelCntrYn(String delCntrYn) {
		this.delCntrYn = delCntrYn;
	}
	
	/**
	 * Column Info
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
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
	 * @param iop
	 */
	public void setIop(String iop) {
		this.iop = iop;
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
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
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
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	/**
	 * Column Info
	 * @param psaCreTpCd
	 */
	public void setPsaCreTpCd(String psaCreTpCd) {
		this.psaCreTpCd = psaCreTpCd;
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
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setPsaVslNm(JSPUtil.getParameter(request, prefix + "psa_vsl_nm", ""));
		setCop(JSPUtil.getParameter(request, prefix + "cop", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setNextSkdDirCd(JSPUtil.getParameter(request, prefix + "next_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBatchNo(JSPUtil.getParameter(request, prefix + "batch_no", ""));
		setReceiverId(JSPUtil.getParameter(request, prefix + "receiver_id", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setUdtFlag(JSPUtil.getParameter(request, prefix + "udt_flag", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFmCd(JSPUtil.getParameter(request, prefix + "fm_cd", ""));
		setLdIns(JSPUtil.getParameter(request, prefix + "ld_ins", ""));
		setSpc(JSPUtil.getParameter(request, prefix + "spc", ""));
		setNextSkdVoyNo(JSPUtil.getParameter(request, prefix + "next_skd_voy_no", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setDelCntrYn(JSPUtil.getParameter(request, prefix + "del_cntr_yn", ""));
		setN1stPodCd(JSPUtil.getParameter(request, prefix + "n1st_pod_cd", ""));
		setPsaVoyDirCd(JSPUtil.getParameter(request, prefix + "psa_voy_dir_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setIop(JSPUtil.getParameter(request, prefix + "iop", ""));
		setNextVslCd(JSPUtil.getParameter(request, prefix + "next_vsl_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, prefix + "n3rd_pod_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSav(JSPUtil.getParameter(request, prefix + "sav", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setPsaCreTpCd(JSPUtil.getParameter(request, prefix + "psa_cre_tp_cd", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
		setOop(JSPUtil.getParameter(request, prefix + "oop", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaImpStsVO[]
	 */
	public MalaysiaImpStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaImpStsVO[]
	 */
	public MalaysiaImpStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaImpStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] psaVslNm = (JSPUtil.getParameter(request, prefix	+ "psa_vsl_nm", length));
			String[] cop = (JSPUtil.getParameter(request, prefix	+ "cop", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] nextSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "next_skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] batchNo = (JSPUtil.getParameter(request, prefix	+ "batch_no", length));
			String[] receiverId = (JSPUtil.getParameter(request, prefix	+ "receiver_id", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] udtFlag = (JSPUtil.getParameter(request, prefix	+ "udt_flag", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fmCd = (JSPUtil.getParameter(request, prefix	+ "fm_cd", length));
			String[] ldIns = (JSPUtil.getParameter(request, prefix	+ "ld_ins", length));
			String[] spc = (JSPUtil.getParameter(request, prefix	+ "spc", length));
			String[] nextSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "next_skd_voy_no", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] delCntrYn = (JSPUtil.getParameter(request, prefix	+ "del_cntr_yn", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] psaVoyDirCd = (JSPUtil.getParameter(request, prefix	+ "psa_voy_dir_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] iop = (JSPUtil.getParameter(request, prefix	+ "iop", length));
			String[] nextVslCd = (JSPUtil.getParameter(request, prefix	+ "next_vsl_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sav = (JSPUtil.getParameter(request, prefix	+ "sav", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] psaCreTpCd = (JSPUtil.getParameter(request, prefix	+ "psa_cre_tp_cd", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] oop = (JSPUtil.getParameter(request, prefix	+ "oop", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaImpStsVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (psaVslNm[i] != null)
					model.setPsaVslNm(psaVslNm[i]);
				if (cop[i] != null)
					model.setCop(cop[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (nextSkdDirCd[i] != null)
					model.setNextSkdDirCd(nextSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
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
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fmCd[i] != null)
					model.setFmCd(fmCd[i]);
				if (ldIns[i] != null)
					model.setLdIns(ldIns[i]);
				if (spc[i] != null)
					model.setSpc(spc[i]);
				if (nextSkdVoyNo[i] != null)
					model.setNextSkdVoyNo(nextSkdVoyNo[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (delCntrYn[i] != null)
					model.setDelCntrYn(delCntrYn[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (psaVoyDirCd[i] != null)
					model.setPsaVoyDirCd(psaVoyDirCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (iop[i] != null)
					model.setIop(iop[i]);
				if (nextVslCd[i] != null)
					model.setNextVslCd(nextVslCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
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
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (psaCreTpCd[i] != null)
					model.setPsaCreTpCd(psaCreTpCd[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (oop[i] != null)
					model.setOop(oop[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaImpStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaImpStsVO[]
	 */
	public MalaysiaImpStsVO[] getMalaysiaImpStsVOs(){
		MalaysiaImpStsVO[] vos = (MalaysiaImpStsVO[])models.toArray(new MalaysiaImpStsVO[models.size()]);
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
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVslNm = this.psaVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cop = this.cop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdDirCd = this.nextSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchNo = this.batchNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverId = this.receiverId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udtFlag = this.udtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCd = this.fmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldIns = this.ldIns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spc = this.spc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextSkdVoyNo = this.nextSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntrYn = this.delCntrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaVoyDirCd = this.psaVoyDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iop = this.iop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVslCd = this.nextVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sav = this.sav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaCreTpCd = this.psaCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oop = this.oop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
