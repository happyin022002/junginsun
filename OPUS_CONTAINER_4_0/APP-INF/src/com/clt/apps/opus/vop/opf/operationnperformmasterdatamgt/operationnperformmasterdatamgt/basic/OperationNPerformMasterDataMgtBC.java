/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtBC.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.OpfStvDmgCdVO;
import com.clt.syscommon.common.table.OpfTmlProdRptRsnCdVO;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * OPUS-Operationnperformmasterdatamgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_opf_0048EventResponse 
 * @since J2EE 1.4
 */

public interface OperationNPerformMasterDataMgtBC {

	/**
	 * Retrieve [VOP_OPF_0048 StevedoreDamagePartCodeList]<br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception EventException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamagePartCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException;
	
	/**
	 * Manage [VOP_OPF_0048 StevedoreDamagePartCode]<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageStevedoreDamagePartCode(OpfStvDmgCdVO[] opfStvDmgCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve [VOP_OPF_0049 StevedoreDamageReasonCodeList]<br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception EventException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamageReasonCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException;

	/**
	 * Manage [VOP_OPF_0049 StevedoreDamageReasonCode]<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageStevedoreDamageReasonCode(OpfStvDmgCdVO[] opfStvDmgCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve [VOP_OPF_0087 ExcludeTPRReasonCodeList]<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception EventException
	 */	
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTPRReasonCodeList(OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO) throws EventException;
	
	/**
	 * Manage [VOP_OPF_0087 ExcludeTPRReasonCode]<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageExcludeTPRReasonCode(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve Restow Reason Code. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfRstwgRsnCdVO> searchRestowReasonCodeList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException;
	/**
	 * Save Restow Reason Code<br>
	 * 
	 * @param OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void mamageRestowReasonCode(OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs,SignOnUserAccount account) throws EventException;
	/**
	 * Retrieve COD Reject Reason Code. <br>
	 * 
	 * @param opfCodRjctCdVO   OpfCodRjctCdVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception DAOException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectReasonCodeList(OpfCodRjctCdVO opfCodRjctCdVO) throws EventException;
	/**
	 * Save COD Reject Reason Code <br>
	 * 
	 * @param opfCodRjctCdVOs OpfCodRjctCdVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void manageCODRejectReasonCode(OpfCodRjctCdVO[] opfCodRjctCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Pre Checking Report  <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchAllPortList(MdmLocationVO mdmLocationVO) throws EventException;
	
	/**
	 * Retrieve TPR Target Port Creation . <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchTPRTargetPortList(MdmLocationVO mdmLocationVO) throws EventException;
	
	/**
	 * Retrieve RHQ list. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchRHQOfficeList(MdmLocationVO mdmLocationVO) throws EventException;
	
	/**
	 * Save TTPR Target Port Creation .<br>
	 * 
	 * @param MdmLocationVO[] mdmLocationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetPort(MdmLocationVO[] mdmLocationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieve TPR Target Lane Creation . <br>
	 * 
	 * @param MdmVslSvcLaneVO   mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchTPRTargetLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Save TPR Target Lane Creation <br>
	 * 
	 * @param MdmVslSvcLaneVO[] mdmVslSvcLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetLaneList(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * COD Diversion Fee Code search <br>
	 * 
	 * @param OpfCodDvsFeeVO opfCodDvsFeeVO
	 * @return List<OpfCodDvsFeeVO>
	 * @exception DAOException
	 */
	public List<OpfCodDvsFeeVO> searchCODDiversionCodeList(OpfCodDvsFeeVO opfCodDvsFeeVO) throws EventException;
	
	/**
	 * Conti Cd  Enable or disable search <br>
	 * 
	 * @param OpfCodDvsFeeVO opfCodDvsFeeVO
	 * @return List<OpfCodDvsFeeVO>
	 * @exception DAOException
	 */
	public String searchContiCdUseYn(OpfCodDvsFeeVO opfCodDvsFeeVO) throws EventException;
	
	/**
	 * COD Diversion Fee Cdoe save <br>
	 * 
	 * @param opfCodDvsFeeVOs OpfCodDvsFeeVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void manageCODDiversionCode(OpfCodDvsFeeVO[] opfCodDvsFeeVOs,SignOnUserAccount account) throws EventException;

}