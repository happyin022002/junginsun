/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceProviderRelationshipSegmentationResultDBDAO.java
*@FileTitle : SRS Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.08.06 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.integration.ServiceProviderRelationshipAttractivenessResultDBDAOSearchAttractivenessResultRSQL;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo.SearchInputListVO;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.basic.ServiceProviderRelationshipSegmentationResultBCImpl;
import com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.vo.SearchServiceProviderRelationshipSegmentationResultListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ServiceProviderRelationshipSegmentationResultDBDAO <br>
 * - ALPS-ServiceProviderResultManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kown Jeong hwa
 * @see ServiceProviderRelationshipSegmentationResultBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ServiceProviderRelationshipSegmentationResultDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchServiceProviderRelationshipSegmentationResultListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchServiceProviderRelationshipSegmentationResultListVO> searchServiceProviderRelationshipSegmentationResultList(SearchInputListVO searchInputListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchServiceProviderRelationshipSegmentationResultListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchInputListVO != null){
				Map<String, String> mapVO = searchInputListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ServiceProviderRelationshipAttractivenessResultDBDAOSearchAttractivenessResultRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchServiceProviderRelationshipSegmentationResultListVO .class);
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