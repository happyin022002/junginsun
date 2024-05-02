/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtBCImpl.java
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
* 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.03.19 김민아 [CHM-201216890-01] Port Time Reduction project (2차) 수정사항 (Direction, 2nd Call추가)
* 2012.05.03 조경완 [CHM-201217535] [TOR] Port Time Activity Creation에 Double Call추가 외1건 
* 2012.07.11 문동선 [CHM-201218855-01] Base line 입력화면 추가 / Dashboard에 반영
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfCommonVariableVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration.PortTimePerformanceMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphPerformanceListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.GraphYtdListVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortDoubleCallVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityReportVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeVVDRemarkVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CargoLoadingResultMgt Business Logic Basic Command implementation<br>
 * - NIS2010-CargoLoadingResultMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see PortTimePerformanceMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class PortTimePerformanceMgtBCImpl extends BasicCommandSupport implements PortTimePerformanceMgtBC {

	// Database Access Object
	private transient PortTimePerformanceMgtDBDAO dbDao = null;

	/**
	 * TerminalDepartureReportBCImpl 객체 생성<br>
	 * TerminalDepartureReportDBDAO를 생성한다.<br>
	 */
	public PortTimePerformanceMgtBCImpl() {
		dbDao = new PortTimePerformanceMgtDBDAO();
	}

	/**
	 * Port Time Performance Summary를 조회합니다.<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PerformanceSummaryVO>
	 * @exception EventException
	 */
	public List<PerformanceSummaryVO> searchPortTimePerformanceSummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException {
		try {
			return dbDao.searchPortTimePerformanceSummaryList(portTimePerformanceConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	
	
	/**
	 * 해당 KPI에 속해 있는 최종 년도와 Version 정보를 표시한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPILastYearVersion(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException {
		try {
			return dbDao.searchKPILastYearVersion(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KPI Version 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIYearVersionList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException {
		try {
			return dbDao.searchKPIYearVersionList(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KPI Lane 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPISvcLaneCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException {
		try {
			return dbDao.searchKPISvcLaneCodeList(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KPI RHQ 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIRHQCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException {
		try {
			return dbDao.searchKPIRHQCodeList(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * KPI Port 정보를 조회합니다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchKPIPortCodeList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException {
		try {
			return dbDao.searchKPIPortCodeList(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 해당 KPI 정보를 조회한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> searchPortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException{
		try {
			return dbDao.searchPortTimeKPIList(portTimeKPIDetailVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 KPI 정보를 생성한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO[] portTimeKPIDetailVOs
	 * @param SignOnUserAccount account
	 * @return List<PortTimeKPIDetailVO>
	 * @exception EventException
	 */
	public List<PortTimeKPIDetailVO> addPortTimeKPIVersionList(PortTimeKPIDetailVO[] portTimeKPIDetailVOs, SignOnUserAccount account) throws EventException{
		List<PortTimeKPIDetailVO> list = null;
		try{
			//입력한 년도별 KPI 중 Max Version Sequence를 채번한다.
			int kpiVerSeq = dbDao.searchPortTimeKPIMaxVersion(portTimeKPIDetailVOs[0].getKpiTgtYr(),portTimeKPIDetailVOs[0].getTabChk());
			
			//일괄 셋팅
			for(int i = 0 ; i < portTimeKPIDetailVOs.length ; i++) {
				//Lane, Port, Direction 대문자변환
				portTimeKPIDetailVOs[i].setSlanCd(portTimeKPIDetailVOs[i].getSlanCd().toUpperCase());
				portTimeKPIDetailVOs[i].setVpsPortCd(portTimeKPIDetailVOs[i].getVpsPortCd().toUpperCase());
				portTimeKPIDetailVOs[i].setPortKpiDirCd(portTimeKPIDetailVOs[i].getPortKpiDirCd().toUpperCase());
			}
			
			for(int i = 0 ; i < portTimeKPIDetailVOs.length ; i++) {
				
				//Lane Code와 Port Code가 유효한지 확인한다.
				List<PortTimeKPIDetailVO> chkList = dbDao.checkLanePort(portTimeKPIDetailVOs[i]);
				if(chkList == null) {
					portTimeKPIDetailVOs[i].setChkVal("fail");
				}else {
					if("".equals(chkList.get(0).getVpsPortCd()) || "".equals(chkList.get(0).getSlanCd())) {
						portTimeKPIDetailVOs[i].setChkVal("fail");
					}else {
						
						int cnt = 0;
						String oriDirCd = "";
						String oriSeq = "";
						
						if("".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())) oriDirCd = "A";
						else oriDirCd = portTimeKPIDetailVOs[i].getPortKpiDirCd();
						if("".equals(portTimeKPIDetailVOs[i].getClptIndSeq())) oriSeq = "1";
						else oriSeq = portTimeKPIDetailVOs[i].getClptIndSeq();
						
						for(int j = 0 ; j < portTimeKPIDetailVOs.length ; j++) {
							if(!"fail".equals(portTimeKPIDetailVOs[j].getChkVal())) {
								//Insert 된 데이터와 중복된 데이터가 존재하는지 확인한다.
								if(j < i) {
									String compDirCd = "";
									String compSeq = "";
									if("".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) compDirCd = "A";
									else compDirCd = portTimeKPIDetailVOs[j].getPortKpiDirCd();
									if("".equals(portTimeKPIDetailVOs[j].getClptIndSeq())) compSeq = "1";
									else compSeq = portTimeKPIDetailVOs[j].getClptIndSeq();
									
									if(portTimeKPIDetailVOs[i].getVpsPortCd().equals(portTimeKPIDetailVOs[j].getVpsPortCd())
											&& portTimeKPIDetailVOs[i].getSlanCd().equals(portTimeKPIDetailVOs[j].getSlanCd())
											&& oriDirCd.equals(compDirCd)
											&& oriSeq.equals(compSeq)) {
										cnt ++;
									}
								}
								
								if(j != i) {
									//Lane, Port 동일하고 Direction 이 존재하지 않는 데이터와 존재하는 데이터가 함께 공존할 경우 Direction 이 존재하지 않는 데이터 생성 불가
									if(portTimeKPIDetailVOs[i].getVpsPortCd().equals(portTimeKPIDetailVOs[j].getVpsPortCd())
											&& portTimeKPIDetailVOs[i].getSlanCd().equals(portTimeKPIDetailVOs[j].getSlanCd())
											&& "".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())
											&& !"".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) {
										cnt++;
									}
									//East-West, South-North 의 Direction이 서로 엇갈릴 경우 모두 생성 불가
									if(portTimeKPIDetailVOs[i].getVpsPortCd().equals(portTimeKPIDetailVOs[j].getVpsPortCd())
											&& portTimeKPIDetailVOs[i].getSlanCd().equals(portTimeKPIDetailVOs[j].getSlanCd())) {
										if("E".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())
											&& !"E".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd()) && !"W".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) {
											cnt++;
										}else if("W".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())
											&& !"W".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd()) && !"E".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) {
											cnt++;
										}else if("S".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())
											&& !"S".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd()) && !"N".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) {
											cnt++;
										}else if("N".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())
											&& !"N".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd()) && !"S".equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())) {
											cnt++;
										}
									}
								}
							}
						}
						
						//Direction이 없는 Double Call 생성 불가
						//First Call이 없는 Second Call 생성 불가
						boolean dbCallFlag = false;
						if("2".equals(portTimeKPIDetailVOs[i].getClptIndSeq())) {
							if("".equals(portTimeKPIDetailVOs[i].getPortKpiDirCd())) {
								dbCallFlag = false;
							}else {
								for(int j = 0 ; j < portTimeKPIDetailVOs.length ; j++) {
									if(!"fail".equals(portTimeKPIDetailVOs[j].getChkVal())) {
										if(i != j){
											if(portTimeKPIDetailVOs[i].getVpsPortCd().equals(portTimeKPIDetailVOs[j].getVpsPortCd())
												&& portTimeKPIDetailVOs[i].getSlanCd().equals(portTimeKPIDetailVOs[j].getSlanCd())
												&& portTimeKPIDetailVOs[i].getPortKpiDirCd().equals(portTimeKPIDetailVOs[j].getPortKpiDirCd())
												&& !"2".equals(portTimeKPIDetailVOs[j].getClptIndSeq())) {
												dbCallFlag = true;
											}
										}
									}
								}
							}
						}else {
							dbCallFlag = true;
						}
						
						if(cnt > 0 || !dbCallFlag) portTimeKPIDetailVOs[i].setChkVal("fail");
						else {
							//해당 KPI 정보를 등록 한다.
							portTimeKPIDetailVOs[i].setKpiVerSeq(kpiVerSeq+"");
							portTimeKPIDetailVOs[i].setCreUsrId(account.getUsr_id());
							portTimeKPIDetailVOs[i].setUpdUsrId(account.getUsr_id());
							dbDao.addPortTimeKPIVersionList(portTimeKPIDetailVOs[i]);
						}
					}
				}
				portTimeKPIDetailVOs[i].setIbflag("R");
			}
			list = Arrays.asList(portTimeKPIDetailVOs);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
		return list;
	}
	
	/**
	 * 해당 KPI 정보를 삭제한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO portTimeKPIDetailVO
	 * @exception EventException
	 */
	public void removePortTimeKPIList(PortTimeKPIDetailVO portTimeKPIDetailVO) throws EventException{
		try{
			dbDao.removePortTimeKPIList(portTimeKPIDetailVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * 해당 KPI 정보를 변경한다.<br>
	 * 
	 * @param PortTimeKPIDetailVO[] portTimeKPIDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortTimeKPIList(PortTimeKPIDetailVO[] portTimeKPIDetailVOs, SignOnUserAccount account) throws EventException{
		try{
			List<PortTimeKPIDetailVO> list = new ArrayList<PortTimeKPIDetailVO>();
			if(portTimeKPIDetailVOs != null) {
				for(int i = 0 ; i < portTimeKPIDetailVOs.length ; i++) {
					if("U".equals(portTimeKPIDetailVOs[i].getIbflag())){
						portTimeKPIDetailVOs[i].setCreUsrId(account.getUsr_id());
						portTimeKPIDetailVOs[i].setUpdUsrId(account.getUsr_id());
						list.add(portTimeKPIDetailVOs[i]);
					}
				}
				
				if(list.size() > 0){
					dbDao.modifyPortTimeKPIList(list);
				}
			}
			
			
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Operation Stoppage Code 정보를 조회한다.<br>
	 * 
	 * @return List<OpfCommonVariableVO>
	 * @exception EventException
	 */
	public List<OpfCommonVariableVO> searchOprStopCodeList() throws EventException{
		try{
			return dbDao.searchOprStopCodeList();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Port Time Activity 탭페이지의 Grid에 표시할 정보를 조회 한다.<br>
	 * 
	 * @return List<PortTimeActivityVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityVO> searchAcitivityByPortTimeList() throws EventException{
		try{
			return dbDao.searchAcitivityByPortTimeList();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port별 Activity Time 정보를 조회한다.<br>
	 * 
	 * @param PortTimeActivityVO portTimeActivityVO
	 * @return List<PortTimeActivityVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityVO> searchPortTimeAcitvityList(PortTimeActivityVO portTimeActivityVO) throws EventException{
		try{
			return dbDao.searchPortTimeAcitvityList(portTimeActivityVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VVD Port별 Activity Time 정보를 생성 및 변경한다.<br>
	 * 
	 * @param PortTimeActivityVO[] portTimeActivityVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTimeAcitvityList(PortTimeActivityVO[] portTimeActivityVOs, SignOnUserAccount account) throws EventException{
		try{
			if(portTimeActivityVOs != null) {
				for(int i = 0 ; i < portTimeActivityVOs.length ; i++) {
					portTimeActivityVOs[i].setCreUsrId(account.getUsr_id());
					portTimeActivityVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.managePortTimeAcitvityList(portTimeActivityVOs[i]);
				}
			}
			
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VVD별 Port Time Activity의 입력 현황 정보를 조회 한다.<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<PortTimeActivityReportVO>
	 * @exception EventException
	 */
	public List<PortTimeActivityReportVO> searchVVDPortTimeActivitySummaryList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException{
		try{
			return dbDao.searchVVDPortTimeActivitySummaryList(portTimePerformanceConditionVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VVD별 Port/D.Call 정보를 조회 한다.<br>
	 * 
	 * @param OpfUtilSearchOptVO opfUtilSearchOptVO
	 * @return List<PortDoubleCallVO>
	 * @exception EventException
	 */
	@Override
	public List<PortDoubleCallVO> searchPortDoubleCallList(OpfUtilSearchOptVO opfUtilSearchOptVO) throws EventException {
		try{
			return dbDao.searchPortDoubleCallList(opfUtilSearchOptVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VVD별 Dashboard Chart Report - Performance Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception EventException
	 */
	public List<GraphPerformanceListVO> searchGraphPerformanceList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException {
		try{
			return dbDao.searchGraphPerformanceList(portTimePerformanceConditionVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}

	/**
	 * VVD별 Dashboard Chart Report - Ytd Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphYtdListVO>
	 * @exception EventException
	 */
	public List<GraphYtdListVO> searchGraphYtdList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException {
		try{
			if(portTimePerformanceConditionVO.getPortKpiDirCd() == null || portTimePerformanceConditionVO.getPortKpiDirCd().equals("")){
				portTimePerformanceConditionVO.setPortKpiDirCd("A");
			}
			return dbDao.searchGraphYtdList(portTimePerformanceConditionVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VVD Remark 정보를 조회 한다.<br>
	 * 
	 * @param PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs
	 * @return List<PortTimeVVDRemarkVO>
	 * @exception EventException
	 */
	public List<PortTimeVVDRemarkVO> searchPortTimeVVDRemarkList(PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs) throws EventException {
		try{
			List<PortTimeVVDRemarkVO> rtnList = new ArrayList<PortTimeVVDRemarkVO>();
			List<PortTimeVVDRemarkVO> retList = new ArrayList<PortTimeVVDRemarkVO>();
			
			for(int i=0; i<portTimeVVDRemarkVOs.length; i++) {
				retList = dbDao.searchPortTimeVVDRemarkList(portTimeVVDRemarkVOs[i]);
				if(retList.size() > 0){
					rtnList.add((PortTimeVVDRemarkVO)retList.get(0));
				} else {
					rtnList.add(portTimeVVDRemarkVOs[i]);
				}
			}
			return rtnList;
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}

	/**
	 * VVD Remark 정보를 저장 한다.<br>
	 * 
	 * @param PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePortTimeVVDRemarkList(PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs, SignOnUserAccount account) throws EventException{
		try{
			if(portTimeVVDRemarkVOs != null) {
				for(int i = 0 ; i < portTimeVVDRemarkVOs.length ; i++) {
					portTimeVVDRemarkVOs[i].setCreUsrId(account.getUsr_id());
					portTimeVVDRemarkVOs[i].setUpdUsrId(account.getUsr_id());
					
					if(portTimeVVDRemarkVOs[i].getIbflag().equals("I")) {
						dbDao.addPortTimeVVDRemarkList(portTimeVVDRemarkVOs[i]);
					} else if(portTimeVVDRemarkVOs[i].getIbflag().equals("U")) {
						dbDao.modifyPortTimeVVDRemarkList(portTimeVVDRemarkVOs[i]);
					} 
				}
			}
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VVD별 Dashboard Chart Report - Baseline Data<br>
	 * 
	 * @param PortTimePerformanceConditionVO portTimePerformanceConditionVO
	 * @return List<GraphPerformanceListVO>
	 * @exception EventException
	 */
	public List<GraphPerformanceListVO> searchGraphBaselineList(PortTimePerformanceConditionVO portTimePerformanceConditionVO) throws EventException {
		try{
			return dbDao.searchGraphBaselineList(portTimePerformanceConditionVO);
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Exp 정보를 저장 한다.<br>
	 * 
	 * @param PerformanceSummaryVO[] performanceSummaryVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPortTimePerformanceVVDExceptList(PerformanceSummaryVO[] performanceSummaryVO, SignOnUserAccount account) throws EventException{
		try {
			List<PerformanceSummaryVO> updateVoList = new ArrayList<PerformanceSummaryVO>();

			for ( int i=0; i<performanceSummaryVO .length; i++ ) {
				if ( performanceSummaryVO[i].getIbflag().equals("U")){
					performanceSummaryVO[i].setUpdateUser(account.getUsr_id());
					updateVoList.add(performanceSummaryVO[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyPortTimePerformanceVVDExceptList(updateVoList);
			}
 
		}catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
}