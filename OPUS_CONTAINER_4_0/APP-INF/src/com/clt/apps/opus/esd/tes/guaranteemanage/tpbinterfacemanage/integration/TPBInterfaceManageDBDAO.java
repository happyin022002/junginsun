/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceManageDBDAO.java
*@FileTitle : Guarantee TPB I/F
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.11.11 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.basic.TPBInterfaceManageBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchGuaranteeTPBIfDataVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.vo.SearchRevVVDListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * TPBInterfaceManageDBDAO <br>
 * GuaranteeManage system Business Logic 을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see TPBInterfaceManageBCImpl 참조
 * @since J2EE 1.6
 */
public class TPBInterfaceManageDBDAO extends DBDAOSupport {

	/**
	 * [Guarantee TPB I/F] 정보를 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchGuaranteeTPBIfDataVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchGuaranteeTPBIfDataVO> searchGuaranteeTPBIfData(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchGuaranteeTPBIfDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		ArrayList<String>	tempArrL		= new ArrayList<String>();
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchGuaranteeTPBIfDataVO .class);
			
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
	 * [Guarantee TPB I/F Revenue VVD] 정보를 [Select] 합니다.<br>
	 * 
	 * @param TesGnteHdrVO tesGnteHdrVO
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<SearchRevVVDListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchRevVVDListVO> searchRevVVDList(TesGnteHdrVO tesGnteHdrVO, TesGnteCntrListVO tesGnteCntrListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRevVVDListVO> list = null;
		//query parameter
		Map<String, Object> param		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();
		Map<String, String> mapVO		= new HashMap<String, String>();
		
		try{

			if(tesGnteCntrListVO != null){
				mapVO = tesGnteCntrListVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(tesGnteHdrVO != null){
				mapVO = tesGnteHdrVO .getColumnValues();
			
				param	.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBInterfaceManageDBDAOSearchRevVVDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRevVVDListVO .class);
			
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
	 * [Guarantee TPB I/F Max Seq] 정보를 [Select] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception DAOException
	 */
	public int searchGuaranteeTPBIfDataSeq(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int		tpbSeq		= 1;
		try{
			if( !"".equals(ofcCd) ) { 
				param.put("tml_if_ofc_cd", ofcCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TPBInterfaceManageDBDAOSearchGuaranteeTPBIfDataSeqRSQL(), param, velParam);
			
			if ( dbRowset != null && dbRowset.next() ) {
				tpbSeq	= dbRowset.getInt("MAX_SEQ");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tpbSeq;
	}
	 
	 
	/**
	 * [Guarantee TPB I/F] 정보를 [Insert] 합니다.<br>
	 * 
	 * @param List<TesN3rdPtyIfVO> tesN3rdPtyIfVO
	 * @param ofcCd
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addGuaranteeTPBIfData(List<TesN3rdPtyIfVO> tesN3rdPtyIfVO, String ofcCd) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesN3rdPtyIfVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBInterfaceManageDBDAOAddGuaranteeTPBIfDataCSQL(), tesN3rdPtyIfVO, null);
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
	 * [Guarantee TPB I/F] 정보를 [Update] 합니다.<br>
	 * 
	 * @param List<TesGnteCntrListVO> tesGnteCntrListVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyGuaranteeTPBIfDataSts(List<TesGnteCntrListVO> tesGnteCntrListVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(tesGnteCntrListVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TPBInterfaceManageDBDAOModifyGuaranteeTPBIfDataStsUSQL(), tesGnteCntrListVO, null);
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
	
}