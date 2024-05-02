/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesBCImpl.java
*@FileTitle : Inland Rates Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.inlandrates.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.integration.InlandRatesDBDAO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.clt.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTrfInlndProgVO;
import com.clt.syscommon.common.table.PriTrfInlndRtVO;
import com.clt.syscommon.common.table.PriTrfInlndVO;

/**
 * Tariff Business Logic Command Interface<br>
 * - handling biz logic about Tariff <br>
 *
 * @author SHKIM
 * @see EsmPri3514EventResponse,InlandRatesBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class InlandRatesBCImpl extends BasicCommandSupport implements InlandRatesBC {

	// Database Access Object
	private transient InlandRatesDBDAO dbDao = null;

	/**
	 * InlandRatesBCImpl object creation<br>
	 * creating InlandRatesDBDAO <br>
	 */
	public InlandRatesBCImpl() {
		dbDao = new InlandRatesDBDAO();
	}

	/**
	 * retrieving Inland Rate name <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<PriTrfInlndVO>
	 * @exception EventException
	 */
	public List<PriTrfInlndVO> searchInlandRatesName(PriTrfInlndVO priTrfInlndVO) throws EventException {
		try {
			return dbDao.searchInlandRatesName(priTrfInlndVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * retrieving Inland Rate <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRates(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException {
		try {
			return dbDao.searchInlandRates(priTrfInlndParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
		
	/**
	 * retrieving Inland Rate Detail information <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesLocation(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException {
		try {
			return dbDao.searchInlandRatesLocation(priTrfInlndParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
		
	/**
	 * downloading Inland Rate Detail information <br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesExcel(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException {
		try {
			return dbDao.searchInlandRatesExcel(priTrfInlndRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * saving Inland Rate file<br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRatesFile(PriTrfInlndVO priTrfInlndVO,List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			int sizeKeys = 0;
			if (keys != null) {
				sizeKeys = keys.size() - 1;
				
				if(priTrfInlndVO.getIbflag().equals("I")) {
					priTrfInlndVO.setAtchFileId(keys.get(sizeKeys));
					priTrfInlndVO.setUpdUsrId(account.getUsr_id());	
					dbDao.modifyInlandRatesAttach(priTrfInlndVO);
				} else if(priTrfInlndVO.getIbflag().equals("D")) {

					//file delete (del_flg update)
					UpdateFileMetaInfo.delete(priTrfInlndVO.getAtchFileId());

					priTrfInlndVO.setAtchFileId("");
					priTrfInlndVO.setUpdUsrId(account.getUsr_id());					
					dbDao.modifyInlandRatesAttach(priTrfInlndVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * saving Inland Rate information <br>
	 * 
	 * @param PriTrfInlndListVO priTrfInlndListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageInlandRates(PriTrfInlndListVO priTrfInlndListVO, SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndParamVO paramVo = priTrfInlndListVO.getPriTrfInlndParamVO();
			PriTrfInlndVO[] vo = priTrfInlndListVO.getPriTrfInlndVOs();
			PriTrfInlndRtVO[] dtlvo = priTrfInlndListVO.getPriTrfInlndRtVOs();
			List<String> keys = priTrfInlndListVO.getKeys();
									
			List<PriTrfInlndVO> insertVoList = new ArrayList<PriTrfInlndVO>();
			List<PriTrfInlndVO> updateVoList = new ArrayList<PriTrfInlndVO>();
			List<PriTrfInlndVO> deleteVoList = new ArrayList<PriTrfInlndVO>();
			List<PriTrfInlndRtVO> insertDtlVoList = new ArrayList<PriTrfInlndRtVO>();
			List<PriTrfInlndRtVO> updateDtlVoList = new ArrayList<PriTrfInlndRtVO>();
			List<PriTrfInlndRtVO> deleteDtlVoList = new ArrayList<PriTrfInlndRtVO>();
			
			int sizeKeys = 0;
			if (keys != null) sizeKeys = keys.size() - 1;
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());	
					vo[i].setRqstOfcCd(account.getOfc_cd()); //Request Office
					if(keys != null) {
						vo[i].setAtchFileId(keys.get(sizeKeys)); //Attached File
					}
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					if(keys != null) {
						vo[i].setAtchFileId(keys.get(sizeKeys)); //Attached File
					}
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					deleteVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					deleteDtlVoList.add(dtlvo[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInlandRatesS(insertVoList);
				
				//max seq
				//String maxSeq = dbDao.searchInlandRatesMaxSeq(insertVoList.get(0));
				
				PriTrfInlndProgVO priTrfInlndProgVO = new PriTrfInlndProgVO();				
				ObjectCloner.build(insertVoList.get(0), priTrfInlndProgVO);
				//priTrfInlndProgVO.setTrfInlndSeq(maxSeq);
				priTrfInlndProgVO.setProgUsrId(account.getUsr_id());
				priTrfInlndProgVO.setProgOfcCd(account.getOfc_cd());
				priTrfInlndProgVO.setCreUsrId(account.getUsr_id());
				priTrfInlndProgVO.setUpdUsrId(account.getUsr_id());
				dbDao.addInlandRatesProgress(priTrfInlndProgVO);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInlandRatesS(updateVoList);
			}

			
			
			if(paramVo.getExcelFlg().equals("Y")) {
				PriTrfInlndRtVO priTrfInlndRtVO = new PriTrfInlndRtVO();
				paramVo.setUpdUsrId(account.getUsr_id());			
				ObjectCloner.build(paramVo, priTrfInlndRtVO);
				
				// amend delete  .
				dbDao.modifyInlandRatesExcel1(priTrfInlndRtVO);
				
				// amend data amend delete  
				dbDao.modifyInlandRatesExcel2(priTrfInlndRtVO);
				
				// delete
				dbDao.removeInlandRatesExcel(priTrfInlndRtVO);
				
				// add
				for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {	
					
					dtlvo[i].setTrfPfxCd(paramVo.getTrfPfxCd());
					dtlvo[i].setTrfNo(paramVo.getTrfNo());
					dtlvo[i].setAmdtSeq(paramVo.getAmdtSeq());
					dtlvo[i].setTrfInlndSeq(paramVo.getTrfInlndSeq());
					dtlvo[i].setN1stCmncAmdtSeq(paramVo.getAmdtSeq());
					dtlvo[i].setSrcInfoCd(paramVo.getSrcInfoCd());
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
											
					dbDao.addInlandRatesExcel(dtlvo[i]);
				}
			} else {
				if ( insertDtlVoList.size() > 0 ) {
					dbDao.addInlandRatesLocationS(insertDtlVoList);
				}
			}
			
			/*
			if ( insertDtlVoList.size() > 0 ) {
				if(paramVo.getExcelFlg().equals("Y")) {
					PriTrfInlndRtVO priTrfInlndRtVO = new PriTrfInlndRtVO();
					paramVo.setUpdUsrId(account.getUsr_id());			
					ObjectCloner.build(paramVo, priTrfInlndRtVO);
					
 
					dbDao.modifyInlandRatesExcel1(priTrfInlndRtVO);
					
	 
					dbDao.modifyInlandRatesExcel2(priTrfInlndRtVO);
					
					// delete
					dbDao.removeInlandRatesExcel(priTrfInlndRtVO);
					
					// add
					for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {	
						
						dtlvo[i].setTrfPfxCd(paramVo.getTrfPfxCd());
						dtlvo[i].setTrfNo(paramVo.getTrfNo());
						dtlvo[i].setAmdtSeq(paramVo.getAmdtSeq());
						dtlvo[i].setTrfInlndSeq(paramVo.getTrfInlndSeq());
						dtlvo[i].setN1stCmncAmdtSeq(paramVo.getAmdtSeq());
						dtlvo[i].setSrcInfoCd(paramVo.getSrcInfoCd());
						dtlvo[i].setCreUsrId(account.getUsr_id());
						dtlvo[i].setUpdUsrId(account.getUsr_id());
												
						dbDao.addInlandRatesExcel(dtlvo[i]);
					}
					
				} else {
					dbDao.addInlandRatesLocationS(insertDtlVoList);
				}
			}
			*/
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyInlandRatesLocationS(updateDtlVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeInlandRatesLocationS(deleteDtlVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * deleting Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @exception EventException
	 */
	public void removeInlandRates(PriTrfInlndVO priTrfInlndVO) throws EventException {
		try {
			PriTrfInlndRtVO priTrfInlndRtVO = new PriTrfInlndRtVO();

			//file delete (del_flg update)
			if(!priTrfInlndVO.getAtchFileId().equals("") && priTrfInlndVO.getAtchFileId() != null) {
				UpdateFileMetaInfo.delete(priTrfInlndVO.getAtchFileId());
			}

			//Progress
			PriTrfInlndProgVO priTrfInlndProgVO = new PriTrfInlndProgVO();				
			ObjectCloner.build(priTrfInlndVO, priTrfInlndProgVO);
			dbDao.removeInlandRatesProgress(priTrfInlndProgVO);

			//Location Information Delete
			ObjectCloner.build(priTrfInlndVO, priTrfInlndRtVO);	
			dbDao.removeInlandRatesLocation(priTrfInlndRtVO);

			dbDao.removeInlandRates(priTrfInlndVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Requesting Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndProgVO priTrfInlandProgVO = new PriTrfInlndProgVO();
			
			if(priTrfInlndVO != null) {
				priTrfInlndVO.setUpdUsrId(account.getUsr_id());
				priTrfInlndVO.setRqstOfcCd(account.getOfc_cd());
				priTrfInlndVO.setTrfInlndStsCd("Q");
				dbDao.modifyInlandRatesStatus(priTrfInlndVO);
								
				ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
				priTrfInlandProgVO.setCreUsrId(account.getUsr_id());
				priTrfInlandProgVO.setUpdUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addInlandRatesProgress(priTrfInlandProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * canceling Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndProgVO priTrfInlandProgVO = new PriTrfInlndProgVO();
			PriTrfInlndRtVO priTrfInlandRtVO = new PriTrfInlndRtVO();
			
			if(priTrfInlndVO != null) {

				if(priTrfInlndVO.getTrfInlndStsCd().equals("Q")) {
					priTrfInlndVO.setTrfInlndStsCd("I");
				} else if(priTrfInlndVO.getTrfInlndStsCd().equals("A")) {
					priTrfInlndVO.setTrfInlndStsCd("Q");
				} else if(priTrfInlndVO.getTrfInlndStsCd().equals("I")) {
					priTrfInlndVO.setTrfInlndStsCd("X");
				}

				
				
				if(priTrfInlndVO.getTrfInlndStsCd().equals("X")) { //Amend Cancel
					ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
					dbDao.removeInlandRatesProgress(priTrfInlandProgVO);
					
					ObjectCloner.build(priTrfInlndVO, priTrfInlandRtVO);
					dbDao.removeInlandRatesLocation(priTrfInlandRtVO);
					
					dbDao.removeInlandRates(priTrfInlndVO);
				} else {
					priTrfInlndVO.setUpdUsrId(account.getUsr_id());
					priTrfInlndVO.setRqstOfcCd(account.getOfc_cd());				
					dbDao.modifyInlandRatesStatus(priTrfInlndVO);
									
					ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
					priTrfInlandProgVO.setCreUsrId(account.getUsr_id());
					priTrfInlandProgVO.setUpdUsrId(account.getUsr_id());
					priTrfInlandProgVO.setProgUsrId(account.getUsr_id());
					priTrfInlandProgVO.setProgOfcCd(account.getOfc_cd());
					dbDao.addInlandRatesProgress(priTrfInlandProgVO);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
		
	/**
	 * approving Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndProgVO priTrfInlandProgVO = new PriTrfInlndProgVO();
			
			if(priTrfInlndVO != null) {
				priTrfInlndVO.setUpdUsrId(account.getUsr_id());
				priTrfInlndVO.setRqstOfcCd(account.getOfc_cd());
				priTrfInlndVO.setTrfInlndStsCd("A");				
				dbDao.modifyInlandRatesStatus(priTrfInlndVO);
								
				ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
				priTrfInlandProgVO.setCreUsrId(account.getUsr_id());
				priTrfInlandProgVO.setUpdUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addInlandRatesProgress(priTrfInlandProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
		
	/**
	 * Publishing Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndProgVO priTrfInlandProgVO = new PriTrfInlndProgVO();
			
			if(priTrfInlndVO != null) {
				// Publish  
				priTrfInlndVO.setUpdUsrId(account.getUsr_id());				
				dbDao.modifyInlandRatesStatus(priTrfInlndVO);
				
				// modifying previous SEQ's EXP_DT = current SEQ's EFF_DT -1  
				dbDao.modifyInlandRatesPublish(priTrfInlndVO);
				
				// PROGRESS
				ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
				priTrfInlandProgVO.setCreUsrId(account.getUsr_id());
				priTrfInlandProgVO.setUpdUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addInlandRatesProgress(priTrfInlandProgVO);
				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Amending Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendInlandRates(PriTrfInlndVO priTrfInlndVO,SignOnUserAccount account) throws EventException{
		try {
			PriTrfInlndProgVO priTrfInlandProgVO = new PriTrfInlndProgVO();
			PriTrfInlndRtVO priTrfInlndRtVO = new PriTrfInlndRtVO();
			
			if(priTrfInlndVO != null) {				
				priTrfInlndVO.setUpdUsrId(account.getUsr_id());
				priTrfInlndVO.setCreUsrId(account.getUsr_id());
				priTrfInlndVO.setRqstOfcCd(account.getOfc_cd());	
				dbDao.addInlandRatesAmend(priTrfInlndVO);
				
				ObjectCloner.build(priTrfInlndVO, priTrfInlndRtVO);
				dbDao.addInlandRatesLocationAmend(priTrfInlndRtVO);
				
				ObjectCloner.build(priTrfInlndVO, priTrfInlandProgVO);
				priTrfInlandProgVO.setCreUsrId(account.getUsr_id());
				priTrfInlandProgVO.setUpdUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgUsrId(account.getUsr_id());
				priTrfInlandProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addInlandRatesProgress(priTrfInlandProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Inland Rate information <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesInquiryList(PriTrfInlndVO priTrfInlndVO) throws EventException {
		try {
			return dbDao.searchInlandRatesInquiryList(priTrfInlndVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
		
	/**
	 * retrieving Inland Rate Detail information <br>
	 * 
	 * @param PriTrfInlndRtVO priTrfInlndRtVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesInquiry(PriTrfInlndRtVO priTrfInlndRtVO) throws EventException {
		try {
			return dbDao.searchInlandRatesInquiry(priTrfInlndRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * retrieving Inland Rates Name information <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException {
		try {
			return dbDao.searchInlandRatesHistoryList(priTrfInlndHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * retrieving Inland Rates Amend information <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndVO> searchInlandRatesAmendHistoryList(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException {
		try {
			return dbDao.searchInlandRatesAmendHistoryList(priTrfInlndHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * retrieving Inland Rates Location information <br>
	 * 
	 * @param PriTrfInlndHistoryVO priTrfInlndHistoryVO
	 * @return List<RsltPriTrfInlndRtVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfInlndRtVO> searchInlandRatesHistory(PriTrfInlndHistoryVO priTrfInlndHistoryVO) throws EventException {
		try {
			return dbDao.searchInlandRatesHistory(priTrfInlndHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	/**
	 * retrieving Tariff Code List information <br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException {
		try {
			return dbDao.searchTariffCodeList(rsltCdListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
		
	/**
	 * checking Inland Rates Location excel information <br>
	 * 
	 * @param PriTrfInlndRtVO[] priTrfInlndRtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchInlandRatesCheck(PriTrfInlndRtVO[] priTrfInlndRtVO) throws EventException {
		
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			RsltCdListVO cdVO = null;
			
			for ( int i=0; i<priTrfInlndRtVO.length; i++ ) {
				//LOC.CODE
				vo.setCd(priTrfInlndRtVO[i].getInlndRtBseLocCd());
				cdVO = dbDao.searchLocationCodeExist(vo);
             	if (cdVO == null) {
             		cdVO = new RsltCdListVO();
             		cdVO.setCd(vo.getCd());					
             		cdVO.setNm("Loc. Code");				
             		cdVO.setEtc1(String.valueOf(i));		// Row index
             		cdVO.setEtc2("inlnd_rt_bse_loc_cd");	
             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
             		cdVO.setEtc4("PRI00315");				
             		cdVO.setEtc5("3");						
             		rslt.add(cdVO);
             	}
				//VIA
             	if(!priTrfInlndRtVO[i].getInlndRtViaLocCd().equals("")) {
	             	vo.setCd(priTrfInlndRtVO[i].getInlndRtViaLocCd());
					cdVO = dbDao.searchLocationCodeExist(vo);
	             	if (cdVO == null) {
	             		cdVO = new RsltCdListVO();
	             		cdVO.setCd(vo.getCd());
	             		cdVO.setNm("Via");
	             		cdVO.setEtc1(String.valueOf(i));
	             		cdVO.setEtc2("inlnd_rt_via_loc_cd");
	             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
	             		cdVO.setEtc4("PRI00315");
	             		cdVO.setEtc5("7");
	             		rslt.add(cdVO);
	             	}
             	}
             	
             	//CURRENCY
             	vo.setCd(priTrfInlndRtVO[i].getCurrCd());
				cdVO = dbDao.searchCurrencyCodeExist(vo);
             	if (cdVO == null) {
             		cdVO = new RsltCdListVO();
             		cdVO.setCd(vo.getCd());
             		cdVO.setNm("Currency");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("curr_cd");
             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
             		cdVO.setEtc4("PRI00315");
             		cdVO.setEtc5("13");
             		rslt.add(cdVO);
             	}
             	
             	//Term
             	if(!priTrfInlndRtVO[i].getInlndRtTermCd().equals("")) {
	             	vo.setCd(priTrfInlndRtVO[i].getInlndRtTermCd());
	             	vo.setEtc3("CD01725");
					cdVO = dbDao.searchComCodeExist(vo);
	             	if (cdVO == null) {
	             		cdVO = new RsltCdListVO();
	             		cdVO.setCd(vo.getCd());
	             		cdVO.setNm("Term");
	             		cdVO.setEtc1(String.valueOf(i));
	             		cdVO.setEtc2("inlnd_rt_term_cd");
	             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
	             		cdVO.setEtc4("PRI00315");
	             		cdVO.setEtc5("6");
	             		rslt.add(cdVO);
	             	}
             	}
             	
             	//Trans. Mode
             	if(!priTrfInlndRtVO[i].getPrcInlndRtTrspModCd().equals("")) {
	             	vo.setCd(priTrfInlndRtVO[i].getPrcInlndRtTrspModCd());
	             	vo.setEtc3("CD02772");
					cdVO = dbDao.searchComCodeExist(vo);
	             	if (cdVO == null) {
	             		cdVO = new RsltCdListVO();
	             		cdVO.setCd(vo.getCd());
	             		cdVO.setNm("Trans. Mode");
	             		cdVO.setEtc1(String.valueOf(i));
	             		cdVO.setEtc2("prc_inlnd_rt_trsp_mod_cd");
	             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
	             		cdVO.setEtc4("PRI00315");
	             		cdVO.setEtc5("8");
	             		rslt.add(cdVO);
	             	}
             	}
             	
             	//Weght Unit
             	if(!priTrfInlndRtVO[i].getInlndRtLmtWgtUtCd().equals("")) {
	             	vo.setCd(priTrfInlndRtVO[i].getInlndRtLmtWgtUtCd());
	             	vo.setEtc3("CD02764");
					cdVO = dbDao.searchComCodeExist(vo);
	             	if (cdVO == null) {
	             		cdVO = new RsltCdListVO();
	             		cdVO.setCd(vo.getCd());
	             		cdVO.setNm("Weght Unit");
	             		cdVO.setEtc1(String.valueOf(i));
	             		cdVO.setEtc2("inlnd_rt_lmt_wgt_ut_cd");
	             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
	             		cdVO.setEtc4("PRI00315");
	             		cdVO.setEtc5("11");
	             		rslt.add(cdVO);
	             	}
             	}
             	
             	//Type
             	if(!priTrfInlndRtVO[i].getPrcCgoTpCd().equals("")) {
	             	vo.setCd(priTrfInlndRtVO[i].getPrcCgoTpCd());
	             	vo.setEtc3("CD01701");
					cdVO = dbDao.searchComCodeExist(vo);
	             	if (cdVO == null) {
	             		cdVO = new RsltCdListVO();
	             		cdVO.setCd(vo.getCd());
	             		cdVO.setNm("Type");
	             		cdVO.setEtc1(String.valueOf(i));
	             		cdVO.setEtc2("prc_cgo_tp_cd");
	             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
	             		cdVO.setEtc4("PRI00315");
	             		cdVO.setEtc5("12");
	             		rslt.add(cdVO);
	             	}
             	}

             	/////////////////////////////////////////////
             	String tMin = priTrfInlndRtVO[i].getInlndRtMinLmtWgt();
             	String tMax = priTrfInlndRtVO[i].getInlndRtLmtWgt();
             	String tUnit = priTrfInlndRtVO[i].getInlndRtLmtWgtUtCd();
             	
             	if((!tMax.equals("") || !tMin.equals("")) && tUnit.equals("")) {
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("Weight Unit");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_rt_lmt_wgt_ut_cd");
             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("11");
             		rslt.add(cdVO);
             	}
             	
             	if((tMax.equals("") && tMin.equals("")) && !tUnit.equals("")) {
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("Weight");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_rt_min_lmt_wgt");
             		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("9");
             		rslt.add(cdVO);
             	}
             	
        		//  min > max  X
        		if(!tMax.equals("") && !tMin.equals("") && !tUnit.equals("")){
        			//if(Float.parseFloat(tMin) > Float.parseFloat(tMax)) {
        			if(Float.compare(Float.parseFloat(tMin), Float.parseFloat(tMax)) > 0 ) {
        				cdVO = new RsltCdListVO();
                 		cdVO.setCd("");
                 		cdVO.setNm("Weight");
                 		cdVO.setEtc1(String.valueOf(i));
                 		cdVO.setEtc2("inlnd_rt_min_lmt_wgt");
                 		cdVO.setEtc3(priTrfInlndRtVO[i].getTrfInlndRtSeq());	// Seq.
                 		cdVO.setEtc4("PRI08008");
                 		cdVO.setEtc5("9");
                 		rslt.add(cdVO);
        			}
        		}
             	
        		//One Way & Round Trip CAN NTO ALL null  

             	/*
        		if(priTrfInlndRtVO[i].getInlndBxRtAmt().equals("") && priTrfInlndRtVO[i].getInlnd20ftRtAmt().equals("")
             			&& priTrfInlndRtVO[i].getInlnd40ftRtAmt().equals("") && priTrfInlndRtVO[i].getInlnd40ftHcRtAmt().equals("")
             			&& priTrfInlndRtVO[i].getInlnd45ftRtAmt().equals("") && priTrfInlndRtVO[i].getInlndOneWyBxRtAmt().equals("")
             			&& priTrfInlndRtVO[i].getInlndOneWy20ftRtAmt().equals("") && priTrfInlndRtVO[i].getInlndOneWy40ftRtAmt().equals("")
             			&& priTrfInlndRtVO[i].getInlndOneWy40ftHcRtAmt().equals("") && priTrfInlndRtVO[i].getInlndOneWy45ftRtAmt().equals("")) {
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_bx_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("14");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_20ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("15");
             		rslt.add(cdVO);

             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_40ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("16");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_40ft_hc_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("17");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_45ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("18");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_one_wy_bx_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("19");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_one_wy_20ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("20");
             		rslt.add(cdVO);
             		
             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_one_wy_40ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("21");
             		rslt.add(cdVO);

             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_one_wy_40ft_hc_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("22");
             		rslt.add(cdVO);

             		cdVO = new RsltCdListVO();
             		cdVO.setCd("");
             		cdVO.setNm("rate");
             		cdVO.setEtc1(String.valueOf(i));
             		cdVO.setEtc2("inlnd_one_wy_45ft_rt_amt");
             		cdVO.setEtc4("PRI00308");
             		cdVO.setEtc5("23");
             		rslt.add(cdVO);
             	}
        		*/
			}
			return rslt;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Inland Rate Max Seq <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxSeq(PriTrfInlndVO priTrfInlndVO) throws EventException{
		try {
			return dbDao.searchInlandRatesMaxSeq(priTrfInlndVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * retrieving Inland Rate Location Max Seq <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesLocationMaxSeq(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException{
		try {
			return dbDao.searchInlandRatesLocationMaxSeq(priTrfInlndParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * retrieving Inland Rate Location's last update date information <br>
	 * 
	 * @param PriTrfInlndParamVO priTrfInlndParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesMaxUpdate(PriTrfInlndParamVO priTrfInlndParamVO) throws EventException{
		try {
			return dbDao.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}

	/**
	 * retrieving existence of Inland Rate <br>
	 * 
	 * @param PriTrfInlndVO priTrfInlndVO
	 * @return String
	 * @exception EventException
	 */
	public String searchInlandRatesExistCheck(PriTrfInlndVO priTrfInlndVO) throws EventException{
		try {
			return dbDao.searchInlandRatesExistCheck(priTrfInlndVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
}


	
	
	