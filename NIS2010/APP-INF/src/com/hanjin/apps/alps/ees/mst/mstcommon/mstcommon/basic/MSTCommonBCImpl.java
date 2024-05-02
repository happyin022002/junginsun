/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonBCImpl.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.18 이호선
* 1.0 Creation
* 
* History
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration.MSTCommonDBDAO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.integration.MSTCommonEAIDAO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-MSTCommon Business Logic Basic Command implementation<br>
 * - ALPS-MSTCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Ho Sun
 * @see MST_COMEventResponse,MSTCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MSTCommonBCImpl extends BasicCommandSupport implements MSTCommonBC {

	// Database Access Object
	private transient MSTCommonDBDAO dbDao = null;
	private transient MSTCommonEAIDAO eaiDao = null;

	/**
	 * MSTCommonBCImpl 객체 생성<br>
	 * MSTCommonDBDAO를 생성한다.<br>
	 */
	public MSTCommonBCImpl() {
		dbDao = new MSTCommonDBDAO();
		eaiDao = new MSTCommonEAIDAO();
	}
	/**
	 * ManufacturerList : 공통 retrieve<br>
	 *  Manufacturer List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchManufacturerListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchManufacturerListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacturer"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacturer"}).getMessage(),ex);		
		}
	}
	
	/**                       
	 * EqTypeSizeList :  공통 retrieve<br>
	 * Eq Type Size List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchEqTypeSizeListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchEqTypeSizeListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search TP/SZ"}).getMessage(),ex);
		}
	}
	
	/**                       
	 * ManufacturePlaceList : 공통 retrieve<br>
	 * Manufacture Place List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchManufacturePlaceListBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchManufacturePlaceListData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacture Place"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Manufacture Place"}).getMessage(),ex);		
		}
	}
	
	/**
	 * EES_MST_0014 : retrieve<br>
	 * Lease Agreement List 조회<br>
	 * 
	 * @param AgmtInfoVO agmtInfoVO
	 * @return List<AgmtInfoVO>
	 * @exception EventException
	 */
	public List<AgmtInfoVO> searchAgmtBasic(AgmtInfoVO agmtInfoVO) throws EventException {
		//int cnt = 0;                       // 조회 데이터 총카운트
		List<AgmtInfoVO> resultVOs = new ArrayList<AgmtInfoVO>();

		try {
			if (agmtInfoVO.getAgmtSeq() != null && !agmtInfoVO.getAgmtSeq().equals("")){
				resultVOs = dbDao.searchAgmtData(agmtInfoVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lease Agreement"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lease Agreement"}).getMessage(),ex);		
		}
		
		return resultVOs;
	}
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * MSTCommon화면에 대한 조회 이벤트 처리<br>
	 * @param CommonListVO   commonListVO
	 * @return CommonListVO
	 * @exception EventException
	 */	
	public CommonListVO searchYardCodeBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchYardCodeData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Yard Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Yard Code"}).getMessage(),ex);
		}
	}
	
	/**
	 * Lessor 코드명을 조회합니다.<br>
	 * 
	 * @param CommonListVO   commonListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchLessorCodeBasic(CommonListVO commonListVO) throws EventException {
		try {
			return dbDao.searchLessorCodeData(commonListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lessor Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Lessor Code"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * Reefer Type Code를 조회합니다.<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchReeferTypeCodeListBasic() throws EventException {
		try {
			return dbDao.searchReeferTypeCodeListData();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Unit Type Code"}).getMessage(),ex);
		}
	}	
	
	/**
	 * COM_INTG_CD를 조회합니다.<br>
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException {
		try {
			return dbDao.searchComIntgCdListData(intgCdId,intgCdVal);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Search Intg Code"}).getMessage(),ex);
		}
	}	
	
	/**
	 * EDI 메시지를 송신합니다.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEdiToFleet(String flatFile) throws EventException { 
		try {
			return eaiDao.sendEdiToFleet(flatFile);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MST00013", new String[]{"  Send EDI to Fleet"}).getMessage(),ex);
		}
	}	
}