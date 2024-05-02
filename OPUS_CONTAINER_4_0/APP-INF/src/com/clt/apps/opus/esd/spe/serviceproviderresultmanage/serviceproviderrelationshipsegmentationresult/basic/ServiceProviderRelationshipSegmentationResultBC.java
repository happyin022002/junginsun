/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipSegmentationResultBC.java
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
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.vo.SearchServiceProviderRelationshipSegmentationResultListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Serviceproviderresultmanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Serviceproviderresultmanage<br>
 *
 * @author
 * @see Esd_spe_0005EventResponse
 * @since J2EE 1.6
 */

public interface ServiceProviderRelationshipSegmentationResultBC {

	/**
	 * Retrieving the list of service provider relationship segmentation result
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipSegmentationResultListVO>
	 * @exception EventException
	 */
	public List<SearchServiceProviderRelationshipSegmentationResultListVO> searchServiceProviderRelationshipSegmentationResultList(SearchInputListVO searchInputListVO) throws EventException;
}