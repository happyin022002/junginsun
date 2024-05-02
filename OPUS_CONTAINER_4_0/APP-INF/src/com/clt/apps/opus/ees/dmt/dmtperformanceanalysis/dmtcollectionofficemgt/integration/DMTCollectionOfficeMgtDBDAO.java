/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportDBDAO.java
*@FileTitle : Current Collection Status by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.CollectionOfficeFinderVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo.OfficeYardListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ChargeCollectionReportDBDAO <br>
 * - DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang HyoKeun
 * @see ChargeCollectionReportBCImpl 참조
 * @since J2EE 1.6
 */
public class DMTCollectionOfficeMgtDBDAO extends DBDAOSupport {

    /**
    * [DEM/DET Office Inquiry by Yard] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param CollectionOfficeFinderVO collectionOfficeFinderVO
    * @return List<OfficeYardListVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OfficeYardListVO> searchCollectionOfficeList ( CollectionOfficeFinderVO collectionOfficeFinderVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OfficeYardListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{

            if ( collectionOfficeFinderVO != null ) {

                Map<String, String> mapVO = collectionOfficeFinderVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
/*----------------------------------------------------------------------------------------*/                
                
                String tempDEMDETOFF = (String)collectionOfficeFinderVO.getDemdetoff();
                List<String> tempDEMDETOFFList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempDEMDETOFF, ",");
                while (st.hasMoreTokens()) {
                    tempDEMDETOFFList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempDEMDETOFFList", tempDEMDETOFFList);

            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCollectionOfficeMgtDBDAOSearchCollectionOfficeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeYardListVO .class);
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