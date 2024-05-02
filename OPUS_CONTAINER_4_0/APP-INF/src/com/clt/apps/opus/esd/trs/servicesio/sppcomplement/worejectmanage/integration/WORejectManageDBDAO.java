/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WORejectManageDBDAO.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.common.document.WorkOrderDetailSubmitRejectList;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.basic.WORejectManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspWrkOrdPrvTmpVO;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectManageBCImpl 참조
 * @since J2EE 1.4
 */
public class WORejectManageDBDAO extends DBDAOSupport {
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * DB에 반영.(추가, 수정)<br>
	 * 
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public boolean multiRejectWOList(Event et) throws DAOException {
				
		boolean isSuccessFlag = false;		

		Map<String, Object> param = new HashMap<String, Object>();
		
		DBRowSet dRs = null;
		DBRowSet dRs2 = null;
	
		WorkOrderDetailSubmitRejectList[] workOrderDetailSubmitRejectList = null;		

		ExpPap0002Event event = (ExpPap0002Event)et;
		workOrderDetailSubmitRejectList = event.getWorkOrderDetailSubmitRejectList();			
        String r_trsp_wo_ofc_cty_cd		= event.getWorkOrderNo().substring(0,3);
        String r_trsp_wo_seq 			= event.getWorkOrderNo().substring(3,10);
        String r_vendor_seq				= event.getVendorCode();
       
        
		log.info("####  WorkOrderDetailSubmitRejectList.length = " + workOrderDetailSubmitRejectList.length);		
		
		try {
			
			
			for ( int i=0; i<workOrderDetailSubmitRejectList.length; i++ ) {
				
				if(workOrderDetailSubmitRejectList[i].getSo_no().substring(0,3) == null || workOrderDetailSubmitRejectList[i].getSo_no().substring(0,3).equals("") ){
	    			throw new Exception("SO_NO is mandatory");
				}
				if(workOrderDetailSubmitRejectList[i].getSo_no().substring(3) == null || workOrderDetailSubmitRejectList[i].getSo_no().substring(0,3).equals("") ){
	    			throw new Exception("SO_SEQUENCE is mandatory");
				}
				if(r_vendor_seq == null || r_vendor_seq.equals("") ){
	    			throw new Exception("vender sequece is mandatory");
				}
				log.info("r_trsp_wo_ofc_cty_cd::::"+r_trsp_wo_ofc_cty_cd +":::r_trsp_wo_seq:::"+r_trsp_wo_seq);
				param.put("TRSP_WO_OFC_CTY_CD", r_trsp_wo_ofc_cty_cd);
				param.put("TRSP_WO_SEQ", r_trsp_wo_seq);
				
				dRs = new SQLExecuter().executeQuery(new WORejectManageDBDAOmultiRejectWOListOfcCdRSQL(), param, param);
		
		
				if(dRs != null && dRs.next()){
			
					param.put("OFC_CD", dRs.getString("OFC_CD"));
					param.put("TRSP_SO_OFC_CTY_CD", workOrderDetailSubmitRejectList[i].getSo_no().substring(0,3).trim());
					param.put("TRSP_SO_SEQ", Integer.parseInt(workOrderDetailSubmitRejectList[i].getSo_no().substring(3).trim()));

					dRs2 = new SQLExecuter().executeQuery(new WORejectManageDBDAOmultiRejectWOListInvRSQL(), param,param);
		
					if(dRs2 != null && dRs2.next()){
			
						param.put("OFC_CD", dRs.getString("OFC_CD"));
						param.put("TRSP_SO_OFC_CTY_CD", workOrderDetailSubmitRejectList[i].getSo_no().substring(0,3).trim());
						param.put("TRSP_SO_SEQ", Integer.parseInt(workOrderDetailSubmitRejectList[i].getSo_no().substring(3).trim()));
						param.put("TRSP_WO_OFC_CTY_CD", event.getWorkOrderNo().substring(0,3).trim());
						param.put("TRSP_WO_SEQ",Integer.parseInt(event.getWorkOrderNo().substring(3).trim()));
						param.put("WO_VNDR_SEQ",Integer.parseInt(event.getVendorCode().trim()));
						param.put("WO_RJCT_RSN",workOrderDetailSubmitRejectList[i].getRejectReason().trim());
				
						new SQLExecuter().executeUpdate(new WORejectManageDBDAOmultiRejectWOListRejectUSQL(), param,param);

						new SQLExecuter().executeUpdate(new WORejectManageDBDAOmultiRejectWOListRjctHisCSQL(), param,param);
 
						new SQLExecuter().executeUpdate(new WORejectManageDBDAOmultiRejectWOListWoUSQL(), param,param);

					} else {
						throw new Exception("INVOICE is already submitted ");
					}
				}
					isSuccessFlag = true;

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
		return isSuccessFlag;
	}

	
	/**
	 * DB에 반영.(추가, 수정)<br>
	 * 
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0024Event selectRejectWO(Event et) throws DAOException {
		
		DBRowSet dRs1 = null;
		DBRowSet dRs2 = null;
		DBRowSet dRs3 = null;

		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspWrkOrdVO	wrkOrdVO 			= new TrsTrspWrkOrdVO();
		WorkOrderPreviewVO wrkOrdPrvVO 	= new WorkOrderPreviewVO();
		
		WorkOrderDetailSubmitRejectList[] workOrderDetailSubmitRejectList = null;	
		
		ExpPap0002Event event = (ExpPap0002Event)et;
		workOrderDetailSubmitRejectList = event.getWorkOrderDetailSubmitRejectList();			
        String r_trsp_wo_ofc_cty_cd		= event.getWorkOrderNo().substring(0,3);
        String r_trsp_wo_seq 			= event.getWorkOrderNo().substring(3);
        String r_vendor_seq				= event.getVendorCode();
        
		log.info("####  WorkOrderDetailSubmitRejectList.length = " + workOrderDetailSubmitRejectList.length);
		        
		EsdTrs0024Event event24 = new EsdTrs0024Event();
		HashMap<String, String> hashParam = event24.getHashParam();

		
		param.put("TRSP_WO_OFC_CTY_CD", r_trsp_wo_ofc_cty_cd);
		param.put("TRSP_WO_SEQ", r_trsp_wo_seq);
		param.put("VNDR_SEQ", r_vendor_seq);
		
		try {
			
			for ( int i=0; i<workOrderDetailSubmitRejectList.length; i++ ) {			
				
				dRs1 = new SQLExecuter().executeQuery(new WORejectManageDBDAOselectRejectWOOfcCdRSQL(), param,param);
				
				if(dRs1 != null && dRs1.next()){
					String ofc_cd =dRs1.getString("OFC_CD");
					param.put("FORM_CRE_USR_ID", ofc_cd);
					param.put("FORM_USR_OFC_CD", ofc_cd);

					dRs2 = new SQLExecuter().executeQuery(new WORejectManageDBDAOselectRejectWOWoDataRSQL(), param,param);
					
					if(dRs2 != null && dRs2.next()){
						hashParam.put("f_cmd", dRs2.getString("f_cmd"));
						hashParam.put("FORM_CRE_USR_ID", dRs2.getString("FORM_CRE_USR_ID"));
						hashParam.put("FORM_USR_OFC_CD", dRs2.getString("FORM_USR_OFC_CD"));
						hashParam.put("issued", dRs2.getString("issued"));
						hashParam.put("SCG_GRP_SEQ", dRs2.getString("SCG_GRP_SEQ"));
						hashParam.put("WO_VNDR_SEQ", dRs2.getString("WO_VNDR_SEQ"));			
						hashParam.put("WO_ISS_STS_CD", dRs2.getString("WO_ISS_STS_CD"));
						hashParam.put("TRSP_WO_OFC_CTY_CD", dRs2.getString("TRSP_WO_OFC_CTY_CD"));
						hashParam.put("TRSP_WO_SEQ", dRs2.getString("TRSP_WO_SEQ"));
						hashParam.put("FAX_SYS_CD", dRs2.getString("FAX_SYS_CD"));
						hashParam.put("FAX_APP_CD", dRs2.getString("FAX_APP_CD"));
						hashParam.put("FAX_BATCH_IND", dRs2.getString("FAX_BATCH_IND"));
						hashParam.put("FAX_TITLE", dRs2.getString("FAX_TITLE"));
						hashParam.put("FAX_PARAM", dRs2.getString("FAX_PARAM"));
						hashParam.put("FAX_RCV_INFO", dRs2.getString("FAX_RCV_INFO"));
						hashParam.put("EMAIL_TITLE", dRs2.getString("EMAIL_TITLE"));			
						hashParam.put("EMAIL_CONTENTS", dRs2.getString("EMAIL_CONTENTS"));
						hashParam.put("WO_PRN_USE_FLG", dRs2.getString("WO_PRN_USE_FLG"));
						hashParam.put("WO_EML_USE_FLG", dRs2.getString("WO_EML_USE_FLG"));
						hashParam.put("WO_FAX_USE_FLG", dRs2.getString("WO_FAX_USE_FLG"));
						hashParam.put("WO_EDI_USE_FLG", dRs2.getString("WO_EDI_USE_FLG"));
						hashParam.put("RT_DP_USE_FLG", dRs2.getString("RT_DP_USE_FLG"));
						hashParam.put("CMDT_DP_USE_FLG", dRs2.getString("CMDT_DP_USE_FLG"));
						hashParam.put("PRE_DIS_USE_FLG", dRs2.getString("PRE_DIS_USE_FLG"));
						hashParam.put("WO_N1ST_EML", dRs2.getString("WO_N1ST_EML"));
						hashParam.put("WO_N2ND_EML", dRs2.getString("WO_N2ND_EML"));			
						hashParam.put("WO_N3RD_EML", dRs2.getString("WO_N3RD_EML"));
						hashParam.put("WO_N1ST_FAX_NO", dRs2.getString("WO_N1ST_FAX_NO"));
						hashParam.put("WO_N2ND_FAX_NO", dRs2.getString("WO_N2ND_FAX_NO"));
						hashParam.put("WO_N3RD_FAX_NO", dRs2.getString("WO_N3RD_FAX_NO"));
						wrkOrdVO.setCreUsrId(dRs2.getString("FORM_CRE_USR_ID"));
						wrkOrdVO.setCreOfcCd(dRs2.getString("FORM_USR_OFC_CD"));
						wrkOrdVO.setWoVndrSeq(dRs2.getString("WO_VNDR_SEQ"));			
						wrkOrdVO.setWoIssStsCd(dRs2.getString("WO_ISS_STS_CD"));
						wrkOrdVO.setTrspWoOfcCtyCd(dRs2.getString("TRSP_WO_OFC_CTY_CD"));
						wrkOrdVO.setTrspWoSeq(dRs2.getString("TRSP_WO_SEQ"));
						wrkOrdVO.setWoFaxUseFlg(dRs2.getString("FAX_SYS_CD"));
						wrkOrdVO.setWoPrnUseFlg(dRs2.getString("WO_PRN_USE_FLG"));
						wrkOrdVO.setWoEmlUseFlg(dRs2.getString("WO_EML_USE_FLG"));
						wrkOrdVO.setWoFaxUseFlg(dRs2.getString("WO_FAX_USE_FLG"));
						wrkOrdVO.setWoEdiUseFlg(dRs2.getString("WO_EDI_USE_FLG"));
						wrkOrdVO.setRtDpUseFlg(dRs2.getString("RT_DP_USE_FLG"));
						wrkOrdVO.setCmdtDpUseFlg(dRs2.getString("CMDT_DP_USE_FLG"));
						wrkOrdVO.setPreDisUseFlg(dRs2.getString("PRE_DIS_USE_FLG"));
						wrkOrdVO.setWoN1stEml(dRs2.getString("WO_N1ST_EML"));
						wrkOrdVO.setWoN2ndEml(dRs2.getString("WO_N2ND_EML"));			
						wrkOrdVO.setWoN3rdEml(dRs2.getString("WO_N3RD_EML"));
						wrkOrdVO.setWoN1stFaxNo(dRs2.getString("WO_N1ST_FAX_NO"));
						wrkOrdVO.setWoN2ndFaxNo(dRs2.getString("WO_N2ND_FAX_NO"));
						wrkOrdVO.setWoN3rdFaxNo(dRs2.getString("WO_N3RD_FAX_NO"));
						
						wrkOrdPrvVO.setWoVndrSeq(dRs2.getString("WO_VNDR_SEQ"));			
						wrkOrdPrvVO.setWoIssStsCd(dRs2.getString("WO_ISS_STS_CD"));
						wrkOrdPrvVO.setTrspWoOfcCtyCd(dRs2.getString("TRSP_WO_OFC_CTY_CD"));
						wrkOrdPrvVO.setTrspWoSeq(dRs2.getString("TRSP_WO_SEQ"));
						wrkOrdPrvVO.setWoFaxUseFlg(dRs2.getString("FAX_SYS_CD"));
						wrkOrdPrvVO.setWoPrnUseFlg(dRs2.getString("WO_PRN_USE_FLG"));
						wrkOrdPrvVO.setWoEmlUseFlg(dRs2.getString("WO_EML_USE_FLG"));
						wrkOrdPrvVO.setWoFaxUseFlg(dRs2.getString("WO_FAX_USE_FLG"));
						wrkOrdPrvVO.setWoEdiUseFlg(dRs2.getString("WO_EDI_USE_FLG"));
						wrkOrdPrvVO.setRtDpUseFlg(dRs2.getString("RT_DP_USE_FLG"));
						wrkOrdPrvVO.setCmdtDpUseFlg(dRs2.getString("CMDT_DP_USE_FLG"));
						wrkOrdPrvVO.setPreDisUseFlg(dRs2.getString("PRE_DIS_USE_FLG"));
						wrkOrdPrvVO.setWoN1stEml(dRs2.getString("WO_N1ST_EML"));
						wrkOrdPrvVO.setWoN2ndEml(dRs2.getString("WO_N2ND_EML"));			
						wrkOrdPrvVO.setWoN3rdEml(dRs2.getString("WO_N3RD_EML"));
						wrkOrdPrvVO.setWoN1stFaxNo(dRs2.getString("WO_N1ST_FAX_NO"));
						wrkOrdPrvVO.setWoN2ndFaxNo(dRs2.getString("WO_N2ND_FAX_NO"));
						wrkOrdPrvVO.setWoN3rdFaxNo(dRs2.getString("WO_N3RD_FAX_NO"));
						
					}
						event24.setHashParam(hashParam);
					
					
					dRs3 = new SQLExecuter().executeQuery(new WORejectManageDBDAOselectRejectWOSoDataRSQL(), param,param);

					int k = dRs3.getRowCount();
					TrsTrspWrkOrdPrvTmpVO model = new TrsTrspWrkOrdPrvTmpVO();
					TrsTrspWrkOrdPrvTmpVO[] models = new TrsTrspWrkOrdPrvTmpVO[k];
					int j=0;
					while(dRs3 != null && dRs3.next()){
						model = new TrsTrspWrkOrdPrvTmpVO();
						// 알수없는 이유로 마지막 Loop를 사용함 이와같은 이유로 인해 workOrderDetailSubmitRejectList Loop 하여 비교
						for ( int ix=0; ix<workOrderDetailSubmitRejectList.length; ix++ ) {
							if( dRs3.getString("trsp_so_ofc_cty_cd").equals(workOrderDetailSubmitRejectList[ix].getSo_no().substring(0,3)) &&
									dRs3.getString("trsp_so_seq").equals(workOrderDetailSubmitRejectList[ix].getSo_no().substring(3)) ){
								model.setTrspRjctRsnCd("R");
								//workOrderDetailSubmitRejectList[i].getRejectReason();
							}
						}
						model.setIbflag(dRs3.getString("ibflag"));
						model.setTrspSoOfcCtyCd(dRs3.getString("trsp_so_ofc_cty_cd"));   
						model.setTrspSoSeq(dRs3.getString("trsp_so_seq"));  
						model.setWoCxlFlg(dRs3.getString("wo_cxl_flg"));   
						model.setDtnUseFlg(dRs3.getString("dtn_use_flg")); 
						model.setWoBlNoIssFlg(dRs3.getString("wo_bl_no_iss_flg"));  
						model.setVndrSeq(dRs3.getString("vndr_seq")); 
						model.setCurrCd(dRs3.getString("curr_cd")); 
						model.setBzcAmt(dRs3.getString("bzc_amt"));  
						model.setNegoAmt(dRs3.getString("nego_amt")); 
						model.setEtcAddAmt(dRs3.getString("etc_add_amt")); 
						model.setFuelScgAmt(dRs3.getString("fuel_scg_amt"));         
						model.setOvrWgtScgAmt(dRs3.getString("ovr_wgt_scg_amt"));      
						model.setN3ptyBilFlg(dRs3.getString("n3pty_bil_flg")); 
						models[j] = model;
						j++;
					}
					event24.setTrsTrspWrkOrdPrvTmpVOs(models);
					event24.setFormCreUsrId(event.getUserID());	
					event24.setFormUsrOfcCd(ofc_cd);
					event24.setTrsTrspWrkOrdVO(wrkOrdVO);
					event24.setWorkOrderPreviewVO(wrkOrdPrvVO);
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
		}		
		return event24; 
	}

	/**
	 * DB에 반영.(추가, 수정)<br>
	 * 
	 * @param rowset
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public EsdTrs0024Event selectRejectWOMULTI(DBRowSet rowset, Event et) throws DAOException {
		
		DBRowSet dRs1 = null;
		DBRowSet dRs2 = null;

		Map<String, Object> param = new HashMap<String, Object>();
		EsdTrs0024Event event24 = (EsdTrs0024Event) et;
		TrsTrspWrkOrdVO	wrkOrdVO 			= event24.getTrsTrspWrkOrdVO();
		WorkOrderPreviewVO wrkPrvVO  	= event24.getWorkOrderPreviewVO();
		TrsTrspWrkOrdPrvTmpVO wrkOrdPrvTmpVO =  new TrsTrspWrkOrdPrvTmpVO();
		HashMap hashParam = event24.getHashParam();		
	
		
		
		try {
			
			dRs1 = new SQLExecuter().executeQuery(new WORejectManageDBDAOselectRejectWOMULTIUsrRSQL(), param,param);

			if (dRs1 != null && dRs1.next()){
				hashParam.put("USR_ID", dRs1.getString("USR_ID"));
				hashParam.put("USR_EML", dRs1.getString("USR_EML"));

			}
			
			if (rowset != null && rowset.next()) {
				param.put("WO_PRV_GRP_SEQ", rowset.getString("WO_PRV_GRP_SEQ"));
				param.put("WO_ISS_NO",  Integer.parseInt(rowset.getString("WO_ISS_NO")));			
				wrkPrvVO.setWoPrvGrpSeq(rowset.getString("WO_PRV_GRP_SEQ"));
				wrkPrvVO.setWoIssNo(rowset.getString("WO_ISS_NO"));
				wrkOrdVO.setWoFmtTpCd(rowset.getString("WO_FMT_TP_CD"));
				wrkOrdPrvTmpVO.setWoPrvGrpSeq(rowset.getString("WO_PRV_GRP_SEQ"));			
				wrkOrdPrvTmpVO.setWoIssNo(rowset.getString("WO_ISS_NO"));
				hashParam.put("WO_FMT_TP_CD", (rowset.getString("WO_FMT_TP_CD"))); // WO_FMT_TP_CD 추가. 2007.04.09

			}
			
			dRs2 = new SQLExecuter().executeQuery(new WORejectManageDBDAOselectRejectWOMULTITmpRSQL(), param,param);
			
			if (dRs2 != null && dRs2.next()){
				hashParam.put("f_cmd", dRs2.getString("f_cmd"));
				hashParam.put("WO_PRV_GRP_SEQ", dRs2.getString("WO_PRV_GRP_SEQ"));
				hashParam.put("WO_ISS_NO", dRs2.getString("WO_ISS_NO"));
				hashParam.put("FAX_APP_CD", dRs2.getString("FAX_APP_CD"));
				hashParam.put("FAX_PARAM", "[]["+dRs2.getString("WO_PRV_GRP_SEQ")+"]["+dRs2.getString("WO_ISS_NO")+"][SYSTEM][SPP_IF]");
				hashParam.put("FAX_RCV_INFO", dRs2.getString("FAX_RCV_INFO"));
			}	
			event24.setHashParam(hashParam);

			wrkOrdVO.setWoIssStsCd("");
			wrkPrvVO.setContiCd("");
			event24.setTrsTrspWrkOrdVO(wrkOrdVO);
			event24.setWorkOrderPreviewVO(wrkPrvVO);
			event24.setTrsTrspWrkOrdPrvTmpVO(wrkOrdPrvTmpVO);
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
		return event24; 
	}		
}