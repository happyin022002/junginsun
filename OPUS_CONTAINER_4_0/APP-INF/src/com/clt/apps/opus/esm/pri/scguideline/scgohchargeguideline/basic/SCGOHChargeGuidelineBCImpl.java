/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineBCImpl.java
*@FileTitle : S/C GOH Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.integration.SCGOHChargeGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.vo.RsltPriSgGohChgVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGohChgVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about  SCGuidelin.<br>
 *
 * @author
 * @see UI_PRI_0001_005EventResponse,SCGOHChargeGuidelineBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCGOHChargeGuidelineBCImpl extends BasicCommandSupport implements SCGOHChargeGuidelineBC {

	// Database Access Object
	private transient SCGOHChargeGuidelineDBDAO dbDao = null;

	/**
	 * Creating SCGOHChargeGuidelineBCImpl object<br>
	 * Creating SCGOHChargeGuidelineDBDAO<br>
	 */
	public SCGOHChargeGuidelineBCImpl() {
		dbDao = new SCGOHChargeGuidelineDBDAO();
	}
	/**
	 * Retrieving S/C Guideline GOH Charge<br>
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
	 * Saving GOHChargeGuideline<br>
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
	 * Deleting GOHChargeGuideline<br>
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
	 * Copying GOH Guideline<br>
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