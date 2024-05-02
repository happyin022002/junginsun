/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : seviceBC.java
 *@FileTitle : activity
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.basic;
 

import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ActivityVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.MovementStatusVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.RLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.ScopeGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.TradeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SubTradeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Common code Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface ServiceBC {

	/**
	 * To act code to query detailed information.<br>
	 * 
	 * @param String actCd
	 * @return ActivityVO
	 * @exception EventException
	 */
	public ActivityVO searchActCode(String actCd) throws EventException;

	/**
	 * Act code on the new generation, and act code to modify the details of information.<br>
	 * 
	 * @param ActivityVO actvo
	 * @exception EventException
	 */
	public void manageActCode(ActivityVO actvo) throws EventException;

	/**
	 * To mvmt sts code to query detailed information.<br>
	 * 
	 * @param String mvmtStsCd
	 * @return MovementStatusVO
	 * @exception EventException
	 */
	public MovementStatusVO searchMvmtStsCode(String mvmtStsCd) throws EventException;

	/**
	 * Mvmt sts code on the new generation, and mvmt sts code to modify the details of information.<br>
	 * 
	 * @param MovementStatusVO mvmtstsvo
	 * @exception EventException
	 */
	public void manageMvmtStsCode(MovementStatusVO mvmtstsvo, SignOnUserAccount account) throws EventException;

	/**
	 * To rlane code to query detailed information.<br>
	 * 
	 * @param String rlaneCd
	 * @return RLaneGroupVO
	 * @exception EventException
	 */
	public RLaneGroupVO searchRlaneCode(String rlaneCd) throws EventException;
	
	/**
	 * To rlane code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return RLaneGroupVO
	 * @exception EventException
	 */
	public RLaneGroupVO searchRlaneCodeRqst(String rqstNo) throws EventException;

	/**
	 * Rlane code on the new generation, and rlane code to modify the details of information.<br>
	 * 
	 * @param RLaneGroupVO rlaneVO
	 * @exception EventException
	 */
	public void manageRlaneCode(RLaneGroupVO rlanevo) throws EventException;
	
	/**
	 * Rlane code on the new generation, and rlane code to modify the details of information.<br>
	 * 
	 * @param RLaneGroupVO rlaneVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageRlaneCodeRqst(RLaneGroupVO rlanevo, String rqstNo) throws EventException;

	/**
	 * To slane code to query detailed information.<br>
	 * 
	 * @param String slaneCd
	 * @return SLaneGroupVO
	 * @exception EventException
	 */
	public SLaneGroupVO searchSlaneCode(String slaneCd) throws EventException;
	
	/**
	 * To slane code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return SLaneGroupVO
	 * @exception EventException
	 */
	public SLaneGroupVO searchSlaneRqst(String rqstNo) throws EventException;

	/**
	 * Slane code on the new generation, and slane code to modify the details of information.<br>
	 * 
	 * @param SLaneGroupVO slaneVO
	 * @exception EventException
	 */
	public void manageSlaneCode(SLaneGroupVO slanevo) throws EventException;
	
	/**
	 * Slane code on the new generation, and slane code to modify the details of information.<br>
	 * 
	 * @param SLaneGroupVO slaneVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageSlaneRqst(SLaneGroupVO slanevo, String rqstNo) throws EventException;

	/**
	 * To scp code to query detailed information.<br>
	 * 
	 * @param String scpCd
	 * @return ScopeGroupVO
	 * @exception EventException
	 */
	public ScopeGroupVO searchScpCode(String scpCd) throws EventException;
	
	/**
	 * To scp code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return ScopeGroupVO
	 * @exception EventException
	 */
	public ScopeGroupVO searchScpRqst(String rqstNo) throws EventException;

	/**
	 * Scp code on the new generation, and scp code to modify the details of information.<br>
	 * 
	 * @param ScopeGroupVO scpGroupVO
	 * @exception EventException
	 */
	public void manageScpCode(ScopeGroupVO scpGroupVO) throws EventException;
	
	/**
	 * Scp code on the new generation, and scp code to modify the details of information.<br>
	 * 
	 * @param ScopeGroupVO scpGroupVO
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageScpRqst(ScopeGroupVO scpGroupVO, String rqstNo) throws EventException;

	/**
	 * To trd code to query detailed information.<br>
	 * 
	 * @param String trdCd
	 * @return TradeVO
	 * @exception EventException
	 */
	public TradeVO searchTrdCode(String trdCd) throws EventException;
	
	/**
	 * To trd code to query detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return TradeVO
	 * @exception EventException
	 */
	public TradeVO searchTrdRqst(String rqstNo) throws EventException;

	/**
	 * Trd code on the new generation, and trd code to modify the details of information.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception EventException
	 */
	public void manageTrdCode(TradeVO trdvo) throws EventException;
	
	/**
	 * Trd code on the new generation, and trd code to modify the details of information.<br>
	 * 
	 * @param TradeVO trdvo
	 * @exception EventException
	 */
	public void manageTrdRqst(TradeVO trdvo) throws EventException;

	/**
	 * To sub trd code to query detailed information.<br>
	 * 
	 * @param String subtrdCd
	 * @return SubTradeVO
	 * @exception EventException
	 */
	public SubTradeVO searchSubTrdCode(String subTrdCd) throws EventException;

	/**
	 * Sub trd code on the new generation, and sub trd code to modify the details of information.<br>
	 * 
	 * @param SubTradeVO subtrdvo
	 * @exception EventException
	 */
	public void manageSubTrdCode(SubTradeVO subTrdvo) throws EventException;	
}