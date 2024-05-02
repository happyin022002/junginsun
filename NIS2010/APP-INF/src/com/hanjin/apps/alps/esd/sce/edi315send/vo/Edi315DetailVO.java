/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315DetailVO.java
*@FileTitle : Edi315DetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.06.08 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

import java.util.List;
import com.hanjin.syscommon.common.table.SceFltFileMsgDtlVslVO;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315DetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	
	private Collection<Edi315DetailVO> models = new ArrayList<Edi315DetailVO>();
	
	private List<SceFltFileMsgDtlVslVO> vslInfo = null;
	public void setVslInfo(List<SceFltFileMsgDtlVslVO> vslInfo){
		this.vslInfo = vslInfo;
	}	
	public List<SceFltFileMsgDtlVslVO> getVslInfo(){
		return this.vslInfo;
	}
	/* Column Info */
	private String ediCntrSndTpCd = null;
	/* Column Info */
	private String ediVslTpCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String preRly = null;
	/* Column Info */
	private String toDir = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String coDivCd = null;
	/* Column Info */
	private String toVsl = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custTpId = null;
	/* Column Info */
	private String orgDestCntDesc = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String ediAutoSndFlg = null;
	/* Column Info */
	private String rsltFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String postRly = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String destConti = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String sndSkipFlg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String destCntDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ediEvntCd = null;
	/* Column Info */
	private String ediCgoRmk = null;
	/* Column Info */
	private String ediSndRsltRmk = null;
	/* Column Info */
	private String destContiDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgEdiSts = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String orgConti = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rcvDtlSeq = null;
	/* Column Info */
	private String logFlg = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String ediRmk3 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ediRmk2 = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String ediRmk1 = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String ediSndItvalHrmnt = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String toVoyage = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgCreTpCd = null;
	/* Column Info */
	private String orgContiDesc = null;
	/* Column Info */
	private String copRailChkCd = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String hostTpId = null;
	/* Column Info */
	private String stsSndTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315DetailVO() {}

	public Edi315DetailVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String rcvDtlSeq, String ediGrpCd, String hostTpId, String custTpId, String custNo, String orgEdiSts, String logFlg, String ediSts, String custEdiStsCd, String coDivCd, String ediEvntCd, String ediVslTpCd, String ediSndItvalHrmnt, String ediCntrSndTpCd, String orgContiDesc, String orgDestCntDesc, String destContiDesc, String destCntDesc, String ediCgoRmk, String ediAutoSndFlg, String ediRmk1, String ediRmk2, String ediRmk3, String creUsrId, String creDt, String updUsrId, String updDt, String bkgNo, String blNo, String copNo, String cntrNo, String rsltFlg, String ediSndRsltRmk, String sndSkipFlg, String cntrTpszCd, String copRailChkCd, String trunkVvd, String copStsCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String porCd, String polCd, String podCd, String delCd, String scNo, String blTpCd, String toVsl, String toVoyage, String toDir, String preRly, String postRly, String bkgCreTpCd, String orgConti, String destConti, String rcvTermCd, String deTermCd, String dcgoFlg, String vslNm, String vslCntCd, String lloydCd, String stsSndTpCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
		this.ediVslTpCd = ediVslTpCd;
		this.copNo = copNo;
		this.lloydCd = lloydCd;
		this.preRly = preRly;
		this.toDir = toDir;
		this.custEdiStsCd = custEdiStsCd;
		this.coDivCd = coDivCd;
		this.toVsl = toVsl;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.custTpId = custTpId;
		this.orgDestCntDesc = orgDestCntDesc;
		this.polCd = polCd;
		this.scNo = scNo;
		this.rcvDt = rcvDt;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.delNodCd = delNodCd;
		this.ediAutoSndFlg = ediAutoSndFlg;
		this.rsltFlg = rsltFlg;
		this.updUsrId = updUsrId;
		this.postRly = postRly;
		this.ediGrpCd = ediGrpCd;
		this.delCd = delCd;
		this.destConti = destConti;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.sndSkipFlg = sndSkipFlg;
		this.porCd = porCd;
		this.custNo = custNo;
		this.destCntDesc = destCntDesc;
		this.creDt = creDt;
		this.trunkVvd = trunkVvd;
		this.rcvSeq = rcvSeq;
		this.ediEvntCd = ediEvntCd;
		this.ediCgoRmk = ediCgoRmk;
		this.ediSndRsltRmk = ediSndRsltRmk;
		this.destContiDesc = destContiDesc;
		this.ibflag = ibflag;
		this.orgEdiSts = orgEdiSts;
		this.dcgoFlg = dcgoFlg;
		this.orgConti = orgConti;
		this.rcvTermCd = rcvTermCd;
		this.rcvDtlSeq = rcvDtlSeq;
		this.logFlg = logFlg;
		this.vslCntCd = vslCntCd;
		this.ediRmk3 = ediRmk3;
		this.updDt = updDt;
		this.ediRmk2 = ediRmk2;
		this.porNodCd = porNodCd;
		this.ediRmk1 = ediRmk1;
		this.vslNm = vslNm;
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
		this.polNodCd = polNodCd;
		this.toVoyage = toVoyage;
		this.blTpCd = blTpCd;
		this.deTermCd = deTermCd;
		this.bkgCreTpCd = bkgCreTpCd;
		this.orgContiDesc = orgContiDesc;
		this.copRailChkCd = copRailChkCd;
		this.ediSts = ediSts;
		this.cntrNo = cntrNo;
		this.hostTpId = hostTpId;
		this.stsSndTpCd = stsSndTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cntr_snd_tp_cd", getEdiCntrSndTpCd());
		this.hashColumns.put("edi_vsl_tp_cd", getEdiVslTpCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("pre_rly", getPreRly());
		this.hashColumns.put("to_dir", getToDir());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("co_div_cd", getCoDivCd());
		this.hashColumns.put("to_vsl", getToVsl());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_tp_id", getCustTpId());
		this.hashColumns.put("org_dest_cnt_desc", getOrgDestCntDesc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("edi_auto_snd_flg", getEdiAutoSndFlg());
		this.hashColumns.put("rslt_flg", getRsltFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("post_rly", getPostRly());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dest_conti", getDestConti());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("snd_skip_flg", getSndSkipFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("dest_cnt_desc", getDestCntDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("edi_evnt_cd", getEdiEvntCd());
		this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
		this.hashColumns.put("edi_snd_rslt_rmk", getEdiSndRsltRmk());
		this.hashColumns.put("dest_conti_desc", getDestContiDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_edi_sts", getOrgEdiSts());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("org_conti", getOrgConti());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rcv_dtl_seq", getRcvDtlSeq());
		this.hashColumns.put("log_flg", getLogFlg());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("edi_rmk3", getEdiRmk3());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("edi_rmk2", getEdiRmk2());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("edi_rmk1", getEdiRmk1());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("edi_snd_itval_hrmnt", getEdiSndItvalHrmnt());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("to_voyage", getToVoyage());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_cre_tp_cd", getBkgCreTpCd());
		this.hashColumns.put("org_conti_desc", getOrgContiDesc());
		this.hashColumns.put("cop_rail_chk_cd", getCopRailChkCd());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("host_tp_id", getHostTpId());
		this.hashColumns.put("sts_snd_tp_cd", getStsSndTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cntr_snd_tp_cd", "ediCntrSndTpCd");
		this.hashFields.put("edi_vsl_tp_cd", "ediVslTpCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("pre_rly", "preRly");
		this.hashFields.put("to_dir", "toDir");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("co_div_cd", "coDivCd");
		this.hashFields.put("to_vsl", "toVsl");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_tp_id", "custTpId");
		this.hashFields.put("org_dest_cnt_desc", "orgDestCntDesc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("edi_auto_snd_flg", "ediAutoSndFlg");
		this.hashFields.put("rslt_flg", "rsltFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("post_rly", "postRly");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dest_conti", "destConti");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("snd_skip_flg", "sndSkipFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("dest_cnt_desc", "destCntDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("edi_evnt_cd", "ediEvntCd");
		this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
		this.hashFields.put("edi_snd_rslt_rmk", "ediSndRsltRmk");
		this.hashFields.put("dest_conti_desc", "destContiDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_edi_sts", "orgEdiSts");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("org_conti", "orgConti");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rcv_dtl_seq", "rcvDtlSeq");
		this.hashFields.put("log_flg", "logFlg");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("edi_rmk3", "ediRmk3");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("edi_rmk2", "ediRmk2");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("edi_rmk1", "ediRmk1");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("edi_snd_itval_hrmnt", "ediSndItvalHrmnt");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("to_voyage", "toVoyage");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_cre_tp_cd", "bkgCreTpCd");
		this.hashFields.put("org_conti_desc", "orgContiDesc");
		this.hashFields.put("cop_rail_chk_cd", "copRailChkCd");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("host_tp_id", "hostTpId");
		this.hashFields.put("sts_snd_tp_cd", "stsSndTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediCntrSndTpCd
	 */
	public String getEdiCntrSndTpCd() {
		return this.ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediVslTpCd
	 */
	public String getEdiVslTpCd() {
		return this.ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return preRly
	 */
	public String getPreRly() {
		return this.preRly;
	}
	
	/**
	 * Column Info
	 * @return toDir
	 */
	public String getToDir() {
		return this.toDir;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return coDivCd
	 */
	public String getCoDivCd() {
		return this.coDivCd;
	}
	
	/**
	 * Column Info
	 * @return toVsl
	 */
	public String getToVsl() {
		return this.toVsl;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return custTpId
	 */
	public String getCustTpId() {
		return this.custTpId;
	}
	
	/**
	 * Column Info
	 * @return orgDestCntDesc
	 */
	public String getOrgDestCntDesc() {
		return this.orgDestCntDesc;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return ediAutoSndFlg
	 */
	public String getEdiAutoSndFlg() {
		return this.ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @return rsltFlg
	 */
	public String getRsltFlg() {
		return this.rsltFlg;
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
	 * @return postRly
	 */
	public String getPostRly() {
		return this.postRly;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return destConti
	 */
	public String getDestConti() {
		return this.destConti;
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
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return sndSkipFlg
	 */
	public String getSndSkipFlg() {
		return this.sndSkipFlg;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
	}
	
	/**
	 * Column Info
	 * @return destCntDesc
	 */
	public String getDestCntDesc() {
		return this.destCntDesc;
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
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return ediEvntCd
	 */
	public String getEdiEvntCd() {
		return this.ediEvntCd;
	}
	
	/**
	 * Column Info
	 * @return ediCgoRmk
	 */
	public String getEdiCgoRmk() {
		return this.ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @return ediSndRsltRmk
	 */
	public String getEdiSndRsltRmk() {
		return this.ediSndRsltRmk;
	}
	
	/**
	 * Column Info
	 * @return destContiDesc
	 */
	public String getDestContiDesc() {
		return this.destContiDesc;
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
	 * @return orgEdiSts
	 */
	public String getOrgEdiSts() {
		return this.orgEdiSts;
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
	 * @return orgConti
	 */
	public String getOrgConti() {
		return this.orgConti;
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
	 * @return rcvDtlSeq
	 */
	public String getRcvDtlSeq() {
		return this.rcvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return logFlg
	 */
	public String getLogFlg() {
		return this.logFlg;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return ediRmk3
	 */
	public String getEdiRmk3() {
		return this.ediRmk3;
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
	 * @return ediRmk2
	 */
	public String getEdiRmk2() {
		return this.ediRmk2;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return ediRmk1
	 */
	public String getEdiRmk1() {
		return this.ediRmk1;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return ediSndItvalHrmnt
	 */
	public String getEdiSndItvalHrmnt() {
		return this.ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return toVoyage
	 */
	public String getToVoyage() {
		return this.toVoyage;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCreTpCd
	 */
	public String getBkgCreTpCd() {
		return this.bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgContiDesc
	 */
	public String getOrgContiDesc() {
		return this.orgContiDesc;
	}
	
	/**
	 * Column Info
	 * @return copRailChkCd
	 */
	public String getCopRailChkCd() {
		return this.copRailChkCd;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
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
	 * @return hostTpId
	 */
	public String getHostTpId() {
		return this.hostTpId;
	}
	
	/**
	 * Column Info
	 * @return stsSndTpCd
	 */
	public String getStsSndTpCd() {
		return this.stsSndTpCd;
	}
	

	/**
	 * Column Info
	 * @param ediCntrSndTpCd
	 */
	public void setEdiCntrSndTpCd(String ediCntrSndTpCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediVslTpCd
	 */
	public void setEdiVslTpCd(String ediVslTpCd) {
		this.ediVslTpCd = ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param preRly
	 */
	public void setPreRly(String preRly) {
		this.preRly = preRly;
	}
	
	/**
	 * Column Info
	 * @param toDir
	 */
	public void setToDir(String toDir) {
		this.toDir = toDir;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param coDivCd
	 */
	public void setCoDivCd(String coDivCd) {
		this.coDivCd = coDivCd;
	}
	
	/**
	 * Column Info
	 * @param toVsl
	 */
	public void setToVsl(String toVsl) {
		this.toVsl = toVsl;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param custTpId
	 */
	public void setCustTpId(String custTpId) {
		this.custTpId = custTpId;
	}
	
	/**
	 * Column Info
	 * @param orgDestCntDesc
	 */
	public void setOrgDestCntDesc(String orgDestCntDesc) {
		this.orgDestCntDesc = orgDestCntDesc;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
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
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param ediAutoSndFlg
	 */
	public void setEdiAutoSndFlg(String ediAutoSndFlg) {
		this.ediAutoSndFlg = ediAutoSndFlg;
	}
	
	/**
	 * Column Info
	 * @param rsltFlg
	 */
	public void setRsltFlg(String rsltFlg) {
		this.rsltFlg = rsltFlg;
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
	 * @param postRly
	 */
	public void setPostRly(String postRly) {
		this.postRly = postRly;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param destConti
	 */
	public void setDestConti(String destConti) {
		this.destConti = destConti;
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
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param sndSkipFlg
	 */
	public void setSndSkipFlg(String sndSkipFlg) {
		this.sndSkipFlg = sndSkipFlg;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	
	/**
	 * Column Info
	 * @param destCntDesc
	 */
	public void setDestCntDesc(String destCntDesc) {
		this.destCntDesc = destCntDesc;
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
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param ediEvntCd
	 */
	public void setEdiEvntCd(String ediEvntCd) {
		this.ediEvntCd = ediEvntCd;
	}
	
	/**
	 * Column Info
	 * @param ediCgoRmk
	 */
	public void setEdiCgoRmk(String ediCgoRmk) {
		this.ediCgoRmk = ediCgoRmk;
	}
	
	/**
	 * Column Info
	 * @param ediSndRsltRmk
	 */
	public void setEdiSndRsltRmk(String ediSndRsltRmk) {
		this.ediSndRsltRmk = ediSndRsltRmk;
	}
	
	/**
	 * Column Info
	 * @param destContiDesc
	 */
	public void setDestContiDesc(String destContiDesc) {
		this.destContiDesc = destContiDesc;
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
	 * @param orgEdiSts
	 */
	public void setOrgEdiSts(String orgEdiSts) {
		this.orgEdiSts = orgEdiSts;
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
	 * @param orgConti
	 */
	public void setOrgConti(String orgConti) {
		this.orgConti = orgConti;
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
	 * @param rcvDtlSeq
	 */
	public void setRcvDtlSeq(String rcvDtlSeq) {
		this.rcvDtlSeq = rcvDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param logFlg
	 */
	public void setLogFlg(String logFlg) {
		this.logFlg = logFlg;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param ediRmk3
	 */
	public void setEdiRmk3(String ediRmk3) {
		this.ediRmk3 = ediRmk3;
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
	 * @param ediRmk2
	 */
	public void setEdiRmk2(String ediRmk2) {
		this.ediRmk2 = ediRmk2;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param ediRmk1
	 */
	public void setEdiRmk1(String ediRmk1) {
		this.ediRmk1 = ediRmk1;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param ediSndItvalHrmnt
	 */
	public void setEdiSndItvalHrmnt(String ediSndItvalHrmnt) {
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param toVoyage
	 */
	public void setToVoyage(String toVoyage) {
		this.toVoyage = toVoyage;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCreTpCd
	 */
	public void setBkgCreTpCd(String bkgCreTpCd) {
		this.bkgCreTpCd = bkgCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgContiDesc
	 */
	public void setOrgContiDesc(String orgContiDesc) {
		this.orgContiDesc = orgContiDesc;
	}
	
	/**
	 * Column Info
	 * @param copRailChkCd
	 */
	public void setCopRailChkCd(String copRailChkCd) {
		this.copRailChkCd = copRailChkCd;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
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
	 * @param hostTpId
	 */
	public void setHostTpId(String hostTpId) {
		this.hostTpId = hostTpId;
	}
	
	/**
	 * Column Info
	 * @param hostTpId
	 */
	public void setStsSndTpCd(String stsSndTpCd) {
		this.stsSndTpCd = stsSndTpCd;
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
		setEdiCntrSndTpCd(JSPUtil.getParameter(request, prefix + "edi_cntr_snd_tp_cd", ""));
		setEdiVslTpCd(JSPUtil.getParameter(request, prefix + "edi_vsl_tp_cd", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setPreRly(JSPUtil.getParameter(request, prefix + "pre_rly", ""));
		setToDir(JSPUtil.getParameter(request, prefix + "to_dir", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, prefix + "cust_edi_sts_cd", ""));
		setCoDivCd(JSPUtil.getParameter(request, prefix + "co_div_cd", ""));
		setToVsl(JSPUtil.getParameter(request, prefix + "to_vsl", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustTpId(JSPUtil.getParameter(request, prefix + "cust_tp_id", ""));
		setOrgDestCntDesc(JSPUtil.getParameter(request, prefix + "org_dest_cnt_desc", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, prefix + "cop_sts_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setEdiAutoSndFlg(JSPUtil.getParameter(request, prefix + "edi_auto_snd_flg", ""));
		setRsltFlg(JSPUtil.getParameter(request, prefix + "rslt_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPostRly(JSPUtil.getParameter(request, prefix + "post_rly", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setDestConti(JSPUtil.getParameter(request, prefix + "dest_conti", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setSndSkipFlg(JSPUtil.getParameter(request, prefix + "snd_skip_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCustNo(JSPUtil.getParameter(request, prefix + "cust_no", ""));
		setDestCntDesc(JSPUtil.getParameter(request, prefix + "dest_cnt_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setEdiEvntCd(JSPUtil.getParameter(request, prefix + "edi_evnt_cd", ""));
		setEdiCgoRmk(JSPUtil.getParameter(request, prefix + "edi_cgo_rmk", ""));
		setEdiSndRsltRmk(JSPUtil.getParameter(request, prefix + "edi_snd_rslt_rmk", ""));
		setDestContiDesc(JSPUtil.getParameter(request, prefix + "dest_conti_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgEdiSts(JSPUtil.getParameter(request, prefix + "org_edi_sts", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setOrgConti(JSPUtil.getParameter(request, prefix + "org_conti", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setRcvDtlSeq(JSPUtil.getParameter(request, prefix + "rcv_dtl_seq", ""));
		setLogFlg(JSPUtil.getParameter(request, prefix + "log_flg", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setEdiRmk3(JSPUtil.getParameter(request, prefix + "edi_rmk3", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setEdiRmk2(JSPUtil.getParameter(request, prefix + "edi_rmk2", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setEdiRmk1(JSPUtil.getParameter(request, prefix + "edi_rmk1", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setEdiSndItvalHrmnt(JSPUtil.getParameter(request, prefix + "edi_snd_itval_hrmnt", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setToVoyage(JSPUtil.getParameter(request, prefix + "to_voyage", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgCreTpCd(JSPUtil.getParameter(request, prefix + "bkg_cre_tp_cd", ""));
		setOrgContiDesc(JSPUtil.getParameter(request, prefix + "org_conti_desc", ""));
		setCopRailChkCd(JSPUtil.getParameter(request, prefix + "cop_rail_chk_cd", ""));
		setEdiSts(JSPUtil.getParameter(request, prefix + "edi_sts", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setHostTpId(JSPUtil.getParameter(request, prefix + "host_tp_id", ""));
		setHostTpId(JSPUtil.getParameter(request, prefix + "sts_snd_tp_cd", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315DetailVO[]
	 */
	public Edi315DetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315DetailVO[]
	 */
	public Edi315DetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315DetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediCntrSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_cntr_snd_tp_cd", length));
			String[] ediVslTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_tp_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] preRly = (JSPUtil.getParameter(request, prefix	+ "pre_rly", length));
			String[] toDir = (JSPUtil.getParameter(request, prefix	+ "to_dir", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] coDivCd = (JSPUtil.getParameter(request, prefix	+ "co_div_cd", length));
			String[] toVsl = (JSPUtil.getParameter(request, prefix	+ "to_vsl", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custTpId = (JSPUtil.getParameter(request, prefix	+ "cust_tp_id", length));
			String[] orgDestCntDesc = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_desc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] ediAutoSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_auto_snd_flg", length));
			String[] rsltFlg = (JSPUtil.getParameter(request, prefix	+ "rslt_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] postRly = (JSPUtil.getParameter(request, prefix	+ "post_rly", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] destConti = (JSPUtil.getParameter(request, prefix	+ "dest_conti", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] sndSkipFlg = (JSPUtil.getParameter(request, prefix	+ "snd_skip_flg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] destCntDesc = (JSPUtil.getParameter(request, prefix	+ "dest_cnt_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] ediEvntCd = (JSPUtil.getParameter(request, prefix	+ "edi_evnt_cd", length));
			String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] ediSndRsltRmk = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rslt_rmk", length));
			String[] destContiDesc = (JSPUtil.getParameter(request, prefix	+ "dest_conti_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgEdiSts = (JSPUtil.getParameter(request, prefix	+ "org_edi_sts", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] orgConti = (JSPUtil.getParameter(request, prefix	+ "org_conti", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rcvDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_dtl_seq", length));
			String[] logFlg = (JSPUtil.getParameter(request, prefix	+ "log_flg", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] ediRmk3 = (JSPUtil.getParameter(request, prefix	+ "edi_rmk3", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ediRmk2 = (JSPUtil.getParameter(request, prefix	+ "edi_rmk2", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] ediRmk1 = (JSPUtil.getParameter(request, prefix	+ "edi_rmk1", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] ediSndItvalHrmnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hrmnt", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] toVoyage = (JSPUtil.getParameter(request, prefix	+ "to_voyage", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgCreTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_tp_cd", length));
			String[] orgContiDesc = (JSPUtil.getParameter(request, prefix	+ "org_conti_desc", length));
			String[] copRailChkCd = (JSPUtil.getParameter(request, prefix	+ "cop_rail_chk_cd", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] hostTpId = (JSPUtil.getParameter(request, prefix	+ "host_tp_id", length));
			String[] stsSndTpCd = (JSPUtil.getParameter(request, prefix	+ "sts_snd_tp_cd", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new Edi315DetailVO();
				if (ediCntrSndTpCd[i] != null)
					model.setEdiCntrSndTpCd(ediCntrSndTpCd[i]);
				if (ediVslTpCd[i] != null)
					model.setEdiVslTpCd(ediVslTpCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (preRly[i] != null)
					model.setPreRly(preRly[i]);
				if (toDir[i] != null)
					model.setToDir(toDir[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (coDivCd[i] != null)
					model.setCoDivCd(coDivCd[i]);
				if (toVsl[i] != null)
					model.setToVsl(toVsl[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custTpId[i] != null)
					model.setCustTpId(custTpId[i]);
				if (orgDestCntDesc[i] != null)
					model.setOrgDestCntDesc(orgDestCntDesc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (ediAutoSndFlg[i] != null)
					model.setEdiAutoSndFlg(ediAutoSndFlg[i]);
				if (rsltFlg[i] != null)
					model.setRsltFlg(rsltFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (postRly[i] != null)
					model.setPostRly(postRly[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (destConti[i] != null)
					model.setDestConti(destConti[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (sndSkipFlg[i] != null)
					model.setSndSkipFlg(sndSkipFlg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (destCntDesc[i] != null)
					model.setDestCntDesc(destCntDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ediEvntCd[i] != null)
					model.setEdiEvntCd(ediEvntCd[i]);
				if (ediCgoRmk[i] != null)
					model.setEdiCgoRmk(ediCgoRmk[i]);
				if (ediSndRsltRmk[i] != null)
					model.setEdiSndRsltRmk(ediSndRsltRmk[i]);
				if (destContiDesc[i] != null)
					model.setDestContiDesc(destContiDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgEdiSts[i] != null)
					model.setOrgEdiSts(orgEdiSts[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (orgConti[i] != null)
					model.setOrgConti(orgConti[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rcvDtlSeq[i] != null)
					model.setRcvDtlSeq(rcvDtlSeq[i]);
				if (logFlg[i] != null)
					model.setLogFlg(logFlg[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (ediRmk3[i] != null)
					model.setEdiRmk3(ediRmk3[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ediRmk2[i] != null)
					model.setEdiRmk2(ediRmk2[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (ediRmk1[i] != null)
					model.setEdiRmk1(ediRmk1[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (ediSndItvalHrmnt[i] != null)
					model.setEdiSndItvalHrmnt(ediSndItvalHrmnt[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (toVoyage[i] != null)
					model.setToVoyage(toVoyage[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgCreTpCd[i] != null)
					model.setBkgCreTpCd(bkgCreTpCd[i]);
				if (orgContiDesc[i] != null)
					model.setOrgContiDesc(orgContiDesc[i]);
				if (copRailChkCd[i] != null)
					model.setCopRailChkCd(copRailChkCd[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (hostTpId[i] != null)
					model.setHostTpId(hostTpId[i]);
				if (stsSndTpCd[i] != null)
					model.setStsSndTpCd(stsSndTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315DetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315DetailVO[]
	 */
	public Edi315DetailVO[] getEdi315DetailVOs(){
		Edi315DetailVO[] vos = (Edi315DetailVO[])models.toArray(new Edi315DetailVO[models.size()]);
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
		this.ediCntrSndTpCd = this.ediCntrSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslTpCd = this.ediVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRly = this.preRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDir = this.toDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coDivCd = this.coDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVsl = this.toVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpId = this.custTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntDesc = this.orgDestCntDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediAutoSndFlg = this.ediAutoSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltFlg = this.rsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postRly = this.postRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destConti = this.destConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSkipFlg = this.sndSkipFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCntDesc = this.destCntDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEvntCd = this.ediEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCgoRmk = this.ediCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRsltRmk = this.ediSndRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destContiDesc = this.destContiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEdiSts = this.orgEdiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgConti = this.orgConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtlSeq = this.rcvDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logFlg = this.logFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk3 = this.ediRmk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk2 = this.ediRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk1 = this.ediRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHrmnt = this.ediSndItvalHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVoyage = this.toVoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreTpCd = this.bkgCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgContiDesc = this.orgContiDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copRailChkCd = this.copRailChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hostTpId = this.hostTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsSndTpCd = this.stsSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
