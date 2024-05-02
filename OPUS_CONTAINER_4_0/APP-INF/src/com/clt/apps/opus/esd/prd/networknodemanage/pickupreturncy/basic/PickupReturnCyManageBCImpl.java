/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManageImpl.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration.PickupReturnCyManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse,BlockStowageManage
 * @since J2EE 1.4
 */
public class PickupReturnCyManageBCImpl extends BasicCommandSupport implements PickupReturnCyManageBC {

	private transient PickupReturnCyManageDBDAO dbDao = null;

	/**
	 * creating BlockStowageManageImpl Object<br>
	 * creating YardManageDBDAO<br>
	 */
	public PickupReturnCyManageBCImpl() {
		dbDao = new PickupReturnCyManageDBDAO();
	}

	/**
	 * retrieving
	 * 
	 * @param vo
	 * @return EventResponse ESD_PRD_002EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List searchPickupList(PickupReturnCYVO vo) throws EventException {
		try {
			return dbDao.searchPickupList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving
	 * 
	 * @param vos
	 * @param account
	 * @exception EventException
	 */
	public void multiPickupReturnCY(PickupReturnCYVO[] vos, SignOnUserAccount account) throws EventException {
		try {
//			DBRowSet rowSet = null;
//			for (int i = 0; i < vos.length; i++) {
//				if (vos[i].getIbflag().equals("I")) {
//					rowSet = dbDao.cnkDupPickupReturnCY(vos[i]);
//					if (rowSet.next()) {
//						if (rowSet.getInt("dup_cnt") > 0) {
//							throw new EventException(new ErrorHandler("PRD99998", new String[] { "Duplication Data." }).getMessage());
//						}
//					}
//				}
//			}
			List<PickupReturnCYVO> updateVos = new ArrayList<PickupReturnCYVO>();
			for (int i = 0; i < vos.length; i++) {
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				if (vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U") || vos[i].getIbflag().equals("D")) {
					updateVos.add(vos[i]);
				}
			}
			if (!updateVos.isEmpty()) {
				dbDao.updatePickupReturnCY(updateVos);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
