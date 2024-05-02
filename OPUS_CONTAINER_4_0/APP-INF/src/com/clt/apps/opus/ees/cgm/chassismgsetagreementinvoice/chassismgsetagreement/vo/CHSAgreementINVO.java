/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CHSAgreementINVO.java
 *@FileTitle : CHSAgreementINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.19  
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
public class CHSAgreementINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CHSAgreementINVO>  models =	new	ArrayList<CHSAgreementINVO>();


	/*	Column Info	*/
	private  String	 agmtEffDt   =  null;
	/*	Column Info	*/
	private  String	 keyRntlFmTrVal   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSf4   =  null;
	/*	Column Info	*/
	private  String	 drpOffLmtTpCd   =  null;
	/*	Column Info	*/
	private  String	 dppCvrgAmt   =  null;
	/*	Column Info	*/
	private  String	 chssPoolCd   =  null;
	/*	Column Info	*/
	private  String	 lmsmAmt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 monDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 agmtIssOfcCd   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 drpOffLmtPrdCd   =  null;
	/*	Column Info	*/
	private  String	 rntlToTrVal   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdZt4   =  null;
	/*	Column Info	*/
	private  String	 offhHndlRtAmt   =  null;
	/*	Column Info	*/
	private  String	 agmtExpDt   =  null;
	/*	Column Info	*/
	private  String	 ohnInitValAmt   =  null;
	/*	Column Info	*/
	private  String	 rntlToTitle   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSf2   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 agmtRefNo   =  null;
	/*	Column Info	*/
	private  String	 chssLseRtAmt   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdCb4   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 agmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 payTermDys   =  null;
	/*	Column Info	*/
	private  String	 initDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 keyRntlToTrVal   =  null;
	/*	Column Info	*/
	private  String	 rntlFmTitle   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdGn4   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdGn5   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 agmtVerNo   =  null;
	/*	Column Info	*/
	private  String	 lstVerFlg   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 preEffDt   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdSl2   =  null;
	/*	Column Info	*/
	private  String	 agmtDt   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 dppRtAmt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdEg8   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdTa2   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCdEg5   =  null;
	/*	Column Info	*/
	private  String	 rntlFmTrVal   =  null;
	/*	Column Info	*/
	private  String	 actionFlag   =  null;
	/*	Column Info	*/
	private  String	 trRtAmt   =  null;
	/*	Column Info	*/
	private  String	 onhHndlRtAmt   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 preExpDt   =  null;
	/*	Column Info	*/
	private  String	 keySteCd   =  null;
	/*	Column Info	*/
	private  String	 eqRntlTpCd   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 rgstScgRtAmt   =  null;
	/*	Column Info	*/
	private  String	 drpOffLmtQty   =  null;
	/*	Column Info	*/
	private  String	 diffRmk   =  null;
	/*	Column Info	*/
	private  String	 drpOffLmtRto   =  null;
	/*	Column Info	*/
	private  String	 steNm   =  null;
	/*	Column Info	*/
	private  String	 maxDpcRtAmt   =  null;
	/*	Column Info	*/
	private  String	 steCd   =  null;
	/*	Column Info	*/
	private  String	 dppTpCd   =  null;
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
	public CHSAgreementINVO(){}

	public CHSAgreementINVO(String agmtEffDt,String keyRntlFmTrVal,String eqTpszCdSf4,String drpOffLmtTpCd,String dppCvrgAmt,String chssPoolCd,String lmsmAmt,String pagerows,String monDpcRtAmt,String agmtIssOfcCd,String effDt,String drpOffLmtPrdCd,String rntlToTrVal,String eqTpszCdZt4,String offhHndlRtAmt,String agmtExpDt,String ohnInitValAmt,String rntlToTitle,String eqTpszCdSf2,String updUsrId,String agmtRefNo,String chssLseRtAmt,String eqTpszCdCb4,String agmtSeq,String agmtNo,String agmtLstmCd,String payTermDys,String initDpcRtAmt,String eqTpszCd,String keyRntlToTrVal,String rntlFmTitle,String creUsrId,String eqTpszCdGn4,String eqTpszCdGn5,String vndrSeq,String agmtOfcCtyCd,String agmtVerNo,String lstVerFlg,String currCd,String preEffDt,String eqTpszCdSl2,String agmtDt,String vndrLglEngNm,String creDt,String dppRtAmt,String ibflag,String eqTpszCdEg8,String eqTpszCdTa2,String eqTpszCdEg5,String rntlFmTrVal,String actionFlag,String trRtAmt,String onhHndlRtAmt,String expDt,String preExpDt,String keySteCd,String eqRntlTpCd,String eqKndCd,String rgstScgRtAmt,String drpOffLmtQty,String diffRmk,String drpOffLmtRto,String steNm,String maxDpcRtAmt,String steCd,String dppTpCd,String eqTpszCd1,String eqTpszCd2,String eqTpszCd3,String eqTpszCd4,String eqTpszCd5,String eqTpszCd6,String eqTpszCd7,String eqTpszCd8,String eqTpszCd9,String eqTpszCd10,String eqTpszCd11,String eqTpszCd12,String eqTpszCd13,String eqTpszCd14,String eqTpszCd15,String eqTpszCd16,String eqTpszCd17,String eqTpszCd18,String eqTpszCd19,String eqTpszCd20,String agmtCtrtNo, String oldAgmtNo, String eqNo)	{
		this.agmtEffDt  = agmtEffDt ;
		this.keyRntlFmTrVal  = keyRntlFmTrVal ;
		this.eqTpszCdSf4  = eqTpszCdSf4 ;
		this.drpOffLmtTpCd  = drpOffLmtTpCd ;
		this.dppCvrgAmt  = dppCvrgAmt ;
		this.chssPoolCd  = chssPoolCd ;
		this.lmsmAmt  = lmsmAmt ;
		this.pagerows  = pagerows ;
		this.monDpcRtAmt  = monDpcRtAmt ;
		this.agmtIssOfcCd  = agmtIssOfcCd ;
		this.effDt  = effDt ;
		this.drpOffLmtPrdCd  = drpOffLmtPrdCd ;
		this.rntlToTrVal  = rntlToTrVal ;
		this.eqTpszCdZt4  = eqTpszCdZt4 ;
		this.offhHndlRtAmt  = offhHndlRtAmt ;
		this.agmtExpDt  = agmtExpDt ;
		this.ohnInitValAmt  = ohnInitValAmt ;
		this.rntlToTitle  = rntlToTitle ;
		this.eqTpszCdSf2  = eqTpszCdSf2 ;
		this.updUsrId  = updUsrId ;
		this.agmtRefNo  = agmtRefNo ;
		this.chssLseRtAmt  = chssLseRtAmt ;
		this.eqTpszCdCb4  = eqTpszCdCb4 ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.agmtLstmCd  = agmtLstmCd ;
		this.payTermDys  = payTermDys ;
		this.initDpcRtAmt  = initDpcRtAmt ;
		this.eqTpszCd  = eqTpszCd ;
		this.keyRntlToTrVal  = keyRntlToTrVal ;
		this.rntlFmTitle  = rntlFmTitle ;
		this.creUsrId  = creUsrId ;
		this.eqTpszCdGn4  = eqTpszCdGn4 ;
		this.eqTpszCdGn5  = eqTpszCdGn5 ;
		this.vndrSeq  = vndrSeq ;
		this.agmtOfcCtyCd  = agmtOfcCtyCd ;
		this.agmtVerNo  = agmtVerNo ;
		this.lstVerFlg  = lstVerFlg ;
		this.currCd  = currCd ;
		this.preEffDt  = preEffDt ;
		this.eqTpszCdSl2  = eqTpszCdSl2 ;
		this.agmtDt  = agmtDt ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.creDt  = creDt ;
		this.dppRtAmt  = dppRtAmt ;
		this.ibflag  = ibflag ;
		this.eqTpszCdEg8  = eqTpszCdEg8 ;
		this.eqTpszCdTa2  = eqTpszCdTa2 ;
		this.eqTpszCdEg5  = eqTpszCdEg5 ;
		this.rntlFmTrVal  = rntlFmTrVal ;
		this.actionFlag  = actionFlag ;
		this.trRtAmt  = trRtAmt ;
		this.onhHndlRtAmt  = onhHndlRtAmt ;
		this.expDt  = expDt ;
		this.preExpDt  = preExpDt ;
		this.keySteCd  = keySteCd ;
		this.eqRntlTpCd  = eqRntlTpCd ;
		this.eqKndCd  = eqKndCd ;
		this.rgstScgRtAmt  = rgstScgRtAmt ;
		this.drpOffLmtQty  = drpOffLmtQty ;
		this.diffRmk  = diffRmk ;
		this.drpOffLmtRto  = drpOffLmtRto ;
		this.steNm  = steNm ;
		this.maxDpcRtAmt  = maxDpcRtAmt ;
		this.steCd  = steCd ;
		this.dppTpCd  = dppTpCd ;
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
		this.hashColumns.put("key_rntl_fm_tr_val", getKeyRntlFmTrVal());		
		this.hashColumns.put("eq_tpsz_cd_sf4", getEqTpszCdSf4());		
		this.hashColumns.put("drp_off_lmt_tp_cd", getDrpOffLmtTpCd());		
		this.hashColumns.put("dpp_cvrg_amt", getDppCvrgAmt());		
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());		
		this.hashColumns.put("lmsm_amt", getLmsmAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("mon_dpc_rt_amt", getMonDpcRtAmt());		
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("drp_off_lmt_prd_cd", getDrpOffLmtPrdCd());		
		this.hashColumns.put("rntl_to_tr_val", getRntlToTrVal());		
		this.hashColumns.put("eq_tpsz_cd_zt4", getEqTpszCdZt4());		
		this.hashColumns.put("offh_hndl_rt_amt", getOffhHndlRtAmt());		
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());		
		this.hashColumns.put("ohn_init_val_amt", getOhnInitValAmt());		
		this.hashColumns.put("rntl_to_title", getRntlToTitle());		
		this.hashColumns.put("eq_tpsz_cd_sf2", getEqTpszCdSf2());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());		
		this.hashColumns.put("chss_lse_rt_amt", getChssLseRtAmt());		
		this.hashColumns.put("eq_tpsz_cd_cb4", getEqTpszCdCb4());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());		
		this.hashColumns.put("pay_term_dys", getPayTermDys());		
		this.hashColumns.put("init_dpc_rt_amt", getInitDpcRtAmt());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("key_rntl_to_tr_val", getKeyRntlToTrVal());		
		this.hashColumns.put("rntl_fm_title", getRntlFmTitle());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("eq_tpsz_cd_gn4", getEqTpszCdGn4());		
		this.hashColumns.put("eq_tpsz_cd_gn5", getEqTpszCdGn5());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());		
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());		
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("pre_eff_dt", getPreEffDt());		
		this.hashColumns.put("eq_tpsz_cd_sl2", getEqTpszCdSl2());		
		this.hashColumns.put("agmt_dt", getAgmtDt());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("dpp_rt_amt", getDppRtAmt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_tpsz_cd_eg8", getEqTpszCdEg8());		
		this.hashColumns.put("eq_tpsz_cd_ta2", getEqTpszCdTa2());		
		this.hashColumns.put("eq_tpsz_cd_eg5", getEqTpszCdEg5());		
		this.hashColumns.put("rntl_fm_tr_val", getRntlFmTrVal());		
		this.hashColumns.put("action_flag", getActionFlag());		
		this.hashColumns.put("tr_rt_amt", getTrRtAmt());		
		this.hashColumns.put("onh_hndl_rt_amt", getOnhHndlRtAmt());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("pre_exp_dt", getPreExpDt());		
		this.hashColumns.put("key_ste_cd", getKeySteCd());		
		this.hashColumns.put("eq_rntl_tp_cd", getEqRntlTpCd());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("rgst_scg_rt_amt", getRgstScgRtAmt());		
		this.hashColumns.put("drp_off_lmt_qty", getDrpOffLmtQty());		
		this.hashColumns.put("diff_rmk", getDiffRmk());		
		this.hashColumns.put("drp_off_lmt_rto", getDrpOffLmtRto());		
		this.hashColumns.put("ste_nm", getSteNm());		
		this.hashColumns.put("max_dpc_rt_amt", getMaxDpcRtAmt());		
		this.hashColumns.put("ste_cd", getSteCd());		
		this.hashColumns.put("dpp_tp_cd", getDppTpCd());		
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
		this.hashFields.put("key_rntl_fm_tr_val", "keyRntlFmTrVal");
		this.hashFields.put("eq_tpsz_cd_sf4", "eqTpszCdSf4");
		this.hashFields.put("drp_off_lmt_tp_cd", "drpOffLmtTpCd");
		this.hashFields.put("dpp_cvrg_amt", "dppCvrgAmt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("lmsm_amt", "lmsmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_dpc_rt_amt", "monDpcRtAmt");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("drp_off_lmt_prd_cd", "drpOffLmtPrdCd");
		this.hashFields.put("rntl_to_tr_val", "rntlToTrVal");
		this.hashFields.put("eq_tpsz_cd_zt4", "eqTpszCdZt4");
		this.hashFields.put("offh_hndl_rt_amt", "offhHndlRtAmt");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("ohn_init_val_amt", "ohnInitValAmt");
		this.hashFields.put("rntl_to_title", "rntlToTitle");
		this.hashFields.put("eq_tpsz_cd_sf2", "eqTpszCdSf2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("chss_lse_rt_amt", "chssLseRtAmt");
		this.hashFields.put("eq_tpsz_cd_cb4", "eqTpszCdCb4");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("init_dpc_rt_amt", "initDpcRtAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("key_rntl_to_tr_val", "keyRntlToTrVal");
		this.hashFields.put("rntl_fm_title", "rntlFmTitle");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_tpsz_cd_gn4", "eqTpszCdGn4");
		this.hashFields.put("eq_tpsz_cd_gn5", "eqTpszCdGn5");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("eq_tpsz_cd_sl2", "eqTpszCdSl2");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dpp_rt_amt", "dppRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_eg8", "eqTpszCdEg8");
		this.hashFields.put("eq_tpsz_cd_ta2", "eqTpszCdTa2");
		this.hashFields.put("eq_tpsz_cd_eg5", "eqTpszCdEg5");
		this.hashFields.put("rntl_fm_tr_val", "rntlFmTrVal");
		this.hashFields.put("action_flag", "actionFlag");
		this.hashFields.put("tr_rt_amt", "trRtAmt");
		this.hashFields.put("onh_hndl_rt_amt", "onhHndlRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("key_ste_cd", "keySteCd");
		this.hashFields.put("eq_rntl_tp_cd", "eqRntlTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("rgst_scg_rt_amt", "rgstScgRtAmt");
		this.hashFields.put("drp_off_lmt_qty", "drpOffLmtQty");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("drp_off_lmt_rto", "drpOffLmtRto");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("max_dpc_rt_amt", "maxDpcRtAmt");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("dpp_tp_cd", "dppTpCd");
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
	* @param  keyRntlFmTrVal
	*/
	public void	setKeyRntlFmTrVal( String	keyRntlFmTrVal ) {
		this.keyRntlFmTrVal =	keyRntlFmTrVal;
	}
 
	/**
	 * Column Info
	 * @return	keyRntlFmTrVal
	 */
	 public	 String	getKeyRntlFmTrVal() {
		 return	this.keyRntlFmTrVal;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdSf4
	*/
	public void	setEqTpszCdSf4( String	eqTpszCdSf4 ) {
		this.eqTpszCdSf4 =	eqTpszCdSf4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSf4
	 */
	 public	 String	getEqTpszCdSf4() {
		 return	this.eqTpszCdSf4;
	 } 
 	/**
	* Column Info
	* @param  drpOffLmtTpCd
	*/
	public void	setDrpOffLmtTpCd( String	drpOffLmtTpCd ) {
		this.drpOffLmtTpCd =	drpOffLmtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	drpOffLmtTpCd
	 */
	 public	 String	getDrpOffLmtTpCd() {
		 return	this.drpOffLmtTpCd;
	 } 
 	/**
	* Column Info
	* @param  dppCvrgAmt
	*/
	public void	setDppCvrgAmt( String	dppCvrgAmt ) {
		this.dppCvrgAmt =	dppCvrgAmt;
	}
 
	/**
	 * Column Info
	 * @return	dppCvrgAmt
	 */
	 public	 String	getDppCvrgAmt() {
		 return	this.dppCvrgAmt;
	 } 
 	/**
	* Column Info
	* @param  chssPoolCd
	*/
	public void	setChssPoolCd( String	chssPoolCd ) {
		this.chssPoolCd =	chssPoolCd;
	}
 
	/**
	 * Column Info
	 * @return	chssPoolCd
	 */
	 public	 String	getChssPoolCd() {
		 return	this.chssPoolCd;
	 } 
 	/**
	* Column Info
	* @param  lmsmAmt
	*/
	public void	setLmsmAmt( String	lmsmAmt ) {
		this.lmsmAmt =	lmsmAmt;
	}
 
	/**
	 * Column Info
	 * @return	lmsmAmt
	 */
	 public	 String	getLmsmAmt() {
		 return	this.lmsmAmt;
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
	* @param  drpOffLmtPrdCd
	*/
	public void	setDrpOffLmtPrdCd( String	drpOffLmtPrdCd ) {
		this.drpOffLmtPrdCd =	drpOffLmtPrdCd;
	}
 
	/**
	 * Column Info
	 * @return	drpOffLmtPrdCd
	 */
	 public	 String	getDrpOffLmtPrdCd() {
		 return	this.drpOffLmtPrdCd;
	 } 
 	/**
	* Column Info
	* @param  rntlToTrVal
	*/
	public void	setRntlToTrVal( String	rntlToTrVal ) {
		this.rntlToTrVal =	rntlToTrVal;
	}
 
	/**
	 * Column Info
	 * @return	rntlToTrVal
	 */
	 public	 String	getRntlToTrVal() {
		 return	this.rntlToTrVal;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdZt4
	*/
	public void	setEqTpszCdZt4( String	eqTpszCdZt4 ) {
		this.eqTpszCdZt4 =	eqTpszCdZt4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdZt4
	 */
	 public	 String	getEqTpszCdZt4() {
		 return	this.eqTpszCdZt4;
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
	* @param  ohnInitValAmt
	*/
	public void	setOhnInitValAmt( String	ohnInitValAmt ) {
		this.ohnInitValAmt =	ohnInitValAmt;
	}
 
	/**
	 * Column Info
	 * @return	ohnInitValAmt
	 */
	 public	 String	getOhnInitValAmt() {
		 return	this.ohnInitValAmt;
	 } 
 	/**
	* Column Info
	* @param  rntlToTitle
	*/
	public void	setRntlToTitle( String	rntlToTitle ) {
		this.rntlToTitle =	rntlToTitle;
	}
 
	/**
	 * Column Info
	 * @return	rntlToTitle
	 */
	 public	 String	getRntlToTitle() {
		 return	this.rntlToTitle;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdSf2
	*/
	public void	setEqTpszCdSf2( String	eqTpszCdSf2 ) {
		this.eqTpszCdSf2 =	eqTpszCdSf2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSf2
	 */
	 public	 String	getEqTpszCdSf2() {
		 return	this.eqTpszCdSf2;
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
	* @param  chssLseRtAmt
	*/
	public void	setChssLseRtAmt( String	chssLseRtAmt ) {
		this.chssLseRtAmt =	chssLseRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	chssLseRtAmt
	 */
	 public	 String	getChssLseRtAmt() {
		 return	this.chssLseRtAmt;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdCb4
	*/
	public void	setEqTpszCdCb4( String	eqTpszCdCb4 ) {
		this.eqTpszCdCb4 =	eqTpszCdCb4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdCb4
	 */
	 public	 String	getEqTpszCdCb4() {
		 return	this.eqTpszCdCb4;
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
	* @param  keyRntlToTrVal
	*/
	public void	setKeyRntlToTrVal( String	keyRntlToTrVal ) {
		this.keyRntlToTrVal =	keyRntlToTrVal;
	}
 
	/**
	 * Column Info
	 * @return	keyRntlToTrVal
	 */
	 public	 String	getKeyRntlToTrVal() {
		 return	this.keyRntlToTrVal;
	 } 
 	/**
	* Column Info
	* @param  rntlFmTitle
	*/
	public void	setRntlFmTitle( String	rntlFmTitle ) {
		this.rntlFmTitle =	rntlFmTitle;
	}
 
	/**
	 * Column Info
	 * @return	rntlFmTitle
	 */
	 public	 String	getRntlFmTitle() {
		 return	this.rntlFmTitle;
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
	* @param  eqTpszCdGn4
	*/
	public void	setEqTpszCdGn4( String	eqTpszCdGn4 ) {
		this.eqTpszCdGn4 =	eqTpszCdGn4;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdGn4
	 */
	 public	 String	getEqTpszCdGn4() {
		 return	this.eqTpszCdGn4;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdGn5
	*/
	public void	setEqTpszCdGn5( String	eqTpszCdGn5 ) {
		this.eqTpszCdGn5 =	eqTpszCdGn5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdGn5
	 */
	 public	 String	getEqTpszCdGn5() {
		 return	this.eqTpszCdGn5;
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
	* @param  eqTpszCdSl2
	*/
	public void	setEqTpszCdSl2( String	eqTpszCdSl2 ) {
		this.eqTpszCdSl2 =	eqTpszCdSl2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdSl2
	 */
	 public	 String	getEqTpszCdSl2() {
		 return	this.eqTpszCdSl2;
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
	* @param  dppRtAmt
	*/
	public void	setDppRtAmt( String	dppRtAmt ) {
		this.dppRtAmt =	dppRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	dppRtAmt
	 */
	 public	 String	getDppRtAmt() {
		 return	this.dppRtAmt;
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
	* @param  eqTpszCdEg8
	*/
	public void	setEqTpszCdEg8( String	eqTpszCdEg8 ) {
		this.eqTpszCdEg8 =	eqTpszCdEg8;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdEg8
	 */
	 public	 String	getEqTpszCdEg8() {
		 return	this.eqTpszCdEg8;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdTa2
	*/
	public void	setEqTpszCdTa2( String	eqTpszCdTa2 ) {
		this.eqTpszCdTa2 =	eqTpszCdTa2;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdTa2
	 */
	 public	 String	getEqTpszCdTa2() {
		 return	this.eqTpszCdTa2;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCdEg5
	*/
	public void	setEqTpszCdEg5( String	eqTpszCdEg5 ) {
		this.eqTpszCdEg5 =	eqTpszCdEg5;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCdEg5
	 */
	 public	 String	getEqTpszCdEg5() {
		 return	this.eqTpszCdEg5;
	 } 
 	/**
	* Column Info
	* @param  rntlFmTrVal
	*/
	public void	setRntlFmTrVal( String	rntlFmTrVal ) {
		this.rntlFmTrVal =	rntlFmTrVal;
	}
 
	/**
	 * Column Info
	 * @return	rntlFmTrVal
	 */
	 public	 String	getRntlFmTrVal() {
		 return	this.rntlFmTrVal;
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
	* @param  trRtAmt
	*/
	public void	setTrRtAmt( String	trRtAmt ) {
		this.trRtAmt =	trRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	trRtAmt
	 */
	 public	 String	getTrRtAmt() {
		 return	this.trRtAmt;
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
	* @param  keySteCd
	*/
	public void	setKeySteCd( String	keySteCd ) {
		this.keySteCd =	keySteCd;
	}
 
	/**
	 * Column Info
	 * @return	keySteCd
	 */
	 public	 String	getKeySteCd() {
		 return	this.keySteCd;
	 } 
 	/**
	* Column Info
	* @param  eqRntlTpCd
	*/
	public void	setEqRntlTpCd( String	eqRntlTpCd ) {
		this.eqRntlTpCd =	eqRntlTpCd;
	}
 
	/**
	 * Column Info
	 * @return	eqRntlTpCd
	 */
	 public	 String	getEqRntlTpCd() {
		 return	this.eqRntlTpCd;
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
	* @param  rgstScgRtAmt
	*/
	public void	setRgstScgRtAmt( String	rgstScgRtAmt ) {
		this.rgstScgRtAmt =	rgstScgRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	rgstScgRtAmt
	 */
	 public	 String	getRgstScgRtAmt() {
		 return	this.rgstScgRtAmt;
	 } 
 	/**
	* Column Info
	* @param  drpOffLmtQty
	*/
	public void	setDrpOffLmtQty( String	drpOffLmtQty ) {
		this.drpOffLmtQty =	drpOffLmtQty;
	}
 
	/**
	 * Column Info
	 * @return	drpOffLmtQty
	 */
	 public	 String	getDrpOffLmtQty() {
		 return	this.drpOffLmtQty;
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
	* @param  drpOffLmtRto
	*/
	public void	setDrpOffLmtRto( String	drpOffLmtRto ) {
		this.drpOffLmtRto =	drpOffLmtRto;
	}
 
	/**
	 * Column Info
	 * @return	drpOffLmtRto
	 */
	 public	 String	getDrpOffLmtRto() {
		 return	this.drpOffLmtRto;
	 } 
 	/**
	* Column Info
	* @param  steNm
	*/
	public void	setSteNm( String	steNm ) {
		this.steNm =	steNm;
	}
 
	/**
	 * Column Info
	 * @return	steNm
	 */
	 public	 String	getSteNm() {
		 return	this.steNm;
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
	* @param  steCd
	*/
	public void	setSteCd( String	steCd ) {
		this.steCd =	steCd;
	}
 
	/**
	 * Column Info
	 * @return	steCd
	 */
	 public	 String	getSteCd() {
		 return	this.steCd;
	 } 
 	/**
	* Column Info
	* @param  dppTpCd
	*/
	public void	setDppTpCd( String	dppTpCd ) {
		this.dppTpCd =	dppTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dppTpCd
	 */
	 public	 String	getDppTpCd() {
		 return	this.dppTpCd;
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
	 * @return eqTpszCd20
	 */
	public String getEqTpszCd20() {
		return this.eqTpszCd20;
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
		setKeyRntlFmTrVal(JSPUtil.getParameter(request,	prefix + "key_rntl_fm_tr_val", ""));
		setEqTpszCdSf4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sf4", ""));
		setDrpOffLmtTpCd(JSPUtil.getParameter(request,	prefix + "drp_off_lmt_tp_cd", ""));
		setDppCvrgAmt(JSPUtil.getParameter(request,	prefix + "dpp_cvrg_amt", ""));
		setChssPoolCd(JSPUtil.getParameter(request,	prefix + "chss_pool_cd", ""));
		setLmsmAmt(JSPUtil.getParameter(request,	prefix + "lmsm_amt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMonDpcRtAmt(JSPUtil.getParameter(request,	prefix + "mon_dpc_rt_amt", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request,	prefix + "agmt_iss_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setDrpOffLmtPrdCd(JSPUtil.getParameter(request,	prefix + "drp_off_lmt_prd_cd", ""));
		setRntlToTrVal(JSPUtil.getParameter(request,	prefix + "rntl_to_tr_val", ""));
		setEqTpszCdZt4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_zt4", ""));
		setOffhHndlRtAmt(JSPUtil.getParameter(request,	prefix + "offh_hndl_rt_amt", ""));
		setAgmtExpDt(JSPUtil.getParameter(request,	prefix + "agmt_exp_dt", ""));
		setOhnInitValAmt(JSPUtil.getParameter(request,	prefix + "ohn_init_val_amt", ""));
		setRntlToTitle(JSPUtil.getParameter(request,	prefix + "rntl_to_title", ""));
		setEqTpszCdSf2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sf2", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setAgmtRefNo(JSPUtil.getParameter(request,	prefix + "agmt_ref_no", ""));
		setChssLseRtAmt(JSPUtil.getParameter(request,	prefix + "chss_lse_rt_amt", ""));
		setEqTpszCdCb4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_cb4", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "agmt_lstm_cd", ""));
		setPayTermDys(JSPUtil.getParameter(request,	prefix + "pay_term_dys", ""));
		setInitDpcRtAmt(JSPUtil.getParameter(request,	prefix + "init_dpc_rt_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setKeyRntlToTrVal(JSPUtil.getParameter(request,	prefix + "key_rntl_to_tr_val", ""));
		setRntlFmTitle(JSPUtil.getParameter(request,	prefix + "rntl_fm_title", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setEqTpszCdGn4(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_gn4", ""));
		setEqTpszCdGn5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_gn5", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_ofc_cty_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request,	prefix + "agmt_ver_no", ""));
		setLstVerFlg(JSPUtil.getParameter(request,	prefix + "lst_ver_flg", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPreEffDt(JSPUtil.getParameter(request,	prefix + "pre_eff_dt", ""));
		setEqTpszCdSl2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_sl2", ""));
		setAgmtDt(JSPUtil.getParameter(request,	prefix + "agmt_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setDppRtAmt(JSPUtil.getParameter(request,	prefix + "dpp_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqTpszCdEg8(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_eg8", ""));
		setEqTpszCdTa2(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_ta2", ""));
		setEqTpszCdEg5(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd_eg5", ""));
		setRntlFmTrVal(JSPUtil.getParameter(request,	prefix + "rntl_fm_tr_val", ""));
		setActionFlag(JSPUtil.getParameter(request,	prefix + "action_flag", ""));
		setTrRtAmt(JSPUtil.getParameter(request,	prefix + "tr_rt_amt", ""));
		setOnhHndlRtAmt(JSPUtil.getParameter(request,	prefix + "onh_hndl_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setPreExpDt(JSPUtil.getParameter(request,	prefix + "pre_exp_dt", ""));
		setKeySteCd(JSPUtil.getParameter(request,	prefix + "key_ste_cd", ""));
		setEqRntlTpCd(JSPUtil.getParameter(request,	prefix + "eq_rntl_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setRgstScgRtAmt(JSPUtil.getParameter(request,	prefix + "rgst_scg_rt_amt", ""));
		setDrpOffLmtQty(JSPUtil.getParameter(request,	prefix + "drp_off_lmt_qty", ""));
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setDrpOffLmtRto(JSPUtil.getParameter(request,	prefix + "drp_off_lmt_rto", ""));
		setSteNm(JSPUtil.getParameter(request,	prefix + "ste_nm", ""));
		setMaxDpcRtAmt(JSPUtil.getParameter(request,	prefix + "max_dpc_rt_amt", ""));
		setSteCd(JSPUtil.getParameter(request,	prefix + "ste_cd", ""));
		setDppTpCd(JSPUtil.getParameter(request,	prefix + "dpp_tp_cd", ""));
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
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CHSAgreementINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] agmtEffDt =	(JSPUtil.getParameter(request, prefix +	"agmt_eff_dt".trim(),	length));
				String[] keyRntlFmTrVal =	(JSPUtil.getParameter(request, prefix +	"key_rntl_fm_tr_val".trim(),	length));
				String[] eqTpszCdSf4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sf4".trim(),	length));
				String[] drpOffLmtTpCd =	(JSPUtil.getParameter(request, prefix +	"drp_off_lmt_tp_cd".trim(),	length));
				String[] dppCvrgAmt =	(JSPUtil.getParameter(request, prefix +	"dpp_cvrg_amt".trim(),	length));
				String[] chssPoolCd =	(JSPUtil.getParameter(request, prefix +	"chss_pool_cd".trim(),	length));
				String[] lmsmAmt =	(JSPUtil.getParameter(request, prefix +	"lmsm_amt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] monDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"mon_dpc_rt_amt".trim(),	length));
				String[] agmtIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"agmt_iss_ofc_cd".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] drpOffLmtPrdCd =	(JSPUtil.getParameter(request, prefix +	"drp_off_lmt_prd_cd".trim(),	length));
				String[] rntlToTrVal =	(JSPUtil.getParameter(request, prefix +	"rntl_to_tr_val".trim(),	length));
				String[] eqTpszCdZt4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_zt4".trim(),	length));
				String[] offhHndlRtAmt =	(JSPUtil.getParameter(request, prefix +	"offh_hndl_rt_amt".trim(),	length));
				String[] agmtExpDt =	(JSPUtil.getParameter(request, prefix +	"agmt_exp_dt".trim(),	length));
				String[] ohnInitValAmt =	(JSPUtil.getParameter(request, prefix +	"ohn_init_val_amt".trim(),	length));
				String[] rntlToTitle =	(JSPUtil.getParameter(request, prefix +	"rntl_to_title".trim(),	length));
				String[] eqTpszCdSf2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sf2".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] agmtRefNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ref_no".trim(),	length));
				String[] chssLseRtAmt =	(JSPUtil.getParameter(request, prefix +	"chss_lse_rt_amt".trim(),	length));
				String[] eqTpszCdCb4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_cb4".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] agmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_lstm_cd".trim(),	length));
				String[] payTermDys =	(JSPUtil.getParameter(request, prefix +	"pay_term_dys".trim(),	length));
				String[] initDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"init_dpc_rt_amt".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] keyRntlToTrVal =	(JSPUtil.getParameter(request, prefix +	"key_rntl_to_tr_val".trim(),	length));
				String[] rntlFmTitle =	(JSPUtil.getParameter(request, prefix +	"rntl_fm_title".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] eqTpszCdGn4 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_gn4".trim(),	length));
				String[] eqTpszCdGn5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_gn5".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] agmtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_ofc_cty_cd".trim(),	length));
				String[] agmtVerNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ver_no".trim(),	length));
				String[] lstVerFlg =	(JSPUtil.getParameter(request, prefix +	"lst_ver_flg".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] preEffDt =	(JSPUtil.getParameter(request, prefix +	"pre_eff_dt".trim(),	length));
				String[] eqTpszCdSl2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_sl2".trim(),	length));
				String[] agmtDt =	(JSPUtil.getParameter(request, prefix +	"agmt_dt".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] dppRtAmt =	(JSPUtil.getParameter(request, prefix +	"dpp_rt_amt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqTpszCdEg8 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_eg8".trim(),	length));
				String[] eqTpszCdTa2 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_ta2".trim(),	length));
				String[] eqTpszCdEg5 =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd_eg5".trim(),	length));
				String[] rntlFmTrVal =	(JSPUtil.getParameter(request, prefix +	"rntl_fm_tr_val".trim(),	length));
				String[] actionFlag =	(JSPUtil.getParameter(request, prefix +	"action_flag".trim(),	length));
				String[] trRtAmt =	(JSPUtil.getParameter(request, prefix +	"tr_rt_amt".trim(),	length));
				String[] onhHndlRtAmt =	(JSPUtil.getParameter(request, prefix +	"onh_hndl_rt_amt".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] preExpDt =	(JSPUtil.getParameter(request, prefix +	"pre_exp_dt".trim(),	length));
				String[] keySteCd =	(JSPUtil.getParameter(request, prefix +	"key_ste_cd".trim(),	length));
				String[] eqRntlTpCd =	(JSPUtil.getParameter(request, prefix +	"eq_rntl_tp_cd".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] rgstScgRtAmt =	(JSPUtil.getParameter(request, prefix +	"rgst_scg_rt_amt".trim(),	length));
				String[] drpOffLmtQty =	(JSPUtil.getParameter(request, prefix +	"drp_off_lmt_qty".trim(),	length));
				String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk".trim(),	length));
				String[] drpOffLmtRto =	(JSPUtil.getParameter(request, prefix +	"drp_off_lmt_rto".trim(),	length));
				String[] steNm =	(JSPUtil.getParameter(request, prefix +	"ste_nm".trim(),	length));
				String[] maxDpcRtAmt =	(JSPUtil.getParameter(request, prefix +	"max_dpc_rt_amt".trim(),	length));
				String[] steCd =	(JSPUtil.getParameter(request, prefix +	"ste_cd".trim(),	length));
				String[] dppTpCd =	(JSPUtil.getParameter(request, prefix +	"dpp_tp_cd".trim(),	length));
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
					model =	new	CHSAgreementINVO();
						if ( agmtEffDt[i] !=	null)
						model.setAgmtEffDt( agmtEffDt[i]);
						if ( keyRntlFmTrVal[i] !=	null)
						model.setKeyRntlFmTrVal( keyRntlFmTrVal[i]);
						if ( eqTpszCdSf4[i] !=	null)
						model.setEqTpszCdSf4( eqTpszCdSf4[i]);
						if ( drpOffLmtTpCd[i] !=	null)
						model.setDrpOffLmtTpCd( drpOffLmtTpCd[i]);
						if ( dppCvrgAmt[i] !=	null)
						model.setDppCvrgAmt( dppCvrgAmt[i]);
						if ( chssPoolCd[i] !=	null)
						model.setChssPoolCd( chssPoolCd[i]);
						if ( lmsmAmt[i] !=	null)
						model.setLmsmAmt( lmsmAmt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( monDpcRtAmt[i] !=	null)
						model.setMonDpcRtAmt( monDpcRtAmt[i]);
						if ( agmtIssOfcCd[i] !=	null)
						model.setAgmtIssOfcCd( agmtIssOfcCd[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( drpOffLmtPrdCd[i] !=	null)
						model.setDrpOffLmtPrdCd( drpOffLmtPrdCd[i]);
						if ( rntlToTrVal[i] !=	null)
						model.setRntlToTrVal( rntlToTrVal[i]);
						if ( eqTpszCdZt4[i] !=	null)
						model.setEqTpszCdZt4( eqTpszCdZt4[i]);
						if ( offhHndlRtAmt[i] !=	null)
						model.setOffhHndlRtAmt( offhHndlRtAmt[i]);
						if ( agmtExpDt[i] !=	null)
						model.setAgmtExpDt( agmtExpDt[i]);
						if ( ohnInitValAmt[i] !=	null)
						model.setOhnInitValAmt( ohnInitValAmt[i]);
						if ( rntlToTitle[i] !=	null)
						model.setRntlToTitle( rntlToTitle[i]);
						if ( eqTpszCdSf2[i] !=	null)
						model.setEqTpszCdSf2( eqTpszCdSf2[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( agmtRefNo[i] !=	null)
						model.setAgmtRefNo( agmtRefNo[i]);
						if ( chssLseRtAmt[i] !=	null)
						model.setChssLseRtAmt( chssLseRtAmt[i]);
						if ( eqTpszCdCb4[i] !=	null)
						model.setEqTpszCdCb4( eqTpszCdCb4[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( agmtLstmCd[i] !=	null)
						model.setAgmtLstmCd( agmtLstmCd[i]);
						if ( payTermDys[i] !=	null)
						model.setPayTermDys( payTermDys[i]);
						if ( initDpcRtAmt[i] !=	null)
						model.setInitDpcRtAmt( initDpcRtAmt[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( keyRntlToTrVal[i] !=	null)
						model.setKeyRntlToTrVal( keyRntlToTrVal[i]);
						if ( rntlFmTitle[i] !=	null)
						model.setRntlFmTitle( rntlFmTitle[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( eqTpszCdGn4[i] !=	null)
						model.setEqTpszCdGn4( eqTpszCdGn4[i]);
						if ( eqTpszCdGn5[i] !=	null)
						model.setEqTpszCdGn5( eqTpszCdGn5[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( agmtOfcCtyCd[i] !=	null)
						model.setAgmtOfcCtyCd( agmtOfcCtyCd[i]);
						if ( agmtVerNo[i] !=	null)
						model.setAgmtVerNo( agmtVerNo[i]);
						if ( lstVerFlg[i] !=	null)
						model.setLstVerFlg( lstVerFlg[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( preEffDt[i] !=	null)
						model.setPreEffDt( preEffDt[i]);
						if ( eqTpszCdSl2[i] !=	null)
						model.setEqTpszCdSl2( eqTpszCdSl2[i]);
						if ( agmtDt[i] !=	null)
						model.setAgmtDt( agmtDt[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( dppRtAmt[i] !=	null)
						model.setDppRtAmt( dppRtAmt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqTpszCdEg8[i] !=	null)
						model.setEqTpszCdEg8( eqTpszCdEg8[i]);
						if ( eqTpszCdTa2[i] !=	null)
						model.setEqTpszCdTa2( eqTpszCdTa2[i]);
						if ( eqTpszCdEg5[i] !=	null)
						model.setEqTpszCdEg5( eqTpszCdEg5[i]);
						if ( rntlFmTrVal[i] !=	null)
						model.setRntlFmTrVal( rntlFmTrVal[i]);
						if ( actionFlag[i] !=	null)
						model.setActionFlag( actionFlag[i]);
						if ( trRtAmt[i] !=	null)
						model.setTrRtAmt( trRtAmt[i]);
						if ( onhHndlRtAmt[i] !=	null)
						model.setOnhHndlRtAmt( onhHndlRtAmt[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( preExpDt[i] !=	null)
						model.setPreExpDt( preExpDt[i]);
						if ( keySteCd[i] !=	null)
						model.setKeySteCd( keySteCd[i]);
						if ( eqRntlTpCd[i] !=	null)
						model.setEqRntlTpCd( eqRntlTpCd[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( rgstScgRtAmt[i] !=	null)
						model.setRgstScgRtAmt( rgstScgRtAmt[i]);
						if ( drpOffLmtQty[i] !=	null)
						model.setDrpOffLmtQty( drpOffLmtQty[i]);
						if ( diffRmk[i] !=	null)
						model.setDiffRmk( diffRmk[i]);
						if ( drpOffLmtRto[i] !=	null)
						model.setDrpOffLmtRto( drpOffLmtRto[i]);
						if ( steNm[i] !=	null)
						model.setSteNm( steNm[i]);
						if ( maxDpcRtAmt[i] !=	null)
						model.setMaxDpcRtAmt( maxDpcRtAmt[i]);
						if ( steCd[i] !=	null)
						model.setSteCd( steCd[i]);
						if ( dppTpCd[i] !=	null)
						model.setDppTpCd( dppTpCd[i]);
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
		return getCHSAgreementINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[]	 getCHSAgreementINVOs(){
		CHSAgreementINVO[] vos = (CHSAgreementINVO[])models.toArray(new	CHSAgreementINVO[models.size()]);
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
		this.keyRntlFmTrVal =	this.keyRntlFmTrVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf4 =	this.eqTpszCdSf4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtTpCd =	this.drpOffLmtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppCvrgAmt =	this.dppCvrgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd =	this.chssPoolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmsmAmt =	this.lmsmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monDpcRtAmt =	this.monDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd =	this.agmtIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtPrdCd =	this.drpOffLmtPrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlToTrVal =	this.rntlToTrVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdZt4 =	this.eqTpszCdZt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhHndlRtAmt =	this.offhHndlRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt =	this.agmtExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohnInitValAmt =	this.ohnInitValAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlToTitle =	this.rntlToTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf2 =	this.eqTpszCdSf2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo =	this.agmtRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssLseRtAmt =	this.chssLseRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdCb4 =	this.eqTpszCdCb4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd =	this.agmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys =	this.payTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDpcRtAmt =	this.initDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyRntlToTrVal =	this.keyRntlToTrVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlFmTitle =	this.rntlFmTitle.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn4 =	this.eqTpszCdGn4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn5 =	this.eqTpszCdGn5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd =	this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo =	this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstVerFlg =	this.lstVerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt =	this.preEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSl2 =	this.eqTpszCdSl2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt =	this.agmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppRtAmt =	this.dppRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg8 =	this.eqTpszCdEg8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTa2 =	this.eqTpszCdTa2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg5 =	this.eqTpszCdEg5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlFmTrVal =	this.rntlFmTrVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionFlag =	this.actionFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trRtAmt =	this.trRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhHndlRtAmt =	this.onhHndlRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt =	this.preExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keySteCd =	this.keySteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRntlTpCd =	this.eqRntlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstScgRtAmt =	this.rgstScgRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtQty =	this.drpOffLmtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtRto =	this.drpOffLmtRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm =	this.steNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRtAmt =	this.maxDpcRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd =	this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppTpCd =	this.dppTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.oldAgmtNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}