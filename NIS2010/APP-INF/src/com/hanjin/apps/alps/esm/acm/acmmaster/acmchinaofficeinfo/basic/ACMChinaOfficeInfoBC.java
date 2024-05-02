/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoBC.java
*@FileTitle : ACMChinaOfficeInfoBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMMaster Business Logic Command Interface<br>
 * - ALPS-ACMMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0007EventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMChinaOfficeInfoBC {

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 목록을 조회<br>
	 *
	 * @param ChinaOfficeInfoVO chinaOfficeInfoVO
	 * @return List<ChinaOfficeInfoVO>
	 * @exception EventException
	 */
	public List<ChinaOfficeInfoVO> searchOBChinaOfficeInfo(ChinaOfficeInfoVO chinaOfficeInfoVO) throws EventException;

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 목록을 저장하기 위해 BKG모듈의 VO Setting<br>
	 *
	 * @param ChinaOfficeInfoVO[] chinaOfficeInfoVOs
	 * @return BkgChinaAgentVO[]
	 * @exception EventException
	 */
	public BkgChinaAgentVO[] manageOBChinaOfficeInfo(ChinaOfficeInfoVO[] chinaOfficeInfoVOs) throws EventException;

	/**
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 조회<br>
	 *
	 * @param ChinaInfoForLaneVO chinaInfoForLaneVO
	 * @return List<ChinaInfoForLaneVO>
	 * @exception EventException
	 */
	public List<ChinaInfoForLaneVO> searchIBChinaInfoForLane(ChinaInfoForLaneVO chinaInfoForLaneVO) throws EventException;

	/**
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 저장<br>
	 *
	 * @param ChinaInfoForLaneVO[] chinaInfoForLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIBChinaInfoForLane(ChinaInfoForLaneVO[] chinaInfoForLaneVOs, SignOnUserAccount account) throws EventException;

}