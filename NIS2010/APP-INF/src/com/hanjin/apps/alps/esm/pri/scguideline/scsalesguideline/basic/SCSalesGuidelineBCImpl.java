/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scsalesguideline.integration.SCSalesGuidelineDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgSlsRefVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCSalesGuidelineBCImpl extends BasicCommandSupport implements SCSalesGuidelineBC {

	// Database Access Object
	private transient SCSalesGuidelineDBDAO dbDao = null;

	/**
	 * SCGuidelineMainBCImpl 객체 생성<br>
	 * SCGuidelineMainDBDAO를 생성한다.<br>
	 */
	public SCSalesGuidelineBCImpl() {
		dbDao = new SCSalesGuidelineDBDAO();
	}

	/**
	 * Sales Guideline을 조회합니다. <br>
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
	 * Sales Guideline 데이터의 CUD 멀티 이벤트를 처리합니다. <br>
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
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