/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PreCMSimulationBCImpl.java
*@FileTitle : Inquiry the report 
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration.PreCMSimulationDBDAO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.vo.TrfChgVO;

/**
 * OPUS-COA Business Logic Basic Command implementation<br>
 * 
 * 
 * @author
 * @see multiDimensionRPTBC reference the each DAO class 
 * @since J2EE 1.6
 */
public class PreCMSimulationBCImpl   extends BasicCommandSupport implements PreCMSimulationBC {

	// Database Access Object
	private transient PreCMSimulationDBDAO dbDao=null;

	/**
	 * PreCMSimulationBCImpl Object creation<br>
	 * MultiDimensionRPTDBDAO Creation<br>
	 */
	public PreCMSimulationBCImpl(){
		dbDao = new PreCMSimulationDBDAO();
	}
	
	/**
	 * (CMTX)Route Cost Inqiury <br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param TrfChgVO[] trfChgVO
	 * @return CommonCoaRsVO
	 * @exception EventException
	 */
	public CommonCoaRsVO searchBKG4006List(SearchConditionVO searchConditionVO, TrfChgVO[] trfChgVO) throws EventException {
		try {
			List<TrfChgVO> selectVoList = new ArrayList<TrfChgVO>();
			
			for ( int i=0; i<trfChgVO .length; i++ ) {
				selectVoList.add(trfChgVO[i]);
			}			
			
			return dbDao.searchBKG4006List(searchConditionVO, selectVoList);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * Inquiry by BKG Cost Remark]<br>
	 * About the ESM_COA_4007, Handling the inquiry event<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return list List<SearchBkgRmk4007ListVO> 
	 * @throws EventException
	 */
	public CommonCoaRsVO searchBkgRemarkList4007(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchBkgRemarkList4007(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
     * ESM_COA_0153 비용 생성<br>
     * 
     * @param AplyRtInVO aplyRtInVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createPreCMSimulation(AplyRtInVO aplyRtInVO, SignOnUserAccount account) throws EventException{
		PreCMSimulationCreateBackEndJob backEndJob = new PreCMSimulationCreateBackEndJob();
		backEndJob.setAplyRtInVO(aplyRtInVO,account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Pre CM/OP Simulation - Create Pre CM/OP Simulation Message");		
        } catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

    }
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
}



