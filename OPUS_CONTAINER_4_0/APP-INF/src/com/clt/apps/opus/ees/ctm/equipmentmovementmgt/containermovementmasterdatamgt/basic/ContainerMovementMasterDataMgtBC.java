/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtBC.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.CntrMvmtSeqVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;
import com.clt.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * OPUS-Equipmentmovementmgt Business Logic Command Interface<br>

 *
 * @author 
 * @see Ees_ctm_0419EventResponse reference
 * @since J2EE 1.5
 * 2009.4.24
 */
public interface ContainerMovementMasterDataMgtBC {

	/**
	 * EES_CTM_0400
	 * retrieving Movement Status List 
	 *
	 * @param RCtmMvmtStsVO rCtmMvmtStsVO
	 * @return List<RCtmMvmtStsVO>
	 * @exception EventException
	 */
	public List<RCtmMvmtStsVO> searchMVMTStatusList(RCtmMvmtStsVO rCtmMvmtStsVO) throws EventException;

	/**
	 * EES_CTM_0421 : onload
	 * retrieving Restuffing Reason List
	 *
	 * @param CtmMvmtXchRsnVO ctmMvmtXchRsnVO
	 * @return List<CtmMvmtXchRsnVO>
	 * @exception EventException
	 */
	public List<CtmMvmtXchRsnVO> searchReasonList(CtmMvmtXchRsnVO ctmMvmtXchRsnVO) throws EventException;

	/**
	 * retrieving US AMS Location List
	 *
	 * @param UsAmsLocationListVO usLmsLocationListVO
	 * @return List<UsAmsLocationListVO>
	 * @exception EventException
	 */
	public List<UsAmsLocationListVO> searchAmsLocation(UsAmsLocationListVO usLmsLocationListVO) throws EventException;

	/**
	 * updating US AMS Location List
	 *
	 * @param UsAmsLocationListVO[] usLmsLocationListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAmsLocation(UsAmsLocationListVO[] usLmsLocationListVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * updating Restuffing Reason List
	 *
	 * @param CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageReasonList(CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs,SignOnUserAccount account) throws EventException;
	
	/** manageOSCARCtmCycNoList
	 * 
	 * @param SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs
	 * @param String usrId
	 * @throws EventException
	 */
	public void manageOSCARCtmCycNoList(SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs, String usrId) throws EventException;
	
	/** manageVVDList
	 * 
	 * @param SearchAllVVDByBKGVO[] searchAllVVDByBKGVOs
	 * @param String usrId
	 * @throws EventException
	 */
	public void manageVVDList(SearchAllVVDByBKGVO[] searchAllVVDByBKGVOs, String usrId) throws EventException;
	
	/**
	 * EES_CTM_1001 : onload
	 * Retrieving CNTR MVMT Sequence List
	 *
	 * @param CntrMvmtSeqVO cntrMvmtSeqVO
	 * @return List<CntrMvmtSeqVO>
	 * @exception EventException
	 */
	public List<CntrMvmtSeqVO> searchCntrMvmtSeqList(CntrMvmtSeqVO cntrMvmtSeqVO) throws EventException;
	
	/**
	 * Updating CNTR MVMT Sequence<br>
	 *
	 * @param CntrMvmtSeqVO[] cntrMvmtSeqVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCntrMvmtSeqList(CntrMvmtSeqVO[] cntrMvmtSeqVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_CTM_1002 : onload
	 * Retrieving CNTR MVMT Status Decision List
	 *
	 * @param CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO
	 * @return List<CtmMvmtStsDcsnVO>
	 * @exception EventException
	 */
	public List<CtmMvmtStsDcsnVO> searchCtmMvmtStsDcsnList(CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO) throws EventException;
	
	/**
	 * Updating CNTR MVMT Status Decision
	 *
	 * @param CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCtmMvmtStsDcsnList(CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs,SignOnUserAccount account) throws EventException;
	
}