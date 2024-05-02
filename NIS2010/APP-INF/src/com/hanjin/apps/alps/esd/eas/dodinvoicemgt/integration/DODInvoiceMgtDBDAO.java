/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :DODInvoiceMgtDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history 
*@LastModifyDate : 2013. 9. 11.
*@LastModifier : KIM HYUN HWA
*@LastVersion : 
* 2013. 9. 11. KIM HYUN HWA
=========================================================*/


package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic.DODInvoiceMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionParmVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionSumVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceEdiInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DodArIfMnVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EASEdiSndLogDtlVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrCntcPntVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchDODInvoiceListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DOD Invoice management 에 대한 DB 처리를 담당<br>
 * @author KIM HYUN HWA
 * @see DODInvoiceMgtBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class DODInvoiceMgtDBDAO  extends DBDAOSupport{

	/**
	 * BKG Container List를 조회한다.
	 * 
	 * @param inBlNo
	 * @param sessionOfcCd
	 * @return List<SearchBKGCntrListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchBKGCntrListVO> searchBKGCntrList(String inBlNo, String sessionOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBKGCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.debug("\n ==============================[DBDAO] sessionOfcCd:"+sessionOfcCd);
			param.put("in_bl_no", inBlNo);
			velParam.put("in_bl_no", inBlNo);
			param.put("in_session_ofc_cd", sessionOfcCd);
			velParam.put("in_session_ofc_cd", sessionOfcCd);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchBKGCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBKGCntrListVO .class);
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
	 * ESD_EAS_0100 Payer정보를 조회한다.<br>
	 * 
	 * @param String inPayerCd
	 * @return DODPayrInfoVO
	 * @throws DAOException
	 */
	public DODPayrInfoVO searchPayerInfo(String inPayerCd) throws DAOException {
		DBRowSet dbRowset = null;
		DODPayrInfoVO dODPayrInfoVO = new DODPayrInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
      	 
		try {
			param.put("payer_cd", inPayerCd);
			velParam.put("payer_cd", inPayerCd);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAODODPayrInfoVORSQL(),param,velParam);
			if(dbRowset.next()){
				dODPayrInfoVO.setCustCd(dbRowset.getString("cust_cd"));
				dODPayrInfoVO.setCustNm(dbRowset.getString("cust_nm"));
           }  			 
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return dODPayrInfoVO;		
	}	 
	 
	/**
	 * ESD_EAS_0100 Payer정보를 조회한다.<br>
	 * 
	 * @param String inPayerCd
	 * @param String inCustRgstNo
	 * @return DODPayrInfoVO
	 * @throws DAOException
	 */
	public DODPayrInfoVO searchPayerInfo(String inPayerCd, String inCustRgstNo) throws DAOException { 
		DBRowSet dbRowset = null;
		DODPayrInfoVO dODPayrInfoVO = new DODPayrInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
      	 
		try {
			param.put("payer_cd", inPayerCd);
			velParam.put("payer_cd", inPayerCd);
			
			param.put("cust_rgst_no", inCustRgstNo);  
			velParam.put("cust_rgst_no", inCustRgstNo);			
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAODODPayrInfoVORSQL(),param,velParam);
			if(dbRowset.next()){
				dODPayrInfoVO.setCustCd(dbRowset.getString("cust_cd"));
				dODPayrInfoVO.setCustNm(dbRowset.getString("cust_nm"));
				
				dODPayrInfoVO.setCustRgstNo(dbRowset.getString("cust_rgst_no")); 
           }  			 
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return dODPayrInfoVO;		
	}
	 
	/**
	 * INV No 추출<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchEasDodInvSeq(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String dodInvNo = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchEasDodInvSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				dodInvNo = dbRowset.getString("dod_inv_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dodInvNo;
	}
	
	/**
	 * (KOR) DOD Invoice Issue - Add Main<br>
	 * 
	 * @param DODInvoiceMainVO dodInvoiceMainVO
	 * @throws DAOException 
	 */
	public void addDODInvoiceMain(DODInvoiceMainVO dodInvoiceMainVO) throws EventException, DAOException {
		try	{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			if(dodInvoiceMainVO != null){
				Map<String, String> mapVO = dodInvoiceMainVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddDODInvoiceMainCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}			
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * (KOR) DOD Invoice Issue - Add Detail<br>
	 * 
	 * @param List<DODInvoiceDetailVO> insModels
	 * @throws DAOException
	 */
	public void addDODInvoiceDetail(List<DODInvoiceDetailVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DODInvoiceMgtDBDAOAddDODInvoiceDetailCSQL(), insModels,null);
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
	 * ESD_EAS_0100 Attention 정보를 조회 합니다.<br>
	 * 
	 * @param EasAttentionVO attendtionVO
	 * @return List<EasAttentionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasAttentionVO> searchAttention(EasAttentionVO attendtionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasAttentionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			if(attendtionVO != null){
				Map<String, String> mapVO = attendtionVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchAttentionRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasAttentionVO .class);
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
	 * ESD_EAS_0100 Customer 정보를 조회 합니다.<br>
	 * 
	 * @param EasAttentionVO attendtionVO
	 * @return List<AttentionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasAttentionVO> searchAttentionOfCustomer(EasAttentionVO attendtionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EasAttentionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(attendtionVO != null){
				Map<String, String> mapVO = attendtionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchAttentionOfCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasAttentionVO .class);
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
	 * ESD_EAS_0102 : 조회<br>
	 * DOD Invoice list를 조회합니다.<br>
	 * 
	 * @param SearchDODInvoiceListInputVO searchDODInvoiceListInputVO
	 * @return List<SearchDODInvoiceListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DODInvoiceListVO> searchDODInvoiceList(SearchDODInvoiceListInputVO searchDODInvoiceListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DODInvoiceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchDODInvoiceListInputVO != null){
				Map<String, String> mapVO = searchDODInvoiceListInputVO .getColumnValues();
				 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchDODInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DODInvoiceListVO .class);
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
	 * ESD_EAS_0102 : Cancel<br>
	 * DOD Invoice 를 Cancel합니다.<br>
	 * 
	 * @param List<DODInvoiceListVO> updModels
	 * @throws DAOException
	 */
	public void cancelDODInvoice(List<DODInvoiceListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DODInvoiceMgtDBDAOModifyCancelDODInvoiceUSQL(), updModels, null, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param String custCd
	 * @param String custGubun
	 * @return List<EasPayrCntcPntVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrCntcPntVO> searchPayerContactPoint(String custCd, String custGubun) throws DAOException, Exception {
        DBRowSet dbRowset = null;
        List<EasPayrCntcPntVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
        try {

			param.put("s_cust_cd", custCd);
			param.put("s_cust_gubun", custGubun);
			
			velParam.put("s_cust_cd", custCd);
			velParam.put("s_cust_gubun", custGubun);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerContactPointRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrCntcPntVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
		
	}
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param String custCd
	 * @param String custGubun
	 * @return List<EasPayrCntcPntVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrCntcPntVO> searchPayerContactPointMdm( String custCd, String custGubun) throws DAOException, Exception {
        DBRowSet dbRowset = null;
        List<EasPayrCntcPntVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
        try {

			param.put("s_cust_cd", custCd);
			param.put("s_cust_gubun", custGubun);
			
			velParam.put("s_cust_cd", custCd);
			velParam.put("s_cust_gubun", custGubun);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerContactPointMdmRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrCntcPntVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
		
	}		
	
	/**
	 * ESD_EAS_0103 Payer 정보를 조회한다.
	 * @param String sCustCd
	 * @param String payrYn
	 * @param String sCustGubun
	 * @return EasPayrInfoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public EasPayrInfoVO searchPayerInformation(String sCustCd, String payrYn, String sCustGubun) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		EasPayrInfoVO easPayInfoVO = new EasPayrInfoVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
      	 
		try {

			param.put("s_cust_cd"		, sCustCd);
			param.put("payr_yn"			, payrYn);
			param.put("s_cust_gubun"	, sCustGubun);
			
			velParam.put("s_cust_cd"	, sCustCd);
			velParam.put("payr_yn"		, payrYn);
			velParam.put("s_cust_gubun"	, sCustGubun);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerInformationRSQL(),param,velParam);
			if(dbRowset.next()){
				 

				easPayInfoVO.setCustCd(dbRowset.getString("cust_cd"));
				easPayInfoVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				easPayInfoVO.setCustSeq(dbRowset.getString("cust_seq"));
				easPayInfoVO.setCustRgstNo(dbRowset.getString("cust_rgst_no"));
				easPayInfoVO.setIssDivNm(dbRowset.getString("iss_div_nm"));
				easPayInfoVO.setPayrNm(dbRowset.getString("payr_nm"));
				easPayInfoVO.setCustAddr(dbRowset.getString("cust_addr"));
				easPayInfoVO.setCntcPntNm(dbRowset.getString("cntc_pnt_nm"));
				easPayInfoVO.setCntcPntPhnNo(dbRowset.getString("cntc_pnt_phn_no"));
				easPayInfoVO.setCntcPntFaxNo(dbRowset.getString("cntc_pnt_fax_no"));
				easPayInfoVO.setN1stEml(dbRowset.getString("n1st_eml"));
           }  			 
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return easPayInfoVO;		
	}	

	
	/**
	 * ESD_EAS_0103 Payer Name 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerNameRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
			
	}
	/**
	 * ESD_EAS_0103 Payer Address 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerAddressRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * ESD_EAS_0103 Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerContactPointNameRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * ESD_EAS_0103 Payer Phone No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerPhoneNoRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * ESD_EAS_0103 Payer Fax No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerFaxNoRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * ESD_EAS_0103 Payer Email 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<EasPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EasPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<EasPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchPayerEmailRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EasPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	
	/**
	 * ESD_EAS_0103 Payer Info 존재여부를 조회한다.<br>
	 * 
	 * @param String sCustCd
	 * @param String vndrFlg
	 * @return String
	 * @throws DAOException
	 */
	public String checkPayerInfo(String  sCustCd, String vndrFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String payr_yn = "";
		try {

			param.put("s_cust_cd"	, sCustCd);
			velParam.put("s_cust_cd", sCustCd);
			velParam.put("s_vndr_flg", vndrFlg);
		
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOCheckPayerInfoRSQL(),param,velParam);
            if(dbRowset.next()){
            	payr_yn = dbRowset.getString("payr_yn");
            	
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return payr_yn;
	}
	
	/**
	 * ESD_EAS_0103 PAYER INFO 정보를 [INSERT] 합니다.<br>
	 * 
	 * @param easPayrInfoVO EasPayrInfoVO
	 * @throws DAOException
	 */
	public void addPayerInfomation(EasPayrInfoVO easPayrInfoVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = easPayrInfoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddPayerInfomationCSQL(), param, velParam);
            
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
	 * ESD_EAS_0103 PAYER INFO 정보를 [MODIFY] 합니다.<br>
	 * 
	 * @param easPayrInfoVO EasPayrInfoVO
	 * @throws DAOException
	 */
	public void modifyPayerInfomation(EasPayrInfoVO easPayrInfoVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = easPayrInfoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOModifyPayerInfomationUSQL(), param, velParam);
            
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
	 * ESD_EAS_0103 Payer Contact Point 존재여부를 조회한다.<br>
	 * 
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String sCustCntcPntSeq
	 * @param String sVndrFlg
	 * @return String
	 * @throws DAOException
	 */
	public String checkPayerContactPoint(String sOfcCd, String  sCustCd, String sCustCntcPntSeq, String sVndrFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String payr_cont_yn = "";
		try {
			param.put("s_ofc_cd"			, sOfcCd);
			param.put("s_cust_cd"			, sCustCd);
			param.put("s_cust_cntc_pnt_seq"	, sCustCntcPntSeq);
			velParam.put("s_ofc_cd"				, sOfcCd);
			velParam.put("s_cust_cd"			, sCustCd);
			velParam.put("s_cust_cntc_pnt_seq"	, sCustCntcPntSeq);
			velParam.put("s_vndr_flg"	, sVndrFlg);
		
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOCheckPayerContactPointRSQL(),param,velParam);
            if(dbRowset.next()){
            	payr_cont_yn = dbRowset.getString("payr_cont_yn");
            	
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return payr_cont_yn;
	}
	/**
	 * ESD_EAS_0103 PAYER CONTACT POINT 정보를 [INSERT] 합니다.<br>
	 * 
	 * @param EasPayrCntcPntVO easPayrCntcPntVO
	 * @throws DAOException
	 */
	public void addPayerContactPoint(EasPayrCntcPntVO easPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = easPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddPayerContactPointCSQL(), param, velParam);
            
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
	 * ESD_EAS_0103 PAYER CONTACT POINT 정보를 [MODIFY] 합니다.<br>
	 * 
	 * @param EasPayrCntcPntVO easPayrCntcPntVO
	 * @throws DAOException
	 */
	public void modifyPayerContactPoint(EasPayrCntcPntVO easPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = easPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOModifyPayerContactPointUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * ESD_EAS_0103 PAYER CONTACT POINT 정보를 [DELETE] 합니다.<br>
	 * 
	 * @param EasPayrCntcPntVO easPayrCntcPntVO
	 * @throws DAOException
	 */
	public void removePayerContactPoint(EasPayrCntcPntVO easPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = easPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAORemovePayerContactPointDSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to remove SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * Invoice 자료의 AR Interface Main 정보를 조회합니다.<br>
	 *
	 * @param  String invoiceNo
	 * @param  String bkgNo
	 * @param  String ofcCd
	 * @param  String creUsrId 
	 * @return InvArIfMnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public InvArIfMnVO searchARInterfaceInvoiceMain(String invoiceNo,  String bkgNo , String ofcCd, String creUsrId) throws DAOException {

		DBRowSet dbRowset = null;
		InvArIfMnVO info = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				param.put("bkg_no", bkgNo);
				param.put("dod_inv_no", invoiceNo);
				param.put("ofc_cd", ofcCd);
				param.put("cre_usr_id", creUsrId);
				velParam.put("bkg_no", bkgNo);
				velParam.put("dod_inv_no", invoiceNo);


			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL(), param, velParam);
			List<InvArIfMnVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);
			info = list.get(0);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return info;
	}

	/**
	 * Invoice 자료의 AR Interface Charge 정보를 조회합니다.<br>
	 *
	 * @param  String invoiceNo
	 * @param  String ofcCd
	 * @param  String creUsrId  
	 * @return List<InvArIfChgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchARInterfaceChargeList(String invoiceNo , String ofcCd, String creUsrId) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("dod_inv_no", invoiceNo);
			param.put("ofc_cd", ofcCd);
			param.put("cre_usr_id", creUsrId);



			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchARInterfaceChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
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
	 * Invoice 자료의 AR Interface Container 정보를 조회합니다.<br>
	 *
	 * @param  String invoiceNo
	 * @param  String ofcCd
	 * @param  String creUsrId 
	 * @return List<InvArIfCntrVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<InvArIfCntrVO> searchARInterfaceContainerList(String invoiceNo , String ofcCd, String creUsrId) throws DAOException {

		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("dod_inv_no", invoiceNo);
			param.put("ofc_cd", ofcCd);
			param.put("cre_usr_id", creUsrId);

			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchARInterfaceContainerListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
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
	     * ARIF를 UPDATE한다.
	     * @param String arIfNo
	     * @param String ofcCd
	     * @param String arUsrId
	     * @param String invoiceNo
	     * @throws DAOException
	     */
	    public void modifyARInterfaceInfo(String arIfNo, String ofcCd, String arUsrId, String invoiceNo) throws DAOException {
			//query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        try {
	        	param.put("ar_if_no", arIfNo);
	        	param.put("ofc_cd",ofcCd);
	        	param.put("ar_usr_id", arUsrId);
	        	param.put("invoice_no", invoiceNo);
	            
	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = 0;
	            result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOModifyARInterfaceUSQL(), param, null);
	            
	            if(result == Statement.EXECUTE_FAILED)
	                throw new DAOException("Fail to update SQL");
	            
	        } catch (SQLException se) {
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	    }

	/**
	 * DOD Invoice Collection List를 조회합니다.<br>
	 *
	 * @param  DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionVO>
	 * @throws DAOException
	 */	    
	public List<DODCollectionVO> searchDODInvoiceCollectionList(DODCollectionParmVO dodCollectionParmVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<DODCollectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
//			param.put("dod_inv_no", invoiceNo);
//			param.put("ofc_cd", ofcCd);
//			param.put("cre_usr_id", creUsrId);

            Map<String, String> mapVO = dodCollectionParmVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchDODInvoiceCollectionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DODCollectionVO .class);
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
	 * DOD Invoice Collection Summary를 조회합니다.<br>
	 *
	 * @param  DODCollectionParmVO dodCollectionParmVO
	 * @return List<DODCollectionSumVO>
	 * @throws DAOException
	 */		
	public List<DODCollectionSumVO> searchDODInvoiceCollectionSummary(DODCollectionParmVO dodCollectionParmVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<DODCollectionSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
//			param.put("dod_inv_no", invoiceNo);
//			param.put("ofc_cd", ofcCd);
//			param.put("cre_usr_id", creUsrId);

            Map<String, String> mapVO = dodCollectionParmVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchDODInvoiceCollectionSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DODCollectionSumVO .class);
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
		 * DOD Invoice  Credit Note Main 생성<br>
		 * 
		 * @param String dodInvNo
		 * @param String newDodInvNo
         * @param String creUsrId
         * @param String ofcCd
		 * @throws DAOException 
		 */
		public void addCreditNoteMain(String dodInvNo, String newDodInvNo,String creUsrId, String ofcCd) throws EventException, DAOException {
			try	{
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				int result = 0;
				if(dodInvNo != null){
				
					param.put("new_inv_no", newDodInvNo);
					param.put("old_inv_no", dodInvNo);
		        	param.put("ofc_cd",ofcCd);
		        	param.put("cre_usr_id", creUsrId);
						
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddCreditNoteMainCSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Insert SQL");
				}			
			}catch (SQLException se){
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch (Exception ex){
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}  
		
		/**
		 * DOD Invoice  Credit Note Detail 생성<br>
		 * 
		 * @param String dodInvNo
		 * @param String newDodInvNo
         * @param String creUsrId
         * @param String ofcCd
		 * @throws DAOException 
		 */
		public void addCreditNoteDetail(String dodInvNo, String newDodInvNo,String creUsrId, String ofcCd) throws EventException, DAOException {
			try	{
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				int result = 0;
				if(dodInvNo != null){
				
					param.put("new_inv_no", newDodInvNo);
					param.put("old_inv_no", dodInvNo);
		        	param.put("ofc_cd",ofcCd);
		        	param.put("cre_usr_id", creUsrId);
						
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddCreditNoteDetailCSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to Insert SQL");
				}			
			}catch (SQLException se){
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch (Exception ex){
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}

		/**
		 * @param String invoice_no
		 * @param String bkg_no
		 * @param String ofc_cd
		 * @param String usr_id
		 * @return
		 * @throws DAOException
		 */
		public DodArIfMnVO checkAlreadyArIf(String invoice_no, String bkg_no,
				String ofc_cd, String usr_id) throws DAOException {

			DBRowSet dbRowset = null;
			DodArIfMnVO info = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("bkg_no", bkg_no);
				param.put("dod_inv_no", invoice_no);
				param.put("ofc_cd", ofc_cd);
				param.put("cre_usr_id", usr_id);
				velParam.put("bkg_no", bkg_no);
				velParam.put("dod_inv_no", invoice_no);


			dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchARInterfaceInvoiceMainRSQL(), param, velParam);
			List<DodArIfMnVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, DodArIfMnVO .class);
			info = list.get(0);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return info;
		}		
		
		
		/**
		 * EAS에서 사용하는 Flat File Header 생성 <br>
		 * @param String sndrId
		 * @param String rcvId
		 * @param String msgId
		 * @return String
		 * @throws DAOException
		 */
		public String searchEASEdiHeader(String sndrId, String rcvId, String msgId) throws DAOException {
			DBRowSet dbRowset = null;
			String strReturn = "";

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			log.debug("\n sndrId:"+sndrId+" rcvId:"+rcvId+" msgId:"+msgId);
			try {
				param.put("sndr_id", sndrId);
				param.put("rcv_id", rcvId);
				param.put("msg_id", msgId);

				velParam.put("sndr_id", sndrId);
				velParam.put("rcv_id", rcvId);
				velParam.put("msg_id", msgId);
//		        RPAD(NVL(TRIM(@[sndr_id]),' '),20,' ')||
//		        RPAD(NVL(TRIM(@[rcv_id]),' '),20,' ')||
//		        RPAD(NVL(TRIM(@[msg_id]),' '),10,' ')||				

				dbRowset = new SQLExecuter().executeQuery(new DODInvoiceMgtDBDAOSearchEASEdiHeaderRSQL(), param, velParam);
				if (dbRowset.next()) {
					strReturn = dbRowset.getString("str_flatfile");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}

			return strReturn;
		}		
		
		 
			/**
			 * EDI 전송용 데이타 서치<br>
			 * @param String dod_inv_no
			 * @return DODInvoiceEdiInfoVO
			 * @throws DAOException
			 */
			public DODInvoiceEdiInfoVO searchIssueEdiInfo(String dod_inv_no) throws DAOException {
				DBRowSet dbRowset = null;
				DODInvoiceEdiInfoVO sendInvoiceEdiVO = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				log.debug("\n dod_inv_no:"+dod_inv_no+"============================");
				try{
					if(dod_inv_no != null){
						param.put("dod_inv_no", dod_inv_no);
						velParam.put("dod_inv_no", dod_inv_no);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL(), param, velParam);
					List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DODInvoiceEdiInfoVO.class);
					
					if (list != null && list.size() > 0){
						sendInvoiceEdiVO = (DODInvoiceEdiInfoVO) list.get(0);
					}
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return sendInvoiceEdiVO;
			}	 		
			 
			/**
			 * [처리대상] 정보를 [행위] 합니다.<br>
			 * 
			 * @param  String cntr_tpsz_cd
			 * @return String
			 * @throws DAOException
			 */
			public String searchCntrSizeIso(String cntr_tpsz_cd) throws DAOException {
				DBRowSet dbRowset = null;
				String cntrSizeIso = "";
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(cntr_tpsz_cd != null){
						param.put("cntr_tpsz_cd", cntr_tpsz_cd);
						velParam.put("cntr_tpsz_cd", cntr_tpsz_cd);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchCntrSizeIsoRSQL(), param, velParam);
					
					if(dbRowset.next()){
						cntrSizeIso = dbRowset.getString("cntr_tpsz_iso_cd");
					}
					
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return cntrSizeIso;
			}	 
			

			/**
			 * EAS EDI 송신 log 저장 (송신 Detail)<Br>
			 * @param EASEdiSndLogDtlVO inputVO
			 * @throws DAOException
			 * @throws Exception
			 */
			public void addEASEdiSndLogDtl(EASEdiSndLogDtlVO inputVO) throws DAOException,Exception {

				//query parameter
		        Map<String, Object> param = new HashMap<String, Object>();
		        //velocity parameter
		        Map<String, Object> velParam = new HashMap<String, Object>();
		        
		        int result = 0;
		        
		        try {
		        	if(inputVO != null) {        		
			            Map<String, String> mapVO = inputVO.getColumnValues();    
			            param.putAll(mapVO);
			            velParam.putAll(mapVO);
		        	}
		            
		            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new DODInvoiceMgtDBDAOAddEASEdiSndLogDtlRSQL(), param, velParam);
		            if(result == Statement.EXECUTE_FAILED) {
		           		throw new DAOException(new ErrorHandler("EAS EDI",new String[]{}).getMessage());
		            }
		            
				} catch (SQLException se) {
					throw new DAOException(new ErrorHandler(se).getMessage(), se);
				} catch (Exception ex) {
					throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
				}

			}			
			
			
			/**
			 * EAS Invoice Main 정보를  search 한다.
			 * @param dodInvNo
			 * @return DODInvoiceMainVO
			 * @throws DAOException
			 */
			public DODInvoiceMainVO searchEASEdiHeader(String dodInvNo) throws DAOException {
				DBRowSet dbRowset = null;
				DODInvoiceMainVO dodInvoiceMainVO = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				log.debug("\n dod_inv_no:"+dodInvNo+"============================");
				try{
					if(dodInvNo != null){
						param.put("dod_inv_no", dodInvNo);
						velParam.put("dod_inv_no", dodInvNo);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchIssueEdiInfoRSQL(), param, velParam);
					List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DODInvoiceMainVO.class);
					
					if (list != null && list.size() > 0){
						dodInvoiceMainVO = (DODInvoiceMainVO) list.get(0);
					}
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return dodInvoiceMainVO;
			}					

			
			/**
			 * EAS Invoice Main 정보를  search 한다.
			 * @param dodInvNo
			 * @return DODInvoiceMainVO
			 * @throws DAOException
			 */
			public DODInvoiceMainVO searchDodInvoiceMain(String dodInvNo) throws DAOException {
				DBRowSet dbRowset = null;
				DODInvoiceMainVO dodInvoiceMainVO = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				log.debug("\n dod_inv_no:"+dodInvNo+"============================");
				try{
					if(dodInvNo != null){
						param.put("dod_inv_no", dodInvNo);
						velParam.put("dod_inv_no", dodInvNo);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOsearchDodInvoiceMainRSQL(), param, velParam);
					List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DODInvoiceMainVO.class);
					
					if (list != null && list.size() > 0){
						dodInvoiceMainVO = (DODInvoiceMainVO) list.get(0);
					}
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return dodInvoiceMainVO;
			}								
			
			
			/**
			 * EAS Invoice Detail 정보를  search 한다.
			 * @param dodInvNo
			 * @return List<DODInvoiceDetailVO>
			 * @throws DAOException
			 */
			public DODInvoiceDetailVO[] searchDodInvoiceDetail(String dodInvNo) throws DAOException {
				DBRowSet dbRowset = null;
				DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				log.debug("\n dod_inv_no:"+dodInvNo+"============================");
				try{
					if(dodInvNo != null){
						param.put("dod_inv_no", dodInvNo);
						velParam.put("dod_inv_no", dodInvNo);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOsearchDodInvoiceDetailRSQL(), param, velParam);
					log.debug("\n 1=============================================================");
					List<Object> list = RowSetUtil.rowSetToVOs(dbRowset, DODInvoiceDetailVO.class);

					log.debug("\n 2 list.size():"+list.size()+"=============================================================");
					if (list != null && list.size() > 0){
						DODInvoiceDetailVO[] dodInvoiceDetailVOsTemp = new DODInvoiceDetailVO[0];
						dodInvoiceDetailVOs=list.toArray(dodInvoiceDetailVOsTemp);//list.get(0);
//						dodInvoiceDetailVOs =  (DODInvoiceDetailVO[])list.toArray();//list.get(0);
					}
					
				}catch(SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return dodInvoiceDetailVOs;
			}

			/**
			 * Korea DOD Tariff List 정보를 조회합니다.<br>
			 *
			 * @param  String ofcCd
			 * @param  String polContiCd
			 * @param  String effDt  
			 * @return List<DODTariffVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<DODTariffVO> searchDODTariffList(String ofcCd , String polContiCd, String effDt) throws DAOException {

				DBRowSet dbRowset = null;
				List<DODTariffVO> list = null;
				
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					param.put("ofc_cd", ofcCd);
					param.put("pol_conti_cd", polContiCd);
					param.put("eff_dt", effDt);
					
					velParam.put("ofc_cd", ofcCd);
					velParam.put("pol_conti_cd", polContiCd);
					velParam.put("eff_dt", effDt);

					dbRowset = new SQLExecuter("").executeQuery(new DODInvoiceMgtDBDAOSearchDODTariffListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, DODTariffVO .class);
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
		 * Korea DOD Tariff Effective Date 정보를 조회한다.<br>
		 * 
	   * @param String ofc
	   * @param String pol_conti
		 * @return List<String>
		 * @throws DAOException
		 */
			@SuppressWarnings("unchecked")
			public List<String> searchDODTariffEffDtList(String ofc, String pol_conti) throws DAOException {
				  DBRowSet dbRowset = null;
			    List list = new ArrayList();
			    String eff_dt = "";
					 
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					//Map<String, Object> velParam = new HashMap<String, Object>();

					try {
						  param.put("ofc_cd", ofc);
						  param.put("pol_conti_cd", pol_conti);
					
			        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchDODTariffEffDtListRSQL(),param,null);
				      while (dbRowset.next()) {
							     eff_dt = dbRowset.getString("EFF_DT");
							     list.add(eff_dt);
				        } 
					}catch(SQLException se) {
		            log.error(se.getMessage(),se);
		            throw new DAOException(new ErrorHandler(se).getMessage());
		      }catch(Exception ex){
		            log.error(ex.getMessage(),ex);
		            throw new DAOException(new ErrorHandler(ex).getMessage());
		      }
		        return list;
			}
			
			/**
			 * (KOR) DOD Tariff Creation EAS_DOD_TRF 테이블에 insert 한다.<br>
			 * 
			 * @author  
			 * @param List<DODTariffVO> dODTariffVOs
			 * @exception DAOException
			 */
			
			public void addDODTariff(List<DODTariffVO> dODTariffVOs) throws DAOException, Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int insCnt[] = null;
					if (dODTariffVOs.size() > 0) {
						insCnt = sqlExe.executeBatch((ISQLTemplate) new DODInvoiceMgtDBDAOAddDODTariffCSQL(), dODTariffVOs, null);
						for (int i = 0; i < insCnt.length; i++) {
							if (insCnt[i] == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to insert No" + i + " SQL");
						}
					}
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}

			/**
			 * (KOR) DOD Tariff Creation EAS_DOD_TRF 테이블에 update 한다.<br>
			 * 
			 * @author  
			 * @param List<DODTariffVO> dODTariffVOs
			 * @exception DAOException
			 */
			public void modifyDODTariff(List<DODTariffVO> dODTariffVOs) throws DAOException, Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if (dODTariffVOs.size() > 0) {
						updCnt = sqlExe.executeBatch((ISQLTemplate) new DODInvoiceMgtDBDAOModifyDODTariffUSQL(), dODTariffVOs, null);
						for (int i = 0; i < updCnt.length; i++) {
							if (updCnt[i] == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to update No" + i + " SQL");
						}
					}
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}

			/**
			 * (KOR) DOD Tariff Creation EAS_DOD_TRF 테이블에 delete 한다.<br>
			 * 
			 * @author  
			 * @param List<DODTariffVO> dODTariffVOs
			 * @exception DAOException
			 */
			public void removeDODTariff(List<DODTariffVO> dODTariffVOs) throws DAOException, Exception {
				try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int delCnt[] = null;
					if (dODTariffVOs.size() > 0) {
						delCnt = sqlExe.executeBatch((ISQLTemplate) new DODInvoiceMgtDBDAORemoveDODTariffDSQL(), dODTariffVOs, null);
						for (int i = 0; i < delCnt.length; i++) {
							if (delCnt[i] == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to delete No" + i + " SQL");
						}
					}
				} catch (SQLException se) {
					log.error(se.getMessage(), se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex) {
					log.error(ex.getMessage(), ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}		
			
			 /**
			 * (KOR) DOD Tariff Creation  CNTR TYSZ CODE를 점검한다.<br>
			 * 
	         * @param String cntr_tpsz_cd
			 * @return String
			 * @throws DAOException
			 */
			@SuppressWarnings("unchecked")
			public String verifyDODTariffTpSz(String cntr_tpsz_cd) throws DAOException {
				DBRowSet dbRowset = null;
				String tpSzCnt = "1";
				
			    String cntr_tpsz_cds = "";
			    cntr_tpsz_cds = cntr_tpsz_cd;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				//Map<String, Object> velParam = new HashMap<String, Object>();

				try {
					StringTokenizer tpCdToken = new StringTokenizer(cntr_tpsz_cds, ",");
					int chkCnt = 0;
					 while(tpCdToken.hasMoreTokens()){
			            	String tpSzCd = tpCdToken.nextToken();
			            	param.put("cntr_tpsz_cd", tpSzCd);
				
			            	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOverifyCntrTpSzRSQL(),param,null);
			            	if(dbRowset.next()){
			            		chkCnt = dbRowset.getInt("TPSZ_CNT");
			            		if (chkCnt == 0) {
			            			tpSzCnt = "0";
			            			dbRowset.beforeFirst();
			            			return tpSzCnt;
			            		}
			            	}
					 }
				}catch(SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
		        }catch(Exception ex){
		            log.error(ex.getMessage(),ex);
		            throw new DAOException(new ErrorHandler(ex).getMessage());
		        }
		        return tpSzCnt;
			}			
			
			/**
			 * Korea DOD Tariff Dup Chek 정보를 조회한다.<br>
			 * 
			 * @param DODTariffVO dODTariffVO
			 * @return String
			 * @throws DAOException
			 */
			@SuppressWarnings("unchecked")
			public String searchDODTariffDupCheck(DODTariffVO dODTariffVO) throws DAOException {
				  DBRowSet dbRowset = null;
			    String dupCnt = "";
					 
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					//Map<String, Object> velParam = new HashMap<String, Object>();
			
					try {
						if(dODTariffVO != null) {        		
				            Map<String, String> mapVO = dODTariffVO.getColumnValues();    
				            param.putAll(mapVO);
			        	}
						  dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DODInvoiceMgtDBDAOSearchDODTariffDupCheckRSQL(),param,null);
						  while (dbRowset.next()) {
							  dupCnt = dbRowset.getString("DUP_CNT");
						  } 
					}catch(SQLException se) {
			        log.error(se.getMessage(),se);
			        throw new DAOException(new ErrorHandler(se).getMessage());
			  }catch(Exception ex){
			        log.error(ex.getMessage(),ex);
			        throw new DAOException(new ErrorHandler(ex).getMessage());
			  }
			    return dupCnt;
			}
}