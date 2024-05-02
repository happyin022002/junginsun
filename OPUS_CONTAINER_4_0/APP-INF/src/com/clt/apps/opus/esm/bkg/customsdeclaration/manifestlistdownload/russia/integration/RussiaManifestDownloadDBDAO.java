/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : RussiaManifestDownloadDBDAO.java
 *@FileTitle : ESM_BKG_1163
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.04
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.07.04 김보배
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic.RussiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlInVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.ModifyCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS RussiaManifestDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic 을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author BOBAE KIM
 * @see RussiaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class RussiaManifestDownloadDBDAO extends DBDAOSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	public RussiaManifestDownloadDBDAO() {}

	
	/**
	 * Russia 를 통과하는 화물에 대한 Manifest List 를 조회한다.<br> 
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManifestListDetailVO> searchRussiaManifestList(ManifestListCondVO manifestListCondVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RussiaManifestDownloadDBDAOSearchRussiaManifestListRSQL(), param,velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RussiaManifestListDetailVO.class);
			
		}catch (SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch (Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.
	 * 
	 * @param FdrBlInVO fdrBlInVO
	 * @return List<FdrBlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FdrBlVO> searchBkgListForFdrBl(FdrBlInVO fdrBlInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FdrBlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null!=fdrBlInVO) {
				Map<String, String> mapVO = fdrBlInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExec = new SQLExecuter("DEFAULT");
				RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL template = new RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL();
				dbRowset = sqlExec.executeQuery(template, param, velParam, true);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, FdrBlVO.class);
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * Customer 정보를 변경한다.<br>
	 * 
	 * @param FdrBlVO fdrBlVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addCustInfoBkgCstmsRuCust(FdrBlVO fdrBlVO, SignOnUserAccount account) throws DAOException {
		int retInt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try {
        	
			Map<String, String> mapVO = fdrBlVO.getColumnValues();
			
			param.put("cre_usr_id", account.getUsr_id());
			param.put("upd_usr_id", account.getUsr_id());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
            retInt = new SQLExecuter("").executeUpdate((ISQLTemplate) new RussiaManifestDownloadDBDAOaddCustInfoForFdrBlCSQL(), param, velParam);
			if(retInt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	
	/**
	 * ESM_BKG_1163
	 * SAVE 시 CNTR WGT 정보 저장
	 * 
	 * @param List<ModifyCntrInfoVO> modifyCntrInfoVOs
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void manageRussiaCntrInfo(List<ModifyCntrInfoVO> modifyCntrInfoVOs, SignOnUserAccount account) throws DAOException {

        try {
        	
        	 //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
			int result = -1;

			for(int i = 0; i < modifyCntrInfoVOs.size(); i++) {
				ModifyCntrInfoVO modifyCntrInfoVO = modifyCntrInfoVOs.get(i);
				
	        	if(modifyCntrInfoVO != null) {
		            Map<String, String> mapVO = modifyCntrInfoVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new RussiaManifestDownloadDBDAOmodifyCntrInfoCSQL(), param, velParam);
	
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
			}
			
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
}
