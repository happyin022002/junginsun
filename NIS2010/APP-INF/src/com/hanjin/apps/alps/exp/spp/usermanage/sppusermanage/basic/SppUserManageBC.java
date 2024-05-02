/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageBC.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.30 안준상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.basic;

import java.util.List;

import com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.vo.MnrPartnerGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MnrPartnerVO;
import com.hanjin.syscommon.common.table.MnrPrnrCntcPntVO;


/**
 * ALPS-Usermanage Business Logic Command Interface<br>
 * - ALPS-Usermanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jsahn
 * @see SppusermanageEventResponse 참조
 * @since J2EE 1.6
 */

public interface SppUserManageBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String sp_ptal_id
	 * @return List<MnrPartnerVO>
	 * @exception EventException
	 */
	public List<MnrPartnerVO> searchSppUserBidInfoBasic(String sp_ptal_id) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String sp_ptal_id
	 * @return List<MnrPrnrCntcPntVO>
	 * @exception EventException
	 */
	public List<MnrPrnrCntcPntVO> searchSppUserBidInfosBasic(String sp_ptal_id) throws EventException;
	
	/**
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 * 
	 * @param vndrSeq String
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchMdmVendorInfoBasic(String vndrSeq) throws EventException;
	
	
	/**   
	 * 멀티 이벤트 처리<br>   
	 * bid user 추가 이벤트 처리<br>
	 * 
	 * @param MnrPartnerGRPVO mnrPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */         
	public void insertSppUserBidInfoBasic(MnrPartnerGRPVO mnrPartnerGRPVO,SignOnUserAccount account) throws EventException;
	
	/**   
	 * 멀티 이벤트 처리<br>   
	 * bid user 수정 이벤트 처리<br>
	 * 
	 * @param MnrPartnerGRPVO mnrPartnerGRPVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */         
	public void modifySppUserBidInfoBasic(MnrPartnerGRPVO mnrPartnerGRPVO,SignOnUserAccount account) throws EventException;
	
	/**   
	 * 멀티 이벤트 처리<br>   
	 * pso user 수정 이벤트 처리<br>
	 * 
	 * @param MdmVendorVO mdmVendorVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */         
	public void modifySppUserPsoInfoBasic(MdmVendorVO mdmVendorVO,SignOnUserAccount account) throws EventException;

	/**   
	 * 멀티 이벤트 처리<br>   
	 * bid user 수정 이벤트 처리<br>
	 * 
	 * @param MnrPartnerGRPVO mnrPartnerGRPVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */         
	public void modifySppUserBidPwdInfo(MnrPartnerGRPVO mnrPartnerGRPVO,SignOnUserAccount account) throws EventException;

}	