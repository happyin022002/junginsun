/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : TrendLineBCImpl.java
 *@FileTitle : TrendLine
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.11.15 진마리아
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
 * 2014.09.25 Lee Byoung Hoon [CHM-201431761] PF SKED simulation 기능과 연동으로 Bunker 소모량 산출 기능
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration.SimulationDBDAO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.BnkReqSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.StandardFocVO;
import com.hanjin.apps.alps.vop.fcm.simulation.simulation.vo.TrndLineSimulationVO;
import com.hanjin.apps.alps.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.FcmVslPortStndFuelOilVO;

/**
 * ALPS-Simulation Business Logic Basic Command implementation<br>
 * - ALPS-Simulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ryu Hyuk
 * @see VOP_FCM_0051EventResponse,SimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SimulationBCImpl extends BasicCommandSupport implements
		SimulationBC {

	// Database Access Object
	private transient SimulationDBDAO dbDao = null;

	/**
	 * SimulationBCImpl 객체 생성<br>
	 * SimulationBCDBDAO 생성한다.<br>
	 */
	public SimulationBCImpl() {
		dbDao = new SimulationDBDAO();
	}
	
	/**
	 * 등록된 Proforma SKD 정보를 조회한다.<br>
	 * Modify By 2014.09.25 Lee Byoung Hoon
	 * 
	 * @param PfSkdVO pfSkdVO
	 * @return List<PfSkdVO>
	 * @throws EventException
	 */
	public List<SmlPfSkdVO> searchPfSkd(SmlPfSkdVO pfSkdVO) throws EventException {
		List<SmlPfSkdVO> returnValue = null;
		
		try {
			String simDt = pfSkdVO.getSimDt();
			String simNo = pfSkdVO.getSimNo();
			
			if (!"".equals(simDt) && !"".equals(simNo)) {
				returnValue = dbDao.searchPfSkdSim(pfSkdVO);
			} else {
				if("F".equals(pfSkdVO.getVslSvcTpCd())){
					pfSkdVO.setVslSvcTpCd("");
				}
				returnValue = dbDao.searchPfSkd(pfSkdVO);
			}
			
			return returnValue;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Proforma SKD"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Proforma SKD"}).getMessage(), ex);
		} 
	}
	
	/**
	 * simulation no의 max 값을 조회한다.<br>
	 * 
	 * @param FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public  void multiFcmBnkCsm(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO,SignOnUserAccount account) throws EventException {
		try {
			 List<List<FcmBnkCsmPfDtlSimVO>> list = fcmBnkCsmPfSimVO.getFcmBnkCsmPfDtlSimVOs();
				for(int j=0;j<list.size();j++){
					List<FcmBnkCsmPfDtlSimVO> fcmBnkCsmPfDtlSimVOs = list.get(j);
					 for(int i = 1 ; i < fcmBnkCsmPfDtlSimVOs.size()-3 ;i++) {				
						if(i%2 == 1){
							fcmBnkCsmPfDtlSimVOs.get(i).setVslSlanCd(fcmBnkCsmPfSimVO.getVslSlanCd());
							fcmBnkCsmPfDtlSimVOs.get(i).setPfSvcTpCd(fcmBnkCsmPfSimVO.getPfSvcTpCd());
							fcmBnkCsmPfDtlSimVOs.get(i).setBnkCsmSimNo(fcmBnkCsmPfSimVO.getBnkCsmSimNo());
							fcmBnkCsmPfDtlSimVOs.get(i).setUpdUsrId(account.getUsr_id());
							fcmBnkCsmPfDtlSimVOs.get(i).setCreUsrId(account.getUsr_id());
							fcmBnkCsmPfDtlSimVOs.get(i).setClptSeq(fcmBnkCsmPfDtlSimVOs.get(i-1).getClptSeq());
							
							fcmBnkCsmPfDtlSimVOs.get(i).setPortCd(fcmBnkCsmPfDtlSimVOs.get(i-1).getPortCd());
							fcmBnkCsmPfDtlSimVOs.get(i).setSkdDirCd(fcmBnkCsmPfDtlSimVOs.get(i-1).getSkdDirCd());
							fcmBnkCsmPfDtlSimVOs.get(i).setYdCd(fcmBnkCsmPfDtlSimVOs.get(i-1).getYdCd());
							fcmBnkCsmPfDtlSimVOs.get(i).setSimPortFoilCsmWgt(fcmBnkCsmPfDtlSimVOs.get(i-1).getSimPortFoilCsmWgt());
							fcmBnkCsmPfDtlSimVOs.get(i).setSimGnrSeaFoilCsmWgt(fcmBnkCsmPfDtlSimVOs.get(i-1).getSimGnrPortFoilCsmWgt());
							if(fcmBnkCsmPfDtlSimVOs.get(i-1).getIbflag().equals("U")){
								dbDao.modifyFcmBnkCsmPfDtlSim(fcmBnkCsmPfDtlSimVOs.get(i));	
							}else{
								dbDao.addFcmBnkCsmPfDtlSim(fcmBnkCsmPfDtlSimVOs.get(i));
							}
						}
					 }
				}
			 //dbDao.addFcmBnkCsmPfDtlSim(fcmBnkCsmPfDtlSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Bunker Consumption"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192", new String[]{"Bunker Consumption"}).getMessage(), ex);
		} 
	}
	
	/**
	 * simulation no의 max 값을 조회한다.<br>
	 * 
	 * @return String
	 * @throws EventException
	 */
	public String addSimNo() throws EventException {
		try {
			
			return dbDao.searchMaxSimno();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Simulation No"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Simulation No"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Bunker Consumption Simulation 결과를 생성한다.<br>
	 * 
	 * @param FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public  void addFcmBnkCsmPfSim(FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO,SignOnUserAccount account) throws EventException {
		try {
			    fcmBnkCsmPfSimVO.setUpdUsrId(account.getUsr_id());
			    fcmBnkCsmPfSimVO.setCreUsrId(account.getUsr_id());
			    dbDao.addFcmBnkCsmPfSim(fcmBnkCsmPfSimVO);

			 //dbDao.addFcmBnkCsmPfDtlSim(fcmBnkCsmPfDtlSimVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Bunker Consumption Simulation"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Bunker Consumption Simulation"}).getMessage(), ex);
		} 
	}
	
	/**
	 * 지정된 VVD에 대해 Bunker Request Simulation을 한다. <br>
	 * 
	 * @param SmlPfSkdVO pfSkdVO
	 * @param String vsl_clss_cd
	 * @return List<PfSkdVO>
	 * @throws EventException
	 */
	public List<FcmBnkCsmPfDtlSimVO> searchFcmBnkCsmPfDtlSimSmlPfSkd(SmlPfSkdVO pfSkdVO,String vsl_clss_cd) throws EventException {
		try {

			return dbDao.searchFcmBnkCsmPfDtlSimSmlPfSkd(pfSkdVO,vsl_clss_cd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Bunker Request Simulation"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Bunker Request Simulation"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Simulation에 필요한 Vessel Registration 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return FcmVslCntrRgstVO
	 * @exception EventException
	 */
	public FcmVslCntrRgstVO searchVslRgstInfo(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try {

			return dbDao.searchVslRgstInfo(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Vessel Registration"}).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Vessel으로 생성된 Trnd Line이 존재하는지 check<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws EventException
	 */
	public String checkVslCdOfTrndLine(String vslCd) throws EventException {
		try {
			return dbDao.checkVslCdOfTrndLine(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} 
	}
	
	/**
	 * 조건에 맞는 Trnd Line(1,3,6)을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @throws EventException
	 */
	public List<FcmTrndLineVO> searchTrndLineForFOC(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try {
			return dbDao.searchTrndLineForFOC(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Trnd Line이 생성되어 있는 vsl의 direction을 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchTrndLineDirCd(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try {
			return dbDao.searchTrndLineDirCd(fcmTrndLineVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Direction"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Direction"}).getMessage(), ex);
		} 
	}
	
	/**
	 * Trnd Line이 생성되어 있는 Class, Sub Class, lane code를 조회한다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<String[]>
	 * @throws EventException
	 */
	public List<String[]> searchCapaLaneOfTrndLine(FcmTrndLineVO fcmTrndLineVO) throws EventException {
		try {
			String[] arrCapa = null;
			String[] arrSubClass = null;
			String[] arrLane = null;
			if("".equals(fcmTrndLineVO.getVslClssCd())){
				arrCapa = dbDao.searchCapaOfTrndLine(fcmTrndLineVO);
				arrSubClass = dbDao.searchSubClassOfTrndLine(fcmTrndLineVO);
				arrLane = dbDao.searchLaneCdOfTrndLine(fcmTrndLineVO);
			}else if("".equals(fcmTrndLineVO.getVslClssSubCd())){
				arrSubClass = dbDao.searchSubClassOfTrndLine(fcmTrndLineVO);
				arrLane = dbDao.searchLaneCdOfTrndLine(fcmTrndLineVO);
			}else{
				arrLane = dbDao.searchLaneCdOfTrndLine(fcmTrndLineVO);
			}
			
			List<String[]> list = new ArrayList<String[]>();
			list.add(arrCapa);
			list.add(arrSubClass);
			list.add(arrLane);
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		}
	}
	
	/**
	 * Search target VVD and SKD information.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return List<BnkReqSimVO>
	 * @exception EventException
	 */
	public List<BnkReqSimVO> searchVvd(BnkReqSimVO bnkReqSimVO) throws EventException {
		try {
			
//			int check = dbDao.checkVvd(bnkReqSimVO);
//			if(check==0){
//				throw new EventException(new ErrorHandler("COM12114", new String[] {"All port have Departure Report"}).getMessage());
//			}else if(check==1){
//				throw new EventException(new ErrorHandler("COM12114", new String[] {"There is No Departure Report"}).getMessage());
//			}else if(check==-1){
//				throw new EventException(new ErrorHandler("COM12114", new String[] {"SKD is missing"}).getMessage());
//			}
//
//			// find last departure port
//			FcmDepRptVO lastDepRpt = dbDao.searchLastDepPort(bnkReqSimVO);
//			bnkReqSimVO.setVslCd(lastDepRpt.getVslCd());
//			bnkReqSimVO.setSkdVoyNo(lastDepRpt.getSkdVoyNo());
//			bnkReqSimVO.setSkdDirCd(lastDepRpt.getSkdDirCd());
//			bnkReqSimVO.setVpsPortCd(lastDepRpt.getDepPortCd());
//			bnkReqSimVO.setClptIndSeq(lastDepRpt.getClptIndSeq());
			
			List<BnkReqSimVO> bnkReqSimVOs = dbDao.searchVvd(bnkReqSimVO);
			if(bnkReqSimVOs!=null && bnkReqSimVOs.size()>1){
				for(int i=1; i<bnkReqSimVOs.size(); i++){
					bnkReqSimVOs.get(i).setAvgCsmWgt(
						dbDao.searchAvgCsmWgtPortPair(bnkReqSimVO.getVslCd(), 
								bnkReqSimVOs.get(i-1).getVpsPortCd(), 
								bnkReqSimVOs.get(i).getVpsPortCd())
					);
				}
			}
			
			return bnkReqSimVOs;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Target VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Target VVD"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Search trend line to simulate bunker request.
	 * 
	 * @param BnkReqSimVO bnkReqSimVO
	 * @return FcmTrndLineVO
	 * @exception EventException
	 */
	public FcmTrndLineVO searchTrendLineForBnkReqSim(BnkReqSimVO bnkReqSimVO) throws EventException {
		try{
			FcmTrndLineVO fcmTrndLineVO = dbDao.searchTrendLineForBnkReqSim(bnkReqSimVO);
			return fcmTrndLineVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line"}).getMessage(), ex);
		}
	}

	/**
	 * Save the simulation data, and get the simulation number.
	 * 
	 * @param BnkReqSimVO[] bnkReqSimVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageBunkerRequestSimulation(BnkReqSimVO[] bnkReqSimVOs) throws EventException {
		return null;
//		try{
//			FcmTrndLineVO fcmTrndLineVO = dbDao.addBunkerRequestSimulation(bnkReqSimVOs);
//			return "";
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
//		}
	}
	
	/**
	 * 0055. 이미 선택된 조건들로 target 정보를 조회한다.
	 * 
	 * @param TrndLineSimulationVO trndLineSimulationVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTrndLineItmList(TrndLineSimulationVO trndLineSimulationVO) throws EventException {
		try {
			
			return dbDao.searchTrndLineItmList(trndLineSimulationVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Trend Line Item"}).getMessage(), ex);
		}
	}
	
	/**
	 * Standard FOC 화면을 조회한다.
	 * 
	 * @param StandardFocVO standardFocVO
	 * @return List<StandardFocVO>
	 * @exception EventException
	 */
	public List<StandardFocVO> searchStandardFoc(StandardFocVO standardFocVO) throws EventException {
		try {
			
			List<StandardFocVO> standardFocVOs = dbDao.searchStandardFoc(standardFocVO);
			return standardFocVOs;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Standard FOC"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12203", new String[]{"Standard FOC"}).getMessage(), ex);
		}
	}
	
	/**
	 * Standard FOC 정보를 저장한다.<br>
	 * 
	 * @param FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageStandardFoc(FcmVslPortStndFuelOilVO[] fcmVslPortStndFuelOilVOs, SignOnUserAccount account) throws EventException {
		try {
			List<FcmVslPortStndFuelOilVO> mergeVoList = new ArrayList<FcmVslPortStndFuelOilVO>();
			
			for ( int i=0; i < fcmVslPortStndFuelOilVOs.length; i++ ) {
				fcmVslPortStndFuelOilVOs[i].setCreUsrId(account.getUsr_id());
				fcmVslPortStndFuelOilVOs[i].setUpdUsrId(account.getUsr_id());
				mergeVoList.add(fcmVslPortStndFuelOilVOs[i]);
			}
			
			if ( mergeVoList.size() > 0 ) {
				dbDao.mergeMultiFcmVslPortStndFuelOilS(mergeVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Standard FOC Merge"}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12213", new String[]{"Standard FOC Merge"}).getMessage(), ex);
		} 
	}
}
