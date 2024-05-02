/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceEntryListVO.java
 *@FileTitle : InvoiceEntryListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.02  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvoiceEntryListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceEntryListVO>  models =	new	ArrayList<InvoiceEntryListVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 payStsFlg   =  null;
	/*	Column Info	*/
	private  String	 liabCoaVvdCd   =  null;
	/*	Column Info	*/
	private  String	 liabCoaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 periodChk   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 eryStlDt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt20   =  null;
	/*	Column Info	*/
	private  String	 liabCoaAcctNo   =  null;
	/*	Column Info	*/
	private  String	 invPayCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invXchDt   =  null;
	/*	Column Info	*/
	private  String	 xterBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 cntAcctgPstFlgY   =  null;
	/*	Column Info	*/
	private  String	 payCurrInvAmt   =  null;
	/*	Column Info	*/
	private  String	 apPayGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 chkFlg   =  null;
	/*	Column Info	*/
	private  String	 invCxlDt   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 invTermDt   =  null;
	/*	Column Info	*/
	private  String	 invTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 batSeq   =  null;
	/*	Column Info	*/
	private  String	 invXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 cxlUsrId   =  null;
	/*	Column Info	*/
	private  String	 liabCoaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt19   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt17   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt18   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 invVatCd   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt16   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 invCurrPrcs   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
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
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 invVatAmt   =  null;
	/*	Column Info	*/
	private  String	 invPayAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbSetSeq   =  null;
	/*	Column Info	*/
	private  String	 invAproRdyFlg   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 invCxlAmt   =  null;
	/*	Column Info	*/
	private  String	 invXchRtTpCdNm   =  null;
	/*	Column Info	*/
	private  String	 liabCoaCoCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apApstsCd   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 liabCoaInterCoCd   =  null;
	/*	Column Info	*/
	private  String	 invTermNm   =  null;
	/*	Column Info	*/
	private  String	 invFuncAmt   =  null;
	/*	Column Info	*/
	private  String	 approvalStatus   =  null;
	/*	Column Info	*/
	private  String	 prepayRmnTotAmt   =  null;
	/*	Column Info	*/
	private  String	 asaTransYn   =  null;
	/*	Column Info	*/
	private  String	 submitFlag   =  null;
	/*	Column Info	*/
	private  String	 bankAcctFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceEntryListVO(){}

	public InvoiceEntryListVO(String glDt,String attrCtnt10,String attrCtnt14,String attrCtnt13,String attrCtnt12,String attrCtnt11,String pagerows,String attrCtnt15,String vndrNo,String invDesc,String liabCdCmbSeq,String payStsFlg,String liabCoaVvdCd,String liabCoaRgnCd,String attrCateNm,String updUsrId,String invXchRt,String periodChk,String invDt,String eryStlDt,String gloAttrCtnt20,String liabCoaAcctNo,String invPayCurrCd,String invXchDt,String xterBankAcctSeq,String cntAcctgPstFlgY,String payCurrInvAmt,String apPayGrpLuCd,String creUsrId,String chkFlg,String invCxlDt,String payMzdLuCd,String invTermDt,String invTpLuCd,String batSeq,String invXchRtTpCd,String cxlUsrId,String liabCoaCtrCd,String gloAttrCtnt19,String gloAttrCtnt17,String gloAttrCtnt18,String vndrLglEngNm,String creDt,String gloAttrCtnt15,String invVatCd,String attrCtnt9,String gloAttrCtnt16,String attrCtnt8,String gloAttrCtnt13,String invSeq,String gloAttrCtnt14,String gloAttrCtnt11,String gloAttrCtnt12,String gloAttrCtnt10,String attrCtnt1,String ibflag,String attrCtnt2,String attrCtnt3,String attrCtnt4,String usrId,String attrCtnt5,String invCurrPrcs,String attrCtnt6,String attrCtnt7,String gloAttrCtnt2,String gloAttrCtnt3,String invAmt,String gloAttrCtnt4,String gloAttrCtnt5,String gloAttrCtnt6,String gloAttrCtnt7,String gloAttrCtnt8,String gloAttrCtnt9,String updDt,String invVatAmt,String invPayAmt,String dtrbSetSeq,String invAproRdyFlg,String gloAttrCtnt1,String invCxlAmt,String invXchRtTpCdNm,String liabCoaCoCd,String gloAttrCateNm,String invCurrCd,String invNo,String ofcCd,String apApstsCd,String apInvSrcCd,String liabCoaInterCoCd,String invTermNm,String invFuncAmt,String approvalStatus,String prepayRmnTotAmt,String asaTransYn,String submitFlag,String bankAcctFlg)	{
		this.glDt  = glDt ;
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.attrCtnt13  = attrCtnt13 ;
		this.attrCtnt12  = attrCtnt12 ;
		this.attrCtnt11  = attrCtnt11 ;
		this.pagerows  = pagerows ;
		this.attrCtnt15  = attrCtnt15 ;
		this.vndrNo  = vndrNo ;
		this.invDesc  = invDesc ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.payStsFlg  = payStsFlg ;
		this.liabCoaVvdCd  = liabCoaVvdCd ;
		this.liabCoaRgnCd  = liabCoaRgnCd ;
		this.attrCateNm  = attrCateNm ;
		this.updUsrId  = updUsrId ;
		this.invXchRt  = invXchRt ;
		this.periodChk  = periodChk ;
		this.invDt  = invDt ;
		this.eryStlDt  = eryStlDt ;
		this.gloAttrCtnt20  = gloAttrCtnt20 ;
		this.liabCoaAcctNo  = liabCoaAcctNo ;
		this.invPayCurrCd  = invPayCurrCd ;
		this.invXchDt  = invXchDt ;
		this.xterBankAcctSeq  = xterBankAcctSeq ;
		this.cntAcctgPstFlgY  = cntAcctgPstFlgY ;
		this.payCurrInvAmt  = payCurrInvAmt ;
		this.apPayGrpLuCd  = apPayGrpLuCd ;
		this.creUsrId  = creUsrId ;
		this.chkFlg  = chkFlg ;
		this.invCxlDt  = invCxlDt ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.invTermDt  = invTermDt ;
		this.invTpLuCd  = invTpLuCd ;
		this.batSeq  = batSeq ;
		this.invXchRtTpCd  = invXchRtTpCd ;
		this.cxlUsrId  = cxlUsrId ;
		this.liabCoaCtrCd  = liabCoaCtrCd ;
		this.gloAttrCtnt19  = gloAttrCtnt19 ;
		this.gloAttrCtnt17  = gloAttrCtnt17 ;
		this.gloAttrCtnt18  = gloAttrCtnt18 ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.creDt  = creDt ;
		this.gloAttrCtnt15  = gloAttrCtnt15 ;
		this.invVatCd  = invVatCd ;
		this.attrCtnt9  = attrCtnt9 ;
		this.gloAttrCtnt16  = gloAttrCtnt16 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.gloAttrCtnt13  = gloAttrCtnt13 ;
		this.invSeq  = invSeq ;
		this.gloAttrCtnt14  = gloAttrCtnt14 ;
		this.gloAttrCtnt11  = gloAttrCtnt11 ;
		this.gloAttrCtnt12  = gloAttrCtnt12 ;
		this.gloAttrCtnt10  = gloAttrCtnt10 ;
		this.attrCtnt1  = attrCtnt1 ;
		this.ibflag  = ibflag ;
		this.attrCtnt2  = attrCtnt2 ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.usrId  = usrId ;
		this.attrCtnt5  = attrCtnt5 ;
		this.invCurrPrcs  = invCurrPrcs ;
		this.attrCtnt6  = attrCtnt6 ;
		this.attrCtnt7  = attrCtnt7 ;
		this.gloAttrCtnt2  = gloAttrCtnt2 ;
		this.gloAttrCtnt3  = gloAttrCtnt3 ;
		this.invAmt  = invAmt ;
		this.gloAttrCtnt4  = gloAttrCtnt4 ;
		this.gloAttrCtnt5  = gloAttrCtnt5 ;
		this.gloAttrCtnt6  = gloAttrCtnt6 ;
		this.gloAttrCtnt7  = gloAttrCtnt7 ;
		this.gloAttrCtnt8  = gloAttrCtnt8 ;
		this.gloAttrCtnt9  = gloAttrCtnt9 ;
		this.updDt  = updDt ;
		this.invVatAmt  = invVatAmt ;
		this.invPayAmt  = invPayAmt ;
		this.dtrbSetSeq  = dtrbSetSeq ;
		this.invAproRdyFlg  = invAproRdyFlg ;
		this.gloAttrCtnt1  = gloAttrCtnt1 ;
		this.invCxlAmt  = invCxlAmt ;
		this.invXchRtTpCdNm  = invXchRtTpCdNm ;
		this.liabCoaCoCd  = liabCoaCoCd ;
		this.gloAttrCateNm  = gloAttrCateNm ;
		this.invCurrCd  = invCurrCd ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.apApstsCd  = apApstsCd ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.liabCoaInterCoCd  = liabCoaInterCoCd ;
		this.invTermNm  = invTermNm ;
		this.invFuncAmt  = invFuncAmt ;
		this.approvalStatus  = approvalStatus ;
		this.prepayRmnTotAmt  = prepayRmnTotAmt ;
		this.asaTransYn  = asaTransYn ;
		this.submitFlag  = submitFlag ;
		this.bankAcctFlg  = bankAcctFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());		
		this.hashColumns.put("liab_coa_vvd_cd", getLiabCoaVvdCd());		
		this.hashColumns.put("liab_coa_rgn_cd", getLiabCoaRgnCd());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("period_chk", getPeriodChk());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("ery_stl_dt", getEryStlDt());		
		this.hashColumns.put("glo_attr_ctnt20", getGloAttrCtnt20());		
		this.hashColumns.put("liab_coa_acct_no", getLiabCoaAcctNo());		
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());		
		this.hashColumns.put("inv_xch_dt", getInvXchDt());		
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());		
		this.hashColumns.put("cnt_acctg_pst_flg_y", getCntAcctgPstFlgY());		
		this.hashColumns.put("pay_curr_inv_amt", getPayCurrInvAmt());		
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("chk_flg", getChkFlg());		
		this.hashColumns.put("inv_cxl_dt", getInvCxlDt());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("inv_term_dt", getInvTermDt());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("bat_seq", getBatSeq());		
		this.hashColumns.put("inv_xch_rt_tp_cd", getInvXchRtTpCd());		
		this.hashColumns.put("cxl_usr_id", getCxlUsrId());		
		this.hashColumns.put("liab_coa_ctr_cd", getLiabCoaCtrCd());		
		this.hashColumns.put("glo_attr_ctnt19", getGloAttrCtnt19());		
		this.hashColumns.put("glo_attr_ctnt17", getGloAttrCtnt17());		
		this.hashColumns.put("glo_attr_ctnt18", getGloAttrCtnt18());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("glo_attr_ctnt15", getGloAttrCtnt15());		
		this.hashColumns.put("inv_vat_cd", getInvVatCd());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("glo_attr_ctnt16", getGloAttrCtnt16());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt13", getGloAttrCtnt13());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("glo_attr_ctnt14", getGloAttrCtnt14());		
		this.hashColumns.put("glo_attr_ctnt11", getGloAttrCtnt11());		
		this.hashColumns.put("glo_attr_ctnt12", getGloAttrCtnt12());		
		this.hashColumns.put("glo_attr_ctnt10", getGloAttrCtnt10());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("inv_curr_prcs", getInvCurrPrcs());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt2", getGloAttrCtnt2());		
		this.hashColumns.put("glo_attr_ctnt3", getGloAttrCtnt3());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("glo_attr_ctnt4", getGloAttrCtnt4());		
		this.hashColumns.put("glo_attr_ctnt5", getGloAttrCtnt5());		
		this.hashColumns.put("glo_attr_ctnt6", getGloAttrCtnt6());		
		this.hashColumns.put("glo_attr_ctnt7", getGloAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt8", getGloAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt9", getGloAttrCtnt9());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());		
		this.hashColumns.put("inv_pay_amt", getInvPayAmt());		
		this.hashColumns.put("dtrb_set_seq", getDtrbSetSeq());		
		this.hashColumns.put("inv_apro_rdy_flg", getInvAproRdyFlg());		
		this.hashColumns.put("glo_attr_ctnt1", getGloAttrCtnt1());		
		this.hashColumns.put("inv_cxl_amt", getInvCxlAmt());		
		this.hashColumns.put("inv_xch_rt_tp_cd_nm", getInvXchRtTpCdNm());		
		this.hashColumns.put("liab_coa_co_cd", getLiabCoaCoCd());		
		this.hashColumns.put("glo_attr_cate_nm", getGloAttrCateNm());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_apsts_cd", getApApstsCd());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("liab_coa_inter_co_cd", getLiabCoaInterCoCd());		
		this.hashColumns.put("inv_term_nm", getInvTermNm());		
		this.hashColumns.put("inv_func_amt", getInvFuncAmt());		
		this.hashColumns.put("approval_status", getApprovalStatus());		
		this.hashColumns.put("prepay_rmn_tot_amt", getPrepayRmnTotAmt());		
		this.hashColumns.put("asa_trans_yn", getAsaTransYn());		
		this.hashColumns.put("submit_flag", getSubmitFlag());		
		this.hashColumns.put("bank_acct_flg", getBankAcctFlg());		
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
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		this.hashFields.put("liab_coa_vvd_cd", "liabCoaVvdCd");
		this.hashFields.put("liab_coa_rgn_cd", "liabCoaRgnCd");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("period_chk", "periodChk");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("ery_stl_dt", "eryStlDt");
		this.hashFields.put("glo_attr_ctnt20", "gloAttrCtnt20");
		this.hashFields.put("liab_coa_acct_no", "liabCoaAcctNo");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("inv_xch_dt", "invXchDt");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("cnt_acctg_pst_flg_y", "cntAcctgPstFlgY");
		this.hashFields.put("pay_curr_inv_amt", "payCurrInvAmt");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("inv_cxl_dt", "invCxlDt");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("inv_term_dt", "invTermDt");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("bat_seq", "batSeq");
		this.hashFields.put("inv_xch_rt_tp_cd", "invXchRtTpCd");
		this.hashFields.put("cxl_usr_id", "cxlUsrId");
		this.hashFields.put("liab_coa_ctr_cd", "liabCoaCtrCd");
		this.hashFields.put("glo_attr_ctnt19", "gloAttrCtnt19");
		this.hashFields.put("glo_attr_ctnt17", "gloAttrCtnt17");
		this.hashFields.put("glo_attr_ctnt18", "gloAttrCtnt18");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("glo_attr_ctnt15", "gloAttrCtnt15");
		this.hashFields.put("inv_vat_cd", "invVatCd");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("glo_attr_ctnt16", "gloAttrCtnt16");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("glo_attr_ctnt13", "gloAttrCtnt13");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("glo_attr_ctnt14", "gloAttrCtnt14");
		this.hashFields.put("glo_attr_ctnt11", "gloAttrCtnt11");
		this.hashFields.put("glo_attr_ctnt12", "gloAttrCtnt12");
		this.hashFields.put("glo_attr_ctnt10", "gloAttrCtnt10");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("inv_curr_prcs", "invCurrPrcs");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("glo_attr_ctnt2", "gloAttrCtnt2");
		this.hashFields.put("glo_attr_ctnt3", "gloAttrCtnt3");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("glo_attr_ctnt4", "gloAttrCtnt4");
		this.hashFields.put("glo_attr_ctnt5", "gloAttrCtnt5");
		this.hashFields.put("glo_attr_ctnt6", "gloAttrCtnt6");
		this.hashFields.put("glo_attr_ctnt7", "gloAttrCtnt7");
		this.hashFields.put("glo_attr_ctnt8", "gloAttrCtnt8");
		this.hashFields.put("glo_attr_ctnt9", "gloAttrCtnt9");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("inv_pay_amt", "invPayAmt");
		this.hashFields.put("dtrb_set_seq", "dtrbSetSeq");
		this.hashFields.put("inv_apro_rdy_flg", "invAproRdyFlg");
		this.hashFields.put("glo_attr_ctnt1", "gloAttrCtnt1");
		this.hashFields.put("inv_cxl_amt", "invCxlAmt");
		this.hashFields.put("inv_xch_rt_tp_cd_nm", "invXchRtTpCdNm");
		this.hashFields.put("liab_coa_co_cd", "liabCoaCoCd");
		this.hashFields.put("glo_attr_cate_nm", "gloAttrCateNm");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_apsts_cd", "apApstsCd");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("liab_coa_inter_co_cd", "liabCoaInterCoCd");
		this.hashFields.put("inv_term_nm", "invTermNm");
		this.hashFields.put("inv_func_amt", "invFuncAmt");
		this.hashFields.put("approval_status", "approvalStatus");
		this.hashFields.put("prepay_rmn_tot_amt", "prepayRmnTotAmt");
		this.hashFields.put("asa_trans_yn", "asaTransYn");
		this.hashFields.put("submit_flag", "submitFlag");
		this.hashFields.put("bank_acct_flg", "bankAcctFlg");
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
	 public	String	getGlDt() {
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
	 public	String	getAttrCtnt10() {
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
	 public	String	getAttrCtnt14() {
		 return	this.attrCtnt14;
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
	 public	String	getAttrCtnt13() {
		 return	this.attrCtnt13;
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
	 public	String	getAttrCtnt12() {
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
	 public	String	getAttrCtnt11() {
		 return	this.attrCtnt11;
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
	 public	String	getPagerows() {
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
	 public	String	getAttrCtnt15() {
		 return	this.attrCtnt15;
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
	 public	String	getVndrNo() {
		 return	this.vndrNo;
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
	 public	String	getInvDesc() {
		 return	this.invDesc;
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
	 public	String	getLiabCdCmbSeq() {
		 return	this.liabCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  payStsFlg
	*/
	public void	setPayStsFlg( String	payStsFlg ) {
		this.payStsFlg =	payStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	payStsFlg
	 */
	 public	String	getPayStsFlg() {
		 return	this.payStsFlg;
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
	 public	String	getLiabCoaVvdCd() {
		 return	this.liabCoaVvdCd;
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
	 public	String	getLiabCoaRgnCd() {
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
	 public	String	getAttrCateNm() {
		 return	this.attrCateNm;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
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
	 public	String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  periodChk
	*/
	public void	setPeriodChk( String	periodChk ) {
		this.periodChk =	periodChk;
	}
 
	/**
	 * Column Info
	 * @return	periodChk
	 */
	 public	String	getPeriodChk() {
		 return	this.periodChk;
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
	 public	String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  eryStlDt
	*/
	public void	setEryStlDt( String	eryStlDt ) {
		this.eryStlDt =	eryStlDt;
	}
 
	/**
	 * Column Info
	 * @return	eryStlDt
	 */
	 public	String	getEryStlDt() {
		 return	this.eryStlDt;
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
	 public	String	getGloAttrCtnt20() {
		 return	this.gloAttrCtnt20;
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
	 public	String	getLiabCoaAcctNo() {
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
	 public	String	getInvPayCurrCd() {
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
	 public	String	getInvXchDt() {
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
	 public	String	getXterBankAcctSeq() {
		 return	this.xterBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  cntAcctgPstFlgY
	*/
	public void	setCntAcctgPstFlgY( String	cntAcctgPstFlgY ) {
		this.cntAcctgPstFlgY =	cntAcctgPstFlgY;
	}
 
	/**
	 * Column Info
	 * @return	cntAcctgPstFlgY
	 */
	 public	String	getCntAcctgPstFlgY() {
		 return	this.cntAcctgPstFlgY;
	 } 
 	/**
	* Column Info
	* @param  payCurrInvAmt
	*/
	public void	setPayCurrInvAmt( String	payCurrInvAmt ) {
		this.payCurrInvAmt =	payCurrInvAmt;
	}
 
	/**
	 * Column Info
	 * @return	payCurrInvAmt
	 */
	 public	String	getPayCurrInvAmt() {
		 return	this.payCurrInvAmt;
	 } 
 	/**
	* Column Info
	* @param  apPayGrpLuCd
	*/
	public void	setApPayGrpLuCd( String	apPayGrpLuCd ) {
		this.apPayGrpLuCd =	apPayGrpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	apPayGrpLuCd
	 */
	 public	String	getApPayGrpLuCd() {
		 return	this.apPayGrpLuCd;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  chkFlg
	*/
	public void	setChkFlg( String	chkFlg ) {
		this.chkFlg =	chkFlg;
	}
 
	/**
	 * Column Info
	 * @return	chkFlg
	 */
	 public	String	getChkFlg() {
		 return	this.chkFlg;
	 } 
 	/**
	* Column Info
	* @param  invCxlDt
	*/
	public void	setInvCxlDt( String	invCxlDt ) {
		this.invCxlDt =	invCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	invCxlDt
	 */
	 public	String	getInvCxlDt() {
		 return	this.invCxlDt;
	 } 
 	/**
	* Column Info
	* @param  payMzdLuCd
	*/
	public void	setPayMzdLuCd( String	payMzdLuCd ) {
		this.payMzdLuCd =	payMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payMzdLuCd
	 */
	 public	String	getPayMzdLuCd() {
		 return	this.payMzdLuCd;
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
	 public	String	getInvTermDt() {
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
	 public	String	getInvTpLuCd() {
		 return	this.invTpLuCd;
	 } 
 	/**
	* Column Info
	* @param  batSeq
	*/
	public void	setBatSeq( String	batSeq ) {
		this.batSeq =	batSeq;
	}
 
	/**
	 * Column Info
	 * @return	batSeq
	 */
	 public	String	getBatSeq() {
		 return	this.batSeq;
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
	 public	String	getInvXchRtTpCd() {
		 return	this.invXchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  cxlUsrId
	*/
	public void	setCxlUsrId( String	cxlUsrId ) {
		this.cxlUsrId =	cxlUsrId;
	}
 
	/**
	 * Column Info
	 * @return	cxlUsrId
	 */
	 public	String	getCxlUsrId() {
		 return	this.cxlUsrId;
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
	 public	String	getLiabCoaCtrCd() {
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
	 public	String	getGloAttrCtnt19() {
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
	 public	String	getGloAttrCtnt17() {
		 return	this.gloAttrCtnt17;
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
	 public	String	getGloAttrCtnt18() {
		 return	this.gloAttrCtnt18;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	String	getCreDt() {
		 return	this.creDt;
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
	 public	String	getGloAttrCtnt15() {
		 return	this.gloAttrCtnt15;
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
	 public	String	getInvVatCd() {
		 return	this.invVatCd;
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
	 public	String	getAttrCtnt9() {
		 return	this.attrCtnt9;
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
	 public	String	getGloAttrCtnt16() {
		 return	this.gloAttrCtnt16;
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
	 public	String	getAttrCtnt8() {
		 return	this.attrCtnt8;
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
	 public	String	getGloAttrCtnt13() {
		 return	this.gloAttrCtnt13;
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
	 public	String	getInvSeq() {
		 return	this.invSeq;
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
	 public	String	getGloAttrCtnt14() {
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
	 public	String	getGloAttrCtnt11() {
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
	 public	String	getGloAttrCtnt12() {
		 return	this.gloAttrCtnt12;
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
	 public	String	getGloAttrCtnt10() {
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
	 public	String	getAttrCtnt1() {
		 return	this.attrCtnt1;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
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
	 public	String	getAttrCtnt2() {
		 return	this.attrCtnt2;
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
	 public	String	getAttrCtnt3() {
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
	 public	String	getAttrCtnt4() {
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
	 public	String	getUsrId() {
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
	 public	String	getAttrCtnt5() {
		 return	this.attrCtnt5;
	 } 
 	/**
	* Column Info
	* @param  invCurrPrcs
	*/
	public void	setInvCurrPrcs( String	invCurrPrcs ) {
		this.invCurrPrcs =	invCurrPrcs;
	}
 
	/**
	 * Column Info
	 * @return	invCurrPrcs
	 */
	 public	String	getInvCurrPrcs() {
		 return	this.invCurrPrcs;
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
	 public	String	getAttrCtnt6() {
		 return	this.attrCtnt6;
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
	 public	String	getAttrCtnt7() {
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
	 public	String	getGloAttrCtnt2() {
		 return	this.gloAttrCtnt2;
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
	 public	String	getGloAttrCtnt3() {
		 return	this.gloAttrCtnt3;
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
	 public	String	getInvAmt() {
		 return	this.invAmt;
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
	 public	String	getGloAttrCtnt4() {
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
	 public	String	getGloAttrCtnt5() {
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
	 public	String	getGloAttrCtnt6() {
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
	 public	String	getGloAttrCtnt7() {
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
	 public	String	getGloAttrCtnt8() {
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
	 public	String	getGloAttrCtnt9() {
		 return	this.gloAttrCtnt9;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	String	getUpdDt() {
		 return	this.updDt;
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
	 public	String	getInvVatAmt() {
		 return	this.invVatAmt;
	 } 
 	/**
	* Column Info
	* @param  invPayAmt
	*/
	public void	setInvPayAmt( String	invPayAmt ) {
		this.invPayAmt =	invPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	invPayAmt
	 */
	 public	String	getInvPayAmt() {
		 return	this.invPayAmt;
	 } 
 	/**
	* Column Info
	* @param  dtrbSetSeq
	*/
	public void	setDtrbSetSeq( String	dtrbSetSeq ) {
		this.dtrbSetSeq =	dtrbSetSeq;
	}
 
	/**
	 * Column Info
	 * @return	dtrbSetSeq
	 */
	 public	String	getDtrbSetSeq() {
		 return	this.dtrbSetSeq;
	 } 
 	/**
	* Column Info
	* @param  invAproRdyFlg
	*/
	public void	setInvAproRdyFlg( String	invAproRdyFlg ) {
		this.invAproRdyFlg =	invAproRdyFlg;
	}
 
	/**
	 * Column Info
	 * @return	invAproRdyFlg
	 */
	 public	String	getInvAproRdyFlg() {
		 return	this.invAproRdyFlg;
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
	 public	String	getGloAttrCtnt1() {
		 return	this.gloAttrCtnt1;
	 } 
 	/**
	* Column Info
	* @param  invCxlAmt
	*/
	public void	setInvCxlAmt( String	invCxlAmt ) {
		this.invCxlAmt =	invCxlAmt;
	}
 
	/**
	 * Column Info
	 * @return	invCxlAmt
	 */
	 public	String	getInvCxlAmt() {
		 return	this.invCxlAmt;
	 } 
 	/**
	* Column Info
	* @param  invXchRtTpCdNm
	*/
	public void	setInvXchRtTpCdNm( String	invXchRtTpCdNm ) {
		this.invXchRtTpCdNm =	invXchRtTpCdNm;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtTpCdNm
	 */
	 public	String	getInvXchRtTpCdNm() {
		 return	this.invXchRtTpCdNm;
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
	 public	String	getLiabCoaCoCd() {
		 return	this.liabCoaCoCd;
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
	 public	String	getGloAttrCateNm() {
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
	 public	String	getInvCurrCd() {
		 return	this.invCurrCd;
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
	 public	String	getInvNo() {
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
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  apApstsCd
	*/
	public void	setApApstsCd( String	apApstsCd ) {
		this.apApstsCd =	apApstsCd;
	}
 
	/**
	 * Column Info
	 * @return	apApstsCd
	 */
	 public	String	getApApstsCd() {
		 return	this.apApstsCd;
	 } 
 	/**
	* Column Info
	* @param  apInvSrcCd
	*/
	public void	setApInvSrcCd( String	apInvSrcCd ) {
		this.apInvSrcCd =	apInvSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	apInvSrcCd
	 */
	 public	String	getApInvSrcCd() {
		 return	this.apInvSrcCd;
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
	 public	String	getLiabCoaInterCoCd() {
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
	 public	String	getInvTermNm() {
		 return	this.invTermNm;
	 } 
 	/**
	* Column Info
	* @param  invFuncAmt
	*/
	public void	setInvFuncAmt( String	invFuncAmt ) {
		this.invFuncAmt =	invFuncAmt;
	}
 
	/**
	 * Column Info
	 * @return	invFuncAmt
	 */
	 public	String	getInvFuncAmt() {
		 return	this.invFuncAmt;
	 } 
 	/**
	* Column Info
	* @param  approvalStatus
	*/
	public void	setApprovalStatus( String	approvalStatus ) {
		this.approvalStatus =	approvalStatus;
	}
 
	/**
	 * Column Info
	 * @return	approvalStatus
	 */
	 public	String	getApprovalStatus() {
		 return	this.approvalStatus;
	 } 
 	/**
	* Column Info
	* @param  prepayRmnTotAmt
	*/
	public void	setPrepayRmnTotAmt( String	prepayRmnTotAmt ) {
		this.prepayRmnTotAmt =	prepayRmnTotAmt;
	}
 
	/**
	 * Column Info
	 * @return	prepayRmnTotAmt
	 */
	 public	String	getPrepayRmnTotAmt() {
		 return	this.prepayRmnTotAmt;
	 } 
 	/**
	* Column Info
	* @param  asaTransYn
	*/
	public void	setAsaTransYn( String	asaTransYn ) {
		this.asaTransYn =	asaTransYn;
	}
 
	/**
	 * Column Info
	 * @return	asaTransYn
	 */
	 public	String	getAsaTransYn() {
		 return	this.asaTransYn;
	 } 
 	/**
	* Column Info
	* @param  submitFlag
	*/
	public void	setSubmitFlag( String	submitFlag ) {
		this.submitFlag =	submitFlag;
	}
 
	/**
	 * Column Info
	 * @return	submitFlag
	 */
	 public	String	getSubmitFlag() {
		 return	this.submitFlag;
	 } 
 	/**
	* Column Info
	* @param  bankAcctFlg
	*/
	public void	setBankAcctFlg( String	bankAcctFlg ) {
		this.bankAcctFlg =	bankAcctFlg;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctFlg
	 */
	 public	String	getBankAcctFlg() {
		 return	this.bankAcctFlg;
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
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setPayStsFlg(JSPUtil.getParameter(request,	prefix + "pay_sts_flg", ""));
		setLiabCoaVvdCd(JSPUtil.getParameter(request,	prefix + "liab_coa_vvd_cd", ""));
		setLiabCoaRgnCd(JSPUtil.getParameter(request,	prefix + "liab_coa_rgn_cd", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setPeriodChk(JSPUtil.getParameter(request,	prefix + "period_chk", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setEryStlDt(JSPUtil.getParameter(request,	prefix + "ery_stl_dt", ""));
		setGloAttrCtnt20(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt20", ""));
		setLiabCoaAcctNo(JSPUtil.getParameter(request,	prefix + "liab_coa_acct_no", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request,	prefix + "inv_pay_curr_cd", ""));
		setInvXchDt(JSPUtil.getParameter(request,	prefix + "inv_xch_dt", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request,	prefix + "xter_bank_acct_seq", ""));
		setCntAcctgPstFlgY(JSPUtil.getParameter(request,	prefix + "cnt_acctg_pst_flg_y", ""));
		setPayCurrInvAmt(JSPUtil.getParameter(request,	prefix + "pay_curr_inv_amt", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_grp_lu_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setChkFlg(JSPUtil.getParameter(request,	prefix + "chk_flg", ""));
		setInvCxlDt(JSPUtil.getParameter(request,	prefix + "inv_cxl_dt", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setInvTermDt(JSPUtil.getParameter(request,	prefix + "inv_term_dt", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setBatSeq(JSPUtil.getParameter(request,	prefix + "bat_seq", ""));
		setInvXchRtTpCd(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_tp_cd", ""));
		setCxlUsrId(JSPUtil.getParameter(request,	prefix + "cxl_usr_id", ""));
		setLiabCoaCtrCd(JSPUtil.getParameter(request,	prefix + "liab_coa_ctr_cd", ""));
		setGloAttrCtnt19(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt19", ""));
		setGloAttrCtnt17(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt17", ""));
		setGloAttrCtnt18(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt18", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setGloAttrCtnt15(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt15", ""));
		setInvVatCd(JSPUtil.getParameter(request,	prefix + "inv_vat_cd", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setGloAttrCtnt16(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt16", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setGloAttrCtnt13(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt13", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setGloAttrCtnt14(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt14", ""));
		setGloAttrCtnt11(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt11", ""));
		setGloAttrCtnt12(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt12", ""));
		setGloAttrCtnt10(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt10", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setInvCurrPrcs(JSPUtil.getParameter(request,	prefix + "inv_curr_prcs", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setGloAttrCtnt2(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt2", ""));
		setGloAttrCtnt3(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt3", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setGloAttrCtnt4(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt4", ""));
		setGloAttrCtnt5(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt5", ""));
		setGloAttrCtnt6(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt6", ""));
		setGloAttrCtnt7(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt7", ""));
		setGloAttrCtnt8(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt8", ""));
		setGloAttrCtnt9(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt9", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setInvVatAmt(JSPUtil.getParameter(request,	prefix + "inv_vat_amt", ""));
		setInvPayAmt(JSPUtil.getParameter(request,	prefix + "inv_pay_amt", ""));
		setDtrbSetSeq(JSPUtil.getParameter(request,	prefix + "dtrb_set_seq", ""));
		setInvAproRdyFlg(JSPUtil.getParameter(request,	prefix + "inv_apro_rdy_flg", ""));
		setGloAttrCtnt1(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt1", ""));
		setInvCxlAmt(JSPUtil.getParameter(request,	prefix + "inv_cxl_amt", ""));
		setInvXchRtTpCdNm(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_tp_cd_nm", ""));
		setLiabCoaCoCd(JSPUtil.getParameter(request,	prefix + "liab_coa_co_cd", ""));
		setGloAttrCateNm(JSPUtil.getParameter(request,	prefix + "glo_attr_cate_nm", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApApstsCd(JSPUtil.getParameter(request,	prefix + "ap_apsts_cd", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setLiabCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "liab_coa_inter_co_cd", ""));
		setInvTermNm(JSPUtil.getParameter(request,	prefix + "inv_term_nm", ""));
		setInvFuncAmt(JSPUtil.getParameter(request,	prefix + "inv_func_amt", ""));
		setApprovalStatus(JSPUtil.getParameter(request,	prefix + "approval_status", ""));
		setPrepayRmnTotAmt(JSPUtil.getParameter(request,	prefix + "prepay_rmn_tot_amt", ""));
		setAsaTransYn(JSPUtil.getParameter(request,	prefix + "asa_trans_yn", ""));
		setSubmitFlag(JSPUtil.getParameter(request,	prefix + "submit_flag", ""));
		setBankAcctFlg(JSPUtil.getParameter(request,	prefix + "bank_acct_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceEntryListVO[]
	 */
	public InvoiceEntryListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceEntryListVO[]
	 */
	public InvoiceEntryListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceEntryListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] payStsFlg =	(JSPUtil.getParameter(request, prefix +	"pay_sts_flg".trim(),	length));
				String[] liabCoaVvdCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_vvd_cd".trim(),	length));
				String[] liabCoaRgnCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_rgn_cd".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] periodChk =	(JSPUtil.getParameter(request, prefix +	"period_chk".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] eryStlDt =	(JSPUtil.getParameter(request, prefix +	"ery_stl_dt".trim(),	length));
				String[] gloAttrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt20".trim(),	length));
				String[] liabCoaAcctNo =	(JSPUtil.getParameter(request, prefix +	"liab_coa_acct_no".trim(),	length));
				String[] invPayCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_pay_curr_cd".trim(),	length));
				String[] invXchDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_dt".trim(),	length));
				String[] xterBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"xter_bank_acct_seq".trim(),	length));
				String[] cntAcctgPstFlgY =	(JSPUtil.getParameter(request, prefix +	"cnt_acctg_pst_flg_y".trim(),	length));
				String[] payCurrInvAmt =	(JSPUtil.getParameter(request, prefix +	"pay_curr_inv_amt".trim(),	length));
				String[] apPayGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_grp_lu_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] chkFlg =	(JSPUtil.getParameter(request, prefix +	"chk_flg".trim(),	length));
				String[] invCxlDt =	(JSPUtil.getParameter(request, prefix +	"inv_cxl_dt".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] invTermDt =	(JSPUtil.getParameter(request, prefix +	"inv_term_dt".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] batSeq =	(JSPUtil.getParameter(request, prefix +	"bat_seq".trim(),	length));
				String[] invXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_tp_cd".trim(),	length));
				String[] cxlUsrId =	(JSPUtil.getParameter(request, prefix +	"cxl_usr_id".trim(),	length));
				String[] liabCoaCtrCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_ctr_cd".trim(),	length));
				String[] gloAttrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt19".trim(),	length));
				String[] gloAttrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt17".trim(),	length));
				String[] gloAttrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt18".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] gloAttrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt15".trim(),	length));
				String[] invVatCd =	(JSPUtil.getParameter(request, prefix +	"inv_vat_cd".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] gloAttrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt16".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt13".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] gloAttrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt14".trim(),	length));
				String[] gloAttrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt11".trim(),	length));
				String[] gloAttrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt12".trim(),	length));
				String[] gloAttrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt10".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] invCurrPrcs =	(JSPUtil.getParameter(request, prefix +	"inv_curr_prcs".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt2".trim(),	length));
				String[] gloAttrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt3".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] gloAttrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt4".trim(),	length));
				String[] gloAttrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt5".trim(),	length));
				String[] gloAttrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt6".trim(),	length));
				String[] gloAttrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt9".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] invVatAmt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_amt".trim(),	length));
				String[] invPayAmt =	(JSPUtil.getParameter(request, prefix +	"inv_pay_amt".trim(),	length));
				String[] dtrbSetSeq =	(JSPUtil.getParameter(request, prefix +	"dtrb_set_seq".trim(),	length));
				String[] invAproRdyFlg =	(JSPUtil.getParameter(request, prefix +	"inv_apro_rdy_flg".trim(),	length));
				String[] gloAttrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt1".trim(),	length));
				String[] invCxlAmt =	(JSPUtil.getParameter(request, prefix +	"inv_cxl_amt".trim(),	length));
				String[] invXchRtTpCdNm =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_tp_cd_nm".trim(),	length));
				String[] liabCoaCoCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_co_cd".trim(),	length));
				String[] gloAttrCateNm =	(JSPUtil.getParameter(request, prefix +	"glo_attr_cate_nm".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apApstsCd =	(JSPUtil.getParameter(request, prefix +	"ap_apsts_cd".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] liabCoaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"liab_coa_inter_co_cd".trim(),	length));
				String[] invTermNm =	(JSPUtil.getParameter(request, prefix +	"inv_term_nm".trim(),	length));
				String[] invFuncAmt =	(JSPUtil.getParameter(request, prefix +	"inv_func_amt".trim(),	length));
				String[] approvalStatus =	(JSPUtil.getParameter(request, prefix +	"approval_status".trim(),	length));
				String[] prepayRmnTotAmt =	(JSPUtil.getParameter(request, prefix +	"prepay_rmn_tot_amt".trim(),	length));
				String[] asaTransYn =	(JSPUtil.getParameter(request, prefix +	"asa_trans_yn".trim(),	length));
				String[] submitFlag =	(JSPUtil.getParameter(request, prefix +	"submit_flag".trim(),	length));
				String[] bankAcctFlg =	(JSPUtil.getParameter(request, prefix +	"bank_acct_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceEntryListVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( attrCtnt14[i] !=	null)
						model.setAttrCtnt14( attrCtnt14[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( attrCtnt12[i] !=	null)
						model.setAttrCtnt12( attrCtnt12[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( payStsFlg[i] !=	null)
						model.setPayStsFlg( payStsFlg[i]);
						if ( liabCoaVvdCd[i] !=	null)
						model.setLiabCoaVvdCd( liabCoaVvdCd[i]);
						if ( liabCoaRgnCd[i] !=	null)
						model.setLiabCoaRgnCd( liabCoaRgnCd[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( periodChk[i] !=	null)
						model.setPeriodChk( periodChk[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( eryStlDt[i] !=	null)
						model.setEryStlDt( eryStlDt[i]);
						if ( gloAttrCtnt20[i] !=	null)
						model.setGloAttrCtnt20( gloAttrCtnt20[i]);
						if ( liabCoaAcctNo[i] !=	null)
						model.setLiabCoaAcctNo( liabCoaAcctNo[i]);
						if ( invPayCurrCd[i] !=	null)
						model.setInvPayCurrCd( invPayCurrCd[i]);
						if ( invXchDt[i] !=	null)
						model.setInvXchDt( invXchDt[i]);
						if ( xterBankAcctSeq[i] !=	null)
						model.setXterBankAcctSeq( xterBankAcctSeq[i]);
						if ( cntAcctgPstFlgY[i] !=	null)
						model.setCntAcctgPstFlgY( cntAcctgPstFlgY[i]);
						if ( payCurrInvAmt[i] !=	null)
						model.setPayCurrInvAmt( payCurrInvAmt[i]);
						if ( apPayGrpLuCd[i] !=	null)
						model.setApPayGrpLuCd( apPayGrpLuCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( chkFlg[i] !=	null)
						model.setChkFlg( chkFlg[i]);
						if ( invCxlDt[i] !=	null)
						model.setInvCxlDt( invCxlDt[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( invTermDt[i] !=	null)
						model.setInvTermDt( invTermDt[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( batSeq[i] !=	null)
						model.setBatSeq( batSeq[i]);
						if ( invXchRtTpCd[i] !=	null)
						model.setInvXchRtTpCd( invXchRtTpCd[i]);
						if ( cxlUsrId[i] !=	null)
						model.setCxlUsrId( cxlUsrId[i]);
						if ( liabCoaCtrCd[i] !=	null)
						model.setLiabCoaCtrCd( liabCoaCtrCd[i]);
						if ( gloAttrCtnt19[i] !=	null)
						model.setGloAttrCtnt19( gloAttrCtnt19[i]);
						if ( gloAttrCtnt17[i] !=	null)
						model.setGloAttrCtnt17( gloAttrCtnt17[i]);
						if ( gloAttrCtnt18[i] !=	null)
						model.setGloAttrCtnt18( gloAttrCtnt18[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( gloAttrCtnt15[i] !=	null)
						model.setGloAttrCtnt15( gloAttrCtnt15[i]);
						if ( invVatCd[i] !=	null)
						model.setInvVatCd( invVatCd[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( gloAttrCtnt16[i] !=	null)
						model.setGloAttrCtnt16( gloAttrCtnt16[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( gloAttrCtnt13[i] !=	null)
						model.setGloAttrCtnt13( gloAttrCtnt13[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( gloAttrCtnt14[i] !=	null)
						model.setGloAttrCtnt14( gloAttrCtnt14[i]);
						if ( gloAttrCtnt11[i] !=	null)
						model.setGloAttrCtnt11( gloAttrCtnt11[i]);
						if ( gloAttrCtnt12[i] !=	null)
						model.setGloAttrCtnt12( gloAttrCtnt12[i]);
						if ( gloAttrCtnt10[i] !=	null)
						model.setGloAttrCtnt10( gloAttrCtnt10[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( attrCtnt2[i] !=	null)
						model.setAttrCtnt2( attrCtnt2[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( invCurrPrcs[i] !=	null)
						model.setInvCurrPrcs( invCurrPrcs[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( gloAttrCtnt2[i] !=	null)
						model.setGloAttrCtnt2( gloAttrCtnt2[i]);
						if ( gloAttrCtnt3[i] !=	null)
						model.setGloAttrCtnt3( gloAttrCtnt3[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
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
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( invVatAmt[i] !=	null)
						model.setInvVatAmt( invVatAmt[i]);
						if ( invPayAmt[i] !=	null)
						model.setInvPayAmt( invPayAmt[i]);
						if ( dtrbSetSeq[i] !=	null)
						model.setDtrbSetSeq( dtrbSetSeq[i]);
						if ( invAproRdyFlg[i] !=	null)
						model.setInvAproRdyFlg( invAproRdyFlg[i]);
						if ( gloAttrCtnt1[i] !=	null)
						model.setGloAttrCtnt1( gloAttrCtnt1[i]);
						if ( invCxlAmt[i] !=	null)
						model.setInvCxlAmt( invCxlAmt[i]);
						if ( invXchRtTpCdNm[i] !=	null)
						model.setInvXchRtTpCdNm( invXchRtTpCdNm[i]);
						if ( liabCoaCoCd[i] !=	null)
						model.setLiabCoaCoCd( liabCoaCoCd[i]);
						if ( gloAttrCateNm[i] !=	null)
						model.setGloAttrCateNm( gloAttrCateNm[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apApstsCd[i] !=	null)
						model.setApApstsCd( apApstsCd[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( liabCoaInterCoCd[i] !=	null)
						model.setLiabCoaInterCoCd( liabCoaInterCoCd[i]);
						if ( invTermNm[i] !=	null)
						model.setInvTermNm( invTermNm[i]);
						if ( invFuncAmt[i] !=	null)
						model.setInvFuncAmt( invFuncAmt[i]);
						if ( approvalStatus[i] !=	null)
						model.setApprovalStatus( approvalStatus[i]);
						if ( prepayRmnTotAmt[i] !=	null)
						model.setPrepayRmnTotAmt( prepayRmnTotAmt[i]);
						if ( asaTransYn[i] !=	null)
						model.setAsaTransYn( asaTransYn[i]);
						if ( submitFlag[i] !=	null)
						model.setSubmitFlag( submitFlag[i]);
						if ( bankAcctFlg[i] !=	null)
						model.setBankAcctFlg( bankAcctFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceEntryListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceEntryListVO[]
	 */
	public InvoiceEntryListVO[]	 getInvoiceEntryListVOs(){
		InvoiceEntryListVO[] vos = (InvoiceEntryListVO[])models.toArray(new	InvoiceEntryListVO[models.size()]);
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
	public void	unDataFormat(){
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg =	this.payStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaVvdCd =	this.liabCoaVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaRgnCd =	this.liabCoaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodChk =	this.periodChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eryStlDt =	this.eryStlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt20 =	this.gloAttrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaAcctNo =	this.liabCoaAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd =	this.invPayCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchDt =	this.invXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq =	this.xterBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntAcctgPstFlgY =	this.cntAcctgPstFlgY.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrInvAmt =	this.payCurrInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd =	this.apPayGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg =	this.chkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCxlDt =	this.invCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermDt =	this.invTermDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSeq =	this.batSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCd =	this.invXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlUsrId =	this.cxlUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaCtrCd =	this.liabCoaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt19 =	this.gloAttrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt17 =	this.gloAttrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt18 =	this.gloAttrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt15 =	this.gloAttrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatCd =	this.invVatCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt16 =	this.gloAttrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt13 =	this.gloAttrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt14 =	this.gloAttrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt11 =	this.gloAttrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt12 =	this.gloAttrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt10 =	this.gloAttrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrPrcs =	this.invCurrPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt2 =	this.gloAttrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt3 =	this.gloAttrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt4 =	this.gloAttrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt5 =	this.gloAttrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt6 =	this.gloAttrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt7 =	this.gloAttrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt8 =	this.gloAttrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt9 =	this.gloAttrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt =	this.invVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayAmt =	this.invPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSetSeq =	this.dtrbSetSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAproRdyFlg =	this.invAproRdyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt1 =	this.gloAttrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCxlAmt =	this.invCxlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtTpCdNm =	this.invXchRtTpCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaCoCd =	this.liabCoaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCateNm =	this.gloAttrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apApstsCd =	this.apApstsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCoaInterCoCd =	this.liabCoaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm =	this.invTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFuncAmt =	this.invFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalStatus =	this.approvalStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayRmnTotAmt =	this.prepayRmnTotAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaTransYn =	this.asaTransYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.submitFlag =	this.submitFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctFlg =	this.bankAcctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}