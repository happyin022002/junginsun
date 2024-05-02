/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtBC.java
*@FileTitle : Lane/Port Expense Ratio Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.27 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Portchargebudget Business Logic Command Interface<br>
 * - ALPS-Portchargebudget에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author myoungjong park
 * @see Vso_pso_0006EventResponse 참조
 * @since J2EE 1.6
 */

public interface LaneExpenseRatioMgtBC {

	/**
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * @return List<SvcLaneVO>
	 * @throws EventException 
	 */
	public List<SvcLaneVO> searchLaneExpenseRatioKeyValue() throws EventException;

	/**PSO PORT EXPENSE DIVISION 테이블 Select<br>
	 * @param vslSlanCd
	 * @return List<ServiceLaneListVO>
	 */
	public List<ServiceLaneListVO> searchPsoPortExpenseDivision(String vslSlanCd) throws EventException;

	/**입력 받은 Lane Code로 생성된 Standard P/F SKD Detail 정보를 조회한다.<br>
	 * @param vslSlanCd
	 * @return List<ServiceLaneListVO>
	 */
	public List<ServiceLaneListVO> searchPfSkdDetail(String vslSlanCd) throws EventException;

	/**입력받은 Service Lane Code에 Standard P/F Type Code와 펜드럼 서비스 구분자를 조회한다.<br>
	 * @param vslSlanCd
	 * @return List<SvcLaneVO>
	 */
	public List<SvcLaneVO> searchPfLaneTypeList(String vslSlanCd) throws EventException;

	/**Lane/Port Expense Ratio Creation 저장
	 * @param svcLaneVO
	 * @param serviceLaneListVO
	 * @param account
	 */
	public void manageLaneExpnRto(SvcLaneVO[] svcLaneVO, ServiceLaneListVO[] serviceLaneListVO, SignOnUserAccount account) throws EventException;
}