/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairExceptionBCImpl.java
 *@FileTitle : PortPairExceptionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.integration.PortPairExceptionDBDAO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * CustomerScheduleEdi Business Logic Command implementation<br>
 * 
 * @author 
 * @see
 * @since J2EE 1.4
 */
public class PortPairExceptionBCImpl  extends BasicCommandSupport implements PortPairExceptionBC {
	// Database Access Object
	private transient PortPairExceptionDBDAO dbDao=null;
	// EAI Interface Object
	//private transient LaneServiceSendEAIDAO eaiDao = null;
	/**
	 * PortPairExceptionBCImpl related objects creation<br>
	 * PortPairExceptionDAO objects creation.<br>
	 */
	public PortPairExceptionBCImpl(){
		dbDao = new PortPairExceptionDBDAO();
	}

	/**
	 * ESD_SCE_0123 : SAVE
	 * @param AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageAdjustment(AdjustmentVO[] adjustmentVOs, SignOnUserAccount account) throws EventException{
		try {
			//List<AdjustmentVO> insertVoList = new ArrayList<AdjustmentVO>();
			List<AdjustmentVO> updateVoList = new ArrayList<AdjustmentVO>();
			List<AdjustmentVO> deleteVoList = new ArrayList<AdjustmentVO>();
			if(null != adjustmentVOs){
				for ( int i=0; i<adjustmentVOs .length; i++ ) {
					String flag = adjustmentVOs[i].getIbflag();
					//2015.04.14 Modify Critical
					//if((adjustmentVOs[i].getAdjSeq().equals(null) || adjustmentVOs[i].getAdjSeq().equals("")) && flag.equals("U")){
					if(StringUtils.isBlank(adjustmentVOs[i].getAdjSeq()) && flag.equals("U")){
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
	
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyAdjustment(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeAdjustment(deleteVoList);
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

   /**
    * TP ID retrieving.<br>
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
     * Port Pair Detail retrieving<br>
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
	 * BlockLane List retrieving<br>
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
	  * ESD_SCE_124 : retrieving <br>
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
	 * ESD_SCE_124 :  open
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
	 * ESD_SCE_0125 : Route Exception List retrieving<br>
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
	 * ESD_SCE_0125 : SAVE
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
 
}
