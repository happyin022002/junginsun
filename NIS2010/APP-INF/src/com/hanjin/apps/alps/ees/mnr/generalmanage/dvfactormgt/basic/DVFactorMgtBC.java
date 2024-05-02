/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DVFactorMgtBC.java
*@FileTitle : DV Factor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.20 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DVFactorGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.DvLeasedUnitINGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Wangyu kim
 * @see Ees_mnr_0107EventResponse 참조
 * @since J2EE 1.4
 */

public interface DVFactorMgtBC {
	/**
	 * [EES_MNR_0107]DV Factor의 정보를 조회 합니다. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @return DVFactorGRPVO
	 * @exception EventException
	 */

	public DVFactorGRPVO searchDVFactorListBasic(DVFactorGRPVO dVFactorGRPVO) throws EventException;
	/**
	 * [EES_MNR_0107]DV Factor의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DVFactorGRPVO dVFactorGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDVFactorBasic(DVFactorGRPVO dVFactorGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0249] DV Leased Unit의 정보를 조회 합니다. <br>
	 *
	 * @param DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO
	 * @return DvLeasedUnitINGRPVO
	 * @exception EventException
	 */
	public DvLeasedUnitINGRPVO searchDvLeasedUnitListBasic(DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO) throws EventException;
	/**
	 * [EES_MNR_0249] DV Leased Unit의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDvLeasedUnitListBasic(DvLeasedUnitINGRPVO dvLeasedUnitINGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0253] Seal Range Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO
	 * @return ContainerSealNoCreationGRPVO
	 * @exception EventException
	 */
	public ContainerSealNoCreationGRPVO searchSealRangeCreationListBasic(ContainerSealNoCreationGRPVO containerSealNoCreationGRPVO) throws EventException;

	/**
	 * [EES_MNR_0253] Seal Range Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ContainerSealNoCreationVO[] containerSealNoCreationVOs
	 * @param SignOnUserAccount account
	 * @returnList<ContainerSealNoCreationVO>
	 * @exception EventException
	 */
	public List<ContainerSealNoCreationVO> manageSealRangeCreationListBasic(ContainerSealNoCreationVO[] containerSealNoCreationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 카운트(Out of Range) 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return String
	 * @throws EventException
	 */
	 public String searchContainerSealInquiryCount(ContainerSealInquiryVO containerSealInquiryVO) throws EventException;

	/**
	 * [EES_MNR_0254] Container Seal Inquiry 목록 조회<br>
	 *
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @return List<ContainerSealInquiryVO>
	 * @throws EventException
	 */
	 public List<ContainerSealInquiryVO> searchContainerSealInquiryList(ContainerSealInquiryVO containerSealInquiryVO) throws EventException;

	 /**
	 * EES_MNR_0254 : SEARCH<br>
	 * Container Seal List 를 조회합니다. <br>
	 * 
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchBackEndCntrSealListBasic(ContainerSealInquiryVO containerSealInquiryVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_MNR_0254 : COMMAND01<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
	
	/**
	 * EES_MNR_0254 : SEARCH01<br>
	 * Container Seal Count 를 조회합니다. <br>
	 * 
	 * @param ContainerSealInquiryVO containerSealInquiryVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchBackEndCntrSealCountBasic(ContainerSealInquiryVO containerSealInquiryVO, SignOnUserAccount account) throws EventException;
	
}