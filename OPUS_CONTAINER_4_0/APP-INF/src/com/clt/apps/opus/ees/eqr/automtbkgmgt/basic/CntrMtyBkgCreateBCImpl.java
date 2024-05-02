/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateBCImpl.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration.CntrMtyBkgCreateDBDAO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionRobVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiRobBKGVVDVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiRobVVDVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.MtyBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrCtrlMtyBkgExeQtyVO;
import com.clt.syscommon.common.table.EqrCtrlMtyBkgExeVO;

/**
 * OPUS-RepoPlanManage Business Logic Basic Command implementation<br>
 * - OPUS-RepoPlanManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_1018EventResponse,CntrRepoExecutionPlanEstablishBC 각 DAO 클래스 참조
 * @since J2EE 1.6 
 */
public class CntrMtyBkgCreateBCImpl extends BasicCommandSupport implements CntrMtyBkgCreateBC {

	// Database Access Object
	private transient CntrMtyBkgCreateDBDAO dbDao = null; 

	/**
	 * CntrRepoExecutionPlanEstablishBCImpl 객체 생성<br>
	 * CntrRepoExecutionPlanEstablishDBDAO를 생성한다.<br>
	 */
	public CntrMtyBkgCreateBCImpl() {
		dbDao = new CntrMtyBkgCreateDBDAO();
	}
	
	/**
	 * [EES_EQR_1018 : ]<br>
	 * 
	 * @param eesEqr1018ConditionVO EesEqr1018ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgList(EesEqr1018ConditionVO eesEqr1018ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgList(eesEqr1018ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_1051 : BKG NO 의 컨테이너 리스트 조회]<br>
	 * 
	 * @param eesEqr1051ConditionVO EesEqr1051ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgContainerList(EesEqr1051ConditionVO eesEqr1051ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgContainerList(eesEqr1051ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [EES_EQR_1018 : ]<br>
	 * BKG 구간정보 입력/수정/삭제
	 * @param eesEqr1018multiVOs	EesEqr1018MultiVO[] 
	 * @param account				SignOnUserAccount 
	 * @exception EventException
	 */
	public void modifyCntrMtyBkgList(EesEqr1018MultiVO[] eesEqr1018multiVOs, SignOnUserAccount account) throws EventException {
		try {
			
			// EQR_CTRL_MTY_BKG_EXE 수정/입력/삭제에 사용
			String trspModCd = null;
			String vslLaneCd = null;
			String vslCd = null;
			String skdVoyNo = null;
			String skdDirCd = null;
		    String bkgExeSeq=null;

			String fmYdCd = null;
			String fmEtdDt = null;
			String polClptIndSeq = null;
			
			String toYdCd = null;
			String toEtbDt = null;
			String podClptIndSeq = null;

			String repoPlnFbRsnCd = null;
			String eqRepoPurpCd = null;
			String repoPlnFbRmk = null;			
			
			String mtyRobFlg = null;
						
			// EQR_CTRL_MTY_BKG_EXE_QTY 테이블 입력/수정에 사용
			List<String> volList	= null;
			List<String> tpszList	= null;			
			String vol 				= null;    // type size별 vol 수량
	    	String ctnrTpszCd 		= null;

			String usrId			= account.getUsr_id();
			
			log.debug("----------------- eesEqr1018multiVOs.length : " +eesEqr1018multiVOs.length);
			
			if(eesEqr1018multiVOs != null && eesEqr1018multiVOs.length > 0){				
				for ( int i=0; i< eesEqr1018multiVOs.length; i++ ) {					

					trspModCd 		= eesEqr1018multiVOs[i].getTrspModCd();
					vslCd 			= eesEqr1018multiVOs[i].getVslCd();
					skdVoyNo 		= eesEqr1018multiVOs[i].getSkdVoyNo();
					skdDirCd 		= eesEqr1018multiVOs[i].getSkdDirCd();
				    bkgExeSeq		= eesEqr1018multiVOs[i].getBkgExeSeq();
				    
					vslLaneCd 		= eesEqr1018multiVOs[i].getVslLaneCd();
					if(eesEqr1018multiVOs[i].getFmYdCd().length() > 7){
						fmYdCd      = eesEqr1018multiVOs[i].getFmYdCd().substring(0, 7); // CODE 잘라주기()
					}else{
						fmYdCd 		= eesEqr1018multiVOs[i].getFmYdCd();
					}
					
					fmEtdDt 		= eesEqr1018multiVOs[i].getFmEtdDt();
					
					polClptIndSeq   = eesEqr1018multiVOs[i].getPolClptIndSeq();
					if(polClptIndSeq==null || polClptIndSeq.equals("")) polClptIndSeq = "1"; // ClptIndSeq 없는 경우 1입력
					
					if(eesEqr1018multiVOs[i].getFmYdCd().length() > 7){
						toYdCd      = eesEqr1018multiVOs[i].getToYdCd().substring(0, 7); // CODE 잘라주기()
					}else{
						toYdCd 		= eesEqr1018multiVOs[i].getToYdCd();
					}
					
					toEtbDt 		= eesEqr1018multiVOs[i].getToEtbDt();
					
					podClptIndSeq   = eesEqr1018multiVOs[i].getPodClptIndSeq();
					if(podClptIndSeq==null || podClptIndSeq.equals("")) podClptIndSeq = "1";  // ClptIndSeq 없는 경우 1입력
					
					repoPlnFbRsnCd 	= eesEqr1018multiVOs[i].getRepoPlnFbRsnCd();
					eqRepoPurpCd 	= eesEqr1018multiVOs[i].getEqRepoPurpCd();
					repoPlnFbRmk 	= eesEqr1018multiVOs[i].getRepoPlnFbRmk();
					mtyRobFlg       = eesEqr1018multiVOs[i].getMtyRobFlg();
					if(mtyRobFlg.equals("1")) mtyRobFlg = "Y"; // ROB CHECK  이면 1-->Y 로 변경
					else                      mtyRobFlg = "N"; // ROB UNCHECK이면 0-->N 로 변경
							
					tpszList		= eesEqr1018multiVOs[i].getTpszList();
					volList			= eesEqr1018multiVOs[i].getVolList();

					
					if ( eesEqr1018multiVOs[i].getIbflag().equals("I") ){
						
						EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo = new EqrCtrlMtyBkgExeVO();
						ObjectCloner.build(eesEqr1018multiVOs[i], eqrCtrlMtyBkgExeVo);
						
						// EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_EXE_SEQ 생성
						bkgExeSeq	= dbDao.makeBkgExeSeqOfCntrMtyBkg(trspModCd, vslCd, skdVoyNo, skdDirCd);
						
						// EXE Table[EQR_CTRL_MTY_BKG_EXE] Setting
						// PK
						eqrCtrlMtyBkgExeVo.setTrspModCd(trspModCd);
						eqrCtrlMtyBkgExeVo.setVslCd(vslCd);
						eqrCtrlMtyBkgExeVo.setSkdVoyNo(skdVoyNo);
						eqrCtrlMtyBkgExeVo.setSkdDirCd(skdDirCd);
						eqrCtrlMtyBkgExeVo.setBkgExeSeq(bkgExeSeq);
						
						// 나머지 정보
						eqrCtrlMtyBkgExeVo.setPolYdCd(fmYdCd);
						eqrCtrlMtyBkgExeVo.setPolEtdDt(fmEtdDt);
                        eqrCtrlMtyBkgExeVo.setPolClptIndSeq(polClptIndSeq);
                        
						eqrCtrlMtyBkgExeVo.setPodYdCd(toYdCd);
						eqrCtrlMtyBkgExeVo.setPodEtbDt(toEtbDt);
						eqrCtrlMtyBkgExeVo.setPodClptIndSeq(podClptIndSeq);
						
						eqrCtrlMtyBkgExeVo.setRepoPlnFbRsnCd(repoPlnFbRsnCd);
						eqrCtrlMtyBkgExeVo.setEqRepoPurpCd(eqRepoPurpCd);						
						eqrCtrlMtyBkgExeVo.setRepoPlnFbRmk(repoPlnFbRmk);
						
						eqrCtrlMtyBkgExeVo.setCreUsrId(usrId);
						
						eqrCtrlMtyBkgExeVo.setMtyRobFlg(mtyRobFlg);
						
						dbDao.modifyCntrMtyBkgList("I", eqrCtrlMtyBkgExeVo);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							// QTY Table[EQR_VSL_EXE_Pln_QTY ] Setting..
							EqrCtrlMtyBkgExeQtyVO eqrCtrlMtyBkgExeQtyVO = new EqrCtrlMtyBkgExeQtyVO();
							ObjectCloner.build(eqrCtrlMtyBkgExeVo, eqrCtrlMtyBkgExeQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							vol			= volList.get(j);							
					       	
							eqrCtrlMtyBkgExeQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrCtrlMtyBkgExeQtyVO.setCntrQty(vol);

							eqrCtrlMtyBkgExeQtyVO.setCreUsrId(usrId);
							eqrCtrlMtyBkgExeQtyVO.setUpdUsrId(usrId);
								
							dbDao.modifyCntrMtyBkgListQty("I", eqrCtrlMtyBkgExeQtyVO);
						}
						
					} else if ( eesEqr1018multiVOs[i].getIbflag().equals("U") ){
						EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo = new EqrCtrlMtyBkgExeVO();
						ObjectCloner.build(eesEqr1018multiVOs[i], eqrCtrlMtyBkgExeVo);
						
						eqrCtrlMtyBkgExeVo.setUpdUsrId(usrId);
						eqrCtrlMtyBkgExeVo.setMtyRobFlg(mtyRobFlg);
						dbDao.modifyCntrMtyBkgList("U",eqrCtrlMtyBkgExeVo);
						
						for ( int j=0; j < tpszList.size(); j++ ) {
							EqrCtrlMtyBkgExeQtyVO eqrCtrlMtyBkgExeQtyVO = new EqrCtrlMtyBkgExeQtyVO();
							ObjectCloner.build(eesEqr1018multiVOs[i], eqrCtrlMtyBkgExeQtyVO);
							
							ctnrTpszCd	= tpszList.get(j);
							vol			= volList.get(j);
						       	
							eqrCtrlMtyBkgExeQtyVO.setCntrTpszCd(ctnrTpszCd);
							eqrCtrlMtyBkgExeQtyVO.setCntrQty(vol);
							eqrCtrlMtyBkgExeQtyVO.setCreUsrId(usrId);
							eqrCtrlMtyBkgExeQtyVO.setUpdUsrId(usrId);
								
							dbDao.modifyCntrMtyBkgListQty("U", eqrCtrlMtyBkgExeQtyVO);

						}
						
					} else if ( eesEqr1018multiVOs[i].getIbflag().equals("D") ){
						EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo 		= new EqrCtrlMtyBkgExeVO();
						EqrCtrlMtyBkgExeQtyVO eqrCtrlMtyBkgExeQtyVO = new EqrCtrlMtyBkgExeQtyVO();
						
						ObjectCloner.build(eesEqr1018multiVOs[i], eqrCtrlMtyBkgExeVo);
						ObjectCloner.build(eqrCtrlMtyBkgExeVo, eqrCtrlMtyBkgExeQtyVO);											
						
						// EQR_CTRL_MTY_DCHG_PLN_QTY 테이블 삭제
						if (eqrCtrlMtyBkgExeQtyVO != null)
							dbDao.modifyCntrMtyBkgListQty("D", eqrCtrlMtyBkgExeQtyVO);
						
						// EQR_CTRL_MTY_DCHG_PLN 테이블 삭제
						if (eqrCtrlMtyBkgExeVo != null)
							dbDao.modifyCntrMtyBkgList("D",eqrCtrlMtyBkgExeVo);
						
						
					}
				}
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * [EES_EQR_1018 : VVD 존재 확인 및 SLAN 조회]<br>
	 * 
	 * @param String vvd 
	 * @param String trsp_mod_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrMtyBkgVvdSlan(String vvd, String trsp_mod_cd) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgVvdSlan(vvd, trsp_mod_cd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_1018 : From Yard 및 ETD 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdFmYdList(String vvd) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgVvdFmYdList(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [EES_EQR_1018 : To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgVvdToYdList(String vvd) throws EventException {
		try {
			log.debug("bcimple searchCntrMtyBkgVvdToYdList =======");
			return dbDao.searchCntrMtyBkgVvdToYdList(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * [EES_EQR_1018 : BKG/DOC Interface - Mty Booking Creation ]<br>
	 * BKG/DOC 생성하기위해 필요한 기본정보를 조회한후 BKG VO 에 셋팅해 주는 작업
	 * DB 를 만나는 CUD 는 없음.
	 * @param EesEqr1018MultiVO multiVO
	 * @param account	SignOnUserAccount 
	 * @return MtyBookingCreateVO
	 * @exception EventException
	 */
	public MtyBookingCreateVO createRepoBKG(EesEqr1018MultiVO multiVO, SignOnUserAccount account) throws EventException {
		MtyBookingCreateVO mtyBookingCreateVO = new MtyBookingCreateVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
//		MtyCntrVO mtyCntrVO= null;
		MtyQtyVO mtyQtyVO = null;
		
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
		Collection<MtyQtyVO> mtyQtyVOs = new ArrayList<MtyQtyVO>();
		
		String targetServer = null;
		String office_code	= null;
		List<String> tpszList= null;
		
//		String polClptIndSeq = null;
//		String podClptIndSeq = null;
        
        int sum_volum = 0;

        String trsp_mod_cd = null;
		String fm_rcc = null;
		String eqRepoPurpCd = null;

		String usrId	= account.getUsr_id();

//		String fm_port = null;
//		String to_port = null;
        
        try {
        	if ( multiVO != null ) {

		        //EesEqr1018MultiVO[] multiVOs = (EesEqr1018MultiVO[]) commonVO.getResultVo();		        
		        
		        //EesEqr1018MultiVO multiVO = multiVOs[0]; // 첫번째 row 를 꺼냄
		        
		        tpszList	= multiVO.getTpszList();
		        trsp_mod_cd = multiVO.getTrspModCd(); 
		        
		        log.debug("\n==================== createRepoBKG trsp_mod_cd : " +trsp_mod_cd);
		        
				// targer server information
				fm_rcc	= dbDao.searchMtyBkgRccCode(multiVO.getFmYdCd());	
	
				targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
				office_code = getOfficeCode(fm_rcc);
				
				// clt인 경우 targetServer를 변경한다.
		        targetServer = transServerName(targetServer);
		        
				log.debug("\n==================== createRepoBKG Vessel targetServer : " +targetServer);
				log.debug("\n==================== createRepoBKG Vessel office_code  : " +office_code);
									
				for ( int i=0; i < tpszList.size(); i++ ){
					sum_volum = 0;
					mtyQtyVO = new MtyQtyVO();

					sum_volum += Integer.parseInt( multiVO.getVolList().get(i));
					
					if(sum_volum > 0) {
						mtyQtyVO.setCntrTpszCd(tpszList.get(i));
						mtyQtyVO.setOpCntrQty(Integer.toString(sum_volum));
	
						mtyQtyVOs.add(mtyQtyVO);
					}
				}
				
				//commonVO.setConditionVo((EesEqr1018MultiVO) multiVO);				
		
				/** mtyBookingVO Setting **/
				mtyBookingVO.setCompInd		("H");
				mtyBookingVO.setUsrId		(usrId);
				mtyBookingVO.setBkgCreSvrCd	(targetServer);
				mtyBookingVO.setVslCd		(multiVO.getVslCd());
				mtyBookingVO.setSkdVoyNo	(multiVO.getSkdVoyNo());
				mtyBookingVO.setSkdDirCd	(multiVO.getSkdDirCd());
				mtyBookingVO.setBkgOfcCd	(office_code);
				mtyBookingVO.setPkupYdCd	(multiVO.getFmYdCd());
				mtyBookingVO.setPreRlyPortCd("");
				mtyBookingVO.setPstRlyPortCd("");
				mtyBookingVO.setPolYdCd		(multiVO.getFmYdCd());
	
				mtyBookingVO.setPodYdCd(multiVO.getToYdCd());
				
				// EQR에서 booking 시 Purpose 항목 추가
				// EQR은 D, H, E, S 로 관리 ---> BKG/DOC 에서는 D, H, S 로 관리
				// E, S ===> S 로 변형시킴. 
		        eqRepoPurpCd = multiVO.getEqRepoPurpCd();
				if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 인 경우
					mtyBookingVO.setMtyBkgStsCd("S");
				} else {														// H(Hanger Rack), D(Damage Repair) 인 경우
					mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
				}
				
				mtyBookingVO.setBkgRmk("");
				
				if(trsp_mod_cd.equals("V")) {
					mtyBookingVO.setMtySplitAvalCd("Z");  // trunk
				}else {
					mtyBookingVO.setMtySplitAvalCd("W");  // feeder
				}
				
				/** mtyVvdVO Setting **/
//				polClptIndSeq = dbDao.searchClptIndSeq(multiVO.getVslCd(), multiVO.getSkdVoyNo(), multiVO.getSkdDirCd(), fm_port);
//				podClptIndSeq = dbDao.searchClptIndSeq(multiVO.getVslCd(), multiVO.getSkdVoyNo(), multiVO.getSkdDirCd(), to_port);				
//				podClptIndSeq = ( podClptIndSeq.equals("") || podClptIndSeq == null ) ? "0" : podClptIndSeq; 
				log.debug("/n--------------- multiVO.getPolClptIndSeq() : " +multiVO.getPolClptIndSeq());		
				log.debug("/n--------------- multiVO.getPodClptIndSeq() : " +multiVO.getPodClptIndSeq());			
				
				mtyVvdVOs[0] = new MtyVvdVO();
				mtyVvdVOs[0].setVslPrePstCd	("T");
				mtyVvdVOs[0].setVslSeq		("0");
				mtyVvdVOs[0].setVslCd		(multiVO.getVslCd());
				mtyVvdVOs[0].setSkdVoyNo	(multiVO.getSkdVoyNo());
				mtyVvdVOs[0].setSkdDirCd	(multiVO.getSkdDirCd());
				mtyVvdVOs[0].setPolYdCd		(multiVO.getFmYdCd());
				mtyVvdVOs[0].setPodYdCd		(multiVO.getToYdCd());
				mtyVvdVOs[0].setPolClptIndSeq(multiVO.getPolClptIndSeq());
				mtyVvdVOs[0].setPodClptIndSeq(multiVO.getPodClptIndSeq());
				
				/** mtyBookingCreate VO Setting **/
				mtyBookingCreateVO.setMtyBookingVO(mtyBookingVO);
				mtyBookingCreateVO.setMtyVvdVOs( mtyVvdVOs );
				mtyBookingCreateVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
				mtyBookingCreateVO.setMtyQtyVOs( (MtyQtyVO[]) mtyQtyVOs.toArray(new MtyQtyVO[mtyQtyVOs.size()]) );
	
        	}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingCreateVO;
	}
	
	/**
	 * [EES_EQR_1052 : BKG/DOC Interface - Mty Booking Split ]<br>
	 * BKG SPLIT 생성을 위해서 BKG/DOC에 넘겨줘야 할 정보를 조회후 VO 에 셋팅
	 * EQR의 EQR_CTRL_MTY_BKG_EXE, EQR_CTRL_MTY_BKG_EXE_QTY 에 데이터 입력 
	 * 
	 * @param EesEqr1052ConditionVO eesEqr1052ConditionVO
	 * @param account	SignOnUserAccount
	 * @return MtyBookingSplitVO
	 * @exception EventException
	 */
	public MtyBookingSplitVO createRepoBKGSplit(EesEqr1052ConditionVO eesEqr1052ConditionVO, SignOnUserAccount account) throws EventException {
		//conditionVO ==> eesEqr1052ConditionVO
		MtyBookingSplitVO mtyBookingSplitVO = new MtyBookingSplitVO();
		MtyBookingVO mtyBookingVO = new MtyBookingVO();
		//MtyVvdVO[] mtyVvdVOs = new MtyVvdVO[1];
		MtyVvdVO[] mtyVvdVOs = null;
		MtyCntrVO mtyCntrVO= null;
		
		//CommonVO commonVO = new CommonVO();				
		Collection<MtyCntrVO> mtyCntrVOs = new ArrayList<MtyCntrVO>();
        
		String vl_bkg_no = null; // org no
		String vd_bkg_no = null; // split no

		String trspModCd = null;
		String vslLaneCd = null;
		String vslCd     = null;
		String skdVoyNo  = null;
		String skdDirCd  = null;
		String bkgExeSeq = null; 
		
		String fmYdCd    = null;
		String fmEtdDt   = null;
		String toYdCd    = null;
		String toEtbDt   = null;
		String usrId	 = null;
		
		String eqRepoPurpCd = null; //EQ_REPO_PURP_CD
		
		String targetServer = null;
		String office_code	= null;	
		String fm_rcc = null;
//		String fm_port = null;
//		String to_port = null;		

		String polClptIndSeq = null;
		String podClptIndSeq = null;
		
		String mtyRobFlg     = null;
		
		String repoPlnId	 = null;
		String refId		 = null;		
		String cntrTpSz		 = null;
		String cntrQty		 = null;
		
        try {
        	// BKG 에 넘겨줄 SPLIT BKG NO 구간정보 조회
			List<EesEqr1018MultiVO> splitRouteInfo = dbDao.searchCntrMtyBkgSplitRouteInfo(eesEqr1052ConditionVO);
			log.debug(">>>>>>>>>>>BKG 에 넘겨줄 SPLIT BKG NO 구간정보 조회 데이타 유무>>>"+splitRouteInfo.size());
        	// BKG 에 넘겨줄 SPLIT BKG NO - CNTR NO, CNTR TPSZ, MVMT 정보 조회
			List<EesEqr1052MultiVO> splitCntrInfo = dbDao.searchCntrMtyBkgSplitCntrInfo(eesEqr1052ConditionVO);
			log.debug(">>>>>>>>>>>BKG 에 넘겨줄 SPLIT BKG NO - CNTR NO, CNTR TPSZ, MVMT 정보 조회 데이타 유무>>>"+splitCntrInfo.size());
        	// EQR 테이블에 입력처리
			
			EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVo = new EqrCtrlMtyBkgExeVO();
			//ObjectCloner.build(eesEqr1018multiVO, eqrCtrlMtyBkgExeVo);

//			log.debug("splitRouteInfo.size() : " + splitRouteInfo.size());
//			for(int i=0; i<splitRouteInfo.size(); i++) {				
//				log.debug("splitRouteInfo : " + i + " , trsp_mod_cd : " + splitRouteInfo.get(i).getTrspModCd());
//				log.debug("splitRouteInfo : " + i + " , fm_yd_cd    : " + splitRouteInfo.get(i).getFmYdCd());
//				log.debug("splitRouteInfo : " + i + " , fm_etd_dt   : " + splitRouteInfo.get(i).getFmEtdDt());											
//				log.debug("splitRouteInfo : " + i + " , to_yd_cd    : " + splitRouteInfo.get(i).getToYdCd());		
//				log.debug("splitRouteInfo : " + i + " , to_etb_dt   : " + splitRouteInfo.get(i).getToEtbDt());						
//			}
//			
//			for(int i=0; i<splitCntrInfo.size(); i++) {				
//				log.debug("splitCntrInfo : " + i + " , cntr_no      : " + splitCntrInfo.get(i).getCntrNo());
//				log.debug("splitCntrInfo : " + i + " , cntr_tpsz_cd : " + splitCntrInfo.get(i).getCntrTpszCd());
//				log.debug("splitCntrInfo : " + i + " , mvmt_sts_cd  : " + splitCntrInfo.get(i).getMvmtStsCd());																
//			}		
			
			if(splitRouteInfo.size() > 0) {
				vl_bkg_no = eesEqr1052ConditionVO.getVlBkgNo(); // org no
				vd_bkg_no = eesEqr1052ConditionVO.getVdBkgNo(); // split no
				mtyRobFlg = eesEqr1052ConditionVO.getOpenFlagRob(); // ROB FLAG (Y, N)

				trspModCd = splitRouteInfo.get(0).getTrspModCd();
				vslLaneCd = splitRouteInfo.get(0).getVslLaneCd();
				vslCd     = splitRouteInfo.get(0).getVslCd();
				skdVoyNo  = splitRouteInfo.get(0).getSkdVoyNo();
				skdDirCd  = splitRouteInfo.get(0).getSkdDirCd();
			
				fmYdCd    = splitRouteInfo.get(0).getFmYdCd();
				fmEtdDt   = splitRouteInfo.get(0).getFmEtdDt();
				polClptIndSeq = splitRouteInfo.get(0).getPolClptIndSeq();
				
//				log.debug(" PLEASE fmEtdDt : " +fmEtdDt); 
				toYdCd    = splitRouteInfo.get(0).getToYdCd();
				toEtbDt   = splitRouteInfo.get(0).getToEtbDt();	
				podClptIndSeq = splitRouteInfo.get(0).getPodClptIndSeq();
				
				eqRepoPurpCd = splitRouteInfo.get(0).getEqRepoPurpCd();
				
				usrId	 = account.getUsr_id();
				log.debug(">>>>>>>usrId:"+usrId);
				log.debug(">>>>>>>vl_bkg_no:"+vl_bkg_no);
				log.debug(">>>>>>>vd_bkg_no:"+vd_bkg_no);
				log.debug(">>>>>>>mtyRobFlg:"+mtyRobFlg);
				log.debug(">>>>>>>trspModCd:"+trspModCd);
				log.debug(">>>>>>>vslLaneCd:"+vslLaneCd);
				log.debug(">>>>>>>vslCd:"+vslCd);
				log.debug(">>>>>>>skdVoyNo:"+skdVoyNo);
				log.debug(">>>>>>>skdDirCd:"+skdDirCd);
				log.debug(">>>>>>>fmYdCd:"+fmYdCd);
				log.debug(">>>>>>>fmEtdDt:"+fmEtdDt);
				log.debug(">>>>>>>polClptIndSeq:"+polClptIndSeq);
				log.debug(">>>>>>>toYdCd:"+toYdCd);
				log.debug(">>>>>>>toEtbDt:"+toEtbDt);
				log.debug(">>>>>>>podClptIndSeq:"+podClptIndSeq);
				log.debug(">>>>>>>eqRepoPurpCd:"+eqRepoPurpCd);
			}
			
			// ---- EQR 데이터 작업 ---------------------------------------------------------------------------------
			// EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_EXE_SEQ 생성
			if(trspModCd != null && vslCd != null && skdVoyNo != null && skdDirCd != null) {
				bkgExeSeq	= dbDao.makeBkgExeSeqOfCntrMtyBkg(trspModCd, vslCd, skdVoyNo, skdDirCd);
			}
			log.debug("EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_EXE_SEQ 생성 :"+bkgExeSeq);
			// EXE Table[EQR_CTRL_MTY_BKG_EXE] Setting
			// PK
			if(trspModCd != null) eqrCtrlMtyBkgExeVo.setTrspModCd(trspModCd);
			if(vslLaneCd != null) eqrCtrlMtyBkgExeVo.setVslLaneCd(vslLaneCd);
			if(vslCd != null) eqrCtrlMtyBkgExeVo.setVslCd(vslCd);
			if(skdVoyNo != null) eqrCtrlMtyBkgExeVo.setSkdVoyNo(skdVoyNo);
			if(skdDirCd != null) eqrCtrlMtyBkgExeVo.setSkdDirCd(skdDirCd);
			if(bkgExeSeq != null) eqrCtrlMtyBkgExeVo.setBkgExeSeq(bkgExeSeq);

			eqrCtrlMtyBkgExeVo.setMtyBkgFlg("Y");
			eqrCtrlMtyBkgExeVo.setMtyBkgSplitFlg("Y");
			if(vd_bkg_no != null) eqrCtrlMtyBkgExeVo.setMtyBkgNo(vd_bkg_no);     // SPLIT BKG NO
			if(vl_bkg_no != null) eqrCtrlMtyBkgExeVo.setOldBkgGrpNo(vl_bkg_no);  // ORG BKG NO
			
			// 나머지 정보
			if(fmYdCd != null) eqrCtrlMtyBkgExeVo.setPolYdCd(fmYdCd);
			if(fmEtdDt != null) eqrCtrlMtyBkgExeVo.setPolEtdDt(fmEtdDt);
			if(polClptIndSeq != null) eqrCtrlMtyBkgExeVo.setPolClptIndSeq(polClptIndSeq);
			
			if(toYdCd != null) eqrCtrlMtyBkgExeVo.setPodYdCd(toYdCd);
			if(toEtbDt != null) eqrCtrlMtyBkgExeVo.setPodEtbDt(toEtbDt);	
			if(podClptIndSeq != null) eqrCtrlMtyBkgExeVo.setPodClptIndSeq(podClptIndSeq);
			
			eqrCtrlMtyBkgExeVo.setRepoPlnFbRsnCd(null);
			if(eqRepoPurpCd != null) eqrCtrlMtyBkgExeVo.setEqRepoPurpCd(eqRepoPurpCd);						
			eqrCtrlMtyBkgExeVo.setRepoPlnFbRmk(null);
			if(usrId != null) eqrCtrlMtyBkgExeVo.setCreUsrId(usrId);
			if(mtyRobFlg != null) eqrCtrlMtyBkgExeVo.setMtyRobFlg(mtyRobFlg);

			// Searching repoPlanId
			if(vslCd != null && skdVoyNo != null && skdDirCd != null && vl_bkg_no != null) {
				repoPlnId = dbDao.searchRepoPlanId(vslCd, skdVoyNo, skdDirCd, vl_bkg_no);
			}
			eqrCtrlMtyBkgExeVo.setRepoPlnId(repoPlnId);
			
			// Searching RefId
			refId = dbDao.makeRefIDCntrRepoPlan("EQR_VSL_LODG_DCHG_EXE_PLN", repoPlnId, "V");
			eqrCtrlMtyBkgExeVo.setRefId(refId);

			// EQR_VSL_LODG_DCHG_EXE_PLN 에 입력
			dbDao.addCntrMtyBkgSplitList(eqrCtrlMtyBkgExeVo);        //--- ROB 수정할 자리
			
			// ORG BKG 정보 수정 (MTY_ROB_FLG='Y' 혹은 MTY_ROB_FLG='N')//--- 안해도 될것으로 판단(2014-03-11, )

			// EQR_VSL_EXE_PLN_QTY 에 입력
			for(int i=0; i<splitRouteInfo.size(); i++) {
				cntrTpSz = splitRouteInfo.get(i).getCntrTpszCd();
				cntrQty = splitRouteInfo.get(i).getCntrQty();
				if(vl_bkg_no != null && vslCd != null && skdVoyNo != null && skdDirCd != null) {
					dbDao.addCntrMtyBkgSplitListQty(cntrTpSz, cntrQty, refId, vl_bkg_no, vslCd, skdVoyNo, skdDirCd);
				}
			}

			// EQR_CTRL_DAT_VRFY 에 VD BKG NO 업데이트
			dbDao.updateEqrCtrlDatVrfy(eesEqr1052ConditionVO);

			log.debug(">>EQR ORG BKG 에 SPLIT HISTORY 생성 처리>>>>>>>>>>");
			log.debug(">>>> vl_bkg_no :"+vl_bkg_no);
			log.debug(">>>> usrId :"+usrId);
			log.debug(">>>> vd_bkg_no :"+vd_bkg_no);
        	// EQR ORG BKG 에 SPLIT HISTORY 생성
			if(vl_bkg_no != null && usrId != null && vd_bkg_no != null) {
				dbDao.createMtyBkgHistory("BS", vl_bkg_no, usrId, vd_bkg_no); // ORIGIN 기준
			}
        	if(vd_bkg_no != null && usrId != null && vl_bkg_no != null) {
        		dbDao.createMtyBkgHistory("BS", vd_bkg_no, usrId, vl_bkg_no); // SPLIT 기준
        	}
			
			// ------ BKG/DOC VO 셋팅 -----------------------------------------------------------------------------
        	if ( splitRouteInfo != null ) {					        		
				// targer server information
        		if(fmYdCd != null) {
        			fm_rcc	     = dbDao.searchMtyBkgRccCode(fmYdCd);				
        		}
        		if(fm_rcc != null) {
					targetServer = dbDao.searchServerName(fm_rcc, "REPO").getField1();
					office_code  = getOfficeCode(fm_rcc);
        		}
					
				// clt인 경우 targetServer를 변경한다.
        		if(targetServer != null) {
        			targetServer = transServerName(targetServer);	
        		}

	        	mtyBookingVO.setCompInd("H");
	        	if(usrId != null) mtyBookingVO.setUsrId(usrId);
	        	mtyBookingVO.setBkgCreSvrCd(targetServer);
	        	mtyBookingVO.setBkgRmk("");
	        	mtyBookingVO.setMtySplitAvalCd("S");
	        	if(vslCd != null) mtyBookingVO.setVslCd(vslCd);
	        	if(skdVoyNo != null) mtyBookingVO.setSkdVoyNo(skdVoyNo);
	        	if(skdDirCd != null) mtyBookingVO.setSkdDirCd(skdDirCd);
	        	if(office_code != null) mtyBookingVO.setBkgOfcCd(office_code);
	        	if(fmYdCd != null) mtyBookingVO.setPkupYdCd(fmYdCd);
	        	mtyBookingVO.setPreRlyPortCd("");
	        	mtyBookingVO.setPstRlyPortCd("");
	        	if(fmYdCd != null) mtyBookingVO.setPolYdCd(fmYdCd);
	        	if(toYdCd != null) mtyBookingVO.setPodYdCd(toYdCd);
	        	
	        	//EQR은 PURPOSE = H(Hanger Rack), D(Damage Repair)로 관리 ---> BKG/DOC 에서는 D, H
	        	//                E(Evacution), S(Stock Feeding)         -- > S 로
	        	if(eqRepoPurpCd != null) {
					if(!eqRepoPurpCd.equals("D") && !eqRepoPurpCd.equals("H")) {	// E(Evacution), S(Stock Feeding) 인 경우
						mtyBookingVO.setMtyBkgStsCd("S");
					} else {														// H(Hanger Rack), D(Damage Repair) 인 경우
						mtyBookingVO.setMtyBkgStsCd(eqRepoPurpCd);
					}	        	
	        	}
					
	        	log.debug(">>>>setMtyBkgStsCd:"+mtyBookingVO.getMtyBkgStsCd());
				/** mtyVvdVO Setting **/
//				polClptIndSeq = dbDao.searchClptIndSeq(vslCd, skdVoyNo, skdDirCd, fm_port);
//				podClptIndSeq = dbDao.searchClptIndSeq(vslCd, skdVoyNo, skdDirCd, to_port);				
//				podClptIndSeq = ( podClptIndSeq.equals("") || podClptIndSeq == null ) ? "0" : podClptIndSeq;
				
			    log.debug("\n---------------- BKG SPLIT BCIMPL, mtyRobFlg : "+mtyRobFlg);
			    /*
			     * 1. 보통 BKG SPLIT 인 경우
			     *    1) ORG BKG VVD 1개만 셋팅 (예전과 동일)
			     * 2. ROB SPLIT 인 경우
			     *    1) ORG BKG VVD - ROB SPLIT VVD 사이의 VVD 검색
			     *    2) ORG BKG의 POD 가 TURNING PORT인지 확인 (T : turning, F : not turning)
			     *    3) 각 VVD 들의 POL-POD 정보를 로직에 의해서 검색
			     *    4) MtyVvdVO에 셋팅
			     */
			    if(mtyRobFlg != null) {
					if(mtyRobFlg.equals("N")) {  // 보통 BKG SPLIT 인 경우는 ORG BKG VVD 1개만 셋팅
						mtyVvdVOs = new MtyVvdVO[1];
						
						mtyVvdVOs[0] = new MtyVvdVO();
						mtyVvdVOs[0].setVslPrePstCd("T");
						mtyVvdVOs[0].setVslSeq("0");
						if(vslCd != null) mtyVvdVOs[0].setVslCd(vslCd);
						if(skdVoyNo != null) mtyVvdVOs[0].setSkdVoyNo(skdVoyNo);
						if(skdDirCd != null) mtyVvdVOs[0].setSkdDirCd(skdDirCd);
						if(fmYdCd != null) mtyVvdVOs[0].setPolYdCd(fmYdCd);
						if(toYdCd != null) mtyVvdVOs[0].setPodYdCd(toYdCd);
						if(polClptIndSeq != null) mtyVvdVOs[0].setPolClptIndSeq(polClptIndSeq);
						if(podClptIndSeq != null) mtyVvdVOs[0].setPodClptIndSeq(podClptIndSeq);
						
					}else { // ROB SPLIT
					    // ROB SPLIT 인 경우는 VVD를 다중으로 가져가므로 정보를 검색해서 MtyVvdVO에 셋팅 
					    // 1. ORG BKG VVD - ROB SPLIT VVD 사이의 VVD 검색
						EesEqr1052ConditionRobVO eesEqr1052ConditionRobVO = new EesEqr1052ConditionRobVO();
						List<EesEqr1052MultiRobBKGVVDVO> eesEqr1052MultiRobBkgVVDVO = null;
						
						List<EesEqr1052MultiRobVVDVO> eesEqr1052MultiRobVVDVO = dbDao.searchRobVVDHeaderInfo(eesEqr1052ConditionVO);
						int vvdSize = eesEqr1052MultiRobVVDVO.size();
						
						mtyVvdVOs = new MtyVvdVO[vvdSize];
											
						// ORG BKG의 POD 가 TURNING PORT인지 확인 (T : turning, F : not turning)
						String checkTurnPort = "";
						if(vl_bkg_no != null) {
							checkTurnPort = dbDao.checkOrgBkgPodIsTurnPort(vl_bkg_no);
						}
						String pol_yard = "";
						String pod_yard = "";
						
						for(int i=0; i<eesEqr1052MultiRobVVDVO.size(); i++) {	
							/*
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " -------------------------------------------------------------------");
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " , VSL_CD     : " + eesEqr1052MultiRobVVDVO.get(i).getVslCd());
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " , SKD_VOY_NO : " + eesEqr1052MultiRobVVDVO.get(i).getSkdVoyNo());
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " , SKD_DIR_CD : " + eesEqr1052MultiRobVVDVO.get(i).getSkdDirCd());											
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " , NUM    	   : " + eesEqr1052MultiRobVVDVO.get(i).getNum());		
							log.debug("\n eesEqr1052MultiRobVVDVO : " + i + " , VSL_SEQ    : " + eesEqr1052MultiRobVVDVO.get(i).getVslSeq());	
							*/
							
							eesEqr1052ConditionRobVO.setVslCd			(eesEqr1052MultiRobVVDVO.get(i).getVslCd());
							eesEqr1052ConditionRobVO.setSkdVoyNo		(eesEqr1052MultiRobVVDVO.get(i).getSkdVoyNo());
							eesEqr1052ConditionRobVO.setSkdDirCd		(eesEqr1052MultiRobVVDVO.get(i).getSkdDirCd());
							eesEqr1052ConditionRobVO.setVslSeq			(eesEqr1052MultiRobVVDVO.get(i).getVslSeq());
							if(vl_bkg_no != null) {
								eesEqr1052ConditionRobVO.setVlBkgNo			(vl_bkg_no);
							}
							eesEqr1052ConditionRobVO.setCheckTurnPort	(checkTurnPort);               // ORG BKG의 POD 가 TURNING PORT인지 확인 (T : turning, F : not turning)
							if(toYdCd != null) {
								eesEqr1052ConditionRobVO.setPodYdCd			(toYdCd);
							}
							if(podClptIndSeq != null) {
								eesEqr1052ConditionRobVO.setPodClptIndSeq	(podClptIndSeq);
							}
							eesEqr1052ConditionRobVO.setVvdSize			(Integer.toString(vvdSize));   // VVD 전체 숫자
							eesEqr1052ConditionRobVO.setVvdNum			(Integer.toString(i));         // FOR LOOP에서의 VVD 순서(0,1,2,3...)
							
							// 2. 각 VVD 들의 POL-POD 정보를 로직에 의해서 검색
							eesEqr1052MultiRobBkgVVDVO = dbDao.searchRobBKGVVDInfo(eesEqr1052ConditionRobVO);
							
							// POL 혹은 POD 없는 경우 메세지로 에게 알려줌.(BKG SPLIT 중지)
							if(eesEqr1052MultiRobBkgVVDVO.size()>0) {
								pol_yard = eesEqr1052MultiRobBkgVVDVO.get(0).getPolYdCd();
								pod_yard = eesEqr1052MultiRobBkgVVDVO.get(0).getPodYdCd();
								if(pol_yard==null || pol_yard.equals("")) {
									throw new EventException(new ErrorHandler("EQR10031", new String[]{"ROB Turning POL Yard"}).getMessage());
								}
								if(pod_yard==null || pod_yard.equals("")) {
									throw new EventException(new ErrorHandler("EQR10031", new String[]{"ROB Turning POD Yard"}).getMessage());
								}			
							}else {  // 검색결과가 없는 경우(turning port 없다는 의미)
								throw new EventException(new ErrorHandler("EQR10031", new String[]{"ROB Turning Yard"}).getMessage());
							}
							
							// 3. MtyVvdVO에 셋팅
							mtyVvdVOs[i] = new MtyVvdVO();
							
							mtyVvdVOs[i].setVslPrePstCd(	eesEqr1052MultiRobBkgVVDVO.get(0).getVslPrePstCd()	);
							mtyVvdVOs[i].setVslSeq(			eesEqr1052MultiRobBkgVVDVO.get(0).getVslSeq()		);
							mtyVvdVOs[i].setVslCd(			eesEqr1052MultiRobBkgVVDVO.get(0).getVslCd()		);
							mtyVvdVOs[i].setSkdVoyNo(		eesEqr1052MultiRobBkgVVDVO.get(0).getSkdVoyNo()		);
							mtyVvdVOs[i].setSkdDirCd(		eesEqr1052MultiRobBkgVVDVO.get(0).getSkdDirCd()		);
							mtyVvdVOs[i].setPolYdCd(		eesEqr1052MultiRobBkgVVDVO.get(0).getPolYdCd()		);
							mtyVvdVOs[i].setPodYdCd(		eesEqr1052MultiRobBkgVVDVO.get(0).getPodYdCd()		);
							mtyVvdVOs[i].setPolClptIndSeq(	eesEqr1052MultiRobBkgVVDVO.get(0).getPolClptIndSeq()	);
							mtyVvdVOs[i].setPodClptIndSeq(	eesEqr1052MultiRobBkgVVDVO.get(0).getPodClptIndSeq()	);							
							
						}			
					}
			    }
			
	        	log.debug(">>>>splitCntrInfo.size()>>>"+splitCntrInfo.size());
				// mtyCntrVOs Setting 		
				for(int k=0; k<splitCntrInfo.size(); k++) {
					mtyCntrVO = new MtyCntrVO();
					mtyCntrVO.setCntrNo		(splitCntrInfo.get(k).getCntrNo());
					mtyCntrVO.setCntrTpszCd	(splitCntrInfo.get(k).getCntrTpszCd());
					mtyCntrVO.setCnmvStsCd	(splitCntrInfo.get(k).getMvmtStsCd());	
					log.debug(">>>>>STEP3에 필요>>"+splitCntrInfo.get(k).getCntrNo());
					log.debug(">>>>>STEP3에 필요>>"+splitCntrInfo.get(k).getMvmtStsCd());
					mtyCntrVOs.add(mtyCntrVO);

		        	// BOOKING SPLIT HISTORY 생성(컨테이너 정보 포함) -- 속도문제로 제거
		        	//dbDao.createMtyBkgHistory("BS", vd_bkg_no, usrId, splitCntrInfo.get(k).getCntrNo());			

				}
	        	
	        	// mtyBookingSplitVO VO Setting 
	        	mtyBookingSplitVO.setMtyBookingVO(mtyBookingVO);
	        	if(mtyVvdVOs != null) mtyBookingSplitVO.setMtyVvdVOs( mtyVvdVOs );
	        	mtyBookingSplitVO.setMtyCntrVOs( (MtyCntrVO[]) mtyCntrVOs.toArray(new MtyCntrVO[mtyCntrVOs.size()]) );
	        		        		        	
	        }	
			
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
		
		return mtyBookingSplitVO;
	}	
	
	/**
	 * office code 를 결정하는 로직
	 * @param targetServer	String
	 * @return String
	 * @exception EventException
	 */
	public String getOfficeCode(String fm_rcc) throws EventException {
		String ofc_cd = null;
		
		try {
			if(fm_rcc.equals("USNYC")) 		ofc_cd = "NYCNA"; 
			else if(fm_rcc.equals("DEHAM")) ofc_cd = "HAMUR"; 
			else if(fm_rcc.equals("SGSIN")) ofc_cd = "SINWA"; 
			else                            ofc_cd = "SHAAS";   // CHSHA,HKHKG,TWTPE,KRSEL,TWTPE,JPTYO

			if(ofc_cd==null || ofc_cd.equals("")) {
				throw new EventException(new ErrorHandler("EQR10031", new String[]{"Office code"}).getMessage());
			}	
			
    		return ofc_cd;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}	
	
	/**
	 * ServerName 변경
	 * 
	 * @param targetServer	String
	 * @return String	target_server
	 * @exception EventException
	 */
	public String transServerName(String targetServer) throws EventException {
		String target_server = null;
		
		try {
        	if(targetServer.equals("DKR"))      target_server = "KOR";
        	else if(targetServer.equals("DCH")) target_server = "CHN";
        	else if(targetServer.equals("DSW")) target_server = "SWA";
        	else if(targetServer.equals("DUS")) target_server = "USA";
        	else if(targetServer.equals("DEU")) target_server = "EUR";        		

			if(target_server==null || target_server.equals("")) {
				throw new DAOException(new ErrorHandler("EQR10031", "Target server").getMessage());
			}	

    		return target_server;

		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}	
	
	/**
	 * [EES_EQR_1018 : MTY Booking Creation 후 Bkg No. 업데이트 해주기. ]<br>
	 * 
	 * @param EesEqr1018MultiVO multiVO
	 * @exception EventException
	 */
	public void modifyMtyBkgNo(EesEqr1018MultiVO multiVO) throws EventException {
//		List<Map<String, Object>> updateVoList = new ArrayList<Map<String, Object>>();
//		String usr_id	= null;
//		String mtyBkgNo	= null;
//		String oldBkgGrpNo = null;
		
		try {
//			if( mtyBkgVO != null) {
//				mtyBkgNo	= mtyBkgVO.getMtyBkgNo();
//				oldBkgGrpNo	= mtyBkgVO.getMtyBkgNo();
//				usr_id		= mtyBkgVO.getUsrId();
//			}

//			EesEqr1018MultiVO[] multiVOs = (EesEqr1018MultiVO[]) commonVO.getResultVo();
//				
//			for ( int i=0; i < multiVOs .length; i++ ) {
//				multiVOs[i].setMtyBkgNo(mtyBkgNo);
//				multiVOs[i].setUpdUsrId(usr_id);
//				Map<String, Object> list = new HashMap<String, Object>();
//				list.putAll(multiVOs[i].getColumnValues());
//				list.put("old_bkg_grp_no", oldBkgGrpNo);
//				updateVoList.add(list);
//			}

			if ( multiVO != null ) {
				dbDao.modifyMtyBkgNo(multiVO);
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}	
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param eesEqr1052ConditionVO EesEqr1052ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtyBkgSplitContainerList(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgSplitContainerList(eesEqr1052ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}

	/**
	 * [EES_EQR_1052 : ]<br>
	 * BKG SPLIT 선택정보 EQR_CTRL_DAT_VRFY에 입력
	 * @param EesEqr1052MultiVO[] eesEqr1052multiVOs
	 * @param EesEqr1052ConditionVO conditionVO
	 * @param account				SignOnUserAccount 
	 * @exception EventException
	 */
	public void addCntrMtyBkgSplitListTmp(EesEqr1052MultiVO[] eesEqr1052multiVOs, EesEqr1052ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		List<Map<String, Object>> updateVoList = new ArrayList<Map<String, Object>>();
		String tmp_seq   		= null;
		String pod_yd_cd 		= null;
		String to_etb_dt 		= null;
		String pod_clpt_ind_seq = null;
		
		try {
									
			// EQR_CTRL_DAT_VRFY 입력에 사용
			pod_yd_cd 		= conditionVO.getPodYdCd();
			if(pod_yd_cd.length() > 7) pod_yd_cd = pod_yd_cd.substring(0, 7);
			to_etb_dt 		= conditionVO.getToEtbDt();
			pod_clpt_ind_seq= conditionVO.getPodClptIndSeq();
			
			log.debug("----------------- eesEqr1052multiVOs.length : " +eesEqr1052multiVOs.length);
			
			if(eesEqr1052multiVOs != null && eesEqr1052multiVOs.length > 0){		
				// tmp seq 결정
				tmp_seq = dbDao.searchEqrCtrlDatVrfyTmpSeq();	
				
				// conditionVO 에 tmp seq 입력
				conditionVO.setTmpSeq(tmp_seq);
				
				log.debug("addCntrMtyBkgSplitList BCIMPL getBkgVvd : " +conditionVO.getVvd());
				
				for ( int i=0; i< eesEqr1052multiVOs.length; i++ ) {					

					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(eesEqr1052multiVOs[i].getColumnValues());
					updateVoList.add(list);
					
					list.put("tmp_seq",   			tmp_seq);
					list.put("pod_yd_cd", 			pod_yd_cd);
					list.put("to_etb_dt", 			to_etb_dt);
					list.put("pod_clpt_ind_seq", 	pod_clpt_ind_seq);
					list.put("usr_id", account.getUsr_id());
					
				}
				
				dbDao.addCntrMtyBkgSplitListTmp(updateVoList);	//BKG SPLIT 선택정보 EQR_CTRL_DAT_VRFY에 입력
				
			}
			

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}		

	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param String tmp_seq
	 * @return List<EesEqr1052MultiVO>
	 * @exception EventException
	 */
	public List<EesEqr1052MultiVO> searchCntrMtyBkgSplitListTmp(String tmp_seq) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgSplitListTmp(tmp_seq);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param eesEqr1052ConditionVO EesEqr1052ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrMtySplitResult(EesEqr1052ConditionVO eesEqr1052ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrMtySplitResult(eesEqr1052ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [EES_EQR_1052 : VVD의 mty bkg no 를 조회합니다.]<br>
	 * 
	 * @param String vvd 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyBkgNoInVVD(String vvd) throws EventException {
		try {
			log.debug("-------------------searchMtyBkgNoInVVD BCIMPL " );
			return dbDao.searchMtyBkgNoInVVD(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_1052 : VVD의 To Yard 및 ETB 조회]<br>
	 * 
	 * @param String vvd 
	 * @param String flag_rob 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchPodYardInVVD(String vvd, String flag_rob) throws EventException {
		try {

			return dbDao.searchPodYardInVVD(vvd, flag_rob);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}			
	
	/**
	 * [EES_EQR_1052 : ROB VVD 리스트 조회한다]<br>
	 * 
	 * @param String vvd 	  
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchROBVVDList(String vvd) throws EventException {
		try {

			return dbDao.searchROBVVDList(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}			
	
	/**
	 * [EES_EQR_1052 : VVD 존재 확인]<br>
	 * 
	 * @param String vvd 
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrMtyBkgVvdExist(String vvd) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgVvdExist(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_1052 : Feeder VVD 인지 조사]<br>
	 * 
	 * @param String vvd 
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrMtyBkgVvdIsWater(String vvd) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgVvdIsWater(vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * [EES_EQR_1052 : ]<br>
	 * 
	 * @param String vvd
	 * @param String excel_cntr_no
	 * @param String flag	 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public EesEqr1052MultiVO searchCntrMtyBkgSplitContainerInfo(String vvd, String excel_cntr_no, String flag) throws EventException {
		try {
			return dbDao.searchCntrMtyBkgSplitContainerInfo(vvd, excel_cntr_no, flag);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	/**
	 * [BOK/DOC InterFace : Mty Booking Cancel ]<br>
	 * BKG/DOC 화면에서 ORG BKG에 컨테이너가 할당되지 않고, VOLUME > 0 으로 큰 경우만 CALL 가능
	 * 
	 * @param mtyBkgVO	MtyBkgVO
	 * @exception EventException
	 */
	public void modifyMtyBkgCancel(MtyBkgVO mtyBkgVO) throws EventException {
		try {
			if( mtyBkgVO.getMtyBkgNo() != null ){
				dbDao.modifyBkgCancel(mtyBkgVO);

			} else {
				throw new EventException(new ErrorHandler("COM12200", "MTY BKG No.").getMessage());
			}
		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}	
	
	/**
	 * Mty Bkg History 입력<br>
	 * 
	 * @param  hisCategory String
	 * @param  mtyBkgNo String
	 * @param  usrId String
	 * @param  crntCtnt String
	 * @exception EventException
	 */
	public void createMtyBkgHistory(String hisCategory, String mtyBkgNo, String usrId, String crntCtnt) throws EventException {
		try {
			/*
			 * BC : MTY BOOKING CREATE
			 * BS : MTY BOOKING SPLIT CREATE
			 * BX : MTY BOOKING CANCEL
			 * CA : CONTAINER ATTACH
			 * CD : CONTAINER DETACH
			 */

			dbDao.createMtyBkgHistory(hisCategory, mtyBkgNo, usrId, crntCtnt);


		} catch (Exception ex) {
	        log.error("err "+ex.toString(),ex);
	        throw new EventException(ex.getMessage());
	    }
	}		
	
	/**
	 * [EES_EQR_1050 : ROB BKG 의 VVD 상세 정보.]<br>
	 * 
	 * @param eesEqr1050ConditionVO EesEqr1050ConditionVO 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyROBVVDDetail(EesEqr1050ConditionVO eesEqr1050ConditionVO) throws EventException {
		try {
			return dbDao.searchMtyROBVVDDetail(eesEqr1050ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}		
	
	/**
	 * checking Location
	 * 
	 * @param locLevel
	 * @param locCD
	 * @return String
	 * @exception EventException 
	 */
	public String checkLocation(String locLevel ,String locCD) throws EventException {
		String check = null;
		try {
			check = dbDao.checkLocation(locLevel ,locCD);
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("CIM21017",new String[]{}).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	
	
	/**
	 * [EES_EQR_1052 : ToEtbDt 존재 확인]<br>
	 * 
	 * @param String yard 
	 * @param String vvd 
	 * @return String
	 * @exception EventException
	 */
	public String searchYardInDateInfo(String yard, String vvd) throws EventException {
		try {
			return dbDao.searchYardInDateInfo(yard, vvd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * [Seq 조회]<br>
	 * 
	 * @param String gubun
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @param String vsl_lane_cd
	 * @param String vps_port_cd    
	 * @return String
	 * @exception EventException
	 */
	public String searchClptIndSEq(String gubun, String vsl_cd, String skd_voy_no, String skd_dir_cd, String vsl_lane_cd, String vps_port_cd) throws EventException {
		try {
			return dbDao.searchClptIndSEq(gubun, vsl_cd, skd_voy_no, skd_dir_cd, vsl_lane_cd, vps_port_cd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
}