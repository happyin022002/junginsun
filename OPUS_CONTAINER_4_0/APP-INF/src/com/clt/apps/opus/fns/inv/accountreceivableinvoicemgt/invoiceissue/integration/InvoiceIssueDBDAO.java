/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueDBDAO.java
*@FileTitle : (Vietnam) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.BLMaxIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CustomerListForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVMainInfoForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.INVChargeInfoForIssueVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvRdApplCdFtpVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceARIssueTempVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.InvArIssVO;
import com.clt.syscommon.common.table.MdmCrCustVO;


/**max
 * InvoiceIssueDBDAO <br>
 * - AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see InvoiceIssueBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceIssueDBDAO extends DBDAOSupport {
    
	 
	/**
	 * InvoiceIssueDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param InvArIssVO invArIssVO
	 * @return List<InvArIssVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIssVO> searchInvoiceRemark(InvArIssVO invArIssVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIssVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIssVO != null){
				Map<String, String> mapVO = invArIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceRemarkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIssVO .class);
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
	 * Invoice 발행시 Copy 본수를 조회한다. <br>
	 * 
	 * @param String ofcCd
	 * @return int
	 * @exception DAOException
	 */
	public int searchInvoiceCopyCnt(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		int copyCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL(), param, velParam);
			if(dbRowset.next()) {						
				copyCnt = dbRowset.getInt("copy_cnt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return copyCnt;
	}		 

	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvArIssVO>
	 * @exception DAOException
	 */
	public List<InvIssMainVO> searchPrintInvoice(PrintInvoiceVO prtInvoiceVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvIssMainVO> list = new ArrayList<InvIssMainVO>();
		InvIssMainVO invIssMainVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(prtInvoiceVo != null){
				Map<String, String> mapVO = prtInvoiceVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchPrintInvoiceRSQL(), param, velParam);
						
			//log.info("########## dbRowset.getRowCount() : "+dbRowset.getRowCount());
			while(dbRowset.next()) {	
				invIssMainVO = new InvIssMainVO();
				invIssMainVO.setInvNo(dbRowset.getString("inv_no"));
				invIssMainVO.setInvIssCmbFlg(dbRowset.getString("inv_iss_cmb_flg"));
				invIssMainVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
				invIssMainVO.setIssGrpTpCd(dbRowset.getString("iss_grp_tp_cd"));
				list.add(invIssMainVO);
	    	}
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
	 * Invoice 발행 정보를 생성한다. <br>
	 * 
	 * @param InvIssMainVO issMainVO
	 * @exception DAOException
	 */
	public void createIssueMain(InvIssMainVO issMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(issMainVO != null){
				Map<String, String> mapVO = issMainVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOcreateIssueMainCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * Fax / E-mail 발송 또는 Print 하려는 대상 Invoice 정보를 조회한다. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvoiceFaxEmailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceFaxEmailListVO> searchIssuedGeneralInvoiceList(PrintInvoiceVO prtInvoiceVo) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(prtInvoiceVo != null){
				Map<String, String> mapVO = prtInvoiceVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceFaxEmailListVO .class);
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
	 * Invoice Number를 채번한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String bnd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceNumber(String ofcCd, String bnd, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bnd", bnd);
			mapVO.put("user_id", userId);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceNumberRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invNumVo.setInvPfxCd(dbRowset.getString("inv_pfx_cd"));
				invNumVo.setInvMaxSeq(dbRowset.getString("inv_max_seq"));
				invNumVo.setInvNo(dbRowset.getString("inv_no"));

	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return invNumVo;
	}	
	
	
	/**
	 *  INV_AR_ISS_DTL 테이블 데이타 생성 (해당 INV_AR_CHG 기준)<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String maxIfNo
	 * @param String userId
	 * @param String invNo
	 * @param String curCd
	 * @exception DAOException
	 */	
	public void createIssueDetail(String blNo, String ofcCd , String maxIfNo , String userId , String invNo, String curCd) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("inv_no", invNo);
			mapVO.put("ar_if_no", maxIfNo);
			mapVO.put("user_id", userId);
			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("curr_cd", curCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOcreateInvoiceMappingVOCSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice 발행할 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IssueTargetVO> searchTargetBLForIssue(GeneralInvoiceVO genInvVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<IssueTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchTargetBLForIssueVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssueTargetVO .class);
		
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
	 * Invoice Detail Table 에 저장할 대상 Data를 조회한다. <br>
	 * 
	 * @param String arIfNo
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IssueEachTargetVO> searchEachTargetForIssue(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<IssueEachTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arIfNo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ar_if_no", arIfNo);
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchEachTargetForIssueVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssueEachTargetVO .class);
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
	 * Invoice Number채번 Table의 max_seq 값을 변경한다. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvoiceNumber(String invPfxCd, String invMaxSeq, String userId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_pfx_cd", invPfxCd);
			mapVO.put("inv_max_seq", invMaxSeq);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			if (invMaxSeq.equals("1")) {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifyInvoiceNumberCSQL(), param, velParam);
			} else {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifyInvoiceNumberUSQL(), param, velParam);
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
	 * Invoice Detail 정보를 생성한다. <br>
	 * 
	 * @param String invNo
	 * @param IssueEachTargetVO issEachTgtVo
	 * @param String userId
	 * @exception DAOException
	 */
	public void createInvoiceMapping(String invNo, IssueEachTargetVO issEachTgtVo, String userId) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("inv_no", invNo);
			mapVO.put("ar_if_no", issEachTgtVo.getArIfNo());
			mapVO.put("ar_if_ser_no", issEachTgtVo.getArIfSerNo());
			mapVO.put("chg_seq", issEachTgtVo.getChgSeq());
			mapVO.put("user_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOcreateInvoiceMappingCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Customer 정보로 Due Date 를 구한다. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param String ofcCd
	 * @param String issDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchDueDateByCustomer(IssueTargetVO issTgtVo, String ofcCd, String issDt) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(issTgtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("io_bnd_cd", issTgtVo.getIoBndCd());
				mapVO.put("sail_arr_dt", issTgtVo.getSailArrDt());
				mapVO.put("ar_if_no", issTgtVo.getArIfNo());
				mapVO.put("cust_cnt_cd", issTgtVo.getActCustCntCd());
				mapVO.put("cust_seq", issTgtVo.getActCustSeq());
				mapVO.put("ofc_cd", ofcCd);
				mapVO.put("iss_dt", issDt);
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByCustomerRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	dueDt = dbRowset.getString("due_dt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dueDt;
	}
	
	/**
	 * Office 정보로 Due Date 를 구한다. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchDueDateByOffice(IssueTargetVO issTgtVo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(issTgtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("io_bnd_cd", issTgtVo.getIoBndCd());
				mapVO.put("sail_arr_dt", issTgtVo.getSailArrDt());
				mapVO.put("ofc_cd", ofcCd);
				mapVO.put("ar_if_no", issTgtVo.getArIfNo());
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByOfficeRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	dueDt = dbRowset.getString("due_dt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dueDt;
	}	
	
	/**
	 * Customer 테이블에서 Actual Customer Code 와 Payment date 와 Due Date 를 결정하는 구분자를 구한다. <br>
	 * 
	 * @param String cntCd
	 * @param String custCd
	 * @return MdmCrCustVO
	 * @exception DAOException
	 */
	public MdmCrCustVO searchPaymentDateByCustomer(String cntCd, String custCd) throws DAOException {
		DBRowSet dbRowset = null;
		MdmCrCustVO mdmCrCust = new MdmCrCustVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cntCd);
			mapVO.put("cust_seq", custCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIssVO .class);
            if(dbRowset.next()) {	
                
                mdmCrCust.setActCustCntCd(dbRowset.getString("act_cust_cnt_cd"));
            	mdmCrCust.setActCustSeq(dbRowset.getString("act_cust_seq"));
            	mdmCrCust.setPayDtDy1(dbRowset.getString("pay_dt_dy1"));
            	mdmCrCust.setPayDtDy2(dbRowset.getString("pay_dt_dy2"));
            	mdmCrCust.setPayDtDy3(dbRowset.getString("pay_dt_dy3"));
            	mdmCrCust.setPayDtDy4(dbRowset.getString("pay_dt_dy4"));
            	mdmCrCust.setCustCrDueDtDivCd(dbRowset.getString("cust_cr_due_dt_div_cd"));
            	mdmCrCust.setCrFlg(dbRowset.getString("cr_flg"));            	

	    	}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mdmCrCust;
	}		 	
	
	/**
	 * Invoice Number 로 Issue Date 를 구한다. <br>
	 * 
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchIssDate(String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		String issDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchIssDateRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	issDt = dbRowset.getString("iss_dt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return issDt;
	}	
	
	/**
	 * DUE DATE 와 신용 (CREDIT) 관련 정보를 구한다. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param String issDt
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchDueDateByDivCd(IssueTargetVO issTgtVo, String issDt, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(issTgtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("cust_cnt_cd", issTgtVo.getActCustCntCd());
				mapVO.put("cust_seq", issTgtVo.getActCustSeq());
				mapVO.put("sa_dt", issTgtVo.getSailArrDt());
				mapVO.put("io_bnd_cd", issTgtVo.getIoBndCd());
				mapVO.put("iss_dt", issDt);
				mapVO.put("ofc_cd", ofcCd);
				mapVO.put("ar_if_no", issTgtVo.getArIfNo());
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByDivCdRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	dueDt = dbRowset.getString("due_dt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dueDt;
	}		
	
	/**
	 * Payment Date로 Due Date 를 구한다. <br>
	 * 
	 * @param IssueTargetVO issTgtVo
	 * @param String dueDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchDueDateByPaymentDate(IssueTargetVO issTgtVo, String dueDt) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt2 = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(issTgtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("cust_cnt_cd", issTgtVo.getActCustCntCd());
				mapVO.put("cust_seq", issTgtVo.getActCustSeq());
				mapVO.put("due_dt", dueDt);
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	dueDt2 = dbRowset.getString("due_dt");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dueDt2;
	}	
	
	/**
	 * Invoice 발행 정보를 생성한다. <br>
	 * 
	 * @param InvIssMainVO issMainVO
	 * @exception DAOException
	 */
	public void modifyIssueMain(InvIssMainVO issMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(issMainVO != null){
				Map<String, String> mapVO = issMainVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifyIssueMainUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}	
	
	/**
	 * INV_AR_ISS 테이블에 EML_SND_NO or  FAX_SND_NO 를 Update. <br>
	 * 
	 * @param InvIssMainVO issMainVO
	 * @param String sendFlag
	 * @param String sndNo
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifySendNo(InvIssMainVO issMainVO, String sendFlag, String sndNo, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
		     
			mapVO.put("send_flag", sendFlag);
			mapVO.put("snd_no", sndNo);
			mapVO.put("user_id", userId);
			mapVO.put("inv_no", issMainVO.getInvNo());
			mapVO.put("iss_ofc_cd", issMainVO.getIssOfcCd());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifySendNoUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * 동일 INVOICE NO를 반영할 대상 INTERFACE NO를 구한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @param IssueTargetVO issTgtVo
	 * @return List<IssueTargetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IssueTargetVO> searchInterfaceNumberList(GeneralInvoiceVO genInvVo, IssueTargetVO issTgtVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<IssueTargetVO> list = new ArrayList<IssueTargetVO>();
		//IssueTargetVO issueTargetVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
						
			if(genInvVo != null && issTgtVo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ar_ofc_cd2", genInvVo.getArOfcCd2()); 
				mapVO.put("bnd", genInvVo.getBnd()); 
				mapVO.put("from_dt", genInvVo.getFromDt()); 
				mapVO.put("to_dt", genInvVo.getToDt()); 
				mapVO.put("dt_option", genInvVo.getDtOption()); 
				mapVO.put("vvd", genInvVo.getVvd()); 
				mapVO.put("bnd", genInvVo.getBnd()); 
				mapVO.put("port", genInvVo.getPort()); 
				mapVO.put("scp", genInvVo.getScp()); 
				mapVO.put("cust_cnt_cd", genInvVo.getCustCntCd()); 
				mapVO.put("cust_seq", genInvVo.getCustSeq()); 
				mapVO.put("bl_nos", genInvVo.getBlNos()); 
				mapVO.put("if_user_id", genInvVo.getIfUserId()); 
				mapVO.put("inv_dup_flg", genInvVo.getInvDupFlg()); 
				mapVO.put("inv_mlt_bl_iss_flg", genInvVo.getInvMltBlIssFlg()); 
				
				mapVO.put("max_act_cust_cnt_cd", issTgtVo.getActCustCntCd());   
				mapVO.put("max_act_cust_seq", issTgtVo.getActCustSeq());                    
				mapVO.put("max_vsl_cd", issTgtVo.getVslCd());                          
				mapVO.put("max_skd_voy_no", issTgtVo.getSkdVoyNo());                      
				mapVO.put("max_skd_dir_cd", issTgtVo.getSkdDirCd());                      
				mapVO.put("max_io_bnd_cd", issTgtVo.getIoBndCd());                       
				mapVO.put("max_port_cd", issTgtVo.getPortCd());                         
				mapVO.put("max_svc_scp_cd", issTgtVo.getSvcScpCd());                      
				mapVO.put("max_bl_src_no", issTgtVo.getBlSrcNo());                       
				mapVO.put("max_inv_iss_tp_cd", issTgtVo.getInvIssTpCd());   
				mapVO.put("max_inv_rmk", issTgtVo.getInvRmk()); 
				mapVO.put("max_sail_arr_dt", issTgtVo.getSailArrDt());                     
				mapVO.put("max_bkg_no", issTgtVo.getBkgNo());                          
				mapVO.put("max_rev_tp_cd", issTgtVo.getRevTpCd());                       
				mapVO.put("max_trsp_rqst_ord_flg", issTgtVo.getTrspRqstOrdFlg());  
				mapVO.put("max_inv_split_cd", issTgtVo.getInvSplitCd()); 
				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssueTargetVO .class);
						
//			while(dbRowset.next()) {						
//				log.info("   \n########## dbRowset.getString(AR_IF_NO) : "+dbRowset.getString("AR_IF_NO"));
//	
//				issueTargetVO = new IssueTargetVO();
//				issueTargetVO.setActCustCntCd(dbRowset.getString("ACT_CUST_CNT_CD"));
//				issueTargetVO.setActCustSeq(dbRowset.getString("ACT_CUST_SEQ"));
//				issueTargetVO.setVslCd(dbRowset.getString("VSL_CD"));
//				issueTargetVO.setSkdVoyNo(dbRowset.getString("SKD_VOY_NO"));
//				issueTargetVO.setSkdDirCd(dbRowset.getString("SKD_DIR_CD"));
//				issueTargetVO.setIoBndCd(dbRowset.getString("IO_BND_CD"));
//				issueTargetVO.setPortCd(dbRowset.getString("PORT_CD"));
//				issueTargetVO.setSvcScpCd(dbRowset.getString("SVC_SCP_CD"));
//				issueTargetVO.setBlSrcNo(dbRowset.getString("BL_SRC_NO"));
//				issueTargetVO.setInvIssTpCd(dbRowset.getString("INV_ISS_TP_CD"));
//				issueTargetVO.setInvRmk(dbRowset.getString("INV_RMK"));
//				issueTargetVO.setSailArrDt(dbRowset.getString("SAIL_ARR_DT"));
//				issueTargetVO.setBkgNo(dbRowset.getString("BKG_NO"));
//				issueTargetVO.setRevTpCd(dbRowset.getString("REV_TP_CD"));
//				issueTargetVO.setTrspRqstOrdFlg(dbRowset.getString("TRSP_RQST_ORD_FLG"));
//				issueTargetVO.setArIfNo(dbRowset.getString("AR_IF_NO"));
//				
//				list.add(issueTargetVO);			
//			      			     
//	    	}
		
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
	 * Invoice 비발행 대상 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchErrorBLNumberList(GeneralInvoiceVO genInvVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchErrorBLNumberListRSQL(), param, velParam);
			while(dbRowset.next()) {						
				list.add(dbRowset.getString("BL_SRC_NO"));
	    	}
		
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
	 * Invoice Number를 채번한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @param String userId
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceMaxSequence(String ofcCd, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("user_id", userId);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssMaxSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invNumVo.setInvPfxCd(dbRowset.getString("inv_pfx_cd"));
				invNumVo.setInvMaxSeq(dbRowset.getString("inv_max_seq"));
				invNumVo.setWrkNo(dbRowset.getString("wrk_no"));
				invNumVo.setIssDt(dbRowset.getString("iss_dt"));
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invNumVo;
	}	
	
	/**
	 * ISSUE TEMP 테이블 INSERT한다.(invDupFlg=N일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @exception DAOException
	 */
	/*public void addInvoiceIssueFilter(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssFilterCSQL(), param, velParam);				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}*/
	
	/**
	 * ISSUE TEMP 테이블 INSERT한다.(invDupFlg=N일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs
	 * @exception DAOException
	 */
	public void addInvoiceIssueFilter(List<INVMainInfoForIssueVO> iNVMainInfoForIssueVOs) throws DAOException,Exception {
	 	 try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (iNVMainInfoForIssueVOs.size() > 0 ) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOInvIssFilterCSQL(), iNVMainInfoForIssueVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ISSUE TEMP 테이블 INSERT한다.(invDupFlg=N일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @exception DAOException
	 */
	public void addInvoiceIssueFilterForDup(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssFilterForDupCSQL(), param, velParam);				
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * INV_AR_ISS 테이블 INSERT한다.(invDupFlg=N일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return String
	 * @exception DAOException
	 */
	public String addInvoiceIssue(InvIssVO invIssVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			int invSeq = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssCSQL(), param, velParam);
			return Integer.toString(invSeq);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * ISSUE TEMP 테이블 DELETE한다.(invDupFlg=Y일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param GeneralInvoiceVO genInvVo
	 * @exception DAOException
	 */
	public void removeInvoiceIssueFilterForDup(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssFilterForDupDSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS 테이블 INSERT한다.(invDupFlg=Y일때) <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return String
	 * @exception DAOException
	 */
	public String addInvoiceIssueForDup(InvIssVO invIssVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			int invSeq = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssForDupCSQL(), param, velParam);
			return Integer.toString(invSeq);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_DTL 테이블 INSERT한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceIssueDetail(InvIssVO invIssVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//String invIssTpCd = invIssVO.getInvIssTpCd();
			/* 2014.06.26
			if(invIssVO.getInvDupFlg().equals("Y")){
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlDupFlgCSQL(), param, velParam);
			}else if(invIssVO.getInvDupFlg().equals("N")){
				if(invIssTpCd.equals("E")){
					sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlECSQL(), param, velParam);
				}else if(invIssTpCd.equals("S")){ */
					sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlCSQL(), param, velParam);
		//		}
		//	}	
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ISSUE TEMP 테이블 DELETE한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void removeInvoiceIssueFilter(InvIssVO invIssVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssFilterDSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Inv No를 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchFilterInvoiceNumber(InvIssVO invIssVO) throws DAOException {
		DBRowSet dbRowset = null;
		//InvoiceNumberVO invNumVo = new InvoiceNumberVO();
		List list = new ArrayList();
		String strInvNo = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = invIssVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//if(invIssVO.getInvDupFlg().equals("Y")){
			//	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssInvNoForDupRSQL(), param, velParam);
			//}else if(invIssVO.getInvDupFlg().equals("N")){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssInvNoRSQL(), param, velParam);
			//}
			while (dbRowset.next()) {
				strInvNo = dbRowset.getString("inv_no");
				list.add(strInvNo);
			}
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
	 * Invoice Number채번 Table의 max_seq 값을 변경한다. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String invSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvMaxSeq(String invPfxCd, String invMaxSeq, String invSeq, String userId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_pfx_cd", invPfxCd);
			if (invMaxSeq.equals("0")) {
				mapVO.put("inv_max_seq", invSeq);
			}else{
				mapVO.put("inv_max_seq", invMaxSeq);
			}			
			mapVO.put("inv_seq", invSeq);
			mapVO.put("user_id", userId);			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			if (invMaxSeq.equals("0") && !invSeq.equals("0")) {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifyInvoiceNumberCSQL(), param, velParam);
			} else {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssModifyInvNoUSQL(), param, velParam);
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
	 * inv_ar_iss_ftr 에서 work 존재여부 체크 <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String wrkNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvIssWorkNumber(String wrkNo) throws DAOException {
		DBRowSet dbRowset = null;
		String wrkCnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("wrk_no", wrkNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssWrkChkRSQL(), param, velParam);
			while (dbRowset.next()) {
				wrkCnt = dbRowset.getString("wrkCnt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return wrkCnt;
	}	
	
	/**
	 * NextVal 실행 <br>
	 * 
	 * @author Dong Hoon Han
	 * @exception DAOException
	 */
	public void searchIssNoNextval() throws DAOException {
		DBRowSet dbRowset = null;
		//String wrkCnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssNextValRSQL(), param, velParam);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * IF NO를 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String wrkNo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchInterfaceNumberForERP(String wrkNo) throws DAOException {
		DBRowSet dbRowset = null;
		//InvoiceNumberVO invNumVo = new InvoiceNumberVO();
		List list = new ArrayList();
		String strArIfNo = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("wrk_no", wrkNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssIfNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				strArIfNo = dbRowset.getString("ar_if_no");
				list.add(strArIfNo);
			}
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
	 * A/R Setup Office 테이블에서 Select한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public SetupOfficeVO searchSetupOfficeForIssue(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		SetupOfficeVO setupOfficeVO = new SetupOfficeVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSetupOfficeVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				setupOfficeVO.setInvMltBlIssFlg(dbRowset.getString("inv_mlt_bl_iss_flg"));
				setupOfficeVO.setInvDupFlg(dbRowset.getString("inv_dup_flg"));
				setupOfficeVO.setOtsSmryCd(dbRowset.getString("ots_smry_cd"));
				setupOfficeVO.setInvIssTpCd(dbRowset.getString("inv_iss_tp_cd"));
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return setupOfficeVO;
	}	
	
	/**
	 * Invoice 발행 정보를 생성한다. <br>
	 * 
	 * @param String invNo
	 * @param String sndTp
	 * @param InvEmlVO invEmlSendNoVO
	 * @param String usrId
	 * @exception DAOException
	 */
	public void createSendNo(String invNo, String sndTp, InvEmlVO invEmlSendNoVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("inv_no", invNo);
			//mapVO.put("inv_seq", invSeq);
			mapVO.put("inv_iss_snd_tp_cd", sndTp);
			mapVO.put("inv_snd_cust_no", invEmlSendNoVO.getCustEml());
			mapVO.put("ofc_cd", invEmlSendNoVO.getOfcCd());
			mapVO.put("inv_snd_no", invEmlSendNoVO.getEmlSndNo());
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOcreateSendNoCSQL(), param, velParam);
						
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	
	/**
	 * office code 로 sever id 조회 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSeverId(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String svrId = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchSeverIdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		svrId = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return svrId;
	}	
	
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<CustomerListForIssueVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerListForIssueVO> searchCustomerListForIssue(GeneralInvoiceVO genInvVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerListForIssueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchCustomerListForIssueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerListForIssueVO .class);
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
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<INVMainInfoForIssueVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<INVMainInfoForIssueVO> searchINVMainInfoForIssue(GeneralInvoiceVO genInvVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<INVMainInfoForIssueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchINVMainInfoForIssueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, INVMainInfoForIssueVO .class);
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
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String ar_if_no
	 * @return List<INVChargeInfoForIssueVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<INVChargeInfoForIssueVO> searchINVChargeInfoForIssue(String ar_if_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<INVChargeInfoForIssueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ar_if_no != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ar_if_no", ar_if_no);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchINVChargeInfoForIssueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, INVChargeInfoForIssueVO .class);

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
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param List<INVChargeInfoForIssueVO> iNVChargeInfoForIssueVOs
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyInvoiceCharge(List<INVChargeInfoForIssueVO> iNVChargeInfoForIssueVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (iNVChargeInfoForIssueVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOModifyInvoiceChargeUSQL(), iNVChargeInfoForIssueVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String ar_if_no
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchValidTaxChgCurr(String ar_if_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ar_if_no != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ar_if_no", ar_if_no);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchValidTaxChgCurrRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CHK_CURR");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}	
	
	/**
	 * FTP 처리 위한 MRD 정보 Search <br>
	 * 
	 * FNS_INV_0034_02 <br>
	 * @author CLT
	 * @param String mrdNm
	 * @return InvRdApplCdFtpVO
	 * @throws DAOException
	 */ 
	public InvRdApplCdFtpVO searchRdApplCdFtp(String mrdNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvRdApplCdFtpVO> list = null;
		InvRdApplCdFtpVO invRdApplCdFtp = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("mrd_nm", mrdNm);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchRdApplCdFtpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvRdApplCdFtpVO.class);
			
			if(list.size()>0){
				invRdApplCdFtp = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invRdApplCdFtp;
	}
	
	/**
	 * Split이 존재하는 B/L 리스트를 조회한다. <br>
	 * 
	 * @param String arOfcCd
	 * @param String blNos
	 * @return List<BLMaxIfNoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BLMaxIfNoVO> searchSplitBLList(String arOfcCd, String blNos) throws DAOException {
		DBRowSet dbRowset = null;
		List<BLMaxIfNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_nos", blNos);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchSplitBLListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BLMaxIfNoVO .class);
		
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
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String blNos
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchBKGInterfaceCount(String blNos) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blNos != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("bl_nos", blNos);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchBKGInterfaceCountRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CNT");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}
	 
		
	/**
  	* Search INV_AR_ISS_TMP_SEQ.NEXTVAL <br>
  	* 
	* @return String
	* @exception DAOException
	*/
	public String searchInvoiceIssueTempNextSeq( ) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchInvoiceIssueTempNextSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				rtnValue = dbRowset.getString("NEXT_SEQ");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnValue;
	}	
	
	/**
	 * INSERT INV_AR_ISS_TMP<br>
	 * 
	 * @author ORKIM
	 * @category Invoice Reissue
	 * @param List<InvoiceARIssueTempVO> issTmpVOList
	 * @return int (insertcnt)
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public int addInvoiceIssueTemp(List<InvoiceARIssueTempVO> issTmpVOList) throws DAOException {
		int insertCnt = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (issTmpVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOAddInvoiceIssueTempCSQL(), issTmpVOList, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					} else {
						insertCnt++;
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insertCnt;
	}
		 
	/**
	 * SEARCH INV_AR_ISS_TMP BY SEQ <br>
	 * 
	 * @author ORKIM
	 * @category Invoice Reissue
	 * @param String invIssTmpSeq
	 * @return List<InvoiceARIssueTempVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceARIssueTempVO> searchInvoiceIssueTempList(String invIssTmpSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceARIssueTempVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_iss_tmp_seq", invIssTmpSeq);
			
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchInvoiceIssueTempListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceARIssueTempVO .class);
			
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
	 * INV_AR_ISS_TMP 삭제 ( FNS_INV_B004(batch) 에서 사용 )( <br>
	 * 
	 * @author ORKIM
	 * @category Invoice Reissue
	 * @param String invIssTmpSeq
	 * @exception DAOException
	 */
	public void removeInvoiceIssueTemp(String invIssTmpSeq) throws DAOException{
		try{
			int successFlag = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (invIssTmpSeq != null) {
				param.put("inv_iss_tmp_seq", invIssTmpSeq);		
				velParam.put("inv_iss_tmp_seq", invIssTmpSeq);		
			}
			
			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new InvoiceIssueDBDAORemoveInvoiceIssueTempDSQL(), param, velParam);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00066")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * office code 로 SPRT_EML_INV_FLG 조회 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSplitEmailFlagByOffice(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchSplitEmailFlagByOfficeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rtnValue = dbRowset.getString("SPRT_EML_INV_FLG");
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return rtnValue;
	}	
	
	
	/**
	 * customer 로 SPRT_EML_INV_FLG 조회 <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchSplitEmailFlagByCust(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custCntCd != null && custSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("cust_cnt_cd", custCntCd);
				mapVO.put("cust_seq", custSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchSplitEmailFlagByCustRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rtnValue = dbRowset.getString("SPRT_EML_INV_FLG");
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return rtnValue;
	}	

	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String arIfNo
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchDupInvoiceNo(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arIfNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ar_if_no", arIfNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchDupInvoiceNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("bl_src_no");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}

	/**
	 * FNS_INV_0034_01 <br>
	 * @author CLT
	 * @param String wrkNo
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchIssuedIfNo(String wrkNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(wrkNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("wrk_no", wrkNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchIssuedIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ar_if_no");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnValue;
	}
}
