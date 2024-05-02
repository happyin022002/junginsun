/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SapInvoiceInterfaceHeaderVO.java
 *@FileTitle : SapInvoiceInterfaceHeaderVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.10.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SapInvoiceInterfaceHeaderVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SapInvoiceInterfaceHeaderVO>  models =	new	ArrayList<SapInvoiceInterfaceHeaderVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 apPayMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 apIfErrRsn   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 calcTaxImpFlg   =  null;
	/*	Column Info	*/
	private  String	 invRcvDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 liabCoaVvdCd   =  null;
	/*	Column Info	*/
	private  String	 aproFlg   =  null;
	/*	Column Info	*/
	private  String	 liabCoaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt20   =  null;
	/*	Column Info	*/
	private  String	 payGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 liabCoaAcctNo   =  null;
	/*	Column Info	*/
	private  String	 invPayCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invXchDt   =  null;
	/*	Column Info	*/
	private  String	 xterBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 invTermDt   =  null;
	/*	Column Info	*/
	private  String	 invTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 invIfStsCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 orgInvNo   =  null;
	/*	Column Info	*/
	private  String	 invInclPpayFlg   =  null;
	/*	Column Info	*/
	private  String	 liabCoaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt19   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt17   =  null;
	/*	Column Info	*/
	private  String	 ppayInvNo   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt18   =  null;
	/*	Column Info	*/
	private  String	 invVatCd   =  null;
	/*	Column Info	*/
	private  String	 ifRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt16   =  null;
	/*	Column Info	*/
	private  String	 invIfGrpSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 ppayAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 invIfFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 ppayAplyGlDt   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 invVatAmt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 ifSrcNm   =  null;
	/*	Column Info	*/
	private  String	 ifRequestSeq   =  null;
	/*	Column Info	*/
	private  String	 liabCoaCoCd   =  null;
	/*	Column Info	*/
	private  String	 invIfSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 vchrNo   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ppayInvLineNo   =  null;
	/*	Column Info	*/
	private  String	 liabCoaInterCoCd   =  null;
	/*	Column Info	*/
	private  String	 invTermNm   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 functionalAmount   =  null;
	/*	Column Info	*/
	private  String	 lAttributeCategory   =  null;
	/*	Column Info	*/
	private  String	 vndrBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrBankAcctPrioCd   =  null;
	/*	Column Info	*/
	private  String	 vndrBankAcctVndrNo   =  null;
	/*	Column Info	*/
	private  String	 creationUser   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SapInvoiceInterfaceHeaderVO(){}

	public SapInvoiceInterfaceHeaderVO(String glDt,String attrCtnt10,String attrCtnt14,String apPayMzdLuCd,String attrCtnt13,String apIfErrRsn,String attrCtnt12,String attrCtnt11,String calcTaxImpFlg,String invRcvDt,String pagerows,String attrCtnt15,String invDesc,String vndrNo,String liabCdCmbSeq,String liabCoaVvdCd,String aproFlg,String liabCoaRgnCd,String attrCateNm,String invXchRt,String invDt,String gloAttrCtnt20,String payGrpLuCd,String liabCoaAcctNo,String invPayCurrCd,String invXchDt,String xterBankAcctSeq,String invTermDt,String invTpLuCd,String invIfStsCd,String invXchRtTpCd,String orgInvNo,String invInclPpayFlg,String liabCoaCtrCd,String gloAttrCtnt19,String gloAttrCtnt17,String ppayInvNo,String gloAttrCtnt18,String invVatCd,String ifRqstSeq,String attrCtnt9,String gloAttrCtnt15,String attrCtnt8,String gloAttrCtnt16,String invIfGrpSeq,String gloAttrCtnt13,String gloAttrCtnt14,String gloAttrCtnt11,String gloAttrCtnt12,String ppayAplyAmt,String gloAttrCtnt10,String attrCtnt1,String attrCtnt2,String ibflag,String attrCtnt3,String attrCtnt4,String usrId,String attrCtnt5,String attrCtnt6,String invIfFlg,String attrCtnt7,String gloAttrCtnt2,String ppayAplyGlDt,String invAmt,String gloAttrCtnt3,String gloAttrCtnt4,String gloAttrCtnt5,String gloAttrCtnt6,String gloAttrCtnt7,String gloAttrCtnt8,String gloAttrCtnt9,String invVatAmt,String gloAttrCtnt1,String ifSrcNm,String ifRequestSeq,String liabCoaCoCd,String invIfSeq,String gloAttrCateNm,String invCurrCd,String vchrNo,String invNo,String ofcCd,String ppayInvLineNo,String liabCoaInterCoCd,String invTermNm,String functionalCurrency,String invSeq,String functionalAmount,String lAttributeCategory,String vndrBankAcctSeq,String vndrBankAcctPrioCd,String vndrBankAcctVndrNo,String creationUser)	{
		this.glDt  = glDt ;
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.apPayMzdLuCd  = apPayMzdLuCd ;
		this.attrCtnt13  = attrCtnt13 ;
		this.apIfErrRsn  = apIfErrRsn ;
		this.attrCtnt12  = attrCtnt12 ;
		this.attrCtnt11  = attrCtnt11 ;
		this.calcTaxImpFlg  = calcTaxImpFlg ;
		this.invRcvDt  = invRcvDt ;
		this.pagerows  = pagerows ;
		this.attrCtnt15  = attrCtnt15 ;
		this.invDesc  = invDesc ;
		this.vndrNo  = vndrNo ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.liabCoaVvdCd  = liabCoaVvdCd ;
		this.aproFlg  = aproFlg ;
		this.liabCoaRgnCd  = liabCoaRgnCd ;
		this.attrCateNm  = attrCateNm ;
		this.invXchRt  = invXchRt ;
		this.invDt  = invDt ;
		this.gloAttrCtnt20  = gloAttrCtnt20 ;
		this.payGrpLuCd  = payGrpLuCd ;
		this.liabCoaAcctNo  = liabCoaAcctNo ;
		this.invPayCurrCd  = invPayCurrCd ;
		this.invXchDt  = invXchDt ;
		this.xterBankAcctSeq  = xterBankAcctSeq ;
		this.invTermDt  = invTermDt ;
		this.invTpLuCd  = invTpLuCd ;
		this.invIfStsCd  = invIfStsCd ;
		this.invXchRtTpCd  = invXchRtTpCd ;
		this.orgInvNo  = orgInvNo ;
		this.invInclPpayFlg  = invInclPpayFlg ;
		this.liabCoaCtrCd  = liabCoaCtrCd ;
		this.gloAttrCtnt19  = gloAttrCtnt19 ;
		this.gloAttrCtnt17  = gloAttrCtnt17 ;
		this.ppayInvNo  = ppayInvNo ;
		this.gloAttrCtnt18  = gloAttrCtnt18 ;
		this.invVatCd  = invVatCd ;
		this.ifRqstSeq  = ifRqstSeq ;
		this.attrCtnt9  = attrCtnt9 ;
		this.gloAttrCtnt15  = gloAttrCtnt15 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.gloAttrCtnt16  = gloAttrCtnt16 ;
		this.invIfGrpSeq  = invIfGrpSeq ;
		this.gloAttrCtnt13  = gloAttrCtnt13 ;
		this.gloAttrCtnt14  = gloAttrCtnt14 ;
		this.gloAttrCtnt11  = gloAttrCtnt11 ;
		this.gloAttrCtnt12  = gloAttrCtnt12 ;
		this.ppayAplyAmt  = ppayAplyAmt ;
		this.gloAttrCtnt10  = gloAttrCtnt10 ;
		this.attrCtnt1  = attrCtnt1 ;
		this.attrCtnt2  = attrCtnt2 ;
		this.ibflag  = ibflag ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.usrId  = usrId ;
		this.attrCtnt5  = attrCtnt5 ;
		this.attrCtnt6  = attrCtnt6 ;
		this.invIfFlg  = invIfFlg ;
		this.attrCtnt7  = attrCtnt7 ;
		this.gloAttrCtnt2  = gloAttrCtnt2 ;
		this.ppayAplyGlDt  = ppayAplyGlDt ;
		this.invAmt  = invAmt ;
		this.gloAttrCtnt3  = gloAttrCtnt3 ;
		this.gloAttrCtnt4  = gloAttrCtnt4 ;
		this.gloAttrCtnt5  = gloAttrCtnt5 ;
		this.gloAttrCtnt6  = gloAttrCtnt6 ;
		this.gloAttrCtnt7  = gloAttrCtnt7 ;
		this.gloAttrCtnt8  = gloAttrCtnt8 ;
		this.gloAttrCtnt9  = gloAttrCtnt9 ;
		this.invVatAmt  = invVatAmt ;
		this.gloAttrCtnt1  = gloAttrCtnt1 ;
		this.ifSrcNm  = ifSrcNm ;
		this.ifRequestSeq  = ifRequestSeq ;
		this.liabCoaCoCd  = liabCoaCoCd ;
		this.invIfSeq  = invIfSeq ;
		this.gloAttrCateNm  = gloAttrCateNm ;
		this.invCurrCd  = invCurrCd ;
		this.vchrNo  = vchrNo ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.ppayInvLineNo  = ppayInvLineNo ;
		this.liabCoaInterCoCd  = liabCoaInterCoCd ;
		this.invTermNm  = invTermNm ;
		this.functionalCurrency  = functionalCurrency ;
		this.invSeq  = invSeq ;
		this.functionalAmount  = functionalAmount ;
		this.lAttributeCategory  = lAttributeCategory ;
		this.vndrBankAcctSeq  = vndrBankAcctSeq ;
		this.vndrBankAcctPrioCd  = vndrBankAcctPrioCd ;
		this.vndrBankAcctVndrNo  = vndrBankAcctVndrNo ;
		this.creationUser  = creationUser ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("ap_pay_mzd_lu_cd", getApPayMzdLuCd());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("ap_if_err_rsn", getApIfErrRsn());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("calc_tax_imp_flg", getCalcTaxImpFlg());		
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("liab_coa_vvd_cd", getLiabCoaVvdCd());		
		this.hashColumns.put("apro_flg", getAproFlg());		
		this.hashColumns.put("liab_coa_rgn_cd", getLiabCoaRgnCd());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("glo_attr_ctnt20", getGloAttrCtnt20());		
		this.hashColumns.put("pay_grp_lu_cd", getPayGrpLuCd());		
		this.hashColumns.put("liab_coa_acct_no", getLiabCoaAcctNo());		
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());		
		this.hashColumns.put("inv_xch_dt", getInvXchDt());		
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());		
		this.hashColumns.put("inv_term_dt", getInvTermDt());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("inv_if_sts_cd", getInvIfStsCd());		
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());		
		this.hashColumns.put("org_inv_no", getOrgInvNo());		
		this.hashColumns.put("inv_incl_ppay_flg", getInvInclPpayFlg());		
		this.hashColumns.put("liab_coa_ctr_cd", getLiabCoaCtrCd());		
		this.hashColumns.put("glo_attr_ctnt19", getGloAttrCtnt19());		
		this.hashColumns.put("glo_attr_ctnt17", getGloAttrCtnt17());		
		this.hashColumns.put("ppay_inv_no", getPpayInvNo());		
		this.hashColumns.put("glo_attr_ctnt18", getGloAttrCtnt18());		
		this.hashColumns.put("inv_vat_cd", getInvVatCd());		
		this.hashColumns.put("if_rqst_seq", getIfRqstSeq());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("glo_attr_ctnt15", getGloAttrCtnt15());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt16", getGloAttrCtnt16());		
		this.hashColumns.put("inv_if_grp_seq", getInvIfGrpSeq());		
		this.hashColumns.put("glo_attr_ctnt13", getGloAttrCtnt13());		
		this.hashColumns.put("glo_attr_ctnt14", getGloAttrCtnt14());		
		this.hashColumns.put("glo_attr_ctnt11", getGloAttrCtnt11());		
		this.hashColumns.put("glo_attr_ctnt12", getGloAttrCtnt12());		
		this.hashColumns.put("ppay_aply_amt", getPpayAplyAmt());		
		this.hashColumns.put("glo_attr_ctnt10", getGloAttrCtnt10());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("inv_if_flg", getInvIfFlg());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt2", getGloAttrCtnt2());		
		this.hashColumns.put("ppay_aply_gl_dt", getPpayAplyGlDt());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("glo_attr_ctnt3", getGloAttrCtnt3());		
		this.hashColumns.put("glo_attr_ctnt4", getGloAttrCtnt4());		
		this.hashColumns.put("glo_attr_ctnt5", getGloAttrCtnt5());		
		this.hashColumns.put("glo_attr_ctnt6", getGloAttrCtnt6());		
		this.hashColumns.put("glo_attr_ctnt7", getGloAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt8", getGloAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt9", getGloAttrCtnt9());		
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());		
		this.hashColumns.put("glo_attr_ctnt1", getGloAttrCtnt1());		
		this.hashColumns.put("if_src_nm", getIfSrcNm());		
		this.hashColumns.put("if_request_seq", getIfRequestSeq());		
		this.hashColumns.put("liab_coa_co_cd", getLiabCoaCoCd());		
		this.hashColumns.put("inv_if_seq", getInvIfSeq());		
		this.hashColumns.put("glo_attr_cate_nm", getGloAttrCateNm());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("vchr_no", getVchrNo());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ppay_inv_line_no", getPpayInvLineNo());		
		this.hashColumns.put("liab_coa_inter_co_cd", getLiabCoaInterCoCd());		
		this.hashColumns.put("inv_term_nm", getInvTermNm());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("functional_amount", getFunctionalAmount());		
		this.hashColumns.put("l_attribute_category", getLAttributeCategory());		
		this.hashColumns.put("vndr_bank_acct_seq", getVndrBankAcctSeq());		
		this.hashColumns.put("vndr_bank_acct_prio_cd", getVndrBankAcctPrioCd());		
		this.hashColumns.put("vndr_bank_acct_vndr_no", getVndrBankAcctVndrNo());		
		this.hashColumns.put("creation_user", getCreationUser());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("ap_pay_mzd_lu_cd", "apPayMzdLuCd");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("ap_if_err_rsn", "apIfErrRsn");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("calc_tax_imp_flg", "calcTaxImpFlg");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("liab_coa_vvd_cd", "liabCoaVvdCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("liab_coa_rgn_cd", "liabCoaRgnCd");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("glo_attr_ctnt20", "gloAttrCtnt20");
		this.hashFields.put("pay_grp_lu_cd", "payGrpLuCd");
		this.hashFields.put("liab_coa_acct_no", "liabCoaAcctNo");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("inv_if_sts_cd", "invIfStsCd");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("org_inv_no", "orgInvNo");
		this.hashFields.put("inv_incl_ppay_flg", "invInclPpayFlg");
		this.hashFields.put("liab_coa_ctr_cd", "liabCoaCtrCd");
		this.hashFields.put("glo_attr_ctnt19", "gloAttrCtnt19");
		this.hashFields.put("glo_attr_ctnt17", "gloAttrCtnt17");
		this.hashFields.put("ppay_inv_no", "ppayInvNo");
		this.hashFields.put("glo_attr_ctnt18", "gloAttrCtnt18");
		this.hashFields.put("inv_vat_cd", "invVatCd");
		this.hashFields.put("if_rqst_seq", "ifRqstSeq");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("glo_attr_ctnt15", "gloAttrCtnt15");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("glo_attr_ctnt16", "gloAttrCtnt16");
		this.hashFields.put("inv_if_grp_seq", "invIfGrpSeq");
		this.hashFields.put("glo_attr_ctnt13", "gloAttrCtnt13");
		this.hashFields.put("glo_attr_ctnt14", "gloAttrCtnt14");
		this.hashFields.put("glo_attr_ctnt11", "gloAttrCtnt11");
		this.hashFields.put("glo_attr_ctnt12", "gloAttrCtnt12");
		this.hashFields.put("ppay_aply_amt", "ppayAplyAmt");
		this.hashFields.put("glo_attr_ctnt10", "gloAttrCtnt10");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("glo_attr_ctnt2", "gloAttrCtnt2");
		this.hashFields.put("ppay_aply_gl_dt", "ppayAplyGlDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("glo_attr_ctnt3", "gloAttrCtnt3");
		this.hashFields.put("glo_attr_ctnt4", "gloAttrCtnt4");
		this.hashFields.put("glo_attr_ctnt5", "gloAttrCtnt5");
		this.hashFields.put("glo_attr_ctnt6", "gloAttrCtnt6");
		this.hashFields.put("glo_attr_ctnt7", "gloAttrCtnt7");
		this.hashFields.put("glo_attr_ctnt8", "gloAttrCtnt8");
		this.hashFields.put("glo_attr_ctnt9", "gloAttrCtnt9");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("glo_attr_ctnt1", "gloAttrCtnt1");
		this.hashFields.put("if_src_nm", "ifSrcNm");
		this.hashFields.put("if_request_seq", "ifRequestSeq");
		this.hashFields.put("liab_coa_co_cd", "liabCoaCoCd");
		this.hashFields.put("inv_if_seq", "invIfSeq");
		this.hashFields.put("glo_attr_cate_nm", "gloAttrCateNm");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("vchr_no", "vchrNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ppay_inv_line_no", "ppayInvLineNo");
		this.hashFields.put("liab_coa_inter_co_cd", "liabCoaInterCoCd");
		this.hashFields.put("inv_term_nm", "invTermNm");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("functional_amount", "functionalAmount");
		this.hashFields.put("l_attribute_category", "lAttributeCategory");
		this.hashFields.put("vndr_bank_acct_seq", "vndrBankAcctSeq");
		this.hashFields.put("vndr_bank_acct_prio_cd", "vndrBankAcctPrioCd");
		this.hashFields.put("vndr_bank_acct_vndr_no", "vndrBankAcctVndrNo");
		this.hashFields.put("creation_user", "creationUser");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt10
	*/
	public void	setAttrCtnt10( String	attrCtnt10 ) {
		this.attrCtnt10 =	attrCtnt10;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt10
	 */
	 public	 String	getAttrCtnt10() {
		 return	this.attrCtnt10;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt14
	*/
	public void	setAttrCtnt14( String	attrCtnt14 ) {
		this.attrCtnt14 =	attrCtnt14;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt14
	 */
	 public	 String	getAttrCtnt14() {
		 return	this.attrCtnt14;
	 } 
 	/**
	* Column Info
	* @param  apPayMzdLuCd
	*/
	public void	setApPayMzdLuCd( String	apPayMzdLuCd ) {
		this.apPayMzdLuCd =	apPayMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	apPayMzdLuCd
	 */
	 public	 String	getApPayMzdLuCd() {
		 return	this.apPayMzdLuCd;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt13
	*/
	public void	setAttrCtnt13( String	attrCtnt13 ) {
		this.attrCtnt13 =	attrCtnt13;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt13
	 */
	 public	 String	getAttrCtnt13() {
		 return	this.attrCtnt13;
	 } 
 	/**
	* Column Info
	* @param  apIfErrRsn
	*/
	public void	setApIfErrRsn( String	apIfErrRsn ) {
		this.apIfErrRsn =	apIfErrRsn;
	}
 
	/**
	 * Column Info
	 * @return	apIfErrRsn
	 */
	 public	 String	getApIfErrRsn() {
		 return	this.apIfErrRsn;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt12
	*/
	public void	setAttrCtnt12( String	attrCtnt12 ) {
		this.attrCtnt12 =	attrCtnt12;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt12
	 */
	 public	 String	getAttrCtnt12() {
		 return	this.attrCtnt12;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt11
	*/
	public void	setAttrCtnt11( String	attrCtnt11 ) {
		this.attrCtnt11 =	attrCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt11
	 */
	 public	 String	getAttrCtnt11() {
		 return	this.attrCtnt11;
	 } 
 	/**
	* Column Info
	* @param  calcTaxImpFlg
	*/
	public void	setCalcTaxImpFlg( String	calcTaxImpFlg ) {
		this.calcTaxImpFlg =	calcTaxImpFlg;
	}
 
	/**
	 * Column Info
	 * @return	calcTaxImpFlg
	 */
	 public	 String	getCalcTaxImpFlg() {
		 return	this.calcTaxImpFlg;
	 } 
 	/**
	* Column Info
	* @param  invRcvDt
	*/
	public void	setInvRcvDt( String	invRcvDt ) {
		this.invRcvDt =	invRcvDt;
	}
 
	/**
	 * Column Info
	 * @return	invRcvDt
	 */
	 public	 String	getInvRcvDt() {
		 return	this.invRcvDt;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt15
	*/
	public void	setAttrCtnt15( String	attrCtnt15 ) {
		this.attrCtnt15 =	attrCtnt15;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt15
	 */
	 public	 String	getAttrCtnt15() {
		 return	this.attrCtnt15;
	 } 
 	/**
	* Column Info
	* @param  invDesc
	*/
	public void	setInvDesc( String	invDesc ) {
		this.invDesc =	invDesc;
	}
 
	/**
	 * Column Info
	 * @return	invDesc
	 */
	 public	 String	getInvDesc() {
		 return	this.invDesc;
	 } 
 	/**
	* Column Info
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
	 } 
 	/**
	* Column Info
	* @param  liabCdCmbSeq
	*/
	public void	setLiabCdCmbSeq( String	liabCdCmbSeq ) {
		this.liabCdCmbSeq =	liabCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	liabCdCmbSeq
	 */
	 public	 String	getLiabCdCmbSeq() {
		 return	this.liabCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  liabCoaVvdCd
	*/
	public void	setLiabCoaVvdCd( String	liabCoaVvdCd ) {
		this.liabCoaVvdCd =	liabCoaVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaVvdCd
	 */
	 public	 String	getLiabCoaVvdCd() {
		 return	this.liabCoaVvdCd;
	 } 
 	/**
	* Column Info
	* @param  aproFlg
	*/
	public void	setAproFlg( String	aproFlg ) {
		this.aproFlg =	aproFlg;
	}
 
	/**
	 * Column Info
	 * @return	aproFlg
	 */
	 public	 String	getAproFlg() {
		 return	this.aproFlg;
	 } 
 	/**
	* Column Info
	* @param  liabCoaRgnCd
	*/
	public void	setLiabCoaRgnCd( String	liabCoaRgnCd ) {
		this.liabCoaRgnCd =	liabCoaRgnCd;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaRgnCd
	 */
	 public	 String	getLiabCoaRgnCd() {
		 return	this.liabCoaRgnCd;
	 } 
 	/**
	* Column Info
	* @param  attrCateNm
	*/
	public void	setAttrCateNm( String	attrCateNm ) {
		this.attrCateNm =	attrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	attrCateNm
	 */
	 public	 String	getAttrCateNm() {
		 return	this.attrCateNm;
	 } 
 	/**
	* Column Info
	* @param  invXchRt
	*/
	public void	setInvXchRt( String	invXchRt ) {
		this.invXchRt =	invXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRt
	 */
	 public	 String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	 String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt20
	*/
	public void	setGloAttrCtnt20( String	gloAttrCtnt20 ) {
		this.gloAttrCtnt20 =	gloAttrCtnt20;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt20
	 */
	 public	 String	getGloAttrCtnt20() {
		 return	this.gloAttrCtnt20;
	 } 
 	/**
	* Column Info
	* @param  payGrpLuCd
	*/
	public void	setPayGrpLuCd( String	payGrpLuCd ) {
		this.payGrpLuCd =	payGrpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payGrpLuCd
	 */
	 public	 String	getPayGrpLuCd() {
		 return	this.payGrpLuCd;
	 } 
 	/**
	* Column Info
	* @param  liabCoaAcctNo
	*/
	public void	setLiabCoaAcctNo( String	liabCoaAcctNo ) {
		this.liabCoaAcctNo =	liabCoaAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaAcctNo
	 */
	 public	 String	getLiabCoaAcctNo() {
		 return	this.liabCoaAcctNo;
	 } 
 	/**
	* Column Info
	* @param  invPayCurrCd
	*/
	public void	setInvPayCurrCd( String	invPayCurrCd ) {
		this.invPayCurrCd =	invPayCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invPayCurrCd
	 */
	 public	 String	getInvPayCurrCd() {
		 return	this.invPayCurrCd;
	 } 
 	/**
	* Column Info
	* @param  invXchDt
	*/
	public void	setInvXchDt( String	invXchDt ) {
		this.invXchDt =	invXchDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchDt
	 */
	 public	 String	getInvXchDt() {
		 return	this.invXchDt;
	 } 
 	/**
	* Column Info
	* @param  xterBankAcctSeq
	*/
	public void	setXterBankAcctSeq( String	xterBankAcctSeq ) {
		this.xterBankAcctSeq =	xterBankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterBankAcctSeq
	 */
	 public	 String	getXterBankAcctSeq() {
		 return	this.xterBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  invTermDt
	*/
	public void	setInvTermDt( String	invTermDt ) {
		this.invTermDt =	invTermDt;
	}
 
	/**
	 * Column Info
	 * @return	invTermDt
	 */
	 public	 String	getInvTermDt() {
		 return	this.invTermDt;
	 } 
 	/**
	* Column Info
	* @param  invTpLuCd
	*/
	public void	setInvTpLuCd( String	invTpLuCd ) {
		this.invTpLuCd =	invTpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	invTpLuCd
	 */
	 public	 String	getInvTpLuCd() {
		 return	this.invTpLuCd;
	 } 
 	/**
	* Column Info
	* @param  invIfStsCd
	*/
	public void	setInvIfStsCd( String	invIfStsCd ) {
		this.invIfStsCd =	invIfStsCd;
	}
 
	/**
	 * Column Info
	 * @return	invIfStsCd
	 */
	 public	 String	getInvIfStsCd() {
		 return	this.invIfStsCd;
	 } 
 	/**
	* Column Info
	* @param  invXchRtTpCd
	*/
	public void	setInvXchRtTpCd( String	invXchRtTpCd ) {
		this.invXchRtTpCd =	invXchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtTpCd
	 */
	 public	 String	getInvXchRtTpCd() {
		 return	this.invXchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  orgInvNo
	*/
	public void	setOrgInvNo( String	orgInvNo ) {
		this.orgInvNo =	orgInvNo;
	}
 
	/**
	 * Column Info
	 * @return	orgInvNo
	 */
	 public	 String	getOrgInvNo() {
		 return	this.orgInvNo;
	 } 
 	/**
	* Column Info
	* @param  invInclPpayFlg
	*/
	public void	setInvInclPpayFlg( String	invInclPpayFlg ) {
		this.invInclPpayFlg =	invInclPpayFlg;
	}
 
	/**
	 * Column Info
	 * @return	invInclPpayFlg
	 */
	 public	 String	getInvInclPpayFlg() {
		 return	this.invInclPpayFlg;
	 } 
 	/**
	* Column Info
	* @param  liabCoaCtrCd
	*/
	public void	setLiabCoaCtrCd( String	liabCoaCtrCd ) {
		this.liabCoaCtrCd =	liabCoaCtrCd;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaCtrCd
	 */
	 public	 String	getLiabCoaCtrCd() {
		 return	this.liabCoaCtrCd;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt19
	*/
	public void	setGloAttrCtnt19( String	gloAttrCtnt19 ) {
		this.gloAttrCtnt19 =	gloAttrCtnt19;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt19
	 */
	 public	 String	getGloAttrCtnt19() {
		 return	this.gloAttrCtnt19;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt17
	*/
	public void	setGloAttrCtnt17( String	gloAttrCtnt17 ) {
		this.gloAttrCtnt17 =	gloAttrCtnt17;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt17
	 */
	 public	 String	getGloAttrCtnt17() {
		 return	this.gloAttrCtnt17;
	 } 
 	/**
	* Column Info
	* @param  ppayInvNo
	*/
	public void	setPpayInvNo( String	ppayInvNo ) {
		this.ppayInvNo =	ppayInvNo;
	}
 
	/**
	 * Column Info
	 * @return	ppayInvNo
	 */
	 public	 String	getPpayInvNo() {
		 return	this.ppayInvNo;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt18
	*/
	public void	setGloAttrCtnt18( String	gloAttrCtnt18 ) {
		this.gloAttrCtnt18 =	gloAttrCtnt18;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt18
	 */
	 public	 String	getGloAttrCtnt18() {
		 return	this.gloAttrCtnt18;
	 } 
 	/**
	* Column Info
	* @param  invVatCd
	*/
	public void	setInvVatCd( String	invVatCd ) {
		this.invVatCd =	invVatCd;
	}
 
	/**
	 * Column Info
	 * @return	invVatCd
	 */
	 public	 String	getInvVatCd() {
		 return	this.invVatCd;
	 } 
 	/**
	* Column Info
	* @param  ifRqstSeq
	*/
	public void	setIfRqstSeq( String	ifRqstSeq ) {
		this.ifRqstSeq =	ifRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	ifRqstSeq
	 */
	 public	 String	getIfRqstSeq() {
		 return	this.ifRqstSeq;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt9
	*/
	public void	setAttrCtnt9( String	attrCtnt9 ) {
		this.attrCtnt9 =	attrCtnt9;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt9
	 */
	 public	 String	getAttrCtnt9() {
		 return	this.attrCtnt9;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt15
	*/
	public void	setGloAttrCtnt15( String	gloAttrCtnt15 ) {
		this.gloAttrCtnt15 =	gloAttrCtnt15;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt15
	 */
	 public	 String	getGloAttrCtnt15() {
		 return	this.gloAttrCtnt15;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt8
	*/
	public void	setAttrCtnt8( String	attrCtnt8 ) {
		this.attrCtnt8 =	attrCtnt8;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt8
	 */
	 public	 String	getAttrCtnt8() {
		 return	this.attrCtnt8;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt16
	*/
	public void	setGloAttrCtnt16( String	gloAttrCtnt16 ) {
		this.gloAttrCtnt16 =	gloAttrCtnt16;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt16
	 */
	 public	 String	getGloAttrCtnt16() {
		 return	this.gloAttrCtnt16;
	 } 
 	/**
	* Column Info
	* @param  invIfGrpSeq
	*/
	public void	setInvIfGrpSeq( String	invIfGrpSeq ) {
		this.invIfGrpSeq =	invIfGrpSeq;
	}
 
	/**
	 * Column Info
	 * @return	invIfGrpSeq
	 */
	 public	 String	getInvIfGrpSeq() {
		 return	this.invIfGrpSeq;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt13
	*/
	public void	setGloAttrCtnt13( String	gloAttrCtnt13 ) {
		this.gloAttrCtnt13 =	gloAttrCtnt13;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt13
	 */
	 public	 String	getGloAttrCtnt13() {
		 return	this.gloAttrCtnt13;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt14
	*/
	public void	setGloAttrCtnt14( String	gloAttrCtnt14 ) {
		this.gloAttrCtnt14 =	gloAttrCtnt14;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt14
	 */
	 public	 String	getGloAttrCtnt14() {
		 return	this.gloAttrCtnt14;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt11
	*/
	public void	setGloAttrCtnt11( String	gloAttrCtnt11 ) {
		this.gloAttrCtnt11 =	gloAttrCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt11
	 */
	 public	 String	getGloAttrCtnt11() {
		 return	this.gloAttrCtnt11;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt12
	*/
	public void	setGloAttrCtnt12( String	gloAttrCtnt12 ) {
		this.gloAttrCtnt12 =	gloAttrCtnt12;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt12
	 */
	 public	 String	getGloAttrCtnt12() {
		 return	this.gloAttrCtnt12;
	 } 
 	/**
	* Column Info
	* @param  ppayAplyAmt
	*/
	public void	setPpayAplyAmt( String	ppayAplyAmt ) {
		this.ppayAplyAmt =	ppayAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	ppayAplyAmt
	 */
	 public	 String	getPpayAplyAmt() {
		 return	this.ppayAplyAmt;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt10
	*/
	public void	setGloAttrCtnt10( String	gloAttrCtnt10 ) {
		this.gloAttrCtnt10 =	gloAttrCtnt10;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt10
	 */
	 public	 String	getGloAttrCtnt10() {
		 return	this.gloAttrCtnt10;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt1
	*/
	public void	setAttrCtnt1( String	attrCtnt1 ) {
		this.attrCtnt1 =	attrCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt1
	 */
	 public	 String	getAttrCtnt1() {
		 return	this.attrCtnt1;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt2
	*/
	public void	setAttrCtnt2( String	attrCtnt2 ) {
		this.attrCtnt2 =	attrCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt2
	 */
	 public	 String	getAttrCtnt2() {
		 return	this.attrCtnt2;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt3
	*/
	public void	setAttrCtnt3( String	attrCtnt3 ) {
		this.attrCtnt3 =	attrCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt3
	 */
	 public	 String	getAttrCtnt3() {
		 return	this.attrCtnt3;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt4
	*/
	public void	setAttrCtnt4( String	attrCtnt4 ) {
		this.attrCtnt4 =	attrCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt4
	 */
	 public	 String	getAttrCtnt4() {
		 return	this.attrCtnt4;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt5
	*/
	public void	setAttrCtnt5( String	attrCtnt5 ) {
		this.attrCtnt5 =	attrCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt5
	 */
	 public	 String	getAttrCtnt5() {
		 return	this.attrCtnt5;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt6
	*/
	public void	setAttrCtnt6( String	attrCtnt6 ) {
		this.attrCtnt6 =	attrCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt6
	 */
	 public	 String	getAttrCtnt6() {
		 return	this.attrCtnt6;
	 } 
 	/**
	* Column Info
	* @param  invIfFlg
	*/
	public void	setInvIfFlg( String	invIfFlg ) {
		this.invIfFlg =	invIfFlg;
	}
 
	/**
	 * Column Info
	 * @return	invIfFlg
	 */
	 public	 String	getInvIfFlg() {
		 return	this.invIfFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt7
	*/
	public void	setAttrCtnt7( String	attrCtnt7 ) {
		this.attrCtnt7 =	attrCtnt7;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt7
	 */
	 public	 String	getAttrCtnt7() {
		 return	this.attrCtnt7;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt2
	*/
	public void	setGloAttrCtnt2( String	gloAttrCtnt2 ) {
		this.gloAttrCtnt2 =	gloAttrCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt2
	 */
	 public	 String	getGloAttrCtnt2() {
		 return	this.gloAttrCtnt2;
	 } 
 	/**
	* Column Info
	* @param  ppayAplyGlDt
	*/
	public void	setPpayAplyGlDt( String	ppayAplyGlDt ) {
		this.ppayAplyGlDt =	ppayAplyGlDt;
	}
 
	/**
	 * Column Info
	 * @return	ppayAplyGlDt
	 */
	 public	 String	getPpayAplyGlDt() {
		 return	this.ppayAplyGlDt;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt3
	*/
	public void	setGloAttrCtnt3( String	gloAttrCtnt3 ) {
		this.gloAttrCtnt3 =	gloAttrCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt3
	 */
	 public	 String	getGloAttrCtnt3() {
		 return	this.gloAttrCtnt3;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt4
	*/
	public void	setGloAttrCtnt4( String	gloAttrCtnt4 ) {
		this.gloAttrCtnt4 =	gloAttrCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt4
	 */
	 public	 String	getGloAttrCtnt4() {
		 return	this.gloAttrCtnt4;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt5
	*/
	public void	setGloAttrCtnt5( String	gloAttrCtnt5 ) {
		this.gloAttrCtnt5 =	gloAttrCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt5
	 */
	 public	 String	getGloAttrCtnt5() {
		 return	this.gloAttrCtnt5;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt6
	*/
	public void	setGloAttrCtnt6( String	gloAttrCtnt6 ) {
		this.gloAttrCtnt6 =	gloAttrCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt6
	 */
	 public	 String	getGloAttrCtnt6() {
		 return	this.gloAttrCtnt6;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt7
	*/
	public void	setGloAttrCtnt7( String	gloAttrCtnt7 ) {
		this.gloAttrCtnt7 =	gloAttrCtnt7;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt7
	 */
	 public	 String	getGloAttrCtnt7() {
		 return	this.gloAttrCtnt7;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt8
	*/
	public void	setGloAttrCtnt8( String	gloAttrCtnt8 ) {
		this.gloAttrCtnt8 =	gloAttrCtnt8;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt8
	 */
	 public	 String	getGloAttrCtnt8() {
		 return	this.gloAttrCtnt8;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt9
	*/
	public void	setGloAttrCtnt9( String	gloAttrCtnt9 ) {
		this.gloAttrCtnt9 =	gloAttrCtnt9;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt9
	 */
	 public	 String	getGloAttrCtnt9() {
		 return	this.gloAttrCtnt9;
	 } 
 	/**
	* Column Info
	* @param  invVatAmt
	*/
	public void	setInvVatAmt( String	invVatAmt ) {
		this.invVatAmt =	invVatAmt;
	}
 
	/**
	 * Column Info
	 * @return	invVatAmt
	 */
	 public	 String	getInvVatAmt() {
		 return	this.invVatAmt;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCtnt1
	*/
	public void	setGloAttrCtnt1( String	gloAttrCtnt1 ) {
		this.gloAttrCtnt1 =	gloAttrCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCtnt1
	 */
	 public	 String	getGloAttrCtnt1() {
		 return	this.gloAttrCtnt1;
	 } 
 	/**
	* Column Info
	* @param  ifSrcNm
	*/
	public void	setIfSrcNm( String	ifSrcNm ) {
		this.ifSrcNm =	ifSrcNm;
	}
 
	/**
	 * Column Info
	 * @return	ifSrcNm
	 */
	 public	 String	getIfSrcNm() {
		 return	this.ifSrcNm;
	 } 
 	/**
	* Column Info
	* @param  ifRequestSeq
	*/
	public void	setIfRequestSeq( String	ifRequestSeq ) {
		this.ifRequestSeq =	ifRequestSeq;
	}
 
	/**
	 * Column Info
	 * @return	ifRequestSeq
	 */
	 public	 String	getIfRequestSeq() {
		 return	this.ifRequestSeq;
	 } 
 	/**
	* Column Info
	* @param  liabCoaCoCd
	*/
	public void	setLiabCoaCoCd( String	liabCoaCoCd ) {
		this.liabCoaCoCd =	liabCoaCoCd;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaCoCd
	 */
	 public	 String	getLiabCoaCoCd() {
		 return	this.liabCoaCoCd;
	 } 
 	/**
	* Column Info
	* @param  invIfSeq
	*/
	public void	setInvIfSeq( String	invIfSeq ) {
		this.invIfSeq =	invIfSeq;
	}
 
	/**
	 * Column Info
	 * @return	invIfSeq
	 */
	 public	 String	getInvIfSeq() {
		 return	this.invIfSeq;
	 } 
 	/**
	* Column Info
	* @param  gloAttrCateNm
	*/
	public void	setGloAttrCateNm( String	gloAttrCateNm ) {
		this.gloAttrCateNm =	gloAttrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	gloAttrCateNm
	 */
	 public	 String	getGloAttrCateNm() {
		 return	this.gloAttrCateNm;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  vchrNo
	*/
	public void	setVchrNo( String	vchrNo ) {
		this.vchrNo =	vchrNo;
	}
 
	/**
	 * Column Info
	 * @return	vchrNo
	 */
	 public	 String	getVchrNo() {
		 return	this.vchrNo;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  ppayInvLineNo
	*/
	public void	setPpayInvLineNo( String	ppayInvLineNo ) {
		this.ppayInvLineNo =	ppayInvLineNo;
	}
 
	/**
	 * Column Info
	 * @return	ppayInvLineNo
	 */
	 public	 String	getPpayInvLineNo() {
		 return	this.ppayInvLineNo;
	 } 
 	/**
	* Column Info
	* @param  liabCoaInterCoCd
	*/
	public void	setLiabCoaInterCoCd( String	liabCoaInterCoCd ) {
		this.liabCoaInterCoCd =	liabCoaInterCoCd;
	}
 
	/**
	 * Column Info
	 * @return	liabCoaInterCoCd
	 */
	 public	 String	getLiabCoaInterCoCd() {
		 return	this.liabCoaInterCoCd;
	 } 
 	/**
	* Column Info
	* @param  invTermNm
	*/
	public void	setInvTermNm( String	invTermNm ) {
		this.invTermNm =	invTermNm;
	}
 
	/**
	 * Column Info
	 * @return	invTermNm
	 */
	 public	 String	getInvTermNm() {
		 return	this.invTermNm;
	 } 
 	/**
	* Column Info
	* @param  functionalCurrency
	*/
	public void	setFunctionalCurrency( String	functionalCurrency ) {
		this.functionalCurrency =	functionalCurrency;
	}
 
	/**
	 * Column Info
	 * @return	functionalCurrency
	 */
	 public	 String	getFunctionalCurrency() {
		 return	this.functionalCurrency;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	 String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  functionalAmount
	*/
	public void	setFunctionalAmount( String	functionalAmount ) {
		this.functionalAmount =	functionalAmount;
	}
 
	/**
	 * Column Info
	 * @return	functionalAmount
	 */
	 public	 String	getFunctionalAmount() {
		 return	this.functionalAmount;
	 } 
 	/**
	* Column Info
	* @param  lAttributeCategory
	*/
	public void	setLAttributeCategory( String	lAttributeCategory ) {
		this.lAttributeCategory =	lAttributeCategory;
	}
 
	/**
	 * Column Info
	 * @return	lAttributeCategory
	 */
	 public	 String	getLAttributeCategory() {
		 return	this.lAttributeCategory;
	 } 
 	/**
	* Column Info
	* @param  vndrBankAcctSeq
	*/
	public void	setVndrBankAcctSeq( String	vndrBankAcctSeq ) {
		this.vndrBankAcctSeq =	vndrBankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrBankAcctSeq
	 */
	 public	 String	getVndrBankAcctSeq() {
		 return	this.vndrBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  vndrBankAcctPrioCd
	*/
	public void	setVndrBankAcctPrioCd( String	vndrBankAcctPrioCd ) {
		this.vndrBankAcctPrioCd =	vndrBankAcctPrioCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrBankAcctPrioCd
	 */
	 public	 String	getVndrBankAcctPrioCd() {
		 return	this.vndrBankAcctPrioCd;
	 } 
 	/**
	* Column Info
	* @param  vndrBankAcctVndrNo
	*/
	public void	setVndrBankAcctVndrNo( String	vndrBankAcctVndrNo ) {
		this.vndrBankAcctVndrNo =	vndrBankAcctVndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrBankAcctVndrNo
	 */
	 public	 String	getVndrBankAcctVndrNo() {
		 return	this.vndrBankAcctVndrNo;
	 } 
 	/**
	* Column Info
	* @param  creationUser
	*/
	public void	setCreationUser( String	creationUser ) {
		this.creationUser =	creationUser;
	}
 
	/**
	 * Column Info
	 * @return	creationUser
	 */
	 public	 String	getCreationUser() {
		 return	this.creationUser;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setApPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_mzd_lu_cd", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setApIfErrRsn(JSPUtil.getParameter(request,	prefix + "ap_if_err_rsn", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setCalcTaxImpFlg(JSPUtil.getParameter(request,	prefix + "calc_tax_imp_flg", ""));
		setInvRcvDt(JSPUtil.getParameter(request,	prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setLiabCoaVvdCd(JSPUtil.getParameter(request,	prefix + "liab_coa_vvd_cd", ""));
		setAproFlg(JSPUtil.getParameter(request,	prefix + "apro_flg", ""));
		setLiabCoaRgnCd(JSPUtil.getParameter(request,	prefix + "liab_coa_rgn_cd", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setGloAttrCtnt20(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt20", ""));
		setPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "pay_grp_lu_cd", ""));
		setLiabCoaAcctNo(JSPUtil.getParameter(request,	prefix + "liab_coa_acct_no", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request,	prefix + "inv_pay_curr_cd", ""));
		setInvXchDt(JSPUtil.getParameter(request,	prefix + "inv_xch_dt", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request,	prefix + "xter_bank_acct_seq", ""));
		setInvTermDt(JSPUtil.getParameter(request,	prefix + "inv_term_dt", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setInvIfStsCd(JSPUtil.getParameter(request,	prefix + "inv_if_sts_cd", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_tp_cd", ""));
		setOrgInvNo(JSPUtil.getParameter(request,	prefix + "org_inv_no", ""));
		setInvInclPpayFlg(JSPUtil.getParameter(request,	prefix + "inv_incl_ppay_flg", ""));
		setLiabCoaCtrCd(JSPUtil.getParameter(request,	prefix + "liab_coa_ctr_cd", ""));
		setGloAttrCtnt19(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt19", ""));
		setGloAttrCtnt17(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt17", ""));
		setPpayInvNo(JSPUtil.getParameter(request,	prefix + "ppay_inv_no", ""));
		setGloAttrCtnt18(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt18", ""));
		setInvVatCd(JSPUtil.getParameter(request,	prefix + "inv_vat_cd", ""));
		setIfRqstSeq(JSPUtil.getParameter(request,	prefix + "if_rqst_seq", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setGloAttrCtnt15(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt15", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setGloAttrCtnt16(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt16", ""));
		setInvIfGrpSeq(JSPUtil.getParameter(request,	prefix + "inv_if_grp_seq", ""));
		setGloAttrCtnt13(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt13", ""));
		setGloAttrCtnt14(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt14", ""));
		setGloAttrCtnt11(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt11", ""));
		setGloAttrCtnt12(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt12", ""));
		setPpayAplyAmt(JSPUtil.getParameter(request,	prefix + "ppay_aply_amt", ""));
		setGloAttrCtnt10(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt10", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setInvIfFlg(JSPUtil.getParameter(request,	prefix + "inv_if_flg", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setGloAttrCtnt2(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt2", ""));
		setPpayAplyGlDt(JSPUtil.getParameter(request,	prefix + "ppay_aply_gl_dt", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setGloAttrCtnt3(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt3", ""));
		setGloAttrCtnt4(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt4", ""));
		setGloAttrCtnt5(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt5", ""));
		setGloAttrCtnt6(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt6", ""));
		setGloAttrCtnt7(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt7", ""));
		setGloAttrCtnt8(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt8", ""));
		setGloAttrCtnt9(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt9", ""));
		setInvVatAmt(JSPUtil.getParameter(request,	prefix + "inv_vat_amt", ""));
		setGloAttrCtnt1(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt1", ""));
		setIfSrcNm(JSPUtil.getParameter(request,	prefix + "if_src_nm", ""));
		setIfRequestSeq(JSPUtil.getParameter(request,	prefix + "if_request_seq", ""));
		setLiabCoaCoCd(JSPUtil.getParameter(request,	prefix + "liab_coa_co_cd", ""));
		setInvIfSeq(JSPUtil.getParameter(request,	prefix + "inv_if_seq", ""));
		setGloAttrCateNm(JSPUtil.getParameter(request,	prefix + "glo_attr_cate_nm", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setVchrNo(JSPUtil.getParameter(request,	prefix + "vchr_no", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setPpayInvLineNo(JSPUtil.getParameter(request,	prefix + "ppay_inv_line_no", ""));
		setLiabCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "liab_coa_inter_co_cd", ""));
		setInvTermNm(JSPUtil.getParameter(request,	prefix + "inv_term_nm", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setFunctionalAmount(JSPUtil.getParameter(request,	prefix + "functional_amount", ""));
		setLAttributeCategory(JSPUtil.getParameter(request,	prefix + "l_attribute_category", ""));
		setVndrBankAcctSeq(JSPUtil.getParameter(request,	prefix + "vndr_bank_acct_seq", ""));
		setVndrBankAcctPrioCd(JSPUtil.getParameter(request,	prefix + "vndr_bank_acct_prio_cd", ""));
		setVndrBankAcctVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_bank_acct_vndr_no", ""));
		setCreationUser(JSPUtil.getParameter(request,	prefix + "creation_user", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SapInvoiceInterfaceHeaderVO[]
	 */
	public SapInvoiceInterfaceHeaderVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SapInvoiceInterfaceHeaderVO[]
	 */
	public SapInvoiceInterfaceHeaderVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SapInvoiceInterfaceHeaderVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] apPayMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_mzd_lu_cd".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] apIfErrRsn =	(JSPUtil.getParameter(request, prefix +	"ap_if_err_rsn".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] calcTaxImpFlg =	(JSPUtil.getParameter(request, prefix +	"calc_tax_imp_flg".trim(),	length));
				String[] invRcvDt =	(JSPUtil.getParameter(request, prefix +	"inv_rcv_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] liabCoaVvdCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_vvd_cd".trim(),	length));
				String[] aproFlg =	(JSPUtil.getParameter(request, prefix +	"apro_flg".trim(),	length));
				String[] liabCoaRgnCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_rgn_cd".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] gloAttrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt20".trim(),	length));
				String[] payGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_grp_lu_cd".trim(),	length));
				String[] liabCoaAcctNo =	(JSPUtil.getParameter(request, prefix +	"liab_coa_acct_no".trim(),	length));
				String[] invPayCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_pay_curr_cd".trim(),	length));
				String[] invXchDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_dt".trim(),	length));
				String[] xterBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"xter_bank_acct_seq".trim(),	length));
				String[] invTermDt =	(JSPUtil.getParameter(request, prefix +	"inv_term_dt".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] invIfStsCd =	(JSPUtil.getParameter(request, prefix +	"inv_if_sts_cd".trim(),	length));
				String[] invXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_tp_cd".trim(),	length));
				String[] orgInvNo =	(JSPUtil.getParameter(request, prefix +	"org_inv_no".trim(),	length));
				String[] invInclPpayFlg =	(JSPUtil.getParameter(request, prefix +	"inv_incl_ppay_flg".trim(),	length));
				String[] liabCoaCtrCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_ctr_cd".trim(),	length));
				String[] gloAttrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt19".trim(),	length));
				String[] gloAttrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt17".trim(),	length));
				String[] ppayInvNo =	(JSPUtil.getParameter(request, prefix +	"ppay_inv_no".trim(),	length));
				String[] gloAttrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt18".trim(),	length));
				String[] invVatCd =	(JSPUtil.getParameter(request, prefix +	"inv_vat_cd".trim(),	length));
				String[] ifRqstSeq =	(JSPUtil.getParameter(request, prefix +	"if_rqst_seq".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] gloAttrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt15".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt16".trim(),	length));
				String[] invIfGrpSeq =	(JSPUtil.getParameter(request, prefix +	"inv_if_grp_seq".trim(),	length));
				String[] gloAttrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt13".trim(),	length));
				String[] gloAttrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt14".trim(),	length));
				String[] gloAttrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt11".trim(),	length));
				String[] gloAttrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt12".trim(),	length));
				String[] ppayAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ppay_aply_amt".trim(),	length));
				String[] gloAttrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt10".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] invIfFlg =	(JSPUtil.getParameter(request, prefix +	"inv_if_flg".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt2".trim(),	length));
				String[] ppayAplyGlDt =	(JSPUtil.getParameter(request, prefix +	"ppay_aply_gl_dt".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] gloAttrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt3".trim(),	length));
				String[] gloAttrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt4".trim(),	length));
				String[] gloAttrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt5".trim(),	length));
				String[] gloAttrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt6".trim(),	length));
				String[] gloAttrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt9".trim(),	length));
				String[] invVatAmt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_amt".trim(),	length));
				String[] gloAttrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt1".trim(),	length));
				String[] ifSrcNm =	(JSPUtil.getParameter(request, prefix +	"if_src_nm".trim(),	length));
				String[] ifRequestSeq =	(JSPUtil.getParameter(request, prefix +	"if_request_seq".trim(),	length));
				String[] liabCoaCoCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_co_cd".trim(),	length));
				String[] invIfSeq =	(JSPUtil.getParameter(request, prefix +	"inv_if_seq".trim(),	length));
				String[] gloAttrCateNm =	(JSPUtil.getParameter(request, prefix +	"glo_attr_cate_nm".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] vchrNo =	(JSPUtil.getParameter(request, prefix +	"vchr_no".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ppayInvLineNo =	(JSPUtil.getParameter(request, prefix +	"ppay_inv_line_no".trim(),	length));
				String[] liabCoaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_inter_co_cd".trim(),	length));
				String[] invTermNm =	(JSPUtil.getParameter(request, prefix +	"inv_term_nm".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] functionalAmount =	(JSPUtil.getParameter(request, prefix +	"functional_amount".trim(),	length));
				String[] lAttributeCategory =	(JSPUtil.getParameter(request, prefix +	"l_attribute_category".trim(),	length));
				String[] vndrBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_bank_acct_seq".trim(),	length));
				String[] vndrBankAcctPrioCd =	(JSPUtil.getParameter(request, prefix +	"vndr_bank_acct_prio_cd".trim(),	length));
				String[] vndrBankAcctVndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_bank_acct_vndr_no".trim(),	length));
				String[] creationUser =	(JSPUtil.getParameter(request, prefix +	"creation_user".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SapInvoiceInterfaceHeaderVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( attrCtnt14[i] !=	null)
						model.setAttrCtnt14( attrCtnt14[i]);
						if ( apPayMzdLuCd[i] !=	null)
						model.setApPayMzdLuCd( apPayMzdLuCd[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( apIfErrRsn[i] !=	null)
						model.setApIfErrRsn( apIfErrRsn[i]);
						if ( attrCtnt12[i] !=	null)
						model.setAttrCtnt12( attrCtnt12[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
						if ( calcTaxImpFlg[i] !=	null)
						model.setCalcTaxImpFlg( calcTaxImpFlg[i]);
						if ( invRcvDt[i] !=	null)
						model.setInvRcvDt( invRcvDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( liabCoaVvdCd[i] !=	null)
						model.setLiabCoaVvdCd( liabCoaVvdCd[i]);
						if ( aproFlg[i] !=	null)
						model.setAproFlg( aproFlg[i]);
						if ( liabCoaRgnCd[i] !=	null)
						model.setLiabCoaRgnCd( liabCoaRgnCd[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( gloAttrCtnt20[i] !=	null)
						model.setGloAttrCtnt20( gloAttrCtnt20[i]);
						if ( payGrpLuCd[i] !=	null)
						model.setPayGrpLuCd( payGrpLuCd[i]);
						if ( liabCoaAcctNo[i] !=	null)
						model.setLiabCoaAcctNo( liabCoaAcctNo[i]);
						if ( invPayCurrCd[i] !=	null)
						model.setInvPayCurrCd( invPayCurrCd[i]);
						if ( invXchDt[i] !=	null)
						model.setInvXchDt( invXchDt[i]);
						if ( xterBankAcctSeq[i] !=	null)
						model.setXterBankAcctSeq( xterBankAcctSeq[i]);
						if ( invTermDt[i] !=	null)
						model.setInvTermDt( invTermDt[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( invIfStsCd[i] !=	null)
						model.setInvIfStsCd( invIfStsCd[i]);
						if ( invXchRtTpCd[i] !=	null)
						model.setInvXchRtTpCd( invXchRtTpCd[i]);
						if ( orgInvNo[i] !=	null)
						model.setOrgInvNo( orgInvNo[i]);
						if ( invInclPpayFlg[i] !=	null)
						model.setInvInclPpayFlg( invInclPpayFlg[i]);
						if ( liabCoaCtrCd[i] !=	null)
						model.setLiabCoaCtrCd( liabCoaCtrCd[i]);
						if ( gloAttrCtnt19[i] !=	null)
						model.setGloAttrCtnt19( gloAttrCtnt19[i]);
						if ( gloAttrCtnt17[i] !=	null)
						model.setGloAttrCtnt17( gloAttrCtnt17[i]);
						if ( ppayInvNo[i] !=	null)
						model.setPpayInvNo( ppayInvNo[i]);
						if ( gloAttrCtnt18[i] !=	null)
						model.setGloAttrCtnt18( gloAttrCtnt18[i]);
						if ( invVatCd[i] !=	null)
						model.setInvVatCd( invVatCd[i]);
						if ( ifRqstSeq[i] !=	null)
						model.setIfRqstSeq( ifRqstSeq[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( gloAttrCtnt15[i] !=	null)
						model.setGloAttrCtnt15( gloAttrCtnt15[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( gloAttrCtnt16[i] !=	null)
						model.setGloAttrCtnt16( gloAttrCtnt16[i]);
						if ( invIfGrpSeq[i] !=	null)
						model.setInvIfGrpSeq( invIfGrpSeq[i]);
						if ( gloAttrCtnt13[i] !=	null)
						model.setGloAttrCtnt13( gloAttrCtnt13[i]);
						if ( gloAttrCtnt14[i] !=	null)
						model.setGloAttrCtnt14( gloAttrCtnt14[i]);
						if ( gloAttrCtnt11[i] !=	null)
						model.setGloAttrCtnt11( gloAttrCtnt11[i]);
						if ( gloAttrCtnt12[i] !=	null)
						model.setGloAttrCtnt12( gloAttrCtnt12[i]);
						if ( ppayAplyAmt[i] !=	null)
						model.setPpayAplyAmt( ppayAplyAmt[i]);
						if ( gloAttrCtnt10[i] !=	null)
						model.setGloAttrCtnt10( gloAttrCtnt10[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( attrCtnt2[i] !=	null)
						model.setAttrCtnt2( attrCtnt2[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( invIfFlg[i] !=	null)
						model.setInvIfFlg( invIfFlg[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( gloAttrCtnt2[i] !=	null)
						model.setGloAttrCtnt2( gloAttrCtnt2[i]);
						if ( ppayAplyGlDt[i] !=	null)
						model.setPpayAplyGlDt( ppayAplyGlDt[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( gloAttrCtnt3[i] !=	null)
						model.setGloAttrCtnt3( gloAttrCtnt3[i]);
						if ( gloAttrCtnt4[i] !=	null)
						model.setGloAttrCtnt4( gloAttrCtnt4[i]);
						if ( gloAttrCtnt5[i] !=	null)
						model.setGloAttrCtnt5( gloAttrCtnt5[i]);
						if ( gloAttrCtnt6[i] !=	null)
						model.setGloAttrCtnt6( gloAttrCtnt6[i]);
						if ( gloAttrCtnt7[i] !=	null)
						model.setGloAttrCtnt7( gloAttrCtnt7[i]);
						if ( gloAttrCtnt8[i] !=	null)
						model.setGloAttrCtnt8( gloAttrCtnt8[i]);
						if ( gloAttrCtnt9[i] !=	null)
						model.setGloAttrCtnt9( gloAttrCtnt9[i]);
						if ( invVatAmt[i] !=	null)
						model.setInvVatAmt( invVatAmt[i]);
						if ( gloAttrCtnt1[i] !=	null)
						model.setGloAttrCtnt1( gloAttrCtnt1[i]);
						if ( ifSrcNm[i] !=	null)
						model.setIfSrcNm( ifSrcNm[i]);
						if ( ifRequestSeq[i] !=	null)
						model.setIfRequestSeq( ifRequestSeq[i]);
						if ( liabCoaCoCd[i] !=	null)
						model.setLiabCoaCoCd( liabCoaCoCd[i]);
						if ( invIfSeq[i] !=	null)
						model.setInvIfSeq( invIfSeq[i]);
						if ( gloAttrCateNm[i] !=	null)
						model.setGloAttrCateNm( gloAttrCateNm[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( vchrNo[i] !=	null)
						model.setVchrNo( vchrNo[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ppayInvLineNo[i] !=	null)
						model.setPpayInvLineNo( ppayInvLineNo[i]);
						if ( liabCoaInterCoCd[i] !=	null)
						model.setLiabCoaInterCoCd( liabCoaInterCoCd[i]);
						if ( invTermNm[i] !=	null)
						model.setInvTermNm( invTermNm[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( functionalAmount[i] !=	null)
						model.setFunctionalAmount( functionalAmount[i]);
						if ( lAttributeCategory[i] !=	null)
						model.setLAttributeCategory( lAttributeCategory[i]);
						if ( vndrBankAcctSeq[i] !=	null)
						model.setVndrBankAcctSeq( vndrBankAcctSeq[i]);
						if ( vndrBankAcctPrioCd[i] !=	null)
						model.setVndrBankAcctPrioCd( vndrBankAcctPrioCd[i]);
						if ( vndrBankAcctVndrNo[i] !=	null)
						model.setVndrBankAcctVndrNo( vndrBankAcctVndrNo[i]);
						if ( creationUser[i] !=	null)
						model.setCreationUser( creationUser[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSapInvoiceInterfaceHeaderVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SapInvoiceInterfaceHeaderVO[]
	 */
	public SapInvoiceInterfaceHeaderVO[]	 getSapInvoiceInterfaceHeaderVOs(){
		SapInvoiceInterfaceHeaderVO[] vos = (SapInvoiceInterfaceHeaderVO[])models.toArray(new	SapInvoiceInterfaceHeaderVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayMzdLuCd =	this.apPayMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apIfErrRsn =	this.apIfErrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTaxImpFlg =	this.calcTaxImpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt =	this.invRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaVvdCd =	this.liabCoaVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg =	this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaRgnCd =	this.liabCoaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt20 =	this.gloAttrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payGrpLuCd =	this.payGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaAcctNo =	this.liabCoaAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd =	this.invPayCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt =	this.invXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq =	this.xterBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt =	this.invTermDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfStsCd =	this.invIfStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd =	this.invXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo =	this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invInclPpayFlg =	this.invInclPpayFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaCtrCd =	this.liabCoaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt19 =	this.gloAttrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt17 =	this.gloAttrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayInvNo =	this.ppayInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt18 =	this.gloAttrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatCd =	this.invVatCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRqstSeq =	this.ifRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt15 =	this.gloAttrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt16 =	this.gloAttrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfGrpSeq =	this.invIfGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt13 =	this.gloAttrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt14 =	this.gloAttrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt11 =	this.gloAttrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt12 =	this.gloAttrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayAplyAmt =	this.ppayAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt10 =	this.gloAttrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg =	this.invIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt2 =	this.gloAttrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayAplyGlDt =	this.ppayAplyGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt3 =	this.gloAttrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt4 =	this.gloAttrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt5 =	this.gloAttrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt6 =	this.gloAttrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt7 =	this.gloAttrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt8 =	this.gloAttrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt9 =	this.gloAttrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt =	this.invVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt1 =	this.gloAttrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSrcNm =	this.ifSrcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRequestSeq =	this.ifRequestSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaCoCd =	this.liabCoaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfSeq =	this.invIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCateNm =	this.gloAttrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vchrNo =	this.vchrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayInvLineNo =	this.ppayInvLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaInterCoCd =	this.liabCoaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm =	this.invTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalAmount =	this.functionalAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lAttributeCategory =	this.lAttributeCategory.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrBankAcctSeq =	this.vndrBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrBankAcctPrioCd =	this.vndrBankAcctPrioCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrBankAcctVndrNo =	this.vndrBankAcctVndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationUser =	this.creationUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}