/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleBC.java
*@FileTitle : Route Location Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.basic;

import java.util.List;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo.RoutLocCdVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Applicationdaterule Business Logic Command Interface<br>
 * - Applicationdaterule business logic Interface<br>
 *
 * @author 
 * @see Esm_pri_4034EventResponse 
 * @since J2EE 1.6
 */
public interface ApplicationDateRuleBC {
	
	/**
	 * Route Location conversion List select<br>
	 * @param routLocCdVO
	 * @return List<RoutLocCdVO>
	 * @throws EventException
	 */
	public List<RoutLocCdVO> searchLocationInfo(RoutLocCdVO routLocCdVO) throws EventException;
	
	/**
	 * Scope code select from Route Location conversion
	 * @return String
	 * @throws EventException
	 */
	public String[] searchScpCd() throws EventException ;
	
	/**
	 * Route Location conversion List Insert, Update, Delete.<br>
	 * @param routLocCdVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageLocationInfo(RoutLocCdVO[] routLocCdVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * check if there is the same data in Route Location conversion List
	 * @param chkScpCd
	 * @param chkOrgCd
	 * @param chkConvCd
	 * @return String
	 * @throws EventException
	 */
	public String checkLocationInfo(String chkScpCd,String chkOrgCd,String chkConvCd) throws EventException;
	
	/**check if there is Location code
	 * 
	 * @param chkLocation
	 * @return String
	 * @throws EventException
	 */
	public String checkLocationName(String chkLocation) throws EventException;
	
	/**check if there are the same data in DB
	 * @param chkLocation
	 * @param check_flg
	 * @param chk_scp_cd
	 * @return String
	 * @throws EventException
	 */
	public String checkForScp(String chkLocation,String check_flg,String chk_scp_cd) throws EventException;
}