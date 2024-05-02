/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChangePODTariffVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CheckWeekEndParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DMIFnDTICFreeTimeEndDateVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtCmdtGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtOCMvmtVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DualTypeExceptionCustInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.StopDaysVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * batch function<br>
 *
 * @author 
 * @see DMTCalculationDBDAO class reference
 * @since J2EE 1.6
 */
public class DMTCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null;
	protected transient Logger log = null;
	
	ContainerCargoTypeVO 		containerCargoTypeVO 	 = new ContainerCargoTypeVO();
	ContainerCargoTypeParmVO 	containerCargoTypeParmVO = new ContainerCargoTypeParmVO();
	ChargeArgumentVO 			chargeArgumentVO 		 = new ChargeArgumentVO();
	

	/**
	 * DMTCalculationUtilCreate object<br>
	 * DMTCalculationDBDAO Creation<br>
	 */
	public DMTCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	/**
	 * searchBscSvrId Search 
	 * @param zDcFmYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchBscSvrId(String zDcFmYdCd) throws DAOException {
		return dbDao.searchBscSvrId(zDcFmYdCd);
	}
	
	/**
	 * searchInOutGauge  Search
	 * @param String zCntrNo  
	 * @param String zBkgNo  
	 * @return String 
	 * @throws DAOException
	 */
	public String searchInOutGauge(String zCntrNo  , String zBkgNo  ) throws DAOException {
		return dbDao.searchAwkInOut(zBkgNo  , zCntrNo  );
	}

	/**
	 * settingContainerCargoType  Search
	 * @param ContainerCargoTypeParmVO containerCargoTypeParmVO
	 * @return ContainerCargoTypeVO
	 * @exception EventException
	 */
	public ContainerCargoTypeVO settingContainerCargoType(ContainerCargoTypeParmVO containerCargoTypeParmVO) {
		
		if(containerCargoTypeParmVO.getRcFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("RFR");
		} else if(containerCargoTypeParmVO.getAwkCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("AWK");
		} else if(containerCargoTypeParmVO.getDcgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("DGR");
		} else if(containerCargoTypeParmVO.getRdCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("DRY");
		} else if(containerCargoTypeParmVO.getSocFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("SOC");
		} else if(containerCargoTypeParmVO.getBbCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("B/B");
		} else {
			containerCargoTypeVO.setCgoTp("DRY");
		} 
		return containerCargoTypeVO;
		
	}

	/**
	 * searchBookingContainerQuantity Search
	 * @param String zBkgNo  
	 * @return int
	 * @exception EventException
	 * @throws DAOException 
	 */
	public int searchBookingContainerQuantity(String zBkgNo  ) throws EventException, DAOException {
		return dbDao.searchBookingContainerQuantity(zBkgNo  );
	}


	/**
	 * setLocationByBound Search
	 * @param LocationByBoundParmVO locationByBoundParmVO
	 * @return LocationByBoundVO
	 * @exception EventException
	 */
	public LocationByBoundVO setLocationByBound(LocationByBoundParmVO locationByBoundParmVO) {
		LocationByBoundVO locationByBoundVO = new LocationByBoundVO();
		
		if(locationByBoundParmVO.getIoBnd().equals("I")){
			locationByBoundVO.setBkgLocCd(locationByBoundParmVO.getDelLocCd());
			locationByBoundVO.setBkgCntCd(locationByBoundParmVO.getDelCntCd());
			locationByBoundVO.setBkgRgnCd(locationByBoundParmVO.getDelRgnCd());
			locationByBoundVO.setBkgStateCd(locationByBoundParmVO.getDelStateCd());
		} else {
			locationByBoundVO.setBkgLocCd(locationByBoundParmVO.getPorLocCd());
			locationByBoundVO.setBkgCntCd(locationByBoundParmVO.getPorCntCd());
			locationByBoundVO.setBkgRgnCd(locationByBoundParmVO.getPorRgnCd());
			locationByBoundVO.setBkgStateCd(locationByBoundParmVO.getPorStateCd());
		}
		return locationByBoundVO;
	}

	/**
	 * fixPODLocation Search
	 * @param FixPODLocationParmVO fixPODLocationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String fixPODLocation(FixPODLocationParmVO fixPODLocationParmVO) throws EventException {
		String	iPodLoc		= nullToString(fixPODLocationParmVO.getPodCd());
		//String	iDelLoc		= nullToString(fixPODLocationParmVO.getDelCd());
		//String	iPostRly	= nullToString(fixPODLocationParmVO.getPostRly());
		String	oPodLoc		= "";
		

		VVDNEtaVO vvdEtaVO = null;
		try {
			vvdEtaVO = dbDao.searchInVVDNEta(fixPODLocationParmVO.getBkgNo(), iPodLoc);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchInVVDNEta Select Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchInVVDNEta Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		
		oPodLoc = iPodLoc;
		
		return oPodLoc;
	}

	/**
	 * fixPOLLocation Search
	 * @param FixPOLLocationParmVO fixPOLLocationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String fixPOLLocation(FixPOLLocationParmVO fixPOLLocationParmVO) throws EventException {
		//String	iPorLoc	= nullToString(fixPOLLocationParmVO.getPorCd());
		String	iPolLoc	= nullToString(fixPOLLocationParmVO.getPolCd());
		//String	iPreRly	= nullToString(fixPOLLocationParmVO.getPreRly());
		String	oPolLoc	= "";
		
		VVDNEtaVO vvdEtaVO = null;
		try {
			vvdEtaVO = dbDao.searchOutVVDNEta(fixPOLLocationParmVO.getBkgNo(), iPolLoc);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchOutVVDNEta Select Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchOutVVDNEta Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		

		
		oPolLoc = iPolLoc;
		
		return oPolLoc;
	}

	/**
	 * searchVVDNEta Search
	 * @param String bookingNo
	 * @param String polCode
	 * @param String podCode
	 * @param String ioBound
	 * @return VVDNEtaVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public VVDNEtaVO searchVVDNEta(String bookingNo, String polCode, 
			String podCode, String ioBound) throws EventException, DAOException {
			VVDNEtaVO vvdEtaVO = null;
			
			if(ioBound.equals("I")){
				vvdEtaVO = dbDao.searchInVVDNEta(bookingNo, podCode);
			} else {
				vvdEtaVO = dbDao.searchOutVVDNEta(bookingNo, polCode);
			}
			
			return vvdEtaVO;
		}


	/**
	 *  fixDELLocation Search
	 * 
	 * @param FixDELLocationParmVO fixDELLocationParmVO
	 * @return FixDELLocationVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FixDELLocationVO fixDELLocation(FixDELLocationParmVO fixDELLocationParmVO) throws EventException, DAOException {
		FixDELLocationVO fixDELLocationVO = new FixDELLocationVO();
			
		//String	prmDttCode		= nullToString(fixDELLocationParmVO.getDmdtTrfCd(), 4);
		String	prmPodLocCd		= nullToString(fixDELLocationParmVO.getPodCd(), 5);
		//String	prmDelLocCd		= nullToString(fixDELLocationParmVO.getDelCd(), 5);
		//String	prmBcntrDlvTerm	= nullToString(fixDELLocationParmVO.getDeTermCd(), 1);
		//String	prmDcFmCnms		= nullToString(fixDELLocationParmVO.getFmMvmtStsCd());
		//String	prmDcToCnms		= nullToString(fixDELLocationParmVO.getToMvmtStsCd());
		String	prmDcIoBnd		= nullToString(fixDELLocationParmVO.getIoBnd());
		String	prmTspFlag		= nullToString(fixDELLocationParmVO.getTspFlag(), 1);
		String	prmPostRly		= nullToString(fixDELLocationParmVO.getPostRly());
		String	prmPreRly		= nullToString(fixDELLocationParmVO.getPreRly());

		/* --------------------------------------- */	
		ChangePODTariffVO changePODTariffVO = null;
			
		if( prmTspFlag.substring(0,1).equals("Y") ){
				changePODTariffVO = dbDao.changePODTariff(prmPodLocCd, prmDcIoBnd, prmPostRly, prmPreRly, 
						prmTspFlag, "DEL");
			
			log.debug("******************************************************************");
			log.debug("*[ Apply RLY Tariff ] rtnDelLocCd :"+changePODTariffVO.getLocCd());
			log.debug("******************************************************************");

			fixDELLocationVO.setDelContiCd(changePODTariffVO.getContiCd());
			fixDELLocationVO.setDelCntCd(changePODTariffVO.getCntCd());
			fixDELLocationVO.setDelRgnCd(changePODTariffVO.getRgnCd());	
			fixDELLocationVO.setDelSteCd(changePODTariffVO.getSteCd());
			fixDELLocationVO.setDelCd(changePODTariffVO.getLocCd());;
			fixDELLocationVO.setMsgCd("1");
			return fixDELLocationVO;
		}

		fixDELLocationVO.setMsgCd("0");
		return fixDELLocationVO;
	}

	
	
	/**
	 *  fixORGLocation Search
	 * 
	 * @param FixORGLocationParmVO fixORGLocationParmVO
	 * @return FixORGLocationVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FixORGLocationVO fixORGLocation(FixORGLocationParmVO fixORGLocationParmVO) throws EventException, DAOException {
		FixORGLocationVO fixORGLocationVO = new FixORGLocationVO();
			
		String	prmDcIoBnd		= nullToString(fixORGLocationParmVO.getIoBnd(), 1);
		String	prmTspFlag		= nullToString(fixORGLocationParmVO.getTspFlag(), 1);
		String	prmDelLocCd		= nullToString(fixORGLocationParmVO.getDelLocCd());

		/* --------------------------------------- */	
		ChangePODTariffVO changePODTariffVO = null;
		
		if( prmTspFlag.substring(0, 1).equals("Y") && prmDcIoBnd.substring(0, 1).equals("O") ){
			changePODTariffVO = dbDao.changePODTariff(prmDelLocCd, "", "", "", "", "ORG");
			
			log.debug("*******************************************************************");
			log.debug("* [ Apply ORG Tariff ] rtnDelLocCd "+changePODTariffVO.getLocCd());
			log.debug("*******************************************************************");

			fixORGLocationVO.setOrgContiCd(changePODTariffVO.getContiCd());
			fixORGLocationVO.setOrgCntCd(changePODTariffVO.getCntCd());
			fixORGLocationVO.setOrgRgnCd(changePODTariffVO.getRgnCd()); 
			fixORGLocationVO.setOrgSteCd(changePODTariffVO.getSteCd());
			fixORGLocationVO.setOrgCd(changePODTariffVO.getLocCd());;
			fixORGLocationVO.setMsgCd("1");
			return fixORGLocationVO;
		}
		fixORGLocationVO.setMsgCd("0");
		return fixORGLocationVO;
	
}

	/**
	 * searchBasicTariffByGeneration Search
	 * 
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return BasicTariffKeyVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public BasicTariffKeyVO searchBasicTariffByGeneration(BasicTariffParmVO basicTariffParmVO) throws EventException, DAOException {
		BasicTariffKeyVO basicTariffKeyVO = new BasicTariffKeyVO();
		
		String prmPorContiCd	= nullToString(basicTariffParmVO.getPorContiCd());
		String prmPorCntCd		= nullToString(basicTariffParmVO.getPorCntCd());
		String prmPorRgnCd		= nullToString(basicTariffParmVO.getPorRgnCd());
		String prmPorStateCd	= nullToString(basicTariffParmVO.getPorSteCd());
		String prmPorLoc		= nullToString(basicTariffParmVO.getPorLocCd());
		
		String prmYrdContiCd	= nullToString(basicTariffParmVO.getYrdContiCd());
		String prmYrdCntCd		= nullToString(basicTariffParmVO.getYrdCntCd());
		String prmYrdRgnCd		= nullToString(basicTariffParmVO.getYrdRgnCd());
		String prmYrdStateCd	= nullToString(basicTariffParmVO.getYrdSteCd());
		String prmYrdLoc		= nullToString(basicTariffParmVO.getYrdLocCd());
		
		String prmPolContiCd	= nullToString(basicTariffParmVO.getPolContiCd());
		String prmPolCntCd		= nullToString(basicTariffParmVO.getPolCntCd());
		String prmPolRgnCd		= nullToString(basicTariffParmVO.getPolRgnCd());
		String prmPolStateCd	= nullToString(basicTariffParmVO.getPolSteCd());
		String prmPolLoc		= nullToString(basicTariffParmVO.getPolLocCd());

		String prmDelContiCd	= nullToString(basicTariffParmVO.getDelContiCd());
		String prmDelCntCd		= nullToString(basicTariffParmVO.getDelCntCd());
		String prmDelRgnCd		= nullToString(basicTariffParmVO.getDelRgnCd());
		String prmDelStateCd	= nullToString(basicTariffParmVO.getDelSteCd());
		String prmDelLoc		= nullToString(basicTariffParmVO.getDelLocCd());
		
		String prmDttCode		= nullToString(basicTariffParmVO.getDmdtTrfCd());
		String prmEfftDt		= nullToString(basicTariffParmVO.getEffDt());
		String prmCntrTp		= nullToString(basicTariffParmVO.getDmdtCntrTpCd());
		String prmCgoTp			= nullToString(basicTariffParmVO.getDmdtCgoTpCd());
		String prmIoBnd			= nullToString(basicTariffParmVO.getIoBndCd());
		String prmAwkInOut		= nullToString(basicTariffParmVO.getAwkInOut());
		
		log.debug("*******************************************************");
		log.debug("[searchBasicTariffByGeneration ] prmPorContiCd 	:"+prmPorContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorCntCd 	:"+prmPorCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorRgnCd 	:"+prmPorRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorStateCd 	:"+prmPorStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorLoc 		:"+prmPorLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmYrdContiCd 	:"+prmYrdContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdCntCd 	:"+prmYrdCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdRgnCd 	:"+prmYrdRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdStateCd 	:"+prmYrdStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdLoc 		:"+prmYrdLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmPolContiCd 	:"+prmPolContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolCntCd 	:"+prmPolCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolRgnCd 	:"+prmPolRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolStateCd 	:"+prmPolStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolLoc 		:"+prmPolLoc);

		
		log.debug("[searchBasicTariffByGeneration ] prmDelContiCd 	:"+prmDelContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelCntCd 	:"+prmDelCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelRgnCd 	:"+prmDelRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelStateCd 	:"+prmDelStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelLoc 		:"+prmDelLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmDttCode 		:"+prmDttCode);
		log.debug("[searchBasicTariffByGeneration ] prmEfftDt 		:"+prmEfftDt);
		log.debug("[searchBasicTariffByGeneration ] prmCntrTp 		:"+prmCntrTp);
		log.debug("[searchBasicTariffByGeneration ] prmCgoTp 		:"+prmCgoTp);
		log.debug("[searchBasicTariffByGeneration ] prmIoBnd 		:"+prmIoBnd);
		log.debug("[searchBasicTariffByGeneration ] prmAwkInOut 	:"+prmAwkInOut);
		
		log.debug("*******************************************************");
		
		
		/* ----------------- CNTR & CGO Type Adjust */

		if(prmCntrTp.equals("D")){
			if(prmCgoTp.equals("AWK") || prmCgoTp.equals("B/B") || prmCgoTp.equals("SOC")){
					prmCgoTp = "DRY";
			  }
		}

		if( prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC") || prmCgoTp.equals("AWK")){
				prmCgoTp = "DRY";
			}
		}

		if( prmCntrTp.equals("R")){
			if(prmCgoTp.equals("AWK")|| prmCgoTp.equals("DGR")){
					prmCgoTp = "DRY";
			}
		}

		if(	(!prmCntrTp.equals("D") && !prmCntrTp.equals("R")) && prmCgoTp.equals("AWK")){
			if( prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			} else if( prmAwkInOut.equals("O")){
				prmCgoTp.equals("AWK");
			}
		}

		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("P")){
			if(prmCgoTp.equals("DGR")){
//				prmCntrTp = "D";
				prmCgoTp = "DRY"; 
			}
		}

		if(prmCntrTp.equals("F")){
			if(prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			} else if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}

		if(prmCntrTp.equals("O")){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}

		if(prmCntrTp.equals("S")){
			if(prmCgoTp.equals("DGR")){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}

		if(prmCntrTp.equals("A")){
			if(prmCgoTp.equals("DGR" )){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "F";
			}
		}
		/* --------------------------------------------------------------------------------- */

		basicTariffParmVO.setDmdtCgoTpCd(prmCgoTp);
		basicTariffParmVO.setDmdtCntrTpCd(prmCntrTp);

		log.debug(" [searchBasicTariffByGeneration] getDmdtCgoTpCd  :"+ basicTariffParmVO.getDmdtCgoTpCd());
		log.debug(" [searchBasicTariffByGeneration] getDmdtCntrTpCd :"+ basicTariffParmVO.getDmdtCntrTpCd());
		
		basicTariffKeyVO = dbDao.searchBasicTariffByGeneration(basicTariffParmVO);
		
		
		log.debug(" [basicTariffKeyVO(return)] getDmdtTrfGrpTpCd :"+ basicTariffKeyVO.getDmdtTrfGrpTpCd());
		if(basicTariffKeyVO.getDmdtTrfGrpTpCd() != null && basicTariffKeyVO.getDmdtTrfGrpTpCd().equals("N")){
			basicTariffKeyVO.setMsgCd("-99");
			return	basicTariffKeyVO;
		}

		return basicTariffKeyVO;
	
	}


	/**
	 * basicFreeTime Search
	 * 
	 * @param String zSvrId  
	 * @param String zDttCode
	 * @param long zDtnSeq
	 * @param long zDtgGrpId
	 * @param long zDbcBkgQty
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long basicFreeTime(String zSvrId  , String zDttCode, long zDtnSeq, long zDtgGrpId, long zDbcBkgQty) throws EventException, DAOException{
		return dbDao.basicFreeTime(zSvrId  , zDttCode, zDtnSeq, zDtgGrpId, zDbcBkgQty);				
	}



	/**
	 * getDTOCFtime Search
	 * 
	 * @param DtocFreeTimeParmVO dtocFreeTimeParmVO
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long getDTOCFtime(DtocFreeTimeParmVO dtocFreeTimeParmVO) throws EventException, DAOException {
		
		String	prmCntrNo	 	= nullToString(dtocFreeTimeParmVO.getCntrNo());
		long	prmCnmvCycNo	= stringToLong(dtocFreeTimeParmVO.getCnmvCycNo());
		String	prmEfftDt	 	= nullToString(dtocFreeTimeParmVO.getEfftDt());
		String	prmFmYdCd		= nullToString(dtocFreeTimeParmVO.getFmYdCd());
		
		log.debug("****************************************************");
		log.debug("[getDTOCFtime(param)] prmCntrNo 	 :"+ prmCntrNo);
		log.debug("[getDTOCFtime(param)] prmCnmvCycNo :"+ prmCnmvCycNo);
		log.debug("[getDTOCFtime(param)] prmEfftDt 	 :"+ prmEfftDt);
		log.debug("[getDTOCFtime(param)] prmFmYdCd 	 :"+ prmFmYdCd);
		log.debug("****************************************************");

		String	zCntrtsCd	 = "";
		String	zBkgNo  	 = "";
		String	zBcntrSpeDg	 = "";
		String	zBcntrSpeRf	 = "";
		String	zBcntrSpeAk	 = "";
		String	zBcntrSpeRd	 = "";
		String	zBcntrSpeBb	 = "";
		String	zBcntrSocInd = "";
		String	zBcntrPartial= "";
		String	zBcntrExcept = "";
		String	zDcsCntrTp	 = "";
		String	zDcsCgoTp	 = "";
		
		String	zPorLoc	 	 = "";
		String	zPorContiCd	 = "";
		String	zPorCntCd	 = "";
		String	zPorRgnCd	 = "";
		String	zPorStateCd	 = "";
		
		String	zYrdLoc	 	 = "";
		String	zYrdContiCd	 = "";
		String	zYrdCntCd	 = "";
		String	zYrdRgnCd	 = "";
		String	zYrdStateCd	 = "";

		String	zPolLoc	 	 = "";
		String	zPolContiCd	 = "";
		String	zPolCntCd	 = "";
		String	zPolRgnCd	 = "";
		String	zPolStateCd	 = "";
		
		String	zDelLoc	 	 = "";
		String	zDelContiCd	 = "";
		String	zDelCntCd	 = "";
		String	zDelRgnCd	 = "";
		String	zDelStateCd	 = "";
		
		long	zDbcBkgQty	 = 0;
		long	zDtnSeq	 	 = 0;
		long	zDtgGrpId	 = 0;
		String	dtgCmncTp	 = "";
		String	dtgCmncHr	 = "";
		String	dtgExclSat	 = "";
		String	dtgExclSun	 = "";
		String	dtgExclHoli	 = "";
		String	zCurCd	 	 = "";
		long	zDcFtDays	 = 0;
		String	awkInOut	 = "";
		
		String zSvrId   	 = "";
		String zDttCode 	 = "";

		DtocFreeTimeVO dtocFreeTimeVO = null;
		try {
			dtocFreeTimeVO = dbDao.getDTOCFtime(dtocFreeTimeParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("getDTOCFtime Select Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("getDTOCFtime Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		{   
			zCntrtsCd		= nullToString(dtocFreeTimeVO.getCntrTpszCd(), 1);
			zBkgNo  		= nullToString(dtocFreeTimeVO.getBkgNo());		
			                                                                                                                     
			zBcntrSpeDg		= nullToString(dtocFreeTimeVO.getDcgoFlg());		                                                     
			zBcntrSpeRf		= nullToString(dtocFreeTimeVO.getRcFlg());                                                                
			zBcntrSpeAk		= nullToString(dtocFreeTimeVO.getAwkCgoFlg());       		                                     
			zBcntrSpeRd		= nullToString(dtocFreeTimeVO.getRdCgoFlg());                                                             
			                                                                                                                     
			zBcntrSpeBb		= nullToString(dtocFreeTimeVO.getBbCgoFlg());		                                             
			zBcntrSocInd	= nullToString(dtocFreeTimeVO.getSocFlg());                                                                       
			zBcntrPartial	= nullToString(dtocFreeTimeVO.getCntrPrtFlg());		                                                     
			zBcntrExcept	= nullToString(dtocFreeTimeVO.getAdvShtgCd()); 
			
			zPorLoc			= nullToString(dtocFreeTimeVO.getPorCd());                                                                
			zPorContiCd		= nullToString(dtocFreeTimeVO.getPorContiCd());		                                     
			zPorCntCd		= nullToString(dtocFreeTimeVO.getPorCntCd());                                                            
			zPorRgnCd		= nullToString(dtocFreeTimeVO.getPorRgnCd());       		                                     
			zPorStateCd		= nullToString(dtocFreeTimeVO.getPorSteCd()); 
					                                                                                                                     
			zPolLoc			= nullToString(dtocFreeTimeVO.getPolCd());                                                                
			zPolContiCd		= nullToString(dtocFreeTimeVO.getPolContiCd());		                                     
			zPolCntCd		= nullToString(dtocFreeTimeVO.getPolCntCd());                                                            
			zPolRgnCd		= nullToString(dtocFreeTimeVO.getPolRgnCd());       		                                     
			zPolStateCd		= nullToString(dtocFreeTimeVO.getPolSteCd());                                                            
			
			zYrdLoc			= nullToString(dtocFreeTimeVO.getYrdCd());                                                                
			zYrdContiCd		= nullToString(dtocFreeTimeVO.getYrdContiCd());		                                     
			zYrdCntCd		= nullToString(dtocFreeTimeVO.getYrdCntCd());                                                            
			zYrdRgnCd		= nullToString(dtocFreeTimeVO.getYrdRgnCd());       		                                     
			zYrdStateCd		= nullToString(dtocFreeTimeVO.getYrdSteCd());
			
			zDelLoc			= nullToString(dtocFreeTimeVO.getDelCd());                                                               
			zDelContiCd		= nullToString(dtocFreeTimeVO.getDelContiCd());		                                        
			zDelCntCd		= nullToString(dtocFreeTimeVO.getDelCntCd());                                                               
			zDelRgnCd		= nullToString(dtocFreeTimeVO.getDelRgnCd());       		                                        
			zDelStateCd		= nullToString(dtocFreeTimeVO.getDelSteCd());      
		}
		log.debug("*******************************************************");
		log.debug("[getDTOCFtime]");
		log.debug(" prmCnmvCycNo 	: "+prmCnmvCycNo);
		log.debug(" zBkgNo   		: "+zBkgNo  );
		log.debug("*******************************************************");		
		
		/*
		[logic] Set CNTR TYPE 
		*/		
		zDcsCntrTp = DMTCalculationUtil.nullToString(zCntrtsCd,1).substring(0, 1);
		if(zDcsCntrTp.equals("P")){
			zDcsCntrTp = "F";
		}
		log.debug("****************************************************");
		log.debug("[Set Cntr Type] zDcsCntrTp ::"+ zDcsCntrTp);
		log.debug("****************************************************");
		
		/*
		[logic] Cargo type decision : Set Cntr & Cgo Type
		*/
		containerCargoTypeParmVO.setDcgoFlg(zBcntrSpeDg);
		containerCargoTypeParmVO.setRcFlg(zBcntrSpeRf);
		containerCargoTypeParmVO.setAwkCgoFlg(zBcntrSpeAk);
		containerCargoTypeParmVO.setRdCgoFlg(zBcntrSpeRd);
		containerCargoTypeParmVO.setSocFlg(zBcntrSocInd);
		containerCargoTypeParmVO.setBbCgoFlg(zBcntrSpeBb);
		
		containerCargoTypeVO = settingContainerCargoType(containerCargoTypeParmVO);
		zDcsCgoTp = containerCargoTypeVO.getCgoTp();
		log.debug("****************************************************");
		log.debug("[DTOC - Type] zDcsCgoTp : :"+ zDcsCgoTp);
		log.debug("****************************************************");
		
		
		/*
		[logic] Booking Container count  get : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = searchBookingContainerQuantity(zBkgNo  );
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchBookingContainerQuantity Funtion Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBookingContainerQuantity Funtion  Error ! : " + new ErrorHandler(e).getMessage());
		}
			log.debug("****************************************************");
			log.debug("[searchBookingContainerQuantity] zDbcBkgQty :"+ zDbcBkgQty);
			log.debug("****************************************************");
		
		try {
			awkInOut = searchInOutGauge(prmCntrNo, zBkgNo  );
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchBookingContainerQuantity Funtion Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBookingContainerQuantity Funtion Error !  " + new ErrorHandler(e).getMessage());
		}
		log.debug("****************************************************");
		log.debug("[searchInOutGauge] awkInOut :"+ awkInOut);
		log.debug("****************************************************");
		
		/*
		[logic] Basic Tariff information  get : Get Basic Tariff No
		*/
		
		BasicTariffParmVO basicTariffParmVO = new BasicTariffParmVO();
		
		basicTariffParmVO.setCvrgYdCd(prmFmYdCd); 
		basicTariffParmVO.setPorContiCd(zPorContiCd);
		basicTariffParmVO.setPorCntCd(zPorCntCd);
		basicTariffParmVO.setPorRgnCd(zPorRgnCd);
		basicTariffParmVO.setPorSteCd(zPorStateCd);
		basicTariffParmVO.setPorLocCd(zPorLoc);
			
		basicTariffParmVO.setPolContiCd(zPolContiCd);
		basicTariffParmVO.setPolCntCd(zPolCntCd);
		basicTariffParmVO.setPolRgnCd(zPolRgnCd);
		basicTariffParmVO.setPolSteCd(zPolStateCd);
		basicTariffParmVO.setPolLocCd(zPolLoc);
		
		basicTariffParmVO.setYrdContiCd(zYrdContiCd);
		basicTariffParmVO.setYrdCntCd(zYrdCntCd);
		basicTariffParmVO.setYrdRgnCd(zYrdRgnCd);
		basicTariffParmVO.setYrdSteCd(zYrdStateCd);
		basicTariffParmVO.setYrdLocCd(zYrdLoc);
		
		basicTariffParmVO.setDelContiCd(zDelContiCd);
		basicTariffParmVO.setDelCntCd(zDelCntCd);
		basicTariffParmVO.setDelRgnCd(zDelRgnCd);
		basicTariffParmVO.setDelSteCd(zDelStateCd);
		basicTariffParmVO.setDelLocCd(zDelLoc);
		
		basicTariffParmVO.setDmdtTrfCd("DTOC");
		basicTariffParmVO.setEffDt(prmEfftDt);
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd("O");
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		BasicTariffKeyVO basicTariffKeyVO = searchBasicTariffByGeneration(basicTariffParmVO);
		{			
			zDtnSeq 		= stringToLong(basicTariffKeyVO.getTrfSeq());
			zDtgGrpId		= stringToLong(basicTariffKeyVO.getTrfGrpSeq());
			
			zSvrId  		= nullToString(basicTariffKeyVO.getSvrId());		
			zDttCode		= nullToString(basicTariffKeyVO.getDmdtTrfCd());
			
			dtgCmncTp		= nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= nullToString(basicTariffKeyVO.getXcldHolFlg());
			zCurCd			= nullToString(basicTariffKeyVO.getCurrCd());
		}
		log.debug("****************************************************");
		log.debug("[searchBasicTariffByGeneration]");
		log.debug("[BasicTariffKeyVO] zDtnSeq 		:"+ zDtnSeq);
		log.debug("[BasicTariffKeyVO] zDtgGrpId 	:"+ zDtgGrpId);
		log.debug("****************************************************");		
	
		/*
		[logic] DTOC - F/Time
		*/
		zDcFtDays = 0;
		zDcFtDays = basicFreeTime(zSvrId  , "DTOC", zDtnSeq, zDtgGrpId, zDbcBkgQty);
		log.debug("*******************************************************");
		log.debug("* [DTOC - F/Time] zDcFtDays :"+zDcFtDays);
		log.debug("*******************************************************");
		
		return zDcFtDays;
	}




	/**
	 *  searchFreeTimeStart Search
	 * 
	 * @param FreeTimeStartParmVO freeTimeStartParmVO
	 * @return FreeTimeVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FreeTimeVO searchFreeTimeStart(FreeTimeStartParmVO freeTimeStartParmVO) throws EventException, DAOException {
		FreeTimeVO freeTimeVO = new FreeTimeVO();
		
		String	prmFromDt		= nullToString(freeTimeStartParmVO.getFromDt());
			
		String	prmBkgCntCd		= nullToString(freeTimeStartParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(freeTimeStartParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(freeTimeStartParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(freeTimeStartParmVO.getBkgLocCd());
		
		String	prmYrdCntCd		= nullToString(freeTimeStartParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(freeTimeStartParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(freeTimeStartParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(freeTimeStartParmVO.getYrdLocCd());
		
		String	prmDttCode		= nullToString(freeTimeStartParmVO.getDttCode(), 4);
		String	prmOfcCd		= nullToString(freeTimeStartParmVO.getOfcCd());
		String	prmExclSat		= nullToString(freeTimeStartParmVO.getExclSat());
		String	prmExclSun		= nullToString(freeTimeStartParmVO.getExclSun());
		String	prmExclHoli		= nullToString(freeTimeStartParmVO.getExclHoli());
		String 	prmCmncTp		= nullToString(freeTimeStartParmVO.getCmncTp());
		String 	prmCmncHr	 	= nullToString(freeTimeStartParmVO.getCmncHr());
		
		//String  prmSvrId 		= nullToString(freeTimeStartParmVO.getSvrId());
		long	ioIdxCstop		= stringToLong(freeTimeStartParmVO.getCstopIdx());
		
		String 	prmYardCd	 	= nullToString(freeTimeStartParmVO.getYardCd());	
		List<String> cstopNoList= freeTimeStartParmVO.getCStopNoList();

		log.debug("*******************************************************");
		log.debug("* [searchFreeTimeStart(param)] prmYardCd    :"+prmYardCd);
		log.debug("* [searchFreeTimeStart(param)] prmFromDt    :"+prmFromDt);
		log.debug("* [searchFreeTimeStart(param)] prmCmncTp    :"+prmCmncTp);
		log.debug("* [searchFreeTimeStart(param)] cstopNoList  :"+cstopNoList);
		log.debug("*******************************************************");
		
		String rtnFtimeCmnc	 		= "";
		String tmpCstopNo	 		= "";
		String ddhDate		 		= "";
		String weekOfDay	 		= "";
		String cntCd		 		= "";
		String rgnCd		 		= "";
		String stateCd		 		= "";
		String locCd		 		= "";
		String existYN 				= "";
		
		if(prmCmncTp.equals("1")){
			/* Movement Date --- */
					;
		} else if(prmCmncTp.equals("2")){
			/* Next Day -------- */
			try {
				prmFromDt = nullToString(dbDao.getNextDay(prmFromDt));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getNextDay Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getNextDay Select Error ! : " + new ErrorHandler(e).getMessage());
			}
		} else if(prmCmncTp.equals("3")){
			/* Interchage HR --- */
			try {
				prmFromDt = nullToString(dbDao.getInterchangeHR(prmFromDt, prmCmncHr));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getInterchangeHR Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getInterchangeHR Select Error ! : " + new ErrorHandler(e).getMessage());
			}
		} else {
			freeTimeVO.setMsgCd("-1");
			return freeTimeVO;
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeStart] prmFromDt :"+ prmFromDt);
		log.debug("****************************************************");
		
		/* ----------------------------Holiday Loc Setting */
		if( prmDttCode.substring(0, 2).equals("DM") ||

			( prmDttCode.substring(0, 4).equals("DTIC"))){
			cntCd 		= 	prmYrdCntCd;
			rgnCd 		= 	prmYrdRgnCd;
			stateCd 	= 	prmYrdStateCd;
			locCd 		= 	prmYrdLocCd;
		} else {	
			cntCd 		= 	prmBkgCntCd;
			rgnCd 		= 	prmBkgRgnCd;
			stateCd 	= 	prmBkgStateCd;
			locCd 		= 	prmBkgLocCd;
		}

		
		/* ----------------------------- Initial Date Setting */

		List<FreeTimeVO> mapPrev = null;
//		Map<String, String> mapPrev = new HashMap<String, String>();
		/* Previous Day -------- */
		try {
			mapPrev 		= dbDao.getPrevDay(prmFromDt);
//			weekOfDay 		= nullToString(mapPrev.get("week_of_day"));
//			rtnFtimeCmnc 	= nullToString(mapPrev.get("rtn_ftime_cmnc"));
			if (mapPrev != null && mapPrev.size() > 0) {
				log.debug("\n\n @@@@@ dbDao.getPrevDay size>0 - "+(mapPrev!=null?mapPrev.size():0)+" @@@@@@@@@@@@@ \n\n");

				FreeTimeVO tmp = mapPrev.get(0);
				log.debug("\n\n @@@@@ dbDao.getPrevDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
				if (tmp!=null){
					log.debug("\n\n @@@@@ dbDao.getPrevDay : WeekOfDaY:"+tmp.getWeekOfDay()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
					weekOfDay 		= nullToString(tmp.getWeekOfDay());
					rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());
				}
			}
			else {log.debug("\n\n @@@@@ dbDao.getPrevDay size=0 @@@@@@@@@@@@@ \n\n");}			
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("getPrevDay Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("getPrevDay Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeStart :getPrevDay] weekOfDay 		: ["+ weekOfDay +"]");
		log.debug("[searchFreeTimeStart :getPrevDay] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
		log.debug("****************************************************");

		for(  ;  ; 	)
		{
			List<FreeTimeVO> mapPlus = null;
//			Map<String, String> mapPlus = new HashMap<String, String>();
			/* Plus Day -------- */
			try {
				mapPlus 		= dbDao.getPlusDay(rtnFtimeCmnc);
//				weekOfDay 		= nullToString(mapPlus.get("week_of_day"));
//				rtnFtimeCmnc 	= nullToString(mapPlus.get("rtn_ftime_cmnc"));
				if (mapPlus != null && mapPlus.size() > 0) {
					
					FreeTimeVO tmp = mapPlus.get(0);
					log.debug("\n\n @@@@@ dbDao.getPlusDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						log.debug("\n\n @@@@@ dbDao.getPlusDay : WeekOfDaY:"+tmp.getWeekOfDay()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
						weekOfDay 		= nullToString(tmp.getWeekOfDay());
						rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());				
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Exception]>> DEM/DET Office Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			log.debug("****************************************************");
			log.debug("[getPlusDay ] weekOfDay 		: ["+ weekOfDay +"]");
			log.debug("[getPlusDay ] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
			log.debug("****************************************************");

			tmpCstopNo = "";
//			Map<String, String> mapTCStop = new HashMap<String, String>();
			List<FreeTimeVO> mapTCStop = null;
			/* getTimeClockStopToDt -------- */
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt(param) ]  prmDttCode 	: ["+ prmDttCode +"]");
			log.debug("[getTimeClockStopToDt(param) ]  prmOfcCd 	: ["+ prmOfcCd +"]");
			log.debug("[getTimeClockStopToDt(param) ]  rtnFtimeCmnc : ["+ rtnFtimeCmnc +"]");
			log.debug("[getTimeClockStopToDt(param) ]  prmYardCd    : ["+ prmYardCd +"]");
			log.debug("****************************************************");
			try {
				mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, rtnFtimeCmnc, prmYardCd);

//				if(!nullToString(mapTCStop.get("tmp_cstop_no")).equals("")){
//					tmpCstopNo 		= mapTCStop.get("tmp_cstop_no");
//					rtnFtimeCmnc 	= mapTCStop.get("rtn_ftime_cmnc");
//				}
				if (mapTCStop != null && mapTCStop.size() > 0) {
					FreeTimeVO tmp = mapTCStop.get(0);
					log.debug("\n\n @@@@@ dbDao.getTimeClockStopToDt : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						log.debug("\n\n @@@@@ dbDao.getTimeClockStopToDt : CstopNo:"+tmp.getCstopNo()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
						if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
							tmpCstopNo 		= nullToString(tmp.getCstopNo());
							rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());
						}
					}
				}				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getTimeClockStopToDt Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("getTimeClockStopToDt Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt ]  tmpCstopNo 		: ["+ tmpCstopNo +"]");
			log.debug("[getTimeClockStopToDt ]  rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
			log.debug("****************************************************");
			

			if( !tmpCstopNo.equals("") ){
				ioIdxCstop = ioIdxCstop + 1;
				if(tmpCstopNo != null) cstopNoList.add(tmpCstopNo);
				
				log.debug("****************************************************");
				log.debug("[ioIdxCstop ] ioIdxCstop :["+ ioIdxCstop +"]");
				log.debug("[tmpCstopNo ] tmpCstopNo :["+ tmpCstopNo +"]");
				if(cstopNoList != null && cstopNoList.size() > 0){	
					for(int i = 0; i < cstopNoList.size(); i++){
						log.debug("[cstopNoList.get("+i+")]"+cstopNoList.get(i));
					}
				}
				log.debug("****************************************************");
				
				continue;
			}

			existYN = nullToString(dbDao.checkWeekEnd(cntCd, weekOfDay, prmExclSat, prmExclSun));	
			log.debug("****************************************************");
			log.debug("[checkWeekEnd ] existYN : ["+ existYN +"]");
			log.debug("****************************************************");
			if(existYN.equals("Y")){
				continue;
			}
			
			/* getHolidayToDt -------- */
			try {
				ddhDate = nullToString(dbDao.getHolidayToDt(rtnFtimeCmnc, cntCd, rgnCd, stateCd, locCd));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getHolidayToDt Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("getHolidayToDt Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			log.debug("****************************************************");
			log.debug("[getHolidayToDt ] ddhDate 		: ["+ ddhDate +"]");
			log.debug("[getHolidayToDt ] prmExclHoli 	: ["+ prmExclHoli +"]");
			log.debug("****************************************************");
			if( !ddhDate.equals("") && prmExclHoli.equals("Y")){
				continue;
			}

			break ;

		}/* end of the for loop*/
		
		log.debug("****************************************************");
		log.debug("[return:searchFreeTimeStart ] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
		log.debug("[return:searchFreeTimeStart ] ioIdxCstop 	: ["+ ioIdxCstop +"]");
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[[return:searchFreeTimeStart ]>>cstopNoList.get("+i+")]"+cstopNoList.get(i));
			}
		}
		log.debug("****************************************************");
		
		freeTimeVO.setFtimeCmnc(rtnFtimeCmnc);
		freeTimeVO.setCstopIdx(String.valueOf(ioIdxCstop));
		if(cstopNoList != null) freeTimeVO.setCStopNoList(cstopNoList);
		return freeTimeVO;
	}


	/**
	 * searchFreeTimeEnd Search
	 * 
	 * @param FreeTimeEndParmVO freeTimeEndParmVO
	 * @return FreeTimeVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FreeTimeVO searchFreeTimeEnd(FreeTimeEndParmVO freeTimeEndParmVO) throws EventException, DAOException {
		FreeTimeVO freeTimeVO = new FreeTimeVO();
				
		String	prmFromDt		= nullToString(freeTimeEndParmVO.getFromDt());
		
		String	prmBkgCntCd		= nullToString(freeTimeEndParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(freeTimeEndParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(freeTimeEndParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(freeTimeEndParmVO.getBkgLocCd());
		
		String	prmYrdCntCd		= nullToString(freeTimeEndParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(freeTimeEndParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(freeTimeEndParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(freeTimeEndParmVO.getYrdLocCd());
		
		String	prmDttCode		= nullToString(freeTimeEndParmVO.getDttCode(), 4);
		String	prmOfcCd		= nullToString(freeTimeEndParmVO.getOfcCd());
		String	prmExclSat		= nullToString(freeTimeEndParmVO.getExclSat());
		String	prmExclSun		= nullToString(freeTimeEndParmVO.getExclSun());
		String	prmExclHoli		= nullToString(freeTimeEndParmVO.getExclHoli());
		long	prmFreeTime		= stringToLong(freeTimeEndParmVO.getFreeTime());
		
		//String	prmSvrId		= nullToString(freeTimeEndParmVO.getSvrId());
		

		long	ioIdxCstop		= stringToLong(freeTimeEndParmVO.getCstopIdx());
		List<String> cstopNoList = freeTimeEndParmVO.getCStopNoList();
		
		String prmYardCd		= nullToString(freeTimeEndParmVO.getYardCd());	

		log.debug("*******************************************************");
		log.debug("* [searchFreeTimeEnd(param)] prmFromDt 	:"+prmFromDt);
		log.debug("* [searchFreeTimeEnd(param)] cstopNoList :"+cstopNoList);
		log.debug("*******************************************************");
		
		String	rtnFtimeEnd		= "";
		String	tmpCstopNo		= "";
		
		String	ddhDate			= "";
		String	weekOfDay		= "";
		long	ii				= 0;
		String	cntCd			= "";
		String	rgnCd			= "";
		String	stateCd			= "";
		String	locCd			= "";
		String existYN 			= "";
		
		/* ---------------------------------------------------- */
		if(	prmDttCode.substring(0, 2).equals("DM") || ( 
			prmDttCode.substring(0, 4).equals("DTIC") )){
			cntCd 		= 	prmYrdCntCd;
			rgnCd 		= 	prmYrdRgnCd;
			stateCd 	= 	prmYrdStateCd;
			locCd 		= 	prmYrdLocCd;
		} else {
			cntCd 		= 	prmBkgCntCd;
			rgnCd 		= 	prmBkgRgnCd;
			stateCd 	= 	prmBkgStateCd;
			locCd 		= 	prmBkgLocCd;
		}
		/* -------------------------------------------------------- */
		rtnFtimeEnd = prmFromDt;

//		Map<String, String> mapPrev = new HashMap<String, String>();
		List<FreeTimeVO> mapPrev = null;
		/* Previous Day -------- */
		mapPrev = dbDao.getPrevDay(rtnFtimeEnd);
//		rtnFtimeEnd = nullToString(mapPrev.get("rtn_ftime_cmnc"));
		if (mapPrev != null && mapPrev.size() > 0) {
	
			FreeTimeVO tmp = mapPrev.get(0);
			if (tmp!=null){
				rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
			}
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeEnd :getPrevDay] rtnFtimeEnd  : ["+ rtnFtimeEnd +"]");
		log.debug("****************************************************");
		log.debug("[searchFreeTimeEnd :prmFreeTime] prmFreeTime : ["+ prmFreeTime +"]");
		log.debug("****************************************************");
		
		
		for( ii = 1  ; ii <= prmFreeTime ; ii++ )
		{
			
//			Map<String, String> mapPlus = new HashMap<String, String>();
			List<FreeTimeVO> mapPlus = null;
			/* Plus Day -------- */
			mapPlus 		= dbDao.getPlusDay(rtnFtimeEnd);
//			weekOfDay 		= nullToString(mapPlus.get("week_of_day"));
//			rtnFtimeEnd 	= nullToString(mapPlus.get("rtn_ftime_cmnc"));
			if (mapPlus != null && mapPlus.size() > 0) {
		
				FreeTimeVO tmp = mapPlus.get(0);
				if (tmp!=null){
					weekOfDay 		= nullToString(tmp.getWeekOfDay());
					rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
				}
			}
			
			log.debug("*******************************************************");
			log.debug("* [searchFreeTimeEnd:getPlusDay] weekOfDay ["+ii+"]  :"+weekOfDay);
			log.debug("* [searchFreeTimeEnd:getPlusDay] rtnFtimeEnd["+ii+"] :"+rtnFtimeEnd);
			log.debug("*******************************************************");
			
			tmpCstopNo = "";
//			Map<String, String> mapTCStop = new HashMap<String, String>();
			List<FreeTimeVO> mapTCStop = null;
			/* getTimeClockStopToDt -------- */
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt (param)]  prmDttCode  	: ["+ prmDttCode +"]");
			log.debug("[getTimeClockStopToDt (param)]  prmOfcCd 	: ["+ prmOfcCd +"]");
			log.debug("[getTimeClockStopToDt (param)]  rtnFtimeEnd 	: ["+ rtnFtimeEnd +"]");
			log.debug("[getTimeClockStopToDt (param)]  prmYardCd 	: ["+ prmYardCd +"]");
			log.debug("****************************************************");
			mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, rtnFtimeEnd, prmYardCd);
//			if(!nullToString(mapTCStop.get("tmp_cstop_no")).equals("")){
//				tmpCstopNo 		= nullToString(mapTCStop.get("tmp_cstop_no"));
//				rtnFtimeEnd 	= nullToString(mapTCStop.get("rtn_ftime_cmnc"));
//			}
			if (mapTCStop != null && mapTCStop.size() > 0) {
				FreeTimeVO tmp = mapTCStop.get(0);
				if (tmp!=null){
					if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
						tmpCstopNo 		= nullToString(tmp.getCstopNo());
						rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
					}
				}
			}
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt ] tmpCstopNo  : ["+ tmpCstopNo +"]");
			log.debug("[getTimeClockStopToDt ] rtnFtimeEnd : ["+ rtnFtimeEnd +"]");
			log.debug("****************************************************");
			
			if( !tmpCstopNo.equals("") ){
				
				ioIdxCstop = ioIdxCstop + 1;
				cstopNoList.add(tmpCstopNo);
				
				log.debug("****************************************************");
				log.debug("[ioIdxCstop ] ioIdxCstop : ["+ ioIdxCstop +"]");
				log.debug("[tmpCstopNo ] tmpCstopNo : ["+ tmpCstopNo +"]");
				if(cstopNoList.size() > 0){
					for(int i = 0; i < cstopNoList.size(); i++){
						log.debug("[cstopNoList.get("+i+")]"+cstopNoList.get(i));
					}
				}
				log.debug("****************************************************");
				
				ii = ii - 1;
				continue;
			}

 
			existYN = nullToString(dbDao.checkWeekEnd(cntCd, weekOfDay, prmExclSat, prmExclSun));
			log.debug("****************************************************");
			log.debug("[checkWeekEnd ] existYN : ["+ existYN +"]");
			log.debug("****************************************************");
			
			if(existYN.equals("Y")){
				ii = ii - 1;
				continue;
			}
			
			/* getHolidayToDt -------- */
			ddhDate = nullToString(dbDao.getHolidayToDt(rtnFtimeEnd, cntCd, rgnCd, stateCd, locCd));
			log.debug("****************************************************");
			log.debug("[getHolidayToDt ] ddhDate     : ["+ ddhDate +"]");
			log.debug("[getHolidayToDt ] prmExclHoli : ["+ prmExclHoli +"]");
			log.debug("****************************************************");
			
			if( !ddhDate.equals("") && prmExclHoli.equals("Y") ){
				ii = ii - 1;
				continue;
			}

		}/* end of the for loop*/
		
		log.debug("****************************************************");
		log.debug("[return:searchFreeTimeEnd ] rtnFtimeEnd : ["+ rtnFtimeEnd +"]");
		log.debug("[return:searchFreeTimeEnd ] ioIdxCstop  : ["+ ioIdxCstop +"]");
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[[return:searchFreeTimeEnd ]cstopNoList.get("+i+")]:"+cstopNoList.get(i));
			}
		}
		log.debug("****************************************************");
		
		freeTimeVO.setFtimeEnd(rtnFtimeEnd);
		freeTimeVO.setCstopIdx(String.valueOf(ioIdxCstop));
		if(cstopNoList != null) freeTimeVO.setCStopNoList(cstopNoList);
		return freeTimeVO;
	}

	

	/**
	 * getMTNotify Search
	 * 
	 * @param String zSvrId  
	 * @param String zCntrNo  
	 * @param long zCnmvCycNo   
	 * @param String zDttCode
	 * @param String zDcFmCnms
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String getMTNotify(String zSvrId  , String zCntrNo  , long zCnmvCycNo   , String zDttCode, String zDcFmCnms) throws EventException, DAOException {
		return dbDao.getMTDate(zSvrId  , zCntrNo  , zCnmvCycNo   , zDttCode, zDcFmCnms);
	}



	/**
	 *  overdayNStatus Search
	 * 
	 * @param OverdayNStatusParmVO overdayNStatusParmVO
	 * @return OverdayNStatusVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public OverdayNStatusVO overdayNStatus(OverdayNStatusParmVO overdayNStatusParmVO) throws EventException, DAOException {
		OverdayNStatusVO overdayNStatusVO = new OverdayNStatusVO();
		
		String		prmToDate		= nullToString(overdayNStatusParmVO.getToDate());
		String		prmFtimeEnd		= nullToString(overdayNStatusParmVO.getFtimeEnd());
		String		prmDttCode		= nullToString(overdayNStatusParmVO.getDttCode());
		String		prmOfcCd		= nullToString(overdayNStatusParmVO.getOfcCd());
		String		prmMtDate		= nullToString(overdayNStatusParmVO.getMtDate());
		long		ioIdxCstop		= stringToLong(overdayNStatusParmVO.getCstopIdx());
		List<String> cstopNoList  	= overdayNStatusParmVO.getCStopNoList();
		String      prmYardCd		= nullToString(overdayNStatusParmVO.getYardCd());	

		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		String 	prmIoBndCd	 	= nullToString(overdayNStatusParmVO.getIoBndCd());
		String  prmBkgDeTermCd  = nullToString(overdayNStatusParmVO.getBkgDeTermCd());
		String  prmBkgRcvTermCd = nullToString(overdayNStatusParmVO.getBkgRcvTermCd());
		String	prmBkgCntCd		= nullToString(overdayNStatusParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(overdayNStatusParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(overdayNStatusParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(overdayNStatusParmVO.getBkgLocCd());
		String	prmYrdCntCd		= nullToString(overdayNStatusParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(overdayNStatusParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(overdayNStatusParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(overdayNStatusParmVO.getYrdLocCd());	
		String	prmSvrId        = nullToString(overdayNStatusParmVO.getSvrId());	
		
		String	prmExptCostFlg = nullToString(overdayNStatusParmVO.getExptCostFlg());
		
		if (!"Y".equals(prmExptCostFlg)){
			prmExptCostFlg = "N";
		}
		
		String	ddhDate		 = "";
		String	weekOfDay	 = "";
		String  overday_st_dt  = "";
		String  existYN 	 = "";
		String	cntCd		 = "";
		String	rgnCd		 = "";
		String	stateCd		 = "";
		String	locCd		 = "";
		
		String termCd = "";
	    if (prmIoBndCd.equals("O")){
		      termCd = prmBkgRcvTermCd;
		}else{
		   	  termCd = prmBkgDeTermCd;
		}
		
		long		rtnOverDay		= 0;
		String		rtnStatus		= "";
		String		tmpCstopNo		= "";
		long		tmpCstopDay		= 0;
		long		tmpCstopTotal	= 0;

		int			unfinishFlag	= 0;
//		long		checkNum		= 0;
		long		checkGrace		= 0;
		
		log.debug("*******************************************************");
		log.debug("* [overdayNStatusParmVO ] prmToDate   	:"+prmToDate);
		log.debug("* [overdayNStatusParmVO ] prmFtimeEnd 	:"+prmFtimeEnd);
		log.debug("* [overdayNStatusParmVO ] prmDttCode  	:"+prmDttCode);
		log.debug("* [overdayNStatusParmVO ] prmOfcCd 		:"+prmOfcCd);
		log.debug("* [overdayNStatusParmVO ] prmMtDate 		:"+prmMtDate +";"+ prmMtDate.length());
		log.debug("* [overdayNStatusParmVO ] ioIdxCstop 	:"+ioIdxCstop);
		log.debug("* [overdayNStatusParmVO ] cstopNoList 	:"+cstopNoList);
		log.debug("* [overdayNStatusParmVO ] prmYardCd 		:"+prmYardCd);
		log.debug("*******************************************************");
		/* ----------------------------------- Date Fixing */
		if( prmToDate.length() == 0 ){

			List<OverdayNStatusVO> rtnList = null;
			
			
			rtnList = dbDao.getOverdayStatus("", prmFtimeEnd, 0, "1", prmOfcCd);
			
			if (rtnList != null && rtnList.size() > 0) {
				log.debug("\n\n @@@@@ dbDao.getOverdayStatus size>0 - "+(rtnList!=null?rtnList.size():0)+" @@@@@@@@@@@@@ \n\n");
				OverdayNStatusVO tmp = rtnList.get(0);
				log.debug("\n\n @@@@@ dbDao.getOverdayStatus : OverdayNStatusVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
				if (tmp!=null){
					prmToDate 		= nullToString(tmp.getPrmToDate());
					prmFtimeEnd 	= nullToString(tmp.getPrmFtimeEnd());
					log.debug("\n\n @@@@@ dbDao.getOverdayStatus : PrmToDate:"+tmp.getPrmToDate()+" / PrmFtimeEnd:"+tmp.getPrmFtimeEnd()+" @@@@@@@@@@@@@ \n\n");
				}
			}
			else {log.debug("\n\n @@@@@ dbDao.getOverdayStatus size=0 @@@@@@@@@@@@@ \n\n");}
			
			unfinishFlag	=	1;

		} else {
			List<OverdayNStatusVO> rtnList = null;
			rtnList = dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, 0, "2", "");
			
			if (rtnList != null && rtnList.size() > 0) {
				log.debug("\n\n @@@@@ dbDao.getOverdayStatus size>0 - "+(rtnList!=null?rtnList.size():0)+" @@@@@@@@@@@@@ \n\n");
				OverdayNStatusVO tmp = rtnList.get(0);
				log.debug("\n\n @@@@@ dbDao.getOverdayStatus : OverdayNStatusVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
				if (tmp!=null){
					prmToDate 		= nullToString(tmp.getPrmToDate());
					prmFtimeEnd 	= nullToString(tmp.getPrmFtimeEnd());
					log.debug("\n\n @@@@@ dbDao.getOverdayStatus : PrmToDate:"+tmp.getPrmToDate()+" / PrmFtimeEnd:"+tmp.getPrmFtimeEnd()+" @@@@@@@@@@@@@ \n\n");
				}
			}
			else {log.debug("\n\n @@@@@ dbDao.getOverdayStatus size=0 @@@@@@@@@@@@@ \n\n");}
			
			unfinishFlag	=	0;
		}

		//**********************************************************************************************
		//	    2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		//	    USOAK 또는 USSFO인 Yard에서는 IB와 OB의 Detention(CTIC/CTOC포함)의 Day 계산에서 SAT/SUN/HOL을 모두 제외
		//      2012.07.03  'USLGB', 'USLAX', 'USGAC' 추가.	
		//      Exception cost 계산시에는 반영 되지 않도록 하기 위해 추가 함. prmExptCostFlg  = "Y" 인 경우는 처리되지 않도록 함.
		//**********************************************************************************************
		
		log.debug("[overdayNStatus] prmYrdLocCd    : " + prmYrdLocCd);
		log.debug("[overdayNStatus] unfinishFlag   : " + ( unfinishFlag == 1?"(U)Unfinsh":"(F)Finish" ));
		log.debug("[overdayNStatus] termCd         : " + termCd);
		log.debug("[overdayNStatus] prmExptCostFlg : " + prmExptCostFlg);
		
//		if(( prmYrdLocCd.equals("USSFO") || prmYrdLocCd.equals("USOAK") || prmYrdLocCd.equals("USLGB")|| prmYrdLocCd.equals("USLAX")|| prmYrdLocCd.equals("USGAC") || prmYrdLocCd.substring(1, 2).equals("SE")) 
//		  && prmExptCostFlg.equals("N")) {
			
			long ret = 0;
			overday_st_dt =   prmFtimeEnd ;
			long overDay = 0;
//			String  prmExclSat = "Y";
//			String  prmExclSun = "Y";
//			String  prmExclHoli = "Y";
	      
			List<OverdayNStatusVO> checkNumList = null;
			checkNumList = dbDao.getOverdayStatus(prmToDate, overday_st_dt, 0, "3", "");
			
			if (checkNumList != null && checkNumList.size() > 0) {
				OverdayNStatusVO tmp = checkNumList.get(0);
				if (tmp!=null){
					ret = stringToLong(tmp.getCheckNum());
				}
			}	  
		  
			log.debug("[overdayNStatus] overday_st_dt : PrmToDate ["+prmToDate+"] / PrmFtimeEnd ["+prmFtimeEnd+"] @@@@@@@@@@@@@ \n");
		
			if (ret > 0){		
			   for(int k = 0; k < ret; k++  ){	   

				   List<FreeTimeVO> mapPlus = null;
				   
				   /* Plus Day -------- */
				   try {
				      mapPlus  = dbDao.getPlusDay(overday_st_dt);
				     if (mapPlus != null && mapPlus.size() > 0) {
				         FreeTimeVO tmp = mapPlus.get(0);
				         log.debug("[overdayNStatus] dbDao.getPlusDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n");
				        if (tmp!=null){
				             log.debug("[overdayNStatus] dbDao.getPlusDay : WeekOfDaY ["+tmp.getWeekOfDay()+"] / overday_st_dt ["+tmp.getRtnFtimeCmnc()+"] @@@@@@@@@@@@@ \n");
				             weekOfDay   = nullToString(tmp.getWeekOfDay());
				             overday_st_dt  = nullToString(tmp.getRtnFtimeCmnc());    
				         }
				     }
				   }catch(Exception e) {
				    log.error("[Exception]>> DEM/DET Office Select Error !  ");
				    throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
				   }
				   
				   log.debug("[overdayNStatus] [getPlusDay] weekOfDay      : ["+ weekOfDay +"]");
				   log.debug("[overdayNStatus] [getPlusDay] overday_st_dt  : ["+ overday_st_dt +"]");
				   
				   tmpCstopNo = "";
				   List<FreeTimeVO> mapTCStop = null;
				   
				   /* getTimeClockStopToDt -------- */
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmDttCode    : ["+ prmDttCode +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmOfcCd      : ["+ prmOfcCd +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  overday_st_dt : ["+ overday_st_dt +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmYardCd     : ["+ prmYardCd +"]");

				   try {
				       mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, overday_st_dt, prmYardCd);
				       if (mapTCStop != null && mapTCStop.size() > 0) {
				           FreeTimeVO tmp = mapTCStop.get(0);
				           
				           log.debug("[overdayNStatus] dbDao.getTimeClockStopToDt : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n");
				           
				           if (tmp!=null){
				               log.debug("[overdayNStatus] dbDao.getTimeClockStopToDt : CstopNo ["+tmp.getCstopNo()+"] / overday_st_dt ["+tmp.getRtnFtimeCmnc()+"] @@@@@@@@@@@@@ \n");
				               if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
				                   tmpCstopNo   = nullToString(tmp.getCstopNo());
				                   //overday_st_dt  = nullToString(tmp.getRtnFtimeCmnc());
				                }
				            }
				       }     
				   	}catch(Exception e) {
						log.error("getTimeClockStopToDt Select Error !  ");
						throw new EventException("getTimeClockStopToDt Select Error ! : " + new ErrorHandler(e).getMessage());
				   	}
				   
				   	log.debug("[overdayNStatus] [getTimeClockStopToDt ] tmpCstopNo     : ["+ tmpCstopNo +"]");
				   	//log.debug("[overdayNStatus] [getTimeClockStopToDt ] overday_st_dt  : ["+ overday_st_dt +"]");
				   
				   	if( !tmpCstopNo.equals("") ){
				   		ioIdxCstop = ioIdxCstop + 1;
				   		cstopNoList.add(tmpCstopNo);
				   		tmpCstopTotal += tmpCstopDay;
				    
				   		log.debug("[overdayNStatus] [ioIdxCstop ] ioIdxCstop : ["+ ioIdxCstop +"]");
				   		log.debug("[overdayNStatus] [tmpCstopNo ] tmpCstopNo : ["+ tmpCstopNo +"]");
				       
				   		if(cstopNoList != null && cstopNoList.size() > 0){ 
				   			for(int i = 0; i < cstopNoList.size(); i++){
				   				log.debug("[overdayNStatus] [cstopNoList.get("+i+")]"+cstopNoList.get(i));
				   			}
				   		}
				   		continue;
				   	}

				    String  prmExclSat = "N";
				    String  prmExclSun = "N";
				    String  prmExclHoli = "N";
				    String  trfTp = prmDttCode.substring(1, 2);
				    String  effDt = overday_st_dt.substring(0, 8);

				    String[] rtnValues = dbDao.searchSB45RullingOverday(prmYrdCntCd, prmYrdLocCd, prmYardCd, prmIoBndCd, effDt, trfTp);
				    
				    prmExclSat = rtnValues[0];
				    prmExclSun = rtnValues[1];
				    prmExclHoli = rtnValues[2];
				    
				    
				    CheckWeekEndParmVO  checkWeekEndParmVO = new CheckWeekEndParmVO();
				    
					checkWeekEndParmVO.setCntCd(prmYrdLocCd.substring(0, 2));
					checkWeekEndParmVO.setWeekOfDay(weekOfDay);
					checkWeekEndParmVO.setExclSat(prmExclSat);
					checkWeekEndParmVO.setExclSun(prmExclSun);
					checkWeekEndParmVO.setLocCd(prmYrdLocCd);
					checkWeekEndParmVO.setTermCd(termCd);
					checkWeekEndParmVO.setTrfCd(prmDttCode);
					 
					existYN = nullToString(dbDao.checkWeekEnd(checkWeekEndParmVO)); 

					log.debug("[overdayNStatus] [checkWeekEnd] existYN : ["+ existYN +"]");
				   
					if(existYN.equals("Y")){
						continue;
					}
				   
				    /* getHolidayToDt -------- */
					/* ---Holiday Loc Setting ------ */
					if( prmDttCode.substring(0, 2).equals("DM") ||
						( prmSvrId.equals("USA") && prmDttCode.substring(0, 4).equals("DTIC"))){
						cntCd 		= 	prmYrdCntCd;
						rgnCd 		= 	prmYrdRgnCd;
						stateCd 	= 	prmYrdStateCd;
						locCd 		= 	prmYrdLocCd;
					} else {	
						cntCd 		= 	prmBkgCntCd;
						rgnCd 		= 	prmBkgRgnCd;
						stateCd 	= 	prmBkgStateCd;
						locCd 		= 	prmBkgLocCd;
					}
				   
					try {
						ddhDate = nullToString(dbDao.getHolidayToDt(overday_st_dt, cntCd, rgnCd, stateCd, locCd));
					}catch(Exception e) {
						log.error("[overdayNStatus] getHolidayToDt Select Error !  ");
						throw new EventException("getHolidayToDt Select Error ! : " + new ErrorHandler(e).getMessage());
					}
				   
					log.debug("[overdayNStatus] [getHolidayToDt ] ddhDate      : ["+ ddhDate +"]");
					log.debug("[overdayNStatus] [getHolidayToDt ] prmExclHoli  : ["+ prmExclHoli +"]");
				   
					if( !ddhDate.equals("") && prmExclHoli.equals("Y")){
						continue;
					}
				   
					overDay++; 
			   }/* end of for */
			}
			
			rtnOverDay = overDay;
//		} else {			   
//			/* -------------------------------Clock-Stop Day Check  */
//			tmpCstopTotal	=	0;
//			checkNum		=	0;
//	
//			List<OverdayNStatusVO> rtnCheckNumList = null;
//			rtnCheckNumList = dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, 0, "3", "");	// prmToDate(A)- prmFtimeEnd(B)
//			
//			if (rtnCheckNumList != null && rtnCheckNumList.size() > 0) {
//				// Over Day 발생.
//				OverdayNStatusVO tmp = rtnCheckNumList.get(0);
//				if (tmp!=null){
//					// Over Days.
//					checkNum = stringToLong(tmp.getCheckNum());
//				}
//			}
//			
//			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] prmToDate      :["+prmToDate+"]");
//			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] prmFtimeEnd    :["+prmFtimeEnd+"]");
//			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] type 3");
//			log.debug("*[overdayNStatus] [overdayNStatusParmVO ] checkNum       :["+checkNum+"]");
//			
//			if( checkNum > 0 ) {			/* When To Date is latter than Free Time End Date */
//				List<StopDaysVO> list = null;
//				list = dbDao.getStopDays(prmToDate, prmDttCode, prmOfcCd, prmFtimeEnd, prmYardCd);
//	
//				if (list != null && list.size() > 0) {
//					for (int i = 0 ; i < list.size() ; i++) {
//						StopDaysVO tmp = list.get(i);
//						if (tmp!=null){
//							tmpCstopNo 	= nullToString(tmp.getTmpCstopNo());
//							tmpCstopDay = stringToLong(tmp.getTmpCstopDay());
//						}
//						
//						ioIdxCstop = ioIdxCstop + 1;
//						cstopNoList.add(tmpCstopNo);
//						tmpCstopTotal += tmpCstopDay;
//						
//						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopNo      :["+tmpCstopNo+"]");
//						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopDay     :["+tmpCstopDay+"]");
//						log.debug("*[overdayNStatus] [GetStopDays ] ioIdxCstop      :["+ioIdxCstop+"]");
//						log.debug("*[overdayNStatus] [GetStopDays ] cstopNoList     :["+cstopNoList+"]");
//						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopTotal   :["+tmpCstopTotal+"]");
//						
//						if(cstopNoList != null && cstopNoList.size() > 0){
//							for(int ii = 0; ii < cstopNoList.size(); ii++){
//								log.debug("[overdayNStatus] [cstopNoList.get("+ii+")]:["+cstopNoList.get(ii)+"]");
//							}
//						}
//					}
//				}			
//			} else {
//				tmpCstopTotal = 0;
//			}
//			
//			List<OverdayNStatusVO> rtnOverDayList = null;
//			rtnOverDayList 	= dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, tmpCstopTotal, "4", "");
//			
//			if (rtnOverDayList != null && rtnOverDayList.size() > 0) {
//				OverdayNStatusVO tmp = rtnOverDayList.get(0);
//				if (tmp!=null){
//					rtnOverDay = stringToLong(tmp.getOverDay());
//				}
//			}
//		}
		 
		/**
		 *  unfinishFlag = 1 이면 Unfinished 의미.
		 *  unfinishFlag = 0 이면 Finshed 의미.
		 */
		
		log.debug("*[overdayNStatus] prmMtDate  : ["+prmMtDate+"]");
		log.debug("*[overdayNStatus] rtnOverDay : ["+rtnOverDay+"]");
		
		checkGrace	=	0;
		if( prmMtDate.length() == 0 ){		
		
			if( rtnOverDay > 0 ){
				if( unfinishFlag == 1 ){
					 rtnStatus = "L";	
				} else {
					rtnStatus = "F";	
				}
			} else {
				if( unfinishFlag == 1 ){
					rtnStatus = "U";	
				} else {
					rtnStatus = "N";	
				}
			}
		} else {		
			/* _____________ Get the Grace Period Overday	*/

			List<OverdayNStatusVO> checkGraceList = null;
			checkGraceList = dbDao.getOverdayStatus(prmToDate, prmMtDate, 0, "5", prmOfcCd);

			if (checkGraceList != null && checkGraceList.size() > 0) {
				OverdayNStatusVO tmp = checkGraceList.get(0);
				if (tmp!=null){
					checkGrace = stringToLong(tmp.getCheckGrace());
				}
			}
			
			if( rtnOverDay > 0 ){		
				if( checkGrace > 7 ){	
					if( unfinishFlag == 1 ){
						rtnStatus = "L"; 			
					} else {
						rtnStatus = "F"; 			
					}
				} else {						/*_____	Not Passed the Grace Period	*/
					rtnOverDay = 0;		

					if( unfinishFlag == 1 ){
						rtnStatus = "U";
					} else {
						rtnStatus = "N";
					}
				}
			} else {							/*_____	Not Passed the Free Time End Date	*/
				if( unfinishFlag == 1 ){
					rtnStatus = "U"; 			
				} else {
					rtnStatus = "N";
				}
			}
		}
		
		log.debug("[overdayNStatus] [return] rtnOverDay : ["+ rtnOverDay +"]");
		log.debug("[overdayNStatus] [return] rtnStatus  : ["+ rtnStatus +"]");
		log.debug("[overdayNStatus] [return] ioIdxCstop : ["+ ioIdxCstop +"]");
		
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[overdayNStatus] [return] cstopNoList.get("+i+")]:["+cstopNoList.get(i)+"]");
			}
		}
		
		overdayNStatusVO.setOverDay(String.valueOf(rtnOverDay));
		overdayNStatusVO.setStatus(rtnStatus);
		overdayNStatusVO.setCstopIdx(String.valueOf(ioIdxCstop));
		if(cstopNoList != null) overdayNStatusVO.setCStopNoList(cstopNoList);
		
		return overdayNStatusVO;
	}


///
	/**
	 * basicCalculation Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public CalculationAMTVO basicCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		String 		prmSvrId			= nullToString(calculationParmVO.getSvrId());
		String		prmDttCode			= nullToString(calculationParmVO.getDmdtTrfCd());
		long		prmDtnSeq			= stringToLong(calculationParmVO.getTrfSeq());
		long		prmGrpId			= stringToLong(calculationParmVO.getTrfGrpSeq());
		
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		
		double		rtnTotal			= 0.0;

		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		long		underOverTerm		= 0;
		
		log.debug("*******************************************************");
		log.debug("* [basicCalculation] prmSvrId 		:"+prmSvrId);
		log.debug("* [basicCalculation] prmDttCode 		:"+prmDttCode);
		log.debug("* [basicCalculation] prmDtnSeq 		:"+prmDtnSeq);
		log.debug("* [basicCalculation] prmGrpId 		:"+prmGrpId);
		
		log.debug("* [basicCalculation] prmCntrts 		:"+prmCntrts);
		log.debug("* [basicCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [basicCalculation] prmDivOverDay	:"+prmDivOverDay);
		log.debug("* [basicCalculation] prmOrgDivOverDay:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		list = dbDao.searchDivChrgList(prmSvrId, prmDttCode, prmDtnSeq,
//										prmGrpId, prmCntrts, prmOverDay, prmDivOverDay);
//		List<ChargeListVO> list = dbDao.searchDivChrgList(prmSvrId, prmDttCode, prmDtnSeq, prmGrpId, prmCntrts, prmOverDay, prmDivOverDay);
		List<ChargeListVO> list = dbDao.searchDivChrgList(calculationParmVO);
		
		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if(list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 	= 0.0;
			
				chrgDtlVO = new ChrgDtlVO();
				
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
				
//				dtrFtOver 	= stringToLong((String) list.get(i).get("ft_over"));
//				dtrFtUnder 	= stringToLong((String) list.get(i).get("ft_under"));
//				dtrRate 	= stringToDouble((String) list.get(i).get("rate"));
			
				log.debug("[1.dtrFtOver] :"+dtrFtOver);
				log.debug("[2.dtrFtOver] :"+dtrFtUnder);
				log.debug("[3.dtrRate  ] :"+dtrRate);
				
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the BSCChrg]");
					log.debug("*******************************************************");		
					
					break;
				}

				
				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));
				

				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){
					/* ________________ last rate level */
					if (prmDivOverDay == 0){
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
					}
				} else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ;

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						
						underOverTerm = 0;	
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}

				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [bscChrgRate] "+ list.size() +"["+i+"]");
				log.debug("* [bscChrgRate] dtrFtOver["+i+"]		:"+dtrFtOver);
				log.debug("* [bscChrgRate] dtrFtUnder["+i+"]	:"+dtrFtUnder);
				log.debug("* [bscChrgRate] dtrRate["+i+"]		:"+dtrRate);
				log.debug("* [bscChrgRate] underOverTerm["+i+"]	:"+underOverTerm);
				log.debug("* [bscChrgRate] rtnTotal["+i+"]		:"+rtnTotal);
				log.debug("*******************************************************");
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
		} /* End of the if clause */
		
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		if(list != null) {
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		}
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		return calculationAMTVO;
	}

	/**
	 * basicCalculationByBKG Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double basicCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String 		prmSvrId			= nullToString(calculationParmVO.getSvrId());
		String		prmDttCode			= nullToString(calculationParmVO.getDmdtTrfCd());
		long		prmDtnSeq			= stringToLong(calculationParmVO.getTrfSeq());
		long		prmGrpId			= stringToLong(calculationParmVO.getGrpSeq());
		
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		log.debug("*******************************************************");
		log.debug("* [basicCalculation] prmSvrId 		:"+prmSvrId);
		log.debug("* [basicCalculation] prmDttCode 		:"+prmDttCode);
		log.debug("* [basicCalculation] prmDtnSeq 		:"+prmDtnSeq);
		log.debug("* [basicCalculation] prmGrpId 		:"+prmGrpId);
		
		log.debug("* [basicCalculation] prmCntrts 		:"+prmCntrts);
		log.debug("* [basicCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [basicCalculation] prmDivOverDay	:"+prmDivOverDay);
		log.debug("* [basicCalculation] prmOrgDivOverDay:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		list = dbDao.searchDivChrgList(prmSvrId, prmDttCode, prmDtnSeq,
//										prmGrpId, prmCntrts, prmOverDay, prmDivOverDay);
		List<ChargeListVO> list = dbDao.searchDivChrgList(calculationParmVO);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 	= 0.0;

			dtrFtOver 	= stringToLong(list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong(list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble(list.get(0).getRtAmt());
			
			log.debug("*******************************************************");
			log.debug("* [bscChrgRate] [0]");
			log.debug("* [bscChrgRate] dtrFtOver[0] :"+dtrFtOver);
			log.debug("* [bscChrgRate] dtrFtUnder[0]:"+dtrFtUnder);
			log.debug("* [bscChrgRate] dtrRate[0]    :"+dtrRate);
			log.debug("*******************************************************");
				
		} /* End of the if clause */
		
		return dtrRate;
	}
	
	/**
	 *  searchCommodityExceptionByGeneration Search
	 * 
	 * @param CommodityExceptionParmVO commodityExceptionParmVO
	 * @return DmtCmdtGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtCmdtGrpVO searchCommodityExceptionByGeneration(CommodityExceptionParmVO commodityExceptionParmVO) throws EventException, DAOException {
		return dbDao.searchCommodityExceptionByGeneration(commodityExceptionParmVO);
	}

	/**
	 * getMinVLDate Search
	 * 
	 * @param String cntrNo
	 * @param long cnmvCycNo
	 * @param String mvmtStsCd
	 * @param String startMvmtStsCd
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String getMinOCVLDate(String cntrNo ,long cnmvCycNo, String mvmtStsCd, String startMvmtStsCd) throws EventException, DAOException {
		return dbDao.getMinOCVLDate(cntrNo, cnmvCycNo, mvmtStsCd, startMvmtStsCd);
	}

	 /**
	  * getMinOCDate Search
	  * 
	  * @param String bkgNo
	  * @param String cntrNo
	  * @param String zDcFmDate
	  * @param String zDcFmYdCd
	  * @param String zDcFmCnms
	  * @return String[]
	  * @throws EventException 
	  * @exception EventException
	  * @throws DAOException 
	  */
	 public String getMinOCDate(String bkgNo, String cntrNo, String zDcFmDate, String zDcFmYdCd, String zDcFmCnms) throws EventException, DAOException {
	 
	      String cnmvYr = "";
	      String cnmvSeq = "";
	      String cnmvSplitNo = ""; 
	      
	      String[] tmpKey = null;
	      DmtOCMvmtVO dmtOCMvmtVO = new DmtOCMvmtVO();
	      DmtOCMvmtVO tmpDmtOCMvmtVO = new DmtOCMvmtVO();
	      tmpKey = dbDao.searchCntrKey(bkgNo, cntrNo, zDcFmDate, zDcFmYdCd, zDcFmCnms);
	      
	      if (tmpKey == null || tmpKey.equals("")) {
	    	  return "";
	      }
	      
	      cnmvYr = tmpKey[0];
	      cnmvSeq = tmpKey[1];
	      cnmvSplitNo = tmpKey[2];
	      
	      dmtOCMvmtVO = dbDao.getMinOCDate(cntrNo, cnmvYr, cnmvSeq, cnmvSplitNo, "1");
	      
	      if (dmtOCMvmtVO == null || dmtOCMvmtVO.equals("")) {
	    	  return "";
	      }
	      
	      for(; ;) {
	          tmpDmtOCMvmtVO = new DmtOCMvmtVO();
	          tmpDmtOCMvmtVO = dbDao.getMinOCDate(cntrNo, dmtOCMvmtVO.getCnmvYr(), dmtOCMvmtVO.getCnmvSeq(), dmtOCMvmtVO.getCnmvSplitNo(), "2");
	          
	          if (tmpDmtOCMvmtVO == null || tmpDmtOCMvmtVO.equals("")) {
	        	  return "";
	          }
	          
	          if(tmpDmtOCMvmtVO.getMvmtStsCd().equals("EN") || tmpDmtOCMvmtVO.getMvmtStsCd().equals("TN") || tmpDmtOCMvmtVO.getMvmtStsCd().equals("OC") )
	          {
	            dmtOCMvmtVO = tmpDmtOCMvmtVO;
	            continue;
	          }
	          else if(!tmpDmtOCMvmtVO.getMvmtStsCd().equals("OC"))
	          {
	            break;
	          }
	      }
	    return dmtOCMvmtVO.getCnmvEvntDt();
	 }	

	/**
	 *  searchSCExceptionByGeneration Search
	 *  
	 *  [2015.04.28][CLT-000039159-04] SCG application for 45, flat rack and open top container
	 *               awkInOut 추가.
	 * 
	 * @param SCExceptionParmVO scExceptionParmVO
	 * @return DmtSCGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtSCGrpVO searchSCExceptionByGeneration(SCExceptionParmVO scExceptionParmVO) throws EventException, DAOException {
		DmtSCGrpVO dmtSCGrpVO = new DmtSCGrpVO();

		String	prmCntrTp			= nullToString(scExceptionParmVO.getCntrTp());
		String	prmCgoTp			= nullToString(scExceptionParmVO.getCgoTp());

		String	awkInOut			= nullToString(scExceptionParmVO.getAwkInOut()); //[CLT-000039159-04] 2015.04.28 Add.
		String	prmCntrCgoTp		= "";
	                                                
		/*------------------------------- CNTR & CGO Type Setting 
		D-Dry ("D" - "Dry")                    					1
		F-Reefer Dry ("R" - "Dry")         						2
		R-Reefer ("R" - "Reefer")          						3
		S-Spectial ("D" - "Danger", "F", "T", "O", "P", "A")  	4
		*/
		
		if( prmCntrTp.equals("D")){
			if( prmCgoTp.equals("DRY") || prmCgoTp.equals("AWK") ){
				prmCntrCgoTp = "D";     
			} else if( prmCgoTp.equals("DGR") ){
				prmCntrCgoTp = "S";		
			} else {
				dmtSCGrpVO.setMsgCd("-2");
				return	dmtSCGrpVO;
			}
		} else if( prmCntrTp.equals("R"))	{
			if( prmCgoTp.equals("DRY")){
				prmCntrCgoTp = "F"; 		
			} else if( prmCgoTp.equals("RFR")){
				prmCntrCgoTp = "R";		
			} else {
				dmtSCGrpVO.setMsgCd("-2");
				return	dmtSCGrpVO;
			}
		} else if (prmCntrTp.equals("T")) { //[CLT-000039159-04] 2015.04.28 Modify.
			prmCntrCgoTp = "S";	
		} else if( prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("P") || prmCntrTp.equals("A") || prmCntrTp.equals("S")){//2010.12.07. [CHM-201007392-01] 'A' 추가 , 2015.04.28 'S' 추가
			if(awkInOut.equals("O")){  //[CLT-000039159-04] 2015.04.28 Modify.
		       prmCntrCgoTp = "S";
		    }else{
		       prmCntrCgoTp = "D";
		    }		
		} else {
			dmtSCGrpVO.setMsgCd("-2");
			return	dmtSCGrpVO;
		}
		
		scExceptionParmVO.setCntrCgoTp(prmCntrCgoTp);
		
		dmtSCGrpVO = dbDao.searchSCExceptionByGeneration(scExceptionParmVO);
		dmtSCGrpVO.setMsgCd("0");
		return 	dmtSCGrpVO;
	}


	/**
	 * getSCEFreeTime Search
	 * 
	 * @param String prmScNo
	 * @param long prmVerSeq
	 * @param long prmGrpSeq
	 * @param long prmQty
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long getSCEFreeTime(String prmScNo, long prmVerSeq, long prmGrpSeq, long prmQty) throws EventException, DAOException {
		return dbDao.getSCEFreeTime(prmScNo, prmVerSeq, prmGrpSeq, prmQty);
	}


	/**
	 * scCalculationByBKG Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double scCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String		prmScNo				= nullToString(calculationParmVO.getPropNo());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmGrpSeq			= stringToLong(calculationParmVO.getGrpSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		
		log.debug("*******************************************************");
		log.debug("* [scCalculation] prmScNo 			:"+ prmScNo);
		log.debug("* [scCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [scCalculation] prmGrpSeq 			:"+prmGrpSeq);
		log.debug("* [scCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [scCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [scCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [scCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list  = dbDao.searchDivSChrgList(prmScNo, prmVerSeq, prmGrpSeq, prmCntrts, prmOverDay, prmDivOverDay);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 		= 0.0;
		
			dtrFtOver 	= stringToLong(list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong(list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble(list.get(0).getRtAmt());
		
			log.debug("*******************************************************");
			log.debug("* [scChrgRate] [0]");
			log.debug("* [sceChrgRate ] dtrFtOver[0]	:"+dtrFtOver);
			log.debug("* [sceChrgRate ] dtrFtUnder[0]	:"+dtrFtUnder);
			log.debug("* [sceChrgRate ] dtrRate[0]		:"+dtrRate);
			log.debug("*******************************************************");
				
				
		} /* End of the if clause */
		

		return dtrRate;
	}
	
	/**
	 *  scCalculation Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO 
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public CalculationAMTVO scCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		
		String		prmScNo			= nullToString(calculationParmVO.getPropNo());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmGrpSeq			= stringToLong(calculationParmVO.getGrpSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		double		rtnTotal			= 0.0;
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;
		long		underOverTerm		= 0;
		
		log.debug("*******************************************************");
		log.debug("* [scCalculation] prmScNo 			:"+ prmScNo);
		log.debug("* [scCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [scCalculation] prmGrpSeq 			:"+prmGrpSeq);
		log.debug("* [scCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [scCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [scCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [scCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		

		List<ChargeListVO> list = dbDao.searchDivSChrgList(prmScNo, prmVerSeq, prmGrpSeq, prmCntrts, prmOverDay, prmDivOverDay);


		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 	= 0.0;
				
				chrgDtlVO = new ChrgDtlVO();
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
				
				log.debug("[1.dtrFtOver]	:"+dtrFtOver);
				log.debug("[2.dtrFtOver]	:"+dtrFtUnder);
				log.debug("[3.dtrRate   ]	:"+dtrRate);
				
			
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the sceChrgRate ]");
					log.debug("*******************************************************");		
					
					break;
				}

				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));
				
				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){
					/* ________________ last rate level */
					if (prmDivOverDay == 0){
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
					}
				} else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ;

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						underOverTerm = 0;	
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}
				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [sceChrgRate ] "+ list.size() +"["+i+"]");
				log.debug("* [sceChrgRate ] dtrFtOver["+i+"]	:"+dtrFtOver);
				log.debug("* [sceChrgRate ] dtrFtUnder["+i+"]	:"+dtrFtUnder);
				log.debug("* [sceChrgRate ] dtrRate["+i+"]		:"+dtrRate);
				log.debug("* [sceChrgRate ] underOverTerm["+i+"]:"+underOverTerm);
				log.debug("* [sceChrgRate ] rtnTotal["+i+"]		:"+rtnTotal);
				log.debug("*******************************************************");		
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
		} /* End of the if clause */
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		if(list != null) {
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		}
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		return calculationAMTVO;
	}

	/**
	 *  searchExchangeRate Search
	 * 
	 * @param ExchangeRateParmVO exchangeRateParmVO
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double searchExchangeRate(ExchangeRateParmVO exchangeRateParmVO) throws EventException, DAOException {
		double exRate = 0;
		
		String		prmFmCurCd			= nullToString(exchangeRateParmVO.getFmCurCd());
		String		prmToCurCd			= nullToString(exchangeRateParmVO.getToCurCd());
		double		tmpUsdLcl			= 0	;
		double		tmpMonthlyRate		= 0	;
		double		acctRateFrom		= 0	;
		double		acctRateTo			= 0	;
		
		
		tmpUsdLcl = dbDao.getLCLExRate(exchangeRateParmVO, "1");
		if(tmpUsdLcl != 0)
		{
			exRate = tmpUsdLcl;
		}
		else
		{
			tmpUsdLcl = dbDao.getLCLExRate(exchangeRateParmVO, "2");
			if(tmpUsdLcl != 0)
			{
				exRate = tmpUsdLcl;
			}
			else
			{

				/* If Not Found Then Monthly Rate */
				acctRateFrom = dbDao.getMonthlyRate(prmFmCurCd);
				acctRateTo = dbDao.getMonthlyRate(prmToCurCd);
				if(acctRateFrom > 0 && acctRateTo > 0 ){
					tmpMonthlyRate = dbDao.getRoundRate(acctRateTo, acctRateFrom);
				} else {
					return -1;
				}
				
				exRate = tmpMonthlyRate;
				log.debug("==================");
				log.debug("[ORDER 3:]"+exRate);
				log.debug("==================");
			}
		}



		log.debug("==================");
		log.debug("[final rate:]"+exRate);
		log.debug("==================");
		return exRate;
	}


	/**
	 *  searchBFRExceptionByGeneration Search
	 * 
	 * @param BFRExceptionParmVO bfrExceptionParmVO
	 * @return DmtBFRGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtBFRGrpVO searchBFRExceptionByGeneration(BFRExceptionParmVO bfrExceptionParmVO) throws EventException, DAOException {
		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		
		String		prmScNo			= nullToString(bfrExceptionParmVO.getScNo());
		String		prmRfaNo		= nullToString(bfrExceptionParmVO.getRfaNo());
		String		prmCntrTp		= nullToString(bfrExceptionParmVO.getCntrTp());
		String		prmCgoTp		= nullToString(bfrExceptionParmVO.getCgoTp());
		String		actCustCntCd	= nullToString(bfrExceptionParmVO.getActCustCntCd());
		long   		actCustSeq    	= stringToLong(bfrExceptionParmVO.getActCustSeq()); 
		String		prmAwkInOut		= nullToString(bfrExceptionParmVO.getAwkInOut());
		
		
		/*------------------------------- CNTR & CGO Type Adjust */
		if(prmCntrTp.equals("D")){
			if(	prmCgoTp.equals("AWK") ||	prmCgoTp.equals("B/B") ||	prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("R")){
			if(	prmCgoTp.equals("AWK") || prmCgoTp.equals("DGR") ){
				prmCgoTp = "DRY";
			}
		}
		if(	!prmCntrTp.equals("D") && !prmCntrTp.equals("R") &&	prmCgoTp.equals("AWK")){
			if(prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			}
			else if(prmAwkInOut.equals("O")){
				prmCgoTp = "AWK";
			}
		}
		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("P")){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			}
		}
		if( prmCntrTp.equals("F") ){
			if( prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			}else if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("O") ){
			if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("S") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}
		if( prmCntrTp.equals("A") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "F";
			}
		}
		log.debug("*******************************************************");
		log.debug("* [cntrTp]"+prmCntrTp);
		log.debug("* [prmCgoTp]"+prmCgoTp);
		log.debug("*******************************************************");

		/* -------------------------------------- Set Searching Key */

		if( prmScNo.length() == 0 && prmRfaNo.length() == 0 ){
			dmtBFRGrpVO.setMsgCd("0");
			return	dmtBFRGrpVO;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() != 0 ) {
			actCustCntCd = "" ;
			actCustSeq	= 0;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() == 0  ) {
			;
		} else if( prmScNo.length() == 0 && prmRfaNo.length() != 0 ) {
			;
		}
			
		bfrExceptionParmVO.setCntrTp(prmCntrTp);
		bfrExceptionParmVO.setCgoTp(prmCgoTp);
		
		dmtBFRGrpVO = dbDao.searchBFRExceptionByGeneration(bfrExceptionParmVO);

		return 	dmtBFRGrpVO;
	}

	/**
	 * beforeCalculationByBKG Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return double
	 * @throws EventException 
	 * @throws DAOException 
	 */
	public double beforeCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String		prmDarNo			= nullToString(calculationParmVO.getDarNo());
		long		prmMapgNo			= stringToLong(calculationParmVO.getMapgSeq());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmDtlSeq			= stringToLong(calculationParmVO.getDtlSeq());
		long		prmCmbSeq			= stringToLong(calculationParmVO.getCmbSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		
		log.debug("*******************************************************");
		log.debug("* [beforeCalculation] prmDarNo 			:"+prmDarNo);
		log.debug("* [beforeCalculation] prmMapgNo 			:"+prmMapgNo);
		log.debug("* [beforeCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [beforeCalculation] prmDtlSeq 			:"+prmDtlSeq);
		log.debug("* [beforeCalculation] prmCmbSeq 			:"+prmCmbSeq);
		
		log.debug("* [beforeCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [beforeCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [beforeCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [beforeCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list = dbDao.searchDivBChrgList(prmDarNo, prmMapgNo, prmVerSeq, prmDtlSeq, prmCmbSeq, prmCntrts, prmOverDay, prmDivOverDay);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 	= 0.0;
		
			dtrFtOver 	= stringToLong((String) list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong((String) list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble((String) list.get(0).getRtAmt());

			log.debug("*******************************************************");
			log.debug("* [scChrgRate] [0]");
			log.debug("* [sceChrgRate ] dtrFtOver[0]	:"+dtrFtOver);
			log.debug("* [sceChrgRate ] dtrFtUnder[0]	:"+dtrFtUnder);
			log.debug("* [sceChrgRate] dtrRate[0]		:"+dtrRate);
			log.debug("*******************************************************");
		} /* End of the if clause */

		return dtrRate;
	}
	
	/**
	 * beforeCalculation Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @throws DAOException 
	 */
	public CalculationAMTVO beforeCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		String		prmDarNo			= nullToString(calculationParmVO.getDarNo());
		long		prmMapgNo			= stringToLong(calculationParmVO.getMapgSeq());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmDtlSeq			= stringToLong(calculationParmVO.getDtlSeq());
		long		prmCmbSeq			= stringToLong(calculationParmVO.getCmbSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		double		rtnTotal			= 0.0;
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;
		long		underOverTerm			= 0;
		
		log.debug("*******************************************************");
		log.debug("* [beforeCalculation] prmDarNo 			:"+prmDarNo);
		log.debug("* [beforeCalculation] prmMapgNo 			:"+prmMapgNo);
		log.debug("* [beforeCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [beforeCalculation] prmDtlSeq 			:"+prmDtlSeq);
		log.debug("* [beforeCalculation] prmCmbSeq 			:"+prmCmbSeq);
		log.debug("* [beforeCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [beforeCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [beforeCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [beforeCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list = dbDao.searchDivBChrgList(prmDarNo, prmMapgNo, prmVerSeq, prmDtlSeq, prmCmbSeq, prmCntrts, prmOverDay, prmDivOverDay);
		
		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if (list != null && list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 		= 0.0;
				
				chrgDtlVO = new ChrgDtlVO();
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
						
				log.debug("[1.dtrFtOver] :"+dtrFtOver);
				log.debug("[2.dtrFtOver] :"+dtrFtUnder);
				log.debug("[3.dtrRate   ]:"+dtrRate);
				
	
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the BFRChrgRate ]");
					log.debug("*******************************************************");		
					
					break;
				}
				
				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));
				
				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){
					/* ________________ last rate level */
					if (prmDivOverDay == 0){
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
					}
				} 
				else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ;

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						underOverTerm = 0;	/* 지나간 Balance rate 금액 */
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}

				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [BFRChrgRate ] "+ list.size() +"["+i+"]");
				log.debug("* [BFRChrgRate ] dtrFtOver["+i+"]	:"+dtrFtOver);
				log.debug("* [BFRChrgRate ] dtrFtUnder["+i+"]	:"+dtrFtUnder);
				log.debug("* [BFRChrgRate ] dtrRate["+i+"]		:"+dtrRate);
				log.debug("* [BFRChrgRate ] underOverTerm["+i+"]:"+underOverTerm);
				log.debug("* [BFRChrgRate ] rtnTotal["+i+"]		:"+rtnTotal);
				log.debug("*******************************************************");
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
		} /* End of the if clause */
		
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		if(list != null) {
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		}
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		return calculationAMTVO;
	}
	
	

	/**
	 * searchAFTExceptionByGeneration Search
	 * 
	 * @param AFTExceptionParmVO aftExceptionParmVO
	 * @return DmtAFTGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtAFTGrpVO searchAFTExceptionByGeneration(AFTExceptionParmVO aftExceptionParmVO) throws EventException, DAOException {
		return dbDao.searchAFTExceptionByGeneration(aftExceptionParmVO);
	}
	

	/**
	 *  trimCurrencyAmount Search
	 * 
	 * @param String currencyCode
	 * @param double oriAmount
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 */
	public double trimCurrencyAmount(String currencyCode, double oriAmount ) throws EventException{
		String	prmCur		= "";
		double	prmAmt		= 0.0;
		double  tmpAmt		= 0.0;

		prmCur = currencyCode;
		prmAmt = oriAmount;
		
		if	(	prmCur.equals("KRW") || prmCur.equals("JPY") ||
				prmCur.equals("BEF") || prmCur.equals("DJF") ||
				prmCur.equals("ESP") || prmCur.equals("GRD") ||
				prmCur.equals("ITL") || prmCur.equals("LAK") ||
				prmCur.equals("MGF") || prmCur.equals("MRO") ||
				prmCur.equals("MXP") || prmCur.equals("PTE") ||
				prmCur.equals("SDD") || prmCur.equals("MXN")){ 
			
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "1");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("1 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("1 trimCurrencyAmount Select Error ! " + new ErrorHandler(e).getMessage());
			}
		} 
		else if( prmCur.equals("TWD") || prmCur.equals("IDR") || prmCur.equals("VND") ) {
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "2");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("2 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("2 trimCurrencyAmount Select Error !" + new ErrorHandler(e).getMessage());
			}
		} 
		else {
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "3");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("3 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("3 trimCurrencyAmount Select Error !" + new ErrorHandler(e).getMessage());
			}
		}

		return tmpAmt ;
	}
	
	
	/**
	 *  overdayNDiv Search
	 * 
	 * @param OverdayNDivParmVO overdayNDivParmVO
	 * @return OverdayNDivVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public OverdayNDivVO overdayNDiv(OverdayNDivParmVO overdayNDivParmVO) throws EventException, DAOException{
		OverdayNDivVO overdayNDivVO = new OverdayNDivVO();
		
		/* ____ Exist Checking */
		overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO,"EXIST_CHECK");
		log.debug("*******************************************************");
		log.debug("* EXIST Checking :"+overdayNDivVO.getDivOverDay());
		log.debug("*******************************************************");
		
		if( overdayNDivVO.getDivOverDay() == null){
			overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO, "NOT_EXIST");
		} else {
			overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO, "EXIST");			
		}
		
		return overdayNDivVO;
		
	}

	/**
	 *  searchCalculationType Search <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchCalculationType(CalculationTypeParmVO calculationTypeParmVO) throws EventException, DAOException{
		
		//String prmCntCd = nullToString(calculationTypeParmVO.getCntCd());
		//String prmLocCd = nullToString(calculationTypeParmVO.getLocCd());
		//String prmIoBnd = nullToString(calculationTypeParmVO.getIoBnd());
		//String prmBcntrDlvTerm = nullToString(calculationTypeParmVO.getBcntrDlvTerm(), 1);
		//String prmPodLoc = nullToString(calculationTypeParmVO.getPodLoc(), 5);
		String dcCalcTp = "";
		
		//추가
		//String prmPorLoc = nullToString(calculationTypeParmVO.getPorLoc(), 5);
		//String prmPolLoc = nullToString(calculationTypeParmVO.getPolLoc(), 5);
		//String prmDelLoc = nullToString(calculationTypeParmVO.getDelLoc(), 5);
		
		log.debug("*****************************************************************");
		log.debug("[searchCalculationType(param)]getCntCd() 	: "+ calculationTypeParmVO.getCntCd());
		log.debug("[searchCalculationType(param)]getRgnCd() 	: "+ calculationTypeParmVO.getRgnCd());
		log.debug("[searchCalculationType(param)]getStateCd() 	: "+ calculationTypeParmVO.getStateCd());
		log.debug("[searchCalculationType(param)]getLocCd() 	: "+ calculationTypeParmVO.getLocCd());
		log.debug("[searchCalculationType(param)]getIoBnd() 	: "+ calculationTypeParmVO.getIoBnd());
		log.debug("[searchCalculationType(param)]getEffDt() 	: "+ calculationTypeParmVO.getEffDt());
		log.debug("[searchCalculationType(param)]getBcntrDlvTerm() : "+ calculationTypeParmVO.getBcntrDlvTerm());
		log.debug("[searchCalculationType(param)]getPodLoc() 	: "+ calculationTypeParmVO.getPodLoc());
		log.debug("[searchCalculationType(param)]getPorLoc() 	: "+ calculationTypeParmVO.getPorLoc());
		log.debug("[searchCalculationType(param)]getPolLoc() 	: "+ calculationTypeParmVO.getPolLoc());
		log.debug("[searchCalculationType(param)]getDelLoc() 	: "+ calculationTypeParmVO.getDelLoc());
		log.debug("[searchCalculationType(param)]getPodEtaFlg() : "+ calculationTypeParmVO.getPodEtaFlg());
		log.debug("*****************************************************************");
		
		dcCalcTp = dbDao.searchCalculationType(calculationTypeParmVO);
		log.debug("[ReturnValue:searchCalculationType] : "+ dcCalcTp);

		
		return dcCalcTp;
	}

	/**
	 *  checkChargeCorrection Search <br>
	 * Charge의 Correction History가 존재하는지 여부를 조회하여 존재시 1을, 미존재시 0을 Return한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public int checkChargeCorrection(ChargeArgumentVO chargeArgumentVO) throws EventException, DAOException{
	
		int corrHisSeq = 0;
		int retValue = 0;
		
		retValue = dbDao.checkChargeCorrection(chargeArgumentVO);
	
		// check Correction History of charge, exist --> 1, not exist --> 0
		if(retValue > 0){
			corrHisSeq = retValue;
		} else {
			corrHisSeq = 0;
		}
			
		log.debug("[ReturnValue:checkChargeCorrection]>> : "+ corrHisSeq);
		return corrHisSeq;
	}
	
	/**
	 *  bbsChargeCalculation Search
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @exception EventException
	 */
	public CalculationAMTVO bbsChargeCalculation(CalculationParmVO calculationParmVO) throws EventException{
		
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		
		String		zDcApplRate	= nullToString(calculationParmVO.getDcApplRate(), 1);

		/*_________ basicCalculation */
		String 		zSvrId   	= nullToString(calculationParmVO.getSvrId());
		String		zDttCode	= nullToString(calculationParmVO.getDmdtTrfCd());
		long		zDtnSeq		= stringToLong(calculationParmVO.getTrfSeq());
		long		zDtgGrpId	= stringToLong(calculationParmVO.getTrfGrpSeq());
		String		zCntrtsCd	= nullToString(calculationParmVO.getCntrts());
		

		/*_________ beforeCalculation */
		String		zRfaDarNo	= nullToString(calculationParmVO.getDarNo());
		long		zRfaMapgSeq	= stringToLong(calculationParmVO.getMapgSeq());
		long		zRfaVerSeq	= stringToLong(calculationParmVO.getVerSeq());
		long		zRfaDtlSeq	= stringToLong(calculationParmVO.getDtlSeq());

		/*_________ scCalculation */
		String		zScNo		= nullToString(calculationParmVO.getPropNo());
		long		zScVerSeq	= stringToLong(calculationParmVO.getVerSeq());
		long		zScGrpSeq	= stringToLong(calculationParmVO.getGrpSeq());

		long		zOverDay	= stringToLong(calculationParmVO.getOverDay());
		long		zDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		String		zCurCd		= nullToString(calculationParmVO.getCurCd());

		String		rtnRateCurCd		= 		"";

		if(zDcApplRate.substring(0, 1).equals("G") ){		/* Baisc Tariff			*/
			
			calculationParmVO.setSvrId(zSvrId  );
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));
			
			try {
				calculationAMTVO = basicCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*[bbsChargeCalculation]  basicCalculation Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("[bbsChargeCalculation]  basicCalculation Function Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			// case in No Charge,   return same curCd and  invCurCd 
			rtnRateCurCd = zCurCd;	
			
		} 
		else if(zDcApplRate.substring(0, 1).equals("B") ){   			/* Before BKG Exception	*/
		
			calculationParmVO.setDarNo(zRfaDarNo);
			calculationParmVO.setMapgSeq(String.valueOf(zRfaMapgSeq));
			calculationParmVO.setVerSeq(String.valueOf(zRfaVerSeq));
			calculationParmVO.setDtlSeq(String.valueOf(zRfaDtlSeq));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));	
			
			try {
				calculationAMTVO = beforeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*[bbsChargeCalculation]  beforeCalculation Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("[bbsChargeCalculation]  beforeCalculation Function Error :" + new ErrorHandler(e).getMessage());
			}
			
			try {
				rtnRateCurCd = dbDao.bbsChargeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Rate Cur Select Error ! :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Rate Cur Select Error ! :" + new ErrorHandler(e).getMessage());
			}
			
			
		} 
		else if (zDcApplRate.substring(0, 1).equals("S")){   			/* SC Exception			*/
	
			calculationParmVO.setPropNo(zScNo);
			calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
			calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));

			try {
				calculationAMTVO = scCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("scCalculation Function Error !  ");
				log.error("*******************************************************");
				throw new EventException("scCalculation Function Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			try {
				rtnRateCurCd = dbDao.bbsChargeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Rate Cur Select Error! :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Rate Cur Select Error! :" + new ErrorHandler(e).getMessage());
			}
			
		}		// END OF THE zDccApplRate

		calculationAMTVO.setRateCurCd(rtnRateCurCd);
		return calculationAMTVO;
	}
	
	
	
	
	/**
	 *  searchDualTypeException Search
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDualTypeException(ChargeCalculationParmVO chargeCalculationParmVO) 
	 throws EventException{
	  
	//  ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
	  //parameter values
	  containerCargoTypeParmVO  = new ContainerCargoTypeParmVO();
	  FixPOLLocationParmVO   fixPOLLocationParmVO   = new FixPOLLocationParmVO();
	  FixPODLocationParmVO   fixPODLocationParmVO   = new FixPODLocationParmVO();
	  LocationByBoundParmVO   locationByBoundParmVO   = new LocationByBoundParmVO();
	  FixDELLocationParmVO   fixDELLocationParmVO   = new FixDELLocationParmVO();
	  SCExceptionParmVO    scExceptionParmVO    = new SCExceptionParmVO();
	  BFRExceptionParmVO    bfrExceptionParmVO    = new BFRExceptionParmVO();
	  
	  //param local variables 
	  String zSvrId       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());
	  String zCntrNo      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
	  long   zCnmvCycNo   = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
	  String zBkgNo       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBkgNo());
	  String zDcFmDate    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
	  String zDcFmYdCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
	  String zDcFmCnms    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
	  String zDcToDate    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
	  String zDcToYdCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
	  String zDcToCnms    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
	  String zDttCode     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
	  String zCntrtsCd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrTpszCd());
	  String zDbcIoBnd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getIoBndCd());
	  String zCustCntCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustCntCd());
	  String zCustCd      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustSeq());
	  String zAczCnzCd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCntCd());
	  String zAczCuszCd   = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCustSeq());
	  
	  log.debug("***********************************************************");
	  log.debug("[ChargeCalculationParmVO]>> zSvrId    :"+ zSvrId  );
	  log.debug("[ChargeCalculationParmVO]>> zCntrNo    :"+ zCntrNo  );
	  log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo   :"+ zCnmvCycNo   );
	  log.debug("[ChargeCalculationParmVO]>> zDcFmDate  :"+ zDcFmDate);
	  log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd  :"+ zDcFmYdCd);
	  log.debug("[ChargeCalculationParmVO]>> zDcFmCnms  :"+ zDcFmCnms);
	  log.debug("[ChargeCalculationParmVO]>> zDcToDate  :"+ zDcToDate);
	  log.debug("[ChargeCalculationParmVO]>> zDcToYdCd  :"+ zDcToYdCd);
	  log.debug("[ChargeCalculationParmVO]>> zDcToCnms  :"+ zDcToCnms);
	  log.debug("[ChargeCalculationParmVO]>> zDttCode  :"+ zDttCode);
	  log.debug("[ChargeCalculationParmVO]>> zCntrtsCd  :"+ zCntrtsCd);
	  log.debug("[ChargeCalculationParmVO]>> zDbcIoBnd  :"+ zDbcIoBnd);
	  log.debug("[ChargeCalculationParmVO]>> zCustCntCd  :"+ zCustCntCd);
	  log.debug("[ChargeCalculationParmVO]>> zCustCd   :"+ zCustCd);
	  log.debug("[ChargeCalculationParmVO]>> zAczCnzCd  :"+ zAczCnzCd);
	  log.debug("[ChargeCalculationParmVO]>> zAczCuszCd  :"+ zAczCuszCd);
	  log.debug("*************************************************************");
	//////////////////////  START   defind variables    /////////////////
	  
	  String zBlNo   = "";  
	  
	  String zPorContiCd   = ""; 
	  String zPorCntCd   = ""; 
	  String zPorRgnCd   = ""; 
	  String zPorStateCd   = ""; 
	  
	  String zPolContiCd  = "";                                                      
	  String zPolCntCd  = "";                                                      
	  String zPolRgnCd  = "";                                                      
	  String zPolStateCd  = "";                                                      
	  
	  String zDelContiCd  = "";                                                      
	  String zDelCntCd  = "";                                                      
	  String zDelRgnCd  = "";                                                      
	  String zDelStateCd  = "";                                                      
	  
	  String zYrdContiCd  = "";                                                      
	  String zYrdLoc   = "";                                                      
	  String zYrdCntCd  = "";                                                      
	  String zYrdRgnCd  = "";                                                      
	  String zYrdStateCd  = "";                                                      
	  
	  String fixPodLoc  = "";                                                                                      
	  
	  String fixDelContiCd = "";                                                                      
	  String fixDelCntCd  = "";                                                                     
	  String fixDelRgnCd  = "";                                                                      
	  String fixDelStateCd = "";                                                                       
	  String fixDelLoc  = "";    
	  
	  String zPorLoc   = "";                                                      
	  String zPodLoc   = "";                                                      
	  String zPolLoc   = "";                                                      
	  String zDelLoc   = "";                                                      
	  
	  String zPostRly   = "";                                                      
	  String zBcntrSpeDg  = "";                                                      
	  String zBcntrSpeRf  = "";                                                      
	  String zBcntrSpeAk  = "";                                                      
	  String zBcntrSpeRd  = "";                                                      
	  String zBcntrSpeBb  = "";                                                      
	  String zBcntrSocInd  = "";                                                      
	  String zBcntrPartial = "";                                                      
	  String zBcntrExcept  = "";                                                      
	  
	//  String zOfcCd   = "";                                              
	//  String zOfcRhq   = ""; 
	//  String zCollectYn  = "";   
	  
	  String zSalOfc   = "";                                                      
	  String zSalRhq   = "";                                                      
	  String zBcntrDlvTerm = "";                                              
	  String bkgCntCd   = "";                                                      
	  String bkgRgnCd   = "";                                                      
	  String bkgStateCd  = "";                                                      
	  String bkgLocCd   = "";                                                      
	  String zVslCd   = "";                                              
	  String zSkdVoyageNo  = "";                                                      
	  String zSkdDirCd  = "";                                                      
	  String zVpsEtaDt  = "";                                                      
	  String dtgEfftDt  = "";                                                      
	  String fixDtgEfftDt  = "";   /*___ InBound VL Date */                                            
	  String zDcsCntrTp  = "";                                                      
	  String zDcsCgoTp  = "";                                                      
	//  long   zDbcBkgQty  = 0;    
	  
	//  long   zDtnSeq   = 0;                                           
	//  long   zDtgGrpId  = 0;                                             
	//  String dtgCmncTp  = "";                                                      
	//  String dtgCmncHr  = "";                                                      
	//  String dtgExclSat  = "";                                                      
	//  String dtgExclSun  = "";                                                      
	//  String dtgExclHoli  = "";                                                      
	//  String zCurCd   = "";                                              
	//  long   zDcFtDays  = 0;                                           
	//  String zDcFtCmnc  = "";                                                      
	//  String zDcFtEnd   = "";                                                      
	//  long   zDcFtOver  = 0;                                                                                           
	//  String zDcStatus  = "";    
	  
	//  long   zDcOrgOver  = 0;                                             
	//  long   zDcBfrOver  = 0;                                             
	//  long   zDcAftOver  = 0;  
	  
	//  String zDcApplRate  = "";                                                      
	//  double zDcOrgAmt  = 0;                                               
	//  double zDcExpAmt  = 0;                                               
	//  double zDcDscAmt  = 0;                                               
	//  double zDcBillAmt  = 0;                                              
	//  double zDcBfrAmt  = 0;                                              
	//  double zDcAftAmt  = 0;    
	  
	  //S/C
	  String zBrhScNo   = "";                                                      
	  String zBrhRfaNo  = "";                                                      
	                                                                 
	//  String zScNo   = "";    //propNo
	//  long   zScVerSeq  = 0;                                             
	//  long   zScGrpSeq  = 0; 
	  
	//  String dsdFtimeMk  = "";                                                      
	//  String dsdExclSat  = "";                                                      
	//  String dsdExclSun  = "";                                                      
	//  String dsdExclHoli  = "";                                                      
	//  String dsdFtAddMk  = "";                                                      
	//  long   dsdFtAddDay  = 0;                                                     
	//  String dsdFtAdjMk  = "";                                                      
	//  String dsdRtAdjMk  = "";                                                      
	//  String dsdCurCd   = "";    
	  
	  //COMMODITY
	  String zCmdtCd   = "";     
	//  String zCmdtCdC   = "";     
	  String zRepCmdtCd  = "";                                                      
	  
	//  String dcrExclSat  = "";                                                      
	//  String dcrExclSun  = "";                                                      
	//  String dcrExclHoli  = "";                                                      
	//  long   zDcrSeq   = 0;                                                
	//  long   dcrAddDay  = 0;                                                
	//  long   dcrTtlDay  = 0;                                                
	//  long   zDcCmdtOver  = 0;                                                        
	//  double zDcCmdtAmt  = 0;           
	  
	  
	  //RFA -  BEFORE
	//  String zApprNo   = ""; 
	//  String zDarNo   = ""; 
	//  long   zMapgSeq   = 0;  
	//  long   zVerSeq   = 0;  
	//  long   zDtlSeq   = 0;  
	//  long   zCmbSeq   = 0;
	  
	//  String dbdFtimeMk  = "";                                                      
	//  long   dbdAddDay  = 0;                                                
	//  long   dbdTtlDay  = 0;                                               
	//  String dbdExclSat  = "";                                                      
	//  String dbdExclSun  = "";                                                      
	//  String dbdExclHoli  = "";                                                      
	//  String dbdRateMk  = "";                                                      
	//  String dbdCurCd   = "";                                                      
	 
	  //AFTER
	//  String zAftApprNo  = "";                                                      
	//  String zAftDarNo  = "";                                                      
	//  long   zAftAdjSeq  = 0;  
	//  String dadFtimeMk  = "";                                                      
	//  long   dadAddDay  = 0;                                              
	//  long   dadTtlDay  = 0;                                              
	//  String dadExclSat  = "";                                                      
	//  String dadExclSun  = "";                                                      
	//  String dadExclHoli  = "";                                                      
	//  String dadDcMk   = "";                                                      
	//  String dadCurCd   = "";                                                      
	//  double dadDcAmt   = 0;                                                
	//  double dadDcRate  = 0;                                                
	  
	  String fixPolLoc  = "";
	  String zPreRly   = "";
	  
	  /* ------------------------------------------- */
	  
	//  long   rateDtlCnt   = 0;
	//  double getBfrExRate  = 1.0; 
	//  double getAftExRate  = 1.0; 
	  
	//  long   zDtocFtime  = 0;   
	  
	//  double tmp1    = 0;     
	//  double tmp2    = 0;
	  
	//  String zFixedVlDt  = ""; 
	//  String zFixedCmnc  = ""; 
	  
	//  String zWebMtDate  = ""; 
	  
	  String actCustCntCd   = ""; 
	  long   actCustSeq      = 0;                                              
	  String awkInOut   = "";    
	  
	//  List<String> cstopNoList = null;
	//  long  idxCstop = 0;
	  
	  String tmpTsp   = ""; 
	//  String zOrgContiCd  = "";
	//  String zOrgCntCd  = "";
	//  String zOrgRgnCd  = "";
	//  String zOrgStateCd  = "";
	//  String zOrgLocCd  = "";
	  
	  String dualFlag   = "N";
	  
	  //////////////////////END   defind variables    /////////////////   
	  
	  /*
	  [1.logic] Set CNTR TYPE 
	  */
	  zDcsCntrTp = DMTCalculationUtil.nullToString(zCntrtsCd,1).substring(0, 1);
	  if(zDcsCntrTp.equals("P")){
	   zDcsCntrTp = "F";
	  }
	 
	  /*  
	  [2.logic] Booking Container  information get280
	  
	  */
	  BkgContainerInfoVO bkgContainerInfoVO = null;
	  
	   try {
	    bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo  , zCntrNo  , zDcFmYdCd , "");
	    log.debug("** searchBkgContainerInfo end ***");
	   }catch(Exception e) {
	    log.error("*******************************************************");
	    log.error("Invalid BKG No ! : "+zBkgNo   +", "+ zCntrNo   +", "+ zDcFmYdCd);
	    log.error("*******************************************************");
	    throw new EventException("searchBkgContainerInfo Select Error ! : " + new ErrorHandler(e).getMessage());
	   }
	   zBlNo    = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBlNo());
	   zBrhScNo   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getScNo());
	   zBrhRfaNo   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRfaNo());
	  
	   zCmdtCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCmdtCd());
	   zRepCmdtCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRepCmdtCd());
	   zBcntrSpeDg  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDcgoFlg());
	   zBcntrSpeRf  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcFlg());
	   
	   zBcntrSpeAk  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAwkCgoFlg());
	   zBcntrSpeRd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRdCgoFlg());
	   zBcntrSpeBb  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbCgoFlg());
	   zBcntrSocInd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSocFlg());
	   zBcntrPartial  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCntrPrtFlg());
	   zBcntrExcept  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAdvShtgCd());
	   
	   zPorLoc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCd());
	   zPolLoc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCd());
	   zPodLoc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPodCd());
	   zDelLoc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCd());
	   zYrdLoc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
	   
	   zSalOfc   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getObSlsOfcCd());
	   zSalRhq   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSalRhq());
	   
	   /********************************************************************/
	   zPorContiCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorContiCd());
	   zPorCntCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCntCd());
	   zPorRgnCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorRgnCd());
	   zPorStateCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorSteCd());
	   
	   zPolContiCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolContiCd());
	   zPolCntCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCntCd());
	   zPolRgnCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolRgnCd());
	   zPolStateCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolSteCd());
	   
	   zDelContiCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelContiCd());
	   zDelCntCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCntCd());
	   zDelRgnCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelRgnCd());
	   zDelStateCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelSteCd());
	   
	   
	   zYrdContiCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdContiCd());
	   zYrdCntCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCntCd());
	   zYrdRgnCd   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdRgnCd());
	   zYrdStateCd  = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdSteCd());
	 
	   zPostRly   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPstRlyPortCd(), 5);
	   zBcntrDlvTerm = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
	   zPreRly   = DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPreRlyPortCd(), 5);
	 
	    
	   /*
	   [3.logic] Cargo type decision : Set Cntr & Cgo Type
	   */
	   containerCargoTypeParmVO.setDcgoFlg(zBcntrSpeDg);
	   containerCargoTypeParmVO.setRcFlg(zBcntrSpeRf);
	   containerCargoTypeParmVO.setAwkCgoFlg(zBcntrSpeAk);
	   containerCargoTypeParmVO.setRdCgoFlg(zBcntrSpeRd);
	   containerCargoTypeParmVO.setSocFlg(zBcntrSocInd);
	   containerCargoTypeParmVO.setBbCgoFlg(zBcntrSpeBb);
	   
	   containerCargoTypeVO = settingContainerCargoType(containerCargoTypeParmVO);
	   zDcsCgoTp = containerCargoTypeVO.getCgoTp();
	 
	   
	   /*
	   [4.logic] Booking I/O Bound Location decision :  Set In/Out Bound
	   */
	   locationByBoundParmVO.setIoBnd(zDbcIoBnd);
	   locationByBoundParmVO.setPorCntCd(zPorCntCd);
	   locationByBoundParmVO.setPorRgnCd(zPorRgnCd);
	   locationByBoundParmVO.setPorStateCd(zPorStateCd);
	   locationByBoundParmVO.setPorLocCd(zPorLoc);
	   
	   locationByBoundParmVO.setDelCntCd(zDelCntCd);
	   locationByBoundParmVO.setDelRgnCd(zDelRgnCd);
	   locationByBoundParmVO.setDelStateCd(zDelStateCd);
	   locationByBoundParmVO.setDelLocCd(zDelLoc);
	   
	   LocationByBoundVO locationByBoundVO = setLocationByBound(locationByBoundParmVO);
	   bkgCntCd   = locationByBoundVO.getBkgCntCd();
	   bkgRgnCd    = locationByBoundVO.getBkgRgnCd();
	   bkgStateCd  = locationByBoundVO.getBkgStateCd();
	   bkgLocCd    = locationByBoundVO.getBkgLocCd();
	   
	  
	   /*
	   [5.logic] POD Loc Fix
	   */
	   fixPODLocationParmVO.setPodCd(zPodLoc);
	   fixPODLocationParmVO.setDelCd(zDelLoc);
	   fixPODLocationParmVO.setPostRly(zPostRly);
	   fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 
	   fixPodLoc = DMTCalculationUtil.nullToString(fixPODLocation(fixPODLocationParmVO), 5);
	   
	   if( !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPodLoc,5).substring(0,5)) && 
	      DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5)) &&  
	       ( DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEBRE") ||
	         DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("BEANR"))
	       && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD") ){
	     
	    return dualFlag;
	   }
	   
	   
	   /*
	   [6.logic] POL Loc Fix
	   */
	   fixPOLLocationParmVO.setPorCd(zPorLoc);
	   fixPOLLocationParmVO.setPolCd(zPolLoc);
	   fixPOLLocationParmVO.setPreRly(zPreRly);
	   fixPOLLocationParmVO.setBkgNo(zBkgNo); //2010.03.26
	   fixPolLoc = fixPOLLocation(fixPOLLocationParmVO);
	   
	   if( !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPolLoc,5).substring(0,5)) && 
	      DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5)) &&  
	       ( DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEBRE") ||
	         DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("BEANR"))
	        && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD") ){    
	      
	    return dualFlag;
	   }
	   
	   /*
	   [7.logic] Booking VVD, ETA  get : Get VVD & ETA Date
	   */
	   VVDNEtaVO vvEtaVO = null;
	   try {
	    vvEtaVO = searchVVDNEta(zBkgNo  , fixPolLoc, fixPodLoc, zDbcIoBnd);
	    log.debug("** searchVVDNEta end ***");
	    zVslCd   = DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
	    zSkdVoyageNo = DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
	    zSkdDirCd  = DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
	    zVpsEtaDt  = DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt());
	   }catch(Exception e) {
	    log.error("*******************************************************");
	    log.error("searchVVDNEta Function Error !  " + e.getMessage());
	    log.error("*******************************************************");
	    throw new EventException("searchVVDNEta Function Error ! : " + new ErrorHandler(e).getMessage());
	   }
	   
	   
	   /*
	   [8.logic] Tariff Effective Date decision : Set Tariff Effective Date
	   */
	   if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
	    dtgEfftDt = DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8);
	   } else {
	    dtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
	   }
	   
	   /*
	   [9.logic] Booking DEL Location decision :  BKG DEL Loc Fix
	    According to (POD->DEL), decision apply  DEL Tariff to POD Tariff 
	    case in EUR T/S ,apply  DEL Tariff to POST/PRE RLY
	   */
	   fixDELLocationParmVO.setDmdtTrfCd(zDttCode);
	   fixDELLocationParmVO.setPodCd(zPodLoc);
	   fixDELLocationParmVO.setDelCd(zDelLoc);
	   fixDELLocationParmVO.setDeTermCd(zBcntrDlvTerm);
	   fixDELLocationParmVO.setFmMvmtStsCd(zDcFmCnms);
	   fixDELLocationParmVO.setToMvmtStsCd(zDcToCnms);
	   fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
	   fixDELLocationParmVO.setTspFlag(tmpTsp);
	   fixDELLocationParmVO.setPostRly(zPostRly);
	   fixDELLocationParmVO.setPreRly(zPreRly);
	   FixDELLocationVO fixDELLocationVO;
	   try {
	    fixDELLocationVO = fixDELLocation(fixDELLocationParmVO);
	   }catch(Exception e) {
	    log.error("*******************************************************");
	    log.error("fixDELLocation Function Error !  " + e.getMessage());
	    log.error("*******************************************************");
	    throw new EventException("fixDELLocation Function Error ! : " + new ErrorHandler(e).getMessage());
	   }
	   if(fixDELLocationVO.getMsgCd().equals("1")){
	    fixDelContiCd = DMTCalculationUtil.nullToString(fixDELLocationVO.getDelContiCd());
	    fixDelCntCd  = DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCntCd());
	    fixDelRgnCd  = DMTCalculationUtil.nullToString(fixDELLocationVO.getDelRgnCd());
	    fixDelStateCd = DMTCalculationUtil.nullToString(fixDELLocationVO.getDelSteCd());
	    fixDelLoc  = DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCd()); 
	   } 
	   else if(fixDELLocationVO.getMsgCd().equals("0")){
	    /* Not Changed */
	    fixDelContiCd  = zDelContiCd;
	    fixDelCntCd  = zDelCntCd;
	    fixDelRgnCd  = zDelRgnCd;
	    fixDelStateCd  = zDelStateCd;
	    fixDelLoc   = zDelLoc;
	   }
	   
	   /*
	   [10.logic] Awkward In/Out-Gauge
	   */
	   try {
	    awkInOut = searchInOutGauge(zCntrNo  , zBkgNo  );
	   }catch(Exception e) {
	    log.error("*******************************************************");
	    log.error("searchInOutGauge Function Error !  " + e.getMessage());
	    log.error("*******************************************************");
	    throw new EventException("searchInOutGauge Function Error ! : " + new ErrorHandler(e).getMessage());
	   }
	 
	   /*
	   [11.logic] OutBound first 'OCVL' Data Checking
	    */
	   /*
	   [logic] OutBound first 'OCVL' Data Checking
	   *  SC  :: OutBound 1 order: OC DATE , 2 order:From Mvmt Date 
	   *  SC  :: InBound  1 order: OC DATE , 2 order:POL ETA 
	   *  RFA :: OutBound 1 order: POL ETA , 2 order:From Mvmt Date 
	   *  RFA :: InBound  1 order: VL DATE , 2 order:POL ETA 
	   */
	   log.debug("*******************************************************");
	   log.debug("* [logic] OutBound first 'OCVL' Data Checking ");
	   log.debug("*******************************************************");
	   
	   VVDNEtaVO polEta = new VVDNEtaVO();
	   try {
	    polEta    = searchVVDNEta(zBkgNo, fixPolLoc, "", "I/O"); 
	   }catch(Exception e) {
	    log.error("*******************************************************");
	    log.error("searchVVDNEta Function Error !  " + e.getMessage());
	    log.error("*******************************************************");
	    throw new EventException("searchVVDNEta Function Error ! : " + new ErrorHandler(e).getMessage());
	   }
	   
	   log.debug("*******************************************************");
	   log.debug(" POL ETA DATE:: "+ DMTCalculationUtil.nullToString(polEta.getVpsEtaDt()));
	   log.debug("*******************************************************");
	   
	   if( zDbcIoBnd.equals("I") ){    
	    if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {
	     //[InBound SC CASE]
	     try {
//			      fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "OP"));
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCDate(zBkgNo, zCntrNo, zDcFmDate, zDcFmYdCd, zDcFmCnms)); 
	     }catch(Exception e) {
	      log.error("*******************************************************");
	      log.error("InBound SC getMinOCDate Function Error !  "+e.getMessage());
	      log.error("*******************************************************");
	      throw new EventException("InBound SC getMinOCDate Function Error ! : " + new ErrorHandler(e).getMessage());
	     }
	     //no OC Date --> POL ETA
	     if(fixDtgEfftDt.length() == 0){
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
	     } 
	     log.debug("*******************************************************");
	     log.debug(" [InBound SC CASE]:: "+ fixDtgEfftDt);
	     log.debug("*******************************************************");
	    } else if( zBrhRfaNo.length() != 0 ){
	     //[InBound RFA CASE]
	     try {
//			      fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "VL", "OP"));
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "VL", "VD"));
	     }catch(Exception e) {
	      log.error("*******************************************************");
	      log.error("InBound RFA getMinOCVLDate Function  Error ! "+e.getMessage());
	      log.error("*******************************************************");
	      throw new EventException("InBound RFA getMinOCVLDate Function  Error ! " + new ErrorHandler(e).getMessage());
	     }
	     //no  VL Date --> POL ETA로
	     if(fixDtgEfftDt.length() == 0){
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
	     } 
	     log.debug("*******************************************************");
	     log.debug(" [InBound RFA CASE]:: "+ fixDtgEfftDt);
	     log.debug("*******************************************************");
	    }
	   } 
	   else {   // OutBound  :: COPY: dtgEfftDt ===> fixDtgEfftDt 
	    if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) { 
	     //[OutBound SC CASE]
	     try {
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "VD"));
	     }catch(Exception e) {
	      log.error("*******************************************************");
	      log.error("OutBound SC getMinOCVLDate Function Error !  "+e.getMessage());
	      log.error("*******************************************************");
	      throw new EventException("OutBound SC getMinOCVLDate Function Error ! : " + new ErrorHandler(e).getMessage());
	     }
	     // No OC Date --> From Mvmt Date
	     if(fixDtgEfftDt.length() == 0){
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
	     } 
	     log.debug("*******************************************************");
	     log.debug(" [OutBound SC CASE]:: "+ fixDtgEfftDt);
	     log.debug("*******************************************************");
	    } else if( zBrhRfaNo.length() != 0 ){
	     //[OutBound RFA CASE]
	     fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
	     // No POL ETA --> From Mvmt Date
	     if(fixDtgEfftDt.length() == 0){
	      fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
	     } 
	     log.debug("*******************************************************");
	     log.debug(" [OutBound RFA CASE]:: "+ fixDtgEfftDt);
	     log.debug("*******************************************************");
	    }
	   }
	   
	   /*
	   [12.logic] Get USC Exception Values
	     1.RFA - do first 
	     2.SC  - after RFA and return N
	   */
	   
	   if(  zBrhRfaNo.length() != 0 ){
	 //   Map<String, String> custMap = new HashMap<String, String>();
	    List<DualTypeExceptionCustInfoVO> custList = null;
	    try {
	     custList = dbDao.getDualTypeExceptionCustInfoByRFA(zBrhRfaNo);
	 //    actCustCntCd  = nullToString(custMap.get("cust_cnt_cd"));
	 //    actCustSeq   = stringToLong(custMap.get("cust_seq"));
	     if (custList!=null && custList.size()>0){
	      log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA size>0 - "+(custList!=null?custList.size():0)+" @@@@@@@@@@@@@ \n\n");
	      DualTypeExceptionCustInfoVO tmp = custList.get(0);
	      log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA : DualTypeExceptionCustInfoVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
	      if (tmp!=null){
	       actCustCntCd  = nullToString(tmp.getCustCntCd());
	       actCustSeq   = stringToLong(tmp.getCustSeq());
	       log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA : actCustCntCd:"+tmp.getCustCntCd()+" / actCustSeq:"+tmp.getCustSeq()+" @@@@@@@@@@@@@ \n\n");
	      }
	     }
	     else {log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA size=0 @@@@@@@@@@@@@ \n\n");}    
	    }catch(Exception e) {
	     log.error("*******************************************************");
	     log.error("getDualTypeExceptionCustInfoByRFA Select Error !  "+e.getMessage());
	     log.error("*******************************************************");
	     throw new EventException("getDualTypeExceptionCustInfoByRFA Select Error ! : " + new ErrorHandler(e).getMessage());
	    }
	    
	    bfrExceptionParmVO.setDmdtTrfCd(zDttCode);                         
	    bfrExceptionParmVO.setScNo(zBrhScNo);                   
	    bfrExceptionParmVO.setRfaNo(zBrhRfaNo);                 
	    bfrExceptionParmVO.setCntrTp(zDcsCntrTp);               
	    bfrExceptionParmVO.setCgoTp(zDcsCgoTp);                 
	    bfrExceptionParmVO.setIoBndCd(zDbcIoBnd);                 
	    bfrExceptionParmVO.setEfftDt(fixDtgEfftDt);             
	    bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
	    bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
	    bfrExceptionParmVO.setAwkInOut(awkInOut);
	    
	    bfrExceptionParmVO.setPorContiCd(zPorContiCd);
	    bfrExceptionParmVO.setPorCntCd(zPorCntCd);
	    bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
	    bfrExceptionParmVO.setPorSteCd(zPorStateCd);
	    bfrExceptionParmVO.setPorLocCd(zPorLoc);
	    
	    bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
	    bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
	    bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
	    bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
	    bfrExceptionParmVO.setYrdLocCd(zYrdLoc);
	 
	    bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
	    bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
	    bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);        
	    bfrExceptionParmVO.setPolSteCd(zPolStateCd);
	    bfrExceptionParmVO.setPolLocCd(zPolLoc);      
	    
	    bfrExceptionParmVO.setDelContiCd(zDelContiCd);                    
	    bfrExceptionParmVO.setDelCntCd(zDelCntCd);                
	    bfrExceptionParmVO.setDelRgnCd(zDelRgnCd);  
	    bfrExceptionParmVO.setDelSteCd(zDelStateCd);
	    bfrExceptionParmVO.setDelLocCd(zDelLoc);       
	    bfrExceptionParmVO.setCmdtCd(zCmdtCd); // 2016.07.28 Adding Commodity code 
	    
	    try {
	      dualFlag = searchDualTypeExceptionByRFA(bfrExceptionParmVO);
	    }catch(Exception e) {
	     log.error("*******************************************************");
	     log.error("searchDualTypeExceptionByRFA Function Error !  "+e.getMessage());
	     log.error("*******************************************************");
	     throw new EventException("searchDualTypeExceptionByRFA Function Error ! : " + new ErrorHandler(e).getMessage());
	    }
	    
	    if (dualFlag.equals("Y")) {
		    DmtBFRGrpVO dmtBFRGrpVO = null;
		    try {
		     dmtBFRGrpVO = searchBFRExceptionByGeneration(bfrExceptionParmVO);
		    }catch(Exception e) {
		     log.error("*******************************************************");
		     log.error("BFR searchBFRExceptionByGeneration Function Error :  ");
		     log.error("*******************************************************");
		     throw new EventException("BFR searchBFRExceptionByGeneration Function Error : " + new ErrorHandler(e).getMessage());
		    }
		    if(DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo()).equals("")){
		     dualFlag = "N";
		    }
		    else
		    {
		     dualFlag = "Y";
		    }
	    }
	   }
	   
	   if(dualFlag.equals("") || dualFlag == null) dualFlag = "N";
	   
	   if(zBrhScNo.length() != 0 && dualFlag.equals("N")) {
	 //   Map<String, String> custMap = new HashMap<String, String>();
	    List<DualTypeExceptionCustInfoVO> custList = null;
	    try {
	     custList = dbDao.getDualTypeExceptionCustInfoBySC(zBrhScNo);
	 //    actCustCntCd  = nullToString(custMap.get("cust_cnt_cd"));
	 //    actCustSeq   = stringToLong(custMap.get("cust_seq"));
	     if (custList!=null && custList.size()>0){
	      log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC size>0 - "+(custList!=null?custList.size():0)+" @@@@@@@@@@@@@ \n\n");
	      DualTypeExceptionCustInfoVO tmp = custList.get(0);
	      log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC : DualTypeExceptionCustInfoVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
	      if (tmp!=null){
	       log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC : actCustCntCd:"+tmp.getCustCntCd()+" / actCustSeq:"+tmp.getCustSeq()+" @@@@@@@@@@@@@ \n\n");
	       actCustCntCd  = nullToString(tmp.getCustCntCd());
	       actCustSeq   = stringToLong(tmp.getCustSeq());
	      }
	     }
	     else {log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC size=0 @@@@@@@@@@@@@ \n\n");}    
	    }catch(Exception e) {
	     log.error("*******************************************************");
	     log.error("getDualTypeExceptionCustInfoBySC Select Error !  "+e.getMessage());
	     log.error("*******************************************************");
	     throw new EventException("getDualTypeExceptionCustInfoBySC Select Error ! : " + new ErrorHandler(e).getMessage());
	    }
	    
	    
	    scExceptionParmVO.setCustCntCd(actCustCntCd);
	    scExceptionParmVO.setCustCd(String.valueOf(actCustSeq));
	    
	    scExceptionParmVO.setEfftDt(fixDtgEfftDt);
	    scExceptionParmVO.setIoBndCd(zDbcIoBnd);
	    scExceptionParmVO.setCntrTp(zDcsCntrTp);
	    scExceptionParmVO.setCgoTp(zDcsCgoTp);
	    
	    scExceptionParmVO.setScNo(zBrhScNo);
	    scExceptionParmVO.setDttCode(zDttCode);
	    
	    scExceptionParmVO.setPolContiCd(zPolContiCd);
	    scExceptionParmVO.setPolCntCd(zPolCntCd);
	    scExceptionParmVO.setPolRgnCd(zPolRgnCd);
	    scExceptionParmVO.setPolSteCd(zPolStateCd);
	    scExceptionParmVO.setPolLocCd(zPolLoc);
	    
	    scExceptionParmVO.setDelContiCd(zDelContiCd);
	    scExceptionParmVO.setDelCntCd(zDelCntCd);
	    scExceptionParmVO.setDelRgnCd(zDelRgnCd);
	    scExceptionParmVO.setDelSteCd(zDelStateCd);
	    scExceptionParmVO.setDelLocCd(zDelLoc);
	 
	    scExceptionParmVO.setPorContiCd(zPorContiCd);
	    scExceptionParmVO.setPorCntCd(zPorCntCd);
	    scExceptionParmVO.setPorRgnCd(zPorRgnCd);
	    scExceptionParmVO.setPorSteCd(zPorStateCd);
	    scExceptionParmVO.setPorLocCd(zPorLoc);
	    
	    scExceptionParmVO.setYrdContiCd(zYrdContiCd);
	    scExceptionParmVO.setYrdCntCd(zYrdCntCd);
	    scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
	    scExceptionParmVO.setYrdSteCd(zYrdStateCd);
	    scExceptionParmVO.setYrdLocCd(zYrdLoc);
	 
	    scExceptionParmVO.setPolContiCd(zPolContiCd);
	    scExceptionParmVO.setPolCntCd(zPolCntCd);
	    scExceptionParmVO.setPolRgnCd(zPolRgnCd);
	    scExceptionParmVO.setPolSteCd(zPolStateCd);
	    scExceptionParmVO.setPolLocCd(zPolLoc);
	    
	    scExceptionParmVO.setDelContiCd(zDelContiCd);
	    scExceptionParmVO.setDelCntCd(zDelCntCd);
	    scExceptionParmVO.setDelRgnCd(zDelRgnCd);
	    scExceptionParmVO.setDelSteCd(zDelStateCd);
	    scExceptionParmVO.setDelLocCd(zDelLoc);
	    scExceptionParmVO.setCmdtCd(zCmdtCd); // 2016.07.28 Adding Commodity code
	    
	    try {
	      dualFlag = searchDualTypeExceptionBySC(scExceptionParmVO);
	    }catch(Exception e) {
	     log.error("*******************************************************");
	     log.error("searchDualTypeExceptionBySC Function Error !  "+e.getMessage());
	     log.error("*******************************************************");
	     throw new EventException("searchDualTypeExceptionBySC Function Error ! : " + new ErrorHandler(e).getMessage());
	    }
	    
	    if (dualFlag.equals("Y")) {
		    DmtSCGrpVO dmtSCGrpVO = null;
		    try {
		     dmtSCGrpVO = searchSCExceptionByGeneration(scExceptionParmVO);
		    }catch(Exception e) {
		     log.error("*******************************************************");
		     log.error("* searchSCExceptionByGeneration Functon Error :"+e.getMessage());
		     log.error("*******************************************************");
		     throw new EventException("searchSCExceptionByGeneration Functon Error :" + new ErrorHandler(e).getMessage());
		    }
		    
		    if(DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){
		     log.debug("[searchSCExceptionByGeneration -> No data found]");
		     dualFlag = "N";
		    } else {
		     dualFlag = "Y";
		    }
	    }
	   } 
	   
	   if(dualFlag.equals("") || dualFlag == null) dualFlag = "N";
	  return dualFlag;
	 }

	
	
	/**
	 *  searchDualTypeExceptionBySC Search
	 * 
	 * @param SCExceptionParmVO scExceptionParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchDualTypeExceptionBySC(SCExceptionParmVO scExceptionParmVO) throws EventException, DAOException {
		String  dualflag = "";

//		String	prmIoBnd		= nullToString(scExceptionParmVO.getIoBndCd());
		String	prmCntrTp		= nullToString(scExceptionParmVO.getCntrTp());
		String	prmCgoTp		= nullToString(scExceptionParmVO.getCgoTp());
		
//		String	prmPolContiCd	= nullToString(scExceptionParmVO.getPolContiCd());
//		String	prmPolCntCd		= nullToString(scExceptionParmVO.getPolCntCd());
//		String	prmPolRgnCd		= nullToString(scExceptionParmVO.getPolRgnCd());
//		String	prmPolStateCd	= nullToString(scExceptionParmVO.getPolStateCd());
//		String	prmPolLoc		= nullToString(scExceptionParmVO.getPolLocCd());
		
//		String	prmDelContiCd	= nullToString(scExceptionParmVO.getDelContiCd());
//		String	prmDelCntCd		= nullToString(scExceptionParmVO.getDelCntCd());
//		String	prmDelRgnCd		= nullToString(scExceptionParmVO.getDelRgnCd());
//		String	prmDelStateCd	= nullToString(scExceptionParmVO.getDelStateCd());
//		String	prmDelLoc		= nullToString(scExceptionParmVO.getDelLocCd());
		
		
		String		prmCntrCgoTp	= "";
//		String		parContiCd		= "";
//		String		parCntCd		= "";
//		String		parRgnCd		= "";
//		String		parStateCd		= "";
//		String		parLoc			= "";
	                                                
			
		/*------------------------------- CNTR & CGO Type Setting */

		if( prmCntrTp.equals("D")){
			if( prmCgoTp.equals("DRY") || prmCgoTp.equals("AWK") ){
//				prmCntrCgoTp = "1";     
				prmCntrCgoTp = "D";	// 20100107  modify 
			} else if( prmCgoTp.equals("DGR") ){
//				prmCntrCgoTp = "4";		
				prmCntrCgoTp = "S";	// 20100107  modify
			} else {
				return	dualflag;
			}
		} else if( prmCntrTp.equals("R"))	{
			if( prmCgoTp.equals("DRY")){
//				prmCntrCgoTp = "2";
				prmCntrCgoTp = "F";	
			} else if( prmCgoTp.equals("RFR")){
//				prmCntrCgoTp = "3";
				prmCntrCgoTp = "R";	
			} else {
				return	dualflag;
			}
		} else if( prmCntrTp.equals("F") || prmCntrTp.equals("T") || prmCntrTp.equals("O") || prmCntrTp.equals("P") ){
//			prmCntrCgoTp = "4";
			prmCntrCgoTp = "S";	
		} else {
			return	dualflag;
		}
		
		scExceptionParmVO.setCntrCgoTp(prmCntrCgoTp);
		dualflag = dbDao.searchDualTypeExceptionBySC(scExceptionParmVO);
		
		return 	dualflag;
	}
	
	/**
	 *  searchDualTypeExceptionByRFA Search
	 * 
	 * @param BFRExceptionParmVO bfrExceptionParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchDualTypeExceptionByRFA(BFRExceptionParmVO bfrExceptionParmVO) throws EventException, DAOException {
		String  dualflag = "";

//		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		
		String		prmScNo			= nullToString(bfrExceptionParmVO.getScNo());
		String		prmRfaNo		= nullToString(bfrExceptionParmVO.getRfaNo());
		String		prmCntrTp		= nullToString(bfrExceptionParmVO.getCntrTp());
		String		prmCgoTp		= nullToString(bfrExceptionParmVO.getCgoTp());
		String		actCustCntCd	= nullToString(bfrExceptionParmVO.getActCustCntCd());
		long   		actCustSeq    	= stringToLong(bfrExceptionParmVO.getActCustSeq()); 
		String		prmAwkInOut		= nullToString(bfrExceptionParmVO.getAwkInOut());
		
		
		/*------------------------------- CNTR & CGO Type Adjust */
		if(prmCntrTp.equals("D")){
			if(	prmCgoTp.equals("AWK") ||	prmCgoTp.equals("B/B") ||	prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("R")){
			if(	prmCgoTp.equals("AWK") || prmCgoTp.equals("DGR") ){
				prmCgoTp = "DRY";
			}
		}
		if(	!prmCntrTp.equals("D") && !prmCntrTp.equals("R") &&	prmCgoTp.equals("AWK")){
			if(prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			}
			else if(prmAwkInOut.equals("O")){
				prmCgoTp = "AWK";
			}
		}
		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("P")){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			}
		}
		if( prmCntrTp.equals("F") ){
			if( prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			}else if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("O") ){
			if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("S") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}
		if( prmCntrTp.equals("A") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "F";
			}
		}

		/* -------------------------------------- Set Searching Key */

		if( prmScNo.length() == 0 && prmRfaNo.length() == 0 ){
			return	dualflag;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() != 0 ) {
			actCustCntCd = "" ;
			actCustSeq	= 0;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() == 0  ) {
			;
		} else if( prmScNo.length() == 0 && prmRfaNo.length() != 0 ) {
			;
		}
			
		bfrExceptionParmVO.setCntrTp(prmCntrTp);
		bfrExceptionParmVO.setCgoTp(prmCgoTp);
		
		dualflag = dbDao.searchDualTypeExceptionByRFA(bfrExceptionParmVO);
		
		return 	dualflag;
	}
	
	
	/**
	 *  getMinMovement Search
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getMinMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getMinMovement(movementParmVO);
	}
	
	
	/**
	 *  getMaxMovement Search
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getMaxMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getMaxMovement(movementParmVO);
	}
	
	
	/**
	 *  getPreMovement Search
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getPreMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getPreMovement(movementParmVO);
	}
	
	
		
	/**
	 *   case in 'F', 'L' container charge  checking collection office changing function<BR>	 
	 *    
	 * @param String svrId
	 * @param String zCntrNo  
	 * @param long zCnmvCycNo   
	 * @param String zDttCode
	 * @param String zLocDiv
	 * @param long zDccSeq
	 * @return List<OfficeInfoVO>
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public List<OfficeInfoVO> isCntrOfcTrans(String svrId, String zCntrNo  , long zCnmvCycNo   ,
			String zDttCode, String zLocDiv, long zDccSeq) throws EventException, DAOException {
		 return dbDao.isCntrOfcTrans(svrId, zCntrNo  , zCnmvCycNo   ,	zDttCode, zLocDiv, zDccSeq);
	}
	
	/**
	 *  searchDMIFFreeTimeEndDate Search
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDMIFFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo,
			String dmdtTrfCd, String dmdtChgLocDivCd, long chgSeq) throws EventException, DAOException {
		return dbDao.searchDMIFFreeTimeEndDate(svrId, cntrNo, cntrCycNo, dmdtTrfCd, dmdtChgLocDivCd, chgSeq);
	}
	
	/**
	 *  searchDTICFreeTimeEndDate Search
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDTICFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo,
			String dmdtTrfCd, String dmdtChgLocDivCd, long chgSeq) throws EventException, DAOException {
		return dbDao.searchDTICFreeTimeEndDate(svrId, cntrNo, cntrCycNo, dmdtTrfCd, dmdtChgLocDivCd, chgSeq);
	}
	
	
	/**
	 * Search  first SYS_AREA_GRP_ID information before Office Transfer
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return String
	 * @exception DAOException
	 */	
	public String searchFirstSvrID(ChargeCalculationParmVO chargeCalculationParmVO) throws DAOException {
		return dbDao.searchFirstSvrID(chargeCalculationParmVO);
	}

	
	/**
	 *  if paramter is null, then return ""(blank)
	 * 
	 * @param String str
	 * @return String
	 */
	public static String nullToString (String str) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return "";
		else
			return  str;
	}

	/**
	 *  if paramter is null, then return ""(blank)
	 * 
	 * @param String str
	 * @return String
	 */
	public static String nullToInt (String str) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return "0";
		else
			return  str;
	}

	
	/**
	 *   change string to int
	 * 
	 * @param String str
	 * @return int
	 */
	public static int stringToInt (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return (int) 0;
		else
			return  Integer.parseInt(str.trim());
	}

	/**
	 *  change string to long
	 * 
	 * @param String str
	 * @return long
	 */
	public static long stringToLong (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Long.parseLong(str.trim());
	}

	
	/**
	 *  change String to float
	 * 
	 * @param String str
	 * @return float
	 */
	public static float stringToFloat (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Float.parseFloat(str.trim());
	}


	/**
	 *  change String to double
	 * 
	 * @param String str
	 * @return double
	 */
	public static double stringToDouble (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Double.parseDouble(str.trim());
	}
	
	 /**
     * fills space in Null or return value  <br> 
     *
     * @param String str
     * @param int size
     * @return String
     */
	public static String nullToString (String str, int size) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return fillSpace("", size);
		else
			return  fillSpace(str, size);
	}
	
	 /**
     * return value fills space
     *
     * @param String des
     * @param int size
     * @return String
     */
    public static String fillSpace( String des, int size )
    {
        StringBuffer str = new StringBuffer();

        if ( des == null ) {
            for ( int i = 0; i < size; i++ )
                str.append( " " );
            return str.toString();
        }

        if ( des.trim().length() > size )
            return des.substring( 0, size );
        else
            des = des.trim();

        byte[] bDes = des.getBytes();
        int diffsize = size - bDes.length;
        str.append( des );

        for ( int i = 0; i < diffsize; i++ ) {
            str = str.append( " " );
        }

        return str.toString();
    }
    
    /**
     * add date and format change ( yyyymmdd )
     *
     * @param String date
     * @param int type
     * @param int amt
     * @return String
     */
    public static String getAddDate( String date, int type, int amt )
    {


        Calendar cal = Calendar.getInstance();


        cal.setTime( getDate( date ) );

        cal.add( type, amt );

        return getDate( cal.getTime() );

    }

    /**
     * date information return to  "yyyymmdd" type 
     * @param   Date date
     * @return String
     */
    public static String getDate( Date date )
    {
        return new SimpleDateFormat( "yyyyMMdd" ).format( date );
    }
    
    /**
     *  Return String type date value(format: yyyymmdd )
     *
     * @param   String date
     * @return Date
     */
    public static Date getDate( String date )
    {


        int year = Integer.parseInt( date.substring( 0, 4 ) );
        int month = Integer.parseInt( date.substring( 4, 6 ) ) - 1;
        int day = Integer.parseInt( date.substring( 6, 8 ) );


        Calendar cal = Calendar.getInstance();
        cal.set( year, month, day, 0, 0, 0 );

        return cal.getTime();

    }

    /**
     * return date(yyyymmdd) , add first date to second date
     *
     * @param String ymd
     * @param int day
     * @return String
     */
    public static String getAddDateByDay( String ymd, int day )
    {
        return getAddDate( ymd, Calendar.DATE, day );
    }


	/**
	 * getRFAFreeTime Search
	 * [2016.01.04] NYK Add
	 * 
	 * @param String prmDarNo
	 * @param long prmMapgSeq
	 * @param long prmVerSeq
	 * @param long prmDtlSeq
	 * @param long prmCmbSeq
	 * @param long prmDbcBkgQty
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long getRFAFreeTime(String prmDarNo, long prmMapgSeq, long prmVerSeq, long prmDtlSeq, long prmCmbSeq, long prmDbcBkgQty) throws EventException, DAOException {
		return dbDao.getRFAFreeTime(prmDarNo, prmMapgSeq, prmVerSeq, prmDtlSeq, prmCmbSeq, prmDbcBkgQty);
	}
}
