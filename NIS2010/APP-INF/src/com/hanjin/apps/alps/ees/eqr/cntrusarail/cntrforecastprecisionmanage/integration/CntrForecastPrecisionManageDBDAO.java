/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAO.java
*@FileTitle : MTY Rail Arrival Inquiry
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.		Ver.	Modifier		Modifier Date		Explanation
*-----------------------------------------------------------------------------
*					chae chang ho	2007-11-13			CSR No : R200711054305 - Based on  1st Week와 4 weeks Ago 로 반영 (현재는 4주전 Forcast와 실적 비교)
*					chae chang ho	2008-05-19			Project_name :신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록
* 					Haeng-ji, Lee   2009-05-18			CSR No : R200905150001 - 컨테이너 타입사이즈 조건을 All, Dry 이외의 항목으로 조회했을 때의 에러수정
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrusarail.cntrforecastprecisionmanage.vo.MtyRailDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrForecastPrecisionManageDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see CntrForecastPrecisionManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrForecastPrecisionManageDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5286258241547689347L;

	/**
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailArrival(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
				
				String tpszText =  Utils.convertStr(mtyRailConditionVO.getTpsztype());
				ArrayList<Integer> arrday = new ArrayList<Integer>();
				int diff_date = Integer.parseInt(mtyRailConditionVO.getDiffDate());
				
				for( int i=0; i <= diff_date; i++){
					arrday.add(i);
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
				velParam.put("arrday", arrday);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailArrivalUSTime() throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String usTime ="";
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL(), param, velParam);
			if(dbRowset.next()){
			usTime =dbRowset.getString("CURRENT_TIME").trim();
			}
			commonRsVO.setResultString(usTime);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	/**
	 * [EES_EQR_0142 : MTY Rail Trans Result }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailResult(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
			
				List<String> arrtpsz = Utils.replaceStrToList(mtyRailConditionVO.getTpsztype());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return List<MtyRailDetailVO>
	 * @exception DAOException
	 */
	public List<MtyRailDetailVO> searchMtyRailArrivalDetail(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRailDetailVO> list = new ArrayList<MtyRailDetailVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO.getColumnValues();
				
				String tpszText =  Utils.convertStr(mtyRailConditionVO.getTpsztype());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRailDetailVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [EES_EQR_0142 : MTY Rail Trans Result }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public List<MtyRailDetailVO> searchMtyRailResultDetail(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRailDetailVO> list = new ArrayList<MtyRailDetailVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
			
				List<String> arrtpsz = Utils.replaceStrToList(mtyRailConditionVO.getTpsztype());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailResultDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRailDetailVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) { 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
}