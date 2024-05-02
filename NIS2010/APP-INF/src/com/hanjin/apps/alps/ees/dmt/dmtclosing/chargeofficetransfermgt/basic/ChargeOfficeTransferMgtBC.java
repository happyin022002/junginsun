/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtBC.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;

/**
 * ALPS-Dmtclosing Business Logic Command Interface<br>
 * - ALPS-Dmtclosing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang HyoKeun
 * @see Ees_dmt_3009EventResponse 참조
 * @since J2EE 1.6
 */

public interface ChargeOfficeTransferMgtBC {

	/**
	 * Office Transfer 내역을 Office/날짜별로 조회한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<DmtOfcTrnsHisVO>
	 * @exception EventException
	 */
	public List<DmtOfcTrnsHisVO> searchOfficeTransferHistoryList(OfficeTransferParmVO officeTransferParmVO) throws EventException;

	
	/**
	 * Charge를 Office Transfer되도록 Charge의 Office Data를 수정한다.
	 * Office Transfer 할 Charge의 Status가 "F"(Finish), "L"(Long Staying) 상태이다.
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] createOfficeTransferCharge(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Container별 Office Transfer History 정보를 조회한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<OfficeTransferHistoryByContainerVO>
	 * @exception EventException
	 */
	public List<OfficeTransferHistoryByContainerVO> searchOfficeTransferHistoryListByContainer(OfficeTransferParmVO officeTransferParmVO) 
		throws EventException;
	
	
	/**
	 * Office Transfer된 Charge를 Partial 하는 경우, 새로 생성되는 Charge의 Office Transfer Flag는 "Y"가 되며,
	 * Office Transfer History도 생성되도록 한다.
	 * 
	 * @param	ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param	SignOnUserAccount account
	 * @return	DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createOfficeTransferHistoryByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;

}