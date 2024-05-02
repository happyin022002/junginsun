/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineBC.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpGriGrpVO;

/**
 * Scguideline Business Logic Command Interface<br>
 * - interface about Scguideline biz logic<br>
 * 
 * @author 
 * @see Ui_pri_0030EventResponse 
 * @since J2EE 1.4
 */

public interface SCGRICalculationProposalBC {
	/**
	 * retrieving GRI Calculation Header list<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriSpScpGriGrpVO vo) throws EventException;

	/**
	 * retrieving GRI Calculation list<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriSpScpGriGrpVO vo) throws EventException;

	/**
	 * handling GRI Calculation data CUD transaction<br>
	 * 
	 * @param ScGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException;

	/************************************** ESM_PRI_0109 Start *******************************************/
	/**
	 * GRI Calculation - retrieving all combo data for combo filter on Arbitrary screen<br>
	 * 
	 * @param PriSpScpTrspAddChgCombo1VO vo
	 * @return List<PriSpScpTrspAddChgCombo1VO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgCombo1VO> searchPriSpScpTrspAddChgCombo1VOs(PriSpScpTrspAddChgCombo1VO vo)
			throws EventException;

	/**
	 * GRI Calculation - retrieving apply GRI(upper grid) on Arbitrary screen<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLListVO> searchPriSpScpTrspAddChgGriArbOKCLList(
			PriSpScpTrspAddChgGriArbOKCLListVO vo) throws EventException;

	/**
	 * handling retrieving event<br>
	 * GRI Calculation - retrieving apply GRI(lower grid) on Arbitrary screen<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLSubListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLSubListVO> searchPriSpScpTrspAddChgGriArbOKCLSubList(
			PriSpScpTrspAddChgGriArbOKCLSubListVO vo) throws EventException;

	/**
	 * GRI Calculation - retrieving ALL GRI and option on Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLAllListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLAllListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLAllListVO> searchPriSpScpTrspAddChgGriArbOKCLAllList(
			PriSpScpTrspAddChgGriArbOKCLAllListVO vo) throws EventException;

	/**
	 * GRI Calculation - retrieving ALL Arbitrary item for applying GRI on Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(
			PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo) throws EventException;

	/**
	 * GRI Calculation - saving GRI item on Arbitrary screen <br>
	 * 
	 * @param PriSpScpArbGriGrpVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriGrpVOS(PriSpScpArbGriGrpVO[] pVO, SignOnUserAccount account) throws EventException;

	/**
	 * GRI Calculation - saving GRI option item on Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriRtVOS(PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * GRI Calculation - applying GRI on Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO,
			SignOnUserAccount account) throws EventException;

	/**
	 * GRI Calculation - GRI appying cancel on Arbitrary screen<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLCancleListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO,
			SignOnUserAccount account) throws EventException;

	/************************************** ESM_PRI_0109 End *******************************************/

	/**
	 * when init cancel, deleting all data<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

}