/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterDBDAO.java
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic.JointOperationLetterBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvMcsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvoiceCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAOJooCrrMrgVOCSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;
import com.hanjin.syscommon.common.table.JooLetterVO;
import com.hanjin.syscommon.common.table.JooLtrTmpltVO;


/**
 * ALPS JointOperationLetterDBDAO <br>
 * - ALPS-JointOperationAgreementSettlement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see JointOperationLetterBCImpl 참조
 * @since J2EE 1.6
 */
public class JointOperationLetterDBDAO extends DBDAOSupport {

    
	/**
	 * PersonInfo를 조회합니다.
	 * @param String car
	 * @return List<JooCntcMbrVO>
	 * @throws DAOException
	 */
	public List<JooCntcMbrVO> searchPersonInfo(String car)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCntcMbrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("jo_crr_cd", car);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationLetterDBDAOJooCntcMbrVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCntcMbrVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * Letter 전송정보를 조회한다.
	 * @param InvMcsLetterVO  invMcsLetterVO
	 * @return List<InvMcsLetterVO>
	 * @throws DAOException
	 */
	public List<InvMcsLetterVO> searchLetterSendList (InvMcsLetterVO  invMcsLetterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvMcsLetterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invMcsLetterVO != null){
				Map<String, String> mapVO = invMcsLetterVO .getColumnValues(); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOInvMcsLetterVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvMcsLetterVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
		/**
		 * 고객정보를 조회한다.
		 * @param String car
		 * @return List<CustCdNmVO>
		 * @throws DAOException
		 */
		public List<CustCdNmVO> searchCustCdNm(String car) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustCdNmVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				 Map<String, String> mapVO = new HashMap<String, String>();
				 mapVO.put("jo_crr_cd", car);

				 param.putAll(mapVO);
				 velParam.putAll(mapVO); 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOCustCdNmVORSQL(),	param, velParam);
				 list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustCdNmVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		 
		/**
		 * 
		 * 고객정보 Seq를  조회합니다.
		 * 
		 * @param  String car
		 * @param  String customer
		 * @return List<CarrierSeqVO>
		 * @throws DAOException
		 */
		public List<CarrierSeqVO> searchCarrierSeq(String car, String customer) throws DAOException {
			DBRowSet dbRowset = null;
			List<CarrierSeqVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				 Map<String, String> mapVO = new HashMap<String, String>();
				 mapVO.put("jo_crr_cd", car);
				 mapVO.put("customer_code", customer);

				 param.putAll(mapVO);
				 velParam.putAll(mapVO); 

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);

				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOCarrierSeqVORSQL(),	param, velParam);
				 list = (List) RowSetUtil.rowSetToVOs(dbRowset, CarrierSeqVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 *  Letter를 송부하기위하여 각 선사별 담당자에 상세정보를 조회합니다.
		 * 
		 * @param CustMemberVO custMemberVO
		 * @return List<CustMemberVO>
		 * @throws DAOException
		 */
		public List<CustMemberVO> searchMemberInfo(CustMemberVO custMemberVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustMemberVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{ 
				Map<String, String> mapVO = custMemberVO.getColumnValues(); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOCustMemberVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustMemberVO.class);
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * 선택한 선사에 Customer Seq와 CustomerName 정보를 조회
		 * @param String custCntCd
         * @param int custSeq
		 * @return CustCdInfoVO
		 * @throws DAOException
		 */
		public CustCdInfoVO searchCustCdInfo(String custCntCd, int custSeq) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustCdInfoVO> list = null;
			CustCdInfoVO rtnVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{ 
				Map<String, String> mapVO = new HashMap<String, String>(); 
				mapVO.put("cust_cnt_cd", custCntCd);
				mapVO.put("cust_seq", String.valueOf(custSeq));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOCustCdInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdInfoVO.class);
				
				if(list.size() > 0){
					rtnVO = (CustCdInfoVO)list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnVO;
		}

		/**
		 *  Letter를 송부하기위하여 각 선사별 담당자에 상세정보를 생성한다.
		 * 
		 * @param CustMemberVO custMemberVO
		 * @throws DAOException
		 */
		
		public void addMemberInfo(CustMemberVO custMemberVO) throws DAOException, Exception {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = custMemberVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new JointOperationLetterDBDAOJooCntcMbrVOCSQL(),
							param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		/**
		 * 
         *  Letter를 송부하기위하여 각 선사별 CrrCntSeq를 조회한다.
		 *
		 * @param  JooCntcMbrVO jooCntcMbrVO
		 * @throws DAOException
		 * @return List<JooCntcMbrVO>
		 * @author jang kang cheol
		 */
        public List<JooCntcMbrVO> searchCrrCntcSeq(JooCntcMbrVO jooCntcMbrVO) throws DAOException {
		    //crr_cntc_seq
            DBRowSet dbRowset = null;
            List<JooCntcMbrVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try{
                //query parameter
                Map<String, String> mapVO = jooCntcMbrVO.getColumnValues();
 
                param.putAll(mapVO);
                velParam.putAll(mapVO);

                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchCrrCntcSeqRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCntcMbrVO .class);
            }catch(SQLException se){
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
            }catch(Exception ex){
                log.error(ex.getMessage(),ex);
                throw new DAOException(new ErrorHandler(ex).getMessage());
            }
            return list;
		}
		/**
         *  Letter를 송부하기위하여 각 선사별 담당자에 상세정보를 수정한다.
		 * 
		 * @param CustMemberVO custMemberVO
		 * @throws DAOException
		 */
		public void modifyMemberInfo(CustMemberVO custMemberVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
				
			try {
				Map<String, String> mapVO = custMemberVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe
						.executeUpdate(
								(ISQLTemplate) new JointOperationLetterDBDAOJooCntcMbrVOUSQL(),
								param, velParam);
				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}			
		}

		/**
         *  Member Information을 삭제합니다.
		 * 
		 * @param  CustMemberVO custMemberVO
		 * @throws DAOException
		 * @author Lee Jun Bum
		 */
	     public void removeMemberInfo (CustMemberVO custMemberVO) throws DAOException {
	    	 
	    	 Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
					
				try {
					Map<String, String> mapVO = custMemberVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					SQLExecuter sqlExe = new SQLExecuter("");
					int result = sqlExe
							.executeUpdate(
									(ISQLTemplate) new JointOperationLetterDBDAOJooCntcMbrVODSQL(),
									param, velParam);
					if (result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}			  

	     }
	     
		/**
		 * Carrier Member정보를 조회합니다.
		 * 
		 * @param String car
		 * @return List<JooCntcMbrVO>
		 * @throws DAOException
		 */
	 	public List<JooCntcMbrVO> searchCarrierMemberInfo(String car) throws DAOException {
			DBRowSet dbRowset = null;
			List<JooCntcMbrVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

	 		try{
	 	        //query parameter
	 			Map<String, String> mapVO = new HashMap<String, String>();
	 			mapVO.put("jo_crr_cd", car);
	 			mapVO.put("crr_cntc_seq", "0");
	 			
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);

 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOJooCntcMbrRSQL(), param, velParam);
	 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooCntcMbrVO .class);
	 		}catch(SQLException se){
	 			log.error(se.getMessage(),se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		}catch(Exception ex){
	 			log.error(ex.getMessage(),ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}
	 		return list;
	 	}
	 	 
		/**
		 * Template Text No 조회합니다.
		 * 
		 * @param  String joLtrTpCd
		 * @param  String ofcCd
		 * @param  String userId
		 * @return List<JoTmpltNoVO>
		 * @throws DAOException
		 */
		public List<JoTmpltNoVO> searchTempalteTextNoList(String joLtrTpCd, String ofcCd, String userId) throws DAOException {
			DBRowSet dbRowset = null;
			List<JoTmpltNoVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				 Map<String, String> mapVO = new HashMap<String, String>();
				 mapVO.put("jo_ltr_tp_cd", joLtrTpCd);
				 mapVO.put("ofc_cd", ofcCd);
				 mapVO.put("user_id", userId);

				 param.putAll(mapVO);
				 velParam.putAll(mapVO); 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOJoTmpltNoVORSQL(),	param, velParam);
				 list = (List) RowSetUtil.rowSetToVOs(dbRowset, JoTmpltNoVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
 
		/**
		 * MCS, Invoice TempalteAddress 조회한다..
		 * 
		 * @param String ofcCd
		 * @return JooLtrTmpltVO
		 * @throws DAOException
		 */
		public JooLtrTmpltVO searchTempalteAddress(String ofcCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<JooLtrTmpltVO> list = null;
			JooLtrTmpltVO rtnVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{ 
				Map<String, String> mapVO = new HashMap<String, String>(); 
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOTmptAddressRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooLtrTmpltVO.class);
				
				if(list.size() > 0){
					rtnVO = (JooLtrTmpltVO)list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnVO;
		}
		
		
		/**
		 *  MCS, Invoice Template를 조회 
		 * @param String joLtrTpCd
		 * @param String joTmpltNo
		 * @param String ofcCd
		 * @return JooLtrTmpltVO 
		 * @throws DAOException
		 */
		public JooLtrTmpltVO searchTemplate (String joLtrTpCd,String joTmpltNo, String ofcCd) throws DAOException {
			DBRowSet dbRowset = null;
			List<JooLtrTmpltVO > list = null;
			JooLtrTmpltVO rtnVO = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{ 
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("jo_ltr_tp_cd", joLtrTpCd);
				mapVO.put("jo_tmplt_no", joTmpltNo);
				mapVO.put("ofc_cd", ofcCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOJooLtrTmpltVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooLtrTmpltVO .class);
				if(list.size() > 0){
					rtnVO = (JooLtrTmpltVO)list.get(0);
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnVO;
		}
 
		/**
		 *  MCS, Invoice Template 생성한다.
		 * 
		 * @param JooLtrTmpltVO  jooLtrTmpltVO
		 * @throws DAOException
		 */
		public void addTemplate (JooLtrTmpltVO  jooLtrTmpltVO) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = jooLtrTmpltVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOJooLtrTmpltVOCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 *  MCS, Invoice Template 저장-수정 처리 
		 * 
		 * @param JooLtrTmpltVO  jooLtrTmpltVO
		 * @throws DAOException
		 */
		public void modifyTemplate(JooLtrTmpltVO  jooLtrTmpltVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = 0;
			try {
				Map<String, String> mapVO = jooLtrTmpltVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOJooLtrTmpltVOUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 *  MCS, Invoice Template 삭제<br>
		 *  
		 * @param String joLtrTpCd
		 * @param String joTmpltNo
		 * @param String ofcCd
		 * @throws DAOException
		 */
	     public void removeTemplate  (String joLtrTpCd,String joTmpltNo, String ofcCd) throws DAOException {
		    	  
		 		try {
		 			SQLExecuter sqlExe = new SQLExecuter("");
		 			int insCnt = 0;
		 			
		 	        //query parameter
		 	        Map<String, Object> param = new HashMap<String, Object>();
		 	        param.put("jo_ltr_tp_cd", joLtrTpCd);
		 	        param.put("jo_tmplt_no", joTmpltNo);
		 	        param.put("ofc_cd", ofcCd);
							
		 	        //삭제 
		 	        insCnt = sqlExe.executeUpdate((ISQLTemplate) new JointOperationLetterDBDAOJooLtrTmpltVODSQL() , param, null);
					if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove SQL");
		 			
		 		} catch (SQLException se) {
		 			log.error(se.getMessage(), se);
		 			throw new DAOException(new ErrorHandler(se).getMessage());
		 		} catch (Exception ex) {
		 			log.error(ex.getMessage(), ex);
		 			throw new DAOException(new ErrorHandler(ex).getMessage());
		 		}
	    }
	     
	     /**
	      * 
	      * [MCS & Invoice Letter Fax/E-mail Inquiry]을 [조회Retrieve]합니다.<br>
	      * @param  String ofcCd
	      * @param  String userId
	      * @param  String fmDt
	      * @param  String toDt
	      * @return List<LetterVO>
	      * @throws DAOException
	      * @author jang kang cheol
	      */ 
        public List<LetterVO> searchLetterSendStsList(String ofcCd, String userId,String fmDt, String toDt) throws DAOException {
	            DBRowSet dbRowset = null;
	            List<LetterVO> list = null;
	            //query parameter
	            Map<String, Object> param = new HashMap<String, Object>();
	            //velocity parameter
	            Map<String, Object> velParam = new HashMap<String, Object>();
	            try{ 
	                Map<String, String> mapVO = new HashMap<String, String>();
	                
	                mapVO.put("ofc_cd"       , ofcCd);
	                mapVO.put("cre_usr_id"   , userId);
	                mapVO.put("ltr_iss_dt_fr", fmDt);
                    mapVO.put("ltr_iss_dt_to", toDt);	                
 
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchLetterSendStsListRSQL(), param, velParam);
	                list = (List)RowSetUtil.rowSetToVOs(dbRowset, LetterVO .class);
	            }catch(SQLException se){
	                log.error(se.getMessage(),se);
	                throw new DAOException(new ErrorHandler(se).getMessage());
	            }catch(Exception ex){
	                log.error(ex.getMessage(),ex);
	                throw new DAOException(new ErrorHandler(ex).getMessage());
	            }
	            return list;     
	     }
         /**
          * 
          * [MCS Letter Information Creation]을 [조회 Get]합니다.<br>
          *
          * @param  LetterVO letterVO
          * @throws DAOException
          * @return List<TextNoVO> 
          * @author jang kang cheol
          */ 
        public  List<TextNoVO> searchMcsTextNo(LetterVO letterVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<TextNoVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                 Map<String, String> mapVO = letterVO.getColumnValues();
 
                 param.putAll(mapVO);
                 velParam.putAll(mapVO); 
                 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOSearchMcsTextNoRSQL(),   param, velParam);
                 list = (List) RowSetUtil.rowSetToVOs(dbRowset, TextNoVO.class);
            } catch (SQLException se) {
                log.error(se.getMessage(), se);
                throw new DAOException(new ErrorHandler(se).getMessage());
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new DAOException(new ErrorHandler(ex).getMessage());
            }
            return list;
         }	    
        /**
         * 
         * [MCS Letter Information Creation]을 [조회 Get]합니다.<br>
         *
         * @param   LetterVO letterVO
         * @throws  DAOException
         * @return  List<McsLetterVO>
         * @author  jang kang cheol
         */ 
       public List<McsLetterVO> searchMcsLetter(LetterVO letterVO) throws DAOException {
               DBRowSet dbRowset = null;
               List<McsLetterVO> list = null;
               //query parameter
               Map<String, Object> param = new HashMap<String, Object>();
               //velocity parameter
               Map<String, Object> velParam = new HashMap<String, Object>();
               try{ 
                   Map<String, String> mapVO =  letterVO.getColumnValues();
 
                   param.putAll(mapVO);
                   velParam.putAll(mapVO);

                   dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchMcsLetterRSQL(), param, velParam);
                   list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsLetterVO .class);
               }catch(SQLException se){
                   log.error(se.getMessage(),se);
                   throw new DAOException(new ErrorHandler(se).getMessage());
               }catch(Exception ex){
                   log.error(ex.getMessage(),ex);
                   throw new DAOException(new ErrorHandler(ex).getMessage());
               }
               return list;     
        }      
       /**
        * 
        * [MCS Letter Information Creation]을 [조회 Retrieve]합니다.<br>
        *
        * @param   McsCombinedVO mcsCombinedVO
        * @throws  DAOException
        * @return  List<McsCombinedVO>
        * @author  jang kang cheol
        */ 
      public List<McsCombinedVO> searchMcsCombined(McsCombinedVO mcsCombinedVO) throws DAOException {
              DBRowSet dbRowset = null;
              List<McsCombinedVO> list = null;
              //query parameter
              Map<String, Object> param = new HashMap<String, Object>();
              //velocity parameter
              Map<String, Object> velParam = new HashMap<String, Object>();
              try{ 
                  Map<String, String> mapVO = mcsCombinedVO .getColumnValues(); 
                  
                  if(mcsCombinedVO != null){
 
                      param.putAll(mapVO);
                      velParam.putAll(mapVO);
                      
                      List<String> aryYdSeq = new ArrayList();   
                      String tmpRlanceCd =  mcsCombinedVO.getRlaneCd();
                      
                      String[] sRlaneCd =     tmpRlanceCd.split("\\|");
 
                      for(int i = 0; i < sRlaneCd.length ; i++){   
                          aryYdSeq.add(sRlaneCd[i]  );   
                      }
                      velParam.put("rlane_cds", aryYdSeq);                      
                  }                  
 
                  dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchMcsCombinedRSQL(), param, velParam);
                  list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsCombinedVO .class);
              }catch(SQLException se){
                  log.error(se.getMessage(),se);
                  throw new DAOException(new ErrorHandler(se).getMessage());
              }catch(Exception ex){
                  log.error(ex.getMessage(),ex);
                  throw new DAOException(new ErrorHandler(ex).getMessage());
              }
              return list;     
       }        
     
      
      
      
      /**
       * 
       * Mcs Letter 정보를 신규저장.<br>
       * 
       * 
       * @param  LetterVO letterVO
       * @throws DAOException
       * @author jang kang cheol
       */
      public void addMcsLetter ( LetterVO  letterVO) throws DAOException,Exception {
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();
          try {
              Map<String, String> mapVO = letterVO.getColumnValues();

              param.putAll(mapVO);
              velParam.putAll(mapVO);

              SQLExecuter sqlExe = new SQLExecuter("");
              int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOAddMcsLetterCSQL(), param, velParam);
              if(result == Statement.EXECUTE_FAILED)
                      throw new DAOException("Fail to insert SQL");
          } catch (SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
      }
      
      
      /**
       * 
       * Mcs Letter 상세정보를  등록 합니다<br>
       *
       * @param  List<LetterVO> letterVOs
       * @throws DAOException
       * @author jang kang cheol
       */
      public void addMcsLetterStl(List<LetterVO> letterVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("");
              int insCnt[] = null;
              if(letterVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationLetterDBDAOAddMcsLetterStlCSQL(), letterVOs,null);
                  for(int i = 0; i < insCnt.length; i++){
                      if(insCnt[i]== Statement.EXECUTE_FAILED)
                          throw new DAOException("Fail to insert No"+ i + " SQL");
                  }
              }
          } catch (SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
      }

      
      /**
       * 
       * Letter정보의 Attach File정보를  등록 합니다<br>
       *
       * @param  List<LetterVO> letterVOs
       * @throws DAOException
       * @author jang kang cheol
       */
      public void addLetterAttach(List<LetterVO> letterVOs) throws DAOException,Exception {
          try {
              SQLExecuter sqlExe = new SQLExecuter("");
              int insCnt[] = null;
              if(letterVOs.size() > 0){
                  insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationLetterDBDAOAddLetterAttachCSQL(), letterVOs,null);
                  for(int i = 0; i < insCnt.length; i++){
                      if(insCnt[i]== Statement.EXECUTE_FAILED)
                          throw new DAOException("Fail to insert No"+ i + " SQL");
                  }
              }
          } catch (SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
      }  
      /**
       * 
       * Mdm_Customer 자료를 CarCd로 조회합니다.<br>
       *
       * @param  String carCd
       * @return  List<McsLetterVO> 
       * @throws DAOException
       * @author jang kang cheol
       */
      public   List<McsLetterVO> searchToCustList(String carCd) throws DAOException,EventException {
          DBRowSet dbRowset = null;
          List<McsLetterVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();
          try{ 
              Map<String, String> mapVO = new HashMap<String, String>();
              mapVO.put("jo_crr_cd", carCd);
              
              param.putAll(mapVO);
              velParam.putAll(mapVO);

              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchToCustListRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, McsLetterVO .class);
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;             
      }
     /**
      * 
      * Letter정보를 저장하기위한 Key - SEQ을 추출합니다.<br>
      *
      * @throws DAOException
      * @return String
      * @author jang kang cheol
      */
     public String  searchJoLtrSeq() throws DAOException,EventException {
         DBRowSet dbRowset = null;
         String sJoLtrSeq = ""; 
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try{ 
             Map<String, String> mapVO = new HashMap<String, String>();
 
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchJoLtrSeqRSQL(), param, velParam);
             if(dbRowset.next()){
                 sJoLtrSeq =  dbRowset.getString("JO_LTR_SEQ");
             }
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return sJoLtrSeq;             
     }
     
     
     
     
     /**
      * 
      * Mail 전송후 결과 처리합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @throws Exception
      * @author jang kang cheol
      */
     public void modifyEmailResult ( LetterVO  letterVO) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOModifyEmailResultUSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
          
     /**
      * 
      * Fax 전송후 결과 처리합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @throws Exception
      * @author jang kang cheol
      */
     public void modifyFaxResult ( LetterVO  letterVO) throws DAOException,Exception {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOModifyFaxResultUSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");
         } catch (SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }
     /**
      * 
      * 저장시 Letter정보의  JO_LTR_NO 을 추출합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @throws EventException
      * @return String
      * @author jang kang cheol
      */
     public String  searchJoLtrNo( LetterVO  letterVO) throws DAOException,EventException {
         DBRowSet dbRowset = null;
         String sJoLtrNo = ""; 
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try{ 
             Map<String, String> mapVO = letterVO.getColumnValues();
 
             
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchJoLtrNoRSQL(), param, velParam);
             if(dbRowset.next()){
                 sJoLtrNo =  dbRowset.getString("JO_LTR_NO");
             }
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return sJoLtrNo;             
     }     
     /**
      * 
      * Letter정보를   삭제 합니다.<br>
      *
      * @param   LetterVO letterVO
      * @throws DAOException
      * @throws EventException
      * @author jang kang cheol
      */     
     public void removeLetter (LetterVO letterVO) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             SQLExecuter sqlExe = new SQLExecuter("");
             Map<String, String> mapVO = letterVO.getColumnValues();
 
             param.putAll(mapVO);
             velParam.putAll(mapVO);
             //삭제 
             sqlExe.executeUpdate((ISQLTemplate) new JointOperationLetterDBDAORemoveMcsLetterDSQL() , param, null);
         } catch (SQLException se) {
             log.error(se.getMessage(), se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch (Exception ex) {
             log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
      }   
     /**
      * 
      * Letter 상세정보를 삭제 합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @author jang kang cheol
      */         
     public void removeLetterStl (LetterVO letterVO) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             SQLExecuter sqlExe = new SQLExecuter("");
             Map<String, String> mapVO = letterVO.getColumnValues();
 
             param.putAll(mapVO);
             velParam.putAll(mapVO);
             //삭제 
             sqlExe.executeUpdate((ISQLTemplate) new JointOperationLetterDBDAORemoveLetterStlDSQL() , param, null);
         } catch (SQLException se) {
             log.error(se.getMessage(), se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch (Exception ex) {
             log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
      }  
     
     
     /**
      * 
      * Letter정보의 파일첨부를 삭제 합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @author jang kang cheol
      */         
     public void removeLetterAttach (LetterVO letterVO) throws DAOException {
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             SQLExecuter sqlExe = new SQLExecuter("");
             Map<String, String> mapVO = letterVO.getColumnValues();
 
             param.putAll(mapVO);
             velParam.putAll(mapVO);
             //삭제 
             sqlExe.executeUpdate((ISQLTemplate) new JointOperationLetterDBDAORemoveLetterAttachDSQL() , param, null);
         } catch (SQLException se) {
             log.error(se.getMessage(), se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch (Exception ex) {
             log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
      }      
     /**
      * 
      * [Invoice Letter Information Creation]을 [조회 Get]합니다.<br>
      *
      * @param  LetterVO letterVO
      * @throws DAOException
      * @return List<TextNoVO> 
      * @author jang kang cheol
      */ 
    public  List<TextNoVO> searchInvoiceTextNo(LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<TextNoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO =  letterVO.getColumnValues();
             
             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOSearchInvoiceTextNoRSQL(),   param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, TextNoVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se); 
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
     }
    /**
     * 
     * [MCS Letter Information Creation]을 [조회 Get]합니다.<br>
     *
     * @param   LetterVO letterVO
     * @throws  DAOException
     * @return  List<InvoiceCombinedVO>
     * @author  jang kang cheol
     */ 
   public List<InvoiceCombinedVO> searchInvoiceLetter( LetterVO letterVO) throws DAOException {
           DBRowSet dbRowset = null;
           List<InvoiceCombinedVO> list = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();
           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();
           try{ 
               Map<String, String> mapVO = letterVO.getColumnValues();

               param.putAll(mapVO);
               velParam.putAll(mapVO);

               dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOSearchMcsLetterRSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCombinedVO .class);
           }catch(SQLException se){
               log.error(se.getMessage(),se);
               throw new DAOException(new ErrorHandler(se).getMessage());
           }catch(Exception ex){
               log.error(ex.getMessage(),ex);
               throw new DAOException(new ErrorHandler(ex).getMessage());
           }
           return list;     
    }    
   /**
    * 
    * [Invoice Letter Information Creation]을 [조회 Retrieve]합니다.<br>
    *
    * @param   InvoiceCombinedVO invoiceCombinedVO
    * @throws  DAOException
    * @return  List<InvoiceCombinedVO>
    * @author  jang kang cheol
    */ 
  public List<InvoiceCombinedVO> searchInvoiceCombined(InvoiceCombinedVO invoiceCombinedVO) throws DAOException {
          DBRowSet dbRowset = null;
          List<InvoiceCombinedVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();
          try{ 
              Map<String, String> mapVO = invoiceCombinedVO .getColumnValues(); 
              
              if(invoiceCombinedVO != null){ 
                  param.putAll(mapVO);
                  velParam.putAll(mapVO);
 
                  List<String> aryYdSeq = new ArrayList();   
                  String stlCmbSeq =  invoiceCombinedVO.getStlCmbSeq();
                  
                  String[] sStlCmbSeq =     stlCmbSeq.split("\\|");

                  for(int i = 0; i < sStlCmbSeq.length ; i++){   
                      aryYdSeq.add(sStlCmbSeq[i]  );   
                  }
                  velParam.put("stlcmbseq", aryYdSeq);  
              }                  

              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new  JointOperationLetterDBDAOSearchInvoiceCombinedRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCombinedVO .class);
          }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;     
   }
  /**
   * 
   * [Invoice Letter Information Creation의 Ltr Stl 정보를 ]을 [조회 Retrieve]합니다.<br>
   *
   * @param   InvoiceCombinedVO invoiceCombinedVO
   * @throws  DAOException
   * @return  List<InvoiceCombinedVO>
   * @author  jang kang cheol
   */ 
 public List<InvoiceCombinedVO> searchSavedJooLtrStl(InvoiceCombinedVO invoiceCombinedVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<InvoiceCombinedVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try{ 
             Map<String, String> mapVO = invoiceCombinedVO .getColumnValues(); 
             
             if(invoiceCombinedVO != null){ 
                 param.putAll(mapVO);
                 velParam.putAll(mapVO); 
             }                  

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new  JointOperationLetterDBDAOSearchSavedJooLtrStlRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCombinedVO .class);
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;     
  }
  /**
   * 
   * Invoice Letter정보를  등록 합니다.<br>
   *
   * @param  LetterVO letterVO
   * @throws DAOException
   * @throws Exception
   * @author jang kang cheol
   */
  public void addInvoiceLetter ( LetterVO  letterVO) throws DAOException,Exception {
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();
      try {
          Map<String, String> mapVO = letterVO.getColumnValues();

          param.putAll(mapVO);
          velParam.putAll(mapVO);

          SQLExecuter sqlExe = new SQLExecuter("");
          int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOAddMcsLetterCSQL(), param, velParam);
          if(result == Statement.EXECUTE_FAILED)
                  throw new DAOException("Fail to insert SQL");
      } catch (SQLException se) {
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
          log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
      }
  }
  /**
   * 
   * Letter상세정보를  등록 합니다<br>
   *
   * @param  LetterVO letterVO
   * @throws DAOException
   * @throws Exception
   * @author jang kang cheol
   */
  public void addInvoiceLetterStls(LetterVO letterVO) throws DAOException,Exception {
      //query parameter
      Map<String, Object> param = new HashMap<String, Object>();
      //velocity parameter
      Map<String, Object> velParam = new HashMap<String, Object>();
      try {
          SQLExecuter sqlExe = new SQLExecuter("");
 
          Map<String, String> mapVO = letterVO.getColumnValues();
 
          if(letterVO != null){ 
              param.putAll(mapVO);
              velParam.putAll(mapVO);

              List<String> aryYdSeq = new ArrayList();   
              String stlCmbSeq =  letterVO.getStlCmbSeq();
              
              String[] sStlCmbSeq =     stlCmbSeq.split("\\|");

              for(int i = 0; i < sStlCmbSeq.length ; i++){   
                  aryYdSeq.add(sStlCmbSeq[i]  );   
              }
              velParam.put("stlcmbseq", aryYdSeq);  
          }  
 
          int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationLetterDBDAOAddInvoiceLetterStlCSQL(), param, velParam);
          if(result == Statement.EXECUTE_FAILED)
                  throw new DAOException("Fail to insert SQL");
          
      } catch (SQLException se) {
          log.error(se.getMessage(),se);
          throw new DAOException(new ErrorHandler(se).getMessage());
      }catch(Exception ex){
          log.error(ex.getMessage(),ex);
          throw new DAOException(new ErrorHandler(ex).getMessage());
      }
  }  
 
  /**
   * 
   * [Bank detail & Signature Office]을 [조회 Get]합니다.<br>
   * 
   * @param   LetterVO letterVO
   * @throws  DAOException
   * @return  List<LetterVO>
   * @author  jang kang cheol
   */ 
 public List<LetterVO> searchOfficeCd(LetterVO letterVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<LetterVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try{ 
             Map<String, String> mapVO = letterVO.getColumnValues();
             param.putAll(mapVO);
             velParam.putAll(mapVO);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationAgreementSettlementDAOSearchOfficeCdRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, LetterVO .class);
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;     
  }       
     /**
      * 
      * [Bank detail & Signature의  User Nm]을 [조회 Get]합니다.<br>
      * @param   LetterVO letterVO
      * @throws  DAOException
      * @return  List<LetterVO>
      * @author  jang kang cheol
      */ 
    public List<LetterVO> searchUserNm(LetterVO letterVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<LetterVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            try{ 
                Map<String, String> mapVO = letterVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
    
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationAgreementSettlementDAOSearchUserNmRSQL(), param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, LetterVO .class);
            }catch(SQLException se){
                log.error(se.getMessage(),se);
                throw new DAOException(new ErrorHandler(se).getMessage());
            }catch(Exception ex){
                log.error(ex.getMessage(),ex);
                throw new DAOException(new ErrorHandler(ex).getMessage());
            }
            return list;     
     }
    /**
     * Bank detail & Signature의  Retrieve
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws DAOException
     */
    public List<LetterVO> searchSignNBank(LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAgreementSettlementDAOSearchSignNBankRSQL(), param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
     * 
     * Bank detail & Signature의  JO_TMPLT_NO 값을 조회 합니다. <br>
     *
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws DAOException
     * @author jang kang cheol
     */
    public List<LetterVO> getNewTmpltSeqNo(LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{ 
            Map<String, String> mapVO = letterVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOGetNewTmpltSeqNoRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list; 
    }
    /**
     * Bank detail & Signature의  Save
     * 
     * @param  LetterVO letterVO
     * @throws DAOException
     */
    public void addSignNBank(LetterVO letterVO) throws DAOException {
 
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO); 

             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationAgreementSettlemenDAOAddSignNBankCSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");             
             
      
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
 
    }
    /**
     * Bank detail & Signature의  Retrieve
     * @param  LetterVO letterVO
     * @throws DAOException
     */
    public void removeSignNBank(LetterVO letterVO) throws DAOException {
 
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = letterVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO); 
            
             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationAgreementSettlemenDAORemoveSignNBankDSQL(), param, velParam);
             
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to insert SQL");              
 
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
 
    }
    /**
     * Template Seq정보목록을 조회합니다.
     * 
     * @param  String joLtrTpCd
     * @param  String ofcCd
     * @param  String userId
     * @return List<LetterVO>
     * @throws DAOException
     */
    public List<LetterVO> searchTempalteSeqList(String joLtrTpCd, String ofcCd, String userId) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = new HashMap<String, String>();
             mapVO.put("jo_ltr_tp_cd", joLtrTpCd);
             mapVO.put("ofc_cd", ofcCd);
             mapVO.put("user_id", userId);

             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOSearchTempalteSeqListRSQL(), param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }    
    /**
     * 
     * Letter정보를  Pk(JO_LTR_SEQ)키로 조회합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws DAOException
     * @return List<LetterVO>
     * @author jang kang cheol
     */
    public List<LetterVO> searchJooLetter( LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = letterVO.getColumnValues();
             
             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationLetterDBDAOSearchJooLetterRSQL(), param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * 
     * Letter상세정보를  Key(JO_LTR_SEQ)키로 조회합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws DAOException
     * @return List<LetterVO>
     * @author jang kang cheol
     */
    public List<LetterVO> searchJooLtrStl( LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationLetterDBDAOSearchJooLtrStlRSQL(), param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }  
     /**
     * 
     * 사용자 정보를 조회합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List<LetterVO>
     * @author jang kang cheol
     */
    public List<LetterVO>  searchComUserInfo(LetterVO letterVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<LetterVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
             Map<String, String> mapVO = letterVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO); 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationLetterDBDAOSearchComUserInfoRSQL(), param, velParam);
             list = (List) RowSetUtil.rowSetToVOs(dbRowset, LetterVO.class);
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
	 * PIC of User 정보를 조회합니다.<br>
	 * 
	 * @param String joCntcPicId
	 * @return PicOfUserInfoVO
	 * @throws DAOException
	 */
 	public PicOfUserInfoVO searchPicUserIdInfo(String joCntcPicId) throws DAOException {
		DBRowSet dbRowset = null;
		List<PicOfUserInfoVO> list = null;
		PicOfUserInfoVO picOfUserInfoVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 		try{
 	        //query parameter
 			Map<String, String> mapVO = new HashMap<String, String>();
 			mapVO.put("jo_cntc_pic_id", joCntcPicId);
 			
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationLetterDBDAOPicOfUserInfoVORSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PicOfUserInfoVO .class);
 			if (list.size() > 0) picOfUserInfoVO = list.get(0);
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return picOfUserInfoVO;
 	}
 
}