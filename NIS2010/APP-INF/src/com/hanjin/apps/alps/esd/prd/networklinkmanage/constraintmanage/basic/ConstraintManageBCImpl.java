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
 * 2011.11.22 이수진 [CHM-201113877-01] [PRD] Constraint 기능상에 Update 이력 관리 기능 추가 및 관련 Alert Message 기능 추가
 * 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.integration.ConstraintManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
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
	 * @throws com.hanjin.framework.core.layer.event.EventException
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

//			String effFmDate = null;
//			String effToDate = null;
			int insSeq = 0;

			DBRowSet dRs = null;

			List<SearchNodeConstraintVO> insertVoList = new ArrayList<SearchNodeConstraintVO>();
			List<SearchNodeConstraintVO> updateVoList = new ArrayList<SearchNodeConstraintVO>();
			List<SearchNodeConstraintVO> deleteVoList = new ArrayList<SearchNodeConstraintVO>();
			for (int i = 0; i < vos.length; i++) {

//				effFmDate = (vos[i].getEffFmDt() == null) ? "" : vos[i].getEffFmDt().replaceAll("-", "");
//				effToDate = (vos[i].getEffToDt() == null) ? "" : vos[i].getEffToDt().replaceAll("-", "");
//
//				vos[i].setEffFmDt(effFmDate);
//				vos[i].setEffToDt(effToDate);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setUpdOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("I")) {
					insSeq = insSeq + 1;
					vos[i].setNodCnstSeq(new Integer(insSeq).toString());
					dRs = dbDao.chkPsNode(vos[i]);
					if (!dRs.next()) {
						insertVoList.add(vos[i]);
					} else {
						throw new EventException((new ErrorHandler("PRD00036")).getMessage());
					}
				} else if (vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.insertNode(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.addNodeConstraintHistory(updateVoList);
				dbDao.updateNode(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.addNodeConstraintHistory(deleteVoList);
				dbDao.deleteNode(deleteVoList);
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
//			String effFmDate = null;
//			String effToDate = null;

			DBRowSet dRs = null;

			List<SearchLinkConstraintVO> insertVoList = new ArrayList<SearchLinkConstraintVO>();
			List<SearchLinkConstraintVO> updateVoList = new ArrayList<SearchLinkConstraintVO>();
			List<SearchLinkConstraintVO> deleteVoList = new ArrayList<SearchLinkConstraintVO>();

			for (int i = 0; i < vos.length; i++) {
//				effFmDate = (vos[i].getEffFmDt() == null) ? "" : vos[i].getEffFmDt().replaceAll("-", "");
//				effToDate = (vos[i].getEffToDt() == null) ? "" : vos[i].getEffToDt().replaceAll("-", "");
//
//				vos[i].setEffFmDt(effFmDate);
//				vos[i].setEffToDt(effToDate);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setUpdOfcCd(account.getOfc_cd());

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
				dbDao.insertLink(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.addLinkConstraintHistory(updateVoList);
				dbDao.updateLink(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.addLinkConstraintHistory(deleteVoList);
				dbDao.deleteLink(deleteVoList);
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
	@Override
	public void multiRouteConstraint(SearchRouteConstraintVO[] vos,	SignOnUserAccount account) throws EventException {
		try {

			boolean isInsertUpdate = false;

			DBRowSet dRs = null;
			List<SearchRouteConstraintVO> insertVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> updateVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> deleteVoList = new ArrayList<SearchRouteConstraintVO>();
			List<SearchRouteConstraintVO> insertUpdateVoList = new ArrayList<SearchRouteConstraintVO>();
//			int psIdx = 1;
			String delChk = "";
			for (int i = 0; i < vos.length; i++) {				
//				psIdx = 1;
//				String sPolNode = vos[i].getPolCd() + vos[i].getPolNodCd();
//				vos[i].setPolNodCd(sPolNode);
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setUpdOfcCd(account.getOfc_cd());

				if (vos[i].getIbflag().equals("I")) {
//					psIdx = 1;
					dRs = dbDao.chkPs(vos[i]);
					if (dRs.next()) {
						isInsertUpdate = false;
						delChk = dRs.getString("DUP");
						if (!delChk.equals("Y")) { // 같은데이터가 살아 있으면
							throw new DAOException((new ErrorHandler("PRD00051")).getMessage());
						} 
//						else {
//							isInsertUpdate = true;
//							vos[i].setRoutCnstSeq( dRs.getString("ROUT_CNST_SEQ") );
//						}
					}

					if (isInsertUpdate) {
						insertUpdateVoList.add(vos[i]);
					} else {
						// dRs = dbDao.getMaxSeq(vos[i]);
						// int maxSeq = 0;
						// if(dRs.next()){
						// maxSeq = dRs.getInt("maxS");
						// vos[i].setMaxSeq(maxSeq + "");
						insertVoList.add(vos[i]);
						// }
					}

				} else if (vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.insertRoute(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.addRouteConstraintHistory(updateVoList);
				dbDao.updateRoute(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.addRouteConstraintHistory(deleteVoList);
				dbDao.deleteRoute(deleteVoList);
			}
			if (insertUpdateVoList.size() > 0) {
				dbDao.addRouteConstraintHistory(insertUpdateVoList);
				dbDao.insertUpdateRoute(insertUpdateVoList);
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
	 * 저장 할 대상의 validation를 체크 합니다. <br>
	 * @param vos
	 * @return List<SearchRouteConstraintVO>
	 * @throws EventException
	 */
	@Override
	public List<SearchRouteConstraintVO> checkRouteConstraint(SearchRouteConstraintVO[] vos) throws EventException {
		if(vos == null) return null;
		
		List<SearchRouteConstraintVO> rstVos = new ArrayList<SearchRouteConstraintVO>();
		try {
			for (int i = 0; i < vos.length; i++) {
				SearchRouteConstraintVO chkVo = vos[i];
				if (chkVo.getIbflag().equals("I") || chkVo.getIbflag().equals("U")) {
					List<SearchRouteConstraintVO> rst = dbDao.checkRouteConstraint(chkVo);
					if(rst != null && rst.size() > 0) {
						String chkFieldStr = "";
						StringBuffer sbChkFieldStr = new StringBuffer();
						
						for(int j = 0; j < rst.size(); j++) {
//							chkFieldStr = chkFieldStr + rst.get(j).getChkField() + "|";
							sbChkFieldStr.append(rst.get(j).getChkField()).append("|");
						}
						chkFieldStr = sbChkFieldStr.toString();
						chkVo.setChkField(chkFieldStr);
						rstVos.add(chkVo);
						return rstVos;
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return rstVos;
	}
	
	
	/**
	 * ConstraintManageBCImpl's checkCommodity 
	 * ★ 2009-08-20 kim kwijin 생성 
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
	
	public List<SearchListCnstExptVO> searchListExptCust(SearchListCnstExptVO searchListCnstExptVO) throws EventException {
		try {
			return dbDao.searchListExptCust(searchListCnstExptVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	public void multiExptCust(SearchListCnstExptVO[] vos, String nod_cd, String nod_cnst_itm_cd, String nod_cnst_seq, SignOnUserAccount account) throws EventException {
		List<SearchListCnstExptVO> insertVoList = new ArrayList<SearchListCnstExptVO>();
		List<SearchListCnstExptVO> updateVoList = new ArrayList<SearchListCnstExptVO>();
		List<SearchListCnstExptVO> deleteVoList = new ArrayList<SearchListCnstExptVO>();
		
		try {
			
			for (int i = 0; i < vos.length; i++) {
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setUpdUsrId(account.getUsr_id());
				
				if (vos[i].getIbflag().equals("I")) {
					insertVoList.add(vos[i]);
				} else if(vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("D")) {
					deleteVoList.add(vos[i]);
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.insertExptCust(insertVoList, nod_cd, nod_cnst_itm_cd, nod_cnst_seq);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.updateExptCust(updateVoList, nod_cd, nod_cnst_itm_cd, nod_cnst_seq);
			}
			
			if (deleteVoList.size() > 0) {
				dbDao.updateExptCust(deleteVoList, nod_cd, nod_cnst_itm_cd, nod_cnst_seq);
			}
			
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
