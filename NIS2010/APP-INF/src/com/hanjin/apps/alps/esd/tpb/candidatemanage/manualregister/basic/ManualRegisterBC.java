/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterBC.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.07.17 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchEQKindVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
   
/**
 * ALPS-ManualRegistermanage Business Logic Command Interface<br>
 * - ALPS-ManualRegistermanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Geon Byeon
 * @see Esd_tpb_0133EventResponse 참조
 * @since J2EE 1.6
 */

public interface ManualRegisterBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDuplicationListVO searchTPBDuplicationListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBDuplicationListVO>
	 * @exception EventException
	 */
	public List<SearchTPBDuplicationListVO> searchTPBDuplicationList(SearchTPBDuplicationListVO searchTPBDuplicationListVO, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchContainerInfoVO searchContainerInfoVO
	 * @return List<SearchContainerInfoVO>
	 * @exception EventException
	 */
	public List<SearchContainerInfoVO> searchContainerInfo(SearchContainerInfoVO searchContainerInfoVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateTPBCandidateVO[] createTPBCandidateVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @throws DAOException 
	 */ 
	public void createTPBCandidate(CreateTPBCandidateVO[] createTPBCandidateVO,SignOnUserAccount account) throws EventException, DAOException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param CreateEACRegistrationVO[] createEACRegistrationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createEACRegistration(CreateEACRegistrationVO[] createEACRegistrationVO,SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBOfficeListVO searchTPBOfficeListVO
	 * @return List<SearchTPBOfficeListVO>
	 * @exception EventException
	 */
	public List<SearchTPBOfficeListVO> searchTPBOfficeList(SearchTPBOfficeListVO searchTPBOfficeListVO) throws EventException;
	
	/**
	 * eqNo 를 체크합니다.<br>
	 * 
	 * @param String eqNo
	 * @return String
	 * @exception EventException
	 */
	public String checkEqNo(String eqNo) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String n3pty_expn_tp_cd
	 * @return List<SearchEQKindVO>
	 * @exception EventException
	 */
	public List<SearchEQKindVO> searchEQKindCd(String n3pty_expn_tp_cd) throws EventException;
	
	
	/**
	 * finance direction code  및 BKG VVD check 한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String ydCd
	 * @param String bkgNo   
	 * @return String
	 * @exception EventException
	 */
	public String searchBkgVVDFincDirCd(String vvdCd, String ydCd, String bkgNo) throws EventException;	
	
	
}