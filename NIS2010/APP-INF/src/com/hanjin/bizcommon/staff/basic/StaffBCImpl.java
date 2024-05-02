/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : StaffBCImpl.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-31 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.staff.basic;

import java.util.List;

import com.hanjin.bizcommon.country.vo.CountryListVO;
import com.hanjin.bizcommon.staff.integration.StaffDBDAO;
import com.hanjin.bizcommon.staff.vo.SearchDeptListVO;
import com.hanjin.bizcommon.staff.vo.SearchStaffListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_091EventResponse,StaffBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class StaffBCImpl   extends BasicCommandSupport implements StaffBC {

	// Database Access Object
	private transient StaffDBDAO dbDao=null;

	/**
	 * StaffBCImpl 객체 생성<br>
	 * StaffDBDAO를 생성한다.<br>
	 */
	public StaffBCImpl(){
		dbDao = new StaffDBDAO();
	}

	/**
	 * 
	 * Staff화면에 대한 조회 이벤트 처리<br>
	 * @param ofcCd
	 * @param userCd
	 * @param userNm
	 * @param iPage
	 * @return List<SearchStaffListVO>
	 * @throws DAOException
	 */
	public List<SearchStaffListVO> searchStaffList(String ofcCd, String userCd, String userNm, int iPage) throws EventException {
		List<SearchStaffListVO> list = null;		
		
        try {
			list = dbDao.searchStaffList(ofcCd, userCd, userNm, iPage);
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
        return list;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Staff화면에 대한 조회 이벤트 처리<br>
	 * @param ofcCd
	 * @return List<SearchDeptListVO>
	 * @throws DAOException
	 */
	public List<SearchDeptListVO> searchDeptList(String ofcCd) throws EventException {
        try {
			return dbDao.searchDeptList(ofcCd);
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Staff업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}