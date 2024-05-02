/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MotFilingLocationPropertyBC.java
*@FileTitle : MOT Base Port Table Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.motfilinglocationproperty.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriMotFileLocPptVO;

/**
 * opus-Primasterdata Business Logic Command Interface<br>
 * - opus-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SongHoJin
 * @see Esm_pri_4035EventResponse 참조
 * @since J2EE 1.6
 */

public interface MotFilingLocationPropertyBC {

	/**
	 * MOT Filing Location Property 정보를  조회  합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO	priMotFileLocPptVO
	 * @return List<PriMotFileLocPptVO>
	 * @exception EventException
	 */
	public List<PriMotFileLocPptVO> searchPriMotFileLocPpt(PriMotFileLocPptVO priMotFileLocPptVO) throws EventException;
	
	/**
	 * MOT Filing Location Property 정보를  관리  합니다.<br>
	 * 
	 * @param PriMotFileLocPptVO[] priMotFileLocPptVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void managePriMotFileLocPpt(PriMotFileLocPptVO[] priMotFileLocPptVO,SignOnUserAccount account) throws EventException;
}