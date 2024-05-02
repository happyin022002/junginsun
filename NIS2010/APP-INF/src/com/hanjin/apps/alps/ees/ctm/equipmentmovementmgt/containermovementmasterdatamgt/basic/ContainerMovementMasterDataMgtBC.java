/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtBC.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.04.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * ALPS-Equipmentmovementmgt Business Logic Command Interface<br>
 * - ALPS-Equipmentmovementmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 우경민
 * @see Ees_ctm_0419EventResponse 참조
 * @since J2EE 1.5
 * 2009.4.24
 */
public interface ContainerMovementMasterDataMgtBC {

	/**
	 * EES_CTM_0400<br>
	 * Movement Status List 조회<br>
	 *
	 * @param RCtmMvmtStsVO rCtmMvmtStsVO
	 * @return List<RCtmMvmtStsVO>
	 * @exception EventException
	 */
	public List<RCtmMvmtStsVO> searchMVMTStatusList(RCtmMvmtStsVO rCtmMvmtStsVO) throws EventException;

	/**
	 * EES_CTM_0421 : onload<br>
	 * Restuffing Reason 리스트 조회<br>
	 *
	 * @param CtmMvmtXchRsnVO ctmMvmtXchRsnVO
	 * @return List<CtmMvmtXchRsnVO>
	 * @exception EventException
	 */
	public List<CtmMvmtXchRsnVO> searchReasonList(CtmMvmtXchRsnVO ctmMvmtXchRsnVO) throws EventException;

	/**
	 * US AMS Location의 List를 조회<br>
	 * 
	 * @param UsAmsLocationListVO usLmsLocationListVO
	 * @return List<UsAmsLocationListVO>
	 * @exception EventException
	 */
	public List<UsAmsLocationListVO> searchAmsLocation(UsAmsLocationListVO usLmsLocationListVO) throws EventException;
	
	/**
	 * US AMS Location List를 Update한다.<br>
	 * 
	 * @param UsAmsLocationListVO[] usLmsLocationListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAmsLocation(UsAmsLocationListVO[] usLmsLocationListVOs,SignOnUserAccount account) throws EventException;

}