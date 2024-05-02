/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : USDomesticBCImpl.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - 컬럼 추가에 의한 Creation Logic 및 변경 저장 로직 수정 
* 2012.11.20 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 수정
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.integration.USDomesticDBDAO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.vo.SearchUSDomesticVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-STDUnitCost Business Logic Basic Command implementation<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author BOBAE KIM
 * @see USDomesticBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class USDomesticBCImpl extends BasicCommandSupport implements USDomesticBC {

	// Database Access Object
	private transient USDomesticDBDAO dbDao = null;

	/**
	 * MTCostBCImpl 객체 생성<br>
	 * MTCostDBDAO를 생성한다.<br>
	 */
	public USDomesticBCImpl() {
		dbDao = new USDomesticDBDAO();
	}

	/**
	 * USDomesticCost 조회
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @return List<SearchUSDomesticVO>
	 * @throws EventException
	 */
	public List<SearchUSDomesticVO> searchUSDomesticCost(SearchUSDomesticVO searchUSDomesticVO) throws EventException {
		try {
			return dbDao.searchUSDomesticCost(searchUSDomesticVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * USDomesticCost 수정 후 저장
	 * 
	 * @param SearchUSDomesticVO[] searchUSDomesticVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiUSDomesticCost(SearchUSDomesticVO[] searchUSDomesticVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SearchUSDomesticVO> insertVoList = new ArrayList<SearchUSDomesticVO>();
			
			for ( int i=0; i<searchUSDomesticVOs .length; i++ ) {
				if ( searchUSDomesticVOs[i].getIbflag().equals("U")){
					searchUSDomesticVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchUSDomesticVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyEmptyRepoCredit(insertVoList);
//				dbDao.modifyEmptyRepo(insertVoList);
//				dbDao.modifyDomSav(insertVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * USDomesticCost 월 단가 생성
	 * 
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createUSDomesticCost(SearchUSDomesticVO searchUSDomesticVO, SignOnUserAccount account) throws EventException {
		
		searchUSDomesticVO.setUpdUsrId(account.getUsr_id());
		searchUSDomesticVO.setCreUsrId(account.getUsr_id());
		
		try {
			// 1. Domestic Revenue 데이터 삭제
			dbDao.removeDomRev(searchUSDomesticVO);

			// 2. Domestic Revenue 데이터 생성
            dbDao.addDomRev(searchUSDomesticVO);
            
            // 3. Domestic Rail 데이터 생성
            dbDao.addDomRailCost(searchUSDomesticVO);
            
            // 3.1 Domestic TRP 데이터 생성
            dbDao.addUSDomesticTRP(searchUSDomesticVO);
  
            // 4. Location data 를 ECC Level 로 Summary 데이터 생성
            dbDao.addLocEccSum(searchUSDomesticVO);
  
            // 4.1 EQ Off-hire 데이터 생성 (Sub lease out , CN Domestic)
            dbDao.addLeaseOut (searchUSDomesticVO);
  
            // 4.2 EQ Off-hire 데이터 생성 (Disposal)
            dbDao.addDisposal (searchUSDomesticVO);
  
            // 4.3 EQ Off-hire 데이터 생성 (EQ Off-hire)
            dbDao.addEQOffhire (searchUSDomesticVO);
            
            // 4.4 EQ Off-hire US Rail Invoice Amount 데이터 생성 (DRP cost)
            dbDao.addDRPInvoiceAmount (searchUSDomesticVO);

            // 5. Domestic total cost 데이터 생성
            dbDao.addDomCost(searchUSDomesticVO);
            
            // 6. Simulated empty reposition 데이터 생성
            dbDao.addEmptyRepo(searchUSDomesticVO);
            
            // 7. Domestic savings 데이터 생성
            dbDao.addDomSav(searchUSDomesticVO);
            
            // 8. 기간 히스토리 데이터 생성
            dbDao.createUSDomCreationStatus(searchUSDomesticVO, account);
           
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);    			
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
	
	
	/**
	 * BackEndJob을 실행
	 * 
	 * @param SignOnUserAccount account
	 * @param SearchUSDomesticVO searchUSDomesticVO
	 * @param String pgmNo
	 * @return String 
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, SearchUSDomesticVO searchUSDomesticVO, String pgmNo)  throws EventException{

		USDomesticBackEndJob backEndJob = new USDomesticBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_COA_0014")) {
			backEndJob.setSearchUSDomesticVO(searchUSDomesticVO);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "createUSDomesticCost BackEndJob");
		}
		return resultStr;
	}
	
	
	
	/**
	 * CREATE 하기 전 COA_MTY_ECC_UT_COST 테이블 데이터 유무 확인
	 * 
	 * @param fCostYrmon
	 * @return String 
	 * @throws EventException
	 */
	public String searchCoaMtyEccUtCostCnt(String fCostYrmon) throws EventException {
		
		String retCnt = "";
		
		try {
			retCnt = dbDao.searchCoaMtyEccUtCostCnt(fCostYrmon);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return retCnt;
	}
	
	
	/**
	 * ESM_COA_0014 : CREATE 된 기간 조회
	 *
	 * @param String fCostYrmon
	 * @return String retVal
	 * @throws EventException
	 */
	public String searchUSDomCreationStatus(String fCostYrmon) throws EventException {
		
		String retVal = "";
		
		try {
			retVal = dbDao.searchUSDomCreationStatus(fCostYrmon);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);    			
			throw new EventException(ex.getMessage(),ex);
		}
		return retVal;
	}
	


	/**
	 * [Domestic Saving Credit 월단가]을 [복사] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createDomesticMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account)  throws EventException{
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

            //1. TARGET 해당월을 삭제한다.
            dbDao.removeDomesticMonthCopy(param);
            //2. CSOURCE 해당월을 복사해서  TARGET 데이타를 생성한다. 
            dbDao.addDomesticMonthCopy(param);
            //3. 생성 상태정보를 복사한다.
            dbDao.addDomesticStatusMonthCopy(param);
              
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12192",new String[]{}).getMessage(), ex);
		}
	}
	
}