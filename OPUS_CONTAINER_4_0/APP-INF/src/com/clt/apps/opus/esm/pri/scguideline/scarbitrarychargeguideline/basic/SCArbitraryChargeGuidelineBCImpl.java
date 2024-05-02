/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCArbitraryChargeGuidelineBCImpl.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.integration.SCArbitraryChargeGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgArbVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline.<br>
 *
 * @author 
 * @see UI_PRI_0001_04EventResponse,SCArbitraryChargeGuidelineBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCArbitraryChargeGuidelineBCImpl extends BasicCommandSupport implements SCArbitraryChargeGuidelineBC {

	// Database Access Object
	private transient SCArbitraryChargeGuidelineDBDAO dbDao = null;

	/**
	 * Creating SCArbitraryChargeGuidelineBCImpl object<br>
	 * Creating SCArbitraryChargeGuidelineDBDAO.<br>
	 */
	public SCArbitraryChargeGuidelineBCImpl() {
		dbDao = new SCArbitraryChargeGuidelineDBDAO();
	}
	/**
	 * Retrieving Arbitrary Charge Type의 Count<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbTypeVO> searchArbitraryChargeTypeCountList(PriSgArbVO priSgArbVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeTypeCountList(priSgArbVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}	
	/**
	 * Retrieving Arbitrary Charge Guide Line List<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriSgArbVO> searchArbitraryChargeGuidelineList(PriSgArbVO priSgArbVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeGuidelineList(priSgArbVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}
	/**
	 * Saving Arbitrary Charge<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriSgArbVO> insertVoList = new ArrayList<PriSgArbVO>();
			List<PriSgArbVO> updateVoList = new ArrayList<PriSgArbVO>();
			List<PriSgArbVO> deleteVoList = new ArrayList<PriSgArbVO>();
					
			for ( int i=0; i<priSgArbVOs .length; i++ ) {
				if ( priSgArbVOs[i].getIbflag().equals("I")){
					priSgArbVOs[i].setCreUsrId(account.getUsr_id());
					priSgArbVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSgArbVOs[i]);
				} else if ( priSgArbVOs[i].getIbflag().equals("U")){
					priSgArbVOs[i].setUpdUsrId(account.getUsr_id());				
					updateVoList.add(priSgArbVOs[i]);
				} else if ( priSgArbVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priSgArbVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryChargeGuidelineS(insertVoList);
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyArbitraryChargeGuidelineS(updateVoList);
			}			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeArbitraryChargeGuidelineS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Deleting Arbitrary Charge<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainArbitraryCharge(priSgMnVO);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Uploading excep datas<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriSgArbVO[] priSgArbVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriSgArbVO> insertVoList = new ArrayList<PriSgArbVO>();
								
			for ( int i=0; i<priSgArbVOs .length; i++ ) {
				if ( priSgArbVOs[i].getIbflag().equals("I")){
					priSgArbVOs[i].setCreUsrId(account.getUsr_id());
					priSgArbVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSgArbVOs[i]);
				} 
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.addArbitraryExcel(insertVoList);
			}			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Copying Arbitray Guideline <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.addGuidelineMainArbitraryChargeCopy(glineMnCpVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Checking validation for excel file datas<br>
	 * 
	 * @param PriSgArbVO[] priSgArbVOs
	 * @return List<PriSgArbVO>
	 * @exception EventException
	 */
	public List<PriSgArbVO> searchCodeCheckResult(PriSgArbVO[] priSgArbVOs) throws EventException{
		try {
			List<PriSgArbVO> checkVoList = new ArrayList<PriSgArbVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			
			for ( int i=0; i<priSgArbVOs.length; i++ ) {
				//Point
				vo.setCd(priSgArbVOs[i].getRoutPntLocDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if(cdList != null && cdList.size()>0) {
					priSgArbVOs[i].setRoutPntLocDefCd("1");
				} else {
					priSgArbVOs[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priSgArbVOs[i].getBsePortDefCd());
				vo.setEtc1(priSgArbVOs[i].getSvcScpCd());
				vo.setEtc2(priSgArbVOs[i].getGlineSeq());
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchExcelCodeList(vo, "GRP");
				} else {
					cdList = dbDao.searchExcelCodeList(vo, "LOC");
				}    			
				
				if(cdList != null && cdList.size()>0) {
					priSgArbVOs[i].setBsePortDefCd("1");
				} else {
					priSgArbVOs[i].setBsePortDefCd("0");
				}
				
				//VIA
				vo.setCd(priSgArbVOs[i].getViaPortDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if(cdList != null && cdList.size()>0) {
					priSgArbVOs[i].setViaPortDefCd("1");
				} else {
					priSgArbVOs[i].setViaPortDefCd("0");
				}				
				
				checkVoList.add(priSgArbVOs[i]);
			} 
			
			return checkVoList;
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);

		}
	}
}