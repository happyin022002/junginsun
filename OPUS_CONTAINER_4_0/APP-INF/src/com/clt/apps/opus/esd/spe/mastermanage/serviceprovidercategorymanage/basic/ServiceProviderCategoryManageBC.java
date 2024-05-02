/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderCategoryManageBC.java
*@FileTitle : S/P Category 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchOfficeCodeAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchSPCategoryManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeSvcProvSvcCateMtchVO;

/**
 * ALPS-Mastermanage Business Logic Command Interface<br>
 * - The interface of the business logic of ALPS-Mastermanage<br>
 *
 * @author 
 * @see Esd_spe_002EventResponse 
 * @since J2EE 1.6
 */

public interface ServiceProviderCategoryManageBC {

	/**
	 * Retrieving the managing SP Category<br>
	 * 
	 * @param SearchSPCategoryManageConditionVO	searchSPCategoryManageConditionVO
	 * @return List<SearchSPCategoryManageVO>
	 * @exception EventException
	 */
	public List<SearchSPCategoryManageVO> searchSPCategoryManage(SearchSPCategoryManageConditionVO searchSPCategoryManageConditionVO) throws EventException;
	
	/**
	 * Retrieving the list of all office code
	 * 
	 * @return List<SearchOfficeCodeAllListVO>
	 * @exception EventException
	 */
	public List<SearchOfficeCodeAllListVO> searchOfficeCodeAllList() throws EventException;
	
	/**
	 * Retrieving the list of all office code<br>
	 * 
	 * @param SearchVndrSeqVO searchVndrSeqVO
	 * @return List<SearchVndrSeqVO>
	 * @exception EventException
	 */
	public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO)throws EventException;
	
	/**
	 * Saving the data of SP Category
	 * 
	 * @param SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSPCategoryManage(SpeSvcProvSvcCateMtchVO[] speSvcProvSvcCateMtchVOs,SignOnUserAccount account) throws EventException;


}