/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CMAGTCalcBCImpl.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
2007-01-11 SangJun Kwon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.cmagtcalc.basic;

import java.util.HashMap;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.apps.alps.esm.agt.agtcalculation.cmagtcalc.integration.CMAGTCalcDBDAO;

/**
 * eNIS-agt Business Logic Basic Command implementation<br>
 * - eNIS-agt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SangJun Kwon
 * @see ESM_AGT_008_02EventResponse,CMAGTCalcBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CMAGTCalcBCImpl extends BasicCommandSupport implements CMAGTCalcBC {

	// Database Access Object
	private transient CMAGTCalcDBDAO dbDao=null;

	/**
	 * CMAGTCalcBCImpl 객체 생성<br>
	 * CMAGTCalcDBDAO를 생성한다.<br>
	 */
	public CMAGTCalcBCImpl(){
		dbDao = new CMAGTCalcDBDAO();
	}
	
	/**
	 * agt 업무 시나리오 마감작업<br>
	 * CMAGTCalc업무 시나리오 종료시 관련 내부객체 해제<br>
	 */	
	public void doEnd() {
		dbDao = null;
	}	
	
	/**
	 * Agent Commission CM Calculation 처리<br>
	 * ESM_AGT_007 배치 처리<br>
	 * 
	 * @param String receive_cd
	 * @return int(0 : 정상처리, -1 : 에러)
	 * @exception EventException
	 */
	public int createCMComm(String receive_cd) throws EventException{

		HashMap cmMap = new HashMap(); // 계산시 필요한 데이타를 담아 두는 Map.
		
		int returnNo = 0;
		
		try {

			// Booking 정보를 조회한다.
			log.info(" CMAgtCalculation START------------------");
			cmMap = dbDao.searchPrdCtlInfoforComm(receive_cd);
			if(!(cmMap.get("CM_ERROR")).equals("")){
				return returnNo;
			}
			cmMap = dbDao.searchPrdCtlQTYInfo(cmMap);
			if(!(cmMap.get("CM_ERROR")).equals("")){
				return returnNo;
			}
			cmMap = dbDao.searchPrdCtlAGTCHNAROFCInfo(cmMap);
			returnNo = dbDao.searchAccountCostbyOffice(cmMap);
			// DB 로그 테이블에 저장한다.
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
		return returnNo;
	}
}