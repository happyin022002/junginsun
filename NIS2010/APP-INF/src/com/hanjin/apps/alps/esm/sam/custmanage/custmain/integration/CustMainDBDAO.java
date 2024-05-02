/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustMainDBDAO.java
*@FileTitle : Customer main 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.integration;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAOSearchStateByCountryRSQL;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration.CustGroupDBDAOModifyCustGroupSrepUSQL;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CustMainDBDAO <br>
 * - ALPS system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 임재관 
 * @see CustManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CustMainDBDAO extends DBDAOSupport {
	/** 
     * CustomerA의 모든 목록을 가져온다.<br>
	 * @param String custCd
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String include
	 * @param String cust
	 * @param String zipCd
	 * @return List<SearchCustomerVO>
     * @throws DAOException
     */
    public List<SearchCustomerVO> searchCustomerList(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd, String custGrpId, String locCd, String steCd, String srepCd, String deltFlg) throws DAOException {
    	
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchCustomerVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
         
        // 페이징 처리
		int currentPage = iPage;
		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		param.put("startpart", startPart);
		param.put("endpart", endPart);
		param.put("include", include);
		velParam.put("include", include);
		
		log.debug("currentPage: " + currentPage);
		log.debug("startPart: " + startPart);
		log.debug("endPart: " + endPart);
		
		try {
			StringBuffer tmpCust = new StringBuffer();
			if(!cust.equals("")){
				for (int i = cust.length(); i < 6; i++) {
					tmpCust.append("0");
				}
				tmpCust.append(cust);
				cust = tmpCust.toString();
			}
			if(!custCd.equals("")) {
	        	param.put("cust_cnt_cd", custCd);
	        	velParam.put("cust_cnt_cd", custCd);
			}
			if(!cust.equals("")) {
	        	param.put("cust_seq", cust);
	        	velParam.put("cust_seq", cust);
			}
			if(!custNm.equals("")) {
				param.put("cust_lgl_eng_nm", custNm);
	        	velParam.put("cust_lgl_eng_nm", custNm);
			}		
			if(!ofcCd.equals("")) {
				param.put("ofc_cd", ofcCd);
	        	velParam.put("ofc_cd", ofcCd);
			}
			if(!zipCd.equals("")) {
				param.put("zip_cd", zipCd);
	        	velParam.put("zip_cd", zipCd);
			}
			if(!custGrpId.equals("")) {
				param.put("cust_grp_id", custGrpId);
	        	velParam.put("cust_grp_id", custGrpId);
			}
			if(!locCd.equals("")) {
				param.put("loc_cd", locCd);
	        	velParam.put("loc_cd", locCd);
			}
			if(!steCd.equals("")) {
				param.put("ste_cd", steCd);
	        	velParam.put("ste_cd", steCd);
			}
			if(!srepCd.equals("")) {
				param.put("srep_cd", srepCd);
	        	velParam.put("srep_cd", srepCd);
			}
			if(!deltFlg.equals("")) {
				param.put("delt_flg", deltFlg);
	        	velParam.put("delt_flg", deltFlg);
			}
			dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOTotalCustomerRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  
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
	 * Trade Code 유무를 확인.<br>
	 * 
	 * @param String trdCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkTrdCode (String trdCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter			
			try {
				if(trdCd != null){
					param.put("trd_cd" ,trdCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckTrdCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	
	/**
	 * [Coverage Team Tab] 정보를 [Retrieve] 합니다.<br>
	 * 
	 * @param SearchCustomerVO  searchCustomerVO 
	 * @return List<CustCoverTeamVO >
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustCoverTeamVO > searchCustCoverList(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustCoverTeamVO > list = null;
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchCustCoverListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustCoverTeamVO.class);
			
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
	 * ESM_SAM_0003 : SELECT <br>
	 * DBClick
	 * 
	 * @param SamKeyManInfoVO samKeyManInfoVO
	 * @return List<SamKeyManInfoVO>
	 * @exception DAOException
	 */
/*	@SuppressWarnings("unchecked")
	public List<SamKeyManInfoVO> searchKeyManDetailInfo(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<SamKeyManInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			velParam.put("cust_cnt_cd", custCntCd);
			velParam.put("cust_seq", custSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustMainDBDAOsearchKeyManDetailInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SamKeyManInfoVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}*/
	
	
	 /**
	  * Customer Code 존재여부 확인<br>
	  * 
	  * @param String custCntCd
	  * @param String custSeq
	  * @return List<CustomerVO>
	  * @exception DAOException
	  */
	public List<CustomerVO> checkExistCustInfoData(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			velParam.put("cust_cnt_cd", custCntCd);
			velParam.put("cust_seq", custSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CustMainDBDAOCheckExistingCustInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Sales Repository Code 유무를 확인.<br>
	 * 
	 * @param String slsRepCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSlsRepCode(String slsRepCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(slsRepCd != null){
					param.put("srep_cd" ,slsRepCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckSlsRepCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}	
	
	/**
	 * Customer Code 유무를 확인.<br>
	 * 
	 * @param String custCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCustCode(String custCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(custCd != null){
					param.put("cust_cd"    ,custCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckCustCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Group Customer Code 유무를 확인.<br>
	 * 
	 * @param String grpCustCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkGrpCustCode(String grpCustCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
		try{
			if(grpCustCd != null){
				param.put("cust_grp_id" ,grpCustCd);
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckGrpCustCodeRSQL(), param, null);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * State Code 유무를 확인.<br>
	 * 
	 * @param String grpCustCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkStateCode(String steCd, String cntCd) throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(steCd != null){
				param.put("ste_cd" ,steCd);
				param.put("cnt_cd" ,cntCd);
				velParam.put("cnt_cd", cntCd);
				velParam.put("ste_cd", steCd);
			}		
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchStateByCountryRSQL(), param, velParam);
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingUtilDBDAOSearchStateByCountryRSQL(), param, null);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Currency Code 유무를 확인.<br>
	 * 
	 * @param String currCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCurrCode(String currCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter			
			try {
				if(currCd != null){
					param.put("curr_cd",currCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckCurrCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * Vender Code 를 체크합니다.<br>
	 * 
	 * @param String vndrCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkVndrCode(String vndrCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(vndrCd != null){
					param.put("vndr_cd",vndrCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckVndrCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}	
	
	/**
	 * Office Code 유무를 확인.<br>
	 * 
	 * @param String ofcCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkOfcCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(ofcCd != null){
					param.put("ofc_cd" ,ofcCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckOfcCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * Location Code 유무를 확인.<br>
	 * 
	 * @param String locCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkLocCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(locCd != null){
					param.put("loc_cd" ,locCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckLocCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * Country Code 유무를 확인.<br>
	 * 
	 * @param String cntCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkCntCode(String cntCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(cntCd != null){
					param.put("cnt_cd",cntCd);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckCntCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * International No 유무를 확인.<br>
	 * 
	 * @param String intlNo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkIntlNo(String intlNo) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(intlNo != null){
					param.put("intl_no",intlNo);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckCntCodeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * Customer Contact Point Code 정보를 수정한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerContactVO custCntcVO
	 * @exception DAOException
	 */

	public void modifyCustCntcCode(CustomerContactVO custCntcVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custCntcVO != null){
				Map<String, String> mapVO = custCntcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOModifyCustCntcCodeUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchMAXCustomerSeq(String custcntcd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custcntcd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchMAXCustomerSeqRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchMAXCustAddrSeq(String custcntcd, String custseq, String addrtpcd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custcntcd);
			param.put("cust_seq", custseq);
			param.put("addr_tp_cd", addrtpcd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchMAXCustAddrSeqRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer Address(MDM_CUST_ADDR) 테이블의 MAX ADDR_SEQ 를 가져온다.(ESM_SAM_0302)<br>
	 * 
	 * @param  String custcntcd
	 * @param  String custseq
	 * @param  String addrtpcd
	 * @return DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCntCustHisSeq(String custcntcd, String custseq) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cust_cnt_cd", custcntcd);
			param.put("cust_seq", custseq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOsearchCntCustHisSeqRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer Address 정보를 삭제한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerAddressVO custAddrVO
	 * @exception DAOException
	 */

	public void removeCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAORemoveCustAddrCodeDSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Customer Address 정보를 생성한다.(ESM_SAM_0302)<br>
	*  
	* @param CustomerAddressVO custAddrVO
	* @exception DAOException
	*/
	public void addCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOAddCustAddrCodeCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}
	
		}catch(SQLException se) 
			{
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} 
		catch(Exception ex) 
			{
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
	}
	
	/**
	 *  Customer Address 정보를 수정한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerAddressVO custAddrVO
	 * @exception DAOException
	 */

	public void modifyCustAddrCode(CustomerAddressVO custAddrVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
		
			if(custAddrVO != null){
				Map<String, String> mapVO = custAddrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOModifyCustAddrCodeUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
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
				insCnt = sqlExe.executeBatch((ISQLTemplate) new CustMainDBDAOMergeBkgCustCdValFrmMdmCustAddrUSQL(), mdmCustomerVOs, null);
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
	 * Customer Code Validation Data Merge
	 * 생성
	 * @param  List<MdmCustomerVO> mdmCustomerVOs
	 * @return boolean
	 * @exception DAOException
	 * @author
	 */
	public boolean mergeMdmCustSezCerti(CustomerVO customerVo) throws DAOException {
		boolean isSuccessful = false;
		int result = 0; 
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customerVo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOMergeMdmCustSezCertiUSQL(), param, velParam);
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
	 * Booking SalesRep Code를 입력합니다.<br>
	 * 
	 * @param BkgSalesRepVO bkgSalesRepVO
	 * @throws DAOException
	 */
	public void addSalesRepCode(BkgSalesRepVO bkgSalesRepVO) throws DAOException {

		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = bkgSalesRepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOAddSalesRepCodeCSQL(), param, velParam);
		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Booking SalesRep Code를 입력합니다.<br>
	 * 
	 * @param BkgSalesRepVO bkgSalesRepVO
	 * @throws DAOException
	 */
	public void modifySalesRepCode(BkgSalesRepVO bkgSalesRepVO) throws DAOException {
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (bkgSalesRepVO != null) {
				Map<String, String> mapVO = bkgSalesRepVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new CustMainDBDAOmodifySalesRepCodeUSQL(), param, velParam);
	
			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
	
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	
	/**
	 * Sales Rep Code 를 가져옵니다.<br>
	 * 
	 * @param String custCd
	 * @param String srepCd
	 * @return DBRowSet
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkSalesRepCode(String custCd, String srepCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		try{
			if(custCd != null && srepCd != null){
				param.put("cust_cd", custCd);
				param.put("srep_cd", srepCd);
			}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckSalesRepCodeRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Cotact Point 를 가져옵니다.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return DBRowSet
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkCntcPnt(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		try{
			if(custCntCd != null && custSeq != null){
				param.put("cust_cnt_cd", custCntCd);
				param.put("cust_seq", custSeq);
			}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOCheckCntcPntRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer Code 정보를 수정한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @exception DAOException
	 */

	public void modifyCustCode (CustomerVO custVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOModifyCustCodeUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Customer Code 정보를 수정한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @exception DAOException
	 */

	public void modifyCustGroupSrepCode (CustomerVO custVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustGroupDBDAOModifyCustGroupSrepUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Customer Code 정보를 수정한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO CustVO
	 * @exception DAOException
	 */

	public void modifyGstCustCode (CustomerVO custVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOModifyGstCustCodeUSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Customer Code 정보를 생성한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO custVO
	 * @exception DAOException
	 */
	public void addCustCode(CustomerVO custVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(custVO != null){
				Map<String, String> mapVO = custVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOAddCustCodeCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Code 정보를 생성한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO custVO
	 * @exception DAOException
	 */
	public void addCustHist(String custCntCd, String custSeq,  String usrId) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 mapVO.put("usr_id", usrId);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOPrcExecAllCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Code 정보를 생성한다.(ESM_SAM_0302)<br>
	 *  
	 * @param CustomerVO custVO
	 * @exception DAOException
	 */
	public void addCustHistMig(String custCntCd, String custSeq,  String usrId) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 mapVO.put("usr_id", usrId);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOPrcExecCustAllCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Customer Address 정보를 조회 합니다.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @param String addrTpCd
	 * @return List<CustomerAddressVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomerAddressVO> searchCustAddr(String custCntCd, String custSeq,  String addrTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerAddressVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 Map<String, String> mapVO = new HashMap<String, String>();

			 mapVO.put("cust_cnt_cd", custCntCd);
			 mapVO.put("cust_seq", custSeq);
			 mapVO.put("addr_tp_cd", addrTpCd);
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 dbRowset = new SQLExecuter().executeQuery(new CustMainDBDAOSearchCustAddrRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerAddressVO.class);	
			 
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
		 * 유사한 Name으로 등록된 Customer를 조회 합니다.(ESM_SAM_0304)<br>
		 * 
		 * @param String custCntCd
		 * @param String custNm
		 * @param String locCd
		 * @param String custRgstNo
		 * @param String matchRule
		 * @return List<CustomerVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<CustomerVO> searchCustomerListByName(String custCntCd, String custNm, String locCd, String custRgstNo, String matchRule) throws DAOException {
			DBRowSet dbRowset = null;
			List<CustomerVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				 Map<String, String> mapVO = new HashMap<String, String>();
				 log.debug("DBDAO    matchRule========="+custRgstNo);
				 mapVO.put("cust_cnt_cd", custCntCd);
				 mapVO.put("cust_nm", custNm);
				 mapVO.put("loc_cd", locCd);
				 mapVO.put("cust_rgst_no", custRgstNo);
				 mapVO.put("match_rule", matchRule);
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter().executeQuery(new CustMainDBDAOCustomerListByNameRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
				 
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
	 * Customer  정보를 조회 합니다.(ESM_SAM_0302)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CustomerVO searchCustCode(String custCntCd, String custSeq) throws DAOException {
		 					 
		DBRowSet dbRowset = null;
		List<CustomerVO> list = new ArrayList<CustomerVO>();
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
			 
			 dbRowset = new SQLExecuter().executeQuery(new CustMainDBDAOSearchCustCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
			 
			 } catch(SQLException se) {

			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	 
	 /**
		 * Customer  정보를 조회 합니다.(ESM_SAM_0302)<br>
		 * 
		 * @param String custCntCd
		 * @param String custSeq
		 * @return CustomerVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public CustomerVO searchLocSteCode(String locCd) throws DAOException {
			 					 
			DBRowSet dbRowset = null;
			List<CustomerVO> list = new ArrayList<CustomerVO>();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			
			 try{
				 Map<String, String> mapVO = new HashMap<String, String>();

				 mapVO.put("loc_cd", locCd);
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 dbRowset = new SQLExecuter().executeQuery(new CustMainDBDAOSearchLocStateRSQL(), param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomerVO.class);	
				 
				 } catch(SQLException se) {

				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			if (list.size() > 0)
				return list.get(0);
			else
				return null;
		}
	 
	 /**
		 * Customer Contact Point Code 정보를 생성한다.(ESM_SAM_0302)<br>
		 *  
		 * @param CustomerContactVO custCntcVO
		 * @exception DAOException
		 */

		public void addCustCntcCode(CustomerContactVO custCntcVO) throws DAOException, Exception {
			//query parameter ,String usrId
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//parameter Setting
			
			int result = 0;
			try {
				if(custCntcVO != null){
					Map<String, String> mapVO = custCntcVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new CustMainDBDAOAddCustCntcPntCSQL(), param,velParam);
				if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");		
			}

			}catch(SQLException se) 
			{
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} 
			catch(Exception ex) 
			{
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			
		}
	
	/**
	 * CONTINENT 콤보의 목록을 가져온다.<br>
	 * MDM_CONTINENT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchContiCode() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","Conti");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Group Commodity 콤보의 목록을 가져온다.<br>
	 * MDM_GRP_CMDT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchGrpCmdtList() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","GrpCmdt");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Repository Commodity 콤보의 목록을 가져온다.<br>
	 * MDM_REP_CMDT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRepCmdtList() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","RepCmdt");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Rep. Charge Code List 콤보의 목록을 가져온다.<br>
	 * MDM_CONTINENT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRepChgCode() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","RepChg");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 5. Sub Trade Code List 콤보의 목록을 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeCode() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","SubTrade");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 6. Trade Code List 콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeCode() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","Trade");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 7. Container Size Code List 콤보의 목록을 가져온다.<br>
	 * MDM_CNTR_SZ
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrSize() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","CntrSize");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 8. Container Type Code List 콤보의 목록을 가져온다.<br>
	 * MDM_CNTR_TP
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrType() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","CntrType");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 9. Container Type/Size Code List 콤보의 목록을 가져온다.<br>
	 * MDM_CNTR_TP_SZ
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrTypeSize() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","CntrTpSz");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 10. Package Code List 콤보의 목록을 가져온다.<br>
	 * MDM_PCK_TP
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPackage() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","Package");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 11. Office Code List 콤보의 목록을 가져온다.<br>
	 * MDM_ORGANIZATION
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOffice() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			//velParam.put("codeItem","Package");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchOfficeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 12. India State List 콤보의 목록을 가져온다.<br>
	 * MDM_ORGANIZATION
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchIndState() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","IndState");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 13. INTERNATIONAL PHN NO 콤보의 목록을 가져온다.<br>
	 * bkg_hrd_cdg_ctnt
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchIntlPhnNo() throws DAOException {
		DBRowSet dbRowset = new DBRowSet(); // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			velParam.put("codeItem","IntlPhnNo");				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchComCodeListRSQL(), null, velParam);			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Customer 목록조회<br>
	 *
	 * @param  BkgBlNoVO vo
	 * @return List<BlHistVO>
	 * @author Lee NamKyung
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BlHistVO> searchCustHist(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlHistVO> list = null;

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
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CustMainDBDAOSearchCustHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlHistVO.class);
		}catch(SQLException se){
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	 
	 
}