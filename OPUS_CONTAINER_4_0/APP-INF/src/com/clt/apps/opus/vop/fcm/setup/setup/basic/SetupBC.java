/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SetupBC.java
*@FileTitle : SetupBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.04 진마리아
* 1.0 Creation
* 
* History
* 2012.04.23 진마리아 CHM-201217192-01 Vessel Registration 선박 추가 로직 변경 요청건
=========================================================*/
package com.clt.apps.opus.vop.fcm.setup.setup.basic;

import java.util.List;

import com.clt.apps.opus.vop.fcm.setup.setup.vo.FcmVslCntrRgstVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Setup Business Logic Command Interface<br>
 * - ALPS-Setup에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Ryu Hyuk
 * @see BudgetPlanEventResponse 참조
 * @since J2EE 1.6
 */
public interface SetupBC {
	
	/**
	 * Vessel Registration 정보를 생성합니다.
	 * 
	 * @param FcmVslCntrRgstVO fcmVslCntrRgstVO
	 * @return List<FcmVslCntrRgstVO>
	 * @exception EventException
	 */
	public List<FcmVslCntrRgstVO> searchFcmVslCntrRgst(FcmVslCntrRgstVO fcmVslCntrRgstVO) throws EventException;
	
	/**
	 * Vessel Registration 정보를 변경합니다.
	 * 
	 * @param FcmVslCntrRgstVO[] fcmVslCntrRgstVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFcmVslCntrRgst(FcmVslCntrRgstVO[] fcmVslCntrRgstVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Vessel Registration 정보를 삭제합니다.
	 * 
	 * @param FcmVslCntrRgstVO[] fcmVslCntrRgstVOs
	 * @exception EventException
	 */
	public void removeFcmVslCntrRgst(FcmVslCntrRgstVO[] fcmVslCntrRgstVOs) throws EventException;
	
	/**
	 * Vessel Registration에 기등록된 Vsl인지 check합니다.
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVslCntrRgstExist(String vslCd) throws EventException;
	
	/**
	 * MDM의 Vessel 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return FcmVslCntrRgstVO
	 * @exception EventException
	 */
	public FcmVslCntrRgstVO searchMdmVslCntrRgstList(String vslCd) throws EventException;
	
	/**
	 * Search FMS vessel info.
	 * 
	 * @param vslCd
	 * @return
	 * @throws EventException
	 */
	public FcmVslCntrRgstVO searchFmsVslCntr(String vslCd) throws EventException;
	
}
