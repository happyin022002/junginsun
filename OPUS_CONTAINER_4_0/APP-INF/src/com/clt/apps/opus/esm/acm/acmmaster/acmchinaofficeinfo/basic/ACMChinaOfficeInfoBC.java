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
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMMaster Business Logic Command Interface<br>
 * - OPUS-ACMMaster에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * @param chinaOfficeInfoVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public BkgChinaAgentVO[] manageOBChinaOfficeInfo(ChinaOfficeInfoVO[] chinaOfficeInfoVOs, SignOnUserAccount account) throws EventException;

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
	
	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 의 Vendor Code 중복 체크<br>
	 * 
	 * @param chinaOfficeInfoVOs
	 * @return
	 * @throws EventException
	 */
	public String checkDupVendorCode(ChinaOfficeInfoVO[] chinaOfficeInfoVOs) throws EventException;
}