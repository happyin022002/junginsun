/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RestuffingContainerRegistrationBC.java
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Restuffingmgt Business Logic Command Interface<br>
 * - ALPS-Restuffingmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KyungMin Woo
 * @see Ui_ctm_0423EventResponse 참조
 * @since J2EE 1.4
 */

public interface RestuffingContainerRegistrationBC {
	/**
	 * EES_CTM_0417
	 * Restuffing대상 목록 조회..<br>
	 *
	 * @param RetuffingListVO retuffingListVO
	 * @return List<RetuffingListVO>
	 * @throws EventException
	 */
	public List<RetuffingListVO> searchRestuffingList(RetuffingListVO retuffingListVO) throws EventException;


	 /**
	  * EES_CTM_0445
	  * 0445 POPUP화면을 위한 조회이벤트 처리. <br>
	  * 
	  * @param  CtmMovementHistoryVO ctmMovementHistoryVO
	  * @param  String flg
	  * @return List<CTMRestuffingVO>
	  * @exception EventException
	  */
	public List<CTMRestuffingVO> searchOBJMVMT(CtmMovementHistoryVO ctmMovementHistoryVO, String flg) throws EventException;

	 /**
	  * EES_CTM_0422
	  * 0422 Restuffing Save 이벤트를 처리한다. <br>
	  * 
	  * @param  CtmRestuffingDetailVO[] ctmRestuffingDetailVOs
	  * @param  SignOnUserAccount account
	  * @return UpdMstCntrVO
	  * @exception EventException
	  */
	public UpdMstCntrVO createRestuffingContainer(CtmRestuffingDetailVO[] ctmRestuffingDetailVOs, SignOnUserAccount account) throws EventException;	

	/**
	 * BKG_CONTAINER 에서 SPLIT된 부킹을 찾아온다.<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 */
	public String getBkgSplitRSQL(String cntrNo) throws EventException;


}