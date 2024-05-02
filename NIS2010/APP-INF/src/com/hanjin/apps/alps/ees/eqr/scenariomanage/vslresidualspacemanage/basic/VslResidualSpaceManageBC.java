/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslResidualSpaceManageBC.java
*@FileTitle : VslResidualSpaceManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.06 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0060ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchBSPortInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.SearchVslRsdlSpaceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrBsaPortVO;
import com.hanjin.syscommon.common.table.EqrScnrBsaVvdVO;
import com.hanjin.syscommon.common.table.EqrScnrVslRsdlCapaVO;

/**
 * ALPS-Scenariomanage Business Logic Command Interface<br>
 * - ALPS-Scenariomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0060EventResponse 참조
 * @since J2EE 1.6
 */

public interface VslResidualSpaceManageBC {

  /**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_014 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr0014ConditionVO
	 * @return List<SearchBSInfoVO>
	 * @exception EventException
	 */
	public List<SearchBSInfoVO> searchBSInfo(EesEqr0014ConditionVO condiVO) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_014 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr0014ConditionVO
	 * @return EventResponse EES_EQR_014EventResponse
	 * @exception EventException
	 */
	public List<SearchBSPortInfoVO> searchBSPortInfo(EesEqr0014ConditionVO condiVO) throws EventException;
	
	
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_014 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrBsaVvdVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyBSAInfo(EqrScnrBsaVvdVO[] vos , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_014 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrBsaVvdVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
    public void modifyBSAPortInfo(EqrScnrBsaPortVO[] vos , SignOnUserAccount account)throws EventException;

	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Search ]<br>
	 * 
	 * @param EesEqr0060ConditionVO	eesEqr0060ConditionVO
	 * @return List<SearchVslRsdlSpaceVO>
	 * @exception EventException
	 */
	public List<SearchVslRsdlSpaceVO> searchVslResidualSpaceManage(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException;

	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Lane 체크해서 VVD 가져오기]<br>
	 * 
	 * @param EesEqr0060ConditionVO	eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceLaneInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException;

	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - 해당 VVD Click시 VVD SPC 값 체크해서 보여주기.]<br>
	 * 
	 * @param EesEqr0060ConditionVO	eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceVvdInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException;

	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Ecc 체크.]<br>
	 * 
	 * @param EesEqr0060ConditionVO	eesEqr0060ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchVslResidualSpaceEccInfo(EesEqr0060ConditionVO eesEqr0060ConditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0060 : Vessel R.Capa. - Insert, Update, Delete ]<br>
	 * 
	 * @param EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyVslResidualSpaceManage(EqrScnrVslRsdlCapaVO[] eqrScnrVslRsdlCapaVOs,SignOnUserAccount account) throws EventException;
}