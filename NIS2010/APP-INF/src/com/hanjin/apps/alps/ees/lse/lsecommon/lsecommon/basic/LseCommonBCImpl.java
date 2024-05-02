/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LseCommonBCImpl.java
*@FileTitle : ETC LesCommon Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.29 장준우
* 1.0 Creation
* 2014-02-19 채창호 [CHM-201428698-01] Split 01-계약 종료 Notice건 개발
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.integration.LseCommonDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS-LseCommon system Business Logic Basic Command implementation<br>
 * - ALPS-LseCommon 에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see LseCommonBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LseCommonBCImpl extends BasicCommandSupport implements LseCommonBC {
	// Database Access Object
	private transient LseCommonDBDAO dbDao = null;

	/**
	 * LseCommonBCImpl 객체 생성<br>
	 * LseCommonDBDAO를 생성한다.<br>
	 */
	public LseCommonBCImpl() {
		dbDao = new LseCommonDBDAO();
	}

	/**
	 * Location - Port 코드목록을 조회합니다.<br>
	 *
	 * @param  String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchLocationPortBasic(String locCd) throws EventException {
		List<MdmLocationVO>  list = null;

		try {
			list = dbDao.searchLocationPortData(locCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Vessel SKD 목록을 조회합니다.<br>
	 *
	 * @param  String vvdCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVesselSkdBasic(String vvdCd) throws EventException {
		List<VskVslPortSkdVO>  list = null;

		try {
			list = dbDao.searchVesselSkdData(vvdCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 컨테이너 정보 조회합니다.<br>
	 *
	 * @param  String cntrNo
	 * @return MstContainerVO
	 * @exception EventException
	 */
	public MstContainerVO searchContainerInfoBrieflyBasic(String cntrNo) throws EventException {
		List<MstContainerVO> list = null;

		try {
			list = dbDao.searchContainerInfoBrieflyData(cntrNo);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list.get(0);
	}

	/**
	 * Office 코드목록을 조회합니다.<br>
	 *
	 * @param  String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCodeBasic(String ofcCd) throws EventException {
		List<MdmOrganizationVO>  list = null;

		try {
			list = dbDao.searchOfficeCodeData(ofcCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Vessel SVC Lane 목록을 조회합니다.<br>
	 *
	 * @param  String slanCd
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneBasic(String slanCd) throws EventException {
		List<MdmVslSvcLaneVO>  list = null;

		try {
			list = dbDao.searchServiceLaneData(slanCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Agreement No 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * @param String agmtNo
	 * @return String
	 * @exception EventException
	 */	
	public String searchLessorCodeCtrtNtcInfo(String agmtNo) throws EventException { 
		try {
			return dbDao.searchLessorCodeCtrtNtcInfo(agmtNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("LSE10005", new String[]{}).getMessage(), ex);
		}
	}
}