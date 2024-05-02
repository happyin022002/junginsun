/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTFindCodeBC.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic;

import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.CustomVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
/**
 * ALPS-Totcommon Business Logic Command Interface<br>
 * - ALPS-Totcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Chang Soo
 * @see TotcommonEventResponse 참조
 * @since J2EE 1.6
 */

public interface TOTFindCodeBC {
	
	/**
	 * 해당년월의 마감여부를 조회한다 <br>
	 * 
	 * @param String isYear
	 * @return List<TotStlClzVO>
	 * @exception EventException
	 */	
	public List<TotStlClzVO> checkSettlementClosing(String isYear) throws EventException;

	/**
	 * 해당 선박코드의 vessel name 과 계약일자 데이터를 조회한다. <br>
	 * 
	 * @param VslVO vslVO
	 * @return List<VslVO>
	 * @exception EventException
	 */	
	public List<VslVO> searchFmsVslInfo(VslVO vslVO) throws EventException; 

	/**
	 * lane에 해당하는 trade code를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 	
	public List<TotCodeInfoVO> searchTrdCodeByLaneList(TotCodeParamVO totCodeParamVO) throws EventException;
*/
	/**
	 * 해당하는 trade code를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchTradeCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	/**
	 * 해당 lane 존재여부를 체크한다. <br>
	 * 
	 * @param MdmLaneVO mdmLaneVO
	 * @return List<MdmLaneVO>
	 * @exception EventException
	 */	
	public List<MdmLaneVO> searchLaneCheckList(MdmLaneVO mdmLaneVO) throws EventException;

	/**
	 * pendlum lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchPLaneCodeList(TotCodeParamVO totCodeParamVO) throws EventException;
	
	/**
	 * pendlum lane에 해당하는 trade를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchPLaneTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	/**
	 * pendlum lane에 해당하는 trade를 조회한다. 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @throws EventException
	 */
	public List<TotCodeInfoVO> searchPLaneDistinctTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	/**
	 * BSA lane을 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchBsaLaneCodeList(TotCodeParamVO totCodeParamVO) throws EventException;
	
	/**
	 * BSA lane에 해당하는 trade를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchBsaTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	
	/**
	 * 해당 시작일자 종료일자 lane, dir_cd 에 해당하는 port조회한다. <br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */	
	public List<TotCodeInfoVO> searchPortCodeList(VskVslPortSkdVO vskVslPortSkdVO) throws EventException;

	
	/**
	 * BSA Trade code 조회한다.
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @throws EventException
	 */
	public List<TotCodeInfoVO> searchBSATradeCodeList(TotCodeParamVO totCodeParamVO) throws EventException;


	/**
	 * tot lane에 해당하는 lane과 TRADE를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	/**
	 * tot lane에 해당하는 TRADE를 조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneDistinctTrdCodeList(TotCodeParamVO totCodeParamVO) throws EventException;

	/**
	 * trade에 해당하는 lane을  조회한다. <br>
	 * 
	 * @param TotCodeParamVO totCodeParamVO
	 * @return List<TotCodeInfoVO>
	 * @exception EventException
	 */
	public List<TotCodeInfoVO> searchTotLaneByTrdList(TotCodeParamVO totCodeParamVO) throws EventException;

	
	/**
	 * 공통코드를 가지고 있는 데이터에 한해 해당코드를 넘겨주면 해당코드의 리스트를 조회한다.. <br>
	 * 
	 * @param String code
	 * @return CustomVO
	 * @exception EventException
	 */	
	public CustomVO searchComboCodeList(String code)  throws EventException;

	/**
	 * BSA Creation back end job return 데이터를 조회한다. <br>
	 * 
	 * @param String backEndJobKey
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchCreationByBackEndJobStatus(String backEndJobKey) throws EventException;

		
}