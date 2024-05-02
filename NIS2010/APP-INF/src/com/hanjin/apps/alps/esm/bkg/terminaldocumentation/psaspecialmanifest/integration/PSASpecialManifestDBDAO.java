/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : psaspecialmanifestDBDAO.java
*@FileTitle : Forwarder Code, Name Setup(ANRBS)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.11 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.basic.PSASpecialManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrBaseInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSACntrCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADeclBaseInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendDtlHistoryVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgSendHistoryVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgValidationCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAFeederNameVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainMeansVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSAMainPartiesVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSASendHistoryDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PsaDGRcvMsgVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 PSASpecialManifestDBDAO <br>
 * - NIS2010-PSASpecialManifestBC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyoung Jong Yun
 * @see PSASpecialManifestBCImpl 참조
 * @since J2EE 1.4
 */
public class PSASpecialManifestDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EDI전송 결과를 조회 해 온다.<br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PSADgListDetailVO> searchPsaEdiSentStatus(PSADgListCondVO psaDgListCondVO) throws DAOException {

		List<PSADgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchEdiSentStatusRSQL(), param, velParam, PSADgListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }

	/**
	 * ANRBS에서 SVC_RQST_NO를 조회함(Declaration : Discharging인 것만 DEP_LOC_CD = Port_cd) <br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PSADgListDetailVO> searchPsaSSRNo(PSADgListCondVO psaDgListCondVO) throws DAOException {

		List<PSADgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchSSRNoRSQL(), param, velParam, PSADgListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
    
	/**
	 * BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PSADgListDetailVO> searchPsaDgInfoAtBkgDg(PSADgListCondVO psaDgListCondVO) throws DAOException {

		List<PSADgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				log.debug("psaDgListCondVO==>"+psaDgListCondVO.toString());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchDgInfoAtBkgDgRSQL(), param, velParam, PSADgListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함- (Booking 쪽 data) <br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return List<PSADgListDetailVO>
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<PSADgListDetailVO> serachPsaVslAtCommon(PSADgListCondVO psaDgListCondVO) throws DAOException {

		List<PSADgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new PSASpecialManifestDBDAOpsaSerachVslAtCommonRSQL(), param, velParam, PSADgListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
	/**
	 * Berth Code로 YardName을 조회한다.<br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaYardNameByCd(PSADgListCondVO psaDgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchYardNameRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		
		return retVal;
    }
   
    /**
     * Sent결과를 조회해 온다.<br>
     * 
     * @param PSASendHistoryCondVO psaSendHistoryCondVO
     * @return List<PSASendHistoryDetailVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PSASendHistoryDetailVO> searchPsaSendHistoryByCntrNo(PSASendHistoryCondVO psaSendHistoryCondVO) throws DAOException {
		List<PSASendHistoryDetailVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaSendHistoryCondVO != null)
			{
				Map<String, String> mapVO = psaSendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchSendHistoryByCntrNoRSQL(), param, velParam, PSASendHistoryDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }
    

	/**
	 * Flat File - decl 기본정보를 조회한다. <br>
	 * 
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return PSADeclBaseInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PSADeclBaseInfoVO searchPsaDeclBaseInfo(PSADgEdiVO psaDgEdiVO) throws DAOException {
		PSADeclBaseInfoVO declBaseInfoVO = new PSADeclBaseInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaDgEdiVO != null)
			{
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL(), param, velParam);
			
			List<PSADeclBaseInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,PSADeclBaseInfoVO.class);
			
			if (list != null && list.size() > 0) {
				declBaseInfoVO = (PSADeclBaseInfoVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return declBaseInfoVO;
	}
	
    /**
     * Flat File - MAIN PARTIES 정보를 조회한다. <br>
     * 
     * @param PSADgEdiVO psaDgEdiVO
     * @return List<PSAMainPartiesVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PSAMainPartiesVO> searchPsaMainParties(PSADgEdiVO psaDgEdiVO) throws DAOException {
		List<PSAMainPartiesVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaDgEdiVO != null)
			{
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchMainPartiesRSQL(), param, velParam, PSAMainPartiesVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }

	/**
	 * Flat File - MAIN MEANS 정보를 조회한다.  <br>
	 * 
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return PSAMainMeansVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PSAMainMeansVO searchPsaMainMeans(PSADgEdiVO psaDgEdiVO) throws DAOException {
		PSAMainMeansVO mainMeansVO = new PSAMainMeansVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaDgEdiVO != null)
			{
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchMainMeansRSQL(), param, velParam);
			
			List<PSAMainMeansVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,PSAMainMeansVO.class);
			
			if (list != null && list.size() > 0) {
				mainMeansVO = (PSAMainMeansVO) list.get(list.size() - 1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return mainMeansVO;
	}
    
	/**
	 * Flat File - 컨테이터 기본정보를 조회한다.   <br>
	 * 
	 * @param PSADgEdiVO psaDgEdiVO
	 * @return List<PSACntrBaseInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PSACntrBaseInfoVO> searchPsaCntrBaseInfo(PSADgEdiVO psaDgEdiVO) throws DAOException {
		List<PSACntrBaseInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaDgEdiVO != null)
			{
				Map<String, String> mapVO = psaDgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchCntrBaseInfoRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,PSACntrBaseInfoVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * Flat File - 컨테이터에 해당하는 아이템 정보 조회 <br>
	 * 
	 * @param PSACntrBaseInfoVO psaCntrBaseInfoVO
	 * @return List<PSACntrCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PSACntrCgoVO> searchPsaCntrCgoByCntrBase(PSACntrBaseInfoVO psaCntrBaseInfoVO) throws DAOException {
		List<PSACntrCgoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaCntrBaseInfoVO != null)
			{
				Map<String, String> mapVO = psaCntrBaseInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchCntrCgoByCntrBaseRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,PSACntrCgoVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
		
	/**
	 * 송신 log 저장 (송신 마스터 테이블)
	 * 
	 * @param  PSADgSendHistoryVO psaDgSendHistoryVO
	 * @throws DAOException
	 */
	public void addPsaSendLog(PSADgSendHistoryVO psaDgSendHistoryVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(psaDgSendHistoryVO != null) {
	            Map<String, String> mapVO = psaDgSendHistoryVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddPsaSendLogCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 *  * 송신 log 저장 (송신 Detail)<Br>
	 * @param List<PSADgSendDtlHistoryVO> psaDgSendDtlHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsaSendDtlLog(List<PSADgSendDtlHistoryVO> psaDgSendDtlHistoryVOs) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        PSADgSendDtlHistoryVO psaDgSendDtlHistoryVO = null;
        
        int result = 0;
        
        try {
        	for(int i = 0; i < psaDgSendDtlHistoryVOs.size(); i++) {
        	
        		psaDgSendDtlHistoryVO = psaDgSendDtlHistoryVOs.get(i);
	        	if(psaDgSendDtlHistoryVO != null) {
		            Map<String, String> mapVO = psaDgSendDtlHistoryVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSASpecialManifestDBDAOaddPsaSendDtlLogCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
        	} // end for(i)
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 *  bkg_cstms_eur_snd_log 테이블에 FlatFile을 통으로 저장한다.<Br>
	 * @param  List<PSADgSendHistoryVO> psaDgSendFlatFileHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPsaSendFlatFileLog(List<PSADgSendHistoryVO> psaDgSendFlatFileHistoryVOs) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        PSADgSendHistoryVO PsaDgSendFlatFileHistoryVO = null;
        
        int result = 0;
        
        try {
        	for(int i = 0; i < psaDgSendFlatFileHistoryVOs.size(); i++) {
        	
        		PsaDgSendFlatFileHistoryVO = psaDgSendFlatFileHistoryVOs.get(i);
	        	if(PsaDgSendFlatFileHistoryVO != null) {
		            Map<String, String> mapVO = PsaDgSendFlatFileHistoryVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate) new PSASpecialManifestDBDAOaddPsaSendFlatFileLogCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
        	} // end for(i)
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
	
	/**
	 * 수신정보 키값(MSG_SND_NO) 조회<br>
	 * 
	 * @param String msgTpId
	 * @param String keyType
	 * @param String vvdCd
	 * @param String portCd
	 * @param String dType
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaEdiHistoryKey(String msgTpId, String keyType, String vvdCd, String portCd, String dType) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (msgTpId != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("msgTpId", msgTpId);
				mapVO.put("keyType", keyType);
				mapVO.put("vvdCd", vvdCd);
				mapVO.put("portCd", portCd);
				mapVO.put("dType", dType);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchEdiHistoryKeyRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
     * 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
     * Loading(L) -> Loading(L)+Pre-carriage(P) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
     * Loading(L)+Pre-carriage(P) -> Loading(L) 이 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
     * Discharging(D) -> Discharging(D)+On-Carriage(O) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
     * Discharging(D)+On-Carriage(O) -> Discharging(D)이 등록되었는지를 판다.있으면 return "Y" 없으면 return "N"<br>
     * Transit(T) -> return "N"<br>
	 * 
	 * @param PSADgListCondVO psaDgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaDgListCopyYn(PSADgListCondVO psaDgListCondVO) throws DAOException {

		String retVal = "N";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(psaDgListCondVO != null) {
				Map<String, String> mapVO = psaDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOpsaSearchDgListCopyYnRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			} 
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		
		return retVal;
    }
	
	/**
	 * 수신정보 키값(RCV_LOG_SEQ) 조회<br>
	 * 
	 * @param String msgTpId
	 * @param String msgRevNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchRcvLogSeq(String msgTpId, String msgRevNo) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("msg_tp_id", msgTpId);
				mapVO.put("msg_rcv_no", msgRevNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOsearchRcvLogSeqRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 *  수신데이타 저장<Br>
	 *  
	 * @param PsaDGRcvMsgVO psaDGRcvMsgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAck(PsaDGRcvMsgVO psaDGRcvMsgVO) throws DAOException,Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(psaDGRcvMsgVO != null) {
	            Map<String, String> mapVO = psaDGRcvMsgVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddAckCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
	/**
	 *  수신데이타 저장<Br>
	 *  
	 * @param PsaDGRcvMsgVO psaDGRcvMsgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAckKnt(PsaDGRcvMsgVO psaDGRcvMsgVO) throws DAOException,Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(psaDGRcvMsgVO != null) {
	            Map<String, String> mapVO = psaDGRcvMsgVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddAckKntCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
    /**
     * BKG_CSTMS_PSA_DG 정보들을 신규생성한다.
     * 
     * @param List<PSACntrBaseInfoVO> insModels
     * @throws DAOException
     */
    public void addDgList(List<PSACntrBaseInfoVO> insModels) throws DAOException {
    	
		try {
			int result = 0;
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();

	        PSACntrBaseInfoVO psaCntrBaseInfoVO = null;
	        
			if(insModels.size() > 0) {
				
				for(int i = 0 ; i < insModels.size(); i++) {
					
					psaCntrBaseInfoVO = insModels.get(i);
					Map<String, String> mapVO = psaCntrBaseInfoVO.getColumnValues();
	
		            param.putAll(mapVO);

					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddDgListCSQL(), param, null);
		            if(result == Statement.EXECUTE_FAILED) {
		           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
		            }
				}
				
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
    /**
     * BKG_CSTMS_PSA_DG_CGO 정보들을 신규생성한다.
     * 
     * @param List<PSACntrCgoVO> cntrCgoVOs
     * @throws DAOException
     */
    public void addPsaCntrCgo(List<PSACntrCgoVO> cntrCgoVOs) throws DAOException {
    	
		try {
			int result = 0;
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();

			
	        PSACntrCgoVO cntrCgoVO = null;
	        
			if(cntrCgoVOs.size() > 0) {
				
				for(int i = 0 ; i < cntrCgoVOs.size(); i++) {
					
					cntrCgoVO = cntrCgoVOs.get(i);
					Map<String, String> mapVO = cntrCgoVO.getColumnValues();
	
		            param.putAll(mapVO);
		            
					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddPsaCntrCgoCSQL(), param, null);
		            if(result == Statement.EXECUTE_FAILED) {
		           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
		            }
				}
				
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }
	/**
	 * 수신정보 키값(Msg_Rcv_No) 조회<br>
	 * 
	 * @param String msgTpId
	 * @return String
	 * @throws DAOException
	 */
	public String searchMsgRcvNo(String msgTpId) throws DAOException {
		String retVal = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("msg_tp_id", msgTpId);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PSASpecialManifestDBDAOsearchMsgRcvNoRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
				
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
    /**
     * 수신 결과를 조회해 온다.<br>
     * 
     * @param PSASendHistoryCondVO psaSendHistoryCondVO
     * @return List<PSASendHistoryDetailVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PSASendHistoryDetailVO> searchPsaReceiveHistory(PSASendHistoryCondVO psaSendHistoryCondVO) throws DAOException {
		List<PSASendHistoryDetailVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (psaSendHistoryCondVO != null)
			{
				Map<String, String> mapVO = psaSendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new PSASpecialManifestDBDAOpsaSearchReceiveHistoryRSQL(), param, velParam, PSASendHistoryDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }
}
