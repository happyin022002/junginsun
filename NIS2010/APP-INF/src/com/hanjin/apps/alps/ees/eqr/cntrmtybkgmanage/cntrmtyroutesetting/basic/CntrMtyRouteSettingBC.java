/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyRouteSettingBC.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 최초등록
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 두기민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.basic;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019GRPVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtyroutesetting.vo.EesEqr1019RouteSettingVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS Business Logic Command Interface<br>
 * - 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 두기민
 * @see Ees_eqr_1019EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrMtyRouteSettingBC {

	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING 화면 수정.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrMtyRouteSettingList(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING TP/SZ 수정.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCntrTpSzList(EesEqr1019RouteSettingVO[] eesEqr1019RouteSettingVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING 화면 조회.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return EesEqr1019GRPVO
	 * @exception EventException
	 * 
	 */
	public EesEqr1019GRPVO searchCntrMtyRouteSettingList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException;
	
	/**
	 * [EES_EQR_1019 : ] MTY BKG ROUTE SETTING TP/SZ 조회.<br>
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return EesEqr1019GRPVO
	 * @exception EventException
	 * 
	 */
	public EesEqr1019GRPVO searchCntrTpSzList(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException;
	
	/**
	 * MTY BKG ROUTE SETTING Location 유효성 조회. <br> 
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return int
	 * @exception EventException
	 */
	public int checkLocationByGroupCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException;
	
	/**
	 * MTY BKG ROUTE SETTING Rcc에 따른 Lcc_cd 조회(사용안함) <br> 
	 * 
	 * @param EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationByRccCode(EesEqr1019RouteSettingVO eesEqr1019RouteSettingVO) throws EventException;
	
}