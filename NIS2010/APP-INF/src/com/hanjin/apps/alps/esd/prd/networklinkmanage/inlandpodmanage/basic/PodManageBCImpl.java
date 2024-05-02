/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PodManageBCImpl.java
*@FileTitle : PodManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-24
*@LastModifier : Noh Seung Bae
*@LastVersion : 1.0
* 2009-08-24 Noh Seung Bae
* 1.0 최초 생성
* 2011.11.02 이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.integration.PodManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.PrdImdgClssCdVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo.SearchPodListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-PRD Business Logic Basic Command implementation<br/>
 * - eNIS-PRD에 대한 비지니스 로직을 처리한다.<br/>
 * 
 * @author noh seung bae
 * @see ESD_PRD_085EventResponse,YardManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PodManageBCImpl extends BasicCommandSupport implements PodManageBC {

	// Database Access Object
	private transient PodManageDBDAO dbDao=null;

	/**
	 * YardManageBCImpl 객체 생성<br>
	 * YardManageDBDAO를 생성한다.<br>
	 */
	public PodManageBCImpl(){
		dbDao = new PodManageDBDAO();
	}
	

	
	/**
	 * 조회 이벤트 처리<br>
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchPodListVO> searchPodList(SearchPodListVO vo) throws EventException{
		try {
			return dbDao.searchPodList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * searchLoactionState
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchPodListVO> searchLoactionState(SearchPodListVO vo) throws EventException{
		try {
			return dbDao.searchLocationState(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * searchValidation
	 * ★2009-10-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public String searchValidation(SearchPodListVO vo) throws EventException{
		DBRowSet rowSet=null;
		String counter = null;
		try {
			rowSet = dbDao.searchValidation(vo);
			if((rowSet.next() && 0 < rowSet.getInt("COUNTER")) && "Y".equals(rowSet.getString("DELT_FLG"))){
				dbDao.updatePrdPodMgmt(vo);
				counter = "Y".equals(rowSet.getString("DELT_FLG")) ? "2" : JSPUtil.getNull(rowSet.getString("COUNTER")) ;
			}
			return counter;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	
		
		
	}
	
	
	
	
	
	/**
	 * pod 저장처리
	 * ★2009-10-16 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiPod(SearchPodListVO[] vos, SignOnUserAccount account) throws EventException{
		try {
			List<SearchPodListVO> insertVoList = new ArrayList<SearchPodListVO>();
			List<SearchPodListVO> updateVoList = new ArrayList<SearchPodListVO>();
			
			for ( int i=0; i<vos .length; i++ ) {
				if ( vos[i].getIbflag().equals("I")){
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					vos[i].setCreOfcCd(account.getOfc_cd());
					vos[i].setUpdOfcCd(account.getOfc_cd());
					insertVoList.add(vos[i]);
				} else if ( vos[i].getIbflag().equals("U")){
					vos[i].setUpdUsrId(account.getUsr_id());
					vos[i].setUpdOfcCd(account.getOfc_cd());
					updateVoList.add(vos[i]);
					
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.insertPod(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.addPrdPodMgmtHistory(updateVoList);
				dbDao.updatePod(updateVoList);
			}
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
		
		
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * YardManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}



	/**
	 * Class 를 조회 합니다. <br>
	 * 
	 * @return List<PrdImdgClssCdVO>
	 * @exception EventException
	 */
	public List<PrdImdgClssCdVO> searchUNClass() throws EventException {
		try {
			return dbDao.searchUNClass();
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Class Code"}).getMessage(), ex);
		}		
	}

}