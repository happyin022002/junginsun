/*=========================================================
*Copyright(c) 2017 Hipluscard
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
package com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.basic;

import java.util.List;

import com.hanjin.apps.alps.bcm.cms.custmanage.keymaninfo.vo.SamKeyManInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Generalinfomanage Business Logic Command Interface<br>
 * - OPUS-Generalinfomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author NAMKOONGJINHO
 * @see KeyManInfoManageBC
 * @since J2EE 1.6 
 */
public interface KeyManInfoBC {
	/**
	 * EMS_SAM_0003
	 * KeyManInfo sheet 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchCustomerVO	searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception EventException
	 */
	public List<SamKeyManInfoVO > searchKeyManInfo(String custCntCd, String custSeq ) throws EventException;
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
	
	/**
	 * multi event process<br>
	 * Customer KeyMan  multi event process(BCM_CMS_0302)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKeyManCust(SamKeyManInfoVO[] samKeyManInfoVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * EMS_SAM_0307
	 * Key man List를 [조회] 합니다.<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @return List<SamKeyManInfoVO>
	 * @exception EventException
	 */
	public List<SamKeyManInfoVO> searchKeyManList(SamKeyManInfoVO samKeyManInfoVO) throws EventException;
	
	/**
	 * KeyManList 저장(insert OR update)<br>
	 * Customer Address (BCM_CMS_0308.do)<br>
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageKeyManList(SamKeyManInfoVO samKeyManInfoVO, SignOnUserAccount account) throws EventException;

}