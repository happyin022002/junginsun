/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ClaimMainBCImpl.java
 *@FileTitle : Container Cargo Claim 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 *  ------------------------------------------------------------------
 * 2011.6.2 표준희 [CHM-201111326-01]
 * 1.제목 : Transfer 시 Handler 정보 Update Logic
 * 2.처리내역
 *   Transfer 화면에서 데이터 변경후 저장시 Claim Main쪽에서 Accept일때만 저장가능하도록 변경    
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainEAIDAO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.BookingNoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CMSServiceVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmLtgtVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostInfoVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBIndemnityClaimVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBMainClaimVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 * Container Cargo Claim 에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see ClaimMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ClaimMainBCImpl extends BasicCommandSupport implements ClaimMainBC
{

    // Database Access Object
    private transient ClaimMainDBDAO dbDao = null;

    /**
     * ContainerCargoClaimBCImpl 객체 생성<br>
     * ContainerCargoClaimDBDAO 생성한다.<br>
     */
    public ClaimMainBCImpl()
    {
        dbDao = new ClaimMainDBDAO();
    }



    // ===========================================================================
    // 진윤오
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [COM005_R001] GW 웹서비스 승인정보 수신
	// ---------------------------------------------------------------------------	
	
	/**
	 * GW 웹서비스 승인정보 수신시 카고클레임 정보 취득<br>
	 * @author 진윤오
	 * @category COM005_R001
	 * @category searchCargoClaim 
	 * @param String cgoClmNo
	 * @return CniCgoClmVO
	 * @exception EventException
	 */
	public CniCgoClmVO searchCargoClaim(String cgoClmNo) throws EventException {
		try {
			return dbDao.searchCargoClaim(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}	
    
    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0030001] CRM 웹서비스
	// ---------------------------------------------------------------------------	    
	/** 
	 * CRM 웹서비스(EAI)로 전송 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0030001
	 * @category searchCMSService 
	 * @param String cgoClmNo
	 * @exception EventException
	 */
    public void sendCMSService(String cgoClmNo) {
        
        try {     
        	CMSServiceVO vo = dbDao.searchCMSService(cgoClmNo);       	
        	// EAI 전송
        	ClaimMainEAIDAO eaiDao = new ClaimMainEAIDAO();
        	eaiDao.sendCRMData(vo);
        	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
     
    } 		    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0001] Client Default Setup
	// ---------------------------------------------------------------------------	    
	/** 
	 * Area Cd 정보 수정,등록<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category manageAreaOfc
	 * @param CniAreaOfcVO cniAreaOfcVO
	 * @exception EventException
	 */
	public void manageAreaOfc(CniAreaOfcVO cniAreaOfcVO) throws EventException {

		try {		
			
			// office code
			String ofcCd = cniAreaOfcVO.getOfcCd();
			
			CniAreaOfcVO vo = dbDao.searchAreaCd(ofcCd);
			
			if (vo == null) {
				dbDao.addAreaOfc(cniAreaOfcVO);
			} else {
				// 갱신 처리
				dbDao.modifyAreaOfc(cniAreaOfcVO);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}		
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0043] Impending TB Claim
	// ---------------------------------------------------------------------------	
	/**
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBMainClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBMainClaimVO>
     * @throws EventException
     */
    public List<ImpendingTBMainClaimVO> searchImpendingTBMainClaimList(String usrId , String condFor) throws EventException {
      
        try {     
            return dbDao.searchImpendingTBMainClaimList(usrId, condFor);            
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
       
    } 
    
	/**
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBIndemnityClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBIndemnityClaimVO>
     * @throws EventException
     */
    public List<ImpendingTBIndemnityClaimVO> searchImpendingTBIndemnityClaimList(String usrId , String condFor) throws EventException {
        
        try {    
            return dbDao.searchImpendingTBIndemnityClaimList(usrId, condFor);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
       
    }    
    // ===========================================================================
    // 양정란
    // ===========================================================================

    // ---------------------------------------------------------------------------
    // [CPS_CNI_0002] Find
    // ---------------------------------------------------------------------------
	/**
	 * Find 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0002
	 * @category searchFindList 
	 * @param FindCondVO FindCondVO
     * @return List<FindVO> 
     * @throws EventException
     */	
	public List<FindVO> searchFindList(FindCondVO findCondVO) throws EventException {
		try {
			
			List<FindVO> returnList = new ArrayList<FindVO>();
			
			returnList = dbDao.searchFindList(findCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				FindVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0008] Payment
    // ---------------------------------------------------------------------------
	/**
	 * Payment 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category searchPaymentInfo 
	 * @param String cgoClmNo
     * @return List<PaymentVO> 
     * @throws EventException
     */	
	public List<PaymentVO> searchPaymentInfo(String cgoClmNo) throws EventException {
		try {
			
			List<PaymentVO> returnList = new ArrayList<PaymentVO>();
			
			returnList = dbDao.searchPaymentInfo(cgoClmNo);
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}	
	
	/** 
	 * Payment Remark 변경<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category managePayment 
	 * @param PaymentVO paymentVO
	 * @exception EventException
	 */
	public void managePayment(PaymentVO paymentVO) throws EventException {
		try {		
			dbDao.managePayment(paymentVO);
			
			//settlement date 가 있고 , 현 상태가 V(Settlement Application Approval)인 경우  Status = 'P'로  변경.
			if(!paymentVO.getCgoClmStlDt().equals("") && paymentVO.getCgoClmStsCd().equals("V")){
				CniCgoClmVO cniCgoClmVO = new CniCgoClmVO();
				cniCgoClmVO.setCgoClmNo(paymentVO.getCgoClmNo());
				cniCgoClmVO.setCgoClmStsCd("P");
				cniCgoClmVO.setCgoClmClzCd("O");//O:미결, C:종결, X:취소
				cniCgoClmVO.setUpdUsrId(paymentVO.getUpdUsrId());
				
				modifyClaimStatus(cniCgoClmVO);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0036] Transfer
    // ---------------------------------------------------------------------------
	/**
	 * Transfer 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO> 
     * @throws EventException
     */	
	public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws EventException {
		try {
			
			List<TransferVO> returnList = new ArrayList<TransferVO>();
			
			returnList = dbDao.searchTransferList(transferCondVO);
			
			if (returnList != null && !returnList.isEmpty()) {
				TransferVO vo = returnList.get(0);
				int maxRows = Integer.parseInt(vo.getTotal());
				vo.setMaxRows(maxRows);
			}			
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}
	
    /**
	 * Transfer 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category manageTransfer
	 * @param TransferVO[] transferVOs
	 * @exception EventException
	 */
	public void manageTransfer(TransferVO[] transferVOs) throws EventException {		
		
		try{
			
			if (transferVOs != null) {				
				for (int i = 0; i < transferVOs.length; i++) {
					TransferVO transferVO = transferVOs[i];
										
					String ibflag = transferVO.getIbflag();					
					if ("U".equals(ibflag)) {
						dbDao.modifyTransfer(transferVO);
						
						// Main 에 Update
						dbDao.modifyTransferClaimMain(transferVO.getCgoClmNo() , transferVO.getUpdUsrId() , transferVO.getTrnsToUsrId(), transferVO.getTrnsToOfcCd(), transferVO.getClmTrnsAuthCd() );
						
						if(transferVO.getDiv().equals("TO")&& transferVO.getClmTrnsAuthCd().equals("A")){
							// HandlerHistory에 저장		
							CodeMgtBC codeMgtBC = new CodeMgtBCImpl();
							HandlerHistoryVO handlerHistoryVO = new HandlerHistoryVO();
							handlerHistoryVO.setCgoClmNo(transferVO.getCgoClmNo());
							handlerHistoryVO.setUpdUsrId(transferVO.getUpdUsrId());
							handlerHistoryVO.setCreUsrId(transferVO.getUpdUsrId());
							handlerHistoryVO.setHdlrOfcCd(transferVO.getTrnsToOfcCd());
							handlerHistoryVO.setHdlrUsrId(transferVO.getTrnsToUsrId());
							handlerHistoryVO.setCgoClmStsCd(transferVO.getClmMiscCd());
							
							
							
							codeMgtBC.manageHandlerHistory(handlerHistoryVO, transferVO.getClmMiscCd());
						}
					} 				
				}
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}		
	}
	
	// ---------------------------------------------------------------------------
    // [CPS_CNI_0009] Handling Costs
    // ---------------------------------------------------------------------------
	/**
	 * Handling Costs 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostList 
	 * @param String cgoClmNo
     * @return List<HandlingCostVO> 
     * @throws EventException
     */	
	public List<HandlingCostVO> searchHandlingCostList(String cgoClmNo) throws EventException {
		try {
			
			List<HandlingCostVO> returnList = new ArrayList<HandlingCostVO>();
			
			returnList = dbDao.searchHandlingCostList(cgoClmNo);
			
			return returnList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}	
	
	/**
	 * Handling Costs 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostInfo 
	 * @param String cgoClmNo
     * @return HandlingCostInfoVO
     * @throws EventException
     */	
	public HandlingCostInfoVO searchHandlingCostInfo(String cgoClmNo) throws EventException {
		try {
			
			return dbDao.searchHandlingCostInfo(cgoClmNo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}
	}		
	
    /**
	 * Handling Costs 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category manageHandlingCost
	 * @param CniCgoClmCostVO[] cniCgoClmCostVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageHandlingCost(CniCgoClmCostVO[] cniCgoClmCostVOs) throws EventException {		
		
		try{
			
			String cgoClmNo = "";
			String updateSurveyFlag = "N";
			String existClaimNo = "";
			String errMsg = "N";
			
			if (cniCgoClmCostVOs != null) {				
				for (int i = 0; i < cniCgoClmCostVOs.length; i++) {
					CniCgoClmCostVO cniCgoClmCostVO = cniCgoClmCostVOs[i];
										
					String ibflag = cniCgoClmCostVO.getIbflag();
					
					cniCgoClmCostVO.setInvXchRt(cniCgoClmCostVO.getInvXchRt().replaceAll(",", ""));
					
					cgoClmNo = cniCgoClmCostVO.getCgoClmNo();
					if ("I".equals(ibflag)) {
						dbDao.addHandlingCost(cniCgoClmCostVO);
					} else if ("U".equals(ibflag)) {
						dbDao.modifyHandlingCost(cniCgoClmCostVO);
					} else if ("D".equals(ibflag)) {
						dbDao.removeHandlingCost(cniCgoClmCostVO);
					}
					
					if(cniCgoClmCostVO.getClmCostTpCd().equals("SS") || cniCgoClmCostVO.getClmCostTpCd().equals("SP") ||cniCgoClmCostVO.getClmCostTpCd().equals("SC")){
						updateSurveyFlag = "Y";
					}
				}
				
				//CLM_COST_TP_CD = 'S'인경우 Survey(CNI_CGO_CLM_SVEY) 의 SVYR_FEE_USD_AMT 값을 변경한다.
				if(updateSurveyFlag.equals("Y")){
					existClaimNo = dbDao.searchClaimExist(cgoClmNo, "CNI_CGO_CLM_SVEY");
					
					// Claim NO가 존재하면("Y")
					if (existClaimNo != null && existClaimNo.trim().equals("Y")) {
						dbDao.modifySurveyUsdAmt(cgoClmNo);
					}else{
						errMsg = "Y";//화면Error 처리로 변경.
//						throw new EventException(new ErrorHandler("CNI00020",new String[]{"Survey Data"}).getMessage()); 
					}
				}
			}
			
			return errMsg;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}		
	}
	
    /**
	 * Handling Costs 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0045
	 * @category manageHandlingCostInvRgstNo
	 * @param CniCgoClmCostVO cniCgoClmCostVO
	 * @exception EventException
	 */
	public void manageHandlingCostInvRgstNo(CniCgoClmCostVO cniCgoClmCostVO) throws EventException {		
		
		try{
			
			if (cniCgoClmCostVO != null) {				
				dbDao.modifyHandlingCostInvRgstNo(cniCgoClmCostVO);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage());
		}		
	}	

	// ===========================================================================
    // 정행룡
    // ===========================================================================
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0003] Claim Main
    // ---------------------------------------------------------------------------	
    
	/** 
	 * Claim Main 정보 수정,등록<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMain 
	 * @param ClaimMainCntVO claimMainCntVO
	 * @return ClaimMainCntVO
	 * @exception EventException
	 */
	public ClaimMainCntVO manageClaimMain(ClaimMainCntVO claimMainCntVO) throws EventException {

		try {		
			
			CniCgoClmVO        cniCgoClmVO      = claimMainCntVO.getCniCgoClmVO();
			CniCgoClmLtgtVO    cniCgoClmLtgtVO  = claimMainCntVO.getCniCgoClmLtgtVO();
			CniCgoClmCtrtVO    cniCgoClmCtrtVO  = claimMainCntVO.getCniCgoClmCtrtVO();
			CniCgoClmBlDtlVO   cniCgoClmBlDtlVO = claimMainCntVO.getCniCgoClmBlDtlVO();
			CniCgoClmTrnsVO    cniCgoClmTrnsVO  = claimMainCntVO.getCniCgoClmTrnsVO();
			
			// Claim No
			String cgoClmNo = cniCgoClmVO.getCgoClmNo();
			
			String existClaimNo = dbDao.searchClaimExist(cgoClmNo, "CNI_CGO_CLM");
			// Claim NO가 존재하면("Y")
			if (existClaimNo != null &&  existClaimNo.equals("Y")) {
				// 갱신 처리
				dbDao.modifyClaimMain(cniCgoClmVO);
				dbDao.modifyClaimLitigation(cniCgoClmLtgtVO);
				if (!cniCgoClmVO.getBfrCgoClmStsCd().equals(cniCgoClmVO.getCgoClmStsCd())){
					//CRM시스템에 해당데이타 전송
					//2017.12.05 CRM 호출 삭제
					//sendCMSService(cniCgoClmVO.getCgoClmNo());
				}
			} else {
				cgoClmNo = dbDao.searchMaxClaimNo();        // "CC" + 해당년도(YYYY)+ MAX SEQ(4자리)를 가져옴
				cniCgoClmVO.setCgoClmNo(cgoClmNo);          // CniCgoClmVO의 Claim No에 셋팅
				claimMainCntVO.setCniCgoClmVO(cniCgoClmVO); // CaimMainCntVO에 CniCgoClmVO을 세팅
				dbDao.addClaimMain(cniCgoClmVO);            // CNI_CGO_CLM 테이블에 데이터 INSERT
				
				//CRM시스템에 해당데이타 전송
				//2017.12.05 CRM 호출 삭제
				//sendCMSService(cniCgoClmVO.getCgoClmNo());
			}
			
			existClaimNo = dbDao.searchClaimExist(cgoClmNo, "CNI_CGO_CLM_LTGT");
			// Claim NO가 존재하면("Y")
			if (existClaimNo != null && existClaimNo.equals("Y")) {
				// 갱신 처리
				dbDao.modifyClaimLitigation(cniCgoClmLtgtVO);
			} else {
				cniCgoClmLtgtVO.setCgoClmNo(cgoClmNo);      // CniCgoClmLtgtVO의 새로 생성된 Claim No에 셋팅
				dbDao.addClaimLitigation(cniCgoClmLtgtVO);  // CNI_CGO_CLM_LTGT 테이블에 데이터 INSERT 
			}
			
			// Claim Contract 처리
			existClaimNo = dbDao.searchClaimExist(cgoClmNo, "CNI_CGO_CLM_CTRT");
			// Claim NO가 존재하면("Y")
			if (existClaimNo != null && existClaimNo.equals("Y")) {
				dbDao.modifyClaimMainContractCarriage(cniCgoClmCtrtVO);
			} else {
				cniCgoClmCtrtVO.setCgoClmNo(cgoClmNo); 
				dbDao.addContractCarriage(cniCgoClmCtrtVO); // CNI_CGO_CLM_CTRT 테이블에 데이터 INSERT
			}
			// Claim B/L Detail 처리
			existClaimNo = dbDao.searchClaimExist(cgoClmNo, "CNI_CGO_CLM_BL_DTL");
			// Claim NO가 존재하면("Y")
			if (existClaimNo != null && existClaimNo.equals("Y")) {
				dbDao.modifyBlDetail(cniCgoClmBlDtlVO);
			} else {
				cniCgoClmBlDtlVO.setCgoClmNo(cgoClmNo);
				cniCgoClmBlDtlVO.setMnBlFlg("Y");
				dbDao.addBlDetail(cniCgoClmBlDtlVO); //CNI_CGO_CLM_BL_DTL 테이블에 데이터 INSERT
			}
			
			//Transfer 가 체크("Y")되면 
			String trnsFlg = cniCgoClmVO.getTrnsFlg();
			String clmTrnsAuthCd = cniCgoClmTrnsVO.getClmTrnsAuthCd();
			cniCgoClmTrnsVO.setTrnsFmOfcCd(cniCgoClmVO.getHdlrOfcCd());
			cniCgoClmTrnsVO.setTrnsFmUsrId(cniCgoClmVO.getHdlrUsrId());

			if (trnsFlg.equals("Y") && clmTrnsAuthCd.equals("") ){
				dbDao.addTransfer(cniCgoClmTrnsVO);
			} else if (trnsFlg.equals("") && (clmTrnsAuthCd.equals("W") || clmTrnsAuthCd.equals("R")) ){
				dbDao.removeTransfer(cniCgoClmTrnsVO);
			}
			
			return claimMainCntVO;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/** 
	 * Claim ReOpen 변경(ReOpen 처리)<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimReOpen 
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @param String cgoClmStlTpCd
	 * @exception EventException
	 */
	public void modifyClaimReOpen(String cgoClmNo , String updUsrId , String cgoClmStlTpCd) throws EventException {
		try {		
			dbDao.modifyClaimReOpen(cgoClmNo , updUsrId, cgoClmStlTpCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/** 
	 * Claim Status 변경(Cancel 처리)<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimStatus 
	 * @param CniCgoClmVO cniCgoClmVO
	 * @exception EventException
	 */
	public void modifyClaimStatus(CniCgoClmVO cniCgoClmVO) throws EventException {
		try {		
			dbDao.modifyClaimStatus(cniCgoClmVO);
			
			//CRM시스템에 해당데이타 전송
			//2017.12.05 CRM 호출 삭제
			//sendCMSService(cniCgoClmVO.getCgoClmNo());
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/** 
	 * Claim Status 이전 단계 변경<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category modifyClaimPreStatus
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @exception EventException
	 */
	public void modifyClaimPreStatus(String cgoClmNo , String updUsrId) throws EventException {
		try {		
			dbDao.modifyClaimPreStatus(cgoClmNo , updUsrId );
			
			//CRM시스템에 해당데이타 전송
			//2017.12.05 CRM 호출 삭제
			//sendCMSService(cgoClmNo);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Claim Status 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category searchClaimStatus
	 * @param String cgoClmNo 
	 * @return String status code
     * @throws EventException
     */
   public String searchClaimStatus(String cgoClmNo) throws EventException {
    	try {
			return dbDao.searchClaimStatus(cgoClmNo);
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
    	
    }	
	
	/**
	 * Claim Main 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimMain
	 * @param String cgoClmNo
     * @return ClaimMainVO 
     * @throws EventException
     */
	public ClaimMainVO searchClaimMain(String cgoClmNo) throws EventException {
    	try {
			return dbDao.searchClaimMain(cgoClmNo);
    	} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
    	
    }

    /**
	 * Area Cd 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchAreaCd
	 * @param String ofcCd
     * @return CniAreaOfcVO
     * @throws EventException
     */
	public CniAreaOfcVO searchAreaCd(String ofcCd) throws EventException {
		try {
			return dbDao.searchAreaCd(ofcCd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * B/L 정보 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGetChk
	 * @param String cgoClmRefBlNo
     * @return String
     * @throws EventException
     */
	public String searchBlGetChk(String cgoClmRefBlNo) throws EventException {
		try {
			return dbDao.searchBlGetChk(cgoClmRefBlNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * B/L 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGet
	 * @param String cgoClmRefBlNo
     * @return BlGetVO
     * @throws EventException
     */
	public BlGetVO searchBlGet(String cgoClmRefBlNo) throws EventException {
		try {
			return dbDao.searchBlGet(cgoClmRefBlNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	
    // ===========================================================================
    // 박제성
    // ===========================================================================

	/**
	 * ContractCarriage 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo
	 * @return ContractCarriageVO
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public ContractCarriageVO searchContractCarriageInfo(String cgoClmNo) throws EventException {
		try {
			return dbDao.searchContractCarriageInfo(cgoClmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ContractCarriage BL Get <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet
	 * @return ContractCarriageVO
	 * @param String cgoClmNo
	 * @param String blNo
	 * @param String bkgNo
	 * @exception EventException
	 */
	
	public ContractCarriageVO searchContractCarriageBLGet(String cgoClmNo,String blNo,String bkgNo) throws EventException {
		try {
			
			ContractCarriageVO ccVO = dbDao.searchContractCarriageBLGet1(blNo);
			
			//  Shipper
			ContractCarriageVO ccVO2 = dbDao.searchContractCarriageBLGet2(bkgNo);
			ccVO.setShprNm(ccVO2.getShprNm());
			
			//  Consignee
			ContractCarriageVO ccVO3 = dbDao.searchContractCarriageBLGet3(bkgNo);
			ccVO.setCneeNm(ccVO3.getCneeNm());
			
			//  NOTIFY
			ContractCarriageVO ccVO4 = dbDao.searchContractCarriageBLGet4(bkgNo);
			ccVO.setNtfyNm(ccVO4.getNtfyNm());
			
			// CGO_QLTY_DESC   
			ContractCarriageVO ccVO5 = dbDao.searchContractCarriageBLGet5(cgoClmNo);
			ccVO.setCgoQltyDesc(ccVO5.getCgoQltyDesc());
			
			//  Freight      CLM_OFRT_AMT
			ContractCarriageVO ccVO6 = dbDao.searchContractCarriageBLGet6(bkgNo);
			ccVO.setClmOfrtAmt(ccVO6.getClmOfrtAmt());
			
			//pre-vvd
			ContractCarriageVO ccVO7 = dbDao.searchContractCarriageBLGet7(bkgNo);
			if(ccVO7!=null) {	
				ccVO.setN1stPreRefVvdNo(ccVO7.getN1stPreRefVvdNo());
				ccVO.setN2ndPreRefVvdNo(ccVO7.getN2ndPreRefVvdNo());
				ccVO.setN3rdPreRefVvdNo(ccVO7.getN3rdPreRefVvdNo());
			}
			
			// on-vvd
			ContractCarriageVO ccVO8 = dbDao.searchContractCarriageBLGet8(bkgNo);
			
			if(ccVO8!=null) {	
				ccVO.setN1stPstRefVvdNo(ccVO8.getN1stPstRefVvdNo());	
				ccVO.setN2ndPstRefVvdNo(ccVO8.getN2ndPstRefVvdNo());	
			    ccVO.setN3rdPstRefVvdNo(ccVO8.getN3rdPstRefVvdNo());	
			}		
			
			return ccVO;
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ClaimBlDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimBlDetailList
	 * @return List<CniCgoClmBlDtlVO>  
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmBlDtlVO> searchClaimBlDetailList(String cgoClmNo) throws EventException {
		try {
			return dbDao.searchClaimBlDetailList(cgoClmNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ClaimContractDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimContractDetailList
	 * @return List<CniCgoClmCntrDtlVO>  
	 * @param String cgoClmNo
	 * @param String cgoClmRefBlNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmCntrDtlVO> searchClaimContractDetailList(String cgoClmNo, String cgoClmRefBlNo) throws EventException {
		try {
			return dbDao.searchClaimContractDetailList(cgoClmNo,cgoClmRefBlNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * ClaimContractDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimContractBLGetDetailList
	 * @return List<CniCgoClmCntrDtlVO>  
	 * @param String cgoClmNo
	 * @param String blNo
	 * @param String bkgNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmCntrDtlVO> searchClaimContractBLGetDetailList(String cgoClmNo,String blNo,String bkgNo) throws EventException {
		try {
			return dbDao.searchClaimContractBLGetDetailList(cgoClmNo,blNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ContractCarriage 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageContractCarriage
	 * @return String 
	 * @param CniCgoClmCtrtVO cniCgoClmCtrtVO
	 * @param CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs
	 * @param CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs
	 * @exception EventException
	 */
	
	public String manageContractCarriage(CniCgoClmCtrtVO cniCgoClmCtrtVO, CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs, 
											CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs) throws EventException {
		try {
			String manageStr="";
						
			String exist = dbDao.searchContractCarriageExist(cniCgoClmCtrtVO.getCgoClmNo());

			if (exist.equals("MS")) {
				dbDao.modifyContractCarriage(cniCgoClmCtrtVO);// 존재하면
				
			}else if ( exist.equals("M")||exist.equals("") ) {
				manageStr = "N";
				return manageStr;
			}
			
			
			if ( (exist.equals("MS")) ) {
				
				if (cniCgoClmBlDtlVOs != null) {				
					for (int i = 0; i < cniCgoClmBlDtlVOs.length; i++) {
						CniCgoClmBlDtlVO cniCgoClmBlDtlVO = cniCgoClmBlDtlVOs[i];
											
						String ibflag = cniCgoClmBlDtlVO.getIbflag();					
						if ("I".equals(ibflag)) {
							dbDao.addBlDetail(cniCgoClmBlDtlVO);

						} else if ("D".equals(ibflag)) {
							dbDao.removeBlDetail(cniCgoClmBlDtlVO);
						}					
					}//for
				}//if
				
				
				if (cniCgoClmCntrDtlVOs != null) {				
					for (int i = 0; i < cniCgoClmCntrDtlVOs.length; i++) {
						CniCgoClmCntrDtlVO cniCgoClmCntrDtlVO = cniCgoClmCntrDtlVOs[i];
											
						String ibflag = cniCgoClmCntrDtlVO.getIbflag();					
						if ("I".equals(ibflag)) {
							String cnt = dbDao.searchContractCarriageCntrExist(cniCgoClmCntrDtlVO);
							
							if(cnt.equals("0")){
							
								dbDao.addContractDetail(cniCgoClmCntrDtlVO);
							}
												
						} else if ("D".equals(ibflag)) {
							dbDao.removeContractDetail(cniCgoClmCntrDtlVO);

						}					
					}//for
				}//if
								
			}//if ( (exist[0].equals("MS")) )
			
			manageStr = "Y";
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
	
	/**
	 * ContractCarriage 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageContractCarriageBL
	 * @return String 
	 * @param String cgoClmNo
	 * @param CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs	 
	 * @exception EventException
	 */
	
	public String manageContractCarriageBL(String cgoClmNo, CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs) throws EventException {
		try {
			String manageStr="";
						
			String exist = dbDao.searchContractCarriageExist(cgoClmNo);
			
			if ( (exist.equals("MS")) ) {
				
				if (cniCgoClmBlDtlVOs != null) {				
					for (int i = 0; i < cniCgoClmBlDtlVOs.length; i++) {
						CniCgoClmBlDtlVO cniCgoClmBlDtlVO = cniCgoClmBlDtlVOs[i];
											
						String ibflag = cniCgoClmBlDtlVO.getIbflag();					
						if ("I".equals(ibflag)) {
							dbDao.addBlDetail(cniCgoClmBlDtlVO);

						} else if ("D".equals(ibflag)) {
							dbDao.removeBlDetail(cniCgoClmBlDtlVO);
						}					
					}//for
				}//if
				
													
			}//if ( (exist[0].equals("MS")) )
			
			manageStr = "Y";
			
			return manageStr;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI999999",new String[]{}).getUserMessage(), ex);
		}	
		
	}
	
	/**
	 * Booking No 공통 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchBookingNoInfo
	 * @return BookingNoVO
	 * @param String blNo
	 * @exception EventException
	 */
	
	public BookingNoVO searchBookingNoInfo(String blNo) throws EventException {
		try {
			return dbDao.searchBookingNoInfo(blNo);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999",new String[]{}).getMessage(), ex);
		}
	}


	
}