/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailBC.java
*@FileTitle : Guideline Email
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.basic;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS- Mty Repo Guideline Email Business Logic Command Interface<br>
 * - OPUS- Mty Repo Guideline Email 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author YONGCHAN SHIN
 * @see EES_EQR_1018EventResponse 참조
 * @since J2EE 1.6
 */
public interface CntrPlanGuidelineEmailBC {

	/**
	 * [ EES_EQR_1030 : Guideline Email Set-Up ]<br>
	 * Guideline Email 수신자 리스트 조회
	 * @param EesEqr1030ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchGuidelineEmailList(EesEqr1030ConditionVO condVO) throws EventException;
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-Up ]<br>
	 * 입력될 이메일 수신자 ID 의 검증 및 name/office/email 정보 조회
	 * @param String usr_id
	 * @return EesEqr1030MultiVO
	 * @exception EventException
	 */
	public EesEqr1030MultiVO searchGuidelineEmailUserInfo(String usr_id) throws EventException;		
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 입력/수정/삭제 처리
	 * 
	 * @param EesEqr1030MultiVO[] eesEqr1030MultiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiGuidelineEmailList(EesEqr1030MultiVO[] eesEqr1030MultiVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * Guideline email 수신자조회
	 * @param EesEqr1031ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchGuidelineEmailContentsRecipient(EesEqr1031ConditionVO condVO) throws EventException;	
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * 최근 저장된 GUIDELINE LANE 조회
	 * @param EesEqr1031ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchGuidelineEmailContentsVslLaneCd(EesEqr1031ConditionVO condVO) throws EventException;	

}