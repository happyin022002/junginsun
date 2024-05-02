/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeBC.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;
import com.clt.syscommon.common.table.BkgHldWdDtlVO;
import com.clt.syscommon.common.table.BkgHldWdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;


/**
 *   Inboundnoticemgt Business Logic Command Interface<br>
 * - Inboundnoticemgt  business logic handling.<br>
 *
 * @author
 * @see Esm_bkg-0948EventResponse reference
 * @since J2EE 1.4
 */

public interface HoldNoticeBC {

	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948)retrieve event handling.<br>
	 * 
	 * @param String cstmsLocCd Location Code
	 * @param String userId User ID
	 * @return List<BkgHldNtcUsrVO>  by Staff, Setting Hold Notice info
	 * @exception EventException
	 */
	public List<BkgHldNtcUsrVO> searchHldNtcUsr(String cstmsLocCd, String userId) throws EventException;

	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948) multi event handling<br>
	 * 
	 * @param BkgHldNtcUsrVO[] hldNtcUsrs Hold Notice User list
	 * @param SignOnUserAccount account SignOn User Account
	 * @exception EventException
	 */
	public void setupHldNtcUsr(BkgHldNtcUsrVO[] hldNtcUsrs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Hold Code info in special country retrieve.<br>
	 * 
	 * @param String cntCd 
	 * @return List<BkgHldCdVO> Hold Code Data
	 * @exception EventException
	 */
	public List<BkgComboVO> searchHldNtcCode(String cntCd) throws EventException;

	/**
	 * POD list info retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @param String hldNtcTpCd
	 * @return List<BkgHldWdVO>
	 * @exception EventException
	 */
	public List<BkgHldWdVO> searchHldNtcFormPodList (String ofcCd, String hldNtcTpCd) throws EventException;

	/**
	 * Form Setup info retrieve. <br>
	 * 
	 * @param String	ofcCd 
	 * @param String	podCd
	 * @return List<HoldNoticeFormVO>
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcPreForm (String ofcCd, String podCd) throws EventException;
	
	/**
	 * Hold Notice ( Pre-Hold ) Form info manage.<br>
	 * 
	 * @param HoldNoticeFormVO[]	hldNtcForm
	 * @param SignOnUserAccount	account 
	 * @exception EventException
	 */
	public void setupHldNtcPreForm(BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException;


	/**
	 * H/N Form Master info remove.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @exception EventException
	 */
	public void removeHldNtcForm(String ofcCd, String podCd, String ntcTpCd) throws EventException;

	/**
	 * Pre-Hold Notice Setup info Check.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExist(String ofcCd, String podCd, String ntcTpCd) throws EventException;

	
	/**
	 *  Pre-Hold Notice Setup info Copy.<br>
	 * 
	 * @param String toOfcCd
	 * @param String toPodCd
	 * @param String fmOfcCd
	 * @param String fmPodCd
	 * @param String ntcTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyHldNtcPreForm(String toOfcCd, String toPodCd, String fmOfcCd, String fmPodCd, String ntcTpCd, SignOnUserAccount account) throws EventException;

	
	/**
	 *  pre-transmited Hold info in manifest EDI info, Pre-Hold Notice info retrieve. ( In USA)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<PreHldNtcSendListVO> searchHldNtcSendListByPre(HldNtcSearchVO hldNtcSearch) throws EventException;
	
	
	/**
	 * Hold Clear(Confirm) info retrieve.(In USA)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<ConfirmHldNtcSendListVO> searchHldNtcSendListByConfirm(HldNtcSearchVO hldNtcSearch) throws EventException;
	
	
	/**
	 * Hold Notice Setup info Check.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String hldNtcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExistByNtcType(String ofcCd, String podCd, String hldNtcTpCd) throws EventException;

	
	/**
	 * Pre Hold info send by Fax.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByFax (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException; 
	
	
	/**
	 * Pre Hold info send by E-mail.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByEmail (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException;

	/**
	 * Pre Hold Confirm info send by Fax.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByFax (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException; 
	
	
	/**
	 * Pre Hold Confirm info send by E-mail.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByEmail (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException;

	
	/**
	 * differ transmission method and description in Confirm Hold Notice, Form Setup info retrieve.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @return HoldNoticeFormVO
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcConfirmForm (String ofcCd, String podCd) throws EventException;
	

	/**
	 * Hold Notice (  Confirm-Hold) Hold Code Form info manage.<br>
	 * 
	 * @param HoldNoticeFormVO hldNtcForm
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupHldNtcConfirmForm(BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException;

	/**
	 * Waring event handling.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToObStaff (CstmsHldVO cstmsHld);
	
	/**
	 * Hold Notice event handling.
	 * 
	 * @param CstmsHldVO cstmsHld
	 * @return List<BkgNtcHisVO>
	 */
	public List<BkgNtcHisVO> createCstmsHld (CstmsHldVO cstmsHld);

	/**
	 * TPB info retrieve.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<TpbInfoVO>
	 * @exception EventException
	 */
	public List<TpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException;

	
	/**
	 * TPB info update.
	 * 
	 * @param TpbInfoVO[] tpbInfos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupTpbInfo(TpbInfoVO[] tpbInfos, SignOnUserAccount account) throws EventException;
	
	/**
	 * Waring 이벤트 발생을 처리한다.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToBkgStaff (CstmsHldVO cstmsHld);	

}