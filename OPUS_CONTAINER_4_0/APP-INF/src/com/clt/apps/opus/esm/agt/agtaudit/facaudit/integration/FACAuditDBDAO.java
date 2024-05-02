/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACAuditDBDAO.java
*@FileTitle : FAC Commission Maintenance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-17
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-01-17 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.facaudit.integration;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.agt.agtaudit.facaudit.basic.FACAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0034Event;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.loggable.LoggableStateFactory;
import com.clt.framework.component.util.loggable.LoggableStatement;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS-AGT에 대한 DB 처리를 담당<br>
 * - OPUS-AGT Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author junghyung kim
 * @see FACAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class FACAuditDBDAO extends DBDAOSupport {

	/**
     * (ESM_AGT_033) FAC Commission Maintenance & Approval 대상리스트를 가져온다.<br>
     * 
     * @param FACCommVO facCommVO
     * @return List<FACCommVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<FACCommVO> searchFACCommList(FACCommVO facCommVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FACCommVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(facCommVO != null){
				Map<String, String> mapVO = facCommVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FACAuditDBDAOSearchFACCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FACCommVO .class);
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
	 * (ESM_AGT_0015) FAC Commission의 정보를 조회.<br>
	 * @param FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO
	 * @return List<FACCommDetailBasicbyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
    public List<FACCommDetailBasicbyBLVO> searchFACCommDetailBasicbyBL(FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO) throws DAOException, Exception {
        List<FACCommDetailBasicbyBLVO> list = null;
        DBRowSet dbRowSet = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity Parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if(facCommDetailBasicbyBLVO != null){
	        	Map<String, String> mapVO = facCommDetailBasicbyBLVO.getColumnValues();
	        	param.putAll(mapVO);
	        	velParam.putAll(mapVO);
        	}
        	dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new FACAuditDBDAOFACCommDetailBasicbyBLRSQL(), param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowSet, FACCommDetailBasicbyBLVO.class);
        }catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        return list;
    }
    
	/**
	 * (ESM_AGT_015) Charge Detail 목록 조회<br>
	 * @param FACCommDetailChargebyBLVO facCommDetailChargebyBLVO
	 * @return List<FACCommDetailChargebyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
    public List<FACCommDetailChargebyBLVO> searchFACCommDetailChargebyBL(FACCommDetailChargebyBLVO facCommDetailChargebyBLVO) throws DAOException, Exception {
       List<FACCommDetailChargebyBLVO> list = null;
       DBRowSet dbRowSet = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{
    	   if(facCommDetailChargebyBLVO != null){
    		   Map<String, String> mapVO = facCommDetailChargebyBLVO.getColumnValues();
    		   param.putAll(mapVO);
    		   velParam.putAll(mapVO);
    	   }
    	   dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new FACAuditDBDAOFACCommDetailChargebyBLRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowSet, FACCommDetailChargebyBLVO.class);
       }catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
       return list;
    }
    
	/**
	 * (ESM_AGT_015) FAC Commission의 History Detail 목록 조회<br>
	 * @param FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO
	 * @return List<FACCommDetailHistorybyBLVO>
	 * @throws DAOException
	 * @throws Exception
	 */
    public List<FACCommDetailHistorybyBLVO> searchFACCommDetailHistorybyBL(FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO) throws DAOException, Exception {
       List<FACCommDetailHistorybyBLVO> list = null;
       DBRowSet dbRowSet = null;
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();
       try{
    	   if(facCommDetailHistorybyBLVO != null){
    		   Map<String, String> mapVO = facCommDetailHistorybyBLVO.getColumnValues();
    		   param.putAll(mapVO);
    		   velParam.putAll(mapVO);
    	   }
    	   dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new FACAuditDBDAOFACCommDetailHistorybyBLRSQL(), param, velParam);
    	   list = (List)RowSetUtil.rowSetToVOs(dbRowSet, FACCommDetailHistorybyBLVO.class);
       }catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
       return list;
    }
    
	/**
     * (ESM_AGT_015) 실제로 Commission 계산한 FAC Agreement 요율 정보를 가져온다.<br>
     * 
     * @param  AGTFACRateInfoVO agtFacRateInfoVO
     * @return List<AGTFACRateInfoVO>
     * @throws DAOException
     */
    public List<AGTFACRateInfoVO> searchAGTFACRateInfo(AGTFACRateInfoVO agtFacRateInfoVO) throws DAOException {
    	List<AGTFACRateInfoVO> list = null;
    	DBRowSet dbRowSet = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try{
    		if(agtFacRateInfoVO != null){
    			Map<String, String> mapVO = agtFacRateInfoVO.getColumnValues();
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    		}
    		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new FACAuditDBDAOAGTFACRateInfoRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AGTFACRateInfoVO.class);
    	}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    	
    	return list;
    	
    }

    /**
     * (ESM_AGT_034) FAC AP Interface 대상리스트를 가져온다.<br>
     * 
     * @param  Event et
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchAPActualInterfaceMasterForFAC(Event et) throws DAOException {
        EsmAgt0034Event event = (EsmAgt0034Event)et;
        
        Connection con = null;			// Connection Interface
        PreparedStatement selectPs1 = null;	// 정적파싱을 지원하는 SQL Statement
        ResultSet rs1 = null;			// DB ResultSet
        DBRowSet dRs = null;			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        String slsOfcCd = "";
        String ifOpt = "";
        
        StringBuffer selectQuery1 = new StringBuffer() ;

        selectQuery1.append("\nSELECT a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') fwdr, ");
        selectQuery1.append("\n       b.cust_lgl_eng_nm fwdr_name, ");
        selectQuery1.append("\n       COUNT(*) bl_cnt, ");
        selectQuery1.append("\n       SUM(ROUND(a.act_if_comm_amt,2)) ttl_amt, ");
        selectQuery1.append("\n       a.ap_ofc_cd, ");
        selectQuery1.append("\n       a.csr_no, ");
        selectQuery1.append("\n       DECODE(d.if_flg,'Y','Success',d.if_err_rsn), ");
        selectQuery1.append("\n       DECODE(d.rcv_err_flg,'Y','Success',d.rcv_err_rsn) ");
        selectQuery1.append("\n  FROM agt_fac_comm a, ");
        selectQuery1.append("\n       mdm_customer b, ");
        selectQuery1.append("\n       agt_comm_bkg_info c, ");
        selectQuery1.append("\n       ap_inv_hdr d ");
        selectQuery1.append("\n WHERE a.sls_ofc_cd = ? ");	//:sls_ofc_cd
        selectQuery1.append("\n   AND (('BF' = ? AND a.comm_proc_sts_cd IN('CS','CM','CA')) OR ");	//:ifOpt
        selectQuery1.append("\n        ('NC' = ? AND a.comm_proc_sts_cd IN('CE','IC')) OR ");	//:ifOpt
        selectQuery1.append("\n        ('IF' = ? AND a.comm_proc_sts_cd IN('IF'))) ");	//:ifOpt
        selectQuery1.append("\n   AND NVL(a.agn_div_flg,'N') = 'Y' ");
        selectQuery1.append("\n   AND a.frt_fwrd_cnt_cd = b.cust_cnt_cd ");
        selectQuery1.append("\n   AND a.frt_fwrd_seq = b.cust_seq ");
        selectQuery1.append("\n   AND a.bkg_no = c.bkg_no ");
        selectQuery1.append("\n   AND a.bkg_no_split = c.bkg_no_split ");
        selectQuery1.append("\n   AND a.csr_no = d.csr_no(+) ");
        selectQuery1.append("\n GROUP BY a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000'), ");
        selectQuery1.append("\n          b.cust_lgl_eng_nm, a.ap_ofc_cd, a.csr_no, ");
        selectQuery1.append("\n          DECODE(d.if_flg,'Y','Success',d.if_err_rsn), ");
        selectQuery1.append("\n          DECODE(d.rcv_err_flg,'Y','Success',d.rcv_err_rsn) ");
        selectQuery1.append("\n ORDER BY 1 ");

        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            } else {
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
            }
            
            //변수값 설정
            slsOfcCd = event.getString("cbOfcCd");
            ifOpt = event.getString("ifOpt");
            
            
            // 쿼리에 변수 세팅. 
            i = 1;
            selectPs1.setString(i++, slsOfcCd);
            selectPs1.setString(i++, ifOpt);
            selectPs1.setString(i++, ifOpt);
            selectPs1.setString(i++, ifOpt);
            
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.info("\n [searchAPActualInterfaceMasterForFAC]SQL1 ::\n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [searchAPActualInterfaceMasterForFAC]SQL1 :\n" + selectQuery1.toString() );
            }
            rs1 = selectPs1.executeQuery();
            
            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs1);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeResultSet(rs1);
            closeStatement(selectPs1);
            closeConnection(con);
        }
        
        return dRs;
    }

	/**
     * (ESM_AGT_018) Brokerage AP Interface 대상리스트를 가져온다.<br>
     * 
     * @param  Event et
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchAPActualInterfaceDetailForFAC(Event et) throws DAOException {
        EsmAgt0034Event event = (EsmAgt0034Event)et;
        
        Connection con = null;			// Connection Interface
        PreparedStatement selectPs1 = null;	// 정적파싱을 지원하는 SQL Statement
        ResultSet rs1 = null;			// DB ResultSet
        DBRowSet dRs = null;			// 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int i = 1;						// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        String slsOfcCd = "";
        String ifOpt = "";
        String fwdr = "";
        String csrNo = "";
        
        ifOpt = event.getString("ifOpt");
        
        StringBuffer selectQuery1 = new StringBuffer() ;
        
        selectQuery1.append("\nSELECT c.bl_no||c.bl_no_tp||c.bl_no_chk, ");
        selectQuery1.append("\n       ROUND(a.act_if_comm_amt,2), ");
        selectQuery1.append("\n       DECODE(SUBSTR(a.fac_div_cd,1,1),'B','Rate','CNTR'), ");
        selectQuery1.append("\n       a.fac_bkg_rt, ");
        selectQuery1.append("\n       a.bkg_no, ");
        selectQuery1.append("\n       a.bkg_no_split, ");
        selectQuery1.append("\n       a.fac_seq ");
        selectQuery1.append("\n  FROM agt_fac_comm a, ");
        selectQuery1.append("\n       mdm_customer b, ");
        selectQuery1.append("\n       agt_comm_bkg_info c ");
        selectQuery1.append("\n WHERE a.sls_ofc_cd = ? ");	//sls_ofc_cd
        if(ifOpt.equals("IF")) selectQuery1.append("\n   AND a.csr_no = ? ");	//:csrNo
        selectQuery1.append("\n   AND (('BF' = ? AND a.comm_proc_sts_cd IN('CS','CM','CA')) OR ");	//:ifOpt
        selectQuery1.append("\n        ('NC' = ? AND a.comm_proc_sts_cd IN('CE','IC')) OR ");	//:ifOpt
        selectQuery1.append("\n        ('IF' = ? AND a.comm_proc_sts_cd IN('IF'))) ");	//:ifOpt
        selectQuery1.append("\n   AND a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') = ? ");	//:fwdr
        selectQuery1.append("\n   AND NVL(a.agn_div_flg,'N') = 'Y' ");
        selectQuery1.append("\n   AND a.frt_fwrd_cnt_cd = b.cust_cnt_cd ");
        selectQuery1.append("\n   AND a.frt_fwrd_seq = b.cust_seq ");
        selectQuery1.append("\n   AND a.bkg_no = c.bkg_no ");
        selectQuery1.append("\n   AND a.bkg_no_split = c.bkg_no_split ");
        selectQuery1.append("\n ORDER BY 1 ");

        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            } else {
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
            }
            
            
            //변수값 설정
            slsOfcCd = event.getString("cbOfcCd");
            fwdr = event.getString("param1");
            csrNo = event.getString("param2");
            
            
            // 쿼리에 변수 세팅. 
            i = 1;
            selectPs1.setString(i++, slsOfcCd);
            if(ifOpt.equals("IF")) selectPs1.setString(i++, csrNo);
            selectPs1.setString(i++, ifOpt);
            selectPs1.setString(i++, ifOpt);
            selectPs1.setString(i++, ifOpt);
            selectPs1.setString(i++, fwdr);
            
            // Loggable Statement 사용에 의해 추가 
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
                log.info("\n [searchAPActualInterfaceDetailForFAC]SQL1 ::\n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [searchAPActualInterfaceDetailForFAC]SQL1 :\n" + selectQuery1.toString() );
            }
            rs1 = selectPs1.executeQuery();
            
            // 결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs1);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        } finally {
            closeResultSet(rs1);
            closeStatement(selectPs1);
            closeConnection(con);
        }
        
        return dRs;
    }

   	/**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  Event et
     * @return HashMap CSR No를 담은 HashMap 
     * @throws DAOException
     */
    /*
    public HashMap createFACCSRHeader(Event et) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // INSERT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs4 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs5 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs6 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs7 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs8 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs9 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // INSERT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs2 = null; // INSERT를 수행하기 위한 SQL Statement
        
        ResultSet rs1 = null;	// DB ResultSet
        ResultSet rs2 = null;	// DB ResultSet
        ResultSet rs3 = null;	// DB ResultSet
        ResultSet rs4 = null;	// DB ResultSet
        ResultSet rs5 = null;	// DB ResultSet
        ResultSet rs6 = null;	// DB ResultSet
        ResultSet rs7 = null;	// DB ResultSet
        ResultSet rs8 = null;	// DB ResultSet
        ResultSet rs9 = null;	// DB ResultSet
        //DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String slsOfcCd = "";
        String localDt = "";
        String invDt = "";
        String termDt = "";
        String glDt = "";
        String csrPartNo = "";
        int    vndr = 0;
        String apOfcCd = "";
        String csrNo = "";
        String termNm = "";
        float  csrAmt = 0;
        String[] fwdr = null;	//Grid에서 선택한 F.Forwarder
        String facVal = "?";	//Grid에서 선택한 Row의 건수만큼 PS의 바인딩변수를 생성
        String payMzdLuCd = "";
        String payGrpLuCd = "";
        String coaRgnCd = "";
        String coaCtrCd = "";
        String userId = "";	//event
        String userNm = "";	//event
        String userEm = "";
        //String csrTpCd = "STANDARD";
        String srcCtnt = "FAC";
        String invDesc = "FAC/Brokerage";
        String attrCateNm = "Invoices";
        String attrCtnt1 = null;	//EP 결재자명(일단 NULL)
        HashMap rtnHash = null; 
        
        String bkg_no = "";
        String bkg_no_split = "";
        int fac_seq = 0;
        double act_if_comm_amt = 0;
        double act_if_locl_comm_amt = 0;
        double act_usd_comm_amt = 0;
        double act_locl_comm_amt = 0;
        
        fwdr = event.getObject("fwdr");
        for(int j=1; j<fwdr.length; j++){facVal = facVal + ", ?";}
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        StringBuffer selectQuery3 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        StringBuffer selectQuery4 = new StringBuffer();
        StringBuffer selectQuery5 = new StringBuffer();
        StringBuffer selectQuery6 = new StringBuffer();
        StringBuffer selectQuery7 = new StringBuffer();
        StringBuffer selectQuery8 = new StringBuffer();
        StringBuffer selectQuery9 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer insertQuery2 = new StringBuffer();
        
        
        ////1.GET LOCAL_DATE, INVOICE DATE, TERM_DATE, GL_DATE
        selectQuery1.append("\nSELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd ),'YYYYMMDDHH24MISS') ");
        selectQuery1.append("\n  FROM mdm_organization ");
        selectQuery1.append("\n WHERE ofc_cd = ? ");	//:slsOfcCd
        selectQuery1.append("\n   AND ROWNUM = 1 ");
        
        ////2.GET CSR_PART_NO, F.FORWARDER, VENDOR, AP_OFC_CD, FINC_RGN_CD
        selectQuery2.append("\nSELECT '08'||'S'||ap_ofc||SUBSTR(?,3,6) csr_part_no, ");	//:local_date
        selectQuery2.append("\n       fwdr, vndr, ap_ofc, finc_rgn_cd ");
        selectQuery2.append("\n  FROM (SELECT DISTINCT a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') fwdr, ");
        selectQuery2.append("\n               a.vndr_seq vndr, a.ap_ofc_cd ap_ofc, b.finc_rgn_cd ");
        selectQuery2.append("\n          FROM agt_fac_comm a, mdm_organization b ");
        selectQuery2.append("\n         WHERE a.comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery2.append("\n           AND a.fac_if_dt IS NULL ");
        selectQuery2.append("\n           AND a.sls_ofc_cd = ? ");	//:sls_ofc
        selectQuery2.append("\n           AND a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");	//:fwdr
        selectQuery2.append("\n           AND NVL(a.agn_div_flg,'N') = 'Y' ");
        selectQuery2.append("\n           AND a.ap_ofc_cd = b.ofc_cd ");
        selectQuery2.append("\n           AND (a.bkg_no, a.bkg_no_split, a.fac_seq) IN  ");
        selectQuery2.append("\n               (SELECT bkg_no, bkg_no_split, MAX(fac_seq) ");
        selectQuery2.append("\n                  FROM agt_fac_comm ");
        selectQuery2.append("\n                 WHERE comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery2.append("\n                   AND fac_if_dt IS NULL ");
        selectQuery2.append("\n                   AND a.sls_ofc_cd = ? ");	//:sls_ofc
        selectQuery2.append("\n                   AND NVL(agn_div_flg,'N') = 'Y' ");
        selectQuery2.append("\n                 GROUP BY bkg_no, bkg_no_split) ");
        selectQuery2.append("\n           AND ROWNUM = 1 ");
        selectQuery2.append("\n       )  ");
        
        ////3.GET CSR_NO
        selectQuery3.append("\nSELECT ?||TO_CHAR(ser,'FM00000') ");	//:csr_part_no
        selectQuery3.append("\n  FROM (SELECT NVL(MAX(TO_NUMBER(SUBSTR(csr_no,LENGTH(csr_no)-4)))+1,1) ser ");        
        selectQuery3.append("\n          FROM ap_csr_no ");
        selectQuery3.append("\n         WHERE csr_no like '%'||SUBSTR(?,3,6)||'%') ");	//:local_date
		
        ////4.AP_CSR_NO INSERT
        insertQuery1.append("\nINSERT INTO ap_csr_no(csr_no, cre_usr_id, cre_dt) ");
        insertQuery1.append("\nVALUES(?, 'BRKG/FAC', SYSDATE) ");	//:csr_no
        
        ////5.GET VNDR_TERM_NM
        selectQuery4.append("\nSELECT gen_pay_term_cd "); 
        selectQuery4.append("\n  FROM mdm_vendor ");
        selectQuery4.append("\n WHERE vndr_seq = ? ");	//:vndr_seq
        
        //5.1 GET LOCAL COMM AMOUNT
        selectQuery8.append("\nSELECT  a.bkg_no, a.bkg_no_split, a.fac_seq,  a.act_if_comm_amt, a.act_if_locl_comm_amt ");       
        selectQuery8.append("\n  FROM agt_fac_comm a ");
        selectQuery8.append("\n WHERE a.comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery8.append("\n   AND a.fac_if_dt IS NULL ");
        selectQuery8.append("\n   AND NVL(a.agn_div_flg,'N') = 'Y' ");
        selectQuery8.append("\n   AND a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");
        
        // 5.2 GET LOCAL DETAIL AMOUNT
        selectQuery9.append("\nSELECT SUM(a.act_usd_comm_amt) act_usd_comm_amt, SUM(a.act_locl_comm_amt) act_locl_comm_amt ");       
        selectQuery9.append("\n  FROM agt_fac_comm_dtl a ");
        selectQuery9.append("\n WHERE a.bkg_no = ? ");
        selectQuery9.append("\n   AND a.bkg_no_split = ? ");
        selectQuery9.append("\n   AND a.fac_seq = ? ");        
        
        // 5.3 UPDATE agt_agn_comm_dtl 
		updateQuery1.append("\nUPDATE agt_fac_comm_dtl ");
		updateQuery1.append("\n   SET act_usd_comm_amt = act_usd_comm_amt + (? - ?) ");
		updateQuery1.append("\n     , act_locl_comm_amt = act_locl_comm_amt + (? - ?) ");
		updateQuery1.append("\n WHERE bkg_no = ? ");
		updateQuery1.append("\n   AND bkg_no_split = ? ");
		updateQuery1.append("\n   AND fac_seq = ? ");
		updateQuery1.append("\n   AND cntr_tpsz_cd = (select cntr_tpsz_cd from bkg_bkg_qty where bkg_no = ? and bkg_no_split = ? and rownum = 1) ");
        
        ////6.GET CSR_AMOUNT
        selectQuery5.append("\nSELECT SUM(ROUND(act_if_comm_amt,2)) ");
        selectQuery5.append("\n  FROM agt_fac_comm ");
        selectQuery5.append("\n WHERE comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery5.append("\n   AND fac_if_dt IS NULL ");
        selectQuery5.append("\n   AND NVL(agn_div_flg,'N') = 'Y' ");
        selectQuery5.append("\n   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");
        
        ////7.GET PAY_MZD_LU_CD, PAY_GRP_LU_CD
        selectQuery6.append("\nSELECT DECODE(b.conti_cd,'M','CMS CHECK(O/EXP)','E','CMS WIRE','WIRE'), ");
        selectQuery6.append("\n       a.ap_ofc_cd||'_O/EXP' ");
        selectQuery6.append("\n  FROM mdm_organization a, mdm_location b ");
        selectQuery6.append("\n WHERE a.ofc_cd = ? ");	//:ap_ofc_cd
        selectQuery6.append("\n   AND a.loc_cd = b.loc_cd ");
         
        ////8.GET COA_RGN_CD, COA_CTR_CD
        selectQuery7.append("\nSELECT NVL(finc_rgn_cd,'00'), ap_ctr_cd ");
        selectQuery7.append("\n  FROM mdm_organization ");
        selectQuery7.append("\n WHERE ofc_cd = ? ");	//:ap_ofc_cd
        selectQuery7.append("\n   AND NVL(delt_flg,'N') = 'N' ");
         
        ////9.AP_INV_HDR INSERT
        insertQuery2.append("\nINSERT INTO ap_inv_hdr ");
        insertQuery2.append("\n      (csr_no, csr_tp_cd, inv_dt, inv_term_dt, gl_dt, vndr_no, csr_amt, "); 					//1
        insertQuery2.append("\n       pay_amt, pay_dt, csr_curr_cd, vndr_term_nm, inv_desc, attr_cate_nm, "); 				//2
        insertQuery2.append("\n       attr_ctnt1, attr_ctnt2, attr_ctnt3, attr_ctnt4, attr_ctnt5, "); 						//3
        insertQuery2.append("\n       attr_ctnt6, attr_ctnt7, attr_ctnt8, attr_ctnt9, attr_ctnt10, "); 						//4
        insertQuery2.append("\n       attr_ctnt11, attr_ctnt12, attr_ctnt13, attr_ctnt14, attr_ctnt15, "); 					//5
        insertQuery2.append("\n       glo_attr_ctnt1, glo_attr_ctnt2, glo_attr_ctnt3, glo_attr_ctnt4, glo_attr_ctnt5, "); 	//6
        insertQuery2.append("\n       glo_attr_ctnt6, glo_attr_ctnt7, glo_attr_ctnt8, glo_attr_ctnt9, glo_attr_ctnt10, "); 	//7
        insertQuery2.append("\n       glo_attr_ctnt11, glo_attr_ctnt12, glo_attr_ctnt13, glo_attr_ctnt14, glo_attr_ctnt15, "); //8
        insertQuery2.append("\n       glo_attr_ctnt16, glo_attr_ctnt17, glo_attr_ctnt18, "); 								//9
        insertQuery2.append("\n       src_ctnt, pay_mzd_lu_cd, pay_grp_lu_cd, coa_co_cd, coa_rgn_cd, coa_ctr_cd, "); 		//10
        insertQuery2.append("\n       coa_acct_cd, coa_vvd_cd, coa_inter_co_cd, coa_ftu_n1st_cd, coa_ftu_n2nd_cd, "); 		//11
        insertQuery2.append("\n       ppd_no, ppd_dtrb_no, ppd_aply_amt, ppd_gl_dt, apro_flg, tax_decl_flg, err_csr_no, "); //12
        insertQuery2.append("\n       if_flg, if_dt, if_err_rsn, ppay_aply_flg, tj_ofc_cd, act_xch_rt, imp_err_flg, "); 	//13
        insertQuery2.append("\n       rcv_err_flg, tax_curr_xch_flg, usr_eml, imp_err_rsn, rcv_err_rsn, "); 				//14
        insertQuery2.append("\n       ftu_use_ctnt1, ftu_use_ctnt2, ftu_use_ctnt3, ftu_use_ctnt4, ftu_use_ctnt5, "); 		//15
        insertQuery2.append("\n       cre_dt, cre_usr_id, eai_evnt_dt) "); 													//16
        insertQuery2.append("\nVALUES(?, DECODE(SIGN(?),-1,'CREDIT','STANDARD'), ?, ?, ?, ?, ?, "); //1
        insertQuery2.append("\n       0, NULL, 'USD', ?, ?, ?, "); 							//2
        insertQuery2.append("\n       ?, NULL, NULL, NULL, NULL, "); 						//3
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, ?, "); 						//4
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, NULL, "); 					//5
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, NULL, "); 					//6
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, NULL, "); 					//7
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, NULL, ");	 					//8
        insertQuery2.append("\n       NULL, NULL, NULL, "); 								//9
        insertQuery2.append("\n       ?, ?, ?, '01', ?, ?, "); 								//10
        insertQuery2.append("\n       '210111', '0000000000', '00', '000000', '000000', "); //11
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, 'Y', 'N', NULL, "); 			//12
        insertQuery2.append("\n       NULL, NULL, NULL, 'N', ?, NULL, NULL, "); 			//13
        insertQuery2.append("\n       NULL, NULL, ?, NULL, NULL, "); 						//14
        insertQuery2.append("\n       NULL, NULL, NULL, NULL, NULL, "); 					//15
        insertQuery2.append("\n       SYSDATE, ?, SYSDATE) "); 								//16

        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            	selectPs2 = new LoggableStatement(con, selectQuery2.toString());
                selectPs3 = new LoggableStatement(con, selectQuery3.toString());
                insertPs1 = new LoggableStatement(con, insertQuery1.toString());
                selectPs4 = new LoggableStatement(con, selectQuery4.toString());
                selectPs5 = new LoggableStatement(con, selectQuery5.toString());
                selectPs6 = new LoggableStatement(con, selectQuery6.toString());
                selectPs7 = new LoggableStatement(con, selectQuery7.toString());
                selectPs8 = new LoggableStatement(con, selectQuery8.toString());
                selectPs9 = new LoggableStatement(con, selectQuery9.toString());
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
                insertPs2 = new LoggableStatement(con, insertQuery2.toString());
            } else {
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
            	selectPs2 = con.prepareStatement(selectQuery2.toString());
                selectPs3 = con.prepareStatement(selectQuery3.toString());
                insertPs1 = con.prepareStatement(insertQuery1.toString());
                selectPs4 = con.prepareStatement(selectQuery4.toString());
                selectPs5 = con.prepareStatement(selectQuery5.toString());
                selectPs6 = con.prepareStatement(selectQuery6.toString());
                selectPs7 = con.prepareStatement(selectQuery7.toString());
                selectPs8 = con.prepareStatement(selectQuery8.toString());
                selectPs9 = con.prepareStatement(selectQuery9.toString());
                updatePs1 = con.prepareStatement(updateQuery1.toString());
                insertPs2 = con.prepareStatement(insertQuery2.toString());
            }
            
            ////변수값 세팅
            slsOfcCd = event.getString("cbOfcCd");
            userId = event.getUserId();
            userNm = event.getUserNm();
            userEm = event.getUserEml();
            ////변수값 세팅.끝
            

            ////1.GET LOCAL_DATE, INVOICE_DATE, TERM_DATE, GL_DATE
            i = 1;
            selectPs1.setString(i++, slsOfcCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL1 :::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
            while (rs1.next()) {
				localDt = rs1.getString(1);
				invDt = localDt.substring(0,8);
				termDt = localDt.substring(0,8);
				glDt = localDt.substring(0,8);
			}
            
            
            ////2.GET CSR_PART_NO, F.FORWARDER, VENDOR, AP_OFC_CD, FINC_RGN_CD
            i = 1;
            selectPs2.setString(i++, localDt);
            selectPs2.setString(i++, slsOfcCd);
            for(int j=0; j<fwdr.length; j++){selectPs2.setString(i++, fwdr[j]);}
            selectPs2.setString(i++, slsOfcCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL2 :::: \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL2 : \n" + selectQuery2.toString() );
            }            
            rs2 = selectPs2.executeQuery();
            
            while (rs2.next()) {
            	csrPartNo = rs2.getString(1);
            	vndr = rs2.getInt(3);
            	apOfcCd = rs2.getString(4);
            }
            	
            	
        	////3.GET CSR_NO
            i = 1;
            selectPs3.setString(i++, csrPartNo);
            selectPs3.setString(i++, localDt);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL3 :::: \n" + ((LoggableStatement)selectPs3).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL3 : \n" + selectQuery3.toString() );
            }            
            rs3 = selectPs3.executeQuery();
            
            while (rs3.next()) {
				csrNo = rs3.getString(1);
			}
		
        
            ////4.AP_CSR_NO INSERT
        	i = 1;
        	insertPs1.setString(i++, csrNo);
        	
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Insert SQL1 :::: \n" + ((LoggableStatement)insertPs1).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Insert SQL1 : \n" + insertQuery1.toString() );
            }            
            insertPs1.execute();
        
        
            ////5.GET VNDR_TERM_NM
            i = 1;
            selectPs4.setInt(i++, vndr);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL4 :::: \n" + ((LoggableStatement)selectPs4).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL4 : \n" + selectQuery4.toString() );
            }            
            rs4 = selectPs4.executeQuery();
            
        	while (rs4.next()) {
				termNm = rs4.getString(1);
			}
        	
        	
			// 5.1 GET LOCAL COMM AMOUNT
            i = 1;
            for(int j=0; j<fwdr.length; j++){selectPs8.setString(i++, fwdr[j]);}
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createAGTCSRHeader]Select SQL7 : \n" + ((LoggableStatement)selectPs8).getQueryString());
            } else {
                log.info("\n [createAGTCSRHeader]Select SQL7 : \n" + selectQuery8.toString() );
            }            
            rs8 = selectPs8.executeQuery();
            
			while (rs8.next()) {
				bkg_no = rs8.getString("bkg_no");
				bkg_no_split = rs8.getString("bkg_no_split");
				fac_seq = rs8.getInt("fac_seq");
				act_if_comm_amt = rs8.getDouble("act_if_comm_amt");
				act_if_locl_comm_amt = rs8.getDouble("act_if_locl_comm_amt");
				
				// 5.2 GET LOCAL DETAIL AMOUNT
	            i = 1;
	            selectPs9.setString(i++, bkg_no);
	            selectPs9.setString(i++, bkg_no_split);
	            selectPs9.setInt(i++, fac_seq);
	            
	            //Loggable Statement 사용에 의해 추가
	            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
	                log.info("\n [createAGTCSRHeader]Select SQL7 : \n" + ((LoggableStatement)selectPs9).getQueryString());
	            } else {
	                log.info("\n [createAGTCSRHeader]Select SQL7 : \n" + selectQuery9.toString() );
	            }            
	            rs9 = selectPs9.executeQuery();
	            
				if(rs9.next()) {
					act_usd_comm_amt = rs9.getDouble("act_usd_comm_amt");
					act_locl_comm_amt  = rs9.getDouble("act_locl_comm_amt");
				}
				closeResultSet(rs9);
				
				if(((act_if_comm_amt - act_usd_comm_amt) != 0) || ((act_if_locl_comm_amt - act_locl_comm_amt) != 0)){
			        
					// 5.3 AGT_AGN_COMM UPDATE
		        	i = 1;
		        	updatePs1.setDouble(i++, act_if_comm_amt);
		        	updatePs1.setDouble(i++, act_usd_comm_amt);
		        	updatePs1.setDouble(i++, act_if_locl_comm_amt);
		        	updatePs1.setDouble(i++, act_locl_comm_amt);
		        	updatePs1.setString(i++, bkg_no);
		        	updatePs1.setString(i++, bkg_no_split);
		        	updatePs1.setInt(i++, fac_seq);
		        	updatePs1.setString(i++, bkg_no);
		        	updatePs1.setString(i++, bkg_no_split);
		        	
		            // Loggable Statement 사용에 의해 추가
		            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
		                log.info("\n [createAGTCSRHeader]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
		            } else {
		                log.info("\n [createAGTCSRHeader]Update SQL1 : \n" + updateQuery1.toString() );
		            }            
		            updatePs1.executeUpdate();
					  
				}				
				
			}
			
        	
        	////6.GET CSR_AMOUNT           	
        	i = 1;
        	for(int j=0; j<fwdr.length; j++){selectPs5.setString(i++, fwdr[j]);}
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL5 :::: \n" + ((LoggableStatement)selectPs5).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL5 : \n" + selectQuery5.toString() );
            }            
            rs5 = selectPs5.executeQuery();
            
        	while (rs5.next()) {
        		csrAmt = rs5.getFloat(1);
			}
			
        	
            ////7.GET PAY_MZD_LU_CD, PAY_GRP_LU_CD
        	i = 1;
            selectPs6.setString(i++, apOfcCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL6 :::: \n" + ((LoggableStatement)selectPs6).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL6 : \n" + selectQuery6.toString() );
            }            
            rs6 = selectPs6.executeQuery();
            
        	while (rs6.next()) {
		        payMzdLuCd = rs6.getString(1);
		        payGrpLuCd = rs6.getString(2);
			}
			
        	
            ////8.GET COA_RGN_CD, COA_CTR_CD
            i = 1;
            selectPs7.setString(i++, apOfcCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Select SQL7 :::: \n" + ((LoggableStatement)selectPs7).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Select SQL7 : \n" + selectQuery7.toString() );
            }            
            rs7 = selectPs7.executeQuery();
            
        	while (rs7.next()) {
				coaRgnCd = rs7.getString(1);
				coaCtrCd = rs7.getString(2);
			}
		
        	
            ////9.AP_INV_HDR INSERT
        	i = 1;
        	insertPs2.setString(i++, csrNo);
        	insertPs2.setFloat(i++, csrAmt);
        	insertPs2.setString(i++, invDt);
        	insertPs2.setString(i++, termDt);
        	insertPs2.setString(i++, glDt);
        	insertPs2.setString(i++, Integer.toString(vndr));
        	insertPs2.setFloat(i++, csrAmt);
        	insertPs2.setString(i++, termNm);
        	insertPs2.setString(i++, invDesc);
        	insertPs2.setString(i++, attrCateNm);
        	insertPs2.setString(i++, attrCtnt1);
        	insertPs2.setString(i++, userNm);
        	insertPs2.setString(i++, srcCtnt);
        	insertPs2.setString(i++, payMzdLuCd);
        	insertPs2.setString(i++, payGrpLuCd);
        	insertPs2.setString(i++, coaRgnCd);
        	insertPs2.setString(i++, coaCtrCd);
        	insertPs2.setString(i++, apOfcCd);
        	insertPs2.setString(i++, userEm);
        	insertPs2.setString(i++, userId);
        	
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRHeader]Insert SQL2 :::: \n" + ((LoggableStatement)insertPs2).getQueryString());
            } else {
                log.info("\n [createFACCSRHeader]Insert SQL2 : \n" + insertQuery2.toString() );
            }            
            insertPs2.execute();
            
            
            //CSR_NO, VENDOR_SEQ, AP_OFC_CD를 HashMap에 담는다.
            rtnHash = new HashMap();
            rtnHash.put("csrNo", csrNo);
            //rtnHash.put("vndr",  Integer.toString(vndr));
            //rtnHash.put("apOfc", apOfcCd);
            
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeResultSet(rs3);
        	closeResultSet(rs4);
        	closeResultSet(rs5);
        	closeResultSet(rs6);
        	closeResultSet(rs7);
        	closeResultSet(rs8);
        	closeResultSet(rs9);
        	closeStatement(selectPs1);
            closeStatement(selectPs2);
            closeStatement(selectPs3);
            closeStatement(insertPs1);
            closeStatement(selectPs4);
            closeStatement(selectPs5);
            closeStatement(selectPs6);
            closeStatement(selectPs7);
            closeStatement(selectPs8);
            closeStatement(selectPs9);
            closeStatement(updatePs1);
            closeStatement(insertPs2);
            closeConnection(con);
        }
        
        return rtnHash;
    }
    */
	/**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  Event et
     * @param  HashMap paramHash
     * @return DBRowSet
     * @throws DAOException
     */
    /*
    public DBRowSet createFACCSRDistribution(Event et, HashMap paramHash) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs4 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // INSERT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        
        ResultSet rs1 = null;	// DB ResultSet
        ResultSet rs2 = null;	// DB ResultSet
        ResultSet rs3 = null;	// DB ResultSet
        ResultSet rs4 = null;	// DB ResultSet
        DBRowSet dRs = null;	// DB DBRowSet
        int i = 1;				// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "";		//event
        String slsOfcCd = "";	//event
        String csrNo  = "";
        String regionCd  = "";
        String centerCd  = "";
        String vvdCd 	 = "";
        String accountCd = "";
        String vvdLevel  = "";
        String vvdFlag   = "";
        String[] fwdr = null;	//Grid에서 선택한 F.Forwarder
        String facVal = "?";	//Grid에서 선택한 Row의 건수만큼 PS의 바인딩변수를 생성
        
        fwdr = event.getObject("fwdr");
        for(int j=1; j<fwdr.length; j++){facVal = facVal + ", ?";}
                
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        StringBuffer selectQuery3 = new StringBuffer();
        StringBuffer selectQuery4 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        
        
        ////1.GET AP_INV_DSTR 
        selectQuery1.append("\n SELECT y.csr_no, ");
        selectQuery1.append("\n       ROW_NUMBER() OVER(ORDER BY x.att1, x.company, x.region, x.center, x.acct, x.vvd) line_seq, ");
    	selectQuery1.append("\n       DENSE_RANK() OVER(ORDER BY x.att1, x.company, x.region, x.center, x.acct, x.vvd) line_number, ");
        selectQuery1.append("\n       x.lookup, x.inv_amt, x.inv_desc, x.tax_cd, x.company, x.region, x.center, ");
        selectQuery1.append("\n       x.acct, x.vvd, x.inter_company, x.future1, x.future2, x.att_ctlg, ");
        selectQuery1.append("\n       x.att1, x.att2, x.att3, x.att4, x.att5, x.att6, x.att7, x.att8, x.att9, x.att10, ");
        selectQuery1.append("\n       x.att11, x.att12, x.att13, x.att14, x.att15, x.bkg_no, x.bkg_no_split, ");
        selectQuery1.append("\n       x.tpsz, x.rev_vvd, x.div_cd, x.carrier, x.yard, x.cost_code, x.qty, x.tmnl_cd, x.agnt, x.sub_flg ");
        selectQuery1.append("\n  FROM (SELECT a.vndr_seq vndr, ");
        selectQuery1.append("\n               'ITEM' lookup, ");
        selectQuery1.append("\n               ROUND(NVL(b.act_locl_comm_amt,a.act_if_comm_amt),2) inv_amt, ");
        selectQuery1.append("\n               'FAC/Brokerage' inv_desc, ");
        selectQuery1.append("\n               '' tax_cd, ");
        selectQuery1.append("\n               '01' company, ");
        selectQuery1.append("\n               NVL((SELECT finc_rgn_cd FROM mdm_organization WHERE ofc_cd = a.ap_ofc_cd),'00') region, ");
        selectQuery1.append("\n               (SELECT ap_ctr_cd FROM mdm_organization WHERE ofc_cd = a.ap_ofc_cd) center, a.comm_stnd_cost_cd acct, ");
        selectQuery1.append("\n        	      DECODE(a.comm_slan_cd||SUBSTR(a.comm_vsl_cd,0,2),'RBCFD','CFDR'||SUBSTR(a.comm_vsl_cd,3,2)||SUBSTR(comm_skd_voy_no,0,2)||'EE', ");
        selectQuery1.append("\n                      a.comm_vsl_cd||a.comm_skd_voy_no||a.comm_skd_dir_cd||NVL(a.comm_rev_dir_cd,a.comm_skd_dir_cd)) vvd, ");
        selectQuery1.append("\n               (SELECT NVL(LTRIM(subs_co_cd),'00') FROM mdm_vendor WHERE vndr_seq = a.vndr_seq) inter_company, ");
        selectQuery1.append("\n               '000000' future1, ");
        selectQuery1.append("\n               '000000' future2, ");
        selectQuery1.append("\n               a.comm_stnd_cost_cd att_ctlg, ");
        selectQuery1.append("\n               a.bkg_no||REPLACE(a.bkg_no_split,' ','#')||SUBSTR(TO_CHAR(a.fac_seq,'FM000000'),5,6) att1, ");
        selectQuery1.append("\n               TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,a.comm_occr_info_cd),'YYYYMMDD') att2, ");
        selectQuery1.append("\n               a.comm_occr_info_cd att3, ");
        selectQuery1.append("\n               '' att4, '' att5, '' att6, '' att7, '' att8, '' att9, '' att10,  ");
        selectQuery1.append("\n               '' att11, '' att12, '' att13, '' att14, '' att15, ");
        selectQuery1.append("\n               a.bkg_no, ");
        selectQuery1.append("\n               a.bkg_no_split, ");
        selectQuery1.append("\n               b.cntr_tpsz_cd tpsz, ");
        selectQuery1.append("\n               NVL((SELECT DECODE(SUBSTR(rev_vvd_cd,0,2),'FD','CFDR'||SUBSTR(rev_vvd_cd,3,4)||'EE',rev_vvd_cd) FROM agt_comm_bkg_info WHERE bkg_no = a.bkg_no AND bkg_no_split = a.bkg_no), ");
        selectQuery1.append("\n                   DECODE(a.comm_slan_cd||SUBSTR(a.comm_vsl_cd,0,2),'RBCFD','CFDR'||SUBSTR(a.comm_vsl_cd,3,2)||SUBSTR(comm_skd_voy_no,0,2)||'EE',a.comm_vsl_cd||a.comm_skd_voy_no||a.comm_skd_dir_cd||a.comm_rev_dir_cd)) rev_vvd, ");
        selectQuery1.append("\n               'C' div_cd, ");
        selectQuery1.append("\n               '' carrier, ");
        selectQuery1.append("\n               '' yard, ");
        selectQuery1.append("\n               '' cost_code, ");
        selectQuery1.append("\n               b.bkg_vol_qty qty, ");
        selectQuery1.append("\n               '' tmnl_cd, ");
        selectQuery1.append("\n               '' agnt, ");
        selectQuery1.append("\n               'N' sub_flg ");
        selectQuery1.append("\n          FROM agt_fac_comm a, agt_fac_comm_dtl b ");
        selectQuery1.append("\n         WHERE NVL(a.agn_div_flg,'N') = 'Y' ");
        selectQuery1.append("\n           AND a.fac_if_dt IS NULL ");
        selectQuery1.append("\n           AND a.comm_proc_sts_cd IN('CS','CM','CA') ");
        selectQuery1.append("\n           AND a.sls_ofc_cd = ? ");	//:sls_ofc
        selectQuery1.append("\n           AND a.frt_fwrd_cnt_cd||TO_CHAR(a.frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");	//:fwdr
        selectQuery1.append("\n           AND a.bkg_no = b.bkg_no(+) ");
        selectQuery1.append("\n           AND a.bkg_no_split = b.bkg_no_split(+) ");
        selectQuery1.append("\n           AND a.fac_seq = b.fac_seq(+) ");
        selectQuery1.append("\n       ) x, ");
        selectQuery1.append("\n       (SELECT csr_no, vndr_no ");
        selectQuery1.append("\n          FROM ap_inv_hdr ");
        selectQuery1.append("\n         WHERE csr_no = ? ");	//:csr_no
        selectQuery1.append("\n       ) y ");
        selectQuery1.append("\n WHERE x.vndr = y.vndr_no ");
        	
        ////2.GET VVD_CD
        selectQuery2.append("\nSELECT 'CFDR'||SUBSTR(gl_dt,3,4)||'EE' ");
        selectQuery2.append("\n  FROM ap_inv_hdr ");
        selectQuery2.append("\n WHERE csr_no = ? "); //:csrNO 
        
        ////3.GET VVD_COM_LVL
        selectQuery3.append("\nSELECT vvd_com_lvl lvl ");
        selectQuery3.append("\n  FROM ar_mst_rev_vvd ");
        selectQuery3.append("\n WHERE vsl_cd     = SUBSTR(?,1,4) ");	//:vvd
        selectQuery3.append("\n   AND skd_voy_no = SUBSTR(?,5,4) ");	//:vvd
        selectQuery3.append("\n   AND skd_dir_cd = SUBSTR(?,9,1) ");	//:vvd
        
        ////4.GET VVD_LVL_FLG
        selectQuery4.append("\nSELECT NVL(DECODE(?,'1',vvd_lvl_flg1, ");	//:vvd_level
        selectQuery4.append("\n                    '2',vvd_lvl_flg2, "); 
        selectQuery4.append("\n                    '3',vvd_lvl_flg3, ");
        selectQuery4.append("\n                    '4',vvd_lvl_flg4, ");
        selectQuery4.append("\n                    '5',vvd_lvl_flg5,vvd_lvl_flg6),'N') ");
        selectQuery4.append("\n  FROM mdm_account ");
        selectQuery4.append("\n WHERE acct_cd = ? ");	//:account_cd
        
        ////5.AP_INV_DSTR INSERT
        insertQuery1.append("\nINSERT INTO ap_inv_dtrb ");
        insertQuery1.append("\n       (csr_no, ");	//1
        insertQuery1.append("\n        line_seq, ");
        insertQuery1.append("\n        line_no, ");
        insertQuery1.append("\n        line_tp_lu_cd, ");
        insertQuery1.append("\n        inv_amt, ");
        insertQuery1.append("\n        inv_desc, ");
        insertQuery1.append("\n        inv_tax_cd, ");
        insertQuery1.append("\n        dtrb_coa_co_cd, ");
        insertQuery1.append("\n        dtrb_coa_rgn_cd, ");
        insertQuery1.append("\n        dtrb_coa_ctr_cd, ");
        insertQuery1.append("\n        dtrb_coa_acct_cd, ");	//11
        insertQuery1.append("\n        dtrb_coa_vvd_cd, ");
        insertQuery1.append("\n        dtrb_coa_inter_co_cd, ");
        insertQuery1.append("\n        dtrb_coa_ftu_n1st_cd, ");
        insertQuery1.append("\n        dtrb_coa_ftu_n2nd_cd, ");
        insertQuery1.append("\n        attr_cate_nm, ");
        insertQuery1.append("\n        attr_ctnt1, ");
        insertQuery1.append("\n        attr_ctnt2, ");
        insertQuery1.append("\n        attr_ctnt3, ");
        insertQuery1.append("\n        attr_ctnt4, ");
        insertQuery1.append("\n        attr_ctnt5, ");	//21
        insertQuery1.append("\n        attr_ctnt6, ");
        insertQuery1.append("\n        attr_ctnt7, ");
        insertQuery1.append("\n        attr_ctnt8, ");
        insertQuery1.append("\n        attr_ctnt9, ");
        insertQuery1.append("\n        attr_ctnt10, ");
        insertQuery1.append("\n        attr_ctnt11, ");
        insertQuery1.append("\n        attr_ctnt12, ");
        insertQuery1.append("\n        attr_ctnt13, ");
        insertQuery1.append("\n        attr_ctnt14, ");
        insertQuery1.append("\n        attr_ctnt15, ");	//31
        insertQuery1.append("\n        bkg_no, ");
        insertQuery1.append("\n        bkg_no_split, ");
        insertQuery1.append("\n        cntr_tpsz_cd, ");
        insertQuery1.append("\n        act_vvd_cd, ");
        insertQuery1.append("\n        pln_sctr_div_cd, ");
        insertQuery1.append("\n        so_crr_cd, ");
        insertQuery1.append("\n        yd_cd, ");
        insertQuery1.append("\n        ftu_use_ctnt1, ");
        insertQuery1.append("\n        ftu_use_ctnt2, ");
        insertQuery1.append("\n        ftu_use_ctnt3, ");	//41
        insertQuery1.append("\n        ftu_use_ctnt4, ");
        insertQuery1.append("\n        ftu_use_ctnt5, ");
        insertQuery1.append("\n        cre_dt, ");
        insertQuery1.append("\n        cre_usr_id, ");
        insertQuery1.append("\n        eai_evnt_dt)  ");
        insertQuery1.append("\nVALUES (?, ?, ?, ?, ROUND(?,2), ?, ?, ?, ?, ?, ");
        insertQuery1.append("\n        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        insertQuery1.append("\n        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        insertQuery1.append("\n        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ");
        insertQuery1.append("\n        ?, ?, ?, SYSDATE, ?, SYSDATE) ");

        ////6.CHECK AMOUNT
		updateQuery1.append("\nUPDATE ap_inv_dtrb a ");
		updateQuery1.append("\n   SET inv_amt = inv_amt + (SELECT x.csr_amt - SUM(y.inv_amt) ");
		updateQuery1.append("\n                              FROM ap_inv_hdr x, ap_inv_dtrb y ");
		updateQuery1.append("\n                             WHERE x.csr_no = ? "); //:csrNo
		updateQuery1.append("\n                               AND x.csr_no = y.csr_no ");
		updateQuery1.append("\n                             GROUP BY x.csr_amt) ");
		updateQuery1.append("\n WHERE csr_no = ? "); //:csrNo
		updateQuery1.append("\n   AND (line_seq,line_no) IN (SELECT line_seq, line_no ");
		updateQuery1.append("\n                                FROM ap_inv_dtrb ");
		updateQuery1.append("\n                               WHERE csr_no = a.csr_no ");
		updateQuery1.append("\n                                 AND ROWNUM = 1) ");
        
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                selectPs2 = new LoggableStatement(con, selectQuery2.toString());
                selectPs3 = new LoggableStatement(con, selectQuery3.toString());
                selectPs4 = new LoggableStatement(con, selectQuery4.toString());
                insertPs1 = new LoggableStatement(con, insertQuery1.toString());
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            } else {
                selectPs1 = con.prepareStatement(selectQuery1.toString());
                selectPs2 = con.prepareStatement(selectQuery2.toString());
                selectPs3 = con.prepareStatement(selectQuery3.toString());
                selectPs4 = con.prepareStatement(selectQuery4.toString());
                insertPs1 = con.prepareStatement(insertQuery1.toString());
                updatePs1 = con.prepareStatement(updateQuery1.toString());
            }

            ////변수값 세팅
            userId = event.getUserId();
            slsOfcCd = event.getString("cbOfcCd");
            csrNo = (String)paramHash.get("csrNo");
        	////끝
            
        	
            ////1.GET AP_INV_DSTR
            i = 1;
            selectPs1.setString(i++, slsOfcCd);
            for(int j=0; j<fwdr.length; j++){selectPs1.setString(i++, fwdr[j]);}
            selectPs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACCSRDistribution]Select SQL1 :::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [createFACCSRDistribution]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
        	while(rs1.next()) {
				regionCd  = rs1.getString(9);
			    centerCd  = rs1.getString(10);
			    accountCd = rs1.getString(11);
			    vvdCd     = rs1.getString(12);
			     
			    //CHECK
			    if(regionCd == null || regionCd.length() < 1){
			    	//[Region Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Region Code"})).getMessage());
			    }

			    //CHECK
			    if(centerCd == null || centerCd.length() < 1){
			    	//[Center Code] does not exist!, Please check up Again!
			    	throw new DAOException((new ErrorHandler("AGT00027", new String[]{"Center Code"})).getMessage());
			    }
			    
			    
			    //VVD가 없다면, 임의생성한다(CFDR + YYMM + EE)
			    if(vvdCd == null || vvdCd.length() < 1){
					////2.GET VVD_CD
					i = 1;
		            selectPs2.setString(i++, csrNo);
		            
		            //Loggable Statement 사용에 의해 추가
		            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
		                log.info("\n [createFACCSRDistribution]Select SQL2 :::: \n" + ((LoggableStatement)selectPs2).getQueryString());
		            } else {
		                log.info("\n [createFACCSRDistribution]Select SQL2 : \n" + selectQuery2.toString());
		            }            
		            rs2 = selectPs2.executeQuery();
		            
		            while (rs2.next()) {
						vvdCd = rs2.getString(1);
		            }
		            closeResultSet(rs2);
			    }//if(vvdCd == null || vvdCd.length() < 1){
			    
			    
	            if(!vvdCd.substring(1,4).equals("CNTC")){
	            	vvdLevel = "";
	            	
				    ////3.GET VVD_LEVEL_FLAG
				    i = 1;
		            selectPs3.setString(i++, vvdCd);
		            selectPs3.setString(i++, vvdCd);
		            selectPs3.setString(i++, vvdCd);
		            
		            //Loggable Statement 사용에 의해 추가
		            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
		                log.info("\n [createFACCSRDistribution]Select SQL3 :::: \n" + ((LoggableStatement)selectPs3).getQueryString());
		            } else {
		                log.info("\n [createFACCSRDistribution]Select SQL3 : \n" + selectQuery3.toString() );
		            }            
		            rs3 = selectPs3.executeQuery();
		            
		            while (rs3.next()) {
						vvdLevel = rs3.getString(1);
		            }
		            closeResultSet(rs3);
		            
		            //CHECK
		            if(vvdLevel == null || vvdLevel.length() < 1){
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("AGT00030", new String[]{vvdCd})).getMessage());
		            }
		            	
		            
	            	////4.GET VVD_LVL_FLG
	            	i = 1;
		            selectPs4.setString(i++, vvdLevel);
		            selectPs4.setString(i++, (accountCd==null?"":accountCd));
		            
		            //Loggable Statement 사용에 의해 추가
		            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
		                log.info("\n [createFACCSRDistribution]Select SQL4 :::: \n" + ((LoggableStatement)selectPs4).getQueryString());
		            } else {
		                log.info("\n [createFACCSRDistribution]Select SQL4 : \n" + selectQuery4.toString() );
		            }            
		            rs4 = selectPs4.executeQuery();
		            
		            while (rs4.next()) {
						vvdFlag = rs4.getString(1);
		            }
		            closeResultSet(rs4);
		            
		            //CHECK
					if(!vvdFlag.equals("Y")){
						//Wrong Revenue VVD for AP Interface!, Please check up the vvd[$]!
						throw new DAOException((new ErrorHandler("AGT00030", new String[]{vvdCd})).getMessage());
					}
						
	            }//if(!vvdCd.substring(1,4).equals("CNTC")){
	            

	            ////5.AP_INV_DSTR INSERT ////////////////////////////////////////
	        	i = 1;
	        	insertPs1.setString(i, rs1.getString(i++));	//1
	            insertPs1.setLong(i, rs1.getLong(i++));
	            insertPs1.setLong(i, rs1.getLong(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setFloat(i, rs1.getFloat(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));	//11
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));	//21
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));	//31
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));	//41
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, rs1.getString(i++));
	            insertPs1.setString(i, userId);
	        	
	            // Loggable Statement 사용에 의해 추가
	            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
	                log.info("\n [createFACCSRDistribution]Insert SQL1 :::: \n" + ((LoggableStatement)insertPs1).getQueryString());
	            } else {
	                log.info("\n [createFACCSRDistribution]Insert SQL1 : \n" + insertQuery1.toString() );
	            }            
	            insertPs1.execute(); 
			}//while (rs1.next()) {
        	
        	
            ////6.CHECK AMOUNT
            i = 1;
            updatePs1.setString(i++, csrNo);
            updatePs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACAPTempTable]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
            } else {
                log.info("\n [createFACAPTempTable]Update SQL1 : \n" + updateQuery1.toString() );
            }            
            updatePs1.executeUpdate();

        
                      
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeResultSet(rs3);
        	closeResultSet(rs4);
        	closeStatement(selectPs1);
            closeStatement(selectPs2);
            closeStatement(selectPs3);
            closeStatement(selectPs4);
            closeStatement(insertPs1);
            closeStatement(updatePs1);
            closeConnection(con);
        }
        
        return dRs;
    }
    */
    /**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  Event et
     * @param  HashMap paramHash
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet createFACAPTempTable(Event et, HashMap paramHash) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement insertPs1 = null; // INSERT를 수행하기 위한 SQL Statement
        ResultSet rs1 = null;				// DB ResultSet
        DBRowSet dRs = null;				// DB DBRowSet
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String slsOfcCd = "";
        String localDt = "";
        String csrNo = "";
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer insertQuery1 = new StringBuffer();
        
        //1.GET LOCAL_DATE 
        selectQuery1.append("\nSELECT TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,loc_cd),'YYYYMMDD') ");
        selectQuery1.append("\n  FROM mdm_organization ");
        selectQuery1.append("\n WHERE ofc_cd = ? ");	//:sls_ofc_cd
        selectQuery1.append("\n   AND ROWNUM = 1 ");
        
        //2.AP_INV_IF INSERT
        insertQuery1.append("\nINSERT INTO ap_inv_if(AP_PGM_NO, INV_SEQ, TTL_ROW_KNT, ROW_KNT, HDR_CSR_NO, HDR_CSR_TP_CD, HDR_INV_DT, HDR_INV_TERM_DT, HDR_GL_DT, HDR_VNDR_NO, HDR_CSR_AMT, HDR_PAY_AMT, HDR_PAY_DT, HDR_CSR_CURR_CD, HDR_VNDR_TERM_NM, HDR_INV_DESC, HDR_ATTR_CATE_NM, HDR_ATTR_CTNT1, HDR_ATTR_CTNT2, HDR_ATTR_CTNT3, HDR_ATTR_CTNT4, HDR_ATTR_CTNT5, HDR_ATTR_CTNT6, HDR_ATTR_CTNT7, HDR_ATTR_CTNT8, HDR_ATTR_CTNT9, HDR_ATTR_CTNT10, HDR_ATTR_CTNT11, HDR_ATTR_CTNT12, HDR_ATTR_CTNT13, HDR_ATTR_CTNT14, HDR_ATTR_CTNT15, HDR_GLO_ATTR_CTNT1, HDR_GLO_ATTR_CTNT2, HDR_GLO_ATTR_CTNT3, HDR_GLO_ATTR_CTNT4, HDR_GLO_ATTR_CTNT5, HDR_GLO_ATTR_CTNT6, HDR_GLO_ATTR_CTNT7, HDR_GLO_ATTR_CTNT8, HDR_GLO_ATTR_CTNT9, HDR_GLO_ATTR_CTNT10, HDR_GLO_ATTR_CTNT11, HDR_GLO_ATTR_CTNT12, HDR_GLO_ATTR_CTNT13, HDR_GLO_ATTR_CTNT14, HDR_GLO_ATTR_CTNT15, HDR_GLO_ATTR_CTNT16, HDR_GLO_ATTR_CTNT17, HDR_GLO_ATTR_CTNT18, HDR_SRC_CTNT, HDR_PAY_MZD_LU_CD, HDR_PAY_GRP_LU_CD, HDR_COA_CO_CD, HDR_COA_RGN_CD, HDR_COA_CTR_CD, HDR_COA_ACCT_CD, HDR_COA_VVD_CD, HDR_COA_INTER_CO_CD, HDR_COA_FTU_N1ST_CD, HDR_COA_FTU_N2ND_CD, HDR_PPD_NO, HDR_PPD_DTRB_NO, HDR_PPD_APLY_AMT, HDR_PPD_GL_DT, HDR_APRO_FLG, HDR_TAX_DECL_FLG, HDR_ERR_CSR_NO, HDR_IF_FLG, HDR_IF_DT, HDR_IF_ERR_RSN, HDR_PPAY_APLY_FLG, HDR_TJ_OFC_CD, HDR_ACT_XCH_RT, HDR_IMP_ERR_FLG, HDR_RCV_ERR_FLG, HDR_TAX_CURR_XCH_FLG, HDR_USR_EML, HDR_IMP_ERR_RSN, HDR_RCV_ERR_RSN, HDR_FTU_USE_CTNT1, HDR_FTU_USE_CTNT2, HDR_FTU_USE_CTNT3, HDR_FTU_USE_CTNT4, HDR_FTU_USE_CTNT5, CSR_NO, LINE_SEQ, LINE_NO, LINE_TP_LU_CD, INV_AMT, INV_DESC, INV_TAX_CD, DTRB_COA_CO_CD, DTRB_COA_RGN_CD, DTRB_COA_CTR_CD, DTRB_COA_ACCT_CD, DTRB_COA_VVD_CD, DTRB_COA_INTER_CO_CD, DTRB_COA_FTU_N1ST_CD, DTRB_COA_FTU_N2ND_CD, ATTR_CATE_NM, ATTR_CTNT1, ATTR_CTNT2, ATTR_CTNT3, ATTR_CTNT4, ATTR_CTNT5, ATTR_CTNT6, ATTR_CTNT7, ATTR_CTNT8, ATTR_CTNT9, ATTR_CTNT10, ATTR_CTNT11, ATTR_CTNT12, ATTR_CTNT13, ATTR_CTNT14, ATTR_CTNT15, BKG_NO, BKG_NO_SPLIT, CNTR_TPSZ_CD, ACT_VVD_CD, PLN_SCTR_DIV_CD, SO_CRR_CD, YD_CD, FTU_USE_CTNT1, FTU_USE_CTNT2, FTU_USE_CTNT3, FTU_USE_CTNT4, FTU_USE_CTNT5, SND_FLG, CRE_DT, CRE_USR_ID, EAI_EVNT_DT, ESTM_ERR_RSN) ");
        insertQuery1.append("\nSELECT 'ESMAGTFAC'||?, ");	//:local_date
        insertQuery1.append("\n       ROWNUM + (SELECT NVL(MAX(inv_seq),0) FROM ap_inv_if WHERE ap_pgm_no = 'ESMAGTFAC'||?), ");	////:local_date
        insertQuery1.append("\n       (SELECT COUNT(*) FROM ap_inv_dtrb WHERE csr_no = ?), ");	//:csr_no
        insertQuery1.append("\n       ROWNUM, ");
        insertQuery1.append("\n       a.csr_no, ");
        insertQuery1.append("\n       a.csr_tp_cd, ");
        insertQuery1.append("\n       a.inv_dt, ");
        insertQuery1.append("\n       a.inv_term_dt, ");
        insertQuery1.append("\n       a.gl_dt, ");
        insertQuery1.append("\n       a.vndr_no, ");
        insertQuery1.append("\n       a.csr_amt, ");
        insertQuery1.append("\n       a.pay_amt, ");
        insertQuery1.append("\n       a.pay_dt, ");
        insertQuery1.append("\n       a.csr_curr_cd, ");
        insertQuery1.append("\n       a.vndr_term_nm, ");
        insertQuery1.append("\n       a.inv_desc, ");
        insertQuery1.append("\n       a.attr_cate_nm, ");
        insertQuery1.append("\n       a.attr_ctnt1, ");
        insertQuery1.append("\n       a.attr_ctnt2, ");
        insertQuery1.append("\n       a.attr_ctnt3, ");
        insertQuery1.append("\n       a.attr_ctnt4, ");
        insertQuery1.append("\n       a.attr_ctnt5, ");
        insertQuery1.append("\n       a.attr_ctnt6, ");
        insertQuery1.append("\n       a.attr_ctnt7, ");
        insertQuery1.append("\n       a.attr_ctnt8, ");
        insertQuery1.append("\n       a.attr_ctnt9, ");
        insertQuery1.append("\n       a.attr_ctnt10, ");
        insertQuery1.append("\n       a.attr_ctnt11, ");
        insertQuery1.append("\n       a.attr_ctnt12, ");
        insertQuery1.append("\n       a.attr_ctnt13, ");
        insertQuery1.append("\n       a.attr_ctnt14, ");
        insertQuery1.append("\n       a.attr_ctnt15, ");
        insertQuery1.append("\n       a.glo_attr_ctnt1, ");
        insertQuery1.append("\n       a.glo_attr_ctnt2, ");
        insertQuery1.append("\n       a.glo_attr_ctnt3, ");
        insertQuery1.append("\n       a.glo_attr_ctnt4, ");
        insertQuery1.append("\n       a.glo_attr_ctnt5, ");
        insertQuery1.append("\n       a.glo_attr_ctnt6, ");
        insertQuery1.append("\n       a.glo_attr_ctnt7, ");
        insertQuery1.append("\n       a.glo_attr_ctnt8, ");
        insertQuery1.append("\n       a.glo_attr_ctnt9, ");
        insertQuery1.append("\n       a.glo_attr_ctnt10, ");
        insertQuery1.append("\n       a.glo_attr_ctnt11, ");
        insertQuery1.append("\n       a.glo_attr_ctnt12, ");
        insertQuery1.append("\n       a.glo_attr_ctnt13, ");
        insertQuery1.append("\n       a.glo_attr_ctnt14, ");
        insertQuery1.append("\n       a.glo_attr_ctnt15, ");
        insertQuery1.append("\n       a.glo_attr_ctnt16, ");
        insertQuery1.append("\n       a.glo_attr_ctnt17, ");
        insertQuery1.append("\n       a.glo_attr_ctnt18, ");
        insertQuery1.append("\n       a.src_ctnt, ");
        insertQuery1.append("\n       a.pay_mzd_lu_cd, ");
        insertQuery1.append("\n       a.pay_grp_lu_cd, ");
        insertQuery1.append("\n       a.coa_co_cd, ");
        insertQuery1.append("\n       a.coa_rgn_cd, ");
        insertQuery1.append("\n       a.coa_ctr_cd, ");
        insertQuery1.append("\n       a.coa_acct_cd, ");
        insertQuery1.append("\n       a.coa_vvd_cd, ");
        insertQuery1.append("\n       a.coa_inter_co_cd, ");
        insertQuery1.append("\n       a.coa_ftu_n1st_cd, ");
        insertQuery1.append("\n       a.coa_ftu_n2nd_cd, ");
        insertQuery1.append("\n       a.ppd_no, ");
        insertQuery1.append("\n       a.ppd_dtrb_no, ");
        insertQuery1.append("\n       a.ppd_aply_amt, ");
        insertQuery1.append("\n       a.ppd_gl_dt, ");     
        insertQuery1.append("\n       a.apro_flg, ");
        insertQuery1.append("\n       a.tax_decl_flg, ");
        insertQuery1.append("\n       a.err_csr_no, ");
        insertQuery1.append("\n       a.if_flg, ");
        insertQuery1.append("\n       a.if_dt, ");
        insertQuery1.append("\n       a.if_err_rsn, ");
        insertQuery1.append("\n       a.ppay_aply_flg, ");
        insertQuery1.append("\n       a.tj_ofc_cd, ");
        insertQuery1.append("\n       a.act_xch_rt, ");
        insertQuery1.append("\n       a.imp_err_flg, ");
        insertQuery1.append("\n       a.rcv_err_flg, ");
        insertQuery1.append("\n       a.tax_curr_xch_flg, ");
        insertQuery1.append("\n       a.usr_eml, ");
        insertQuery1.append("\n       a.imp_err_rsn, ");
        insertQuery1.append("\n       a.rcv_err_rsn, ");
        insertQuery1.append("\n       a.ftu_use_ctnt1, ");
        insertQuery1.append("\n       a.ftu_use_ctnt2, ");
        insertQuery1.append("\n       a.ftu_use_ctnt3, ");
        insertQuery1.append("\n       a.ftu_use_ctnt4, ");
        insertQuery1.append("\n       a.ftu_use_ctnt5, ");
        insertQuery1.append("\n       b.csr_no, ");
        insertQuery1.append("\n       b.line_seq, ");
        insertQuery1.append("\n       b.line_no, ");
        insertQuery1.append("\n       b.line_tp_lu_cd, ");
        insertQuery1.append("\n       b.inv_amt, ");
        insertQuery1.append("\n       b.inv_desc, ");
        insertQuery1.append("\n       b.inv_tax_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_co_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_rgn_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_ctr_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_acct_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_vvd_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_inter_co_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_ftu_n1st_cd, ");
        insertQuery1.append("\n       b.dtrb_coa_ftu_n2nd_cd, ");
        insertQuery1.append("\n       b.attr_cate_nm, ");
        insertQuery1.append("\n       b.attr_ctnt1, ");
        insertQuery1.append("\n       b.attr_ctnt2, ");
        insertQuery1.append("\n       b.attr_ctnt3, ");
        insertQuery1.append("\n       b.attr_ctnt4, ");
        insertQuery1.append("\n       b.attr_ctnt5, ");
        insertQuery1.append("\n       b.attr_ctnt6, ");
        insertQuery1.append("\n       b.attr_ctnt7, ");
        insertQuery1.append("\n       b.attr_ctnt8, ");
        insertQuery1.append("\n       b.attr_ctnt9, ");
        insertQuery1.append("\n       b.attr_ctnt10, ");
        insertQuery1.append("\n       b.attr_ctnt11, ");
        insertQuery1.append("\n       b.attr_ctnt12, ");
        insertQuery1.append("\n       b.attr_ctnt13, ");
        insertQuery1.append("\n       b.attr_ctnt14, ");
        insertQuery1.append("\n       b.attr_ctnt15, ");
        insertQuery1.append("\n       b.bkg_no, ");
        insertQuery1.append("\n       b.bkg_no_split, ");
        insertQuery1.append("\n       b.cntr_tpsz_cd, ");
        insertQuery1.append("\n       b.act_vvd_cd, ");
        insertQuery1.append("\n       b.pln_sctr_div_cd, ");
        insertQuery1.append("\n       b.so_crr_cd, ");
        insertQuery1.append("\n       b.yd_cd, ");
        insertQuery1.append("\n       b.ftu_use_ctnt1, ");
        insertQuery1.append("\n       b.ftu_use_ctnt2, ");
        insertQuery1.append("\n       b.ftu_use_ctnt3, ");
        insertQuery1.append("\n       b.ftu_use_ctnt4, ");
        insertQuery1.append("\n       b.ftu_use_ctnt5, ");
        insertQuery1.append("\n       'N', ");
        insertQuery1.append("\n       b.cre_dt, ");
        insertQuery1.append("\n       b.cre_usr_id, ");
        insertQuery1.append("\n       b.cre_dt, ");
        insertQuery1.append("\n       '' ");
        insertQuery1.append("\n  FROM ap_inv_hdr a, ap_inv_dtrb b ");
        insertQuery1.append("\n WHERE a.csr_no = ? ");	//:csr_no
        insertQuery1.append("\n   AND a.csr_no = b.csr_no ");
        insertQuery1.append("\n   AND NVL(a.if_flg,'N') = 'N' ");
        insertQuery1.append("\n ORDER BY b.csr_no, b.line_seq, b.line_no ");

        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                insertPs1 = new LoggableStatement(con, insertQuery1.toString());
            } else {
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
                insertPs1 = con.prepareStatement(insertQuery1.toString());
            }

            ////변수값 구하기
            slsOfcCd = event.getString("cbOfcCd");
            csrNo = (String)paramHash.get("csrNo");
            
            
            ////1.GET LOCAL_DATE
            i = 1;
            selectPs1.setString(i++, slsOfcCd);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACAPTempTable]Select SQL1 :::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [createFACAPTempTable]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
        	while (rs1.next()) {
				localDt = rs1.getString(1);
			}
		
        
        	////2.GET AP_INV_IF
    		i = 1;
            insertPs1.setString(i++, localDt);
            insertPs1.setString(i++, localDt);
            insertPs1.setString(i++, csrNo);
            insertPs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [createFACAPTempTable]Insert SQL1 :::: \n" + ((LoggableStatement)insertPs1).getQueryString());
            } else {
                log.info("\n [createFACAPTempTable]Insert SQL1 : \n" + insertQuery1.toString() );
            }            
            insertPs1.execute();
    	
                        
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeStatement(selectPs1);
            closeStatement(insertPs1);
            closeConnection(con);
        }
        
        return dRs;
    }
    
    /**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  HashMap paramHash
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchFACActualINFtoAP(HashMap paramHash) throws DAOException {
    	Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        ResultSet rs1 = null;	// DB ResultSet
        ResultSet rs2 = null;	// DB ResultSet
        DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String ifId = "FNS008-0003";
        String csrNo = "";
        int csrCnt = 0;
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        
        //1.CHECK
        selectQuery1.append("\nSELECT COUNT(hdr_csr_no) ");
        selectQuery1.append("\n  FROM ap_inv_if ");
        selectQuery1.append("\n WHERE csr_no = ? ");	//:csrNo
        selectQuery1.append("\n   AND NVL(snd_flg,'N') = 'Y' ");
        
        //2.SEARCH AP_INV_IF 
        selectQuery2.append("\nSELECT ? lif_id, ap_pgm_no||inv_seq seq, ttl_row_knt, row_knt, hdr_csr_no, hdr_csr_tp_cd, "); //:ifId
        selectQuery2.append("\n       hdr_inv_dt, hdr_inv_term_dt, hdr_gl_dt, hdr_vndr_no, hdr_csr_amt, hdr_pay_amt, ");
        selectQuery2.append("\n       hdr_csr_curr_cd, hdr_vndr_term_nm, hdr_inv_desc, hdr_attr_cate_nm, hdr_pay_dt, ");
        selectQuery2.append("\n       hdr_attr_ctnt1, hdr_attr_ctnt2, hdr_attr_ctnt3, hdr_attr_ctnt4, hdr_attr_ctnt5, ");
        selectQuery2.append("\n       hdr_attr_ctnt6, hdr_attr_ctnt7, hdr_attr_ctnt8, hdr_attr_ctnt9, hdr_attr_ctnt10, ");
        selectQuery2.append("\n       hdr_attr_ctnt11, hdr_attr_ctnt12, hdr_attr_ctnt13, hdr_attr_ctnt14, hdr_attr_ctnt15, ");
        selectQuery2.append("\n       hdr_glo_attr_ctnt1, hdr_glo_attr_ctnt2, hdr_glo_attr_ctnt3, hdr_glo_attr_ctnt4, ");
        selectQuery2.append("\n       hdr_glo_attr_ctnt5, hdr_glo_attr_ctnt6, hdr_glo_attr_ctnt7, hdr_glo_attr_ctnt8, ");
        selectQuery2.append("\n       hdr_glo_attr_ctnt9, hdr_glo_attr_ctnt10, hdr_glo_attr_ctnt11, hdr_glo_attr_ctnt12, ");
        selectQuery2.append("\n       hdr_glo_attr_ctnt13, hdr_glo_attr_ctnt14, hdr_glo_attr_ctnt15, hdr_glo_attr_ctnt16, ");
        selectQuery2.append("\n       hdr_glo_attr_ctnt17, hdr_glo_attr_ctnt18, hdr_src_ctnt, hdr_pay_mzd_lu_cd, ");
        selectQuery2.append("\n       hdr_pay_grp_lu_cd, hdr_coa_co_cd, hdr_coa_rgn_cd, hdr_coa_ctr_cd, hdr_coa_acct_cd, ");
        selectQuery2.append("\n       hdr_coa_vvd_cd, hdr_coa_inter_co_cd, hdr_coa_ftu_n1st_cd, hdr_coa_ftu_n2nd_cd, ");
        selectQuery2.append("\n       hdr_ppd_no, hdr_ppd_dtrb_no, hdr_ppd_aply_amt, hdr_ppd_gl_dt, hdr_apro_flg, ");
        selectQuery2.append("\n       hdr_tax_decl_flg, hdr_err_csr_no, hdr_if_flg, hdr_if_dt, hdr_if_err_rsn, ");
        selectQuery2.append("\n       hdr_ppay_aply_flg, hdr_tj_ofc_cd, hdr_act_xch_rt, hdr_imp_err_flg, hdr_rcv_err_flg, ");
        selectQuery2.append("\n       hdr_tax_curr_xch_flg, hdr_usr_eml, hdr_imp_err_rsn, hdr_rcv_err_rsn, hdr_ftu_use_ctnt1, ");
        selectQuery2.append("\n       hdr_ftu_use_ctnt2, hdr_ftu_use_ctnt3, hdr_ftu_use_ctnt4, hdr_ftu_use_ctnt5, ");
        selectQuery2.append("\n       csr_no, line_seq, line_no, line_tp_lu_cd, inv_amt, inv_desc, inv_tax_cd, dtrb_coa_co_cd, ");
        selectQuery2.append("\n       dtrb_coa_rgn_cd, dtrb_coa_ctr_cd, dtrb_coa_acct_cd, dtrb_coa_vvd_cd, dtrb_coa_inter_co_cd, ");
        selectQuery2.append("\n       dtrb_coa_ftu_n1st_cd, dtrb_coa_ftu_n2nd_cd, attr_cate_nm, attr_ctnt1, attr_ctnt2, ");
        selectQuery2.append("\n       attr_ctnt3, attr_ctnt4, attr_ctnt5, attr_ctnt6, attr_ctnt7, attr_ctnt8, attr_ctnt9, ");
        selectQuery2.append("\n       attr_ctnt10, attr_ctnt11, attr_ctnt12, attr_ctnt13, attr_ctnt14, attr_ctnt15, ");
        selectQuery2.append("\n       bkg_no||bkg_no_split bkg_no, cntr_tpsz_cd, act_vvd_cd, pln_sctr_div_cd, so_crr_cd, yd_cd, ");
        selectQuery2.append("\n       ftu_use_ctnt1, ftu_use_ctnt2, ftu_use_ctnt3, ftu_use_ctnt4, ftu_use_ctnt5 ");
        selectQuery2.append("\n  FROM ap_inv_if ");
        selectQuery2.append("\n WHERE ap_pgm_no LIKE 'ESMAGTFAC%' ");
        selectQuery2.append("\n   AND csr_no = ? ");	//:csrNo
        selectQuery2.append("\n   AND NVL(snd_flg,'N') = 'N' ");
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                selectPs2 = new LoggableStatement(con, selectQuery2.toString());
            } else {
                selectPs1 = con.prepareStatement(selectQuery1.toString());
                selectPs2 = con.prepareStatement(selectQuery2.toString());
            }

            ////변수값 세팅
            csrNo = (String)paramHash.get("csrNo");
            
            
            ////1.CHECK
            i = 1;
            selectPs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [searchFACActualINFtoAP]Select SQL1 :::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [searchFACActualINFtoAP]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
            if(rs1 != null){
	        	while(rs1.next()) {
					csrCnt = rs1.getInt(1);
				}
            }

            if(csrCnt > 0){
				//CSR No has already Interfaced! Please check up CSR No[$]
				throw new DAOException((new ErrorHandler("AGT00029", new String[]{csrNo})).getMessage());
            }
            
            
            ////2.SEARCH AP_INV_IF 
            i = 1;
            selectPs2.setString(i++, ifId);
            selectPs2.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [searchFACActualINFtoAP]Select SQL2 :::: \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [searchFACActualINFtoAP]Select SQL2 : \n" + selectQuery2.toString() );
            }            
            rs2 = selectPs2.executeQuery();
            
            //결과를 DBRowset에 담는다.
            dRs = new DBRowSet();
            dRs.populate(rs2);            
                         
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeStatement(selectPs1);
        	closeStatement(selectPs2);
            closeConnection(con);
        }
        
        return dRs;
    }
    
    /**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  HashMap paramHash
     * @param  HashMap eaiHash
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet createFACAcutalINFFromAPbyMSG(HashMap paramHash, HashMap eaiHash) throws DAOException {
    	Connection con = null;				// Connection Interface  
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement updatePs2 = null; // UPDATE를 수행하기 위한 SQL Statement
        
        DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String nCsrNo = "";
        boolean isSuccess = false; 
        
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer updateQuery2 = new StringBuffer();
        
        //1.AP_INV_HDR에 AP I/F 결과 UPDATE
        updateQuery1.append("\nUPDATE ap_inv_hdr ");
        updateQuery1.append("\n   SET if_flg = NULL, ");
        updateQuery1.append("\n       if_dt  = NULL, ");
        updateQuery1.append("\n       if_err_rsn  = NULL, ");
        updateQuery1.append("\n       rcv_err_flg = NULL, ");
        updateQuery1.append("\n       rcv_err_rsn = NULL  ");
        updateQuery1.append("\n WHERE csr_no = ? ");		//:new_csr_no
        		
        //2.AP_INV_IF에 AP I/F 결과 UPDATE
        updateQuery2.append("\nUPDATE ap_inv_if ");
        updateQuery2.append("\n   SET snd_flg = 'Y', ");
        updateQuery2.append("\n       hdr_if_flg = NULL, ");
        updateQuery2.append("\n       hdr_if_dt  = NULL, ");
        updateQuery2.append("\n       hdr_if_err_rsn  = NULL, ");
        updateQuery2.append("\n       hdr_rcv_err_flg = NULL, ");
        updateQuery2.append("\n       hdr_rcv_err_rsn = NULL  ");
        updateQuery2.append("\n WHERE csr_no = ? ");	//:new_csr_no
        updateQuery2.append("\n   AND NVL(snd_flg,'N') = 'N' ");
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
                updatePs2 = new LoggableStatement(con, updateQuery2.toString());
            } else {
                updatePs1 = con.prepareStatement(updateQuery1.toString());
                updatePs2 = con.prepareStatement(updateQuery2.toString());
            }

            ////변수값 세팅
            nCsrNo = (String)paramHash.get("csrNo");
            isSuccess = ((String)eaiHash.get("isSuccess")=="Y"?true:false);
            ////
            
            if(isSuccess){
            	////1.AP_INV_HDR에 AP I/F 결과 UPDATE
            	i = 1;
            	updatePs1.setString(i++, nCsrNo);
	            
	            //Loggable Statement 사용에 의해 추가
	            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
	                log.info("\n [createFACAcutalINFFromAPbyMSG]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
	            } else {
	                log.info("\n [createFACAcutalINFFromAPbyMSG]Update SQL1 : \n" + updateQuery1.toString() );
	            }            
	            updatePs1.execute();
	            
	            
	            ////2.AP_INV_IF에 AP I/F 결과 UPDATE
	            i = 1;
	            updatePs2.setString(i++, nCsrNo);
	            
	            //Loggable Statement 사용에 의해 추가
	            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
	                log.info("\n [createFACAcutalINFFromAPbyMSG]Update SQ2 : \n" + ((LoggableStatement)updatePs2).getQueryString());
	            } else {
	                log.info("\n [createFACAcutalINFFromAPbyMSG]Update SQL2 : \n" + updateQuery2.toString() );
	            }            
	            updatePs2.execute();
	            
            }else{
            	//INTERFACE RESULT가 FAIL일때 ROLLBACK;
            	//The Error of Actual FAC Interface to ERP-AP occured.
            	throw new DAOException((new ErrorHandler("AGT00010")).getMessage());
            }
                        
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeStatement(updatePs1);
        	closeStatement(updatePs2);
            closeConnection(con);
        }
        
        return dRs;
    }
    
    /**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  Event et
     * @param  boolean isSuccess
     * @param  HashMap paramHash
     * @return DBRowSet
     * @throws DAOException
     */
    /*
    public DBRowSet modifyFACInfo(Event et, boolean isSuccess, HashMap paramHash) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        DBRowSet dRs = null;				// DB DBRowSet
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "";	//event
        String slsOfcCd = ""; //event
        String csrNo = "";
        String[] fwdr = null;
        String facVal = "?";
        
        fwdr = event.getObject("fwdr");
        for(int j=1; j<fwdr.length; j++){facVal = facVal + ", ?";}
        
        StringBuffer updateQuery1 = new StringBuffer();
        
        ////1.AGT_FAC_COMM에 AP I/F 결과 UPDATE
        if(isSuccess){
        	//true : Interface OK
        	updateQuery1.append("\nUPDATE agt_fac_comm ");
        	updateQuery1.append("\n   SET comm_proc_sts_cd = 'IF', ");
        	updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface OK!', ");
        	updateQuery1.append("\n       fac_if_usr_id = ?, ");	//:user_id
        	updateQuery1.append("\n       fac_if_dt = SYSDATE, ");
        	updateQuery1.append("\n       accl_flg = 'Y', ");
        	updateQuery1.append("\n       csr_no = ?, ");		//:csr_no
        	updateQuery1.append("\n       upd_usr_id = ?, ");	//:user_id
        	updateQuery1.append("\n       upd_dt = SYSDATE ");
        	updateQuery1.append("\n WHERE comm_proc_sts_cd IN('CS','CM','CA') ");
            updateQuery1.append("\n   AND fac_if_dt IS NULL ");
        	updateQuery1.append("\n   AND sls_ofc_cd = ? ");	//:sls_ofc_cd
        	updateQuery1.append("\n   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");	//:fwdr
        }else{
        	//false : Interface FAIL
	        updateQuery1.append("\nUPDATE agt_fac_comm ");
	        updateQuery1.append("\n   SET comm_proc_sts_cd = 'CM', ");
	        updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface FAIL!', ");
        	updateQuery1.append("\n       fac_if_usr_id = ?, ");	//:userId
	        updateQuery1.append("\n       fac_if_dt = SYSDATE, ");
	        updateQuery1.append("\n       upd_usr_id = ?, ");	//:userId
	        updateQuery1.append("\n       upd_dt = SYSDATE ");
	        updateQuery1.append("\n WHERE comm_proc_sts_cd IN('CS','CM','CA') ");
            updateQuery1.append("\n   AND fac_if_dt IS NULL ");
        	updateQuery1.append("\n   AND sls_ofc_cd = ? ");	//:sls_ofc_cd
        	updateQuery1.append("\n   AND frt_fwrd_cnt_cd||TO_CHAR(frt_fwrd_seq,'FM000000') IN(" + facVal + ") ");	//:fwdr
        }
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            } else {
                updatePs1 = con.prepareStatement(updateQuery1.toString());
            }

            ////변수값 세팅
            userId = event.getUserId();
            slsOfcCd = event.getString("cbOfcCd");
            csrNo = (String)paramHash.get("csrNo");
            ////
            
            
            ////1.AGT_AGN_COMM에 AP I/F 결과 UPDATE
            i = 1;
            if(isSuccess){
            	//true : Interface OK
	            updatePs1.setString(i++, userId);
	            updatePs1.setString(i++, csrNo);
	            updatePs1.setString(i++, userId);
	            updatePs1.setString(i++, slsOfcCd);
	            for(int j=0; j<fwdr.length; j++){updatePs1.setString(i++, fwdr[j]);}
            }else{
            	//false : Interface FAIL
            	updatePs1.setString(i++, userId);
	            updatePs1.setString(i++, userId);
	            updatePs1.setString(i++, slsOfcCd);
	            for(int j=0; j<fwdr.length; j++){updatePs1.setString(i++, fwdr[j]);}
            }
	            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [modifyFACInfo]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
            } else {
                log.info("\n [modifyFACInfo]Update SQL1 : \n" + updateQuery1.toString() );
            }            
            updatePs1.execute();
                        
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeStatement(updatePs1);
            closeConnection(con);
        }
        
        return dRs;
    }
    */
    /**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  et ESM_AGT_034Event
     * @return HashMap 조회결과
     * @see    EsmAgt0034Event
     * @throws DAOException
     */
    public HashMap searchFACInfoForPrint(Event et) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        ResultSet rs1 = null;	// DB ResultSet
        ResultSet rs2 = null;	// DB ResultSet
        DBRowSet dRs1 = null;
        DBRowSet dRs2 = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String csrNo = "";
        HashMap rtnMap = null;
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        
        //1.AP_INV_HDR SELECT
        selectQuery1.append("\nSELECT DECODE(SIGN(a.csr_amt),0,'TRANSFER SLIP','CONSULTATION SLIP') hdr_title, ");
        selectQuery1.append("\n       a.csr_no 			hdr_csr_no,    ");
        selectQuery1.append("\n       a.tj_ofc_cd 		hdr_office,    ");
        selectQuery1.append("\n       a.attr_ctnt10 	hdr_prpd_by,   ");
        selectQuery1.append("\n       (SELECT REPLACE(vndr_lgl_eng_nm,'&','&amp;') FROM mdm_vendor WHERE vndr_seq = a.vndr_no) hdr_pay_to, ");
        selectQuery1.append("\n       a.csr_tp_cd       hdr_csr_type,  ");
        selectQuery1.append("\n       REPLACE(a.inv_desc,'&','&amp;') hdr_desc,      ");
        selectQuery1.append("\n       a.pay_grp_lu_cd 	hdr_pay_grp,   ");
        selectQuery1.append("\n       a.attr_cate_nm||'/'||(SELECT COUNT(DISTINCT attr_ctnt1) FROM ap_inv_dtrb WHERE csr_no = a.csr_no) hdr_evi_tp, ");
        selectQuery1.append("\n       TO_CHAR(TO_DATE(a.inv_term_dt,'YYYYMMDD')+a.vndr_term_nm,'YYYY.MM.DD') hdr_due_dt, ");
        selectQuery1.append("\n       SUBSTR(a.attr_ctnt2,1,3)||SUBSTR(a.attr_ctnt2,8)||SUBSTR(a.attr_ctnt2,4,4)  hdr_asa_no,    ");
        selectQuery1.append("\n       TO_CHAR(TO_DATE(a.inv_dt,'YYYYMMDD'),'YYYY.MM.DD') hdr_inv_dt, ");
        selectQuery1.append("\n       a.csr_curr_cd		hdr_curr_cd,   ");
        selectQuery1.append("\n       a.attr_ctnt1		 hdr_apprd_by, ");
        selectQuery1.append("\n       ROUND(a.csr_amt,2) hdr_amount    ");
        selectQuery1.append("\n  FROM ap_inv_hdr a ");
        selectQuery1.append("\n WHERE a.csr_no = ? ");	//:csr_no
        
        //2.AP_INV_DTRB SELECT
        selectQuery2.append("\nSELECT ROWNUM dtl_seq, ");
        selectQuery2.append("\n       dtl_cht_acct, ");
        selectQuery2.append("\n       dtl_acct_nm, ");
        selectQuery2.append("\n       dtl_gl_dt, ");
        selectQuery2.append("\n       dtl_city, ");
        selectQuery2.append("\n       dtl_inv_no, ");
        selectQuery2.append("\n       dtl_desc, ");
        selectQuery2.append("\n       dtl_debit, ");
        selectQuery2.append("\n       dtl_credit ");
        selectQuery2.append("\n  FROM (SELECT DECODE(a.dtrb_coa_acct_cd,'111821',2,1) no, ");
        selectQuery2.append("\n               a.dtrb_coa_co_cd||'.'||a.dtrb_coa_rgn_cd||'.'||a.dtrb_coa_ctr_cd||'.'||a.dtrb_coa_acct_cd||'.'||a.dtrb_coa_inter_co_cd||'.'||a.dtrb_coa_vvd_cd dtl_cht_acct, ");
        selectQuery2.append("\n               (SELECT acct_eng_nm FROM mdm_account WHERE acct_cd = a.dtrb_coa_acct_cd) dtl_acct_nm, ");
        selectQuery2.append("\n               (SELECT TO_CHAR(TO_DATE(gl_dt,'YYYYMMDD'),'YYYY/MM/DD') FROM ap_inv_hdr WHERE csr_no = a.csr_no) dtl_gl_dt, ");
        selectQuery2.append("\n               a.attr_ctnt3            dtl_city,   ");
        selectQuery2.append("\n               a.attr_ctnt1            dtl_inv_no, ");
        selectQuery2.append("\n               a.inv_desc              dtl_desc,   ");
        selectQuery2.append("\n               SUM(ROUND(a.inv_amt,2)) dtl_debit,  ");
        selectQuery2.append("\n               NULL                    dtl_credit  ");
        selectQuery2.append("\n          FROM ap_inv_dtrb a ");
        selectQuery2.append("\n         WHERE a.csr_no = ? "); //:csrNo
        selectQuery2.append("\n         GROUP BY DECODE(a.dtrb_coa_acct_cd,'111821',2,1), ");
        selectQuery2.append("\n                  a.dtrb_coa_co_cd||'.'||a.dtrb_coa_rgn_cd||'.'||a.dtrb_coa_ctr_cd||'.'||a.dtrb_coa_acct_cd||'.'||a.dtrb_coa_inter_co_cd||'.'||a.dtrb_coa_vvd_cd, ");
        selectQuery2.append("\n                  a.dtrb_coa_acct_cd, a.csr_no, a.attr_ctnt3, a.attr_ctnt1, a.inv_desc ");
        selectQuery2.append("\n        UNION ALL ");
        selectQuery2.append("\n        SELECT 9 no, ");
        selectQuery2.append("\n               a.coa_co_cd||'.'||a.coa_rgn_cd||'.'||a.coa_ctr_cd||'.'||a.coa_acct_cd||'.'||a.coa_inter_co_cd||'.'||a.coa_vvd_cd dtl_cht_acct, ");
        selectQuery2.append("\n               (SELECT acct_eng_nm FROM mdm_account WHERE acct_cd = a.coa_acct_cd) dtl_acct_nm, ");
        selectQuery2.append("\n               TO_CHAR(TO_DATE(gl_dt,'YYYYMMDD'),'YYYY/MM/DD') dtl_gl_dt, ");
        selectQuery2.append("\n               NULL                   dtl_city,   ");
        selectQuery2.append("\n               NULL                   dtl_inv_no, ");
        selectQuery2.append("\n               a.inv_desc             dtl_desc,   ");
        selectQuery2.append("\n               NULL                   dtl_debit,  ");
        selectQuery2.append("\n               ROUND(a.csr_amt,2)     dtl_credit  ");
        selectQuery2.append("\n          FROM ap_inv_hdr a ");
        selectQuery2.append("\n         WHERE a.csr_no = ? "); //:csrNo
        selectQuery2.append("\n         ORDER BY no ASC, dtl_cht_acct ASC ");
        selectQuery2.append("\n       ) ");
        
        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
                selectPs2 = new LoggableStatement(con, selectQuery2.toString());
            } else {
                selectPs1 = con.prepareStatement(selectQuery1.toString());
                selectPs2 = con.prepareStatement(selectQuery2.toString());
            }

            ////변수값 세팅
            csrNo = event.getString("h_csrNo");
            
            
            ////1.AP_INV_HDR SELECT
            i = 1;
            selectPs1.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [searchFACInfoForPrint]Select SQL1 :::: \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [searchFACInfoForPrint]Select SQL1 : \n" + selectQuery1.toString() );
            }            
            rs1 = selectPs1.executeQuery();
            
            
            ////2.AP_INV_DTRB SELECT 
            i = 1;
            selectPs2.setString(i++, csrNo);
            selectPs2.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [searchFACInfoForPrint]Select SQL2 :::: \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [searchFACInfoForPrint]Select SQL2 : \n" + selectQuery2.toString() );
            }            
            rs2 = selectPs2.executeQuery();
            
            //결과를 HashMap에 담는다.
            dRs1 = new DBRowSet();
            dRs1.populate(rs1);  
            
            dRs2 = new DBRowSet();
            dRs2.populate(rs2);  
            
            rtnMap = new HashMap();
            rtnMap.put("HDR", dRs1);
            rtnMap.put("DTL", dRs2);
                         
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeStatement(selectPs1);
        	closeStatement(selectPs2);
            closeConnection(con);
        }
        
        return rtnMap;
    }
        
	/**
     * (ESM_AGT_034) FAC AP Actual Interface의 정보를 수정한다.<br>
     * 
     * @param  Event et
     * @return DBRowSet
     * @throws DAOException
     */
    /*
    public DBRowSet modifyCancelFACInfo(Event et) throws DAOException {
    	EsmAgt0034Event event = (EsmAgt0034Event)et;
                
        Connection con = null;				// Connection Interface  
        PreparedStatement selectPs1 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs2 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement selectPs3 = null; // SELECT를 수행하기 위한 SQL Statement
        PreparedStatement updatePs1 = null; // UPDATE를 수행하기 위한 SQL Statement
        PreparedStatement deletePs1 = null; // DELETE를 수행하기 위한 SQL Statement
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        DBRowSet dRs = null;
        int i = 1;							// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
        
        //변수 선언
        String userId = "";	//event
        String[] csrNoArray = null;
        String csrNo = "";
        String ifFlag = "";
        String rcvFlag = "";
        String bkgNo = "";
        String bkgNoSplit = "";
        int facSeq = 0;
        int cnt = 0;
        
        StringBuffer selectQuery1 = new StringBuffer();
        StringBuffer selectQuery2 = new StringBuffer();
        StringBuffer selectQuery3 = new StringBuffer();
        StringBuffer updateQuery1 = new StringBuffer();
        StringBuffer deleteQuery1 = new StringBuffer();
        
        ////1.CHECK INTERFACE RESULT
        selectQuery1.append("\nSELECT if_flg, rcv_err_flg ");
        selectQuery1.append("\n  FROM ap_inv_hdr ");
        selectQuery1.append("\n WHERE csr_no = ? ");	//:csr_no
        selectQuery1.append("\n   AND ROWNUM = 1 ");
        
        ////2.SEARCH
        selectQuery2.append("\nSELECT bkg_no, bkg_no_split, fac_seq ");
        selectQuery2.append("\n  FROM agt_fac_comm ");
        selectQuery2.append("\n WHERE csr_no = ? ");	//:csr_no
        
        ////3.CHECK
        selectQuery3.append("\nSELECT COUNT(*) ");
        selectQuery3.append("\n  FROM agt_fac_comm ");
        selectQuery3.append("\n WHERE bkg_no = ? ");		//:bkg_no
        selectQuery3.append("\n   AND bkg_no_split = ? ");	//:bkg_no_split
        selectQuery3.append("\n   AND fac_seq > ? ");		//:brog_seq
        selectQuery3.append("\n   AND comm_proc_sts_cd = 'IF' ");
        
        ////4.UPDATE AGT_AGN_COMM
    	updateQuery1.append("\nUPDATE agt_fac_comm ");
        updateQuery1.append("\n   SET comm_proc_sts_cd = 'IC', ");
        updateQuery1.append("\n       comm_proc_rslt_rsn = 'Interface Cancel!', ");
        updateQuery1.append("\n       fac_if_usr_id = NULL, ");
        updateQuery1.append("\n       fac_if_dt = NULL, ");
        updateQuery1.append("\n       accl_flg = 'N', ");
        updateQuery1.append("\n       csr_no = NULL, ");
        updateQuery1.append("\n       upd_usr_id = ?, ");	//:userId
        updateQuery1.append("\n       upd_dt = SYSDATE ");
        updateQuery1.append("\n WHERE bkg_no = ? ");		//:bkg_no
        updateQuery1.append("\n   AND bkg_no_split = ? ");	//:bkg_no_split
        updateQuery1.append("\n   AND fac_seq = ? ");		//:fac_seq
        
        ////5.DELETE AGT_AGN_COMM
        deleteQuery1.append("\nDELETE FROM agt_fac_comm ");
        deleteQuery1.append("\n WHERE bkg_no = ? ");		//:bkg_no
        deleteQuery1.append("\n   AND bkg_no_split = ? ");	//:bkg_no_split
        deleteQuery1.append("\n   AND fac_seq > ? ");		//:fac_seq

        try {
            con = getConnection();
            
            // Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
            	selectPs1 = new LoggableStatement(con, selectQuery1.toString());
            	selectPs2 = new LoggableStatement(con, selectQuery2.toString());
            	selectPs3 = new LoggableStatement(con, selectQuery3.toString());
            	updatePs1 = new LoggableStatement(con, updateQuery1.toString());
            	deletePs1 = new LoggableStatement(con, deleteQuery1.toString());
            } else {
            	selectPs1 = con.prepareStatement(selectQuery1.toString());
            	selectPs2 = con.prepareStatement(selectQuery2.toString());
            	selectPs3 = con.prepareStatement(selectQuery3.toString());
            	updatePs1 = con.prepareStatement(updateQuery1.toString());
            	deletePs1 = con.prepareStatement(deleteQuery1.toString());
            }

            ////변수값 세팅
            userId = event.getUserId();
            csrNoArray = event.getObject("csrNo");
            csrNo = csrNoArray[0];
            
            
        	////1.CHECK INTERFACE RESULT
        	i = 1;
        	selectPs1.setString(i++, csrNo);
        	
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [modifyCancelBRKGCommInfo]Select SQL1 : \n" + ((LoggableStatement)selectPs1).getQueryString());
            } else {
                log.info("\n [modifyCancelBRKGCommInfo]Select SQL1 : \n" + selectQuery1.toString() );
            }            
        	rs1 = selectPs1.executeQuery();
        	
        	while(rs1.next()){
        		ifFlag = rs1.getString(1);
        		rcvFlag = rs1.getString(2);
        	}

            //ifFlag = "E";
        	//rcvFlag = "E";
        	////인터페이스 결과가 '정상'이라면 에러메시지 출력
            if((ifFlag == null || ifFlag.equals("Y")) && (rcvFlag == null || rcvFlag.equals("Y"))){
            	//[$s]CSR No does not cancel! Because interface status is success!
		    	throw new DAOException((new ErrorHandler("AGT00067", new String[]{csrNo})).getMessage());
            }

            
            ////2.SEARCH
            i = 1;
            selectPs2.setString(i++, csrNo);
            
            //Loggable Statement 사용에 의해 추가
            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                log.info("\n [modifyCancelFACInfo]Select SQL2 : \n" + ((LoggableStatement)selectPs2).getQueryString());
            } else {
                log.info("\n [modifyCancelFACInfo]Select SQL2 : \n" + selectQuery2.toString() );
            }            
            rs2 = selectPs2.executeQuery();
            
            while(rs2.next()){
            	bkgNo = rs2.getString(1);
            	bkgNoSplit = rs2.getString(2);
            	facSeq = rs2.getInt(3);
            	
            	
            	////3.CHECK
            	i = 1;
            	selectPs3.setString(i++, bkgNo);
            	selectPs3.setString(i++, bkgNoSplit);
            	selectPs3.setInt(i++, facSeq);
            	
                //Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                    log.info("\n [modifyCancelFACInfo]Select SQL3 : \n" + ((LoggableStatement)selectPs3).getQueryString());
                } else {
                    log.info("\n [modifyCancelFACInfo]Select SQL3 : \n" + selectQuery3.toString() );
                }            
                rs3 = selectPs3.executeQuery();
                
                while(rs3.next()){
                	cnt = rs3.getInt(1);
                }
                closeResultSet(rs3);
            	
            	
                ////취소하려는 건 이후에 인터페이스 완료된 건이 있다면 에러메시지 출력
                if(cnt > 0){
                	//[$s]CSR No does not cancel! Because another CSR is interfaced!
			    	throw new DAOException((new ErrorHandler("AGT00068", new String[]{csrNo})).getMessage());
                }

            	////4.UPDATE AGT_AGN_COMM
                i = 1;
                updatePs1.setString(i++, userId);
                updatePs1.setString(i++, bkgNo);
                updatePs1.setString(i++, bkgNoSplit);
                updatePs1.setInt(i++, facSeq);
                
                //Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                    log.info("\n [modifyCancelFACInfo]Update SQL1 : \n" + ((LoggableStatement)updatePs1).getQueryString());
                } else {
                    log.info("\n [modifyCancelFACInfo]Update SQL1 : \n" + updateQuery1.toString() );
                }            
                updatePs1.execute();
            	

                ////5.DELETE AGT_AGN_COMM
                i = 1;
                deletePs1.setString(i++, bkgNo);
                deletePs1.setString(i++, bkgNoSplit);
                deletePs1.setInt(i++, facSeq);
                
                //Loggable Statement 사용에 의해 추가
                if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
                    log.info("\n [modifyCancelFACInfo]Delete SQL1 : \n" + ((LoggableStatement)deletePs1).getQueryString());
                } else {
                    log.info("\n [modifyCancelFACInfo]Delete SQL1 : \n" + deleteQuery1.toString() );
                }            
                deletePs1.execute();
            	
            } //while(rs1.next()){
                        
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } finally {
        	closeResultSet(rs1);
        	closeResultSet(rs2);
        	closeResultSet(rs3);
        	closeStatement(selectPs1);
        	closeStatement(selectPs2);
        	closeStatement(selectPs3);
            closeStatement(updatePs1);
        	closeStatement(deletePs1);
            closeConnection(con);
        }
        
        return dRs;
    }
    */
	/**
	 * 해당 데이터를 원하는 소수점 짜리로 반올림해서 리턴한다.<br>
	 * 
	 * @param roundValue double
	 * @param c int 소수점 자리수
	 * @return String 결과값
	 * @throws Exception
	 */
	 public double roundValue(double roundValue, int c) {
		 double returnDouble = 0;

		 try{
			 BigDecimal bd = new BigDecimal(roundValue);
			 returnDouble = Double.parseDouble(""+bd.setScale(c, BigDecimal.ROUND_HALF_UP));
		 }catch (Exception e) {
				log.error(e.getMessage(), e);
		 }
         return returnDouble;
	 }	
}
