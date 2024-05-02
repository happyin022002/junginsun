/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnCSRINFtoAPVO.java
*@FileTitle : SPCLCmpnCSRINFtoAPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.04 김봉균 
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

public class SPCLCmpnCSRINFtoAPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SPCLCmpnCSRINFtoAPVO> models = new ArrayList<SPCLCmpnCSRINFtoAPVO>();
	
	/* Column Info */
	private String hdrCsrNo = null;
	/* Column Info */
	private String hdrCoaAcctCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String hdrCoaVvdCd = null;
	/* Column Info */
	private String ftuUseCtnt2 = null;
	/* Column Info */
	private String ftuUseCtnt1 = null;
	/* Column Info */
	private String attrCateNm = null;
	/* Column Info */
	private String ftuUseCtnt5 = null;
	/* Column Info */
	private String ftuUseCtnt4 = null;
	/* Column Info */
	private String hdrPayAmt = null;
	/* Column Info */
	private String ftuUseCtnt3 = null;
	/* Column Info */
	private String hdrPayGrpLuCd = null;
	/* Column Info */
	private String invTaxCd = null;
	/* Column Info */
	private String hdrIfDt = null;
	/* Column Info */
	private String hdrSrcCtnt = null;
	/* Column Info */
	private String hdrPpdAplyAmt = null;
	/* Column Info */
	private String hdrFtuUseCtnt1 = null;
	/* Column Info */
	private String hdrCoaFtuN2ndCd = null;
	/* Column Info */
	private String hdrFtuUseCtnt2 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String hdrFtuUseCtnt3 = null;
	/* Column Info */
	private String hdrFtuUseCtnt4 = null;
	/* Column Info */
	private String hdrRcvErrFlg = null;
	/* Column Info */
	private String hdrFtuUseCtnt5 = null;
	/* Column Info */
	private String hdrErrCsrNo = null;
	/* Column Info */
	private String hdrCoaCoCd = null;
	/* Column Info */
	private String dtrbCoaRgnCd = null;
	/* Column Info */
	private String hdrGloAttrCtnt17 = null;
	/* Column Info */
	private String hdrActXchRt = null;
	/* Column Info */
	private String hdrGloAttrCtnt18 = null;
	/* Column Info */
	private String hdrGloAttrCtnt15 = null;
	/* Column Info */
	private String hdrGloAttrCtnt16 = null;
	/* Column Info */
	private String hdrPayMzdLuCd = null;
	/* Column Info */
	private String hdrAttrCtnt5 = null;
	/* Column Info */
	private String hdrAttrCtnt4 = null;
	/* Column Info */
	private String hdrAttrCtnt3 = null;
	/* Column Info */
	private String hdrAttrCtnt2 = null;
	/* Column Info */
	private String hdrAttrCtnt1 = null;
	/* Column Info */
	private String hdrCsrTpCd = null;
	/* Column Info */
	private String hdrAttrCtnt9 = null;
	/* Column Info */
	private String hdrAttrCtnt8 = null;
	/* Column Info */
	private String hdrAttrCtnt7 = null;
	/* Column Info */
	private String hdrAttrCtnt6 = null;
	/* Column Info */
	private String dtrbCoaAcctCd = null;
	/* Column Info */
	private String dtrbCoaFtuN1stCd = null;
	/* Column Info */
	private String hdrGlDt = null;
	/* Column Info */
	private String soCrrCd = null;
	/* Column Info */
	private String hdrInvDesc = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String hdrGloAttrCtnt10 = null;
	/* Column Info */
	private String hdrInvTermDt = null;
	/* Column Info */
	private String hdrGloAttrCtnt12 = null;
	/* Column Info */
	private String hdrGloAttrCtnt11 = null;
	/* Column Info */
	private String hdrGloAttrCtnt14 = null;
	/* Column Info */
	private String hdrImpErrFlg = null;
	/* Column Info */
	private String hdrGloAttrCtnt13 = null;
	/* Column Info */
	private String hdrPpdNo = null;
	/* Column Info */
	private String hdrRcvErrRsn = null;
	/* Column Info */
	private String attrCtnt10 = null;
	/* Column Info */
	private String attrCtnt14 = null;
	/* Column Info */
	private String attrCtnt13 = null;
	/* Column Info */
	private String attrCtnt12 = null;
	/* Column Info */
	private String attrCtnt11 = null;
	/* Column Info */
	private String hdrCoaInterCoCd = null;
	/* Column Info */
	private String hdrCoaFtuN1stCd = null;
	/* Column Info */
	private String attrCtnt15 = null;
	/* Column Info */
	private String hdrPpdDtrbNo = null;
	/* Column Info */
	private String hdrIfFlg = null;
	/* Column Info */
	private String hdrTjOfcCd = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String hdrCsrCurrCd = null;
	/* Column Info */
	private String hdrCoaRgnCd = null;
	/* Column Info */
	private String hdrCoaCtrCd = null;
	/* Column Info */
	private String hdrInvDt = null;
	/* Column Info */
	private String hdrTaxDeclFlg = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String hdrVndrNo = null;
	/* Column Info */
	private String rowKnt = null;
	/* Column Info */
	private String hdrImpErrRsn = null;
	/* Column Info */
	private String lineNo = null;
	/* Column Info */
	private String ttlRowKnt = null;
	/* Column Info */
	private String hdrAttrCtnt14 = null;
	/* Column Info */
	private String hdrAttrCtnt13 = null;
	/* Column Info */
	private String hdrAttrCtnt15 = null;
	/* Column Info */
	private String hdrCsrAmt = null;
	/* Column Info */
	private String lifId = null;
	/* Column Info */
	private String hdrVndrTermNm = null;
	/* Column Info */
	private String actVvdCd = null;
	/* Column Info */
	private String dtrbCoaFtuN2ndCd = null;
	/* Column Info */
	private String lineSeq = null;
	/* Column Info */
	private String hdrIfErrRsn = null;
	/* Column Info */
	private String hdrUsrEml = null;
	/* Column Info */
	private String attrCtnt9 = null;
	/* Column Info */
	private String hdrAttrCtnt11 = null;
	/* Column Info */
	private String hdrAttrCtnt12 = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String hdrAttrCtnt10 = null;
	/* Column Info */
	private String hdrPayDt = null;
	/* Column Info */
	private String dtrbCoaInterCoCd = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String hdrGloAttrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String hdrPpayAplyFlg = null;
	/* Column Info */
	private String hdrGloAttrCtnt2 = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String hdrGloAttrCtnt1 = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String hdrPpdGlDt = null;
	/* Column Info */
	private String hdrGloAttrCtnt7 = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String hdrGloAttrCtnt6 = null;
	/* Column Info */
	private String lineTpLuCd = null;
	/* Column Info */
	private String hdrGloAttrCtnt5 = null;
	/* Column Info */
	private String hdrGloAttrCtnt4 = null;
	/* Column Info */
	private String hdrGloAttrCtnt9 = null;
	/* Column Info */
	private String hdrGloAttrCtnt8 = null;
	/* Column Info */
	private String dtrbCoaCoCd = null;
	/* Column Info */
	private String dtrbCoaCtrCd = null;
	/* Column Info */
	private String plnSctrDivCd = null;
	/* Column Info */
	private String hdrAproFlg = null;
	/* Column Info */
	private String hdrTaxCurrXchFlg = null;
	/* Column Info */
	private String dtrbCoaVvdCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String hdrAttrCateNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SPCLCmpnCSRINFtoAPVO() {}

	public SPCLCmpnCSRINFtoAPVO(String ibflag, String pagerows, String hdrCsrNo, String hdrCoaAcctCd, String cntrTpszCd, String ftuUseCtnt2, String hdrCoaVvdCd, String ftuUseCtnt1, String ftuUseCtnt5, String attrCateNm, String ftuUseCtnt4, String ftuUseCtnt3, String hdrPayAmt, String hdrPayGrpLuCd, String invTaxCd, String hdrIfDt, String hdrSrcCtnt, String hdrPpdAplyAmt, String hdrFtuUseCtnt1, String hdrCoaFtuN2ndCd, String hdrFtuUseCtnt2, String bkgNo, String hdrFtuUseCtnt3, String hdrFtuUseCtnt4, String hdrRcvErrFlg, String hdrCoaCoCd, String hdrErrCsrNo, String hdrFtuUseCtnt5, String dtrbCoaRgnCd, String hdrGloAttrCtnt17, String hdrGloAttrCtnt18, String hdrActXchRt, String hdrGloAttrCtnt15, String hdrGloAttrCtnt16, String hdrPayMzdLuCd, String hdrAttrCtnt5, String hdrAttrCtnt4, String hdrAttrCtnt3, String hdrAttrCtnt2, String hdrCsrTpCd, String hdrAttrCtnt1, String hdrAttrCtnt9, String hdrAttrCtnt8, String hdrAttrCtnt7, String dtrbCoaFtuN1stCd, String dtrbCoaAcctCd, String hdrAttrCtnt6, String hdrGlDt, String soCrrCd, String hdrInvDesc, String ydCd, String hdrGloAttrCtnt10, String hdrInvTermDt, String hdrGloAttrCtnt12, String hdrGloAttrCtnt11, String hdrGloAttrCtnt14, String hdrImpErrFlg, String hdrGloAttrCtnt13, String hdrPpdNo, String hdrRcvErrRsn, String attrCtnt10, String attrCtnt14, String attrCtnt13, String attrCtnt12, String attrCtnt11, String hdrCoaInterCoCd, String hdrCoaFtuN1stCd, String attrCtnt15, String hdrPpdDtrbNo, String hdrIfFlg, String hdrTjOfcCd, String invDesc, String hdrCsrCurrCd, String hdrCoaRgnCd, String hdrCoaCtrCd, String hdrInvDt, String hdrTaxDeclFlg, String csrNo, String hdrVndrNo, String rowKnt, String hdrImpErrRsn, String lineNo, String ttlRowKnt, String hdrAttrCtnt14, String hdrAttrCtnt13, String hdrAttrCtnt15, String hdrCsrAmt, String lifId, String hdrVndrTermNm, String actVvdCd, String dtrbCoaFtuN2ndCd, String lineSeq, String hdrIfErrRsn, String hdrUsrEml, String attrCtnt9, String hdrAttrCtnt11, String attrCtnt8, String hdrAttrCtnt12, String hdrAttrCtnt10, String hdrPayDt, String attrCtnt1, String dtrbCoaInterCoCd, String attrCtnt2, String attrCtnt3, String attrCtnt4, String hdrGloAttrCtnt3, String attrCtnt5, String hdrGloAttrCtnt2, String hdrPpayAplyFlg, String attrCtnt6, String hdrGloAttrCtnt1, String attrCtnt7, String hdrGloAttrCtnt7, String hdrPpdGlDt, String hdrGloAttrCtnt6, String invAmt, String hdrGloAttrCtnt5, String lineTpLuCd, String hdrGloAttrCtnt4, String hdrGloAttrCtnt9, String hdrGloAttrCtnt8, String dtrbCoaCoCd, String dtrbCoaCtrCd, String plnSctrDivCd, String hdrAproFlg, String hdrTaxCurrXchFlg, String dtrbCoaVvdCd, String seq, String hdrAttrCateNm) {
		this.hdrCsrNo = hdrCsrNo;
		this.hdrCoaAcctCd = hdrCoaAcctCd;
		this.pagerows = pagerows;
		this.cntrTpszCd = cntrTpszCd;
		this.hdrCoaVvdCd = hdrCoaVvdCd;
		this.ftuUseCtnt2 = ftuUseCtnt2;
		this.ftuUseCtnt1 = ftuUseCtnt1;
		this.attrCateNm = attrCateNm;
		this.ftuUseCtnt5 = ftuUseCtnt5;
		this.ftuUseCtnt4 = ftuUseCtnt4;
		this.hdrPayAmt = hdrPayAmt;
		this.ftuUseCtnt3 = ftuUseCtnt3;
		this.hdrPayGrpLuCd = hdrPayGrpLuCd;
		this.invTaxCd = invTaxCd;
		this.hdrIfDt = hdrIfDt;
		this.hdrSrcCtnt = hdrSrcCtnt;
		this.hdrPpdAplyAmt = hdrPpdAplyAmt;
		this.hdrFtuUseCtnt1 = hdrFtuUseCtnt1;
		this.hdrCoaFtuN2ndCd = hdrCoaFtuN2ndCd;
		this.hdrFtuUseCtnt2 = hdrFtuUseCtnt2;
		this.bkgNo = bkgNo;
		this.hdrFtuUseCtnt3 = hdrFtuUseCtnt3;
		this.hdrFtuUseCtnt4 = hdrFtuUseCtnt4;
		this.hdrRcvErrFlg = hdrRcvErrFlg;
		this.hdrFtuUseCtnt5 = hdrFtuUseCtnt5;
		this.hdrErrCsrNo = hdrErrCsrNo;
		this.hdrCoaCoCd = hdrCoaCoCd;
		this.dtrbCoaRgnCd = dtrbCoaRgnCd;
		this.hdrGloAttrCtnt17 = hdrGloAttrCtnt17;
		this.hdrActXchRt = hdrActXchRt;
		this.hdrGloAttrCtnt18 = hdrGloAttrCtnt18;
		this.hdrGloAttrCtnt15 = hdrGloAttrCtnt15;
		this.hdrGloAttrCtnt16 = hdrGloAttrCtnt16;
		this.hdrPayMzdLuCd = hdrPayMzdLuCd;
		this.hdrAttrCtnt5 = hdrAttrCtnt5;
		this.hdrAttrCtnt4 = hdrAttrCtnt4;
		this.hdrAttrCtnt3 = hdrAttrCtnt3;
		this.hdrAttrCtnt2 = hdrAttrCtnt2;
		this.hdrAttrCtnt1 = hdrAttrCtnt1;
		this.hdrCsrTpCd = hdrCsrTpCd;
		this.hdrAttrCtnt9 = hdrAttrCtnt9;
		this.hdrAttrCtnt8 = hdrAttrCtnt8;
		this.hdrAttrCtnt7 = hdrAttrCtnt7;
		this.hdrAttrCtnt6 = hdrAttrCtnt6;
		this.dtrbCoaAcctCd = dtrbCoaAcctCd;
		this.dtrbCoaFtuN1stCd = dtrbCoaFtuN1stCd;
		this.hdrGlDt = hdrGlDt;
		this.soCrrCd = soCrrCd;
		this.hdrInvDesc = hdrInvDesc;
		this.ydCd = ydCd;
		this.hdrGloAttrCtnt10 = hdrGloAttrCtnt10;
		this.hdrInvTermDt = hdrInvTermDt;
		this.hdrGloAttrCtnt12 = hdrGloAttrCtnt12;
		this.hdrGloAttrCtnt11 = hdrGloAttrCtnt11;
		this.hdrGloAttrCtnt14 = hdrGloAttrCtnt14;
		this.hdrImpErrFlg = hdrImpErrFlg;
		this.hdrGloAttrCtnt13 = hdrGloAttrCtnt13;
		this.hdrPpdNo = hdrPpdNo;
		this.hdrRcvErrRsn = hdrRcvErrRsn;
		this.attrCtnt10 = attrCtnt10;
		this.attrCtnt14 = attrCtnt14;
		this.attrCtnt13 = attrCtnt13;
		this.attrCtnt12 = attrCtnt12;
		this.attrCtnt11 = attrCtnt11;
		this.hdrCoaInterCoCd = hdrCoaInterCoCd;
		this.hdrCoaFtuN1stCd = hdrCoaFtuN1stCd;
		this.attrCtnt15 = attrCtnt15;
		this.hdrPpdDtrbNo = hdrPpdDtrbNo;
		this.hdrIfFlg = hdrIfFlg;
		this.hdrTjOfcCd = hdrTjOfcCd;
		this.invDesc = invDesc;
		this.hdrCsrCurrCd = hdrCsrCurrCd;
		this.hdrCoaRgnCd = hdrCoaRgnCd;
		this.hdrCoaCtrCd = hdrCoaCtrCd;
		this.hdrInvDt = hdrInvDt;
		this.hdrTaxDeclFlg = hdrTaxDeclFlg;
		this.csrNo = csrNo;
		this.hdrVndrNo = hdrVndrNo;
		this.rowKnt = rowKnt;
		this.hdrImpErrRsn = hdrImpErrRsn;
		this.lineNo = lineNo;
		this.ttlRowKnt = ttlRowKnt;
		this.hdrAttrCtnt14 = hdrAttrCtnt14;
		this.hdrAttrCtnt13 = hdrAttrCtnt13;
		this.hdrAttrCtnt15 = hdrAttrCtnt15;
		this.hdrCsrAmt = hdrCsrAmt;
		this.lifId = lifId;
		this.hdrVndrTermNm = hdrVndrTermNm;
		this.actVvdCd = actVvdCd;
		this.dtrbCoaFtuN2ndCd = dtrbCoaFtuN2ndCd;
		this.lineSeq = lineSeq;
		this.hdrIfErrRsn = hdrIfErrRsn;
		this.hdrUsrEml = hdrUsrEml;
		this.attrCtnt9 = attrCtnt9;
		this.hdrAttrCtnt11 = hdrAttrCtnt11;
		this.hdrAttrCtnt12 = hdrAttrCtnt12;
		this.attrCtnt8 = attrCtnt8;
		this.hdrAttrCtnt10 = hdrAttrCtnt10;
		this.hdrPayDt = hdrPayDt;
		this.dtrbCoaInterCoCd = dtrbCoaInterCoCd;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.attrCtnt3 = attrCtnt3;
		this.hdrGloAttrCtnt3 = hdrGloAttrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.hdrPpayAplyFlg = hdrPpayAplyFlg;
		this.hdrGloAttrCtnt2 = hdrGloAttrCtnt2;
		this.attrCtnt5 = attrCtnt5;
		this.hdrGloAttrCtnt1 = hdrGloAttrCtnt1;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.hdrPpdGlDt = hdrPpdGlDt;
		this.hdrGloAttrCtnt7 = hdrGloAttrCtnt7;
		this.invAmt = invAmt;
		this.hdrGloAttrCtnt6 = hdrGloAttrCtnt6;
		this.lineTpLuCd = lineTpLuCd;
		this.hdrGloAttrCtnt5 = hdrGloAttrCtnt5;
		this.hdrGloAttrCtnt4 = hdrGloAttrCtnt4;
		this.hdrGloAttrCtnt9 = hdrGloAttrCtnt9;
		this.hdrGloAttrCtnt8 = hdrGloAttrCtnt8;
		this.dtrbCoaCoCd = dtrbCoaCoCd;
		this.dtrbCoaCtrCd = dtrbCoaCtrCd;
		this.plnSctrDivCd = plnSctrDivCd;
		this.hdrAproFlg = hdrAproFlg;
		this.hdrTaxCurrXchFlg = hdrTaxCurrXchFlg;
		this.dtrbCoaVvdCd = dtrbCoaVvdCd;
		this.seq = seq;
		this.hdrAttrCateNm = hdrAttrCateNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hdr_csr_no", getHdrCsrNo());
		this.hashColumns.put("hdr_coa_acct_cd", getHdrCoaAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("hdr_coa_vvd_cd", getHdrCoaVvdCd());
		this.hashColumns.put("ftu_use_ctnt2", getFtuUseCtnt2());
		this.hashColumns.put("ftu_use_ctnt1", getFtuUseCtnt1());
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());
		this.hashColumns.put("ftu_use_ctnt5", getFtuUseCtnt5());
		this.hashColumns.put("ftu_use_ctnt4", getFtuUseCtnt4());
		this.hashColumns.put("hdr_pay_amt", getHdrPayAmt());
		this.hashColumns.put("ftu_use_ctnt3", getFtuUseCtnt3());
		this.hashColumns.put("hdr_pay_grp_lu_cd", getHdrPayGrpLuCd());
		this.hashColumns.put("inv_tax_cd", getInvTaxCd());
		this.hashColumns.put("hdr_if_dt", getHdrIfDt());
		this.hashColumns.put("hdr_src_ctnt", getHdrSrcCtnt());
		this.hashColumns.put("hdr_ppd_aply_amt", getHdrPpdAplyAmt());
		this.hashColumns.put("hdr_ftu_use_ctnt1", getHdrFtuUseCtnt1());
		this.hashColumns.put("hdr_coa_ftu_n2nd_cd", getHdrCoaFtuN2ndCd());
		this.hashColumns.put("hdr_ftu_use_ctnt2", getHdrFtuUseCtnt2());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("hdr_ftu_use_ctnt3", getHdrFtuUseCtnt3());
		this.hashColumns.put("hdr_ftu_use_ctnt4", getHdrFtuUseCtnt4());
		this.hashColumns.put("hdr_rcv_err_flg", getHdrRcvErrFlg());
		this.hashColumns.put("hdr_ftu_use_ctnt5", getHdrFtuUseCtnt5());
		this.hashColumns.put("hdr_err_csr_no", getHdrErrCsrNo());
		this.hashColumns.put("hdr_coa_co_cd", getHdrCoaCoCd());
		this.hashColumns.put("dtrb_coa_rgn_cd", getDtrbCoaRgnCd());
		this.hashColumns.put("hdr_glo_attr_ctnt17", getHdrGloAttrCtnt17());
		this.hashColumns.put("hdr_act_xch_rt", getHdrActXchRt());
		this.hashColumns.put("hdr_glo_attr_ctnt18", getHdrGloAttrCtnt18());
		this.hashColumns.put("hdr_glo_attr_ctnt15", getHdrGloAttrCtnt15());
		this.hashColumns.put("hdr_glo_attr_ctnt16", getHdrGloAttrCtnt16());
		this.hashColumns.put("hdr_pay_mzd_lu_cd", getHdrPayMzdLuCd());
		this.hashColumns.put("hdr_attr_ctnt5", getHdrAttrCtnt5());
		this.hashColumns.put("hdr_attr_ctnt4", getHdrAttrCtnt4());
		this.hashColumns.put("hdr_attr_ctnt3", getHdrAttrCtnt3());
		this.hashColumns.put("hdr_attr_ctnt2", getHdrAttrCtnt2());
		this.hashColumns.put("hdr_attr_ctnt1", getHdrAttrCtnt1());
		this.hashColumns.put("hdr_csr_tp_cd", getHdrCsrTpCd());
		this.hashColumns.put("hdr_attr_ctnt9", getHdrAttrCtnt9());
		this.hashColumns.put("hdr_attr_ctnt8", getHdrAttrCtnt8());
		this.hashColumns.put("hdr_attr_ctnt7", getHdrAttrCtnt7());
		this.hashColumns.put("hdr_attr_ctnt6", getHdrAttrCtnt6());
		this.hashColumns.put("dtrb_coa_acct_cd", getDtrbCoaAcctCd());
		this.hashColumns.put("dtrb_coa_ftu_n1st_cd", getDtrbCoaFtuN1stCd());
		this.hashColumns.put("hdr_gl_dt", getHdrGlDt());
		this.hashColumns.put("so_crr_cd", getSoCrrCd());
		this.hashColumns.put("hdr_inv_desc", getHdrInvDesc());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("hdr_glo_attr_ctnt10", getHdrGloAttrCtnt10());
		this.hashColumns.put("hdr_inv_term_dt", getHdrInvTermDt());
		this.hashColumns.put("hdr_glo_attr_ctnt12", getHdrGloAttrCtnt12());
		this.hashColumns.put("hdr_glo_attr_ctnt11", getHdrGloAttrCtnt11());
		this.hashColumns.put("hdr_glo_attr_ctnt14", getHdrGloAttrCtnt14());
		this.hashColumns.put("hdr_imp_err_flg", getHdrImpErrFlg());
		this.hashColumns.put("hdr_glo_attr_ctnt13", getHdrGloAttrCtnt13());
		this.hashColumns.put("hdr_ppd_no", getHdrPpdNo());
		this.hashColumns.put("hdr_rcv_err_rsn", getHdrRcvErrRsn());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());
		this.hashColumns.put("hdr_coa_inter_co_cd", getHdrCoaInterCoCd());
		this.hashColumns.put("hdr_coa_ftu_n1st_cd", getHdrCoaFtuN1stCd());
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());
		this.hashColumns.put("hdr_ppd_dtrb_no", getHdrPpdDtrbNo());
		this.hashColumns.put("hdr_if_flg", getHdrIfFlg());
		this.hashColumns.put("hdr_tj_ofc_cd", getHdrTjOfcCd());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("hdr_csr_curr_cd", getHdrCsrCurrCd());
		this.hashColumns.put("hdr_coa_rgn_cd", getHdrCoaRgnCd());
		this.hashColumns.put("hdr_coa_ctr_cd", getHdrCoaCtrCd());
		this.hashColumns.put("hdr_inv_dt", getHdrInvDt());
		this.hashColumns.put("hdr_tax_decl_flg", getHdrTaxDeclFlg());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("hdr_vndr_no", getHdrVndrNo());
		this.hashColumns.put("row_knt", getRowKnt());
		this.hashColumns.put("hdr_imp_err_rsn", getHdrImpErrRsn());
		this.hashColumns.put("line_no", getLineNo());
		this.hashColumns.put("ttl_row_knt", getTtlRowKnt());
		this.hashColumns.put("hdr_attr_ctnt14", getHdrAttrCtnt14());
		this.hashColumns.put("hdr_attr_ctnt13", getHdrAttrCtnt13());
		this.hashColumns.put("hdr_attr_ctnt15", getHdrAttrCtnt15());
		this.hashColumns.put("hdr_csr_amt", getHdrCsrAmt());
		this.hashColumns.put("lif_id", getLifId());
		this.hashColumns.put("hdr_vndr_term_nm", getHdrVndrTermNm());
		this.hashColumns.put("act_vvd_cd", getActVvdCd());
		this.hashColumns.put("dtrb_coa_ftu_n2nd_cd", getDtrbCoaFtuN2ndCd());
		this.hashColumns.put("line_seq", getLineSeq());
		this.hashColumns.put("hdr_if_err_rsn", getHdrIfErrRsn());
		this.hashColumns.put("hdr_usr_eml", getHdrUsrEml());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("hdr_attr_ctnt11", getHdrAttrCtnt11());
		this.hashColumns.put("hdr_attr_ctnt12", getHdrAttrCtnt12());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("hdr_attr_ctnt10", getHdrAttrCtnt10());
		this.hashColumns.put("hdr_pay_dt", getHdrPayDt());
		this.hashColumns.put("dtrb_coa_inter_co_cd", getDtrbCoaInterCoCd());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("hdr_glo_attr_ctnt3", getHdrGloAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("hdr_ppay_aply_flg", getHdrPpayAplyFlg());
		this.hashColumns.put("hdr_glo_attr_ctnt2", getHdrGloAttrCtnt2());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("hdr_glo_attr_ctnt1", getHdrGloAttrCtnt1());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("hdr_ppd_gl_dt", getHdrPpdGlDt());
		this.hashColumns.put("hdr_glo_attr_ctnt7", getHdrGloAttrCtnt7());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("hdr_glo_attr_ctnt6", getHdrGloAttrCtnt6());
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());
		this.hashColumns.put("hdr_glo_attr_ctnt5", getHdrGloAttrCtnt5());
		this.hashColumns.put("hdr_glo_attr_ctnt4", getHdrGloAttrCtnt4());
		this.hashColumns.put("hdr_glo_attr_ctnt9", getHdrGloAttrCtnt9());
		this.hashColumns.put("hdr_glo_attr_ctnt8", getHdrGloAttrCtnt8());
		this.hashColumns.put("dtrb_coa_co_cd", getDtrbCoaCoCd());
		this.hashColumns.put("dtrb_coa_ctr_cd", getDtrbCoaCtrCd());
		this.hashColumns.put("pln_sctr_div_cd", getPlnSctrDivCd());
		this.hashColumns.put("hdr_apro_flg", getHdrAproFlg());
		this.hashColumns.put("hdr_tax_curr_xch_flg", getHdrTaxCurrXchFlg());
		this.hashColumns.put("dtrb_coa_vvd_cd", getDtrbCoaVvdCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("hdr_attr_cate_nm", getHdrAttrCateNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hdr_csr_no", "hdrCsrNo");
		this.hashFields.put("hdr_coa_acct_cd", "hdrCoaAcctCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("hdr_coa_vvd_cd", "hdrCoaVvdCd");
		this.hashFields.put("ftu_use_ctnt2", "ftuUseCtnt2");
		this.hashFields.put("ftu_use_ctnt1", "ftuUseCtnt1");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("ftu_use_ctnt5", "ftuUseCtnt5");
		this.hashFields.put("ftu_use_ctnt4", "ftuUseCtnt4");
		this.hashFields.put("hdr_pay_amt", "hdrPayAmt");
		this.hashFields.put("ftu_use_ctnt3", "ftuUseCtnt3");
		this.hashFields.put("hdr_pay_grp_lu_cd", "hdrPayGrpLuCd");
		this.hashFields.put("inv_tax_cd", "invTaxCd");
		this.hashFields.put("hdr_if_dt", "hdrIfDt");
		this.hashFields.put("hdr_src_ctnt", "hdrSrcCtnt");
		this.hashFields.put("hdr_ppd_aply_amt", "hdrPpdAplyAmt");
		this.hashFields.put("hdr_ftu_use_ctnt1", "hdrFtuUseCtnt1");
		this.hashFields.put("hdr_coa_ftu_n2nd_cd", "hdrCoaFtuN2ndCd");
		this.hashFields.put("hdr_ftu_use_ctnt2", "hdrFtuUseCtnt2");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("hdr_ftu_use_ctnt3", "hdrFtuUseCtnt3");
		this.hashFields.put("hdr_ftu_use_ctnt4", "hdrFtuUseCtnt4");
		this.hashFields.put("hdr_rcv_err_flg", "hdrRcvErrFlg");
		this.hashFields.put("hdr_ftu_use_ctnt5", "hdrFtuUseCtnt5");
		this.hashFields.put("hdr_err_csr_no", "hdrErrCsrNo");
		this.hashFields.put("hdr_coa_co_cd", "hdrCoaCoCd");
		this.hashFields.put("dtrb_coa_rgn_cd", "dtrbCoaRgnCd");
		this.hashFields.put("hdr_glo_attr_ctnt17", "hdrGloAttrCtnt17");
		this.hashFields.put("hdr_act_xch_rt", "hdrActXchRt");
		this.hashFields.put("hdr_glo_attr_ctnt18", "hdrGloAttrCtnt18");
		this.hashFields.put("hdr_glo_attr_ctnt15", "hdrGloAttrCtnt15");
		this.hashFields.put("hdr_glo_attr_ctnt16", "hdrGloAttrCtnt16");
		this.hashFields.put("hdr_pay_mzd_lu_cd", "hdrPayMzdLuCd");
		this.hashFields.put("hdr_attr_ctnt5", "hdrAttrCtnt5");
		this.hashFields.put("hdr_attr_ctnt4", "hdrAttrCtnt4");
		this.hashFields.put("hdr_attr_ctnt3", "hdrAttrCtnt3");
		this.hashFields.put("hdr_attr_ctnt2", "hdrAttrCtnt2");
		this.hashFields.put("hdr_attr_ctnt1", "hdrAttrCtnt1");
		this.hashFields.put("hdr_csr_tp_cd", "hdrCsrTpCd");
		this.hashFields.put("hdr_attr_ctnt9", "hdrAttrCtnt9");
		this.hashFields.put("hdr_attr_ctnt8", "hdrAttrCtnt8");
		this.hashFields.put("hdr_attr_ctnt7", "hdrAttrCtnt7");
		this.hashFields.put("hdr_attr_ctnt6", "hdrAttrCtnt6");
		this.hashFields.put("dtrb_coa_acct_cd", "dtrbCoaAcctCd");
		this.hashFields.put("dtrb_coa_ftu_n1st_cd", "dtrbCoaFtuN1stCd");
		this.hashFields.put("hdr_gl_dt", "hdrGlDt");
		this.hashFields.put("so_crr_cd", "soCrrCd");
		this.hashFields.put("hdr_inv_desc", "hdrInvDesc");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("hdr_glo_attr_ctnt10", "hdrGloAttrCtnt10");
		this.hashFields.put("hdr_inv_term_dt", "hdrInvTermDt");
		this.hashFields.put("hdr_glo_attr_ctnt12", "hdrGloAttrCtnt12");
		this.hashFields.put("hdr_glo_attr_ctnt11", "hdrGloAttrCtnt11");
		this.hashFields.put("hdr_glo_attr_ctnt14", "hdrGloAttrCtnt14");
		this.hashFields.put("hdr_imp_err_flg", "hdrImpErrFlg");
		this.hashFields.put("hdr_glo_attr_ctnt13", "hdrGloAttrCtnt13");
		this.hashFields.put("hdr_ppd_no", "hdrPpdNo");
		this.hashFields.put("hdr_rcv_err_rsn", "hdrRcvErrRsn");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("hdr_coa_inter_co_cd", "hdrCoaInterCoCd");
		this.hashFields.put("hdr_coa_ftu_n1st_cd", "hdrCoaFtuN1stCd");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("hdr_ppd_dtrb_no", "hdrPpdDtrbNo");
		this.hashFields.put("hdr_if_flg", "hdrIfFlg");
		this.hashFields.put("hdr_tj_ofc_cd", "hdrTjOfcCd");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("hdr_csr_curr_cd", "hdrCsrCurrCd");
		this.hashFields.put("hdr_coa_rgn_cd", "hdrCoaRgnCd");
		this.hashFields.put("hdr_coa_ctr_cd", "hdrCoaCtrCd");
		this.hashFields.put("hdr_inv_dt", "hdrInvDt");
		this.hashFields.put("hdr_tax_decl_flg", "hdrTaxDeclFlg");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("hdr_vndr_no", "hdrVndrNo");
		this.hashFields.put("row_knt", "rowKnt");
		this.hashFields.put("hdr_imp_err_rsn", "hdrImpErrRsn");
		this.hashFields.put("line_no", "lineNo");
		this.hashFields.put("ttl_row_knt", "ttlRowKnt");
		this.hashFields.put("hdr_attr_ctnt14", "hdrAttrCtnt14");
		this.hashFields.put("hdr_attr_ctnt13", "hdrAttrCtnt13");
		this.hashFields.put("hdr_attr_ctnt15", "hdrAttrCtnt15");
		this.hashFields.put("hdr_csr_amt", "hdrCsrAmt");
		this.hashFields.put("lif_id", "lifId");
		this.hashFields.put("hdr_vndr_term_nm", "hdrVndrTermNm");
		this.hashFields.put("act_vvd_cd", "actVvdCd");
		this.hashFields.put("dtrb_coa_ftu_n2nd_cd", "dtrbCoaFtuN2ndCd");
		this.hashFields.put("line_seq", "lineSeq");
		this.hashFields.put("hdr_if_err_rsn", "hdrIfErrRsn");
		this.hashFields.put("hdr_usr_eml", "hdrUsrEml");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("hdr_attr_ctnt11", "hdrAttrCtnt11");
		this.hashFields.put("hdr_attr_ctnt12", "hdrAttrCtnt12");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("hdr_attr_ctnt10", "hdrAttrCtnt10");
		this.hashFields.put("hdr_pay_dt", "hdrPayDt");
		this.hashFields.put("dtrb_coa_inter_co_cd", "dtrbCoaInterCoCd");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("hdr_glo_attr_ctnt3", "hdrGloAttrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("hdr_ppay_aply_flg", "hdrPpayAplyFlg");
		this.hashFields.put("hdr_glo_attr_ctnt2", "hdrGloAttrCtnt2");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("hdr_glo_attr_ctnt1", "hdrGloAttrCtnt1");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("hdr_ppd_gl_dt", "hdrPpdGlDt");
		this.hashFields.put("hdr_glo_attr_ctnt7", "hdrGloAttrCtnt7");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("hdr_glo_attr_ctnt6", "hdrGloAttrCtnt6");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("hdr_glo_attr_ctnt5", "hdrGloAttrCtnt5");
		this.hashFields.put("hdr_glo_attr_ctnt4", "hdrGloAttrCtnt4");
		this.hashFields.put("hdr_glo_attr_ctnt9", "hdrGloAttrCtnt9");
		this.hashFields.put("hdr_glo_attr_ctnt8", "hdrGloAttrCtnt8");
		this.hashFields.put("dtrb_coa_co_cd", "dtrbCoaCoCd");
		this.hashFields.put("dtrb_coa_ctr_cd", "dtrbCoaCtrCd");
		this.hashFields.put("pln_sctr_div_cd", "plnSctrDivCd");
		this.hashFields.put("hdr_apro_flg", "hdrAproFlg");
		this.hashFields.put("hdr_tax_curr_xch_flg", "hdrTaxCurrXchFlg");
		this.hashFields.put("dtrb_coa_vvd_cd", "dtrbCoaVvdCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("hdr_attr_cate_nm", "hdrAttrCateNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdrCsrNo
	 */
	public String getHdrCsrNo() {
		return this.hdrCsrNo;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaAcctCd
	 */
	public String getHdrCoaAcctCd() {
		return this.hdrCoaAcctCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaVvdCd
	 */
	public String getHdrCoaVvdCd() {
		return this.hdrCoaVvdCd;
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
	 * @return hdrPayAmt
	 */
	public String getHdrPayAmt() {
		return this.hdrPayAmt;
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
	 * @return hdrPayGrpLuCd
	 */
	public String getHdrPayGrpLuCd() {
		return this.hdrPayGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @return invTaxCd
	 */
	public String getInvTaxCd() {
		return this.invTaxCd;
	}
	
	/**
	 * Column Info
	 * @return hdrIfDt
	 */
	public String getHdrIfDt() {
		return this.hdrIfDt;
	}
	
	/**
	 * Column Info
	 * @return hdrSrcCtnt
	 */
	public String getHdrSrcCtnt() {
		return this.hdrSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @return hdrPpdAplyAmt
	 */
	public String getHdrPpdAplyAmt() {
		return this.hdrPpdAplyAmt;
	}
	
	/**
	 * Column Info
	 * @return hdrFtuUseCtnt1
	 */
	public String getHdrFtuUseCtnt1() {
		return this.hdrFtuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaFtuN2ndCd
	 */
	public String getHdrCoaFtuN2ndCd() {
		return this.hdrCoaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return hdrFtuUseCtnt2
	 */
	public String getHdrFtuUseCtnt2() {
		return this.hdrFtuUseCtnt2;
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
	 * @return hdrFtuUseCtnt3
	 */
	public String getHdrFtuUseCtnt3() {
		return this.hdrFtuUseCtnt3;
	}
	
	/**
	 * Column Info
	 * @return hdrFtuUseCtnt4
	 */
	public String getHdrFtuUseCtnt4() {
		return this.hdrFtuUseCtnt4;
	}
	
	/**
	 * Column Info
	 * @return hdrRcvErrFlg
	 */
	public String getHdrRcvErrFlg() {
		return this.hdrRcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrFtuUseCtnt5
	 */
	public String getHdrFtuUseCtnt5() {
		return this.hdrFtuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @return hdrErrCsrNo
	 */
	public String getHdrErrCsrNo() {
		return this.hdrErrCsrNo;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaCoCd
	 */
	public String getHdrCoaCoCd() {
		return this.hdrCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaRgnCd
	 */
	public String getDtrbCoaRgnCd() {
		return this.dtrbCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt17
	 */
	public String getHdrGloAttrCtnt17() {
		return this.hdrGloAttrCtnt17;
	}
	
	/**
	 * Column Info
	 * @return hdrActXchRt
	 */
	public String getHdrActXchRt() {
		return this.hdrActXchRt;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt18
	 */
	public String getHdrGloAttrCtnt18() {
		return this.hdrGloAttrCtnt18;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt15
	 */
	public String getHdrGloAttrCtnt15() {
		return this.hdrGloAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt16
	 */
	public String getHdrGloAttrCtnt16() {
		return this.hdrGloAttrCtnt16;
	}
	
	/**
	 * Column Info
	 * @return hdrPayMzdLuCd
	 */
	public String getHdrPayMzdLuCd() {
		return this.hdrPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt5
	 */
	public String getHdrAttrCtnt5() {
		return this.hdrAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt4
	 */
	public String getHdrAttrCtnt4() {
		return this.hdrAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt3
	 */
	public String getHdrAttrCtnt3() {
		return this.hdrAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt2
	 */
	public String getHdrAttrCtnt2() {
		return this.hdrAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt1
	 */
	public String getHdrAttrCtnt1() {
		return this.hdrAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return hdrCsrTpCd
	 */
	public String getHdrCsrTpCd() {
		return this.hdrCsrTpCd;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt9
	 */
	public String getHdrAttrCtnt9() {
		return this.hdrAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt8
	 */
	public String getHdrAttrCtnt8() {
		return this.hdrAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt7
	 */
	public String getHdrAttrCtnt7() {
		return this.hdrAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt6
	 */
	public String getHdrAttrCtnt6() {
		return this.hdrAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaAcctCd
	 */
	public String getDtrbCoaAcctCd() {
		return this.dtrbCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaFtuN1stCd
	 */
	public String getDtrbCoaFtuN1stCd() {
		return this.dtrbCoaFtuN1stCd;
	}
	
	/**
	 * Column Info
	 * @return hdrGlDt
	 */
	public String getHdrGlDt() {
		return this.hdrGlDt;
	}
	
	/**
	 * Column Info
	 * @return soCrrCd
	 */
	public String getSoCrrCd() {
		return this.soCrrCd;
	}
	
	/**
	 * Column Info
	 * @return hdrInvDesc
	 */
	public String getHdrInvDesc() {
		return this.hdrInvDesc;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt10
	 */
	public String getHdrGloAttrCtnt10() {
		return this.hdrGloAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return hdrInvTermDt
	 */
	public String getHdrInvTermDt() {
		return this.hdrInvTermDt;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt12
	 */
	public String getHdrGloAttrCtnt12() {
		return this.hdrGloAttrCtnt12;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt11
	 */
	public String getHdrGloAttrCtnt11() {
		return this.hdrGloAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt14
	 */
	public String getHdrGloAttrCtnt14() {
		return this.hdrGloAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return hdrImpErrFlg
	 */
	public String getHdrImpErrFlg() {
		return this.hdrImpErrFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt13
	 */
	public String getHdrGloAttrCtnt13() {
		return this.hdrGloAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return hdrPpdNo
	 */
	public String getHdrPpdNo() {
		return this.hdrPpdNo;
	}
	
	/**
	 * Column Info
	 * @return hdrRcvErrRsn
	 */
	public String getHdrRcvErrRsn() {
		return this.hdrRcvErrRsn;
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
	 * @return hdrCoaInterCoCd
	 */
	public String getHdrCoaInterCoCd() {
		return this.hdrCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaFtuN1stCd
	 */
	public String getHdrCoaFtuN1stCd() {
		return this.hdrCoaFtuN1stCd;
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
	 * @return hdrPpdDtrbNo
	 */
	public String getHdrPpdDtrbNo() {
		return this.hdrPpdDtrbNo;
	}
	
	/**
	 * Column Info
	 * @return hdrIfFlg
	 */
	public String getHdrIfFlg() {
		return this.hdrIfFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrTjOfcCd
	 */
	public String getHdrTjOfcCd() {
		return this.hdrTjOfcCd;
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
	 * @return hdrCsrCurrCd
	 */
	public String getHdrCsrCurrCd() {
		return this.hdrCsrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaRgnCd
	 */
	public String getHdrCoaRgnCd() {
		return this.hdrCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return hdrCoaCtrCd
	 */
	public String getHdrCoaCtrCd() {
		return this.hdrCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return hdrInvDt
	 */
	public String getHdrInvDt() {
		return this.hdrInvDt;
	}
	
	/**
	 * Column Info
	 * @return hdrTaxDeclFlg
	 */
	public String getHdrTaxDeclFlg() {
		return this.hdrTaxDeclFlg;
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
	 * @return hdrVndrNo
	 */
	public String getHdrVndrNo() {
		return this.hdrVndrNo;
	}
	
	/**
	 * Column Info
	 * @return rowKnt
	 */
	public String getRowKnt() {
		return this.rowKnt;
	}
	
	/**
	 * Column Info
	 * @return hdrImpErrRsn
	 */
	public String getHdrImpErrRsn() {
		return this.hdrImpErrRsn;
	}
	
	/**
	 * Column Info
	 * @return lineNo
	 */
	public String getLineNo() {
		return this.lineNo;
	}
	
	/**
	 * Column Info
	 * @return ttlRowKnt
	 */
	public String getTtlRowKnt() {
		return this.ttlRowKnt;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt14
	 */
	public String getHdrAttrCtnt14() {
		return this.hdrAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt13
	 */
	public String getHdrAttrCtnt13() {
		return this.hdrAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt15
	 */
	public String getHdrAttrCtnt15() {
		return this.hdrAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @return hdrCsrAmt
	 */
	public String getHdrCsrAmt() {
		return this.hdrCsrAmt;
	}
	
	/**
	 * Column Info
	 * @return lifId
	 */
	public String getLifId() {
		return this.lifId;
	}
	
	/**
	 * Column Info
	 * @return hdrVndrTermNm
	 */
	public String getHdrVndrTermNm() {
		return this.hdrVndrTermNm;
	}
	
	/**
	 * Column Info
	 * @return actVvdCd
	 */
	public String getActVvdCd() {
		return this.actVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaFtuN2ndCd
	 */
	public String getDtrbCoaFtuN2ndCd() {
		return this.dtrbCoaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return lineSeq
	 */
	public String getLineSeq() {
		return this.lineSeq;
	}
	
	/**
	 * Column Info
	 * @return hdrIfErrRsn
	 */
	public String getHdrIfErrRsn() {
		return this.hdrIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @return hdrUsrEml
	 */
	public String getHdrUsrEml() {
		return this.hdrUsrEml;
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
	 * @return hdrAttrCtnt11
	 */
	public String getHdrAttrCtnt11() {
		return this.hdrAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCtnt12
	 */
	public String getHdrAttrCtnt12() {
		return this.hdrAttrCtnt12;
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
	 * @return hdrAttrCtnt10
	 */
	public String getHdrAttrCtnt10() {
		return this.hdrAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return hdrPayDt
	 */
	public String getHdrPayDt() {
		return this.hdrPayDt;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaInterCoCd
	 */
	public String getDtrbCoaInterCoCd() {
		return this.dtrbCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt3
	 */
	public String getHdrGloAttrCtnt3() {
		return this.hdrGloAttrCtnt3;
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
	 * @return hdrPpayAplyFlg
	 */
	public String getHdrPpayAplyFlg() {
		return this.hdrPpayAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt2
	 */
	public String getHdrGloAttrCtnt2() {
		return this.hdrGloAttrCtnt2;
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
	 * @return hdrGloAttrCtnt1
	 */
	public String getHdrGloAttrCtnt1() {
		return this.hdrGloAttrCtnt1;
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
	 * @return hdrPpdGlDt
	 */
	public String getHdrPpdGlDt() {
		return this.hdrPpdGlDt;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt7
	 */
	public String getHdrGloAttrCtnt7() {
		return this.hdrGloAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt6
	 */
	public String getHdrGloAttrCtnt6() {
		return this.hdrGloAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return lineTpLuCd
	 */
	public String getLineTpLuCd() {
		return this.lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt5
	 */
	public String getHdrGloAttrCtnt5() {
		return this.hdrGloAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt4
	 */
	public String getHdrGloAttrCtnt4() {
		return this.hdrGloAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt9
	 */
	public String getHdrGloAttrCtnt9() {
		return this.hdrGloAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return hdrGloAttrCtnt8
	 */
	public String getHdrGloAttrCtnt8() {
		return this.hdrGloAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaCoCd
	 */
	public String getDtrbCoaCoCd() {
		return this.dtrbCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaCtrCd
	 */
	public String getDtrbCoaCtrCd() {
		return this.dtrbCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return plnSctrDivCd
	 */
	public String getPlnSctrDivCd() {
		return this.plnSctrDivCd;
	}
	
	/**
	 * Column Info
	 * @return hdrAproFlg
	 */
	public String getHdrAproFlg() {
		return this.hdrAproFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrTaxCurrXchFlg
	 */
	public String getHdrTaxCurrXchFlg() {
		return this.hdrTaxCurrXchFlg;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoaVvdCd
	 */
	public String getDtrbCoaVvdCd() {
		return this.dtrbCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return hdrAttrCateNm
	 */
	public String getHdrAttrCateNm() {
		return this.hdrAttrCateNm;
	}
	

	/**
	 * Column Info
	 * @param hdrCsrNo
	 */
	public void setHdrCsrNo(String hdrCsrNo) {
		this.hdrCsrNo = hdrCsrNo;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaAcctCd
	 */
	public void setHdrCoaAcctCd(String hdrCoaAcctCd) {
		this.hdrCoaAcctCd = hdrCoaAcctCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaVvdCd
	 */
	public void setHdrCoaVvdCd(String hdrCoaVvdCd) {
		this.hdrCoaVvdCd = hdrCoaVvdCd;
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
	 * @param hdrPayAmt
	 */
	public void setHdrPayAmt(String hdrPayAmt) {
		this.hdrPayAmt = hdrPayAmt;
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
	 * @param hdrPayGrpLuCd
	 */
	public void setHdrPayGrpLuCd(String hdrPayGrpLuCd) {
		this.hdrPayGrpLuCd = hdrPayGrpLuCd;
	}
	
	/**
	 * Column Info
	 * @param invTaxCd
	 */
	public void setInvTaxCd(String invTaxCd) {
		this.invTaxCd = invTaxCd;
	}
	
	/**
	 * Column Info
	 * @param hdrIfDt
	 */
	public void setHdrIfDt(String hdrIfDt) {
		this.hdrIfDt = hdrIfDt;
	}
	
	/**
	 * Column Info
	 * @param hdrSrcCtnt
	 */
	public void setHdrSrcCtnt(String hdrSrcCtnt) {
		this.hdrSrcCtnt = hdrSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @param hdrPpdAplyAmt
	 */
	public void setHdrPpdAplyAmt(String hdrPpdAplyAmt) {
		this.hdrPpdAplyAmt = hdrPpdAplyAmt;
	}
	
	/**
	 * Column Info
	 * @param hdrFtuUseCtnt1
	 */
	public void setHdrFtuUseCtnt1(String hdrFtuUseCtnt1) {
		this.hdrFtuUseCtnt1 = hdrFtuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaFtuN2ndCd
	 */
	public void setHdrCoaFtuN2ndCd(String hdrCoaFtuN2ndCd) {
		this.hdrCoaFtuN2ndCd = hdrCoaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param hdrFtuUseCtnt2
	 */
	public void setHdrFtuUseCtnt2(String hdrFtuUseCtnt2) {
		this.hdrFtuUseCtnt2 = hdrFtuUseCtnt2;
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
	 * @param hdrFtuUseCtnt3
	 */
	public void setHdrFtuUseCtnt3(String hdrFtuUseCtnt3) {
		this.hdrFtuUseCtnt3 = hdrFtuUseCtnt3;
	}
	
	/**
	 * Column Info
	 * @param hdrFtuUseCtnt4
	 */
	public void setHdrFtuUseCtnt4(String hdrFtuUseCtnt4) {
		this.hdrFtuUseCtnt4 = hdrFtuUseCtnt4;
	}
	
	/**
	 * Column Info
	 * @param hdrRcvErrFlg
	 */
	public void setHdrRcvErrFlg(String hdrRcvErrFlg) {
		this.hdrRcvErrFlg = hdrRcvErrFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrFtuUseCtnt5
	 */
	public void setHdrFtuUseCtnt5(String hdrFtuUseCtnt5) {
		this.hdrFtuUseCtnt5 = hdrFtuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @param hdrErrCsrNo
	 */
	public void setHdrErrCsrNo(String hdrErrCsrNo) {
		this.hdrErrCsrNo = hdrErrCsrNo;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaCoCd
	 */
	public void setHdrCoaCoCd(String hdrCoaCoCd) {
		this.hdrCoaCoCd = hdrCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaRgnCd
	 */
	public void setDtrbCoaRgnCd(String dtrbCoaRgnCd) {
		this.dtrbCoaRgnCd = dtrbCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt17
	 */
	public void setHdrGloAttrCtnt17(String hdrGloAttrCtnt17) {
		this.hdrGloAttrCtnt17 = hdrGloAttrCtnt17;
	}
	
	/**
	 * Column Info
	 * @param hdrActXchRt
	 */
	public void setHdrActXchRt(String hdrActXchRt) {
		this.hdrActXchRt = hdrActXchRt;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt18
	 */
	public void setHdrGloAttrCtnt18(String hdrGloAttrCtnt18) {
		this.hdrGloAttrCtnt18 = hdrGloAttrCtnt18;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt15
	 */
	public void setHdrGloAttrCtnt15(String hdrGloAttrCtnt15) {
		this.hdrGloAttrCtnt15 = hdrGloAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt16
	 */
	public void setHdrGloAttrCtnt16(String hdrGloAttrCtnt16) {
		this.hdrGloAttrCtnt16 = hdrGloAttrCtnt16;
	}
	
	/**
	 * Column Info
	 * @param hdrPayMzdLuCd
	 */
	public void setHdrPayMzdLuCd(String hdrPayMzdLuCd) {
		this.hdrPayMzdLuCd = hdrPayMzdLuCd;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt5
	 */
	public void setHdrAttrCtnt5(String hdrAttrCtnt5) {
		this.hdrAttrCtnt5 = hdrAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt4
	 */
	public void setHdrAttrCtnt4(String hdrAttrCtnt4) {
		this.hdrAttrCtnt4 = hdrAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt3
	 */
	public void setHdrAttrCtnt3(String hdrAttrCtnt3) {
		this.hdrAttrCtnt3 = hdrAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt2
	 */
	public void setHdrAttrCtnt2(String hdrAttrCtnt2) {
		this.hdrAttrCtnt2 = hdrAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt1
	 */
	public void setHdrAttrCtnt1(String hdrAttrCtnt1) {
		this.hdrAttrCtnt1 = hdrAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param hdrCsrTpCd
	 */
	public void setHdrCsrTpCd(String hdrCsrTpCd) {
		this.hdrCsrTpCd = hdrCsrTpCd;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt9
	 */
	public void setHdrAttrCtnt9(String hdrAttrCtnt9) {
		this.hdrAttrCtnt9 = hdrAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt8
	 */
	public void setHdrAttrCtnt8(String hdrAttrCtnt8) {
		this.hdrAttrCtnt8 = hdrAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt7
	 */
	public void setHdrAttrCtnt7(String hdrAttrCtnt7) {
		this.hdrAttrCtnt7 = hdrAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt6
	 */
	public void setHdrAttrCtnt6(String hdrAttrCtnt6) {
		this.hdrAttrCtnt6 = hdrAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaAcctCd
	 */
	public void setDtrbCoaAcctCd(String dtrbCoaAcctCd) {
		this.dtrbCoaAcctCd = dtrbCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaFtuN1stCd
	 */
	public void setDtrbCoaFtuN1stCd(String dtrbCoaFtuN1stCd) {
		this.dtrbCoaFtuN1stCd = dtrbCoaFtuN1stCd;
	}
	
	/**
	 * Column Info
	 * @param hdrGlDt
	 */
	public void setHdrGlDt(String hdrGlDt) {
		this.hdrGlDt = hdrGlDt;
	}
	
	/**
	 * Column Info
	 * @param soCrrCd
	 */
	public void setSoCrrCd(String soCrrCd) {
		this.soCrrCd = soCrrCd;
	}
	
	/**
	 * Column Info
	 * @param hdrInvDesc
	 */
	public void setHdrInvDesc(String hdrInvDesc) {
		this.hdrInvDesc = hdrInvDesc;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt10
	 */
	public void setHdrGloAttrCtnt10(String hdrGloAttrCtnt10) {
		this.hdrGloAttrCtnt10 = hdrGloAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param hdrInvTermDt
	 */
	public void setHdrInvTermDt(String hdrInvTermDt) {
		this.hdrInvTermDt = hdrInvTermDt;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt12
	 */
	public void setHdrGloAttrCtnt12(String hdrGloAttrCtnt12) {
		this.hdrGloAttrCtnt12 = hdrGloAttrCtnt12;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt11
	 */
	public void setHdrGloAttrCtnt11(String hdrGloAttrCtnt11) {
		this.hdrGloAttrCtnt11 = hdrGloAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt14
	 */
	public void setHdrGloAttrCtnt14(String hdrGloAttrCtnt14) {
		this.hdrGloAttrCtnt14 = hdrGloAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param hdrImpErrFlg
	 */
	public void setHdrImpErrFlg(String hdrImpErrFlg) {
		this.hdrImpErrFlg = hdrImpErrFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt13
	 */
	public void setHdrGloAttrCtnt13(String hdrGloAttrCtnt13) {
		this.hdrGloAttrCtnt13 = hdrGloAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param hdrPpdNo
	 */
	public void setHdrPpdNo(String hdrPpdNo) {
		this.hdrPpdNo = hdrPpdNo;
	}
	
	/**
	 * Column Info
	 * @param hdrRcvErrRsn
	 */
	public void setHdrRcvErrRsn(String hdrRcvErrRsn) {
		this.hdrRcvErrRsn = hdrRcvErrRsn;
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
	 * @param hdrCoaInterCoCd
	 */
	public void setHdrCoaInterCoCd(String hdrCoaInterCoCd) {
		this.hdrCoaInterCoCd = hdrCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaFtuN1stCd
	 */
	public void setHdrCoaFtuN1stCd(String hdrCoaFtuN1stCd) {
		this.hdrCoaFtuN1stCd = hdrCoaFtuN1stCd;
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
	 * @param hdrPpdDtrbNo
	 */
	public void setHdrPpdDtrbNo(String hdrPpdDtrbNo) {
		this.hdrPpdDtrbNo = hdrPpdDtrbNo;
	}
	
	/**
	 * Column Info
	 * @param hdrIfFlg
	 */
	public void setHdrIfFlg(String hdrIfFlg) {
		this.hdrIfFlg = hdrIfFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrTjOfcCd
	 */
	public void setHdrTjOfcCd(String hdrTjOfcCd) {
		this.hdrTjOfcCd = hdrTjOfcCd;
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
	 * @param hdrCsrCurrCd
	 */
	public void setHdrCsrCurrCd(String hdrCsrCurrCd) {
		this.hdrCsrCurrCd = hdrCsrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaRgnCd
	 */
	public void setHdrCoaRgnCd(String hdrCoaRgnCd) {
		this.hdrCoaRgnCd = hdrCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param hdrCoaCtrCd
	 */
	public void setHdrCoaCtrCd(String hdrCoaCtrCd) {
		this.hdrCoaCtrCd = hdrCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param hdrInvDt
	 */
	public void setHdrInvDt(String hdrInvDt) {
		this.hdrInvDt = hdrInvDt;
	}
	
	/**
	 * Column Info
	 * @param hdrTaxDeclFlg
	 */
	public void setHdrTaxDeclFlg(String hdrTaxDeclFlg) {
		this.hdrTaxDeclFlg = hdrTaxDeclFlg;
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
	 * @param hdrVndrNo
	 */
	public void setHdrVndrNo(String hdrVndrNo) {
		this.hdrVndrNo = hdrVndrNo;
	}
	
	/**
	 * Column Info
	 * @param rowKnt
	 */
	public void setRowKnt(String rowKnt) {
		this.rowKnt = rowKnt;
	}
	
	/**
	 * Column Info
	 * @param hdrImpErrRsn
	 */
	public void setHdrImpErrRsn(String hdrImpErrRsn) {
		this.hdrImpErrRsn = hdrImpErrRsn;
	}
	
	/**
	 * Column Info
	 * @param lineNo
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	
	/**
	 * Column Info
	 * @param ttlRowKnt
	 */
	public void setTtlRowKnt(String ttlRowKnt) {
		this.ttlRowKnt = ttlRowKnt;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt14
	 */
	public void setHdrAttrCtnt14(String hdrAttrCtnt14) {
		this.hdrAttrCtnt14 = hdrAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt13
	 */
	public void setHdrAttrCtnt13(String hdrAttrCtnt13) {
		this.hdrAttrCtnt13 = hdrAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt15
	 */
	public void setHdrAttrCtnt15(String hdrAttrCtnt15) {
		this.hdrAttrCtnt15 = hdrAttrCtnt15;
	}
	
	/**
	 * Column Info
	 * @param hdrCsrAmt
	 */
	public void setHdrCsrAmt(String hdrCsrAmt) {
		this.hdrCsrAmt = hdrCsrAmt;
	}
	
	/**
	 * Column Info
	 * @param lifId
	 */
	public void setLifId(String lifId) {
		this.lifId = lifId;
	}
	
	/**
	 * Column Info
	 * @param hdrVndrTermNm
	 */
	public void setHdrVndrTermNm(String hdrVndrTermNm) {
		this.hdrVndrTermNm = hdrVndrTermNm;
	}
	
	/**
	 * Column Info
	 * @param actVvdCd
	 */
	public void setActVvdCd(String actVvdCd) {
		this.actVvdCd = actVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaFtuN2ndCd
	 */
	public void setDtrbCoaFtuN2ndCd(String dtrbCoaFtuN2ndCd) {
		this.dtrbCoaFtuN2ndCd = dtrbCoaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param lineSeq
	 */
	public void setLineSeq(String lineSeq) {
		this.lineSeq = lineSeq;
	}
	
	/**
	 * Column Info
	 * @param hdrIfErrRsn
	 */
	public void setHdrIfErrRsn(String hdrIfErrRsn) {
		this.hdrIfErrRsn = hdrIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @param hdrUsrEml
	 */
	public void setHdrUsrEml(String hdrUsrEml) {
		this.hdrUsrEml = hdrUsrEml;
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
	 * @param hdrAttrCtnt11
	 */
	public void setHdrAttrCtnt11(String hdrAttrCtnt11) {
		this.hdrAttrCtnt11 = hdrAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCtnt12
	 */
	public void setHdrAttrCtnt12(String hdrAttrCtnt12) {
		this.hdrAttrCtnt12 = hdrAttrCtnt12;
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
	 * @param hdrAttrCtnt10
	 */
	public void setHdrAttrCtnt10(String hdrAttrCtnt10) {
		this.hdrAttrCtnt10 = hdrAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param hdrPayDt
	 */
	public void setHdrPayDt(String hdrPayDt) {
		this.hdrPayDt = hdrPayDt;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaInterCoCd
	 */
	public void setDtrbCoaInterCoCd(String dtrbCoaInterCoCd) {
		this.dtrbCoaInterCoCd = dtrbCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt3
	 */
	public void setHdrGloAttrCtnt3(String hdrGloAttrCtnt3) {
		this.hdrGloAttrCtnt3 = hdrGloAttrCtnt3;
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
	 * @param hdrPpayAplyFlg
	 */
	public void setHdrPpayAplyFlg(String hdrPpayAplyFlg) {
		this.hdrPpayAplyFlg = hdrPpayAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt2
	 */
	public void setHdrGloAttrCtnt2(String hdrGloAttrCtnt2) {
		this.hdrGloAttrCtnt2 = hdrGloAttrCtnt2;
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
	 * @param hdrGloAttrCtnt1
	 */
	public void setHdrGloAttrCtnt1(String hdrGloAttrCtnt1) {
		this.hdrGloAttrCtnt1 = hdrGloAttrCtnt1;
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
	 * @param hdrPpdGlDt
	 */
	public void setHdrPpdGlDt(String hdrPpdGlDt) {
		this.hdrPpdGlDt = hdrPpdGlDt;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt7
	 */
	public void setHdrGloAttrCtnt7(String hdrGloAttrCtnt7) {
		this.hdrGloAttrCtnt7 = hdrGloAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt6
	 */
	public void setHdrGloAttrCtnt6(String hdrGloAttrCtnt6) {
		this.hdrGloAttrCtnt6 = hdrGloAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param lineTpLuCd
	 */
	public void setLineTpLuCd(String lineTpLuCd) {
		this.lineTpLuCd = lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt5
	 */
	public void setHdrGloAttrCtnt5(String hdrGloAttrCtnt5) {
		this.hdrGloAttrCtnt5 = hdrGloAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt4
	 */
	public void setHdrGloAttrCtnt4(String hdrGloAttrCtnt4) {
		this.hdrGloAttrCtnt4 = hdrGloAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt9
	 */
	public void setHdrGloAttrCtnt9(String hdrGloAttrCtnt9) {
		this.hdrGloAttrCtnt9 = hdrGloAttrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param hdrGloAttrCtnt8
	 */
	public void setHdrGloAttrCtnt8(String hdrGloAttrCtnt8) {
		this.hdrGloAttrCtnt8 = hdrGloAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaCoCd
	 */
	public void setDtrbCoaCoCd(String dtrbCoaCoCd) {
		this.dtrbCoaCoCd = dtrbCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaCtrCd
	 */
	public void setDtrbCoaCtrCd(String dtrbCoaCtrCd) {
		this.dtrbCoaCtrCd = dtrbCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param plnSctrDivCd
	 */
	public void setPlnSctrDivCd(String plnSctrDivCd) {
		this.plnSctrDivCd = plnSctrDivCd;
	}
	
	/**
	 * Column Info
	 * @param hdrAproFlg
	 */
	public void setHdrAproFlg(String hdrAproFlg) {
		this.hdrAproFlg = hdrAproFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrTaxCurrXchFlg
	 */
	public void setHdrTaxCurrXchFlg(String hdrTaxCurrXchFlg) {
		this.hdrTaxCurrXchFlg = hdrTaxCurrXchFlg;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoaVvdCd
	 */
	public void setDtrbCoaVvdCd(String dtrbCoaVvdCd) {
		this.dtrbCoaVvdCd = dtrbCoaVvdCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCateNm
	 */
	public void setHdrAttrCateNm(String hdrAttrCateNm) {
		this.hdrAttrCateNm = hdrAttrCateNm;
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
		setHdrCsrNo(JSPUtil.getParameter(request, prefix + "hdr_csr_no", ""));
		setHdrCoaAcctCd(JSPUtil.getParameter(request, prefix + "hdr_coa_acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setHdrCoaVvdCd(JSPUtil.getParameter(request, prefix + "hdr_coa_vvd_cd", ""));
		setFtuUseCtnt2(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt2", ""));
		setFtuUseCtnt1(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt1", ""));
		setAttrCateNm(JSPUtil.getParameter(request, prefix + "attr_cate_nm", ""));
		setFtuUseCtnt5(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt5", ""));
		setFtuUseCtnt4(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt4", ""));
		setHdrPayAmt(JSPUtil.getParameter(request, prefix + "hdr_pay_amt", ""));
		setFtuUseCtnt3(JSPUtil.getParameter(request, prefix + "ftu_use_ctnt3", ""));
		setHdrPayGrpLuCd(JSPUtil.getParameter(request, prefix + "hdr_pay_grp_lu_cd", ""));
		setInvTaxCd(JSPUtil.getParameter(request, prefix + "inv_tax_cd", ""));
		setHdrIfDt(JSPUtil.getParameter(request, prefix + "hdr_if_dt", ""));
		setHdrSrcCtnt(JSPUtil.getParameter(request, prefix + "hdr_src_ctnt", ""));
		setHdrPpdAplyAmt(JSPUtil.getParameter(request, prefix + "hdr_ppd_aply_amt", ""));
		setHdrFtuUseCtnt1(JSPUtil.getParameter(request, prefix + "hdr_ftu_use_ctnt1", ""));
		setHdrCoaFtuN2ndCd(JSPUtil.getParameter(request, prefix + "hdr_coa_ftu_n2nd_cd", ""));
		setHdrFtuUseCtnt2(JSPUtil.getParameter(request, prefix + "hdr_ftu_use_ctnt2", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setHdrFtuUseCtnt3(JSPUtil.getParameter(request, prefix + "hdr_ftu_use_ctnt3", ""));
		setHdrFtuUseCtnt4(JSPUtil.getParameter(request, prefix + "hdr_ftu_use_ctnt4", ""));
		setHdrRcvErrFlg(JSPUtil.getParameter(request, prefix + "hdr_rcv_err_flg", ""));
		setHdrFtuUseCtnt5(JSPUtil.getParameter(request, prefix + "hdr_ftu_use_ctnt5", ""));
		setHdrErrCsrNo(JSPUtil.getParameter(request, prefix + "hdr_err_csr_no", ""));
		setHdrCoaCoCd(JSPUtil.getParameter(request, prefix + "hdr_coa_co_cd", ""));
		setDtrbCoaRgnCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_rgn_cd", ""));
		setHdrGloAttrCtnt17(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt17", ""));
		setHdrActXchRt(JSPUtil.getParameter(request, prefix + "hdr_act_xch_rt", ""));
		setHdrGloAttrCtnt18(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt18", ""));
		setHdrGloAttrCtnt15(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt15", ""));
		setHdrGloAttrCtnt16(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt16", ""));
		setHdrPayMzdLuCd(JSPUtil.getParameter(request, prefix + "hdr_pay_mzd_lu_cd", ""));
		setHdrAttrCtnt5(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt5", ""));
		setHdrAttrCtnt4(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt4", ""));
		setHdrAttrCtnt3(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt3", ""));
		setHdrAttrCtnt2(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt2", ""));
		setHdrAttrCtnt1(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt1", ""));
		setHdrCsrTpCd(JSPUtil.getParameter(request, prefix + "hdr_csr_tp_cd", ""));
		setHdrAttrCtnt9(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt9", ""));
		setHdrAttrCtnt8(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt8", ""));
		setHdrAttrCtnt7(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt7", ""));
		setHdrAttrCtnt6(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt6", ""));
		setDtrbCoaAcctCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_acct_cd", ""));
		setDtrbCoaFtuN1stCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_ftu_n1st_cd", ""));
		setHdrGlDt(JSPUtil.getParameter(request, prefix + "hdr_gl_dt", ""));
		setSoCrrCd(JSPUtil.getParameter(request, prefix + "so_crr_cd", ""));
		setHdrInvDesc(JSPUtil.getParameter(request, prefix + "hdr_inv_desc", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setHdrGloAttrCtnt10(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt10", ""));
		setHdrInvTermDt(JSPUtil.getParameter(request, prefix + "hdr_inv_term_dt", ""));
		setHdrGloAttrCtnt12(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt12", ""));
		setHdrGloAttrCtnt11(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt11", ""));
		setHdrGloAttrCtnt14(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt14", ""));
		setHdrImpErrFlg(JSPUtil.getParameter(request, prefix + "hdr_imp_err_flg", ""));
		setHdrGloAttrCtnt13(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt13", ""));
		setHdrPpdNo(JSPUtil.getParameter(request, prefix + "hdr_ppd_no", ""));
		setHdrRcvErrRsn(JSPUtil.getParameter(request, prefix + "hdr_rcv_err_rsn", ""));
		setAttrCtnt10(JSPUtil.getParameter(request, prefix + "attr_ctnt10", ""));
		setAttrCtnt14(JSPUtil.getParameter(request, prefix + "attr_ctnt14", ""));
		setAttrCtnt13(JSPUtil.getParameter(request, prefix + "attr_ctnt13", ""));
		setAttrCtnt12(JSPUtil.getParameter(request, prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request, prefix + "attr_ctnt11", ""));
		setHdrCoaInterCoCd(JSPUtil.getParameter(request, prefix + "hdr_coa_inter_co_cd", ""));
		setHdrCoaFtuN1stCd(JSPUtil.getParameter(request, prefix + "hdr_coa_ftu_n1st_cd", ""));
		setAttrCtnt15(JSPUtil.getParameter(request, prefix + "attr_ctnt15", ""));
		setHdrPpdDtrbNo(JSPUtil.getParameter(request, prefix + "hdr_ppd_dtrb_no", ""));
		setHdrIfFlg(JSPUtil.getParameter(request, prefix + "hdr_if_flg", ""));
		setHdrTjOfcCd(JSPUtil.getParameter(request, prefix + "hdr_tj_ofc_cd", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setHdrCsrCurrCd(JSPUtil.getParameter(request, prefix + "hdr_csr_curr_cd", ""));
		setHdrCoaRgnCd(JSPUtil.getParameter(request, prefix + "hdr_coa_rgn_cd", ""));
		setHdrCoaCtrCd(JSPUtil.getParameter(request, prefix + "hdr_coa_ctr_cd", ""));
		setHdrInvDt(JSPUtil.getParameter(request, prefix + "hdr_inv_dt", ""));
		setHdrTaxDeclFlg(JSPUtil.getParameter(request, prefix + "hdr_tax_decl_flg", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setHdrVndrNo(JSPUtil.getParameter(request, prefix + "hdr_vndr_no", ""));
		setRowKnt(JSPUtil.getParameter(request, prefix + "row_knt", ""));
		setHdrImpErrRsn(JSPUtil.getParameter(request, prefix + "hdr_imp_err_rsn", ""));
		setLineNo(JSPUtil.getParameter(request, prefix + "line_no", ""));
		setTtlRowKnt(JSPUtil.getParameter(request, prefix + "ttl_row_knt", ""));
		setHdrAttrCtnt14(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt14", ""));
		setHdrAttrCtnt13(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt13", ""));
		setHdrAttrCtnt15(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt15", ""));
		setHdrCsrAmt(JSPUtil.getParameter(request, prefix + "hdr_csr_amt", ""));
		setLifId(JSPUtil.getParameter(request, prefix + "lif_id", ""));
		setHdrVndrTermNm(JSPUtil.getParameter(request, prefix + "hdr_vndr_term_nm", ""));
		setActVvdCd(JSPUtil.getParameter(request, prefix + "act_vvd_cd", ""));
		setDtrbCoaFtuN2ndCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_ftu_n2nd_cd", ""));
		setLineSeq(JSPUtil.getParameter(request, prefix + "line_seq", ""));
		setHdrIfErrRsn(JSPUtil.getParameter(request, prefix + "hdr_if_err_rsn", ""));
		setHdrUsrEml(JSPUtil.getParameter(request, prefix + "hdr_usr_eml", ""));
		setAttrCtnt9(JSPUtil.getParameter(request, prefix + "attr_ctnt9", ""));
		setHdrAttrCtnt11(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt11", ""));
		setHdrAttrCtnt12(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt12", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setHdrAttrCtnt10(JSPUtil.getParameter(request, prefix + "hdr_attr_ctnt10", ""));
		setHdrPayDt(JSPUtil.getParameter(request, prefix + "hdr_pay_dt", ""));
		setDtrbCoaInterCoCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_inter_co_cd", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setHdrGloAttrCtnt3(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setHdrPpayAplyFlg(JSPUtil.getParameter(request, prefix + "hdr_ppay_aply_flg", ""));
		setHdrGloAttrCtnt2(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt2", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setHdrGloAttrCtnt1(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt1", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setHdrPpdGlDt(JSPUtil.getParameter(request, prefix + "hdr_ppd_gl_dt", ""));
		setHdrGloAttrCtnt7(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt7", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setHdrGloAttrCtnt6(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt6", ""));
		setLineTpLuCd(JSPUtil.getParameter(request, prefix + "line_tp_lu_cd", ""));
		setHdrGloAttrCtnt5(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt5", ""));
		setHdrGloAttrCtnt4(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt4", ""));
		setHdrGloAttrCtnt9(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt9", ""));
		setHdrGloAttrCtnt8(JSPUtil.getParameter(request, prefix + "hdr_glo_attr_ctnt8", ""));
		setDtrbCoaCoCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_co_cd", ""));
		setDtrbCoaCtrCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_ctr_cd", ""));
		setPlnSctrDivCd(JSPUtil.getParameter(request, prefix + "pln_sctr_div_cd", ""));
		setHdrAproFlg(JSPUtil.getParameter(request, prefix + "hdr_apro_flg", ""));
		setHdrTaxCurrXchFlg(JSPUtil.getParameter(request, prefix + "hdr_tax_curr_xch_flg", ""));
		setDtrbCoaVvdCd(JSPUtil.getParameter(request, prefix + "dtrb_coa_vvd_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setHdrAttrCateNm(JSPUtil.getParameter(request, prefix + "hdr_attr_cate_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SPCLCmpnCSRINFtoAPVO[]
	 */
	public SPCLCmpnCSRINFtoAPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SPCLCmpnCSRINFtoAPVO[]
	 */
	public SPCLCmpnCSRINFtoAPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SPCLCmpnCSRINFtoAPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_no", length));
			String[] hdrCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_acct_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] hdrCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_vvd_cd", length));
			String[] ftuUseCtnt2 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt2", length));
			String[] ftuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt1", length));
			String[] attrCateNm = (JSPUtil.getParameter(request, prefix	+ "attr_cate_nm", length));
			String[] ftuUseCtnt5 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt5", length));
			String[] ftuUseCtnt4 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt4", length));
			String[] hdrPayAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_amt", length));
			String[] ftuUseCtnt3 = (JSPUtil.getParameter(request, prefix	+ "ftu_use_ctnt3", length));
			String[] hdrPayGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_grp_lu_cd", length));
			String[] invTaxCd = (JSPUtil.getParameter(request, prefix	+ "inv_tax_cd", length));
			String[] hdrIfDt = (JSPUtil.getParameter(request, prefix	+ "hdr_if_dt", length));
			String[] hdrSrcCtnt = (JSPUtil.getParameter(request, prefix	+ "hdr_src_ctnt", length));
			String[] hdrPpdAplyAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_aply_amt", length));
			String[] hdrFtuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt1", length));
			String[] hdrCoaFtuN2ndCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ftu_n2nd_cd", length));
			String[] hdrFtuUseCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt2", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] hdrFtuUseCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt3", length));
			String[] hdrFtuUseCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt4", length));
			String[] hdrRcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_rcv_err_flg", length));
			String[] hdrFtuUseCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt5", length));
			String[] hdrErrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_err_csr_no", length));
			String[] hdrCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_co_cd", length));
			String[] dtrbCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_rgn_cd", length));
			String[] hdrGloAttrCtnt17 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt17", length));
			String[] hdrActXchRt = (JSPUtil.getParameter(request, prefix	+ "hdr_act_xch_rt", length));
			String[] hdrGloAttrCtnt18 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt18", length));
			String[] hdrGloAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt15", length));
			String[] hdrGloAttrCtnt16 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt16", length));
			String[] hdrPayMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_mzd_lu_cd", length));
			String[] hdrAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt5", length));
			String[] hdrAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt4", length));
			String[] hdrAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt3", length));
			String[] hdrAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt2", length));
			String[] hdrAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt1", length));
			String[] hdrCsrTpCd = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_tp_cd", length));
			String[] hdrAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt9", length));
			String[] hdrAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt8", length));
			String[] hdrAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt7", length));
			String[] hdrAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt6", length));
			String[] dtrbCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_acct_cd", length));
			String[] dtrbCoaFtuN1stCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_ftu_n1st_cd", length));
			String[] hdrGlDt = (JSPUtil.getParameter(request, prefix	+ "hdr_gl_dt", length));
			String[] soCrrCd = (JSPUtil.getParameter(request, prefix	+ "so_crr_cd", length));
			String[] hdrInvDesc = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_desc", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] hdrGloAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt10", length));
			String[] hdrInvTermDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_term_dt", length));
			String[] hdrGloAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt12", length));
			String[] hdrGloAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt11", length));
			String[] hdrGloAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt14", length));
			String[] hdrImpErrFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_imp_err_flg", length));
			String[] hdrGloAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt13", length));
			String[] hdrPpdNo = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_no", length));
			String[] hdrRcvErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_rcv_err_rsn", length));
			String[] attrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt10", length));
			String[] attrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt14", length));
			String[] attrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt13", length));
			String[] attrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt12", length));
			String[] attrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt11", length));
			String[] hdrCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_inter_co_cd", length));
			String[] hdrCoaFtuN1stCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ftu_n1st_cd", length));
			String[] attrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt15", length));
			String[] hdrPpdDtrbNo = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_dtrb_no", length));
			String[] hdrIfFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_if_flg", length));
			String[] hdrTjOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdr_tj_ofc_cd", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] hdrCsrCurrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_curr_cd", length));
			String[] hdrCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_rgn_cd", length));
			String[] hdrCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ctr_cd", length));
			String[] hdrInvDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_dt", length));
			String[] hdrTaxDeclFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_tax_decl_flg", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] hdrVndrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_vndr_no", length));
			String[] rowKnt = (JSPUtil.getParameter(request, prefix	+ "row_knt", length));
			String[] hdrImpErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_imp_err_rsn", length));
			String[] lineNo = (JSPUtil.getParameter(request, prefix	+ "line_no", length));
			String[] ttlRowKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_row_knt", length));
			String[] hdrAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt14", length));
			String[] hdrAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt13", length));
			String[] hdrAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt15", length));
			String[] hdrCsrAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_amt", length));
			String[] lifId = (JSPUtil.getParameter(request, prefix	+ "lif_id", length));
			String[] hdrVndrTermNm = (JSPUtil.getParameter(request, prefix	+ "hdr_vndr_term_nm", length));
			String[] actVvdCd = (JSPUtil.getParameter(request, prefix	+ "act_vvd_cd", length));
			String[] dtrbCoaFtuN2ndCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_ftu_n2nd_cd", length));
			String[] lineSeq = (JSPUtil.getParameter(request, prefix	+ "line_seq", length));
			String[] hdrIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_if_err_rsn", length));
			String[] hdrUsrEml = (JSPUtil.getParameter(request, prefix	+ "hdr_usr_eml", length));
			String[] attrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt9", length));
			String[] hdrAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt11", length));
			String[] hdrAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt12", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] hdrAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt10", length));
			String[] hdrPayDt = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_dt", length));
			String[] dtrbCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_inter_co_cd", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] hdrGloAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] hdrPpayAplyFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_ppay_aply_flg", length));
			String[] hdrGloAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt2", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] hdrGloAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt1", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] hdrPpdGlDt = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_gl_dt", length));
			String[] hdrGloAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt7", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] hdrGloAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt6", length));
			String[] lineTpLuCd = (JSPUtil.getParameter(request, prefix	+ "line_tp_lu_cd", length));
			String[] hdrGloAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt5", length));
			String[] hdrGloAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt4", length));
			String[] hdrGloAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt9", length));
			String[] hdrGloAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt8", length));
			String[] dtrbCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_co_cd", length));
			String[] dtrbCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_ctr_cd", length));
			String[] plnSctrDivCd = (JSPUtil.getParameter(request, prefix	+ "pln_sctr_div_cd", length));
			String[] hdrAproFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_apro_flg", length));
			String[] hdrTaxCurrXchFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_tax_curr_xch_flg", length));
			String[] dtrbCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_coa_vvd_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] hdrAttrCateNm = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_cate_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SPCLCmpnCSRINFtoAPVO();
				if (hdrCsrNo[i] != null)
					model.setHdrCsrNo(hdrCsrNo[i]);
				if (hdrCoaAcctCd[i] != null)
					model.setHdrCoaAcctCd(hdrCoaAcctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (hdrCoaVvdCd[i] != null)
					model.setHdrCoaVvdCd(hdrCoaVvdCd[i]);
				if (ftuUseCtnt2[i] != null)
					model.setFtuUseCtnt2(ftuUseCtnt2[i]);
				if (ftuUseCtnt1[i] != null)
					model.setFtuUseCtnt1(ftuUseCtnt1[i]);
				if (attrCateNm[i] != null)
					model.setAttrCateNm(attrCateNm[i]);
				if (ftuUseCtnt5[i] != null)
					model.setFtuUseCtnt5(ftuUseCtnt5[i]);
				if (ftuUseCtnt4[i] != null)
					model.setFtuUseCtnt4(ftuUseCtnt4[i]);
				if (hdrPayAmt[i] != null)
					model.setHdrPayAmt(hdrPayAmt[i]);
				if (ftuUseCtnt3[i] != null)
					model.setFtuUseCtnt3(ftuUseCtnt3[i]);
				if (hdrPayGrpLuCd[i] != null)
					model.setHdrPayGrpLuCd(hdrPayGrpLuCd[i]);
				if (invTaxCd[i] != null)
					model.setInvTaxCd(invTaxCd[i]);
				if (hdrIfDt[i] != null)
					model.setHdrIfDt(hdrIfDt[i]);
				if (hdrSrcCtnt[i] != null)
					model.setHdrSrcCtnt(hdrSrcCtnt[i]);
				if (hdrPpdAplyAmt[i] != null)
					model.setHdrPpdAplyAmt(hdrPpdAplyAmt[i]);
				if (hdrFtuUseCtnt1[i] != null)
					model.setHdrFtuUseCtnt1(hdrFtuUseCtnt1[i]);
				if (hdrCoaFtuN2ndCd[i] != null)
					model.setHdrCoaFtuN2ndCd(hdrCoaFtuN2ndCd[i]);
				if (hdrFtuUseCtnt2[i] != null)
					model.setHdrFtuUseCtnt2(hdrFtuUseCtnt2[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (hdrFtuUseCtnt3[i] != null)
					model.setHdrFtuUseCtnt3(hdrFtuUseCtnt3[i]);
				if (hdrFtuUseCtnt4[i] != null)
					model.setHdrFtuUseCtnt4(hdrFtuUseCtnt4[i]);
				if (hdrRcvErrFlg[i] != null)
					model.setHdrRcvErrFlg(hdrRcvErrFlg[i]);
				if (hdrFtuUseCtnt5[i] != null)
					model.setHdrFtuUseCtnt5(hdrFtuUseCtnt5[i]);
				if (hdrErrCsrNo[i] != null)
					model.setHdrErrCsrNo(hdrErrCsrNo[i]);
				if (hdrCoaCoCd[i] != null)
					model.setHdrCoaCoCd(hdrCoaCoCd[i]);
				if (dtrbCoaRgnCd[i] != null)
					model.setDtrbCoaRgnCd(dtrbCoaRgnCd[i]);
				if (hdrGloAttrCtnt17[i] != null)
					model.setHdrGloAttrCtnt17(hdrGloAttrCtnt17[i]);
				if (hdrActXchRt[i] != null)
					model.setHdrActXchRt(hdrActXchRt[i]);
				if (hdrGloAttrCtnt18[i] != null)
					model.setHdrGloAttrCtnt18(hdrGloAttrCtnt18[i]);
				if (hdrGloAttrCtnt15[i] != null)
					model.setHdrGloAttrCtnt15(hdrGloAttrCtnt15[i]);
				if (hdrGloAttrCtnt16[i] != null)
					model.setHdrGloAttrCtnt16(hdrGloAttrCtnt16[i]);
				if (hdrPayMzdLuCd[i] != null)
					model.setHdrPayMzdLuCd(hdrPayMzdLuCd[i]);
				if (hdrAttrCtnt5[i] != null)
					model.setHdrAttrCtnt5(hdrAttrCtnt5[i]);
				if (hdrAttrCtnt4[i] != null)
					model.setHdrAttrCtnt4(hdrAttrCtnt4[i]);
				if (hdrAttrCtnt3[i] != null)
					model.setHdrAttrCtnt3(hdrAttrCtnt3[i]);
				if (hdrAttrCtnt2[i] != null)
					model.setHdrAttrCtnt2(hdrAttrCtnt2[i]);
				if (hdrAttrCtnt1[i] != null)
					model.setHdrAttrCtnt1(hdrAttrCtnt1[i]);
				if (hdrCsrTpCd[i] != null)
					model.setHdrCsrTpCd(hdrCsrTpCd[i]);
				if (hdrAttrCtnt9[i] != null)
					model.setHdrAttrCtnt9(hdrAttrCtnt9[i]);
				if (hdrAttrCtnt8[i] != null)
					model.setHdrAttrCtnt8(hdrAttrCtnt8[i]);
				if (hdrAttrCtnt7[i] != null)
					model.setHdrAttrCtnt7(hdrAttrCtnt7[i]);
				if (hdrAttrCtnt6[i] != null)
					model.setHdrAttrCtnt6(hdrAttrCtnt6[i]);
				if (dtrbCoaAcctCd[i] != null)
					model.setDtrbCoaAcctCd(dtrbCoaAcctCd[i]);
				if (dtrbCoaFtuN1stCd[i] != null)
					model.setDtrbCoaFtuN1stCd(dtrbCoaFtuN1stCd[i]);
				if (hdrGlDt[i] != null)
					model.setHdrGlDt(hdrGlDt[i]);
				if (soCrrCd[i] != null)
					model.setSoCrrCd(soCrrCd[i]);
				if (hdrInvDesc[i] != null)
					model.setHdrInvDesc(hdrInvDesc[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (hdrGloAttrCtnt10[i] != null)
					model.setHdrGloAttrCtnt10(hdrGloAttrCtnt10[i]);
				if (hdrInvTermDt[i] != null)
					model.setHdrInvTermDt(hdrInvTermDt[i]);
				if (hdrGloAttrCtnt12[i] != null)
					model.setHdrGloAttrCtnt12(hdrGloAttrCtnt12[i]);
				if (hdrGloAttrCtnt11[i] != null)
					model.setHdrGloAttrCtnt11(hdrGloAttrCtnt11[i]);
				if (hdrGloAttrCtnt14[i] != null)
					model.setHdrGloAttrCtnt14(hdrGloAttrCtnt14[i]);
				if (hdrImpErrFlg[i] != null)
					model.setHdrImpErrFlg(hdrImpErrFlg[i]);
				if (hdrGloAttrCtnt13[i] != null)
					model.setHdrGloAttrCtnt13(hdrGloAttrCtnt13[i]);
				if (hdrPpdNo[i] != null)
					model.setHdrPpdNo(hdrPpdNo[i]);
				if (hdrRcvErrRsn[i] != null)
					model.setHdrRcvErrRsn(hdrRcvErrRsn[i]);
				if (attrCtnt10[i] != null)
					model.setAttrCtnt10(attrCtnt10[i]);
				if (attrCtnt14[i] != null)
					model.setAttrCtnt14(attrCtnt14[i]);
				if (attrCtnt13[i] != null)
					model.setAttrCtnt13(attrCtnt13[i]);
				if (attrCtnt12[i] != null)
					model.setAttrCtnt12(attrCtnt12[i]);
				if (attrCtnt11[i] != null)
					model.setAttrCtnt11(attrCtnt11[i]);
				if (hdrCoaInterCoCd[i] != null)
					model.setHdrCoaInterCoCd(hdrCoaInterCoCd[i]);
				if (hdrCoaFtuN1stCd[i] != null)
					model.setHdrCoaFtuN1stCd(hdrCoaFtuN1stCd[i]);
				if (attrCtnt15[i] != null)
					model.setAttrCtnt15(attrCtnt15[i]);
				if (hdrPpdDtrbNo[i] != null)
					model.setHdrPpdDtrbNo(hdrPpdDtrbNo[i]);
				if (hdrIfFlg[i] != null)
					model.setHdrIfFlg(hdrIfFlg[i]);
				if (hdrTjOfcCd[i] != null)
					model.setHdrTjOfcCd(hdrTjOfcCd[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (hdrCsrCurrCd[i] != null)
					model.setHdrCsrCurrCd(hdrCsrCurrCd[i]);
				if (hdrCoaRgnCd[i] != null)
					model.setHdrCoaRgnCd(hdrCoaRgnCd[i]);
				if (hdrCoaCtrCd[i] != null)
					model.setHdrCoaCtrCd(hdrCoaCtrCd[i]);
				if (hdrInvDt[i] != null)
					model.setHdrInvDt(hdrInvDt[i]);
				if (hdrTaxDeclFlg[i] != null)
					model.setHdrTaxDeclFlg(hdrTaxDeclFlg[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (hdrVndrNo[i] != null)
					model.setHdrVndrNo(hdrVndrNo[i]);
				if (rowKnt[i] != null)
					model.setRowKnt(rowKnt[i]);
				if (hdrImpErrRsn[i] != null)
					model.setHdrImpErrRsn(hdrImpErrRsn[i]);
				if (lineNo[i] != null)
					model.setLineNo(lineNo[i]);
				if (ttlRowKnt[i] != null)
					model.setTtlRowKnt(ttlRowKnt[i]);
				if (hdrAttrCtnt14[i] != null)
					model.setHdrAttrCtnt14(hdrAttrCtnt14[i]);
				if (hdrAttrCtnt13[i] != null)
					model.setHdrAttrCtnt13(hdrAttrCtnt13[i]);
				if (hdrAttrCtnt15[i] != null)
					model.setHdrAttrCtnt15(hdrAttrCtnt15[i]);
				if (hdrCsrAmt[i] != null)
					model.setHdrCsrAmt(hdrCsrAmt[i]);
				if (lifId[i] != null)
					model.setLifId(lifId[i]);
				if (hdrVndrTermNm[i] != null)
					model.setHdrVndrTermNm(hdrVndrTermNm[i]);
				if (actVvdCd[i] != null)
					model.setActVvdCd(actVvdCd[i]);
				if (dtrbCoaFtuN2ndCd[i] != null)
					model.setDtrbCoaFtuN2ndCd(dtrbCoaFtuN2ndCd[i]);
				if (lineSeq[i] != null)
					model.setLineSeq(lineSeq[i]);
				if (hdrIfErrRsn[i] != null)
					model.setHdrIfErrRsn(hdrIfErrRsn[i]);
				if (hdrUsrEml[i] != null)
					model.setHdrUsrEml(hdrUsrEml[i]);
				if (attrCtnt9[i] != null)
					model.setAttrCtnt9(attrCtnt9[i]);
				if (hdrAttrCtnt11[i] != null)
					model.setHdrAttrCtnt11(hdrAttrCtnt11[i]);
				if (hdrAttrCtnt12[i] != null)
					model.setHdrAttrCtnt12(hdrAttrCtnt12[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (hdrAttrCtnt10[i] != null)
					model.setHdrAttrCtnt10(hdrAttrCtnt10[i]);
				if (hdrPayDt[i] != null)
					model.setHdrPayDt(hdrPayDt[i]);
				if (dtrbCoaInterCoCd[i] != null)
					model.setDtrbCoaInterCoCd(dtrbCoaInterCoCd[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (hdrGloAttrCtnt3[i] != null)
					model.setHdrGloAttrCtnt3(hdrGloAttrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (hdrPpayAplyFlg[i] != null)
					model.setHdrPpayAplyFlg(hdrPpayAplyFlg[i]);
				if (hdrGloAttrCtnt2[i] != null)
					model.setHdrGloAttrCtnt2(hdrGloAttrCtnt2[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (hdrGloAttrCtnt1[i] != null)
					model.setHdrGloAttrCtnt1(hdrGloAttrCtnt1[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (hdrPpdGlDt[i] != null)
					model.setHdrPpdGlDt(hdrPpdGlDt[i]);
				if (hdrGloAttrCtnt7[i] != null)
					model.setHdrGloAttrCtnt7(hdrGloAttrCtnt7[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (hdrGloAttrCtnt6[i] != null)
					model.setHdrGloAttrCtnt6(hdrGloAttrCtnt6[i]);
				if (lineTpLuCd[i] != null)
					model.setLineTpLuCd(lineTpLuCd[i]);
				if (hdrGloAttrCtnt5[i] != null)
					model.setHdrGloAttrCtnt5(hdrGloAttrCtnt5[i]);
				if (hdrGloAttrCtnt4[i] != null)
					model.setHdrGloAttrCtnt4(hdrGloAttrCtnt4[i]);
				if (hdrGloAttrCtnt9[i] != null)
					model.setHdrGloAttrCtnt9(hdrGloAttrCtnt9[i]);
				if (hdrGloAttrCtnt8[i] != null)
					model.setHdrGloAttrCtnt8(hdrGloAttrCtnt8[i]);
				if (dtrbCoaCoCd[i] != null)
					model.setDtrbCoaCoCd(dtrbCoaCoCd[i]);
				if (dtrbCoaCtrCd[i] != null)
					model.setDtrbCoaCtrCd(dtrbCoaCtrCd[i]);
				if (plnSctrDivCd[i] != null)
					model.setPlnSctrDivCd(plnSctrDivCd[i]);
				if (hdrAproFlg[i] != null)
					model.setHdrAproFlg(hdrAproFlg[i]);
				if (hdrTaxCurrXchFlg[i] != null)
					model.setHdrTaxCurrXchFlg(hdrTaxCurrXchFlg[i]);
				if (dtrbCoaVvdCd[i] != null)
					model.setDtrbCoaVvdCd(dtrbCoaVvdCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (hdrAttrCateNm[i] != null)
					model.setHdrAttrCateNm(hdrAttrCateNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSPCLCmpnCSRINFtoAPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SPCLCmpnCSRINFtoAPVO[]
	 */
	public SPCLCmpnCSRINFtoAPVO[] getSPCLCmpnCSRINFtoAPVOs(){
		SPCLCmpnCSRINFtoAPVO[] vos = (SPCLCmpnCSRINFtoAPVO[])models.toArray(new SPCLCmpnCSRINFtoAPVO[models.size()]);
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
		this.hdrCsrNo = this.hdrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaAcctCd = this.hdrCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaVvdCd = this.hdrCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt2 = this.ftuUseCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt1 = this.ftuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm = this.attrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt5 = this.ftuUseCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt4 = this.ftuUseCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayAmt = this.hdrPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuUseCtnt3 = this.ftuUseCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayGrpLuCd = this.hdrPayGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTaxCd = this.invTaxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfDt = this.hdrIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrSrcCtnt = this.hdrSrcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdAplyAmt = this.hdrPpdAplyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt1 = this.hdrFtuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaFtuN2ndCd = this.hdrCoaFtuN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt2 = this.hdrFtuUseCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt3 = this.hdrFtuUseCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt4 = this.hdrFtuUseCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrRcvErrFlg = this.hdrRcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt5 = this.hdrFtuUseCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrErrCsrNo = this.hdrErrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaCoCd = this.hdrCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaRgnCd = this.dtrbCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt17 = this.hdrGloAttrCtnt17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrActXchRt = this.hdrActXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt18 = this.hdrGloAttrCtnt18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt15 = this.hdrGloAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt16 = this.hdrGloAttrCtnt16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayMzdLuCd = this.hdrPayMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt5 = this.hdrAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt4 = this.hdrAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt3 = this.hdrAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt2 = this.hdrAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt1 = this.hdrAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrTpCd = this.hdrCsrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt9 = this.hdrAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt8 = this.hdrAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt7 = this.hdrAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt6 = this.hdrAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaAcctCd = this.dtrbCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaFtuN1stCd = this.dtrbCoaFtuN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGlDt = this.hdrGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCrrCd = this.soCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDesc = this.hdrInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt10 = this.hdrGloAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvTermDt = this.hdrInvTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt12 = this.hdrGloAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt11 = this.hdrGloAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt14 = this.hdrGloAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrImpErrFlg = this.hdrImpErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt13 = this.hdrGloAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdNo = this.hdrPpdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrRcvErrRsn = this.hdrRcvErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 = this.attrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 = this.attrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 = this.attrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 = this.attrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 = this.attrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaInterCoCd = this.hdrCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaFtuN1stCd = this.hdrCoaFtuN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 = this.attrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdDtrbNo = this.hdrPpdDtrbNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfFlg = this.hdrIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTjOfcCd = this.hdrTjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrCurrCd = this.hdrCsrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaRgnCd = this.hdrCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaCtrCd = this.hdrCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDt = this.hdrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTaxDeclFlg = this.hdrTaxDeclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrVndrNo = this.hdrVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowKnt = this.rowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrImpErrRsn = this.hdrImpErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineNo = this.lineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRowKnt = this.ttlRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt14 = this.hdrAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt13 = this.hdrAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt15 = this.hdrAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrAmt = this.hdrCsrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifId = this.lifId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrVndrTermNm = this.hdrVndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvdCd = this.actVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaFtuN2ndCd = this.dtrbCoaFtuN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineSeq = this.lineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfErrRsn = this.hdrIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrUsrEml = this.hdrUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 = this.attrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt11 = this.hdrAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt12 = this.hdrAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt10 = this.hdrAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayDt = this.hdrPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaInterCoCd = this.dtrbCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt3 = this.hdrGloAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpayAplyFlg = this.hdrPpayAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt2 = this.hdrGloAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt1 = this.hdrGloAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdGlDt = this.hdrPpdGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt7 = this.hdrGloAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt6 = this.hdrGloAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd = this.lineTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt5 = this.hdrGloAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt4 = this.hdrGloAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt9 = this.hdrGloAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt8 = this.hdrGloAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCoCd = this.dtrbCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCtrCd = this.dtrbCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSctrDivCd = this.plnSctrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAproFlg = this.hdrAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTaxCurrXchFlg = this.hdrTaxCurrXchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaVvdCd = this.dtrbCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCateNm = this.hdrAttrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
