/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtBCImpl.java
*@FileTitle : Damage Flagging/Unflagging Pop Up,Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
* 2012.01.04 신혜정 [CHM-201215407-01] Hanger Rack/Bar Using Report 의 Detail EQ no 내역 팝업 조회                                          
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration.EQFlagMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EqListForDisposalVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.HangerRackReportVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-OperationManage Business Logic Basic Command implementation<br>
 * - alps-OperationManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin
 * @see EES_MNR_0139EventResponse,EES_MNR_0122HTMLAction,EQFlagMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class EQFlagMgtBCImpl extends BasicCommandSupport implements EQFlagMgtBC {

	// Database Access Object
	private transient EQFlagMgtDBDAO dbDao = null;
	// Flag From
	private String flgDmgCd 	= "DMG";
	private String flgHangerCd 	= "HGR";
	private String flgScrCd  	= "SCR";
	private String flgDonCd  	= "DON";
	private String flgTllCd  	= "TLL";
	private String flgDspCd  	= "DSP";

	// Flag Input Type Code List
	private String disposal        = "D";
	private String scrapping       = "C";
	private String donation        = "N";
	private String totalLoss       = "T";
	private String manual          = "M";
	private String movement        = "V";
	//private String repair          = "R";
	//private String workOrder       = "W";
	//private String invoice         = "I";
	//private String resultCreation  = "S";

	/**
	 * EQFlagMgtBCImpl 객체 생성<br>
	 * EQFlagMgtDBDAO를 생성한다.<br>
	 */
	public EQFlagMgtBCImpl() {
		dbDao = new EQFlagMgtDBDAO();
	}

	/**
	 * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException {
		try {
				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals(flgHangerCd)){
					customMnrEqStsVOS = dbDao.searchHangerFlagStatusListData(eQFlagListGRPVO.getEQFlagListINVO());
				}else{
					customMnrEqStsVOS = dbDao.searchEQFlagStatusListData(eQFlagListGRPVO.getEQFlagListINVO());
				}
				eQFlagListGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVOS);

				return eQFlagListGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Attatch/Detach Qty by CNTR] searchEQFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Attatch/Detach Qty by CNTR] searchEQFlagListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0122]W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrFlgHisVO> addCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
			List<CustomMnrEqStsVO> addCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
			List<CustomMnrEqStsVO> modifyCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();

			CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
			CustomMnrFlgHisVO[] customMnrFlgHisVOS = eQFlagListGRPVO.getArrCustomMnrFlgHisVOS();

			String mnrFlgTpCd = eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd();

			for ( int i = 0; i< customMnrEqStsVOS.length; i++ ) {
					if(mnrFlgTpCd.equals(flgHangerCd)){
						customMnrEqStsVOS[i].setHngrBarAtchKnt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
					}
					customMnrEqStsVOS[i].setCreUsrId(account.getUsr_id());
					customMnrEqStsVOS[i].setUpdDt(account.getUpd_dt());
					customMnrEqStsVOS[i].setCreDt(account.getUpd_dt());
					customMnrEqStsVOS[i].setCostDtlCd(mnrFlgTpCd);

					//history 테이블 세팅시작
					customMnrFlgHisVOS[i].setMnrStsFlg(customMnrEqStsVOS[i].getMnrDmgFlg());
					customMnrFlgHisVOS[i].setMnrFlgRmk(customMnrEqStsVOS[i].getMnrStsRmk());

					//행거
					if(mnrFlgTpCd.equals(flgHangerCd)){
						customMnrFlgHisVOS[i].setMnrStsFlg(customMnrEqStsVOS[i].getMnrHngrFlg());
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgHangerCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrHngrFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(manual);
						}
					//DMG
					} else if(mnrFlgTpCd.equals(flgDmgCd)){
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDmgCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(manual);
						}
					//스크랩
					} else if(mnrFlgTpCd.equals(flgScrCd)){
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgScrCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(scrapping);
						}
					//도네이션
					} else if(mnrFlgTpCd.equals(flgDonCd)){
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDonCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(donation);
						}
					//토탈로스
					} else if(mnrFlgTpCd.equals(flgTllCd)){
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgTllCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(totalLoss);
						}
					//Disposal
					} else if(mnrFlgTpCd.equals(flgDspCd)){
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDspCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(disposal);
						}
					}
					customMnrFlgHisVOS[i].setCreOfcCd(account.getOfc_cd());
					customMnrFlgHisVOS[i].setCreUsrId(account.getUsr_id());
					customMnrFlgHisVOS[i].setCreDt(account.getUpd_dt());

					addCustomMnrFlgHisVOS.add(customMnrFlgHisVOS[i]);

					int cnt = dbDao.checkHangerFlagStatusData(customMnrEqStsVOS[i].getEqNo());
					if(cnt > 0){
						modifyCustomMnrEqStsVOS.add(customMnrEqStsVOS[i]);
					} else {
						addCustomMnrEqStsVOS.add(customMnrEqStsVOS[i]);
					}
			}

			if(mnrFlgTpCd.equals(flgHangerCd)){
				if(modifyCustomMnrEqStsVOS.size() > 0 ){
					dbDao.modifyHangerFlagStatusData(modifyCustomMnrEqStsVOS);
				}
				if(addCustomMnrEqStsVOS.size() > 0 ){
					dbDao.addHangerFlagStatusData(addCustomMnrEqStsVOS);
				}
			} else{
				if(modifyCustomMnrEqStsVOS.size() > 0 ){
					dbDao.modifyEQFlagStatusData(modifyCustomMnrEqStsVOS);
				}
				if(addCustomMnrEqStsVOS.size() > 0 ){
					dbDao.addEQFlagStatusData(addCustomMnrEqStsVOS);
				}
			}

			if ( addCustomMnrFlgHisVOS.size() > 0 ) {
				if(mnrFlgTpCd.equals(flgHangerCd)){
					dbDao.addHangerFlagHistoryListData(addCustomMnrFlgHisVOS);
				}else{
					dbDao.addEQFlagHistoryListData(addCustomMnrFlgHisVOS,account.getOfc_cd());
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging] manageEQFlagListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging] manageEQFlagListBasic"}).getMessage(),de);
		}
	}

	/**
	 * [Damage Flagging/Unflagging Interface] Flagging , CTM 호출 전용 외부 Interface Method <br>
	 * MNR, MST, CGM 에 정보를 업데이트 합니다.
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIFFlagForOtherBasic(CustomMnrEqStsVO customMnrEqStsVO, SignOnUserAccount account) throws EventException{
		try {

			/* 필수 입력 받을 값
			 *  customMnrEqStsVO.setEqNo(*** );			 AMFU5001997
			 *	customMnrEqStsVO.setEqKndCd(***);		 U
			 *	customMnrEqStsVO.setEqTpszCd(***);	     D2
			 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);	 KRPUSHN
			 *  customMnrEqStsVO.setMnrDmgFlg(***)    	 0=>N , 1=>Y
			 *  매칭테이블 MNR_EQ_STS
			 */

			/*======================================================================================
			 *  2010.09.09 박명신 [CHM-201005672-01] 추가작업 - 요청데미지플레깅과 값이 다를때만 로직 태움  *
			 =======================================================================================*/
			/*======================================================================================
			 *  2010.09.13 박명신 [CHM-201005672-01] 요청데미지플레깅과 값이 다를때만 로직 태움 - 검증로직 뺌
			 =======================================================================================*/
			/*CustomMnrEqStsVVO customMnrEqStsVVO = dbDao.searchEqInfoData(customMnrEqStsVO.getEqNo());
			boolean isNeedFlagging = true;
			String reqDmgFlg =  customMnrEqStsVO.getMnrDmgFlg().equals("0") ?  "N" : "Y";
			if(!customMnrEqStsVVO.getDmgFlag().equalsIgnoreCase(reqDmgFlg)) {
				isNeedFlagging = true;
			}	*/

			//데미지 플레깅 로직 시작
			List<CustomMnrFlgHisVO> addCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
			List<CustomMnrEqStsVO> addCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
			List<CustomMnrEqStsVO> modifyCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();

			//STS 테이블 세팅시작
			customMnrEqStsVO.setCreUsrId(account.getUsr_id());
			customMnrEqStsVO.setMnrStsRmk(account.getUsr_id());
			customMnrEqStsVO.setUpdDt(account.getUpd_dt());
			customMnrEqStsVO.setCreDt(account.getUpd_dt());
			customMnrEqStsVO.setCostDtlCd(flgDmgCd);
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			String today = formatter.format(new java.util.Date());
			customMnrEqStsVO.setMnrDmgFlgDt(today);
			customMnrEqStsVO.setMnrStsRmk("CTM OP EVENT CALL");

			int cnt = dbDao.checkHangerFlagStatusData(customMnrEqStsVO.getEqNo());
			if(cnt > 0){
				modifyCustomMnrEqStsVOS.add(customMnrEqStsVO);
			} else {
				addCustomMnrEqStsVOS.add(customMnrEqStsVO);
			}

			CustomMnrFlgHisVO customMnrFlgHisVO =  new CustomMnrFlgHisVO();
			//history 테이블 세팅시작
			customMnrFlgHisVO.setEqNo(customMnrEqStsVO.getEqNo());
			customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVO.getEqTpszCd());
			customMnrFlgHisVO.setEqKndCd(customMnrEqStsVO.getEqKndCd());
			customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());
			customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrDmgFlg());
			customMnrFlgHisVO.setMnrFlgRmk(customMnrEqStsVO.getMnrStsRmk());
			customMnrFlgHisVO.setMnrFlgTpCd(flgDmgCd);
			customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());
			customMnrFlgHisVO.setMnrFlgInpDt(customMnrEqStsVO.getMnrDmgFlgDt());
			customMnrFlgHisVO.setMnrFlgInpTpCd(movement);
			customMnrFlgHisVO.setCreUsrId(account.getUsr_id());
			customMnrFlgHisVO.setCreDt(account.getUpd_dt());

			addCustomMnrFlgHisVOS.add(customMnrFlgHisVO);

			//history 테이블 insert
			dbDao.addEQFlagHistoryListData(addCustomMnrFlgHisVOS,account.getOfc_cd());

		    //STS 테이블 처리
			if(modifyCustomMnrEqStsVOS.size() > 0 ){
				dbDao.modifyEQFlagStatusData(modifyCustomMnrEqStsVOS);
			}
			if(addCustomMnrEqStsVOS.size() > 0 ){
				dbDao.addEQFlagStatusData(addCustomMnrEqStsVOS);
			}

			/***************** MST 외부 인터페이스 호출을 위한 **********************/
			IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
			if(customMnrEqStsVO.getMnrDmgFlg().equals("1")){
				iFMnrFlagVO.setStsFlag("Y");
			} else {
				iFMnrFlagVO.setStsFlag("N");
			}
			iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
			iFMnrFlagVO.setFlagUserId(account.getUsr_id());
			iFMnrFlagVO.setFlagType(flgDmgCd);
			iFMnrFlagVO.setRetireFlag("N");
			iFMnrFlagVO.setEqKindCd(customMnrEqStsVO.getEqKndCd());
			iFMnrFlagVO.setEqNo(customMnrEqStsVO.getEqNo());
			iFMnrFlagVO.setFlagDt(customMnrEqStsVO.getMnrDmgFlgDt());
			iFMnrFlagVO.setFlagYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());

			List<IFMnrFlagVO> cntrIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			List<IFMnrFlagVO> otherIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

			ContainerOnOffhireBC command1 =  new ContainerOnOffhireBCImpl();
			ChassisMgsetOnOffhireBC command2 =  new ChassisMgsetOnOffhireBCImpl();

			if(iFMnrFlagVO.getEqKindCd().equalsIgnoreCase("U")){
				cntrIFMnrFlagVOS.add(iFMnrFlagVO);
			} else {
				otherIFMnrFlagVOS.add(iFMnrFlagVO);
			}

			//로직 동일
			if ( cntrIFMnrFlagVOS.size() > 0 ) {
				IFMnrFlagVO[] arrIFMnrFlagVOS = new IFMnrFlagVO[cntrIFMnrFlagVOS.size()];
				for ( int i = 0; i < cntrIFMnrFlagVOS.size(); i++ ) {
					arrIFMnrFlagVOS[i] = cntrIFMnrFlagVOS.get(i);
				}
				command1.createMNRStatusBasic(arrIFMnrFlagVOS,account);
			}

			if ( otherIFMnrFlagVOS.size() > 0 ) {
				command2.createMNRStatusBasic(otherIFMnrFlagVOS);
			}
			/***************** MST 외부 인터페이스 호출을 위한 END **********************/


		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Interface] manageIFFlagForOtherBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Interface] manageIFFlagForOtherBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0125]Hanger Bar CNTR History의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListGRPVO 	eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagHistoryListBasic(EQFlagListGRPVO eQFlagListGRPVO,SignOnUserAccount account) throws EventException {
		try {

				List<CustomMnrFlgHisVO> customMnrFlgHisVO = new ArrayList<CustomMnrFlgHisVO>();
				customMnrFlgHisVO = dbDao.searchEQFlagHistoryListData(eQFlagListGRPVO.getEQFlagListINVO(),account.getOfc_cd());
				eQFlagListGRPVO.setCustomMnrFlgHisVOS(customMnrFlgHisVO);

				return eQFlagListGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar CNTR History] searchEQFlagHistoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar CNTR History] searchEQFlagHistoryListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidateFlagListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException {
		try {
				List<CustomMnrEqStsVO> customMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrEqRngStsVO> customMnrEqRngStsVO = new ArrayList<CustomMnrEqRngStsVO>();

				if(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd().equals("R")){
					customMnrEqRngStsVO = dbDao.searchDisposalCandidateFlagByRangeData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO(),account);
					disposalCandidateFlagGRPVO.setCustomMnrEqRngStsVOS(customMnrEqRngStsVO);
				}else if(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd().equals("N")) {
					customMnrEqStsVO = dbDao.searchDisposalCandidateFlagByEQData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO(),account);
					disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVO);

				}
				disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVO);

				return disposalCandidateFlagGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0158]Disposal Candidate Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidatePopupListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException {
		try {
				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				customMnrEqStsVOS = dbDao.searchDisposalCandidatePopupListData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO());
				disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVOS);

				return disposalCandidateFlagGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Inquiry_Pop Up] searchDisposalCandidatePopupListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Inquiry_Pop Up] searchDisposalCandidatePopupListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalCandidateFlagBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException{
		try {
			CustomMnrEqRngStsVO[] customMnrEqRngStsVOS = disposalCandidateFlagGRPVO.getarrCustomMnrEqRngStsVOS();
			CustomMnrEqStsVO[] customMnrEqStsVOS = disposalCandidateFlagGRPVO.getArrCustomMnrEqStsVOS();
			List<CustomMnrEqStsVO> customMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>();
			String selectCd = disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd();
			//Selection Type = EQ Range
			if(selectCd.equalsIgnoreCase("R"))
			{
				List<CustomMnrEqRngStsVO> mergeRngVoList = new ArrayList<CustomMnrEqRngStsVO>();

				int cnt=0;
				for ( int i=0; i< customMnrEqRngStsVOS.length; i++ ) {
					customMnrEqRngStsVOS[i].setCreUsrId(account.getUsr_id());
					customMnrEqRngStsVOS[i].setUpdUsrId(account.getUsr_id());
					mergeRngVoList.add(customMnrEqRngStsVOS[i]);
					customMnrEqStsVO=dbDao.checkDisposalCandidateFlagByRangeAfterData(mergeRngVoList);
					if(customMnrEqStsVO.size() >0)
					{
						dbDao.modifyDisposalCandidateFlagByRangeAfterData(mergeRngVoList);
						if(Integer.parseInt(customMnrEqRngStsVOS[i].getEqQty()) != customMnrEqStsVO.size())
						{
							dbDao.addDisposalCandidateFlagByRangeAfterData(mergeRngVoList);
						}
					}
					else
					{
						dbDao.addDisposalCandidateFlagByRangeAfterData(mergeRngVoList);
					}
					customMnrEqStsVO.clear();

					cnt++;
					if(cnt==10 || i==customMnrEqRngStsVOS.length-1)
					{
						if ( mergeRngVoList.size() > 0 ) {
							dbDao.mergeDisposalCandidateFlagByRangeData(mergeRngVoList);
						}
						mergeRngVoList.clear();
						cnt=0;
					}
				}
			}
			//Selection Type = EQ No
			else if(selectCd.equalsIgnoreCase("N"))
			{
				List<CustomMnrEqStsVO> mergeNoVoList = new ArrayList<CustomMnrEqStsVO>();
				for ( int i=0; i< customMnrEqStsVOS.length; i++ ) {
					if(!customMnrEqStsVOS[i].getIbflag().equalsIgnoreCase("R"))
					{
						customMnrEqStsVOS[i].setCreUsrId(account.getUsr_id());
						customMnrEqStsVOS[i].setUpdUsrId(account.getUsr_id());
						mergeNoVoList.add(customMnrEqStsVOS[i]);
					}
				}
				if ( mergeNoVoList.size() > 0 ) {
						dbDao.mergeDisposalCandidateFlagByEQData(mergeNoVoList);
				}
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] manageDisposalCandidateFlagBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] manageDisposalCandidateFlagBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0156] MNR_EQ_STS 의 mkr_nm,mdl_nm,rpr_cost_amt 추가/수정 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEqStsMkrNmMdlNmBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS();

			//DISPOSAL EQ_NO로 입력된것만
			for(int i = 0;i < arrCustomMnrDispDtlVOS.length;i++){
				if(arrCustomMnrDispDtlVOS[i].getDispUtTpCd().equals("E")){
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyEqStsMkrNmMdlNmData(arrCustomMnrDispDtlVOS[i]);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal request/approval] manageEqStsMkrNmMdlNmBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal request/approval] manageEqStsMkrNmMdlNmBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWarrantyAlertBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomWarrantyAlertListVO> addCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>();
			List<CustomWarrantyAlertListVO> modifyCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>();
			List<CustomWarrantyAlertListVO> removeCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>();

			CustomWarrantyAlertListVO[] customWarrantyAlertListVOS = warrantyAlertListGRPVO.getArrCustomWarrantyAlertListVOS();
			for ( int i=0; i< customWarrantyAlertListVOS.length; i++ ) {
				if (customWarrantyAlertListVOS[i].getIbflag().equals("I") || customWarrantyAlertListVOS[i].getIbflag().equals("U")){
					customWarrantyAlertListVOS[i].setCreUsrId(account.getUsr_id());
					customWarrantyAlertListVOS[i].setUpdUsrId(account.getUsr_id());
					customWarrantyAlertListVOS[i].setCreDt(account.getUpd_dt());
					customWarrantyAlertListVOS[i].setUpdDt(account.getUpd_dt());
					String checkResult = dbDao.checkWarrantyAlertData(customWarrantyAlertListVOS[i]);

					if(checkResult.equals("U")){
						modifyCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]);
					} else {
						addCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]);
					}
				} else if ( customWarrantyAlertListVOS[i].getIbflag().equals("D")){
					removeCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]);
				}
			}

			if ( addCustomWarrantyAlertListVOS.size() > 0 ) {
				dbDao.addWarrantyAlertData(addCustomWarrantyAlertListVOS);
			}

			if ( modifyCustomWarrantyAlertListVOS.size() > 0 ) {
				dbDao.modifyWarrantyAlertData(modifyCustomWarrantyAlertListVOS);
			}

			if ( removeCustomWarrantyAlertListVOS.size() > 0 ) {
				dbDao.removeWarrantyAlertData(removeCustomWarrantyAlertListVOS);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] manageWarrantyAlertBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] manageWarrantyAlertBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0151] Range 안에 EQ NO 리스트의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchRangeToEQNoBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException {
		try {
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			iFMnrFlagVOS = dbDao.searchRangeToEQNoData(disposalCandidateFlagGRPVO);
			disposalCandidateFlagGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			return disposalCandidateFlagGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchRangeToEQNoBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal Candidate Selection] searchRangeToEQNoBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0019] EQ NO 정보 단건 조회<br>
	 * @param String  eqNo
	 * @return String
	 * @exception EventException
	 */
	public  CustomMnrEqStsVVO searchEqInfoBasic(String  eqNo) throws EventException {
		try {
			CustomMnrEqStsVVO customMnrEqStsVVO = null;
			customMnrEqStsVVO = dbDao.searchEqInfoData(eqNo);
			return customMnrEqStsVVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Creation/Approval] searchEqInfoBasic"}).getMessage(),ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Creation/Approval] searchEqInfoBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0058] Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 * WO 삭제전 EQ_STS 테이블 정보를 참조한다.
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchHangerEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException {
		try {
			CustomMnrEqStsVO customMnrEqStsVO = dbDao.searchHangerEQFlagListData(eQFlagListGRPVO.getEQFlagListINVO());
			eQFlagListGRPVO.setCustomMnrEqStsVO(customMnrEqStsVO);
			return eQFlagListGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Extra W/O Delete] searchHangerEQFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Extra W/O Delete] searchHangerEQFlagListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0257] Hanger Rack/Bar Using Report의 정보를 조회 합니다. <br>
	 * @param HangerRackReportVO hangerRackReportVO
	 * @param SignOnUserAccount account
	 * @return List<HangerRackReportVO>
	 * @exception EventException
	 */
	public List<HangerRackReportVO> searchHangerRackReportListBasic(HangerRackReportVO hangerRackReportVO, SignOnUserAccount account) throws EventException {
		try {
			hangerRackReportVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchHangerRackReportListData(hangerRackReportVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Rack Report] searchHangerRackReportListBasic"}).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Rack Report] searchHangerRackReportListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0258] Hanger Rack/Bar Using Report Pop Up 정보를 조회 합니다. <br>
	 * 
	 * @param HangerRackReportVO hangerRackReportVO
	 * @param SignOnUserAccount account
	 * @return List<HangerRackReportVO>
	 * @throws EventException
	 */	
	public List<HangerRackReportVO> searchHangerRackReportDtlListBasic(HangerRackReportVO hangerRackReportVO, SignOnUserAccount account) throws EventException {
		try {
			hangerRackReportVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchHangerRackReportDtlListData(hangerRackReportVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Rack Report Pop Up] searchHangerRackReportDtlListBasic"}).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Rack Report Pop Up] searchHangerRackReportDtlListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0151]Load Excel로 전달 받은 EQ들에 대한 정보를 조회합니다. <br>
	 *
	 * @param EqListForDisposalVO[] EqListForDisposalVOs
	 * @param String eqKndCd
	 * @return List<CustomMnrEqStsVO>
	 * @exception EventException
	 */
	public List<CustomMnrEqStsVO> searchEQDataForDisposalRSQL(EqListForDisposalVO[] EqListForDisposalVOs, String eqKndCd) throws EventException {
		try {
				List<CustomMnrEqStsVO> customMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>();
				
				List<String> eqList = new ArrayList();
				
				for(int i = 0; i < EqListForDisposalVOs.length; i++){
					eqList.add(EqListForDisposalVOs[i].getEqNo());
				}
				
				customMnrEqStsVO = dbDao.searchEQDataForDisposalRSQL(eqList, eqKndCd);

				return customMnrEqStsVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex);
		}
	}

}
