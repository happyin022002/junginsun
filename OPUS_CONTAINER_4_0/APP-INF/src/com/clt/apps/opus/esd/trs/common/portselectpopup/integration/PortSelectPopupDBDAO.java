/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSelectPopupDBDAO.java
*@FileTitle : PortSelectPopupDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.portselectpopup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.portselectpopup.vo.PortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCountryVO;

/**
 * NIS2010 VSKCodeFinderDAO <br>
 * - NIS2010-VSKCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see PortSelectPopupBCImpl 참조
 * @since J2EE 1.4
 */
public class PortSelectPopupDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 116077188562110775L;

	/**
	 * MDM에서 Port 정보를 조회합니다.
	 * 
	 * @param PortVO portVO
	 * @return List<PortVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PortVO> searchPortList(PortVO portVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portVO != null){
				Map<String, String> mapVO = portVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSelectPopupDBDAOPortListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PortVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MdmCountryVO> searchCountryList(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cntCd != null){
				param.put("cnt_cd", cntCd);
				velParam.put("cnt_cd", cntCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PortSelectPopupDBDAOMdmCountryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}		
}
