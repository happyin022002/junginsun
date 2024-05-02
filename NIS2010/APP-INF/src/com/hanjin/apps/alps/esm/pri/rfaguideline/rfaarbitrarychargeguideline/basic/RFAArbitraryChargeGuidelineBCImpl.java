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
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration.RFAArbitraryChargeGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbTypeVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.vo.RsltPriRgArbVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgArbVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-RFAGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-RFAGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see UI_PRI_0002_03EventResponse,RFAArbitraryChargeGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAArbitraryChargeGuidelineBCImpl extends BasicCommandSupport implements RFAArbitraryChargeGuidelineBC {

	// Database Access Object
	private transient RFAArbitraryChargeGuidelineDBDAO dbDao = null;

	/**
	 * RFAArbitraryChargeGuidelineBCImpl 객체 생성<br>
	 * RFAArbitraryChargeGuidelineDBDAO를 생성한다.<br>
	 */
	public RFAArbitraryChargeGuidelineBCImpl() {
		dbDao = new RFAArbitraryChargeGuidelineDBDAO();
	}
	
	/**
	 * Arbitrary List 갯수와 font type을 조회한다. <br>
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
	 * Guideline Arbitrary를 조회합니다. <br>
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
	 * Guideline Arbitrary를 수정합니다. <br>
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
	 * Guideline main에서 전체 Guideline를 삭제합니다. <br>
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
	 * 엑셀파일을 업로드합니다.<br>
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
	 * RFA Guideline Arbitrary Charge 정보를 Copy 합니다.<br>
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
	 * 엑셀파일을 체크합니다.<br>
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