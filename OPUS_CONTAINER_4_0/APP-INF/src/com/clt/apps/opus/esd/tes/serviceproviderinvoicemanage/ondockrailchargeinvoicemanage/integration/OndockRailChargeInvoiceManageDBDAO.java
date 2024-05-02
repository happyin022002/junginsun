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
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchBkgCntrTPCDListRSQL;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration.MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9031Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9231Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD에 대한 DB 처리를 담당<br>
 * ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author parkyeonjin
 * @see OndockRailChargeInvoiceManageBCImpl 참조
 * @since J2EE 1.4
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



	/** multiOndockRailChargeInvoiceDetailInsert
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void multiOndockRailChargeInvoiceDetailInsert(List<TesTmlSoDtlVO> voList) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
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
	 * @param  String agmtCostYN
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchOndockRailChargeCostCalculationListNew(EsdTes0064Event event, String agmtCostYN) throws DAOException {
		
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
			
			velParam.put("agmt_cost_yn", agmtCostYN);
			
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
		
log.debug("velParam whereColumn1========>"+velParam.get("whereColumn1"));
log.debug("velParam whereColumn2========>"+velParam.get("whereColumn2"));
log.debug("velParam whereColumn1Value========>"+velParam.get("whereColumn1Value"));
log.debug("velParam whereColumn2Value========>"+velParam.get("whereColumn2Value"));

log.debug("Param whereColumn1Value========>"+param.get("whereColumn1Value"));
log.debug("Param whereColumn2Value========>"+param.get("whereColumn2Value"));

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
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			if(event.getTesTmlSoCntrListVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoCntrListVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(event.getTesCommonVO() != null){
				Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
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
	
	/** searchTerminalInvoiceRevisedVolumeTPB
	 * 
	 * @param tesTmlSoCntrListVO
	 * @param tesTmlSoDtlVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTerminalInvoiceRevisedVolumeTPB(TesTmlSoCntrListVO tesTmlSoCntrListVO, TesTmlSoDtlVO tesTmlSoDtlVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("==========OndockRailChargeInvoiceManageDBDAO    searchTerminalInvoiceRevisedVolumeTPB()  ");

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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OndockRailChargeInvoiceManageDBDAOSearchTerminalInvoiceRevisedVolumeTPBRSQL(), param, velParam);

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
	 * 9130 Search CNTR TYPE CD List<br>
	 * 
	 * @param TesFileImpTmpVO tesFileImpTmpVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	
	public String searchBkgCntrTPCDList(TesFileImpTmpVO tesFileImpTmpVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("cntr_no", tesFileImpTmpVO.getCntrNo() );
			velParam.put("cntr_no", tesFileImpTmpVO.getCntrNo() );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchBkgCntrTPCDListRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnVal = dbRowset.getString("CNTR_TPSZ_CD");
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
		
		return rtnVal;
	}


}