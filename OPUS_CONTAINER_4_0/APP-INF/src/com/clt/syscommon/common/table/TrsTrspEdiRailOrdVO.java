/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TrsTrspEdiRailOrdVO.java
 *@FileTitle : TrsTrspEdiRailOrdVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.30
 *@LastModifier : 박준용
 *@LastVersion : 1.0
 * 2009.09.30 박준용 
 * 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 박준용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsTrspEdiRailOrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TrsTrspEdiRailOrdVO> models = new ArrayList<TrsTrspEdiRailOrdVO>();

	/* Column Info */
	private String bilEdiRcvRsltCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bilIssKnt = null;
	/* Column Info */
	private String railOrdRjctFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String woRjctRsn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String bilEdiRcvRsltFlg = null;
	/* Column Info */
	private String mtcEdiRcvRsltFlg = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cxlRqstRjctRsn = null;
	/* Column Info */
	private String bilIssStsCd = null;
	/* Column Info */
	private String bilEdiRsndDt = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dwUpdDt = null;
	/* Column Info */
	private String bilEdiRsndRcvRsltCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String bilEdiCtrlSeq = null;
	/* Column Info */
	private String cfmMsgSntDt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bilEdiSntDt = null;
	/* Column Info */
	private String cxlRqstDt = null;
	/* Column Info */
	private String bilEdiRcvRsltDt = null;
	/* Column Info */
	private String bilEdiRsndRcvRsltDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mtcEdiIndCd = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String mtcEdiRcvRsltDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String railCmbThruTpCd = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String cndCstmsClrFlg = null;
	/* Column Info */
	private String uplnSoFlg = null;
	/* Column Info */
	private String trspFrstFlg = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TrsTrspEdiRailOrdVO() {
	}

	public TrsTrspEdiRailOrdVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String bilIssKnt, String bilIssStsCd, String bkgNo, String blNo, String bkgCgoTpCd, String vndrSeq, String eqNo, String eqTpszCd, String fmNodCd, String toNodCd, String cxlRqstDt,
			String cxlRqstRjctRsn, String interRmk, String spclInstrRmk, String bilEdiSntDt, String bilEdiRcvRsltFlg, String bilEdiRcvRsltDt, String mtcEdiIndCd, String mtcEdiRcvRsltFlg, String mtcEdiRcvRsltDt, String cfmMsgSntDt, String railOrdRjctFlg, String deltFlg, String creOfcCd,
			String bilEdiCtrlSeq, String bilEdiRcvRsltCd, String woRjctRsn, String bilEdiRsndDt, String bilEdiRsndRcvRsltCd, String bilEdiRsndRcvRsltDt, String dwUpdDt, String creUsrId, String creDt, String updUsrId, String updDt, String loclCreDt, String loclUpdDt, String copNo, String cgoTpCd,
			String repoPlnId, String plnYrwk, String refId, String refSeq, String costActGrpSeq, String railCmbThruTpCd, String fmNodYard, String toNodYard, String trspSoStsCd, String trspBndCd, String cndCstmsClrFlg, String uplnSoFlg, String trspFrstFlg) {
		this.bilEdiRcvRsltCd = bilEdiRcvRsltCd;
		this.toNodCd = toNodCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.deltFlg = deltFlg;
		this.trspSoSeq = trspSoSeq;
		this.creDt = creDt;
		this.bilIssKnt = bilIssKnt;
		this.railOrdRjctFlg = railOrdRjctFlg;
		this.blNo = blNo;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.woRjctRsn = woRjctRsn;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.bilEdiRcvRsltFlg = bilEdiRcvRsltFlg;
		this.mtcEdiRcvRsltFlg = mtcEdiRcvRsltFlg;
		this.interRmk = interRmk;
		this.creOfcCd = creOfcCd;
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
		this.bilIssStsCd = bilIssStsCd;
		this.bilEdiRsndDt = bilEdiRsndDt;
		this.spclInstrRmk = spclInstrRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.dwUpdDt = dwUpdDt;
		this.bilEdiRsndRcvRsltCd = bilEdiRsndRcvRsltCd;
		this.loclCreDt = loclCreDt;
		this.bilEdiCtrlSeq = bilEdiCtrlSeq;
		this.cfmMsgSntDt = cfmMsgSntDt;
		this.eqTpszCd = eqTpszCd;
		this.fmNodCd = fmNodCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.bilEdiSntDt = bilEdiSntDt;
		this.cxlRqstDt = cxlRqstDt;
		this.bilEdiRcvRsltDt = bilEdiRcvRsltDt;
		this.bilEdiRsndRcvRsltDt = bilEdiRsndRcvRsltDt;
		this.vndrSeq = vndrSeq;
		this.mtcEdiIndCd = mtcEdiIndCd;
		this.loclUpdDt = loclUpdDt;
		this.mtcEdiRcvRsltDt = mtcEdiRcvRsltDt;
		this.copNo = copNo;
		this.cgoTpCd = cgoTpCd;
		this.repoPlnId = repoPlnId;
		this.plnYrwk = plnYrwk;
		this.refId = refId;
		this.refSeq = refSeq;
		this.costActGrpSeq = costActGrpSeq;
		this.railCmbThruTpCd = railCmbThruTpCd;
		this.fmNodYard = fmNodYard;
		this.toNodYard = toNodYard;
		this.trspSoStsCd = trspSoStsCd;
		this.trspBndCd = trspBndCd;
		this.cndCstmsClrFlg = cndCstmsClrFlg;
		this.uplnSoFlg = uplnSoFlg;
		this.trspFrstFlg = trspFrstFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("bil_edi_rcv_rslt_cd", getBilEdiRcvRsltCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bil_iss_knt", getBilIssKnt());
		this.hashColumns.put("rail_ord_rjct_flg", getRailOrdRjctFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wo_rjct_rsn", getWoRjctRsn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("bil_edi_rcv_rslt_flg", getBilEdiRcvRsltFlg());
		this.hashColumns.put("mtc_edi_rcv_rslt_flg", getMtcEdiRcvRsltFlg());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cxl_rqst_rjct_rsn", getCxlRqstRjctRsn());
		this.hashColumns.put("bil_iss_sts_cd", getBilIssStsCd());
		this.hashColumns.put("bil_edi_rsnd_dt", getBilEdiRsndDt());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dw_upd_dt", getDwUpdDt());
		this.hashColumns.put("bil_edi_rsnd_rcv_rslt_cd", getBilEdiRsndRcvRsltCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("bil_edi_ctrl_seq", getBilEdiCtrlSeq());
		this.hashColumns.put("cfm_msg_snt_dt", getCfmMsgSntDt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bil_edi_snt_dt", getBilEdiSntDt());
		this.hashColumns.put("cxl_rqst_dt", getCxlRqstDt());
		this.hashColumns.put("bil_edi_rcv_rslt_dt", getBilEdiRcvRsltDt());
		this.hashColumns.put("bil_edi_rsnd_rcv_rslt_dt", getBilEdiRsndRcvRsltDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mtc_edi_ind_cd", getMtcEdiIndCd());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("mtc_edi_rcv_rslt_dt", getMtcEdiRcvRsltDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("rail_cmb_thru_tp_cd", getRailCmbThruTpCd());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("cnd_cstms_clr_flg", getCndCstmsClrFlg());
		this.hashColumns.put("upln_so_flg", getUplnSoFlg());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("bil_edi_rcv_rslt_cd", "bilEdiRcvRsltCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bil_iss_knt", "bilIssKnt");
		this.hashFields.put("rail_ord_rjct_flg", "railOrdRjctFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wo_rjct_rsn", "woRjctRsn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("bil_edi_rcv_rslt_flg", "bilEdiRcvRsltFlg");
		this.hashFields.put("mtc_edi_rcv_rslt_flg", "mtcEdiRcvRsltFlg");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cxl_rqst_rjct_rsn", "cxlRqstRjctRsn");
		this.hashFields.put("bil_iss_sts_cd", "bilIssStsCd");
		this.hashFields.put("bil_edi_rsnd_dt", "bilEdiRsndDt");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dw_upd_dt", "dwUpdDt");
		this.hashFields.put("bil_edi_rsnd_rcv_rslt_cd", "bilEdiRsndRcvRsltCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("bil_edi_ctrl_seq", "bilEdiCtrlSeq");
		this.hashFields.put("cfm_msg_snt_dt", "cfmMsgSntDt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bil_edi_snt_dt", "bilEdiSntDt");
		this.hashFields.put("cxl_rqst_dt", "cxlRqstDt");
		this.hashFields.put("bil_edi_rcv_rslt_dt", "bilEdiRcvRsltDt");
		this.hashFields.put("bil_edi_rsnd_rcv_rslt_dt", "bilEdiRsndRcvRsltDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mtc_edi_ind_cd", "mtcEdiIndCd");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("mtc_edi_rcv_rslt_dt", "mtcEdiRcvRsltDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("rail_cmb_thru_tp_cd", "railCmbThruTpCd");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("cnd_cstms_clr_flg", "cndCstmsClrFlg");
		this.hashFields.put("upln_so_flg", "uplnSoFlg");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRcvRsltCd
	 */
	public String getBilEdiRcvRsltCd() {
		return this.bilEdiRcvRsltCd;
	}

	/**
	 * Column Info
	 * 
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilIssKnt
	 */
	public String getBilIssKnt() {
		return this.bilIssKnt;
	}

	/**
	 * Column Info
	 * 
	 * @return railOrdRjctFlg
	 */
	public String getRailOrdRjctFlg() {
		return this.railOrdRjctFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return woRjctRsn
	 */
	public String getWoRjctRsn() {
		return this.woRjctRsn;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRcvRsltFlg
	 */
	public String getBilEdiRcvRsltFlg() {
		return this.bilEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiRcvRsltFlg
	 */
	public String getMtcEdiRcvRsltFlg() {
		return this.mtcEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRjctRsn
	 */
	public String getCxlRqstRjctRsn() {
		return this.cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @return bilIssStsCd
	 */
	public String getBilIssStsCd() {
		return this.bilIssStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRsndDt
	 */
	public String getBilEdiRsndDt() {
		return this.bilEdiRsndDt;
	}

	/**
	 * Column Info
	 * 
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return dwUpdDt
	 */
	public String getDwUpdDt() {
		return this.dwUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRsndRcvRsltCd
	 */
	public String getBilEdiRsndRcvRsltCd() {
		return this.bilEdiRsndRcvRsltCd;
	}

	/**
	 * Column Info
	 * 
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiCtrlSeq
	 */
	public String getBilEdiCtrlSeq() {
		return this.bilEdiCtrlSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cfmMsgSntDt
	 */
	public String getCfmMsgSntDt() {
		return this.cfmMsgSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiSntDt
	 */
	public String getBilEdiSntDt() {
		return this.bilEdiSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstDt
	 */
	public String getCxlRqstDt() {
		return this.cxlRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRcvRsltDt
	 */
	public String getBilEdiRcvRsltDt() {
		return this.bilEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilEdiRsndRcvRsltDt
	 */
	public String getBilEdiRsndRcvRsltDt() {
		return this.bilEdiRsndRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiIndCd
	 */
	public String getMtcEdiIndCd() {
		return this.mtcEdiIndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return mtcEdiRcvRsltDt
	 */
	public String getMtcEdiRcvRsltDt() {
		return this.mtcEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @return copNo
	 */
	public String getCopNo() {
		return copNo;
	}

	/**
	 * Column Info
	 * 
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return cgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @return refId
	 */
	public String getRefId() {
		return refId;
	}

	/**
	 * Column Info
	 * 
	 * @return refSeq
	 */
	public String getRefSeq() {
		return refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return railCmbThruTpCd
	 */
	public String getRailCmbThruTpCd() {
		return railCmbThruTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodYard
	 */
	public String getFmNodYard() {
		return fmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodYard
	 */
	public String getToNodYard() {
		return toNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return trspSoStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspBndCd
	 */
	public String getTrspBndCd() {
		return trspBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRcvRsltCd
	 */
	public void setBilEdiRcvRsltCd(String bilEdiRcvRsltCd) {
		this.bilEdiRcvRsltCd = bilEdiRcvRsltCd;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilIssKnt
	 */
	public void setBilIssKnt(String bilIssKnt) {
		this.bilIssKnt = bilIssKnt;
	}

	/**
	 * Column Info
	 * 
	 * @param railOrdRjctFlg
	 */
	public void setRailOrdRjctFlg(String railOrdRjctFlg) {
		this.railOrdRjctFlg = railOrdRjctFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param woRjctRsn
	 */
	public void setWoRjctRsn(String woRjctRsn) {
		this.woRjctRsn = woRjctRsn;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRcvRsltFlg
	 */
	public void setBilEdiRcvRsltFlg(String bilEdiRcvRsltFlg) {
		this.bilEdiRcvRsltFlg = bilEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiRcvRsltFlg
	 */
	public void setMtcEdiRcvRsltFlg(String mtcEdiRcvRsltFlg) {
		this.mtcEdiRcvRsltFlg = mtcEdiRcvRsltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRjctRsn
	 */
	public void setCxlRqstRjctRsn(String cxlRqstRjctRsn) {
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @param bilIssStsCd
	 */
	public void setBilIssStsCd(String bilIssStsCd) {
		this.bilIssStsCd = bilIssStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRsndDt
	 */
	public void setBilEdiRsndDt(String bilEdiRsndDt) {
		this.bilEdiRsndDt = bilEdiRsndDt;
	}

	/**
	 * Column Info
	 * 
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param dwUpdDt
	 */
	public void setDwUpdDt(String dwUpdDt) {
		this.dwUpdDt = dwUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRsndRcvRsltCd
	 */
	public void setBilEdiRsndRcvRsltCd(String bilEdiRsndRcvRsltCd) {
		this.bilEdiRsndRcvRsltCd = bilEdiRsndRcvRsltCd;
	}

	/**
	 * Column Info
	 * 
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiCtrlSeq
	 */
	public void setBilEdiCtrlSeq(String bilEdiCtrlSeq) {
		this.bilEdiCtrlSeq = bilEdiCtrlSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cfmMsgSntDt
	 */
	public void setCfmMsgSntDt(String cfmMsgSntDt) {
		this.cfmMsgSntDt = cfmMsgSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiSntDt
	 */
	public void setBilEdiSntDt(String bilEdiSntDt) {
		this.bilEdiSntDt = bilEdiSntDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstDt
	 */
	public void setCxlRqstDt(String cxlRqstDt) {
		this.cxlRqstDt = cxlRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRcvRsltDt
	 */
	public void setBilEdiRcvRsltDt(String bilEdiRcvRsltDt) {
		this.bilEdiRcvRsltDt = bilEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilEdiRsndRcvRsltDt
	 */
	public void setBilEdiRsndRcvRsltDt(String bilEdiRsndRcvRsltDt) {
		this.bilEdiRsndRcvRsltDt = bilEdiRsndRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiIndCd
	 */
	public void setMtcEdiIndCd(String mtcEdiIndCd) {
		this.mtcEdiIndCd = mtcEdiIndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param mtcEdiRcvRsltDt
	 */
	public void setMtcEdiRcvRsltDt(String mtcEdiRcvRsltDt) {
		this.mtcEdiRcvRsltDt = mtcEdiRcvRsltDt;
	}

	/**
	 * Column Info
	 * 
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * Column Info
	 * 
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * Column Info
	 * 
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param railCmbThruTpCd
	 */
	public void setRailCmbThruTpCd(String railCmbThruTpCd) {
		this.railCmbThruTpCd = railCmbThruTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getCndCstmsClrFlg() {
		return cndCstmsClrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cndCstmsClrFlg
	 */
	public void setCndCstmsClrFlg(String cndCstmsClrFlg) {
		this.cndCstmsClrFlg = cndCstmsClrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return uplnSoFlg
	 */
	public String getUplnSoFlg() {
		return uplnSoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param uplnSoFlg
	 */
	public void setUplnSoFlg(String uplnSoFlg) {
		this.uplnSoFlg = uplnSoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return trspFrstFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBilEdiRcvRsltCd(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_cd", ""));
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBilIssKnt(JSPUtil.getParameter(request, "bil_iss_knt", ""));
		setRailOrdRjctFlg(JSPUtil.getParameter(request, "rail_ord_rjct_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWoRjctRsn(JSPUtil.getParameter(request, "wo_rjct_rsn", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setBilEdiRcvRsltFlg(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_flg", ""));
		setMtcEdiRcvRsltFlg(JSPUtil.getParameter(request, "mtc_edi_rcv_rslt_flg", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCxlRqstRjctRsn(JSPUtil.getParameter(request, "cxl_rqst_rjct_rsn", ""));
		setBilIssStsCd(JSPUtil.getParameter(request, "bil_iss_sts_cd", ""));
		setBilEdiRsndDt(JSPUtil.getParameter(request, "bil_edi_rsnd_dt", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, "spcl_instr_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDwUpdDt(JSPUtil.getParameter(request, "dw_upd_dt", ""));
		setBilEdiRsndRcvRsltCd(JSPUtil.getParameter(request, "bil_edi_rsnd_rcv_rslt_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, "locl_cre_dt", ""));
		setBilEdiCtrlSeq(JSPUtil.getParameter(request, "bil_edi_ctrl_seq", ""));
		setCfmMsgSntDt(JSPUtil.getParameter(request, "cfm_msg_snt_dt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBilEdiSntDt(JSPUtil.getParameter(request, "bil_edi_snt_dt", ""));
		setCxlRqstDt(JSPUtil.getParameter(request, "cxl_rqst_dt", ""));
		setBilEdiRcvRsltDt(JSPUtil.getParameter(request, "bil_edi_rcv_rslt_dt", ""));
		setBilEdiRsndRcvRsltDt(JSPUtil.getParameter(request, "bil_edi_rsnd_rcv_rslt_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setMtcEdiIndCd(JSPUtil.getParameter(request, "mtc_edi_ind_cd", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, "locl_upd_dt", ""));
		setMtcEdiRcvRsltDt(JSPUtil.getParameter(request, "mtc_edi_rcv_rslt_dt", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setRailCmbThruTpCd(JSPUtil.getParameter(request, "rail_cmb_thru_tp_cd", ""));
		setFmNodYard(JSPUtil.getParameter(request, "fm_nod_yard", ""));
		setToNodYard(JSPUtil.getParameter(request, "to_nod_yard", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setCndCstmsClrFlg(JSPUtil.getParameter(request, "cnd_cstms_clr_flg", ""));
		setUplnSoFlg(JSPUtil.getParameter(request, "upln_so_flg", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, "trsp_frst_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return TrsTrspEdiRailOrdVO[]
	 */
	public TrsTrspEdiRailOrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return TrsTrspEdiRailOrdVO[]
	 */
	public TrsTrspEdiRailOrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsTrspEdiRailOrdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bilEdiRcvRsltCd = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix + "to_nod_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] bilIssKnt = (JSPUtil.getParameter(request, prefix + "bil_iss_knt", length));
			String[] railOrdRjctFlg = (JSPUtil.getParameter(request, prefix + "rail_ord_rjct_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] woRjctRsn = (JSPUtil.getParameter(request, prefix + "wo_rjct_rsn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
			String[] bilEdiRcvRsltFlg = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_flg", length));
			String[] mtcEdiRcvRsltFlg = (JSPUtil.getParameter(request, prefix + "mtc_edi_rcv_rslt_flg", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] cxlRqstRjctRsn = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rjct_rsn", length));
			String[] bilIssStsCd = (JSPUtil.getParameter(request, prefix + "bil_iss_sts_cd", length));
			String[] bilEdiRsndDt = (JSPUtil.getParameter(request, prefix + "bil_edi_rsnd_dt", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] dwUpdDt = (JSPUtil.getParameter(request, prefix + "dw_upd_dt", length));
			String[] bilEdiRsndRcvRsltCd = (JSPUtil.getParameter(request, prefix + "bil_edi_rsnd_rcv_rslt_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix + "locl_cre_dt", length));
			String[] bilEdiCtrlSeq = (JSPUtil.getParameter(request, prefix + "bil_edi_ctrl_seq", length));
			String[] cfmMsgSntDt = (JSPUtil.getParameter(request, prefix + "cfm_msg_snt_dt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix + "fm_nod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] bilEdiSntDt = (JSPUtil.getParameter(request, prefix + "bil_edi_snt_dt", length));
			String[] cxlRqstDt = (JSPUtil.getParameter(request, prefix + "cxl_rqst_dt", length));
			String[] bilEdiRcvRsltDt = (JSPUtil.getParameter(request, prefix + "bil_edi_rcv_rslt_dt", length));
			String[] bilEdiRsndRcvRsltDt = (JSPUtil.getParameter(request, prefix + "bil_edi_rsnd_rcv_rslt_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
			String[] mtcEdiIndCd = (JSPUtil.getParameter(request, prefix + "mtc_edi_ind_cd", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix + "locl_upd_dt", length));
			String[] mtcEdiRcvRsltDt = (JSPUtil.getParameter(request, prefix + "mtc_edi_rcv_rslt_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix + "cgo_tp_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix + "repo_pln_id", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix + "pln_yrwk", length));
			String[] refId = (JSPUtil.getParameter(request, prefix + "ref_id", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix + "ref_seq", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", length));
			String[] railCmbThruTpCd = (JSPUtil.getParameter(request, prefix + "rail_cmb_thru_tp_cd", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix + "fm_nod_yard", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix + "to_nod_yard", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", length));
			String[] cndCstmsClrFlg = (JSPUtil.getParameter(request, prefix + "cnd_cstms_clr_flg", length));
			String[] uplnSoFlg = (JSPUtil.getParameter(request, prefix + "upln_so_flg", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix + "trsp_frst_flg", length));

			for (int i = 0; i < length; i++) {
				model = new TrsTrspEdiRailOrdVO();
				if (bilEdiRcvRsltCd[i] != null)
					model.setBilEdiRcvRsltCd(bilEdiRcvRsltCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bilIssKnt[i] != null)
					model.setBilIssKnt(bilIssKnt[i]);
				if (railOrdRjctFlg[i] != null)
					model.setRailOrdRjctFlg(railOrdRjctFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (woRjctRsn[i] != null)
					model.setWoRjctRsn(woRjctRsn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (bilEdiRcvRsltFlg[i] != null)
					model.setBilEdiRcvRsltFlg(bilEdiRcvRsltFlg[i]);
				if (mtcEdiRcvRsltFlg[i] != null)
					model.setMtcEdiRcvRsltFlg(mtcEdiRcvRsltFlg[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cxlRqstRjctRsn[i] != null)
					model.setCxlRqstRjctRsn(cxlRqstRjctRsn[i]);
				if (bilIssStsCd[i] != null)
					model.setBilIssStsCd(bilIssStsCd[i]);
				if (bilEdiRsndDt[i] != null)
					model.setBilEdiRsndDt(bilEdiRsndDt[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dwUpdDt[i] != null)
					model.setDwUpdDt(dwUpdDt[i]);
				if (bilEdiRsndRcvRsltCd[i] != null)
					model.setBilEdiRsndRcvRsltCd(bilEdiRsndRcvRsltCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (bilEdiCtrlSeq[i] != null)
					model.setBilEdiCtrlSeq(bilEdiCtrlSeq[i]);
				if (cfmMsgSntDt[i] != null)
					model.setCfmMsgSntDt(cfmMsgSntDt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bilEdiSntDt[i] != null)
					model.setBilEdiSntDt(bilEdiSntDt[i]);
				if (cxlRqstDt[i] != null)
					model.setCxlRqstDt(cxlRqstDt[i]);
				if (bilEdiRcvRsltDt[i] != null)
					model.setBilEdiRcvRsltDt(bilEdiRcvRsltDt[i]);
				if (bilEdiRsndRcvRsltDt[i] != null)
					model.setBilEdiRsndRcvRsltDt(bilEdiRsndRcvRsltDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mtcEdiIndCd[i] != null)
					model.setMtcEdiIndCd(mtcEdiIndCd[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (mtcEdiRcvRsltDt[i] != null)
					model.setMtcEdiRcvRsltDt(mtcEdiRcvRsltDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (railCmbThruTpCd[i] != null)
					model.setRailCmbThruTpCd(railCmbThruTpCd[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (cndCstmsClrFlg[i] != null)
					model.setCndCstmsClrFlg(cndCstmsClrFlg[i]);
				if (uplnSoFlg[i] != null)
					model.setUplnSoFlg(uplnSoFlg[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsTrspEdiRailOrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return TrsTrspEdiRailOrdVO[]
	 */
	public TrsTrspEdiRailOrdVO[] getTrsTrspEdiRailOrdVOs() {
		TrsTrspEdiRailOrdVO[] vos = (TrsTrspEdiRailOrdVO[]) models.toArray(new TrsTrspEdiRailOrdVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.bilEdiRcvRsltCd = this.bilEdiRcvRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilIssKnt = this.bilIssKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railOrdRjctFlg = this.railOrdRjctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRjctRsn = this.woRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRcvRsltFlg = this.bilEdiRcvRsltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiRcvRsltFlg = this.mtcEdiRcvRsltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRjctRsn = this.cxlRqstRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilIssStsCd = this.bilIssStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRsndDt = this.bilEdiRsndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwUpdDt = this.dwUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRsndRcvRsltCd = this.bilEdiRsndRcvRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiCtrlSeq = this.bilEdiCtrlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmMsgSntDt = this.cfmMsgSntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiSntDt = this.bilEdiSntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstDt = this.cxlRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRcvRsltDt = this.bilEdiRcvRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilEdiRsndRcvRsltDt = this.bilEdiRsndRcvRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiIndCd = this.mtcEdiIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtcEdiRcvRsltDt = this.mtcEdiRcvRsltDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCmbThruTpCd = this.railCmbThruTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsClrFlg = this.cndCstmsClrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uplnSoFlg = this.uplnSoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
