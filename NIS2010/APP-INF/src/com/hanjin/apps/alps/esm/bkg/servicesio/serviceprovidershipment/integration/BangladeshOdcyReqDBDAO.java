/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BangladeshOdcyReqDAO.java
*@FileTitle : WebGate Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-06
*@LastModifier : tae-kyoung.kim
*@LastVersion : 1.0
* 2012-04-06 tae-kyoung.kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.ShpRqst;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002Event;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0002EventResponse;
import com.hanjin.apps.alps.esm.bkg.servicesio.serviceprovidershipment.event.SppBkg0003Event;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * SPP-BKG 에 대한 DB 처리를 담당<br>
 * - SPP-BKG Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author taekyoung.kim
 * @see BangladeshOdcyReqBCImpl 참조
 * @since J2EE 1.4
 */

public class BangladeshOdcyReqDBDAO extends DBDAOSupport {
	
	/**
     * 조회 이벤트 처리<br>
     * verifyShipmentReq 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param ShpRqst shpRqst
     * @return String
     * @exception DAOException
     */
	public String verifyBkgNo(ShpRqst shpRqst) throws DAOException{
		DBRowSet rs = null;
        String vrfyRslt ="";
        
        log.debug("BangladeshOdcyReqDAO  verifyShipmentReq ");

        try{
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("bkg_no", shpRqst.getBkgNo());

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			BangladeshOdcyReqDBDAOVerifyBkgNoRSQL template = new BangladeshOdcyReqDBDAOVerifyBkgNoRSQL();	        
		    rs = sqlExe.executeQuery(template,param,null);
            
            if(rs != null && rs.next()) {
            	vrfyRslt = rs.getString("bkg_no");
            }
           
            log.debug("BangladeshOdcyReqDAO verifyShipmentReq result length " + vrfyRslt);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            //log.error("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }finally{
        	log.info("verifyBkgNo");
        }
        return vrfyRslt;
	}
	
	/**
     * 조회 이벤트 처리<br>
     * verifyShipmentReq 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param ShpRqst shpRqst
     * @return String
     * @exception DAOException
     */
	public String verifyCntrNo(ShpRqst shpRqst) throws DAOException{
		DBRowSet rs = null;
        String vrfyRslt ="";
        
        log.debug("BangladeshOdcyReqDAO  verifyShipmentReq ");

        try{
        	Map<String, Object> param = new HashMap<String, Object>();
        	param.put("cntr_no", shpRqst.getCntrNo());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			BangladeshOdcyReqDBDAOVerifyCntrNoRSQL template = new BangladeshOdcyReqDBDAOVerifyCntrNoRSQL();	        
		    rs = sqlExe.executeQuery(template,param,null);
            
            if(rs != null && rs.next()) {
            	vrfyRslt = rs.getString("cntr_no");
            }
           
            log.debug("BangladeshOdcyReqDAO verifyShipmentReq result length " + vrfyRslt);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            //log.error("\n SQL : \n" + ((LoggableStatement)ps).getQueryString());
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }finally{
        	log.info("verifyCntrNo");
        }
        return vrfyRslt;
	}	
	
	/**
	 * Shipping Request 항목을 입력한다.<br>
	 * 
	 * @param et SppBkg0002Event
	 * @return EventResponse SppBkg0002EventResponse
	 * @throws DAOException
	 */
	public EventResponse manageShippingRequest(Event et) throws DAOException {
		
		SppBkg0002Event event = (SppBkg0002Event) et;
		SppBkg0002EventResponse eventResponse = new SppBkg0002EventResponse();

		int insertcount = 0;
		int updatecount = 0;
		int deletecount = 0;
		ShpRqst[] shp = event.getShpRqst();
		
		try {			
			for(int i=0; i < shp.length; i++){				
				if(shp[i].getSaveDvsn().equals("I")){
					insertcount = insertShippingRequest(shp[i]);		
				}else if(shp[i].getSaveDvsn().equals("U")){
					updatecount = updateShippingRequest(shp[i]);
				}else if(shp[i].getSaveDvsn().equals("D")){
					deletecount = deleteShippingRequest(shp[i]);
				}
				
				if( insertcount < 0 || updatecount < 0 || deletecount < 0){
					eventResponse.setSuccessFlag("FAIL");
				}else{
					eventResponse.setSuccessFlag("SUCCESS");
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return eventResponse;
	}

	private int insertShippingRequest(ShpRqst shpRqst){
		int iRet = -1;

		try{
			Map<String, Object> param = new HashMap<String, Object>();
			
    		param.put("cntr_tpsz_cd", shpRqst.getCntrTpszCd());
    		param.put("cntr_seal_no", shpRqst.getCntrSealNo());
    		param.put("pck_qty", shpRqst.getPckQty());
    		param.put("pck_tp_cd", shpRqst.getPckTpCd());
    		param.put("cntr_wgt", shpRqst.getCntrWgt());
    		param.put("wgt_ut_cd", shpRqst.getWgtUtCd());
    		param.put("meas_qty", shpRqst.getMeasQty());
    		param.put("meas_ut_cd", shpRqst.getMeasUtCd());
    		param.put("cntr_vol_qty", shpRqst.getCntrVolQty());
    		param.put("vndr_seq", shpRqst.getVndrSeq());    		
    		param.put("bkg_no", shpRqst.getBkgNo());
    		param.put("cntr_no", shpRqst.getCntrNo());	
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BangladeshOdcyReqDBDAOAddShippingRequestCSQL template = new BangladeshOdcyReqDBDAOAddShippingRequestCSQL();
    		
    		iRet = sqlExe.executeUpdate(template,param,null);

		} catch (SQLException se) {
			log.error(" insertShippingRequest: " + se.getMessage());
			iRet = -1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			iRet = -1;
		} finally {
			log.info("insertShippingRequest");
		}
		return iRet;
	}
	
	private int updateShippingRequest(ShpRqst shpRqst){
		int iRet = -1;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
    		
    		param.put("cntr_tpsz_cd", shpRqst.getCntrTpszCd());
    		param.put("cntr_seal_no", shpRqst.getCntrSealNo());
    		param.put("pck_qty", shpRqst.getPckQty());
    		param.put("pck_tp_cd", shpRqst.getPckTpCd());
    		param.put("cntr_wgt", shpRqst.getCntrWgt());
    		param.put("wgt_ut_cd", shpRqst.getWgtUtCd());
    		param.put("meas_qty", shpRqst.getMeasQty());
    		param.put("meas_ut_cd", shpRqst.getMeasUtCd());
    		param.put("cntr_vol_qty", shpRqst.getCntrVolQty());
    		param.put("vndr_seq", shpRqst.getVndrSeq());    		
    		param.put("bkg_no", shpRqst.getBkgNo());
    		param.put("cntr_no", shpRqst.getCntrNo());
    		param.put("cntr_seq", shpRqst.getCntrSeq());  		
    		
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BangladeshOdcyReqDBDAOModifyShippingRequestUSQL template = new BangladeshOdcyReqDBDAOModifyShippingRequestUSQL();
    		
    		iRet = sqlExe.executeUpdate(template,param,null);

		} catch (SQLException se) {
			log.error("updateShippingRequest: " + se.getMessage());
			iRet = -1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			iRet = -1;
		} finally {
			log.info("updateShippingRequest");
		}
		return iRet;
	}
	
	private int deleteShippingRequest(ShpRqst shpRqst){
		int iRet = -1;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("bkg_no", shpRqst.getBkgNo());
    		param.put("cntr_no", shpRqst.getCntrNo());
    		param.put("cntr_seq", shpRqst.getCntrSeq());  		
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			BangladeshOdcyReqDBDAOModifyShippingRequestDSQL template = new BangladeshOdcyReqDBDAOModifyShippingRequestDSQL();
    		
    		iRet = sqlExe.executeUpdate(template,param,null);

		} catch (SQLException se) {
			log.error("deleteShippingRequest: " + se.getMessage());
			iRet = -1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			iRet = -1;
		} finally {
			log.info("deleteShippingRequest");
		}
		return iRet;
	}
		
	/**
	 * <br>
	 * 
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchShippingRequest(Event et) throws DAOException {

		DBRowSet rs = null;
		Object[] result = new Object[2];

		try {
			
			SppBkg0003Event event = (SppBkg0003Event) et;

			if("".equals(event.getBkgNo()) && "".equals(event.getPolCd())){
				throw new Exception("Please enter Booking Number or POL");
			}
			
			if(null == event.getBkgNo() && null == event.getPolCd()){
				throw new Exception("Please enter Booking Number or POL");
			}
			
			String bkgNo = event.getBkgNo();
			String cntrNo = event.getCntrNo();
			String updDtFrom = event.getUpdDtFrom();
			String updDtTo = event.getUpdDtTo();
			String vndrSeq = event.getVndrSeq();	
			String polCd = event.getPolCd();

//			if(event.getBkgNo() == null || event.getBkgNo().equals("")) {
//				throw new Exception("Please enter Booking Number");
//		    }
//			if(event.getCntrNo() == null || event.getCntrNo().equals("")) {
//				throw new Exception("Please enter Container Number");
//		    }

			//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("bkg_no", bkgNo);
    		param.put("cntr_no", cntrNo);
    		param.put("upd_dt_from", updDtFrom);
    		param.put("upd_dt_to", updDtTo);
    		param.put("vndr_seq", vndrSeq);   		
    		param.put("pol_cd", polCd);
    		
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("bkg_no", bkgNo);
    		velParam.put("cntr_no", cntrNo);
    		velParam.put("upd_dt_from", updDtFrom);
    		velParam.put("upd_dt_to", updDtTo);
    		velParam.put("vndr_seq", vndrSeq);
    		velParam.put("pol_cd", polCd);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		BangladeshOdcyReqDBDAOSearchShippingRequestRSQL template = new BangladeshOdcyReqDBDAOSearchShippingRequestRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);

			ArrayList args = new ArrayList();
			while (rs != null && rs.next()) {
				ShpRqst shp = new ShpRqst();
				shp.setBkgNo(rs.getString("bkg_no"));
				shp.setCntrNo(rs.getString("cntr_no"));
				shp.setCntrSealNo(rs.getString("cntr_seal_no"));
				shp.setCntrSeq(rs.getInt("cntr_seq"));
				shp.setCntrTpszCd(rs.getString("cntr_tpsz_cd"));
				shp.setCntrVolQty(rs.getDouble("cntr_vol_qty"));
				shp.setCntrWgt(rs.getDouble("cntr_wgt"));
				shp.setMeasQty(rs.getDouble("meas_qty"));
				shp.setMeasUtCd(rs.getString("meas_ut_cd"));
				shp.setPckTpCd(rs.getString("pck_tp_cd"));
				shp.setPckQty(rs.getDouble("pck_qty"));
				shp.setWgtUtCd(rs.getString("wgt_ut_cd"));
				shp.setVndrSeq(rs.getInt("vndr_seq"));
				shp.setSlaneCd(rs.getString("slane_cd"));
				shp.setPolCd(rs.getString("pol_cd"));
				shp.setVvd(rs.getString("vvd"));
				args.add(shp);
			}

			// 조회결과
			if (args.size() == 0) {
				result[0] = null;
			} else {
				result[0] = (ShpRqst[]) args.toArray(new ShpRqst[0]);
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
			throw new DAOException("");
		}
		return result;
	}
}
