/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CndManifestListDownloadBackEndJob.java
 *@FileTitle : CndManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
 * 
 * 2011.08.02 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration.CndManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBackEndJob;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCntrMfVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvMkDescVO;
import com.hanjin.syscommon.common.table.BkgCstmsSealNoVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min Jeong
 * @see CndManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CndManifestListDownloadBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestListDetailVO[] manifestListDetailVOs;
	private SignOnUserAccount account;
	private CndManifestListDownloadDBDAO dbDao;

	/**
	 * BackEndCommand Start
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		//Manifest Download
		manageManifest();
		return null;
	}
	
	/**
	 * Manifest Download 
	 * @return String
	 * @throws EventException
	 */
	public String manageManifest() throws EventException {
		
		String result = "SUCCESS";
		String sVslCd = "";
		String sSkdVoyNo = "";
		String sSkdDirCd = "";
		String sPodCd = "";
		String sPolCd = "";
		try 
		{
			/**************************************************
			 * 2010.01.07 추가<br>
			 * POD가 CANADA, DEL이 US PORT의 경우 US로 다운로드<BR>
			 * 미세관 수신때 정보를 UPDATE하고 위함<bR>
			 * VVD가 US를 지나는 경우만 처리
			 **************************************************/
			int iUsCnt = 0;
			for (int i = 0; i < manifestListDetailVOs.length; i++)
			{
				CndManifestModificationVO paramVO = (CndManifestModificationVO) manifestListDetailVOs[i];
				if (i == 0)
				{
					sVslCd = paramVO.getVslCd();
					sSkdVoyNo = paramVO.getSkdVoyNo();
					sSkdDirCd = paramVO.getSkdDirCd();
					sPodCd = paramVO.getPodCd();
					sPolCd = paramVO.getPolCd();
				}
				if (paramVO.getBkgPodCd().startsWith("CA") && paramVO.getBkgDelCd().startsWith("US"))
				{
					iUsCnt++;
				}
			}
			// US Port를 지나지 않는 Vessel에 대해서만 다운로드한다.
			if (!dbDao.checkUsPort(sVslCd, sSkdVoyNo, sSkdDirCd))
			{
				UsaManifestListDetailVO[] usaManifestListDetailVO = new UsaManifestListDetailVO[iUsCnt];
				iUsCnt = 0;
				for (int i = 0; i < manifestListDetailVOs.length; i++)
				{
					CndManifestModificationVO paramVO = (CndManifestModificationVO) manifestListDetailVOs[i];
					if (paramVO.getBkgPodCd().startsWith("CA") && paramVO.getBkgDelCd().startsWith("US"))
					{
						usaManifestListDetailVO[iUsCnt] = new UsaManifestListDetailVO();
						usaManifestListDetailVO[iUsCnt].setBlNos(paramVO.getBlNos());
						usaManifestListDetailVO[iUsCnt].setBkgNo(paramVO.getBkgNo());
						usaManifestListDetailVO[iUsCnt].setBlType(paramVO.getBlType());
						usaManifestListDetailVO[iUsCnt].setVslCd(sVslCd);
						usaManifestListDetailVO[iUsCnt].setSkdVoyNo(sSkdVoyNo);
						usaManifestListDetailVO[iUsCnt].setSkdDirCd(sSkdDirCd);
						usaManifestListDetailVO[iUsCnt].setPodCd(sPodCd);
						usaManifestListDetailVO[iUsCnt].setPolCd(sPolCd);
						usaManifestListDetailVO[iUsCnt].setVPod(sPodCd);
						iUsCnt++;
					}
				}
				if (iUsCnt > 0)
				{
					UsaManifestListDownloadBackEndJob usaBackEnd = new UsaManifestListDownloadBackEndJob();
					UsaManifestListDownloadDBDAO usaDbDao = new UsaManifestListDownloadDBDAO();
					usaBackEnd.setManifestListDetailVO(usaManifestListDetailVO, account, usaDbDao);
					usaBackEnd.manageManifest(usaManifestListDetailVO);
				}
			}
			// END US 추가분
			
			for (int i = 0; i < manifestListDetailVOs.length; i++)
			{
				CndManifestModificationVO paramVO = (CndManifestModificationVO) manifestListDetailVOs[i];
//				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
//				if ("M".equals(paramVO.getBlType()))
//				{
//					/*****************************************
//					 * Master B/L 조회
//					 *****************************************/
//					bkgCstmsAdvBlVO = dbDao.searchBkgBookingMaster(paramVO.getBkgNo(), sVslCd, sSkdVoyNo, sSkdDirCd);
//				}
//				else
//				{
//					/*****************************************
//					 * House B/L 조회
//					 *****************************************/
//					bkgCstmsAdvBlVO = dbDao.searchBkgBookingHBl(paramVO.getBkgNo(), paramVO.getBlNos(), sVslCd,
//							sSkdVoyNo, sSkdDirCd);
//				}
//				if (bkgCstmsAdvBlVO == null)
//				{
//					String[] arrErr = new String[1];
//					arrErr[0] = "No Data B/L";
//					throw new EventException(new ErrorHandler("BKG00628", arrErr).getMessage());
//				}
				
				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = new BkgCstmsAdvBlVO();				
				bkgCstmsAdvBlVO.setUpdUsrId("TempUser");
				
				if ("M".equals(paramVO.getBlType()))
				{
					/*****************************************
					 * Master B/L 조회
					 *****************************************/
					bkgCstmsAdvBlVO = dbDao.searchBkgBookingMaster(paramVO.getBkgNo(), sVslCd, sSkdVoyNo, sSkdDirCd);
				}
				else
				{
					/*****************************************
					 * House B/L 조회
					 *****************************************/
					bkgCstmsAdvBlVO = dbDao.searchBkgBookingHBl(paramVO.getBkgNo(), paramVO.getBlNos(), sVslCd,
							sSkdVoyNo, sSkdDirCd);
				}
				if("TempUser".equals(bkgCstmsAdvBlVO.getUpdUsrId())){
					String[] arrErr = new String[1];
					arrErr[0] = "No Data B/L";
					throw new EventException(new ErrorHandler("BKG00628", arrErr).getMessage());					
				}
				
				
				/**************************************************
				 * BDR 이후 변경된 건에 대한 조회
				 **************************************************/
				/* ============================================================= */
				/* [TO-BE] 2009.12.11 LeeSubin:                                  */
				/* C/A Report(I/B) 화면에서 다운로드 호출 시                                                                */
				/* 넘겨받은 CA_NO, CA_ISS_DT 데이터를 BL 테이블에 저장				 */
				/* ============================================================= */
				BkgCstmsAdvBlVO bkgCorrectionVO = null;
				if(paramVO.getCaNo() != null || !"".equals(paramVO.getCaNo()))
				{
					bkgCstmsAdvBlVO.setCaFlg("Y");
					bkgCstmsAdvBlVO.setCaNo(paramVO.getCaNo());
					bkgCstmsAdvBlVO.setCaIssDt(paramVO.getCaIssDt());
				}
				else
				{
					bkgCorrectionVO = dbDao.searchBkgCorrection(paramVO.getBkgNo());
					if (bkgCorrectionVO != null)
					{
						bkgCstmsAdvBlVO.setCaFlg("Y");
						bkgCstmsAdvBlVO.setCaNo(bkgCorrectionVO.getCaNo());
						bkgCstmsAdvBlVO.setCaIssDt(bkgCorrectionVO.getCaIssDt());
					}
				}
				if ("Y".equals(bkgCstmsAdvBlVO.getBdrFlg()))
				{
					bkgCstmsAdvBlVO.setBdrIfUsrId(account.getUsr_id());
					bkgCstmsAdvBlVO.setBdrIfDt(DateTime.getFormatString("yyyyMMddHHmmss"));
					bkgCstmsAdvBlVO.setBdrOfcCd(account.getOfc_cd());
				}
				/*****************************************
				 * BL DELETE Start
				 *****************************************/
				CndCstmsBlCondVO cndCstmsBlCondVO = new CndCstmsBlCondVO();
				cndCstmsBlCondVO.setBlNo(paramVO.getBlNos());

				BkgCstmsAdvMkDescVO bkgCstmsAdvMkDesc = new BkgCstmsAdvMkDescVO();
				bkgCstmsAdvMkDesc.setCntCd(CountryCode.CA);
				bkgCstmsAdvMkDesc.setBlNo(cndCstmsBlCondVO.getBlNo());
				dbDao.removeBkgCstmsAdvMkDesc(bkgCstmsAdvMkDesc);
				BkgCstmsAdvCntrMfVO bkgCstmsAdvCntrMf = new BkgCstmsAdvCntrMfVO();
				bkgCstmsAdvCntrMf.setCntCd(CountryCode.CA);
				bkgCstmsAdvCntrMf.setBlNo(cndCstmsBlCondVO.getBlNo());
				dbDao.removeBkgCstmsAdvCntrMf(bkgCstmsAdvCntrMf);
				BkgCstmsSealNoVO bkgCstmsSealNoVO = new BkgCstmsSealNoVO();
				bkgCstmsSealNoVO.setCntCd(CountryCode.CA);
				bkgCstmsSealNoVO.setBlNo(cndCstmsBlCondVO.getBlNo());
				dbDao.removeBkgCstmsSealNo(bkgCstmsSealNoVO);
				
				//Canada B/L Download 시 BKG_CSTMS_ADV_CNTR 테이블의 RAIL_CRR_REF_NO, USA_IB_TRSP_NO 2개 칼럼 기존 데이터 유지
				List<BkgCstmsAdvCntrVO> bkgCstmsAdvCntrVOs = null;
				BkgCstmsAdvCntrVO bkgCstmsAdvCntr = new BkgCstmsAdvCntrVO();
				bkgCstmsAdvCntr.setCntCd(CountryCode.CA);
				bkgCstmsAdvCntr.setBlNo(cndCstmsBlCondVO.getBlNo());
				bkgCstmsAdvCntrVOs = dbDao.searchBkgCstmsAdvCntr(bkgCstmsAdvCntr);
				dbDao.removeBkgCstmsAdvCntr(bkgCstmsAdvCntr);
				BkgCstmsAdvCustVO bkgCstmsAdvCust = new BkgCstmsAdvCustVO();
				bkgCstmsAdvCust.setCntCd(CountryCode.CA);
				bkgCstmsAdvCust.setBlNo(cndCstmsBlCondVO.getBlNo());
				dbDao.removeBkgCstmsAdvCust(bkgCstmsAdvCust);
				/*****************************************
				 * BL DELETE End
				 *****************************************/
				if ("Y".equals(paramVO.getIfFlg()))
				{
					bkgCstmsAdvBlVO.setIbflag("U");
				}
				else
				{
					bkgCstmsAdvBlVO.setIbflag("C");
				}
				/*****************************************
				 * BKG_CSTMS_ADV_BL UPDATE or INSERT
				 *****************************************/
				bkgCstmsAdvBlVO.setUpdUsrId(account.getUsr_id());
				dbDao.mergeSelectBkgCstmsAdvBl(bkgCstmsAdvBlVO);
				/*****************************************
				 * BKG_CUSTOMER => BKG_CSTMS_ADV_CUST
				 *****************************************/
//				List<BkgCstmsAdvCustVO> listCust = null;
//				if ("M".equals(paramVO.getBlType()))
//				{
//					// Master BL의 경우 Customer 조회
//					listCust = dbDao.searchBkgCustomer(bkgCstmsAdvBlVO);
//				}
//				else
//				{
//					// HB/L의 경우 Customer 조회
//					listCust = dbDao.searchBkgHblCust(bkgCstmsAdvBlVO);
//				}
//				dbDao.addBkgCstmsAdvCust(listCust);
				
				if ("M".equals(paramVO.getBlType()))
				{
					// Master BL의 경우 Customer 조회
					dbDao.addBkgCstmsAdvCust(dbDao.searchBkgCustomer(bkgCstmsAdvBlVO));
				}
				else
				{
					// HB/L의 경우 Customer 조회
					dbDao.addBkgCstmsAdvCust(dbDao.searchBkgHblCust(bkgCstmsAdvBlVO));
				}
				
				/*****************************************
				 * BKG_CONTAINER => BKG_CSTMS_ADV_CNTR
				 *****************************************/
				dbDao.addBkgCstmsAdvCntr(dbDao.searchBkgContainer(bkgCstmsAdvBlVO));
				/*****************************************
				 * BKG_CNTR_SEAL_NO => BKG_CSTMS_SEAL_NO
				 *****************************************/
				dbDao.addBkgCstmsSealNo(dbDao.searchBkgCntrSealNo(bkgCstmsAdvBlVO));
				/*****************************************
				 * BKG_CNTR_MF_DESC => BKG_CSTMS_ADV_CNTR_MF
				 *****************************************/
				dbDao.addBkgCstmsAdvCntrMf(dbDao.searchBkgCntrMfDesc(bkgCstmsAdvBlVO));
				/*****************************************
				 * BKG_BL_MK_DESC => BKG_CSTMS_ADV_MK_DESC
				 *****************************************/
				dbDao.addBkgCstmsAdvMkDesc(dbDao.searchBkgBlMkDesc(bkgCstmsAdvBlVO));
				
				/*****************************************
				 * BKG_CSTMS_ADV_CNTR
				 * 기존 RAIL_CRR_REF_NO, USA_IB_TRSP_NO 유지
				 *****************************************/
				dbDao.modifyBkgCstmsAdvCntr(bkgCstmsAdvCntrVOs);
			}
		}
		catch (EventException ex) 
		{
	        log.error("err " + ex.toString(), ex);
	        result = "FAIL";
	        throw ex;
		}
		catch (DAOException ex)
		{
            result = "FAIL";
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
            result = "FAIL";
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return result;
	}

	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param manifestListDetailVOs 적하목록 List
	 * @param account 세션정보
	 */
	public void setManifestListDetailVO(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account,CndManifestListDownloadDBDAO dbDao) {
		if(manifestListDetailVOs != null){
			ManifestListDetailVO[] tmpVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
		this.account = account;
		this.dbDao = dbDao;
	}

}
