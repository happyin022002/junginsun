/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyforecastmanageBCImpl.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2013.10.17 [CHM-201325350] Split 04-영업지원 Application 개발 요청 - 이로 인해 Forecast Input Save의 parameter 변경
* 2013.10.24 [선처리] Account Add/Del 과 Mapping 구분자 생성
* 2013.10.28 [CHM-201325350] 영업지원 Application 개발요청 - Others 저장시 Others 안에 있는 다른건 zero로 변경
* 2013.12.02 모델 불일치로 인한 컬럼명 수정. MAPG_FLG -> CUST_MAPG_FLG
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
* 2016.04.01 이혜민 [CHM-201640539] ALPS Live Out Of Memory Error 확인 및 조치 요청(Sales Rep이 몇 개의 Account를 체크했는지 개수 조회)
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration.DailyForecastManageDBDAO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageMainVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchAccumulatedGuidePfmcVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchContractForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistoryOfcListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastHistorySrepAcctListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchDailyForecastSrepAccountManageListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchLoadOfficeMappingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.SearchSalesRepInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcCtrtFcastCustVO;
import com.hanjin.syscommon.common.table.SpcCtrtFcastOfcMapgVO;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustMapgVO;
import com.hanjin.syscommon.common.table.SpcSlsRepCustVO;

/**
 * ALPS-DailyForecast Business Logic Basic Command implementation<br>
 * - ALPS-DailyForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0103EventResponse,DailyforecastmanageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class DailyForecastManageBCImpl extends BasicCommandSupport implements DailyForecastManageBC {

	// Database Access Object
	private transient DailyForecastManageDBDAO dbDao = null;

	/**
	 * DailyforecastmanageBCImpl 객체 생성<br>
	 * DailyforecastmanageDBDAO를 생성한다.<br>
	 */
	public DailyForecastManageBCImpl() {
		dbDao = new DailyForecastManageDBDAO();
	}
	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastSrepAccountManageList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			
			List<SearchDailyForecastSrepAccountManageListVO> voList = dbDao.searchDailyForecastSrepAccountManageList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();			
			main.setVoList(voList);
			
			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);
			
			return mainList;//return dbDao.searchDailyForecastSrepAccountManageList(searchSpaceControlInquiryConditionVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ESM_SPC_0103]을 [행위] 합니다.<br>
	 * 
	 * @param SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastSrepAccountManage(SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcSlsRepCustMapgVO> insertVoList = new ArrayList<SpcSlsRepCustMapgVO>();
			List<SpcSlsRepCustMapgVO> updateVoList = new ArrayList<SpcSlsRepCustMapgVO>();
			List<SpcSlsRepCustMapgVO> deleteVoList = new ArrayList<SpcSlsRepCustMapgVO>();
			for ( int i=0; i<spcSlsRepCustMapgVO .length; i++ ) {
				if ( spcSlsRepCustMapgVO[i].getIbflag().equals("I")){
					spcSlsRepCustMapgVO[i].setCreUsrId(account.getUsr_id());
					spcSlsRepCustMapgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcSlsRepCustMapgVO[i]);
				} else if ( spcSlsRepCustMapgVO[i].getIbflag().equals("U")){
					spcSlsRepCustMapgVO[i].setCreUsrId(account.getUsr_id());
					spcSlsRepCustMapgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcSlsRepCustMapgVO[i]);
				} else if ( spcSlsRepCustMapgVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcSlsRepCustMapgVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiDailyForecastSrepAccountManageS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiDailyForecastSrepAccountManageS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiDailyForecastSrepAccountManageS(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistoryOfcList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			String vslcd = "";
			String skdvoyno = "";
			String skddircd = "";
			String ofckndcd = "";
			
			String vvd = dailyforecastmanageConditionVO.getVvd();
			String salesOffice = dailyforecastmanageConditionVO.getSalesOffice();
			String subOffice = dailyforecastmanageConditionVO.getSubOffice();
			
			if(vvd.length() > 0 ){
				vslcd = vvd.substring(0, 4);
				skdvoyno = vvd.substring(4, 8);
				skddircd = vvd.substring(8);
		 		dailyforecastmanageConditionVO.setVslcd(vslcd);
		 		dailyforecastmanageConditionVO.setSkdvoyno(skdvoyno);
		 		dailyforecastmanageConditionVO.setSkddircd(skddircd);
			}
			if(salesOffice.length() > 0 && subOffice.length() == 0){
				ofckndcd = "3";
				dailyforecastmanageConditionVO.setOfckndcd(ofckndcd);
			}
			if(subOffice.length() > 0 && salesOffice.length() == 0 || subOffice.length() > 0 && salesOffice.length() > 0){
				ofckndcd = "4";
				dailyforecastmanageConditionVO.setOfckndcd(ofckndcd);
			}
			
			List<SearchDailyForecastHistoryOfcListVO> historyOfcList = dbDao.searchDailyForecastHistoryOfcList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();			
			main.setHistoryOfcList(historyOfcList);
			
			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);
			
			return mainList;//return dbDao.searchDailyForecastSrepAccountManageList(searchSpaceControlInquiryConditionVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * [ESM_SPC_0104]을 [행위] 합니다.<br>
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<DailyforecastmanageMainVO>
	 * @exception EventException
	 */
	public List<DailyforecastmanageMainVO> searchDailyForecastHistorySrepAcctList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			String vslcd = "";
			String skdvoyno = "";
			String skddircd = "";
			
			String vvd = dailyforecastmanageConditionVO.getVvd();
						
			if(vvd.length() > 0 ){
				vslcd = vvd.substring(0, 4);
				skdvoyno = vvd.substring(4, 8);
				skddircd = vvd.substring(8);
		 		dailyforecastmanageConditionVO.setVslcd(vslcd);
		 		dailyforecastmanageConditionVO.setSkdvoyno(skdvoyno);
		 		dailyforecastmanageConditionVO.setSkddircd(skddircd);
			}
			
			List<SearchDailyForecastHistorySrepAcctListVO> serpAcctList = dbDao.searchDailyForecastHistorySrepAcctList(dailyforecastmanageConditionVO);
			DailyforecastmanageMainVO main = new DailyforecastmanageMainVO();
			main.setSerpAcctList(serpAcctList);
			
			List<DailyforecastmanageMainVO> mainList = new ArrayList<DailyforecastmanageMainVO>();
			mainList.add(main);
			
			return mainList;//return dbDao.searchDailyForecastSrepAccountManageList(searchSpaceControlInquiryConditionVO);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [ESM_SPC_102]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManage2List(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDailyForecastManage2List(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_102]을 [행위] 합니다.<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForecastManage2(SpcDlyFcastCustVO[] spcDlyFcastCustVO,SignOnUserAccount account) throws EventException{
		try {
			List<SpcDlyFcastCustVO> insertVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> updateVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> deleteVoList = new ArrayList<SpcDlyFcastCustVO>();
			for ( int i=0; i<spcDlyFcastCustVO .length; i++ ) {
				if ( spcDlyFcastCustVO[i].getIbflag().equals("I") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){
					spcDlyFcastCustVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcDlyFcastCustVO[i]);
					
					if(spcDlyFcastCustVO[i].getPodYdCd().equals("")){
						deleteVoList.add(spcDlyFcastCustVO[i]);
					}
				} else if ( spcDlyFcastCustVO[i].getIbflag().equals("U") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){
					spcDlyFcastCustVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(spcDlyFcastCustVO[i]);
				} else if ( spcDlyFcastCustVO[i].getIbflag().equals("D") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){
					deleteVoList.add(spcDlyFcastCustVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpcDlyFcastCustS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpcDlyFcastCustS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSpcDlyFcastCustS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_102]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiDailyForcastForHistory(ConditionVO conditionVO,SignOnUserAccount account) throws EventException{
		try {
			List<SpcDlyFcastCustVO> updateVoList = new ArrayList<SpcDlyFcastCustVO>();
			
			String vvdList = conditionVO.getVvdList();
			String salesRepCodeList = conditionVO.getSalesRepCodeList();
			
			String[] vvdListArr = (vvdList.replace('|', ',')).split(",");
			String[] salesRepCodeListArr = (salesRepCodeList.replace('|', ',')).split(",");
			
			for ( int j=0; j<vvdListArr.length; j++ ) {
				if ( !"".equals(vvdListArr[j]) ){
					for ( int k=0; k<salesRepCodeListArr.length; k++ ) {
						if(!"".equals(salesRepCodeListArr[k])) {
							SpcDlyFcastCustVO spcDlyFcastCustVO = new SpcDlyFcastCustVO();
							spcDlyFcastCustVO.setVslCd(vvdListArr[j].substring(0, 4));
							spcDlyFcastCustVO.setSkdVoyNo(vvdListArr[j].substring(4, 8));
							spcDlyFcastCustVO.setSkdDirCd(vvdListArr[j].substring(8));
							spcDlyFcastCustVO.setIocCd(conditionVO.getIoc());
							spcDlyFcastCustVO.setSrepUsrId(salesRepCodeListArr[k]);
							spcDlyFcastCustVO.setUpdUsrId(account.getUsr_id());
							updateVoList.add(spcDlyFcastCustVO);
						}
					}
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpcDlyFcastCust2(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException {
		try {
			List<SearchSalesRepInfoVO> voList = dbDao.searchSalesRepList(searchSalesRepInfoVO);
			SearchSalesRepInfoVO main = new SearchSalesRepInfoVO();			
			main.setVoList(voList);
			
			List<SearchSalesRepInfoVO> mainList = new ArrayList<SearchSalesRepInfoVO>();
			mainList.add(main);
			
			return mainList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchSalesRepAccountList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException {
		try {
			List<SearchSalesRepInfoVO> voList = dbDao.searchSalesRepAccountList(searchSalesRepInfoVO);
			SearchSalesRepInfoVO main = new SearchSalesRepInfoVO();			
			main.setVoList(voList);
			
			List<SearchSalesRepInfoVO> mainList = new ArrayList<SearchSalesRepInfoVO>();
			mainList.add(main);
			
			return mainList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0106 : SEARCHLIST03
	 * Individual 을 언체크 할경우 해당 S.Rep, 화주, S.office 에 이번주 이후에 물량을 준게 있는지 확인한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchSalesRepVolExistList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException {
		try {
			List<String> rsList = dbDao.searchSalesRepVolExistList(searchSalesRepInfoVO);
			return rsList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0106 : [이벤트]
	 * 한국지점 - Sales Rep별 Account 정보를 관리한다.
	 * 
	 * @param  SpcSlsRepCustVO[] spcSlsRepCustVOS
	 * @param  SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSalesRepAccountManage(SpcSlsRepCustVO[] spcSlsRepCustVOS, SignOnUserAccount account) throws EventException {
		try {
//			List<SpcSlsRepCustVO> insertVoList = new ArrayList<SpcSlsRepCustVO>();
			List<SpcSlsRepCustVO> updateVoList = new ArrayList<SpcSlsRepCustVO>();
			List<SpcSlsRepCustVO> deleteVoList = new ArrayList<SpcSlsRepCustVO>();
			SpcSlsRepCustVO tempVo = new SpcSlsRepCustVO();
			
			for ( int i=0; i<spcSlsRepCustVOS .length; i++ ) {
				spcSlsRepCustVOS[i].setUpdUsrId(account.getUsr_id());
				spcSlsRepCustVOS[i].setTrade(spcSlsRepCustVOS[0].getTrade());
				
				String[] sub_trd_cd = (spcSlsRepCustVOS[i].getSubTrdCd()).split(",");
				
				for( int j=0; j<sub_trd_cd.length; j++) {
//					// XX999999(Others) 강제 생성하기 위함
//					if(i==0){
//						tempVo.setSrepCd(spcSlsRepCustVOS[i].getSrepCd());
//						tempVo.setSlsOfcCd(spcSlsRepCustVOS[i].getSlsOfcCd());
//						tempVo.setSlsRepOfcTeamCd(spcSlsRepCustVOS[i].getSlsRepOfcTeamCd());
//						tempVo.setRvisCntrCustTpCd("N");
//						tempVo.setCustCntCd("XX");
//						tempVo.setCustSeq("999999");
//						tempVo.setDeltFlg("N");
//						tempVo.setTrade(spcSlsRepCustVOS[0].getTrade());
//						tempVo.setIndivCustUseFlg("Y");
//						tempVo.setUpdUsrId(account.getUsr_id());
//						
//						updateVoList.add(tempVo);
//					}
//					// 첫번째는 XX999999(Others) 로 생각하고, 두번째 부터 처리
//					if(i>0){
					
						tempVo = (SpcSlsRepCustVO) spcSlsRepCustVOS[i].clone();
						tempVo.setSubTrdCd(sub_trd_cd[j]);
						tempVo.setOfcCd(spcSlsRepCustVOS[i].getSlsOfcCd());
						
//						Account Add/Del 저장시 기존에 mapping을 통해 저장된 데이터를 걸러내어 저장시 mapg_flg를 유지하도록 한다.
						String mapgFlg = dbDao.searchOrgMapgFlg(tempVo);
						tempVo.setCustMapgFlg(mapgFlg);
						
						if ( spcSlsRepCustVOS[i].getIbflag().equals("I")){
							deleteVoList.add(tempVo);
							
							if(!sub_trd_cd[j].isEmpty()) {
								updateVoList.add(tempVo);
							}
						} else if ( spcSlsRepCustVOS[i].getIbflag().equals("U")){
							deleteVoList.add(tempVo);
							
							if(!sub_trd_cd[j].isEmpty()) {
								updateVoList.add(tempVo);
							}
						} else if ( spcSlsRepCustVOS[i].getIbflag().equals("D")){
							deleteVoList.add(tempVo);
							
							if(!sub_trd_cd[j].isEmpty()) {
								updateVoList.add(tempVo);
							}
						}
//				   }
				}
			}
			/*
			if ( insertVoList.size() > 0 ) {
//				dbDao.addmultiDailyForecastSrepAccountManageS(insertVoList);
			}*/
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiAccountSrepList(deleteVoList, "ESM_SPC_0106");
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addmultiSalesRepAccountManageS(updateVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_SPC_107]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastManageListVO> searchDailyForecastManageListByKor(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDailyForecastManageListByKor(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_107]을 [행위] 합니다.<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void multiDailyForecastManageForKor(SpcDlyFcastCustVO[] spcDlyFcastCustVO,String usrId) throws EventException{
		try {
			List<SpcDlyFcastCustVO> insertVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> updateVoList = new ArrayList<SpcDlyFcastCustVO>();
			List<SpcDlyFcastCustVO> deleteVoList = new ArrayList<SpcDlyFcastCustVO>();
			for ( int i=0; i<spcDlyFcastCustVO .length; i++ ) {
				spcDlyFcastCustVO[i].setUpdUsrId(usrId);				
				spcDlyFcastCustVO[i].setFcastCustTpCd("C");//  한국 지점은 FCAST_CUST_TP_CD를 'C'로 고정
				
				if ( spcDlyFcastCustVO[i].getIbflag().equals("I") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){	
					insertVoList.add(spcDlyFcastCustVO[i]);
					
					if(spcDlyFcastCustVO[i].getPodYdCd().equals("")){
						deleteVoList.add(spcDlyFcastCustVO[i]);
					}
				} else if ( spcDlyFcastCustVO[i].getIbflag().equals("U") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){	
					updateVoList.add(spcDlyFcastCustVO[i]);
					
					if(spcDlyFcastCustVO[i].getPodYdCd().equals("")){
						deleteVoList.add(spcDlyFcastCustVO[i]);
					}
				} else if ( spcDlyFcastCustVO[i].getIbflag().equals("D") && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){
					deleteVoList.add(spcDlyFcastCustVO[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpcDlyFcastCustSForKor(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addmultiSpcDlyFcastCustSForKor(updateVoList);
//				dbDao.modifymultiSpcDlyFcastCustSForKor(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSpcDlyFcastCustS(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0102 : [Retreive 전]<br>
	 * 해당 Sales Rep이 몇 개의 Account를 체크했는지 개수를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSrepAccountCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchSrepAccountCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_109]을 [조회] 합니다.<br>
	 * Forecast Input(Contract) 정보를 조회합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastManageListVO>
	 * @exception EventException
	 */
	public List<SearchContractForecastManageListVO> searchContractForecastManageList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchContractForecastManageList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [ESM_SPC_109]을 [행위] 합니다.<br>
	 * Forecast Input(Contract) 정보를 관리합니다.
	 * 
	 * @param SpcCtrtFcastCustVO[] spcCtrtFcastCustVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiContractForecastManage(SpcCtrtFcastCustVO[] spcCtrtFcastCustVO,SignOnUserAccount account) throws EventException{
		try {
			List<SpcCtrtFcastCustVO> insertVoList = new ArrayList<SpcCtrtFcastCustVO>();
			List<SpcCtrtFcastCustVO> updateVoList = new ArrayList<SpcCtrtFcastCustVO>();
			List<SpcCtrtFcastCustVO> deleteVoList = new ArrayList<SpcCtrtFcastCustVO>();
			
			for ( int i=0; i<spcCtrtFcastCustVO .length; i++ ) {
				spcCtrtFcastCustVO[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcCtrtFcastCustVO[i].getIbflag().equals("I")){	
					insertVoList.add(spcCtrtFcastCustVO[i]);
				} else if ( spcCtrtFcastCustVO[i].getIbflag().equals("U")){					
					updateVoList.add(spcCtrtFcastCustVO[i]);
				} else if ( spcCtrtFcastCustVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcCtrtFcastCustVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiContractForecast(insertVoList);
				dbDao.addmultiContractForecastHis(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiContractForecast(updateVoList);
				dbDao.addmultiContractForecastHis(updateVoList);
			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removemultiContractForecast(deleteVoList);
//			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0110]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchDailyForecastHistorySrepAcctListVO>
	 * @exception EventException
	 */
	public List<SearchDailyForecastHistorySrepAcctListVO> searchPreviousSalesRepList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchPreviousSalesRepList(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * [ESM_SPC_0110]을 [저장] 합니다.
	 * 
	 * @param SearchDailyForecastManageListVO[] searchDailyForecastManageListVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiDailyForecastManageSwitch(SearchDailyForecastManageListVO[] searchDailyForecastManageListVO, SignOnUserAccount account) throws EventException {
		try {
			List<SearchDailyForecastManageListVO> updateVoList = new ArrayList<SearchDailyForecastManageListVO>();
			List<SearchDailyForecastManageListVO> deleteVoList = new ArrayList<SearchDailyForecastManageListVO>();
			
			List<SpcSlsRepCustVO> insertVoList1 = new ArrayList<SpcSlsRepCustVO>();
			List<SpcSlsRepCustVO> insertVoList2 = new ArrayList<SpcSlsRepCustVO>();
			SpcSlsRepCustVO tempVo = new SpcSlsRepCustVO();
			SpcSlsRepCustVO tempVo1 = new SpcSlsRepCustVO();
			
			for ( int i=0; i<searchDailyForecastManageListVO .length; i++ ) {
				searchDailyForecastManageListVO[i].setUpdUsrId(account.getUsr_id());				
				//searchDailyForecastManageListVO[i].setFcastCustTpCd("C");//  한국 지점은 FCAST_CUST_TP_CD를 'C'로 고정
				
				// 신규로 추가된 화주를 Individual Account로 등록.
				// XX999999(Others) 강제 생성하기 위함
				if(i==0){
					tempVo.setSrepCd(searchDailyForecastManageListVO[0].getSalesRep());
					tempVo.setSlsOfcCd(searchDailyForecastManageListVO[0].getOfcCd());
					tempVo.setSlsRepOfcTeamCd(searchDailyForecastManageListVO[0].getSubOfcCd());
					tempVo.setRvisCntrCustTpCd("N");
					tempVo.setCustCntCd("XX");
					tempVo.setCustSeq("999999");
					tempVo.setDeltFlg("N");
					tempVo.setUpdUsrId(account.getUsr_id());					
					insertVoList1.add(tempVo);
				}
				
				tempVo = new SpcSlsRepCustVO();
				tempVo.setSrepCd(searchDailyForecastManageListVO[0].getSalesRep());
				tempVo.setSlsOfcCd(searchDailyForecastManageListVO[0].getOfcCd());
				tempVo.setSlsRepOfcTeamCd(searchDailyForecastManageListVO[0].getSubOfcCd());
				tempVo.setRvisCntrCustTpCd(searchDailyForecastManageListVO[i].getCustTpCd());
				tempVo.setCustCntCd(searchDailyForecastManageListVO[i].getCustCntCd());
				tempVo.setCustSeq(searchDailyForecastManageListVO[i].getCustSeq());
				tempVo.setDeltFlg("N");
				tempVo.setUpdUsrId(account.getUsr_id());					
				insertVoList1.add(tempVo);
				//////////////////////////////////////////////////////////////////////////////////
				
				// 전임자의 Individual Account에서 삭제처리
				tempVo1 = new SpcSlsRepCustVO();
				tempVo1.setSrepCd(searchDailyForecastManageListVO[i].getSrepCd());
				tempVo1.setSlsOfcCd(searchDailyForecastManageListVO[0].getOfcCd());
				tempVo1.setSlsRepOfcTeamCd(searchDailyForecastManageListVO[0].getSubOfcCd());
				tempVo1.setRvisCntrCustTpCd(searchDailyForecastManageListVO[i].getCustTpCd());
				tempVo1.setCustCntCd(searchDailyForecastManageListVO[i].getCustCntCd());
				tempVo1.setCustSeq(searchDailyForecastManageListVO[i].getCustSeq());
				tempVo1.setDeltFlg("Y");
				tempVo1.setUpdUsrId(account.getUsr_id());					
				insertVoList2.add(tempVo1);
				/////////////////////////////////////////////////////////////////////////////////
				
				
				// 전임자의 Forecast 정보 승계
				if ( searchDailyForecastManageListVO[i].getIbflag().equals("U")){
					searchDailyForecastManageListVO[i].setTrdCd(searchDailyForecastManageListVO[0].getTrdCd());
					searchDailyForecastManageListVO[i].setIocTsCd(searchDailyForecastManageListVO[0].getIocTsCd());
					updateVoList.add(searchDailyForecastManageListVO[i]);
					deleteVoList.add(searchDailyForecastManageListVO[i]);
				}
			}
			
			// 신규로 추가된 화주를 Individual Account로 등록
			if ( insertVoList1.size() > 0 ) {
				dbDao.addmultiSalesRepAccountManageS(insertVoList1);
			}
			
			// 전임자의 Individual Account에서 삭제처리
			if ( insertVoList2.size() > 0 ) {
				dbDao.addmultiSalesRepAccountManageS(insertVoList2);
			}
			
			// 전임자의 Forecast 정보 승계
			if ( updateVoList.size() > 0 ) {
				dbDao.addDailyForecastManageSwitch(updateVoList);
			}
			
			// 전임자의 Forecast 정보 삭제
			if ( deleteVoList.size() > 0 ) {
				dbDao.removePreSrepDailyForecastManage(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SPC_0111 : [이벤트]
	 * 
	 * @param SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOS
	 * @param SignOnUserAccount account
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @throws EventException
	 */
	public void multiLoadOfficeMappingList(SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOS, SignOnUserAccount account, DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			List<SpcCtrtFcastOfcMapgVO> deleteVoList = new ArrayList<SpcCtrtFcastOfcMapgVO>();
			List<SpcCtrtFcastOfcMapgVO> insertVoList = new ArrayList<SpcCtrtFcastOfcMapgVO>();
			
			for ( int i=0; i<spcCtrtFcastOfcMapgVOS .length; i++ ) {
				spcCtrtFcastOfcMapgVOS[i].setTrdCd(dailyforecastmanageConditionVO.getTrade());
				spcCtrtFcastOfcMapgVOS[i].setIocTsCd(dailyforecastmanageConditionVO.getIoc());
				spcCtrtFcastOfcMapgVOS[i].setCtrtOfcCd(dailyforecastmanageConditionVO.getOfcCd());
				spcCtrtFcastOfcMapgVOS[i].setCustCntCd(dailyforecastmanageConditionVO.getCustcntcd());
				spcCtrtFcastOfcMapgVOS[i].setCustSeq(dailyforecastmanageConditionVO.getCustseq());
				spcCtrtFcastOfcMapgVOS[i].setFcastSeq(dailyforecastmanageConditionVO.getFcastSeq());
				spcCtrtFcastOfcMapgVOS[i].setCreUsrId(account.getUsr_id());
				spcCtrtFcastOfcMapgVOS[i].setUpdUsrId(account.getUsr_id());
				
				if ( spcCtrtFcastOfcMapgVOS[i].getIbflag().equals("I")){
					insertVoList.add(spcCtrtFcastOfcMapgVOS[i]);
				} else if ( spcCtrtFcastOfcMapgVOS[i].getIbflag().equals("D")){
					deleteVoList.add(spcCtrtFcastOfcMapgVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiLoadOfficeMappingList(insertVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiLoadOfficeMappingList(deleteVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0111 : [이벤트]
	 * 
	 * 
	 * @param DailyforecastmanageConditionVO dailyforecastmanageConditionVO
	 * @return List<SearchLoadOfficeMappingListVO>
	 * @throws EventException
	 */
	public List<SearchLoadOfficeMappingListVO> searchLoadOfficeMappingList(DailyforecastmanageConditionVO dailyforecastmanageConditionVO) throws EventException {
		try {
			return dbDao.searchLoadOfficeMappingList(dailyforecastmanageConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SPC_0112 : [이벤트]
	 * 본사에서 내려준 Account에 따른 S.Rep List를 조회한다.
	 * 
	 * @param SearchSalesRepInfoVO searchSalesRepInfoVO
	 * @return List<SearchSalesRepInfoVO>
	 * @throws EventException
	 */
	public List<SearchSalesRepInfoVO> searchAccountSrepList(SearchSalesRepInfoVO searchSalesRepInfoVO) throws EventException {
		try {
			List<SearchSalesRepInfoVO> voList = dbDao.searchAccountSrepList(searchSalesRepInfoVO);
			SearchSalesRepInfoVO main = new SearchSalesRepInfoVO();			
			main.setVoList(voList);
			
			List<SearchSalesRepInfoVO> mainList = new ArrayList<SearchSalesRepInfoVO>();
			mainList.add(main);
			
			return mainList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SPC_0112 : [이벤트]
	 * 화주별 담당 S.REP을 등록한다.
	 * 
	 * @param SpcSlsRepCustVO[] spcSlsRepCustVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAccountSrepList(SpcSlsRepCustVO[] spcSlsRepCustVOS, SignOnUserAccount account) throws EventException {
		try {
			List<SpcSlsRepCustVO> deleteVoList = new ArrayList<SpcSlsRepCustVO>();
			List<SpcSlsRepCustVO> updateVoList = new ArrayList<SpcSlsRepCustVO>();
			SpcSlsRepCustVO tempVo  = new SpcSlsRepCustVO();
			SpcSlsRepCustVO tempVo1 = new SpcSlsRepCustVO();
			String srep_cd = "";
			
			for ( int i=0; i<spcSlsRepCustVOS .length; i++ ) {
				spcSlsRepCustVOS[i].setUpdUsrId(account.getUsr_id());
				spcSlsRepCustVOS[i].setTrade(spcSlsRepCustVOS[0].getTrade());
				spcSlsRepCustVOS[i].setOfcCd(spcSlsRepCustVOS[0].getOfcCd());
				
				String[] sub_trd_cd = (spcSlsRepCustVOS[i].getSubTrdCd()).split(",");
				
				for( int j=0; j<sub_trd_cd.length; j++) {
					// XX999999(Others) 강제 생성하기 위함
					if(!srep_cd.equals(spcSlsRepCustVOS[i].getSrepCd())){
						tempVo.setSrepCd(spcSlsRepCustVOS[i].getSrepCd());
						tempVo.setRvisCntrCustTpCd("N");
						tempVo.setCustCntCd("XX");
						tempVo.setCustSeq("999999");
						tempVo.setDeltFlg("N");
						tempVo.setTrade(spcSlsRepCustVOS[0].getTrade());
						tempVo.setSubTrdCd(sub_trd_cd[j]);
						tempVo.setOfcCd(spcSlsRepCustVOS[0].getOfcCd());
						tempVo.setIndivCustUseFlg("Y");
						tempVo.setUpdUsrId(account.getUsr_id());
						tempVo.setCustMapgFlg("N");
						
						SpcSlsRepCustVO tempVo2 = (SpcSlsRepCustVO) tempVo.clone();
						updateVoList.add(tempVo2);
					}
					
					// 첫번째는 XX999999(Others) 로 생각하고, 두번째 부터 처리
					//if(i>0){
					
						tempVo1 = (SpcSlsRepCustVO) spcSlsRepCustVOS[i].clone();
						tempVo1.setSubTrdCd(sub_trd_cd[j]);
//						tempVo1.setOfcCd(spcSlsRepCustVOS[i].getSlsOfcCd());
						
						if ( spcSlsRepCustVOS[i].getIbflag().equals("I")){
							tempVo1.setIndivCustUseFlg("Y");
							tempVo1.setCustMapgFlg("Y");
							updateVoList.add(tempVo1);
							deleteVoList.add(tempVo1);
						} else if ( spcSlsRepCustVOS[i].getIbflag().equals("U")){
							tempVo1.setIndivCustUseFlg("Y");
							tempVo1.setCustMapgFlg("Y");
							updateVoList.add(tempVo1);
							deleteVoList.add(tempVo1);
						} else if ( spcSlsRepCustVOS[i].getIbflag().equals("R")){
							tempVo1.setIndivCustUseFlg("Y");
							tempVo1.setCustMapgFlg("Y");
							updateVoList.add(tempVo1);
						} else if ( spcSlsRepCustVOS[i].getIbflag().equals("D")){
							deleteVoList.add(tempVo1);
						}
				    //}
				}
				
			    srep_cd = spcSlsRepCustVOS[i].getSrepCd();
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiAccountSrepList(deleteVoList, "ESM_SPC_0112");
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addmultiAccountSrepList(updateVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_SPC_0108]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO paramVO
	 * @return List<SearchAccumulatedGuidePfmcVO>
	 * @exception EventException
	 */
	public List<SearchAccumulatedGuidePfmcVO> searchAccumulatedGuidePfmcList(ConditionVO paramVO) throws EventException {
		try {
			List<SearchAccumulatedGuidePfmcVO> list = new ArrayList<SearchAccumulatedGuidePfmcVO>();
			ConditionVO vo = dbDao.searchSeasonPeriod(paramVO);
			if(vo!=null){
				paramVO.setSeason(vo.getSeason());
				paramVO.setVersion(vo.getVersion());
				
				String stYr = paramVO.getYear1();
				String stWk = paramVO.getWeek1();
				if("".equals(stYr) || "".equals(stWk)){
					paramVO.setYear1(vo.getSdate().substring(0,4));
					paramVO.setWeek1(vo.getSdate().substring(4));
				}
				list = dbDao.searchAccumulatedGuidePfmcList(paramVO);
				
				if ( list.size() > 0 ) {
					list.get(0).setSdate(vo.getSdate());
					list.get(0).setEdate(vo.getEdate());
				}
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [모바일] others fcast 입력시 내부에 존재하는 fcast를 0으로 update (alps는 화면내에서 control함)<br>
	 * 
	 * @param SpcDlyFcastCustVO[] spcDlyFcastCustVO
	 * @param String usrId
	 * @exception EventException
	 */
	public void multiOthersFcastToZero(SpcDlyFcastCustVO[] spcDlyFcastCustVO,String usrId) throws EventException{
		try {
			List<SpcDlyFcastCustVO> deleteVoList = new ArrayList<SpcDlyFcastCustVO>();
			
			for ( int i=0; i<spcDlyFcastCustVO .length; i++ ) {
				spcDlyFcastCustVO[i].setUpdUsrId(usrId);				
				
				if ( (spcDlyFcastCustVO[i].getIbflag().equals("I")||spcDlyFcastCustVO[i].getIbflag().equals("U")) && !spcDlyFcastCustVO[i].getVslCd().equals("TTL")){	
					if(!"".equals(spcDlyFcastCustVO[i].getPodYdCd())){//zero 쿼리 건당 한번만 타도록
						if("XX".equals(spcDlyFcastCustVO[i].getCustCntCd()) && "999999".equals(spcDlyFcastCustVO[i].getCustSeq())){
							//zero 대상
							deleteVoList.add(spcDlyFcastCustVO[i]);
						}
					}
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.modifyOthersFcastToZero(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}