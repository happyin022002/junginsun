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
* --------------------------------------------------------
* History
* 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2011.08.04 오요한 [CHM-201112323] 코드 속성 작업 결과에 따른 ALPS INV 소스 삭제
* 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
* 2012.02.01 권   민 [CHM-201215781-01] [INV] ALPS INV 중복 발행 시 알림창 pop up
* 2014.08.26 최도순 [CHM-201431413] 미주지역 Inv Issue 프로그램 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic.InvoiceIssueBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNIssuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CHNReissuedInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRIDListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArEmlCustRgstVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArGiroVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArKrIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArSplitIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvArUsaIssSndVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvEmlVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceFaxEmailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceNumberVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueEachTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.IssueTargetVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORGiroListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceBLListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.NYCInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.PrintInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.SetupOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEActInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIECombineInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEDailyExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIEInvoiceTargetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.InvArIssSndVO;
import com.hanjin.syscommon.common.table.InvArIssVO;
import com.hanjin.syscommon.common.table.MdmCrCustVO;


/**max
 * ALPS InvoiceIssueDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see InvoiceIssueBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceIssueDBDAO extends DBDAOSupport {
				
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	
	/**
	 * InvoiceIssueDBDAO 객체 생성<br>
	 * InvoiceIssueDBDAO 를 생성한다.<br>
	 */
	public InvoiceIssueDBDAO() { }
	
	/**
	 * InvoiceIssueDBDAO 객체 생성<br>
	 * InvoiceIssueDBDAO 를 생성한다.<br>
	 * @param String dataSource
	 */
	public InvoiceIssueDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
	
    /**
     * INV_AR_MN, INV_AR_GIRO, MDM_CUSTOMER 테이블에서 select. <br>
     * 
     * @param KORGiroInputVO giroInputVo
     * @return List<KORGiroListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<KORGiroListVO> searchKORGIROList(KORGiroInputVO giroInputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<KORGiroListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(giroInputVo != null){
				Map<String, String> mapVO = giroInputVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOKORGiroInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KORGiroListVO .class);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceRemarkRSQL(), param, velParam);
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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceCopyCntRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchPrintInvoiceRSQL(), param, velParam);
						
			//log.info("########## dbRowset.getRowCount() : "+dbRowset.getRowCount());
			while(dbRowset.next()) {	
				invIssMainVO = new InvIssMainVO();
				invIssMainVO.setInvNo(dbRowset.getString("inv_no"));
				invIssMainVO.setInvIssCmbFlg(dbRowset.getString("inv_iss_cmb_flg"));
				invIssMainVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
				invIssMainVO.setVnInvPayMzdCd(dbRowset.getString("vn_inv_pay_mzd_cd"));
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchIssuedGeneralInvoiceListRSQL(), param, velParam);
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
	 * INV_AR_MN 테이블과 INV_AR_CHG 테이블에서 넘겨 받은 B/L NO, OFFICE CODE 로 금액을 USD/Local 로 변환한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @return List<CHNIssuedInvoiceListVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CHNIssuedInvoiceListVO> searchCHNInvoiceForIssue(String blNo , String ofcCd, String curCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("curr_cd", curCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCHNIssuedInvoiceListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHNIssuedInvoiceListVO .class);
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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchInvoiceNumberRSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
	 * Invoice Main, Invoice Charge, Invoice Issue Detail, Invoice Issue main 테이블에서 Select 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @param String ofcCd
	 * @param String curCd
	 * @return List<CHNReissuedInvoiceListVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CHNReissuedInvoiceListVO> searchCHNInvoiceForReissue (String blNo , String ofcCd, String curCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("cur_cd", curCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCHNReissuedInvoiceListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHNReissuedInvoiceListVO .class);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchTargetBLForIssueVORSQL(), param, velParam, true);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchEachTargetForIssueVORSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByCustomerRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByOfficeRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchPaymentDateByCustomerRSQL(), param, velParam);
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
				
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchIssDateRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByDivCdRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL(), param, velParam);
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
	 * 한개 이상의 Report ID로  INV_CPRT_HIS에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTListVO cprIdVo
	 * @return List<CPRTMainVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTMainVO> searchCPRTHistoryList(CPRTListVO cprIdVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CPRTMainVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.info("########## cprIdVos : "+cprIdVo);
			if(cprIdVo != null){
				String custRptId = "";
				//for(int i=0; i<cprIdVos.length; i++) {
					custRptId = cprIdVo.getCustRptId();
				//}
				
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("cust_rpt_id", custRptId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCPRTMainVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTMainVO .class);
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
	 * Creation date, Create user ID, Office로  Report ID를  INV_CPRT_HIS에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRIDListInputVO cprsearchVo
	 * @return List<CPRTListVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTListVO> searchCPRTIDList(CPRIDListInputVO cprsearchVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CPRTListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cprsearchVo != null){
	
				Map<String, String> mapVO = cprsearchVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCPRTListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTListVO .class);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
	 * KOR Issue main[], Customer 테이블에서 select<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KORInvoiceVO searchKORIssuedCustomer(String invNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List< KORInvoiceVO> list = null;
		KORInvoiceVO korInvoiceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( invNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("inv_no", invNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssuedCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  KORInvoiceVO .class);
			
			if (list != null && list.size() > 0) {
				korInvoiceVO = (KORInvoiceVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korInvoiceVO;
	}
	
	/**
	 * KOR Invoice Main, Invoice Main 테이블에서 select<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofcCd
	 * @return List<KORInvoiceBLListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KORInvoiceBLListVO>  searchKORIssuedBLList (String invNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<KORInvoiceBLListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( invNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssuedBLListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  KORInvoiceBLListVO .class);
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
	 * KOR Invoice main, KOR Invoice Charge 테이블에서 Select<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofcCd
	 * @return List<InvArKrIssChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArKrIssChgVO>  searchKORIssuedChargeList (String invNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArKrIssChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( invNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssuedChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  InvArKrIssChgVO .class);
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
	 * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 CUSTOMER 테이블에서 CUSTOMER 정보를 SELECT 한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORInvoiceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public KORInvoiceVO searchKORIssueTargetByBL(String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List< KORInvoiceVO> list = null;
		KORInvoiceVO korInvoiceVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( blNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bl_src_no", blNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssueTargetByBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  KORInvoiceVO .class);
			
			if (list != null && list.size() > 0) {
				korInvoiceVO = (KORInvoiceVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korInvoiceVO;
	}
	
	/**
	 * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 Invoice Main 테이블에서 BKG NO, LOCAL VVD, S/A DATE, BOUND, PORT를 SELECT 한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return List<KORInvoiceBLListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<KORInvoiceBLListVO>  searchKORIssueTargetBL (String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<KORInvoiceBLListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( blNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_src_no", blNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssueTargetBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  KORInvoiceBLListVO .class);
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
	 * B/L NO 입력하고 TAB 또는 FOCUS 이동 시 Invoice CHARGE 테이블에서 해당 B/L NO의 I/F NO로 CHARGE 정보를 SELECT 한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return List<InvArKrIssChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArKrIssChgVO>  searchKORIssueTargetChargeList (String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArKrIssChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( blNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bl_src_no", blNo);
				mapVO.put("ar_ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORIssueTargetChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  InvArKrIssChgVO .class);
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
	 * INV_AR_BANK 테이블에서 Select하여 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @param String currCd
	 * @return List<String>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<String> searchBankAccount(String ofcCd, String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String acctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("curr_cd", currCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchBankAccountRSQL(), param, velParam);
			if(dbRowset.next()) {						
				acctCd = dbRowset.getString("bank_acct_no");
				list.add(acctCd);
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
	 * Korea Issue의 Issue event에 대한 main부분 insert 이벤트 처리<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @exception EventException
	 */	
	public void addKORIssueMain (KORInvoiceVO korInvVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(korInvVo != null){
				Map<String, String> mapVO = korInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 
			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOAddKORIssueMainCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Korea Issue의 Issue event에 대한 charge부분 insert 이벤트 처리<br>
	 * 
	 * @author JungJin Park
	 * @param KORInvoiceVO korInvVo
	 * @exception EventException
	 */	
	public void addKORIssueCharge (KORInvoiceVO korInvVo) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(korInvVo != null){
				List<InvArKrIssChgVO> insModels = korInvVo.getInvArKrIssChgVO();
				int insCnt[] = null;
				
				if(insModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOAddKORIssueChargeCSQL(), insModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
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
					
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchInterfaceNumberListVORSQL(), param, velParam, true);
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
	 * USER가 사용가능한 권한으로 등록된 Template name을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<TemplateVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<TemplateVO> searchTemplateList(String userId, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("usr_id", userId);
			mapVO.put("ar_ofc_cd", ofc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOTemplateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TemplateVO .class);
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
	 * 해당 Template으로 저장되어 있는 선택 item목록을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String tmplate
 	 * @param CPRTInputVO cprInputVo
	 * @return List<TemplateItemVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<TemplateItemVO> searchTemplateItemList(String tmplate,  CPRTInputVO cprInputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		
		log.debug("DBDAO==================scNo===================================");
    	log.debug(cprInputVo.getScNo());
    	log.debug(cprInputVo.getArOfcCd());
		log.debug("DBDAO==================scNo END===================================");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", cprInputVo.getArOfcCd());
			mapVO.put("sc_no", cprInputVo.getScNo());
			mapVO.put("rfa_no",  cprInputVo.getRfaNo());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOTemplateItemVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TemplateItemVO .class);
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
	 * CPRT 대상 데이터를 BKG 테이블에서 조회함. <br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return List<CPRTInvoiceVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = cprInputVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			List<String> cols  = new ArrayList();   
			
			StringTokenizer st = new StringTokenizer(rptItmId, "|");
			String strRptItmId = "";
			while (st.hasMoreTokens()) {
				strRptItmId = st.nextToken();
				if (!strRptItmId.equals("")) {
					cols.add(strRptItmId);
				}
			}
			param.put("allcols", cols);   
			velParam.put("allcols", cols);   
		    dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCPRTInvoiceVORSQL(), param, velParam, true);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTInvoiceVO .class);
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
	 * CPRT 대상 데이터를 BL No 조건으로 BKG 테이블에서 조회함. <br>
	 * @author KIM HYUN HWA
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return List<CPRTInvoiceVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTInvoiceVO> searchCPRTByBL(CPRTInputVO cprInputVo, String rptItmId) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("frt_term_cd", cprInputVo.getFrtTermCd()); 
				mapVO.put("bl_nos", cprInputVo.getBlNos()); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			List<String> cols  = new ArrayList();   
			
			StringTokenizer st = new StringTokenizer(rptItmId, "|");
			String strRptItmId = "";
			while (st.hasMoreTokens()) {
				strRptItmId = st.nextToken();
				if (!strRptItmId.equals("")) {
					cols.add(strRptItmId);
				}
			}
			param.put("allcols", cols);   
			velParam.put("allcols", cols);   

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceissueDBDAOCPRTInvoiceByMultiBLRSQL(), param, velParam, true);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTInvoiceVO .class);
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
	 * 신규 Report ID 생성시 이전 Max Report ID를 조회하여 다음 번호를 Return한다. <br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param String arOfcCd
	 * @return String
	 * @exception DAOException
	 */	
	public String searchMaxReporID(String custNm, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String reportId = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("custNm", custNm);
			mapVO.put("ar_ofc_cd", arOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchMaxReporIDRSQL(), param, velParam);
			if(dbRowset.next()) {						
				reportId = dbRowset.getString("cust_rpt_id");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return reportId;
	}
	
	/**
	 * Report ID 생성시 INV_CPRT_HIS에 정해진 주요 item  Insert.<br>
	 * Customer Name이 5자리+YYMM+’-’+SEQ3자리호 Report ID 생성.<br>
	 * @author Dong Hoon Han
	 * @param String newID
	 * @param CPRTInputVO cprInputVo
	 * @exception DAOException
	 */		
	public void addCPRTHistory(String newID, CPRTInputVO cprInputVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(cprInputVo != null){
				Map<String, String> mapVO = cprInputVo.getColumnValues();
				mapVO.put("cust_rpt_id", newID);
				mapVO.put("ar_ofc_cd", cprInputVo.getArOfcCd());
				mapVO.put("usr_id", cprInputVo.getCreUsrId());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOCPRTMain2VOCSQL(), param, velParam);
			//log.info("result==========>>>"+result);
			if(result == 0){
				throw new DAOException("Fail to insert SQL");
			}	
			//sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOCPRTMainVOCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * MDM_CUSTOMER, MDM_CR_CUST, MDM_CUST_ADDR, INV_AR_MN, INV_AR_CHG 테이블에서 select하여 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String blNo
	 * @param String ofcCd
	 * @return KORGiroListVO
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public KORGiroListVO searchGIROMain (String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		KORGiroListVO korGiroListVO = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blNo);
			mapVO.put("ar_ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchGIROMainRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, KORGiroListVO .class);
			if (list != null && list.size() > 0) {
				korGiroListVO = (KORGiroListVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return korGiroListVO;
	}
	
	/**
	 * INV_AR_GIRO 테이블에서 select하여 조회한다.<br>
	 * 
	 * @param String blNo
	 * @param String ofcCd
	 * @return List<InvArGiroVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArGiroVO> searchGIROAmtList (String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArGiroVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blNo);
			mapVO.put("ar_ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchGIROAmtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArGiroVO .class);
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
	 * INV_AR_GIRO 테이블 데이타 생성 (해당 INV_AR_MN 기준)<br>
	 * KOR 지로 정보 입력
	 *  
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception DAOException,Exception
	 */	
	public void createKORGIRO(List<InvArGiroVO> invArGiros) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			
			if(invArGiros.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOCreateKORGIROCSQL(), invArGiros,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_GIRO 테이블 데이타 생성 (해당 INV_AR_MN 기준)<br>
	 * KOR 지로 정보 수정
	 * 
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception DAOException,Exception
	 */	
	public void modifyKORGIRO(List<InvArGiroVO> invArGiros) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int updCnt[] = null;
			
			if(invArGiros.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOModifyKORGIROUSQL(), invArGiros,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  INV_AR_GIRO 테이블 데이타 수정 (해당 INV_AR_MN 기준)<br>
	 *  KOR 지로 정보 삭제
	 *  
	 * @author JungJin Park
	 * @param List<InvArGiroVO> invArGiros
	 * @exception DAOException,Exception
	 */	
	public void removeKORGIRO(List<InvArGiroVO> invArGiros) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int updCnt[] = null;
			
			if(invArGiros.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAORemoveKORGIROUSQL(), invArGiros,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * e-mail, FAX 전송 후 공통테이블에서 구한 SEND NO를 KOREA ISSUE MAIN 테이블에 업데이트 한다.
	 * email send date , fax send date 도 업데이트 한다. <br>
	 * 
	 * @param String invNo
	 * @param String invSeq
	 * @param String sendNo
	 * @param String flag
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyKORIssueMain (String invNo, String invSeq, String sendNo, String flag, String userId ) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
		     
			mapVO.put("send_flag", flag);
			mapVO.put("send_no", sendNo);
			mapVO.put("usr_id", userId);
			mapVO.put("inv_no", invNo);
			mapVO.put("inv_seq", invSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifyKORIssueMainUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice Main, Invoice Charge, Invoice Issue Detail, Invoice Issue Main, Customer 테이블에서 Select<br>
	 * 
	 * @param InvoiceIssueDateVO vieInvVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ARInvoiceListByIFDateVO> searchSWAIssuedInvoiceList (InvoiceIssueDateVO vieInvVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceListByIFDateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vieInvVo != null){
				StringBuffer sb = new StringBuffer();
				StringBuffer sb1 = new StringBuffer();
				if(!vieInvVo.getInvType().equals("") || vieInvVo.getInvType() !=null) {
					String arrInvType[] = vieInvVo.getInvType().split(",");
					
					if(arrInvType.length > 0) {
						if(!arrInvType[0].equals("A")) {
							sb.append(" AND (");
							sb1.append(" AND (");
							
							for (int i=0; i<arrInvType.length; i++) {
								if(arrInvType[i].equals("F")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'F%'");
										sb1.append("A1.INV_NO LIKE 'F%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'F%'");
										sb1.append(" OR A1.INV_NO LIKE 'F%'");
									}
								}
								if(arrInvType[i].equals("T")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'T%'");
										sb1.append("A1.INV_NO LIKE 'T%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'T%'");
										sb1.append(" OR A1.INV_NO LIKE 'T%'");
									}
								}
								if(arrInvType[i].equals("H")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'H%'");
										sb1.append("A1.INV_NO LIKE 'H%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'H%'");
										sb1.append(" OR A1.INV_NO LIKE 'H%'");
									}
								}
								if(arrInvType[i].equals("D")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'D%'");
										sb1.append("A1.INV_NO LIKE 'D%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'D%'");
										sb1.append(" OR A1.INV_NO LIKE 'D%'");
									}
								}
								if(arrInvType[i].equals("R")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'R%'");
										sb1.append("A1.INV_NO LIKE 'R%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'R%'");
										sb1.append(" OR A1.INV_NO LIKE 'R%'");
									}
								}
								if(arrInvType[i].equals("M")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'M%'");
										sb1.append("A1.INV_NO LIKE 'M%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'M%'");
										sb1.append(" OR A1.INV_NO LIKE 'M%'");
									}
								}
								if(arrInvType[i].equals("S")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'S%'");
										sb1.append("A1.INV_NO LIKE 'S%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'S%'");
										sb1.append(" OR A1.INV_NO LIKE 'S%'");
									}
								}
								if(arrInvType[i].equals("C")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'C%'");
										sb1.append("A1.INV_NO LIKE 'C%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'C%'");
										sb1.append(" OR A1.INV_NO LIKE 'C%'");
									}
								}
								if(arrInvType[i].equals("E")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'E%'");
										sb1.append("A1.INV_NO LIKE 'E%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'E%'");
										sb1.append(" OR A1.INV_NO LIKE 'E%'");
									}
								}
								if(arrInvType[i].equals("X")) {
									if(i == 0) {
										sb.append("A.INV_NO LIKE 'X%'");
										sb1.append("A1.INV_NO LIKE 'X%'");
									} else {
										sb.append(" OR A.INV_NO LIKE 'X%'");
										sb1.append(" OR A1.INV_NO LIKE 'X%'");
									}
								}	
							}
							sb.append(")");
							sb1.append(")");
						}
					}
				}
				
				vieInvVo.setInvType(sb.toString());
				
				Map<String, String> mapVO = vieInvVo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("inv_type1", sb1.toString());
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchSWAIssuedInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceListByIFDateVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * FNS_INV_0036<br>
	 * Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIEInvoiceTargetVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<VIEInvoiceTargetVO> searchVIEIssueTargetBLNoList(GeneralInvoiceVO sinInvVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<VIEInvoiceTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sinInvVo != null){
				Map<String, String> mapVO = sinInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIEIssueTargetBLNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VIEInvoiceTargetVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * FNS_INV_0036<br>
	 * Invoice Main, Invoice Charge 테이블을 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String blNo
	 * @param String invType
	 * @param String invNo
	 * @param String arOfcCd
	 * @return List<IssueEachTargetVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<IssueEachTargetVO> searchVIEIssueTargetByBLNo(String blNo, String invType, String invNo, String arOfcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<IssueEachTargetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bl_no", blNo);
			param.put("inv_no", invNo);
			param.put("ar_ofc_cd", arOfcCd);
			velParam.put("inv_type", invType);
			velParam.put("inv_type", invType);
				
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIEIssueTargetByBLNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssueEachTargetVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FNS_INV_0036<br>
	 * VIE Invoice Number 테이블을 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String invPrefix
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException,Exception
	 */
	public String searchVIEInvoiceNumber(String invPrefix, String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String invNo = "";

		try{
			param.put("vn_inv_pfx_cd", invPrefix);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIEInvoiceNumberRSQL(), param, null);
			if(dbRowset.next()) {
				//invNo = dbRowset.getString("inv_no").toString();
				invNo = dbRowset.getString("inv_no");
				log.error("invNo>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+invNo);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return invNo;
	}
		
	/**
	 * FNS_INV_0036<br>
	 * INV_AR_VN_ISS_NO 테이블에 VN_INV_PFX_CD별 ISSUE DATE에 VN_INV_MAX_SEQ '001'로 insert<br>
	 * 
	 * @param String prefix
	 * @param String ofcCd
	 * @param String userId
	 * @throws DAOException, Exception
	 */
	public void addVIEInvoiceNumber(String prefix, String ofcCd, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vn_inv_pfx_cd", prefix);
			param.put("ofc_cd", ofcCd);
			param.put("cre_usr_id", userId);
			param.put("upd_usr_id", userId);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOVIEInvoiceNumberCSQL(), param, null);
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
	 * FNS_INV_0036<br>
	 * INV_AR_VN_ISS_NO테이블에 VN_INV_PFX_CD별 ISSUE DATE에 VN_INV_MAX_SEQ에 새로 생성한. INV NO SEQ를 update 함.<br>
	 * 
	 * @param String prefix
	 * @param String maxseq
	 * @param String ofcCd
	 * @param String userId
	 * @throws DAOException, Exception
	 */
	public void modifyVIEInvoiceNumber(String prefix, String maxseq, String ofcCd, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vn_inv_pfx_cd", prefix);
			param.put("vn_inv_max_seq", maxseq);
			param.put("ofc_cd", ofcCd);
			param.put("upd_usr_id", userId);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOVIEInvoiceNumberUSQL(), param, null);
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
	 * FNS_INV_0036<br>
	 * 베트남 지역의 Invoice 발행시 적용 환율을 구한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIEDailyExrateVO vieDailyExrateVO
	 * @return VIEDailyExrateReturnVO
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public VIEDailyExrateReturnVO searchVIEDailyExrate (VIEDailyExrateVO vIEDailyExrateVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<VIEDailyExrateReturnVO> list = null;
		VIEDailyExrateReturnVO vIEDailyExrateReturnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vIEDailyExrateVO != null){
				Map<String, String> mapVO = vIEDailyExrateVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery(new InvoiceIssueDBDAOVIEDailyExrateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VIEDailyExrateReturnVO .class);
			if(list.size() > 0) {
				vIEDailyExrateReturnVO = (VIEDailyExrateReturnVO)list.get(0);
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vIEDailyExrateReturnVO;
	}
	
	/**
	 * Invoice Issue Main 테이블에 Update<br>
	 * 넘겨받은 INV NO로 INV_AR_ISS 테이블에서 찾아서 넘겨받은 ACTUAL INVOICE NO를 업데이트 한다.
	 * 즉, 동일한 INV_NO는 동일한 ACT_INV_NO를 갖는다.
	 * 
	 * @author JungJin Park
	 * @param List<VIEActInvoiceVO> vieActInvoiceVOs
	 * @exception DAOException
	 */	
	public void createVIEActualInvoiceNumber (List<VIEActInvoiceVO> vieActInvoiceVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if(vieActInvoiceVOs.size() > 0){				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new InvoiceIssueDBDAOCreateVIEActualInvoiceNumberUSQL(), vieActInvoiceVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0036<br>
	 * Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<VIECombineInvoiceVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<VIECombineInvoiceVO> searchVIECombineBLNoList(GeneralInvoiceVO sinInvVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<VIECombineInvoiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sinInvVo != null){
				Map<String, String> mapVO = sinInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIECombineBLNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VIECombineInvoiceVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchErrorBLNumberListRSQL(), param, velParam);
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
	 * Invoice 기발행 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchAlreadyIssuedList(GeneralInvoiceVO genInvVo) throws DAOException {
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchAlreadyIssuedListRSQL(), param, velParam);
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
	 * FNS_INV_0088<br>
	 * B/L 대상 Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param VIECombineInvoiceVO[] vIECombineInvoiceVOs
	 * @return List<VIECombineInvoiceVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<VIECombineInvoiceVO> searchVIECombineTargetBLNoList(VIECombineInvoiceVO[] vIECombineInvoiceVOs) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<VIECombineInvoiceVO> list = null;
		List<String> blNo = new ArrayList();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			for(int i=0; i<vIECombineInvoiceVOs.length; i++){
				if(vIECombineInvoiceVOs[i].getIbflag().equals("I")) {
					blNo.add(vIECombineInvoiceVOs[i].getBlNo());
				}
			}  
			velParam.put("bl_no", blNo);
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIECombineTargetBLNoListRSQL(), null, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VIECombineInvoiceVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Sequence 에서 nextval 조회 <br>
	 * 
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchKORInvoiceNumber(String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		String invSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchKORInvoiceNumberRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	invSeq = dbRowset.getString("inv_seq");
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invSeq;
	}
	
	/**
	 * Invoice Number를 채번한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String ofcCd
	 * @param String userId
	 * @param String autoInvIssFlg
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchInvoiceMaxSequence(String ofcCd, String userId, String autoInvIssFlg) throws DAOException {
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
			mapVO.put("auto_inv_iss_flg", autoInvIssFlg);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssMaxSeqRSQL(), param, velParam);
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
	public void addInvoiceIssueFilter(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			//log.info("########## issMain.getSendFlag() : "+issMainVO.getSendFlag());
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if(invIssVO != null){
				String invIssTpCd = invIssVO.getInvIssTpCd();
				if(invIssVO.getInvDupFlg().equals("Y")){
					sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlDupFlgCSQL(), param, velParam);
				}else if(invIssVO.getInvDupFlg().equals("N")){
					if(invIssTpCd.equals("E")){
						sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlECSQL(), param, velParam);
					}else if(invIssTpCd.equals("S")){
						sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvIssDtlCSQL(), param, velParam);
					}
				}	
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
		List<String> list = new ArrayList<String>();
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
			//	dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssInvNoForDupRSQL(), param, velParam);
			//}else if(invIssVO.getInvDupFlg().equals("N")){
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssInvNoRSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssWrkChkRSQL(), param, velParam);
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
		//DBRowSet dbRowset = null;
		//String wrkCnt = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			//dbRowset = 
			new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssNextValRSQL(), param, velParam);

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
		List<String> list = new ArrayList<String>();
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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOInvIssIfNoRSQL(), param, velParam);
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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSetupOfficeVORSQL(), param, velParam);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
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
	 * 베트남 지역의 Re Invoice 발행시 적용 환율을 구한다.<br>
	 * 
	 * @param VIEDailyExrateVO vieDailyExrateVO
	 * @return String
	 * @exception DAOException,Exception
	 */
	public String searchVIEDailyExrateMaxToDt(VIEDailyExrateVO vIEDailyExrateVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String xchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vIEDailyExrateVO != null){
				Map<String, String> mapVO = vIEDailyExrateVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	xchRt = dbRowset.getString("xch_rt");
	    	}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return xchRt;
	}	
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBlNo(String blNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String bkgNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOCPRTSearchBkgNoRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	bkgNo = dbRowset.getString("bkg_no");
	    	}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchSeverIdRSQL(), param, velParam);
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
	 * FNS_INV_0036<br>
	 * Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select<br>
	 * 
	 * @param GeneralInvoiceVO sinInvVo
	 * @return String
	 * @exception DAOException,Exception
	 */
	public String searchVIEIssueTargetCheckCharge(GeneralInvoiceVO sinInvVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String chgCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sinInvVo != null){
				Map<String, String> mapVO = sinInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOVIEIssueTargetCheckChargeRSQL(), param, velParam);
			if(dbRowset.next()) {
				chgCd = dbRowset.getString(1);
	    	}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chgCd;
	}
	
	
	// [CHM-201111084] 베트남 지역 인보이스 로직 변경 요청건
	/**
	 * FNS_INV_0036<br>
	 * Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select<br>
	 * 
	 * @param GeneralInvoiceVO sinInvVo
	 * @return List<String>
	 * @exception DAOException,Exception
	 */
	public List<String> searchVIEVATCharge (GeneralInvoiceVO sinInvVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;

		List<String> list = new ArrayList<String>();
		String Value = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sinInvVo != null){
				Map<String, String> mapVO = sinInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchVIEVATChargeRSQL(), param, velParam);
			while (dbRowset.next()) {
				Value = dbRowset.getString("vat_exist");
				list.add(Value);
				Value = dbRowset.getString("chg_cd");
				list.add(Value);
				Value = dbRowset.getString("chg_cd_iss");
				list.add(Value);
			}

		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * FNS_INV_0036<br>
	 * Re Issue시 Invoice Main, Invoice Charge 테이블에서 INV TYPE  별 charge 조건으로 Select<br>
	 * 
	 * @param String inv_no
	 * @return string xchRt
	 * @exception DAOException,Exception
	 */
	public String searchVIEDailyExrateForReIssue(String inv_no) throws DAOException,Exception {

		DBRowSet dbRowset = null;
		String xchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inv_no != null && !inv_no.equals("")){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", inv_no);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchVIEDailyExrateForReIssueRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	xchRt = dbRowset.getString("xch_rt");
	    	}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return xchRt;
	}
	
	/**
     * INV_EDI_GLOVIS_HDR 테이블 데이터를 갱신한다.<br>
     * 
     * @param InvArIssSndVO invArIssSndVO
     * @return int 
     * @exception DAOException
     */                  
    public int modifyInvArIssSnd(InvArIssSndVO invArIssSndVO ) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	int result = 0;
    	try {
    		
    		if (invArIssSndVO !=null){
    			Map<String, String> mapVO = invArIssSndVO.getColumnValues();
    			
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			
    			SQLExecuter sqlExe = new SQLExecuter("");
    			result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOmodifyInvArIssSndUSQL(), param, velParam);
    			log.error(">Eur Email Server EDI Message NO>>>>>>>>>>>>>>>>>>"+result);
    			if(result == Statement.EXECUTE_FAILED)
    				throw new DAOException("Fail to insert SQL");
    		}
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}		
    	return result;
    }
    
    
    /**
     * @param String workNo
     * @return int
     * @throws DAOException
     */
    public int checkInvoiceIssueFilterForSysClear(String workNo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();

    	DBRowSet dbRowset = null;
    	
    	int result = 0;
    	try {
    		
    		param.put("wrk_no",workNo);
    		
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new InvoiceIssueDBDAOcheckInvoiceIssueFilterForSysClearRSQL(), param, null);
			
			if (dbRowset.next()) {
				result = Integer.parseInt(dbRowset.getString("CNT"));
			}
			
			
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}	

    	return result;
	}
    
    /**
     * @param String workNo
     * @throws DAOException
     * @throws Exception
     */
    public void removeInvArIssSndForSysClear(String workNo) throws DAOException,Exception {
		
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			param.put("wrk_no", workNo);

		    sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOremoveInvArIssSndForSysClearDSQL(), param, null);
						
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
     * @param String workNo
     * @throws DAOException
     * @throws Exception
     */
    public void removeInvArIssForSysClear(String workNo) throws DAOException,Exception {
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	try {
    		SQLExecuter sqlExe = new SQLExecuter(dataSource);
    		
    		param.put("wrk_no", workNo);
    		
    		sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOremoveInvArIssForSysClearDSQL(), param, null);
    		
    	} catch(SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex) {
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }

    
    /**
     * @param String workNo
     * @throws DAOException
     * @throws Exception
     */
    public void removeInvArIssDtlForSysClear(String workNo) throws DAOException,Exception {
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	try {
    		SQLExecuter sqlExe = new SQLExecuter(dataSource);
    		
    		param.put("wrk_no", workNo);
    		
    		sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOremoveInvArIssDtlForSysClearDSQL(), param, null);
    		
    	} catch(SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex) {
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }
    
    
    /**
     * @param String workNo
     * @throws DAOException
     * @throws Exception
     */
    public void removeInvoiceIssueFilterForSysClear(String workNo) throws DAOException,Exception {
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	try {
    		SQLExecuter sqlExe = new SQLExecuter(dataSource);
    		
    		param.put("wrk_no", workNo);
    		
    		sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOremoveInvoiceIssueFilterForSysClearDSQL(), param, null);
    		
    	} catch(SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex) {
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }
    
    /**
     * @param String workNo
     * @param String arOfcCd
     * @throws DAOException
     * @throws Exception
     */
    public void modifySpndVatRgstSeq(String workNo, String arOfcCd) throws DAOException,Exception {
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	try {
    		SQLExecuter sqlExe = new SQLExecuter(dataSource);
    		
    		param.put("wrk_no", workNo);
    		param.put("ar_ofc_cd", arOfcCd);
    		
    		sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifySpndVatRgstSeqUSQL(), param, null);
    		
    	} catch(SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex) {
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }


    /**
     * @param vo
     * @return
     * @throws DAOException
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<InvArEmlCustRgstVO> searchEmlCustRgst(InvArEmlCustRgstVO vo) throws DAOException, Exception{
    	DBRowSet dbRowset = null;
    	List<InvArEmlCustRgstVO> list = null;
    	
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try {
    		if(vo != null){
    			Map<String, String> mapVO = vo.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowset = (new SQLExecuter(dataSource)).executeQuery(new InvoiceIssueDBDAOInvArEmlCustRgstRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArEmlCustRgstVO.class);
    	}catch(SQLException se){
    		log.error(se.getMessage(), se);
    		throw new DAOException((new ErrorHandler(se)).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(), ex);
    		throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
    	}
    	return list;
    }
    

    /**
     * @param invArEmlCustRgstVOs
     * @throws DAOException
     * @throws Exception
     */
    public void createEmlCustRgst(List<InvArEmlCustRgstVO> invArEmlCustRgstVOs)throws DAOException, Exception{
    	try {
    		SQLExecuter sqlExe = new SQLExecuter(dataSource);
    		int insCnt[] = (int[])null;
    		if(invArEmlCustRgstVOs.size() > 0){
    			insCnt = sqlExe.executeBatch(new InvoiceIssueDBDAOInvArEmlCustRgstCSQL(), invArEmlCustRgstVOs, null);
    			for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
    		}
    	}catch(SQLException se){
    		log.error(se.getMessage(), se);
    		throw new DAOException((new ErrorHandler(se)).getMessage(), se);
    	}catch(Exception ex){
    		log.error(ex.getMessage(), ex);
    		throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
    	}
    }

	/**
	 * @param invArEmlCustRgstVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEmlCustRgst(List<InvArEmlCustRgstVO> invArEmlCustRgstVOs)throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = (int[]) null;
			if (invArEmlCustRgstVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new InvoiceIssueDBDAOInvArEmlCustRgstUSQL(),invArEmlCustRgstVOs, null);
    			for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}

	/**
	 * @param invArEmlCustRgstVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeEmlCustRgst(List<InvArEmlCustRgstVO> invArEmlCustRgstVOs)throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = (int[]) null;
			if (invArEmlCustRgstVOs.size() > 0) {
				insCnt = sqlExe.executeBatch(new InvoiceIssueDBDAOInvArEmlCustRgstDSQL(),invArEmlCustRgstVOs, null);
    			for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}

	/**
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchOfcOpt(String ofcCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
		String ofcOpt = "";
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			param.put("ar_ofc_cd", ofcCd);
			dbRowset = sqlExe.executeQuery(new InvoiceIssueDBDAOSearchInvEmlSplitFlgRSQL(), param,null);
			if (dbRowset.next()) {
				ofcOpt = dbRowset.getString("inv_eml_split_flg");
				ofcOpt = "Y".equals(ofcOpt) ? "Sepatate" : "Merge";
			}
			return ofcOpt;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}

	/**
	 * @param invArSplitIssVO
	 * @param usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addInvoiceSplitIssue(InvArSplitIssVO invArSplitIssVO,String usrId) throws DAOException, Exception {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			if (invArSplitIssVO != null) {
				Map<String, String> mapVO = invArSplitIssVO.getColumnValues();
				param.putAll(mapVO);
				param.put("user_id", usrId);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate(new InvoiceIssueDBDAOaddInvoiceSplitIssueCSQL(), param,velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}

	/**
	 * @param invArSplitIssChgVO
	 * @param usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addInvoiceSplitIssueCharge(InvArSplitIssChgVO invArSplitIssChgVO, String usrId)throws DAOException, Exception {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			if (invArSplitIssChgVO != null) {
				Map<String, String> mapVO = invArSplitIssChgVO.getColumnValues();
				param.put("user_id", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			sqlExe.executeUpdate(new InvoiceIssueDBDAOaddInvoiceSplitIssueChargeCSQL(),param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}

	/**
	 * @param invArSplitIssVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchMaxSplitInvWorkNumber(InvArSplitIssVO invArSplitIssVO)throws DAOException, Exception {
		DBRowSet dbRowset = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
		String maxWrkNo = "";
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			Map<String,String> mapVO = invArSplitIssVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = sqlExe.executeQuery(new InvoiceIssueDBDAOsearchMaxSplitInvWorkNumberRSQL(),param, velParam);
			if (dbRowset.next())
				maxWrkNo = dbRowset.getString("inv_split_iss_wrk_no");
			return maxWrkNo;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
	}
	
	/**
	 * Invoice No를 입력받은 후 유효한 Invoice No를 Return. <br>
	 * 
	 * @param PrintInvoiceVO prtInvoiceVo
	 * @return List<InvArIssVO>
	 * @exception DAOException
	 */
	public List<InvIssMainVO> searchPrintSplitInvoice(PrintInvoiceVO prtInvoiceVo) throws DAOException {
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchPrintSplitInvoiceRSQL(), param, velParam);
						
			//log.info("########## dbRowset.getRowCount() : "+dbRowset.getRowCount());
			while(dbRowset.next()) {	
				invIssMainVO = new InvIssMainVO();
				invIssMainVO.setInvNo(dbRowset.getString("inv_no"));
				invIssMainVO.setInvIssCmbFlg(dbRowset.getString("inv_iss_cmb_flg"));
				invIssMainVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
				invIssMainVO.setVnInvPayMzdCd(dbRowset.getString("vn_inv_pay_mzd_cd"));
				invIssMainVO.setIfNo(dbRowset.getString("if_no"));
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
	 * Issue 대상 Bkg No, Sail Arr Dt, Due Dt 를 가져온다 <br>
	 * 
	 * @author Choi Do Soon
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<NYCInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<NYCInvoiceVO> searchNYCIssueTarget(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		
		DBRowSet dbRowset = null;
		List<NYCInvoiceVO> list = new ArrayList<NYCInvoiceVO>();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchNYCIssueTargetRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NYCInvoiceVO .class);
			
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
	 * NYC Issue의 Issue event에 대한 main부분 insert 이벤트 처리<br>
	 * 
	 * @author Dosoon Choi
	 * @param InvArUsaIssSndVO invArUsaIssSndVO
	 * @exception EventException
	 */	
	public void addNYCIssueMain (InvArUsaIssSndVO invArUsaIssSndVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(invArUsaIssSndVO != null){
				Map<String, String> mapVO = invArUsaIssSndVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOInvArUsaIssSndCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * * VLCSC  MIV 존재여부 Check 
     * VLCSC의 경우 Auto Invoice Issue는 MIV가 존재하는 BL만 대상으로함
	 * 
     * @param arOfcCd
     * @param blSrcNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchChkAutoInv(String arOfcCd, String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		String chkAutoInvFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(arOfcCd != null && blSrcNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("ar_ofc_cd", arOfcCd);
				mapVO.put("bl_src_no", blSrcNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchChkAutoInvRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		chkAutoInvFlg = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return chkAutoInvFlg;
	}	
	
	/**
     * Auto Invoice 전송을 위해 AR_IF_NO로 Customer Email 조회<br>
	 * @author JungJin Park
     * @param arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchAutoInvEmail(String arIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		String custEml = null;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearchAutoInvEmailRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		custEml = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return custEml;
	}	
	
	/**
	 * Invoice 기발행 Data를 조회한다. <br>
	 * 
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> search3rdCheckList(GeneralInvoiceVO genInvVo) throws DAOException {
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOsearch3rdCheckListRSQL(), param, velParam);
			while(dbRowset.next()) {						
				list.add(dbRowset.getString("BL_NOS"));
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
	 * INDIA Invoice Number를 채번한다. <br>
	 * 
	 * @author Sung Yong Park
	 * @param String ofcCd
	 * @param String indIssTpCd
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchINDInvoiceMaxSequence(String ofcCd, String indIssTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("ind_iss_tp_cd", indIssTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOINDInvIssMaxSeqRSQL(), param, velParam);
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
	 * INDIA Invoice Number채번 Table의 max_seq 값을 변경한다. <br>
	 * 
	 * @param String invPfxCd
	 * @param String invMaxSeq
	 * @param String invSeq
	 * @param String userId
	 * @param String ofcCd
	 * @exception DAOException
	 */
	public void modifyINDInvMaxSeq(String invPfxCd, String invMaxSeq, String invSeq, String userId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_pfx_cd", invPfxCd);
			if (invMaxSeq.equals("0")) {
				mapVO.put("inv_max_seq", invSeq);
			}else{
				mapVO.put("inv_max_seq", invMaxSeq);
			}			
			mapVO.put("inv_seq", invSeq);
			mapVO.put("user_id", userId);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
			if (invMaxSeq.equals("0") && !invSeq.equals("0")) {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifyINDInvoiceNumberCSQL(), param, velParam);
			} else {
				sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOINDInvIssModifyInvNoUSQL(), param, velParam);
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
     * @param String arOfcCd
     * @param String blSrcNo
     * @return int
     * @throws DAOException
     */
    public int searchTaxInvIssCnt(String arOfcCd, String blSrcNo) throws DAOException {
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();

    	DBRowSet dbRowset = null;
    	
    	int result = 0;
    	try {
    		
    		param.put("ar_ofc_cd",arOfcCd);
    		param.put("bl_src_no",blSrcNo);
    		
			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchTaxInvIssCntRSQL(), param, null);
			
			if (dbRowset.next()) {
				result = Integer.parseInt(dbRowset.getString("CNT"));
			}
			
			
    	} catch (SQLException se) {
    		log.error(se.getMessage(),se);
    		throw new DAOException(new ErrorHandler(se).getMessage(), se);
    	} catch(Exception ex){
    		log.error(ex.getMessage(),ex);
    		throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    	}	

    	return result;
	}
    
    /**
	 * INDIA Invoice Number를 채번한다. <br>
	 * 
	 * @author Sung Yong Park
	 * @param String ofcCd
	 * @param String indIssTpCd
	 * @return InvoiceNumberVO
	 * @exception DAOException
	 */
	public InvoiceNumberVO searchINDInvoiceNumber(String ofcCd, String indIssTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		InvoiceNumberVO invNumVo = new InvoiceNumberVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("ind_iss_tp_cd", indIssTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new InvoiceIssueDBDAOSearchINDInvoiceNumberRSQL(), param, velParam);
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
	 * GST Ratio 를 update 한다. <br>
	 * 
	 * @param String invNo
	 * @param String invSeq
	 * @param String arIfNo
	 * @exception DAOException
	 */
	public void modifyIDAGstRto(String invNo, String invSeq, String arIfNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			mapVO.put("inv_seq", invSeq);
			mapVO.put("ar_if_no", arIfNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifyIDAGstRtoUSQL(), param, velParam);			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * GST Amount 를 update 한다. <br>
	 * 
	 * @param String invNo
	 * @param String invSeq
	 * @exception DAOException
	 */
	public void modifyIDAGstAmt(String invNo, String invSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			mapVO.put("inv_seq", invSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifyIDAGstAmtUSQL(), param, velParam);			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * 인도지역 Split Flag를 update 한다. <br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	public void modifyIDASplitFlg(String arOfcCd, String blSrcNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOModifyIDASplitFlgUSQL(), param, velParam);			
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
}
