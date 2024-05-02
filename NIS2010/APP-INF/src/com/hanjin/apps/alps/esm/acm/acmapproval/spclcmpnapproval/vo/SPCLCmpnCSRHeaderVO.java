/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnCSRHeaderVO.java
*@FileTitle : SPCLCmpnCSRHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.10 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SPCLCmpnCSRHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SPCLCmpnCSRHeaderVO> models = new ArrayList<SPCLCmpnCSRHeaderVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String impErrFlg = null;
	/* Column Info */
	private String coaRgnCd = null;
	/* Column Info */
	private String ppdNo = null;
	/* Column Info */
	private String ppdDtrbNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String payAmt = null;
	/* Column Info */
	private String ftuUseCtnt2 = null;
	/* Column Info */
	private String ftuUseCtnt1 = null;
	/* Column Info */
	private String csrTpCd = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Column Info */
	private String ftuUseCtnt5 = null;
	/* Column Info */
	private String ftuUseCtnt4 = null;
	/* Column Info */
	private String ftuUseCtnt3 = null;
	/* Column Info */
	private String rcvErrFlg = null;
	/* Column Info */
	private String payGrpLuCd = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String ppayAplyFlg = null;
	/* Column Info */
	private String rcvFlg = null;
	/* Column Info */
	private String ifRsn = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String rcvRsn = null;
	/* Column Info */
	private String invTermDt = null;
	/* Column Info */
	private String payMzdLuCd = null;
	/* Column Info */
	private String coaInterCompyCd = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String totAmt = null;
	/* Column Info */
	private String coaAcctCd = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Column Info */
	private String taxCurrXchFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String gloAttrCtnt2 = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String gloAttrCtnt3 = null;
	/* Column Info */
	private String gloAttrCtnt4 = null;
	/* Column Info */
	private String gloAttrCtnt5 = null;
	/* Column Info */
	private String gloAttrCtnt6 = null;
	/* Column Info */
	private String ppdAplyAmt = null;
	/* Column Info */
	private String gloAttrCtnt7 = null;
	/* Column Info */
	private String gloAttrCtnt8 = null;
	/* Column Info */
	private String gloAttrCtnt9 = null;
	/* Column Info */
	private String gloAttrCtnt1 = null;
	/* Column Info */
	private String coaVvdCd = null;
	/* Column Info */
	private String coaFtuN2ndCd = null;
	/* Column Info */
	private String impErrRsn = null;
	/* Column Info */
	private String srcCtnt = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String rcvErrRsn = null;
	/* Column Info */
	private String attrCtnt10 = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String attrCtnt14 = null;
	/* Column Info */
	private String attrCtnt13 = null;
	/* Column Info */
	private String attrCtnt12 = null;
	/* Column Info */
	private String attrCtnt11 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String attrCtnt15 = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String vndrNo = null;
	/* Column Info */
	private String ppdGlDt = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String coaCoCd = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String errCsrNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String taxDeclFlg = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String gloAttrCtnt17 = null;
	/* Column Info */
	private String coaInterCoCd = null;
	/* Column Info */
	private String gloAttrCtnt18 = null;
	/* Column Info */
	private String gloAttrCtnt15 = null;
	/* Column Info */
	private String attrCtnt9 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String gloAttrCtnt16 = null;
	/* Column Info */
	private String gloAttrCtnt13 = null;
	/* Column Info */
	private String gloAttrCtnt14 = null;
	/* Column Info */
	private String gloAttrCtnt11 = null;
	/* Column Info */
	private String gloAttrCtnt12 = null;
	/* Column Info */
	private String usrEm = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Column Info */
	private String gloAttrCtnt10 = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String coaFtuN1stCd = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String tjOfcCd = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String invTaxRt = null;
	/* Column Info */
	private String actXchRt = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String coaCtrCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String csrAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SPCLCmpnCSRHeaderVO() {}

	public SPCLCmpnCSRHeaderVO(String ibflag, String pagerows, String impErrFlg, String ifDt, String payDt, String rcvErrRsn, String glDt, String attrCtnt10, String csrCurrCd, String attrCtnt14, String coaRgnCd, String attrCtnt13, String ppdNo, String attrCtnt12, String attrCtnt11, String ppdDtrbNo, String attrCtnt15, String invDesc, String vndrNo, String payAmt, String ppdGlDt, String ftuUseCtnt2, String ftuUseCtnt1, String usrEml, String aproFlg, String ftuUseCtnt5, String attrCateNm, String csrTpCd, String ftuUseCtnt4, String ftuUseCtnt3, String invDt, String rcvErrFlg, String csrNo, String payGrpLuCd, String ifFlg, String ppayAplyFlg, String coaCoCd, String errCsrNo, String creUsrId, String payMzdLuCd, String invTermDt, String taxDeclFlg, String coaInterCoCd, String coaAcctCd, String gloAttrCtnt17, String gloAttrCtnt18, String creDt, String attrCtnt9, String gloAttrCtnt15, String attrCtnt8, String gloAttrCtnt16, String gloAttrCtnt13, String gloAttrCtnt14, String gloAttrCtnt11, String ifErrRsn, String gloAttrCtnt12, String gloAttrCtnt10, String attrCtnt1, String taxCurrXchFlg, String coaFtuN1stCd, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String tjOfcCd, String attrCtnt6, String attrCtnt7, String gloAttrCtnt2, String gloAttrCtnt3, String gloAttrCtnt4, String gloAttrCtnt5, String actXchRt, String gloAttrCtnt6, String ppdAplyAmt, String gloAttrCtnt7, String gloAttrCtnt8, String gloAttrCtnt9, String vndrTermNm, String gloAttrCtnt1, String coaCtrCd, String eaiEvntDt, String coaVvdCd, String coaFtuN2ndCd, String impErrRsn, String csrAmt, String srcCtnt, String usrId, String usrNm, String usrEm, String arHdQtrOfcCd, String dateFm, String totAmt, String ifOpt, String blNo, String ffCntSeq, String dateDiv, String apOfcCd, String totCnt, String dateTo, String rcvFlg, String custLglEngNm, String ifRsn, String rcvRsn, String vndrSeq, String ffCntCd, String coaInterCompyCd, String invTaxRt, String custCntSeq) {
		this.ifDt = ifDt;
		this.impErrFlg = impErrFlg;
		this.coaRgnCd = coaRgnCd;
		this.ppdNo = ppdNo;
		this.ppdDtrbNo = ppdDtrbNo;
		this.pagerows = pagerows;
		this.payAmt = payAmt;
		this.ftuUseCtnt2 = ftuUseCtnt2;
		this.ftuUseCtnt1 = ftuUseCtnt1;
		this.csrTpCd = csrTpCd;
		this.attrCateNm = attrCateNm;
		this.ftuUseCtnt5 = ftuUseCtnt5;
		this.ftuUseCtnt4 = ftuUseCtnt4;
		this.ftuUseCtnt3 = ftuUseCtnt3;
		this.rcvErrFlg = rcvErrFlg;
		this.payGrpLuCd = payGrpLuCd;
		this.apOfcCd = apOfcCd;
		this.totCnt = totCnt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.ifFlg = ifFlg;
		this.ppayAplyFlg = ppayAplyFlg;
		this.rcvFlg = rcvFlg;
		this.ifRsn = ifRsn;
		this.custLglEngNm = custLglEngNm;
		this.rcvRsn = rcvRsn;
		this.invTermDt = invTermDt;
		this.payMzdLuCd = payMzdLuCd;
		this.coaInterCompyCd = coaInterCompyCd;
		this.dateFm = dateFm;
		this.totAmt = totAmt;
		this.coaAcctCd = coaAcctCd;
		this.ifErrRsn = ifErrRsn;
		this.taxCurrXchFlg = taxCurrXchFlg;
		this.usrId = usrId;
		this.gloAttrCtnt2 = gloAttrCtnt2;
		this.dateDiv = dateDiv;
		this.gloAttrCtnt3 = gloAttrCtnt3;
		this.gloAttrCtnt4 = gloAttrCtnt4;
		this.gloAttrCtnt5 = gloAttrCtnt5;
		this.gloAttrCtnt6 = gloAttrCtnt6;
		this.ppdAplyAmt = ppdAplyAmt;
		this.gloAttrCtnt7 = gloAttrCtnt7;
		this.gloAttrCtnt8 = gloAttrCtnt8;
		this.gloAttrCtnt9 = gloAttrCtnt9;
		this.gloAttrCtnt1 = gloAttrCtnt1;
		this.coaVvdCd = coaVvdCd;
		this.coaFtuN2ndCd = coaFtuN2ndCd;
		this.impErrRsn = impErrRsn;
		this.srcCtnt = srcCtnt;
		this.payDt = payDt;
		this.glDt = glDt;
		this.rcvErrRsn = rcvErrRsn;
		this.attrCtnt10 = attrCtnt10;
		this.csrCurrCd = csrCurrCd;
		this.attrCtnt14 = attrCtnt14;
		this.attrCtnt13 = attrCtnt13;
		this.attrCtnt12 = attrCtnt12;
		this.attrCtnt11 = attrCtnt11;
		this.blNo = blNo;
		this.attrCtnt15 = attrCtnt15;
		this.invDesc = invDesc;
		this.vndrNo = vndrNo;
		this.ppdGlDt = ppdGlDt;
		this.usrEml = usrEml;
		this.aproFlg = aproFlg;
		this.invDt = invDt;
		this.csrNo = csrNo;
		this.dateTo = dateTo;
		this.coaCoCd = coaCoCd;
		this.custCntSeq = custCntSeq;
		this.errCsrNo = errCsrNo;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.taxDeclFlg = taxDeclFlg;
		this.ifOpt = ifOpt;
		this.gloAttrCtnt17 = gloAttrCtnt17;
		this.coaInterCoCd = coaInterCoCd;
		this.gloAttrCtnt18 = gloAttrCtnt18;
		this.gloAttrCtnt15 = gloAttrCtnt15;
		this.attrCtnt9 = attrCtnt9;
		this.creDt = creDt;
		this.attrCtnt8 = attrCtnt8;
		this.gloAttrCtnt16 = gloAttrCtnt16;
		this.gloAttrCtnt13 = gloAttrCtnt13;
		this.gloAttrCtnt14 = gloAttrCtnt14;
		this.gloAttrCtnt11 = gloAttrCtnt11;
		this.gloAttrCtnt12 = gloAttrCtnt12;
		this.usrEm = usrEm;
		this.ffCntSeq = ffCntSeq;
		this.gloAttrCtnt10 = gloAttrCtnt10;
		this.attrCtnt1 = attrCtnt1;
		this.ibflag = ibflag;
		this.coaFtuN1stCd = coaFtuN1stCd;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.attrCtnt5 = attrCtnt5;
		this.usrNm = usrNm;
		this.tjOfcCd = tjOfcCd;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.invTaxRt = invTaxRt;
		this.actXchRt = actXchRt;
		this.vndrTermNm = vndrTermNm;
		this.coaCtrCd = coaCtrCd;
		this.eaiEvntDt = eaiEvntDt;
		this.ffCntCd = ffCntCd;
		this.csrAmt = csrAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("imp_err_flg", getImpErrFlg());
		this.hashColumns.put("coa_rgn_cd", getCoaRgnCd());
		this.hashColumns.put("ppd_no", getPpdNo());
		this.hashColumns.put("ppd_dtrb_no", getPpdDtrbNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pay_amt", getPayAmt());
		this.hashColumns.put("ftu_use_ctnt2", getFtuUseCtnt2());
		this.hashColumns.put("ftu_use_ctnt1", getFtuUseCtnt1());
		this.hashColumns.put("csr_tp_cd", getCsrTpCd());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("ftu_use_ctnt5", getFtuUseCtnt5());
		this.hashColumns.put("ftu_use_ctnt4", getFtuUseCtnt4());
		this.hashColumns.put("ftu_use_ctnt3", getFtuUseCtnt3());
		this.hashColumns.put("rcv_err_flg", getRcvErrFlg());
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("ppay_aply_flg", getPpayAplyFlg());
		this.hashColumns.put("rcv_flg", getRcvFlg());
		this.hashColumns.put("if_rsn", getIfRsn());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("rcv_rsn", getRcvRsn());
		this.hashColumns.put("inv_term_dt", getInvTermDt());
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());
		this.hashColumns.put("coa_inter_compy_cd", getCoaInterCompyCd());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("tot_amt", getTotAmt());
		this.hashColumns.put("coa_acct_cd", getCoaAcctCd());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("tax_curr_xch_flg", getTaxCurrXchFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("glo_attr_ctnt2", getGloAttrCtnt2());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("glo_attr_ctnt3", getGloAttrCtnt3());
		this.hashColumns.put("glo_attr_ctnt4", getGloAttrCtnt4());
		this.hashColumns.put("glo_attr_ctnt5", getGloAttrCtnt5());
		this.hashColumns.put("glo_attr_ctnt6", getGloAttrCtnt6());
		this.hashColumns.put("ppd_aply_amt", getPpdAplyAmt());
		this.hashColumns.put("glo_attr_ctnt7", getGloAttrCtnt7());
		this.hashColumns.put("glo_attr_ctnt8", getGloAttrCtnt8());
		this.hashColumns.put("glo_attr_ctnt9", getGloAttrCtnt9());
		this.hashColumns.put("glo_attr_ctnt1", getGloAttrCtnt1());
		this.hashColumns.put("coa_vvd_cd", getCoaVvdCd());
		this.hashColumns.put("coa_ftu_n2nd_cd", getCoaFtuN2ndCd());
		this.hashColumns.put("imp_err_rsn", getImpErrRsn());
		this.hashColumns.put("src_ctnt", getSrcCtnt());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("rcv_err_rsn", getRcvErrRsn());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("vndr_no", getVndrNo());
		this.hashColumns.put("ppd_gl_dt", getPpdGlDt());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("coa_co_cd", getCoaCoCd());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("err_csr_no", getErrCsrNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tax_decl_flg", getTaxDeclFlg());
		this.hashColumns.put("if_opt", getIfOpt());
		this.hashColumns.put("glo_attr_ctnt17", getGloAttrCtnt17());
		this.hashColumns.put("coa_inter_co_cd", getCoaInterCoCd());
		this.hashColumns.put("glo_attr_ctnt18", getGloAttrCtnt18());
		this.hashColumns.put("glo_attr_ctnt15", getGloAttrCtnt15());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("glo_attr_ctnt16", getGloAttrCtnt16());
		this.hashColumns.put("glo_attr_ctnt13", getGloAttrCtnt13());
		this.hashColumns.put("glo_attr_ctnt14", getGloAttrCtnt14());
		this.hashColumns.put("glo_attr_ctnt11", getGloAttrCtnt11());
		this.hashColumns.put("glo_attr_ctnt12", getGloAttrCtnt12());
		this.hashColumns.put("usr_em", getUsrEm());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("glo_attr_ctnt10", getGloAttrCtnt10());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coa_ftu_n1st_cd", getCoaFtuN1stCd());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("tj_ofc_cd", getTjOfcCd());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("inv_tax_rt", getInvTaxRt());
		this.hashColumns.put("act_xch_rt", getActXchRt());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("coa_ctr_cd", getCoaCtrCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("imp_err_flg", "impErrFlg");
		this.hashFields.put("coa_rgn_cd", "coaRgnCd");
		this.hashFields.put("ppd_no", "ppdNo");
		this.hashFields.put("ppd_dtrb_no", "ppdDtrbNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("ftu_use_ctnt2", "ftuUseCtnt2");
		this.hashFields.put("ftu_use_ctnt1", "ftuUseCtnt1");
		this.hashFields.put("csr_tp_cd", "csrTpCd");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("ftu_use_ctnt5", "ftuUseCtnt5");
		this.hashFields.put("ftu_use_ctnt4", "ftuUseCtnt4");
		this.hashFields.put("ftu_use_ctnt3", "ftuUseCtnt3");
		this.hashFields.put("rcv_err_flg", "rcvErrFlg");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("ppay_aply_flg", "ppayAplyFlg");
		this.hashFields.put("rcv_flg", "rcvFlg");
		this.hashFields.put("if_rsn", "ifRsn");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("rcv_rsn", "rcvRsn");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("coa_inter_compy_cd", "coaInterCompyCd");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("tot_amt", "totAmt");
		this.hashFields.put("coa_acct_cd", "coaAcctCd");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("tax_curr_xch_flg", "taxCurrXchFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("glo_attr_ctnt2", "gloAttrCtnt2");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("glo_attr_ctnt3", "gloAttrCtnt3");
		this.hashFields.put("glo_attr_ctnt4", "gloAttrCtnt4");
		this.hashFields.put("glo_attr_ctnt5", "gloAttrCtnt5");
		this.hashFields.put("glo_attr_ctnt6", "gloAttrCtnt6");
		this.hashFields.put("ppd_aply_amt", "ppdAplyAmt");
		this.hashFields.put("glo_attr_ctnt7", "gloAttrCtnt7");
		this.hashFields.put("glo_attr_ctnt8", "gloAttrCtnt8");
		this.hashFields.put("glo_attr_ctnt9", "gloAttrCtnt9");
		this.hashFields.put("glo_attr_ctnt1", "gloAttrCtnt1");
		this.hashFields.put("coa_vvd_cd", "coaVvdCd");
		this.hashFields.put("coa_ftu_n2nd_cd", "coaFtuN2ndCd");
		this.hashFields.put("imp_err_rsn", "impErrRsn");
		this.hashFields.put("src_ctnt", "srcCtnt");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("rcv_err_rsn", "rcvErrRsn");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ppd_gl_dt", "ppdGlDt");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("coa_co_cd", "coaCoCd");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("err_csr_no", "errCsrNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tax_decl_flg", "taxDeclFlg");
		this.hashFields.put("if_opt", "ifOpt");
		this.hashFields.put("glo_attr_ctnt17", "gloAttrCtnt17");
		this.hashFields.put("coa_inter_co_cd", "coaInterCoCd");
		this.hashFields.put("glo_attr_ctnt18", "gloAttrCtnt18");
		this.hashFields.put("glo_attr_ctnt15", "gloAttrCtnt15");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("glo_attr_ctnt16", "gloAttrCtnt16");
		this.hashFields.put("glo_attr_ctnt13", "gloAttrCtnt13");
		this.hashFields.put("glo_attr_ctnt14", "gloAttrCtnt14");
		this.hashFields.put("glo_attr_ctnt11", "gloAttrCtnt11");
		this.hashFields.put("glo_attr_ctnt12", "gloAttrCtnt12");
		this.hashFields.put("usr_em", "usrEm");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("glo_attr_ctnt10", "gloAttrCtnt10");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coa_ftu_n1st_cd", "coaFtuN1stCd");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("tj_ofc_cd", "tjOfcCd");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("inv_tax_rt", "invTaxRt");
		this.hashFields.put("act_xch_rt", "actXchRt");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("coa_ctr_cd", "coaCtrCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("csr_amt", "csrAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return impErrFlg
	 */
	public String getImpErrFlg() {
		return this.impErrFlg;
	}
	
	/**
	 * Column Info
	 * @return coaRgnCd
	 */
	public String getCoaRgnCd() {
		return this.coaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return ppdNo
	 */
	public String getPpdNo() {
		return this.ppdNo;
	}
	
	/**
	 * Column Info
	 * @return ppdDtrbNo
	 */
	public String getPpdDtrbNo() {
		return this.ppdDtrbNo;
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
	 * @return payAmt
	 */
	public String getPayAmt() {
		return this.payAmt;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt2
	 */
	public String getFtuUseCtnt2() {
		return this.ftuUseCtnt2;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt1
	 */
	public String getFtuUseCtnt1() {
		return this.ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @return csrTpCd
	 */
	public String getCsrTpCd() {
		return this.csrTpCd;
	}
	
	/**
	 * Column Info
	 * @return attrCateNm
	 */
	public String getAttrCateNm() {
		return this.attrCateNm;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt5
	 */
	public String getFtuUseCtnt5() {
		return this.ftuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt4
	 */
	public String getFtuUseCtnt4() {
		return this.ftuUseCtnt4;
	}
	
	/**
	 * Column Info
	 * @return ftuUseCtnt3
	 */
	public String getFtuUseCtnt3() {
		return this.ftuUseCtnt3;
	}
	
	/**
	 * Column Info
	 * @return rcvErrFlg
	 */
	public String getRcvErrFlg() {
		return this.rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @return payGrpLuCd
	 */
	public String getPayGrpLuCd() {
		return this.payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return ppayAplyFlg
	 */
	public String getPpayAplyFlg() {
		return this.ppayAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvFlg
	 */
	public String getRcvFlg() {
		return this.rcvFlg;
	}
	
	/**
	 * Column Info
	 * @return ifRsn
	 */
	public String getIfRsn() {
		return this.ifRsn;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rcvRsn
	 */
	public String getRcvRsn() {
		return this.rcvRsn;
	}
	
	/**
	 * Column Info
	 * @return invTermDt
	 */
	public String getInvTermDt() {
		return this.invTermDt;
	}
	
	/**
	 * Column Info
	 * @return payMzdLuCd
	 */
	public String getPayMzdLuCd() {
		return this.payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return coaInterCompyCd
	 */
	public String getCoaInterCompyCd() {
		return this.coaInterCompyCd;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return totAmt
	 */
	public String getTotAmt() {
		return this.totAmt;
	}
	
	/**
	 * Column Info
	 * @return coaAcctCd
	 */
	public String getCoaAcctCd() {
		return this.coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return ifErrRsn
	 */
	public String getIfErrRsn() {
		return this.ifErrRsn;
	}
	
	/**
	 * Column Info
	 * @return taxCurrXchFlg
	 */
	public String getTaxCurrXchFlg() {
		return this.taxCurrXchFlg;
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
	 * @return gloAttrCtnt2
	 */
	public String getGloAttrCtnt2() {
		return this.gloAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt3
	 */
	public String getGloAttrCtnt3() {
		return this.gloAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt4
	 */
	public String getGloAttrCtnt4() {
		return this.gloAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt5
	 */
	public String getGloAttrCtnt5() {
		return this.gloAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt6
	 */
	public String getGloAttrCtnt6() {
		return this.gloAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return ppdAplyAmt
	 */
	public String getPpdAplyAmt() {
		return this.ppdAplyAmt;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt7
	 */
	public String getGloAttrCtnt7() {
		return this.gloAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt8
	 */
	public String getGloAttrCtnt8() {
		return this.gloAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt9
	 */
	public String getGloAttrCtnt9() {
		return this.gloAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt1
	 */
	public String getGloAttrCtnt1() {
		return this.gloAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return coaVvdCd
	 */
	public String getCoaVvdCd() {
		return this.coaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return coaFtuN2ndCd
	 */
	public String getCoaFtuN2ndCd() {
		return this.coaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return impErrRsn
	 */
	public String getImpErrRsn() {
		return this.impErrRsn;
	}
	
	/**
	 * Column Info
	 * @return srcCtnt
	 */
	public String getSrcCtnt() {
		return this.srcCtnt;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return rcvErrRsn
	 */
	public String getRcvErrRsn() {
		return this.rcvErrRsn;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt10
	 */
	public String getAttrCtnt10() {
		return this.attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt14
	 */
	public String getAttrCtnt14() {
		return this.attrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt13
	 */
	public String getAttrCtnt13() {
		return this.attrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt12
	 */
	public String getAttrCtnt12() {
		return this.attrCtnt12;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt11
	 */
	public String getAttrCtnt11() {
		return this.attrCtnt11;
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
	 * @return attrCtnt15
	 */
	public String getAttrCtnt15() {
		return this.attrCtnt15;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
	}
	
	/**
	 * Column Info
	 * @return ppdGlDt
	 */
	public String getPpdGlDt() {
		return this.ppdGlDt;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return aproFlg
	 */
	public String getAproFlg() {
		return this.aproFlg;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return coaCoCd
	 */
	public String getCoaCoCd() {
		return this.coaCoCd;
	}
	
	/**
	 * Column Info
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return errCsrNo
	 */
	public String getErrCsrNo() {
		return this.errCsrNo;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return taxDeclFlg
	 */
	public String getTaxDeclFlg() {
		return this.taxDeclFlg;
	}
	
	/**
	 * Column Info
	 * @return ifOpt
	 */
	public String getIfOpt() {
		return this.ifOpt;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt17
	 */
	public String getGloAttrCtnt17() {
		return this.gloAttrCtnt17;
	}
	
	/**
	 * Column Info
	 * @return coaInterCoCd
	 */
	public String getCoaInterCoCd() {
		return this.coaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt18
	 */
	public String getGloAttrCtnt18() {
		return this.gloAttrCtnt18;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt15
	 */
	public String getGloAttrCtnt15() {
		return this.gloAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt9
	 */
	public String getAttrCtnt9() {
		return this.attrCtnt9;
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
	 * @return attrCtnt8
	 */
	public String getAttrCtnt8() {
		return this.attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt16
	 */
	public String getGloAttrCtnt16() {
		return this.gloAttrCtnt16;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt13
	 */
	public String getGloAttrCtnt13() {
		return this.gloAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt14
	 */
	public String getGloAttrCtnt14() {
		return this.gloAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt11
	 */
	public String getGloAttrCtnt11() {
		return this.gloAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt12
	 */
	public String getGloAttrCtnt12() {
		return this.gloAttrCtnt12;
	}
	
	/**
	 * Column Info
	 * @return usrEm
	 */
	public String getUsrEm() {
		return this.usrEm;
	}
	
	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
	}
	
	/**
	 * Column Info
	 * @return gloAttrCtnt10
	 */
	public String getGloAttrCtnt10() {
		return this.gloAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
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
	 * @return coaFtuN1stCd
	 */
	public String getCoaFtuN1stCd() {
		return this.coaFtuN1stCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return tjOfcCd
	 */
	public String getTjOfcCd() {
		return this.tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public String getAttrCtnt6() {
		return this.attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return invTaxRt
	 */
	public String getInvTaxRt() {
		return this.invTaxRt;
	}
	
	/**
	 * Column Info
	 * @return actXchRt
	 */
	public String getActXchRt() {
		return this.actXchRt;
	}
	
	/**
	 * Column Info
	 * @return vndrTermNm
	 */
	public String getVndrTermNm() {
		return this.vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return coaCtrCd
	 */
	public String getCoaCtrCd() {
		return this.coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param impErrFlg
	 */
	public void setImpErrFlg(String impErrFlg) {
		this.impErrFlg = impErrFlg;
	}
	
	/**
	 * Column Info
	 * @param coaRgnCd
	 */
	public void setCoaRgnCd(String coaRgnCd) {
		this.coaRgnCd = coaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param ppdNo
	 */
	public void setPpdNo(String ppdNo) {
		this.ppdNo = ppdNo;
	}
	
	/**
	 * Column Info
	 * @param ppdDtrbNo
	 */
	public void setPpdDtrbNo(String ppdDtrbNo) {
		this.ppdDtrbNo = ppdDtrbNo;
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
	 * @param payAmt
	 */
	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt2
	 */
	public void setFtuUseCtnt2(String ftuUseCtnt2) {
		this.ftuUseCtnt2 = ftuUseCtnt2;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt1
	 */
	public void setFtuUseCtnt1(String ftuUseCtnt1) {
		this.ftuUseCtnt1 = ftuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @param csrTpCd
	 */
	public void setCsrTpCd(String csrTpCd) {
		this.csrTpCd = csrTpCd;
	}
	
	/**
	 * Column Info
	 * @param attrCateNm
	 */
	public void setAttrCateNm(String attrCateNm) {
		this.attrCateNm = attrCateNm;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt5
	 */
	public void setFtuUseCtnt5(String ftuUseCtnt5) {
		this.ftuUseCtnt5 = ftuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt4
	 */
	public void setFtuUseCtnt4(String ftuUseCtnt4) {
		this.ftuUseCtnt4 = ftuUseCtnt4;
	}
	
	/**
	 * Column Info
	 * @param ftuUseCtnt3
	 */
	public void setFtuUseCtnt3(String ftuUseCtnt3) {
		this.ftuUseCtnt3 = ftuUseCtnt3;
	}
	
	/**
	 * Column Info
	 * @param rcvErrFlg
	 */
	public void setRcvErrFlg(String rcvErrFlg) {
		this.rcvErrFlg = rcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @param payGrpLuCd
	 */
	public void setPayGrpLuCd(String payGrpLuCd) {
		this.payGrpLuCd = payGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param ppayAplyFlg
	 */
	public void setPpayAplyFlg(String ppayAplyFlg) {
		this.ppayAplyFlg = ppayAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvFlg
	 */
	public void setRcvFlg(String rcvFlg) {
		this.rcvFlg = rcvFlg;
	}
	
	/**
	 * Column Info
	 * @param ifRsn
	 */
	public void setIfRsn(String ifRsn) {
		this.ifRsn = ifRsn;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rcvRsn
	 */
	public void setRcvRsn(String rcvRsn) {
		this.rcvRsn = rcvRsn;
	}
	
	/**
	 * Column Info
	 * @param invTermDt
	 */
	public void setInvTermDt(String invTermDt) {
		this.invTermDt = invTermDt;
	}
	
	/**
	 * Column Info
	 * @param payMzdLuCd
	 */
	public void setPayMzdLuCd(String payMzdLuCd) {
		this.payMzdLuCd = payMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param coaInterCompyCd
	 */
	public void setCoaInterCompyCd(String coaInterCompyCd) {
		this.coaInterCompyCd = coaInterCompyCd;
	}
	
	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param totAmt
	 */
	public void setTotAmt(String totAmt) {
		this.totAmt = totAmt;
	}
	
	/**
	 * Column Info
	 * @param coaAcctCd
	 */
	public void setCoaAcctCd(String coaAcctCd) {
		this.coaAcctCd = coaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param ifErrRsn
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
	}
	
	/**
	 * Column Info
	 * @param taxCurrXchFlg
	 */
	public void setTaxCurrXchFlg(String taxCurrXchFlg) {
		this.taxCurrXchFlg = taxCurrXchFlg;
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
	 * @param gloAttrCtnt2
	 */
	public void setGloAttrCtnt2(String gloAttrCtnt2) {
		this.gloAttrCtnt2 = gloAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt3
	 */
	public void setGloAttrCtnt3(String gloAttrCtnt3) {
		this.gloAttrCtnt3 = gloAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt4
	 */
	public void setGloAttrCtnt4(String gloAttrCtnt4) {
		this.gloAttrCtnt4 = gloAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt5
	 */
	public void setGloAttrCtnt5(String gloAttrCtnt5) {
		this.gloAttrCtnt5 = gloAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt6
	 */
	public void setGloAttrCtnt6(String gloAttrCtnt6) {
		this.gloAttrCtnt6 = gloAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param ppdAplyAmt
	 */
	public void setPpdAplyAmt(String ppdAplyAmt) {
		this.ppdAplyAmt = ppdAplyAmt;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt7
	 */
	public void setGloAttrCtnt7(String gloAttrCtnt7) {
		this.gloAttrCtnt7 = gloAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt8
	 */
	public void setGloAttrCtnt8(String gloAttrCtnt8) {
		this.gloAttrCtnt8 = gloAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt9
	 */
	public void setGloAttrCtnt9(String gloAttrCtnt9) {
		this.gloAttrCtnt9 = gloAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt1
	 */
	public void setGloAttrCtnt1(String gloAttrCtnt1) {
		this.gloAttrCtnt1 = gloAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param coaVvdCd
	 */
	public void setCoaVvdCd(String coaVvdCd) {
		this.coaVvdCd = coaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param coaFtuN2ndCd
	 */
	public void setCoaFtuN2ndCd(String coaFtuN2ndCd) {
		this.coaFtuN2ndCd = coaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param impErrRsn
	 */
	public void setImpErrRsn(String impErrRsn) {
		this.impErrRsn = impErrRsn;
	}
	
	/**
	 * Column Info
	 * @param srcCtnt
	 */
	public void setSrcCtnt(String srcCtnt) {
		this.srcCtnt = srcCtnt;
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param rcvErrRsn
	 */
	public void setRcvErrRsn(String rcvErrRsn) {
		this.rcvErrRsn = rcvErrRsn;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt10
	 */
	public void setAttrCtnt10(String attrCtnt10) {
		this.attrCtnt10 = attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt14
	 */
	public void setAttrCtnt14(String attrCtnt14) {
		this.attrCtnt14 = attrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt13
	 */
	public void setAttrCtnt13(String attrCtnt13) {
		this.attrCtnt13 = attrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt12
	 */
	public void setAttrCtnt12(String attrCtnt12) {
		this.attrCtnt12 = attrCtnt12;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt11
	 */
	public void setAttrCtnt11(String attrCtnt11) {
		this.attrCtnt11 = attrCtnt11;
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
	 * @param attrCtnt15
	 */
	public void setAttrCtnt15(String attrCtnt15) {
		this.attrCtnt15 = attrCtnt15;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	
	/**
	 * Column Info
	 * @param ppdGlDt
	 */
	public void setPpdGlDt(String ppdGlDt) {
		this.ppdGlDt = ppdGlDt;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param aproFlg
	 */
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param coaCoCd
	 */
	public void setCoaCoCd(String coaCoCd) {
		this.coaCoCd = coaCoCd;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param errCsrNo
	 */
	public void setErrCsrNo(String errCsrNo) {
		this.errCsrNo = errCsrNo;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param taxDeclFlg
	 */
	public void setTaxDeclFlg(String taxDeclFlg) {
		this.taxDeclFlg = taxDeclFlg;
	}
	
	/**
	 * Column Info
	 * @param ifOpt
	 */
	public void setIfOpt(String ifOpt) {
		this.ifOpt = ifOpt;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt17
	 */
	public void setGloAttrCtnt17(String gloAttrCtnt17) {
		this.gloAttrCtnt17 = gloAttrCtnt17;
	}
	
	/**
	 * Column Info
	 * @param coaInterCoCd
	 */
	public void setCoaInterCoCd(String coaInterCoCd) {
		this.coaInterCoCd = coaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt18
	 */
	public void setGloAttrCtnt18(String gloAttrCtnt18) {
		this.gloAttrCtnt18 = gloAttrCtnt18;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt15
	 */
	public void setGloAttrCtnt15(String gloAttrCtnt15) {
		this.gloAttrCtnt15 = gloAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt9
	 */
	public void setAttrCtnt9(String attrCtnt9) {
		this.attrCtnt9 = attrCtnt9;
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
	 * @param attrCtnt8
	 */
	public void setAttrCtnt8(String attrCtnt8) {
		this.attrCtnt8 = attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt16
	 */
	public void setGloAttrCtnt16(String gloAttrCtnt16) {
		this.gloAttrCtnt16 = gloAttrCtnt16;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt13
	 */
	public void setGloAttrCtnt13(String gloAttrCtnt13) {
		this.gloAttrCtnt13 = gloAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt14
	 */
	public void setGloAttrCtnt14(String gloAttrCtnt14) {
		this.gloAttrCtnt14 = gloAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt11
	 */
	public void setGloAttrCtnt11(String gloAttrCtnt11) {
		this.gloAttrCtnt11 = gloAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt12
	 */
	public void setGloAttrCtnt12(String gloAttrCtnt12) {
		this.gloAttrCtnt12 = gloAttrCtnt12;
	}
	
	/**
	 * Column Info
	 * @param usrEm
	 */
	public void setUsrEm(String usrEm) {
		this.usrEm = usrEm;
	}
	
	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
	}
	
	/**
	 * Column Info
	 * @param gloAttrCtnt10
	 */
	public void setGloAttrCtnt10(String gloAttrCtnt10) {
		this.gloAttrCtnt10 = gloAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
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
	 * @param coaFtuN1stCd
	 */
	public void setCoaFtuN1stCd(String coaFtuN1stCd) {
		this.coaFtuN1stCd = coaFtuN1stCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
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
	 * @param tjOfcCd
	 */
	public void setTjOfcCd(String tjOfcCd) {
		this.tjOfcCd = tjOfcCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt6
	 */
	public void setAttrCtnt6(String attrCtnt6) {
		this.attrCtnt6 = attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param invTaxRt
	 */
	public void setInvTaxRt(String invTaxRt) {
		this.invTaxRt = invTaxRt;
	}
	
	/**
	 * Column Info
	 * @param actXchRt
	 */
	public void setActXchRt(String actXchRt) {
		this.actXchRt = actXchRt;
	}
	
	/**
	 * Column Info
	 * @param vndrTermNm
	 */
	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param coaCtrCd
	 */
	public void setCoaCtrCd(String coaCtrCd) {
		this.coaCtrCd = coaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setImpErrFlg(JSPUtil.getParameter(request, prefix + "imp_err_flg", ""));
		setCoaRgnCd(JSPUtil.getParameter(request, prefix + "coa_rgn_cd", ""));
		setPpdNo(JSPUtil.getParameter(request, prefix + "ppd_no", ""));
		setPpdDtrbNo(JSPUtil.getParameter(request, prefix + "ppd_dtrb_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPayAmt(JSPUtil.getParameter(request, prefix + "pay_amt", ""));
		setFtuUseCtnt2(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt2", ""));
		setFtuUseCtnt1(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt1", ""));
		setCsrTpCd(JSPUtil.getParameter(request, prefix + "csr_tp_cd", ""));
		setAttrCateNm(JSPUtil.getParameter(request, prefix + "attr_cate_nm", ""));
		setFtuUseCtnt5(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt5", ""));
		setFtuUseCtnt4(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt4", ""));
		setFtuUseCtnt3(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt3", ""));
		setRcvErrFlg(JSPUtil.getParameter(request, prefix + "rcv_err_flg", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request, prefix + "pay_grp_lu_cd", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setPpayAplyFlg(JSPUtil.getParameter(request, prefix + "ppay_aply_flg", ""));
		setRcvFlg(JSPUtil.getParameter(request, prefix + "rcv_flg", ""));
		setIfRsn(JSPUtil.getParameter(request, prefix + "if_rsn", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setRcvRsn(JSPUtil.getParameter(request, prefix + "rcv_rsn", ""));
		setInvTermDt(JSPUtil.getParameter(request, prefix + "inv_term_dt", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request, prefix + "pay_mzd_lu_cd", ""));
		setCoaInterCompyCd(JSPUtil.getParameter(request, prefix + "coa_inter_compy_cd", ""));
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setTotAmt(JSPUtil.getParameter(request, prefix + "tot_amt", ""));
		setCoaAcctCd(JSPUtil.getParameter(request, prefix + "coa_acct_cd", ""));
		setIfErrRsn(JSPUtil.getParameter(request, prefix + "if_err_rsn", ""));
		setTaxCurrXchFlg(JSPUtil.getParameter(request, prefix + "tax_curr_xch_flg", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setGloAttrCtnt2(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt2", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setGloAttrCtnt3(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt3", ""));
		setGloAttrCtnt4(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt4", ""));
		setGloAttrCtnt5(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt5", ""));
		setGloAttrCtnt6(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt6", ""));
		setPpdAplyAmt(JSPUtil.getParameter(request, prefix + "ppd_aply_amt", ""));
		setGloAttrCtnt7(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt7", ""));
		setGloAttrCtnt8(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt8", ""));
		setGloAttrCtnt9(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt9", ""));
		setGloAttrCtnt1(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt1", ""));
		setCoaVvdCd(JSPUtil.getParameter(request, prefix + "coa_vvd_cd", ""));
		setCoaFtuN2ndCd(JSPUtil.getParameter(request, prefix + "coa_ftu_n2nd_cd", ""));
		setImpErrRsn(JSPUtil.getParameter(request, prefix + "imp_err_rsn", ""));
		setSrcCtnt(JSPUtil.getParameter(request, prefix + "src_ctnt", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setRcvErrRsn(JSPUtil.getParameter(request, prefix + "rcv_err_rsn", ""));
		setAttrCtnt10(JSPUtil.getParameter(request, prefix + "attr_ctnt10", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, prefix + "csr_curr_cd", ""));
		setAttrCtnt14(JSPUtil.getParameter(request, prefix + "attr_ctnt14", ""));
		setAttrCtnt13(JSPUtil.getParameter(request, prefix + "attr_ctnt13", ""));
		setAttrCtnt12(JSPUtil.getParameter(request, prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request, prefix + "attr_ctnt11", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAttrCtnt15(JSPUtil.getParameter(request, prefix + "attr_ctnt15", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setVndrNo(JSPUtil.getParameter(request, prefix + "vndr_no", ""));
		setPpdGlDt(JSPUtil.getParameter(request, prefix + "ppd_gl_dt", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setAproFlg(JSPUtil.getParameter(request, prefix + "apro_flg", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCoaCoCd(JSPUtil.getParameter(request, prefix + "coa_co_cd", ""));
		setCustCntSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_seq", ""));
		setErrCsrNo(JSPUtil.getParameter(request, prefix + "err_csr_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTaxDeclFlg(JSPUtil.getParameter(request, prefix + "tax_decl_flg", ""));
		setIfOpt(JSPUtil.getParameter(request, prefix + "if_opt", ""));
		setGloAttrCtnt17(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt17", ""));
		setCoaInterCoCd(JSPUtil.getParameter(request, prefix + "coa_inter_co_cd", ""));
		setGloAttrCtnt18(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt18", ""));
		setGloAttrCtnt15(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt15", ""));
		setAttrCtnt9(JSPUtil.getParameter(request, prefix + "attr_ctnt9", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setGloAttrCtnt16(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt16", ""));
		setGloAttrCtnt13(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt13", ""));
		setGloAttrCtnt14(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt14", ""));
		setGloAttrCtnt11(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt11", ""));
		setGloAttrCtnt12(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt12", ""));
		setUsrEm(JSPUtil.getParameter(request, prefix + "usr_em", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setGloAttrCtnt10(JSPUtil.getParameter(request, prefix + "glo_attr_ctnt10", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCoaFtuN1stCd(JSPUtil.getParameter(request, prefix + "coa_ftu_n1st_cd", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setTjOfcCd(JSPUtil.getParameter(request, prefix + "tj_ofc_cd", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setInvTaxRt(JSPUtil.getParameter(request, prefix + "inv_tax_rt", ""));
		setActXchRt(JSPUtil.getParameter(request, prefix + "act_xch_rt", ""));
		setVndrTermNm(JSPUtil.getParameter(request, prefix + "vndr_term_nm", ""));
		setCoaCtrCd(JSPUtil.getParameter(request, prefix + "coa_ctr_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, prefix + "csr_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SPCLCmpnCSRHeaderVO[]
	 */
	public SPCLCmpnCSRHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SPCLCmpnCSRHeaderVO[]
	 */
	public SPCLCmpnCSRHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SPCLCmpnCSRHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] impErrFlg = (JSPUtil.getParameter(request, prefix	+ "imp_err_flg", length));
			String[] coaRgnCd = (JSPUtil.getParameter(request, prefix	+ "coa_rgn_cd", length));
			String[] ppdNo = (JSPUtil.getParameter(request, prefix	+ "ppd_no", length));
			String[] ppdDtrbNo = (JSPUtil.getParameter(request, prefix	+ "ppd_dtrb_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] payAmt = (JSPUtil.getParameter(request, prefix	+ "pay_amt", length));
			String[] ftuUseCtnt2 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt2", length));
			String[] ftuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt1", length));
			String[] csrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_tp_cd", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] ftuUseCtnt5 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt5", length));
			String[] ftuUseCtnt4 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt4", length));
			String[] ftuUseCtnt3 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt3", length));
			String[] rcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_err_flg", length));
			String[] payGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_grp_lu_cd", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] ppayAplyFlg = (JSPUtil.getParameter(request, prefix	+ "ppay_aply_flg", length));
			String[] rcvFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_flg", length));
			String[] ifRsn = (JSPUtil.getParameter(request, prefix	+ "if_rsn", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] rcvRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_rsn", length));
			String[] invTermDt = (JSPUtil.getParameter(request, prefix	+ "inv_term_dt", length));
			String[] payMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "pay_mzd_lu_cd", length));
			String[] coaInterCompyCd = (JSPUtil.getParameter(request, prefix	+ "coa_inter_compy_cd", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] totAmt = (JSPUtil.getParameter(request, prefix	+ "tot_amt", length));
			String[] coaAcctCd = (JSPUtil.getParameter(request, prefix	+ "coa_acct_cd", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] taxCurrXchFlg = (JSPUtil.getParameter(request, prefix	+ "tax_curr_xch_flg", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] gloAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt2", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] gloAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt3", length));
			String[] gloAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt4", length));
			String[] gloAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt5", length));
			String[] gloAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt6", length));
			String[] ppdAplyAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_aply_amt", length));
			String[] gloAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt7", length));
			String[] gloAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt8", length));
			String[] gloAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt9", length));
			String[] gloAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt1", length));
			String[] coaVvdCd = (JSPUtil.getParameter(request, prefix	+ "coa_vvd_cd", length));
			String[] coaFtuN2ndCd = (JSPUtil.getParameter(request, prefix	+ "coa_ftu_n2nd_cd", length));
			String[] impErrRsn = (JSPUtil.getParameter(request, prefix	+ "imp_err_rsn", length));
			String[] srcCtnt = (JSPUtil.getParameter(request, prefix	+ "src_ctnt", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] rcvErrRsn = (JSPUtil.getParameter(request, prefix	+ "rcv_err_rsn", length));
			String[] attrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt10", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] attrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt14", length));
			String[] attrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt13", length));
			String[] attrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt12", length));
			String[] attrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt11", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] attrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt15", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] vndrNo = (JSPUtil.getParameter(request, prefix	+ "vndr_no", length));
			String[] ppdGlDt = (JSPUtil.getParameter(request, prefix	+ "ppd_gl_dt", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] coaCoCd = (JSPUtil.getParameter(request, prefix	+ "coa_co_cd", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] errCsrNo = (JSPUtil.getParameter(request, prefix	+ "err_csr_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] taxDeclFlg = (JSPUtil.getParameter(request, prefix	+ "tax_decl_flg", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] gloAttrCtnt17 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt17", length));
			String[] coaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "coa_inter_co_cd", length));
			String[] gloAttrCtnt18 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt18", length));
			String[] gloAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt15", length));
			String[] attrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt9", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] gloAttrCtnt16 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt16", length));
			String[] gloAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt13", length));
			String[] gloAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt14", length));
			String[] gloAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt11", length));
			String[] gloAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt12", length));
			String[] usrEm = (JSPUtil.getParameter(request, prefix	+ "usr_em", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] gloAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "glo_attr_ctnt10", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coaFtuN1stCd = (JSPUtil.getParameter(request, prefix	+ "coa_ftu_n1st_cd", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] tjOfcCd = (JSPUtil.getParameter(request, prefix	+ "tj_ofc_cd", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] invTaxRt = (JSPUtil.getParameter(request, prefix	+ "inv_tax_rt", length));
			String[] actXchRt = (JSPUtil.getParameter(request, prefix	+ "act_xch_rt", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] coaCtrCd = (JSPUtil.getParameter(request, prefix	+ "coa_ctr_cd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SPCLCmpnCSRHeaderVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (impErrFlg[i] != null)
					model.setImpErrFlg(impErrFlg[i]);
				if (coaRgnCd[i] != null)
					model.setCoaRgnCd(coaRgnCd[i]);
				if (ppdNo[i] != null)
					model.setPpdNo(ppdNo[i]);
				if (ppdDtrbNo[i] != null)
					model.setPpdDtrbNo(ppdDtrbNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (payAmt[i] != null)
					model.setPayAmt(payAmt[i]);
				if (ftuUseCtnt2[i] != null)
					model.setFtuUseCtnt2(ftuUseCtnt2[i]);
				if (ftuUseCtnt1[i] != null)
					model.setFtuUseCtnt1(ftuUseCtnt1[i]);
				if (csrTpCd[i] != null)
					model.setCsrTpCd(csrTpCd[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (ftuUseCtnt5[i] != null)
					model.setFtuUseCtnt5(ftuUseCtnt5[i]);
				if (ftuUseCtnt4[i] != null)
					model.setFtuUseCtnt4(ftuUseCtnt4[i]);
				if (ftuUseCtnt3[i] != null)
					model.setFtuUseCtnt3(ftuUseCtnt3[i]);
				if (rcvErrFlg[i] != null)
					model.setRcvErrFlg(rcvErrFlg[i]);
				if (payGrpLuCd[i] != null)
					model.setPayGrpLuCd(payGrpLuCd[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (ppayAplyFlg[i] != null)
					model.setPpayAplyFlg(ppayAplyFlg[i]);
				if (rcvFlg[i] != null)
					model.setRcvFlg(rcvFlg[i]);
				if (ifRsn[i] != null)
					model.setIfRsn(ifRsn[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (rcvRsn[i] != null)
					model.setRcvRsn(rcvRsn[i]);
				if (invTermDt[i] != null)
					model.setInvTermDt(invTermDt[i]);
				if (payMzdLuCd[i] != null)
					model.setPayMzdLuCd(payMzdLuCd[i]);
				if (coaInterCompyCd[i] != null)
					model.setCoaInterCompyCd(coaInterCompyCd[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (totAmt[i] != null)
					model.setTotAmt(totAmt[i]);
				if (coaAcctCd[i] != null)
					model.setCoaAcctCd(coaAcctCd[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (taxCurrXchFlg[i] != null)
					model.setTaxCurrXchFlg(taxCurrXchFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (gloAttrCtnt2[i] != null)
					model.setGloAttrCtnt2(gloAttrCtnt2[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (gloAttrCtnt3[i] != null)
					model.setGloAttrCtnt3(gloAttrCtnt3[i]);
				if (gloAttrCtnt4[i] != null)
					model.setGloAttrCtnt4(gloAttrCtnt4[i]);
				if (gloAttrCtnt5[i] != null)
					model.setGloAttrCtnt5(gloAttrCtnt5[i]);
				if (gloAttrCtnt6[i] != null)
					model.setGloAttrCtnt6(gloAttrCtnt6[i]);
				if (ppdAplyAmt[i] != null)
					model.setPpdAplyAmt(ppdAplyAmt[i]);
				if (gloAttrCtnt7[i] != null)
					model.setGloAttrCtnt7(gloAttrCtnt7[i]);
				if (gloAttrCtnt8[i] != null)
					model.setGloAttrCtnt8(gloAttrCtnt8[i]);
				if (gloAttrCtnt9[i] != null)
					model.setGloAttrCtnt9(gloAttrCtnt9[i]);
				if (gloAttrCtnt1[i] != null)
					model.setGloAttrCtnt1(gloAttrCtnt1[i]);
				if (coaVvdCd[i] != null)
					model.setCoaVvdCd(coaVvdCd[i]);
				if (coaFtuN2ndCd[i] != null)
					model.setCoaFtuN2ndCd(coaFtuN2ndCd[i]);
				if (impErrRsn[i] != null)
					model.setImpErrRsn(impErrRsn[i]);
				if (srcCtnt[i] != null)
					model.setSrcCtnt(srcCtnt[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (rcvErrRsn[i] != null)
					model.setRcvErrRsn(rcvErrRsn[i]);
				if (attrCtnt10[i] != null)
					model.setAttrCtnt10(attrCtnt10[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (attrCtnt14[i] != null)
					model.setAttrCtnt14(attrCtnt14[i]);
				if (attrCtnt13[i] != null)
					model.setAttrCtnt13(attrCtnt13[i]);
				if (attrCtnt12[i] != null)
					model.setAttrCtnt12(attrCtnt12[i]);
				if (attrCtnt11[i] != null)
					model.setAttrCtnt11(attrCtnt11[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (attrCtnt15[i] != null)
					model.setAttrCtnt15(attrCtnt15[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (vndrNo[i] != null)
					model.setVndrNo(vndrNo[i]);
				if (ppdGlDt[i] != null)
					model.setPpdGlDt(ppdGlDt[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (coaCoCd[i] != null)
					model.setCoaCoCd(coaCoCd[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (errCsrNo[i] != null)
					model.setErrCsrNo(errCsrNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (taxDeclFlg[i] != null)
					model.setTaxDeclFlg(taxDeclFlg[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (gloAttrCtnt17[i] != null)
					model.setGloAttrCtnt17(gloAttrCtnt17[i]);
				if (coaInterCoCd[i] != null)
					model.setCoaInterCoCd(coaInterCoCd[i]);
				if (gloAttrCtnt18[i] != null)
					model.setGloAttrCtnt18(gloAttrCtnt18[i]);
				if (gloAttrCtnt15[i] != null)
					model.setGloAttrCtnt15(gloAttrCtnt15[i]);
				if (attrCtnt9[i] != null)
					model.setAttrCtnt9(attrCtnt9[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (gloAttrCtnt16[i] != null)
					model.setGloAttrCtnt16(gloAttrCtnt16[i]);
				if (gloAttrCtnt13[i] != null)
					model.setGloAttrCtnt13(gloAttrCtnt13[i]);
				if (gloAttrCtnt14[i] != null)
					model.setGloAttrCtnt14(gloAttrCtnt14[i]);
				if (gloAttrCtnt11[i] != null)
					model.setGloAttrCtnt11(gloAttrCtnt11[i]);
				if (gloAttrCtnt12[i] != null)
					model.setGloAttrCtnt12(gloAttrCtnt12[i]);
				if (usrEm[i] != null)
					model.setUsrEm(usrEm[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (gloAttrCtnt10[i] != null)
					model.setGloAttrCtnt10(gloAttrCtnt10[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coaFtuN1stCd[i] != null)
					model.setCoaFtuN1stCd(coaFtuN1stCd[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (tjOfcCd[i] != null)
					model.setTjOfcCd(tjOfcCd[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (invTaxRt[i] != null)
					model.setInvTaxRt(invTaxRt[i]);
				if (actXchRt[i] != null)
					model.setActXchRt(actXchRt[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (coaCtrCd[i] != null)
					model.setCoaCtrCd(coaCtrCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSPCLCmpnCSRHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SPCLCmpnCSRHeaderVO[]
	 */
	public SPCLCmpnCSRHeaderVO[] getSPCLCmpnCSRHeaderVOs(){
		SPCLCmpnCSRHeaderVO[] vos = (SPCLCmpnCSRHeaderVO[])models.toArray(new SPCLCmpnCSRHeaderVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.impErrFlg = this.impErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaRgnCd = this.coaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdNo = this.ppdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdDtrbNo = this.ppdDtrbNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt = this.payAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt2 = this.ftuUseCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt1 = this.ftuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrTpCd = this.csrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt5 = this.ftuUseCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt4 = this.ftuUseCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt3 = this.ftuUseCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrFlg = this.rcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd = this.payGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayAplyFlg = this.ppayAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvFlg = this.rcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRsn = this.ifRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRsn = this.rcvRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt = this.invTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd = this.payMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaInterCompyCd = this.coaInterCompyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmt = this.totAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaAcctCd = this.coaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCurrXchFlg = this.taxCurrXchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt2 = this.gloAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt3 = this.gloAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt4 = this.gloAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt5 = this.gloAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt6 = this.gloAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAplyAmt = this.ppdAplyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt7 = this.gloAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt8 = this.gloAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt9 = this.gloAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt1 = this.gloAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaVvdCd = this.coaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaFtuN2ndCd = this.coaFtuN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.impErrRsn = this.impErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCtnt = this.srcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvErrRsn = this.rcvErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 = this.attrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 = this.attrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 = this.attrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 = this.attrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 = this.attrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 = this.attrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo = this.vndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdGlDt = this.ppdGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCoCd = this.coaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCsrNo = this.errCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxDeclFlg = this.taxDeclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOpt = this.ifOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt17 = this.gloAttrCtnt17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaInterCoCd = this.coaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt18 = this.gloAttrCtnt18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt15 = this.gloAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 = this.attrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt16 = this.gloAttrCtnt16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt13 = this.gloAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt14 = this.gloAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt11 = this.gloAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt12 = this.gloAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEm = this.usrEm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt10 = this.gloAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaFtuN1stCd = this.coaFtuN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjOfcCd = this.tjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxRt = this.invTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actXchRt = this.actXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCtrCd = this.coaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
