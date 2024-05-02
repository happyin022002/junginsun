/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Eur24ManifestDownloadDBDAO.java
 *@FileTitle : Eur24ManifestDownloadDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.03
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2010.09.03 김경섭
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
 * 2011.04.05 이재위 [CHM-201109537-01] [BKG] Manifest : ENS Monotiring Function화면 개발
 * 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
 * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
 * 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration.EurCustomsTransmissionDBDAOaddEurCrnAckCSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic.Eur24ManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestOBListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrMFListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrSealNoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlDangerCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlGeneralInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010 Eur24ManifestDownloadDBDAO <br>
 * - NIS2010-Eur24ManifestDownload system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Gyoung Sub
 * @see Eur24ManifestDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public class Eur24ManifestDownloadDBDAO extends DBDAOSupport{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public Eur24ManifestDownloadDBDAO() {}

	/**
	 * BL 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchEur24BlManifestList(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEur24BlManifestListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 정보 조회를 위해 BL_NO로 VVD,EU_1ST_PORT,POL 등을 먼저 조해한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> search1stEUvvdByBL(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EU_1ST_PORT 조회를 위해 기존에 송신한 것 중 MRN이 있는것들을 조회 한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchENSBL(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchENSBLRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * EU_1ST_PORT 조회를 위해 기존에 송신한 것 중 MRN이 있으면 현 매소드를 사용한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchEU24ENSPOFEbyVVD(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
    /**
     * 기 다운로드 된  BL 정보를 삭제한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24Bl( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24BlDSQL(), param, velParam);
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
     * 기 다운로드 된 컨테이너 정보를 삭제한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24Cntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24CntrDSQL(), param, velParam);
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
     * 기 다운로드 된 컨테이너 Manifest 정보를 삭제한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24CntrMf( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24CntrMfDSQL(), param, velParam);
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
     * 기 다운로드 된 컨테이너 Danger Cargo 정보를 삭제한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24DgCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24DgCntrDSQL(), param, velParam);
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
     * 기 다운로드 된 SEAL NO를 삭제한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24CntrSeal( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24CntrSealDSQL(), param, velParam);
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
     * 기 다운로드 된 고객 정보를 삭제한다.<br>
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void removeBkgCstmsEu24Cust( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24CustDSQL(), param, velParam);
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
     * BL 정보를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24Bl( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24BlCSQL(), param, velParam);
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
     * 컨테이너 정보를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24Cntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;

    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24CntrCSQL(), param, velParam);
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
     * 컨테이너 Manifest 정보를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24CntrMf( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24CntrMfCSQL(), param, velParam);
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
     * 컨테이너 Danger Cargo 정보를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24DgCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24DgCntrCSQL(), param, velParam);
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
     * SEAL NO를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24CntrSeal( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;

    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24CntrSealCSQL(), param, velParam);
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
     * 고객 정보를 생성한다.<br>
     * 
     * @param Eu24ManifestListVO[] eu24ManifestListVOs
     * @exception DAOException
     */
	public void addBkgCstmsEu24Cust( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {

		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;

    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24CustCSQL(), param, velParam);
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
	 * BL 정보 조회<br>
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @param SignOnUserAccount account
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselArrival(Eur24VesselArrivalCondVO vesselArrivalCondVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//String crnNo = vesselArrivalCondVO.getCvyRefNo();
			Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
			if (vesselArrivalCondVO != null){
				mapVO.put("upd_usr_id", account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice1RSQL(), param, velParam);
			//if((crnNo == null || crnNo.equals("")) && (dbRowset == null || dbRowset.getRowCount() == 0)){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchVesselArrivalNotice1RSQL(), param, velParam);
			//}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CRN정보 중복 확인<br>
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselArrivalNoticeDetailVO> searchCRN(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (eur24VesselArrivalNoticeDetailVO != null){
				Map<String, String> mapVO = eur24VesselArrivalNoticeDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOsearchCRNRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 입력한다.
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int addArrivalNotice(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24VesselArrivalNoticeDetailVO.getColumnValues();
			mapVO.put("dvs_rqst_smt_flg", eur24VesselArrivalNoticeDetailVO.getDvsRqstSmtFlg().equals("1")?"Y":"N");
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOaddArrivalNoticeCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice를 입력한다.
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int modifyArrivalNotice(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			boolean flag = false;
			Map<String, String> mapVO = eur24VesselArrivalNoticeDetailVO.getColumnValues();
			mapVO.put("dvs_rqst_smt_flg", eur24VesselArrivalNoticeDetailVO.getDvsRqstSmtFlg().equals("1")?"Y":"N");
			mapVO.put("upd_usr_id", account.getUsr_id());
			String n1stClptCdNew = eur24VesselArrivalNoticeDetailVO.getRvisN1stClptCd();
			String n1stPortOfcCdNew = eur24VesselArrivalNoticeDetailVO.getN1stPortOfcCdNew();
			if(n1stClptCdNew != null && !n1stClptCdNew.equals("")){
				mapVO.put("rvis_n1st_clpt_cd", n1stClptCdNew);
				flag = true;
			}
			if(n1stPortOfcCdNew != null && !n1stPortOfcCdNew.equals("")){
				mapVO.put("n1st_port_ofc_cd", n1stPortOfcCdNew);
				flag = true;
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			if(flag){
				result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOmodifyArrivalNotice2USQL(), param, velParam);
			}else{
				result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOmodifyArrivalNoticeUSQL(), param, velParam);
			}
			
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws DAOException
	  */
	 public List<ManifestListDetailVO> searchEu1stPortByVvd(ManifestListCondVO manifestListCondVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 List<ManifestListDetailVO> list = null;
		 try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL(),param, velParam);
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }
	 
	/**
	 * Europe Advanced Manifest - ENS Report 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSReport(Eu24EnsListVO eu24EnsListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24EnsListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eu24EnsListVO != null){
				Map<String, String> mapVO = eu24EnsListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchENSReportRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24EnsListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Europe Advanced Manifest - ENS Monitoring 조회<br>
	 * 
	 * @param Eu24EnsListVO eu24EnsListVO
	 * @return List<Eu24EnsListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EnsListVO> searchENSMonitoring(Eu24EnsListVO eu24EnsListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24EnsListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eu24EnsListVO != null){
				Map<String, String> mapVO = eu24EnsListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchENSMonitoringRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24EnsListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * 
	 * @param CustomsSetupVO customsSetupVO
	 * @return List<CustomsSetupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchCustomsSetupList(CustomsSetupVO customsSetupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomsSetupVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (customsSetupVO != null){
				Map<String, String> mapVO = customsSetupVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchCustomsSetupListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomsSetupVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * MDM LOCATION 조회<br>
	 * 
	 * @param String cntCd
	 * @return List<CustomsSetupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmLocationPort(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomsSetupVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("p_cnt_cd", cntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchMdmLocationPortRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomsSetupVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * MDM YARD 조회<br>
	 * 
	 * @param String portCd
	 * @return List<CustomsSetupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomsSetupVO> searchMdmYardTmlcode(String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomsSetupVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("p_port", portCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomsSetupVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Europe Customs 코드 생성.
	 * 
	 * @param CustomsSetupVO customsSetupVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void addCustomsSetup(CustomsSetupVO customsSetupVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = customsSetupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddCustomsSetupCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Europe Customs 코드 수정.
	 * 
	 * @param CustomsSetupVO customsSetupVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void modifyCustomsSetup(CustomsSetupVO customsSetupVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = customsSetupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyCustomsSetupUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Europe Customs 코드 삭제.
	 * 
	 * @param CustomsSetupVO customsSetupVO
	 * @throws EventException
	 * @throws DAOException 
	 */
	public void removeCustomsSetup(CustomsSetupVO customsSetupVO) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = customsSetupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveCustomsSetupDSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * searchVesselByBL 정보 검색
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 * @throws DAOException 
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBL(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vesselArrivalCondVO != null){
				Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchVVDByBlRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * BL General Info 정보 검색
	 * 
	 * @param String blNo
	 * @param String vvd
	 * @param String cstmsPortCd
	 * @param String cstmsYdCd
	 * @return Eur24BlGeneralInfoVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public Eur24BlGeneralInfoVO searchBlGeneral(String blNo, String vvd,String cstmsPortCd, String cstmsYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlGeneralInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			param.put("cstms_yd_cd", cstmsYdCd);
			velParam.put("cstms_yd_cd", cstmsYdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlInfoRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlGeneralInfoVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * B/L Container 조회
	 * @param String blNo 
	 * @param String vvd
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrListVO> searchBlCntr(String blNo, String vvd, String cstmsPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOsearchBlCntrRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrListVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	
	/**
	 * B/L Container 조회
	 * @param String blNo 
	 * @param String vvd
	 * @param String cntrNo
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrMFListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrMFListVO> searchBlCntrMF(String blNo, String vvd, String cntrNo, String cstmsPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrMFListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOsearchBlCntrMFRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrMFListVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	
	/**
	 * B/L Container 조회 : searchBlCntrMF의 overloading method
	 * @param String blNo 
	 * @param String vvd
	 * @param String cstmsPortCd
	 * @return List<Eur24BlCntrMFListVO>
	 * @exception DAOException
	 */
	public List<Eur24BlCntrMFListVO> searchBlCntrMF(String blNo, String vvd, String cstmsPortCd) throws DAOException {
		return searchBlCntrMF(blNo, vvd, "", cstmsPortCd);
	}

	/**
	 * B/L Customer 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @return Eur24BlCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Eur24BlCustVO searchBlCust(String blNo, String vvd, String cstmsPortCd) throws DAOException	{
		DBRowSet dbRowset = null;
		List<Eur24BlCustVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlCustInfoRSQL() ,param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCustVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EUR24H B/L Danger Container 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @return List<Eur24BlDangerCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlDangerCntrListVO> searchBlDangerCntr(String blNo, String vvd, String cstmsPortCd) throws DAOException{
		DBRowSet dbRowset = null;
		List<Eur24BlDangerCntrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlDangerCntrRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlDangerCntrListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}

	/**
	 * EUR24H B/L Container Sean No 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @param String cntrNo
	 * @return List<Eur24BlDangerCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrSealNoListVO> searchBlCntrSealNo(String blNo, String vvd, String cstmsPortCd, String cntrNo) throws DAOException{
		DBRowSet dbRowset = null;
		List<Eur24BlCntrSealNoListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlCntrSealNoRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrSealNoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	
	/**
	 * EUR24H B/L Container Sean No 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @return List<Eur24BlDangerCntrListVO>
	 * @exception DAOException
	 */
	public List<Eur24BlCntrSealNoListVO> searchBlCntrSealNo(String blNo, String vvd, String cstmsPortCd) throws DAOException {
		return searchBlCntrSealNo(blNo, vvd, cstmsPortCd, "");
	}
	
	/**
	 * EUR24H B/L General Info 조회
	 * @param Eur24BlGeneralInfoVO eur24BlGeneralInfoVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlInfo(Eur24BlGeneralInfoVO eur24BlGeneralInfoVO,	SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlGeneralInfoVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOUpdateBlGeneralInfoUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Customer Info 입력
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @throws DAOException 
	 * @exception DAOException
	 */
	public int addBlCust(Eur24BlCustVO eur24BlCustVO, SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("I") && !f_ibflag.equals("I") && !n_ibflag.equals("I") && !c_ibflag.equals("I")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCustCSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Customer Info 수정
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBlCust(Eur24BlCustVO eur24BlCustVO,	SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("U") && !f_ibflag.equals("U") && !n_ibflag.equals("U") && !c_ibflag.equals("U")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCustCSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Customer Info 삭제
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @throws DAOException 
	 * @exception DAOException
	 */
	public int removeBlCust(Eur24BlCustVO eur24BlCustVO, SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("D") && !f_ibflag.equals("D") && !n_ibflag.equals("D") && !c_ibflag.equals("D")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCustDSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Danger Info 입력
	 * @param Eur24BlDangerCntrListVO danger 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int addBlCntrDanger(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlDangerousCntrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * EUR24H B/L Danger Info 삭제
	 * @param Eur24BlDangerCntrListVO danger  
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlCntrDanger(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlDangerousCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	/**
	 * EUR24H B/L Danger Info 수정
	 * @param Eur24BlDangerCntrListVO danger 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBlCntrDanger(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlDangerousCntrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Container Info 수정
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntr(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EUR24H B/L Container Info 추가
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntr(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EUR24H B/L Container Info 수정
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntr(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrMF(List<Eur24BlCntrMFListVO> eur24BlCntrMFListVOs,	SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			int count = 0;
			String temp_cntr_no = "";
			int cntr_cgo_seq = 1;
			for(Eur24BlCntrMFListVO cntr : eur24BlCntrMFListVOs){
				String ibFlag = cntr.getIbflag();
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				SQLExecuter sqlExe = new SQLExecuter("");
				Map<String, String> mapVO = cntr.getColumnValues();
				if(temp_cntr_no.equals(cntr.getCntrNo())){
					cntr_cgo_seq++;
				}else{
					cntr_cgo_seq = 1;
				}
				mapVO.put("cntr_cgo_seq", cntr_cgo_seq+"");
				mapVO.put("cre_usr_id", account.getUsr_id());
				mapVO.put("upd_usr_id", account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(ibFlag.equals("D") || count == 0){//맨 처음에 원래 입력되어 있던 정보를 삭제한다
					result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAODeleteBlCntrMFDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				}
				
				if(ibFlag.equals("I")|| ibFlag.equals("U"))
					result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrMFCSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
				count++;
				temp_cntr_no = cntr.getCntrNo();
			}
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrMF(Eur24BlCntrMFListVO cntrMF,	SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrMFUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntrMF(Eur24BlCntrMFListVO cntrMF,	SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrMFCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntrMF(Eur24BlCntrMFListVO cntrMF, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrMFDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EUR24H B/L Container Seal No Info 추가
	 * @param Eur24BlCntrSealNoListVO seal
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntrSealNo(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrSealNoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Container Seal No Info 수정
	 * @param Eur24BlCntrSealNoListVO seal 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrSealNo(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrSealNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H B/L Container Seal No Info 수정
	 * @param Eur24BlCntrSealNoListVO seal 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntrSealNo(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrSealNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EUR24H searchCstmsRcvMsg 조회
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO 
	 * @return List<Eur24RcvMsgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")	
	public List<Eur24RcvMsgVO> searchCstmsRcvMsg(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24RcvMsgVO> list = null;
//		List<Eur24RcvMsgVO> result = new ArrayList<Eur24RcvMsgVO>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	//	String[][] msgFlag = {{"S","Status"}, {"E", "Reject of Error Code"} , {"M", "Message Full Text"}};//S Status, E Error, M Message
		try{
			Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchRcvMsgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24RcvMsgVO.class);
			/*
			for(int i=0; i < msgFlag.length; i++){
				if(vesselArrivalCondVO != null){
					Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
					mapVO.put("msgFlag", msgFlag[i][0]);
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchRcvMsgRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24RcvMsgVO.class);
				for(int j = 0; j < list.size(); j++){
					Eur24RcvMsgVO msgVO = list.get(j);
					String remarks = msgVO.getRemark1();
					if(remarks.equals(":")) continue;
					if(msgFlag[i][0].equals("E")){
						msgVO.setColumn1(msgFlag[i][1] + (j+1));
					}else{
						msgVO.setColumn1(msgFlag[i][1]);
					}
					result.add(msgVO);
				}
			}
			*/
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * EUR24H 점소 ID 조회
	 * @param String rvis_n1st_clpt_cd 
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")	
	public List<Eur24VesselArrivalNoticeDetailVO> searchCstmsOfficeIdByPort(String rvis_n1st_clpt_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselArrivalNoticeDetailVO> list = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (rvis_n1st_clpt_cd != null){
				param.put("port_cd", rvis_n1st_clpt_cd);
				velParam.put("port_cd", rvis_n1st_clpt_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Eur24ManifestDownloadDBDAOSearchCstmsOfficeIdByportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Transmit / Receive History 조회<br>
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EU24EDIHistoryVO> searchEU24EDIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EU24EDIHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eU24EDIHistoryVO != null){
				Map<String, String> mapVO = eU24EDIHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EU24EDIHistoryVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Transmit / Receive History 조회<br>
	 * @param EU24EDIHistoryVO eU24EDIHistoryVO
	 * @return List<EU24EDIHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EU24EDIHistoryVO> searchEU24EDIFIHistory(EU24EDIHistoryVO eU24EDIHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EU24EDIHistoryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eU24EDIHistoryVO != null){
				Map<String, String> mapVO = eU24EDIHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24FIEDIHistoryRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EU24EDIHistoryVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ENS화면 - POL이 EU 포트인지 체크를 위해 EU포트 조회<br>
	 * @param Eu24CountryListVO eu24CountryListVO
	 * @return List<Eu24CountryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24CountryListVO> searchEU24CountryList (Eu24CountryListVO  eu24CountryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24CountryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eu24CountryListVO != null){
				Map<String, String> mapVO = eu24CountryListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24CountryListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24CountryListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * Europe Advanced Manifest-Error Code Table 조회<br>
	 * @param EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO
	 * @return List<EU24RcvErrorCodeTableVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EU24RcvErrorCodeTableVO> searchEU24RcvErrorCodeTable(EU24RcvErrorCodeTableVO eU24RcvErrorCodeTableVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EU24RcvErrorCodeTableVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eU24RcvErrorCodeTableVO != null){
				Map<String, String> mapVO = eU24RcvErrorCodeTableVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24RcvErrorCodeTableRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EU24RcvErrorCodeTableVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * ESM_BKG_1105.do -> Diversion Request용
	  * ESM_BKG_1104.do는 VSL_PORT_SKD table에서 가져오나 이 서비스는 BKG_CSTMS_EUR_BL에서 가져온다.
	  * ENS과정을 거친 정보를 가져와야 유효하기 때문이다.
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws DAOException 
	  */
	public List<ManifestListDetailVO> searchCstmsENSPofeList(ManifestListCondVO manifestListCondVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 List<ManifestListDetailVO> list = null;
		 try{
			if(manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Eur24ManifestDownloadDBDAOSearchCstmsENSPofeListRSQL(),param, velParam);
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		return list;
	}	

	 /**
	  * VVD  FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	  * @param  ManifestListCondVO manifestListCondVO
	  * @return List<ManifestListDetailVO>
	  * @throws DAOException
	  */
	 public List<ManifestListDetailVO> searchEuPolByVvd(ManifestListCondVO manifestListCondVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 List<ManifestListDetailVO> list = null;
		 try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Eur24ManifestDownloadDBDAOSearchEuPolByVvdRSQL(),param, velParam);
			 list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		 } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		 
		 return list;
	 }
	/**
	 * BL 정보 조회<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<Eu24ManifestListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchEur24BlManifestOBList(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEur24BlManifestOBListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestOBListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * OB 기 다운로드 된  BL 정보를 삭제한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBBl( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBBlDSQL(), param, velParam);
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
	 * OB 기 다운로드 된 컨테이너 정보를 삭제한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL(), param, velParam);
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
	 * OB 기 다운로드 된 컨테이너 Manifest 정보를 삭제한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBCntrMf( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrMfDSQL(), param, velParam);
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
	 * OB 기 다운로드 된 SEAL NO를 삭제한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBCntrSeal( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrSealDSQL(), param, velParam);
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
	 * OB 기 다운로드 된 고객 정보를 삭제한다.<br>
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBCust( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCustDSQL(), param, velParam);
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
	 * OB 기 다운로드 된 컨테이너 Danger Cargo 정보를 삭제한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void removeBkgCstmsEu24OBDgCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBDgCntrDSQL(), param, velParam);
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
	 * OB BL 정보를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBBl( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBBlCSQL(), param, velParam);
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
	 * OB 컨테이너 정보를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
	
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCntrCSQL(), param, velParam);
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
	 * OB 컨테이너 Manifest 정보를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBCntrMf( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCntrMfCSQL(), param, velParam);
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
	 * OB SEAL NO를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBCntrSeal( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
	
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCntrSealCSQL(), param, velParam);
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
	 * OB고객 정보를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBCust( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
	
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
	
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO); 
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBCustCSQL(), param, velParam);
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
	 * OB 컨테이너 Danger Cargo 정보를 생성한다.<br>
	 * 
	 * @param Eu24ManifestListVO[] eu24ManifestListVOs
	 * @exception DAOException
	 */
	public void addBkgCstmsEu24OBDgCntr( Eu24ManifestListVO[] eu24ManifestListVOs) throws DAOException {
		if(eu24ManifestListVOs == null || eu24ManifestListVOs.length == 0) return;
		//query parameter
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
	    try{
	        Map<String, String> mapVO = eu24ManifestListVOs[0].getColumnValues();
	        param.putAll(mapVO);
	        velParam.putAll(mapVO);
	        
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOAddBkgCstmsEu24OBDgCntrCSQL(), param, velParam);
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
	 * EXS용(1121) BL 정보 조회를 위해 BL_NO로 VVD,POL,POD 등을 먼저 조회한다.<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchEuOBVvdByBL(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEuOBVvdByBLRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		}
		catch (SQLException se)
		{
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch (Exception ex)
		{
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * Europe Advanced Manifest - ENS Report 조회<br>
	 * 
	 * @param Eu24ExsListOBVO eu24ExsListOBVO
	 * @return List<Eu24ExsListOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24ExsListOBVO> searchEXSReportOB(Eu24ExsListOBVO eu24ExsListOBVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24ExsListOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eu24ExsListOBVO != null){
				Map<String, String> mapVO = eu24ExsListOBVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ExsListOBVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * Transmit / Receive History 조회<br>
	 * @param EU24EDIHistoryOBVO eU24EDIHistoryOBVO
	 * @return List<EU24EDIHistoryOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EU24EDIHistoryOBVO> searchEU24EDIHistoryOB(EU24EDIHistoryOBVO eU24EDIHistoryOBVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EU24EDIHistoryOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eU24EDIHistoryOBVO != null){
				Map<String, String> mapVO = eU24EDIHistoryOBVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24EDIHistoryOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EU24EDIHistoryOBVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Transmit / Receive History 중 Result 값에 Hold 관련된 데이터 조회<br>
	 * @param EU24EDIHistoryOBVO eU24EDIHistoryOBVO
	 * @return List<EU24EDIHistoryOBVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public EU24EDIHistoryOBVO searchEU24EDIHoldHistoryOB(String pBlNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EU24EDIHistoryOBVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{System.out.println("*******11*********");
    	
			if (pBlNo != null){
				
				param.put("p_bl_no", pBlNo);
				velParam.put("p_bl_no", pBlNo);
			}
			System.out.println("*******12*********");
	    	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEU24EDIHoldHistoryOBRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EU24EDIHistoryOBVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
			
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * EUR24H searchCstmsRcvMsg 조회
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO 
	 * @return List<Eur24RcvMsgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")	
	public List<Eur24RcvMsgVO> searchCstmsRcvMsgOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24RcvMsgVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchRcvMsgOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24RcvMsgVO.class);

		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * BL General Info 정보 검색
	 * 
	 * @param String blNo
	 * @param String vvd
	 * @param String cstmsPortCd
	 * @param String cstmsYdCd
	 * @return Eur24BlGeneralInfoVO
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public Eur24BlGeneralInfoVO searchBlGeneralOB(String blNo, String vvd,String cstmsPortCd, String cstmsYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlGeneralInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			param.put("cstms_yd_cd", cstmsYdCd);
			velParam.put("cstms_yd_cd", cstmsYdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlInfoOBRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24BlGeneralInfoVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * B/L Customer 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @return Eur24BlCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public Eur24BlCustVO searchBlCustOB(String blNo, String vvd, String cstmsPortCd) throws DAOException	{
		DBRowSet dbRowset = null;
		List<Eur24BlCustVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlCustInfoOBRSQL() ,param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCustVO.class);
			if(list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * B/L Container 조회
	 * @param String blNo 
	 * @param String vvd
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrListVO> searchBlCntrOB(String blNo, String vvd, String cstmsPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOsearchBlCntrOBRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrListVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	/**
	 * EUR24H B/L Danger Container 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @return List<Eur24BlDangerCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlDangerCntrListVO> searchBlDangerCntrOB(String blNo, String vvd, String cstmsPortCd) throws DAOException{
		DBRowSet dbRowset = null;
		List<Eur24BlDangerCntrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlDangerCntrOBRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlDangerCntrListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	/**
	 * B/L Container 조회
	 * @param String blNo 
	 * @param String vvd
	 * @param String cntrNo
	 * @param String cstmsPortCd 
	 * @return List<Eur24BlCntrMFListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrMFListVO> searchBlCntrMFOB(String blNo, String vvd, String cntrNo, String cstmsPortCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24BlCntrMFListVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOsearchBlCntrMFOBRSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrMFListVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	/**
	 * EUR24H B/L Container Sean No 조회
	 * @param String blNo 
	 * @param String vvd 
	 * @param String cstmsPortCd
	 * @param String cntrNo
	 * @return List<Eur24BlDangerCntrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24BlCntrSealNoListVO> searchBlCntrSealNoOB(String blNo, String vvd, String cstmsPortCd, String cntrNo) throws DAOException{
		DBRowSet dbRowset = null;
		List<Eur24BlCntrSealNoListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			param.put("cstms_port_cd", cstmsPortCd);
			velParam.put("cstms_port_cd", cstmsPortCd);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlCntrSealNoOBRSQL(),param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Eur24BlCntrSealNoListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;		
	}
	/**
	 * searchVesselByBL 정보 검색
	 * 
	 * @param Eur24VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<Eur24VesselArrivalNoticeDetailVO>
	 * @throws EventException
	 * @throws DAOException 
	 */
	public List<Eur24VesselArrivalNoticeDetailVO> searchVesselByBLOB(Eur24VesselArrivalCondVO vesselArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vesselArrivalCondVO != null){
				Map<String, String> mapVO = vesselArrivalCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchVVDByBlOBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * EUR24H B/L General Info 조회
	 * @param Eur24BlGeneralInfoVO eur24BlGeneralInfoVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlInfoOB(Eur24BlGeneralInfoVO eur24BlGeneralInfoVO,	SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlGeneralInfoVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOUpdateBlGeneralInfoOBUSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Customer Info 입력
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @throws DAOException 
	 * @exception DAOException
	 */
	public int addBlCustOB(Eur24BlCustVO eur24BlCustVO, SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("I") && !f_ibflag.equals("I") && !n_ibflag.equals("I") && !c_ibflag.equals("I")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCustOBCSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Customer Info 수정
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBlCustOB(Eur24BlCustVO eur24BlCustVO,	SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("U") && !f_ibflag.equals("U") && !n_ibflag.equals("U") && !c_ibflag.equals("U")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCustOBCSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Customer Info 삭제
	 * @param Eur24BlCustVO eur24BlCustVO 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @throws DAOException 
	 * @exception DAOException
	 */
	public int removeBlCustOB(Eur24BlCustVO eur24BlCustVO, SignOnUserAccount account) throws DAOException {
		String s_ibflag = eur24BlCustVO.getSIbflag();
		String f_ibflag = eur24BlCustVO.getFIbflag();
		String n_ibflag = eur24BlCustVO.getNIbflag();
		String c_ibflag = eur24BlCustVO.getCIbflag();
		if(!s_ibflag.equals("D") && !f_ibflag.equals("D") && !n_ibflag.equals("D") && !c_ibflag.equals("D")) return 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24BlCustVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCustOBDSQL(), param,	velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to remove SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Info 수정
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntrOB(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrOBDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Info 추가
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntrOB(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrOBCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Info 수정
	 * @param Eur24BlCntrListVO cntr 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrOB(Eur24BlCntrListVO cntr, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = cntr.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrOBUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntrMFOB(Eur24BlCntrMFListVO cntrMF, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrMFOBDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntrMFOB(Eur24BlCntrMFListVO cntrMF,	SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrMFOBCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container MF Info 수정
	 * @param Eur24BlCntrMFListVO cntrMF
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrMFOB(Eur24BlCntrMFListVO cntrMF,	SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = cntrMF.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrMFOBUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Danger Info 삭제
	 * @param Eur24BlDangerCntrListVO danger  
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int removeBlCntrDangerOB(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlDangerousCntrOBDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	/**
	 * EUR24H B/L Danger Info 입력
	 * @param Eur24BlDangerCntrListVO danger 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int addBlCntrDangerOB(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlDangerousCntrOBCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	/**
	 * EUR24H B/L Danger Info 수정
	 * @param Eur24BlDangerCntrListVO danger 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBlCntrDangerOB(Eur24BlDangerCntrListVO danger, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = danger.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlDangerousCntrOBUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Seal No Info 수정
	 * @param Eur24BlCntrSealNoListVO seal 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int removeBlCntrSealNoOB(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAORemoveBlCntrSealNoOBDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Seal No Info 추가
	 * @param Eur24BlCntrSealNoListVO seal
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addBlCntrSealNoOB(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOAddBlCntrSealNoOBCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * EUR24H B/L Container Seal No Info 수정
	 * @param Eur24BlCntrSealNoListVO seal 
	 * @param SignOnUserAccount account 
	 * @return int
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int modifyBlCntrSealNoOB(Eur24BlCntrSealNoListVO seal, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = seal.getColumnValues();
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyBlCntrSealNoOBUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 삭제 <br>
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @return int
	 * @exception DAOException
	 */

	public int modifyMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws DAOException {
		int result = -1;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		try	{
			Map<String, String> mapVO = eur24BlInfoCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOModifyMrnNoUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	/**
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 재입력 <br>
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @return int
	 * @exception DAOException
	 */

	public int reactivateMrnNo(Eur24BlInfoCondVO eur24BlInfoCondVO) throws DAOException {
		int result = -1;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		try	{
			Map<String, String> mapVO = eur24BlInfoCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOReactivateMrnNoUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Delete SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Prev. Doc No를 저장 (수신 마스터 테이블)<Br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)<br>
	 * 
	 * @param  List<EurCrnRcvMsgVO> eurCrnRcvMsgVOs
	 * @throws DAOException
	 */
	public void addEurPrevDocNo(List<EurCrnRcvMsgVO> eurCrnRcvMsgVOs) throws DAOException {
		
        try {
        	
        	
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
			int result = 0;
			
			/*
			 * 화면 Prev.Doc No 정보를 등록한다.(수신 CRN 테이블에)
			 */

			for(int i = 0; i < eurCrnRcvMsgVOs.size(); i++) {
	        	EurCrnRcvMsgVO eurCrnRcvMsgVO = eurCrnRcvMsgVOs.get(i);
				
	        	if(eurCrnRcvMsgVO != null) {
		            Map<String, String> mapVO = eurCrnRcvMsgVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
				
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new EurCustomsTransmissionDBDAOaddEurCrnAckCSQL(), param, velParam);
	
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
			}
            
		} catch (SQLException se) {
			log.error(se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	
	/**
	 * ESM_BKG_1146 : SEARCH <br>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No pop-up 조회<br>
	 * 
	 * @param EurCrnRcvMsgVO eurCrnRcvMsgVO
	 * @return List<EurCrnRcvMsgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurCrnRcvMsgVO> searchPrevDocNo(EurCrnRcvMsgVO eurCrnRcvMsgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EurCrnRcvMsgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(eurCrnRcvMsgVO != null){
				Map<String, String> mapVO = eurCrnRcvMsgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchPrevDocNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EurCrnRcvMsgVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
	
	
	/**
	 * Europe Advanced Manifest - EXS Monitoring 조회<br>
	 * 
	 * @param Eu24EXSListVO eu24EXSListVO
	 * @return List<Eu24EXSListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eu24EXSListVO> searchEXSMonitoring(Eu24EXSListVO eu24EXSListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eu24EXSListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (eu24EXSListVO != null){
				Map<String, String> mapVO = eu24EXSListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchEXSMonitoringRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24EXSListVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회<br>
	 * @param  ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	public List<ManifestListDetailVO> searchPreEUportByVvd(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ManifestListDetailVO> list = null;
		try{
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Eur24ManifestDownloadDBDAOSearchPreEUportByVvdRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Finland (IE344) / BL 로 해당하는 vvd 의 pre EU Port 를 조회
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchPreEUvvdByBL(ManifestListCondVO manifestListCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ManifestListDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (manifestListCondVO != null){
				Map<String, String> mapVO = manifestListCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchPreEUvvdByBLRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eu24ManifestListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 정보 조회<br>
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchVesselFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselFIArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//String crnNo = vesselArrivalCondVO.getCvyRefNo();
			Map<String, String> mapVO = vesselFIArrivalCondVO.getColumnValues();
			if (vesselFIArrivalCondVO != null){
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchVesselFIArrivalNoticeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselFIArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * BL 정보 조회<br>
	 * 
	 * @param Eur24VesselArrivalCondVO vesselFIArrivalCondVO
	 * @return List<Eur24VesselFIArrivalNoticeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Eur24VesselFIArrivalNoticeDetailVO> searchBlFIArrival(Eur24VesselArrivalCondVO vesselFIArrivalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<Eur24VesselFIArrivalNoticeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			//String crnNo = vesselArrivalCondVO.getCvyRefNo();
			Map<String, String> mapVO = vesselFIArrivalCondVO.getColumnValues();
			if (vesselFIArrivalCondVO != null){
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new Eur24ManifestDownloadDBDAOSearchBlFIArrivalNoticeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, Eur24VesselFIArrivalNoticeDetailVO.class);
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다.
	 * 
	 * @param Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int modifyFIArrivalNotice(Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			//boolean flag = false;
			Map<String, String> mapVO = eur24VesselFIArrivalNoticeDetailVO.getColumnValues();
			mapVO.put("dvs_rqst_smt_flg", eur24VesselFIArrivalNoticeDetailVO.getDvsRqstSmtFlg().equals("1")?"Y":"N");
			mapVO.put("upd_usr_id", account.getUsr_id());

			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			
				result = sqlExe.executeUpdate((ISQLTemplate)new Eur24ManifestDownloadDBDAOModifyFIArrivalNoticeUSQL(), param, velParam);
			
			
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	
	/**
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No 저장한다
	 * 
	 * @param Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int addFIArrivalNotice(Eur24VesselFIArrivalNoticeDetailVO eur24VesselFIArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24VesselFIArrivalNoticeDetailVO.getColumnValues();
			mapVO.put("dvs_rqst_smt_flg", eur24VesselFIArrivalNoticeDetailVO.getDvsRqstSmtFlg().equals("1")?"Y":"N");
			mapVO.put("cre_usr_id", account.getUsr_id());
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOaddFIArrivalNoticeCSQL(), param,	velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
		
	/**
	 * ESM_BKG_1107 <br>
	 * MRN No 관리 기록 추가(남기기) <br>
	 * @param Eur24BlInfoCondVO eur24BlInfoCondVO
	 * @return int
	 * @exception DAOException
	 */
	public int addMrnNoHis(Eur24BlInfoCondVO eur24BlInfoCondVO) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = eur24BlInfoCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOaddMrnNoHisCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	
	/**
	 * 세관 신고 대상 Vessel Arrival Notice 의 ENS ETA 를 수정한다.
	 * 
	 * @param Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO
	 * @param SignOnUserAccount account
	 * @return int 
	 * @throws EventException
	 * @throws DAOException 
	 */
	public int modifyArrivalNoticeEnsEta(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws EventException, DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;
		try	{
			Map<String, String> mapVO = eur24VesselArrivalNoticeDetailVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAOmodifyArrivalNoticeEnsEtaUSQL(), param,	velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
	
	/**
	 * EU A/N (ESM_BKG_1104) 에서 구주스탭이 해당 VVD 의 모든 MRN 을 삭제
	 * 
	 * @param eur24VesselArrivalNoticeDetailVO
	 * @param account
	 * @return int
	 * @throws DAOException
	 */
	public int deleteAllMrn(Eur24VesselArrivalNoticeDetailVO eur24VesselArrivalNoticeDetailVO, SignOnUserAccount account) throws DAOException {
		int result = -1;
		try	{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = eur24VesselArrivalNoticeDetailVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = sqlExe.executeUpdate((ISQLTemplate) new Eur24ManifestDownloadDBDAODeleteAllMrnUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	
}