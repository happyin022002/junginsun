/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOBunkerRegisterBC.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.framework.core.layer.event.EventException;
 
/**
 * ALPS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - ALPS-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon-Tae, Jung
 * @see Esm_Fms_0050EventResponse 참조
 * @since J2EE 1.5
 */

public interface TCharterIOBunkerRegisterBC {
	
	/**
	 * Bunker 정보를 가져온다
	 * 
	 * @param searchBunkerVO SearchBunkerVO
	 * @return List<SearchBunkerVO>
	 * @exception EventException
	 */
	public List<SearchBunkerVO> searchBunkerList(SearchBunkerVO searchBunkerVO) throws EventException;
	
	/**
	 * Bunker 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customBunkerVOs CustomBunkerVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageBunker(CustomBunkerVO[] customBunkerVOs, String usrId) throws EventException;
	
	/**
	 * 계약번호에 해당하는 vslCd 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchIdVslCdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchIdVslCdByBunkerVO> searchIdVslCdListByBunker(String fletCtrtNo) throws EventException;
	
	/**
	 * vslCd와 bnkDt에 해당하는 항차 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param bunkerDt String
	 * @return List<SearchVvdByBunkerVO>
	 * @exception EventException
	 */
	public List<SearchVvdByBunkerVO> searchVvdListByBunker(String vslCd, String bunkerDt) throws EventException;
	
	/**
	 * Location Code 가져오기<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @exception EventException
	 */
	public String checkLocCdByBunker(String locCd) throws EventException;
	
	/**
	 * Bunker 테이블에서 계약 테이블에 업데이트 할 정보가져오기<br>
	 * 
	 * @param fletCtrtNo String 
	 * @param bnkYrmon String 
	 * @return List<ContractByBunkerVO>
	 * @exception EventException
	 */
	public List<ContractByBunkerVO> searchContractByBunker(String fletCtrtNo, String bnkYrmon) throws EventException;
	
	/**
	 * Bunker 테이블에서 Interface 할 정보가져오기<br>
	 * 
	 * @param bnkYrmon String 
	 * @return List<SearchBunkerInterfaceVO>
	 * @exception EventException
	 */
	public List<SearchBunkerInterfaceVO> searchBunkerInterfaceList(String bnkYrmon) throws EventException;
	
	/**
	 * BOD, BOR Monthly Interface 화면에서 EAI 데이타 전송<br>
	 * 
	 * @param bnkYrmon String
	 * @param usrId String 
	 * @exception EventException
	 */
	public void sendBunkerData(String bnkYrmon, String usrId) throws EventException;
	
	/**
	 * 기 작성된 BOD / BOR Data / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param ofcCd String
	 * @param csrCurrCd String
	 * @param aproFlg String
	 * @return List<SearchBunkerListByPaymentSlipVO>
	 * @exception EventException
	 */
	public List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd, String aproFlg) throws EventException;
	
	/**
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다<br>
	 * 
	 * @param customPamConsultationVOs CustomPamConsultationVO[]
	 * @param customPamCsulSlpVOs CustomPamCsulSlpVO[]
	 * @param slpSerNo String
	 * @exception EventException
	 */
	public void modifyPaymentSlipBunkers(CustomPamConsultationVO[] customPamConsultationVOs, CustomPamCsulSlpVO[] customPamCsulSlpVOs, String slpSerNo) throws EventException;

	/**
	 * 용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifySlipApprovalCancelBunker(String csrNo, String usrId) throws EventException;
	
	/**
	 * 대선 전표가 생성되면 정산 테이블에 관련 항목들에 대해서 수정한다<br>
	 * 
	 * @param customCsulSlpVOs CustomCsulSlpVO[]
	 * @exception EventException
	 */
	public void modifySubletRevenueSlip(CustomCsulSlpVO[] customCsulSlpVOs) throws EventException;
	
	/**
	 * AP, AR 대선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyApArSlipApprovalCancelBunker(String csrNo, String usrId) throws EventException;
	
	
}