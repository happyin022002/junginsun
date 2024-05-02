/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerMovementMgtForGateNewBCImpl.java
 *@FileTitle : GATENEW Business Logic Basic Command implementation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.27
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration.ContainerMovementValidationDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDICtmEqMvmtListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.CtmMvmtEdiBkgVO;

 
/**
 * OPUS-EquipmentMovementMgt Business Logic Basic Command implementation
 * handling business logic about OPUS-EquipmentMovementMgt
 *
 * @author 
 * @see    Ees_ctm_0000EventResponse, ContainerMovementMgtForGateNewBC DAO class reference
 * @see    UbizComOpusCtmEqmvmt EventResponse(MQ message INBOUND), ContainerMovementMgtForGateNewBC DAO class reference
 * @since J2EE 1.6
 */
public class ContainerMovementMgtForGateNewBCImpl extends BasicCommandSupport implements ContainerMovementMgtForGateNewBC {

	// Database Access Object
	private transient ContainerMovementMgtForGateNewDBDAO dbDao = null;
	private transient ContainerMovementValidationDBDAO dbDao2 = null;

	/**
	 * creating ContainerMovementMgtForGateNewBCImpl Object
	 * creating ContainerMovementValidationBC
	 * creating ContainerMovementMgtForGateNewDBDAO
	 */
	public ContainerMovementMgtForGateNewBCImpl() {
		dbDao = new ContainerMovementMgtForGateNewDBDAO();
		dbDao2 = new ContainerMovementValidationDBDAO();
	}
	
	
	/**
	 * Saving <br>
	 * Saving EDI Message from terminal to DB[]
	 * 
	 * @param String ediFlatFile
	 * @return SearchEDICtmEqMvmtListVO
	 * @exception EventException
	 */
	public List<SearchEDICtmEqMvmtListVO> setEppBookingNew(String ediFlatFile) {
		
		List<SearchEDICtmEqMvmtListVO> flatFilePartnerLineVOs = new ArrayList<SearchEDICtmEqMvmtListVO>();		
		SearchEDICtmEqMvmtListVO     ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
		String[] result = null;
		String brgTpId = "";
		
		/*List<SearchEDICtmEqMvmtListVO> insertVoList = new ArrayList<SearchEDICtmEqMvmtListVO>();
		List<SearchEDICtmEqMvmtListVO> updateVoList = new ArrayList<SearchEDICtmEqMvmtListVO>();
		List<SearchEDICtmEqMvmtListVO> deleteVoList = new ArrayList<SearchEDICtmEqMvmtListVO>();*/
		
		try {			

			String [] arrDomEdiFlatFile = ediFlatFile.split("\n");
			String tempDomEdiFlatFile = "";
			String srtFlag = "";
			
			for(int i=0; arrDomEdiFlatFile!=null && i<arrDomEdiFlatFile.length; i++){
				tempDomEdiFlatFile = arrDomEdiFlatFile[i];
				
				int bkgBookingCnt = tempDomEdiFlatFile.indexOf("BKG_BOOKING");		//OK
				int eppCnt = tempDomEdiFlatFile.indexOf("EPP#|#");							//OK
				
				int bkgContainerCnt = tempDomEdiFlatFile.indexOf("BKG_CONTAINER");	//OK
				int eppContainerCnt = tempDomEdiFlatFile.indexOf("EPP_CONTAINER");
				
				int bkgVvdCnt = tempDomEdiFlatFile.indexOf("BKG_VVD");						//OK
				int eppVvdCnt = tempDomEdiFlatFile.indexOf("EPP_VVD");		
				
				int domBookingCnt = tempDomEdiFlatFile.indexOf("DOM_BOOKING");			//OK
				
				int bkgBlCnt = tempDomEdiFlatFile.indexOf("BKG_BL");							// OK
 				
			
				tempDomEdiFlatFile = tempDomEdiFlatFile.replaceAll("\"", "");
				result = null;
				String[] arrResult = null;
				
				
				int fiatSize = 0;
				if(bkgBlCnt >= 0) {
					if(bkgBlCnt >= 0) result = tempDomEdiFlatFile.split("BKG_BL");
					brgTpId = "BKG_BL";
					//[2015.05.28]소스품질 Modify
					if(null != result){
						fiatSize = result.length;
						for (int fiatRow = 1; fiatRow < fiatSize ; fiatRow++ ) {	
							arrResult = result[fiatRow].split("#\\|#");
							
							ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
							ediCtmEqVO.setBkgNo					(arrResult[1].trim());		
							ediCtmEqVO.setBlNo						(arrResult[2].trim());		
							ediCtmEqVO.setBlNoTp					(arrResult[3].trim());	
							ediCtmEqVO.setBlTpCd					(arrResult[4].trim());		
							ediCtmEqVO.setCudFlg					(arrResult[5].trim());	
							srtFlag = arrResult[5].trim();
							
							ediCtmEqVO.setBrgTpId(brgTpId);
							ediCtmEqVO.setDatMnplCd(srtFlag);
							flatFilePartnerLineVOs.add(ediCtmEqVO);
							
//							int cnt = dbDao.selectEDIBkgBlMvmtCnt(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getBlNo());
//							if(cnt>0){//있다면 
//								dbDao.deleteEDIBkgBlMvmt(ediCtmEqVO);
//								dbDao.insertEDIBkgBlMvmt(ediCtmEqVO);
//								
//							}else{
//								dbDao.insertEDIBkgBlMvmt(ediCtmEqVO);
//							}
							
							if("C".equals(srtFlag)) {
								int cnt = dbDao.selectEDIBkgBlMvmtCnt(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getBlNo());
								if(cnt>0){
									dbDao.updateEDIBkgBlMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIBkgBlMvmt(ediCtmEqVO);
								}
								
							}else if("N".equals(srtFlag)) {
								int cnt = dbDao.selectEDIBkgBlMvmtCnt(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getBlNo());
								if(cnt<=0){
									dbDao.insertEDIBkgBlMvmt(ediCtmEqVO);
								}
								
							}else if("U".equals(srtFlag)) {
								// update
								int cnt = dbDao.selectEDIBkgBlMvmtCnt(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getBlNo());
								if(cnt>0){
									dbDao.updateEDIBkgBlMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIBkgBlMvmt(ediCtmEqVO);
								}
								
							}else if("D".equals(srtFlag)) {
								dbDao.deleteEDIBkgBlMvmt(ediCtmEqVO);
								// Del column update 
							}
						}
					}
				}
				
				if(domBookingCnt >= 0) {
					if(domBookingCnt >= 0) result = tempDomEdiFlatFile.split("DOM_BOOKING");
					brgTpId = "DOM_BOOKING";
					//[2015.05.28]소스품질 Modify
					if(null != result){
						fiatSize = result.length;
						for (int fiatRow = 1; fiatRow < fiatSize ; fiatRow++ ) {	
							arrResult = result[fiatRow].split("#\\|#");
							
							ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
							ediCtmEqVO.setDmstBkgNo				(arrResult[1].trim());		
							ediCtmEqVO.setDestLocCd				(arrResult[2].trim());		
							ediCtmEqVO.setStTurnFlg				(arrResult[3].trim());					
							ediCtmEqVO.setCntrNo					(arrResult[4].trim());			
							ediCtmEqVO.setCudFlg					(arrResult[5].trim());	
							
							srtFlag = arrResult[5].trim();
							ediCtmEqVO.setBrgTpId(brgTpId);
							ediCtmEqVO.setDatMnplCd(srtFlag);
							
							flatFilePartnerLineVOs.add(ediCtmEqVO);
							int cnt = dbDao.selectEDIDmstMvmt(ediCtmEqVO.getDmstBkgNo());
							
							if("C".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDIDomBkgMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIDomBkgMvmt(ediCtmEqVO);
								}
								
							}else if("N".equals(srtFlag)) {
								if(cnt<=0){
									dbDao.insertEDIDomBkgMvmt(ediCtmEqVO);
								}
								
							}else if("U".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDIDomBkgMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIDomBkgMvmt(ediCtmEqVO);
								}
								
							}else if("D".equals(srtFlag)) {
								dbDao.deleteEDIDomBkgMvmt(ediCtmEqVO);
								// Del column update 
							}
						}
					}
				}
				
				if(bkgBookingCnt >= 0) {
					if(bkgBookingCnt >= 0) result = tempDomEdiFlatFile.split("BKG_BOOKING");		
					brgTpId = "BKG_BOOKING";
					//[2015.05.28]소스품질 Modify
					if(null != result){
						fiatSize = result.length;
						
						for (int fiatRow = 1; fiatRow < fiatSize ; fiatRow++ ) {	
							arrResult = result[fiatRow].split("#\\|#");

							ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
							ediCtmEqVO.setBkgNo				(arrResult[1].trim());
							ediCtmEqVO.setBlNo					(arrResult[2].trim());
							ediCtmEqVO.setBlNoTp				(arrResult[3].trim());
							ediCtmEqVO.setBlTpCd				(arrResult[4].trim());			
							ediCtmEqVO.setBkgStsCd			(arrResult[5].trim());			
							ediCtmEqVO.setBkgCgoTpCd		(arrResult[6].trim());
							ediCtmEqVO.setSlanCd				(arrResult[7].trim());
							ediCtmEqVO.setSvcScpCd			(arrResult[8].trim());
							ediCtmEqVO.setVslCd				(arrResult[9].trim());
							
							if(arrResult[10].trim() != null && !"".equals(arrResult[10].trim())) {
								if(arrResult[10].trim().length() == 4) {							
									ediCtmEqVO.setSkdVoyNo			(arrResult[10].trim());
								}else if(arrResult[10].trim().length() > 4) {							
									ediCtmEqVO.setSkdVoyNo			(arrResult[10].trim().substring(0, 4));
								}else if(arrResult[10].trim().length() < 4)  {							
									ediCtmEqVO.setSkdVoyNo			('0' + arrResult[10].trim());
								}
							}else{
								ediCtmEqVO.setSkdVoyNo			("");
							}
							
							ediCtmEqVO.setSkdDirCd			(arrResult[11].trim());
							ediCtmEqVO.setRcvTermCd		(arrResult[12].trim());
							ediCtmEqVO.setDeTermCd			(arrResult[13].trim());
							ediCtmEqVO.setPorCd				(arrResult[14].trim());
							ediCtmEqVO.setPolCd				(arrResult[15].trim());
							ediCtmEqVO.setPodCd				(arrResult[16].trim());
							ediCtmEqVO.setDelCd				(arrResult[17].trim());
							ediCtmEqVO.setCmdtCd				(arrResult[18].trim());
							ediCtmEqVO.setRepCmdtCd		(arrResult[19].trim());
							ediCtmEqVO.setDcgoFlg				(arrResult[20].trim());
							ediCtmEqVO.setRcFlg				(arrResult[21].trim());
							ediCtmEqVO.setAwkCgoFlg			(arrResult[22].trim());
							ediCtmEqVO.setBbCgoFlg			(arrResult[23].trim());
							ediCtmEqVO.setRdCgoFlg			(arrResult[24].trim());
							ediCtmEqVO.setHngrFlg				(arrResult[25].trim());
							ediCtmEqVO.setRailBlkCd			(arrResult[26].trim());
							ediCtmEqVO.setPrctFlg				(arrResult[27].trim());
							ediCtmEqVO.setSpclHideFlg		(arrResult[28].trim());
							ediCtmEqVO.setSocFlg				(arrResult[29].trim());
							ediCtmEqVO.setSplitFlg				(arrResult[30].trim());
							ediCtmEqVO.setHcmtCmbFlg		(arrResult[31].trim());
							ediCtmEqVO.setBkgCreTpCd		(arrResult[32].trim());
							ediCtmEqVO.setToBkgNo			(arrResult[33].trim());
							ediCtmEqVO.setFmBkgNo			(arrResult[34].trim());
							ediCtmEqVO.setMtySplitAvalCd	(arrResult[35].trim());
							ediCtmEqVO.setPreRlyPortCd		(arrResult[36].trim());
							ediCtmEqVO.setPstRlyPortCd		(arrResult[37].trim());
							ediCtmEqVO.setCreUsrId			(arrResult[38].trim());
							ediCtmEqVO.setCreDt				(arrResult[39].trim());
							ediCtmEqVO.setUpdUsrId			(arrResult[40].trim());
							ediCtmEqVO.setUpdDt				(arrResult[41].trim());
							ediCtmEqVO.setIbflag				(arrResult[42].trim());
							if (arrResult.length < 44)
							{
								ediCtmEqVO.setEtdDt    			("");
							}
							else
							{
								ediCtmEqVO.setEtdDt    			(arrResult[43].trim());
							}
							
							srtFlag = arrResult[42].trim();
							ediCtmEqVO.setBrgTpId(brgTpId);
							ediCtmEqVO.setDatMnplCd(srtFlag);
							
							flatFilePartnerLineVOs.add(ediCtmEqVO);
							int cnt = dbDao.selectEDIEppMvmt(ediCtmEqVO.getBkgNo());
							
							if("C".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDIEppMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIEppMvmt(ediCtmEqVO);
								}
								
							}else if("N".equals(srtFlag)) {
								if(cnt<=0){
									dbDao.insertEDIEppMvmt(ediCtmEqVO);
								}
								
							}else if("U".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDIEppMvmt(ediCtmEqVO);
								}else{
									dbDao.insertEDIEppMvmt(ediCtmEqVO);
								}
								
							}else if("D".equals(srtFlag)) {
								dbDao.deleteEDIEppMvmt(ediCtmEqVO);
								// Del column update 
							}
							
						}
					}
				}
				
				//////////////////////////////////////
				//vvd C,U,D
				if(bkgVvdCnt >= 0 ) {
					if(bkgVvdCnt >= 0) result = tempDomEdiFlatFile.split("BKG_VVD");
					brgTpId = "BKG_VVD";
					//[2015.05.28]소스품질 Modify
					if(null != result){
						fiatSize = result.length;
						
						for (int fiatRow2 = 1; fiatRow2 < fiatSize ; fiatRow2++ ) {	
							arrResult = result[fiatRow2].split("#\\|#");
							
							ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
							ediCtmEqVO.setBkgNo				(arrResult[1].trim());		
							ediCtmEqVO.setVslPrePstCd		(arrResult[2].trim());		
							ediCtmEqVO.setVslSeq				(arrResult[3].trim());					
							ediCtmEqVO.setSlanCd				(arrResult[4].trim());			
							ediCtmEqVO.setVslCd				(arrResult[5].trim());			
							if(arrResult[6].trim() != null && !"".equals(arrResult[6].trim())) {
								if(arrResult[6].trim().length() == 4) {
									ediCtmEqVO.setSkdVoyNo			(arrResult[6].trim());
								}else if(arrResult[6].trim().length() > 4) {
									ediCtmEqVO.setSkdVoyNo			(arrResult[6].trim().substring(0, 4));
								}else if(arrResult[6].trim().length() < 4){
									ediCtmEqVO.setSkdVoyNo			('0' + arrResult[6].trim());
								}
							}else{
								ediCtmEqVO.setSkdVoyNo			("");
							}
							
							ediCtmEqVO.setSkdDirCd			(arrResult[7].trim());		
							ediCtmEqVO.setOpCd				(arrResult[8].trim());		
							ediCtmEqVO.setPolClptIndSeq		(arrResult[9].trim());		
							ediCtmEqVO.setPolCd				(arrResult[10].trim());		
							ediCtmEqVO.setPolYdCd 			(arrResult[11].trim());	
							ediCtmEqVO.setPodClptIndSeq	(arrResult[12].trim());	
							ediCtmEqVO.setPodCd				(arrResult[13].trim());				
							ediCtmEqVO.setPodYdCd			(arrResult[14].trim());	
							ediCtmEqVO.setBkgTrspMzdCd	(arrResult[15].trim());	
							ediCtmEqVO.setCntrLodgFlg		(arrResult[16].trim());	
							ediCtmEqVO.setRevVvdFlg			(arrResult[17].trim());	
							ediCtmEqVO.setCreUsrId			(arrResult[18].trim());	
							ediCtmEqVO.setCreDt				(arrResult[19].trim());	
							ediCtmEqVO.setUpdUsrId			(arrResult[20].trim());	
							ediCtmEqVO.setUpdDt				(arrResult[21].trim());		
							
							srtFlag = arrResult[22].trim();
							ediCtmEqVO.setBrgTpId(brgTpId);
							ediCtmEqVO.setDatMnplCd(srtFlag);
							
							flatFilePartnerLineVOs.add(ediCtmEqVO);
							int cnt = dbDao.selectEDICtmBkgVvd(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getVslPrePstCd(), ediCtmEqVO.getVslSeq());
							
							if("C".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDICtmBkgVvd(ediCtmEqVO);
								}else{
									dbDao.insertEDICtmBkgVvd(ediCtmEqVO);
								}
								
							}else if("N".equals(srtFlag)) {
								if(cnt<=0){
									dbDao.insertEDICtmBkgVvd(ediCtmEqVO);
								}
								
							}else if("U".equals(srtFlag)) {
								if(cnt>0){
									dbDao.updateEDICtmBkgVvd(ediCtmEqVO);
								}else{
									dbDao.insertEDICtmBkgVvd(ediCtmEqVO);
								}
								
							}else if("D".equals(srtFlag)) {
								dbDao.deleteEDICtmBkgVvd(ediCtmEqVO);
								
							}
							
						}
					}
				}
						
						
						if(bkgContainerCnt >= 0 ) {
							if(bkgContainerCnt >= 0) result = tempDomEdiFlatFile.split("BKG_CONTAINER");
							brgTpId = "BKG_CONTAINER";
							//[2015.05.28]소스품질 Modify
							
							if(null != result){
								fiatSize = result.length;
								for (int fiatRow3 = 1; fiatRow3 < fiatSize ; fiatRow3++ ) {	
									arrResult = result[fiatRow3].split("#\\|#");
									
									ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
									ediCtmEqVO.setBkgNo				(arrResult[1].trim());
									ediCtmEqVO.setCntrNo				(arrResult[2].trim());
									ediCtmEqVO.setCntrTpszCd		(arrResult[3].trim());					
									ediCtmEqVO.setCnmvYr				(arrResult[4].trim());			
									ediCtmEqVO.setCnmvIdNo			(arrResult[5].trim());			
									ediCtmEqVO.setCnmvCycNo		(arrResult[6].trim());					
									ediCtmEqVO.setCnmvStsCd		(arrResult[7].trim());
									ediCtmEqVO.setRcvTermCd		(arrResult[8].trim());
									ediCtmEqVO.setDeTermCd			(arrResult[9].trim());
									ediCtmEqVO.setCntrVolQty			(arrResult[10].trim());	
									ediCtmEqVO.setDcgoFlg 			(arrResult[11].trim());
									ediCtmEqVO.setRcFlg				(arrResult[12].trim());
									ediCtmEqVO.setBbCgoFlg			(arrResult[13].trim());					
									ediCtmEqVO.setAwkCgoFlg			(arrResult[14].trim());
									ediCtmEqVO.setRdCgoFlg			(arrResult[15].trim());
									ediCtmEqVO.setHngrFlg				(arrResult[16].trim());
									ediCtmEqVO.setSocFlg				(arrResult[17].trim());
									ediCtmEqVO.setCnmvEvntDt		(arrResult[18].trim());
									ediCtmEqVO.setCntrCfmFlg			(arrResult[19].trim());
									//ediCtmEqVO.setcntrCNTR_DELT_FLG DcgoFlg				(arrResult[20].trim());
									ediCtmEqVO.setCreUsrId			(arrResult[21].trim());
									ediCtmEqVO.setCreDt				(arrResult[22].trim());
									ediCtmEqVO.setUpdUsrId			(arrResult[23].trim());
									ediCtmEqVO.setUpdDt				(arrResult[24].trim());
									
									srtFlag = arrResult[25].trim();
									ediCtmEqVO.setBrgTpId(brgTpId);
									ediCtmEqVO.setDatMnplCd(srtFlag);
									
									flatFilePartnerLineVOs.add(ediCtmEqVO);
									
									int cnt = dbDao.selectEDICtmBkgCntr(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getCntrNo());
									
									if("C".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgCntr(ediCtmEqVO);
										}else{
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
									}else if("N".equals(srtFlag)) {
										if(cnt<=0){
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
									}else if("U".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgCntr(ediCtmEqVO);
										}else{
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
									}else if("D".equals(srtFlag)) {
										dbDao.deleteEDICtmBkgCntr(ediCtmEqVO);
									}
									
									
								}
							}
						}
						
					
					result = null;
					if(eppCnt >= 0){
						if(eppCnt >= 0) result = tempDomEdiFlatFile.split("EPP");
						brgTpId = "EPP";
						
						if(null != result){
							fiatSize = result.length;
							for (int fiatRow = 1; fiatRow < fiatSize ; fiatRow++ ) {	
								arrResult = result[fiatRow].split("#\\|#");
													
								ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
								ediCtmEqVO.setBkgNo				(arrResult[1].trim());
								ediCtmEqVO.setBlNo					(arrResult[2].trim());
								ediCtmEqVO.setBlNoTp				(arrResult[3].trim());
								ediCtmEqVO.setBlTpCd				(arrResult[4].trim());			
								ediCtmEqVO.setBkgStsCd			(arrResult[5].trim());			
								ediCtmEqVO.setBkgCgoTpCd		(arrResult[6].trim());
								ediCtmEqVO.setSlanCd				(arrResult[7].trim());
								ediCtmEqVO.setSvcScpCd			(arrResult[8].trim());
								ediCtmEqVO.setVslCd				(arrResult[9].trim());
								
								if(arrResult[10].trim() != null && !"".equals(arrResult[10].trim())) {
									if(arrResult[10].trim().length() == 4) {							
										ediCtmEqVO.setSkdVoyNo			(arrResult[10].trim());
									}else if(arrResult[10].trim().length() > 4) {							
										ediCtmEqVO.setSkdVoyNo			(arrResult[10].trim().substring(0, 4));
									}else if(arrResult[10].trim().length() < 4)  {							
										ediCtmEqVO.setSkdVoyNo			('0' + arrResult[10].trim());
									}
								}else{
									ediCtmEqVO.setSkdVoyNo			("");
								}
								
								ediCtmEqVO.setSkdDirCd			(arrResult[11].trim());
								ediCtmEqVO.setRcvTermCd		(arrResult[12].trim());
								ediCtmEqVO.setDeTermCd			(arrResult[13].trim());
								ediCtmEqVO.setPorCd				(arrResult[14].trim());
								ediCtmEqVO.setPolCd				(arrResult[15].trim());
								ediCtmEqVO.setPodCd				(arrResult[16].trim());
								ediCtmEqVO.setDelCd				(arrResult[17].trim());
								ediCtmEqVO.setCmdtCd				(arrResult[18].trim());
								ediCtmEqVO.setRepCmdtCd		(arrResult[19].trim());
								ediCtmEqVO.setDcgoFlg				(arrResult[20].trim());
								ediCtmEqVO.setRcFlg				(arrResult[21].trim());
								ediCtmEqVO.setAwkCgoFlg			(arrResult[22].trim());
								ediCtmEqVO.setBbCgoFlg			(arrResult[23].trim());
								ediCtmEqVO.setRdCgoFlg			(arrResult[24].trim());
								ediCtmEqVO.setHngrFlg				(arrResult[25].trim());
								ediCtmEqVO.setRailBlkCd			(arrResult[26].trim());
								ediCtmEqVO.setPrctFlg				(arrResult[27].trim());
								ediCtmEqVO.setSpclHideFlg		(arrResult[28].trim());
								ediCtmEqVO.setSocFlg				(arrResult[29].trim());
								ediCtmEqVO.setSplitFlg				(arrResult[30].trim());
								ediCtmEqVO.setHcmtCmbFlg		(arrResult[31].trim());
								ediCtmEqVO.setBkgCreTpCd		(arrResult[32].trim());
								ediCtmEqVO.setToBkgNo			(arrResult[33].trim());
								ediCtmEqVO.setFmBkgNo			(arrResult[34].trim());
								ediCtmEqVO.setMtySplitAvalCd	(arrResult[35].trim());
								ediCtmEqVO.setPreRlyPortCd		(arrResult[36].trim());
								ediCtmEqVO.setPstRlyPortCd		(arrResult[37].trim());
								ediCtmEqVO.setCreUsrId			(arrResult[38].trim());
								ediCtmEqVO.setCreDt				(arrResult[39].trim());
								ediCtmEqVO.setUpdUsrId			(arrResult[40].trim());
								ediCtmEqVO.setUpdDt				(arrResult[41].trim());
								ediCtmEqVO.setIbflag				(arrResult[42].trim());
								if (arrResult.length < 44)
								{
									ediCtmEqVO.setEtdDt    			("");
								}
								else
								{
									ediCtmEqVO.setEtdDt    			(arrResult[43].trim());
								}
								
								srtFlag = arrResult[42].trim();
								ediCtmEqVO.setBrgTpId(brgTpId);
								ediCtmEqVO.setDatMnplCd(srtFlag);
								
								
								flatFilePartnerLineVOs.add(ediCtmEqVO);
								int cnt = dbDao.selectEDIEppMvmt(ediCtmEqVO.getBkgNo());
								
								if("C".equals(srtFlag)) {
									if(cnt>0){
										dbDao.updateEDIEppMvmt(ediCtmEqVO);
									}else{
										dbDao.insertEDIEppMvmt(ediCtmEqVO);
									}
									
								}else if("N".equals(srtFlag)) {
									if(cnt<=0){
										dbDao.insertEDIEppMvmt(ediCtmEqVO);
									}
									
								}else if("U".equals(srtFlag)) {
									if(cnt>0){
										dbDao.updateEDIEppMvmt(ediCtmEqVO);
									}else{
										dbDao.insertEDIEppMvmt(ediCtmEqVO);
									}
									
								}else if("D".equals(srtFlag)) {
									dbDao.deleteEDIEppMvmt(ediCtmEqVO);
									
								}
							}
						}
					}	
					
//					if("C".equals(srtFlag)) {
						//vvd, container 인서트
						if(eppVvdCnt >= 0) {
							if(eppVvdCnt >= 0) result = tempDomEdiFlatFile.split("EPP_VVD");	
							brgTpId = "EPP_VVD";
							
							//[2015.05.28]소스품질 Modify
							if(null != result){
								fiatSize = result.length;
								
								for (int fiatRow2 = 1; fiatRow2 < fiatSize ; fiatRow2++ ) {	
									arrResult = result[fiatRow2].split("#\\|#");
									
									ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
									ediCtmEqVO.setBkgNo				(arrResult[1].trim());		
									ediCtmEqVO.setVslPrePstCd		(arrResult[2].trim());		
									ediCtmEqVO.setVslSeq				(arrResult[3].trim());					
									ediCtmEqVO.setSlanCd				(arrResult[4].trim());			
									ediCtmEqVO.setVslCd				(arrResult[5].trim());			
									if(arrResult[6].trim() != null && !"".equals(arrResult[6].trim())) {
										if(arrResult[6].trim().length() == 4) {
											ediCtmEqVO.setSkdVoyNo			(arrResult[6].trim());
										}else if(arrResult[6].trim().length() > 4) {
											ediCtmEqVO.setSkdVoyNo			(arrResult[6].trim().substring(0, 4));
										}else if(arrResult[6].trim().length() < 4){
											ediCtmEqVO.setSkdVoyNo			('0' + arrResult[6].trim());
										}
									}else{
										ediCtmEqVO.setSkdVoyNo			("");
									}
									
									ediCtmEqVO.setSkdDirCd			(arrResult[7].trim());		
									ediCtmEqVO.setOpCd				(arrResult[8].trim());		
									ediCtmEqVO.setPolClptIndSeq		(arrResult[9].trim());		
									ediCtmEqVO.setPolCd				(arrResult[10].trim());		
									ediCtmEqVO.setPolYdCd 			(arrResult[11].trim());	
									ediCtmEqVO.setPodClptIndSeq	(arrResult[12].trim());	
									ediCtmEqVO.setPodCd				(arrResult[13].trim());				
									ediCtmEqVO.setPodYdCd			(arrResult[14].trim());	
									ediCtmEqVO.setBkgTrspMzdCd	(arrResult[15].trim());	
									ediCtmEqVO.setCntrLodgFlg		(arrResult[16].trim());	
									ediCtmEqVO.setRevVvdFlg			(arrResult[17].trim());	
									ediCtmEqVO.setCreUsrId			(arrResult[18].trim());	
									ediCtmEqVO.setCreDt				(arrResult[19].trim());	
									ediCtmEqVO.setUpdUsrId			(arrResult[20].trim());	
									ediCtmEqVO.setUpdDt				(arrResult[21].trim());

									srtFlag = arrResult[22].trim();
									ediCtmEqVO.setBrgTpId(brgTpId);
									ediCtmEqVO.setDatMnplCd(srtFlag);
									
									flatFilePartnerLineVOs.add(ediCtmEqVO);
									
									int cnt = dbDao.selectEDICtmBkgVvd(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getVslPrePstCd(), ediCtmEqVO.getVslSeq());
									
									if("C".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgVvd(ediCtmEqVO);	
										}else{
											dbDao.insertEDICtmBkgVvd(ediCtmEqVO);	
										}
										
									}else if("N".equals(srtFlag)) {
										if(cnt<=0){
											dbDao.insertEDICtmBkgVvd(ediCtmEqVO);	
										}
										
									}else if("U".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgVvd(ediCtmEqVO);	
										}else{
											dbDao.insertEDICtmBkgVvd(ediCtmEqVO);	
										}
										
									}else if("D".equals(srtFlag)) {
										dbDao.deleteEDICtmBkgVvd(ediCtmEqVO);
										
									}
								}
							}
						}
						
						if(eppContainerCnt >= 0) {
							if(eppContainerCnt >= 0) result = tempDomEdiFlatFile.split("EPP_CONTAINER");
							brgTpId = "EPP_CONTAINER";
							//[2015.05.28]소스품질 Modify
							
							if(null != result){
								fiatSize = result.length;
								for (int fiatRow3 = 1; fiatRow3 < fiatSize ; fiatRow3++ ) {	
									arrResult = result[fiatRow3].split("#\\|#");
									
									ediCtmEqVO = new SearchEDICtmEqMvmtListVO();
									ediCtmEqVO.setBkgNo				(arrResult[1].trim());
									ediCtmEqVO.setCntrNo				(arrResult[2].trim());
									ediCtmEqVO.setCntrTpszCd		(arrResult[3].trim());					
									ediCtmEqVO.setCnmvYr				(arrResult[4].trim());			
									ediCtmEqVO.setCnmvIdNo			(arrResult[5].trim());			
									ediCtmEqVO.setCnmvCycNo		(arrResult[6].trim());					
									ediCtmEqVO.setCnmvStsCd		(arrResult[7].trim());
									ediCtmEqVO.setRcvTermCd		(arrResult[8].trim());
									ediCtmEqVO.setDeTermCd			(arrResult[9].trim());
									ediCtmEqVO.setCntrVolQty			(arrResult[10].trim());	
									ediCtmEqVO.setDcgoFlg 			(arrResult[11].trim());
									ediCtmEqVO.setRcFlg				(arrResult[12].trim());
									ediCtmEqVO.setBbCgoFlg			(arrResult[13].trim());					
									ediCtmEqVO.setAwkCgoFlg			(arrResult[14].trim());
									ediCtmEqVO.setRdCgoFlg			(arrResult[15].trim());
									ediCtmEqVO.setHngrFlg				(arrResult[16].trim());
									ediCtmEqVO.setSocFlg				(arrResult[17].trim());
									ediCtmEqVO.setCnmvEvntDt		(arrResult[18].trim());
									ediCtmEqVO.setCntrCfmFlg			(arrResult[19].trim());
									//ediCtmEqVO.setcntrCNTR_DELT_FLG DcgoFlg				(arrResult[20].trim());
									ediCtmEqVO.setCreUsrId			(arrResult[21].trim());
									ediCtmEqVO.setCreDt				(arrResult[22].trim());
									ediCtmEqVO.setUpdUsrId			(arrResult[23].trim());
									ediCtmEqVO.setUpdDt				(arrResult[24].trim());
									
									srtFlag = arrResult[25].trim();
									ediCtmEqVO.setBrgTpId(brgTpId);
									ediCtmEqVO.setDatMnplCd(srtFlag);
									
									flatFilePartnerLineVOs.add(ediCtmEqVO);
									
									int cnt = dbDao.selectEDICtmBkgCntr(ediCtmEqVO.getBkgNo(), ediCtmEqVO.getCntrNo());
									
									if("C".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgCntr(ediCtmEqVO);
										}else{
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
										
									}else if("N".equals(srtFlag)) {
										if(cnt<=0){
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
									}else if("U".equals(srtFlag)) {
										if(cnt>0){
											dbDao.updateEDICtmBkgCntr(ediCtmEqVO);
										}else{
											String cntrSts = dbDao.checkContainerStatus(ediCtmEqVO.getCntrNo());
											if (cntrSts.equals("1")) {
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), "9999");
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											} else {
												String maxCycNo = dbDao.getMaxCnmvCycNo(ediCtmEqVO.getCntrNo());
												String opusBkgFlg = dbDao.getOPUSBkgFlg(ediCtmEqVO.getCntrNo(), maxCycNo);
												
												if ("".equals(opusBkgFlg) || opusBkgFlg == null) {
													dbDao.insertEDICtmBkgCntr(ediCtmEqVO);
													dbDao.updateVLVvd(ediCtmEqVO);
												} else {
													dbDao.insertEDICtmBkgCntrWithoutCycNo(ediCtmEqVO);
												}
											}
										}
										
									}else if("D".equals(srtFlag)) {
										dbDao.deleteEDICtmBkgCntr(ediCtmEqVO);
									}
									
								}
							}
						}
//					}
		
			}
		} catch (Exception e) {
			//e.printStackTrace();
			ediCtmEqVO.setBrgTpId(brgTpId);
			dbDao.insertEDICtmErrLog(ediCtmEqVO, e.toString());
			log.error("err " + e.toString(), e);
		}
		return flatFilePartnerLineVOs;
	}
	
	

	/**
	 * GATE NEW <br>
	 *  Container Movement EDI Batch<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	public FlatFileForGateNewVO gateNew( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		try {
			/* returning booking count after parsing tag value from MQ and saving data in flatFileVo */
 
			flatFileForGateNewVO.setBkgCount(flatFileForGateNewVO.getBkgCount() == null ? "" : flatFileForGateNewVO.getBkgCount().toString().trim());
			flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber0() == null ? "" : flatFileForGateNewVO.getBkgNumber0().toString().trim());

			if ( flatFileForGateNewVO.getBkgNumber() == null ) {
				String[] bkgNumber = new String[1];
				bkgNumber[0] = flatFileForGateNewVO.getBkgNumber0();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				if (flatFileForGateNewVO.getBkgNumber0().equals("")) {
					flatFileForGateNewVO.setBkgCount("0");
				} else {
					flatFileForGateNewVO.setBkgCount("1");
				}
			} else if ( !"".equals(flatFileForGateNewVO.getBkgNumber()[0]) ) {
				flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0].toString().trim());
			}
			flatFileForGateNewVO.setBlNo(flatFileForGateNewVO.getBlNo() == null ? "" : flatFileForGateNewVO.getBlNo().toString().trim());
			flatFileForGateNewVO.setCallSignNo(flatFileForGateNewVO.getCallSignNo() == null ? "" : flatFileForGateNewVO.getCallSignNo().toString().trim());
			flatFileForGateNewVO.setCarrierCode(flatFileForGateNewVO.getCarrierCode() == null ? "" : flatFileForGateNewVO.getCarrierCode().toString().trim());
			flatFileForGateNewVO.setCarrierCountry(flatFileForGateNewVO.getCarrierCountry() == null ? "" : flatFileForGateNewVO.getCarrierCountry().toString().trim());
			flatFileForGateNewVO.setChssCase(flatFileForGateNewVO.getChssCase() == null ? "" : flatFileForGateNewVO.getChssCase().toString().trim());
			flatFileForGateNewVO.setChssCode(flatFileForGateNewVO.getChssCode() == null ? "" : flatFileForGateNewVO.getChssCode().toString().trim());
			flatFileForGateNewVO.setMgsCase(flatFileForGateNewVO.getMgsCase() == null ? "" : flatFileForGateNewVO.getMgsCase().toString().trim());
			flatFileForGateNewVO.setCntCd(flatFileForGateNewVO.getCntCd() == null ? "" : flatFileForGateNewVO.getCntCd().toString().trim());
			flatFileForGateNewVO.setCntrNumber(flatFileForGateNewVO.getCntrNumber() == null ? "" : flatFileForGateNewVO.getCntrNumber().toString().trim());
			flatFileForGateNewVO.setCntrTpszCd(flatFileForGateNewVO.getCntrTpszCd() == null ? "" : flatFileForGateNewVO.getCntrTpszCd().toString().trim());
			flatFileForGateNewVO.setContStat(flatFileForGateNewVO.getContStat() == null ? "" : flatFileForGateNewVO.getContStat().toString().trim());
			flatFileForGateNewVO.setDelTag(flatFileForGateNewVO.getDelTag() == null ? "" : flatFileForGateNewVO.getDelTag().toString().trim());
			flatFileForGateNewVO.setDestLoc(flatFileForGateNewVO.getDestLoc() == null ? "" : flatFileForGateNewVO.getDestLoc().toString().trim());
			flatFileForGateNewVO.setDestNm(flatFileForGateNewVO.getDestNm() == null ? "" : flatFileForGateNewVO.getDestNm().toString().trim());
			flatFileForGateNewVO.setDestSte(flatFileForGateNewVO.getDestSte() == null ? "" : flatFileForGateNewVO.getDestSte().toString().trim());
			flatFileForGateNewVO.setDir(flatFileForGateNewVO.getDir() == null ? "" : flatFileForGateNewVO.getDir().toString().trim());
			flatFileForGateNewVO.setDmgFlag(flatFileForGateNewVO.getDmgFlag() == null ? "" : flatFileForGateNewVO.getDmgFlag().toString().trim());
			flatFileForGateNewVO.setDmgFlgDt(flatFileForGateNewVO.getDmgFlgDt() == null ? "" : flatFileForGateNewVO.getDmgFlgDt().toString().trim());
			flatFileForGateNewVO.setDmgUnflgDt(flatFileForGateNewVO.getDmgUnflgDt() == null ? "" : flatFileForGateNewVO.getDmgUnflgDt().toString().trim());
			flatFileForGateNewVO.setEdiBkgNo(flatFileForGateNewVO.getEdiBkgNo() == null ? "" : flatFileForGateNewVO.getEdiBkgNo().toString().trim());
			flatFileForGateNewVO.setEdiId(flatFileForGateNewVO.getEdiId() == null ? "" : flatFileForGateNewVO.getEdiId().toString().trim());
			flatFileForGateNewVO.setEventDate(flatFileForGateNewVO.getEventDate() == null ? "" : flatFileForGateNewVO.getEventDate().toString().trim());
			flatFileForGateNewVO.setEventYard(flatFileForGateNewVO.getEventYard() == null ? "" : flatFileForGateNewVO.getEventYard().toString().trim());
			flatFileForGateNewVO.setFfileRrefNo(flatFileForGateNewVO.getFfileRrefNo() == null ? "" : flatFileForGateNewVO.getFfileRrefNo().toString().trim());
			flatFileForGateNewVO.setFlatCarNbr(flatFileForGateNewVO.getFlatCarNbr() == null ? "" : flatFileForGateNewVO.getFlatCarNbr().toString().trim());
			flatFileForGateNewVO.setGateIo(flatFileForGateNewVO.getGateIo() == null ? "" : flatFileForGateNewVO.getGateIo().toString().trim());
			flatFileForGateNewVO.setHangerTag(flatFileForGateNewVO.getHangerTag() == null ? "" : flatFileForGateNewVO.getHangerTag().toString().trim());
			flatFileForGateNewVO.setLloydNo(flatFileForGateNewVO.getLloydNo() == null ? "" : flatFileForGateNewVO.getLloydNo().toString().trim());
			flatFileForGateNewVO.setLstmCd(flatFileForGateNewVO.getLstmCd() == null ? "" : flatFileForGateNewVO.getLstmCd().toString().trim());
			flatFileForGateNewVO.setMgSet(flatFileForGateNewVO.getMgSet() == null ? "" : flatFileForGateNewVO.getMgSet().toString().trim());
			flatFileForGateNewVO.setMsgId(flatFileForGateNewVO.getMsgId() == null ? "" : flatFileForGateNewVO.getMsgId().toString().trim());
			flatFileForGateNewVO.setMuidArea(flatFileForGateNewVO.getMuidArea() == null ? "" : flatFileForGateNewVO.getMuidArea().toString().trim());
			flatFileForGateNewVO.setMuidDt(flatFileForGateNewVO.getMuidDt() == null ? "" : flatFileForGateNewVO.getMuidDt().toString().trim());
			flatFileForGateNewVO.setMuidSeq(flatFileForGateNewVO.getMuidSeq() == null ? "" : flatFileForGateNewVO.getMuidSeq().toString().trim());
			flatFileForGateNewVO.setMvmtEdiStsTpFlg(flatFileForGateNewVO.getMvmtEdiStsTpFlg() == null ? "" : flatFileForGateNewVO.getMvmtEdiStsTpFlg().toString().trim());
			flatFileForGateNewVO.setMvmtStatus(flatFileForGateNewVO.getMvmtStatus() == null ? "" : flatFileForGateNewVO.getMvmtStatus().toString().trim());
			flatFileForGateNewVO.setOfficeYard(flatFileForGateNewVO.getOfficeYard() == null ? "" : flatFileForGateNewVO.getOfficeYard().toString().trim());
			flatFileForGateNewVO.setPickupNo(flatFileForGateNewVO.getPickupNo() == null ? "" : flatFileForGateNewVO.getPickupNo().toString().trim());
			flatFileForGateNewVO.setPod(flatFileForGateNewVO.getPod() == null ? "" : flatFileForGateNewVO.getPod().toString().trim());
			flatFileForGateNewVO.setPol(flatFileForGateNewVO.getPol() == null ? "" : flatFileForGateNewVO.getPol().toString().trim());
			flatFileForGateNewVO.setResultIndicator(flatFileForGateNewVO.getResultIndicator() == null ? "" : flatFileForGateNewVO.getResultIndicator().toString().trim());
			flatFileForGateNewVO.setResultMessage(flatFileForGateNewVO.getResultMessage() == null ? "" : flatFileForGateNewVO.getResultMessage().toString().trim());
			flatFileForGateNewVO.setSealNo(flatFileForGateNewVO.getSealNo() == null ? "" : flatFileForGateNewVO.getSealNo().toString().trim());
			flatFileForGateNewVO.setSightCd(flatFileForGateNewVO.getSightCd() == null ? "" : flatFileForGateNewVO.getSightCd().toString().trim());
			flatFileForGateNewVO.setSubstitution(flatFileForGateNewVO.getSubstitution() == null ? "" : flatFileForGateNewVO.getSubstitution().toString().trim());
			flatFileForGateNewVO.setTermId(flatFileForGateNewVO.getTermId() == null ? "" : flatFileForGateNewVO.getTermId().toString().trim());
			flatFileForGateNewVO.setTransMode(flatFileForGateNewVO.getTransMode() == null ? "" : flatFileForGateNewVO.getTransMode().toString().trim());
			flatFileForGateNewVO.setVessel(flatFileForGateNewVO.getVessel() == null ? "" : flatFileForGateNewVO.getVessel().toString().trim());
			flatFileForGateNewVO.setVndrSeq(flatFileForGateNewVO.getVndrSeq() == null ? "" : flatFileForGateNewVO.getVndrSeq().toString().trim());
			flatFileForGateNewVO.setVoyage(flatFileForGateNewVO.getVoyage() == null ? "" : flatFileForGateNewVO.getVoyage().toString().trim());
			flatFileForGateNewVO.setWayBillNo(flatFileForGateNewVO.getWayBillNo() == null ? "" : flatFileForGateNewVO.getWayBillNo().toString().trim());
			flatFileForGateNewVO.setCheckNassignData("");
			flatFileForGateNewVO.setNBkgNoFlg("N");
			flatFileForGateNewVO.setUserId(flatFileForGateNewVO.getUserId() == null ? "" : flatFileForGateNewVO.getUserId().toString().trim());
			flatFileForGateNewVO.setUserNm(flatFileForGateNewVO.getUserNm() == null ? "" : flatFileForGateNewVO.getUserNm().toString().trim());
			
			//EDI Flat File 추가에 따른 작업 [2014.09.01]
			flatFileForGateNewVO.setWoNo(flatFileForGateNewVO.getWoNo() == null ? "" : flatFileForGateNewVO.getWoNo().toString().trim());
			flatFileForGateNewVO.setEdiVvdCd(flatFileForGateNewVO.getEdiVvdCd() == null ? "" : flatFileForGateNewVO.getEdiVvdCd().toString().trim());
			flatFileForGateNewVO.setVslEngNm(flatFileForGateNewVO.getVslEngNm() == null ? "" : flatFileForGateNewVO.getVslEngNm().toString().trim());
			flatFileForGateNewVO.setTirNo(flatFileForGateNewVO.getTirNo() == null ? "" : flatFileForGateNewVO.getTirNo().toString().trim());
			flatFileForGateNewVO.setMtyPlnNo(flatFileForGateNewVO.getMtyPlnNo() == null ? "" : flatFileForGateNewVO.getMtyPlnNo().toString().trim());
			flatFileForGateNewVO.setMtyRepoNo(flatFileForGateNewVO.getMtyRepoNo() == null ? "" : flatFileForGateNewVO.getMtyRepoNo().toString().trim());
			flatFileForGateNewVO.setEdiMtyEqRepoRefNo(flatFileForGateNewVO.getEdiMtyEqRepoRefNo() == null ? "" : flatFileForGateNewVO.getEdiMtyEqRepoRefNo().toString().trim());
			flatFileForGateNewVO.setEdiCrrNo(flatFileForGateNewVO.getEdiCrrNo() == null ? "" : flatFileForGateNewVO.getEdiCrrNo().toString().trim());
			flatFileForGateNewVO.setTrspDocNo(flatFileForGateNewVO.getTrspDocNo() == null ? "" : flatFileForGateNewVO.getTrspDocNo().toString().trim());
			flatFileForGateNewVO.setVgmDocIdNo(flatFileForGateNewVO.getVgmDocIdNo() == null ? "" : flatFileForGateNewVO.getVgmDocIdNo().toString().trim());
			flatFileForGateNewVO.setVgmWgt(flatFileForGateNewVO.getVgmWgt() == null ? "" : flatFileForGateNewVO.getVgmWgt().toString().trim());
			flatFileForGateNewVO.setVgmEdiWgtUtCd(flatFileForGateNewVO.getVgmEdiWgtUtCd() == null ? "" : flatFileForGateNewVO.getVgmEdiWgtUtCd().toString().trim());
			flatFileForGateNewVO.setVgmDocTpCd(flatFileForGateNewVO.getVgmDocTpCd() == null ? "" : flatFileForGateNewVO.getVgmDocTpCd().toString().trim());
			flatFileForGateNewVO.setVgmDtTpCd(flatFileForGateNewVO.getVgmDtTpCd() == null ? "" : flatFileForGateNewVO.getVgmDtTpCd().toString().trim());
			flatFileForGateNewVO.setVgmHndlDt(flatFileForGateNewVO.getVgmHndlDt() == null ? "" : flatFileForGateNewVO.getVgmHndlDt().toString().trim());
			flatFileForGateNewVO.setVgmCustCntcTpCd(flatFileForGateNewVO.getVgmCustCntcTpCd() == null ? "" : flatFileForGateNewVO.getVgmCustCntcTpCd().toString().trim());
			flatFileForGateNewVO.setVgmCustCntcNm(flatFileForGateNewVO.getVgmCustCntcNm() == null ? "" : flatFileForGateNewVO.getVgmCustCntcNm().toString().trim());
			flatFileForGateNewVO.setVgmCustFaxNo(flatFileForGateNewVO.getVgmCustFaxNo() == null ? "" : flatFileForGateNewVO.getVgmCustFaxNo().toString().trim());
			flatFileForGateNewVO.setVgmCustEml(flatFileForGateNewVO.getVgmCustEml() == null ? "" : flatFileForGateNewVO.getVgmCustEml().toString().trim());
			flatFileForGateNewVO.setVgmCustPhnNo(flatFileForGateNewVO.getVgmCustPhnNo() == null ? "" : flatFileForGateNewVO.getVgmCustPhnNo().toString().trim());
			flatFileForGateNewVO.setVgmCustAddr(flatFileForGateNewVO.getVgmCustAddr() == null ? "" : flatFileForGateNewVO.getVgmCustAddr().toString().trim());
			flatFileForGateNewVO.setCntrStwgPsnCtnt(flatFileForGateNewVO.getCntrStwgPsnCtnt() == null ? "" : flatFileForGateNewVO.getCntrStwgPsnCtnt().toString().trim());

	//--------------------------------------------------------------------------------------------
		
//			int rtnCnt = dbDao.checkEdiMessage(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getGateIo());
//			
//			if(rtnCnt>0){
//				flatFileForGateNewVO.setResultMessage("The same message already exist!");
//				flatFileForGateNewVO.setResultIndicator("I");
//				
//				flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
//				
//				return flatFileForGateNewVO;
//			}
			
			boolean cntrCheck = true;
			
			if( ( (flatFileForGateNewVO.getBlNo()!=null || !flatFileForGateNewVO.getBlNo().equals("")) && flatFileForGateNewVO.getBlNo().length() == 10 )
			         && (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) ) {
				if (isNumeric(subStr(flatFileForGateNewVO.getBlNo(), 0, 2)) || (isAlpha(subStr(flatFileForGateNewVO.getBlNo(), 0, 1)) && isNumeric(subStr(flatFileForGateNewVO.getBlNo(), 1, 2)))) {
				    String  tmpBkg = searchBkgNoForOscar(flatFileForGateNewVO.getBlNo(), flatFileForGateNewVO.getCntrNumber());
				    String [] arrTmpBkg = new String[1];
				    arrTmpBkg[0] = tmpBkg;
				    flatFileForGateNewVO.setBkgNumber(arrTmpBkg);
				}
			}
			   
			if (flatFileForGateNewVO.getBkgNumber()[0].length() == 10) {	// 2015.01.12
				flatFileForGateNewVO.setOscaBkgFlg("Y");
			} else {
				flatFileForGateNewVO.setOscaBkgFlg("N");
			}
			
			if (flatFileForGateNewVO.getBkgNumber()[0].length() == 8 &&  
				    (flatFileForGateNewVO.getBkgNumber()[0].substring(0,1).equals("A") || flatFileForGateNewVO.getBkgNumber()[0].substring(0,1).equals("E")
				    || flatFileForGateNewVO.getBkgNumber()[0].substring(0,1).equals("L") || flatFileForGateNewVO.getBkgNumber()[0].substring(0,1).equals("N") )) {// 2015.06.19 
//			if (flatFileForGateNewVO.getBkgNumber()[0].length() == 8 &&  flatFileForGateNewVO.getBkgNumber()[0].substring(0,1).equals("A")) {// 2015.06.19
				String tempBkgNo = dbDao.searchBkgNoForOscar2(flatFileForGateNewVO.getBkgNumber0(), flatFileForGateNewVO.getCntrNumber());
				flatFileForGateNewVO.setBkgNumber(new String[]{tempBkgNo});
				flatFileForGateNewVO.setOscaBkgFlg("Y");
				 
			}else{
				flatFileForGateNewVO.setOscaBkgFlg("N");
				
			}
			
			
			/* Executing next logic according to msgId 	*/
			if ( flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") || flatFileForGateNewVO.getMsgId().equals("WEB") || flatFileForGateNewVO.getMsgId().equals("SPP") ) {

				if ( flatFileForGateNewVO.getMvmtStatus().equals("ER") || flatFileForGateNewVO.getMvmtStatus().equals("ZZ") || flatFileForGateNewVO.getMvmtStatus().equals("") ) {
					//EdiMsgVO.mvmt_edi_sts_tp_flg = "Y" ;	/* checking Movement Status in OPUS */
					flatFileForGateNewVO.setMvmtEdiStsTpFlg("Y");	 /* checking Movement Status in OPUS */
				} else {
					//EdiMsgVO.mvmt_edi_sts_tp_flg = "N" ;	/* receiving Movement Status from EDI */
					flatFileForGateNewVO.setMvmtEdiStsTpFlg("N");	 /* receiving Movement Status from EDI */
				}

				// mvmtStatus Not IN ("ER","","ZZ","AE","UV")
				if ( !flatFileForGateNewVO.getMvmtStatus().equals("ER") && (!flatFileForGateNewVO.getMvmtStatus().equals("")) && !flatFileForGateNewVO.getMvmtStatus().equals("ZZ") && !flatFileForGateNewVO.getMvmtStatus().equals("AE") && !flatFileForGateNewVO.getMvmtStatus().equals("UV")) {

					if ( (flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV"))
					  && (flatFileForGateNewVO.getMuidArea().equals("KOR") || flatFileForGateNewVO.getMuidArea().equals("SWA")) ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

					if ( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getMuidArea().equals("EUR") ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

					if ( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getMuidArea().equals("CHN") ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}
					
					if ( flatFileForGateNewVO.getMsgId().equals("SPP") ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

				}
				
				if( subStr(flatFileForGateNewVO.getEventYard(), 0, 7).equals("SGSINAO") ) {
					flatFileForGateNewVO.setContStat("M");
				}

				/* executing chassis logic in case of US "322" message and entered chassis no in cntrNumber  */
				/* if ( flatFileVo.getMsgId().equals("322") && (subStr(flatFileVo.getCntrNumber(), 9, 11).equals("") || (subStr(flatFileVo.getCntrNumber(), 3, 4).equals("Z") || subStr(flatFileVo.getCntrNumber(), 3, 4).equals("C"))) ) { */
				if ( flatFileForGateNewVO.getMsgId().equals("322")
				 && ((subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("Z") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("C") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("P") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("H") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("R"))) ) {

					flatFileForGateNewVO.setChssCase("Y");
					log.debug("\n\n===============================================================" +
							  "\n @decideChassisStatus(GateIo)" +
							  "\n===============================================================\n");
					flatFileForGateNewVO.setMvmtStatus(decideChassisStatus(flatFileForGateNewVO.getGateIo()));    /* Chassis Status */

					if ( flatFileForGateNewVO.getMvmtStatus().equals("BI") ) {
						flatFileForGateNewVO.setGateIo("I");

					} else if ( flatFileForGateNewVO.getMvmtStatus().equals("BO") ) {
						flatFileForGateNewVO.setGateIo("O");

					}
					log.debug("\n\n===============================================================" +
							  "\n @checkNassignData(322 & Z,C,P )" +
							  "\n===============================================================\n");
					if ( checkNassignData(flatFileForGateNewVO, cntrCheck) ) {
						flatFileForGateNewVO.setCheckNassignData("Y");
					} else {
						flatFileForGateNewVO.setCheckNassignData("N");
					}

					if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
						/* saving EDI Message */
						log.debug("\n\n===============================================================" +
								  "\n @insertEDIMessage" +
								  "\n===============================================================\n");
						flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
					}

					return flatFileForGateNewVO;
				} else if ( flatFileForGateNewVO.getMsgId().equals("322")
						 && ((subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("J") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("G") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("K"))) ) {

							flatFileForGateNewVO.setMgsCase("Y");
							log.debug("\n\n===============================================================" +
									  "\n @decideChassisStatus(GateIo)" +
									  "\n===============================================================\n");
							flatFileForGateNewVO.setMvmtStatus(decideChassisStatus(flatFileForGateNewVO.getGateIo()));    /* Chassis Status */

							if ( flatFileForGateNewVO.getMvmtStatus().equals("BI") ) {
								flatFileForGateNewVO.setGateIo("I");

							} else if ( flatFileForGateNewVO.getMvmtStatus().equals("BO") ) {
								flatFileForGateNewVO.setGateIo("O");

							}
							log.debug("\n\n===============================================================" +
									  "\n @checkNassignData(322 & J,G,K )" +
									  "\n===============================================================\n");
							if ( checkNassignData(flatFileForGateNewVO, cntrCheck) ) {
								flatFileForGateNewVO.setCheckNassignData("Y");
							} else {
								flatFileForGateNewVO.setCheckNassignData("N");
							}

							if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
								/* saving EDI Message */
								log.debug("\n\n===============================================================" +
										  "\n @insertEDIMessage" +
										  "\n===============================================================\n");
								flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
							}

							return flatFileForGateNewVO;
						}

				/* skipping in case of US "322" message and gate status = AR(Rail Arrival At Destination Intermodal Ramp) */
//				if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("UR") ) {
//					log.debug("\n\n=============================================================== [MsgId : 322 & GateIo : UR] Case = > Skip\n");
//					return flatFileForGateNewVO;
//				}
				
				/* executing logic for searching booking no in case of "322", "COD", "PRV" message */
				if ( flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") || flatFileForGateNewVO.getMsgId().equals("SPP") ) {

					flatFileForGateNewVO = adjustEqrRefNumber (flatFileForGateNewVO );
					
					cntrCheck = adjustCntr(flatFileForGateNewVO);
					
					log.debug("\n\n===============================================================" +
							  "\n @adjustBkgNumber" +
							  "\n===============================================================\n");
					boolean bkgCheck = adjustBkgNumber( flatFileForGateNewVO );
					log.debug("\n\n===============================================================" +
							  "\n bkgCheck = " + bkgCheck +
							  "\n===============================================================\n");

					/* executing logic for searching Sight code in case of "322", "COD", "PRV" message and Normal BKG */
					log.debug("\n\n===============================================================" +
							  "\n @adjustSightCode" +
							  "\n===============================================================\n");
					flatFileForGateNewVO = adjustSightCode( flatFileForGateNewVO, bkgCheck );
					
					//추가됨 20150618 
					 if(flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV"))
				     {
				      log.debug("\n\n===============================================================" +
				          "\n @adjustGateInOutCode" +
				          "\n===============================================================\n");
				      flatFileForGateNewVO = adjustGateInOutCode( flatFileForGateNewVO);
				           if ( bkgCheck && (flatFileForGateNewVO.getContStat().equals("F") || flatFileForGateNewVO.getContStat().equals("AH") || flatFileForGateNewVO.getContStat().equals("AC") )
				         && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) && !flatFileForGateNewVO.getSightCd().equals("X") ) {
				       log.debug("\n\n===============================================================" +
				           "\n changing gate io code @adjustSightCode" +
				           "\n===============================================================\n");
				       flatFileForGateNewVO = adjustSightCode( flatFileForGateNewVO, bkgCheck );
				      }
				     }					
				}

				/* executing confirming logic for Movement Status */
				if ( (flatFileForGateNewVO.getMvmtStatus().equals("ER") || flatFileForGateNewVO.getMvmtStatus().equals("")) && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) ) {
					if ( flatFileForGateNewVO.getMsgId().equals("322") ) {
						/* FlatFileVO.bkgNumber[0]가 Domestic Booking 이면 skip 한다. */
						/*String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
						if ( (domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
						  || domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI"))
						  && flatFileForGateNewVO.getMuidArea().equals("USA") ) {*/
						int domesticCheck = dbDao.searchDomsticBooking(flatFileForGateNewVO.getBkgNumber()[0]);
						if(domesticCheck != 0) {
							log.debug("\n\n===============================================================" +
									  "\n @decideDomesticStatus" +
									  "\n===============================================================\n");
							String domesticStatus = decideDomesticStatus( flatFileForGateNewVO );    /* Domestic_Decision */
							if (domesticStatus.equals("ER")) {
								flatFileForGateNewVO.setResultMessage("Domestic Status Check Error Return");
							}
							flatFileForGateNewVO.setMvmtStatus( domesticStatus );

						} else {						
							log.debug("\n\n===============================================================" +
									  "\n @decide322Status" +
									  "\n===============================================================\n");
							flatFileForGateNewVO.setMvmtStatus( decide322Status(flatFileForGateNewVO) );    /* N322_Decision */
						}

					} else {
						log.debug("\n\n===============================================================" +
								  "\n @decideOtherStatus" +
								  "\n===============================================================\n");
						flatFileForGateNewVO.setMvmtStatus( decideOtherStatus(flatFileForGateNewVO) );    /* ALL_Decision */

					}

				} else if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("UV") ) {
					flatFileForGateNewVO.setMvmtStatus("VD");

				} else if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("AE") ) {
					flatFileForGateNewVO.setMvmtStatus("VL");

				} else if( (flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("SPP")) && flatFileForGateNewVO.getGateIo().equals("UV") && flatFileForGateNewVO.getMvmtStatus().equals("ZZ") ) {
					
					flatFileForGateNewVO.setMvmtStatus("VD");

				} else if( (flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("SPP")) && flatFileForGateNewVO.getGateIo().equals("AE") && flatFileForGateNewVO.getMvmtStatus().equals("ZZ") ) {
					
					flatFileForGateNewVO.setMvmtStatus("VL");
				}

			/* handling data logic */
			/* ALL_Data_Update()  */
			/* if ( msgId in ("322", "COD", "PRV", "WEB")  ) */
			} else if ( flatFileForGateNewVO.getMsgId().equals("222") ) {
				flatFileForGateNewVO.setMvmtEdiStsTpFlg("N");
			}

			log.debug("\n\n===============================================================" +
					  "\n @checkNassignData(Other)" +
					  "\n===============================================================\n");
			if ( checkNassignData(flatFileForGateNewVO, cntrCheck) ) {
				flatFileForGateNewVO.setCheckNassignData("Y");
			} else {
				flatFileForGateNewVO.setCheckNassignData("N");
			}

			if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
				/* saving EDI Message */
				log.debug("\n\n===============================================================" +
						  "\n @insertEDIMessage" +
						  "\n===============================================================\n");
				flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
			}
			return flatFileForGateNewVO;

		} catch (EventException ex) {
			log.error("\n\n[BCImpl - gateNew] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - gateNew] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Container Movement Status <br>
	 *  decideOtherStatus for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return String
	 * @exception EventException
	 *
	 *  ALL_Decision (sub_sts.pc) + Get_MoveId_All(sub_sts1.pc) + Get_MoveIdTbl_All(sub_sts2.c)
	 **/
	private String decideOtherStatus( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		if ( flatFileForGateNewVO.getContStat().equals("E") )   {
			flatFileForGateNewVO.setContStat("M");

		} else if ( flatFileForGateNewVO.getContStat().equals("L") ) {
			flatFileForGateNewVO.setContStat("F");

		}

//		EXEC SQL
//		SELECT	NVL(MVMT_STS_CD,"ER")
//		INTO	:set_mvmtStatus
//		FROM	CTM_MVMT_STS_DCSN
//		WHERE	MVMT_EDI_MSG_TP_ID = "OTH"	/* 2010 Not 322 */
//		AND		MVMT_EDI_IO_BND_CD = DECODE(:FlatFileVO.cont_stat,	"M",	"I", :FlatFileVO.cont_stat)
//		AND		MVMT_EDI_CNTR_STS_CD = :FlatFileVO.cont_stat
//		AND		MVMT_EDI_GATE_IO_CD = :FlatFileVO.gateIo

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.decideStatus(OTH)" +
					  "\n===============================================================\n");
			returnValue = dbDao.decideStatus(flatFileForGateNewVO.getContStat(), flatFileForGateNewVO.getGateIo(), "OTH", flatFileForGateNewVO.getSightCd());
			log.debug("\n====================== dbDao.decideStatus(OTH) returnValue : " + returnValue + "\n");
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.decideStatus(OTH)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.decideStatus(OTH)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return "ER";
		}

		// checking returnValue for using switch statement
		int returnValueNum = 0;
		for(int k=0; k<10; k++) {
			if((k + "").equals(returnValue.trim() + "")) {
				returnValueNum = k;
				break;
			}
		}


		switch (returnValueNum) {
		case 1:
			if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {
				log.debug("\n\n===============================================================" +
						  "\n @@checkEDIBkgNo" +
						  "\n===============================================================\n");
				if ( checkEDIBkgNo( flatFileForGateNewVO.getEdiBkgNo(), flatFileForGateNewVO.getBlNo() ) ) {
					returnValue = "OP";

				} else {
					returnValue = "TN";
				}
			} else if ( subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 3).equals("REP") ) {
				log.debug("\n\n===============================================================" +
						  "\n @setEnTn" +
						  "\n===============================================================\n");
				returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), subStr(flatFileForGateNewVO.getBkgNumber()[0], 4, 8) ) ;

			} else {
				log.debug("\n\n===============================================================" +
						  "\n @checkBkgNo" +
						  "\n===============================================================\n");
				if ( checkBkgNo( flatFileForGateNewVO.getBkgNumber()[0] ) ) {
					returnValue = "OP";

				} else {
					returnValue = "TN";
				}
			}
			break;


		case 2:
			String delCode[] = new String[2];
			if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD					
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "");
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

				String[] blNo = new String[2];
				
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchBlNo(CntrNumber,BlNo)" +
							  "\n===============================================================\n");
					blNo = dbDao.searchBlNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBlNo());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( blNo[0] == null || blNo[0].equals("") ) {
					returnValue = "TN";    
					break;
				} else if ( blNo[0].equals("1") ) {
					String bkgNo = blNo[1];

//					EXEC SQL
//					SELECT	DEL_CD,		DE_TERM_CD
//					INTO	:destLoc,	:dlvTerm
//					FROM	BKG_BOOKING
//					WHERE	BL_NO		=  :flatFileVo.blNo[0];

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(BlNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode(bkgNo, "");
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( delCode[0] == null || delCode[0].equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				} else {
//					EXEC SQL
//					SELECT	DEL_CD,		DE_TERM_CD					
//					INTO	:destLoc,	:dlvTerm
//					FROM	BKG_BOOKING
//					WHERE	BL_NO		=	:flatFileVo.blNo[0];

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(BlNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( delCode[0] == null || delCode[0].equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of  Full, GateOut, Invalid BKG */
						break;
					}
				}

			} else {
				/* returnValue = "ER"; */
				returnValue = "TN"	;	/* setting TN in case of Full without booking information, GateOut(Inbound or Outbound) */
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setIdEnTnOther" +
					  "\n===============================================================\n");
			returnValue = setIdEnTnOther( flatFileForGateNewVO, delCode[0], delCode[1] );

			break;


		case 3:
			String destLoc = "";
			if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//					EXEC SQL
//					SELECT	POL_CD
//					INTO	:destLoc
//					FROM	BKG_BOOKING
//					WHERE	BKG_NO	=	:flatFileVo.bkgNumber[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				destLoc = getPolCodeOf(flatFileForGateNewVO.getBkgNumber()[0], "");

				if ( destLoc == null || destLoc.equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

				String[] blNo = new String[2];
				
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchBlNo(CntrNumber,BlNo)" +
							  "\n===============================================================\n");
					blNo = dbDao.searchBlNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBlNo());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( blNo[0] == null || blNo[0].equals("") ) {
					returnValue = "TN";    
					break;
				} else if (blNo[0].equals("1") ) {
					String bkgNo = blNo[1];
					
					log.debug("\n\n===============================================================" +
							  "\n @getPolCodeOf" +
							  "\n===============================================================\n");
					destLoc = getPolCodeOf(bkgNo, "");
	
					if ( destLoc == null || destLoc.equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				} else {
	//					EXEC SQL
	//					SELECT	POL_CD
	//					INTO	:destLoc
	//					FROM	BKG_BOOKING
	//					WHERE	BL_NO	=	:flatFileVo.blNo[0];
	
					log.debug("\n\n===============================================================" +
							  "\n @getPolCodeOf" +
							  "\n===============================================================\n");
					destLoc = getPolCodeOf("", flatFileForGateNewVO.getBlNo());
	
					if ( destLoc == null || destLoc.equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN"	;	/* setting TN in case of Full without booking information, GateOut(Inbound or Outbound) */
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn(flatFileForGateNewVO.getEventYard(), destLoc);

			break;

		}    /* switch( set_mvmtStatus ) */

		if ( returnValue.equals("") ) returnValue = "ER";

		return returnValue;

	}

	/**
	 * Container Movement Status <br>
	 *  decide322Status for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return String
	 * @exception EventException
	 *
	 * N322_Decision (322.pc) + Get_MoveId (sub_322.pc) + Get_MoveIdTbl (move_id.c)
	 **/
	private String decide322Status( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		if ( flatFileForGateNewVO.getContStat().equals("AL") || flatFileForGateNewVO.getContStat().equals("AA") || flatFileForGateNewVO.getContStat().equals("W") ) {	/* MT Status   */
			flatFileForGateNewVO.setContStat("M");

		} else if ( flatFileForGateNewVO.getContStat().equals("AC") ) {	/* Full Status */
			flatFileForGateNewVO.setContStat("F");

		}

		String returnValue = "";
		if ( flatFileForGateNewVO.getSightCd().equals("N") ) {	/* Import / Export */
			if ( flatFileForGateNewVO.getGateIo().equals("A") ||  flatFileForGateNewVO.getGateIo().equals("I") ) {
				returnValue = "TS";

			} else if ( flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("D") || flatFileForGateNewVO.getGateIo().equals("OA") ) {
				returnValue = "TN";

			} else {
				returnValue = "ER";

			}
			return	returnValue;
		}

//		EXEC SQL
//		SELECT	NVL(MVMT_STS_CD,"ER")
//		INTO	:set_mvmtStatus
//		FROM	CTM_MVMT_STS_DCSN
//		WHERE	MVMT_EDI_MSG_TP_ID		=	"322"
//		AND		MVMT_EDI_IO_BND_CD		=	DECODE( :flatFileVo.cont_stat,	"F ",	:flatFileVo.sightCd , "AH",	:flatFileVo.sightCd ,	"I" ) /* MTY 는 Inbound 기준 */
//		AND		MVMT_EDI_CNTR_STS_CD	=	:flatFileVo.cont_stat
//		AND		MVMT_EDI_GATE_IO_CD		=	:flatFileVo.gateIo;

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.decideStatus(322)" +
					  "\n===============================================================\n");
			returnValue = dbDao.decideStatus(flatFileForGateNewVO.getContStat(), flatFileForGateNewVO.getGateIo(), "322", flatFileForGateNewVO.getSightCd());
			log.debug("\n\n===============================================================" +
					  "\n returnValue : " + returnValue +
					  "\n===============================================================\n");
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.decideStatus(322)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.decideStatus(322)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return "ER";

		}

		// checking returnValue for using switch statement
		int returnValueNum = 0;
		for(int k=0; k<10; k++) {
			if((k + "").equals(returnValue.trim() + "")) {
				returnValueNum = k;
				break;
			}
		}


		String[] delCode = new String[2];
		switch (returnValueNum) {
		case 1:
			if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {
				log.debug("\n\n===============================================================" +
						  "\n @@checkEDIBkgNo" +
						  "\n===============================================================\n");
				if ( checkEDIBkgNo( flatFileForGateNewVO.getEdiBkgNo(), flatFileForGateNewVO.getBlNo() ) ) {
					returnValue = "OP";

				} else {
					
					if ( flatFileForGateNewVO.getContStat().equals("AB") ) {
						returnValue = "TN";

					} else if ( flatFileForGateNewVO.getDestLoc() != null && !flatFileForGateNewVO.getDestLoc().equals("") ) {
						log.debug("\n\n===============================================================" +
								  "\n @setEnTn" +
								  "\n===============================================================\n");
						returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getDestLoc() );

					} else {
						if ( flatFileForGateNewVO.getGateIo().equals("AL") ) {
							returnValue = "EN";

						} else {
							returnValue = "TN";
						}
					}
				}

			} else if ( subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 3).equals("REP") ) {
				if ( flatFileForGateNewVO.getContStat().equals("AB") ) {
					returnValue = "TN";

				} else {
					log.debug("\n\n===============================================================" +
							  "\n @setEnTn(REP)" +
							  "\n===============================================================\n");
					returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), "US" + subStr(flatFileForGateNewVO.getBkgNumber()[0], 4, 6) ) ;
				}

			} else {
				if ( flatFileForGateNewVO.getGateIo().equals("AL") ) {
					returnValue = "EN";

				} else {
					log.debug("\n\n===============================================================" +
							  "\n @checkBkgNo" +
							  "\n===============================================================\n");
					if ( checkBkgNo( flatFileForGateNewVO.getBkgNumber()[0] ) ) {
						returnValue = "OP";

					} else {
						returnValue = "TN"	;
					}
				}
			}
			break;


		case 2:
			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			if ( checkLocCd( flatFileForGateNewVO.getDestLoc() ) ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();
				delCode[1] = "";

			} else if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "");
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

				String[] blNo = new String[2];
				
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchBlNo(CntrNumber,BlNo)" +
							  "\n===============================================================\n");
					blNo = dbDao.searchBlNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBlNo());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( blNo[0] == null || blNo[0].equals("") ) {
					returnValue = "TN";    
					break;
				} else if ( blNo[0].equals("1") ) {
					String bkgNo = blNo[1];

//					EXEC SQL
//					SELECT	DEL_CD,		DE_TERM_CD
//					INTO	:destLoc,	:dlvTerm
//					FROM	BKG_BOOKING
//					WHERE	BL_NO		=  :flatFileVo.blNo[0];

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(BlNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode(bkgNo, "");
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( delCode[0] == null || delCode[0].equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				} else {
//					EXEC SQL
//					SELECT	DEL_CD,		DE_TERM_CD
//					INTO	:destLoc,	:dlvTerm
//					FROM	BKG_BOOKING
//					WHERE	BL_NO		=  :flatFileVo.blNo[0];

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(BlNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( delCode[0] == null || delCode[0].equals("") ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN";    /* setting TN in case of Full without booking information, GateOut(Inbound or Outbound) */
				break;
			}

			log.debug("\n\n===============================================================" +
					  "\n @setIdEnTn322" +
					  "\n===============================================================\n");
			returnValue = setIdEnTn322( flatFileForGateNewVO, delCode[0], delCode[1] ) ;
			break;


		case 3:
			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			if ( checkLocCd( flatFileForGateNewVO.getDestLoc() ) ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();

			} else if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !"".equals(flatFileForGateNewVO.getBkgNumber()[0])) && !"#".equals(subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1)) ) {

//				EXEC SQL
//				SELECT	POL_CD
//				INTO	:destLoc
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				delCode[0] = getPolCodeOf(flatFileForGateNewVO.getBkgNumber()[0], "");

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !"".equals(flatFileForGateNewVO.getBlNo())) && !"#".equals(subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1)) ) {

				String[] blNo = new String[2];
				
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchBlNo(CntrNumber,BlNo)" +
							  "\n===============================================================\n");
					blNo = dbDao.searchBlNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBlNo());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( blNo[0] == null || blNo[0].equals("") ) {
					returnValue = "TN";    
					break;
				} else if ( blNo[0].equals("1") ) {
					String bkgNo = blNo[1];
					
					log.debug("\n\n===============================================================" +
							  "\n @getPolCodeOf" +
							  "\n===============================================================\n");
					delCode[0] = getPolCodeOf(bkgNo, "");

					if ( delCode[0] == null || "".equals(delCode[0]) ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				} else {

//					EXEC SQL
//					SELECT	POL_CD
//					INTO	:destLoc
//					FROM	BKG_BOOKING
//					WHERE	BL_NO		= :flatFileVo.blNo[0];

					log.debug("\n\n===============================================================" +
							  "\n @getPolCodeOf" +
							  "\n===============================================================\n");
					delCode[0] = getPolCodeOf("", flatFileForGateNewVO.getBlNo());

					if ( delCode[0] == null || "".equals(delCode[0]) ) {
						/* returnValue = "ER"; */
						returnValue = "TN"	;	/* setting TN in case of Full, GateOut, Invalid BKG */
						break;
					}
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN";    
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), delCode[0] ) ;

			break;


		case 4:

			boolean checkLocCdYN = false;

			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			checkLocCdYN = checkLocCd( flatFileForGateNewVO.getDestLoc() );

			if ( flatFileForGateNewVO.getContStat().equals("M") &&  !checkLocCdYN && (flatFileForGateNewVO.getBkgNumber()[0].equals("") && subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#")) ) {
				returnValue = "EN";
				break;

			} else if ( checkLocCdYN ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();
				delCode[1] = "";

			} else if ( !flatFileForGateNewVO.getBkgNumber()[0].equals("") &&  !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "");
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					returnValue = "ER";
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

				String[] blNo = new String[2];
				
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchBlNo(CntrNumber,BlNo)" +
							  "\n===============================================================\n");
					blNo = dbDao.searchBlNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBlNo());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchBlNo(CntrNumber,BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( blNo[0] == null || blNo[0].equals("") ) {
					if ( flatFileForGateNewVO.getContStat().equals("M") ) {
						
						returnValue = "EN"	;

					} else {
						returnValue = "ER"	;

					}
					break;
				} else if ( blNo[0].equals("1") ) {
					String bkgNo = blNo[1];
					
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(bkgNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode(bkgNo, "");
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(bkgNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(bkgNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( delCode[0] == null || delCode[0].equals("") ) {
						returnValue = "ER";
						break;
					}
				} else {
				
	//				EXEC SQL
	//				SELECT	DEL_CD,		DE_TERM_CD
	//				INTO	:destLoc,	:dlvTerm
	//				FROM	BKG_BOOKING
	//				WHERE	BL_NO		=	:flatFileVo.blNo[0];
	
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.searchDelCode(BlNo)" +
								  "\n===============================================================\n");
						delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
	
					if ( delCode[0] == null || delCode[0].equals("") ) {
						returnValue = "ER";
						break;
					}
				}

			} else {

				if ( flatFileForGateNewVO.getContStat().equals("M") ) {
					
					returnValue = "EN"	;

				} else {
					returnValue = "ER"	;

				}
				break;
			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), delCode[0] ) ;

			break;

		}    /* switch( temp_mvmtStatus ) */

		if ( returnValue.equals("") ) returnValue = "ER";

		/* 2001.05.21 By SBKIM : AL -> EN Fix */
		if ( returnValue.equals("ER") && flatFileForGateNewVO.getGateIo().equals("AL") ) returnValue = "EN";

		return returnValue;

	}
	
	/**
	 * Container Movement Status 판정<br>
	 *  decideDomesticStatus for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return String
	 * @exception EventException
	 *
	 * N322_Decision (322.pc) + Get_MoveId (sub_322.pc) + Get_MoveIdTbl (move_id.c)
	 **/
	private String decideDomesticStatus( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		String returnValue = "";
		if ( !flatFileForGateNewVO.getLstmCd().equals("SH") && (subStr(flatFileForGateNewVO.getContStat(), 0, 1).equals("M") || subStr(flatFileForGateNewVO.getContStat(), 0, 1).equals("W")) ) {

    		if ( flatFileForGateNewVO.getGateIo().equals("RL") || flatFileForGateNewVO.getGateIo().equals("D") || flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("O")
    		  || flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("OA") || flatFileForGateNewVO.getGateIo().equals("AL") ) {

    			returnValue = "CP";

    		} else {
    			returnValue = "ER";

    		}
    	} else if ( flatFileForGateNewVO.getLstmCd().equals("SH") || (!flatFileForGateNewVO.getContStat().equals("M") && !flatFileForGateNewVO.getContStat().equals("W")) ) {

//    		EXEC SQL
//            SELECT  G1.SCC_CD,        G1.LCC_CD,
//                    G2.SCC_CD,        G2.LCC_CD
//            INTO    :del_scc,        :del_lcc,
//                    :event_scc,        :event_lcc
//            FROM    DOM_BOOKING        DB,
//                    MDM_LOCATION    L1,
//                    MDM_EQ_ORZ_CHT    G1,
//                    MDM_LOCATION    L2,
//                    MDM_EQ_ORZ_CHT    G2
//            WHERE    DB.DMST_BKG_NO = :FlatFileVO.bkgNumber
//            AND        L1.LOC_D = DB.DEST_RAIL_LOC_CD
//            AND        L1.SCC_CD = G1.SCC_CD
//            AND        L2.LOC_CD = :FlatFileVO.eventYard
//            AND        L2.SCC_CD = G2.SCC_CD;

    		String[] returnValues = new String[4];
    		String delScc = "";
    		String delLcc = "";
    		String eventScc = "";
    		String eventLcc = "";
    		try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getLccSccForGateNew" +
						  "\n===============================================================\n");
    			returnValues = dbDao.getLccSccForGateNew( flatFileForGateNewVO.getBkgNumber()[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 5) );
	    		delScc = returnValues[0];
	    		delLcc = returnValues[1];
	    		eventScc = returnValues[2];
	    		eventLcc = returnValues[3];
    		} catch (DAOException ex) {
    			log.error("[GATENEW : dbDao.getLccSccForGateNew] DAOerr : " + ex.toString(), ex);
    			throw new EventException(ex.getMessage(), ex);
    		} catch (Exception ex) {
    			log.error("[GATENEW : dbDao.getLccSccForGateNew] err : " + ex.toString(), ex);
    			throw new EventException(ex.getMessage(), ex);
    		}

    		if ( (delScc == null || delScc.equals("")) && (delLcc == null || delLcc.equals(""))
    		  && (eventScc == null || eventScc.equals("")) && (eventLcc == null || eventLcc.equals("")) ) {

    			returnValue = "ER";

    		} else {
    			if ( flatFileForGateNewVO.getGateIo().equals("RL") || flatFileForGateNewVO.getGateIo().equals("D")
  	    		  || flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("O")
  	    		  || flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("OA")
  	    		  || flatFileForGateNewVO.getGateIo().equals("AL") ) {

		  			if ( eventScc.equals(delScc) ) {
		  				returnValue = "CD";

		  			} else if ( eventLcc.equals(delLcc) ) {
		  				returnValue = "CT";

		  			} else {
		  				returnValue = "CE";

		  			}
    			} else if( !flatFileForGateNewVO.getGateIo().equals("") ) {
					if ( eventScc.equals(delScc) ) {
						returnValue = "CI";

					} else {
						returnValue = "CO";

					}
    			}
    		}
        }
		return returnValue;
	}	

	/**
	 * determining Container Movement Status 
	 * decideChassisStatus for GateNew
	 *
	 * @param String gateIo
	 * @return String
	 *
	 * chs_dbup.pc
	 **/
	private String decideChassisStatus( String gateIo ) {
		String mvmtStatus = "";
		if ( gateIo.equals("A") || gateIo.equals("I") || gateIo.equals("AR") || gateIo.equals("N") || gateIo.equals("UR") ) {
			mvmtStatus = "BI";

		} else if ( gateIo.equals("AL") || gateIo.equals("AO") || gateIo.equals("D") || gateIo.equals("OA")
				 || gateIo.equals("P") || gateIo.equals("RL") || gateIo.equals("O") ) {

			mvmtStatus = "BO";

		}
		return mvmtStatus;
	}

	/**
	 * setEnTn for GateNew<br>
	 *
	 * @param String eventLoc
	 * @param String destLoc
	 * @return String
	 * @exception EventException
	 **/
	private String setEnTn( String eventLoc, String destLoc ) throws EventException {
		String eventLccCode = getLccSccOf( "LCC_CD", eventLoc );
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		String returnValue = "";

		if ( (eventLccCode == null || eventLccCode.equals("")) || (destLccCode == null || destLccCode.equals("")) ) {
			returnValue = "ER";

		} else if ( !eventLccCode.equals(destLccCode) ) {
			returnValue = "EN";

		} else {
			returnValue = "TN";
		}
		return returnValue;
	}

	/**
	 * getLccSccOf for GateNew<br>
	 *
	 * @param String lccScc
	 * @param String locCode
	 * @return String
	 * @exception EventException
	 **/
	private String getLccSccOf( String lccScc, String locCode ) throws EventException {
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchLccScc(" + lccScc + ")" +
					  "\n===============================================================\n");
			return dbDao.searchLccScc(lccScc, subStr(locCode, 0, 5));
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchLccScc(lccScc)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchLccScc(lccScc)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * checkLocCd for GateNew<br>
	 *
	 * @param String locCode
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean checkLocCd( String locCode ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchCodeExist(LOC_CD)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchCodeExistForGateNew("MDM_LOCATION", "LOC_CD", locCode);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(LOC_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(LOC_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * getPolCodeOf for GateNew<br>
	 *
	 * @param String columnNm
	 * @param String codeValue
	 * @return String
	 * @exception EventException
	 **/
	private String getPolCodeOf( String bkgNo, String blNo) throws EventException {

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getPolByBkgNoOrBlNo(bkgNo, blNo)" +
					  "\n===============================================================\n");
			return dbDao.getPolByBkgNoOrBlNo(bkgNo, blNo);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(POL_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getCodeValue(POL_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * setIdEnTnOther for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param String destLoc
	 * @param String dlvTerm
	 * @return String
	 * @exception EventException
	 **/
	private String setIdEnTnOther( FlatFileForGateNewVO flatFileForGateNewVO, String destLoc, String dlvTerm ) throws EventException {

		log.info("\n\n===============================================================" +
				  "\n destSccCode(destSccCode)[EnTnOth]" +
				  "\n===============================================================\n");
		String destSccCode = getLccSccOf( "SCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventSccCode(eventSccCode)[EnTnOth]" +
				  "\n===============================================================\n");
		String eventSccCode = getLccSccOf( "SCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( (eventSccCode == null || eventSccCode.equals("")) || (destSccCode == null || destSccCode.equals("")) ) {
			return "ER";

		} else if ( destSccCode.equals(eventSccCode) ) {
			return "ID";
		}

		log.info("\n\n===============================================================" +
				  "\n destLccCode(eventYard)[EnTnOth]" +
				  "\n===============================================================\n");
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventLccCode(destLoc)[EnTnOth]" +
				  "\n===============================================================\n");
		String eventLccCode = getLccSccOf( "LCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( eventLccCode.equals(destLccCode) ) {
			return	"TN";

		} else {
			if ( "EUR".equals(flatFileForGateNewVO.getMuidArea()) && "D".equals(dlvTerm) && "F".equals(flatFileForGateNewVO.getContStat()) ) {
				return "ID";

			} else if ( "EUR".equals(flatFileForGateNewVO.getMuidArea()) && "Y".equals(dlvTerm) && "F".equals(flatFileForGateNewVO.getContStat()) ) {
				log.info("\n\n===============================================================" +
						  "\n @getFinalFacility" +
						  "\n===============================================================\n");
				if ( getFinalFacility(flatFileForGateNewVO) ) {		/* 2016 getFinalFacility !!!!!! */
					return "ID";

				} else {
					return "EN";

				}
			} else {
				return "EN";
			}
		}
	}

	/**
	 * setIdEnTn322 for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param String destLoc
	 * @param String dlvTerm
	 * @return String
	 * @exception EventException
	 **/
	private String setIdEnTn322( FlatFileForGateNewVO flatFileForGateNewVO, String destLoc, String dlvTerm ) throws EventException {

		log.info("\n\n===============================================================" +
				  "\n destSccCode(eventYard)[EnTn322]" +
				  "\n===============================================================\n");
		String destSccCode = getLccSccOf( "SCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventSccCode(destLoc)[EnTn322]" +
				  "\n===============================================================\n");
		String eventSccCode = getLccSccOf( "SCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( (eventSccCode == null || eventSccCode.equals("")) || (destSccCode == null || destSccCode.equals("")) ) {
			return "ER";

		}

		log.info("\n\n===============================================================" +
				  "\n destLccCode(eventYard)[EnTn322]" +
				  "\n===============================================================\n");
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventLccCode(destLoc)[EnTn322]" +
				  "\n===============================================================\n");
		String eventLccCode = getLccSccOf( "LCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( (eventLccCode == null || eventLccCode.equals("")) || (destLccCode == null || destLccCode.equals("")) ) {
			return "ER";

		} else if ( eventLccCode.equals(destLccCode) ) {
//			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && "D".equals(dlvTerm) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
//				if ( "US".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 2)) ) {
//					log.info("\n\n===============================================================" +
//							  "\n @getIRGsts" +
//							  "\n===============================================================\n");
//					if ( getIRGsts(flatFileForGateNewVO) ) {		/* 2010 Get_IRGsts !!!!!! 처리 ?? */
//						return "TN";
//
//					} else {
//						return "ID";
//
//					}
//				} else {
//					return "ID";
//
//				}
//			} else 
			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && ("Y".equals(dlvTerm)||"D".equals(dlvTerm)) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
				log.info("\n\n===============================================================" +
						  "\n @getFinalFacility" +
						  "\n===============================================================\n");
				if ( getFinalFacility(flatFileForGateNewVO) ) {		/* 2016 getFinalFacility !!!!!! */
					return "ID";

				} else {
					return "TN";

				}
			} else {
				return "TN";

			}
		} else {
//			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && "D".equals(dlvTerm) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
//				if ( "US".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 2)) ) {
//					log.debug("\n\n===============================================================" +
//							  "\n @getIRGsts" +
//							  "\n===============================================================\n");
//					if ( getIRGsts(flatFileForGateNewVO) ) {		/* 2010 Get_IRGsts !!!!!! 처리 ?? */
//						return "EN";
//
//					} else {
//						return "ID";
//
//					}
//				} else {
//					return "EN";
//
//				}
//			} else 
			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && ("Y".equals(dlvTerm)||"D".equals(dlvTerm)) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
				log.info("\n\n===============================================================" +
						  "\n @getFinalFacility" +
						  "\n===============================================================\n");
				if ( getFinalFacility(flatFileForGateNewVO) ) {		/* 2016 getFinalFacility !!!!!! */
					return "ID";

				} else {
					return "EN";

				}
			} else {
				return "EN";

			}
		}
	}

//	/**
//	 * getIRGsts for GateNew<br>
//	 *
//	 * @param FlatFileForGateNewVO flatFileForGateNewVO
//	 * @return Boolean
//	 * @exception EventException
//	 **/
//	private Boolean getIRGsts( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
//
//		String returnValue = "";
//		try {
//			log.debug("\n\n===============================================================" +
//					  "\n dbDao.searchTrspModCode(getIRGsts)" +
//					  "\n===============================================================\n");
//			returnValue = dbDao.searchTrspModCode( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard() );
//		} catch (DAOException ex) {
//			log.error("[GATENEW : dbDao.searchTrspModCode(getIRGsts)] DAOerr : " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("[GATENEW : dbDao.searchTrspModCode(getIRGsts)] err : " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(), ex);
//		}
//
//		if ( returnValue == null || returnValue.equals("") ) {
//			return false;
//		} else {
//			return true;
//		}
//
//	}

	/**
	 * getFinalFacility for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean getFinalFacility( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchFinalFacility(getFinalFacility)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchFinalFacility( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber() );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchFinalFacility(getFinalFacility)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchFinalFacility(getFinalFacility)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {					// ID at POD
			return true;
		} else {
			if (returnValue.equals(flatFileForGateNewVO.getEventYard())) { 		// ID at Last Facility
				return true;
			} else { 															// TN or EN at middle Facility
				return false;
			}
		}

	}

	/**
	 * checkBkgNo for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean checkBkgNo( String bkgNumber ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.checkBkgNoForGateNew(checkBkgNo)" +
					  "\n===============================================================\n");
			returnValue = dbDao.checkBkgNoForGateNew( bkgNumber );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.checkBkgNoForGateNew(checkBkgNo)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.checkBkgNoForGateNew(checkBkgNo)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * checkEDIBkgNo for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @param String blNumber
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean checkEDIBkgNo( String bkgNumber, String blNumber ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.checkEDIBkgNoForGateNew(checkEDIBkgNo, checkEDIBlNo)" +
					  "\n===============================================================\n");
			returnValue = dbDao.checkEDIBkgNoForGateNew( bkgNumber, blNumber );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.checkEDIBkgNoForGateNew(checkEDIBkgNo, checkEDIBlNo)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.checkEDIBkgNoForGateNew(checkEDIBkgNo, checkEDIBlNo)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			
			if (bkgNumber.length() >= 12) {
				if ( isAlpha(bkgNumber.substring(0,1)) && isAlpha(bkgNumber.substring(1,2)) && isAlpha(bkgNumber.substring(2,3)) && isAlpha(bkgNumber.substring(3,4)) && isNumeric(bkgNumber.substring(4,11)) ) {
					return true;
				} else if ( isAlpha(bkgNumber.substring(0,1)) && isAlpha(bkgNumber.substring(1,2)) && isAlpha(bkgNumber.substring(2,3)) && isNumeric(bkgNumber.substring(3,11)) ) {
					return true;
				} else if ( isAlpha(bkgNumber.substring(0,1)) && isAlpha(bkgNumber.substring(1,2)) && isNumeric(bkgNumber.substring(2,3)) && isAlpha(bkgNumber.substring(3,4)) && isAlpha(bkgNumber.substring(4,5)) && isNumeric(bkgNumber.substring(5,11)) ) {
					return true;
				}
			}
			if (blNumber.length() >= 12) {
				if ( isAlpha(blNumber.substring(0,1)) && isAlpha(blNumber.substring(1,2)) && isAlpha(blNumber.substring(2,3)) && isAlpha(blNumber.substring(3,4)) && isNumeric(blNumber.substring(4,11)) ) {
					return true;
				} else if ( isAlpha(blNumber.substring(0,1)) && isAlpha(blNumber.substring(1,2)) && isAlpha(blNumber.substring(2,3)) && isNumeric(blNumber.substring(3,11)) ) {
					return true;
				} else if ( isAlpha(blNumber.substring(0,1)) && isAlpha(blNumber.substring(1,2)) && isNumeric(blNumber.substring(2,3)) && isAlpha(blNumber.substring(3,4)) && isAlpha(blNumber.substring(4,5)) && isNumeric(blNumber.substring(5,11)) ) {
					return true;
				}
			} else if (blNumber.length() == 10) {
				if ( isAlpha(blNumber.substring(0,1)) && isAlpha(blNumber.substring(1,2)) && isNumeric(blNumber.substring(2,9)) ) {
					return true;
				}
			}

			return false;
		} else {
			return false;
		}

	}

	/**
	 * returning DateTime
	 *
	 * @param String eventDate
	 * @return String
	 */
/*
	private String convertDatetime( String eventDate ) {
		String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String returnValue = "";
		if ( eventDate == null || eventDate.equals("") ) {
			returnValue = DateTime.getFormatDate(new Date(), "ddMMyy HH:mm");
		} else  {
			if ( DateTime.isValid(eventDate, "yyyyMMddHHmmss") ) {
				returnValue = DateTime.getFormatDate(eventDate, "yyyyMMddHHmmss", "ddMMyy HH:mm");
			} else {
				returnValue = DateTime.getFormatDate(new Date(), "ddMMyy HH:mm");
			}
		}
		String strMonth = monthNames[Integer.parseInt(returnValue, 2, 4))-1];
		return returnValue, 0, 2) + strMonth + returnValue, 4);
	}
*/

	/**
	 * returning substring in case total character count < ruled character count
	 *
	 * @param String str
	 * @param int beginIndex
	 * @param int endIndex
	 * @return String
	 */
	private String subStr( String str, int beginIndex, int endIndex ) {
		str = ( (str == null || str.trim().equals("")) ? "" : str.trim() + "" );
		int firstIndex = str.length() < beginIndex ? str.length() : beginIndex;
		int lastIndex = str.length() < endIndex ? str.length() : endIndex;
		return str.substring(firstIndex, lastIndex);
	}

	/**
	 * checking English
	 *
	 * @param String str
	 * @return Boolean
	 */
	public Boolean isAlpha( String str ) {
		if ( str == null || str.equals("") ) return false;
		char ch = str.charAt(0);
		if ( (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) ) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checking numbers
	 *
	 * @param String str
	 * @return Boolean
	 */
	private Boolean isNumeric( String str ) {
		boolean returnValue = true;
		//[2015.05.28]소스품질 Modify
		if ( StringUtils.isEmpty(str)) returnValue = false;
		//if ( str == null || str.equals("") ) returnValue = false;
		for ( int i=0; i<str.length() ; i++ ) {
			char ch = str.charAt(i);
			if ( ch < 48 || ch > 59 ) {
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}

	/**
	 * checking ACIAC_DIV_CD 
	 *
	 * @param String cntrNumber
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException,Exception
	 */
	public String[] checkAciacDivCd(String cntrNumber, String bkgNumber) throws DAOException,Exception {
		String[] returnValues = new String[4];
		returnValues[0] = "";    // ResultMessage
		returnValues[1] = "";    // ResultIndicator
		returnValues[2] = "";    // checkAciacDivCdYN(Y/N)
		returnValues[3] = "";    // cntrTpszCd

//		EXEC SQL
//		SELECT  ACIAC_DIV_CD,	LSTM_CD,		CNTR_STS_CD,	CNTR_TPSZ_CD /*2010.02.17 By IHChang*/, CO_CRE_FLG /*2010.05.17 신조장비로직추가*/
//		FROM	MST_CONTAINER
//		INTO	:actStatus,		:leaseTerm,		:cntrStsCd,		:FlatFileVO.cntrTpszCd,		:comCreFlg
//		WHERE	CNTR_NO		=	FlatFileVO.cntrNumber

		String[] daoReturns = new String[5];
		String actStatus = "";
		String leaseTerm = "";
		String cntrStsCd = "";
		String cntrTpszCd = "";
		String comCreFlg = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getAciacDivCd" +
					  "\n===============================================================\n");
			daoReturns = dbDao.getAciacDivCd(cntrNumber);
			actStatus = daoReturns[0];
			leaseTerm = daoReturns[1];
			cntrStsCd = daoReturns[2];
			cntrTpszCd = daoReturns[3];
			comCreFlg = daoReturns[4];
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getAciacDivCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getAciacDivCd] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		if ( (actStatus == null || "".equals(actStatus)) &&
			 (leaseTerm == null || "".equals(leaseTerm)) &&
			 (cntrStsCd == null || "".equals(cntrStsCd)) &&
			 (cntrTpszCd == null || "".equals(cntrTpszCd)) &&
			 (comCreFlg == null || "".equals(comCreFlg)) ) {

			String daoReturn = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))" +
						  "\n===============================================================\n");
				daoReturn = dbDao.searchCodeExistForGateNew("MDM_ORGANIZATION", "SUBSTR(OFC_CD, 1, 3)", subStr(bkgNumber, 0, 3));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))] err : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}

			if (daoReturn != null && !"".equals(daoReturn)) {
				returnValues[0] = "Mis use in or SOC container";
				returnValues[1] = "N";

			} else {
				returnValues[0] = "Other company's container";
				returnValues[1] = "X";

			}
			returnValues[2] = "N";

		} else {
			returnValues[3] = cntrTpszCd;
			if ( "I".equals(actStatus) && "N".equals(comCreFlg) ) {   
				if ( "SH".equals(leaseTerm) ) {
					returnValues[0] = "Inactive container";
					returnValues[1] = "N";

				} else if ( "MU".equals(leaseTerm) ) {
					returnValues[0] = "Inactive container (Ignored)";
					returnValues[1] = "I";

				} else if ( "DON".equals(cntrStsCd) || "SCR".equals(cntrStsCd) || "SLD".equals(cntrStsCd) || "TLL".equals(cntrStsCd) ) {	// Total Loss TTL --> TLL by 2015/06/04 황미연
					returnValues[0] = "Inactive container (Ignored)";
					returnValues[1] = "I";

				} else {
					returnValues[0] = "Inactive container";
					returnValues[1] = "N";

				}
				returnValues[2] = "N";

			}
		}

		// returnValues[0] : ResultMessage
		// returnValues[1] : ResultIndicator
		// returnValues[2] : checkAciacDivCdYN(Y/N)
		// returnValues[3] : cntrTpszCd
		return returnValues;
	}

	/**
	 * getAmsLoc for GateNew<br>
	 *
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 **/
	private String getAmsLoc( String locCd ) throws EventException {

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(MDM_LOCATION)" +
					  "\n===============================================================\n");
			return dbDao.getCodeValueForGateNew("MDM_LOCATION", "LOC_AMS_PORT_CD", "LOC_CD", locCd);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(MDM_LOCATION)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getCodeValue(MDM_LOCATION)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * checkNassignData for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param boolean cntrCheck
	 * @return Boolean
	 * @exception EventException
	 *
	 * F_DB_CHECK
	 * @throws ParseException
	 **/
	private Boolean checkNassignData( FlatFileForGateNewVO flatFileForGateNewVO, boolean cntrCheck ) throws EventException {
		
		String[] returnValues = new String[2];
		String bkgCgoTpCd = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getBkgStsCd" +
					  "\n===============================================================\n");
			returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
			bkgCgoTpCd = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 2. Search BKG" +
					  "\n===============================================================" +
					  "\n BKG_CGO_TP = " + bkgCgoTpCd +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		if ("F".equals(bkgCgoTpCd)) {
			flatFileForGateNewVO.setMtyPlnNo("");
			flatFileForGateNewVO.setMtyRepoNo("");
		}
		
		String returnValue = "";
		if ( flatFileForGateNewVO.getMsgId().equals("322") ) {

			// POL
			if ( (flatFileForGateNewVO.getPol() != null && !flatFileForGateNewVO.getPol().equals("")) && isNumeric(flatFileForGateNewVO.getPol()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.pol
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.pol
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by POL)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getPol());


				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setPol(returnValue);
				}
			}

			// POD
			if ( (flatFileForGateNewVO.getPod() != null && !flatFileForGateNewVO.getPod().equals("")) && isNumeric(flatFileForGateNewVO.getPod()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.pod
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.pod
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by POD)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getPod());

				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setPod(returnValue);
				}
			}

			// DESTLOC
			if ( (flatFileForGateNewVO.getDestLoc() != null && !flatFileForGateNewVO.getDestLoc().equals("")) && isNumeric(flatFileForGateNewVO.getDestLoc()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.destLoc
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.destLoc
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by DESTLOC)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getDestLoc());

				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setDestLoc(returnValue);
				}
			}

		}

/* 2010 ___________________________________________________________> Logic From @ALL_Data_Update */

//		EXEC SQL
//		SELECT	TO_CHAR(TO_DATE(:FlatFileVO.eventDate,"YYYYMMDDHH24MI"),"DDMonrr HH24:MI")
//		INTO	:FlatFileVO.eventDate
//		FROM	DUAL;

		if ( !DateTime.isValid(flatFileForGateNewVO.getEventDate(), "yyyyMMddHHmm") ) {

			/* 20100316 By DSLee (S) */
			flatFileForGateNewVO.setResultMessage("Invalid Event date [" + flatFileForGateNewVO.getEventDate() + "]");
			flatFileForGateNewVO.setResultIndicator("N");
			return false;
			/* 20100316 By DSLee (E) */

/*
// (S) ==========================================
//			EXEC SQL
//			SELECT  GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, SUBSTR (:FlatFileVO.eventYard, 0, 5))
//			INTO	:FlatFileVO.eventDate
//			FROM    DUAL

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getLocalTime" +
						  "\n===============================================================\n");
				returnValue = dbDao.getLocalTime( flatFileForGateNewVO.getEventYard() );
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getLocalTime] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getLocalTime] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if (returnValue != null && !returnValue.equals("")) {
				flatFileForGateNewVO.setEventDate(returnValue);
			}
//  (E) ==========================================
*/
		}

		if ( !flatFileForGateNewVO.getCarrierCode().equals("") &&  (flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("SPP")) ) {

//			EXEC SQL
//			SELECT   VNDR_SEQ
//			INTO	 :FlatFileVO.vndr_seq
//			FROM	 MMD_VENDOR
//			WHERE	USA_EDI_CD = SUBSTR(:FlatFileVO.carrierCode,1,4)
//			AND	  DELT_FLG <> "Y";

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getVendorSeq" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setVndrSeq(dbDao.getVendorSeq(flatFileForGateNewVO.getCarrierCode()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getVendorSeq] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getVendorSeq] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}

//		EXEC SQL
//		SELECT	NVL(TRIM(:FlatFileVO.cntrNumber)," ")
//		INTO	:FlatFileVO.cntrNumber
//		FROM	DUAL;

		if ( flatFileForGateNewVO.getCntrNumber() == null ) flatFileForGateNewVO.setCntrNumber("");

		if ( ("Y".equals(flatFileForGateNewVO.getChssCase())||("Y".equals(flatFileForGateNewVO.getMgsCase()))) && (isAlpha(subStr(flatFileForGateNewVO.getCntrNumber(), 0, 1))) ) {    /* Bare Chassis Number Adjustment */

//			EXEC SQL
//			SELECT	SUBSTR(:FlatFileVO.cntrNumber,1,4) || LPAD( SUBSTR(:FlatFileVO.cntrNumber,5,10),6,'0')
//			INTO	:FlatFileVO.cntrNumber
//			FROM	DUAL

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.defineChssCode(flatFileVo.getCntrNumber)" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setCntrNumber(dbDao.defineChssCode(flatFileForGateNewVO.getCntrNumber()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.defineChssCode] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.defineChssCode] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}

		if( isAlpha(subStr(flatFileForGateNewVO.getChssCode(), 0, 1)) ) {    /* Chassis Number Adjustment */

//			EXEC SQL
//			SELECT	SUBSTR(:FlatFileVO.chssCode,1,4) || LPAD( SUBSTR(:FlatFileVO.chssCode,5,10),6,"0")
//			INTO	:FlatFileVO.chssCode);
//			FROM	DUAL;

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.defineChssCode(flatFileVo.getChssCode)" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setChssCode(dbDao.defineChssCode(flatFileForGateNewVO.getChssCode()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.defineChssCode] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.defineChssCode] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

//			EXEC SQL
//			SELECT	EQ_NO
//			FROM	CGM_EQUIPMENT
//			WHERE	EQ_NO = rtrim(:FlatFileVO.chssCode);

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCodeValue(EQ_NO)" +
						  "\n===============================================================\n");
				returnValue = dbDao.getCodeValueForGateNew("CGM_EQUIPMENT", "EQ_NO", "EQ_NO", flatFileForGateNewVO.getChssCode());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCodeValue(EQ_NO)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCodeValue(EQ_NO)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( returnValue == null || returnValue.equals("") ) {

//				EXEC SQL
//				SELECT	EQ_NO
//				INTO	:FlatFileVO.chssCode
//				FROM	CGM_EQUIPMENT
//				WHERE	(
//							CHSS_ALS_NO = rtrim(:FlatFileVO.chssCode)
//							OR
//							N2ND_CHSS_ALS_NO = rtrim(:FlatFileVO.chssCode)

				returnValue = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getEqNo" +
							  "\n===============================================================\n");
					returnValue = dbDao.getEqNo(flatFileForGateNewVO.getChssCode());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getEqNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getEqNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
			}
		}

		/* 2010 <_________________________________________________________Logic From @ALL_Data_Update */

		// if ( FlatFileVO.chssCase = FALSE )
		if ( !"Y".equals(flatFileForGateNewVO.getChssCase()) && !"Y".equals(flatFileForGateNewVO.getMgsCase()) ) {

			if (!cntrCheck) {
				flatFileForGateNewVO.setResultMessage("Container Number is not unique");
				flatFileForGateNewVO.setResultIndicator("N");
				return false;
			}
			
			String[] checkAciacDivCdYN = new String[3];
			try {
				log.debug("\n\n===============================================================" +
						  "\n @checkAciacDivCd" +
						  "\n===============================================================\n");
				checkAciacDivCdYN = checkAciacDivCd(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
				// checkAciacDivCdYN[0] : ResultMessage
				// checkAciacDivCdYN[1] : ResultIndicator
				// checkAciacDivCdYN[2] : checkAciacDivCdYN(Y/N)
				// checkAciacDivCdYN[3] : cntrTpszCd
			} catch (Exception ex) {
				log.error("[GATENEW : @checkAciacDivCd err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			flatFileForGateNewVO.setCntrTpszCd(checkAciacDivCdYN[3] == null ? "" : String.valueOf(checkAciacDivCdYN[3]).trim());

			if ( checkAciacDivCdYN[2].equals("N") ) {
				flatFileForGateNewVO.setResultMessage(checkAciacDivCdYN[0]);
				flatFileForGateNewVO.setResultIndicator(checkAciacDivCdYN[1]);
				return false;
			}

//			if ( flatFileForGateNewVO.getEventYard().equals("USSLCR2") || flatFileForGateNewVO.getEventYard().equals("USTYSR3") || flatFileForGateNewVO.getEventYard().equals("USJANKC") ) {
//				flatFileForGateNewVO.setResultMessage("Ignored Yard(USSLCR2, USTYSR3, USJANKC)");
//				flatFileForGateNewVO.setResultIndicator("X");
//				return false;
//			}

			if ( flatFileForGateNewVO.getSightCd().equals("X") ) {
				flatFileForGateNewVO.setResultMessage("Rehandling (X)");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

/*
 * 2014.10.21 Sung-Wook Kim 김성욱
 * 37830	AOC *CTM* - Data Validation Logic seeing "R" value in Yard Code
 * 37831	AOC *CTM* - Data Validation Logic review
 * 37832	 AOC *CTM* - Define Movement & Data Validation Logic - contents confirmation
		    if ( flatFileForGateNewVO.getTermId().equals("UP") && flatFileForGateNewVO.getGateIo().equals("A") ) {
 */
			/*if ( flatFileForGateNewVO.getGateIo().equals("A") ) {
				flatFileForGateNewVO.setResultMessage("City arrival status 'A' is ignored.");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}*/

			if ( flatFileForGateNewVO.getGateIo().equals("OB") ) {
				flatFileForGateNewVO.setResultMessage("Received of 404 bill of lading and created a shipment for the container");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			
			if ( flatFileForGateNewVO.getTransMode().equals("X") && flatFileForGateNewVO.getGateIo().equals("O") ) {
				flatFileForGateNewVO.setResultMessage("Mixed barge");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( flatFileForGateNewVO.getGateIo().equals("9") ) {
				flatFileForGateNewVO.setResultMessage("EQ STATUS CHANGE");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			
			if ( (flatFileForGateNewVO.getGateIo().equals("CB") || flatFileForGateNewVO.getGateIo().equals("CC") || flatFileForGateNewVO.getGateIo().equals("SA") || flatFileForGateNewVO.getGateIo().equals("SC")) ) {
				flatFileForGateNewVO.setResultMessage("Not for movement(CB,CC,SA,SC)");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}
			
			if (flatFileForGateNewVO.getGateIo().equals("0") || flatFileForGateNewVO.getGateIo().equals("1") || flatFileForGateNewVO.getGateIo().equals("ST")) {
					String damageFlg = "";
					
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getCntrDamageFlg(cntrNumber, EventDate, EventYard)" +
								  "\n===============================================================\n");
						damageFlg = dbDao.getCntrDamageFlg(flatFileForGateNewVO.getCntrNumber(),flatFileForGateNewVO.getEventDate(),flatFileForGateNewVO.getEventYard());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getCntrDamageFlg] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getCntrDamageFlg err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					
					if (damageFlg == null || "".equals(damageFlg)) {
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getCntrDamageFlg(cntrNumber, EventDate, ())" +
									  "\n===============================================================\n");
							damageFlg = dbDao.getCntrDamageFlg(flatFileForGateNewVO.getCntrNumber(),flatFileForGateNewVO.getEventDate(),"");
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getCntrDamageFlg] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getCntrDamageFlg err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						
						if (damageFlg == null || "".equals(damageFlg)) {
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getMSTDamageFlg(cntrNumber)" +
										  "\n===============================================================\n");
								damageFlg = dbDao.getMSTDamageFlg(flatFileForGateNewVO.getCntrNumber());
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getCntrDamageFlg] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getCntrDamageFlg err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}
						} else {
							if ( flatFileForGateNewVO.getDmgFlag().equals("Y")) {
								flatFileForGateNewVO.setDmgFlgDt(flatFileForGateNewVO.getEventDate());
							} else {
								flatFileForGateNewVO.setDmgUnflgDt(flatFileForGateNewVO.getEventDate());
							}
							
							flatFileForGateNewVO.setResultMessage("Container does not exist in "+flatFileForGateNewVO.getEventYard()+ " on "+flatFileForGateNewVO.getEventDate()+".");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}
					}
					
					if ( flatFileForGateNewVO.getDmgFlag().equals("Y")) {
						flatFileForGateNewVO.setDmgFlgDt(flatFileForGateNewVO.getEventDate());
						
						String mvmtSts = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.checkOPSts(cntrNumber)" +
									  "\n===============================================================\n");
							mvmtSts = dbDao.checkOPSts(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventDate());
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.checkOPSts] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.checkOPSts err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						
						if (mvmtSts.equals("OP")) {
							flatFileForGateNewVO.setResultMessage("This will update OP as damaged container. Re-save to continue.");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}
					} else {
						flatFileForGateNewVO.setDmgUnflgDt(flatFileForGateNewVO.getEventDate());
					}
					
					log.info("\n\n===============================================================" +
							  "\n DMG STATUS CHANGE" +  
							  "\n CTM AS-IS DMG_FLG : " + damageFlg + 
							  "\n CTM TO-BE DMG_FLG : " + flatFileForGateNewVO.getDmgFlag() + 
							  "\n CTM DMG_FLG_DT : " + flatFileForGateNewVO.getDmgFlgDt() + 
							  "\n CTM DMG_UNFLG_DT : " + flatFileForGateNewVO.getDmgUnflgDt() + 
							  "\n===============================================================\n");
					
					flatFileForGateNewVO.setResultMessage("STATUS CHANGE");
					flatFileForGateNewVO.setResultIndicator("X");
					return false;
			}

		
			if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
				Double eventTimeGap = null;

//				EXEC SQL
//				SELECT
//						TO_NUMBER
//						(
//							GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, DECODE (@[event_yard], '',
//								DECODE (@[muid_area], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''),
//									  SUBSTR(@[event_yard], 1, 5)) )
//							-
//							TO_DATE (@[event_date], 'YYYYMMDDHH24MISS')
//						)
//				INTO    :eventTimeGap
//				FROM    DUAL

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getEventTimeGap(muidArea, eventYard, eventDate)" +
							  "\n===============================================================\n");
					eventTimeGap = dbDao.getEventTimeGap(flatFileForGateNewVO.getMuidArea(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getEventTimeGap] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getEventTimeGap err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( eventTimeGap != null && (eventTimeGap < -10 || eventTimeGap > 10) ) {
					flatFileForGateNewVO.setResultMessage("Time gap between event and receiving date is over 10 days");
					flatFileForGateNewVO.setResultIndicator("X");
			        // flatFileForGateNewVO.setSightCd("X");  
					return false;
				}
			}
		}	/* if ( chassisCase = FALSE) */


//		EXEC SQL
//		SELECT	MVMT_STS_CD
//		FROM	MDM_MVMT_STS
//		WHERE	MVMT_STS_CD = :FlatFileVO.mvmtStatus;

		returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchCodeExist(MVMT_STS_CD)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchCodeExistForGateNew("MDM_MVMT_STS", "MVMT_STS_CD", flatFileForGateNewVO.getMvmtStatus());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(MVMT_STS_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(MVMT_STS_CD)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			if (flatFileForGateNewVO.getGateIo().equals("L") || flatFileForGateNewVO.getGateIo().equals("T") || flatFileForGateNewVO.getGateIo().equals("CA") || flatFileForGateNewVO.getGateIo().equals("RE") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 1(" + flatFileForGateNewVO.getGateIo() + ")");
				flatFileForGateNewVO.setResultIndicator("X");

			} else {
				flatFileForGateNewVO.setResultMessage("STS CHECK ERROR");
				flatFileForGateNewVO.setResultIndicator("N");

			}
			flatFileForGateNewVO.setMvmtStatus("ER");
			return false;
		}


//		EXEC SQL
//		SELECT	NVL(OFC_CD, '')
//		INTO	:FlatFileVO.yardOffice
//		FROM	MDM_YARD
//		WHERE	YD_CD = :FlatFileVO.eventYard
//		AND		DELT_FLG = "N";

		String officeYard = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getOfcCd(eventYard)" +
					  "\n===============================================================\n");
			officeYard = dbDao.getOfcCd(flatFileForGateNewVO.getEventYard());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getOfcCd(eventYard)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getOfcCd(eventYard)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( officeYard == null || officeYard.equals("") ) {
			flatFileForGateNewVO.setResultMessage("ORIGIN YARD CHECK ERROR");
			flatFileForGateNewVO.setResultIndicator("N");
			return false;

		} else {
			flatFileForGateNewVO.setOfficeYard(officeYard);

		}

/* 
 * 2014.10.21 Sung-Wook Kim 김성욱
 * 37830	AOC *CTM* - Data Validation Logic seeing "R" value in Yard Code
 * 37831	AOC *CTM* - Data Validation Logic review
 * 37832	 AOC *CTM* - Define Movement & Data Validation Logic - contents confirmation
 * 
  		if ( subStr(flatFileForGateNewVO.getEventYard(), 5, 6).equals("R") && flatFileForGateNewVO.getGateIo().equals("A") ) {
			if ( flatFileForGateNewVO.getMvmtStatus().equals("MT") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 2(" + flatFileForGateNewVO.getGateIo() + ", " + flatFileForGateNewVO.getMvmtStatus() + ")");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;

			}

			if ( flatFileForGateNewVO.getContStat().equals("F") && flatFileForGateNewVO.getTermId().equals("NS") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 3(" + flatFileForGateNewVO.getGateIo() + ", " + flatFileForGateNewVO.getMvmtStatus() + ")");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;

			}
		}
*/

		if ( flatFileForGateNewVO.getMvmtStatus().equals("OP") || flatFileForGateNewVO.getMvmtStatus().equals("OC") ) {
			String[] prevMvmt = null;
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.checkPrevMvmt" +
						  "\n===============================================================\n");
				prevMvmt = dbDao.checkPrevMvmt(flatFileForGateNewVO.getCntrNumber());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.checkPrevMvmt] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.checkPrevMvmt] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
			if (flatFileForGateNewVO.getMvmtStatus().equals("OP") || (flatFileForGateNewVO.getMvmtStatus().equals("OC") && (prevMvmt[0].equals("MT")||prevMvmt[0].equals("CM")) )) {	
				String dmgFlg = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getMSTDamageFlg" +
							  "\n===============================================================\n");
					dmgFlg = dbDao.getMSTDamageFlg(flatFileForGateNewVO.getCntrNumber());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getMSTDamageFlg] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getMSTDamageFlg] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				if ( dmgFlg.equals("Y") && !flatFileForGateNewVO.getDmgFlag().equals("N") ) {
					flatFileForGateNewVO.setResultMessage("This Container is Damaged. Re-save to continue.");
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}
			}			
			
			if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {
				if ( flatFileForGateNewVO.getSightCd().equals("N") ) {
					flatFileForGateNewVO.setResultMessage("THIS CONTAINER IS TS CONTAINER");
					flatFileForGateNewVO.setResultIndicator("Y");
					flatFileForGateNewVO.setMvmtStatus("TS");

				} else {
					flatFileForGateNewVO.setResultMessage("AFTER INPUT BKG NBR,RECOVERY THIS DATA");
					flatFileForGateNewVO.setResultIndicator("N");

				}
				return	false;
			}

			String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();    // flatFileForGateNewVO의 BkgNumber를 배열변수에 setting
			int combineCnt = 0;
			String[] bkgInforRetVal = null;
			for ( int p=0; p<bkgNumber.length ; p++ ) {
				if ( !bkgNumber[p].equals("") && bkgNumber[p] != null && !subStr(bkgNumber[p], 0, 1).equals("#") ) {

//					EXEC SQL														/* 2010.04.22 BKG_CRE_TP_CD Check By DSLee */
//					SELECT	BKG_STS_CD,		SPLIT_FLG,			TO_BKG_NO,		LENGTH(FlatFileVO.bkgNumber[p]),	BKG_CRE_TP_CD
//					INTO	:bkg_sts,		:bkg_split_ind,		:bkg_com_no,	:bkg_length,						:bkg_cre_tp_cd
//					FROM	BKG_BOOKING
//					WHERE	BKG_NO			=	TRIM( FlatFileVO.bkgNumber[p] )

					bkgInforRetVal = new String[4];
					String bkgStsCd = "";
					String bkgSplitInd = "";
					String bkgComNo = "";
					String bkgCreTpCd = "";
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getBookingInfo" +
								  "\n===============================================================\n");
						bkgInforRetVal = dbDao.getBookingInfo(bkgNumber[p]);
						bkgStsCd = (bkgInforRetVal[0] == null ? "" : bkgInforRetVal[0].trim());
						bkgSplitInd = (bkgInforRetVal[1] == null ? "" : bkgInforRetVal[1].trim());
						bkgComNo = (bkgInforRetVal[2] == null ? "" : bkgInforRetVal[2].trim());
						bkgCreTpCd = (bkgInforRetVal[4] == null ? "" : bkgInforRetVal[4].trim());;
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( bkgStsCd == null || bkgStsCd.equals("") ) {
					    /* 20100222 By DSLEE */
						if ( flatFileForGateNewVO.getMsgId().equals("222") && flatFileForGateNewVO.getMvmtStatus().equals("OP") ) {
							flatFileForGateNewVO.setMvmtStatus("TN");
							bkgNumber = new String[1]; /* BKG No Clear */
							bkgNumber[0] = "";
							flatFileForGateNewVO.setBkgNumber(bkgNumber);
							flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
							break;

						} else {
							flatFileForGateNewVO.setResultMessage("BKG NBR NOT EXIST");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}

/* 
					} else if ( sqlca.sqlcode != 0 && sqlca.sqlcode != SQLNULL ) {
	                    FlatFileVO.resultMessage = "BKG NBR CANCEL, SPLIT CHECK ERROR";
	                    FlatFileVO.resultIndicator = "N";
	                    return    false;
*/
					}

					
					if ( subStr(bkgStsCd, 0 , 1).equals("X") && subStr(bkgSplitInd, 0 , 1).equals("N") && bkgComNo.length() == 0 ) {
						flatFileForGateNewVO.setResultMessage("BKG NBR ALREADY CANCEL");
						flatFileForGateNewVO.setResultIndicator("N");
						return false;

					}

					if ( bkgComNo.length() > 1 ) {
						bkgNumber[p] = bkgComNo;
						combineCnt++;

						if ( combineCnt > 15 ) {
							flatFileForGateNewVO.setResultMessage("COMBINE BKG SELECT ERROR");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}

						p--;
						continue;
					}

					
					if ( subStr(bkgStsCd, 0 , 1).equals("S") || (subStr(bkgSplitInd, 0 , 1).equals("Y") && !subStr(bkgCreTpCd, 0 , 1).equals("S")) ) {

						
//						EXEC SQL
//						SELECT	BC.BKG_NO
//						INTO	:temp_bkgNumber
//						FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//						WHERE	BC.CNTR_NO	     =   :FlatFileVO.cntrNumber
//						AND     BC.BKG_NO        =	  BO.BKG_NO
//						AND		(
//									BO.FM_BKG_NO  =   :FlatFileVO.bkgNumber[0]
//									OR
//									BO.BKG_NO     =   :FlatFileVO.bkgNumber[0]
//								)
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'A'
//						AND     ROWNUM = 1

						String tempBkgNumber = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getBkgNo" +
									  "\n===============================================================\n");
							tempBkgNumber = dbDao.getBkgNo(flatFileForGateNewVO.getCntrNumber(), bkgNumber[p]);
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getBkgNo] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getBkgNo] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}

						String tempSts = "";
						try {
							tempSts = dbDao.searchBkgStatus(bkgNumber[p]);
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.searchBkgStatus(BKG_NO)] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.searchBkgStatus(BKG_NO)] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						
						if("X".equals(tempSts) || "S".equals(tempSts))
						{
							flatFileForGateNewVO.setResultMessage("Could not find split booking since container is not attached on split booking.");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}
						String tempStsBkg = bkgNumber[p];
						if(!"X".equals(tempSts) && !"S".equals(tempSts)){
							//bkgNumber[p]를 그대로 사용한다. 
							bkgNumber[p] =  tempStsBkg ;
						}else{
							bkgNumber[p] =  tempBkgNumber ;
						}
					} else if (bkgComNo.length() == 0 && !subStr(bkgStsCd, 0 , 1).equals("S") && !subStr(bkgSplitInd, 0 , 1).equals("Y") && flatFileForGateNewVO.getMvmtStatus().equals("OP")) {

						String fromBkgNumber = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getFromBkgNo" +
									  "\n===============================================================\n");
							fromBkgNumber = dbDao.getFromBkgNo(bkgNumber[p]);
							/***** For Log (S) *****/
							log.info("\n\n===============================================================" +
									  "\n 8. Search From BKG" +
									  "\n===============================================================" +
									  "\n BKG_NO = " + fromBkgNumber +
									  "\n===============================================================\n");
							/***** For Log (E) *****/
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getFromBkgNo] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getFromBkgNo] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						
						if ( fromBkgNumber == null || fromBkgNumber.equals("") ) {
							
//							SELECT	B.BKG_NO
//							INTO	:temp_bkgNumber
//							FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//							WHERE	BC.CNTR_NO			= :FlatFileVO.cntrNumber
//							AND		BC.CNMV_CYC_NO		=	9999
//							AND		SYSDATE - BC.CRE_DT < 60		/* 30 -> 60 (SBK1218) */
//							AND     BC.BKG_NO           = BO.BKG_NO
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//							AND		NVL(BO.BKG_STS_CD,' ') <> DECODE(:FlatFileVO.gateIo,'AE','A','UV','A','X')
//							AND     ROWNUM = 1

							String tempBkgNumber = "";
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getOldBkgNo" +
										  "\n===============================================================\n");
								tempBkgNumber = dbDao.getOldBkgNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo());
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 8. Search BKG by 9999" +
										  "\n===============================================================" +
										  "\n BKG_NO = " + tempBkgNumber +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getOldBkgNo] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getOldBkgNo] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if ( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
								
								if (!flatFileForGateNewVO.getEdiBkgNo().equals(tempBkgNumber)) {
									flatFileForGateNewVO.setResultMessage("Booking & EDI Booking unmatch error");
									flatFileForGateNewVO.setResultIndicator("N");
									return false;
								}

							} 
						}
					}
				} /* if ( FlatFileVO.getBkgNumber()[p][1] NOT IN ( " ", NULL, "#" ) */
			}	/* for ( ii = 0; ii < BkgCount : ii++ ) */

			flatFileForGateNewVO.setBkgNumber(bkgNumber);        
			flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);    // flatFileForGateNewVO의 BkgNumber0에 배열의 첫번째 value setting

		}	/* if ( FlatFileVO.cont_stat[1-2] IN ( "OP", "OC" ) ) */


		if (
				(
					(
						flatFileForGateNewVO.getMsgId().equals("COD") 
					 && (		flatFileForGateNewVO.getMuidArea().equals("EUR") 
							 || flatFileForGateNewVO.getMuidArea().equals("SWA") 
							 || flatFileForGateNewVO.getMuidArea().equals("CHN")
					   		 || flatFileForGateNewVO.getMuidArea().equals("") 
					   		 || flatFileForGateNewVO.getMuidArea().equals("KOR")
					   	)
					 )
				  || (flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getMuidArea().equals("USA"))
				  || flatFileForGateNewVO.getMsgId().equals("SPP")
				) 
			&& 	(flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV"))  
		   ) {

			/* ________________________________________________________________________ Variables Initialize */
			boolean bkgExist = false;
			boolean callSignExist = false;
			boolean callSignVSLFound = false;
			boolean vvdFound = false;

			/* ____________________________________________________________________________ BKG No Checking */
//			EXEC SQL
//			SELECT	 "A"
//			FROM	BKG_BOOKING BK
//			WHERE	BK.BKG_NO =	 :FlatFileVO.bkgNumber[0];

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
//						  "\n dbDao.searchCodeExist(BKG_NO:BKG_BOOKING)" +
						  "\n dbDao.getBookingInfo(bkgNo)" +
						  "\n===============================================================\n");
//				String tableName = "BKG_BOOKING";
//				if(flatFileForGateNewVO.getOscaBkgFlg().equalsIgnoreCase("Y"))
//					tableName = "CTM_BOOKING";
//				returnValue = dbDao.searchCodeExistForGateNew(tableName, "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0]);
				returnValue = dbDao.getBookingInfo(flatFileForGateNewVO.getBkgNumber()[0])[0];
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getBookingInfo(BKG_NO)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getBookingInfo(BKG_NO)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( returnValue != null && !returnValue.equals("") ) bkgExist = true;

			/* __________________________________________________________________________ Callsign Checking */

			Integer callsignLength = 0;
			if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
				callsignLength = flatFileForGateNewVO.getCallSignNo().length();
				if (callsignLength == 0) {
					callsignLength = flatFileForGateNewVO.getLloydNo().length();
				}
			} else {
				callsignLength = flatFileForGateNewVO.getLloydNo().length();
				if (callsignLength == 0) {
					callsignLength = flatFileForGateNewVO.getCallSignNo().length();
				}
			}
			/* __________________________________________________________________ Callsign VVD Checking */

			String[] csnVslCd = new String[3];	 
			String[] OscaBkgFlg = new String[1];
			if ( callsignLength > 0 ) {
				callSignExist = true;

//					EXEC SQL
//					SELECT  MAX(BC.CNMV_CYC_NO)
//					INTO	:max_bkg_cycle
//					FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//					WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//					AND		BC.BKG_NO = BO.BKG_NO
//					AND		NVL(BO.BKG_STS_CD," ") <> "X"
//					AND		NVL(BO.BKG_STS_Cd," ") <> "S";

				String maxBkgCycle = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getMaxCnmvCycNo" +
							  "\n===============================================================\n");
					maxBkgCycle = dbDao.getMaxCnmvCycNo( flatFileForGateNewVO.getCntrNumber() );
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 9. Search BKG by Last Cycle" +
							  "\n===============================================================" +
							  "\n LAST_CYCLE = " + maxBkgCycle +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if (maxBkgCycle != null && !maxBkgCycle.equals("")) {

//					EXEC SQL
//					SELECT  1
//					INTO	:osca_bkg_flg
//					FROM	CTM_BKG_CNTR
//					WHERE	CNTR_NO = :FlatFileVO.cntrNumber
//					AND		CNMV_CYC_NO = maxBkgCycle;

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getOscaBkgFlg" +
								  "\n===============================================================\n");
						OscaBkgFlg = dbDao.getOscaBkgFlg( flatFileForGateNewVO.getCntrNumber(), maxBkgCycle );
						/***** For Log (S) *****/
						log.info("\n\n===============================================================" +
								  "\n 9. Search OscaBKG by Max Cycle" +
								  "\n===============================================================" +
								  "\n Osca_Bkg_Flg = " + OscaBkgFlg[0] +
								  "\n===============================================================\n");
						/***** For Log (E) *****/
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getOscaBkgFlg] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getOscaBkgFlg] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					
					if ( (OscaBkgFlg[0] == null || OscaBkgFlg[0].equals("")) || (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) ) {
			    	
						if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
						     try {
						      log.debug("\n\n===============================================================" +
						          "\n dbDao.getVslCd(CallSignNo)" +
						          "\n===============================================================\n");
						      csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), flatFileForGateNewVO.getLloydNo());
						     } catch (DAOException ex) {
						      log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] DAOerr : " + ex.toString(), ex);
						      throw new EventException(ex.getMessage(), ex);
						     } catch (Exception ex) {
						      log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] err : " + ex.toString(), ex);
						      throw new EventException(ex.getMessage(), ex);
						     }
					    } else {
							 try {
								  log.debug("\n\n===============================================================" +
								  "\n dbDao.getVslCd(LloydNo)" +
								  "\n===============================================================\n");
								  csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), flatFileForGateNewVO.getLloydNo());
							 } catch (DAOException ex) {
								  log.error("[GATENEW : dbDao.getVslCd(LloydNo)] DAOerr : " + ex.toString(), ex);
								  throw new EventException(ex.getMessage(), ex);
							 } catch (Exception ex) {
								  log.error("[GATENEW : dbDao.getVslCd(LloydNo)] err : " + ex.toString(), ex);
								  throw new EventException(ex.getMessage(), ex);
							 }
					    }
					} else {
						if ( !bkgExist ) {
							flatFileForGateNewVO.setResultMessage("Could not find correct BKG No");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}
					}
			    } else {
			    	if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
					     try {
					      log.debug("\n\n===============================================================" +
					          "\n dbDao.getVslCd(CallSignNo)" +
					          "\n===============================================================\n");
					      csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), flatFileForGateNewVO.getLloydNo());
					     } catch (DAOException ex) {
					      log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] DAOerr : " + ex.toString(), ex);
					      throw new EventException(ex.getMessage(), ex);
					     } catch (Exception ex) {
					      log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] err : " + ex.toString(), ex);
					      throw new EventException(ex.getMessage(), ex);
					     }
				    } else {
						 try {
							  log.debug("\n\n===============================================================" +
							  "\n dbDao.getVslCd(LloydNo)" +
							  "\n===============================================================\n");
							  csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), flatFileForGateNewVO.getLloydNo());
						 } catch (DAOException ex) {
							  log.error("[GATENEW : dbDao.getVslCd(LloydNo)] DAOerr : " + ex.toString(), ex);
							  throw new EventException(ex.getMessage(), ex);
						 } catch (Exception ex) {
							  log.error("[GATENEW : dbDao.getVslCd(LloydNo)] err : " + ex.toString(), ex);
							  throw new EventException(ex.getMessage(), ex);
						 }
				    }
			    }
			    
			    if ( (csnVslCd[0] != null && !csnVslCd[0].equals(""))
			      || (csnVslCd[1] != null && !csnVslCd[1].equals(""))
			      || (csnVslCd[2] != null && !csnVslCd[2].equals("")) ) {
			    	callSignVSLFound = true;
			    }
			}

			String[] vvdCode = null;

			if ( !bkgExist ) {

				if ( !callSignExist ) {
					if (!adjustVVD( flatFileForGateNewVO )) {
						if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
							flatFileForGateNewVO.setResultMessage("CallSign is Missing. Request Terminal to send CallSign");
						}else{
							flatFileForGateNewVO.setResultMessage("LloydNo is Missing. Request Terminal to send LloydNo");
						}
					} else {
						vvdFound = true ;
					}

				}else {	/* ( callsignExist == TRUE ) */

					if ( !callSignVSLFound ) {
						if (!adjustVVD( flatFileForGateNewVO )) {
							flatFileForGateNewVO.setResultMessage("No Matched VSL Code against CallSign/Lloyd Code. Update CallSign/Lloyd Code on VSL Info");
						} else {
							vvdFound = true ;
						}

					} else {	/* ( callSignVVDFound == TRUE ) */

						flatFileForGateNewVO.setResultMessage("Could not find correct BKG No");    /* 20091221 SBKIM */

						vvdCode = new String[3];
						for ( int ii=0; ii<3 && csnVslCd[ii] != null && !csnVslCd[ii].equals(""); ii++ ) {

							try {
								if( flatFileForGateNewVO.getGateIo().equals("AE") ) {    /* -------------------------------------------- (VL) Case */

//									/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 */
//									EXEC SQL
//									SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//									INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//									FROM	(
//												SELECT	/*+ ORDERED
//																INDEX_DESC( VPS1 XAK2VSL_PORT_SKD_ETD   )
//																INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//														ROUND(ABS(VPS1.VPS_ETD_DT-TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//														SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//												FROM	VSK_VSL_PORT_SKD VPS1,  VSK_VSL_SKD SKD
//												WHERE	VPS1.VPS_ETD_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//												AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//												AND		VPS1.VPS_PORT_CD         =	:FlatFileVO.eventYard
//												AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//												AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//												AND		SKD.SKD_STS_CD	        =	'ACT'
//												AND		SKD.VSL_CD              =	VPS1.VSL_CD
//												AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//												AND		SKD.SKD_DIR_CD          =	VPS1.SKD_DIR_CD
//												ORDER BY DIF ASC SKD.SKD_VOY_NO DESC  /* VL : using bigger Voyage No - 2009.09.03 */
//											) S
//									WHERE	ROWNUM  = 1;

									log.debug("\n\n===============================================================" +
											  "\n dbDao.getVvdCdByVL" +
											  "\n===============================================================\n");
									vvdCode = dbDao.getVvdCdByVL(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);

								} else {									     /* ------------------------------------------- (VD) Case */

//									/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 *
//									EXEC SQL
//									SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//									INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//									FROM	(
//												SELECT /*+ ORDERED
//																INDEX_DESC( VPS1 XAK1VSL_PORT_SKD_ETB   )
//																INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//														ROUND(ABS(VPS1.VPS_ETB_DT-TO_DATE(:eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//														SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//												FROM	VSK_VSL_PORT_SKD VPS1, VSK_VSL_SKD SKD
//												WHERE	VPS1.VPS_ETB_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//												AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//												AND		VPS1.VPS_PORT_CD		=	:FlatFileVO.eventYard
//												AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//												AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//												AND		SKD.SKD_STS_CD			=	'ACT'
//												AND		SKD.VSL_CD				=	VPS1.VSL_CD
//												AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//												AND		SKD.SKD_DIR_CD			=	VPS1.SKD_DIR_CD
//												ORDER BY DIF ASC SKD.SKD_VOY_NO ASC	/* VD : using smaller Voyage No - 2009.09.03 */
//											) S
//									WHERE	ROWNUM  = 1;

									log.debug("\n\n===============================================================" +
											  "\n dbDao.getVvdCdByVD" +
											  "\n===============================================================\n");
									vvdCode = dbDao.getVvdCdByVD(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);
								}
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getVvdCd] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getVvdCd] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if ( (vvdCode[0] != null && !vvdCode[0].equals("")) || (vvdCode[1] != null && !vvdCode[1].equals("")) || (vvdCode[2] != null && !vvdCode[2].equals("")) ) {
								flatFileForGateNewVO.setVessel(vvdCode[0]);
								flatFileForGateNewVO.setVoyage(vvdCode[1]);
								flatFileForGateNewVO.setDir(vvdCode[2]);
								vvdFound = true ;
								break;
							} else {
								vvdFound = adjustVVD( flatFileForGateNewVO );
							}
						}    /* for ( ii = 0; ii < 3 && csn_vsl_cd[ii] ! = ""; ii++ ) */
					}
				}

			} else {	/* if ( bkgExist = = TRUE ) */

				/* ____________________________________________________________________________ BKG VVD Checking */

//				EXEC SQL
//				SELECT	 "A"
//				FROM	BKG_CONTAINER BC
//				WHERE	BC.BKG_NO =	 :FlatFileVO.bkgNumber[0]
//				AND		BC.CNTR_NO = TRIM(:FlatFileVO.cntrNumber)
//				AND		ROWNUM = 1;

				returnValue = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchCodeExist(BkgCntr)" +
							  "\n===============================================================\n");
					String tableName = "BKG_CONTAINER";
					
					//[2015.06.01]Add Osca Bkg 구분값 추가.
					if (flatFileForGateNewVO.getBkgNumber()[0].length() == 10) { // 2015.01.12
						flatFileForGateNewVO.setOscaBkgFlg("Y");
					} else {
						flatFileForGateNewVO.setOscaBkgFlg("N");
					}
					
					log.debug("\n GATENEW : Booking No ["+flatFileForGateNewVO.getBkgNumber()[0]+"] Oscar Booking Flag ["+flatFileForGateNewVO.getOscaBkgFlg()+"]");
					
					if(flatFileForGateNewVO.getOscaBkgFlg()!=null && flatFileForGateNewVO.getOscaBkgFlg().equalsIgnoreCase("Y"))
						tableName = "CTM_BKG_CNTR";
					returnValue = dbDao.searchCodeExistForGateNew(tableName, "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0] + "' AND CNTR_NO = '" + flatFileForGateNewVO.getCntrNumber());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( returnValue == null || returnValue.equals("") ) {	/* bkgCNTRFound = FALSE */
					if( !flatFileForGateNewVO.getContStat().equals("E") && !flatFileForGateNewVO.getContStat().equals("M") ) {
						flatFileForGateNewVO.setResultMessage("BKG & BKG CNTR unmatch error");
						flatFileForGateNewVO.setResultIndicator("N");
					}

				} else {

//					EXEC SQL
//					SELECT	 NVL(BV.VSL_CD,"X"),		NVL(BV.SKD_VOY_NO,"X"),		NVL(BV.SKD_DIR_CD,"X")
//					INTO	:bkg_vsl_cd,			:bkg_voyage_no,				:bkg_dir_cd
//					FROM	BKG_VVD BV
//					WHERE	BV.BKG_NO =	 :FlatFileVO.bkgNumber[0]
//					AND	 DECODE(:FlatFileVO.gateIo,"AE",BV.POL_CD, BV.POD_CD) = :FlatFileVO.eventYard
//					AND		ROWNUM = 1;

					vvdCode = new String[3];
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getVvdCd" +
								  "\n===============================================================\n");
						vvdCode = dbDao.getVvdCd(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getVvdCd1] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getVvdCd1] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( (vvdCode[0] == null || vvdCode[0].equals("")) || (vvdCode[1] == null || vvdCode[1].equals("")) || (vvdCode[2] == null && vvdCode[2].equals(""))) {
						/* bkgVVDFound = FALSE */

						/*	20091221 SBKIM (S)-------------------------------------- */
						if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
							flatFileForGateNewVO.setResultMessage("POL is different");

						} else {
							flatFileForGateNewVO.setResultMessage("POD is different");

						}

						flatFileForGateNewVO.setResultIndicator("N");
						flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
						/*	20091221 SBKIM (E)-------------------------------------- */

					} else if ( vvdCode[0].equals("X") ) {
						flatFileForGateNewVO.setResultMessage("BKG VVD is not updated yet");
						flatFileForGateNewVO.setResultIndicator("N");
						/*	20091221 SBKIM (S)-------------------------------------- */
						flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
						/*	20091221 SBKIM (E)-------------------------------------- */

					} else {
						if ( !callSignExist || !callSignVSLFound ) {
							flatFileForGateNewVO.setVessel(vvdCode[0]);
							flatFileForGateNewVO.setVoyage(vvdCode[1]);
							flatFileForGateNewVO.setDir(vvdCode[2]);
							vvdFound = true;

						} else {    /* RETURN TRUE */

							for ( int ii=0; ii<3 && csnVslCd[ii] != null; ii++ ) {
								if ( csnVslCd[ii].equals(vvdCode[0]) ) {	// bkg_vsl_cd
									flatFileForGateNewVO.setVessel(vvdCode[0]);
									flatFileForGateNewVO.setVoyage(vvdCode[1]);
									flatFileForGateNewVO.setDir(vvdCode[2]);
									vvdFound = true;
								}
							}

							if ( !vvdFound ) {
								flatFileForGateNewVO.setResultMessage("BKG VVD is different");
								flatFileForGateNewVO.setResultIndicator("N");
								/*	20091221 SBKIM (S)-------------------------------------- */
								flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
								/*	20091221 SBKIM (E)-------------------------------------- */
							}
						}
					}
				}
			}

			if ( !vvdFound ) {
				if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && flatFileForGateNewVO.getGateIo().equals("AE") ) {
//					if (flatFileForGateNewVO.getFfileRrefNo().substring(0,3).equals("IEM")) {
						flatFileForGateNewVO.setVessel("");
						flatFileForGateNewVO.setVoyage("");
						flatFileForGateNewVO.setDir("");
						
						flatFileForGateNewVO.setResultMessage("Could not find correct VVD");
						flatFileForGateNewVO.setResultIndicator("N");
						return false;
//					} else {
//						flatFileForGateNewVO.setVessel("XXXX");
//						flatFileForGateNewVO.setVoyage("0000");
//						flatFileForGateNewVO.setDir("");
//					}
				} else {
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}
			} else if ( bkgExist == false ) {
				/*** 2015.04.28 Changed by Mark Lee : Change to process the VD Movement for MT  Start
				* As-Is
				 * if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && flatFileForGateNewVO.getGateIo().equals("AE") ) {
				 * 
				 * To-Be
				 * if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {
				***/
				if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {
					log.debug("\n\n============================== bkgExist=false & ContStat in (E,M) & GateIo=AE  >>>  skip");
				} else {
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}
			}
		}
		
		//EQR Reference Number check 
		if ( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && !flatFileForGateNewVO.getLstmCd().equals("SH") ) {
			if ( flatFileForGateNewVO.getMvmtStatus().equals("TN") || flatFileForGateNewVO.getMvmtStatus().equals("EN") ) {
				if ( flatFileForGateNewVO.getMtyPlnNo() == null || flatFileForGateNewVO.getMtyPlnNo().equals("") ) {
					if ( flatFileForGateNewVO.getMtyRepoNo() == null || flatFileForGateNewVO.getMtyRepoNo().equals("") ) {
						flatFileForGateNewVO.setResultMessage("EQR Ref. No does not exist");
						flatFileForGateNewVO.setResultIndicator("N");
						return	false;
					}
				}
			}
				
			//EQR Reference Number Auto-backfill
			if ( flatFileForGateNewVO.getMvmtStatus().equals("MT")) {
				
//				SELECT MVMT_STS_CD, FCNTR_FLG, MTY_PLN_NO, MTY_REPO_NO
//				FROM CTM_MOVEMENT
//				WHERE CNTR_NO = flatFileForGateNewVO.getCntrNumber()
//				AND ROWNUM=1
//				ORDER BY CNMV_YR DESC, CNMV_SEQ DESC, CNMV_SPLIT_NO DESC
				String[] prevMvmt = new String[4];
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkPrevMvmt" +
							  "\n===============================================================\n");
					prevMvmt = dbDao.checkPrevMvmt(flatFileForGateNewVO.getCntrNumber());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.checkPrevMvmt] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.checkPrevMvmt] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( prevMvmt != null && !"".equals(prevMvmt) ) {					
					if ( (prevMvmt[0].equals("EN") || prevMvmt[0].equals("TN") ) && prevMvmt[1].equals("N") ) {
						if ( flatFileForGateNewVO.getMtyPlnNo() == null || flatFileForGateNewVO.getMtyPlnNo().equals("") ) {
							if ( flatFileForGateNewVO.getMtyRepoNo() == null || flatFileForGateNewVO.getMtyRepoNo().equals("") ) {
								flatFileForGateNewVO.setMtyPlnNo(prevMvmt[2]);
								flatFileForGateNewVO.setMtyRepoNo(prevMvmt[3]);
							}
						}
						
						if ( flatFileForGateNewVO.getMtyPlnNo() == null || flatFileForGateNewVO.getMtyPlnNo().equals("") ) {
							if ( flatFileForGateNewVO.getMtyRepoNo() == null || flatFileForGateNewVO.getMtyRepoNo().equals("") ) {
								flatFileForGateNewVO.setResultMessage("EQR Ref. No does not exist");
								flatFileForGateNewVO.setResultIndicator("N");
								return	false;
							}
						}
					}
				}
			}
		}	/* if ( FlatFileVO.cont_stat[1-2] IN ( "E", "M" ) ) */
		
		return true;

	}


	/**
	 * adjustBkgNumber for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return Boolean
	 * @exception EventException
	 *
	 * - Retrun TRUE if normal bkg of Found -
	 *   (adjust.pc)
	 **/
	private Boolean adjustBkgNumber( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		String[] returnValues = null;

///* 
////		EXEC SQL
////		SELECT	UPPER(TRIM(NVL(:FlatFileVO.bkgNumber[0],"")))
////		INTO	:FlatFileVO.bkgNumber[0]
////		FROM	DUAL;
//
//
////		EXEC SQL
////		SELECT	NVL(TRIM(:FlatFileVO.cntrNumber),"")
////		INTO	:FlatFileVO.cntrNumber
////		FROM	DUAL;
//
//		/***** 2009.05.08 : Container No Check Using CONTAINER Table *****/			 
//		if ( flatFileForGateNewVO.getCntrNumber().length() >= 10 ) {
//
////			EXEC SQL
////			SELECT	CNTR_NO
////			INTO	:FlatFileVO.cntrNumber
////			FROM	(
////						SELECT	CNTR_NO
////						FROM	MST_CONTAINER
////						/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
////						WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
////						ORDER BY
////								CNMV_DT DESC
////					)
////			WHERE	ROWNUM  = 1
//
//			String cntrNumber = "";
//			try {
//				log.debug("\n\n===============================================================" +
//						  "\n dbDao.getCntrNo(cntrNo)" +
//						  "\n===============================================================\n");
//				cntrNumber = dbDao.getCntrNo(flatFileForGateNewVO.getCntrNumber());
//			} catch (DAOException ex) {
//				log.error("[GATENEW : dbDao.getCntrNo(cntrNo)] DAOerr : " + ex.toString(), ex);
//				throw new EventException(ex.getMessage(), ex);
//			} catch (Exception ex) {
//				log.error("[GATENEW : dbDao.getCntrNo(cntrNo)] err : " + ex.toString(), ex);
//				throw new EventException(ex.getMessage(), ex);
//			}
//
//			if ( cntrNumber != null && !cntrNumber.equals("") ) {
//				flatFileForGateNewVO.setCntrNumber(cntrNumber);
//
//			} else {
//				return false;
//
//			}
//		}
		
		
		if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals(""))
				&& (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) ) {
				   /* FlatFileVO.blNo가 Domestic Booking 이면 BKG No로 치환 */
			 //String domesticCheck = subStr(flatFileForGateNewVO.getBlNo(), 0, 4);
			int domesticCheck = 0;
			try {
				domesticCheck = dbDao.searchDomsticBooking(flatFileForGateNewVO.getBlNo());
				if(domesticCheck != 0) {   
					/* if ( (domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
							 || domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI")) ) {*/
						 		String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
						 		bkgNumber[0] = flatFileForGateNewVO.getBlNo();
						 		flatFileForGateNewVO.setBkgNumber(bkgNumber);
						 		flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
						 		flatFileForGateNewVO.setBlNo("");
					 }
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.searchDomsticBooking(R)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
		}
		
		/* FlatFileVO.bkgNumber[0]가 Domestic Booking 이면 skip */
		//String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
		int domesticCheck = 0;
		try {
			domesticCheck = dbDao.searchDomsticBooking(flatFileForGateNewVO.getBkgNumber()[0]);
			/*if ( domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
					|| domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI") ) {*/
			 if(domesticCheck != 0) {
					   return false;
			}
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchDomsticBooking(R)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		

		
		if ( flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("") ) {
			if ( isAlpha(subStr(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getBkgNumber()[0].length()-1, flatFileForGateNewVO.getBkgNumber()[0].length())) ) {

				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, flatFileForGateNewVO.getBkgNumber()[0].length()-1);
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

			}
		}

		
		if ( flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("") ) {
			if ( isAlpha(subStr(flatFileForGateNewVO.getBlNo(), flatFileForGateNewVO.getBlNo().length()-1, flatFileForGateNewVO.getBlNo().length())) ) {

				flatFileForGateNewVO.setBlNo(subStr(flatFileForGateNewVO.getBlNo(), 0, flatFileForGateNewVO.getBlNo().length()-1));

			}
		}

	
		if ( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {

//			EXEC SQL
//			SELECT /*+ ordered index_desc(A XAKBKG_CNTR) index(B XPKBOOKING) 2010 : 
//					B.BKG_NO
//			INTO	:mty_bkgNumber
//			FROM	BKG_CONTAINER A, BKG_BOOKING B
//			WHERE	A.CNTR_NO = :FlatFileVO.cntrNumber
//			AND		A.CNMV_CYC_NO = (
//										SELECT	/*+ ordered index_desc(bc XAKBKG_CNTR)
//												index(bo XPKBOOKING) 2010 :
//												MAX(CNMV_CYC_NO)
//										FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//										WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//										AND		BC.BKG_NO = BO.BKG_NO
//										AND		NVL(BO.BKG_STS_CD," ") <> "X"
//										AND		NVL(BO.BKG_STS_CD," ") <> "S"
//										AND		NVL(BO.BKG_STS_CD," ") <> "A"
//										AND		BC.CNMV_CYC_NO	  <>	DECODE(:FlatFileVO.gateIo,"UV",9999,0)
//										AND		BC.CNMV_CYC_NO = DECODE(:FlatFileVO.gateIo,"AE",9999,BC.CNMV_CYC_NO)
//									)
//			AND		A.BKG_NO = B.BKG_NO
//			AND		NVL(B.BKG_STS_CD," ")  <> "X"
//			AND		NVL(B.BKG_STS_CD," ")  <> "S"아래 Logic을 수행한다.
//			AND		NVL(B.BKG_STS_CD," ")  <> "A"
//			AND		B.BKG_CGO_TP_CD = "P"
//			AND		DECODE(:FlatFileVO.gateIo,"AE",B.POL_CD,B.POD_CD) = SUBSTR(:FlatFileVO.eventYard,1,5)
//			AND		ROWNUM = 1;

			String mtyBkgNumber = "";
			
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(R)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "R");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1. Search MT Repo BKG(R)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(R)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(R)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber != null && !mtyBkgNumber.equals("") ) {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true;
			}

			
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(B.Bulk)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "F");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1-1. Search MT Repo BKG(B.Bulk)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(B.Bulk)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(B.Bulk)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber != null && !mtyBkgNumber.equals("") ) {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				flatFileForGateNewVO.setContStat("F");    
				return true;
			}

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(P)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "P");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1-1. Search MT Repo BKG(P)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(P)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(P)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber == null || mtyBkgNumber.equals("") ) {
				String[] bkgNumber = new String[1];
				bkgNumber[0] = "";
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

				/*** 2015.04.28 Changed by Mark Lee : Change to process the VD Movement for MT  Start
				/* As-Is
				 * if (!"UV".equals(flatFileForGateNewVO.getGateIo())) {
				 * 
				 * To-Be
				 * if ("AE".equals(flatFileForGateNewVO.getGateIo())||"UV".equals(flatFileForGateNewVO.getGateIo())) {
				***/
				if ("AE".equals(flatFileForGateNewVO.getGateIo())||"UV".equals(flatFileForGateNewVO.getGateIo())) {
					flatFileForGateNewVO.setNBkgNoFlg("Y");    
					return false;
				}

			} else {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true;
			}
		}

		
//		EXEC SQL
//		SELECT	BKG_STS_CD,		BKG_CGO_TP_CD
//		INTO	:bkg_sts_cd,	:bkg_cgo_tp_cd		/* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
//		FROM	BKG_BOOKING
//		WHERE	BKG_NO			=	:FlatFileVO.bkgNumber[0]

		boolean validBooking = false;

		returnValues = new String[2];
		String bkgStsCd = "";
		String bkgCgoTpCd = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getBkgStsCd" +
					  "\n===============================================================\n");
			returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
			bkgStsCd = returnValues[0];
			bkgCgoTpCd = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 2. Search BKG" +
					  "\n===============================================================" +
					  "\n BKG_STS = " + bkgStsCd +
					  "\n BKG_CGO_TP = " + bkgCgoTpCd +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		//[2015.05.28]소스품질 Modify
		if ( StringUtils.isNotEmpty(bkgStsCd) //if ( (bkgStsCd != null && !bkgStsCd.equals(""))
		  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
		  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
	  	  /* (Empty/GateOUT or OP) with Advance BKG -> Normal BKG - 2009.06.15 */
		  && (!bkgStsCd.equals("A") || (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("O")
															   || flatFileForGateNewVO.getGateIo().equals("D")
															   || flatFileForGateNewVO.getGateIo().equals("OA")
															   || flatFileForGateNewVO.getGateIo().equals("P"))
															  && (flatFileForGateNewVO.getContStat().equals("E")
															   || flatFileForGateNewVO.getContStat().equals("M")
															   || flatFileForGateNewVO.getContStat().equals("AB"))
															 || flatFileForGateNewVO.getMvmtStatus().equals("OP")))
									/* (Full/GateIN or OC) with Advance BKG -> Normal BKG - 2009.09.29 */
									|| (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("I")
															   || flatFileForGateNewVO.getGateIo().equals("A")
															   || flatFileForGateNewVO.getGateIo().equals("AR")
															   || flatFileForGateNewVO.getGateIo().equals("UR")
															   || flatFileForGateNewVO.getGateIo().equals("N")
															   || flatFileForGateNewVO.getGateIo().equals("R"))
															  && (flatFileForGateNewVO.getContStat().equals("F")
															   || flatFileForGateNewVO.getContStat().equals("AH")))
															 || flatFileForGateNewVO.getMvmtStatus().equals("OC")))) {

			
			validBooking = true;

		// else if ( sqlca.sqlcode == 1403 || :bkg_sts_cd  In ( "X","S","A" ) )
		} else if ( bkgStsCd.equals("") || (bkgStsCd.equals("X") || bkgStsCd.equals("S") || bkgStsCd.equals("A")) || bkgCgoTpCd.equals("P") ) {

			/* 
			   FlatFileVO.blNo 를 가지고 Booking TBL에서 BKG Status(:bkg_sts)와 BKG No(:bkgNumber_by_blNo)를 조회 */
//				EXEC SQL
//				SELECT	BKG_NO, BKG_STS_CD
//				INTO	:bkgNumber_by_blNo, :bkg_sts_cd
//				FROM	BKG_BOOKING
//				WHERE	BL_NO = :FlatFileVO.blNo;

			returnValues = new String[2];
			String bkgNumberByBlNo = "";
			bkgStsCd = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getBkgNoByBlNo" +
						  "\n===============================================================\n");
				returnValues = dbDao.getBkgNoByBlNo(flatFileForGateNewVO.getBlNo());
				bkgNumberByBlNo = returnValues[0];
				bkgStsCd = returnValues[1];
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 3. Search BKG by BL_NO" +
						  "\n===============================================================" +
						  "\n FLT_BL_NO = " + flatFileForGateNewVO.getBlNo() +
						  "\n BKG_NO = " + bkgNumberByBlNo +
						  "\n BKG_STS = " + bkgStsCd +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getBkgNoByBlNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getBkgNoByBlNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( (bkgNumberByBlNo != null && !bkgNumberByBlNo.equals("")) && (bkgStsCd != null && !bkgStsCd.equals(""))
			  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
			  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
			  && (!bkgStsCd.equals("A")
			  || (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("O")
										 || flatFileForGateNewVO.getGateIo().equals("D")
										 || flatFileForGateNewVO.getGateIo().equals("OA")
										 || flatFileForGateNewVO.getGateIo().equals("P")
										   )
										&& (flatFileForGateNewVO.getContStat().equals("E")
										 || flatFileForGateNewVO.getContStat().equals("M")
										 || flatFileForGateNewVO.getContStat().equals("AB")
										   )
			  							  ) || flatFileForGateNewVO.getMvmtStatus().equals("OP")))) {

				
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = (bkgNumberByBlNo == null ? "" : bkgNumberByBlNo.trim() + "");
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				validBooking = true;

			} else {

				/* */
//						EXEC SQL
//						SELECT	BKG_NO, NVL(BKG_STS," ")
//						INTO	:temp_bkgNumber, :bkg_sts_cd
//						FROM	BKG_BOOKING
//						WHERE	(   BKG_NO = :FlatFileVO.blNo
//									OR
//									BL_NO = :FlatFileVO.bkgNumber[0] )
//						AND		ROWNUM = 1;

				returnValues = new String[2];
				String tempBkgNumber = "";
				bkgStsCd = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getBkgNoForCrossCheck" +
							  "\n===============================================================\n");
					returnValues = dbDao.getBkgNoForCrossCheck(flatFileForGateNewVO.getBlNo(), flatFileForGateNewVO.getBkgNumber()[0]);
					tempBkgNumber = returnValues[0];
					bkgStsCd = returnValues[1];
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 4. Search BKG by Cross Check" +
							  "\n===============================================================" +
							  "\n FLT_BL_NO = " + flatFileForGateNewVO.getBlNo() +
							  "\n FLT_BKG_NO = " + flatFileForGateNewVO.getBkgNumber()[0] +
							  "\n BKG_NO = " + tempBkgNumber +
							  "\n BKG_STS = " + bkgStsCd +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getBkgNoForCrossCheck] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getBkgNoForCrossCheck] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if	( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
					
					String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
					bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
					flatFileForGateNewVO.setBkgNumber(bkgNumber);
					flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

					if ( (bkgStsCd != null && !bkgStsCd.equals(""))
					  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
					  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
					  && (!bkgStsCd.equals("A")
					  || (bkgStsCd.equals("A") && (    (flatFileForGateNewVO.getGateIo().equals("O")
													|| flatFileForGateNewVO.getGateIo().equals("D")
													|| flatFileForGateNewVO.getGateIo().equals("OA")
													|| flatFileForGateNewVO.getGateIo().equals("P")
													)
													&& (flatFileForGateNewVO.getContStat().equals("E")
													|| flatFileForGateNewVO.getContStat().equals("M")
													|| flatFileForGateNewVO.getContStat().equals("AB")
													)
												  ) || flatFileForGateNewVO.getMvmtStatus().equals("OP")))) {

						validBooking = true;

					}
				}

				if ( !validBooking ) {

					
//							EXEC SQL
//							SELECT	NVL(TO_BKG_NO," "),
//									NVL(BKG_STS_CD," "),
//									NVL(SPLIT_FLG," "),
//									LENGTH(:FlatFileVO.bkgNumber[0])
//							INTO	:bkg_combine_no,
//									:bkg_sts_cd,
//									:bkg_split_flag,
//									:bkg_length
//							FROM	BKG_BOOKING
//							WHERE   BKG_NO = :FlatFileVO.bkgNumber[0]       

					String[] bkgInforRetVal = new String[4];
					String bkgCombineNo = "";
					String bkgSplitFlag = "";
					String bkgLength = "";
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getBookingInfo (Combine/SplitBkg)" +
								  "\n===============================================================\n");
						bkgInforRetVal = dbDao.getBookingInfo(flatFileForGateNewVO.getBkgNumber()[0]);
						bkgStsCd = (bkgInforRetVal[0] == null ? "" : bkgInforRetVal[0].trim() + "");
						bkgSplitFlag = (bkgInforRetVal[1] == null ? "" : bkgInforRetVal[1].trim() + "");
						bkgCombineNo = (bkgInforRetVal[2] == null ? "" : bkgInforRetVal[2].trim() + "");
						bkgLength = (bkgInforRetVal[3] == null ? "" : bkgInforRetVal[3].trim() + "");
						/***** For Log (S) *****/
						log.info("\n\n===============================================================" +
								  "\n 5. Search BKG by Combine/Split" +
								  "\n===============================================================" +
								  "\n FlatFileVO.bkgNumber[0] = " + flatFileForGateNewVO.getBkgNumber()[0] +
								  "\n BKG_NO = " + bkgCombineNo +
								  "\n BKG_STS = " + bkgStsCd +
								  "\n SPLIT_FLG = " + bkgSplitFlag +
								  "\n BKG_LEN = " + bkgLength +
								  "\n===============================================================\n");
						/***** For Log (E) *****/
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( !bkgCombineNo.equals("") || !bkgStsCd.equals("") ) {
						if ( !bkgCombineNo.equals("") ) {

//									EXEC SQL
//									SELECT	"A"
//									FROM	BKG_BOOKING		BO,
//											BKG_CONTAINER	BC
//									WHERE	BO.BKG_NO = :bkg_combine_no
//									AND		NVL(BO.BKG_STS," ") <> "X"
//									AND		BC.BKG_NO = BO.BKG_NO
//									AND		BC.CNTR_NO = :FlatFileVO.cntrNumber;

							//CSR #11543
//							try {
//								log.debug("\n\n===============================================================" +
//										  "\n dbDao.checkCombienBkgNo" +
//										  "\n===============================================================\n");
//								if ( dbDao.checkCombienBkgNo(bkgCombineNo, flatFileForGateNewVO.getCntrNumber()) ) {
									/* Combine BKG인 경우는 Combine BKG으로 BKG No 치환 */
									String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
									bkgNumber[0] = (bkgCombineNo == null ? "" : bkgCombineNo.trim() + "");
									flatFileForGateNewVO.setBkgNumber(bkgNumber);
									flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
									validBooking = true;
//								}
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 6.Search BKG by Combine Check" +
										  "\n===============================================================" +
										  "\n BKG_COM_NO = " + bkgCombineNo +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
//							} catch (DAOException ex) {
//								log.error("[GATENEW : dbDao.checkCombienBkgNo] DAOerr : " + ex.toString(), ex);
//								throw new EventException(ex.getMessage(), ex);
//							} catch (Exception ex) {
//								log.error("[GATENEW : dbDao.checkCombienBkgNo] err : " + ex.toString(), ex);
//								throw new EventException(ex.getMessage(), ex);
//							}

						} else if ( bkgStsCd.equals("S") || bkgSplitFlag.equals("Y") ) {

							
//							EXEC SQL
//							SELECT	BC.BKG_NO
//							INTO	:temp_bkgNumber
//							FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//							WHERE	BC.CNTR_NO	     =   :FlatFileVO.cntrNumber
//							AND     BC.BKG_NO        =	  BO.BKG_NO
//							AND		(
//										BO.FM_BKG_NO  =   :FlatFileVO.bkgNumber[0]
//										OR
//										BO.BKG_NO     =   :FlatFileVO.bkgNumber[0]
//									)
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'A'
//							AND     ROWNUM = 1

							tempBkgNumber = "";
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getBkgNo" +
										  "\n===============================================================\n");
								tempBkgNumber = dbDao.getBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 7. Search BKG by Split Check" +
										  "\n===============================================================" +
										  "\n FLT_BKG_NO = " + flatFileForGateNewVO.getBkgNumber()[0] +
										  "\n BKG_NO = " + tempBkgNumber +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getBkgNo] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getBkgNo] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if ( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
								String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
								bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
								flatFileForGateNewVO.setBkgNumber(bkgNumber);
								flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
								validBooking = true;

							}
						}
					}
				}  /* if( normal_booking ! = TRUE ) */
			}

		} else {
			return false;

		}

		
		if( validBooking ) {

//			SELECT	B.BKG_NO
//			INTO	:temp_bkgNumber
//			FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//			WHERE	BC.CNTR_NO			= :FlatFileVO.cntrNumber
//			AND		BC.CNMV_CYC_NO		=	9999
//			AND		SYSDATE - BC.CRE_DT < 60		/* 30 -> 60 (SBK1218) */
//			AND     BC.BKG_NO           = BO.BKG_NO
//			AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//			AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//			AND		NVL(BO.BKG_STS_CD,' ') <> DECODE(:FlatFileVO.gateIo,'AE','A','UV','A','X')
//			AND     ROWNUM = 1

			String tempBkgNumber = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getOldBkgNo" +
						  "\n===============================================================\n");
				tempBkgNumber = dbDao.getOldBkgNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo());
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 8. Search BKG by 9999" +
						  "\n===============================================================" +
						  "\n BKG_NO = " + tempBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getOldBkgNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getOldBkgNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
				/*CSR #14014 - Adjust Fcntr Flag*/
				returnValues = new String[2];
				bkgCgoTpCd = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getBkgStsCd" +
							  "\n===============================================================\n");
					returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
					bkgCgoTpCd = returnValues[1];
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 2. Search BKG" +
							  "\n===============================================================" +
							  "\n BKG_CGO_TP = " + bkgCgoTpCd +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if	( bkgCgoTpCd != null && !bkgCgoTpCd.equals("") ) {
					if ("R".equals(bkgCgoTpCd) && "SH".equals(flatFileForGateNewVO.getLstmCd())) {
						flatFileForGateNewVO.setContStat("M");
					}
				}				
				
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true ;

			} else {

				
//				EXEC SQL
//				SELECT  MAX(BC.CNMV_CYC_NO)
//				INTO	:max_bkg_cycle
//				FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//				WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//				AND		BC.BKG_NO = BO.BKG_NO
//				AND		NVL(BO.BKG_STS_CD," ") <> "X"
//				AND		NVL(BO.BKG_STS_Cd," ") <> "S";

				String maxBkgCycle = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getMaxCnmvCycNo" +
							  "\n===============================================================\n");
					maxBkgCycle = dbDao.getMaxCnmvCycNo( flatFileForGateNewVO.getCntrNumber() );
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 9. Search BKG by Last Cycle" +
							  "\n===============================================================" +
							  "\n LAST_CYCLE = " + maxBkgCycle +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( maxBkgCycle == null || maxBkgCycle.equals("") ) {
					return false;

				}

				
//				EXEC SQL
//				SELECT	CNMV_CYC_NO
//				INTO	:nm_bkg_cycle
//				FROM	BKG_CONTAINER
//				WHERE	BKG_NO = :FlatFileVO.bkgNumber[0]
//				AND		CNTR_NO = :FlatFileVO.cntrNumber;

				String nmBkgCycle = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getCurrCnmvCycNo" +
							  "\n===============================================================\n");
					nmBkgCycle = dbDao.getCurrCnmvCycNo( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber());
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 10. Search BKG by BKG Cycle" +
							  "\n===============================================================" +
							  "\n BKG_CYCLE = " + nmBkgCycle +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getCurrCnmvCycNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getCurrCnmvCycNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( "".equals(nmBkgCycle) ) { 		/* sqlca.sqlcode == 1403 */
					if (	(	(flatFileForGateNewVO.getGateIo().equals("O")
								|| flatFileForGateNewVO.getGateIo().equals("D")
								|| flatFileForGateNewVO.getGateIo().equals("OA")
								|| flatFileForGateNewVO.getGateIo().equals("P"))
							&&	(flatFileForGateNewVO.getContStat().equals("E")
								|| flatFileForGateNewVO.getContStat().equals("M")
								|| flatFileForGateNewVO.getContStat().equals("AB")))
							|| flatFileForGateNewVO.getMvmtStatus().equals("OP")
							/* (SBK1218) --> */
							|| ((flatFileForGateNewVO.getGateIo().equals("I")
								|| flatFileForGateNewVO.getGateIo().equals("A")
								|| flatFileForGateNewVO.getGateIo().equals("AR")
								|| flatFileForGateNewVO.getGateIo().equals("UR")
								|| flatFileForGateNewVO.getGateIo().equals("N")
								|| flatFileForGateNewVO.getGateIo().equals("R"))
							&& (flatFileForGateNewVO.getContStat().equals("F")
								|| flatFileForGateNewVO.getContStat().equals("AH")
								|| flatFileForGateNewVO.getContStat().equals("AC")))
							|| flatFileForGateNewVO.getMvmtStatus().equals("OC")
							/* <-- (SBK1218) */ ) {

						return true;
						/* Normal BKG Check [OK] (Empty/GateOut or OP & BKG CNTR Cycle doesn't exist)!" */

					} else {
						/* return false;    <----------------- 20100316 By SBKIM Just Do Nothing */
					}

				} else {
					
					if ( !nmBkgCycle.equals("9999") && nmBkgCycle.equals(maxBkgCycle) ) {

						
//						EXEC SQL
//						SELECT  MVMT_STS_CD
//						FROM    CTM_MOVEMENT
//						WHERE   CNTR_NO			= :FlatFileVO.cntrNumber
//						AND     CNMV_CYC_NO		= :nm_bkg_cycle   /* 2010.03.17 SBKIM Just Check Again */
//						AND		MVMT_STS_CD		= 'MT'
//						AND		SYS_AREA_GRP_ID	=	(	/* :current_svr_id	 */
//														SELECT	SYS_AREA_GRP_ID
//														FROM	COM_SYS_AREA_GRP_ID
//														WHERE	CO_IND_CD	= 'H'
//														AND		CNT_CD		= SUBSTR(:FlatFileVO.eventYard,1,2)
//													)   /* Modified By 2010.03.17 By SBKIM */
//						AND		ROWNUM			= 1;

						String cnmsCd = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getCnmsCd(currBkgCycle)" +
									  "\n===============================================================\n");
							cnmsCd = dbDao.getCnmsCd( flatFileForGateNewVO.getCntrNumber(), nmBkgCycle, flatFileForGateNewVO.getEventYard() );
							/***** For Log (S) *****/
							log.info("\n\n===============================================================" +
									  "\n 11. Search BKG by MT Check" +
									  "\n===============================================================" +
									  "\n MVMT_STS_CD = " + cnmsCd +
									  "\n===============================================================\n");
							/***** For Log (E) *****/
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getCnmsCd] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getCnmsCd] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}

						if( cnmsCd != null && !cnmsCd.equals("") ) {    // if(sqlca.sqlcode == 0)
							
							/*CSR #14014 - Adjust Fcntr Flag*/
							returnValues = new String[2];
							bkgCgoTpCd = "";
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getBkgStsCd" +
										  "\n===============================================================\n");
								returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
								bkgCgoTpCd = returnValues[1];
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 2. Search BKG" +
										  "\n===============================================================" +
										  "\n BKG_CGO_TP = " + bkgCgoTpCd +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if	( bkgCgoTpCd != null && !bkgCgoTpCd.equals("") ) {
								if ("R".equals(bkgCgoTpCd) && "SH".equals(flatFileForGateNewVO.getLstmCd())) {
									flatFileForGateNewVO.setContStat("M");
									return true;
								}
							}
							
							String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
							bkgNumber[0] = "";    /* Empty String */
							flatFileForGateNewVO.setBkgNumber(bkgNumber);
							flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
							int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
							flatFileForGateNewVO.setBkgCount(bkgCount + "");

						} else {    //[2015.05.28]소스품질 Modify else if ( cnmsCd.equals("") ) , else if (sqlca.sqlcode == 1403)
							/*CSR #14014 - Adjust Fcntr Flag*/
							returnValues = new String[2];
							bkgCgoTpCd = "";
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getBkgStsCd" +
										  "\n===============================================================\n");
								returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
								bkgCgoTpCd = returnValues[1];
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 2. Search BKG" +
										  "\n===============================================================" +
										  "\n BKG_CGO_TP = " + bkgCgoTpCd +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if	( bkgCgoTpCd != null && !bkgCgoTpCd.equals("") ) {
								if ("R".equals(bkgCgoTpCd) && "SH".equals(flatFileForGateNewVO.getLstmCd())) {
									flatFileForGateNewVO.setContStat("M");
								}
							}
							return true;

						}
					} else if ( 0 + Integer.parseInt(nmBkgCycle) < 0 + Integer.parseInt(maxBkgCycle) ) {
						String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
						bkgNumber[0] = "";    /* Empty String */
						flatFileForGateNewVO.setBkgNumber(bkgNumber);
						flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
						int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
						flatFileForGateNewVO.setBkgCount(bkgCount + "");

					}
				}
			}
		} else {
			String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
			bkgNumber[0] = "";    /* Empty String */
			flatFileForGateNewVO.setBkgNumber(bkgNumber);
			flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
			int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
			flatFileForGateNewVO.setBkgCount(bkgCount + "");

		}


		if ((flatFileForGateNewVO.getContStat() != null && !flatFileForGateNewVO.getContStat().equals("")) && (bkgStsCd != null && !bkgStsCd.equals(""))) {

			if (  (!flatFileForGateNewVO.getContStat().equals("F") && !flatFileForGateNewVO.getContStat().equals("AH") && !flatFileForGateNewVO.getContStat().equals("AC") && !flatFileForGateNewVO.getContStat().equals("L"))
					&&(!bkgStsCd.equals("X") && !bkgStsCd.equals("S") && !bkgStsCd.equals("A")) ) {

				return false;
			}
		}



//		EXEC SQL
//		SELECT	SVR_ID
//		INTO	:master_svr_id
//		FROM	MST_CONTAINER	M
//		WHERE	CNTR_NO = :FlatFileVO.cntrNumber;

		String masterSvrId = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(get masterSvrId)" +
					  "\n===============================================================\n");
			masterSvrId = dbDao.getCodeValueForGateNew("MST_CONTAINER", "CNTR_NO", "SYS_AREA_GRP_ID", flatFileForGateNewVO.getCntrNumber());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(get masterSvrId)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeValue(get masterSvrId)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if	( masterSvrId == null || masterSvrId.equals("") ) {
			return false;

		}

//		EXEC SQL
//		SELECT  SVR_ID
//		INTO	:current_svr_id
//		FROM	COM_OPUS_SVR_ID
//		WHERE   CNT_CD = SUBSTR(:FlatFileVO.eventYard,1,2)
//		AND	 CO_IND_CD = "H";

		String currSvrId = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(get currentSvrId)" +
					  "\n===============================================================\n");
			currSvrId = dbDao.getCodeValueForGateNew("COM_SYS_AREA_GRP_ID", "CO_IND_CD = 'H' AND CNT_CD", "SYS_AREA_GRP_ID", subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(get currentSvrId)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeValue(get currentSvrId)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if	( currSvrId == null || currSvrId.equals("") ) {
			return false;

		}

		if ( !masterSvrId.equals(currSvrId)
		  && !(flatFileForGateNewVO.getGateIo().equals("UV")
			&& (flatFileForGateNewVO.getMvmtStatus().equals("ZZ") || flatFileForGateNewVO.getMvmtStatus().equals("VD") || flatFileForGateNewVO.getMvmtStatus().equals(""))) ) {

			return false;

		}

		
//		EXEC SQL
//		SELECT	/*+ ordered index_desc(A XAKBKG_CNTR) index(B XPKBOOKING) 2010 : Index 재조정할것 */
//				B.BKG_NO,
//				A.CNMV_CYC_NO
//		INTO
//				:pre_bkg_number,
//				:pre_cycle_no
//		FROM	BKG_CONTAINER A, BKG_BOOKING B
//		WHERE	A.CNTR_NO = :FlatFileVO.cntrNumber
//		AND		A.CNMV_CYC_NO = (
//										SELECT /*+ ordered index_desc(bc XAKBKG_CNTR)
//										index(bo XPKBOOKING) 2010 : Index 재조정할것 */
//												MAX(CNMV_CYC_NO)
//										FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//										WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//										AND		BC.BKG_NO = BO.BKG_NO
//										AND		NVL(BO.BKG_STS_CD," ") <> "X"
//										AND		NVL(BO.BKG_STS_CD," ") <> "S"
//										AND		NVL(BO.BKG_STS_CD," ") <> DECODE(:FlatFileVO.gateIo,"AE","A","UV","A","X") /* 2008.12.16 */
//										AND		(
//													BC.CNMV_CYC_NO <> 9999
//													OR
//													(	BC.CNMV_CYC_NO = 9999
//														AND
//														SYSDATE - BC.CRE_DT < 30
//													)
//												)
//									)
//		AND		A.BKG_NO = B.BKG_NO
//		AND		NVL(B.BKG_STS_CD," ")  <> "X"
//		AND		NVL(B.BKG_STS_CD," ")  <> "S"
//		AND		NVL(B.BKG_STS_CD," ")  <> DECODE(:FlatFileVO.gateIo,"AE","A","UV","A","X") /* 2008.12.16 */
//		AND		ROWNUM = 1;

		returnValues = new String[2];
		String preBkgNumber = "";
		String preBkgCycle = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getPreCnmvCycNo" +
					  "\n===============================================================\n");
			returnValues = dbDao.getPreCnmvCycNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo());
			preBkgNumber = returnValues[0];
			preBkgCycle = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 12. Search BKG by Pre Max Cycle" +
					  "\n===============================================================" +
					  "\n PRE_BKG = " + preBkgNumber +
					  "\n PRE_CYC = " + preBkgCycle +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getPreCnmvCycNo] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getPreCnmvCycNo] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( (preBkgNumber == null || preBkgNumber.equals("")) || (preBkgCycle == null || preBkgCycle.equals("")) ) {
			return false;

		}

		
		if ( !preBkgCycle.equals("9999") ) {

//			EXEC SQL
//			SELECT	"A"
//			FROM	MST_CONTAINER
//			WHERE	CNTR_NO = :FlatFileVO.cntrNumber
//			AND		CNMV_CYC_NO = :pre_cycle_no;

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.checkCnmvCycNo" +
						  "\n===============================================================\n");
				if ( !dbDao.checkCnmvCycNo(flatFileForGateNewVO.getCntrNumber(), preBkgCycle) ) {
					return false;
				}
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.checkCnmvCycNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.checkCnmvCycNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			
//			SELECT MVMT_STS_CD
//			  FROM CTM_MOVEMENT
//			 WHERE CNTR_NO = :FlatFileVO.cntrNumber
//			   AND CNMV_CYC_NO = :pre_cycle_no
//			   AND MVMT_STS_CD = 'MT'
//			   AND SYS_AREA_GRP_ID = ( /* :current_svr_id */
//			                          SELECT SYS_AREA_GRP_ID
//			                            FROM COM_SYS_AREA_GRP_ID
//			                           WHERE CO_IND_CD = 'H'
//			                             AND CNT_CD = SUBSTR (:FlatFileVO.eventYard, 1, 2)
//			                         ) /* Modified By 2010.03.17 By SBKIM */
//			   AND ROWNUM = 1

			String cnmsCd = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCnmsCd(preBkgCycle)" +
						  "\n===============================================================\n");
                cnmsCd = dbDao.getCnmsCd( flatFileForGateNewVO.getCntrNumber(), preBkgCycle, flatFileForGateNewVO.getEventYard() );
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 13. Search BKG by Pre BKG MT Check" +
						  "\n===============================================================" +
						  "\n PRE_CYC = " + preBkgCycle +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCnmsCd] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCnmsCd] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if (cnmsCd != null && !cnmsCd.equals("")) {
				/*CSR #14014 - Adjust Fcntr Flag*/
				returnValues = new String[2];
				bkgCgoTpCd = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getBkgStsCd" +
							  "\n===============================================================\n");
					returnValues = dbDao.getBkgStsCd(preBkgNumber);
					bkgCgoTpCd = returnValues[1];
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 2. Search BKG" +
							  "\n===============================================================" +
							  "\n BKG_CGO_TP = " + bkgCgoTpCd +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if	( bkgCgoTpCd == null || ("").equals(bkgCgoTpCd) || !"R".equals(bkgCgoTpCd) || !"SH".equals(flatFileForGateNewVO.getLstmCd())) {
					return false;

				}

			}
		}		
		
		String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
		bkgNumber[0] = (preBkgNumber == null ? "" : preBkgNumber.trim() + "");
		flatFileForGateNewVO.setBkgNumber(bkgNumber);
		flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

		/*CSR #14014 - Adjust Fcntr Flag*/
		returnValues = new String[2];
		bkgCgoTpCd = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getBkgStsCd" +
					  "\n===============================================================\n");
			returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber0());
			bkgCgoTpCd = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 2. Search BKG" +
					  "\n===============================================================" +
					  "\n BKG_CGO_TP = " + bkgCgoTpCd +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if	( bkgCgoTpCd != null && !bkgCgoTpCd.equals("") ) {
			if ("R".equals(bkgCgoTpCd) && "SH".equals(flatFileForGateNewVO.getLstmCd())) {
				flatFileForGateNewVO.setContStat("M");
			}
		}
		
		return true;

	}


	/**
	 * determining Container Movement Status 
	 *  adjustSightCode for GateNew
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param boolean bkgCheck
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	private FlatFileForGateNewVO adjustSightCode( FlatFileForGateNewVO flatFileForGateNewVO, boolean bkgCheck ) throws EventException {

		if ( bkgCheck && (flatFileForGateNewVO.getContStat().equals("F") || flatFileForGateNewVO.getContStat().equals("AH") || flatFileForGateNewVO.getContStat().equals("AC") )
					  && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) && !flatFileForGateNewVO.getSightCd().equals("X") ) {

//	        EXEC SQL
//	        SELECT "A"
//	        FROM   CTM_MVEMENT CM, BKG_CONTAINER BC
//	        WHERE  CM.CNTR_NO = :FlatFileVO.cntrNumber
//	        AND    BC.BKG_NO = :FlatFileVO.bkgNumber[0]
//	        AND    BC.CNTR_NO = CM.CNTR_NO
//	        AND    CM.CNMV_CYC_NO = BC.CNMV_CYC_NO
//	        AND    CM.MVMT_STS_CD = "VL";

			boolean checkVdCnmvCycNoYN = false;
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.checkVdCnmvCycNo" +
						  "\n===============================================================\n");
				checkVdCnmvCycNoYN = dbDao.checkVdCnmvCycNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.checkVdCnmvCycNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.checkVdCnmvCycNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			String newSightCd = "";
			if ( !checkVdCnmvCycNoYN ) {
				if(flatFileForGateNewVO.getBkgNumber()[0].length() == 10)
			    {
			     boolean checkOutbound = false;
			     
			     try{
			      
			      checkOutbound = dbDao.checkOutbound(flatFileForGateNewVO.getBkgNumber()[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
			      
			     } catch (DAOException ex) {
			      log.error("[GATENEW : dbDao.checkOutbound] DAOerr : " + ex.toString(), ex);
			      throw new EventException(ex.getMessage(), ex);
			     } catch (Exception ex) {
			      log.error("[GATENEW : dbDao.checkOutbound] err : " + ex.toString(), ex);
			      throw new EventException(ex.getMessage(), ex);
			     }
			     
			     if(checkOutbound){
			      
			      if( flatFileForGateNewVO.getMsgId().equals("322") ) {
			       newSightCd = "O";
			  
			               } else if ( flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") || flatFileForGateNewVO.getMsgId().equals("SPP") ) {
			       newSightCd = "E";
			  
			               }
			     }
			     else
			     {
			      newSightCd = "I";
			     }
			    }
			    else
			    {
			     if( flatFileForGateNewVO.getMsgId().equals("322") ) {
			      newSightCd = "O";
			 
			              } else if ( flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") || flatFileForGateNewVO.getMsgId().equals("SPP") ) {
			      newSightCd = "E";
			 
			              }
			    }

	    	} else {

//	        	EXEC SQL
//	            SELECT "A"
//	            FROM   BKG_VVD BV, BKG_BOOKING B
//	            WHERE  BV.BKG_NO = :FlatFileVO.bkgNumber[0]
//	            AND    B.BKG_NO = BV.BKG_NO
//	            AND    BV.POD_CD        <>    B.POD_CD
//	            AND    BV.POD_CD = SUBSTR(:FlatFileVO.eventYard,1,5);

				boolean checkPodCdYN = false;
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkPodCd" +
							  "\n===============================================================\n");
					checkPodCdYN = dbDao.checkPodCd( flatFileForGateNewVO.getBkgNumber()[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.checkPodCd] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.checkPodCd] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( !checkPodCdYN ) {
	            	newSightCd = "I";

				} else {
	            	newSightCd = "N";

				}
	    	}
	        flatFileForGateNewVO.setSightCd(newSightCd);


		}    
		else if ( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M"))
				 && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) ) {

	        flatFileForGateNewVO.setSightCd("I");

		}   
		else if ( flatFileForGateNewVO.getGateIo().equals("AL") && flatFileForGateNewVO.getContStat().equals("F")
			   && (flatFileForGateNewVO.getSightCd() == null || flatFileForGateNewVO.getSightCd().equals("")) ) {

	        flatFileForGateNewVO.setSightCd("I");

		}

		return flatFileForGateNewVO;
	}


	/**
	 * insertEDIMessage for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 *
	 * edi_sts.pc
	 **/
	private FlatFileForGateNewVO insertEDIMessage( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String[] returnValues = null;
		String returnValue = "";

//	    EXEC SQL
//	    SELECT  DECODE(:FlatFileVO.msgId, "322", "A1", "COD", "A3", "PRV", "A3", "222", "B1", "XX"),
//	            TO_CHAR(SYSDATE,"RRMMDD")
//	    INTO    :FlatFileVO.ediId,
//	            :FlatFileVO.muidDt
//	    FROM    DUAL;

		returnValues = new String[2];
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getEdiIdfromDual" +
					  "\n===============================================================\n");
			returnValues = dbDao.getEdiIdfromDual( flatFileForGateNewVO.getMsgId() );
			flatFileForGateNewVO.setEdiId(returnValues[0]);
			flatFileForGateNewVO.setMuidDt(returnValues[1]);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getEdiIdfromDual] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getEdiIdfromDual] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		// final bkgNumber, bkgCount setting
		String bkgNumber = "";
		int bkgCount = 0;
		for ( int i=0; i<flatFileForGateNewVO.getBkgNumber().length ; i++ ) {
			if (flatFileForGateNewVO.getBkgNumber()[i] != null && !flatFileForGateNewVO.getBkgNumber()[i].trim().equals("") ) {
				bkgCount++;
				if (bkgCount == 1) {
					bkgNumber = flatFileForGateNewVO.getBkgNumber()[i];
				} else {
					bkgNumber = bkgNumber + "," + flatFileForGateNewVO.getBkgNumber()[i];
				}
			}
		}
		flatFileForGateNewVO.setBkgCount(bkgCount + "");
		flatFileForGateNewVO.setBkgNumber(bkgNumber.split(","));
		// BkgNumber[0](배열0번째)를 BkgNumber0 에 setting
		flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0] == null ? "" : flatFileForGateNewVO.getBkgNumber()[0] + "");
		// Single Queto처리
		flatFileForGateNewVO.setResultMessage((flatFileForGateNewVO.getResultMessage() == null || flatFileForGateNewVO.getResultMessage().equals(""))? "": flatFileForGateNewVO.getResultMessage().replaceAll("'", "^#^"));

//	    EXEC SQL
//	    SELECT    MAX(MVMT_EDI_MSG_SEQ) + 1
//	    INTO    :FlatFileVO.muidSeq
//	    FROM    CTM_MVMT_EDI_MSG
//	    WHERE    MVMT_EDI_TP_CD = :FlatFileVO.ediId
//	    AND        MVMT_EDI_MSG_TP_ID, = :FlatFileVO.msgId
//	    AND        MVMT_EDI_MSG_AREA_CD = :FlatFileVO.muidArea
//	    AND        MVMT_EDI_MSG_YRMONDY = :FlatFileVO.muidDt
//	    FOR        UPDATE;

		returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getMaxMuidSeq" +
					  "\n===============================================================\n");
			/* 원본쿼리 - 현재 임시 시퀀스 적용중
			SELECT MAX (MVMT_EDI_MSG_SEQ) + 1 AS MVMT_EDI_MSG_SEQ
			  FROM CTM_MVMT_EDI_MSG
			 WHERE MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]
			   AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]
			   AND MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]
			   AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]
			*/
			returnValue = dbDao.getMaxMuidSeq( flatFileForGateNewVO.getEdiId(), flatFileForGateNewVO.getMsgId(), flatFileForGateNewVO.getMuidArea(), flatFileForGateNewVO.getMuidDt() );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getMaxMuidSeq] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getMaxMuidSeq] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			flatFileForGateNewVO.setMuidSeq("1");

		} else {
			flatFileForGateNewVO.setMuidSeq(returnValue);

		}

//	    EXEC SQL
//	    INSERT INTO    CTM_MVMT_EDI_MSG
//	        (
//	            MVMT_EDI_TP_CD,
//	            MVMT_EDI_MSG_TP_ID,                MVMT_EDI_MSG_AREA_CD,
//	            MVMT_EDI_MSG_YRMONDY,            MVMT_EDI_MSG_SEQ,
//	            TML_NM,                            CNTR_NO,
//	            EVNT_YD_CD,                        EVNT_DT,
//	            EDI_GATE_IO_CD,                    CNTR_FULL_STS_CD,
//	            CHSS_NO,
//	            CRNT_VSL_CD,                    CRNT_SKD_VOY_NO,                CRNT_SKD_DIR_CD,
//	            BL_NO,                            BL_NO_TP,                        BL_NO_CHK
//	            BKG_KNT,                        BKG_NO,
//	            BKG_POL_CD,                        BKG_POD_CD
//	            DEST_YD_CD,                        CNTR_SEAL_NO,
//	        /*    MGST_NO        */
//	            VNDR_SEQ
//	            MVMT_TRSP_MOD_CD,                FCAR_NO,                        EDI_MVMT_STS_CD
//	            CNTR_HNGR_RCK_FLG,                WBL_NO,                            PKUP_NO
//	            MVMT_EDI_RSLT_CD,                MVMT_EDI_RMK,
//	            RTY_KNT,
//	            MVMT_EDI_SGHT_CD,                CNTR_DMG_FLG,
//	            CALL_SGN_NO,                    LLOYD_NO,
//	            MVMT_EDI_STS_TP_FLG,            OFC_CD,                            CNMV_CO_CD,
//	            CRE_USR_ID,                        UPD_USR_ID,                        CRE_DT
//	            CRE_LOCL_DT,                    UPD_DT,                            UPD_LOCL_DT,
//	            CNTR_TPSZ_CD,					EDI_BKG_NO			/* <---- 2010.02.17 By IHChang */
//	        )
//	    VALUES
//	        (
//	            FlatFileVO.ediId,
//	            FlatFileVO.msgId,                FlatFileVO.muidArea,
//	            FlatFileVO.muidDt,                FlatFileVO.muidSeq,
//	            FlatFileVO.termId,                FlatFileVO.cntrNumber,
//	            FlatFileVO.eventYard,            TO_DATE(:eventDate, "ddMonrr hh24:mi"),
//	            FlatFileVO.gateIo,                FlatFileVO.cont_stat,
//	            FlatFileVO.chssCode,
//	            FlatFileVO.vessel,                FlatFileVO.voyage,                        FlatFileVO.dir,
//	            SUBSTR(FlatFileVO.blNo,1,10),    SUBSTR(FlatFileVO.blNo,11,1),            SUBSTR(FlatFileVO.blNo,12,1),
//	            FlatFileVO.bkgCount,            FlatFileVO.bkgNumber,
//	            FlatFileVO.pol,                    FlatFileVO.pod,
//	            FlatFileVO.destLoc,                FlatFileVO.sealNo,
//	        /*    #####    */
//	            FlatFileVO.vndr_seq,
//	            FlatFileVO.transMode,            FlatFileVO.flatCarNbr,                    FlatFileVO.mvmtStatus,
//	            FlatFileVO.hangerTag,            FlatFileVO.wayBillNo,                    FlatFileVO.pickupNo,
//	            FlatFileVO.resultMessage_ind,    FlatFileVO.resultMessage,        
//	            0,
//	            FlatFileVO.sightCd,                FlatFileVO.dmgFlag,
//	            FlatFileVO.callSignNo,            FlatFileVO.lloydNo,
//	            FlatFileVO.mvmt_edi_sts_tp_flg,    FlatFileVO.eventYard,            "COM",
//	            "GATENEW",                        "GATENEW"                        SYSDATE,
//	            #####(sysdate의 Local time),    SYSDATE,                        #####(sysdate의 Local time)
//				FlatFileVO.cntrTpszCd,			FlatFileVO.ediBkgNo				/* <---- 2010.02.17 By IHChang */
//	        );

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.insertEDIMessage" +
					  "\n===============================================================\n");
			dbDao.insertEDIMessage(flatFileForGateNewVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.insertEDIMessage] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.insertEDIMessage] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

//      EXEC SQL
//      INSERT INTO CTM_MVMT_EDI_BKG
//          (
//              MVMT_EDI_TP_CD,
//              MVMT_EDI_MSG_TP_ID,            MVMT_EDI_MSG_AREA_CD,
//              MVMT_EDI_MSG_YRMONDY,        MVMT_EDI_MSG_SEQ,
//              BKG_NO,
//              CRE_USR_ID,                    CRE_DT
//              UPD_USR_ID,                    UPD_DT
//          ) VALUES (
//              FlatFileVO.ediId,
//              FlatFileVO.msgId,            FlatFileVO.muidArea,
//              TO_CHAR(SYSDATE,"RRMMDD"),    FlatFileVO.muidSeq,
//              FlatFileVO.bkgNumber[p],
//              "GATENEW",                    SYSDATE,
//              "GATENEW",                    SYSDATE
//          );

		// insertEDIBooking
		CtmMvmtEdiBkgVO ctmMvmtEdiBkgVo = null;
		for ( int p=1; p<flatFileForGateNewVO.getBkgNumber().length ; p++ ) {
			if (flatFileForGateNewVO.getBkgNumber()[p] != null && !flatFileForGateNewVO.getBkgNumber()[p].equals("") ) {
				ctmMvmtEdiBkgVo = new CtmMvmtEdiBkgVO();
				ctmMvmtEdiBkgVo.setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
				ctmMvmtEdiBkgVo.setCreUsrId(flatFileForGateNewVO.getUserId());
			    // BkgNumber[](배열) setting
				ctmMvmtEdiBkgVo.setBkgNo(flatFileForGateNewVO.getBkgNumber()[p]);
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.insertEDIBooking(ctmMvmtEdiBkgVo)[" + p + "]" +
							  "\n===============================================================\n");
					dbDao.insertEDIBooking(ctmMvmtEdiBkgVo);
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.insertEDIBooking] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.insertEDIBooking] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
			}
		}

		return flatFileForGateNewVO;
	}


	/**
	 * resultUpdb for GateNew / EES_CTM_0404 multi event
	 * handling multiple event for EDI Movement
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO resultUpdb( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		log.debug("\n\n============================== resultIndicator : " + searchEDIMovementListVO.getMvmtEdiRsltCd() +
				  "\n================================ resultMessage : " + searchEDIMovementListVO.getMvmtEdiRmk() + "\n");
		com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO dbDaoMgt =
			new com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO();

		boolean bUpdateMovement = false;
		
		if ( "ALEADY ACCEPT".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 13).toUpperCase())
		  || "NOT ACCEPT CONTAINER!".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 21).toUpperCase())
		  || "NOT ACCEPT CONTAINER(3)".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 23).toUpperCase())
		  || "915, ALEADY ACCEPT CNTR".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 23).toUpperCase())
		  || (!"Y".equals(searchEDIMovementListVO.getEdiUiYn())
				  && "EVENT DATE IS EARLIER THAN LAST".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 31).toUpperCase())) )  {


				if (!"Y".equals(searchEDIMovementListVO.getEdiUiYn())
				  && "EVENT DATE IS EARLIER THAN LAST EVENT DATE IN CTM.".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 50).toUpperCase())){
				boolean existMvmt = false;
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDaoMgt.existEDIMovementList - check EDI Movement exist in CTM_MOVEMENT" +
							  "\n===============================================================\n");
					existMvmt = dbDaoMgt.existEDIMovementList(searchEDIMovementListVO);
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.existEDIMovementList] DAOerr : " + ex.toString(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.existEDIMovementList] DAOerr : " + ex.toString(), ex);
				}
				if(existMvmt) {
					bUpdateMovement = true;
			    	searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED (" + searchEDIMovementListVO.getMvmtEdiRmk() + ")");
			    	searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
				}
			}
			

	    } else if ( "THE SAME DATA".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 13).toUpperCase()) ) {    /* Same Data Check추가 - 2009.05.12 */
	    	searchEDIMovementListVO.setMvmtEdiRsltCd("I");

	    } else if ( "ALREADY CREATED".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 15).toUpperCase()) ) {   
	    	searchEDIMovementListVO.setMvmtEdiRsltCd("I");

	    } else {
		    if ( (searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk().trim())) && !"N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd().trim()) ) {
				searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
				if ( searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk()) ) {
					searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED");
				}
			}
	    }

		// handling Single Queto
		searchEDIMovementListVO.setMvmtEdiRmk((searchEDIMovementListVO.getMvmtEdiRmk() == null || searchEDIMovementListVO.getMvmtEdiRmk().equals(""))? "":searchEDIMovementListVO.getMvmtEdiRmk().replaceAll("'", "^#^"));
		searchEDIMovementListVO.setCnmvRmk((searchEDIMovementListVO.getCnmvRmk() == null || searchEDIMovementListVO.getCnmvRmk().equals(""))? "":searchEDIMovementListVO.getCnmvRmk().replaceAll("'", "^#^"));
		searchEDIMovementListVO.setBkgNo((searchEDIMovementListVO.getBkgNo() == null || searchEDIMovementListVO.getBkgNo().equals(""))? "":subStr(searchEDIMovementListVO.getBkgNo(), 0, 13));
		
		if(!"Y".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) ){
		   try {
			   log.debug("\n\n===============================================================" +
					   "\n dbDaoMgt.checkEdiMessage" +
					   "\n===============================================================\n");
			   int rtnCnt = dbDao.checkEdiMessage(searchEDIMovementListVO.getCntrNo(), searchEDIMovementListVO.getEvntYdCd(), searchEDIMovementListVO.getEvntDt(), searchEDIMovementListVO.getEdiGateIoCd());
		   
			   if(rtnCnt>1){
				   searchEDIMovementListVO.setMvmtEdiRmk("The same message already exist!");
				   searchEDIMovementListVO.setMvmtEdiRsltCd("I");
		       }
		   } catch (DAOException ex) {
			   log.error("[GATENEW : dbDao.updateEDIMessage] DAOerr : " + ex.toString(), ex);
			   throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		   } catch (Exception ex) {
			   log.error("[GATENEW : dbDao.updateEDIMessage] err : " + ex.toString(), ex);
			   throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		   }
		} 
		
		if ("X".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())
				&& "STATUS CHANGE".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 13).toUpperCase())) {
			searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED (" + searchEDIMovementListVO.getMvmtEdiRmk() + ")");
	    	searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
		}

		// inserting to CTM_EDI_RSLT_RMK table
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDaoMgt.addManageEDIResult - CTM_EDI_RSLT_RMK테이블 insert" +
					  "\n===============================================================\n");
			dbDaoMgt.addManageEDIResult(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.addManageEDIResult] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.addManageEDIResult] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

//	    EXEC SQL
//	    UPDATE CTM_MVMT_EDI_MSG
//	    SET    MVMT_EDI_RSLT_CD = :FlatFileVO.resultIndicator
//	           MVMT_EDI_RMK = :FlatFileVO.resultMessage
//	    WHERE  MVMT_EDI_TP_CD = :FlatFileVO.ediId
//	    AND    MVMT_EDI_MSG_TP_ID = :FlatFileVO.msgid
//	    AND    MVMT_EDI_MSG_AREA_CD = :FlatFileVO.muidArea
//	    AND    MVMT_EDI_MSG_YRMONDY = :FlatFileVO.muidDt
//	    AND    MVMT_EDI_MSG_SEQ = :FlatFileVO.muidSeq;

		// updateEDIMessage
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDaoMgt.modifyManageEDIMovement" +
					  "\n===============================================================\n");
			dbDaoMgt.modifyManageEDIMovement(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.updateEDIMessage] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.updateEDIMessage] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		//UPDATE  /*+INDEX_DESC(A XAK2CTM_MOVEMENT)*/
//      CTM_MOVEMENT A
//  SET A.CNMV_EVNT_DT = TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS'),
//      A.CNMV_RMK = 'event date updated by system',
//      A.UPD_USR_ID = @[usr_id],
//      A.UPD_LOCL_DT = GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, SUBSTR (@[evnt_yd_cd], 0, 5 )),
//      A.UPD_DT = SYSDATE
//WHERE A.CNTR_NO   = @[cntr_no]
//  AND A.ORG_YD_CD = @[evnt_yd_cd]
//  AND A.MVMT_CRE_TP_CD = 'A'
//  AND A.MVMT_STS_CD = @[edi_mvmt_sts_cd]
//  -- 새로 들어온 EVENT DATE는 기존 EDI RECEIVING DATE 보다 72H 내의  이전이어야 한다.
//  AND A.CRE_LOCL_DT <= TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') + 72/24
//  -- 새로 들어온 EVENT DATE가 이전과 이후의 EVENT DATE 사이여야 한다. (즉, CNMV_SEQ는 변하지 않아아 한다.
//  AND TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') BETWEEN
//      (
//        SELECT /*+INDEX_DESC(X XUK1CTM_MOVEMENT)*/
//               X.CNMV_EVNT_DT
//          FROM CTM_MOVEMENT X
//         WHERE X.CNTR_NO = A.CNTR_NO
//           AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') < A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')
//           AND ROWNUM    = 1
//      )
//      AND
//      (
//        SELECT /*+INDEX(X XUK1CTM_MOVEMENT)*/
//               X.CNMV_EVNT_DT
//          FROM CTM_MOVEMENT X
//         WHERE X.CNTR_NO = A.CNTR_NO
//           AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') > A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')
//           AND ROWNUM    = 1
//      )
//  AND ROWNUM = 1		

		try {
			if (bUpdateMovement){
				log.debug("\n\n===============================================================" +
						  "\n dbDaoMgt.modifyCtmMovementEvntDtAfterAutoCre" +
						  "\n===============================================================\n");			
				dbDaoMgt.modifyCtmMovementEvntDtAfterAutoCre(searchEDIMovementListVO);
			}
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.modifyCtmMovementEvntDtAfterAutoCre] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.modifyCtmMovementEvntDtAfterAutoCre] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		return searchEDIMovementListVO;
	}


	/**
	 * assignCommonVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param int bkgKnt
	 * @return CusCtmMovementVO[]
	 * @exception EventException
	 **/
	public CusCtmMovementVO[] assignCommonVO( FlatFileForGateNewVO flatFileForGateNewVO, int bkgKnt ) throws EventException {
		/* creating vo as count of bkg_no array count */
		CusCtmMovementVO[] cusCtmMovementVOs = new CusCtmMovementVO[bkgKnt];

		try {
			for (int i = 0; i < bkgKnt; i++) {
				cusCtmMovementVOs[i] = new CusCtmMovementVO();

				cusCtmMovementVOs[i].setBkgNo((flatFileForGateNewVO.getBkgNumber()[i] == null ? "" : flatFileForGateNewVO.getBkgNumber()[i]));		
			    cusCtmMovementVOs[i].setBlNo(subStr(flatFileForGateNewVO.getBlNo(), 0, 12));    // MQ EDI로 12자리 이상이 넘어오므로 짤라서 넘김
			    cusCtmMovementVOs[i].setCallSgnNo(flatFileForGateNewVO.getCallSignNo());
			    cusCtmMovementVOs[i].setChssNo(flatFileForGateNewVO.getChssCode());
				cusCtmMovementVOs[i].setCnmvEvntDt(flatFileForGateNewVO.getEventDate());    // yyyyMMddHHmm형식 (초까지 넘어가지 않게)
				cusCtmMovementVOs[i].setCnmvYr(DateTime.getFormatDate(new java.util.Date(), "yyyy"));
				cusCtmMovementVOs[i].setCntrDmgFlg(flatFileForGateNewVO.getDmgFlag());
				cusCtmMovementVOs[i].setDmgFlgDt(flatFileForGateNewVO.getDmgFlgDt());
				cusCtmMovementVOs[i].setDmgUnflgDt(flatFileForGateNewVO.getDmgUnflgDt());
				cusCtmMovementVOs[i].setCntrHngrRckFlg(flatFileForGateNewVO.getHangerTag());
				cusCtmMovementVOs[i].setCntrNo(flatFileForGateNewVO.getCntrNumber());
				cusCtmMovementVOs[i].setCntrSealNo(flatFileForGateNewVO.getSealNo());
				cusCtmMovementVOs[i].setCreUsrId(flatFileForGateNewVO.getUserId());
				cusCtmMovementVOs[i].setCrntSkdDirCd(flatFileForGateNewVO.getDir());
				cusCtmMovementVOs[i].setCrntSkdVoyNo(flatFileForGateNewVO.getVoyage());
				cusCtmMovementVOs[i].setCrntVslCd(flatFileForGateNewVO.getVessel());

			    String fullEmptyFlag = (flatFileForGateNewVO.getContStat() == null ? "" : String.valueOf(flatFileForGateNewVO.getContStat()));
				if ("F".equals(fullEmptyFlag) || "L".equals(fullEmptyFlag) || "AH".equals(fullEmptyFlag)) {
					cusCtmMovementVOs[i].setFcntrFlg("F");
				} else if ("M".equals(fullEmptyFlag) || "E".equals(fullEmptyFlag) || "AB".equals(fullEmptyFlag) || "AJ".equals(fullEmptyFlag)) {
					cusCtmMovementVOs[i].setFcntrFlg("M");
			    } else {
			    	cusCtmMovementVOs[i].setFcntrFlg("F");
				}

				cusCtmMovementVOs[i].setLloydNo(flatFileForGateNewVO.getLloydNo());
			    cusCtmMovementVOs[i].setMgstNo(flatFileForGateNewVO.getMgSet());
				cusCtmMovementVOs[i].setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
				cusCtmMovementVOs[i].setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
				cusCtmMovementVOs[i].setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
				cusCtmMovementVOs[i].setMvmtEdiMsgYrmondy(flatFileForGateNewVO.getMuidDt());
				cusCtmMovementVOs[i].setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
				cusCtmMovementVOs[i].setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			    cusCtmMovementVOs[i].setMvmtTrspModCd(flatFileForGateNewVO.getTransMode());
				cusCtmMovementVOs[i].setOfcCd("");
				cusCtmMovementVOs[i].setOrgYdCd(flatFileForGateNewVO.getEventYard());
				cusCtmMovementVOs[i].setPkupNo(flatFileForGateNewVO.getPickupNo());
				cusCtmMovementVOs[i].setDestYdCd(flatFileForGateNewVO.getDestLoc());
				if (flatFileForGateNewVO.getMvmtStatus().equals("VD")) {
				    cusCtmMovementVOs[i].setPodCd(subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				} else if (flatFileForGateNewVO.getMvmtStatus().equals("VL")) {
					cusCtmMovementVOs[i].setPolCd(subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				}
				cusCtmMovementVOs[i].setUpdUsrId(flatFileForGateNewVO.getUserId());
				cusCtmMovementVOs[i].setUsrNm(flatFileForGateNewVO.getUserNm());
			    cusCtmMovementVOs[i].setVndrSeq(flatFileForGateNewVO.getVndrSeq());
				cusCtmMovementVOs[i].setWblNo(flatFileForGateNewVO.getWayBillNo());
				
				//EDI F/F 변경에 따른 추가 작업.[2014.09.01]
				cusCtmMovementVOs[i].setWoNo(flatFileForGateNewVO.getWoNo());
				cusCtmMovementVOs[i].setEdiVvdCd(flatFileForGateNewVO.getEdiVvdCd());
				cusCtmMovementVOs[i].setTirNo(flatFileForGateNewVO.getTirNo());
				cusCtmMovementVOs[i].setMtyPlnNo(flatFileForGateNewVO.getMtyPlnNo());
				cusCtmMovementVOs[i].setMtyRepoNo(flatFileForGateNewVO.getMtyRepoNo());
				cusCtmMovementVOs[i].setEdiCrrNo(flatFileForGateNewVO.getEdiCrrNo());
				cusCtmMovementVOs[i].setTrspDocNo(flatFileForGateNewVO.getTrspDocNo());
				cusCtmMovementVOs[i].setVgmDocIdNo(flatFileForGateNewVO.getVgmDocIdNo());
				cusCtmMovementVOs[i].setVgmWgt(flatFileForGateNewVO.getVgmWgt());
				if ("K".equals(flatFileForGateNewVO.getVgmEdiWgtUtCd())) {
					cusCtmMovementVOs[i].setVgmWgtUtCd("KGS");
				} else {
					cusCtmMovementVOs[i].setVgmWgtUtCd("LBS");
				}
				cusCtmMovementVOs[i].setVgmDocTpCd(flatFileForGateNewVO.getVgmDocTpCd());
				cusCtmMovementVOs[i].setVgmDtTpCd(flatFileForGateNewVO.getVgmDtTpCd());
				cusCtmMovementVOs[i].setVgmHndlDt(flatFileForGateNewVO.getVgmHndlDt());
				cusCtmMovementVOs[i].setVgmCustCntcTpCd(flatFileForGateNewVO.getVgmCustCntcTpCd());
				cusCtmMovementVOs[i].setVgmCustCntcNm(flatFileForGateNewVO.getVgmCustCntcNm());
				cusCtmMovementVOs[i].setVgmCustFaxNo(flatFileForGateNewVO.getVgmCustFaxNo());
				cusCtmMovementVOs[i].setVgmCustEml(flatFileForGateNewVO.getVgmCustEml());
				cusCtmMovementVOs[i].setVgmCustPhnNo(flatFileForGateNewVO.getVgmCustPhnNo());
				cusCtmMovementVOs[i].setVgmCustAddr(flatFileForGateNewVO.getVgmCustAddr());
				
				cusCtmMovementVOs[i].setUsaEdiCd(flatFileForGateNewVO.getCarrierCode());
				cusCtmMovementVOs[i].setCntrStwgPsnCtnt(flatFileForGateNewVO.getCntrStwgPsnCtnt());
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return cusCtmMovementVOs;
	}

	/**
	 * assignSPPVO2FlatFileVO for GateNew<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignSPPVO2FlatFileVO( CusCtmMovementVO cusCtmMovementVO ) throws EventException {
		FlatFileForGateNewVO flatFileForGateNewVO = new FlatFileForGateNewVO();
		try {
			
			flatFileForGateNewVO.setFfileRrefNo("SPP:11111111");
			flatFileForGateNewVO.setMsgId("SPP");
			flatFileForGateNewVO.setCntrNumber(cusCtmMovementVO.getCntrNo());
			flatFileForGateNewVO.setTermId(cusCtmMovementVO.getCreUsrId());
			flatFileForGateNewVO.setUserId("ESVCUSER");
			flatFileForGateNewVO.setUserNm(cusCtmMovementVO.getUsrNm());
			flatFileForGateNewVO.setEventYard(cusCtmMovementVO.getOrgYdCd());
			flatFileForGateNewVO.setMuidArea(dbDao2.searchUserLocalCode(flatFileForGateNewVO.getEventYard().substring(0,2)));
			flatFileForGateNewVO.setEventDate(cusCtmMovementVO.getCnmvEvntDt());
			flatFileForGateNewVO.setMvmtStatus(cusCtmMovementVO.getMvmtStsCd());
			flatFileForGateNewVO.setContStat(cusCtmMovementVO.getFcntrFlg()); // VL/VD FcntrFlag 추가 예정
			flatFileForGateNewVO.setSightCd(cusCtmMovementVO.getObCntrFlg());
			
			//Gate IO Code & Movement Status Logic
			if (flatFileForGateNewVO.getMvmtStatus().equals("VL") || flatFileForGateNewVO.getMvmtStatus().equals("VD")) {
				if (flatFileForGateNewVO.getMvmtStatus().equals("VL")) {
					flatFileForGateNewVO.setGateIo("AE");
				} else {
					flatFileForGateNewVO.setGateIo("UV");
				}
				flatFileForGateNewVO.setMvmtStatus("ZZ");
			} else if (flatFileForGateNewVO.getMvmtStatus().equals("OC") || flatFileForGateNewVO.getMvmtStatus().equals("IC") || flatFileForGateNewVO.getMvmtStatus().equals("MT")) {
				flatFileForGateNewVO.setGateIo("I");
			} else if (flatFileForGateNewVO.getMvmtStatus().equals("ST")) {
				flatFileForGateNewVO.setGateIo("ST");
			} else {
				flatFileForGateNewVO.setGateIo("O");
			}
						
			flatFileForGateNewVO.setChssCode(cusCtmMovementVO.getChssNo());
			flatFileForGateNewVO.setCallSignNo(cusCtmMovementVO.getCallSgnNo());
			flatFileForGateNewVO.setLloydNo(cusCtmMovementVO.getLloydNo());
			flatFileForGateNewVO.setBlNo(cusCtmMovementVO.getBlNo());
			flatFileForGateNewVO.setPol(cusCtmMovementVO.getPolCd());
			flatFileForGateNewVO.setPod(cusCtmMovementVO.getPodCd());
			flatFileForGateNewVO.setDestLoc(cusCtmMovementVO.getDestYdCd());
			flatFileForGateNewVO.setDestNm("");
			flatFileForGateNewVO.setDestSte("");
			
			//Damage Flag Logic
			flatFileForGateNewVO.setDmgFlag(cusCtmMovementVO.getCntrDmgFlg());
			if (flatFileForGateNewVO.getDmgFlag().equals("Y")) {
				flatFileForGateNewVO.setDmgFlgDt(flatFileForGateNewVO.getEventDate());
			} else if (flatFileForGateNewVO.getDmgFlag().equals("N")) {
				flatFileForGateNewVO.setDmgUnflgDt(flatFileForGateNewVO.getEventDate());
			}
			
			flatFileForGateNewVO.setPickupNo(cusCtmMovementVO.getPkupNo());
			flatFileForGateNewVO.setMgSet(cusCtmMovementVO.getMgstNo());
			flatFileForGateNewVO.setSubstitution("");
			flatFileForGateNewVO.setCarrierCountry("");
			flatFileForGateNewVO.setTransMode(cusCtmMovementVO.getMvmtTrspModCd());
			flatFileForGateNewVO.setFlatCarNbr("");
			flatFileForGateNewVO.setHangerTag(cusCtmMovementVO.getCntrHngrRckFlg());
			flatFileForGateNewVO.setWayBillNo(cusCtmMovementVO.getWblNo());
			flatFileForGateNewVO.setDelTag("");
			flatFileForGateNewVO.setSealNo(cusCtmMovementVO.getCntrSealNo());
			
			// Booking Number & EQR Reference Number Logic
			String[] bkgNoArray = new String[1];
			if (cusCtmMovementVO.getBkgNo().indexOf("NYKS")==-1) {
				if (cusCtmMovementVO.getBkgNo().indexOf("NYKA")==-1) {
					bkgNoArray[0] = cusCtmMovementVO.getBkgNo();
				} else {
					bkgNoArray[0] = cusCtmMovementVO.getBkgNo().substring(cusCtmMovementVO.getBkgNo().indexOf("NYKA")+4);
				}
			} else {
				bkgNoArray[0] = cusCtmMovementVO.getBkgNo().substring(cusCtmMovementVO.getBkgNo().indexOf("NYKS")+4);
			}

			String lstmCd = "";
			
//			/***** 2009.05.08 : Container No Check Using CONTAINER Table *****/			 
//			if ( flatFileForGateNewVO.getCntrNumber().length() >= 10 ) {
//
////				EXEC SQL
////				SELECT	CNTR_NO
////				INTO	:FlatFileVO.cntrNumber
////				FROM	(
////							SELECT	CNTR_NO
////							FROM	MST_CONTAINER
////							/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
////							WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
////							ORDER BY
////									CNMV_DT DESC
////						)
////				WHERE	ROWNUM  = 1
//
//				String cntrNumber = "";
//				log.debug("\n\n===============================================================" +
//						  "\n dbDao.getCntrNo(cntrNo)" +
//						  "\n===============================================================\n");
//				cntrNumber = dbDao.getCntrNo(flatFileForGateNewVO.getCntrNumber());
//				
//				if ( cntrNumber != null && !("").equals(cntrNumber) ) {
//					flatFileForGateNewVO.setCntrNumber(cntrNumber);
//					
//					log.debug("\n\n===============================================================" +
//							  "\n dbDao.getAciacDivCd" +
//							  "\n===============================================================\n");
//					lstmCd = dbDao.getAciacDivCd(flatFileForGateNewVO.getCntrNumber())[1];
//				}				
//			}
			String cntrNumber = "";
			/***** 2009.05.08 : Container No Check Using CONTAINER Table *****/			 
			if ( flatFileForGateNewVO.getCntrNumber().length() == 10 ) {
				int count = 0;
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNoCount(cntrNo)" +
						  "\n===============================================================\n");
				count = dbDao.getCntrNoCount(flatFileForGateNewVO.getCntrNumber());
				
				if (count < 2) {
//					EXEC SQL
//					SELECT	CNTR_NO
//					INTO	:FlatFileVO.cntrNumber
//					FROM	(
//								SELECT	CNTR_NO
//								FROM	MST_CONTAINER
//								/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
//								WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
//								ORDER BY
//										CNMV_DT DESC
//							)
//					WHERE	ROWNUM  = 1

					log.debug("\n\n===============================================================" +
							  "\n dbDao.getCntrNo(cntrNo)" +
							  "\n===============================================================\n");
					cntrNumber = dbDao.getCntrNo(flatFileForGateNewVO.getCntrNumber());
				}				
			} else {
				
//				EXEC SQL
//				SELECT	CNTR_NO
//				INTO	:FlatFileVO.cntrNumber
//				FROM	(
//							SELECT	CNTR_NO
//							FROM	MST_CONTAINER
//							/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
//							WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
//							ORDER BY
//									CNMV_DT DESC
//						)
//				WHERE	ROWNUM  = 1

				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNoNotLike(cntrNo)" +
						  "\n===============================================================\n");
				cntrNumber = dbDao.getCntrNoNotLike(flatFileForGateNewVO.getCntrNumber());			
			}

			if ( cntrNumber != null && !("").equals(cntrNumber) ) {
				flatFileForGateNewVO.setCntrNumber(cntrNumber);
				
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getAciacDivCd" +
						  "\n===============================================================\n");
				lstmCd = dbDao.getAciacDivCd(flatFileForGateNewVO.getCntrNumber())[1];
			}
			
			flatFileForGateNewVO.setLstmCd(lstmCd);
			
			//EQR Reference Number check 
			if ( flatFileForGateNewVO.getContStat().equals("M") && !flatFileForGateNewVO.getLstmCd().equals("SH") ) {
				if ( flatFileForGateNewVO.getMvmtStatus().equals("WW") || flatFileForGateNewVO.getMvmtStatus().equals("TN") || flatFileForGateNewVO.getMvmtStatus().equals("EN") || flatFileForGateNewVO.getMvmtStatus().equals("MT") ) {
//					SELECT MVMT_STS_CD, FCNTR_FLG, MTY_PLN_NO, MTY_REPO_NO
//					FROM CTM_MOVEMENT
//					WHERE CNTR_NO = flatFileForGateNewVO.getCntrNumber()
//					AND ROWNUM=1
//					ORDER BY CNMV_YR DESC, CNMV_SEQ DESC, CNMV_SPLIT_NO DESC
					String[] prevMvmt = new String[4];
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkPrevMvmt" +
							  "\n===============================================================\n");
					prevMvmt = dbDao.checkPrevMvmt(flatFileForGateNewVO.getCntrNumber());
					
					if ( prevMvmt != null && !"".equals(prevMvmt) ) {					
						if ( (prevMvmt[0].equals("EN") || prevMvmt[0].equals("TN") || prevMvmt[0].equals("MT") || prevMvmt[0].equals("CM") ) && prevMvmt[1].equals("N") ) {
							flatFileForGateNewVO.setEdiMtyEqRepoRefNo(cusCtmMovementVO.getBkgNo());
							flatFileForGateNewVO.setMtyPlnNo(cusCtmMovementVO.getBkgNo());
							flatFileForGateNewVO.setMtyRepoNo("");
							bkgNoArray[0] = "";
						}
					}
				}
			} else {
				flatFileForGateNewVO.setEdiMtyEqRepoRefNo("");
				flatFileForGateNewVO.setMtyPlnNo("");
				flatFileForGateNewVO.setMtyRepoNo("");
			}
			flatFileForGateNewVO.setBkgNumber(bkgNoArray);
			flatFileForGateNewVO.setBkgNumber0(bkgNoArray[0]);
			flatFileForGateNewVO.setEdiBkgNo(bkgNoArray[0]);
			if (flatFileForGateNewVO.getBkgNumber0() == null || flatFileForGateNewVO.getBkgNumber0().equals("")) {
				flatFileForGateNewVO.setBkgCount("0");
			} else {
				flatFileForGateNewVO.setBkgCount("1");
			}
			
			flatFileForGateNewVO.setWoNo(cusCtmMovementVO.getWoNo());

			if (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) {
				flatFileForGateNewVO.setEdiVvdCd(cusCtmMovementVO.getCrntVslCd()+cusCtmMovementVO.getCrntSkdVoyNo()+cusCtmMovementVO.getCrntSkdDirCd());
			} else {
				flatFileForGateNewVO.setEdiVvdCd ("");
			}			
			flatFileForGateNewVO.setVslEngNm("");
			flatFileForGateNewVO.setCarrierCode(cusCtmMovementVO.getUsaEdiCd());
			flatFileForGateNewVO.setCntrStwgPsnCtnt(cusCtmMovementVO.getCntrStwgPsnCtnt());
			
			flatFileForGateNewVO.setTirNo(cusCtmMovementVO.getTirNo());
			flatFileForGateNewVO.setEdiCrrNo(cusCtmMovementVO.getEdiCrrNo());
			flatFileForGateNewVO.setTrspDocNo(cusCtmMovementVO.getTrspDocNo());
			flatFileForGateNewVO.setVgmDocIdNo(cusCtmMovementVO.getVgmDocIdNo());
			flatFileForGateNewVO.setVgmWgt(cusCtmMovementVO.getVgmWgt());
			flatFileForGateNewVO.setVgmEdiWgtUtCd(cusCtmMovementVO.getVgmWgtUtCd());
			flatFileForGateNewVO.setVgmDocTpCd(cusCtmMovementVO.getVgmDocTpCd());
			flatFileForGateNewVO.setVgmDtTpCd(cusCtmMovementVO.getVgmDtTpCd());
			flatFileForGateNewVO.setVgmHndlDt(cusCtmMovementVO.getVgmHndlDt());
			flatFileForGateNewVO.setVgmCustCntcTpCd(cusCtmMovementVO.getVgmCustCntcTpCd());
			flatFileForGateNewVO.setVgmCustCntcNm(cusCtmMovementVO.getVgmCustCntcNm());
			flatFileForGateNewVO.setVgmCustFaxNo(cusCtmMovementVO.getVgmCustFaxNo());
			flatFileForGateNewVO.setVgmCustEml(cusCtmMovementVO.getVgmCustEml());
			flatFileForGateNewVO.setVgmCustPhnNo(cusCtmMovementVO.getVgmCustPhnNo());
			flatFileForGateNewVO.setVgmCustAddr(cusCtmMovementVO.getVgmCustAddr());
			
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return flatFileForGateNewVO;
	}

	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @return FlatFileForGateNewVO[]
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO[] assignFlatFileVO( String flatFile ) throws EventException {
		FlatFileForGateNewVO[] flatFileVOs = null;
		String headerKey = "";
		String strGubunCd = "EDI"; 
		try {
			//  - allStringArray[0] : MQ Message header
			//  - allStringArray[1] : MQ Message contents[1] ~
			//  - allStringArray[x] : MQ Message header[x]
			String[] allStringArray = flatFile.toUpperCase().trim().split("\\{CNTR_MAIN");

			// MQ Message header (S) ================================================================
			
			if ( allStringArray[0] != null && !allStringArray[0].trim().equals("") ) {
				String tmpHeader = "";

				// 2014.1.03 fix NYK Header
//				if ( allStringArray[0].indexOf("UBIZ") > -1 ) {
//					tmpeHeader = allStringArray[0].substring(allStringArray[0].indexOf("UBIZ"));
//				} else if (allStringArray[0].indexOf("UDEV") > -1) {
//					tmpeHeader = allStringArray[0].substring(allStringArray[0].indexOf("UDEV"));
//				}
				
				if(allStringArray[0].indexOf("EDI") > 0 ){ 
					tmpHeader = allStringArray[0].substring(allStringArray[0].indexOf("EDI")); //MQProxy
				}else {
					tmpHeader = allStringArray[0].substring(allStringArray[0].indexOf("IEM")); //ovementMQProxy
					strGubunCd = "IEM";
				}
				
				//tmpHeader = allStringArray[0].substring(allStringArray[0].indexOf("EDI")); //MQProxy
				//if(tmpHeader.length() < 0) {
				//	tmpHeader = allStringArray[0].substring(allStringArray[0].indexOf("IEM")); //ovementMQProxy
				//	strGubunCd = "IEM";
				//}
				
				
				
				if ( tmpHeader.indexOf("EDI:") > -1 ) {
					headerKey = "EDI:" + tmpHeader.trim().split("EDI:", 2)[1];
				}else{
					headerKey = "IEM:" + tmpHeader.trim().split("IEM:", 2)[1];
				}
			}
			
			// MQ Message header (E) ================================================================

			// MQ Message content (S) ================================================================
			if ( allStringArray[1] != null && !allStringArray[1].trim().equals("") ) {
				flatFileVOs = new FlatFileForGateNewVO[allStringArray.length -1];
				FlatFileForGateNewVO flatFileVo = null;
				String[] oneCaseArray = null;
				String[] columneArray = null;
				StringBuilder strBkgNo = null;
				String[] bkgNoArray = null;
				int bkgKnt = 0;
				
				for ( int i=0; i<allStringArray.length -1; i++ ) {
					
					oneCaseArray = allStringArray[i +1].split("\n");
					flatFileVo = new FlatFileForGateNewVO();
					flatFileVo.setFfileRrefNo(subStr(headerKey, 0, 50));
					strBkgNo = new StringBuilder();
					
					for ( int k=0; k<oneCaseArray.length; k++ ) {
						if ( oneCaseArray[k].indexOf(":") > -1 ) {
							columneArray = new String[2];
							columneArray = oneCaseArray[k].split(":", 2);
							
							columneArray[0] = (columneArray[0] == null ? "" : columneArray[0].trim() + "");
							columneArray[1] = (columneArray[1] == null ? "" : columneArray[1].trim() + "");
							if ( "AREA".equals(columneArray[0]) ) {
								flatFileVo.setMuidArea(subStr(columneArray[1], 0, 3));
							} else if ( "MSG_ID".equals(columneArray[0]) ) {
								flatFileVo.setMsgId(subStr(columneArray[1], 0, 10));
							} else if ( "CNTR_NO".equals(columneArray[0]) ) {
								flatFileVo.setCntrNumber(subStr(columneArray[1], 0, 14));
							} else if ( "TMNL_ID".equals(columneArray[0]) ) {
								flatFileVo.setTermId(subStr(columneArray[1], 0, 50));
								flatFileVo.setUserNm(subStr(columneArray[1], 0, 20));    // setting Terminal ID 20 characters as User Name in case of EDI
							} else if ( "EVENT_YARD".equals(columneArray[0]) ) {
								flatFileVo.setEventYard(subStr(columneArray[1], 0, 7));
								
								if("IEM".equals(strGubunCd.trim())) {
									String strYdCd = dbDao.getMdmYardYdCd(columneArray[1]);
									flatFileVo.setEventYard(strYdCd); //searchYardCodeForFacilityCode search
							         // searchUserLocalCode는 ContainerMovementValidationDBDAO의 쿼리
								}
								
								if(flatFileVo.getEventYard()!=null && !flatFileVo.getEventYard().equals("")){
									flatFileVo.setMuidArea(dbDao2.searchUserLocalCode(flatFileVo.getEventYard().substring(0, 2))); //IEM인 경우 AREA CODE를 조회해서 사용.	
								} else {
									flatFileVo.setEventYard("NO_YARD");
								}
								
							} else if ( "EVENT_DT".equals(columneArray[0]) ) {
								flatFileVo.setEventDate(subStr(columneArray[1], 0, 12));
							} else if ( "MVMT_STS".equals(columneArray[0]) ) {
								flatFileVo.setMvmtStatus(subStr(columneArray[1], 0, 2));
							} else if ( "GATE_IO".equals(columneArray[0]) ) {
								flatFileVo.setGateIo(subStr(columneArray[1], 0, 2));
							} else if ( "FL_MT_IND".equals(columneArray[0]) ) {
								flatFileVo.setContStat(subStr(columneArray[1], 0, 2));
							} else if ( "SIGHT_CD".equals(columneArray[0]) ) {
								flatFileVo.setSightCd(subStr(columneArray[1], 0, 1));
							} else if ( "CHSS_CODE".equals(columneArray[0]) ) {
								flatFileVo.setChssCode(subStr(columneArray[1], 0, 11));
							} else if ( "CALLSIGN".equals(columneArray[0]) ) {
								flatFileVo.setCallSignNo(subStr(columneArray[1], 0, 15));
							} else if ( "LLOYD_NO".equals(columneArray[0]) ) {
								flatFileVo.setLloydNo(subStr(columneArray[1], 0, 20));
							} else if ( "BL_NO".equals(columneArray[0]) ) {
								if(columneArray[1].indexOf("NYKS")==-1){
									if(columneArray[1].indexOf("NYKA")==-1){
										flatFileVo.setBlNo(subStr(columneArray[1], 0, 13));
									}else{
										flatFileVo.setBlNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKA")+4), 0, 13));
									}
								}else{
									flatFileVo.setBlNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKS")+4), 0, 13));
								}
							} else if ( "POL".equals(columneArray[0]) ) {
								flatFileVo.setPol(subStr(columneArray[1], 0, 5));
							} else if ( "POD".equals(columneArray[0]) ) {
								flatFileVo.setPod(subStr(columneArray[1], 0, 5));
							} else if ( "DEST_LOC".equals(columneArray[0]) ) {
								flatFileVo.setDestLoc(subStr(columneArray[1], 0, 7));
					              if("IEM".equals(strGubunCd.trim())) { 
					                  String strYdCd = dbDao.getMdmYardYdCd(columneArray[1]); 
					                  flatFileVo.setDestLoc(strYdCd); //searchYardCodeForFacilityCode search 
					                   // searchUserLocalCode는 ContainerMovementValidationDBDAO의 쿼리 
					                 } 		
							} else if ( "DEST_NM".equals(columneArray[0]) ) {
								flatFileVo.setDestNm(subStr(columneArray[1], 0, 50));	
							} else if ( "DEST_STS".equals(columneArray[0]) ) {
								flatFileVo.setDestSte(subStr(columneArray[1], 0, 20));
							} else if ( "DMG_FLAG".equals(columneArray[0]) ) {
								flatFileVo.setDmgFlag(subStr(columneArray[1], 0, 1));

								if (flatFileVo.getDmgFlag().equals("Y")) {
									flatFileVo.setDmgFlgDt(flatFileVo.getEventDate());
								} else if (flatFileVo.getDmgFlag().equals("N")) {
									flatFileVo.setDmgUnflgDt(flatFileVo.getEventDate());
								}
							} else if ( "PICKUP_NO".equals(columneArray[0]) ) {
								flatFileVo.setPickupNo(subStr(columneArray[1], 0, 30));
							} else if ( "MG_SET".equals(columneArray[0]) ) {
								flatFileVo.setMgSet(subStr(columneArray[1], 0, 11));
							} else if ( "SUBSTITUTION".equals(columneArray[0]) ) {
								flatFileVo.setSubstitution(columneArray[1]);
							} else if ( "CARRIER_COUNTRY".equals(columneArray[0]) ) {
								flatFileVo.setCarrierCountry(columneArray[1]);
							} else if ( "CARRIER_CD".equals(columneArray[0]) ) {
								flatFileVo.setCarrierCode(subStr(columneArray[1], 0, 4)); 
							} else if ( "TRANS_MODE".equals(columneArray[0]) ) {
								if("IEM".equals(strGubunCd.trim())) {
									flatFileVo.setTransMode("");
								}
								else
								{
									flatFileVo.setTransMode(subStr(columneArray[1], 0, 1));
								} 
							} else if ( "FLAT_CAR_NO".equals(columneArray[0]) ) {
								flatFileVo.setFlatCarNbr(subStr(columneArray[1], 0, 10));
							} else if ( "HANGER_TAG".equals(columneArray[0]) ) {
								flatFileVo.setHangerTag(subStr(columneArray[1], 0, 1));
							} else if ( "WAY_BILL_NO".equals(columneArray[0]) ) {
								flatFileVo.setWayBillNo(subStr(columneArray[1], 0, 13));
							} else if ( "DEL_TAG".equals(columneArray[0]) ) {
								flatFileVo.setDelTag(columneArray[1]);
							} else if ( "SEAL_NO".equals(columneArray[0]) ) {
								//flatFileVo.setSealNo(subStr(columneArray[1], 0, 10)); 20150519 Modify
								flatFileVo.setSealNo(subStr(columneArray[1], 0, 20));
							} else if ( "BKG_NO".equals(columneArray[0]) ) {
								if (bkgKnt < 31 && !columneArray[1].equals("")) {    
									bkgKnt++;
									if (bkgKnt == 1) {
										if(columneArray[1].indexOf("NYKS")==-1){
											if(columneArray[1].indexOf("NYKA")==-1){
												strBkgNo.append(subStr(columneArray[1], 0, 20));
											}else{
												strBkgNo.append(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKA")+4), 0, 20));
											}
										}else{
											strBkgNo.append(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKS")+4), 0, 20));
										}
										
									} else {
										if(columneArray[1].indexOf("NYKS")==-1){
											if(columneArray[1].indexOf("NYKA")==-1){
												strBkgNo.append("," + subStr(columneArray[1], 0, 20));
											}else{
												strBkgNo.append("," + subStr(columneArray[1].substring(columneArray[1].indexOf("NYKA")+4), 0, 20));
											}
										}else{
											strBkgNo.append("," + subStr(columneArray[1].substring(columneArray[1].indexOf("NYKS")+4), 0, 20));
										}
										
									}
								}
							} else if ( "WO_NO".equals(columneArray[0]) ) {
								flatFileVo.setWoNo(subStr(columneArray[1], 0, 20));
							} else if ( "VVD".equals(columneArray[0]) ) {
								flatFileVo.setEdiVvdCd(subStr(columneArray[1], 0, 20));
							} else if ( "VSL_NM".equals(columneArray[0]) ) {
								flatFileVo.setVslEngNm(subStr(columneArray[1], 0, 50));
							} else if ( "TI_NO".equals(columneArray[0]) ) {
								flatFileVo.setTirNo(subStr(columneArray[1], 0, 30));
							} else if ( "MT_PLAN".equals(columneArray[0]) ) {
								if(columneArray[1].indexOf("NYKS")==-1){
									if(columneArray[1].indexOf("NYKA")==-1){
										flatFileVo.setMtyPlnNo(subStr(columneArray[1], 0, 30));
									}else{
										flatFileVo.setMtyPlnNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKA")+4), 0, 30));
									}
								}else{
									flatFileVo.setMtyPlnNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKS")+4), 0, 30));
								}
								if (flatFileVo.getMtyPlnNo() != null && !"".equals(flatFileVo.getMtyPlnNo())) {
									flatFileVo.setEdiMtyEqRepoRefNo(subStr(flatFileVo.getMtyPlnNo(), 0, 20));
								}
							} else if ( "EP_REPOSITION".equals(columneArray[0]) ) {
								if(columneArray[1].indexOf("NYKS")==-1){
									if(columneArray[1].indexOf("NYKA")==-1){
										flatFileVo.setMtyRepoNo(subStr(columneArray[1], 0, 30));
									}else{
										flatFileVo.setMtyRepoNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKA")+4), 0, 30));
									}
								}else{
									flatFileVo.setMtyRepoNo(subStr(columneArray[1].substring(columneArray[1].indexOf("NYKS")+4), 0, 30));
								}
								if (flatFileVo.getMtyRepoNo() != null && !"".equals(flatFileVo.getMtyRepoNo())) {
									flatFileVo.setEdiMtyEqRepoRefNo(subStr(flatFileVo.getMtyRepoNo(), 0, 20));
								}
							} else if ( "CN_NO".equals(columneArray[0]) ) {
								flatFileVo.setEdiCrrNo(subStr(columneArray[1], 0, 30));
							} else if ( "TRANS_NO".equals(columneArray[0]) ) {
								flatFileVo.setTrspDocNo(subStr(columneArray[1], 0, 30));
							} else if ( "DOC_ID".equals(columneArray[0]) ) {
								flatFileVo.setVgmDocIdNo(subStr(columneArray[1], 0, 100));
							} else if ( "MEAS".equals(columneArray[0]) ) {
								flatFileVo.setVgmWgt(columneArray[1]);
							} else if ( "MEAS_UT".equals(columneArray[0]) ) {
								flatFileVo.setVgmEdiWgtUtCd(subStr(columneArray[1], 0, 1));
							} else if ( "DOC_TP".equals(columneArray[0]) ) {
								flatFileVo.setVgmDocTpCd(subStr(columneArray[1], 0, 3));
							} else if ( "DATE_TP".equals(columneArray[0]) ) {
								flatFileVo.setVgmDtTpCd(subStr(columneArray[1], 0, 3));
							} else if ( "DATE".equals(columneArray[0]) ) {
								flatFileVo.setVgmHndlDt(subStr(columneArray[1], 0, 12));
							} else if ( "CUST_CNTC_TP".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustCntcTpCd(subStr(columneArray[1], 0, 2));
							} else if ( "CUST_CNTC_NM".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustCntcNm(subStr(columneArray[1], 0, 100));
							} else if ( "CUST_FAX".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustFaxNo(subStr(columneArray[1], 0, 100));
							} else if ( "CUST_EML".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustEml(subStr(columneArray[1], 0, 200));
							} else if ( "CUST_PHN".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustPhnNo(subStr(columneArray[1], 0, 100));
							} else if ( "CUST_ML_ADDR".equals(columneArray[0]) ) {
								flatFileVo.setVgmCustAddr(subStr(columneArray[1], 0, 200));
							} else if ( "STOWAGE".equals(columneArray[0]) ) {
								flatFileVo.setCntrStwgPsnCtnt(subStr(columneArray[1], 0, 10));
							}
							columneArray = null;
						}
					}
					flatFileVo.setBkgCount(bkgKnt + "");
					if (bkgKnt > 0) {
						bkgNoArray = strBkgNo.toString().split(",");
					} else {
						bkgNoArray = new String[1];
						bkgNoArray[0] = "";
					}
					flatFileVo.setBkgNumber(bkgNoArray);
					flatFileVo.setBkgNumber0(bkgNoArray[0]);
					flatFileVo.setEdiBkgNo(bkgNoArray[0]);
					flatFileVo.setUserId("EDIUSER");

					flatFileVOs[i] = flatFileVo;
					strBkgNo = null;
					bkgNoArray = null;
					bkgKnt = 0;
					oneCaseArray = null;
					flatFileVo = null;
				}
			}
			// MQ Message content (E) ================================================================
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return flatFileVOs;
	}

	/**
	 * assignEdiUiVO2FlatFileVO for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignEdiUiVO2FlatFileVO( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		FlatFileForGateNewVO flatFileForGateNewVO = new FlatFileForGateNewVO();
		try {
			
			flatFileForGateNewVO.setBkgNumber0(searchEDIMovementListVO.getEdiBkgNo());
			flatFileForGateNewVO.setBlNo(searchEDIMovementListVO.getBlNo());
			flatFileForGateNewVO.setCallSignNo(searchEDIMovementListVO.getCallSgnNo());
			flatFileForGateNewVO.setLloydNo(searchEDIMovementListVO.getLloydNo());
			flatFileForGateNewVO.setChssCode(searchEDIMovementListVO.getChssNo());
			flatFileForGateNewVO.setContStat(searchEDIMovementListVO.getCntrFullStsCd());
			flatFileForGateNewVO.setCntrNumber(searchEDIMovementListVO.getCntrNo());
			flatFileForGateNewVO.setCntrTpszCd(searchEDIMovementListVO.getCntrTpszCd());
			flatFileForGateNewVO.setSealNo(searchEDIMovementListVO.getCntrSealNo());
			flatFileForGateNewVO.setDir(searchEDIMovementListVO.getCrntSkdDirCd());
			flatFileForGateNewVO.setVoyage(searchEDIMovementListVO.getCrntSkdVoyNo());
			flatFileForGateNewVO.setVessel(searchEDIMovementListVO.getCrntVslCd());
			flatFileForGateNewVO.setDestLoc(searchEDIMovementListVO.getDestYdCd());
			flatFileForGateNewVO.setDestNm(searchEDIMovementListVO.getDestNmCd());
			flatFileForGateNewVO.setDestSte(searchEDIMovementListVO.getDestSteCd());
			flatFileForGateNewVO.setEdiBkgNo(searchEDIMovementListVO.getEdiBkgNo());
			flatFileForGateNewVO.setGateIo(searchEDIMovementListVO.getEdiGateIoCd());
			flatFileForGateNewVO.setMvmtStatus(searchEDIMovementListVO.getEdiMvmtStsCd());
			flatFileForGateNewVO.setEdiUiYn(searchEDIMovementListVO.getEdiUiYn());
			flatFileForGateNewVO.setEventDate(searchEDIMovementListVO.getEvntDt());
			flatFileForGateNewVO.setEventYard(searchEDIMovementListVO.getEvntYdCd());
			flatFileForGateNewVO.setMgSet(searchEDIMovementListVO.getMgstNo());
			flatFileForGateNewVO.setMuidArea(searchEDIMovementListVO.getMvmtEdiMsgAreaCd());
			flatFileForGateNewVO.setMuidSeq(searchEDIMovementListVO.getMvmtEdiMsgSeq());
			flatFileForGateNewVO.setMsgId(searchEDIMovementListVO.getMvmtEdiMsgTpId());
			flatFileForGateNewVO.setMuidDt(searchEDIMovementListVO.getMvmtEdiMsgYrmondy());
			flatFileForGateNewVO.setResultMessage(searchEDIMovementListVO.getMvmtEdiRmk());
			flatFileForGateNewVO.setResultIndicator(searchEDIMovementListVO.getMvmtEdiRsltCd());
			flatFileForGateNewVO.setSightCd(searchEDIMovementListVO.getMvmtEdiSghtCd());
			flatFileForGateNewVO.setEdiId(searchEDIMovementListVO.getMvmtEdiTpCd());
			flatFileForGateNewVO.setTransMode(searchEDIMovementListVO.getMvmtTrspModCd());
			flatFileForGateNewVO.setPickupNo(searchEDIMovementListVO.getPkupNo());
			flatFileForGateNewVO.setPod(searchEDIMovementListVO.getPodCd());
			flatFileForGateNewVO.setPol(searchEDIMovementListVO.getPolCd());
			flatFileForGateNewVO.setTermId(searchEDIMovementListVO.getTmlNm());
			flatFileForGateNewVO.setUserId(searchEDIMovementListVO.getUserId());
			flatFileForGateNewVO.setUserNm(searchEDIMovementListVO.getUserNm());
			flatFileForGateNewVO.setVndrSeq(searchEDIMovementListVO.getVndrSeq());
			flatFileForGateNewVO.setWayBillNo(searchEDIMovementListVO.getWblNo());
			
			//EDI 추가에 따른 변경 [2014.09.01]
			flatFileForGateNewVO.setWoNo(searchEDIMovementListVO.getWoNo());
			flatFileForGateNewVO.setEdiVvdCd(searchEDIMovementListVO.getEdiVvdCd());
			flatFileForGateNewVO.setVslEngNm(searchEDIMovementListVO.getVslEngNm());
			flatFileForGateNewVO.setTirNo(searchEDIMovementListVO.getTirNo());
			flatFileForGateNewVO.setMtyPlnNo(searchEDIMovementListVO.getMtyPlnNo());
			flatFileForGateNewVO.setMtyRepoNo(searchEDIMovementListVO.getMtyRepoNo());
			flatFileForGateNewVO.setEdiMtyEqRepoRefNo(searchEDIMovementListVO.getEdiMtyEqRepoRefNo());
			flatFileForGateNewVO.setEdiCrrNo(searchEDIMovementListVO.getEdiCrrNo());
			flatFileForGateNewVO.setTrspDocNo(searchEDIMovementListVO.getTrspDocNo());

			flatFileForGateNewVO.setDmgFlag(searchEDIMovementListVO.getCntrDmgFlg());
			flatFileForGateNewVO.setDmgFlgDt(searchEDIMovementListVO.getDmgFlgDt());
			flatFileForGateNewVO.setDmgUnflgDt(searchEDIMovementListVO.getDmgUnflgDt());
			flatFileForGateNewVO.setVgmDocIdNo(searchEDIMovementListVO.getVgmDocIdNo());
			flatFileForGateNewVO.setVgmWgt(searchEDIMovementListVO.getVgmWgt());
			flatFileForGateNewVO.setVgmEdiWgtUtCd(searchEDIMovementListVO.getVgmEdiWgtUtCd());
			flatFileForGateNewVO.setVgmDocTpCd(searchEDIMovementListVO.getVgmDocTpCd());
			flatFileForGateNewVO.setVgmDtTpCd(searchEDIMovementListVO.getVgmDtTpCd());
			flatFileForGateNewVO.setVgmHndlDt(searchEDIMovementListVO.getVgmHndlDt());
			flatFileForGateNewVO.setVgmCustCntcTpCd(searchEDIMovementListVO.getVgmCustCntcTpCd());
			flatFileForGateNewVO.setVgmCustCntcNm(searchEDIMovementListVO.getVgmCustCntcNm());
			flatFileForGateNewVO.setVgmCustFaxNo(searchEDIMovementListVO.getVgmCustFaxNo());
			flatFileForGateNewVO.setVgmCustEml(searchEDIMovementListVO.getVgmCustEml());
			flatFileForGateNewVO.setVgmCustPhnNo(searchEDIMovementListVO.getVgmCustPhnNo());
			flatFileForGateNewVO.setVgmCustAddr(searchEDIMovementListVO.getVgmCustAddr());
			flatFileForGateNewVO.setCarrierCode(searchEDIMovementListVO.getUsaEdiCd());
			flatFileForGateNewVO.setCntrStwgPsnCtnt(searchEDIMovementListVO.getCntrStwgPsnCtnt());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return flatFileForGateNewVO;
	}

	/**
	 * assignFlatFileVO2EdiUiVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO assignFlatFileVO2EdiUiVO( FlatFileForGateNewVO flatFileForGateNewVO, SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		try {
			searchEDIMovementListVO.setBkgNo(flatFileForGateNewVO.getBkgNumber0());
			searchEDIMovementListVO.setBlNo(flatFileForGateNewVO.getBlNo());
			searchEDIMovementListVO.setCallSgnLloyd(flatFileForGateNewVO.getCallSignNo().equals("")? flatFileForGateNewVO.getLloydNo(): flatFileForGateNewVO.getCallSignNo());
			searchEDIMovementListVO.setCallSgnNo(flatFileForGateNewVO.getCallSignNo());
			searchEDIMovementListVO.setLloydNo(flatFileForGateNewVO.getLloydNo());
			searchEDIMovementListVO.setChssNo(flatFileForGateNewVO.getChssCode());
			searchEDIMovementListVO.setCntrFullStsCd(flatFileForGateNewVO.getContStat());
			searchEDIMovementListVO.setCntrNo(flatFileForGateNewVO.getCntrNumber());
			searchEDIMovementListVO.setCntrSealNo(flatFileForGateNewVO.getSealNo());
			searchEDIMovementListVO.setCrntSkdDirCd(flatFileForGateNewVO.getDir());
			searchEDIMovementListVO.setCrntSkdVoyNo(flatFileForGateNewVO.getVoyage());
			searchEDIMovementListVO.setCntrTpszCd(flatFileForGateNewVO.getCntrTpszCd());
			searchEDIMovementListVO.setCrntVslCd(flatFileForGateNewVO.getVessel());
			searchEDIMovementListVO.setDestYdCd(flatFileForGateNewVO.getDestLoc());
			searchEDIMovementListVO.setDestNmCd(flatFileForGateNewVO.getDestNm());
			searchEDIMovementListVO.setDestSteCd(flatFileForGateNewVO.getDestSte());
			searchEDIMovementListVO.setEdiBkgNo(flatFileForGateNewVO.getEdiBkgNo());
			searchEDIMovementListVO.setEdiGateIoCd(flatFileForGateNewVO.getGateIo());
			searchEDIMovementListVO.setEdiMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			searchEDIMovementListVO.setEdiUiYn(flatFileForGateNewVO.getEdiUiYn());
			searchEDIMovementListVO.setEvntDt(flatFileForGateNewVO.getEventDate());
			searchEDIMovementListVO.setEvntYdCd(flatFileForGateNewVO.getEventYard());
			searchEDIMovementListVO.setMgstNo(flatFileForGateNewVO.getMgSet());
			searchEDIMovementListVO.setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
			searchEDIMovementListVO.setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
			searchEDIMovementListVO.setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
			searchEDIMovementListVO.setMvmtEdiMsgYrmondy(flatFileForGateNewVO.getMuidDt());
			searchEDIMovementListVO.setMvmtEdiRmk(flatFileForGateNewVO.getResultMessage());
			searchEDIMovementListVO.setMvmtEdiRsltCd(flatFileForGateNewVO.getResultIndicator());
			searchEDIMovementListVO.setMvmtEdiSghtCd(flatFileForGateNewVO.getSightCd());
			searchEDIMovementListVO.setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
			searchEDIMovementListVO.setMvmtTrspModCd(flatFileForGateNewVO.getTransMode());
			searchEDIMovementListVO.setPkupNo(flatFileForGateNewVO.getPickupNo());
			searchEDIMovementListVO.setPodCd(flatFileForGateNewVO.getPod());
			searchEDIMovementListVO.setPolCd(flatFileForGateNewVO.getPol());
			searchEDIMovementListVO.setTmlNm(flatFileForGateNewVO.getTermId());
			searchEDIMovementListVO.setUserId(flatFileForGateNewVO.getUserId());
			searchEDIMovementListVO.setUserNm(flatFileForGateNewVO.getUserNm());
			searchEDIMovementListVO.setVndrSeq(flatFileForGateNewVO.getVndrSeq());
			searchEDIMovementListVO.setWblNo(flatFileForGateNewVO.getWayBillNo());
			//EDI 추가에 따른 변경 [2014.09.01]
			searchEDIMovementListVO.setWoNo(flatFileForGateNewVO.getWoNo());
			searchEDIMovementListVO.setEdiVvdCd(flatFileForGateNewVO.getEdiVvdCd());
			searchEDIMovementListVO.setVslEngNm(flatFileForGateNewVO.getVslEngNm());
			searchEDIMovementListVO.setTirNo(flatFileForGateNewVO.getTirNo());
			searchEDIMovementListVO.setMtyPlnNo(flatFileForGateNewVO.getMtyPlnNo());
			searchEDIMovementListVO.setMtyRepoNo(flatFileForGateNewVO.getMtyRepoNo());
			searchEDIMovementListVO.setEdiMtyEqRepoRefNo(flatFileForGateNewVO.getEdiMtyEqRepoRefNo());
			searchEDIMovementListVO.setEdiCrrNo(flatFileForGateNewVO.getEdiCrrNo());
			searchEDIMovementListVO.setTrspDocNo(flatFileForGateNewVO.getTrspDocNo());

			searchEDIMovementListVO.setCntrDmgFlg(flatFileForGateNewVO.getDmgFlag());
			searchEDIMovementListVO.setDmgFlgDt(flatFileForGateNewVO.getDmgFlgDt());
			searchEDIMovementListVO.setDmgUnflgDt(flatFileForGateNewVO.getDmgUnflgDt());

			searchEDIMovementListVO.setVgmDocIdNo(flatFileForGateNewVO.getVgmDocIdNo());
			searchEDIMovementListVO.setVgmWgt(flatFileForGateNewVO.getVgmWgt());
			searchEDIMovementListVO.setVgmEdiWgtUtCd(flatFileForGateNewVO.getVgmEdiWgtUtCd());
			searchEDIMovementListVO.setVgmDocTpCd(flatFileForGateNewVO.getVgmDocTpCd());
			searchEDIMovementListVO.setVgmDtTpCd(flatFileForGateNewVO.getVgmDtTpCd());
			searchEDIMovementListVO.setVgmHndlDt(flatFileForGateNewVO.getVgmHndlDt());
			searchEDIMovementListVO.setVgmCustCntcTpCd(flatFileForGateNewVO.getVgmCustCntcTpCd());
			searchEDIMovementListVO.setVgmCustCntcNm(flatFileForGateNewVO.getVgmCustCntcNm());
			searchEDIMovementListVO.setVgmCustFaxNo(flatFileForGateNewVO.getVgmCustFaxNo());
			searchEDIMovementListVO.setVgmCustEml(flatFileForGateNewVO.getVgmCustEml());
			searchEDIMovementListVO.setVgmCustPhnNo(flatFileForGateNewVO.getVgmCustPhnNo());
			searchEDIMovementListVO.setVgmCustAddr(flatFileForGateNewVO.getVgmCustAddr());
			searchEDIMovementListVO.setUsaEdiCd(flatFileForGateNewVO.getCarrierCode());
			searchEDIMovementListVO.setCntrStwgPsnCtnt(flatFileForGateNewVO.getCntrStwgPsnCtnt());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchEDIMovementListVO;
	}
	
	/**
	 * checking ACIAC_DIV_CD 
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException,
	 */
	public Integer searchDomsticBooking(String bkgNo) throws EventException {
		int domesticCheck = 0;
		try {			
			domesticCheck = dbDao.searchDomsticBooking(bkgNo);		
		}catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchDomsticBooking(OTH)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return domesticCheck;
	}
	
	/**
	  * determining Gate In/Out Code 
	  * adjustGateInOutCode for GateNew
	  *
	  * @param FlatFileForGateNewVO flatFileForGateNewVO
	  * @param boolean bkgCheck
	  * @return FlatFileForGateNewVO
	  * @exception EventException
	  **/
	 private FlatFileForGateNewVO adjustGateInOutCode( FlatFileForGateNewVO flatFileForGateNewVO) throws EventException {
	  
	  /* ________________________________________________________________________ Variables Initialize */
	  boolean bkgExist = false;
	  boolean callSignExist = false;
	  boolean callSignVSLFound = false;
	  boolean vvdFound = false;
	  /* ____________________________________________________________________________ BKG No Checking */
	//  EXEC SQL
	//  SELECT  "A"
	//  FROM BKG_BOOKING BK
	//  WHERE BK.BKG_NO =  :FlatFileVO.bkgNumber[0];
	//   returnValue = "";
	  String returnValue = "";
	  String [] rtnValueArr = new String[4];
	  try {
	   log.debug("\n\n===============================================================" +
	       "\n dbDao.searchCodeExist(BKG_NO:BKG_BOOKING)" +
	       "\n dbDao.getBookingInfo(bkgNo)" +
	       "\n===============================================================\n");
//	    String tableName = "BKG_BOOKING";
//	    if(flatFileForGateNewVO.getOscaBkgFlg().equalsIgnoreCase("Y"))
//	     tableName = "CTM_BOOKING";
//	    returnValue = dbDao.searchCodeExistForGateNew(tableName, "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0]);
	   
	    rtnValueArr = dbDao.searchBookingRoute(flatFileForGateNewVO.getBkgNumber()[0]);
	    
	    //AE 이고 Event Yard가 POR이나 POD와 같으면 이후 로직 수행
	    //UV 이고 Event Yard가 POL이나 DEL과 같으면 이후 로직 수행
	    if(flatFileForGateNewVO.getGateIo().equals("AE") && ( (flatFileForGateNewVO.getEventYard().substring(0, 5).equals(rtnValueArr[0]) && (!rtnValueArr[0].equals(rtnValueArr[1]) ))  || (flatFileForGateNewVO.getEventYard().substring(0,5).equals(rtnValueArr[2]) && (!rtnValueArr[2].equals(rtnValueArr[3]) )))    ) {
	        //로직실행
	        log.debug("AE ====>");
	    }else if(flatFileForGateNewVO.getGateIo().equals("UV") && ( (flatFileForGateNewVO.getEventYard().substring(0,5).equals(rtnValueArr[1]) && (!rtnValueArr[0].equals(rtnValueArr[1]) )) || ( flatFileForGateNewVO.getEventYard().substring(0,5).equals(rtnValueArr[3])  && (!rtnValueArr[2].equals(rtnValueArr[3]) ) ) ) ) {
	        //로직실행
	        log.debug("UV ====>");
	    }else{
	        return flatFileForGateNewVO;
	    }
	   
	    returnValue = dbDao.getBookingInfo(flatFileForGateNewVO.getBkgNumber()[0])[0];
	  } catch (DAOException ex) {
	   log.error("[GATENEW : dbDao.getBookingInfo(BKG_NO)] DAOerr : " + ex.toString(), ex);
	   throw new EventException(ex.getMessage(), ex);
	  } catch (Exception ex) {
	   log.error("[GATENEW : dbDao.getBookingInfo(BKG_NO)] err : " + ex.toString(), ex);
	   throw new EventException(ex.getMessage(), ex);
	  }
	  if ( returnValue != null && !returnValue.equals("") ) bkgExist = true;
	  /* __________________________________________________________________________ Callsign Checking */
	  Integer callsignLength = 0;
	  if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	   callsignLength = flatFileForGateNewVO.getCallSignNo().length();
	  } else {
	   callsignLength = flatFileForGateNewVO.getLloydNo().length();
	  }
	  /* __________________________________________________________________ Callsign VVD Checking */
	  String[] csnVslCd = new String[3];  
	  if ( callsignLength > 0 ) {
	   callSignExist = true;
	   if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	    try {
	     log.debug("\n\n===============================================================" +
	            "\n dbDao.getVslCd(CallSignNo)" +
	            "\n===============================================================\n");
	        csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), "");
	    } catch (DAOException ex) {
	     log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] DAOerr : " + ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] err : " + ex.toString(), ex);
	        throw new EventException(ex.getMessage(), ex);
	    }
	   } else {
	    try {
	     log.debug("\n\n===============================================================" +
	       "\n dbDao.getVslCd(LloydNo)" +
	       "\n===============================================================\n");
	     csnVslCd = dbDao.getVslCd("", flatFileForGateNewVO.getLloydNo());
	    } catch (DAOException ex) {
	     log.error("[GATENEW : dbDao.getVslCd(LloydNo)] DAOerr : " + ex.toString(), ex);
	     throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	     log.error("[GATENEW : dbDao.getVslCd(LloydNo)] err : " + ex.toString(), ex);
	     throw new EventException(ex.getMessage(), ex);
	    }
	   }
	   if ( (csnVslCd[0] != null && !csnVslCd[0].equals(""))
	     || (csnVslCd[1] != null && !csnVslCd[1].equals(""))
	     || (csnVslCd[2] != null && !csnVslCd[2].equals("")) ) {
	       callSignVSLFound = true;
	   }
	  }
	  String[] vvdCode = null;
	  if ( !bkgExist ) {
	   if ( !callSignExist ) {
	    if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	     if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	      flatFileForGateNewVO.setGateIo("O");
	      flatFileForGateNewVO.setMvmtStatus("");
	     }
	     else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	     {
	      flatFileForGateNewVO.setGateIo("I");
	      flatFileForGateNewVO.setMvmtStatus("");
	     }
	    }else{
	     if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	      flatFileForGateNewVO.setGateIo("OA");
	      flatFileForGateNewVO.setMvmtStatus("");
	     }
	     else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	     {
	      flatFileForGateNewVO.setGateIo("I");
	      flatFileForGateNewVO.setMvmtStatus("");
	     }
	    }
	   } else { /* ( callsignExist == TRUE ) */
	    if ( !callSignVSLFound ) {
	     if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	      if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	       flatFileForGateNewVO.setGateIo("O");
	       flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }else{
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("OA");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }
	    } else { /* ( callSignVVDFound == TRUE ) */
	     flatFileForGateNewVO.setResultMessage("Could not find correct BKG No");    /* 20091221 SBKIM */
	     vvdCode = new String[3];
	     for ( int ii=0; ii<3 && csnVslCd[ii] != null; ii++ ) {
	      try {
	       if( flatFileForGateNewVO.getGateIo().equals("AE") ) {    /* -------------------------------------------- (VL) Case */
//	         /* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 */
//	         EXEC SQL
//	         SELECT  S.VSL_CD,   S.SKD_VOY_NO,  S.SKD_DIR_CD
//	         INTO :vps_vsl_cd,  :vps_voyage_no,  :vps_dir_cd
//	         FROM (
//	            SELECT /*+ ORDERED
//	                INDEX_DESC( VPS1 XAK2VSL_PORT_SKD_ETD   )
//	                INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//	              ROUND(ABS(VPS1.VPS_ETD_DT-TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')),5) DIF,  /* 2008.12.04 */
//	              SKD.VSL_CD,   SKD.SKD_VOY_NO,  SKD.SKD_DIR_CD
//	            FROM VSK_VSL_PORT_SKD VPS1,  VSK_VSL_SKD SKD
//	            WHERE VPS1.VPS_ETD_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD') - :fm_margin
//	            AND        TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD') + :to_margin + .99999
//	            AND  VPS1.VPS_PORT_CD         = :FlatFileVO.eventYard
//	            AND  NVL(VPS1.SKD_CNG_STS_CD,' ') <> 'S'
//	            AND  SKD.VSL_CD   LIKE TRIM(:csn_vsl_cd[ii])||'%'
//	            AND  SKD.SKD_STS_CD         = 'ACT'
//	            AND  SKD.VSL_CD              = VPS1.VSL_CD
//	            AND  SKD.SKD_VOY_NO   = VPS1.SKD_VOY_NO
//	            AND  SKD.SKD_DIR_CD          = VPS1.SKD_DIR_CD
//	            ORDER BY DIF ASC SKD.SKD_VOY_NO DESC  /* VL : using bigger Voyage No - 2009.09.03 */
//	           ) S
//	         WHERE ROWNUM  = 1;
	        log.debug("\n\n===============================================================" +
	             "\n dbDao.getVvdCdByVL" +
	             "\n===============================================================\n");
	        vvdCode = dbDao.getVvdCdByVL(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);
	       } else {              /* ------------------------------------------- (VD) Case */
//	         /* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 *
//	         EXEC SQL
//	         SELECT  S.VSL_CD,   S.SKD_VOY_NO,  S.SKD_DIR_CD
//	         INTO :vps_vsl_cd,  :vps_voyage_no,  :vps_dir_cd
//	         FROM (
//	            SELECT /*+ ORDERED
//	                INDEX_DESC( VPS1 XAK1VSL_PORT_SKD_ETB   )
//	                INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//	              ROUND(ABS(VPS1.VPS_ETB_DT-TO_DATE(:eventDate, 'YYYYMMDD')),5) DIF,  /* 2008.12.04 */
//	              SKD.VSL_CD,   SKD.SKD_VOY_NO,  SKD.SKD_DIR_CD
//	            FROM VSK_VSL_PORT_SKD VPS1, VSK_VSL_SKD SKD
//	            WHERE VPS1.VPS_ETB_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD') - :fm_margin
//	            AND        TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD') + :to_margin + .99999
//	            AND  VPS1.VPS_PORT_CD  = :FlatFileVO.eventYard
//	            AND  NVL(VPS1.SKD_CNG_STS_CD,' ') <> 'S'
//	            AND  SKD.VSL_CD   LIKE TRIM(:csn_vsl_cd[ii])||'%'
//	            AND  SKD.SKD_STS_CD   = 'ACT'
//	            AND  SKD.VSL_CD    = VPS1.VSL_CD
//	            AND  SKD.SKD_VOY_NO   = VPS1.SKD_VOY_NO
//	            AND  SKD.SKD_DIR_CD   = VPS1.SKD_DIR_CD
//	            ORDER BY DIF ASC SKD.SKD_VOY_NO ASC /* VD : using smaller Voyage No - 2009.09.03 */
//	           ) S
//	         WHERE ROWNUM  = 1;
	        log.debug("\n\n===============================================================" +
	            "\n dbDao.getVvdCdByVD" +
	            "\n===============================================================\n");
	        vvdCode = dbDao.getVvdCdByVD(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);
	       }
	      } catch (DAOException ex) {
	       log.error("[GATENEW : dbDao.getVvdCd] DAOerr : " + ex.toString(), ex);
	       throw new EventException(ex.getMessage(), ex);
	      } catch (Exception ex) {
	       log.error("[GATENEW : dbDao.getVvdCd] err : " + ex.toString(), ex);
	       throw new EventException(ex.getMessage(), ex);
	      }
	      if ( (vvdCode[0] != null && !vvdCode[0].equals("")) || (vvdCode[1] != null && !vvdCode[1].equals("")) || (vvdCode[2] != null && !vvdCode[2].equals("")) ) {
	       flatFileForGateNewVO.setVessel(vvdCode[0]);
	       flatFileForGateNewVO.setVoyage(vvdCode[1]);
	       flatFileForGateNewVO.setDir(vvdCode[2]);
	       vvdFound = true ;
	       break;
	      }
	     }    /* for ( ii = 0; ii < 3 && csn_vsl_cd[ii] ! = ""; ii++ ) */
	    }
	   }
	  } else { /* if ( bkgExist = = TRUE ) */
	   /* ____________________________________________________________________________ BKG VVD Checking */
//	    EXEC SQL
//	    SELECT  "A"
//	    FROM BKG_CONTAINER BC
//	    WHERE BC.BKG_NO =  :FlatFileVO.bkgNumber[0]
//	    AND  BC.CNTR_NO = TRIM(:FlatFileVO.cntrNumber)
//	    AND  ROWNUM = 1;
	   returnValue = "";
	   try {
	    log.debug("\n\n===============================================================" +
	        "\n dbDao.searchCodeExist(BkgCntr)" +
	        "\n===============================================================\n");
	    String tableName = "BKG_CONTAINER";
	     
	    //[2015.06.01]Add Osca Bkg 구분값 추가.
	    if (flatFileForGateNewVO.getBkgNumber()[0].length() == 10) { // 2015.01.12
	     flatFileForGateNewVO.setOscaBkgFlg("Y");
	    } else {
	     flatFileForGateNewVO.setOscaBkgFlg("N");
	    }
	     
	    log.debug("\n GATENEW : Booking No ["+flatFileForGateNewVO.getBkgNumber()[0]+"] Oscar Booking Flag ["+flatFileForGateNewVO.getOscaBkgFlg()+"]");
	     
	    if(flatFileForGateNewVO.getOscaBkgFlg()!=null && flatFileForGateNewVO.getOscaBkgFlg().equalsIgnoreCase("Y"))
	     tableName = "CTM_BKG_CNTR";
	    returnValue = dbDao.searchCodeExistForGateNew(tableName, "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0] + "' AND CNTR_NO = '" + flatFileForGateNewVO.getCntrNumber());
	   } catch (DAOException ex) {
	    log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] DAOerr : " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(), ex);
	   } catch (Exception ex) {
	    log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] err : " + ex.toString(), ex);
	    throw new EventException(ex.getMessage(), ex);
	   }
	   if ( returnValue != null && !returnValue.equals("") ) {
//	     EXEC SQL
//	     SELECT  NVL(BV.VSL_CD,"X"),  NVL(BV.SKD_VOY_NO,"X"),  NVL(BV.SKD_DIR_CD,"X")
//	     INTO :bkg_vsl_cd,   :bkg_voyage_no,    :bkg_dir_cd
//	     FROM BKG_VVD BV
//	     WHERE BV.BKG_NO =  :FlatFileVO.bkgNumber[0]
//	     AND  DECODE(:FlatFileVO.gateIo,"AE",BV.POL_CD, BV.POD_CD) = :FlatFileVO.eventYard
//	     AND  ROWNUM = 1;
	    vvdCode = new String[3];
	    try {
	     log.debug("\n\n===============================================================" +
	         "\n dbDao.getVvdCd" +
	         "\n===============================================================\n");
	     vvdCode = dbDao.getVvdCd(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard());
	    } catch (DAOException ex) {
	     log.error("[GATENEW : dbDao.getVvdCd1] DAOerr : " + ex.toString(), ex);
	     throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	     log.error("[GATENEW : dbDao.getVvdCd1] err : " + ex.toString(), ex);
	     throw new EventException(ex.getMessage(), ex);
	    }
	    if ( (vvdCode[0] == null || vvdCode[0].equals("")) || (vvdCode[1] == null || vvdCode[1].equals("")) || (vvdCode[2] == null && vvdCode[2].equals(""))) {
	     /* bkgVVDFound = FALSE */
	     /* 20091221 SBKIM (S)-------------------------------------- */
	     if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	      if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	       flatFileForGateNewVO.setGateIo("O");
	       flatFileForGateNewVO.setMvmtStatus("");
	      }
	      else
	      {
	       flatFileForGateNewVO.setGateIo("OA");
	       flatFileForGateNewVO.setMvmtStatus("");
	      }
	     } else {
	       flatFileForGateNewVO.setGateIo("I");
	       flatFileForGateNewVO.setMvmtStatus("");
	     }

	    } else if ( vvdCode[0].equals("X") ) {
	     if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("O");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }else{
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("OA");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }
	    } else {
	     if ( !callSignExist || !callSignVSLFound ) {
	      flatFileForGateNewVO.setVessel(vvdCode[0]);
	      flatFileForGateNewVO.setVoyage(vvdCode[1]);
	      flatFileForGateNewVO.setDir(vvdCode[2]);
	      vvdFound = true;
	     } else {    /* RETURN TRUE */
	      for ( int ii=0; ii<3 && csnVslCd[ii] != null; ii++ ) {
	       if ( csnVslCd[ii].equals(vvdCode[0]) ) { // bkg_vsl_cd
	        flatFileForGateNewVO.setVessel(vvdCode[0]);
	        flatFileForGateNewVO.setVoyage(vvdCode[1]);
	        flatFileForGateNewVO.setDir(vvdCode[2]);
	        vvdFound = true;
	       }
	      }
	//
//	       if ( !vvdFound ) {
//	        flatFileForGateNewVO.setResultMessage("BKG VVD is different");
//	        flatFileForGateNewVO.setResultIndicator("N");
//	        /* 20091221 SBKIM (S)-------------------------------------- */
//	        flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
//	        /* 20091221 SBKIM (E)-------------------------------------- */
//	       }
	     }
	    }
	   }
	  }
	  if ( !vvdFound ) {
	    if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && flatFileForGateNewVO.getGateIo().equals("AE") ) {
	     flatFileForGateNewVO.setVessel("XXXX");
	     flatFileForGateNewVO.setVoyage("0000");
	     flatFileForGateNewVO.setDir("");
	 
	    } else {
	     if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("O");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       } else {
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("OA");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }
	    }
	  } else if ( bkgExist == false ) {
	    if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {
	     log.debug("\n\n============================== bkgExist=false & ContStat in (E,M) & GateIo=AE  >>>  skip");
	    } else {
	     if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("O");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       } else {
	        if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
	         flatFileForGateNewVO.setGateIo("OA");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	        else if ( flatFileForGateNewVO.getGateIo().equals("UV") )
	        {
	         flatFileForGateNewVO.setGateIo("I");
	         flatFileForGateNewVO.setMvmtStatus("");
	        }
	       }
	    }
	  }
	  return flatFileForGateNewVO;
	 }

	 /**
	  * 
	  * @param blNo
	  * @param cntrNo
	  * @return String
	  * @throws EventException
	  */
	 public String searchBkgNoForOscar(String blNo, String cntrNo) throws EventException{
		try {
			return dbDao.searchBkgNoForOscar(blNo, cntrNo);
			
		} catch (DAOException ex) {
			log.error("[ : dbDao.searchBkgNoForOscar] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[ : dbDao.searchBkgNoForOscar] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	
	 }


		/**
		 * adjusting EQR Reference Number 
		 *  adjustEqrRefNumber for GateNew
		 *
		 * @param FlatFileForGateNewVO flatFileForGateNewVO
		 * @return FlatFileForGateNewVO
		 * @exception EventException
		 **/
		private FlatFileForGateNewVO adjustEqrRefNumber( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

			if (flatFileForGateNewVO.getBkgNumber()[0].length() >= 12) {
				if ( isNumeric(flatFileForGateNewVO.getBkgNumber()[0].substring(0,8)) && !isNumeric(flatFileForGateNewVO.getBkgNumber()[0].substring(8,9)) && isNumeric(flatFileForGateNewVO.getBkgNumber()[0].substring(9,11)) ) {
					flatFileForGateNewVO.setMtyPlnNo(flatFileForGateNewVO.getBkgNumber()[0]);
					flatFileForGateNewVO.setEdiMtyEqRepoRefNo(flatFileForGateNewVO.getBkgNumber()[0]);
					flatFileForGateNewVO.setEdiBkgNo("");
				}
			}
			if (flatFileForGateNewVO.getBlNo().length() >= 12) {
				if ( isNumeric(flatFileForGateNewVO.getBlNo().substring(0,8)) && !isNumeric(flatFileForGateNewVO.getBlNo().substring(8,9)) && isNumeric(flatFileForGateNewVO.getBlNo().substring(9,11)) ) {
					flatFileForGateNewVO.setMtyPlnNo(flatFileForGateNewVO.getBlNo());
					flatFileForGateNewVO.setEdiMtyEqRepoRefNo(flatFileForGateNewVO.getBlNo());
					flatFileForGateNewVO.setBlNo("");
				}
			}

			//Activate after 1st August
			
//			String returnValue = "";
//			
//			try {
//				log.debug("\n\n===============================================================" +
//						  "\n dbDao.checkEqrRefNo(mtyPlnNo, mtyRepoNo)" +
//						  "\n===============================================================\n");
//				returnValue = dbDao.checkEqrRefNo(flatFileForGateNewVO.getMtyPlnNo(), flatFileForGateNewVO.getMtyRepoNo());
//			} catch (DAOException ex) {
//				log.error("[GATENEW : dbDao.checkEqrRefNo] DAOerr : " + ex.toString(), ex);
//				throw new EventException(ex.getMessage(), ex);
//			} catch (Exception ex) {
//				log.error("[GATENEW : dbDao.checkEqrRefNo err : " + ex.toString(), ex);
//				throw new EventException(ex.getMessage(), ex);
//			}
//
//			if ( returnValue == null || returnValue.equals("") ) {
//				flatFileForGateNewVO.setMtyPlnNo("");
//				flatFileForGateNewVO.setMtyRepoNo("");
//			} 

			return flatFileForGateNewVO;
		}


	/**
	 * adjusting VVD 
	 *  adjustVVD for GateNew
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return boolean
	 * @exception EventException
	 **/
	private boolean adjustVVD( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String[] vvdCode = new String[3];
		boolean returnValue = false;
		
		if (flatFileForGateNewVO.getEdiVvdCd().length() >= 7) { /* -------------------------------------------- Vessel + Voyage + Direction */
			if ( isNumeric(flatFileForGateNewVO.getEdiVvdCd().substring(3,4)) ) { /* -------------------------- (OSCAR) IEM + EDI */
				vvdCode[0] = flatFileForGateNewVO.getEdiVvdCd().substring(0,3);
				vvdCode[1] = "0"+flatFileForGateNewVO.getEdiVvdCd().substring(3,6);
				vvdCode[2] = flatFileForGateNewVO.getEdiVvdCd().substring(6,7);

				try {
					log.debug("\n\n===============================================================" +
					  "\n dbDao.getOscarVslCd(vslCd)" +
					  "\n===============================================================\n");
					vvdCode[0] =  dbDao.getOscarVslCd(vvdCode[0]);
					
				} catch (DAOException ex) {
					log.error("[ : dbDao.getOscarVslCd] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[ : dbDao.getOscarVslCd] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
			} else {
				if (flatFileForGateNewVO.getEdiVvdCd().length() >= 9) { /* ------------------------------------ (OPUS) EDI */
					vvdCode[0] = flatFileForGateNewVO.getEdiVvdCd().substring(0,4);
					vvdCode[1] = flatFileForGateNewVO.getEdiVvdCd().substring(4,8);
					vvdCode[2] = flatFileForGateNewVO.getEdiVvdCd().substring(8,9);
				}
			}
		} else { /* ------------------------------------------------------------------------------------------- Voyage + Direction */
			
			/* Search Vessel Code with Vessel Name */
			try {
				log.debug("\n\n===============================================================" +
				  "\n dbDao.getVslCd(vslEngNm)" +
				  "\n===============================================================\n");
				vvdCode[0] =  dbDao.getVslCd(flatFileForGateNewVO.getVslEngNm());
				
			} catch (DAOException ex) {
				log.error("[ : dbDao.getOscarVslCd] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[ : dbDao.getOscarVslCd] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
			if (flatFileForGateNewVO.getEdiVvdCd().length() == 4) { /* ---------------------------------------- (OSCAR) */
				vvdCode[1] = "0"+flatFileForGateNewVO.getEdiVvdCd().substring(0,3);
				vvdCode[2] = flatFileForGateNewVO.getEdiVvdCd().substring(3,4);
			} else if (flatFileForGateNewVO.getEdiVvdCd().length() == 5) { /* --------------------------------------------------------------------------------------- (OPUS) */
				vvdCode[1] = flatFileForGateNewVO.getEdiVvdCd().substring(0,4);
				vvdCode[2] = flatFileForGateNewVO.getEdiVvdCd().substring(4,5);
			}
		}
		
		if (vvdCode[0] != null && !vvdCode[0].equals("")) {
			 
			flatFileForGateNewVO.setResultMessage("Could not find correct BKG No");
			
			String [] vslCode = new String[3];
			try {
				if( flatFileForGateNewVO.getGateIo().equals("AE") ) {    /* -------------------------------------------- (VL) Case */

//						/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 */
//						EXEC SQL
//						SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//						INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//						FROM	(
//									SELECT	/*+ ORDERED
//													INDEX_DESC( VPS1 XAK2VSL_PORT_SKD_ETD   )
//													INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//											ROUND(ABS(VPS1.VPS_ETD_DT-TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//											SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//									FROM	VSK_VSL_PORT_SKD VPS1,  VSK_VSL_SKD SKD
//									WHERE	VPS1.VPS_ETD_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//									AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//									AND		VPS1.VPS_PORT_CD         =	:FlatFileVO.eventYard
//									AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//									AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//									AND		SKD.SKD_STS_CD	        =	'ACT'
//									AND		SKD.VSL_CD              =	VPS1.VSL_CD
//									AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//									AND		SKD.SKD_DIR_CD          =	VPS1.SKD_DIR_CD
//									ORDER BY DIF ASC SKD.SKD_VOY_NO DESC  /* VL : using bigger Voyage No - 2009.09.03 */
//								) S
//						WHERE	ROWNUM  = 1;

					log.debug("\n\n===============================================================" +
							  "\n dbDao.getVvdCdByVL" +
							  "\n===============================================================\n");
					vslCode = dbDao.getVvdCdByVL(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), vvdCode[0]);

				} else {									     /* ------------------------------------------- (VD) Case */

//						/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 *
//						EXEC SQL
//						SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//						INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//						FROM	(
//									SELECT /*+ ORDERED
//													INDEX_DESC( VPS1 XAK1VSL_PORT_SKD_ETB   )
//													INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//											ROUND(ABS(VPS1.VPS_ETB_DT-TO_DATE(:eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//											SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//									FROM	VSK_VSL_PORT_SKD VPS1, VSK_VSL_SKD SKD
//									WHERE	VPS1.VPS_ETB_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//									AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//									AND		VPS1.VPS_PORT_CD		=	:FlatFileVO.eventYard
//									AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//									AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//									AND		SKD.SKD_STS_CD			=	'ACT'
//									AND		SKD.VSL_CD				=	VPS1.VSL_CD
//									AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//									AND		SKD.SKD_DIR_CD			=	VPS1.SKD_DIR_CD
//									ORDER BY DIF ASC SKD.SKD_VOY_NO ASC	/* VD : using smaller Voyage No - 2009.09.03 */
//								) S
//						WHERE	ROWNUM  = 1;

					log.debug("\n\n===============================================================" +
							  "\n dbDao.getVvdCdByVD" +
							  "\n===============================================================\n");
					vslCode = dbDao.getVvdCdByVD(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), vvdCode[0]);
				}
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getVvdCd] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getVvdCd] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( (vslCode[0] != null && !vslCode[0].equals("")) || (vslCode[1] != null && !vslCode[1].equals("")) || (vslCode[2] != null && !vslCode[2].equals("")) ) {
				flatFileForGateNewVO.setVessel(vslCode[0]);
				flatFileForGateNewVO.setVoyage(vslCode[1]);
				flatFileForGateNewVO.setDir(vslCode[2]);
				returnValue = true;
			}
		}
		
		return returnValue;
	}
	
	/**
	 * adjusting Container No 
	 *  adjustCntr for GateNew
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return boolean
	 * @exception EventException
	 **/
	private boolean adjustCntr( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String cntrNumber = "";
		/***** 2009.05.08 : Container No Check Using CONTAINER Table *****/			 
		if ( flatFileForGateNewVO.getCntrNumber().length() == 10 ) {
			int count = 0;
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNoCount(cntrNo)" +
						  "\n===============================================================\n");
				count = dbDao.getCntrNoCount(flatFileForGateNewVO.getCntrNumber());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCntrNoCount] DAOerr : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCntrNoCount] err : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}
			
			if (count >= 2) {
				return false;
			}
			
//			EXEC SQL
//			SELECT	CNTR_NO
//			INTO	:FlatFileVO.cntrNumber
//			FROM	(
//						SELECT	CNTR_NO
//						FROM	MST_CONTAINER
//						/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
//						WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
//						ORDER BY
//								CNMV_DT DESC
//					)
//			WHERE	ROWNUM  = 1

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNo(cntrNo)" +
						  "\n===============================================================\n");
				cntrNumber = dbDao.getCntrNo(flatFileForGateNewVO.getCntrNumber());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCntrNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCntrNo] err : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}				
		} else {
			
//			EXEC SQL
//			SELECT	CNTR_NO
//			INTO	:FlatFileVO.cntrNumber
//			FROM	(
//						SELECT	CNTR_NO
//						FROM	MST_CONTAINER
//						/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
//						WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
//						ORDER BY
//								CNMV_DT DESC
//					)
//			WHERE	ROWNUM  = 1

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNoNotLike(cntrNo)" +
						  "\n===============================================================\n");
				cntrNumber = dbDao.getCntrNoNotLike(flatFileForGateNewVO.getCntrNumber());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCntrNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCntrNo] err : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}				
		}

		if ( cntrNumber != null && !("").equals(cntrNumber) ) {
			String lstmCd = "";
			try {
				flatFileForGateNewVO.setCntrNumber(cntrNumber);
				
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getAciacDivCd" +
						  "\n===============================================================\n");
				lstmCd = dbDao.getAciacDivCd(flatFileForGateNewVO.getCntrNumber())[1];
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getAciacDivCd] DAOerr : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getAciacDivCd] err : " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}
			
			if (lstmCd != null && !lstmCd.equals("")) {
				flatFileForGateNewVO.setLstmCd(lstmCd);
			}
		}
		
		return true;
	}
	

}