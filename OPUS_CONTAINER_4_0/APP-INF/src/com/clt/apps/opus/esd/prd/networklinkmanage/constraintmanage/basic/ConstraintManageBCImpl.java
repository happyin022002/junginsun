/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ConstraintManageBCImpl.java
 *@FileTitle : Node Constraint Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-16 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration.ConstraintManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchHubConstraintListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_022EventResponse,ConstraintManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ConstraintManageBCImpl extends BasicCommandSupport implements ConstraintManageBC {

	// Database Access Object
	private transient ConstraintManageDBDAO dbDao = null;

	/**
	 * ConstraintManageBCImpl 객체 생성<br>
	 * ConstraintManageDBDAO를 생성한다.<br>
	 */
	public ConstraintManageBCImpl() {
		dbDao = new ConstraintManageDBDAO();
	}

	/**
	 * 
	 * @param constraintVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchNodeConstraintVO> searchNodeConstraintList(ConstraintVO constraintVO) throws EventException {
		try {
			return dbDao.searchNodeConstraintList(constraintVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl.java's multiNodeConstraint
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void multiNodeConstraint(SearchNodeConstraintVO[] vos, SignOnUserAccount account) throws EventException {
		try {

			String effFmDate = null;
			String effToDate = null;
			int insSeq = 0;

			DBRowSet dRs = null;

			List<SearchNodeConstraintVO> insertVoList = new ArrayList<SearchNodeConstraintVO>();
			List<SearchNodeConstraintVO> updateVoList = new ArrayList<SearchNodeConstraintVO>();
			List<SearchNodeConstraintVO> deleteVoList = new ArrayList<SearchNodeConstraintVO>();
			for (int i = 0; i < vos.length; i++) {

				effFmDate = (vos[i].getSEffFm() == null) ? "" : vos[i].getSEffFm().replaceAll("-", "");
				effToDate = (vos[i].getSEffTo() == null) ? "" : vos[i].getSEffTo().replaceAll("-", "");

				vos[i].setEffFmDate(effFmDate);
				vos[i].setEffToDate(effToDate);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("I")) {
					vos[i].setSNodCnstSeq(null);
					dRs = dbDao.chkPsNode(vos[i]);
					if (!dRs.next()) {
						insSeq++;
						vos[i].setSNodCnstSeq(new Integer(insSeq).toString());
						insertVoList.add(vos[i]);
					} else {
						throw new EventException((new ErrorHandler("PRD00036")).getMessage());
					}
				} else if (vos[i].getIbflag().equals("U")) {
					dRs = dbDao.chkPsNode(vos[i]);
					if (dRs.next()) {
						throw new EventException((new ErrorHandler("PRD00036")).getMessage());
					}
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				for (int i = 0; i < insertVoList.size(); i++) {
					dbDao.insertNode(insertVoList.get(i));
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.updateNode(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.deleteNode(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl.java's searchLinkConstraintList
	 * 
	 * @param constraintVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchLinkConstraintVO> searchLinkConstraintList(ConstraintVO constraintVO) throws EventException {
		try {
			return dbDao.searchLinkConstraintList(constraintVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl.java's multiLinkConstraint
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void multiLinkConstraint(SearchLinkConstraintVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			String effFmDate = null;
			String effToDate = null;

			DBRowSet dRs = null;

			List<SearchLinkConstraintVO> insertVoList = new ArrayList<SearchLinkConstraintVO>();
			List<SearchLinkConstraintVO> updateVoList = new ArrayList<SearchLinkConstraintVO>();
			List<SearchLinkConstraintVO> deleteVoList = new ArrayList<SearchLinkConstraintVO>();

			for (int i = 0; i < vos.length; i++) {
				effFmDate = (vos[i].getSEffFm() == null) ? "" : vos[i].getSEffFm().replaceAll("-", "");
				effToDate = (vos[i].getSEffTo() == null) ? "" : vos[i].getSEffTo().replaceAll("-", "");

				vos[i].setEffFmDate(effFmDate);
				vos[i].setEffToDate(effToDate);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("I")) {
					dRs = dbDao.chkPsLink(vos[i]);
					if (!dRs.next()) {
						insertVoList.add(vos[i]);
					} else {
						throw new EventException((new ErrorHandler("PRD00037")).getMessage());
					}

				} else if (vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				for (int i = 0; i < insertVoList.size(); i++) {
					dbDao.insertLink(insertVoList.get(i));
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateLink(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.deleteLink(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl.java's searchRouteConstraintList
	 * 
	 * @param constraintVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<SearchRouteConstraintVO> searchRouteConstraintList(ConstraintVO constraintVO) throws EventException {
		try {
			return dbDao.searchRouteConstraintList(constraintVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl.java's multiRouteConstraint
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiRouteConstraint(SearchRouteConstraintVO[] vos, SignOnUserAccount account) throws EventException {
		try {

			boolean isInsertUpdate = false;

			DBRowSet dRs = null;
			List<SearchRouteConstraintVO> insertVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> updateVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> deleteVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> insertUpdateVoList = new ArrayList<SearchRouteConstraintVO>();
			String delChk = "";
			for (int i = 0; i < vos.length; i++) {
				String sPolNode = vos[i].getSPol() + vos[i].getSPolNode();
				vos[i].setSPolNode(sPolNode);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("I")) {
					dRs = dbDao.chkPs(vos[i]);
					if (dRs.next()) {
						delChk = dRs.getString("DUP");
						if (!delChk.equals("Y")) {
							throw new DAOException((new ErrorHandler("PRD00051")).getMessage());
						} else {
							isInsertUpdate = true;
						}
					}

					if (isInsertUpdate) {
						insertUpdateVoList.add(vos[i]);
					} else {
						dRs = dbDao.getMaxSeq(vos[i]);
						int maxSeq = 0;
						if (dRs.next()) {
							maxSeq = dRs.getInt("maxS");
							vos[i].setMaxSeq(maxSeq + "");
							insertVoList.add(vos[i]);
						}

					}

				} else if (vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					if (vos[i].getSDelChk().equals("1")) {
						deleteVoList.add(vos[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				for (int i = 0; i < insertVoList.size(); i++) {
					dbDao.insertRoute(insertVoList.get(i));
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateRoute(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.deleteRoute(deleteVoList);
			}
			if (insertUpdateVoList.size() > 0) {
				dbDao.insertUpdateRoute(insertUpdateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ConstraintManageBCImpl's checkCommodity ★ 2009-08-20 kim kwijin 생성
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<CheckCommodityVO> checkCommodity(CheckCommodityVO vo) throws EventException {
		try {
			return dbDao.checkCommodity(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 
	 * @param constraintVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<AbstractValueObject> searchHubConstraintList(ConstraintVO constraintVO) throws EventException {
		try {
			return dbDao.searchHubConstraintList(constraintVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * multiHubConstraint
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiHubConstraint(SearchHubConstraintListVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			List<SearchHubConstraintListVO> insertVoList = new ArrayList<SearchHubConstraintListVO>();
			List<SearchHubConstraintListVO> updateVoList = new ArrayList<SearchHubConstraintListVO>();
			List<SearchHubConstraintListVO> deleteVoList = new ArrayList<SearchHubConstraintListVO>();
			for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("I")) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("U")) {
					vos[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeHubConstraint(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyHubConstraint(updateVoList);
			}
			if (insertVoList.size() > 0) {
				for (SearchHubConstraintListVO vo : insertVoList) {
					if (dbDao.searchHubConstraintDupCheck(vo)) {
						throw new EventException("There is a duplicated data, please check it!");
					}
				}
				dbDao.addHubConstraint(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param constraintVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchContainerTypeSize(ConstraintVO constraintVO) throws EventException {
		try {
			return dbDao.searchContainerTypeSize(constraintVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * ConstraintManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
