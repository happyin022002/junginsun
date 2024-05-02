/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAO.java
*@FileTitle : PSAManifestDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
* 
* 
2011.06.16 민정호 [CHM-201111127] Split 03-Split 08-ALPS Error 처리 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgCstmsPsaCntrChkVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgDataVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.BkgVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.CntrNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.CntrSpeCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.NameEtdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAddVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrFlatVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgCntrNewVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrTpszVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgRlsOrdVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVslVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgvvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrCntVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaHeadVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsAddVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaMaxSubSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaNextVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsForYardVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdCntrQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRlsOrdSubSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaRoCntrQtyVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSerNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaShprVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSndDtVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaSubSrlNoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaTpVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBKGVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchBkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchCNTRVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchPsaCntrVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * PSA Manifest 업무의 Business Logic 처리를 위한 JDBC 작업 수행
 * 
 * @author 박상훈
 * @see PSAManifestBCImpl 참조
 * @since J2EE 1.6
 *
 */ 
public class PSAManifestDBDAO extends DBDAOSupport {


	private static final long serialVersionUID = 5184706835600062011L;

	/**
	 * PSA Vessel 정보 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return PsaVvdVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaVvdVO[] searchPSAVslRegist(PsaVvdVO psaVvdVO) throws DAOException 
	{
		DBRowSet dbRowset = null;
		List<PsaVvdVO> list = null;
		PsaVvdVO[] psaVvdVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslRegistRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
			if (list!=null && list.size() > 0) psaVvdVOs = list.toArray(new PsaVvdVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaVvdVOs;	
	}
	
	/**
	 * Vsl Code 로 Vsl Name 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSAVslName(PsaVvdVO psaVvdVO) throws DAOException
	{
		String psaVslNm = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) psaVslNm = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaVslNm;
	}
	
	/**
	 * VESSEL PORT SCHEDULE VALIDATION CHECK
	 * @param String vslCd
	 * @param String voyNo
	 * @param String dirCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVslPortSkdValidCheck(String vslCd, String voyNo, String dirCd) throws DAOException
	{
		String cnt = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("vsl_cd", 	vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", dirCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslPortSkdValidCheckRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;
	}
	
	/**
	 *  PSA VVD Validation check
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSAVVDValidCheck(PsaVvdVO psaVvdVO) throws DAOException
	{
		String cnt = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVVDValidCheckRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;
	}
	
	/**
	 * PSA VVD 정보 추가
	 * @param PsaVvdVO psaVvdVO
	 * @exception DAOException
	 */
	public void addPSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException 
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPSAVVDInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * PSA VVD 정보 수정
	 * @param PsaVvdVO psaVvdVO
	 * @exception DAOException
	 */
	public void modifyPSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPSAVVDInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA 기 전송여부 체크 
	 * @param PsaVvdVO psaVvdVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSASendValidCheck(PsaVvdVO psaVvdVO) throws DAOException
	{
		String cnt = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSASendValidCheckRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;
	}
	
	/**
	 * PSA VVD Data 삭제
	 * @param PsaVvdVO psaVvdVO
	 * @exception DAOException
	 */
	public void removePSAVVDInfo(PsaVvdVO psaVvdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePSAVVDInfoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Target Port에 일정기간내 접안 예정 스케줄의 VVD를 조회한다.
	 * @param PsaVvdVO psaVvdVO
	 * @return PsaVvdVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaVvdVO[] searchPSAVVD(PsaVvdVO psaVvdVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaVvdVO> list = null;
		PsaVvdVO[] psaVvdVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVVDRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
			if (list!=null && list.size() > 0) psaVvdVOs = list.toArray(new PsaVvdVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaVvdVOs;		
	}
	
	/**
	 * PSA Container Booking I/F History 조회
	 * @param PsaBkgVO psaBkgVO
	 * @return PsaBkgVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgVO[] searchPSACNTRBKGHist(PsaBkgVO psaBkgVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaVvdVO> list = null;
		PsaBkgVO[] psaBkgVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaBkgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSACNTRBKGHistRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVO.class);
			if (list!=null && list.size() > 0) psaBkgVOs = list.toArray(new PsaBkgVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgVOs;
	}
	
	/**
	 * PSA Container Booking I/F Status Log 조회
	 * @param String bkgNo
	 * @param String psaSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSAStatusLog(String bkgNo, String psaSeq) throws DAOException
	{
		String statusLog = "";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no",  bkgNo);
			mapVO.put("bkg_seq", psaSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAStatusLogRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) statusLog = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return statusLog;		
	}

	/**
	 * EDI전송을 위해 Yard Code를 PSA Port로 Coversion을 위해 PSA Port조회
	 * @param String portCd
	 * @return PsaPortVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaPortVO[] searchPSAPortList(String portCd) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaPortVO> list = null;
		PsaPortVO[] psaPortVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", portCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAPortListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaPortVO.class);
			if (list!=null && list.size() > 0) psaPortVOs = list.toArray(new PsaPortVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaPortVOs;		
	}
	
	/**
	 * PSA Import Status Count 조회
	 * @param PsaTpVO psaTpVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSATpCnt(PsaTpVO psaTpVO) throws DAOException
	{
		String cnt = "0";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = psaTpVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSATpCntRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;			
	}
	
	/**
	 * PSA VSL Name과 Voyage Dir을 조회
	 * @param PsaVvdVO psaVvdVO
	 * @return PsaVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaVvdVO searchPSAVslNameDir(PsaVvdVO psaVvdVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaVvdVO> list = null;
		PsaVvdVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameDirRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaVvdVO.class);
			if (list!=null && list.size() > 0 ) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * PSA Import Status List조회
	 * @param PsaImpStsVO psaImpStsVO
	 * @return PsaImpStsVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaImpStsVO[] searchPSAImpStsInfoList(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaImpStsVO> list = null;
		PsaImpStsVO[] psaImpStsVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsInfoListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaImpStsVO.class);
			if (list!=null && list.size() > 0) psaImpStsVOs = list.toArray(new PsaImpStsVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaImpStsVOs;			
	}
	
	/**
	 * BKG에서 Add된 CNTR을 조회
	 * @param PsaAddVO psaAddVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchPSAAddCNTRList(PsaAddVO psaAddVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] cntrNOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaAddVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAAddCNTRListRSQL(),param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			cntrNOs = list.toArray(new String[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cntrNOs;			
	}
	
	/**
	 * searchAddCNTRList에서 추가된 정보에 대해서 BKG에서 PSA정보를 조회 (리스트)
	 * @param PsaImpStsAddVO psaImpStsAddVO
	 * @return PsaImpStsVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaImpStsVO[] searchPSAImpStsInfoAddList(PsaImpStsAddVO psaImpStsAddVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaImpStsVO> list = null;
		PsaImpStsVO[] psaImpStsVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaImpStsAddVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaImpStsVO.class);
			if (list!=null && list.size() > 0) psaImpStsVOs = list.toArray(new PsaImpStsVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaImpStsVOs;			
	}
	
	/**
	 * Container Validation Check
	 * @param String vslCd
	 * @param String voyNo
	 * @param String voyDir
	 * @param String cntrNo
	 * @return String 
	 * @exception DAOException
	 */
	public String searchCNTRCount(String vslCd, String voyNo, String voyDir, String cntrNo) throws DAOException
	{
		String cnt = "0";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", voyDir);
			mapVO.put("cntr_no", cntrNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCNTRCountRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;			
	}
	
	/**
	 * Vessel Count Validation Check
	 * @param String vslCd
	 * @param String voyNo
	 * @param String voyDir
	 * @return String 
	 * @exception DAOException
	 */
	public String searchVslCount(String vslCd, String voyNo, String voyDir) throws DAOException
	{
		String cnt = "0";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", voyNo);
			mapVO.put("skd_dir_cd", voyDir);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslCountRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;			
	}

	/**
	 * PSA Import Status 신규 Insert
	 * @param PsaImpStsVO psaImpStsVO
	 * @exception DAOException
	 */
	public void addPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPSAImpStsInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA Import Status Update
	 * @param PsaImpStsVO psaImpStsVO
	 * @exception DAOException
	 */
	public void modifyPSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPSAImpStsInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA Import Status 정보 삭제
	 * @param PsaImpStsVO psaImpStsVO
	 * @exception DAOException
	 */
	public void removePSAImpStsInfo(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePSAImpStsInfoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA Import Status Special Data를 삭제
	 * @param PsaImpStsVO psaImpStsVO
	 * @exception DAOException
	 */
	public void removePSAImpStsSpclInfo(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePSAImpStsSpclInfoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA Import Status Special Cargo의 정보를 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ImpStsSpclCgoVO searchPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAImpStsSpclCgoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpStsSpclCgoVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * PSA Import Status Special Cargo의 정보를 BKG과 Special Cargo 테이블에서 조회
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @return ImpStsSpclCgoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ImpStsSpclCgoVO searchBKGImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<ImpStsSpclCgoVO> list = null;
		ImpStsSpclCgoVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBKGImpStsSpclCgoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImpStsSpclCgoVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * PSA Import Status Special Cargo정보를 신규로 생성
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception DAOException
	 */
	public void addPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPSAImpStsSpclCgoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA Import Status Special Cargo정보를 수정
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception DAOException
	 */
	public void modifyPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPSAImpStsSpclCgoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA Import Status Special Cargo정보를 삭제
	 * @param ImpStsSpclCgoVO impStsSpclCgoVO
	 * @exception DAOException
	 */
	public void removePSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePSAImpStsSpclCgoDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA Data로 Flat File Header를 조회
	 * @param PsaHeadVO psaHeadVO
	 * @return PsaHeadVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaHeadVO searchPSAHeadFlatFile(PsaHeadVO psaHeadVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaHeadVO> list = null;
		PsaHeadVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaHeadVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAHeadFlatFileRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaHeadVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * PSA CNTR Information을 조회
	 * @param PsaCntrVO psaCntrVO
	 * @return PsaCntrVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaCntrVO[] searchPSACNTRInfoFlatFile(PsaCntrVO psaCntrVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaCntrVO> list = null;
		PsaCntrVO[] psaCntrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSACNTRInfoFlatFileRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaCntrVO.class);
			if (list!=null && list.size() > 0) psaCntrVOs = list.toArray(new PsaCntrVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaCntrVOs;			
	}
	
	/**
	 * PSA Import Status Send date를 기록한다.
	 * @param PsaImpStsVO psaImpStsVO
	 * @exception DAOException
	 */
	public void modifyPSAImpStsSndInfo(PsaImpStsVO psaImpStsVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaImpStsVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPSAImpStsSndInfoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}

	/**
	 * PSA PORT에 데이터가 기 존재하는지 여부 check
	 * @param String locCd
	 * @param String tmlCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchPSAPortExistChk(String locCd, String tmlCd) throws DAOException
	{
		String chk = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("loc_cd", locCd);
			mapVO.put("tml_cd", tmlCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAPortExistChkRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) chk = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return chk;
	}
	
	/**
	 * PSA Port에 대한 신규추가
	 * @param PsaPortVO psaPortVO
	 * @exception DAOException
	 */
	public void addPSAPortList(PsaPortVO psaPortVO) throws DAOException 
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPSAPortListCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * PSA Port  Update한다. Grid상에서 Row가 신규추가가 아니면서 화면상의 변경이 일어날 경우 modify한다.
	 * @param PsaPortVO psaPortVO
	 * @exception DAOException
	 */
	public void modifyPSAPortList(PsaPortVO psaPortVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPSAPortListUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA Port Data 삭제처리
	 * @param PsaPortVO psaPortVO
	 * @exception DAOException
	 */
	public void removePSAPortList(PsaPortVO psaPortVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaPortVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePSAPortListDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * ETD Date에  Relay Port를 경유하는 VVD조회
	 * 
	 * @param String portCd
	 * @param String etdDt
	 * @param String transTp
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchPSATsVVDList(String portCd, String etdDt, String transTp) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] vvds = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rly_port", portCd);
			mapVO.put("etd_dt", etdDt);
			mapVO.put("trans_tp_cd", transTp);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSATsVVDListRSQL(),param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			vvds = list.toArray(new String[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return vvds;				
	}
	
	/**
	 * VSL Name과 ETD를 구한다.
	 * @param String vslCd
	 * @param String voyCd
	 * @param String dirCd
	 * @param String portCd
	 * @return String 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public NameEtdVO searchPSAVslNameEtd(String vslCd, String voyCd, String dirCd, String portCd) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<NameEtdVO> list = null;
		NameEtdVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vslCd + voyCd + dirCd);
			mapVO.put("port_cd", portCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAVslNameEtdRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, NameEtdVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * NIS와 PSA가 Unmatch되는 CNTR List를 조회
	 * @param PsaUnmatchCNTRVO psaUnmatchCNTRVO
	 * @return CntrNoVO[]
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CntrNoVO[] searchUnmatchCNTRList(PsaUnmatchCNTRVO psaUnmatchCNTRVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<CntrNoVO> list = null;
		CntrNoVO[] cntrNoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaUnmatchCNTRVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchCNTRListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrNoVO.class);
			if (list!=null && list.size() > 0) cntrNoVOs = list.toArray(new CntrNoVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cntrNoVOs;			
	}
	
	/**
	 * searchUnmatchCNTRList에서 조회된 CNTR No를 인자값으로 하여 Unmatch된 BKG List를 조회
	 * @param PsaUnmatchBKGVO psaUnmatchBKGVO
	 * @return PsaUnmatchBKGVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaUnmatchBKGVO searchUnmatchBKGList(PsaUnmatchBKGVO psaUnmatchBKGVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaUnmatchBKGVO> list = null;
		PsaUnmatchBKGVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaUnmatchBKGVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchBKGListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchBKGVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * searchUnmatchBKGList에서 special Dg Cargo 가 있을 경우(=> spe_dg_ind = '1') 상세정보 조회
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String 
	 * @exception DAOException
	 */
	public String searchPSADGDetailInfo(String bkgNo, String cntrNo) throws DAOException
	{
		String dgDetail = "";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no",  bkgNo );
			mapVO.put("cntr_no", cntrNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSADGDetailInfoRSQL(), param, velParam);
			
			StringBuffer dgDetailBu = new StringBuffer();
			if (dbRowset!=null) {
				while(dbRowset.next()) {
					if (dgDetailBu.length() > 0) dgDetailBu.append(",");
					dgDetailBu.append(dbRowset.getString(1));					
				}
			}
			dgDetail = dgDetailBu.toString();
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return dgDetail;		
	}
	
	/**
	 * searchUnmatchCNTRList에서 조회된 CNTR No를 인자값으로 하여 Unmatch PSA List를 조회
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @return BkgCstmsPsaCntrChkVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsPsaCntrChkVO searchUnmatchPSAList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<BkgCstmsPsaCntrChkVO> list = null;
		BkgCstmsPsaCntrChkVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchPSAListRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsPsaCntrChkVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * Unmatch하는 BKG CNTR정보를 조회한다. (ALPS 탭 Grid)
	 * @param PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO
	 * @return PsaUnmatchBkgCntrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaUnmatchBkgCntrVO[] searchUnmatchBkgCntrList(PsaUnmatchBkgCntrVO psaUnmatchBkgCntrVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaUnmatchBkgCntrVO> list = null;
		PsaUnmatchBkgCntrVO[] psaUnmatchBkgCntrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaUnmatchBkgCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchBkgCntrListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchBkgCntrVO.class);
			if (list!=null && list.size() > 0) psaUnmatchBkgCntrVOs = list.toArray(new PsaUnmatchBkgCntrVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaUnmatchBkgCntrVOs;		
	}
	
	/**
	 * Unmatch하는 PSA CNTR List를 조회한다. (PSA 탭 Grid)
	 * @param PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO
	 * @return PsaUnmatchPsaCntrVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaUnmatchPsaCntrVO[] searchUnmatchPSACntrList(PsaUnmatchPsaCntrVO psaUnmatchPsaCntrVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaUnmatchPsaCntrVO> list = null;
		PsaUnmatchPsaCntrVO[] psaUnmatchPsaCntrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = psaUnmatchPsaCntrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUnmatchPSACntrListRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaUnmatchPsaCntrVO.class);
			if (list!=null && list.size() > 0) psaUnmatchPsaCntrVOs = list.toArray(new PsaUnmatchPsaCntrVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaUnmatchPsaCntrVOs;	
	}
	
	/**
	 * Vessel SKD에 등록되어있는지 여부 확인
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchVslSkdValid(String vvd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String valid = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchVslSkdValidRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				valid = dbRowset.getString(1);
			}
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return valid;
	}
	
	/**
	 * VVD + Relay Port에 해당하는 Data Delete
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @exception DAOException
	 */
	public void removeUnmatchPSAList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremoveUnmatchPSAListDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * Un Code로 들어오는 Location은 NIS Code로 Coversion 하기 위한 체크
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCodeConvLoc(String locCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String valid = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", locCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCodeConvLocRSQL(),param, velParam);
			if (dbRowset!=null &&	dbRowset.next()) valid = dbRowset.getString(1);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return valid;
	}
	
	/**
	 * Un Code로 들어오는 Location은 NIS Code로 Coversion
	 * @param String unLocCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCodeConvUNLoc(String unLocCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String locCd = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("port_cd", unLocCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCodeConvUNLocRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				locCd = dbRowset.getString(1);
			}
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return locCd;
	}
	
	/**
	 * PSA List 추가
	 * @param BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO
	 * @exception DAOException
	 */
	public void addUnmatchPsaList(BkgCstmsPsaCntrChkVO bkgCstmsPsaCntrChkVO) throws DAOException 
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgCstmsPsaCntrChkVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddUnmatchPsaListCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * 사용자 이름 조회 
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchComUser(String usrId) throws DAOException {
		
		DBRowSet dbRowset = null;
		String usrNm = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchComUserRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				usrNm = dbRowset.getString(1);
			}
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return usrNm;
	}
	
	/**
	 * PSA Interface 정보 조회
	 * @param String bkgNo
	 * @return PsaBkgIfVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgIfVO[] searchPSAIFInfo(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgIfVO> list = null;
		PsaBkgIfVO[] psaBkgIfVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSAIFInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgIfVO.class);
			if (list!=null && list.size() > 0) psaBkgIfVOs = list.toArray(new PsaBkgIfVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgIfVOs;	
	}		
	
	/**
	 * PSA Interface 최종 정보 조회
	 * @param String bkgNo
	 * @return PsaBkgIfVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgIfVO[] searchPSAIFInfoLast(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgIfVO> list = null;
		PsaBkgIfVO[] psaBkgIfVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOSearchPSAIFInfoLastRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgIfVO.class);
			if (list!=null && list.size() > 0) psaBkgIfVOs = list.toArray(new PsaBkgIfVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgIfVOs;	
	}
	
	/**
	 * PSAIFInfo 에서 조회값이 없을 경우 PSA Interface 재조회
	 * @param String bkgNo
	 * @return PsaBkgIfVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgIfVO[] searchPSABKGIFInfo(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgIfVO> list = null;
		PsaBkgIfVO[] psaBkgIfVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPSABKGIFInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgIfVO.class);
			if (list!=null && list.size() > 0) psaBkgIfVOs = list.toArray(new PsaBkgIfVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgIfVOs;		
	}
	
	/**
	 * BKG VVD 에서 POL이 SSN 인 Vessel 정보 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgNewVvd(String bkgNo) throws DAOException
	{
		String newVvd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgNewVvdRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) newVvd = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return newVvd;
	}
	
	/**
	 * PSA BKG 테이블의 SEQ+1 값 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgMaxSeqPls(String bkgNo) throws DAOException
	{
		String pbSeq = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgMaxSeqPlsRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) pbSeq = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return pbSeq;
	}
	
	/**
	 * PSA BKG OLD VVD 조회
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgOldVvd(String bkgNo, String pbSeq) throws DAOException
	{
		String oldVvd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("pb_seq", pbSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgOldVvdRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) oldVvd = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return oldVvd;
	}
	
	/**
	 * PSA I/F BKG Code 를 D로 변경
	 * 
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void modifyPsaBkgIFCdD(String bkgNo) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgIFCdDUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * PSA I/F Container Code 를 D로 변경
	 * 
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrIFCdD(String bkgNo) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrIFCdDUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 *  PSA I/F RlseOrd Code 를 D로 변경
	 *  
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void modifyPsaBkgRlseOrdIFCd(String bkgNo) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgRlseOrdIFCdUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * ALPS 데이터로 PSA 데이터 생성
	 * 
	 * @param String bkgNo
	 * @return BkgDataVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgDataVO searchBkgDataForPsaBkg(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<BkgDataVO> list = null;
		BkgDataVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgDataForPsaBkgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgDataVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * BLock Stowage Code 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBlckStwgCd(String bkgNo) throws DAOException
	{
		String blckStwgCd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBlckStwgCdRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) blckStwgCd = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return blckStwgCd;
	}
	
	/**
	 * BKG VVD 에서 Vessel 정보 조회
	 * 
	 * @param String bkgNo
	 * @param String polCd
	 * @return BkgVvdInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdInfoVO searchBkgVvdInfo(String bkgNo, String polCd) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<BkgVvdInfoVO> list = null;
		BkgVvdInfoVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("pol_cd", polCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdInfoVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * POD 정보 조회
	 * 
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgVvdPodCd(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		String[] pods = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try
		{
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdPodCdRSQL(),param, velParam);
			while(dbRowset.next()) list.add(dbRowset.getString(1));
			pods = list.toArray(new String[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return pods;				
	}
	
	/**
	 * Shipper name 조회
	 * 
	 * @param String bkgNo
	 * @return PsaShprVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaShprVO searchShprName(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaShprVO> list = null;
		PsaShprVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchShprNameRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaShprVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;		
	}
	
	/**
	 * BKG_STS_CD가 'X'가 아닐 경우 해당 파라미터에 'U'를 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchUpdatePsaIFCd(String bkgNo) throws DAOException
	{
		String updateCd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchUpdatePsaIFCdRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) updateCd = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return updateCd;
	}
	
	/**
	 * PSA BKG 테이블에 데이터 추가
	 * 
	 * @param PsaBkgInfoVO psaBkgInfoVO
	 * @throws DAOException
	 */
	public void addPsaBkgInfo(PsaBkgInfoVO psaBkgInfoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaBkgInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * BKG Quantity 정보 조회
	 * 
	 * @param String bkgNo
	 * @return PsaBkgQtyVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgQtyVO[] searchBkgQtyInfo(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgQtyVO> list = null;
		PsaBkgQtyVO[] psaBkgQtyVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try
		{
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgQtyInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgQtyVO.class);
			if (list!=null && list.size() > 0) psaBkgQtyVOs = list.toArray(new PsaBkgQtyVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgQtyVOs;			
	}
	
	/**
	 * Reefer Cargo 정보 조회
	 * 
	 * @param PsaRfCgoVO psaRfCgoVO
	 * @return PsaRfCgoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaRfCgoVO[] searchRfCgoInfo(PsaRfCgoVO psaRfCgoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaRfCgoVO> list = null;
		PsaRfCgoVO[] psaRfCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			// Map VO
			Map<String, String> mapVO = psaRfCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchRfCgoInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaRfCgoVO.class);
			if (list!=null && list.size() > 0) psaRfCgoVOs = list.toArray(new PsaRfCgoVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaRfCgoVOs;
	}
	
	/**
	 * Awkward Cargo Info 조회
	 * 
	 * @param PsaAwkCgoVO psaAwkCgoVO
	 * @return PsaAwkCgoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaAwkCgoVO[] searchAwkCgoInfo(PsaAwkCgoVO psaAwkCgoVO) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaAwkCgoVO> list = null;
		PsaAwkCgoVO[] psaAwkCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			// Map VO
			Map<String, String> mapVO = psaAwkCgoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchAwkCgoInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaAwkCgoVO.class);
			if (list!=null && list.size() > 0) psaAwkCgoVOs = list.toArray(new PsaAwkCgoVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaAwkCgoVOs;
	}
	
	/**
	 * PSA Serial No 조회
	 * 
	 * @param PsaSrlNoVO psaSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaSerialNo(PsaSrlNoVO psaSrlNoVO) throws DAOException
	{
		String serialNo = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			// Map VO
			Map<String, String> mapVO = psaSrlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaSerialNoRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return serialNo;
	}
	
	/**
	 * PSA BKG CNTR 테이블에 CNTR Count정보를 update
	 * 
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrCnt(PsaCntrCntVO psaCntrCntVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrCntUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA BKG CNTR 테이블의 Serial No에 +1을 한 값을 조회
	 * 
	 * @param String bkgNo
	 * @param String seq
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgCntrMaxSerialNoPls(String bkgNo, String seq) throws DAOException
	{
		String serialNo = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", seq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrMaxSerialNoPlsRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return serialNo;
	}
	
	/**
	 * PSA BKG CNTR 테이블에 데이터 INSERT
	 * 
	 * @param PsaBkgCntrInfoVO PsaBkgCntrInfoVO
	 * @throws DAOException
	 */
	public void addPsaBkgCntrInfo(PsaBkgCntrInfoVO PsaBkgCntrInfoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = PsaBkgCntrInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgCntrInfoCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA RELEASE ORDER Table의 SUB PSA SERIAL NUMBER 를 조회
	 * 
	 * @param PsaSubSrlNoVO PsaSubSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubPsaSerialNo(PsaSubSrlNoVO PsaSubSrlNoVO) throws DAOException
	{
		String serialNo = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			// Map VO
			Map<String, String> mapVO = PsaSubSrlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchSubPsaSerialNoRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return serialNo;		
	}
	
	/**
	 * PSA_RLSE_ORD 테이블의 CONTAINER QUANTITY에 +1을 update
	 * 
	 * @param PsaRoCntrQtyVO psaRoCntrQtyVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgRoCntrQty(PsaRoCntrQtyVO psaRoCntrQtyVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRoCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgRoCntrQtyUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA RELEASE ORDER Table의 MAX SUB PSA SERIAL NUMBER +1 를 조회
	 * 
	 * @param PsaMaxSubSrlNoVO psaMaxSubSrlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSubPsaMaxSerialNo(PsaMaxSubSrlNoVO psaMaxSubSrlNoVO) throws DAOException
	{
		String serialNo = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			// Map VO
			Map<String, String> mapVO = psaMaxSubSrlNoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchSubPsaMaxSerialNoRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) serialNo = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return serialNo;			
	}
	
	/**
	 * PSA RELEASE ORDER 테이블에 Insert
	 * 
	 * @param PsaBkgRlsOrdVO psaBkgRlsOrdVO
	 * @throws DAOException
	 */
	public void addPsaBkgRlsOrd(PsaBkgRlsOrdVO psaBkgRlsOrdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaBkgRlsOrdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgRlsOrdCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * PSA BKG CNTR의 CNTR Count를 조회
	 *  
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String psaSerNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgCntrCnt(String bkgNo, String bkgSeq, String psaSerNo) throws DAOException
	{
		String cnt = "0";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("psa_ser_no", psaSerNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrCntRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;		
	}
	
	/**
	 * PSA CNTR CNT 가 6 이상인 경우 UPDATE 처리
	 * 
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrCntOverSix(PsaCntrCntVO psaCntrCntVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrCntOverSixUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			
	}
	
	/**
	 * ADD SEQ 값을 더해 SERIAL UPDATE
	 * 
	 * @param PsaSerNoVO psaSerNoVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrSerialNo(PsaSerNoVO psaSerNoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrSerialNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA Release Order 에 ADD SEQ 값을 더해 SERIAL UPDATE
	 * 
	 * @param PsaRlsOrdSerNoVO psaRlsOrdSerNoVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgRlsOrdSerialNo(PsaRlsOrdSerNoVO psaRlsOrdSerNoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsOrdSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgRlsOrdSerialNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA BKG CNTR의 NEW Count 를 ADD
	 * 
	 * @param PsaBkgCntrNewVO psaBkgCntrNewVO
	 * @throws DAOException
	 */
	public void addPsaBkgCntrNewCnt(PsaBkgCntrNewVO psaBkgCntrNewVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaBkgCntrNewVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgCntrNewCntCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA BKG Release Order에서 CNTR Qty값 조회
	 * 
	 * @param PsaRlsOrdQtyVO psaRlsOrdQtyVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaBkgRlsOrdQty(PsaRlsOrdQtyVO psaRlsOrdQtyVO) throws DAOException
	{
		String cnt = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			// Map VO
			Map<String, String> mapVO = psaRlsOrdQtyVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdQtyRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) cnt = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cnt;		
	}
	
	/**
	 * PSA Release Order의 CNTR Qty를 update
	 * @param PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgRlsOrdCntrQty(PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsOrdCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgRlsOrdCntrQtyUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pbr_qty > pbr_qty_rest 일 경우 PSA Release Order테이블에 새로 Insert
	 * 
	 * @param PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO
	 * @throws DAOException
	 */
	public void addPsaBkgRlsOrdCntrQty(PsaRlsOrdCntrQtyVO psaRlsOrdCntrQtyVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsOrdCntrQtyVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgRlsOrdCntrQtyCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA Release Order테이블의 Sub serial No칼럼을 update
	 * 
	 * @param PsaRlsOrdSubSerNoVO psaRlsOrdSubSerNoVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgRlsOrdSubSerialNo(PsaRlsOrdSubSerNoVO psaRlsOrdSubSerNoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsOrdSubSerNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgRlsOrdSubSerialNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * BKG Quantity 테이블에서 CNTR TPSZ와 QTY 조회
	 * @param String bkgNo
	 * @return PsaBkgQtyVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgQtyVO[] searchBkgQtyCntrTpSzQty(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgQtyVO> list = null;
		PsaBkgQtyVO[] psaBkgQtyVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgQtyCntrTpSzQtyRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgQtyVO.class);
			if (list!=null && list.size() > 0) psaBkgQtyVOs = list.toArray(new PsaBkgQtyVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgQtyVOs;		
	}
	
	/**
	 * PSA BKG Release Order와 CNTR에서 정보를 조회
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @param String cntrTpSz
	 * @return PsaBkgRlsOrdCntrVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgRlsOrdCntrVO[] searchPsaBkgRlsOrdCntrInfo(String bkgNo, String pbSeq, String cntrTpSz) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrVO> list = null;
		PsaBkgRlsOrdCntrVO[] psaBkgRlsOrdCntrVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			mapVO.put("cntr_tpsz_cd", cntrTpSz);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrVOs = list.toArray(new PsaBkgRlsOrdCntrVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgRlsOrdCntrVOs;	
	}
	
	/**
	 * CNTR 및 Special cargo정보를 조회
	 * 
	 * @param String bkgNo
	 * @param String cntrTpsz
	 * @return CntrSpeCgoVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CntrSpeCgoVO[] searchCntrSpeCgoInfo(String bkgNo, String cntrTpsz) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<CntrSpeCgoVO> list = null;
		CntrSpeCgoVO[] cntrSpeCgoVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_tpsz_cd", cntrTpsz);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchCntrSpeCgoInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSpeCgoVO.class);
			if (list!=null && list.size() > 0) cntrSpeCgoVOs = list.toArray(new CntrSpeCgoVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cntrSpeCgoVOs;			
	}
	
	/**
	 * PSA BKG CNTR NO 6개 조회
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String psaSerNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPsaBkgCntrNo(String bkgNo, String bkgSeq, String psaSerNo) throws DAOException
	{
		String[] cntrNos = new String[6];
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("psa_ser_no", psaSerNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrNoRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				for (int i=0; i < 6; i++) cntrNos[i] = dbRowset.getString(i+1);
			}
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return cntrNos;
	}

	/**
	 * PSA BKG CNTR_NO 정보 UPDATE
	 * 
	 * @param PsaCntrNoVO psaCntrNoVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrNo(PsaCntrNoVO psaCntrNoVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrNoUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA BKG VSL Info 조회
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgVslVO searchPsaBkgVslInfo(String bkgNo, String pbSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgVslVO> list = null;
		PsaBkgVslVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgVslInfoRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVslVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * [vvd_unchanged용]PSA BKG VSL Info를 조회하여 flat file로 만든다.
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgVslVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgVslVO searchPsaBkgVslInfoForUnchg(String bkgNo, String pbSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgVslVO> list = null;
		PsaBkgVslVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgVslInfoForUnchgRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgVslVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;			
	}
	
	/**
	 * PSA BKG CNTR로 flat file을 만들기 위해 조회
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return PsaBkgCntrFlatVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgCntrFlatVO[] searchPsaBkgCntrInfo(String bkgNo, String bkgSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgCntrFlatVO> list = null;
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrInfoRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgCntrFlatVO.class);
			if (list!=null && list.size() > 0) psaBkgCntrFlatVOs = list.toArray(new PsaBkgCntrFlatVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgCntrFlatVOs;
	}
	
	/**
	 * [vvd_unchanged용]PSA BKG CNTR로 flat file을 만들기 위해 조회
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return PsaBkgCntrFlatVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgCntrFlatVO[] searchPsaBkgCntrInfoForUnchg(String bkgNo, String bkgSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgCntrFlatVO> list = null;
		PsaBkgCntrFlatVO[] psaBkgCntrFlatVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgCntrInfoForUnchgRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgCntrFlatVO.class);
			if (list!=null && list.size() > 0) psaBkgCntrFlatVOs = list.toArray(new PsaBkgCntrFlatVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgCntrFlatVOs;
	}
	
	/**
	 * PSA BKG Release Order의 CNTR Type size조회
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgRlsOrdCntrTpszVO[] searchPsaBkgRlsOrdCntrTpsz(String bkgNo, String pbSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrTpszVO> list = null;
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrTpszVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrTpszVOs = list.toArray(new PsaBkgRlsOrdCntrTpszVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgRlsOrdCntrTpszVOs;
	}
	
	/**
	 * [vvd_unchanged용]PSA BKG Release Order의 CNTR Type size조회
	 * 
	 * @param String bkgNo
	 * @param String pbSeq
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgRlsOrdCntrTpszVO[] searchPsaBkgRlsOrdCntrTpszForUnchg(String bkgNo, String pbSeq) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgRlsOrdCntrTpszVO> list = null;
		PsaBkgRlsOrdCntrTpszVO[] psaBkgRlsOrdCntrTpszVOs = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", pbSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaBkgRlsOrdCntrTpszForUnchgRSQL(),param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgRlsOrdCntrTpszVO.class);
			if (list!=null && list.size() > 0) psaBkgRlsOrdCntrTpszVOs = list.toArray(new PsaBkgRlsOrdCntrTpszVO[0]);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return psaBkgRlsOrdCntrTpszVOs;
	}
	
	/**
	 * PSA BKG에 Send Date와 ACK RECEIVE STATUS CODE를 update
	 * 
	 * @param PsaSndDtVO psaSndDtVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgSndDt(PsaSndDtVO psaSndDtVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaSndDtVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgSndDtUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [vvd_unchanged용]PSA BKG CNTR 테이블에 CNTR Count정보를 update
	 * 
	 * @param PsaCntrCntVO psaCntrCntVO
	 * @throws DAOException
	 */
	public void modifyPsaBkgCntrCntForUnchg(PsaCntrCntVO psaCntrCntVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrCntVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaBkgCntrCntForUnchgUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Yard Assign By CNTR Booking 데이터 INSERT
	 * 
	 * @param PsaBkgForYardVO psaBkgForYardVO
	 * @throws DAOException
	 */
	public void addPsaBkgForYardCd(PsaBkgForYardVO psaBkgForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaBkgForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaBkgForYardCdCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Yard Assign By CNTR Container 데이터 INSERT
	 * 
	 * @param PsaCntrForYardVO psaCntrForYardVO
	 * @throws DAOException
	 */
	public void addPsaCntrForYardCd(PsaCntrForYardVO psaCntrForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaCntrForYardCdCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Yard Assign By CNTR Release Order 데이터 INSERT
	 * 
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException
	 */
	public void addPsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOaddPsaRlsOrdForYardCdCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Yard Assign By CNTR화면에서 Grid의 P/UP CY를 수정
	 * 
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException
	 */
	public void modifyPsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOmodifyPsaRlsOrdForYardCdUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA Yard Container 삭제
	 * 
	 * @param PsaCntrForYardVO psaCntrForYardVO
	 * @throws DAOException
	 */
	public void removePsaCntrForYardCd(PsaCntrForYardVO psaCntrForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaCntrForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePsaCntrForYardCdDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA Yard Relase Order 삭제
	 * 
	 * @param PsaRlsForYardVO psaRlsForYardVO
	 * @throws DAOException
	 */
	public void removePsaRlsOrdForYardCd(PsaRlsForYardVO psaRlsForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaRlsForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePsaRlsOrdForYardCdDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PSA Yard Booking 정보 삭제
	 * 
	 * @param PsaBkgForYardVO psaBkgForYardVO
	 * @throws DAOException
	 */
	public void removePsaBkgForYardCd(PsaBkgForYardVO psaBkgForYardVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = psaBkgForYardVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new PSAManifestDBDAOremovePsaBkgForYardCdDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Max bkg_seq를 구해서 add할때 Max+1한 값을 BKG_SEQ에 넣어준다.
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchPsaMaxBkgSeq(String bkgNo) throws DAOException
	{
		String maxSeq = "0";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchPsaMaxBkgSeqRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) maxSeq = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return maxSeq;
	}
	
	/**
	 * Booking VVD Info 조회
	 * 
	 * @param String bkgNo
	 * @return PsaBkgvvdInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaBkgvvdInfoVO searchBkgVvdInfoForPsa(String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaBkgvvdInfoVO> list = null;
		PsaBkgvvdInfoVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgVvdInfoForPsaRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaBkgvvdInfoVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;
	}
	
	/**
	 * Import선택시 Next POD, Next VVD를 조회
	 * 
	 * @param String vvdCd
	 * @param String bkgNo
	 * @return PsaNextVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public PsaNextVO searchNextPodVvdForImport(String vvdCd, String bkgNo) throws DAOException
	{
		DBRowSet dbRowset = null;
		List<PsaNextVO> list = null;
		PsaNextVO outVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		try
		{
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("vvd", vvdCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchNextPodVvdForImportRSQL(), param, velParam);
			if (dbRowset!=null) list = (List)RowSetUtil.rowSetToVOs(dbRowset, PsaNextVO.class);
			if (list!=null && list.size() > 0) outVO = list.get(0);
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return outVO;
	}
	
	/**
	 * Import의 경우 NextPod, Next VVD조회를 위해 BKG No를 조회
	 * @param String vvdCd
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgNoForNextPodVvd(String vvdCd, String cntrNo) throws DAOException
	{
		String bkgNo = "";
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("vvdCd", 	vvdCd);
			mapVO.put("cntrNo", cntrNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgNoForNextPodVvdRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) bkgNo = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return bkgNo;
	}
	
	/**
	 * BKG CNTR Type Size 와 Qty 정보 조회
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgCntrTpSzQty(String bkgNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String bkgQty = "";
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgCntrTpSzQtyRSQL(),param, velParam);
			if (dbRowset!=null && dbRowset.next()) {
				bkgQty = dbRowset.getString(1);
			}
		} 
		catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgQty;
	}
	
    /**
     * CSTMS_PSA_IMP_STS_SPCL PK 체크<br>
     * 
     * @param ImpStsSpclCgoVO impStsSpclCgoVO 
     * @return Integer
     * @exception DAOException
     */
	public int searchPKPSAImpStsSpclCgo(ImpStsSpclCgoVO impStsSpclCgoVO) throws DAOException {
    	DBRowSet dbRowset = null;
        int cnt = 0;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if(impStsSpclCgoVO != null){
	            Map<String, String> mapVO = impStsSpclCgoVO.getColumnValues();	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}  
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new PSAManifestDBDAOsearchPKPSAImpStsSpclCgoRSQL(), param, velParam);
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
	 * EDI 추가 전송을 위한 BKG MTY_PKUP_YD_CD 조회
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgMtyPkupYdCdForPsa(String bkgNo) throws DAOException
	{
		String mtyPkupYdCd = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// Map VO
		Map<String, String> mapVO = new HashMap<String, String>();
		
		try {
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PSAManifestDBDAOsearchBkgMtyPkupYdCdForPsaRSQL(),param, velParam);
			
			if (dbRowset!=null && dbRowset.next()) mtyPkupYdCd = dbRowset.getString(1);
			
		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return mtyPkupYdCd;
	}
}