/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AgentRateDetailVO.java
 *@FileTitle : AgentRateDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.03.23
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.03.23  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
 
/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AgentRateDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AgentRateDetailVO>  models =	new	ArrayList<AgentRateDetailVO>();


	/*	Column Info	*/
	private  String	 repChgCd   =  null;
	/*	Column Info	*/
	private  String	 por   =  null;
	/*	Column Info	*/
	private  String	 por3   =  null;
	/*	Column Info	*/
	private  String	 por4   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 pol   =  null;
	/*	Column Info	*/
	private  String	 acTpCd   =  null;
	/*	Column Info	*/
	private  String	 fdrgDdctOrgFlg   =  null;
	/*	Column Info	*/
	private  String	 pod   =  null;
	/*	Column Info	*/
	private  String	 fdrgDdctDestFlg   =  null;
	/*	Column Info	*/
	private  String	 polLvlCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCvrgCd   =  null;
	/*	Column Info	*/
	private  String	 podLvlCd   =  null;
	/*	Column Info	*/
	private  String	 commRt   =  null;
	/*	Column Info	*/
	private  String	 commFxAmt   =  null;
	/*	Column Info	*/
	private  String	 pol4   =  null;
	/*	Column Info	*/
	private  String	 ofcSetTpCd   =  null;
	/*	Column Info	*/
	private  String	 pol3   =  null;
	/*	Column Info	*/
	private  String	 pol2   =  null;
	/*	Column Info	*/
	private  String	 pol1   =  null;
	/*	Column Info	*/
	private  String	 hlgDdctOrgFlg   =  null;
	/*	Column Info	*/
	private  String	 pod2   =  null;
	/*	Column Info	*/
	private  String	 pod1   =  null;
	/*	Column Info	*/
	private  String	 pod4   =  null;
	/*	Column Info	*/
	private  String	 pod3   =  null;
	/*	Column Info	*/
	private  String	 rateDiv   =  null;
	/*	Column Info	*/
	private  String	 fullMtyCd   =  null;
	/*	Column Info	*/
	private  String	 oftPayTermCd   =  null;
	/*	Column Info	*/
	private  String	 delLvlCd   =  null;
	/*	Column Info	*/
	private  String	 revDivCd   =  null;
	/*	Column Info	*/
	private  String	 agmtHisNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 agmtDtlPk   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 agnCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 del   =  null;
	/*	Column Info	*/
	private  String	 commPayTermCd   =  null;
	/*	Column Info	*/
	private  String	 del2   =  null;
	/*	Column Info	*/
	private  String	 del1   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 del4   =  null;
	/*	Column Info	*/
	private  String	 del3   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 por2   =  null;
	/*	Column Info	*/
	private  String	 porLvlCd   =  null;
	/*	Column Info	*/
	private  String	 por1   =  null;
	/*	Column Info	*/
	private  String	 hlgDdctDestFlg   =  null;
	/*	Column Info	*/
	private  String	 commChgCd   =  null;
	/*	Column Info	*/
	private  String	 chgCommDivCd   =  null;
	/*	Column Info	*/
	private  String	 chgCommRt   =  null;
	/*	Column Info	*/
	private  String	 chgCommOtrAmt   =  null;
	/*	Column Info	*/
	private  String	 chgCommCurrCd   =  null;
	/*	Column Info	*/
	private  String	 chgCommPayTermCd   =  null;
	/*	Column Info	*/
	private  String	 chgCommRateDiv   =  null;
	/*	Column Info	*/
	private  String	 minCommDivCd   =  null;
	/*	Column Info	*/
	private  String	 minCommRt   =  null;
	/*	Column Info	*/
	private  String	 minCommCurrCd   =  null;
	/*	Column Info	*/
	private  String	 minCommPerCd   =  null;
	/*	Column Info	*/
	private  String	 minCommNetRevAmt   =  null;
	/*	Column Info	*/
	private  String	 minCommNetRevCurrCd   =  null;
	/*	Column Info	*/
	private  String	 agnAgmtMinCommSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AgentRateDetailVO(){}

	public AgentRateDetailVO(String repChgCd,String por,String por3,String por4,String chgCd,String pagerows,String agnAgmtSeq,String cntrTpszCd,String pol,String acTpCd,String fdrgDdctOrgFlg,String pod,String fdrgDdctDestFlg,String polLvlCd,String ofcCvrgCd,String podLvlCd,String commRt,String commFxAmt,String pol4,String ofcSetTpCd,String pol3,String pol2,String pol1,String hlgDdctOrgFlg,String pod2,String pod1,String pod4,String pod3,String rateDiv,String fullMtyCd,String oftPayTermCd,String delLvlCd,String revDivCd,String agmtHisNo,String currCd,String agmtDtlPk,String agnAgmtNo,String agnCd,String ibflag,String usrId,String del,String commPayTermCd,String del2,String del1,String ioBndCd,String del4,String del3,String ofcCd,String por2,String porLvlCd,String por1,String hlgDdctDestFlg,String commChgCd,String chgCommDivCd,String chgCommRt,String chgCommOtrAmt,String chgCommCurrCd,String chgCommPayTermCd,String chgCommRateDiv,String minCommDivCd,String minCommRt,String minCommCurrCd,String minCommPerCd,String minCommNetRevAmt,String minCommNetRevCurrCd,String agnAgmtMinCommSeq)	{
		this.repChgCd  = repChgCd ;
		this.por  = por ;
		this.por3  = por3 ;
		this.por4  = por4 ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.agnAgmtSeq  = agnAgmtSeq ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.pol  = pol ;
		this.acTpCd  = acTpCd ;
		this.fdrgDdctOrgFlg  = fdrgDdctOrgFlg ;
		this.pod  = pod ;
		this.fdrgDdctDestFlg  = fdrgDdctDestFlg ;
		this.polLvlCd  = polLvlCd ;
		this.ofcCvrgCd  = ofcCvrgCd ;
		this.podLvlCd  = podLvlCd ;
		this.commRt  = commRt ;
		this.commFxAmt  = commFxAmt ;
		this.pol4  = pol4 ;
		this.ofcSetTpCd  = ofcSetTpCd ;
		this.pol3  = pol3 ;
		this.pol2  = pol2 ;
		this.pol1  = pol1 ;
		this.hlgDdctOrgFlg  = hlgDdctOrgFlg ;
		this.pod2  = pod2 ;
		this.pod1  = pod1 ;
		this.pod4  = pod4 ;
		this.pod3  = pod3 ;
		this.rateDiv  = rateDiv ;
		this.fullMtyCd  = fullMtyCd ;
		this.oftPayTermCd  = oftPayTermCd ;
		this.delLvlCd  = delLvlCd ;
		this.revDivCd  = revDivCd ;
		this.agmtHisNo  = agmtHisNo ;
		this.currCd  = currCd ;
		this.agmtDtlPk  = agmtDtlPk ;
		this.agnAgmtNo  = agnAgmtNo ;
		this.agnCd  = agnCd ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.del  = del ;
		this.commPayTermCd  = commPayTermCd ;
		this.del2  = del2 ;
		this.del1  = del1 ;
		this.ioBndCd  = ioBndCd ;
		this.del4  = del4 ;
		this.del3  = del3 ;
		this.ofcCd  = ofcCd ;
		this.por2  = por2 ;
		this.porLvlCd  = porLvlCd ;
		this.por1  = por1 ;
		this.hlgDdctDestFlg  = hlgDdctDestFlg ;
		this.commChgCd  = commChgCd ;
		this.chgCommDivCd  = chgCommDivCd ;
		this.chgCommRt  = chgCommRt ;
		this.chgCommOtrAmt  = chgCommOtrAmt ;
		this.chgCommCurrCd  = chgCommCurrCd ;
		this.chgCommPayTermCd  = chgCommPayTermCd ;
		this.chgCommRateDiv  = chgCommRateDiv ;
		this.minCommDivCd  = minCommDivCd ;
		this.minCommRt  = minCommRt ;
		this.minCommCurrCd  = minCommCurrCd ;
		this.minCommPerCd  = minCommPerCd ;
		this.minCommNetRevAmt  = minCommNetRevAmt ;
		this.minCommNetRevCurrCd  = minCommNetRevCurrCd ;
		this.agnAgmtMinCommSeq  = agnAgmtMinCommSeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());		
		this.hashColumns.put("por", getPor());		
		this.hashColumns.put("por_3", getPor3());		
		this.hashColumns.put("por_4", getPor4());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("pol", getPol());		
		this.hashColumns.put("ac_tp_cd", getAcTpCd());		
		this.hashColumns.put("fdrg_ddct_org_flg", getFdrgDdctOrgFlg());		
		this.hashColumns.put("pod", getPod());		
		this.hashColumns.put("fdrg_ddct_dest_flg", getFdrgDdctDestFlg());		
		this.hashColumns.put("pol_lvl_cd", getPolLvlCd());		
		this.hashColumns.put("ofc_cvrg_cd", getOfcCvrgCd());		
		this.hashColumns.put("pod_lvl_cd", getPodLvlCd());		
		this.hashColumns.put("comm_rt", getCommRt());		
		this.hashColumns.put("comm_fx_amt", getCommFxAmt());		
		this.hashColumns.put("pol_4", getPol4());		
		this.hashColumns.put("ofc_set_tp_cd", getOfcSetTpCd());		
		this.hashColumns.put("pol_3", getPol3());		
		this.hashColumns.put("pol_2", getPol2());		
		this.hashColumns.put("pol_1", getPol1());		
		this.hashColumns.put("hlg_ddct_org_flg", getHlgDdctOrgFlg());		
		this.hashColumns.put("pod_2", getPod2());		
		this.hashColumns.put("pod_1", getPod1());		
		this.hashColumns.put("pod_4", getPod4());		
		this.hashColumns.put("pod_3", getPod3());		
		this.hashColumns.put("rate_div", getRateDiv());		
		this.hashColumns.put("full_mty_cd", getFullMtyCd());		
		this.hashColumns.put("oft_pay_term_cd", getOftPayTermCd());		
		this.hashColumns.put("del_lvl_cd", getDelLvlCd());		
		this.hashColumns.put("rev_div_cd", getRevDivCd());		
		this.hashColumns.put("agmt_his_no", getAgmtHisNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("agmt_dtl_pk", getAgmtDtlPk());		
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());		
		this.hashColumns.put("agn_cd", getAgnCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("del", getDel());		
		this.hashColumns.put("comm_pay_term_cd", getCommPayTermCd());		
		this.hashColumns.put("del_2", getDel2());		
		this.hashColumns.put("del_1", getDel1());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("del_4", getDel4());		
		this.hashColumns.put("del_3", getDel3());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("por_2", getPor2());		
		this.hashColumns.put("por_lvl_cd", getPorLvlCd());		
		this.hashColumns.put("por_1", getPor1());		
		this.hashColumns.put("hlg_ddct_dest_flg", getHlgDdctDestFlg());		
		this.hashColumns.put("comm_chg_cd", getCommChgCd());		
		this.hashColumns.put("chg_comm_div_cd", getChgCommDivCd());		
		this.hashColumns.put("chg_comm_rt", getChgCommRt());		
		this.hashColumns.put("chg_comm_otr_amt", getChgCommOtrAmt());		
		this.hashColumns.put("chg_comm_curr_cd", getChgCommCurrCd());		
		this.hashColumns.put("chg_comm_pay_term_cd", getChgCommPayTermCd());		
		this.hashColumns.put("chg_comm_rate_div", getChgCommRateDiv());		
		this.hashColumns.put("min_comm_div_cd", getMinCommDivCd());		
		this.hashColumns.put("min_comm_rt", getMinCommRt());		
		this.hashColumns.put("min_comm_curr_cd", getMinCommCurrCd());		
		this.hashColumns.put("min_comm_per_cd", getMinCommPerCd());		
		this.hashColumns.put("min_comm_net_rev_amt", getMinCommNetRevAmt());		
		this.hashColumns.put("min_comm_net_rev_curr_cd", getMinCommNetRevCurrCd());		
		this.hashColumns.put("agn_agmt_min_comm_seq", getAgnAgmtMinCommSeq());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("por", "por");
		this.hashFields.put("por_3", "por3");
		this.hashFields.put("por_4", "por4");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("fdrg_ddct_org_flg", "fdrgDdctOrgFlg");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("fdrg_ddct_dest_flg", "fdrgDdctDestFlg");
		this.hashFields.put("pol_lvl_cd", "polLvlCd");
		this.hashFields.put("ofc_cvrg_cd", "ofcCvrgCd");
		this.hashFields.put("pod_lvl_cd", "podLvlCd");
		this.hashFields.put("comm_rt", "commRt");
		this.hashFields.put("comm_fx_amt", "commFxAmt");
		this.hashFields.put("pol_4", "pol4");
		this.hashFields.put("ofc_set_tp_cd", "ofcSetTpCd");
		this.hashFields.put("pol_3", "pol3");
		this.hashFields.put("pol_2", "pol2");
		this.hashFields.put("pol_1", "pol1");
		this.hashFields.put("hlg_ddct_org_flg", "hlgDdctOrgFlg");
		this.hashFields.put("pod_2", "pod2");
		this.hashFields.put("pod_1", "pod1");
		this.hashFields.put("pod_4", "pod4");
		this.hashFields.put("pod_3", "pod3");
		this.hashFields.put("rate_div", "rateDiv");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("oft_pay_term_cd", "oftPayTermCd");
		this.hashFields.put("del_lvl_cd", "delLvlCd");
		this.hashFields.put("rev_div_cd", "revDivCd");
		this.hashFields.put("agmt_his_no", "agmtHisNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_dtl_pk", "agmtDtlPk");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("del", "del");
		this.hashFields.put("comm_pay_term_cd", "commPayTermCd");
		this.hashFields.put("del_2", "del2");
		this.hashFields.put("del_1", "del1");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("del_4", "del4");
		this.hashFields.put("del_3", "del3");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("por_2", "por2");
		this.hashFields.put("por_lvl_cd", "porLvlCd");
		this.hashFields.put("por_1", "por1");
		this.hashFields.put("hlg_ddct_dest_flg", "hlgDdctDestFlg");
		this.hashFields.put("comm_chg_cd", "commChgCd");
		this.hashFields.put("chg_comm_div_cd", "chgCommDivCd");
		this.hashFields.put("chg_comm_rt", "chgCommRt");
		this.hashFields.put("chg_comm_otr_amt", "chgCommOtrAmt");
		this.hashFields.put("chg_comm_curr_cd", "chgCommCurrCd");
		this.hashFields.put("chg_comm_pay_term_cd", "chgCommPayTermCd");
		this.hashFields.put("chg_comm_rate_div", "chgCommRateDiv");
		this.hashFields.put("min_comm_div_cd", "minCommDivCd");
		this.hashFields.put("min_comm_rt", "minCommRt");
		this.hashFields.put("min_comm_curr_cd", "minCommCurrCd");
		this.hashFields.put("min_comm_per_cd", "minCommPerCd");
		this.hashFields.put("min_comm_net_rev_amt", "minCommNetRevAmt");
		this.hashFields.put("min_comm_net_rev_curr_cd", "minCommNetRevCurrCd");
		this.hashFields.put("agn_agmt_min_comm_seq", "agnAgmtMinCommSeq");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  repChgCd
	*/
	public void	setRepChgCd( String	repChgCd ) {
		this.repChgCd =	repChgCd;
	}
 
	/**
	 * Column Info
	 * @return	repChgCd
	 */
	 public	 String	getRepChgCd() {
		 return	this.repChgCd;
	 } 
 	/**
	* Column Info
	* @param  por
	*/
	public void	setPor( String	por ) {
		this.por =	por;
	}
 
	/**
	 * Column Info
	 * @return	por
	 */
	 public	 String	getPor() {
		 return	this.por;
	 } 
 	/**
	* Column Info
	* @param  por3
	*/
	public void	setPor3( String	por3 ) {
		this.por3 =	por3;
	}
 
	/**
	 * Column Info
	 * @return	por3
	 */
	 public	 String	getPor3() {
		 return	this.por3;
	 } 
 	/**
	* Column Info
	* @param  por4
	*/
	public void	setPor4( String	por4 ) {
		this.por4 =	por4;
	}
 
	/**
	 * Column Info
	 * @return	por4
	 */
	 public	 String	getPor4() {
		 return	this.por4;
	 } 
 	/**
	* Column Info
	* @param  chgCd
	*/
	public void	setChgCd( String	chgCd ) {
		this.chgCd =	chgCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCd
	 */
	 public	 String	getChgCd() {
		 return	this.chgCd;
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
	* @param  agnAgmtSeq
	*/
	public void	setAgnAgmtSeq( String	agnAgmtSeq ) {
		this.agnAgmtSeq =	agnAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtSeq
	 */
	 public	 String	getAgnAgmtSeq() {
		 return	this.agnAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  pol
	*/
	public void	setPol( String	pol ) {
		this.pol =	pol;
	}
 
	/**
	 * Column Info
	 * @return	pol
	 */
	 public	 String	getPol() {
		 return	this.pol;
	 } 
 	/**
	* Column Info
	* @param  acTpCd
	*/
	public void	setAcTpCd( String	acTpCd ) {
		this.acTpCd =	acTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acTpCd
	 */
	 public	 String	getAcTpCd() {
		 return	this.acTpCd;
	 } 
 	/**
	* Column Info
	* @param  fdrgDdctOrgFlg
	*/
	public void	setFdrgDdctOrgFlg( String	fdrgDdctOrgFlg ) {
		this.fdrgDdctOrgFlg =	fdrgDdctOrgFlg;
	}
 
	/**
	 * Column Info
	 * @return	fdrgDdctOrgFlg
	 */
	 public	 String	getFdrgDdctOrgFlg() {
		 return	this.fdrgDdctOrgFlg;
	 } 
 	/**
	* Column Info
	* @param  pod
	*/
	public void	setPod( String	pod ) {
		this.pod =	pod;
	}
 
	/**
	 * Column Info
	 * @return	pod
	 */
	 public	 String	getPod() {
		 return	this.pod;
	 } 
 	/**
	* Column Info
	* @param  fdrgDdctDestFlg
	*/
	public void	setFdrgDdctDestFlg( String	fdrgDdctDestFlg ) {
		this.fdrgDdctDestFlg =	fdrgDdctDestFlg;
	}
 
	/**
	 * Column Info
	 * @return	fdrgDdctDestFlg
	 */
	 public	 String	getFdrgDdctDestFlg() {
		 return	this.fdrgDdctDestFlg;
	 } 
 	/**
	* Column Info
	* @param  polLvlCd
	*/
	public void	setPolLvlCd( String	polLvlCd ) {
		this.polLvlCd =	polLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	polLvlCd
	 */
	 public	 String	getPolLvlCd() {
		 return	this.polLvlCd;
	 } 
 	/**
	* Column Info
	* @param  ofcCvrgCd
	*/
	public void	setOfcCvrgCd( String	ofcCvrgCd ) {
		this.ofcCvrgCd =	ofcCvrgCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCvrgCd
	 */
	 public	 String	getOfcCvrgCd() {
		 return	this.ofcCvrgCd;
	 } 
 	/**
	* Column Info
	* @param  podLvlCd
	*/
	public void	setPodLvlCd( String	podLvlCd ) {
		this.podLvlCd =	podLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	podLvlCd
	 */
	 public	 String	getPodLvlCd() {
		 return	this.podLvlCd;
	 } 
 	/**
	* Column Info
	* @param  commRt
	*/
	public void	setCommRt( String	commRt ) {
		this.commRt =	commRt;
	}
 
	/**
	 * Column Info
	 * @return	commRt
	 */
	 public	 String	getCommRt() {
		 return	this.commRt;
	 } 
 	/**
	* Column Info
	* @param  commFxAmt
	*/
	public void	setCommFxAmt( String	commFxAmt ) {
		this.commFxAmt =	commFxAmt;
	}
 
	/**
	 * Column Info
	 * @return	commFxAmt
	 */
	 public	 String	getCommFxAmt() {
		 return	this.commFxAmt;
	 } 
 	/**
	* Column Info
	* @param  pol4
	*/
	public void	setPol4( String	pol4 ) {
		this.pol4 =	pol4;
	}
 
	/**
	 * Column Info
	 * @return	pol4
	 */
	 public	 String	getPol4() {
		 return	this.pol4;
	 } 
 	/**
	* Column Info
	* @param  ofcSetTpCd
	*/
	public void	setOfcSetTpCd( String	ofcSetTpCd ) {
		this.ofcSetTpCd =	ofcSetTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcSetTpCd
	 */
	 public	 String	getOfcSetTpCd() {
		 return	this.ofcSetTpCd;
	 } 
 	/**
	* Column Info
	* @param  pol3
	*/
	public void	setPol3( String	pol3 ) {
		this.pol3 =	pol3;
	}
 
	/**
	 * Column Info
	 * @return	pol3
	 */
	 public	 String	getPol3() {
		 return	this.pol3;
	 } 
 	/**
	* Column Info
	* @param  pol2
	*/
	public void	setPol2( String	pol2 ) {
		this.pol2 =	pol2;
	}
 
	/**
	 * Column Info
	 * @return	pol2
	 */
	 public	 String	getPol2() {
		 return	this.pol2;
	 } 
 	/**
	* Column Info
	* @param  pol1
	*/
	public void	setPol1( String	pol1 ) {
		this.pol1 =	pol1;
	}
 
	/**
	 * Column Info
	 * @return	pol1
	 */
	 public	 String	getPol1() {
		 return	this.pol1;
	 } 
 	/**
	* Column Info
	* @param  hlgDdctOrgFlg
	*/
	public void	setHlgDdctOrgFlg( String	hlgDdctOrgFlg ) {
		this.hlgDdctOrgFlg =	hlgDdctOrgFlg;
	}
 
	/**
	 * Column Info
	 * @return	hlgDdctOrgFlg
	 */
	 public	 String	getHlgDdctOrgFlg() {
		 return	this.hlgDdctOrgFlg;
	 } 
 	/**
	* Column Info
	* @param  pod2
	*/
	public void	setPod2( String	pod2 ) {
		this.pod2 =	pod2;
	}
 
	/**
	 * Column Info
	 * @return	pod2
	 */
	 public	 String	getPod2() {
		 return	this.pod2;
	 } 
 	/**
	* Column Info
	* @param  pod1
	*/
	public void	setPod1( String	pod1 ) {
		this.pod1 =	pod1;
	}
 
	/**
	 * Column Info
	 * @return	pod1
	 */
	 public	 String	getPod1() {
		 return	this.pod1;
	 } 
 	/**
	* Column Info
	* @param  pod4
	*/
	public void	setPod4( String	pod4 ) {
		this.pod4 =	pod4;
	}
 
	/**
	 * Column Info
	 * @return	pod4
	 */
	 public	 String	getPod4() {
		 return	this.pod4;
	 } 
 	/**
	* Column Info
	* @param  pod3
	*/
	public void	setPod3( String	pod3 ) {
		this.pod3 =	pod3;
	}
 
	/**
	 * Column Info
	 * @return	pod3
	 */
	 public	 String	getPod3() {
		 return	this.pod3;
	 } 
 	/**
	* Column Info
	* @param  rateDiv
	*/
	public void	setRateDiv( String	rateDiv ) {
		this.rateDiv =	rateDiv;
	}
 
	/**
	 * Column Info
	 * @return	rateDiv
	 */
	 public	 String	getRateDiv() {
		 return	this.rateDiv;
	 } 
 	/**
	* Column Info
	* @param  fullMtyCd
	*/
	public void	setFullMtyCd( String	fullMtyCd ) {
		this.fullMtyCd =	fullMtyCd;
	}
 
	/**
	 * Column Info
	 * @return	fullMtyCd
	 */
	 public	 String	getFullMtyCd() {
		 return	this.fullMtyCd;
	 } 
 	/**
	* Column Info
	* @param  oftPayTermCd
	*/
	public void	setOftPayTermCd( String	oftPayTermCd ) {
		this.oftPayTermCd =	oftPayTermCd;
	}
 
	/**
	 * Column Info
	 * @return	oftPayTermCd
	 */
	 public	 String	getOftPayTermCd() {
		 return	this.oftPayTermCd;
	 } 
 	/**
	* Column Info
	* @param  delLvlCd
	*/
	public void	setDelLvlCd( String	delLvlCd ) {
		this.delLvlCd =	delLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	delLvlCd
	 */
	 public	 String	getDelLvlCd() {
		 return	this.delLvlCd;
	 } 
 	/**
	* Column Info
	* @param  revDivCd
	*/
	public void	setRevDivCd( String	revDivCd ) {
		this.revDivCd =	revDivCd;
	}
 
	/**
	 * Column Info
	 * @return	revDivCd
	 */
	 public	 String	getRevDivCd() {
		 return	this.revDivCd;
	 } 
 	/**
	* Column Info
	* @param  agmtHisNo
	*/
	public void	setAgmtHisNo( String	agmtHisNo ) {
		this.agmtHisNo =	agmtHisNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtHisNo
	 */
	 public	 String	getAgmtHisNo() {
		 return	this.agmtHisNo;
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
	* @param  agmtDtlPk
	*/
	public void	setAgmtDtlPk( String	agmtDtlPk ) {
		this.agmtDtlPk =	agmtDtlPk;
	}
 
	/**
	 * Column Info
	 * @return	agmtDtlPk
	 */
	 public	 String	getAgmtDtlPk() {
		 return	this.agmtDtlPk;
	 } 
 	/**
	* Column Info
	* @param  agnAgmtNo
	*/
	public void	setAgnAgmtNo( String	agnAgmtNo ) {
		this.agnAgmtNo =	agnAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtNo
	 */
	 public	 String	getAgnAgmtNo() {
		 return	this.agnAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  agnCd
	*/
	public void	setAgnCd( String	agnCd ) {
		this.agnCd =	agnCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCd
	 */
	 public	 String	getAgnCd() {
		 return	this.agnCd;
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
	* @param  del
	*/
	public void	setDel( String	del ) {
		this.del =	del;
	}
 
	/**
	 * Column Info
	 * @return	del
	 */
	 public	 String	getDel() {
		 return	this.del;
	 } 
 	/**
	* Column Info
	* @param  commPayTermCd
	*/
	public void	setCommPayTermCd( String	commPayTermCd ) {
		this.commPayTermCd =	commPayTermCd;
	}
 
	/**
	 * Column Info
	 * @return	commPayTermCd
	 */
	 public	 String	getCommPayTermCd() {
		 return	this.commPayTermCd;
	 } 
 	/**
	* Column Info
	* @param  del2
	*/
	public void	setDel2( String	del2 ) {
		this.del2 =	del2;
	}
 
	/**
	 * Column Info
	 * @return	del2
	 */
	 public	 String	getDel2() {
		 return	this.del2;
	 } 
 	/**
	* Column Info
	* @param  del1
	*/
	public void	setDel1( String	del1 ) {
		this.del1 =	del1;
	}
 
	/**
	 * Column Info
	 * @return	del1
	 */
	 public	 String	getDel1() {
		 return	this.del1;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  del4
	*/
	public void	setDel4( String	del4 ) {
		this.del4 =	del4;
	}
 
	/**
	 * Column Info
	 * @return	del4
	 */
	 public	 String	getDel4() {
		 return	this.del4;
	 } 
 	/**
	* Column Info
	* @param  del3
	*/
	public void	setDel3( String	del3 ) {
		this.del3 =	del3;
	}
 
	/**
	 * Column Info
	 * @return	del3
	 */
	 public	 String	getDel3() {
		 return	this.del3;
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
	* @param  por2
	*/
	public void	setPor2( String	por2 ) {
		this.por2 =	por2;
	}
 
	/**
	 * Column Info
	 * @return	por2
	 */
	 public	 String	getPor2() {
		 return	this.por2;
	 } 
 	/**
	* Column Info
	* @param  porLvlCd
	*/
	public void	setPorLvlCd( String	porLvlCd ) {
		this.porLvlCd =	porLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	porLvlCd
	 */
	 public	 String	getPorLvlCd() {
		 return	this.porLvlCd;
	 } 
 	/**
	* Column Info
	* @param  por1
	*/
	public void	setPor1( String	por1 ) {
		this.por1 =	por1;
	}
 
	/**
	 * Column Info
	 * @return	por1
	 */
	 public	 String	getPor1() {
		 return	this.por1;
	 } 
 	/**
	* Column Info
	* @param  hlgDdctDestFlg
	*/
	public void	setHlgDdctDestFlg( String	hlgDdctDestFlg ) {
		this.hlgDdctDestFlg =	hlgDdctDestFlg;
	}
 
	/**
	 * Column Info
	 * @return	hlgDdctDestFlg
	 */
	 public	 String	getHlgDdctDestFlg() {
		 return	this.hlgDdctDestFlg;
	 } 
 	/**
	* Column Info
	* @param  commChgCd
	*/
	public void	setCommChgCd( String	commChgCd ) {
		this.commChgCd =	commChgCd;
	}
 
	/**
	 * Column Info
	 * @return	commChgCd
	 */
	 public	 String	getCommChgCd() {
		 return	this.commChgCd;
	 } 
 	/**
	* Column Info
	* @param  chgCommDivCd
	*/
	public void	setChgCommDivCd( String	chgCommDivCd ) {
		this.chgCommDivCd =	chgCommDivCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCommDivCd
	 */
	 public	 String	getChgCommDivCd() {
		 return	this.chgCommDivCd;
	 } 
 	/**
	* Column Info
	* @param  chgCommRt
	*/
	public void	setChgCommRt( String	chgCommRt ) {
		this.chgCommRt =	chgCommRt;
	}
 
	/**
	 * Column Info
	 * @return	chgCommRt
	 */
	 public	 String	getChgCommRt() {
		 return	this.chgCommRt;
	 } 
 	/**
	* Column Info
	* @param  chgCommOtrAmt
	*/
	public void	setChgCommOtrAmt( String	chgCommOtrAmt ) {
		this.chgCommOtrAmt =	chgCommOtrAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgCommOtrAmt
	 */
	 public	 String	getChgCommOtrAmt() {
		 return	this.chgCommOtrAmt;
	 } 
 	/**
	* Column Info
	* @param  chgCommCurrCd
	*/
	public void	setChgCommCurrCd( String	chgCommCurrCd ) {
		this.chgCommCurrCd =	chgCommCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCommCurrCd
	 */
	 public	 String	getChgCommCurrCd() {
		 return	this.chgCommCurrCd;
	 } 
 	/**
	* Column Info
	* @param  chgCommPayTermCd
	*/
	public void	setChgCommPayTermCd( String	chgCommPayTermCd ) {
		this.chgCommPayTermCd =	chgCommPayTermCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCommPayTermCd
	 */
	 public	 String	getChgCommPayTermCd() {
		 return	this.chgCommPayTermCd;
	 } 
 	/**
	* Column Info
	* @param  chgCommRateDiv
	*/
	public void	setChgCommRateDiv( String	chgCommRateDiv ) {
		this.chgCommRateDiv =	chgCommRateDiv;
	}
 
	/**
	 * Column Info
	 * @return	chgCommRateDiv
	 */
	 public	 String	getChgCommRateDiv() {
		 return	this.chgCommRateDiv;
	 } 
 	/**
	* Column Info
	* @param  minCommDivCd
	*/
	public void	setMinCommDivCd( String	minCommDivCd ) {
		this.minCommDivCd =	minCommDivCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommDivCd
	 */
	 public	 String	getMinCommDivCd() {
		 return	this.minCommDivCd;
	 } 
 	/**
	* Column Info
	* @param  minCommRt
	*/
	public void	setMinCommRt( String	minCommRt ) {
		this.minCommRt =	minCommRt;
	}
 
	/**
	 * Column Info
	 * @return	minCommRt
	 */
	 public	 String	getMinCommRt() {
		 return	this.minCommRt;
	 } 
 	/**
	* Column Info
	* @param  minCommCurrCd
	*/
	public void	setMinCommCurrCd( String	minCommCurrCd ) {
		this.minCommCurrCd =	minCommCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommCurrCd
	 */
	 public	 String	getMinCommCurrCd() {
		 return	this.minCommCurrCd;
	 } 
 	/**
	* Column Info
	* @param  minCommPerCd
	*/
	public void	setMinCommPerCd( String	minCommPerCd ) {
		this.minCommPerCd =	minCommPerCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommPerCd
	 */
	 public	 String	getMinCommPerCd() {
		 return	this.minCommPerCd;
	 } 
 	/**
	* Column Info
	* @param  minCommNetRevAmt
	*/
	public void	setMinCommNetRevAmt( String	minCommNetRevAmt ) {
		this.minCommNetRevAmt =	minCommNetRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	minCommNetRevAmt
	 */
	 public	 String	getMinCommNetRevAmt() {
		 return	this.minCommNetRevAmt;
	 } 
 	/**
	* Column Info
	* @param  minCommNetRevCurrCd
	*/
	public void	setMinCommNetRevCurrCd( String	minCommNetRevCurrCd ) {
		this.minCommNetRevCurrCd =	minCommNetRevCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	minCommNetRevCurrCd
	 */
	 public	 String	getMinCommNetRevCurrCd() {
		 return	this.minCommNetRevCurrCd;
	 } 
 	/**
	* Column Info
	* @param  agnAgmtMinCommSeq
	*/
	public void	setAgnAgmtMinCommSeq( String	agnAgmtMinCommSeq ) {
		this.agnAgmtMinCommSeq =	agnAgmtMinCommSeq;
	}
 
	/**
	 * Column Info
	 * @return	agnAgmtMinCommSeq
	 */
	 public	 String	getAgnAgmtMinCommSeq() {
		 return	this.agnAgmtMinCommSeq;
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
		setRepChgCd(JSPUtil.getParameter(request,	prefix + "rep_chg_cd", ""));
		setPor(JSPUtil.getParameter(request,	prefix + "por", ""));
		setPor3(JSPUtil.getParameter(request,	prefix + "por_3", ""));
		setPor4(JSPUtil.getParameter(request,	prefix + "por_4", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request,	prefix + "agn_agmt_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setPol(JSPUtil.getParameter(request,	prefix + "pol", ""));
		setAcTpCd(JSPUtil.getParameter(request,	prefix + "ac_tp_cd", ""));
		setFdrgDdctOrgFlg(JSPUtil.getParameter(request,	prefix + "fdrg_ddct_org_flg", ""));
		setPod(JSPUtil.getParameter(request,	prefix + "pod", ""));
		setFdrgDdctDestFlg(JSPUtil.getParameter(request,	prefix + "fdrg_ddct_dest_flg", ""));
		setPolLvlCd(JSPUtil.getParameter(request,	prefix + "pol_lvl_cd", ""));
		setOfcCvrgCd(JSPUtil.getParameter(request,	prefix + "ofc_cvrg_cd", ""));
		setPodLvlCd(JSPUtil.getParameter(request,	prefix + "pod_lvl_cd", ""));
		setCommRt(JSPUtil.getParameter(request,	prefix + "comm_rt", ""));
		setCommFxAmt(JSPUtil.getParameter(request,	prefix + "comm_fx_amt", ""));
		setPol4(JSPUtil.getParameter(request,	prefix + "pol_4", ""));
		setOfcSetTpCd(JSPUtil.getParameter(request,	prefix + "ofc_set_tp_cd", ""));
		setPol3(JSPUtil.getParameter(request,	prefix + "pol_3", ""));
		setPol2(JSPUtil.getParameter(request,	prefix + "pol_2", ""));
		setPol1(JSPUtil.getParameter(request,	prefix + "pol_1", ""));
		setHlgDdctOrgFlg(JSPUtil.getParameter(request,	prefix + "hlg_ddct_org_flg", ""));
		setPod2(JSPUtil.getParameter(request,	prefix + "pod_2", ""));
		setPod1(JSPUtil.getParameter(request,	prefix + "pod_1", ""));
		setPod4(JSPUtil.getParameter(request,	prefix + "pod_4", ""));
		setPod3(JSPUtil.getParameter(request,	prefix + "pod_3", ""));
		setRateDiv(JSPUtil.getParameter(request,	prefix + "rate_div", ""));
		setFullMtyCd(JSPUtil.getParameter(request,	prefix + "full_mty_cd", ""));
		setOftPayTermCd(JSPUtil.getParameter(request,	prefix + "oft_pay_term_cd", ""));
		setDelLvlCd(JSPUtil.getParameter(request,	prefix + "del_lvl_cd", ""));
		setRevDivCd(JSPUtil.getParameter(request,	prefix + "rev_div_cd", ""));
		setAgmtHisNo(JSPUtil.getParameter(request,	prefix + "agmt_his_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setAgmtDtlPk(JSPUtil.getParameter(request,	prefix + "agmt_dtl_pk", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request,	prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setDel(JSPUtil.getParameter(request,	prefix + "del", ""));
		setCommPayTermCd(JSPUtil.getParameter(request,	prefix + "comm_pay_term_cd", ""));
		setDel2(JSPUtil.getParameter(request,	prefix + "del_2", ""));
		setDel1(JSPUtil.getParameter(request,	prefix + "del_1", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setDel4(JSPUtil.getParameter(request,	prefix + "del_4", ""));
		setDel3(JSPUtil.getParameter(request,	prefix + "del_3", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setPor2(JSPUtil.getParameter(request,	prefix + "por_2", ""));
		setPorLvlCd(JSPUtil.getParameter(request,	prefix + "por_lvl_cd", ""));
		setPor1(JSPUtil.getParameter(request,	prefix + "por_1", ""));
		setHlgDdctDestFlg(JSPUtil.getParameter(request,	prefix + "hlg_ddct_dest_flg", ""));
		setCommChgCd(JSPUtil.getParameter(request,	prefix + "comm_chg_cd", ""));
		setChgCommDivCd(JSPUtil.getParameter(request,	prefix + "chg_comm_div_cd", ""));
		setChgCommRt(JSPUtil.getParameter(request,	prefix + "chg_comm_rt", ""));
		setChgCommOtrAmt(JSPUtil.getParameter(request,	prefix + "chg_comm_otr_amt", ""));
		setChgCommCurrCd(JSPUtil.getParameter(request,	prefix + "chg_comm_curr_cd", ""));
		setChgCommPayTermCd(JSPUtil.getParameter(request,	prefix + "chg_comm_pay_term_cd", ""));
		setChgCommRateDiv(JSPUtil.getParameter(request,	prefix + "chg_comm_rate_div", ""));
		setMinCommDivCd(JSPUtil.getParameter(request,	prefix + "min_comm_div_cd", ""));
		setMinCommRt(JSPUtil.getParameter(request,	prefix + "min_comm_rt", ""));
		setMinCommCurrCd(JSPUtil.getParameter(request,	prefix + "min_comm_curr_cd", ""));
		setMinCommPerCd(JSPUtil.getParameter(request,	prefix + "min_comm_per_cd", ""));
		setMinCommNetRevAmt(JSPUtil.getParameter(request,	prefix + "min_comm_net_rev_amt", ""));
		setMinCommNetRevCurrCd(JSPUtil.getParameter(request,	prefix + "min_comm_net_rev_curr_cd", ""));
		setAgnAgmtMinCommSeq(JSPUtil.getParameter(request,	prefix + "agn_agmt_min_comm_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgentRateDetailVO[]
	 */
	public AgentRateDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgentRateDetailVO[]
	 */
	public AgentRateDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AgentRateDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] repChgCd =	(JSPUtil.getParameter(request, prefix +	"rep_chg_cd".trim(),	length));
				String[] por =	(JSPUtil.getParameter(request, prefix +	"por".trim(),	length));
				String[] por3 =	(JSPUtil.getParameter(request, prefix +	"por_3".trim(),	length));
				String[] por4 =	(JSPUtil.getParameter(request, prefix +	"por_4".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] agnAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_seq".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] pol =	(JSPUtil.getParameter(request, prefix +	"pol".trim(),	length));
				String[] acTpCd =	(JSPUtil.getParameter(request, prefix +	"ac_tp_cd".trim(),	length));
				String[] fdrgDdctOrgFlg =	(JSPUtil.getParameter(request, prefix +	"fdrg_ddct_org_flg".trim(),	length));
				String[] pod =	(JSPUtil.getParameter(request, prefix +	"pod".trim(),	length));
				String[] fdrgDdctDestFlg =	(JSPUtil.getParameter(request, prefix +	"fdrg_ddct_dest_flg".trim(),	length));
				String[] polLvlCd =	(JSPUtil.getParameter(request, prefix +	"pol_lvl_cd".trim(),	length));
				String[] ofcCvrgCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cvrg_cd".trim(),	length));
				String[] podLvlCd =	(JSPUtil.getParameter(request, prefix +	"pod_lvl_cd".trim(),	length));
				String[] commRt =	(JSPUtil.getParameter(request, prefix +	"comm_rt".trim(),	length));
				String[] commFxAmt =	(JSPUtil.getParameter(request, prefix +	"comm_fx_amt".trim(),	length));
				String[] pol4 =	(JSPUtil.getParameter(request, prefix +	"pol_4".trim(),	length));
				String[] ofcSetTpCd =	(JSPUtil.getParameter(request, prefix +	"ofc_set_tp_cd".trim(),	length));
				String[] pol3 =	(JSPUtil.getParameter(request, prefix +	"pol_3".trim(),	length));
				String[] pol2 =	(JSPUtil.getParameter(request, prefix +	"pol_2".trim(),	length));
				String[] pol1 =	(JSPUtil.getParameter(request, prefix +	"pol_1".trim(),	length));
				String[] hlgDdctOrgFlg =	(JSPUtil.getParameter(request, prefix +	"hlg_ddct_org_flg".trim(),	length));
				String[] pod2 =	(JSPUtil.getParameter(request, prefix +	"pod_2".trim(),	length));
				String[] pod1 =	(JSPUtil.getParameter(request, prefix +	"pod_1".trim(),	length));
				String[] pod4 =	(JSPUtil.getParameter(request, prefix +	"pod_4".trim(),	length));
				String[] pod3 =	(JSPUtil.getParameter(request, prefix +	"pod_3".trim(),	length));
				String[] rateDiv =	(JSPUtil.getParameter(request, prefix +	"rate_div".trim(),	length));
				String[] fullMtyCd =	(JSPUtil.getParameter(request, prefix +	"full_mty_cd".trim(),	length));
				String[] oftPayTermCd =	(JSPUtil.getParameter(request, prefix +	"oft_pay_term_cd".trim(),	length));
				String[] delLvlCd =	(JSPUtil.getParameter(request, prefix +	"del_lvl_cd".trim(),	length));
				String[] revDivCd =	(JSPUtil.getParameter(request, prefix +	"rev_div_cd".trim(),	length));
				String[] agmtHisNo =	(JSPUtil.getParameter(request, prefix +	"agmt_his_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] agmtDtlPk =	(JSPUtil.getParameter(request, prefix +	"agmt_dtl_pk".trim(),	length));
				String[] agnAgmtNo =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_no".trim(),	length));
				String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] del =	(JSPUtil.getParameter(request, prefix +	"del".trim(),	length));
				String[] commPayTermCd =	(JSPUtil.getParameter(request, prefix +	"comm_pay_term_cd".trim(),	length));
				String[] del2 =	(JSPUtil.getParameter(request, prefix +	"del_2".trim(),	length));
				String[] del1 =	(JSPUtil.getParameter(request, prefix +	"del_1".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] del4 =	(JSPUtil.getParameter(request, prefix +	"del_4".trim(),	length));
				String[] del3 =	(JSPUtil.getParameter(request, prefix +	"del_3".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] por2 =	(JSPUtil.getParameter(request, prefix +	"por_2".trim(),	length));
				String[] porLvlCd =	(JSPUtil.getParameter(request, prefix +	"por_lvl_cd".trim(),	length));
				String[] por1 =	(JSPUtil.getParameter(request, prefix +	"por_1".trim(),	length));
				String[] hlgDdctDestFlg =	(JSPUtil.getParameter(request, prefix +	"hlg_ddct_dest_flg".trim(),	length));
				String[] commChgCd =	(JSPUtil.getParameter(request, prefix +	"comm_chg_cd".trim(),	length));
				String[] chgCommDivCd =	(JSPUtil.getParameter(request, prefix +	"chg_comm_div_cd".trim(),	length));
				String[] chgCommRt =	(JSPUtil.getParameter(request, prefix +	"chg_comm_rt".trim(),	length));
				String[] chgCommOtrAmt =	(JSPUtil.getParameter(request, prefix +	"chg_comm_otr_amt".trim(),	length));
				String[] chgCommCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_comm_curr_cd".trim(),	length));
				String[] chgCommPayTermCd =	(JSPUtil.getParameter(request, prefix +	"chg_comm_pay_term_cd".trim(),	length));
				String[] chgCommRateDiv =	(JSPUtil.getParameter(request, prefix +	"chg_comm_rate_div".trim(),	length));
				String[] minCommDivCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_div_cd".trim(),	length));
				String[] minCommRt =	(JSPUtil.getParameter(request, prefix +	"min_comm_rt".trim(),	length));
				String[] minCommCurrCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_curr_cd".trim(),	length));
				String[] minCommPerCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_per_cd".trim(),	length));
				String[] minCommNetRevAmt =	(JSPUtil.getParameter(request, prefix +	"min_comm_net_rev_amt".trim(),	length));
				String[] minCommNetRevCurrCd =	(JSPUtil.getParameter(request, prefix +	"min_comm_net_rev_curr_cd".trim(),	length));
				String[] agnAgmtMinCommSeq =	(JSPUtil.getParameter(request, prefix +	"agn_agmt_min_comm_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AgentRateDetailVO();
						if ( repChgCd[i] !=	null)
						model.setRepChgCd( repChgCd[i]);
						if ( por[i] !=	null)
						model.setPor( por[i]);
						if ( por3[i] !=	null)
						model.setPor3( por3[i]);
						if ( por4[i] !=	null)
						model.setPor4( por4[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( agnAgmtSeq[i] !=	null)
						model.setAgnAgmtSeq( agnAgmtSeq[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( pol[i] !=	null)
						model.setPol( pol[i]);
						if ( acTpCd[i] !=	null)
						model.setAcTpCd( acTpCd[i]);
						if ( fdrgDdctOrgFlg[i] !=	null)
						model.setFdrgDdctOrgFlg( fdrgDdctOrgFlg[i]);
						if ( pod[i] !=	null)
						model.setPod( pod[i]);
						if ( fdrgDdctDestFlg[i] !=	null)
						model.setFdrgDdctDestFlg( fdrgDdctDestFlg[i]);
						if ( polLvlCd[i] !=	null)
						model.setPolLvlCd( polLvlCd[i]);
						if ( ofcCvrgCd[i] !=	null)
						model.setOfcCvrgCd( ofcCvrgCd[i]);
						if ( podLvlCd[i] !=	null)
						model.setPodLvlCd( podLvlCd[i]);
						if ( commRt[i] !=	null)
						model.setCommRt( commRt[i]);
						if ( commFxAmt[i] !=	null)
						model.setCommFxAmt( commFxAmt[i]);
						if ( pol4[i] !=	null)
						model.setPol4( pol4[i]);
						if ( ofcSetTpCd[i] !=	null)
						model.setOfcSetTpCd( ofcSetTpCd[i]);
						if ( pol3[i] !=	null)
						model.setPol3( pol3[i]);
						if ( pol2[i] !=	null)
						model.setPol2( pol2[i]);
						if ( pol1[i] !=	null)
						model.setPol1( pol1[i]);
						if ( hlgDdctOrgFlg[i] !=	null)
						model.setHlgDdctOrgFlg( hlgDdctOrgFlg[i]);
						if ( pod2[i] !=	null)
						model.setPod2( pod2[i]);
						if ( pod1[i] !=	null)
						model.setPod1( pod1[i]);
						if ( pod4[i] !=	null)
						model.setPod4( pod4[i]);
						if ( pod3[i] !=	null)
						model.setPod3( pod3[i]);
						if ( rateDiv[i] !=	null)
						model.setRateDiv( rateDiv[i]);
						if ( fullMtyCd[i] !=	null)
						model.setFullMtyCd( fullMtyCd[i]);
						if ( oftPayTermCd[i] !=	null)
						model.setOftPayTermCd( oftPayTermCd[i]);
						if ( delLvlCd[i] !=	null)
						model.setDelLvlCd( delLvlCd[i]);
						if ( revDivCd[i] !=	null)
						model.setRevDivCd( revDivCd[i]);
						if ( agmtHisNo[i] !=	null)
						model.setAgmtHisNo( agmtHisNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( agmtDtlPk[i] !=	null)
						model.setAgmtDtlPk( agmtDtlPk[i]);
						if ( agnAgmtNo[i] !=	null)
						model.setAgnAgmtNo( agnAgmtNo[i]);
						if ( agnCd[i] !=	null)
						model.setAgnCd( agnCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( del[i] !=	null)
						model.setDel( del[i]);
						if ( commPayTermCd[i] !=	null)
						model.setCommPayTermCd( commPayTermCd[i]);
						if ( del2[i] !=	null)
						model.setDel2( del2[i]);
						if ( del1[i] !=	null)
						model.setDel1( del1[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( del4[i] !=	null)
						model.setDel4( del4[i]);
						if ( del3[i] !=	null)
						model.setDel3( del3[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( por2[i] !=	null)
						model.setPor2( por2[i]);
						if ( porLvlCd[i] !=	null)
						model.setPorLvlCd( porLvlCd[i]);
						if ( por1[i] !=	null)
						model.setPor1( por1[i]);
						if ( hlgDdctDestFlg[i] !=	null)
						model.setHlgDdctDestFlg( hlgDdctDestFlg[i]);
						if ( commChgCd[i] !=	null)
						model.setCommChgCd( commChgCd[i]);
						if ( chgCommDivCd[i] !=	null)
						model.setChgCommDivCd( chgCommDivCd[i]);
						if ( chgCommRt[i] !=	null)
						model.setChgCommRt( chgCommRt[i]);
						if ( chgCommOtrAmt[i] !=	null)
						model.setChgCommOtrAmt( chgCommOtrAmt[i]);
						if ( chgCommCurrCd[i] !=	null)
						model.setChgCommCurrCd( chgCommCurrCd[i]);
						if ( chgCommPayTermCd[i] !=	null)
						model.setChgCommPayTermCd( chgCommPayTermCd[i]);
						if ( chgCommRateDiv[i] !=	null)
						model.setChgCommRateDiv( chgCommRateDiv[i]);
						if ( minCommDivCd[i] !=	null)
						model.setMinCommDivCd( minCommDivCd[i]);
						if ( minCommRt[i] !=	null)
						model.setMinCommRt( minCommRt[i]);
						if ( minCommCurrCd[i] !=	null)
						model.setMinCommCurrCd( minCommCurrCd[i]);
						if ( minCommPerCd[i] !=	null)
						model.setMinCommPerCd( minCommPerCd[i]);
						if ( minCommNetRevAmt[i] !=	null)
						model.setMinCommNetRevAmt( minCommNetRevAmt[i]);
						if ( minCommNetRevCurrCd[i] !=	null)
						model.setMinCommNetRevCurrCd( minCommNetRevCurrCd[i]);
						if ( agnAgmtMinCommSeq[i] !=	null)
						model.setAgnAgmtMinCommSeq( agnAgmtMinCommSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAgentRateDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AgentRateDetailVO[]
	 */
	public AgentRateDetailVO[]	 getAgentRateDetailVOs(){
		AgentRateDetailVO[] vos = (AgentRateDetailVO[])models.toArray(new	AgentRateDetailVO[models.size()]);
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
		this.repChgCd =	this.repChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por =	this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por3 =	this.por3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por4 =	this.por4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq =	this.agnAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol =	this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd =	this.acTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrgDdctOrgFlg =	this.fdrgDdctOrgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod =	this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrgDdctDestFlg =	this.fdrgDdctDestFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLvlCd =	this.polLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCvrgCd =	this.ofcCvrgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLvlCd =	this.podLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRt =	this.commRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commFxAmt =	this.commFxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 =	this.pol4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSetTpCd =	this.ofcSetTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 =	this.pol3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 =	this.pol2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 =	this.pol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgDdctOrgFlg =	this.hlgDdctOrgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 =	this.pod2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 =	this.pod1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 =	this.pod4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 =	this.pod3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateDiv =	this.rateDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd =	this.fullMtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftPayTermCd =	this.oftPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLvlCd =	this.delLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivCd =	this.revDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtHisNo =	this.agmtHisNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDtlPk =	this.agmtDtlPk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo =	this.agnAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del =	this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commPayTermCd =	this.commPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del2 =	this.del2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del1 =	this.del1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del4 =	this.del4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del3 =	this.del3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por2 =	this.por2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porLvlCd =	this.porLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por1 =	this.por1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgDdctDestFlg =	this.hlgDdctDestFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commChgCd =	this.commChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommDivCd =	this.chgCommDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommRt =	this.chgCommRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommOtrAmt =	this.chgCommOtrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommCurrCd =	this.chgCommCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommPayTermCd =	this.chgCommPayTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommRateDiv =	this.chgCommRateDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommDivCd =	this.minCommDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommRt =	this.minCommRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommCurrCd =	this.minCommCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommPerCd =	this.minCommPerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommNetRevAmt =	this.minCommNetRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCommNetRevCurrCd =	this.minCommNetRevCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtMinCommSeq =	this.agnAgmtMinCommSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}