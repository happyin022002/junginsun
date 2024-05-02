/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMigrationDBDAO.java
 *@FileTitle : Migration Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.26
 *@LastModifier : 박성용
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARCreditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARCurrCdVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARInvoiceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ActInvCustVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ArOfcAgtMkVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ArOfcAttributeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BKGMainDocVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BLNoBKGStatusVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.BkgOfcPayIndVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ChinaDailyExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.CustExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArAmtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIssDtlVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvBkgIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VVDExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VvdPortVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.VvdSaDtVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.REVTypeSourceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.jms.send.vandor.IBMSendQClient;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
 
/**
 * OPUS AccountReceivableInvoiceMigrationDBDAO <br>
 * - OPUS-AccountReceivableInvoiceMigration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sung yong park
 * @see AccountReceivableInvoiceMigrationBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableInvoiceMigrationDBDAO extends DBDAOSupport {
	 
	private static final long serialVersionUID = 1L;


	/**
	 * Search BKG Migration List<br>
	 * 
	 * @param String fmBkgOfcCd
	 * @param String toBkgOfcCd
	 * @param String bkgNo
	 * @return List<ARBkgInterfaceCreationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARBkgInterfaceCreationVO> searchBKGMigrationList(String fmBkgOfcCd, String toBkgOfcCd, String bkgNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARBkgInterfaceCreationVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("fm_bkg_ofc_cd", fmBkgOfcCd);
			mapVO.put("to_bkg_ofc_cd", toBkgOfcCd);
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchBKGMigrationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARBkgInterfaceCreationVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 BKG Status 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return BLNoBKGStatusVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BLNoBKGStatusVO searchBLNoByBKGNo(String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		BLNoBKGStatusVO bLNoBKGStatusVO = null;
		List<BLNoBKGStatusVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchBLNoByBKGNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BLNoBKGStatusVO .class);
			
			if (list != null && list.size() > 0) {
				bLNoBKGStatusVO = (BLNoBKGStatusVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bLNoBKGStatusVO;
	}
	
	/**
	 * Booking IF 상태, 에러코드를 업데이트 한다.
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String invArIfCd
	 * @param String arIfErrRsn
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvArIfStatus(String bkgNo,String bkgSeq,String invArIfCd,String arIfErrRsn, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("inv_ar_if_cd", invArIfCd);
			mapVO.put("ar_if_err_rsn", arIfErrRsn);
			mapVO.put("upd_usr_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOModifyInvArIfStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_BKG_IF_OFC_CUST 테이블에서 해당 BKG_NO의 OFC List select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return List<BkgOfcPayIndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgOfcPayIndVO> searchBKGOfficeList (String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgOfcPayIndVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchBKGOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgOfcPayIndVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
     * MDM_CUSTOMER 에서 삭제된 CUSTOMER 인지 체크<br>
     * 
     * @param String custCntCd
     * @param String custSeq
     * @return int
     * @exception DAOException
     */
	public int checkCustomer(String custCntCd , String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOCheckCustomerRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
	 * INV_BKG_IF_CHG 테이블에서 해당 CHG 정보 select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String ioBndCd
	 * @param String n3rdFlg
	 * @return List<InvBkgIfChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvBkgIfChgVO> searchInvoiceChargeList(String bkgNo, String bkgSeq,String ofcCd, String ioBndCd, String n3rdFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvBkgIfChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			
			//String svrId = searchServerID(ofcCd);
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("n3rd_flg", n3rdFlg);
			//mapVO.put("svr_id", svrId);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchInvoiceChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvBkgIfChgVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 Booking 기본 정보 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @return BKGMainDocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BKGMainDocVO searchBKGInterface(String bkgNo,String bkgSeq,String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		BKGMainDocVO bKGMainDocVO = new BKGMainDocVO();
		List<BKGMainDocVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchBKGInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGMainDocVO .class);
			
			if (list != null && list.size() > 0) {
				bKGMainDocVO = (BKGMainDocVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bKGMainDocVO;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 PORT 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @param  String ioBndCd
	* @return VvdPortVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public VvdPortVO searchPort ( String bkgNo, String bkgSeq, String ioBndCd )throws DAOException {
		DBRowSet dbRowset = null;
		VvdPortVO vvdPortVO = new VvdPortVO();
		List<VvdPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortVO .class);
			
			if (list != null && list.size() > 0) {
				vvdPortVO = (VvdPortVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vvdPortVO;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 VVD,SaDt 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String portCd
	 * @param String ioBndCd
	 * @return VvdSaDtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VvdSaDtVO searchVVDSaDt(String bkgNo, String bkgSeq, String portCd, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		VvdSaDtVO vvdSaDtVO = new VvdSaDtVO();
		List<VvdSaDtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("port_cd", portCd);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdSaDtVO .class);
			
			if (list != null && list.size() > 0) {
				vvdSaDtVO = (VvdSaDtVO) list.get(0);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdSaDtVO;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 slanCd 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @return String
	* @exception DAOException
	*/
	public String searchLane( String bkgNo, String bkgSeq )throws DAOException {
		DBRowSet dbRowset = null;
		String slanCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchLaneRSQL(), param, velParam);
			if(dbRowset.next()) {						
				slanCd = dbRowset.getString("slan_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return slanCd;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 svcScpCd 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @return String
	* @exception DAOException
	*/
	public String searchServiceScope( String bkgNo, String bkgSeq )throws DAOException {
		DBRowSet dbRowset = null;
		String svcScpCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchServiceScopeRSQL(), param, velParam);
			if(dbRowset.next()) {						
				svcScpCd = dbRowset.getString("svc_scp_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return svcScpCd;
	}
	
	/**
	 * VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchSailingDateRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	
	
	/**
	 * MDM_ORGANIZATION 테이블에서 AR_OFC_CD,SUB_AGN_FLG 조회<br>
	 * 
	 * @param String ofcCd
	 * @return ArOfcAgtMkVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArOfcAgtMkVO searchAROfficeAgtMk(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ArOfcAgtMkVO arOfcAgtMkVO = new ArOfcAgtMkVO();
		List<ArOfcAgtMkVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchAROfficeAgtMkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcAgtMkVO .class);
			
			if (list != null && list.size() > 0) {
				arOfcAgtMkVO = (ArOfcAgtMkVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfcAgtMkVO;
	}
	
	/**
	 * MDM_ORGANIZATION 테이블에서 AR_OFC_CD 정보 조회<br>
	 * 
	 * @param String arOfcCd
	 * @return ArOfcAttributeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArOfcAttributeVO searchOfficeAttribute(String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ArOfcAttributeVO arOfcAttributeVO = new ArOfcAttributeVO();
		List<ArOfcAttributeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchOfficeAttributeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcAttributeVO .class);
			
			if (list != null && list.size() > 0) {
				arOfcAttributeVO = (ArOfcAttributeVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfcAttributeVO;
	}
	
	/**
	 * MDR_CR_CUST 테이블에서 ACT_CUST 조회<br>
	 * 
	 * @param String invCustCntCd
	 * @param String invCustSeq
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchActualCustomerCode(String invCustCntCd,String invCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_cust_cnt_cd", invCustCntCd);
			mapVO.put("inv_cust_seq", invCustSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchActualCustomerCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
	 * MDM_CR_CUST, MDM_ORGANIZATION 테이블에서 select<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return ARCreditVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCreditVO searchCreditCustomerForCredit(ARInvoiceCreationVO invCreVo) throws DAOException {
		DBRowSet dbRowset = null;
		ARCreditVO arCrdtVo = new ARCreditVO();
		List<ARCreditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invCreVo != null){
				Map<String, String> mapVO = invCreVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchCreditCustomerForCreditRSQL(), param, velParam);
//			while(dbRowset.next()){
//            	//port = dbRowset.getString("port");
//				arCrdtVo.setCrFlg(dbRowset.getString("cr_flg"));
//				arCrdtVo.setDueDt(dbRowset.getString("due_dt"));
//				arCrdtVo.setCrTerm(dbRowset.getString("cr_term"));
//            }
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCreditVO .class);
			
			if (list != null && list.size() > 0) {
				arCrdtVo = (ARCreditVO) list.get(0);
			} 

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCrdtVo;
	}	
	
	/**
	 * MDM_ORGANIZATION 테이블에서 select<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return ARCreditVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCreditVO searchOfficeForCredit(ARInvoiceCreationVO invCreVo) throws DAOException {
		DBRowSet dbRowset = null;
		ARCreditVO arCrdtVo = new ARCreditVO();
		List<ARCreditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invCreVo != null){
				Map<String, String> mapVO = invCreVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchOfficeForCreditRSQL(), param, velParam);
//			while(dbRowset.next()){
//            	port = dbRowset.getString("port");
//				arCrdtVo.setCrFlg(dbRowset.getString("cr_flg"));
//				arCrdtVo.setDueDt(dbRowset.getString("due_dt"));
//				arCrdtVo.setCrTerm(dbRowset.getString("cr_term"));
//          }
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCreditVO .class);
			
			if (list != null && list.size() > 0) {
				arCrdtVo = (ARCreditVO) list.get(0);
			} else {
				arCrdtVo = new ARCreditVO();
				
				arCrdtVo.setCrFlg("");
				arCrdtVo.setDueDt("");
				arCrdtVo.setCrTerm("");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCrdtVo;
	}	
	
	/**
  	* Interface Number 테이블에서 Select<br>
  	* 
	* @param  String acctCtnt4
	* @param  String acctCtnt5
	* @param  String acctCtnt6
	* @return String
	* @exception DAOException
	*/
	public String searchBKGInterfaceNo ( String acctCtnt4, String acctCtnt5, String acctCtnt6 )throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_ctnt4", acctCtnt4);
			mapVO.put("acct_ctnt5", acctCtnt5);
			mapVO.put("acct_ctnt6", acctCtnt6);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchBKGInterfaceNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxSeq = dbRowset.getString("maxSeq");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxSeq;
	}
	
	/**
	 * INV_AR_BKG_IF_NO 테이블에 insert<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addNewInterfaceNo(String ofcCd,String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("cre_usr_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOAddNewInterfaceNoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	
	/**
	 * INV_AR_BKG_IF_NO 테이블에 update<br>
	 * 
	 * @param String ofcCd
	 * @param String maxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyNewInterfaceNo(String ofcCd,String maxSeq,String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.info("user:"+userId);
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("upd_usr_id", userId);
			mapVO.put("max_seq", maxSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOModifyNewInterfaceNoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
  	*  Rev Type으로 TJSRCNM 조회<br>
  	* 
	* @param String ofcCd
	* @param  String chgCd
	* @param  String revTpSrcCd
	* @param  String svrId
	* @return String
	* @exception DAOException
	*/
	public String searchTjSrcNm( String ofcCd, String chgCd, String revTpSrcCd , String svrId) throws DAOException {
		DBRowSet dbRowset = null;
		String tjSrcNm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);			
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_src_cd", revTpSrcCd);
			mapVO.put("svr_id", svrId);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchTjSrcNmRSQL(), param, velParam);
			if(dbRowset.next()) {						
				tjSrcNm = dbRowset.getString("tj_src_nm");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return tjSrcNm;
	}
	
	/**
	 * INV_AR_MN table 저장<br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception DAOException
	 */
	  public void addInvMain(InvArMnVO invMain) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = invMain.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOAddInvMainCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}	 	
	 
	/**
	 * INV_AR_AMT table 저장<br>
	 * 
	 * @param List<InvArAmtVO> invAmts
	 * @exception DAOException
	 */                  
    public void addInvAmount(List<InvArAmtVO> invAmts ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invAmts.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOAddInvAmountCSQL(), invAmts, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	 
	 
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
    public void addInvCharge(List<InvArChgVO> invChges ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invChges.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOAddInvChargeCSQL(), invChges, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }	
    
    /**
	 * INV_AR_AMT table 저장 BKG Interface 요<br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */                  
    public void modifyInvArChg(String arIfNo) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
    	int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOModifyInvArChgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}    
    }	 
    
    /**
	 * ifNo 로 Local Amount Update <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	
	public void modifyInvTotalLocalAmount(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOModifyInvTotalLocalAmountUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
  	* Account Rate 테이블에서 Select<br>
  	* 
  	* @param  String effDt
	* @return int
	* @exception DAOException
	*/
	public int checkAccountRateExist ( String effDt )throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("eff_dt", effDt);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOCheckAccountRateExistRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
	    	}
			log.info("cnt==>"+cnt);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}
	
	/**
	 * flag='good' 인 경우   INV_AR_MN 의 BL_INV_CFM_DT 에 Local time의 YYYYMMDD 를 Update <br>
	 * [경리환율에따라 ] INV_AR_MN.BL_INV_CFM_DT 컬럼을 Update 하고 종료<br>
	 * 
	 * @param String ifNo
	 * @param String flag
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	public void modifyCFMDate(String ifNo,String flag,String arOfcCd, String blSrcNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			mapVO.put("flag", flag);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOModifyCFMDateVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
  	* INV_AR_AMT에서 CHG 테이블 내용으로 조회<br>
  	* 
	* @param String arIfNo
	* @return List<InvArAmtVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArAmtVO> searchInvArAmount ( String arIfNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArAmtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchInvArAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArAmtVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CustExrateInputVO custExrateVo
	 * @return String
	 * @exception DAOException
	 */	  
	public String searchCustomerExrate(CustExrateInputVO custExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custExrateVo != null){
				Map<String, String> mapVO = custExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchCustomerExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	 
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDExrateInputVO vvdExrateVo
	 * @return String
	 * @exception DAOException
	 */
	 public String searchVVDExrate(VVDExrateInputVO vvdExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdExrateVo != null){
				Map<String, String> mapVO = vvdExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchVVDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}		 
	 
	/**
  	* Select New BKG No<br>
  	* 
	* @param  String acctCtnt2
	* @param  String acctCtnt4
	* @param  String acctCtnt5
	* @param  String acctCtnt6
	* @return String
	* @exception DAOException
	*/
	public String searchMaxBKGNo ( String acctCtnt2, String acctCtnt4, String acctCtnt5, String acctCtnt6 )throws DAOException {
		DBRowSet dbRowset = null;
		String newBkgNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_ctnt2", acctCtnt2);
			mapVO.put("acct_ctnt4", acctCtnt4);
			mapVO.put("acct_ctnt5", acctCtnt5);
			mapVO.put("acct_ctnt6", acctCtnt6);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchMaxBKGNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				newBkgNo = dbRowset.getString("new_bkg_no");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newBkgNo;
	}
	
	/**
  	* Select New Invoice No<br>
  	* 
	* @param  String acctCtnt2
	* @param  String acctCtnt4
	* @param  String acctCtnt5
	* @param  String acctCtnt6
	* @return String
	* @exception DAOException
	*/
	public String searchMaxInvoiceNo ( String acctCtnt2, String acctCtnt4, String acctCtnt5, String acctCtnt6 )throws DAOException {
		DBRowSet dbRowset = null;
		String newInvNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_ctnt2", acctCtnt2);
			mapVO.put("acct_ctnt4", acctCtnt4);
			mapVO.put("acct_ctnt5", acctCtnt5);
			mapVO.put("acct_ctnt6", acctCtnt6);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchMaxInvoiceNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				newInvNo = dbRowset.getString("new_inv_no");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return newInvNo;
	}
	
	
	/**
	 * MDM_ORGANIZATION table 에서 LOC_CD 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCityCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String locCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchCityCdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		locCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return locCd;
	}		
	
	/**
	 * INV_AR_IF_MN Table 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String fmSrcIfSeq
	 * @param String toSrcIfSeq
	 * @return List<InvArIfMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArIfMnVO> searchInvArIfMain(String ofcCd, String fmSrcIfSeq, String toSrcIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_cd", ofcCd);
				mapVO.put("fm_src_if_seq", fmSrcIfSeq);
				mapVO.put("to_src_if_seq", toSrcIfSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchInvArIfMainRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return list;
	}
	
	/**
	 * INV_AR_IF_CHG Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("src_if_dt", srcIfDt);
				mapVO.put("src_if_seq", srcIfSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchInvArIfChgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
						
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return list;
	}	
	
	/**
  	* INV_AR_MN 테이블에서 I/F 되어 있는 데이터가 있는지 여부 체크<br>
  	* 
  	* @param  String blSrcNo
	* @return int
	* @exception DAOException
	*/
	public int searchLastDMTInvNo( String blSrcNo)throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchLastDMTInvNoSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
	    	}
			log.info("cnt==>"+cnt);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}
	
	/**
	 * Other Interface 에러사유 저장 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIFSeq
	 * @param String ifErrRsn
	 * @exception DAOException
	 */
	public void modifyIfErrRsn(String srcIfDt, String srcIFSeq, String ifErrRsn) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0; 
        
        try {
        	
			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("src_if_dt", srcIfDt);
			mapVO.put("src_if_seq", srcIFSeq);
			mapVO.put("if_err_rsn", ifErrRsn);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	            
            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOmodifyIfErrRsnUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
            	throw new DAOException("Fail to update SQL");
            }
        	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

	}
	
	/**
	 * MDM_ORGANIZATION table 에서 office 정보 조회<br>
	 * 
	 * @param String ifSrcCd
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmOrganizationVO searchOfficeAttribute(String ifSrcCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		MdmOrganizationVO mdmOrgVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("if_src_cd", ifSrcCd);
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchGeneralOfficeAttributeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO .class);
			
			if (list != null && list.size() > 0) {
				mdmOrgVo = (MdmOrganizationVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mdmOrgVo;
	}	

	
	/**
	 * VSK_VSL_SKD table 에서 data 유무 체크<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String port
	 * @return String
	 * @exception DAOException
	 */
	public String searchVskVslSkd(String vslCd, String skdVoyNo, String skdDirCd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		String flag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
        	if(vslCd != null && skdVoyNo != null && skdDirCd != null && port != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				mapVO.put("port", port);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchVskVslSkdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		flag = dbRowset.getString(1);
	    	}

        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return flag;
	}	
	
	/**
	 * AR_MST_REV_VVD table 에서 data 유무 체크<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchArMstRevVvd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		String flag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
        	if(vslCd != null && skdVoyNo != null && skdDirCd != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchArMstRevVvdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		flag = dbRowset.getString(1);
	    	}
	    				
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return flag;
	}	
	
	/**
	 * AR_MST_REV_VVD table 에서 data 유무 체크<br>
	 * 
	 * @return BkgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdVO searchArMstRevVvdTml() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		BkgVvdVO bkgVvdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
        	if(bkgVvdVo != null) {
	            Map<String, String> mapVO = bkgVvdVo.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchArMstRevVvdTmlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO .class);
			
			if (list != null && list.size() > 0) {
				bkgVvdVo = (BkgVvdVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return bkgVvdVo;
	}	
	
	/**
	 * MDM_LOCATION table 에서 rgn_cd 조회<br>
	 * 
	 * @param String locCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchRgnCd(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rgnCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("loc_cd", locCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchRgnCdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rgnCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return rgnCd;
	}	
	
	/**
	 * MDM_SVC_SCP_LMT table 에서 svc_scp_cd 조회<br>
	 * 
	 * @param String rgnCdPor
	 * @param String rgnCdDel
	 * @param String laneCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSvcScp(String rgnCdPor, String rgnCdDel, String laneCd) throws DAOException {
		DBRowSet dbRowset = null;
		String svcScpCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rgnCdPor != null && rgnCdDel != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("rgn_cd_por", rgnCdPor);
				mapVO.put("rgn_cd_del", rgnCdDel);
				mapVO.put("lane_cd", laneCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchSvcScpRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		svcScpCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return svcScpCd;
	}	
	
	/**
	 * VSK_VSL_PORT_SKD table 에서 SAIL_ARR_DT, SLAN_CD 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @return VskVslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskVslPortSkdVO searchSaDtLaneOb(InvArIfMnVO invArIfMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		VskVslPortSkdVO vskVslPortSkdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("vsl_cd", invArIfMnVO.getVslCd());
				mapVO.put("skd_voy_no", invArIfMnVO.getSkdVoyNo());
				mapVO.put("skd_dir_cd", invArIfMnVO.getSkdDirCd());
				mapVO.put("pol_cd", invArIfMnVO.getPolCd());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchSaDtLaneObRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
			
			if (list != null && list.size() > 0) {
				vskVslPortSkdVo = (VskVslPortSkdVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return vskVslPortSkdVo;
	}	
	
	/**
	 * VSK_VSL_PORT_SKD table 에서 SAIL_ARR_DT, SLAN_CD 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @return VskVslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskVslPortSkdVO searchSaDtLaneIb(InvArIfMnVO invArIfMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		VskVslPortSkdVO vskVslPortSkdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("vsl_cd", invArIfMnVO.getVslCd());
				mapVO.put("skd_voy_no", invArIfMnVO.getSkdVoyNo());
				mapVO.put("skd_dir_cd", invArIfMnVO.getSkdDirCd());
				mapVO.put("pod_cd", invArIfMnVO.getPodCd());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchSaDtLaneIbRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
			
			if (list != null && list.size() > 0) {
				vskVslPortSkdVo = (VskVslPortSkdVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return vskVslPortSkdVo;
	}	
	
	/**
	 * AR_MST_REV_VVD table 에서 SAIL_ARR_DT, SLAN_CD 조회<br>
	 * 
	 * @param String localTime
	 * @return VskVslPortSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VskVslPortSkdVO searchSaDtLane(String localTime) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		VskVslPortSkdVO vskVslPortSkdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(localTime != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("local_time", localTime);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchSaDtLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
			
			if (list != null && list.size() > 0) {
				vskVslPortSkdVo = (VskVslPortSkdVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return vskVslPortSkdVo;
	}	
	
	/**
	 * office 별 Local Time 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalTime(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String localTime = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchLocalTimeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		localTime = dbRowset.getString(1);
	    	}
	    	//log.info("\n########## localTime : "+localTime);
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return localTime;
	}

	
	/**
	 * MDM_LOCATION table 에서 zone ioc 조회<br>
	 * 
	 * @param String pol
	 * @param String pod
	 * @return String
	 * @exception DAOException
	 */
	public String searchZoneIOC(String pol, String pod) throws DAOException {
		DBRowSet dbRowset = null;
		String zoneIoc = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pol != null && pod != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("pol", pol);
				mapVO.put("pod", pod);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchZoneIOCRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		zoneIoc = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return zoneIoc;
	}	
	
	/**
	 * MDM_CHARGE table 에서 CHG_NM 조회<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchChargeName(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String chgNm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chgCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("chg_cd", chgCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchChargeNameRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		chgNm = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return chgNm;
	}			
	
	
	/**
	 * REV_TP_CD, REV_SRC_CD 조회<br>
	 * 
	 * @param String ifTpCd
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ifSrcCd
	 * @return REVTypeSourceVO revTypeSrcVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public REVTypeSourceVO searchREVTypeSource(String ifTpCd, String bkgNo, String bkgSeq, String ifSrcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<REVTypeSourceVO> list = null;
		REVTypeSourceVO revTypeSrcVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ifSrcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("if_tp_cd", ifTpCd);
				mapVO.put("bkg_no", bkgNo);
				mapVO.put("bkg_seq", bkgSeq);
				mapVO.put("if_src_cd", ifSrcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchREVTypeSourceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, REVTypeSourceVO .class);
			
			if (list != null && list.size() > 0) {
				revTypeSrcVo = (REVTypeSourceVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return revTypeSrcVo;
	}		
	 
	
	/**
	 * ACCT_CD 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @param String acctCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdConversion(String ofcCd, String chgCd, String revTpCd, String revSrcCd, String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rAcctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("ofc_cd", ofcCd);			
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
			mapVO.put("acct_cd", acctCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchAccountCdConversionRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		rAcctCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return rAcctCd;
	}
	
	
	/**
	 * INV_AR_IF_MN Table 에 AR_IF_NO 업데이트. <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @param String arIfNo
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyIfNo(String srcIfDt, String srcIfSeq, String arIfNo, String ofcCd, String userId) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("src_if_dt", srcIfDt);
			mapVO.put("src_if_seq", srcIfSeq);
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOmodifyIfNoUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	} 
	
	/**
	 * VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String vslCd
	 * @param String voyNo
	 * @param String dirCd
	 * @param String port
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDateByVvd(String vslCd, String voyNo, String dirCd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("voy_no", voyNo);
			mapVO.put("dir_cd", dirCd);
			mapVO.put("port", port);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchSailingDateByVvdRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	

	
	/**
	 * FINC_RGN_CD, AR_CTR_CD 조회<br>
	 * 
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmOrganizationVO searchInvCoaRgnInvCoaCtr(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		MdmOrganizationVO mdmOrganizationVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ofc_cd", ofcCd);
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchInvCoaRgnInvCoaCtrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO .class);
			
			if (list != null && list.size() > 0) {
				mdmOrganizationVO = (MdmOrganizationVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mdmOrganizationVO;
	}		
	
	/**
	 * USD_XCH_RT 조회<br>
	 * 
	 * @param String localTime
	 * @param String lclCurr
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsdXchRtByAcctMonth(String localTime, String lclCurr) throws DAOException {
		DBRowSet dbRowset = null;
		//List<MdmOrganizationVO> list = null;
		String usdXchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(localTime != null && lclCurr != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("local_time", localTime);
				mapVO.put("lcl_curr", lclCurr);
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchUsdXchRtByAcctMonthRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		usdXchRt = dbRowset.getString(1);
	    	}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return usdXchRt;
	}	
	
    
	/**
  	*  REV_TP_SRC_CD 조회<br>
  	* 
	* @param  String chgCd
	* @param  InvArMnVO invArMnVO
	* @param  String acctCd
	* @return InvArChgVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public InvArChgVO searchInvRevTpSrcCd(String chgCd, InvArMnVO invArMnVO, String acctCd) throws DAOException {
	
		DBRowSet dbRowset = null;
		InvArChgVO invChgeVo = new InvArChgVO();
		List<InvArChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", invArMnVO.getRevTpCd());
			mapVO.put("rev_src_cd", invArMnVO.getRevSrcCd());
			//mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
			mapVO.put("ofc_cd", invArMnVO.getArOfcCd());
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchInvRevTpSrcCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArChgVO .class);
			if (list != null && list.size() > 0) {
				invChgeVo = (InvArChgVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invChgeVo;
	}
	
	
	/**
	 * INV_AR_IF_MN의 BL_SRC_NO 유무 체크, INV_AR_IF_CHG DATA 유무 체크<br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIFSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchInterfaceMain(String srcIfDt, String srcIFSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String ifFlag = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("src_if_dt", srcIfDt);
			mapVO.put("src_if_seq", srcIFSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOsearchInterfaceMainRSQL(), param, velParam);
			if(dbRowset.next()) {						
				ifFlag = dbRowset.getString("if_flag");
	    	} else {
	    		ifFlag = "NO_CHG";
	    	}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ifFlag;
	}	
	
	/**
	 * INV_AR_MRI_IF_NO table 에서 MRI_MAX_SEQ 조회. <br>
	 * 
	 * @param  String acctCtnt4
	 * @param  String acctCtnt5
	 * @param  String acctCtnt6
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String acctCtnt4, String acctCtnt5, String acctCtnt6) throws DAOException {
		DBRowSet dbRowset = null;
		String mriMaxSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("acct_ctnt4", acctCtnt4);
			mapVO.put("acct_ctnt5", acctCtnt5);
			mapVO.put("acct_ctnt6", acctCtnt6);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOsearchMRIInterfaceNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				mriMaxSeq = dbRowset.getString("mri_max_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mriMaxSeq;
	}
	
	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOaddMRIInterfaceNoCSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("mri_max_seq", mriMaxSeq);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOmodifyMRIInterfaceNoUSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
    public void addOtherInvCharge(List<InvArChgVO> invChges ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invChges.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
			
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOaddOtherInvChargeCSQL(), invChges, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }
    
	/**
	 * INV_AR_MN table 에 저장 <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception DAOException
	 */
	public void addOtherInvMain(InvArMnVO invMain) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> velParam = invMain.getColumnValues();				
			Map<String, String> paramMap = invMain.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOaddOtherInvMainCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}
	
	/**
	 * INV_AR_AMT table 저장 <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception DAOException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, InvArMnVO invArMnVo, InvArAmtVO invArAmtVo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(arIfNo != null && invArMnVo != null && invArAmtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ar_if_no", arIfNo);            
				mapVO.put("ar_inv_src_cd", invArAmtVo.getArInvSrcCd());            
				mapVO.put("inv_coa_co_cd", invArAmtVo.getInvCoaCoCd());            
				mapVO.put("inv_coa_rgn_cd", invArAmtVo.getInvCoaRgnCd());            
				mapVO.put("inv_coa_ctr_cd", invArAmtVo.getInvCoaCtrCd());            
				mapVO.put("svr_id", svrId);            
				mapVO.put("rev_tp_cd", invArMnVo.getRevTpCd());            
				mapVO.put("rev_src_cd", invArMnVo.getRevSrcCd());            
				mapVO.put("acct_cd", invArMnVo.getAcctCd());            
				mapVO.put("inv_coa_inter_co_cd", invArAmtVo.getInvCoaInterCoCd());           
				mapVO.put("inv_coa_vsl_cd", invArAmtVo.getInvCoaVslCd());            
				mapVO.put("inv_coa_voy_no", invArAmtVo.getInvCoaVoyNo());            
				mapVO.put("inv_coa_skd_dir_cd", invArAmtVo.getInvCoaSkdDirCd());            
				mapVO.put("inv_coa_rev_dir_cd", invArAmtVo.getInvCoaRevDirCd());            
				mapVO.put("erp_if_gl_dt", invArAmtVo.getErpIfGlDt());            
				mapVO.put("erp_if_ofc_cd", invArAmtVo.getErpIfOfcCd());            
				mapVO.put("cre_usr_id", invArMnVo.getCreUsrId());            
				mapVO.put("upd_usr_id", invArMnVo.getUpdUsrId());				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOaddOtherInvAmountCSQL(), param, velParam);
	    } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS table 저장<br>
	 * 
	 * @param InvArIssVO invArIss
	 * @exception DAOException
	 */
	public void addInvIss(InvArIssVO invArIss) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = invArIss.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOAddInvIssCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}	 	
	 
	/**
	 * INV_AR_ISS_DTL table 저장<br>
	 * 
	 * @param List<InvArIssDtlVO> invArIssDtl
	 * @exception DAOException
	 */                  
    public void addInvIssDtl(List<InvArIssDtlVO> invArIssDtl ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invArIssDtl.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AccountReceivableInvoiceMigrationDBDAOAddInvIssDtlCSQL(), invArIssDtl, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	 
    
    /**
	 * 경리환율 해당되는 값을 불러온다.<br>
	 * 
	 * @param String fromCurrCd
	 * @param String toCurrCd
	 * @param String effDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountRate(String fromCurrCd,String toCurrCd,String effDt) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String usdLoclXchRt = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("from_curr_cd", fromCurrCd);
			mapVO.put("to_curr_cd", toCurrCd);
			mapVO.put("eff_dt", effDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchAccountRateRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		usdLoclXchRt = dbRowset.getString("usd_locl_xch_rt");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usdLoclXchRt;
	}		
	
	/**
	 * Add VVD Exchange Rate<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvdCd
	 * @exception DAOException
	 */
	public void addVVDExchangeRate(String arOfcCd,String vvdCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("vvd_cd", vvdCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOAddVVDExchangeRateCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * USD의 Ex.Rate에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDExrateInputVO vvdExrateVo
	 * @return String
	 * @exception DAOException
	 */
	 public String searchVVDUSDExrate(VVDExrateInputVO vvdExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdExrateVo != null){
				Map<String, String> mapVO = vvdExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchVVDUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}
	 
	/**
	 * USD의 Ex.Rate에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CustExrateInputVO custExrateVo
	 * @return String
	 * @exception DAOException
	 */	  
	public String searchCustomerUSDExrate(CustExrateInputVO custExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custExrateVo != null){
				Map<String, String> mapVO = custExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchCustomerUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}
	
	/**
	 * Search Office A/R Currency Code<br>
	 * 
	 * @param String ofcCd
	 * @return ARCurrCdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCurrCdVO searchOfficeCurrency(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCurrCdVO> list = null;
		ARCurrCdVO arCurrCdVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchOfficeCurrencyRSQL(), param, velParam);	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARCurrCdVO.class);

			if (list != null && list.size() > 0) {
				arCurrCdVO = (ARCurrCdVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCurrCdVO;
	}
	
	/**
	 * Add Daily USD Exchange Rate<br>
	 * 
	 * @param String arOfcCd
	 * @exception DAOException
	 */
	public void addDailyUSDExchangeRate(String arOfcCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOAddDailyUSDExchangeRateCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Daily의 Ex.Rate에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ChinaDailyExrateInputVO chinaDailyExrateVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchChinaDailyExrate(ChinaDailyExrateInputVO chinaDailyExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chinaDailyExrateVo != null){
				Map<String, String> mapVO = chinaDailyExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	

	/**
	 * Daily의 Ex.Rate에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ChinaDailyExrateInputVO chinaDailyExrateVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchChinaDailyUSDExrate(ChinaDailyExrateInputVO chinaDailyExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chinaDailyExrateVo != null){
				Map<String, String> mapVO = chinaDailyExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchChinaDailyUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	
	
	/**
  	* INV_BKG_IF_MN 테이블에서 POL/POD VVD 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @param  String ioBndCd
	* @return String
	* @exception DAOException
	*/
	public String searchPolPodVvd( String bkgNo, String bkgSeq, String ioBndCd )throws DAOException {
		DBRowSet dbRowset = null;
		String vvdCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchPolPodVvdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				vvdCd = dbRowset.getString("vvd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vvdCd;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 VVD,SaDt 조회<br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String portCd
	 * @param String ioBndCd
	 * @param String divCd
	 * @return VvdSaDtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VvdSaDtVO searchVVDSaDtByVslVoy(String vslCd, String skdVoyNo, String skdDirCd, String portCd, String ioBndCd, String divCd) throws DAOException {
		DBRowSet dbRowset = null;
		VvdSaDtVO vvdSaDtVO = new VvdSaDtVO();
		List<VvdSaDtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);
			mapVO.put("port_cd", portCd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("div_cd", divCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableInvoiceMigrationDBDAOSearchVVDSaDtByVslVoyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdSaDtVO .class);
			
			if (list != null && list.size() > 0) {
				vvdSaDtVO = (VvdSaDtVO) list.get(0);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdSaDtVO;
	}
}
