/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration.CntrPlanGuidelineManageDBDAO;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import com.clt.syscommon.common.table.EqrCtrlDchgGlineVO;
import com.clt.syscommon.common.table.EqrCtrlDchgGlineValVO;
import com.clt.syscommon.common.table.EqrCtrlGlineHdrVO;
import com.clt.syscommon.common.table.EqrCtrlLodgGlineVO;


/**
 * OPUS-GuidelineManage Business Logic Basic Command implementation<br>
 * - OPUS-GuidelineManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1008EventResponse,CntrPlanGuidelineManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrPlanGuidelineManageBCImpl extends BasicCommandSupport implements CntrPlanGuidelineManageBC {
	/**
	 * Database Access Object
	 */
	private transient CntrPlanGuidelineManageDBDAO dbDao = null;

	/**
	 * CntrPlanGuidelineManageBCImpl 객체 생성<br>
	 * CntrRepoExecutionPlanEstablishDBDAO를 생성한다.<br>
	 */
	public CntrPlanGuidelineManageBCImpl() {
		dbDao = new CntrPlanGuidelineManageDBDAO();
	}

	/**
	 * [ EES_EQR_1008 : EQR Mty Repo Guideline 페이지 정보] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchGuidelineConfig(EesEqr1008ConditionVO condVO) throws EventException {
		CommonVO guidelineConfig = null; 
		try {
			guidelineConfig =dbDao.searchGuidelineConfig(condVO);
			return guidelineConfig;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1008 : EQR Mty Repo Guideline Config ] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGuidelineConfig(EesEqr1009ConditionVO conditionVO) throws EventException {
		CommonVO guidelineConfig = null; 
		try {
			guidelineConfig =dbDao.searchAddGuidelineConfig(conditionVO);
			return guidelineConfig;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1009 : EQR Mty Repo Guideline POL Search ] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchPolCdList(EesEqr1009ConditionVO conditionVO) throws EventException {
		CommonVO str_pol_cd = null; 
		try {
			str_pol_cd =dbDao.searchPolCdList(conditionVO);
			return str_pol_cd;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR Mty Repo Guideline Search ] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchGuidelineList(EesEqr1008ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchGuidelineList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1008 : EQR Mty Repo Guideline Creation ] <br>
	 * @param EesEqr1009ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchAmendPortion(EesEqr1009ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchAmendPortion(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [ EES_EQR_1008 : Mty Repo Guideline Management Save ]<br>
	 * @param eqrCtrlGlineHdrVOs
	 * @param eqrCtrlLodgGlineVOs
	 * @param eqrCtrlDchgGlineVOs
	 * @param eqrCtrlDchgGlineValVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiGuidelineList(List<EqrCtrlGlineHdrVO> eqrCtrlGlineHdrVOs,	List<EqrCtrlLodgGlineVO> eqrCtrlLodgGlineVOs,	List<EqrCtrlDchgGlineVO> eqrCtrlDchgGlineVOs,List<EqrCtrlDchgGlineValVO> eqrCtrlDchgGlineValVOs,SignOnUserAccount account) throws EventException {
		try {
			String ins_gline_seq = null;
			String grid_eq_gline_seq = null;
			String check_key    = null;

			// 화면에서 받은 임시 eq_gline_seq인 grid_eq_gline_seq와 같은 건에 대하여 데이터 그룹핑한다.
			// ibflag가 I,U,D일 경우 VO list에서 VO에 Data Setting
			// Sort id에 따라  Data setting Sort id = 1: Guideline Header, 2: Loading Guideline, 3:POD 
			// ibflag에 따라  DAO CALL

			if(eqrCtrlGlineHdrVOs.size() > 0){ 
				// EQ GUIDELINE HEADER INSERT
				for(int i=0; i<eqrCtrlGlineHdrVOs.size();i++){

					grid_eq_gline_seq = eqrCtrlGlineHdrVOs.get(i).getEqGlineSeq();

					if((eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("I") || (eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("U")){
						
						EqrCtrlGlineHdrVO EqrCtrlGlineHdrVO = new EqrCtrlGlineHdrVO();
						
						EqrCtrlGlineHdrVO.setTrdCd(eqrCtrlGlineHdrVOs.get(i).getTrdCd());
						EqrCtrlGlineHdrVO.setSubTrdCd(eqrCtrlGlineHdrVOs.get(i).getSubTrdCd());
						EqrCtrlGlineHdrVO.setVslLaneCd(eqrCtrlGlineHdrVOs.get(i).getVslLaneCd());
						EqrCtrlGlineHdrVO.setEqGlineSeq(eqrCtrlGlineHdrVOs.get(i).getEqGlineSeq());
						EqrCtrlGlineHdrVO.setVslCd(eqrCtrlGlineHdrVOs.get(i).getVslCd());
						EqrCtrlGlineHdrVO.setSkdVoyNo(eqrCtrlGlineHdrVOs.get(i).getSkdVoyNo());
						EqrCtrlGlineHdrVO.setSkdDirCd(eqrCtrlGlineHdrVOs.get(i).getSkdDirCd());
						EqrCtrlGlineHdrVO.setPolCd(eqrCtrlGlineHdrVOs.get(i).getPolCd());
						EqrCtrlGlineHdrVO.setEffStDt(eqrCtrlGlineHdrVOs.get(i).getEffStDt());
						EqrCtrlGlineHdrVO.setEffEndDt(eqrCtrlGlineHdrVOs.get(i).getEffEndDt());
						EqrCtrlGlineHdrVO.setCfmFlg(eqrCtrlGlineHdrVOs.get(i).getCfmFlg());
						EqrCtrlGlineHdrVO.setRepoGlineRmk(eqrCtrlGlineHdrVOs.get(i).getRepoGlineRmk());
						EqrCtrlGlineHdrVO.setCreUsrId(eqrCtrlGlineHdrVOs.get(i).getCreUsrId());
						EqrCtrlGlineHdrVO.setUpdUsrId(eqrCtrlGlineHdrVOs.get(i).getUpdUsrId());
						
						if((eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("I")){
							
							ins_gline_seq 	= dbDao.makeGuidelineSeq(EqrCtrlGlineHdrVO); //Create Guideline Seq
							 
							check_key = dbDao.checkGuidelineKey("EQR_CTRL_GLINE_HDR",EqrCtrlGlineHdrVO.getTrdCd(),EqrCtrlGlineHdrVO.getSubTrdCd(),EqrCtrlGlineHdrVO.getVslLaneCd(),ins_gline_seq,"",""); //Create Guideline Header PK 존재 유무 체크
							
							if(check_key.equals("N")){
								EqrCtrlGlineHdrVO.setEqGlineSeq(ins_gline_seq);
								dbDao.addGuidelineHeader(EqrCtrlGlineHdrVO); 	  // INSERT EQR_CTRL_GLINE_HDR TABLE
								
							}else{
								// PK Exception
							}
						}else if((eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("U")){
							String old_cfm_flg 	= dbDao.searchOldConfirmFlg(EqrCtrlGlineHdrVO); //Create Guideline Seq
							if(!eqrCtrlGlineHdrVOs.get(i).getCfmFlg().equals(old_cfm_flg)){
								dbDao.modifyGuidelineEffEndDt(EqrCtrlGlineHdrVO); // 전차수 GUIDELINE EFF_END_DT UPDATE
							}
							dbDao.modifyGuidelineHeader(EqrCtrlGlineHdrVO);
						}
						
						// EQ LOADING GUIDELINE  INSERT 
						if(eqrCtrlLodgGlineVOs.size() > 0){
							for(int a=0; a<eqrCtrlLodgGlineVOs.size();a++){
								
								if(grid_eq_gline_seq.equals(eqrCtrlLodgGlineVOs.get(a).getEqGlineSeq())){
									if((eqrCtrlLodgGlineVOs.get(a).getIbflag()).equals("I")){
										EqrCtrlLodgGlineVO EqrCtrlLodgGlineVO = new EqrCtrlLodgGlineVO();
										
										EqrCtrlLodgGlineVO.setTrdCd(eqrCtrlLodgGlineVOs.get(a).getTrdCd());
										EqrCtrlLodgGlineVO.setSubTrdCd(eqrCtrlLodgGlineVOs.get(a).getSubTrdCd());
										EqrCtrlLodgGlineVO.setVslLaneCd(eqrCtrlLodgGlineVOs.get(a).getVslLaneCd());
										EqrCtrlLodgGlineVO.setEqGlineSeq(eqrCtrlLodgGlineVOs.get(a).getEqGlineSeq());
										EqrCtrlLodgGlineVO.setCntrTpszCd(eqrCtrlLodgGlineVOs.get(a).getCntrTpszCd());
										EqrCtrlLodgGlineVO.setPrioSeq(eqrCtrlLodgGlineVOs.get(a).getPrioSeq());
										EqrCtrlLodgGlineVO.setEqGlineTpCd(eqrCtrlLodgGlineVOs.get(a).getEqGlineTpCd());
										EqrCtrlLodgGlineVO.setEqGlineVal(eqrCtrlLodgGlineVOs.get(a).getEqGlineVal());
										EqrCtrlLodgGlineVO.setCreUsrId(eqrCtrlLodgGlineVOs.get(a).getCreUsrId());
										EqrCtrlLodgGlineVO.setUpdUsrId(eqrCtrlLodgGlineVOs.get(a).getUpdUsrId());
									
										//Param : table_name,trd_cd, sub_trd_cd, vsl_lane_cd, eq_gline_seq,cntr_tpsz_cd, pod_cd
										if(ins_gline_seq != null) {
											check_key = dbDao.checkGuidelineKey("EQR_CTRL_LODG_GLINE",EqrCtrlLodgGlineVO.getTrdCd(), EqrCtrlLodgGlineVO.getSubTrdCd(),EqrCtrlLodgGlineVO.getVslLaneCd(), ins_gline_seq,EqrCtrlLodgGlineVO.getCntrTpszCd(), ""); //Create Guideline Header PK 존재 유무 체크
										}
										if(check_key != null) {
											if(check_key.equals("N")){
												if(ins_gline_seq != null) {
													EqrCtrlLodgGlineVO.setEqGlineSeq(ins_gline_seq);
												}
												dbDao.addLoadingGuideline(EqrCtrlLodgGlineVO); // INSERT EQR_CTRL_LODG_GLINE TABLE
											}
										}
									}
								}
							}
						}//end if(eqrCtrlLodgGlineVOs != null)
					
						// EQ DISCHARGING GUIDELINE  INSERT
						if(eqrCtrlDchgGlineVOs.size() > 0){ 
							for(int b=0; b<eqrCtrlDchgGlineVOs.size();b++){
								if(grid_eq_gline_seq.equals(eqrCtrlDchgGlineVOs.get(b).getEqGlineSeq())){
									if((eqrCtrlDchgGlineVOs.get(b).getIbflag()).equals("I")){
										
										EqrCtrlDchgGlineVO EqrCtrlDchgGlineVO = new EqrCtrlDchgGlineVO();
										
										EqrCtrlDchgGlineVO.setTrdCd(eqrCtrlDchgGlineVOs.get(b).getTrdCd());
										EqrCtrlDchgGlineVO.setSubTrdCd(eqrCtrlDchgGlineVOs.get(b).getSubTrdCd());
										EqrCtrlDchgGlineVO.setVslLaneCd(eqrCtrlDchgGlineVOs.get(b).getVslLaneCd());
										EqrCtrlDchgGlineVO.setEqGlineSeq(eqrCtrlDchgGlineVOs.get(b).getEqGlineSeq());
										EqrCtrlDchgGlineVO.setPodCd(eqrCtrlDchgGlineVOs.get(b).getPodCd());
										EqrCtrlDchgGlineVO.setCreUsrId(eqrCtrlDchgGlineVOs.get(b).getCreUsrId());
										EqrCtrlDchgGlineVO.setUpdUsrId(eqrCtrlDchgGlineVOs.get(b).getUpdUsrId());
										
										if((eqrCtrlDchgGlineVOs.get(b).getIbflag()).equals("I")){
											 if(ins_gline_seq == null){ //Loading이 Update이고 Discharging이 Insert일 경우
												 ins_gline_seq = eqrCtrlDchgGlineVOs.get(b).getEqGlineSeq();
											 }
											//Param : table_name,trd_cd, sub_trd_cd, vsl_lane_cd, eq_gline_seq,cntr_tpsz_cd, pod_cd
											check_key = dbDao.checkGuidelineKey("EQR_CTRL_DCHG_GLINE",EqrCtrlDchgGlineVO.getTrdCd(), EqrCtrlDchgGlineVO.getSubTrdCd(),EqrCtrlDchgGlineVO.getVslLaneCd(), ins_gline_seq,"",EqrCtrlDchgGlineVO.getPodCd()); //Create Guideline Header PK 존재 유무 체크
											if(check_key.equals("N")){
												EqrCtrlDchgGlineVO.setEqGlineSeq(ins_gline_seq);
												dbDao.addDischargingGuideline(EqrCtrlDchgGlineVO);	// INSERT EQR_CTRL_DCHG_GLINE TABLE
											}
										}
									}
								}
							}
						}
						// EQ DISCHARGING VALUE  INSERT 
						if(eqrCtrlDchgGlineValVOs.size() > 0){
							for(int c=0; c<eqrCtrlDchgGlineValVOs.size();c++){
								if(grid_eq_gline_seq.equals(eqrCtrlDchgGlineValVOs.get(c).getEqGlineSeq())){
									if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("I") || (eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("U")){
										
										EqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO	= new EqrCtrlDchgGlineValVO();

										EqrCtrlDchgGlineValVO.setTrdCd(eqrCtrlDchgGlineValVOs.get(c).getTrdCd());
										EqrCtrlDchgGlineValVO.setSubTrdCd(eqrCtrlDchgGlineValVOs.get(c).getSubTrdCd());
										EqrCtrlDchgGlineValVO.setVslLaneCd(eqrCtrlDchgGlineValVOs.get(c).getVslLaneCd());
										EqrCtrlDchgGlineValVO.setEqGlineSeq(eqrCtrlDchgGlineValVOs.get(c).getEqGlineSeq());
										EqrCtrlDchgGlineValVO.setPodCd(eqrCtrlDchgGlineValVOs.get(c).getPodCd());
										EqrCtrlDchgGlineValVO.setCntrTpszCd(eqrCtrlDchgGlineValVOs.get(c).getCntrTpszCd());
										EqrCtrlDchgGlineValVO.setEqGlineTpCd(eqrCtrlDchgGlineValVOs.get(c).getEqGlineTpCd());
										EqrCtrlDchgGlineValVO.setEqGlineVal(eqrCtrlDchgGlineValVOs.get(c).getEqGlineVal());
										EqrCtrlDchgGlineValVO.setCreUsrId(eqrCtrlDchgGlineValVOs.get(c).getCreUsrId());
										EqrCtrlDchgGlineValVO.setUpdUsrId(eqrCtrlDchgGlineValVOs.get(c).getUpdUsrId());
										
										
										if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("I")){
											 if(ins_gline_seq == null){ //Loading이 Update이고 Discharging이 Insert일 경우
												 ins_gline_seq = eqrCtrlDchgGlineValVOs.get(c).getEqGlineSeq();
											 }
											//Param : table_name,trd_cd, sub_trd_cd, vsl_lane_cd, eq_gline_seq,cntr_tpsz_cd, pod_cd
											check_key = dbDao.checkGuidelineKey("EQR_CTRL_DCHG_GLINE_VAL",EqrCtrlDchgGlineValVO.getTrdCd(), EqrCtrlDchgGlineValVO.getSubTrdCd(), EqrCtrlDchgGlineValVO.getVslLaneCd(), ins_gline_seq,EqrCtrlDchgGlineValVO.getCntrTpszCd(),EqrCtrlDchgGlineValVO.getPodCd()); //Create Guideline Header PK 존재 유무 체크
											if(check_key.equals("N")){
												EqrCtrlDchgGlineValVO.setEqGlineSeq(ins_gline_seq);
												dbDao.addDischargingValueGuideline(EqrCtrlDchgGlineValVO);	// INSERT EQR_CTRL_DCHG_GLINE_VAL TABLE
											}
										}else if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("U")){
											dbDao.modifyDischargingValueGuideline(EqrCtrlDchgGlineValVO);
										}
									}
								}
							}
						}//end if(eqrCtrlDchgGlineValVOs != null)
					}//end if((eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("I"))
				}//end for(int i=0; i<eqrCtrlGlineHdrVOs.size();i++)
			}//end if(eqrCtrlGlineHdrVOs != null)
			
			// EQ LOADING GUIDELINE  UPDATE 
			if(eqrCtrlLodgGlineVOs.size() > 0){
				for(int a=0; a<eqrCtrlLodgGlineVOs.size();a++){
					if((eqrCtrlLodgGlineVOs.get(a).getIbflag()).equals("U")){
							
						EqrCtrlLodgGlineVO EqrCtrlLodgGlineVO = new EqrCtrlLodgGlineVO();
						
						EqrCtrlLodgGlineVO.setTrdCd(eqrCtrlLodgGlineVOs.get(a).getTrdCd());
						EqrCtrlLodgGlineVO.setSubTrdCd(eqrCtrlLodgGlineVOs.get(a).getSubTrdCd());
						EqrCtrlLodgGlineVO.setVslLaneCd(eqrCtrlLodgGlineVOs.get(a).getVslLaneCd());
						EqrCtrlLodgGlineVO.setEqGlineSeq(eqrCtrlLodgGlineVOs.get(a).getEqGlineSeq());
						EqrCtrlLodgGlineVO.setCntrTpszCd(eqrCtrlLodgGlineVOs.get(a).getCntrTpszCd());
						EqrCtrlLodgGlineVO.setPrioSeq(eqrCtrlLodgGlineVOs.get(a).getPrioSeq());
						EqrCtrlLodgGlineVO.setEqGlineTpCd(eqrCtrlLodgGlineVOs.get(a).getEqGlineTpCd());
						EqrCtrlLodgGlineVO.setEqGlineVal(eqrCtrlLodgGlineVOs.get(a).getEqGlineVal());
						EqrCtrlLodgGlineVO.setCreUsrId(eqrCtrlLodgGlineVOs.get(a).getCreUsrId());
						EqrCtrlLodgGlineVO.setUpdUsrId(eqrCtrlLodgGlineVOs.get(a).getUpdUsrId());
						
						if((eqrCtrlLodgGlineVOs.get(a).getIbflag()).equals("U")){
							dbDao.modifyLoadingGuideline(EqrCtrlLodgGlineVO);
						}
					}
				}
			}//end if(eqrCtrlLodgGlineVOs != null)	
			
			
			//********************** EQ DISCHARGING GUIDELINE  INSERT >> POD ADD시에만 **********************
			if(eqrCtrlGlineHdrVOs.size() < 1 && eqrCtrlDchgGlineVOs.size() > 0){ 
				for(int b=0; b<eqrCtrlDchgGlineVOs.size();b++){
					if((eqrCtrlDchgGlineVOs.get(b).getIbflag()).equals("I")){
						
						EqrCtrlDchgGlineVO EqrCtrlDchgGlineVO = new EqrCtrlDchgGlineVO();
						
						EqrCtrlDchgGlineVO.setTrdCd(eqrCtrlDchgGlineVOs.get(b).getTrdCd());
						EqrCtrlDchgGlineVO.setSubTrdCd(eqrCtrlDchgGlineVOs.get(b).getSubTrdCd());
						EqrCtrlDchgGlineVO.setVslLaneCd(eqrCtrlDchgGlineVOs.get(b).getVslLaneCd());
						EqrCtrlDchgGlineVO.setEqGlineSeq(eqrCtrlDchgGlineVOs.get(b).getEqGlineSeq());
						EqrCtrlDchgGlineVO.setPodCd(eqrCtrlDchgGlineVOs.get(b).getPodCd());
						EqrCtrlDchgGlineVO.setCreUsrId(eqrCtrlDchgGlineVOs.get(b).getCreUsrId());
						EqrCtrlDchgGlineVO.setUpdUsrId(eqrCtrlDchgGlineVOs.get(b).getUpdUsrId());
						
						if((eqrCtrlDchgGlineVOs.get(b).getIbflag()).equals("I")){
							//Param : table_name,trd_cd, sub_trd_cd, vsl_lane_cd, eq_gline_seq,cntr_tpsz_cd, pod_cd
							check_key = dbDao.checkGuidelineKey("EQR_CTRL_DCHG_GLINE",EqrCtrlDchgGlineVO.getTrdCd(), EqrCtrlDchgGlineVO.getSubTrdCd(),EqrCtrlDchgGlineVO.getVslLaneCd(),EqrCtrlDchgGlineVO.getEqGlineSeq(),"",EqrCtrlDchgGlineVO.getPodCd()); //Create Guideline Header PK 존재 유무 체크
							if(check_key.equals("N")){
								dbDao.addDischargingGuideline(EqrCtrlDchgGlineVO);	// INSERT EQR_CTRL_DCHG_GLINE TABLE
							}
						}
					}
				}
			}
			
			
			//********************** EQ DISCHARGING VALUE INSERT/UPDATE >> POD ADD/UPDATE시에만 **********************
			if(eqrCtrlGlineHdrVOs.size() < 1 && eqrCtrlDchgGlineValVOs.size() > 0){
				for(int c=0; c<eqrCtrlDchgGlineValVOs.size();c++){
					if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("I")||(eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("U")){
						
						EqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO	= new EqrCtrlDchgGlineValVO();

						EqrCtrlDchgGlineValVO.setTrdCd(eqrCtrlDchgGlineValVOs.get(c).getTrdCd());
						EqrCtrlDchgGlineValVO.setSubTrdCd(eqrCtrlDchgGlineValVOs.get(c).getSubTrdCd());
						EqrCtrlDchgGlineValVO.setVslLaneCd(eqrCtrlDchgGlineValVOs.get(c).getVslLaneCd());
						EqrCtrlDchgGlineValVO.setEqGlineSeq(eqrCtrlDchgGlineValVOs.get(c).getEqGlineSeq());
						EqrCtrlDchgGlineValVO.setPodCd(eqrCtrlDchgGlineValVOs.get(c).getPodCd());
						EqrCtrlDchgGlineValVO.setCntrTpszCd(eqrCtrlDchgGlineValVOs.get(c).getCntrTpszCd());
						EqrCtrlDchgGlineValVO.setEqGlineTpCd(eqrCtrlDchgGlineValVOs.get(c).getEqGlineTpCd());
						EqrCtrlDchgGlineValVO.setEqGlineVal(eqrCtrlDchgGlineValVOs.get(c).getEqGlineVal());
						EqrCtrlDchgGlineValVO.setCreUsrId(eqrCtrlDchgGlineValVOs.get(c).getCreUsrId());
						EqrCtrlDchgGlineValVO.setUpdUsrId(eqrCtrlDchgGlineValVOs.get(c).getUpdUsrId());
						
						if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("I")){ //POD Row Add시
							//Param : table_name,trd_cd, sub_trd_cd, vsl_lane_cd, eq_gline_seq,cntr_tpsz_cd, pod_cd
							check_key = dbDao.checkGuidelineKey("EQR_CTRL_DCHG_GLINE_VAL",EqrCtrlDchgGlineValVO.getTrdCd(), EqrCtrlDchgGlineValVO.getSubTrdCd(), EqrCtrlDchgGlineValVO.getVslLaneCd(), EqrCtrlDchgGlineValVO.getEqGlineSeq(),EqrCtrlDchgGlineValVO.getCntrTpszCd(),EqrCtrlDchgGlineValVO.getPodCd()); //Create Guideline Header PK 존재 유무 체크
							if(check_key.equals("N")){
								dbDao.addDischargingValueGuideline(EqrCtrlDchgGlineValVO);	// UPDATE EQR_CTRL_DCHG_GLINE_VAL TABLE
							}							
						}else if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("U")){
							dbDao.modifyDischargingValueGuideline(EqrCtrlDchgGlineValVO);
						}
					}
				}
			}//end if(eqrCtrlGlineHdrVOs.size() < 1 && eqrCtrlDchgGlineValVOs.size() > 0)
			
			//********************** EQ DISCHARGING VALUE  DELETE **********************
			if(eqrCtrlDchgGlineValVOs.size() > 0){ 
				for(int b=0; b<eqrCtrlDchgGlineVOs.size();b++){
					if((eqrCtrlDchgGlineVOs.get(b).getIbflag()).equals("D")){
						
						EqrCtrlDchgGlineVO EqrCtrlDchgGlineVO = new EqrCtrlDchgGlineVO();
						
						EqrCtrlDchgGlineVO.setTrdCd(eqrCtrlDchgGlineVOs.get(b).getTrdCd());
						EqrCtrlDchgGlineVO.setSubTrdCd(eqrCtrlDchgGlineVOs.get(b).getSubTrdCd());
						EqrCtrlDchgGlineVO.setVslLaneCd(eqrCtrlDchgGlineVOs.get(b).getVslLaneCd());
						EqrCtrlDchgGlineVO.setEqGlineSeq(eqrCtrlDchgGlineVOs.get(b).getEqGlineSeq());
						EqrCtrlDchgGlineVO.setPodCd(eqrCtrlDchgGlineVOs.get(b).getPodCd());
						
						dbDao.delDischargingValueGuideline(EqrCtrlDchgGlineVO);
					}
				}
			}			
			
			//********************** EQ DISCHARGING   DELETE**********************
			if(eqrCtrlDchgGlineVOs.size() > 0){
				for(int c=0; c<eqrCtrlDchgGlineValVOs.size();c++){
					if((eqrCtrlDchgGlineValVOs.get(c).getIbflag()).equals("D")){
						
						EqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO	= new EqrCtrlDchgGlineValVO();

						EqrCtrlDchgGlineValVO.setTrdCd(eqrCtrlDchgGlineValVOs.get(c).getTrdCd());
						EqrCtrlDchgGlineValVO.setSubTrdCd(eqrCtrlDchgGlineValVOs.get(c).getSubTrdCd());
						EqrCtrlDchgGlineValVO.setVslLaneCd(eqrCtrlDchgGlineValVOs.get(c).getVslLaneCd());
						EqrCtrlDchgGlineValVO.setEqGlineSeq(eqrCtrlDchgGlineValVOs.get(c).getEqGlineSeq());
						EqrCtrlDchgGlineValVO.setPodCd(eqrCtrlDchgGlineValVOs.get(c).getPodCd());
						
						dbDao.delDischargingGuideline(EqrCtrlDchgGlineValVO);
					}
				}
			}//end if(eqrCtrlDchgGlineValVOs != null)
			
			//********************** EQ LOADING GUIDELINE  DELETE **********************
			if(eqrCtrlLodgGlineVOs.size() > 0){
				for(int a=0; a<eqrCtrlLodgGlineVOs.size();a++){
					if((eqrCtrlLodgGlineVOs.get(a).getIbflag()).equals("D")){
						EqrCtrlLodgGlineVO EqrCtrlLodgGlineVO = new EqrCtrlLodgGlineVO();
						
						EqrCtrlLodgGlineVO.setTrdCd(eqrCtrlLodgGlineVOs.get(a).getTrdCd());
						EqrCtrlLodgGlineVO.setSubTrdCd(eqrCtrlLodgGlineVOs.get(a).getSubTrdCd());
						EqrCtrlLodgGlineVO.setVslLaneCd(eqrCtrlLodgGlineVOs.get(a).getVslLaneCd());
						EqrCtrlLodgGlineVO.setEqGlineSeq(eqrCtrlLodgGlineVOs.get(a).getEqGlineSeq());
						
						
						dbDao.delLoadGuideline(EqrCtrlLodgGlineVO);
					}
				}
			}//end if(eqrCtrlLodgGlineVOs != null)
			
			
			//********************** EQ GUIDELINE HEADER DELETE **********************
			if(eqrCtrlGlineHdrVOs.size() > 0 ){
				for(int i=0; i<eqrCtrlGlineHdrVOs.size();i++){
					if((eqrCtrlGlineHdrVOs.get(i).getIbflag()).equals("D")){
						
						EqrCtrlGlineHdrVO EqrCtrlGlineHdrVO = new EqrCtrlGlineHdrVO();
						
						EqrCtrlGlineHdrVO.setTrdCd(eqrCtrlGlineHdrVOs.get(i).getTrdCd());
						EqrCtrlGlineHdrVO.setTrdCd(eqrCtrlGlineHdrVOs.get(i).getTrdCd());
						EqrCtrlGlineHdrVO.setSubTrdCd(eqrCtrlGlineHdrVOs.get(i).getSubTrdCd());
						EqrCtrlGlineHdrVO.setVslLaneCd(eqrCtrlGlineHdrVOs.get(i).getVslLaneCd());
						EqrCtrlGlineHdrVO.setEqGlineSeq(eqrCtrlGlineHdrVOs.get(i).getEqGlineSeq());
						
						dbDao.delGuidelineHdr(EqrCtrlGlineHdrVO);
					}
	
				}
			}
			
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * [ EES_EQR_1009 : Guideline Add/Amend Search ] <br>
	 * @param EesEqr1009ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchAddGuidelineList(EesEqr1009ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchAddGuidelineList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1009 :Lane의 유요한 VVD 체크] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdCd(EesEqr1009ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCheckVvdCd(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [ EES_EQR_1009 : VVD Search ] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchVvdCd(EesEqr1009ConditionVO conditionVO) throws EventException {
		CommonVO rtn_val = null; 
		try {
			rtn_val =dbDao.searchVvdCd(conditionVO);
			return rtn_val;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
	}

	/**
	 * [ EES_EQR_1008 : EQR Mty Repo  Guideline Add시 VVD 조회 ] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGlineVvd(EesEqr1009ConditionVO conditionVO) throws EventException {
		CommonVO vvd_cd = null; 
		try {
			vvd_cd =dbDao.searchAddGlineVvd(conditionVO);
			return vvd_cd;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ EES_EQR_1009 : EQR Mty Repo Guideline Add시 POL CD변경시 ETA DT 조회 ] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGlineEtaDt(EesEqr1009ConditionVO conditionVO) throws EventException {
		CommonVO vvd_cd = null; 
		try {
			vvd_cd =dbDao.searchAddGlineEtaDt(conditionVO);
			return vvd_cd;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 :입력 받은 rcc/lcc가 해당 rcc에 속하는지 체크] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkSubLocCd(EesEqr1008ConditionVO condVO) throws EventException {
		try{
			return dbDao.checkSubLocCd(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
	 
	 
	/**
	 * [ EES_EQR_1008 :입력 받은 rcc/lcc가 해당 rcc에 속하는지 체크] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMaxEqGlineSeq(EesEqr1008ConditionVO condVO) throws EventException {
		try{
			return dbDao.checkMaxEqGlineSeq(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
	 
	/**
	 * [ EES_EQR_1008 :입력 받은 POL 체크] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPodCd(EesEqr1008ConditionVO condVO) throws EventException {
		try{
			return dbDao.checkPodCd(condVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
	 
	/**
	 * [ EES_EQR_1009 : Guideline 존재 유무 체크] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String checkGline(EesEqr1009ConditionVO conditionVO) throws EventException {
		try{
			return dbDao.checkGline(conditionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
	
}