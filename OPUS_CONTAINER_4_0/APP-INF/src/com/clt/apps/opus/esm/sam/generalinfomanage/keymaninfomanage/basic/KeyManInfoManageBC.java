/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KeyManInfoManageBC.java
*@FileTitle : KeyMan Info Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.05.09 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.vo.SamKeyManInfoVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Generalinfomanage Business Logic Command Interface<br>
 * - OPUS-Generalinfomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see KeyManInfoManageBC
 * @since J2EE 1.6
 */

public interface KeyManInfoManageBC {

	/**
	 * EMS_SAM_0003
	 * KeyManInfo sheet 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchCustomerVO	searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception EventException
	 */
	public List<SearchCustomerVO > searchKeyManInfo(SearchCustomerVO  searchCustomerVO ) throws EventException;
	/**
	 * EMS_SAM_0003
	 * Key man Detail Info를 [조회] 합니다.<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @return List<SamKeyManInfoVO>
	 * @exception EventException
	 */
	
	public List<SamKeyManInfoVO> searchKeyManDetailInfo(SamKeyManInfoVO samKeyManInfoVO) throws EventException;

	
	/**
	 * EMS_SAM_0003
	 * KeyManInfo를 [수정], [추가] 합니다.<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @exception EventException
	 */
	public void manageKeyManInfo(SamKeyManInfoVO samKeyManInfoVO) throws EventException;
	
	
	/**
	 * EMS_SAM_0003
	 * KeyManInfo를 [삭제] 합니다.<br>
	 * 
	 * @param SamKeyManInfoVO[] samKeyManInfoVOs
	 * @exception EventException
	 */
	public void deleteKeyManInfo(SamKeyManInfoVO[] samKeyManInfoVOs) throws EventException;

}