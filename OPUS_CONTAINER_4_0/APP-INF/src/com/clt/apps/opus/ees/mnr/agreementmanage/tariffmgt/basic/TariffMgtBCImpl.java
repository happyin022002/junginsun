/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtBCImpl.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBackEndJob;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration.TariffMgtDBDAO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfDtlVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrDispTrfInQueryVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfDtlVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomMnrRprTrfHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.CustomTariffApprovalVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtListVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AgreementManage Business Logic Basic Command implementation<br>
 * - COM-AgreementManage disposing business logic<br>
 *
 * @author 
 * @see 	ees_mnr_0188EventResponse, TariffMgtBC, DAO Class
 * @since J2EE 1.6
 */
public class TariffMgtBCImpl extends BasicCommandSupport implements TariffMgtBC {

	// Database Access Object
	private transient TariffMgtDBDAO dbDao = null;

	/**
	 * Constructor
	 */
	public TariffMgtBCImpl() {
		dbDao = new TariffMgtDBDAO();
	}

	/**
	 * [EES_MNR_0188]Retrieving "M&R Tariff No Inquiry_Pop Up" data<br>
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
	 * [EES_MNR_0015]Retrieving "M&R Tariff No Combo List" data<br>
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
	 * [EES_MNR_0215]Retrieving "Tariff Detail Information_Pop_Up" data<br>
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
	 * [EES_MNR_0014]Adding, modifying, deleting "M&R Standard Tariff Creation & Inquiry" data<br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO manageRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Setting header
			List<CustomMnrRprTrfHdrVO> insertHdrVo = new ArrayList<CustomMnrRprTrfHdrVO>();

			String mnrTrfKndCd	= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getMnrTrfKndCd();
			String paramTrfNo	= repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getTrfNo();
			
			if(paramTrfNo.equals("NEW")) {
				String effDt   = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEffDt();
				String eqKndCd = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEqKndCd();
				String eqKndNm = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getEqKndNm();
				String vndrSeq = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getVndrSeq();
				
				int cnt = dbDao.checkRepairTariffHeaderData(effDt, eqKndCd, mnrTrfKndCd, vndrSeq);
				
				if(cnt>0) {
					if(mnrTrfKndCd.equals("STD")) {
						throw new EventException(new ErrorHandler("MNR00178",new String[]{"EQ Type:"+eqKndNm+" "," Eff.from:"+effDt+" "}).getMessage());
					} else {
						throw new EventException(new ErrorHandler("MNR00178",new String[]{"EQ Type:"+eqKndNm+",  S/Provider Code:"+vndrSeq," Eff.from:"+effDt+" "}).getMessage());
					}
				}

				//Retrieving created tariff number
				paramTrfNo  = dbDao.searchRepairTariffNoData(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getPreTrfNo());
				repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setTrfNo(paramTrfNo);
			}
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setStsRefNo("0");
			String mnrInpTpCd = repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().getMnrInpTpCd();
			if(mnrInpTpCd.equals("") || mnrInpTpCd==null) {
				mnrInpTpCd = "M";
			}	
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setMnrInpTpCd(mnrInpTpCd);
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setRqstOfcCd(account.getOfc_cd());
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setCreUsrId(account.getUsr_id());
			repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO().setUpdUsrId(account.getUsr_id());
			insertHdrVo.add(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO());


			//Setting detail
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
					repairTariffMgtGRPVO.getArrayCustomMnrRprTrfDtlVOs()[i].setTempSeq((i+1)+"");
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
	 * [EES_MNR_0154]Retrieving "Disposal Tariff by Region" data<br>
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
	 * [EES_MNR_0232]Retrieving "Disposal Tariff by Region" data<br>
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
	 * [EES_MNR_0154]Retrieving "Disposal Tariff by Region" data<br>
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
	 * [EES_MNR_0232]Retrieving "Disposal Tariff by Region" data<br>
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
	 * [EES_MNR_0154]Adding, modifying, deleting "Disposal Tariff by Region" data<br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO manageDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException{
		try {
			//Setting header
			List<CustomMnrDispTrfHdrVO> insertHdrVo = new ArrayList<CustomMnrDispTrfHdrVO>();

			//Setting detail
			List<CustomMnrDispTrfDtlVO> insertDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();
			List<CustomMnrDispTrfDtlVO> updateDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();
			List<CustomMnrDispTrfDtlVO> deleteDtlVoList = new ArrayList<CustomMnrDispTrfDtlVO>();

			String mnrDispTrfSeq    = disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfSeq();
			String mnrDispTrfStsCd  = disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfStsCd();
			String newMnrDispTrfSeq	= "";
			
			if(mnrDispTrfStsCd.equalsIgnoreCase("D"))
			{
				if(!"".equals(mnrDispTrfSeq))
				{
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
				//Checking duplicate data of Eff.from, EQ Type, Tariff Price Type
				String effDt 		= disposalTariffGRPVO.getDisposalTariffINVO().getEffDt();
				String eqKndCd		= disposalTariffGRPVO.getDisposalTariffINVO().getEqKndCd();
				String mnrDispTrfKndCd	= disposalTariffGRPVO.getDisposalTariffINVO().getMnrDispTrfTpCd();
				int cnt			= dbDao.checkDisposalTariffHeaderData(effDt, eqKndCd, mnrDispTrfKndCd);
				if(cnt<=0) {
				    //Retrieving newly created "disposal tariff sequence"
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

				//Returning Tariff No after saving
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
	 * [EES_MNR_0011]Retrieving "M&R Local Tariff Creation & Verify" data<br>
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
	 * [EES_MNR_0171]Retrieving "M&R Tariff Inquiry" data<br>
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
	 * [EES_MNR_0154]Retrieving quarterly price information<br>
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
	 * [EES_MNR_0154]Modifying quarterly price information<br>
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
					//Saving In Case of not existing data
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
	 * [EES_MNR_0154]Modifying batch quarterly price information<br>
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
	 * Retrieving BackEndJob result<br>
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
	 * [EES_MNR_0232]Retrieving quarterly and regional price information<br>
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