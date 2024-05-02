/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteConditionManageBCImpl.java
 *@FileTitle : Ocean Route Condition Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration.OceanRouteConditionManageDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author jungsunyoung
 * @see ESD_PRD_011EventResponse,OceanRouteConditionManageBC 
 * @since J2EE 1.4
 */
public class OceanRouteConditionManageBCImpl extends BasicCommandSupport implements OceanRouteConditionManageBC{

	// Database Access Object
	private transient OceanRouteConditionManageDBDAO dbDao = null;

	/**
	 * creating OceanRouteConditionManageBCImpl<br>
	 * creating OceanRouteConditionManageDBDAO<br>
	 */
	public OceanRouteConditionManageBCImpl(){
		dbDao = new OceanRouteConditionManageDBDAO();
	}

	/**
	 * retrieving - OceanRouteConditionManage
	 * 
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
	 * 
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
	 *  multi event - ESD_PRD_0011
	 *  
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
				for (int i = 0; i < insertVoList.size(); i++) {
					
					int chkCnt = dbDao.checkDupOceanLink(insertVoList.get(i));
					if(chkCnt > 0){
						throw new EventException(new ErrorHandler("PRD99998",new String[]{"Duplication Data." }).getMessage());
					}
					
				}
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
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * retrieving - OceanRouteConditionManage Embargo
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
	 * multi event - ESD_PRD_010
	 * 
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
	 * 
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
