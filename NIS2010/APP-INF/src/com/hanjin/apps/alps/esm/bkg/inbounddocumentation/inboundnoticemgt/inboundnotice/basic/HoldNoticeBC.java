/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeBC.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.05.06 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHldNtcUsrVO;
import com.hanjin.syscommon.common.table.BkgHldWdDtlVO;
import com.hanjin.syscommon.common.table.BkgHldWdVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;


/**
 * ALPS-Inboundnoticemgt Business Logic Command Interface<br>
 * - ALPS-Inboundnoticemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Mi Ok
 * @see Esm_bkg-0948EventResponse 참조
 * @since J2EE 1.4
 */

public interface HoldNoticeBC {

	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948)화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String cstmsLocCd Location Code
	 * @param String userId User ID
	 * @return List<BkgHldNtcUsrVO>  Staff에 의해 Setting된 Hold Notice 정보
	 * @exception EventException
	 */
	public List<BkgHldNtcUsrVO> searchHldNtcUsr(String cstmsLocCd, String userId) throws EventException;

	/**
	 * Hold Mail/Alert Set-Up(UI_BKG-0948)화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param BkgHldNtcUsrVO[] hldNtcUsrs Hold Notice User 목록
	 * @param SignOnUserAccount account SignOn User Account
	 * @exception EventException
	 */
	public void setupHldNtcUsr(BkgHldNtcUsrVO[] hldNtcUsrs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 특정 국가별로 등록된 Hold Code정보를 조회한다.<br>
	 * 
	 * @param String cntCd 국가코드
	 * @return List<BkgHldCdVO> 특정 국가별 다건의  Hold Code Data
	 * @exception EventException
	 */
	public List<BkgComboVO> searchHldNtcCode(String cntCd) throws EventException;

	/**
	 * 기 등록된 Hold Notice Form화면에 POD 목록 정보를 조회한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String hldNtcTpCd
	 * @return List<BkgHldWdVO>
	 * @exception EventException
	 */
	public List<BkgHldWdVO> searchHldNtcFormPodList (String ofcCd, String hldNtcTpCd) throws EventException;

	/**
	 * Pre Hold Notice 전송방식과 내용에 따른 Form Setup정보를 조회한다. <br>
	 * 
	 * @param String	ofcCd 
	 * @param String	podCd
	 * @return HoldNoticeFormVO
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcPreForm (String ofcCd, String podCd) throws EventException;
	
	/**
	 * Hold Notice ( Pre-Hold )의 Hold Code별 Form정보를 저장 or수정 한다.<br>
	 * 
	 * @param HoldNoticeFormVO[]	hldNtcForm
	 * @param SignOnUserAccount	account 
	 * @exception EventException
	 */
	public void setupHldNtcPreForm(BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException;


	/**
	 * 특정 Location별로 등록된 H/N Form Master정보를 삭제한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @exception EventException
	 */
	public void removeHldNtcForm(String ofcCd, String podCd, String ntcTpCd) throws EventException;

	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Check한다.<br>
	 * 
	 * @param String OfcCd
	 * @param String PodCd
	 * @param String ntcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExist(String ofcCd, String podCd, String ntcTpCd) throws EventException;

	
	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Copy한다.<br>
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
	 * 세관 EDI정보에서 Hold정보를 자동  인식해서 발송된 Pre-Hold Notice내역 정보를 조회한다. ( 미주지역만 해당)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<PreHldNtcSendListVO> searchHldNtcSendListByPre(HldNtcSearchVO hldNtcSearch) throws EventException;
	
	
	/**
	 * 세관 EDI정보에서 Hold에 대한 Clear(Confirm) Event가 발생한 대상 정보를 조화한다.( 미주지역만 해당)<br>
	 *  
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception EventException
	 */
	public List<ConfirmHldNtcSendListVO> searchHldNtcSendListByConfirm(HldNtcSearchVO hldNtcSearch) throws EventException;
	
	
	/**
	 * 기 입력된 Hold Notice Setup 정보를 Check한다.<br>
	 * 
	 * @param String OfcCd
	 * @param String PodCd
	 * @param String hldNtcTpCd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkHldNtcFormExistByNtcType(String ofcCd, String podCd, String hldNtcTpCd) throws EventException;

	
	/**
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Fax로 Hold Notice를 발송한다.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByFax (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException; 
	
	
	/**
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가  Email로 Hold Notice를 발송한다.<br>
	 * 
	 * @param PreHldNtcSendListVO[] preHldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendPreHldNtcByEmail (PreHldNtcSendListVO[] preHldNtcSendLists, SignOnUserAccount account) throws EventException;

	/**
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Fax로 Hold Notice를 발송한다.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByFax (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException; 
	
	
	/**
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가  Email로 Hold Notice를 발송한다.<br>
	 * 
	 * @param ConfirmHldNtcSendListVO[] hldNtcSendLists
	 * @param SignOnUserAccount account
	 * @return
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendConfirmHldNtcByEmail (ConfirmHldNtcSendListVO[] hldNtcSendLists, SignOnUserAccount account) throws EventException;

	
	/**
	 * Confirm Hold Notice 전송방식과 내용에 따른 Form Setup정보를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @return HoldNoticeFormVO
	 * @exception EventException
	 */
	public HoldNoticeFormVO searchHldNtcConfirmForm (String ofcCd, String podCd) throws EventException;
	

	/**
	 * Hold Notice (  Confirm-Hold)의 Hold Code별 Form정보를 저장 or수정 or 삭제한다.<br>
	 * 
	 * @param HoldNoticeFormVO hldNtcForm
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupHldNtcConfirmForm(BkgHldWdVO hldWd, BkgHldWdDtlVO[] hldWdDtls, SignOnUserAccount account) throws EventException;

	/**
	 * Waring 이벤트 발생을 처리한다.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToObStaff (CstmsHldVO cstmsHld);
	
	/**
	 * Waring 이벤트 발생을 처리한다.
	 * 
	 * @param CstmsHldVO cstmsHld
	 */
	public void sendAmsNtcToBkgStaff (CstmsHldVO cstmsHld);
	
	/**
	 * Hold Notice 이벤트 발생을 처리한다.
	 * 
	 * @param CstmsHldVO cstmsHld
	 * @return List<BkgNtcHisVO>
	 */
	public List<BkgNtcHisVO> createCstmsHld (CstmsHldVO cstmsHld);

	/**
	 * TPB 관련 대상을 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<TpbInfoVO>
	 * @exception EventException
	 */
	public List<TpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws EventException;

	
	/**
	 * TPB 정보(금액, TPB 번호)를 업데이트 한다.
	 * 
	 * @param TpbInfoVO[] tpbInfos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void setupTpbInfo(TpbInfoVO[] tpbInfos, SignOnUserAccount account) throws EventException;

}