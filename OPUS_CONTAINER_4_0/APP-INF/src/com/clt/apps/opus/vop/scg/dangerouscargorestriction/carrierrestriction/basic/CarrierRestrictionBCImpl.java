/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionBCImpl.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration.CarrierRestrictionDBDAO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.CarrierRestrictionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.PortRestrictionOptionVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.ScgImdgCrrRstrVO;
import com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.vo.VopScg0009ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DangerousCargoRestriction Business Logic Basic Command implementation<br>
 * - Handling business transactions of OPUS-DangerousCargoRestriction<br>
 *
 * @author
 * @see VOP_SCG_0009EventResponse,CarrierRestrictionBC
 * @since J2EE 1.6
 */
public class CarrierRestrictionBCImpl extends BasicCommandSupport implements CarrierRestrictionBC {

	// Database Access Object
	private transient CarrierRestrictionDBDAO dbDao = null;

	/**
	 * CarrierRestrictionBCImpl object creation<br>
	 * CarrierRestrictionDBDAO creation<br>
	 */
	public CarrierRestrictionBCImpl() {
		dbDao = new CarrierRestrictionDBDAO();
	}
 
	
    /**
     * 
     * VOP_SCG_0009 Carrier Restiction SAVE process <br>
     * 
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
	public void manageCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO, SignOnUserAccount signOnUserAccount)
			throws EventException {

		List<CarrierRestrictionVO> returnVoList = 	new ArrayList<CarrierRestrictionVO>();
		VopScg0009ConditionVO cond = carrierRestrictionOptionVO.getCondition();
		try {
			List<CarrierRestrictionVO> insertVoList = new ArrayList<CarrierRestrictionVO>();
			List<CarrierRestrictionVO> updateVoList = new ArrayList<CarrierRestrictionVO>();
			List<CarrierRestrictionVO> deleteVoList = new ArrayList<CarrierRestrictionVO>();
			
			String optClass = cond.getOptclass();
			CarrierRestrictionVO[] pCarrierRestrictionVO = null;
			String sImdgUnNoNullCheck  = "";
			if( cond.getOptclass().equals("class")  ){
				pCarrierRestrictionVO = carrierRestrictionOptionVO.getClassCarrierRestrictionVOs();
				sImdgUnNoNullCheck = "Y";
			}
			if( cond.getOptclass().equals("unno")  ){
				pCarrierRestrictionVO = carrierRestrictionOptionVO.getUnnoCarrierRestrictionVOs();				
			}
			 
			if(pCarrierRestrictionVO != null){
				for ( int i=0; i<pCarrierRestrictionVO .length; i++ ) {
					pCarrierRestrictionVO[i].setVslOprTpCd( cond.getCrrCd() );
	 
					if ( pCarrierRestrictionVO[i].getIbflag().equals("U")){
						pCarrierRestrictionVO[i].setUpdUsrId(signOnUserAccount.getUsr_id());
						updateVoList.add(pCarrierRestrictionVO[i]);
					} else if ( pCarrierRestrictionVO[i].getIbflag().equals("D")){
						deleteVoList.add(pCarrierRestrictionVO[i]);
					}
				}				
			}
 
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCarrierRestriction(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCarrierRestriction(deleteVoList, optClass);
			}
			
			if(pCarrierRestrictionVO != null){
	            for ( int i=0; i<pCarrierRestrictionVO .length; i++ ) {
	                pCarrierRestrictionVO[i].setVslOprTpCd( cond.getCrrCd() );
	                if ( pCarrierRestrictionVO[i].getIbflag().equals("I")){
	        
	                    pCarrierRestrictionVO[i].setCreUsrId(signOnUserAccount.getUsr_id());
	                    pCarrierRestrictionVO[i].setImdgUnNoNull(   sImdgUnNoNullCheck  );
	                    List<CarrierRestrictionVO> checkRestrictionVO 
	                                           =   dbDao.getImdgCrrRstrVO( pCarrierRestrictionVO[i]  );
	                    //imdg_un_no_null
	                    /****************************Carrier Seq extract.***********************************/
	                    if( checkRestrictionVO.size() == 0  ){
	                        pCarrierRestrictionVO[i].setImdgCrrRstrSeq( dbDao.getImdgCrrRstrSeq(  pCarrierRestrictionVO[i].getVslOprTpCd()  ) );
	                    }else{
	                        carrierRestrictionOptionVO.setMsgCode("SCG50005");
	                        carrierRestrictionOptionVO.setMsgCodeNm(pCarrierRestrictionVO[i].getImdgCrrRstrExptCd()+"|"+pCarrierRestrictionVO[i].getSlanCd()+"|");
	                        return;  
	                    }
	                    dbDao.addCarrierRestriction(pCarrierRestrictionVO[i]);                  
	                    insertVoList.add(pCarrierRestrictionVO[i]);
	                }
	                if ( !pCarrierRestrictionVO[i].getIbflag().equals("D")   ){
	                    pCarrierRestrictionVO[i].setIbflag("R");
	                    returnVoList.add(pCarrierRestrictionVO[i]);
	                }                
	            }
			}

            carrierRestrictionOptionVO.setList(returnVoList);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restiction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Carrier Restiction"}).getMessage(), ex);
        }
		
		
	}
 
    /**
     * 
     * Carrier Restirction main retrieve <br>
     *
     * @param  CarrierRestrictionOptionVO carrierRestrictionOptionVO
     * @return List<CarrierRestrictionVO>
     * @throws EventException
     */
	public List<CarrierRestrictionVO>  searchCarrierRestriction(CarrierRestrictionOptionVO carrierRestrictionOptionVO) throws EventException {
 
		VopScg0009ConditionVO vopScg0009ConditionVO = carrierRestrictionOptionVO.getCondition();
 
		try {
             return dbDao.searchCarrierRestriction( vopScg0009ConditionVO );        
 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restiction"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restiction"}).getMessage(), ex);
        }
        
	}	 
 
    /**
     * Port & VSL OPR’s Carrier Restriction En-route main retrieve <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<ScgImdgCrrRstrVO> 
     * @throws EventException
     */ 
    public List<ScgImdgCrrRstrVO> searchCarrierEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchCarrierEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Carrier Restriction En-route"}).getMessage(), ex);
        }
    }

    /**
     * Port & VSL OPR’s Port Restriction En-route main retrieve <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionOptionVO> searchPortEnRouteList(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchPortEnRouteList(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        }
    }

    /**
     * Port & VSL OPR’s Port Restriction En-route main retrieve <br>
     * 
     * @param  PortRestrictionOptionVO portRestrictionOptionVO
     * @return List<PortRestrictionOptionVO> 
     * @throws EventException
     */ 
    public List<PortRestrictionOptionVO> searchPortRotnSeq(
            PortRestrictionOptionVO portRestrictionOptionVO) throws EventException {
        try {
            return dbDao.searchPortRotnSeq(portRestrictionOptionVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Port & VSL OPR’s Port Restriction En-route"}).getMessage(), ex);
        }
    }

	
}
 