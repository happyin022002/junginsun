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
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.integration.OceanLinkManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS-PRD Business Logic Basic Command implementation<br>
 * - NIS-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see OceanLinkManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OceanLinkManageBCImpl extends BasicCommandSupport implements OceanLinkManageBC{

	// Database Access Object
	private transient OceanLinkManageDBDAO dbDao = null;

	/**
	 * OceanLinkManageBCImpl 객체 생성<br>
	 * OceanLinkManageDBDAO를 생성한다.<br>
	 */
	public OceanLinkManageBCImpl(){
		dbDao = new OceanLinkManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanLinkManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-14 kim kiwjin생성 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLinkVO> searchOceanLinkList(SearchOceanLinkVO vo) throws EventException{
		try{
			return dbDao.searchOceanLinkList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_PRD_0012 에 대한 추가 이벤트 처리<br>
	 * ★2009-09-15 kim kwijin생성
	 * CHM-201006410-01 HQ Link Management Logic 변경 요청
	 * @param vos
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String modifyOceanLink(SaveOceanLinkVO[] vos, SignOnUserAccount account) throws EventException{
		String backendJobKey = null;
		try {
			if(vos != null){
				// 기 등록된 Route와 동일한 Route가 있는지 확인한다. (Delete는 확인할 필요 없음)
				for(int i = 0; i < vos.length; i++){
					SaveOceanLinkVO vo = vos[i];
					if(vo.getIbflag().equals("I") && "1".equals(vo.getChk())){
						DBRowSet dRs = dbDao.oceanLinkSChk(vo);
						
						if(dRs.next()){
							throw new EventException((new ErrorHandler("PRD00048")).getMessage());
						}
					}
				}
			}

			// Back-end job을 실행한다.
			OceanLinkBackEndJob command = new OceanLinkBackEndJob();
	        command.setModifyOceanLink(vos,account.getOfc_cd(),account.getUsr_id());
	
	        BackEndJobManager backEndJobManager = new BackEndJobManager();
	        backendJobKey = backEndJobManager.execute(command, account.getUsr_id(), "ESD_PRD_0012 HQ Link Management");
		} catch(EventException e) {
			throw e;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

        return backendJobKey;

	}
	
//	/**
//	 * 수정 이벤트 처리<br>
//	 * ESD_PRD_0012 에 대한 추가 이벤트 처리<br>
//	 * ★2009-09-15 kim kwijin생성
//	 * CHM-201006410-01 HQ Link Management Logic 변경 요청
//	 * @param vos
//	 * @param account
//	 * @throws EventException
//	 */
//	public void modifyOceanLink(SaveOceanLinkVO[] vos, SignOnUserAccount account) throws EventException{
//		double tztmHrs = 0;
//		int retVal = 0;
//
//		try{
//			if(vos != null){
//				for(int i = 0; i < vos.length; i++){
//					SaveOceanLinkVO vo = vos[i];
//					vo.setCreOfcCd(account.getOfc_cd());
//					vo.setCreUsrId(account.getUsr_id());
//					vo.setUpdUsrId(account.getUsr_id());
//
//					String delOption = vo.getDelcombo().equals("D") ? "Direct Calling. " : "Transshipment.  ";
//					String remarks = delOption + vo.getRemark().replace("Direct Calling. ", "").replace("Transshipment.  ", "");
//					vo.setRemark(remarks);
//					
//					tztmHrs = Double.parseDouble(vo.getFmtTztmHrs().substring(0, 2)) * 24 + Double.parseDouble(vo.getFmtTztmHrs().substring(2));
//					log.debug("\n ★ fmt_tztm_hrs[i] :" + vo.getFmtTztmHrs() + ", tztmHrs:" + tztmHrs + "=  " + Double.parseDouble(vo.getFmtTztmHrs().substring(0, 2)) * 24 + "+" + Double.parseDouble(vo.getFmtTztmHrs().substring(2)));
//					vo.setFmtTztmHrs(tztmHrs + "");
//
//					if(vo.getIbflag().equals("I")){ //sStatus
//						DBRowSet dRs = dbDao.oceanLinkSChk(vo);
//						if(dRs.next()){
//							throw new DAOException((new ErrorHandler("PRD00048")).getMessage());
//						}
//						int retInsertVal = dbDao.insertPrdPfTxTm(vo);
//						log.debug("\n\n ★insertVar: " + retInsertVal);
//
//						DBRowSet tmpDRs = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd());
//						boolean isOcnRout = false;
//						while(tmpDRs.next()){
//							isOcnRout = true;
//							// history 생성 JSY 
//							dbDao.historyOcnAdd(tmpDRs.getString("ORG_LOC_CD"), tmpDRs.getString("DEST_LOC_CD"), tmpDRs.getString("ROUT_SEQ"));
//
//						}
//
////						int retMergeOcnRoutVal = dbDao.oceanLinkMergeInto(vo);
//						dbDao.oceanLinkMergeInto(vo);
//
//						if(!isOcnRout){
//							tmpDRs = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd());
//							if(tmpDRs.next()){
//								// history 생성 JSY 
//								dbDao.historyOcnAdd(tmpDRs.getString("ORG_LOC_CD"), tmpDRs.getString("DEST_LOC_CD"), tmpDRs.getString("ROUT_SEQ"));
//
//							}
//						}
//					}
//
//
//					if(!vo.getIbflag().equals("I")){
//						DBRowSet tmpDRs2 = dbDao.searchDirecOcnRout(vo.getPolprot(), vo.getPodprot(), vo.getLanecd()); //새로 추가된 ocn rout를 찾는다.
//						if(tmpDRs2.next()){
//							// history 생성 JSY 
//							dbDao.historyOcnAdd(tmpDRs2.getString("ORG_LOC_CD"), tmpDRs2.getString("DEST_LOC_CD"), tmpDRs2.getString("ROUT_SEQ"));
//						}
//					}
//
//					retVal = dbDao.oceanLinkUpdate1(vo);
//					log.debug("\n @@@@@@@@@@@@@@@@ 1.UPDATE는 DIRECT 구간의 tgm_upt_ind, REMARK만 UPDATE :" + retVal);
//					
//					if(vo.getIbflag().equals("D")){
//						dbDao.deleteManualPfTzTm(vo);
//					}
//
//					if(vo.getIbflag().equals("D") && vo.getDelcombo().equals("T")){ //sStatus ,delcombo
//						
//						dbDao.historyOcnAddByLinkNo(vo.getPolprot(), vo.getPodprot(), vo.getLanecd(), "1");
//						dbDao.oceanLinkUpdate2(vo);
//
//						dbDao.historyOcnAddByLinkNo(vo.getPolprot(), vo.getPodprot(), vo.getLanecd(), "2");
//						dbDao.oceanLinkUpdate3(vo);
//
//						dbDao.historyOcnAddByLinkNo(vo.getPolprot(), vo.getPodprot(), vo.getLanecd(), "3");
//						dbDao.oceanLinkUpdate4(vo);
//
//						dbDao.historyOcnAddByLinkNo(vo.getPolprot(), vo.getPodprot(), vo.getLanecd(), "5");
//						dbDao.oceanLinkUpdate5(vo);
//					}
//
//					if(vo.getIbflag().equals("U") && vo.getOcnLnkMnlFlg().equals("Y")){ //sStatus가 U  , manual 일때 
//
//						dbDao.updateManualPfTzTm(vo);
//
//						retVal = dbDao.updateManualOcnRoutN1st(vo);
//						retVal = dbDao.updateManualOcnRoutN2nd(vo);
//						retVal = dbDao.updateManualOcnRoutN3rd(vo);
//						retVal = dbDao.updateManualOcnRoutN4th(vo);
//
//
//					}
//
//				}// for끝
//
//			}
//		}catch(DAOException ex){
//			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		}catch(Exception ex){
//			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		}
//	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESD_PRD_0013 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLinkRHQVO> searchOceanLinkListRHQ(SearchOceanLinkRHQVO vo) throws EventException{
		try{
			return dbDao.searchOceanLinkListRHQ(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 *  멀티 이벤트 처리<br>
	 * ESD_PRD_013 화면에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-17 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanLinkRHQ(SaveOceanLinkRHQVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			List<SaveOceanLinkRHQVO> insertVoList = new ArrayList<SaveOceanLinkRHQVO>();
			List<SaveOceanLinkRHQVO> updateVoList = new ArrayList<SaveOceanLinkRHQVO>();

			for(int i = 0; i < vos.length; i++){
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());

				if(vos[i].getIbflag().equals("I")){
					insertVoList.add(vos[i]);
				}else if(vos[i].getIbflag().equals("U")){
					updateVoList.add(vos[i]);

					if(vos[i].getHChkLaneDirTztm().equals("U")){
//						int iUpdatePs2 = dbDao.oceanLinkRHQUpdate2(vos[i]);
//						int iUpdatePs3 = dbDao.oceanLinkRHQUpdate3(vos[i]);
//						int iUpdatePs4 = dbDao.oceanLinkRHQUpdate4(vos[i]);
//						int iUpdatePs5 = dbDao.oceanLinkRHQUpdate5(vos[i]);
						dbDao.oceanLinkRHQUpdate2(vos[i]);
						dbDao.oceanLinkRHQUpdate3(vos[i]);
						dbDao.oceanLinkRHQUpdate4(vos[i]);
						dbDao.oceanLinkRHQUpdate5(vos[i]);

					}
				}else if(vos[i].getIbflag().equals("D")){
//					int delResult = dbDao.oceanLinkRHQDelete(vos[i]);
//					int his1 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "1");
//					int delResult2 = dbDao.oceanLinkRHQDelete2(vos[i]);
//					int his2 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "2");
//					int delResult3 = dbDao.oceanLinkRHQDelete3(vos[i]);
//					int his3 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "3");
//					int delResult4 = dbDao.oceanLinkRHQDelete4(vos[i]);
//					int his4 = dbDao.historyOcnFdrAddByLinkNo(vos[i].getSFrom(), vos[i].getSTo(), "4");
//					int delResult5 = dbDao.oceanLinkRHQDelete5(vos[i]);
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

			if(insertVoList.size() > 0){
				dbDao.oceanLinkRHQInsert(insertVoList);
			}

			if(updateVoList.size() > 0){
				dbDao.oceanLinkRHQUpdate(updateVoList);
			}


		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}


	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * OceanLinkManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
