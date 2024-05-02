/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtBC.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.12 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * NIS2010-Operationnperformmasterdatamgt Business Logic Command Interface<br>
 * - NIS2010-Operationnperformmasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ji Seok Woo
 * @see Vop_opf_0048EventResponse 참조
 * @since J2EE 1.4
 */

public interface OperationNPerformMasterDataMgtBC {

	/**
	 * [VOP_OPF_0048 StevedoreDamagePartCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception EventException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamagePartCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException;
	
	/**
	 * [VOP_OPF_0048 StevedoreDamagePartCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageStevedoreDamagePartCode(OpfStvDmgCdVO[] opfStvDmgCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * [VOP_OPF_0049 StevedoreDamageReasonCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception EventException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamageReasonCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException;

	/**
	 * [VOP_OPF_0049 StevedoreDamageReasonCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageStevedoreDamageReasonCode(OpfStvDmgCdVO[] opfStvDmgCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * [VOP_OPF_0087 ExcludeTPRReasonCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception EventException
	 */	
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTPRReasonCodeList(OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO) throws EventException;
	
	/**
	 * [VOP_OPF_0087 ExcludeTPRReasonCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageExcludeTPRReasonCode(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Restow Reason Code을 조회 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception EventException
	 */
	public List<OpfRstwgRsnCdVO> searchRestowReasonCodeList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException;
	/**
	 * Restow Reason Code을 저장 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void mamageRestowReasonCode(OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs,SignOnUserAccount account) throws EventException;
	/**
	 * COD Reject Reason Code을 조회 합니다. <br>
	 * 
	 * @param opfCodRjctCdVO   OpfCodRjctCdVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception DAOException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectReasonCodeList(OpfCodRjctCdVO opfCodRjctCdVO) throws EventException;
	/**
	 * COD Reject Reason Code을 저장 합니다. <br>
	 * 
	 * @param opfCodRjctCdVOs OpfCodRjctCdVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void manageCODRejectReasonCode(OpfCodRjctCdVO[] opfCodRjctCdVOs,SignOnUserAccount account) throws EventException;

	/**
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchAllPortList(MdmLocationVO mdmLocationVO) throws EventException;
	
	/**
	 * TPR Target Port Creation 를 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchTPRTargetPortList(MdmLocationVO mdmLocationVO) throws EventException;
	
	/**
	 * TTPR Target Port Creation 을 저장 합니다.<br>
	 * 
	 * @param MdmLocationVO[] mdmLocationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetPort(MdmLocationVO[] mdmLocationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * TPR Target Lane Creation 를 조회 합니다. <br>
	 * 
	 * @param MdmVslSvcLaneVO   mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchTPRTargetLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * TPR Target Lane Creation 을 저장 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO[] mdmVslSvcLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetLaneList(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs,SignOnUserAccount account) throws EventException;	
}