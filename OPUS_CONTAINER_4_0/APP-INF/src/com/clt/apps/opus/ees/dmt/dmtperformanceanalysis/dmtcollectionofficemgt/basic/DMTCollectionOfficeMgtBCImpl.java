/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCollectionOfficeMgtBCImpl.java
*@FileTitle : DEM/DET Office Inquiry by Yard
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration.DMTCollectionOfficeMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DMTPerformanceAnalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see DMTCollectionOfficeMgtDBDAO class reference
 * @since J2EE 1.6
 */
public class DMTCollectionOfficeMgtBCImpl extends BasicCommandSupport implements DMTCollectionOfficeMgtBC {

	// Database Access Object
	private transient DMTCollectionOfficeMgtDBDAO dbDao = null;

	/**
	 * DMTCollectionOfficeMgtBCImpl Create object<br>
	 * DMTCollectionOfficeMgtDBDAO Create.<br>
	 */
	public DMTCollectionOfficeMgtBCImpl() {
		dbDao = new DMTCollectionOfficeMgtDBDAO();
	}
	
    /**
    * [DEM/DET Office Inquiry by Yard][SEARCH].<br>
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
}
