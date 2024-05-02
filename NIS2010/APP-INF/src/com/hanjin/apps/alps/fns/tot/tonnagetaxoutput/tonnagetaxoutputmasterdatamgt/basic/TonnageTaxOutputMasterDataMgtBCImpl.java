/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtBCImpl.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2012.01.27 이준범 [CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration.TonnageTaxOutputMasterDataMgtDBDAO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.LaneVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.MissLaneChkVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.NrtBsaChgVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.PndlmPortVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TotVesselVO;
import com.hanjin.syscommon.common.table.TotBsaVO;
/**
 * ALPS-TonnageTaxOutput Business Logic Basic Command implementation<br>
 * - ALPS-TonnageTaxOutput에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Chang Soo
 * @see FNS_TOT_0001EventResponse,TonnageTaxOutputMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TonnageTaxOutputMasterDataMgtBCImpl extends BasicCommandSupport implements TonnageTaxOutputMasterDataMgtBC {

	// Database Access Object
	private transient TonnageTaxOutputMasterDataMgtDBDAO dbDao = null;

	/**
	 * TonnageTaxOutputMasterDataMgtBCImpl 객체 생성<br>
	 * TonnageTaxOutputMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public TonnageTaxOutputMasterDataMgtBCImpl() {
		dbDao = new TonnageTaxOutputMasterDataMgtDBDAO();
	}
	
	/**
	 * VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */
	public List<VslVO> searchUseTonnageVesselList(VslVO vslVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0001 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchUseTonnageVesselList(vslVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * VESSEL 정보의 가장 최근 업데이트된 날짜조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */	
	public List<VslVO> searchRecentUpdateDt(VslVO vslVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0001 SC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchRecentUpdateDt(vslVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	
	/**
	 * 추가,수정 또는 삭제된 VESSEL 정보를 저장한다. <br>
	 * 
	 * @param TotVesselVO[] totVesselVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageUseTonnageVessel (TotVesselVO[] totVesselVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");
			List<TotVesselVO> insertVoList = new ArrayList<TotVesselVO>();
			List<TotVesselVO> updateVoList = new ArrayList<TotVesselVO>();
			List<TotVesselVO> deleteVoList = new ArrayList<TotVesselVO>();
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 2:::::::::"+totVesselVO);
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입3:::::::::" +totVesselVO.length);
			
			for ( int i=0; i<totVesselVOs.length; i++ ) {
				if ( totVesselVOs[i].getIbflag().equals("I")){
					//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : I :::::::::");
					totVesselVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(totVesselVOs[i]);
				} else if ( totVesselVOs[i].getIbflag().equals("U")){
					//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : U :::::::::");
					totVesselVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(totVesselVOs[i]);
				} else if ( totVesselVOs[i].getIbflag().equals("D")){
					log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : D :::::::::");
					log.debug("::vsl_seq : D :::::::::"+totVesselVOs[i].getVslSeq());
					deleteVoList.add(totVesselVOs[i]);
				}
			}

			if(insertVoList.size() > 0){
				log.debug("::CALL::> FNS_TOT_0001 DAQ >IB_FLAG : I 존재:::::::::");
				
				for(int k=0; k<insertVoList.size(); k++){
					TotVesselVO vo = insertVoList.get(k);
					dbDao.addUseTonnageVessel (vo);
				}

			}
			
			if ( updateVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyUseTonnageVessel(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : D 존재:::::::::");
				dbDao.removeUseTonnageVessel(deleteVoList);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{"Save"}).getMessage(), ex);

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{"  Save"}).getMessage(),ex);
		}
	}

	/**
	 * 30일이상 사용하지 않은 VESSEL 정보를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */
	public List<VslVO> searchUnusedVesselList(VslVO vslVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0003 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchUnusedVesselList(vslVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 추가,수정 또는 삭제된 30일 이상 사용하지 않은 VESSEL 정보를 저장한다. <br>
	 * 
	 * @param TotVesselVO[] totVesselVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageUnusedVessel (TotVesselVO[] totVesselVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입 :::::::::");
			List<TotVesselVO> insertVoList = new ArrayList<TotVesselVO>();
			List<TotVesselVO> updateVoList = new ArrayList<TotVesselVO>();
			List<TotVesselVO> deleteVoList = new ArrayList<TotVesselVO>();
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입 2:::::::::"+totVesselVO);
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입3:::::::::" +totVesselVO.length);
			
			for ( int i=0; i<totVesselVOs.length; i++ ) {
				if ( totVesselVOs[i].getIbflag().equals("I")){
					//log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : I :::::::::");
					totVesselVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(totVesselVOs[i]);
				} else if ( totVesselVOs[i].getIbflag().equals("U")){
					//log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : U :::::::::");
					totVesselVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(totVesselVOs[i]);
				} else if ( totVesselVOs[i].getIbflag().equals("D")){
					//log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : D :::::::::");
					deleteVoList.add(totVesselVOs[i]);
				}
			}

			if(insertVoList.size() > 0){
				log.debug("::CALL::> FNS_TOT_0001 DAQ >IB_FLAG : I 존재:::::::::");
				for(int k=0; k<insertVoList.size(); k++){
					TotVesselVO vo = insertVoList.get(k);
					dbDao.addUnusedVessel (vo);
				}

			}
			
			if ( updateVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyUnusedVessel(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : D 존재:::::::::");
				dbDao.removeUnusedVessel(deleteVoList);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception EventException
	 */	
	public List<LaneVO> searchLaneTradeGroupList(LaneVO laneVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0003 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchLaneTradeGroupList(laneVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT00001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보의 최근업데이트일자를 조회한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @return List<LaneVO>
	 * @exception EventException
	 */	
	public List<LaneVO> searchRcLaneUpdateDt(LaneVO LaneVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0001 SC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchRcLaneUpdateDt(LaneVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 추가,수정 또는 삭제된 Trade정보를 저장한다. <br>
	 * 
	 * @param LaneVO[] laneVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageLaneTradeGroup (LaneVO[] laneVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {

			List<LaneVO> insertVoList = new ArrayList<LaneVO>();
			List<LaneVO> updateVoList = new ArrayList<LaneVO>();
			List<LaneVO> deleteVoList = new ArrayList<LaneVO>();
			
			for ( int i=0; i<laneVOs.length; i++ ) {
				if ( laneVOs[i].getIbflag().equals("I")){
					laneVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(laneVOs[i]);
				} else if ( laneVOs[i].getIbflag().equals("U")){
					laneVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(laneVOs[i]);
				} else if ( laneVOs[i].getIbflag().equals("D")){
					deleteVoList.add(laneVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				
				dbDao.addLaneTradeGroup(insertVoList);
				dbDao.addLaneTradeCd(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLaneTradeGroup(updateVoList);
				dbDao.modifyLaneTradeCd(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLane(deleteVoList);
				dbDao.removeLaneTrd(deleteVoList);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * 전월의 lane group 정보를 해당년월에 copy한다. <br>
	 * 
	 * @param LaneVO laneVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void createLaneTradeGroupFromPreMonth (LaneVO laneVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<LaneVO> insertVoList = new ArrayList<LaneVO>();
			
			String curYm = laneVO.getStlYrmon();
			String lastYm = DateTime.addMonths(curYm,-1,"yyyyMM");

			dbDao.removeLaneTradeGroupForCopy(laneVO);

			log.debug("::CALL::> createLaneTradeGroupFromPreMonth::::::::: lastYm : "+lastYm);
			laneVO.setStlYrmon(lastYm);
			List<LaneVO> list = dbDao.searchLaneTradeGroupForCopyList(laneVO);
			
			for ( int i=0; i<list.size(); i++ ) {
				LaneVO vo1 = list.get(i);
				vo1.setStlYrmon(curYm);
				vo1.setCreUsrId(signOnUserAccount.getUsr_id());
				insertVoList.add(vo1);
			}
			if ( insertVoList.size() > 0 ) {
				
				dbDao.addLaneTradeGroup(insertVoList);
				dbDao.addLaneTradeCd(insertVoList);
			}
			

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	
	/**
	 * Pendulm port Start Port List, End Port List 정보를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception EventException
	 */	
	public List<PndlmPortVO> searchPendulumLanePortCodeList(PndlmPortVO pndlmPortVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0008 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchPendulumLanePortCodeList(pndlmPortVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * Pendulm port Start Port List, End Port List 정보의 최근업데이트된 날짜를 조회한다. <br>
	 * 
	 * @param PndlmPortVO pndlmPortVO
	 * @return List<PndlmPortVO>
	 * @exception EventException
	 */	
	public List<PndlmPortVO> searchPendulumRecentUpdateDt(PndlmPortVO pndlmPortVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0008 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchPendulumRecentUpdateDt(pndlmPortVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 추가, 수정, 삭제된 Pendulm port Start Port List, End Port List 정보를 저장한다. <br>
	 * 
	 * @param PndlmPortVO[] pndlmPortVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @exception EventException
	 */	
	public int managePendulumLanePortCode (PndlmPortVO[] pndlmPortVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		int res =0;
		try {
			log.debug("::CALL::> FNS_TOT_0008 BC >진입 :::::::::");
			List<PndlmPortVO> insertVoList = new ArrayList<PndlmPortVO>();
			List<PndlmPortVO> updateVoList = new ArrayList<PndlmPortVO>();
			List<PndlmPortVO> deleteVoList = new ArrayList<PndlmPortVO>();
			log.debug("::CALL::> FNS_TOT_0003 BC >진입 2:::::::::"+pndlmPortVOs);
			//log.debug("::CALL::> FNS_TOT_0003 BC >진입3:::::::::" +totPndlmPortVO.length);
			
			for ( int i=0; i<pndlmPortVOs.length; i++ ) {
				if ( pndlmPortVOs[i].getIbflag().equals("I")){
					log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : I :::::::::");
					pndlmPortVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(pndlmPortVOs[i]);
				} else if ( pndlmPortVOs[i].getIbflag().equals("U")){
					log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : U :::::::::");
					pndlmPortVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(pndlmPortVOs[i]);
				} else if ( pndlmPortVOs[i].getIbflag().equals("D")){
					log.debug("::CALL::> FNS_TOT_0003 BC >IB_FLAG : D :::::::::");
					deleteVoList.add(pndlmPortVOs[i]);
				}
			}

			if(insertVoList.size() > 0){
				log.debug("::CALL::> FNS_TOT_0008 DAQ >IB_FLAG : I 존재:::::::::");
				
				for(int k=0; k<insertVoList.size(); k++){
					PndlmPortVO vo = insertVoList.get(k);
					res = dbDao.addStartEndPorts (vo);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0008 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyStartEndPort(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0008 BC >IB_FLAG : D 존재:::::::::");
				dbDao.removeStartEndPort(deleteVoList);
			}
			
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
		return res;
	}

	/**
	 * BSA 정보를 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */	
	public List<BsaVO> searchBSAListByVVD(BsaVO bsaVO) throws EventException {
		try {
			log.debug("::CALL::> FNS_TOT_0001 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchBSAListByVVD(bsaVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * BSA 정보의 tax 재계산전 변경된 데이터가 있는지 여부를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception EventException
	 */	
	public List<TotBsaVO> searchBSAModiFlgYCnt(TotBsaVO totBsaVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0006 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchRecalculateBsaForModiFlg(totBsaVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * BSA 정보의 배치처리된 데이터가 있는지를 조회한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @return List<TotBsaVO>
	 * @exception EventException
	 */	
	public List<TotBsaVO> searchBSABatchCnt(TotBsaVO totBsaVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0006 SC 그리드 조회DAO전> :::::::::");
			return dbDao.searchBSABatchCnt(totBsaVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	
	/**
	 * BSA 정보의 최근업데이트 일자를 조회한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @return List<BsaVO>
	 * @exception EventException
	 */	
	public List<BsaVO> searchBSARecentUpdateDt(BsaVO bsaVO) throws EventException {
		try {
			//log.debug("::CALL::> FNS_TOT_0001 SC 최근날짜 조회DAO전> :::::::::");
			return dbDao.searchBSARecentUpdateDt(bsaVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}

	/**
	 * 수정된 BSA 정보를 저장한다. <br>
	 * 
	 * @param TotBsaVO[] totBsaVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageBSAByVVD (TotBsaVO[] totBsaVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 :::::::::");
			//List<TotBsaVO> insertVoList = new ArrayList<TotBsaVO>();
			List<TotBsaVO> updateVoList = new ArrayList<TotBsaVO>();
			//List<TotBsaVO> deleteVoList = new ArrayList<TotBsaVO>();
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입 2:::::::::"+totVesselVO);
			//log.debug("::CALL::> FNS_TOT_0001 BC >진입3:::::::::" +totVesselVO.length);
			
			for ( int i=0; i<totBsaVOs.length; i++ ) {
				
				if ( totBsaVOs[i].getIbflag().equals("U")){
					//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : U :::::::::");
					totBsaVOs[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					if(totBsaVOs[i].getModiFlg().equals("1")){
						totBsaVOs[i].setModiFlg("Y");
					}else{
						totBsaVOs[i].setModiFlg("N");
					}
					
					updateVoList.add(totBsaVOs[i]);
				} 
				 
			}

			
			if ( updateVoList.size() > 0 ) {
				//log.debug("::CALL::> FNS_TOT_0001 BC >IB_FLAG : U 존재:::::::::");
				dbDao.modifyBSAByVVD(updateVoList);
				log.debug("::CALL::> FNS_TOT_0006 BC >IB_FLAG : U 끝:::::::::");
			}

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년월의 정보를 모두 삭제한다. <br>
	 * 
	 * @param BsaVO bsaVO
	 * @exception EventException
	 */	
	public void removeBSAByVVD (BsaVO bsaVO) throws EventException{
		try {
				dbDao.removeBSAByVVD(bsaVO);
				

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Remove"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Remove"}).getMessage(),ex);
		}
	}

	/**
	 * 해당년월의 BSA 정보를 생성하여 저장한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @exception EventException
	 */	
	public String manageIFBSAByVVD (TotBsaVO totBsaVO,SignOnUserAccount signOnUserAccount) throws EventException{

		try {
			String acctUsrId = signOnUserAccount.getUsr_id();
			// BC 객체 생성
			TonnageBSACreationBackEndJob command = new TonnageBSACreationBackEndJob();
			command.setTotBsaVO(totBsaVO);
			command.setUsrId(acctUsrId);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String backEndJobKey = backEndJobManager.execute(command, acctUsrId, "BSA Creation");

			return backEndJobKey;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	

	/**
	 * 변경된(MODIFY FLAG = 'Y') 정보를 "N" 으로 초기화한다. <br>
	 * 
	 * @param TotBsaVO totBsaVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */	
	public void manageRecalculateBsaForModiFlg (TotBsaVO totBsaVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			log.debug("::CALL::> FNS_TOT_0006 BC manageRecalculateBSA >진입 :::::::::");
		
		   // 모든 데이터 저장완료후 tot_bsa의 해당 데이터 modi_flag를 'N'으로 수정
			dbDao.modifyRecalculateBsaForModiFlg(totBsaVO);

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}	
	
	/**
	 * NRT & BSA Change 정보를 조회한다. <br>
	 * 
	 * @param String stlYrmon
	 * @return List<NrtBsaChgVO>
	 * @exception EventException
	 */	
	public List<NrtBsaChgVO>  searchNrtBsaChg(String stlYrmon) throws EventException {
		try {
			return dbDao.searchNrtBsaChg(stlYrmon);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * Missing Lane Check 정보를 조회한다. <br>
	 * 
	 * @param String stlYrmon
	 * @return List<MissLaneChkVO>
	 * @exception EventException
	 */	
	public List<MissLaneChkVO>  searchMissLaneChk(String stlYrmon) throws EventException {
		try {
			return dbDao.searchMissLaneChk(stlYrmon);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10001", new String[]{" Search"}).getMessage(),ex);
		}
	}
	
	/**
	 * NRT & BSA Change 화면에서 BSA Before 를 After로 업데이트 한다.<br>
	 * 
	 * @param NrtBsaChgVO nrtBsaChgVO
	 * @exception EventException
	 */	
	public void modifyNrtBsaChgBsa (NrtBsaChgVO nrtBsaChgVO) throws EventException{
		try {
		
		   // 모든 데이터 저장완료후 tot_bsa의 해당 데이터 modi_flag를 'N'으로 수정
			dbDao.modifyNrtBsaChgBsa(nrtBsaChgVO);

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}

	/**
	 * VESSEL 정보를 저장한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void createUseTonnageVessel(VslVO vslVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			vslVO.setCreUsrId(signOnUserAccount.getUsr_id());
			dbDao.createUseTonnageVessel(vslVO);
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
	}
	
	/**
	 * VESSEL 정보를 저장한다. <br>
	 * @param LaneVO laneVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	@Override
	public void createLaneTradeGroupByVesselSchedule(LaneVO laneVO, SignOnUserAccount signOnUserAccount)  throws EventException {
		try {
			List<LaneVO> insertVoList = new ArrayList<LaneVO>();
			List<LaneVO> insertVoList2 = new ArrayList<LaneVO>();
			
			String curYm = laneVO.getStlYrmon();

			dbDao.removeLaneTradeGroupForCopy(laneVO);

			log.debug("::CALL::> createLaneTradeGroupByVesselSchedule::::::::: curYm : "+curYm);
			
			//List<LaneVO> list = dbDao.searchLaneTradeGroupForCopyList(laneVO);
			List<LaneVO> laneList = dbDao.searchLaneTradeGroupForCreateTOTLANE(laneVO);
			List<LaneVO> laneTradeList = dbDao.searchLaneTradeGroupForCreateTOTLANETRADE(laneVO);
			
			for ( int i=0; i<laneList.size(); i++ ) {
				LaneVO vo1 = laneList.get(i);
				vo1.setStlYrmon(curYm);
				vo1.setCreUsrId(signOnUserAccount.getUsr_id());
				insertVoList.add(vo1);
			}
			
			for ( int i=0; i<laneTradeList.size(); i++ ) {
				LaneVO vo2 = laneTradeList.get(i);
				vo2.setStlYrmon(curYm);
				vo2.setCreUsrId(signOnUserAccount.getUsr_id());
				insertVoList2.add(vo2);
			}
			
			if ( insertVoList2.size() > 0 ) {
				dbDao.addTotLane(insertVoList);
				dbDao.addTotLaneTrade(insertVoList2);
			}
			

		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TOT10002", new String[]{" Save"}).getMessage(),ex);
		}
		
	}
}