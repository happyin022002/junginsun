/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CntrMasterInquiryVO.java
 *@FileTitle : CntrMasterInquiryVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
public class CntrMasterInquiryVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CntrMasterInquiryVO>  models =	new	ArrayList<CntrMasterInquiryVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszIsoCd   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 minTemp   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 onhCntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 exitVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrBarTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 aproTirNo   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrBarAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 tareWgt   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 ownrCoCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 exitVndrEngNm   =  null;
	/*	Column Info	*/
	private  String	 aciacDivCd   =  null;
	/*	Column Info	*/
	private  String	 onhDtOld   =  null;
	/*	Column Info	*/
	private  String	 rntlChgAmt   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 chkDgt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 lessorNm   =  null;
	/*	Column Info	*/
	private  String	 rfRfrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckCd   =  null;
	/*	Column Info	*/
	private  String	 dppAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecNo   =  null;
	/*	Column Info	*/
	private  String	 lseVndrUrl   =  null;
	/*	Column Info	*/
	private  String	 cntrUseCoCd   =  null;
	/*	Column Info	*/
	private  String	 subLstmCd   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 rfMdlNm   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 costAmt   =  null;
	/*	Column Info	*/
	private  String	 tareWgtLbs   =  null;
	/*	Column Info	*/
	private  String	 certiNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo1   =  null;
	/*	Column Info	*/
	private  String	 dpcVal   =  null;
	/*	Column Info	*/
	private  String	 bkgNo2   =  null;
	/*	Column Info	*/
	private  String	 bkgNo3   =  null;
	/*	Column Info	*/
	private  String	 onhAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 uclmLs   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 cntrStsEvntDt   =  null;
	/*	Column Info	*/
	private  String	 usingDays   =  null;
	/*	Column Info	*/
	private  String	 exitAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 d2PayldFlg   =  null;
	/*	Column Info	*/
	private  String	 plstFlrFlg   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 maxTemp   =  null;
	/*	Column Info	*/
	private  String	 mftDt   =  null;
	/*	Column Info	*/
	private  String	 rfMkrSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 aproCscNo   =  null;
	/*	Column Info	*/
	private  String	 imdtExtFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrMtrlCd   =  null;
	/*	Column Info	*/
	private  String	 cntrStsEvntDtOld   =  null;
	/*	Column Info	*/
	private  String	 offHireAvail   =  null;
	/*	Column Info	*/
	private  String	 dppTpCd   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblDesc   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/*	Column Info	*/
	private  String	 lotPlnYr   =  null;
	/*	Column Info	*/
	private  String	 lotLocCd   =  null;
	/*	Column Info	*/
	private  String	 lotSeq   =  null;
	/*	Column Info	*/
	private  String	 lotCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 lsrCd   =  null;
	/*	Column Info	*/
	private  String	 lsrNm   =  null;
	/*	Column Info	*/
	private  String	 cntrAuthNo   =  null;
	/*	Column Info	*/
	private  String	 cntrGrsWgt   =  null;
	/*	Column Info	*/
	private  String	 cntrGrsWgtLbs   =  null;
	/*	Column Info	*/
	private  String	 payLoad   =  null;
	/*	Column Info	*/
	private  String	 payLoadLbs   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrOffhAuthNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CntrMasterInquiryVO(){}

	public CntrMasterInquiryVO(String vslCd,String cntrTpszIsoCd,String cntrStsCd,String minTemp,String pagerows,String onhCntrStsCd,String exitVndrSeq,String mnrHngrBarTpCd,String cntrTpszCd,String aproTirNo,String cntrHngrBarAtchKnt,String tareWgt,String lstmCd,String updUsrId,String ownrCoCd,String cnmvDt,String skdVoyNo,String exitVndrEngNm,String aciacDivCd,String onhDtOld,String rntlChgAmt,String dispFlg,String chkDgt,String creUsrId,String vndrSeq,String fullFlg,String vndrAbbrNm,String lessorNm,String rfRfrNo,String cntrHngrRckCd,String dppAmt,String cntrSpecNo,String lseVndrUrl,String cntrUseCoCd,String subLstmCd,String vndrLglEngNm,String creDt,String crntYdCd,String dmgFlg,String rfMdlNm,String onhDt,String ibflag,String cnmvStsCd,String costAmt,String tareWgtLbs,String certiNo,String bkgNo1,String dpcVal,String bkgNo2,String bkgNo3,String onhAgmtNo,String uclmLs,String updDt,String cntrStsEvntDt,String usingDays,String exitAgmtNo,String d2PayldFlg,String plstFlrFlg,String skdDirCd,String maxTemp,String mftDt,String rfMkrSeq,String cntrNo,String aproCscNo,String imdtExtFlg,String cntrMtrlCd,String cntrStsEvntDtOld,String offHireAvail,String dppTpCd,String rfTpCd,String rstrUsgLblNm,String rstrUsgLblTp,String rstrUsgLblDesc,String rfHumidCtrlValCd,String rfCmprCtnt,String lotPlnYr,String lotLocCd,String lotSeq,String lotCntrTpszCd,String lsrCd,String lsrNm,String cntrAuthNo,String cntrGrsWgt,String cntrGrsWgtLbs,String payLoad,String payLoadLbs,String cntrSpecTpCd,String cntrOffhAuthNo)	{
		this.vslCd  = vslCd ;
		this.cntrTpszIsoCd  = cntrTpszIsoCd ;
		this.cntrStsCd  = cntrStsCd ;
		this.minTemp  = minTemp ;
		this.pagerows  = pagerows ;
		this.onhCntrStsCd  = onhCntrStsCd ;
		this.exitVndrSeq  = exitVndrSeq ;
		this.mnrHngrBarTpCd  = mnrHngrBarTpCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.aproTirNo  = aproTirNo ;
		this.cntrHngrBarAtchKnt  = cntrHngrBarAtchKnt ;
		this.tareWgt  = tareWgt ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.ownrCoCd  = ownrCoCd ;
		this.cnmvDt  = cnmvDt ;
		this.skdVoyNo  = skdVoyNo ;
		this.exitVndrEngNm  = exitVndrEngNm ;
		this.aciacDivCd  = aciacDivCd ;
		this.onhDtOld  = onhDtOld ;
		this.rntlChgAmt  = rntlChgAmt ;
		this.dispFlg  = dispFlg ;
		this.chkDgt  = chkDgt ;
		this.creUsrId  = creUsrId ;
		this.vndrSeq  = vndrSeq ;
		this.fullFlg  = fullFlg ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.lessorNm  = lessorNm ;
		this.rfRfrNo  = rfRfrNo ;
		this.cntrHngrRckCd  = cntrHngrRckCd ;
		this.dppAmt  = dppAmt ;
		this.cntrSpecNo  = cntrSpecNo ;
		this.lseVndrUrl  = lseVndrUrl ;
		this.cntrUseCoCd  = cntrUseCoCd ;
		this.subLstmCd  = subLstmCd ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.creDt  = creDt ;
		this.crntYdCd  = crntYdCd ;
		this.dmgFlg  = dmgFlg ;
		this.rfMdlNm  = rfMdlNm ;
		this.onhDt  = onhDt ;
		this.ibflag  = ibflag ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.costAmt  = costAmt ;
		this.tareWgtLbs  = tareWgtLbs ;
		this.certiNo  = certiNo ;
		this.bkgNo1  = bkgNo1 ;
		this.dpcVal  = dpcVal ;
		this.bkgNo2  = bkgNo2 ;
		this.bkgNo3  = bkgNo3 ;
		this.onhAgmtNo  = onhAgmtNo ;
		this.uclmLs  = uclmLs ;
		this.updDt  = updDt ;
		this.cntrStsEvntDt  = cntrStsEvntDt ;
		this.usingDays  = usingDays ;
		this.exitAgmtNo  = exitAgmtNo ;
		this.d2PayldFlg  = d2PayldFlg ;
		this.plstFlrFlg  = plstFlrFlg ;
		this.skdDirCd  = skdDirCd ;
		this.maxTemp  = maxTemp ;
		this.mftDt  = mftDt ;
		this.rfMkrSeq  = rfMkrSeq ;
		this.cntrNo  = cntrNo ;
		this.aproCscNo  = aproCscNo ;
		this.imdtExtFlg  = imdtExtFlg ;
		this.cntrMtrlCd  = cntrMtrlCd ;
		this.cntrStsEvntDtOld  = cntrStsEvntDtOld ;
		this.offHireAvail  = offHireAvail ;
		this.dppTpCd  = dppTpCd ;
		this.rfTpCd  = rfTpCd ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.rstrUsgLblTp  = rstrUsgLblTp ;
		this.rstrUsgLblDesc  = rstrUsgLblDesc ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.lotPlnYr  = lotPlnYr ;
		this.lotLocCd  = lotLocCd ;
		this.lotSeq  = lotSeq ;
		this.lotCntrTpszCd  = lotCntrTpszCd ;
		this.lsrCd  = lsrCd ;
		this.lsrNm  = lsrNm ;
		this.cntrAuthNo  = cntrAuthNo ;
		this.cntrGrsWgt  = cntrGrsWgt ;
		this.cntrGrsWgtLbs  = cntrGrsWgtLbs ;
		this.payLoad  = payLoad ;
		this.payLoadLbs  = payLoadLbs ;
		this.cntrSpecTpCd  = cntrSpecTpCd ;
		this.cntrOffhAuthNo  = cntrOffhAuthNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("min_temp", getMinTemp());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("onh_cntr_sts_cd", getOnhCntrStsCd());		
		this.hashColumns.put("exit_vndr_seq", getExitVndrSeq());		
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("apro_tir_no", getAproTirNo());		
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());		
		this.hashColumns.put("tare_wgt", getTareWgt());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("exit_vndr_eng_nm", getExitVndrEngNm());		
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());		
		this.hashColumns.put("onh_dt_old", getOnhDtOld());		
		this.hashColumns.put("rntl_chg_amt", getRntlChgAmt());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("chk_dgt", getChkDgt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("lessor_nm", getLessorNm());		
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());		
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());		
		this.hashColumns.put("dpp_amt", getDppAmt());		
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("lse_vndr_url", getLseVndrUrl());		
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());		
		this.hashColumns.put("sub_lstm_cd", getSubLstmCd());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("cost_amt", getCostAmt());		
		this.hashColumns.put("tare_wgt_lbs", getTareWgtLbs());		
		this.hashColumns.put("certi_no", getCertiNo());		
		this.hashColumns.put("bkg_no1", getBkgNo1());		
		this.hashColumns.put("dpc_val", getDpcVal());		
		this.hashColumns.put("bkg_no2", getBkgNo2());		
		this.hashColumns.put("bkg_no3", getBkgNo3());		
		this.hashColumns.put("onh_agmt_no", getOnhAgmtNo());		
		this.hashColumns.put("uclm_ls", getUclmLs());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());		
		this.hashColumns.put("using_days", getUsingDays());		
		this.hashColumns.put("exit_agmt_no", getExitAgmtNo());		
		this.hashColumns.put("d2_payld_flg", getD2PayldFlg());		
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("max_temp", getMaxTemp());		
		this.hashColumns.put("mft_dt", getMftDt());		
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("apro_csc_no", getAproCscNo());		
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());		
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());		
		this.hashColumns.put("cntr_sts_evnt_dt_old", getCntrStsEvntDtOld());		
		this.hashColumns.put("off_hire_avail", getOffHireAvail());		
		this.hashColumns.put("dpp_tp_cd", getDppTpCd());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());		
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());		
		this.hashColumns.put("rstr_usg_lbl_desc", getRstrUsgLblDesc());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());		
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());		
		this.hashColumns.put("lot_loc_cd", getLotLocCd());		
		this.hashColumns.put("lot_seq", getLotSeq());		
		this.hashColumns.put("lot_cntr_tpsz_cd", getLotCntrTpszCd());		
		this.hashColumns.put("lsr_cd", getLsrCd());		
		this.hashColumns.put("lsr_nm", getLsrNm());		
		this.hashColumns.put("cntr_auth_no", getCntrAuthNo());	
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());
		this.hashColumns.put("cntr_grs_wgt_lbs", getCntrGrsWgtLbs());	
		this.hashColumns.put("pay_load", getPayLoad());
		this.hashColumns.put("pay_load_lbs", getPayLoadLbs());
		this.hashColumns.put("cntr_spec_tp_cd", getCntrSpecTpCd());
		this.hashColumns.put("cntr_offh_auth_no", getCntrOffhAuthNo());								
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("onh_cntr_sts_cd", "onhCntrStsCd");
		this.hashFields.put("exit_vndr_seq", "exitVndrSeq");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("apro_tir_no", "aproTirNo");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("exit_vndr_eng_nm", "exitVndrEngNm");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("onh_dt_old", "onhDtOld");
		this.hashFields.put("rntl_chg_amt", "rntlChgAmt");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("chk_dgt", "chkDgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("dpp_amt", "dppAmt");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("lse_vndr_url", "lseVndrUrl");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("sub_lstm_cd", "subLstmCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("tare_wgt_lbs", "tareWgtLbs");
		this.hashFields.put("certi_no", "certiNo");
		this.hashFields.put("bkg_no1", "bkgNo1");
		this.hashFields.put("dpc_val", "dpcVal");
		this.hashFields.put("bkg_no2", "bkgNo2");
		this.hashFields.put("bkg_no3", "bkgNo3");
		this.hashFields.put("onh_agmt_no", "onhAgmtNo");
		this.hashFields.put("uclm_ls", "uclmLs");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("using_days", "usingDays");
		this.hashFields.put("exit_agmt_no", "exitAgmtNo");
		this.hashFields.put("d2_payld_flg", "d2PayldFlg");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("apro_csc_no", "aproCscNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("cntr_sts_evnt_dt_old", "cntrStsEvntDtOld");
		this.hashFields.put("off_hire_avail", "offHireAvail");
		this.hashFields.put("dpp_tp_cd", "dppTpCd");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstrUsgLblDesc");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("lot_cntr_tpsz_cd", "lotCntrTpszCd");
		this.hashFields.put("lsr_cd", "lsrCd");
		this.hashFields.put("lsr_nm", "lsrNm");
		this.hashFields.put("cntr_auth_no", "cntrAuthNo");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("cntr_grs_wgt_lbs", "cntrGrsWgtLbs");
		this.hashFields.put("pay_load", "payLoad");
		this.hashFields.put("pay_load_lbs", "payLoadLbs");
		this.hashFields.put("cntr_spec_tp_cd", "cntrSpecTpCd");
		this.hashFields.put("cntr_offh_auth_no", "cntrOffhAuthNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszIsoCd
	*/
	public void	setCntrTpszIsoCd( String	cntrTpszIsoCd ) {
		this.cntrTpszIsoCd =	cntrTpszIsoCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszIsoCd
	 */
	 public	 String	getCntrTpszIsoCd() {
		 return	this.cntrTpszIsoCd;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  minTemp
	*/
	public void	setMinTemp( String	minTemp ) {
		this.minTemp =	minTemp;
	}
 
	/**
	 * Column Info
	 * @return	minTemp
	 */
	 public	 String	getMinTemp() {
		 return	this.minTemp;
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
	* @param  onhCntrStsCd
	*/
	public void	setOnhCntrStsCd( String	onhCntrStsCd ) {
		this.onhCntrStsCd =	onhCntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	onhCntrStsCd
	 */
	 public	 String	getOnhCntrStsCd() {
		 return	this.onhCntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  exitVndrSeq
	*/
	public void	setExitVndrSeq( String	exitVndrSeq ) {
		this.exitVndrSeq =	exitVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	exitVndrSeq
	 */
	 public	 String	getExitVndrSeq() {
		 return	this.exitVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrBarTpCd
	*/
	public void	setMnrHngrBarTpCd( String	mnrHngrBarTpCd ) {
		this.mnrHngrBarTpCd =	mnrHngrBarTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrBarTpCd
	 */
	 public	 String	getMnrHngrBarTpCd() {
		 return	this.mnrHngrBarTpCd;
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
	* @param  aproTirNo
	*/
	public void	setAproTirNo( String	aproTirNo ) {
		this.aproTirNo =	aproTirNo;
	}
 
	/**
	 * Column Info
	 * @return	aproTirNo
	 */
	 public	 String	getAproTirNo() {
		 return	this.aproTirNo;
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
	* @param  tareWgt
	*/
	public void	setTareWgt( String	tareWgt ) {
		this.tareWgt =	tareWgt;
	}
 
	/**
	 * Column Info
	 * @return	tareWgt
	 */
	 public	 String	getTareWgt() {
		 return	this.tareWgt;
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
	* @param  ownrCoCd
	*/
	public void	setOwnrCoCd( String	ownrCoCd ) {
		this.ownrCoCd =	ownrCoCd;
	}
 
	/**
	 * Column Info
	 * @return	ownrCoCd
	 */
	 public	 String	getOwnrCoCd() {
		 return	this.ownrCoCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  exitVndrEngNm
	*/
	public void	setExitVndrEngNm( String	exitVndrEngNm ) {
		this.exitVndrEngNm =	exitVndrEngNm;
	}
 
	/**
	 * Column Info
	 * @return	exitVndrEngNm
	 */
	 public	 String	getExitVndrEngNm() {
		 return	this.exitVndrEngNm;
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
	* @param  onhDtOld
	*/
	public void	setOnhDtOld( String	onhDtOld ) {
		this.onhDtOld =	onhDtOld;
	}
 
	/**
	 * Column Info
	 * @return	onhDtOld
	 */
	 public	 String	getOnhDtOld() {
		 return	this.onhDtOld;
	 } 
 	/**
	* Column Info
	* @param  rntlChgAmt
	*/
	public void	setRntlChgAmt( String	rntlChgAmt ) {
		this.rntlChgAmt =	rntlChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	rntlChgAmt
	 */
	 public	 String	getRntlChgAmt() {
		 return	this.rntlChgAmt;
	 } 
 	/**
	* Column Info
	* @param  dispFlg
	*/
	public void	setDispFlg( String	dispFlg ) {
		this.dispFlg =	dispFlg;
	}
 
	/**
	 * Column Info
	 * @return	dispFlg
	 */
	 public	 String	getDispFlg() {
		 return	this.dispFlg;
	 } 
 	/**
	* Column Info
	* @param  chkDgt
	*/
	public void	setChkDgt( String	chkDgt ) {
		this.chkDgt =	chkDgt;
	}
 
	/**
	 * Column Info
	 * @return	chkDgt
	 */
	 public	 String	getChkDgt() {
		 return	this.chkDgt;
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
	* @param  fullFlg
	*/
	public void	setFullFlg( String	fullFlg ) {
		this.fullFlg =	fullFlg;
	}
 
	/**
	 * Column Info
	 * @return	fullFlg
	 */
	 public	 String	getFullFlg() {
		 return	this.fullFlg;
	 } 
 	/**
	* Column Info
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
	 } 
 	/**
	* Column Info
	* @param  lessorNm
	*/
	public void	setLessorNm( String	lessorNm ) {
		this.lessorNm =	lessorNm;
	}
 
	/**
	 * Column Info
	 * @return	lessorNm
	 */
	 public	 String	getLessorNm() {
		 return	this.lessorNm;
	 } 
 	/**
	* Column Info
	* @param  rfRfrNo
	*/
	public void	setRfRfrNo( String	rfRfrNo ) {
		this.rfRfrNo =	rfRfrNo;
	}
 
	/**
	 * Column Info
	 * @return	rfRfrNo
	 */
	 public	 String	getRfRfrNo() {
		 return	this.rfRfrNo;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckCd
	*/
	public void	setCntrHngrRckCd( String	cntrHngrRckCd ) {
		this.cntrHngrRckCd =	cntrHngrRckCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckCd
	 */
	 public	 String	getCntrHngrRckCd() {
		 return	this.cntrHngrRckCd;
	 } 
 	/**
	* Column Info
	* @param  dppAmt
	*/
	public void	setDppAmt( String	dppAmt ) {
		this.dppAmt =	dppAmt;
	}
 
	/**
	 * Column Info
	 * @return	dppAmt
	 */
	 public	 String	getDppAmt() {
		 return	this.dppAmt;
	 } 
 	/**
	* Column Info
	* @param  cntrSpecNo
	*/
	public void	setCntrSpecNo( String	cntrSpecNo ) {
		this.cntrSpecNo =	cntrSpecNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSpecNo
	 */
	 public	 String	getCntrSpecNo() {
		 return	this.cntrSpecNo;
	 } 
 	/**
	* Column Info
	* @param  lseVndrUrl
	*/
	public void	setLseVndrUrl( String	lseVndrUrl ) {
		this.lseVndrUrl =	lseVndrUrl;
	}
 
	/**
	 * Column Info
	 * @return	lseVndrUrl
	 */
	 public	 String	getLseVndrUrl() {
		 return	this.lseVndrUrl;
	 } 
 	/**
	* Column Info
	* @param  cntrUseCoCd
	*/
	public void	setCntrUseCoCd( String	cntrUseCoCd ) {
		this.cntrUseCoCd =	cntrUseCoCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrUseCoCd
	 */
	 public	 String	getCntrUseCoCd() {
		 return	this.cntrUseCoCd;
	 } 
 	/**
	* Column Info
	* @param  subLstmCd
	*/
	public void	setSubLstmCd( String	subLstmCd ) {
		this.subLstmCd =	subLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	subLstmCd
	 */
	 public	 String	getSubLstmCd() {
		 return	this.subLstmCd;
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
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
	 } 
 	/**
	* Column Info
	* @param  dmgFlg
	*/
	public void	setDmgFlg( String	dmgFlg ) {
		this.dmgFlg =	dmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlg
	 */
	 public	 String	getDmgFlg() {
		 return	this.dmgFlg;
	 } 
 	/**
	* Column Info
	* @param  rfMdlNm
	*/
	public void	setRfMdlNm( String	rfMdlNm ) {
		this.rfMdlNm =	rfMdlNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMdlNm
	 */
	 public	 String	getRfMdlNm() {
		 return	this.rfMdlNm;
	 } 
 	/**
	* Column Info
	* @param  onhDt
	*/
	public void	setOnhDt( String	onhDt ) {
		this.onhDt =	onhDt;
	}
 
	/**
	 * Column Info
	 * @return	onhDt
	 */
	 public	 String	getOnhDt() {
		 return	this.onhDt;
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
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  costAmt
	*/
	public void	setCostAmt( String	costAmt ) {
		this.costAmt =	costAmt;
	}
 
	/**
	 * Column Info
	 * @return	costAmt
	 */
	 public	 String	getCostAmt() {
		 return	this.costAmt;
	 } 
 	/**
	* Column Info
	* @param  tareWgtLbs
	*/
	public void	setTareWgtLbs( String	tareWgtLbs ) {
		this.tareWgtLbs =	tareWgtLbs;
	}
 
	/**
	 * Column Info
	 * @return	tareWgtLbs
	 */
	 public	 String	getTareWgtLbs() {
		 return	this.tareWgtLbs;
	 } 
 	/**
	* Column Info
	* @param  certiNo
	*/
	public void	setCertiNo( String	certiNo ) {
		this.certiNo =	certiNo;
	}
 
	/**
	 * Column Info
	 * @return	certiNo
	 */
	 public	 String	getCertiNo() {
		 return	this.certiNo;
	 } 
 	/**
	* Column Info
	* @param  bkgNo1
	*/
	public void	setBkgNo1( String	bkgNo1 ) {
		this.bkgNo1 =	bkgNo1;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo1
	 */
	 public	 String	getBkgNo1() {
		 return	this.bkgNo1;
	 } 
 	/**
	* Column Info
	* @param  dpcVal
	*/
	public void	setDpcVal( String	dpcVal ) {
		this.dpcVal =	dpcVal;
	}
 
	/**
	 * Column Info
	 * @return	dpcVal
	 */
	 public	 String	getDpcVal() {
		 return	this.dpcVal;
	 } 
 	/**
	* Column Info
	* @param  bkgNo2
	*/
	public void	setBkgNo2( String	bkgNo2 ) {
		this.bkgNo2 =	bkgNo2;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo2
	 */
	 public	 String	getBkgNo2() {
		 return	this.bkgNo2;
	 } 
 	/**
	* Column Info
	* @param  bkgNo3
	*/
	public void	setBkgNo3( String	bkgNo3 ) {
		this.bkgNo3 =	bkgNo3;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo3
	 */
	 public	 String	getBkgNo3() {
		 return	this.bkgNo3;
	 } 
 	/**
	* Column Info
	* @param  onhAgmtNo
	*/
	public void	setOnhAgmtNo( String	onhAgmtNo ) {
		this.onhAgmtNo =	onhAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	onhAgmtNo
	 */
	 public	 String	getOnhAgmtNo() {
		 return	this.onhAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  uclmLs
	*/
	public void	setUclmLs( String	uclmLs ) {
		this.uclmLs =	uclmLs;
	}
 
	/**
	 * Column Info
	 * @return	uclmLs
	 */
	 public	 String	getUclmLs() {
		 return	this.uclmLs;
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
	* @param  cntrStsEvntDt
	*/
	public void	setCntrStsEvntDt( String	cntrStsEvntDt ) {
		this.cntrStsEvntDt =	cntrStsEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsEvntDt
	 */
	 public	 String	getCntrStsEvntDt() {
		 return	this.cntrStsEvntDt;
	 } 
 	/**
	* Column Info
	* @param  usingDays
	*/
	public void	setUsingDays( String	usingDays ) {
		this.usingDays =	usingDays;
	}
 
	/**
	 * Column Info
	 * @return	usingDays
	 */
	 public	 String	getUsingDays() {
		 return	this.usingDays;
	 } 
 	/**
	* Column Info
	* @param  exitAgmtNo
	*/
	public void	setExitAgmtNo( String	exitAgmtNo ) {
		this.exitAgmtNo =	exitAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	exitAgmtNo
	 */
	 public	 String	getExitAgmtNo() {
		 return	this.exitAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  d2PayldFlg
	*/
	public void	setD2PayldFlg( String	d2PayldFlg ) {
		this.d2PayldFlg =	d2PayldFlg;
	}
 
	/**
	 * Column Info
	 * @return	d2PayldFlg
	 */
	 public	 String	getD2PayldFlg() {
		 return	this.d2PayldFlg;
	 } 
 	/**
	* Column Info
	* @param  plstFlrFlg
	*/
	public void	setPlstFlrFlg( String	plstFlrFlg ) {
		this.plstFlrFlg =	plstFlrFlg;
	}
 
	/**
	 * Column Info
	 * @return	plstFlrFlg
	 */
	 public	 String	getPlstFlrFlg() {
		 return	this.plstFlrFlg;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  maxTemp
	*/
	public void	setMaxTemp( String	maxTemp ) {
		this.maxTemp =	maxTemp;
	}
 
	/**
	 * Column Info
	 * @return	maxTemp
	 */
	 public	 String	getMaxTemp() {
		 return	this.maxTemp;
	 } 
 	/**
	* Column Info
	* @param  mftDt
	*/
	public void	setMftDt( String	mftDt ) {
		this.mftDt =	mftDt;
	}
 
	/**
	 * Column Info
	 * @return	mftDt
	 */
	 public	 String	getMftDt() {
		 return	this.mftDt;
	 } 
 	/**
	* Column Info
	* @param  rfMkrSeq
	*/
	public void	setRfMkrSeq( String	rfMkrSeq ) {
		this.rfMkrSeq =	rfMkrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrSeq
	 */
	 public	 String	getRfMkrSeq() {
		 return	this.rfMkrSeq;
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
	* @param  aproCscNo
	*/
	public void	setAproCscNo( String	aproCscNo ) {
		this.aproCscNo =	aproCscNo;
	}
 
	/**
	 * Column Info
	 * @return	aproCscNo
	 */
	 public	 String	getAproCscNo() {
		 return	this.aproCscNo;
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
	* @param  cntrMtrlCd
	*/
	public void	setCntrMtrlCd( String	cntrMtrlCd ) {
		this.cntrMtrlCd =	cntrMtrlCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrMtrlCd
	 */
	 public	 String	getCntrMtrlCd() {
		 return	this.cntrMtrlCd;
	 } 
 	/**
	* Column Info
	* @param  cntrStsEvntDtOld
	*/
	public void	setCntrStsEvntDtOld( String	cntrStsEvntDtOld ) {
		this.cntrStsEvntDtOld =	cntrStsEvntDtOld;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsEvntDtOld
	 */
	 public	 String	getCntrStsEvntDtOld() {
		 return	this.cntrStsEvntDtOld;
	 } 
 	/**
	* Column Info
	* @param  offHireAvail
	*/
	public void	setOffHireAvail( String	offHireAvail ) {
		this.offHireAvail =	offHireAvail;
	}
 
	/**
	 * Column Info
	 * @return	offHireAvail
	 */
	 public	 String	getOffHireAvail() {
		 return	this.offHireAvail;
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
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblNm
	*/
	public void	setRstrUsgLblNm( String	rstrUsgLblNm ) {
		this.rstrUsgLblNm =	rstrUsgLblNm;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNm
	 */
	 public	 String	getRstrUsgLblNm() {
		 return	this.rstrUsgLblNm;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblTp
	*/
	public void	setRstrUsgLblTp( String	rstrUsgLblTp ) {
		this.rstrUsgLblTp =	rstrUsgLblTp;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblTp
	 */
	 public	 String	getRstrUsgLblTp() {
		 return	this.rstrUsgLblTp;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblDesc
	*/
	public void	setRstrUsgLblDesc( String	rstrUsgLblDesc ) {
		this.rstrUsgLblDesc =	rstrUsgLblDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblDesc
	 */
	 public	 String	getRstrUsgLblDesc() {
		 return	this.rstrUsgLblDesc;
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
	* @param  lotPlnYr
	*/
	public void	setLotPlnYr( String	lotPlnYr ) {
		this.lotPlnYr =	lotPlnYr;
	}
 
	/**
	 * Column Info
	 * @return	lotPlnYr
	 */
	 public	 String	getLotPlnYr() {
		 return	this.lotPlnYr;
	 } 
 	/**
	* Column Info
	* @param  lotLocCd
	*/
	public void	setLotLocCd( String	lotLocCd ) {
		this.lotLocCd =	lotLocCd;
	}
 
	/**
	 * Column Info
	 * @return	lotLocCd
	 */
	 public	 String	getLotLocCd() {
		 return	this.lotLocCd;
	 } 
 	/**
	* Column Info
	* @param  lotSeq
	*/
	public void	setLotSeq( String	lotSeq ) {
		this.lotSeq =	lotSeq;
	}
 
	/**
	 * Column Info
	 * @return	lotSeq
	 */
	 public	 String	getLotSeq() {
		 return	this.lotSeq;
	 } 
 	/**
	* Column Info
	* @param  lotCntrTpszCd
	*/
	public void	setLotCntrTpszCd( String	lotCntrTpszCd ) {
		this.lotCntrTpszCd =	lotCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	lotCntrTpszCd
	 */
	 public	 String	getLotCntrTpszCd() {
		 return	this.lotCntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  lsrCd
	*/
	public void	setLsrCd( String	lsrCd ) {
		this.lsrCd =	lsrCd;
	}
 
	/**
	 * Column Info
	 * @return	lsrCd
	 */
	 public	 String	getLsrCd() {
		 return	this.lsrCd;
	 } 
 	/**
	* Column Info
	* @param  lsrNm
	*/
	public void	setLsrNm( String	lsrNm ) {
		this.lsrNm =	lsrNm;
	}
 
	/**
	 * Column Info
	 * @return	lsrNm
	 */
	 public	 String	getLsrNm() {
		 return	this.lsrNm;
	 } 
 	/**
	* Column Info
	* @param  cntrAuthNo
	*/
	public void	setCntrAuthNo( String	cntrAuthNo ) {
		this.cntrAuthNo =	cntrAuthNo;
	}
	/**
	 * Column Info
	 * @return	cntrAuthNo
	 */
	 public	 String	getCntrAuthNo() {
		 return	this.cntrAuthNo;
	 }
	 /**
	  * Column Info
	  * @param  cntrGrsWgt
	  */
	public void	setCntrGrsWgt( String	cntrGrsWgt ) {
		this.cntrGrsWgt =	cntrGrsWgt;
	}
	/**
	 * Column Info
	 * @return	cntrGrsWgt
	 */
	 public	 String	getCntrGrsWgt() {
		 return	this.cntrGrsWgt;
	 }
	/**
	 * Column Info
	 * @param  cntrGrsWgtLbs
	 */
	 public void	setCntrGrsWgtLbs( String	cntrGrsWgtLbs ) {
		this.cntrGrsWgtLbs =	cntrGrsWgtLbs;
	 }
	/**
	 * Column Info
	 * @return	cntrGrsWgtLbs
	 */
	 public	 String	getCntrGrsWgtLbs() {
		 return	this.cntrGrsWgtLbs;
	 }
	 /**
	  * Column Info
	  * @param  payLoad
	  */
	public void	setPayLoad ( String	payLoad ) {
		this.payLoad =	payLoad;
	}
	/**
	 * Column Info
	 * @return	payLoad
	 */
	 public	 String	getPayLoad() {
		 return	this.payLoad;
	 }
	 /**
	  * Column Info
	  * @param  payLoadLbs
	  */
	public void	setPayLoadLbs ( String	payLoadLbs ) {
		this.payLoadLbs =	payLoadLbs;
	}
	/**
	 * Column Info
	 * @return	payLoadLbs
	 */
	 public	 String	getPayLoadLbs() {
		 return	this.payLoadLbs;
	 }
	 /**
	  * Column Info
	  * @param  cntrSpecTpCd
	  */
	public void	setCntrSpecTpCd ( String	cntrSpecTpCd ) {
		this.cntrSpecTpCd =	cntrSpecTpCd;
	}
	/**
	 * Column Info
	 * @return	cntrSpecTpCd
	 */
	 public	 String	getCntrSpecTpCd() {
		 return	this.cntrSpecTpCd;
	 }
	 /**
	  * Column Info
	  * @param  cntrOffhAuthNo
	  */
	public void	setCntrOffhAuthNo ( String	cntrOffhAuthNo ) {
		this.cntrOffhAuthNo =	cntrOffhAuthNo;
	}
	/**
	 * Column Info
	 * @return	cntrOffhAuthNo
	 */
	 public	 String	getCntrOffhAuthNo() {
		 return	this.cntrOffhAuthNo;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_iso_cd", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setMinTemp(JSPUtil.getParameter(request,	prefix + "min_temp", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOnhCntrStsCd(JSPUtil.getParameter(request,	prefix + "onh_cntr_sts_cd", ""));
		setExitVndrSeq(JSPUtil.getParameter(request,	prefix + "exit_vndr_seq", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_bar_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setAproTirNo(JSPUtil.getParameter(request,	prefix + "apro_tir_no", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request,	prefix + "cntr_hngr_bar_atch_knt", ""));
		setTareWgt(JSPUtil.getParameter(request,	prefix + "tare_wgt", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setOwnrCoCd(JSPUtil.getParameter(request,	prefix + "ownr_co_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setExitVndrEngNm(JSPUtil.getParameter(request,	prefix + "exit_vndr_eng_nm", ""));
		setAciacDivCd(JSPUtil.getParameter(request,	prefix + "aciac_div_cd", ""));
		setOnhDtOld(JSPUtil.getParameter(request,	prefix + "onh_dt_old", ""));
		setRntlChgAmt(JSPUtil.getParameter(request,	prefix + "rntl_chg_amt", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setChkDgt(JSPUtil.getParameter(request,	prefix + "chk_dgt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setLessorNm(JSPUtil.getParameter(request,	prefix + "lessor_nm", ""));
		setRfRfrNo(JSPUtil.getParameter(request,	prefix + "rf_rfr_no", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd", ""));
		setDppAmt(JSPUtil.getParameter(request,	prefix + "dpp_amt", ""));
		setCntrSpecNo(JSPUtil.getParameter(request,	prefix + "cntr_spec_no", ""));
		setLseVndrUrl(JSPUtil.getParameter(request,	prefix + "lse_vndr_url", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request,	prefix + "cntr_use_co_cd", ""));
		setSubLstmCd(JSPUtil.getParameter(request,	prefix + "sub_lstm_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setRfMdlNm(JSPUtil.getParameter(request,	prefix + "rf_mdl_nm", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setCostAmt(JSPUtil.getParameter(request,	prefix + "cost_amt", ""));
		setTareWgtLbs(JSPUtil.getParameter(request,	prefix + "tare_wgt_lbs", ""));
		setCertiNo(JSPUtil.getParameter(request,	prefix + "certi_no", ""));
		setBkgNo1(JSPUtil.getParameter(request,	prefix + "bkg_no1", ""));
		setDpcVal(JSPUtil.getParameter(request,	prefix + "dpc_val", ""));
		setBkgNo2(JSPUtil.getParameter(request,	prefix + "bkg_no2", ""));
		setBkgNo3(JSPUtil.getParameter(request,	prefix + "bkg_no3", ""));
		setOnhAgmtNo(JSPUtil.getParameter(request,	prefix + "onh_agmt_no", ""));
		setUclmLs(JSPUtil.getParameter(request,	prefix + "uclm_ls", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request,	prefix + "cntr_sts_evnt_dt", ""));
		setUsingDays(JSPUtil.getParameter(request,	prefix + "using_days", ""));
		setExitAgmtNo(JSPUtil.getParameter(request,	prefix + "exit_agmt_no", ""));
		setD2PayldFlg(JSPUtil.getParameter(request,	prefix + "d2_payld_flg", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request,	prefix + "plst_flr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setMaxTemp(JSPUtil.getParameter(request,	prefix + "max_temp", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
		setRfMkrSeq(JSPUtil.getParameter(request,	prefix + "rf_mkr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setAproCscNo(JSPUtil.getParameter(request,	prefix + "apro_csc_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request,	prefix + "imdt_ext_flg", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request,	prefix + "cntr_mtrl_cd", ""));
		setCntrStsEvntDtOld(JSPUtil.getParameter(request,	prefix + "cntr_sts_evnt_dt_old", ""));
		setOffHireAvail(JSPUtil.getParameter(request,	prefix + "off_hire_avail", ""));
		setDppTpCd(JSPUtil.getParameter(request,	prefix + "dpp_tp_cd", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setLotPlnYr(JSPUtil.getParameter(request,	prefix + "lot_pln_yr", ""));
		setLotLocCd(JSPUtil.getParameter(request,	prefix + "lot_loc_cd", ""));
		setLotSeq(JSPUtil.getParameter(request,	prefix + "lot_seq", ""));
		setLotCntrTpszCd(JSPUtil.getParameter(request,	prefix + "lot_cntr_tpsz_cd", ""));
		setLsrCd(JSPUtil.getParameter(request,	prefix + "lsr_cd", ""));
		setLsrNm(JSPUtil.getParameter(request,	prefix + "lsr_nm", ""));
		setCntrAuthNo(JSPUtil.getParameter(request,	prefix + "cntr_auth_no", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request,	prefix + "cntr_grs_wgt", ""));
		setCntrGrsWgtLbs(JSPUtil.getParameter(request,	prefix + "cntr_grs_wgt_lbs", ""));
		setPayLoad(JSPUtil.getParameter(request,	prefix + "pay_load", ""));
		setPayLoadLbs(JSPUtil.getParameter(request,	prefix + "pay_load_lbs", ""));
		setCntrSpecTpCd(JSPUtil.getParameter(request,	prefix + "cntr_spec_tp_cd", ""));
		setCntrOffhAuthNo(JSPUtil.getParameter(request,	prefix + "cntr_offh_auth_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMasterInquiryVO[]
	 */
	public CntrMasterInquiryVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CntrMasterInquiryVO[]
	 */
	public CntrMasterInquiryVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CntrMasterInquiryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] cntrTpszIsoCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_iso_cd".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] minTemp =	(JSPUtil.getParameter(request, prefix +	"min_temp".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] onhCntrStsCd =	(JSPUtil.getParameter(request, prefix +	"onh_cntr_sts_cd".trim(),	length));
				String[] exitVndrSeq =	(JSPUtil.getParameter(request, prefix +	"exit_vndr_seq".trim(),	length));
				String[] mnrHngrBarTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_bar_tp_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] aproTirNo =	(JSPUtil.getParameter(request, prefix +	"apro_tir_no".trim(),	length));
				String[] cntrHngrBarAtchKnt =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_bar_atch_knt".trim(),	length));
				String[] tareWgt =	(JSPUtil.getParameter(request, prefix +	"tare_wgt".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] ownrCoCd =	(JSPUtil.getParameter(request, prefix +	"ownr_co_cd".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] exitVndrEngNm =	(JSPUtil.getParameter(request, prefix +	"exit_vndr_eng_nm".trim(),	length));
				String[] aciacDivCd =	(JSPUtil.getParameter(request, prefix +	"aciac_div_cd".trim(),	length));
				String[] onhDtOld =	(JSPUtil.getParameter(request, prefix +	"onh_dt_old".trim(),	length));
				String[] rntlChgAmt =	(JSPUtil.getParameter(request, prefix +	"rntl_chg_amt".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] chkDgt =	(JSPUtil.getParameter(request, prefix +	"chk_dgt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] lessorNm =	(JSPUtil.getParameter(request, prefix +	"lessor_nm".trim(),	length));
				String[] rfRfrNo =	(JSPUtil.getParameter(request, prefix +	"rf_rfr_no".trim(),	length));
				String[] cntrHngrRckCd =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd".trim(),	length));
				String[] dppAmt =	(JSPUtil.getParameter(request, prefix +	"dpp_amt".trim(),	length));
				String[] cntrSpecNo =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_no".trim(),	length));
				String[] lseVndrUrl =	(JSPUtil.getParameter(request, prefix +	"lse_vndr_url".trim(),	length));
				String[] cntrUseCoCd =	(JSPUtil.getParameter(request, prefix +	"cntr_use_co_cd".trim(),	length));
				String[] subLstmCd =	(JSPUtil.getParameter(request, prefix +	"sub_lstm_cd".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] rfMdlNm =	(JSPUtil.getParameter(request, prefix +	"rf_mdl_nm".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] costAmt =	(JSPUtil.getParameter(request, prefix +	"cost_amt".trim(),	length));
				String[] tareWgtLbs =	(JSPUtil.getParameter(request, prefix +	"tare_wgt_lbs".trim(),	length));
				String[] certiNo =	(JSPUtil.getParameter(request, prefix +	"certi_no".trim(),	length));
				String[] bkgNo1 =	(JSPUtil.getParameter(request, prefix +	"bkg_no1".trim(),	length));
				String[] dpcVal =	(JSPUtil.getParameter(request, prefix +	"dpc_val".trim(),	length));
				String[] bkgNo2 =	(JSPUtil.getParameter(request, prefix +	"bkg_no2".trim(),	length));
				String[] bkgNo3 =	(JSPUtil.getParameter(request, prefix +	"bkg_no3".trim(),	length));
				String[] onhAgmtNo =	(JSPUtil.getParameter(request, prefix +	"onh_agmt_no".trim(),	length));
				String[] uclmLs =	(JSPUtil.getParameter(request, prefix +	"uclm_ls".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] cntrStsEvntDt =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_evnt_dt".trim(),	length));
				String[] usingDays =	(JSPUtil.getParameter(request, prefix +	"using_days".trim(),	length));
				String[] exitAgmtNo =	(JSPUtil.getParameter(request, prefix +	"exit_agmt_no".trim(),	length));
				String[] d2PayldFlg =	(JSPUtil.getParameter(request, prefix +	"d2_payld_flg".trim(),	length));
				String[] plstFlrFlg =	(JSPUtil.getParameter(request, prefix +	"plst_flr_flg".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] maxTemp =	(JSPUtil.getParameter(request, prefix +	"max_temp".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				String[] rfMkrSeq =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_seq".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] aproCscNo =	(JSPUtil.getParameter(request, prefix +	"apro_csc_no".trim(),	length));
				String[] imdtExtFlg =	(JSPUtil.getParameter(request, prefix +	"imdt_ext_flg".trim(),	length));
				String[] cntrMtrlCd =	(JSPUtil.getParameter(request, prefix +	"cntr_mtrl_cd".trim(),	length));
				String[] cntrStsEvntDtOld =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_evnt_dt_old".trim(),	length));
				String[] offHireAvail =	(JSPUtil.getParameter(request, prefix +	"off_hire_avail".trim(),	length));
				String[] dppTpCd =	(JSPUtil.getParameter(request, prefix +	"dpp_tp_cd".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstrUsgLblDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
				String[] lotPlnYr =	(JSPUtil.getParameter(request, prefix +	"lot_pln_yr".trim(),	length));
				String[] lotLocCd =	(JSPUtil.getParameter(request, prefix +	"lot_loc_cd".trim(),	length));
				String[] lotSeq =	(JSPUtil.getParameter(request, prefix +	"lot_seq".trim(),	length));
				String[] lotCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"lot_cntr_tpsz_cd".trim(),	length));
				String[] lsrCd =	(JSPUtil.getParameter(request, prefix +	"lsr_cd".trim(),	length));
				String[] lsrNm =	(JSPUtil.getParameter(request, prefix +	"lsr_nm".trim(),	length));
				String[] cntrAuthNo =	(JSPUtil.getParameter(request, prefix +	"cntr_auth_no".trim(),	length));
				String[] cntrGrsWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_grs_wgt".trim(),	length));
				String[] cntrGrsWgtLbs =	(JSPUtil.getParameter(request, prefix +	"cntr_grs_wgt_lbs".trim(),	length));
				String[] payLoad =	(JSPUtil.getParameter(request, prefix +	"pay_load".trim(),	length));
				String[] payLoadLbs =	(JSPUtil.getParameter(request, prefix +	"pay_load_lbs".trim(),	length));
				String[] cntrSpecTpCd =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_tp_cd".trim(),	length));
				String[] cntrOffhAuthNo =	(JSPUtil.getParameter(request, prefix +	"cntr_offh_auth_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CntrMasterInquiryVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( cntrTpszIsoCd[i] !=	null)
						model.setCntrTpszIsoCd( cntrTpszIsoCd[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( minTemp[i] !=	null)
						model.setMinTemp( minTemp[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( onhCntrStsCd[i] !=	null)
						model.setOnhCntrStsCd( onhCntrStsCd[i]);
						if ( exitVndrSeq[i] !=	null)
						model.setExitVndrSeq( exitVndrSeq[i]);
						if ( mnrHngrBarTpCd[i] !=	null)
						model.setMnrHngrBarTpCd( mnrHngrBarTpCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( aproTirNo[i] !=	null)
						model.setAproTirNo( aproTirNo[i]);
						if ( cntrHngrBarAtchKnt[i] !=	null)
						model.setCntrHngrBarAtchKnt( cntrHngrBarAtchKnt[i]);
						if ( tareWgt[i] !=	null)
						model.setTareWgt( tareWgt[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( ownrCoCd[i] !=	null)
						model.setOwnrCoCd( ownrCoCd[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( exitVndrEngNm[i] !=	null)
						model.setExitVndrEngNm( exitVndrEngNm[i]);
						if ( aciacDivCd[i] !=	null)
						model.setAciacDivCd( aciacDivCd[i]);
						if ( onhDtOld[i] !=	null)
						model.setOnhDtOld( onhDtOld[i]);
						if ( rntlChgAmt[i] !=	null)
						model.setRntlChgAmt( rntlChgAmt[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( chkDgt[i] !=	null)
						model.setChkDgt( chkDgt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( lessorNm[i] !=	null)
						model.setLessorNm( lessorNm[i]);
						if ( rfRfrNo[i] !=	null)
						model.setRfRfrNo( rfRfrNo[i]);
						if ( cntrHngrRckCd[i] !=	null)
						model.setCntrHngrRckCd( cntrHngrRckCd[i]);
						if ( dppAmt[i] !=	null)
						model.setDppAmt( dppAmt[i]);
						if ( cntrSpecNo[i] !=	null)
						model.setCntrSpecNo( cntrSpecNo[i]);
						if ( lseVndrUrl[i] !=	null)
						model.setLseVndrUrl( lseVndrUrl[i]);
						if ( cntrUseCoCd[i] !=	null)
						model.setCntrUseCoCd( cntrUseCoCd[i]);
						if ( subLstmCd[i] !=	null)
						model.setSubLstmCd( subLstmCd[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( rfMdlNm[i] !=	null)
						model.setRfMdlNm( rfMdlNm[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( costAmt[i] !=	null)
						model.setCostAmt( costAmt[i]);
						if ( tareWgtLbs[i] !=	null)
						model.setTareWgtLbs( tareWgtLbs[i]);
						if ( certiNo[i] !=	null)
						model.setCertiNo( certiNo[i]);
						if ( bkgNo1[i] !=	null)
						model.setBkgNo1( bkgNo1[i]);
						if ( dpcVal[i] !=	null)
						model.setDpcVal( dpcVal[i]);
						if ( bkgNo2[i] !=	null)
						model.setBkgNo2( bkgNo2[i]);
						if ( bkgNo3[i] !=	null)
						model.setBkgNo3( bkgNo3[i]);
						if ( onhAgmtNo[i] !=	null)
						model.setOnhAgmtNo( onhAgmtNo[i]);
						if ( uclmLs[i] !=	null)
						model.setUclmLs( uclmLs[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( cntrStsEvntDt[i] !=	null)
						model.setCntrStsEvntDt( cntrStsEvntDt[i]);
						if ( usingDays[i] !=	null)
						model.setUsingDays( usingDays[i]);
						if ( exitAgmtNo[i] !=	null)
						model.setExitAgmtNo( exitAgmtNo[i]);
						if ( d2PayldFlg[i] !=	null)
						model.setD2PayldFlg( d2PayldFlg[i]);
						if ( plstFlrFlg[i] !=	null)
						model.setPlstFlrFlg( plstFlrFlg[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( maxTemp[i] !=	null)
						model.setMaxTemp( maxTemp[i]);
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
						if ( rfMkrSeq[i] !=	null)
						model.setRfMkrSeq( rfMkrSeq[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( aproCscNo[i] !=	null)
						model.setAproCscNo( aproCscNo[i]);
						if ( imdtExtFlg[i] !=	null)
						model.setImdtExtFlg( imdtExtFlg[i]);
						if ( cntrMtrlCd[i] !=	null)
						model.setCntrMtrlCd( cntrMtrlCd[i]);
						if ( cntrStsEvntDtOld[i] !=	null)
						model.setCntrStsEvntDtOld( cntrStsEvntDtOld[i]);
						if ( offHireAvail[i] !=	null)
						model.setOffHireAvail( offHireAvail[i]);
						if ( dppTpCd[i] !=	null)
						model.setDppTpCd( dppTpCd[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if ( rstrUsgLblTp[i] !=	null)
						model.setRstrUsgLblTp( rstrUsgLblTp[i]);
						if ( rstrUsgLblDesc[i] !=	null)
						model.setRstrUsgLblDesc( rstrUsgLblDesc[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( rfCmprCtnt[i] !=	null)
						model.setRfCmprCtnt( rfCmprCtnt[i]);
						if ( lotPlnYr[i] !=	null)
						model.setLotPlnYr( lotPlnYr[i]);
						if ( lotLocCd[i] !=	null)
						model.setLotLocCd( lotLocCd[i]);
						if ( lotSeq[i] !=	null)
						model.setLotSeq( lotSeq[i]);
						if ( lotCntrTpszCd[i] !=	null)
						model.setLotCntrTpszCd( lotCntrTpszCd[i]);
						if ( lsrCd[i] !=	null)
						model.setLsrCd( lsrCd[i]);
						if ( lsrNm[i] !=	null)
						model.setLsrNm( lsrNm[i]);
						if ( cntrAuthNo[i] !=	null)
						model.setCntrAuthNo( cntrAuthNo[i]);
						if ( cntrGrsWgt[i] !=	null)
							model.setCntrGrsWgt( cntrGrsWgt[i]);
						if ( cntrGrsWgtLbs[i] !=	null)
							model.setCntrGrsWgtLbs( cntrGrsWgtLbs[i]);
						if ( payLoad[i] !=	null)
							model.setPayLoad( payLoad[i]);
						if ( payLoadLbs[i] !=	null)
							model.setPayLoadLbs( payLoadLbs[i]);
						if ( cntrSpecTpCd[i] !=	null)
							model.setCntrSpecTpCd( cntrSpecTpCd[i]);
						if ( cntrOffhAuthNo[i] !=	null)
							model.setCntrOffhAuthNo( cntrOffhAuthNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCntrMasterInquiryVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CntrMasterInquiryVO[]
	 */
	public CntrMasterInquiryVO[]	 getCntrMasterInquiryVOs(){
		CntrMasterInquiryVO[] vos = (CntrMasterInquiryVO[])models.toArray(new	CntrMasterInquiryVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd =	this.cntrTpszIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp =	this.minTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhCntrStsCd =	this.onhCntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exitVndrSeq =	this.exitVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd =	this.mnrHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTirNo =	this.aproTirNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt =	this.cntrHngrBarAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt =	this.tareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd =	this.ownrCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exitVndrEngNm =	this.exitVndrEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd =	this.aciacDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDtOld =	this.onhDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgAmt =	this.rntlChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDgt =	this.chkDgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm =	this.lessorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo =	this.rfRfrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd =	this.cntrHngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppAmt =	this.dppAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo =	this.cntrSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseVndrUrl =	this.lseVndrUrl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd =	this.cntrUseCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLstmCd =	this.subLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm =	this.rfMdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt =	this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgtLbs =	this.tareWgtLbs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiNo =	this.certiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo1 =	this.bkgNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcVal =	this.dpcVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo2 =	this.bkgNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo3 =	this.bkgNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhAgmtNo =	this.onhAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLs =	this.uclmLs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt =	this.cntrStsEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDays =	this.usingDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exitAgmtNo =	this.exitAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PayldFlg =	this.d2PayldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg =	this.plstFlrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp =	this.maxTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq =	this.rfMkrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCscNo =	this.aproCscNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg =	this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd =	this.cntrMtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDtOld =	this.cntrStsEvntDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireAvail =	this.offHireAvail.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppTpCd =	this.dppTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblDesc =	this.rstrUsgLblDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr =	this.lotPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd =	this.lotLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq =	this.lotSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrTpszCd =	this.lotCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsrCd =	this.lsrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsrNm =	this.lsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAuthNo =	this.cntrAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt =	this.cntrGrsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgtLbs =	this.cntrGrsWgtLbs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLoad =	this.payLoad.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLoadLbs =	this.payLoadLbs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecTpCd =	this.cntrSpecTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOffhAuthNo =	this.cntrOffhAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}