/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtBCImpl.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBackEndJob;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration.TariffMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfDtlVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfInQueryVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfDtlVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.CustomTariffApprovalVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtListVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-AgreementManage Business Logic Basic Command implementation<br>
 * - alps-AgreementManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author WanGyu Kim
 * @see ees_mnr_0188EventResponse,TariffMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class TariffMgtBCImpl extends BasicCommandSupport implements TariffMgtBC {

	// Database Access Object
	private transient TariffMgtDBDAO dbDao = null;

	/**
	 * TariffMgtBCImpl 객체 생성<br>
	 * TariffMgtDBDAO를 생성한다.<br>
	 */
	public TariffMgtBCImpl() {
		dbDao = new TariffMgtDBDAO();
	}

	/**
	 * [EES_MNR_0188]M&R Tariff No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffPopUpListBasic(TariffPopupGRPVO tariffPopupGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs = dbDao.searchRepairTariffPopUpListData(tariffPopupGRPVO.getTariffPopupINVO(),account);
			tariffPopupGRPVO.setCustomMnrRprTrfHdrVOs(customMnrRprTrfHdrVOs);
			return tariffPopupGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Tariff No Inquiry_Pop Up] searchRepairTariffPopUpListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Tariff No Inquiry_Pop Up] searchRepairTariffPopUpListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0015]M&R Tariff No Combolist의 정보를 조회 합니다. <br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffComboListBasic(TariffPopupGRPVO tariffPopupGRPVO) throws EventException {
		try {
			List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs = dbDao.searchRepairTariffComboListData(tariffPopupGRPVO.getTariffPopupINVO());
			tariffPopupGRPVO.setCustomMnrRprTrfHdrVOs(customMnrRprTrfHdrVOs);
			return tariffPopupGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] searchRepairTariffComboListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] searchRepairTariffComboListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0215]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO, SignOnUserAccount account) throws EventException {
		try {
            //Header Search
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setOfcCd(account.getOfc_cd());  //parameter for LocalTime
			List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs = dbDao.searchRepairTariffHeaderData(repairTariffMgtGRPVO.getRepairTariffMgtINVO(), account);
			repairTariffMgtGRPVO.setCustomMnrRprTrfHdrVOs(customMnrRprTrfHdrVOs);

            //Detail Search
			List<List<CustomMnrRprTrfDtlVO>> listCustomMnrRprTrfDtlVOs = new ArrayList<List<CustomMnrRprTrfDtlVO>>();
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRDR");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO0 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRRF");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO1 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRRU");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO2 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRDS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO3 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRZS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO4 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRGS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO5 = dbDao.searchRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());

			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO0);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO1);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO2);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO3);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO4);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO5);

			repairTariffMgtGRPVO.setListCustomMnrRprTrfDtlVOs(listCustomMnrRprTrfDtlVOs);

			return repairTariffMgtGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tariff Detail Information_Pop_Up] searchRepairTariffBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Tariff Detail Information_Pop_Up] searchRepairTariffBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO manageRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Header 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrRprTrfHdrVO> insertHdrVo = new ArrayList<CustomMnrRprTrfHdrVO>();

			String mnrTrfKndCd	= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getMnrTrfKndCd();
			String paramTrfNo	= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getTrfNo();
			if(paramTrfNo.equals("NEW")) {
				//Eff.from, EQ Type 중복체크
				String effDt 		= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEffDt();
				String eqKndCd		= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEqKndCd();
				String eqKndNm		= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEqKndNm();
				String vndrSeq		= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getVndrSeq();
				int cnt			= dbDao.checkRepairTariffHeaderData(effDt, eqKndCd, mnrTrfKndCd, vndrSeq);
				if(cnt>0) {
					if(mnrTrfKndCd.equals("STD")) {
						throw new EventException(new ErrorHandler("MNR00178",new String[]{"EQ Type:"+eqKndNm+" "," Eff.from:"+effDt+" "}).getMessage());
					} else {
						throw new EventException(new ErrorHandler("MNR00178",new String[]{"EQ Type:"+eqKndNm+",  S/Provider Code:"+vndrSeq," Eff.from:"+effDt+" "}).getMessage());
					}
				}

				//Tariff No 생성 조회
				paramTrfNo  = dbDao.searchRepairTariffNoData(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getPreTrfNo());
				repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setTrfNo(paramTrfNo);
			}
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setStsRefNo("0");
			String mnrInpTpCd = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getMnrInpTpCd();
			if(mnrInpTpCd.equals("") || mnrInpTpCd==null) {
				if(account.getAccess_system().equals("ALP")){	//ALPS
					mnrInpTpCd = "M";
				} else { 										//SPP
					mnrInpTpCd = "W";
				}
			}
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setMnrInpTpCd(mnrInpTpCd);
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setRqstOfcCd(account.getOfc_cd());
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setCreUsrId(account.getUsr_id());
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setUpdUsrId(account.getUsr_id());
			insertHdrVo.add(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO());


			//Detail 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrRprTrfDtlVO> insertDtlVoList = new ArrayList<CustomMnrRprTrfDtlVO>();
			List<CustomMnrRprTrfDtlVO> updateDtlVoList = new ArrayList<CustomMnrRprTrfDtlVO>();
			List<CustomMnrRprTrfDtlVO> deleteDtlVoList = new ArrayList<CustomMnrRprTrfDtlVO>();
			for ( int i=0; i<repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs().length; i++ ) {
				if ( repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].getIbflag().equals("U")){
					repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i]);
				}
				else if ( repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].getIbflag().equals("I")){
					repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setTrfNo(paramTrfNo);
					//2010-03-24:Local Tariff 도 Verify 추가함에 따라 Tariff Detail Sequence 를 모두 새로 채번함.
					//if(mnrTrfKndCd.equals("STD")) {
						repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setTempSeq((i+1)+"");
					//} else {
						//repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setTempSeq(0+"");
					//}
					repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setCreUsrId(account.getUsr_id());
					repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i]);
				}
				else if ( repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].getIbflag().equals("D")){
					deleteDtlVoList.add(repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i]);
				}
			}

			//Header
			dbDao.removeRepairTariffHeaderData(insertHdrVo);
			dbDao.addRepairTariffHeaderData(insertHdrVo);

			//Detail
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addRepairTariffDetailData(insertDtlVoList);
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyRepairTariffDetailData(updateDtlVoList);
			}
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeRepairTariffDetailData(deleteDtlVoList);
			}

			return repairTariffMgtGRPVO;

		} catch (EventException e){
		    log.error("err " + e.toString(), e);
			throw e;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Standard Tariff Creation & Inquiry] manageRepairTariffBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Standard Tariff Creation & Inquiry] manageRepairTariffBasic"}).getMessage(),de);
		}
	}


	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException {
		try {
            //Header Search
			List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs = dbDao.searchDisposalTariffHeaderData(disposalTariffGRPVO.getDisposalTariffINVO());

			if(customMnrDispTrfHdrVOs.size() ==1)
			{
				disposalTariffGRPVO.setCustomMnrDispTrfHdrVOs(customMnrDispTrfHdrVOs);
				disposalTariffGRPVO.getDisposalTariffINVO().setMnrDispTrfSeq(customMnrDispTrfHdrVOs.get(0).getMnrDispTrfSeq());

			}else if(customMnrDispTrfHdrVOs.size() > 1)
			{
				disposalTariffGRPVO.setCustomMnrDispTrfHdrVOs(customMnrDispTrfHdrVOs);
				disposalTariffGRPVO.getDisposalTariffINVO().setMnrDispTrfSeq("");

			}
		    //Detail Search
			List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs = dbDao.searchDisposalTariffDetailData(disposalTariffGRPVO.getDisposalTariffINVO());
			disposalTariffGRPVO.setCustomMnrDispTrfDtlVOs(customMnrDispTrfDtlVOs);

			return disposalTariffGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffInqueryListBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//Inquery Search
			List<CustomMnrDispTrfInQueryVO> customMnrDispTrfInQueryVOS = dbDao.searchDisposalTariffInqueryListData(disposalTariffGRPVO.getDisposalTariffINVO());
			disposalTariffGRPVO.setCustomMnrDispTrfInQueryVOs(customMnrDispTrfInQueryVOS);
			return disposalTariffGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffInqueryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffInqueryListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO, SignOnUserAccount account) throws EventException {
		try {
            //Header Search
			List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs = dbDao.searchDisposalTariffEffDtListData(disposalTariffEffDtGRPVO.getDisposalTariffEffDtINVO());
			disposalTariffEffDtGRPVO.setDisposalTariffEffDtListVOs(disposalTariffEffDtListVOs);

			return disposalTariffEffDtGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffEffDtListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffEffDtListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffInqueryEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO, SignOnUserAccount account) throws EventException {
		try {
			//Header Search
			List<DisposalTariffEffDtListVO> disposalTariffEffDtListVOs = dbDao.searchDisposalTariffInqueryEffDtListData(disposalTariffEffDtGRPVO.getDisposalTariffEffDtINVO());
			disposalTariffEffDtGRPVO.setDisposalTariffEffDtListVOs(disposalTariffEffDtListVOs);

			return disposalTariffEffDtGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffInqueryEffDtListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffInqueryEffDtListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO manageDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Header 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrDispTrfHdrVO> insertHdrVo = new ArrayList<CustomMnrDispTrfHdrVO>();

			//Detail 설정//////////////////////////////////////////////////////////////////////
			List<CustomMnrDispTrfDtlVO> insertDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();
			List<CustomMnrDispTrfDtlVO> updateDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();
			List<CustomMnrDispTrfDtlVO> deleteDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();

			String mnrDispTrfSeq	=disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfSeq();
			String mnrDispTrfStsCd	=disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfStsCd();
			String newMnrDispTrfSeq		= "";
			if(mnrDispTrfStsCd.equalsIgnoreCase("D"))
			{
				//2011.06.14 mnrDispTrfSeq != ""  -> mnrDispTrfSeq != null로 수정
				//문자열 비교는 문자열 비교 메소드를 사용해야 한다.
				if (!"".equals(mnrDispTrfSeq) && mnrDispTrfSeq != null ){
					CustomMnrDispTrfHdrVO customMnrDispTrfHdrVO=new CustomMnrDispTrfHdrVO();
					CustomMnrDispTrfDtlVO customMnrDispTrfDtlVO=new CustomMnrDispTrfDtlVO();
					customMnrDispTrfHdrVO.setMnrDispTrfSeq(mnrDispTrfSeq);
					customMnrDispTrfDtlVO.setMnrDispTrfSeq(mnrDispTrfSeq);
					insertHdrVo.add(0,customMnrDispTrfHdrVO);
					deleteDtlVoList.add(0,customMnrDispTrfDtlVO);
					dbDao.removeDisposalTariffHeaderData(insertHdrVo);
					dbDao.removeDisposalTariffDetailData(deleteDtlVoList);


				}

			}else{
				//Eff.from, EQ Type,Tarrif Price Type 중복체크
				String effDt 		= disposalTariffGRPVO.getDisposalTariffINVO().getEffDt();
				String eqKndCd		= disposalTariffGRPVO.getDisposalTariffINVO().getEqKndCd();
				String mnrDispTrfKndCd	= disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfTpCd();
				int cnt			= dbDao.checkDisposalTariffHeaderData(effDt, eqKndCd, mnrDispTrfKndCd);
				if(cnt<=0) {
				    //DisposalTariff Seq 생성 조회
				    newMnrDispTrfSeq  = dbDao.searchDisposalTariffSeqData();
				    disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setMnrDispTrfSeq(newMnrDispTrfSeq);
				}else{
				    disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setMnrDispTrfSeq(mnrDispTrfSeq);
				}

				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setCreOfcCd(account.getOfc_cd());
				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setCreUsrId(account.getUsr_id());
				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setUpdUsrId(account.getUsr_id());
				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setMnrDispTrfLstVerFlg(disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfLstVerFlg());
				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setMnrInpTpCd(disposalTariffGRPVO.getDisposalTariffINVO().getMnrInpTpCd());
				disposalTariffGRPVO.getCustomMnrDispTrfHdrVO().setMnrDispTrfStsCd(disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfStsCd());
				insertHdrVo.add(disposalTariffGRPVO.getCustomMnrDispTrfHdrVO());

				int addCnt=0;
				for ( int i=0; i<disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs().length; i++ )
				{
					if ( disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].getIbflag().equals("U")){
						disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setUpdUsrId(account.getUsr_id());
						updateDtlVoList.add(disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i]);
					}
					else if ( disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].getIbflag().equals("I")){
						if(cnt<=0) {
							disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setMnrDispTrfSeq(newMnrDispTrfSeq);
						}else{
							disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setMnrDispTrfSeq(mnrDispTrfSeq);
						}
						disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setTempSeq((addCnt)+1+"");
						disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setCreUsrId(account.getUsr_id());
						disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].setUpdUsrId(account.getUsr_id());
						insertDtlVoList.add(disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i]);
						addCnt++;
					}
					else if ( disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i].getIbflag().equals("D")){

						deleteDtlVoList.add(disposalTariffGRPVO.getArrayCustomMnrDispTrfDtlVOs()[i]);
					}
				}


				//Header
				if(cnt>0)
				{
				    dbDao.modifyDisposalTariffHeaderData(insertHdrVo);
				}else{
				    dbDao.addDisposalTariffHeaderData(insertHdrVo);
				}

				//Detail
				if ( insertDtlVoList.size() > 0 ) {
					dbDao.addDisposalTariffDetailData(insertDtlVoList);
				}
				if ( updateDtlVoList.size() > 0 ) {
					dbDao.modifyDisposalTariffDetailData(updateDtlVoList);
				}
				if ( deleteDtlVoList.size() > 0 ) {
					dbDao.removeDisposalTariffDetailData(deleteDtlVoList);
				}

				//저장후 Tariff No Return
				CustomMnrDispTrfHdrVO customMnrDispTrfHdrVO = disposalTariffGRPVO.getCustomMnrDispTrfHdrVO();
				List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs = new ArrayList<CustomMnrDispTrfHdrVO>();
				if(mnrDispTrfSeq.equals("")) {
					customMnrDispTrfHdrVO.setMnrDispTrfSeq(newMnrDispTrfSeq);
				} else {
					customMnrDispTrfHdrVO.setMnrDispTrfSeq(mnrDispTrfSeq);
				}
				customMnrDispTrfHdrVOs.add(disposalTariffGRPVO.getCustomMnrDispTrfHdrVO());
				disposalTariffGRPVO.setCustomMnrDispTrfHdrVOs(customMnrDispTrfHdrVOs);
			}
			return disposalTariffGRPVO;

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] manageDisposalTariffBasic"}).getMessage(),de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] manageDisposalTariffBasic"}).getMessage(),de);
		}
	}

	/**
	 * [EES_MNR_0011]M&R Local Tariff Creation & Verify의 정보를 조회 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchDefaultRepairTariffDetailBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO, SignOnUserAccount account) throws EventException {
		try {
            //Detail Search
			List<List<CustomMnrRprTrfDtlVO>> listCustomMnrRprTrfDtlVOs = new ArrayList<List<CustomMnrRprTrfDtlVO>>();
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRDR");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO0 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRRF");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO1 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRRU");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO2 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRDS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO3 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRZS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO4 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());
			repairTariffMgtGRPVO.getRepairTariffMgtINVO().setCostGrpCd("MRGS");
			List<CustomMnrRprTrfDtlVO> customMnrRprTrfDtlVO5 = dbDao.searchDefaultRepairTariffDetailData(repairTariffMgtGRPVO.getRepairTariffMgtINVO());

			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO0);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO1);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO2);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO3);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO4);
			listCustomMnrRprTrfDtlVOs.add(customMnrRprTrfDtlVO5);

			repairTariffMgtGRPVO.setListCustomMnrRprTrfDtlVOs(listCustomMnrRprTrfDtlVOs);

			return repairTariffMgtGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Local Tariff Creation & Verify] searchDefaultRepairTariffDetailBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Local Tariff Creation & Verify] searchDefaultRepairTariffDetailBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0171]M&R Tariff Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffApprovalGRPVO
	 * @exception EventException
	 */
	public TariffApprovalGRPVO searchRepairTariffApprovalListBasic(TariffApprovalGRPVO tariffApprovalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomTariffApprovalVO> customTariffApprovalVO = dbDao.searchRepairTariffApprovalListData(tariffApprovalGRPVO.getTariffApprovalINVO(),account);
			tariffApprovalGRPVO.setListCustomTariffApprovalVO(customTariffApprovalVO);
			return tariffApprovalGRPVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Tariff Inquiry] searchRepairTariffApprovalListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Tariff Inquiry] searchRepairTariffApprovalListBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0136]M&R Regional Tariff Approval의 정보를 수정 합니다. <br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRepairTariffStatusBasic(TariffApprovalGRPVO tariffApprovalGRPVO, SignOnUserAccount account) throws EventException {
		try {
			List<CustomTariffApprovalVO> updateVoList = new ArrayList<CustomTariffApprovalVO>();
			for ( int i=0; i<tariffApprovalGRPVO.getArrayCustomTariffApprovalVOs().length; i++ ) {
				if ( tariffApprovalGRPVO.getArrayCustomTariffApprovalVOs()[i].getIbflag().equals("U")){
					tariffApprovalGRPVO.getArrayCustomTariffApprovalVOs()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(tariffApprovalGRPVO.getArrayCustomTariffApprovalVOs()[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRepairTariffStatusData(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Regional Tariff Approval] modifyRepairTariffStatusBasic"}).getMessage(),ex);
		} catch (Exception e) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Regional Tariff Approval] modifyRepairTariffStatusBasic"}).getMessage(),e);
		}
	}

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param DisposalTariffRegionVO disposalTariffRegionVO
	 * @return List<DisposalTariffRegionVO>
	 * @exception EventException
	 */
	public List<DisposalTariffRegionVO> searchDisposalTariffRegionListBasic(DisposalTariffRegionVO disposalTariffRegionVO) throws EventException {
		List<DisposalTariffRegionVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchDisposalTariffRegionListData(disposalTariffRegionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffRegionListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] searchDisposalTariffRegionListBasic"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장합니다.<br>
	 *
	 * @param DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<DisposalTariffRegionVO> insertVoList = new ArrayList<DisposalTariffRegionVO>();
			List<DisposalTariffRegionVO> updateVoList = new ArrayList<DisposalTariffRegionVO>();
			List<DisposalTariffRegionVO> deleteVoList = new ArrayList<DisposalTariffRegionVO>();

			for(int i = 0, cnt = 0; i < disposalTariffRegionVOs.length; i++ ) {
				if(disposalTariffRegionVOs[i].getIbflag().equals("I")) {
					//기존 데이터 존재 여부에 따라 insert 여부 결정
					if(!dbDao.searchDisposalTariffRegionExistData(disposalTariffRegionVOs[i])) {
						disposalTariffRegionVOs[i].setCreOfcCd(userAccount.getOfc_cd());
						disposalTariffRegionVOs[i].setCreUsrId(userAccount.getUsr_id());
						disposalTariffRegionVOs[i].setInsertSeq(String.valueOf(cnt++));
						insertVoList.add(disposalTariffRegionVOs[i]);
					}
				} else if(disposalTariffRegionVOs[i].getIbflag().equals("U")) {
					disposalTariffRegionVOs[i].setUpdUsrId(userAccount.getUsr_id());
					updateVoList.add(disposalTariffRegionVOs[i]);
				} else if(disposalTariffRegionVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(disposalTariffRegionVOs[i]);
				}
			}

			if(insertVoList.size() > 0) {
				dbDao.addDisposalTariffRegionListData(insertVoList);
			}
			if(updateVoList.size() > 0) {
				dbDao.modifyDisposalTariffRegionListData(updateVoList);
			}
			if(deleteVoList.size() > 0) {
				dbDao.removeDisposalTariffRegionListData(deleteVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] manageDisposalTariffRegionListBasic"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff by Region] manageDisposalTariffRegionListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장합니다.<br>
	 *
	 * @param  DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException {
		TariffMgtBackEndJob backEndJob = new TariffMgtBackEndJob();
		backEndJob.setJobType("manageDisposalTariffRegionList");
		backEndJob.setDisposalTariffRegionVOs(disposalTariffRegionVOs);
		backEndJob.setUserAccount(userAccount);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, userAccount.getUsr_id(), "manageDisposalTariffRegionList BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"manageDisposalTariffRegionList BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * [EES_MNR_0232] 분기별 지역별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param DisposalTariffQuarterVO disposalTariffQuarterVO
	 * @return DisposalTariffQuarterGRPVO
	 * @exception EventException
	 */
	public DisposalTariffQuarterGRPVO searchDisposalTariffQuarterListBasic(DisposalTariffQuarterVO disposalTariffQuarterVO) throws EventException {
		DisposalTariffQuarterGRPVO resultVO = new DisposalTariffQuarterGRPVO();
		List<List<DisposalTariffQuarterVO>> disposalTariffQuarterVOs = new ArrayList<List<DisposalTariffQuarterVO>>();
		List<DisposalTariffQuarterVO> resultVOs = null;
		DisposalTariffQuarterVO tempVO = null;

		try {
			resultVOs = dbDao.searchDisposalTariffQuarterListData(disposalTariffQuarterVO);
			List<DisposalTariffQuarterVO> rsQtr1VOs = new ArrayList<DisposalTariffQuarterVO>();
			List<DisposalTariffQuarterVO> rsQtr2VOs = new ArrayList<DisposalTariffQuarterVO>();
			List<DisposalTariffQuarterVO> rsQtr3VOs = new ArrayList<DisposalTariffQuarterVO>();
			List<DisposalTariffQuarterVO> rsQtr4VOs = new ArrayList<DisposalTariffQuarterVO>();
			List<DisposalTariffQuarterVO> rsQtr5VOs = new ArrayList<DisposalTariffQuarterVO>();

			for(int i = 0 ; i < resultVOs.size() ; i++){
				tempVO = resultVOs.get(i);
				String trfEffQtr = tempVO.getTrfEffQtrNo();
				if("1".equals(trfEffQtr)) {
					rsQtr1VOs.add(tempVO);
				} else if("2".equals(trfEffQtr)) {
					rsQtr2VOs.add(tempVO);
				} else if("3".equals(trfEffQtr)) {
					rsQtr3VOs.add(tempVO);
				} else if("4".equals(trfEffQtr)) {
					rsQtr4VOs.add(tempVO);
				}

				rsQtr5VOs.add(tempVO);
			}

			disposalTariffQuarterVOs.add(rsQtr1VOs);
			disposalTariffQuarterVOs.add(rsQtr2VOs);
			disposalTariffQuarterVOs.add(rsQtr3VOs);
			disposalTariffQuarterVOs.add(rsQtr4VOs);
			disposalTariffQuarterVOs.add(rsQtr5VOs);

			if(disposalTariffQuarterVOs.size() < 1 ) {
				new EventException(new ErrorHandler("MNR00001",new String[]{"User Information"}).getMessage());
			}

			resultVO.setDisposalTariffQuarterVOs(disposalTariffQuarterVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff Inquiry] searchDisposalTariffQuarterListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Tariff Inquiry] searchDisposalTariffQuarterListBasic"}).getMessage(),ex);
		}

		return resultVO;
	}
}