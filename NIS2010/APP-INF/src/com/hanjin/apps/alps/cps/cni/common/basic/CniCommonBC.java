/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CniCommonBC.java
 *@FileTitle : Container Cargo Claim 공통
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.common.basic;

import com.hanjin.framework.core.layer.event.EventException;



/**
 * Container Cargo Claim Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface CniCommonBC {
    
	
	// ---------------------------------------------------------------------------
	// [CNI COMMON] Cargo Claim 공통
	// ---------------------------------------------------------------------------	
	/**
	 * 사용자 Role 리스트 취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserRoleList 
	 * @param String usrId 로그인 사용자
     * @return String "CNI01,CNI02 ....." 반환
     * @throws EventException
     */
    public String searchUserRoleList(String usrId) throws EventException;
	/**
	 * 사용자 Area  취득<br>
	 * @author 진윤오
	 * @category CNI COMMON
	 * @category searchUserArea 
	 * @param String ofcCd 오피스코드
     * @return String
     * @throws EventException
     */
    public String searchUserArea(String ofcCd) throws EventException;
}