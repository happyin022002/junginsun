/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCArbitraryChargeGuidelineBCImpl.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.integration.SCArbitraryChargeGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgArbVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see UI_PRI_0001_04EventResponse,SCArbitraryChargeGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCArbitraryChargeGuidelineBCImpl extends BasicCommandSupport implements SCArbitraryChargeGuidelineBC {

	// Database Access Object
	private transient SCArbitraryChargeGuidelineDBDAO dbDao = null;

	/**
	 * SCArbitraryChargeGuidelineBCImpl 객체 생성<br>
	 * SCArbitraryChargeGuidelineDBDAO를 생성한다.<br>
	 */
	public SCArbitraryChargeGuidelineBCImpl() {
		dbDao = new SCArbitraryChargeGuidelineDBDAO();
	}
	/**
	 * Arbitrary Charge Type의 Count를 조회합니다.<br>
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
	 * Arbitrary Charge Guide Line List를 조회합니다.<br>
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
	 * Arbitrary Charge를 저장합니다.<br>
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
	 * Arbitrary Charge를 삭제합니다.<br>
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
	 * 엑셀로드 팝업에 대한 엑셀로드 처리<br>
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
	 * Arbitray Guideline Copy를 처리합니다. <br>
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
	 * 엑셀파일 데이터를 VALIDATION 체크한다.<br>
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