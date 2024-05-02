/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeAgreementInfoBC.java
*@FileTitle : Agent Agreement Rate Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.17 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtAgnAgmtMstVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtAgnAgmtVO;
import com.hanjin.syscommon.common.table.AgtAgnCtrtRefVO;
import com.hanjin.syscommon.common.table.AgtAgnOtrRefVO;

/**
 * ALPS-Agtagreement Business Logic Command Interface<br>
 * - ALPS-Agtagreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Jin
 * @see Esmagt0003EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTOfficeAgreementInfoBC {

	/**
	 * EsmAgt0001 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentInfoForAgreementbyCountry(AgtAgnAgmtVO agtAgnAgmtVO) throws EventException;
	
	/**
	 * ESM_AGT_0001 화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	public void removeAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_001 화면에 대한 추가 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_001 화면에 대한 Copy 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOS
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createOldAgreementNoVendortoNew(AgtAgnAgmtVO[] agtAgnAgmtVOS,AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0044 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> checkAgreementOffice(AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List[] 
	 * @exception EventException
	 */
	public List[] searchOtherInfoList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;

	/**
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchOtherInfoSearchList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;
	
	/**
	 * ESM_AGT_005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List[] 
	 * @exception EventException
	 */
	public List[] searchDeductionInfoList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException;
	

	/**
	 * ESM_AGT_005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @exception EventException
	 */
	public List<AgtChargeDeductionVO> searchDeductionInfoChkDetailChkList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException;
	
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO> 
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoSubContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoCntryList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoLocList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoOfcList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_0037 화면에 대한 조회 이벤트 처리<br>
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @param int gbn
	 * @return List<AgtAgnOtrRefVO>
	 * @throws EventException
	 */
	public List<AgtAgnOtrRefVO> searchOtherInfoListInput(AgtAgnOtrRefVO agtAgnOtrRefVO, int gbn) throws EventException;
	/**
	 * ESM_AGT_0037 화면에 대한 조회 이벤트 처리<br>
	 * @param AgtAgnCtrtRefVO agtAgnCtrtRefVO
	 * @param int gbn
	 * @return List<AgtAgnCtrtRefVO>
	 * @throws EventException
	 */
	public List<AgtAgnCtrtRefVO> searchOtherInfoListInput2(AgtAgnCtrtRefVO agtAgnCtrtRefVO, int gbn) throws EventException;
	/**
	 * ESM_AGT_0003 화면에 대한 Office 조회<br>
	 * @param AgtAgnAgmtMstVO agtAgnAgmtMstVO
	 * @return List<AgtAgnAgmtMstVO> 
	 * @exception EventException
	 */
	public List<AgtAgnAgmtMstVO> searchAgentRateInfoList(AgtAgnAgmtMstVO agtAgnAgmtMstVO) throws EventException;
	/**
	 * ESM_AGT_0003 화면에 대한 CUD <br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0003 화면에 대한 Agreement Copy<br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOs
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multicopyAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVOs,
			AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0003 화면에 대한 조회<br>
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @throws EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentRateInfoList2(AgtAgnAgmtVO agtAgnAgmtVO) throws EventException;
	/**
	 * ESM_AGT_0003 화면에 대한 Detail 조회 이벤트<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtRtVO> searchAgentRateDetailInfoList(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws EventException;
	/**
	 * ESM_AGT_0003 화면 AGreement RowCopy Save이벤트<br>
	 * @param AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAgentRateDetailInfo(AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS, AgtAgnAgmtRtVO agtAgnAgmtRtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0101화면에 대한 조회 이벤트 처리<br>
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchRepCntrList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;
	
}