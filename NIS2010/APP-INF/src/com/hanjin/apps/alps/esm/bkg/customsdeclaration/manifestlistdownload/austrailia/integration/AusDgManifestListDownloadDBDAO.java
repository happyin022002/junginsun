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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusBkgAndLocalDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCargoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.FeederNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic.BangladeshManifestListDownloadBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010 CustomsTransmissionDAO <br>
 * - NIS2010-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jun ChangHyun
 * @see BangladeshManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class AusDgManifestListDownloadDBDAO extends DBDAOSupport {
	
	/**
	 * 구주위험물 테이블과 BKG테이블에서 동시에 데이타를 가져온다.<br>
	 * 
	 * @param  AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO> list
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<AusBkgAndLocalDgListDetailVO> searchAusDgInfoAtBkgAndLocal(AusDgListCondVO ausDgListCondVO) throws DAOException {
    	DBRowSet dbRowset = null; 
		List<AusBkgAndLocalDgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ausDgListCondVO != null) {
				Map<String, String> mapVO = ausDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchAusDgInfoAtBkgAndLocalRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AusBkgAndLocalDgListDetailVO .class); 	

			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
	

	/**
	 * 구주위험물 테이블들에서 데이타를 가져온다.<br>
	 * 
	 * @param  AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO> list
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<AusDgListDetailVO> searchAusDgInfoAtLocal(AusDgListCondVO ausDgListCondVO) throws DAOException {
    	DBRowSet dbRowset = null; 
		List<AusDgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ausDgListCondVO != null) {
				Map<String, String> mapVO = ausDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchAusDgInfoAtLocalRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AusDgListDetailVO .class); 	

			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
    
    
    
    /**
	 * 구주위험물 테이블에 정보가 없는경우, BKG테이블에서 데이타를 가져온다.<br>
	 * 
	 * @param AusDgListCondVO ausDgListCondVO
	 * @return List<AusDgListDetailVO> list
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<AusDgListDetailVO> searchAusDgInfoAtBkgDg(AusDgListCondVO ausDgListCondVO) throws DAOException {
    	DBRowSet dbRowset = null; 
		List<AusDgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ausDgListCondVO != null) {
				Map<String, String> mapVO = ausDgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchAusDgInfoAtBkgDgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AusDgListDetailVO .class); 
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
    
    
    
    
    /**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-local,<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함 <br>
	 * 
	 * @param AusDgListCondVO ausdgListCondVO
	 * @return List<AusVslInfoVO> list
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<AusVslInfoVO> searchAusVslInfo(AusDgListCondVO ausdgListCondVO) throws DAOException {
    	
    	DBRowSet dbRowset = null; 
		List<AusVslInfoVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ausdgListCondVO != null) {
				Map<String, String> mapVO = ausdgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchAusVslInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AusVslInfoVO .class); 

			
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
	 * @param AusDgListCondVO ausdgListCondVO
	 * @return List<AusVslInfoVO> list
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<AusVslInfoVO> serachVslAtCommon(AusDgListCondVO ausdgListCondVO) throws DAOException {
    	
    	DBRowSet dbRowset = null; 
		List<AusVslInfoVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ausdgListCondVO != null) {
				Map<String, String> mapVO = ausdgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOserachVslAtCommonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AusVslInfoVO .class); 
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
    
    
    

    /**
     * VSL 정보를 업데이트한다.(barge에 한해)
     * 
     * @param AusVslInfoVO ausVslInfoVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void modifyAusVslInfo(AusVslInfoVO ausVslInfoVO, SignOnUserAccount account) throws DAOException {
    	
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = ausVslInfoVO.getColumnValues();
            mapVO.put("upd_usr_id", account.getUsr_id());
            mapVO.put("cre_usr_id", account.getUsr_id());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusDgManifestListDownloadDBDAOmodifyAusVslInfoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

    	
    }
    
    
    /**
     * VSL 정보를 생성한다.(barge에 한해)
     * 
     * @param AusVslInfoVO ausVslInfoVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void addAusVslInfo(AusVslInfoVO ausVslInfoVO, SignOnUserAccount account) throws DAOException {
    	
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
        	Map<String, String> mapVO = ausVslInfoVO.getColumnValues();
            mapVO.put("upd_usr_id", account.getUsr_id());
            mapVO.put("cre_usr_id", account.getUsr_id());
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusDgManifestListDownloadDBDAOaddAusVslInfoCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

    	
    }

    
    /**
     * 위험물 정보들을 신규생성한다.
     * 
     * @param List<AusDgListDetailVO> insertDgList
     * @throws DAOException
     */
    public void addDgList(List<AusDgListDetailVO> insertDgList) throws DAOException {
    	
		try {
			int result = 0;
			
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        //Map<String, Object> velParam = new HashMap<String, Object>();
			
	        AusDgListDetailVO ausDgListDetailVO = null;
	        
			if(insertDgList.size() > 0) {
				
				for(int i = 0 ; i < insertDgList.size(); i++) {
					
					ausDgListDetailVO = insertDgList.get(i);
					Map<String, String> mapVO = ausDgListDetailVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            //velParam.putAll(mapVO);

					
					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusDgManifestListDownloadDBDAOaddDgListCSQL(), param, null);
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
     * 위험물 정보들을 업데이트한다.
     * 
     * @param List<AusDgListDetailVO> updateDgList
     * @throws DAOException
     */
    public void modifyDgList(List<AusDgListDetailVO> updateDgList) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(updateDgList.size() > 0) {
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AusDgManifestListDownloadDBDAOmodifyDgListUSQL(), updateDgList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

    	
    	
    }
    
    /**
     * 위험물 정보들을 삭제한다.<br>
     * 
     * @param List<AusDgListDetailVO> deleteDgList
     * @throws DAOException
     */
    public void removeDgList(List<AusDgListDetailVO> deleteDgList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(deleteDgList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AusDgManifestListDownloadDBDAOremoveDgListDSQL(), deleteDgList ,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

    	
    }
    
    
    
 // ★★★ ★ ★ ★ ★ ★ 여기서부터 팝업
    
    
    
    
	 /**
     * 호주 Danger cargo 정보를 컨테이너 단위로 조회한다.
     * 
     * @param dgCargoCondVO
     * @return DgInqModiVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<DgInqModiVO> searchDgInfoinquiry(DgCargoCondVO dgCargoCondVO) throws DAOException {

    	//DgInqModiVO dgInqModiVO = new DgInqModiVO();
    	List<DgInqModiVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//			list = (List)new SQLExecuter("").executeQuery(
//					(ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoinquiryRSQL(), param, velParam, DgInqModiVO.class);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusDgManifestListDownloadDBDAOsearchDgInfoinquiryRSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,DgInqModiVO.class);
			
//			if (list != null && list.size() > 0) {
//				dgInqModiVO = (DgInqModiVO) list.get(list.size() - 1);
//			}
			
			
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }   
    
	
    
    
    /**
     * 호주 DG 팝업에서 위험물 상세 정보들을 업데이트&저장한다.
     * 
     * @param DgInqModiVO dgInqModiVO
     * @throws DAOException
     */
    public void modifyDgInqBySeq(DgInqModiVO dgInqModiVO) throws DAOException {

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = dgInqModiVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AusDgManifestListDownloadDBDAOmodifyDgInqBySeqUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException("Fail to insert");
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		
    }
    
    
    
    /**
	 * Forward Code로 Forward Name을 조회한다.<br>
	 * 
	 * @param DgListCondVO dgListCondVO
	 * @return String retVal
	 * @throws DAOException
	 */
	public String searchForwarderNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusDgManifestListDownloadDBDAOsearchForwarderNameByCdRSQL(), param, velParam);

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
	 * UN NO로 NAME을 조회한다.<br>
	 * 
	 * @param DgListCondVO dgListCondVO
	 * @return String retVal
	 * @throws DAOException
	 */
	public String searchUnnoNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new AusDgManifestListDownloadDBDAOsearchUnnoNameByCdRSQL(), param, velParam);

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
	 * Feeder Name, Lloyd No를 조회한다.<br>
	 * 
	 * @return List<FeederNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederNameVO> searchDgFeederNameList() throws DAOException {

		List<FeederNameVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchDgFeederNameListRSQL(), param, velParam, FeederNameVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
    }
	
	
	/**
     * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
     * 
     * @param dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws DAOException {
		List<DgCntrInfoListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchCntrInfoListByBlRSQL(), param, velParam, DgCntrInfoListVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }
    
    
    /**
     * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
     * 
     * @param dgCargoCondVO
     * @return List<DgCntrInfoListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws DAOException {
		List<DgCntrInfoListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new AusDgManifestListDownloadDBDAOsearchCgoSeqListByCntrRSQL(), param, velParam, DgCntrInfoListVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
    }
	
    

}