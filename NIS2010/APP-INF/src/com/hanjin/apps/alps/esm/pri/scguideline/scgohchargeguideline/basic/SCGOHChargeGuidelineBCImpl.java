/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineBCImpl.java
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.16 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.integration.SCGOHChargeGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGohChgVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see UI_PRI_0001_005EventResponse,SCGOHChargeGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCGOHChargeGuidelineBCImpl extends BasicCommandSupport implements SCGOHChargeGuidelineBC {

	// Database Access Object
	private transient SCGOHChargeGuidelineDBDAO dbDao = null;

	/**
	 * SCGOHChargeGuidelineBCImpl 객체 생성<br>
	 * SCGOHChargeGuidelineDBDAO를 생성한다.<br>
	 */
	public SCGOHChargeGuidelineBCImpl() {
		dbDao = new SCGOHChargeGuidelineDBDAO();
	}
	/**
	 * S/C Guideline GOH Charge 정보를 조회합니다.<br>
	 * 
	 * @param PriSgGohChgVO priSgGohChgVO
	 * @return List<RsltPriSgGohChgVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGohChgVO> searchGOHChargeGuidelineList(PriSgGohChgVO priSgGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeGuidelineList(priSgGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * GOHChargeGuideline을 저장합니다.<br>
	 * 
	 * @param PriSgGohChgVO[] priSgGohChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHChargeGuideline(PriSgGohChgVO[] priSgGohChgVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriSgGohChgVO> insertVoList = new ArrayList<PriSgGohChgVO>();
			List<PriSgGohChgVO> updateVoList = new ArrayList<PriSgGohChgVO>();
			List<PriSgGohChgVO> deleteVoList = new ArrayList<PriSgGohChgVO>();
			for ( int i=0; i<priSgGohChgVOs .length; i++ ) {
				if ( priSgGohChgVOs[i].getIbflag().equals("I")){
					priSgGohChgVOs[i].setCreUsrId(account.getUsr_id());
					priSgGohChgVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSgGohChgVOs[i]);
				} else if ( priSgGohChgVOs[i].getIbflag().equals("U")){
					priSgGohChgVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSgGohChgVOs[i]);
				} else if ( priSgGohChgVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priSgGohChgVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGOHChargeGuidelineS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGOHChargeGuidelineS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGOHChargeGuidelineS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * GOHChargeGuideline을 삭제합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {

			dbDao.removeGuidelineMainGOH(priSgMnVO);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * GOH Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.addGuidelineMainGOHCopy(glineMnCpVO);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
}