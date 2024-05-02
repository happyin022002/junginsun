/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CargoTrackingDBDAO.java
*@FileTitle : CargoTrackingDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-24
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-24 Seong-mun Kang
* 1.0 최초 생성
* 2007-04-30 JeongSeon An
* MailCargoTracking과 검색 결과를 일치 시킴
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.integraion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo.CargoTrackingOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration.RailTransitReportDBDAOSearchCLMCountRSQL;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration.RailTransitReportDBDAOSearchCLMListRSQL;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-SCE에 대한 DB 처리를 담당<br>
 * - ENIS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seong-mun Kang
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class CargoTrackingDBDAO extends DBDAOSupport {
	
	
	/*============================================= 강성문 =========================================================*/
	/**
     * Cargo Tracking 총조회수
     * 
     * @param CargoTrackingOptionsVO ctopt
     * @return int
     * @throws DAOException
     */

   public int searchUSCargoTrackingCount(CargoTrackingOptionsVO ctopt)throws DAOException{
      	log.debug("searchUSCargoTrackingCount 실행합니다.");
      	DBRowSet dbRowset = null;
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {
    			if (ctopt != null) {
    				Map<String, String> mapVO = ctopt.getColumnValues();
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    				//log.debug("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
    			}
    			dbRowset = new SQLExecuter("").executeQuery(
    					(ISQLTemplate) new CargoTrackingDBDAOSearchUSCargoTrackingCountRSQL(),
    					param, velParam);
    		    if(dbRowset.getRowCount()>0){
    		    	dbRowset.next();
    		    	return dbRowset.getInt(1);
    		    }else{
    		    	return 0;
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
    * Cargo Tracking 총조회 List
    * 
    * @param CargoTrackingOptionsVO ctopt
    * @return DBRowSet
    * @throws DAOException
    */
    public DBRowSet searchUSCargoTrackingList(CargoTrackingOptionsVO ctopt)throws DAOException{
    	log.debug("searchUSCargoTrackingList를 실행합니다.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ctopt != null) {
				Map<String, String> mapVO = ctopt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//log.debug("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CargoTrackingDBDAOSearchUSCargoTrackingListRSQL(),
					param, velParam);
			

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}    

// 20080923 미사용table관련 정리    
//    public int searchUSCargoTrackingCount_old(RequestDataSetBC dataSet) throws DAOException {
//    	
//    	Connection con    = null;
//        PreparedStatement  pstmt   = null;
//        ResultSet  rs     = null;
//        int        totCnt = 0 ;
//
//        StringBuffer queryStr = new StringBuffer("") ;
//        queryStr.append(" --[UI038_UScargoTracking : HEAD]  \n") ;
//        queryStr.append(" SELECT /*+ALL_ROWS */ COUNT(t1.eq_no) tot_cnt  \n") ;
//        queryStr.append(" FROM   (SELECT  tcntr.eq_no                --COP NO_Hidden	    \n") ;
//        queryStr.append(" 		      ,tcntr.cust_cnt_cd                 --forInputCondition  \n") ;
//        queryStr.append(" 		      ,tcntr.cust_seq	                 --forInputCondition  \n") ;
//        queryStr.append(" 		      ,tcntr.sc_no                       --forInputCondition  \n") ;	    
//        queryStr.append(" 	FROM ( SELECT sch.cntr_no eq_no          --CNTR       \n") ;
//        queryStr.append(" 		      ,max(scage.cop_expt_no||sche.cop_expt_no||scde.cop_expt_no||srboe.cop_expt_no) cop_expt_no  \n") ;
//        queryStr.append(" 		      ,max(bbc.cust_cnt_cd) cust_cnt_cd  --forInputCondition  \n") ;
//        queryStr.append(" 		      ,max(bbc.cust_seq) cust_seq	 --forInputCondition  \n") ;
//        queryStr.append(" 		      ,max(sch.sc_no) sc_no              --forInputCondition  \n") ;
//        queryStr.append(" 	      from bkg_bkg_cust   bbc                       \n") ;
//        queryStr.append(" 		  ,bkg_booking    bb                        \n") ;
//        queryStr.append(" 		  ,sce_cop_hdr    sch                       \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl    scd                       \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl    scd2                      \n") ;              
//        queryStr.append(" 		  ,sce_cop_dtl    scd3                      \n") ;      
//        queryStr.append(" 		  ,edi_usa_ib_cgo_rlse euicr                \n") ;
//        queryStr.append(" 		  ,trs_trsp_rail_bil_ord ttrbo	            \n") ;
//        queryStr.append(" 		  ,trs_trsp_rail_bil_vndr_set ttrbvs        \n") ;
//        queryStr.append(" 		  ,sce_rail_splc  srs		            \n") ;      
//        queryStr.append(" 		  ,mdm_vendor     mv 		            \n") ;     
//        queryStr.append(" 		  ,mdm_location   ml                        \n") ; 
//        queryStr.append(" 		  ,mdm_activity   ma                        \n") ;
//        queryStr.append(" 		  ,sce_cost_act_grp_expt scage              \n") ;
//        queryStr.append(" 		  ,sce_cop_hdr_expt sche                    \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl_expt scde                    \n") ;
//        queryStr.append(" 		  ,sce_rail_bil_ord_expt srboe             \n") ;       
//        queryStr.append(" 	     where sch.bkg_no                 = bbc.bkg_no        \n") ;
//        queryStr.append(" 	     and   sch.bkg_no_split           = bbc.bkg_no_split      \n") ;
//        queryStr.append(" 	     and   sch.cop_sts_cd             IN ('C','T')   \n") ;
//        queryStr.append(" 	     and   sch.cntr_no                <> 'SMCU0000000'  \n") ;
//        queryStr.append(" 	     AND   (ml.loc_cd                  = SUBSTR(sch.del_cd,1,5) AND   ml.conti_cd  = 'M' )  \n") ;
//        queryStr.append(" 	     AND   scd.cop_no                 = sch.cop_no    \n") ;
//        queryStr.append(" 	     AND   scd.act_sts_cd             = 'C'  \n") ;
//        queryStr.append(" 	     AND   scd2.cop_no(+)             = scd.cop_no  \n") ;
//        queryStr.append(" 	     and   scd2.act_sts_cd(+)         = 'F'  \n") ;
//        queryStr.append(" 	     AND   scd3.cop_no(+)             = scd.cop_no  \n") ;
//        queryStr.append(" 	     and   scd3.act_cd(+)             = 'FUVMUD'  \n") ;
//        queryStr.append(" 	     AND   scd2.act_cd                = ma.act_cd(+)     \n") ;
//        queryStr.append(" 	     AND   SUBSTR(scd2.nod_cd,1,5)    = ml.loc_cd(+)    \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no                 = bb.bkg_no     \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no_split           = bb.bkg_no_split    \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no                 = ttrbo.bkg_no(+)     \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no_split           = ttrbo.bkg_no_split(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbo.arr_splc_cd          = srs.splc_cd(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_ofc_cty_cd   = ttrbvs.trsp_so_ofc_cty_cd(+)     \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_seq          = ttrbvs.trsp_so_seq(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbvs.vndr_seq            = mv.vndr_seq(+)    \n") ;
//        queryStr.append(" 	     AND   bb.bl_no                   = euicr.bl_no(+)     \n") ;
//        queryStr.append(" 	     AND   bb.bl_no_tp                = euicr.bl_no_tp(+)     \n") ;
//        queryStr.append(" 	     AND   bb.bl_no_chk               = euicr.bl_no_chk(+)  \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = scage.cop_no(+)     \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = sche.cop_no(+)  \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = scde.cop_no(+)  \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_ofc_cty_cd   = srboe.trsp_so_ofc_cty_cd(+)  \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_seq          = srboe.trsp_so_seq(+)  \n") ;
//        queryStr.append(" 	     GROUP BY sch.cntr_no ) tcntr  \n") ;
//        queryStr.append(" 	     ,sce_cop_expt sce  \n") ;
//        queryStr.append(" 	where tcntr.cop_expt_no = sce.cop_expt_no(+) ) t1  \n") ;
//        queryStr.append(" --[화면조건 입력]--------------------------------------------------------------------------	  \n") ;
//    	String custCntCD  = dataSet.getString("cust_cnt_seq").substring(0,2) ;
//        String custSeq    = dataSet.getString("cust_cnt_seq").substring(2) ;
//        String scNo       = dataSet.getString("sc_no") ;
//        
//        log.debug("\n custCntCD["+custCntCD+"] custSeq["+custSeq+"] scNo["+scNo+"]");
//        
//        if(dataSet.get("cust_cnt_seq")!=null && !dataSet.getString("cust_cnt_seq").trim().equals("")){
//            queryStr.append(" WHERE t1.cust_cnt_cd 	                  = '"+custCntCD+"'  \n") ;
//            queryStr.append(" and   t1.cust_seq                       = '"+custSeq+"'  \n") ;
//            if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//            	queryStr.append(" and   t1.sc_no                          = '"+scNo+"'  \n") ;
//            }
//        }else if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//        	queryStr.append(" WHERE  t1.sc_no                          = '"+scNo+"'  \n") ;
//        }
//        
//        try {
//            con  = getConnection();
//            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//            	pstmt = new LoggableStatement(con, queryStr.toString());
//            }else{
//            	pstmt = con.prepareStatement(queryStr.toString());
//            }
//            log.debug("\n SQL : "+queryStr.toString());
//            rs = pstmt.executeQuery() ;
//            if(rs!=null&&rs.next()){
//            	totCnt = rs.getInt("tot_cnt") ;
//            }
//            
//        } catch (SQLException se) {
//        	log.error(se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//        	log.error(de.getMessage(), de);
//            throw de;
//        }finally {
//            closeResultSet(rs);
//            closeStatement(pstmt);
//            closeConnection(con);
//        }
//        
//        return totCnt;
//    }
    
//    /**
//     * Cargo Tracking 조회 리스트
//     * 
//     * @param dataSet 검색조건이 저장되어 있는 RequestDataSet
//     * @return rowSet 검색결과
//     * @throws DAOException
//     */
//  
    
// 20080923 미사용talbe관련 정리    
//    public DBRowSet searchUSCargoTrackingList_old(RequestDataSetBC dataSet) throws DAOException {
//    	
//        Connection         con    = null ;
//        PreparedStatement  pstmt  = null ;
//        ResultSet          rs     = null ;
//        DBRowSet           rowSet = null ;
//        int                idx    = 1 ;
//        
//        int cur_page = dataSet.getInt("cur_page")<0?1 :dataSet.getInt("cur_page") ;
//        int row_size = dataSet.getInt("row_size")<0?3000:dataSet.getInt("row_size") ;
//
//        StringBuffer queryStr = new StringBuffer("") ;
//        queryStr.append(" --[UI038_UScargoTracking : BODY]  \n") ;
//        queryStr.append(" SELECT /*+ALL_ROWS */ t1.*   \n") ;
//        queryStr.append(" FROM   (SELECT  tcntr.cop_no             --COP NO_Hidden  \n") ;
//        queryStr.append(" 		,tcntr.trsp_so_ofc_cty_cd      --SO NO1_Hidden      \n") ;
//        queryStr.append(" 		,tcntr.trsp_so_seq             --SO NO2_Hidden      \n") ;
//        queryStr.append(" 		    ,tcntr.eq_no                   --CNTR   \n") ;
//        queryStr.append(" 		    ,tcntr.ts                      --T/S    \n") ;
//        queryStr.append(" 		    ,tcntr.bkg_no                  --BKG    \n") ;
//        queryStr.append(" 		    ,tcntr.bkg_no_split            --BKG    \n") ;
//        queryStr.append(" 		    ,tcntr.vvd                     --VVD    \n") ;
//        queryStr.append(" 		    ,tcntr.por_cd                  --POR    \n") ;
//        queryStr.append(" 		    ,tcntr.pol_cd                  --POL    \n") ;
//        queryStr.append(" 		    ,tcntr.pod_cd                  --POD    \n") ;
//        queryStr.append(" 		    ,tcntr.del_cd                  --DEL    \n") ;
//        queryStr.append(" 		    ,tcntr.rd_term_cd              --R/D Term     \n") ;
//        queryStr.append(" 		    ,tcntr.local_ipi               --Local/IPI    \n") ;
//        queryStr.append(" 		    ,tcntr.c_act                   --Current Acitivity    \n") ;
//        queryStr.append(" 	        ,tcntr.c_act_date              --Date/Time  \n") ;
//        queryStr.append(" 	        ,tcntr.c_act_time              --Date/Time  \n") ;
//        queryStr.append(" 		    ,tcntr.nod                     --Location   \n") ; 
//        queryStr.append(" 		    ,tcntr.vd_date                 --VD Date/Time    \n") ;
//        queryStr.append(" 		    ,tcntr.vd_time                 --VD Date/Time    \n") ;
//        queryStr.append(" 		    ,tcntr.f                       --F   \n") ;
//        queryStr.append(" 		    ,tcntr.o                       --O   \n") ;
//        queryStr.append(" 		    ,tcntr.c                       --C   \n") ;
//        queryStr.append(" 		    ,tcntr.hold                    --Hold  \n") ;  
//        queryStr.append(" 		    ,tcntr.hold_r_date             --Release    \n") ;
//        queryStr.append(" 		    ,tcntr.hold_r_time             --Release    \n") ;
//        queryStr.append(" 		    ,tcntr.l_free_date             --Last Free Date    \n") ;
//        queryStr.append(" 		    ,tcntr.l_free_time             --Last Free Date    \n") ;
//        queryStr.append(" 		    ,tcntr.hot                     --Hot Delivery    \n") ;
//        queryStr.append(" 		    ,tcntr.rail_com                --Rail Company    \n") ;
//        queryStr.append(" 		    ,tcntr.fm_nod_cd               --Rail Origin     \n") ;
//        queryStr.append(" 		    ,tcntr.rail_etd_date           --Estimated Departure    \n") ;
//        queryStr.append(" 		    ,tcntr.rail_etd_time           --Estimated Departure    \n") ;
//        queryStr.append(" 		    ,tcntr.org_out_date            --Actual Departure    \n") ;
//        queryStr.append(" 		    ,tcntr.org_out_time            --Actual Departure    \n") ;
//        queryStr.append(" 		    ,tcntr.to_nod_cd               --Rail Desination     \n") ;
//        queryStr.append(" 		    ,tcntr.rail_eta_date           --Estimated Arrival    \n") ;
//        queryStr.append(" 		    ,tcntr.rail_eta_time           --Estimated Arrival    \n") ;
//        queryStr.append(" 		    ,tcntr.dest_in_date            --Actual Arrival    \n") ;
//        queryStr.append(" 		    ,tcntr.dest_in_time            --Actual Arrival    \n") ;
//        queryStr.append(" 		    ,tcntr.l_rail_loc              --Last Rail Location    \n") ;
//        queryStr.append(" 		    ,tcntr.l_rail_ata_date         --Last Rail Date/Time    \n") ;
//        queryStr.append(" 		    ,tcntr.l_rail_ata_time         --Last Rail Date/Time    \n") ;
//        queryStr.append(" 		    --5.DeliveryInformation----------------------------------------------    \n") ;
//        queryStr.append(" 		    ,tcntr.pick_up_avail           --Pick-Up Available    \n") ;
//        queryStr.append(" 		    ,tcntr.gate_out_etd_date       --Out-Gate    \n") ;
//        queryStr.append(" 		    ,tcntr.gate_out_etd_time       --Out-Gate    \n") ;
//        queryStr.append(" 		    ,tcntr.door_eta_date           --Esimated Door Delivery    \n") ;
//        queryStr.append(" 		    ,tcntr.door_eta_time           --Esimated Door Delivery    \n") ;
//        queryStr.append(" 		    ,tcntr.door_ata_date           --Actual Door Delivery    \n") ;
//        queryStr.append(" 		    ,tcntr.door_ata_time           --Actual Door Delivery    \n") ;
//        queryStr.append(" 		    --6.Exception--------------------------------------------------------    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(sce.occr_dt, 'YYYY-MM-DD') expt_date               --Exception Date/Time    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(sce.occr_dt, 'HH24:MI') expt_time                  --Exception Date/Time    \n") ;
//        queryStr.append(" 		    ,sce.occr_nod_cd  occr_nod_cd                               --Exception Location    \n") ;
//        queryStr.append(" 		    ,sce.cop_expt_rsn sts_desc                                  --Exception Reason      \n") ;
//        queryStr.append(" 		    ,'' etd_rail_date                                           --Esimated Rail Departure Date/Time    \n") ;
//        queryStr.append(" 		    ,'' etd_rail_time                                           --Esimated Rail Departure Date/Time    \n") ;		    
//        queryStr.append(" 		    ,tcntr.cust_cnt_cd                                                --forInputCondition  \n") ;
//        queryStr.append(" 		    ,tcntr.cust_seq	                                                --forInputCondition  \n") ;
//        queryStr.append(" 		    ,tcntr.sc_no                                                      --forInputCondition  \n") ;
//        queryStr.append(" 	FROM ( SELECT max(sch.cop_no) cop_no                                       --COP No                        \n") ;          							
//        queryStr.append(" 		  ,max(ttrbo.trsp_so_ofc_cty_cd) trsp_so_ofc_cty_cd            --SO NO1                            \n") ;     							
//        queryStr.append(" 		  ,max(ttrbo.trsp_so_seq) trsp_so_seq                          --SO NO2    \n") ;
//        queryStr.append(" 		------------------------------------------------------------------------    \n") ;
//        queryStr.append(" 		    ,sch.cntr_no eq_no                                                  --CNTR      \n") ; 
//        queryStr.append(" 		    ,max(sch.cntr_tpsz_cd) ts                                          --T/S    \n") ;
//        queryStr.append(" 		    ,max(bb.bkg_no) bkg_no                                             --BKG       \n") ;
//        queryStr.append(" 		    ,max(bb.bkg_no_split)  bkg_no_split                                --BKG      \n") ;
//        queryStr.append(" 		    --,max(bb.bl_no||bb.bl_no_tp||bb.bl_no_chk) bl                           --B/L    \n") ;
//        queryStr.append(" 		    ,max(bb.vsl_cd||bb.skd_voy_no||bb.skd_dir_cd) vvd                  --VVD    \n") ;
//        queryStr.append(" 		    ,max(bb.por_cd) por_cd                                             --POR    \n") ;
//        queryStr.append(" 		    ,max(bb.pol_cd) pol_cd                                             --POL    \n") ;
//        queryStr.append(" 		    ,max(bb.pod_cd) pod_cd                                             --POD    \n") ;
//        queryStr.append(" 		    ,max(bb.del_cd) del_cd                                             --DEL    \n") ;
//        queryStr.append(" 		    ,max(bb.rcv_term_cd||'/'||bb.de_term_cd) rd_term_cd                --R/D Term     \n") ;
//        queryStr.append(" 		    ,DECODE(max(euicr.ibd_ipi_locl_ind_cd), 'L', 'Local','I', 'IPI') local_ipi  --Local/IPI   \n") ; 
//        queryStr.append(" 		    ,nvl(max(ma.act_nm),'Not Start') c_act                             --Current Acitivity    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd2.act_dt), 'YYYY-MM-DD') c_act_date                --Date/Time    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd2.act_dt), 'HH24:MI') c_act_time                   --Date/Time    \n") ;
//        queryStr.append(" 		    ,max(ml.loc_nm) nod                                                --Location   \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd3.estm_dt), 'YYYY-MM-DD') vd_date                  --VD Date/Time    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd3.estm_dt), 'HH24:MI') vd_time                     --VD Date/Time    \n") ;
//        queryStr.append(" 		    ,max(euicr.cgor_frt_pay_ind_flg) f                                 --F    \n") ;
//        queryStr.append(" 		    ,max(euicr.cgor_org_bl_rcvr_ind_flg) o                             --O    \n") ;
//        queryStr.append(" 		    ,max(euicr.cstms_acpt_flg) c                                       --C    \n") ;
//        queryStr.append(" 		    ,'' hold                                                           --Hold    \n") ;
//        queryStr.append(" 		    ,'' hold_r_date                                                    --Release    \n") ;
//        queryStr.append(" 		    ,'' hold_r_time                                                    --Release    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.lst_free_dt), 'YYYY-MM-DD') l_free_date         --Last Free Date    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.lst_free_dt), 'HH24:MI') l_free_time            --Last Free Date    \n") ;
//        queryStr.append(" 		    ,max(bb.bkg_hot_de_flg) hot                                        --Hot Delivery    \n") ;
//        queryStr.append(" 		    ,max(mv.usa_edi_cd) rail_com                                       --Rail Company   \n") ;
//        queryStr.append(" 		    ,max(ttrbo.fm_nod_cd) fm_nod_cd                                    --Rail Origin     \n") ;
//        queryStr.append(" 		    ,(CASE WHEN  max(scd.act_cd)  IN ('FIRRDO', 'FORRDO') THEN  TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD') END) rail_etd_date  --Estimated Departure    \n") ;
//        queryStr.append(" 		    ,(CASE WHEN  max(scd.act_cd)  IN ('FIRRDO', 'FORRDO') THEN  TO_CHAR(max(scd.estm_dt), 'HH24:MI')  END) rail_etd_time   --Estimated Departure    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.org_gate_out_dt), 'YYYY-MM-DD') org_out_date    --Actual Departure    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.org_gate_out_dt), 'HH24:MI') org_out_time       --Actual Departure    \n") ;
//        queryStr.append(" 		    ,max(ttrbo.to_nod_cd) to_nod_cd                                    --Rail Desination     \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD') rail_eta_date             --Estimated Arrival    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(scd.estm_dt), 'HH24:MI') rail_eta_time                --Estimated Arrival    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.dest_gate_in_dt), 'YYYY-MM-DD') dest_in_date    --Actual Arrival    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.dest_gate_in_dt), 'HH24:MI') dest_in_time       --Actual Arrival    \n") ;
//        queryStr.append(" 		    ,max(srs.loc_cd) l_rail_loc                                        --Last Rail Location    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.arr_dt), 'YYYY-MM-DD') l_rail_ata_date          --Last Rail Date/Time    \n") ;
//        queryStr.append(" 		    ,TO_CHAR(max(ttrbo.arr_dt), 'HH24:MI') l_rail_ata_time             --Last Rail Date/Time    \n") ;
//        queryStr.append(" 		    ,DECODE(max(ttrbo.dest_aval_dt), '', 'N', 'Y') pick_up_avail       --Pick-Up Available    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITYDO', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD')) gate_out_etd_date    --Out-Gate    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITYDO', TO_CHAR(max(scd.estm_dt), 'HH24:MI')) gate_out_etd_time       --Out-Gate    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD HH24:MI')) door_eta_date  --Estimated Door Delivery    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.estm_dt), 'YYYY-MM-DD HH24:MI')) door_eta_time  --Estimated Door Delivery    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.act_dt), 'YYYY-MM-DD HH24:MI')) door_ata_date   --Actual Door Delivery    \n") ;
//        queryStr.append(" 		    ,DECODE(max(scd.act_cd), 'FITZAD', TO_CHAR(max(scd.act_dt), 'YYYY-MM-DD HH24:MI')) door_ata_time   --Actual Door Delivery    \n") ;
//        queryStr.append(" 		    ---------------------------------------------------------------------  \n") ;
//        queryStr.append(" 		    ,max(scage.cop_expt_no||sche.cop_expt_no||scde.cop_expt_no||srboe.cop_expt_no) cop_expt_no  \n") ;
//        queryStr.append(" 		    ,max(bbc.cust_cnt_cd) cust_cnt_cd                                  --forInputCondition  \n") ;
//        queryStr.append(" 		    ,max(bbc.cust_seq) cust_seq	                                       --forInputCondition  \n") ;
//        queryStr.append(" 		    ,max(sch.sc_no) sc_no                                              --forInputCondition  \n") ;
//        queryStr.append(" 	     from bkg_bkg_cust   bbc                        \n") ;
//        queryStr.append(" 		  ,bkg_booking    bb                        \n") ;
//        queryStr.append(" 		  ,sce_cop_hdr    sch                       \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl    scd  \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl    scd2         \n") ;              
//        queryStr.append(" 		  ,sce_cop_dtl    scd3                 \n") ;      
//        queryStr.append(" 		  ,edi_usa_ib_cgo_rlse euicr                \n") ;
//        queryStr.append(" 		  ,trs_trsp_rail_bil_ord ttrbo	             \n") ;
//        queryStr.append(" 		  ,trs_trsp_rail_bil_vndr_set ttrbvs        \n") ;
//        queryStr.append(" 		  ,sce_rail_splc  srs		                 \n") ;
//        queryStr.append(" 		  ,mdm_vendor     mv 		                 \n") ;
//        queryStr.append(" 		  ,mdm_location   ml                        \n") ;
//        queryStr.append(" 		  ,mdm_activity   ma   \n") ;
//        queryStr.append(" 		  ,sce_cost_act_grp_expt scage  \n") ;
//        queryStr.append(" 		  ,sce_cop_hdr_expt sche  \n") ;
//        queryStr.append(" 		  ,sce_cop_dtl_expt scde  \n") ;
//        queryStr.append(" 		  ,sce_rail_bil_ord_expt srboe  \n") ;
//        queryStr.append(" 	     where sch.bkg_no                 = bbc.bkg_no        \n") ;
//        queryStr.append(" 	     and   sch.bkg_no_split           = bbc.bkg_no_split      \n") ;
//        queryStr.append(" 	     and   sch.cop_sts_cd             IN ('C','T')   \n") ;
//        queryStr.append(" 	     and   sch.cntr_no                <> 'SMCU0000000'  \n") ;
//        queryStr.append(" 	     AND   (ml.loc_cd                  = SUBSTR(sch.del_cd,1,5) AND   ml.conti_cd  = 'M' )  \n") ;
//        queryStr.append(" 	     AND   scd.cop_no                 = sch.cop_no    \n") ;
//        queryStr.append(" 	     AND   scd.act_sts_cd             = 'C'  \n") ;
//        queryStr.append(" 	     AND   scd2.cop_no(+)             = scd.cop_no  \n") ;
//        queryStr.append(" 	     and   scd2.act_sts_cd(+)         = 'F'  \n") ;
//        queryStr.append(" 	     AND   scd3.cop_no(+)             = scd.cop_no  \n") ;
//        queryStr.append(" 	     and   scd3.act_cd(+)             = 'FUVMUD'  \n") ;
//        queryStr.append(" 	     AND   scd2.act_cd                = ma.act_cd(+)     \n") ;
//        queryStr.append(" 	     AND   SUBSTR(scd2.nod_cd,1,5)    = ml.loc_cd(+)    \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no                 = bb.bkg_no     \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no_split           = bb.bkg_no_split    \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no                 = ttrbo.bkg_no(+)     \n") ;
//        queryStr.append(" 	     AND   bbc.bkg_no_split           = ttrbo.bkg_no_split(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbo.arr_splc_cd          = srs.splc_cd(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_ofc_cty_cd   = ttrbvs.trsp_so_ofc_cty_cd(+)     \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_seq          = ttrbvs.trsp_so_seq(+)    \n") ;
//        queryStr.append(" 	     AND   ttrbvs.vndr_seq            = mv.vndr_seq(+)    \n") ;
//        queryStr.append(" 	     AND   bb.bl_no                   = euicr.bl_no(+)     \n") ;
//        queryStr.append(" 	     AND   bb.bl_no_tp                = euicr.bl_no_tp(+)     \n") ;
//        queryStr.append(" 	     AND   bb.bl_no_chk               = euicr.bl_no_chk(+)  \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = scage.cop_no(+)     \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = sche.cop_no(+)  \n") ;
//        queryStr.append(" 	     AND   sch.cop_no                 = scde.cop_no(+)  \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_ofc_cty_cd   = srboe.trsp_so_ofc_cty_cd(+)  \n") ;
//        queryStr.append(" 	     AND   ttrbo.trsp_so_seq          = srboe.trsp_so_seq(+)  \n") ;
//        queryStr.append(" 	     GROUP BY sch.cntr_no ) tcntr,  \n") ;
//        queryStr.append(" 	     sce_cop_expt sce  \n") ;
//        queryStr.append(" 	where tcntr.cop_expt_no = sce.cop_expt_no(+)  \n") ;
//        queryStr.append(" 	order by (tcntr.bkg_no||tcntr.bkg_no_split), tcntr.vvd ) t1  \n") ;
//        queryStr.append("  WHERE   CEIL(rownum/?) = ?  \n") ;
//        queryStr.append(" --[화면조건 입력]--------------------------------------------------------------------------	  \n") ;
//    	String custCntCD  = dataSet.getString("cust_cnt_seq").substring(0,2) ;
//        String custSeq    = dataSet.getString("cust_cnt_seq").substring(2) ;
//        String scNo       = dataSet.getString("sc_no") ;
//        
//        log.debug("\n custCntCD["+custCntCD+"] custSeq["+custSeq+"] scNo["+scNo+"]");
//        
//        if(dataSet.get("cust_cnt_seq")!=null && !dataSet.getString("cust_cnt_seq").trim().equals("")){
//            queryStr.append(" and   t1.cust_cnt_cd 	                  = '"+custCntCD+"'  \n") ;
//            queryStr.append(" and   t1.cust_seq                       = '"+custSeq+"'  \n") ;
//            if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//            	queryStr.append(" and   t1.sc_no                          = '"+scNo+"'  \n") ;
//            }
//        }else if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//        	queryStr.append(" and  t1.sc_no                          = '"+scNo+"'  \n") ;
//        }
//
//        try {
//            con  = getConnection();
//            
//            if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//  				pstmt = new LoggableStatement(con, queryStr.toString());
//  			}else{
//  				pstmt = con.prepareStatement(queryStr.toString());
//  			}
//            
//            pstmt.setInt(idx++, row_size);
//			pstmt.setInt(idx++, cur_page);
//			
//			if(LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true") ){
//				log.info(" SQL :\n" + ((LoggableStatement)pstmt).getQueryString()) ;
//      	  	}else{
//      	  		log.info(" SQL :\n" + queryStr ) ;
//      	  	}
//			
//			rs     = pstmt.executeQuery() ;
//			rowSet = new DBRowSet() ;
//			rowSet.populate(rs) ;
//            
//        } catch (SQLException se) {
//        	log.error(se.getMessage(), se) ;
//            throw new DAOException(new ErrorHandler(se).getMessage()) ;
//        } catch (DAOException de) {
//        	log.error(de.getMessage(), de) ;
//            throw de;
//        }finally {
//            closeResultSet(rs) ;
//            closeStatement(pstmt) ;
//            closeConnection(con) ;
//        }
//        
//        return rowSet ;
//    }    
//    /**
//     * Rail Transit Report 검색 조건
//     * 
//     * @param queryStr
//     * @param dataSet
//     */
//    private void setCargoTrackingListCondition(StringBuffer queryStr, RequestDataSetBC dataSet){
//    	
//    	String custCntCD  = (dataSet.get("cust_cnt_seq")!=null && !dataSet.getString("cust_cnt_seq").trim().equals(""))?dataSet.getString("cust_cnt_seq").substring(0,2):"" ;
//        String custSeq    = (dataSet.get("cust_cnt_seq")!=null && !dataSet.getString("cust_cnt_seq").trim().equals(""))?dataSet.getString("cust_cnt_seq").substring(2):"" ;
//        String scNo       = dataSet.getString("sc_no") ;
//        String porCD      = dataSet.getString("por_cd") ;
//        String polCD      = dataSet.getString("pol_cd") ;
//        String podCD      = dataSet.getString("pod_cd") ;
//        String delCD      = dataSet.getString("del_cd") ;   	
//    	
//        log.debug("\n custCntCD["+custCntCD+"] custSeq["+custSeq+"] scNo["+scNo+"] porCD["+porCD+"] polCD["+polCD+"] podCD["+podCD+"] delCD["+delCD+"]" );
//        //JSPUtil.replace(dataSet.get("pod_pol").toString(),"'","''")
//        if(dataSet.get("cust_cnt_seq")!=null && !dataSet.getString("cust_cnt_seq").trim().equals("")){
//            queryStr.append(" AND   bbc.cust_cnt_cd                   = '"+JSPUtil.replace(custCntCD,"'","''")+"'  \n") ;
//            queryStr.append(" AND   bbc.cust_seq                      = '"+JSPUtil.replace(custSeq,"'","''")+"'  \n") ;
//            queryStr.append(" AND   bbc.bkg_cust_tp_cd                IN ('S', 'C', 'N') \n") ;
//            if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//            	queryStr.append(" AND   srtr.sc_no                        = '"+JSPUtil.replace(scNo,"'","''")+"'  \n") ;
//            }
//        }else if(dataSet.get("sc_no")!=null && !dataSet.getString("sc_no").trim().equals("")){
//        	queryStr.append(" AND   srtr.sc_no                        = '"+JSPUtil.replace(scNo,"'","''")+"'  \n") ;
//        }
//        
//        //date
//        String dateKind = dataSet.getString("date_kind") ;
//    	String fmDT = dataSet.getString("fm_dt") ;
//    	String toDT = dataSet.getString("to_dt") ;
//
//        if(!dateKind.equals("")&&!fmDT.equals("")&&!toDT.equals("")){
//        	
//        	fmDT = dataSet.getString("fm_dt")+" 00:00:00" ;
//        	toDT = dataSet.getString("to_dt")+" 23:59:59" ;
//        	
//        	if(dateKind.equals("S")){
//        		if(!fmDT.equals("")&&!toDT.equals("")){
//        			queryStr.append(" AND     srtr.SO_CRE_DT    BETWEEN  TO_DATE('" + fmDT + "', 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE('" + toDT + "', 'YYYY-MM-DD HH24:MI:SS')      --SO DATE \n") ;
//        		}
//        	}else if(dateKind.equals("A")){
//        		if(!fmDT.equals("")&&!toDT.equals("")){
//        	    	queryStr.append(" AND     srtr.DEST_AVAL_DT BETWEEN  TO_DATE('" + fmDT + "', 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE('" + toDT + "', 'YYYY-MM-DD HH24:MI:SS')      --DA DATE \n") ;
//                }
//        	}else if(dateKind.equals("O")){
//        		if(!fmDT.equals("")&&!toDT.equals("")){
//        	    	queryStr.append(" AND    (CASE WHEN srtr.TO_NOD_CD IN ('CAVANM2', 'USLGBPT', 'USORFM2', 'USPDXM1', 'USSAVM1', 'USTIWM1') \n") ;
//        	    	queryStr.append("              THEN srtr.DEST_AVAL_DT \n") ;
//        	    	queryStr.append("              ELSE srtr.DEST_GATE_OUT_DT \n") ;
//        	    	queryStr.append("         END) BETWEEN  TO_DATE('" + fmDT + "', 'YYYY-MM-DD HH24:MI:SS')  AND  TO_DATE('" + toDT + "', 'YYYY-MM-DD HH24:MI:SS')                  --DO DATE \n") ;
//                }
//        	}
//        } 
//        
//        // POR/POL/POD/DEL
//        if(dataSet.get("por_cd")!=null && !dataSet.getString("por_cd").trim().equals("")){
//        	queryStr.append(" AND    bb.por_cd                         = '"+JSPUtil.replace(porCD,"'","''")+"'  \n") ;
//        }
//        if(dataSet.get("pol_cd")!=null && !dataSet.getString("pol_cd").trim().equals("")){
//        	queryStr.append(" AND    bb.pol_cd                         = '"+JSPUtil.replace(polCD,"'","''")+"'  \n") ;
//        }
//        if(dataSet.get("pod_cd")!=null && !dataSet.getString("pod_cd").trim().equals("")){
//        	queryStr.append(" AND    bb.pod_cd                         = '"+JSPUtil.replace(podCD,"'","''")+"'  \n") ;
//        }
//        if(dataSet.get("del_cd")!=null && !dataSet.getString("del_cd").trim().equals("")){
//        	queryStr.append(" AND    bb.del_cd                         = '"+JSPUtil.replace(delCD,"'","''")+"'  \n") ;
//        }
//                
//
//    }
    
    /**
     * Customer 이름을 가져온다
     * @param CargoTrackingOptionsVO ctopt
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchCustomerName(CargoTrackingOptionsVO ctopt)throws DAOException{
    	log.debug("searchCustomerName 실행합니다.");
    	DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ctopt != null) {
				Map<String, String> mapVO = ctopt.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//log.debug("SearchCustomerData 를 위한 조회용 VO 파라미터를 정의하였습니다.");
			}						
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CargoTrackingDBDAOSearchCustomerNameRSQL(),
					param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}  

}