/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAO.java
*@FileTitle : BangladeshCustomsTransmissionDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.08 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic.BangladeshManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 CustomsTransmissionDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun ChangHyun
 * @see BangladeshManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */ 
public class BangladeshManifestListDownloadDBDAO extends DBDAOSupport {

    /**
     * Inbound/Outbound 다운로드 대상 및 다운로드한 B/L 리스트 조회<br>
     * 
     * @param BangladeshManifestListCondVO manifestListCondVO
     * @return List<ManifestListDetailVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchManifestList(BangladeshManifestListCondVO manifestListCondVO) throws DAOException {
    	DBRowSet dbRowset = null;
        List<ManifestListDetailVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(manifestListCondVO != null){
	            Map<String, String> mapVO = manifestListCondVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			          
				if(manifestListCondVO.getIoFlag().equals("I")){
					if(manifestListCondVO.getDataFlag().equals("B")){
						// Inbound B/L Info List
			            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BangladeshManifestListDownloadDBDAOsearchManifestIbBlListRSQL(), param, velParam);
			            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BangladeshManifestListInboundVO.class);
					}
					else if(manifestListCondVO.getDataFlag().equals("D")){
						// Inbound D/L Info List
			            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BangladeshManifestListDownloadDBDAOsearchManifestIbDlListRSQL(), param, velParam);
			            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BangladeshManifestListInboundVO.class);
					}
				}
				else if(manifestListCondVO.getIoFlag().equals("O")){
					if(manifestListCondVO.getDataFlag().equals("B")){
						// Outbound B/L Info List
			            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BangladeshManifestListDownloadDBDAOsearchManifestObBlListRSQL(), param, velParam);
			            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BangladeshManifestListOutboundVO.class);
					}
					else if(manifestListCondVO.getDataFlag().equals("D")){
						// Outbound D/L Info List
			            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BangladeshManifestListDownloadDBDAOsearchManifestObDlListRSQL(), param, velParam);
			            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BangladeshManifestListOutboundVO.class);
					}			
				}
			}  
            
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
     * 기 다운로드 된 다 건의 Inbound Manifest 정보를 삭제한다.<br>
     * 
     * @param String vvd
     * @param String pod
     * @throws DAOException
     */
	public void removeManifestList( String vvd, String pod ) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("vvd", vvd);
            velParam.put("vvd", vvd);
            param.put("pod_code", pod);
            velParam.put("pod_code", pod);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new BangladeshManifestListDownloadDBDAOremoveManifestIbDlListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }	
	}
    
    /**
     * 기 다운로드 된 다 건의 Outbound Manifest 정보를 삭제한다.<br>
     * 
     * @param String vvd
     * @param String pol
     * @throws DAOException
     */
	public void removeObManifestList( String vvd, String pol ) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("vvd", vvd);
            velParam.put("vvd", vvd);
            param.put("pol_code", pol);
            velParam.put("pol_code", pol);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new BangladeshManifestListDownloadDBDAOremoveManifestOutDlListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }	
	}

    /**
     * 다운로드 할 다 건의 Inbound Manifest 정보를 등록한다.<br>
     * 
     * @param List<BangladeshManifestListInboundVO> insertVoList
     * @throws DAOException
     */
	public void addManifestList(List<BangladeshManifestListInboundVO> insertVoList) throws DAOException,Exception {
        int addCnt[] = null;
        
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new BangladeshManifestListDownloadDBDAOaddManifestIbDlListCSQL(), insertVoList, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }		
	}
	
    /**
     * 다운로드 할 다 건의 Outbound Manifest 정보를 등록한다.<br>
     * 
     * @param List<BangladeshManifestListOutboundVO> insertVoList
     * @throws DAOException
     */
	public void addObManifestList(List<BangladeshManifestListOutboundVO> insertVoList) throws DAOException,Exception {
        int addCnt[] = null;
        
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new BangladeshManifestListDownloadDBDAOaddManifestOutDlListCSQL(), insertVoList, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }		
	}
    
}