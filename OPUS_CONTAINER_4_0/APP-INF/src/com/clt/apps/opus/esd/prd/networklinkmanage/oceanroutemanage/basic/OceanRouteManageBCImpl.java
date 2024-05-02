/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteManageBCImpl.java
 *@FileTitle : OceanLink Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration.OceanRouteManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_014EventResponse,OceanRouteManageBC
 * @since J2EE 1.4
 */
public class OceanRouteManageBCImpl extends BasicCommandSupport implements OceanRouteManageBC {

	// Database Access Object
	private transient OceanRouteManageDBDAO dbDao = null;

	/**
	 * creating OceanRouteManageBCImpl<br>
	 * creating OceanRouteManageDBDAO<br>
	 */
	public OceanRouteManageBCImpl() {
		dbDao = new OceanRouteManageDBDAO();
	}

	/**
	 * retrieving - OceanRouteManage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteListVO> searchOceanRouteList(SearchConditionVO vo) throws EventException {
		try {

			if (JSPUtil.getNull(vo.getIDelFlag()).equals("Y")) {
				return dbDao.searchOceanRouteDelList(vo);
			} else {
				return dbDao.searchOceanRouteList(vo);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * multi event - ESD_PRD_0014
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRoute(SaveOceanRouteVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			DBRowSet dRs = null;
			for (int i = 0; i < vos.length; i++) {
				String tsIndCd = "D";
				if (Integer.parseInt(vos[i].getSLnkCnt()) > 1) {
					tsIndCd = "T";
				}
				vos[i].setTsIndCd(tsIndCd);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());
				if (vos[i].getIbflag().equals("I")) {
					dRs = dbDao.delChkPs(vos[i]);
					if (dRs.next()) {
						String upIndCd = dRs.getString("UPD_IND_CD");
						if ("Y".equals(upIndCd) || "O".equals(upIndCd) || "N".equals(upIndCd)) {
							if ("N".equals(upIndCd)) {
								vos[i].setSRouteFlg("T");
							} else if ("O".equals(upIndCd)) {
								vos[i].setSRouteFlg("T");
							}
							dbDao.historyOcnAddByLink(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSLane(), vos[i].getSDir1(), vos[i].getSTs1Port(), vos[i].getSTs1Lane(), vos[i].getSDir2(), vos[i].getSTs2Port(), vos[i].getSTs2Lane(), vos[i].getSDir3(), vos[i].getSTs3Port(), vos[i].getSTs3Lane(),
									vos[i].getSDir4());
							dbDao.insertUpdatePs(vos[i]);
						} else {
							throw new DAOException((new ErrorHandler("PRD00010")).getMessage());
						}
					} else {
						dRs = dbDao.getMaxSeqPs(vos[i]);

						int maxSeq = 0;

						if (dRs.next()) {
							maxSeq = dRs.getInt("maxS");
							vos[i].setMaxSeq(maxSeq + "");
						}

						dbDao.insertOceanRoute(vos[i]);
						dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), Integer.toString(maxSeq + 1));
					}

				} else if (vos[i].getIbflag().equals("U")) {
					if (vos[i].getSRoutSeq() != null && !vos[i].getSRoutSeq().equals("")) {
						dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSRoutSeq());
						dbDao.updateOceanRoute(vos[i]);
					}
				} else if (vos[i].getIbflag().equals("D")) {
					dbDao.historyOcnAdd(vos[i].getSPol(), vos[i].getSPod(), vos[i].getSRoutSeq());
					dbDao.deleteOceanRoute(vos[i]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * retrieving - OceanRouteManage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteAutoCreationVO> searchOceanRouteAutoCreationList(SearchOceanRouteAutoCreationVO vo) throws EventException {
		try {
			return dbDao.searchOceanRouteAutoCreationList(vo);
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

	/**
	 * OceanRouteManageBCImpl's searchOceanLane
	 * 
	 * @param vo
	 * @param eventName
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLaneVO> searchOceanLane(SearchOceanLaneVO vo, String eventName) throws EventException {
		try {
			List<SearchOceanLaneVO> list = dbDao.searchOceanLane(vo);
			if (eventName.equalsIgnoreCase("EsdPrd0035Event")) {
				if (list.size() > 1) {
					throw new EventException((new ErrorHandler("PRD00011")).getMessage());
				}
				if (list.size() == 0) {
					throw new EventException((new ErrorHandler("PRD00001")).getMessage());
				}
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving - OceanRouteManage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchOceanRouteManageVO> rowSearchOceanRouteManage(RowSearchOceanRouteManageVO vo) throws EventException {
		try {
			return dbDao.rowSearchOceanRouteManage(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * OceanRouteManageBCImpl's searchOceanRouteMultiCreationList
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteMultiCreationVO> searchOceanRouteMultiCreationList(SearchOceanRouteMultiCreationVO vo) throws EventException {
		try {
			return dbDao.searchOceanRouteMultiCreationList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * retrieving - ESD_PRD_0016
	 * 
	 * @param SaveOceanRouteVO saveOceanRouteVO
	 * @return String
	 * @throws EventException
	 */
	public String searchSameOceanRoute(SaveOceanRouteVO saveOceanRouteVO) throws EventException {
		String findFlg = "N";
		DBRowSet dRs = null;
		String tsIndCd = "D";

		try {
			if ("".equals(saveOceanRouteVO.getSLnkCnt()) || Integer.parseInt(saveOceanRouteVO.getSLnkCnt()) > 1) {
				tsIndCd = "T";
			}
			saveOceanRouteVO.setTsIndCd(tsIndCd);
			dRs = dbDao.delChkPs(saveOceanRouteVO);
			if (dRs.next()) {
				if (!(dRs.getString("UPD_IND_CD").equals("Y") || dRs.getString("UPD_IND_CD").equals("O") || dRs.getString("UPD_IND_CD").equals("N"))) { // "Y" means "D" (deleted one)
					findFlg = "Y";
				}
			}

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return findFlg;

	}

	/**
	 * retrieving - ESD_PRD_0060
	 * 
	 * @param vo SearchOceanRouteSingleCreationVO
	 * @return List<SearchOceanRouteSingleCreationVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteSingleCreationVO> searchOceanRouteSingleCreation(SearchOceanRouteSingleCreationVO vo) throws EventException {
		try {
			return dbDao.searchOceanRouteSingleCreation(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

}
