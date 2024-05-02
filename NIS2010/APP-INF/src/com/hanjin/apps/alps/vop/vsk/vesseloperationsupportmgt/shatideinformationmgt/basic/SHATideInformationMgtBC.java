/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SHATideInformationMgtBC.java
*@FileTitle : SHA Tide Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.06 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.SHATideInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.shatideinformationmgt.vo.VskPortTideVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.VskPortTideVO;

/**
 * NIS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - NIS2010-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_vsk_0013EventResponse 참조
 * @since J2EE 1.6
 */

public interface SHATideInformationMgtBC {
	/**
	 * SHA Tide Information Creation 을 조회 합니다.<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return List<VskPortTideVO> 
	 * @exception EventException
	 */
	public List<VskPortTideVO> searchTideInfoList(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException;
	/**
	 * SHA Tide Information Creation 을 저장 합니다.<br>
	 * 
	 * @param VskPortTideVO[] vskPortTideVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTideInfo(VskPortTideVO[] vskPortTideVOs,SignOnUserAccount account) throws EventException;
	/**
	 * Port Code 유효성(체크) 을 조회 합니다.<br>
	 * 
	 * @param SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO
	 * @return VskPortTideVO
	 * @exception EventException
	 */
	public VskPortTideVO searchPortCode(SHATideInformationMgtConditionVO sHATideInformationMgtConditionVO) throws EventException;
}