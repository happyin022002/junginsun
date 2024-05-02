/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAO.java
*@FileTitle : ChinaManifestListDownloadDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
* 
* 2011.06.16 민정호 [CHM-201111127] Split 03-Split 08-ALPS Error 처리 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaVslRgstVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChnBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCstmsChnAwkVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnDgCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnMkVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnRfVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnVvdVO;
import com.hanjin.syscommon.common.table.BkgCstmsSealNoVO;


/**
 * NIS2010 ManifestListDownloadDBDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Subin
 * @see ChinaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class ChinaManifestListDownloadDBDAO extends DBDAOSupport {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 다운로드 대상 Vessel 정보 조회<br>
     * 
     * @param ChinaManifestListCondVO manifestListCondVO 
     * @return BkgCstmsChnVvdVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public BkgCstmsChnVvdVO searchVvdInfo(ChinaManifestListCondVO manifestListCondVO) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnVvdVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(manifestListCondVO != null){
	            Map<String, String> mapVO = manifestListCondVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}            
			// Vessel Info
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchVvdInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnVvdVO.class);
            
            if(list.size()>0){
                return list.get(0);
            }else{
            	return null;
            }           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    
    /**
     * 다운로드 대상 B/L 리스트 조회<br>
     * 
     * @param ChinaManifestListCondVO manifestListCondVO 
     * @return List<ChinaManifestListDetailVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchManifestList(ChinaManifestListCondVO manifestListCondVO) throws DAOException {
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
			}            
			// Booking Info List
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchManifestListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaManifestListDetailVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    
    /**
     * 다운로드 대상 B/L 리스트 데이터 갯수 조회 - CSV 저장용<br>
     * 
     * @param ChinaManifestListCondVO manifestListCondVO 
     * @return String
     * @exception DAOException
     */
	public String searchManifestDetailListCount(ChinaManifestListCondVO manifestListCondVO) throws DAOException {
    	DBRowSet dbRowset = null;
        String total = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(manifestListCondVO != null){
	            Map<String, String> mapVO = manifestListCondVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}  
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchManifestList2RSQL(), param, velParam);
            if(dbRowset.next()) {
            	total = Integer.toString(dbRowset.getInt(1));
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return total;
    }
    
    
    /**
     * 다운로드 대상 B/L 리스트 조회 - CSV 저장용<br>
     * 
     * @param ChinaManifestListCondVO manifestListCondVO 
     * @return List<ManifestListDetailVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchManifestDetailList(ChinaManifestListCondVO manifestListCondVO) throws DAOException {
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
			}            
			// Booking Info List
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchManifestDetailListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaManifestDetailListVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * 다운로드 대상 VSL Info 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<ChinaVslInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnVvdVO> searchVslInfoList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnVvdVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);   

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}         
             
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchVslInfoListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnVvdVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * 기 다운로드 된 다 건의 Vessel 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeVslInfoList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            String strBkgNo = null;
			List<String> arrString = new ArrayList();  //BKG_NO
			for (int i=0; i<blKeyVOs.size(); i++) {	
				strBkgNo = blKeyVOs.get(i).getBkgNo();
				arrString.add(strBkgNo);
			}
			velParam.put("field_list", arrString);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveVslInfoListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 기 다운로드 된 다 건의 Vessel 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnVvdVO> bkgCstmsChnVvdVOs 
     * @exception DAOException
     */
    public void addVslInfoList ( List<BkgCstmsChnVvdVO> bkgCstmsChnVvdVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddVslInfoListCSQL(), bkgCstmsChnVvdVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 다운로드 대상 VSL Info 조회<br>
     * 
     * @param ChnBlKeyVO blKeyVO
     * @return ChinaVslInfoVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public BkgCstmsChnVvdVO searchVslInfo(ChnBlKeyVO blKeyVO) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnVvdVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVO != null){
	            Map<String, String> mapVO = blKeyVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchVslInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnVvdVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list.get(0);
    }

    /**
     * 기 다운로드 된 한 건의 Vessel 정보를 삭제한다.<br>
     * 
     * @param ChnBlKeyVO blKeyVO 
     * @param String transMode 
     * @exception DAOException
     */
    public void removeCncusVslInfo ( ChnBlKeyVO blKeyVO, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveCncusVslInfoDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 기 다운로드 된 한 건의 Vessel 정보를 등록한다.<br>
     * 
     * @param BkgCstmsChnVvdVO bkgCstmsChnVvdVO 
     * @exception DAOException
     */
    public void addVslInfo ( BkgCstmsChnVvdVO bkgCstmsChnVvdVO ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnVvdVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddVslInfoListCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 다운로드 대상 B/L 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnBlVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnBlVO> searchBlList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnBlVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchBlListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnBlVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * 다운로드 대상 B/L 의 PodRoutDesc 조회<br>
     * 
     * @param BkgCstmsChnBlVO bkgCstmsChnBlVO 
     * @return String
     * @exception DAOException
     */
	public String searchPodRoutDesc(BkgCstmsChnBlVO bkgCstmsChnBlVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	String podRoutDesc = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{      
            Map<String, String> mapVO = bkgCstmsChnBlVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchPodRoutDescRSQL(), param, velParam);
            if(dbRowset.next()){
            	podRoutDesc = dbRowset.getString(1);
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return podRoutDesc;
    }
    
    /**
     * 기 다운로드 된 다 건의 B/L 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 기 다운로드 된 건의 History 정보 입력 위해 기 입력정보 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @param String UsrId 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlDlHis ( List<ChnBlKeyVO> blKeyVOs, String transMode, String UsrId ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
             param.put("vvd", blKeyVOs.get(0).getVvd());
             param.put("usr_id", UsrId);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlDlHisDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 B/L 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnBlVO> bkgCstmsChnBlVOs 
     * @exception DAOException
     */
    public void addBlList ( List<BkgCstmsChnBlVO> bkgCstmsChnBlVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlListCSQL(), bkgCstmsChnBlVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 기 다운로드 된 다 건의 B/L 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnBlVO> bkgCstmsChnBlVOs 
     * @exception DAOException
     */
    public void addBlDlHis ( List<BkgCstmsChnBlVO> bkgCstmsChnBlVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlDlHisCSQL(), bkgCstmsChnBlVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * 다운로드 대상 Customer 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnCustVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnCustVO> searchBlCustList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnCustVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchBlCustListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnCustVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Customer 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCustList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCustListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Customer 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnCustVO> bkgCstmsChnCustVOs 
     * @exception DAOException
     */
    public void addBlCustList ( List<BkgCstmsChnCustVO> bkgCstmsChnCustVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCustListCSQL(), bkgCstmsChnCustVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * 다운로드 대상 Container 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnCntrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnCntrVO> searchBkgCntr(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnCntrVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchBkgCntrRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnCntrVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Container 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCntrList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 기 다운로드 된 다 건의 Container 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs 
     * @exception DAOException
     */
    public void addBlCntrList ( List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrListCSQL(), bkgCstmsChnCntrVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
     * 다운로드 대상 Container Seal No. 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsSealNoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsSealNoVO> searchBkgCntrSealNo(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsSealNoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchBkgCntrSealNoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsSealNoVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Container Seal No. 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCntrSealNoList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
             param.put("cnt_cd", CountryCode.CN);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrSealNoListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Container Seal No. 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs 
     * @exception DAOException
     */
    public void addBlCntrSealNoList ( List<BkgCstmsSealNoVO> bkgCstmsSealNoVOs ) throws DAOException {
        BkgCstmsSealNoVO bkgCstmsSealNoVO = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try{
        	/*
            SQLExecuter sqlExe = new SQLExecuter("");
            addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL(), bkgCstmsSealNoVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			} 
			*/       
			
        	for(int i = 0; i < bkgCstmsSealNoVOs.size(); i++) {
            	
        		bkgCstmsSealNoVO = bkgCstmsSealNoVOs.get(i);
	        	
        		if(bkgCstmsSealNoVO != null) {
        			
		        	String cntrTpszCd = bkgCstmsSealNoVO.getCntrTpszCd();
		        	String bkgCgoTpCd = bkgCstmsSealNoVO.getBkgCgoTpCd();
		        	
		        	if(cntrTpszCd.startsWith("F") || cntrTpszCd.startsWith("A") || bkgCgoTpCd.equals("R") || bkgCgoTpCd.equals("P") ) {
		        		bkgCstmsSealNoVO.setSealNo("0000");
		        		bkgCstmsSealNoVO.setSealPtyTpCd("AB");
		        		bkgCstmsSealNoVO.setSealKndCd("M");
		        	
		        	} else if(cntrTpszCd.startsWith("T")) {
		        		if(!checkNumberInclude(bkgCstmsSealNoVO.getSealNo())) bkgCstmsSealNoVO.setSealNo("0000");
		        		if(bkgCstmsSealNoVO.getSealPtyTpCd().equals("")) bkgCstmsSealNoVO.setSealPtyTpCd("AB");
		        		if(bkgCstmsSealNoVO.getSealKndCd().equals("")) bkgCstmsSealNoVO.setSealKndCd("M");
		        	}
	        	
		            Map<String, String> mapVO = bkgCstmsSealNoVO.getColumnValues();
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddBlCntrSealNoListCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
        	} // end for(i)
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    public static boolean checkNumberInclude(final String str) {                

        if(str == null || str.isEmpty()) return false;

        boolean found = false;
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                found = true;
                break;    
            }
        }

        return found;
    }
    
    public boolean CheckNumber(String str){

		 char check;

		

		 if(str.equals(""))

		 {

			 //문자열이 공백인지 확인

			 return false;

		 }

		

		 for(int i = 0; i<str.length(); i++){

			 check = str.charAt(i);

			 if( check < 48 || check > 58)

			 {

				 //해당 char값이 숫자가 아닐 경우

				 return false;

			 }

			

		 }		

		 return true;

	 }

    
    /**
     * 다운로드 대상 Danger Cargo 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnDgCgoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnDgCgoVO> searchCntrDgList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnDgCgoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchCntrDgListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnDgCgoVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Danger Cargo 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCntrDgList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrDgListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Danger Cargo 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnDgCgoVO> bkgCstmsChnDgCgoVOs 
     * @exception DAOException
     */
    public void addBlCntrDgList ( List<BkgCstmsChnDgCgoVO> bkgCstmsChnDgCgoVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrDgListCSQL(), bkgCstmsChnDgCgoVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * 다운로드 대상 Awkward 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnAwkVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnAwkVO> searchCntrAkList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnAwkVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchCntrAkListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnAwkVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Awkward 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCntrAkList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrAkListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Awkward 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnAwkVO> bkgCstmsChnAwkVOs 
     * @exception DAOException
     */
    public void addBlCntrAkList ( List<BkgCstmsChnAwkVO> bkgCstmsChnAwkVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrAkListCSQL(), bkgCstmsChnAwkVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * 다운로드 대상 Reefer Cargo 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnRfVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnRfVO> searchCntrRfList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnRfVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchCntrRfListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnRfVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Reefer Cargo 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlCntrRfList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrRfListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Reefer Cargo 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnRfVO> bkgCstmsChnRfVOs 
     * @exception DAOException
     */
    public void addBlCntrRfList ( List<BkgCstmsChnRfVO> bkgCstmsChnRfVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrRfListCSQL(), bkgCstmsChnRfVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    
    /**
     * 다운로드 대상 Mark Desc 리스트 조회<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @return List<BkgCstmsChnMkVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public List<BkgCstmsChnMkVO> searchBlMdList(List<ChnBlKeyVO> blKeyVOs) throws DAOException {
    	DBRowSet dbRowset = null;
        List<BkgCstmsChnMkVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(blKeyVOs != null){
	            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            String strBkgNo = null;
				List<String> arrString = new ArrayList();  //BKG_NO
				for (int i=0; i<blKeyVOs.size(); i++) {	
					strBkgNo = blKeyVOs.get(i).getBkgNo();
					arrString.add(strBkgNo);
				}
				velParam.put("field_list", arrString);
			}            
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchBlMdListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnMkVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }


    /**
     * 기 다운로드 된 다 건의 Mark Desc 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void removeBlMdList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<blKeyVOs.size(); i++) {	
				 strBlNo = blKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
             param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlMdListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 기 다운로드 된 다 건의 Mark Desc 정보를 등록한다.<br>
     * 
     * @param List<BkgCstmsChnMkVO> bkgCstmsChnMkVOs 
     * @exception DAOException
     */
    public void addBlMdList ( List<BkgCstmsChnMkVO> bkgCstmsChnMkVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlMdListCSQL(), bkgCstmsChnMkVOs, null);

			for (int i = 0; i < addCnt.length; i++) {
				if (addCnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}          
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 세관용 Container Seal No. 정보를 수정한다.<br>
     * 
     * @param BkgCstmsSealNoVO bkgCstmsSealNoVO 
     * @return Integer
     * @exception DAOException
     */
    public int modifyBlCntrSeal ( BkgCstmsSealNoVO bkgCstmsSealNoVO ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsSealNoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBlCntrSealUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
            return result;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 Container Seal No. 정보를 생성한다.<br>
     * 
     * @param BkgCstmsSealNoVO bkgCstmsSealNoVO 
     * @exception DAOException
     */
    public void addBlCntrSeal ( BkgCstmsSealNoVO bkgCstmsSealNoVO ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsSealNoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddBlCntrSealCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 B/L 정보를 수정한다.<br>
     * 
     * @param BkgCstmsChnBlVO bkgCstmsChnBlVO 
     * @exception DAOException
     */
    public void modifyBlGeneral ( BkgCstmsChnBlVO bkgCstmsChnBlVO ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnBlVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBlGeneralUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 Reefer 정보를 수정한다.<br>
     * 
     * @param BkgCstmsChnRfVO bkgCstmsChnRfVO 
     * @exception DAOException
     */
    public void modifyBlReeferCntr ( BkgCstmsChnRfVO bkgCstmsChnRfVO ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnRfVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBlReeferCntrUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 B/L Mark&Desc 정보를 생성한다.<br>
     * 
     * @param BkgCstmsChnMkVO bkgCstmsChnMkVO 
     * @exception DAOException
     */
    public void addBlMarkDesc ( BkgCstmsChnMkVO bkgCstmsChnMkVO ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnMkVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddBlMarkDescCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 Container 정보를 생성한다.<br>
     * 
     * @param List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs 
     * @exception DAOException
     */
    public void addBlCntr ( List<BkgCstmsChnCntrVO> bkgCstmsChnCntrVOs ) throws DAOException {
        int addCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
			addCnt = sqlExe.executeBatch((ISQLTemplate) new ChinaManifestListDownloadDBDAOaddBlCntrCSQL(), bkgCstmsChnCntrVOs, null);

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
     * 세관용 Awkard Container 정보를 생성한다.<br>
     * 
     * @param BkgCstmsChnAwkVO bkgCstmsChnAwkVO 
     * @exception DAOException
     */
    public void addBlAwkardCntr ( BkgCstmsChnAwkVO bkgCstmsChnAwkVO ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnAwkVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddBlAwkardCntrCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * 세관용 B/L Customer 정보를 수정한다.<br>
     * 
     * @param BkgCstmsChnCustVO bkgCstmsChnCustVO 
     * @exception DAOException
     */
    public void modifyBlCust ( BkgCstmsChnCustVO bkgCstmsChnCustVO ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnCustVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBlCustUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * B/L No 로 세관용 Danger Container 정보를 생성한다.<br>
     * 
     * @param BkgCstmsChnDgCgoVO bkgCstmsChnDgCgoVO 
     * @exception DAOException
     */
    public void addBlDangerCntr ( BkgCstmsChnDgCgoVO bkgCstmsChnDgCgoVO ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = bkgCstmsChnDgCgoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddBlDangerCntrCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * 세관용 B/L 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlGeneral ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlGeneralDSQL(), param, velParam);
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
     * 세관용 Awkard Container 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlAwkardCntr ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlAwkardCntrDSQL(), param, velParam);
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
     * 세관용 Container 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlCntr ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrDSQL(), param, velParam);
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
     * 세관용 Customer 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlCust ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCustDSQL(), param, velParam);
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
     * B/L No 로 세관용 Danger Container 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlDangerCntr ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlDangerCntrDSQL(), param, velParam);
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
     * 세관용 Reefer 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlReeferCntr ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlReeferCntrDSQL(), param, velParam);
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
     * 세관용 B/L Mark&Desc 정보를 삭제한다.<br>
     * 
	 * @param String blNo 
	 * @param String transMode 
     * @exception DAOException
     */
	public void removeBlMarkDesc ( String blNo, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("bl_no", blNo);
            param.put("trans_mode", transMode);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlMarkDescDSQL(), param, velParam);
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
     * B/L 정보를 수정한다.<br>
     * 
     * @param List<TransKeyVO> transKeyVOs 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void modifyBl ( List<TransKeyVO> transKeyVOs ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<transKeyVOs.size(); i++) {	
				 strBlNo = transKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
				 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBlUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * B/L 테이블에 전송 내역 데이터를 업데이트한다.<br>
     * 
     * @param List<TransKeyVO> transKeyVOs 
     * @param String pol 
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void modifyBl2 ( List<TransKeyVO> transKeyVOs, String pol ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("send_date", transKeyVOs.get(0).getSendDate());
            param.put("usr_id", transKeyVOs.get(0).getUsrId());
            param.put("trans_mode", transKeyVOs.get(0).getTransMode());
            param.put("vvd", transKeyVOs.get(0).getVvd());
            param.put("pol", pol);
            
             String strBlNo = null;
			 List<String> arrString = new ArrayList();  //BL_NO
			 for (int i=0; i<transKeyVOs.size(); i++) {	
				 strBlNo = transKeyVOs.get(i).getBlNo();
				 arrString.add(strBlNo);
			 }
			 velParam.put("field_list", arrString);
	         velParam.put("trans_mode", transKeyVOs.get(0).getTransMode());
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyBl2USQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * VVD 테이블에 전송 내역 데이터를 업데이트한다.<br>
     * 
     * @param TransKeyVO transKeyVO 
     * @param String pol 
     * @exception DAOException
     */
    public void modifyVvd ( TransKeyVO transKeyVO, String pol ) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = transKeyVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            param.put("pol", pol);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyVvdUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to update SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * 세관용 Awkard Container 정보 생성여부를 조사한다.<br>
     * 
     * @param BkgCstmsChnAwkVO bkgCstmsChnAwkVO 
     * @return Integer
     * @exception DAOException
     */
	public int searchPKBlAwkardCntr(BkgCstmsChnAwkVO bkgCstmsChnAwkVO) throws DAOException {
    	DBRowSet dbRowset = null;
        int cnt = 0;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(bkgCstmsChnAwkVO != null){
	            Map<String, String> mapVO = bkgCstmsChnAwkVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}  
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchPKBlAwkardCntrRSQL(), param, velParam);
            if(dbRowset.next()) {
            	cnt = dbRowset.getInt(1);
            }            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }
	
    /**
     * 기 다운로드 된 다 건의 BL 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
	public void removeBlAllList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlAllListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
    /**
     * 기 다운로드 된 다 건의 Customer 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
	public void removeBlCustAllList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
           
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCustAllListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
	
    /**
     * 기 다운로드 된 다 건의 CNTR 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
	public void removeBlCntrAllList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
      
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrAllListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
	
    /**
     * 기 다운로드 된 다 건의 Seal 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
	public void removeBlCntrSealNoAllList ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            param.put("cnt_cd", CountryCode.CN);
            velParam.putAll(mapVO);            
           
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlCntrSealNoAllListDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }	
	
    /**
     * 기 다운로드 된 다 건의 BLMD 정보를 삭제한다.<br>
     * 
     * @param List<ChnBlKeyVO> blKeyVOs 
     * @param String transMode 
     * @exception DAOException
     */
	public void removeBlMdList2 ( List<ChnBlKeyVO> blKeyVOs, String transMode ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = blKeyVOs.get(0).getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveBlMdList2DSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to delete SQL");
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	/**
	 * Vessel Registration (from VSK_VSL_PORT_SKD) 목록 조회<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @return List<VslRgstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaVslRgstVO> searchVslRgstFromVskPortSkd(ChinaVslRgstVO chinaVslRgstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaVslRgstVO != null) {
				Map<String, String> mapVO = chinaVslRgstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchVslRgstFromVskPortSkdRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaVslRgstVO.class);
		} catch(SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Registration (from BKG_CSTMS_CHN_CORR_VVD) 목록 조회<br>
	 *
	 * @param ChinaVslRgstVO chinaVslRgstVO
	 * @return List<VslRgstVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChinaVslRgstVO> searchVslRgstFromChnCorrVvd(ChinaVslRgstVO chinaVslRgstVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (chinaVslRgstVO != null) {
				Map<String, String> mapVO = chinaVslRgstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChinaManifestListDownloadDBDAOsearchVslRgstFromChnCorrVvdRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ChinaVslRgstVO.class);
		} catch(SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Registration 목록 신규 저장<br>
	 *
	 * @param List<ChinaVslRgstVO> chinaVslRgstVOList
	 * @exception DAOException, Exception
	 */
	public void addChinaVslRgst(List<ChinaVslRgstVO> chinaVslRgstVOList) throws DAOException, Exception {
		try {
			if (chinaVslRgstVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new ChinaManifestListDownloadDBDAOaddVslRgstCSQL(), chinaVslRgstVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Registration 목록 수정 저장<br>
	 *
	 * @param List<ChinaVslRgstVO> chinaVslRgstVOList
	 * @exception DAOException, Exception
	 */
	public void modifyChinaVslRgst(List<ChinaVslRgstVO> chinaVslRgstVOList) throws DAOException, Exception {
		try {
			if (chinaVslRgstVOList.size() > 0) {
				int insCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new ChinaManifestListDownloadDBDAOmodifyVslRgstUSQL(), chinaVslRgstVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Vessel Registration 목록 삭제<br>
	 *
	 * @param List<ChinaVslRgstVO> chinaVslRgstVOList
	 * @exception DAOException, Exception
	 */
	public void removeChinaVslRgst(List<ChinaVslRgstVO> chinaVslRgstVOList) throws DAOException, Exception {
		try {
			if (chinaVslRgstVOList.size() > 0) {
				int delCnt[] = new SQLExecuter("").executeBatch((ISQLTemplate)new ChinaManifestListDownloadDBDAOremoveVslRgstDSQL(), chinaVslRgstVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}