/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtBCImpl.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* 2010.10.12 이석준 [CSR전 사전 작업] VVD,VSL,Lane,Port 유효성 검사 로직 추가
*                                 Delete시 유효성 check logic 추가
*                                 SDMS No 체계 변경
* 2010.10.15 이상민 [CHM-201007482-01] 1053 event에 COMMAND01 - checkTabSavable() 추가
* 2011.01.12 진마리아 [CHM-201108239-01] SDMS내 demage date및 삭제 권한 변경 요청 건
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항                      
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
* 2011.12.20 김민아 [CHM-201215700-01] [VOP-OPF] SDMS내 메일 기능 추가 요청
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration.StevedoreDamageMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration.StevedoreDamageMgtEAIDAO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.RsltOpfStvDmgEmlSndHisVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageClaimSendMailContentVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageClaimSendMailVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDetailsGRPVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsPortStayingDatesVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.hanjin.bizcommon.currency.vo.MdmCurrencyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.hanjin.syscommon.common.table.OpfStvDmgDtlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgEmlSndHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgRprVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStepHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-StevedoreDamageMgt Business Logic Basic Command implementation<br>
 * - NIS2010-StevedoreDamageMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_0052EventResponse,StevedoreDamageMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class StevedoreDamageMgtBCImpl extends BasicCommandSupport implements StevedoreDamageMgtBC {

	// Database Access Object
	private transient StevedoreDamageMgtDBDAO dbDao = null;

	/**
	 * StevedoreDamageMgtBCImpl 객체 생성<br>
	 * StevedoreDamageMgtDBDAO를 생성한다.<br>
	 */
	public StevedoreDamageMgtBCImpl() {
		dbDao = new StevedoreDamageMgtDBDAO();
	}
	
	// VOP_OPF_0052 Start ============================================================//
	/**
	 * Stevedore Damage 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgCreateVO>
	 * @exception EventException
	 */
	public List<OpfStvDmgCreateVO> searchDamage(OpfStvDmgCreateVO opfStvDmgCreateVO) throws EventException {
//		try {
//			List<OpfStvDmgCreateVO> list = dbDao.searchDamage(opfStvDmgCreateVO);
//			
//			if(list.size() < 1){
//				throw new EventException(new ErrorHandler("OPF00001").getMessage());
//			}
//			return list;
		try {
			return dbDao.searchDamage(opfStvDmgCreateVO);
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
	 * Stevedore Damage Claim Handling User 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO
	 * @return List<RsltOpfStvDmgEmlSndHisVO>
	 * @exception EventException
	 */
	public List<RsltOpfStvDmgEmlSndHisVO> searchDamageClaimHandlingUser(OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO) throws EventException {
		try {
			return dbDao.searchDamageClaimHandlingUser(opfStvDmgEmlSndHisVO);		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
	/**
	 * Stevedore Damage에 VVD 정보를 조회 합니다. <br>
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
	/* 2010.10.13 [CHM-201006428-01] SDMS No 체계 변경
	 * 2010.10.15 [CHM-201006428-01] Delete 로직 추가
    */
	/**
	 * Stevedore Damage 정보를 저장 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO[] opfStvDmgCreateVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param String[] strKeys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamage(OpfStvDmgCreateVO[] opfStvDmgCreateVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO , String[] strKeys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException{
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
			// Claim Handling User
			List<OpfStvDmgEmlSndHisVO> checkDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			List<OpfStvDmgEmlSndHisVO> insertDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			List<OpfStvDmgEmlSndHisVO> deleteDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			OpfStvDmgEmlSndHisVO tempVO = null;
			
			String etcData = "";
			String stvDmgNo = "";
			//Message를 위한 셋팅 : Mail 을 보낸 경우 : "Y" 셋팅 
			String mailSendMark = "N";
			Boolean delAll = false;
			
			if(opfStvDmgCreateVO!=null){
				for ( int i=0; i<opfStvDmgCreateVO .length; i++ ) {										
					stvDmgNo = "";
					if(opfStvDmgCreateVO[i].getStvDmgNo() != null && !opfStvDmgCreateVO[i].getStvDmgNo().equals("")){
						stvDmgNo = opfStvDmgCreateVO[i].getStvDmgNo();
					}
					else{
						//VVD CD/Port/DamageDate 정보 중복체크.
						/*List<OpfStvDmgVO> dmgCheckVO = dbDao.checkVVDInfo(opfStvDmgCreateVO[i]);
						if(dmgCheckVO.size() > 0){
							throw new EventException(new ErrorHandler("OPF00003").getMessage());
						}*/
						 
						//현재년도 가져오기..
						Calendar cal = Calendar.getInstance();  
						SimpleDateFormat year = new SimpleDateFormat("yy"); 
						String yy = year.format(cal.getTime());
					    
						//해당 Vsl Code의 Max Serial No 가져오기..
//						<SDMS Numbering 체계변경>
//						   [as-is]
//						    vessel code (4) + 연도 (2) + vvd/port seq (3) + sub seq (2)
//						   [to-be]
//						    vessel code (4) + 연도 (2) + 월(2) + Vessel Category(1) + Damage Category(1) + sub seq(1)
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
						/* 셋팅후 stvDmgNo Dup Check */
						String stvDmgNoDup = dbDao.checkSdmsNoDup(opfStvDmgVO);
						if(!"".equals(stvDmgNoDup)){
							throw new EventException(new ErrorHandler("OPF50005", new String[]{stvDmgNoDup}).getMessage());
						}
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
					opfStvDmgDtlVO.setStvDmgRespbPtyKwnCd(opfStvDmgCreateVO[i].getStvDmgRespbPtyKwnCd());
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
						//Update시에는 Status가 변경된 경우만 History Insert..
						insertStvDmgStepHisVoList.add(hisVO);
					}
					else if(opfStvDmgCreateVO[i].getIbflag().equals("D")){
						deleteStvDmgStepHisVoList.add(hisVO);
					}
					//History........................................................//
					
				}
				
				//removeDamageAllEmailSendHistory 를 위한 vo 생성
				tempVO = new OpfStvDmgEmlSndHisVO();
				tempVO.setStvDmgNo(stvDmgNo);
				
				//Responsible Party가 unKnown일 경우 해당 stvDmgNo의 Claim Handling User 는 삭제한다.
				if("U".equals(opfStvDmgCreateVO[0].getStvDmgRespbPtyKwnCd())){
					dbDao.removeDamageAllEmailSendHistory(tempVO);
				}
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY값
				//Iterator<String> keyArr = null;			
				//if(keys != null) keyArr = keys.iterator();
				
				//::2011.11.22 append::jsk
				int	iFileSaveIdLen						= 0;
				if(strKeys != null)	iFileSaveIdLen		= strKeys.length;
				int	iFileSaveDownIdx					= iFileSaveIdLen - 1;				
				
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(stvDmgNo);
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					//FILE UPLOAD KEY값 SETTING하기
					//if(keyArr != null) {
					//	if(keyArr.hasNext()){
					//		opfStvDmgAtchFileVO[j].setFileSavId(keyArr.next());
					//	}
					//}
					
					if(strKeys != null && iFileSaveDownIdx >=0){
						opfStvDmgAtchFileVO[j].setFileSavId(strKeys[iFileSaveDownIdx--]);
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
			
			/* Claim Handling User ===============================================================*/
			
			if(opfStvDmgEmlSndHisVO != null){
				
				for(int k=0; k<opfStvDmgEmlSndHisVO.length; k++){
					if(opfStvDmgEmlSndHisVO[k].getStvDmgNo()==null || "".equals(opfStvDmgEmlSndHisVO[k].getStvDmgNo())){
						opfStvDmgEmlSndHisVO[k].setStvDmgNo(stvDmgNo);
					}
					opfStvDmgEmlSndHisVO[k].setCreUsrId(account.getUsr_id());
					opfStvDmgEmlSndHisVO[k].setUpdUsrId(account.getUsr_id());
					checkDmgEmlSndHisVOList.add(opfStvDmgEmlSndHisVO[k]);
				}
				
				//기존 데이터와 비교하는 체크 로직
				//1. 동일한 데이터 존재 : pass (코드 없음)
				//2. 동일하지 않은 기존 데이터 : 삭제
				//3. 새로운 데이터 : insert 후 메일발송
				deleteDmgEmlSndHisVOList = dbDao.checkDeleteClaimHandlingUser(opfStvDmgEmlSndHisVO[0], checkDmgEmlSndHisVOList);
				insertDmgEmlSndHisVOList = dbDao.checkInsertClaimHandlingUser(opfStvDmgEmlSndHisVO[0], checkDmgEmlSndHisVOList);
			
			}
			
			if(deleteDmgEmlSndHisVOList.size() > 0){
				dbDao.removeDamageEmailSendHistory(deleteDmgEmlSndHisVOList);
			}
			
			/* Claim Handling User ===============================================================*/
			
			if ( insertDmgVoList.size() > 0 ) {
				dbDao.addDamage(insertDmgVoList);
				dbDao.addDamageDetail(insertDmgDtlVoList);
			}
			
			if ( updateDmgVoList.size() > 0 ) {
				dbDao.modifyDamage(updateDmgVoList);
				dbDao.modifyDamageDetail(updateDmgDtlVoList);
				
				/* mail 전송 (Creation 구분자 : Creation) ==========================================*/
				if(opfStvDmgEmlSndHisVO != null && insertDmgEmlSndHisVOList.size() == 0 && deleteDmgEmlSndHisVOList.size() == 0 && deleteDmgEmlSndHisVOList.size() == 0){
					sendMailDamageCreation(insertDmgEmlSndHisVOList, stvDmgNo, "D", "Creation", account);
					mailSendMark = "Y";
				}
				
			}
			
			if ( deleteDmgVoList.size() > 0 ) {
				//dbDao.removeDamage(deleteDmgVoList);
				dbDao.removeDamageDetail(deleteDmgDtlVoList);
				dbDao.removeDamageAllAttachFile(deleteDmgVoList);
				dbDao.removeDamageAllEmailSendHistory(tempVO);
				delAll = true;
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
			
			/* Claim Handling User ===============================================================*/
			
			if(!delAll && insertDmgEmlSndHisVOList.size() > 0){
				for(int i=0 ; i<insertDmgEmlSndHisVOList.size() ; i++){
					insertDmgEmlSndHisVOList.get(i).setStvDmgEmlSndSeq(dbDao.searchDamageClaimHandlingUserKey(insertDmgEmlSndHisVOList.get(0)));
					dbDao.addDamageEmailSendHistory(insertDmgEmlSndHisVOList.get(i));
				}
				//mail 전송 (Creation 구분자 : Creation)
				sendMailDamageCreation(insertDmgEmlSndHisVOList, "", "", "Creation", account);
				mailSendMark = "Y";
			}
			/* Claim Handling User ===============================================================*/
			
			String returnStr = "";
			
			if(etcData!=null && !etcData.equals("")){
				returnStr = etcData.substring(0,etcData.lastIndexOf("|"));
			}
			returnStr = returnStr+"."+mailSendMark;
			
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
	 * Stevedore Damage 정보를 삭제 합니다. <br>
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
	 * Stevedore Damage Approval 정보를 저장 합니다. <br>
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
	 * StevedoreDamageMgt화면에 대한 VVD Port Code 및 ETA/ETD Date 조회 이벤트 처리<br>
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
	 * Stevedore Damage 화면에 대한 Lane Code 조회 이벤트 처리<br>
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
	 * StevedoreDamageMgt화면에 대한 Common Code 조회 이벤트 처리<br>
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
	 * StevedoreDamageMgt화면에 대한 Approval Permission 조회 이벤트 처리<br>
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
	 * Stevedore Damage 화면에 대한 Office Code 조회 이벤트 처리<br>
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
	 * Stevedore Damage 화면에 대한 E-mail [PIC of Claim Handling Office] 조회 이벤트 처리<br>
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
	 *  Stevedore Damage Inquiry 화면에 대한 조회 이벤트 처리<br>
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
	 * Stevedore Damage Details 화면에 대한 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 User Name 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 USD_AMT 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Default Currency 조회 이벤트 처리<br>
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
	 * Stevedore Damage 화면에 대한 Currency Code 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage 정보 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage Detail 정보 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage Repair 정보 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage Compensation 정보 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage Settlement 정보 조회 이벤트 처리<br>
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
	 * Stevedore Damage Update 화면에 대한 Damage 정보 저장 이벤트 처리<br>
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
			
			if(opfStvDmgVO != null){
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
	 * Stevedore Damage Update 화면에 대한 Damage Detail 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgDtlVO[] opfStvDmgDtlVO
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamageDetail(OpfStvDmgDtlVO[] opfStvDmgDtlVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO, List<String> keys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException{
		
		try {
			List<OpfStvDmgDtlVO> updateVoList = new ArrayList<OpfStvDmgDtlVO>();
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			
			// Claim Handling User
			List<OpfStvDmgEmlSndHisVO> checkDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			List<OpfStvDmgEmlSndHisVO> insertDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			List<OpfStvDmgEmlSndHisVO> deleteDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			
			//Message를 위한 셋팅 : Mail 을 보낸 경우 : "Y" 셋팅 
			String mailSendMark = "N";
			String stvDmgNo = "";
			
			if(opfStvDmgDtlVO != null){
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
							//Update시에는 Status가 변경된 경우만 History Insert..
							insertStvDmgStepHisVoList.add(hisVO);
						}
						//History........................................................//
					} 
				}
				stvDmgNo = opfStvDmgDtlVO[0].getStvDmgNo();
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY값
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgDtlVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					//FILE UPLOAD KEY값 SETTING하기
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
			
			/* Claim Handling User ===============================================================*/
			
			//removeDamageAllEmailSendHistory 를 위한 vo 생성
			OpfStvDmgEmlSndHisVO tempVO = new OpfStvDmgEmlSndHisVO();
			tempVO.setStvDmgNo(stvDmgNo);
			
			if(opfStvDmgEmlSndHisVO != null){
				
				for(int k=0; k<opfStvDmgEmlSndHisVO.length; k++){
					opfStvDmgEmlSndHisVO[k].setCreUsrId(account.getUsr_id());
					opfStvDmgEmlSndHisVO[k].setUpdUsrId(account.getUsr_id());
					checkDmgEmlSndHisVOList.add(opfStvDmgEmlSndHisVO[k]);
				}
				
				//기존 데이터와 비교하는 체크 로직
				//1. 동일한 데이터 존재 : pass (코드 없음)
				//2. 동일하지 않은 기존 데이터 : 삭제
				//3. 새로운 데이터 : insert 후 메일발송
				deleteDmgEmlSndHisVOList = dbDao.checkDeleteClaimHandlingUser(opfStvDmgEmlSndHisVO[0], checkDmgEmlSndHisVOList);
				insertDmgEmlSndHisVOList = dbDao.checkInsertClaimHandlingUser(opfStvDmgEmlSndHisVO[0], checkDmgEmlSndHisVOList);
				
			//Responsible Party가 unKnown일 경우 opfStvDmgEmlSndHisVO는 null이고, 해당 stvDmgNo의 Claim Handling User 는 삭제한다.
			} else {
				dbDao.removeDamageAllEmailSendHistory(tempVO);
			}
			
			if(deleteDmgEmlSndHisVOList.size() > 0){
				dbDao.removeDamageEmailSendHistory(deleteDmgEmlSndHisVOList);
			}
			/* Claim Handling User ===============================================================*/
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDamageDetail(updateVoList);
				//mail 전송 (Creation 구분자 : Detail) ==============================================*/
				if(opfStvDmgEmlSndHisVO != null && insertDmgEmlSndHisVOList.size() == 0){
					sendMailDamageCreation(insertDmgEmlSndHisVOList, updateVoList.get(0).getStvDmgNo(), "D", "Detail", account);
					mailSendMark = "Y";
				}
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
			
			/* Claim Handling User ===============================================================*/
			if(insertDmgEmlSndHisVOList.size() > 0){
				for(int i=0 ; i<insertDmgEmlSndHisVOList.size() ; i++){
					insertDmgEmlSndHisVOList.get(i).setStvDmgEmlSndSeq(dbDao.searchDamageClaimHandlingUserKey(insertDmgEmlSndHisVOList.get(0)));
					dbDao.addDamageEmailSendHistory(insertDmgEmlSndHisVOList.get(i));
				}
				//mail 전송 (Creation 구분자 : Detail)
				sendMailDamageCreation(insertDmgEmlSndHisVOList, "", "", "Detail", account);
				mailSendMark = "Y";
			}
			/* Claim Handling User ===============================================================*/
			
			return mailSendMark;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Repair 정보 저장 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgRprVO[] opfStvDmgRprVO
 	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO
	 * @param List<String> keys
	 * @param OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageDamageRepair(OpfStvDmgRprVO[] opfStvDmgRprVO, OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVO , List<String> keys, OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVO, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgRprVO> insertVoList = new ArrayList<OpfStvDmgRprVO>();
			List<OpfStvDmgRprVO> updateVoList = new ArrayList<OpfStvDmgRprVO>();
			List<OpfStvDmgStepHisVO> insertStvDmgStepHisVoList = new ArrayList<OpfStvDmgStepHisVO>();
			
			// File Upload Data..
			List<OpfStvDmgAtchFileVO> insertOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> updateOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();
			List<OpfStvDmgAtchFileVO> deleteOpfStvDmgAtchFileVOList = new ArrayList<OpfStvDmgAtchFileVO>();	
			
			// Claim Handling User
			List<OpfStvDmgEmlSndHisVO> checkDmgEmlSndHisVOList = new ArrayList<OpfStvDmgEmlSndHisVO>();
			String stvDmgRprProcStsCd = opfStvDmgRprVO[0].getStvDmgRprProcStsCd();
			
			String mailSendMark = "N";
			
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
					//Update시에는 Status가 변경된 경우만 History Insert..
					insertStvDmgStepHisVoList.add(hisVO);
				}
				//History........................................................//
			}
			
			if(opfStvDmgAtchFileVO != null){
				
				// FILE UPLOAD KEY값
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgRprVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());
					
					//FILE UPLOAD KEY값 SETTING하기
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
			
			/* Claim Handling User ===============================================================*/
			if("C".equals(stvDmgRprProcStsCd)){
				if(opfStvDmgEmlSndHisVO != null){
					
					for(int k=0; k<opfStvDmgEmlSndHisVO.length; k++){
						opfStvDmgEmlSndHisVO[k].setCreUsrId(account.getUsr_id());
						opfStvDmgEmlSndHisVO[k].setUpdUsrId(account.getUsr_id());
						checkDmgEmlSndHisVOList.add(opfStvDmgEmlSndHisVO[k]);
					}
					//History 로 계속 생성하므로 기존 데이터와 비교하는 체크 로직은 없다.
				}
			}
			/* Claim Handling User ===============================================================*/
			
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
			
			/* Claim Handling User ===============================================================*/
			if(checkDmgEmlSndHisVOList.size() > 0){
				for(int i=0 ; i<checkDmgEmlSndHisVOList.size() ; i++){
					checkDmgEmlSndHisVOList.get(i).setStvDmgEmlSndSeq(dbDao.searchDamageClaimHandlingUserKey(checkDmgEmlSndHisVOList.get(0)));
					dbDao.addDamageEmailSendHistory(checkDmgEmlSndHisVOList.get(i));
				}
				//mail 전송
				sendMailDamageCreation(checkDmgEmlSndHisVOList, "", "", "", account);
				mailSendMark = "Y";
			}
			
			return mailSendMark;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	/**
	 * Stevedore Damage Update 화면에 대한 Damage Compensation 정보 저장 이벤트 처리<br>
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
					//Update시에는 Status가 변경된 경우만 History Insert..
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
	 * Stevedore Damage Update 화면에 대한 Damage Settlement 정보 저장 이벤트 처리<br>
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
				
				// FILE UPLOAD KEY값
				Iterator<String> keyArr = null;			
				if(keys != null) keyArr = keys.iterator();
				// File Upload Data..
				for(int j=0; j < opfStvDmgAtchFileVO.length; j++){
					//stvDmgNo
					if(opfStvDmgAtchFileVO[j].getStvDmgNo()==null || opfStvDmgAtchFileVO[j].getStvDmgNo().equals("")){
						opfStvDmgAtchFileVO[j].setStvDmgNo(opfStvDmgStlVO[0].getStvDmgNo());
					}
					opfStvDmgAtchFileVO[j].setUpdUsrId(account.getUsr_id());

					//FILE UPLOAD KEY값 SETTING하기
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
	 * FMS에서 Payment Data Insert에 이용하는 메서드<br>
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
	 * FMS에서 Payment Data Delete에 이용하는 메서드<br>
	 * 
	 * @param CustomInvDtlVO[] customInvDtlVOs
	 * @exception EventException
	 */
	public void removeSettlementFMS(CustomInvDtlVO[] customInvDtlVOs) throws EventException{
		try {
			List<CustomInvDtlVO> deleteVoList = new ArrayList<CustomInvDtlVO>();
			
			for ( int i=0; i<customInvDtlVOs.length; i++ ) {
				// ibflag 가 'D'인 경우와 sdmsNo가 존재하는 경우만 실제 delete 대상이 됨
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
	 * VOP_OPF_1053 : Tab이동시 save 가능 여부 확인 로직 추가
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
	 * Stevedore Damage History 화면에 대한 정보를 조회 합니다.<br>
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
	 * Stevedore Damage History 화면에 대한 정보를 저장 합니다.<br>
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
	 * 조회 이벤트 처리<br>
	 *  StevedoreDamageMgt화면에 대한 조회 이벤트 처리<br>
	 *  File Upload Data 조회한다.
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
	 * 메일 전송 이벤트 처리<br>
	 *  StevedoreDamageMgt화면에 대한 메일 전송 이벤트 처리<br>
	 *  VOP_OPF_1153 리포트 화면을 메일로 전송한다.
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
	 * Stevedore Damage Performance Report 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Report 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Repair Report 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Compensation Report 정보를 조회 합니다.<br>
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
	 * Stevedore Damage Settlement Report 정보를 조회 합니다.<br>
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
	 * VSL,VVD,Lane,Port Code Validation 을 검사합니다..<br>
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
	 * VOP_OPF_0052 : Delete시에 delete 가능 여부 확인 로직 추가
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
	 * VVD, Port로 ETB, ETD 일자를 가져온다.
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
	 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param String delStvDmgNo
	 * @param String tabNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeDamageDetail(String delStvDmgNo, String tabNo, SignOnUserAccount account) throws EventException{
		try {
			//removeDamageAllEmailSendHistory 를 위한 vo 생성
			OpfStvDmgEmlSndHisVO tempVO = new OpfStvDmgEmlSndHisVO();
			tempVO.setStvDmgNo(delStvDmgNo);
			
			if("0".equals(tabNo)){
				dbDao.removeDamageAllEmailSendHistory(tempVO);	//OPF_STV_DMG_EML_SND_HIS
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

	/**
	 * Stevedore Damage Settlement Report 정보를 조회 합니다.<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<SdmsPortStayingDatesVO>
	 * @exception EventException
	 */
	public List<SdmsPortStayingDatesVO> searchVesselPortStayingDates(VskVslPortSkdVO vskVslPortSkdVO ) throws EventException{
		try {
			List<SdmsPortStayingDatesVO> list = null;
			SdmsPortStayingDatesVO tmpVO = new SdmsPortStayingDatesVO();
			if("".equals(vskVslPortSkdVO.getYdCd())){
				MdmLocationVO mdmLocationVOIn = new MdmLocationVO();				
				mdmLocationVOIn.setLocCd(vskVslPortSkdVO.getVpsPortCd());
				List<MdmLocationVO> mdmLocationVOOut = dbDao.searchMdmLocation(mdmLocationVOIn);
				if(mdmLocationVOOut != null && mdmLocationVOOut.size() != 0){
					tmpVO.setOfcCd(mdmLocationVOOut.get(0).getEqCtrlOfcCd());
				}
				//sdmsPortStayingDatesVO.setOfcCd(mdmLocationVO.getLocCd());				
			}else{
				MdmYardVO mdmYardVOIn = new MdmYardVO();
				mdmYardVOIn.setYdCd(vskVslPortSkdVO.getYdCd());
				MdmYardVO mdmYardVOOut = dbDao.searchMdmYard(mdmYardVOIn);
				tmpVO.setOfcCd(mdmYardVOOut.getOfcCd());
			}
				list = dbDao.searchVesselPortStayingDates(vskVslPortSkdVO);
				list.add(0, tmpVO);
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("OPF00001").getMessage());
		}
	}
	
    /**
     * Stevedore Damage Creation/Detail 에서 정보 변경 및 Repair-Complete 할 때 담당자에게 GW 메일을 전송합니다.<br>
     * 
     * @param List<OpfStvDmgEmlSndHisVO> opfStvDmgEmlSndHisVOs
	 * @param String stvDmgNo
	 * @param String stvDmgProcCd
	 * @param String stsCd
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailDamageCreation(List<OpfStvDmgEmlSndHisVO> opfStvDmgEmlSndHisVOs, String stvDmgNo, String stvDmgProcCd, String stsCd, SignOnUserAccount account) throws EventException {
        try {
            SdmsDamageClaimSendMailVO sendMailVO = new SdmsDamageClaimSendMailVO();
            OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO = new OpfStvDmgEmlSndHisVO();
            List<String> emailList = new ArrayList<String>();
            
            // List 에 존재하는 데이터 : D - 추가된 담당자  
            //                       R - Completed 시 전체 (UI 부터 해당 목록을 가져옴)
            if(opfStvDmgEmlSndHisVOs.size() != 0){
	            opfStvDmgEmlSndHisVO = opfStvDmgEmlSndHisVOs.get(0);
            }
            // List 에 데이터가 존재하지 않음 : D - 담당자 추가가 없고 정보가 변경된 경우 해당 분기가 적용, 전체 대상
            else{
            	opfStvDmgEmlSndHisVO.setStvDmgNo(stvDmgNo);
            	opfStvDmgEmlSndHisVO.setStvDmgProcCd(stvDmgProcCd);
            	opfStvDmgEmlSndHisVOs = dbDao.searchDamageClaimSendMailUser(opfStvDmgEmlSndHisVO);
            }
            
            // mail content 조회
            List<SdmsDamageClaimSendMailContentVO> list = dbDao.searchDamageClaimSendMailContent(opfStvDmgEmlSndHisVO);
            if (list == null || list.size() == 0) {
                return ;
            }
            SdmsDamageClaimSendMailContentVO vo = list.get(0);
            
            sendMailVO.setFromUser(account.getUsr_eml());
            sendMailVO.setFromUserNm(account.getUsr_nm());
            
            StringBuilder sbSubject = new StringBuilder();
            sbSubject.append("Re : [").append(vo.getSlanCd()).append("]").append(" ");
            sbSubject.append(vo.getVvd()).append(" ");
            sbSubject.append(vo.getVpsPortCd()).append(" ");
            sbSubject.append("Stevedore Damage Compensation Request = ").append(vo.getStvDmgNo());
            sendMailVO.setSubject(sbSubject.toString());
            
            StringBuilder sbHtmlContent = new StringBuilder();
            sbHtmlContent.append("<html>");
            sbHtmlContent.append("<head>");
            sbHtmlContent.append("<title></title>");
            sbHtmlContent.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-kr\">");
            sbHtmlContent.append("<link rel=\"stylesheet\" href=\"include/style.css\" type=\"text/css\">");
            sbHtmlContent.append("</head>");
            sbHtmlContent.append("<table style=\"width:100%\" class=\"popup\" cellpadding=\"0\" border=\"0\">");
            sbHtmlContent.append("<tr><td class=\"top\"></td></tr>");
            sbHtmlContent.append("<tr><td valign=\"top\">");
            sbHtmlContent.append("<table width=\"100%\" border=\"0\">");
            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131;\">Date: "+vo.getToday()+"</td></tr>");
            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131;\">To: "+vo.getClmHndlOfcCd()+"</td></tr>");
            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131;\">Fm: "+account.getOfc_cd()+"</td></tr>");
            sbHtmlContent.append("<tr><td style=\"font-family:arial,verdana; font-size: 16px; word-spacing:-0px; color: #313131; font-weight:bold;\">Re : [").append(vo.getSlanCd()).append("] ").append(vo.getVvd()).append(" ").append(vo.getVpsPortCd()).append(" ").append("Stevedore Damage Compensation Request = ").append(vo.getStvDmgNo()).append("<br><br><br></td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("<table class=\"search\">");
            sbHtmlContent.append("<tr><td class=\"bg\">");
            
            if("D".equals(opfStvDmgEmlSndHisVO.getStvDmgProcCd())) {
            	if("Creation".equals(stsCd)){
		            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		            sbHtmlContent.append("<tr>");
		            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\">");
	            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;");
	            	sbHtmlContent.append("It was created SDR(Stevedore Damage Report) of [").append(vo.getSlanCd()).append("] ").append(vo.getVvd()).append(".<br>");
	            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;");
	            	sbHtmlContent.append("Pls see <u><b> SDMS No. : ").append(vo.getStvDmgNo()).append("</b></u> of \"Stevedore Damage Inquiry & Update\" in Operation & PFMC of ALPS<br>");
	            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;&nbsp;");
	            	sbHtmlContent.append("and hold the Responsibility of this Stevedore Damage from terminal.<br>");
	            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;");
	            	sbHtmlContent.append("If any changes, pls update this matter in ALPS to take next action.");
		            sbHtmlContent.append("<br><br>");
		            sbHtmlContent.append("</td>");
		            sbHtmlContent.append("</tr>");
		            sbHtmlContent.append("</table>");
            	}else if("Detail".equals(stsCd)){
		            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
		            sbHtmlContent.append("<tr>");
		            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\">");
	            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;");
	            	sbHtmlContent.append("It was revised Damage Information for <u><b> SDMS No. : ").append(vo.getStvDmgNo()).append("</b></u> of [").append(vo.getSlanCd()).append("] ").append(vo.getVvd()).append(" hence pls recheck it on SDMS.");
		            sbHtmlContent.append("<br><br>");
		            sbHtmlContent.append("</td>");
		            sbHtmlContent.append("</tr>");
		            sbHtmlContent.append("</table>");
            	}
	            sbHtmlContent.append("<table cellpadding=\"1\" cellspacing=\"1\" bgcolor=\"#ffffff\" border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("1. VVD : ").append(vo.getVvd()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("2. Port : ").append(vo.getVpsPortCd()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("3. SDMS No. : ").append(vo.getStvDmgNo()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("4. Claim Handling Off : </td><td td style=\"background-color: #ffffff; color: blue; text-align : left; font-weight:bold; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append(vo.getClmHndlOfcCd()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("5. Damage Date : ").append(vo.getStvDmgEvntDt()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("6. Damage part : ").append(vo.getStvDmgTpCd()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("7. Responsible party : ").append(vo.getStvDmgRespbPtyKwnCd()).append("</td></tr></table></td></tr>");
	            sbHtmlContent.append("<tr><td><table><tr><td style=\"background-color: #ffffff; color: #313131; text-align : left; height:23; word-break : break-all; font-family: arial,verdana; font-size: 16px; padding-right:3px;\">").append("8. Detail information : Pls refer to SDMS in ALPS").append("</td></tr>");
	            sbHtmlContent.append("</table>");
	            
            }else if("R".equals(opfStvDmgEmlSndHisVO.getStvDmgProcCd())) {
            	//It was updated repair information for SDMS No. :                 of [Lane] VVD hence pls take next action with terminal for compensation.
	            sbHtmlContent.append("<table border=\"0\" style=\"width:100%;\">");
	            sbHtmlContent.append("<tr>");
	            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\">");
            	sbHtmlContent.append("&nbsp;&nbsp;&nbsp;");
            	sbHtmlContent.append("It was updated repair information for <u><b> SDMS No. : ").append(vo.getStvDmgNo()).append("</b></u> of [").append(vo.getSlanCd()).append("] ").append(vo.getVvd()).append(" hence pls take next action with terminal for compensation.");
	            sbHtmlContent.append("<br><br>");
	            sbHtmlContent.append("</td>");
	            sbHtmlContent.append("</tr>");
	            sbHtmlContent.append("</table>");
            }
	            
            sbHtmlContent.append("<table class=\"search\" border=\"0\" style=\"width:100%;\">");
            sbHtmlContent.append("<tr>");
            sbHtmlContent.append("<td style=\"padding:0px; font-family: arial,verdana; font-size: 16px; word-spacing:-0px;\"><br>Thank you.<br>");
            sbHtmlContent.append("Best regards</td>");
            sbHtmlContent.append("</tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</td></tr>");
            sbHtmlContent.append("</table>");
            sbHtmlContent.append("</html>");
            sendMailVO.setHtmlContent(sbHtmlContent.toString());

            // mail 대상 Key(email send Seq) List 에 담기
            for (int i = 0 ; i < opfStvDmgEmlSndHisVOs.size() ; i++) {
                emailList.add(opfStvDmgEmlSndHisVOs.get(i).getClmHndlUsrEml());
            }
            
            StevedoreDamageMgtEAIDAO eaiDao = new StevedoreDamageMgtEAIDAO();
            String sndNo = eaiDao.sendMailDamageCreation(sendMailVO, emailList);
            
            for(int i=0 ; i<opfStvDmgEmlSndHisVOs.size() ; i++){
            	opfStvDmgEmlSndHisVOs.get(i).setEmlSndNo(sndNo);
            	opfStvDmgEmlSndHisVOs.get(i).setUpdUsrId(account.getUsr_id());
            }
            
            dbDao.modifyDamageEmailSendHistory(opfStvDmgEmlSndHisVOs);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00120",new String[]{}).getMessage(), ex);
        }
    }
}