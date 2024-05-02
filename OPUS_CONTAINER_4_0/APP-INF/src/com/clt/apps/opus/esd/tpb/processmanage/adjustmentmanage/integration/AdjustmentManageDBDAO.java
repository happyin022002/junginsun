/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustmentManageDBDAO.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.01 변종건 [CHM-201005566-01] [TPB] 지역본부/본사의 ROC 결정 후 2ND REVIEW를 위한 보완
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.basic.AdjustmentManageBCImpl;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffApproveVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.CreateWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteResponsibleOfficeChangeRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.DeleteWriteOffRequestVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 *  AdjustmentManageDBDAO <br>
 * - -AdjustmentManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, CHOI
 * @see AdjustmentManageBCImpl 참조
 * @since J2EE 1.6
 */
public class AdjustmentManageDBDAO extends DBDAOSupport {
	
	/**
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchROCToOfficeListVO searchROCToOfficeListVO
	  * @return List<SearchAdjustmentManageListVO>
	  * @throws DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<SearchROCToOfficeListVO> searchROCToOfficeList(SearchROCToOfficeListVO searchROCToOfficeListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchROCToOfficeListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchROCToOfficeListVO != null){
				 Map<String, String> mapVO = searchROCToOfficeListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchROCToOfficeListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchROCToOfficeListVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO
	 * @return List<SearchResponsibleOfficeChangeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchResponsibleOfficeChangeVO> searchResponsibleOfficeChange(SearchResponsibleOfficeChangeVO searchResponsibleOfficeChangeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchResponsibleOfficeChangeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strSearch = null;
		String tempSN3ptyInvNoSearch = ""; 
		
		try{
			if(searchResponsibleOfficeChangeVO != null){
				Map<String, String> mapVO = searchResponsibleOfficeChangeVO .getColumnValues();
	
				param.putAll(mapVO);
//				mapVO.remove("s_n3pty_no");
				mapVO.remove("s_n3pty_no_strs_link"); // s_n3pty_no_strs_link 처리를 위해 추가
				velParam.putAll(mapVO);
				
				List<String> arrayList = OfficeCodeMgr.getOfficeCodeList("000004","TPB");
				String headOfcCd = null;
				if(arrayList != null && arrayList.size()>0) headOfcCd = arrayList.get(0);
				
				velParam.put("head_ofc_cd", headOfcCd);
			}

			SearchResponsibleOfficeChangeVO sThVO = searchResponsibleOfficeChangeVO;

//			String s_n3pty_no = sThVO.getN3ptyNo();
			String s_n3pty_no_strs_link 	= sThVO==null?"":sThVO.getSN3ptyNoStrsLink();
			int len_s_n3pty_no_strs_link 	= s_n3pty_no_strs_link.length();
			
			String s_date_flag_r = sThVO==null?"":sThVO.getSDateFlagR();
//			String s_date_kind_flag = sThVO.getSDateKindFlag();
			if (s_date_flag_r.equals("")) { 
				s_date_flag_r = "OT";
			}
//			log.debug("s_date_flag_r============>["+s_date_flag_r+"]");
			velParam.put("s_date_flag_r", s_date_flag_r);
//			log.debug("s_date_kind_flag============>["+s_date_kind_flag+"]");			
//			log.debug("s_n3pty_no_strs_link==============>["+s_n3pty_no_strs_link+"]");
			
			//s_n3pty_no_strs_link 넣는 부분
			if(!s_n3pty_no_strs_link.equals("")){
				s_n3pty_no_strs_link = s_n3pty_no_strs_link.substring(0,len_s_n3pty_no_strs_link);
				strSearch = new StringTokenizer(s_n3pty_no_strs_link, "|");
				tempSN3ptyInvNoSearch = strSearch.nextToken();
				tempArrL.add(tempSN3ptyInvNoSearch);

				while(strSearch.hasMoreTokens()){
					tempSN3ptyInvNoSearch = strSearch.nextToken();
					tempArrL.add(tempSN3ptyInvNoSearch);
				}
			}

			if(tempArrL.size()>0){
				velParam.put("s_n3pty_no_strs_link", tempArrL);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchResponsibleOfficeChangeRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchResponsibleOfficeChangeVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO
	 * @return List<SearchResponsibleOfficeChangeInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchResponsibleOfficeChangeInquiryVO> searchResponsibleOfficeChangeInquiry(SearchResponsibleOfficeChangeInquiryVO searchResponsibleOfficeChangeInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchResponsibleOfficeChangeInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchResponsibleOfficeChangeInquiryVO != null){
				Map<String, String> mapVO = searchResponsibleOfficeChangeInquiryVO .getColumnValues();

				param.putAll(mapVO);
//				mapVO.remove("s_n3pty_no");
				velParam.putAll(mapVO);
			}
//				SearchResponsibleOfficeChangeInquiryVO sThIVO = searchResponsibleOfficeChangeInquiryVO;
//				String s_n3pty_no = sThIVO.getN3ptyNo();
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchResponsibleOfficeChangeInquiryRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchResponsibleOfficeChangeInquiryVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffVO searchWriteOffVO
	 * @return List<SearchWriteOffVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchWriteOffVO> searchWriteOff(SearchWriteOffVO searchWriteOffVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWriteOffVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ArrayList tempArrL = new ArrayList();
		StringTokenizer strSearch = null;
		String tempSN3ptyInvNoSearch = ""; 
		
		try{
			if(searchWriteOffVO != null){
				Map<String, String> mapVO = searchWriteOffVO .getColumnValues();

				param.putAll(mapVO);
//				mapVO.remove("s_n3pty_no");
				mapVO.remove("s_n3pty_no_strs_link"); // s_n3pty_no_strs_link 처리를 위해 추가
				velParam.putAll(mapVO);
			}

			SearchWriteOffVO sWoVO = searchWriteOffVO;

			String s_n3pty_no_strs_link = sWoVO==null?"":sWoVO.getSN3ptyNoStrsLink();
			int len_s_n3pty_no_strs_link = s_n3pty_no_strs_link.length();
			
			String s_date_flag_r = sWoVO==null?"":sWoVO.getSDateFlagR();
//			String s_date_kind_flag = sWoVO.getSDateKindFlag();
			if (s_date_flag_r.equals("")) { 
				s_date_flag_r = "OT";
			}
//			log.debug("s_date_flag_r============>["+s_date_flag_r+"]");
			velParam.put("s_date_flag_r", s_date_flag_r);
//			log.debug("s_date_kind_flag============>["+s_date_kind_flag+"]");			
//			log.debug("s_n3pty_no_strs_link==============>["+s_n3pty_no_strs_link+"]");
			
			//s_n3pty_no_strs_link 넣는 부분
			if(!s_n3pty_no_strs_link.equals("")){
				s_n3pty_no_strs_link = s_n3pty_no_strs_link.substring(0,len_s_n3pty_no_strs_link);
				strSearch = new StringTokenizer(s_n3pty_no_strs_link, "|");
				tempSN3ptyInvNoSearch = strSearch.nextToken();
//				log.debug("tempSN3ptyInvNoSearch ============>["+tempSN3ptyInvNoSearch+"]");
				tempArrL.add(tempSN3ptyInvNoSearch);

				while(strSearch.hasMoreTokens()){
					tempSN3ptyInvNoSearch = strSearch.nextToken();
					tempArrL.add(tempSN3ptyInvNoSearch);
				}
			}
			if(tempArrL.size()>0){
				velParam.put("s_n3pty_no_strs_link", tempArrL);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchWriteOffRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWriteOffVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchWriteOffInquiryVO searchWriteOffInquiryVO
	 * @return List<SearchWriteOffInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchWriteOffInquiryVO> searchWriteOffInquiry(SearchWriteOffInquiryVO searchWriteOffInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWriteOffInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchWriteOffInquiryVO != null){
				Map<String, String> mapVO = searchWriteOffInquiryVO .getColumnValues();

				param.putAll(mapVO);
//				mapVO.remove("s_n3pty_no");
				velParam.putAll(mapVO);
				
				List<String> arrayList = OfficeCodeMgr.getOfficeCodeList("000004","TPB");
				String headOfcCd = null;
				if(arrayList != null && arrayList.size()>0) headOfcCd = arrayList.get(0);
				
				velParam.put("head_ofc_cd", headOfcCd);
			}
//				SearchWriteOffInquiryVO sWoIVO = searchWriteOffInquiryVO;
//				String s_n3pty_no = sWoIVO.getN3ptyNo();
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchWriteOffInquiryRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchWriteOffInquiryVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateResponsibleOfficeChangeRequestVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addResponsibleOfficeChangeRequest(List<CreateResponsibleOfficeChangeRequestVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAOCreateResponsibleOfficeChangeRequestCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<DeleteResponsibleOfficeChangeRequestVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeResponsibleOfficeChangeRequest(List<DeleteResponsibleOfficeChangeRequestVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAODeleteResponsibleOfficeChangeRequestUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateResponsibleOfficeChangeApproveVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addResponsibleOfficeChangeApprove(List<CreateResponsibleOfficeChangeApproveVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAOCreateResponsibleOfficeChangeApproveCSQL(), insModels,null);
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
		return insCnt;
	}

	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateWriteOffApproveVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addWriteOffApprove(List<CreateWriteOffApproveVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAOCreateWriteOffApproveCSQL(), insModels,null);
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
		return insCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateWriteOffRequestVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addWriteOffRequest(List<CreateWriteOffRequestVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAOCreateWriteOffRequestCSQL(), insModels,null);
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
		return insCnt;
	}	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<DeleteWriteOffRequestVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeWriteOffRequest(List<DeleteWriteOffRequestVO> delModels) throws DAOException,Exception {
//		log.debug(">>>>>>>>>>>>>>>>>removeWriteOffRequestDBDAO");
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentManageDBDAODeleteWriteOffRequestUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		return delCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param CreateResponsibleOfficeChangeApproveVO createResponsibleOfficeChangeApproveVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDuplicationCheck(CreateResponsibleOfficeChangeApproveVO createResponsibleOfficeChangeApproveVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = createResponsibleOfficeChangeApproveVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchDupCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validYn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param CreateResponsibleOfficeChangeRequestVO createResponsibleOfficeChangeRequestVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchStatusCheck(CreateResponsibleOfficeChangeRequestVO createResponsibleOfficeChangeRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String rtnValue = "";
		try{
			Map<String, String> mapVO = createResponsibleOfficeChangeRequestVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AdjustmentManageDBDAOSearchStatusCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("validYn");
			} else {
				rtnValue = "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
}