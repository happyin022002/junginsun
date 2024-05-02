/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.integration.SCSalesGuidelineDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;
import com.clt.syscommon.common.table.PriSgSlsRefVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC refer to each DAO class
 * @since J2EE 1.4
 */

public class SCSalesGuidelineBCImpl extends BasicCommandSupport implements SCSalesGuidelineBC {

	// Database Access Object
	private transient SCSalesGuidelineDBDAO dbDao = null;

	/**
	 * Creating SCGuidelineMainBCImpl Object <br>
	 * Creating SCGuidelineMainDBDAO.<br>
	 */
	public SCSalesGuidelineBCImpl() {
		dbDao = new SCSalesGuidelineDBDAO();
	}

	/**
	 * Retrieving Sales Guideline <br>
	 * 
	 * @param PriSgSlsRefVO priSgSlsRefVO
	 * @return List<PriSgSlsRefVO>
	 * @exception EventException
	 */
	public List<PriSgSlsRefVO> searchSalesGuidelineList(PriSgSlsRefVO priSgSlsRefVO) throws EventException {
		try {
			return dbDao.searchSalesGuidelineList(priSgSlsRefVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *  Handling CUD Multi-event of Sales Guideline data <br>
	 * 
	 * @param PriSgSlsRefVO[] priSgSlsRefVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSalesGuideline(PriSgSlsRefVO[] priSgSlsRefVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriSgSlsRefVO> insertVoList = new ArrayList<PriSgSlsRefVO>();
			List<PriSgSlsRefVO> updateVoList = new ArrayList<PriSgSlsRefVO>();
			List<PriSgSlsRefVO> deleteVoList = new ArrayList<PriSgSlsRefVO>();
			for (int i = 0; i < priSgSlsRefVOs.length; i++) {
				if (priSgSlsRefVOs[i].getIbflag().equals("I")) {
					priSgSlsRefVOs[i].setCreUsrId(account.getUsr_id());
					priSgSlsRefVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSgSlsRefVOs[i]);
				} else if (priSgSlsRefVOs[i].getIbflag().equals("U")) {
					priSgSlsRefVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSgSlsRefVOs[i]);
				} else if (priSgSlsRefVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(priSgSlsRefVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addSalesGuideline(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifySalesGuideline(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeSalesGuideline(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Deleting from guideline from Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainSalesGuideline(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
}