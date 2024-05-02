/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RestuffingContainerRegistrationBC.java
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic;

import java.util.List;

import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmRestuffingDetailVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.UpdMstCntrVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Restuffingmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Ui_ctm_0423EventResponse reference
 * @since J2EE 1.4
 */

public interface RestuffingContainerRegistrationBC {
	/**
	 * EES_CTM_0417
	 * retrieving Restuffing list
	 *
	 * @param RetuffingListVO retuffingListVO
	 * @return List<RetuffingListVO>
	 * @throws EventException
	 */
	public List<RetuffingListVO> searchRestuffingList(RetuffingListVO retuffingListVO) throws EventException;


	 /**
	  * EES_CTM_0445
	  * retrieving for 0445 POPUP 
	  *
	  * @param  CtmMovementHistoryVO ctmMovementHistoryVO
	  * @param  String flg
	  * @return List<CTMRestuffingVO>
	  * @exception EventException
	  */
	public List<CTMRestuffingVO> searchOBJMVMT(CtmMovementHistoryVO ctmMovementHistoryVO, String flg) throws EventException;

	 /**
	  * EES_CTM_0422
	  * handling save event for 0422 Restuffing Save 
	  *
	  * @param  CtmRestuffingDetailVO[] ctmRestuffingDetailVOs
	  * @param  SignOnUserAccount account
	  * @return UpdMstCntrVO
	  * @exception EventException
	  */
	public UpdMstCntrVO createRestuffingContainer(CtmRestuffingDetailVO[] ctmRestuffingDetailVOs, SignOnUserAccount account) throws EventException;

	/**
	 * searching SPLIT booking from BKG_CONTAINER 
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 */
	public String getBkgSplitRSQL(String cntrNo) throws EventException;


}