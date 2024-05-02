/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipSegmentationResultBCImpl.java
*@FileTitle : SRS Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.integration.ServiceProviderRelationshipSegmentationResultDBDAO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.vo.SearchServiceProviderRelationshipSegmentationResultListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ServiceProviderResultManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-ServiceProviderResultManage<br>
 *
 * @author 
 * @see ESD_SPE_0005EventResponse,ServiceProviderRelationshipSegmentationResultBC
 * @since J2EE 1.6
 */
public class ServiceProviderRelationshipSegmentationResultBCImpl extends BasicCommandSupport implements ServiceProviderRelationshipSegmentationResultBC {

	// Database Access Object
	private transient ServiceProviderRelationshipSegmentationResultDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating ServiceProviderRelationshipSegmentationResultDBDAO class<br>
	 */
	public ServiceProviderRelationshipSegmentationResultBCImpl() {
		dbDao = new ServiceProviderRelationshipSegmentationResultDBDAO();
	}
	
	/**
	 * Retrieving the list of service provider relationship segmentation result
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipSegmentationResultListVO>
	 * @exception EventException
	 */
	public List<SearchServiceProviderRelationshipSegmentationResultListVO> searchServiceProviderRelationshipSegmentationResultList(SearchInputListVO searchInputListVO) throws EventException {
		try {
			return dbDao.searchServiceProviderRelationshipSegmentationResultList(searchInputListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
}