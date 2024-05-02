/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBCBCImpl.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2011.10.26 신자영 [CHM-201113916-01] [CIM] Load factor by cy의 sub-trade 검색 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.integration.CIMCommonDBDAO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.SearchDayListVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CNTROperatioNPerformanceMgt Business Logic Basic Command implementation<br>
 * - ALPS-CNTROperatioNPerformanceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Prak Kwang Seok
 * @see CIMCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class CIMCommonBCImpl extends BasicCommandSupport implements CIMCommonBC {

	// Database Access Object
	private transient CIMCommonDBDAO dbDao = null;

	/**
	 * CIMCommonBCImpl 객체 생성<br>
	 * CIMCommonBCDBDAO를 생성한다.<br>
	 */
	public CIMCommonBCImpl() {
		dbDao = new CIMCommonDBDAO();
	}
	/**
	 * TPSZSequence의 List를 조회 합니다. <br>
	 * 
	 * @return List<TypeSizeSequenceVO>
	 * @exception EventException
	 */
	public List<TypeSizeSequenceVO> searchTPSZSequenceList() throws EventException {
		try {
			return dbDao.searchTPSZSequenceList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21003",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Day의 List를 조회 합니다. <br>
	 * 
	 * @return List<SearchDayListVO>
	 * @exception EventException
	 */
	public List<SearchDayListVO> searchDayList() throws EventException {
		try {
			return dbDao.searchDayList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21003",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException 
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException {
		String check = null;
		try {
		//	if("Y".equals(locLevel)){
		//		check = dbDao.checkLocationYardr(locLevel ,locCD);
		//	}
		//	else if("O".equals(locLevel) || "C".equals(locLevel) || "P".equals(locLevel)){
				check = dbDao.checkLocation(locLevel ,locCD);
		//	}
		//	else{
		//		check = dbDao.checkLocationEqOrzCht(locLevel ,locCD);
		//	}
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21017",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	/**
	 * VVD를 check  합니다. <br>
	 * 
	 * @param vvd 
	 * @return String
	 * @exception EventException 
	 */
	public String checkVVD(String vvd) throws EventException {
		String check = null;
		try {
			check = dbDao.checkVVD(vvd);
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21009",new String[]{""}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}	
	
	/**
	 * Port List를 조회 합니다. <br>
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchPortList() throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchPortList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}	

	/**
	 * trade에 해당하는 Lane List를 조회 합니다. <br>
	 *  
	 * @param trade
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchLaneList(String trade) throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchLaneList(trade);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21007",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}
	/**
	 * trade에 해당하는 Sub Trade List를 조회 합니다. <br>
	 *  
	 * @param trade
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchSubTradeList(String trade) throws EventException {
		String[] arrPort = null;
		try {
			log.debug("\n trade!!!!!!!!!!!!!!!!!!!!!!!!!!");
			log.debug("\n trade  " +  trade);
			arrPort = dbDao.searchSubTradeList(trade);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21007",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}
	/**
	 * 입력받은 lane Code Validation Check<br>
	 * 
	 * @param lane 
	 * @return String
	 * @exception EventException 
	 */
	public String checkLane(String lane) throws EventException {
		String check = null;
		try {
			check = dbDao.checkLane(lane);
					
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21008",new String[]{""}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}		
	
	/**
	 * Rcc List를 조회 합니다. <br>
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchRCCList() throws EventException {
		String[] arrPort = null;
		try {
			arrPort = dbDao.searchRCCList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21010",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrPort;
	}		
	
	/**
	 * PortTurnTime화면에 있는 COMBO List를 조회 합니다. <br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchPortTurnTimeCombo() throws EventException {
		String[] sPort = null;
		String[] sLane = null;
		List<TypeSizeSequenceVO> list = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
		try {
			sPort = dbDao.searchPortList();
			sLane = dbDao.searchLaneList(null);
			list = dbDao.searchTPSZSequenceList();
			sReturn.setSPort(sPort);
			sReturn.setSLane(sLane);
			sReturn.setTypeSizeSequenceVO(list);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}	
	
	/**
	 * CntrTypeSize List를 조회합니다.<br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCntrTypeSizeList() throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] arrTpsz = null;

		try {
			arrTpsz = dbDao.searchCntrTypeSizeList();

		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrTpsz;
	}
	
	
	/**
	 * Trade List를 조회합니다.<br>
	 * 
	 * @return String[]
	 * @exception EventException 
	 */
	public String[] searchTradeList() throws EventException {
		String[] arrTrade = null;
		try {
			arrTrade = dbDao.searchTradeList();
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21015",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return arrTrade;
	}		
	
	/**
	 * AroundTurnTime화면에 있는 Combo를 조회 합니다.<br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchAroundTurnTimeCombo() throws EventException {
		String[] sTrade = null;
		//String[] sLane = null;
		String[] sTpsz = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
		
		try {
			sTrade = dbDao.searchTradeList();
		//	sLane = dbDao.searchLaneList();
			sTpsz = dbDao.searchCntrTypeSizeList();
			
			sReturn.setSTrade(sTrade);
			sReturn.setSTpsz(sTpsz);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21011",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}		
	
	/**
	 * REPOResultByPort화면에 있는 Combo를 조회 합니다.<br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException 
	 */
	public CommonComboSetVO searchREPOResultByPortCombo() throws EventException {
		String[] sPort = null;
		String[] sLane = null;
		String[] sRcc = null;
		List<TypeSizeSequenceVO> list = null;
		CommonComboSetVO sReturn = new CommonComboSetVO();
//		Map<String, Object> sReturn = new HashMap<String, Object>();
		try {
			sPort = dbDao.searchPortList();
			sLane = dbDao.searchLaneList(null);
			sRcc = dbDao.searchRCCList();
			list = dbDao.searchTPSZSequenceList();
			sReturn.setSPort(sPort);
			sReturn.setSLane(sLane);
			sReturn.setSRcc(sRcc);
			sReturn.setTypeSizeSequenceVO(list);
			
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return sReturn;
	}

}