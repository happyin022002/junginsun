/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAO.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.06 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFromDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InVesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaBondListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaCntrMfDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmCntrModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaIgmModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS CndManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see IndiaManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class IndiaManifestListDownloadDBDAO extends DBDAOSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * INDIA 에서 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
	 * 
	 * @param InVesselArrivalCondVO inVesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchIgmVesselDetailsByVvdPod(InVesselArrivalCondVO inVesselArrivalCondVO)throws DAOException {
		
		List<VesselArrivalDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inVesselArrivalCondVO != null) {
				
				Map<String, String> mapVO = inVesselArrivalCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new IndiaManifestListDownloadDBDAOsearchIgmVesselDetailsByVvdPodRSQL(), param, velParam, InVesselArrivalDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * 운항목록에서 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션 <br>
	 * 
	 * @param InVesselArrivalCondVO inVesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselArrivalDetailVO> searchVesselDetailAtVsl(InVesselArrivalCondVO inVesselArrivalCondVO)throws DAOException {
		
		List<VesselArrivalDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inVesselArrivalCondVO != null) {
				
				Map<String, String> mapVO = inVesselArrivalCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new IndiaManifestListDownloadDBDAOsearchVesselDetailAtVslRSQL(), param, velParam, InVesselArrivalDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}

	
	/**
	 * 인도세관 Vessel 정보 수정하는 오퍼레이션<Br>
	 * 
	 * @param InVesselArrivalVO inVesselArrivalVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyIgmVessel(InVesselArrivalVO inVesselArrivalVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = inVesselArrivalVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaManifestListDownloadDBDAOmodifyIgmVesselUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
           		//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return result;
	}
	 
	/**
	 * 인도세관 Vessel 정보 추가<Br>
	 * 
	 * @param InVesselArrivalVO inVesselArrivalVO
	 * @return int
	 * @throws DAOException
	 */
	public int addIgmVessel(InVesselArrivalVO inVesselArrivalVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = inVesselArrivalVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaManifestListDownloadDBDAOaddIgmVesselCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED) {
           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return result;
	}
	
	/**
	 * 인도세관 Vessel 정보를 제거한다.<br>
	 * 
	 * @param InVesselArrivalVO inVesselArrivalVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeIgmVessel(InVesselArrivalVO inVesselArrivalVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = inVesselArrivalVO.getColumnValues();
            
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaManifestListDownloadDBDAOremoveIgmVesselDSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED) {
                    throw new DAOException("Fail to delete SQL");
            }
            
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        return result;

	}
	
	/**
	 * INDIA 에서 세관에 적하목록을 신고하기 위한 BKG DATA 확인 하는 화면 - 배정보를 조회한다.<br>
	 * 
	 * @param IndiaManifestListCondVO indiaManifestListCondVO
	 * @return List<IndiaManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndiaManifestListDetailVO> searchIGMVsl(IndiaManifestListCondVO indiaManifestListCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<IndiaManifestListDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(indiaManifestListCondVO != null) {
				
				Map<String, String> mapVO = indiaManifestListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchIGMVslRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndiaManifestListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * INDIA 에서 세관에 적하목록을 신고하기 위한 BKG DATA 확인 하는 화면 - 신고대상을 조회해 온다.- H/BL도 대상임<br>
	 * 
	 * @param IndiaManifestListCondVO indiaManifestListCondVO
	 * @return List<IndiaManifestListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IndiaManifestListDetailVO> searchIndiaManifestListByVvdPort(IndiaManifestListCondVO indiaManifestListCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<IndiaManifestListDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(indiaManifestListCondVO != null) {
				
				Map<String, String> mapVO = indiaManifestListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchIndiaManifestListByVvdPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndiaManifestListDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * 인도세관 테이블에 BL정보를 추가한다.<Br>
	 * 
	 * @param List<IndiaIgmModiVO> indiaIgmModiVOs
	 * @throws DAOException
	 */
	public void addIGM(List<IndiaIgmModiVO> indiaIgmModiVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(indiaIgmModiVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IndiaManifestListDownloadDBDAOaddIGMCSQL(), indiaIgmModiVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
	           			throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
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
	 * 인도세관 테이블에 BL정보를 수정한다.<br>
	 * 
	 * @param List<IndiaIgmModiVO> indiaIgmModiVOs
	 * @throws DAOException
	 */
	public void modifyIGM(List<IndiaIgmModiVO> indiaIgmModiVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(indiaIgmModiVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IndiaManifestListDownloadDBDAOmodifyIGMUSQL(), indiaIgmModiVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
	           			throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
					
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	
	/**
	 * Cntr정보를 조회 해 온다.<br>
	 * 
	 * @param IndiaManifestListCondVO indiaManifestListCondVO
	 * @return List<IndiaManifestListDetailVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IndiaManifestListDetailVO> searchIndiaCntrManifestListByVvdPort(IndiaManifestListCondVO indiaManifestListCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<IndiaManifestListDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(indiaManifestListCondVO != null) {
				
				Map<String, String> mapVO = indiaManifestListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchIndiaCntrManifestListByVvdPortRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndiaCntrMfDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * 인도세관 테이블에 컨테이너 정보를 추가한다.<br>
	 * 
	 * @param List<IndiaIgmCntrModiVO> indiaIgmCntrModiVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addIGMCntr(List<IndiaIgmCntrModiVO> indiaIgmCntrModiVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(indiaIgmCntrModiVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IndiaManifestListDownloadDBDAOaddIGMCntrCSQL(), indiaIgmCntrModiVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
	           			throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
					
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * 인도세관 테이블에 컨테이너 정보를 수정한다.<br>
	 * 
	 * @param List<IndiaIgmCntrModiVO> indiaIgmCntrModiVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyIGMCntr(List<IndiaIgmCntrModiVO> indiaIgmCntrModiVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(indiaIgmCntrModiVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IndiaManifestListDownloadDBDAOmodifyIGMCntrUSQL(), indiaIgmCntrModiVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
	           			throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());
					
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * 조직 코드 등록 유무 판단.. ("0" : 미등록 / 1이상이면 등록)
	 * 
	 * @param String ofcCd
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchExistOrganization(String ofcCd) throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		
		int retVal = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null) {
				
				//Map<String, String> mapVO = inPrintFormCondVO.getColumnValues();
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchExistOrganizationRSQL(), param, velParam);
			
			if (!dbRowset.wasNull() && dbRowset.next()) {
				retVal = dbRowset.getInt(1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return retVal;
	}

	
	/**
	 * INDIA 에서 세관에 적하목록을 신고하기 위한 Cover Form Setting 하는 operation<Br>
	 * 
	 * @param  InPrintFormCondVO inPrintFormCondVO
	 * @return List<CstmsNtfyAddrVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CstmsNtfyAddrVO> searchFormSettingByOfcCd(InPrintFormCondVO inPrintFormCondVO) throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<CstmsNtfyAddrVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inPrintFormCondVO != null) {
				
				Map<String, String> mapVO = inPrintFormCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchFormSettingByOfcCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InPrintFromDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	
	/**
	 * 신규 Ofc code 로 새 폼을 추가한다.<Br>
	 * 
	 * @param List<InPrintFormModiVO> inPrintFormModiVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addFormSetting(List<InPrintFormModiVO> inPrintFormModiVOs) throws DAOException, Exception {
		int insCnt[] = null;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(inPrintFormModiVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new IndiaManifestListDownloadDBDAOaddFormSettingCSQL(), inPrintFormModiVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
	           			throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
					
				}
				
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Ofc code 정보를 수정한다.<br>
	 * 
	 * @param  List<InPrintFormModiVO> inPrintFormModiVOs
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyFormSetting(List<InPrintFormModiVO> inPrintFormModiVOs) throws DAOException, Exception {
		int result = 0;
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		
        InPrintFormModiVO inPrintFormModiVO = null;

		try {
			
			if(inPrintFormModiVOs != null && inPrintFormModiVOs.size() > 0) {
				inPrintFormModiVO = inPrintFormModiVOs.get(0);
				Map<String, String> mapVO = inPrintFormModiVO.getColumnValues();

	            param.putAll(mapVO);
	            velParam.putAll(mapVO);

	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new IndiaManifestListDownloadDBDAOmodifyFormSettingUSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
	            }
			}
			
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return result;

	}
	
	
	/**
	 * Bond(warehouse)정보를 조회해 온다.<br>
	 * 
	 * @param  IndiaBondListCondVO indiaBondListCondVO
	 * @return List<BondDetailListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BondDetailListVO> searchBondListByCdNm(IndiaBondListCondVO indiaBondListCondVO) throws DAOException, Exception {
		
		DBRowSet dbRowset = null;
		List<BondDetailListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(indiaBondListCondVO != null) {
				
				Map<String, String> mapVO = indiaBondListCondVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new IndiaManifestListDownloadDBDAOsearchBondListByCdNmRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IndiaBondDetailVO.class);
			
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
