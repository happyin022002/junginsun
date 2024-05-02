/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeOfficeTransferMgtBCImpl.java
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration.ChargeOfficeTransferMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.DmtOfcTrnsHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferHistoryByContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;

/**
 * ALPS-DMTClosing Business Logic Basic Command implementation<br>
 * - ALPS-DMTClosing에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3009EventResponse,ChargeOfficeTransferMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChargeOfficeTransferMgtBCImpl extends BasicCommandSupport implements ChargeOfficeTransferMgtBC {

	// Database Access Object
	private transient ChargeOfficeTransferMgtDBDAO dbDao = null;

	/**
	 * ChargeOfficeTransferMgtBCImpl 객체 생성<br>
	 * ChargeOfficeTransferMgtDBDAO를 생성한다.<br>
	 */
	public ChargeOfficeTransferMgtBCImpl() {
		dbDao = new ChargeOfficeTransferMgtDBDAO();
	}
	
	/**
	 * Office Transfer 내역을 Office/날짜별로 조회한다.
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<DmtOfcTrnsHisVO>
	 * @exception EventException
	 */
	public List<DmtOfcTrnsHisVO> searchOfficeTransferHistoryList(OfficeTransferParmVO officeTransferParmVO) throws EventException {
		try {
			return dbDao.searchOfficeTransferHistoryList(officeTransferParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		}
	}
	
	
	/**
	 * Charge를 Office Transfer되도록 Charge의 Office Data를 수정한다.
	 * Office Transfer 할 Charge의 Status가 "F"(Finish), "L"(Long Staying) 상태이다.
	 * 
	 * @param	OfficeTransferParmVO[] officeTransferParmVOs
	 * @param	SignOnUserAccount account
	 * @return	String[]
	 * @exception EventException
	 */
	public String[] createOfficeTransferCharge(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException {
		try {
			// 오류 발생시 오류 메세지 코드와 부가정보를  배열에 저장해서 리턴한다.
			String result[] = new String[2];
			
			// 첫번째 VO객체를 가져온다.
			OfficeTransferParmVO ofcTrnsParmVO = officeTransferParmVOs[0];
			
			//String fmSvrId = ofcTrnsParmVO.getSvrId();
			String fmOfcCd = ofcTrnsParmVO.getFmOfcCd();
			String toOfcCd = ofcTrnsParmVO.getToOfcCd();
			String trnsRsn = ofcTrnsParmVO.getTrnsRsn();
			
			DmtOfcTrnsHisVO dmtOfcTrnsHisVO = new DmtOfcTrnsHisVO();
			dmtOfcTrnsHisVO.setFmOfcCd(fmOfcCd);
			dmtOfcTrnsHisVO.setToOfcCd(toOfcCd);
			dmtOfcTrnsHisVO.setTrnsRsn(trnsRsn);
			dmtOfcTrnsHisVO.setCreUsrId(account.getUsr_id());
			dmtOfcTrnsHisVO.setCreOfcCd(account.getOfc_cd());
			
			// 동일 RHQ Office: "N", 다른 RHQ Office: "Y"
			String rhqChkFlg = dbDao.searchOfficeTransferToServerID(fmOfcCd, toOfcCd);
			
			/*
			String svrFlag = "Y";
			if(fmSvrId.equals(toSvrId)) {
				svrFlag = "N";
			}*/
			/*else {
				if( (fmSvrId.equals("KOR") || fmSvrId.equals("CHN")) && (toSvrId.equals("KOR") || toSvrId.equals("CHN")) )
					svrFlag = "N";
			}*/
			
			String updOfc =  account.getOfc_cd();
			
			/* 타지역으로의 Office Transfer 가능한 Office 체크 */
			
			// 변경내용 : SELOPB 에서 SELCON 으로 변경 // 변경자 : jameskai // 변경일시 : 2018. 04. 30 
			if(rhqChkFlg.equals("Y") && !(
						updOfc.equals("HAMRU")	|| updOfc.equals("HAMRUO")
					||	updOfc.equals("NYCRA")	|| updOfc.equals("NYCRAO")
					||	updOfc.equals("SHARC")	|| updOfc.equals("SHARCO")
					||	updOfc.equals("SELCON") || updOfc.equals("SINRSO")
					||	updOfc.equals("SELSC")  || updOfc.equals("SELBO")
					||	updOfc.equals("TYOSC")  || updOfc.equals("TYOBBO")
					||	updOfc.equals("SINRS")	)) {
				result[0] = "DMT01009";
				return result;
			}

			for(int i=0; i < officeTransferParmVOs.length; i++) {
				ofcTrnsParmVO = officeTransferParmVOs[i];
				//ofcTrnsParmVO.setToSvrId(toSvrId);
				
				if(rhqChkFlg.equals("Y") && ofcTrnsParmVO.getDmdtChgStsCd().equals("L")) {
					result[0] = "DMT01010";
					return result;
				}
				
				ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
				chargeArgumentVO.setSvrId(ofcTrnsParmVO.getSvrId());
				chargeArgumentVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
				chargeArgumentVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
				chargeArgumentVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
				chargeArgumentVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
				chargeArgumentVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
				chargeArgumentVO.setOfcCd(account.getOfc_cd());
				
				int gapDate = dbDao.getFinishedGapDate(chargeArgumentVO);
			
				// 변경내용 : SELOPB 에서 SELCON 으로 변경 // 변경자 : jameskai // 변경일시 : 2018. 04. 30 
				if(gapDate > 30 && ofcTrnsParmVO.getDmdtChgStsCd().equals("F") &&
							!(	updOfc.equals("HAMRU")	|| updOfc.equals("HAMRUO")
							||	updOfc.equals("NYCRA")	|| updOfc.equals("NYCRAO")
							||	updOfc.equals("SHARC")	|| updOfc.equals("SHARCO")
							||	updOfc.equals("SELCON") || updOfc.equals("SINRSO")
							||	updOfc.equals("SELSC")  || updOfc.equals("SELBO")
							||	updOfc.equals("TYOSC")  || updOfc.equals("TYOBBO")
							||	updOfc.equals("SINRS")	)) {
					
					result[0] = "DMT01011";
					result[1] = ofcTrnsParmVO.getCntrNo();
					return result;
				}
				
				int ofcTrnsMaxSeq = dbDao.searchOfficeTransferMaxSEQ(chargeArgumentVO);
				
				dmtOfcTrnsHisVO.setSvrId(ofcTrnsParmVO.getSvrId());
				dmtOfcTrnsHisVO.setCntrNo(ofcTrnsParmVO.getCntrNo());
				dmtOfcTrnsHisVO.setCntrCycNo(ofcTrnsParmVO.getCntrCycNo());
				dmtOfcTrnsHisVO.setDmdtTrfCd(ofcTrnsParmVO.getDmdtTrfCd());
				dmtOfcTrnsHisVO.setDmdtChgLocDivCd(ofcTrnsParmVO.getDmdtChgLocDivCd());
				dmtOfcTrnsHisVO.setChgSeq(ofcTrnsParmVO.getChgSeq());
				dmtOfcTrnsHisVO.setOfcTrnsSeq(String.valueOf(ofcTrnsMaxSeq+1));
				
				dbDao.addOfficeTransferHistory(dmtOfcTrnsHisVO);
			}
			
			result[1] = rhqChkFlg;
			return result;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
	}
	
	
	/**
	 * Container별 Office Transfer History 정보를 조회한다.<br>
	 * 
	 * @param OfficeTransferParmVO officeTransferParmVO
	 * @return List<OfficeTransferHistoryByContainerVO>
	 * @exception EventException
	 */
	public List<OfficeTransferHistoryByContainerVO> searchOfficeTransferHistoryListByContainer(OfficeTransferParmVO officeTransferParmVO) throws EventException {
		
		try {
			return dbDao.searchOfficeTransferHistoryListByContainer(officeTransferParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Office Transfer History"}).getMessage());
		}
	}
	
	
	/**
	 * Office Transfer된 Charge를 Partial 하는 경우, 새로 생성되는 Charge의 Office Transfer Flag는 "Y"가 되며,
	 * Office Transfer History도 생성되도록 한다.
	 * 
	 * @param	ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param	SignOnUserAccount account
	 * @return	DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createOfficeTransferHistoryByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException {
		try {
			DmtResultVO resultVO = new DmtResultVO();
			
			DmtOfcTrnsHisVO dmtOfcTrnsHisVO = new DmtOfcTrnsHisVO();
			//DmtOfcTrnsHisVO tmpDmtOfcTrnsHisVO = null;
			String orgChgSeq = null;
			
			// 동일 RHQ Office: "N", 다른 RHQ Office: "Y"
			//String rhqChkFlg = dbDao.searchOfficeTransferToServerID(fmOfcCd, toOfcCd);
			
			for(int i=0; i < chargeCalculationContainerVOs.length; i++) {
				
				ChargeCalculationContainerVO chgCalcCntrVO = chargeCalculationContainerVOs[i];
				
				// OFC_TRNS_FLG 필드값이 "Y"가 아닌 것은 Skip
				if( !"Y".equals(chgCalcCntrVO.getOfcTrnsFlg()) ) {
					continue;
				}
				
				dmtOfcTrnsHisVO.setCntrNo(chgCalcCntrVO.getCntrNo());
				dmtOfcTrnsHisVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
				dmtOfcTrnsHisVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
				dmtOfcTrnsHisVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
				dmtOfcTrnsHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				
				
				String chkVal = dbDao.checkOfficeTransferHistoryByPartialPayment(dmtOfcTrnsHisVO);
				
				// 해당 Charge에 대한 DMT_OFC_TRNS_HIS 테이블에 데이터가 존재하면 SKIP
				if(chkVal.equals("Y")) {
					//if(tmpDmtOfcTrnsHisVO == null)
					orgChgSeq = dmtOfcTrnsHisVO.getChgSeq();
					
					continue;
				}
				
				
				//dmtOfcTrnsHisVO.setChgSeq(chgCalcCntrVO.getChgSeq());
				dmtOfcTrnsHisVO.setOrgChgSeq(orgChgSeq);
				
				dbDao.addOfficeTransferHistoryByPartialPayment(dmtOfcTrnsHisVO);
			} // for - end
			
			//result[1] = rhqChkFlg;
			return resultVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("DMT00003", new String[]{"Office Transfer Charge"}).getMessage());
		}
	}
	
	
}