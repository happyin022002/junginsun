/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GEMMasterCodeMgtBCImpl.java
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

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration.GEMMasterCodeMgtDBDAO;
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
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-GEMCommon Business Logic Basic Command implementation<br>
 * - NIS2010-GEMCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author choijungmi
 * @see UI_GEM_0008EventResponse,GEMMasterCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GEMMasterCodeMgtBCImpl extends BasicCommandSupport implements GEMMasterCodeMgtBC
{

    // Database Access Object
    private transient GEMMasterCodeMgtDBDAO dbDao = null;

    /**
     * GEMMasterCodeMgtBCImpl 객체 생성<br>
     * GEMMasterCodeMgtDBDAO를 생성한다.<br>
     */
    public GEMMasterCodeMgtBCImpl()
    {
        dbDao = new GEMMasterCodeMgtDBDAO();
    }

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
    public List<GemXchRtVO> searchExchangeRateInfo(String year, String deltFlg) throws EventException {
    	
    	try {    		
    		//계획환율 취득 
    		List<GemXchRtVO> returnList = 
    			dbDao.searchInitialExchangeRate(year, deltFlg);
    		
    		return returnList;    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	
    }

    
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
    public String searchCurrencyByOffice(List<String> inCurrCd) throws EventException {
    	
    	try {    		
    		
    		List<String> list = 
    			dbDao.searchCurrencyByOffice(inCurrCd);
    		
    		if (list == null || list.size() == 0) {
    			return "";
    		}
    		
    		StringBuffer sb = new StringBuffer();
    		for (int i = 0; i < list.size(); i++) {    			
				sb.append("|").append(list.get(i));
			}    		
    		
    		return sb.substring(1);
    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    	
    }
    
    
    /**
     * 일반관리비 비용계획시 사용할 계획환율 정의하고 등록 , 수정 , 삭제 한다<br>
     * 
     * @author JIN YOON OH
     * @category CPS_GEM_0009
     * @category manageInitialExchangeRateInfo
     * 
     * @param GemXchRtVO[] gemXchRtVOs 환율 정보리스트 
     * @param userId 시용자 ID
     * @throws EventException
     */ 
	public void manageInitialExchangeRateInfo(GemXchRtVO[] gemXchRtVOs ,String userId) throws EventException {
			
		try {
			List<GemXchRtVO> addVoList 	  = new ArrayList<GemXchRtVO>();
			List<GemXchRtVO> modifyVoList = new ArrayList<GemXchRtVO>();
			List<GemXchRtVO> removeVoList = new ArrayList<GemXchRtVO>();
			
			for(int i=0; i<gemXchRtVOs.length; i++) {				
				//사용자 설정 
				gemXchRtVOs[i].setCreUsrId(userId);
				gemXchRtVOs[i].setUpdUsrId(userId);
				//플래그 취득 
				String ibFlag = gemXchRtVOs[i].getIbflag();
				
				if("I".equals(ibFlag)) {
					//중복 체크 
					String year = gemXchRtVOs[i].getAcctXchRtYrmon();
					String currCd = gemXchRtVOs[i].getCurrCd();
					//존재하면 UPDATE
					if (dbDao.searchGaeCurrency(year, currCd)) {
						modifyVoList.add(gemXchRtVOs[i]);
						//throw new DAOException("GEM00007");
					} else {
						addVoList.add(gemXchRtVOs[i]);
					}
										
				} else if("U".equals(ibFlag)) {
					modifyVoList.add(gemXchRtVOs[i]);					
				} else if ("D".equals(ibFlag)) {
					removeVoList.add(gemXchRtVOs[i]);
				}
			}
			
			//데이타 입력
			if(addVoList.size() > 0) {				
				dbDao.addInitialExchangeRateInfo(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyInitialExchangeRateInfo(modifyVoList);				
			}
			
			//데이타  삭제
			if(removeVoList.size() > 0) {
				dbDao.removeInitialExchangeRateInfo(removeVoList);				
			}
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}	
				
	}

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
    public List<GemXchRtVO> searchMonthlyExchangeRate(String year , String currCd ) throws EventException {
    	try {
    		//Currency Code의 월별 환율을 조회
			List<GemXchRtVO> monthList = 
				dbDao.searchMonthlyExchangeRate(year, currCd);    		
    		return monthList;    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    
	/**
     * 1.입력된 Currency Code 가 유효한지 체크한다 <br>
	 * 
	 * @author JIN YOON OH
	 * @category CPS_GEM-0009
	 * @category checkCurrency
	 * 
	 * @param String year 
	 * @param String currCd
	 * @return String 결과값 1 정상  2, 키에러   3, 잘못된코드
	 * @exception EventException
	 */
    public String checkCurrency(String year , String currCd ) throws EventException {
    	try {
    		if ( !dbDao.searchGaeCurrency(year, currCd) ) {
    			
    			if ( dbDao.searchMdmCurrency(currCd) ) {
        			return "1";        			
        		} else {
        			return "3";
        		}
    		} else {
    			return "2";
    		}    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
    // ---------------------------------------------------------------------------
    // [CPS_GEM_0111] Monthly Accounting Rate Interface
    // ---------------------------------------------------------------------------
    /**
	 * 일반관리비 비용실적 집계시 USD , KRW , LCL 로 환산하기 위한 경리환율을 I/F 받아 생성한다 <br>
	 * 
	 * @author J.Y.O
	 * @category CPS_GEM_0111
	 * @category manageExchangeRateInterface
	 * 
     * @param acctXchRtYrmon 환율 년월
     * @param userId 사용자 ID
     * @return int
     * @throws DAOException
     */
	public int manageExchangeRateInterface(String acctXchRtYrmon, String userId)
			throws EventException {
		try {						
			
			
			//기존데이타 삭제 
			dbDao.removeExchangeRateInterface(acctXchRtYrmon, userId);
			
			//[2009-12-29 CYO 수정 : 건수가 존재 하지 않아도 인서트)
			/*
			if (cnt == 0 ) {
				return 0;
			}
			*/
			
			//데이타 입력
			dbDao.addExchangeRateInterface(acctXchRtYrmon, userId);
			
			return 1;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

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
    public String[] searchExpenseTICList() throws EventException    {
    
    	try {
    		String[] returnList = 
    			dbDao.searchExpenseTICList();
    		return returnList;    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }    
	
    /**
     * 1.일반관리비 비용코드 기준 정보
     * 2.회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보
     * 3.비용실적에 대한 재분배를 위한 예외사항 정보  
     * @param genExpnCd  비용코드
     * @param deltFlg 삭제여부 
     * @return
     * @throws EventException
     */
	public ExpenseInfoMgtVO searchExpenseInfo(String genExpnCd,
			String deltFlg) throws EventException {
    	try {
    		
    		ExpenseInfoMgtVO expenseInfoMgtVO = new ExpenseInfoMgtVO();
    		
    		//1.일반관리비 비용코드 기준 정보
    		GemExpenseVO gemExpenseVO = 
    			dbDao.searchExpenseInfo(genExpnCd, deltFlg);    		
    		expenseInfoMgtVO.setGemExpenseVO(gemExpenseVO);
    	
    		
    		return expenseInfoMgtVO;
    		 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		
		
	}
	
	
	/**
	 * 일반관리비 비용계획 및 실적집계시 사용할 코드 수정<br>
     * 일반관리비 비용계획시 사용할 비용코드(Expense Code) 정의하고, 실적(전표)집계를 위한 회계코드(Account Code)를 매핑, 실적(전표)재분배를 위한 코드정의를 한다<br>
     * GEM00007 에러코드
	 * @param ExpenseInfoMgtVO expenseInfoMgtVO
	 * @throws EventException
	 */
	public void manageExpenseInfo(ExpenseInfoMgtVO expenseInfoMgtVO )
			throws EventException {
		
		try {
			
			
			// ----------------------------------------------------------			
    		//1.일반관리비 비용코드 기준 정보
			// ----------------------------------------------------------			
			GemExpenseVO gemExpenseVO = expenseInfoMgtVO.getGemExpenseVO();

			String userId = gemExpenseVO.getCreUsrId();
			
			gemExpenseVO.setCreDt(userId);
			gemExpenseVO.setUpdUsrId(userId);
			
			// Expense Code			
			String genExpnCd = gemExpenseVO.getGenExpnCd();
			//비용코드  존재 유무 체크
			String chk = dbDao.searchExpenseInfoCheck(genExpnCd);
			
			if ("0".equals(chk)) {
				dbDao.addExpenseInfo(gemExpenseVO);
			} else  {
				dbDao.modifyExpenseInfo(gemExpenseVO);
			}
			
			// ----------------------------------------------------------			
    		//2.회계코드 기준 정보 및 일반관리비 비용코드와 매핑 정보    		
			// ----------------------------------------------------------
			List<GemAcctMtxVO>  gemAcctMtxVOs = expenseInfoMgtVO.getGemAcctMtxVOs();
			
			if ( gemAcctMtxVOs != null ) {
				List<GemAcctMtxVO> addVoList 	  = new ArrayList<GemAcctMtxVO>();
				List<GemAcctMtxVO> modifyVoList = new ArrayList<GemAcctMtxVO>();
				List<GemAcctMtxVO> removeVoList = new ArrayList<GemAcctMtxVO>();
				
				for(int i=0; i<gemAcctMtxVOs.size(); i++) {
					// 사용자 설정 
					gemAcctMtxVOs.get(i).setCreUsrId(userId);
					gemAcctMtxVOs.get(i).setUpdUsrId(userId);					
					
					
					//신규 입력인경우 
					String mtxGenExpnCd = gemAcctMtxVOs.get(i).getGenExpnCd();
					
					if (mtxGenExpnCd == null || mtxGenExpnCd.trim().length() == 0) {
						gemAcctMtxVOs.get(i).setGenExpnCd(genExpnCd);
					}
					
					//플래그 취득 
					String ibFlag = gemAcctMtxVOs.get(i).getIbflag();
					
					if("I".equals(ibFlag)) {
						addVoList.add(gemAcctMtxVOs.get(i));					
					} else if("U".equals(ibFlag)) {
						modifyVoList.add(gemAcctMtxVOs.get(i));					
					} else if ("D".equals(ibFlag)) {
						//삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정) 
						if ("Y".equals(gemExpenseVO.getAcctMtxDeltFlg())) {
							gemAcctMtxVOs.get(i).setDeltFlg("N");
						} else {
							gemAcctMtxVOs.get(i).setDeltFlg("Y");
						}
						
						removeVoList.add(gemAcctMtxVOs.get(i));
					}
				}
				
				//데이타 입력
				if(addVoList.size() > 0) {				
					dbDao.addAccountInfo(addVoList);
				}
				
				//데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifyAccountInfo(modifyVoList);				
				}
				
				//데이타  삭제
				if(removeVoList.size() > 0) {
					dbDao.removeAccountInfo(removeVoList);				
				}
				
			}
			
			
			// ----------------------------------------------------------			
     		//3.비용실적에 대한 재분배를 위한 예외사항 정보  		
			// ----------------------------------------------------------			
			List<GemAcctExptVO>  gemAcctExptVOs = expenseInfoMgtVO.getGemAcctExptVOs();
			
			if (gemAcctExptVOs != null) {
				List<GemAcctExptVO> addVoList 	  = new ArrayList<GemAcctExptVO>();
				List<GemAcctExptVO> modifyVoList = new ArrayList<GemAcctExptVO>();
				List<GemAcctExptVO> removeVoList = new ArrayList<GemAcctExptVO>();
				
				
				for(int i=0; i<gemAcctExptVOs.size(); i++) {
					
					// expense code 설정 
					gemAcctExptVOs.get(i).setGenExpnCd(genExpnCd);
					
					//사용자 설정 
					gemAcctExptVOs.get(i).setCreUsrId(userId);
					gemAcctExptVOs.get(i).setUpdUsrId(userId);
					
					//플래그 취득 
					String ibFlag = gemAcctExptVOs.get(i).getIbflag();
					
					if("I".equals(ibFlag)) {
						addVoList.add(gemAcctExptVOs.get(i));					
					} else if("U".equals(ibFlag)) {
						modifyVoList.add(gemAcctExptVOs.get(i));					
					} else if ("D".equals(ibFlag)) {
						//삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정)
						if ("Y".equals(gemExpenseVO.getAcctExptDeltFlg())) {
							gemAcctExptVOs.get(i).setDeltFlg("N");
						} else {
							gemAcctExptVOs.get(i).setDeltFlg("Y");
						}
						removeVoList.add(gemAcctExptVOs.get(i));
					}
				}
				
				//데이타 입력
				if(addVoList.size() > 0) {				
					dbDao.addDividedOfficeInfo(addVoList);
				}
				
				//데이타 수정
				if(modifyVoList.size() > 0) {
					dbDao.modifyDividedOfficeInfo(modifyVoList);		
				}
				
				//데이타  삭제
				if(removeVoList.size() > 0) {
					dbDao.removeDividedOfficeInfo(removeVoList);		
				}			

			}
			
			
			
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(new ErrorHandler("GEM00007",new String[]{}).getUserMessage());	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}			
		
	}
	
	
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
			throws EventException {
    	try {
    		return dbDao.searchAccountInfo(genExpnCd, deltFlg);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
		
	}	
	
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
    public MdmAccountVO searchAccountName (String acctCd )  throws EventException   {
    	try {
    		return dbDao.searchAccountName(acctCd);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }   	
	
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
    public List<GemExpenseVO> searchExpenseParentList(String genExpnGrpLvl)
			throws EventException {    
    	try {
    		return dbDao.searchExpenseParentList(genExpnGrpLvl);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}

    }        
    
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
    public ExpenseNameVO searchExpenseName(String genExpnCd)  throws EventException   {
    	try {
    		return dbDao.searchExpenseName(genExpnCd);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }       
    
    
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
    public List<GemAcctExptVO> searchDividedOfficeInfo (String genExpnCd , String deltFlg )  throws EventException   {
    
    	try {
    		return dbDao.searchDividedOfficeInfo(genExpnCd,deltFlg);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }          
    
    
    /**
     * 계정코드 존재 여부 체크
     * 계정코드 미존재(신규)  == 0
     * 삭제 계정코드 존재 == > 1
	 * 사용중 계정코드 존재 == > 2 
 	 * @author J.Y.O
	 * @category CPS_GEM-0007
	 * @category searchAcctCheck
     * @param acctCd 계정코드 
     * @return 체크코드
     * @throws EventException
     */
    public String[] searchAcctCheck(String acctCd) throws EventException {
    	try {
    		return dbDao.searchAcctCheck(acctCd);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }          
    
    
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
    public String searchOfcCheck(String ofcCd) throws EventException {
    	try {
    		return dbDao.searchOfcCheck(ofcCd);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }      
    
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
    public String searchGenExpnCheck(String ofcCd, String genExpnCd, String acctCd) throws EventException {
    	try {
    		return dbDao.searchGenExpnCheck(ofcCd,genExpnCd,acctCd);    		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }      
    
    // ===========================================================================
    // C.J.M
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0010] Expense Code Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * 일반관리비 비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchExpenseList
	 * @return List<GemExpenseVO>
	 * @exception EventException
	 */
	public List<GemExpenseVO> searchExpenseList() throws EventException {
		try {
			List<GemExpenseVO> list = new ArrayList<GemExpenseVO>();
			list = dbDao.searchExpenseList();
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * 일반관리비 회계계정코드 조회
	 * 
	 * @author choijungmi
	 * @category searchAccountList
	 * @return List<GemAcctMtxVO>
	 * @exception EventException
	 */
	public List<GemAcctMtxVO> searchAccountList() throws EventException {
		try {			
			List<GemAcctMtxVO> list = new ArrayList<GemAcctMtxVO>();
			list = dbDao.searchAccountList();
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * 일반관리비 1st Group비용코드 조회
	 * 
	 * @author choijungmi
	 * @category searchGroupListByExpense
	 * @return List<ExpenseInquiryVO>
	 * @exception EventException
	 */
	public List<GemExpenseVO> searchGroupListByExpense() throws EventException {
		try {			
			List<GemExpenseVO> list = new ArrayList<GemExpenseVO>();
			list = dbDao.searchGroupListByExpense();
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * Expense Code별 속성 Inquiry
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0010
	 * @category searchExpenseInq
	 * 
	 * @param expenseInqVO 
	 * @return List<ExpenseInquiryVO>
	 * @exception EventException
	 */
	public List<ExpenseInquiryVO> searchExpenseInq(ExpenseInqVO expenseInqVO) throws EventException {
		try {
			List<ExpenseInquiryVO> returnList = new ArrayList<ExpenseInquiryVO>();
			returnList = dbDao.searchExpenseInq(expenseInqVO);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0011] Expense Office Inquiry
	// ---------------------------------------------------------------------------
	
	/**
     * CPS_GEM_0011의 SUMUP OFFICE코드 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0011
     * @category searchSumUpListByOffice
     * @return String[]
     * @exception EventException
     */
	public String[] searchSumUpListByOffice() throws EventException {
		String[] returnStr = null;
		try {			
			returnStr = dbDao.searchSumUpListByOffice();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * Expense Office Code별 속성 Inquiry
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0011
	 * @category searchOfficeInfo
	 * 
	 * @param officeMgtVO 
	 * @return List<GemOfficeVO>
	 * @exception EventException
	 */
	public List<GemOfficeVO> searchOfficeInfo(OfficeMgtVO officeMgtVO) throws EventException {
		try {
			List<GemOfficeVO> returnList = new ArrayList<GemOfficeVO>();
			returnList = dbDao.searchOfficeInfo(officeMgtVO);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
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
	public String[] searchCurrencyList(String year) throws EventException {
		String[] returnStr = null;
		try {
			returnStr = dbDao.searchCurrencyList(year);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
     * CPS_GEM_0012의 Open시 USD Rate 조회
     * 
     * @author choijungmi
     * @category CPS_GEM_0012
     * @category searchUsdRate
     * 
     * @param year
     * @return String[]
     * @exception EventException
     */
	public String searchUsdRate(String year) throws EventException {
		String returnStr = null;
		try {			
			returnStr = dbDao.searchUsdRate(year);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * Foreign Exchange Rate Inquiry별 속성 Inquiry
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0012
	 * @category searchExchangeRateInq
	 * 
	 * @param acctXchRtYrmon
	 * @param currCds
	 * @return List<GemXchRtVO>
	 * @exception EventException
	 */
	public List<XchRtInqVO> searchExchangeRateInq(String acctXchRtYrmon, String currCds) throws EventException {
		try {
			List<XchRtInqVO> returnList = new ArrayList<XchRtInqVO>();
			returnList = dbDao.searchExchangeRateInq(acctXchRtYrmon, currCds);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0013] Expense Matrix per Office
	// ---------------------------------------------------------------------------	
	
	/**
	 * Expense Matrix per Office별 속성 Office Inquiry
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrix
	 * 
	 * @param officeMgtVO
	 * @return List<OfficeInfoVO>
	 * @exception EventException
	 */
	public List<OfficeInfoVO> searchOfficeExpenseMatrix(OfficeMgtVO officeMgtVO) throws EventException {
		try {
			List<OfficeInfoVO> returnList = new ArrayList<OfficeInfoVO>();
			returnList = dbDao.searchOfficeExpenseMatrixListByOffice(officeMgtVO);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

	/**
	 * Expense Matrix per Office별 속성 Expense Inquiry
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0013
	 * @category searchOfficeExpenseMatrixListByExpense
	 * 
	 * @param officeMgtVO
	 * @return List<OfficeInfoVO>
	 * @exception EventException
	 */
	public List<OfficeInfoVO> searchOfficeExpenseMatrixListByExpense(OfficeMgtVO officeMgtVO) throws EventException {
		try {
			List<OfficeInfoVO> returnList = new ArrayList<OfficeInfoVO>();
			returnList = dbDao.searchOfficeExpenseMatrixListByExpense(officeMgtVO);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}

	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_01] Expense Office Maintenance - Office Code
	// ---------------------------------------------------------------------------
    
	/**
	 * CPS_GEM_0008_01 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_01
	 * @category manageOfficeInfo
	 * 
	 * @param gemOfficeVOs
	 *            GemOfficeVO[]
	 * @exception EventException
	 */
	public void manageOfficeInfo(GemOfficeVO[] gemOfficeVOs) throws EventException {		
		try {			
			List<GemOfficeVO> modifyVoList = new ArrayList<GemOfficeVO>();
			List<GemOfficeVO> removeVoList = new ArrayList<GemOfficeVO>();
						
			for(int i=0; i<gemOfficeVOs.length; i++) {				
				
				//플래그 취득
				String ibFlag = gemOfficeVOs[i].getIbflag();
				
				if("U".equals(ibFlag)) {
					gemOfficeVOs[i].setRqstAuthFlg(gemOfficeVOs[i].getRqstAuthFlg().equals("1")?"Y":"N");
					gemOfficeVOs[i].setRhqAuthFlg(gemOfficeVOs[i].getRhqAuthFlg().equals("1")?"Y":"N");
					gemOfficeVOs[i].setTicAuthFlg(gemOfficeVOs[i].getTicAuthFlg().equals("1")?"Y":"N");
					gemOfficeVOs[i].setCmitAuthFlg(gemOfficeVOs[i].getCmitAuthFlg().equals("1")?"Y":"N");
					modifyVoList.add(gemOfficeVOs[i]);
					
				} else if ("D".equals(ibFlag)) {
					// OFC_HIS_CNT가 0인경우만 삭제함.
					//if("0".equals(gemOfficeVOs[i].getOfcHisCnt())) {
						// 삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정) 
						if ("Y".equals(gemOfficeVOs[i].getDeltFlg())) {
							gemOfficeVOs[i].setDeltFlg("N");
						} else {
							gemOfficeVOs[i].setDeltFlg("Y");
						}
						
						removeVoList.add(gemOfficeVOs[i]);
					//}
				}
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyOfficeInformation(modifyVoList);				
			}
			
			//데이타  삭제
			if(removeVoList.size() > 0) {
				dbDao.removeOfficeInformation(removeVoList);				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0109] Office code history
	// ---------------------------------------------------------------------------
    
	/**
	 * Office code history 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfo
	 * 
	 * @param ofcCd
	 * @return List<GemOfcHisVO>
	 * @exception EventException
	 */
	public List<GemOfcHisVO> searchOfficeHistoryInfo(String ofcCd) throws EventException {
		try {
			List<GemOfcHisVO> returnList = new ArrayList<GemOfcHisVO>();
			returnList = dbDao.searchOfficeHistoryInfo(ofcCd);
	        return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * Office code history 조회의 Ofc_Code에 해당하는 Ctr_Code 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category searchOfficeHistoryInfoByCtrCode
	 * 
	 * @param ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeHistoryInfoByCtrCode(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfficeHistoryInfoByCtrCode(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0109 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0109
	 * @category manageOfficeHistoryInfo
	 * 
	 * @param gemOfcHisVOs
	 *            GemOfcHisVO[]
	 * @exception EventException
	 */
	public void manageOfficeHistoryInfo(GemOfcHisVO[] gemOfcHisVOs) throws EventException {
		try {
			
			List<GemOfcHisVO> addVoList   = new ArrayList<GemOfcHisVO>();
			List<GemOfcHisVO> modifyVoList = new ArrayList<GemOfcHisVO>();
						
			for(int i=0; i<gemOfcHisVOs.length; i++) {				
				
				//플래그 취득 
				String ibFlag = gemOfcHisVOs[i].getIbflag();
				
				if("I".equals(ibFlag)) {
					addVoList.add(gemOfcHisVOs[i]);				
				} else if("U".equals(ibFlag)) {
					modifyVoList.add(gemOfcHisVOs[i]);					
				}
			}
			
			//데이타 입력
			if(addVoList.size() > 0) {				
				dbDao.addOfficeHistoryInfo(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyOfficeHistoryInfo(modifyVoList);				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0008_02] Expense Office Maintenance - Expense Matrix per Office
	// ---------------------------------------------------------------------------
	
	/**
     * Expense Code 사용여부를 체크 
 	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category searchExpenseCheck
	 * @param schGbn 
     * @param ofcCd
     * @param genExpnCd 
     * @return String
     * @throws EventException
     */
    public String searchExpenseCheck(String schGbn, String ofcCd, String genExpnCd) throws EventException {
    	try {
    		return dbDao.searchExpenseCheck(schGbn, ofcCd, genExpnCd);    		
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	/**
	 * CPS_GEM_0008_02 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_02
	 * @category manageOfficeExpenseMatrix
	 * 
	 * @param officeInfoVOs
	 *            OfficeInfoVO[]
	 * @exception EventException
	 */
	public void manageOfficeExpenseMatrix(OfficeInfoVO[] officeInfoVOs) throws EventException {		
		try {
			
			List<OfficeInfoVO> addVoList   = new ArrayList<OfficeInfoVO>();
			List<OfficeInfoVO> modifyVoList = new ArrayList<OfficeInfoVO>();
						
			for(int i=0; i<officeInfoVOs.length; i++) {				
				
				//플래그 취득 
				String ibFlag = officeInfoVOs[i].getIbflag();
				
				if("I".equals(ibFlag)) {
					addVoList.add(officeInfoVOs[i]);				
				} else if("U".equals(ibFlag) || "D".equals(ibFlag)) {
					// 삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정) 
					if ("Y".equals(officeInfoVOs[i].getDeltFlg())) {
						officeInfoVOs[i].setDeltFlg("N");
					} else {
						officeInfoVOs[i].setDeltFlg("Y");
					}
					
					modifyVoList.add(officeInfoVOs[i]);					
				} 
			}
			
			//데이타 입력
			if(addVoList.size() > 0) {				
				dbDao.addOfficeExpenseMatrix(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyOfficeExpenseMatrix(modifyVoList);				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_0110] Expense Matrix Copy
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_0110 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
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
	public int createExpenseCopy(String mtxDiv, String fmOfc, String toOfc, String userId) throws EventException {
		try {
			int insCnt = 0;
			
			if(mtxDiv.equals("I")) {
				insCnt = dbDao.addInitialCopy(toOfc, userId);
			} else if(mtxDiv.equals("C")) {
				insCnt = dbDao.addExpenseCopy(fmOfc, toOfc, userId);
			}			
			return insCnt;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
	}
	
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
	public String[] searchFromOffice(String rgnOfcFlg, String deltFlg) throws EventException {
		String[] returnStr = null;
		try {			
			returnStr = dbDao.searchFromOffice(rgnOfcFlg, deltFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
     * CPS_GEM_0008_03의 To OFFICE코드 조회
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
	public String[] searchToOffice(String rgnOfcFlg, String deltFlg) throws EventException {
		String[] returnStr = null;
		try {			
			returnStr = dbDao.searchToOffice(rgnOfcFlg, deltFlg);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return returnStr;
	}
	
	/**
	 * CPS_GEM_0008_03 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category searchOfficeMatrixListByOffice
	 * 
	 * @param officeMgtVO
	 * @return List<OfficeInfoVO>
	 * @exception EventException
	 */
	public List<OfficeExptVO> searchOfficeMatrixListByOffice(OfficeMgtVO officeMgtVO) throws EventException {
		try {			
			List<OfficeExptVO> returnList = new ArrayList<OfficeExptVO>();			
			returnList = dbDao.searchOfficeMatrixListByOffice(officeMgtVO);	        	        
			return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
	 * CPS_GEM_0008_03의 From ~ To Office Code선택시 해당범위안의 Expense Code를 조회
	 * 
	 * @author choijungmi
	 * @category searchExptListByExpense
	 * 
	 * @param String sndOfcCd
	 * @param String rcvOfcCd
	 * @return List<ExpenseNameVO>
	 * @exception EventException
	 */
	public List<ExpenseNameVO> searchExptListByExpense(String sndOfcCd, String rcvOfcCd) throws EventException {
		try {			
			List<ExpenseNameVO> list = dbDao.searchExptListByExpense("A", sndOfcCd, rcvOfcCd);
			log.info("##### list.size() : "+list.size());

			List<ExpenseNameVO> returnList = new ArrayList<ExpenseNameVO>();
			if(list.size() == 0) {
				returnList = dbDao.searchExptListByExpense("B", sndOfcCd, rcvOfcCd);
			} else {
				returnList = dbDao.searchExptListByExpense("C", sndOfcCd, rcvOfcCd);
			}
				
			return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
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
    public String searchExptListByDupCheck(String sndOfcCd , String rcvOfcCd, String genExpnCd) throws EventException {
    	try {
    		if(!dbDao.searchExptListByDupCheck(sndOfcCd , rcvOfcCd, genExpnCd)) {
    			return "1";
    		} else {
    			return "2";
    		}    		
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
    }
    
	/**
	 * CPS_GEM_0008_03 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_0008_03
	 * @category manageOfficeMatrixListByOffice
	 * 
	 * @param officeExptVOs
	 *            OfficeInfoVO[]
	 * @exception EventException
	 */
	public void manageOfficeMatrixListByOffice(OfficeExptVO[] officeExptVOs) throws EventException {		
		try {
			
			List<OfficeExptVO> addVoList   = new ArrayList<OfficeExptVO>();
			List<OfficeExptVO> modifyVoList = new ArrayList<OfficeExptVO>();
						
			for(int i=0; i<officeExptVOs.length; i++) {				
				
				//플래그 취득 
				String ibFlag = officeExptVOs[i].getIbflag();
				
				if("I".equals(ibFlag)) {
					addVoList.add(officeExptVOs[i]);				
				} else if("U".equals(ibFlag) || "D".equals(ibFlag)) {
					// 삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정) 
					if ("Y".equals(officeExptVOs[i].getDeltFlg())) {
						officeExptVOs[i].setDeltFlg("N");
					} else {
						officeExptVOs[i].setDeltFlg("Y");
					}
					
					modifyVoList.add(officeExptVOs[i]);					
				}  
			}
			
			//데이타 입력
			if(addVoList.size() > 0) {				
				dbDao.addOfficeMatrixListByOffice(addVoList);
			}
			
			//데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyOfficeMatrixListByOffice(modifyVoList);				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_GEM_9999] Log in Office Change Management
	// ---------------------------------------------------------------------------
	
	/**
	 * CPS_GEM_9999 조회
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category searchLogInOfficeChange
	 * 
	 * @param OfficeMgtVO officeMgtVO
	 * @return List<GemCngOfcVO>
	 * @exception EventException
	 */
	public List<GemCngOfcVO> searchLogInOfficeChange(OfficeMgtVO officeMgtVO) throws EventException {
		try {			
			List<GemCngOfcVO> returnList = new ArrayList<GemCngOfcVO>();			
			returnList = dbDao.searchLogInOfficeChange(officeMgtVO);	        	        
			return returnList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
	}
	
	/**
     * GEM_OFFICE Table에 OFC_CD 존재여부를 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByDupCheck
	 * 
	 * @param gubun
     * @param ofcCd
	 * @return String 결과값 1 사용가능  2, 사용불가능
	 * @exception EventException
	 */
    public String searchLogInOfficeChangeByDupCheck(String gubun, String ofcCd) throws EventException {
    	String resultStr = "";
    	try {
    		if(dbDao.searchLogInOfficeChangeByDupCheck(gubun, ofcCd)) {
    			resultStr = "1";
    		} else {
    			resultStr = "2";
    		}    		
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return resultStr;
    }
    
    /**
     * GEM_CNG_OFC Table에 OFC_CD, CNG_OFC_CD를 중복 체크한다 <br>
	 * 
	 * @author choijungmi
     * @category CPS_GEM_9999
     * @category searchLogInOfficeChangeByOfcCdDupCheck
	 * 
	 * @param String ofcCd
     * @param String cngOfcCd
	 * @return String 결과값 1 신규  2, 중복
	 * @exception EventException
	 */
    public String searchLogInOfficeChangeByOfcCdDupCheck(String ofcCd, String cngOfcCd) throws EventException {
    	String resultStr = "";
    	try {
    		if(dbDao.searchLogInOfficeChangeByOfcCdDupCheck(ofcCd, cngOfcCd)) {
    			resultStr = "2";
    		} else {
    			resultStr = "1";
    		}    		
    	} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}
		return resultStr;
    }
	
    /**
	 * CPS_GEM_9999 멀티 이벤트 처리<br>
	 * In화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @author choijungmi
	 * @category CPS_GEM_9999
	 * @category manageLogInOfficeChange
	 * 
	 * @param GemCngOfcVO[] gemCngOfcVOs
	 * @exception EventException
	 */
	public void manageLogInOfficeChange(GemCngOfcVO[] gemCngOfcVOs) throws EventException {		
		try {
			
			List<GemCngOfcVO> addVoList   = new ArrayList<GemCngOfcVO>();
			List<GemCngOfcVO> modifyVoList = new ArrayList<GemCngOfcVO>();
			List<GemCngOfcVO> deleteVoList = new ArrayList<GemCngOfcVO>();
						
			for(int i=0; i<gemCngOfcVOs.length; i++) {				
				
				//플래그 취득 
				String ibFlag = gemCngOfcVOs[i].getIbflag();
				
				if("I".equals(ibFlag)) {
					addVoList.add(gemCngOfcVOs[i]);				
				} else if("U".equals(ibFlag)) {
					log.info("#####"+gemCngOfcVOs[i]);
					modifyVoList.add(gemCngOfcVOs[i]);					
				} else if("D".equals(ibFlag)) {
					// 삭제 플래그 설정  (삭제된 데이타에서 삭제인경우 delt_flg = N 으로 설정) 
					if ("Y".equals(gemCngOfcVOs[i].getDeltFlg())) {
						gemCngOfcVOs[i].setDeltFlg("N");
					} else {
						gemCngOfcVOs[i].setDeltFlg("Y");
					}
					
					deleteVoList.add(gemCngOfcVOs[i]);					
				} 
			}
			
			// 데이타 입력
			if(addVoList.size() > 0) {				
				dbDao.addLogInOfficeChange(addVoList);
			}
			
			// 데이타 수정
			if(modifyVoList.size() > 0) {
				dbDao.modifyLogInOfficeChange(modifyVoList);				
			}
			
			// 데이터 삭제
			if(deleteVoList.size() > 0) {
				dbDao.removeLogInOfficeChange(deleteVoList);				
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM10001",new String[]{}).getMessage());
		}		
	}
}