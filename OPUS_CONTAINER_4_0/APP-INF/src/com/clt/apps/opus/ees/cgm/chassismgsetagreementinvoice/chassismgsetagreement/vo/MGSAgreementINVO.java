/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MGSAgreementINVO.java
 *@FileTitle : MGSAgreementINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
public class MGSAgreementINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MGSAgreementINVO>  models =	new	ArrayList<MGSAgreementINVO>();


	/*	Column Info	*/
	private  String	 agmtEffDt   =  null;
	/*	Column Info	*/
	private  String	 lstVerFlg   =  null;
	/*	Column Info	*/
	private  String	 mgstPotcScgRtAmt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 preEffDt   =  null;
	/*	Column Info	*/
	private  String	 onhInitValAmtUmg   =  null;
	/*	Column Info	*/
	private  String	 agmtDt   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 onhInitValAmt   =  null;
	/*	Column Info	*/
	private  String	 mgstBldpRtAmtUmg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 monDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 mgstBldpRtAmt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 agmtIssOfcCd   =  null;
	/*	Column Info	*/
	private  String	 offhHndlRtAmt   =  null;
	/*	Column Info	*/
	private  String	 agmtExpDt   =  null;
	/*	Column Info	*/
	private  String	 actionFlag   =  null;
	/*	Column Info	*/
	private  String	 mgstPotcScgRtAmtClg   =  null;
	/*	Column Info	*/
	private  String	 mgstLseFxRtAmtClg   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 onhHndlRtAmt   =  null;
	/*	Column Info	*/
	private  String	 onhInitValAmtClg   =  null;
	/*	Column Info	*/
	private  String	 mgstPrtcScgRtAmt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 preExpDt   =  null;
	/*	Column Info	*/
	private  String	 agmtRefNo   =  null;
	/*	Column Info	*/
	private  String	 mgstPotcScgRtAmtUmg   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 agmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 initDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 payTermDys   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 diffRmk   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 maxDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 mgstPrtcScgRtAmtUmg   =  null;
	/*	Column Info	*/
	private  String	 mgstLseFxRtAmt   =  null;
	/*	Column Info	*/
	private  String	 mgstLseFxRtAmtUmg   =  null;
	/*	Column Info	*/
	private  String	 agmtVerNo   =  null;
	/*	Column Info	*/
	private  String	 mgstBldpRtAmtClg   =  null;
	/*	Column Info	*/
	private  String	 mgstPrtcScgRtAmtClg   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd1   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd2   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd3   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd5   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd6   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd7   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd8   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd9   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd10   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd11   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd12   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd13   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd14   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd15   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd16   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd17   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd18   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd19   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd20   =  null;
	/*	Column Info	*/
	private  String	 agmtCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MGSAgreementINVO(){}

	public MGSAgreementINVO(String agmtEffDt,String lstVerFlg,String mgstPotcScgRtAmt,String currCd,String preEffDt,String onhInitValAmtUmg,String agmtDt,String vndrLglEngNm,String creDt,String onhInitValAmt,String mgstBldpRtAmtUmg,String pagerows,String monDpcRtAmt,String mgstBldpRtAmt,String ibflag,String effDt,String agmtIssOfcCd,String offhHndlRtAmt,String agmtExpDt,String actionFlag,String mgstPotcScgRtAmtClg,String mgstLseFxRtAmtClg,String expDt,String onhHndlRtAmt,String onhInitValAmtClg,String mgstPrtcScgRtAmt,String updUsrId,String preExpDt,String agmtRefNo,String mgstPotcScgRtAmtUmg,String agmtSeq,String agmtNo,String agmtLstmCd,String eqKndCd,String initDpcRtAmt,String payTermDys,String eqTpszCd,String creUsrId,String diffRmk,String vndrSeq,String agmtOfcCtyCd,String maxDpcRtAmt,String mgstPrtcScgRtAmtUmg,String mgstLseFxRtAmt,String mgstLseFxRtAmtUmg,String agmtVerNo,String mgstBldpRtAmtClg,String mgstPrtcScgRtAmtClg,String eqTpszCd1,String eqTpszCd2,String eqTpszCd3,String eqTpszCd4,String eqTpszCd5,String eqTpszCd6,String eqTpszCd7,String eqTpszCd8,String eqTpszCd9,String eqTpszCd10,String eqTpszCd11,String eqTpszCd12,String eqTpszCd13,String eqTpszCd14,String eqTpszCd15,String eqTpszCd16,String eqTpszCd17,String eqTpszCd18,String eqTpszCd19,String eqTpszCd20,String agmtCtrtNo, String oldAgmtNo, String eqNo)	{
		this.agmtEffDt  = agmtEffDt ;
		this.lstVerFlg  = lstVerFlg ;
		this.mgstPotcScgRtAmt  = mgstPotcScgRtAmt ;
		this.currCd  = currCd ;
		this.preEffDt  = preEffDt ;
		this.onhInitValAmtUmg  = onhInitValAmtUmg ;
		this.agmtDt  = agmtDt ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.creDt  = creDt ;
		this.onhInitValAmt  = onhInitValAmt ;
		this.mgstBldpRtAmtUmg  = mgstBldpRtAmtUmg ;
		this.pagerows  = pagerows ;
		this.monDpcRtAmt  = monDpcRtAmt ;
		this.mgstBldpRtAmt  = mgstBldpRtAmt ;
		this.ibflag  = ibflag ;
		this.effDt  = effDt ;
		this.agmtIssOfcCd  = agmtIssOfcCd ;
		this.offhHndlRtAmt  = offhHndlRtAmt ;
		this.agmtExpDt  = agmtExpDt ;
		this.actionFlag  = actionFlag ;
		this.mgstPotcScgRtAmtClg  = mgstPotcScgRtAmtClg ;
		this.mgstLseFxRtAmtClg  = mgstLseFxRtAmtClg ;
		this.expDt  = expDt ;
		this.onhHndlRtAmt  = onhHndlRtAmt ;
		this.onhInitValAmtClg  = onhInitValAmtClg ;
		this.mgstPrtcScgRtAmt  = mgstPrtcScgRtAmt ;
		this.updUsrId  = updUsrId ;
		this.preExpDt  = preExpDt ;
		this.agmtRefNo  = agmtRefNo ;
		this.mgstPotcScgRtAmtUmg  = mgstPotcScgRtAmtUmg ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.agmtLstmCd  = agmtLstmCd ;
		this.eqKndCd  = eqKndCd ;
		this.initDpcRtAmt  = initDpcRtAmt ;
		this.payTermDys  = payTermDys ;
		this.eqTpszCd  = eqTpszCd ;
		this.creUsrId  = creUsrId ;
		this.diffRmk  = diffRmk ;
		this.vndrSeq  = vndrSeq ;
		this.agmtOfcCtyCd  = agmtOfcCtyCd ;
		this.maxDpcRtAmt  = maxDpcRtAmt ;
		this.mgstPrtcScgRtAmtUmg  = mgstPrtcScgRtAmtUmg ;
		this.mgstLseFxRtAmt  = mgstLseFxRtAmt ;
		this.mgstLseFxRtAmtUmg  = mgstLseFxRtAmtUmg ;
		this.agmtVerNo  = agmtVerNo ;
		this.mgstBldpRtAmtClg  = mgstBldpRtAmtClg ;
		this.mgstPrtcScgRtAmtClg  = mgstPrtcScgRtAmtClg ;
		this.eqTpszCd1  = eqTpszCd1 ;
		this.eqTpszCd2  = eqTpszCd2 ;
		this.eqTpszCd3  = eqTpszCd3 ;
		this.eqTpszCd4  = eqTpszCd4 ;
		this.eqTpszCd5  = eqTpszCd5 ;
		this.eqTpszCd6  = eqTpszCd6 ;
		this.eqTpszCd7  = eqTpszCd7 ;
		this.eqTpszCd8  = eqTpszCd8 ;
		this.eqTpszCd9  = eqTpszCd9 ;
		this.eqTpszCd10  = eqTpszCd10 ;
		this.eqTpszCd11  = eqTpszCd11 ;
		this.eqTpszCd12  = eqTpszCd12 ;
		this.eqTpszCd13  = eqTpszCd13 ;
		this.eqTpszCd14  = eqTpszCd14 ;
		this.eqTpszCd15  = eqTpszCd15 ;
		this.eqTpszCd16  = eqTpszCd16 ;
		this.eqTpszCd17  = eqTpszCd17 ;
		this.eqTpszCd18  = eqTpszCd18 ;
		this.eqTpszCd19  = eqTpszCd19 ;
		this.eqTpszCd20  = eqTpszCd20 ;
		this.agmtCtrtNo = agmtCtrtNo;
		this.oldAgmtNo = oldAgmtNo;
		this.eqNo = eqNo;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());		
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());		
		this.hashColumns.put("mgst_potc_scg_rt_amt", getMgstPotcScgRtAmt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("pre_eff_dt", getPreEffDt());		
		this.hashColumns.put("onh_init_val_amt_umg", getOnhInitValAmtUmg());		
		this.hashColumns.put("agmt_dt", getAgmtDt());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("onh_init_val_amt", getOnhInitValAmt());		
		this.hashColumns.put("mgst_bldp_rt_amt_umg", getMgstBldpRtAmtUmg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("mon_dpc_rt_amt", getMonDpcRtAmt());		
		this.hashColumns.put("mgst_bldp_rt_amt", getMgstBldpRtAmt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());		
		this.hashColumns.put("offh_hndl_rt_amt", getOffhHndlRtAmt());		
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());		
		this.hashColumns.put("action_flag", getActionFlag());		
		this.hashColumns.put("mgst_potc_scg_rt_amt_clg", getMgstPotcScgRtAmtClg());		
		this.hashColumns.put("mgst_lse_fx_rt_amt_clg", getMgstLseFxRtAmtClg());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("onh_hndl_rt_amt", getOnhHndlRtAmt());		
		this.hashColumns.put("onh_init_val_amt_clg", getOnhInitValAmtClg());		
		this.hashColumns.put("mgst_prtc_scg_rt_amt", getMgstPrtcScgRtAmt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("pre_exp_dt", getPreExpDt());		
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());		
		this.hashColumns.put("mgst_potc_scg_rt_amt_umg", getMgstPotcScgRtAmtUmg());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("init_dpc_rt_amt", getInitDpcRtAmt());		
		this.hashColumns.put("pay_term_dys", getPayTermDys());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("diff_rmk", getDiffRmk());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());		
		this.hashColumns.put("max_dpc_rt_amt", getMaxDpcRtAmt());		
		this.hashColumns.put("mgst_prtc_scg_rt_amt_umg", getMgstPrtcScgRtAmtUmg());		
		this.hashColumns.put("mgst_lse_fx_rt_amt", getMgstLseFxRtAmt());		
		this.hashColumns.put("mgst_lse_fx_rt_amt_umg", getMgstLseFxRtAmtUmg());		
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());		
		this.hashColumns.put("mgst_bldp_rt_amt_clg", getMgstBldpRtAmtClg());		
		this.hashColumns.put("mgst_prtc_scg_rt_amt_clg", getMgstPrtcScgRtAmtClg());		
		this.hashColumns.put("eq_tpsz_cd1", getEqTpszCd1());		
		this.hashColumns.put("eq_tpsz_cd2", getEqTpszCd2());		
		this.hashColumns.put("eq_tpsz_cd3", getEqTpszCd3());		
		this.hashColumns.put("eq_tpsz_cd4", getEqTpszCd4());		
		this.hashColumns.put("eq_tpsz_cd5", getEqTpszCd5());		
		this.hashColumns.put("eq_tpsz_cd6", getEqTpszCd6());		
		this.hashColumns.put("eq_tpsz_cd7", getEqTpszCd7());		
		this.hashColumns.put("eq_tpsz_cd8", getEqTpszCd8());		
		this.hashColumns.put("eq_tpsz_cd9", getEqTpszCd9());		
		this.hashColumns.put("eq_tpsz_cd10", getEqTpszCd10());		
		this.hashColumns.put("eq_tpsz_cd11", getEqTpszCd11());		
		this.hashColumns.put("eq_tpsz_cd12", getEqTpszCd12());		
		this.hashColumns.put("eq_tpsz_cd13", getEqTpszCd13());		
		this.hashColumns.put("eq_tpsz_cd14", getEqTpszCd14());		
		this.hashColumns.put("eq_tpsz_cd15", getEqTpszCd15());		
		this.hashColumns.put("eq_tpsz_cd16", getEqTpszCd16());		
		this.hashColumns.put("eq_tpsz_cd17", getEqTpszCd17());		
		this.hashColumns.put("eq_tpsz_cd18", getEqTpszCd18());		
		this.hashColumns.put("eq_tpsz_cd19", getEqTpszCd19());		
		this.hashColumns.put("eq_tpsz_cd20", getEqTpszCd20());
		this.hashColumns.put("agmt_ctrt_no", getAgmtCtrtNo());
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());
		this.hashColumns.put("eq_no", getEqNo());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("mgst_potc_scg_rt_amt", "mgstPotcScgRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("onh_init_val_amt_umg", "onhInitValAmtUmg");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("onh_init_val_amt", "onhInitValAmt");
		this.hashFields.put("mgst_bldp_rt_amt_umg", "mgstBldpRtAmtUmg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_dpc_rt_amt", "monDpcRtAmt");
		this.hashFields.put("mgst_bldp_rt_amt", "mgstBldpRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("offh_hndl_rt_amt", "offhHndlRtAmt");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("action_flag", "actionFlag");
		this.hashFields.put("mgst_potc_scg_rt_amt_clg", "mgstPotcScgRtAmtClg");
		this.hashFields.put("mgst_lse_fx_rt_amt_clg", "mgstLseFxRtAmtClg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("onh_hndl_rt_amt", "onhHndlRtAmt");
		this.hashFields.put("onh_init_val_amt_clg", "onhInitValAmtClg");
		this.hashFields.put("mgst_prtc_scg_rt_amt", "mgstPrtcScgRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("mgst_potc_scg_rt_amt_umg", "mgstPotcScgRtAmtUmg");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("init_dpc_rt_amt", "initDpcRtAmt");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("max_dpc_rt_amt", "maxDpcRtAmt");
		this.hashFields.put("mgst_prtc_scg_rt_amt_umg", "mgstPrtcScgRtAmtUmg");
		this.hashFields.put("mgst_lse_fx_rt_amt", "mgstLseFxRtAmt");
		this.hashFields.put("mgst_lse_fx_rt_amt_umg", "mgstLseFxRtAmtUmg");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("mgst_bldp_rt_amt_clg", "mgstBldpRtAmtClg");
		this.hashFields.put("mgst_prtc_scg_rt_amt_clg", "mgstPrtcScgRtAmtClg");
		this.hashFields.put("eq_tpsz_cd1", "eqTpszCd1");
		this.hashFields.put("eq_tpsz_cd2", "eqTpszCd2");
		this.hashFields.put("eq_tpsz_cd3", "eqTpszCd3");
		this.hashFields.put("eq_tpsz_cd4", "eqTpszCd4");
		this.hashFields.put("eq_tpsz_cd5", "eqTpszCd5");
		this.hashFields.put("eq_tpsz_cd6", "eqTpszCd6");
		this.hashFields.put("eq_tpsz_cd7", "eqTpszCd7");
		this.hashFields.put("eq_tpsz_cd8", "eqTpszCd8");
		this.hashFields.put("eq_tpsz_cd9", "eqTpszCd9");
		this.hashFields.put("eq_tpsz_cd10", "eqTpszCd10");
		this.hashFields.put("eq_tpsz_cd11", "eqTpszCd11");
		this.hashFields.put("eq_tpsz_cd12", "eqTpszCd12");
		this.hashFields.put("eq_tpsz_cd13", "eqTpszCd13");
		this.hashFields.put("eq_tpsz_cd14", "eqTpszCd14");
		this.hashFields.put("eq_tpsz_cd15", "eqTpszCd15");
		this.hashFields.put("eq_tpsz_cd16", "eqTpszCd16");
		this.hashFields.put("eq_tpsz_cd17", "eqTpszCd17");
		this.hashFields.put("eq_tpsz_cd18", "eqTpszCd18");
		this.hashFields.put("eq_tpsz_cd19", "eqTpszCd19");
		this.hashFields.put("eq_tpsz_cd20", "eqTpszCd20");
		this.hashFields.put("agmt_ctrt_no", "agmtCtrtNo");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("eq_no", "eqNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  agmtEffDt
	*/
	public void	setAgmtEffDt( String	agmtEffDt ) {
		this.agmtEffDt =	agmtEffDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtEffDt
	 */
	 public	 String	getAgmtEffDt() {
		 return	this.agmtEffDt;
	 } 
 	/**
	* Column Info
	* @param  lstVerFlg
	*/
	public void	setLstVerFlg( String	lstVerFlg ) {
		this.lstVerFlg =	lstVerFlg;
	}
 
	/**
	 * Column Info
	 * @return	lstVerFlg
	 */
	 public	 String	getLstVerFlg() {
		 return	this.lstVerFlg;
	 } 
 	/**
	* Column Info
	* @param  mgstPotcScgRtAmt
	*/
	public void	setMgstPotcScgRtAmt( String	mgstPotcScgRtAmt ) {
		this.mgstPotcScgRtAmt =	mgstPotcScgRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	mgstPotcScgRtAmt
	 */
	 public	 String	getMgstPotcScgRtAmt() {
		 return	this.mgstPotcScgRtAmt;
	 } 
 	/**
	* Column Info
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  preEffDt
	*/
	public void	setPreEffDt( String	preEffDt ) {
		this.preEffDt =	preEffDt;
	}
 
	/**
	 * Column Info
	 * @return	preEffDt
	 */
	 public	 String	getPreEffDt() {
		 return	this.preEffDt;
	 } 
 	/**
	* Column Info
	* @param  onhInitValAmtUmg
	*/
	public void	setOnhInitValAmtUmg( String	onhInitValAmtUmg ) {
		this.onhInitValAmtUmg =	onhInitValAmtUmg;
	}
 
	/**
	 * Column Info
	 * @return	onhInitValAmtUmg
	 */
	 public	 String	getOnhInitValAmtUmg() {
		 return	this.onhInitValAmtUmg;
	 } 
 	/**
	* Column Info
	* @param  agmtDt
	*/
	public void	setAgmtDt( String	agmtDt ) {
		this.agmtDt =	agmtDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtDt
	 */
	 public	 String	getAgmtDt() {
		 return	this.agmtDt;
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
	 public	 String	getVndrLglEngNm() {
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
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  onhInitValAmt
	*/
	public void	setOnhInitValAmt( String	onhInitValAmt ) {
		this.onhInitValAmt =	onhInitValAmt;
	}
 
	/**
	 * Column Info
	 * @return	onhInitValAmt
	 */
	 public	 String	getOnhInitValAmt() {
		 return	this.onhInitValAmt;
	 } 
 	/**
	* Column Info
	* @param  mgstBldpRtAmtUmg
	*/
	public void	setMgstBldpRtAmtUmg( String	mgstBldpRtAmtUmg ) {
		this.mgstBldpRtAmtUmg =	mgstBldpRtAmtUmg;
	}
 
	/**
	 * Column Info
	 * @return	mgstBldpRtAmtUmg
	 */
	 public	 String	getMgstBldpRtAmtUmg() {
		 return	this.mgstBldpRtAmtUmg;
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
	* @param  monDpcRtAmt
	*/
	public void	setMonDpcRtAmt( String	monDpcRtAmt ) {
		this.monDpcRtAmt =	monDpcRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	monDpcRtAmt
	 */
	 public	 String	getMonDpcRtAmt() {
		 return	this.monDpcRtAmt;
	 } 
 	/**
	* Column Info
	* @param  mgstBldpRtAmt
	*/
	public void	setMgstBldpRtAmt( String	mgstBldpRtAmt ) {
		this.mgstBldpRtAmt =	mgstBldpRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	mgstBldpRtAmt
	 */
	 public	 String	getMgstBldpRtAmt() {
		 return	this.mgstBldpRtAmt;
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
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
	 } 
 	/**
	* Column Info
	* @param  agmtIssOfcCd
	*/
	public void	setAgmtIssOfcCd( String	agmtIssOfcCd ) {
		this.agmtIssOfcCd =	agmtIssOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtIssOfcCd
	 */
	 public	 String	getAgmtIssOfcCd() {
		 return	this.agmtIssOfcCd;
	 } 
 	/**
	* Column Info
	* @param  offhHndlRtAmt
	*/
	public void	setOffhHndlRtAmt( String	offhHndlRtAmt ) {
		this.offhHndlRtAmt =	offhHndlRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	offhHndlRtAmt
	 */
	 public	 String	getOffhHndlRtAmt() {
		 return	this.offhHndlRtAmt;
	 } 
 	/**
	* Column Info
	* @param  agmtExpDt
	*/
	public void	setAgmtExpDt( String	agmtExpDt ) {
		this.agmtExpDt =	agmtExpDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtExpDt
	 */
	 public	 String	getAgmtExpDt() {
		 return	this.agmtExpDt;
	 } 
 	/**
	* Column Info
	* @param  actionFlag
	*/
	public void	setActionFlag( String	actionFlag ) {
		this.actionFlag =	actionFlag;
	}
 
	/**
	 * Column Info
	 * @return	actionFlag
	 */
	 public	 String	getActionFlag() {
		 return	this.actionFlag;
	 } 
 	/**
	* Column Info
	* @param  mgstPotcScgRtAmtClg
	*/
	public void	setMgstPotcScgRtAmtClg( String	mgstPotcScgRtAmtClg ) {
		this.mgstPotcScgRtAmtClg =	mgstPotcScgRtAmtClg;
	}
 
	/**
	 * Column Info
	 * @return	mgstPotcScgRtAmtClg
	 */
	 public	 String	getMgstPotcScgRtAmtClg() {
		 return	this.mgstPotcScgRtAmtClg;
	 } 
 	/**
	* Column Info
	* @param  mgstLseFxRtAmtClg
	*/
	public void	setMgstLseFxRtAmtClg( String	mgstLseFxRtAmtClg ) {
		this.mgstLseFxRtAmtClg =	mgstLseFxRtAmtClg;
	}
 
	/**
	 * Column Info
	 * @return	mgstLseFxRtAmtClg
	 */
	 public	 String	getMgstLseFxRtAmtClg() {
		 return	this.mgstLseFxRtAmtClg;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
	 } 
 	/**
	* Column Info
	* @param  onhHndlRtAmt
	*/
	public void	setOnhHndlRtAmt( String	onhHndlRtAmt ) {
		this.onhHndlRtAmt =	onhHndlRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	onhHndlRtAmt
	 */
	 public	 String	getOnhHndlRtAmt() {
		 return	this.onhHndlRtAmt;
	 } 
 	/**
	* Column Info
	* @param  onhInitValAmtClg
	*/
	public void	setOnhInitValAmtClg( String	onhInitValAmtClg ) {
		this.onhInitValAmtClg =	onhInitValAmtClg;
	}
 
	/**
	 * Column Info
	 * @return	onhInitValAmtClg
	 */
	 public	 String	getOnhInitValAmtClg() {
		 return	this.onhInitValAmtClg;
	 } 
 	/**
	* Column Info
	* @param  mgstPrtcScgRtAmt
	*/
	public void	setMgstPrtcScgRtAmt( String	mgstPrtcScgRtAmt ) {
		this.mgstPrtcScgRtAmt =	mgstPrtcScgRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	mgstPrtcScgRtAmt
	 */
	 public	 String	getMgstPrtcScgRtAmt() {
		 return	this.mgstPrtcScgRtAmt;
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
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  preExpDt
	*/
	public void	setPreExpDt( String	preExpDt ) {
		this.preExpDt =	preExpDt;
	}
 
	/**
	 * Column Info
	 * @return	preExpDt
	 */
	 public	 String	getPreExpDt() {
		 return	this.preExpDt;
	 } 
 	/**
	* Column Info
	* @param  agmtRefNo
	*/
	public void	setAgmtRefNo( String	agmtRefNo ) {
		this.agmtRefNo =	agmtRefNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtRefNo
	 */
	 public	 String	getAgmtRefNo() {
		 return	this.agmtRefNo;
	 } 
 	/**
	* Column Info
	* @param  mgstPotcScgRtAmtUmg
	*/
	public void	setMgstPotcScgRtAmtUmg( String	mgstPotcScgRtAmtUmg ) {
		this.mgstPotcScgRtAmtUmg =	mgstPotcScgRtAmtUmg;
	}
 
	/**
	 * Column Info
	 * @return	mgstPotcScgRtAmtUmg
	 */
	 public	 String	getMgstPotcScgRtAmtUmg() {
		 return	this.mgstPotcScgRtAmtUmg;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  agmtLstmCd
	*/
	public void	setAgmtLstmCd( String	agmtLstmCd ) {
		this.agmtLstmCd =	agmtLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtLstmCd
	 */
	 public	 String	getAgmtLstmCd() {
		 return	this.agmtLstmCd;
	 } 
 	/**
	* Column Info
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
	 } 
 	/**
	* Column Info
	* @param  initDpcRtAmt
	*/
	public void	setInitDpcRtAmt( String	initDpcRtAmt ) {
		this.initDpcRtAmt =	initDpcRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	initDpcRtAmt
	 */
	 public	 String	getInitDpcRtAmt() {
		 return	this.initDpcRtAmt;
	 } 
 	/**
	* Column Info
	* @param  payTermDys
	*/
	public void	setPayTermDys( String	payTermDys ) {
		this.payTermDys =	payTermDys;
	}
 
	/**
	 * Column Info
	 * @return	payTermDys
	 */
	 public	 String	getPayTermDys() {
		 return	this.payTermDys;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
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
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  diffRmk
	*/
	public void	setDiffRmk( String	diffRmk ) {
		this.diffRmk =	diffRmk;
	}
 
	/**
	 * Column Info
	 * @return	diffRmk
	 */
	 public	 String	getDiffRmk() {
		 return	this.diffRmk;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  agmtOfcCtyCd
	*/
	public void	setAgmtOfcCtyCd( String	agmtOfcCtyCd ) {
		this.agmtOfcCtyCd =	agmtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtOfcCtyCd
	 */
	 public	 String	getAgmtOfcCtyCd() {
		 return	this.agmtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  maxDpcRtAmt
	*/
	public void	setMaxDpcRtAmt( String	maxDpcRtAmt ) {
		this.maxDpcRtAmt =	maxDpcRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	maxDpcRtAmt
	 */
	 public	 String	getMaxDpcRtAmt() {
		 return	this.maxDpcRtAmt;
	 } 
 	/**
	* Column Info
	* @param  mgstPrtcScgRtAmtUmg
	*/
	public void	setMgstPrtcScgRtAmtUmg( String	mgstPrtcScgRtAmtUmg ) {
		this.mgstPrtcScgRtAmtUmg =	mgstPrtcScgRtAmtUmg;
	}
 
	/**
	 * Column Info
	 * @return	mgstPrtcScgRtAmtUmg
	 */
	 public	 String	getMgstPrtcScgRtAmtUmg() {
		 return	this.mgstPrtcScgRtAmtUmg;
	 } 
 	/**
	* Column Info
	* @param  mgstLseFxRtAmt
	*/
	public void	setMgstLseFxRtAmt( String	mgstLseFxRtAmt ) {
		this.mgstLseFxRtAmt =	mgstLseFxRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	mgstLseFxRtAmt
	 */
	 public	 String	getMgstLseFxRtAmt() {
		 return	this.mgstLseFxRtAmt;
	 } 
 	/**
	* Column Info
	* @param  mgstLseFxRtAmtUmg
	*/
	public void	setMgstLseFxRtAmtUmg( String	mgstLseFxRtAmtUmg ) {
		this.mgstLseFxRtAmtUmg =	mgstLseFxRtAmtUmg;
	}
 
	/**
	 * Column Info
	 * @return	mgstLseFxRtAmtUmg
	 */
	 public	 String	getMgstLseFxRtAmtUmg() {
		 return	this.mgstLseFxRtAmtUmg;
	 } 
 	/**
	* Column Info
	* @param  agmtVerNo
	*/
	public void	setAgmtVerNo( String	agmtVerNo ) {
		this.agmtVerNo =	agmtVerNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtVerNo
	 */
	 public	 String	getAgmtVerNo() {
		 return	this.agmtVerNo;
	 } 
 	/**
	* Column Info
	* @param  mgstBldpRtAmtClg
	*/
	public void	setMgstBldpRtAmtClg( String	mgstBldpRtAmtClg ) {
		this.mgstBldpRtAmtClg =	mgstBldpRtAmtClg;
	}
 
	/**
	 * Column Info
	 * @return	mgstBldpRtAmtClg
	 */
	 public	 String	getMgstBldpRtAmtClg() {
		 return	this.mgstBldpRtAmtClg;
	 } 
 	/**
	* Column Info
	* @param  mgstPrtcScgRtAmtClg
	*/
	public void	setMgstPrtcScgRtAmtClg( String	mgstPrtcScgRtAmtClg ) {
		this.mgstPrtcScgRtAmtClg =	mgstPrtcScgRtAmtClg;
	}
 
	/**
	 * Column Info
	 * @return	mgstPrtcScgRtAmtClg
	 */
	 public	 String	getMgstPrtcScgRtAmtClg() {
		 return	this.mgstPrtcScgRtAmtClg;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd1
	*/
	public void	setEqTpszCd1( String	eqTpszCd1 ) {
		this.eqTpszCd1 =	eqTpszCd1;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd1
	 */
	 public	 String	getEqTpszCd1() {
		 return	this.eqTpszCd1;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd2
	*/
	public void	setEqTpszCd2( String	eqTpszCd2 ) {
		this.eqTpszCd2 =	eqTpszCd2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd2
	 */
	 public	 String	getEqTpszCd2() {
		 return	this.eqTpszCd2;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd3
	*/
	public void	setEqTpszCd3( String	eqTpszCd3 ) {
		this.eqTpszCd3 =	eqTpszCd3;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd3
	 */
	 public	 String	getEqTpszCd3() {
		 return	this.eqTpszCd3;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd4
	*/
	public void	setEqTpszCd4( String	eqTpszCd4 ) {
		this.eqTpszCd4 =	eqTpszCd4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd4
	 */
	 public	 String	getEqTpszCd4() {
		 return	this.eqTpszCd4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd5
	*/
	public void	setEqTpszCd5( String	eqTpszCd5 ) {
		this.eqTpszCd5 =	eqTpszCd5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd5
	 */
	 public	 String	getEqTpszCd5() {
		 return	this.eqTpszCd5;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd6
	*/
	public void	setEqTpszCd6( String	eqTpszCd6 ) {
		this.eqTpszCd6 =	eqTpszCd6;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd6
	 */
	 public	 String	getEqTpszCd6() {
		 return	this.eqTpszCd6;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd7
	*/
	public void	setEqTpszCd7( String	eqTpszCd7 ) {
		this.eqTpszCd7 =	eqTpszCd7;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd7
	 */
	 public	 String	getEqTpszCd7() {
		 return	this.eqTpszCd7;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd8
	*/
	public void	setEqTpszCd8( String	eqTpszCd8 ) {
		this.eqTpszCd8 =	eqTpszCd8;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd8
	 */
	 public	 String	getEqTpszCd8() {
		 return	this.eqTpszCd8;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd9
	*/
	public void	setEqTpszCd9( String	eqTpszCd9 ) {
		this.eqTpszCd9 =	eqTpszCd9;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd9
	 */
	 public	 String	getEqTpszCd9() {
		 return	this.eqTpszCd9;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd10
	*/
	public void	setEqTpszCd10( String	eqTpszCd10 ) {
		this.eqTpszCd10 =	eqTpszCd10;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd10
	 */
	 public	 String	getEqTpszCd10() {
		 return	this.eqTpszCd10;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd11
	*/
	public void	setEqTpszCd11( String	eqTpszCd11 ) {
		this.eqTpszCd11 =	eqTpszCd11;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd11
	 */
	 public	 String	getEqTpszCd11() {
		 return	this.eqTpszCd11;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd12
	*/
	public void	setEqTpszCd12( String	eqTpszCd12 ) {
		this.eqTpszCd12 =	eqTpszCd12;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd12
	 */
	 public	 String	getEqTpszCd12() {
		 return	this.eqTpszCd12;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd13
	*/
	public void	setEqTpszCd13( String	eqTpszCd13 ) {
		this.eqTpszCd13 =	eqTpszCd13;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd13
	 */
	 public	 String	getEqTpszCd13() {
		 return	this.eqTpszCd13;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd14
	*/
	public void	setEqTpszCd14( String	eqTpszCd14 ) {
		this.eqTpszCd14 =	eqTpszCd14;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd14
	 */
	 public	 String	getEqTpszCd14() {
		 return	this.eqTpszCd14;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd15
	*/
	public void	setEqTpszCd15( String	eqTpszCd15 ) {
		this.eqTpszCd15 =	eqTpszCd15;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd15
	 */
	 public	 String	getEqTpszCd15() {
		 return	this.eqTpszCd15;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd16
	*/
	public void	setEqTpszCd16( String	eqTpszCd16 ) {
		this.eqTpszCd16 =	eqTpszCd16;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd16
	 */
	 public	 String	getEqTpszCd16() {
		 return	this.eqTpszCd16;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd17
	*/
	public void	setEqTpszCd17( String	eqTpszCd17 ) {
		this.eqTpszCd17 =	eqTpszCd17;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd17
	 */
	 public	 String	getEqTpszCd17() {
		 return	this.eqTpszCd17;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd18
	*/
	public void	setEqTpszCd18( String	eqTpszCd18 ) {
		this.eqTpszCd18 =	eqTpszCd18;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd18
	 */
	 public	 String	getEqTpszCd18() {
		 return	this.eqTpszCd18;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd19
	*/
	public void	setEqTpszCd19( String	eqTpszCd19 ) {
		this.eqTpszCd19 =	eqTpszCd19;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd19
	 */
	 public	 String	getEqTpszCd19() {
		 return	this.eqTpszCd19;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd20
	*/
	public void	setEqTpszCd20( String	eqTpszCd20 ) {
		this.eqTpszCd20 =	eqTpszCd20;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd20
	 */
	 public	 String	getEqTpszCd20() {
		 return	this.eqTpszCd20;
	 } 

	/**
	 * Column Info
	 * @param agmtCtrtNo
	 */
	public void setAgmtCtrtNo(String agmtCtrtNo) {
		this.agmtCtrtNo = agmtCtrtNo;
	}

	/**
	 * Column Info
	 * @return agmtCtrtNo
	 */
	public String getAgmtCtrtNo() {
		return this.agmtCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param oldAgmtNo
	 */
	public void setOldAgmtNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}

	/**
	 * Column Info
	 * @return oldAgmtNo
	 */
	public String getOldAgmtNo() {
		return this.oldAgmtNo;
	}
	
	public String getEqNo() {
		return eqNo;
	}

	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
		setAgmtEffDt(JSPUtil.getParameter(request,	prefix + "agmt_eff_dt", ""));
		setLstVerFlg(JSPUtil.getParameter(request,	prefix + "lst_ver_flg", ""));
		setMgstPotcScgRtAmt(JSPUtil.getParameter(request,	prefix + "mgst_potc_scg_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPreEffDt(JSPUtil.getParameter(request,	prefix + "pre_eff_dt", ""));
		setOnhInitValAmtUmg(JSPUtil.getParameter(request,	prefix + "onh_init_val_amt_umg", ""));
		setAgmtDt(JSPUtil.getParameter(request,	prefix + "agmt_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setOnhInitValAmt(JSPUtil.getParameter(request,	prefix + "onh_init_val_amt", ""));
		setMgstBldpRtAmtUmg(JSPUtil.getParameter(request,	prefix + "mgst_bldp_rt_amt_umg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMonDpcRtAmt(JSPUtil.getParameter(request,	prefix + "mon_dpc_rt_amt", ""));
		setMgstBldpRtAmt(JSPUtil.getParameter(request,	prefix + "mgst_bldp_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request,	prefix + "agmt_iss_ofc_cd", ""));
		setOffhHndlRtAmt(JSPUtil.getParameter(request,	prefix + "offh_hndl_rt_amt", ""));
		setAgmtExpDt(JSPUtil.getParameter(request,	prefix + "agmt_exp_dt", ""));
		setActionFlag(JSPUtil.getParameter(request,	prefix + "action_flag", ""));
		setMgstPotcScgRtAmtClg(JSPUtil.getParameter(request,	prefix + "mgst_potc_scg_rt_amt_clg", ""));
		setMgstLseFxRtAmtClg(JSPUtil.getParameter(request,	prefix + "mgst_lse_fx_rt_amt_clg", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setOnhHndlRtAmt(JSPUtil.getParameter(request,	prefix + "onh_hndl_rt_amt", ""));
		setOnhInitValAmtClg(JSPUtil.getParameter(request,	prefix + "onh_init_val_amt_clg", ""));
		setMgstPrtcScgRtAmt(JSPUtil.getParameter(request,	prefix + "mgst_prtc_scg_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPreExpDt(JSPUtil.getParameter(request,	prefix + "pre_exp_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request,	prefix + "agmt_ref_no", ""));
		setMgstPotcScgRtAmtUmg(JSPUtil.getParameter(request,	prefix + "mgst_potc_scg_rt_amt_umg", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setInitDpcRtAmt(JSPUtil.getParameter(request,	prefix + "init_dpc_rt_amt", ""));
		setPayTermDys(JSPUtil.getParameter(request,	prefix + "pay_term_dys", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_ofc_cty_cd", ""));
		setMaxDpcRtAmt(JSPUtil.getParameter(request,	prefix + "max_dpc_rt_amt", ""));
		setMgstPrtcScgRtAmtUmg(JSPUtil.getParameter(request,	prefix + "mgst_prtc_scg_rt_amt_umg", ""));
		setMgstLseFxRtAmt(JSPUtil.getParameter(request,	prefix + "mgst_lse_fx_rt_amt", ""));
		setMgstLseFxRtAmtUmg(JSPUtil.getParameter(request,	prefix + "mgst_lse_fx_rt_amt_umg", ""));
		setAgmtVerNo(JSPUtil.getParameter(request,	prefix + "agmt_ver_no", ""));
		setMgstBldpRtAmtClg(JSPUtil.getParameter(request,	prefix + "mgst_bldp_rt_amt_clg", ""));
		setMgstPrtcScgRtAmtClg(JSPUtil.getParameter(request,	prefix + "mgst_prtc_scg_rt_amt_clg", ""));
		setEqTpszCd1(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd1", ""));
		setEqTpszCd2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd2", ""));
		setEqTpszCd3(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd3", ""));
		setEqTpszCd4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd4", ""));
		setEqTpszCd5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd5", ""));
		setEqTpszCd6(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd6", ""));
		setEqTpszCd7(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd7", ""));
		setEqTpszCd8(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd8", ""));
		setEqTpszCd9(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd9", ""));
		setEqTpszCd10(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd10", ""));
		setEqTpszCd11(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd11", ""));
		setEqTpszCd12(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd12", ""));
		setEqTpszCd13(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd13", ""));
		setEqTpszCd14(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd14", ""));
		setEqTpszCd15(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd15", ""));
		setEqTpszCd16(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd16", ""));
		setEqTpszCd17(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd17", ""));
		setEqTpszCd18(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd18", ""));
		setEqTpszCd19(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd19", ""));
		setEqTpszCd20(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd20", ""));
		setAgmtCtrtNo(JSPUtil.getParameter(request,	prefix + "agmt_ctrt_no", ""));
		setOldAgmtNo(JSPUtil.getParameter(request,	prefix + "old_agmt_no", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSAgreementINVO[]
	 */
	public MGSAgreementINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MGSAgreementINVO[]
	 */
	public MGSAgreementINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MGSAgreementINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] agmtEffDt =	(JSPUtil.getParameter(request, prefix +	"agmt_eff_dt".trim(),	length));
				String[] lstVerFlg =	(JSPUtil.getParameter(request, prefix +	"lst_ver_flg".trim(),	length));
				String[] mgstPotcScgRtAmt =	(JSPUtil.getParameter(request, prefix +	"mgst_potc_scg_rt_amt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] preEffDt =	(JSPUtil.getParameter(request, prefix +	"pre_eff_dt".trim(),	length));
				String[] onhInitValAmtUmg =	(JSPUtil.getParameter(request, prefix +	"onh_init_val_amt_umg".trim(),	length));
				String[] agmtDt =	(JSPUtil.getParameter(request, prefix +	"agmt_dt".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] onhInitValAmt =	(JSPUtil.getParameter(request, prefix +	"onh_init_val_amt".trim(),	length));
				String[] mgstBldpRtAmtUmg =	(JSPUtil.getParameter(request, prefix +	"mgst_bldp_rt_amt_umg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] monDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"mon_dpc_rt_amt".trim(),	length));
				String[] mgstBldpRtAmt =	(JSPUtil.getParameter(request, prefix +	"mgst_bldp_rt_amt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] agmtIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"agmt_iss_ofc_cd".trim(),	length));
				String[] offhHndlRtAmt =	(JSPUtil.getParameter(request, prefix +	"offh_hndl_rt_amt".trim(),	length));
				String[] agmtExpDt =	(JSPUtil.getParameter(request, prefix +	"agmt_exp_dt".trim(),	length));
				String[] actionFlag =	(JSPUtil.getParameter(request, prefix +	"action_flag".trim(),	length));
				String[] mgstPotcScgRtAmtClg =	(JSPUtil.getParameter(request, prefix +	"mgst_potc_scg_rt_amt_clg".trim(),	length));
				String[] mgstLseFxRtAmtClg =	(JSPUtil.getParameter(request, prefix +	"mgst_lse_fx_rt_amt_clg".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] onhHndlRtAmt =	(JSPUtil.getParameter(request, prefix +	"onh_hndl_rt_amt".trim(),	length));
				String[] onhInitValAmtClg =	(JSPUtil.getParameter(request, prefix +	"onh_init_val_amt_clg".trim(),	length));
				String[] mgstPrtcScgRtAmt =	(JSPUtil.getParameter(request, prefix +	"mgst_prtc_scg_rt_amt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] preExpDt =	(JSPUtil.getParameter(request, prefix +	"pre_exp_dt".trim(),	length));
				String[] agmtRefNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ref_no".trim(),	length));
				String[] mgstPotcScgRtAmtUmg =	(JSPUtil.getParameter(request, prefix +	"mgst_potc_scg_rt_amt_umg".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] agmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_lstm_cd".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] initDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"init_dpc_rt_amt".trim(),	length));
				String[] payTermDys =	(JSPUtil.getParameter(request, prefix +	"pay_term_dys".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] agmtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_ofc_cty_cd".trim(),	length));
				String[] maxDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"max_dpc_rt_amt".trim(),	length));
				String[] mgstPrtcScgRtAmtUmg =	(JSPUtil.getParameter(request, prefix +	"mgst_prtc_scg_rt_amt_umg".trim(),	length));
				String[] mgstLseFxRtAmt =	(JSPUtil.getParameter(request, prefix +	"mgst_lse_fx_rt_amt".trim(),	length));
				String[] mgstLseFxRtAmtUmg =	(JSPUtil.getParameter(request, prefix +	"mgst_lse_fx_rt_amt_umg".trim(),	length));
				String[] agmtVerNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ver_no".trim(),	length));
				String[] mgstBldpRtAmtClg =	(JSPUtil.getParameter(request, prefix +	"mgst_bldp_rt_amt_clg".trim(),	length));
				String[] mgstPrtcScgRtAmtClg =	(JSPUtil.getParameter(request, prefix +	"mgst_prtc_scg_rt_amt_clg".trim(),	length));
				String[] eqTpszCd1 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd1".trim(),	length));
				String[] eqTpszCd2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd2".trim(),	length));
				String[] eqTpszCd3 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd3".trim(),	length));
				String[] eqTpszCd4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd4".trim(),	length));
				String[] eqTpszCd5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd5".trim(),	length));
				String[] eqTpszCd6 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd6".trim(),	length));
				String[] eqTpszCd7 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd7".trim(),	length));
				String[] eqTpszCd8 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd8".trim(),	length));
				String[] eqTpszCd9 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd9".trim(),	length));
				String[] eqTpszCd10 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd10".trim(),	length));
				String[] eqTpszCd11 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd11".trim(),	length));
				String[] eqTpszCd12 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd12".trim(),	length));
				String[] eqTpszCd13 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd13".trim(),	length));
				String[] eqTpszCd14 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd14".trim(),	length));
				String[] eqTpszCd15 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd15".trim(),	length));
				String[] eqTpszCd16 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd16".trim(),	length));
				String[] eqTpszCd17 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd17".trim(),	length));
				String[] eqTpszCd18 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd18".trim(),	length));
				String[] eqTpszCd19 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd19".trim(),	length));
				String[] eqTpszCd20 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd20".trim(),	length));
				String[] agmtCtrtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ctrt_no".trim(),	length));
				String[] oldAgmtNo =	(JSPUtil.getParameter(request, prefix +	"old_agmt_no".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MGSAgreementINVO();
						if ( agmtEffDt[i] !=	null)
						model.setAgmtEffDt( agmtEffDt[i]);
						if ( lstVerFlg[i] !=	null)
						model.setLstVerFlg( lstVerFlg[i]);
						if ( mgstPotcScgRtAmt[i] !=	null)
						model.setMgstPotcScgRtAmt( mgstPotcScgRtAmt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( preEffDt[i] !=	null)
						model.setPreEffDt( preEffDt[i]);
						if ( onhInitValAmtUmg[i] !=	null)
						model.setOnhInitValAmtUmg( onhInitValAmtUmg[i]);
						if ( agmtDt[i] !=	null)
						model.setAgmtDt( agmtDt[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( onhInitValAmt[i] !=	null)
						model.setOnhInitValAmt( onhInitValAmt[i]);
						if ( mgstBldpRtAmtUmg[i] !=	null)
						model.setMgstBldpRtAmtUmg( mgstBldpRtAmtUmg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( monDpcRtAmt[i] !=	null)
						model.setMonDpcRtAmt( monDpcRtAmt[i]);
						if ( mgstBldpRtAmt[i] !=	null)
						model.setMgstBldpRtAmt( mgstBldpRtAmt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( agmtIssOfcCd[i] !=	null)
						model.setAgmtIssOfcCd( agmtIssOfcCd[i]);
						if ( offhHndlRtAmt[i] !=	null)
						model.setOffhHndlRtAmt( offhHndlRtAmt[i]);
						if ( agmtExpDt[i] !=	null)
						model.setAgmtExpDt( agmtExpDt[i]);
						if ( actionFlag[i] !=	null)
						model.setActionFlag( actionFlag[i]);
						if ( mgstPotcScgRtAmtClg[i] !=	null)
						model.setMgstPotcScgRtAmtClg( mgstPotcScgRtAmtClg[i]);
						if ( mgstLseFxRtAmtClg[i] !=	null)
						model.setMgstLseFxRtAmtClg( mgstLseFxRtAmtClg[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( onhHndlRtAmt[i] !=	null)
						model.setOnhHndlRtAmt( onhHndlRtAmt[i]);
						if ( onhInitValAmtClg[i] !=	null)
						model.setOnhInitValAmtClg( onhInitValAmtClg[i]);
						if ( mgstPrtcScgRtAmt[i] !=	null)
						model.setMgstPrtcScgRtAmt( mgstPrtcScgRtAmt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( preExpDt[i] !=	null)
						model.setPreExpDt( preExpDt[i]);
						if ( agmtRefNo[i] !=	null)
						model.setAgmtRefNo( agmtRefNo[i]);
						if ( mgstPotcScgRtAmtUmg[i] !=	null)
						model.setMgstPotcScgRtAmtUmg( mgstPotcScgRtAmtUmg[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( agmtLstmCd[i] !=	null)
						model.setAgmtLstmCd( agmtLstmCd[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( initDpcRtAmt[i] !=	null)
						model.setInitDpcRtAmt( initDpcRtAmt[i]);
						if ( payTermDys[i] !=	null)
						model.setPayTermDys( payTermDys[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( diffRmk[i] !=	null)
						model.setDiffRmk( diffRmk[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( agmtOfcCtyCd[i] !=	null)
						model.setAgmtOfcCtyCd( agmtOfcCtyCd[i]);
						if ( maxDpcRtAmt[i] !=	null)
						model.setMaxDpcRtAmt( maxDpcRtAmt[i]);
						if ( mgstPrtcScgRtAmtUmg[i] !=	null)
						model.setMgstPrtcScgRtAmtUmg( mgstPrtcScgRtAmtUmg[i]);
						if ( mgstLseFxRtAmt[i] !=	null)
						model.setMgstLseFxRtAmt( mgstLseFxRtAmt[i]);
						if ( mgstLseFxRtAmtUmg[i] !=	null)
						model.setMgstLseFxRtAmtUmg( mgstLseFxRtAmtUmg[i]);
						if ( agmtVerNo[i] !=	null)
						model.setAgmtVerNo( agmtVerNo[i]);
						if ( mgstBldpRtAmtClg[i] !=	null)
						model.setMgstBldpRtAmtClg( mgstBldpRtAmtClg[i]);
						if ( mgstPrtcScgRtAmtClg[i] !=	null)
						model.setMgstPrtcScgRtAmtClg( mgstPrtcScgRtAmtClg[i]);
						if ( eqTpszCd1[i] !=	null)
						model.setEqTpszCd1( eqTpszCd1[i]);
						if ( eqTpszCd2[i] !=	null)
						model.setEqTpszCd2( eqTpszCd2[i]);
						if ( eqTpszCd3[i] !=	null)
						model.setEqTpszCd3( eqTpszCd3[i]);
						if ( eqTpszCd4[i] !=	null)
						model.setEqTpszCd4( eqTpszCd4[i]);
						if ( eqTpszCd5[i] !=	null)
						model.setEqTpszCd5( eqTpszCd5[i]);
						if ( eqTpszCd6[i] !=	null)
						model.setEqTpszCd6( eqTpszCd6[i]);
						if ( eqTpszCd7[i] !=	null)
						model.setEqTpszCd7( eqTpszCd7[i]);
						if ( eqTpszCd8[i] !=	null)
						model.setEqTpszCd8( eqTpszCd8[i]);
						if ( eqTpszCd9[i] !=	null)
						model.setEqTpszCd9( eqTpszCd9[i]);
						if ( eqTpszCd10[i] !=	null)
						model.setEqTpszCd10( eqTpszCd10[i]);
						if ( eqTpszCd11[i] !=	null)
						model.setEqTpszCd11( eqTpszCd11[i]);
						if ( eqTpszCd12[i] !=	null)
						model.setEqTpszCd12( eqTpszCd12[i]);
						if ( eqTpszCd13[i] !=	null)
						model.setEqTpszCd13( eqTpszCd13[i]);
						if ( eqTpszCd14[i] !=	null)
						model.setEqTpszCd14( eqTpszCd14[i]);
						if ( eqTpszCd15[i] !=	null)
						model.setEqTpszCd15( eqTpszCd15[i]);
						if ( eqTpszCd16[i] !=	null)
						model.setEqTpszCd16( eqTpszCd16[i]);
						if ( eqTpszCd17[i] !=	null)
						model.setEqTpszCd17( eqTpszCd17[i]);
						if ( eqTpszCd18[i] !=	null)
						model.setEqTpszCd18( eqTpszCd18[i]);
						if ( eqTpszCd19[i] !=	null)
						model.setEqTpszCd19( eqTpszCd19[i]);
						if ( eqTpszCd20[i] !=	null)
						model.setEqTpszCd20( eqTpszCd20[i]);
						if ( agmtCtrtNo[i] !=	null)
						model.setAgmtCtrtNo( agmtCtrtNo[i]);
						if ( oldAgmtNo[i] !=	null)
						model.setOldAgmtNo( oldAgmtNo[i]);
						if ( eqNo[i] !=	null)
							model.setEqNo( eqNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMGSAgreementINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MGSAgreementINVO[]
	 */
	public MGSAgreementINVO[]	 getMGSAgreementINVOs(){
		MGSAgreementINVO[] vos = (MGSAgreementINVO[])models.toArray(new	MGSAgreementINVO[models.size()]);
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
		this.agmtEffDt =	this.agmtEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstVerFlg =	this.lstVerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmt =	this.mgstPotcScgRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt =	this.preEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmtUmg =	this.onhInitValAmtUmg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt =	this.agmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmt =	this.onhInitValAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmtUmg =	this.mgstBldpRtAmtUmg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monDpcRtAmt =	this.monDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmt =	this.mgstBldpRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd =	this.agmtIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhHndlRtAmt =	this.offhHndlRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt =	this.agmtExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionFlag =	this.actionFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmtClg =	this.mgstPotcScgRtAmtClg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmtClg =	this.mgstLseFxRtAmtClg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhHndlRtAmt =	this.onhHndlRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmtClg =	this.onhInitValAmtClg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmt =	this.mgstPrtcScgRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt =	this.preExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo =	this.agmtRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmtUmg =	this.mgstPotcScgRtAmtUmg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd =	this.agmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDpcRtAmt =	this.initDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys =	this.payTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd =	this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRtAmt =	this.maxDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmtUmg =	this.mgstPrtcScgRtAmtUmg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmt =	this.mgstLseFxRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmtUmg =	this.mgstLseFxRtAmtUmg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo =	this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmtClg =	this.mgstBldpRtAmtClg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmtClg =	this.mgstPrtcScgRtAmtClg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd1 =	this.eqTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd2 =	this.eqTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd3 =	this.eqTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd4 =	this.eqTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd5 =	this.eqTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd6 =	this.eqTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd7 =	this.eqTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd8 =	this.eqTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd9 =	this.eqTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd10 =	this.eqTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd11 =	this.eqTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd12 =	this.eqTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd13 =	this.eqTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd14 =	this.eqTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd15 =	this.eqTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd16 =	this.eqTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd17 =	this.eqTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd18 =	this.eqTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd19 =	this.eqTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd20 =	this.eqTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtrtNo =	this.agmtCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}