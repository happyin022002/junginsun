/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrregularManageDBDAO.java
*@FileTitle : Irregular Creation & Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.28 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAOAddUSGuaranteeCntrListCSQL;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAODeleteUSGuaranteeCntrListDSQL;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.basic.IrregularManageBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchGuaranteeIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularCntrListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularHdrVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.vo.SearchIrregularListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesIrrHdrVO;


/**
 * IrregularManageDBDAO <br>
 * GuaranteeManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see IrregularManageBCImpl 참조
 * @since J2EE 1.6
 */
public class IrregularManageDBDAO extends DBDAOSupport {

	
	/**
	 * [Irregular Header] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIrregularHdrVO> searchIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIrregularHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(tesIrrHdrVO != null){
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//log.info("[IrregularManageDBDAO][searchIrregularHdr][] >>>>>>>>>>>>>>>>>>>>>>> tesIrrHdrVO = " + tesIrrHdrVO);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchIrregularHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * [Irregular Header Max Seq] 정보를 [Select] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchIrregularHdrSeq(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String		irrNo		= "";
		try{
			if( !"".equals(ofcCd) ) { 
				param.put("ofc_cd", ofcCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchIrregularHdrSeqRSQL(), param, velParam);
			
			if ( dbRowset != null && dbRowset.next() ) {
				irrNo	= dbRowset.getString("IRR_NO");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return irrNo;
	}
	 
	
	/**
	 * [Irregular Header] 정보를 [Insert] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
			
			param	.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new IrregularManageDBDAOAddIrregularHdrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Irregular Header] 정보를 [Update] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int modifyIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
//			if ( tesIrrHdrVO != null ) {
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
//			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new IrregularManageDBDAOModifyIrregularHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [Irregular Header] 정보를 [Delete] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeIrregular(TesIrrHdrVO tesIrrHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if ( tesIrrHdrVO != null ) {
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new IrregularManageDBDAORemoveIrregularUSQL(), param, velParam);
			if( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [Irregular Container List]을 [Select] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIrregularCntrListVO> searchIrregularCntrList(TesIrrHdrVO tesIrrHdrVO) throws DAOException {
		DBRowSet				dbRowset	= null;
		List<SearchIrregularCntrListVO>	list		= null;
		
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
	
		try{
			
			if(tesIrrHdrVO != null){
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//log.info("[IrregularManageDBDAO][searchIrregularCntrList][] >>>>>>>>>>>>>>>>>>>>>>> tesIrrHdrVO = " + tesIrrHdrVO);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchIrregularCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularCntrListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [Irregular Container List Max Sequence] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchIrregularCntrListSeq(TesIrrHdrVO tesIrrHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int		maxSeq	= 1;
		
		try{
			if( !"".equals( tesIrrHdrVO.getGnteNo() ) ) {
				param.put("gnte_no", tesIrrHdrVO.getGnteNo() );
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GuaranteeManageDBDAOSearchUSGuaranteeCntrListSeqRSQL(), param, velParam);

			if ( dbRowset != null && dbRowset.next() ) {
				maxSeq	= dbRowset.getInt("SEQ");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * [Irregular Container List]를 [Insert] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addIrregularCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){

				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				
				if ( !"".equals( tesGnteCntrListVOtmp.getIrrNo() ) ) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAOAddUSGuaranteeCntrListCSQL(), tesGnteCntrListVO, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	
	
	/**
	 * [Irregular Container List]를 [Update] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyIrregularCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO, GuaranteeCommonVO guaranteeCommonVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				if (!"".equals( tesGnteCntrListVOtmp.getIrrNo() ) &&
					!"Y".equals( guaranteeCommonVO.getGnteFlg() )) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL(), tesGnteCntrListVO, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [Irregular Container List]를 [Delete] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeIrregularCntrList(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				TesGnteCntrListVO	tesGnteCntrListVOtmp = tesGnteCntrListVO.get(0);
				if ( !"".equals( tesGnteCntrListVOtmp.getGnteNo() ) ) {
					velParam.put("gnte_no", tesGnteCntrListVOtmp.getGnteNo());
				}
				
				if ( !"".equals( tesGnteCntrListVOtmp.getIrrNo() ) ) {
					velParam.put("irr_no", tesGnteCntrListVOtmp.getIrrNo());
				}
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GuaranteeManageDBDAODeleteUSGuaranteeCntrListDSQL(), tesGnteCntrListVO, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	
	/**
	 * [Irregular Header] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @return List<SearchIrregularHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIrregularHdrVO> searchGuaranteeIrregularHdr(TesIrrHdrVO tesIrrHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIrregularHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(tesIrrHdrVO != null){
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//log.info("[IrregularManageDBDAO][searchIrregularHdr][] >>>>>>>>>>>>>>>>>>>>>>> tesIrrHdrVO = " + tesIrrHdrVO);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchGuaranteeIrregularHdrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [Guarantee 에서 Irregular 등록할 Container List] 정보를 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeIrregularCntrListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchGuaranteeIrregularCntrListVO> searchGuaranteeIrregularCntrList(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGuaranteeIrregularCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		ArrayList			tempArrL		= new ArrayList();
		StringTokenizer		strCd			= null;
		String				cntrListSeq		= "";

		try{
			if(guaranteeCommonVO != null){
				Map<String, String> mapVO = guaranteeCommonVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if( !"".equals( guaranteeCommonVO.getCntrSeq() ) ) {
					strCd = new StringTokenizer(guaranteeCommonVO.getCntrSeq(), ",");
					cntrListSeq = strCd.nextToken();
					tempArrL.add(cntrListSeq);

					while(strCd.hasMoreTokens()){
						cntrListSeq	= strCd.nextToken();
						tempArrL.add(cntrListSeq);
					}
				}
				
				if(tempArrL.size() > 0) {
					velParam.put("tml_gnte_cntr_list_seq", tempArrL);
				}	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchGuaranteeIrregularCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGuaranteeIrregularCntrListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}


	/**
	 * [Irregular Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param TesIrrHdrVO tesIrrHdrVO
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchIrregularListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchIrregularListVO> searchIrregularList(TesIrrHdrVO tesIrrHdrVO, GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet					dbRowset	= null;
		List<SearchIrregularListVO>	list		= null;
		
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();

		try{
			
			if(tesIrrHdrVO != null){
				Map<String, String> mapVO = tesIrrHdrVO .getColumnValues();
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if ( guaranteeCommonVO != null ) {
				Map<String, String> mapVO = guaranteeCommonVO .getColumnValues();
				
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new IrregularManageDBDAOSearchIrregularListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
}