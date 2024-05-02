/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoEventVO.java
*@FileTitle : DoEventVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.08.11 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoEventVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoEventVO> models = new ArrayList<DoEventVO>();
	
	/* Column Info */
	private String idaDoVtyDt = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String idaDoDmdtPayTpCd = null;
	/* Column Info */
	private String vnCgoDeCd = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String doPrnRmk = null;
	/* Column Info */
	private String rcvrBizNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String trkrMvmtRefNo = null;
	/* Column Info */
	private String rcvrFaxNo = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String lastRlseStsCd = null;
	/* Column Info */
	private String picNm = null;
	/* Column Info */
	private String rcvrCneeNm = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String nationFlag = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String cgorRmk = null;
	/* Column Info */
	private String trkrNm = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String idaImpGenMfNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ackInd = null;
	/* Column Info */
	private String cstmsRefNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String cstmsAsgnNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String custPrnFlg = null;
	/* Column Info */
	private String doNoSplit = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String selfTrnsFlg = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String rcvrCoNm = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String idaCstmsAsgnLineNo = null;
	/* Column Info */
	private String jpDoSndStsCd = null;
	/* Column Info */
	private String idaCgorOrdYr = null;
	/* Column Info */
	private String cstmsAsgnCtnt = null;
	/* Column Info */
	private String trkrMtyRtnYdCd = null;
	/* Column Info */
	private String cstmsRefCtnt = null;
	/* Column Info */
	private String trkrPhnNo = null;
	/* Column Info */
	private String evntFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoEventVO() {}

	public DoEventVO(String ibflag, String pagerows, String splitFlg, String idaDoVtyDt, String cyOpCd, String idaImpGenMfNo, String creDt, String doHldFlg, String cstmsRefNm, String doCngEvntCd, String idaDoDmdtPayTpCd, String interRmk, String vnCgoDeCd, String rcvrPhnNo, String hblNo, String cstmsAsgnNm, String doPrnRmk, String updUsrId, String rcvrBizNo, String updDt, String doNoSplit, String custPrnFlg, String evntOfcCd, String trkrMvmtRefNo, String rcvrFaxNo, String bkgNoSplit, String selfTrnsFlg, String infoCgoFlg, String rcvrCoNm, String rlseSeq, String idaCstmsAsgnLineNo, String picNm, String rcvrCneeNm, String jpDoSndStsCd, String idaCgorOrdYr, String doNo, String cstmsAsgnCtnt, String bkgNo, String creUsrId, String rcvrEml, String trkrMtyRtnYdCd, String nationFlag, String cstmsRefCtnt, String trkrPhnNo, String cgorRmk, String trkrNm, String evntUsrId, String preCtnt, String crntCtnt, String rlseStsCd, String lastRlseStsCd, String evntFlag, String cntrPrtFlg, String rqstNo, String ackInd) {
		this.idaDoVtyDt = idaDoVtyDt;
		this.rqstNo = rqstNo;
		this.doHldFlg = doHldFlg;
		this.pagerows = pagerows;
		this.idaDoDmdtPayTpCd = idaDoDmdtPayTpCd;
		this.vnCgoDeCd = vnCgoDeCd;
		this.evntUsrId = evntUsrId;
		this.hblNo = hblNo;
		this.doPrnRmk = doPrnRmk;
		this.rcvrBizNo = rcvrBizNo;
		this.updUsrId = updUsrId;
		this.cntrPrtFlg = cntrPrtFlg;
		this.trkrMvmtRefNo = trkrMvmtRefNo;
		this.rcvrFaxNo = rcvrFaxNo;
		this.rlseSeq = rlseSeq;
		this.lastRlseStsCd = lastRlseStsCd;
		this.picNm = picNm;
		this.rcvrCneeNm = rcvrCneeNm;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.rcvrEml = rcvrEml;
		this.nationFlag = nationFlag;
		this.preCtnt = preCtnt;
		this.cgorRmk = cgorRmk;
		this.trkrNm = trkrNm;
		this.splitFlg = splitFlg;
		this.cyOpCd = cyOpCd;
		this.idaImpGenMfNo = idaImpGenMfNo;
		this.creDt = creDt;
		this.ackInd = ackInd;
		this.cstmsRefNm = cstmsRefNm;
		this.ibflag = ibflag;
		this.doCngEvntCd = doCngEvntCd;
		this.interRmk = interRmk;
		this.rcvrPhnNo = rcvrPhnNo;
		this.cstmsAsgnNm = cstmsAsgnNm;
		this.updDt = updDt;
		this.custPrnFlg = custPrnFlg;
		this.doNoSplit = doNoSplit;
		this.evntOfcCd = evntOfcCd;
		this.bkgNoSplit = bkgNoSplit;
		this.selfTrnsFlg = selfTrnsFlg;
		this.infoCgoFlg = infoCgoFlg;
		this.rcvrCoNm = rcvrCoNm;
		this.crntCtnt = crntCtnt;
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
		this.jpDoSndStsCd = jpDoSndStsCd;
		this.idaCgorOrdYr = idaCgorOrdYr;
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
		this.trkrMtyRtnYdCd = trkrMtyRtnYdCd;
		this.cstmsRefCtnt = cstmsRefCtnt;
		this.trkrPhnNo = trkrPhnNo;
		this.evntFlag = evntFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_do_vty_dt", getIdaDoVtyDt());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ida_do_dmdt_pay_tp_cd", getIdaDoDmdtPayTpCd());
		this.hashColumns.put("vn_cgo_de_cd", getVnCgoDeCd());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("do_prn_rmk", getDoPrnRmk());
		this.hashColumns.put("rcvr_biz_no", getRcvrBizNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("trkr_mvmt_ref_no", getTrkrMvmtRefNo());
		this.hashColumns.put("rcvr_fax_no", getRcvrFaxNo());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("last_rlse_sts_cd", getLastRlseStsCd());
		this.hashColumns.put("pic_nm", getPicNm());
		this.hashColumns.put("rcvr_cnee_nm", getRcvrCneeNm());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("nation_flag", getNationFlag());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("cgor_rmk", getCgorRmk());
		this.hashColumns.put("trkr_nm", getTrkrNm());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("ida_imp_gen_mf_no", getIdaImpGenMfNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ack_ind", getAckInd());
		this.hashColumns.put("cstms_ref_nm", getCstmsRefNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("cstms_asgn_nm", getCstmsAsgnNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cust_prn_flg", getCustPrnFlg());
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("self_trns_flg", getSelfTrnsFlg());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("ida_cstms_asgn_line_no", getIdaCstmsAsgnLineNo());
		this.hashColumns.put("jp_do_snd_sts_cd", getJpDoSndStsCd());
		this.hashColumns.put("ida_cgor_ord_yr", getIdaCgorOrdYr());
		this.hashColumns.put("cstms_asgn_ctnt", getCstmsAsgnCtnt());
		this.hashColumns.put("trkr_mty_rtn_yd_cd", getTrkrMtyRtnYdCd());
		this.hashColumns.put("cstms_ref_ctnt", getCstmsRefCtnt());
		this.hashColumns.put("trkr_phn_no", getTrkrPhnNo());
		this.hashColumns.put("evnt_flag", getEvntFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_do_vty_dt", "idaDoVtyDt");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ida_do_dmdt_pay_tp_cd", "idaDoDmdtPayTpCd");
		this.hashFields.put("vn_cgo_de_cd", "vnCgoDeCd");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("do_prn_rmk", "doPrnRmk");
		this.hashFields.put("rcvr_biz_no", "rcvrBizNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("trkr_mvmt_ref_no", "trkrMvmtRefNo");
		this.hashFields.put("rcvr_fax_no", "rcvrFaxNo");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("last_rlse_sts_cd", "lastRlseStsCd");
		this.hashFields.put("pic_nm", "picNm");
		this.hashFields.put("rcvr_cnee_nm", "rcvrCneeNm");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("nation_flag", "nationFlag");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("cgor_rmk", "cgorRmk");
		this.hashFields.put("trkr_nm", "trkrNm");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("ida_imp_gen_mf_no", "idaImpGenMfNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ack_ind", "ackInd");
		this.hashFields.put("cstms_ref_nm", "cstmsRefNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("cstms_asgn_nm", "cstmsAsgnNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cust_prn_flg", "custPrnFlg");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("self_trns_flg", "selfTrnsFlg");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("ida_cstms_asgn_line_no", "idaCstmsAsgnLineNo");
		this.hashFields.put("jp_do_snd_sts_cd", "jpDoSndStsCd");
		this.hashFields.put("ida_cgor_ord_yr", "idaCgorOrdYr");
		this.hashFields.put("cstms_asgn_ctnt", "cstmsAsgnCtnt");
		this.hashFields.put("trkr_mty_rtn_yd_cd", "trkrMtyRtnYdCd");
		this.hashFields.put("cstms_ref_ctnt", "cstmsRefCtnt");
		this.hashFields.put("trkr_phn_no", "trkrPhnNo");
		this.hashFields.put("evnt_flag", "evntFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaDoVtyDt
	 */
	public String getIdaDoVtyDt() {
		return this.idaDoVtyDt;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
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
	 * @return idaDoDmdtPayTpCd
	 */
	public String getIdaDoDmdtPayTpCd() {
		return this.idaDoDmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @return vnCgoDeCd
	 */
	public String getVnCgoDeCd() {
		return this.vnCgoDeCd;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return doPrnRmk
	 */
	public String getDoPrnRmk() {
		return this.doPrnRmk;
	}
	
	/**
	 * Column Info
	 * @return rcvrBizNo
	 */
	public String getRcvrBizNo() {
		return this.rcvrBizNo;
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
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return trkrMvmtRefNo
	 */
	public String getTrkrMvmtRefNo() {
		return this.trkrMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return rcvrFaxNo
	 */
	public String getRcvrFaxNo() {
		return this.rcvrFaxNo;
	}
	
	/**
	 * Column Info
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return lastRlseStsCd
	 */
	public String getLastRlseStsCd() {
		return this.lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @return picNm
	 */
	public String getPicNm() {
		return this.picNm;
	}
	
	/**
	 * Column Info
	 * @return rcvrCneeNm
	 */
	public String getRcvrCneeNm() {
		return this.rcvrCneeNm;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
	}
	
	/**
	 * Column Info
	 * @return nationFlag
	 */
	public String getNationFlag() {
		return this.nationFlag;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
	}
	
	/**
	 * Column Info
	 * @return cgorRmk
	 */
	public String getCgorRmk() {
		return this.cgorRmk;
	}
	
	/**
	 * Column Info
	 * @return trkrNm
	 */
	public String getTrkrNm() {
		return this.trkrNm;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
	}
	
	/**
	 * Column Info
	 * @return idaImpGenMfNo
	 */
	public String getIdaImpGenMfNo() {
		return this.idaImpGenMfNo;
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
	 * @return ackInd
	 */
	public String getAckInd() {
		return this.ackInd;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefNm
	 */
	public String getCstmsRefNm() {
		return this.cstmsRefNm;
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
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return rcvrPhnNo
	 */
	public String getRcvrPhnNo() {
		return this.rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnNm
	 */
	public String getCstmsAsgnNm() {
		return this.cstmsAsgnNm;
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
	 * @return custPrnFlg
	 */
	public String getCustPrnFlg() {
		return this.custPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return selfTrnsFlg
	 */
	public String getSelfTrnsFlg() {
		return this.selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvrCoNm
	 */
	public String getRcvrCoNm() {
		return this.rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return idaCstmsAsgnLineNo
	 */
	public String getIdaCstmsAsgnLineNo() {
		return this.idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @return jpDoSndStsCd
	 */
	public String getJpDoSndStsCd() {
		return this.jpDoSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return idaCgorOrdYr
	 */
	public String getIdaCgorOrdYr() {
		return this.idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @return cstmsAsgnCtnt
	 */
	public String getCstmsAsgnCtnt() {
		return this.cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @return trkrMtyRtnYdCd
	 */
	public String getTrkrMtyRtnYdCd() {
		return this.trkrMtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsRefCtnt
	 */
	public String getCstmsRefCtnt() {
		return this.cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @return trkrPhnNo
	 */
	public String getTrkrPhnNo() {
		return this.trkrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return evntFlag
	 */
	public String getEvntFlag() {
		return this.evntFlag;
	}
	

	/**
	 * Column Info
	 * @param idaDoVtyDt
	 */
	public void setIdaDoVtyDt(String idaDoVtyDt) {
		this.idaDoVtyDt = idaDoVtyDt;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
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
	 * @param idaDoDmdtPayTpCd
	 */
	public void setIdaDoDmdtPayTpCd(String idaDoDmdtPayTpCd) {
		this.idaDoDmdtPayTpCd = idaDoDmdtPayTpCd;
	}
	
	/**
	 * Column Info
	 * @param vnCgoDeCd
	 */
	public void setVnCgoDeCd(String vnCgoDeCd) {
		this.vnCgoDeCd = vnCgoDeCd;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param doPrnRmk
	 */
	public void setDoPrnRmk(String doPrnRmk) {
		this.doPrnRmk = doPrnRmk;
	}
	
	/**
	 * Column Info
	 * @param rcvrBizNo
	 */
	public void setRcvrBizNo(String rcvrBizNo) {
		this.rcvrBizNo = rcvrBizNo;
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
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param trkrMvmtRefNo
	 */
	public void setTrkrMvmtRefNo(String trkrMvmtRefNo) {
		this.trkrMvmtRefNo = trkrMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param rcvrFaxNo
	 */
	public void setRcvrFaxNo(String rcvrFaxNo) {
		this.rcvrFaxNo = rcvrFaxNo;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param lastRlseStsCd
	 */
	public void setLastRlseStsCd(String lastRlseStsCd) {
		this.lastRlseStsCd = lastRlseStsCd;
	}
	
	/**
	 * Column Info
	 * @param picNm
	 */
	public void setPicNm(String picNm) {
		this.picNm = picNm;
	}
	
	/**
	 * Column Info
	 * @param rcvrCneeNm
	 */
	public void setRcvrCneeNm(String rcvrCneeNm) {
		this.rcvrCneeNm = rcvrCneeNm;
	}
	
	/**
	 * Column Info
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}
	
	/**
	 * Column Info
	 * @param nationFlag
	 */
	public void setNationFlag(String nationFlag) {
		this.nationFlag = nationFlag;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param cgorRmk
	 */
	public void setCgorRmk(String cgorRmk) {
		this.cgorRmk = cgorRmk;
	}
	
	/**
	 * Column Info
	 * @param trkrNm
	 */
	public void setTrkrNm(String trkrNm) {
		this.trkrNm = trkrNm;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
	}
	
	/**
	 * Column Info
	 * @param idaImpGenMfNo
	 */
	public void setIdaImpGenMfNo(String idaImpGenMfNo) {
		this.idaImpGenMfNo = idaImpGenMfNo;
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
	 * @param ackInd
	 */
	public void setAckInd(String ackInd) {
		this.ackInd = ackInd;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefNm
	 */
	public void setCstmsRefNm(String cstmsRefNm) {
		this.cstmsRefNm = cstmsRefNm;
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
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param rcvrPhnNo
	 */
	public void setRcvrPhnNo(String rcvrPhnNo) {
		this.rcvrPhnNo = rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnNm
	 */
	public void setCstmsAsgnNm(String cstmsAsgnNm) {
		this.cstmsAsgnNm = cstmsAsgnNm;
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
	 * @param custPrnFlg
	 */
	public void setCustPrnFlg(String custPrnFlg) {
		this.custPrnFlg = custPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param selfTrnsFlg
	 */
	public void setSelfTrnsFlg(String selfTrnsFlg) {
		this.selfTrnsFlg = selfTrnsFlg;
	}
	
	/**
	 * Column Info
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvrCoNm
	 */
	public void setRcvrCoNm(String rcvrCoNm) {
		this.rcvrCoNm = rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}
	
	/**
	 * Column Info
	 * @param idaCstmsAsgnLineNo
	 */
	public void setIdaCstmsAsgnLineNo(String idaCstmsAsgnLineNo) {
		this.idaCstmsAsgnLineNo = idaCstmsAsgnLineNo;
	}
	
	/**
	 * Column Info
	 * @param jpDoSndStsCd
	 */
	public void setJpDoSndStsCd(String jpDoSndStsCd) {
		this.jpDoSndStsCd = jpDoSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param idaCgorOrdYr
	 */
	public void setIdaCgorOrdYr(String idaCgorOrdYr) {
		this.idaCgorOrdYr = idaCgorOrdYr;
	}
	
	/**
	 * Column Info
	 * @param cstmsAsgnCtnt
	 */
	public void setCstmsAsgnCtnt(String cstmsAsgnCtnt) {
		this.cstmsAsgnCtnt = cstmsAsgnCtnt;
	}
	
	/**
	 * Column Info
	 * @param trkrMtyRtnYdCd
	 */
	public void setTrkrMtyRtnYdCd(String trkrMtyRtnYdCd) {
		this.trkrMtyRtnYdCd = trkrMtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsRefCtnt
	 */
	public void setCstmsRefCtnt(String cstmsRefCtnt) {
		this.cstmsRefCtnt = cstmsRefCtnt;
	}
	
	/**
	 * Column Info
	 * @param trkrPhnNo
	 */
	public void setTrkrPhnNo(String trkrPhnNo) {
		this.trkrPhnNo = trkrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param evntFlag
	 */
	public void setEvntFlag(String evntFlag) {
		this.evntFlag = evntFlag;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdaDoVtyDt(JSPUtil.getParameter(request, "ida_do_vty_dt", ""));
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIdaDoDmdtPayTpCd(JSPUtil.getParameter(request, "ida_do_dmdt_pay_tp_cd", ""));
		setVnCgoDeCd(JSPUtil.getParameter(request, "vn_cgo_de_cd", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setHblNo(JSPUtil.getParameter(request, "hbl_no", ""));
		setDoPrnRmk(JSPUtil.getParameter(request, "do_prn_rmk", ""));
		setRcvrBizNo(JSPUtil.getParameter(request, "rcvr_biz_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setTrkrMvmtRefNo(JSPUtil.getParameter(request, "trkr_mvmt_ref_no", ""));
		setRcvrFaxNo(JSPUtil.getParameter(request, "rcvr_fax_no", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setLastRlseStsCd(JSPUtil.getParameter(request, "last_rlse_sts_cd", ""));
		setPicNm(JSPUtil.getParameter(request, "pic_nm", ""));
		setRcvrCneeNm(JSPUtil.getParameter(request, "rcvr_cnee_nm", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRcvrEml(JSPUtil.getParameter(request, "rcvr_eml", ""));
		setNationFlag(JSPUtil.getParameter(request, "nation_flag", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setCgorRmk(JSPUtil.getParameter(request, "cgor_rmk", ""));
		setTrkrNm(JSPUtil.getParameter(request, "trkr_nm", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setCyOpCd(JSPUtil.getParameter(request, "cy_op_cd", ""));
		setIdaImpGenMfNo(JSPUtil.getParameter(request, "ida_imp_gen_mf_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAckInd(JSPUtil.getParameter(request, "ack_ind", ""));
		setCstmsRefNm(JSPUtil.getParameter(request, "cstms_ref_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, "rcvr_phn_no", ""));
		setCstmsAsgnNm(JSPUtil.getParameter(request, "cstms_asgn_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCustPrnFlg(JSPUtil.getParameter(request, "cust_prn_flg", ""));
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setSelfTrnsFlg(JSPUtil.getParameter(request, "self_trns_flg", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, "info_cgo_flg", ""));
		setRcvrCoNm(JSPUtil.getParameter(request, "rcvr_co_nm", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setIdaCstmsAsgnLineNo(JSPUtil.getParameter(request, "ida_cstms_asgn_line_no", ""));
		setJpDoSndStsCd(JSPUtil.getParameter(request, "jp_do_snd_sts_cd", ""));
		setIdaCgorOrdYr(JSPUtil.getParameter(request, "ida_cgor_ord_yr", ""));
		setCstmsAsgnCtnt(JSPUtil.getParameter(request, "cstms_asgn_ctnt", ""));
		setTrkrMtyRtnYdCd(JSPUtil.getParameter(request, "trkr_mty_rtn_yd_cd", ""));
		setCstmsRefCtnt(JSPUtil.getParameter(request, "cstms_ref_ctnt", ""));
		setTrkrPhnNo(JSPUtil.getParameter(request, "trkr_phn_no", ""));
		setEvntFlag(JSPUtil.getParameter(request, "evnt_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoEventVO[]
	 */
	public DoEventVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoEventVO[]
	 */
	public DoEventVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoEventVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaDoVtyDt = (JSPUtil.getParameter(request, prefix	+ "ida_do_vty_dt", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] idaDoDmdtPayTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_do_dmdt_pay_tp_cd", length));
			String[] vnCgoDeCd = (JSPUtil.getParameter(request, prefix	+ "vn_cgo_de_cd", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] doPrnRmk = (JSPUtil.getParameter(request, prefix	+ "do_prn_rmk", length));
			String[] rcvrBizNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_biz_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] trkrMvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "trkr_mvmt_ref_no", length));
			String[] rcvrFaxNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_fax_no", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] lastRlseStsCd = (JSPUtil.getParameter(request, prefix	+ "last_rlse_sts_cd", length));
			String[] picNm = (JSPUtil.getParameter(request, prefix	+ "pic_nm", length));
			String[] rcvrCneeNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_cnee_nm", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] nationFlag = (JSPUtil.getParameter(request, prefix	+ "nation_flag", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] cgorRmk = (JSPUtil.getParameter(request, prefix	+ "cgor_rmk", length));
			String[] trkrNm = (JSPUtil.getParameter(request, prefix	+ "trkr_nm", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] idaImpGenMfNo = (JSPUtil.getParameter(request, prefix	+ "ida_imp_gen_mf_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ackInd = (JSPUtil.getParameter(request, prefix	+ "ack_ind", length));
			String[] cstmsRefNm = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] cstmsAsgnNm = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] custPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cust_prn_flg", length));
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] selfTrnsFlg = (JSPUtil.getParameter(request, prefix	+ "self_trns_flg", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] rcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_co_nm", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] idaCstmsAsgnLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_cstms_asgn_line_no", length));
			String[] jpDoSndStsCd = (JSPUtil.getParameter(request, prefix	+ "jp_do_snd_sts_cd", length));
			String[] idaCgorOrdYr = (JSPUtil.getParameter(request, prefix	+ "ida_cgor_ord_yr", length));
			String[] cstmsAsgnCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_asgn_ctnt", length));
			String[] trkrMtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "trkr_mty_rtn_yd_cd", length));
			String[] cstmsRefCtnt = (JSPUtil.getParameter(request, prefix	+ "cstms_ref_ctnt", length));
			String[] trkrPhnNo = (JSPUtil.getParameter(request, prefix	+ "trkr_phn_no", length));
			String[] evntFlag = (JSPUtil.getParameter(request, prefix	+ "evnt_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoEventVO();
				if (idaDoVtyDt[i] != null)
					model.setIdaDoVtyDt(idaDoVtyDt[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (idaDoDmdtPayTpCd[i] != null)
					model.setIdaDoDmdtPayTpCd(idaDoDmdtPayTpCd[i]);
				if (vnCgoDeCd[i] != null)
					model.setVnCgoDeCd(vnCgoDeCd[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (doPrnRmk[i] != null)
					model.setDoPrnRmk(doPrnRmk[i]);
				if (rcvrBizNo[i] != null)
					model.setRcvrBizNo(rcvrBizNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (trkrMvmtRefNo[i] != null)
					model.setTrkrMvmtRefNo(trkrMvmtRefNo[i]);
				if (rcvrFaxNo[i] != null)
					model.setRcvrFaxNo(rcvrFaxNo[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (lastRlseStsCd[i] != null)
					model.setLastRlseStsCd(lastRlseStsCd[i]);
				if (picNm[i] != null)
					model.setPicNm(picNm[i]);
				if (rcvrCneeNm[i] != null)
					model.setRcvrCneeNm(rcvrCneeNm[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (nationFlag[i] != null)
					model.setNationFlag(nationFlag[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (cgorRmk[i] != null)
					model.setCgorRmk(cgorRmk[i]);
				if (trkrNm[i] != null)
					model.setTrkrNm(trkrNm[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (idaImpGenMfNo[i] != null)
					model.setIdaImpGenMfNo(idaImpGenMfNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ackInd[i] != null)
					model.setAckInd(ackInd[i]);
				if (cstmsRefNm[i] != null)
					model.setCstmsRefNm(cstmsRefNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (cstmsAsgnNm[i] != null)
					model.setCstmsAsgnNm(cstmsAsgnNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (custPrnFlg[i] != null)
					model.setCustPrnFlg(custPrnFlg[i]);
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (selfTrnsFlg[i] != null)
					model.setSelfTrnsFlg(selfTrnsFlg[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (rcvrCoNm[i] != null)
					model.setRcvrCoNm(rcvrCoNm[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (idaCstmsAsgnLineNo[i] != null)
					model.setIdaCstmsAsgnLineNo(idaCstmsAsgnLineNo[i]);
				if (jpDoSndStsCd[i] != null)
					model.setJpDoSndStsCd(jpDoSndStsCd[i]);
				if (idaCgorOrdYr[i] != null)
					model.setIdaCgorOrdYr(idaCgorOrdYr[i]);
				if (cstmsAsgnCtnt[i] != null)
					model.setCstmsAsgnCtnt(cstmsAsgnCtnt[i]);
				if (trkrMtyRtnYdCd[i] != null)
					model.setTrkrMtyRtnYdCd(trkrMtyRtnYdCd[i]);
				if (cstmsRefCtnt[i] != null)
					model.setCstmsRefCtnt(cstmsRefCtnt[i]);
				if (trkrPhnNo[i] != null)
					model.setTrkrPhnNo(trkrPhnNo[i]);
				if (evntFlag[i] != null)
					model.setEvntFlag(evntFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoEventVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoEventVO[]
	 */
	public DoEventVO[] getDoEventVOs(){
		DoEventVO[] vos = (DoEventVO[])models.toArray(new DoEventVO[models.size()]);
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
		this.idaDoVtyDt = this.idaDoVtyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDoDmdtPayTpCd = this.idaDoDmdtPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnCgoDeCd = this.vnCgoDeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doPrnRmk = this.doPrnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrBizNo = this.rcvrBizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkrMvmtRefNo = this.trkrMvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrFaxNo = this.rcvrFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastRlseStsCd = this.lastRlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picNm = this.picNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCneeNm = this.rcvrCneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nationFlag = this.nationFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorRmk = this.cgorRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkrNm = this.trkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaImpGenMfNo = this.idaImpGenMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackInd = this.ackInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefNm = this.cstmsRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnNm = this.cstmsAsgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custPrnFlg = this.custPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfTrnsFlg = this.selfTrnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm = this.rcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCstmsAsgnLineNo = this.idaCstmsAsgnLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoSndStsCd = this.jpDoSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgorOrdYr = this.idaCgorOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAsgnCtnt = this.cstmsAsgnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkrMtyRtnYdCd = this.trkrMtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRefCtnt = this.cstmsRefCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkrPhnNo = this.trkrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntFlag = this.evntFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
