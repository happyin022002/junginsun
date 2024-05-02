/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchBCImpl.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.03 변종건 [CHM-201217633] Inland Cost Batch Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.integration.CostBatchDBDAO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchFdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchInlandCostBatchErrorVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

 
/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 
 * @see ESD_TRS_3004EventResponse,DistanceCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CostBatchBCImpl   extends BasicCommandSupport implements CostBatchBC {

	// Database Access Object
	private transient CostBatchDBDAO dbDao=null;

	/**
	 * CostBatchBCImpl 객체 생성<br>
	 * CostBatchDBDAO를 생성한다.<br>
	 */
	public CostBatchBCImpl(){
		dbDao = new CostBatchDBDAO();
	}
	
	
	/**
	 * @param searchCostCalcListVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<SearchCostCalcListVO> searchCostCalcList(SearchCostCalcListVO searchCostCalcListVO, SignOnUserAccount account) throws EventException{
		String[] cntCdArr = null;
		String[] stsCdArr = null;
		String cntCd = "";
		String stsCd = "";
		try {
			cntCdArr = searchCostCalcListVO.getCntCd().split(",");
			for( int idx=0; idx<cntCdArr.length; idx++ ){
				if( idx == 0 && !cntCdArr[idx].equals("") ){
					cntCd = "'" + cntCdArr[idx] + "'";
				} else if( idx > 0 ){
					cntCd = cntCd + ",'" + cntCdArr[idx] + "'";
				}
			}
			searchCostCalcListVO.setCntCd(cntCd);
			
			stsCdArr = searchCostCalcListVO.getComboSts().split(",");
			for( int idx=0; idx<stsCdArr.length; idx++ ){
				if( idx == 0 && !stsCdArr[idx].equals("") ){
					stsCd = "'" + stsCdArr[idx] + "'";
				} else if( idx > 0 ){
					stsCd = stsCd + ",'" + stsCdArr[idx] + "'";
				}
			}
			searchCostCalcListVO.setComboSts(stsCd);
			searchCostCalcListVO.setCreOfcCd(account.getOfc_cd());
			
			return dbDao.searchCostCalcList(searchCostCalcListVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void insertBatchQueue(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException{
		List<SearchCostCalcListVO> voList = new ArrayList<SearchCostCalcListVO>();
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				searchCostCalcListVOs[idx].setCreUsrId(account.getUsr_id());
				searchCostCalcListVOs[idx].setUsrOfcCd(account.getOfc_cd());
				voList.add(searchCostCalcListVOs[idx]);
			}
			
			dbDao.insertBatchQueue(voList);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorBatchExec(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException{
		String progFlg = "";
		String errFlg = "N";
		
		try {
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				progFlg = dbDao.monitorBatchExec(searchCostCalcListVOs[idx]);
				if( "Y".equals(progFlg) ){
					errFlg = "Y";
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		return errFlg;
	}
	
	
	/**
	 * @param searchCostCalcListVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchCostCalcListVO> searchFeederCostCalcList(SearchCostCalcListVO searchCostCalcListVO) throws EventException{
		String[] rhqCdArr = null;
		String rhqCd = "";
		
		try {
			//RHQ Office
			rhqCdArr = searchCostCalcListVO.getComboRhq().split(",");
			for( int idx=0; idx<rhqCdArr.length; idx++ ){
				if( idx == 0 && !rhqCdArr[idx].equals("") ){
					rhqCd = "'" + rhqCdArr[idx] + "'";
				} else if( idx > 0 ){
					rhqCd = rhqCd + ",'" + rhqCdArr[idx] + "'";
				}
			}
			searchCostCalcListVO.setComboRhq(rhqCd);
			
			return dbDao.searchFeederCostCalcList(searchCostCalcListVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void insertFeederBatchQueue(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException{
		List<SearchCostCalcListVO> voList = new ArrayList<SearchCostCalcListVO>();
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				searchCostCalcListVOs[idx].setCreUsrId(account.getUsr_id());
				searchCostCalcListVOs[idx].setUsrOfcCd(account.getOfc_cd());
				voList.add(searchCostCalcListVOs[idx]);
			}
			
			dbDao.insertFeederBatchQueue(voList);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorFeederBatchExec(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException{
		String progFlg = "";
		String errFlg = "N";
		
		try {
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				progFlg = dbDao.monitorFeederBatchExec(searchCostCalcListVOs[idx]);
				if( "Y".equals(progFlg) ){
					errFlg = "Y";
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		return errFlg;
	}
	
	
	/**
	 * @param searchInlandCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandCostBatchErrorVO> searchInlandCostBatchError(SearchInlandCostBatchErrorVO searchInlandCostBatchErrorVO) throws EventException{
		try {
			return dbDao.searchInlandCostBatchError(searchInlandCostBatchErrorVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchFdrCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchFdrCostBatchErrorVO> searchFdrCostBatchError(SearchFdrCostBatchErrorVO searchFdrCostBatchErrorVO) throws EventException{
		try {
			return dbDao.searchFdrCostBatchError(searchFdrCostBatchErrorVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyBatchCancel(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException{
		List<SearchCostCalcListVO> voList = new ArrayList<SearchCostCalcListVO>();
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				searchCostCalcListVOs[idx].setUpdUsrId(account.getUsr_id());
				voList.add(searchCostCalcListVOs[idx]);
			}
			
			dbDao.modifyBatchCancel(voList);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostCfm(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException{
		List<SearchCostCalcListVO> voList = new ArrayList<SearchCostCalcListVO>();
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				searchCostCalcListVOs[idx].setUpdUsrId(account.getUsr_id());
				searchCostCalcListVOs[idx].setUsrOfcCd(account.getOfc_cd());
				voList.add(searchCostCalcListVOs[idx]);
			}
			
			dbDao.modifyInlandCostPreVerByCfm(voList);
			dbDao.modifyInlandCostCfm(voList);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @param account
	 * @throws EventException
	 */
	public void modifyInlandCostCfmCxl(SearchCostCalcListVO[] searchCostCalcListVOs, SignOnUserAccount account) throws EventException{
		List<SearchCostCalcListVO> voList = new ArrayList<SearchCostCalcListVO>();
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				searchCostCalcListVOs[idx].setUpdUsrId(account.getUsr_id());
				searchCostCalcListVOs[idx].setUsrOfcCd(account.getOfc_cd());
				voList.add(searchCostCalcListVOs[idx]);
			}
			
			dbDao.modifyInlandCostPreVerByCfmCxl(voList);
			dbDao.modifyInlandCostCfmCxl(voList);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String monitorWaitingSts(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException{
		String costTrfBatSeqArr = "";
		String errFlg = "";
		try {
			
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				if( idx > 0 ){
					costTrfBatSeqArr = costTrfBatSeqArr + "," + searchCostCalcListVOs[idx].getCostTrfBatSeq();
				} else{
					costTrfBatSeqArr = searchCostCalcListVOs[idx].getCostTrfBatSeq();
				}
			}
			
			errFlg = dbDao.monitorWaitingSts(costTrfBatSeqArr);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		return errFlg;
	}
	
	
	/**
	 * @param searchCostCalcListVOs
	 * @return
	 * @throws EventException
	 */
	public String searchGuidelineExist(SearchCostCalcListVO[] searchCostCalcListVOs) throws EventException{
		String existFlg = "";
		String errFlg = "N";
		
		try {
			for(int idx=0; idx<searchCostCalcListVOs.length; idx++){
				existFlg = dbDao.searchGuidelineExist(searchCostCalcListVOs[idx].getCostTrfNo());
				if( "Y".equals(existFlg) ){
					errFlg = "Y";
				}
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
		return errFlg;
	}

	
	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * DistanceCreation업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}