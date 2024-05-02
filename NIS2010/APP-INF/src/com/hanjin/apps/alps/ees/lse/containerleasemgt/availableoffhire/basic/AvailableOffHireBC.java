/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AvailableOffHireBC.java
*@FileTitle : Available Off Hire Q'ty
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.22 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.EmailSendInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.SearchParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public interface AvailableOffHireBC {

	/**
	 * 지역별 반납가능 대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireSummaryVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireSummaryVO> searchAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 지역별 반납가능 대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerSummaryBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 선택된 반납가능 대상 장비의 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireDetailVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireDetailVO> searchAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 선택된 반납가능 대상 장비의 내역을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerDetailBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 선택된 반납가능 대상 장비에 대한 내역을 메일로 발송합니다.<br>
	 *
	 * @param EmailSendInfoVO emailSendInfoVO
	 * @param AvailableOffHireDetailVO[] availableOffHireDetailVOs
	 * @param userAccount SignOnUserAccount
	 * @exception EventException
	 */
    public void sendToEmailAvailableOffHireContainerBasic(EmailSendInfoVO emailSendInfoVO, AvailableOffHireDetailVO[] availableOffHireDetailVOs, SignOnUserAccount userAccount) throws EventException;

    /**
	 * 지역별 지정된 반납대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireConfirmVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireConfirmVO> searchAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 지역별 지정된 반납대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndAvailableOffHireContainerConfirmBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 선정된 대상장비의 내역을 반납확정 자료로 일괄갱신합니다.<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerConfirmBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 선정된 대상장비의 반납상태 정보를 갱신합니다.<br>
	 *
	 * @param AvailableOffHireConfirmVO[] availableOffHireConfirmVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void modifyAvailableOffHireContainerStatusBasic(AvailableOffHireConfirmVO[] availableOffHireConfirmVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * AvailableOffHire Yard 코드 목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<AvailableOffHireYardCodeVO>
	 * @throws EventException
	 */
	public List<AvailableOffHireYardCodeVO> searchAvailableOffHireYardCodeListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;

	/**
	 * AvailableOffHire Container 목록을 조회합니다.<br>
	 *
	 * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
	 * @return List<AvailableOffHireContainerListVO.java>
	 * @throws EventException
	 */
	public List<AvailableOffHireContainerListVO> searchAvailableOffHireContainerListBasic(AvailableOffHireContainerListVO availableOffHireContainerListVO) throws EventException;
	
	
	/**
	 * off hire 현황을 요청합니다.<br>
	 *
	 * @param  AvailableOffHireContainerListVO availableOffHireContainerListVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndSearchAvailableOffHireContainerListService(AvailableOffHireContainerListVO availableOffHireContainerListVO, SignOnUserAccount userAccount) throws EventException;

}
