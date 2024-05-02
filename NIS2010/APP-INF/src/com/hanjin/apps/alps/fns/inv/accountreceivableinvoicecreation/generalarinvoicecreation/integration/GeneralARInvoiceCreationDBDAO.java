/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAO.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.16 최도순 [] OTHER I/F GL_EFF_DT 구하는 로직 변경
* 2010.10.21 최도순 [CHM-201006525] A/R INVOICE의 DEM/DET 자료 인터페이스 로직 수정 요청
* 2010.10.22 최도순 [CHM-201006609] [A/R] DEMDET invoice의 이중 I/F 방지를 위한 보완
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.08.10 오요한 [CHM-20111????] 공통항차 ASSIGN LOGIC 변경
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.CntrTypeSizeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.CutOffOfficeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvIssueFlagVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.MRIRevenueVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.REVTypeSourceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MdmCrCustVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS GeneralARInvoiceCreationDBDAO <br>
 * - ALPS-AccountReceivableInvoiceCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung Hwi Taek
 * @see GeneralARInvoiceCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class GeneralARInvoiceCreationDBDAO extends DBDAOSupport {	
	
	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	
	/**
	 * GeneralARInvoiceCreationDBDAO 객체 생성<br>
	 * GeneralARInvoiceCreationDBDAO 를 생성한다.<br>
	 */
	public GeneralARInvoiceCreationDBDAO() { }
	
	/**
	 * GeneralARInvoiceCreationDBDAO 객체 생성<br>
	 * GeneralARInvoiceCreationDBDAO 를 생성한다.<br>
	 * @param String dataSource
	 */
	public GeneralARInvoiceCreationDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Interface Main 테이블에 Insert <br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @exception DAOException
	 */
	public void addInterfaceMain(InvArIfMnVO invArIfMnVO) throws DAOException {
		
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        
        try {
        	if(invArIfMnVO != null) {
	            Map<String, String> mapVO = invArIfMnVO.getColumnValues();
	            
	            param.putAll(mapVO);
	            velParam.putAll(mapVO);
        	}
            
            result = new SQLExecuter(dataSource).executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOaddInterfaceMainCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
            	throw new DAOException("Fail to insert SQL");
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
	 * Interface Charge 테이블에 Insert. <br>
	 * 
	 * @param List<InvArIfChgVO> invArIfChgVOs
	 * @exception DAOException
	 */
	public void addInterfaceCharge(List<InvArIfChgVO> invArIfChgVOs) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        InvArIfChgVO invArIfChgVO = null;
        
        int result = 0; 
        
        try {
        	for(int i = 0; i < invArIfChgVOs.size(); i++) {
        	
        		invArIfChgVO = invArIfChgVOs.get(i);
	        	if(invArIfChgVO != null) {
		            Map<String, String> mapVO = invArIfChgVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter(dataSource).executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOaddInterfaceChargeCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	            	throw new DAOException("Fail to insert SQL");
	            }
        	} // end for(i)    
        	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

	}
		
	/**
	 * Interface Container 테이블에 Insert. <br>
	 * 
	 * @param List<InvArIfCntrVO> invArIfCntrVOs
	 * @exception DAOException
	 */
	public void addInterfaceContainer(List<InvArIfCntrVO> invArIfCntrVOs) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        InvArIfCntrVO invArIfCntrVO = null;
        
        int result = 0; 
        
        try {
        	for(int i = 0; i < invArIfCntrVOs.size(); i++) {
        	
        		invArIfCntrVO = invArIfCntrVOs.get(i);
	        	if(invArIfCntrVO != null) {
		            Map<String, String> mapVO = invArIfCntrVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter(dataSource).executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOaddInterfaceContainerCSQL(), param, velParam);
	            if(result == Statement.EXECUTE_FAILED) {
	            	throw new DAOException("Fail to insert SQL");
	            }
        	} // end for(i)    
        	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

	}
	
	/**
	 * INV_AR_IF_MN의 SRC_IF_SEQ 번호 채번<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchSrcIfSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String srcIfSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSrcIfSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				srcIfSeq = dbRowset.getString("src_if_seq");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return srcIfSeq;
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInterfaceMainRSQL(), param, velParam);
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
	            
            result = new SQLExecuter(dataSource).executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOmodifyIfErrRsnUSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL(), param, velParam);
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
	 * BKG_VVD table 에서 vvd 정보 조회<br>
	 * 
	 * @param String bnd
	 * @param String bkgNo
	 * @return BkgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdVO searchBkgVvd(String bnd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		BkgVvdVO bkgVvdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bnd != null && bkgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bnd", bnd);
				mapVO.put("bkg_no", bkgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchBkgVvdRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchVskVslSkdRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchArMstRevVvdRSQL(), param, velParam);
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
	 * @param String glEffDt
	 * @return BkgVvdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdVO searchArMstRevVvdTml(String glEffDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		BkgVvdVO bkgVvdVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
            param.put("glEffDt", glEffDt);
            param.putAll(mapVO);
            velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchArMstRevVvdTmlRSQL(), param, velParam);
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
	 * MDM_CUSTOMER table 에서 customer 정보 조회<br>
	 * 
	 * @param MdmOrganizationVO mdmOrgVo
	 * @param String custCntCd
	 * @param String custSeq
	 * @return MdmCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCustomerVO checkCustomer(MdmOrganizationVO mdmOrgVo, String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCustomerVO> list = null;
		MdmCustomerVO mdmCustVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmOrgVo != null && custCntCd != null && custSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_agent_mark", mdmOrgVo.getSoIfCd());
				mapVO.put("rep_cust_cnt_cd", mdmOrgVo.getRepCustCntCd());
				mapVO.put("rep_cust_seq", mdmOrgVo.getRepCustSeq());
				mapVO.put("cust_cnt_cd", custCntCd);
				mapVO.put("cust_seq", custSeq);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOcheckCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCustomerVO .class);
			
			if (list != null && list.size() > 0) {
				mdmCustVo = (MdmCustomerVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mdmCustVo;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchRgnCdRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSvcScpRSQL(), param, velParam);
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
	 * INV_VVD_XCH_RT table 에서 inv_xch_rt 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @param String arCurrCd
	 * @param String svcScpCd
	 * @param String chgCurrCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvXchRt(InvArIfMnVO invArIfMnVO, String arCurrCd, String svcScpCd, String chgCurrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invSchRt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null && arCurrCd != null && svcScpCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("vsl_cd", invArIfMnVO.getVslCd());
				mapVO.put("skd_voy_no", invArIfMnVO.getSkdVoyNo());
				mapVO.put("skd_dir_cd", invArIfMnVO.getSkdDirCd());
				mapVO.put("pol_cd", invArIfMnVO.getPolCd());
				mapVO.put("pod_cd", invArIfMnVO.getPodCd());
				mapVO.put("locl_curr_cd", arCurrCd);
				mapVO.put("chg_curr_cd", chgCurrCd);				
				mapVO.put("svc_scp_cd", svcScpCd);
				mapVO.put("io_bnd_cd", invArIfMnVO.getIoBndCd());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvXchRtRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		invSchRt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invSchRt;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSaDtLaneObRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSaDtLaneIbRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSaDtLaneRSQL(), param, velParam);
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
	 * MDM_CR_CUST table 에서 CR_FLG, IB_CR_TERM_DYS, OB_CR_TERM_DYS 조회<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return MdmCrCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmCrCustVO searchARCredit(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCrCustVO> list = null;
		MdmCrCustVO mdmCrCustVo = null;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchARCreditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCrCustVO .class);
			
			if (list != null && list.size() > 0) {
				mdmCrCustVo = (MdmCrCustVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mdmCrCustVo;
	}		
	
	/**
	 * INV_AR_MN table 에서 DUE_DT 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @return DueDateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DueDateVO searchDueDtForMaxINVInterface(String blSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<DueDateVO> list = null;
		DueDateVO dueDateVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blSrcNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bl_src_no", blSrcNo);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDueDtForMaxINVInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateVO .class);
			
			if (list != null && list.size() > 0) {
				dueDateVo = (DueDateVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return dueDateVo;
	}	
	
	/**
	 * BKG_BOOKING table 에서 DEST_TRNS_SVC_MOD_CD 조회<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchDestSVCModeCode(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String destTrnsSvcModCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bkg_no", bkgNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDestSVCModeCodeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		destTrnsSvcModCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return destTrnsSvcModCd;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchLocalTimeRSQL(), param, velParam);
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
	 * MDM_CR_CUST table 에서 due date 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @param String sailArrDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreditCustomerForCredit(InvArIfMnVO invArIfMnVO, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null && sailArrDt != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("io_bnd_cd", invArIfMnVO.getIoBndCd());
				mapVO.put("sail_arr_dt", sailArrDt);
				mapVO.put("cust_cnt_cd", invArIfMnVO.getCustCntCd());
				mapVO.put("cust_seq", invArIfMnVO.getCustSeq());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchCreditCustomerForCreditRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		dueDt = dbRowset.getString(1);
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
	 * MDM_CR_CUST table 에서 due date 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @param String sailArrDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfficeForCredit(InvArIfMnVO invArIfMnVO, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		String dueDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null && sailArrDt != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("io_bnd_cd", invArIfMnVO.getIoBndCd());
				mapVO.put("sail_arr_dt", sailArrDt);
				mapVO.put("ofc_cd", invArIfMnVO.getOfcCd());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchOfficeForCreditRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		dueDt = dbRowset.getString(1);
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
	 * DEST_TRNS_SVC_MOD_CD 로 due date 계산 <br>
	 * 
	 * @param String destTrnsSvcModCd
	 * @param String dueDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchDueDtForDestSVCModeCode(String destTrnsSvcModCd, String dueDt) throws DAOException {
		DBRowSet dbRowset = null;
		String rDueDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(destTrnsSvcModCd != null && dueDt != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("dest_trns_svc_mod_cd", destTrnsSvcModCd);
				mapVO.put("due_dt", dueDt);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rDueDt = dbRowset.getString(1);
	    	}
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return rDueDt;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSeverIdRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchZoneIOCRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchCityCdRSQL(), param, velParam);
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
	 * BKG_BOOKING, BKG_BL_DOC table 에서 BL_OBRD_DT 조회<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBLOnDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String blObrdDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("bkg_no", bkgNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchBLOnDateRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		blObrdDt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return blObrdDt;
	}		
	
	/**
	 * MDM_CUSTOMER table 에서 SUBS_CO_CD 조회<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchInterCompany(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String subsCoCd = null;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInterCompanyRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		subsCoCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return subsCoCd;
	}		
	
	/**
	 * MDM_CHARGE table 에서 REP_CHG_CD 조회<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchRepCharge(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String repChgCd = "";
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchRepChargeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		repChgCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return repChgCd;
	}		
	
	/**
	 * MDM_CHARGE table 에서 CHG_NM 조회<br>
	 * 
	 * @param String chgCd
	 * @param String arOfcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchChargeName(String chgCd, String arOfcCd) throws DAOException {
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
				mapVO.put("ar_ofc_cd", arOfcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchChargeNameRSQL(), param, velParam);
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
	 * INV_REV_ACCT_CD table 에서 INV_ACCT_DIV_CD 조회<br>
	 * 
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountDivision(String revTpCd, String revSrcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invAcctDivCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(revTpCd != null && revSrcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("rev_tp_cd", revTpCd);
				mapVO.put("rev_src_cd", revSrcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountDivisionRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		invAcctDivCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invAcctDivCd;
	}	
	
	/**
	 * MDM_CHARGE table 에서 HJS_CHG_ACCT_CD 조회<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdFromCharge(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String hjsChgAcctCd = "";
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountCdFromChargeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		hjsChgAcctCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return hjsChgAcctCd;
	}		
	
	/**
	 * INV_REV_ACCT_CD table 에서 ACCT_CD 조회<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdFromRevAcct(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String acctCd = "";
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountCdFromRevAcctRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		acctCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return acctCd;
	}		
	
	/**
	 * INV_AR_STUP_OFC table 에서 ISSUE_FLAG, REISSUE_FLAG 조회 <br>
	 * 
	 * @param String invSrcNo
	 * @param String ofcCd
	 * @return InvIssueFlagVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvIssueFlagVO searchARSetupOfficeForIssueReIssue(String invSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvIssueFlagVO> list = null;
		InvIssueFlagVO invIssFlagVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invSrcNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("inv_src_no", invSrcNo);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchARSetupOfficeForIssueReIssueRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvIssueFlagVO .class);
			
			if (list != null && list.size() > 0) {
				invIssFlagVo = (InvIssueFlagVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invIssFlagVo;
	}	
	
	/**
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @param String zoneIoc
	 * @return MRIRevenueVVDLaneVO mriRevVvdLaneVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLane(InvArIfMnVO invArIfMnVO, String zoneIoc) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null && zoneIoc != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("lane", invArIfMnVO.getSlanCd());
				mapVO.put("vsl", invArIfMnVO.getVslCd());
				mapVO.put("voy", invArIfMnVO.getSkdVoyNo());
				mapVO.put("dep", invArIfMnVO.getSkdDirCd());
				mapVO.put("pol", invArIfMnVO.getPolCd());
				mapVO.put("pod", invArIfMnVO.getPodCd());
				mapVO.put("zone_ioc", zoneIoc);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
	}		
	
	/**
	 * REV_TP_CD, REV_SRC_CD 조회<br>
	 * 
	 * @param String ifSrcCd
	 * @return REVTypeSourceVO revTypeSrcVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public REVTypeSourceVO searchREVTypeSource(String ifSrcCd) throws DAOException {
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
			    				
				mapVO.put("if_src_cd", ifSrcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchREVTypeSourceRSQL(), param, velParam);
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
	 * MDM_CR_CUST table 에서 CUST_CR_FLG, CR_TERM_DYS 조회<br>
	 * 
	 * @param String ioBndCd
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String sailArrDt
	 * @return DueDateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DueDateVO searchDueDtByCustomerSadt(String ioBndCd, String custCntCd, String custSeq, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<DueDateVO> list = null;
		DueDateVO dueDateVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custCntCd != null && custSeq != null && sailArrDt != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("io_bnd_cd", ioBndCd);
				mapVO.put("cust_cnt_cd", custCntCd);
				mapVO.put("cust_seq", custSeq);
				mapVO.put("sail_arr_dt", sailArrDt);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDueDtByCustomerSadtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateVO .class);
			
			if (list != null && list.size() > 0) {
				dueDateVo = (DueDateVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return dueDateVo;
	}		
	
	/**
	 * MDM_ORGANIZATION table 에서 CUST_CR_FLG, CR_TERM_DYS 조회<br>
	 * 
	 * @param String ioBndCd
	 * @param String ofcCd
	 * @return DueDateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DueDateVO searchDueDtByOffice(String ioBndCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<DueDateVO> list = null;
		DueDateVO dueDateVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ioBndCd != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("io_bnd_cd", ioBndCd);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDueDtByOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateVO .class);
			
			if (list != null && list.size() > 0) {
				dueDateVo = (DueDateVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return dueDateVo;
	}			
	
	/**
	 * AP_PERIOD table 에서 MRI_MAX_YYMM 조회 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMriMaxYymm(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String mriMaxYymm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMriMaxYymmRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		mriMaxYymm = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriMaxYymm;
	}	
	
	/**
	 * 한국지역 gl_eff_dt 조회 <br>
	 * 
	 * @param String mriMaxYymm
	 * @param String localTime
	 * @param String glDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchGlEffDtKor(String mriMaxYymm, String localTime, String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		String glEffDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("mri_max_yymm", mriMaxYymm);
			mapVO.put("local_time", localTime);
			mapVO.put("gl_eff_dt", glDt);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchGlEffDtKorRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		glEffDt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return glEffDt;
	}	
	
	/**
	 * 기타지역 gl_eff_dt 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxYymm
	 * @param String glDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchGlEffDtOther(String ofcCd, String mriMaxYymm, String glDt) throws DAOException {
		DBRowSet dbRowset = null;
		String glEffDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("mri_max_yymm", mriMaxYymm);
			//mapVO.put("local_time", localTime);
			mapVO.put("gl_eff_dt", glDt);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			//2010-09-18 최도순
			//SELECT DECODE(SIGN(TO_NUMBER(SUBSTR(NVL(NVL(@[gl_eff_dt],@[sail_dt]), @[local_time]), 1, 6)- @[mri_max_yymm])), -1, @[mri_max_yymm]||'01', NVL(NVL(@[gl_eff_dt],@[sail_dt]), @[local_time])) GL_EFF_DT
			//  FROM DUAL 에서 변경
			//1. Front 넘겨준 G/L Date 가 마감 Open 되어 있으면 그대로 G/L Date 로 결정한다.
			//2. Front 넘겨준 G/L Date 가 마감Open 되어 있지 않으면  마감테이블에서 Open된 Min 값을 G/L Date로 결정한다.
			//3. Front 에서 넘겨준 G/L Date 가 존재하지 않는 경우(DEM/DET) 무조건 마감테이블에서 Open된 Min 값을 G/L Date로 결정한다.
		
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		glEffDt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return glEffDt;
	}		
	
	/**
	 * INV_AR_IF_CHG table 에서 Tax Index 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchTaxInd(String srcIfDt, String srcIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String taxInd = "0";
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchTaxIndRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		taxInd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return taxInd;
	}		
	
	/**
	 * MDM_CR_CUST table 에서 CR_CLT_OFC_CD 조회 <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchErpIFOfcCd(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String erpIfOfcCd = "";
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		erpIfOfcCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return erpIfOfcCd;
	}	
	
	/**
	 * MDM_CR_CUST table 에서 KR_IB_OFC_CD 조회 <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchErpIFOfcCdIb(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String erpIfOfcCd = "";
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdIbRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		erpIfOfcCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return erpIfOfcCd;
	}	
	
	/**
	 * ACCT_CD 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @param String svrId
	 * @param String acctCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdConversion(String ofcCd, String chgCd, String revTpCd, String revSrcCd, String svrId,  String acctCd) throws DAOException {
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
			mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountCdConversionRSQL(), param, velParam);						
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
	 * TJ_SRC_NM 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @param String svrId
	 * @return String
	 * @exception DAOException
	 */
	public String searchTjSrcNm( String ofcCd, String chgCd, String revTpCd, String revSrcCd, String svrId) throws DAOException {
		DBRowSet dbRowset = null;
		String tjSrcNm = "";
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
			mapVO.put("svr_id", svrId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchTjSrcNmRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		tjSrcNm = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return tjSrcNm;
	}		
	
	/**
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @return MRIRevenueVVDLaneVO mriRevVvdLaneVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLaneRowNum(InvArIfMnVO invArIfMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("lane", invArIfMnVO.getSlanCd());
				mapVO.put("vsl", invArIfMnVO.getVslCd());
				mapVO.put("voy", invArIfMnVO.getSkdVoyNo());
				mapVO.put("dep", invArIfMnVO.getSkdDirCd());
				mapVO.put("pol", invArIfMnVO.getPolCd());
				mapVO.put("pod", invArIfMnVO.getPodCd());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRowNumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
	}	
	
	/**
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param String vslCd
	 * @param String glEffDt
	 * @return MRIRevenueVVDLaneVO mriRevVvdLaneVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLaneRd(String vslCd, String glEffDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("vsl", vslCd);
				mapVO.put("glEffDt", glEffDt);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
	}	
	
	/**
	 * ERP에 전송할 Container Type 정보를 조회합니다. <br>
	 * 
	 * @param String ifNo
	 * @return List<CntrTypeSizeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrTypeSizeVO> searchCntrTpSzForERP(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchCntrTpSzForERPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTypeSizeVO .class);
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
	 * ERP에 전송할 Invoice 정보를 조회합니다. <br>
	 * 
	 * @param String ifNo 
	 * @param String flag
	 * @return List<Fns0120001VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<Fns0120001VO> searchARInvoiceForERP(String ifNo, String flag) throws DAOException {
		DBRowSet dbRowset = null;
		List<Fns0120001VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			mapVO.put("flag", flag);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			// 2010.01.06 정휘택
			// BookingARCreationDBDAOSearchARInvoiceForERPRSQL 과 동일한 SQL 입니다
			// 수정시 BookingARCreationDBDAOSearchARInvoiceForERPRSQL 도 같이 수정해 주십시요
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchARInvoiceForERPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Fns0120001VO .class);
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
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("src_if_dt", srcIfDt);
			mapVO.put("src_if_seq", srcIfSeq);
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);	

			sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOmodifyIfNoUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	} 
	 
	 
	/**
	 * INV_AR_IF_MN Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return InvArIfMnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvArIfMnVO searchInvArIfMain(String srcIfDt, String srcIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfMnVO> list = null;
		InvArIfMnVO invArIfMnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(srcIfDt != null && srcIfSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("src_if_dt", srcIfDt);
				mapVO.put("src_if_seq", srcIfSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvArIfMainRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfMnVO .class);
			
			if (list != null && list.size() > 0) {
				invArIfMnVO = (InvArIfMnVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invArIfMnVO;
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
			if(srcIfDt != null && srcIfSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("src_if_dt", srcIfDt);
				mapVO.put("src_if_seq", srcIfSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvArIfChgRSQL(), param, velParam);
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
	 * INV_AR_IF_CNTR Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArIfCntrVO> searchInvArIfCntr(String srcIfDt, String srcIfSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(srcIfDt != null && srcIfSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("src_if_dt", srcIfDt);
				mapVO.put("src_if_seq", srcIfSeq);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
						
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
	 * INV_AR_MN Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	public void removeArIfMain(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(arIfNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ar_if_no", arIfNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOremoveArIfMainDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_AMT Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	public void removeArIfAmt(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(arIfNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ar_if_no", arIfNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOremoveArIfAmtDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_CHG Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	public void removeArIfChg(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(arIfNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ar_if_no", arIfNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOremoveArIfChgDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * INV_AR_CNTR Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	public void removeArIfCntr(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if(arIfNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ar_if_no", arIfNo);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralARInvoiceCreationDBDAOremoveArIfCntrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * BKG_VVD, VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDateByBkgNo(String bkgNo) throws DAOException {
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSailingDateByBkgNoRSQL(), param, velParam);
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchSailingDateByVvdRSQL(), param, velParam);
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
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param InvArIfMnVO invArIfMnVO
	 * @return MRIRevenueVVDLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLaneByVvdPort(InvArIfMnVO invArIfMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invArIfMnVO != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("lane", invArIfMnVO.getSlanCd());
				mapVO.put("vsl", invArIfMnVO.getVslCd());
				mapVO.put("voy", invArIfMnVO.getSkdVoyNo());
				mapVO.put("dep", invArIfMnVO.getSkdDirCd());
				mapVO.put("pol", invArIfMnVO.getPolCd());
				mapVO.put("pod", invArIfMnVO.getPodCd());
				mapVO.put("bkg_no", invArIfMnVO.getBkgNo());
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMRIRevenueVVDLaneByVvdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvCoaRgnInvCoaCtrRSQL(), param, velParam);
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchUsdXchRtByAcctMonthRSQL(), param, velParam);
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
	 * INV_AR_LOCL_CHG 테이블에서 ACCT CODE 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalChgFlg(String ofcCd, String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String loclChgAcctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchLocalChgFlgRSQL(), param, velParam);
			while(dbRowset.next()){
				loclChgAcctCd = dbRowset.getString("acct_cd");
            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return loclChgAcctCd;
	}		
    
	/**
  	*  Rev Type, Chg Cd 로 REV_COA_ACCT_CD 조회<br>
  	* 
	* @param  String chgCd
	* @param  InvArMnVO invArMnVO
	* @param  String svrId
	* @param  String acctCd
	* @return InvArChgVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public InvArChgVO searchInvRevTpSrcCd(String chgCd, InvArMnVO invArMnVO, String svrId, String acctCd) throws DAOException {
	
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
			mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
			mapVO.put("ofc_cd", invArMnVO.getArOfcCd());
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchInvRevTpSrcCdRSQL(), param, velParam);
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
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addEnisLog(String modName, String applInfo, String logDesc) {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mod_name", modName);
			mapVO.put("appl_info", applInfo);
			mapVO.put("log_desc", logDesc);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter(dataSource).executeSP((ISQLTemplate) new GeneralARInvoiceCreationDBDAOPrcExecEnisLogCSQL(), param, velParam);
		}
//		catch (SQLException se)
//		{
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}
		catch (Exception ex)
		{
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			log.error(ex.getMessage());
			log.info(ex.getMessage());
		}
	}
	
	
	/**
	 * INV_AR_MN table 에서 VVD, Bnd 관련 항목 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @return InvArMnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvArMnVO searchVVDForMaxINVInterface(String blSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArMnVO> list = null;
		InvArMnVO invArMnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blSrcNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bl_src_no", blSrcNo);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchVVDForMaxINVInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
			
			if (list != null && list.size() > 0) {
				invArMnVO = (InvArMnVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invArMnVO;
	}	
	
	/**
  	* INV_AR_MN 테이블에서 I/F 되어 있는 데이터가 있는지 여부 체크<br>
  	* 
  	* @param  String blSrcNo
  	* @param  String invSrcNo
	* @return int
	* @exception DAOException
	*/
	public int searchLastDMTInvNo( String blSrcNo, String invSrcNo )throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("inv_src_no", invSrcNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchLastDMTInvNoSQL(), param, velParam);
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
  	* INV_AR_CNTR에서 AR_IF_NO로 조회함.<br>
  	* 
	* @param String ifNo
	* @return List<InvArCntrVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArCntrVO> searchARInvoiceContainer ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOSearchARInvoiceContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArCntrVO .class);
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
  	* AR_IF_NO로 Good 여부 체크.<br>
  	* 
	* @param String ifNo
	* @return int
	* @exception DAOException
	*/
	public int checkGoodData ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		int goodCnt = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOcheckGoodDataRSQL(), param, velParam);
			if(dbRowset.next()) {						
				goodCnt = dbRowset.getInt("cnt");
	    	}
			log.info("goodCnt==>"+goodCnt);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return goodCnt;
	}
	
	/**
	 * INV_CUT_OFF_LANE table 에서 OLD OFC 를 조회<br>
	 * 
	 * @param CutOffOfficeVO cutOffOfficeVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCutOffLaneOfficebyOld(CutOffOfficeVO cutOffOfficeVO) throws DAOException {

		DBRowSet dbRowset = null;
		String new_ar_ofc_cd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

				Map<String, String> mapVO = cutOffOfficeVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyOldRSQL(), param, velParam);

			if(dbRowset.next()) {
	    		new_ar_ofc_cd = dbRowset.getString("ar_ofc_cd");
	    	}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return new_ar_ofc_cd;
	}

	/**
	 * INV_CUT_OFF_LANE table 에서 NEW OFC 를 조회<br>
	 * 
	 * @param CutOffOfficeVO cutOffOfficeVO
	 * @return String
	 * @exception DAOException
	 */

	public String searchCutOffLaneOfficebyNew(CutOffOfficeVO cutOffOfficeVO) throws DAOException {

		DBRowSet dbRowset = null;
		String new_ar_ofc_cd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				Map<String, String> mapVO = cutOffOfficeVO.getColumnValues();
				
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchCutOffLaneOfficebyNewRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		new_ar_ofc_cd = dbRowset.getString("ar_ofc_cd");
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return new_ar_ofc_cd;
	}
}


