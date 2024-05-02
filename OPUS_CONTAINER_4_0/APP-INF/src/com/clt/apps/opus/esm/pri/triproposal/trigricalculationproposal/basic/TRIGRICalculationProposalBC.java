/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIGRICalculationProposalBC.java
 *@FileTitle : TRI GRI Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.TriGriCalcVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTriGriGrpVO;

/**
 * TRIGRICalculationProposal Business Logic Command Interface<br>
 * - interface about TRIGRICalculationProposal biz logic<br>
 * 
 * @author 
 * @see Ui_pri_3010EventResponse 
 * @since J2EE 1.4
 */

public interface TRIGRICalculationProposalBC {
	/**
	 * Retrieving GRI Calculation Header list <br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriTriGriGrpVO vo) throws EventException;

	/**
	 * Retrieving GRI Calculation list<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriTriGriGrpVO vo) throws EventException;

	/**
	 * Handling GRI Calculation CUD transaction<br>
	 * 
	 * @param TriGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(TriGriCalcVO pVo, SignOnUserAccount account) throws EventException;

}