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
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.integration.InlandRouteManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.EmptySaveInlandRouteMstVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.GetReferenceNoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteSelCreVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchEmptyMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchInlandRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.RowSearchMasterVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchEmptyInlandRouteMasterListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchInlandRouteManageAsiaEuVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;

/**
 * PRD Business Logic Basic Command implementation<br>
 * @author jungsunyong
 * @see ESD_PRD_005EventResponse,InlandRouteManageBC
 * @since J2EE 1.4
 */
public class InlandRouteManageBCImpl extends BasicCommandSupport implements InlandRouteManageBC {
	private transient InlandRouteManageDBDAO dbDao = null;

	/**
	 * creating InlandRouteManageBCImpl Object<br>
	 * creating InlandRouteManageDBDAO<br>
	 */
	public InlandRouteManageBCImpl() {
		dbDao = new InlandRouteManageDBDAO();
	}

	/**
	 * InlandRouteManageBCImpl.java's searchInlandRouteManageList
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandRouteManageAsiaEuVO> searchInlandRouteManageList(SearchConditionVO vo) throws EventException {
		try {
			return dbDao.searchInlandRouteManageList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * retrieving<br>
	 * @param inlandRouteVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteVO> searchInlandRouteManageList01(InlandRouteVO inlandRouteVO) throws EventException {
		try {
			return dbDao.searchInlandRouteManageList01(inlandRouteVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl.java's searchInlandRouteManage
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException {
		try {
			return dbDao.searchInlandRouteManage(inlandRouteDetVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's searchEmptyInlandRouteManage
	 * @param inlandRouteDetVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteDetVO> searchEmptyInlandRouteManage(InlandRouteDetVO inlandRouteDetVO) throws EventException {
		try {
			return dbDao.searchInlandRouteManage(inlandRouteDetVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * retrieving - InlandRouteManage<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchInlandRouteManageVO> rowSearchInlandRouteManage(RowSearchInlandRouteManageVO vo) throws EventException {
		try {
			return dbDao.rowSearchInlandRouteManage(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchMasterVO> rowSearchMaster(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException {
		try {
			return dbDao.rowSearchMaster(inlandRouteMsUSVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param inlandRouteMsUSVO
	 * @return
	 * @throws EventException
	 */
	public String searchPrioSeq(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException {
		try {
			return dbDao.searchPrioSeq(inlandRouteMsUSVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's rowSearchEmptyMaster
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchEmptyMasterVO> rowSearchEmptyMaster(EmptySaveInlandRouteDetVO vo) throws EventException {
		try {
			return dbDao.rowSearchEmptyMaster(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param vos
	 * @param iDelFlg
	 * @param account
	 * @throws EventException
	 */
	public void multiInlandRouteManage(SearchInlandRouteManageAsiaEuVO[] vos, String iDelFlg, SignOnUserAccount account) throws EventException {
		try {
			List<SearchInlandRouteManageAsiaEuVO> updateVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			List<SearchInlandRouteManageAsiaEuVO> unDelUpdateVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			List<SearchInlandRouteManageAsiaEuVO> deleteVoList = new ArrayList<SearchInlandRouteManageAsiaEuVO>();
			for (int i = 0; i < vos.length; i++) {
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("U")) {
					if (!iDelFlg.equals("Y")) {
						updateVoList.add(vos[i]);
					} else {
						unDelUpdateVoList.add(vos[i]);
					}
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateAsiaEuPs(updateVoList);
			}

			if (unDelUpdateVoList.size() > 0) {
				dbDao.updateUndelAsiEu(unDelUpdateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.strDelUpdAsiaEu(deleteVoList);
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
	 * InlandRouteManageBCImpl's multiEmptyInlandRouteManage
	 * @param emptySaveInlandRouteMstVO
	 * @param account
	 * @param iDelFlg
	 * @throws EventException
	 */
	public void multiEmptyInlandRouteManage(EmptySaveInlandRouteMstVO[] emptySaveInlandRouteMstVO, SignOnUserAccount account, String iDelFlg) throws EventException {
		try {
			List<EmptySaveInlandRouteMstVO> updateVoList = new ArrayList<EmptySaveInlandRouteMstVO>();
			for (int i = 0; i < emptySaveInlandRouteMstVO.length; i++) {
				emptySaveInlandRouteMstVO[i].setCreUsrId(account.getUsr_id());
				emptySaveInlandRouteMstVO[i].setUpdUsrId(account.getUsr_id());
				emptySaveInlandRouteMstVO[i].setCreOfcCd(account.getOfc_cd());

				if ("1".equals(emptySaveInlandRouteMstVO[i].getWrsChk())) {
					DBRowSet chkWrs = dbDao.checkEmptyWrs(emptySaveInlandRouteMstVO[i]);
					if (chkWrs.next()) {
						if ("Y".equals(chkWrs.getString("WRS"))) {
							throw new DAOException("WRS Flagged IRG already exists!");
						}
					}
				}
				if (emptySaveInlandRouteMstVO[i].getWrsChk().equals("1")) {
					if (emptySaveInlandRouteMstVO[i].getD2Flg().equals("0") && emptySaveInlandRouteMstVO[i].getD4Flg().equals("0") && emptySaveInlandRouteMstVO[i].getD5Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getD7Flg().equals("0") && emptySaveInlandRouteMstVO[i].getO2Flg().equals("0") && emptySaveInlandRouteMstVO[i].getO4Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getA2Flg().equals("0") && emptySaveInlandRouteMstVO[i].getA4Flg().equals("0") && emptySaveInlandRouteMstVO[i].getR2Flg().equals("0")
							&& emptySaveInlandRouteMstVO[i].getR5Flg().equals("0")) {
						emptySaveInlandRouteMstVO[i].setWrsChk("0");
					}
				}
				updateVoList.add(emptySaveInlandRouteMstVO[i]);
			}

			if (iDelFlg.equals("Y")) {
				dbDao.undelUpdateEmptyPs(updateVoList);
			} else {
				dbDao.updateEmptyPs(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * saving detail - ESD_PRD_005<br>
	 * @param inlandRouteUSDetVOs
	 * @param inlandRouteMsUSVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01InlandRouteManage(InlandRouteUSDetVO[] inlandRouteUSDetVOs, InlandRouteMsUSVO inlandRouteMsUSVO, SignOnUserAccount account) throws EventException {
		String retVal = "";
		try {
			List<InlandRouteUSDetVO> voList = new ArrayList<InlandRouteUSDetVO>();
			String iRoutSeq = inlandRouteMsUSVO.getIRoutSeq();
			if ("FN".equals(inlandRouteMsUSVO.getWrsFChk())) {
				if ("Y".equals(dbDao.checkWrs(inlandRouteMsUSVO))) {
					throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteMsUSVO.getIRoutOrgNodCd() + "-" + inlandRouteMsUSVO.getIRoutDestNodCd() + "]").getMessage());
				}
				if ("Y".equals(dbDao.checkWrs2(inlandRouteMsUSVO))) {
					throw new DAOException(new ErrorHandler("PRD00049", " [" + inlandRouteMsUSVO.getIRoutOrgNodCd() + "-" + inlandRouteMsUSVO.getIRoutDestNodCd() + "]").getMessage());
				}
			}
			if (dbDao.isPseudoYard(inlandRouteMsUSVO)) {
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}
			Map<String, String> selPs = dbDao.selectPs(inlandRouteMsUSVO);
			inlandRouteMsUSVO.setNextRoutSeq(selPs.get("next_rout_seq"));
			inlandRouteMsUSVO.setNextPrioSeq(selPs.get("next_prio_seq"));

			inlandRouteMsUSVO.setCreOfcCd(account.getOfc_cd());
			inlandRouteMsUSVO.setCreUsrId(account.getUsr_id());
			inlandRouteMsUSVO.setUpdUsrId(account.getUsr_id());

			if ("Y".equals(inlandRouteMsUSVO.getINewRouteCd())) {
				iRoutSeq = selPs.get("next_rout_seq");
				inlandRouteMsUSVO.setIRoutSeq(iRoutSeq);
				dbDao.insertPs1(inlandRouteMsUSVO);
			}

			if ("N".equals(inlandRouteMsUSVO.getINewRouteCd()) || "M".equals(inlandRouteMsUSVO.getINewRouteCd())) {
				dbDao.deletePs(inlandRouteMsUSVO);
				dbDao.updatePs(inlandRouteMsUSVO);
			}
			String chkPs = dbDao.checkPs(inlandRouteMsUSVO);

			if (CheckUtilities.isInBlank(chkPs) || !"X".equals(chkPs)) {
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}
			int routDtlSeq = 1;
			String rInbound = inlandRouteMsUSVO.getRInbound();
			String nod_tp_cd1 = inlandRouteMsUSVO.getNodTpCd1();
			String nod_tp_cd2 = nod_tp_cd1;
			int rowCount = inlandRouteUSDetVOs.length;
			for (int j = 0; j < inlandRouteUSDetVOs.length; j++) {
				if (rInbound.equals("I") && nod_tp_cd1.equals("Z")) {
					if (j < (rowCount - 1)) {
						if (dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
								|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					} else if (routDtlSeq == rowCount) {
						if (dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				} else if (rInbound.equals("O") && nod_tp_cd2.equals("Z")) {
					if (j == 0) {
						if (dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					} else {
						if (dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
								|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				} else {
					if (dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType())
							|| dbDao.isDoorTml(inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType())) {
						throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
					}
				}
				if (!dbDao.validCheckPrdInlndEachLink(inlandRouteUSDetVOs[j].getLnkOrgLoc() + inlandRouteUSDetVOs[j].getLnkOrgType(),
						inlandRouteUSDetVOs[j].getLnkDestLoc() + inlandRouteUSDetVOs[j].getLnkDestType(), inlandRouteUSDetVOs[j].getTrspModCd())) {
					throw new DAOException((new ErrorHandler("COM12199", new String[] { "Each Link " })).getUserMessage());
				}
				if (inlandRouteUSDetVOs[j].getIbflag().equals("I") || inlandRouteUSDetVOs[j].getIbflag().equals("U") || inlandRouteUSDetVOs[j].getIbflag().equals("R")
						|| inlandRouteUSDetVOs[j].getIbflag().equals("")) {
					inlandRouteUSDetVOs[j].setRoutOrgNodCd(inlandRouteMsUSVO.getIRoutOrgNodCd());
					inlandRouteUSDetVOs[j].setRoutDestNodCd(inlandRouteMsUSVO.getIRoutDestNodCd());
					inlandRouteUSDetVOs[j].setRoutSeq(iRoutSeq);
					inlandRouteUSDetVOs[j].setRoutDtlSeq(routDtlSeq + "");
					inlandRouteUSDetVOs[j].setCreOfcCd(account.getOfc_cd());
					inlandRouteUSDetVOs[j].setCreUsrId(account.getUsr_id());
					inlandRouteUSDetVOs[j].setUpdUsrId(account.getUsr_id());
					String ctyCd = "";
					String agmtSeq = "";
					if (inlandRouteUSDetVOs[j].getAgmtNo() != null && inlandRouteUSDetVOs[j].getAgmtNo().length() > 4) {
						ctyCd = inlandRouteUSDetVOs[j].getAgmtNo().substring(0, 3);
						agmtSeq = inlandRouteUSDetVOs[j].getAgmtNo().substring(3);
						Integer.parseInt(agmtSeq);
					}

					inlandRouteUSDetVOs[j].setTrspAgmtOfcCtyCd(ctyCd);
					inlandRouteUSDetVOs[j].setTrspAgmtSeq(agmtSeq);
					voList.add(inlandRouteUSDetVOs[j]);
					routDtlSeq++;
				}
			}

			if (voList.size() > 0) {
				dbDao.insert2Ps(voList);
			}

			// String i_rout_org_nod_cd = inlandRouteMsUSVO.getIRoutOrgNodCd();
			// String i_rout_dest_nod_cd = inlandRouteMsUSVO.getIRoutDestNodCd();
			// String i_rout_seq = inlandRouteMsUSVO.getIRoutSeq();
			//
			// Map<String, String> addItems = dbDao.getInlandRoutAddItems(i_rout_org_nod_cd, i_rout_dest_nod_cd, i_rout_seq);
			// inlandRouteMsUSVO.setFullRtnYdCd((String) addItems.get("fullRtnYdCd"));
			// inlandRouteMsUSVO.setFullPkupYdCd((String) addItems.get("fullPkupYdCd"));
			// inlandRouteMsUSVO.setTrspModCd((String) addItems.get("trspModCd"));
			dbDao.updateInlandRoutAddItems(inlandRouteMsUSVO);
			dbDao.upDateHubLoc(inlandRouteMsUSVO);
			return retVal;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's multi01EmptyInlandRouteManage saving empty inland route detail
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String multi01EmptyInlandRouteManage(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo, SignOnUserAccount account) throws EventException {
		String i_rout_seq = "";
		String prioSeq = "";
		try {
			List<EmptySaveInlandRouteDetVO> insertVoList = new ArrayList<EmptySaveInlandRouteDetVO>();
			DBRowSet dRs = null;

			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreOfcCd(account.getOfc_cd());
			if (!CheckUtilities.isInBlank(vo.getWrsChk())) {
				DBRowSet wrsDrs = dbDao.checkEmptyWrs(vo);
				if (wrsDrs.next()) {
					if ("Y".equals(wrsDrs.getString("WRS"))) {
						throw new DAOException(new ErrorHandler("PRD00049", " [" + vo.getIRoutOrgNodCd() + "-" + vo.getIRoutDestNodCd() + "]").getMessage());
					}
				}
			}

			if (dbDao.isPseudoYard(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd())) {
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}
			if (vo.getINewRouteCd().equals("Y")) {
				dRs = dbDao.searchEmptyRoutSeq(vo);
				if (dRs.next()) {
					i_rout_seq = dRs.getString("next_rout_seq");
					prioSeq = dRs.getString("next_prio_seq");
				}
				vo.setIRoutSeq(i_rout_seq);
				vo.setPrioSeq(prioSeq);
				dbDao.insert1Empty1Ps(vo);
			}
			if ("N".equals(vo.getINewRouteCd()) || "M".equals(vo.getINewRouteCd())) {
				dbDao.deleteEmptyDetPs(vo);
				dbDao.updateEmptyDetPs(vo);
			}
			dRs = dbDao.checkEmptyDetPs(vo);
			if (!dRs.next()) {
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}
			int routDtlSeq = 1;
			if (vos != null) {
				for (int i = 0; i < vos.length; i++) {
					String ibflag = vos[i].getIbflag();
					if ("I".equals(ibflag) || "U".equals(ibflag) || "R".equals(ibflag)) {
						String ctyCd = "";
						String agmtSeq = "";
						int iAgmtSeq = 0;
						if (CheckUtilities.isNullOrNullStringReplacement(vos[i].getAgmtNo(), "").length() > 4) {
							ctyCd = vos[i].getAgmtNo().substring(0, 3);
							agmtSeq = vos[i].getAgmtNo().substring(3);
							iAgmtSeq = Integer.parseInt(agmtSeq);
						}
						vos[i].setCreUsrId(account.getUsr_id());
						vos[i].setUpdUsrId(account.getUsr_id());
						vos[i].setCreOfcCd(account.getOfc_cd());
						vos[i].setRoutDtlSeq(routDtlSeq + "");
						vos[i].setIAgmtSeq(iAgmtSeq + "");
						vos[i].setCtyCd(ctyCd);

						vos[i].setIRoutOrgNodCd(vo.getIRoutOrgNodCd());
						vos[i].setIRoutDestNodCd(vo.getIRoutDestNodCd());
						vos[i].setIRoutSeq(vo.getIRoutSeq());

						routDtlSeq++;
						insertVoList.add(vos[i]);
					}
				}
				if (insertVoList.size() > 0) {
					int[] retDtl = dbDao.insertEmpty2Ps(insertVoList);
					if (vos.length != retDtl.length) {
						throw new DAOException((new ErrorHandler("PRD00047")).getMessage());
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		vo.setIRoutSeq(i_rout_seq);

		return i_rout_seq;

	}

	/**
	 * INLAND ROUTE DETAIL SAVE AS
	 * @param vos
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String saveAsInlandRouteManage(InlandRouteUSDetVO[] vos, InlandRouteMsUSVO vo, SignOnUserAccount account) throws EventException {
		try {
			List<InlandRouteUSDetVO> insertVoList = new ArrayList<InlandRouteUSDetVO>();

			DBRowSet wrsDrs = null;
			String i_rout_seq = vo.getIRoutSeq();
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setCreOfcCd(account.getOfc_cd());

			if (dbDao.isPseudoYard(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd())) {
				throw new DAOException(new ErrorHandler("PRD00050").getMessage());
			}

			wrsDrs = dbDao.inlandRouteSaveAsSelectPs(vo);
			String prioSeq = "";
			if (wrsDrs.next()) {
				i_rout_seq = wrsDrs.getString("next_rout_seq");
				prioSeq = wrsDrs.getString("next_prio_seq");
				vo.setIRoutSeq(i_rout_seq);
				vo.setNextPrioSeq(prioSeq);
			}
			dbDao.inlandRouteSaveAsInsert1(vo);
			wrsDrs = dbDao.inlandRouteSaveAsCheckLastPs(vo);
			if (wrsDrs.next()) {
				if (CheckUtilities.isInBlank(wrsDrs.getString(1)) || !"X".equals(wrsDrs.getString(1))) {
					throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
				}
			} else {
				throw new DAOException((new ErrorHandler("PRD00046")).getMessage());
			}

			int routDtlSeq = 1;
			int rowCount = (vos == null) ? 0 : vos.length;
			for (int j = 0; j < rowCount; j++) {
				vos[j].setCreUsrId(account.getUsr_id());
				vos[j].setUpdUsrId(account.getUsr_id());
				vos[j].setCreOfcCd(account.getOfc_cd());
				if ("I".equals(vo.getRInbound()) && "Z".equals(vo.getNodTpCd1())) {
					if (j < (rowCount - 1)) {
						if (dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					} else if (routDtlSeq == rowCount) {
						if (dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				} else if ("O".equals(vo.getRInbound()) && "Z".equals(vo.getNodTpCd2())) {
					if (j == 0) {
						if (dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					} else {
						if (dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())) {
							throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
						}
					}
				} else {
					if (dbDao.isDoorTml(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType()) || dbDao.isDoorTml(vos[j].getLnkDestLoc() + vos[j].getLnkDestType())) {
						throw new DAOException((new ErrorHandler("PRD00069")).getMessage());
					}
				}

				if (!dbDao.validCheckPrdInlndEachLink(vos[j].getLnkOrgLoc() + vos[j].getLnkOrgType(), vos[j].getLnkDestLoc() + vos[j].getLnkDestType(), vos[j].getTrspModCd())) {
					throw new DAOException((new ErrorHandler("COM12199", new String[] { "Each Link " })).getUserMessage());
				}

				String ctyCd = "";
				String agmtSeq = "";
				int iAgmtSeq = 0;

				if (CheckUtilities.isNullOrNullStringReplacement(vos[j].getAgmtNo(), "").length() > 4) {
					ctyCd = vos[j].getAgmtNo().substring(0, 3);
					agmtSeq = vos[j].getAgmtNo().substring(3);
					iAgmtSeq = Integer.parseInt(agmtSeq);
				}
				vos[j].setCtyCd(ctyCd);
				vos[j].setIAgmtSeq(iAgmtSeq + "");
				vos[j].setRoutDtlSeq(routDtlSeq + "");
				vos[j].setRoutSeq(i_rout_seq);
				vos[j].setRoutOrgNodCd(vo.getIRoutOrgNodCd());
				vos[j].setRoutDestNodCd(vo.getIRoutDestNodCd());

				routDtlSeq++;
				insertVoList.add(vos[j]);
			}

			if (insertVoList == null || insertVoList.size() == 0) {
				throw new DAOException((new ErrorHandler("PRD00010")).getUserMessage());
			}
			int retDtl[] = dbDao.inlandRouteSaveAsInsert2(insertVoList);
			if (rowCount != retDtl.length) {
				log.debug("\n\n rowCount(ibflag): " + rowCount + "  !=  retDtl.length:" + retDtl.length);
				throw new DAOException((new ErrorHandler("PRD00070")).getMessage());
			}
			// Map<String, String> addItems = dbDao.getInlandRoutAddItems(vo.getIRoutOrgNodCd(), vo.getIRoutDestNodCd(), vo.getIRoutSeq());
			// vo.setFullRtnYdCd((String) addItems.get("fullRtnYdCd"));
			// vo.setFullPkupYdCd((String) addItems.get("fullPkupYdCd"));
			// vo.setTrspModCd((String) addItems.get("trspModCd"));
			dbDao.updateInlandRoutAddItems(vo);
			dbDao.upDateHubLoc(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return vo.getIRoutSeq();
	}

	/**
	 * retrieving - InlandRouteManage
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<InlandRouteSelCreVO> searchInlandRouteManageCreateList(InlandRouteSelCreVO vo) throws EventException {
		try {
			DBRowSet chkPort = dbDao.portChk(vo.getIOrgCd(), vo.getIDestCd());
			String fromChk = "";
			String toChk = "";

			String hubLocCd = "";
			String trspModCd = "";
			List<InlandRouteSelCreVO> list = new ArrayList<InlandRouteSelCreVO>();
			if (chkPort.next()) {
				fromChk = chkPort.getString("from_port_chk");
				toChk = chkPort.getString("to_port_chk");

			}
			vo.setFromChk(fromChk);
			vo.setToChk(toChk);

			if ((fromChk.equals("Y") && toChk.equals("N")) || (fromChk.equals("N") && toChk.equals("Y"))) {
				DBRowSet chkHub = dbDao.hubChk(fromChk, vo.getIOrgCd(), toChk, vo.getIDestCd());
				if (chkHub.next()) {
					hubLocCd = chkHub.getString("hub_loc_cd");
					trspModCd = chkHub.getString("trsp_mod_cd");
				}
				vo.setHubLocCd(hubLocCd);
				vo.setTrspModCd(trspModCd);

				list = dbDao.searchInlandRouteManageCreateList(vo);
			}

			return list;

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
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<GetReferenceNoVO> getReferenceNo(GetReferenceNoVO vo) throws EventException {
		try {
			List<GetReferenceNoVO> list = dbDao.getReferenceNo(vo);
			if (list.size() == 0) {
				throw new EventException((new ErrorHandler("PRD00001")).getMessage());
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's getInLandRouteExistCount
	 * @param inlandRouteMsUSVO
	 * @param InlandRouteUSDetVOs
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getInLandRouteExistCount(InlandRouteMsUSVO inlandRouteMsUSVO, InlandRouteUSDetVO[] InlandRouteUSDetVOs) throws EventException {
		try {
			return dbDao.getInLandRouteExistCount(inlandRouteMsUSVO, InlandRouteUSDetVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's getEmptyInLandRouteExistCount
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getEmptyInLandRouteExistCount(EmptySaveInlandRouteDetVO[] vos, EmptySaveInlandRouteDetVO vo) throws EventException {
		try {
			return dbDao.getEmptyInLandRouteExistCount(vos, vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * InlandRouteManageBCImpl's getInLandRouteRemarkCompare
	 * @param vos
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int getInLandRouteRemarkCompare(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException {
		try {
			return dbDao.getInLandRouteRemarkCompare(inlandRouteMsUSVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param inlandRouteMsUSVO
	 * @throws EventException
	 */
	public void updateRemark(InlandRouteMsUSVO inlandRouteMsUSVO) throws EventException {
		try {
			dbDao.updateRemark(inlandRouteMsUSVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * InlandRouteManageBCImpl's updateEmptyRemark
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updateEmptyRemark(EmptySaveInlandRouteDetVO vo) throws EventException {
		try {
			return dbDao.updateEmptyRemark(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * (non-Javadoc) InlandRouteManageBCImpl's searchEmptyInlandRouteManageList
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchEmptyInlandRouteMasterListVO> searchEmptyInlandRouteManageList(SearchConditionVO vo) throws EventException {
		try {
			return dbDao.searchEmptyInlandRouteManageList(vo.getFromCd(), vo.getToCd(), vo.getWrsFlg(), vo.getIDelFlg());
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * updatePrdInlndRoutMst
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public int updatePrdInlndRoutMst(InlandRouteMsUSVO vo) throws EventException {
		try {
			return dbDao.updatePrdInlndRoutMst(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
