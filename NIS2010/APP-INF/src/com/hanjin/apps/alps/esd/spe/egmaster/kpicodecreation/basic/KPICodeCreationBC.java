/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPICodeCreationBC.java
*@FileTitle : KPI Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.vo.KPICodeCreVO;

/**
 * ALPS-Egmaster Business Logic Command Interface<br>
 * - ALPS-Egmaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */

public interface KPICodeCreationBC {

	
	/**
	 * KPI Code Creation 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param KPICodeCreVO[] kpiCodeCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiKPICodeCre(KPICodeCreVO[] kpiCodeCreVOs,SignOnUserAccount account) throws EventException;	

	/**
	 * KPI Code Creation 데이터를 조회한다.<br>
	 * 
	 * @param KPICodeCreVO kpiCodeCreVO
	 * @return List<KPICodeCreVO>
	 * @exception EventException
	 */
	public List<KPICodeCreVO> searchKPICodeCre(KPICodeCreVO kpiCodeCreVO) throws EventException;	
}