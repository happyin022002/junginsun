/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGRICalculationProposalBC.java
 *@FileTitle : RFAGRICalculationProposalBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RfaGriCalcVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;

/**
 * Rfaguideline Business Logic Command Interface<br>
 * - Handling a biz logic about Rfaguideline<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse
 * @since J2EE 1.4
 */

public interface RFAGRICalculationProposalBC {
	/**
	 * Retrieving GRI Calculation Header list<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws EventException;

	/**
	 * Retrieving GRI Calculation list.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriRpScpGriGrpVO priRpScpGriGrpVO) throws EventException;

	/**
	 * Handling CUD transaction of GRI Calculation data<br>
	 * 
	 * @param RfaGriCalcVO rfaGriCalcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(RfaGriCalcVO rfaGriCalcVO, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting all data with related amend seq no when canceling init status of main<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

}