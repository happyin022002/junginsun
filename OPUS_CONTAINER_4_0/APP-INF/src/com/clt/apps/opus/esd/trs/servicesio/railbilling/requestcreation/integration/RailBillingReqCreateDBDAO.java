/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingReqCreateDBDAO
*@FileTitle : RailBilling Request Creation
*Open Issues :
*Change history :
*2007-06-15 
*     수정자  : leebh
*     내   역  : 해당 Booking의 Container가 All Rail Billed 되어도 화면에 표시
*2007-10-28 
*     수정자  : leebh
*     내   역  : Full Cntr 참조 데이터 조회 성능 개선     
*
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration.RailSoManageDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.common.util.HashMapEnumeration;
import com.clt.apps.opus.esd.trs.servicesio.common.vo.CommonVo;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
//import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.TraceLogger;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic.RailBillingReqCreateBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BookingDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BookingSummary;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ContainerTypeSize;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.EmptyContainer;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.LocationDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailBillEmptyCreateVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailBillErrorVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailBillFullCreateVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailRampLocation;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.TrsRailOrderKey;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.Usa404EDISendVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.VndrUserDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.YardDetail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;
import com.clt.syscommon.common.table.TrsTrspRailBilOrdVO;
import com.clt.syscommon.common.table.SceCopHdrVO;

/**
 * ESD-TRS 에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author leebh
 * @see RailBillingReqCreateBCImpl 참조
 * @since J2EE 1.4
 */
public class RailBillingReqCreateDBDAO extends DBDAOSupport {
//	private TraceLogUtil  trcLogUtil  = new TraceLogUtil("WRS");
//	private TraceLogger  trcLogger  = new TraceLogger("WRS");
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Booking Detail)화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchBookingSummaryFull(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        Object[] result = new Object[2];

        try {
//        	trcLogger.masterBegin("searchBookingSummaryFull");
            ExpPap0010Event event = (ExpPap0010Event)et;
    		String bkgNo      = event.getBkg_no();
    		String vndrSeq    = event.getVender_cd();
    		
    		if(bkgNo == null || Constants.EMPTY.equals(bkgNo)) {
    			throw new DAOException("Booking No is incorrect.");
    		}
    		param.put("bkg_no", 	bkgNo);
    		param.put("vndr_seq", 	vndrSeq); 
    		RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL rsql = new RailBillingReqCreateDBDAOsearchBookingSummaryFullRSQL();
//            trcLogger.queryBegin("Full searchBookingSummaryFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
            BookingSummary oDTO = null;
            if(dRs != null && dRs.next()) {
            	oDTO = new BookingSummary();
                
            	oDTO.setShipper_nm		(dRs.getString("cust_nm"));
            	oDTO.setShipper_fax_no	(dRs.getString("cust_fax"));
            	oDTO.setPor_cd			(dRs.getString("por_cd"));
            	oDTO.setPor_nm			(dRs.getString("por_nm"));
            	oDTO.setPol_cd			(dRs.getString("pol_cd"));
            	oDTO.setPol_nm			(dRs.getString("pol_nm"));
            	oDTO.setBb				(dRs.getString("bb"));
            	oDTO.setHd				(dRs.getString("hd"));
            	oDTO.setRf				(dRs.getString("rf"));
            	oDTO.setRd				(dRs.getString("rd"));
            	oDTO.setDg				(dRs.getString("dg"));
            	oDTO.setAk				(dRs.getString("ak"));
            	oDTO.setSc				(dRs.getString("sc"));
            	oDTO.setRb				(dRs.getString("rb"));
            	oDTO.setBkg_cmdt_cd		(dRs.getString("bkg_cmdt_cd"));
            	oDTO.setPor_cnt_cd		(dRs.getString("por_cnt_cd"));
            	oDTO.setPol_cnt_cd		(dRs.getString("pol_cnt_cd"));
            	oDTO.setStop_off_ind	(dRs.getString("stop_off_ind"));
            	oDTO.setStatus_cd		(dRs.getString("status_cd"));
            	oDTO.setRrcv_dt_fm		(dRs.getString("rrcv_date_fm"));
            	oDTO.setRrcv_dt_to		(dRs.getString("rrcv_date_to"));
            	oDTO.setSpcl_cust_flg	(dRs.getString("spcl_cust_flg"));
//            	oDTO.setAlocStsCd		(dRs.getString("aloc_sts_cd"));
//            	oDTO.setNonRtStsCd		(dRs.getString("non_rt_sts_cd"));
            }
            
            // 조회결과
            if (oDTO == null) {
            	result[0] = null;
            }
            else {
            	result[0] = oDTO;
            }
            result[1] = new Integer(1);
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
        }
        return result;
    }
	
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Cntr List)화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchBookingDetailListFull(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        Object[] result = new Object[2];

        try {
//        	trcLogger.masterBegin("searchBookingDetailListFull");
        	ExpPap0010Event event = (ExpPap0010Event)et;
        	String bkgNo      = event.getBkg_no();
    		String vndrSeq      = event.getVender_cd();
    		// All Rail Billed된 내역도 화면에 표시 하기 위해 추가
    		int billedCnt = 0;
    		int noBilledCnt = 0;
    		
    		if(bkgNo == null || Constants.EMPTY.equals(bkgNo)) {
    			throw new DAOException("Booking No is incorrect.");
    		}
    		
       		param.put("vndr_seq", 	vndrSeq);
       		param.put("bkg_no", 	bkgNo);
    		RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL rsql = new RailBillingReqCreateDBDAOsearchBookingDetailListFullRSQL();
//            trcLogger.queryBegin("Full searchBookingDetailListFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
             
    		// 결과를 Proforma Array 에 담는다.
    		ArrayList args = new ArrayList();
	  		while(dRs != null && dRs.next()) {
	            BookingDetail bkgInfo = new BookingDetail();
	            bkgInfo.setRow_idx		("");
	            bkgInfo.setSelect_text	("");
	            bkgInfo.setIo_flag		(dRs.getString("io_flag"));
	            bkgInfo.setSo_ofc_city	(dRs.getString("so_ofc_cty_cd"));
	            bkgInfo.setSo_seq		(dRs.getString("so_seq"));
	            bkgInfo.setCntr_no		(dRs.getString("cntr_no"));
	            bkgInfo.setCntr_tpsz_cd	(dRs.getString("cntr_tpsz_cd"));
	            bkgInfo.setCntr_tpsz_nm	(dRs.getString("cntr_tpsz_nm"));
	            bkgInfo.setWeight		(dRs.getString("wgt_qty"));
	            bkgInfo.setBulk			(dRs.getString("bulk_flag"));
	            bkgInfo.setSteelwire	(dRs.getString("steel_flag"));
	            bkgInfo.setCoil_shipment(dRs.getString("coil_flag"));
	            bkgInfo.setFumigation	(dRs.getString("fum_flag"));
	            bkgInfo.setPiece		(dRs.getString("pkg_qty"));
	            bkgInfo.setAes_tp		(dRs.getString("auto_xpt_sys_cd"));
	            bkgInfo.setAes_no		(dRs.getString("auto_xpt_sys_no"));
	            bkgInfo.setVrfy_rst_cd	("");
	            bkgInfo.setVrfy_rst_msg	("");
	            bkgInfo.setVrfy_rsn_cd	("");
	            bkgInfo.setVrfy_rsn_msg	("");
	            bkgInfo.setBkg_qty		(dRs.getString("bkg_qty"));
	            bkgInfo.setRemark		(dRs.getString("remark_desc"));
	            bkgInfo.setUs_region	(dRs.getString("dvsn"));
	            bkgInfo.setTare_wgt     (dRs.getString("tare_wgt"));
//	            if(dRs.getString("tare_wgt") == null || "".equals(dRs.getString("tare_wgt")))
//	            	bkgInfo.setVgm_wgt	("");
//	            else
//	            	bkgInfo.setVgm_wgt  (Integer.toString(Integer.parseInt(dRs.getString("tare_wgt"))+Integer.parseInt(dRs.getString("wgt_qty"))));
	            
	            
	            args.add(bkgInfo);
	            
	            // All Rail Billed된 내역도 화면에 표시 하기 위해 추가
	            if(Constants.YES.equals(bkgInfo.getIo_flag())){
	            	billedCnt++;
	            } else if(Constants.NO.equals(bkgInfo.getIo_flag())){
	            	noBilledCnt++;
	            }
	  		}

	  		// 조회결과
    		if (args.size() == 0) {
    			result[0] = null;
    			result[1] = Constants.NO;
    		}
    		else {
    			result[0] = (BookingDetail[])args.toArray(new BookingDetail[0]);
    			if(billedCnt > 0 && noBilledCnt == 0){
    				result[1] = Constants.YES;
    			} else {
    				result[1] = Constants.NO;
    			}
    		}
    		
    		
    		
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
        }
        return result;
    }
	
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Excel Down)화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchTrsRailOrderListFull(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
        
		Object[] result = new Object[2];
		
		try {
//	       	trcLogger.masterBegin("searchTrsRailOrderListFull");
	        ExpPap0020Event event = (ExpPap0020Event)et;
			TrsRailOrderKey[] trsRailOrderKeyList = event.getTrsRailOrderKeyList();
			
			if(trsRailOrderKeyList == null || trsRailOrderKeyList.length <= 0) {
    			throw new DAOException("No data found.");
    		}
			for(int i = 0; i < trsRailOrderKeyList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(trsRailOrderKeyList[i].getSo_ofc_city()); 
				paramVO.setVelParamField2(trsRailOrderKeyList[i].getSo_seq()); 
				velParamArr.add(paramVO); 				
			}
	       	velParam.put("trsRailOrderKey", velParamArr);
	        
	       	RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL rsql = new RailBillingReqCreateDBDAOsearchTrsRailOrderListFullRSQL();
//			trcLogger.queryBegin("Full searchTrsRailOrderListFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
			// 결과를 Proforma Array 에 담는다.
			ArrayList args = new ArrayList();
			while(dRs != null && dRs.next()) {
				BookingDetail bkgInfo = new BookingDetail();
				bkgInfo.setRow_idx("");
				bkgInfo.setSelect_text("");
				bkgInfo.setIo_flag(dRs.getString("io_flag"));
				bkgInfo.setSo_ofc_city(dRs.getString("so_ofc_cty_cd"));
				bkgInfo.setSo_seq(dRs.getString("so_seq"));
				bkgInfo.setCntr_no(dRs.getString("cntr_no"));
				bkgInfo.setCntr_tpsz_cd(dRs.getString("cntr_tpsz_cd"));
				bkgInfo.setCntr_tpsz_nm(dRs.getString("cntr_tpsz_nm"));
				bkgInfo.setWeight(dRs.getString("wgt_qty"));
				bkgInfo.setBulk(dRs.getString("bulk_flag"));
				bkgInfo.setSteelwire(dRs.getString("steel_flag"));
				bkgInfo.setCoil_shipment(dRs.getString("coil_flag"));
				bkgInfo.setFumigation(dRs.getString("fum_flag"));
				bkgInfo.setPiece(dRs.getString("pkg_qty"));
				bkgInfo.setAes_tp(dRs.getString("auto_xpt_sys_cd"));
				bkgInfo.setAes_no(dRs.getString("auto_xpt_sys_no"));
				bkgInfo.setVrfy_rst_cd("");
				bkgInfo.setVrfy_rst_msg("");
				bkgInfo.setVrfy_rsn_cd("");
				bkgInfo.setVrfy_rsn_msg("");
				bkgInfo.setBkg_qty(dRs.getString("bkg_qty"));
				bkgInfo.setRemark(dRs.getString("remark_desc"));
				args.add(bkgInfo);
			}
			
			// 조회결과
			if (args.size() == 0) {
				result[0] = null;
			}
			else {
				result[0] = (BookingDetail[])args.toArray(new BookingDetail[0]);
			}
			result[1] = new Integer(args.size());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//		} finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
		}
		return result;
	}
	
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchRailRampLocationFull(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        Object[] result = new Object[2];

        try {
//        	trcLogger.masterBegin("searchRailRampLocationFull");
            ExpPap0010Event event = (ExpPap0010Event)et;
            String bkgNo      = event.getBkg_no();
    		
    		if(bkgNo == null || Constants.EMPTY.equals(bkgNo)) {
    			throw new DAOException("Booking No is incorrect.");
    		}
    		
       		param.put("bkg_no", 	bkgNo);

       		RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL rsql = new RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL();
//            trcLogger.queryBegin("Full searchRailRampLocationFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
 
            // rs가 여러건 이면 오류 처리 하고 fax로 수신하여 업무 처리한다.  -- 정원근 수석님
            ArrayList args = new ArrayList();
			while(dRs != null && dRs.next()) {
            	RailRampLocation oDTO = new RailRampLocation();
            	oDTO.setRout_org_nod_cd(dRs.getString("rout_org_nod_cd"));
            	oDTO.setRout_dest_nod_cd(dRs.getString("rout_dest_nod_cd"));
            	oDTO.setRout_seq(dRs.getString("rout_seq"));
            	oDTO.setPctl_io_bnd_cd(dRs.getString("pctl_io_bnd_cd"));
            	oDTO.setOrg_loc_cd(dRs.getString("org_loc_cd"));
            	oDTO.setOrg_loc_nm(dRs.getString("org_loc_nm"));
            	oDTO.setOrg_yd_cd(dRs.getString("org_yd_cd"));
            	oDTO.setOrg_yd_nm(dRs.getString("org_yd_nm"));
            	oDTO.setOrg_yd_addr(dRs.getString("org_yd_addr"));
            	oDTO.setDest_loc_cd(dRs.getString("dest_loc_cd"));
            	oDTO.setDest_loc_nm(dRs.getString("dest_loc_nm"));
            	oDTO.setDest_yd_cd(dRs.getString("dest_yd_cd"));
            	oDTO.setDest_yd_nm(dRs.getString("dest_yd_nm"));
            	oDTO.setDest_yd_addr(dRs.getString("dest_yd_addr"));
            	oDTO.setBlock_vndr_flg(dRs.getString("block_vndr_flg"));
            	oDTO.setRail_bulk_vndr_flg(dRs.getString("rail_bulk_vndr_flg"));
            	oDTO.setBill_type_flg(dRs.getString("bill_type_flg"));
            	oDTO.setEmbargo_flg(dRs.getString("embargo_flg"));
            	oDTO.setTofc_flg(dRs.getString("tofc_flg"));
            	oDTO.setWrs_full_flg(dRs.getString("wrs_full_flg"));
            	oDTO.setAuto_irg_flg(dRs.getString("auto_irg_flg"));
            	oDTO.setRail_ns_vndr_flg(dRs.getString("rail_ns_vndr_flg"));
            	args.add(oDTO);
            }
            // 조회결과
			if (args.size() == 0) {
				result[0] = null;
			}
			else {
				result[0] = (RailRampLocation[])args.toArray(new RailRampLocation[0]);
			}
			result[1] = new Integer(args.size());
			
       } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
        }
        return result;
    }
	
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchRailRampAutoAdjustLocationFull(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        Object[] result = new Object[2];

        try {
//        	trcLogger.masterBegin("searchRailRampAutoAdjustLocationFull");
            ExpPap0010Event event = (ExpPap0010Event)et;
            String bkgNo      = event.getBkg_no();
    		
    		if(bkgNo == null || Constants.EMPTY.equals(bkgNo)) {
    			throw new DAOException("Booking No is incorrect.");
    		}
    		log.debug("bkgNo " +bkgNo);
       		param.put("bkg_no", 	bkgNo);
    		
       		RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL rsql = new RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL();
//            trcLogger.queryBegin("Full searchRailRampAutoAdjustLocationFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            // rs가 여러건 이면 오류 처리 하고 fax로 수신하여 업무 처리한다.  -- 정원근 수석님
            ArrayList args = new ArrayList();
			while(dRs != null && dRs.next()) {
            	RailRampLocation oDTO = new RailRampLocation();
            	oDTO.setRout_org_nod_cd(dRs.getString("rout_org_nod_cd"));
            	oDTO.setRout_dest_nod_cd(dRs.getString("rout_dest_nod_cd"));
            	oDTO.setRout_seq(dRs.getString("rout_seq"));
            	oDTO.setOrg_loc_cd(dRs.getString("org_loc_cd"));
            	oDTO.setOrg_loc_nm(dRs.getString("org_loc_nm"));
            	oDTO.setOrg_yd_cd(dRs.getString("org_yd_cd"));
            	oDTO.setOrg_yd_nm(dRs.getString("org_yd_nm"));
            	oDTO.setOrg_yd_addr(dRs.getString("org_yd_addr"));
            	oDTO.setDest_loc_cd(dRs.getString("dest_loc_cd"));
            	oDTO.setDest_loc_nm(dRs.getString("dest_loc_nm"));
            	oDTO.setDest_yd_cd(dRs.getString("dest_yd_cd"));
            	oDTO.setDest_yd_nm(dRs.getString("dest_yd_nm"));
            	oDTO.setDest_yd_addr(dRs.getString("dest_yd_addr"));
            	oDTO.setBlock_vndr_flg(dRs.getString("block_vndr_flg"));
            	oDTO.setRail_bulk_vndr_flg(dRs.getString("rail_bulk_vndr_flg"));
            	oDTO.setBill_type_flg(dRs.getString("bill_type_flg"));
            	oDTO.setEmbargo_flg(dRs.getString("embargo_flg"));
            	oDTO.setTofc_flg(dRs.getString("tofc_flg"));
            	oDTO.setWrs_full_flg(dRs.getString("wrs_full_flg"));
            	oDTO.setAuto_irg_flg(dRs.getString("auto_irg_flg"));
            	args.add(oDTO);
            }
            
            // 조회결과
			if (args.size() == 0) {
				result[0] = null;
			}
			else {
				result[0] = (RailRampLocation[])args.toArray(new RailRampLocation[0]);
			}
			result[1] = new Integer(args.size());
			
			
			
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
        }
        return result;
    }	
	
	/**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회 이벤트 처리<br>
	 * @param routOrgNodCd
	 * @param routDestNodCd
	 * @param routSeq
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchRailRampLocationByAutoAdjustFull(String routOrgNodCd, String routDestNodCd, String routSeq) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Object[] result = new Object[2];
		
		try {
//			trcLogger.masterBegin("searchRailRampLocationByAutoAdjustFull");
			
       		param.put("routOrgNodCd", 	routOrgNodCd);
       		param.put("routDestNodCd", 	routDestNodCd);
       		param.put("routSeq", 	routSeq);
    		
       		RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL rsql =  new RailBillingReqCreateDBDAOsearchRailRampLocationByAutoAdjustFullRSQL();
//            trcLogger.queryBegin("Full searchRailRampLocationByAutoAdjustFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
			// rs가 여러건 이면 오류 처리 하고 fax로 수신하여 업무 처리한다.  -- 정원근 수석님
			ArrayList args = new ArrayList();
			while(dRs != null && dRs.next()) {
				RailRampLocation oDTO = new RailRampLocation();
				oDTO.setRout_org_nod_cd(dRs.getString("rout_org_nod_cd"));
				oDTO.setRout_dest_nod_cd(dRs.getString("rout_dest_nod_cd"));
				oDTO.setOrg_loc_cd(dRs.getString("org_loc_cd"));
				oDTO.setOrg_loc_nm(dRs.getString("org_loc_nm"));
				oDTO.setOrg_yd_cd(dRs.getString("org_yd_cd"));
				oDTO.setOrg_yd_nm(dRs.getString("org_yd_nm"));
				oDTO.setOrg_yd_addr(dRs.getString("org_yd_addr"));
				oDTO.setDest_loc_cd(dRs.getString("dest_loc_cd"));
				oDTO.setDest_loc_nm(dRs.getString("dest_loc_nm"));
				oDTO.setDest_yd_cd(dRs.getString("dest_yd_cd"));
				oDTO.setDest_yd_nm(dRs.getString("dest_yd_nm"));
				oDTO.setDest_yd_addr(dRs.getString("dest_yd_addr"));
				oDTO.setBlock_vndr_flg(dRs.getString("block_vndr_flg"));
				oDTO.setBill_type_flg(dRs.getString("bill_type_flg"));
				oDTO.setEmbargo_flg(dRs.getString("embargo_flg"));
				oDTO.setTofc_flg(dRs.getString("tofc_flg"));
				oDTO.setWrs_full_flg(dRs.getString("wrs_full_flg"));
				oDTO.setAuto_irg_flg(dRs.getString("auto_irg_flg"));
				args.add(oDTO);
			}
			
			// 조회결과
			if (args.size() == 0) {
				result[0] = null;
			}
			else {
				// 1건만 리턴
				result[0] = ((RailRampLocation[])args.toArray(new RailRampLocation[0]))[0];
			}
			result[1] = new Integer(args.size());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//		} finally {
//			trcLogger.masterEnd(TraceLogger.LIMIT_02);
		}
		return result;
	}	
	
	/**
	 * searchRailRampLocationByAllBilledFull
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchRailRampLocationByAllBilledFull(String bkgNo) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Object[] result = new Object[2];
		
		try {
			
       		param.put("bkg_no", 	bkgNo);
     		
       		RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL rsql =  new RailBillingReqCreateDBDAOsearchRailRampLocationByAllBilledFullRSQL();
//            trcLogger.queryBegin("Full searchRailRampLocationByAllBilledFull Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
			
			RailRampLocation oDTO = new RailRampLocation();
			if(dRs != null && dRs.next()) {
				oDTO.setRout_org_nod_cd(dRs.getString("rout_org_nod_cd"));
				oDTO.setRout_dest_nod_cd(dRs.getString("rout_dest_nod_cd"));
				oDTO.setOrg_loc_cd(dRs.getString("org_loc_cd"));
				oDTO.setOrg_loc_nm(dRs.getString("org_loc_nm"));
				oDTO.setOrg_yd_cd(dRs.getString("org_yd_cd"));
				oDTO.setOrg_yd_nm(dRs.getString("org_yd_nm"));
				oDTO.setOrg_yd_addr(dRs.getString("org_yd_addr"));
				oDTO.setDest_loc_cd(dRs.getString("dest_loc_cd"));
				oDTO.setDest_loc_nm(dRs.getString("dest_loc_nm"));
				oDTO.setDest_yd_cd(dRs.getString("dest_yd_cd"));
				oDTO.setDest_yd_nm(dRs.getString("dest_yd_nm"));
				oDTO.setDest_yd_addr(dRs.getString("dest_yd_addr"));
			}
			
			result[0] = oDTO;
			result[1] = new Integer(1);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//		} finally {
//			trcLogger.masterEnd(TraceLogger.LIMIT_02);
		}
		return result;
	}	
	
    /**
     * 이벤트 처리<br>
     * Rail Billing Full Cntr Request 생성 화면에 대한 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] insertRailBillingReqCreateFull(Event et) throws DAOException {
        
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		DBRowSet dRsCntrList = null;
		DBRowSet dRsCopDupList = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> velParamCntrList = new HashMap<String, Object>();
		Map<String, Object> paramCntrList = new HashMap<String, Object>();
		Map<String, Object> paramCopDupList = new HashMap<String, Object>();

		String vndrOfcCd = "";
        String keyValue = "";
        
        Object[] result = new Object[2];
        
        try {
//        	trcLogger.masterBegin("insertRailBillingReqCreateFull");
            ExpPap0015Event event = (ExpPap0015Event)et;
            
            String bkgNo      				= event.getBkg_no();
            String bkgVrfyRstCd  			= event.getBkg_vrfy_rst_cd();
            VndrUserDetail vndrUserDtlInfo 	= event.getVndrUserDetailInfo();
            String shprFaxNo 				= event.getBookingSummary().getShipper_fax_no();
            BookingDetail[] bookingDetailList = event.getBookingDetailList();
            RailRampLocation railRampLocation = event.getRailRampLocation();
            
            if(bookingDetailList == null || bookingDetailList.length <= 0) {
    			throw new DAOException("Container Request Creation Info is incorrect.");
    		}
            
            if(   railRampLocation                       == null 
               || railRampLocation.getRout_org_nod_cd()  == null
               || railRampLocation.getRout_dest_nod_cd() == null
               || railRampLocation.getRout_seq() 		 == null
               || railRampLocation.getOrg_yd_cd() 	     == null
               || railRampLocation.getDest_yd_cd()       == null    ) {
            	
            	throw new DAOException("IRG Info is incorrect.");
            }
 
            if(vndrUserDtlInfo.getProv_vndr_seq() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_vndr_seq())) {
    			throw new DAOException("Invalid Vendor No.");
    		}
            if(vndrUserDtlInfo.getProv_usr_id() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_usr_id())) {
            	throw new DAOException("Invalid Vendor User ID.");
            }
            if(vndrUserDtlInfo.getProv_phn_no() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_phn_no())) {
            	throw new DAOException("Invalid Vendor Phone No.");
            }
            if(vndrUserDtlInfo.getProv_fax_no() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_fax_no())) {
            	throw new DAOException("Invalid Vendor Fax No.");
            }
            if(vndrUserDtlInfo.getProv_eml() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_eml())) {
            	throw new DAOException("Invalid Vendor e-Mail.");
            }
            if(vndrUserDtlInfo.getProv_cfm_mzd_cd() == null || Constants.EMPTY.equals(vndrUserDtlInfo.getProv_cfm_mzd_cd())) {
            	throw new DAOException("Invalid Vendor Confirm Method.");
            }
            
       		param.put("fm_full_nod_cd", 	railRampLocation.getOrg_yd_cd());
       		param.put("to_full_nod_cd", 	railRampLocation.getDest_yd_cd());
       		param.put("fm_nod_cd", 			railRampLocation.getOrg_yd_cd());
       		param.put("to_nod_cd", 			railRampLocation.getDest_yd_cd());
       		param.put("rout_org_nod_cd", 	railRampLocation.getRout_org_nod_cd());
       		param.put("rout_dest_nod_cd", 	railRampLocation.getRout_dest_nod_cd());
       		param.put("rout_seq", 			railRampLocation.getRout_seq());
       		param.put("bkg_no", 			bkgNo);

    		List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
			for(int i = 0; i < bookingDetailList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				log.debug("setVelParamField1   :  " +bookingDetailList[i].getCop_no());
				log.debug("setVelParamField2   :  " +bookingDetailList[i].getCost_act_grp_seq());
				paramVO.setVelParamField1(bookingDetailList[i].getCop_no()); 
				paramVO.setVelParamField2(bookingDetailList[i].getCost_act_grp_seq()); 
				velParamArr.add(paramVO); 				
			}
	       	
        	velParam.put("actGrpKey", velParamArr);

       		RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL rsql =  new RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL();
//            trcLogger.queryBegin("insertRailBillingReqCreateFull RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());

           HashMapEnumeration htCntrAssistList = new HashMapEnumeration();
            while(dRs != null && dRs.next()) {
            	RailBillFullCreateVO railCreateVO = new RailBillFullCreateVO();
            	
            	railCreateVO.setTrsp_so_ofc_cty_cd	(dRs.getString("trsp_so_ofc_cty_cd"));
            	railCreateVO.setTrsp_so_seq			(dRs.getString("trsp_so_seq"));
            	railCreateVO.setRail_cmb_thru_tp_cd	(dRs.getString("rail_cmb_thru_tp_cd"));
            	railCreateVO.setTrsp_so_sts_cd		(dRs.getString("trsp_so_sts_cd"));
            	railCreateVO.setTrsp_rail_bil_tp_cd	(dRs.getString("trsp_rail_bil_tp_cd"));
            	railCreateVO.setIbd_ipi_locl_ind_cd	(dRs.getString("ibd_ipi_locl_ind_cd"));
            	railCreateVO.setFm_full_nod_cd		(dRs.getString("fm_full_nod_cd"));
            	railCreateVO.setTo_full_nod_cd		(dRs.getString("to_full_nod_cd"));
            	railCreateVO.setFm_nod_cd			(dRs.getString("fm_nod_cd"));
            	railCreateVO.setTo_nod_cd			(dRs.getString("to_nod_cd"));
            	railCreateVO.setVsl_cd				(dRs.getString("vsl_cd"));
            	railCreateVO.setSkd_voy_no			(dRs.getString("skd_voy_no"));
            	railCreateVO.setSkd_dir_cd			(dRs.getString("skd_dir_cd"));
            	railCreateVO.setSlan_cd				(dRs.getString("slan_cd"));
            	railCreateVO.setTrsp_bnd_cd			(dRs.getString("trsp_bnd_cd"));
            	railCreateVO.setBkg_no				(dRs.getString("bkg_no"));
            	railCreateVO.setBl_no				(dRs.getString("bl_no"));
            	railCreateVO.setWgt_meas_ut_cd		(dRs.getString("wgt_meas_ut_cd"));
            	railCreateVO.setCgo_tp_cd			(dRs.getString("cgo_tp_cd"));
            	railCreateVO.setPck_tp_cd			(dRs.getString("pck_tp_cd"));
            	railCreateVO.setCmdt_cd				(dRs.getString("cmdt_cd"));
            	railCreateVO.setStnd_cmdt_no		(dRs.getString("stnd_cmdt_no"));
            	railCreateVO.setCop_no				(dRs.getString("cop_no"));
            	railCreateVO.setCost_act_grp_seq	(dRs.getString("cost_act_grp_seq"));
            	railCreateVO.setSpcl_cgo_cntr_tp_cd	(dRs.getString("spcl_cgo_cntr_tp_cd"));
            	railCreateVO.setIbd_cstms_clr_loc_cd(dRs.getString("ibd_cstms_clr_loc_cd"));
            	railCreateVO.setPod_cd				(dRs.getString("pod_cd"));
            	railCreateVO.setPor_cd				(dRs.getString("por_cd"));
            	railCreateVO.setPol_cd				(dRs.getString("pol_cd"));
            	railCreateVO.setDel_cd				(dRs.getString("del_cd"));
            	railCreateVO.setPor_nod_cd			(dRs.getString("por_nod_cd"));
            	railCreateVO.setDel_nod_cd			(dRs.getString("del_nod_cd"));
            	railCreateVO.setDel_scc_cd			(dRs.getString("del_scc_cd"));
            	railCreateVO.setNvocc_file_no		(dRs.getString("nvocc_file_no"));
            	railCreateVO.setCntr_seal_no		(dRs.getString("cntr_seal_no"));
            	railCreateVO.setAct_grp_cd			(dRs.getString("act_grp_cd"));
            	railCreateVO.setN1st_nod_pln_dt		(dRs.getString("n1st_nod_pln_dt"));
            	railCreateVO.setLst_nod_pln_dt		(dRs.getString("lst_nod_pln_dt"));
            	railCreateVO.setBkg_cgo_tp_cd		(dRs.getString("bkg_cgo_tp_cd"));
            	railCreateVO.setRout_org_nod_cd		(dRs.getString("rout_org_nod_cd"));
            	railCreateVO.setRout_dest_nod_cd	(dRs.getString("rout_dest_nod_cd"));
            	railCreateVO.setRout_seq			(dRs.getString("rout_seq"));
            	railCreateVO.setCtrl_ofc_cd			(dRs.getString("ctrl_ofc_cd"));
            	railCreateVO.setRout_pln_cd			(dRs.getString("rout_pln_cd"));
            	railCreateVO.setInlnd_rout_rmk		(dRs.getString("inlnd_rout_rmk"));
            	railCreateVO.setCre_ofc_cd			(dRs.getString("cre_ofc_cd"));
            	railCreateVO.setCre_usr_id			(dRs.getString("cre_usr_id"));
            	railCreateVO.setUpd_usr_id			(dRs.getString("upd_usr_id"));
            	railCreateVO.setShpr_cust_nm		(dRs.getString("shpr_cust_nm"));
            	railCreateVO.setCust_cnt_cd			(dRs.getString("cust_cnt_cd"));
            	railCreateVO.setCust_seq			(dRs.getString("cust_seq"));
            	railCreateVO.setMtc_edi_ind_cd		(dRs.getString("mtc_edi_ind_cd"));
            	railCreateVO.setBkg_rcvde_term_cd	(dRs.getString("bkg_rcvde_term_cd"));
            	railCreateVO.setPol_nod_cd			(dRs.getString("pol_nod_cd"));
            	railCreateVO.setPod_nod_cd			(dRs.getString("pod_nod_cd"));
            	railCreateVO.setSc_no				(dRs.getString("sc_no"));
            	
            	keyValue = railCreateVO.getCop_no().trim()+"-"+railCreateVO.getCost_act_grp_seq().trim();
    log.debug("keyValue  : " +keyValue);        	
            	htCntrAssistList.put(keyValue, railCreateVO);
            }
            
            if(htCntrAssistList == null || htCntrAssistList.size() != bookingDetailList.length) {
            	throw new DAOException("Container condition for Web rail billing request was changed after your verification.\\nPlease try [VERIFY] again before [SUBMIT DATA TO HJS].");
            }
            List<CommonVo> velParamArr2 	= new ArrayList<CommonVo>(); 
			for(int i = 0; i < bookingDetailList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(bookingDetailList[i].getCntr_no()); 
				velParamArr2.add(paramVO); 				
			}
            // Container Type Size 참조용 조회
    		// 2007-05-18 수정 : 요청자 : 정원근 수석 
    		//                 사    유 : D4/D5 적용처리
            velParamCntrList.put("cntrNoList", velParamArr2);
           
       		RailBillingReqCreateDBDAOsearchReqCreationTargetCntrListFullCntrRSQL rsqlCntrList = 
            	new RailBillingReqCreateDBDAOsearchReqCreationTargetCntrListFullCntrRSQL();
//            trcLogger.queryBegin("insertRailBillingReqCreateFull searchReqCreationTargetCntrListFullCntrRSQL Query");
            dRsCntrList = new SQLExecuter("DEFAULT").executeQuery(rsqlCntrList, paramCntrList, velParamCntrList);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsqlCntrList.getSQL());

            HashMapEnumeration htCntrTypeAssistList = new HashMapEnumeration();
            while(dRsCntrList != null && dRsCntrList.next()) {
            	ContainerTypeSize cntrTpSzVO = new ContainerTypeSize();
            	
            	cntrTpSzVO.setCntr_no(dRsCntrList.getString("cntr_no"));
            	cntrTpSzVO.setCntr_tpsz_cd(dRsCntrList.getString("cntr_tpsz_cd"));
            	
            	htCntrTypeAssistList.put(cntrTpSzVO.getCntr_no(), cntrTpSzVO);
            }
            
            if(htCntrTypeAssistList == null || htCntrTypeAssistList.size() != bookingDetailList.length) {
            	throw new DAOException("Can't refer subsidiary data during creating rail order.[Container Type/Size]");
            }      
            

            // EDI 전송을 위해서 처리
            Usa404EDISendVO ediSendVO = new Usa404EDISendVO();
            Collection arEdiSendList = new ArrayList();
            
//            int procCount = 0;
            int insResult = 0;
            int updResult = 0;
            for(int idx = 0; idx < bookingDetailList.length; idx++) {
            	// insertRailBillOrderPS 처리
            	BookingDetail cntrInfo = bookingDetailList[idx];
            	
        		// submit 직전 verify 한 것이 nowrs 이면 skip 하고 처리 한다.( 처리 방식 확인 해야함.)
        		if(Constants.VRFY_NOWRS.equals(cntrInfo.getVrfy_rst_cd())) {
        			continue;
        		}
            	
        		keyValue = cntrInfo.getCop_no().trim()+"-"+cntrInfo.getCost_act_grp_seq().trim();
             	RailBillFullCreateVO railCreateVO = (RailBillFullCreateVO)htCntrAssistList.get(keyValue);
        		if(railCreateVO == null) {
        			throw new DAOException("Container info is incorrect[COP].["+ cntrInfo.getCntr_no()+"]");
        		}
        		
        		// 수정내역 : D4/D5 적용처리 
        		// 수정일자 : 2007-05-18 
        		// 요 청  자 : 정원근 수석님 
        		// 사      유 : D4/D5 구분 없이 Create 되게 업무 변경
        		ContainerTypeSize cntrTpSzVO = (ContainerTypeSize)htCntrTypeAssistList.get(cntrInfo.getCntr_no());
        		if(cntrTpSzVO == null) {
        			throw new DAOException("Container info is incorrect[MST].["+ cntrInfo.getCntr_no()+"]");
        		}
        		
        		if(cntrInfo.getWeight() == null || Constants.EMPTY.equals(cntrInfo.getWeight())) {
        			throw new DAOException("Container Weight is incorrect.");
        		}
        		
        		if(cntrInfo.getPiece() == null || Constants.EMPTY.equals(cntrInfo.getPiece())) {
        			throw new DAOException("Container Piece is incorrect.");
        		}
        		
        		// 수정내역 : COP_NO,COST_ACT_GRP_SEQ 중복 체크 
        		// 수정일자 : 2007-05-29 
        		// 요 청  자 : 정원근 수석님 
        		// 사      유 : COP에서 RePlan 시에  SCE_COST_ACT_GRP의 Create된 데이터를 Plan 상태로 변경 하는 경우가 생김 
                paramCopDupList.put("cop_no", railCreateVO.getCop_no());
                paramCopDupList.put("cost_act_grp_seq", railCreateVO.getCost_act_grp_seq());

                RailBillingReqCreateDBDAOsearchCopDupCheckRSQL rsqlCopDupList = 
                	new RailBillingReqCreateDBDAOsearchCopDupCheckRSQL();
//                trcLogger.queryBegin("insertRailBillingReqCreateFull searchCopDupCheckRSQL Query");
                dRsCopDupList = new SQLExecuter("DEFAULT").executeQuery(rsqlCopDupList, paramCopDupList, velParam);
//                trcLogger.queryEnd(TraceLogger.LIMIT_02, rsqlCopDupList.getSQL());
       		
        		if(dRsCopDupList != null && dRsCopDupList.next()) {
        			// 중복 데이터가 존재 할 경우 전체 Roll Back 하면서 에러 처리
        			throw new DAOException("Submitted data is already processed by another user.");
        		}

        		Map<String, Object> paramInsertRailBillOrder = new HashMap<String, Object>();
        		if(railCreateVO != null) {
        			vndrOfcCd = railCreateVO.getCtrl_ofc_cd();
        		}
        		log.debug("vndrOfcCd  : "+vndrOfcCd);
        		paramInsertRailBillOrder.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
        		paramInsertRailBillOrder.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
        		paramInsertRailBillOrder.put("rail_cmb_thru_tp_cd", railCreateVO.getRail_cmb_thru_tp_cd());
        		paramInsertRailBillOrder.put("trsp_so_sts_cd", railCreateVO.getTrsp_so_sts_cd());
        		paramInsertRailBillOrder.put("trsp_rail_bil_tp_cd", railCreateVO.getTrsp_rail_bil_tp_cd());
        		paramInsertRailBillOrder.put("cost_act_grp_cd", railCreateVO.getAct_grp_cd());
        		paramInsertRailBillOrder.put("ibd_ipi_locl_ind_cd", railCreateVO.getIbd_ipi_locl_ind_cd());
        		paramInsertRailBillOrder.put("fm_nod_cd", railCreateVO.getFm_nod_cd());
        		paramInsertRailBillOrder.put("to_nod_cd", railCreateVO.getTo_nod_cd());
        		paramInsertRailBillOrder.put("vsl_cd", railCreateVO.getVsl_cd());
        		paramInsertRailBillOrder.put("skd_voy_no", railCreateVO.getSkd_voy_no());
        		paramInsertRailBillOrder.put("skd_dir_cd", railCreateVO.getSkd_dir_cd());
        		paramInsertRailBillOrder.put("slan_cd", railCreateVO.getSlan_cd());
        		paramInsertRailBillOrder.put("eq_no", cntrInfo.getCntr_no());
        		
        		// 2007-05-18 수정 : 요청자 : 정원근 수석님 
        		//                 사    유 : D4/D5 적용처리
        		paramInsertRailBillOrder.put("eq_tpsz_cd", cntrTpSzVO.getCntr_tpsz_cd());  
        		paramInsertRailBillOrder.put("trsp_bnd_cd", railCreateVO.getTrsp_bnd_cd());
        		paramInsertRailBillOrder.put("bkg_no", railCreateVO.getBkg_no());
        		paramInsertRailBillOrder.put("bl_no", railCreateVO.getBl_no());
        		paramInsertRailBillOrder.put("cntr_wgt", cntrInfo.getWeight()); 
        		paramInsertRailBillOrder.put("wgt_meas_ut_cd", railCreateVO.getWgt_meas_ut_cd());
        		paramInsertRailBillOrder.put("cgo_tp_cd", railCreateVO.getCgo_tp_cd());
        		paramInsertRailBillOrder.put("pck_tp_cd", railCreateVO.getPck_tp_cd());
        		paramInsertRailBillOrder.put("pck_qty", cntrInfo.getPiece()); 
        		paramInsertRailBillOrder.put("cmdt_cd", railCreateVO.getCmdt_cd());
        		paramInsertRailBillOrder.put("stnd_cmdt_no", railCreateVO.getStnd_cmdt_no());
        		paramInsertRailBillOrder.put("auto_xpt_sys_cd", cntrInfo.getAes_tp());
        		paramInsertRailBillOrder.put("auto_xpt_sys_no", cntrInfo.getAes_no());
        		paramInsertRailBillOrder.put("cop_no", railCreateVO.getCop_no());
        		paramInsertRailBillOrder.put("cost_act_grp_seq", railCreateVO.getCost_act_grp_seq());
        		paramInsertRailBillOrder.put("spcl_cgo_cntr_tp_cd", railCreateVO.getSpcl_cgo_cntr_tp_cd());
        		paramInsertRailBillOrder.put("ibd_cstms_clr_loc_cd", railCreateVO.getIbd_cstms_clr_loc_cd());
        		paramInsertRailBillOrder.put("pod_cd", railCreateVO.getPod_cd());
        		paramInsertRailBillOrder.put("por_cd", railCreateVO.getPor_cd());
        		paramInsertRailBillOrder.put("pol_cd", railCreateVO.getPol_cd());
        		paramInsertRailBillOrder.put("del_cd", railCreateVO.getDel_cd());
        		paramInsertRailBillOrder.put("por_nod_cd", railCreateVO.getPor_nod_cd());
        		paramInsertRailBillOrder.put("del_nod_cd", railCreateVO.getDel_nod_cd());
        		paramInsertRailBillOrder.put("del_scc_cd", railCreateVO.getDel_scc_cd());
        		paramInsertRailBillOrder.put("nvocc_file_no", railCreateVO.getNvocc_file_no());
        		paramInsertRailBillOrder.put("cntr_seal_no", railCreateVO.getCntr_seal_no());
        		paramInsertRailBillOrder.put("n1st_nod_pln_dt", railCreateVO.getN1st_nod_pln_dt());
        		paramInsertRailBillOrder.put("lst_nod_pln_dt", railCreateVO.getLst_nod_pln_dt());
        		paramInsertRailBillOrder.put("bkg_cgo_tp_cd", railCreateVO.getBkg_cgo_tp_cd());
        		log.debug("FULL CNTR cgo_tp_cd : "+railCreateVO.getCgo_tp_cd());
        		log.debug("FULL CNTR bkg_cgo_tp_cd : "+railCreateVO.getBkg_cgo_tp_cd());
        		log.debug("FULL CNTR rout_org_nod_cd : "+railCreateVO.getRout_org_nod_cd());
        		log.debug("FULL CNTR rout_dest_nod_cd : "+railCreateVO.getRout_dest_nod_cd());
        		paramInsertRailBillOrder.put("rout_org_nod_cd", railCreateVO.getRout_org_nod_cd());
        		paramInsertRailBillOrder.put("rout_dest_nod_cd", railCreateVO.getRout_dest_nod_cd());
        		paramInsertRailBillOrder.put("rout_seq", railCreateVO.getRout_seq());
        		paramInsertRailBillOrder.put("rout_pln_cd", railCreateVO.getRout_pln_cd());
        		paramInsertRailBillOrder.put("inlnd_rout_rmk", railCreateVO.getInlnd_rout_rmk());
        		paramInsertRailBillOrder.put("cre_ofc_cd", railCreateVO.getCre_ofc_cd());
        		paramInsertRailBillOrder.put("vndr_seq", vndrOfcCd);
        		paramInsertRailBillOrder.put("cre_usr_id", railCreateVO.getCre_usr_id());
        		paramInsertRailBillOrder.put("vndr_seq", vndrOfcCd);
        		paramInsertRailBillOrder.put("upd_usr_id", railCreateVO.getUpd_usr_id());
        		paramInsertRailBillOrder.put("inter_rmk", "");
        		paramInsertRailBillOrder.put("spcl_instr_rmk", "");
        		paramInsertRailBillOrder.put("cust_seq", railCreateVO.getCust_seq());
        		paramInsertRailBillOrder.put("blk_flg", cntrInfo.getBulk());
        		paramInsertRailBillOrder.put("stel_wire_flg", cntrInfo.getSteelwire());
        		paramInsertRailBillOrder.put("coi_shp_flg", cntrInfo.getCoil_shipment());
        		paramInsertRailBillOrder.put("fumg_flg", cntrInfo.getFumigation());
        		//paramInsertRailBillOrder.put("", cntrInfo.getVrfy_rsn_msg());
        		
        		if(Constants.VRFY_NOGOOD.equals(bkgVrfyRstCd) || Constants.VRFY_NOGOOD.equals(cntrInfo.getVrfy_rst_cd())) {
        			paramInsertRailBillOrder.put("spnd_flg", Constants.YES);
        		} else {
        			paramInsertRailBillOrder.put("spnd_flg", Constants.NO); // GOOD
        		}
        		
        		paramInsertRailBillOrder.put("spnd_err_msg_cd", cntrInfo.getVrfy_rsn_cd());
        		paramInsertRailBillOrder.put("spnd_lang_tp_cd", cntrInfo.getVrfy_lang_tp_cd());
        		
        		paramInsertRailBillOrder.put("shpr_cust_nm", railCreateVO.getShpr_cust_nm());
        		paramInsertRailBillOrder.put("shpr_fax_no", shprFaxNo);
        		paramInsertRailBillOrder.put("prov_vndr_seq", vndrUserDtlInfo.getProv_vndr_seq());
        		paramInsertRailBillOrder.put("prov_usr_id", vndrUserDtlInfo.getProv_usr_id());
        		paramInsertRailBillOrder.put("prov_phn_no", vndrUserDtlInfo.getProv_phn_no());
        		paramInsertRailBillOrder.put("prov_fax_no", vndrUserDtlInfo.getProv_fax_no());
        		paramInsertRailBillOrder.put("prov_eml", vndrUserDtlInfo.getProv_eml());
        		paramInsertRailBillOrder.put("prov_cfm_mzd_cd", vndrUserDtlInfo.getProv_cfm_mzd_cd());
        		paramInsertRailBillOrder.put("bkg_rcvde_term_cd", railCreateVO.getBkg_rcvde_term_cd());

        		// 2008-01-31 긴급요청 Booking No Revision 관련하여 TRS 로직변경으로 인한 추가
 
        		paramInsertRailBillOrder.put("org_cop_no", railCreateVO.getCop_no());
        		paramInsertRailBillOrder.put("org_cost_act_grp_seq", railCreateVO.getCost_act_grp_seq());
        		paramInsertRailBillOrder.put("org_bkg_no", railCreateVO.getBkg_no());
        		paramInsertRailBillOrder.put("pol_nod_cd", railCreateVO.getPol_nod_cd());
        		paramInsertRailBillOrder.put("pod_nod_cd", railCreateVO.getPod_nod_cd());
           		paramInsertRailBillOrder.put("sc_no", railCreateVO.getSc_no());

//        		trcLogger.queryBegin("insertRailBillingReqCreateFull InsertRailBillOrderFullCntrCSQL");
        		RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL insRailBillOrder =
        			new RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insRailBillOrder, paramInsertRailBillOrder,paramInsertRailBillOrder);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insRailBillOrder.getSQL());
				
    			if(insResult == 0){
    				throw new DAOException("Rail Billing Order Full Creation is Failed.[Code:10]");
    						
    			}
       		
            	// insertRailBillVndrSetPS 처리
           		Map<String, Object> paramInsRailBillVndrSet = new HashMap<String, Object>();

           		paramInsRailBillVndrSet.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
        		paramInsRailBillVndrSet.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
        		paramInsRailBillVndrSet.put("cre_ofc_cd", railCreateVO.getCre_ofc_cd());
        		paramInsRailBillVndrSet.put("cre_usr_id", railCreateVO.getCre_usr_id());
        		paramInsRailBillVndrSet.put("vndr_seq", vndrOfcCd);
        		paramInsRailBillVndrSet.put("upd_usr_id", railCreateVO.getUpd_usr_id());
        		paramInsRailBillVndrSet.put("fm_full_nod_cd", railCreateVO.getFm_full_nod_cd());
        		paramInsRailBillVndrSet.put("to_full_nod_cd", railCreateVO.getTo_full_nod_cd());
        		paramInsRailBillVndrSet.put("rout_org_nod_cd", railCreateVO.getRout_org_nod_cd());
        		paramInsRailBillVndrSet.put("rout_dest_nod_cd", railCreateVO.getRout_dest_nod_cd());
        		paramInsRailBillVndrSet.put("rout_seq", railCreateVO.getRout_seq());
        		
//        		trcLogger.queryBegin("insertRailBillingReqCreateFull insertRailBillVndrSetFullCntrCSQL");
        		RailBillingReqCreateDBDAOinsertRailBillVndrSetFullCntrCSQL insRailBillVndrSet =
        			new RailBillingReqCreateDBDAOinsertRailBillVndrSetFullCntrCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insRailBillVndrSet, paramInsRailBillVndrSet,paramInsRailBillVndrSet);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insRailBillVndrSet.getSQL());
				
    			if(insResult == 0){
               		throw new DAOException("Rail Billing Order Full Creation is Failed.[Code:20]");
               	     						
    			}
    			
//        		trcLogger.detailBegin("Call SCE COP Method ");
        	
            	// insertSceSoIfPS 처리 => SCE 요청으로 삭제(2010-02-10 이윤정,김인수SS)
    			ReplanManageBC copBC = new ReplanManageBCImpl();
        		TrsTrspRailBilOrdVO trsTrspRailBilOrdVO = new TrsTrspRailBilOrdVO();
        		trsTrspRailBilOrdVO.setTrspSoOfcCtyCd(railCreateVO.getTrsp_so_ofc_cty_cd());
        		trsTrspRailBilOrdVO.setTrspSoSeq(railCreateVO.getTrsp_so_seq());
        		trsTrspRailBilOrdVO.setTrspSoStsCd(railCreateVO.getTrsp_so_sts_cd());
        		trsTrspRailBilOrdVO.setCreUsrId(railCreateVO.getCre_usr_id());
        		trsTrspRailBilOrdVO.setUpdUsrId(railCreateVO.getUpd_usr_id());
        		trsTrspRailBilOrdVO.setVndrSeq(vndrOfcCd);
        		trsTrspRailBilOrdVO.setCopNo(railCreateVO.getCop_no());
        		trsTrspRailBilOrdVO.setCostActGrpSeq(railCreateVO.getCost_act_grp_seq());
        		trsTrspRailBilOrdVO.setActGrpCd(railCreateVO.getAct_grp_cd());
        		trsTrspRailBilOrdVO.setTrspBndCd(railCreateVO.getTrsp_bnd_cd());
        		trsTrspRailBilOrdVO.setBkgNo(railCreateVO.getBkg_no());
        		trsTrspRailBilOrdVO.setEqNo(cntrInfo.getCntr_no());
        		trsTrspRailBilOrdVO.setScNo(railCreateVO.getSc_no());
        		
        		updResult = copBC.modifySoList(trsTrspRailBilOrdVO);

        		if(updResult <= 0) {
            		throw new DAOException("Rail Billing Order Full Creation is Failed.[Code:40]");
            	}
       		
          		SceCopHdrVO copHdrVO = new SceCopHdrVO();
          		copHdrVO.setCopNo			(railCreateVO.getCop_no());
          		copHdrVO.setProvCntrNo		(cntrTpSzVO.getCntr_no());
          		copHdrVO.setProvCntrTpszCd	(cntrTpSzVO.getCntr_tpsz_cd());
          		copHdrVO.setUpdUsrId			(railCreateVO.getUpd_usr_id());
          		
          		updResult = copBC.modifyProvCntrByWRS(copHdrVO);
        		if(updResult <= 0) {
        			throw new DAOException("Rail Billing Order Full Creation is Failed.[Code:50]");
            	}
//        		trcLogger.detailEnd();
       		
        		// insertEdiRailTmpPS 처리
          		Map<String, Object> paramInsertEdiRailTmp = new HashMap<String, Object>();
          		paramInsertEdiRailTmp.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
          		paramInsertEdiRailTmp.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
          		paramInsertEdiRailTmp.put("cre_usr_id", railCreateVO.getCre_usr_id());
          		//paramInsertEdiRailTmp.put("vndr_seq", vndrOfcCd);
          		paramInsertEdiRailTmp.put("upd_usr_id", railCreateVO.getUpd_usr_id());

//        		trcLogger.queryBegin("insertRailBillingReqCreateFull insertEdiRailTmpFullCntrCSQL");
        		RailBillingReqCreateDBDAOinsertEdiRailTmpFullCntrCSQL insEdiRailTmpFull =
        			new RailBillingReqCreateDBDAOinsertEdiRailTmpFullCntrCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insEdiRailTmpFull, paramInsertEdiRailTmp,paramInsertEdiRailTmp);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insEdiRailTmpFull.getSQL());

        		if(insResult <= 0) {
        			throw new DAOException("Rail Billing Order Full Creation is Failed.[Code:60]");
            	}

        		// EDI 전송용 데이터  만들기
        		if( Constants.VRFY_GOOD.equals(bkgVrfyRstCd) && Constants.VRFY_GOOD.equals(cntrInfo.getVrfy_rst_cd()) ) {

        			String edi_vndr_seq = searchVndrSeq(railCreateVO.getTrsp_so_ofc_cty_cd(), railCreateVO.getTrsp_so_seq());
        			
        			TrsTrspEdiRailOrdVO ediSendInfo = new TrsTrspEdiRailOrdVO();
        			ediSendInfo.setIbflag("I");
        			ediSendInfo.setTrspSoOfcCtyCd(railCreateVO.getTrsp_so_ofc_cty_cd());
        			ediSendInfo.setTrspSoSeq(railCreateVO.getTrsp_so_seq());
        			ediSendInfo.setRailCmbThruTpCd(railCreateVO.getRail_cmb_thru_tp_cd());
        			ediSendInfo.setBkgNo(railCreateVO.getBkg_no());
        			ediSendInfo.setBlNo(railCreateVO.getBl_no());
        			ediSendInfo.setBkgCgoTpCd(railCreateVO.getBkg_cgo_tp_cd());
        			ediSendInfo.setVndrSeq(edi_vndr_seq);
        			ediSendInfo.setEqNo(cntrInfo.getCntr_no());
        			ediSendInfo.setEqTpszCd(cntrInfo.getCntr_tpsz_cd());
            		ediSendInfo.setFmNodCd(railCreateVO.getFm_nod_cd());
            		ediSendInfo.setToNodCd(railCreateVO.getTo_nod_cd());
//            		ediSendInfo.setInter_rmk();
//            		ediSendInfo.setSpcl_instr_rmk();
            		ediSendInfo.setMtcEdiIndCd(railCreateVO.getMtc_edi_ind_cd());
            		ediSendInfo.setCgoTpCd(railCreateVO.getCgo_tp_cd());
            		ediSendInfo.setCopNo(railCreateVO.getCop_no());
            		ediSendInfo.setCostActGrpSeq(railCreateVO.getCost_act_grp_seq());
          
	        		arEdiSendList.add(ediSendInfo);
        		}
        		
        		
            }
            
    		// insertTrsTrspRailConvAmt 처리
//            trcLogger.detailBegin("insertRailBillingReqCreateFull multiProcTRS_TRSP_RAIL_BILLING_VO");
            RailSoManageDBDAO piDBDao = new RailSoManageDBDAO();
            piDBDao.multiProcTrsTrspRailBillingVos(vndrOfcCd);
//            trcLogger.detailEnd();          
    		
            // 처리결과
            isSuccessful = true;
            
            // 처리 결과 값 세팅
			result[0] = Boolean.valueOf(isSuccessful);
			
			// EDI 전송용 데이터
			ediSendVO.setCntr_ofc_cd("CHIBB");
			ediSendVO.setUser_id("SPP_IF");
			ediSendVO.setEdi_send_list(arEdiSendList);
			result[1] = ediSendVO;
			
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//			trcLogger.masterEnd(TraceLogger.LIMIT_20);
        }
         
        return result;
    }
	
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] searchRailBillingReqCreateEmpty(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
       
        Object[] result = new Object[2];
        try {
            
            param.put("pctl_io_bnd_cd", 			"M");
       		
            RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL rsql =  
            	new RailBillingReqCreateDBDAOsearchRailBillingReqCreateEmptyRSQL();
//            trcLogger.queryBegin("searchRailBillingReqCreateEmpty searchRailBillingReqCreateEmptyRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());

            ArrayList args1 = new ArrayList();
            ArrayList args2 = new ArrayList();
            
            String prevLocCd = "";
            String prevLocNm = "";
            while(dRs != null && dRs.next()){
            	if(!prevLocCd.equals(dRs.getString("loc_cd"))) {
            		if(!Constants.EMPTY.equals(prevLocCd)) {
	            		LocationDetail locDTO = new LocationDetail();
	            		locDTO.setLoc_cd(prevLocCd);
	            		locDTO.setLoc_nm(prevLocNm);
	            		locDTO.setYardDetailList((YardDetail[])args2.toArray(new YardDetail[0]));
	            		
	            		args1.add(locDTO);
	            		args2.clear();
            		}
            	}
            	
                YardDetail ydDTO = new YardDetail();
                ydDTO.setYd_cd(dRs.getString("yd_cd"));
                ydDTO.setYd_nm(dRs.getString("yd_nm"));
                ydDTO.setYd_addr(dRs.getString("yd_addr"));
                ydDTO.setD2_flg(dRs.getString("d2_flg"));
                ydDTO.setD4_flg(dRs.getString("d4_flg"));
                ydDTO.setD5_flg(dRs.getString("d5_flg"));
                ydDTO.setD7_flg(dRs.getString("d7_flg"));
                ydDTO.setO2_flg(dRs.getString("o2_flg"));
                ydDTO.setO4_flg(dRs.getString("o4_flg"));
                ydDTO.setA2_flg(dRs.getString("a2_flg"));
                ydDTO.setA4_flg(dRs.getString("a4_flg"));
//                ydDTO.setA5_flg(dRs.getString("a5_flg"));
                ydDTO.setR5_flg(dRs.getString("r5_flg"));
                ydDTO.setR2_flg(dRs.getString("r2_flg"));
//                ydDTO.setO5_flg(dRs.getString("o5_flg"));
                
                args2.add(ydDTO);            	
                
        		prevLocCd = dRs.getString("loc_cd");
                prevLocNm = dRs.getString("loc_nm");
            }
            
            if(args2.size() > 0) {
        		LocationDetail locDTO = new LocationDetail();
        		locDTO.setLoc_cd(prevLocCd);
        		locDTO.setLoc_nm(prevLocNm);
        		locDTO.setYardDetailList((YardDetail[])args2.toArray(new YardDetail[0]));
        		
        		args1.add(locDTO);
        		args2.clear();
            }

            // 조회결과
            if (args1.size() == 0) {
            	result[0] = null;
            }
            else {
            	result[0] = (LocationDetail[])args1.toArray(new LocationDetail[0]);
            }
            result[1] = new Integer(args1.size());
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return result;
    }
	
    /**
     * 이벤트 처리<br>
     * Rail Billing Empty Cntr Request 생성 화면에 대한 이벤트 처리<br>
     * 
     * @param et Event
     * @return 
     * @exception DAOException
     */
	public Object[] insertRailBillingReqCreateEmpty(Event et) throws DAOException {
        
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> paramInsRailBillOdr = new HashMap<String, Object>();
		Map<String, Object> paramInsRailBillVndrSet = new HashMap<String, Object>();
		Map<String, Object> paramUpdEqrRepoExeSoIf = new HashMap<String, Object>();
		Map<String, Object> paramInsEdiRailTmp = new HashMap<String, Object>();
		
		boolean isSuccessful = false; 
        
        String vndrOfcCd = "";
        
        Object[] result = new Object[2];
        
        try {
//        	trcLogger.masterBegin("MT insertRailBillingReqCreateEmpty");
        	
            ExpPap0018Event event = (ExpPap0018Event)et;
            
            VndrUserDetail vndrUserDtlInfo = event.getVndrUserDetailInfo();
            EmptyContainer[] cntrList = event.getEmptyContainerList();
            //String cntr_no = "";
            
            if(cntrList == null || cntrList.length <= 0) {
    			throw new DAOException("Empty Container Request Creation Info is incorrect.");
    		}
            
            HashMapEnumeration htCntrList = new HashMapEnumeration();
            for(int i = 0; i < cntrList.length; i++) {
            	htCntrList.put(cntrList[i].getCntr_no(), cntrList[i]);
            }
    		param.put("trsp_so_ofc_cty_cd", 			"WRS");
                  		
    		List<CommonVo> velParamRout 	= new ArrayList<CommonVo>(); 
    		List<CommonVo> velParamRepo 	= new ArrayList<CommonVo>(); 
			for(int i = 0; i < cntrList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				CommonVo param2VO 			= new CommonVo();
				paramVO.setVelParamField1(cntrList[i].getRoute_org_nod_cd()); 
				paramVO.setVelParamField2(cntrList[i].getRoute_dest_nod_cd()); 
				paramVO.setVelParamField3(cntrList[i].getRoute_seq()); 

				param2VO.setVelParamField1(cntrList[i].getRepo_pln_id()); 
				param2VO.setVelParamField2(cntrList[i].getPln_yrwk()); 
				param2VO.setVelParamField3(cntrList[i].getRef_id()); 
				param2VO.setVelParamField4(cntrList[i].getRef_seq()); 

				velParamRout.add(paramVO); 				
				velParamRepo.add(param2VO); 				
			}
	       	
        	velParam.put("routList", velParamRout);
        	velParam.put("RepoPlnList", velParamRepo);
        	
        	RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL rsql =  
            	new RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL();
//            trcLogger.queryBegin("insertRailBillingReqCreateEmpty SearchReqCreationTargetEmptyCntrRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
           
            HashMapEnumeration htCntrAssistList = new HashMapEnumeration();
            while(dRs != null && dRs.next()) {
            	RailBillEmptyCreateVO railCreateVO = new RailBillEmptyCreateVO();
            	log.debug("dRs.getString(key_value)           :	"+dRs.getString("key_value")                     	+"\n");
            	log.debug("dRs.getString(trsp_so_ofc_cty_cd)  :	"+dRs.getString("trsp_so_ofc_cty_cd")                   +"\n");
            	log.debug("dRs.getString(trsp_so_seq)         :	"+dRs.getString("trsp_so_seq")                          +"\n");
            	log.debug("dRs.getString(rail_cmb_thru_tp_cd) :	"+dRs.getString("rail_cmb_thru_tp_cd")                  +"\n");
            	log.debug("dRs.getString(trsp_so_sts_cd)      :	"+dRs.getString("trsp_so_sts_cd")                       +"\n");
            	log.debug("dRs.getString(trsp_rail_bil_tp_cd) :	"+dRs.getString("trsp_rail_bil_tp_cd")                  +"\n");
            	log.debug("dRs.getString(fm_nod_cd)           :	"+dRs.getString("fm_nod_cd")                            +"\n");
            	log.debug("dRs.getString(to_nod_cd)           :	"+dRs.getString("to_nod_cd")                            +"\n");
            	log.debug("dRs.getString(vsl_cd)              :	"+dRs.getString("vsl_cd")                               +"\n");
            	log.debug("dRs.getString(skd_voy_no)          :	"+dRs.getString("skd_voy_no")                           +"\n");
            	log.debug("dRs.getString(skd_dir_cd)          :	"+dRs.getString("skd_dir_cd")                           +"\n");
            	log.debug("dRs.getString(slan_cd)             :	"+dRs.getString("slan_cd")                              +"\n");
            	log.debug("dRs.getString(eq_no)               :	"+dRs.getString("eq_no")                                +"\n");
            	log.debug("dRs.getString(eq_tpsz_cd)          :	"+dRs.getString("eq_tpsz_cd")                           +"\n");
            	log.debug("dRs.getString(cgo_tp_cd)           :	"+dRs.getString("cgo_tp_cd")                            +"\n");
            	log.debug("dRs.getString(rout_org_nod_cd)     :	"+dRs.getString("rout_org_nod_cd")                      +"\n");
            	log.debug("dRs.getString(rout_dest_nod_cd)    :	"+dRs.getString("rout_dest_nod_cd")                     +"\n");
            	log.debug("dRs.getString(rout_seq)            :	"+dRs.getString("rout_seq")                             +"\n");
            	log.debug("dRs.getString(rout_pln_cd)         :	"+dRs.getString("rout_pln_cd")                          +"\n");
            	log.debug("dRs.getString(inlnd_rout_rmk)      :	"+dRs.getString("inlnd_rout_rmk")                       +"\n");
            	log.debug("dRs.getString(cre_ofc_cd)          :	"+dRs.getString("cre_ofc_cd")                           +"\n");
            	log.debug("dRs.getString(cre_usr_id)          :	"+dRs.getString("cre_usr_id")                           +"\n");
            	log.debug("dRs.getString(upd_usr_id)          :	"+dRs.getString("upd_usr_id")                           +"\n");
            	log.debug("dRs.getString(inter_rmk)           :	"+dRs.getString("inter_rmk")                            +"\n");
            	log.debug("dRs.getString(spcl_instr_rmk)      :	"+dRs.getString("spcl_instr_rmk")                       +"\n");
            	log.debug("dRs.getString(trsp_mty_cost_mod_cd):	"+dRs.getString("trsp_mty_cost_mod_cd")                 +"\n");
            	log.debug("dRs.getString(repo_pln_id)         :	"+dRs.getString("repo_pln_id")                          +"\n");
            	log.debug("dRs.getString(pln_yrwk)            :	"+dRs.getString("pln_yrwk")                             +"\n");
            	log.debug("dRs.getString(ref_seq)             :	"+dRs.getString("ref_seq")                              +"\n");
            	log.debug("dRs.getString(ref_id)              :	"+dRs.getString("ref_id")                               +"\n");
            	log.debug("dRs.getString(trsp_mty_rqst_dt)    :	"+dRs.getString("trsp_mty_rqst_dt")                     +"\n");
            	log.debug("dRs.getString(eq_ctrl_ofc_cd)      :	"+dRs.getString("eq_ctrl_ofc_cd")                       +"\n");
            	log.debug("dRs.getString(mtc_edi_ind_cd)      :	"+dRs.getString("mtc_edi_ind_cd")                       +"\n");
            	
            	railCreateVO.setKey_value(dRs.getString("key_value"));
            	railCreateVO.setTrsp_so_ofc_cty_cd(dRs.getString("trsp_so_ofc_cty_cd"));
            	railCreateVO.setTrsp_so_seq(dRs.getString("trsp_so_seq"));
            	railCreateVO.setRail_cmb_thru_tp_cd(dRs.getString("rail_cmb_thru_tp_cd"));
            	railCreateVO.setTrsp_so_sts_cd(dRs.getString("trsp_so_sts_cd"));
            	railCreateVO.setTrsp_rail_bil_tp_cd(dRs.getString("trsp_rail_bil_tp_cd"));
            	railCreateVO.setFm_nod_cd(dRs.getString("fm_nod_cd"));
            	railCreateVO.setTo_nod_cd(dRs.getString("to_nod_cd"));
            	railCreateVO.setVsl_cd(dRs.getString("vsl_cd"));
            	railCreateVO.setSkd_voy_no(dRs.getString("skd_voy_no"));
            	railCreateVO.setSkd_dir_cd(dRs.getString("skd_dir_cd"));
            	railCreateVO.setSlan_cd(dRs.getString("slan_cd"));
            	railCreateVO.setEq_no(dRs.getString("eq_no"));
            	railCreateVO.setEq_tpsz_cd(dRs.getString("eq_tpsz_cd"));
            	railCreateVO.setCgo_tp_cd(dRs.getString("cgo_tp_cd"));
            	railCreateVO.setRout_org_nod_cd(dRs.getString("rout_org_nod_cd"));
            	railCreateVO.setRout_dest_nod_cd(dRs.getString("rout_dest_nod_cd"));
            	railCreateVO.setRout_seq(dRs.getString("rout_seq"));
            	railCreateVO.setRout_pln_cd(dRs.getString("rout_pln_cd"));
            	railCreateVO.setInlnd_rout_rmk(dRs.getString("inlnd_rout_rmk"));
            	railCreateVO.setCre_ofc_cd(dRs.getString("cre_ofc_cd"));
            	railCreateVO.setCre_usr_id(dRs.getString("cre_usr_id"));
            	railCreateVO.setUpd_usr_id(dRs.getString("upd_usr_id"));
            	railCreateVO.setInter_rmk(dRs.getString("inter_rmk"));
            	railCreateVO.setSpcl_instr_rmk(dRs.getString("spcl_instr_rmk"));
            	railCreateVO.setTrsp_mty_cost_mod_cd(dRs.getString("trsp_mty_cost_mod_cd"));
            	railCreateVO.setRepo_pln_id(dRs.getString("repo_pln_id"));
            	railCreateVO.setPln_yrwk(dRs.getString("pln_yrwk"));
            	railCreateVO.setRef_seq(dRs.getString("ref_seq"));
            	railCreateVO.setRef_id(dRs.getString("ref_id"));
            	railCreateVO.setTrsp_mty_rqst_dt(dRs.getString("trsp_mty_rqst_dt"));
            	railCreateVO.setEq_ctrl_ofc_cd(dRs.getString("eq_ctrl_ofc_cd"));
            	railCreateVO.setMtc_edi_ind_cd(dRs.getString("mtc_edi_ind_cd"));

            	htCntrAssistList.put(railCreateVO.getKey_value(), railCreateVO);
            }
            
            if(htCntrAssistList == null || htCntrAssistList.size() != cntrList.length) {
            	throw new DAOException("Container condition for Web rail billing request was changed after your verification.\\nPlease try [VERIFY] again before [SUBMIT DATA TO NYK].");
            }
            
            
            // EDI 전송을 위해서 처리
            Usa404EDISendVO ediSendVO = new Usa404EDISendVO();
            Collection arEdiSendList = new ArrayList();
            
            //String    htKeyValue = "";
            StringBuffer htKeyValue = new StringBuffer(512);
            String    htKeyValue1 = "";
            String    htKeyValue2 = "";
            
            int insResult = 0;
            log.debug(" cntrList.length : "+cntrList.length);
            for(int idx = 0; idx < cntrList.length; idx++) {
            	// insertRailBillOrderPS 처리
            	EmptyContainer cntrInfo = cntrList[idx];
            	
        		// submit 직전 verify 한 것이 nowrs 이면 skip 하고 처리 한다.( 처리 방식 확인 해야함.)
        		if(Constants.VRFY_NOWRS.equals(cntrInfo.getVrfy_rst_cd())) {
        			continue;
        		}
        		cntrInfo.setVrfy_rsn_msg("RAIL BILLING HAS ALREADY BEEN MADE");
        		cntrInfo.setSubmitFlag(Constants.YES);
        		
            	//htKeyValue = cntrInfo.getRepo_pln_id().trim()+"-"+cntrInfo.getPln_yrwk().trim()+"-"+cntrInfo.getRef_id().trim()+"-"+cntrInfo.getRef_seq().trim();
            	//htKeyValue = htKeyValue+"="+cntrInfo.getRoute_org_nod_cd().trim()+"-"+cntrInfo.getRoute_dest_nod_cd().trim()+"-"+cntrInfo.getRoute_seq().trim();
        		htKeyValue1 = cntrInfo.getRepo_pln_id().trim()+"-"+cntrInfo.getPln_yrwk().trim()+"-"+cntrInfo.getRef_id().trim()+"-"+cntrInfo.getRef_seq().trim();
            	htKeyValue2 = "="+cntrInfo.getRoute_org_nod_cd().trim()+"-"+cntrInfo.getRoute_dest_nod_cd().trim()+"-"+cntrInfo.getRoute_seq().trim();
            	htKeyValue.append(htKeyValue1);
            	htKeyValue.append(htKeyValue2);
        		
        		log.debug("htKeyValue : "+htKeyValue);           	
            	RailBillEmptyCreateVO railCreateVO = (RailBillEmptyCreateVO)htCntrAssistList.get(htKeyValue.toString());
            	htKeyValue.setLength(0);
        		if(railCreateVO == null) {
        			throw new DAOException("Container info is incorrect.["+ cntrInfo.getCntr_no()+"]");
        		}
        		
        		vndrOfcCd = railCreateVO.getEq_ctrl_ofc_cd();
        		
//        		int i1 = 1;
        		
        		paramInsRailBillOdr.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
        		paramInsRailBillOdr.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
        		paramInsRailBillOdr.put("rail_cmb_thru_tp_cd", railCreateVO.getRail_cmb_thru_tp_cd());
        		paramInsRailBillOdr.put("trsp_so_sts_cd", railCreateVO.getTrsp_so_sts_cd());
        		paramInsRailBillOdr.put("trsp_rail_bil_tp_cd", railCreateVO.getTrsp_rail_bil_tp_cd());
        		paramInsRailBillOdr.put("fm_nod_cd", railCreateVO.getFm_nod_cd());
        		paramInsRailBillOdr.put("to_nod_cd", railCreateVO.getTo_nod_cd());
        		paramInsRailBillOdr.put("vsl_cd", railCreateVO.getVsl_cd());
        		paramInsRailBillOdr.put("skd_voy_no", railCreateVO.getSkd_voy_no());
        		paramInsRailBillOdr.put("skd_dir_cd", railCreateVO.getSkd_dir_cd());
        		paramInsRailBillOdr.put("slan_cd", railCreateVO.getSlan_cd());
        		
        		// 조회결과 eq_no가 없는 경우는 사용자가 입력한 eq_no를 입력한다.
        		if(railCreateVO.getEq_no() == null || Constants.EMPTY.equals(railCreateVO.getEq_no().trim())) {
        			paramInsRailBillOdr.put("eq_no", cntrInfo.getCntr_no());
        		} else {
        			paramInsRailBillOdr.put("eq_no", railCreateVO.getEq_no());
        		}
        		
        		paramInsRailBillOdr.put("eq_tpsz_cd", railCreateVO.getEq_tpsz_cd());
        		paramInsRailBillOdr.put("cgo_tp_cd", railCreateVO.getCgo_tp_cd());
        		paramInsRailBillOdr.put("rout_org_nod_cd", railCreateVO.getRout_org_nod_cd());
        		paramInsRailBillOdr.put("rout_dest_nod_cd", railCreateVO.getRout_dest_nod_cd());
        		paramInsRailBillOdr.put("rout_seq", railCreateVO.getRout_seq());
        		paramInsRailBillOdr.put("rout_pln_cd", railCreateVO.getRout_pln_cd());
        		paramInsRailBillOdr.put("inlnd_rout_rmk", railCreateVO.getInlnd_rout_rmk());
        		paramInsRailBillOdr.put("cre_ofc_cd", railCreateVO.getCre_ofc_cd());
        		paramInsRailBillOdr.put("vndr_seq", vndrOfcCd);
        		paramInsRailBillOdr.put("cre_usr_id", railCreateVO.getCre_usr_id());
        		paramInsRailBillOdr.put("upd_usr_id", railCreateVO.getUpd_usr_id());
        		paramInsRailBillOdr.put("inter_rmk", railCreateVO.getInter_rmk());
        		paramInsRailBillOdr.put("spcl_instr_rmk", railCreateVO.getSpcl_instr_rmk());
        		paramInsRailBillOdr.put("trsp_mty_cost_mod_cd", railCreateVO.getTrsp_mty_cost_mod_cd());
        		paramInsRailBillOdr.put("repo_pln_id", railCreateVO.getRepo_pln_id());
        		paramInsRailBillOdr.put("pln_yrwk", railCreateVO.getPln_yrwk());
        		paramInsRailBillOdr.put("ref_seq", railCreateVO.getRef_seq());
        		paramInsRailBillOdr.put("ref_id", railCreateVO.getRef_id());
        		paramInsRailBillOdr.put("trsp_mty_rqst_dt", railCreateVO.getTrsp_mty_rqst_dt());
        		//paramInsRailBillOdr.put("", cntrInfo.getVrfy_rsn_msg());
        		
        		if(Constants.VRFY_NOGOOD.equals(cntrInfo.getVrfy_rst_cd())) {
        			paramInsRailBillOdr.put("spnd_flg", Constants.YES);
        		} else {
        			paramInsRailBillOdr.put("spnd_flg", Constants.NO); // GOOD
        		}
        		
        		paramInsRailBillOdr.put("spnd_err_msg_cd", cntrInfo.getVrfy_rsn_cd());
        		paramInsRailBillOdr.put("spnd_lang_tp_cd", cntrInfo.getVrfy_lang_tp_cd());
        		
        		paramInsRailBillOdr.put("shpr_cust_nm", railCreateVO.getShpr_cust_nm());
        		paramInsRailBillOdr.put("shpr_fax_no", railCreateVO.getShpr_fax_no());
        		paramInsRailBillOdr.put("prov_vndr_seq", vndrUserDtlInfo.getProv_vndr_seq());
        		paramInsRailBillOdr.put("prov_usr_id", vndrUserDtlInfo.getProv_usr_id());
        		paramInsRailBillOdr.put("prov_phn_no", vndrUserDtlInfo.getProv_phn_no());
        		paramInsRailBillOdr.put("prov_fax_no", vndrUserDtlInfo.getProv_fax_no());
        		paramInsRailBillOdr.put("prov_eml", vndrUserDtlInfo.getProv_eml());
        		paramInsRailBillOdr.put("prov_cfm_mzd_cd", vndrUserDtlInfo.getProv_cfm_mzd_cd());
        		
        		log.debug("trsp_so_ofc_cty_cd=====> "+railCreateVO.getTrsp_so_ofc_cty_cd()+"\n");
        		log.debug("trsp_so_seq=====> "+railCreateVO.getTrsp_so_seq()+"\n");
        		log.debug("rail_cmb_thru_tp_cd=====> "+railCreateVO.getRail_cmb_thru_tp_cd()+"\n");
        		log.debug("trsp_so_sts_cd=====> "+railCreateVO.getTrsp_so_sts_cd()+"\n");
        		log.debug("trsp_rail_bil_tp_cd=====> "+railCreateVO.getTrsp_rail_bil_tp_cd()+"\n");
        		log.debug("fm_nod_cd=====> "+railCreateVO.getFm_nod_cd()+"\n");
        		log.debug("to_nod_cd=====> "+railCreateVO.getTo_nod_cd()+"\n");
        		log.debug("vsl_cd=====> "+railCreateVO.getVsl_cd()+"\n");
        		log.debug("skd_voy_no=====> "+railCreateVO.getSkd_voy_no()+"\n");
        		log.debug("skd_dir_cd=====> "+railCreateVO.getSkd_dir_cd()+"\n");
        		log.debug("slan_cd=====> "+railCreateVO.getSlan_cd()+"\n");
        		log.debug("eq_no=====> "+cntrInfo.getCntr_no()+"\n");
        		log.debug("eq_no=====> "+railCreateVO.getEq_no()+"\n");
        		log.debug("eq_tpsz_cd=====> "+railCreateVO.getEq_tpsz_cd()+"\n");
        		log.debug("cgo_tp_cd=====> "+railCreateVO.getCgo_tp_cd()+"\n");
        		log.debug("rout_org_nod_cd=====> "+railCreateVO.getRout_org_nod_cd()+"\n");
        		log.debug("rout_dest_nod_cd=====> "+railCreateVO.getRout_dest_nod_cd()+"\n");
        		log.debug("rout_seq=====> "+railCreateVO.getRout_seq()+"\n");
        		log.debug("rout_pln_cd=====> "+railCreateVO.getRout_pln_cd()+"\n");
        		log.debug("inlnd_rout_rmk=====> "+railCreateVO.getInlnd_rout_rmk()+"\n");
        		log.debug("cre_ofc_cd=====> "+railCreateVO.getCre_ofc_cd()+"\n");
        		log.debug("vndr_seq=====> "+vndrOfcCd+"\n");
        		log.debug("cre_usr_id=====> "+railCreateVO.getCre_usr_id()+"\n");
        		log.debug("upd_usr_id=====> "+railCreateVO.getUpd_usr_id()+"\n");
        		log.debug("inter_rmk=====> "+railCreateVO.getInter_rmk()+"\n");
        		log.debug("spcl_instr_rmk=====> "+railCreateVO.getSpcl_instr_rmk()+"\n");
        		log.debug("trsp_mty_cost_mod_cd=====> "+railCreateVO.getTrsp_mty_cost_mod_cd()+"\n");
        		log.debug("repo_pln_id=====> "+railCreateVO.getRepo_pln_id()+"\n");
        		log.debug("pln_yrwk=====> "+railCreateVO.getPln_yrwk()+"\n");
        		log.debug("ref_seq=====> "+railCreateVO.getRef_seq()+"\n");
        		log.debug("ref_id=====> "+railCreateVO.getRef_id()+"\n");
        		log.debug("trsp_mty_rqst_dt=====> "+railCreateVO.getTrsp_mty_rqst_dt()+"\n");
        		log.debug("spnd_err_msg_cd=====> "+cntrInfo.getVrfy_rsn_cd()+"\n");
        		log.debug("spnd_lang_tp_cd=====> "+cntrInfo.getVrfy_lang_tp_cd()+"\n");
        		log.debug("shpr_cust_nm=====> "+railCreateVO.getShpr_cust_nm()+"\n");
        		log.debug("shpr_fax_no=====> "+railCreateVO.getShpr_fax_no()+"\n");
        		log.debug("prov_vndr_seq=====> "+vndrUserDtlInfo.getProv_vndr_seq()+"\n");
        		log.debug("prov_usr_id=====> "+vndrUserDtlInfo.getProv_usr_id()+"\n");
        		log.debug("prov_phn_no=====> "+vndrUserDtlInfo.getProv_phn_no()+"\n");
        		log.debug("prov_fax_no=====> "+vndrUserDtlInfo.getProv_fax_no()+"\n");
        		log.debug("prov_eml=====> "+vndrUserDtlInfo.getProv_eml()+"\n");
        		log.debug("prov_cfm_mzd_cd=====> "+vndrUserDtlInfo.getProv_cfm_mzd_cd()+"\n");

//        		trcLogger.queryBegin("insertRailBillingReqCreateFull insertRailBillVndrSetFullCntrCSQL");
        		RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL insRailBillOdr =
        			new RailBillingReqCreateDBDAOInsertRailBillOrderEmptyCntrCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insRailBillOdr, paramInsRailBillOdr,paramInsRailBillOdr);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insRailBillOdr.getSQL());
        		if(insResult <= 0) {
            		throw new DAOException("Rail Billing Order Empty Creation is Failed.[Code:10]");
            	}
        		
            	// insertRailBillVndrSetPS 처리
        		paramInsRailBillVndrSet.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
        		paramInsRailBillVndrSet.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
        		paramInsRailBillVndrSet.put("cre_ofc_cd", railCreateVO.getCre_ofc_cd());
        		paramInsRailBillVndrSet.put("cre_usr_id", railCreateVO.getCre_usr_id());
        		paramInsRailBillVndrSet.put("vndr_seq", vndrOfcCd);
        		paramInsRailBillVndrSet.put("upd_usr_id", railCreateVO.getUpd_usr_id());
        		paramInsRailBillVndrSet.put("fm_nod_cd", railCreateVO.getFm_nod_cd());
        		paramInsRailBillVndrSet.put("to_nod_cd", railCreateVO.getTo_nod_cd());
        		paramInsRailBillVndrSet.put("rout_org_nod_cd", railCreateVO.getRout_org_nod_cd());
        		paramInsRailBillVndrSet.put("rout_dest_nod_cd", railCreateVO.getRout_dest_nod_cd());
        		paramInsRailBillVndrSet.put("rout_seq", railCreateVO.getRout_seq());
        		
//        		trcLogger.queryBegin("insertRailBillingReqCreateFull insertRailBillVndrSetEmptyCntrCSQL");
        		RailBillingReqCreateDBDAOInsertRailBillVndrSetEmptyCntrCSQL insRailBillVndrSet =
        			new RailBillingReqCreateDBDAOInsertRailBillVndrSetEmptyCntrCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insRailBillVndrSet, paramInsRailBillVndrSet,paramInsRailBillVndrSet);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insRailBillVndrSet.getSQL());
        		// tranCount >= 1 일수 있다..
        		if(insResult <= 0) {
        			throw new DAOException("Rail Billing Order Empty Creation is Failed.[Code:20]");
            	}
            	
            	// updateEqrRepoExeSoIf 처리
//        		int i3 = 1;
        		paramUpdEqrRepoExeSoIf.put("repo_pln_id", railCreateVO.getRepo_pln_id());
        		paramUpdEqrRepoExeSoIf.put("pln_yrwk", railCreateVO.getPln_yrwk());
        		paramUpdEqrRepoExeSoIf.put("ref_id", railCreateVO.getRef_id());
        		paramUpdEqrRepoExeSoIf.put("ref_seq", railCreateVO.getRef_seq());
        		
//        		trcLogger.queryBegin("insertRailBillingReqCreateFull updateRailBillVndrSetEmptyCntrCSQL");
        		RailBillingReqCreateDBDAOUpdateEqrRepoExeSoIfEmptyUSQL updEqrRepoExeSoIf =
        			new RailBillingReqCreateDBDAOUpdateEqrRepoExeSoIfEmptyUSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(updEqrRepoExeSoIf, paramUpdEqrRepoExeSoIf,paramUpdEqrRepoExeSoIf);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, updEqrRepoExeSoIf.getSQL());
        		
        		if(insResult <= 0) {
            		throw new DAOException("Rail Billing Order Empty Creation is Failed.[Code:30]");
            	}
        		
        		// insertEdiRailTmpPS 처리
//        		int i4 = 1;
        		paramInsEdiRailTmp.put("trsp_so_ofc_cty_cd", railCreateVO.getTrsp_so_ofc_cty_cd());
        		paramInsEdiRailTmp.put("trsp_so_seq", railCreateVO.getTrsp_so_seq());
        		paramInsEdiRailTmp.put("cre_usr_id", railCreateVO.getCre_usr_id());
        		//paramInsEdiRailTmp.put("vndr_seq", vndrOfcCd);
        		paramInsEdiRailTmp.put("upd_usr_id", railCreateVO.getUpd_usr_id());
        		
//        		trcLogger.queryBegin("insertRailBillingReqCreateFull InsertEdiRailTmpEmptyCSQL");
        		RailBillingReqCreateDBDAOInsertEdiRailTmpEmptyCSQL insEdiRailTmp =
        			new RailBillingReqCreateDBDAOInsertEdiRailTmpEmptyCSQL();
    			insResult = new SQLExecuter("DEFAULT").executeUpdate(insEdiRailTmp, paramInsEdiRailTmp,paramInsEdiRailTmp);			
//        		trcLogger.queryEnd(TraceLogger.LIMIT_02, insEdiRailTmp.getSQL());
          		
        		if(insResult <= 0) {
        			throw new DAOException("Rail Billing Order Empty Creation is Failed.[Code:40]");
        		}
        		
        		// EDI 전송용 데이터  만들기
        		if(Constants.VRFY_GOOD.equals(cntrInfo.getVrfy_rst_cd())) {
        			
        			String edi_vndr_seq = searchVndrSeq(railCreateVO.getTrsp_so_ofc_cty_cd(), railCreateVO.getTrsp_so_seq()); 
        			
        			TrsTrspEdiRailOrdVO ediSendInfo = new TrsTrspEdiRailOrdVO();
        			ediSendInfo.setIbflag("I");
        			ediSendInfo.setTrspSoOfcCtyCd(railCreateVO.getTrsp_so_ofc_cty_cd());
        			ediSendInfo.setTrspSoSeq(railCreateVO.getTrsp_so_seq());
        			ediSendInfo.setRailCmbThruTpCd(railCreateVO.getRail_cmb_thru_tp_cd());
        			ediSendInfo.setVndrSeq(edi_vndr_seq);
        			
            		// 조회결과 eq_no가 없는 경우는 사용자가 입력한 eq_no를 입력한다.
            		if(railCreateVO.getEq_no() == null || Constants.EMPTY.equals(railCreateVO.getEq_no().trim())) {
            			ediSendInfo.setEqNo(cntrInfo.getCntr_no());
            		} else {
            			ediSendInfo.setEqNo(railCreateVO.getEq_no());
            		}
            		
            		ediSendInfo.setEqTpszCd(railCreateVO.getEq_tpsz_cd());
            		ediSendInfo.setFmNodCd(railCreateVO.getFm_nod_cd());
            		ediSendInfo.setToNodCd(railCreateVO.getTo_nod_cd());
            		ediSendInfo.setMtcEdiRcvRsltDt(railCreateVO.getMtc_edi_ind_cd());
            		ediSendInfo.setCgoTpCd(railCreateVO.getCgo_tp_cd());
            		ediSendInfo.setRepoPlnId(railCreateVO.getRepo_pln_id());
            		ediSendInfo.setPlnYrwk(railCreateVO.getPln_yrwk());
            		ediSendInfo.setRefId(railCreateVO.getRef_id());
            		ediSendInfo.setRefSeq(railCreateVO.getRef_seq());
            		
	        		arEdiSendList.add(ediSendInfo);
        		}
            }
            
    		// insertTrsTrspRailConvAmt 처리
//            trcLogger.detailBegin("MT multiProcTRS_TRSP_RAIL_BILLING_VO");
            RailSoManageDBDAO piDBDao = new RailSoManageDBDAO();
            // 정원근 수석님의 요청으로 "PHXSA" 을 세팅 함 : 2007-05-07 18:56
            // NYK사 버전인 CHIBB로 수정 : 2016-11-17            
            piDBDao.multiProcTrsTrspRailBillingVos("CHIBB");
//            trcLogger.detailEnd();
    		
            // 처리결과
            isSuccessful = true;
            
            // 처리 결과 값 세팅
			result[0] = Boolean.valueOf(isSuccessful);
			
			// EDI 전송용 데이터
			// NYK사 버전인 CHIBB로 수정 : 2016-11-17
			ediSendVO.setCntr_ofc_cd("CHIBB");
			ediSendVO.setUser_id("SPP_IF");
			ediSendVO.setEdi_send_list(arEdiSendList);
			result[1] = ediSendVO;
			
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
//        } finally {
//            trcLogger.masterEnd(TraceLogger.LIMIT_20);
           
        }
        
        return result;
    }
	
	
	/**
	 * searchComErrMsg
	 * @param errCode
	 * @param langTpCd
	 * @return
	 * @throws DAOException
	 */
	public String searchComErrMsg(String errCode, String langTpCd) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();	
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRs = null;

		String errMsg = "";
        
        try {
    		
     		// 쿼리에 변수 세팅
            if(langTpCd == null || Constants.EMPTY.equals(langTpCd)) {
            	langTpCd = "ENG";
            }
            param.put("err_msg_cd", errCode);
            param.put("lang_tp_cd", langTpCd);
            
            dbRs = new SQLExecuter("DEFAULT").executeQuery(new RailBillingReqCreateDBDAOsearchComErrMsgRSQL(), param, velParam);
                        
            if(dbRs != null && dbRs.next()) {
            	errMsg = dbRs.getString("err_msg");
            }
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return errMsg;
    }
	
	/**
	 * searchComErrMsgList
	 * 
	 * @return Object[]
	 * @throws DAOException
	 */
	public Object[] searchComErrMsgList() throws DAOException {
        Object[] result = new Object[2];
        
        Map<String, Object> param = new HashMap<String, Object>();	
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRs = null;

        try {
    		
            dbRs = new SQLExecuter("DEFAULT").executeQuery(new RailBillingReqCreateDBDAOsearchComErrMsgListRSQL(), param, velParam);
          
            HashMapEnumeration args1 = new HashMapEnumeration();
            String keyValue = "";
            
            while(dbRs != null && dbRs.next()){
            	RailBillErrorVO errInfo = new RailBillErrorVO();
            	
            	errInfo.setErr_msg_cd(dbRs.getString("err_msg_cd"));
            	errInfo.setLang_tp_cd(dbRs.getString("lang_tp_cd"));
            	errInfo.setErr_tp_cd(dbRs.getString("err_tp_cd"));
            	errInfo.setErr_msg(dbRs.getString("err_msg"));
            	
				keyValue = errInfo.getErr_msg_cd()+errInfo.getLang_tp_cd();
				args1.put(keyValue, errInfo);
            }

            // 조회결과
            if (args1.size() == 0) {
            	result[0] = null;
            }
            else {
            	result[0] = args1;
            }
            result[1] = new Integer(args1.size());
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
        return result;
    }
	
	/**
	 * Vendor Office Code
	 * @param vndrSeq
	 * @return
	 * @throws DAOException
	 */
	public String searchVndrOfcCd(String vndrSeq) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();	
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRs = null;
        String ofcCd = "";
        try {
    		
             param.put("vndr_seq",  vndrSeq);
            
            dbRs = new SQLExecuter("DEFAULT").executeQuery(new RailBillingReqCreateDBDAOsearchVndrOfcCdRSQL(), param, velParam);
            
            if(dbRs != null && dbRs.next()) {
            	ofcCd = dbRs.getString("ofc_cd");
            }
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return ofcCd;
    }
	
	
	/**
	 * searchBkgSplitMsg
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String searchBkgSplitMsg(String bkgNo) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();	
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRs = null;

		String result = "";
        String splitNo = "";
        int splitCnt = 0;
        String splitBkgs = "";
        try {
    		
            
    		// 쿼리에 변수 세팅
//            int i = 1;
            param.put("bkg_no", bkgNo);
            
            dbRs = new SQLExecuter("DEFAULT").executeQuery(new RailBillingReqCreateDBDAOsearchBkgSplitMsgRSQL(), param, velParam);
            
            splitCnt = 0;
            splitNo = "";
            while(dbRs != null && dbRs.next()) {
            	if(!"  ".equals(dbRs.getString("bkg_no"))) {
	        		splitCnt++;
	        		if(splitCnt > 1) {
	        			splitBkgs = splitBkgs + ", "; 
	        		}
	        		splitBkgs = splitBkgs + dbRs.getString("bkg_no");
            	}
            }
            
            if(splitCnt > 0) {
            	result = "This booking ("+bkgNo+ ") is splited to "+splitBkgs+".\\n\\n Please contact with Hanjin local booking office.";
            	//'This booking (ATL76269003) is splited to ATL76269003A1, B1. Please contact with Hanjin local booking office.
            } else {
            	result = "";
            }
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return result;
    }	
	
	/**
	 * searchVndrSeq 메소드
	 * 
	 * @param trsp_so_ofc_cty_cd
	 * @param trsp_so_seq
	 * @return String
	 * @throws DAOException
	 */
	public String searchVndrSeq(String trsp_so_ofc_cty_cd, String trsp_so_seq ) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
		String vndr_seq = "";
        
        try {
    		
            param.put("trsp_so_ofc_cty_cd", trsp_so_ofc_cty_cd);
            param.put("trsp_so_seq", trsp_so_seq);

            RailBillingReqCreateDBDAOsearchVndrSeqRSQL rsql = 
            	new RailBillingReqCreateDBDAOsearchVndrSeqRSQL();
//            trcLogger.queryBegin("insertRailBillingReqCreateFull searchVndrSeqRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, param);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());

            if(dRs != null && dRs.next()) {
            	vndr_seq = dRs.getString("vndr_seq");
            } 
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return vndr_seq;
    }
	
	/**
	 * searchCntrTpSz
	 * @param emptyContainerList
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchCntrTpSz(EmptyContainer[] emptyContainerList ) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dRs = null;
        Object[] result = new Object[2];
        
        try {
    		
        	List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
			for(int i = 0; i < emptyContainerList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(emptyContainerList[i].getCntr_no()); 
				velParamArr.add(paramVO); 				
			}
            velParam.put("cntrNoList", velParamArr);
            
            // 쿼리에 변수 세팅
        	RailBillingReqCreateDBDAOsearchCntrTpSzRSQL rsql = 
            	new RailBillingReqCreateDBDAOsearchCntrTpSzRSQL();
//            trcLogger.queryBegin("searchCntrTpSzRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
            ArrayList args = new ArrayList();
            
            while(dRs != null && dRs.next()){
            	EmptyContainer cntrInfo = new EmptyContainer();
            	
            	cntrInfo.setCntr_no(dRs.getString("cntr_no"));
            	cntrInfo.setCntr_tpsz_cd(dRs.getString("cntr_tpsz_cd"));
            	cntrInfo.setCntr_tpsz_nm(dRs.getString("cntr_tpsz_rmk"));
            	
            	args.add(cntrInfo);
            }
            // 조회결과
            if (args.size() == 0) {
            	result[0] = null;
            }
            else {
            	result[0] = (EmptyContainer[])args.toArray(new EmptyContainer[0]);
            }
            result[1] = new Integer(args.size());
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return result;
    }
	
	/**
	 * searchEmptyCntrTpSz
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchEmptyCntrTpSz() throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
        Object[] result = new Object[2];
        
        try {
    		
            
    		// 쿼리에 변수 세팅
            param.put("d2", "D2");
            param.put("d4", "D4");
            param.put("d5", "D5");
            param.put("d7", "D7");
            param.put("o2", "O2");
            param.put("o4", "O4");
            param.put("a2", "A2");
            param.put("a4", "A4");
            param.put("a5", "A5");
            param.put("r5", "R5");
            param.put("r2", "R2");
            param.put("o5", "O5");
            
            RailBillingReqCreateDBDAOsearchEmptyCntrTpSzRSQL rsql = 
            	new RailBillingReqCreateDBDAOsearchEmptyCntrTpSzRSQL();
//            trcLogger.queryBegin("searchEmptyCntrTpSzRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, param);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
            ArrayList args = new ArrayList();
            
            while(dRs != null && dRs.next()){
            	ContainerTypeSize cntrInfo = new ContainerTypeSize();
            	
            	cntrInfo.setCntr_tpsz_cd(dRs.getString("cntr_tpsz_cd"));
            	cntrInfo.setCntr_tpsz_nm(dRs.getString("cntr_tpsz_rmk"));
            	
            	args.add(cntrInfo);
            }
            // 조회결과
            if (args.size() == 0) {
            	result[0] = null;
            }
            else {
            	result[0] = (ContainerTypeSize[])args.toArray(new ContainerTypeSize[0]);
            }
            result[1] = new Integer(args.size());
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        }
        return result;
    }	
	
	/**
	 * searchUserEmptyFmNodCd
	 * @param provUserId
	 * @return
	 * @throws DAOException
	 */
	public String searchUserEmptyFmNodCd(String provUserId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
        String fmNodCd = "";
        
        try {
    		
            
    		// 쿼리에 변수 세팅
            param.put("prov_usr_id", provUserId);
            
            RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL rsql = 
            	new RailBillingReqCreateDBDAOsearchUserEmptyFmNodCdRSQL();
//            trcLogger.queryBegin("MT searchUserEmptyFmNodCd Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, param);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
 
            if(dRs != null && dRs.next()) {
            	fmNodCd = dRs.getString("fm_nod_cd");
            }
            
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        } 
        return fmNodCd;
    }
	
	/**
	 * wrsFullBkgVerifyResultLog
	 * @param rqEvent
	 * @param rsEvent
	 * @throws DAOException
	 */
	public void wrsFullBkgVerifyResultLog(ExpPap0010Event rqEvent, ExpPap0010EventResponse rsEvent) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
        StringBuffer infoSB = null;
        
        try {
//        	trcLogger.masterBegin("wrsFullBkgVerifyResultLog");
        	
        	infoSB = new StringBuffer();
        	infoSB.append("\n\n########## wrsFullBkgVerifyResultLog START ##########");
        	infoSB.append("\n-> BKG_NO=["+ rqEvent.getBkg_no() +"]");
        	infoSB.append("\n-> USER_ID=["+ rqEvent.getUser_id() +"]");
        	infoSB.append("\n-> VNDR_SEQ=["+ rqEvent.getVender_cd() +"]");
        	infoSB.append("\n-> BKG_VRFY_RESULT_CD=["+ rsEvent.getBkgVrfyRstCd() +"]");
        	infoSB.append("\n-> BKG_VRFY_ERR_CD=["+ rsEvent.getBkgVrfyErrCd() +"]");
        	infoSB.append("\n-> BKG_VRFY_ERR_MSG=["+ rsEvent.getBkgVrfyErrMsg() +"]");
        	infoSB.append("\n");
        	if(rsEvent.getRailRampLocationInfo() != null){
	        	infoSB.append("\n-> ROUT_ORG_NOD_CD=["+rsEvent.getRailRampLocationInfo().getRout_org_nod_cd()+"]");
	        	infoSB.append("\n-> ROUT_DEST_NOD_CD=["+rsEvent.getRailRampLocationInfo().getRout_dest_nod_cd()+"]");
	        	infoSB.append("\n-> ROUT_SEQ=["+rsEvent.getRailRampLocationInfo().getRout_seq()+"]");
	        	infoSB.append("\n-> RAIL_ORG_NOD_CD=["+rsEvent.getRailRampLocationInfo().getOrg_yd_cd()+"]");
	        	infoSB.append("\n-> RAIL_DEST_NOD_CD=["+rsEvent.getRailRampLocationInfo().getDest_yd_cd()+"]");        	
	        	infoSB.append("\n");
	        	
	    		// 쿼리에 변수 세팅
	            param.put("rout_org_nod_cd", rsEvent.getRailRampLocationInfo().getRout_org_nod_cd());
	            param.put("rout_dest_nod_cd", rsEvent.getRailRampLocationInfo().getRout_dest_nod_cd());
	            
	        	RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL rsql = 
	            	new RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL();
//	            trcLogger.queryBegin("wrsFullBkgVerifyResultLog Query");
	            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, param);
//	            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
	            infoSB.append("\n-- PRD_INLND_ROUT_MST START --");
	            while(dRs != null && dRs.next()) {
	            	infoSB.append("\n");
	            	infoSB.append("rout_org_nod_cd=["+dRs.getString("rout_org_nod_cd")+"], ");
	            	infoSB.append("rout_dest_nod_cd=["+dRs.getString("rout_dest_nod_cd")+"], ");
	            	infoSB.append("rout_seq=["+dRs.getString("rout_seq")+"], ");
	            	infoSB.append("wrs_full_cmdt_cd=["+dRs.getString("wrs_full_cmdt_cd")+"], ");
	            	infoSB.append("pctl_io_bnd_cd=["+dRs.getString("pctl_io_bnd_cd")+"], ");
	            	infoSB.append("delt_flg=["+dRs.getString("delt_flg")+"]");
	            }
	            infoSB.append("\n-- PRD_INLND_ROUT_MST   END --");
        	}   	
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
        	throw new DAOException(se.getMessage(), se);
            //throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	throw new DAOException(e.getMessage(), e);
            //throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        } finally {
            infoSB.append("\n########## wrsFullBkgVerifyResultLog   END ##########\n");
            log.error(infoSB.toString());
            infoSB.setLength(0);
            
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);
        }
    }		
	
	/**
	 * wrsFullBkgIRGVerifyResultLog
	 * 
	 * @param bkgNo String
	 * @param railRamp RailRampLocation
	 * @throws DAOException
	 */
	public void wrsFullBkgIRGVerifyResultLog(String bkgNo, RailRampLocation railRamp) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
         StringBuffer infoSB = null;
        
        try {
//        	trcLogger.masterBegin("wrsFullBkgIRGVerifyResultLog");
        	infoSB = new StringBuffer();
        	infoSB.append("\n\n########## wrsFullBkgIRGVerifyResultLog START ##########");
        	infoSB.append("\n-> BKG_NO=["+ bkgNo +"]");
        	infoSB.append("\n-> ROUT_ORG_NOD_CD=["+railRamp.getRout_org_nod_cd()+"]");
        	infoSB.append("\n-> ROUT_DEST_NOD_CD=["+railRamp.getRout_dest_nod_cd()+"]");
        	infoSB.append("\n-> ROUT_SEQ=["+railRamp.getRout_seq()+"]");        	
        	infoSB.append("\n-> RAIL_ORG_NOD_CD=["+railRamp.getOrg_yd_cd()+"]");
        	infoSB.append("\n-> RAIL_DEST_NOD_CD=["+railRamp.getDest_yd_cd()+"]");        	
        	infoSB.append("\n");
        	
            param.put("rout_org_nod_cd", railRamp.getRout_org_nod_cd());
            param.put("rout_dest_nod_cd", railRamp.getRout_dest_nod_cd());
            
        	RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL rsql = 
            	new RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL();
//            trcLogger.queryBegin("wrsFullBkgIRGVerifyResultLogRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, param);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
            infoSB.append("\n-- PRD_INLND_ROUT_MST START --");
            while(dRs != null && dRs.next()) {
            	infoSB.append("\n");
            	infoSB.append("rout_org_nod_cd=["+dRs.getString("rout_org_nod_cd")+"], ");
            	infoSB.append("rout_dest_nod_cd=["+dRs.getString("rout_dest_nod_cd")+"], ");
            	infoSB.append("rout_seq=["+dRs.getString("rout_seq")+"], ");
            	infoSB.append("wrs_full_cmdt_cd=["+dRs.getString("wrs_full_cmdt_cd")+"], ");
            	infoSB.append("pctl_io_bnd_cd=["+dRs.getString("pctl_io_bnd_cd")+"], ");
            	infoSB.append("delt_flg=["+dRs.getString("delt_flg")+"]");
            }
            infoSB.append("\n-- PRD_INLND_ROUT_MST   END --");

        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
        	throw new DAOException(se.getMessage(), se);
            //throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	throw new DAOException(e.getMessage(), e);
            //throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        } finally {
            infoSB.append("\n########## wrsFullBkgIRGVerifyResultLog   END ##########\n");
            log.error(infoSB.toString());
            infoSB.setLength(0);
            
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);           
        }
    }	
	
	/**
	 * wrsFullCntrVerifyResultLog
	 * @param bkgNo
	 * @param procFlag
	 * @param bookingDetailList
	 * @throws DAOException
	 */
	public void wrsFullCntrVerifyResultLog(String bkgNo, String procFlag, BookingDetail[] bookingDetailList) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
		DBRowSet dRs = null;
		StringBuffer infoSB = null;
		
        try {
//        	trcLogger.masterBegin("wrsFullCntrVerifyResultLog");
        	infoSB = new StringBuffer();
        	infoSB.append("\n\n########## wrsFullCntrVerifyResultLog START ##########");
        	infoSB.append("\n-> PROC_FLAG=["+ procFlag +"]");
        	infoSB.append("\n-> BKG_NO=["+ bkgNo +"]");
        	infoSB.append("\n");
        	for(int i=0; i < bookingDetailList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(bookingDetailList[i].getCop_no()); 
				paramVO.setVelParamField2(bookingDetailList[i].getCost_act_grp_seq()); 
				velParamArr.add(paramVO); 				

        		infoSB.append("\n");
        		infoSB.append("-> IDX=["+ i +"], ");
        		infoSB.append("CNTR_NO=["+ bookingDetailList[i].getCntr_no() +"], ");
        		infoSB.append("COP_NO=["+ bookingDetailList[i].getCop_no() +"], "); 
        		infoSB.append("COST_ACT_GRP_SEQ=["+ bookingDetailList[i].getCost_act_grp_seq() +"]");        		
        		infoSB.append("PCTL_NO=["+ bookingDetailList[i].getPctl_no() +"]");        		
        	}
        	
        	velParam.put("actGrpKey", velParamArr);
        	
            RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL rsql = 
            	new RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL();
//            trcLogger.queryBegin("wrsFullCntrVerifyResultLogRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_02, rsql.getSQL());
            
            infoSB.append("\n-- PRD_PROD_CTL_ACT_GRP_DTL START --");
            while(dRs != null && dRs.next()) {
            	infoSB.append("\n");
            	infoSB.append("cop_no=["+dRs.getString("cop_no")+"], ");
            	infoSB.append("cost_act_grp_seq=["+dRs.getString("cost_act_grp_seq")+"], ");
            	infoSB.append("pctl_no=["+dRs.getString("pctl_no")+"], ");
            	infoSB.append("n1st_nod_cd=["+dRs.getString("n1st_nod_cd")+"], ");
            	infoSB.append("n2nd_nod_cd=["+dRs.getString("n2nd_nod_cd")+"], ");
            	infoSB.append("n3rd_nod_cd=["+dRs.getString("n3rd_nod_cd")+"], ");
            	infoSB.append("n4th_nod_cd=["+dRs.getString("n4th_nod_cd")+"], ");
            	infoSB.append("rout_org_nod_cd=["+dRs.getString("rout_org_nod_cd")+"], ");
            	infoSB.append("rout_dest_nod_cd=["+dRs.getString("rout_dest_nod_cd")+"], ");
            	infoSB.append("rout_seq=["+dRs.getString("rout_seq")+"], ");
            }
            infoSB.append("\n-- PRD_PROD_CTL_ACT_GRP_DTL   END --");        	
            
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
        	throw new DAOException(e.getMessage(), e);
//            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        } finally {
        	infoSB.append("\n########## wrsFullCntrVerifyResultLog   END ##########\n");
        	log.error(infoSB.toString());
        	infoSB.setLength(0);
        	
//            trcLogger.masterEnd(TraceLogger.LIMIT_02);         
        }
    }	

     public String setRoutInfoReplaceArray(EmptyContainer[] condValues) {
    	StringBuffer sb = new StringBuffer();
    	int addCnt = 0;
    	for(int i = 0; i < condValues.length; i++) {
    		if(!Constants.VRFY_NOWRS.equals(condValues[i].getVrfy_rst_cd())) {
	    		if(addCnt > 0) {
	    			sb.append(",");
	    		}
	    		addCnt++;    			
	    		sb.append("('").append(condValues[i].getRoute_org_nod_cd()).append("',");
	    		sb.append("'").append(condValues[i].getRoute_dest_nod_cd()).append("',");
	    		sb.append("'").append(condValues[i].getRoute_seq());
	    		sb.append("')");
    		}
    	}
    	
    	if(Constants.EMPTY.equals(sb.toString())) {
    		sb.append("('0', '0', '0')");
    	}
    	//setConditionReplaceString(sql, condName, sb.toString());
    	return sb.toString();
    }
    
    /**
     * SQL 문장에서 Container No를 해당 값으로 Replace 한다.(배열)<br>
     * @param sql
     * @param condName
     * @param condValues
     */
    public String setCntrNoReplaceArray(EmptyContainer[] condValues) {
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < condValues.length; i++) {
			sb.append("'").append(condValues[i].getCntr_no()).append("'");
			if(i != (condValues.length-1)) {
				sb.append(",");
			}
    	}
    	
    	if(Constants.EMPTY.equals(sb.toString())) {
    		sb.append("'0'");
    	}
    	//setConditionReplaceString(sql, condName, sb.toString());
    	return sb.toString();
    }    

    
}