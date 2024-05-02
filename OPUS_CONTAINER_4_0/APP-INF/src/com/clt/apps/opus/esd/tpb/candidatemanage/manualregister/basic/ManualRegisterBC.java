/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterBC.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
   
/**
 * -ManualRegistermanage Business Logic Command Interface<br>
 * - -ManualRegistermanage Business Logic Interface<br>
 *
 * @author 
 * @see Esd_tpb_0133EventResponse reference
 * @since J2EE 1.6
 */

public interface ManualRegisterBC {

	/**
	 * <br>
	 * 
	 * @param SearchTPBDuplicationListVO searchTPBDuplicationListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBDuplicationListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDuplicationListVO> searchTPBDuplicationList(SearchTPBDuplicationListVO searchTPBDuplicationListVO, SignOnUserAccount account) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchContainerInfoVO searchContainerInfoVO
	 * @return List<SearchContainerInfoVO>
	 * @exception EventException
	 */
	public List<SearchContainerInfoVO> searchContainerInfo(SearchContainerInfoVO searchContainerInfoVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param CreateTPBCandidateVO[] createTPBCandidateVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @throws DAOException 
	 */ 
	public void createTPBCandidate(CreateTPBCandidateVO[] createTPBCandidateVO,SignOnUserAccount account) throws EventException, DAOException;
	/**
	 * <br>
	 * 
	 * @param CreateEACRegistrationVO[] createEACRegistrationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createEACRegistration(CreateEACRegistrationVO[] createEACRegistrationVO,SignOnUserAccount account) throws EventException;

	/**
	 * <br>
	 * 
	 * @param SearchTPBOfficeListVO searchTPBOfficeListVO
	 * @return List<SearchTPBOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchTPBOfficeListVO> searchTPBOfficeList(SearchTPBOfficeListVO searchTPBOfficeListVO) throws EventException;
}