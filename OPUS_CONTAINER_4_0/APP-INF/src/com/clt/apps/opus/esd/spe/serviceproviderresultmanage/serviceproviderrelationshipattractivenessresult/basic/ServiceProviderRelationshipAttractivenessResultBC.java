/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipAttractivenessResultBC.java
*@FileTitle : RA Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchServiceProviderRelationshipAttractivenessResultListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SpeRltAtrcRsltAddVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Serviceproviderresultmanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Serviceproviderresultmanage
 *
 * @author 
 * @see Esd_spe_0004EventResponse 
 * @since J2EE 1.6
 */

public interface ServiceProviderRelationshipAttractivenessResultBC {

	/**
	 * Retrieving the list of service provider relationship attractiveness result.
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipAttractivenessResultListVO>
	 * @exception EventException
	 */
	public List<SearchServiceProviderRelationshipAttractivenessResultListVO> searchServiceProviderRelationshipAttractivenessResultList(SearchInputListVO searchInputListVO) throws EventException;
	
	/**
	 * Managing the data of SpeRltAtrcRslt.<br>
	 * 
	 * @param SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void multiSpeRltAtrcRslt(SpeRltAtrcRsltAddVO[] speRltAtrcRsltAddVOs,SignOnUserAccount account) throws EventException;
}