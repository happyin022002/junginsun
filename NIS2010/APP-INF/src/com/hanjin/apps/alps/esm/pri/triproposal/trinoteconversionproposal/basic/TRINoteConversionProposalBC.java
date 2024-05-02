/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalBC.java
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTriNoteConvVO;
import com.hanjin.syscommon.common.table.PriTriNoteVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * ALPS-Triproposal Business Logic Command Interface<br>
 * - ALPS-Triproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @since J2EE 1.6
 */

public interface TRINoteConversionProposalBC {
	
	/**
	 * Tariff Fomula Rule 화면에서 Duration 리스트를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return List<PriTriNoteVO>
	 * @exception EventException
	 */
	public List<PriTriNoteVO> searchTRIFomulaRuleInfo(PriTriNoteVO priTriNoteVO) throws EventException;
	
	/**
	 * TRI Note 정보를 조회한다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;
	
	/**
	 * 복사된 TRI NOTE CONVERSION 데이터를 조회합니다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionCopyList(PriTriNoteConvVO priTriNoteConvVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * TRI Note Conversion 정보를 저장합니다.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * TRI Note Conversion 정보를 복사합니다.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * SERVICE SCOPE CODE를 조회한다. <br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;
	
	/**
	 * Tariff Fomula Rule 정보를 저장합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Tariff Fomula Rule 정보를 Confirmation 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff Fomula Rule 정보를 Confirm Cancel 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;

	/**
	 * Tariff Fomula Rule 정보를 Delete 합니다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception EventException
	 */
	public void deleteTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws EventException;
				
	/**
	 * TRI Proposal 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRI Proposal 데이터를 Amend한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRI Proposal 데이터를 Cancel한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 다건의 TRI Proposal 데이터를 Cancel한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 다건의 TRI Proposal 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * GRI Calculation을 적용합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SCOPE 별 사용자 승인권한 유무를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthScopeCount(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * Tariff Code 에 해당하는 Service Scope 별 RULE CODE, CHARGE CODE를 조회한다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRuleChargeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;

	
}