/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EQCOrgChartBC.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.vo.EQCOrgChartListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyung Choon_Roh
 * @see ComEns0O1EventResponse 참조
 * @since J2EE 1.4
 */
public interface EQCOrgChartBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQCOrgChart화면에 대한 조회 이벤트 처리<br>
	 * @param String depth
	 * @param String chkDepth
	 * @param SignOnUserAccount account
	 * @return List<EQQrgChartListVO>
	 * @exception EventException
	 */
	public List<EQCOrgChartListVO> searchEQCOrgChartList(String depth, String chkDepth, SignOnUserAccount account) throws EventException;

	/**
	 * EQC Organization Chart 화면에 대한 저장 이벤트 처리<br>
	 * @param EQCOrgChartListVO[] eQCOrgChartListVOs
	 * @param SignOnUserAccount account
	 * @return int[]
	 * @exception EventException
	 */
	public int[] multiEqrCtrlFcastLocBasic(EQCOrgChartListVO[] eQCOrgChartListVOs, SignOnUserAccount account) throws EventException;
}