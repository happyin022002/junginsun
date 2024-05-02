/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAO.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
* 수정 20080829
* 2015-03-24 : 김영신 [CHM-201534788]GW Agmt Link 기준 변경 (SAve->Confirm) 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAOGetCntrBkgNoRSQL;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAOSearchCntcBkgNoCntrListRSQL;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCntcBkgNoCntrListVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9031Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9231Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * eNIS-ESD에 대한 DB 처리를 담당<br>
 * - eNIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author parkyeonjin
 * @see OndockRailChargeInvoiceManageBCImpl 참조
 * @since J2EE 1.4
 * 2011.07.15 윤태승 [CHM-201111696-01] TES의 BKG no. 참조로직 변경을 위한 타당성 검토 및 변경요청
 */
public class OndockRailChargeInvoiceManageDBDAO extends DBDAOSupport {



	/**
	 * OndockRailChargeInvoiceManage 의 데이타 모델을 DB에 저장한다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param String userId
	 * @param String ofc_cd
	 * @return int
	 * @throws DAOException
	 */
	public int createOndockRailChargeBasicInfo(TesTmlSoHdrVO tesTmlSoHdrVO, String userId, String ofc_cd) throws DAOException {
		if(log.isDebugEnabled())log.debug("createOndockRailChargeBasicInfo   =======================>	");

		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int i = 1;
		int addcnt = 0;
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("tml_so_ofc_cty_cd", tesTmlSoHdrVO.getInvOfcCd().substring(0, 3));
				param.put("cre_usr_id", userId);
				param.put("ofc_cd", ofc_cd);
			}
			
			i = new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOCreateOndockRailChargeBasicInfoCSQL(), param, velParam);
			
			if (i > 0){
				addcnt = 1;
				return addcnt;
			} else {
				throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}

	/** multiOndockRailChargeContainerListSeq
	 * 
	 * @param tesTmlSoHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int multiOndockRailChargeContainerListSeq(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		param.putAll(tesTmlSoHdrVO.getColumnValues());
		velParam.putAll(tesTmlSoHdrVO.getColumnValues());
		
		DBRowSet dbRowset = new DBRowSet();
		int maxSeq = 0;

		try { 
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListSeqRSQL(), param, velParam);
			
			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
log.debug(" dao MaxSeq=============>"+maxSeq);				
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;			
		
	}

	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeContainerListInsert(List<TesTmlSoCntrListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeContainerListUpdate(List<TesTmlSoCntrListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeContainerListDelete(List<TesTmlSoCntrListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeContainerListDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	


//	/**
//	 * verify전 CNTR목록 삭제하기
//	 * @param param_map
//	 * @throws DAOException
//	 */
//	public void deleteOndockRailChargeContainerList(HashMap param_map) throws DAOException {
//		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO  deleteTerminalInvoiceContainerList() ============");
//
//		Connection con = null;
//
//		PreparedStatement deletePs  	= null;
//		int cnt = 1;
//		StringBuffer 	  deleteQuery 	= new StringBuffer();
//
//		deleteQuery.append(" DELETE TES_TML_SO_CNTR_LIST L		                    \n");
//		deleteQuery.append(" WHERE L.TML_SO_OFC_CTY_CD = ? AND L.TML_SO_SEQ = ?     \n");
//
//		try {
//			con = getConnection();
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//			deletePs.setString(cnt++,JSPUtil.getNull((String)param_map.get("tml_so_ofc_cty_cd")));
//			deletePs.setString(cnt++,JSPUtil.getNull((String)param_map.get("tml_so_seq")));			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + deleteQuery );
//			}
//			deletePs.executeBatch();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//	}

	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param voList List<TesTmlSoCntrListVO> 
	 * @see EsdTes0001Event
	 * @throws DAOException
	 */
	public void createOndockRailChargeContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    createOndockRailChargeContainerList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOCreateOndockRailChargeContainerListCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}



	/**
	 * OndockRailChargeInvoiceManage 의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 *
	 * @param EsdTes0064Event event
	 * @throws DAOException
	 * TES_TML_SO_HDR데이타를 update하는 메서드.
	 */
	public void modifyOndockRailChargeBasicInfo(EsdTes0064Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("modifyOndockRailChargeBasicInfo   =======================>	");
		//parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOModifyOndockRailChargeBasicInfoUSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}





	/** OndockRailChargeInvoiceManage 의 Confirm시 ContainerList를 수정한다.<br>
	 *
	 * @param  event EsdTes0064Event
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCntrListForTerminalInvoiceConfirm(EsdTes0064Event event) throws DAOException {
	log.debug("start modifyCntrListForTerminalInvoiceConfirm =============================");
	
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		int updCnt 		= 0;
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				
			}
			
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL(), param, velParam);
			
			return updCnt;			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		

	}



	/**
	 * multiOndockRailChargeInvoiceDetailInsert
	 * @param voList List<TesTmlSoDtlVO>
	 * @param etcMap Map<String, String>
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailInsert(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
//	public void multiOndockRailChargeInvoiceDetailInsert(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			// TES CSR I/F의 "AGMNT LINK"에 대해 Link되어있는 모든 계약서 load (4347-11-27)
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList!=null && voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailUpdate(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList!=null && voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailDelete01(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList!=null && voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailDelete01DSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailDelete02(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList!=null && voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailDelete02DSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailDelete03(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList!=null && voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailDelete03DSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}

	
	/**
	 *  tpb 수정
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFUpdate1(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFUpdate01USQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**  CNTR 수정
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFUpdate2(List<TesTmlSoCntrListVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFUpdate02USQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/** DTL 수정
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFUpdate3(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFUpdate03USQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/** TPB 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFDelete(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/** invoice TPB 생성
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiTerminalInvoiceN3rdParyIFInsert(List<TesN3rdPtyIfVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOMultiTerminalInvoiceN3rdParyIFInsertCSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	


//	/** OndockRailChargeInvoiceManage의 데이타 모델에 해당되는 값을 삭제한다.<br>
//	 *
//	 * @param param_map 데이타 모델
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public void removeTerminalInvoiceContainerList(HashMap param_map) throws DAOException {
//		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    removeTerminalInvoiceContainerList() ============");
//		// Connection Interface
//		Connection con = null;
//
//		// DELETE를 수행하기 위한 SQL Statement
//		PreparedStatement deletePs 		= null;
//		StringBuffer 	  deleteQuery	= new StringBuffer();
//		// DB ResultSet
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int cnt = 1;
//
//				//삭제
//		deleteQuery.append(" DELETE FROM  TES_TML_SO_CNTR_LIST				\n");
//		deleteQuery.append(" WHERE 	TML_SO_OFC_CTY_CD 			    = ?		\n");
//		deleteQuery.append(" AND    TML_SO_SEQ                		= ?    	\n");
//
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//
//				deletePs = new LoggableStatement(con, deleteQuery.toString());
//			} else {
//
//				deletePs = con.prepareStatement(deleteQuery.toString());
//			}
//
//
//			deletePs.setString(cnt++, param_map.get("tml_so_ofc_cty_cd").toString());
//			deletePs.setString(cnt++, param_map.get("tml_so_seq").toString());
//
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//
//				log.info("\n SQL :" + ((LoggableStatement)deletePs).getQueryString());
//			} else {
//
//				log.info("\n SQL :" + deleteQuery );
//			}
//			deletePs.executeUpdate();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(deletePs);
//			closeConnection(con);
//		}
//
//	}




	/** OndockRailChargeInvoiceManage의 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param EsdTes0064Event event
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceRvisList(EsdTes0064Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageDBDAO    removeTerminalInvoiceRvisList() ============");
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAORemoveTerminalInvoiceRvisListDSQL(), velParam, param);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}


	/** OndockRailChargeInvoiceManage의 데이타 모델에 N3RD 해당되는 값을 삭제한다.<br>
	 *
	 * @param EsdTes0064Event event
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceN3RDList(EsdTes0064Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    removeTerminalInvoiceN3RDList() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAORemoveTerminalInvoiceN3RDListDSQL(), velParam, param);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}


	/** OndockRailChargeInvoiceManage 데이타 모델에 해당되는 값을 삭제한다.<br>
	 *
	 * @param EsdTes0064Event event
	 * @throws DAOException
	 */
	public void removeTerminalInvoiceCostCalculation(EsdTes0064Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    removeTerminalInvoiceCostCalculation() ============");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAORemoveTerminalInvoiceCostCalculationDSQL(), velParam, param);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}


	/**
	 * OndockRailChargeInvoiceManage의 데이타 모델에 해당되는 기본 정보를 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeBasicInfo(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeBasicInfoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		

	}


	/** OndockRailChargeInvoiceManage의 CntrTypeSizeList를 조회한다.<br>
	 *
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCntrTypeSizeList() throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchCntrTypeSizeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	

	}




	/** OndockRailChargeInvoiceManage 의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdTes0064Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeContainerList (EsdTes0064Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    searchOndockRailChargeContainerList() ============");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getOndockRailChargeInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getOndockRailChargeInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}




//	/* OndockRailChargeInvoiceManage 의 3'd party List을 조회한다.<br>
//	 *
//	 * @param param_map 파라메터
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchOndockRailChargeInvoiceN3ptyList(HashMap param_map) throws DAOException {
//
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append("  SELECT                                                                   \n");
//		queryStr.append("  		  A.TML_IF_OFC_CD        N3RD_TML_IF_OFC_CD                           \n");
//		queryStr.append("  		, A.TML_IF_SEQ           N3RD_TML_IF_SEQ                              \n");
//		queryStr.append("  		, A.TML_N3PTY_TP_CD      N3RD_TML_N3PTY_TP_CD                         \n");
//		queryStr.append("  		, A.TML_N3PTY_IF_STS_CD  N3RD_TML_N3PTY_IF_STS_CD                     \n");
//		queryStr.append("  		, A.INV_NO               N3RD_INV_NO                                  \n");
//		queryStr.append("  		, LPAD(A.VNDR_SEQ, 6, '0') N3RD_VNDR_SEQ                                \n");
//		queryStr.append("  		, A.YD_CD                N3RD_YD_CD                                   \n");
//		queryStr.append("  		, A.LGS_COST_CD          N3RD_LGS_COST_CD                             \n");
//		queryStr.append("  		, A.ACCT_CD              N3RD_ACCT_CD                                 \n");
//		queryStr.append("  		, A.TML_SO_OFC_CTY_CD    N3RD_TML_SO_OFC_CTY_CD                       \n");
//		queryStr.append("  		, A.TML_SO_SEQ           N3RD_TML_SO_SEQ                              \n");
//		queryStr.append("  		, A.TML_SO_DTL_SEQ       N3RD_TML_SO_DTL_SEQ                          \n");
////		queryStr.append("  		, A.CAR_OFC_CTY_CD       N3RD_CAR_OFC_CTY_CD                          \n");
////		queryStr.append("  		, A.CAR_SEQ              N3RD_CAR_SEQ                                 \n");
//		queryStr.append("  		, A.N3PTY_BIL_TP_CD      N3RD_N3PTY_BIL_TP_CD                         \n");
//		queryStr.append("  		, A.CNTR_NO              N3RD_CNTR_NO                                 \n");
//		queryStr.append("  		, A.CNTR_TPSZ_CD         N3RD_CNTR_TPSZ_CD                            \n");
//		queryStr.append("  		, A.BKG_NO               N3RD_BKG_NO                                  \n");
//		queryStr.append("  		, A.BKG_NO_SPLIT         N3RD_BKG_NO_SPLIT                            \n");
//		queryStr.append("  		, A.BL_NO                N3RD_BL_NO                                   \n");
//		queryStr.append("  		, A.BL_NO_TP             N3RD_BL_NO_TP                                \n");
//		queryStr.append("  		, A.BL_NO_CHK            N3RD_BL_NO_CHK                               \n");
//		queryStr.append("  		, A.FINC_VSL_CD          N3RD_FINC_VSL_CD                             \n");
//		queryStr.append("  		, A.FINC_SKD_VOY_NO      N3RD_FINC_SKD_VOY_NO                         \n");
//		queryStr.append("  		, A.FINC_SKD_DIR_CD      N3RD_FINC_SKD_DIR_CD                         \n");
//		queryStr.append("  		, A.REF_VNDR_SEQ         N3RD_REF_VNDR_SEQ                            \n");
//		queryStr.append("  		, A.TML_CRR_CD           N3RD_TML_CRR_CD                              \n");
//		queryStr.append("  		, A.VNDR_CUST_DIV_CD     N3RD_VNDR_CUST_DIV_CD                        \n");
//		queryStr.append("  		, A.VNDR_CNT_CD          N3RD_VNDR_CNT_CD                             \n");
//		queryStr.append("  		, A.N3PTY_VNDR_SEQ       N3RD_N3PTY_VNDR_SEQ                          \n");
//		queryStr.append("  		, A.CUST_CNT_CD          N3RD_CUST_CNT_CD                             \n");
//		queryStr.append("  		, A.CUST_SEQ             N3RD_CUST_SEQ                                \n");
//		queryStr.append("  		, A.N3PTY_OFC_CD         N3RD_N3PTY_OFC_CD                            \n");
//		queryStr.append("  		, A.CURR_CD              N3RD_CURR_CD                                 \n");
//		queryStr.append("  		, A.IF_AMT               N3RD_IF_AMT                                  \n");
//		queryStr.append("  		, A.IF_RMK               N3RD_IF_RMK                                  \n");
//		queryStr.append("  		, A.N3PTY_INV_DT         N3RD_N3PTY_INV_DT                            \n");
//		queryStr.append("  		, A.N3PTY_TERM_DT        N3RD_N3PTY_TERM_DT                           \n");
//		queryStr.append("  		, A.N3PTY_CSR_CURR_CD    N3RD_N3PTY_CSR_CURR_CD                       \n");
//		queryStr.append("  		, A.N3PTY_AMT            N3RD_N3PTY_AMT                               \n");
//		queryStr.append("  		, A.N3PTY_DESC           N3RD_N3PTY_DESC                              \n");
//		queryStr.append("  		, A.CXL_FLG              N3RD_CXL_FLG                                 \n");
//		queryStr.append("  		, A.FINC_VSL_CD||A.FINC_SKD_VOY_NO||A.FINC_SKD_DIR_CD    N3RD_VVD_NO  \n");
//		queryStr.append("  		, B.CALC_COST_GRP_CD   	N3RD_CALC_COST_GRP_CD                          \n");
//		queryStr.append("  		, B.CALC_TP_CD         	N3RD_CALC_TP_CD                                \n");
//		queryStr.append("  		, B.IOC_CD             	N3RD_IOC_CD                                    \n");
//		queryStr.append("  		, B.LANE_CD            	N3RD_LANE_CD                                   \n");
//		queryStr.append("  		, B.IO_BND_CD          	N3RD_IO_BND_CD                                 \n");
//		queryStr.append("  		, B.CNTR_TPSZ_CD       	N3RD_CNTR_TPSZ_CD                              \n");
//		queryStr.append("  		, B.FM_TR_VOL_VAL      	N3RD_FM_TR_VOL_VAL                             \n");
//		queryStr.append("  		, B.TO_TR_VOL_VAL      	N3RD_TO_TR_VOL_VAL                             \n");
//		queryStr.append(" 		, B.WRK_DT         	   	N3RD_WRK_DT                 			\n");
//		queryStr.append(" 		, DECODE(TO_CHAR(TO_DATE(B.WRK_DT,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','HOL','HO','WD') N3RD_DT \n");
//		queryStr.append(" 		, B.DCGO_IND_CD        	N3RD_DCGO_CLSS_CD                 			\n");
//		queryStr.append("  FROM TES_N3RD_PTY_IF A,                                                  \n");
//		queryStr.append("       TES_TML_SO_DTL B                                                    \n");
//		queryStr.append("  WHERE  A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD                         \n");
//		queryStr.append("  AND    A.TML_SO_SEQ        = B.TML_SO_SEQ                                \n");
//		queryStr.append("  AND    A.TML_SO_DTL_SEQ    = B.TML_SO_DTL_SEQ                            \n");
//		queryStr.append("  AND    A.TML_SO_OFC_CTY_CD =  ?                                          \n");
//		queryStr.append("  AND    A.TML_SO_SEQ 		=  ?                                              \n");
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			ps.setString(i++, param_map!=null?JSPUtil.getNull((String)param_map.get("tml_so_ofc_cty_cd" )):"");
//			ps.setString(i++, param_map!=null?JSPUtil.getNull((String)param_map.get("tml_so_seq" 		)):"");
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//			while (dRs.next()){
//				for(int j=1; j<=dRs.getMetaData().getColumnCount(); j++){
//					if(log.isDebugEnabled())
//							log.debug("==========OndockRailChargeInvoiceManageDBDAO    searchAccumulatedVolumeList()  dRs.getMetaData().getColumnName("+j+")"+ "  :  " + dRs.getString(j));
//				}
//			}
//			dRs.beforeFirst();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}






//	/* OndockRailChargeInvoiceManage 의 RevisedVolumeList을 조회한다.<br>
//	 *
//	 * @param param_map 파라메터
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchOndockRailChargeInvoiceRvisList(HashMap param_map) throws DAOException {
//
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//
//		StringBuffer queryStr = new StringBuffer();
//		queryStr.append(" SELECT    A.TML_SO_OFC_CTY_CD     RVIS_TML_SO_OFC_CTY_CD           		\n");
//		queryStr.append("         , A.TML_SO_SEQ            RVIS_TML_SO_SEQ                    \n");
//		queryStr.append("         , A.TML_SO_DTL_SEQ        RVIS_TML_SO_DTL_SEQ                \n");
//		queryStr.append("         , A.TML_SO_RVIS_LIST_SEQ  RVIS_TML_SO_RVIS_LIST_SEQ          \n");
//		queryStr.append("         , A.TML_INV_TP_CD         RVIS_TML_INV_TP_CD                 \n");
//		queryStr.append("         , A.CALC_COST_GRP_CD      RVIS_CALC_COST_GRP_CD              \n");
//		queryStr.append("         , A.TML_RVIS_TP_CD        RVIS_TML_RVIS_TP_CD                \n");
//		queryStr.append("         , A.LGS_COST_CD           RVIS_LGS_COST_CD                   \n");
//		queryStr.append("         , A.CNTR_NO               RVIS_CNTR_NO                       \n");
//		queryStr.append("         , A.BKG_NO                RVIS_BKG_NO                        \n");
//		queryStr.append("         , A.BKG_NO_SPLIT          RVIS_BKG_NO_SPLIT                  \n");
//		queryStr.append("         , A.VSL_CD                RVIS_VSL_CD                        \n");
//		queryStr.append("         , A.SKD_VOY_NO            RVIS_SKD_VOY_NO                    \n");
//		queryStr.append("         , A.SKD_DIR_CD            RVIS_SKD_DIR_CD                    \n");
//		queryStr.append("         , A.CUZ_CNTR_NO           RVIS_CUZ_CNTR_NO                   \n");
//		queryStr.append("         , A.RHND_RSN_CD           RVIS_RHND_RSN_CD                   \n");
//		queryStr.append("         , A.RVIS_RMK              RVIS_RVIS_RMK                      \n");
//		queryStr.append("         , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD        RVIS_VVD_NO    \n");
//		queryStr.append(" 		    , B.CALC_COST_GRP_CD      RVIS_CALC_COST_GRP_CD              \n");
//		queryStr.append(" 		    , B.CALC_TP_CD            RVIS_CALC_TP_CD                    \n");
//		queryStr.append(" 		    , B.IOC_CD                RVIS_IOC_CD                        \n");
//		queryStr.append(" 		    , B.LANE_CD               RVIS_LANE_CD                       \n");
//		queryStr.append(" 		    , B.IO_BND_CD             RVIS_IO_BND_CD                     \n");
//		queryStr.append(" 		    , B.CNTR_TPSZ_CD          RVIS_CNTR_TPSZ_CD                  \n");
//		queryStr.append(" 		    , B.FM_TR_VOL_VAL         RVIS_FM_TR_VOL_VAL                 \n");
//		queryStr.append(" 		    , B.TO_TR_VOL_VAL         RVIS_TO_TR_VOL_VAL                 \n");
//		queryStr.append(" 		    , B.WRK_DT         		  RVIS_WRK_DT                 			\n");
//		queryStr.append(" 		    , DECODE(TO_CHAR(TO_DATE(B.WRK_DT,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','HOL','HO','WD') RVIS_DT \n");
//		queryStr.append(" 		, B.DCGO_IND_CD        	RVIS_DCGO_CLSS_CD                 			\n");
//		queryStr.append(" FROM    TES_TML_SO_RVIS_LIST A,                                      		\n");
//		queryStr.append("      		TES_TML_SO_DTL B                                             	\n");
//		queryStr.append(" WHERE  A.TML_SO_OFC_CTY_CD = B.TML_SO_OFC_CTY_CD                     		\n");
//		queryStr.append(" AND    A.TML_SO_SEQ        = B.TML_SO_SEQ                           		\n");
//		queryStr.append(" AND    A.TML_SO_DTL_SEQ    = B.TML_SO_DTL_SEQ                             \n");
//		queryStr.append(" AND    A.TML_SO_OFC_CTY_CD =  ?                                      		\n");
//		queryStr.append(" AND    A.TML_SO_SEQ 		 =  ?                                      		\n");
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			ps.setString(i++, param_map!=null?JSPUtil.getNull((String)param_map.get("tml_so_ofc_cty_cd" )):"");
//			ps.setString(i++, param_map!=null?JSPUtil.getNull((String)param_map.get("tml_so_seq" 		)):"");
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//			while (dRs.next()){
//				for(int j=1; j<=dRs.getMetaData().getColumnCount(); j++){
//					if(log.isDebugEnabled())
//							log.debug("==========OndockRailChargeInvoiceManageDBDAO    searchAccumulatedVolumeList()  dRs.getMetaData().getColumnName("+j+")"+ "  :  " + dRs.getString(j));
//				}
//			}
//			dRs.beforeFirst();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}



	/** OndockRailChargeInvoiceManage의 CostCodeList를 조회한다.<br>
	 *
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCostCodeList() throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	

	}
	
	/** searchOndockRailChargeCostCalculationListNew
	 * 
	 * @param  EsdTes0064Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeCostCalculationListNew(EsdTes0064Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getOndockRailChargeInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getOndockRailChargeInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListNewRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	
	}
	
	/** OndockRailChargeInvoiceCommonSeq
	 * 
	 * @param colName
	 * @param tabName
	 * @param whereColumn1
	 * @param whereColumn2
	 * @param whereColumn1Value
	 * @param whereColumn2Value
	 * @return int
	 * @throws DAOException
	 */
	public int onDockRailChargeInvoiceCommonSeq(String colName, String tabName, String whereColumn1, String whereColumn2, String whereColumn1Value, String whereColumn2Value) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		DBRowSet dbRowset = new DBRowSet();
		int maxSeq = 0;
		
		velParam.put("colName", colName);
		velParam.put("tabName", tabName);
		velParam.put("whereColumn1", whereColumn1);
		velParam.put("whereColumn2", whereColumn2);
		velParam.put("whereColumn1Value", whereColumn1Value);
		velParam.put("whereColumn2Value", whereColumn2Value);
		
		param.put("whereColumn1Value", whereColumn1Value);
		param.put("whereColumn2Value", whereColumn2Value);
		
log.info("velParam whereColumn1========>"+velParam.get("whereColumn1"));
log.info("velParam whereColumn2========>"+velParam.get("whereColumn2"));
log.info("velParam whereColumn1Value========>"+velParam.get("whereColumn1Value"));
log.info("velParam whereColumn1Value========>"+velParam.get("whereColumn2Value"));
log.info("Param whereColumn1Value========>"+param.get("whereColumn1Value"));
log.info("Param whereColumn2Value========>"+param.get("whereColumn2Value"));

		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOOndockRailChargeInvoiceCommonSeqRSQL(), param, velParam);
			
			if(dbRowset!= null && dbRowset.next()){
				maxSeq = dbRowset.getInt("MAX_SEQ");
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return maxSeq;			
		
	}	

	/** OndockRailChargeInvoiceManage 의 CostCalculationList를 조회한다..<br>
	 *
	 * @param EsdTes0064Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeCostCalculationList(EsdTes0064Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getOndockRailChargeInvoiceCommonVO() != null){
				Map<String, String> mapVO = event.getOndockRailChargeInvoiceCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeCostCalculationListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	

	}


	/**
	 * On-dock Container 목록을 가져온다.<br>
	 *
	 * @param  TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param  String CODC_tp
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeContainerList2(TesTmlSoHdrVO tesTmlSoHdrVO, String CODC_tp) throws DAOException{
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				param.put("vrfy_rslt_ind_cd", CODC_tp);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockRailChargeContainerList2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		

	}
	

	/**
	 * On-dock Container 목록을 가져온다.<br>
	 * 
	 * @param  TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOndockCostCalculationList(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException{
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOndockCostCalculationListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		
	
	}


	/**
	 * createTES_FILE_IMP_TMP 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param  voList List<TesFileImpTmpVO>
	 * @throws DAOException
	 */
	public void createTES_FILE_IMP_TMP(List<TesFileImpTmpVO> voList) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}

	/**
	 * MarineTerminalInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * @param EsdTes9130Event event
	 * @throws DAOException
	 */
	public void removeTES_FILE_IMP_TMP(EsdTes9130Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    removeTES_FILE_IMP_TMP() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAORemoveTES_FILE_IMP_TMPDSQL(), velParam, param);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error("DAOException "+de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error("Exception:"+e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}


	/**
	 * OndockRailChargeInvoiceManage의 ContainerList를 verify한 List를 조회한다.<br>
	 * @param EsdTes9130Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyOndockRailChargeContainerList(EsdTes9130Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    verifyOndockRailChargeContainerList() ============");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	
		try {

			if(event.getTesTmlSoHdrVO() != null){
				param.put("tml_so_ofc_cty_cd", event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				param.put("tml_so_seq", event.getTesTmlSoHdrVO().getTmlSoSeq());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOVerifyOndockRailChargeContainerListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}


//	/**
//	 * OndockRailChargeInvoiceManage의 ContainerList를 verify한 List를 조회한다.<br>
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet verifyOndockRailChargeContainerList(TerminalInvoceContainer model,HashMap param_map) throws DAOException {
//		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    verifyOndockRailChargeContainerList()  model ============"+model);
//
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		StringBuffer queryStr = new StringBuffer() ;
//		queryStr.append(" SELECT DECODE(A.CNTR_NO,NULL,B.EQ_NO,A.CNTR_NO) 															CNTR_NO																																																							    \n");
//		queryStr.append("   	   ,DECODE(A.CNTR_TPSZ_CD,NULL ,B.EQ_TPSZ_CD,A.CNTR_TPSZ_CD) 							CNTR_TPSZ_CD                                                                                                            \n");
//		queryStr.append("   	   ,DECODE(A.CNTR_STY_CD,NULL ,B.MT,A.CNTR_STY_CD) 										CNTR_STY_CD                                                                                                           \n");
//		queryStr.append("        ,TO_CHAR(TO_DATE(DECODE(A.CNTR_NO,NULL,'',?),'YYYYMMDD'),'YYYY-MM-DD') WRK_DT                                                                                                                  \n");
//		queryStr.append("   	   ,A.VNDR_SEQ                                                                                                                                                                                    \n");
//		queryStr.append("   	   ,A.YD_CD                                                                                                                                                                                       \n");
//		queryStr.append("   	   ,A.RCV_DT                                                                                                                                                                                      \n");
//		queryStr.append("   	   ,DECODE(A.DSCR_IND_CD,NULL,'HO',A.DSCR_IND_CD)  									DSCR_IND_CD                                                                                                          \n");
//		queryStr.append("        ,B.VSL_CD                                                                                                                                                                                      \n");
//		queryStr.append("        ,B.SKD_VOY_NO                                                                                                                                                                                  \n");
//		queryStr.append("        ,B.SKD_DIR_CD                                                                                                                                                                                  \n");
//		queryStr.append("        ,B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD  																VVD_NO                                                                                                                  \n");
//		queryStr.append("        ,B.BKG_NO                                                                                                                                                                                      \n");
//		queryStr.append("        ,B.BKG_NO_SPLIT                                                                                                                                                                                \n");
//		queryStr.append("        ,B.BL_NO                   --추가 2007.02.27                                                                                                                                                             \n");
//		queryStr.append("        ,B.BL_NO_CHK               --추가 2007.02.27                                                                                                                                                                 \n");
//		queryStr.append("        ,B.BL_NO_TP                --추가 2007.02.27                                                                                                                                                                \n");
//		queryStr.append("        ,B.FM_NOD_CD                                                                                                                                                                                   \n");
//		queryStr.append("        ,B.TO_NOD_CD                                                                                                                                                                                   \n");
//		queryStr.append("        ,DECODE(B.DCGO_CLSS_CD,NULL,'N',B.DCGO_CLSS_CD) DCGO_CLSS_CD                                                                                                                                                                                          \n");
//		queryStr.append("        ,TO_CHAR(B.CLM_DT,'YYYY-MM-DD')                                 				CLM_DT                                                                                                                  \n");
//		queryStr.append("        ,B.RAIL_BIL_DT                                                                                                                                                                                       \n");
//		queryStr.append("        ,DECODE(A.CNTR_NO,NULL,DECODE(B.HO,0,B.DY,'HO'),NULL) DY            --수정 2007.02.27                                                                 \n");
//		queryStr.append("        ,DECODE(TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD),NULL,'',TES_GET_COMCODENAME_FNC('CD00823',DSCR_IND_CD))  DSCR_IND_NM                                                           \n");
//		queryStr.append("  FROM                                                                                                                                                                                                 \n");
//		queryStr.append("      (SELECT ?  CNTR_NO												                                                                                                                                                        \n");
//
////		queryStr.append("      SELECT ?  CNTR_NO												                                                                                                                                                        \n");
//		queryStr.append("  	  	  , ?  CNTR_TPSZ_CD                                                                                                                                                                             \n");
//		queryStr.append("  	  	  , ?  CNTR_STY_CD                                                                                                                                                                            \n");
//		queryStr.append("  	  	  , ?  VNDR_SEQ                                                                                                                                                                                 \n");
//		queryStr.append("  	  	  , ?  YD_CD                                                                                                                                                                                    \n");
//		queryStr.append("  	  	  , ?  RCV_DT                                                                                                                                                                                   \n");
//		queryStr.append("  	  	  , ?  WRK_DT                                                                                                                                                                                   \n");
//		queryStr.append("            , CASE WHEN((SELECT COUNT(*) -- 'Double Bill' Check                                                                                                                                        \n");
//		queryStr.append("                         FROM   TES_TML_SO_HDR A,                                                                                                                                                      \n");
//		queryStr.append("                                TES_TML_SO_CNTR_LIST B                                                                                                                                                 \n");
//		queryStr.append("                         WHERE  A.TML_SO_OFC_CTY_CD  = B.TML_SO_OFC_CTY_CD                                                                                                                             \n");
//		queryStr.append("                         AND    A.TML_SO_SEQ         = B.TML_SO_SEQ                                                                                                                                    \n");
//		queryStr.append("                         AND    A.VNDR_SEQ           = ?                                                                                                                                               \n");
//		queryStr.append("                         AND    A.YD_CD              = ?                                                                                                                                               \n");
//		queryStr.append("                         AND    A.TML_INV_TP_CD      = 'ON'                                                                                                                                             \n");
//		queryStr.append("                         AND    NVL(A.DELT_FLG,'N')  <> 'Y'                                                                                                                                    \n");
//		queryStr.append("                         AND    B.CNTR_NO            = ?                                                                                                                                              \n");
//		queryStr.append("                         AND    MONTHS_BETWEEN(TO_DATE(REPLACE(?,'-'),'YYYYMMDD'),A.ISS_DT ) <= 3)                                                                                                                  \n");
//		queryStr.append("                      > 0 ) THEN 'DB'                                                                                                                                                                  \n");
//		queryStr.append("               ELSE  /*BOOKING CHECK START*/                                                                                                                                                           \n");
//		queryStr.append("                      (SELECT DECODE((SELECT COUNT(*) -- 'Not in SML Souce' Check                                                                                                                      \n");
//		queryStr.append("                                      FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D                                                                                                      \n");
//		queryStr.append("                                      WHERE  ( O.FM_NOD_CD        = ?                                                                                                                                  \n");
//		queryStr.append("                                      OR     O.TO_NOD_CD          = ? )                                                                                                                                \n");
//		queryStr.append("                                      AND    O.CRE_DT             >= TO_DATE(?,'YYYYMMDD') - 15   -- FILE IMPORT한 WORKING DATE의 MIN 값                                                               \n");
//		queryStr.append("                                      AND    O.CRE_DT             <= TO_DATE(?,'YYYYMMDD') + 15   -- FILE IMPORT한 WORKING DATE의 MAX 값                                                               \n");
//		queryStr.append("                                      AND    NVL(O.DELT_FLG,'N')  <> 'Y'                                                                                                                               \n");
//		queryStr.append("                                      AND    O.EQ_NO        = ?                                                                                                                                        \n");
//		queryStr.append("                                      AND    O.BKG_NO             = B.BKG_NO(+)                                                                                                                        \n");
//		queryStr.append("                                      AND    O.BKG_NO_SPLIT       = B.BKG_NO_SPLIT(+)                                                                                                                  \n");
//		queryStr.append("                                      AND    O.BKG_NO             = D.BKG_NO(+)                                                                                                                        \n");
//		queryStr.append("                                      AND    O.BKG_NO_SPLIT       = D.BKG_NO_SPLIT(+)                                                                                                                  \n");
//		queryStr.append("                                      ),0,'NH',(SELECT DECODE(O.EQ_TPSZ_CD,?,DECODE(O.CGO_TP_CD, ?,'CO','DDF'),'DDT') -- 'Discrepancy by Detail Data' Check                                            \n");
//		queryStr.append("                                                FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D                                                                                            \n");
//		queryStr.append("                                                WHERE  ( O.FM_NOD_CD        = ?                                                                                                                        \n");
//		queryStr.append("                                                OR     O.TO_NOD_CD          = ? )                                                                                                                      \n");
//		queryStr.append("                                                AND    O.CRE_DT             >= TO_DATE(?,'YYYYMMDD') - 15   -- FILE IMPORT한 WORKING DATE의 MIN 값                                                     \n");
//		queryStr.append("                                                AND    O.CRE_DT             <= TO_DATE(?,'YYYYMMDD') + 15   -- FILE IMPORT한 WORKING DATE의 MAX 값                                                     \n");
//		queryStr.append("                                                AND    NVL(O.DELT_FLG,'N')  <> 'Y'                                                                                                                     \n");
//		queryStr.append("                                                AND    O.EQ_NO        = ?                                                                                                                              \n");
//		queryStr.append("                                                AND    O.BKG_NO             = B.BKG_NO(+)                                                                                                              \n");
//		queryStr.append("                                                AND    O.BKG_NO_SPLIT       = B.BKG_NO_SPLIT(+)                                                                                                        \n");
//		queryStr.append("                                                AND    O.BKG_NO             = D.BKG_NO(+)                                                                                                              \n");
//		queryStr.append("                                                AND    O.BKG_NO_SPLIT       = D.BKG_NO_SPLIT(+)                                                                                                       \n");
//		//20070117 container : booking data = 1: n 인경우에대한 로직 추가
//		queryStr.append("                                                AND    rownum = 1 )                                                                                                      \n");
//		queryStr.append("                        )                                                                                                                                                                              \n");
//		queryStr.append("                        FROM DUAL                                                                                                                                                                      \n");
//		queryStr.append("                   ) /*BOOKING CHECK END*/                                                                                                                                                             \n");
//		queryStr.append("           END DSCR_IND_CD                                                                                                                                                                          \n");
//		queryStr.append("       FROM DUAL																												                                                                                                                                \n");
//
//		queryStr.append("  ) A,                                                                                                                                                                                                 \n");
//
//		queryStr.append("  (SELECT B.VSL_CD,                                                                                                                                                                                    \n");
////		queryStr.append("  SELECT B.VSL_CD,                                                                                                                                                                                    \n");
//		queryStr.append("          B.SKD_VOY_NO,                                                                                                                                                                                \n");
//		queryStr.append("          B.SKD_DIR_CD,                                                                                                                                                                                \n");
//		queryStr.append("          O.BKG_NO,                                                                                                                                                                                    \n");
//		queryStr.append("          O.BKG_NO_SPLIT,                                                                                                                                                                              \n");
//		queryStr.append("          B.BL_NO,                  --추가 2007.02.27                                                                                                                                                            \n");
//		queryStr.append("          B.BL_NO_CHK,              --추가 2007.02.27                                                                                                                                                                \n");
//		queryStr.append("          B.BL_NO_TP,               --추가 2007.02.27                                                                                                                                                               \n");
//		queryStr.append("          O.EQ_NO,                                                                                                                                                                                     \n");
//		queryStr.append("          O.EQ_TPSZ_CD,                                                                                                                                                                                \n");
//		queryStr.append("          O.CGO_TP_CD MT,                                                                                                                                                                              \n");
//		queryStr.append("          O.FM_NOD_CD,                                                                                                                                                                                 \n");
//		queryStr.append("          O.TO_NOD_CD,                                                                                                                                                                                 \n");
//		queryStr.append("          NVL(SUBSTR(D.DCGO_IMO_CLSS_CD,1,1),'N') DCGO_CLSS_CD,                                                                                                                                                  \n");
//		queryStr.append("          TO_CHAR(TO_DATE(?,'YYYYMMDD'),'YYYY-MM-DD') WK_DT,    -- FILE IMPORT한 CNTR LIST와 맞는 값이라면 FILE IMPORT의 WORKING DATE 맞는 CNTR이 없으면 NULL                                          \n");
//		queryStr.append("          DECODE(DECODE(SUBSTR(?,1,5),B.POL_CD,'O','I'),'O',MIN(U.ARR_DT),MAX(V.ARR_DT)) CLM_DT,                                                                                                       \n");
//		queryStr.append("          TO_CHAR(O.CRE_DT,'YYYY-MM-DD') RAIL_BIL_DT,                                           -- DY 수정 2007.02.27                                                                                                             \n");
//		queryStr.append("          DECODE(TO_CHAR(TO_DATE(?,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','WD') DY, -- FILE IMPORT한 CNTR LIST와 맞는 값이라면 FILE IMPORT의 WORKING DATE 맞는 CNTR이 없으면 NULL           \n");
//		queryStr.append("		   (SELECT COUNT(*)   \n");
//		queryStr.append("           FROM PRD_HOLIDAY \n");
//		queryStr.append("           WHERE TO_NUMBER(HOL_FM_DT) >= TO_NUMBER(?)	\n");
//		queryStr.append("           AND CNT_CD = ?	\n");
//		queryStr.append("           AND TO_NUMBER(HOL_FM_DT) <= TO_NUMBER(?)	\n");
//		queryStr.append("           AND DELT_FLG = 'N') HO \n");
//
////
////		queryStr.append("			( SELECT COUNT(*) 								 																																			\n");
////////		queryStr.append("			 SELECT COUNT(*) 								--추가 2007.02.27 																																			\n");
////		queryStr.append("			  FROM   PRD_HOLIDAY							 																																			\n");
////		queryStr.append("			  WHERE  to_number(HOL_FM_DT) >= to_number(?)		 																																				\n");
//////		queryStr.append("			  AND    CNT_CD    = ?			--추가 2007.02.27 																																							\n");
////		queryStr.append("			  AND    to_number(HOL_FM_DT) <= to_number(?)																																						'\n");
//////		queryStr.append("			  AND    DELT_FLG  = 'N' 					--추가 2007.02.27 																																					\n");
////		queryStr.append("			  AND    DELT_FLG  = 'N' ) HO					 																																					\n");
//
//		queryStr.append("   FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D, SCE_CLM U, SCE_CLM V   -- 수정                                                                                                         \n");
//		queryStr.append("   WHERE  ( O.FM_NOD_CD        = ?                                                                                                                                                                     \n");
//		queryStr.append("   OR     O.TO_NOD_CD          = ? )                                                                                                                                                                   \n");
//		queryStr.append("   AND    O.CRE_DT             >= TO_DATE(?,'YYYYMMDD') - 15   -- FILE IMPORT한 WORKING DATE의 MIN 값                                                                                                  \n");
//		queryStr.append("   AND    O.CRE_DT             <= TO_DATE(?,'YYYYMMDD') + 15   -- FILE IMPORT한 WORKING DATE의 MAX 값                                                                                                  \n");
//		queryStr.append("   AND    NVL(O.DELT_FLG,'N')  <> 'Y'                                                                                                                                                                  \n");
//		queryStr.append("   AND    O.EQ_NO        = ?                                                                                                                                                                           \n");
//		queryStr.append("   AND    O.BKG_NO             = B.BKG_NO(+)                                                                                                                                                           \n");
//		queryStr.append("   AND    O.BKG_NO_SPLIT       = B.BKG_NO_SPLIT(+)                                                                                                                                                     \n");
//		queryStr.append("   AND    O.BKG_NO             = D.BKG_NO(+)                                                                                                                                                           \n");
//		queryStr.append("   AND    O.BKG_NO_SPLIT       = D.BKG_NO_SPLIT(+)                                                                                                                                                     \n");
//		queryStr.append("   AND    O.TRSP_SO_OFC_CTY_CD = U.TRSP_SO_OFC_CTY_CD(+)                                                                                                                                               \n");
//		queryStr.append("   AND    O.TRSP_SO_SEQ        = U.TRSP_SO_SEQ(+)                                                                                                                                                      \n");
//		queryStr.append("   AND    O.EQ_NO              = U.CNTR_NO(+)                                                                                                                                                          \n");
//		queryStr.append("   AND    U.CLM_SGHT_CD(+)     = 'U'                                                                                                                                                                   \n");
//		queryStr.append("   AND    O.TRSP_SO_OFC_CTY_CD = V.TRSP_SO_OFC_CTY_CD(+)                                                                                                                                               \n");
//		queryStr.append("   AND    O.TRSP_SO_SEQ        = V.TRSP_SO_SEQ(+)                                                                                                                                                      \n");
//		queryStr.append("   AND    O.EQ_NO              = V.CNTR_NO(+)                                                                                                                                                          \n");
//		queryStr.append("   AND    V.CLM_SGHT_CD(+)     = 'V'                                                                                                                                                                   \n");
//		//20070117 container : booking data = 1: n 인경우에대한 로직 추가
//		queryStr.append("   AND    rownum = 1                                                                                                                                                                   \n");
//		queryStr.append("   GROUP BY B.VSL_CD,                                                                                                                                                                                  \n");
//		queryStr.append("          B.SKD_VOY_NO,                                                                                                                                                                                \n");
//		queryStr.append("          B.SKD_DIR_CD,                                                                                                                                                                                \n");
//		queryStr.append("          O.BKG_NO,                                                                                                                                                                                    \n");
//		queryStr.append("          O.BKG_NO_SPLIT,                                                                                                                                                                              \n");
//		queryStr.append("          B.BL_NO,                       --추가 2007.02.27                                                                                                                               \n");
//		queryStr.append("          B.BL_NO_CHK,                   --추가 2007.02.27                                                                                                                                   \n");
//		queryStr.append("          B.BL_NO_TP,                     --추가 2007.02.27                                                                                                                                  \n");
//		queryStr.append("          O.EQ_NO,                                                                                                                                                                                     \n");
//		queryStr.append("          O.EQ_TPSZ_CD,                                                                                                                                                                                \n");
//		queryStr.append("          O.CGO_TP_CD,                                                                                                                                                                                 \n");
//		queryStr.append("          O.FM_NOD_CD, O.TO_NOD_CD,                                                                                                                                                                    \n");
//		queryStr.append("          D.DCGO_IMO_CLSS_CD,                                                                                                                                                     \n");
//		queryStr.append("          B.POL_CD,                                                                                                                                                      \n");
//		queryStr.append("          O.CRE_DT                                                                                                                                                              \n");
//	  queryStr.append("  ) B                                                                                                                                                                                                  \n");
//		queryStr.append("  WHERE A.CNTR_NO = B.EQ_NO(+)                                                                                                                                                                         \n");
//
//
//
//		try {
//			con = getConnection();
//
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			//ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//			// 쿼리에 변수 세팅.
//			//if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    verifyOndockRailChargeContainerList()  ps ============" +ps);
//			int cnt = 1;
//
//
//				ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_no()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_tpsz_cd()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_sty_cd()));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("vndr_seq")));	//5
//
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("rcv_dt")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("vndr_seq")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));		//10
//
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_no()));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("rcv_dt")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("min_wrk_dt")));	//15
//
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("max_wrk_dt")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_no()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_tpsz_cd()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_sty_cd()));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("min_wrk_dt")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("max_wrk_dt")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_no()));
//               ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//
//               //추가 2007.02.27
//               ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getWrk_dt()));
//
//
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("yd_cd")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("min_wrk_dt")));
//               ps.setString(cnt++, JSPUtil.getNull((String)param_map.get("max_wrk_dt")));
//               ps.setString(cnt++, JSPUtil.getNull(model.getCntr_no()));
//
////			 Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL 1 :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL 2 :" + queryStr );
//			}
//
//			rs = ps.executeQuery();
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return dRs;
//	}

	/** MarineTerminalInvoiceManage의 RevisedVolume를 조회한다.<br>
	 *
	 * @param EsdTes9031Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchAutoRevisedVolume(EsdTes9031Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchAutoRevisedVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}

	/** MarineTerminalInvoiceManage의 RevisedVolume를 조회한다.<br>
	 *
	 * @param TesTmlSoCntrListVO tesTmlSoCntrListVO
	 * @param TesTmlSoDtlVO tesTmlSoDtlVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceRevisedVolume(TesTmlSoCntrListVO tesTmlSoCntrListVO, TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    searchTerminalInvoiceRevisedVolume()  ");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoCntrListVO != null){
				Map<String, String> mapVO = tesTmlSoCntrListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			if(tesTmlSoDtlVO != null){
				Map<String, String> mapVO = tesTmlSoDtlVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchTerminalInvoiceRevisedVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;

	}



	/** MarineTerminalInvoiceManage의 RehandlingVolume를 조회한다.<br>
	 *
	 * @param  EsdTes9231Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRehandlingVolume(EsdTes9231Event event) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchRehandlingVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;	

	}


	/**
	 * TerminalInvoiceContainerList의 데이타 모델을 DB에서 Createion한다<br>
	 *
	 * @param List<TesTmlSoCntrListVO> voList
	 * @param String lgsCostCd
	 * @see EsdTes0001Event
	 * @throws DAOException
	 */
	public void updateOnDockContainerListRvisFlg(List<TesTmlSoCntrListVO> voList, String lgsCostCd) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageDBDAO    updateContainerListRvisFlg() ============");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
//log.debug("\n[][updateContainerListRvisFlg][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> lgs_cost_cd==========>"+velParam.get("lgs_cost_cd"));

		try {
			velParam.put("lgs_cost_cd", lgsCostCd.substring(0, 2));
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOUpdateOnDockContainerListRvisFlgUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}		

	}
	
	/** searchStorageTotalAmount
	 * 
	 * @param  TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorageTotalAmount(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		  
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchStorageTotalAmountRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;		

	}	

	/**
	 * updateOnDockRvisVol RVIS 수정함<br>
	 *
	 * @param EsdTes9031Event event
	 * @see EsdTes0001Event
	 * @throws DAOException
	 */
	public void updateOnDockRvisVol(EsdTes9031Event event) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========OndockRailChargeInvoiceManageDBDAO    updateContainerListRvisFlg() ============");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getTesTmlSoDtlVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoDtlVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOUpdateOnDockRvisVolUSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}



	/** MarineTerminalInvoiceManage의 3rd Party Volume를 조회한다.<br>
	 *
	 * @param TesN3rdPtyIfVO tesN3rdPtyIfVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOnDockTrdPartyVolume(TesN3rdPtyIfVO tesN3rdPtyIfVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========MarineTerminalInvoiceManageDAO    searchManualTrdPartyVolume()  ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesN3rdPtyIfVO != null){
				Map<String, String> mapVO = tesN3rdPtyIfVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchOnDockTrdPartyVolumeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dbRowset;				
		
	}	
	
	/** 
	 * Verify Result가 NH인 Container List 조회
	 * 
	 * @param TesTmlSoCntrListVO tesTmlSoCntrListVO 
	 * @return List<SearchNotBkgNoCntrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCntcBkgNoCntrListVO> searchNotBkgNoCntrList(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		List<SearchCntcBkgNoCntrListVO> list = null; //new ArrayList<SearchCntcBkgNoCntrListVO>();
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if ( tesTmlSoHdrVO != null ) {
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchNotBkgNoCntrListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, SearchCntcBkgNoCntrListVO.class);

			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/** 
	 * TRS에서 찾은 BKG No.의 Status가 Cancelled인 경우의 BKG NO 찾기
	 * 
	 * @param  
	 * @return String
	 * @throws DAOException
	 */
	public String getCancelledBkgNoInfo(SearchCntcBkgNoCntrListVO searchCntcBkgNoCntrListVO) throws DAOException {
		log.debug("dao start getCancelledBkgNoInfo ============");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		String cancelledBkgNo = "";
		
		try {
			if ( searchCntcBkgNoCntrListVO != null ) {
				Map<String, String> mapVO = searchCntcBkgNoCntrListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOGetCancelledBkgNoInfoRSQL(), param, velParam);
			
			if(dbRowSet!= null && dbRowSet.next()){
				cancelledBkgNo = dbRowSet.getString("bkg_no");
			}
			
			return cancelledBkgNo;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/** 
	 * Status가 Cancelled가 아닌  BKG 정보 찾기
	 * 
	 * @param  
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getNotCancelledBkgNoInfo(String bkgNo) throws DAOException {
		log.debug("dao start getNotCancelledBkgNoInfo ============");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if ( bkgNo != null ) {				
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOGetNotCancelledBkgNoInfoRSQL(), param, velParam);
			
			return dbRowSet;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}

}