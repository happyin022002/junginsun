/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGRICalculationProposalBC.java
 *@FileTitle : RFAGRICalculationProposalBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;

/**
 * NIS2010-Rfaguideline Business Logic Command Interface<br>
 * - NIS2010-Rfaguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFAGRICalculationProposalBC {
	/**
	 * GRI Calculation Header 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws EventException;

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriRpScpGriGrpVO priRpScpGriGrpVO) throws EventException;

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param RfaGriCalcVO rfaGriCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(RfaGriCalcVO rfaGriCalcVO, SignOnUserAccount account) throws EventException;

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param RfaGriCalcVO rfaGriCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculationForIHC(RfaGriCalcVO rfaGriCalcVO, SignOnUserAccount account) throws EventException;	

}