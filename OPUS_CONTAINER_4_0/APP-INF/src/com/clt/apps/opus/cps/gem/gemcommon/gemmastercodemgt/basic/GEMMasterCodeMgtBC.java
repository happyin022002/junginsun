/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtBC.java
*@FileTitle : Expense Office Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.17 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.basic;

import java.util.List;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInfoMgtVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInqVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInquiryVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseNameVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctExptVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctMtxVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemCngOfcVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfcHisVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemOfficeVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.MdmAccountVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeExptVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeInfoVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.OfficeMgtVO;
import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo.XchRtInqVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * NIS2010-Gemcommon Business Logic Command Interface<br>
 * - NIS2010-Gemcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * NIS2010-GEMMasterCodeMgtBC Business Logic Command Interface<br>
 * - NIS2010-GEMMasterCodeMgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author choijungmi
 * @see Ui_gem_0008EventResponse 참조
 * @since J2EE 1.4
 */

public interface GEMMasterCodeMgtBC {
    
	
    // ===========================================================================
    // J.Y.O
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_GEM-0009] Foreign Exchange Rate Maintenance
    // ---------------------------------------------------------------------------

    /**
     * 비용계획 및 실적집계시 사용할 환율정보를 조회한다<br>
     * 비용계획시 사용할 계획환율 정의하고, 실적(전표)집계를 위한 경리환율 정보를 조회한다<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category searchExchangeRateInfo
     * 
     * @param year
     *            조회년도
     * @param deltFlg
     *            삭제여부
     * @return
     * @throws EventException
     */
    public List<GemXchRtVO>  searchExchangeRateInfo(String year, String deltFlg) throws EventException;

    

    /**
     * 1.Excel 로 작성된 계획환율 Upload <br>
     * 2.Upload 된 Currency Code와 조직별 Currency Code를 비교하여, 누락된 조직별 Currency Code를 표시한다<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category searchCurrencyByOffice
     * 
     * @param inCurrCd
     *           sql in 절 Currency Code List
     * @return
     * @throws EventException
     */
    public String searchCurrencyByOffice(List<String> inCurrCd) throws EventException;
    
    
    /**
     * 일반관리비 비용계획시 사용할 계획환율 정의하고 등록 , 수정 , 삭제 한다<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category manageInitialExchangeRateInfo 
     * @param GemXchRtVO[] gemXchRtVO 
     * @param userId 시용자 ID
     * @throws EventException
     */
    public void manageInitialExchangeRateInfo(GemXchRtVO[] gemXchRtVO  , String userId) throws EventException;
    
    /**
     * Currency Code의 월별 환율을 조회<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category searchMonthlyExchangeRate
     * @param year  환율 계획년
     * @param currCd 통화코드 
     * @return List<GemXchRtVO>
     * @throws EventException
     */
    public List<GemXchRtVO> searchMonthlyExchangeRate(String year , String currCd ) throws EventException;
    
	/**
     * 1.입력된 Currency Code 가 유효한지 체크한다 <br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category checkCurrency
     * @param String year
     * @param String currCd
	 * @return String 결과값 1 정상  2, 키에러   3, 잘못된코드
	 * @exception EventException
	 */
    public String checkCurrency(String year , String currCd ) throws EventException;

    // ---------------------------------------------------------------------------
    // [CPS_GEM_0111] Monthly Accounting Rate Interface
    // ---------------------------------------------------------------------------
    
    /**
	 * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0009
	 * @category createExchangeRateInterface
	 * 
     * @param acctXchRtYrmon 환율 년월
     * @param userId 사용자 ID
     * @return int
     * @throws DAOException
     */
    public int manageExchangeRateInterface(String acctXchRtYrmon , String userId) throws EventException;
    
    
    // ---------------------------------------------------------------------------
    // [CPS_GEM-0007] Expense Code Maintenance
    // ---------------------------------------------------------------------------        
    /**
	 * 일반관리비 비용주관팀으로 정의된 조직코드(Office Code) 정보<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseTICList
     * @return 비용주관팀으로 정의된 조직코드 리스트
     * @throws EventException
     */
    public String[] searchExpenseTICList() throws EventException ;
    
    /**
     * 1.일반관리비 비용코드 기준 정보
     * 2.회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
     * 3.비용실적에 대한 재분배를 위한 예외사항 정보  
     * @param genExpnCd  비용코드
     * @param deltFlg 삭제여부 
     * @return
     * @throws EventException
     */
    public ExpenseInfoMgtVO searchExpenseInfo(String genExpnCd , String deltFlg) throws EventException;    
    
    
	/**
	 * 일반관리비 비용계획 및 실적집계시 사용할 코드 수정<br>
     * 일반관리비 비용계획시 사용할 비용코드(Expense Code) 정의하고, 실적(전표)집계를 위한 회계코드(Account Code)를 매핑, 실적(전표)재분배를 위한 코드정의를 한다<br>
     * GEM00007 에러코드
	 * @param ExpenseInfoMgtVO expenseInfoMgtVO
	 * @throws EventException
	 */
	public void manageExpenseInfo(ExpenseInfoMgtVO expenseInfoMgtVO)
			throws EventException ;
	
	
    /**
	 * 회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountInfo
	 * 
     * @param genExpnCd  비용코드
     * @param deltFlg  삭제여부
     * @return
     * @throws EventException
     */
	public List<GemAcctMtxVO> searchAccountInfo(String genExpnCd, String deltFlg)
			throws EventException ;
	
    /**
     * 회계코드(Account Code)가 사용되는 코드인지를 체크하고, 영문약어명과 한글약어명 조회
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAccountName
	 * 
     * @param acctCd  회계코드
     * @return
     * @throws EventException
     */
    public MdmAccountVO searchAccountName (String acctCd )  throws EventException ;
 	
	
    /**
     * 일반관리비 비용코드의 Group Level[1st, 2nd, 3rd, Final]에 해당하는 Parent Code 리스트 조회<br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseParentList
	 * 
     * @param genExpnGrpLvl  Parent Code(Expense Code) 리스트
     * @return Parent Code(Expense Code) 리스트
     * @throws EventException
     */
    public List<GemExpenseVO> searchExpenseParentList  (String genExpnGrpLvl)  throws EventException ;
    
    
    
    /**
     * 일반관리비 비용코드(Expense Code) 의 한글약어명, 영문약어명, 비용주관팀을 조회한다<br> 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchExpenseName
	 * 
     * @param genExpnCd  일반관리비 비용코드(Expense Code)
     * @return ExpenseNameVO 
     * @throws EventException
     */
    public ExpenseNameVO searchExpenseName(String genExpnCd)  throws EventException ;
    
    
    /**
	 * 비용실적에 대한 재분배를 위한 예외사항 정보<br>
	 * ( 특정조직(SELTDA) 에서 회계코드(Account Code)의 실적을 발생시킬때, 매핑된 일반관리비 비용코드(Expense Code)로 집계하지않고,<br> 
     * 정의된 비용코드(Expense Code)로 집계 ) <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchDividedOfficeInfo
	 * 
     * @param genExpnCd  비용코드
     * @param deltFlg  삭제여부
     * @return
     * @throws EventException
     */
    public List<GemAcctExptVO> searchDividedOfficeInfo (String genExpnCd , String deltFlg )  throws EventException ;
            
    /**
     * 계정코드 존재 여부 체크
     * 계정코드 미존재(신규)  == 0
     * 삭제 계정코드 존재 == > 1
	 * 사용중 계정코드 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
     * @param acctCd 계정코드 
     * @return
     * @throws DAOException
     */
    public String[] searchAcctCheck(String acctCd) throws EventException;    
    
    /**
     * 오피스코드 존재 여부 체크
     * 오피스코드 미존재(신규)  == 0
     * 삭제 오피스코드 존재 == > 1
	 * 사용중 오피스코드 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
     * @param ofcCd 오피스코드 
     * @return 체크코드
     * @throws EventException
     */
    public String searchOfcCheck(String ofcCd) throws EventException;    
    
    /**
     * 분리되어야 할 Budget Code 존재 여부 체크
     * 분리되어야 할 Budget Code 미존재(신규)  == 0
     * 삭제 분리되어야 할 Budget Code 존재 == > 1
	 * 사용중 분리되어야 할 Budget Code 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchGenExpnCheck 
     * @param String ofcCd
     * @param String genExpnCd 
     * @param String acctCd
	 * @return 체크코드
	 * @throws EventException
     */    
    public String searchGenExpnCheck(String ofcCd, String genExpnCd, String acctCd) throws EventException;    
    
    // ===========================================================================
    // C.J.M
    // ===========================================================================

    // ---------------------------------------------------------------------------
	// [CPS_GEM_0010] Expense Code Inquiry
	// ---------------------------------------------------------------------------

    /**
     * Open 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0010
     * @category searchExpenseList
     * @return List<GemExpenseVO>
     * @exception EventException
     */
    public List<GemExpenseVO> searchExpenseList() throws EventException;
    
    /**
     * Open 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0010
     * @category searchAccountList
     * @return List<GemAcctMtxVO>
     * @exception EventException
     */
    public List<GemAcctMtxVO> searchAccountList() throws EventException;
    
    /**
     * Open 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0010
     * @category searchGroupListByExpense
     * @return List<GemExpenseVO>
     * @exception EventException
     */
    public List<GemExpenseVO> searchGroupListByExpense() throws EventException;
    
    /**
     * CPS_GEM_0010 조회 이벤트 처리<br>
	 * CPS_GEM_0010 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0010
     * @category searchExpenseInq
     * 
     * @param ExpenseInqVO expenseInqVO
     * @return List<ExpenseInquiryVO>
     * @exception EventException
     */
    public List<ExpenseInquiryVO> searchExpenseInq(ExpenseInqVO expenseInqVO) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0011] Expense Office Inquiry
	// ---------------------------------------------------------------------------
    
    /**
     * CPS_GEM_0011의 SUMUP OFFICE코드 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0011
     * @category searchSumUpListByOffice
     *  
     * @return String[]
     * @exception EventException
     */
    public String[] searchSumUpListByOffice() throws EventException;
    
    /**
     * CPS_GEM_0011 조회 이벤트 처리<br>
	 * CPS_GEM_0011 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0011
     * @category searchOfficeInfo
     * 
     * @param OfficeMgtVO officeMgtVO
     * @return List<GemOfficeVO>
     * @exception EventException
     */
    public List<GemOfficeVO> searchOfficeInfo(OfficeMgtVO officeMgtVO) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0012] Foreign Exchange Rate Inquiry
	// ---------------------------------------------------------------------------
    
    /**
     * CPS_GEM_0012의 Open시 Currency Code 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0012
     * @category searchCurrencyList
     * 
     * @param year
     * @return String[]
     * @exception EventException
     */
    public String[] searchCurrencyList(String year) throws EventException;
    
    /**
     * CPS_GEM_0012의 Open시 USD Rate 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0012
     * @category searchUsdRate
     * 
     * @param year
     * @return String
     * @exception EventException
     */
    public String searchUsdRate(String year) throws EventException;
    
    /**
     * CPS_GEM_0012 조회 이벤트 처리<br>
	 * CPS_GEM_0012 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0012
     * @category searchExchangeRateInq
     * 
     * @param String acctXchRtYrmon
     * @param String currCds
     * @return List<GemOfficeVO>
     * @exception EventException
     */
    public List<XchRtInqVO> searchExchangeRateInq(String acctXchRtYrmon, String currCds) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0013] Expense Matrix per Office
	// ---------------------------------------------------------------------------
    
    /**
     * CPS_GEM_0013 (Office)조회 이벤트 처리<br>
	 * CPS_GEM_0013 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0013
     * @category searchOfficeExpenseMatrix
     * 
     * @param OfficeMgtVO officeMgtVO
     * @return List<OfficeInfoVO>
     * @exception EventException
     */
    public List<OfficeInfoVO> searchOfficeExpenseMatrix(OfficeMgtVO officeMgtVO) throws EventException;
    
    /**
     * CPS_GEM_0013 (Expense)조회 이벤트 처리<br>
	 * CPS_GEM_0013 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0013
     * @category searchOfficeExpenseMatrixListByExpense
     * 
     * @param OfficeMgtVO officeMgtVO
     * @return List<OfficeInfoVO>
     * @exception EventException
     */
    public List<OfficeInfoVO> searchOfficeExpenseMatrixListByExpense(OfficeMgtVO officeMgtVO) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0008_01] Expense Office Maintenance - Office Code
	// ---------------------------------------------------------------------------
    
    /**
	 * CPS_GEM_0008_01 멀티 이벤트 처리<br>
	 * CPS_GEM_0008_01 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0008_01
     * @category manageOfficeInfo
     * 
	 * @param GemOfficeVO[] gemOfficeVOs
	 * @exception EventException
	 */
    public void manageOfficeInfo(GemOfficeVO[] gemOfficeVOs) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0109] Office code history
	// ---------------------------------------------------------------------------
    
    /**
     * CPS_GEM_0109 (Expense)조회 이벤트 처리<br>
	 * CPS_GEM_0109 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0109
     * @category searchOfficeHistoryInfo
     * 
     * @param ofcCd
     * @return List<GemOfcHisVO>
     * @exception EventException
     */
    public List<GemOfcHisVO> searchOfficeHistoryInfo(String ofcCd) throws EventException;
    
    /**
     * CPS_GEM_0109 의 Ofc_Code에 해당하는 Ctr_Code 조회<br>
	 * CPS_GEM_0109 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0109
     * @category searchOfficeHistoryInfoByCtrCode
     * 
     * @param ofcCd
     * @return List<GemOfcHisVO>
     * @exception EventException
     */
    public String searchOfficeHistoryInfoByCtrCode(String ofcCd) throws EventException;
    
    /**
	 * CPS_GEM_0110 멀티 이벤트 처리<br>
	 * CPS_GEM_0110 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0110
     * @category manageOfficeHistoryInfo
     * 
	 * @param GemOfcHisVO[] gemOfcHisVOs
	 * @exception EventException
	 */
    public void manageOfficeHistoryInfo(GemOfcHisVO[] gemOfcHisVOs) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0008_02] Expense Office Maintenance - Expense Matrix per Office
	// ---------------------------------------------------------------------------
    
    /**
     * Expense Code 사용여부를 체크 
 	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category searchExpenseCheck
	 * @param String schGbn 
     * @param String ofcCd
     * @param String genExpnCd 
     * @return String
     * @throws EventException
     */
    public String searchExpenseCheck(String schGbn, String ofcCd, String genExpnCd) throws EventException;
    
    /**
	 * CPS_GEM_0008_02 멀티 이벤트 처리<br>
	 * CPS_GEM_0008_02 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0008_02
     * @category manageOfficeExpenseMatrix
     * 
	 * @param OfficeInfoVO[] officeInfoVOs
	 * @exception EventException
	 */
    public void manageOfficeExpenseMatrix(OfficeInfoVO[] officeInfoVOs) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_0110] Expense Matrix Copy
	// ---------------------------------------------------------------------------
    
    /**
	 * CPS_GEM_0110 멀티 이벤트 처리<br>
	 * CPS_GEM_0110 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0110
     * @category createExpenseCopy
     * 
	 * @param String mtxDiv
	 * @param String fmOfc 
	 * @param String toOfc
	 * @param String userId
	 * @return int
	 * @exception EventException
	 */
	public int createExpenseCopy(String mtxDiv, String fmOfc, String toOfc, String userId) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_03] Expense Office Maintenance - Office Matrix per Office
	// ---------------------------------------------------------------------------
	
	/**
     * CPS_GEM_0008_03의 FROM OFFICE코드 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchFromOffice
     * 
     * @param String rgnOfcFlg
     * @param String deltFlg
     * @return String[]
     * @exception EventException
     */
    public String[] searchFromOffice(String rgnOfcFlg, String deltFlg) throws EventException;
    
    /**
     * CPS_GEM_0008_03의 TO OFFICE코드 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchToOffice
     * 
     * @param String rgnOfcFlg
     * @param String deltFlg
     * @return String[]
     * @exception EventException
     */
    public String[] searchToOffice(String rgnOfcFlg, String deltFlg) throws EventException;
    
    /**
     * CPS_GEM_0008_03 조회 이벤트 처리<br>
	 * CPS_GEM_0008_03 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchOfficeMatrixListByOffice
     * 
     * @param OfficeMgtVO officeMgtVO
     * @return List<OfficeInfoVO>
     * @exception EventException
     */
    public List<OfficeExptVO> searchOfficeMatrixListByOffice(OfficeMgtVO officeMgtVO) throws EventException;
    
    /**
     * CPS_GEM_0008_03의 From ~ To Office Code선택시 해당범위안의 Expense Code를 조회
	 * CPS_GEM_0008_03 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchGroupListByExpense
     * 
     * @param sndOfcCd
     * @param rcvOfcCd
     * @return List<ExpenseNameVO>
     * @exception EventException
     */
    public List<ExpenseNameVO> searchExptListByExpense(String sndOfcCd , String rcvOfcCd) throws EventException;
    
    /**
     * GEM_OFC_EXPT Table에 입력값을 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category searchExptListByDupCheck
	 * 
	 * @param sndOfcCd
     * @param rcvOfcCd
     * @param genExpnCd
	 * @return String 결과값 1 정상  2, 키에러  3, 잘못된코드
	 * @exception EventException
	 */
    public String searchExptListByDupCheck(String sndOfcCd , String rcvOfcCd, String genExpnCd) throws EventException;
    
    /**
	 * CPS_GEM_0008_03 멀티 이벤트 처리<br>
	 * CPS_GEM_0008_03 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_0008_03
     * @category manageOfficeMatrixListByOffice
     * 
	 * @param OfficeExptVO[] officeExptVOs
	 * @exception EventException
	 */
    public void manageOfficeMatrixListByOffice(OfficeExptVO[] officeExptVOs) throws EventException;
    
    // ---------------------------------------------------------------------------
	// [CPS_GEM_9999] Log in Office Change Management
	// ---------------------------------------------------------------------------
	
    /**
     * CPS_GEM_9999 조회 이벤트 처리<br>
	 * CPS_GEM_9999 화면에 대한 조회 이벤트 처리<br>
     * 
     * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChange
     * 
     * @param officeMgtVO
     * @return List<GemCngOfcVO>
     * @exception EventException
     */
    public List<GemCngOfcVO> searchLogInOfficeChange(OfficeMgtVO officeMgtVO) throws EventException;
    
    /**
     * GEM_OFFICE Table에 OFC_CD 존재여부를 체크한다 <br>
     * 
     * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByDupCheck
     * 
     * @param String gubun
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchLogInOfficeChangeByDupCheck(String gubun, String ofcCd) throws EventException;
    
    /**
     * GGEM_CNG_OFC Table에 OFC_CD, CNG_OFC_CD를 중복 체크한다 <br>
     * 
     * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByOfcCdDupCheck
     * 
     * @param String ofcCd
     * @param String cngOfcCd
     * @return String
     * @exception EventException
     */
    public String searchLogInOfficeChangeByOfcCdDupCheck(String ofcCd, String cngOfcCd) throws EventException;
    
    /**
	 * CPS_GEM_9999의 멀티 이벤트 처리<br>
	 * GEMMasterCodeMgt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_9999
     * @category manageLogInOfficeChange
     * 
	 * @param GemCngOfcVO[] gemCngOfcVOs
	 * @exception EventException
	 */    
    public void manageLogInOfficeChange(GemCngOfcVO[] gemCngOfcVOs) throws EventException;
}