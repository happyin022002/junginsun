package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.vo.MdmVendorInfoVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRComApFileUpldVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

public class ServiceProviderManageDBDAO extends DBDAOSupport {

	/**
	 * searchMdmVendorInfo 값을 불러온다.<br>
	 *
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMdmVendorInfo(MdmVendorInfoVO model) throws DAOException {
		
		DBRowSet	dbRowset		= null;
		
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderManageDBDAOSearchMdmVendorInfoRSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}				
		return dbRowset;
	}
	
	/**
	 * searchMdmVendorIndiaInfo 값을 불러온다.<br>
	 *
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMdmVendorIndiaInfo(String vndrSeq) throws DAOException {
		
		DBRowSet	dbRowset		= null;
		
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		try {			
			if ( vndrSeq != null && !vndrSeq.equals("")) {
				param.put("vndr_seq", vndrSeq);
				velParam.put("vndr_seq", vndrSeq);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderManageDBDAOSearchMdmVendorIndiaInfoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}				
		return dbRowset;
	}
	
	/**
	 * MdmVendor India Info 값을 수정한다.<br>
	 *
	 * @exception DAOException
	 */
	public void modifyMdmVendorIndiaInfo(MdmVendorInfoVO model) throws DAOException {
		
		//query parameter
		Map<String, Object>	param			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object>	velParam		= new HashMap<String, Object>();
		
		int updCnt = 0;
		
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			//India info update
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ServiceProviderManageDBDAOModifyMdmVendorInfoUSQL(), param, velParam);
			
			//India mail info update
			if(updCnt > 0)
				new SQLExecuter("").executeUpdate((ISQLTemplate)new ServiceProviderManageDBDAOModifyMdmVendorCntcPntUSQL(), param, velParam);
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}	
	}

}
