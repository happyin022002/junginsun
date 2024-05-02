/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBC.java
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

import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.CommonComboSetVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.SearchDayListVO;
import com.hanjin.apps.alps.ees.cim.cimcommon.cimcommon.vo.TypeSizeSequenceVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Cntroperationperformancemgt Business Logic Command Interface<br>
 * - ALPS-Cntroperationperformancemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Prak Kwang Seok
 * @see Ui_cim_1001EventResponse 참조
 * @since J2EE 1.4
 */

public interface CIMCommonBC {
	/**
	 * TPSZSequence의 List를 조회 합니다. <br>
	 * 
	 * @return List<TypeSizeSequenceVO>
	 * @exception EventException
	 */
	public List<TypeSizeSequenceVO> searchTPSZSequenceList() throws EventException;

	/**
	 * Day의 List를 조회 합니다. <br>
	 * 
	 * @return List<SearchDayListVO>
	 * @exception EventException
	 */
	public List<SearchDayListVO> searchDayList() throws EventException;
	
	/**
	 * Location을 check  합니다. <br>
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException;
	
	/**
	 * VVD를 check  합니다. <br>
	 * 
	 * @param vvd
	 * @return String
	 * @exception EventException
	 */
	public String checkVVD(String vvd) throws EventException;
	
	

	/**
	 * Port List를 조회 합니다. <br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortList() throws EventException;	
	
	/**
	 * trade에 해당하는 Lane List를 조회 합니다. <br>
	 * 
	 * @param trade
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchLaneList(String trade) throws EventException;	
	
	/**
	 * trade에 해당하는 Sub Trade List를 조회 합니다. <br>
	 * 
	 * @param trade
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSubTradeList(String trade) throws EventException;	
	
	
	/**
	 * 입력받은 lane Code Validation Check<br>
	 * 
	 * @param lane
	 * @return String
	 * @exception EventException
	 */
	public String checkLane(String lane) throws EventException;

	
	/**
	 * Rcc List를 조회 합니다. <br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchRCCList() throws EventException;		
	
	/**
	 * PortTurnTime화면에 있는 COMBO List를 조회 합니다. <br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchPortTurnTimeCombo() throws EventException;	
	
	
	/**
	 * CntrTypeSize List를 조회합니다.<br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCntrTypeSizeList() throws EventException;		
	
	
	/**
	 * Trade List를 조회합니다.<br>
	 * 
	 * @return String[]
	 * @exception EventException
	 */ 
	public String[] searchTradeList() throws EventException;	
	
	/**
	 * AroundTurnTime화면에 있는 Combo를 조회 합니다.<br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchAroundTurnTimeCombo() throws EventException;	
	
	
	/**
	 * REPOResultByPort화면에 있는 Combo를 조회 합니다.<br>
	 * 
	 * @return CommonComboSetVO
	 * @exception EventException
	 */
	public CommonComboSetVO searchREPOResultByPortCombo() throws EventException;	
	

	
	
}