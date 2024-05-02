/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : YardManageBCImpl.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
 * 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0008Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration.YardManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeDefaultSpInfoListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDwellHistoryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse,YardManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class YardManageBCImpl extends BasicCommandSupport implements YardManageBC{

	// Database Access Object
	private transient YardManageDBDAO dbDao = null;

	/**
	 * YardManageBCImpl 객체 생성<br>
	 * YardManageDBDAO를 생성한다.<br>
	 */
	public YardManageBCImpl(){
		dbDao = new YardManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchNodeList(SearchNodeListVO vo) throws EventException{
		try{
			return dbDao.searchNodeList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchYardDetail(SearchYardDetailVO vo) throws EventException{
		try{
			return dbDao.searchYardDetail(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchZonePostCode(SearchZonePostCodeVO vo) throws EventException{
		try{
			return dbDao.searchZonePostCode(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchZoneDetail(SearchZoneDetailVO vo) throws EventException{
		try{
			return dbDao.searchZoneDetail(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * YardManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 * YardManageBCImpl's searchLeaseList
	 *
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchLeaseList(SearchLeaseListVO vo) throws EventException{
		try{
			return dbDao.searchLeaseList(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * YardManageBCImpl's SearchYardDwellHistoryVO
	 *
	 * @param event
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchYardDwellHistoryVO> searchDwellTimeHIstory(
			EsdPrd0008Event event) throws EventException {
		try{
			return dbDao.searchDwellTimeHIstory(event.getSearchYardDwellHistoryVO());
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchNodeDefaultSpInfoList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO)
			throws EventException {
		try{
			return dbDao.searchNodeDefaultSpInfoList(searchNodeDefaultSpInfoListVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	
	
	/**
	 * 수정 이벤트 처리<br>
	 * 
	 *
	 * @param searchNodeDefaultSpInfoListVOS
	 * @param account
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public void modifyNodeDefaultSpInfoList(	SearchNodeDefaultSpInfoListVO[] searchNodeDefaultSpInfoListVOS,SignOnUserAccount account) throws EventException {
		try {
			List<SearchNodeDefaultSpInfoListVO> updateVoList = new ArrayList<SearchNodeDefaultSpInfoListVO>();
			
			
			String tmpYdCd = "";
			String os ="";
			String spCode="";
			String ctc= "";
			SearchNodeDefaultSpInfoListVO vo = null;
			for(int i=0; i<searchNodeDefaultSpInfoListVOS.length; i++){
				if(searchNodeDefaultSpInfoListVOS[i].getIbflag().equals("U")){		
					String ydCd= searchNodeDefaultSpInfoListVOS[i].getYdCd();
					 os= searchNodeDefaultSpInfoListVOS[i].getOs();
					 spCode= searchNodeDefaultSpInfoListVOS[i].getSpCode();
					 ctc= searchNodeDefaultSpInfoListVOS[i].getCountryCode();

					if(!tmpYdCd.equals(ydCd)) {
						vo = new SearchNodeDefaultSpInfoListVO();
					}
						
					 vo.setYdCd(ydCd);
					 vo.setOs(os);
					 
					 if(i==0 || tmpYdCd.equals(ydCd)) {
						
						if(os.equals("Wharfage")){
							vo.setN4thVndrCntCd(ctc);
							vo.setN4thVndrSeq(spCode);
							vo.setChkOsD("D");
						 }else if(os.equals("Assessment")){
							vo.setN5thVndrCntCd(ctc);
							vo.setN5thVndrSeq(spCode);
							vo.setChkOsE("E");
						 }else if(os.equals("Storage")){
							vo.setN6thVndrCntCd(ctc);
							vo.setN6thVndrSeq(spCode);
							vo.setChkOsF("F");
						 }
						
					} else {
						if(os.equals("Wharfage")){
							vo.setN4thVndrCntCd(ctc);
							vo.setN4thVndrSeq(spCode);
							vo.setChkOsD("D");
						 }else if(os.equals("Assessment")){
							 vo.setN5thVndrCntCd(ctc);
							vo.setN5thVndrSeq(spCode);
							vo.setChkOsE("E");
						 }else if(os.equals("Storage")){
							vo.setN6thVndrCntCd(ctc);
							vo.setN6thVndrSeq(spCode);
							vo.setChkOsF("F");
						 }
						
					}
					 vo.setUpdusrid(account.getUsr_id());
					 
					if(!tmpYdCd.equals(ydCd)){	
						updateVoList.add(vo);
					}
					
					tmpYdCd = ydCd;
					
					
					
					
				}
				
			} // for
			
				
			if(updateVoList.size() > 0){				
				dbDao.modifyNodeDefaultSpInfoList(updateVoList);
			}
		} catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 *
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchSubOfficeSOManageList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO)
			throws EventException {
		try{
			return dbDao.searchSubOfficeSOManageList(searchNodeDefaultSpInfoListVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 *
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List searchSubOfficeCList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO)
			throws EventException {
		try{
			return dbDao.searchSubOfficeCList(searchNodeDefaultSpInfoListVO);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}



}
