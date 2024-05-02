/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalBC.java
*@FileTitle : Tariff Formula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTriNoteConvVO;
import com.clt.syscommon.common.table.PriTriNoteVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * Triproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Triproposal<br>
 *
 * @author SHKIM
 * @see EsmPri3005EventResponse
 * @since J2EE 1.6
 */
public interface TRINoteConversionProposalBC {
	
	/**
	 * Retrieving Duration list on Tariff Fomula Rule screen<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return List<PriTriNoteVO>
	 * @exception EventException
	 */
	public List<PriTriNoteVO> searchTRIFomulaRuleInfo(PriTriNoteVO priTriNoteVO) throws EventException;
	
	/**
	 * Retrieving TRI Note information.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;
	
	/**
	 * Retrieving copied TRI NOTE CONVERSION .<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionCopyList(PriTriNoteConvVO priTriNoteConvVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Saving TRI Note Conversion information<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Copying TRI Note Conversion information.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving SERVICE SCOPE CODE<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;
	
	/**
	 * Saving Tariff Fomula Rule information<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Confirming Tariff Fomula Rule information<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;

	/**
	 * Canceling Confirmmation of Tariff Fomula Rule information  <br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;

	/**
	 * Deleting Tariff Fomula Rule information.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception EventException
	 */
	public void deleteTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws EventException;
	
	
	/**
	 * Handling multi transaction of TRI Proposal , Rate data<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Amending TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling several TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Publishing TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Publishing several TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Applying GRI Calculation<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Canceling applied GRI Calculation<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving checking whether user have authority for approval by scope<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthScopeCount(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * Retrieving rule Code,Charge Code by service scope for Tariff Code<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRuleChargeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException;
	
}