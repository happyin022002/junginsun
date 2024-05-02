/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : CtmCntrMovInfoVO.java
 *@FileTitle : CtmCntrMovInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier :
 *@LastVersion : 1.0
 * 2009.06.30
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class CtmCntrMovInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CtmCntrMovInfoVO> models = new ArrayList<CtmCntrMovInfoVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String descYdCd = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmMsgId = null;
	/* Column Info */
	private String cntrActCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mtyPlnNo = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String cntrEvntDt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	/* Column Info */
	private String pType1 = null;
	/* Column Info */
	private String pType2 = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Colunm Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usaEdiCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CtmCntrMovInfoVO() {}

	public CtmCntrMovInfoVO(String ibflag, String pagerows, String bkgCgoTpCd, String mvmtStsCd, String orgYdCd, String descYdCd, String cnmvSeq, String cnmvSplitNo, String cnmvLvlNo, String cnmvCycNo, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String obCntrFlg, String fcntrFlg, String cntrSealNo, String cntrEvntDt, String bkgNo, String mtyPlnNo, String cntrDmgFlg, String cnmvYr, String cnmvIdNo, String evntDt, String cmMsgId, String cntrSvrId, String cntrActCd, String cntrNo, String rcvTermCd, String chssNo, String cntrTpszCd, String polCd, String podCd, String pType1, String pType2, String mvmtCreTpCd, String mvmtTrspModCd, String crntVslCd, String crntSkdVoyNo, String crntSkdDirCd, String blNo, String creUsrId, String updUsrId, String usrNm, String ofcCd, String usaEdiCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCycNo = cnmvCycNo;
		this.descYdCd = descYdCd;
		this.cnmvSeq = cnmvSeq;
		this.cnmvLvlNo = cnmvLvlNo;
		this.fcntrFlg = fcntrFlg;
		this.cntrSvrId = cntrSvrId;
		this.pagerows = pagerows;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.crntSkdDirCd = crntSkdDirCd;
		this.cnmvSplitNo = cnmvSplitNo;
		this.ibflag = ibflag;
		this.cmMsgId = cmMsgId;
		this.cntrActCd = cntrActCd;
		this.evntDt = evntDt;
		this.orgYdCd = orgYdCd;
		this.obCntrFlg = obCntrFlg;
		this.cnmvIdNo = cnmvIdNo;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.mtyPlnNo = mtyPlnNo;
		this.cntrDmgFlg = cntrDmgFlg;
		this.blNo = blNo;
		this.cntrNo = cntrNo;
		this.trnkVslCd = trnkVslCd;
		this.crntVslCd = crntVslCd;
		this.cntrSealNo = cntrSealNo;
		this.cnmvYr = cnmvYr;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.cntrEvntDt = cntrEvntDt;
		this.rcvTermCd = rcvTermCd;
		this.chssNo = chssNo;
		this.cntrTpszCd = cntrTpszCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.pType1 = pType1;
		this.pType2 = pType2;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.usrNm    = usrNm;
		this.ofcCd    = ofcCd;
		this.usaEdiCd = usaEdiCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("desc_yd_cd", getDescYdCd());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_msg_id", getCmMsgId());
		this.hashColumns.put("cntr_act_cd", getCntrActCd());
		this.hashColumns.put("cnmv_evnt_dt", getEvntDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("cntr_evnt_dt", getCntrEvntDt());
		this.hashColumns.put("rcv_term_Cd", getRcvTermCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("cntr_tpsz_cd", getChssNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cnmv_rmk", getMgstNo());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("p_type1", getPType1());
		this.hashColumns.put("p_type2", getPType2());
		this.hashColumns.put("mvmt_cre_to_cd", getMvmtCreTpCd());
		this.hashColumns.put("mvmt_trsp_mod_cd" , getMvmtTrspModCd());
		this.hashColumns.put("cre_usr_id" , getCreUsrId());
		this.hashColumns.put("upd_usr_id" , getUpdUsrId());
		this.hashColumns.put("usr_nm" , getUsrNm());
		this.hashColumns.put("ofc_cd" , getOfcCd());
		this.hashColumns.put("usa_edi_cd" , getUsaEdiCd());
		return this.hashColumns;

	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("desc_yd_cd", "descYdCd");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_msg_id", "cmMsgId");
		this.hashFields.put("cntr_act_cd", "cntrActCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("cntr_evnt_dt", "cntrEvntDt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("p_type1", "pType1");
		this.hashFields.put("p_type2", "pType2");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("mvmt_trsp_mod_cd", mvmtTrspModCd);
		this.hashFields.put("cre_usr_id" , "creUsrId");
		this.hashFields.put("upd_usr_id" , "updUsrId");
		this.hashFields.put("usr_nm" , "usrNm");
		this.hashFields.put("ofc_cd" , "ofcCd");
		this.hashFields.put("usa_edi_cd" , "usaEdiCd");

		return this.hashFields;

	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getUsrNm() {
		return this.usrNm;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}

	/**
	 * Column Info
	 * @return descYdCd
	 */
	public String getDescYdCd() {
		return this.descYdCd;
	}

	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}

	/**
	 * Column Info
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
	}

	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}

	/**
	 * Column Info
	 * @return cntrSvrId
	 */
	public String getCntrSvrId() {
		return this.cntrSvrId;
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
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
	}
	/**
	 * Column Info
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
	}

	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return cmMsgId
	 */
	public String getCmMsgId() {
		return this.cmMsgId;
	}

	/**
	 * Column Info
	 * @return cntrActCd
	 */
	public String getCntrActCd() {
		return this.cntrActCd;
	}

	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}

	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}

	/**
	 * Column Info
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
	}

	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}

	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}

	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}

	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}

	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
	}
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return cntrEvntDt
	 */
	public String getCntrEvntDt() {
		return this.cntrEvntDt;
	}

	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}

	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}

	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}

	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}

	/**
	 * Column Info
	 * @return pType1
	 */
	public String getPType1() {
		return this.pType1;
	}

	/**
	 * Column Info
	 * @return pType1
	 */
	public String getPType2() {
		return this.pType2;
	}

	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}

	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}

	/**
	 * Column Info
	 * @param descYdCd
	 */
	public void setDescYdCd(String descYdCd) {
		this.descYdCd = descYdCd;
	}

	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}

	/**
	 * Column Info
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
	}

	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}

	/**
	 * Column Info
	 * @param cntrSvrId
	 */
	public void setCntrSvrId(String cntrSvrId) {
		this.cntrSvrId = cntrSvrId;
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
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
	}
	/**
	 * Column Info
	 * @param trnkSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}

	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param cmMsgId
	 */
	public void setCmMsgId(String cmMsgId) {
		this.cmMsgId = cmMsgId;
	}

	/**
	 * Column Info
	 * @param cntrActCd
	 */
	public void setCntrActCd(String cntrActCd) {
		this.cntrActCd = cntrActCd;
	}

	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}

	/**
	 * Column Info
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}

	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}

	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}

	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}

	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}

	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param cntrEvntDt
	 */
	public void setCntrEvntDt(String cntrEvntDt) {
		this.cntrEvntDt = cntrEvntDt;
	}

	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}

	/**
	 * Column Info
	 * @param cntrEvntDt
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}

	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}

	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}

	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}

	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}

	/**
	 * Column Info
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param pType1
	 */
	public void setPType1(String pType1) {
		this.pType1 = pType1;
	}

	/**
	 * Column Info
	 * @param pType2
	 */
	public void setPType2(String pType2) {
		this.pType2 = pType2;
	}

	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}//mvmtTrspModCd

	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setDescYdCd(JSPUtil.getParameter(request, "desc_yd_cd", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, "cnmv_lvl_no", ""));
		setFcntrFlg(JSPUtil.getParameter(request, "fcntr_flg", ""));
		setCntrSvrId(JSPUtil.getParameter(request, "cntr_svr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, "crnt_skd_dir_cd", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmMsgId(JSPUtil.getParameter(request, "cm_msg_id", ""));
		setCntrActCd(JSPUtil.getParameter(request, "cntr_act_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setObCntrFlg(JSPUtil.getParameter(request, "ob_cntr_flg", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, "mty_pln_no", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setCrntVslCd(JSPUtil.getParameter(request, "crnt_vsl_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
		setCrntSkdVoyNo(JSPUtil.getParameter(request, "crnt_skd_voy_no", ""));
		setCntrEvntDt(JSPUtil.getParameter(request, "cntr_evnt_dt", ""));
		setCntrEvntDt(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndrSeq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setCnmvRmk(JSPUtil.getParameter(request, "cnmv_rmk", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, "spcl_cgo_flg", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPType1(JSPUtil.getParameter(request, "p_type1", ""));
		setPType2(JSPUtil.getParameter(request, "p_type2", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, "mvmt_cre_tp_cd", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, "mvmt_trsp_mod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, "usa_edi_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CtmCntrMovInfoVO[]
	 */
	public CtmCntrMovInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CtmCntrMovInfoVO[]
	 */
	public CtmCntrMovInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmCntrMovInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] descYdCd = (JSPUtil.getParameter(request, prefix	+ "desc_yd_cd", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmMsgId = (JSPUtil.getParameter(request, prefix	+ "cm_msg_id", length));
			String[] cntrActCd = (JSPUtil.getParameter(request, prefix	+ "cntr_act_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] cntrEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_evnt_dt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pType1 = (JSPUtil.getParameter(request, prefix	+ "p_type1", length));
			String[] pType2 = (JSPUtil.getParameter(request, prefix	+ "p_type2", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));


			for (int i = 0; i < length; i++) {

				model = new CtmCntrMovInfoVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (descYdCd[i] != null)
					model.setDescYdCd(descYdCd[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (cntrSvrId[i] != null)
					model.setCntrSvrId(cntrSvrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmMsgId[i] != null)
					model.setCmMsgId(cmMsgId[i]);
				if (cntrActCd[i] != null)
					model.setCntrActCd(cntrActCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (cntrEvntDt[i] != null)
					model.setCntrEvntDt(cntrEvntDt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pType1[i] != null)
					model.setPType1(pType1[i]);
				if (pType2[i] != null)
					model.setPType2(pType2[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				models.add(model);

			}

		} catch (Exception e) {
			return null;
		}
		return getCtmCntrMovInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CtmCntrMovInfoVO[]
	 */
	public CtmCntrMovInfoVO[] getCtmCntrMovInfoVOs(){
		CtmCntrMovInfoVO[] vos = (CtmCntrMovInfoVO[])models.toArray(new CtmCntrMovInfoVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descYdCd = this.descYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMsgId = this.cmMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrActCd = this.cntrActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEvntDt = this.cntrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEvntDt = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
