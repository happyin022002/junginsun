/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairExceptionBCImpl.java
 *@FileTitle : PortPairExceptionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration.PortPairExceptionDBDAO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.PartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command implementation<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class PortPairExceptionBCImpl  extends BasicCommandSupport implements PortPairExceptionBC {
	// Database Access Object
	private transient PortPairExceptionDBDAO dbDao=null;
	// EAI Interface Object
	//private transient LaneServiceSendEAIDAO eaiDao = null;
	/**
	 * PortPairExceptionBCImpl 객체 생성<br>
	 * PortPairExceptionDAO 생성한다.<br>
	 */
	public PortPairExceptionBCImpl(){
		dbDao = new PortPairExceptionDBDAO();
	}

	/**
	 * ESD_SCE_0123 : 저장
	 * @param AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageAdjustment(AdjustmentVO[] adjustmentVOs, SignOnUserAccount account) throws EventException{
		try {
			//List<AdjustmentVO> insertVoList = new ArrayList<AdjustmentVO>();
			List<AdjustmentVO> updateVoList = new ArrayList<AdjustmentVO>();
			List<AdjustmentVO> deleteVoList = new ArrayList<AdjustmentVO>();
			
			for ( int i=0; i<adjustmentVOs .length; i++ ) {
				String flag = adjustmentVOs[i].getIbflag();
				//if((adjustmentVOs[i].getAdjSeq().equals(null) || adjustmentVOs[i].getAdjSeq().equals("")) && flag.equals("U")){
				if((adjustmentVOs[i].getAdjSeq() == null || adjustmentVOs[i].getAdjSeq().equals("")) && flag.equals("U")){
					flag = "I";
				}
				adjustmentVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( flag.equals("I")){
					adjustmentVOs[i].setCreUsrId(account.getUsr_id());
					//insertVoList.add(adjustmentVOs[i]);
					dbDao.addAdjustment(adjustmentVOs[i]);
				} else if ( flag.equals("U")){
					updateVoList.add(adjustmentVOs[i]);
				} else if ( flag.equals("D")){
					deleteVoList.add(adjustmentVOs[i]);
				}
			}
			/*
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneDetail(insertVoList);
			}
			*/
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAdjustment(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAdjustment(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

   /**
    * TP ID 을 조회 합니다.<br>
    * @param   SearchGetPartnerVO searchGetPartnerVO
    * @throws  EventException
    * @return  List<SearchGetPartnerVO>
    */ 
    public List<SearchGetPartnerVO> searchTpId(SearchGetPartnerVO searchGetPartnerVO) throws EventException{
       try {
           return dbDao.searchTpId(searchGetPartnerVO); 
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("TOT10001", new String[]{"TP ID", "Retrieve"}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("TOT10001", new String[]{"TP ID", "Retrieve"}).getMessage(), ex);
       }
    }
	
    /**
     * Port Pair Detail 조회<br>
     * @param AdjustmentVO adjustmentVO 
     * @return List<AdjustmentVO>
     * @exception EventException
     */
	public List<AdjustmentVO> searchRouteListForAdjustment(AdjustmentVO adjustmentVO) throws EventException {
		try {
			return dbDao.searchRouteListForAdjustment(adjustmentVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	/**
	 * BlockLane List 조회<br>
	 * @param RouteForBLVO routeForBLVO
	 * @return List<RouteForBLVO>
	 * @exception EventException
	 */
	public List<RouteForBLVO> searchRouteListForBlockLane(RouteForBLVO routeForBLVO) throws EventException {
		try {
			return dbDao.searchRouteListForBlockLane(routeForBLVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	 /**
	  * ESD_SCE_124 : 리스트 조회 <br>
	  * 
	  * @param BlockLaneVO blockLaneVO
	  * @return List<BlockLaneVO> 
	  * @exception EventException
	  */
	public List<BlockLaneVO> searchBlockLaneList(BlockLaneVO blockLaneVO) throws EventException {
		try {
			
			return dbDao.searchBlockLaneList(blockLaneVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	/**
	 * ESD_SCE_124 : CUD<br>
	 * 
	 * @param BlockLaneVO[] blockLaneVOs
	 * @param account SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBlockLane(BlockLaneVO[] blockLaneVOs, SignOnUserAccount account) throws EventException{
		try {
			//gubun이 A인 경우 C1T0W 가 아닌경우 gubun이 B인 경우 C1T0W 인 경우
			List<BlockLaneVO> updateVoList = new ArrayList<BlockLaneVO>();
			List<BlockLaneVO> deleteVoList = new ArrayList<BlockLaneVO>();
			
			for ( int i=0; i<blockLaneVOs .length; i++ ) {
				blockLaneVOs[i].setCustTrdPrnrId(blockLaneVOs[0].getCustTrdPrnrId());
				blockLaneVOs[i].setPodCd( blockLaneVOs[0].getPodCd());
				blockLaneVOs[i].setPolCd( blockLaneVOs[0].getPolCd());
				blockLaneVOs[i].setUpdUsrId(account.getUsr_id());
				if ( blockLaneVOs[i].getIbflag().equals("I")){
					blockLaneVOs[i].setCreUsrId(account.getUsr_id());
					blockLaneVOs[i].setGubun(blockLaneVOs[0].getGubun());
					if(blockLaneVOs[0].getGubun().equals("A")){
						dbDao.addBlockLane(blockLaneVOs[i]);
					}else{
						dbDao.addAdjBlockLane(blockLaneVOs[i]);
					}
				} else if ( blockLaneVOs[i].getIbflag().equals("U")){
					updateVoList.add(blockLaneVOs[i]);
				} else if ( blockLaneVOs[i].getIbflag().equals("D")){
					deleteVoList.add(blockLaneVOs[i]);
					if(blockLaneVOs[0].getGubun().equals("A")){
						dbDao.removeBlockLane(blockLaneVOs[i]);
					}
				}
			}
			/*
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiBlockLane(insertVoList);
			}*/
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBlockLane(updateVoList);
			}
			if ( deleteVoList.size() > 0 && !blockLaneVOs[0].getGubun().equals("A")) {
				dbDao.removeAdjBlockLane(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESD_SCE_124 : 화면 open
	 * @param CustomerVO customerVO
	 * @return List<CustomerVO>
	 * @throws EventException
	 */
	public List<CustomerVO> searchLaneCombo(CustomerVO customerVO) throws EventException {
		try {
			return dbDao.searchLaneCombo(customerVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESD_SCE_0125 : Route Exception List 조회<br>
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return List<ExceptionalRouteVO>
	 * @exception EventException
	 */
	public List<ExceptionalRouteVO> searchExceptionalRouteList(ExceptionalRouteVO exceptionalRouteVO) throws EventException {
		try {
            return dbDao.searchExceptionalRouteList(exceptionalRouteVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_SCE_0125 : 저장
	 * @param ExceptionalRouteVO[] exceptionalRouteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageExceptionRoute(ExceptionalRouteVO[] exceptionalRouteVOs, SignOnUserAccount account) throws EventException{
		try {
			//List<AdjustmentVO> insertVoList = new ArrayList<AdjustmentVO>();
			List<ExceptionalRouteVO> updateVoList = new ArrayList<ExceptionalRouteVO>();
			List<ExceptionalRouteVO> deleteVoList = new ArrayList<ExceptionalRouteVO>();
			
			for ( int i=0; i<exceptionalRouteVOs .length; i++ ) {
				
				String flag = exceptionalRouteVOs[i].getIbflag();
				exceptionalRouteVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( flag.equals("I")){
	    			//중복 체크 로직
					if(dbDao.exceptSameRoute(exceptionalRouteVOs[i])){	//true
						throw new EventException(new ErrorHandler("PRD00051").getMessage());
					}
					exceptionalRouteVOs[i].setCreUsrId(account.getUsr_id());
					dbDao.addExceptionRoute(exceptionalRouteVOs[i]);
				} else if ( flag.equals("U")){
					updateVoList.add(exceptionalRouteVOs[i]);
				} else if ( flag.equals("D")){
					deleteVoList.add(exceptionalRouteVOs[i]);
				}
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyExceptionRoute(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeExceptionRoute(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	/**
	 * ESD_SCE_123 : PortPairPartner 검색 콤보 리스트 조회
	 * @return List<PartnerVO>
	 * @throws EventException
	 */
	@Override
	public List<PartnerVO> searchPortPairPartner() throws EventException {
		try {
			return dbDao.searchPortPairPartner();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	
	/**
	 * ESD_SCE_123 : Edi 323 Adjustment 검색 리스트 저장
	 * @param Edi323AdjustmentVO vo
	 * @return List<Edi323AdjustmentVO>
	 * @throws EventException
	 */
	@Override
	public List<Edi323AdjustmentVO> searchEdi323Adjustment(Edi323AdjustmentVO vo)
			throws EventException {
		try {
			return dbDao.searchEdi323Adjustment(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
	/**
	 * ESD_SCE_123 : Edi 323 Adjustment 검색 리스트 저장
	 * @param Edi323AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageEdi323Adjustment(Edi323AdjustmentVO[] adjustmentVOs,
			SignOnUserAccount account) throws EventException {
		try {
			List<Edi323AdjustmentVO> insertVoList = new ArrayList<Edi323AdjustmentVO>();
			List<Edi323AdjustmentVO> updateVoList = new ArrayList<Edi323AdjustmentVO>();
			List<Edi323AdjustmentVO> updateVoList2 = new ArrayList<Edi323AdjustmentVO>();
			List<Edi323AdjustmentVO> deleteVoList = new ArrayList<Edi323AdjustmentVO>();
			
			for ( int i=0; i<adjustmentVOs .length; i++ ) {
				String flag = adjustmentVOs[i].getIbflag();
				
				if((adjustmentVOs[i].getAdjSeq() == null || adjustmentVOs[i].getAdjSeq().equals("")) && flag.equals("U")){
					flag = "I";
				}
				adjustmentVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( flag.equals("I")){
					adjustmentVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(dbDao.searchEdi323AdjustmentSequence(adjustmentVOs[i]));
				} else if ( flag.equals("U")){
					updateVoList.add(adjustmentVOs[i]);
					adjustmentVOs[i].setCreUsrId(account.getUsr_id());
					updateVoList2.add(adjustmentVOs[i]);
				} else if ( flag.equals("D")){
					deleteVoList.add(adjustmentVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEdi323Adjustment(insertVoList);
				dbDao.addEdi323AdjustmentLane(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEdi323Adjustment(updateVoList);
				dbDao.removeEdi323AdjustmentLane(updateVoList);
				dbDao.addEdi323AdjustmentLane(updateVoList2);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEdi323Adjustment(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	
	/**
	 * ESD_SCE_127 : Edi 323 Adjustment Lane 검색 리스트 조회
	 * @param Event e
	 * @return List<Edi323AdjustmentLaneVO>
	 * @throws EventException
	 */
	@Override
	public List<Edi323AdjustmentLaneVO> searchEdi323AdjustmentLane(Event e) throws EventException {
		try {
			
			return dbDao.searchEdi323AdjustmentLane(e);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TOT10001", new String[]{"", ""}).getMessage(), ex);
		}
	}
 
}
