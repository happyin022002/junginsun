/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineBC.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcRateActualCustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.ScGriCalcVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCGRICalculationProposalBC {
	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception EventException
	 */
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriSpScpGriGrpVO vo) throws EventException;

	/**
	 * GRI Calculation 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return RsltGriCalcListVO
	 * @exception EventException
	 */
	public RsltGriCalcListVO searchGRICalculationList(PriSpScpGriGrpVO vo) throws EventException;

	/**
	 * GRI Calculation 데이터의 CUD 트랜잭션을 처리합니다.<br>
	 * 
	 * @param ScGriCalcVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGRICalculation(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException;

	/************************************** ESM_PRI_0109 Start *******************************************/
	/**
	 * GRI Calculation - Arbitrary 화면에서 콤보 필터를 위해 전체 콤보 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgCombo1VO vo
	 * @return List<PriSpScpTrspAddChgCombo1VO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgCombo1VO> searchPriSpScpTrspAddChgCombo1VOs(PriSpScpTrspAddChgCombo1VO vo)
			throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI(상단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLListVO> searchPriSpScpTrspAddChgGriArbOKCLList(
			PriSpScpTrspAddChgGriArbOKCLListVO vo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI 옵션(하단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLSubListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLSubListVO> searchPriSpScpTrspAddChgGriArbOKCLSubList(
			PriSpScpTrspAddChgGriArbOKCLSubListVO vo) throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 적용할 모든 GRI 와 옵션을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLAllListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLAllListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLAllListVO> searchPriSpScpTrspAddChgGriArbOKCLAllList(
			PriSpScpTrspAddChgGriArbOKCLAllListVO vo) throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 모든 Arbitrary 항목을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(
			PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo) throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 항목을 저장한다. <br>
	 * 
	 * @param PriSpScpArbGriGrpVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriGrpVOS(PriSpScpArbGriGrpVO[] pVO, SignOnUserAccount account) throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목을 저장한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpArbGriRtVOS(PriSpScpTrspAddChgGriArbOKCLSubListVO[] pVO, SignOnUserAccount account)
			throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO,
			SignOnUserAccount account) throws EventException;

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriSpScpTrspAddChgGriArbOKCLCancleListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO,
			SignOnUserAccount account) throws EventException;

	/************************************** ESM_PRI_0109 End *******************************************/

	/**
	 * Init Cancel시 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

    /**
     * GRI Calculation Apply Flag 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRIApplyFlag(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException ;
    
    /**
     * GRI Calculation - Actual Customer List을 조회한다. <br>
     * 
     * @param PriSpScpRtActCustVO vo
     * @return List<RsltGriCalcRateActualCustListVO>
     * @exception EventException
     */
    public List<RsltGriCalcRateActualCustListVO> searchGriCalcRateActualCustList(PriSpScpRtActCustVO vo) throws EventException  ;
    /**
     * GRI Calculation 데이터의 COPY 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRICopy(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException;
    
    /**
     * GRI Calculation 데이터의 REMOVE 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeGRICopy(ScGriCalcVO pVo, SignOnUserAccount account) throws EventException ; 
 
    /**
     * GRI Calculation 데이터의 PASTE 트랜잭션을 처리합니다.<br>
     * 
     * @param PriSpScpGriGrpVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageGRIPaste(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException;
    
    /**
     * GRI Calculation 데이터의 REMOVE 트랜잭션을 처리합니다.<br>
     * 
     * @param ScGriCalcVO pVo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void removeGRIAll(PriSpScpGriGrpVO pVo, SignOnUserAccount account) throws EventException;
}