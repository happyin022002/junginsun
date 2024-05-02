/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtBCImpl.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.clt.syscommon.common.util.FileUploadKeyUtil;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration.StevedoreDamageMgtDBDAO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.clt.bizcommon.currency.vo.MdmCurrencyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStepHisVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * OPUS-StevedoreDamageMgt Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VOP_OPF_0052EventResponse,StevedoreDamageMgtBC 
 * @since J2EE 1.4
 */
public class StevedoreDamageMgtBCImpl extends BasicCommandSupport implements StevedoreDamageMgtBC {

	// Database Access Object
	private transient StevedoreDamageMgtDBDAO dbDao = null;

	/**
	 * Creating object StevedoreDamageMgtBCImpl <br>
	 * Creating StevedoreDamageMgtDBDAO<br>
	 */
	public StevedoreDamageMgtBCImpl() {
		dbDao = new StevedoreDamageMgtDBDAO();
	}
	
	// VOP_OPF_0052 Start ============================================================//
	/**
	 * Retrieve Stevedore Damage Info <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgCreateVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCreateVO> searchDamage(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
		try {
			List<OpfStvDmgCreateVO> list = dbDao.searchDamage(opfStvDmgCreateVO);
			
//			if(list.size() < 1){
//				throw new EventException(new ErrorHandler("OPF00001").getMessage());
//			}
			return list;
		
//		} catch (EventException de) {
//			throw de;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Retrieve VVD Info of Stevedore Damage  <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> checkVVDInfo(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
		try {
			//if(opfStvDmgCreateVO!=null){
			//	for ( int i=0; i<opfStvDmgCreateVO .length; i++ ) {
					//List<OpfStvDmgVO> list = dbDao.checkVVDInfo(opfStvDmgCreateVO[i]);
					List<OpfStvDmgVO> list = dbDao.checkVVDInfo(opfStvDmgCreateVO);
					
					if(list.size() > 0){
						throw new EventException(new ErrorHandler("OPF00003").getMessage());
					}
			//	}
			//}
			return list;
		
		} catch (EventException de) {
			throw de;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}	

	/**
	 * Save Stevedore Damage Info <br>
	 * 
	 * @param OpfStvDmgCreateVO[] opfStvDmgCreateVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamage(OpfStvDmgCreateVO[] opfStvDmgCreateVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO , List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgVO> insertDmgVoList = new ArrayList<OpfStvDmgVO>();
			List<OpfStvDmgDtlVO> insertDmgDtlVoList = new ArrayList<OpfStvDmgDtlVO>();
			List<OpfStvDmgVO> updateDmgVoList = new ArrayList<OpfStvDmgVO>();
			List<OpfStvDmgDtlVO> updateDmgDtlVoList = new ArrayList<OpfStvDmgDtlVO>();
			List<OpfStvDmgVO> deleteDmgVoList = new ArrayList<OpfStvDmgVO>();
			List<OpfStvDmgDtlVO> deleteDmgDtlVoList = new ArrayList<OpfStvDmgDtlVO>();
			// History Data Insert..
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			List<OpfStvDmgStepHisVO> deleteStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			
			String etcData = "";
			String stvDmgNo = "";
			
			if(opfStvDmgCreateVO!=null){
				for ( int i=0; i<opfStvDmgCreateVO .length; i++ ) {										
					stvDmgNo = "";
					if(opfStvDmgCreateVO[i].getStvDmgNo() != null && !opfStvDmgCreateVO[i].getStvDmgNo().equals("")){
						stvDmgNo = opfStvDmgCreateVO[i].getStvDmgNo();
					}
					else{
						//Checking duplication VVD CD/Port/DamageDate Info
						/*List<OpfStvDmgVO> dmgCheckVO = dbDao.checkVVDInfo(opfStvDmgCreateVO[i]);
						if(dmgCheckVO.size() > 0){
							throw new EventException(new ErrorHandler("OPF00003").getMessage());
						}*/
						 
						//Get this year
						Calendar cal = Calendar.getInstance();  
						SimpleDateFormat year = new SimpleDateFormat("yy"); 
						String yy = year.format(cal.getTime());
					    
						//Get Max Serial No of Vsl Code selected..
//						<Changing SDMS Numbering system>
//						   [as-is]
//						    vessel code (4) + year (2) + vvd/port seq (3) + sub seq (2)
//						   [to-be]
//						    vessel code (4) + year (2) + month(2) + Vessel Category(1) + Damage Category(1) + sub seq(1)
//						   * Vessel Code(4) + Creation Year(2) + Vessel Category(1) + Damage Category(1) + Sub Seq (3)
//						    * vessel category
//						      - Container Own Ship     : 1 => CO
//						      - Container Charter Ship : 2 => CC
//						      - Bulk Own Ship            : 3 => BO
//						    * damage category
//						      - Hull           : 1 => HULL
//						      - Machinery      : 2 => MACH
//						      - Material       : 3 => MATL
//												
						if(yy.length()==1){
							yy = "0"+yy;
						}				 
						String vslCtrl ="";
						String dmgCtrl ="";
						if ("CO".equals(opfStvDmgCreateVO[i].getVslOshpCntrBlkTpCd())) {
							vslCtrl ="1";
						} else if ("CC".equals(opfStvDmgCreateVO[i].getVslOshpCntrBlkTpCd())){
							vslCtrl ="2";
						} else if ("BO".equals(opfStvDmgCreateVO[i].getVslOshpCntrBlkTpCd())){
							vslCtrl ="3";
						}
						
						if ("HULL".equals(opfStvDmgCreateVO[i].getStvDmgPrtCateCd())){
							dmgCtrl = "1";
						} else if ("MACH".equals(opfStvDmgCreateVO[i].getStvDmgPrtCateCd())){
							dmgCtrl = "2";
						} else if ("MATL".equals(opfStvDmgCreateVO[i].getStvDmgPrtCateCd())){
							dmgCtrl = "3";
						}
						
						// Vessel Code(4) + Creation Year(2) + Vessel Category(1) + Damage Category(1) + Sub Seq (3)
						String serialNo = dbDao.getStvDmgNo(opfStvDmgCreateVO[i].getVslCd()+yy+vslCtrl+dmgCtrl);
						stvDmgNo = opfStvDmgCreateVO[i].getVslCd()+yy+vslCtrl+dmgCtrl+serialNo;
						
					}
	
					OpfStvDmgVO opfStvDmgVO = new OpfStvDmgVO();
					if ( opfStvDmgCreateVO[i].getIbflag().equals("I")){
						opfStvDmgVO.setStvDmgNo(stvDmgNo);
					}else{
						opfStvDmgVO.setStvDmgNo(opfStvDmgCreateVO[i].getStvDmgNo());
					}
					opfStvDmgVO.setCreUsrId(account.getUsr_id());
					opfStvDmgVO.setUpdUsrId(account.getUsr_id());
					opfStvDmgVO.setVslCd(opfStvDmgCreateVO[i].getVslCd());
					opfStvDmgVO.setSkdVoyNo(opfStvDmgCreateVO[i].getSkdVoyNo());
					opfStvDmgVO.setSkdDirCd(opfStvDmgCreateVO[i].getSkdDirCd());
					opfStvDmgVO.setVpsPortCd(opfStvDmgCreateVO[i].getVpsPortCd());
					opfStvDmgVO.setStvDmgEvntDt(opfStvDmgCreateVO[i].getStvDmgEvntDt().replace("-", ""));
					opfStvDmgVO.setVslOshpCntrBlkTpCd(opfStvDmgCreateVO[i].getVslOshpCntrBlkTpCd());
					opfStvDmgVO.setStvDmgRefNo(opfStvDmgCreateVO[i].getStvDmgRefNo());
					opfStvDmgVO.setClmHndlOfcCd(opfStvDmgCreateVO[i].getClmHndlOfcCd());
					opfStvDmgVO.setDmgAuthStsCd(opfStvDmgCreateVO[i].getDmgAuthStsCd());
					opfStvDmgVO.setAuthUsrId(opfStvDmgCreateVO[i].getAuthUsrId());
					opfStvDmgVO.setAuthDt(opfStvDmgCreateVO[i].getAuthDt());
					
					OpfStvDmgDtlVO opfStvDmgDtlVO = new OpfStvDmgDtlVO();
					if ( opfStvDmgCreateVO[i].getIbflag().equals("I")){
						opfStvDmgDtlVO.setStvDmgNo(stvDmgNo);
					}else{
						opfStvDmgDtlVO.setStvDmgNo(opfStvDmgCreateVO[i].getStvDmgNo());
					}
					opfStvDmgDtlVO.setCreUsrId(account.getUsr_id());
					opfStvDmgDtlVO.setUpdUsrId(account.getUsr_id());
					opfStvDmgDtlVO.setStvDmgPrtCateCd(opfStvDmgCreateVO[i].getStvDmgPrtCateCd());
					opfStvDmgDtlVO.setStvDmgPrtCd(opfStvDmgCreateVO[i].getStvDmgPrtCd());
					opfStvDmgDtlVO.setStvDmgTpCd(opfStvDmgCreateVO[i].getStvDmgTpCd());
					opfStvDmgDtlVO.setStvDmgLocDesc(opfStvDmgCreateVO[i].getStvDmgLocDesc());
					opfStvDmgDtlVO.setStvDmgRptAtchFlg(opfStvDmgCreateVO[i].getStvDmgRptAtchFlg());
					opfStvDmgDtlVO.setStvDmgPictAtchFlg(opfStvDmgCreateVO[i].getStvDmgPictAtchFlg());
					opfStvDmgDtlVO.setStvDmgDocAtchFlg(opfStvDmgCreateVO[i].getStvDmgDocAtchFlg());
					opfStvDmgDtlVO.setCntrDmgFlg(opfStvDmgCreateVO[i].getCntrDmgFlg());
					opfStvDmgDtlVO.setCgoDmgFlg(opfStvDmgCreateVO[i].getCgoDmgFlg());
					opfStvDmgDtlVO.setCntrNo(opfStvDmgCreateVO[i].getCntrNo());
					opfStvDmgDtlVO.setFmTmLssDt(opfStvDmgCreateVO[i].getFmTmLssDt());
					opfStvDmgDtlVO.setToTmLssDt(opfStvDmgCreateVO[i].getToTmLssDt());
					opfStvDmgDtlVO.setStvDmgRmk(opfStvDmgCreateVO[i].getStvDmgRmk());
					opfStvDmgDtlVO.setStvDmgReqCateCd(opfStvDmgCreateVO[i].getStvDmgReqCateCd());
					opfStvDmgDtlVO.setReqVslCd(opfStvDmgCreateVO[i].getReqVslCd());
					opfStvDmgDtlVO.setReqSkdVoyNo(opfStvDmgCreateVO[i].getReqSkdVoyNo());
					opfStvDmgDtlVO.setReqSkdDirCd(opfStvDmgCreateVO[i].getReqSkdDirCd());
					opfStvDmgDtlVO.setReqPortCd(opfStvDmgCreateVO[i].getReqPortCd());
					opfStvDmgDtlVO.setReqEtaDt(opfStvDmgCreateVO[i].getReqEtaDt());
					//opfStvDmgDtlVO.setStvDmgQttnCateCd(opfStvDmgCreateVO[i].getStvDmgQttnCateCd());
					opfStvDmgDtlVO.setStvDmgQttnCd(opfStvDmgCreateVO[i].getStvDmgQttnCd());
					opfStvDmgDtlVO.setStvDmgQttnRsnDesc(opfStvDmgCreateVO[i].getStvDmgQttnRsnDesc());
					opfStvDmgDtlVO.setStvDmgRespbPtyKwnFlg(opfStvDmgCreateVO[i].getStvDmgRespbPtyKwnFlg());
					//opfStvDmgDtlVO.setStvDmgRespbCateCd(opfStvDmgCreateVO[i].getStvDmgRespbCateCd());
					opfStvDmgDtlVO.setStvDmgRespbCd(opfStvDmgCreateVO[i].getStvDmgRespbCd());
					opfStvDmgDtlVO.setStvDmgRespbDesc(opfStvDmgCreateVO[i].getStvDmgRespbDesc());
					
					opfStvDmgDtlVO.setStvDmgRptAtchKnt(opfStvDmgCreateVO[i].getStvDmgRptAtchKnt());
					opfStvDmgDtlVO.setStvDmgPictAtchKnt(opfStvDmgCreateVO[i].getStvDmgPictAtchKnt());
					opfStvDmgDtlVO.setStvDmgDocAtchKnt(opfStvDmgCreateVO[i].getStvDmgDocAtchKnt());
					
					if ( opfStvDmgCreateVO[i].getIbflag().equals("I")){
						insertDmgVoList.add(opfStvDmgVO);
						insertDmgDtlVoList.add(opfStvDmgDtlVO);
						
						etcData = etcData + stvDmgNo+"|";
						
					} else if ( opfStvDmgCreateVO[i].getIbflag().equals("U")){
						updateDmgVoList.add(opfStvDmgVO);
						updateDmgDtlVoList.add(opfStvDmgDtlVO);
						
					} else if ( opfStvDmgCreateVO[i].getIbflag().equals("D")){
						deleteDmgVoList.add(opfStvDmgVO);
						deleteDmgDtlVoList.add(opfStvDmgDtlVO);
					}
					
					//History........................................................//
					String hisSeq = "1";
					String hisBeforeStsCd = "";
					OpfStvDmgStepHisVO hisVO = new OpfStvDmgStepHisVO();
					//Map<String, String> mapVO = dbDao.searchHistoryMaxSeq(opfStvDmgDtlVO.getStvDmgNo(), "D");
					OpfStvDmgStepHisVO hisSeqVO = dbDao.searchHistoryMaxSeq(opfStvDmgDtlVO.getStvDmgNo(), "D");
					if(hisSeqVO != null){
						//hisSeq = mapVO.get("seq");
						//hisBeforeStsCd = mapVO.get("beforeStsCd");
						hisSeq         = hisSeqVO.getStvDmgStepHisSeq();
						hisBeforeStsCd = hisSeqVO.getStvDmgProcCd();
					}
					hisVO.setStvDmgNo(opfStvDmgDtlVO.getStvDmgNo());
					hisVO.setStvDmgProcCd("D");
					hisVO.setStvDmgStepHisSeq(hisSeq);
					hisVO.setStvDmgCrntProcStsCd(opfStvDmgDtlVO.getStvDmgReqCateCd());
					//hisVO.setStvDmgPreProcStsCd(hisBeforeStsCd);
					//hisVO.setStvDmgPreProcCd("");
					hisVO.setCreUsrId(account.getUsr_id());
					hisVO.setUpdUsrId(account.getUsr_id());
					
					if(opfStvDmgCreateVO[i].getIbflag().equals("I")){
						insertStvDmgStepHisVoList.add(hisVO);
					}
					else if(opfStvDmgCreateVO[i].getIbflag().equals("U")
							&& !hisBeforeStsCd.equals(opfStvDmgDtlVO.getStvDmgReqCateCd()))
					{
						//In case Update, Insert History in case of changing Status
						insertStvDmgStepHisVoList.add(hisVO);
					}
					else if(opfStvDmgCreateVO[i].getIbflag().equals("D")){
						deleteStvDmgStepHisVoList.add(hisVO);
					}
					//History........................................................//
					
				}
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY value
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(stvDmgNo);
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					// SETTING FILE UPLOAD KEY value
//					if(keyArr != null) {
//						if(keyArr.hasNext()){
//							opfStvDmgAtchFileVO[j].setFileSavId(keyArr.next());
//						}
//					}
					if(keys != null) {
						opfStvDmgAtchFileVO[j].setFileSavId (FileUploadKeyUtil.getFileSavIdByOriginName(  opfStvDmgAtchFileVO[j].getFileNm() , keys) );
					} else {
						opfStvDmgAtchFileVO[j].setFileSavId ("");
					}
					if(opfStvDmgAtchFileVO[j].getIbflag().equals("I")){
						opfStvDmgAtchFileVO[j].setCreUsrId(account.getUsr_id());
						insertOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("U")){
						updateOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("D")){
						deleteOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
				}
			}
			
			if ( insertDmgVoList.size() > 0 ) {
				dbDao.addDamage(insertDmgVoList);
				dbDao.addDamageDetail(insertDmgDtlVoList);
			}
			
			if ( updateDmgVoList.size() > 0 ) {
				dbDao.modifyDamage(updateDmgVoList);
				dbDao.modifyDamageDetail(updateDmgDtlVoList);
			}
			
			if ( deleteDmgVoList.size() > 0 ) {
				//dbDao.removeDamage(deleteDmgVoList);
				dbDao.removeDamageDetail(deleteDmgDtlVoList);
				dbDao.removeDamageAllAttachFile(deleteDmgVoList);
			}
		
			//History........................................................//
			if ( insertStvDmgStepHisVoList.size() > 0 ) {
				dbDao.addDamageHistory(insertStvDmgStepHisVoList);
			}
			if ( deleteStvDmgStepHisVoList.size() > 0 ) {
				dbDao.removeDamageHistory(deleteStvDmgStepHisVoList);
			}
			//History........................................................//
			
			// File Upload Data..
			
			if ( deleteOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.removeDamageAttachFile(deleteOpfStvDmgAtchFileVOList);
			}
			if ( updateOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.modifyDamageAttachFile(updateOpfStvDmgAtchFileVOList);
			}
			if ( insertOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.addDamageAttachFile(insertOpfStvDmgAtchFileVOList);
			}

			if ( deleteDmgVoList.size() > 0 ) {
				dbDao.removeDamage(deleteDmgVoList);
			}
			
			// Remove Repair/compensation/settlement
			if ( deleteDmgVoList.size() > 0 ) { 
				dbDao.removeDamageRepair(deleteDmgVoList);
				dbDao.removeDamageCompensation(deleteDmgVoList);
				dbDao.removeDamageSettlement(deleteDmgVoList);
			}
			
			String returnStr = "";
			
			if(etcData!=null && !etcData.equals("")){
				returnStr = etcData.substring(0,etcData.lastIndexOf("|"));
			}
			
			return returnStr;
			
		} catch (EventException de) {
			throw de;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Delete Stevedore Damage Info <br>
	 * 
	 * @param String delStvDmgNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamage(String delStvDmgNo, SignOnUserAccount account) throws EventException{
		try {
			
			dbDao.deleteDamageDetail(delStvDmgNo);			//OPF_STV_DMG_DTL
			dbDao.deleteDamageAllAttachFile(delStvDmgNo);	//OPF_STV_DMG_ATCH_FILE
			dbDao.deleteDamageHistory(delStvDmgNo);			//OPF_STV_DMG_STEP_HIS
			dbDao.deleteDamageRepair(delStvDmgNo);			//OPF_STV_DMG_RPR
			dbDao.deleteDamageCompensation(delStvDmgNo);	//OPF_STV_DMG_CMPN
			dbDao.deleteDamageSettlement(delStvDmgNo);		//OPF_STV_DMG_STL
			dbDao.deleteDamage(delStvDmgNo);				//OPF_STV_DMG
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Save Stevedore Damage Approval Info <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApproval(OpfStvDmgCreateVO opfStvDmgCreateVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.updateApproval(opfStvDmgCreateVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling retrieve event VVD Port Code and ETA/ETD Data of StevedoreDamageMgt page<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchVskVslPortSkdVO(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
		try {
			return dbDao.searchVskVslPortSkdVO(opfStvDmgCreateVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Lane Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslSkdVO>
	 * @exception EventException
	 */
	public List<VskVslSkdVO> searchLaneCode(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
		try {
			return dbDao.searchLaneCode(opfStvDmgCreateVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Common Code retrieve event of StevedoreDamageMgt page<br>
	 * 
	 * @param String codeID
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchComCodeList(String codeID) throws EventException {
		try {
			return dbDao.searchComCodeList(codeID);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12203").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12203").getMessage());
		}
	}
	
	/**
	 * Handling Approval Permission retrieve event of StevedoreDamageMgt page<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int searchApprovalPermissionCheck(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchApprovalPermissionCheck(account.getUsr_id());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Office Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @exception EventException
	 */
	public List<MdmOrganizationVO> searchOfficeCode(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfficeCode(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}

	/**
	 * Handling E-mail [PIC of Claim Handling Office] retrieve event of Stevedore Damage page<br>
	 * 
	 * @param String ofcCd
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchMailContentPic(String ofcCd) throws EventException {
		try {
			return dbDao.searchMailContentPic(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	// VOP_OPF_0052 End ============================================================//
	
	// VOP_OPF_0053 Start ============================================================//
	/**
	 *  Handling retrieve event of Stevedore Damage Inquiry page<br>
	 * 
	 * @param SdmsOptionVO sdmsOptionVO
	 * @return List<SdmsOptionVO>
	 * @exception EventException
	 */
	public List<SdmsOptionVO> searchSDList(SdmsOptionVO sdmsOptionVO) throws EventException {
		try {
			return dbDao.searchSDList(sdmsOptionVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001", new String[]{"Stevedore Damage Inquiry"}).getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001", new String[]{"Stevedore Damage Inquiry"}).getMessage());
		}
	}
	// VOP_OPF_0053 End ============================================================//
	
	// VOP_OPF_1053 Start ============================================================//
	/**
	 * Handling retrieve event of Stevedore Damage Details page<br>
	 * 
	 * @param String stvDmgNo
	 * @return SdmsDetailsGRPVO
	 * @exception EventException
	 */
	public SdmsDetailsGRPVO searchSdmsDetails(String stvDmgNo) throws EventException {
		try {
			SdmsDetailsGRPVO grpVO = new SdmsDetailsGRPVO();
			
			grpVO.setOpfStvDmgVOs(dbDao.searchSdmsDamage(stvDmgNo));
			grpVO.setOpfStvDmgDtlVOs(dbDao.searchSdmsDamageDtl(stvDmgNo));
			grpVO.setOpfStvDmgRprVOs(dbDao.searchSdmsDamageRpr(stvDmgNo));
			grpVO.setOpfStvDmgCmpnVOs(dbDao.searchSdmsDamageCmpn(stvDmgNo));
			grpVO.setOpfStvDmgStlVOs(dbDao.searchSdmsDamageStl(stvDmgNo));

			grpVO.setOpfStvDmgAtchFileDSDRVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "SDR", "D"));
			grpVO.setOpfStvDmgAtchFileDPICVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "PIC", "D"));
			grpVO.setOpfStvDmgAtchFileDDOCVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "DOC", "D"));
			
			grpVO.setOpfStvDmgAtchFileRRESVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "RES", "R"));
			grpVO.setOpfStvDmgAtchFileRINVVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "INV", "R"));
			grpVO.setOpfStvDmgAtchFileRPICVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "PIC", "R"));
			grpVO.setOpfStvDmgAtchFileRDOCVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "DOC", "R"));
			
			grpVO.setOpfStvDmgAtchFileSINVVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "INV", "S"));
			grpVO.setOpfStvDmgAtchFileSDOCVOs(dbDao.searchSdmsDamageAtchFile(stvDmgNo, "DOC", "S"));
			
			return grpVO;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling User Name retrieve event of Stevedore Damage Update <br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchUserName(String usrId, String ofcCd) throws EventException{
		try {
			return dbDao.searchUserName(usrId, ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling USD_AMT retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param String loclAmt
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalPayUsd(String loclAmt, String currCd) throws EventException{
		try {
			return dbDao.searchLocalPayUsd(loclAmt, currCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}	
	
	/**
	 * Handling Default Currency retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchDefaultCurrency(String ofcCd) throws EventException{
		try {
			return dbDao.searchDefaultCurrency(ofcCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Currency Code retrieve event of Stevedore Damage page<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyCode() throws EventException{
		try {
			return dbDao.searchCurrencyCode();
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Damage Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgVO opfStvDmgVO
	 * @return List<OpfStvDmgVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgVO> searchStvDamage(OpfStvDmgVO opfStvDmgVO) throws EventException {
		try {
			return dbDao.searchStvDamage(opfStvDmgVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Detail Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgDtlVO opfStvDmgDtlVO
	 * @return List<OpfStvDmgDtlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgDtlVO> searchDamageDetail(OpfStvDmgDtlVO opfStvDmgDtlVO) throws EventException {
		try {
			return dbDao.searchDamageDetail(opfStvDmgDtlVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Repair Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgRprVO opfStvDmgRprVO
	 * @return List<OpfStvDmgRprVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgRprVO> searchDamageRepair(OpfStvDmgRprVO opfStvDmgRprVO) throws EventException {
		try {
			return dbDao.searchDamageRepair(opfStvDmgRprVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Compensation Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgCmpnVO opfStvDmgCmpnVO
	 * @return List<OpfStvDmgCmpnVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCmpnVO> searchDamageCompensation(OpfStvDmgCmpnVO opfStvDmgCmpnVO) throws EventException {
		try {
			return dbDao.searchDamageCompensation(opfStvDmgCmpnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Settlement Info retrieve event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgStlVO opfStvDmgStlVO
	 * @return List<OpfStvDmgStlVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgStlVO> searchDamageSettlement(OpfStvDmgStlVO opfStvDmgStlVO) throws EventException {
		try {
			return dbDao.searchDamageSettlement(opfStvDmgStlVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Handling Damage Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgVO[] opfStvDmgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageStvDamage(OpfStvDmgVO[] opfStvDmgVO, SignOnUserAccount account) throws EventException{
		try {
			//List<OpfStvDmgVO> insertVoList = new ArrayList<OpfStvDmgVO>();
			List<OpfStvDmgVO> updateVoList = new ArrayList<OpfStvDmgVO>();
			//List<OpfStvDmgVO> deleteVoList = new ArrayList<OpfStvDmgVO>();
			for ( int i=0; i<opfStvDmgVO .length; i++ ) {
//				if ( opfStvDmgVO[i].getIbflag().equals("I")){
//					opfStvDmgVO[i].setCreUsrId(account.getUsr_id());
//					opfStvDmgVO[i].setUpdUsrId(account.getUsr_id());
//					insertVoList.add(opfStvDmgVO[i]);
//				} else 
				if ( opfStvDmgVO[i].getIbflag().equals("U")){
					opfStvDmgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfStvDmgVO[i]);
				} 
//				else if ( opfStvDmgVO[i].getIbflag().equals("D")){
//					deleteVoList.add(opfStvDmgVO[i]);
//				}
			}
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addManageStvDamage(insertVoList);
//			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamage(updateVoList);
			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeManageStvDamage(deleteVoList);
//			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Detail Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgDtlVO[] opfStvDmgDtlVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageDetail(OpfStvDmgDtlVO[] opfStvDmgDtlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, SignOnUserAccount account) throws EventException{
		
		try {
			List<OpfStvDmgDtlVO> updateVoList = new ArrayList<OpfStvDmgDtlVO>();
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();			
			
			for ( int i=0; i<opfStvDmgDtlVO .length; i++ ) {
				if ( opfStvDmgDtlVO[i].getIbflag().equals("U")){
					opfStvDmgDtlVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfStvDmgDtlVO[i]);
					
					//History........................................................//
					String hisSeq = "1";
					String hisBeforeStsCd = "";
					OpfStvDmgStepHisVO hisVO = new OpfStvDmgStepHisVO();
					//Map<String, String> mapVO = dbDao.searchHistoryMaxSeq(opfStvDmgDtlVO[i].getStvDmgNo(), "D");
					OpfStvDmgStepHisVO hisSeqVO = dbDao.searchHistoryMaxSeq(opfStvDmgDtlVO[i].getStvDmgNo(), "D");
					if(hisSeqVO != null){
						//hisSeq = mapVO.get("seq");
						//hisBeforeStsCd = mapVO.get("beforeStsCd");
						hisSeq         = hisSeqVO.getStvDmgStepHisSeq();
						hisBeforeStsCd = hisSeqVO.getStvDmgProcCd();
					}
					hisVO.setStvDmgNo(opfStvDmgDtlVO[i].getStvDmgNo());
					hisVO.setStvDmgProcCd("D");
					hisVO.setStvDmgStepHisSeq(hisSeq);
					hisVO.setStvDmgCrntProcStsCd(opfStvDmgDtlVO[i].getStvDmgReqCateCd());
					//hisVO.setStvDmgPreProcStsCd(hisBeforeStsCd);
					//hisVO.setStvDmgPreProcCd("");
					hisVO.setCreUsrId(account.getUsr_id());
					hisVO.setUpdUsrId(account.getUsr_id());
					
					if(!hisBeforeStsCd.equals(opfStvDmgDtlVO[i].getStvDmgReqCateCd()))
					{
						//In case Update, Insert History in case of changing Status
						insertStvDmgStepHisVoList.add(hisVO);
					}
					//History........................................................//
				} 
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY value
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgDtlVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					//SETTING FILE UPLOAD KEY value
					if(keyArr != null && opfStvDmgAtchFileVO[j].getIbflag().equals("I")) {
						if(keyArr.hasNext()){
							opfStvDmgAtchFileVO[j].setFileSavId(keyArr.next());
						}
					}
					if(opfStvDmgAtchFileVO[j].getIbflag().equals("I")){
						opfStvDmgAtchFileVO[j].setCreUsrId(account.getUsr_id());
						insertOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("U")){
						updateOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("D")){
						deleteOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamageDetail(updateVoList);
			}
			//History........................................................//
			if ( insertStvDmgStepHisVoList.size() > 0 ) {
				dbDao.addDamageHistory(insertStvDmgStepHisVoList);
			}
			//History........................................................//
			
			// File Upload Data..
			if ( deleteOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.removeDamageAttachFile(deleteOpfStvDmgAtchFileVOList);
			}
			if ( updateOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.modifyDamageAttachFile(updateOpfStvDmgAtchFileVOList);
			}
			if ( insertOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.addDamageAttachFile(insertOpfStvDmgAtchFileVOList);
			}			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Repair Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgRprVO[] opfStvDmgRprVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageRepair(OpfStvDmgRprVO[] opfStvDmgRprVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO , List<String> keys, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgRprVO> insertVoList = new ArrayList<OpfStvDmgRprVO>();
			List<OpfStvDmgRprVO> updateVoList = new ArrayList<OpfStvDmgRprVO>();
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();	
			
			for ( int i=0; i<opfStvDmgRprVO .length; i++ ) {
				if ( opfStvDmgRprVO[i].getIbflag().equals("I")){
					opfStvDmgRprVO[i].setCreUsrId(account.getUsr_id());
					opfStvDmgRprVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(opfStvDmgRprVO[i]);
				} else if ( opfStvDmgRprVO[i].getIbflag().equals("U")){
					opfStvDmgRprVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfStvDmgRprVO[i]);
				} 
				
				//History........................................................//
				String hisSeq = "1";
				String hisBeforeStsCd = "";
				OpfStvDmgStepHisVO hisVO = new OpfStvDmgStepHisVO();
				//Map<String, String> mapVO = dbDao.searchHistoryMaxSeq(opfStvDmgRprVO[i].getStvDmgNo(), "R");
				OpfStvDmgStepHisVO hisSeqVO = dbDao.searchHistoryMaxSeq(opfStvDmgRprVO[i].getStvDmgNo(), "R");
				if(hisSeqVO != null){
					//hisSeq = mapVO.get("seq");
					//hisBeforeStsCd = mapVO.get("beforeStsCd");
					hisSeq         = hisSeqVO.getStvDmgStepHisSeq();
					hisBeforeStsCd = hisSeqVO.getStvDmgProcCd();
				}
				hisSeq = String.valueOf(Integer.parseInt(hisSeq)+i);
				
				hisVO.setStvDmgNo(opfStvDmgRprVO[i].getStvDmgNo());
				hisVO.setStvDmgProcCd("R");
				hisVO.setStvDmgStepHisSeq(hisSeq);
				hisVO.setStvDmgCrntProcStsCd(opfStvDmgRprVO[i].getStvDmgRprProcStsCd());
				//hisVO.setStvDmgPreProcStsCd(hisBeforeStsCd);
				//hisVO.setStvDmgPreProcCd("D");
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				
				if(opfStvDmgRprVO[i].getIbflag().equals("I")){
					insertStvDmgStepHisVoList.add(hisVO);
				}
				else if(opfStvDmgRprVO[i].getIbflag().equals("U")
						&& !hisBeforeStsCd.equals(opfStvDmgRprVO[i].getStvDmgRprProcStsCd()))
				{
					//In case Update, Insert History in case of changing Status
					insertStvDmgStepHisVoList.add(hisVO);
				}
				//History........................................................//
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY value
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgRprVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					//SETTING FILE UPLOAD KEY value
					if(keyArr != null && opfStvDmgAtchFileVO[j].getIbflag().equals("I")) {
						if(keyArr.hasNext()){
							opfStvDmgAtchFileVO[j].setFileSavId(keyArr.next());
						}
					}
					if(opfStvDmgAtchFileVO[j].getIbflag().equals("I")){
						opfStvDmgAtchFileVO[j].setCreUsrId(account.getUsr_id());
						insertOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("U")){
						updateOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("D")){
						deleteOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
				}
			}
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDamageRepair(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamageRepair(updateVoList);
			}
			//History........................................................//
			if ( insertStvDmgStepHisVoList.size() > 0 ) {
				dbDao.addDamageHistory(insertStvDmgStepHisVoList);
			}
			//History........................................................//
			
			// File Upload Data..
			if ( deleteOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.removeDamageAttachFile(deleteOpfStvDmgAtchFileVOList);
			}
			if ( updateOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.modifyDamageAttachFile(updateOpfStvDmgAtchFileVOList);
			}
			if ( insertOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.addDamageAttachFile(insertOpfStvDmgAtchFileVOList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Compensation Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgCmpnVO[] opfStvDmgCmpnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageCompensation(OpfStvDmgCmpnVO[] opfStvDmgCmpnVO, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgCmpnVO> insertVoList = new ArrayList<OpfStvDmgCmpnVO>();
			List<OpfStvDmgCmpnVO> updateVoList = new ArrayList<OpfStvDmgCmpnVO>();
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			for ( int i=0; i<opfStvDmgCmpnVO .length; i++ ) {

				opfStvDmgCmpnVO[i].setUpdUsrId(account.getUsr_id());
				opfStvDmgCmpnVO[i].setClmHndlOfcCd(account.getOfc_cd());
				opfStvDmgCmpnVO[i].setClmHndlUsrId(account.getUsr_id());
				opfStvDmgCmpnVO[i].setClmHndlUsrNm(account.getUsr_nm());
				
				if ( opfStvDmgCmpnVO[i].getIbflag().equals("I")){
					opfStvDmgCmpnVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(opfStvDmgCmpnVO[i]);
				} else if ( opfStvDmgCmpnVO[i].getIbflag().equals("U")){
					updateVoList.add(opfStvDmgCmpnVO[i]);
				} 
				
				//History........................................................//
				String hisSeq = "1";
				String hisBeforeStsCd = "";
				OpfStvDmgStepHisVO hisVO = new OpfStvDmgStepHisVO();
				//Map<String, String> mapVO = dbDao.searchHistoryMaxSeq(opfStvDmgCmpnVO[i].getStvDmgNo(), "C");
				OpfStvDmgStepHisVO hisSeqVO = dbDao.searchHistoryMaxSeq(opfStvDmgCmpnVO[i].getStvDmgNo(), "C");
				if(hisSeqVO != null){
					//hisSeq = mapVO.get("seq");
					//hisBeforeStsCd = mapVO.get("beforeStsCd");
					hisSeq         = hisSeqVO.getStvDmgStepHisSeq();
					hisBeforeStsCd = hisSeqVO.getStvDmgProcCd();
				}
				hisVO.setStvDmgNo(opfStvDmgCmpnVO[i].getStvDmgNo());
				hisVO.setStvDmgProcCd("C");
				hisVO.setStvDmgStepHisSeq(hisSeq);
				hisVO.setStvDmgCrntProcStsCd(opfStvDmgCmpnVO[i].getStvDmgCmpnProcStsCd());
				//hisVO.setStvDmgPreProcStsCd(hisBeforeStsCd);
				//hisVO.setStvDmgPreProcCd("R");
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				
				if(opfStvDmgCmpnVO[i].getIbflag().equals("I")){
					insertStvDmgStepHisVoList.add(hisVO);
				}
				else if(opfStvDmgCmpnVO[i].getIbflag().equals("U")
						&& !hisBeforeStsCd.equals(opfStvDmgCmpnVO[i].getStvDmgCmpnProcStsCd()))
				{
					//In case Update, Insert History in case of changing Status
					insertStvDmgStepHisVoList.add(hisVO);
				}
				//History........................................................//
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDamageCompensation(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamageCompensation(updateVoList);
			}
			//History........................................................//
			if ( insertStvDmgStepHisVoList.size() > 0 ) {
				dbDao.addDamageHistory(insertStvDmgStepHisVoList);
			}
			//History........................................................//
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Handling Damage Settlement Info save event of Stevedore Damage Update page<br>
	 * 
	 * @param OpfStvDmgStlVO[] opfStvDmgStlVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageSettlement(OpfStvDmgStlVO[] opfStvDmgStlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO , List<String> keys, SignOnUserAccount account) throws EventException{		
		try {
			List<OpfStvDmgStlVO> insertVoList = new ArrayList<OpfStvDmgStlVO>();
			List<OpfStvDmgStlVO> updateVoList = new ArrayList<OpfStvDmgStlVO>();
			
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();	
			
			if(opfStvDmgStlVO != null){
				for ( int i=0; i<opfStvDmgStlVO .length; i++ ) {
					if ( opfStvDmgStlVO[i].getIbflag().equals("I")){
						opfStvDmgStlVO[i].setCreUsrId(account.getUsr_id());
						opfStvDmgStlVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(opfStvDmgStlVO[i]);
					} else if ( opfStvDmgStlVO[i].getIbflag().equals("U")){
						opfStvDmgStlVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(opfStvDmgStlVO[i]);
					} 
				}
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY value
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgStlVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());

					//SETTING FILE UPLOAD KEY value
					if(keyArr != null && opfStvDmgAtchFileVO[j].getIbflag().equals("I")) {
						if(keyArr.hasNext()){
							opfStvDmgAtchFileVO[j].setFileSavId(keyArr.next());
						}
					}
					if(opfStvDmgAtchFileVO[j].getIbflag().equals("I")){
						opfStvDmgAtchFileVO[j].setCreUsrId(account.getUsr_id());
						insertOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("U")){
						updateOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
					else if(opfStvDmgAtchFileVO[j].getIbflag().equals("D")){
						deleteOpfStvDmgAtchFileVOList.add(opfStvDmgAtchFileVO[j]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDamageSettlement(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamageSettlement(updateVoList);
			}
			
			// File Upload Data..
			if ( deleteOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.removeDamageAttachFile(deleteOpfStvDmgAtchFileVOList);
			}
			if ( updateOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.modifyDamageAttachFile(updateOpfStvDmgAtchFileVOList);
			}
			if ( insertOpfStvDmgAtchFileVOList.size() > 0 ) {
				dbDao.addDamageAttachFile(insertOpfStvDmgAtchFileVOList);
			}			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Method used in case of Payment Data Insert in FMS<br>
	 * 
	 * @param CustomSdmsSettlementVO[] customSdmsSettlementVOs
	 * @exception EventException
	 */
	public void addSettlementFMS(CustomSdmsSettlementVO[] customSdmsSettlementVOs) throws EventException{
		try {
			List<CustomSdmsSettlementVO> insertVoList = new ArrayList<CustomSdmsSettlementVO>();
			
			for ( int i=0; i<customSdmsSettlementVOs.length; i++ ) {
				if ( customSdmsSettlementVOs[i].getIbflag().equals("I")){
					insertVoList.add(customSdmsSettlementVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSettlementFMS(insertVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Method used in case of Payment Data Delete in FMS<br>
	 * 
	 * @param CustomInvDtlVO[] customInvDtlVOs
	 * @exception EventException
	 */
	public void removeSettlementFMS(CustomInvDtlVO[] customInvDtlVOs) throws EventException{
		try {
			List<CustomInvDtlVO> deleteVoList = new ArrayList<CustomInvDtlVO>();
			
			for ( int i=0; i<customInvDtlVOs.length; i++ ) {
				// In case ibflag is 'D' and sdmsNo exists, become the object of actual delete. 
				if( customInvDtlVOs[i].getIbflag().equals("D")
				     && !customInvDtlVOs[i].getSdmsNo().equals("")) 
				{
					deleteVoList.add(customInvDtlVOs[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSettlementFMS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VOP_OPF_1053 : Adding checking logic whether save is available in case of moving Tab
	 * 
	 * @param String tabName
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */		
	public String checkTabSavable(String tabName, String stvDmgNo) throws EventException {
		try {
			return dbDao.checkTabSavable(tabName, stvDmgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}		
	}
	// VOP_OPF_1053 End ============================================================//
	
	// VOP_OPF_0054 Start ============================================================//
	/**
	 * Retrieve Info of Stevedore Damage History <br>
	 * 
	 * @param SdmsStepHistoryVO sdmsStepHistoryVO
	 * @return List<SdmsStepHistoryVO>
	 * @exception EventException
	 */
	public List<SdmsStepHistoryVO> searchSDHistoryList(SdmsStepHistoryVO sdmsStepHistoryVO) throws EventException {
		try {
			return dbDao.searchSDHistoryList(sdmsStepHistoryVO.getStvDmgNo());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Save Info of Stevedore Damage History <br>
	 * 
	 * @param OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDamageHistory(OpfStvDmgStepHisVO[] opfStvDmgStepHisVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgStepHisVO> insertVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			for ( int i=0; i<opfStvDmgStepHisVOs .length; i++ ) {
				opfStvDmgStepHisVOs[i].setCreUsrId(account.getUsr_id());
				opfStvDmgStepHisVOs[i].setUpdUsrId(account.getUsr_id());
				insertVoList.add(opfStvDmgStepHisVOs[i]);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDamageHistory(insertVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	// VOP_OPF_0054 End ============================================================//
	
	// VOP_OPF_1052 Start ============================================================//
	/**
	 *  Handling retrieve event of StevedoreDamageMgt page<br>
	 *  Retrieve File Upload Data
	 * 
	 * @param OpfStvDmgAtchFileVO opfStvDmgAtchFileVO
	 * @return List<OpfStvDmgAtchFileVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgAtchFileVO> searchDamageAttachFile(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO) throws EventException {
		try {
			return dbDao.searchDamageAttachFile(opfStvDmgAtchFileVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("OPF00001").getMessage());
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("OPF00001").getMessage());
        }
	} 
	// VOP_OPF_1052 End ============================================================//
	
	// VOP_OPF_2052 Start ============================================================//
	/**
	 *  Handling mail transmitting event of StevedoreDamageMgt page<br>
	 *  Transmitting VOP_OPF_1153 Report page to mail
	 * 
	 * @param event   Event
	 * @return String
	 * @exception EventException
	 */
//	public String sendMail(Event event) throws EventException {
//		try {
//			StevedoreDamageMgtEAIDAO mailDAO = new StevedoreDamageMgtEAIDAO();
//			return mailDAO.sendMail(event);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}
	// VOP_OPF_2052 End ============================================================//
	
	// VOP_OPF_0056 Start ============================================================//
	/**
	 * Retrieve Stevedore Damage Performance Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsReportVO>
	 * @exception EventException
	 */
	public List<SdmsReportVO> searchSdmsReportList(SdmsReportVO sdmsReportVO) throws EventException {
		try {
			return dbDao.searchSdmsReportList(sdmsReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Retrieve Stevedore Damage Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsDamageReportVO>
	 * @exception EventException
	 */
	public List<SdmsDamageReportVO> searchDamageReportList(SdmsReportVO sdmsReportVO) throws EventException {
		try {
			return dbDao.searchDamageReportList(sdmsReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Retrieve Stevedore Damage Repair Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsRepairReportVO>
	 * @exception EventException
	 */
	public List<SdmsRepairReportVO> searchRepairReportList(SdmsReportVO sdmsReportVO) throws EventException {
		try {
			return dbDao.searchRepairReportList(sdmsReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Retrieve Stevedore Damage Compensation Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsCompensationReportVO>
	 * @exception EventException
	 */
	public List<SdmsCompensationReportVO> searchCompensationReportList(SdmsReportVO sdmsReportVO) throws EventException {
		try {
			return dbDao.searchCompensationReportList(sdmsReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Retrieve Stevedore Damage Settlement Report Info<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsSettlementReportVO>
	 * @exception EventException
	 */
	public List<SdmsSettlementReportVO> searchSettlementReportList(SdmsReportVO sdmsReportVO) throws EventException {
		try {
			return dbDao.searchSettlementReportList(sdmsReportVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	// VOP_OPF_0056 End ============================================================//
	/**
	 * Checking VSL,VVD,Lane,Port Code Validation .<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkMainCode(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			return dbDao.checkMainCode(vskVslPortSkdVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * VOP_OPF_0052 :Adding checking logic whether delete is available in case of Delete
	 * 
	 * @param String stvDmgNo
	 * @return String
	 * @exception EventException
	 */		
	public String checkDeleteFlag(String stvDmgNo) throws EventException {
		try {
			return dbDao.checkDeleteFlag(stvDmgNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}		
	}

	/**
	 * Retrieve ETB, ETD to VVD, Port
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<VskVslPortSkdVO>
	 * @throws EventException
	 */
	public List<VskVslPortSkdVO> searchVpsEtbEtdDtList(VskVslPortSkdVO vskVslPortSkdVO) throws EventException {
		try {
			return dbDao.searchVpsEtbEtdDtList(vskVslPortSkdVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * VOP_OPF_1053 : Delete <br>
	 * Delete Stevedore Damage Detail Info<br>
	 * 
	 * @param String delStvDmgNo
	 * @param String tabNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamageDetail(String delStvDmgNo, String tabNo, SignOnUserAccount account) throws EventException{
		try {
			if("0".equals(tabNo)){
				dbDao.deleteDamageDetail(delStvDmgNo);			//OPF_STV_DMG_DTL
				dbDao.deleteDamageAllAttachFile(delStvDmgNo);	//OPF_STV_DMG_ATCH_FILE
				dbDao.deleteDamageHistory(delStvDmgNo);			//OPF_STV_DMG_STEP_HIS
				dbDao.deleteDamageRepair(delStvDmgNo);			//OPF_STV_DMG_RPR
				dbDao.deleteDamageCompensation(delStvDmgNo);	//OPF_STV_DMG_CMPN
				dbDao.deleteDamageSettlement(delStvDmgNo);		//OPF_STV_DMG_STL
				dbDao.deleteDamage(delStvDmgNo);				//OPF_STV_DMG
			}else{
				dbDao.deleteDamageStepHistory(delStvDmgNo, tabNo);		//OPF_STV_DMG_STEP_HIS
				if("1".equals(tabNo)){
					dbDao.deleteDamageRepair(delStvDmgNo);			//OPF_STV_DMG_RPR
				}else if("2".equals(tabNo)){
					dbDao.deleteDamageCompensation(delStvDmgNo);	//OPF_STV_DMG_CMPN
				}else if("3".equals(tabNo)){
					dbDao.deleteDamageSettlement(delStvDmgNo);		//OPF_STV_DMG_STL
				}
			}
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
}