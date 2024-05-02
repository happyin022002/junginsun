/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtDBDAO.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.10 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.integration.FinCommonDBDAOCheckInvoiceNoRSQL;
import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration.RepairMgtDBDAOsearchMnrOrdSeqDataRSQL;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
 
/**
 * COM InterfaceMgtDBDAO <br>
 * - COM-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author LEE JU HYUN
 * @see interfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class InterfaceMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 견적서 넣을 SEQ을 조회합니다. <br>
	 *
	 * @param  CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO searchEstimateSeqByRefNoData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchEstimateSeqByRefNoDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);

			 if(customMnrRprRqstHdrVOS.size() > 0){
				 customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return customMnrRprRqstHdrVO;
	 }

	/**
	  * [Receive MQ] EDI로 들어온 견적서를 플레그 재처리 합니다. <br>
	  *
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @param String EdiErrCd
	  * @return int
	  * @exception DAOException
	  */
	 public int modifyESTTempFlagData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO,String EdiErrCd) throws DAOException {
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;

		 try {
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 param.put("edi_err_cd", EdiErrCd);
			 velParam.put("edi_err_cd", EdiErrCd);

			 SQLExecuter sqlExe = new SQLExecuter("");
			 result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyESTTempFlagDataUSQL(), param, velParam);

			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to Update modifyESTTempFlagData");
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return result;
	 }

	/**
	  * [EES_MNR_0022] TPB 전용 Interface Method <br>
	  * [EES_MNR_0023] TPB 전용 Interface Method <br>
	  * @param 	String 				rqstEqNo
	  * @return List<ApPayInvDtlVO>	tPBInterfaceVOS
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<TPBInterfaceVO> searchTPBInterfaceListData(String rqstEqNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TPBInterfaceVO> tPBInterfaceVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put("rqst_eq_no",rqstEqNo);
			 velParam.put("rqst_eq_no",rqstEqNo);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTPBInterfaceListDataRSQL(), param, velParam);
			 tPBInterfaceVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, TPBInterfaceVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return tPBInterfaceVOS;
	 }

	 /**
	  * Receive MQ 연동 처리 <br>
	  * @param 	   CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return    String
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String searchEqTypeByEqNoData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrEqStsVVO> customMnrEqStsVVOS = null;
		 String returnEqType = "";

		 try{
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();

			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEqTypeByEqNoDataRSQL(), param, velParam);
			 customMnrEqStsVVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVVO .class);

			 if(customMnrEqStsVVOS.size() > 0){
				 returnEqType = customMnrEqStsVVOS.get(0).getEqType();
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnEqType;
	 }

	/**
	 * 파일 일련번호 정보를 조회합니다.<br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String createMnrFileAtchSeqData() throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOcreateMnrFileAtchSeqDataRSQL(), param, velParam);
			if(dbRowset.next()){
				returnVal = dbRowset.getString("file_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}

	/**
	 * 파일 정보를 생성합니다.<br>
	 *
	 * @param List<CustomMnrFileAtchVO> customMnrFileAtchVOS
	 * @exception DAOException
	 */
	public void addFileUploadData(List<CustomMnrFileAtchVO> customMnrFileAtchVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrFileAtchVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOaddFileUploadDataCSQL(), customMnrFileAtchVOS,null);
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
	 * 파일 정보를 수정합니다.<br>
	 *
	 * @param List<CustomMnrFileAtchVO> CustomMnrFileAtchVOS
	 * @exception DAOException
	 */
	public void modifyFileUploadData(List<CustomMnrFileAtchVO> CustomMnrFileAtchVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(CustomMnrFileAtchVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOmodifyFileUploadDataUSQL(), CustomMnrFileAtchVOS,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 파일 정보를 삭제합니다.<br>
	 *
	 * @param List<CustomMnrFileAtchVO> CustomMnrFileAtchVOS
	 * @exception DAOException
	 */
	public void removeFileUploadData(List<CustomMnrFileAtchVO> CustomMnrFileAtchVOS) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(CustomMnrFileAtchVOS.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOremoveFileUploadDataDSQL(), CustomMnrFileAtchVOS,null);

				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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
	 * 파일 정보를 삭제합니다.(file_seq에 해당하는)<br>
	 *
	 * @param String fileSeq
	 * @exception DAOException
	 */
	public void removeFileUploadAllData(String fileSeq) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("file_seq", fileSeq);

			sqlExe.executeUpdate(new InterfaceMgtDBDAOremoveFileUploadAllDataDSQL(), param, null);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 *  파일 정보를 조회합니다.(file_seq에 해당하는)<br>
	 *
	 * @param String fileSeq
	 * @return List<CustomMnrFileAtchVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomMnrFileAtchVO> searchFileUploadData(String fileSeq) throws DAOException {

		List<CustomMnrFileAtchVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 if(fileSeq != null){
				 param.put("file_seq", fileSeq);
				 velParam.put("file_seq", fileSeq);
			 }

			DBRowSet dbRowset = new SQLExecuter().executeQuery(new InterfaceMgtDBDAOsearchFileUploadDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrFileAtchVO.class);

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
	 * MQ 견적서템프 헤더 데이타를  삽입한다.<br>
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addTempEstimateHDRData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempEstimateHDRDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addTempEstimateHDRData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * New Port Data Verify Result Update<br>
	 * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNewPortTmpDtlData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyNewPortTmpDtlDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyNewPortTmpDtlData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * New Port Data Verify Result Update<br>
	 * @param CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNewPortTmpHdrData(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyNewPortTmpHdrDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyNewPortTmpHdrData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * MQ 견적서템프 DTL 데이타를  삽입한다.<br>
	 * @param CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int addTempEstimateDTLData(CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrRprRqstTmpDtlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempEstimateDTLDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addTempEstimateDTLData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	  * 견적서 템프 헤더에서 RQST_SEQ와 VER NO을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return CustomMnrRprRqstTmpHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstTmpHdrVO searchTempEstimateSeqData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstTmpHdrVO retCustomMnrRprRqstTmpHdrVO = null;
		 List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempEstimateSeqDataRSQL(), param, velParam);
			 customMnrRprRqstTmpHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstTmpHdrVO .class);

			 if(customMnrRprRqstTmpHdrVOS.size() > 0){
				 retCustomMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return retCustomMnrRprRqstTmpHdrVO;
	 }

	 /**
	  * 견적서 템프에 사용할 vetify cd 을 조회합니다.<br>
	  * @param  CustomMnrRprRqstTmpHdrVO	customMnrRprRqstTmpHdrVO
	  * @return String	returnVal
	  * @throws DAOException
	  */
	 public String searchEQFlagFileListByEQData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEQFlagFileListByEQDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 returnVal = dbRowset.getString("EQ_CHK");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }

	 /**
	  * 견적서 템프에 사용할 TPSZ 을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return String
	  * @exception DAOException
	  */
	 public String searchTempEstimateTpszData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempEstimateTpszDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 returnVal = dbRowset.getString("TPSZ_CD");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }

	 /**
	  * 견적서 템프 디테일에 사용할 TPSZ 을 조회합니다.<br>
	  * @param String eqType
	  * @param String tpSz
	  * @param String cmpoCd
	  * @return String
	  * @exception DAOException
	  */
	 public String searchTempEstimateCostCdData(String eqType,String tpSz,String cmpoCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 param.put("eq_knd_cd",eqType);
			 param.put("tp_sz",tpSz);
			 param.put("cmpo_cd",cmpoCd);
			 velParam.put("eq_knd_cd",eqType);
			 velParam.put("tp_sz",tpSz);
			 velParam.put("cmpo_cd",cmpoCd);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempEstimateCostCdDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 returnVal = dbRowset.getString("COST_CD");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }
	 
	 /**
	  * 견적서 템프 디테일에 사용할 TPSZ 을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO
	  * @return String
	  * @exception DAOException 
	  */
	 public String searchTempEstimateDivCdData(CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpDtlVO.getColumnValues();
			 	
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempEstimateDivCdDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 returnVal = dbRowset.getString("DIV_CD");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }

	 /**
	  * 견적서 템프 헤더에 넣을 AGMT와 VNDR_SEQ을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return CustomMnrRprRqstTmpHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstTmpHdrVO searchTempEstimateAGMTData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstTmpHdrVO retCustomMnrRprRqstTmpHdrVO = null;
		 List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempEstimateAGMTDataRSQL(), param, velParam);
			 customMnrRprRqstTmpHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstTmpHdrVO .class);

			 if(customMnrRprRqstTmpHdrVOS.size() > 0){
				 retCustomMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return retCustomMnrRprRqstTmpHdrVO;
	 }

	 /**
	 * 템프견적서 헤더데이타를 라스트 버젼 플레그 N 한다.<br>
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyESTTmpHDRLastVersionUnFlagData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyESTTmpHDRLastVersionUnFlagDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyESTTmpHDRLastVersionUnFlagData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 견적서 DTL데이타를 라스트 버젼 플레그 N 한다.<br>
	 * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyESTTmpDTLLastVersionUnFlagData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyESTTmpDTLLastVersionUnFlagDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyESTTmpDTLLastVersionUnFlagData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	  * TEMP 견적서 넣을 SEQ을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO
	  * @return CustomMnrRprRqstTmpHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstTmpHdrVO searchEstimateTempSeqNewEqData(CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstTmpHdrVO retCustomMnrRprRqstTmpHdrVO = null;
		 List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateTempSeqNewEqDataRSQL(), param, velParam);
			 customMnrRprRqstTmpHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstTmpHdrVO .class);

			 if(customMnrRprRqstTmpHdrVOS.size() > 0){
				 retCustomMnrRprRqstTmpHdrVO = customMnrRprRqstTmpHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return retCustomMnrRprRqstTmpHdrVO;
	 }

	 /**
	  * 견적서 헤더을 조회합니다.<br>
	  * Repair Estimate Creation
	  * @param DocResultVO docResultVO
	  * @return FlatFileHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public FlatFileHdrVO searchIFEstimateHRDData(DocResultVO docResultVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 FlatFileHdrVO flatFileHdrVO = null;
		 List<FlatFileHdrVO> flatFileHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = docResultVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateHDRDataRSQL(), param, velParam);
			 flatFileHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, FlatFileHdrVO .class);

			 if(flatFileHdrVOS.size() > 0){
				 flatFileHdrVO = flatFileHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return flatFileHdrVO;
	 }

	 /**
	  * 견적서 디테일을 조회합니다.<br>
	  * Repair Estimate Creation
      * @param DocResultVO docResultVO
	  * @return List<FlatFileDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<FlatFileDtlVO> searchIFEstimateDTLData(DocResultVO docResultVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<FlatFileDtlVO> flatFileDtlVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = docResultVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateDTLDataRSQL(), param, velParam);
			 flatFileDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, FlatFileDtlVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return flatFileDtlVOS;
	 }

	/**
	 * FA 전송시 EQ_NO로 FA_EQ_NO를 조회합니다.<br>
	 * @param String eqNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchFAEqNoData(String eqNo) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("eq_no",eqNo);
			 velParam.put("eq_no",eqNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchFAEqNoDataRSQL(), param, velParam);
			if(dbRowset.next()){
				returnVal = dbRowset.getString("fa_eq_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}


	/**
	  * ApPayInvData을 조회합니다.<br>
	  * @param String refNum
	  * @return ApPayInvVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public ApPayInvVO searchApPayInvData(String refNum) throws DAOException {
		 DBRowSet dbRowset = null;
		 ApPayInvVO apPayInvVO = null;
		 List<ApPayInvVO> apPayInvVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 param.put("pay_inv_seq",refNum);
			 velParam.put("pay_inv_seq",refNum);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchApPayInvDataRSQL(), param, velParam);
			 apPayInvVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO .class);

			 if(apPayInvVOS.size() > 0){
				 apPayInvVO = apPayInvVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return apPayInvVO;
	 }

	 /**
	  * ApPayInvData을 조회합니다.<br>
	  * Repair Estimate Creation
	  * @param String refNum
	  * @return List<ApPayInvDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<ApPayInvDtlVO> searchApPayInvDtlData(String refNum) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ApPayInvDtlVO> apPayInvDtlVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 param.put("pay_inv_seq",refNum);
			 velParam.put("pay_inv_seq",refNum);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchApPayInvDtlDataRSQL(), param, velParam);
			
			 apPayInvDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return apPayInvDtlVOS;
	 }

	 /**
	  * [EES_MNR_0096] ApPayInvData을 조회합니다.<br>
	  *
	  * @param String refNum
	  * @return List<ApPayInvDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<ApPayInvDtlVO> searchTotalLossApPayInvDtlData(String refNum) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ApPayInvDtlVO> apPayInvDtlVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 param.put("pay_inv_seq",refNum);
			 velParam.put("pay_inv_seq",refNum);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTotalLossApPayInvDtlDataRSQL(), param, velParam);
			 apPayInvDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return apPayInvDtlVOS;
	 }

	/**
	 * [EES_MNR_0036]M&R Document Transmission의 정보를 작업 합니다. <br>
	 * InterfaceTrace 정보를 저장합니다.<br>
	 * @param DocResultVO docResultVO
	 * @return int
	 * @exception DAOException
	 */

	public int addInterfaceTraceData(DocResultVO docResultVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = docResultVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddInterfaceTraceDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addInterfaceTraceData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	 /**
	  * [EES_MNR_0036]M&R Document Transmission의 정보를 작업 합니다. <br>
	  * InterfaceTrace 시퀀스를 조회 생성한다.<br>
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrIfTrcSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchMnrIfTrcSeqDataRSQL(), param, velParam);
	 		if(dbRowset.next()){
	 			returnVal = dbRowset.getString("SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return returnVal;
	 }

	/**
	 * CNMV_EVNT_DT 와 FlagDate 를 비교한다<br>
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCNTRActualDTData(IFMnrFlagVO iFMnrFlagVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = -1;

		try {
			Map<String, String> mapVO = iFMnrFlagVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOcheckCNTRActualDTDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 result = dbRowset.getInt(1);
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	 /**
	  * InvArIfMnData을 조회합니다.<br>
	  *	@param ReceivableINVInquiryINVO receivableINVInquiryINVO
	  * @return InvArIfMnVO invArIfMnVO
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public InvArIfMnVO searchInvArIfMnData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<InvArIfMnVO> invArIfMnVOS = null;
		 InvArIfMnVO invArIfMnVO = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();

		 param.putAll(mapVO);
		 velParam.putAll(mapVO);

		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchInvArIfMnDataRSQL(), param, velParam);
			 invArIfMnVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);

			 if(invArIfMnVOS.size() > 0){
				 invArIfMnVO = invArIfMnVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return invArIfMnVO;
	 }
	 /**
	  * InvArIfChgData을 조회합니다.<br>
	  * @param  receivableINVInquiryINVO ReceivableINVInquiryINVO
	  * @return invArIfChgVO InvArIfChgVO
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	 public List<InvArIfChgVO> searchInvArIfChgData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<InvArIfChgVO> invArIfChgVOs = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

 			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchInvArIfChgDataRSQL(), param, velParam);
			 invArIfChgVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return invArIfChgVOs;
	 }

	 /**
	  * InvArIfCntrData을 조회합니다.<br>
	  * @param  receivableINVInquiryINVO ReceivableINVInquiryINVO
	  * @return invArIfCntrVO InvArIfCntrVO
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	 public List<InvArIfCntrVO> searchInvArIfCntrData(ReceivableINVInquiryINVO receivableINVInquiryINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<InvArIfCntrVO> invArIfCntrVOs = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = receivableINVInquiryINVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchInvArIfCntrDataRSQL(), param, velParam);
			 invArIfCntrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return invArIfCntrVOs;
	 }

	/**
	  * [EES_MNR_0192] EDI Estimate 의 정보를 조회 합니다. <br>
	  *
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrRprRqstTmpHdrVO> searchReSendEDIEstimateHRDData() throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = new CustomMnrRprRqstTmpHdrVO();
		 List<CustomMnrRprRqstTmpHdrVO> customMnrRprRqstTmpHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchReSendEDIEstimateHRDDataRSQL(), param, velParam);
			 customMnrRprRqstTmpHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstTmpHdrVO .class);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return customMnrRprRqstTmpHdrVOS;
	 }

	/**
	 * CNMV_EVNT_DT 와 FlagDate 를 비교한다<br>
	 * @param IFMnrFlagVO iFMnrFlagVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAciacDivData(IFMnrFlagVO iFMnrFlagVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";

		try {
			Map<String, String> mapVO = iFMnrFlagVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchAciacDivDataRSQL(), param, velParam);

			 if(dbRowset.next()){
				 result = dbRowset.getString(1);
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	 /**
	  * TEMP 견적서 디테일에 넣을 DTL_SEQ을 조회합니다.<br>
	  * @param CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO
	  * @return CustomMnrRprRqstTmpDtlVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstTmpDtlVO searchEstimateTempDtlSeqNewEqData(CustomMnrRprRqstTmpDtlVO customMnrRprRqstTmpDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstTmpDtlVO retCustomMnrRprRqstTmpDtlVO = null;
		 List<CustomMnrRprRqstTmpDtlVO> customMnrRprRqstTmpDtlVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstTmpDtlVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateTempDtlSeqNewEqDataRSQL(), param, velParam);
			 customMnrRprRqstTmpDtlVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstTmpDtlVO .class);

			 if(customMnrRprRqstTmpDtlVOS.size() > 0){
				 retCustomMnrRprRqstTmpDtlVO = customMnrRprRqstTmpDtlVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return retCustomMnrRprRqstTmpDtlVO;
	 }

	 /**
	  * Estimate Upload 처리된 결과를 조회합니다.<br>
	  * @param EstimateUploadGRPVO estimateUploadGRPVO
	  * @return List<EstimateUploadVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EstimateUploadVO> searchEstimateUploadResultData(EstimateUploadGRPVO estimateUploadGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EstimateUploadVO> list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{

			 List<String> estimateUploadPK = estimateUploadGRPVO.getEstimateUploadPK();
			 param.put("complex_pk",estimateUploadPK);
			 velParam.put("complex_pk",estimateUploadPK);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimateUploadVO.class);
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
	 * [EES_MNR_0036]M&R FASendEAI 의 작업에 대한 로그 작업을 합니다. <br>
	 * InterfaceTrace 정보를 저장합니다.<br>
	 * 
	 * @param DocResultVO docResultVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFASendEAIData(DocResultVO docResultVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = docResultVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new InterfaceMgtDBDAOaddFASendEAIDataCSQL(),param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addFASendEAIData");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	
	/**
	 * New Port Hdr 데이타를  삽입한다.<br>
	 * @param CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int addTempNewPortHDRData(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempNewPortHDRDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addTempNewPortDTLData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * New Port DTL 데이타를  삽입한다.<br>
	 * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int addTempNewPortDTLData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempNewPortDTLDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addTempNewPortDTLData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 
	 * @param customESTWOMainINFOVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addNewPortWOCreationHeaderData(List<CustomMnrOrdHdrVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOaddWorkOrderNewPortHDRDataCSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addNewPortWOCreationHeaderData");
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
	 * @param customESTWOMainINFOVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addNewPortWOCreationDetailData(List<CustomMnrOrdDtlVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOaddWorkOrderNewPortDTLDataCSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addNewPortWOCreationDetailData");
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
	
	/**\
	 * 
	 * @param customESTWOMainINFOVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyNewPortWOCreationDetailData(List<CustomMnrOrdTmpDtlVO> customESTWOMainINFOVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customESTWOMainINFOVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOaddTempNewPortDTLDataUSQL(), customESTWOMainINFOVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyNewPortWOCreationHeaderData");
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
	 * New Port Hdr 데이타를  수정한다.<br>
	 * @param CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyTempNewPortHDRData(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempNewPortHDRDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyESTTmpDTLLastVersionUnFlagData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * New Port Dtl 데이타를  수정한다.<br>
	 * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyTempNewPortDTLData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddTempNewPortDTLDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update modifyESTTmpDTLLastVersionUnFlagData");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}	
	
	 /**
	  * MnrOrdTmpHdr 시퀀스를 조회 생성한다.<br>
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpHdrSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempNewPortHDRDataRSQL(), param, velParam);
	 		if(dbRowset.next()){
	 			returnVal = dbRowset.getString("MNR_RCV_ORD_INV_TMP_SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se);
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}
	 	return returnVal;
	 }
	
	 
	 /**
	  * MnrOrdTmpDtl 시퀀스를 조회 생성한다.<br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpDtlSeqData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempNewPortDTLDataRSQL(), param, velParam);
		 		if(dbRowset.next()){
		 			returnVal = dbRowset.getString("MNR_RCV_ORD_INV_TMP_DTL_SEQ");
		 		}
		 	}catch(SQLException se){
		 		log.error(se.getMessage(),se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	}catch(Exception ex){
		 		log.error(ex.getMessage(),ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}
		 	return returnVal;
	 }
	 
	 /**
	  * MDM_VENDOR VNDR_SEQ 를 조회한다.<br>
	  * 
	  * @param String vndrSeq
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpVndrSeqData(String vndrSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
		//	 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.put("vndrSeq", vndrSeq);
			 velParam.put("vndrSeq", vndrSeq);
			 
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempNewPortVndrSeqDataRSQL(), param, velParam);
		 		if(dbRowset.next()){
		 			returnVal = dbRowset.getString("VNDR_SEQ");
		 		}
		 	}catch(SQLException se){
		 		log.error(se.getMessage(),se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	}catch(Exception ex){
		 		log.error(ex.getMessage(),ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}
		 	return returnVal;
	 }	 
	 
	 /**
	  * MDM_VENDOR GEN_PAY_TERM_CD 를 조회한다.<br>
	  * @param String vndrSeq
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpGenPayTermCdData(String vndrSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
		//	 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.put("vndr_seq", vndrSeq);
			 velParam.put("vndr_seq", vndrSeq);
			 
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempNewPortGenPayTermCdDataRSQL(), param, velParam);
		 		if(dbRowset.next()){
		 			returnVal = dbRowset.getString("GEN_PAY_TERM_CD");
		 		}
		 	}catch(SQLException se){
		 		log.error(se.getMessage(),se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	}catch(Exception ex){
		 		log.error(ex.getMessage(),ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}
		 	return returnVal;
	 }		 

	 
	 /**
	  * MNR_GEN_CD COST_CD 를 조회한다.<br>
	  * 
	  * @param String costCd
	  * @param String eqKndCd
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpCostCdData(String costCd,String eqKndCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
		//	 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.put("costCd", costCd);
			 param.put("eqKndCd", eqKndCd);
			 velParam.put("costCd", costCd);
			 velParam.put("eqKndCd", eqKndCd);
			 
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTempNewPortCostCdDataRSQL(), param, velParam);
		 		if(dbRowset.next()){
		 			returnVal = dbRowset.getString("MNR_CD_ID");
		 		}
		 	}catch(SQLException se){
		 		log.error(se.getMessage(),se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	}catch(Exception ex){
		 		log.error(ex.getMessage(),ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}
		 	return returnVal;
	 }	 
	 
	 /**
	  * 
	  * @return
	  * @throws DAOException
	  */
	 public String searchMnrOrdSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RepairMgtDBDAOsearchMnrOrdSeqDataRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	}	 
	 
	/**
	 * InvoiceNo의 중복정보를 체크한다 : 공통
	 * @param CheckInvoiceNoVO checkInvoiceNoVO
	 * @return List<CheckInvoiceNoVO>
	 * @exception EventException
	 */
	public List<CheckInvoiceNoVO> checkInvoiceNo(CheckInvoiceNoVO checkInvoiceNoVO) throws DAOException {
		log.debug("\n DAO.checkInvoiceNo \n");
		
		DBRowSet dbRowset = null;
		List<CheckInvoiceNoVO> resultVOs = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try{
			//query parameter
			param.putAll(checkInvoiceNoVO.getColumnValues());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FinCommonDBDAOCheckInvoiceNoRSQL(), param, vparam);
			resultVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckInvoiceNoVO.class);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (DAOException de) { 
			log.error(de.getMessage(), de);
			throw de;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVOs;
	}	 

	/**
	  * MNR_ORD_TMP_DTL 의 Verify 결과를 체크한다<br>
	  * 
	  * @param String mnrRcvOrdInvTmpSeq
	  * @return String
	  * @exception DAOException
	  */
	 public String searchTmpDtlVrfyRsltData(String mnrRcvOrdInvTmpSeq) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
		//	 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.put("mnr_rcv_ord_inv_tmp_seq", mnrRcvOrdInvTmpSeq);
			 velParam.put("mnr_rcv_ord_inv_tmp_seq", mnrRcvOrdInvTmpSeq);
			 
		 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchTmpDtlVrfyRsltDataRSQL(), param, velParam);
		 		if(dbRowset.next()){
		 			returnVal = dbRowset.getString("CNT");
		 		}
		 	}catch(SQLException se){
		 		log.error(se.getMessage(),se);
		 		throw new DAOException(new ErrorHandler(se).getMessage());
		 	}catch(Exception ex){
		 		log.error(ex.getMessage(),ex);
		 		throw new DAOException(new ErrorHandler(ex).getMessage());
		 	}
		 	return returnVal;
	 }
	 
	/**
	 * New Port EDI Detail 정보를 조회한다
	 * 
	 * @param CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO
	 * @return List<CustomMnrOrdTmpDtlVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CustomMnrOrdTmpDtlVO> searchMnrOrdTmpDtlData(CustomMnrOrdTmpHdrVO customMnrOrdTmpHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrOrdTmpDtlVO> resultVOs = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> vparam = new HashMap<String, Object>();

		try {
			// query parameter
			param.putAll(customMnrOrdTmpHdrVO.getColumnValues());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchMnrOrdTmpDtlDataRSQL(),param, vparam);
			resultVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrOrdTmpDtlVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVOs;
	}
	
	/**
	  * MNR_GEN_CD COST_DTL_CD 를 조회한다.<br>
	  * 
	  * @param String costCd
	  * @param String costDtlCd
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMnrOrdTmpCostDtlCdData(String costCd, String costDtlCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
		//	 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.put("cost_cd", costCd);
			param.put("cost_dtl_cd", costDtlCd);
			velParam.put("cost_cd", costCd);
			velParam.put("cost_dtl_cd", costDtlCd);
			 
		 	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchMnrOrdTmpCostDtlCdDataRSQL(), param, velParam);
		 	if(dbRowset.next()){
		 		returnVal = dbRowset.getString("MNR_CD_ID");
		 	}
		 }catch(SQLException se){
		 	log.error(se.getMessage(),se);
		 	throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
		 	log.error(ex.getMessage(),ex);
		 	throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }
	 
	 /**
	  * 견적서 템프 디테일에 사용할 TPSZ 을 조회합니다.<br>
	  * @param String vrfyRsltDesc
	  * @return String
	  * @exception DAOException 
	  */
	 public String searchVerifyResultData(String vrfyRsltDesc) throws DAOException {
		 DBRowSet dbRowset = null;
		 String returnVal = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{	
			 param.put("searchkey", vrfyRsltDesc);
			 velParam.put("searchkey", vrfyRsltDesc);
			 velParam.put("searchVel", vrfyRsltDesc.substring(1));
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchVerifyResultDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 returnVal = dbRowset.getString("MNR_CD_DP_DESC");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return returnVal;
	 }
	 
	 /**
	  * Cost Code 가 Agmt 에 있는지 체크br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchCostCdAgmtData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchCostCodeAgmtDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = "OK";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Cost Code Agmt Amount 을 조회합니다.<br>
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return List<CustomMnrAgmtRtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrAgmtRtVO> searchAgmtAmountData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
//		 CustomMnrAgmtRtVO customMnrAgmtRtVO = null;
		 List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 param.put("type", customMnrOrdTmpDtlVO.getType());
			 velParam.put("type", customMnrOrdTmpDtlVO.getType());

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchAgmtAmoutDataRSQL(), param, velParam);
			 customMnrAgmtRtVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAgmtRtVO .class);

//			 if(customMnrAgmtRtVOS.size() > 0){
//				 customMnrAgmtRtVO = customMnrAgmtRtVOS.get(0);
//			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return customMnrAgmtRtVOS;
	 }
	 
	 /**
	  * Cost Code 의 Type 을 체크br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchCostTypeData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchMnrCostTypeDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("MNR_ORD_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * EQ No Check <br>
	  * @param 	EQGeneralInfoINVO eQGeneralInfoINVO
	  * @return List<CustomMnrEqStsVVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrEqStsVVO> searchEqInfoData(EQGeneralInfoINVO eQGeneralInfoINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrEqStsVVO>  list = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 Map<String, String> mapVO = eQGeneralInfoINVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEQInfoDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVVO .class);
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
	  * Agmt Exist Flag 가 Y인지 체크br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchAgmtExistData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchAgmtExistFlagDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("agmt_val_flg");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Rate Check Flag 를 체크br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchAgmtRateFlagData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchAgmtRateFlagDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("agmt_rt_flg");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	 * MNR_ORD_DTL VRFY_TP_CD 데이타를  수정한다.<br>
	 * @param CustomPayableInvoiceDetailINVO customPayableInvoiceDetailINVO
	 * @return int
	 * @exception DAOException, Exception
	 */
	public int modifyMnrWOVrfyCdData(CustomPayableInvoiceDetailINVO customPayableInvoiceDetailINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = customPayableInvoiceDetailINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOmodifyMnrWOVrfyCdDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update InterfaceMgtDBDAOmodifyMnrWOVrfyCdDataUSQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	  * Cost Code 별 Yard Code 를 조회합니다.<br>
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return List<CustomMnrAgmtRtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrAgmtRtVO> searchCostYardCodeData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			 param.putAll(mapVO);
				velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchCostYardCodeDataRSQL(), param, velParam);
			 customMnrAgmtRtVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAgmtRtVO .class);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return customMnrAgmtRtVOS;
	 }
	 
	 /**
	  * Agreement 존재 여부 체크 <br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchAgreementExistData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchAgmtExistDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("AGMT_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * QTY Cost Code 인지 체크<br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String checkQtyCostCodeData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOcheckQtyCostCodeDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("MNR_ORD_TP_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Cost Code 가 Agmt 에 있는지 체크br>
	  * 
	  * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	  * @return String
	  * @exception DAOException
	  */
	public String searchCostTypeSizeData(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			Map<String, String> mapVO = customMnrOrdTmpDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchCostTypeSizeDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = "OK";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Financial Office 검색<br>
	  * 
	  * @param String locCd
	  * @return String
	  * @exception DAOException
	  */
	public String searchFinancialOfficeData(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("loc_cd", locCd);
			velParam.put("loc_Cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchFinancialOfficeDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("FINC_CTRL_OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * 해당 날짜의 Mvmt Event Time 검색<br>
	  * 
	  * @param String eqNo
	  * @param String rprRsltDt
	  * @param String ydCd
	  * @param String mvmtStsCd
	  * @return String
	  * @exception DAOException
	  */
	public String searchMvmtTimeData(String eqNo, String rprRsltDt, String ydCd, String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("eq_no", eqNo);
			param.put("rpr_rslt_dt", rprRsltDt);
			param.put("yd_cd", ydCd);
			param.put("mvmt_sts_cd", mvmtStsCd);
			velParam.put("eq_no", eqNo);
			velParam.put("rpr_rslt_dt", rprRsltDt);
			velParam.put("yd_cd", ydCd);
			velParam.put("mvmt_sts_cd", mvmtStsCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchMvmtEvntDayDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("EVNT_TM");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Find Revenue VVD, Service Lane<br>
	  * 
	  * @param String bkgNo
	  * @return String
	  * @exception DAOException
	  */
	public String searchRevenueVvdData(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchRevVvdInfoDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("REV_VVD_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * Find Currency Decimal Point<br>
	  * 
	  * @param String currCd
	  * @return String
	  * @exception DAOException
	  */
	public String searchCurrencyDecimalData(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("curr_cd", currCd);
			velParam.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchCurrencyDecimalPointDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("DP_PRCS_KNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
	
	/**
	  * 해당 날짜의 Mvmt Event Count 검색<br>
	  * 
	  * @param String cntrNo
	  * @param String rprRsltDt
	  * @return int
	  * @exception DAOException
	  */
	public int searchMvmtCntSameDayData(String cntrNo, String rprRsltDt) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("rpr_rslt_dt", rprRsltDt);
			velParam.put("cntr_no", cntrNo);
			velParam.put("rpr_rslt_dt", rprRsltDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchMvmtCntSameDayDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return Integer.parseInt(returnVal);
	}
	
	/**
	  * 해당 날짜의 Damage Flag Status 검색<br>
	  * 
	  * @param String eqNo
	  * @param String rprRsltDt
	  * @param String ydCd
	  * @return String
	  * @exception DAOException
	  */
	public String searchDamageStatusData(String eqNo, String rprRsltDt, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		String returnVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", eqNo);
			param.put("evnt_dt", rprRsltDt);
			param.put("event_yard", ydCd);
			velParam.put("cntr_no", eqNo);
			velParam.put("evnt_dt", rprRsltDt);
			velParam.put("event_yard", ydCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchDamageFlagingStatusDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnVal = dbRowset.getString("CNTR_DMG_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVal;
	}
}
