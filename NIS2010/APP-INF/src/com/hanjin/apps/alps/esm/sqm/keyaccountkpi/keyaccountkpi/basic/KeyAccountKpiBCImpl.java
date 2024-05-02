/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : KeyAccountKpiBCImpl.java
*@FileTitle      : KeyAccountKpi
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.08.13
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.08.13 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.integration.KeyAccountKpiDBDAO;
import com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.vo.SearchKpiUploadVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmKeyAcctCfmQtaVO;

/**
 * ALPS-KeyAccountKpi Business Logic Command Interface<br>
 * - ALPS-KeyAccountKpi 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see KeyAccountKpiDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class KeyAccountKpiBCImpl extends BasicCommandSupport implements KeyAccountKpiBC {
	
	// Database Access Object
	private transient KeyAccountKpiDBDAO dbDao = null;
	
	/**
	 * KeyAccountKpiBCImpl 객체 생성<br>
	 * KeyAccountKpiDBDAO를 생성한다.<br>
	 */
	public KeyAccountKpiBCImpl() {
		dbDao = new KeyAccountKpiDBDAO();
	}
	
	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiUploadVO>
	 * @exception EventException
	 */
	public List<SearchKpiUploadVO> searchKpiUpload(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiUpload(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0601 : [SEARCH]<br>
	 * [KPI Upload]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiUploadCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiUploadCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0601 : [SEARCH01]<br>
	 * [KPI Upload]화면에서 Yearly 조회 후 Quaterly 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.search1QTransferDataCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0601 : [MULTI]<br>
	 * [KPI Upload]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiUpload(ConditionVO conditionVO, SqmKeyAcctCfmQtaVO[] sqmKeyAcctCfmQtaVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmKeyAcctCfmQtaVO> insUpdVoList = new ArrayList<SqmKeyAcctCfmQtaVO>();
			
			for ( int i=0; i<sqmKeyAcctCfmQtaVOS .length; i++ ) {    
				sqmKeyAcctCfmQtaVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmKeyAcctCfmQtaVOS[i].setCreUsrId(account.getUsr_id());
				sqmKeyAcctCfmQtaVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmKeyAcctCfmQtaVOS[i].getIbflag().equals("I") || sqmKeyAcctCfmQtaVOS[i].getIbflag().equals("U")){
					insUpdVoList.add(sqmKeyAcctCfmQtaVOS[i]);
				}
			}
			if ( insUpdVoList.size() > 0 ) {
				dbDao.modifyKpiUpload(insUpdVoList);
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	
	/**
	 * ESM_SQM_0601 : [MULTI01]<br>
	 * [KPI Upload]화면에서 [1Q Data]을 [Transfer] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String create1QTransferData(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		try {
			istCnt = dbDao.create1QTransferData(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());   
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}
	
}