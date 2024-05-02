/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : InlandCutOffTimeManageBCImpl.JAVA
 *@FileTitle : Inland Cut Off Time Management
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration.InlandCutOffTimeManageDAO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PrdInlndCutOffTmMgmtVO;

/**
 * Inland Cut Off Time Management Command implementation<br>
 * 
 * @author
 * @see ESD_PRD_0038EventResponse
 * @since J2EE 1.4
 */
public class InlandCutOffTimeManageBCImpl extends BasicCommandSupport implements InlandCutOffTimeManageBC {
	private transient InlandCutOffTimeManageDAO inlandCutOffTimeManageDAO = null;

	public InlandCutOffTimeManageBCImpl() {
		inlandCutOffTimeManageDAO = new InlandCutOffTimeManageDAO();
	}

	/**
	 * searchInlandCutOffTime
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<AbstractValueObject> searchInlandCutOffTime(PrdInlndCutOffTmMgmtVO vo) throws EventException {
		try {
			return inlandCutOffTimeManageDAO.searchInlandCutOffTime(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param vos
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public int multiInlandCutOffTime(PrdInlndCutOffTmMgmtVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			List<PrdInlndCutOffTmMgmtVO> mergeVos = new ArrayList<PrdInlndCutOffTmMgmtVO>();
			List<PrdInlndCutOffTmMgmtVO> deleteVos = new ArrayList<PrdInlndCutOffTmMgmtVO>();

			for (PrdInlndCutOffTmMgmtVO vo : vos) {
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				if (vo.getIbflag().equals("I")) {
					if (inlandCutOffTimeManageDAO.dupcheck(vo) > 0) {
						throw new EventException(new ErrorHandler("COM12115", new String[] { vo.getLaneCd() + "-" + vo.getOrgYdCd() + "-" + vo.getDestYdCd() + "-Priority " + vo.getPrioSeq() }).getMessage());
					}
				}
				if (vo.getIbflag().equals("D")) {
					deleteVos.add(vo);
				} else {
					mergeVos.add(vo);
				}
			}
			if (deleteVos.size() > 0) {
				inlandCutOffTimeManageDAO.managePrdInlndCutOffTmMgmt(deleteVos, "D");
			}
			if (mergeVos.size() > 0) {
				inlandCutOffTimeManageDAO.managePrdInlndCutOffTmMgmt(mergeVos, "M");
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return 0;
	}

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int checkEffectDate(PrdInlndCutOffTmMgmtVO vo) throws EventException {
		try {
			return inlandCutOffTimeManageDAO.checkEffectDate(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
