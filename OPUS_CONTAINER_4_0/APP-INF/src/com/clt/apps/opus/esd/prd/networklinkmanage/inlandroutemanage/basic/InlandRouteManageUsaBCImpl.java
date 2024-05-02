/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageBCImpl.java
 *@FileTitle : Inland Route Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration.InlandRouteManageUsaDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.CheckWrsVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * @author jungsunyong
 * @see ESD_PRD_057EventResponse,InlandRouteManageBC
 * @since J2EE 1.4
 */
public class InlandRouteManageUsaBCImpl extends BasicCommandSupport implements InlandRouteManageUsaBC {

	// Database Access Object
	private transient InlandRouteManageUsaDBDAO dbDao = null;

	/**
	 * creating InlandRouteManageBCImpl Object<br>
	 * creating InlandRouteManageDBDAO<br>
	 */
	public InlandRouteManageUsaBCImpl() {
		dbDao = new InlandRouteManageUsaDBDAO();
	}

	/**
	 * Retrieving master - nlandRouteManage
	 * @param inlandRouteUSVO
	 * @return
	 * @throws EventException
	 */
	public List<lnlandRouteUSVO> searchInlandRouteMasterUSA(lnlandRouteUSVO inlandRouteUSVO) throws EventException {
		try {
			return dbDao.searchInlandRouteMasterUSA(inlandRouteUSVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * Retrieving detail - nlandRouteManage
	 * @param searchConditionVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteUSDetVO> searchInlandRouteDetailUSA(SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchInlandRouteDetailUSA(searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param inlandRouteUSVO
	 * @param params
	 * @param account
	 * @throws EventException
	 */
	public void saveInlandRouteMasterUSA(lnlandRouteUSVO[] inlandRouteUSVO, lnlandRouteUSVO params, SignOnUserAccount account) throws EventException {
		try {
			List<lnlandRouteUSVO> deleteVoList = new ArrayList<lnlandRouteUSVO>();
			List<lnlandRouteUSVO> updateVoList = new ArrayList<lnlandRouteUSVO>();
			List<lnlandRouteUSVO> update2VoList = new ArrayList<lnlandRouteUSVO>();

			for (int i = 0; i < inlandRouteUSVO.length; i++) {
				inlandRouteUSVO[i].setCreUsrId(account.getUsr_id());
				inlandRouteUSVO[i].setRInbound(params.getRBtnIrgCd());
				inlandRouteUSVO[i].setUpdUsrId(account.getUsr_id());
				inlandRouteUSVO[i].setInlndRoutTmpFlg(inlandRouteUSVO[i].getInlndRoutTmpFlg().equals("1") ? "Y" : "N");
				inlandRouteUSVO[i].setInlndRoutInclSttlFlg(inlandRouteUSVO[i].getInlndRoutInclSttlFlg().equals("1") ? "Y" : "N");
				inlandRouteUSVO[i].setCreOfcCd(account.getOfc_cd());
				if (inlandRouteUSVO[i].getIbflag().equals("D")) {
					deleteVoList.add(inlandRouteUSVO[i]);
				} else if (!inlandRouteUSVO[i].getIbflag().equals("D")) {
					if (inlandRouteUSVO[i].getWrsFullCmdt().equals("1")) {
						CheckWrsVO itm = new CheckWrsVO();

						itm.setRInbound(params.getRBtnIrgCd());
						itm.setRoutDestNodCd(inlandRouteUSVO[i].getRoutDestNodCd());
						itm.setRoutOrgNodCd(inlandRouteUSVO[i].getRoutOrgNodCd());
						itm.setRoutSeq(inlandRouteUSVO[i].getRoutSeq());

						List<CheckWrsVO> checkwrs = dbDao.getChkWrs(itm);
						if (checkwrs.size() >= 1) {
							if ("Y".equals(checkwrs.get(0).getWrs())) {
								throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteUSVO[i].getRoutDestNodCd() + "-" + inlandRouteUSVO[i].getRoutOrgNodCd() + "]").getMessage());
							}
						}
					}
					if (params.getIDelFlg().equals("Y")) {
						updateVoList.add(inlandRouteUSVO[i]);
					} else {
						update2VoList.add(inlandRouteUSVO[i]);
					}
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.saveInlandRouteMasterUSA01(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.saveInlandRouteMasterUSA02(updateVoList);
			}
			if (update2VoList.size() > 0) {
				dbDao.saveInlandRouteMasterUSA01(update2VoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageUsaBCImpl's saveInlandRoutePriorityUSA<br>
	 * @param inlandRouteUSVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void saveInlandRoutePriorityUSA(lnlandRouteUSVO[] inlandRouteUSVO, SignOnUserAccount account) throws EventException {
		try {

			List<lnlandRouteUSVO> updateVoList = new ArrayList<lnlandRouteUSVO>();

			for (int i = 0; i < inlandRouteUSVO.length; i++) {

				if (inlandRouteUSVO[i].getIbflag().equals("U")) {
					inlandRouteUSVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(inlandRouteUSVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.saveInlandRoutePriorityUSA(updateVoList);
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
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
