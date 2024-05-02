/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireBC.java
*@FileTitle : Available Off Hire Q'ty
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireRegisterVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt Biz Logic Interface<br>
 *
 * @author 
 * @see Ees_lse_0020EventResponse 
 * @since J2EE 1.6
 */
public interface AvailableOffHireBC {

	/**
	 * Retrieving current state of equipment possible to return by Region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireSummaryVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireSummaryVO> searchAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Requesting current state of equipment possible to return by Region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving details of equipment available to return <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireDetailVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireDetailVO> searchAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Requesting details of equipment available to return<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Sending details of selected equipment available to return by Email<br>
	 *
	 * @param EmailSendInfoVO emailSendInfoVO
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param userAccount SignOnUserAccount
	 * @exception EventException
	 */
    public void sendToEmailAvailableOffHireContainerBasic(EmailSendInfoVO emailSendInfoVO, AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException;
    
	/**
	 * modify status of selected equipment available to return<br>
	 *
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param userAccount SignOnUserAccount
	 * @exception EventException
	 */
    public void modifyAvailableOffHireContainerBasic(AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException;

    /**
	 * Retrieving current state of confirmed equipments available to return<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireConfirmVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireConfirmVO> searchAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Requesting current state of confirmed equipments available to return by region<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Modifying all details of selected equipment into return fixed data<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerConfirmBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Modifying return state of selected equipment <br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerStatusBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving Code List of AvailableOffHire Yard <br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireYardCodeVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireYardCodeVO> searchAvailableOffHireYardCodeListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Retrieving state value about result of BackEndJob<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
	
	/**
	 * Retrieving current state of registered equipments available to return<br>
	 *
	 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireRegisterVO> searchAvailableTargetLocationBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException;

	/**
	 * Retrieving current state of registered equipments available to return<br>
	 *
	 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireRegisterVO> searchTargetOffHireContainerAgreementBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException;

	/**
	 * Retrieving current state of registered equipments available to return<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerTargetBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Retrieving Target Location of registered equipments available to return<br>
	 *
	 * @param  AvailableOffHireRegisterVO availableOffHireRegisterVO
	 * @return List<AvailableOffHireRegisterVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireRegisterVO> modifyAvailableOffHireContainerTargetBasic(AvailableOffHireRegisterVO availableOffHireRegisterVO) throws EventException;

	/**
	 * Retrieving current state of registered equipments available to return by region<br>
	 *
	 * @param  AvailableOffHireRegisterVO[] availableOffHireRegisterVOs
	 * @param SignOnUserAccount userAccount
	 * @throws EventException
	 */
	public void modifyTargetOffHireContainerRegisterBasic(AvailableOffHireRegisterVO[] availableOffHireRegisterVOs, SignOnUserAccount userAccount) throws EventException;
}
