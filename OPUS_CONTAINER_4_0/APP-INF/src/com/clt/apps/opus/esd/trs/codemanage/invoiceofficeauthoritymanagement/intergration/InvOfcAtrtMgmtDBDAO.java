/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvOfcAtrtMgmtDBDAOInvOfcAtrtMgmtDBDAO.java
*@FileTitle : TRS Invoice Authority
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 유선오
*@LastVersion : 1.1
* 2011.11.09 유선오
* 1.0 Creation
-------------------------------------------------------------------
* History
* 2011.11.09  유선오 1.1 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16  유선오 1.2 [CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 :Line No.34 클래스의 주석을 기술  Line No.51,87,161 메소드 주석 기술(메소드 파라미터 맞추기) 
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.intergration;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
  
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Yoo,SunOh
 * @see InvOfcAtrtMgmtBCImpl 참조
 * @since J2EE 1.6
 */

public class InvOfcAtrtMgmtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * InvoiceOfficeCode의 조회 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceOfficeAuthorityManagementVO> searchInvOfcAtrtMgmtList(InvoiceOfficeAuthorityManagementVO model) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<InvoiceOfficeAuthorityManagementVO> list = null;
		try{
						
			param.put("inv_ofc_cd", model.getInvOfcCd().replace(",", "','"));
			param.put("ofc_cd", model.getOfcCd().replace(",", "','"));
	        velParam.put("inv_ofc_cd", model.getInvOfcCd());
	        velParam.put("ofc_cd", model.getOfcCd());
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new InvOfcAtrtMgmtDBDAOSearchTrsTrspOfcCdMdmOrganizationRSQL(), param, velParam, true);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceOfficeAuthorityManagementVO.class);
            	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return list;
	}
	
   /**
    * OfficeCode의 조회 후 OfficeCode의 영어 주소명을 가져온다. <br>
    * @param event
    * @return
    * @throws DAOException
    */
public InvoiceOfficeAuthorityManagementVO searchOfficeCode(EsdTrs0976Event event) throws DAOException {	
	        DBRowSet dbRowset = null;
	        InvoiceOfficeAuthorityManagementVO vo = event.getInvoiceOfficeAuthorityManagementVO();
		    Map<String, Object> param = new HashMap<String, Object>();
		    Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_ofc_cd",event.getInvOfcCd());
			mapVO.put("ofc_cd", event.getOfcCd());
		    mapVO.put("row", event.getRow());	
        	param.putAll(mapVO);
			velParam.putAll(mapVO);
            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new InvOfcAtrtMgmtDBDAOSearchOfficeCodeRSQL(), param, velParam);
            while(dbRowset.next()){
				if(dbRowset.getString("OFC_ENG_NM") == null || dbRowset.getString("OFC_ENG_NM").equals("")){
					vo.setOfcEngNm("");
				}else{
					vo.setOfcEngNm(dbRowset.getString("OFC_ENG_NM"));
				   }				
			    }				
		    } catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		    } catch (Exception ee){
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		    } 
		return vo;
    }

	/**
	 * InvoiceOfficeAuthorityManagement 데이타 모델을 DB에서 삭제한다.<br>
	 * @param event
	 * @throws DAOException
	 */
	
	public void removeInvoiceOffice(EsdTrs0976Event event) throws DAOException {
    		Map<String, Object> param = new HashMap<String, Object>();
    		InvoiceOfficeAuthorityManagementVO[] models = event.getInvoiceOfficeAuthorityManagementVOs();
    		int insCnt = 0;
    		try {
			InvoiceOfficeAuthorityManagementVO model = null;
			for (int i = 0; models != null && i < models.length; i++) {
				model = (InvoiceOfficeAuthorityManagementVO) models[i];
				if (model.getIbflag().length() > 0) {
					param.put("inv_ofc_cd", model.getInvOfcCd());
					param.put("ofc_cd", model.getOfcCd());
					
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new InvOfcAtrtMgmtDBDAORemoveTrsTrspInvOfcDSQL(),param, param);
					
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
					}
				 }
			  }
    		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
    		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * InvoiceOfficeCode의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * @param event
	 * @throws DAOException
	 */
	public void multiTRS_TRSP_INV_OFC(EsdTrs0976Event event) throws DAOException {
         
	    	DBRowSet dbRowset=null;
	    	@SuppressWarnings("unused")
	    	int insCnt = 0;
	    	InvoiceOfficeAuthorityManagementVO [] models = event.getInvoiceOfficeAuthorityManagementVOs();
	    	Map<String, Object> param = new HashMap<String, Object>();
	    	Map<String, Object> velParam = new HashMap<String, Object>();
	    	String cre_usr_id = event.getCreUsrId();
	    	try {
	    		for(int f=0; models != null && f < models.length; f++) {
	    			if (models[f].getIbflag().length() > 0) {
	    				if (models[f].getIbflag().equals("I")) {    
	    					param.put("inv_ofc_cd", models[f].getInvOfcCd()); 
	    					param.put("ofc_cd", models[f].getOfcCd()); 
	    					dbRowset=new SQLExecuter("DEFAULT").executeQuery(new InvOfcAtrtMgmtDBDAOsearchInvoiceOfficeAuthorityManagementDupleRSQL(), param, velParam);
	    					while (dbRowset.next()) {
	    						int verifyCnt = dbRowset.getInt("cnt");
	    						if(verifyCnt > 0) {
	    						throw new DAOException((new ErrorHandler("TRS00099",new String[]{"Duplicated data has exists."})).getMessage());
	    						}
	    					}   
	    					param.put("inv_ofc_cd", models[f].getInvOfcCd());                   
	    					param.put("ofc_cd", models[f].getOfcCd());
	    					param.put("inv_ofc_eng_nm", models[f].getInvOfcEngNm());    
	    					param.put("ofc_eng_nm", models[f].getOfcEngNm());                   
	    					param.put("cre_usr_id", cre_usr_id);                                
							insCnt=	new SQLExecuter().executeUpdate(new InvOfcAtrtMgmtDBDAOmultiInvOfcInsertCSQL(), param, param);							
					    	}
	    				}
	    			}	
	    	} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
	    	} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		    }
	    }
    }	   