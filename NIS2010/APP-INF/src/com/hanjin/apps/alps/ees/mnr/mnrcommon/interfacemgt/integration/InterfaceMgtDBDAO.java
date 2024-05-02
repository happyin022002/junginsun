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
* --------------------------------------------------------
* History
* 2012.01.30 김상수 [CHM-201215889-01] Repair SPP Upload 화면 로직 변경 요청
*                                      - 엑셀로 업로드 받은 Hour와 Material은 Qty가 1이상일 경우 Hour*Qty, Material*Qty로 계산해서 업로드
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가     
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	  
* 2013.02.15 조경완 [CHM-201322897-01] ALPS-CNTR MNR-Repair -Estimate Creation 화면 상에서 TPB Interface 에러 건 수정 요청                            
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableINVInquiryINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrFileAtchVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpDtlVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileDtlVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FlatFileHdrVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * alps InterfaceMgtDBDAO <br>
 * - alps-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author LEE JU HYUN
 * @see interfaceBCImpl 참조
 * @since J2EE 1.4
 */
public class InterfaceMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] 견적서 넣을 SEQ을 조회합니다. <br>
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
	  * @param 	InterfaceGRPVO interfaceGRPVO
	  * @return List<ApPayInvDtlVO>	tPBInterfaceVOS
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<TPBInterfaceVO> searchTPBInterfaceListData(InterfaceGRPVO interfaceGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TPBInterfaceVO> tPBInterfaceVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 param.put("rqst_eq_no",interfaceGRPVO.getTpbRqstEqNo());
			 param.put("rpr_rqst_seq",interfaceGRPVO.getTpbRprRqstSeq());
			 param.put("rpr_rqst_ver_no",interfaceGRPVO.getTpbRprRqstVerNo());
			 velParam.put("rqst_eq_no",interfaceGRPVO.getTpbRqstEqNo());
			 velParam.put("rpr_rqst_seq",interfaceGRPVO.getTpbRprRqstSeq());
			 velParam.put("rpr_rqst_ver_no",interfaceGRPVO.getTpbRprRqstVerNo());

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
				
				// MNR_FILE_ATCH_EXTR: 썸네일 사진 저장용 테이블의 내용을 삭제
				sqlExe.executeBatch((ISQLTemplate)new InterfaceMgtDBDAOremoveThumbnailUploadDataDSQL(), CustomMnrFileAtchVOS,null);
				
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

		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
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
	public String searchAciacDivData(IFMnrFlagVO iFMnrFlagVO) throws DAOException {
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
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
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

		 Map<String, Object> param = new HashMap<String, Object>();
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
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
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

		 Map<String, Object> param = new HashMap<String, Object>();
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 List<String> estimateUploadPK = estimateUploadGRPVO.getEstimateUploadPK();
			 param.put("complex_pk", estimateUploadPK);
			 velParam.put("complex_pk", estimateUploadPK);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateUploadResultDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstimateUploadVO.class);
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
	  * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 eq type, tpsz 조회.<br>
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO searchEqTypeNTpSzByEqNoData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstHdrVO rtnCustomMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEqTypeNTpSzByEqNoDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);

			 if(customMnrRprRqstHdrVOS.size() > 0){
				 rtnCustomMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtnCustomMnrRprRqstHdrVO;
	 }	 
	 
	 /**
	  * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 AGMT 정보 조회<br>
	  * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	  * @return CustomMnrRprRqstHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrRprRqstHdrVO searchEstimateAGMTData(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 CustomMnrRprRqstHdrVO rtnCustomMnrRprRqstHdrVO = null;
		 List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = customMnrRprRqstHdrVO.getColumnValues();

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceMgtDBDAOsearchEstimateAGMTDataRSQL(), param, velParam);
			 customMnrRprRqstHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstHdrVO .class);

			 if(customMnrRprRqstHdrVOS.size() > 0){
				 rtnCustomMnrRprRqstHdrVO = customMnrRprRqstHdrVOS.get(0);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtnCustomMnrRprRqstHdrVO;
	 }	 
	 
	/**
	 * [EES_MNR_0036]M&R FASendEAI 의 작업에 대한 로그 작업을 합니다. <br>
	 * InterfaceTrace 정보를 저장합니다.<br>
	 * @param DocResultVO docResultVO
	 * @return int
	 * @exception DAOException
	 */
	public int addFASendEAIData(DocResultVO docResultVO) throws DAOException {
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

			result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceMgtDBDAOaddFASendEAIDataCSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update addFASendEAIData");
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
	 * [EES_MNR_0019]M&R모듈에서 첨부 파일의 썸네일 이미지를 저장하기 위한 키 값들(PF)를 검색합니다. <br>
	 * @param String seqValue
	 * @param String keyFileNm
	 * @return String
	 * @exception DAOException
	 */
	public String searchDetailFileSeqenceValue(String seqValue, String keyFileNm) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = new String();
		DBRowSet dbRowSet = null;

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("seqValue", seqValue);
			mapVO.put("keyFileNm", keyFileNm);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");

			dbRowSet = sqlExe.executeQuery((ISQLTemplate) new InterfaceMgtDBDAOsearchDetailSequenceValueRSQL(), param, velParam);

			 if(dbRowSet.next()){
				 result = dbRowSet.getString(1);
			 }
			
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
	 * [EES_MNR_0019]M&R모듈에서 첨부 파일의 썸네일 이미지를 저장하기 위한 키 값들(PF)를 저장합니다. <br>
	 * @param String seqValue
	 * @param String dtlSeqValue
	 * @param String[] filePathNm
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void insertThumbnailInformation(String seqValue, String dtlSeqValue, String[] filePathNm, InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		
		for(int i = 0; i < filePathNm.length; i++){
			if(!"zip".equalsIgnoreCase(filePathNm[i].substring(filePathNm[i].length()-3))){ //zip 파일의 경우 저장하지 않는다.
				if(filePathNm[i].toLowerCase().contains("bmp") || filePathNm[i].toLowerCase().contains("tiff") || filePathNm[i].toLowerCase().contains("tif") || filePathNm[i].toLowerCase().contains("jpg") || filePathNm[i].toLowerCase().contains("jpeg") || filePathNm[i].toLowerCase().contains("png") ){
					
					param.put("file_seq",seqValue);
					param.put("file_dtl_seq",dtlSeqValue);
					param.put("file_path_nm",filePathNm[i]);
					param.put("thm_file_path_nm","tb_"+ filePathNm[i]);
					param.put("usr_id",account.getUsr_id());
							
					SQLExecuter sqlExe = new SQLExecuter("");
					
					try {
						sqlExe.executeUpdate((ISQLTemplate) new InterfaceMgtDBDAOinsertThumbnailInformationCSQL(), param, velParam);	
					} catch (SQLException se) {
						log.error(se.getMessage(), se);
						throw new DAOException(new ErrorHandler(se).getMessage());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
						throw new DAOException(new ErrorHandler(ex).getMessage());
					}
				}
			}
		}
	}
}
