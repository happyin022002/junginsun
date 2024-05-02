/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCollectionOfficeMgtBCImpl.java
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.29 mun jung cheol
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration.DMTCollectionOfficeMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.DmtYdExptCostVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;

/**
 * ALPS-DMTPerformanceAnalysis Business Logic Command Interface<br>
 * - ALPS-DMTPerformanceAnalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see DMTCollectionOfficeMgtDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTCollectionOfficeMgtBCImpl extends BasicCommandSupport implements DMTCollectionOfficeMgtBC {

	// Database Access Object
	private transient DMTCollectionOfficeMgtDBDAO dbDao = null;

	/**
	 * DMTCollectionOfficeMgtBCImpl 객체 생성<br>
	 * DMTCollectionOfficeMgtDBDAO를 생성한다.<br>
	 */
	public DMTCollectionOfficeMgtBCImpl() {
		dbDao = new DMTCollectionOfficeMgtDBDAO();
	}
	
    /**
    * [DEM/DET Office Inquiry by Yard]을 [SEARCH] 합니다.<br>
    * 
    * @param CollectionOfficeFinderVO collectionOfficeFinderVO
    * @return List<OfficeYardListVO>
    * @exception EventException
    */
    public List<OfficeYardListVO> searchCollectionOfficeList ( CollectionOfficeFinderVO collectionOfficeFinderVO ) throws EventException {
        try {
            return dbDao.searchCollectionOfficeList ( collectionOfficeFinderVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }	
    /**
     * [YardExceptionCost]을 [SEARCH] 합니다.<br>
     * 
     * @param DmtYdExptCostParmVO dmtYdExptCostParmVO
     * @return List<DmtYdExptCostVO>
     * @exception EventException
     */ 
    
    public List<DmtYdExptCostVO> searchYardExceptionCost( DmtYdExptCostParmVO dmtYdExptCostParmVO ) throws EventException {
        try {
        	
            return dbDao.searchYardExceptionCost( dmtYdExptCostParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
	/**
	 * YardExceptionCost를 생성, 수정한다<br>
	 * 
	 * @param DmtYdExptCostVO[] dmtYdExptCostVOs   
	 * @exception EventException
	 */
	public void modifyYardExceptionCost(DmtYdExptCostVO[] dmtYdExptCostVOs ) throws EventException{
        try {
    	    
			for ( int i=0; i< dmtYdExptCostVOs.length; i++ ) {
				DmtYdExptCostVO dmtYdExptCostVO = dmtYdExptCostVOs[i];

				String ibflag = dmtYdExptCostVO.getIbflag();

				   if(ibflag.equals("R")) continue;
				   
				   if (ibflag.equals("I")){

					   dbDao.createYardExceptionCost(dmtYdExptCostVO);
				   }else if(ibflag.equals("U")){

					   dbDao.modifyYardExceptionCost(dmtYdExptCostVO);
				   }else if(ibflag.equals("D")){
					   dbDao.deleteYardExceptionCost(dmtYdExptCostVO);
				   }
				   
				
			}	

        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }

	/**
	 * YardExceptionCost를 Confirm한다<br>
	 * 
	 * @param DmtYdExptCostVO[] dmtYdExptCostVOs
	 * @param  String cfmCancel 
	 * @exception EventException
	 */
	public void confirmYardExceptionCost(DmtYdExptCostVO[] dmtYdExptCostVOs, String cfmCancel ) throws EventException{
        try {
        	List<DmtYdExptCostVO> cfmList = new ArrayList<DmtYdExptCostVO>();
        	for ( int i=0; i<dmtYdExptCostVOs.length; i++ ) {
				DmtYdExptCostVO dmtYdExptCostVO = dmtYdExptCostVOs[i];
				cfmList.add(dmtYdExptCostVO);
        	}	
        	
        	if (cfmList.size() > 0){
                dbDao.confirmYardExceptionCost(cfmList, cfmCancel);
        	}
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
	
    /**
     * [YardExceptionCost]을 [dup check] 합니다.<br>
     * 
     * @param String ydCd
     * @param String effDt
     * @param String expDt
     * @return String
     * @exception EventException
     */   
    public String checkCostDup(String ydCd, String effDt, String expDt ) throws EventException {
        try {
        	 return  dbDao.checkCostDup(ydCd, effDt, expDt);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    
  
}