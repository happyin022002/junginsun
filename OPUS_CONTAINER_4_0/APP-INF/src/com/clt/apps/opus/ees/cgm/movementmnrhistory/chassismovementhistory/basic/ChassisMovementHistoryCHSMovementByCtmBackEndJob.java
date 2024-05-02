/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBCImpl.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.03 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.basic.ChassisMgsetAttachDetachHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.vo.CHSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration.ChassisMovementHistoryDBDAO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSAtchDtchHisMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CNTRMvmtMGTVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - OPUS-MovementMnrHistory에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI MIN HOI
 * @see testEventResponse,ChassisMovementHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisMovementHistoryCHSMovementByCtmBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	// Database Access Object
	private transient ChassisMovementHistoryDBDAO dbDao = null;


 

	private List<CusCtmMovementVO>  cusCtmMovementVOs; 

	/**
	 * ChassisMovementHistoryBCImpl 객체 생성<br>
	 * ChassisMovementHistoryDBDAO를 생성한다.<br>
	 */
	public ChassisMovementHistoryCHSMovementByCtmBackEndJob() {
		dbDao = new ChassisMovementHistoryDBDAO();
	}
	
	/**
	 * Chassis Movement 를 수정하는 오퍼레이션 BackEndJob Start
	 * @return List<CusCtmMovementVO>
	 * @throws Exception
	 */
	public List<CusCtmMovementVO> doStart() throws Exception {
		log.debug("manageCHSMovementByCtmBasic==BackEndJob  doStart ");
		List<CusCtmMovementVO> list = null;
		try {
			list = manageCHSMovementByCtmBasic(this.cusCtmMovementVOs);
	    } catch (DAOException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    }
		return list;
	}
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * CusCtmMovementVO
	 */
	public void setSearchEDIErrorVO(List<CusCtmMovementVO>  cusCtmMovementVOs) {
		this.cusCtmMovementVOs = cusCtmMovementVOs;
	}
	
	/**
	 *  Chassis Movement 를 수정하는 오퍼레이션 SAVE  [CTM 호출]<br>
	 * 
	 * @param cusCtmMovementVOs List<CusCtmMovementVO>
	 * @return List<CusCtmMovementVO>
	 */
	public List<CusCtmMovementVO>  manageCHSMovementByCtmBasic(List<CusCtmMovementVO> cusCtmMovementVOs)throws Exception {
		try {
			log.debug("manageCHSMovementByCtmBasic==BackEndJob  start "+cusCtmMovementVOs.size());
			ChassisMgsetOnOffhireBC chs = new ChassisMgsetOnOffhireBCImpl();
			
			ChassisMgsetAttachDetachHistoryBC atdt = new ChassisMgsetAttachDetachHistoryBCImpl();
			
			CHSMasterMGTVO          cHSMasterMGTVO    = null;
			CusCtmMovementVO        cusCtmMovementVO  = null;
			List<CHSMvmtBareMGTVO>  cHSMvmtBareMGTVOs = null;
			CHSMvmtBareMGTVO        cHSMvmtBareMGTVO  = null;
			CHSAtdtHistoryMGTVO     cHSAtdtHistoryMGTVO = null;
			CHSAtdtHistoryMGTVO     chkAtdtHistoryMGTVO = null;
			CHSAtchDtchHisMGTVO     cgmEqAtchDtchHisMGTVO = null;
			
			List<CNTRMvmtMGTVO>     cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
			CNTRMvmtMGTVO           cNTRMvmtMGTVO     = null;
			CNTRMvmtMGTVO           cNTRMvmtMGTVO2    = null;
			CNTRMvmtMGTVO           cNTRMvmtINVO      = null;
			
			
			String                  sGmtDt            = "";
			
			String                  mvmtStsCd         = "";
			String                  chssNo            = "";
			String                  chkFlag           = "";
			
			String                  sLagDt            = "";
			String                  sLeadDt           = "";
			String                  sLagDtYd          = "";
			String                  sLeadDtYd         = "";
			String                  sAtchdt           = "";
			for(int i=0;i<cusCtmMovementVOs.size();i++){
				
				cusCtmMovementVO  = new CusCtmMovementVO();
				
				cusCtmMovementVO = cusCtmMovementVOs.get(i);
				chkFlag          = cusCtmMovementVO.getIbflag(); 
				log.debug("chssNo ===========|cusCtmMovementVO|getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
				log.debug("chssNo ===========|cusCtmMovementVO|getMgstNo|================="+cusCtmMovementVO.getMgstNo());
			
				if(chkFlag == null){
					chkFlag      = "";
				}
				
				log.debug("cusCtmMovementVO.chkFlag()==="+chkFlag);
				log.debug("cusCtmMovementVO.chkFlag()=i="+i);
				log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());
				
				// start Row  데이터가 추 가 
				if(chkFlag.equals("C") || chkFlag.equals("I")|| chkFlag.equals("")){
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
					// 기존 로직
					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
					chssNo    = cusCtmMovementVO.getChssNo();
					if(chssNo == null){
						chssNo ="";
					}
					
					log.debug("cusCtmMovementVO.getMvmtStsCd()==="+cusCtmMovementVO.getMvmtStsCd());
					log.debug("cusCtmMovementVO.getCnmvEvntDt()==="+cusCtmMovementVO.getCnmvEvntDt());
					
					// CGM Chassis Movement History 업데이트  
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd()); 
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd(cusCtmMovementVO.getMvmtStsCd());
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 확인
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 확인
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());
					cNTRMvmtMGTVO.setCntrTpszCd(cusCtmMovementVO.getCntrTpszCd());
					
//					- VL,EN,CE & Chss_no=null
//			          & 입력 cntr, 입력 lcc의 최근 Chss_mvmt date == 그 발생내역 chss_no 의 최근 chss mvmt date, 
					if(chssNo.equals("")&& (mvmtStsCd.equals("VL") || mvmtStsCd.equals("EN")|| mvmtStsCd.equals("CE")) ){
						// sql 실행
						cNTRMvmtMGTVO2 = dbDao.checkChsBareMvmtByCtmData(cusCtmMovementVO);
						
						if(cNTRMvmtMGTVO2 != null){
							if(cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2())){
								// 데이터 있을떼ㅐ a.mvmtdt = b.mbmtdt
								cNTRMvmtMGTVO.setMvmtRsnCd("CT"+mvmtStsCd);
								cNTRMvmtMGTVO.setMvmtStsCd("BR");
								cNTRMvmtMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
							} else {
								// 없을때  틀릴경우 같지 않을경우 
								cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
							}
						} else {
							// 없을때   
							cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
						}
						
					} else { // 나머지 mvmt_sts_cd = 입력된 cnms_cd 로 입력됨. (Cnms_reason:'CTMV')	(addChsMovement())
						cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					}
					
					
					//--
					
					log.debug("cusCtmMovementVO.getUpdUsrId()========="+cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
					
					if(cNTRMvmtMGTVO.getChssNo() !=null && !cNTRMvmtMGTVO.getChssNo().equals("")){
						dbDao.addCHSMovementData(cNTRMvmtMGTVOs);
						
						//chungpa 20100330 add
						atdt.manageCHSDetachByChssBasic(cNTRMvmtMGTVO);
					}
					
					
					// dt 조회  조건 추가 
					cNTRMvmtINVO = new CNTRMvmtMGTVO();
					cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					chkAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
					// 콘데이터로  DtchYdCd 체크 
					chkAtdtHistoryMGTVO = dbDao.checkCHSAtdtData(cNTRMvmtINVO);
					
					// chssNo null 경우 처리 
					String sChssNo = null;
					
					sChssNo = cusCtmMovementVO.getChssNo();
					if(sChssNo == null){
						sChssNo = "";
					}
					

					// dt 조건  yd_cd null 이면서  체크된 eq_no 와 넘겨온 chss_no 가 틀린경우 dt 한다 
					if(chkAtdtHistoryMGTVO != null){
						if((chkAtdtHistoryMGTVO.getDtchYdCd() == null || chkAtdtHistoryMGTVO.getDtchYdCd().equals(""))
								  && (  !chkAtdtHistoryMGTVO.getEqNo().equals(sChssNo) )
								)
								{
									// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									
									cHSAtdtHistoryMGTVO.setAt("DT");
									cHSAtdtHistoryMGTVO.setEqNo(chkAtdtHistoryMGTVO.getEqNo());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // 수정
									cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다. 
									if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
										atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
									}
									
								}
					}
					
					
					// 해당 date 로 At/dt History 에 Insert or Update(Attach # 'BR' 제외)
					if(!cNTRMvmtMGTVO.getMvmtStsCd().equals("BR")){
						// at 인지 조건 
						log.debug("br 아닌 경우 타고 있니 ");
						cNTRMvmtINVO = new CNTRMvmtMGTVO();
						cNTRMvmtINVO.setCntrNo(cusCtmMovementVO.getCntrNo());
						
						// 무조건 입력 
						cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
						
						cHSAtdtHistoryMGTVO.setAt("AT");
						cHSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
						cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt()); // 수정
						cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
						cHSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
						cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
						cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
						
						// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다. 
						if(cHSAtdtHistoryMGTVO.getEqNo()!= null && !cHSAtdtHistoryMGTVO.getEqNo().equals("")){
							atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
						}
						
					}
					
					// * Damage Unflaggin 처리
			        // : (CTM 에서 Mnr 함수 콜 하여 Cntr 및 Chss 에 대해 unflaging 처리됨)
					// 개발 할내용 
					// CGM Equipment 업데이트
			        //  :crnt_yd, crnt_loc,dst_yd_cd, mvmt_dat 를 최근 정보로 업데이트 처리
					// Master 데이터 update
					cHSMasterMGTVO    = new CHSMasterMGTVO();
					cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getDestYdCd());
					
//					cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//					cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////					cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//					cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//					cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//					cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
					cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					log.debug("cHSMasterMGTVO.getEqNo()================");
					if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
						log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
						chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
					}
					
					// sql 실행
					log.debug("cNTRMvmtMGTVO.getMvmtStsCd()================"+cNTRMvmtMGTVO.getMvmtStsCd());
					if(cNTRMvmtMGTVO.getMvmtStsCd().equals("OP") || cNTRMvmtMGTVO.getMvmtStsCd().equals("CP")){
						cNTRMvmtMGTVO2 = null;
						cNTRMvmtMGTVO2 = dbDao.checkChsBareMvmtByopocData(cusCtmMovementVO);
						
						//String                  sGmtDt              = "";
						if(cNTRMvmtMGTVO2!= null && (cNTRMvmtMGTVO2.getMvmtDt1().equals(cNTRMvmtMGTVO2.getMvmtDt2()) && !cNTRMvmtMGTVO2.getChssNo().equals(cusCtmMovementVO.getChssNo())  ))
						{
							cHSMvmtBareMGTVOs = new ArrayList<CHSMvmtBareMGTVO>();
							
							cHSMvmtBareMGTVO = new CHSMvmtBareMGTVO();
							cusCtmMovementVO = cusCtmMovementVOs.get(i);
							
							cHSMvmtBareMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
							
							sGmtDt = cusCtmMovementVO.getCnmvEvntDt().replaceAll("-", "");
							sGmtDt = sGmtDt.replaceAll(":", "");
							sGmtDt = sGmtDt.replaceAll(" ", "");
							
							cHSMvmtBareMGTVO.setMvmtDtDay(sGmtDt.substring(0,8));
							cHSMvmtBareMGTVO.setMvmtDtHd(sGmtDt.substring(8,sGmtDt.length()));
							cHSMvmtBareMGTVO.setMvmtStsCd("BR");
							cHSMvmtBareMGTVO.setYdCd(cusCtmMovementVO.getOrgYdCd());   // 확인
							cHSMvmtBareMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					
							cHSMvmtBareMGTVO.setVndrAbbrNm(cusCtmMovementVO.getVndrSeq());     
							cHSMvmtBareMGTVO.setMvmtRsnCd("CT"+cNTRMvmtMGTVO.getMvmtStsCd());    
							cHSMvmtBareMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
							//cHSMvmtBareMGTVO.setMvmtCoCd(cusCtmMovementVO.getmvmtc)   // 확인
							cHSMvmtBareMGTVO.setDiffRmk("");
							cHSMvmtBareMGTVO.setMnlInpFlg("N");
							cHSMvmtBareMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							cHSMvmtBareMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
							cHSMvmtBareMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
							cHSMvmtBareMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
							
							cHSMvmtBareMGTVOs.add(cHSMvmtBareMGTVO);
							// Bare Movement 처리 
							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								dbDao.addCHSBareMvmtData(cHSMvmtBareMGTVOs);
							}
							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
							
							cHSAtdtHistoryMGTVO.setAt("DT");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo()); // 
							cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt()); // 수정
							cHSAtdtHistoryMGTVO.setDtchYdCd(cusCtmMovementVO.getOrgYdCd());
							cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// CTM 으로부터 322 Movement 데이터를 받아 Chassis, M.G.Set Attach/Detach 내역을 처리 한다. 
							if(cHSMvmtBareMGTVO.getEqNo() != null && !cHSMvmtBareMGTVO.getEqNo().equals("")){
								atdt.manageCHSAtdtByCtmBasic(cHSAtdtHistoryMGTVO);
							}
							
							// 뮤브먼트 수정시 마스타 업데이트
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							log.debug("cHSMasterMGTVO.getEqNo()================");
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								log.debug("cHSMasterMGTVO.getEqNo()==========333====="+cHSMasterMGTVO.getEqNo());
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				// END Row  데이터가 추 가 
				// start Row  데이터가  update , delete
				} else {
					cNTRMvmtMGTVOs    = new ArrayList<CNTRMvmtMGTVO>();
					//업데이트나 삭제시 
					// CGM Chassis Movement History 업데이트  
					cNTRMvmtMGTVO = new CNTRMvmtMGTVO();
					cNTRMvmtMGTVO.setChssNo(cusCtmMovementVO.getChssNo());
					cNTRMvmtMGTVO.setCnmvEvntDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
					cNTRMvmtMGTVO.setOrgYdCd(cusCtmMovementVO.getOrgYdCd()); 
					cNTRMvmtMGTVO.setDestYdCd(cusCtmMovementVO.getDestYdCd());
					cNTRMvmtMGTVO.setMvmtRsnCd("CTMV");
					cNTRMvmtMGTVO.setMvmtStsCd(cusCtmMovementVO.getMvmtStsCd().trim());
//					cNTRMvmtMGTVO.setIoBndCd(cusCtmMovementVO.getObCntrFlg()); // 확인
					cNTRMvmtMGTVO.setVndrSeq(cusCtmMovementVO.getVndrSeq());
					cNTRMvmtMGTVO.setMgstNo(cusCtmMovementVO.getMgstNo());
					cNTRMvmtMGTVO.setCnmvRmk(""); // 확인
					cNTRMvmtMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
					cNTRMvmtMGTVO.setCnmvYr(cusCtmMovementVO.getCnmvYr());
					cNTRMvmtMGTVO.setCnmvIdNo(cusCtmMovementVO.getCnmvIdNo());
					cNTRMvmtMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
					cNTRMvmtMGTVO.setBkgNo(cusCtmMovementVO.getBkgNo());
					
					mvmtStsCd = cusCtmMovementVO.getMvmtStsCd().trim();
					chssNo    = cusCtmMovementVO.getChssNo();
					
					
					log.debug("chssNo ===========||getCnmvYr|================="+cusCtmMovementVO.getCnmvYr());
					log.debug("chssNo ===========||getCnmvIdNo|================="+cusCtmMovementVO.getCnmvIdNo());
					//입력 ctm mvmt PK 로 Chassis Mvmt 테이블 조회
					cNTRMvmtMGTVO2 = dbDao.searchCgmChssMvmtHisData(cusCtmMovementVO);
					
					// start Row  데이터가  update  
					if(chkFlag.equals("U") ){
						if(chssNo == null){
							chssNo ="";
						}
						
						// Start Chss_no null 이면  기존 Mvmt 존재시  데이터 삭제
						if(chssNo.equals("")){
							// sql 실행
							
							if(cNTRMvmtMGTVO2 != null){
								// Movement data 삭제 
								dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
								
								// Attach detach data  삭제
								// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>(); 
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								
								deldateVoList.add(cHSAtdtHistoryMGTVO);
								// 조건 필요 업데이트
								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}
								
								if(sLagDt == null) sLagDt ="";
								if(sLeadDt == null) sLeadDt ="";
								if(sLagDtYd == null) sLagDtYd ="";
								if(sLeadDtYd == null) sLeadDtYd ="";
								if(sAtchdt == null) sAtchdt = "";
								
							    //  AtDt 삭제
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList); 
								// AtDt 업데이트
								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
									cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
									//cHSAtdtHistoryMGTVO.setDtchInpTpCd("A");
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
								}
								
								// Master 데이터 update
								cHSMasterMGTVO    = new CHSMasterMGTVO();
								cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//								cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//								cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//								cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////								cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//								cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//								cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//								cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
								cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								
								if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
									chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
								}
							}
						// End Chss_no null 이면  기존 Mvmt 존재시  데이터 삭제
						// Start Chss_no is not null 
						} else {
							cNTRMvmtMGTVOs.add(cNTRMvmtMGTVO);
							log.debug("chssNo ===========|||||||||||||================="+chssNo);
							log.debug("chssNo ===========||||cusCtmMovementVO.getVndrSeq()================="+cusCtmMovementVO.getVndrSeq());
							log.debug("chssNo ===========|||||||||||||================="+cNTRMvmtMGTVO2);
							if(cNTRMvmtMGTVO2 != null){
								
				
								log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());
							    
							 // Attach detach data  삭제
								// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>(); 
								cHSAtdtHistoryMGTVO.setIbflag("D");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								
								deldateVoList.add(cHSAtdtHistoryMGTVO);
								// 조건 필요 업데이트
								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
								if(cgmEqAtchDtchHisMGTVO != null){
									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
								}
								
								// 기존 chss_no <> 입력된 chss_no  또는 이벤트 시간이 변경시에 사용 
								if(!chssNo.equals(cNTRMvmtMGTVO2.getChssNo()) || !cNTRMvmtMGTVO2.getMvmtDt().substring(0,12).equals(cusCtmMovementVO.getCnmvEvntDt().substring(0,12))){
							    	// Movement data 삭제 
									dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
									// 신규 입력 
									dbDao.addCHSMovementData(cNTRMvmtMGTVOs);
									
								   
									
									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
									List<CHSAtdtHistoryMGTVO> insdateVoList = new ArrayList<CHSAtdtHistoryMGTVO>(); 
									cHSAtdtHistoryMGTVO.setIbflag("I");
									cHSAtdtHistoryMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
									
									
									cHSAtdtHistoryMGTVO.setEqKndCd("Z");
									cHSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO2.getChssNo());
									cHSAtdtHistoryMGTVO.setCntrNo(cusCtmMovementVO.getCntrNo());
									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
									cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
									cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
									
									
									 //  date,yard 변경시   바로 전 detach 정보  수정한다
									cHSAtdtHistoryMGTVO.setIbflag("R");
									log.debug("ccNTRMvmtMGTVO2.getMvmtDt()=================="+cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO2.getMvmtDt());
									cHSAtdtHistoryMGTVO.setDtchDt(cusCtmMovementVO.getCnmvEvntDt() );
									log.debug("cHSAtdtHistoryMGTVO.getAtchDt()======================="+cHSAtdtHistoryMGTVO.getAtchDt());
									atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);
									
									 //  AtDt 삭제
									
									atdt.manageCHSAtdtByMvmtBasic(deldateVoList); 
		
									cHSAtdtHistoryMGTVO.setIbflag("I");
									cHSAtdtHistoryMGTVO.setAtchDt(cusCtmMovementVO.getCnmvEvntDt() ); // 수정
									insdateVoList.add(cHSAtdtHistoryMGTVO);
									// EQ Attatch/Detach 정보 저장(History 저장) 
									atdt.manageCHSAtdtByMvmtBasic(insdateVoList); 
									
							    } else {
							    	//  Movement data 업데이트  
							    	dbDao.modifyCgmChssMvmtHisData(cNTRMvmtMGTVO);
							    	if(sLagDt == null) sLagDt ="";
									if(sLeadDt == null) sLeadDt ="";
									if(sLagDtYd == null) sLagDtYd ="";
									if(sLeadDtYd == null) sLeadDtYd ="";
									if(sAtchdt == null) sAtchdt = "";
									
									// AtDt 업데이트
									if(cgmEqAtchDtchHisMGTVO != null && sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
										
										cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
										cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
										cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
//										cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//									    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
										cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
										atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
									}
							    }
							} else {
								log.debug("cNTRMvmtMGTVO==getMvmtRsnCd=====U========="+cNTRMvmtMGTVO.getMvmtRsnCd());
								cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
								List<CHSAtdtHistoryMGTVO> insdateVoList = new ArrayList<CHSAtdtHistoryMGTVO>(); 
								cHSAtdtHistoryMGTVO.setIbflag("I");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getMvmtDt() ); // 수정
								cHSAtdtHistoryMGTVO.setEqKndCd("Z");
								cHSAtdtHistoryMGTVO.setChssNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setCreUsrId(cusCtmMovementVO.getUpdUsrId());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
								
	
								
								insdateVoList.add(cHSAtdtHistoryMGTVO);
								atdt.manageCHSAtdtByMvmtBasic(insdateVoList); 
								// 신규 Insert 처리 기존에 데이터가 없음 
								dbDao.addCHSMovementData(cNTRMvmtMGTVOs);
							}
							
							
							
							// Master 데이터 update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
						// end Chss_no is not null 
				    // ENd Row  데이터가  update  
					// start Row  데이터가    delete
					} else {  // 삭제시 
						if(!chssNo.equals("")){
							// Movement data 삭제 
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
					 
							// Attach detach data  삭제
							// 해당 date 이전의, 해당 Cntr OR Chss 로 attach되어 있는 AT/DT History 는 모두 Detach 처리
							cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
							List<CHSAtdtHistoryMGTVO> deldateVoList = new ArrayList<CHSAtdtHistoryMGTVO>(); 
							cHSAtdtHistoryMGTVO.setIbflag("D");
							cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
							cHSAtdtHistoryMGTVO.setAtchDt(cNTRMvmtMGTVO.getCnmvEvntDt() ); // 수정
							cHSAtdtHistoryMGTVO.setEqKndCd("Z");
							
							deldateVoList.add(cHSAtdtHistoryMGTVO);
							if(cNTRMvmtMGTVO2 !=null){
								// 조건 필요 업데이트
//								cgmEqAtchDtchHisMGTVO = dbDao.searchCgmEqAtchDtchHisData(cHSAtdtHistoryMGTVO);
//								if(cgmEqAtchDtchHisMGTVO !=null){
//									sLagDt     = cgmEqAtchDtchHisMGTVO.getLagDt();
//									sLeadDt    = cgmEqAtchDtchHisMGTVO.getLeadDt();
//									sLagDtYd   = cgmEqAtchDtchHisMGTVO.getLagDtYd();
//									sLeadDtYd  = cgmEqAtchDtchHisMGTVO.getLeadDtYd();
//									sAtchdt    = cgmEqAtchDtchHisMGTVO.getAtchDt();
//								}
//								
//								if(sLagDt == null) sLagDt ="";
//								if(sLeadDt == null) sLeadDt ="";
//								if(sLagDtYd == null) sLagDtYd ="";
//								if(sLeadDtYd == null) sLeadDtYd ="";
//								if(sAtchdt == null) sAtchdt = "";
								
							//  date,yard 변경시   바로 전 detach 정보  수정한다
								
								cHSAtdtHistoryMGTVO.setIbflag("N");
								cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
								cHSAtdtHistoryMGTVO.setCntrNo(cNTRMvmtMGTVO.getCntrNo());
								cHSAtdtHistoryMGTVO.setAtchYdCd(cusCtmMovementVO.getOrgYdCd());
								cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
								atdt.manageCHSAtdtPrePostHistoryBasic(cHSAtdtHistoryMGTVO);
								
								
							    //  AtDt 삭제
								atdt.manageCHSAtdtByMvmtBasic(deldateVoList); 
//								//  atdt 업데이트 
//								if(sAtchdt.equals(sLagDt) && sAtchdt.equals(sLeadDt)){
//									cHSAtdtHistoryMGTVO = new CHSAtdtHistoryMGTVO();
//									cHSAtdtHistoryMGTVO.setEqNo(cNTRMvmtMGTVO2.getChssNo());
//									cHSAtdtHistoryMGTVO.setAtchDt(sLagDt); // 수정
//									cHSAtdtHistoryMGTVO.setDtchYdCd(sLeadDtYd);
//								    cHSAtdtHistoryMGTVO.setDtchDt(sLeadDt);
//									cHSAtdtHistoryMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
//									atdt.manageCHSAtdtHistoryBasic(cHSAtdtHistoryMGTVO);
//								}
							}
							
							
							// Master 데이터 update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cNTRMvmtMGTVO.getChssNo());
//							cHSMasterMGTVO.setChssMvmtDestYdCd(cusCtmMovementVO.getDestYdCd());
//							cHSMasterMGTVO.setChssMvmtStsCd(cusCtmMovementVO.getMvmtStsCd());
//							cHSMasterMGTVO.setChssMvmtDt(cusCtmMovementVO.getCnmvEvntDt());
//							
////							cHSMasterMGTVO.setChssGateIoFlg(cusCtmMovementVO.getObCntrFlg)     //  확인
//							cHSMasterMGTVO.setAtchMgstNo(cusCtmMovementVO.getMgstNo()); // 확인
//							cHSMasterMGTVO.setCrntYdCd(cusCtmMovementVO.getOrgYdCd()); // 확인
//							cHSMasterMGTVO.setCrntLocCd(cusCtmMovementVO.getLocCd());  // 확인
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master 정보를 수정한다
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
								
						} else {
							//  Chss_no 가 없더라도  cntr_no, cnmv_yr, cnmv_id_no  로 cgm_chss_mvmt_his 테이블에 데이터가 있으면 삭제 해야합니다.  
							// (기존 delete sql 그대로 사용하면됨)
                          
							// Movement data 삭제 
							dbDao.removeCgmChssMvmtHisData(cusCtmMovementVO);
							
							// Master 데이터 update
							cHSMasterMGTVO    = new CHSMasterMGTVO();
							cHSMasterMGTVO.setEqNo(cusCtmMovementVO.getChssNo());
							cHSMasterMGTVO.setUpdUsrId(cusCtmMovementVO.getUpdUsrId());
							// Eq Master 정보를 수정한다
							if(cHSMasterMGTVO.getEqNo()!=null && !cHSMasterMGTVO.getEqNo().equals("")){
								chs.modifyCHSCgmEquipmentBasic(cHSMasterMGTVO);
							}
						}
					}
				}
				// END Row  데이터가  update , delete
			}
		 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.debug("manageCHSMovementByCtmBasic===           end ");
			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			log.debug("manageCHSMovementByCtmBasic===           end ");
			throw new EventException(de.getMessage());
//			return cusCtmMovementVOs; 
		}
		log.debug("manageCHSMovementByCtmBasic===           end ");
		return cusCtmMovementVOs;
	}



	
}