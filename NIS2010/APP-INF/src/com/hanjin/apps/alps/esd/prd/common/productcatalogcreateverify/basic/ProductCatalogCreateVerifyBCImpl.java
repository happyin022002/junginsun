/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBCImpl.java
 *@FileTitle : PRD 공통관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-16 jungsunyoung
 * 1.0 최초 생성
 * 2011.05.09 변종건 [CHM-201110702-01] [PRD] Product Catalog 생성 오류시 메시지 처리
 * 2011.07.25 변종건 [CHM-201112214-01] [S/R : CHM-201111888 : Group VVD 상에서, DEL Term이 Yard일때, 처리 Logic 변경 요청] 관련, PRD 작업사항 요청.
 * 2011.07.25 변종건 [CHM-201112213-01] [PRD] TML change 이후 COP 상에 inland route 참조 이상오류 수정요청
 * 2012.05.10 정선용 [] virtual port 처리 메세지 

=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.basic;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.integration.ProductCatalogCreateVerifyDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * alps-PRD Business Logic Basic Command implementation<br>
 * - alps-PRD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author jungsunyoung
 * @see EventResponse,PrdCommonManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ProductCatalogCreateVerifyBCImpl extends BasicCommandSupport implements ProductCatalogCreateVerifyBC{

	// Database Access Object
	private transient ProductCatalogCreateVerifyDBDAO dbDao = null;

	/**
	 * PrdCommonManageDBDAO를 생성한다.<br>
	 */
	public ProductCatalogCreateVerifyBCImpl(){
		dbDao = new ProductCatalogCreateVerifyDBDAO();
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * PrdCommonManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd(){
		dbDao = null;
	}

	/**
	 *
	 * @param prdCreateParamVO
	 * @param prdPcCreateVO
	 * @param prdPatternVO
	 * @return
	 * @throws EventException
	 */
	public String getPcVerify(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVO, PrdPatternVO prdPatternVO) throws EventException{
		StringBuilder sbMessage = new StringBuilder();

		try{
			DBRowSet rowset = null;
			//if checkOcnRoute
			rowset = dbDao.getPcVerify(prdCreateParamVO, prdPcCreateVO, prdPatternVO);
			//rowset = dbDao.getOceanRoute(e);
			//sbMessage.append("\n P/C Creation Failed. ");
			if(rowset.next()){

//				if(Integer.parseInt(rowset.getString("HUB_COUNT")) == 0){
//					sbMessage.append("\n Could not find Hub Location ");
//					return sbMessage.toString();
//				}
				if(Integer.parseInt(rowset.getString("ROUT_SEQ")) == 0){
					sbMessage.append("\n Could not find OCN ROUTE. ");
					if(Integer.parseInt(rowset.getString("HUB_COUNT")) == 0){
						sbMessage.append("\n Could not find Hub Location. ");
						//return sbMessage.toString();
					}
					return sbMessage.toString();
				}
				
				log.debug("OB_LOC_ZN_CHK : " + rowset.getString("OB_LOC_ZN_CHK"));
				log.debug("IB_LOC_ZN_CHK : " + rowset.getString("IB_LOC_ZN_CHK"));

				if("X".equals(rowset.getString("CHECK_ROUT"))){
					//sbMessage.append("\n Could not find vessel SKD between ").append(prdCreateParamVO.getPol() + " - " + prdCreateParamVO.getPod());
					//sbMessage.append("\n");
					String vfVvd ="";
					String chgVfVvd ="";
					vfVvd = rowset.getString("VF_VVD");
					chgVfVvd = rowset.getString("CHG_VF_VVD");
					if( !"".equals(vfVvd)){
						sbMessage.append("\n ").append(vfVvd).append(" have 'Virtual Port' flag");
						sbMessage.append("\n which means it can't be used in actual booking.");
						sbMessage.append("\n Please try again with ").append(chgVfVvd);	
					} else if(!"".equals(rowset.getString("STS_CHECK"))){
						sbMessage.append("\n * Please request PUSCOV to activate the status of '").append(rowset.getString("STS_CHECK"));
						sbMessage.append(" ' from 'Closed' to 'Active' so as to update booking inforamtion withouth any restriction.");
						sbMessage.append("\n * Contact Office:PUSCOV");	
					}else {
						sbMessage.append("\n Could not find vessel SKD between ").append(prdCreateParamVO.getPol() + " - " + prdCreateParamVO.getPod());
						String checkValidLink= rowset.getString("CHECK_VALID_LINK");
						String lnk_knt = rowset.getString("LNK_KNT");
						log.debug("\n checkValidLink"+checkValidLink); 
						if( "1".equals(checkValidLink) ) {
							sbMessage.append("\n 1st Link ").append(rowset.getString("ORG_LOC_CD") + " - "  + (lnk_knt.equals("1")? rowset.getString("DEST_LOC_CD"): rowset.getString("N2ND_POL_CD")) + "(" + rowset.getString("N1ST_LANE_CD")+")");
						} else if("2".equals(checkValidLink) ){
							sbMessage.append("\n 2nd Link ").append(rowset.getString("N2ND_POL_CD") + " - " + (lnk_knt.equals("2")? rowset.getString("DEST_LOC_CD"):rowset.getString("N3RD_POL_CD"))+ "(" + rowset.getString("N2ND_LANE_CD")+")");
						} else if("3".equals(checkValidLink) ){
							sbMessage.append("\n 3rd Link ").append(rowset.getString("N3RD_POL_CD") + " - " + (lnk_knt.equals("3")? rowset.getString("DEST_LOC_CD"):rowset.getString("N4TH_POL_CD"))+ "(" + rowset.getString("N3RD_LANE_CD")+")");
						} else if("4".equals(checkValidLink) ){
							sbMessage.append("\n 4th Link ").append(rowset.getString("N4TH_POL_CD") + " - " +rowset.getString("DEST_LOC_CD")+ "(" + rowset.getString("N4TH_LANE_CD")+")");
						}
						sbMessage.append("\n");
					}
					
				} else if ("Y".equals(rowset.getString("CHECK_ROUT")) && "X".equals(rowset.getString("OCN_SO_CHK"))){
					sbMessage.append("\n Could not find proper Ocean Route from the S/O Information. \n Please check the S/O and the ocean route. ");
					sbMessage.append("\n");
					
				} else {
					StringBuffer sbObMsg = new StringBuffer();
					String obTr = prdCreateParamVO.getObTrspMode();
					if ("LOC".equals(rowset.getString("OB_LOC_ZN_CHK"))){
						sbObMsg.append("POR Location Code is not registered on MDM. Pls check the node information.");
					}else if ("D".equals(prdCreateParamVO.getRcvT()) && "ZN".equals(rowset.getString("OB_LOC_ZN_CHK"))){
						sbObMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("D".equals(prdCreateParamVO.getRcvT()) && "LZ".equals(rowset.getString("OB_LOC_ZN_CHK"))){
						sbObMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "B".equals(rowset.getString("ORG_FLG_CHK"))){
						sbObMsg.append("Please check O/B's BKG Flag");
						sbObMsg.append("\n and its Priority with the control RHQ for the route");
					} else if ("X".equals(rowset.getString("ORG_CHECK"))){ // route를 먼저 체크한 다음 trans mode를 검사하도록 변경
						String fmNode = (prdCreateParamVO.getPorN() != null && !"".equals(prdCreateParamVO.getPorN()))?prdCreateParamVO.getPorN():prdCreateParamVO.getPor();
						String toNode = (prdCreateParamVO.getPolN() != null && !"".equals(prdCreateParamVO.getPolN()))?prdCreateParamVO.getPolN():prdCreateParamVO.getPol();
						sbObMsg.append("There is no proper inland route from ").append(fmNode).append(" to ").append(toNode).append(" in PRD\n Please request each RHQ/Operation part to register the above inland route.");
//						sbObMsg.append("\n Could not find Outbound Route from ").append(prdCreateParamVO.getPor() +"," + prdCreateParamVO.getPorN()).append(" to ").append(prdCreateParamVO.getPol() + ","+prdCreateParamVO.getPolN()).append(" for R_Term[").append(prdCreateParamVO.getRcvT()).append("]\n Please change service term or request to create new Inland Route ");
						sbObMsg.append("\n");
					} else if(obTr != null && !"".equals(obTr) && !"AL".equals(obTr) && !obTr.equals(rowset.getString("OB_TRSP_MOD_CD"))){ 
						sbObMsg.append("Could not find Outbound TransMode [").append(obTr).append("] \n");
//					} else if ("X".equals(rowset.getString("ORG_CHECK"))){
//						sbObMsg.append("\n Could not find Outbound Route from ").append(prdCreateParamVO.getPor() +"," + prdCreateParamVO.getPorN()).append(" to ").append(prdCreateParamVO.getPol() + ","+prdCreateParamVO.getPolN()).append(" for R_Term[").append(prdCreateParamVO.getRcvT()).append("]\n Please change service term or request to create new Inland Route ");
//						sbObMsg.append("\n");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "X".equals(rowset.getString("OB_SO_CHK")) 
							&& "Y".equals(rowset.getString("OB_IRG_CHK").substring(0,1))){
						sbObMsg.append("The O/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
//						sbObMsg.append("\n[SO ROUTE : ").append(rowset.getString("OB_IRG_CHK").substring(2)).append("]");
						String msgStr = prdPatternVO.getObItchgCtnt().replaceAll("-..-.-...-","-").replaceAll("[%]{3}|[%]{2}|[%]{1}", "-");
						msgStr = msgStr.substring(1, msgStr.length() -1);
						sbObMsg.append("\n[SO ROUTE : ").append(msgStr).append("]");
						sbObMsg.append("\n");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "X".equals(rowset.getString("OB_SO_CHK"))){
						sbObMsg.append("The O/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
						String msgStr = prdPatternVO.getObItchgCtnt().replaceAll("-..-.-...-","-").replaceAll("[%]{3}|[%]{2}|[%]{1}", "-");
						msgStr = msgStr.substring(1, msgStr.length() -1);
						sbObMsg.append("\n[SO ROUTE : ").append(msgStr).append("]");
//						sbObMsg.append("\n Could not find proper Outbound Route from the S/O Information. \n Please check the O/B S/O of this booking. ");
						sbObMsg.append("\n");
//					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "B".equals(rowset.getString("ORG_FLG_CHK"))){
//						sbObMsg.append("\n Please check O/B's BKG Flag");
//						sbObMsg.append("\n and its Priority with the control RHQ for the route");
					} else if ("Y".equals(rowset.getString("ORG_CHECK")) && "N".equals(rowset.getString("ORG_FLG_CHK"))){
						sbObMsg.append("The O/B route you are trying to change have Temp flag, so you can’t choose that.");
						sbObMsg.append("\n Please contact an operation group of RHQ who is controlling area’s inland route");
//					} else if ("X".equals(rowset.getString("FULL_RTN_CHK"))){
//						sbObMsg.append("Full Return CY should be based on Inland Routes registered in PRD set by Operation Part(RHQ)");
					} else if ("D".equals(prdCreateParamVO.getRcvT()) && "N".equals(rowset.getString("MTPU_CY_CHK")) && "ZY".equals(rowset.getString("OB_LOC_ZN_CHK"))){
						sbObMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("Y".equals(prdCreateParamVO.getRcvT()) && "N".equals(rowset.getString("MTPU_CY_CHK")) && "MPU".equals(rowset.getString("OB_LOC_ZN_CHK"))){
						sbObMsg.append("Rep. Empty or Return CY is not registered. Pls contact RHQ to ask registering it.");
					}  
					
					StringBuffer sbIbMsg = new StringBuffer();
					String ibTr = prdCreateParamVO.getIbTrspMode();
					if ("LOC".equals(rowset.getString("IB_LOC_ZN_CHK"))){
						sbIbMsg.append("DEL Location Code is not registered on MDM. Pls check the node information.");
					}else if ("D".equals(prdCreateParamVO.getDelT()) && "ZN".equals(rowset.getString("IB_LOC_ZN_CHK"))){
						sbIbMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("D".equals(prdCreateParamVO.getDelT()) && "LZ".equals(rowset.getString("IB_LOC_ZN_CHK"))){
						sbIbMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "B".equals(rowset.getString("DEST_FLG_CHK"))){
						sbIbMsg.append("Please check I/B's BKG Flag");
						sbIbMsg.append("\n and its Priority with the control RHQ for the route");
					} else if ("X".equals(rowset.getString("DEST_CHECK"))){ // route를 먼저 체크한 다음 trans mode를 검사하도록 변경
						String podN = "";
						if (prdCreateParamVO.getDelN() != null && !"".equals(prdCreateParamVO.getDelN()) && prdCreateParamVO.getPod() != null && !"".equals(prdCreateParamVO.getPod())) {
							String pod = prdCreateParamVO.getPod();
							if (prdCreateParamVO.getPod4N() != null && !prdCreateParamVO.getPod4N().equals("") && pod.equals(prdCreateParamVO.getPod4N().substring(0,5)) && prdCreateParamVO.getPod4N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod4N();
							} else if (prdCreateParamVO.getPod3N() != null && !prdCreateParamVO.getPod3N().equals("") && pod.equals(prdCreateParamVO.getPod3N().substring(0,5)) && prdCreateParamVO.getPod3N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod3N();
							} else if (prdCreateParamVO.getPod2N() != null && !prdCreateParamVO.getPod2N().equals("") && pod.equals(prdCreateParamVO.getPod2N().substring(0,5)) && prdCreateParamVO.getPod2N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod2N();
							} else if (prdCreateParamVO.getPod1N() != null && !prdCreateParamVO.getPod1N().equals("") && pod.equals(prdCreateParamVO.getPod1N().substring(0,5)) && prdCreateParamVO.getPod1N().equals(rowset.getString("POD_NODE_"))) {
								podN = prdCreateParamVO.getPod1N();
							}
						}
						
						if(!podN.equals("")) {
							String toNode = (prdCreateParamVO.getDelN() != null && !"".equals(prdCreateParamVO.getDelN()))?prdCreateParamVO.getDelN():prdCreateParamVO.getDel();
							sbIbMsg.append("There is no proper inland route from ").append(podN).append(" to ").append(toNode).append(" in PRD\n Please request each RHQ/Operation part to register the above inland route.");
						} else {
							sbIbMsg.append("Could not find Inbound Route from ").append(prdCreateParamVO.getPod() +","+ prdCreateParamVO.getPodN()).append(" to ").append(prdCreateParamVO.getDel() + ","+prdCreateParamVO.getDelN()).append(" for D_Term[").append(prdCreateParamVO.getDelT()).append("]\n Please change service term or request to create new Inland Route ");
						}
						sbIbMsg.append("\n");
					} else if(ibTr != null && !"".equals(ibTr) && !"AL".equals(obTr) && !ibTr.equals(rowset.getString("IB_TRSP_MOD_CD"))){
						sbIbMsg.append("Could not find Inbound TransMode [").append(ibTr).append("] \n");
//					} else if ("X".equals(rowset.getString("DEST_CHECK"))){
//						sbIbMsg.append("\n Could not find Inbound Route from ").append(prdCreateParamVO.getPod() +","+ prdCreateParamVO.getPodN()).append(" to ").append(prdCreateParamVO.getDel() + ","+prdCreateParamVO.getDelN()).append(" for D_Term[").append(prdCreateParamVO.getDelT()).append("]\n Please change service term or request to create new Inland Route ");
//						sbIbMsg.append("\n");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "X".equals(rowset.getString("IB_SO_CHK")) 
							&& "Y".equals(rowset.getString("IB_IRG_CHK").substring(0,1))){
						sbIbMsg.append("The I/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
//						sbIbMsg.append("\n[SO ROUTE : ").append(rowset.getString("IB_IRG_CHK").substring(2)).append("]");
						String msgStr = prdPatternVO.getIbItchgCtnt().replaceAll("-..-.-...-","-").replaceAll("[%]{3}|[%]{2}|[%]{1}", "-");
						msgStr = msgStr.substring(1, msgStr.length() -1);
						sbIbMsg.append("\n[SO ROUTE : ").append(msgStr).append("]");
						sbIbMsg.append("\n");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "X".equals(rowset.getString("IB_SO_CHK"))){
						sbIbMsg.append("The I/B's Inland Route Information between BKG and SO is different. Please match the route of BKG and SO.");
						String msgStr = prdPatternVO.getIbItchgCtnt().replaceAll("-..-.-...-","-").replaceAll("[%]{3}|[%]{2}|[%]{1}", "-");
						msgStr = msgStr.substring(1, msgStr.length() -1);
						sbIbMsg.append("\n[SO ROUTE : ").append(msgStr).append("]");
//						sbIbMsg.append("\n Could not find proper Inbound Route from the S/O Information. \n Please check the I/B S/O of this booking. ");
						sbIbMsg.append("\n");
//					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "B".equals(rowset.getString("DEST_FLG_CHK"))){
//						sbIbMsg.append("\n Please check I/B's BKG Flag");
//						sbIbMsg.append("\n and its Priority with the control RHQ for the route");
					} else if ("Y".equals(rowset.getString("DEST_CHECK")) && "N".equals(rowset.getString("DEST_FLG_CHK"))){
						sbIbMsg.append("The I/B route you are trying to change have Temp flag, so you can’t choose that.");
						sbIbMsg.append("\n Please contact an operation group of RHQ who is controlling area’s inland route");
					} else if ("D".equals(prdCreateParamVO.getDelT()) && "N".equals(rowset.getString("MTRTN_CY_CHK")) && "ZY".equals(rowset.getString("IB_LOC_ZN_CHK"))){
						sbIbMsg.append("Rep. Zone and Rep.CY for that are not registered. Pls contact RHQ to ask registering it.");
					} else if ("Y".equals(prdCreateParamVO.getDelT()) && "N".equals(rowset.getString("MTRTN_CY_CHK")) && "MRTN".equals(rowset.getString("IB_LOC_ZN_CHK"))){
						sbIbMsg.append("Rep. Empty or Return CY is not registered. Pls contact RHQ to ask registering it.");
					}  
					
					//pol double calling check
					StringBuffer etcMsg = new StringBuffer();
					if("Y".equals(rowset.getString("ORG_DC_CHECK"))){
						etcMsg.append("\n Please check Double calling. ["+rowset.getString("VVD1")+"-"+rowset.getString("POL1_")+ "]" +
								"\n Try Transshipment > Group VVD/Port Assign.");
					}
					
					if(sbObMsg.length() > 0 && sbIbMsg.length() > 0) {
						if (sbObMsg.toString().equals(sbIbMsg.toString())) {
							sbMessage.append("\n " ).append(sbObMsg.toString());
						} else {
							sbMessage.append("\n 1) " ).append(sbObMsg.toString());
							sbMessage.append("\n\n 2) " ).append(sbIbMsg.toString());
						}
					} else if (sbObMsg.length() > 0) {
						sbMessage.append("\n " ).append(sbObMsg.toString());
					} else if (sbIbMsg.length() > 0) {
						sbMessage.append("\n " ).append(sbIbMsg.toString());
					}
					
					if(etcMsg.length()> 0){
						sbMessage.append(etcMsg.toString());
					}
					
				}
				
			}else{
				sbMessage.append("\n Not Found Any Available Ocean Route !! ");
				sbMessage.append("\n");
			}
			
			if(sbMessage.length() == 0){
				sbMessage.append("\n P/C Creation Failed. ");

			}
			 
			return sbMessage.toString();

		}catch(DAOException ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	} // end method
}
