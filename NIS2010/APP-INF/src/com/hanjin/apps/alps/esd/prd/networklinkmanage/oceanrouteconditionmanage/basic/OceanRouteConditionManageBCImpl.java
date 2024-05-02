/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteConditionManageBCImpl.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-02 jungsunyoung
 * 1.0 최초 생성
 * N200902100240 2009-02-27 Terminal Matrix Exception UI 추가 개발 (ESD_PRD_041)
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration.OceanRouteConditionManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see ESD_PRD_011EventResponse,OceanRouteConditionManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OceanRouteConditionManageBCImpl extends BasicCommandSupport implements OceanRouteConditionManageBC{

	// Database Access Object
	private transient OceanRouteConditionManageDBDAO dbDao = null;

	/**
	 * OceanRouteConditionManageBCImpl 객체 생성<br>
	 * OceanRouteConditionManageDBDAO를 생성한다.<br>
	 */
	public OceanRouteConditionManageBCImpl(){
		dbDao = new OceanRouteConditionManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteConditionManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteConditionVO> searchOceanRouteConditionManageList(SearchOceanRouteConditionVO vo) throws EventException{
		try{
			return dbDao.searchOceanRouteConditionManageList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * searchCallingTmlMtxExptList
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchCallingTmlMtxExptVO> searchCallingTmlMtxExptList(SearchCallingTmlMtxExptVO vo) throws EventException{
		try{
			return dbDao.searchCallingTmlMtxExptList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 *  멀티 이벤트 처리<br>
	 *  ESD_PRD_0011 화면에 대한 멀티 이벤트 처리<br>
	 *  ★2009-09-16 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRouteConditionManage(SearchOceanRouteConditionVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			List<SearchOceanRouteConditionVO> insertVoList = new ArrayList<SearchOceanRouteConditionVO>();
			List<SearchOceanRouteConditionVO> updateVoList = new ArrayList<SearchOceanRouteConditionVO>();
			List<SearchOceanRouteConditionVO> deleteVoList = new ArrayList<SearchOceanRouteConditionVO>();
			List<SearchOceanRouteConditionVO> historyVoList = new ArrayList<SearchOceanRouteConditionVO>();
			String portCd = "";
			String vslSlanCd = "";
			String skdDirCd = "";
			String crrCd = "";
			DBRowSet dRs = null;

			long max = 0;
			for(int i = 0; i < vos.length; i++){

				if(!portCd.equals(vos[i].getPortCd()) || !vslSlanCd.equals(vos[i].getVslSlanCd()) || !skdDirCd.equals(vos[i].getSkdDirCd()) || !crrCd.equals(vos[i].getCrrCd())){
					dRs = dbDao.oceanRouteCondiHistoryMax(vos[i]);
					if(dRs.next()){
						max = dRs.getInt("max_seq");
					}
				}
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setMaxSeq(max + "");


				if(vos[i].getIbflag().equals("I")){
					insertVoList.add(vos[i]);
				}else if(vos[i].getIbflag().equals("U")){
					updateVoList.add(vos[i]);
				}else if(vos[i].getIbflag().equals("D")){
					deleteVoList.add(vos[i]);
				}

				historyVoList.add(vos[i]);
			}

			if(insertVoList.size() > 0){
				dbDao.oceanRouteCondiInsert(insertVoList);
			}

			if(updateVoList.size() > 0){
				dbDao.oceanRouteCondiUpdate(updateVoList);
			}

			if(deleteVoList.size() > 0){
				dbDao.oceanRouteCondiDelete(deleteVoList);
			}

			if(historyVoList.size() > 0){
				dbDao.oceanRouteCondiHistoryAdd(historyVoList);
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
	 * OceanRouteConditionManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteConditionManage Embargo 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return 
	 * @throws EventException
	 */
	public List<SearchEmbargoVO> searchEmbargoManageList(SearchEmbargoVO vo) throws EventException{
		try{
			return dbDao.searchEmbargoManageList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_010 화면에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiEmbargoManage(SearchEmbargoVO[] vos, SignOnUserAccount account) throws EventException{
		try{
			List<SearchEmbargoVO> insertVoList = new ArrayList<SearchEmbargoVO>();
			List<SearchEmbargoVO> updateVoList = new ArrayList<SearchEmbargoVO>();
			List<SearchEmbargoVO> deleteVoList = new ArrayList<SearchEmbargoVO>();
			for(int i = 0; i < vos.length; i++){
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());

				if(vos[i].getIbflag().equals("I")){
					insertVoList.add(vos[i]);
				}else if(vos[i].getIbflag().equals("U")){
					updateVoList.add(vos[i]);
				}else if(vos[i].getIbflag().equals("D")){
					deleteVoList.add(vos[i]);
				}
			}

			if(insertVoList.size() > 0){
				dbDao.insertEmbargo(insertVoList);
			}

			if(updateVoList.size() > 0){
				dbDao.updateEmbargo(updateVoList);
			}

			if(deleteVoList.size() > 0){
				dbDao.deleteEmbargo(deleteVoList);
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
	 * multiCallingTmlMtxExptList
	 * ★2009-09-17 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiCallingTmlMtxExptList(SearchCallingTmlMtxExptVO[] vos, SignOnUserAccount account) throws EventException{
		try{

			List<SearchCallingTmlMtxExptVO> deleteVoList = new ArrayList<SearchCallingTmlMtxExptVO>();
			for(int i = 0; i < vos.length; i++){
				vos[i].setCreOfcCd(account.getOfc_cd());
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());

				if(vos[i].getIbflag().equals("I") || vos[i].getIbflag().equals("U")){
//					int mergeRes = dbDao.mergeCallingTmlMtxExpt(vos[i]);
					dbDao.mergeCallingTmlMtxExpt(vos[i]);
				}else if(vos[i].getIbflag().equals("D")){
					deleteVoList.add(vos[i]);
				}
			}
			if(deleteVoList.size() > 0){
				dbDao.deleteCallingTmlMtxExpt(deleteVoList);
			}
		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}
}
