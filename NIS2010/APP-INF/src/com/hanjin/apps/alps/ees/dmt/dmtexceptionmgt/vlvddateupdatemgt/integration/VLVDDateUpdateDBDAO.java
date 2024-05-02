/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDDateUpdateDBDAO.java
*@FileTitle : VL/VD Date Update by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김재진
*@LastVersion : 1.0
* 2009.08.26 김재진
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.basic.TimeClockStopMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.DmtVesselDateUpdateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo.VslDtUpdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * APLS VLVDDateUpdateDBDAO <br>
 * - APLS-DMTExceptionMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jae Jin
 * @see TimeClockStopMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class VLVDDateUpdateDBDAO extends DBDAOSupport {

    /**
    * [VL/VD DATE UPDATE 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO
    * @return List<VslDtUpdListVO>
    * @throws DAOException
    */
	@SuppressWarnings("unchecked")
	public List<VslDtUpdListVO> searchVLVDByVVDList ( DmtVesselDateUpdateParmVO dmtVesselDateUpdateParmVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslDtUpdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dmtVesselDateUpdateParmVO != null){
				Map<String, String> mapVO = dmtVesselDateUpdateParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new VLVDDateUpdateDBDAOSearchVLVDByVVDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslDtUpdListVO .class);
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
    * [VVD 존재여부] 정보를 [Search] 합니다.<br>
    * 
    * @param String vvd
    * @param String xMvmt
    * @param String xPort
    * @return List<VslDtUpdListVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<VslDtUpdListVO> checkVvdIsExist ( String vvd , String xMvmt , String xPort, String clptIndSeq ) throws DAOException {
        DBRowSet dbRowset = null;
        List<VslDtUpdListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            param.put( "vvd"   , vvd   );
            param.put( "xMvmt" , xMvmt );
            param.put( "xPort" , xPort );
            param.put( "clpt_ind_seq"  , clptIndSeq    );
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new VLVDDateUpdateDBDAOCheckExistVvdRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslDtUpdListVO .class);
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
    * [VL/VD Date] 정보를 [Insert by VVD] 합니다.<br>
    * 
    * @param String xMvmt
    * @param String xPort
    * @param String vvd
    * @param String vldaten
    * @param String vldateb
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String addDateByVvdCd( String xMvmt , String xPort , String vvd , String vldaten , String vldateb , SignOnUserAccount account, String clptIndSeq) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;

        try{

            param.put( "vvd"     , vvd                 );
            param.put( "xMvmt"   , xMvmt               );
            param.put( "xPort"   , xPort               );
            param.put( "vldaten" , vldaten             );
            param.put( "vldateb" , vldateb             );
            param.put( "userid"  , account.getUsr_id() );
            param.put( "offccd"  , account.getOfc_cd() );
            param.put( "clpt_ind_seq"  , clptIndSeq    );
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new VLVDDateUpdateDBDAOInsertVLVDDateByVVDCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to INSERT VVD SQL ["+vvd+"]");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [VL/VD Date] 정보를 [Update by VVD] 합니다.<br>
    * 
    * @param String xMvmt
    * @param String xPort
    * @param String vvd
    * @param String vldaten
    * @param String vldateb
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String modifyDateByVvdCd( String xMvmt , String xPort , String vvd , String vldaten , String vldateb , SignOnUserAccount account, String clptIndSeq) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;

        try{

            param.put( "vvd"     , vvd                 );
            param.put( "xMvmt"   , xMvmt               );
            param.put( "xPort"   , xPort               );
            param.put( "vldaten" , vldaten             );
            param.put( "vldateb" , vldateb             );
            param.put( "userid"  , account.getUsr_id() );
            param.put( "offccd"  , account.getOfc_cd() );
            param.put( "clpt_ind_seq"  , clptIndSeq    );
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new VLVDDateUpdateDBDAOUpdateVLVDDateByVVDUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to UPDATE VVD SQL ["+vvd+"]");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
}
