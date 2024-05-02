/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeDAO.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrivalNoticeSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgArrNtcCntrVO;
import com.clt.syscommon.common.table.BkgArrNtcDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcVO;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;
import com.clt.syscommon.common.table.BkgCustCdValVO;
import com.clt.syscommon.common.table.BkgCustTmpltVO;
import com.clt.syscommon.common.table.BkgIbCmdtCntcVO;
import com.clt.syscommon.common.table.BkgIbCustCntcHisVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupHisVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupVO;
import com.clt.syscommon.common.table.BkgIbCustCntcVO;
import com.clt.syscommon.common.table.BkgMdmCrCustVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;


/**
 *   ArrivalNoticeDBDAO <br>
 * - InboundNoticeMgt system Arrival Notice 관련 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see ArrivalNoticeBCImpl 참조
 * @since J2EE 1.4
 */
public class ArrivalNoticeDBDAO extends DBDAOSupport {

	
	/**
	 * [UI-BKG-0375] Arrival Notice Form을 조회 합니다.<br>
	 * @author
	 * @param String ofcCd
	 * @param String podCd
	 * @param String agent
	 * @return BkgArrNtcWdVO
	 * @exception DAOException
	 */
	public BkgArrNtcWdVO searchArrNtcForm(String ofcCd,
		String podCd, String agent) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdVO> list = null;
		BkgArrNtcWdVO arrNtcWd = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			HashMap<String, Object> mapVO = new HashMap<String, Object>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("pod_cd", podCd);
			mapVO.put("chn_agn_cd", agent);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			log.debug("-------------------------------- param S");
			log.debug(param);
			log.debug("-------------------------------- param E");

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new ArrivalNoticeDBDAOsearchArrNtcFormRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgArrNtcWdVO.class);
			
			if (list.size() > 0) {
				arrNtcWd = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrNtcWd;

	}
	
	/**
	 * [UI-BKG-0375] Arrival Notice Form을 조회 합니다.<br>
	 * @author
	 * @param String anSeq 
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception DAOException 
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtls(String anSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdDtlVO> arrNtcWdDtls = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			HashMap<String, Object> mapVO = new HashMap<String, Object>();
			mapVO.put("an_seq", anSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			log.debug("-------------------------------- param S");
			log.debug(param);
			log.debug("-------------------------------- param E");

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new ArrivalNoticeDBDAOsearchArrNtcFormDtlsRSQL(),
							param, velParam);
			arrNtcWdDtls = (List) RowSetUtil.rowSetToVOs(dbRowset,
					BkgArrNtcWdDtlVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrNtcWdDtls;

	}
		
	/**
	 * [UI-BKG-0375] ArrivalNoticeDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Pod List 가져오기<br>
	 * @author
	 * @param String ofcCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception DAOException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormPodList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdVO> arrNtcWds = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ofcCd != null && !ofcCd.equals("")) {
			
				param.put("ofc_cd", ofcCd);
				velParam.put("ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcFormOfcCdRSQL(), param, velParam);
			arrNtcWds = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdVO.class);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrNtcWds;
	}	
	
	
	/**
	 * [UI-BKG-0375]Arrval Notice Form을 가지고 있는 Agent list를 조회한다.<br>
	 * @author
	 * @param String ofcCd
	 * @param String podCd
	 * @return List<BkgArrNtcWdVO>
	 * @exception DAOException
	 */
	public List<BkgArrNtcWdVO> searchArrNtcFormAgentList(String ofcCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdVO> arrNtcWds = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ofcCd != null && !ofcCd.equals("")) {
			
				param.put("ofc_cd", ofcCd);
				param.put("pod_cd", podCd);
				
				velParam.put("ofc_cd", ofcCd);
				velParam.put("pod_cd", podCd);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOArrNtcFormAgentRSQL(), param, velParam);
			arrNtcWds = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdVO.class);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrNtcWds;
	}

	/**
	 * [UI-BKG-0375]단건의 데이터를 생성한다.<br>
	 * Arrival Notice Form Data를 수정
	 * @author
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @exception DAOException
	 */
	public void addArrNtcForm(BkgArrNtcWdVO arrNtcWd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = arrNtcWd.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcFormCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [UI-BKG-0375]단건의 데이터를 삭제한다.<br>
	 * Arrival Notice Form Data를 수정
	 * @author
	 * @param  String anSeq
	 * @exception DAOException
	 */
	public void removeArrNtcForm(String anSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			param.put("an_seq", anSeq);
			velParam.put("an_seq", anSeq);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcFormDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [UI-BKG-0375] Arrival Notice Form 다건의 데이터를 일괄적으로 생성한다.<br>
	 * @author
	 * @param BkgArrNtcWdDtlVO arrNtcWdDtl
	 * @exception DAOException
	 */
	public void addArrNtcFormDtl(BkgArrNtcWdDtlVO arrNtcWdDtl) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = arrNtcWdDtl.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcFormDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * UI_BKG-0375 Arrival Notice Form Setup<br>
	 * Arrival Notice삭제를 위한 폼의 목록을 조회한다.<br>
	 * @param String ofcCd 오피스 코드
	 * @param String podCd 포트 코드
	 * @param String agentCd 중국 에이전트 코드
	 * @return String[] anSeqs 해당하는 폼 코드를 반환
	 * @exception DAOException
	 */
	public String[] searchRemoveForm(String ofcCd, String podCd, String agentCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> lst = new ArrayList<String>();
		String[] anSeqs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ofcCd != null && !ofcCd.equals("")) {
			
				param.put("ofc_cd", ofcCd);
				param.put("pod_cd", podCd);
				param.put("chn_agn_cd", agentCd);
				
				velParam.put("ofc_cd", ofcCd);
				velParam.put("pod_cd", podCd);
				velParam.put("chn_agn_cd", agentCd);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchRevmoeFormRSQL(), param, velParam);
			while (dbRowset.next()) {
				lst.add(dbRowset.getString(1)) ;
			}
			
			anSeqs = new String[lst.size()];
			lst.toArray(anSeqs);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return anSeqs;
		
	}
	
	/**
	 * [UI-BKG-0375] Arrival Notice Form의 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * @author
	 * @param String  anSeq
	 * @exception DAOException
	 */
	public void removeArrNtcFormDtl(String  anSeq) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			param.put("an_seq", anSeq);
			velParam.put("an_seq", anSeq);
		
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcFormDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_BKG_0001 Arrival Notice : Notice Sent History<br>
	 * Bkg Notice History를 이용하여 Inbound Arrival Notice 정보를 추출한다.<br>
	 * @param  BkgNtcSearchVO bkgNtcSearch
	 * @return List<NoticeVO>
	 * @exception DAOException
	 * @author
	 */
	public List<NoticeVO> searchBkgNtcHis(BkgNtcSearchVO bkgNtcSearch) throws DAOException {
		List<NoticeVO> bkgNtcHiss = null;
		try {
		    DBRowSet dbRowset = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();
			
        	if(bkgNtcSearch != null){
				Map<String, String> mapVO = bkgNtcSearch .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}						

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchNoticeHistoryListRSQL(), param, velParam);
            bkgNtcHiss = (List)RowSetUtil.rowSetToVOs(dbRowset, NoticeVO.class);
            if (bkgNtcHiss != null && bkgNtcHiss.size() > 0 ) {
            	NoticeVO noticeVO = bkgNtcHiss.get(0);
            	noticeVO.setMaxRows(Integer.parseInt(noticeVO.getRowCount()));
            }
            
		}catch(SQLException se){
//			se.printStackTrace();
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return bkgNtcHiss;
	}
	
	
	/**
	 * ESM_BKG_0240 Customer Main (MDM) 데이터를 가져온다.<br>
	 * «» searchMdmCustList ( [in] custSearch : IntgCustSearchVO ) : MdmCustomerVO[]
	 * Master Grid 데이터를 조회한다.
	 * @param  custSearch IntgCustSearchVO
	 * @return List<MdmCustomerVO>
	 * @exception DAOException
	 */
	 public List<MdmCustomerVO> searchMdmCustList (IntgCustSearchVO  custSearch ) throws DAOException{
		 DBRowSet dbRowset = null;
	        List<MdmCustomerVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	        	if(custSearch != null){
					Map<String, String> mapVO = custSearch .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}						
				
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOMdmCustomerRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustomerVO .class);
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
	 }
	 
	/**
	 * [240-1]ESM_BKG_0240 Customer Details 데이터를 가져온다. <br>
	 * «» searchIntgCustCntcInfoByIB ( [in] custCntCd , [in] custSeq , [in] ofcCd ) : BkgIbCustCntcVO[]
	 * @param custCntCd String
	 * @param custSeq String 
	 * @param ofcCd String
	 * @return List<IbCustCntcVO>
	 * @exception DAOException 
	 */
	public List<IbCustCntcVO> searchIntgCustCntcInfoByIB ( String custCntCd , String custSeq , String ofcCd ) throws DAOException{

		DBRowSet dbRowset = null;
        List<IbCustCntcVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	param.put("cust_cnt_cd_ib", custCntCd);
			param.put("cust_seq_ib", custSeq);
			param.put("ofc_cd", ofcCd);
		
			velParam.put("cust_cnt_cd_ib", custCntCd);
			velParam.put("cust_seq_ib", custSeq);
			velParam.put("ofc_cd", ofcCd);	
			
			param.putAll(param);
			velParam.putAll(velParam);
								
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOBkgIbCustCntcRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IbCustCntcVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	 
	/**
	 * [0240] I/B 수정일경우 - 1<br>
	 * Inbound 정보를 수정한다.
	 * @param BkgIbCustCntcVO custCntc
	 * @return int
	 * @exception DAOException 
	 */
	public int modifyIntgCustCntcInfo(BkgIbCustCntcVO custCntc)	throws DAOException {
		int result = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// try {
		Map<String, String> mapVO = custCntc.getColumnValues();
		try {
			param.putAll(mapVO);
			velParam.putAll(mapVO);
					
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new ArrivalNoticeDBDAOBkgIbCustCntcUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	 
	/**
	 * [0240] I/B 생성,수정일경우 - 2<br>
	 * HIstory 를 남긴다.
	 * @param BkgIbCustCntcHisVO  custCntcHis
	 * @param SignOnUserAccount account
	 * @exception DAOException 
	 */	 
	public void addIntgCustCntcInfoHistory(BkgIbCustCntcHisVO  custCntcHis, SignOnUserAccount account ) throws DAOException{
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
				Map<String, String> mapVO = custCntcHis.getColumnValues();
				
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOBkgIbCustCntcHisCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	/**
	 * [0240] I/B 생성 - 1 <br>
	 * Inbound 정보를 생성한다.
	 * @param BkgIbCustCntcVO custCntc
	 * @param SignOnUserAccount account
	 * @exception DAOException 
	 */
	 public void addIntgCustCntctInfo(BkgIbCustCntcVO custCntc, SignOnUserAccount account) throws DAOException{
		 try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
				Map<String, String> mapVO = custCntc.getColumnValues();
				
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				log.debug("---------------- "+ mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOBkgIbCustCntcCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0240 Customer Details O/B 데이터를 가져온다.<br>
	 * «» searchIntgCustCntcInfoByOB ( [in] custCntCd , [in] custSeq ) : BkgCustTmpltVO[]
	 * @param custCntCd String
	 * @param custSeq String
	 * @return List<CustTmpltVO>
	 * @exception DAOException 
	 */
	public List<BkgCustTmpltVO> searchIntgCustCntcInfoByOB(String custCntCd,
			String custSeq) throws DAOException {

		DBRowSet dbRowset = null;
		List<BkgCustTmpltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd_ib", custCntCd);
			param.put("cust_seq_ib", custSeq);

			velParam.put("cust_cnt_cd_ib", custCntCd);
			velParam.put("cust_seq_ib", custSeq);

			param.putAll(param);
			velParam.putAll(velParam);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArrivalNoticeDBDAOBkgCustTmpltRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCustTmpltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_BKG_0240 Customer Details Invoice 데이터를 가져온다.<br>
	 * «» searchIntgCustCntcInfoByInvoice ( [in] custCntCd , [in] custSeq ) : MdmCrCustVO[]
	 * @param custCntCd String
	 * @param custSeq String 
	 * @return List<MdmCrCustVO>
	 * @exception DAOException 
	 */
	public List<BkgMdmCrCustVO> searchIntgCustCntcInfoByInvoice(String custCntCd,
			String custSeq) throws DAOException {

		DBRowSet dbRowset = null;
        List<BkgMdmCrCustVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	param.put("cust_cnt_cd_ib", custCntCd);
			param.put("cust_seq_ib", custSeq);
			
			velParam.put("cust_cnt_cd_ib", custCntCd);
			velParam.put("cust_seq_ib", custSeq);
		
			param.putAll(param);
			velParam.putAll(velParam);
											
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ArrivalNoticeDBDAOMdmCrCustRSQL(),
					param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgMdmCrCustVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	 }	
	
	
	/**
	 * ESM_BKG_0240 Customer Details TRO 데이터를 가져온다.<br>
	 * «» searchIntgCustCntcInfoByTRO ( [in] custCntCd , [in] custSeq ) : BkgTroActCustVO[]
	 * @param custCntCd String
	 * @param custSeq String
	 * @return List<TroActCustVO>
	 * @exception DAOException 
	 */
	public List<BkgTroActCustVO> searchIntgCustCntcInfoByTRO ( String custCntCd , String custSeq  ) throws DAOException{

		 DBRowSet dbRowset = null;
        List<BkgTroActCustVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	param.put("cust_cnt_cd_ib", custCntCd);
			param.put("cust_seq_ib", custSeq);
			
		
			velParam.put("cust_cnt_cd_ib", custCntCd);
			velParam.put("cust_seq_ib", custSeq);
		
			
			param.putAll(param);
			velParam.putAll(velParam);
								
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOBkgTroActCustRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTroActCustVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}	 
	 
	/**
	 * ESM_BKG_0242 AN Setting Screen_Customer Information(Consignee) 데이터를 가져온다. <br>
	 * «» searchArrNtcCustInfo ( [in] bkgNo : String , [in] custTpCd : String ) : ArrNtcCustRefVO
	 * @param bkgNo String
	 * @param custTpCd String
	 * @return List<ArrNtcCustRefVO>
	 * @exception DAOException
	 */
	public List<ArrNtcCustRefVO> searchArrNtcCustInfo (String bkgNo,String custTpCd  ) throws DAOException{
		DBRowSet dbRowset = null;
        List<ArrNtcCustRefVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	param.put("bkg_no", bkgNo);
        	param.put("bkg_cust_tp_cd", custTpCd);
      
        	velParam.put("bkg_no", bkgNo);
        	velParam.put("bkg_cust_tp_cd", custTpCd);
        	
			param.putAll(param);
			velParam.putAll(velParam);			
				
			dbRowset = new SQLExecuter("")
				.executeQuery(
						(ISQLTemplate) new ArrivalNoticeDBDAOsearchArrNtcCustInfoRSQL(),
						param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
				ArrNtcCustRefVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}		 
	
	/**
	 * 0672-1 Arrival Information [Arrival Date] Paging조회
	 * tab명 ; Arrival Data
	 * @param  ArrNtcSearchVO arrNtcSearch
	 * @param SignOnUserAccount account
	 * @return List<ArrNtcInfoListVO >
	 * @exception DAOException
	 */
	public List<ArrNtcInfoListVO> searchArrNtcInfoList (ArrNtcSearchVO arrNtcSearch,SignOnUserAccount account  ) throws DAOException{
		DBRowSet dbRowset = null;
        List<ArrNtcInfoListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	if(arrNtcSearch != null){
				Map<String, String> mapVO = arrNtcSearch .getColumnValues();
				mapVO.put("usr_id", account.getUsr_id());
				log.debug("------------- mapVO " + mapVO);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	long startTime = System.currentTimeMillis();
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcInfoListRSQL(), param, velParam);
			long endTime = System.currentTimeMillis();
			log.debug("--------------- 쿼리실행시간 "+((endTime - startTime)/1000) +"초 입니다.");
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcInfoListVO .class);
			
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}	
	
	/**
	 * UI-BKG-1054 Customer Code Validation결과값으로 Un-Match정보를 조회한다.<br>
	 * @author
	 * @param ArrNtcSearchVO anSearch
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception DAOException
	 */
	public List<CustCdValidationVO> searchArrNtcUnMatchCustList(ArrNtcSearchVO anSearch) throws DAOException {
		DBRowSet dbRowset = null;
        List<CustCdValidationVO> codeValidations = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	if(anSearch != null){
				Map<String, String> mapVO = anSearch.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	log.debug("-------------------------------- param S");
        	log.debug(param);
        	log.debug("-------------------------------- param E");
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcUnMatchCustListRSQL(), param, velParam);
            codeValidations = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdValidationVO.class);
            if (codeValidations != null && codeValidations.size() > 0 ) {
            	CustCdValidationVO custCdValidationVO = codeValidations.get(codeValidations.size() -1);
            	codeValidations.get(0).setRowCount(custCdValidationVO.getGrpSeq());
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return codeValidations;
	}


	/**
	 * Customer Code Validation결과값으로 Un-Match정보를 조회한다.<br>
	 * @author
	 * @param ArrNtcSearchVO anSearch
	 * @return List<CustCdValidationVO>
	 * @exception DAOException
	 */
	public List<CustCdValidationVO> searchManualValInfo(ArrNtcSearchVO anSearch) throws DAOException {
		DBRowSet dbRowset = null;
        List<CustCdValidationVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	if(anSearch != null){
				Map<String, String> mapVO = anSearch.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	log.debug("-------------------------------- param S");
        	log.debug(param);
        	log.debug("-------------------------------- param E");
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchManualValInfoRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdValidationVO.class);
            if (list != null && list.size() > 0 ) {
	            CustCdValidationVO custCdValidationVO = list.get(0);
	            custCdValidationVO.setMaxRows(Integer.parseInt(custCdValidationVO.getRowCount()));
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	
	/**
	 * Customer Code Validation결과값으로 Match정보를 조회한다.<br>
	 * @author
	 * @param ArrNtcSearchVO arrNtcSearchVo
	 * @return List<CustCdValidationVO> codeValidations
	 * @exception DAOException
	 */
	public List<CustCdValidationVO> searchArrNtcMatchCustList(ArrNtcSearchVO arrNtcSearchVo) throws DAOException {
		DBRowSet dbRowset = null;
        List<CustCdValidationVO> codeValidations = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	if(arrNtcSearchVo != null){
				Map<String, String> mapVO = arrNtcSearchVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	log.debug("-------------------------------- param S");
        	log.debug(param);
        	log.debug("-------------------------------- param E");
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcMatchCustListRSQL(), param, velParam);
            codeValidations = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCdValidationVO.class);
            if (codeValidations != null && codeValidations.size() > 0 ) {
	            CustCdValidationVO custCdValidationVO = codeValidations.get(0);
	            custCdValidationVO.setMaxRows(Integer.parseInt(custCdValidationVO.getRowCount()));
            }
       }catch(SQLException se){
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage(), se);
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
       }
       return codeValidations;
	}
	
	/**
	 * UI-BKG-0375 bkg_arr_ntc_wd의 ar_seq max값에 1만큼 더한 값을 반환한다.<br>
	 * @author
	 * @return String
	 * @exception DAOException
	 */
	public String searchArrNtcFomMaxSeq() throws DAOException {
		DBRowSet dbRowset = null;
        List<BkgArrNtcWdVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String anSeq = "";

        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcFormMaxSeqRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdVO.class);
            if (list.size() > 0) {
            	BkgArrNtcWdVO bkgArrNtcWdVO = (BkgArrNtcWdVO)list.get(0);
            	anSeq = bkgArrNtcWdVO.getAnSeq();
            }
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return Integer.valueOf(Integer.valueOf(anSeq).intValue() + 1).toString();
	}
	
	/**
	 * Code Validation을 통해 수정된 고객에 대한 ArrivalNotice 정보를 등록한다.<br>
	 * @author
	 * @param List<CustCdEvaluationVO> custCdEvaluations
	 * @exception DAOException
	 */
	public void addArrNtcDtlValInfo (List<CustCdEvaluationVO> custCdEvaluations) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcDtlValInfoCSQL(), custCdEvaluations,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
	
	/**
	 * Code Validation을 통해 수정된 고객에 대한 ArrivalNotice Master 정보를 등록한다.<br>
	 * @author
	 * @param List<CustCdEvaluationVO> custCdEvaluations
	 * @exception DAOException
	 */
	public void addArrNtcValInfo (List<CustCdEvaluationVO> custCdEvaluations) throws DAOException{
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcValInfoCSQL(), custCdEvaluations,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}

	/**
	 * Code Validation을 통해 수정된 고객에 대한 ArrivalNotice Detail 정보를 삭제한다.<br>
	 * @author
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @exception DAOException
	 */
	public void removeArrNtcDtlByCustCdVal(String bkgNo, String bkgCustTpCd) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			HashMap<String, Object> mapVO = new HashMap<String, Object>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_cust_tp_cd", bkgCustTpCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcDtlByCustCdValDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
	
	/**
	 * Code Validation을 통해 수정된 고객에 대한 ArrivalNotice Master 정보를 삭제한다.<br>
	 * @author
	 * @param String bkgNo
	 * @exception DAOException
	 */
	public void removeArrNtcByCustCdVal(String bkgNo) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			HashMap<String, Object> mapVO = new HashMap<String, Object>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcValInfoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}

	
	/**[243] AN Setup Screen_Arrival Info. Setup에서 그룹핑된 VVD/POD별 입력되는 문구와 정보를 조회한다. <br>
	 * Address<br>
	 * @param String ofcCd
	 * @param String podCd
	 * @param String formCd
	 * @param String agent
	 * @return List<BkgArrNtcWdDtlVO>
	 * @exception DAOException 
	 */
	public List<BkgArrNtcWdDtlVO> searchArrNtcFormDtl(String ofcCd, String podCd,
			String formCd,String agent) throws DAOException {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
        List<BkgArrNtcWdDtlVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
        	
        	param.put("ofc_cd", ofcCd);
			param.put("pod_cd", podCd);
			param.put("an_fom_cd", formCd);
			param.put("agent", agent);
			
			velParam.put("ofc_cd", ofcCd);
			velParam.put("pod_cd", podCd);
			velParam.put("an_fom_cd", formCd);
			velParam.put("agent", agent);

			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcFormDtlRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdDtlVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	
	/**
	 * [672-1] 수정<br>
	 * Arrival Notice (Arrival Information) 저장
	 * @param List<BkgArrNtcVO> arrNtcList
	 * @return int
	 * @exception DAOException
	 */
	public int[] modifyArrNtcInfo (List<BkgArrNtcVO> arrNtcList) throws DAOException{
		int[] result;
		try {
			log.debug("------- 수정할 건수 "+ arrNtcList.size());
			SQLExecuter sqlExe = new SQLExecuter("");
			
			result = sqlExe.executeBatch((ISQLTemplate) new ArrivalNoticeDBDAOmodifyArrNtcInfoUSQL(),arrNtcList, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * Customer Code Error Report 조회<br>
	 * @author
	 * @param custCodeErrSearch ArrNtcCustCodeErrSearchVO
	 * @return List<ArrNtcCustCodeErrLstVO>
	 * @exception DAOException
	 */
	public List<ArrNtcCustCodeErrListVO> searchArrNtcCustCodeErrReport(ArrNtcCustCodeErrSearchVO custCodeErrSearch) throws DAOException{
		DBRowSet dbRowset = null;
		List<ArrNtcCustCodeErrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = custCodeErrSearch .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcCustCodeErrRepotRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcCustCodeErrListVO.class);
            if (list != null && list.size() > 0 ) {
            	ArrNtcCustCodeErrListVO arrNtcCustCodeErrLstVO = list.get(0);
            	arrNtcCustCodeErrLstVO.setMaxRows(Integer.parseInt(arrNtcCustCodeErrLstVO.getRowCount()));
            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
	}

	/**
	 * [0375-01] arrival notice form을 수정한다.<br>
	 * @author
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @exception DAOException
	 */
	public void modifyArrNtcForm (BkgArrNtcWdVO arrNtcWd) throws DAOException {
		//query parameter
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = arrNtcWd.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcFormUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [0375-01] arrival notice detail form을 수정한다.<br>
	 * @author
	 * @param BkgArrNtcWdDtlVO arrNtcWdDtl
	 * @exception DAOException
	 */
	public void modifyArrNtcFormDtl (BkgArrNtcWdDtlVO arrNtcWdDtl) throws DAOException {
		//query parameter
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = arrNtcWdDtl.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcFormDtlUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [0764] Customer Data Management Update History<br>
	 * 인바운드 고객정보 수정 현황을 조회한다.<br>
	 *  @author
	 *  @param IbCustCntcHisVO custCntcHis 
	 *  @return List<IbCustCntcHisVO>
	 *  @exception DAOException
	 */
	public List<IbCustCntcHisVO> searchIntgCustCntcInfoHistory (IbCustCntcHisVO custCntcHis) throws DAOException {
		DBRowSet dbRowset = null;
        List<IbCustCntcHisVO> custCntcHiss = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            Map<String, String> mapVO = custCntcHis.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchIntgCustCntcInfoHistoryRSQL(), param, velParam);
            custCntcHiss = (List)RowSetUtil.rowSetToVOs(dbRowset, IbCustCntcHisVO.class);

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return custCntcHiss;

	}
	
	
	

		/**
		 * [0672-2] Customer 정보 조회한다.<br>
		 * «» searchArrNtcCustList ( [in] search : ArrNtcSearchVO ) : ArrNtcCustListVO[]
		 * @param ArrNtcSearchVO arrNtcSearchVO
		 * @param SignOnUserAccount account
		 * @return List<ArrNtcCustListVO>
		 * @exception DAOException 
		 */	
		public List<ArrNtcCustListVO> searchArrNtcCustList(ArrNtcSearchVO arrNtcSearchVO, SignOnUserAccount account) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<ArrNtcCustListVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	                Map<String, String> mapVO = arrNtcSearchVO.getColumnValues();
	                mapVO.put("ofc_cd", account.getOfc_cd());
	        		
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	            
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcCustListRSQL(), param, velParam);

	         
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcCustListVO.class);
	            

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
		}

		/**
		 * [672-2] Customer 정보 삭제한다.<br>
		 * 
		 * @param ArrNtcCustListVO arrNtcCustListVO
		 * @return int
		 * @exception DAOException
		 */
		public int removeArrNtcDtls(BkgArrNtcDtlVO arrNtcCustListVO) throws DAOException {
			//query parameter
			int result = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = arrNtcCustListVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcDtlsDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}		

		/**[0052] Arrival Notice Yard 정보조회<br>
		 * [case 1 ] BEANR일경우<br>
		 * «» searchArrNtcAnrMrnRtnYd ( [in] vvd : String ) : MrnRtnYdVO[]
		 * @param String vvd
		 * @return List<MrnRtnYdVO>
		 * @exception DAOException 
		 */
		public List<MrnRtnYdVO> searchArrNtcAnrMrnRtnYd (String vvd) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<MrnRtnYdVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{

	        		Map<String, String> mapVO = new HashMap<String,String>();
	        		
	        		mapVO.put("vvd_size",""+vvd.trim().length());
	        		mapVO.put("vvd",vvd);
	        		
	        		
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrMrnRtnYdRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MrnRtnYdVO.class);

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
		}
		/**[0052] Arrival Notice Yard 조회<br>
		 * «» searchArrNtcRtmMrnRtnYd ( [in] vvd : String ) : MrnRtnYdVO[]
		 * [case 2] NLRTM 일경우<br> 
		 * @param String vvd
		 * @return List<MrnRtnYdVO> 
		 * @exception DAOException  
		 */	
		public List<MrnRtnYdVO> searchArrNtcRtmMrnRtnYd (String vvd) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<MrnRtnYdVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{

	        		Map<String, String> mapVO = new HashMap<String,String>();
	        		mapVO.put("vvd_size",""+vvd.trim().length());
	        		mapVO.put("vvd",vvd);
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcNtmMrnRtnYdRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MrnRtnYdVO.class);

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
		}
		 

		/**
		 * [0052]Arrival Notice Yard 정보생성<br>
		 * 
		 * @param MrnRtnYdVO mrnRtnYdVO
		 * @param SignOnUserAccount account
		 * @exception DAOException
		 */
		public void addArrNtcMrnRtnYd(MrnRtnYdVO mrnRtnYdVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = mrnRtnYdVO.getColumnValues();
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrMrnRtnYdCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}	
		
		/**
		 * [0052]Arrival Notice Yard 정보수정<br>
		 * 
		 * @param MrnRtnYdVO mrnRtnYdVO
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */
		public int  modifyArrNtcMrnRtnYd(MrnRtnYdVO mrnRtnYdVO, SignOnUserAccount account) throws DAOException {
			//query parameter
			int result = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = mrnRtnYdVO.getColumnValues();
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcMrnRtnYdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}	
		
		/**
		 * [0672-3] Customer 업로드 정보 조회<br>
		 * «» searchArrNtcCustListForUpload ( [in] search : ArrNtcSearchVO ) : ArrNtcCustUploadListVO[]
		 * @param ArrNtcSearchVO search
		 * @return List<ArrNtcCustUploadListVO>
		 * @exception DAOException
		 */
		public List<ArrNtcCustUploadListVO> searchArrNtcCustListForUpload(ArrNtcSearchVO search) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<ArrNtcCustUploadListVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	        		//1-1.검색조건을 가져올때
	                Map<String, String> mapVO = search.getColumnValues();
	                

	                //1-2.각자수정이 필요할때
	                
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcCustListForUploadRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcCustUploadListVO.class);
	            

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
		}
		
		
		/**
		 * [0672-3] Customer 업로드 정보수정
		 * «» modifyArrNtcDtls ( [in] arrNtcDtls : BkgArrNtcDtlVO[] , [in] account : SignOnAccountUser ) : void
		 * @param BkgArrNtcDtlVO vo
		 * @param SignOnUserAccount account
		 * @return int 
		 * @exception DAOException
		 */
		public int modifyArrNtcDtls(BkgArrNtcDtlVO vo,SignOnUserAccount account) throws DAOException {
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = vo.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcDtlsUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		/**
		 * [0672-3] Customer 업로드 정보생성 <br>
		 * 
		 * @param BkgArrNtcDtlVO vo
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */		
		public int addArrNtcDtls(BkgArrNtcDtlVO vo,SignOnUserAccount account) throws DAOException {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = vo.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcDtlsCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		
//-----------------------------------------------------------------------------------------------------		
		/**
		 * [0381]기 Setting된 A/N 발송 대상 정보 및 기 송부 실행이 완료된 A/N History정보를  검색한다. 조회<br>
		 * 
		 * @param ArrivalNoticeSearchVO searchVO
		 * @param SignOnUserAccount account
		 * @return List<ArrNtcSendListVO>
		 * @exception DAOException
		 */
		public List<ArrNtcSendListVO> searchArrNtcSendList(ArrivalNoticeSearchVO searchVO,SignOnUserAccount account) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<ArrNtcSendListVO> listVOS = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	        		//1-1.검색조건을 가져올때
	        		searchVO.setUsrId(account.getUsr_id());
	                Map<String, String> mapVO = searchVO.getColumnValues();
	                mapVO.put("ofc_cd",account.getOfc_cd());
	                mapVO.put("fax_scs_cd","5");  // 팩스 성공 코드
	                mapVO.put("eml_scs_cd","3");  // 이메일 성공 코드 

	                //1-2.각자수정이 필요할때
	                
	                log.debug("------------ 0381 cust_cnt_cd , cust_seq " + mapVO.get("cust_cnt_cd") + " "+mapVO.get("cust_seq"));
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);
	                
	                

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcSendListRSQL(), param, velParam,true);
	            listVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcSendListVO.class);
	            

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return listVOS;
		}
//-----------------------------------------------------------------------------------------------------
		/**
		 * [0381] Master 수정 , Remark 수정, 
		 * 모델순서 : 4
		 * @param ArrNtcSendListVO listVO
		 * @param SignOnUserAccount account
		 * @exception DAOException 
		 */
		public void modifyArrNtcBySend (ArrNtcSendListVO listVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = listVO.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcBySendUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		}
		/**
		 * [0381] Detail 수정 , Fax 관련정보만 수정
		 * 모델순서 : 6
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException 
		 */
		public int modifyArrNtcDtlByFax (BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();
				mapVO.put("usr_id", account.getUsr_id());				
				mapVO.put("ofc_cd",account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcDtlByFaxUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		/**
		 * [0381] Detail 추가 , Fax 관련정보만 추가
		 * 모델순서 : 6
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException 
		 */
		public int addArrNtcDtlByFax (BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();				
				mapVO.put("usr_id", account.getUsr_id());
				mapVO.put("ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcDtlByFaxCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}		
		/**
		 * [0381] EAIDAO 의 SendFax 를 호출에서 받은값을 Detail의 SendId에 입력
		 * 모델순서 : 8
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @exception DAOException 
		 */
		public void modifyArrNtcSendIdByFax(BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcSendIdByFaxUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
//-----------------------------------------------------------------------------------------------------		
		/**
		 * [0381] E-Mail 관련 Detail 정보수정
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @return int 
		 * @exception DAOException 
		 */
		public int modifyArrNtcDtlByMail(BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());
				mapVO.put("eml_snd_usr_id", account.getUsr_id());
				mapVO.put("ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcDtlByMailUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}
		/**
		 * [0381] E-Mail 관련 Detail 정보추가
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @return int 
		 * @exception DAOException 
		 */
		public int addArrNtcDtlByMail(BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());
				mapVO.put("eml_snd_usr_id", account.getUsr_id());
				mapVO.put("ofc_cd", account.getOfc_cd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcDtlByMailCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}	
		/**
		 * [0381] EAIDAO 의 SendMail 를 호출에서 받은값을 Detail의 SendId에 입력
		 * @param BkgArrNtcDtlVO dtlVO
		 * @param SignOnUserAccount account
		 * @exception DAOException 
		 */
		public void modifyArrNtcSendIdByMail(BkgArrNtcDtlVO dtlVO,SignOnUserAccount account) throws DAOException{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				Map<String, String> mapVO = dtlVO.getColumnValues();
				mapVO.put("upd_usr_id", account.getUsr_id());
				mapVO.put("cre_usr_id", account.getUsr_id());				
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcSendIdByMailUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
		}	
		

		/**[0956] Hold Remark 조회<br>
		 * @param String bkgNo 
		 * @return List<BkgArrNtcCntrVO> 
		 * @exception DAOException  
		 */	
		public List<BkgArrNtcCntrVO> searchArrNtcHldRmk  (String bkgNo) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<BkgArrNtcCntrVO> list = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{

	        		Map<String, String> mapVO = new HashMap<String,String>();
	        		mapVO.put("bkg_no",bkgNo);
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchAnHldRmkRSQL(), param, velParam);
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcCntrVO.class);

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return list;
		}
			
	
		/**
		 * [0956]수정<br>
		 * Hold Remark 저장
		 * @param BkgArrNtcCntrVO bkgArrNtcCntr
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */
		public int  modifyArrNtcHldRmk (BkgArrNtcCntrVO bkgArrNtcCntr, SignOnUserAccount account) throws DAOException {
			//query parameter
			int result = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = bkgArrNtcCntr.getColumnValues();
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyAnHldRmkUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}		
		
		/**
		 * [0956]추가<br>
		 * Hold Remark 저장
		 * @param BkgArrNtcCntrVO vo
		 * @param SignOnUserAccount account
		 * @return int
		 * @exception DAOException
		 */
		public int  addArrNtcHldRmk (BkgArrNtcCntrVO vo, SignOnUserAccount account) throws DAOException {
			//query parameter
			int result = 0;
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = vo.getColumnValues();
				mapVO.put("cre_usr_id",account.getUsr_id());
				mapVO.put("upd_usr_id",account.getUsr_id());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyAnHldRmkCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return result;
		}			
		/**[0946] 조회<br>
		 * Group A/N Merge Pop-up 조회
		 * @param ArrNtcGrpSendListVO arrNtcGrpSendListVo
		 * @return List<ArrNtcGrpSendListVO> 
		 * @exception DAOException  
		 */	
		public List<ArrNtcGrpSendListVO> searchArrNtcGrpSendList(ArrNtcGrpSendListVO arrNtcGrpSendListVo) throws DAOException {
			// TODO Auto-generated method stub
			DBRowSet dbRowset = null;
	        List<ArrNtcGrpSendListVO> arrNtcGrpSendListVos = null;
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        Map<String, Object> velParam = new HashMap<String, Object>();

	        try{
	                Map<String, String> mapVO = arrNtcGrpSendListVo.getColumnValues();

	                param.putAll(mapVO);
	                velParam.putAll(mapVO);

	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcGrpSendListRSQL(), param, velParam, true);
	            arrNtcGrpSendListVos = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcGrpSendListVO.class);

	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage(), se);
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return arrNtcGrpSendListVos;
		}
			
	

		/**
		 * MRD 값을 구하기 위함.
		 * @param ArrNtcMrdSearchVO arrNtcMrdSearch
		 * @return ArrNtcMrdVO
		 * @exception DAOException
		 */
		public ArrNtcMrdVO searchArrNtcMrdId( ArrNtcMrdSearchVO arrNtcMrdSearch) throws DAOException{
			
			ArrNtcMrdVO arrNtcMrdVO = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			List<ArrNtcMrdVO> list = null;
			
			try 
			{
				
				Map<String, String> mapVO = arrNtcMrdSearch.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcMrdIdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcMrdVO .class);                                                
				if(list == null) return null;
				if(list.size() > 0)
				{
					if (!"".equals(JSPUtil.getNull(arrNtcMrdSearch.getBkgNo()))) {
						arrNtcMrdVO = list.get(0);
					} else {
//						String arrPrvFomCd = "";
//						String mrdId = "";
//						String comParam = "";
						
						StringBuffer arrPrvFomCd = new StringBuffer("");
						StringBuffer mrdId       = new StringBuffer("");
						StringBuffer comParam    = new StringBuffer("");
						
						for (int i=0; i<list.size(); i++) {
//							arrPrvFomCd = arrPrvFomCd + list.get(i).getArrPrvFomCd() + "|";
//							mrdId = mrdId + list.get(i).getMrdId() + "|";
//							comParam = comParam + list.get(i).getComParam() + "|";
							
							arrPrvFomCd.append(list.get(i).getArrPrvFomCd()).append("|");
							mrdId.append(list.get(i).getMrdId()).append("|");
							comParam.append(list.get(i).getComParam()).append("|");
						}
						arrNtcMrdVO = new ArrNtcMrdVO();
						arrNtcMrdVO.setArrPrvFomCd(arrPrvFomCd.toString());
						arrNtcMrdVO.setMrdId(mrdId.toString());
						arrNtcMrdVO.setComParam(comParam.toString());
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
//				se.printStackTrace();
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return arrNtcMrdVO;
		}
		
		/**
		 * [0381][0946] History 남기기
		 * @param BkgNtcHisVO bkgNtcHisVo
		 * @return BkgNtcHisVO
		 * @exception DAOException
		 */
		public BkgNtcHisVO searchArrNtcHistory(BkgNtcHisVO bkgNtcHisVo) throws DAOException
		{
			BkgNtcHisVO rBkgNtcHisVo = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			List<BkgNtcHisVO> list = null;
			
			try 
			{
				Map<String, String> mapVO = bkgNtcHisVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO .class);                                                
				if(list == null) return null;
				if(list.size() > 0)
				{
					rBkgNtcHisVo = list.get(0);
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return rBkgNtcHisVo;
		}

		
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * @param String ofcCd
	 * @return ArrNtcBankAcctVO
	 * @exception DAOException
	 * @author 
	 */
	public BkgArrNtcWdVO searchArrNtcBankAcct(String ofcCd) throws DAOException
	{
		BkgArrNtcWdVO arrNtcBankAcctVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdVO> list = null;
		
		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("ofc_cd",ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcBankAcctRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdVO .class);                                                
			if(list == null) return null;
			if(list.size() > 0)
			{
				arrNtcBankAcctVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arrNtcBankAcctVO;
	}
	
	
	/**
	 * [0375-01] arrival notice detail form을 수정한다.<br>
	 * @param BkgArrNtcWdVO arrNtcBankAcct
	 * @exception DAOException
	 */
	public void addArrNtcBankAcct(BkgArrNtcWdVO arrNtcBankAcct) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = arrNtcBankAcct.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddArrNtcBankAcctCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 수정
	 * @param  BkgArrNtcWdVO arrNtcBankAcct
	 * @return int
	 * @exception DAOException
	 * @author 
	 */
	public int modifyArrNtcBankAcct(BkgArrNtcWdVO arrNtcBankAcct) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = arrNtcBankAcct.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcBankAcctUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 1021 Bank In Account No Setup for A/N<br>
	 * 삭제
	 * @param String ofcCd
	 * @exception DAOException
	 * @author 
	 */
	public void removeArrNtcBankAcct(String ofcCd) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("ofc_cd",ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveArrNtcBankAcctDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * [1020] arrival notice Group A/N Remark Template<br>
	 * @param String ofcCd
	 * @return BkgArrNtcWdVO
	 * @exception DAOException
	 * @author 
	 */
	public List<BkgArrNtcWdVO> searchArrNtcGrpForm(String ofcCd) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<BkgArrNtcWdVO> list = null;
		
		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("ofc_cd",ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchArrNtcGrpFormRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgArrNtcWdVO.class);                                                
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * [1020] arrival notice Group A/N Remark Template<br>
	 * @param BkgArrNtcWdVO arrNtcWd
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @author 
	 */
	public void mergeArrNtcGrpForm(BkgArrNtcWdVO arrNtcWd,SignOnUserAccount account) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = arrNtcWd.getColumnValues();
			mapVO.put("usr_id", account.getUsr_id());
			mapVO.put("ofc_cd", account.getOfc_cd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyArrNtcFormARGUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [1044] Add Concerned Party Pop-up 조회
	 * @param String ofcCd
	 * @param String custCd 
	 * @param String custSeq
	 * @param String custTpCd
	 * @return List<BkgIbCmdtCntcVO>
	 * @exception DAOException
	 * @author 
	 */
	public List<BkgIbCmdtCntcVO> searchCustCmdtCntcInfo(String ofcCd , String custCd , String custSeq, String custTpCd) throws DAOException
	{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<BkgIbCmdtCntcVO> list = null;
		try
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("ofc_cd",ofcCd);
			mapVO.put("cust_cnt_cd",custCd);
			mapVO.put("cuct_cntc_tp_cd",custTpCd);
			mapVO.put("cust_seq", custSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchCustCmdtCntcInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgIbCmdtCntcVO.class);
		}
		catch (SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	
	/**
	 * [1044] Add Concerned Party Pop-up 수정
	 * @param BkgIbCmdtCntcVO ibCmdtCntc 
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @author 
	 */
	public void modifyCustCmdtCntcInfo(BkgIbCmdtCntcVO ibCmdtCntc, SignOnUserAccount account ) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = ibCmdtCntc.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyCustCmdtCntcInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} 
		catch (SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [1044] Add Concerned Party Pop-up 추가<br>
	 * @param BkgIbCmdtCntcVO ibCmdtCntc
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 * @author 
	 */
	public void addCustCmdtCntctInfo(BkgIbCmdtCntcVO ibCmdtCntc , SignOnUserAccount account)throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = ibCmdtCntc.getColumnValues();
			mapVO.put("upd_usr_id", account.getUsr_id());
			mapVO.put("cre_usr_id", account.getUsr_id());
			if(!mapVO.containsKey("ofc_cd") ||mapVO.get("ofc_cd") == null || mapVO.get("ofc_cd").equals("")){
				mapVO.put("ofc_cd",account.getOfc_cd());
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			
			log.debug("--------------- ofc_cd "+ mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddCustCmdtCntctInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} 
		catch (SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * [1044] Add Concerned Party Pop-up 삭제
	 * @param BkgIbCmdtCntcVO ibCmdtCntc
	 * @exception DAOException
	 * @author 
	 */
	public void removeCustCmdtCntcInfo(BkgIbCmdtCntcVO ibCmdtCntc) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = ibCmdtCntc.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOremoveCustCmdtCntcInfoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		} 
		catch (SQLException se) 
		{
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 1099   Integrated Customer Data Update Setup 조회
	 * @param String ofcCd
	 * @return ArrNtcBankAcctVO
	 * @exception DAOException
	 * @author 
	 */
	public BkgIbCustCntcStupVO searchIntgCustCntcUpdtStupInfoByOfc(String ofcCd) throws DAOException
	{
		BkgIbCustCntcStupVO bkgIbCustCntcStupVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		List<BkgIbCustCntcStupVO> list = null;
		
		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
			mapVO.put("ofc_cd",ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchIntgCustCntcUpdtStupInfoByOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgIbCustCntcStupVO .class);                                                
			if(list == null) return null;
			if(list.size() > 0)
			{
				bkgIbCustCntcStupVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgIbCustCntcStupVO;
	}
	

	/**
	 * 1099 Integrated Customer Data Update Setup 저장
	 * 수정
	 * @param  BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @return int
	 * @exception DAOException
	 * @author 
	 */
	public int modifyIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = bkgIbCustCntcStupVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOmodifyIntgCustCntcUpdtStupInfoByOfcUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 1099 Integrated Customer Data Update Setup Master 저장
	 * 생성
	 * @param  BkgIbCustCntcStupVO bkgIbCustCntcStupVo
	 * @return int
	 * @exception DAOException
	 * @author
	 */
	public int addIntgCustCntcUpdtStupInfoByOfc(BkgIbCustCntcStupVO bkgIbCustCntcStupVo) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = bkgIbCustCntcStupVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoByOfcCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 1099 Integrated Customer Data Update Setup History 저장
	 * 생성
	 * @param  BkgIbCustCntcStupHisVO bkgIbCustCntcStupHisVo
	 * @return int
	 * @exception DAOException
	 * @author
	 */
	public int addIntgCustCntcUpdtStupInfoHisByOfc(BkgIbCustCntcStupHisVO bkgIbCustCntcStupHisVo) throws DAOException
	{
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = bkgIbCustCntcStupHisVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ArrivalNoticeDBDAOaddIntgCustCntcUpdtStupInfoHisByOfcCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}	
		
	/**
	 * Customer Code Validation Data Merge
	 * 생성
	 * @param  List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception DAOException
	 * @author
	 */
	public boolean mergeBkgCustCdVal(List<MdmCustomerVO> mdmCustomerVOs) throws DAOException {
		boolean isSuccessful = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (mdmCustomerVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ArrivalNoticeDBDAOmergeBkgCustCdValCSQL(), mdmCustomerVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
				}
			}//if			
			isSuccessful = true;	
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful; 
	}
	
	/**
	 * UI-BKG-0381 E-Mail 전송 시 첨부 파일이 있는 경우 첨부파일의 File Key를 조회한다.<br>
	 * @param  ArrNtcSendListVO arrNtcSendListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAttachFileKey(ArrNtcSendListVO arrNtcSendListVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<ArrNtcSendListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String fileKey = null;

        try{
        	Map<String, String> mapVO = arrNtcSendListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);        	
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ArrivalNoticeDBDAOsearchAttachFileKeyRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArrNtcSendListVO.class);
            if (list.size() > 0) {
            	ArrNtcSendListVO arrNtcSendList = (ArrNtcSendListVO)list.get(0);
            	fileKey = arrNtcSendList.getFileKey();
            }
	    }catch(SQLException se){
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	    return fileKey;
	}	
}

