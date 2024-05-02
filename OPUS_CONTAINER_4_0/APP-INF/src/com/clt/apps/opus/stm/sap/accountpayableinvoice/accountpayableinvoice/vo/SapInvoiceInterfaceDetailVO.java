/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SapInvoiceInterfaceDetailVO.java
 *@FileTitle : SapInvoiceInterfaceDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.27  
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
public class SapInvoiceInterfaceDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SapInvoiceInterfaceDetailVO>  models =	new	ArrayList<SapInvoiceInterfaceDetailVO>();


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
	private  String	 dtrbSetNm   =  null;
	/*	Column Info	*/
	private  String	 dtrbCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 asetCateSeq   =  null;
	/*	Column Info	*/
	private  String	 acctSgmCd   =  null;
	/*	Column Info	*/
	private  String	 prcCorrFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt20   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 dtrbCdCombinations   =  null;
	/*	Column Info	*/
	private  String	 asetTrakFlg   =  null;
	/*	Column Info	*/
	private  String	 dtrbAmt   =  null;
	/*	Column Info	*/
	private  String	 asetBkTpCd   =  null;
	/*	Column Info	*/
	private  String	 fnlMtchStsCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt19   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt17   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt18   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 ifRqstSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt16   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 invIfLineSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 costCtrSgmCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaInterCoCd   =  null;
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
	private  String	 dtrbDesc   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 lineTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 crCrdTjSeq   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaAcctNo   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 invLineNo   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaCoCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 ifSrcNm   =  null;
	/*	Column Info	*/
	private  String	 invIfSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCateNm   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 balSgmCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaVvdCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbVatCd   =  null;
	/*	Column Info	*/
	private  String	 lineFunctionalAmount   =  null;
	/*	Column Info	*/
	private  String	 lInvRoundAmount   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 creationUser   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchDt   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchRt   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbFuncGainAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbFuncLssAmt   =  null;
	/*	Column Info	*/
	private  String	 exchangeRateType   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public SapInvoiceInterfaceDetailVO(){}

	public SapInvoiceInterfaceDetailVO(String attrCtnt10,String attrCtnt14,String attrCtnt13,String attrCtnt12,String attrCtnt11,String dtrbSetNm,String dtrbCdCmbSeq,String pagerows,String attrCtnt15,String asetCateSeq,String acctSgmCd,String prcCorrFlg,String attrCateNm,String updUsrId,String gloAttrCtnt20,String acctgDt,String creUsrId,String dtrbCdCombinations,String asetTrakFlg,String dtrbAmt,String asetBkTpCd,String fnlMtchStsCd,String dtrbCoaRgnCd,String gloAttrCtnt19,String gloAttrCtnt17,String gloAttrCtnt18,String creDt,String ifRqstSeq,String gloAttrCtnt15,String attrCtnt9,String gloAttrCtnt16,String attrCtnt8,String invIfLineSeq,String gloAttrCtnt13,String gloAttrCtnt14,String costCtrSgmCd,String gloAttrCtnt11,String gloAttrCtnt12,String gloAttrCtnt10,String attrCtnt1,String dtrbCoaInterCoCd,String attrCtnt2,String ibflag,String attrCtnt3,String attrCtnt4,String usrId,String attrCtnt5,String attrCtnt6,String invIfFlg,String dtrbDesc,String attrCtnt7,String gloAttrCtnt2,String gloAttrCtnt3,String lineTpLuCd,String gloAttrCtnt4,String gloAttrCtnt5,String crCrdTjSeq,String dtrbCoaAcctNo,String gloAttrCtnt6,String invLineNo,String gloAttrCtnt7,String gloAttrCtnt8,String gloAttrCtnt9,String updDt,String dtrbCoaCoCd,String dtrbCoaCtrCd,String gloAttrCtnt1,String ifSrcNm,String invIfSeq,String gloAttrCateNm,String invNo,String ofcCd,String balSgmCd,String dtrbCoaVvdCd,String dtrbVatCd,String lineFunctionalAmount,String lInvRoundAmount,String invSeq,String creationUser,String dtrbXchDt,String dtrbXchRt,String dtrbXchRtTpCd,String dtrbFuncGainAmt,String dtrbFuncLssAmt,String exchangeRateType)	{
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.attrCtnt13  = attrCtnt13 ;
		this.attrCtnt12  = attrCtnt12 ;
		this.attrCtnt11  = attrCtnt11 ;
		this.dtrbSetNm  = dtrbSetNm ;
		this.dtrbCdCmbSeq  = dtrbCdCmbSeq ;
		this.pagerows  = pagerows ;
		this.attrCtnt15  = attrCtnt15 ;
		this.asetCateSeq  = asetCateSeq ;
		this.acctSgmCd  = acctSgmCd ;
		this.prcCorrFlg  = prcCorrFlg ;
		this.attrCateNm  = attrCateNm ;
		this.updUsrId  = updUsrId ;
		this.gloAttrCtnt20  = gloAttrCtnt20 ;
		this.acctgDt  = acctgDt ;
		this.creUsrId  = creUsrId ;
		this.dtrbCdCombinations  = dtrbCdCombinations ;
		this.asetTrakFlg  = asetTrakFlg ;
		this.dtrbAmt  = dtrbAmt ;
		this.asetBkTpCd  = asetBkTpCd ;
		this.fnlMtchStsCd  = fnlMtchStsCd ;
		this.dtrbCoaRgnCd  = dtrbCoaRgnCd ;
		this.gloAttrCtnt19  = gloAttrCtnt19 ;
		this.gloAttrCtnt17  = gloAttrCtnt17 ;
		this.gloAttrCtnt18  = gloAttrCtnt18 ;
		this.creDt  = creDt ;
		this.ifRqstSeq  = ifRqstSeq ;
		this.gloAttrCtnt15  = gloAttrCtnt15 ;
		this.attrCtnt9  = attrCtnt9 ;
		this.gloAttrCtnt16  = gloAttrCtnt16 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.invIfLineSeq  = invIfLineSeq ;
		this.gloAttrCtnt13  = gloAttrCtnt13 ;
		this.gloAttrCtnt14  = gloAttrCtnt14 ;
		this.costCtrSgmCd  = costCtrSgmCd ;
		this.gloAttrCtnt11  = gloAttrCtnt11 ;
		this.gloAttrCtnt12  = gloAttrCtnt12 ;
		this.gloAttrCtnt10  = gloAttrCtnt10 ;
		this.attrCtnt1  = attrCtnt1 ;
		this.dtrbCoaInterCoCd  = dtrbCoaInterCoCd ;
		this.attrCtnt2  = attrCtnt2 ;
		this.ibflag  = ibflag ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.usrId  = usrId ;
		this.attrCtnt5  = attrCtnt5 ;
		this.attrCtnt6  = attrCtnt6 ;
		this.invIfFlg  = invIfFlg ;
		this.dtrbDesc  = dtrbDesc ;
		this.attrCtnt7  = attrCtnt7 ;
		this.gloAttrCtnt2  = gloAttrCtnt2 ;
		this.gloAttrCtnt3  = gloAttrCtnt3 ;
		this.lineTpLuCd  = lineTpLuCd ;
		this.gloAttrCtnt4  = gloAttrCtnt4 ;
		this.gloAttrCtnt5  = gloAttrCtnt5 ;
		this.crCrdTjSeq  = crCrdTjSeq ;
		this.dtrbCoaAcctNo  = dtrbCoaAcctNo ;
		this.gloAttrCtnt6  = gloAttrCtnt6 ;
		this.invLineNo  = invLineNo ;
		this.gloAttrCtnt7  = gloAttrCtnt7 ;
		this.gloAttrCtnt8  = gloAttrCtnt8 ;
		this.gloAttrCtnt9  = gloAttrCtnt9 ;
		this.updDt  = updDt ;
		this.dtrbCoaCoCd  = dtrbCoaCoCd ;
		this.dtrbCoaCtrCd  = dtrbCoaCtrCd ;
		this.gloAttrCtnt1  = gloAttrCtnt1 ;
		this.ifSrcNm  = ifSrcNm ;
		this.invIfSeq  = invIfSeq ;
		this.gloAttrCateNm  = gloAttrCateNm ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.balSgmCd  = balSgmCd ;
		this.dtrbCoaVvdCd  = dtrbCoaVvdCd ;
		this.dtrbVatCd  = dtrbVatCd ;
		this.lineFunctionalAmount  = lineFunctionalAmount ;
		this.lInvRoundAmount  = lInvRoundAmount ;
		this.invSeq  = invSeq ;
		this.creationUser  = creationUser ;
		this.dtrbXchDt  = dtrbXchDt ;
		this.dtrbXchRt  = dtrbXchRt ;
		this.dtrbXchRtTpCd  = dtrbXchRtTpCd ;
		this.dtrbFuncGainAmt  = dtrbFuncGainAmt ;
		this.dtrbFuncLssAmt  = dtrbFuncLssAmt ;
		this.exchangeRateType  = exchangeRateType ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("dtrb_set_nm", getDtrbSetNm());		
		this.hashColumns.put("dtrb_cd_cmb_seq", getDtrbCdCmbSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("aset_cate_seq", getAsetCateSeq());		
		this.hashColumns.put("acct_sgm_cd", getAcctSgmCd());		
		this.hashColumns.put("prc_corr_flg", getPrcCorrFlg());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("glo_attr_ctnt20", getGloAttrCtnt20());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("dtrb_cd_combinations", getDtrbCdCombinations());		
		this.hashColumns.put("aset_trak_flg", getAsetTrakFlg());		
		this.hashColumns.put("dtrb_amt", getDtrbAmt());		
		this.hashColumns.put("aset_bk_tp_cd", getAsetBkTpCd());		
		this.hashColumns.put("fnl_mtch_sts_cd", getFnlMtchStsCd());		
		this.hashColumns.put("dtrb_coa_rgn_cd", getDtrbCoaRgnCd());		
		this.hashColumns.put("glo_attr_ctnt19", getGloAttrCtnt19());		
		this.hashColumns.put("glo_attr_ctnt17", getGloAttrCtnt17());		
		this.hashColumns.put("glo_attr_ctnt18", getGloAttrCtnt18());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("if_rqst_seq", getIfRqstSeq());		
		this.hashColumns.put("glo_attr_ctnt15", getGloAttrCtnt15());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("glo_attr_ctnt16", getGloAttrCtnt16());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("inv_if_line_seq", getInvIfLineSeq());		
		this.hashColumns.put("glo_attr_ctnt13", getGloAttrCtnt13());		
		this.hashColumns.put("glo_attr_ctnt14", getGloAttrCtnt14());		
		this.hashColumns.put("cost_ctr_sgm_cd", getCostCtrSgmCd());		
		this.hashColumns.put("glo_attr_ctnt11", getGloAttrCtnt11());		
		this.hashColumns.put("glo_attr_ctnt12", getGloAttrCtnt12());		
		this.hashColumns.put("glo_attr_ctnt10", getGloAttrCtnt10());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("dtrb_coa_inter_co_cd", getDtrbCoaInterCoCd());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("inv_if_flg", getInvIfFlg());		
		this.hashColumns.put("dtrb_desc", getDtrbDesc());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt2", getGloAttrCtnt2());		
		this.hashColumns.put("glo_attr_ctnt3", getGloAttrCtnt3());		
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());		
		this.hashColumns.put("glo_attr_ctnt4", getGloAttrCtnt4());		
		this.hashColumns.put("glo_attr_ctnt5", getGloAttrCtnt5());		
		this.hashColumns.put("cr_crd_tj_seq", getCrCrdTjSeq());		
		this.hashColumns.put("dtrb_coa_acct_no", getDtrbCoaAcctNo());		
		this.hashColumns.put("glo_attr_ctnt6", getGloAttrCtnt6());		
		this.hashColumns.put("inv_line_no", getInvLineNo());		
		this.hashColumns.put("glo_attr_ctnt7", getGloAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt8", getGloAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt9", getGloAttrCtnt9());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("dtrb_coa_co_cd", getDtrbCoaCoCd());		
		this.hashColumns.put("dtrb_coa_ctr_cd", getDtrbCoaCtrCd());		
		this.hashColumns.put("glo_attr_ctnt1", getGloAttrCtnt1());		
		this.hashColumns.put("if_src_nm", getIfSrcNm());		
		this.hashColumns.put("inv_if_seq", getInvIfSeq());		
		this.hashColumns.put("glo_attr_cate_nm", getGloAttrCateNm());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("bal_sgm_cd", getBalSgmCd());		
		this.hashColumns.put("dtrb_coa_vvd_cd", getDtrbCoaVvdCd());		
		this.hashColumns.put("dtrb_vat_cd", getDtrbVatCd());		
		this.hashColumns.put("line_functional_amount", getLineFunctionalAmount());		
		this.hashColumns.put("l_inv_round_amount", getLInvRoundAmount());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("creation_user", getCreationUser());		
		this.hashColumns.put("dtrb_xch_dt", getDtrbXchDt());		
		this.hashColumns.put("dtrb_xch_rt", getDtrbXchRt());		
		this.hashColumns.put("dtrb_xch_rt_tp_cd", getDtrbXchRtTpCd());		
		this.hashColumns.put("dtrb_func_gain_amt", getDtrbFuncGainAmt());		
		this.hashColumns.put("dtrb_func_lss_amt", getDtrbFuncLssAmt());		
		this.hashColumns.put("exchange_rate_type", getExchangeRateType());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("dtrb_set_nm", "dtrbSetNm");
		this.hashFields.put("dtrb_cd_cmb_seq", "dtrbCdCmbSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("aset_cate_seq", "asetCateSeq");
		this.hashFields.put("acct_sgm_cd", "acctSgmCd");
		this.hashFields.put("prc_corr_flg", "prcCorrFlg");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("glo_attr_ctnt20", "gloAttrCtnt20");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dtrb_cd_combinations", "dtrbCdCombinations");
		this.hashFields.put("aset_trak_flg", "asetTrakFlg");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("aset_bk_tp_cd", "asetBkTpCd");
		this.hashFields.put("fnl_mtch_sts_cd", "fnlMtchStsCd");
		this.hashFields.put("dtrb_coa_rgn_cd", "dtrbCoaRgnCd");
		this.hashFields.put("glo_attr_ctnt19", "gloAttrCtnt19");
		this.hashFields.put("glo_attr_ctnt17", "gloAttrCtnt17");
		this.hashFields.put("glo_attr_ctnt18", "gloAttrCtnt18");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("if_rqst_seq", "ifRqstSeq");
		this.hashFields.put("glo_attr_ctnt15", "gloAttrCtnt15");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("glo_attr_ctnt16", "gloAttrCtnt16");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("inv_if_line_seq", "invIfLineSeq");
		this.hashFields.put("glo_attr_ctnt13", "gloAttrCtnt13");
		this.hashFields.put("glo_attr_ctnt14", "gloAttrCtnt14");
		this.hashFields.put("cost_ctr_sgm_cd", "costCtrSgmCd");
		this.hashFields.put("glo_attr_ctnt11", "gloAttrCtnt11");
		this.hashFields.put("glo_attr_ctnt12", "gloAttrCtnt12");
		this.hashFields.put("glo_attr_ctnt10", "gloAttrCtnt10");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("dtrb_coa_inter_co_cd", "dtrbCoaInterCoCd");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("glo_attr_ctnt2", "gloAttrCtnt2");
		this.hashFields.put("glo_attr_ctnt3", "gloAttrCtnt3");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("glo_attr_ctnt4", "gloAttrCtnt4");
		this.hashFields.put("glo_attr_ctnt5", "gloAttrCtnt5");
		this.hashFields.put("cr_crd_tj_seq", "crCrdTjSeq");
		this.hashFields.put("dtrb_coa_acct_no", "dtrbCoaAcctNo");
		this.hashFields.put("glo_attr_ctnt6", "gloAttrCtnt6");
		this.hashFields.put("inv_line_no", "invLineNo");
		this.hashFields.put("glo_attr_ctnt7", "gloAttrCtnt7");
		this.hashFields.put("glo_attr_ctnt8", "gloAttrCtnt8");
		this.hashFields.put("glo_attr_ctnt9", "gloAttrCtnt9");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dtrb_coa_co_cd", "dtrbCoaCoCd");
		this.hashFields.put("dtrb_coa_ctr_cd", "dtrbCoaCtrCd");
		this.hashFields.put("glo_attr_ctnt1", "gloAttrCtnt1");
		this.hashFields.put("if_src_nm", "ifSrcNm");
		this.hashFields.put("inv_if_seq", "invIfSeq");
		this.hashFields.put("glo_attr_cate_nm", "gloAttrCateNm");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bal_sgm_cd", "balSgmCd");
		this.hashFields.put("dtrb_coa_vvd_cd", "dtrbCoaVvdCd");
		this.hashFields.put("dtrb_vat_cd", "dtrbVatCd");
		this.hashFields.put("line_functional_amount", "lineFunctionalAmount");
		this.hashFields.put("l_inv_round_amount", "lInvRoundAmount");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("creation_user", "creationUser");
		this.hashFields.put("dtrb_xch_dt", "dtrbXchDt");
		this.hashFields.put("dtrb_xch_rt", "dtrbXchRt");
		this.hashFields.put("dtrb_xch_rt_tp_cd", "dtrbXchRtTpCd");
		this.hashFields.put("dtrb_func_gain_amt", "dtrbFuncGainAmt");
		this.hashFields.put("dtrb_func_lss_amt", "dtrbFuncLssAmt");
		this.hashFields.put("exchange_rate_type", "exchangeRateType");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  dtrbSetNm
	*/
	public void	setDtrbSetNm( String	dtrbSetNm ) {
		this.dtrbSetNm =	dtrbSetNm;
	}
 
	/**
	 * Column Info
	 * @return	dtrbSetNm
	 */
	 public	String	getDtrbSetNm() {
		 return	this.dtrbSetNm;
	 } 
 	/**
	* Column Info
	* @param  dtrbCdCmbSeq
	*/
	public void	setDtrbCdCmbSeq( String	dtrbCdCmbSeq ) {
		this.dtrbCdCmbSeq =	dtrbCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCdCmbSeq
	 */
	 public	String	getDtrbCdCmbSeq() {
		 return	this.dtrbCdCmbSeq;
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
	* @param  asetCateSeq
	*/
	public void	setAsetCateSeq( String	asetCateSeq ) {
		this.asetCateSeq =	asetCateSeq;
	}
 
	/**
	 * Column Info
	 * @return	asetCateSeq
	 */
	 public	String	getAsetCateSeq() {
		 return	this.asetCateSeq;
	 } 
 	/**
	* Column Info
	* @param  acctSgmCd
	*/
	public void	setAcctSgmCd( String	acctSgmCd ) {
		this.acctSgmCd =	acctSgmCd;
	}
 
	/**
	 * Column Info
	 * @return	acctSgmCd
	 */
	 public	String	getAcctSgmCd() {
		 return	this.acctSgmCd;
	 } 
 	/**
	* Column Info
	* @param  prcCorrFlg
	*/
	public void	setPrcCorrFlg( String	prcCorrFlg ) {
		this.prcCorrFlg =	prcCorrFlg;
	}
 
	/**
	 * Column Info
	 * @return	prcCorrFlg
	 */
	 public	String	getPrcCorrFlg() {
		 return	this.prcCorrFlg;
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
	* @param  acctgDt
	*/
	public void	setAcctgDt( String	acctgDt ) {
		this.acctgDt =	acctgDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgDt
	 */
	 public	String	getAcctgDt() {
		 return	this.acctgDt;
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
	* @param  dtrbCdCombinations
	*/
	public void	setDtrbCdCombinations( String	dtrbCdCombinations ) {
		this.dtrbCdCombinations =	dtrbCdCombinations;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCdCombinations
	 */
	 public	String	getDtrbCdCombinations() {
		 return	this.dtrbCdCombinations;
	 } 
 	/**
	* Column Info
	* @param  asetTrakFlg
	*/
	public void	setAsetTrakFlg( String	asetTrakFlg ) {
		this.asetTrakFlg =	asetTrakFlg;
	}
 
	/**
	 * Column Info
	 * @return	asetTrakFlg
	 */
	 public	String	getAsetTrakFlg() {
		 return	this.asetTrakFlg;
	 } 
 	/**
	* Column Info
	* @param  dtrbAmt
	*/
	public void	setDtrbAmt( String	dtrbAmt ) {
		this.dtrbAmt =	dtrbAmt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbAmt
	 */
	 public	String	getDtrbAmt() {
		 return	this.dtrbAmt;
	 } 
 	/**
	* Column Info
	* @param  asetBkTpCd
	*/
	public void	setAsetBkTpCd( String	asetBkTpCd ) {
		this.asetBkTpCd =	asetBkTpCd;
	}
 
	/**
	 * Column Info
	 * @return	asetBkTpCd
	 */
	 public	String	getAsetBkTpCd() {
		 return	this.asetBkTpCd;
	 } 
 	/**
	* Column Info
	* @param  fnlMtchStsCd
	*/
	public void	setFnlMtchStsCd( String	fnlMtchStsCd ) {
		this.fnlMtchStsCd =	fnlMtchStsCd;
	}
 
	/**
	 * Column Info
	 * @return	fnlMtchStsCd
	 */
	 public	String	getFnlMtchStsCd() {
		 return	this.fnlMtchStsCd;
	 } 
 	/**
	* Column Info
	* @param  dtrbCoaRgnCd
	*/
	public void	setDtrbCoaRgnCd( String	dtrbCoaRgnCd ) {
		this.dtrbCoaRgnCd =	dtrbCoaRgnCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaRgnCd
	 */
	 public	String	getDtrbCoaRgnCd() {
		 return	this.dtrbCoaRgnCd;
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
	* @param  ifRqstSeq
	*/
	public void	setIfRqstSeq( String	ifRqstSeq ) {
		this.ifRqstSeq =	ifRqstSeq;
	}
 
	/**
	 * Column Info
	 * @return	ifRqstSeq
	 */
	 public	String	getIfRqstSeq() {
		 return	this.ifRqstSeq;
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
	* @param  invIfLineSeq
	*/
	public void	setInvIfLineSeq( String	invIfLineSeq ) {
		this.invIfLineSeq =	invIfLineSeq;
	}
 
	/**
	 * Column Info
	 * @return	invIfLineSeq
	 */
	 public	String	getInvIfLineSeq() {
		 return	this.invIfLineSeq;
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
	* @param  costCtrSgmCd
	*/
	public void	setCostCtrSgmCd( String	costCtrSgmCd ) {
		this.costCtrSgmCd =	costCtrSgmCd;
	}
 
	/**
	 * Column Info
	 * @return	costCtrSgmCd
	 */
	 public	String	getCostCtrSgmCd() {
		 return	this.costCtrSgmCd;
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
	* @param  dtrbCoaInterCoCd
	*/
	public void	setDtrbCoaInterCoCd( String	dtrbCoaInterCoCd ) {
		this.dtrbCoaInterCoCd =	dtrbCoaInterCoCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaInterCoCd
	 */
	 public	String	getDtrbCoaInterCoCd() {
		 return	this.dtrbCoaInterCoCd;
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
	* @param  invIfFlg
	*/
	public void	setInvIfFlg( String	invIfFlg ) {
		this.invIfFlg =	invIfFlg;
	}
 
	/**
	 * Column Info
	 * @return	invIfFlg
	 */
	 public	String	getInvIfFlg() {
		 return	this.invIfFlg;
	 } 
 	/**
	* Column Info
	* @param  dtrbDesc
	*/
	public void	setDtrbDesc( String	dtrbDesc ) {
		this.dtrbDesc =	dtrbDesc;
	}
 
	/**
	 * Column Info
	 * @return	dtrbDesc
	 */
	 public	String	getDtrbDesc() {
		 return	this.dtrbDesc;
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
	* @param  lineTpLuCd
	*/
	public void	setLineTpLuCd( String	lineTpLuCd ) {
		this.lineTpLuCd =	lineTpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	lineTpLuCd
	 */
	 public	String	getLineTpLuCd() {
		 return	this.lineTpLuCd;
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
	* @param  crCrdTjSeq
	*/
	public void	setCrCrdTjSeq( String	crCrdTjSeq ) {
		this.crCrdTjSeq =	crCrdTjSeq;
	}
 
	/**
	 * Column Info
	 * @return	crCrdTjSeq
	 */
	 public	String	getCrCrdTjSeq() {
		 return	this.crCrdTjSeq;
	 } 
 	/**
	* Column Info
	* @param  dtrbCoaAcctNo
	*/
	public void	setDtrbCoaAcctNo( String	dtrbCoaAcctNo ) {
		this.dtrbCoaAcctNo =	dtrbCoaAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaAcctNo
	 */
	 public	String	getDtrbCoaAcctNo() {
		 return	this.dtrbCoaAcctNo;
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
	* @param  invLineNo
	*/
	public void	setInvLineNo( String	invLineNo ) {
		this.invLineNo =	invLineNo;
	}
 
	/**
	 * Column Info
	 * @return	invLineNo
	 */
	 public	String	getInvLineNo() {
		 return	this.invLineNo;
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
	* @param  dtrbCoaCoCd
	*/
	public void	setDtrbCoaCoCd( String	dtrbCoaCoCd ) {
		this.dtrbCoaCoCd =	dtrbCoaCoCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaCoCd
	 */
	 public	String	getDtrbCoaCoCd() {
		 return	this.dtrbCoaCoCd;
	 } 
 	/**
	* Column Info
	* @param  dtrbCoaCtrCd
	*/
	public void	setDtrbCoaCtrCd( String	dtrbCoaCtrCd ) {
		this.dtrbCoaCtrCd =	dtrbCoaCtrCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaCtrCd
	 */
	 public	String	getDtrbCoaCtrCd() {
		 return	this.dtrbCoaCtrCd;
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
	* @param  ifSrcNm
	*/
	public void	setIfSrcNm( String	ifSrcNm ) {
		this.ifSrcNm =	ifSrcNm;
	}
 
	/**
	 * Column Info
	 * @return	ifSrcNm
	 */
	 public	String	getIfSrcNm() {
		 return	this.ifSrcNm;
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
	 public	String	getInvIfSeq() {
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
	 public	String	getGloAttrCateNm() {
		 return	this.gloAttrCateNm;
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
	* @param  balSgmCd
	*/
	public void	setBalSgmCd( String	balSgmCd ) {
		this.balSgmCd =	balSgmCd;
	}
 
	/**
	 * Column Info
	 * @return	balSgmCd
	 */
	 public	String	getBalSgmCd() {
		 return	this.balSgmCd;
	 } 
 	/**
	* Column Info
	* @param  dtrbCoaVvdCd
	*/
	public void	setDtrbCoaVvdCd( String	dtrbCoaVvdCd ) {
		this.dtrbCoaVvdCd =	dtrbCoaVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCoaVvdCd
	 */
	 public	String	getDtrbCoaVvdCd() {
		 return	this.dtrbCoaVvdCd;
	 } 
 	/**
	* Column Info
	* @param  dtrbVatCd
	*/
	public void	setDtrbVatCd( String	dtrbVatCd ) {
		this.dtrbVatCd =	dtrbVatCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbVatCd
	 */
	 public	String	getDtrbVatCd() {
		 return	this.dtrbVatCd;
	 } 
 	/**
	* Column Info
	* @param  lineFunctionalAmount
	*/
	public void	setLineFunctionalAmount( String	lineFunctionalAmount ) {
		this.lineFunctionalAmount =	lineFunctionalAmount;
	}
 
	/**
	 * Column Info
	 * @return	lineFunctionalAmount
	 */
	 public	String	getLineFunctionalAmount() {
		 return	this.lineFunctionalAmount;
	 } 
 	/**
	* Column Info
	* @param  lInvRoundAmount
	*/
	public void	setLInvRoundAmount( String	lInvRoundAmount ) {
		this.lInvRoundAmount =	lInvRoundAmount;
	}
 
	/**
	 * Column Info
	 * @return	lInvRoundAmount
	 */
	 public	String	getLInvRoundAmount() {
		 return	this.lInvRoundAmount;
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
	* @param  creationUser
	*/
	public void	setCreationUser( String	creationUser ) {
		this.creationUser =	creationUser;
	}
 
	/**
	 * Column Info
	 * @return	creationUser
	 */
	 public	String	getCreationUser() {
		 return	this.creationUser;
	 } 
 	/**
	* Column Info
	* @param  dtrbXchDt
	*/
	public void	setDtrbXchDt( String	dtrbXchDt ) {
		this.dtrbXchDt =	dtrbXchDt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbXchDt
	 */
	 public	String	getDtrbXchDt() {
		 return	this.dtrbXchDt;
	 } 
 	/**
	* Column Info
	* @param  dtrbXchRt
	*/
	public void	setDtrbXchRt( String	dtrbXchRt ) {
		this.dtrbXchRt =	dtrbXchRt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbXchRt
	 */
	 public	String	getDtrbXchRt() {
		 return	this.dtrbXchRt;
	 } 
 	/**
	* Column Info
	* @param  dtrbXchRtTpCd
	*/
	public void	setDtrbXchRtTpCd( String	dtrbXchRtTpCd ) {
		this.dtrbXchRtTpCd =	dtrbXchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbXchRtTpCd
	 */
	 public	String	getDtrbXchRtTpCd() {
		 return	this.dtrbXchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  dtrbFuncGainAmt
	*/
	public void	setDtrbFuncGainAmt( String	dtrbFuncGainAmt ) {
		this.dtrbFuncGainAmt =	dtrbFuncGainAmt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbFuncGainAmt
	 */
	 public	String	getDtrbFuncGainAmt() {
		 return	this.dtrbFuncGainAmt;
	 } 
 	/**
	* Column Info
	* @param  dtrbFuncLssAmt
	*/
	public void	setDtrbFuncLssAmt( String	dtrbFuncLssAmt ) {
		this.dtrbFuncLssAmt =	dtrbFuncLssAmt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbFuncLssAmt
	 */
	 public	String	getDtrbFuncLssAmt() {
		 return	this.dtrbFuncLssAmt;
	 } 
 	/**
	* Column Info
	* @param  exchangeRateType
	*/
	public void	setExchangeRateType( String	exchangeRateType ) {
		this.exchangeRateType =	exchangeRateType;
	}
 
	/**
	 * Column Info
	 * @return	exchangeRateType
	 */
	 public	String	getExchangeRateType() {
		 return	this.exchangeRateType;
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
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setDtrbSetNm(JSPUtil.getParameter(request,	prefix + "dtrb_set_nm", ""));
		setDtrbCdCmbSeq(JSPUtil.getParameter(request,	prefix + "dtrb_cd_cmb_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setAsetCateSeq(JSPUtil.getParameter(request,	prefix + "aset_cate_seq", ""));
		setAcctSgmCd(JSPUtil.getParameter(request,	prefix + "acct_sgm_cd", ""));
		setPrcCorrFlg(JSPUtil.getParameter(request,	prefix + "prc_corr_flg", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setGloAttrCtnt20(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt20", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDtrbCdCombinations(JSPUtil.getParameter(request,	prefix + "dtrb_cd_combinations", ""));
		setAsetTrakFlg(JSPUtil.getParameter(request,	prefix + "aset_trak_flg", ""));
		setDtrbAmt(JSPUtil.getParameter(request,	prefix + "dtrb_amt", ""));
		setAsetBkTpCd(JSPUtil.getParameter(request,	prefix + "aset_bk_tp_cd", ""));
		setFnlMtchStsCd(JSPUtil.getParameter(request,	prefix + "fnl_mtch_sts_cd", ""));
		setDtrbCoaRgnCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_rgn_cd", ""));
		setGloAttrCtnt19(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt19", ""));
		setGloAttrCtnt17(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt17", ""));
		setGloAttrCtnt18(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt18", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setIfRqstSeq(JSPUtil.getParameter(request,	prefix + "if_rqst_seq", ""));
		setGloAttrCtnt15(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt15", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setGloAttrCtnt16(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt16", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setInvIfLineSeq(JSPUtil.getParameter(request,	prefix + "inv_if_line_seq", ""));
		setGloAttrCtnt13(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt13", ""));
		setGloAttrCtnt14(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt14", ""));
		setCostCtrSgmCd(JSPUtil.getParameter(request,	prefix + "cost_ctr_sgm_cd", ""));
		setGloAttrCtnt11(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt11", ""));
		setGloAttrCtnt12(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt12", ""));
		setGloAttrCtnt10(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt10", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setDtrbCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_inter_co_cd", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setInvIfFlg(JSPUtil.getParameter(request,	prefix + "inv_if_flg", ""));
		setDtrbDesc(JSPUtil.getParameter(request,	prefix + "dtrb_desc", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setGloAttrCtnt2(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt2", ""));
		setGloAttrCtnt3(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt3", ""));
		setLineTpLuCd(JSPUtil.getParameter(request,	prefix + "line_tp_lu_cd", ""));
		setGloAttrCtnt4(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt4", ""));
		setGloAttrCtnt5(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt5", ""));
		setCrCrdTjSeq(JSPUtil.getParameter(request,	prefix + "cr_crd_tj_seq", ""));
		setDtrbCoaAcctNo(JSPUtil.getParameter(request,	prefix + "dtrb_coa_acct_no", ""));
		setGloAttrCtnt6(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt6", ""));
		setInvLineNo(JSPUtil.getParameter(request,	prefix + "inv_line_no", ""));
		setGloAttrCtnt7(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt7", ""));
		setGloAttrCtnt8(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt8", ""));
		setGloAttrCtnt9(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt9", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setDtrbCoaCoCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_co_cd", ""));
		setDtrbCoaCtrCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_ctr_cd", ""));
		setGloAttrCtnt1(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt1", ""));
		setIfSrcNm(JSPUtil.getParameter(request,	prefix + "if_src_nm", ""));
		setInvIfSeq(JSPUtil.getParameter(request,	prefix + "inv_if_seq", ""));
		setGloAttrCateNm(JSPUtil.getParameter(request,	prefix + "glo_attr_cate_nm", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setBalSgmCd(JSPUtil.getParameter(request,	prefix + "bal_sgm_cd", ""));
		setDtrbCoaVvdCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_vvd_cd", ""));
		setDtrbVatCd(JSPUtil.getParameter(request,	prefix + "dtrb_vat_cd", ""));
		setLineFunctionalAmount(JSPUtil.getParameter(request,	prefix + "line_functional_amount", ""));
		setLInvRoundAmount(JSPUtil.getParameter(request,	prefix + "l_inv_round_amount", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setCreationUser(JSPUtil.getParameter(request,	prefix + "creation_user", ""));
		setDtrbXchDt(JSPUtil.getParameter(request,	prefix + "dtrb_xch_dt", ""));
		setDtrbXchRt(JSPUtil.getParameter(request,	prefix + "dtrb_xch_rt", ""));
		setDtrbXchRtTpCd(JSPUtil.getParameter(request,	prefix + "dtrb_xch_rt_tp_cd", ""));
		setDtrbFuncGainAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_gain_amt", ""));
		setDtrbFuncLssAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_lss_amt", ""));
		setExchangeRateType(JSPUtil.getParameter(request,	prefix + "exchange_rate_type", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SapInvoiceInterfaceDetailVO[]
	 */
	public SapInvoiceInterfaceDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SapInvoiceInterfaceDetailVO[]
	 */
	public SapInvoiceInterfaceDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SapInvoiceInterfaceDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] dtrbSetNm =	(JSPUtil.getParameter(request, prefix +	"dtrb_set_nm".trim(),	length));
				String[] dtrbCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"dtrb_cd_cmb_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] asetCateSeq =	(JSPUtil.getParameter(request, prefix +	"aset_cate_seq".trim(),	length));
				String[] acctSgmCd =	(JSPUtil.getParameter(request, prefix +	"acct_sgm_cd".trim(),	length));
				String[] prcCorrFlg =	(JSPUtil.getParameter(request, prefix +	"prc_corr_flg".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] gloAttrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt20".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] dtrbCdCombinations =	(JSPUtil.getParameter(request, prefix +	"dtrb_cd_combinations".trim(),	length));
				String[] asetTrakFlg =	(JSPUtil.getParameter(request, prefix +	"aset_trak_flg".trim(),	length));
				String[] dtrbAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_amt".trim(),	length));
				String[] asetBkTpCd =	(JSPUtil.getParameter(request, prefix +	"aset_bk_tp_cd".trim(),	length));
				String[] fnlMtchStsCd =	(JSPUtil.getParameter(request, prefix +	"fnl_mtch_sts_cd".trim(),	length));
				String[] dtrbCoaRgnCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_rgn_cd".trim(),	length));
				String[] gloAttrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt19".trim(),	length));
				String[] gloAttrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt17".trim(),	length));
				String[] gloAttrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt18".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] ifRqstSeq =	(JSPUtil.getParameter(request, prefix +	"if_rqst_seq".trim(),	length));
				String[] gloAttrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt15".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] gloAttrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt16".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] invIfLineSeq =	(JSPUtil.getParameter(request, prefix +	"inv_if_line_seq".trim(),	length));
				String[] gloAttrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt13".trim(),	length));
				String[] gloAttrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt14".trim(),	length));
				String[] costCtrSgmCd =	(JSPUtil.getParameter(request, prefix +	"cost_ctr_sgm_cd".trim(),	length));
				String[] gloAttrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt11".trim(),	length));
				String[] gloAttrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt12".trim(),	length));
				String[] gloAttrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt10".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] dtrbCoaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_inter_co_cd".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] invIfFlg =	(JSPUtil.getParameter(request, prefix +	"inv_if_flg".trim(),	length));
				String[] dtrbDesc =	(JSPUtil.getParameter(request, prefix +	"dtrb_desc".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt2".trim(),	length));
				String[] gloAttrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt3".trim(),	length));
				String[] lineTpLuCd =	(JSPUtil.getParameter(request, prefix +	"line_tp_lu_cd".trim(),	length));
				String[] gloAttrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt4".trim(),	length));
				String[] gloAttrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt5".trim(),	length));
				String[] crCrdTjSeq =	(JSPUtil.getParameter(request, prefix +	"cr_crd_tj_seq".trim(),	length));
				String[] dtrbCoaAcctNo =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_acct_no".trim(),	length));
				String[] gloAttrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt6".trim(),	length));
				String[] invLineNo =	(JSPUtil.getParameter(request, prefix +	"inv_line_no".trim(),	length));
				String[] gloAttrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt9".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] dtrbCoaCoCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_co_cd".trim(),	length));
				String[] dtrbCoaCtrCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_ctr_cd".trim(),	length));
				String[] gloAttrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt1".trim(),	length));
				String[] ifSrcNm =	(JSPUtil.getParameter(request, prefix +	"if_src_nm".trim(),	length));
				String[] invIfSeq =	(JSPUtil.getParameter(request, prefix +	"inv_if_seq".trim(),	length));
				String[] gloAttrCateNm =	(JSPUtil.getParameter(request, prefix +	"glo_attr_cate_nm".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] balSgmCd =	(JSPUtil.getParameter(request, prefix +	"bal_sgm_cd".trim(),	length));
				String[] dtrbCoaVvdCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_vvd_cd".trim(),	length));
				String[] dtrbVatCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_vat_cd".trim(),	length));
				String[] lineFunctionalAmount =	(JSPUtil.getParameter(request, prefix +	"line_functional_amount".trim(),	length));
				String[] lInvRoundAmount =	(JSPUtil.getParameter(request, prefix +	"l_inv_round_amount".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] creationUser =	(JSPUtil.getParameter(request, prefix +	"creation_user".trim(),	length));
				String[] dtrbXchDt =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_dt".trim(),	length));
				String[] dtrbXchRt =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_rt".trim(),	length));
				String[] dtrbXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_rt_tp_cd".trim(),	length));
				String[] dtrbFuncGainAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_gain_amt".trim(),	length));
				String[] dtrbFuncLssAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_lss_amt".trim(),	length));
				String[] exchangeRateType =	(JSPUtil.getParameter(request, prefix +	"exchange_rate_type".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SapInvoiceInterfaceDetailVO();
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
						if ( dtrbSetNm[i] !=	null)
						model.setDtrbSetNm( dtrbSetNm[i]);
						if ( dtrbCdCmbSeq[i] !=	null)
						model.setDtrbCdCmbSeq( dtrbCdCmbSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( asetCateSeq[i] !=	null)
						model.setAsetCateSeq( asetCateSeq[i]);
						if ( acctSgmCd[i] !=	null)
						model.setAcctSgmCd( acctSgmCd[i]);
						if ( prcCorrFlg[i] !=	null)
						model.setPrcCorrFlg( prcCorrFlg[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( gloAttrCtnt20[i] !=	null)
						model.setGloAttrCtnt20( gloAttrCtnt20[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( dtrbCdCombinations[i] !=	null)
						model.setDtrbCdCombinations( dtrbCdCombinations[i]);
						if ( asetTrakFlg[i] !=	null)
						model.setAsetTrakFlg( asetTrakFlg[i]);
						if ( dtrbAmt[i] !=	null)
						model.setDtrbAmt( dtrbAmt[i]);
						if ( asetBkTpCd[i] !=	null)
						model.setAsetBkTpCd( asetBkTpCd[i]);
						if ( fnlMtchStsCd[i] !=	null)
						model.setFnlMtchStsCd( fnlMtchStsCd[i]);
						if ( dtrbCoaRgnCd[i] !=	null)
						model.setDtrbCoaRgnCd( dtrbCoaRgnCd[i]);
						if ( gloAttrCtnt19[i] !=	null)
						model.setGloAttrCtnt19( gloAttrCtnt19[i]);
						if ( gloAttrCtnt17[i] !=	null)
						model.setGloAttrCtnt17( gloAttrCtnt17[i]);
						if ( gloAttrCtnt18[i] !=	null)
						model.setGloAttrCtnt18( gloAttrCtnt18[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( ifRqstSeq[i] !=	null)
						model.setIfRqstSeq( ifRqstSeq[i]);
						if ( gloAttrCtnt15[i] !=	null)
						model.setGloAttrCtnt15( gloAttrCtnt15[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( gloAttrCtnt16[i] !=	null)
						model.setGloAttrCtnt16( gloAttrCtnt16[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( invIfLineSeq[i] !=	null)
						model.setInvIfLineSeq( invIfLineSeq[i]);
						if ( gloAttrCtnt13[i] !=	null)
						model.setGloAttrCtnt13( gloAttrCtnt13[i]);
						if ( gloAttrCtnt14[i] !=	null)
						model.setGloAttrCtnt14( gloAttrCtnt14[i]);
						if ( costCtrSgmCd[i] !=	null)
						model.setCostCtrSgmCd( costCtrSgmCd[i]);
						if ( gloAttrCtnt11[i] !=	null)
						model.setGloAttrCtnt11( gloAttrCtnt11[i]);
						if ( gloAttrCtnt12[i] !=	null)
						model.setGloAttrCtnt12( gloAttrCtnt12[i]);
						if ( gloAttrCtnt10[i] !=	null)
						model.setGloAttrCtnt10( gloAttrCtnt10[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( dtrbCoaInterCoCd[i] !=	null)
						model.setDtrbCoaInterCoCd( dtrbCoaInterCoCd[i]);
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
						if ( dtrbDesc[i] !=	null)
						model.setDtrbDesc( dtrbDesc[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( gloAttrCtnt2[i] !=	null)
						model.setGloAttrCtnt2( gloAttrCtnt2[i]);
						if ( gloAttrCtnt3[i] !=	null)
						model.setGloAttrCtnt3( gloAttrCtnt3[i]);
						if ( lineTpLuCd[i] !=	null)
						model.setLineTpLuCd( lineTpLuCd[i]);
						if ( gloAttrCtnt4[i] !=	null)
						model.setGloAttrCtnt4( gloAttrCtnt4[i]);
						if ( gloAttrCtnt5[i] !=	null)
						model.setGloAttrCtnt5( gloAttrCtnt5[i]);
						if ( crCrdTjSeq[i] !=	null)
						model.setCrCrdTjSeq( crCrdTjSeq[i]);
						if ( dtrbCoaAcctNo[i] !=	null)
						model.setDtrbCoaAcctNo( dtrbCoaAcctNo[i]);
						if ( gloAttrCtnt6[i] !=	null)
						model.setGloAttrCtnt6( gloAttrCtnt6[i]);
						if ( invLineNo[i] !=	null)
						model.setInvLineNo( invLineNo[i]);
						if ( gloAttrCtnt7[i] !=	null)
						model.setGloAttrCtnt7( gloAttrCtnt7[i]);
						if ( gloAttrCtnt8[i] !=	null)
						model.setGloAttrCtnt8( gloAttrCtnt8[i]);
						if ( gloAttrCtnt9[i] !=	null)
						model.setGloAttrCtnt9( gloAttrCtnt9[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( dtrbCoaCoCd[i] !=	null)
						model.setDtrbCoaCoCd( dtrbCoaCoCd[i]);
						if ( dtrbCoaCtrCd[i] !=	null)
						model.setDtrbCoaCtrCd( dtrbCoaCtrCd[i]);
						if ( gloAttrCtnt1[i] !=	null)
						model.setGloAttrCtnt1( gloAttrCtnt1[i]);
						if ( ifSrcNm[i] !=	null)
						model.setIfSrcNm( ifSrcNm[i]);
						if ( invIfSeq[i] !=	null)
						model.setInvIfSeq( invIfSeq[i]);
						if ( gloAttrCateNm[i] !=	null)
						model.setGloAttrCateNm( gloAttrCateNm[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( balSgmCd[i] !=	null)
						model.setBalSgmCd( balSgmCd[i]);
						if ( dtrbCoaVvdCd[i] !=	null)
						model.setDtrbCoaVvdCd( dtrbCoaVvdCd[i]);
						if ( dtrbVatCd[i] !=	null)
						model.setDtrbVatCd( dtrbVatCd[i]);
						if ( lineFunctionalAmount[i] !=	null)
						model.setLineFunctionalAmount( lineFunctionalAmount[i]);
						if ( lInvRoundAmount[i] !=	null)
						model.setLInvRoundAmount( lInvRoundAmount[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( creationUser[i] !=	null)
						model.setCreationUser( creationUser[i]);
						if ( dtrbXchDt[i] !=	null)
						model.setDtrbXchDt( dtrbXchDt[i]);
						if ( dtrbXchRt[i] !=	null)
						model.setDtrbXchRt( dtrbXchRt[i]);
						if ( dtrbXchRtTpCd[i] !=	null)
						model.setDtrbXchRtTpCd( dtrbXchRtTpCd[i]);
						if ( dtrbFuncGainAmt[i] !=	null)
						model.setDtrbFuncGainAmt( dtrbFuncGainAmt[i]);
						if ( dtrbFuncLssAmt[i] !=	null)
						model.setDtrbFuncLssAmt( dtrbFuncLssAmt[i]);
						if ( exchangeRateType[i] !=	null)
						model.setExchangeRateType( exchangeRateType[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSapInvoiceInterfaceDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SapInvoiceInterfaceDetailVO[]
	 */
	public SapInvoiceInterfaceDetailVO[]	 getSapInvoiceInterfaceDetailVOs(){
		SapInvoiceInterfaceDetailVO[] vos = (SapInvoiceInterfaceDetailVO[])models.toArray(new	SapInvoiceInterfaceDetailVO[models.size()]);
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
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSetNm =	this.dtrbSetNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCmbSeq =	this.dtrbCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCateSeq =	this.asetCateSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctSgmCd =	this.acctSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCorrFlg =	this.prcCorrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt20 =	this.gloAttrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCombinations =	this.dtrbCdCombinations.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetTrakFlg =	this.asetTrakFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt =	this.dtrbAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetBkTpCd =	this.asetBkTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMtchStsCd =	this.fnlMtchStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaRgnCd =	this.dtrbCoaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt19 =	this.gloAttrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt17 =	this.gloAttrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt18 =	this.gloAttrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRqstSeq =	this.ifRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt15 =	this.gloAttrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt16 =	this.gloAttrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfLineSeq =	this.invIfLineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt13 =	this.gloAttrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt14 =	this.gloAttrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCtrSgmCd =	this.costCtrSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt11 =	this.gloAttrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt12 =	this.gloAttrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt10 =	this.gloAttrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaInterCoCd =	this.dtrbCoaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg =	this.invIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc =	this.dtrbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt2 =	this.gloAttrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt3 =	this.gloAttrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd =	this.lineTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt4 =	this.gloAttrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt5 =	this.gloAttrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCrdTjSeq =	this.crCrdTjSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaAcctNo =	this.dtrbCoaAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt6 =	this.gloAttrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLineNo =	this.invLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt7 =	this.gloAttrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt8 =	this.gloAttrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt9 =	this.gloAttrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCoCd =	this.dtrbCoaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCtrCd =	this.dtrbCoaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt1 =	this.gloAttrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSrcNm =	this.ifSrcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfSeq =	this.invIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCateNm =	this.gloAttrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balSgmCd =	this.balSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaVvdCd =	this.dtrbCoaVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatCd =	this.dtrbVatCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineFunctionalAmount =	this.lineFunctionalAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lInvRoundAmount =	this.lInvRoundAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationUser =	this.creationUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchDt =	this.dtrbXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchRt =	this.dtrbXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchRtTpCd =	this.dtrbXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncGainAmt =	this.dtrbFuncGainAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncLssAmt =	this.dtrbFuncLssAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exchangeRateType =	this.exchangeRateType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}