/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CusCtmMovementVO.java
 *@FileTitle : CusCtmMovementVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.17  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class CusCtmMovementVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CusCtmMovementVO>  models =	new	ArrayList<CusCtmMovementVO>();


	/*	Column Info	*/
	private  String	 crntSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 bkgCgoTpCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgTpId   =  null;
	/*	Column Info	*/
	private  String	 gmtDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvSeq   =  null;
	/*	Column Info	*/
	private  String	 mvmtInpTpCd   =  null;
	/*	Column Info	*/
	private  String	 chssNo   =  null;
	/*	Column Info	*/
	private  String	 mvmtTrspModCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgSeq   =  null;
	/*	Column Info	*/
	private  String	 destYdCd   =  null;
	/*	Column Info	*/
	private  String	 ctrtSeq   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 mtyRepoVlRmk   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 substRuleCd   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrActCd   =  null;
	/*	Column Info	*/
	private  String	 cntrXchCd   =  null;
	/*	Column Info	*/
	private  String	 cntrId   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrBarAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 cntrRfubFlg   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 evntDt   =  null;
	/*	Column Info	*/
	private  String	 inpYdCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgAreaCd   =  null;
	/*	Column Info	*/
	private  String	 callSgnNo   =  null;
	/*	Column Info	*/
	private  String	 ctmUiYn   =  null;
	/*	Column Info	*/
	private  String	 wblNo   =  null;
	/*	Column Info	*/
	private  String	 updLoclDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 spclCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 mvmtCreTpCd   =  null;
	/*	Column Info	*/
	private  String	 aciacDivCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 lloydNo   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgYrmondy   =  null;
	/*	Column Info	*/
	private  String	 cnmvRmk   =  null;
	/*	Column Info	*/
	private  String	 creLoclDt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 pType2   =  null;
	/*	Column Info	*/
	private  String	 errMsg   =  null;
	/*	Column Info	*/
	private  String	 trnkVslCd   =  null;
	/*	Column Info	*/
	private  String	 pType1   =  null;
	/*	Column Info	*/
	private  String	 cntrDispFlg   =  null;
	/*	Column Info	*/
	private  String	 ctrtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 pkupNo   =  null;
	/*	Column Info	*/
	private  String	 cnmvCycNo   =  null;
	/*	Column Info	*/
	private  String	 lstrmCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvLvlNo   =  null;
	/*	Column Info	*/
	private  String	 checkDigit   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 bkgRcvTermCd   =  null;
	/*	Column Info	*/
	private  String	 xxlink   =  null;
	/*	Column Info	*/
	private  String	 cntrSvrId   =  null;
	/*	Column Info	*/
	private  String	 fcntrFlg   =  null;
	/*	Column Info	*/
	private  String	 bbulkFlg   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 cntrDmgFlg   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvSplitNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bkgKnt   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 newFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrStsSeq   =  null;
	/*	Column Info	*/
	private  String	 bkgNoSplit   =  null;
	/*	Column Info	*/
	private  String	 inlndTrspLicNo   =  null;
	/*	Column Info	*/
	private  String	 crntSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 preStsFlg   =  null;
	/*	Column Info	*/
	private  String	 orgYdCd   =  null;
	/*	Column Info	*/
	private  String	 mgstNo   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckFlg   =  null;
	/*	Column Info	*/
	private  String	 obCntrFlg   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrSealNo   =  null;
	/*	Column Info	*/
	private  String	 imdtExtFlg   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 cnmvCoCd   =  null;
	/*	Column Info	*/
	private  String	 crntVslCd   =  null;
	/*	Column Info	*/
	private  String	 ediCrrNo   =  null;
	/*	Column Info	*/
	private  String	 trspDocNo   =  null;
	/*	Column Info	*/
	private  String	 mtyRepoNo   =  null;
	/*	Column Info	*/
	private  String	 woNo   =  null;
	/*	Column Info	*/
	private  String	 mtyPlnNo   =  null;
	/*	Column Info	*/
	private  String	 tirNo   =  null;
	/*	Column Info	*/
	private  String	 ediVvdCd   =  null;
	/*	Column Info	*/
	private  String	 oscaBkgFlg   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/* Column Info */
	private String vgmDocIdNo = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String vgmDocTpCd = null;
	/* Column Info */
	private String vgmDtTpCd = null;
	/* Column Info */
	private String vgmHndlDt = null;
	/* Column Info */
	private String vgmCustCntcTpCd = null;
	/* Column Info */
	private String vgmCustCntcNm = null;
	/* Column Info */
	private String vgmCustFaxNo = null;
	/* Column Info */
	private String vgmCustEml = null;
	/* Column Info */
	private String vgmCustPhnNo = null;
	/* Column Info */
	private String vgmCustAddr = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String cntrStwgPsnCtnt = null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CusCtmMovementVO(){}

	public CusCtmMovementVO(String crntSkdVoyNo,String bkgCgoTpCd,String mvmtEdiMsgTpId,String gmtDt,String cnmvSeq,String mvmtInpTpCd,String chssNo,String mvmtTrspModCd,String mvmtEdiMsgSeq,String destYdCd,String ctrtSeq,String blNo,String mtyRepoVlRmk,String pagerows,String substRuleCd,String polCd,String locCd,String vvdCd,String cntrActCd,String cntrXchCd,String cntrId,String cntrTpszCd,String mvmtEdiTpCd,String cntrHngrBarAtchKnt,String cntrRfubFlg,String lstmCd,String updUsrId,String evntDt,String inpYdCd,String mvmtEdiMsgAreaCd,String callSgnNo,String ctmUiYn,String wblNo,String updLoclDt,String cnmvEvntDt,String spclCgoFlg,String mvmtCreTpCd,String aciacDivCd,String cnmvIdNo,String podCd,String bkgNo,String creUsrId,String lloydNo,String mvmtEdiMsgYrmondy,String cnmvRmk,String creLoclDt,String vndrSeq,String pType2,String errMsg,String trnkVslCd,String pType1,String cntrDispFlg,String ctrtOfcCtyCd,String trnkSkdVoyNo,String pkupNo,String cnmvCycNo,String lstrmCd,String cnmvLvlNo,String checkDigit,String creDt,String bkgRcvTermCd,String xxlink,String cntrSvrId,String fcntrFlg,String bbulkFlg,String trnkSkdDirCd,String cntrDmgFlg,String dmgFlgDt,String dmgUnflgDt,String cnmvSplitNo,String ibflag,String bkgKnt,String usrNm,String updDt,String newFlg,String cntrStsSeq,String bkgNoSplit,String inlndTrspLicNo,String crntSkdDirCd,String preStsFlg,String orgYdCd,String mgstNo,String cntrHngrRckFlg,String obCntrFlg,String ofcCd,String mvmtStsCd,String cntrNo,String cntrSealNo,String imdtExtFlg,String cnmvYr,String cnmvCoCd,String crntVslCd,String ediCrrNo,String trspDocNo,String mtyRepoNo,String woNo,String mtyPlnNo,String tirNo,String ediVvdCd,String oscaBkgFlg,String rfHumidCtrlValCd,String rfCmprCtnt,
			String vgmDocIdNo, String vgmWgt, String vgmWgtUtCd, String vgmDocTpCd, String vgmDtTpCd, String vgmHndlDt, String vgmCustCntcTpCd, String vgmCustCntcNm, String vgmCustFaxNo, String vgmCustEml, String vgmCustPhnNo, String vgmCustAddr, String usaEdiCd, String cntrStwgPsnCtnt)	{
		this.crntSkdVoyNo  = crntSkdVoyNo ;
		this.bkgCgoTpCd  = bkgCgoTpCd ;
		this.mvmtEdiMsgTpId  = mvmtEdiMsgTpId ;
		this.gmtDt  = gmtDt ;
		this.cnmvSeq  = cnmvSeq ;
		this.mvmtInpTpCd  = mvmtInpTpCd ;
		this.chssNo  = chssNo ;
		this.mvmtTrspModCd  = mvmtTrspModCd ;
		this.mvmtEdiMsgSeq  = mvmtEdiMsgSeq ;
		this.destYdCd  = destYdCd ;
		this.ctrtSeq  = ctrtSeq ;
		this.blNo  = blNo ;
		this.mtyRepoVlRmk  = mtyRepoVlRmk ;
		this.pagerows  = pagerows ;
		this.substRuleCd  = substRuleCd ;
		this.polCd  = polCd ;
		this.locCd  = locCd ;
		this.vvdCd  = vvdCd ;
		this.cntrActCd  = cntrActCd ;
		this.cntrXchCd  = cntrXchCd ;
		this.cntrId  = cntrId ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.mvmtEdiTpCd  = mvmtEdiTpCd ;
		this.cntrHngrBarAtchKnt  = cntrHngrBarAtchKnt ;
		this.cntrRfubFlg  = cntrRfubFlg ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.evntDt  = evntDt ;
		this.inpYdCd  = inpYdCd ;
		this.mvmtEdiMsgAreaCd  = mvmtEdiMsgAreaCd ;
		this.callSgnNo  = callSgnNo ;
		this.ctmUiYn  = ctmUiYn ;
		this.wblNo  = wblNo ;
		this.updLoclDt  = updLoclDt ;
		this.cnmvEvntDt  = cnmvEvntDt ;
		this.spclCgoFlg  = spclCgoFlg ;
		this.mvmtCreTpCd  = mvmtCreTpCd ;
		this.aciacDivCd  = aciacDivCd ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.creUsrId  = creUsrId ;
		this.lloydNo  = lloydNo ;
		this.mvmtEdiMsgYrmondy  = mvmtEdiMsgYrmondy ;
		this.cnmvRmk  = cnmvRmk ;
		this.creLoclDt  = creLoclDt ;
		this.vndrSeq  = vndrSeq ;
		this.pType2  = pType2 ;
		this.errMsg  = errMsg ;
		this.trnkVslCd  = trnkVslCd ;
		this.pType1  = pType1 ;
		this.cntrDispFlg  = cntrDispFlg ;
		this.ctrtOfcCtyCd  = ctrtOfcCtyCd ;
		this.trnkSkdVoyNo  = trnkSkdVoyNo ;
		this.pkupNo  = pkupNo ;
		this.cnmvCycNo  = cnmvCycNo ;
		this.lstrmCd  = lstrmCd ;
		this.cnmvLvlNo  = cnmvLvlNo ;
		this.checkDigit  = checkDigit ;
		this.creDt  = creDt ;
		this.bkgRcvTermCd  = bkgRcvTermCd ;
		this.xxlink  = xxlink ;
		this.cntrSvrId  = cntrSvrId ;
		this.fcntrFlg  = fcntrFlg ;
		this.bbulkFlg  = bbulkFlg ;
		this.trnkSkdDirCd  = trnkSkdDirCd ;
		this.cntrDmgFlg  = cntrDmgFlg ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
		this.cnmvSplitNo  = cnmvSplitNo ;
		this.ibflag  = ibflag ;
		this.bkgKnt  = bkgKnt ;
		this.usrNm  = usrNm ;
		this.updDt  = updDt ;
		this.newFlg  = newFlg ;
		this.cntrStsSeq  = cntrStsSeq ;
		this.bkgNoSplit  = bkgNoSplit ;
		this.inlndTrspLicNo  = inlndTrspLicNo ;
		this.crntSkdDirCd  = crntSkdDirCd ;
		this.preStsFlg  = preStsFlg ;
		this.orgYdCd  = orgYdCd ;
		this.mgstNo  = mgstNo ;
		this.cntrHngrRckFlg  = cntrHngrRckFlg ;
		this.obCntrFlg  = obCntrFlg ;
		this.ofcCd  = ofcCd ;
		this.mvmtStsCd  = mvmtStsCd ;
		this.cntrNo  = cntrNo ;
		this.cntrSealNo  = cntrSealNo ;
		this.imdtExtFlg  = imdtExtFlg ;
		this.cnmvYr  = cnmvYr ;
		this.cnmvCoCd  = cnmvCoCd ;
		this.crntVslCd  = crntVslCd ;
		this.ediCrrNo  = ediCrrNo ;
		this.trspDocNo  = trspDocNo ;
		this.mtyRepoNo  = mtyRepoNo ;
		this.woNo  = woNo ;
		this.mtyPlnNo  = mtyPlnNo ;
		this.tirNo  = tirNo ;
		this.ediVvdCd  = ediVvdCd ;
		this.oscaBkgFlg  = oscaBkgFlg ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.vgmDocIdNo = vgmDocIdNo;
		this.vgmWgt = vgmWgt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vgmDocTpCd = vgmDocTpCd;
		this.vgmDtTpCd = vgmDtTpCd;
		this.vgmHndlDt = vgmHndlDt;
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		this.vgmCustCntcNm = vgmCustCntcNm;
		this.vgmCustFaxNo = vgmCustFaxNo;
		this.vgmCustEml = vgmCustEml;
		this.vgmCustPhnNo = vgmCustPhnNo;
		this.vgmCustAddr = vgmCustAddr;
		this.usaEdiCd = usaEdiCd;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());		
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());		
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());		
		this.hashColumns.put("gmt_dt", getGmtDt());		
		this.hashColumns.put("cnmv_seq", getCnmvSeq());		
		this.hashColumns.put("mvmt_inp_tp_cd", getMvmtInpTpCd());		
		this.hashColumns.put("chss_no", getChssNo());		
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());		
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());		
		this.hashColumns.put("dest_yd_cd", getDestYdCd());		
		this.hashColumns.put("ctrt_seq", getCtrtSeq());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("mty_repo_vl_rmk", getMtyRepoVlRmk());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("subst_rule_cd", getSubstRuleCd());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("cntr_act_cd", getCntrActCd());		
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());		
		this.hashColumns.put("cntr_id", getCntrId());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());		
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());		
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("evnt_dt", getEvntDt());		
		this.hashColumns.put("inp_yd_cd", getInpYdCd());		
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());		
		this.hashColumns.put("call_sgn_no", getCallSgnNo());		
		this.hashColumns.put("ctm_ui_yn", getCtmUiYn());		
		this.hashColumns.put("wbl_no", getWblNo());		
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());		
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());		
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());		
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());		
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("lloyd_no", getLloydNo());		
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());		
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());		
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("p_type2", getPType2());		
		this.hashColumns.put("err_msg", getErrMsg());		
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());		
		this.hashColumns.put("p_type1", getPType1());		
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());		
		this.hashColumns.put("ctrt_ofc_cty_cd", getCtrtOfcCtyCd());		
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());		
		this.hashColumns.put("pkup_no", getPkupNo());		
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());		
		this.hashColumns.put("lstrm_cd", getLstrmCd());		
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());		
		this.hashColumns.put("check_digit", getCheckDigit());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());		
		this.hashColumns.put("xxlink", getXxlink());		
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());		
		this.hashColumns.put("fcntr_flg", getFcntrFlg());		
		this.hashColumns.put("bbulk_flg", getBbulkFlg());		
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());		
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());			
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());			
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bkg_knt", getBkgKnt());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("new_flg", getNewFlg());		
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());		
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());		
		this.hashColumns.put("inlnd_trsp_lic_no", getInlndTrspLicNo());		
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());		
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());		
		this.hashColumns.put("org_yd_cd", getOrgYdCd());		
		this.hashColumns.put("mgst_no", getMgstNo());		
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());		
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());		
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());		
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());		
		this.hashColumns.put("edi_crr_no", getEdiCrrNo());		
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());		
		this.hashColumns.put("mty_repo_no", getMtyRepoNo());		
		this.hashColumns.put("wo_no", getWoNo());		
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());		
		this.hashColumns.put("tir_no", getTirNo());		
		this.hashColumns.put("edi_vvd_cd", getEdiVvdCd());		
		this.hashColumns.put("osca_bkg_flg", getOscaBkgFlg());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());	
		this.hashColumns.put("vgm_doc_id_no", getVgmDocIdNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vgm_doc_tp_cd", getVgmDocTpCd());
		this.hashColumns.put("vgm_dt_tp_cd", getVgmDtTpCd());
		this.hashColumns.put("vgm_hndl_dt", getVgmHndlDt());
		this.hashColumns.put("vgm_cust_cntc_tp_cd", getVgmCustCntcTpCd());
		this.hashColumns.put("vgm_cust_cntc_nm", getVgmCustCntcNm());
		this.hashColumns.put("vgm_cust_fax_no", getVgmCustFaxNo());
		this.hashColumns.put("vgm_cust_eml", getVgmCustEml());
		this.hashColumns.put("vgm_cust_phn_no", getVgmCustPhnNo());
		this.hashColumns.put("vgm_cust_addr", getVgmCustAddr());	
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());	
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("mvmt_inp_tp_cd", "mvmtInpTpCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mty_repo_vl_rmk", "mtyRepoVlRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("subst_rule_cd", "substRuleCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_act_cd", "cntrActCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("inp_yd_cd", "inpYdCd");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ctm_ui_yn", "ctmUiYn");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("p_type2", "pType2");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("p_type1", "pType1");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("ctrt_ofc_cty_cd", "ctrtOfcCtyCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("lstrm_cd", "lstrmCd");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("xxlink", "xxlink");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("bbulk_flg", "bbulkFlg");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("new_flg", "newFlg");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("inlnd_trsp_lic_no", "inlndTrspLicNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("edi_crr_no", "ediCrrNo");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("mty_repo_no", "mtyRepoNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("tir_no", "tirNo");
		this.hashFields.put("edi_vvd_cd", "ediVvdCd");
		this.hashFields.put("osca_bkg_flg", "oscaBkgFlg");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("vgm_doc_id_no", "vgmDocIdNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vgm_doc_tp_cd", "vgmDocTpCd");
		this.hashFields.put("vgm_dt_tp_cd", "vgmDtTpCd");
		this.hashFields.put("vgm_hndl_dt", "vgmHndlDt");
		this.hashFields.put("vgm_cust_cntc_tp_cd", "vgmCustCntcTpCd");
		this.hashFields.put("vgm_cust_cntc_nm", "vgmCustCntcNm");
		this.hashFields.put("vgm_cust_fax_no", "vgmCustFaxNo");
		this.hashFields.put("vgm_cust_eml", "vgmCustEml");
		this.hashFields.put("vgm_cust_phn_no", "vgmCustPhnNo");
		this.hashFields.put("vgm_cust_addr", "vgmCustAddr");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  crntSkdVoyNo
	*/
	public void	setCrntSkdVoyNo( String	crntSkdVoyNo ) {
		this.crntSkdVoyNo =	crntSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	crntSkdVoyNo
	 */
	 public	 String	getCrntSkdVoyNo() {
		 return	this.crntSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  bkgCgoTpCd
	*/
	public void	setBkgCgoTpCd( String	bkgCgoTpCd ) {
		this.bkgCgoTpCd =	bkgCgoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCgoTpCd
	 */
	 public	 String	getBkgCgoTpCd() {
		 return	this.bkgCgoTpCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgTpId
	*/
	public void	setMvmtEdiMsgTpId( String	mvmtEdiMsgTpId ) {
		this.mvmtEdiMsgTpId =	mvmtEdiMsgTpId;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgTpId
	 */
	 public	 String	getMvmtEdiMsgTpId() {
		 return	this.mvmtEdiMsgTpId;
	 } 
 	/**
	* Column Info
	* @param  gmtDt
	*/
	public void	setGmtDt( String	gmtDt ) {
		this.gmtDt =	gmtDt;
	}
 
	/**
	 * Column Info
	 * @return	gmtDt
	 */
	 public	 String	getGmtDt() {
		 return	this.gmtDt;
	 } 
 	/**
	* Column Info
	* @param  cnmvSeq
	*/
	public void	setCnmvSeq( String	cnmvSeq ) {
		this.cnmvSeq =	cnmvSeq;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSeq
	 */
	 public	 String	getCnmvSeq() {
		 return	this.cnmvSeq;
	 } 
 	/**
	* Column Info
	* @param  mvmtInpTpCd
	*/
	public void	setMvmtInpTpCd( String	mvmtInpTpCd ) {
		this.mvmtInpTpCd =	mvmtInpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtInpTpCd
	 */
	 public	 String	getMvmtInpTpCd() {
		 return	this.mvmtInpTpCd;
	 } 
 	/**
	* Column Info
	* @param  chssNo
	*/
	public void	setChssNo( String	chssNo ) {
		this.chssNo =	chssNo;
	}
 
	/**
	 * Column Info
	 * @return	chssNo
	 */
	 public	 String	getChssNo() {
		 return	this.chssNo;
	 } 
 	/**
	* Column Info
	* @param  mvmtTrspModCd
	*/
	public void	setMvmtTrspModCd( String	mvmtTrspModCd ) {
		this.mvmtTrspModCd =	mvmtTrspModCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtTrspModCd
	 */
	 public	 String	getMvmtTrspModCd() {
		 return	this.mvmtTrspModCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgSeq
	*/
	public void	setMvmtEdiMsgSeq( String	mvmtEdiMsgSeq ) {
		this.mvmtEdiMsgSeq =	mvmtEdiMsgSeq;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgSeq
	 */
	 public	 String	getMvmtEdiMsgSeq() {
		 return	this.mvmtEdiMsgSeq;
	 } 
 	/**
	* Column Info
	* @param  destYdCd
	*/
	public void	setDestYdCd( String	destYdCd ) {
		this.destYdCd =	destYdCd;
	}
 
	/**
	 * Column Info
	 * @return	destYdCd
	 */
	 public	 String	getDestYdCd() {
		 return	this.destYdCd;
	 } 
 	/**
	* Column Info
	* @param  ctrtSeq
	*/
	public void	setCtrtSeq( String	ctrtSeq ) {
		this.ctrtSeq =	ctrtSeq;
	}
 
	/**
	 * Column Info
	 * @return	ctrtSeq
	 */
	 public	 String	getCtrtSeq() {
		 return	this.ctrtSeq;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  mtyRepoVlRmk
	*/
	public void	setMtyRepoVlRmk( String	mtyRepoVlRmk ) {
		this.mtyRepoVlRmk =	mtyRepoVlRmk;
	}
 
	/**
	 * Column Info
	 * @return	mtyRepoVlRmk
	 */
	 public	 String	getMtyRepoVlRmk() {
		 return	this.mtyRepoVlRmk;
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
	* @param  substRuleCd
	*/
	public void	setSubstRuleCd( String	substRuleCd ) {
		this.substRuleCd =	substRuleCd;
	}
 
	/**
	 * Column Info
	 * @return	substRuleCd
	 */
	 public	 String	getSubstRuleCd() {
		 return	this.substRuleCd;
	 } 
 	/**
	* Column Info
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
	 } 
 	/**
	* Column Info
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrActCd
	*/
	public void	setCntrActCd( String	cntrActCd ) {
		this.cntrActCd =	cntrActCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrActCd
	 */
	 public	 String	getCntrActCd() {
		 return	this.cntrActCd;
	 } 
 	/**
	* Column Info
	* @param  cntrXchCd
	*/
	public void	setCntrXchCd( String	cntrXchCd ) {
		this.cntrXchCd =	cntrXchCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrXchCd
	 */
	 public	 String	getCntrXchCd() {
		 return	this.cntrXchCd;
	 } 
 	/**
	* Column Info
	* @param  cntrId
	*/
	public void	setCntrId( String	cntrId ) {
		this.cntrId =	cntrId;
	}
 
	/**
	 * Column Info
	 * @return	cntrId
	 */
	 public	 String	getCntrId() {
		 return	this.cntrId;
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
	* @param  mvmtEdiTpCd
	*/
	public void	setMvmtEdiTpCd( String	mvmtEdiTpCd ) {
		this.mvmtEdiTpCd =	mvmtEdiTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiTpCd
	 */
	 public	 String	getMvmtEdiTpCd() {
		 return	this.mvmtEdiTpCd;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrBarAtchKnt
	*/
	public void	setCntrHngrBarAtchKnt( String	cntrHngrBarAtchKnt ) {
		this.cntrHngrBarAtchKnt =	cntrHngrBarAtchKnt;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrBarAtchKnt
	 */
	 public	 String	getCntrHngrBarAtchKnt() {
		 return	this.cntrHngrBarAtchKnt;
	 } 
 	/**
	* Column Info
	* @param  cntrRfubFlg
	*/
	public void	setCntrRfubFlg( String	cntrRfubFlg ) {
		this.cntrRfubFlg =	cntrRfubFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrRfubFlg
	 */
	 public	 String	getCntrRfubFlg() {
		 return	this.cntrRfubFlg;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
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
	* @param  evntDt
	*/
	public void	setEvntDt( String	evntDt ) {
		this.evntDt =	evntDt;
	}
 
	/**
	 * Column Info
	 * @return	evntDt
	 */
	 public	 String	getEvntDt() {
		 return	this.evntDt;
	 } 
 	/**
	* Column Info
	* @param  inpYdCd
	*/
	public void	setInpYdCd( String	inpYdCd ) {
		this.inpYdCd =	inpYdCd;
	}
 
	/**
	 * Column Info
	 * @return	inpYdCd
	 */
	 public	 String	getInpYdCd() {
		 return	this.inpYdCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgAreaCd
	*/
	public void	setMvmtEdiMsgAreaCd( String	mvmtEdiMsgAreaCd ) {
		this.mvmtEdiMsgAreaCd =	mvmtEdiMsgAreaCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgAreaCd
	 */
	 public	 String	getMvmtEdiMsgAreaCd() {
		 return	this.mvmtEdiMsgAreaCd;
	 } 
 	/**
	* Column Info
	* @param  callSgnNo
	*/
	public void	setCallSgnNo( String	callSgnNo ) {
		this.callSgnNo =	callSgnNo;
	}
 
	/**
	 * Column Info
	 * @return	callSgnNo
	 */
	 public	 String	getCallSgnNo() {
		 return	this.callSgnNo;
	 } 
 	/**
	* Column Info
	* @param  ctmUiYn
	*/
	public void	setCtmUiYn( String	ctmUiYn ) {
		this.ctmUiYn =	ctmUiYn;
	}
 
	/**
	 * Column Info
	 * @return	ctmUiYn
	 */
	 public	 String	getCtmUiYn() {
		 return	this.ctmUiYn;
	 } 
 	/**
	* Column Info
	* @param  wblNo
	*/
	public void	setWblNo( String	wblNo ) {
		this.wblNo =	wblNo;
	}
 
	/**
	 * Column Info
	 * @return	wblNo
	 */
	 public	 String	getWblNo() {
		 return	this.wblNo;
	 } 
 	/**
	* Column Info
	* @param  updLoclDt
	*/
	public void	setUpdLoclDt( String	updLoclDt ) {
		this.updLoclDt =	updLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	updLoclDt
	 */
	 public	 String	getUpdLoclDt() {
		 return	this.updLoclDt;
	 } 
 	/**
	* Column Info
	* @param  cnmvEvntDt
	*/
	public void	setCnmvEvntDt( String	cnmvEvntDt ) {
		this.cnmvEvntDt =	cnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvEvntDt
	 */
	 public	 String	getCnmvEvntDt() {
		 return	this.cnmvEvntDt;
	 } 
 	/**
	* Column Info
	* @param  spclCgoFlg
	*/
	public void	setSpclCgoFlg( String	spclCgoFlg ) {
		this.spclCgoFlg =	spclCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	spclCgoFlg
	 */
	 public	 String	getSpclCgoFlg() {
		 return	this.spclCgoFlg;
	 } 
 	/**
	* Column Info
	* @param  mvmtCreTpCd
	*/
	public void	setMvmtCreTpCd( String	mvmtCreTpCd ) {
		this.mvmtCreTpCd =	mvmtCreTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtCreTpCd
	 */
	 public	 String	getMvmtCreTpCd() {
		 return	this.mvmtCreTpCd;
	 } 
 	/**
	* Column Info
	* @param  aciacDivCd
	*/
	public void	setAciacDivCd( String	aciacDivCd ) {
		this.aciacDivCd =	aciacDivCd;
	}
 
	/**
	 * Column Info
	 * @return	aciacDivCd
	 */
	 public	 String	getAciacDivCd() {
		 return	this.aciacDivCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
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
	* @param  lloydNo
	*/
	public void	setLloydNo( String	lloydNo ) {
		this.lloydNo =	lloydNo;
	}
 
	/**
	 * Column Info
	 * @return	lloydNo
	 */
	 public	 String	getLloydNo() {
		 return	this.lloydNo;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgYrmondy
	*/
	public void	setMvmtEdiMsgYrmondy( String	mvmtEdiMsgYrmondy ) {
		this.mvmtEdiMsgYrmondy =	mvmtEdiMsgYrmondy;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgYrmondy
	 */
	 public	 String	getMvmtEdiMsgYrmondy() {
		 return	this.mvmtEdiMsgYrmondy;
	 } 
 	/**
	* Column Info
	* @param  cnmvRmk
	*/
	public void	setCnmvRmk( String	cnmvRmk ) {
		this.cnmvRmk =	cnmvRmk;
	}
 
	/**
	 * Column Info
	 * @return	cnmvRmk
	 */
	 public	 String	getCnmvRmk() {
		 return	this.cnmvRmk;
	 } 
 	/**
	* Column Info
	* @param  creLoclDt
	*/
	public void	setCreLoclDt( String	creLoclDt ) {
		this.creLoclDt =	creLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	creLoclDt
	 */
	 public	 String	getCreLoclDt() {
		 return	this.creLoclDt;
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
	* @param  pType2
	*/
	public void	setPType2( String	pType2 ) {
		this.pType2 =	pType2;
	}
 
	/**
	 * Column Info
	 * @return	pType2
	 */
	 public	 String	getPType2() {
		 return	this.pType2;
	 } 
 	/**
	* Column Info
	* @param  errMsg
	*/
	public void	setErrMsg( String	errMsg ) {
		this.errMsg =	errMsg;
	}
 
	/**
	 * Column Info
	 * @return	errMsg
	 */
	 public	 String	getErrMsg() {
		 return	this.errMsg;
	 } 
 	/**
	* Column Info
	* @param  trnkVslCd
	*/
	public void	setTrnkVslCd( String	trnkVslCd ) {
		this.trnkVslCd =	trnkVslCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkVslCd
	 */
	 public	 String	getTrnkVslCd() {
		 return	this.trnkVslCd;
	 } 
 	/**
	* Column Info
	* @param  pType1
	*/
	public void	setPType1( String	pType1 ) {
		this.pType1 =	pType1;
	}
 
	/**
	 * Column Info
	 * @return	pType1
	 */
	 public	 String	getPType1() {
		 return	this.pType1;
	 } 
 	/**
	* Column Info
	* @param  cntrDispFlg
	*/
	public void	setCntrDispFlg( String	cntrDispFlg ) {
		this.cntrDispFlg =	cntrDispFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrDispFlg
	 */
	 public	 String	getCntrDispFlg() {
		 return	this.cntrDispFlg;
	 } 
 	/**
	* Column Info
	* @param  ctrtOfcCtyCd
	*/
	public void	setCtrtOfcCtyCd( String	ctrtOfcCtyCd ) {
		this.ctrtOfcCtyCd =	ctrtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	ctrtOfcCtyCd
	 */
	 public	 String	getCtrtOfcCtyCd() {
		 return	this.ctrtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdVoyNo
	*/
	public void	setTrnkSkdVoyNo( String	trnkSkdVoyNo ) {
		this.trnkSkdVoyNo =	trnkSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdVoyNo
	 */
	 public	 String	getTrnkSkdVoyNo() {
		 return	this.trnkSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  pkupNo
	*/
	public void	setPkupNo( String	pkupNo ) {
		this.pkupNo =	pkupNo;
	}
 
	/**
	 * Column Info
	 * @return	pkupNo
	 */
	 public	 String	getPkupNo() {
		 return	this.pkupNo;
	 } 
 	/**
	* Column Info
	* @param  cnmvCycNo
	*/
	public void	setCnmvCycNo( String	cnmvCycNo ) {
		this.cnmvCycNo =	cnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNo
	 */
	 public	 String	getCnmvCycNo() {
		 return	this.cnmvCycNo;
	 } 
 	/**
	* Column Info
	* @param  lstrmCd
	*/
	public void	setLstrmCd( String	lstrmCd ) {
		this.lstrmCd =	lstrmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstrmCd
	 */
	 public	 String	getLstrmCd() {
		 return	this.lstrmCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvLvlNo
	*/
	public void	setCnmvLvlNo( String	cnmvLvlNo ) {
		this.cnmvLvlNo =	cnmvLvlNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvLvlNo
	 */
	 public	 String	getCnmvLvlNo() {
		 return	this.cnmvLvlNo;
	 } 
 	/**
	* Column Info
	* @param  checkDigit
	*/
	public void	setCheckDigit( String	checkDigit ) {
		this.checkDigit =	checkDigit;
	}
 
	/**
	 * Column Info
	 * @return	checkDigit
	 */
	 public	 String	getCheckDigit() {
		 return	this.checkDigit;
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
	* @param  bkgRcvTermCd
	*/
	public void	setBkgRcvTermCd( String	bkgRcvTermCd ) {
		this.bkgRcvTermCd =	bkgRcvTermCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgRcvTermCd
	 */
	 public	 String	getBkgRcvTermCd() {
		 return	this.bkgRcvTermCd;
	 } 
 	/**
	* Column Info
	* @param  xxlink
	*/
	public void	setXxlink( String	xxlink ) {
		this.xxlink =	xxlink;
	}
 
	/**
	 * Column Info
	 * @return	xxlink
	 */
	 public	 String	getXxlink() {
		 return	this.xxlink;
	 } 
 	/**
	* Column Info
	* @param  cntrSvrId
	*/
	public void	setCntrSvrId( String	cntrSvrId ) {
		this.cntrSvrId =	cntrSvrId;
	}
 
	/**
	 * Column Info
	 * @return	cntrSvrId
	 */
	 public	 String	getCntrSvrId() {
		 return	this.cntrSvrId;
	 } 
 	/**
	* Column Info
	* @param  fcntrFlg
	*/
	public void	setFcntrFlg( String	fcntrFlg ) {
		this.fcntrFlg =	fcntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	fcntrFlg
	 */
	 public	 String	getFcntrFlg() {
		 return	this.fcntrFlg;
	 } 
 	/**
	* Column Info
	* @param  bbulkFlg
	*/
	public void	setBbulkFlg( String	bbulkFlg ) {
		this.bbulkFlg =	bbulkFlg;
	}
 
	/**
	 * Column Info
	 * @return	bbulkFlg
	 */
	 public	 String	getBbulkFlg() {
		 return	this.bbulkFlg;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdDirCd
	*/
	public void	setTrnkSkdDirCd( String	trnkSkdDirCd ) {
		this.trnkSkdDirCd =	trnkSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdDirCd
	 */
	 public	 String	getTrnkSkdDirCd() {
		 return	this.trnkSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  cntrDmgFlg
	*/
	public void	setCntrDmgFlg( String	cntrDmgFlg ) {
		this.cntrDmgFlg =	cntrDmgFlg;
	}
 	/**
	* Column Info
	* @param  dmgFlgDt
	*/
	public void	setDmgFlgDt( String	dmgFlgDt ) {
		this.dmgFlgDt =	dmgFlgDt;
	}
 	/**
	* Column Info
	* @param  dmgUnflgDt
	*/
	public void	setDmgUnflgDt( String	dmgUnflgDt ) {
		this.dmgUnflgDt =	dmgUnflgDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrDmgFlg
	 */
	 public	 String	getCntrDmgFlg() {
		 return	this.cntrDmgFlg;
	 } 
	 
	/**
	 * Column Info
	 * @return	dmgFlgDt
	 */
	 public	 String	getDmgFlgDt() {
		 return	this.dmgFlgDt;
	 } 
		 
	/**
	 * Column Info
	 * @return	dmgUnflgDt
	 */
	 public	 String	getDmgUnflgDt() {
		 return	this.dmgUnflgDt;
	 } 
 	/**
	* Column Info
	* @param  cnmvSplitNo
	*/
	public void	setCnmvSplitNo( String	cnmvSplitNo ) {
		this.cnmvSplitNo =	cnmvSplitNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvSplitNo
	 */
	 public	 String	getCnmvSplitNo() {
		 return	this.cnmvSplitNo;
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
	* @param  bkgKnt
	*/
	public void	setBkgKnt( String	bkgKnt ) {
		this.bkgKnt =	bkgKnt;
	}
 
	/**
	 * Column Info
	 * @return	bkgKnt
	 */
	 public	 String	getBkgKnt() {
		 return	this.bkgKnt;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
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
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  newFlg
	*/
	public void	setNewFlg( String	newFlg ) {
		this.newFlg =	newFlg;
	}
 
	/**
	 * Column Info
	 * @return	newFlg
	 */
	 public	 String	getNewFlg() {
		 return	this.newFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrStsSeq
	*/
	public void	setCntrStsSeq( String	cntrStsSeq ) {
		this.cntrStsSeq =	cntrStsSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsSeq
	 */
	 public	 String	getCntrStsSeq() {
		 return	this.cntrStsSeq;
	 } 
 	/**
	* Column Info
	* @param  bkgNoSplit
	*/
	public void	setBkgNoSplit( String	bkgNoSplit ) {
		this.bkgNoSplit =	bkgNoSplit;
	}
 
	/**
	 * Column Info
	 * @return	bkgNoSplit
	 */
	 public	 String	getBkgNoSplit() {
		 return	this.bkgNoSplit;
	 } 
 	/**
	* Column Info
	* @param  inlndTrspLicNo
	*/
	public void	setInlndTrspLicNo( String	inlndTrspLicNo ) {
		this.inlndTrspLicNo =	inlndTrspLicNo;
	}
 
	/**
	 * Column Info
	 * @return	inlndTrspLicNo
	 */
	 public	 String	getInlndTrspLicNo() {
		 return	this.inlndTrspLicNo;
	 } 
 	/**
	* Column Info
	* @param  crntSkdDirCd
	*/
	public void	setCrntSkdDirCd( String	crntSkdDirCd ) {
		this.crntSkdDirCd =	crntSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	crntSkdDirCd
	 */
	 public	 String	getCrntSkdDirCd() {
		 return	this.crntSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  preStsFlg
	*/
	public void	setPreStsFlg( String	preStsFlg ) {
		this.preStsFlg =	preStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	preStsFlg
	 */
	 public	 String	getPreStsFlg() {
		 return	this.preStsFlg;
	 } 
 	/**
	* Column Info
	* @param  orgYdCd
	*/
	public void	setOrgYdCd( String	orgYdCd ) {
		this.orgYdCd =	orgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	orgYdCd
	 */
	 public	 String	getOrgYdCd() {
		 return	this.orgYdCd;
	 } 
 	/**
	* Column Info
	* @param  mgstNo
	*/
	public void	setMgstNo( String	mgstNo ) {
		this.mgstNo =	mgstNo;
	}
 
	/**
	 * Column Info
	 * @return	mgstNo
	 */
	 public	 String	getMgstNo() {
		 return	this.mgstNo;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckFlg
	*/
	public void	setCntrHngrRckFlg( String	cntrHngrRckFlg ) {
		this.cntrHngrRckFlg =	cntrHngrRckFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckFlg
	 */
	 public	 String	getCntrHngrRckFlg() {
		 return	this.cntrHngrRckFlg;
	 } 
 	/**
	* Column Info
	* @param  obCntrFlg
	*/
	public void	setObCntrFlg( String	obCntrFlg ) {
		this.obCntrFlg =	obCntrFlg;
	}
 
	/**
	 * Column Info
	 * @return	obCntrFlg
	 */
	 public	 String	getObCntrFlg() {
		 return	this.obCntrFlg;
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
	* @param  mvmtStsCd
	*/
	public void	setMvmtStsCd( String	mvmtStsCd ) {
		this.mvmtStsCd =	mvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStsCd
	 */
	 public	 String	getMvmtStsCd() {
		 return	this.mvmtStsCd;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  cntrSealNo
	*/
	public void	setCntrSealNo( String	cntrSealNo ) {
		this.cntrSealNo =	cntrSealNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSealNo
	 */
	 public	 String	getCntrSealNo() {
		 return	this.cntrSealNo;
	 } 
 	/**
	* Column Info
	* @param  imdtExtFlg
	*/
	public void	setImdtExtFlg( String	imdtExtFlg ) {
		this.imdtExtFlg =	imdtExtFlg;
	}
 
	/**
	 * Column Info
	 * @return	imdtExtFlg
	 */
	 public	 String	getImdtExtFlg() {
		 return	this.imdtExtFlg;
	 } 
 	/**
	* Column Info
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
	 } 
 	/**
	* Column Info
	* @param  cnmvCoCd
	*/
	public void	setCnmvCoCd( String	cnmvCoCd ) {
		this.cnmvCoCd =	cnmvCoCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCoCd
	 */
	 public	 String	getCnmvCoCd() {
		 return	this.cnmvCoCd;
	 } 
 	/**
	* Column Info
	* @param  crntVslCd
	*/
	public void	setCrntVslCd( String	crntVslCd ) {
		this.crntVslCd =	crntVslCd;
	}
 
	/**
	 * Column Info
	 * @return	crntVslCd
	 */
	 public	 String	getCrntVslCd() {
		 return	this.crntVslCd;
	 } 
 	/**
	* Column Info
	* @param  ediCrrNo
	*/
	public void	setEdiCrrNo( String	ediCrrNo ) {
		this.ediCrrNo =	ediCrrNo;
	}
 
	/**
	 * Column Info
	 * @return	ediCrrNo
	 */
	 public	 String	getEdiCrrNo() {
		 return	this.ediCrrNo;
	 } 
 	/**
	* Column Info
	* @param  trspDocNo
	*/
	public void	setTrspDocNo( String	trspDocNo ) {
		this.trspDocNo =	trspDocNo;
	}
 
	/**
	 * Column Info
	 * @return	trspDocNo
	 */
	 public	 String	getTrspDocNo() {
		 return	this.trspDocNo;
	 } 
 	/**
	* Column Info
	* @param  mtyRepoNo
	*/
	public void	setMtyRepoNo( String	mtyRepoNo ) {
		this.mtyRepoNo =	mtyRepoNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyRepoNo
	 */
	 public	 String	getMtyRepoNo() {
		 return	this.mtyRepoNo;
	 } 
 	/**
	* Column Info
	* @param  woNo
	*/
	public void	setWoNo( String	woNo ) {
		this.woNo =	woNo;
	}
 
	/**
	 * Column Info
	 * @return	woNo
	 */
	 public	 String	getWoNo() {
		 return	this.woNo;
	 } 
 	/**
	* Column Info
	* @param  mtyPlnNo
	*/
	public void	setMtyPlnNo( String	mtyPlnNo ) {
		this.mtyPlnNo =	mtyPlnNo;
	}
 
	/**
	 * Column Info
	 * @return	mtyPlnNo
	 */
	 public	 String	getMtyPlnNo() {
		 return	this.mtyPlnNo;
	 } 
 	/**
	* Column Info
	* @param  tirNo
	*/
	public void	setTirNo( String	tirNo ) {
		this.tirNo =	tirNo;
	}
 
	/**
	 * Column Info
	 * @return	tirNo
	 */
	 public	 String	getTirNo() {
		 return	this.tirNo;
	 } 
 	/**
	* Column Info
	* @param  ediVvdCd
	*/
	public void	setEdiVvdCd( String	ediVvdCd ) {
		this.ediVvdCd =	ediVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	ediVvdCd
	 */
	 public	 String	getEdiVvdCd() {
		 return	this.ediVvdCd;
	 } 
 	/**
	* Column Info
	* @param  oscaBkgFlg
	*/
	public void	setOscaBkgFlg( String	oscaBkgFlg ) {
		this.oscaBkgFlg =	oscaBkgFlg;
	}
 
	/**
	 * Column Info
	 * @return	oscaBkgFlg
	 */
	 public	 String	getOscaBkgFlg() {
		 return	this.oscaBkgFlg;
	 } 
 	/**
	* Column Info
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  rfCmprCtnt
	*/
	public void	setRfCmprCtnt( String	rfCmprCtnt ) {
		this.rfCmprCtnt =	rfCmprCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rfCmprCtnt
	 */
	 public	 String	getRfCmprCtnt() {
		 return	this.rfCmprCtnt;
	 } 
		
		/**
		 * Column Info
		 * @return vgmDocIdNo
		 */
		public String getVgmDocIdNo() {
			return this.vgmDocIdNo;
		}
		
		/**
		 * Column Info
		 * @return vgmWgt
		 */
		public String getVgmWgt() {
			return this.vgmWgt;
		}
		
		/**
		 * Column Info
		 * @return vgmWgtUtCd
		 */
		public String getVgmWgtUtCd() {
			return this.vgmWgtUtCd;
		}
		
		
		/**
		 * Column Info
		 * @return vgmDocTpCd
		 */
		public String getVgmDocTpCd() {
			return this.vgmDocTpCd;
		}
		
		
		/**
		 * Column Info
		 * @return vgmDtTpCd
		 */
		public String getVgmDtTpCd() {
			return this.vgmDtTpCd;
		}
		
		/**
		 * Column Info
		 * @return vgmHndlDt
		 */
		public String getVgmHndlDt() {
			return this.vgmHndlDt;
		}
		
		/**
		 * Column Info
		 * @return vgmCustCntcTpCd
		 */
		public String getVgmCustCntcTpCd() {
			return this.vgmCustCntcTpCd;
		}
		
		/**
		 * Column Info
		 * @return vgmCustCntcNm
		 */
		public String getVgmCustCntcNm() {
			return this.vgmCustCntcNm;
		}
		
		/**
		 * Column Info
		 * @return vgmCustFaxNo
		 */
		public String getVgmCustFaxNo() {
			return this.vgmCustFaxNo;
		}
		
		/**
		 * Column Info
		 * @return vgmCustEml
		 */
		public String getVgmCustEml() {
			return this.vgmCustEml;
		}
		
		/**
		 * Column Info
		 * @return vgmCustPhnNo
		 */
		public String getVgmCustPhnNo() {
			return this.vgmCustPhnNo;
		}
		
		/**
		 * Column Info
		 * @return vgmCustAddr
		 */
		public String getVgmCustAddr() {
			return this.vgmCustAddr;
		}
		
		/**
		 * Column Info
		 * @param vgmDocIdNo
		 */
		public void setVgmDocIdNo(String vgmDocIdNo) {
			this.vgmDocIdNo = vgmDocIdNo;
		}
		
		/**
		 * Column Info
		 * @param vgmWgt
		 */
		public void setVgmWgt(String vgmWgt) {
			this.vgmWgt = vgmWgt;
		}
		
		
		/**
		 * Column Info
		 * @param vgmWgtUtCd
		 */
		public void setVgmWgtUtCd(String vgmWgtUtCd) {
			this.vgmWgtUtCd = vgmWgtUtCd;
		}
		
		
		/**
		 * Column Info
		 * @param vgmDocTpCd
		 */
		public void setVgmDocTpCd(String vgmDocTpCd) {
			this.vgmDocTpCd = vgmDocTpCd;
		}
		
		/**
		 * Column Info
		 * @param vgmDtTpCd
		 */
		public void setVgmDtTpCd(String vgmDtTpCd) {
			this.vgmDtTpCd = vgmDtTpCd;
		}
		
		/**
		 * Column Info
		 * @param vgmHndlDt
		 */
		public void setVgmHndlDt(String vgmHndlDt) {
			this.vgmHndlDt = vgmHndlDt;
		}
		
		/**
		 * Column Info
		 * @param vgmCustCntcTpCd
		 */
		public void setVgmCustCntcTpCd(String vgmCustCntcTpCd) {
			this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		}
		
		/**
		 * Column Info
		 * @param vgmCustCntcNm
		 */
		public void setVgmCustCntcNm(String vgmCustCntcNm) {
			this.vgmCustCntcNm = vgmCustCntcNm;
		}
		
		/**
		 * Column Info
		 * @param vgmCustFaxNo
		 */
		public void setVgmCustFaxNo(String vgmCustFaxNo) {
			this.vgmCustFaxNo = vgmCustFaxNo;
		}
		
		/**
		 * Column Info
		 * @param vgmCustEml
		 */
		public void setVgmCustEml(String vgmCustEml) {
			this.vgmCustEml = vgmCustEml;
		}
		
		/**
		 * Column Info
		 * @param vgmCustPhnNo
		 */
		public void setVgmCustPhnNo(String vgmCustPhnNo) {
			this.vgmCustPhnNo = vgmCustPhnNo;
		}
		
		/**
		 * Column Info
		 * @param vgmCustAddr
		 */
		public void setVgmCustAddr(String vgmCustAddr) {
			this.vgmCustAddr = vgmCustAddr;
		}
		
		/**
		 * Column Info
		 * @return usaEdiCd
		 */
		public String getUsaEdiCd() {
			return this.usaEdiCd;
		}
		
		/**
		 * Column Info
		 * @return cntrStwgPsnCtnt
		 */
		public String getCntrStwgPsnCtnt() {
			return this.cntrStwgPsnCtnt;
		}
		
		/**
		 * Column Info
		 * @param usaEdiCd
		 */
		public void setUsaEdiCd(String usaEdiCd) {
			this.usaEdiCd = usaEdiCd;
		}
		
		/**
		 * Column Info
		 * @param cntrStwgPsnCtnt
		 */
		public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
			this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
		}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setCrntSkdVoyNo(JSPUtil.getParameter(request,	prefix + "crnt_skd_voy_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cgo_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_tp_id", ""));
		setGmtDt(JSPUtil.getParameter(request,	prefix + "gmt_dt", ""));
		setCnmvSeq(JSPUtil.getParameter(request,	prefix + "cnmv_seq", ""));
		setMvmtInpTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_inp_tp_cd", ""));
		setChssNo(JSPUtil.getParameter(request,	prefix + "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request,	prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_seq", ""));
		setDestYdCd(JSPUtil.getParameter(request,	prefix + "dest_yd_cd", ""));
		setCtrtSeq(JSPUtil.getParameter(request,	prefix + "ctrt_seq", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setMtyRepoVlRmk(JSPUtil.getParameter(request,	prefix + "mty_repo_vl_rmk", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSubstRuleCd(JSPUtil.getParameter(request,	prefix + "subst_rule_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setCntrActCd(JSPUtil.getParameter(request,	prefix + "cntr_act_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request,	prefix + "cntr_xch_cd", ""));
		setCntrId(JSPUtil.getParameter(request,	prefix + "cntr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_tp_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request,	prefix + "cntr_hngr_bar_atch_knt", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request,	prefix + "cntr_rfub_flg", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request,	prefix + "evnt_dt", ""));
		setInpYdCd(JSPUtil.getParameter(request,	prefix + "inp_yd_cd", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_area_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request,	prefix + "call_sgn_no", ""));
		setCtmUiYn(JSPUtil.getParameter(request,	prefix + "ctm_ui_yn", ""));
		setWblNo(JSPUtil.getParameter(request,	prefix + "wbl_no", ""));
		setUpdLoclDt(JSPUtil.getParameter(request,	prefix + "upd_locl_dt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request,	prefix + "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request,	prefix + "mvmt_cre_tp_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request,	prefix + "aciac_div_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request,	prefix + "lloyd_no", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_yrmondy", ""));
		setCnmvRmk(JSPUtil.getParameter(request,	prefix + "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request,	prefix + "cre_locl_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setPType2(JSPUtil.getParameter(request,	prefix + "p_type2", ""));
		setErrMsg(JSPUtil.getParameter(request,	prefix + "err_msg", ""));
		setTrnkVslCd(JSPUtil.getParameter(request,	prefix + "trnk_vsl_cd", ""));
		setPType1(JSPUtil.getParameter(request,	prefix + "p_type1", ""));
		setCntrDispFlg(JSPUtil.getParameter(request,	prefix + "cntr_disp_flg", ""));
		setCtrtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "ctrt_ofc_cty_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request,	prefix + "trnk_skd_voy_no", ""));
		setPkupNo(JSPUtil.getParameter(request,	prefix + "pkup_no", ""));
		setCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no", ""));
		setLstrmCd(JSPUtil.getParameter(request,	prefix + "lstrm_cd", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request,	prefix + "cnmv_lvl_no", ""));
		setCheckDigit(JSPUtil.getParameter(request,	prefix + "check_digit", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request,	prefix + "bkg_rcv_term_cd", ""));
		setXxlink(JSPUtil.getParameter(request,	prefix + "xxlink", ""));
		setCntrSvrId(JSPUtil.getParameter(request,	prefix + "cntr_svr_id", ""));
		setFcntrFlg(JSPUtil.getParameter(request,	prefix + "fcntr_flg", ""));
		setBbulkFlg(JSPUtil.getParameter(request,	prefix + "bbulk_flg", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request,	prefix + "trnk_skd_dir_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request,	prefix + "cntr_dmg_flg", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request,	prefix + "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBkgKnt(JSPUtil.getParameter(request,	prefix + "bkg_knt", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setNewFlg(JSPUtil.getParameter(request,	prefix + "new_flg", ""));
		setCntrStsSeq(JSPUtil.getParameter(request,	prefix + "cntr_sts_seq", ""));
		setBkgNoSplit(JSPUtil.getParameter(request,	prefix + "bkg_no_split", ""));
		setInlndTrspLicNo(JSPUtil.getParameter(request,	prefix + "inlnd_trsp_lic_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request,	prefix + "crnt_skd_dir_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request,	prefix + "pre_sts_flg", ""));
		setOrgYdCd(JSPUtil.getParameter(request,	prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request,	prefix + "mgst_no", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_flg", ""));
		setObCntrFlg(JSPUtil.getParameter(request,	prefix + "ob_cntr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request,	prefix + "cntr_seal_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request,	prefix + "imdt_ext_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request,	prefix + "cnmv_co_cd", ""));
		setCrntVslCd(JSPUtil.getParameter(request,	prefix + "crnt_vsl_cd", ""));
		setEdiCrrNo(JSPUtil.getParameter(request,	prefix + "edi_crr_no", ""));
		setTrspDocNo(JSPUtil.getParameter(request,	prefix + "trsp_doc_no", ""));
		setMtyRepoNo(JSPUtil.getParameter(request,	prefix + "mty_repo_no", ""));
		setWoNo(JSPUtil.getParameter(request,	prefix + "wo_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request,	prefix + "mty_pln_no", ""));
		setTirNo(JSPUtil.getParameter(request,	prefix + "tir_no", ""));
		setEdiVvdCd(JSPUtil.getParameter(request,	prefix + "edi_vvd_cd", ""));
		setOscaBkgFlg(JSPUtil.getParameter(request,	prefix + "osca_bkg_flg", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setVgmDocIdNo(JSPUtil.getParameter(request, prefix + "vgm_doc_id_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setVgmDocTpCd(JSPUtil.getParameter(request, prefix + "vgm_doc_tp_cd", ""));
		setVgmDtTpCd(JSPUtil.getParameter(request, prefix + "vgm_dt_tp_cd", ""));
		setVgmHndlDt(JSPUtil.getParameter(request, prefix + "vgm_hndl_dt", ""));
		setVgmCustCntcTpCd(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_tp_cd", ""));
		setVgmCustCntcNm(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_nm", ""));
		setVgmCustFaxNo(JSPUtil.getParameter(request, prefix + "vgm_cust_fax_no", ""));
		setVgmCustEml(JSPUtil.getParameter(request, prefix + "vgm_cust_eml", ""));
		setVgmCustPhnNo(JSPUtil.getParameter(request, prefix + "vgm_cust_phn_no", ""));
		setVgmCustAddr(JSPUtil.getParameter(request, prefix + "vgm_cust_addr", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, prefix + "cntr_stwg_psn_ctnt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CusCtmMovementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] crntSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"crnt_skd_voy_no".trim(),	length));
				String[] bkgCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cgo_tp_cd".trim(),	length));
				String[] mvmtEdiMsgTpId =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_tp_id".trim(),	length));
				String[] gmtDt =	(JSPUtil.getParameter(request, prefix +	"gmt_dt".trim(),	length));
				String[] cnmvSeq =	(JSPUtil.getParameter(request, prefix +	"cnmv_seq".trim(),	length));
				String[] mvmtInpTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_inp_tp_cd".trim(),	length));
				String[] chssNo =	(JSPUtil.getParameter(request, prefix +	"chss_no".trim(),	length));
				String[] mvmtTrspModCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_trsp_mod_cd".trim(),	length));
				String[] mvmtEdiMsgSeq =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_seq".trim(),	length));
				String[] destYdCd =	(JSPUtil.getParameter(request, prefix +	"dest_yd_cd".trim(),	length));
				String[] ctrtSeq =	(JSPUtil.getParameter(request, prefix +	"ctrt_seq".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] mtyRepoVlRmk =	(JSPUtil.getParameter(request, prefix +	"mty_repo_vl_rmk".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] substRuleCd =	(JSPUtil.getParameter(request, prefix +	"subst_rule_cd".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] cntrActCd =	(JSPUtil.getParameter(request, prefix +	"cntr_act_cd".trim(),	length));
				String[] cntrXchCd =	(JSPUtil.getParameter(request, prefix +	"cntr_xch_cd".trim(),	length));
				String[] cntrId =	(JSPUtil.getParameter(request, prefix +	"cntr_id".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] mvmtEdiTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_tp_cd".trim(),	length));
				String[] cntrHngrBarAtchKnt =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_bar_atch_knt".trim(),	length));
				String[] cntrRfubFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_rfub_flg".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] evntDt =	(JSPUtil.getParameter(request, prefix +	"evnt_dt".trim(),	length));
				String[] inpYdCd =	(JSPUtil.getParameter(request, prefix +	"inp_yd_cd".trim(),	length));
				String[] mvmtEdiMsgAreaCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_area_cd".trim(),	length));
				String[] callSgnNo =	(JSPUtil.getParameter(request, prefix +	"call_sgn_no".trim(),	length));
				String[] ctmUiYn =	(JSPUtil.getParameter(request, prefix +	"ctm_ui_yn".trim(),	length));
				String[] wblNo =	(JSPUtil.getParameter(request, prefix +	"wbl_no".trim(),	length));
				String[] updLoclDt =	(JSPUtil.getParameter(request, prefix +	"upd_locl_dt".trim(),	length));
				String[] cnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_evnt_dt".trim(),	length));
				String[] spclCgoFlg =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_flg".trim(),	length));
				String[] mvmtCreTpCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_cre_tp_cd".trim(),	length));
				String[] aciacDivCd =	(JSPUtil.getParameter(request, prefix +	"aciac_div_cd".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] lloydNo =	(JSPUtil.getParameter(request, prefix +	"lloyd_no".trim(),	length));
				String[] mvmtEdiMsgYrmondy =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_yrmondy".trim(),	length));
				String[] cnmvRmk =	(JSPUtil.getParameter(request, prefix +	"cnmv_rmk".trim(),	length));
				String[] creLoclDt =	(JSPUtil.getParameter(request, prefix +	"cre_locl_dt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] pType2 =	(JSPUtil.getParameter(request, prefix +	"p_type2".trim(),	length));
				String[] errMsg =	(JSPUtil.getParameter(request, prefix +	"err_msg".trim(),	length));
				String[] trnkVslCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vsl_cd".trim(),	length));
				String[] pType1 =	(JSPUtil.getParameter(request, prefix +	"p_type1".trim(),	length));
				String[] cntrDispFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_disp_flg".trim(),	length));
				String[] ctrtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"ctrt_ofc_cty_cd".trim(),	length));
				String[] trnkSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_voy_no".trim(),	length));
				String[] pkupNo =	(JSPUtil.getParameter(request, prefix +	"pkup_no".trim(),	length));
				String[] cnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no".trim(),	length));
				String[] lstrmCd =	(JSPUtil.getParameter(request, prefix +	"lstrm_cd".trim(),	length));
				String[] cnmvLvlNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_lvl_no".trim(),	length));
				String[] checkDigit =	(JSPUtil.getParameter(request, prefix +	"check_digit".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] bkgRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"bkg_rcv_term_cd".trim(),	length));
				String[] xxlink =	(JSPUtil.getParameter(request, prefix +	"xxlink".trim(),	length));
				String[] cntrSvrId =	(JSPUtil.getParameter(request, prefix +	"cntr_svr_id".trim(),	length));
				String[] fcntrFlg =	(JSPUtil.getParameter(request, prefix +	"fcntr_flg".trim(),	length));
				String[] bbulkFlg =	(JSPUtil.getParameter(request, prefix +	"bbulk_flg".trim(),	length));
				String[] trnkSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_dir_cd".trim(),	length));
				String[] cntrDmgFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_dmg_flg".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				String[] cnmvSplitNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_split_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bkgKnt =	(JSPUtil.getParameter(request, prefix +	"bkg_knt".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] newFlg =	(JSPUtil.getParameter(request, prefix +	"new_flg".trim(),	length));
				String[] cntrStsSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_seq".trim(),	length));
				String[] bkgNoSplit =	(JSPUtil.getParameter(request, prefix +	"bkg_no_split".trim(),	length));
				String[] inlndTrspLicNo =	(JSPUtil.getParameter(request, prefix +	"inlnd_trsp_lic_no".trim(),	length));
				String[] crntSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"crnt_skd_dir_cd".trim(),	length));
				String[] preStsFlg =	(JSPUtil.getParameter(request, prefix +	"pre_sts_flg".trim(),	length));
				String[] orgYdCd =	(JSPUtil.getParameter(request, prefix +	"org_yd_cd".trim(),	length));
				String[] mgstNo =	(JSPUtil.getParameter(request, prefix +	"mgst_no".trim(),	length));
				String[] cntrHngrRckFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_flg".trim(),	length));
				String[] obCntrFlg =	(JSPUtil.getParameter(request, prefix +	"ob_cntr_flg".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrSealNo =	(JSPUtil.getParameter(request, prefix +	"cntr_seal_no".trim(),	length));
				String[] imdtExtFlg =	(JSPUtil.getParameter(request, prefix +	"imdt_ext_flg".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] cnmvCoCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_co_cd".trim(),	length));
				String[] crntVslCd =	(JSPUtil.getParameter(request, prefix +	"crnt_vsl_cd".trim(),	length));
				String[] ediCrrNo =	(JSPUtil.getParameter(request, prefix +	"edi_crr_no".trim(),	length));
				String[] trspDocNo =	(JSPUtil.getParameter(request, prefix +	"trsp_doc_no".trim(),	length));
				String[] mtyRepoNo =	(JSPUtil.getParameter(request, prefix +	"mty_repo_no".trim(),	length));
				String[] woNo =	(JSPUtil.getParameter(request, prefix +	"wo_no".trim(),	length));
				String[] mtyPlnNo =	(JSPUtil.getParameter(request, prefix +	"mty_pln_no".trim(),	length));
				String[] tirNo =	(JSPUtil.getParameter(request, prefix +	"tir_no".trim(),	length));
				String[] ediVvdCd =	(JSPUtil.getParameter(request, prefix +	"edi_vvd_cd".trim(),	length));
				String[] oscaBkgFlg =	(JSPUtil.getParameter(request, prefix +	"osca_bkg_flg".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
				String[] vgmDocIdNo = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_id_no", length));
				String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
				String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
				String[] vgmDocTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp_cd", length));
				String[] vgmDtTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_dt_tp_cd", length));
				String[] vgmHndlDt = (JSPUtil.getParameter(request, prefix	+ "vgm_hndl_dt", length));
				String[] vgmCustCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_tp_cd", length));
				String[] vgmCustCntcNm = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_nm", length));
				String[] vgmCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_fax_no", length));
				String[] vgmCustEml = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_eml", length));
				String[] vgmCustPhnNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_phn_no", length));
				String[] vgmCustAddr = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_addr", length));
				String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
				String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CusCtmMovementVO();
						if ( crntSkdVoyNo[i] !=	null)
						model.setCrntSkdVoyNo( crntSkdVoyNo[i]);
						if ( bkgCgoTpCd[i] !=	null)
						model.setBkgCgoTpCd( bkgCgoTpCd[i]);
						if ( mvmtEdiMsgTpId[i] !=	null)
						model.setMvmtEdiMsgTpId( mvmtEdiMsgTpId[i]);
						if ( gmtDt[i] !=	null)
						model.setGmtDt( gmtDt[i]);
						if ( cnmvSeq[i] !=	null)
						model.setCnmvSeq( cnmvSeq[i]);
						if ( mvmtInpTpCd[i] !=	null)
						model.setMvmtInpTpCd( mvmtInpTpCd[i]);
						if ( chssNo[i] !=	null)
						model.setChssNo( chssNo[i]);
						if ( mvmtTrspModCd[i] !=	null)
						model.setMvmtTrspModCd( mvmtTrspModCd[i]);
						if ( mvmtEdiMsgSeq[i] !=	null)
						model.setMvmtEdiMsgSeq( mvmtEdiMsgSeq[i]);
						if ( destYdCd[i] !=	null)
						model.setDestYdCd( destYdCd[i]);
						if ( ctrtSeq[i] !=	null)
						model.setCtrtSeq( ctrtSeq[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( mtyRepoVlRmk[i] !=	null)
						model.setMtyRepoVlRmk( mtyRepoVlRmk[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( substRuleCd[i] !=	null)
						model.setSubstRuleCd( substRuleCd[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( cntrActCd[i] !=	null)
						model.setCntrActCd( cntrActCd[i]);
						if ( cntrXchCd[i] !=	null)
						model.setCntrXchCd( cntrXchCd[i]);
						if ( cntrId[i] !=	null)
						model.setCntrId( cntrId[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( mvmtEdiTpCd[i] !=	null)
						model.setMvmtEdiTpCd( mvmtEdiTpCd[i]);
						if ( cntrHngrBarAtchKnt[i] !=	null)
						model.setCntrHngrBarAtchKnt( cntrHngrBarAtchKnt[i]);
						if ( cntrRfubFlg[i] !=	null)
						model.setCntrRfubFlg( cntrRfubFlg[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( evntDt[i] !=	null)
						model.setEvntDt( evntDt[i]);
						if ( inpYdCd[i] !=	null)
						model.setInpYdCd( inpYdCd[i]);
						if ( mvmtEdiMsgAreaCd[i] !=	null)
						model.setMvmtEdiMsgAreaCd( mvmtEdiMsgAreaCd[i]);
						if ( callSgnNo[i] !=	null)
						model.setCallSgnNo( callSgnNo[i]);
						if ( ctmUiYn[i] !=	null)
						model.setCtmUiYn( ctmUiYn[i]);
						if ( wblNo[i] !=	null)
						model.setWblNo( wblNo[i]);
						if ( updLoclDt[i] !=	null)
						model.setUpdLoclDt( updLoclDt[i]);
						if ( cnmvEvntDt[i] !=	null)
						model.setCnmvEvntDt( cnmvEvntDt[i]);
						if ( spclCgoFlg[i] !=	null)
						model.setSpclCgoFlg( spclCgoFlg[i]);
						if ( mvmtCreTpCd[i] !=	null)
						model.setMvmtCreTpCd( mvmtCreTpCd[i]);
						if ( aciacDivCd[i] !=	null)
						model.setAciacDivCd( aciacDivCd[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( lloydNo[i] !=	null)
						model.setLloydNo( lloydNo[i]);
						if ( mvmtEdiMsgYrmondy[i] !=	null)
						model.setMvmtEdiMsgYrmondy( mvmtEdiMsgYrmondy[i]);
						if ( cnmvRmk[i] !=	null)
						model.setCnmvRmk( cnmvRmk[i]);
						if ( creLoclDt[i] !=	null)
						model.setCreLoclDt( creLoclDt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( pType2[i] !=	null)
						model.setPType2( pType2[i]);
						if ( errMsg[i] !=	null)
						model.setErrMsg( errMsg[i]);
						if ( trnkVslCd[i] !=	null)
						model.setTrnkVslCd( trnkVslCd[i]);
						if ( pType1[i] !=	null)
						model.setPType1( pType1[i]);
						if ( cntrDispFlg[i] !=	null)
						model.setCntrDispFlg( cntrDispFlg[i]);
						if ( ctrtOfcCtyCd[i] !=	null)
						model.setCtrtOfcCtyCd( ctrtOfcCtyCd[i]);
						if ( trnkSkdVoyNo[i] !=	null)
						model.setTrnkSkdVoyNo( trnkSkdVoyNo[i]);
						if ( pkupNo[i] !=	null)
						model.setPkupNo( pkupNo[i]);
						if ( cnmvCycNo[i] !=	null)
						model.setCnmvCycNo( cnmvCycNo[i]);
						if ( lstrmCd[i] !=	null)
						model.setLstrmCd( lstrmCd[i]);
						if ( cnmvLvlNo[i] !=	null)
						model.setCnmvLvlNo( cnmvLvlNo[i]);
						if ( checkDigit[i] !=	null)
						model.setCheckDigit( checkDigit[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( bkgRcvTermCd[i] !=	null)
						model.setBkgRcvTermCd( bkgRcvTermCd[i]);
						if ( xxlink[i] !=	null)
						model.setXxlink( xxlink[i]);
						if ( cntrSvrId[i] !=	null)
						model.setCntrSvrId( cntrSvrId[i]);
						if ( fcntrFlg[i] !=	null)
						model.setFcntrFlg( fcntrFlg[i]);
						if ( bbulkFlg[i] !=	null)
						model.setBbulkFlg( bbulkFlg[i]);
						if ( trnkSkdDirCd[i] !=	null)
						model.setTrnkSkdDirCd( trnkSkdDirCd[i]);
						if ( cntrDmgFlg[i] !=	null)
						model.setCntrDmgFlg( cntrDmgFlg[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
						if ( cnmvSplitNo[i] !=	null)
						model.setCnmvSplitNo( cnmvSplitNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bkgKnt[i] !=	null)
						model.setBkgKnt( bkgKnt[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( newFlg[i] !=	null)
						model.setNewFlg( newFlg[i]);
						if ( cntrStsSeq[i] !=	null)
						model.setCntrStsSeq( cntrStsSeq[i]);
						if ( bkgNoSplit[i] !=	null)
						model.setBkgNoSplit( bkgNoSplit[i]);
						if ( inlndTrspLicNo[i] !=	null)
						model.setInlndTrspLicNo( inlndTrspLicNo[i]);
						if ( crntSkdDirCd[i] !=	null)
						model.setCrntSkdDirCd( crntSkdDirCd[i]);
						if ( preStsFlg[i] !=	null)
						model.setPreStsFlg( preStsFlg[i]);
						if ( orgYdCd[i] !=	null)
						model.setOrgYdCd( orgYdCd[i]);
						if ( mgstNo[i] !=	null)
						model.setMgstNo( mgstNo[i]);
						if ( cntrHngrRckFlg[i] !=	null)
						model.setCntrHngrRckFlg( cntrHngrRckFlg[i]);
						if ( obCntrFlg[i] !=	null)
						model.setObCntrFlg( obCntrFlg[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrSealNo[i] !=	null)
						model.setCntrSealNo( cntrSealNo[i]);
						if ( imdtExtFlg[i] !=	null)
						model.setImdtExtFlg( imdtExtFlg[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( cnmvCoCd[i] !=	null)
						model.setCnmvCoCd( cnmvCoCd[i]);
						if ( crntVslCd[i] !=	null)
						model.setCrntVslCd( crntVslCd[i]);
						if ( ediCrrNo[i] !=	null)
						model.setEdiCrrNo( ediCrrNo[i]);
						if ( trspDocNo[i] !=	null)
						model.setTrspDocNo( trspDocNo[i]);
						if ( mtyRepoNo[i] !=	null)
						model.setMtyRepoNo( mtyRepoNo[i]);
						if ( woNo[i] !=	null)
						model.setWoNo( woNo[i]);
						if ( mtyPlnNo[i] !=	null)
						model.setMtyPlnNo( mtyPlnNo[i]);
						if ( tirNo[i] !=	null)
						model.setTirNo( tirNo[i]);
						if ( ediVvdCd[i] !=	null)
						model.setEdiVvdCd( ediVvdCd[i]);
						if ( oscaBkgFlg[i] !=	null)
						model.setOscaBkgFlg( oscaBkgFlg[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( rfCmprCtnt[i] !=	null)
						model.setRfCmprCtnt( rfCmprCtnt[i]);
						if (vgmDocIdNo[i] != null)
							model.setVgmDocIdNo(vgmDocIdNo[i]);
						if (vgmWgt[i] != null)
							model.setVgmWgt(vgmWgt[i]);
						if (vgmWgtUtCd[i] != null)
							model.setVgmWgtUtCd(vgmWgtUtCd[i]);
						if (vgmDocTpCd[i] != null)
							model.setVgmDocTpCd(vgmDocTpCd[i]);
						if (vgmDtTpCd[i] != null)
							model.setVgmDtTpCd(vgmDtTpCd[i]);
						if (vgmHndlDt[i] != null)
							model.setVgmHndlDt(vgmHndlDt[i]);
						if (vgmCustCntcTpCd[i] != null)
							model.setVgmCustCntcTpCd(vgmCustCntcTpCd[i]);
						if (vgmCustCntcNm[i] != null)
							model.setVgmCustCntcNm(vgmCustCntcNm[i]);
						if (vgmCustFaxNo[i] != null)
							model.setVgmCustFaxNo(vgmCustFaxNo[i]);
						if (vgmCustEml[i] != null)
							model.setVgmCustEml(vgmCustEml[i]);
						if (vgmCustPhnNo[i] != null)
							model.setVgmCustPhnNo(vgmCustPhnNo[i]);
						if (vgmCustAddr[i] != null)
							model.setVgmCustAddr(vgmCustAddr[i]);
						if (usaEdiCd[i] != null)
							model.setUsaEdiCd(usaEdiCd[i]);
						if (cntrStwgPsnCtnt[i] != null)
							model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCusCtmMovementVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[]	 getCusCtmMovementVOs(){
		CusCtmMovementVO[] vos = (CusCtmMovementVO[])models.toArray(new	CusCtmMovementVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.crntSkdVoyNo =	this.crntSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd =	this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId =	this.mvmtEdiMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt =	this.gmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq =	this.cnmvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtInpTpCd =	this.mvmtInpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo =	this.chssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd =	this.mvmtTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq =	this.mvmtEdiMsgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd =	this.destYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq =	this.ctrtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoVlRmk =	this.mtyRepoVlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substRuleCd =	this.substRuleCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrActCd =	this.cntrActCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd =	this.cntrXchCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId =	this.cntrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd =	this.mvmtEdiTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt =	this.cntrHngrBarAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg =	this.cntrRfubFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt =	this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYdCd =	this.inpYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd =	this.mvmtEdiMsgAreaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo =	this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctmUiYn =	this.ctmUiYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo =	this.wblNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt =	this.updLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt =	this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg =	this.spclCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd =	this.mvmtCreTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd =	this.aciacDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo =	this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy =	this.mvmtEdiMsgYrmondy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk =	this.cnmvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt =	this.creLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType2 =	this.pType2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg =	this.errMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd =	this.trnkVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType1 =	this.pType1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg =	this.cntrDispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCtyCd =	this.ctrtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo =	this.trnkSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo =	this.pkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo =	this.cnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstrmCd =	this.lstrmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo =	this.cnmvLvlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit =	this.checkDigit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd =	this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xxlink =	this.xxlink.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId =	this.cntrSvrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg =	this.fcntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbulkFlg =	this.bbulkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd =	this.trnkSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg =	this.cntrDmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo =	this.cnmvSplitNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt =	this.bkgKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFlg =	this.newFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq =	this.cntrStsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit =	this.bkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndTrspLicNo =	this.inlndTrspLicNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd =	this.crntSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg =	this.preStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd =	this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo =	this.mgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg =	this.cntrHngrRckFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg =	this.obCntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo =	this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg =	this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd =	this.cnmvCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd =	this.crntVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCrrNo =	this.ediCrrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo =	this.trspDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoNo =	this.mtyRepoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo =	this.woNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo =	this.mtyPlnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tirNo =	this.tirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvdCd =	this.ediVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscaBkgFlg =	this.oscaBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocIdNo = this.vgmDocIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocTpCd = this.vgmDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtTpCd = this.vgmDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmHndlDt = this.vgmHndlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcTpCd = this.vgmCustCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcNm = this.vgmCustCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustFaxNo = this.vgmCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustEml = this.vgmCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustPhnNo = this.vgmCustPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustAddr = this.vgmCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}