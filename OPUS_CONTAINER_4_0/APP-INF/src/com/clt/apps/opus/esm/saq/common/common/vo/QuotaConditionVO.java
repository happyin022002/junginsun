/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : QuotaConditionVO.java
*@FileTitle      : QuotaConditionVO  => Used to Yearly,  Quartely, Fixed Quata Inquiry Menu
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 성미영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class QuotaConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<QuotaConditionVO> models = new ArrayList<QuotaConditionVO>();
	

	/* Column Info */
	private String ctrtAqCd = null;
	/* Column Info */
	private String targetGrpChild = null;
	/* Column Info */
	private String tradeChild = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String targetGrp = null;
	/* Column Info */
	private String version = null;
	/* Column Info */
	private String unit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String subTrade = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String dirCdChild = null;	
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String quarter = null;
	/* Column Info */
	private String slsFcastPubNo = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String fmStep = null; //fm_step 
	/* Column Info */
	private String toStep = null; //to_step 
	/* Column Info */
	private String intervalTime = null;
	/* Column Info */
	private String grp_flg = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String step = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String repTrade = null;   // added by shin yongchan - 20090831
	private String yqtaVerNo = null; // added by shin yongchan - 20090831
	private String loginOfcCd= null; // added by shin yongchan - 20090831
	
	private String sheet_check = null; 

	private String isZeroLoad = null;  // added by shin yongchan - 20090902
	
	/* Column Info */ 
	private String repMonth = null;
	/* Column Info */ //0077화면  searchSaqMonthlyModelResultStatusList의 결과값 담아 분기문의 조건으로 사용하기 위해 생성. 
	private String str = null; //saq_mon_tgt_vvd 테이블에서  tgt_vvd_sts_cd를 검색하여  N (= Notified)인 경우만 진행되도록 처리.

	/* Column Info */
	private String yqtaMdlVerNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String plnScnrNo = null;
	/* Column Info */
	private String saqStsCd = null;
	/* Column Info */
	private String f_cmd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String cmAmt = null;
	/* Column Info */
	private String opfitAmt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String maxLod = null;
	/* Column Info */
	private String minLod = null;
	/* Column Info */
	private String sts00 = null;
	/* Column Info */
	private String stsOthers = null;
	/* Column Info */
	private String inclPortFlag = null;
	/* Column Info */
	private String mqtaMdlVerNo = null;
	/* Column Info */
	private String bseQtrCd = null;
	
	String targetGroup = null;	
	private FormCommand fcmd;	
	
	/* Column Info */
	private String kamer_id = null;
	/* Column Info */
	private String ctrtRhqCd = null;
	/* Column Info */
	private String ctrtRgnOfcCd = null;
	/* Column Info */
	private String comboVersion = null;
	
	/*
	 *  add start By ChungEunHo 09.09.15
	 */
	
	// 0042 ADD
	private String lane = null;
	private String tradeGroup = null;
	private String editMode = null;
	private String calc1 = null;
	private String calc2 = null;
	private String tabIdx = null;
	private String yqtaStepCd = null; 
	// 168 ADD
	private String yqta_step_cd		= null; 
	private String yqta_ver_no		= null;  
	private String ofcTpCd        	= null;
	// 081 ADD
	private String custGrp		    = null;
	private String sub_trade		= null;
	private String keyAcctMgrUsrId	= null;
	
	// 155 ADD
	
	private String ystepCd			= null;
	
	// 054 ADD
	
	private String detTrade			= null;
	private String detBound			= null;
	private String detCRHQ			= null;
	
	// 111 ADD
	
	private String rlane_cd			= null;
	private String ofc_cd			= null;
	
	// 169 ADD
	
	private String yqta_rlse_ver_no = null;
	private String is_new_version = null;
	private String yqtaRlseVerNo = null;
	
	// add end By ChungEunHo 09.09.15

	/* Column Info */
	private String mqtaRlseVerNo = null;	
	/* Column Info */
	private String bseYr = null;
	/* Column Info */	
	private String bseMon = null;	
	/* Column Info */	
	private String fmBseWk = null;
	/* Column Info */	
	private String toBseWk = null;
	/* Column Info */	
	private String ofcOfcCd = null;	
	/* Column Info */	
	private String trdCd = null;
	/* Column Info */	
	private String rbQtaTgtCd = null;
	/* Column Info */	
	private String grsRpbRev = null;
	/* Column Info */	
	private String cm = null;
	/* Column Info */	
	private String cfmSts = null;
	/* Column Info */	
	private String qtaTgtCd = null;	
	private String newVersionNo = null;
	
	private String selType = null;
	/* Column Info */	
	private String month = null;
	/* Column Info */
	private String items0 = null;
	/* Column Info */
	private String ilist = null;
	
	
	/* Column Info */
	private String isRhq = null;
	/* Column Info */
	private String SubTrdCd = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String from_wk = null;
	/* Column Info */
	private String to_wk = null;
	/* Column Info */
	private String orgType = null;
 
	//0083	멤버변수	                                                                                                      
	private String tgtOrzCd = null;
	private String slsRhqCd = null;
	
	//0163
	private String copyBseQtrCd = null;
	private String condStsCd = null;
	private String copyBseYr = null;
	
	//0048, 0075
	private String bse_qtr_cd        = null;
	private String bse_quarter       = null;
	private String bse_yr            = null;
	private String chkCommand        = null;
	private String condStepCd        = null;
	private String creUsrId          = null;
	private String ctrt_rhq_cd       = null;
	private String currMqtaStepCd    = null;
	private String deltFlg           = null;
	private String dir_cd            = null;
	private String edit_mode         = null;
	private String glineVerNo        = null;
	private String gline_ver_no      = null;
	private String mQtaStepCd        = null;
	private String mQtaVerNo         = null;
	private String mqta_step_cd      = null;
	private String mqta_ver_no       = null;
	private String newStatusCd       = null;
	private String newStepCd         = null;
	private String newVersion        = null;
	private String ofc_Cd            = null;
	private String pfmc_fr_month     = null;
	private String pfmc_fr_year      = null;
	private String pfmc_to_month     = null;
	private String pfmc_to_year      = null;
	private String rhq_cd            = null;
	private String zeroList          = null;
	private String saveList          = null;
	private String qtaMstVerNo       = null;
	private String saq_sts_cd        = null;
	private String search_rlane_cd   = null;
	private String search_sub_trd_cd = null;
	private String statusCd          = null;
	private String targetMonth       = null;
	private String tradeGroupCd      = null;
	private String trade_group       = null;
	private String trd_cd            = null;
	private String unit_tp           = null;
	private String updUsrId          = null;
	private String org               = null;
	private String slsRgnOfcCd       = null;
	private String sls_rhq_cd        = null;
	private String search_step       = null;
	private String newQtaTgtCd       = null;
	
	//0098
	private String startLevel		= null;
	private String endLevel			= null;
	private String detCAQ      = null;
	private String detCOfc     = null;
	private String detSubTrade = null;
	private String detLane     = null;
	private String detLRHQ     = null;
	private String detLAQ      = null;
	private String detLOfc     = null;
	private String mstVersion  = null;
	private String datCreStepCd= null;

	private String vvd= null;
	private String group= null;
	private String addTpCd = null;
	private String changeType = null;
	private String changeMode = null;
	private String newRlaneCd = null;
	private String add_tp_cd= null;
	
	//0116
	private String sprtGrpCd= null;
	private String bsaGrpCd= null;
	private String tblGbn= null;
	private String bseMon2= null;

	//0167
	private String aq_cd= null;	
	private String new_rlane_cd= null;
	
	private String creOfcCd  = null;
	private String rgnOfcCd2 = null;
	private String polCd     = null;
	private String podCd     = null;
	
	private String custNm    = null;
	
	//0181
	private String from_mon  = null;
	private String to_mon    = null;
	
	//0187
	private String yQtaStepCd = null;
	private String yQtaVerNo = null;
	
	//0181
	public String getFrom_mon()         {	return from_mon;}
	public String getTo_mon()           {	return to_mon;}
	
	//0048, 0075
	public String getBse_qtr_cd()        {	return bse_qtr_cd;}
	public String getBse_quarter()       {	return bse_quarter;}
	public String getBse_yr()            {	return bse_yr;}
	public String getChkCommand()        {	return chkCommand;}
	public String getCondStepCd()        {	return condStepCd;}
	public String getCreUsrId()          {	return creUsrId;}
	public String getCtrt_rhq_cd()       {	return ctrt_rhq_cd;}
	public String getCurrMqtaStepCd()    {	return currMqtaStepCd;}
	public String getDeltFlg()           {	return deltFlg;}
	public String getDir_cd()            {	return dir_cd;}
	public String getEdit_mode()         {	return edit_mode;}
	public String getGlineVerNo()        {	return glineVerNo;}
	public String getGline_ver_no()      {	return gline_ver_no;}
	public String getMQtaStepCd()        {	return mQtaStepCd;}
	public String getMQtaVerNo()         {	return mQtaVerNo;}
	public String getMqta_step_cd()      {	return mqta_step_cd;}
	public String getMqta_ver_no()       {	return mqta_ver_no;}
	public String getNewStatusCd()       {	return newStatusCd;}
	public String getNewStepCd()         {	return newStepCd;}
	public String getNewVersion()        {	return newVersion;}
	public String getOfc_Cd()            {	return ofc_Cd;}
	public String getPfmc_fr_month()     {	return pfmc_fr_month;}
	public String getPfmc_fr_year()      {	return pfmc_fr_year;}
	public String getPfmc_to_month()     {	return pfmc_to_month;}
	public String getPfmc_to_year()      {	return pfmc_to_year;}
	public String getQtaMstVerNo()       {	return qtaMstVerNo;}
	public String getSaq_sts_cd()        {	return saq_sts_cd;}
	public String getSearch_rlane_cd()   {	return search_rlane_cd;}
	public String getSearch_sub_trd_cd() {	return search_sub_trd_cd;}
	public String getStatusCd()          {	return statusCd;}
	public String getTargetMonth()       {	return targetMonth;}
	public String getTradeGroupCd()	     {	return tradeGroupCd;}
	public String getTrade_group() 	     {	return trade_group;}
	public String getTrd_cd() 	         {	return trd_cd;}
	public String getUnit_tp() 	         {	return unit_tp;}
	public String getUpdUsrId() 	     {	return updUsrId;}
	public String getRhq_cd()            {	return rhq_cd;}
	public String getZeroList()          {  return zeroList;}
	public String getSaveList()          {  return saveList;}
	public String getSearch_step()       {  return search_step;}
	public String getSlsRgnOfcCd()       {  return slsRgnOfcCd;}
	public String getSls_rhq_cd()        {  return sls_rhq_cd;}
	public String getNewQtaTgtCd()       {  return newQtaTgtCd;}
	//0167
	public String getAq_Cd()       		 {  return aq_cd;}	
	public String getNew_Rlane_Cd()      {  return new_rlane_cd;}
	
	//0181
	public void setFrom_mon(String from_mon)       				 {  this.from_mon = from_mon;}
	public void setTo_mon(String to_mon)       					 {  this.to_mon = to_mon;}
	
	//0048, 0075
	public void setSaveList(String saveList)                     {   this.saveList = saveList;}
	public void setZeroList(String zeroList)                     {   this.zeroList = zeroList;}
	public void setBse_qtr_cd(String bse_qtr_cd) 		         {	this.bse_qtr_cd = bse_qtr_cd;}
	public void setBse_quarter(String bse_quarter) 		         {	this.bse_quarter = bse_quarter;}
	public void setBse_yr(String bse_yr) 				         {	this.bse_yr = bse_yr;}
	public void setChkCommand(String chkCommand) 		         {	this.chkCommand = chkCommand;}
	public void setCondStepCd(String condStepCd)		         {	this.condStepCd = condStepCd;}
	public void setCreUsrId(String creUsrId) 			         {	this.creUsrId = creUsrId;}
	public void setCtrt_rhq_cd(String ctrt_rhq_cd) 		         {	this.ctrt_rhq_cd = ctrt_rhq_cd;}
	public void setCurrMqtaStepCd(String currMqtaStepCd)         {	this.currMqtaStepCd = currMqtaStepCd;}
	public void setDeltFlg(String deltFlg) 				         {	this.deltFlg = deltFlg;}
	public void setDir_cd(String dir_cd) 				         {	this.dir_cd = dir_cd;}
	public void setEdit_mode(String edit_mode)			         {	this.edit_mode = edit_mode;}
	public void setGlineVerNo(String glineVerNo)		         {	this.glineVerNo = glineVerNo;}
	public void setGline_ver_no(String gline_ver_no)	         {	this.gline_ver_no = gline_ver_no;}
	public void setMQtaStepCd(String mqtaStepCd)			     {	this.mQtaStepCd = mqtaStepCd;}
	public void setMQtaVerNo(String mqtaVerNo)			         {	this.mQtaVerNo = mqtaVerNo;}
	public void setMqta_step_cd(String mqta_step_cd)	         {	this.mqta_step_cd = mqta_step_cd;}
	public void setMqta_ver_no(String mqta_ver_no)		         {	this.mqta_ver_no = mqta_ver_no;}
	public void setNewStatusCd(String newStatusCd)		         {	this.newStatusCd = newStatusCd;}
	public void setNewStepCd(String newStepCd)			 		 {	this.newStepCd = newStepCd;}
	public void setNewVersion(String newVersion)		         {	this.newVersion = newVersion;}
	public void setOfc_Cd(String ofc_Cd)				 		 {	this.ofc_Cd = ofc_Cd;}
	public void setPfmc_fr_month(String pfmc_fr_month)	         {	this.pfmc_fr_month = pfmc_fr_month;}
	public void setPfmc_fr_year(String pfmc_fr_year)	         {	this.pfmc_fr_year = pfmc_fr_year;}
	public void setPfmc_to_month(String pfmc_to_month)	         {	this.pfmc_to_month = pfmc_to_month;}
	public void setPfmc_to_year(String pfmc_to_year)	         {	this.pfmc_to_year = pfmc_to_year;}
	public void setQtaMstVerNo(String qtaMstVerNo)		         {	this.qtaMstVerNo = qtaMstVerNo;}
	public void setSaq_sts_cd(String saq_sts_cd)		         {	this.saq_sts_cd = saq_sts_cd;}
	public void setSearch_rlane_cd(String search_rlane_cd)		 {	this.search_rlane_cd = search_rlane_cd;}
	public void setSearch_sub_trd_cd(String search_sub_trd_cd) 	 {	this.search_sub_trd_cd = search_sub_trd_cd;}
	public void setStatusCd(String statusCd)			         {	this.statusCd = statusCd;}
	public void setTargetMonth(String targetMonth)			     {	this.targetMonth = targetMonth;}
	public void setTradeGroupCd(String tradeGroupCd)		     {	this.tradeGroupCd = tradeGroupCd;}
	public void setTrade_group(String trade_group)			     {	this.trade_group = trade_group;}
	public void setTrd_cd(String trd_cd)				         {	this.trd_cd = trd_cd;}
	public void setUnit_tp(String unit_tp)				         {	this.unit_tp = unit_tp;}
	public void setUpdUsrId(String updUsrId)			         {	this.updUsrId = updUsrId;}
	public void setRhq_cd(String rhq_cd)                         {	this.rhq_cd = rhq_cd;}
	public void setSearch_step(String search_step)               {  this.search_step = search_step;}
	public void setSlsRgnOfcCd(String slsRgnOfcCd)               {  this.slsRgnOfcCd = slsRgnOfcCd;}
	public void setSls_rhq_cd(String sls_rhq_cd)                 {  this.sls_rhq_cd = sls_rhq_cd;}
	public void setNewQtaTgtCd(String newQtaTgtCd)               {  this.newQtaTgtCd = newQtaTgtCd;}
	
	public void setAq_Cd(String aq_cd)              			 {  this.aq_cd = aq_cd;}	
	public void setNew_Rlane_Cd(String new_rlane_cd)              	     {  this.new_rlane_cd = new_rlane_cd;}
	                                            
	//0083		                                                                                                      
	public String getTgtOrzCd		(){	return tgtOrzCd	 	;}                                                
	public String getSlsRhqCd		(){	return slsRhqCd	 	;}     
	
	//0083
	public void setTgtOrzCd	 		(String tgtOrzCd			) {this.tgtOrzCd			= tgtOrzCd		;}
	public void setSlsRhqCd		 	(String slsRhqCd			) {this.slsRhqCd			= slsRhqCd		;}

	//0098
	public String getStartLevel	(){	return startLevel		;}     
	public String getEndLevel	(){	return endLevel			;}     
	public String getDetCAQ     (){	return detCAQ     		;}     
	public String getDetCOfc    (){	return detCOfc    		;}     
	public String getDetSubTrade(){	return detSubTrade		;}     
	public String getDetLane    (){	return detLane    		;}     
	public String getDetLRHQ    (){	return detLRHQ    		;}     
	public String getDetLAQ     (){	return detLAQ     		;}     
	public String getDetLOfc    (){	return detLOfc    		;}     
	
	//0098
	public void setStartLevel (String startLevel ) {this.startLevel	= startLevel ;}
	public void setEndLevel	  (String endLevel	 ) {this.endLevel	= endLevel	 ;}
	public void setDetCAQ     (String detCAQ     ) {this.detCAQ     = detCAQ     ;}
	public void setDetCOfc    (String detCOfc    ) {this.detCOfc    = detCOfc    ;}
	public void setDetSubTrade(String detSubTrade) {this.detSubTrade= detSubTrade;}
	public void setDetLane    (String detLane    ) {this.detLane    = detLane    ;}
	public void setDetLRHQ    (String detLRHQ    ) {this.detLRHQ    = detLRHQ    ;}
	public void setDetLAQ     (String detLAQ     ) {this.detLAQ     = detLAQ     ;}
	public void setDetLOfc    (String detLOfc    ) {this.detLOfc    = detLOfc    ;}

	
	public void setVvd(String vvd)                 {  this.vvd = vvd;}
	public void setGroup(String group)               {  this.group = group;}
	                                            
	//0083		                                                                                                      
	public String getVvd		(){	return vvd	 	;}                                                
	public String getGroup		(){	return group	 	;}     
	
	public String getAddTpCd()    {return addTpCd;}
	public String getChangeType() {return changeType;}
	public String getChangeMode() {return changeMode;}
	public String getNewRlaneCd() {return newRlaneCd;}
	public String getAdd_tp_cd()  {return add_tp_cd;}
	
	public void setAddTpCd(String addTpCd)       {this.addTpCd = addTpCd;}
	public void setChangeType(String changeType) {this.changeType = changeType;}
	public void setChangeMode(String changeMode) {this.changeMode = changeMode;}
	public void setNewRlaneCd(String newRlaneCd) {this.newRlaneCd = newRlaneCd;}
	public void setAdd_tp_cd(String add_tp_cd)   {this.add_tp_cd = add_tp_cd;}
	
	//0187
	public String getYQtaStepCd()                {	return yQtaStepCd;}
	public void setYQtaStepCd(String yqtaStepCd) {	this.yQtaStepCd = yqtaStepCd;}
	public String getYQtaVerNo()                {	return yQtaVerNo;}
	public void setYQtaVerNo(String yQtaVerNo) {	this.yQtaVerNo = yQtaVerNo;}
	
	public String getSprtGrpCd() {
		return sprtGrpCd;
	}
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
	}
	public String getBsaGrpCd() {
		return bsaGrpCd;
	}
	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}
	public String getTblGbn() {
		return tblGbn;
	}
	public void setTblGbn(String tblGbn) {
		this.tblGbn = tblGbn;
	}
	public String getMstVersion() {
		return mstVersion;
	}
	public void setMstVersion(String mstVersion) {
		this.mstVersion = mstVersion;
	}
	public String getDatCreStepCd() {
		return datCreStepCd;
	}
	public void setDatCreStepCd(String datCreStepCd) {
		this.datCreStepCd = datCreStepCd;
	}
	public String getNewVersionNo() {
		return newVersionNo;
	}
	public void setNewVersionNo(String newVersionNo) {
		this.newVersionNo = newVersionNo;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getSubTrdCd() {
		return SubTrdCd;
	}

	public void setSubTrdCd(String subTrdCd) {
		SubTrdCd = subTrdCd;
	}

	public String getSelType() {
		return selType;
	}

	public void setSelType(String selType) {
		this.selType = selType;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getItems0() {
		return items0;
	}

	public void setItems0(String items0) {
		this.items0 = items0;
	}

	public String getIlist() {
		return ilist;
	}

	public void setIlist(String ilist) {
		this.ilist = ilist;
	}

	public String getIsRhq() {
		return isRhq;
	}

	public void setIsRhq(String isRhq) {
		this.isRhq = isRhq;
	}

	public String getAqCd() {
		return aqCd;
	}

	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}

	public String getFrom_wk() {
		return from_wk;
	}

	public void setFrom_wk(String from_wk) {
		this.from_wk = from_wk;
	}

	public String getTo_wk() {
		return to_wk;
	}

	public void setTo_wk(String to_wk) {
		this.to_wk = to_wk;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public FormCommand getFormCommand() {
		return fcmd;
	}

	public void setFormCommand(FormCommand fcmd) {
		this.fcmd = fcmd;
	}	
	
	public String getTargetGroup() {
		return targetGroup;
	}

	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}	
	
	
	public String getSlsFcastPubNo() {
		return slsFcastPubNo;
	}

	public void setSlsFcastPubNo(String slsFcastPubNo) {
		this.slsFcastPubNo = slsFcastPubNo;
	}

	public String getStsCd() {
		return stsCd;
	}

	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}

	public String getFmStep() {
		return fmStep;
	}

	public void setFmStep(String fmStep) {
		this.fmStep = fmStep;
	}

	public String getToStep() {
		return toStep;
	}

	public void setToStep(String toStep) {
		this.toStep = toStep;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getSlsAqCd() {
		return slsAqCd;
	}

	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
	}

	public String getCtrtAqCd() {
		return ctrtAqCd;
	}

	public void setCtrtAqCd(String ctrtAqCd) {
		this.ctrtAqCd = ctrtAqCd;
	}

	public String getTargetGrpChild() {
		return targetGrpChild;
	}

	public void setTargetGrpChild(String targetGrpChild) {
		this.targetGrpChild = targetGrpChild;
	}

	public String getTradeChild() {
		return tradeChild;
	}

	public void setTradeChild(String tradeChild) {
		this.tradeChild = tradeChild;
	}

	public String getRhqCd() {
		return rhqCd;
	}

	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

	public String getRlaneCd() {
		return rlaneCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

/*	public String getDummyField() {
		return dummyField;
	}

	public void setDummyField(String dummyField) {
		this.dummyField = dummyField;
	}*/

	public String getTargetGrp() {
		return targetGrp;
	}

	public void setTargetGrp(String targetGrp) {
		this.targetGrp = targetGrp;
	}

	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	public String getSlsOfcCd() {
		return slsOfcCd;
	}

	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}

	public String getDirCd() {
		return dirCd;
	}

	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}

	public String getRgnOfcCd() {
		return rgnOfcCd;
	}

	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}

	public String getDirCdChild() {
		return dirCdChild;
	}

	public void setDirCdChild(String dirCdChild) {
		this.dirCdChild = dirCdChild;
	}


	

	public Collection<QuotaConditionVO> getModels() {
		return models;
	}

	public void setModels(Collection<QuotaConditionVO> models) {
		this.models = models;
	}



	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}



	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}


	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public String getBseMon2() {
		return bseMon2;
	}
	public void setBseMon2(String bseMon2) {
		this.bseMon2 = bseMon2;
	}
	
	
	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
	}


	public String getSubTrade() {
		return subTrade;
	}

	public void setSubTrade(String subTrade) {
		this.subTrade = subTrade;
	}
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public String getQuarter() {
		return this.quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getGrpFlg() {
		return this.grp_flg;
	}
	public void setGrpFlg(String grp_flg) {
		this.grp_flg = grp_flg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRepTrade() {
		return repTrade;
	}
	public void setRepTrade(String repTrade) {
		this.repTrade = repTrade;
	}
	
	public String getYqtaVerNo() {
		return yqtaVerNo;
	}

	public void setYqtaVerNo(String yqtaVerNo) {
		this.yqtaVerNo = yqtaVerNo;
	}	

	public String getLoginOfcCd() {
		return loginOfcCd;
	}

	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
	}
	
	
	public String getIsZeroLoad() {
		return isZeroLoad;
	}
	
	public void setIsZeroLoad(String isZeroLoad) {
		this.isZeroLoad = isZeroLoad;
	}	
	
	public String getRepMonth() {
		return repMonth;
	}

	public void setRepMonth(String repMonth) {
		this.repMonth = repMonth;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	/**
	 * sheet_check 멤버변수의 getter method
	 * 
	 * @return String 
	 */
	public String getSheetCheck() {
		return sheet_check;
	}	
	/**
	 * sheet_check 멤버변수의 setter method
	 * 
	 * @param sheet_check 
	 */
	public void setSheetCheck(String sheet_check) {
		this.sheet_check = sheet_check;
	}	
	
	public String getYqtaMdlVerNo() {
		return yqtaMdlVerNo;
	}

	public void setYqtaMdlVerNo(String yqtaMdlVerNo) {
		this.yqtaMdlVerNo = yqtaMdlVerNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getPlnScnrNo() {
		return plnScnrNo;
	}

	public void setPlnScnrNo(String plnScnrNo) {
		this.plnScnrNo = plnScnrNo;
	}

	public String getSaqStsCd() {
		return saqStsCd;
	}

	public void setSaqStsCd(String saqStsCd) {
		this.saqStsCd = saqStsCd;
	}

	public String getFcmd() {
		return f_cmd;
	}

	public void setFcmd(String f_cmd) {
		this.f_cmd = f_cmd;
	}

	public String getLodQty() {
		return lodQty;
	}

	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}

	public String getGrsRev() {
		return grsRev;
	}

	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}

	public String getCmAmt() {
		return cmAmt;
	}

	public void setCmAmt(String cmAmt) {
		this.cmAmt = cmAmt;
	}

	public String getOpfitAmt() {
		return opfitAmt;
	}

	public void setOpfitAmt(String opfitAmt) {
		this.opfitAmt = opfitAmt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMaxLod() {
		return maxLod;
	}

	public void setMaxLod(String maxLod) {
		this.maxLod = maxLod;
	}

	public String getMinLod() {
		return minLod;
	}

	public void setMinLod(String minLod) {
		this.minLod = minLod;
	}

	public String getSts00() {
		return sts00;
	}

	public void setSts00(String sts00) {
		this.sts00 = sts00;
	}

	public String getStsOthers() {
		return stsOthers;
	}

	public void setStsOthers(String stsOthers) {
		this.stsOthers = stsOthers;
	}


	public String getInclPortFlag() {
		return inclPortFlag;
	}

	public void setInclPortFlag(String inclPortFlag) {
		this.inclPortFlag = inclPortFlag;
	}

	public String getMqtaMdlVerNo() {
		return mqtaMdlVerNo;
	}

	public void setMqtaMdlVerNo(String mqtaMdlVerNo) {
		this.mqtaMdlVerNo = mqtaMdlVerNo;
	}

	public String getBseQtrCd() {
		return bseQtrCd;
	}

	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	
	public String getKamer_id() {
		return kamer_id;
	}

	public void setKamer_id(String kamer_id) {
		this.kamer_id = kamer_id;
	}


	public String getCtrtRhqCd() {
		return ctrtRhqCd;
	}

	public void setCtrtRhqCd(String ctrtRhqCd) {
		this.ctrtRhqCd = ctrtRhqCd;
	}

	public String getCtrtRgnOfcCd() {
		return ctrtRgnOfcCd;
	}

	public void setCtrtRgnOfcCd(String ctrtRgnOfcCd) {
		this.ctrtRgnOfcCd = ctrtRgnOfcCd;
	}
	
	public String getComboVersion() {
		return comboVersion;
	}

	public void setComboVersion(String comboVersion) {
		this.comboVersion = comboVersion;
	}
	

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getTradeGroup() {
		return tradeGroup;
	}

	public void setTradeGroup(String tradeGroup) {
		this.tradeGroup = tradeGroup;
	}

	public String getEditMode() {
		return editMode;
	}

	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}

	public String getCalc1() {
		return calc1;
	}

	public void setCalc1(String calc1) {
		this.calc1 = calc1;
	}

	public String getCalc2() {
		return calc2;
	}

	public void setCalc2(String calc2) {
		this.calc2 = calc2;
	}

	public String getYqtaStepCd() {
		return yqtaStepCd;
	}

	public void setYqtaStepCd(String yqtaStepCd) {
		this.yqtaStepCd = yqtaStepCd;
	}

	public String getTabIdx() {
		return tabIdx;
	}

	public void setTabIdx(String tabIdx) {
		this.tabIdx = tabIdx;
	}

	
	
	public String getMqtaRlseVerNo() {
		return mqtaRlseVerNo;
	}

	public void setMqtaRlseVerNo(String mqtaRlseVerNo) {
		this.mqtaRlseVerNo = mqtaRlseVerNo;
	}

	public String getBseYr() {
		return bseYr;
	}

	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}

	public String getBseMon() {
		return bseMon;
	}

	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}

	public String getFmBseWk() {
		return fmBseWk;
	}

	public void setFmBseWk(String fmBseWk) {
		this.fmBseWk = fmBseWk;
	}

	public String getToBseWk() {
		return toBseWk;
	}

	public void setToBseWk(String toBseWk) {
		this.toBseWk = toBseWk;
	}

	public String getOfcOfcCd() {
		return ofcOfcCd;
	}

	public void setOfcOfcCd(String ofcOfcCd) {
		this.ofcOfcCd = ofcOfcCd;
	}

	public String getTrdCd() {
		return trdCd;
	}

	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	public String getRbQtaTgtCd() {
		return rbQtaTgtCd;
	}

	public void setRbQtaTgtCd(String rbQtaTgtCd) {
		this.rbQtaTgtCd = rbQtaTgtCd;
	}

	public String getGrsRpbRev() {
		return grsRpbRev;
	}

	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public String getCfmSts() {
		return cfmSts;
	}

	public void setCfmSts(String cfmSts) {
		this.cfmSts = cfmSts;
	}

	public String getQtaTgtCd() {
		return qtaTgtCd;
	}

	public void setQtaTgtCd(String qtaTgtCd) {
		this.qtaTgtCd = qtaTgtCd;
	}
	public String getYqta_step_cd() {
		return yqta_step_cd;
	}

	public void setYqta_step_cd(String yqta_step_cd) {
		this.yqta_step_cd = yqta_step_cd;
	}

	
	public String getYqta_ver_no() {
		return yqta_ver_no;
	}

	public void setYqta_ver_no(String yqta_ver_no) {
		this.yqta_ver_no = yqta_ver_no;
	}

	public String getOfcTpCd() {
		return ofcTpCd;
	}

	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}

	/**
	 * Column Info
	 * @return copyBseQtrCd
	 */
	public String getCopyBseQtrCd() {
		return this.copyBseQtrCd;
	}
	/**
	 * Column Info
	 * @return condStsCd
	 */
	public String getCondStsCd() {
		return this.condStsCd;
	}
	
	/**
	 * Column Info
	 * @return copyBseYr
	 */
	public String getCopyBseYr() {
		return this.copyBseYr;
	}
	
	/**
	 * Column Info
	 * @param copyBseQtrCd
	 */
	public void setCopyBseQtrCd(String copyBseQtrCd) {
		this.copyBseQtrCd = copyBseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param condStsCd
	 */
	public void setCondStsCd(String condStsCd) {
		this.condStsCd = condStsCd;
	}
	
	/**
	 * Column Info
	 * @param copyBseYr
	 */
	public void setCopyBseYr(String copyBseYr) {
		this.copyBseYr = copyBseYr;
	}
	

	public String getCustGrp() {
		return custGrp;
	}
	public void setCustGrp(String custGrp) {
		this.custGrp = custGrp;
	}
	public String getSub_trade() {
		return sub_trade;
	}
	public void setSub_trade(String sub_trade) {
		this.sub_trade = sub_trade;
	}
	public String getKeyAcctMgrUsrId() {
		return keyAcctMgrUsrId;
	}
	public void setKeyAcctMgrUsrId(String keyAcctMgrUsrId) {
		this.keyAcctMgrUsrId = keyAcctMgrUsrId;
	}

	public String getYstepCd() {
		return ystepCd;
	}
	public void setYstepCd(String ystepCd) {
		this.ystepCd = ystepCd;
	}
	
	public String getRlane_cd() {
		return rlane_cd;
	}
	public void setRlane_cd(String rlane_cd) {
		this.rlane_cd = rlane_cd;
	}
	
	public String getOfc_cd() {
		return ofc_cd;
	}
	public void setOfc_cd(String ofc_cd) {
		this.ofc_cd = ofc_cd;
	}
	/**
	 * @return the yqta_rlse_ver_no
	 */
	public String getYqta_rlse_ver_no() {
		return yqta_rlse_ver_no;
	}
	/**
	 * @param yqta_rlse_ver_no the yqta_rlse_ver_no to set
	 */
	public void setYqta_rlse_ver_no(String yqta_rlse_ver_no) {
		this.yqta_rlse_ver_no = yqta_rlse_ver_no;
	}

	public String getIsNewVersion() {
		return is_new_version;
	}
	public void setIsNewVersion(String is_new_version) {
		this.is_new_version = is_new_version;
	}
	public String getYqtaRlseVerNo() {
		return yqtaRlseVerNo;
	}
	public void setYqtaRlseVerNo(String yqtaRlseVerNo) {
		this.yqtaRlseVerNo = yqtaRlseVerNo;
	}


	public String getDetTrade() {
		return detTrade;
	}
	public void setDetTrade(String detTrade) {
		this.detTrade = detTrade;
	}
	public String getDetBound() {
		return detBound;
	}
	public void setDetBound(String detBound) {
		this.detBound = detBound;
	}
	public String getDetCRHQ() {
		return detCRHQ;
	}
	public void setDetCRHQ(String detCRHQ) {
		this.detCRHQ = detCRHQ;
	}
	
	public String getCreOfcCd(){
		return creOfcCd;
	}
	public void setCreOfcCd(String creOfcCd){
		this.creOfcCd = creOfcCd;
	}
	public String getRgnOfcCd2(){
		return rgnOfcCd2;
	}
	public void setRgnOfcCd2(String rgnOfcCd2){
		this.rgnOfcCd2 = rgnOfcCd2;
	}
	public String getPolCd(){
		return polCd;
	}
	public void setPolCd(String polCd){
		this.polCd = polCd;
	}
	public String getPodCd(){
		return podCd;
	}
	public void setPodCd(String podCd){
		this.podCd = podCd;
	}
	
	public String getCustNm() {
		return custNm;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public QuotaConditionVO() {}

	public QuotaConditionVO(String ibflag, String pagerows, String periodYr1, String periodWk1, String periodYr2, String periodWk2, String contractOffice, String customerCo, String customerCd, String lane, String bound, String salesOffice, String polCd, String approvalCondStatus) {
		this.pagerows = pagerows;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slsAqCd"			, getSlsAqCd()		);
		this.hashColumns.put("ctrtAqCd"			, getCtrtAqCd()		);
		this.hashColumns.put("targetGrpChild"	, getTargetGrpChild());
		this.hashColumns.put("tradeChild"		, getTradeChild()	);
		this.hashColumns.put("rhqCd"			, getRhqCd()		);
		this.hashColumns.put("trade"			, getTrade()		);
		this.hashColumns.put("rlaneCd"			, getRlaneCd()		);
		this.hashColumns.put("pagerows"			, getPagerows()		);
		this.hashColumns.put("targetGrp"		, getTargetGrp()	);
		this.hashColumns.put("version"			, getVersion()		);
		this.hashColumns.put("unit"				, getUnit()			);
		this.hashColumns.put("ibflag"			, getIbflag()		);
		this.hashColumns.put("ctrtOfcCd"		, getCtrtOfcCd()	);
		this.hashColumns.put("slsOfcCd"			, getSlsOfcCd()		);
		this.hashColumns.put("item"				, getItem()			);
		this.hashColumns.put("subTrade"			, getSubTrade()		);
		this.hashColumns.put("year"				, getYear()			);
		this.hashColumns.put("dirCd"			, getDirCd()		);
		this.hashColumns.put("rgnOfcCd"			, getRgnOfcCd()		);
		this.hashColumns.put("dirCdChild"		, getDirCdChild()	);			
		this.hashColumns.put("bound"			, getBound()		);			
		this.hashColumns.put("quarter"			, getQuarter()		);
		this.hashColumns.put("intervalTime"		, getIntervalTime()	); //0047 searchlist02 용
		this.hashColumns.put("grp_flg"			, getGrpFlg()		);
		this.hashColumns.put("type"				, getType()			);
		this.hashColumns.put("step"				, getStep()			);
		this.hashColumns.put("sts"				, getSts()			);
		this.hashColumns.put("period"			, getPeriod()		);
		this.hashColumns.put("rep_trade"		, getRepTrade()	);
		this.hashColumns.put("yqta_ver_no"		, getYqtaVerNo()	);
		this.hashColumns.put("login_ofc_cd"		, getLoginOfcCd()	);
		this.hashColumns.put("sheet_check"		, getSheetCheck()	);
		this.hashColumns.put("isZeroLoad"		, getIsZeroLoad()	);
		this.hashColumns.put("target_grp"		, getTargetGrp()	);
		this.hashColumns.put("sub_trade"		, getSubTrade()		);
		this.hashColumns.put("dir_cd"			, getDirCd()		);
		this.hashColumns.put("sls_fcast_pub_no"	, getSlsFcastPubNo());
		this.hashColumns.put("yqta_mdl_ver_no"	, getYqtaMdlVerNo()	);
		this.hashColumns.put("ofc_cd"			, getOfcCd()		);
		this.hashColumns.put("pln_scnr_no"		, getPlnScnrNo()	);
		this.hashColumns.put("saq_sts_cd"		, getSaqStsCd()		);
		this.hashColumns.put("f_cmd"			, getFcmd()			);
		this.hashColumns.put("lod_qty"			, getLodQty()		);
		this.hashColumns.put("grs_rev"			, getGrsRev()		);
		this.hashColumns.put("cm_amt"			, getCmAmt()		);
		this.hashColumns.put("opfit_amt"		, getOpfitAmt()		);
		this.hashColumns.put("user_id"			, getUserId()		);
		this.hashColumns.put("max_lod"			, getMaxLod()		);
		this.hashColumns.put("min_lod"			, getMinLod()		);
		this.hashColumns.put("sts00"			, getSts00()		);
		this.hashColumns.put("sts_others"		, getStsOthers()	);
		this.hashColumns.put("incl_port_flag"	, getInclPortFlag()	);
		this.hashColumns.put("mqta_mdl_ver_no"	, getMqtaMdlVerNo()	);
		this.hashColumns.put("bse_qtr_cd"		, getBseQtrCd()		);
		this.hashColumns.put("targetGroup"		, getTargetGroup()	);	
		this.hashColumns.put("kamer_id"			, getKamer_id()		);	
		this.hashColumns.put("ctrtRhqCd"		, getCtrtRhqCd()	);	
		this.hashColumns.put("ctrtRgnOfcCd"		, getCtrtRgnOfcCd()	);	
		this.hashColumns.put("combo_version"	, getComboVersion()	);	
		this.hashColumns.put("lane"				, getLane()	);	
		this.hashColumns.put("trade_group"		, getTradeGroup()	);	
		this.hashColumns.put("edit_mode"		, getEditMode()	);	
		this.hashColumns.put("calc1"			, getCalc1()	);	
		this.hashColumns.put("calc2"			, getCalc2()	);	
		this.hashColumns.put("tab_idx"			, getTabIdx()	);	
		this.hashColumns.put("yqta_step_cd"		, getYqtaStepCd()	);	

		this.hashColumns.put("mqtaRlseVerNo"    , getMqtaRlseVerNo()); 
		this.hashColumns.put("bseYr"            , getBseYr()        ); 	      
		this.hashColumns.put("bseMon"           , getBseMon()       ); 	      
		this.hashColumns.put("fmBseWk"          , getFmBseWk()      ); 	  
		this.hashColumns.put("toBseWk"          , getToBseWk()      ); 	  
		this.hashColumns.put("ofcOfcCd"         , getOfcOfcCd()     ); 	  
		this.hashColumns.put("trdCd"            , getTrdCd()        ); 	      
		this.hashColumns.put("rbQtaTgtCd"       , getRbQtaTgtCd()   ); 	  
		this.hashColumns.put("grsRpbRev"        , getGrsRpbRev()    ); 	  
		this.hashColumns.put("cm"               , getCm()           ); 	          
		this.hashColumns.put("cfmSts"           , getCfmSts()       ); 	      
		this.hashColumns.put("qtaTgtCd"         , getQtaTgtCd()     ); 		
		this.hashColumns.put("ofcCd"			, getOfcCd()		);	
		
		this.hashColumns.put("selType", getSelType());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("items0", getItems0());
		this.hashColumns.put("ilist", getIlist());
		this.hashColumns.put("isRhq", getIsRhq());
		this.hashColumns.put("subTrdCd", getSubTrdCd());
		this.hashColumns.put("aqCd", getAqCd());
		this.hashColumns.put("from_wk", getFrom_wk());
		this.hashColumns.put("to_wk", getTo_wk());
		this.hashColumns.put("orgType", getOrgType());

		//0083
		this.hashColumns.put("tgtOrzCd",getTgtOrzCd());
		this.hashColumns.put("slsRhqCd",getSlsRhqCd());		
		
		//0163
		this.hashColumns.put("copy_bse_qtr_cd", getCopyBseQtrCd());
		this.hashColumns.put("cond_sts_cd", getCondStsCd());
		this.hashColumns.put("copy_bse_yr", getCopyBseYr());
		
		//0048, 0075
		this.hashColumns.put("bse_qtr_cd"        ,getBse_qtr_cd());
		this.hashColumns.put("bse_quarter"       ,getBse_quarter());
		this.hashColumns.put("bse_yr"            ,getBse_yr());
		this.hashColumns.put("chkCommand"        ,getChkCommand());
		this.hashColumns.put("condStepCd"        ,getCondStepCd());
		this.hashColumns.put("cre_usr_id"        ,getCreUsrId());
		this.hashColumns.put("ctrt_rhq_cd"       ,getCtrt_rhq_cd());
		this.hashColumns.put("currMqtaStepCd"    ,getCurrMqtaStepCd());
		this.hashColumns.put("delt_flg"          ,getDeltFlg());
		this.hashColumns.put("dir_cd"            ,getDir_cd());
		this.hashColumns.put("edit_mode"         ,getEdit_mode());
		this.hashColumns.put("glineVerNo"        ,getGlineVerNo());
		this.hashColumns.put("gline_ver_no"      ,getGline_ver_no());
		this.hashColumns.put("mQtaStepCd"        ,getMQtaStepCd());
		this.hashColumns.put("mQtaVerNo"         ,getMQtaVerNo());
		this.hashColumns.put("mqta_step_cd"      ,getMqta_step_cd());
		this.hashColumns.put("mqta_ver_no"       ,getMqta_ver_no());
		this.hashColumns.put("newStatusCd"       ,getNewStatusCd());
		this.hashColumns.put("newStepCd"         ,getNewStepCd());
		this.hashColumns.put("newVersion"        ,getNewVersion());
		this.hashColumns.put("ofc_Cd"            ,getOfc_Cd());
		this.hashColumns.put("pfmc_fr_month"     ,getPfmc_fr_month());
		this.hashColumns.put("pfmc_fr_year"      ,getPfmc_fr_year());
		this.hashColumns.put("pfmc_to_month"     ,getPfmc_to_month());
		this.hashColumns.put("pfmc_to_year"      ,getPfmc_to_year());
		this.hashColumns.put("qtaMstVerNo"       ,getQtaMstVerNo());
		this.hashColumns.put("saq_sts_cd"        ,getSaq_sts_cd());
		this.hashColumns.put("search_rlane_cd"   ,getSearch_rlane_cd());
		this.hashColumns.put("search_sub_trd_cd" ,getSearch_sub_trd_cd());
		this.hashColumns.put("statusCd"          ,getStatusCd());
		this.hashColumns.put("subTrade"          ,getSubTrade());
		this.hashColumns.put("targetMonth"       ,getTargetMonth());
		this.hashColumns.put("tradeGroupCd"      ,getTradeGroupCd());
		this.hashColumns.put("trade_group"       ,getTrade_group());
		this.hashColumns.put("trd_cd"            ,getTrd_cd());
		this.hashColumns.put("unit_tp"           ,getUnit_tp());
		this.hashColumns.put("upd_usr_id"        ,getUpdUsrId());		
		this.hashColumns.put("inclPortFlag"      ,getInclPortFlag());
		this.hashColumns.put("mqtaMdlVerNo"      ,getMqtaMdlVerNo());
		this.hashColumns.put("slsFcastPubNo"     ,getSlsFcastPubNo());
		this.hashColumns.put("userId"            ,getUserId());
		this.hashColumns.put("org"               ,getOrg());
		this.hashColumns.put("rhq_cd"            ,getRhq_cd());
		this.hashColumns.put("slsRgnOfcCd"       ,getSlsRgnOfcCd());
		this.hashColumns.put("slsRhqCd"          ,getSls_rhq_cd());
		this.hashColumns.put("saqStsCd"		     ,getSaqStsCd());
		this.hashColumns.put("newQtaTgtCd"	     ,getNewQtaTgtCd());
		
		//0098
		this.hashColumns.put("startLevel"		, getStartLevel	());
		this.hashColumns.put("endLevel"			, getEndLevel	());
   		this.hashColumns.put("detCAQ"			, getDetCAQ		());	
   		this.hashColumns.put("detCOfc"			, getDetCOfc    ());	
   		this.hashColumns.put("detSubTrade"		, getDetSubTrade());	
   		this.hashColumns.put("detLane"			, getDetLane    ());	
   		this.hashColumns.put("detLRHQ"			, getDetLRHQ    ());	
   		this.hashColumns.put("detLAQ"			, getDetLAQ		());	
   		this.hashColumns.put("detLOfc"			, getDetLOfc    ());	
   		this.hashColumns.put("newVersionNo"		, getNewVersionNo());	
   		this.hashColumns.put("IsNewVersion"		, getIsNewVersion());	
   		this.hashColumns.put("yqtaRlseVerNo"	, getYqtaRlseVerNo());	
   		this.hashColumns.put("mstVersion"		, getMstVersion());	
   		this.hashColumns.put("datCreStepCd"		, getDatCreStepCd());	

   		this.hashColumns.put("vvd"				, getVvd());	
   		this.hashColumns.put("group"			, getGroup());	
   		
  		this.hashColumns.put("sprt_grp_cd"		, getSprtGrpCd());	
  		this.hashColumns.put("bsa_grp_cd"		, getBsaGrpCd());	
  		this.hashColumns.put("tbl_gbn"	    	, getTblGbn());	
  		this.hashColumns.put("bse_mon"	    	, getBseMon2());	
  		
   		
  		this.hashColumns.put("rlane_cd"         ,getRlane_cd());
  		this.hashColumns.put("addTpCd"          ,getAddTpCd());
  		this.hashColumns.put("newRlaneCd"       ,getNewRlaneCd());
  		this.hashColumns.put("add_tp_cd"        ,getAdd_tp_cd());
  		
		this.hashColumns.put("aq_cd"			, getAq_Cd());
		this.hashColumns.put("new_rlane_cd"		, getNew_Rlane_Cd());
		
		this.hashColumns.put("cre_ofc_cd" 		, getCreOfcCd());
  		this.hashColumns.put("rgn_ofc_cd" 		, getRgnOfcCd2());
  		this.hashColumns.put("pol_cd"			, getPolCd());
  		this.hashColumns.put("pod_cd"			, getPodCd());
  		
  		this.hashColumns.put("custNm"			, getCustNm());
  		
		//0181
		this.hashColumns.put("from_mon"			,getFrom_mon());
		this.hashColumns.put("to_mon"			,getTo_mon());		
		
		
		//0187
		this.hashColumns.put("yQtaStepCd"       ,getYQtaStepCd());
		this.hashColumns.put("yQtaVerNo"        ,getYQtaVerNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slsAqCd"			, "slsAqCd"			);
		this.hashFields.put("ctrtAqCd"			, "ctrtAqCd"		);
		this.hashFields.put("targetGrpChild"	, "targetGrpChild"	);
		this.hashFields.put("tradeChild"		, "tradeChild"		);
		this.hashFields.put("rhqCd"				, "rhqCd"			);
		this.hashFields.put("trade"				, "trade"			);
		this.hashFields.put("rlaneCd"			, "rlaneCd"			);
		this.hashFields.put("pagerows"			, "pagerows"		);
		this.hashFields.put("targetGrp"			, "targetGrp"		);
		this.hashFields.put("version"			, "version"			);
		this.hashFields.put("unit"				, "unit"			);
		this.hashFields.put("ibflag"			, "ibflag"			);
		this.hashFields.put("ctrtOfcCd"			, "ctrtOfcCd"		);
		this.hashFields.put("slsOfcCd"			, "slsOfcCd"		);
		this.hashFields.put("item"				, "item"			);
		this.hashFields.put("subTrade"			, "subTrade"		);
		this.hashFields.put("year"				, "year"			);
		this.hashFields.put("dirCd"				, "dirCd"			);
		this.hashFields.put("rgnOfcCd"			, "rgnOfcCd"		);
		this.hashFields.put("dirCdChild"		, "dirCdChild"		);	
		this.hashFields.put("bound"				, "bound"			);	
		this.hashFields.put("quarter"			, "quarter"			);
		this.hashFields.put("IntervalTime"		, "IntervalTime"	); //0047 searchlist02 용
		this.hashFields.put("grp_flg"			, "grp_flg"			);
		this.hashFields.put("type"				, "type"			);
		this.hashFields.put("step"				, "step"			);
		this.hashFields.put("sts"				, "sts"				);
		this.hashFields.put("period"			, "period"			);
		this.hashFields.put("rep_trade"			, "rep_trade"		);
		this.hashFields.put("yqta_ver_no"		, "yqta_ver_no"		);
		this.hashFields.put("login_ofc_cd"		, "login_ofc_cd"	);
		this.hashFields.put("sheet_check"		, "sheet_check"		);
		this.hashFields.put("isZeroLoad"		, "isZeroLoad"		);		
		this.hashFields.put("target_grp"		, "targetGrp"		);
		this.hashFields.put("sub_trade"			, "subTrade"		);
		this.hashFields.put("dir_cd"			, "dirCd"			);
		this.hashFields.put("sls_fcast_pub_no"	, "slsFcastPubNo"	);
		this.hashFields.put("yqta_mdl_ver_no"	, "yqtaMdlVerNo"	);
		this.hashFields.put("ofc_cd"			, "ofcCd"			);
		this.hashFields.put("pln_scnr_no"		, "plnScnrNo"		);
		this.hashFields.put("saq_sts_cd"		, "saqStsCd"		);
		this.hashFields.put("f_cmd"				, "f_cmd"			);
		this.hashFields.put("lod_qty"			, "lodQty"			);
		this.hashFields.put("grs_rev"			, "grsRev"			);
		this.hashFields.put("cm_amt"			, "cmAmt"			);
		this.hashFields.put("opfit_amt"			, "opfitAmt"		);
		this.hashFields.put("user_id"			, "userId"			);
		this.hashFields.put("max_lod"			, "maxLod"			);
		this.hashFields.put("min_lod"			, "minLod"			);
		this.hashFields.put("sts00"				, "sts00"			);
		this.hashFields.put("sts_others"		, "stsOthers"		);
		this.hashFields.put("incl_port_flag"	, "inclPortFlag"	);
		this.hashFields.put("mqta_mdl_ver_no"	, "mqtaMdlVerNo"	);
		this.hashFields.put("bse_qtr_cd"		, "bseQtrCd"		);
		this.hashFields.put("targetGroup"		, "targetGroup"		);
		this.hashFields.put("kamer_id"			, "kamer_id"		);
		this.hashFields.put("ctrtRhqCd"			, "ctrtRhqCd"		);
		this.hashFields.put("ctrtRgnOfcCd"		, "ctrtRgnOfcCd"	);
		this.hashFields.put("combo_version"		, "comboVersion"	);
		this.hashFields.put("lane"				, "lane"	);
		this.hashFields.put("trade_group"		, "tradeGroup"	);	
		this.hashFields.put("edit_mode"			, "editMode"	);	
		this.hashFields.put("calc1"				, "calc1"	);	
		this.hashFields.put("calc2"				, "calc2"	);	
		this.hashFields.put("tab_idx"			, "tabIdx"	);	
		this.hashFields.put("yqta_step_cd"		, "yqtaStepCd"	);	
		
		this.hashFields.put("mqtaRlseVerNo"     , "mqtaRlseVerNo"   );       
		this.hashFields.put("bseYr" 	        , "bseYr" 	        );       
		this.hashFields.put("bseMon" 	        , "bseMon" 	        );       
		this.hashFields.put("fmBseWk" 	        , "fmBseWk" 	    );       
		this.hashFields.put("toBseWk" 	        , "toBseWk" 	    );       
		this.hashFields.put("ofcOfcCd" 	        , "ofcOfcCd" 	    );       
		this.hashFields.put("trdCd" 	        , "trdCd" 	        );       
		this.hashFields.put("rbQtaTgtCd" 	    , "rbQtaTgtCd" 	    );       
		this.hashFields.put("grsRpbRev" 	    , "grsRpbRev" 	    );       
		this.hashFields.put("cm" 	            , "cm" 	            );       
		this.hashFields.put("cfmSts" 	        , "cfmSts" 	        );       
		this.hashFields.put("qtaTgtCd" 	        , "qtaTgtCd" 	    );    
		
		this.hashFields.put("selType", "selType");
		this.hashFields.put("month", "month");
		this.hashFields.put("items0", "items0");
		this.hashFields.put("ilist", "ilist");
		this.hashFields.put("isRhq", "isRhq");
		this.hashFields.put("subTrdCd", "subTrdCd");
		this.hashFields.put("aqCd", "aqCd");
		this.hashFields.put("from_wk", "from_wk");
		this.hashFields.put("to_wk", "to_wk");
		this.hashFields.put("orgType", "orgType");
		
		//0083
		this.hashFields.put("tgtOrzCd","tgtOrzCd");
		this.hashFields.put("slsRhqCd","slsRhqCd");

		//0163
		this.hashFields.put("copy_bse_qtr_cd", "copyBseQtrCd");
		this.hashFields.put("cond_sts_cd", "condStsCd");
		this.hashFields.put("copy_bse_yr", "copyBseYr");
		
		//0048, 0075
		this.hashFields.put("bse_qtr_cd"        ,"bse_qtr_cd"        );
		this.hashFields.put("bse_quarter"       ,"bse_quarter"       );
		this.hashFields.put("bse_yr"            ,"bse_yr"            );
		this.hashFields.put("chkCommand"        ,"chkCommand"        );
		this.hashFields.put("condStepCd"        ,"condStepCd"        );
		this.hashFields.put("cre_usr_id"        ,"creUsrId"          );
		this.hashFields.put("ctrt_rhq_cd"       ,"ctrt_rhq_cd"       );
		this.hashFields.put("currMqtaStepCd"    ,"currMqtaStepCd"    );
		this.hashFields.put("delt_flg"          ,"deltFlg"           );
		this.hashFields.put("dir_cd"            ,"dir_cd"            );
		this.hashFields.put("edit_mode"         ,"edit_mode"         );
		this.hashFields.put("glineVerNo"        ,"glineVerNo"        );
		this.hashFields.put("gline_ver_no"      ,"gline_ver_no"      );
		this.hashFields.put("mQtaStepCd"        ,"mQtaStepCd"        );
		this.hashFields.put("mQtaVerNo"         ,"mQtaVerNo"         );
		this.hashFields.put("mqta_step_cd"      ,"mqta_step_cd"      );
		this.hashFields.put("mqta_ver_no"       ,"mqta_ver_no"       );
		this.hashFields.put("newStatusCd"       ,"newStatusCd"       );
		this.hashFields.put("newStepCd"         ,"newStepCd"         );
		this.hashFields.put("newVersion"        ,"newVersion"        );
		this.hashFields.put("ofc_Cd"            ,"ofc_Cd"            );
		this.hashFields.put("pfmc_fr_month"     ,"pfmc_fr_month"     );
		this.hashFields.put("pfmc_fr_year"      ,"pfmc_fr_year"      );
		this.hashFields.put("pfmc_to_month"     ,"pfmc_to_month"     );
		this.hashFields.put("pfmc_to_year"      ,"pfmc_to_year"      );
		this.hashFields.put("qtaMstVerNo"       ,"qtaMstVerNo"       );
		this.hashFields.put("saq_sts_cd"        ,"saq_sts_cd"        );
		this.hashFields.put("search_rlane_cd"   ,"search_rlane_cd"   );
		this.hashFields.put("search_sub_trd_cd" ,"search_sub_trd_cd" );
		this.hashFields.put("statusCd"          ,"statusCd"          );
		this.hashFields.put("subTrade"          ,"subTrade"          );
		this.hashFields.put("target_month"      ,"target_month"      );
		this.hashFields.put("tradeGroupCd"      ,"tradeGroupCd"      );
		this.hashFields.put("trade_group"       ,"trade_group"       );
		this.hashFields.put("trd_cd"            ,"trd_cd"            );
		this.hashFields.put("unit_tp"           ,"unit_tp"           );
		this.hashFields.put("upd_usr_id"        ,"updUsrId"          );
		this.hashFields.put("inclPortFlag"      ,"inclPortFlag"      );
		this.hashFields.put("mqtaMdlVerNo"      ,"mqtaMdlVerNo"      );
		this.hashFields.put("slsFcastPubNo"     ,"slsFcastPubNo"     );
		this.hashFields.put("userId"            ,"userId"            );
		this.hashFields.put("org"               ,"org"               );
		this.hashFields.put("slsRgnOfcCd"       ,"slsRgnOfcCd"       );
		this.hashFields.put("slsRhqCd"          ,"slsRhqCd"          );
		
		//0098
		this.hashFields.put("startLevel"	, "startLevel"	);
		this.hashFields.put("endLevel"		, "endLevel"	);
		this.hashFields.put("detCAQ"		, "detCAQ" 	    );    
		this.hashFields.put("detCOfc"		, "detCOfc" 	);    
		this.hashFields.put("detSubTrade"	, "detSubTrade" );    
		this.hashFields.put("detLane" 	   	, "detLane" 	);    
		this.hashFields.put("detLRHQ" 	   	, "detLRHQ" 	);    
		this.hashFields.put("detLAQ" 	   	, "detLAQ" 	    );    
		this.hashFields.put("detLOfc" 	   	, "detLOfc" 	);    
		this.hashFields.put("newVersionNo" 	, "newVersionNo");
		this.hashFields.put("IsNewVersion" 	, "IsNewVersion");
		this.hashFields.put("yqtaRlseVerNo" , "yqtaRlseVerNo");
		this.hashFields.put("mstVersion" 	, "mstVersion");
		this.hashFields.put("datCreStepCd" 	, "datCreStepCd");
		
		this.hashFields.put("sprt_grp_cd"  , "sprt_grp_cd");
		this.hashFields.put("bsa_grp_cd"   , "bsa_grp_cd");
		this.hashFields.put("tbl_gbn"      , "tbl_gbn");
		this.hashFields.put("bse_mon"      , "bse_mon");
		
		
		this.hashFields.put("vvd" 			, "vvd");
		this.hashFields.put("group" 		, "group");
		this.hashFields.put("rlane_cd"   	, "rlane_cd");
		
		this.hashFields.put("aq_cd"			, "aq_cd");	
		this.hashFields.put("new_rlane_cd"	, "new_rlane_cd");
		
		this.hashFields.put("cre_ofc_cd"	, "cre_ofc_cd");
		this.hashFields.put("rgn_ofc_cd"	, "rgn_ofc_cd");
		this.hashFields.put("pol_cd"		, "pol_cd");
		this.hashFields.put("pod_cd"		, "pod_cd");
		
		this.hashFields.put("custNm"		, "custNm");
		
		//0181
		this.hashFields.put("from_mon"		, "from_mon");
		this.hashFields.put("to_mon"		, "to_mon");
		
		//0187
		this.hashFields.put("yQtaStepCd"    ,"yQtaStepCd"        );
		this.hashFields.put("yQtaVerNo"     ,"yQtaVerNo"        );
		
		return this.hashFields;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSlsAqCd(JSPUtil.getParameter(request, "slsAqCd", ""));
		setCtrtAqCd(JSPUtil.getParameter(request, "ctrtAqCd", ""));
		setTargetGrpChild(JSPUtil.getParameter(request, "targetGrpChild", ""));
		setTradeChild(JSPUtil.getParameter(request, "tradeChild", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhqCd", ""));
		setTrade(JSPUtil.getParameter(request, "trade", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlaneCd", ""));
		setRlane_cd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTargetGrp(JSPUtil.getParameter(request, "targetGrp", ""));
		setVersion(JSPUtil.getParameter(request, "version", ""));
		setUnit(JSPUtil.getParameter(request, "unit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrtOfcCd", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "slsOfcCd", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setSubTrade(JSPUtil.getParameter(request, "subTrade", ""));
		setYear(JSPUtil.getParameter(request, "year", ""));
		setDirCd(JSPUtil.getParameter(request, "dirCd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, "rgnOfcCd", ""));
		setDirCdChild(JSPUtil.getParameter(request, "dirCdChild", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setQuarter(JSPUtil.getParameter(request, "quarter", ""));
		setSlsFcastPubNo(JSPUtil.getParameter(request, "slsFcastPubNo", ""));
		setStsCd(JSPUtil.getParameter(request, "stsCd", ""));
		setFmStep(JSPUtil.getParameter(request, "fm_step", ""));
		setToStep(JSPUtil.getParameter(request, "to_step", ""));
		setIntervalTime(JSPUtil.getParameter(request, "intervalTime", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setStep(JSPUtil.getParameter(request, "step", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setRepTrade(JSPUtil.getParameter(request, "rep_trade", ""));
		setYqtaVerNo(JSPUtil.getParameter(request, "yqta_ver_no", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setSheetCheck(JSPUtil.getParameter(request, "sheet_check", ""));
		setIsZeroLoad(JSPUtil.getParameter(request, "isZeroLoad", ""));	
		setRepMonth(JSPUtil.getParameter(request, "repMonth", ""));
		setStr(JSPUtil.getParameter(request, "str", ""));
		setYqtaMdlVerNo(JSPUtil.getParameter(request, "yqtaMdlVerNo", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofcCd", ""));
		setPlnScnrNo(JSPUtil.getParameter(request, "plnScnrNo", ""));
		setSaqStsCd(JSPUtil.getParameter(request, "saqStsCd", ""));
		setFcmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setLodQty(JSPUtil.getParameter(request, "lodQty", ""));
		setGrsRev(JSPUtil.getParameter(request, "grsRev", ""));
		setCmAmt(JSPUtil.getParameter(request, "cmAmt", ""));
		setOpfitAmt(JSPUtil.getParameter(request, "opfitAmt", ""));
		setUserId(JSPUtil.getParameter(request, "userId", ""));
		setMaxLod(JSPUtil.getParameter(request, "maxLod", ""));
		setMinLod(JSPUtil.getParameter(request, "minLod", ""));
		setSts00(JSPUtil.getParameter(request, "sts00", ""));
		setStsOthers(JSPUtil.getParameter(request, "stsOthers", ""));
		setInclPortFlag(JSPUtil.getParameter(request, "inclPortFlag", ""));
		setMqtaMdlVerNo(JSPUtil.getParameter(request, "mqtaMdlVerNo", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setTargetGroup(JSPUtil.getParameter(request, "targetGroup", ""));	
		setKamer_id(JSPUtil.getParameter(request, "kamer_id", ""));
		setCtrtRhqCd(JSPUtil.getParameter(request, "ctrtRhqCd", ""));
		setCtrtRgnOfcCd(JSPUtil.getParameter(request, "ctrtRgnOfcCd", ""));
		setComboVersion(JSPUtil.getParameter(request, "combo_version", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setTradeGroup(JSPUtil.getParameter(request, "trade_group", ""));
		setEditMode(JSPUtil.getParameter(request, "edit_mode", ""));
		setCalc1(JSPUtil.getParameter(request, "calc1", ""));
		setCalc2(JSPUtil.getParameter(request, "calc2", ""));
		setTabIdx(JSPUtil.getParameter(request, "tab_idx", ""));
		setYqtaStepCd(JSPUtil.getParameter(request, "yqta_step_cd", ""));

		setMqtaRlseVerNo(JSPUtil.getParameter(request,   "mqtaRlseVerNo" , ""));            
		setBseYr(JSPUtil.getParameter(request, 	         "bseYr" 	     , ""));            
		setBseMon(JSPUtil.getParameter(request, 	     "bseMon" 	     , ""));            
		setFmBseWk(JSPUtil.getParameter(request, 	     "fmBseWk" 	     , ""));            
		setToBseWk(JSPUtil.getParameter(request, 	     "toBseWk" 	     , ""));            
		setOfcOfcCd(JSPUtil.getParameter(request, 	     "ofcOfcCd" 	 , ""));            
		setTrdCd(JSPUtil.getParameter(request, 	         "trdCd" 	     , ""));            
		setRbQtaTgtCd(JSPUtil.getParameter(request, 	 "rbQtaTgtCd" 	 , ""));            
		setGrsRpbRev(JSPUtil.getParameter(request, 	     "grsRpbRev" 	 , ""));            
		setCm(JSPUtil.getParameter(request, 	         "cm" 	         , ""));            
		setCfmSts(JSPUtil.getParameter(request, 	     "cfmSts" 	     , ""));            
		setQtaTgtCd(JSPUtil.getParameter(request, 	     "qtaTgtCd" 	 , ""));            
//		setBseQtrCd(JSPUtil.getParameter(request,        "bseQtrCd"      , ""));		
		
		setYqta_step_cd(JSPUtil.getParameter(request, "yqtaStepCd", ""));
		setYqta_ver_no(JSPUtil.getParameter(request, "yqtaVerNo", ""));
		setOfcTpCd(JSPUtil.getParameter(request, "ofcTpCd", ""));
		
		setSelType(JSPUtil.getParameter(request, "selType", ""));
		setMonth(JSPUtil.getParameter(request, "month", ""));
		setItems0(JSPUtil.getParameter(request, "items0", ""));
		setIlist(JSPUtil.getParameter(request, "ilist", ""));
		setIsRhq(JSPUtil.getParameter(request, "isRhq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "subTrdCd", ""));
		setAqCd(JSPUtil.getParameter(request, "aqCd", ""));
		setFrom_wk(JSPUtil.getParameter(request, "from_wk", ""));
		setTo_wk(JSPUtil.getParameter(request, "to_wk", ""));
		setOrgType(JSPUtil.getParameter(request, "orgType", ""));
			
		//0083
		setTgtOrzCd (JSPUtil.getParameter(request, "tgtOrzCd", ""));
		setSlsRhqCd  (JSPUtil.getParameter(request, "slsRhqCd", ""));
		
		//0163
		setCopyBseQtrCd(JSPUtil.getParameter(request, "copy_bse_qtr_cd", ""));
		setCondStsCd(JSPUtil.getParameter(request, "cond_sts_cd", ""));
		setCopyBseYr(JSPUtil.getParameter(request, "copy_bse_yr", ""));
		
		//0081
		setCustGrp(          JSPUtil.getParameter(request, "cust_grp"         , ""));
		setSub_trade(        JSPUtil.getParameter(request, "sub_trade"         , ""));
		setKeyAcctMgrUsrId(  JSPUtil.getParameter(request, "key_acct_mgr_usr_id"         , ""));
		
		setYstepCd(			 JSPUtil.getParameter(request, "ystep_cd"         , ""));
		
		// 0048, 0075
		setBse_qtr_cd(       JSPUtil.getParameter(request, "bse_qtr_cd"       , ""));
		setBse_quarter(      JSPUtil.getParameter(request, "bse_quarter"      , ""));
		setBse_yr(           JSPUtil.getParameter(request, "bse_yr"           , ""));
		setChkCommand(       JSPUtil.getParameter(request, "chkCommand"       , ""));
		setCondStepCd(       JSPUtil.getParameter(request, "condStepCd"       , ""));
		setCreUsrId(         JSPUtil.getParameter(request, "cre_usr_id"       , ""));
		setCtrt_rhq_cd(      JSPUtil.getParameter(request, "ctrt_rhq_cd"      , ""));
		setCurrMqtaStepCd(   JSPUtil.getParameter(request, "currMqtaStepCd"   , ""));
		setDeltFlg(          JSPUtil.getParameter(request, "delt_flg"         , ""));
		setDir_cd(           JSPUtil.getParameter(request, "dir_cd"           , ""));
		setEdit_mode(        JSPUtil.getParameter(request, "edit_mode"        , ""));
		setGlineVerNo(       JSPUtil.getParameter(request, "glineVerNo"       , ""));
		setGline_ver_no(     JSPUtil.getParameter(request, "gline_ver_no"     , ""));
		setMQtaStepCd(       JSPUtil.getParameter(request, "mQtaStepCd"       , ""));
		setMQtaVerNo(        JSPUtil.getParameter(request, "mQtaVerNo"        , ""));
		setMqta_step_cd(     JSPUtil.getParameter(request, "mqta_step_cd"     , ""));
		setMqta_ver_no(      JSPUtil.getParameter(request, "mqta_ver_no"      , ""));
		setNewStatusCd(      JSPUtil.getParameter(request, "newStatusCd"      , ""));
		setNewStepCd(        JSPUtil.getParameter(request, "newStepCd"        , ""));
		setNewVersion(       JSPUtil.getParameter(request, "newVersion"       , ""));
		setOfc_Cd(           JSPUtil.getParameter(request, "ofc_Cd"           , ""));
		setOfc_cd(           JSPUtil.getParameter(request, "ofc_cd"           , ""));
		setPfmc_fr_month(    JSPUtil.getParameter(request, "pfmc_fr_month"    , ""));
		setPfmc_fr_year(     JSPUtil.getParameter(request, "pfmc_fr_year"     , ""));
		setPfmc_to_month(    JSPUtil.getParameter(request, "pfmc_to_month"    , ""));
		setPfmc_to_year(     JSPUtil.getParameter(request, "pfmc_to_year"     , ""));
		setQtaMstVerNo(      JSPUtil.getParameter(request, "qta_mst_ver_no"   , ""));
		setSaq_sts_cd(       JSPUtil.getParameter(request, "saq_sts_cd"       , ""));
		setSearch_rlane_cd(  JSPUtil.getParameter(request, "search_rlane_cd"  , ""));
		setSearch_sub_trd_cd(JSPUtil.getParameter(request, "search_sub_trd_cd", ""));
		setStatusCd(         JSPUtil.getParameter(request, "statusCd"         , ""));
		setTargetMonth(      JSPUtil.getParameter(request, "target_month"     , ""));
		setTradeGroupCd(     JSPUtil.getParameter(request, "saq_tgt_grp_cd"   , ""));
		setTrade_group(      JSPUtil.getParameter(request, "trade_group"      , ""));
		setTrd_cd(           JSPUtil.getParameter(request, "trd_cd"           , ""));
		setUnit_tp(          JSPUtil.getParameter(request, "unit_tp"          , ""));
		setUpdUsrId(         JSPUtil.getParameter(request, "upd_usr_id"       , ""));
		setOrg(              JSPUtil.getParameter(request, "org"              , ""));
		setRhq_cd(           JSPUtil.getParameter(request, "rhq_cd"           , ""));
		setSlsRgnOfcCd(      JSPUtil.getParameter(request, "sls_rgn_ofc_cd"   , ""));
		setSls_rhq_cd(       JSPUtil.getParameter(request, "sls_rhq_cd"       , ""));
		//setMqtaRlseVerNo(    JSPUtil.getParameter(request, "rlse_ver_no"      , "")); 

		//0098
		setStartLevel	(JSPUtil.getParameter(request, "startLevel", ""));		
		setEndLevel		(JSPUtil.getParameter(request, "endLevel", ""));		
		setDetCAQ     	(JSPUtil.getParameter(request, "detCAQ", ""));		
		setDetCOfc    	(JSPUtil.getParameter(request, "detCOfc", ""));		
		setDetSubTrade	(JSPUtil.getParameter(request, "detSubTrade", ""));		
		setDetLane    	(JSPUtil.getParameter(request, "detLane", ""));		
		setDetLRHQ    	(JSPUtil.getParameter(request, "detLRHQ", ""));		
		setDetLAQ     	(JSPUtil.getParameter(request, "detLAQ", ""));		
		setDetLOfc    	(JSPUtil.getParameter(request, "detLOfc", ""));	
		setNewVersionNo (JSPUtil.getParameter(request, "newVersionNo", ""));	
		setIsNewVersion (JSPUtil.getParameter(request, "is_new_version", ""));	
		setYqtaRlseVerNo (JSPUtil.getParameter(request, "yqta_rlse_ver_no", ""));	
		
		setMstVersion   (JSPUtil.getParameter(request, "mstVersion", ""));	
		setDatCreStepCd (JSPUtil.getParameter(request, "datCreStepCd", ""));	

		setDetTrade(JSPUtil.getParameter(request, "detTrade", ""));	
		setDetBound(JSPUtil.getParameter(request, "detBound", ""));	
		setDetCRHQ(JSPUtil.getParameter(request, "detCRHQ", ""));	
		
		setSprtGrpCd (JSPUtil.getParameter(request, "sprt_grp_cd	", ""));	
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd	", ""));	
		setTblGbn (JSPUtil.getParameter(request, "tbl_gbn	", ""));	
		setBseMon2 (JSPUtil.getParameter(request, "bse_mon", ""));
		
			
		setVvd (JSPUtil.getParameter(request, "vvd	", ""));	
		setGroup (JSPUtil.getParameter(request, "group	", ""));
		setAddTpCd (JSPUtil.getParameter(request, "addTpCd	", ""));
		setNewRlaneCd (JSPUtil.getParameter(request, "newRlaneCd	", ""));
		setAdd_tp_cd (JSPUtil.getParameter(request, "add_tp_cd	", ""));
		setChangeType (JSPUtil.getParameter(request, "change_type	", ""));
		setChangeMode (JSPUtil.getParameter(request, "change_mode	", ""));
		
		setAq_Cd(JSPUtil.getParameter(request, "aq_cd", ""));
		setNew_Rlane_Cd(JSPUtil.getParameter(request, "new_rlane_cd", ""));
		
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setRgnOfcCd2(JSPUtil.getParameter(request, "rgn_ofc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		
		setCustNm(JSPUtil.getParameter(request, "custNm", ""));
		
		//0181
		setFrom_mon(JSPUtil.getParameter(request, "from_mon", ""));
		setTo_mon(JSPUtil.getParameter(request, "to_mon", ""));
		
		//0187
		setYQtaStepCd(JSPUtil.getParameter(request, "yQtaStepCd"       , ""));
		setYQtaVerNo(JSPUtil.getParameter(request, "yQtaVerNo"       , ""));
		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConditionVO[]
	 */
	public QuotaConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConditionVO[]
	 */
	public QuotaConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		QuotaConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slsAqCd = (JSPUtil.getParameter(request, prefix	+ "slsAqCd", length));
			String[] ctrtAqCd = (JSPUtil.getParameter(request, prefix	+ "ctrtAqCd", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aqCd", length));			
			String[] aq_cd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] new_rlane_cd = (JSPUtil.getParameter(request, prefix	+ "new_rlane_cd", length));
			
			String[] targetGrpChild = (JSPUtil.getParameter(request, prefix	+ "targetGrpChild", length));
			String[] tradeChild = (JSPUtil.getParameter(request, prefix	+ "tradeChild", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhqCd", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlaneCd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] targetGrp = (JSPUtil.getParameter(request, prefix	+ "targetGrp", length));
			String[] version = (JSPUtil.getParameter(request, prefix	+ "version", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrtOfcCd", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "slsOfcCd", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] subTrade = (JSPUtil.getParameter(request, prefix	+ "subTrade", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dirCd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgnOfcCd", length));
			String[] dirCdChild = (JSPUtil.getParameter(request, prefix	+ "dirCdChild", length));			
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] quarter = (JSPUtil.getParameter(request, prefix	+ "quarter", length));
			String[] grp_flg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] step = (JSPUtil.getParameter(request, prefix	+ "step", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] rep_trade = (JSPUtil.getParameter(request, prefix	+ "rep_trade", length));
			String[] yqta_ver_no = (JSPUtil.getParameter(request, prefix	+ "yqta_ver_no", length));	
			String[] login_ofc_cd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));	
			String[] saq_sts_cd = (JSPUtil.getParameter(request, prefix	+ "saq_sts_cd", length));	
			String[] isZeroLoad = (JSPUtil.getParameter(request, prefix	+ "isZeroLoad", length));	
			String[] yqtaMdlVerNo = (JSPUtil.getParameter(request, prefix	+ "yqtaMdlVerNo", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofcCd", length));
			String[] plnScnrNo = (JSPUtil.getParameter(request, prefix	+ "plnScnrNo", length));
			String[] saqStsCd = (JSPUtil.getParameter(request, prefix	+ "saqStsCd", length));
			String[] f_cmd = (JSPUtil.getParameter(request, prefix + "f_cmd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix + "lodQty", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix + "grsRev", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix + "cmAmt", length));
			String[] opfitAmt = (JSPUtil.getParameter(request, prefix + "opfitAmt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix + "userId", length));
			String[] maxLod = (JSPUtil.getParameter(request, prefix + "maxLod", length));
			String[] minLod = (JSPUtil.getParameter(request, prefix + "minLod", length));
			String[] sts00 = (JSPUtil.getParameter(request, prefix + "sts00", length));
			String[] stsOthers = (JSPUtil.getParameter(request, prefix + "stsOthers", length));
			String[] inclPortFlag = (JSPUtil.getParameter(request, prefix + "inclPortFlag", length));
			String[] mqtaMdlVerNo = (JSPUtil.getParameter(request, prefix + "mqtaMdlVerNo", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix + "bseQtrCd", length));
			String[] targetGroup = (JSPUtil.getParameter(request, prefix	+ "targetGroup", length));
			String[] kamer_id = (JSPUtil.getParameter(request, prefix	+ "kamer_id", length));
			String[] ctrtRhqCd = (JSPUtil.getParameter(request, prefix	+ "ctrtRhqCd", length));
			String[] ctrtRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrtRgnOfcCd", length));
			String[] comboVersion = (JSPUtil.getParameter(request, prefix	+ "combo_version", length));

        	String[] mqtaRlseVerNo =  (JSPUtil.getParameter(request, prefix	+  "mqtaRlseVerNo" , length ));
        	String[] bseYr 	       =  (JSPUtil.getParameter(request, prefix	+  "bseYr" 	       , length ));
        	String[] bseMon 	   =  (JSPUtil.getParameter(request, prefix	+  "bseMon" 	   , length ));
        	String[] fmBseWk 	   =  (JSPUtil.getParameter(request, prefix	+  "fmBseWk" 	   , length ));
        	String[] toBseWk 	   =  (JSPUtil.getParameter(request, prefix	+  "toBseWk" 	   , length ));
        	String[] ofcOfcCd 	   =  (JSPUtil.getParameter(request, prefix	+  "ofcOfcCd" 	   , length ));
        	String[] trdCd 	       =  (JSPUtil.getParameter(request, prefix	+  "trdCd" 	       , length ));
        	String[] rbQtaTgtCd    =  (JSPUtil.getParameter(request, prefix	+  "rbQtaTgtCd"    , length ));
        	String[] grsRpbRev 	   =  (JSPUtil.getParameter(request, prefix	+  "grsRpbRev" 	   , length ));
        	String[] cm 	       =  (JSPUtil.getParameter(request, prefix	+  "cm" 	       , length ));
        	String[] cfmSts 	   =  (JSPUtil.getParameter(request, prefix	+  "cfmSts" 	   , length ));
            String[] qtaTgtCd 	   =  (JSPUtil.getParameter(request, prefix	+  "qtaTgtCd" 	   , length ));

    		//0163
			String[] copyBseQtrCd = (JSPUtil.getParameter(request, prefix	+ "copy_bse_qtr_cd", length));
			String[] condStsCd = (JSPUtil.getParameter(request, prefix	+ "cond_sts_cd", length));
			String[] copyBseYr = (JSPUtil.getParameter(request, prefix	+ "copy_bse_yr", length));
			
			//0048, 0075
			String[] ofc_Cd            = JSPUtil.getParameter(request, prefix + "ofc_Cd"           , length);
			String[] bse_quarter       = JSPUtil.getParameter(request, prefix + "bse_quarter"      , length);
			String[] trade_group       = JSPUtil.getParameter(request, prefix + "trade_group"      , length);
			String[] pfmc_fr_year      = JSPUtil.getParameter(request, prefix + "pfmc_fr_year"     , length);
			String[] pfmc_fr_month     = JSPUtil.getParameter(request, prefix + "pfmc_fr_month"    , length);
			String[] pfmc_to_year      = JSPUtil.getParameter(request, prefix + "pfmc_to_year"     , length);
			String[] pfmc_to_month     = JSPUtil.getParameter(request, prefix + "pfmc_to_month"    , length);
			String[] targetMonth       = JSPUtil.getParameter(request, prefix + "target_month"     , length);
			String[] edit_mode         = JSPUtil.getParameter(request, prefix + "edit_mode"        , length);
			String[] glineVerNo        = JSPUtil.getParameter(request, prefix + "glineVerNo"       , length);
			String[] mQtaVerNo         = JSPUtil.getParameter(request, prefix + "mQtaVerNo"        , length);
			String[] mQtaStepCd        = JSPUtil.getParameter(request, prefix + "mQtaStepCd"       , length);
			String[] slsFcastPubNo     = JSPUtil.getParameter(request, prefix + "slsFcastPubNo"    , length);
			String[] ctrt_rhq_cd       = JSPUtil.getParameter(request, prefix + "ctrt_rhq_cd"      , length);
			String[] search_sub_trd_cd = JSPUtil.getParameter(request, prefix + "search_sub_trd_cd", length);
			String[] search_rlane_cd   = JSPUtil.getParameter(request, prefix + "search_rlane_cd"  , length);
			String[] creUsrId          = JSPUtil.getParameter(request, prefix + "cre_usr_id"       , length);
			String[] updUsrId          = JSPUtil.getParameter(request, prefix + "upd_usr_id"       , length);
			String[] deltFlg           = JSPUtil.getParameter(request, prefix + "delt_flg"         , length);
			String[] statusCd          = JSPUtil.getParameter(request, prefix + "statusCd"         , length);
			String[] newStatusCd       = JSPUtil.getParameter(request, prefix + "newStatusCd"      , length);
			String[] newVersion        = JSPUtil.getParameter(request, prefix + "newVersion"       , length);
			String[] newStepCd         = JSPUtil.getParameter(request, prefix + "newStepCd"        , length);
			String[] currMqtaStepCd    = JSPUtil.getParameter(request, prefix + "currMqtaStepCd"   , length);
			String[] condStepCd        = JSPUtil.getParameter(request, prefix + "condStepCd"       , length);
			String[] gline_ver_no      = JSPUtil.getParameter(request, prefix + "gline_ver_no"     , length);
			String[] mqta_step_cd      = JSPUtil.getParameter(request, prefix + "mqta_step_cd"     , length);
			String[] bse_yr            = JSPUtil.getParameter(request, prefix + "bse_yr"           , length);
			String[] bse_qtr_cd        = JSPUtil.getParameter(request, prefix + "bse_qtr_cd"       , length);
			String[] trd_cd            = JSPUtil.getParameter(request, prefix + "trd_cd"           , length);
			String[] dir_cd            = JSPUtil.getParameter(request, prefix + "dir_cd"           , length);
			String[] mqta_ver_no       = JSPUtil.getParameter(request, prefix + "mqta_ver_no"      , length);
			String[] unit_tp           = JSPUtil.getParameter(request, prefix + "unit_tp"          , length);
			String[] qtaMstVerNo       = JSPUtil.getParameter(request, prefix + "qta_mst_ver_no"   , length);
			String[] tradeGroupCd      = JSPUtil.getParameter(request, prefix + "saq_tgt_grp_cd"   , length);
			String[] rhq_cd            = JSPUtil.getParameter(request, prefix + "rhq_cd"           , length);
			String[] org               = JSPUtil.getParameter(request, prefix + "org"              , length);
			String[] newVersionNo      = JSPUtil.getParameter(request, prefix + "newVersionNo"     , length);
			String[] slsRgnOfcCd       = JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd"   , length);
			String[] sls_rhq_cd        = JSPUtil.getParameter(request, prefix + "sls_rhq_cd"       , length);
			//0181
			String[] from_mon          = JSPUtil.getParameter(request, prefix + "from_mon"   , length);
			String[] to_mon        	   = JSPUtil.getParameter(request, prefix + "to_mon"       , length);
			
			//0187
			String[] yQtaStepCd        = JSPUtil.getParameter(request, prefix + "yQtaStepCd"       , length);
			String[] yQtaVerNo         = JSPUtil.getParameter(request, prefix + "yQtaVerNo"        , length);
			
			
			for (int i = 0; i < length; i++) {
				model = new QuotaConditionVO();
				// Yearly Inquiry
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (ctrtAqCd[i] != null)
					model.setCtrtAqCd(ctrtAqCd[i]);
				if (targetGrpChild[i] != null)
					model.setTargetGrpChild(targetGrpChild[i]);
				if (tradeChild[i] != null)
					model.setTradeChild(tradeChild[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (targetGrp[i] != null)
					model.setTargetGrp(targetGrp[i]);
				if (version[i] != null)
					model.setVersion(version[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (subTrade[i] != null)
					model.setSubTrade(subTrade[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (dirCdChild[i] != null)
					model.setDirCdChild(dirCdChild[i]);			
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (quarter[i] != null)
					model.setQuarter(quarter[i]);
				if (grp_flg[i] != null)
					model.setGrpFlg(grp_flg[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (step[i] != null)
					model.setStep(step[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (rep_trade[i] != null)
					model.setRepTrade(rep_trade[i]);
				if (yqta_ver_no[i] != null)
					model.setYqtaVerNo(yqta_ver_no[i]);
				if (login_ofc_cd[i] != null)
					model.setLoginOfcCd(login_ofc_cd[i]);		
				if (isZeroLoad[i] != null)
					model.setIsZeroLoad(isZeroLoad[i]);		
				if (yqtaMdlVerNo[i] != null)
					model.setYqtaMdlVerNo(yqtaMdlVerNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (plnScnrNo[i] != null)
					model.setPlnScnrNo(plnScnrNo[i]);
				if (saqStsCd[i] != null)
					model.setSaqStsCd(saqStsCd[i]);
				if (f_cmd[i] != null)
					model.setFcmd(f_cmd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (opfitAmt[i] != null)
					model.setOpfitAmt(opfitAmt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (maxLod[i] != null)
					model.setMaxLod(maxLod[i]);
				if (minLod[i] != null)
					model.setMinLod(minLod[i]);
				if (sts00[i] != null)
					model.setSts00(sts00[i]);
				if (stsOthers[i] != null)
					model.setStsOthers(stsOthers[i]);
				if (inclPortFlag[i] != null)
					model.setInclPortFlag(inclPortFlag[i]);
				if (mqtaMdlVerNo[i] != null)
					model.setMqtaMdlVerNo(mqtaMdlVerNo[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (targetGroup[i] != null)
					model.setTargetGroup(targetGroup[i]);	
				if (kamer_id[i] != null)
					model.setKamer_id(kamer_id[i]);
				if (ctrtRhqCd[i] != null)
					model.setCtrtRhqCd(ctrtRhqCd[i]);
				if (ctrtRgnOfcCd[i] != null)
					model.setCtrtRgnOfcCd(ctrtRgnOfcCd[i]);
				if (comboVersion[i] != null)
					model.setComboVersion(comboVersion[i]);
				
				if (mqtaRlseVerNo[i] != null) 	
					model.setMqtaRlseVerNo(mqtaRlseVerNo[i]);  
				if (bseYr[i] != null) 	
					model.setBseYr(bseYr[i]);  
				if (bseMon[i] != null) 	
					model.setBseMon(bseMon[i]);  
				if (fmBseWk[i] != null) 	
					model.setFmBseWk(fmBseWk[i]);  
				if (toBseWk[i] != null) 	
					model.setToBseWk(toBseWk[i]);  
				if (ofcOfcCd[i] != null) 	
					model.setOfcOfcCd(ofcOfcCd[i]);  
				if (trdCd[i] != null) 	
					model.setTrdCd(trdCd[i]);  
				if (rbQtaTgtCd[i] != null) 	
					model.setRbQtaTgtCd(rbQtaTgtCd[i]);  
				if (grsRpbRev[i] != null) 	
					model.setGrsRpbRev(grsRpbRev[i]);  
				if (cm[i] != null) 	
					model.setCm(cm[i]);  
				if (cfmSts[i] != null) 	
					model.setCfmSts(cfmSts[i]);  
				if (qtaTgtCd[i] != null) 	
					model.setQtaTgtCd(qtaTgtCd[i]);  
				if (saq_sts_cd[i] != null) 	
					model.setSaq_sts_cd(saq_sts_cd[i]);  

				//0163
				if (copyBseQtrCd[i] != null)
					model.setCopyBseQtrCd(copyBseQtrCd[i]);
				if (condStsCd[i] != null)
					model.setCondStsCd(condStsCd[i]);
				if (copyBseYr[i] != null)
					model.setCopyBseYr(copyBseYr[i]);
				
				//0048, 0075
				if (ofc_Cd[i] != null)
					model.setOfc_Cd(ofc_Cd[i]);
				if (bse_quarter[i] != null)
					model.setBse_quarter(bse_quarter[i]);
				if (trade_group[i] != null)
					model.setTrade_group(trade_group[i]);
				if (pfmc_fr_year[i] != null)
					model.setPfmc_fr_year(pfmc_fr_year[i]);
				if (pfmc_fr_month[i] != null)
					model.setPfmc_fr_month(pfmc_fr_month[i]);
				if (pfmc_to_year[i] != null)
					model.setPfmc_to_year(pfmc_to_year[i]);
				if (pfmc_to_month[i] != null)
					model.setPfmc_to_month(pfmc_to_month[i]);
				if (subTrade[i] != null)
					model.setSubTrade(subTrade[i]);
				if (targetMonth[i] != null)
					model.setTargetMonth(targetMonth[i]);
				if (edit_mode[i] != null)
					model.setEdit_mode(edit_mode[i]);
				if (glineVerNo[i] != null)
					model.setGlineVerNo(glineVerNo[i]);
				if (mQtaVerNo[i] != null)
					model.setMQtaVerNo(mQtaVerNo[i]);
				if (slsFcastPubNo[i] != null)
					model.setSlsFcastPubNo(slsFcastPubNo[i]);
				if (ctrt_rhq_cd[i] != null)
					model.setCtrt_rhq_cd(ctrt_rhq_cd[i]);
				if (search_sub_trd_cd[i] != null)
					model.setSearch_sub_trd_cd(search_sub_trd_cd[i]);
				if (search_rlane_cd[i] != null)
					model.setSearch_rlane_cd(search_rlane_cd[i]);
				if (saq_sts_cd[i] != null)
					model.setSaq_sts_cd(saq_sts_cd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (newStatusCd[i] != null)
					model.setNewStatusCd(newStatusCd[i]);
				if (newVersion[i] != null)
					model.setNewVersion(newVersion[i]);
				if (newStepCd[i] != null)
					model.setNewStepCd(newStepCd[i]);
				if (currMqtaStepCd[i] != null)
					model.setCurrMqtaStepCd(currMqtaStepCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (condStepCd[i] != null)
					model.setCondStepCd(condStepCd[i]);
				if (gline_ver_no[i] != null)
					model.setGline_ver_no(gline_ver_no[i]);
				if (mqta_step_cd[i] != null)
					model.setMqta_step_cd(mqta_step_cd[i]);
				if (bse_yr[i] != null)
					model.setBse_yr(bse_yr[i]);
				if (bse_qtr_cd[i] != null)
					model.setBse_qtr_cd(bse_qtr_cd[i]);
				if (trd_cd[i] != null)
					model.setTrd_cd(trd_cd[i]);
				if (dir_cd[i] != null)
					model.setDir_cd(dir_cd[i]);
				if (mqta_ver_no[i] != null)
					model.setMqta_ver_no(mqta_ver_no[i]);
				if (unit_tp[i] != null)
					model.setUnit_tp(unit_tp[i]);
				if (qtaMstVerNo[i] != null)
					model.setQtaMstVerNo(qtaMstVerNo[i]);
				if (tradeGroupCd[i] != null)
					model.setTradeGroupCd(tradeGroupCd[i]);
				if (mQtaStepCd[i] != null)
					model.setMQtaStepCd(mQtaStepCd[i]);
				if (rhq_cd[i] != null)
					model.setRhq_cd(rhq_cd[i]);
				if (org[i] != null)
					model.setOrg(org[i]);
				if (newVersionNo[i] != null)
					model.setNewVersionNo(newVersionNo[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (sls_rhq_cd[i] != null)
					model.setSls_rhq_cd(sls_rhq_cd[i]);
				
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);				
				if (aq_cd[i] != null)
					model.setAq_Cd(aq_cd[i]);
				if (new_rlane_cd[i] != null)
					model.setNew_Rlane_Cd(new_rlane_cd[i]);	
				//0181
				if (from_mon[i] != null)
					model.setFrom_mon(from_mon[i]);
				if (to_mon[i] != null)
					model.setTo_mon(to_mon[i]);
				
				//0187
				if (yQtaStepCd[i] != null)
					model.setYQtaStepCd(yQtaStepCd[i]);
				if (yQtaVerNo[i] != null)
					model.setYQtaVerNo(yQtaVerNo[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqlNameVO[]
	 */
	public QuotaConditionVO[] getConditionVOs(){
		QuotaConditionVO[] vos = (QuotaConditionVO[])models.toArray(new QuotaConditionVO[models.size()]);
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
		// Yearly Inquiry 
		this.slsAqCd = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtAqCd = this.ctrtAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetGrpChild = this.targetGrpChild .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeChild = this.tradeChild .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetGrp = this.targetGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.version = this.version .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrade = this.subTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCdChild = this.dirCdChild .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quarter = this.quarter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp_flg = this.grp_flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.step = this.step .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrade = this.repTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaVerNo = this.yqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheet_check = this.sheet_check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isZeroLoad = this.isZeroLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaMdlVerNo = this.yqtaMdlVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnScnrNo = this.plnScnrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqStsCd = this.saqStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f_cmd = this.f_cmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opfitAmt = this.opfitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxLod = this.maxLod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minLod = this.minLod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts00 = this.sts00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsOthers = this.stsOthers .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclPortFlag = this.inclPortFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaMdlVerNo = this.mqtaMdlVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetGroup = this.targetGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kamer_id = this.kamer_id .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRhqCd = this.ctrtRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRgnOfcCd = this.ctrtRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboVersion = this.comboVersion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeGroup = this.tradeGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editMode = this.editMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calc1 = this.calc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calc2 = this.calc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabIdx = this.tabIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yqtaStepCd = this.yqtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.mqtaRlseVerNo  =  this.mqtaRlseVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.bseYr         	=  this.bseYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");         
		this.bseMon        	=  this.bseMon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");        
		this.fmBseWk       	=  this.fmBseWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");       
		this.toBseWk       	=  this.toBseWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");       
		this.ofcOfcCd      	=  this.ofcOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");      
		this.trdCd 	        =  this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 	       
		this.rbQtaTgtCd     =  this.rbQtaTgtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");    
		this.grsRpbRev 	    =  this.grsRpbRev.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 	   
		this.cm 	        =  this.cm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 	       
		this.cfmSts 	    =  this.cfmSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 	   
		this.qtaTgtCd 	    =  this.qtaTgtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 	   

		//0163
		this.copyBseQtrCd = this.copyBseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condStsCd = this.condStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyBseYr = this.copyBseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		//0048, 0075
		this.ofc_Cd            = this.ofc_Cd           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse_quarter       = this.bse_quarter      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade_group       = this.trade_group      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc_fr_year      = this.pfmc_fr_year     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc_fr_month     = this.pfmc_fr_month    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc_to_year      = this.pfmc_to_year     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc_to_month     = this.pfmc_to_month    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetMonth       = this.targetMonth      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edit_mode         = this.edit_mode        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineVerNo        = this.glineVerNo       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mQtaVerNo         = this.mQtaVerNo        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsFcastPubNo     = this.slsFcastPubNo    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrt_rhq_cd       = this.ctrt_rhq_cd      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.search_sub_trd_cd = this.search_sub_trd_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.search_rlane_cd   = this.search_rlane_cd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saq_sts_cd        = this.saq_sts_cd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCommand        = this.chkCommand       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId          = this.creUsrId         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId          = this.updUsrId         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg           = this.deltFlg          .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd          = this.statusCd         .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newStatusCd       = this.newStatusCd      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVersion        = this.newVersion       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newStepCd         = this.newStepCd        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currMqtaStepCd    = this.currMqtaStepCd   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condStepCd        = this.condStepCd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline_ver_no      = this.gline_ver_no     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqta_step_cd      = this.mqta_step_cd     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse_yr            = this.bse_yr           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse_qtr_cd        = this.bse_qtr_cd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trd_cd            = this.trd_cd           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir_cd            = this.dir_cd           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqta_ver_no       = this.mqta_ver_no      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit_tp           = this.unit_tp          .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaMstVerNo       = this.qtaMstVerNo      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaMstVerNo       = this.qtaMstVerNo      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd           = this.rlaneCd          .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mQtaStepCd        = this.mQtaStepCd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq_cd            = this.rhq_cd           .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org               = this.org              .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVersionNo      = this.newVersionNo     .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mQtaStepCd        = this.mQtaStepCd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd       = this.slsRgnOfcCd      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd 			   = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.aq_cd 			   = this.aq_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.new_rlane_cd 	   = this.new_rlane_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//0181
		this.from_mon 		   = this.from_mon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.to_mon 	   	   = this.to_mon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//0187
		this.yQtaStepCd        = this.yQtaStepCd       .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yQtaVerNo         = this.yQtaVerNo        .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}


}
