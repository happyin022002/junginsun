/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanLinkManageBCImpl.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.25
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2006-09-19 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
/*
 * 2010.10.25 진마리아 CHM-201006410-01 HQ Link Management Logic 변경 요청
 */
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration.OceanLinkManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * -PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see OceanLinkManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OceanLinkManageBCImpl extends BasicCommandSupport implements OceanLinkManageBC {

	// Database Access Object
	private transient OceanLinkManageDBDAO dbDao = null;

	/**
	 * OceanLinkManageBCImpl 객체 생성<br>
	 * OceanLinkManageDBDAO를 생성한다.<br>
	 */
	public OceanLinkManageBCImpl() {
		dbDao = new OceanLinkManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanLinkManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-14 kim kiwjin생성
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLinkVO> searchOceanLinkList(SearchOceanLinkVO vo) throws EventException {
		try {
			return dbDao.searchOceanLinkList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_PRD_0012 에 대한 추가 이벤트 처리<br>
	 * ★2009-09-15 kim kwijin생성 CHM-201006410-01 HQ Link Management Logic 변경 요청
	 * 
	 * @param vos
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String modifyOceanLink(SaveOceanLinkVO[] vos, SignOnUserAccount account) throws EventException {
		String backendJobKey = null;
		try {
			if (vos != null) {
				for (int i = 0; i < vos.length; i++) {
					SaveOceanLinkVO vo = vos[i];
					if (vo.getIbflag().equals("I") && "1".equals(vo.getChk())) {
						DBRowSet dRs = dbDao.oceanLinkSChk(vo);

						if (dRs.next()) {
							throw new EventException((new ErrorHandler("PRD00048")).getMessage());
						}
					}
				}
				OceanLinkBackEndJob command = new OceanLinkBackEndJob();
				command.setModifyOceanLink(vos, account.getOfc_cd(), account.getUsr_id());

				BackEndJobManager backEndJobManager = new BackEndJobManager();
				backendJobKey = backEndJobManager.execute(command, account.getUsr_id(), "ESD_PRD_0012 HQ Link Management");
			}
		} catch (EventException e) {
			throw e;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return backendJobKey;

	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESD_PRD_0013 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLinkRHQVO> searchOceanLinkListRHQ(SearchOceanLinkRHQVO vo) throws EventException {
		try {
			return dbDao.searchOceanLinkListRHQ(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_013 화면에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-17 kim kwijin생성
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanLinkRHQ(SaveOceanLinkRHQVO[] vos, SignOnUserAccount account) throws EventException {
		try {
			List<SaveOceanLinkRHQVO> insertVoList = new ArrayList<SaveOceanLinkRHQVO>();
			List<SaveOceanLinkRHQVO> updateVoList = new ArrayList<SaveOceanLinkRHQVO>();

			for (int i = 0; i < vos.length; i++) {
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());

				if (vos[i].getIbflag().equals("I")) {
					insertVoList.add(vos[i]);
				} else if (vos[i].getIbflag().equals("U")) {
					updateVoList.add(vos[i]);

					if (vos[i].getHChkLaneDirTztm().equals("U")) {
						// int iUpdatePs2 = dbDao.oceanLinkRHQUpdate2(vos[i]);
						// int iUpdatePs3 = dbDao.oceanLinkRHQUpdate3(vos[i]);
						// int iUpdatePs4 = dbDao.oceanLinkRHQUpdate4(vos[i]);
						// int iUpdatePs5 = dbDao.oceanLinkRHQUpdate5(vos[i]);
						dbDao.oceanLinkRHQUpdate2(vos[i]);
						dbDao.oceanLinkRHQUpdate3(vos[i]);
						dbDao.oceanLinkRHQUpdate4(vos[i]);
						dbDao.oceanLinkRHQUpdate5(vos[i]);

					}
				} else if (vos[i].getIbflag().equals("D")) {
					// int delResult = dbDao.oceanLinkRHQDelete(vos[i]);
					// int his1 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "1");
					// int delResult2 = dbDao.oceanLinkRHQDelete2(vos[i]);
					// int his2 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "2");
					// int delResult3 = dbDao.oceanLinkRHQDelete3(vos[i]);
					// int his3 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "3");
					// int delResult4 = dbDao.oceanLinkRHQDelete4(vos[i]);
					// int his4 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "4");
					// int delResult5 = dbDao.oceanLinkRHQDelete5(vos[i]);
					dbDao.oceanLinkRHQDelete(vos[i]);
					dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "1");
					dbDao.oceanLinkRHQDelete2(vos[i]);
					dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "2");
					dbDao.oceanLinkRHQDelete3(vos[i]);
					dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "3");
					dbDao.oceanLinkRHQDelete4(vos[i]);
					dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "4");
					dbDao.oceanLinkRHQDelete5(vos[i]);
				}
			}

			if (insertVoList.size() > 0) {
				for (int i = 0; i < insertVoList.size(); i++) {

					int chkCnt = dbDao.checkDupRhqLink(insertVoList.get(i));
					if (chkCnt > 0) {
						throw new EventException(new ErrorHandler("PRD99998", new String[] { "Duplication Data." }).getMessage());
					}

				}
			}

			if (insertVoList.size() > 0) {
				dbDao.oceanLinkRHQInsert(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.oceanLinkRHQUpdate(updateVoList);
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
	 * PRD 업무 시나리오 마감작업<br>
	 * OceanLinkManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
