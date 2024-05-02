/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceEntryLineListVO.java
 *@FileTitle : InvoiceEntryLineListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.05.06  
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
public class InvoiceEntryLineListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceEntryLineListVO>  models =	new	ArrayList<InvoiceEntryLineListVO>();


	/*	Column Info	*/
	private  String	 invDtrbSeq   =  null;
	/*	Column Info	*/
	private  String	 dtrbMtchTpNm   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 dtrbLineNo   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbVatNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dtrbCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 prntRvsDtrbSeq   =  null;
	/*	Column Info	*/
	private  String	 asetAddFlg   =  null;
	/*	Column Info	*/
	private  String	 cshBkPstFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 rvsFlg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt20   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchRt   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 asetTrakFlg   =  null;
	/*	Column Info	*/
	private  String	 dtrbAmt   =  null;
	/*	Column Info	*/
	private  String	 batSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntSeq   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbFuncAmt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt19   =  null;
	/*	Column Info	*/
	private  String	 ppayDtrbSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt17   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt18   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt15   =  null;
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
	private  String	 acctgPstFlg   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaInterCoCd   =  null;
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
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 dtrbDesc   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 lineTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaAcctNo   =  null;
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
	private  String	 dtrbCoaCoCd   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbClssNm   =  null;
	/*	Column Info	*/
	private  String	 oldDtrbSeq   =  null;
	/*	Column Info	*/
	private  String	 gloAttrCateNm   =  null;
	/*	Column Info	*/
	private  String	 ppayRmnAmt   =  null;
	/*	Column Info	*/
	private  String	 acclBkPstFlg   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invRndAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbCoaVvdCd   =  null;
	/*	Column Info	*/
	private  String	 mtchStsFlg   =  null;
	/*	Column Info	*/
	private  String	 dtrbXchDt   =  null;
	/*	Column Info	*/
	private  String	 dtrbVatCd   =  null;
	/*	Column Info	*/
	private  String	 effYrmon   =  null;
	/*	Column Info	*/
	private  String	 dtrbVatRt   =  null;
	/*	Column Info	*/
	private  String	 dtrbFuncGainAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbFuncLssAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceEntryLineListVO(){}

	public InvoiceEntryLineListVO(String invDtrbSeq,String dtrbMtchTpNm,String attrCtnt10,String attrCtnt14,String attrCtnt13,String attrCtnt12,String dtrbLineNo,String attrCtnt11,String dtrbXchRtTpCd,String dtrbVatNm,String pagerows,String dtrbCdCmbSeq,String attrCtnt15,String prntRvsDtrbSeq,String asetAddFlg,String cshBkPstFlg,String attrCateNm,String rvsFlg,String updUsrId,String gloAttrCtnt20,String dtrbXchRt,String acctgDt,String creUsrId,String asetTrakFlg,String dtrbAmt,String batSeq,String acctgEvntSeq,String dtrbCoaRgnCd,String dtrbFuncAmt,String gloAttrCtnt19,String ppayDtrbSeq,String gloAttrCtnt17,String gloAttrCtnt18,String creDt,String gloAttrCtnt15,String attrCtnt9,String gloAttrCtnt16,String attrCtnt8,String gloAttrCtnt13,String invSeq,String gloAttrCtnt14,String gloAttrCtnt11,String gloAttrCtnt12,String acctgPstFlg,String gloAttrCtnt10,String dtrbCoaInterCoCd,String attrCtnt1,String ibflag,String attrCtnt2,String attrCtnt3,String attrCtnt4,String attrCtnt5,String usrId,String attrCtnt6,String attrCtnt7,String dtrbDesc,String gloAttrCtnt2,String gloAttrCtnt3,String gloAttrCtnt4,String lineTpLuCd,String gloAttrCtnt5,String dtrbCoaAcctNo,String gloAttrCtnt6,String gloAttrCtnt7,String gloAttrCtnt8,String gloAttrCtnt9,String updDt,String dtrbCoaCoCd,String gloAttrCtnt1,String dtrbCoaCtrCd,String dtrbClssNm,String oldDtrbSeq,String gloAttrCateNm,String ppayRmnAmt,String acclBkPstFlg,String invCurrCd,String invRndAmt,String dtrbCoaVvdCd,String mtchStsFlg,String dtrbXchDt,String dtrbVatCd,String effYrmon,String dtrbVatRt,String dtrbFuncGainAmt,String dtrbFuncLssAmt)	{
		this.invDtrbSeq  = invDtrbSeq ;
		this.dtrbMtchTpNm  = dtrbMtchTpNm ;
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.attrCtnt13  = attrCtnt13 ;
		this.attrCtnt12  = attrCtnt12 ;
		this.dtrbLineNo  = dtrbLineNo ;
		this.attrCtnt11  = attrCtnt11 ;
		this.dtrbXchRtTpCd  = dtrbXchRtTpCd ;
		this.dtrbVatNm  = dtrbVatNm ;
		this.pagerows  = pagerows ;
		this.dtrbCdCmbSeq  = dtrbCdCmbSeq ;
		this.attrCtnt15  = attrCtnt15 ;
		this.prntRvsDtrbSeq  = prntRvsDtrbSeq ;
		this.asetAddFlg  = asetAddFlg ;
		this.cshBkPstFlg  = cshBkPstFlg ;
		this.attrCateNm  = attrCateNm ;
		this.rvsFlg  = rvsFlg ;
		this.updUsrId  = updUsrId ;
		this.gloAttrCtnt20  = gloAttrCtnt20 ;
		this.dtrbXchRt  = dtrbXchRt ;
		this.acctgDt  = acctgDt ;
		this.creUsrId  = creUsrId ;
		this.asetTrakFlg  = asetTrakFlg ;
		this.dtrbAmt  = dtrbAmt ;
		this.batSeq  = batSeq ;
		this.acctgEvntSeq  = acctgEvntSeq ;
		this.dtrbCoaRgnCd  = dtrbCoaRgnCd ;
		this.dtrbFuncAmt  = dtrbFuncAmt ;
		this.gloAttrCtnt19  = gloAttrCtnt19 ;
		this.ppayDtrbSeq  = ppayDtrbSeq ;
		this.gloAttrCtnt17  = gloAttrCtnt17 ;
		this.gloAttrCtnt18  = gloAttrCtnt18 ;
		this.creDt  = creDt ;
		this.gloAttrCtnt15  = gloAttrCtnt15 ;
		this.attrCtnt9  = attrCtnt9 ;
		this.gloAttrCtnt16  = gloAttrCtnt16 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.gloAttrCtnt13  = gloAttrCtnt13 ;
		this.invSeq  = invSeq ;
		this.gloAttrCtnt14  = gloAttrCtnt14 ;
		this.gloAttrCtnt11  = gloAttrCtnt11 ;
		this.gloAttrCtnt12  = gloAttrCtnt12 ;
		this.acctgPstFlg  = acctgPstFlg ;
		this.gloAttrCtnt10  = gloAttrCtnt10 ;
		this.dtrbCoaInterCoCd  = dtrbCoaInterCoCd ;
		this.attrCtnt1  = attrCtnt1 ;
		this.ibflag  = ibflag ;
		this.attrCtnt2  = attrCtnt2 ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.attrCtnt5  = attrCtnt5 ;
		this.usrId  = usrId ;
		this.attrCtnt6  = attrCtnt6 ;
		this.attrCtnt7  = attrCtnt7 ;
		this.dtrbDesc  = dtrbDesc ;
		this.gloAttrCtnt2  = gloAttrCtnt2 ;
		this.gloAttrCtnt3  = gloAttrCtnt3 ;
		this.gloAttrCtnt4  = gloAttrCtnt4 ;
		this.lineTpLuCd  = lineTpLuCd ;
		this.gloAttrCtnt5  = gloAttrCtnt5 ;
		this.dtrbCoaAcctNo  = dtrbCoaAcctNo ;
		this.gloAttrCtnt6  = gloAttrCtnt6 ;
		this.gloAttrCtnt7  = gloAttrCtnt7 ;
		this.gloAttrCtnt8  = gloAttrCtnt8 ;
		this.gloAttrCtnt9  = gloAttrCtnt9 ;
		this.updDt  = updDt ;
		this.dtrbCoaCoCd  = dtrbCoaCoCd ;
		this.gloAttrCtnt1  = gloAttrCtnt1 ;
		this.dtrbCoaCtrCd  = dtrbCoaCtrCd ;
		this.dtrbClssNm  = dtrbClssNm ;
		this.oldDtrbSeq  = oldDtrbSeq ;
		this.gloAttrCateNm  = gloAttrCateNm ;
		this.ppayRmnAmt  = ppayRmnAmt ;
		this.acclBkPstFlg  = acclBkPstFlg ;
		this.invCurrCd  = invCurrCd ;
		this.invRndAmt  = invRndAmt ;
		this.dtrbCoaVvdCd  = dtrbCoaVvdCd ;
		this.mtchStsFlg  = mtchStsFlg ;
		this.dtrbXchDt  = dtrbXchDt ;
		this.dtrbVatCd  = dtrbVatCd ;
		this.effYrmon  = effYrmon ;
		this.dtrbVatRt  = dtrbVatRt ;
		this.dtrbFuncGainAmt  = dtrbFuncGainAmt ;
		this.dtrbFuncLssAmt  = dtrbFuncLssAmt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_dtrb_seq", getInvDtrbSeq());		
		this.hashColumns.put("dtrb_mtch_tp_nm", getDtrbMtchTpNm());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("dtrb_line_no", getDtrbLineNo());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("dtrb_xch_rt_tp_cd", getDtrbXchRtTpCd());		
		this.hashColumns.put("dtrb_vat_nm", getDtrbVatNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dtrb_cd_cmb_seq", getDtrbCdCmbSeq());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("prnt_rvs_dtrb_seq", getPrntRvsDtrbSeq());		
		this.hashColumns.put("aset_add_flg", getAsetAddFlg());		
		this.hashColumns.put("csh_bk_pst_flg", getCshBkPstFlg());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("rvs_flg", getRvsFlg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("glo_attr_ctnt20", getGloAttrCtnt20());		
		this.hashColumns.put("dtrb_xch_rt", getDtrbXchRt());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("aset_trak_flg", getAsetTrakFlg());		
		this.hashColumns.put("dtrb_amt", getDtrbAmt());		
		this.hashColumns.put("bat_seq", getBatSeq());		
		this.hashColumns.put("acctg_evnt_seq", getAcctgEvntSeq());		
		this.hashColumns.put("dtrb_coa_rgn_cd", getDtrbCoaRgnCd());		
		this.hashColumns.put("dtrb_func_amt", getDtrbFuncAmt());		
		this.hashColumns.put("glo_attr_ctnt19", getGloAttrCtnt19());		
		this.hashColumns.put("ppay_dtrb_seq", getPpayDtrbSeq());		
		this.hashColumns.put("glo_attr_ctnt17", getGloAttrCtnt17());		
		this.hashColumns.put("glo_attr_ctnt18", getGloAttrCtnt18());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("glo_attr_ctnt15", getGloAttrCtnt15());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("glo_attr_ctnt16", getGloAttrCtnt16());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt13", getGloAttrCtnt13());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("glo_attr_ctnt14", getGloAttrCtnt14());		
		this.hashColumns.put("glo_attr_ctnt11", getGloAttrCtnt11());		
		this.hashColumns.put("glo_attr_ctnt12", getGloAttrCtnt12());		
		this.hashColumns.put("acctg_pst_flg", getAcctgPstFlg());		
		this.hashColumns.put("glo_attr_ctnt10", getGloAttrCtnt10());		
		this.hashColumns.put("dtrb_coa_inter_co_cd", getDtrbCoaInterCoCd());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("dtrb_desc", getDtrbDesc());		
		this.hashColumns.put("glo_attr_ctnt2", getGloAttrCtnt2());		
		this.hashColumns.put("glo_attr_ctnt3", getGloAttrCtnt3());		
		this.hashColumns.put("glo_attr_ctnt4", getGloAttrCtnt4());		
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());		
		this.hashColumns.put("glo_attr_ctnt5", getGloAttrCtnt5());		
		this.hashColumns.put("dtrb_coa_acct_no", getDtrbCoaAcctNo());		
		this.hashColumns.put("glo_attr_ctnt6", getGloAttrCtnt6());		
		this.hashColumns.put("glo_attr_ctnt7", getGloAttrCtnt7());		
		this.hashColumns.put("glo_attr_ctnt8", getGloAttrCtnt8());		
		this.hashColumns.put("glo_attr_ctnt9", getGloAttrCtnt9());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("dtrb_coa_co_cd", getDtrbCoaCoCd());		
		this.hashColumns.put("glo_attr_ctnt1", getGloAttrCtnt1());		
		this.hashColumns.put("dtrb_coa_ctr_cd", getDtrbCoaCtrCd());		
		this.hashColumns.put("dtrb_clss_nm", getDtrbClssNm());		
		this.hashColumns.put("old_dtrb_seq", getOldDtrbSeq());		
		this.hashColumns.put("glo_attr_cate_nm", getGloAttrCateNm());		
		this.hashColumns.put("ppay_rmn_amt", getPpayRmnAmt());		
		this.hashColumns.put("accl_bk_pst_flg", getAcclBkPstFlg());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_rnd_amt", getInvRndAmt());		
		this.hashColumns.put("dtrb_coa_vvd_cd", getDtrbCoaVvdCd());		
		this.hashColumns.put("mtch_sts_flg", getMtchStsFlg());		
		this.hashColumns.put("dtrb_xch_dt", getDtrbXchDt());		
		this.hashColumns.put("dtrb_vat_cd", getDtrbVatCd());		
		this.hashColumns.put("eff_yrmon", getEffYrmon());		
		this.hashColumns.put("dtrb_vat_rt", getDtrbVatRt());		
		this.hashColumns.put("dtrb_func_gain_amt", getDtrbFuncGainAmt());		
		this.hashColumns.put("dtrb_func_lss_amt", getDtrbFuncLssAmt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_dtrb_seq", "invDtrbSeq");
		this.hashFields.put("dtrb_mtch_tp_nm", "dtrbMtchTpNm");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("dtrb_line_no", "dtrbLineNo");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("dtrb_xch_rt_tp_cd", "dtrbXchRtTpCd");
		this.hashFields.put("dtrb_vat_nm", "dtrbVatNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dtrb_cd_cmb_seq", "dtrbCdCmbSeq");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("prnt_rvs_dtrb_seq", "prntRvsDtrbSeq");
		this.hashFields.put("aset_add_flg", "asetAddFlg");
		this.hashFields.put("csh_bk_pst_flg", "cshBkPstFlg");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("glo_attr_ctnt20", "gloAttrCtnt20");
		this.hashFields.put("dtrb_xch_rt", "dtrbXchRt");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("aset_trak_flg", "asetTrakFlg");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("bat_seq", "batSeq");
		this.hashFields.put("acctg_evnt_seq", "acctgEvntSeq");
		this.hashFields.put("dtrb_coa_rgn_cd", "dtrbCoaRgnCd");
		this.hashFields.put("dtrb_func_amt", "dtrbFuncAmt");
		this.hashFields.put("glo_attr_ctnt19", "gloAttrCtnt19");
		this.hashFields.put("ppay_dtrb_seq", "ppayDtrbSeq");
		this.hashFields.put("glo_attr_ctnt17", "gloAttrCtnt17");
		this.hashFields.put("glo_attr_ctnt18", "gloAttrCtnt18");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("glo_attr_ctnt15", "gloAttrCtnt15");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("glo_attr_ctnt16", "gloAttrCtnt16");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("glo_attr_ctnt13", "gloAttrCtnt13");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("glo_attr_ctnt14", "gloAttrCtnt14");
		this.hashFields.put("glo_attr_ctnt11", "gloAttrCtnt11");
		this.hashFields.put("glo_attr_ctnt12", "gloAttrCtnt12");
		this.hashFields.put("acctg_pst_flg", "acctgPstFlg");
		this.hashFields.put("glo_attr_ctnt10", "gloAttrCtnt10");
		this.hashFields.put("dtrb_coa_inter_co_cd", "dtrbCoaInterCoCd");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("glo_attr_ctnt2", "gloAttrCtnt2");
		this.hashFields.put("glo_attr_ctnt3", "gloAttrCtnt3");
		this.hashFields.put("glo_attr_ctnt4", "gloAttrCtnt4");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("glo_attr_ctnt5", "gloAttrCtnt5");
		this.hashFields.put("dtrb_coa_acct_no", "dtrbCoaAcctNo");
		this.hashFields.put("glo_attr_ctnt6", "gloAttrCtnt6");
		this.hashFields.put("glo_attr_ctnt7", "gloAttrCtnt7");
		this.hashFields.put("glo_attr_ctnt8", "gloAttrCtnt8");
		this.hashFields.put("glo_attr_ctnt9", "gloAttrCtnt9");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dtrb_coa_co_cd", "dtrbCoaCoCd");
		this.hashFields.put("glo_attr_ctnt1", "gloAttrCtnt1");
		this.hashFields.put("dtrb_coa_ctr_cd", "dtrbCoaCtrCd");
		this.hashFields.put("dtrb_clss_nm", "dtrbClssNm");
		this.hashFields.put("old_dtrb_seq", "oldDtrbSeq");
		this.hashFields.put("glo_attr_cate_nm", "gloAttrCateNm");
		this.hashFields.put("ppay_rmn_amt", "ppayRmnAmt");
		this.hashFields.put("accl_bk_pst_flg", "acclBkPstFlg");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_rnd_amt", "invRndAmt");
		this.hashFields.put("dtrb_coa_vvd_cd", "dtrbCoaVvdCd");
		this.hashFields.put("mtch_sts_flg", "mtchStsFlg");
		this.hashFields.put("dtrb_xch_dt", "dtrbXchDt");
		this.hashFields.put("dtrb_vat_cd", "dtrbVatCd");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("dtrb_vat_rt", "dtrbVatRt");
		this.hashFields.put("dtrb_func_gain_amt", "dtrbFuncGainAmt");
		this.hashFields.put("dtrb_func_lss_amt", "dtrbFuncLssAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  invDtrbSeq
	*/
	public void	setInvDtrbSeq( String	invDtrbSeq ) {
		this.invDtrbSeq =	invDtrbSeq;
	}
 
	/**
	 * Column Info
	 * @return	invDtrbSeq
	 */
	 public	String	getInvDtrbSeq() {
		 return	this.invDtrbSeq;
	 } 
 	/**
	* Column Info
	* @param  dtrbMtchTpNm
	*/
	public void	setDtrbMtchTpNm( String	dtrbMtchTpNm ) {
		this.dtrbMtchTpNm =	dtrbMtchTpNm;
	}
 
	/**
	 * Column Info
	 * @return	dtrbMtchTpNm
	 */
	 public	String	getDtrbMtchTpNm() {
		 return	this.dtrbMtchTpNm;
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
	* @param  dtrbLineNo
	*/
	public void	setDtrbLineNo( String	dtrbLineNo ) {
		this.dtrbLineNo =	dtrbLineNo;
	}
 
	/**
	 * Column Info
	 * @return	dtrbLineNo
	 */
	 public	String	getDtrbLineNo() {
		 return	this.dtrbLineNo;
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
	* @param  dtrbVatNm
	*/
	public void	setDtrbVatNm( String	dtrbVatNm ) {
		this.dtrbVatNm =	dtrbVatNm;
	}
 
	/**
	 * Column Info
	 * @return	dtrbVatNm
	 */
	 public	String	getDtrbVatNm() {
		 return	this.dtrbVatNm;
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
	* @param  prntRvsDtrbSeq
	*/
	public void	setPrntRvsDtrbSeq( String	prntRvsDtrbSeq ) {
		this.prntRvsDtrbSeq =	prntRvsDtrbSeq;
	}
 
	/**
	 * Column Info
	 * @return	prntRvsDtrbSeq
	 */
	 public	String	getPrntRvsDtrbSeq() {
		 return	this.prntRvsDtrbSeq;
	 } 
 	/**
	* Column Info
	* @param  asetAddFlg
	*/
	public void	setAsetAddFlg( String	asetAddFlg ) {
		this.asetAddFlg =	asetAddFlg;
	}
 
	/**
	 * Column Info
	 * @return	asetAddFlg
	 */
	 public	String	getAsetAddFlg() {
		 return	this.asetAddFlg;
	 } 
 	/**
	* Column Info
	* @param  cshBkPstFlg
	*/
	public void	setCshBkPstFlg( String	cshBkPstFlg ) {
		this.cshBkPstFlg =	cshBkPstFlg;
	}
 
	/**
	 * Column Info
	 * @return	cshBkPstFlg
	 */
	 public	String	getCshBkPstFlg() {
		 return	this.cshBkPstFlg;
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
	* @param  rvsFlg
	*/
	public void	setRvsFlg( String	rvsFlg ) {
		this.rvsFlg =	rvsFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsFlg
	 */
	 public	String	getRvsFlg() {
		 return	this.rvsFlg;
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
	* @param  acctgEvntSeq
	*/
	public void	setAcctgEvntSeq( String	acctgEvntSeq ) {
		this.acctgEvntSeq =	acctgEvntSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntSeq
	 */
	 public	String	getAcctgEvntSeq() {
		 return	this.acctgEvntSeq;
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
	* @param  dtrbFuncAmt
	*/
	public void	setDtrbFuncAmt( String	dtrbFuncAmt ) {
		this.dtrbFuncAmt =	dtrbFuncAmt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbFuncAmt
	 */
	 public	String	getDtrbFuncAmt() {
		 return	this.dtrbFuncAmt;
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
	* @param  ppayDtrbSeq
	*/
	public void	setPpayDtrbSeq( String	ppayDtrbSeq ) {
		this.ppayDtrbSeq =	ppayDtrbSeq;
	}
 
	/**
	 * Column Info
	 * @return	ppayDtrbSeq
	 */
	 public	String	getPpayDtrbSeq() {
		 return	this.ppayDtrbSeq;
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
	* @param  acctgPstFlg
	*/
	public void	setAcctgPstFlg( String	acctgPstFlg ) {
		this.acctgPstFlg =	acctgPstFlg;
	}
 
	/**
	 * Column Info
	 * @return	acctgPstFlg
	 */
	 public	String	getAcctgPstFlg() {
		 return	this.acctgPstFlg;
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
	* @param  dtrbClssNm
	*/
	public void	setDtrbClssNm( String	dtrbClssNm ) {
		this.dtrbClssNm =	dtrbClssNm;
	}
 
	/**
	 * Column Info
	 * @return	dtrbClssNm
	 */
	 public	String	getDtrbClssNm() {
		 return	this.dtrbClssNm;
	 } 
 	/**
	* Column Info
	* @param  oldDtrbSeq
	*/
	public void	setOldDtrbSeq( String	oldDtrbSeq ) {
		this.oldDtrbSeq =	oldDtrbSeq;
	}
 
	/**
	 * Column Info
	 * @return	oldDtrbSeq
	 */
	 public	String	getOldDtrbSeq() {
		 return	this.oldDtrbSeq;
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
	* @param  ppayRmnAmt
	*/
	public void	setPpayRmnAmt( String	ppayRmnAmt ) {
		this.ppayRmnAmt =	ppayRmnAmt;
	}
 
	/**
	 * Column Info
	 * @return	ppayRmnAmt
	 */
	 public	String	getPpayRmnAmt() {
		 return	this.ppayRmnAmt;
	 } 
 	/**
	* Column Info
	* @param  acclBkPstFlg
	*/
	public void	setAcclBkPstFlg( String	acclBkPstFlg ) {
		this.acclBkPstFlg =	acclBkPstFlg;
	}
 
	/**
	 * Column Info
	 * @return	acclBkPstFlg
	 */
	 public	String	getAcclBkPstFlg() {
		 return	this.acclBkPstFlg;
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
	* @param  invRndAmt
	*/
	public void	setInvRndAmt( String	invRndAmt ) {
		this.invRndAmt =	invRndAmt;
	}
 
	/**
	 * Column Info
	 * @return	invRndAmt
	 */
	 public	String	getInvRndAmt() {
		 return	this.invRndAmt;
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
	* @param  mtchStsFlg
	*/
	public void	setMtchStsFlg( String	mtchStsFlg ) {
		this.mtchStsFlg =	mtchStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	mtchStsFlg
	 */
	 public	String	getMtchStsFlg() {
		 return	this.mtchStsFlg;
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
	* @param  effYrmon
	*/
	public void	setEffYrmon( String	effYrmon ) {
		this.effYrmon =	effYrmon;
	}
 
	/**
	 * Column Info
	 * @return	effYrmon
	 */
	 public	String	getEffYrmon() {
		 return	this.effYrmon;
	 } 
 	/**
	* Column Info
	* @param  dtrbVatRt
	*/
	public void	setDtrbVatRt( String	dtrbVatRt ) {
		this.dtrbVatRt =	dtrbVatRt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbVatRt
	 */
	 public	String	getDtrbVatRt() {
		 return	this.dtrbVatRt;
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
		setInvDtrbSeq(JSPUtil.getParameter(request,	prefix + "inv_dtrb_seq", ""));
		setDtrbMtchTpNm(JSPUtil.getParameter(request,	prefix + "dtrb_mtch_tp_nm", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setDtrbLineNo(JSPUtil.getParameter(request,	prefix + "dtrb_line_no", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setDtrbXchRtTpCd(JSPUtil.getParameter(request,	prefix + "dtrb_xch_rt_tp_cd", ""));
		setDtrbVatNm(JSPUtil.getParameter(request,	prefix + "dtrb_vat_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDtrbCdCmbSeq(JSPUtil.getParameter(request,	prefix + "dtrb_cd_cmb_seq", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setPrntRvsDtrbSeq(JSPUtil.getParameter(request,	prefix + "prnt_rvs_dtrb_seq", ""));
		setAsetAddFlg(JSPUtil.getParameter(request,	prefix + "aset_add_flg", ""));
		setCshBkPstFlg(JSPUtil.getParameter(request,	prefix + "csh_bk_pst_flg", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setRvsFlg(JSPUtil.getParameter(request,	prefix + "rvs_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setGloAttrCtnt20(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt20", ""));
		setDtrbXchRt(JSPUtil.getParameter(request,	prefix + "dtrb_xch_rt", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setAsetTrakFlg(JSPUtil.getParameter(request,	prefix + "aset_trak_flg", ""));
		setDtrbAmt(JSPUtil.getParameter(request,	prefix + "dtrb_amt", ""));
		setBatSeq(JSPUtil.getParameter(request,	prefix + "bat_seq", ""));
		setAcctgEvntSeq(JSPUtil.getParameter(request,	prefix + "acctg_evnt_seq", ""));
		setDtrbCoaRgnCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_rgn_cd", ""));
		setDtrbFuncAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_amt", ""));
		setGloAttrCtnt19(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt19", ""));
		setPpayDtrbSeq(JSPUtil.getParameter(request,	prefix + "ppay_dtrb_seq", ""));
		setGloAttrCtnt17(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt17", ""));
		setGloAttrCtnt18(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt18", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setGloAttrCtnt15(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt15", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setGloAttrCtnt16(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt16", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setGloAttrCtnt13(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt13", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setGloAttrCtnt14(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt14", ""));
		setGloAttrCtnt11(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt11", ""));
		setGloAttrCtnt12(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt12", ""));
		setAcctgPstFlg(JSPUtil.getParameter(request,	prefix + "acctg_pst_flg", ""));
		setGloAttrCtnt10(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt10", ""));
		setDtrbCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_inter_co_cd", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setDtrbDesc(JSPUtil.getParameter(request,	prefix + "dtrb_desc", ""));
		setGloAttrCtnt2(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt2", ""));
		setGloAttrCtnt3(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt3", ""));
		setGloAttrCtnt4(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt4", ""));
		setLineTpLuCd(JSPUtil.getParameter(request,	prefix + "line_tp_lu_cd", ""));
		setGloAttrCtnt5(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt5", ""));
		setDtrbCoaAcctNo(JSPUtil.getParameter(request,	prefix + "dtrb_coa_acct_no", ""));
		setGloAttrCtnt6(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt6", ""));
		setGloAttrCtnt7(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt7", ""));
		setGloAttrCtnt8(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt8", ""));
		setGloAttrCtnt9(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt9", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setDtrbCoaCoCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_co_cd", ""));
		setGloAttrCtnt1(JSPUtil.getParameter(request,	prefix + "glo_attr_ctnt1", ""));
		setDtrbCoaCtrCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_ctr_cd", ""));
		setDtrbClssNm(JSPUtil.getParameter(request,	prefix + "dtrb_clss_nm", ""));
		setOldDtrbSeq(JSPUtil.getParameter(request,	prefix + "old_dtrb_seq", ""));
		setGloAttrCateNm(JSPUtil.getParameter(request,	prefix + "glo_attr_cate_nm", ""));
		setPpayRmnAmt(JSPUtil.getParameter(request,	prefix + "ppay_rmn_amt", ""));
		setAcclBkPstFlg(JSPUtil.getParameter(request,	prefix + "accl_bk_pst_flg", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvRndAmt(JSPUtil.getParameter(request,	prefix + "inv_rnd_amt", ""));
		setDtrbCoaVvdCd(JSPUtil.getParameter(request,	prefix + "dtrb_coa_vvd_cd", ""));
		setMtchStsFlg(JSPUtil.getParameter(request,	prefix + "mtch_sts_flg", ""));
		setDtrbXchDt(JSPUtil.getParameter(request,	prefix + "dtrb_xch_dt", ""));
		setDtrbVatCd(JSPUtil.getParameter(request,	prefix + "dtrb_vat_cd", ""));
		setEffYrmon(JSPUtil.getParameter(request,	prefix + "eff_yrmon", ""));
		setDtrbVatRt(JSPUtil.getParameter(request,	prefix + "dtrb_vat_rt", ""));
		setDtrbFuncGainAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_gain_amt", ""));
		setDtrbFuncLssAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_lss_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceEntryLineListVO[]
	 */
	public InvoiceEntryLineListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceEntryLineListVO[]
	 */
	public InvoiceEntryLineListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceEntryLineListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invDtrbSeq =	(JSPUtil.getParameter(request, prefix +	"inv_dtrb_seq".trim(),	length));
				String[] dtrbMtchTpNm =	(JSPUtil.getParameter(request, prefix +	"dtrb_mtch_tp_nm".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] dtrbLineNo =	(JSPUtil.getParameter(request, prefix +	"dtrb_line_no".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] dtrbXchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_rt_tp_cd".trim(),	length));
				String[] dtrbVatNm =	(JSPUtil.getParameter(request, prefix +	"dtrb_vat_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dtrbCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"dtrb_cd_cmb_seq".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] prntRvsDtrbSeq =	(JSPUtil.getParameter(request, prefix +	"prnt_rvs_dtrb_seq".trim(),	length));
				String[] asetAddFlg =	(JSPUtil.getParameter(request, prefix +	"aset_add_flg".trim(),	length));
				String[] cshBkPstFlg =	(JSPUtil.getParameter(request, prefix +	"csh_bk_pst_flg".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] rvsFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_flg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] gloAttrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt20".trim(),	length));
				String[] dtrbXchRt =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_rt".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] asetTrakFlg =	(JSPUtil.getParameter(request, prefix +	"aset_trak_flg".trim(),	length));
				String[] dtrbAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_amt".trim(),	length));
				String[] batSeq =	(JSPUtil.getParameter(request, prefix +	"bat_seq".trim(),	length));
				String[] acctgEvntSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_seq".trim(),	length));
				String[] dtrbCoaRgnCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_rgn_cd".trim(),	length));
				String[] dtrbFuncAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_amt".trim(),	length));
				String[] gloAttrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt19".trim(),	length));
				String[] ppayDtrbSeq =	(JSPUtil.getParameter(request, prefix +	"ppay_dtrb_seq".trim(),	length));
				String[] gloAttrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt17".trim(),	length));
				String[] gloAttrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt18".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] gloAttrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt15".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] gloAttrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt16".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt13".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] gloAttrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt14".trim(),	length));
				String[] gloAttrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt11".trim(),	length));
				String[] gloAttrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt12".trim(),	length));
				String[] acctgPstFlg =	(JSPUtil.getParameter(request, prefix +	"acctg_pst_flg".trim(),	length));
				String[] gloAttrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt10".trim(),	length));
				String[] dtrbCoaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_inter_co_cd".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] dtrbDesc =	(JSPUtil.getParameter(request, prefix +	"dtrb_desc".trim(),	length));
				String[] gloAttrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt2".trim(),	length));
				String[] gloAttrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt3".trim(),	length));
				String[] gloAttrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt4".trim(),	length));
				String[] lineTpLuCd =	(JSPUtil.getParameter(request, prefix +	"line_tp_lu_cd".trim(),	length));
				String[] gloAttrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt5".trim(),	length));
				String[] dtrbCoaAcctNo =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_acct_no".trim(),	length));
				String[] gloAttrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt6".trim(),	length));
				String[] gloAttrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt7".trim(),	length));
				String[] gloAttrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt8".trim(),	length));
				String[] gloAttrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt9".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] dtrbCoaCoCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_co_cd".trim(),	length));
				String[] gloAttrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"glo_attr_ctnt1".trim(),	length));
				String[] dtrbCoaCtrCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_ctr_cd".trim(),	length));
				String[] dtrbClssNm =	(JSPUtil.getParameter(request, prefix +	"dtrb_clss_nm".trim(),	length));
				String[] oldDtrbSeq =	(JSPUtil.getParameter(request, prefix +	"old_dtrb_seq".trim(),	length));
				String[] gloAttrCateNm =	(JSPUtil.getParameter(request, prefix +	"glo_attr_cate_nm".trim(),	length));
				String[] ppayRmnAmt =	(JSPUtil.getParameter(request, prefix +	"ppay_rmn_amt".trim(),	length));
				String[] acclBkPstFlg =	(JSPUtil.getParameter(request, prefix +	"accl_bk_pst_flg".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invRndAmt =	(JSPUtil.getParameter(request, prefix +	"inv_rnd_amt".trim(),	length));
				String[] dtrbCoaVvdCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa_vvd_cd".trim(),	length));
				String[] mtchStsFlg =	(JSPUtil.getParameter(request, prefix +	"mtch_sts_flg".trim(),	length));
				String[] dtrbXchDt =	(JSPUtil.getParameter(request, prefix +	"dtrb_xch_dt".trim(),	length));
				String[] dtrbVatCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_vat_cd".trim(),	length));
				String[] effYrmon =	(JSPUtil.getParameter(request, prefix +	"eff_yrmon".trim(),	length));
				String[] dtrbVatRt =	(JSPUtil.getParameter(request, prefix +	"dtrb_vat_rt".trim(),	length));
				String[] dtrbFuncGainAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_gain_amt".trim(),	length));
				String[] dtrbFuncLssAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_lss_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceEntryLineListVO();
						if ( invDtrbSeq[i] !=	null)
						model.setInvDtrbSeq( invDtrbSeq[i]);
						if ( dtrbMtchTpNm[i] !=	null)
						model.setDtrbMtchTpNm( dtrbMtchTpNm[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( attrCtnt14[i] !=	null)
						model.setAttrCtnt14( attrCtnt14[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( attrCtnt12[i] !=	null)
						model.setAttrCtnt12( attrCtnt12[i]);
						if ( dtrbLineNo[i] !=	null)
						model.setDtrbLineNo( dtrbLineNo[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
						if ( dtrbXchRtTpCd[i] !=	null)
						model.setDtrbXchRtTpCd( dtrbXchRtTpCd[i]);
						if ( dtrbVatNm[i] !=	null)
						model.setDtrbVatNm( dtrbVatNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dtrbCdCmbSeq[i] !=	null)
						model.setDtrbCdCmbSeq( dtrbCdCmbSeq[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( prntRvsDtrbSeq[i] !=	null)
						model.setPrntRvsDtrbSeq( prntRvsDtrbSeq[i]);
						if ( asetAddFlg[i] !=	null)
						model.setAsetAddFlg( asetAddFlg[i]);
						if ( cshBkPstFlg[i] !=	null)
						model.setCshBkPstFlg( cshBkPstFlg[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( rvsFlg[i] !=	null)
						model.setRvsFlg( rvsFlg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( gloAttrCtnt20[i] !=	null)
						model.setGloAttrCtnt20( gloAttrCtnt20[i]);
						if ( dtrbXchRt[i] !=	null)
						model.setDtrbXchRt( dtrbXchRt[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( asetTrakFlg[i] !=	null)
						model.setAsetTrakFlg( asetTrakFlg[i]);
						if ( dtrbAmt[i] !=	null)
						model.setDtrbAmt( dtrbAmt[i]);
						if ( batSeq[i] !=	null)
						model.setBatSeq( batSeq[i]);
						if ( acctgEvntSeq[i] !=	null)
						model.setAcctgEvntSeq( acctgEvntSeq[i]);
						if ( dtrbCoaRgnCd[i] !=	null)
						model.setDtrbCoaRgnCd( dtrbCoaRgnCd[i]);
						if ( dtrbFuncAmt[i] !=	null)
						model.setDtrbFuncAmt( dtrbFuncAmt[i]);
						if ( gloAttrCtnt19[i] !=	null)
						model.setGloAttrCtnt19( gloAttrCtnt19[i]);
						if ( ppayDtrbSeq[i] !=	null)
						model.setPpayDtrbSeq( ppayDtrbSeq[i]);
						if ( gloAttrCtnt17[i] !=	null)
						model.setGloAttrCtnt17( gloAttrCtnt17[i]);
						if ( gloAttrCtnt18[i] !=	null)
						model.setGloAttrCtnt18( gloAttrCtnt18[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( gloAttrCtnt15[i] !=	null)
						model.setGloAttrCtnt15( gloAttrCtnt15[i]);
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
						if ( acctgPstFlg[i] !=	null)
						model.setAcctgPstFlg( acctgPstFlg[i]);
						if ( gloAttrCtnt10[i] !=	null)
						model.setGloAttrCtnt10( gloAttrCtnt10[i]);
						if ( dtrbCoaInterCoCd[i] !=	null)
						model.setDtrbCoaInterCoCd( dtrbCoaInterCoCd[i]);
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
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( dtrbDesc[i] !=	null)
						model.setDtrbDesc( dtrbDesc[i]);
						if ( gloAttrCtnt2[i] !=	null)
						model.setGloAttrCtnt2( gloAttrCtnt2[i]);
						if ( gloAttrCtnt3[i] !=	null)
						model.setGloAttrCtnt3( gloAttrCtnt3[i]);
						if ( gloAttrCtnt4[i] !=	null)
						model.setGloAttrCtnt4( gloAttrCtnt4[i]);
						if ( lineTpLuCd[i] !=	null)
						model.setLineTpLuCd( lineTpLuCd[i]);
						if ( gloAttrCtnt5[i] !=	null)
						model.setGloAttrCtnt5( gloAttrCtnt5[i]);
						if ( dtrbCoaAcctNo[i] !=	null)
						model.setDtrbCoaAcctNo( dtrbCoaAcctNo[i]);
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
						if ( dtrbCoaCoCd[i] !=	null)
						model.setDtrbCoaCoCd( dtrbCoaCoCd[i]);
						if ( gloAttrCtnt1[i] !=	null)
						model.setGloAttrCtnt1( gloAttrCtnt1[i]);
						if ( dtrbCoaCtrCd[i] !=	null)
						model.setDtrbCoaCtrCd( dtrbCoaCtrCd[i]);
						if ( dtrbClssNm[i] !=	null)
						model.setDtrbClssNm( dtrbClssNm[i]);
						if ( oldDtrbSeq[i] !=	null)
						model.setOldDtrbSeq( oldDtrbSeq[i]);
						if ( gloAttrCateNm[i] !=	null)
						model.setGloAttrCateNm( gloAttrCateNm[i]);
						if ( ppayRmnAmt[i] !=	null)
						model.setPpayRmnAmt( ppayRmnAmt[i]);
						if ( acclBkPstFlg[i] !=	null)
						model.setAcclBkPstFlg( acclBkPstFlg[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invRndAmt[i] !=	null)
						model.setInvRndAmt( invRndAmt[i]);
						if ( dtrbCoaVvdCd[i] !=	null)
						model.setDtrbCoaVvdCd( dtrbCoaVvdCd[i]);
						if ( mtchStsFlg[i] !=	null)
						model.setMtchStsFlg( mtchStsFlg[i]);
						if ( dtrbXchDt[i] !=	null)
						model.setDtrbXchDt( dtrbXchDt[i]);
						if ( dtrbVatCd[i] !=	null)
						model.setDtrbVatCd( dtrbVatCd[i]);
						if ( effYrmon[i] !=	null)
						model.setEffYrmon( effYrmon[i]);
						if ( dtrbVatRt[i] !=	null)
						model.setDtrbVatRt( dtrbVatRt[i]);
						if ( dtrbFuncGainAmt[i] !=	null)
						model.setDtrbFuncGainAmt( dtrbFuncGainAmt[i]);
						if ( dtrbFuncLssAmt[i] !=	null)
						model.setDtrbFuncLssAmt( dtrbFuncLssAmt[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceEntryLineListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceEntryLineListVO[]
	 */
	public InvoiceEntryLineListVO[]	 getInvoiceEntryLineListVOs(){
		InvoiceEntryLineListVO[] vos = (InvoiceEntryLineListVO[])models.toArray(new	InvoiceEntryLineListVO[models.size()]);
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
		this.invDtrbSeq =	this.invDtrbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbMtchTpNm =	this.dtrbMtchTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbLineNo =	this.dtrbLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchRtTpCd =	this.dtrbXchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatNm =	this.dtrbVatNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCmbSeq =	this.dtrbCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntRvsDtrbSeq =	this.prntRvsDtrbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetAddFlg =	this.asetAddFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cshBkPstFlg =	this.cshBkPstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg =	this.rvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt20 =	this.gloAttrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchRt =	this.dtrbXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetTrakFlg =	this.asetTrakFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt =	this.dtrbAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSeq =	this.batSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntSeq =	this.acctgEvntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaRgnCd =	this.dtrbCoaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncAmt =	this.dtrbFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt19 =	this.gloAttrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayDtrbSeq =	this.ppayDtrbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt17 =	this.gloAttrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt18 =	this.gloAttrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt15 =	this.gloAttrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt16 =	this.gloAttrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt13 =	this.gloAttrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt14 =	this.gloAttrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt11 =	this.gloAttrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt12 =	this.gloAttrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgPstFlg =	this.acctgPstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt10 =	this.gloAttrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaInterCoCd =	this.dtrbCoaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc =	this.dtrbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt2 =	this.gloAttrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt3 =	this.gloAttrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt4 =	this.gloAttrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd =	this.lineTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt5 =	this.gloAttrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaAcctNo =	this.dtrbCoaAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt6 =	this.gloAttrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt7 =	this.gloAttrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt8 =	this.gloAttrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt9 =	this.gloAttrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCoCd =	this.dtrbCoaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCtnt1 =	this.gloAttrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaCtrCd =	this.dtrbCoaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbClssNm =	this.dtrbClssNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDtrbSeq =	this.oldDtrbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gloAttrCateNm =	this.gloAttrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayRmnAmt =	this.ppayRmnAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclBkPstFlg =	this.acclBkPstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRndAmt =	this.invRndAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoaVvdCd =	this.dtrbCoaVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchStsFlg =	this.mtchStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbXchDt =	this.dtrbXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatCd =	this.dtrbVatCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon =	this.effYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbVatRt =	this.dtrbVatRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncGainAmt =	this.dtrbFuncGainAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncLssAmt =	this.dtrbFuncLssAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}