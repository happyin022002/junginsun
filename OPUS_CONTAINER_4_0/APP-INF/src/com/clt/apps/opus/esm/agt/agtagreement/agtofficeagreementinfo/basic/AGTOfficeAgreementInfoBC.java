/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeAgreementInfoBC.java
*@FileTitle : Agent Agreement Rate Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.basic;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtAgnAgmtMstVO;
import com.clt.syscommon.common.table.AgtAgnAgmtRtVO;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;
import com.clt.syscommon.common.table.AgtAgnCtrtRefVO;
import com.clt.syscommon.common.table.AgtAgnOtrRefVO;

/**
 * OPUS-Agtagreement Business Logic Command Interface<br>
 * - OPUS-Agtagreement handling Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Esmagt0003EventResponse 
 * @since J2EE 1.6
 */

public interface AGTOfficeAgreementInfoBC {

	/**
	 * EsmAgt0001 retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentInfoForAgreementbyCountry(AgtAgnAgmtVO agtAgnAgmtVO) throws EventException;
	
	/**
	 * ESM_AGT_0001 remove event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * 
	 */
	public void removeAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_001 create event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentInfoForAgreement(AgtAgnAgmtVO[] agtAgnAgmtVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_001 Copy event process<br>
	 * 
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOS
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createOldAgreementNoVendortoNew(AgtAgnAgmtVO[] agtAgnAgmtVOS,AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0044 retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @return List<AgtAgnAgmtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtVO> checkAgreementOffice(AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_004 retrieve event process<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List[] 
	 * @exception EventException
	 */
	public List[] searchOtherInfoList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;

	/**
	 * ESM_AGT_004 retrieve event process<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchOtherInfoSearchList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;
	
	/**
	 * ESM_AGT_005 retrieve event process<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List[] 
	 * @exception EventException
	 */
	public List[] searchDeductionInfoList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException;
	

	/**
	 * ESM_AGT_005 retrieve event process<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @exception EventException
	 */
	public List<AgtChargeDeductionVO> searchDeductionInfoChkDetailChkList(AgtChargeDeductionVO agtChargeDeductionVO) throws EventException;
	
	/**
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO> 
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoSubContiList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoCntryList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoLocList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_006 retrieve event process<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @exception EventException
	 */
	public List<AgtGeogOfcVO> searchGeogOfcInfoOfcList(AgtGeogOfcVO agtGeogOfcVO) throws EventException;
	/**
	 * ESM_AGT_0037 retrieve event process<br>
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @param int gbn
	 * @return List<AgtAgnOtrRefVO>
	 * @throws EventException
	 */
	public List<AgtAgnOtrRefVO> searchOtherInfoListInput(AgtAgnOtrRefVO agtAgnOtrRefVO, int gbn) throws EventException;
	/**
	 * ESM_AGT_0037 retrieve event process<br>
	 * @param AgtAgnCtrtRefVO agtAgnCtrtRefVO
	 * @param int gbn
	 * @return List<AgtAgnCtrtRefVO>
	 * @throws EventException
	 */
	public List<AgtAgnCtrtRefVO> searchOtherInfoListInput2(AgtAgnCtrtRefVO agtAgnCtrtRefVO, int gbn) throws EventException;
	/**
	 * ESM_AGT_0003 Office retrieve event process<br>
	 * @param AgtAgnAgmtMstVO agtAgnAgmtMstVO
	 * @return List<AgtAgnAgmtMstVO> 
	 * @exception EventException
	 */
	public List<AgtAgnAgmtMstVO> searchAgentRateInfoList(AgtAgnAgmtMstVO agtAgnAgmtMstVO) throws EventException;
	/**
	 * ESM_AGT_0003 CUD event process<br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0003 Agreement Copy event process<br>
	 * @param AgtAgnAgmtVO[] agtAgnAgmtVOs
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multicopyAgentRateInfo(AgtAgnAgmtVO[] agtAgnAgmtVOs,
			AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0003 retrieve event process<br>
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @throws EventException
	 */
	public List<AgtAgnAgmtVO> searchAgentRateInfoList2(AgtAgnAgmtVO agtAgnAgmtVO) throws EventException;
	/**
	 * ESM_AGT_0003 Detail retrieve event process<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtAgnAgmtRtVO> searchAgentRateDetailInfoList(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws EventException;
	/**
	 * ESM_AGT_0003 AGreement RowCopy Save retrieve event process<br>
	 * @param AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAgentRateDetailInfo(AgtAgnAgmtRtVO[] agtAgnAgmtRtVOS, AgtAgnAgmtRtVO agtAgnAgmtRtVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0101 retrieve event process<br>
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List[]
	 * @exception EventException
	 */
	public List<AgtCntrTypeSizeVO> searchRepCntrList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws EventException;

	
}