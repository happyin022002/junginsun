/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselInformationMgtBCImpl.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* 2014.03.17 박다은 [CHM-201428939-01] vessel particular - performance
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBC;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration.VesselInformationMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadFactorListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadableListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LowestListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.MdmVslCntrExcelVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselLoadableInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - NIS2010-VesselOperationSupportMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0503EventResponse,VesselInformationMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselInformationMgtBCImpl extends BasicCommandSupport implements VesselInformationMgtBC {

	// Database Access Object
	private transient VesselInformationMgtDBDAO dbDao = null;

	/**
	 * VesselInformationMgtBCImpl 객체 생성<br>
	 * VesselInformationMgtDBDAO를 생성한다.<br>
	 */
	public VesselInformationMgtBCImpl() {
		dbDao = new VesselInformationMgtDBDAO(); 
	} 
	
	/**
	 * Particular I, Particular II 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPartIVO searchVSLPartI(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			//return dbDao.searchVSLPartI(vesselInformationMgtConditionVO);
			VSLPartIVO vSLPartIVO = dbDao.searchVSLPartI(vesselInformationMgtConditionVO);
			List<MdmVslCntrExcelVO> mdmVslCntrExcelVO = dbDao.searchVSLPartIList(vesselInformationMgtConditionVO);
			vSLPartIVO.setMdmVslCntrExcelVOL(mdmVslCntrExcelVO);
			
			return vSLPartIVO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}

	
	/**
	 * Dock Plan 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<DockPlanListVO>
	 * @exception EventException
	 */
	public List<DockPlanListVO> searchDockPlanList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			return dbDao.searchDockPlanList(vesselInformationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		}
	}
	
	/**
	 * Performance tab 에서 Operation 정보를 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPerformanceVO searchVSLPerformance(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		
		TrendLineBC fcmCommand	= new TrendLineBCImpl();
		
		try {
			VSLPerformanceVO 		vSLPerformanceVO 	= dbDao.searchVSLPerformance(vesselInformationMgtConditionVO);
			List<LoadFactorListVO> 	loadFactorListVO 	= dbDao.searchLoadFactorList(vesselInformationMgtConditionVO);
			vSLPerformanceVO.setLoadFactorListVOl(loadFactorListVO);
			
			//::jskjskjsk::2007816:://
			
			FcmTrndLineVO 			fcmTrndLineVO		= new FcmTrndLineVO();
			
			//::TrendLineDBDAOSearchAverageSlpValRSQL >> AND T1.NOON_RPT_DT BETWEEN TO_DATE(@[trnd_line_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[trnd_line_to_dt], 'YYYY-MM-DD')+0.99999:://
			//Calendar	calendar		= new GregorianCalendar(java.util.Locale.KOREA);
			Calendar	calendar1		= Calendar.getInstance();
			Calendar	calendar2		= Calendar.getInstance();
			calendar1.add(Calendar.MONTH, -12);
			
			String		sOneYearBfrYmd	= new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime());
			String		sCurYmd			= new SimpleDateFormat("yyyy-MM-dd").format(calendar2.getTime()); 
			
			fcmTrndLineVO.setVslSlanCd		(vesselInformationMgtConditionVO.getHVslSlanCd	()	);
			fcmTrndLineVO.setVslCd			(vesselInformationMgtConditionVO.getVslCd		()	);
			fcmTrndLineVO.setTrndLineFmDt	(sOneYearBfrYmd										);	
			fcmTrndLineVO.setTrndLineToDt	(sCurYmd											);
			
			List<FcmNoonRptVO> 		fcmNoonRptVOs 		= fcmCommand.searchFcmTrndLineBasic	(fcmTrndLineVO			);
			// back data를 이용한 Trend Line 계수 계산 - List<FcmTrndLineVO> fcmTrndLineVOs = command.calcTrndLine(fcmNoonRptVOs, "0055");
			
			List<FcmTrndLineVO> 	fcmTrndLineVOs 		= fcmCommand.calcTrndLine			(fcmNoonRptVOs, "0055"	);	
			
			Double	totPfFocQty				= 0D;	//::SEA + IN PORT + MNVR FOC:://
			Double  inportPlusMnvrFocQty	= !"null".equals(vSLPerformanceVO.getPfFocQty()) && !"".equals(vSLPerformanceVO.getPfFocQty()) && vSLPerformanceVO.getPfFocQty() != null ? Double.parseDouble(vSLPerformanceVO.getPfFocQty()) : 0D;
			Double	dailySeaFocQty			= 0D;	//::DAILY SEA FOC:://
			Double  totSeaTimeHrs			= !"null".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && !"".equals(vSLPerformanceVO.getTotSeaTimeHrs()) && vSLPerformanceVO.getTotSeaTimeHrs() != null ? Double.parseDouble(vSLPerformanceVO.getTotSeaTimeHrs()) : 0D;
			
			if(fcmTrndLineVOs != null && fcmTrndLineVOs.size() != 0){

				for(FcmTrndLineVO tmpVO : fcmTrndLineVOs){
					String sTrndLindChtTp	= tmpVO.getTrndLineChtTpCd();
					
					log.info("\n\n ::2007816:: vSLPerformanceVO.getPfSpd()	["+vSLPerformanceVO.getPfSpd()+"]\n");
					
					Double 	pfAvdSpd	= !"null".equals(vSLPerformanceVO.getPfSpd()) && !"".equals(vSLPerformanceVO.getPfSpd()) && vSLPerformanceVO.getPfSpd() != null ? Double.parseDouble(vSLPerformanceVO.getPfSpd()) : 0D;
					
					/********************************************************************************************
					 * :: [calculation rule] :: ref:return (coef2 * Math.pow(cspd, 2)) + (coef * cspd) + cons; -- (nCoef2 * Math.pow(nSpd, 2)) + (nCoef * nSpd) + nCons
					 * ------------------------------------------------------------------------------------------
					 * cons + (coef1 * P/F Speed) + (coef2 * POW(P/F Speed,2)
					 ********************************************************************************************/
						
					if("01".equals(sTrndLindChtTp)){
						
						Double	coef1	= Double.parseDouble(tmpVO.getN1stCoefVal		());
						Double	coef2	= Double.parseDouble(tmpVO.getN2ndCoefVal		());
						Double	cons	= Double.parseDouble(tmpVO.getTrndLineConsVal	());
						
						log.info("\n\n ::2007816:: getN1stCoefVal 		["+tmpVO.getN1stCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getN2ndCoefVal 		["+tmpVO.getN2ndCoefVal		()+"]\n");
						log.info("\n\n ::2007816:: getTrndLineConsVal 	["+tmpVO.getTrndLineConsVal	()+"]\n");
						
						dailySeaFocQty	= cons + (coef2 * pfAvdSpd) + (coef1 * Math.pow(pfAvdSpd,2)); 
						
						log.info("\n\n ::2007816:: pfAvdSpd 		["+pfAvdSpd+"]\n");
						log.info("\n\n ::2007816:: totSeaTimeHrs 	["+totSeaTimeHrs+"]\n");
						log.info("\n\n ::2007816:: (coef1 * pfAvdSpd)	["+coef1 * pfAvdSpd+"]\n");
						log.info("\n\n ::2007816:: Math.pow(pfAvdSpd,2)	["+Math.pow(pfAvdSpd,2)+"]\n");
						log.info("\n\n ::2007816:: coef2 * Math.pow(pfAvdSpd,2)	["+coef2 * Math.pow(pfAvdSpd,2)+"]\n");
						
					}
				}
			}
			
			log.info("\n\n ::2007816:: vSLPerformanceVO.getPfFocQty()	["+vSLPerformanceVO.getPfFocQty()+"]\n");
			log.info("\n\n ::2007816:: calculated daily >> seaFocQty	["+dailySeaFocQty+"]\n");
			log.info("\n\n ::2007816:: totSeaTimeHrs	["+totSeaTimeHrs+"]\n");
			
			String	sTotPfFocQty	= "";
			totPfFocQty				= inportPlusMnvrFocQty + dailySeaFocQty * (totSeaTimeHrs/24);
			sTotPfFocQty			= String.format("%.1f", totPfFocQty);

			log.info("\n\n =========== ::2007816:: ============= fcm trenline finished ============ \n");
			
			vSLPerformanceVO.setPfFocQty(sTotPfFocQty);
			
			return vSLPerformanceVO;
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}
	
	/**
	 * Performance tab 에서 RPM & Slow Steaming 정보를 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return VSLPartIVO
	 * @exception EventException
	 */
	public VSLPerformanceVO searchVSLPerformanceDetail(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			VSLPerformanceVO vSLPerformanceVO = dbDao.searchVSLPerformanceDetail(vesselInformationMgtConditionVO);
			
			return vSLPerformanceVO;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Particular"}).getMessage(), ex);
		}
	}
	
	/**
	 * Lowest List 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<LowestListVO>
	 * @exception EventException
	 */
	public List<LowestListVO> searchLowestList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try { 
			return dbDao.searchLowestList(vesselInformationMgtConditionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		}
	}
	
	/**
	 * Loadable List 을 조회 합니다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<LoadableListVO>
	 * @exception EventException
	 */
	public List<LoadableListVO> searchLoadableList(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try { 
			return dbDao.searchLoadableList(vesselInformationMgtConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		}
	}
	
	/**
	 * Loadable List 을 조회 합니다.<br>
	 * 
	 * @param vesselLoadableInfoVO
	 * @return List<VesselLoadableInfoVO>
	 * @exception EventException
	 */
	public List<VesselLoadableInfoVO> searchLoadableInfoList(VesselLoadableInfoVO vesselLoadableInfoVO) throws EventException {
		try { 
			return dbDao.searchLoadableInfoList(vesselLoadableInfoVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Dock Plan"}).getMessage(), ex);
		}
	}


	/**
	 * @param performanceInfoVO
	 * @param account
	 * @throws EventException
	 */
	public void managePerformanceInfo(PerformanceInfoVO performanceInfoVO, SignOnUserAccount account) throws EventException {
		try {
			performanceInfoVO.setUsrId(account.getUsr_id());
			dbDao.addPerformanceInfo(performanceInfoVO);
			dbDao.modifyMdmVesselParticularInfo(performanceInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * @param vesselLoadableInfoVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageVesselLoadableInfo(VesselLoadableInfoVO[] vesselLoadableInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<VesselLoadableInfoVO> insertVoList = new ArrayList<VesselLoadableInfoVO>();
			List<VesselLoadableInfoVO> deleteVoList = new ArrayList<VesselLoadableInfoVO>();
		
			//1. PSO_YD_CHG_OBJ_LIST 데이터 삭제
			VesselLoadableInfoVO deleteVesselLoadableInfoVO = new VesselLoadableInfoVO();
			dbDao.deleteVesselLoadableInfo(deleteVesselLoadableInfoVO);
			
			
			for (int i=0; i<vesselLoadableInfoVOs.length; i++) {
			if ( vesselLoadableInfoVOs[i].getIbflag().equals("D")){
				deleteVoList.add(vesselLoadableInfoVOs[i]);
			} else {
				//2. PSO_YD_CHG_OBJ_LIST 데이터 입력
				vesselLoadableInfoVOs[i].setUsrId(account.getUsr_id());
				if (vesselLoadableInfoVOs[i].getIbflag().equals("I")|| vesselLoadableInfoVOs[i].getIbflag().equals("U")||vesselLoadableInfoVOs[i].getIbflag().equals("R")) {
					insertVoList.add(vesselLoadableInfoVOs[i]);
				}
			}
		}
			
			if (insertVoList.size() > 0) {
				dbDao.addVesselLoadableInfo(insertVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Vessel Summary 정보를 조회한다.<br>
	 * 
	 * @param VesselInformationMgtConditionVO vesselInformationMgtConditionVO
	 * @return List<VSLPartIVO>
	 * @exception EventException
	 */
	public List<VSLPartIVO> searchVesselSummary(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) throws EventException {
		try {
			
			return dbDao.searchVesselSummary(vesselInformationMgtConditionVO);
			
			
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Summary"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Summary"}).getMessage(), ex);
		}
	}
	
}