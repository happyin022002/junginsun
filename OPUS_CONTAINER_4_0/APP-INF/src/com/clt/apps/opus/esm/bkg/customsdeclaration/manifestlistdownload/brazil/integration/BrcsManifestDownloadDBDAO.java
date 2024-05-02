/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAO.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.04.30 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCmModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCnpiNcmByCntrModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS CndManifestListDownloadDBDAO <br>
 * - OPUS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyoung Jong Yun
 * @see CndManifestListDownloadBCImpl 참조
 * @since J2EE 1.4
 */
public class BrcsManifestDownloadDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * BrcsManifestDownloadDBDAO 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Vessel 정보조회 <br>
	 * 
	 * @param BrHsCdCondVO  brHsCdCondVO
	 * @return List<BrHsCdDetailVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BrHsCdDetailVO> searchHsCdList(BrHsCdCondVO  brHsCdCondVO) throws DAOException {
		 
		List<BrHsCdDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(brHsCdCondVO != null){
				Map<String, String> mapVO = brHsCdCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new BrcsManifestDownloadDBDAOsearchHsCdListRSQL(), param, velParam, BrHsCdDetailVO.class);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return list;
	}
	 
	 /**
	  * Brazil세관에서 대상 조회를 한다.
	  * 
	  * @param BrManifestListCondVO brManifestListCondVO
	  * @param SignOnUserAccount account
	  * @return List<ManifestListDetailVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<ManifestListDetailVO> searchBrManifestList(BrManifestListCondVO brManifestListCondVO, SignOnUserAccount account) throws DAOException {
	 
			List<ManifestListDetailVO> list = null;
			brManifestListCondVO.setUpdUsrId(account.getUpd_usr_id());
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(brManifestListCondVO != null){
					Map<String, String> mapVO = brManifestListCondVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new BrcsManifestDownloadDBDAOsearchBrManifestListRSQL(), param, velParam, BrManifestListDetailVO.class);
				
			} catch (SQLException se) {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
			return list;
	 }
	 
	 /**
	  * OB쪽 정보를 세관쪽 테이블로 저장한다.BL관련 정보를 저장한다.(BKG_CSTMS_BRZ_BL) <br>
	  * 
	  * @param List<BrCmModiVO> brCmModiVOs 
	  * @throws DAOException
	  */
	 public void addBrBl(List<BrCmModiVO> brCmModiVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brCmModiVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOaddBrBlCSQL(), brCmModiVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 

	 /**
	  * OB쪽 정보를 세관쪽 테이블로 저장한다.컨테이너관련 정보를 저장한다. (BKG_CSTMS_BRZ_CNTR_MF)<Br>
	  * @param List<BrCmModiVO> brCmModiVOs
	  * @throws DAOException
	  */
	 public void addBrCM(List<BrCmModiVO> brCmModiVOs ) throws DAOException {
		 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brCmModiVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOaddBrCMCSQL(), brCmModiVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }

	 
	 /**
	  * MAIN쪽 정보를 세관쪽 테이블로 저장한다.컨테이너 MF DTL 관련 정보를 저장한다. (BKG_CSTMS_BRZ_CNTR_MF_DTL)<Br>
	  * @param List<BrCmModiVO> brCmModiVOs
	  * @throws DAOException
	  */
	 public void addBrCMDtl(List<BrCmModiVO> brCmModiVOs ) throws DAOException {
		 
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brCmModiVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOaddBrCMDtlCSQL(), brCmModiVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 
	 
	 /**
	  * 세관쪽 BL관련 정보를 삭제한다.(BKG_CSTMS_BRZ_BL) <br>
	  * @param List<BrCmModiVO> brCmModiVOs
	  * @throws DAOException
	  */
	 public void removeBrBl(List<BrCmModiVO> brCmModiVOs ) throws DAOException {
		 
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				
				if(brCmModiVOs.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOdelBrBlDSQL(), brCmModiVOs, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	  * 세관쪽 컨테이너관련 정보를 삭제한다. (BKG_CSTMS_BRZ_CNTR_MF) <br>
	  * @param List<BrCmModiVO> brCmModiVOs
	  * @throws DAOException
	  */
	 public void removeBrCM(List<BrCmModiVO> brCmModiVOs ) throws DAOException {

			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				
				if(brCmModiVOs.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOdelBrCMDSQL(), brCmModiVOs, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	  * 세관쪽 컨테이너 MF DTL 관련  정보를 삭제한다. (BKG_CSTMS_BRZ_CNTR_MF_DTL) <br>
	  * @param List<BrCmModiVO> brCmModiVOs
	  * @throws DAOException
	  */
	 public void removeBrCMDtl(List<BrCmModiVO> brCmModiVOs ) throws DAOException {

			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				
				if(brCmModiVOs.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOremoveBrCMDtlDSQL(), brCmModiVOs, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	  * 세관쪽 BL관련 정보를 업데이트한다. (BKG_CSTMS_BRZ_BL) <br>
	  * @param List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs
	  * @throws DAOException
	  */
	 public void modifyCnpjNcmByBl(List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs ) throws DAOException {
		 
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				
				if(brCnpiNcmByCntrModiVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOmodifyCnpjNcmByBlUSQL(), brCnpiNcmByCntrModiVOs, null);
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
	  * 세관쪽 컨테이너관련 정보를 업데이트한다. (BKG_CSTMS_BRZ_CNTR_MF) <Br>
	  * @param List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs 
	  * @throws DAOException
	  */
	 public void modifyCnpjNcmByCntr(List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs  ) throws DAOException {
		 
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				
				if(brCnpiNcmByCntrModiVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOmodifyCnpjNcmByCntrUSQL(), brCnpiNcmByCntrModiVOs, null);
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
	  * Container Manifest NCM Detail을 추가한다.
	  * @param List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs
	  * @throws DAOException
	  */
	 public void addBrzCntrMfNcmDtl(List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs  ) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				
				if(brCnpiNcmByCntrModiVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOAddBrzCntrMfNcmDtlCSQL(), brCnpiNcmByCntrModiVOs, null);
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
	  * Container Manifest NCM Detail을 삭제한다.
	  * @param List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs
	  * @throws DAOException
	  */
	 public void removeBrzCntrMfNcmDtl(List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVOs  ) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				
				if(brCnpiNcmByCntrModiVOs.size() > 0) {
					delCnt = sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAORemoveBrzCntrMfNcmDtlDSQL(), brCnpiNcmByCntrModiVOs, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	  *  HS CODE 를 입력한다. <br>
	  * 
	  * @param List<BrHsCdDetailVO> brHsCdDetailVOs 
	  * @throws DAOException
	  */
	 public void addHSCode(List<BrHsCdDetailVO> brHsCdDetailVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brHsCdDetailVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOaddHSCodeCSQL(), brHsCdDetailVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 /**
	  *  HS CODE 를 수정한다. <br>
	  * 
	  * @param List<BrHsCdDetailVO> brHsCdDetailVOs 
	  * @throws DAOException
	  */
	 public void modifyHSCode(List<BrHsCdDetailVO> brHsCdDetailVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brHsCdDetailVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOmodifyHSCodeUSQL(), brHsCdDetailVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 /**
	  *  HS CODE 를 삭제 flag를 업데이트한다. <br>
	  * 
	  * @param List<BrHsCdDetailVO> brHsCdDetailVOs 
	  * @throws DAOException
	  */
	 public void removeHSCode(List<BrHsCdDetailVO> brHsCdDetailVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(brHsCdDetailVOs.size() > 0) {
				sqlExe.executeBatch((ISQLTemplate)new BrcsManifestDownloadDBDAOremoveHSCodeDSQL(), brHsCdDetailVOs, null);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }

}
