/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTBalanceChargeCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeDataVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;

/**
 * Balance calculation function <br>
 *
 * @author
 * @see DMTCalculationDBDAO class reference
 * @since J2EE 1.4
 */
public class DMTBalanceChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null;
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtilCreate object<br>
	 * DMTCalculationDBDAO Creation<br>
	 */
	public DMTBalanceChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	/**
	 *  balanceChargeCalculation Search
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO balanceChargeCalculation(ChargeCalculationParmVO chargeCalculationParmVO) throws EventException{
		
		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
		FixPOLLocationParmVO fixPOLLocationParmVO = new FixPOLLocationParmVO();
		FixPODLocationParmVO fixPODLocationParmVO = new FixPODLocationParmVO();
		OverdayNStatusParmVO overdayNStatusParmVO = new OverdayNStatusParmVO();
		OverdayNDivParmVO 	 overdayNDivParmVO    = new OverdayNDivParmVO();
		CalculationParmVO 	 calculationParmVO 	  = new CalculationParmVO();
		ExchangeRateParmVO 	 exchangeRateParmVO   = new ExchangeRateParmVO();
		
		String zSvrId	  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());				/*	Server ID			*/
		String zCntrNo    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zDttCode   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zLocDiv    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		long   zDccSeq 	  = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getChgSeq());
		String zDcFmDate  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcFmCnms  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToDate  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
		String zDcToCnms  = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		
		log.debug("***********************************************************");
		log.debug("[ChargeCalculationParmVO]>> zSvrId 		:"+ zSvrId);
		log.debug("[ChargeCalculationParmVO]>> zCntrNo 		:"+ zCntrNo);
		log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo 	:"+ zCnmvCycNo);
		log.debug("[ChargeCalculationParmVO]>> zDttCode 	:"+ zDttCode);
		log.debug("[ChargeCalculationParmVO]>> zLocDiv 		:"+ zLocDiv);
		log.debug("[ChargeCalculationParmVO]>> zDccSeq	 	:"+ zDccSeq);
		log.debug("[ChargeCalculationParmVO]>> zDcFmDate 	:"+ zDcFmDate);
		log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd 	:"+ zDcFmYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcFmCnms 	:"+ zDcFmCnms);
		log.debug("[ChargeCalculationParmVO]>> zDcToDate 	:"+ zDcToDate);
		log.debug("[ChargeCalculationParmVO]>> zDcToYdCd 	:"+ zDcToYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcToCnms 	:"+ zDcToCnms);
		log.debug("*************************************************************");
		
		/////////////////////START   defind variables    /////////////////
		
		String		zOfcCd				= "";
		String		zOfcRhq				= "";
		String		zPorLoc				= "";
		String		zPolLoc				= "";
		String		zPodLoc				= "";
		String		zDelLoc				= "";
		
		String		zPostRly			= "";
		String		fixPodLoc			= "";
		String		zVslCd				= "";
		String		zSkdVoyageNo		= "";
		String		zSkdDirCd			= "";
		long		zDtnSeq				= 0 ;
		long		zDtgGrpId			= 0 ;
		String		zCurCd				= "";
		long		zDcFtDays			= 0 ;
		String		zDcFtCmnc			= "";
		String		zDcFtEnd			= "";
		long		zDcFtOver			= 0 ;
		String		zDcStatus			= "";
		long		zDcOrgOver			= 0 ;
		long		zDcBfrOver			= 0 ;
		long		zDcAftOver			= 0 ;
		String		zDcApplRate			= "";
		double		zDcOrgAmt			= 0 ;
		double		zDcExpAmt			= 0 ;
		double		zDcDscAmt			= 0 ;
		double		zDcBillAmt			= 0 ;
		double		zDcBfrAmt			= 0 ;
		double		zDcAftAmt			= 0 ;
		
		String 		zScNo				= "";   
		long   		zScVerSeq			= 0;                                             
		long   		zScGrpSeq			= 0;	
		String		dsdCurCd			= "";
		
		String 		bzcTrfAplyDt 	    = ""; 
		String      zBkgNo				= ""; 
		
		String 		zRfaApprNo			= ""; 
		String 		zRfaDarNo			= ""; 
		long		zRfaMapgSeq			= 0;  
		long		zRfaVerSeq			= 0;  
		long		zRfaDtlSeq			= 0;  
		long	 	zCmbSeq				= 0;  
		String		dbdCurCd			= "";
		String		zCntrtsCd			= "";
		String		zDbcIoBnd			= "";
		long		rateDtlCnt			= 0;
		double		getBfrExRate		= 1.0;	
		long		divOverDay			= 0;	
		String		zFixedVlDt			= "";	
		String		zWebMtDate			= "";
		String		fixPolLoc			= "";
		String		zPreRly				= "";
		String      zDccTrsInd          = "";
		List<String> cstopNoList 		= null;
		long		idxCstop			= 0;
		String		zScRfaExptAplyDt	= ""; 
		
		//////////////////////END   defind variables    ///////////////// 
		
		List<ChargeDataVO> chargeData = null;
		
		try {
			chargeData = dbDao.getChargeData(chargeCalculationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Bal - Chrg Data Select Error ! SQL:  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("Bal - Chrg Data Select Error ! SQL: " + e.getMessage());
		}

		if (chargeData!=null && chargeData.size()>0){
			log.debug("\n\n @@@@@ dbDao.getChargeData size>0 - "+(chargeData!=null?chargeData.size():0)+" @@@@@@@@@@@@@ \n\n");
			ChargeDataVO tmp = chargeData.get(0);
			if (tmp!=null){
				log.debug("\n\n @@@@@ dbDao.getChargeData : ChargeDataVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
				zDcApplRate 	= DMTCalculationUtil.nullToString(tmp.getZDcApplRate()); //z_dc_appl_rate
				zCurCd 			= DMTCalculationUtil.nullToString(tmp.getZCurCd());    //z_cur_cd
				zOfcRhq 		= DMTCalculationUtil.nullToString(tmp.getZOfcRhq());    //z_ofc_rhq
				zDtnSeq 		= DMTCalculationUtil.stringToLong(tmp.getZDtnSeq());    //z_dtn_seq
				zDtgGrpId 		= DMTCalculationUtil.stringToLong(tmp.getZDtgGrpId());    //z_dtg_grp_id
				zRfaApprNo 		= DMTCalculationUtil.nullToString(tmp.getZRfaApprNo());    //z_rfa_appr_no
				zRfaDarNo 		= DMTCalculationUtil.nullToString(tmp.getZRfaDarNo());    //z_rfa_dar_no
				zRfaMapgSeq 	= DMTCalculationUtil.stringToLong(tmp.getZRfaMapgSeq());    //z_rfa_mapg_seq
				zRfaVerSeq 		= DMTCalculationUtil.stringToLong(tmp.getZRfaVerSeq());    //z_rfa_ver_seq
				zRfaDtlSeq 		= DMTCalculationUtil.stringToLong(tmp.getZRfaDtlSeq());    //z_rfa_dtl_seq
				zScNo 			= DMTCalculationUtil.nullToString(tmp.getZScNo());    //z_sc_no
				zScVerSeq 		= DMTCalculationUtil.stringToLong(tmp.getZScVerSeq());    //z_sc_ver_seq
				zScGrpSeq 		= DMTCalculationUtil.stringToLong(tmp.getZScGrpSeq());    //z_sc_grp_seq
				zScRfaExptAplyDt= DMTCalculationUtil.nullToString(tmp.getZScRfaExptAplyDt());    //2011.01.24.
				zDbcIoBnd 		= DMTCalculationUtil.nullToString(tmp.getZDbcIoBnd());    //z_dbc_io_bnd
				zCntrtsCd 		= DMTCalculationUtil.nullToString(tmp.getZCntrtsCd());    //z_cntrts_cd
				zVslCd 			= DMTCalculationUtil.nullToString(tmp.getZVslCd());    //z_vsl_cd
				zSkdVoyageNo 	= DMTCalculationUtil.nullToString(tmp.getZSkdVoyageNo());    //z_skd_voyage_no
				zSkdDirCd 		= DMTCalculationUtil.nullToString(tmp.getZSkdDirCd());    //z_skd_dir_cd
				zPolLoc 		= DMTCalculationUtil.nullToString(tmp.getZPolLoc());    //z_pol_loc
				zPodLoc 		= DMTCalculationUtil.nullToString(tmp.getZPodLoc());    //z_pod_loc
				zPorLoc 		= DMTCalculationUtil.nullToString(tmp.getZPorLoc());    //z_por_loc
				zDelLoc 		= DMTCalculationUtil.nullToString(tmp.getZDelLoc());    //z_del_loc
				zPostRly 		= DMTCalculationUtil.nullToString(tmp.getZPostRly());    //z_post_rly
				zPreRly 		= DMTCalculationUtil.nullToString(tmp.getZPreRly());    //z_pre_rly
				dbdCurCd 		= DMTCalculationUtil.nullToString(tmp.getZRfaCurCd());    //z_rfa_cur_cd
				dsdCurCd 		= DMTCalculationUtil.nullToString(tmp.getZScCurCd());    //z_sc_cur_cd
				bzcTrfAplyDt    = DMTCalculationUtil.nullToString(tmp.getBzcTrfAplyDt());    //bzc_trf_aply_dt
				zBkgNo		    = DMTCalculationUtil.nullToString(tmp.getZBkgNo());    //z_bkg_no
				zDccTrsInd		= DMTCalculationUtil.nullToString(tmp.getZDccTrsInd());    //Z_DCC_TRS_IND			
			}
		}
		else {log.debug("\n\n @@@@@ dbDao.getChargeData size=0 @@@@@@@@@@@@@ \n\n");}		
//		zDcApplRate 	= DMTCalculationUtil.nullToString(chargeDataMap.get("z_dc_appl_rate"));
//		zCurCd 			= DMTCalculationUtil.nullToString(chargeDataMap.get("z_cur_cd"));
//		//zOfcCd 			= DMTCalculationUtil.nullToString(chargeDataMap.get("z_ofc_cd"));
//		zOfcRhq 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_ofc_rhq"));
//		zDtnSeq 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_dtn_seq"));
//		zDtgGrpId 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_dtg_grp_id"));
//
//		zRfaApprNo 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_rfa_appr_no"));
//		zRfaDarNo 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_rfa_dar_no"));
//		zRfaMapgSeq 	= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_rfa_mapg_seq"));
//		zRfaVerSeq 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_rfa_ver_seq"));
//		zRfaDtlSeq 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_rfa_dtl_seq"));
//		
//		zScNo 			= DMTCalculationUtil.nullToString(chargeDataMap.get("z_sc_no"));
//		zScVerSeq 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_sc_ver_seq"));
//		zScGrpSeq 		= DMTCalculationUtil.stringToLong(chargeDataMap.get("z_sc_grp_seq"));
//		
//		zDbcIoBnd 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_dbc_io_bnd"));
//		zCntrtsCd 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_cntrts_cd"));
//		zVslCd 			= DMTCalculationUtil.nullToString(chargeDataMap.get("z_vsl_cd"));
//		zSkdVoyageNo 	= DMTCalculationUtil.nullToString(chargeDataMap.get("z_skd_voyage_no"));
//		zSkdDirCd 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_skd_dir_cd"));
//		zPolLoc 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_pol_loc"));
//		zPodLoc 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_pod_loc"));
//		zPorLoc 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_por_loc"));
//		zDelLoc 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_del_loc"));
//		zPostRly 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_post_rly"));
//		zPreRly 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_pre_rly"));
//		dbdCurCd 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_rfa_cur_cd"));
//		dsdCurCd 		= DMTCalculationUtil.nullToString(chargeDataMap.get("z_sc_cur_cd"));
//		
//		bzcTrfAplyDt    = DMTCalculationUtil.nullToString(chargeDataMap.get("bzc_trf_aply_dt"));
//		zBkgNo		    = DMTCalculationUtil.nullToString(chargeDataMap.get("z_bkg_no"));
//		
//		zDccTrsInd		= DMTCalculationUtil.nullToString(chargeDataMap.get("Z_DCC_TRS_IND")); 

		
		// 2015.02.24
//		if(zDttCode.equals("DMIF") && zDcFmYdCd.substring(0,2).equals("US")) {
//			String evntDt = null;
//			try {
//				evntDt = dbDao.searchNTdate(zCntrNo, zDcFmYdCd, zBkgNo);
//			}catch(Exception e) {
//				log.error("*******************************************************");
//				log.error("searchNTdate Select Error !  "+e.getMessage());
//				log.error("*******************************************************");
//				throw new EventException("searchNTdate Select Error ! " + new ErrorHandler(e).getMessage());
//			}
//			if(evntDt!=null) {
//				zDcFmDate = evntDt;
//			}
//		}
	
	
		log.debug("*****************************************************************");
		log.debug("*[ Balance - searchNTdate  ] zDcFmDate	:"+zDcFmDate		);
		
		log.debug("*[ Balance - getChargeData ] zDcApplRate	:"+zDcApplRate		);
		log.debug("*[ Balance - getChargeData ] zCurCd 		:"+zCurCd			);
		log.debug("*[ Balance - getChargeData ] zOfcRhq 	:"+zOfcRhq			);
		log.debug("*[ Balance - getChargeData ] zDtnSeq 	:"+zDtnSeq			);
		log.debug("*[ Balance - getChargeData ] zDtgGrpId 	:"+zDtgGrpId		);
		
		log.debug("*[ Balance - getChargeData ] zRfaApprNo 	:"+zRfaApprNo		);
		log.debug("*[ Balance - getChargeData ] zRfaDarNo 	:"+zRfaDarNo		);
		log.debug("*[ Balance - getChargeData ] zRfaMapgSeq :"+zRfaMapgSeq		);
		log.debug("*[ Balance - getChargeData ] zRfaVerSeq 	:"+zRfaVerSeq		);
		log.debug("*[ Balance - getChargeData ] zRfaDtlSeq 	:"+zRfaDtlSeq		);
		log.debug("*[ Balance - getChargeData ] zCmbSeq 	:"+zCmbSeq			);
		
		log.debug("*[ Balance - getChargeData ] zScNo 		:"+zScNo			);
		log.debug("*[ Balance - getChargeData ] zScVerSeq 	:"+zScVerSeq		);
		log.debug("*[ Balance - getChargeData ] zScGrpSeq 	:"+zScGrpSeq		);
		
		log.debug("*[ Balance - getChargeData ] zDbcIoBnd 	:"+zDbcIoBnd		);
		log.debug("*[ Balance - getChargeData ] zCntrtsCd 	:"+zCntrtsCd		);
		log.debug("*[ Balance - getChargeData ] zVslCd		:"+zVslCd			);
		log.debug("*[ Balance - getChargeData ] zSkdVoyageNo:"+zSkdVoyageNo		);
		log.debug("*[ Balance - getChargeData ] zSkdDirCd 	:"+zSkdDirCd		);
		log.debug("*[ Balance - getChargeData ] zPolLoc 	:"+zPolLoc			);
		log.debug("*[ Balance - getChargeData ] zPodLoc 	:"+zPodLoc			);
		log.debug("*[ Balance - getChargeData ] zPorLoc 	:"+zPorLoc			);
		log.debug("*[ Balance - getChargeData ] zDelLoc 	:"+zDelLoc			);
		log.debug("*[ Balance - getChargeData ] zPostRly 	:"+zPostRly			);
		log.debug("*[ Balance - getChargeData ] zPreRly 	:"+zPreRly			);
		log.debug("*[ Balance - getChargeData ] dbdCurCd 	:"+dbdCurCd			);
		log.debug("*[ Balance - getChargeData ] dsdCurCd	:"+dsdCurCd			);
		
		log.debug("*[ Balance - getChargeData ] bzcTrfAplyDt:"+bzcTrfAplyDt		);
		log.debug("*[ Balance - getChargeData ] zBkgNo		:"+zBkgNo			);
		log.debug("*[ Balance - getChargeData ] zDccTrsInd	:"+zDccTrsInd		);
		log.debug("*****************************************************************");
	

		OfficeInfoVO officeInfoVO = null;
		try {
			officeInfoVO = dbDao.searchOfficeInfoByFmYardCd(zDbcIoBnd, zDcFmYdCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Exception]>> DEM/DET Office Select Error ! : ("+zDcFmYdCd+ " ) " );
			log.error("*******************************************************");
			throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
		}

		log.debug("*******************************************************");
		log.debug("[DEM/DET Office Setting]>> officeInfoVO.getCollectYn() : "+ officeInfoVO.getCollectYn());
		log.debug("*******************************************************");
		
		if(DMTCalculationUtil.nullToString(officeInfoVO.getCollectYn()).equals("")){
			log.debug("*******************************************************");
			log.debug("[officeInfoVO is null !  88 DEM/DET Office Skip !");
			log.debug("*******************************************************");
			chargeCalculationContainerVO.setMsgCd("88");
			chargeCalculationContainerVO.setMsgDesc("DEM/DET Office Skip ! : ("+zDcFmYdCd+ " ) " );
			
			return chargeCalculationContainerVO;
		} else {
			
				zOfcCd = officeInfoVO.getOfcCd();
				zOfcRhq = officeInfoVO.getOfcRhq();
				
				log.debug("*******************************************************");
				log.debug("[ Office/RHQ ]  "+officeInfoVO.getOfcCd()+" "+ officeInfoVO.getOfcRhq()+" "+ zDcFmYdCd);
				log.debug("*******************************************************");
		}
		log.debug("*******************************************************");
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcCd 		: "+ officeInfoVO.getOfcCd());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getCollectYn 	: "+ officeInfoVO.getCollectYn());
		log.debug("[searchOfficeInfoByFmYardCd] officeInfoVO.getOfcRhq 		: "+ officeInfoVO.getOfcRhq());
		log.debug("*******************************************************");
	
	
		/*		
		[logic] 
		*/

		String rtnSvrId = "";
		try {
			rtnSvrId = dbDao.searchSvrId(zOfcCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Select Sever ID Error ! : ("+zOfcCd+ " ) " );
			log.error("*******************************************************");
			throw new EventException("Select Sever ID Error ! : " + new ErrorHandler(e).getMessage());
		}

		log.debug("*******************************************************");
		log.debug("[return: Select Sever ID]>> rtnSvrId : "+ rtnSvrId);
		log.debug("*******************************************************");
		
		
		
		
		/*		
		[logic] POD Loc Fix  
		*/
		fixPODLocationParmVO.setPodCd(zPodLoc);
		fixPODLocationParmVO.setDelCd(zDelLoc);
		fixPODLocationParmVO.setPostRly(zPostRly);
		fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 
		fixPodLoc = dmtCalculationUtil.fixPODLocation(fixPODLocationParmVO);
		
		log.debug("*******************************************************");
		log.debug("[fixPODLocation] fixPodLoc : "+ fixPodLoc);
		log.debug("*******************************************************");
		
		/*	
		[logic] POL Loc Fix
		*/
		
		fixPOLLocationParmVO.setPorCd(zPorLoc);
		fixPOLLocationParmVO.setPolCd(zPolLoc);
		fixPOLLocationParmVO.setPreRly(zPreRly);
		fixPOLLocationParmVO.setBkgNo(zBkgNo); //2010.03.26
		fixPolLoc = dmtCalculationUtil.fixPOLLocation(fixPOLLocationParmVO);
		
		log.debug("*******************************************************");
		log.debug("[fixPOLLocation] fixPolLoc : "+ fixPolLoc);
		log.debug("*******************************************************");
		
		/*		
		[logic] Set FT CMNC, FT END  
		*/
		
		zDcFtDays 	= 0;

		zDcFtCmnc 	= zDcFmDate;
		zDcFtEnd  	= zDcFmDate;
	
		/*	
		[logic] VL(To Date) Change
		*/
		if(	( zDttCode.equals("DMOF" ) || zDttCode.equals("CTOC")) && zDcToCnms.equals("VL")){

			try {
				zFixedVlDt = dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, 
													zDcToYdCd, "", "to");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Fixed VL Date Select Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Fixed VL Date Select Error:" + new ErrorHandler(e).getMessage());
			}

		}
	
		if( zFixedVlDt.length() != 0 ){
			zDcToDate = zFixedVlDt;
		}
		log.debug("*******************************************************");
		log.debug("* [VL(To Date) Change ] zFixedVlDt 	:"+zFixedVlDt);
		log.debug("* [VL(To Date) Change ] zDcToDate 	:"+zDcToDate);
		log.debug("*******************************************************");
	
		/*
		[logic] Get Grace Period Overday 
		*/
		try {
			zWebMtDate =	dmtCalculationUtil.getMTNotify(zSvrId, zCntrNo, zCnmvCycNo, zDttCode, zDcFmCnms);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Get MT Notification Function Error:"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Get MT Notification Function Error:" + new ErrorHandler(e).getMessage());
		}

		
		log.debug("*******************************************************");
		log.debug("* [ Get Grace Period Overday ] zWebMtDate "+zWebMtDate);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Basic Overday 
		 */
		/* Init Clock Stop Ary */
		cstopNoList = new ArrayList<String>();
		idxCstop = 0;
		
		zDcFtOver = 0;
		
		// 2012.02.15		
		BkgContainerInfoVO bkgContainerInfoVO = null;
		
		try {
			bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo, zCntrNo, zDcFmYdCd, "");
			if(DMTCalculationUtil.nullToString(bkgContainerInfoVO.getIbflag()).equals("NoDataFound")){
				log.error("*******************************************************");
				log.error("[Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
				log.error("*******************************************************");
				chargeCalculationContainerVO.setMsgCd("2");
				chargeCalculationContainerVO.setMsgDesc("Invalid BKG No(No Data Found) ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
				chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
				
				return chargeCalculationContainerVO;
			}			
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("[Invalid BKG No ! : "+zBkgNo +", "+ zCntrNo +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("[Invalid BKG No ! : " + new ErrorHandler(e).getMessage());
		}
	
		String zYrdCntCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCntCd());
		String zYrdRgnCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdRgnCd());
		String zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdSteCd());
		String zYrdLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
		String zRcvTermCd	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcvTermCd());
		String zDeTermCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		
		overdayNStatusParmVO.setToDate(zDcToDate);
		overdayNStatusParmVO.setFtimeEnd(zDcFtEnd);
		overdayNStatusParmVO.setDttCode(zDttCode);
		overdayNStatusParmVO.setOfcCd(zOfcCd);
		overdayNStatusParmVO.setMtDate(zWebMtDate);
		overdayNStatusParmVO.setCstopIdx(String.valueOf(idxCstop));
		overdayNStatusParmVO.setCStopNoList(cstopNoList);
		
		//2012.02.15
		overdayNStatusParmVO.setIoBndCd(zDbcIoBnd);
		overdayNStatusParmVO.setBkgDeTermCd(zDeTermCd);
		overdayNStatusParmVO.setBkgRcvTermCd(zRcvTermCd);
		overdayNStatusParmVO.setBkgCntCd(zYrdCntCd);
		overdayNStatusParmVO.setBkgRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setBkgStateCd(zYrdStateCd);
		overdayNStatusParmVO.setBkgLocCd(zYrdLoc);
		overdayNStatusParmVO.setYrdCntCd(zYrdCntCd);
		overdayNStatusParmVO.setYrdRgnCd(zYrdRgnCd);
		overdayNStatusParmVO.setYrdStateCd(zYrdStateCd);
		overdayNStatusParmVO.setYrdLocCd(zYrdLoc);
		overdayNStatusParmVO.setSvrId(zSvrId);
		overdayNStatusParmVO.setYardCd(zDcFmYdCd);
		
		OverdayNStatusVO overdayNStatusVO = null;
		try {
			overdayNStatusVO = dmtCalculationUtil.overdayNStatus(overdayNStatusParmVO);
			zDcFtOver  = DMTCalculationUtil.stringToLong(overdayNStatusVO.getOverDay());
			zDcOrgOver = zDcFtOver;
			zDcStatus   = DMTCalculationUtil.nullToString(overdayNStatusVO.getStatus());
			idxCstop 	  = DMTCalculationUtil.stringToLong(overdayNStatusVO.getCstopIdx());
			cstopNoList = overdayNStatusVO.getCStopNoList();
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("* Bal - overdayNStatus Function Error:"+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("* Bal - overdayNStatus Function Error:" + new ErrorHandler(e).getMessage());
		}
	
		log.debug("*******************************************************");
		log.debug("* [ Bal - BSC overdayNStatus ] zDcOrgOver :"+zDcOrgOver);
		log.debug("* [ Bal - BSC overdayNStatus ] zDcStatus 	:"+zDcStatus);
		log.debug("* [ Bal - BSC overdayNStatus ] idxCstop 	:"+idxCstop);
		log.debug("* [ Bal - BSC overdayNStatus ] cstopNoList :"+cstopNoList);
		log.debug("*******************************************************");
		
		/*
		[logic] Get Amount
		 */
		zDcOrgAmt 	= 0;
		zDcExpAmt 	= 0;
		zDcDscAmt 	= 0;
		zDcBillAmt 	= 0;

		zDcBfrAmt 	= 0;
		zDcAftAmt 	= 0;
		
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO(); 
		
		if( zDcStatus.equals("L") || zDcStatus.equals("F") ){

			/* _________Get OverdayDiv */
			
			overdayNDivParmVO.setSvrId(zSvrId);
			overdayNDivParmVO.setCntrNo(zCntrNo);
			overdayNDivParmVO.setCnmvCycNo(String.valueOf(zCnmvCycNo));
			overdayNDivParmVO.setDttCode(zDttCode);
			overdayNDivParmVO.setLocDiv(zLocDiv);
			overdayNDivParmVO.setDccSeq(String.valueOf(zDccSeq));
	
			OverdayNDivVO overdayNDivVO = null;
			try {
				overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - get OverdayDiv Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - get OverdayDiv Error:" + new ErrorHandler(e).getMessage());
			}
	
			{
				divOverDay 	= DMTCalculationUtil.stringToLong(overdayNDivVO.getDivOverDay());
			}
			
			log.debug("*******************************************************");
			log.debug("* [Bal Cal - get OverdayDiv ] divOverDay "+divOverDay);
			log.debug("*******************************************************");

			/* ------------------------------------------------ Basic Amt */
			
			
			/**
			 * 2010-09-10 : SvrId 설정  change (zDcFmYdCd로 COM_SYS_AREA_GRP_ID table에서 조회하여 SvrId조회하기로  change)
			 */
			log.debug("\n\n zDcFmYdCd:"+zDcFmYdCd+" \n\n");
			String bscSvrId = "";
			try {
				bscSvrId = dmtCalculationUtil.searchBscSvrId(zDcFmYdCd);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - searchBscSvrId Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - searchBscSvrId Error:" + new ErrorHandler(e).getMessage());
			}

			calculationParmVO.setSvrId(bscSvrId);
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
			calculationParmVO.setDivOverDay(String.valueOf(divOverDay));
			
			try {
				calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
				zDcOrgAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Bal Cal - basicCalculation Function Error:"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Bal Cal - basicCalculation Function Error:" + new ErrorHandler(e).getMessage());
			}


			zDcBillAmt = zDcOrgAmt;

			log.debug("*******************************************************");
			log.debug("* [ Bal - ORG AMT ] zDcOrgAmt "+zDcOrgAmt);
			log.debug("*******************************************************");

			/* ----------------------------------------------- BFR Amt */

			if(  zDcApplRate.equals("S") ){

				calculationParmVO.setPropNo(zScNo);
				calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
				calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
				
				calculationParmVO.setCntrts(zCntrtsCd);
				calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
				calculationParmVO.setDivOverDay(String.valueOf(divOverDay));	
				try {
					calculationAMTVO = dmtCalculationUtil.scCalculation(calculationParmVO);
					zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
					rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* Bal Cal - scCalculation Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("* Bal Cal - scCalculation Function Error:" + new ErrorHandler(e).getMessage());
				}


				if( !zCurCd.equals(dsdCurCd) ){
					exchangeRateParmVO.setPolLoc(fixPolLoc);
					exchangeRateParmVO.setPodLoc(fixPodLoc);
					exchangeRateParmVO.setIoBnd(zDbcIoBnd);
					exchangeRateParmVO.setVslCd(zVslCd);
					exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
					exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
					exchangeRateParmVO.setFmCurCd(dsdCurCd);
					exchangeRateParmVO.setToCurCd(zCurCd);
					exchangeRateParmVO.setOfcCd(zOfcCd);
					try {
						getBfrExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
						zDcBfrAmt = zDcBfrAmt * getBfrExRate;
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
					}

				}
				zDcExpAmt = zDcOrgAmt - zDcBfrAmt;		/* Exp Amount Set */
			}
			else if( zDcApplRate.equals("B") ){
				calculationParmVO.setDarNo(zRfaDarNo);
				calculationParmVO.setMapgSeq(String.valueOf(zRfaMapgSeq));
				calculationParmVO.setVerSeq(String.valueOf(zRfaVerSeq));
				calculationParmVO.setDtlSeq(String.valueOf(zRfaDtlSeq));
				calculationParmVO.setCmbSeq(String.valueOf(zCmbSeq));
				
				calculationParmVO.setCntrts(zCntrtsCd);
				calculationParmVO.setOverDay(String.valueOf(zDcFtOver));
				calculationParmVO.setDivOverDay(String.valueOf(divOverDay));	
				
				try {
					calculationAMTVO = dmtCalculationUtil.beforeCalculation(calculationParmVO);
					rateDtlCnt = DMTCalculationUtil.stringToLong(calculationAMTVO.getDtlCnt());
					zDcBfrAmt  = DMTCalculationUtil.stringToDouble(calculationAMTVO.getTotal());
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
				}

				
				if( !zCurCd.equals(dbdCurCd) ){
						
					exchangeRateParmVO.setPolLoc(fixPolLoc);
					exchangeRateParmVO.setPodLoc(fixPodLoc);
					exchangeRateParmVO.setIoBnd(zDbcIoBnd);
					exchangeRateParmVO.setVslCd(zVslCd);
					exchangeRateParmVO.setSkdVoyageNo(zSkdVoyageNo);
					exchangeRateParmVO.setSkdDirCd(zSkdDirCd);
					exchangeRateParmVO.setFmCurCd(dbdCurCd);
					exchangeRateParmVO.setToCurCd(zCurCd);
					exchangeRateParmVO.setOfcCd(zOfcCd);
					try {
						getBfrExRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
						zDcBfrAmt = zDcBfrAmt * getBfrExRate;
					}catch(Exception e) {
						log.error("*******************************************************");
						log.error("* Bal Cal - searchExchangeRate Function Error:"+e.getMessage());
						log.error("*******************************************************");
						throw new EventException("* Bal Cal - searchExchangeRate Function Error:" + new ErrorHandler(e).getMessage());
					}

				}
				zDcExpAmt = zDcOrgAmt - zDcBfrAmt;		/* Exp Amount Set */
			}

			zDcBillAmt = zDcBillAmt - zDcExpAmt;

			log.debug("*************************************************");
			log.debug("* [ Bal - EXP AMT ] zDcExpAmt  :"+zDcExpAmt);
			log.debug("* [ Bal - BIL AMT ] zDcBillAmt :"+zDcBillAmt);
			log.debug("*************************************************");
	
			/* ---------------------------------------------------- AFT Amt */
		}
		
		/* Trim Amount Values */

		zDcOrgAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcOrgAmt);
		zDcExpAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcExpAmt);
		zDcDscAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcDscAmt);
//		zDcBillAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBillAmt);
		zDcBillAmt 	= zDcBillAmt < 0 ? 0 : dmtCalculationUtil.trimCurrencyAmount(zCurCd, zDcBillAmt);
		zDcBfrAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcBfrAmt);
		zDcAftAmt 	= dmtCalculationUtil.trimCurrencyAmount(zCurCd,	zDcAftAmt);
		
		/* Set The chargeCalculationContainerVO */
		log.debug("*******************************************************************");
		log.debug("****  Set The chargeCalculationContainerVO of Balance **************");
		log.debug("* [ChargeCalculationContainerVO ] zDccTrsInd :"+zDccTrsInd);
		log.debug("* [ChargeCalculationContainerVO ] rtnSvrId 	:"+rtnSvrId);
		log.debug("* [ChargeCalculationContainerVO ] zSvrId 	:"+zSvrId);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcFtDays 	:"+zDcFtDays);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtCmnc 	:"+zDcFtCmnc);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtEnd 	:"+zDcFtEnd);
		log.debug("* [ChargeCalculationContainerVO ] zDcFtOver 	:"+zDcFtOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgOver :"+zDcOrgOver);
		
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrOver :"+zDcBfrOver);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftOver :"+zDcAftOver);
		log.debug("* [ChargeCalculationContainerVO ] zCurCd 	:"+zCurCd);
		log.debug("* [ChargeCalculationContainerVO ] zDcApplRate:"+zDcApplRate);
		log.debug("* [ChargeCalculationContainerVO ] zDcOrgAmt 	:"+zDcOrgAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcExpAmt 	:"+zDcExpAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcDscAmt 	:"+zDcDscAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcBillAmt :"+zDcBillAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcStatus 	:"+zDcStatus);
		log.debug("* [ChargeCalculationContainerVO ] zDcBfrAmt 	:"+zDcBfrAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDcAftAmt 	:"+zDcAftAmt);
		log.debug("* [ChargeCalculationContainerVO ] zDtnSeq 	:"+zDtnSeq);
		log.debug("* [ChargeCalculationContainerVO ] zDtgGrpId 	:"+zDtgGrpId);
		log.debug("* [ChargeCalculationContainerVO ] zRfaApprNo :"+zRfaApprNo);
		log.debug("* [ChargeCalculationContainerVO ] zRfaDarNo 	:"+zRfaDarNo);
		log.debug("* [ChargeCalculationContainerVO ] zRfaMapgSeq:"+zRfaMapgSeq);
		log.debug("* [ChargeCalculationContainerVO ] zRfaVerSeq :"+zRfaVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zRfaDtlSeq :"+zRfaDtlSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScRfaExptAplyDt :"+zScRfaExptAplyDt);//2011.01.24
		log.debug("* [ChargeCalculationContainerVO ] zCmbSeq 	:"+zCmbSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScNo 		:"+zScNo);
		log.debug("* [ChargeCalculationContainerVO ] zScVerSeq 	:"+zScVerSeq);
		log.debug("* [ChargeCalculationContainerVO ] zScGrpSeq 	:"+zScGrpSeq);
		log.debug("* [ChargeCalculationContainerVO ] zOfcCd 	:"+zOfcCd);
		log.debug("* [ChargeCalculationContainerVO ] zOfcRhq 	:"+zOfcRhq);
		log.debug("* [ChargeCalculationContainerVO ] zDcToDate 	:"+zDcToDate);
		log.debug("* [ChargeCalculationContainerVO ] setCstopIdx	:"+idxCstop);
		log.debug("* [ChargeCalculationContainerVO ] setCStopNoList :"+cstopNoList);
		if(cstopNoList != null){
			if(cstopNoList.size() > 0){
				for(int i = 0; i < cstopNoList.size(); i++){
					log.debug(" [ChargeCalculationContainerVO ] cstopNoList.get("+i+")]"+cstopNoList.get(i));
				}
			}
		}
		
		log.debug("* [ChargeCalculationContainerVO ] msgCd :"+0);
		log.debug("******************************************************************");
		
		if(zDccTrsInd.equals("Y")){
			chargeCalculationContainerVO.setSvrId(rtnSvrId); 
		} else {
			chargeCalculationContainerVO.setSvrId(zSvrId); 
		}
		
		chargeCalculationContainerVO.setFtDys(String.valueOf(zDcFtDays));
		chargeCalculationContainerVO.setFtCmncDt(zDcFtCmnc);
		chargeCalculationContainerVO.setFtEndDt(zDcFtEnd);
		chargeCalculationContainerVO.setFxFtOvrDys(String.valueOf(zDcFtOver));
		chargeCalculationContainerVO.setOrgFtOvrDys(String.valueOf(zDcOrgOver));
		chargeCalculationContainerVO.setScRfaExptOvrDys(String.valueOf(zDcBfrOver));
		chargeCalculationContainerVO.setAftExptOvrDys(String.valueOf(zDcAftOver));
		chargeCalculationContainerVO.setBzcTrfCurrCd(zCurCd);
		chargeCalculationContainerVO.setDmdtTrfAplyTpCd(zDcApplRate);
		chargeCalculationContainerVO.setOrgChgAmt(String.valueOf(zDcOrgAmt));
		chargeCalculationContainerVO.setScRfaExptAmt(String.valueOf(zDcExpAmt));
		chargeCalculationContainerVO.setAftExptDcAmt(String.valueOf(zDcDscAmt));
		chargeCalculationContainerVO.setBilAmt(String.valueOf(zDcBillAmt));
		chargeCalculationContainerVO.setDmdtChgStsCd(zDcStatus);
		chargeCalculationContainerVO.setScRfaAmt(String.valueOf(zDcBfrAmt));
		chargeCalculationContainerVO.setAftExptAmt(String.valueOf(zDcAftAmt));
		chargeCalculationContainerVO.setBzcTrfSeq(String.valueOf(zDtnSeq));
		chargeCalculationContainerVO.setBzcTrfGrpSeq(String.valueOf(zDtgGrpId));
		chargeCalculationContainerVO.setRfaExptAproNo(zRfaApprNo);
		chargeCalculationContainerVO.setRfaExptDarNo(zRfaDarNo);
		chargeCalculationContainerVO.setRfaExptMapgSeq(String.valueOf(zRfaMapgSeq));
		chargeCalculationContainerVO.setRfaExptVerSeq(String.valueOf(zRfaVerSeq));
		chargeCalculationContainerVO.setRfaRqstDtlSeq(String.valueOf(zRfaDtlSeq));
		chargeCalculationContainerVO.setScRfaExptAplyDt(String.valueOf(zScRfaExptAplyDt));
		chargeCalculationContainerVO.setCvrgCmbSeq(String.valueOf(zCmbSeq));
		chargeCalculationContainerVO.setScNo(zScNo);
		chargeCalculationContainerVO.setScExptVerSeq(String.valueOf(zScVerSeq));
		chargeCalculationContainerVO.setScExptGrpSeq(String.valueOf(zScGrpSeq));
		chargeCalculationContainerVO.setOfcCd(zOfcCd);
		chargeCalculationContainerVO.setOfcRhq(zOfcRhq);
		chargeCalculationContainerVO.setToMvmtDt(zDcToDate);
		chargeCalculationContainerVO.setBzcTrfAplyDt(bzcTrfAplyDt);
		chargeCalculationContainerVO.setCstopIdx(String.valueOf(idxCstop));
		if(cstopNoList != null)  chargeCalculationContainerVO.setCStopNoList(cstopNoList);
		chargeCalculationContainerVO.setMsgCd("0");
		return chargeCalculationContainerVO;
	}
	

}
