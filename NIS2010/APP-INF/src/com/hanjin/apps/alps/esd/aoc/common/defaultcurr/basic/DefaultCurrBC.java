/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DefaultCurrBC.java
*@FileTitle : Inland Cost Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.defaultcurr.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntDefaultCurrVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.CntInfoVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.InlandCostConditionVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.vo.RHQComboVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-CostManage Business Logic Command Interface<br>
 * - ALPS-CostManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public interface DefaultCurrBC  {

	/**
	 * Default Currency Creation - RHQ<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<RHQComboVO> searchRHQCombo() throws EventException;

	/**
	 * Default Currency Creation - Retrieve<br>
	 * 
	 * @param inlandCostConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<CntDefaultCurrVO> searchCntDefaultCurr(InlandCostConditionVO inlandCostConditionVO) throws EventException;
	
	/**
	 * Default Currency Creation - Country Info<br>
	 * 
	 * @param inCntCd
	 * @return
	 * @throws EventException
	 */
	public CntInfoVO searchCntInfo(String inCntCd) throws EventException;

	/**
	 * Default Currency Creation - Currency Name<br>
	 * 
	 * @param currCd
	 * @return
	 * @throws EventException
	 */
	public String searchCurrNm(String currCd) throws EventException;
	
	/**
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Default Currency Creation - Delete<br>
	 * 
	 * @param cntDefaultCurrVOs
	 * @param account
	 * @throws EventException
	 */
	public void removeCntDefaultCurr(CntDefaultCurrVO[] cntDefaultCurrVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Default Currency Creation - Currency Code 확인<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String verifyCurrencyCode(String currCd) throws EventException;
	
	/**
	 * Default Currency Creation - Country Code 확인<br>
	 * @param rhqCd
	 * @param CntCd
	 * @return
	 * @throws EventException
	 */
	public String verifyCountryCode(String rhqCd, String CntCd) throws EventException;	


}
