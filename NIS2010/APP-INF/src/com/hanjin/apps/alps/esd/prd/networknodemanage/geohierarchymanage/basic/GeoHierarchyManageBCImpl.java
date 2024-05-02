/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GeoHierarchyManageBCImpl.java
 *@FileTitle : Geographic Hierarchy 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-08-30 kimyoungchul
 * 1.0 최초 생성
 * 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.integration.GeoHierarchyManageDBDAO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author kimyoungchul
 * @see EsdPrd001EventResponse,GeoHierarchyManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class GeoHierarchyManageBCImpl extends BasicCommandSupport implements GeoHierarchyManageBC{

	// Database Access Object
	private transient GeoHierarchyManageDBDAO dbDao = null;

	/**
	 * GeoHierarchyManageBCImpl 객체 생성<br>
	 * GeoHierarchyManageDBDAO를 생성한다.<br>
	 */
	public GeoHierarchyManageBCImpl(){
		dbDao = new GeoHierarchyManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * GeoHierarchyManage화면에 대한 조회 이벤트 처리<br>
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyList(SearchGeoHierarchyManageVO vo) throws EventException{
		try{
			return dbDao.searchGeoHierarchyManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * GeoHierarchyManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
