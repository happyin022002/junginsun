/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceBC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.BalDiffAcctVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.GlIfGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoMsaVO;

/**
 * ALPS-Estimateinvoiceaudit Business Logic Command Interface<br>
 * - ALPS-Estimateinvoiceaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jin Ihl
 * @see Vop_pso-0020EventResponse 참조
 * @since J2EE 1.4
 */

public interface CanalTransitFeeBalanceBC {
	/**
	 * VOP_PSO_0020 : WindowsOpen<br/>
	 * Requested MSA의 메인 화면으로 조회 조건으로 들어온 WorkMonth,VendorSeq로 관련 MSA의 정보를 조회한다.<br/>
	 * @param CanalTzFeeBalVO canalTzFeeBalVO
	 * @return List<CanalTzFeeBalVO>
	 * @throws EventException 
	 * @exception EventException
	 */
	public List<CanalTzFeeBalVO> searchCanalTzFeeBalSum(CanalTzFeeBalVO canalTzFeeBalVO) throws EventException;  
	/**
	 * VOP_PSO-0020-1 : Confirm Button Click<br/>
	 * 요청된 MSA에 대한 Confirm 처리를 시행한다.<br/>
	 * @param CanalTzFeeBalVO[] canalTzFeeBalVOs
	 * @param SignOnUserAccount account
	 */
	public void createCanalTzFeeBal(CanalTzFeeBalVO[] canalTzFeeBalVOs, SignOnUserAccount account) throws EventException;
	/**
	 * VOP_PSO-0020-1 Reject Button Click<br>
	 * 요청된 MSA의 취최 처리를 한다.<br>
	 * @param CanalTzFeeBalVO[] canalTzFeeBalVOs
	 * @param SignOnUserAccount account
	 */
	public void removeCanalTzFeeBal(CanalTzFeeBalVO[] canalTzFeeBalVOs,
			SignOnUserAccount account) throws EventException;
	/**
	 * VOP_PSO-0020-2 Details of Remittance Tab Click <br />
	 * Requested MSA의 Remittance 정보를 조회한다.  <br />
	 * @param CanalTzFeeBalDtlVO canalTzFeeBalDtlVO
	 * @return List<CanalTzFeeBalDtlVO>
	 */
	public List<CanalTzFeeBalDtlVO> searchCanalTzFeeBalDtl(CanalTzFeeBalDtlVO canalTzFeeBalDtlVO) throws EventException;
	/**
	 * G/L Data화면에 대한 조회 이벤트 처리<br>
	 * VOP_PSO-0031 조회 처리 
	 * @param  PsoMsaVO psoMsaVO
	 * @return GlIfGRPVO
	 */
	public GlIfGRPVO searchGlifDateByMon(PsoMsaVO psoMsaVO) throws EventException;
	/**
	 * Balance Diff. Account 화면에 대한 조회 이벤트 처리<br>
	 * VOP_PSO-0032 조회 처리 
	 * @param  BalDiffAcctVO balDiffAcctVO
	 * @return BalDiffAcctVO
	 */
	public BalDiffAcctVO searchBalDiffAcct(BalDiffAcctVO balDiffAcctVO) throws EventException;
	
}