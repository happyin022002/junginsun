/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchApSlipInterfaceListVO.java
*@FileTitle : SearchApSlipInterfaceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.23 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchApSlipInterfaceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchApSlipInterfaceListVO> models = new ArrayList<SearchApSlipInterfaceListVO>();
	
	/* Column Info */
	private String hdrCsrNo = null;
	/* Column Info */
	private String hdrCoaAcctCd = null;
	/* Column Info */
	private String dDtrbCoaInterCoCd = null;
	/* Column Info */
	private String hdrEstmErrRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdrCoaVvdCd = null;
	/* Column Info */
	private String hdrPayAmt = null;
	/* Column Info */
	private String hdrPayGrpLuCd = null;
	/* Column Info */
	private String hdrIfDt = null;
	/* Column Info */
	private String dCreDt = null;
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
	private String hdrFtuUseCtnt3 = null;
	/* Column Info */
	private String hdrFtuUseCtnt4 = null;
	/* Column Info */
	private String hdrRcvErrFlg = null;
	/* Column Info */
	private String dLineTpLuCd = null;
	/* Column Info */
	private String dEaiEvntDt = null;
	/* Column Info */
	private String dSoOfcCtyCd = null;
	/* Column Info */
	private String hdrCoaCoCd = null;
	/* Column Info */
	private String hdrErrCsrNo = null;
	/* Column Info */
	private String hdrFtuUseCtnt5 = null;
	/* Column Info */
	private String hdrGloAttrCtnt17 = null;
	/* Column Info */
	private String hdrGloAttrCtnt18 = null;
	/* Column Info */
	private String hdrActXchRt = null;
	/* Column Info */
	private String hdrGloAttrCtnt15 = null;
	/* Column Info */
	private String hdrGloAttrCtnt16 = null;
	/* Column Info */
	private String dInvDesc = null;
	/* Column Info */
	private String hdrPayMzdLuCd = null;
	/* Column Info */
	private String hdrAttrCtnt5 = null;
	/* Column Info */
	private String hdrAttrCtnt4 = null;
	/* Column Info */
	private String dLineSeq = null;
	/* Column Info */
	private String hdrAttrCtnt3 = null;
	/* Column Info */
	private String hdrAttrCtnt2 = null;
	/* Column Info */
	private String hdrCsrTpCd = null;
	/* Column Info */
	private String hdrAttrCtnt1 = null;
	/* Column Info */
	private String dDtrbCoaCtrCd = null;
	/* Column Info */
	private String dAttrCateNm = null;
	/* Column Info */
	private String hdrAttrCtnt9 = null;
	/* Column Info */
	private String hdrAttrCtnt8 = null;
	/* Column Info */
	private String hdrAttrCtnt7 = null;
	/* Column Info */
	private String hdrAttrCtnt6 = null;
	/* Column Info */
	private String hdrGlDt = null;
	/* Column Info */
	private String dAttrCtnt2 = null;
	/* Column Info */
	private String dAttrCtnt3 = null;
	/* Column Info */
	private String dAttrCtnt1 = null;
	/* Column Info */
	private String dAttrCtnt6 = null;
	/* Column Info */
	private String dAttrCtnt7 = null;
	/* Column Info */
	private String dAttrCtnt4 = null;
	/* Column Info */
	private String dAttrCtnt5 = null;
	/* Column Info */
	private String hdrCxlDt = null;
	/* Column Info */
	private String dCsrNo = null;
	/* Column Info */
	private String dAttrCtnt8 = null;
	/* Column Info */
	private String dAttrCtnt9 = null;
	/* Column Info */
	private String hdrInvDesc = null;
	/* Column Info */
	private String dFtuUseCtnt1 = null;
	/* Column Info */
	private String dFtuUseCtnt2 = null;
	/* Column Info */
	private String dFtuUseCtnt5 = null;
	/* Column Info */
	private String dDtrbCoaCoCd = null;
	/* Column Info */
	private String dFtuUseCtnt3 = null;
	/* Column Info */
	private String hdrGloAttrCtnt10 = null;
	/* Column Info */
	private String dFtuUseCtnt4 = null;
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
	private String hdrCreDt = null;
	/* Column Info */
	private String hdrGloAttrCtnt13 = null;
	/* Column Info */
	private String hdrPpdNo = null;
	/* Column Info */
	private String dSoSeq = null;
	/* Column Info */
	private String dDtrbCoaFtuN1stCd = null;
	/* Column Info */
	private String hdrRcvErrRsn = null;
	/* Column Info */
	private String dDtrbCoaRgnCd = null;
	/* Column Info */
	private String dSoCrrCd = null;
	/* Column Info */
	private String hdrCoaInterCoCd = null;
	/* Column Info */
	private String dCreUsrId = null;
	/* Column Info */
	private String hdrCoaFtuN1stCd = null;
	/* Column Info */
	private String hdrPpdDtrbNo = null;
	/* Column Info */
	private String dInvTaxCd = null;
	/* Column Info */
	private String hdrIfFlg = null;
	/* Column Info */
	private String hdrTjOfcCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String hdrCsrCurrCd = null;
	/* Column Info */
	private String hdrCoaRgnCd = null;
	/* Column Info */
	private String dTrspSoTpCd = null;
	/* Column Info */
	private String dDtrbCoaVvdCd = null;
	/* Column Info */
	private String hdrCoaCtrCd = null;
	/* Column Info */
	private String hdrInvDt = null;
	/* Column Info */
	private String dBkgNo = null;
	/* Column Info */
	private String hdrTaxDeclFlg = null;
	/* Column Info */
	private String hdrVndrNo = null;
	/* Column Info */
	private String hdrCreUsrId = null;
	/* Column Info */
	private String dPlnSctrDivCd = null;
	/* Column Info */
	private String dActVvdCd = null;
	/* Column Info */
	private String dAttrCtnt14 = null;
	/* Column Info */
	private String dAttrCtnt13 = null;
	/* Column Info */
	private String dAttrCtnt12 = null;
	/* Column Info */
	private String hdrImpErrRsn = null;
	/* Column Info */
	private String dAttrCtnt11 = null;
	/* Column Info */
	private String dAttrCtnt10 = null;
	/* Column Info */
	private String dLineNo = null;
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
	private String dInvAmt = null;
	/* Column Info */
	private String dAttrCtnt15 = null;
	/* Column Info */
	private String hdrVndrTermNm = null;
	/* Column Info */
	private String hdrIfErrRsn = null;
	/* Column Info */
	private String hdrUsrEml = null;
	/* Column Info */
	private String hdrAttrCtnt11 = null;
	/* Column Info */
	private String hdrAttrCtnt12 = null;
	/* Column Info */
	private String hdrAttrCtnt10 = null;
	/* Column Info */
	private String hdrEaiEvntDt = null;
	/* Column Info */
	private String dYdCd = null;
	/* Column Info */
	private String hdrPayDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hdrGloAttrCtnt3 = null;
	/* Column Info */
	private String hdrGloAttrCtnt2 = null;
	/* Column Info */
	private String hdrPpayAplyFlg = null;
	/* Column Info */
	private String hdrGloAttrCtnt1 = null;
	/* Column Info */
	private String hdrGloAttrCtnt7 = null;
	/* Column Info */
	private String hdrPpdGlDt = null;
	/* Column Info */
	private String hdrGloAttrCtnt6 = null;
	/* Column Info */
	private String hdrGloAttrCtnt5 = null;
	/* Column Info */
	private String hdrGloAttrCtnt4 = null;
	/* Column Info */
	private String hdrGloAttrCtnt9 = null;
	/* Column Info */
	private String hdrGloAttrCtnt8 = null;
	/* Column Info */
	private String dDtrbCoaAcctCd = null;
	/* Column Info */
	private String hdrAproFlg = null;
	/* Column Info */
	private String hdrTaxCurrXchFlg = null;
	/* Column Info */
	private String dDtrbCoaFtuN2ndCd = null;
	/* Column Info */
	private String hdrAttrCateNm = null;
	/* Column Info */
	private String hdrAftActFlg = null;
	/* Column Info */
	private String dCntrTpszCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchApSlipInterfaceListVO() {}

	public SearchApSlipInterfaceListVO(String ibflag, String pagerows, String rnum, String ttlRowKnt, String hdrCsrNo, String hdrCsrTpCd, String hdrInvDt, String hdrInvTermDt, String hdrGlDt, String hdrVndrNo, String hdrCsrAmt, String hdrPayAmt, String hdrPayDt, String hdrCsrCurrCd, String hdrVndrTermNm, String hdrInvDesc, String hdrAttrCateNm, String hdrAttrCtnt1, String hdrAttrCtnt2, String hdrAttrCtnt3, String hdrAttrCtnt4, String hdrAttrCtnt5, String hdrAttrCtnt6, String hdrAttrCtnt7, String hdrAttrCtnt8, String hdrAttrCtnt9, String hdrAttrCtnt10, String hdrAttrCtnt11, String hdrAttrCtnt12, String hdrAttrCtnt13, String hdrAttrCtnt14, String hdrAttrCtnt15, String hdrGloAttrCtnt1, String hdrGloAttrCtnt2, String hdrGloAttrCtnt3, String hdrGloAttrCtnt4, String hdrGloAttrCtnt5, String hdrGloAttrCtnt6, String hdrGloAttrCtnt7, String hdrGloAttrCtnt8, String hdrGloAttrCtnt9, String hdrGloAttrCtnt10, String hdrGloAttrCtnt11, String hdrGloAttrCtnt12, String hdrGloAttrCtnt13, String hdrGloAttrCtnt14, String hdrGloAttrCtnt15, String hdrGloAttrCtnt16, String hdrGloAttrCtnt17, String hdrGloAttrCtnt18, String hdrSrcCtnt, String hdrPayMzdLuCd, String hdrPayGrpLuCd, String hdrCoaCoCd, String hdrCoaRgnCd, String hdrCoaCtrCd, String hdrCoaAcctCd, String hdrCoaVvdCd, String hdrCoaInterCoCd, String hdrCoaFtuN1stCd, String hdrCoaFtuN2ndCd, String hdrPpdNo, String hdrPpdDtrbNo, String hdrPpdAplyAmt, String hdrPpdGlDt, String hdrAproFlg, String hdrTaxDeclFlg, String hdrErrCsrNo, String hdrIfFlg, String hdrIfDt, String hdrIfErrRsn, String hdrPpayAplyFlg, String hdrTjOfcCd, String hdrActXchRt, String hdrImpErrFlg, String hdrRcvErrFlg, String hdrTaxCurrXchFlg, String hdrUsrEml, String hdrImpErrRsn, String hdrRcvErrRsn, String hdrFtuUseCtnt1, String hdrFtuUseCtnt2, String hdrFtuUseCtnt3, String hdrFtuUseCtnt4, String hdrFtuUseCtnt5, String hdrCreDt, String hdrCreUsrId, String hdrEaiEvntDt, String hdrAftActFlg, String hdrEstmErrRsn, String hdrCxlDt, String dCsrNo, String dLineSeq, String dLineNo, String dLineTpLuCd, String dInvAmt, String dInvDesc, String dInvTaxCd, String dDtrbCoaCoCd, String dDtrbCoaRgnCd, String dDtrbCoaCtrCd, String dDtrbCoaAcctCd, String dDtrbCoaVvdCd, String dDtrbCoaInterCoCd, String dDtrbCoaFtuN1stCd, String dDtrbCoaFtuN2ndCd, String dAttrCateNm, String dAttrCtnt1, String dAttrCtnt2, String dAttrCtnt3, String dAttrCtnt4, String dAttrCtnt5, String dAttrCtnt6, String dAttrCtnt7, String dAttrCtnt8, String dAttrCtnt9, String dAttrCtnt10, String dAttrCtnt11, String dAttrCtnt12, String dAttrCtnt13, String dAttrCtnt14, String dAttrCtnt15, String dBkgNo, String dCntrTpszCd, String dActVvdCd, String dPlnSctrDivCd, String dSoCrrCd, String dYdCd, String dFtuUseCtnt1, String dFtuUseCtnt2, String dFtuUseCtnt3, String dFtuUseCtnt4, String dFtuUseCtnt5, String dCreDt, String dCreUsrId, String dEaiEvntDt, String dTrspSoTpCd, String dSoOfcCtyCd, String dSoSeq) {
		this.hdrCsrNo = hdrCsrNo;
		this.hdrCoaAcctCd = hdrCoaAcctCd;
		this.dDtrbCoaInterCoCd = dDtrbCoaInterCoCd;
		this.hdrEstmErrRsn = hdrEstmErrRsn;
		this.pagerows = pagerows;
		this.hdrCoaVvdCd = hdrCoaVvdCd;
		this.hdrPayAmt = hdrPayAmt;
		this.hdrPayGrpLuCd = hdrPayGrpLuCd;
		this.hdrIfDt = hdrIfDt;
		this.dCreDt = dCreDt;
		this.hdrSrcCtnt = hdrSrcCtnt;
		this.hdrPpdAplyAmt = hdrPpdAplyAmt;
		this.hdrFtuUseCtnt1 = hdrFtuUseCtnt1;
		this.hdrCoaFtuN2ndCd = hdrCoaFtuN2ndCd;
		this.hdrFtuUseCtnt2 = hdrFtuUseCtnt2;
		this.hdrFtuUseCtnt3 = hdrFtuUseCtnt3;
		this.hdrFtuUseCtnt4 = hdrFtuUseCtnt4;
		this.hdrRcvErrFlg = hdrRcvErrFlg;
		this.dLineTpLuCd = dLineTpLuCd;
		this.dEaiEvntDt = dEaiEvntDt;
		this.dSoOfcCtyCd = dSoOfcCtyCd;
		this.hdrCoaCoCd = hdrCoaCoCd;
		this.hdrErrCsrNo = hdrErrCsrNo;
		this.hdrFtuUseCtnt5 = hdrFtuUseCtnt5;
		this.hdrGloAttrCtnt17 = hdrGloAttrCtnt17;
		this.hdrGloAttrCtnt18 = hdrGloAttrCtnt18;
		this.hdrActXchRt = hdrActXchRt;
		this.hdrGloAttrCtnt15 = hdrGloAttrCtnt15;
		this.hdrGloAttrCtnt16 = hdrGloAttrCtnt16;
		this.dInvDesc = dInvDesc;
		this.hdrPayMzdLuCd = hdrPayMzdLuCd;
		this.hdrAttrCtnt5 = hdrAttrCtnt5;
		this.hdrAttrCtnt4 = hdrAttrCtnt4;
		this.dLineSeq = dLineSeq;
		this.hdrAttrCtnt3 = hdrAttrCtnt3;
		this.hdrAttrCtnt2 = hdrAttrCtnt2;
		this.hdrCsrTpCd = hdrCsrTpCd;
		this.hdrAttrCtnt1 = hdrAttrCtnt1;
		this.dDtrbCoaCtrCd = dDtrbCoaCtrCd;
		this.dAttrCateNm = dAttrCateNm;
		this.hdrAttrCtnt9 = hdrAttrCtnt9;
		this.hdrAttrCtnt8 = hdrAttrCtnt8;
		this.hdrAttrCtnt7 = hdrAttrCtnt7;
		this.hdrAttrCtnt6 = hdrAttrCtnt6;
		this.hdrGlDt = hdrGlDt;
		this.dAttrCtnt2 = dAttrCtnt2;
		this.dAttrCtnt3 = dAttrCtnt3;
		this.dAttrCtnt1 = dAttrCtnt1;
		this.dAttrCtnt6 = dAttrCtnt6;
		this.dAttrCtnt7 = dAttrCtnt7;
		this.dAttrCtnt4 = dAttrCtnt4;
		this.dAttrCtnt5 = dAttrCtnt5;
		this.hdrCxlDt = hdrCxlDt;
		this.dCsrNo = dCsrNo;
		this.dAttrCtnt8 = dAttrCtnt8;
		this.dAttrCtnt9 = dAttrCtnt9;
		this.hdrInvDesc = hdrInvDesc;
		this.dFtuUseCtnt1 = dFtuUseCtnt1;
		this.dFtuUseCtnt2 = dFtuUseCtnt2;
		this.dFtuUseCtnt5 = dFtuUseCtnt5;
		this.dDtrbCoaCoCd = dDtrbCoaCoCd;
		this.dFtuUseCtnt3 = dFtuUseCtnt3;
		this.hdrGloAttrCtnt10 = hdrGloAttrCtnt10;
		this.dFtuUseCtnt4 = dFtuUseCtnt4;
		this.hdrInvTermDt = hdrInvTermDt;
		this.hdrGloAttrCtnt12 = hdrGloAttrCtnt12;
		this.hdrGloAttrCtnt11 = hdrGloAttrCtnt11;
		this.hdrGloAttrCtnt14 = hdrGloAttrCtnt14;
		this.hdrImpErrFlg = hdrImpErrFlg;
		this.hdrCreDt = hdrCreDt;
		this.hdrGloAttrCtnt13 = hdrGloAttrCtnt13;
		this.hdrPpdNo = hdrPpdNo;
		this.dSoSeq = dSoSeq;
		this.dDtrbCoaFtuN1stCd = dDtrbCoaFtuN1stCd;
		this.hdrRcvErrRsn = hdrRcvErrRsn;
		this.dDtrbCoaRgnCd = dDtrbCoaRgnCd;
		this.dSoCrrCd = dSoCrrCd;
		this.hdrCoaInterCoCd = hdrCoaInterCoCd;
		this.dCreUsrId = dCreUsrId;
		this.hdrCoaFtuN1stCd = hdrCoaFtuN1stCd;
		this.hdrPpdDtrbNo = hdrPpdDtrbNo;
		this.dInvTaxCd = dInvTaxCd;
		this.hdrIfFlg = hdrIfFlg;
		this.hdrTjOfcCd = hdrTjOfcCd;
		this.rnum = rnum;
		this.hdrCsrCurrCd = hdrCsrCurrCd;
		this.hdrCoaRgnCd = hdrCoaRgnCd;
		this.dTrspSoTpCd = dTrspSoTpCd;
		this.dDtrbCoaVvdCd = dDtrbCoaVvdCd;
		this.hdrCoaCtrCd = hdrCoaCtrCd;
		this.hdrInvDt = hdrInvDt;
		this.dBkgNo = dBkgNo;
		this.hdrTaxDeclFlg = hdrTaxDeclFlg;
		this.hdrVndrNo = hdrVndrNo;
		this.hdrCreUsrId = hdrCreUsrId;
		this.dPlnSctrDivCd = dPlnSctrDivCd;
		this.dActVvdCd = dActVvdCd;
		this.dAttrCtnt14 = dAttrCtnt14;
		this.dAttrCtnt13 = dAttrCtnt13;
		this.dAttrCtnt12 = dAttrCtnt12;
		this.hdrImpErrRsn = hdrImpErrRsn;
		this.dAttrCtnt11 = dAttrCtnt11;
		this.dAttrCtnt10 = dAttrCtnt10;
		this.dLineNo = dLineNo;
		this.ttlRowKnt = ttlRowKnt;
		this.hdrAttrCtnt14 = hdrAttrCtnt14;
		this.hdrAttrCtnt13 = hdrAttrCtnt13;
		this.hdrAttrCtnt15 = hdrAttrCtnt15;
		this.hdrCsrAmt = hdrCsrAmt;
		this.dInvAmt = dInvAmt;
		this.dAttrCtnt15 = dAttrCtnt15;
		this.hdrVndrTermNm = hdrVndrTermNm;
		this.hdrIfErrRsn = hdrIfErrRsn;
		this.hdrUsrEml = hdrUsrEml;
		this.hdrAttrCtnt11 = hdrAttrCtnt11;
		this.hdrAttrCtnt12 = hdrAttrCtnt12;
		this.hdrAttrCtnt10 = hdrAttrCtnt10;
		this.hdrEaiEvntDt = hdrEaiEvntDt;
		this.dYdCd = dYdCd;
		this.hdrPayDt = hdrPayDt;
		this.ibflag = ibflag;
		this.hdrGloAttrCtnt3 = hdrGloAttrCtnt3;
		this.hdrGloAttrCtnt2 = hdrGloAttrCtnt2;
		this.hdrPpayAplyFlg = hdrPpayAplyFlg;
		this.hdrGloAttrCtnt1 = hdrGloAttrCtnt1;
		this.hdrGloAttrCtnt7 = hdrGloAttrCtnt7;
		this.hdrPpdGlDt = hdrPpdGlDt;
		this.hdrGloAttrCtnt6 = hdrGloAttrCtnt6;
		this.hdrGloAttrCtnt5 = hdrGloAttrCtnt5;
		this.hdrGloAttrCtnt4 = hdrGloAttrCtnt4;
		this.hdrGloAttrCtnt9 = hdrGloAttrCtnt9;
		this.hdrGloAttrCtnt8 = hdrGloAttrCtnt8;
		this.dDtrbCoaAcctCd = dDtrbCoaAcctCd;
		this.hdrAproFlg = hdrAproFlg;
		this.hdrTaxCurrXchFlg = hdrTaxCurrXchFlg;
		this.dDtrbCoaFtuN2ndCd = dDtrbCoaFtuN2ndCd;
		this.hdrAttrCateNm = hdrAttrCateNm;
		this.hdrAftActFlg = hdrAftActFlg;
		this.dCntrTpszCd = dCntrTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hdr_csr_no", getHdrCsrNo());
		this.hashColumns.put("hdr_coa_acct_cd", getHdrCoaAcctCd());
		this.hashColumns.put("d_dtrb_coa_inter_co_cd", getDDtrbCoaInterCoCd());
		this.hashColumns.put("hdr_estm_err_rsn", getHdrEstmErrRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hdr_coa_vvd_cd", getHdrCoaVvdCd());
		this.hashColumns.put("hdr_pay_amt", getHdrPayAmt());
		this.hashColumns.put("hdr_pay_grp_lu_cd", getHdrPayGrpLuCd());
		this.hashColumns.put("hdr_if_dt", getHdrIfDt());
		this.hashColumns.put("d_cre_dt", getDCreDt());
		this.hashColumns.put("hdr_src_ctnt", getHdrSrcCtnt());
		this.hashColumns.put("hdr_ppd_aply_amt", getHdrPpdAplyAmt());
		this.hashColumns.put("hdr_ftu_use_ctnt1", getHdrFtuUseCtnt1());
		this.hashColumns.put("hdr_coa_ftu_n2nd_cd", getHdrCoaFtuN2ndCd());
		this.hashColumns.put("hdr_ftu_use_ctnt2", getHdrFtuUseCtnt2());
		this.hashColumns.put("hdr_ftu_use_ctnt3", getHdrFtuUseCtnt3());
		this.hashColumns.put("hdr_ftu_use_ctnt4", getHdrFtuUseCtnt4());
		this.hashColumns.put("hdr_rcv_err_flg", getHdrRcvErrFlg());
		this.hashColumns.put("d_line_tp_lu_cd", getDLineTpLuCd());
		this.hashColumns.put("d_eai_evnt_dt", getDEaiEvntDt());
		this.hashColumns.put("d_so_ofc_cty_cd", getDSoOfcCtyCd());
		this.hashColumns.put("hdr_coa_co_cd", getHdrCoaCoCd());
		this.hashColumns.put("hdr_err_csr_no", getHdrErrCsrNo());
		this.hashColumns.put("hdr_ftu_use_ctnt5", getHdrFtuUseCtnt5());
		this.hashColumns.put("hdr_glo_attr_ctnt17", getHdrGloAttrCtnt17());
		this.hashColumns.put("hdr_glo_attr_ctnt18", getHdrGloAttrCtnt18());
		this.hashColumns.put("hdr_act_xch_rt", getHdrActXchRt());
		this.hashColumns.put("hdr_glo_attr_ctnt15", getHdrGloAttrCtnt15());
		this.hashColumns.put("hdr_glo_attr_ctnt16", getHdrGloAttrCtnt16());
		this.hashColumns.put("d_inv_desc", getDInvDesc());
		this.hashColumns.put("hdr_pay_mzd_lu_cd", getHdrPayMzdLuCd());
		this.hashColumns.put("hdr_attr_ctnt5", getHdrAttrCtnt5());
		this.hashColumns.put("hdr_attr_ctnt4", getHdrAttrCtnt4());
		this.hashColumns.put("d_line_seq", getDLineSeq());
		this.hashColumns.put("hdr_attr_ctnt3", getHdrAttrCtnt3());
		this.hashColumns.put("hdr_attr_ctnt2", getHdrAttrCtnt2());
		this.hashColumns.put("hdr_csr_tp_cd", getHdrCsrTpCd());
		this.hashColumns.put("hdr_attr_ctnt1", getHdrAttrCtnt1());
		this.hashColumns.put("d_dtrb_coa_ctr_cd", getDDtrbCoaCtrCd());
		this.hashColumns.put("d_attr_cate_nm", getDAttrCateNm());
		this.hashColumns.put("hdr_attr_ctnt9", getHdrAttrCtnt9());
		this.hashColumns.put("hdr_attr_ctnt8", getHdrAttrCtnt8());
		this.hashColumns.put("hdr_attr_ctnt7", getHdrAttrCtnt7());
		this.hashColumns.put("hdr_attr_ctnt6", getHdrAttrCtnt6());
		this.hashColumns.put("hdr_gl_dt", getHdrGlDt());
		this.hashColumns.put("d_attr_ctnt2", getDAttrCtnt2());
		this.hashColumns.put("d_attr_ctnt3", getDAttrCtnt3());
		this.hashColumns.put("d_attr_ctnt1", getDAttrCtnt1());
		this.hashColumns.put("d_attr_ctnt6", getDAttrCtnt6());
		this.hashColumns.put("d_attr_ctnt7", getDAttrCtnt7());
		this.hashColumns.put("d_attr_ctnt4", getDAttrCtnt4());
		this.hashColumns.put("d_attr_ctnt5", getDAttrCtnt5());
		this.hashColumns.put("hdr_cxl_dt", getHdrCxlDt());
		this.hashColumns.put("d_csr_no", getDCsrNo());
		this.hashColumns.put("d_attr_ctnt8", getDAttrCtnt8());
		this.hashColumns.put("d_attr_ctnt9", getDAttrCtnt9());
		this.hashColumns.put("hdr_inv_desc", getHdrInvDesc());
		this.hashColumns.put("d_ftu_use_ctnt1", getDFtuUseCtnt1());
		this.hashColumns.put("d_ftu_use_ctnt2", getDFtuUseCtnt2());
		this.hashColumns.put("d_ftu_use_ctnt5", getDFtuUseCtnt5());
		this.hashColumns.put("d_dtrb_coa_co_cd", getDDtrbCoaCoCd());
		this.hashColumns.put("d_ftu_use_ctnt3", getDFtuUseCtnt3());
		this.hashColumns.put("hdr_glo_attr_ctnt10", getHdrGloAttrCtnt10());
		this.hashColumns.put("d_ftu_use_ctnt4", getDFtuUseCtnt4());
		this.hashColumns.put("hdr_inv_term_dt", getHdrInvTermDt());
		this.hashColumns.put("hdr_glo_attr_ctnt12", getHdrGloAttrCtnt12());
		this.hashColumns.put("hdr_glo_attr_ctnt11", getHdrGloAttrCtnt11());
		this.hashColumns.put("hdr_glo_attr_ctnt14", getHdrGloAttrCtnt14());
		this.hashColumns.put("hdr_imp_err_flg", getHdrImpErrFlg());
		this.hashColumns.put("hdr_cre_dt", getHdrCreDt());
		this.hashColumns.put("hdr_glo_attr_ctnt13", getHdrGloAttrCtnt13());
		this.hashColumns.put("hdr_ppd_no", getHdrPpdNo());
		this.hashColumns.put("d_so_seq", getDSoSeq());
		this.hashColumns.put("d_dtrb_coa_ftu_n1st_cd", getDDtrbCoaFtuN1stCd());
		this.hashColumns.put("hdr_rcv_err_rsn", getHdrRcvErrRsn());
		this.hashColumns.put("d_dtrb_coa_rgn_cd", getDDtrbCoaRgnCd());
		this.hashColumns.put("d_so_crr_cd", getDSoCrrCd());
		this.hashColumns.put("hdr_coa_inter_co_cd", getHdrCoaInterCoCd());
		this.hashColumns.put("d_cre_usr_id", getDCreUsrId());
		this.hashColumns.put("hdr_coa_ftu_n1st_cd", getHdrCoaFtuN1stCd());
		this.hashColumns.put("hdr_ppd_dtrb_no", getHdrPpdDtrbNo());
		this.hashColumns.put("d_inv_tax_cd", getDInvTaxCd());
		this.hashColumns.put("hdr_if_flg", getHdrIfFlg());
		this.hashColumns.put("hdr_tj_ofc_cd", getHdrTjOfcCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("hdr_csr_curr_cd", getHdrCsrCurrCd());
		this.hashColumns.put("hdr_coa_rgn_cd", getHdrCoaRgnCd());
		this.hashColumns.put("d_trsp_so_tp_cd", getDTrspSoTpCd());
		this.hashColumns.put("d_dtrb_coa_vvd_cd", getDDtrbCoaVvdCd());
		this.hashColumns.put("hdr_coa_ctr_cd", getHdrCoaCtrCd());
		this.hashColumns.put("hdr_inv_dt", getHdrInvDt());
		this.hashColumns.put("d_bkg_no", getDBkgNo());
		this.hashColumns.put("hdr_tax_decl_flg", getHdrTaxDeclFlg());
		this.hashColumns.put("hdr_vndr_no", getHdrVndrNo());
		this.hashColumns.put("hdr_cre_usr_id", getHdrCreUsrId());
		this.hashColumns.put("d_pln_sctr_div_cd", getDPlnSctrDivCd());
		this.hashColumns.put("d_act_vvd_cd", getDActVvdCd());
		this.hashColumns.put("d_attr_ctnt14", getDAttrCtnt14());
		this.hashColumns.put("d_attr_ctnt13", getDAttrCtnt13());
		this.hashColumns.put("d_attr_ctnt12", getDAttrCtnt12());
		this.hashColumns.put("hdr_imp_err_rsn", getHdrImpErrRsn());
		this.hashColumns.put("d_attr_ctnt11", getDAttrCtnt11());
		this.hashColumns.put("d_attr_ctnt10", getDAttrCtnt10());
		this.hashColumns.put("d_line_no", getDLineNo());
		this.hashColumns.put("ttl_row_knt", getTtlRowKnt());
		this.hashColumns.put("hdr_attr_ctnt14", getHdrAttrCtnt14());
		this.hashColumns.put("hdr_attr_ctnt13", getHdrAttrCtnt13());
		this.hashColumns.put("hdr_attr_ctnt15", getHdrAttrCtnt15());
		this.hashColumns.put("hdr_csr_amt", getHdrCsrAmt());
		this.hashColumns.put("d_inv_amt", getDInvAmt());
		this.hashColumns.put("d_attr_ctnt15", getDAttrCtnt15());
		this.hashColumns.put("hdr_vndr_term_nm", getHdrVndrTermNm());
		this.hashColumns.put("hdr_if_err_rsn", getHdrIfErrRsn());
		this.hashColumns.put("hdr_usr_eml", getHdrUsrEml());
		this.hashColumns.put("hdr_attr_ctnt11", getHdrAttrCtnt11());
		this.hashColumns.put("hdr_attr_ctnt12", getHdrAttrCtnt12());
		this.hashColumns.put("hdr_attr_ctnt10", getHdrAttrCtnt10());
		this.hashColumns.put("hdr_eai_evnt_dt", getHdrEaiEvntDt());
		this.hashColumns.put("d_yd_cd", getDYdCd());
		this.hashColumns.put("hdr_pay_dt", getHdrPayDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hdr_glo_attr_ctnt3", getHdrGloAttrCtnt3());
		this.hashColumns.put("hdr_glo_attr_ctnt2", getHdrGloAttrCtnt2());
		this.hashColumns.put("hdr_ppay_aply_flg", getHdrPpayAplyFlg());
		this.hashColumns.put("hdr_glo_attr_ctnt1", getHdrGloAttrCtnt1());
		this.hashColumns.put("hdr_glo_attr_ctnt7", getHdrGloAttrCtnt7());
		this.hashColumns.put("hdr_ppd_gl_dt", getHdrPpdGlDt());
		this.hashColumns.put("hdr_glo_attr_ctnt6", getHdrGloAttrCtnt6());
		this.hashColumns.put("hdr_glo_attr_ctnt5", getHdrGloAttrCtnt5());
		this.hashColumns.put("hdr_glo_attr_ctnt4", getHdrGloAttrCtnt4());
		this.hashColumns.put("hdr_glo_attr_ctnt9", getHdrGloAttrCtnt9());
		this.hashColumns.put("hdr_glo_attr_ctnt8", getHdrGloAttrCtnt8());
		this.hashColumns.put("d_dtrb_coa_acct_cd", getDDtrbCoaAcctCd());
		this.hashColumns.put("hdr_apro_flg", getHdrAproFlg());
		this.hashColumns.put("hdr_tax_curr_xch_flg", getHdrTaxCurrXchFlg());
		this.hashColumns.put("d_dtrb_coa_ftu_n2nd_cd", getDDtrbCoaFtuN2ndCd());
		this.hashColumns.put("hdr_attr_cate_nm", getHdrAttrCateNm());
		this.hashColumns.put("hdr_aft_act_flg", getHdrAftActFlg());
		this.hashColumns.put("d_cntr_tpsz_cd", getDCntrTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hdr_csr_no", "hdrCsrNo");
		this.hashFields.put("hdr_coa_acct_cd", "hdrCoaAcctCd");
		this.hashFields.put("d_dtrb_coa_inter_co_cd", "dDtrbCoaInterCoCd");
		this.hashFields.put("hdr_estm_err_rsn", "hdrEstmErrRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hdr_coa_vvd_cd", "hdrCoaVvdCd");
		this.hashFields.put("hdr_pay_amt", "hdrPayAmt");
		this.hashFields.put("hdr_pay_grp_lu_cd", "hdrPayGrpLuCd");
		this.hashFields.put("hdr_if_dt", "hdrIfDt");
		this.hashFields.put("d_cre_dt", "dCreDt");
		this.hashFields.put("hdr_src_ctnt", "hdrSrcCtnt");
		this.hashFields.put("hdr_ppd_aply_amt", "hdrPpdAplyAmt");
		this.hashFields.put("hdr_ftu_use_ctnt1", "hdrFtuUseCtnt1");
		this.hashFields.put("hdr_coa_ftu_n2nd_cd", "hdrCoaFtuN2ndCd");
		this.hashFields.put("hdr_ftu_use_ctnt2", "hdrFtuUseCtnt2");
		this.hashFields.put("hdr_ftu_use_ctnt3", "hdrFtuUseCtnt3");
		this.hashFields.put("hdr_ftu_use_ctnt4", "hdrFtuUseCtnt4");
		this.hashFields.put("hdr_rcv_err_flg", "hdrRcvErrFlg");
		this.hashFields.put("d_line_tp_lu_cd", "dLineTpLuCd");
		this.hashFields.put("d_eai_evnt_dt", "dEaiEvntDt");
		this.hashFields.put("d_so_ofc_cty_cd", "dSoOfcCtyCd");
		this.hashFields.put("hdr_coa_co_cd", "hdrCoaCoCd");
		this.hashFields.put("hdr_err_csr_no", "hdrErrCsrNo");
		this.hashFields.put("hdr_ftu_use_ctnt5", "hdrFtuUseCtnt5");
		this.hashFields.put("hdr_glo_attr_ctnt17", "hdrGloAttrCtnt17");
		this.hashFields.put("hdr_glo_attr_ctnt18", "hdrGloAttrCtnt18");
		this.hashFields.put("hdr_act_xch_rt", "hdrActXchRt");
		this.hashFields.put("hdr_glo_attr_ctnt15", "hdrGloAttrCtnt15");
		this.hashFields.put("hdr_glo_attr_ctnt16", "hdrGloAttrCtnt16");
		this.hashFields.put("d_inv_desc", "dInvDesc");
		this.hashFields.put("hdr_pay_mzd_lu_cd", "hdrPayMzdLuCd");
		this.hashFields.put("hdr_attr_ctnt5", "hdrAttrCtnt5");
		this.hashFields.put("hdr_attr_ctnt4", "hdrAttrCtnt4");
		this.hashFields.put("d_line_seq", "dLineSeq");
		this.hashFields.put("hdr_attr_ctnt3", "hdrAttrCtnt3");
		this.hashFields.put("hdr_attr_ctnt2", "hdrAttrCtnt2");
		this.hashFields.put("hdr_csr_tp_cd", "hdrCsrTpCd");
		this.hashFields.put("hdr_attr_ctnt1", "hdrAttrCtnt1");
		this.hashFields.put("d_dtrb_coa_ctr_cd", "dDtrbCoaCtrCd");
		this.hashFields.put("d_attr_cate_nm", "dAttrCateNm");
		this.hashFields.put("hdr_attr_ctnt9", "hdrAttrCtnt9");
		this.hashFields.put("hdr_attr_ctnt8", "hdrAttrCtnt8");
		this.hashFields.put("hdr_attr_ctnt7", "hdrAttrCtnt7");
		this.hashFields.put("hdr_attr_ctnt6", "hdrAttrCtnt6");
		this.hashFields.put("hdr_gl_dt", "hdrGlDt");
		this.hashFields.put("d_attr_ctnt2", "dAttrCtnt2");
		this.hashFields.put("d_attr_ctnt3", "dAttrCtnt3");
		this.hashFields.put("d_attr_ctnt1", "dAttrCtnt1");
		this.hashFields.put("d_attr_ctnt6", "dAttrCtnt6");
		this.hashFields.put("d_attr_ctnt7", "dAttrCtnt7");
		this.hashFields.put("d_attr_ctnt4", "dAttrCtnt4");
		this.hashFields.put("d_attr_ctnt5", "dAttrCtnt5");
		this.hashFields.put("hdr_cxl_dt", "hdrCxlDt");
		this.hashFields.put("d_csr_no", "dCsrNo");
		this.hashFields.put("d_attr_ctnt8", "dAttrCtnt8");
		this.hashFields.put("d_attr_ctnt9", "dAttrCtnt9");
		this.hashFields.put("hdr_inv_desc", "hdrInvDesc");
		this.hashFields.put("d_ftu_use_ctnt1", "dFtuUseCtnt1");
		this.hashFields.put("d_ftu_use_ctnt2", "dFtuUseCtnt2");
		this.hashFields.put("d_ftu_use_ctnt5", "dFtuUseCtnt5");
		this.hashFields.put("d_dtrb_coa_co_cd", "dDtrbCoaCoCd");
		this.hashFields.put("d_ftu_use_ctnt3", "dFtuUseCtnt3");
		this.hashFields.put("hdr_glo_attr_ctnt10", "hdrGloAttrCtnt10");
		this.hashFields.put("d_ftu_use_ctnt4", "dFtuUseCtnt4");
		this.hashFields.put("hdr_inv_term_dt", "hdrInvTermDt");
		this.hashFields.put("hdr_glo_attr_ctnt12", "hdrGloAttrCtnt12");
		this.hashFields.put("hdr_glo_attr_ctnt11", "hdrGloAttrCtnt11");
		this.hashFields.put("hdr_glo_attr_ctnt14", "hdrGloAttrCtnt14");
		this.hashFields.put("hdr_imp_err_flg", "hdrImpErrFlg");
		this.hashFields.put("hdr_cre_dt", "hdrCreDt");
		this.hashFields.put("hdr_glo_attr_ctnt13", "hdrGloAttrCtnt13");
		this.hashFields.put("hdr_ppd_no", "hdrPpdNo");
		this.hashFields.put("d_so_seq", "dSoSeq");
		this.hashFields.put("d_dtrb_coa_ftu_n1st_cd", "dDtrbCoaFtuN1stCd");
		this.hashFields.put("hdr_rcv_err_rsn", "hdrRcvErrRsn");
		this.hashFields.put("d_dtrb_coa_rgn_cd", "dDtrbCoaRgnCd");
		this.hashFields.put("d_so_crr_cd", "dSoCrrCd");
		this.hashFields.put("hdr_coa_inter_co_cd", "hdrCoaInterCoCd");
		this.hashFields.put("d_cre_usr_id", "dCreUsrId");
		this.hashFields.put("hdr_coa_ftu_n1st_cd", "hdrCoaFtuN1stCd");
		this.hashFields.put("hdr_ppd_dtrb_no", "hdrPpdDtrbNo");
		this.hashFields.put("d_inv_tax_cd", "dInvTaxCd");
		this.hashFields.put("hdr_if_flg", "hdrIfFlg");
		this.hashFields.put("hdr_tj_ofc_cd", "hdrTjOfcCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("hdr_csr_curr_cd", "hdrCsrCurrCd");
		this.hashFields.put("hdr_coa_rgn_cd", "hdrCoaRgnCd");
		this.hashFields.put("d_trsp_so_tp_cd", "dTrspSoTpCd");
		this.hashFields.put("d_dtrb_coa_vvd_cd", "dDtrbCoaVvdCd");
		this.hashFields.put("hdr_coa_ctr_cd", "hdrCoaCtrCd");
		this.hashFields.put("hdr_inv_dt", "hdrInvDt");
		this.hashFields.put("d_bkg_no", "dBkgNo");
		this.hashFields.put("hdr_tax_decl_flg", "hdrTaxDeclFlg");
		this.hashFields.put("hdr_vndr_no", "hdrVndrNo");
		this.hashFields.put("hdr_cre_usr_id", "hdrCreUsrId");
		this.hashFields.put("d_pln_sctr_div_cd", "dPlnSctrDivCd");
		this.hashFields.put("d_act_vvd_cd", "dActVvdCd");
		this.hashFields.put("d_attr_ctnt14", "dAttrCtnt14");
		this.hashFields.put("d_attr_ctnt13", "dAttrCtnt13");
		this.hashFields.put("d_attr_ctnt12", "dAttrCtnt12");
		this.hashFields.put("hdr_imp_err_rsn", "hdrImpErrRsn");
		this.hashFields.put("d_attr_ctnt11", "dAttrCtnt11");
		this.hashFields.put("d_attr_ctnt10", "dAttrCtnt10");
		this.hashFields.put("d_line_no", "dLineNo");
		this.hashFields.put("ttl_row_knt", "ttlRowKnt");
		this.hashFields.put("hdr_attr_ctnt14", "hdrAttrCtnt14");
		this.hashFields.put("hdr_attr_ctnt13", "hdrAttrCtnt13");
		this.hashFields.put("hdr_attr_ctnt15", "hdrAttrCtnt15");
		this.hashFields.put("hdr_csr_amt", "hdrCsrAmt");
		this.hashFields.put("d_inv_amt", "dInvAmt");
		this.hashFields.put("d_attr_ctnt15", "dAttrCtnt15");
		this.hashFields.put("hdr_vndr_term_nm", "hdrVndrTermNm");
		this.hashFields.put("hdr_if_err_rsn", "hdrIfErrRsn");
		this.hashFields.put("hdr_usr_eml", "hdrUsrEml");
		this.hashFields.put("hdr_attr_ctnt11", "hdrAttrCtnt11");
		this.hashFields.put("hdr_attr_ctnt12", "hdrAttrCtnt12");
		this.hashFields.put("hdr_attr_ctnt10", "hdrAttrCtnt10");
		this.hashFields.put("hdr_eai_evnt_dt", "hdrEaiEvntDt");
		this.hashFields.put("d_yd_cd", "dYdCd");
		this.hashFields.put("hdr_pay_dt", "hdrPayDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hdr_glo_attr_ctnt3", "hdrGloAttrCtnt3");
		this.hashFields.put("hdr_glo_attr_ctnt2", "hdrGloAttrCtnt2");
		this.hashFields.put("hdr_ppay_aply_flg", "hdrPpayAplyFlg");
		this.hashFields.put("hdr_glo_attr_ctnt1", "hdrGloAttrCtnt1");
		this.hashFields.put("hdr_glo_attr_ctnt7", "hdrGloAttrCtnt7");
		this.hashFields.put("hdr_ppd_gl_dt", "hdrPpdGlDt");
		this.hashFields.put("hdr_glo_attr_ctnt6", "hdrGloAttrCtnt6");
		this.hashFields.put("hdr_glo_attr_ctnt5", "hdrGloAttrCtnt5");
		this.hashFields.put("hdr_glo_attr_ctnt4", "hdrGloAttrCtnt4");
		this.hashFields.put("hdr_glo_attr_ctnt9", "hdrGloAttrCtnt9");
		this.hashFields.put("hdr_glo_attr_ctnt8", "hdrGloAttrCtnt8");
		this.hashFields.put("d_dtrb_coa_acct_cd", "dDtrbCoaAcctCd");
		this.hashFields.put("hdr_apro_flg", "hdrAproFlg");
		this.hashFields.put("hdr_tax_curr_xch_flg", "hdrTaxCurrXchFlg");
		this.hashFields.put("d_dtrb_coa_ftu_n2nd_cd", "dDtrbCoaFtuN2ndCd");
		this.hashFields.put("hdr_attr_cate_nm", "hdrAttrCateNm");
		this.hashFields.put("hdr_aft_act_flg", "hdrAftActFlg");
		this.hashFields.put("d_cntr_tpsz_cd", "dCntrTpszCd");
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
	 * Column Info
	 * @return dDtrbCoaInterCoCd
	 */
	public String getDDtrbCoaInterCoCd() {
		return this.dDtrbCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return hdrEstmErrRsn
	 */
	public String getHdrEstmErrRsn() {
		return this.hdrEstmErrRsn;
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
	 * @return hdrCoaVvdCd
	 */
	public String getHdrCoaVvdCd() {
		return this.hdrCoaVvdCd;
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
	 * @return hdrPayGrpLuCd
	 */
	public String getHdrPayGrpLuCd() {
		return this.hdrPayGrpLuCd;
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
	 * @return dCreDt
	 */
	public String getDCreDt() {
		return this.dCreDt;
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
	 * @return dLineTpLuCd
	 */
	public String getDLineTpLuCd() {
		return this.dLineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return dEaiEvntDt
	 */
	public String getDEaiEvntDt() {
		return this.dEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return dSoOfcCtyCd
	 */
	public String getDSoOfcCtyCd() {
		return this.dSoOfcCtyCd;
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
	 * @return hdrErrCsrNo
	 */
	public String getHdrErrCsrNo() {
		return this.hdrErrCsrNo;
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
	 * @return hdrGloAttrCtnt17
	 */
	public String getHdrGloAttrCtnt17() {
		return this.hdrGloAttrCtnt17;
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
	 * @return hdrActXchRt
	 */
	public String getHdrActXchRt() {
		return this.hdrActXchRt;
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
	 * @return dInvDesc
	 */
	public String getDInvDesc() {
		return this.dInvDesc;
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
	 * @return dLineSeq
	 */
	public String getDLineSeq() {
		return this.dLineSeq;
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
	 * @return hdrCsrTpCd
	 */
	public String getHdrCsrTpCd() {
		return this.hdrCsrTpCd;
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
	 * @return dDtrbCoaCtrCd
	 */
	public String getDDtrbCoaCtrCd() {
		return this.dDtrbCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return dAttrCateNm
	 */
	public String getDAttrCateNm() {
		return this.dAttrCateNm;
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
	 * @return hdrGlDt
	 */
	public String getHdrGlDt() {
		return this.hdrGlDt;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt2
	 */
	public String getDAttrCtnt2() {
		return this.dAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt3
	 */
	public String getDAttrCtnt3() {
		return this.dAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt1
	 */
	public String getDAttrCtnt1() {
		return this.dAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt6
	 */
	public String getDAttrCtnt6() {
		return this.dAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt7
	 */
	public String getDAttrCtnt7() {
		return this.dAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt4
	 */
	public String getDAttrCtnt4() {
		return this.dAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt5
	 */
	public String getDAttrCtnt5() {
		return this.dAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return hdrCxlDt
	 */
	public String getHdrCxlDt() {
		return this.hdrCxlDt;
	}
	
	/**
	 * Column Info
	 * @return dCsrNo
	 */
	public String getDCsrNo() {
		return this.dCsrNo;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt8
	 */
	public String getDAttrCtnt8() {
		return this.dAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt9
	 */
	public String getDAttrCtnt9() {
		return this.dAttrCtnt9;
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
	 * @return dFtuUseCtnt1
	 */
	public String getDFtuUseCtnt1() {
		return this.dFtuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @return dFtuUseCtnt2
	 */
	public String getDFtuUseCtnt2() {
		return this.dFtuUseCtnt2;
	}
	
	/**
	 * Column Info
	 * @return dFtuUseCtnt5
	 */
	public String getDFtuUseCtnt5() {
		return this.dFtuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @return dDtrbCoaCoCd
	 */
	public String getDDtrbCoaCoCd() {
		return this.dDtrbCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @return dFtuUseCtnt3
	 */
	public String getDFtuUseCtnt3() {
		return this.dFtuUseCtnt3;
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
	 * @return dFtuUseCtnt4
	 */
	public String getDFtuUseCtnt4() {
		return this.dFtuUseCtnt4;
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
	 * @return hdrCreDt
	 */
	public String getHdrCreDt() {
		return this.hdrCreDt;
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
	 * @return dSoSeq
	 */
	public String getDSoSeq() {
		return this.dSoSeq;
	}
	
	/**
	 * Column Info
	 * @return dDtrbCoaFtuN1stCd
	 */
	public String getDDtrbCoaFtuN1stCd() {
		return this.dDtrbCoaFtuN1stCd;
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
	 * @return dDtrbCoaRgnCd
	 */
	public String getDDtrbCoaRgnCd() {
		return this.dDtrbCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return dSoCrrCd
	 */
	public String getDSoCrrCd() {
		return this.dSoCrrCd;
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
	 * @return dCreUsrId
	 */
	public String getDCreUsrId() {
		return this.dCreUsrId;
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
	 * @return hdrPpdDtrbNo
	 */
	public String getHdrPpdDtrbNo() {
		return this.hdrPpdDtrbNo;
	}
	
	/**
	 * Column Info
	 * @return dInvTaxCd
	 */
	public String getDInvTaxCd() {
		return this.dInvTaxCd;
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
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return dTrspSoTpCd
	 */
	public String getDTrspSoTpCd() {
		return this.dTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dDtrbCoaVvdCd
	 */
	public String getDDtrbCoaVvdCd() {
		return this.dDtrbCoaVvdCd;
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
	 * @return dBkgNo
	 */
	public String getDBkgNo() {
		return this.dBkgNo;
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
	 * @return hdrVndrNo
	 */
	public String getHdrVndrNo() {
		return this.hdrVndrNo;
	}
	
	/**
	 * Column Info
	 * @return hdrCreUsrId
	 */
	public String getHdrCreUsrId() {
		return this.hdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return dPlnSctrDivCd
	 */
	public String getDPlnSctrDivCd() {
		return this.dPlnSctrDivCd;
	}
	
	/**
	 * Column Info
	 * @return dActVvdCd
	 */
	public String getDActVvdCd() {
		return this.dActVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt14
	 */
	public String getDAttrCtnt14() {
		return this.dAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt13
	 */
	public String getDAttrCtnt13() {
		return this.dAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt12
	 */
	public String getDAttrCtnt12() {
		return this.dAttrCtnt12;
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
	 * @return dAttrCtnt11
	 */
	public String getDAttrCtnt11() {
		return this.dAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt10
	 */
	public String getDAttrCtnt10() {
		return this.dAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return dLineNo
	 */
	public String getDLineNo() {
		return this.dLineNo;
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
	 * @return dInvAmt
	 */
	public String getDInvAmt() {
		return this.dInvAmt;
	}
	
	/**
	 * Column Info
	 * @return dAttrCtnt15
	 */
	public String getDAttrCtnt15() {
		return this.dAttrCtnt15;
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
	 * @return hdrAttrCtnt10
	 */
	public String getHdrAttrCtnt10() {
		return this.hdrAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return hdrEaiEvntDt
	 */
	public String getHdrEaiEvntDt() {
		return this.hdrEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return dYdCd
	 */
	public String getDYdCd() {
		return this.dYdCd;
	}
	
	/**
	 * Column Info
	 * @return hdrPayDt
	 */
	public String getHdrPayDt() {
		return this.hdrPayDt;
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
	 * @return hdrGloAttrCtnt3
	 */
	public String getHdrGloAttrCtnt3() {
		return this.hdrGloAttrCtnt3;
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
	 * @return hdrPpayAplyFlg
	 */
	public String getHdrPpayAplyFlg() {
		return this.hdrPpayAplyFlg;
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
	 * @return hdrGloAttrCtnt7
	 */
	public String getHdrGloAttrCtnt7() {
		return this.hdrGloAttrCtnt7;
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
	 * @return hdrGloAttrCtnt6
	 */
	public String getHdrGloAttrCtnt6() {
		return this.hdrGloAttrCtnt6;
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
	 * @return dDtrbCoaAcctCd
	 */
	public String getDDtrbCoaAcctCd() {
		return this.dDtrbCoaAcctCd;
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
	 * @return dDtrbCoaFtuN2ndCd
	 */
	public String getDDtrbCoaFtuN2ndCd() {
		return this.dDtrbCoaFtuN2ndCd;
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
	 * @return hdrAftActFlg
	 */
	public String getHdrAftActFlg() {
		return this.hdrAftActFlg;
	}
	
	/**
	 * Column Info
	 * @return dCntrTpszCd
	 */
	public String getDCntrTpszCd() {
		return this.dCntrTpszCd;
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
	 * Column Info
	 * @param dDtrbCoaInterCoCd
	 */
	public void setDDtrbCoaInterCoCd(String dDtrbCoaInterCoCd) {
		this.dDtrbCoaInterCoCd = dDtrbCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param hdrEstmErrRsn
	 */
	public void setHdrEstmErrRsn(String hdrEstmErrRsn) {
		this.hdrEstmErrRsn = hdrEstmErrRsn;
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
	 * @param hdrCoaVvdCd
	 */
	public void setHdrCoaVvdCd(String hdrCoaVvdCd) {
		this.hdrCoaVvdCd = hdrCoaVvdCd;
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
	 * @param hdrPayGrpLuCd
	 */
	public void setHdrPayGrpLuCd(String hdrPayGrpLuCd) {
		this.hdrPayGrpLuCd = hdrPayGrpLuCd;
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
	 * @param dCreDt
	 */
	public void setDCreDt(String dCreDt) {
		this.dCreDt = dCreDt;
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
	 * @param dLineTpLuCd
	 */
	public void setDLineTpLuCd(String dLineTpLuCd) {
		this.dLineTpLuCd = dLineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param dEaiEvntDt
	 */
	public void setDEaiEvntDt(String dEaiEvntDt) {
		this.dEaiEvntDt = dEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param dSoOfcCtyCd
	 */
	public void setDSoOfcCtyCd(String dSoOfcCtyCd) {
		this.dSoOfcCtyCd = dSoOfcCtyCd;
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
	 * @param hdrErrCsrNo
	 */
	public void setHdrErrCsrNo(String hdrErrCsrNo) {
		this.hdrErrCsrNo = hdrErrCsrNo;
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
	 * @param hdrGloAttrCtnt17
	 */
	public void setHdrGloAttrCtnt17(String hdrGloAttrCtnt17) {
		this.hdrGloAttrCtnt17 = hdrGloAttrCtnt17;
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
	 * @param hdrActXchRt
	 */
	public void setHdrActXchRt(String hdrActXchRt) {
		this.hdrActXchRt = hdrActXchRt;
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
	 * @param dInvDesc
	 */
	public void setDInvDesc(String dInvDesc) {
		this.dInvDesc = dInvDesc;
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
	 * @param dLineSeq
	 */
	public void setDLineSeq(String dLineSeq) {
		this.dLineSeq = dLineSeq;
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
	 * @param hdrCsrTpCd
	 */
	public void setHdrCsrTpCd(String hdrCsrTpCd) {
		this.hdrCsrTpCd = hdrCsrTpCd;
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
	 * @param dDtrbCoaCtrCd
	 */
	public void setDDtrbCoaCtrCd(String dDtrbCoaCtrCd) {
		this.dDtrbCoaCtrCd = dDtrbCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param dAttrCateNm
	 */
	public void setDAttrCateNm(String dAttrCateNm) {
		this.dAttrCateNm = dAttrCateNm;
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
	 * @param hdrGlDt
	 */
	public void setHdrGlDt(String hdrGlDt) {
		this.hdrGlDt = hdrGlDt;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt2
	 */
	public void setDAttrCtnt2(String dAttrCtnt2) {
		this.dAttrCtnt2 = dAttrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt3
	 */
	public void setDAttrCtnt3(String dAttrCtnt3) {
		this.dAttrCtnt3 = dAttrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt1
	 */
	public void setDAttrCtnt1(String dAttrCtnt1) {
		this.dAttrCtnt1 = dAttrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt6
	 */
	public void setDAttrCtnt6(String dAttrCtnt6) {
		this.dAttrCtnt6 = dAttrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt7
	 */
	public void setDAttrCtnt7(String dAttrCtnt7) {
		this.dAttrCtnt7 = dAttrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt4
	 */
	public void setDAttrCtnt4(String dAttrCtnt4) {
		this.dAttrCtnt4 = dAttrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt5
	 */
	public void setDAttrCtnt5(String dAttrCtnt5) {
		this.dAttrCtnt5 = dAttrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param hdrCxlDt
	 */
	public void setHdrCxlDt(String hdrCxlDt) {
		this.hdrCxlDt = hdrCxlDt;
	}
	
	/**
	 * Column Info
	 * @param dCsrNo
	 */
	public void setDCsrNo(String dCsrNo) {
		this.dCsrNo = dCsrNo;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt8
	 */
	public void setDAttrCtnt8(String dAttrCtnt8) {
		this.dAttrCtnt8 = dAttrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt9
	 */
	public void setDAttrCtnt9(String dAttrCtnt9) {
		this.dAttrCtnt9 = dAttrCtnt9;
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
	 * @param dFtuUseCtnt1
	 */
	public void setDFtuUseCtnt1(String dFtuUseCtnt1) {
		this.dFtuUseCtnt1 = dFtuUseCtnt1;
	}
	
	/**
	 * Column Info
	 * @param dFtuUseCtnt2
	 */
	public void setDFtuUseCtnt2(String dFtuUseCtnt2) {
		this.dFtuUseCtnt2 = dFtuUseCtnt2;
	}
	
	/**
	 * Column Info
	 * @param dFtuUseCtnt5
	 */
	public void setDFtuUseCtnt5(String dFtuUseCtnt5) {
		this.dFtuUseCtnt5 = dFtuUseCtnt5;
	}
	
	/**
	 * Column Info
	 * @param dDtrbCoaCoCd
	 */
	public void setDDtrbCoaCoCd(String dDtrbCoaCoCd) {
		this.dDtrbCoaCoCd = dDtrbCoaCoCd;
	}
	
	/**
	 * Column Info
	 * @param dFtuUseCtnt3
	 */
	public void setDFtuUseCtnt3(String dFtuUseCtnt3) {
		this.dFtuUseCtnt3 = dFtuUseCtnt3;
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
	 * @param dFtuUseCtnt4
	 */
	public void setDFtuUseCtnt4(String dFtuUseCtnt4) {
		this.dFtuUseCtnt4 = dFtuUseCtnt4;
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
	 * @param hdrCreDt
	 */
	public void setHdrCreDt(String hdrCreDt) {
		this.hdrCreDt = hdrCreDt;
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
	 * @param dSoSeq
	 */
	public void setDSoSeq(String dSoSeq) {
		this.dSoSeq = dSoSeq;
	}
	
	/**
	 * Column Info
	 * @param dDtrbCoaFtuN1stCd
	 */
	public void setDDtrbCoaFtuN1stCd(String dDtrbCoaFtuN1stCd) {
		this.dDtrbCoaFtuN1stCd = dDtrbCoaFtuN1stCd;
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
	 * @param dDtrbCoaRgnCd
	 */
	public void setDDtrbCoaRgnCd(String dDtrbCoaRgnCd) {
		this.dDtrbCoaRgnCd = dDtrbCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param dSoCrrCd
	 */
	public void setDSoCrrCd(String dSoCrrCd) {
		this.dSoCrrCd = dSoCrrCd;
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
	 * @param dCreUsrId
	 */
	public void setDCreUsrId(String dCreUsrId) {
		this.dCreUsrId = dCreUsrId;
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
	 * @param hdrPpdDtrbNo
	 */
	public void setHdrPpdDtrbNo(String hdrPpdDtrbNo) {
		this.hdrPpdDtrbNo = hdrPpdDtrbNo;
	}
	
	/**
	 * Column Info
	 * @param dInvTaxCd
	 */
	public void setDInvTaxCd(String dInvTaxCd) {
		this.dInvTaxCd = dInvTaxCd;
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
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param dTrspSoTpCd
	 */
	public void setDTrspSoTpCd(String dTrspSoTpCd) {
		this.dTrspSoTpCd = dTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param dDtrbCoaVvdCd
	 */
	public void setDDtrbCoaVvdCd(String dDtrbCoaVvdCd) {
		this.dDtrbCoaVvdCd = dDtrbCoaVvdCd;
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
	 * @param dBkgNo
	 */
	public void setDBkgNo(String dBkgNo) {
		this.dBkgNo = dBkgNo;
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
	 * @param hdrVndrNo
	 */
	public void setHdrVndrNo(String hdrVndrNo) {
		this.hdrVndrNo = hdrVndrNo;
	}
	
	/**
	 * Column Info
	 * @param hdrCreUsrId
	 */
	public void setHdrCreUsrId(String hdrCreUsrId) {
		this.hdrCreUsrId = hdrCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param dPlnSctrDivCd
	 */
	public void setDPlnSctrDivCd(String dPlnSctrDivCd) {
		this.dPlnSctrDivCd = dPlnSctrDivCd;
	}
	
	/**
	 * Column Info
	 * @param dActVvdCd
	 */
	public void setDActVvdCd(String dActVvdCd) {
		this.dActVvdCd = dActVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt14
	 */
	public void setDAttrCtnt14(String dAttrCtnt14) {
		this.dAttrCtnt14 = dAttrCtnt14;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt13
	 */
	public void setDAttrCtnt13(String dAttrCtnt13) {
		this.dAttrCtnt13 = dAttrCtnt13;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt12
	 */
	public void setDAttrCtnt12(String dAttrCtnt12) {
		this.dAttrCtnt12 = dAttrCtnt12;
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
	 * @param dAttrCtnt11
	 */
	public void setDAttrCtnt11(String dAttrCtnt11) {
		this.dAttrCtnt11 = dAttrCtnt11;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt10
	 */
	public void setDAttrCtnt10(String dAttrCtnt10) {
		this.dAttrCtnt10 = dAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param dLineNo
	 */
	public void setDLineNo(String dLineNo) {
		this.dLineNo = dLineNo;
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
	 * @param dInvAmt
	 */
	public void setDInvAmt(String dInvAmt) {
		this.dInvAmt = dInvAmt;
	}
	
	/**
	 * Column Info
	 * @param dAttrCtnt15
	 */
	public void setDAttrCtnt15(String dAttrCtnt15) {
		this.dAttrCtnt15 = dAttrCtnt15;
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
	 * @param hdrAttrCtnt10
	 */
	public void setHdrAttrCtnt10(String hdrAttrCtnt10) {
		this.hdrAttrCtnt10 = hdrAttrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param hdrEaiEvntDt
	 */
	public void setHdrEaiEvntDt(String hdrEaiEvntDt) {
		this.hdrEaiEvntDt = hdrEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param dYdCd
	 */
	public void setDYdCd(String dYdCd) {
		this.dYdCd = dYdCd;
	}
	
	/**
	 * Column Info
	 * @param hdrPayDt
	 */
	public void setHdrPayDt(String hdrPayDt) {
		this.hdrPayDt = hdrPayDt;
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
	 * @param hdrGloAttrCtnt3
	 */
	public void setHdrGloAttrCtnt3(String hdrGloAttrCtnt3) {
		this.hdrGloAttrCtnt3 = hdrGloAttrCtnt3;
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
	 * @param hdrPpayAplyFlg
	 */
	public void setHdrPpayAplyFlg(String hdrPpayAplyFlg) {
		this.hdrPpayAplyFlg = hdrPpayAplyFlg;
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
	 * @param hdrGloAttrCtnt7
	 */
	public void setHdrGloAttrCtnt7(String hdrGloAttrCtnt7) {
		this.hdrGloAttrCtnt7 = hdrGloAttrCtnt7;
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
	 * @param hdrGloAttrCtnt6
	 */
	public void setHdrGloAttrCtnt6(String hdrGloAttrCtnt6) {
		this.hdrGloAttrCtnt6 = hdrGloAttrCtnt6;
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
	 * @param dDtrbCoaAcctCd
	 */
	public void setDDtrbCoaAcctCd(String dDtrbCoaAcctCd) {
		this.dDtrbCoaAcctCd = dDtrbCoaAcctCd;
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
	 * @param dDtrbCoaFtuN2ndCd
	 */
	public void setDDtrbCoaFtuN2ndCd(String dDtrbCoaFtuN2ndCd) {
		this.dDtrbCoaFtuN2ndCd = dDtrbCoaFtuN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param hdrAttrCateNm
	 */
	public void setHdrAttrCateNm(String hdrAttrCateNm) {
		this.hdrAttrCateNm = hdrAttrCateNm;
	}
	
	/**
	 * Column Info
	 * @param hdrAftActFlg
	 */
	public void setHdrAftActFlg(String hdrAftActFlg) {
		this.hdrAftActFlg = hdrAftActFlg;
	}
	
	/**
	 * Column Info
	 * @param dCntrTpszCd
	 */
	public void setDCntrTpszCd(String dCntrTpszCd) {
		this.dCntrTpszCd = dCntrTpszCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHdrCsrNo(JSPUtil.getParameter(request, "hdr_csr_no", ""));
		setHdrCoaAcctCd(JSPUtil.getParameter(request, "hdr_coa_acct_cd", ""));
		setDDtrbCoaInterCoCd(JSPUtil.getParameter(request, "d_dtrb_coa_inter_co_cd", ""));
		setHdrEstmErrRsn(JSPUtil.getParameter(request, "hdr_estm_err_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHdrCoaVvdCd(JSPUtil.getParameter(request, "hdr_coa_vvd_cd", ""));
		setHdrPayAmt(JSPUtil.getParameter(request, "hdr_pay_amt", ""));
		setHdrPayGrpLuCd(JSPUtil.getParameter(request, "hdr_pay_grp_lu_cd", ""));
		setHdrIfDt(JSPUtil.getParameter(request, "hdr_if_dt", ""));
		setDCreDt(JSPUtil.getParameter(request, "d_cre_dt", ""));
		setHdrSrcCtnt(JSPUtil.getParameter(request, "hdr_src_ctnt", ""));
		setHdrPpdAplyAmt(JSPUtil.getParameter(request, "hdr_ppd_aply_amt", ""));
		setHdrFtuUseCtnt1(JSPUtil.getParameter(request, "hdr_ftu_use_ctnt1", ""));
		setHdrCoaFtuN2ndCd(JSPUtil.getParameter(request, "hdr_coa_ftu_n2nd_cd", ""));
		setHdrFtuUseCtnt2(JSPUtil.getParameter(request, "hdr_ftu_use_ctnt2", ""));
		setHdrFtuUseCtnt3(JSPUtil.getParameter(request, "hdr_ftu_use_ctnt3", ""));
		setHdrFtuUseCtnt4(JSPUtil.getParameter(request, "hdr_ftu_use_ctnt4", ""));
		setHdrRcvErrFlg(JSPUtil.getParameter(request, "hdr_rcv_err_flg", ""));
		setDLineTpLuCd(JSPUtil.getParameter(request, "d_line_tp_lu_cd", ""));
		setDEaiEvntDt(JSPUtil.getParameter(request, "d_eai_evnt_dt", ""));
		setDSoOfcCtyCd(JSPUtil.getParameter(request, "d_so_ofc_cty_cd", ""));
		setHdrCoaCoCd(JSPUtil.getParameter(request, "hdr_coa_co_cd", ""));
		setHdrErrCsrNo(JSPUtil.getParameter(request, "hdr_err_csr_no", ""));
		setHdrFtuUseCtnt5(JSPUtil.getParameter(request, "hdr_ftu_use_ctnt5", ""));
		setHdrGloAttrCtnt17(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt17", ""));
		setHdrGloAttrCtnt18(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt18", ""));
		setHdrActXchRt(JSPUtil.getParameter(request, "hdr_act_xch_rt", ""));
		setHdrGloAttrCtnt15(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt15", ""));
		setHdrGloAttrCtnt16(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt16", ""));
		setDInvDesc(JSPUtil.getParameter(request, "d_inv_desc", ""));
		setHdrPayMzdLuCd(JSPUtil.getParameter(request, "hdr_pay_mzd_lu_cd", ""));
		setHdrAttrCtnt5(JSPUtil.getParameter(request, "hdr_attr_ctnt5", ""));
		setHdrAttrCtnt4(JSPUtil.getParameter(request, "hdr_attr_ctnt4", ""));
		setDLineSeq(JSPUtil.getParameter(request, "d_line_seq", ""));
		setHdrAttrCtnt3(JSPUtil.getParameter(request, "hdr_attr_ctnt3", ""));
		setHdrAttrCtnt2(JSPUtil.getParameter(request, "hdr_attr_ctnt2", ""));
		setHdrCsrTpCd(JSPUtil.getParameter(request, "hdr_csr_tp_cd", ""));
		setHdrAttrCtnt1(JSPUtil.getParameter(request, "hdr_attr_ctnt1", ""));
		setDDtrbCoaCtrCd(JSPUtil.getParameter(request, "d_dtrb_coa_ctr_cd", ""));
		setDAttrCateNm(JSPUtil.getParameter(request, "d_attr_cate_nm", ""));
		setHdrAttrCtnt9(JSPUtil.getParameter(request, "hdr_attr_ctnt9", ""));
		setHdrAttrCtnt8(JSPUtil.getParameter(request, "hdr_attr_ctnt8", ""));
		setHdrAttrCtnt7(JSPUtil.getParameter(request, "hdr_attr_ctnt7", ""));
		setHdrAttrCtnt6(JSPUtil.getParameter(request, "hdr_attr_ctnt6", ""));
		setHdrGlDt(JSPUtil.getParameter(request, "hdr_gl_dt", ""));
		setDAttrCtnt2(JSPUtil.getParameter(request, "d_attr_ctnt2", ""));
		setDAttrCtnt3(JSPUtil.getParameter(request, "d_attr_ctnt3", ""));
		setDAttrCtnt1(JSPUtil.getParameter(request, "d_attr_ctnt1", ""));
		setDAttrCtnt6(JSPUtil.getParameter(request, "d_attr_ctnt6", ""));
		setDAttrCtnt7(JSPUtil.getParameter(request, "d_attr_ctnt7", ""));
		setDAttrCtnt4(JSPUtil.getParameter(request, "d_attr_ctnt4", ""));
		setDAttrCtnt5(JSPUtil.getParameter(request, "d_attr_ctnt5", ""));
		setHdrCxlDt(JSPUtil.getParameter(request, "hdr_cxl_dt", ""));
		setDCsrNo(JSPUtil.getParameter(request, "d_csr_no", ""));
		setDAttrCtnt8(JSPUtil.getParameter(request, "d_attr_ctnt8", ""));
		setDAttrCtnt9(JSPUtil.getParameter(request, "d_attr_ctnt9", ""));
		setHdrInvDesc(JSPUtil.getParameter(request, "hdr_inv_desc", ""));
		setDFtuUseCtnt1(JSPUtil.getParameter(request, "d_ftu_use_ctnt1", ""));
		setDFtuUseCtnt2(JSPUtil.getParameter(request, "d_ftu_use_ctnt2", ""));
		setDFtuUseCtnt5(JSPUtil.getParameter(request, "d_ftu_use_ctnt5", ""));
		setDDtrbCoaCoCd(JSPUtil.getParameter(request, "d_dtrb_coa_co_cd", ""));
		setDFtuUseCtnt3(JSPUtil.getParameter(request, "d_ftu_use_ctnt3", ""));
		setHdrGloAttrCtnt10(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt10", ""));
		setDFtuUseCtnt4(JSPUtil.getParameter(request, "d_ftu_use_ctnt4", ""));
		setHdrInvTermDt(JSPUtil.getParameter(request, "hdr_inv_term_dt", ""));
		setHdrGloAttrCtnt12(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt12", ""));
		setHdrGloAttrCtnt11(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt11", ""));
		setHdrGloAttrCtnt14(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt14", ""));
		setHdrImpErrFlg(JSPUtil.getParameter(request, "hdr_imp_err_flg", ""));
		setHdrCreDt(JSPUtil.getParameter(request, "hdr_cre_dt", ""));
		setHdrGloAttrCtnt13(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt13", ""));
		setHdrPpdNo(JSPUtil.getParameter(request, "hdr_ppd_no", ""));
		setDSoSeq(JSPUtil.getParameter(request, "d_so_seq", ""));
		setDDtrbCoaFtuN1stCd(JSPUtil.getParameter(request, "d_dtrb_coa_ftu_n1st_cd", ""));
		setHdrRcvErrRsn(JSPUtil.getParameter(request, "hdr_rcv_err_rsn", ""));
		setDDtrbCoaRgnCd(JSPUtil.getParameter(request, "d_dtrb_coa_rgn_cd", ""));
		setDSoCrrCd(JSPUtil.getParameter(request, "d_so_crr_cd", ""));
		setHdrCoaInterCoCd(JSPUtil.getParameter(request, "hdr_coa_inter_co_cd", ""));
		setDCreUsrId(JSPUtil.getParameter(request, "d_cre_usr_id", ""));
		setHdrCoaFtuN1stCd(JSPUtil.getParameter(request, "hdr_coa_ftu_n1st_cd", ""));
		setHdrPpdDtrbNo(JSPUtil.getParameter(request, "hdr_ppd_dtrb_no", ""));
		setDInvTaxCd(JSPUtil.getParameter(request, "d_inv_tax_cd", ""));
		setHdrIfFlg(JSPUtil.getParameter(request, "hdr_if_flg", ""));
		setHdrTjOfcCd(JSPUtil.getParameter(request, "hdr_tj_ofc_cd", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setHdrCsrCurrCd(JSPUtil.getParameter(request, "hdr_csr_curr_cd", ""));
		setHdrCoaRgnCd(JSPUtil.getParameter(request, "hdr_coa_rgn_cd", ""));
		setDTrspSoTpCd(JSPUtil.getParameter(request, "d_trsp_so_tp_cd", ""));
		setDDtrbCoaVvdCd(JSPUtil.getParameter(request, "d_dtrb_coa_vvd_cd", ""));
		setHdrCoaCtrCd(JSPUtil.getParameter(request, "hdr_coa_ctr_cd", ""));
		setHdrInvDt(JSPUtil.getParameter(request, "hdr_inv_dt", ""));
		setDBkgNo(JSPUtil.getParameter(request, "d_bkg_no", ""));
		setHdrTaxDeclFlg(JSPUtil.getParameter(request, "hdr_tax_decl_flg", ""));
		setHdrVndrNo(JSPUtil.getParameter(request, "hdr_vndr_no", ""));
		setHdrCreUsrId(JSPUtil.getParameter(request, "hdr_cre_usr_id", ""));
		setDPlnSctrDivCd(JSPUtil.getParameter(request, "d_pln_sctr_div_cd", ""));
		setDActVvdCd(JSPUtil.getParameter(request, "d_act_vvd_cd", ""));
		setDAttrCtnt14(JSPUtil.getParameter(request, "d_attr_ctnt14", ""));
		setDAttrCtnt13(JSPUtil.getParameter(request, "d_attr_ctnt13", ""));
		setDAttrCtnt12(JSPUtil.getParameter(request, "d_attr_ctnt12", ""));
		setHdrImpErrRsn(JSPUtil.getParameter(request, "hdr_imp_err_rsn", ""));
		setDAttrCtnt11(JSPUtil.getParameter(request, "d_attr_ctnt11", ""));
		setDAttrCtnt10(JSPUtil.getParameter(request, "d_attr_ctnt10", ""));
		setDLineNo(JSPUtil.getParameter(request, "d_line_no", ""));
		setTtlRowKnt(JSPUtil.getParameter(request, "ttl_row_knt", ""));
		setHdrAttrCtnt14(JSPUtil.getParameter(request, "hdr_attr_ctnt14", ""));
		setHdrAttrCtnt13(JSPUtil.getParameter(request, "hdr_attr_ctnt13", ""));
		setHdrAttrCtnt15(JSPUtil.getParameter(request, "hdr_attr_ctnt15", ""));
		setHdrCsrAmt(JSPUtil.getParameter(request, "hdr_csr_amt", ""));
		setDInvAmt(JSPUtil.getParameter(request, "d_inv_amt", ""));
		setDAttrCtnt15(JSPUtil.getParameter(request, "d_attr_ctnt15", ""));
		setHdrVndrTermNm(JSPUtil.getParameter(request, "hdr_vndr_term_nm", ""));
		setHdrIfErrRsn(JSPUtil.getParameter(request, "hdr_if_err_rsn", ""));
		setHdrUsrEml(JSPUtil.getParameter(request, "hdr_usr_eml", ""));
		setHdrAttrCtnt11(JSPUtil.getParameter(request, "hdr_attr_ctnt11", ""));
		setHdrAttrCtnt12(JSPUtil.getParameter(request, "hdr_attr_ctnt12", ""));
		setHdrAttrCtnt10(JSPUtil.getParameter(request, "hdr_attr_ctnt10", ""));
		setHdrEaiEvntDt(JSPUtil.getParameter(request, "hdr_eai_evnt_dt", ""));
		setDYdCd(JSPUtil.getParameter(request, "d_yd_cd", ""));
		setHdrPayDt(JSPUtil.getParameter(request, "hdr_pay_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHdrGloAttrCtnt3(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt3", ""));
		setHdrGloAttrCtnt2(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt2", ""));
		setHdrPpayAplyFlg(JSPUtil.getParameter(request, "hdr_ppay_aply_flg", ""));
		setHdrGloAttrCtnt1(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt1", ""));
		setHdrGloAttrCtnt7(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt7", ""));
		setHdrPpdGlDt(JSPUtil.getParameter(request, "hdr_ppd_gl_dt", ""));
		setHdrGloAttrCtnt6(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt6", ""));
		setHdrGloAttrCtnt5(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt5", ""));
		setHdrGloAttrCtnt4(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt4", ""));
		setHdrGloAttrCtnt9(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt9", ""));
		setHdrGloAttrCtnt8(JSPUtil.getParameter(request, "hdr_glo_attr_ctnt8", ""));
		setDDtrbCoaAcctCd(JSPUtil.getParameter(request, "d_dtrb_coa_acct_cd", ""));
		setHdrAproFlg(JSPUtil.getParameter(request, "hdr_apro_flg", ""));
		setHdrTaxCurrXchFlg(JSPUtil.getParameter(request, "hdr_tax_curr_xch_flg", ""));
		setDDtrbCoaFtuN2ndCd(JSPUtil.getParameter(request, "d_dtrb_coa_ftu_n2nd_cd", ""));
		setHdrAttrCateNm(JSPUtil.getParameter(request, "hdr_attr_cate_nm", ""));
		setHdrAftActFlg(JSPUtil.getParameter(request, "hdr_aft_act_flg", ""));
		setDCntrTpszCd(JSPUtil.getParameter(request, "d_cntr_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchApSlipInterfaceListVO[]
	 */
	public SearchApSlipInterfaceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchApSlipInterfaceListVO[]
	 */
	public SearchApSlipInterfaceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchApSlipInterfaceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_no", length));
			String[] hdrCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_acct_cd", length));
			String[] dDtrbCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_inter_co_cd", length));
			String[] hdrEstmErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_estm_err_rsn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdrCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_vvd_cd", length));
			String[] hdrPayAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_amt", length));
			String[] hdrPayGrpLuCd = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_grp_lu_cd", length));
			String[] hdrIfDt = (JSPUtil.getParameter(request, prefix	+ "hdr_if_dt", length));
			String[] dCreDt = (JSPUtil.getParameter(request, prefix	+ "d_cre_dt", length));
			String[] hdrSrcCtnt = (JSPUtil.getParameter(request, prefix	+ "hdr_src_ctnt", length));
			String[] hdrPpdAplyAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_aply_amt", length));
			String[] hdrFtuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt1", length));
			String[] hdrCoaFtuN2ndCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ftu_n2nd_cd", length));
			String[] hdrFtuUseCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt2", length));
			String[] hdrFtuUseCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt3", length));
			String[] hdrFtuUseCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt4", length));
			String[] hdrRcvErrFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_rcv_err_flg", length));
			String[] dLineTpLuCd = (JSPUtil.getParameter(request, prefix	+ "d_line_tp_lu_cd", length));
			String[] dEaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "d_eai_evnt_dt", length));
			String[] dSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "d_so_ofc_cty_cd", length));
			String[] hdrCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_co_cd", length));
			String[] hdrErrCsrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_err_csr_no", length));
			String[] hdrFtuUseCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_ftu_use_ctnt5", length));
			String[] hdrGloAttrCtnt17 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt17", length));
			String[] hdrGloAttrCtnt18 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt18", length));
			String[] hdrActXchRt = (JSPUtil.getParameter(request, prefix	+ "hdr_act_xch_rt", length));
			String[] hdrGloAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt15", length));
			String[] hdrGloAttrCtnt16 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt16", length));
			String[] dInvDesc = (JSPUtil.getParameter(request, prefix	+ "d_inv_desc", length));
			String[] hdrPayMzdLuCd = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_mzd_lu_cd", length));
			String[] hdrAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt5", length));
			String[] hdrAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt4", length));
			String[] dLineSeq = (JSPUtil.getParameter(request, prefix	+ "d_line_seq", length));
			String[] hdrAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt3", length));
			String[] hdrAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt2", length));
			String[] hdrCsrTpCd = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_tp_cd", length));
			String[] hdrAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt1", length));
			String[] dDtrbCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_ctr_cd", length));
			String[] dAttrCateNm = (JSPUtil.getParameter(request, prefix	+ "d_attr_cate_nm", length));
			String[] hdrAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt9", length));
			String[] hdrAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt8", length));
			String[] hdrAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt7", length));
			String[] hdrAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt6", length));
			String[] hdrGlDt = (JSPUtil.getParameter(request, prefix	+ "hdr_gl_dt", length));
			String[] dAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt2", length));
			String[] dAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt3", length));
			String[] dAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt1", length));
			String[] dAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt6", length));
			String[] dAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt7", length));
			String[] dAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt4", length));
			String[] dAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt5", length));
			String[] hdrCxlDt = (JSPUtil.getParameter(request, prefix	+ "hdr_cxl_dt", length));
			String[] dCsrNo = (JSPUtil.getParameter(request, prefix	+ "d_csr_no", length));
			String[] dAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt8", length));
			String[] dAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt9", length));
			String[] hdrInvDesc = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_desc", length));
			String[] dFtuUseCtnt1 = (JSPUtil.getParameter(request, prefix	+ "d_ftu_use_ctnt1", length));
			String[] dFtuUseCtnt2 = (JSPUtil.getParameter(request, prefix	+ "d_ftu_use_ctnt2", length));
			String[] dFtuUseCtnt5 = (JSPUtil.getParameter(request, prefix	+ "d_ftu_use_ctnt5", length));
			String[] dDtrbCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_co_cd", length));
			String[] dFtuUseCtnt3 = (JSPUtil.getParameter(request, prefix	+ "d_ftu_use_ctnt3", length));
			String[] hdrGloAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt10", length));
			String[] dFtuUseCtnt4 = (JSPUtil.getParameter(request, prefix	+ "d_ftu_use_ctnt4", length));
			String[] hdrInvTermDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_term_dt", length));
			String[] hdrGloAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt12", length));
			String[] hdrGloAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt11", length));
			String[] hdrGloAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt14", length));
			String[] hdrImpErrFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_imp_err_flg", length));
			String[] hdrCreDt = (JSPUtil.getParameter(request, prefix	+ "hdr_cre_dt", length));
			String[] hdrGloAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt13", length));
			String[] hdrPpdNo = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_no", length));
			String[] dSoSeq = (JSPUtil.getParameter(request, prefix	+ "d_so_seq", length));
			String[] dDtrbCoaFtuN1stCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_ftu_n1st_cd", length));
			String[] hdrRcvErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_rcv_err_rsn", length));
			String[] dDtrbCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_rgn_cd", length));
			String[] dSoCrrCd = (JSPUtil.getParameter(request, prefix	+ "d_so_crr_cd", length));
			String[] hdrCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_inter_co_cd", length));
			String[] dCreUsrId = (JSPUtil.getParameter(request, prefix	+ "d_cre_usr_id", length));
			String[] hdrCoaFtuN1stCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ftu_n1st_cd", length));
			String[] hdrPpdDtrbNo = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_dtrb_no", length));
			String[] dInvTaxCd = (JSPUtil.getParameter(request, prefix	+ "d_inv_tax_cd", length));
			String[] hdrIfFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_if_flg", length));
			String[] hdrTjOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdr_tj_ofc_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] hdrCsrCurrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_curr_cd", length));
			String[] hdrCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_rgn_cd", length));
			String[] dTrspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "d_trsp_so_tp_cd", length));
			String[] dDtrbCoaVvdCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_vvd_cd", length));
			String[] hdrCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "hdr_coa_ctr_cd", length));
			String[] hdrInvDt = (JSPUtil.getParameter(request, prefix	+ "hdr_inv_dt", length));
			String[] dBkgNo = (JSPUtil.getParameter(request, prefix	+ "d_bkg_no", length));
			String[] hdrTaxDeclFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_tax_decl_flg", length));
			String[] hdrVndrNo = (JSPUtil.getParameter(request, prefix	+ "hdr_vndr_no", length));
			String[] hdrCreUsrId = (JSPUtil.getParameter(request, prefix	+ "hdr_cre_usr_id", length));
			String[] dPlnSctrDivCd = (JSPUtil.getParameter(request, prefix	+ "d_pln_sctr_div_cd", length));
			String[] dActVvdCd = (JSPUtil.getParameter(request, prefix	+ "d_act_vvd_cd", length));
			String[] dAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt14", length));
			String[] dAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt13", length));
			String[] dAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt12", length));
			String[] hdrImpErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_imp_err_rsn", length));
			String[] dAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt11", length));
			String[] dAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt10", length));
			String[] dLineNo = (JSPUtil.getParameter(request, prefix	+ "d_line_no", length));
			String[] ttlRowKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_row_knt", length));
			String[] hdrAttrCtnt14 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt14", length));
			String[] hdrAttrCtnt13 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt13", length));
			String[] hdrAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt15", length));
			String[] hdrCsrAmt = (JSPUtil.getParameter(request, prefix	+ "hdr_csr_amt", length));
			String[] dInvAmt = (JSPUtil.getParameter(request, prefix	+ "d_inv_amt", length));
			String[] dAttrCtnt15 = (JSPUtil.getParameter(request, prefix	+ "d_attr_ctnt15", length));
			String[] hdrVndrTermNm = (JSPUtil.getParameter(request, prefix	+ "hdr_vndr_term_nm", length));
			String[] hdrIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "hdr_if_err_rsn", length));
			String[] hdrUsrEml = (JSPUtil.getParameter(request, prefix	+ "hdr_usr_eml", length));
			String[] hdrAttrCtnt11 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt11", length));
			String[] hdrAttrCtnt12 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt12", length));
			String[] hdrAttrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_ctnt10", length));
			String[] hdrEaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "hdr_eai_evnt_dt", length));
			String[] dYdCd = (JSPUtil.getParameter(request, prefix	+ "d_yd_cd", length));
			String[] hdrPayDt = (JSPUtil.getParameter(request, prefix	+ "hdr_pay_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hdrGloAttrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt3", length));
			String[] hdrGloAttrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt2", length));
			String[] hdrPpayAplyFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_ppay_aply_flg", length));
			String[] hdrGloAttrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt1", length));
			String[] hdrGloAttrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt7", length));
			String[] hdrPpdGlDt = (JSPUtil.getParameter(request, prefix	+ "hdr_ppd_gl_dt", length));
			String[] hdrGloAttrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt6", length));
			String[] hdrGloAttrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt5", length));
			String[] hdrGloAttrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt4", length));
			String[] hdrGloAttrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt9", length));
			String[] hdrGloAttrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "hdr_glo_attr_ctnt8", length));
			String[] dDtrbCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_acct_cd", length));
			String[] hdrAproFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_apro_flg", length));
			String[] hdrTaxCurrXchFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_tax_curr_xch_flg", length));
			String[] dDtrbCoaFtuN2ndCd = (JSPUtil.getParameter(request, prefix	+ "d_dtrb_coa_ftu_n2nd_cd", length));
			String[] hdrAttrCateNm = (JSPUtil.getParameter(request, prefix	+ "hdr_attr_cate_nm", length));
			String[] hdrAftActFlg = (JSPUtil.getParameter(request, prefix	+ "hdr_aft_act_flg", length));
			String[] dCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "d_cntr_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchApSlipInterfaceListVO();
				if (hdrCsrNo[i] != null)
					model.setHdrCsrNo(hdrCsrNo[i]);
				if (hdrCoaAcctCd[i] != null)
					model.setHdrCoaAcctCd(hdrCoaAcctCd[i]);
				if (dDtrbCoaInterCoCd[i] != null)
					model.setDDtrbCoaInterCoCd(dDtrbCoaInterCoCd[i]);
				if (hdrEstmErrRsn[i] != null)
					model.setHdrEstmErrRsn(hdrEstmErrRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdrCoaVvdCd[i] != null)
					model.setHdrCoaVvdCd(hdrCoaVvdCd[i]);
				if (hdrPayAmt[i] != null)
					model.setHdrPayAmt(hdrPayAmt[i]);
				if (hdrPayGrpLuCd[i] != null)
					model.setHdrPayGrpLuCd(hdrPayGrpLuCd[i]);
				if (hdrIfDt[i] != null)
					model.setHdrIfDt(hdrIfDt[i]);
				if (dCreDt[i] != null)
					model.setDCreDt(dCreDt[i]);
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
				if (hdrFtuUseCtnt3[i] != null)
					model.setHdrFtuUseCtnt3(hdrFtuUseCtnt3[i]);
				if (hdrFtuUseCtnt4[i] != null)
					model.setHdrFtuUseCtnt4(hdrFtuUseCtnt4[i]);
				if (hdrRcvErrFlg[i] != null)
					model.setHdrRcvErrFlg(hdrRcvErrFlg[i]);
				if (dLineTpLuCd[i] != null)
					model.setDLineTpLuCd(dLineTpLuCd[i]);
				if (dEaiEvntDt[i] != null)
					model.setDEaiEvntDt(dEaiEvntDt[i]);
				if (dSoOfcCtyCd[i] != null)
					model.setDSoOfcCtyCd(dSoOfcCtyCd[i]);
				if (hdrCoaCoCd[i] != null)
					model.setHdrCoaCoCd(hdrCoaCoCd[i]);
				if (hdrErrCsrNo[i] != null)
					model.setHdrErrCsrNo(hdrErrCsrNo[i]);
				if (hdrFtuUseCtnt5[i] != null)
					model.setHdrFtuUseCtnt5(hdrFtuUseCtnt5[i]);
				if (hdrGloAttrCtnt17[i] != null)
					model.setHdrGloAttrCtnt17(hdrGloAttrCtnt17[i]);
				if (hdrGloAttrCtnt18[i] != null)
					model.setHdrGloAttrCtnt18(hdrGloAttrCtnt18[i]);
				if (hdrActXchRt[i] != null)
					model.setHdrActXchRt(hdrActXchRt[i]);
				if (hdrGloAttrCtnt15[i] != null)
					model.setHdrGloAttrCtnt15(hdrGloAttrCtnt15[i]);
				if (hdrGloAttrCtnt16[i] != null)
					model.setHdrGloAttrCtnt16(hdrGloAttrCtnt16[i]);
				if (dInvDesc[i] != null)
					model.setDInvDesc(dInvDesc[i]);
				if (hdrPayMzdLuCd[i] != null)
					model.setHdrPayMzdLuCd(hdrPayMzdLuCd[i]);
				if (hdrAttrCtnt5[i] != null)
					model.setHdrAttrCtnt5(hdrAttrCtnt5[i]);
				if (hdrAttrCtnt4[i] != null)
					model.setHdrAttrCtnt4(hdrAttrCtnt4[i]);
				if (dLineSeq[i] != null)
					model.setDLineSeq(dLineSeq[i]);
				if (hdrAttrCtnt3[i] != null)
					model.setHdrAttrCtnt3(hdrAttrCtnt3[i]);
				if (hdrAttrCtnt2[i] != null)
					model.setHdrAttrCtnt2(hdrAttrCtnt2[i]);
				if (hdrCsrTpCd[i] != null)
					model.setHdrCsrTpCd(hdrCsrTpCd[i]);
				if (hdrAttrCtnt1[i] != null)
					model.setHdrAttrCtnt1(hdrAttrCtnt1[i]);
				if (dDtrbCoaCtrCd[i] != null)
					model.setDDtrbCoaCtrCd(dDtrbCoaCtrCd[i]);
				if (dAttrCateNm[i] != null)
					model.setDAttrCateNm(dAttrCateNm[i]);
				if (hdrAttrCtnt9[i] != null)
					model.setHdrAttrCtnt9(hdrAttrCtnt9[i]);
				if (hdrAttrCtnt8[i] != null)
					model.setHdrAttrCtnt8(hdrAttrCtnt8[i]);
				if (hdrAttrCtnt7[i] != null)
					model.setHdrAttrCtnt7(hdrAttrCtnt7[i]);
				if (hdrAttrCtnt6[i] != null)
					model.setHdrAttrCtnt6(hdrAttrCtnt6[i]);
				if (hdrGlDt[i] != null)
					model.setHdrGlDt(hdrGlDt[i]);
				if (dAttrCtnt2[i] != null)
					model.setDAttrCtnt2(dAttrCtnt2[i]);
				if (dAttrCtnt3[i] != null)
					model.setDAttrCtnt3(dAttrCtnt3[i]);
				if (dAttrCtnt1[i] != null)
					model.setDAttrCtnt1(dAttrCtnt1[i]);
				if (dAttrCtnt6[i] != null)
					model.setDAttrCtnt6(dAttrCtnt6[i]);
				if (dAttrCtnt7[i] != null)
					model.setDAttrCtnt7(dAttrCtnt7[i]);
				if (dAttrCtnt4[i] != null)
					model.setDAttrCtnt4(dAttrCtnt4[i]);
				if (dAttrCtnt5[i] != null)
					model.setDAttrCtnt5(dAttrCtnt5[i]);
				if (hdrCxlDt[i] != null)
					model.setHdrCxlDt(hdrCxlDt[i]);
				if (dCsrNo[i] != null)
					model.setDCsrNo(dCsrNo[i]);
				if (dAttrCtnt8[i] != null)
					model.setDAttrCtnt8(dAttrCtnt8[i]);
				if (dAttrCtnt9[i] != null)
					model.setDAttrCtnt9(dAttrCtnt9[i]);
				if (hdrInvDesc[i] != null)
					model.setHdrInvDesc(hdrInvDesc[i]);
				if (dFtuUseCtnt1[i] != null)
					model.setDFtuUseCtnt1(dFtuUseCtnt1[i]);
				if (dFtuUseCtnt2[i] != null)
					model.setDFtuUseCtnt2(dFtuUseCtnt2[i]);
				if (dFtuUseCtnt5[i] != null)
					model.setDFtuUseCtnt5(dFtuUseCtnt5[i]);
				if (dDtrbCoaCoCd[i] != null)
					model.setDDtrbCoaCoCd(dDtrbCoaCoCd[i]);
				if (dFtuUseCtnt3[i] != null)
					model.setDFtuUseCtnt3(dFtuUseCtnt3[i]);
				if (hdrGloAttrCtnt10[i] != null)
					model.setHdrGloAttrCtnt10(hdrGloAttrCtnt10[i]);
				if (dFtuUseCtnt4[i] != null)
					model.setDFtuUseCtnt4(dFtuUseCtnt4[i]);
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
				if (hdrCreDt[i] != null)
					model.setHdrCreDt(hdrCreDt[i]);
				if (hdrGloAttrCtnt13[i] != null)
					model.setHdrGloAttrCtnt13(hdrGloAttrCtnt13[i]);
				if (hdrPpdNo[i] != null)
					model.setHdrPpdNo(hdrPpdNo[i]);
				if (dSoSeq[i] != null)
					model.setDSoSeq(dSoSeq[i]);
				if (dDtrbCoaFtuN1stCd[i] != null)
					model.setDDtrbCoaFtuN1stCd(dDtrbCoaFtuN1stCd[i]);
				if (hdrRcvErrRsn[i] != null)
					model.setHdrRcvErrRsn(hdrRcvErrRsn[i]);
				if (dDtrbCoaRgnCd[i] != null)
					model.setDDtrbCoaRgnCd(dDtrbCoaRgnCd[i]);
				if (dSoCrrCd[i] != null)
					model.setDSoCrrCd(dSoCrrCd[i]);
				if (hdrCoaInterCoCd[i] != null)
					model.setHdrCoaInterCoCd(hdrCoaInterCoCd[i]);
				if (dCreUsrId[i] != null)
					model.setDCreUsrId(dCreUsrId[i]);
				if (hdrCoaFtuN1stCd[i] != null)
					model.setHdrCoaFtuN1stCd(hdrCoaFtuN1stCd[i]);
				if (hdrPpdDtrbNo[i] != null)
					model.setHdrPpdDtrbNo(hdrPpdDtrbNo[i]);
				if (dInvTaxCd[i] != null)
					model.setDInvTaxCd(dInvTaxCd[i]);
				if (hdrIfFlg[i] != null)
					model.setHdrIfFlg(hdrIfFlg[i]);
				if (hdrTjOfcCd[i] != null)
					model.setHdrTjOfcCd(hdrTjOfcCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (hdrCsrCurrCd[i] != null)
					model.setHdrCsrCurrCd(hdrCsrCurrCd[i]);
				if (hdrCoaRgnCd[i] != null)
					model.setHdrCoaRgnCd(hdrCoaRgnCd[i]);
				if (dTrspSoTpCd[i] != null)
					model.setDTrspSoTpCd(dTrspSoTpCd[i]);
				if (dDtrbCoaVvdCd[i] != null)
					model.setDDtrbCoaVvdCd(dDtrbCoaVvdCd[i]);
				if (hdrCoaCtrCd[i] != null)
					model.setHdrCoaCtrCd(hdrCoaCtrCd[i]);
				if (hdrInvDt[i] != null)
					model.setHdrInvDt(hdrInvDt[i]);
				if (dBkgNo[i] != null)
					model.setDBkgNo(dBkgNo[i]);
				if (hdrTaxDeclFlg[i] != null)
					model.setHdrTaxDeclFlg(hdrTaxDeclFlg[i]);
				if (hdrVndrNo[i] != null)
					model.setHdrVndrNo(hdrVndrNo[i]);
				if (hdrCreUsrId[i] != null)
					model.setHdrCreUsrId(hdrCreUsrId[i]);
				if (dPlnSctrDivCd[i] != null)
					model.setDPlnSctrDivCd(dPlnSctrDivCd[i]);
				if (dActVvdCd[i] != null)
					model.setDActVvdCd(dActVvdCd[i]);
				if (dAttrCtnt14[i] != null)
					model.setDAttrCtnt14(dAttrCtnt14[i]);
				if (dAttrCtnt13[i] != null)
					model.setDAttrCtnt13(dAttrCtnt13[i]);
				if (dAttrCtnt12[i] != null)
					model.setDAttrCtnt12(dAttrCtnt12[i]);
				if (hdrImpErrRsn[i] != null)
					model.setHdrImpErrRsn(hdrImpErrRsn[i]);
				if (dAttrCtnt11[i] != null)
					model.setDAttrCtnt11(dAttrCtnt11[i]);
				if (dAttrCtnt10[i] != null)
					model.setDAttrCtnt10(dAttrCtnt10[i]);
				if (dLineNo[i] != null)
					model.setDLineNo(dLineNo[i]);
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
				if (dInvAmt[i] != null)
					model.setDInvAmt(dInvAmt[i]);
				if (dAttrCtnt15[i] != null)
					model.setDAttrCtnt15(dAttrCtnt15[i]);
				if (hdrVndrTermNm[i] != null)
					model.setHdrVndrTermNm(hdrVndrTermNm[i]);
				if (hdrIfErrRsn[i] != null)
					model.setHdrIfErrRsn(hdrIfErrRsn[i]);
				if (hdrUsrEml[i] != null)
					model.setHdrUsrEml(hdrUsrEml[i]);
				if (hdrAttrCtnt11[i] != null)
					model.setHdrAttrCtnt11(hdrAttrCtnt11[i]);
				if (hdrAttrCtnt12[i] != null)
					model.setHdrAttrCtnt12(hdrAttrCtnt12[i]);
				if (hdrAttrCtnt10[i] != null)
					model.setHdrAttrCtnt10(hdrAttrCtnt10[i]);
				if (hdrEaiEvntDt[i] != null)
					model.setHdrEaiEvntDt(hdrEaiEvntDt[i]);
				if (dYdCd[i] != null)
					model.setDYdCd(dYdCd[i]);
				if (hdrPayDt[i] != null)
					model.setHdrPayDt(hdrPayDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hdrGloAttrCtnt3[i] != null)
					model.setHdrGloAttrCtnt3(hdrGloAttrCtnt3[i]);
				if (hdrGloAttrCtnt2[i] != null)
					model.setHdrGloAttrCtnt2(hdrGloAttrCtnt2[i]);
				if (hdrPpayAplyFlg[i] != null)
					model.setHdrPpayAplyFlg(hdrPpayAplyFlg[i]);
				if (hdrGloAttrCtnt1[i] != null)
					model.setHdrGloAttrCtnt1(hdrGloAttrCtnt1[i]);
				if (hdrGloAttrCtnt7[i] != null)
					model.setHdrGloAttrCtnt7(hdrGloAttrCtnt7[i]);
				if (hdrPpdGlDt[i] != null)
					model.setHdrPpdGlDt(hdrPpdGlDt[i]);
				if (hdrGloAttrCtnt6[i] != null)
					model.setHdrGloAttrCtnt6(hdrGloAttrCtnt6[i]);
				if (hdrGloAttrCtnt5[i] != null)
					model.setHdrGloAttrCtnt5(hdrGloAttrCtnt5[i]);
				if (hdrGloAttrCtnt4[i] != null)
					model.setHdrGloAttrCtnt4(hdrGloAttrCtnt4[i]);
				if (hdrGloAttrCtnt9[i] != null)
					model.setHdrGloAttrCtnt9(hdrGloAttrCtnt9[i]);
				if (hdrGloAttrCtnt8[i] != null)
					model.setHdrGloAttrCtnt8(hdrGloAttrCtnt8[i]);
				if (dDtrbCoaAcctCd[i] != null)
					model.setDDtrbCoaAcctCd(dDtrbCoaAcctCd[i]);
				if (hdrAproFlg[i] != null)
					model.setHdrAproFlg(hdrAproFlg[i]);
				if (hdrTaxCurrXchFlg[i] != null)
					model.setHdrTaxCurrXchFlg(hdrTaxCurrXchFlg[i]);
				if (dDtrbCoaFtuN2ndCd[i] != null)
					model.setDDtrbCoaFtuN2ndCd(dDtrbCoaFtuN2ndCd[i]);
				if (hdrAttrCateNm[i] != null)
					model.setHdrAttrCateNm(hdrAttrCateNm[i]);
				if (hdrAftActFlg[i] != null)
					model.setHdrAftActFlg(hdrAftActFlg[i]);
				if (dCntrTpszCd[i] != null)
					model.setDCntrTpszCd(dCntrTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchApSlipInterfaceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchApSlipInterfaceListVO[]
	 */
	public SearchApSlipInterfaceListVO[] getSearchApSlipInterfaceListVOs(){
		SearchApSlipInterfaceListVO[] vos = (SearchApSlipInterfaceListVO[])models.toArray(new SearchApSlipInterfaceListVO[models.size()]);
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
		this.hdrCsrNo = this.hdrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaAcctCd = this.hdrCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaInterCoCd = this.dDtrbCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrEstmErrRsn = this.hdrEstmErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaVvdCd = this.hdrCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayAmt = this.hdrPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayGrpLuCd = this.hdrPayGrpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfDt = this.hdrIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCreDt = this.dCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrSrcCtnt = this.hdrSrcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdAplyAmt = this.hdrPpdAplyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt1 = this.hdrFtuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaFtuN2ndCd = this.hdrCoaFtuN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt2 = this.hdrFtuUseCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt3 = this.hdrFtuUseCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt4 = this.hdrFtuUseCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrRcvErrFlg = this.hdrRcvErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLineTpLuCd = this.dLineTpLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dEaiEvntDt = this.dEaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSoOfcCtyCd = this.dSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaCoCd = this.hdrCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrErrCsrNo = this.hdrErrCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrFtuUseCtnt5 = this.hdrFtuUseCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt17 = this.hdrGloAttrCtnt17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt18 = this.hdrGloAttrCtnt18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrActXchRt = this.hdrActXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt15 = this.hdrGloAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt16 = this.hdrGloAttrCtnt16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dInvDesc = this.dInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayMzdLuCd = this.hdrPayMzdLuCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt5 = this.hdrAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt4 = this.hdrAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLineSeq = this.dLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt3 = this.hdrAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt2 = this.hdrAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrTpCd = this.hdrCsrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt1 = this.hdrAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaCtrCd = this.dDtrbCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCateNm = this.dAttrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt9 = this.hdrAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt8 = this.hdrAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt7 = this.hdrAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt6 = this.hdrAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGlDt = this.hdrGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt2 = this.dAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt3 = this.dAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt1 = this.dAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt6 = this.dAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt7 = this.dAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt4 = this.dAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt5 = this.dAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCxlDt = this.hdrCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCsrNo = this.dCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt8 = this.dAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt9 = this.dAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDesc = this.hdrInvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFtuUseCtnt1 = this.dFtuUseCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFtuUseCtnt2 = this.dFtuUseCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFtuUseCtnt5 = this.dFtuUseCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaCoCd = this.dDtrbCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFtuUseCtnt3 = this.dFtuUseCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt10 = this.hdrGloAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dFtuUseCtnt4 = this.dFtuUseCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvTermDt = this.hdrInvTermDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt12 = this.hdrGloAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt11 = this.hdrGloAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt14 = this.hdrGloAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrImpErrFlg = this.hdrImpErrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCreDt = this.hdrCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt13 = this.hdrGloAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdNo = this.hdrPpdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSoSeq = this.dSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaFtuN1stCd = this.dDtrbCoaFtuN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrRcvErrRsn = this.hdrRcvErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaRgnCd = this.dDtrbCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dSoCrrCd = this.dSoCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaInterCoCd = this.hdrCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCreUsrId = this.dCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaFtuN1stCd = this.hdrCoaFtuN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdDtrbNo = this.hdrPpdDtrbNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dInvTaxCd = this.dInvTaxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfFlg = this.hdrIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTjOfcCd = this.hdrTjOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrCurrCd = this.hdrCsrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaRgnCd = this.hdrCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTrspSoTpCd = this.dTrspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaVvdCd = this.dDtrbCoaVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCoaCtrCd = this.hdrCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrInvDt = this.hdrInvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dBkgNo = this.dBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTaxDeclFlg = this.hdrTaxDeclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrVndrNo = this.hdrVndrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCreUsrId = this.hdrCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPlnSctrDivCd = this.dPlnSctrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dActVvdCd = this.dActVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt14 = this.dAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt13 = this.dAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt12 = this.dAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrImpErrRsn = this.hdrImpErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt11 = this.dAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt10 = this.dAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLineNo = this.dLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRowKnt = this.ttlRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt14 = this.hdrAttrCtnt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt13 = this.hdrAttrCtnt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt15 = this.hdrAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCsrAmt = this.hdrCsrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dInvAmt = this.dInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dAttrCtnt15 = this.dAttrCtnt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrVndrTermNm = this.hdrVndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrIfErrRsn = this.hdrIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrUsrEml = this.hdrUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt11 = this.hdrAttrCtnt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt12 = this.hdrAttrCtnt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCtnt10 = this.hdrAttrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrEaiEvntDt = this.hdrEaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dYdCd = this.dYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPayDt = this.hdrPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt3 = this.hdrGloAttrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt2 = this.hdrGloAttrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpayAplyFlg = this.hdrPpayAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt1 = this.hdrGloAttrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt7 = this.hdrGloAttrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrPpdGlDt = this.hdrPpdGlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt6 = this.hdrGloAttrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt5 = this.hdrGloAttrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt4 = this.hdrGloAttrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt9 = this.hdrGloAttrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrGloAttrCtnt8 = this.hdrGloAttrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaAcctCd = this.dDtrbCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAproFlg = this.hdrAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrTaxCurrXchFlg = this.hdrTaxCurrXchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDtrbCoaFtuN2ndCd = this.dDtrbCoaFtuN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAttrCateNm = this.hdrAttrCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrAftActFlg = this.hdrAftActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCntrTpszCd = this.dCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
