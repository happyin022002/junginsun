/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : HubLocationMatchingManageBCImpl.java
 *@FileTitle : HubLocation 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.integration.HubLocationMatchingManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyong
 * @see ESD_PRD_004EventResponse,HubLocationMatchingManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class HubLocationMatchingManageBCImpl extends BasicCommandSupport implements HubLocationMatchingManageBC{

	// Database Access Object
	private transient HubLocationMatchingManageDBDAO dbDao = null;

	/**
	 * HubLocationMatchingManageBCImpl 객체 생성<br>
	 * HubLocationMatchingManageDBDAO를 생성한다.<br>
	 */
	public HubLocationMatchingManageBCImpl(){
		dbDao = new HubLocationMatchingManageDBDAO();
	}

	/**
	 * HubLocationMatchingManageBCImpl.java's searchHubLocationMatchingManage
	 * @param searchHubLocationListVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchHubLocationListVO> searchHubLocationMatchingManage(SearchHubLocationListVO searchHubLocationListVO) throws EventException{
		try{
			return dbDao.searchHubLocationMatchingManage(searchHubLocationListVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_004 화면에 대한 멀티 이벤트 처리<br>
	 * 2009/07/28 kim kwi-jin작성
	 * @param searchHubLocationListVO
	 * @param account
	 * @exception EventException
	 */
	public void multiHubLocationMatchingManage(SearchHubLocationListVO[] searchHubLocationListVO, SignOnUserAccount account) throws EventException{
		try{
			List<SearchHubLocationListVO> insertVoList = new ArrayList<SearchHubLocationListVO>();
			List<SearchHubLocationListVO> updateVoList = new ArrayList<SearchHubLocationListVO>();
			List<SearchHubLocationListVO> deleteVoList = new ArrayList<SearchHubLocationListVO>();
			for(int i = 0; i < searchHubLocationListVO.length; i++){
				if(searchHubLocationListVO[i].getIbflag().equals("I")){
					searchHubLocationListVO[i].setCreUsrId(account.getUsr_id());
					searchHubLocationListVO[i].setUpdUsrId(account.getUsr_id());
					searchHubLocationListVO[i].setCreOfcCd(account.getOfc_cd());
					insertVoList.add(searchHubLocationListVO[i]);
				}else if(searchHubLocationListVO[i].getIbflag().equals("U")){
					searchHubLocationListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchHubLocationListVO[i]);
				}else if(searchHubLocationListVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchHubLocationListVO[i]);
				}
			}

			// 존재 여부 체크 
			if(insertVoList.size() > 0){
				for (int i = 0; i < insertVoList.size(); i++) {
					
					int chkCnt = dbDao.checkHubLocation(insertVoList.get(i));
					if(chkCnt > 0){
						throw new DAOException(new ErrorHandler("COM12225", new String[]{insertVoList.get(i).getPortCd()+"-"+insertVoList.get(i).getLocCd()  }).getMessage());
					}
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addHubLocationSaveS(insertVoList);
			}

			if(updateVoList.size() > 0){
				dbDao.modifyHubLocationSaveS(updateVoList);
			}

			if(deleteVoList.size() > 0){
				dbDao.removeHubLocationSaveS(deleteVoList);
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
	 * HubLocationMatchingManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
