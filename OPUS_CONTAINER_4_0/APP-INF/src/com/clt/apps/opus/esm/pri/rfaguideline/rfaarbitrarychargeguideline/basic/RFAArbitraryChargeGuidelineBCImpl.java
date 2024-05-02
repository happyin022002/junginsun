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
package com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration.RFAArbitraryChargeGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbTypeVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgArbVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * RFAGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about RFAGuideline<br>
 *
 * @author JaeYeon Kim
 * @see UI_PRI_0002_03EventResponse,RFAArbitraryChargeGuidelineBC - refer to each  DAO class
 * @since J2EE 1.4
 */

public class RFAArbitraryChargeGuidelineBCImpl extends BasicCommandSupport implements RFAArbitraryChargeGuidelineBC {

	// Database Access Object
	private transient RFAArbitraryChargeGuidelineDBDAO dbDao = null;

	/**
	 * Creating RFAArbitraryChargeGuidelineBCImpl object<br>
	 * Creating RFAArbitraryChargeGuidelineDBDAO<br>
	 */
	public RFAArbitraryChargeGuidelineBCImpl() {
		dbDao = new RFAArbitraryChargeGuidelineDBDAO();
	}
	
	/**
	 *Retrieving count of Arbitrary List and font type <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbTypeVO> searchArbitraryChargeTypeCountList(PriRgArbVO priRgArbVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeTypeCountList(priRgArbVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Retrieving Guideline Arbitrary <br>
	 * 
	 * @param PriRgArbVO priRgArbVO
	 * @return List<RsltPriRgArbVO>
	 * @exception EventException
	 */
	public List<RsltPriRgArbVO> searchArbitraryChargeGuidelineList(PriRgArbVO priRgArbVO) throws EventException {
		try {
			return dbDao.searchArbitraryChargeGuidelineList(priRgArbVO);
		} catch (DAOException de) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Modifying Guideline Arbitrary <br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRgArbVO> insertVoList = new ArrayList<PriRgArbVO>();
			List<PriRgArbVO> updateVoList = new ArrayList<PriRgArbVO>();
			List<PriRgArbVO> deleteVoList = new ArrayList<PriRgArbVO>();
					
			for ( int i=0; i<priRgArbVO .length; i++ ) {
				if ( priRgArbVO[i].getIbflag().equals("I")){
					priRgArbVO[i].setCreUsrId(account.getUsr_id());
					priRgArbVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRgArbVO[i]);
				} else if ( priRgArbVO[i].getIbflag().equals("U")){
					priRgArbVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRgArbVO[i]);
				} else if ( priRgArbVO[i].getIbflag().equals("D")){
					deleteVoList.add(priRgArbVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageArbitraryChargeGuidelineS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageArbitraryChargeGuidelineS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageArbitraryChargeGuidelineS(deleteVoList);
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
	 * Deleting total guideline from Guideline main <br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException {
		try {

			dbDao.removeGuidelineMainArbitraryCharge(priRgMnVO);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Uplading excel file<br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeGuideline(PriRgArbVO[] priRgArbVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRgArbVO> insertVoList = new ArrayList<PriRgArbVO>();
								
			for ( int i=0; i<priRgArbVO .length; i++ ) {
				if ( priRgArbVO[i].getIbflag().equals("I")){
					priRgArbVO[i].setCreUsrId(account.getUsr_id());
					priRgArbVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRgArbVO[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageArbitraryExcel(insertVoList);
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
	 * Copying RFA Guideline Arbitrary Charge information<br>
	 * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException {
		try {
            rsltRfaGlineCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaGlineCopyVO.setUpdUsrId(account.getUsr_id());
            
			dbDao.addGlineCopyArbitraryCharge(rsltRfaGlineCopyVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Checking excel file<br>
	 * 
	 * @param PriRgArbVO[] priRgArbVO
	 * @return List<PriRgArbVO>
	 * @exception EventException
	 */
	public List<PriRgArbVO> searchCodeCheckResult(PriRgArbVO[] priRgArbVO) throws EventException{
		try {
			List<PriRgArbVO> checkVoList = new ArrayList<PriRgArbVO>();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			RsltCdListVO vo = new RsltCdListVO();
			
			for ( int i=0; i<priRgArbVO.length; i++ ) {
				//Point
				vo.setCd(priRgArbVO[i].getRoutPntLocDefCd());
				cdList = dbDao.searchExcelCodeList(vo, "LOC");
				if(cdList != null && cdList.size()>0) {
					priRgArbVO[i].setRoutPntLocDefCd("1");
				} else {
					priRgArbVO[i].setRoutPntLocDefCd("0");
				}
				
				//Base Port
				vo.setCd(priRgArbVO[i].getBsePortDefCd());
				vo.setEtc1(priRgArbVO[i].getSvcScpCd());
				vo.setEtc2(priRgArbVO[i].getGlineSeq());
				if(vo.getCd().length() == 4) {
					cdList = dbDao.searchExcelCodeList(vo, "GRP");
				} else {
					cdList = dbDao.searchExcelCodeList(vo, "LOC");
				}    			
				
				if(cdList != null && cdList.size()>0) {
					priRgArbVO[i].setBsePortDefCd("1");
				} else {
					priRgArbVO[i].setBsePortDefCd("0");
				}
								
				checkVoList.add(priRgArbVO[i]);
			} 
			
			return checkVoList;
			
		}  catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), de);
		}
	}
}