/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterBC.java
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date    
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvMcsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvoiceCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;
import com.hanjin.syscommon.common.table.JooLetterVO;
import com.hanjin.syscommon.common.table.JooLtrTmpltVO;

/**
 * ALPS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - ALPS-Jointoperationagreementsettlement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HAM DAE SUNG
 * @see Fns_joo_0073EventResponse 참조
 * @since J2EE 1.6
 */

public interface JointOperationLetterBC { 
	/**
	 * PersonInfo 조회한다.
	 * @param String car
	 * @return List<JooCntcMbrVO>
	 * @throws EventException
	 */
	public List<JooCntcMbrVO> searchPersonInfo(String car) throws EventException;
	
	/**
	 * Letter 기 전송 정보 조회한다. <br>
	 * @param InvMcsLetterVO invMcsLetterVO
	 * @return List<InvMcsLetterVO>
	 * @exception EventException
	 */
	public List<InvMcsLetterVO> searchLetterSendList (InvMcsLetterVO invMcsLetterVO) throws EventException;
	
	
	/**
	 * CustCdNm 정보를 읽어온다.
	 * @param String car
	 * @return List<CustCdNmVO>
	 * @throws EventException
	 */
	public List<CustCdNmVO> searchCustCdNm(String car) throws EventException;
	
	/**
	 * CarrierSeq 정보를 읽어온다.
	 * @param String car
	 * @param String customer
	 * @return List<CarrierSeqVO>
	 * @throws EventException
	 */
	public List<CarrierSeqVO> searchCarrierSeq(String car, String customer) throws EventException;
	
	/**
	 * Member Info 조회합니다.<br>
	 * 
	 * @param CustMemberVO custMemberVO
	 * @return List<CustMemberVO>
	 * @exception EventException
	 */
	public List<CustMemberVO> searchMemberInfo(CustMemberVO custMemberVO) throws EventException;
	
	/**
	 * Customer Code Info를 조회한다. <br>
	 * @param String custCntCd
	 * @param int custSeq
	 * @return CustCdInfoVO
	 * @exception EventException
	 */
	public CustCdInfoVO searchCustCdInfo(String custCntCd, int custSeq ) throws EventException;
	
	/**
     * Member Info를 저장합니다. <br>
	 * @param CustMemberVO[] custMemberVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageMemberInfo(CustMemberVO[] custMemberVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
     * Carrier Member Info를 조회합니다.
	 * @param String car
	 * @return List<JooCntcMbrVO>
	 * @exception EventException
	 */
	public List<JooCntcMbrVO> searchCarrierMemberInfo (String car) throws EventException;
	 
	/**
	 * Mcs, Invoice TextNo 조회한다.
	 * 
	 * @param String joLtrTpCd
	 * @param String ofcCd
     * @param String userId
	 * @return List<JoTmpltNoVO>
	 * @throws EventException
	 */
	public List<JoTmpltNoVO> searchTempalteTextNoList(String joLtrTpCd, String ofcCd, String userId) throws EventException;
	
 

	/**
	 * Mcs, Invoice  Address를 조회한다. 
	 * @param String ofcCd
	 * @return JooLtrTmpltVO
	 * @throws EventException
	 */
	public JooLtrTmpltVO searchTempalteAddress(String ofcCd) throws EventException;
	
	/**
	 * Mcs, Invoice 에 대한 Template 조회. <br>
	 * @param String joLtrTpCd
	 * @param String joTmpltNo
	 * @param String ofcCd
	 * @return JooLtrTmpltVO
	 * @throws EventException
	 */
	public JooLtrTmpltVO searchTemplate (String joLtrTpCd,String joTmpltNo, String ofcCd) throws EventException;

	/**
	 * Mcs, Invoice 생성<br>
	 * @param JooLtrTmpltVO  jooLtrTmpltVO
	 * @param String copy
	 * @param SignOnUserAccount signOnUserAccount
	 * @return LetterVO
	 * @throws EventException
	 */
	public LetterVO createTemplate (JooLtrTmpltVO  jooLtrTmpltVO, String copy ,SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * Mcs, Invoice 대한 삭제 <br>
	 * @param String joLtrTpCd
	 * @param String joTmpltNo
	 * @param String ofcCd
	 * @throws EventException
	 */
	public void removeTemplate  (String joLtrTpCd,String joTmpltNo, String ofcCd) throws EventException;

    /**
     * [MCS & Invoice Letter Fax/E-mail Inquiry]을 [조회Retrieve]합니다.<br>
     * @param  String ofcCd
     * @param  String userId
     * @param  String fmDt
     * @param  String toDt
     * @throws EventException
     * @return List<LetterVO> 
     * @author jang kang cheol
     */	
    public List<LetterVO>  searchLetterSendStsList  (String ofcCd,String userId, String fmDt, String toDt) throws EventException;	

    /**
     * 
     * [MCS Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return TextNoVO[] 
     * @throws EventException
     * @author jang kang cheol
     */
    public List<TextNoVO>  searchMcsTextNo(LetterVO letterVO) throws EventException;  
    
    /**
     * 
     * [MCS Letter Information Creation의 Text No]을 [조회 Get Text No. OnFocus Out]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return List<McsLetterVO> 
     * @throws EventException
     * @author jang kang cheol
     */
    public List<McsLetterVO> searchMcsLetter( LetterVO letterVO) throws EventException;
 
    
    /**
     * [MCS Letter Information Creation의 Text No]을 [조회 Retrieve]합니다.<br>
     *
     * @param  McsCombinedVO mcsCombinedVO
     * @throws EventException
     * @return  List<McsCombinedVO> 
     * @author jang kang cheol
     */
    public List<McsCombinedVO>  searchMcsCombined(McsCombinedVO mcsCombinedVO ) throws EventException;
    /**
     * 
     * [MCS Letter Information Creation의 Text No]을 [Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @param  LetterVO[] letterVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @return LetterVO
     * @author jang kang cheol
     */
    public LetterVO manageMcsLetter(LetterVO letterVO, LetterVO[] letterVOs, SignOnUserAccount signOnUserAccount) throws EventException;
    /**
     * 
     * [MCS Letter Information Creation]을 [Send]합니다.<br>
     *
     * @param  LetterVO  letterVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void sendMcsLetter(LetterVO  letterVO  ) throws EventException;
    
    /**
     * 
     * Mdm_Customer 자료를 CarCd로 조회합니다.<br>
     *
     * @param  String carCd
     * @throws EventException
     * @return List<McsLetterVO>
     * @author jang kang cheol
     */
    public  List<McsLetterVO>  searchToCustList(String carCd) throws EventException;
    /**
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List<TextNoVO>
     * @author jang kang cheol
     */
    public List<TextNoVO>  searchInvoiceTextNo(LetterVO letterVO) throws EventException; 
 
    /**
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO 
     * @throws EventException
     * @return List< InvoiceCombinedVO> 
     * @author jang kang cheol
     */
    public List<InvoiceCombinedVO> searchInvoiceLetter( LetterVO letterVO )  throws EventException;
    
     
    /**
     * [Invoice Letter Information Creatio ]을 [조회 Retrieve]합니다.<br>
     *
     * @param  InvoiceCombinedVO invoiceCombinedVO
     * @throws EventException
     * @return List<InvoiceCombinedVO> 
     * @author jang kang cheol
     */
    public List<InvoiceCombinedVO> searchInvoiceCombined(InvoiceCombinedVO invoiceCombinedVO) throws EventException;
    
    /**
     * [Invoice Letter Information Creation]을 [Send]합니다.<br>
     *
     * @param  LetterVO  letterVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void sendInvoiceLetter(LetterVO  letterVO  ) throws EventException;
 
    /**
     * 
     * [Invoice Letter Information Creation의 Text No]을 [Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @param LetterVO[] letterVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @return LetterVO
     * @author jang kang cheol
     */
    public LetterVO manageInvoiceLetter(LetterVO letterVO, LetterVO[] letterVOs, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * 
     * [Bank detail & Signature Office]을 [조회 Get]합니다.<br>
     *
     * @param   LetterVO letterVO
     * @throws  EventException
     * @return  List<LetterVO>
     * @author  jang kang cheol
     */ 
   public List<LetterVO> searchOfficeCd(LetterVO letterVO) throws EventException;    
   
   /**
    * 
    * [Bank detail & Signature의  User Nm]을 [조회 Get]합니다.<br>
    * @param  LetterVO letterVO
    * @throws  EventException
    * @return  List<LetterVO>
    * @author  jang kang cheol
    */ 
   public List<LetterVO> searchUserNm(LetterVO letterVO) throws EventException;  
 
    /**
     * [Bank detail & detail]을 [조회 Retrieve]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List<LetterVO>
     * @author jang kang cheol
     */
    public List<LetterVO> searchSignNBank(LetterVO letterVO) throws EventException;    
    /**
     * [Bank detail & detail]을 [저장  Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return LetterVO letterVO
     * @author jang kang cheol
     */
    public LetterVO addSignNBank(LetterVO letterVO) throws EventException;
    
    /**
     * [Bank detail & detail]을 [삭제 Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void removeSignNBank(LetterVO letterVO) throws EventException;
    
    /**
     * Seq코드 정보를 읽어온다.
     * @param String joLtrTpCd
     * @param String ofcCd
     * @param String userId
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchTempalteSeqList(String joLtrTpCd, String ofcCd, String userId) throws EventException;    
    
    /**
     * [MCS Letter Information Creation JOO_LETTER]을 [조회 Saved Retrieve]합니다.
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchJooLetter(LetterVO letterVO) throws EventException;  
    
    
    /**
     * [MCS Letter Information Creation JOO_LTR_STL]을 [조회 Saved Retrieve]합니다.
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchJooLtrStl(LetterVO letterVO) throws EventException; 
 
    /**
     * 
     * 파일정보를 조회합니다.<br>
     *
     * @param  FileInfoVO fileInfoVO
     * @throws EventException
     * @return List<FileInfoVO>
     * @author jang kang cheol
     */
    //지우지 말것 추가 요구건.  public List<FileInfoVO> searchAttchFile(FileInfoVO fileInfoVO) throws EventException;
    
    /**
     * 
     * [Invoice Letter Information Creation의 Ltr Stl 정보를 ]을 [조회 Retrieve]합니다.<br>
     *
     * @param   InvoiceCombinedVO invoiceCombinedVO
     * @throws  DAOException
     * @return  List<InvoiceCombinedVO>
     * @author  jang kang cheol
     */ 
   public List<InvoiceCombinedVO> searchSavedJooLtrStl(InvoiceCombinedVO invoiceCombinedVO) throws EventException;
  
	/**
	 * PIC of User 정보를 조회합니다.<br>
	 * 
	 * @param String joCntcPicId
	 * @return PicOfUserInfoVO
	 * @exception EventException
	 */
	public PicOfUserInfoVO searchPicUserIdInfo(String joCntcPicId) throws EventException;
   
}