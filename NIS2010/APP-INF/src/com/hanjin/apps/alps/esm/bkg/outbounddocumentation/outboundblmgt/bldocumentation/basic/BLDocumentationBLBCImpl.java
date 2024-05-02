/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BLDocumentationBLBCImpl.java
 *@FileTitle : Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
 * -----------------------------------------------------------
 * History
 * 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
 * 2011.03.03 조원주 [CHM-201109079] POD 가 JOAQJ 일 경우 M/D Description 에 tariff 조항 자동 표기 요청
 * 2011.04.18 이일민 [CHM-201110112] BKG HISTORY 추가 요청 - bill type change 
 * 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.05.24 김기택 [CHM-201217780-01] POD 또는 DEL의 국가 코드가 DZ 일 경우 Tariff 강제 적용
 * 2012.07.03 조정민 [CHM-201218736] EQR BKG Update 기능에 Validation 추가
 * 2012.07.23 김기택 [CCHM-201218572-01] POD: BR인 B/L의 경우 현재 B/L 문구적용 삭제 
 * 2012.10.10 김기택 [CHM-201220360-01] POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용 제외
 * 2012.10.26 김기택 [CHM-201220828-01] BR 향 화물의 BL상 특정 안내문구 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import klnet.hssearcher.HSSearcher;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration.BookingUtilDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.common.HblSeq;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationBLDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationBLEAIDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationCMDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlStatusVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MfNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrCycVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MtyCntrStsVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.WgtPkgMeasVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmInfoValidationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlDocVO;
import com.hanjin.syscommon.common.table.BkgBlMkDescVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgHblCustVO;
import com.hanjin.syscommon.common.table.BkgHblVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.MstContainerVO;

/**
 * ALPS-OutboundBLMgt Business Logic Basic Command implementation<br>
 * - ALPS-OutboundBLMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Youngchul
 * @see UI_BKG-0079-04EventResponse,BLDocumentationBLBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BLDocumentationBLBCImpl extends BasicCommandSupport implements BLDocumentationBLBC {

    // Database Access Object
    private transient BLDocumentationBLDBDAO dbDao = null;
    private transient BLDocumentationBLEAIDAO eaiDao = null;
    private transient BLDocumentationCMDBDAO cmDao = null;
    private transient BookingUtilDBDAO utilDao = null;

    /**
     * BLDocumentationBLBCImpl 객체 생성<br>
     * BLDocumentationBLDBDAO를 생성한다.<br>
     */
    public BLDocumentationBLBCImpl() {
        dbDao = new BLDocumentationBLDBDAO();
        eaiDao = new BLDocumentationBLEAIDAO();
        cmDao = new BLDocumentationCMDBDAO();
        utilDao = new BookingUtilDBDAO();
    }
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String mcflag
	 * @param String caflag
	 */
	 public void modifyChgRateBkgBlDocMasterCovered(RateMainInfoVO rateMainInfoVO, String mcflag ,String caflag)throws EventException{  
	    try {
	    	 dbDao.modifyChgRateBkgBlDocMasterCovered(rateMainInfoVO, mcflag ,caflag);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	/**
	* EsmBkg0771Event 저장 이벤트 처리<br>
	* 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다<br>
	* //[결함관리지침에 따른 이동]
	* @author LEE JIN SEO
	* @param String bkg_no
	* @param String master_bl_no
	* @param CoveredBlListVO[] coveredBlListVOs
	* @return String
	* @exception EventException
	*/
	public String manageCoveredBl(String bkg_no,String master_bl_no,CoveredBlListVO[] coveredBlListVOs) throws EventException{
		String r_message = "";
		
		try {
            log.debug("=============================================");
            log.debug(" [save]  manageCoveredBl 저장  ");
            log.debug("=============================================");
			log.debug("[END:: BLDocumentationBLBCImpl == manageCoveredBl  ]==========");
			
			List<CoveredBlListVO> insertVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> updateVoList = new ArrayList<CoveredBlListVO>();
			List<CoveredBlListVO> deletetVoList = new ArrayList<CoveredBlListVO>();

			String bl_no = null;
			CoveredBlListVO coveredBlListVO = null; 
			
			for (int i = 0; i < coveredBlListVOs.length; i++) {
				//user가 입력한 신규 bl_no 
				bl_no = coveredBlListVOs[i].getBlNo();

				if (coveredBlListVOs[i].getIbflag().equals("U")) {
					coveredBlListVO = new CoveredBlListVO();
					//기존 bl_no는 null값으로 update처리 
					coveredBlListVO.setBlCvrdTpCd("");
					coveredBlListVO.setMstCvrdBlNo("");
					coveredBlListVO.setBlNo(coveredBlListVOs[i].getOldBlNo());
					updateVoList.add(coveredBlListVO);
					
					//user가 입력한 bl_no로  신규 처리 
//					coveredBlListVOs[i].setIbflag("I");
//					coveredBlListVOs[i].setBlNo(bl_no);
				}

				if (coveredBlListVOs[i].getIbflag().equals("I") || coveredBlListVOs[i].getIbflag().equals("U")) {
					//user가 입력한 신규 bl_no 처리  = master bl_no로 update함 
					coveredBlListVOs[i].setBlCvrdTpCd("C");
					coveredBlListVOs[i].setMstCvrdBlNo(master_bl_no);					
					coveredBlListVOs[i].setBlNo(bl_no);
					insertVoList.add(coveredBlListVOs[i]);
				}
				 
				if (coveredBlListVOs[i].getIbflag().equals("D")) {			
					coveredBlListVOs[i].setBlCvrdTpCd("");
					coveredBlListVOs[i].setMstCvrdBlNo("");
					coveredBlListVOs[i].setBlNo(coveredBlListVOs[i].getBlNo());
					deletetVoList.add(coveredBlListVOs[i]);
				}
			}
			int db_cnt = 0;
			if (updateVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(updateVoList);
			}
			if (insertVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(insertVoList);
			}
			if (deletetVoList.size() > 0) {
				db_cnt = dbDao.modifyCoveredBl(deletetVoList);
			}
			log.debug("* db_cnt : " + db_cnt);

		}catch (DAOException de) 
		{
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), de);
		} 
		catch (Exception ex) 
		{
			throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
		}
		log.debug("[END::]==========");
		return r_message; 
	}
		
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 */
	 public void modifyChgRateBkgBlDoc(RateMainInfoVO rateMainInfoVO, String caflag)throws EventException{  
	    try {
	    	 dbDao.modifyChgRateBkgBlDoc(rateMainInfoVO,caflag);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	 /**
     * EsmBkg007909Event 저장 이벤트 처리<br>
     * //[결함관리지침에 따른 이동]
     * bl issue 관련 정보를 관리한다.<br>
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
    public void manageBlIssueFlg(BlIssInfoVO blIssInfoVO) throws EventException{
        try {
            dbDao.manageBlIssueFlg(blIssInfoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    /**
     * B/L Issue 관련 B/L Doc 정보를 변경한다. -- UI_BKG-0079-09, BKG B/L ISSUE.
     * 
     * @author LEE JIN SEO
     * @param BlIssInfoVO blIssInfoVO
     * @exception EventException
     */
	public void modifyBlIssInfoForBlDoc(BlIssInfoVO blIssInfoVO) throws EventException{
        try {
            dbDao.modifyBlIssInfoForBlDoc(blIssInfoVO);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	
	
    /**
     * mark & description 조회.
     * 
     * @param bkgBlNoVO
     * @return MndVO
     * @exception EventException 
     */
    public MndVO searchMnd(BkgBlNoVO bkgBlNoVO) throws EventException {
    	BLDocumentationCMDBDAO cmDao = new BLDocumentationCMDBDAO();
        MndVO mndVO = null;
        try {
            mndVO = dbDao.searchMnd(bkgBlNoVO);
            
            
            String porCd = mndVO.getPorCd();
            String polCd = mndVO.getPolCd();
            String podCd = mndVO.getPodCd();
            String delCd = mndVO.getDelCd();
            String cmdtDesc = mndVO.getDgCmdtDesc();
            String bkgNo = mndVO.getBkgNo();
            String caFlg = bkgBlNoVO.getCaFlg();
            
            //2012.10.25  Booking 의 DEL이 BR 인 경우 B/L 자동 문구 추가
            if(delCd !=null && delCd.length()> 2 && "BR".equals(delCd.substring(0, 2))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_BR, "").replace(Constants.CMDT_DESC_ATTD_BR_OLD, "");
            }
            if((polCd !=null && polCd.length()> 2 && "BR".equals(polCd.substring(0, 2))) ||
                    (podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2)))){
            		String desc = cmDao.searchWpmDescForBl(bkgBlNoVO, "N");
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(desc, "");
            }
            //2012.10.25  Booking 의 POD이 UY,AR 인 경우 B/L 자동 문구 추가
            if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY, "");
            }
            if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
               (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
               (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
               (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace((cmdtDesc.endsWith(Constants.CMDT_DESC_ATTD_MX)? Constants.CMDT_DESC_ATTD_MX : Constants.CMDT_DESC_ATTD_MX.substring(2)), "");
            }
            if((delCd !=null && !"GTPRQ".equals(delCd.substring(0, 2))) &&
               (porCd !=null && porCd.length()> 2 && "GT".equals(porCd.substring(0, 2))) ||
               (polCd !=null && polCd.length()> 2 && "GT".equals(polCd.substring(0, 2))) ||
               (podCd !=null && podCd.length()> 2 && "GT".equals(podCd.substring(0, 2))) ||
               (delCd !=null && delCd.length()> 2 && "GT".equals(delCd.substring(0, 2)))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GT, "");
            }
            if((podCd !=null && podCd.length()> 2 && "GR".equals(podCd.substring(0,2))) ||
               (delCd !=null && delCd.length()> 2 && "GR".equals(delCd.substring(0,2)))){
            	//POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용하지 않음
            	String socFlg = dbDao.searchSocFlg(bkgNo,caFlg);
            	if(!"Y".equals(socFlg)){
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GR, "");
            	}
            }
            if((podCd !=null && podCd.length()> 2 && "EG".equals(podCd.substring(0,2))) ||
               (delCd !=null && delCd.length()> 2 && "EG".equals(delCd.substring(0,2)))){
            	//POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용하지 않음
            	String socFlg = dbDao.searchSocFlg(bkgNo,caFlg);
            	if(!"Y".equals(socFlg)){
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_EG, "");
            	}
            		
            }
            if((podCd !=null && podCd.length()> 2 && "SA".equals(podCd.substring(0,2))) ||
                    (delCd !=null && delCd.length()> 2 && "SA".equals(delCd.substring(0,2)))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SA, "");

            }
            
            if((podCd !=null && podCd.length()> 2 && "IRBND".equals(podCd)) ||
                    (delCd !=null && delCd.length()> 2 && "IRBND".equals(delCd))){
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_IRBND, "");
			}
            
            /* POD 가 JOAQJ 일 경우  Tariff 항목 추가 Reefer cargo free time 은 6일 로 변경 */
            if((podCd !=null && "JOAQJ".equals(podCd))){
            	//BlAppWordVO blAppWordVo = dbDao.searchBlAppWord(bkgBlNoVO.getBkgNo());
            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO, "").replace(Constants.CMDT_DESC_ATTD_JOAQJ, "");
//            	String custFlg ="N";
//            	custFlg =  dbDao.searchRvisCntrCustTpCd(bkgNo, caFlg);
//            	if ("Y".equals(custFlg)) {
//            	mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO, ""));
//            	}else if("A".equals(custFlg)) {
//            		mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO, "").replace(Constants.CMDT_DESC_ATTD_JOAQJ, ""));
//				}else{
//            		mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ, ""));
//            	}
            }
            
            /* POD 가 KHPNH 일 경우(Last POL:VNSGN (Y2) -> Last POD:KNPNH(Y4))  Tariff 항목 추가 */
            List<VslSkdVO> routeDetails = dbDao.searchVvdSkdForTsRouteKNPNH(bkgNo, caFlg);
            if(routeDetails != null && routeDetails.size() > 0){
				if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
						&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){	            
					cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_KHPNH, "");
	            }
            }
            
            String syFlg = dbDao.searchMndTsSyFlg(mndVO.getBkgNo());
            /* POD , DEL 의 국가코드가 SY 일 경우  Tariff 항목 추가 */
            if ((podCd !=null && podCd.length() >= 2 && "SY".equals(podCd.substring(0,2)))||
                    (delCd !=null && delCd.length() >= 2 && "SY".equals(delCd.substring(0,2)))||
                    (podCd !=null && podCd.length() >= 2 &&  "Y".equals(syFlg))){
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SY, "");
                 }
            
            // POD 또는 DEL의 국가코드가 DZ 일 경우 Tariff 강제 적용, POR, POL의 국가 코드가 US 일 경우는 에외
            //2015.03.18 US일 경우 auto-clause추가
            if((podCd !=null && podCd.length()> 2 && "DZ".equals(podCd.substring(0,2))) ||
                    (delCd !=null && delCd.length()> 2 && "DZ".equals(delCd.substring(0,2)))){
            	if((porCd !=null && porCd.length()> 2 && "US".equals(porCd.substring(0,2))) ||
                        (polCd !=null && polCd.length()> 2 && "US".equals(polCd.substring(0,2)))){	
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_US_DZ, "");  
            	}else{
            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_DZ_DRY, "").replace(Constants.CMDT_DESC_ATTD_DZ_SPCL, "").replace(Constants.CMDT_DESC_ATTD_DZ, "");
            	}
            }
            
			// PO No.의 Mandatory Item Check
            String rPoOtherMdtItm = dbDao.searchPoMdtItm(bkgBlNoVO);
//            log.debug("rPoOtherMdtItm>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+rPoOtherMdtItm);
//            bkgBlNoVO.setO_PoOtherMdtItmVO(rPoOtherMdtItm);
            mndVO.setRPoOtherMdtItm(rPoOtherMdtItm);
            
            String bkgRefTpCd = dbDao.searchBkgRefTpCd(rPoOtherMdtItm, bkgBlNoVO.getBkgNo());
//            log.debug("bkgRefTpCd>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+bkgRefTpCd);
            mndVO.setBkgRefTpMlCd(bkgRefTpCd);
            mndVO.setDgCmdtDesc(cmdtDesc);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return mndVO;
    }

    /**
     * mark & description 저장선 validation
     * 
     * @param mndVO
     * @exception EventException
     */
    public void validateMnd(MndVO mndVO) throws EventException {
    	BookingUtil utilCmd = new BookingUtil();
        try {
        	if (mndVO.getPckTpCd() != null && ! "".equals(mndVO.getPckTpCd().trim())) {
	            MdmPckTpVO pckTpVO = utilCmd.searchPkgType(mndVO.getPckTpCd());
	            if(pckTpVO == null || pckTpVO.getPckCd() == null) {
	                throw new EventException(new ErrorHandler("BKG00530", new String[]{mndVO.getPckTpCd()}).getMessage());
	            }
        	}
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * Sea NACCS가 eBooking과 통합하게 되어 예외처리되어 구현되었던 부분을 구현하지 않는다.
     * 
     * @param mndVO
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void manageMnd(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException {
    	
    	BookingUtil comboUtil = new BookingUtil();
    	BLDocumentationCMDBDAO cmDao = new BLDocumentationCMDBDAO();
    	
        /* bkgBlDocVO */
        BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
        bkgBlDocVO.setBkgNo(mndVO.getBkgNo());
        bkgBlDocVO.setTtlPckDesc(mndVO.getTtlPckDesc());
        bkgBlDocVO.setCstmsDesc(mndVO.getCstmsDesc());
        bkgBlDocVO.setPckCmdtDesc(mndVO.getPckCmdtDesc());
        bkgBlDocVO.setCntrCmdtDesc(mndVO.getCntrCmdtDesc());
        bkgBlDocVO.setPckQty(mndVO.getPckQty());
        bkgBlDocVO.setPckTpCd(mndVO.getPckTpCd());
        bkgBlDocVO.setMeasQty(mndVO.getMeasQty());
        bkgBlDocVO.setMeasUtCd(mndVO.getMeasUtCd());
        bkgBlDocVO.setActWgt(mndVO.getActWgt());
        bkgBlDocVO.setWgtUtCd(mndVO.getWgtUtCd());
        bkgBlDocVO.setActWgtPrnFlg(mndVO.getActWgtPrnFlg());
        bkgBlDocVO.setCreUsrId(account.getUsr_id());
        bkgBlDocVO.setUpdUsrId(account.getUsr_id());
        
        /* bkgBlNoVO */
        BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
        bkgBlNoVO.setBkgNo(mndVO.getBkgNo());
        bkgBlNoVO.setCaFlg(caFlg);

        String porCd = mndVO.getPorCd();
        String polCd = mndVO.getPolCd();
        String podCd = mndVO.getPodCd();
        String delCd = mndVO.getDelCd();
        //String cmdtDesc = WordWarp.wrap(mndVO.getDgCmdtDesc(), 49);
        //String mkDesc = WordWarp.wrap(mndVO.getMkDesc(), 23);
        String cmdtDesc = mndVO.getDgCmdtDesc();
        String mkDesc = mndVO.getMkDesc();
        String bkgNo = mndVO.getBkgNo();

        /* bkgBlMkDescVO */
        BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
        blMkDescVO.setBkgNo(mndVO.getBkgNo());
        blMkDescVO.setMkDesc(mkDesc);
        blMkDescVO.setCmdtDesc(cmdtDesc);
        blMkDescVO.setAutoCluzDpCd("");;
        blMkDescVO.setMkSeq("1");
        blMkDescVO.setCreUsrId(account.getUsr_id());
        blMkDescVO.setUpdUsrId(account.getUsr_id());
        log.debug("\n//////////////////////////////////////////////////\n"+cmdtDesc+"\n//////////////////////////////////////////////////");

        /* POD or DEL이 터키일 때 Consignee or Notify tax id 없으면 저장 불가 Validation 추가 */
//	        if ((podCd != null && podCd.length() >= 2 && "TR".equals(podCd .substring(0, 2))) || 
//					(delCd != null && delCd.length() >= 2 && "TR".equals(delCd .substring(0, 2)))) {
//	        	try {
//					String flg = dbDao.checkTurkeyTaxId(bkgNo,caFlg);
//					if(!"Y".equalsIgnoreCase(flg)){
//						throw new EventException((String)new ErrorHandler("BKG95098").getMessage());
//					}
//				} catch (DAOException ex) {
//					throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//				}
//					
//			}
        
        
	         //2012.10.25  Booking 의 DEL이 BR 인 경우 B/L 자동 문구 추가
	        if(delCd !=null && delCd.length()> 2 && "BR".equals(delCd.substring(0, 2))){
	        	
        		try {
    	        	if("Y".equals(dbDao.searchEffDtDiv(bkgNo,"BKG",caFlg))){
    	        		cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_BR;
    	        	}else{
    	        		cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_BR_OLD;
    	        	}
        		}catch(DAOException ex) {
    	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	        }
	        }
	        
            if((polCd !=null && polCd.length()> 2 && "BR".equals(polCd.substring(0, 2))) ||
                    (podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2)))){
        		try {
        			String desc = cmDao.searchWpmDescForBl(bkgBlNoVO, "N");
        			cmdtDesc = cmdtDesc + desc;
        		}catch(DAOException ex) {
    	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	        }
	        }

	        if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
		        //Auto-Clause Display가 check상태일때
		        if("Y".equals(mndVO.getDisplayChk())){
		        	 cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_UY;
		        	 blMkDescVO.setAutoCluzDpCd("Y");
		        }else{
		        	 blMkDescVO.setAutoCluzDpCd("N");
		        }
	            
	        }
	        
	        if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
	           (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
	           (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
	           (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
	//            if(cmdtDesc != null && cmdtDesc.length() > 12){
	//                StringBuffer buf = new StringBuffer();
	//                String[] arr = cmdtDesc.split("\\r\\n");
	//                log.debug("# line count : " + (arr.length));
	//                if(arr.length > 9){
	//                    for(int i=0;i<arr.length;i++){
	//                        if(i==9){
	//                            buf.append(Constants.CMDT_DESC_ATTD_MX.substring(2));
	//                        }
	//                        buf.append(arr[i]);
	//                        buf.append("\r\n");
	//                    }
	//                    blMkDescVO.setCmdtDesc(buf.toString());
	//                }else{
	//                    blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_MX);
	//                }
	//            }else{
	        		cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_MX;
	//            }
	        }
	        if((delCd !=null && delCd.length() >= 5 && !"GTPRQ".equals(delCd.substring(0, 2))) &&
	           (porCd !=null && porCd.length() >= 2 && "GT".equals(porCd.substring(0, 2))) ||
	           (polCd !=null && polCd.length() >= 2 && "GT".equals(polCd.substring(0, 2))) ||
	           (podCd !=null && podCd.length() >= 2 && "GT".equals(podCd.substring(0, 2))) ||
	           (delCd !=null && delCd.length() >= 2 && "GT".equals(delCd.substring(0, 2)))){
	        	cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_GT;
	        }
	        
			// POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용하지 않음
	        if((podCd !=null && podCd.length() >= 2 && "GR".equals(podCd.substring(0,2))) ||
	           (delCd !=null && delCd.length() >= 2 && "GR".equals(delCd.substring(0,2)))){
				String socFlg = "";
				try {
					socFlg = dbDao.searchSocFlg(bkgNo,caFlg);
					if (!"Y".equals(socFlg)) {
						cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_GR;
					}
				} catch (DAOException ex) {
					throw new EventException( new ErrorHandler("COM12240").getMessage(), ex);
				}
			}
	        
			// POD가 EG,GR 일때 SOC Container인 경우 강제 문구를 적용하지 않음
			if ((podCd != null && podCd.length() >= 2 && "EG".equals(podCd .substring(0, 2))) || 
				(delCd != null && delCd.length() >= 2 && "EG".equals(delCd .substring(0, 2)))) {
				String socFlg = "";
				try {
					socFlg = dbDao.searchSocFlg(bkgNo,caFlg);
					if (!"Y".equals(socFlg)) {
						cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_EG;
					}
				} catch (DAOException ex) {
					throw new EventException( new ErrorHandler("COM12240").getMessage(), ex);
				}
			}
			
			// POD가 SA 일때 SOC Container인 경우 강제 문구를 적용하지 않음
			if ((podCd != null && podCd.length() >= 2 && "SA".equals(podCd .substring(0, 2))) || 
					(delCd != null && delCd.length() >= 2 && "SA".equals(delCd .substring(0, 2)))) {
				
			        //Auto-Clause Display가 check상태일때
			        if("Y".equals(mndVO.getDisplayChk())){
			        	cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_SA;
			        	blMkDescVO.setAutoCluzDpCd("Y");;
			        }else{
			        	blMkDescVO.setAutoCluzDpCd("N");;
			        }
					
			}
			
            if((podCd !=null && podCd.length()> 2 && "IRBND".equals(podCd)) ||
                    (delCd !=null && delCd.length()> 2 && "IRBND".equals(delCd))){
            		cmdtDesc = cmdtDesc + Constants.CMDT_DESC_IRBND;
			}

			
	        /* POD 가 JOAQJ 일 경우  Tariff 항목 추가 */
	        if((podCd !=null && "JOAQJ".equals(podCd))){
	        	String custFlg = "N";
	        	try{
	        		 
	        		//POD가 JOAQJ 인 경우 계약이 SC일땐 계약자가 NBCO일 경우만 문구를 찍고, RFA일땐 Shipper가 NBCO일때만 문구를 찍는다. (CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO)
	        		custFlg =  dbDao.searchRvisCntrCustTpCd(bkgNo, caFlg);
	        		
	        		if("JORBA".equals(account.getOfc_cd())){
	        			if("Y".equals(mndVO.getDisplayChk())){
	        				if("Y".equals(custFlg)){
	        					cmdtDesc = cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO + Constants.CMDT_DESC_ATTD_JOAQJ;
					        	blMkDescVO.setAutoCluzDpCd("Y");
	        				}else if("K".equals(custFlg)){
	        					cmdtDesc = cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO;
					        	blMkDescVO.setAutoCluzDpCd("Y");
	        				}else if("N".equals(custFlg)){
	        					cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_JOAQJ;
					        	blMkDescVO.setAutoCluzDpCd("Y");
	        				}
	        			}else{
	        				blMkDescVO.setAutoCluzDpCd("N");
	        			}
	        		}else{
	        			
	        			if("K".equals(custFlg)){
	        				cmdtDesc = cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO;
				        	blMkDescVO.setAutoCluzDpCd("N");
	        			}else if("Y".equals(custFlg)){
	        				if("Y".equals(mndVO.getDisplayChk())){
	        					cmdtDesc = cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO + Constants.CMDT_DESC_ATTD_JOAQJ;
					        	blMkDescVO.setAutoCluzDpCd("Y");
	        				}else{
	        					cmdtDesc = cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO;
					        	blMkDescVO.setAutoCluzDpCd("N");
	        				}
	        			}else{
		        			if("Y".equals(mndVO.getDisplayChk())){
		        				cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_JOAQJ;
					        	blMkDescVO.setAutoCluzDpCd("Y");
		        			}else{
		        				blMkDescVO.setAutoCluzDpCd("N");
		        			}
	        			}
	        			
	        		}
//	        		if ("Y".equals(custFlg)) {
//				        //Auto-Clause Display가 check상태일때 free time관련문구
//				        if("Y".equals(mndVO.getDisplayChk())){
//				        	blMkDescVO.setCmdtDesc(cmdtDesc  + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO + Constants.CMDT_DESC_ATTD_JOAQJ);
//				        	blMkDescVO.setAutoCluzDpCd("Y");;
//				        }else{
//				        	blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO);
//				        	blMkDescVO.setAutoCluzDpCd("N");;
//				        }
//					}else{
//				        //Auto-Clause Display가 check상태일때 free time관련문구
//				        if("Y".equals(mndVO.getDisplayChk())){
//				        	blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_JOAQJ);
//				        	blMkDescVO.setAutoCluzDpCd("Y");;
//				        }else{
//				        	blMkDescVO.setAutoCluzDpCd("N");;
//				        }
//					}
	        		

			        
		        } catch(DAOException ex) {
		            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		        }	
	        	
	        }    
	        
	        /* POD/ DEL의 국가 코드가 SY 일 경우  Tariff 항목 추가 */
	        String syFlg ="";
	        try {
	        	syFlg = dbDao.searchMndTsSyFlg(mndVO.getBkgNo());
	        } catch(DAOException ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	    
	        if ((podCd !=null && podCd.length() >= 2 && "SY".equals(podCd.substring(0,2)))||
	                (delCd !=null && delCd.length() >= 2 && "SY".equals(delCd.substring(0,2)))||
	                (podCd !=null && podCd.length() >= 2 &&  "Y".equals(syFlg))) 
	                {
	        	cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_SY;
	        } 
	        
	        // POD 또는 DEL의 국가코드가 DZ 일 경우 Tariff 강제 적용, POR, POL의 국가 코드가 US 일 경우는 에외
	        //2015.03.18 US일 경우 auto-clause추가
	        if((podCd !=null && podCd.length() >= 2 && "DZ".equals(podCd.substring(0,2))) ||
	                (delCd !=null && delCd.length() >= 2 && "DZ".equals(delCd.substring(0,2)))){
	        	if((porCd !=null && porCd.length()> 2 && "US".equals(porCd.substring(0,2))) ||
	                    (polCd !=null && polCd.length()> 2 && "US".equals(polCd.substring(0,2)))){
	        		try {
		        		if("Y".equals(dbDao.searchEffDtDiv(bkgNo,"CRD",caFlg))){
		        			cmdtDesc = cmdtDesc + "\r\n"+Constants.CMDT_DESC_ATTD_US_DZ;
		        		}			
	        		}catch(DAOException ex) {
	    	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    	        }
	        	}else{
	        		try {
		        		String cntrTp = dbDao.searchCntrTpForDZ(bkgNo,caFlg);
		        		if("D".equals(cntrTp)){
		        			cmdtDesc = cmdtDesc + "\r\n"+Constants.CMDT_DESC_ATTD_DZ_DRY;
		        		}else if("S".equals(cntrTp)){
		        			cmdtDesc = cmdtDesc + "\r\n"+Constants.CMDT_DESC_ATTD_DZ_SPCL;
		        		}else if("M".equals(cntrTp)){
		        			cmdtDesc = cmdtDesc + "\r\n"+Constants.CMDT_DESC_ATTD_DZ_DRY + Constants.CMDT_DESC_ATTD_DZ_SPCL;	
		        		}else if("DZ".equals(cntrTp)){
		        			cmdtDesc = cmdtDesc + "\r\n"+Constants.CMDT_DESC_ATTD_DZ;	
		        		}
		        			
		        			
	        		}catch(DAOException ex) {
	    	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    	        }
	        	}
	        }
	        
	        /* POD 가 KHPNH 일 경우(Last POL:VNSGN (Y2) -> Last POD:KNPNH(Y4))  Tariff 항목 추가 */
	        try {
	        List<VslSkdVO> routeDetails = dbDao.searchVvdSkdForTsRouteKNPNH(bkgNo,caFlg);
	        if(routeDetails != null && routeDetails.size() > 0){
	          if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
					&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){
	        	  cmdtDesc = cmdtDesc + Constants.CMDT_DESC_ATTD_KHPNH;
			  }
	        }
	        } catch(DAOException ex) {
	            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	        

	    
	    
        log.debug("\n//////////////////////////////////////////////////\n"+blMkDescVO.getCmdtDesc()+"\n//////////////////////////////////////////////////");
        
        
		try{
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");	
			bkgHrdCdgCtntListCondVO.setAttrCtnt1("GET_HS_CODE");
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = comboUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			 
			if("ON".equals(BkgHrdCdgCtntVOs.get(0).getAttrCtnt2())){
	        	//케이엘넷이 제공한 프로그램으로 HS code가져옴
	        	if(!"".equals(bkgBlDocVO.getCstmsDesc())){
	        		final String searcher_path = SiteConfigFactory.getWhenNullThrowException("COM.HSS.DIRECTORY");
	        		String hsCode = HSSearcher.getHsCode(bkgBlDocVO.getCstmsDesc(), searcher_path);
	        		if (hsCode != null && !hsCode.equals("999999")) {
	            		bkgBlDocVO.setCmdtHsCd(hsCode);
	        		}
	        	}
			}
		} catch(Exception crEx){
			log.error("err " + crEx.toString(), crEx);
		}

		
        try {
            dbDao.modifyBl(bkgBlDocVO, caFlg);
            //dbDao.manageMnd(blMkDescVO);
            blMkDescVO.setCmdtDesc(cmdtDesc);
            if(dbDao.modifyMnd(blMkDescVO, caFlg) == 0){
                dbDao.addMnd(blMkDescVO, caFlg);
            }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * dangerous cargo 정보를 조회한다.
     * @param bkgNo
     * @return List<DGCargoVO>
     * @exception EventException
     */
    public List<DGCargoVO> searchDG(String bkgNo) throws EventException {
        try {
            return dbDao.searchDG(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Package Type code 체크 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param XptImpLicVO[] xptImpLicVOs
     * @exception EventException
     */
    public void validateExportImportNumber(XptImpLicVO[] xptImpLicVOs) throws EventException {
        BookingUtil utilCmd = new BookingUtil();
        boolean flag = false;
        try {
            // 1. BookingUtil::validatePkgType ( pkgTpCd )
//            log.debug(" * PckTpCd : " + xptImpLicVOs.getPckTpCd());
        	for (int i=0; i < xptImpLicVOs.length; i++) {
        		if (!"D".equals(xptImpLicVOs[i].getIbflag())) {
		            flag = utilCmd.validatePkgType(xptImpLicVOs[i].getPckTpCd());
		            if(!flag) {
		                throw new EventException(new ErrorHandler("BKG01050", new String[]{"Package Type"}).getMessage());
		            }
        		}
        	}

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information 국가별 조회 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicIn
     * @param caFlg
     * @return List<XptImpLicVO>
     * @exception EventException
     */
    public List<XptImpLicVO> searchExportImportNumber(XptImpLicInVO xptImpLicIn, String caFlg) throws EventException {
        try {
            return dbDao.searchExportImportNumber(xptImpLicIn, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information 국가별 입력 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param caFlg
     * @exception EventException
     */
    public void createExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.createExportImportNumber(xptImpLicVOs, cntCd, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information 국가별 수정 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param xptImpLicVOs
     * @param cntCd
     * @param caFlg
     * @exception EventException
     */
    public void modifyExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String cntCd, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.modifyExportImportNumber(xptImpLicVOs, cntCd, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Export / Import Information 국가별 삭제 처리 (ESM_BKG_0361_01~06)
     * 
     * @author Choi Do Soon
     * @param List<XptImpLicVO> xptImpLicVOs
     * @param caFlg
     * @exception EventException
     */
    public void removeExportImportNumber(List<XptImpLicVO> xptImpLicVOs, String caFlg) throws EventException {

        try {

            if(xptImpLicVOs.size() > 0) {
                dbDao.removeExportImportNumber(xptImpLicVOs, caFlg);
            }

        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * split시 new booking에 b/l, cntr, c/m 정보를 넣는다.<br>
     * 1. copyBkgBlDocByBkg()를 실행하여 bkg_bl_doc table을 복사한다(일부 값(pkg, wgt, meas 수정)<br>
     * 2. copyMndByBkg()를 실행하여 bkg_bl_mk_desc table을 복사한다.<br>
     * 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyBlDocByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO, SignOnUserAccount account) throws EventException {
        try {
            // new Bkg Split
            for(int i = 0; i < targetBkg.length; i++) {
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    // bkg_bl_doc 테이블을 복사하되 weight, package, measure 관련속성은 splitBlInfoVO의 값으로 바꾼다.
                    dbDao.copyBkgBlDocByBkg(sourceBkg, targetBkg[i], splitBkgVO.getSplitBlInfoVO().get(i), account);
                    // bkg_bl_mk_desc 테이블을 복사한다
                    dbDao.copyMndByBkg(sourceBkg, targetBkg[i], account);
                    // bkg_xpt_imp_lic 테이블을 복사한다
                    dbDao.copyExportImportNumberByBkg(sourceBkg, targetBkg[i], account);
                }
                if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")
                    && sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())) { // 원본 bkg에 대한 처리
                    dbDao.modifyBkgBlDocAfterSplit(sourceBkg, splitBkgVO.getSplitBlInfoVO().get(0), account);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * bkg_hbl 테이블을 sourceBkg -> targetBkg로 복사한다<br>
     *  cntr_mf_no는 ORG_CNTR_MF_NO로 복사한다.<br>
     * 
     * @param String copyModeCd
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param List<SelectCntrVO> selectCntrVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyHblByBkg(String copyModeCd, BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg, List<SelectCntrVO> selectCntrVO, SignOnUserAccount account) throws EventException {
        try {
            // new Bkg Split
            for(int i = 0; i < targetBkg.length; i++) {
                // selectCntrVO만큼 반복
                if(!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
                    // split bkg에 house b/l 전부 복사하므로 loop 제거(정민정 과장 확인 20091013)
//                  for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
                        // bkg_hbl 테이블을 sourceBkg -> targetBkg로 복사한다
                        dbDao.copyHblByBkg(sourceBkg, targetBkg[i], copyModeCd, account);
                        // bkg_hbl_cust 테이블을 sourceBkg -> targetBkg로 복사한다
                        dbDao.copyHblCustByBkg(sourceBkg, targetBkg[i], account);
//                  }
                }
                // split시 원본에도 hbl 그대로 유지 (정민정 과장 확인 20091013)
//                if(copyModeCd.equals("S")) {
////                    for(int icnt = 0; icnt < selectCntrVO.size(); icnt++) {
//                        // 전달받은 cntrNo로 bkg_container에서 cntr_mf_no를 조회하여 hbl에서 cntr_mf_no가 같은 row를 삭제한다
//                        dbDao.removeBkgHblCustByBkg(sourceBkg);
//                        // 전달받은 cntrNo로 bkg_hbl_cus에서 조회하여 hbl에서 같은 row를 삭제한다
//                        dbDao.removeBkgHblByBkg(sourceBkg);
////                    }
//                }
            }// for
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Container Manifest에서 M&D 정보에 업데이트 하기 위해 Data를 조회한다. -- UI_BKG-0707
     * 
     * @param bkgNo
     * @return CmGoodsDescVO
     * @exception EventException
     */   
    public CmGoodsDescVO searchGoodsDescByCm(String bkgNo) throws EventException {
        try {
            return dbDao.searchGoodsDescByCm(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * On-Board Date를 업데이트 한다. -- UI_BKG-0726
     * @param grpBlDtListVO
     * @exception EventException
     */
    public void modifyBlObrdDt(GrpBlDtListVO grpBlDtListVO) throws EventException {
        try {
//        	Check Office Code
        	BookingUtil utilCmd = new BookingUtil();
        	MdmOrganizationVO mdmOrganizationVO = utilCmd.searchMdmOrzByOfcCd(grpBlDtListVO.getOblIssOfcCd());
        	if("Y".equals(grpBlDtListVO.getCreditChk())){
        		MdmOrganizationVO mdmOrganizationVO1 = utilCmd.searchMdmOrzByOfcCd(grpBlDtListVO.getPpdRcvOfcCd());
            	if(mdmOrganizationVO1 == null) {
            		throw new EventException(new ErrorHandler("BKG00905").getMessage());
            	}
        	}
        	if(mdmOrganizationVO == null) {
        		throw new EventException(new ErrorHandler("BKG00905").getMessage());
        	}
        	
            dbDao.modifyBlObrdDt(grpBlDtListVO);
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * house bl의 description 정보를 조회한다. -- UI_BKG-0360
     * M&D에 HB/L의 정보를 추가하기 위해 사용한다.
     * 
     * @param bkgNo
     * @return List<HblForMndVO>
     * @exception EventException
     */
    public List<HblForMndVO> searchHblForMnd(String bkgNo) throws EventException {
        try {
            return dbDao.searchHblForMnd(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * House B/L의 화주 정보에 대한 template 정보를 조회한다. -- UI_BKG-0399
     * @param shprNm
     * @param cneeNm
     * @param ofcCd
     * @return HblTmpltVO
     * @exception EventException
     */
    public HblTmpltVO searchHblTmplt(String shprNm, String cneeNm, String ofcCd) throws EventException {
        HblTmpltVO hblTmpltVO = new HblTmpltVO();
        try {
            List<BkgNvoccProfVO> bkgNvoccProfVOs = dbDao.searchHblCustTmplt(shprNm, cneeNm, ofcCd);
            List<BkgNvoccProfCntrMfVO> bkgNvoccProfCntrMfVOs = dbDao.searchHblCmTmplt(shprNm, cneeNm, ofcCd);
            
            hblTmpltVO.setBkgNvoccProfVOs(bkgNvoccProfVOs);
            hblTmpltVO.setBkgNvoccProfCntrMfVOs(bkgNvoccProfCntrMfVOs);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return hblTmpltVO;
    }

    /**
     * House B/L의 화주 정보에 대한 template 정보를 관리한다. -- UI_BKG-0399
     * @param hblTmpltVO
     * @param s_usr_id
     * @exception EventException
     */
    public void manageHblTmplt(HblTmpltVO hblTmpltVO, String s_usr_id) throws EventException {
        List<BkgNvoccProfVO> vo1 = hblTmpltVO.getBkgNvoccProfVOs();
        List<BkgNvoccProfCntrMfVO> vo2 = hblTmpltVO.getBkgNvoccProfCntrMfVOs();
        try {
            List<BkgNvoccProfVO> createCustList = new ArrayList<BkgNvoccProfVO>();
            List<BkgNvoccProfVO> modifyCustList = new ArrayList<BkgNvoccProfVO>();
            List<BkgNvoccProfVO> deleteCustList = new ArrayList<BkgNvoccProfVO>();
            int custVoCnt = vo1 == null ? 0 : vo1.size();
            log.debug("BkgNvoccProfVO -------------------------->" + custVoCnt);
            for(int i = 0; i < custVoCnt; i++) {
                log.debug("BkgNvoccProfVO -> " + vo1.get(i).getIbflag() + " : " + vo1.get(i).getProfSeq());
                vo1.get(i).setCreUsrId(s_usr_id);
                vo1.get(i).setUpdUsrId(s_usr_id);
                if("I".equals(vo1.get(i).getIbflag())) {
                    createCustList.add(vo1.get(i));
                } else if("U".equals(vo1.get(i).getIbflag())) {
                    modifyCustList.add(vo1.get(i));
                } else if("D".equals(vo1.get(i).getIbflag())) {
                    deleteCustList.add(vo1.get(i));
                }
            }
             
            List<BkgNvoccProfCntrMfVO> createCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            List<BkgNvoccProfCntrMfVO> modifyCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            List<BkgNvoccProfCntrMfVO> deleteCmList = new ArrayList<BkgNvoccProfCntrMfVO>();
            int cmVoCnt = vo2 == null ? 0 : vo2.size();
            log.debug("BkgNvoccProfCntrMfVO -------------------------------->" + cmVoCnt);        
            for(int i = 0; i < cmVoCnt; i++) {
                log.debug("BkgNvoccProfVO -> " + vo2.get(i).getIbflag() + " : " + vo2.get(i).getProfSeq());
                vo2.get(i).setCreUsrId(s_usr_id);
                vo2.get(i).setUpdUsrId(s_usr_id);
                if("I".equals(vo2.get(i).getIbflag())) {
                    createCmList.add(vo2.get(i));
                } else if("U".equals(vo2.get(i).getIbflag())) {
                    modifyCmList.add(vo2.get(i));
                } else if("D".equals(vo2.get(i).getIbflag())) {
                    deleteCmList.add(vo2.get(i));
                }
            }
            

             if(deleteCmList.size() > 0) {
                 dbDao.removeHblCmTmplt(deleteCmList);
             }
             if(deleteCustList.size() > 0) {
                 dbDao.removeHblCustTmplt(deleteCustList);
             }
             
             for(int i=0;i<createCustList.size();i++) {
                 dbDao.createHblCustTmplt(createCustList.get(i));
             }
             for(int i=0;i<modifyCustList.size();i++) {
                 dbDao.modifyHblCustTmplt(modifyCustList.get(i));
             }
             
             for(int i=0;i<createCmList.size();i++) {
                 dbDao.createHblCmTmplt(createCmList.get(i));
             }
             for(int i=0;i<modifyCmList.size();i++) {
                 dbDao.modifyHblCmTmplt(modifyCmList.get(i));
             }
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Empty Repo Booking의 containe 정보, B/L 정보를 insert update한다<br>
     * 
     * @author      KimByungKyu
     * @param       MtyBookingCreateVO mtyBookingCreateVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void createMtyRepoBlCntr(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException {
        try {       
            BookingUtil utilBC = new BookingUtil();
            if(mtyBookingCreateVO != null){
                BkgBlNoVO   bkgBlNoVO  = mtyBookingCreateVO.getBkgBlNoVO();
                MtyCntrVO[] mtyCntrVOs = mtyBookingCreateVO.getMtyCntrVOs();
                
                // 데이터 존재여부 확인
                if(mtyCntrVOs == null){
                    // 데이터 저장 실패(MtyCntrVO 정보 없음)               
                    throw new EventException((String)new ErrorHandler("BKG00391").getMessage());                        
                }
                if(bkgBlNoVO == null){
                    // 데이터 저장 실패(BkgBlNoVO 정보 없음)               
                    throw new EventException((String)new ErrorHandler("BKG00391").getMessage());                        
                }               
                String bkgNo = bkgBlNoVO.getBkgNo();
                
                // 010. creation일 때 addMtyBkgBlDoc()을 실행하여 미리 지정된 값으로 bkg_bl_doc에 insert한다.             
                dbDao.addMtyBkgBlDoc(bkgNo, account);
                // 020. searchMtyBlDesc() 결과를 string[]으로 받아 하나마다 공백을 넣어서 붙이되 4 row마다 new line을 추가한다.                
                String[] blDesc = dbDao.searchMtyBlDesc(bkgBlNoVO);
                String cmdtDesc = "";
                for(int i = 0 ; i < blDesc.length ; i++){
                    if(i < 1){
                        cmdtDesc = blDesc[i];
                    }else{
                        if(i > 1 && i%4 == 1){
                            cmdtDesc = cmdtDesc + "\n" + blDesc[i];
                        }else{
                            cmdtDesc = cmdtDesc + " " + blDesc[i];
                        }
                    }
                }
                // 020의 결과 + new line + "       EMPTY CONTAINER (HJ HANJIN SHIPPING)"를 붙여서 bkg_bl_mk_desc.cmdt_desc에 넣는다.
                cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (SM Line)";

                /* bkgBlMkDescVO */
                BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
                blMkDescVO.setBkgNo(bkgNo);
                blMkDescVO.setMkDesc("N/A");
                blMkDescVO.setCmdtDesc(cmdtDesc);
                blMkDescVO.setMkSeq("1");
                blMkDescVO.setCreUsrId(account.getUsr_id());
                blMkDescVO.setUpdUsrId(account.getUsr_id());                
                
                // 030. manageMnd()를 실행하여 bkg_bl_mk_desc에 inser한다.
                dbDao.addMnd(blMkDescVO, "N");

                String svrId = utilBC.searchPolSvcByBkgNo(bkgBlNoVO);
                
                log.debug("cntr length: "+mtyCntrVOs.length );
                for(int i = 0 ; i < mtyCntrVOs.length ; i++){
                    MtyCntrStsVO mtyCntrStsVO = dbDao.searchMtyCntrSts(mtyCntrVOs[i].getCntrNo(), "");
                    // 040. searchSocCntrCheck()의 결과가 true이면 [BKG00948]을 보여주고 중지한다.
//                    if(dbDao.searchMtySocCntrCheck(mtyCntrVOs[i].getCntrNo())){
                    if("Y".equals(mtyCntrStsVO.getMtySocCntr())){
                        throw new EventException((String)new ErrorHandler("BKG00948",new String[]{mtyCntrVOs[i].getCntrNo()}).getMessage());    
                    }
                    
                    // 050. searchMtyCntrReserve()의 결과가 있다면 [BKG00949]을 보여주고 중지한다.
                    String cntrBkgNo = dbDao.searchMtyCntrReserve(mtyCntrVOs[i].getCntrNo(), bkgNo, mtyBookingCreateVO.getMtyBookingVO().getPolCd(), mtyBookingCreateVO.getMtyBookingVO().getVslCd()+ mtyBookingCreateVO.getMtyBookingVO().getSkdVoyNo()+ mtyBookingCreateVO.getMtyBookingVO().getSkdDirCd());
                    if(cntrBkgNo != null && cntrBkgNo.length() > 0){
                        throw new EventException((String)new ErrorHandler("BKG00949",new String[]{mtyCntrVOs[i].getCntrNo(),cntrBkgNo}).getMessage());
                    }
                    
                    log.debug("cntr : "+ mtyCntrVOs[i].getCntrNo()+",bkg_no:"+mtyCntrStsVO.getBkgNo());
                    // 060. cnmvStsCd = "ID"이거나 "MT"가 아니면 [BKG00951]를 보여주고 중지한다.
                    // "VL"이면 bkg_no가 없어야 한다(bkg 없이 VL 된 것만 가능하다) 
                    if("VL".equals(mtyCntrStsVO.getCnmvStsCd()) && mtyCntrStsVO.getBkgNo() != null){
                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
                    }
                    if(!"ID".equals(mtyCntrStsVO.getCnmvStsCd()) && !"MT".equals(mtyCntrStsVO.getCnmvStsCd())){
                        throw new EventException((String)new ErrorHandler("BKG00951",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getCnmvStsCd()}).getMessage());
                    }
                    
                    // 070. searchMtyCntrSts()의 결과에서 cnmvStsCd, svrId를 받아서 svr_id와 searchSvrByOfc(login office)의 결과(server code)를 비교하여 다르면 [BKG00950]를 보여주고 중지한다.
                    // -> user Office의 svr에서 bkg의 pol의 svr로 변경 (
//                    String svrId = utilBC.searchSvrByOfc(account.getOfc_cd());
                    if(!svrId.equals(mtyCntrStsVO.getSvrId())){
                        throw new EventException((String)new ErrorHandler("BKG00950",new String[]{mtyCntrVOs[i].getCntrNo(),mtyCntrStsVO.getSvrId()}).getMessage());
                    } 
                    
                    // 080. searchMtyCntrSts()의 결과에서 aciac_div_cd(active/inactive)가 'A':ACT가 아니면 [BKG00952]를 보여주고 중지한다.
                    if(!"A".equals(mtyCntrStsVO.getAciacDivCd())){
                        throw new EventException((String)new ErrorHandler("BKG00952",new String[]{mtyCntrVOs[i].getCntrNo()}).getMessage());
                    }
                    // 090. addMtyBkgContainer를 실행하여 실제 bkg_container에 insert를 실행한다.
                    BkgContainerVO bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(bkgNo);
                    bkgContainerVO.setCntrNo(mtyCntrVOs[i].getCntrNo());
                    bkgContainerVO.setCntrTpszCd(mtyCntrStsVO.getCntrTpszCd());
                    bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());
                    
                    dbDao.addMtyBkgContainer(bkgContainerVO, account);
                }
                
            }else{
                // 데이터 저장 실패(MtyBookingCreate 정보 없음)                
                throw new EventException(new ErrorHandler("BKG00391").getMessage());
            }
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception e) {
            log.error("err " + e.toString(), e);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), e);
        }
    }   

    /**
     * house bl 정보를 조회한다.-- UI_BKG-0366
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @return HblVO
     * @exception EventException
     */
    public HblVO searchHbl(BkgBlNoVO bkgBlNoVO) throws EventException {
        HblVO hblVO = new HblVO();
        try {
            HblBkgInfoVO hblBkgInfoVO = dbDao.searchBkgInfoForHbl(bkgBlNoVO);
            hblBkgInfoVO.setHtsFlg(dbDao.searchHTSFlag(bkgBlNoVO));
            hblBkgInfoVO.setCndFlg(dbDao.searchCanadaFlob(bkgBlNoVO));
            List<HblCntrVO> hblCntrVOs = dbDao.searchHblCntrVOs(bkgBlNoVO);
            List<BkgCntrMfDescVO> cntrMfDescVOs = dbDao.searchBkgCntrMfDescVOs(bkgBlNoVO);
            List<HblDtlInfoVO> hblVOs = dbDao.searchHblDtlInfoVOs(bkgBlNoVO);

            hblVO.setHblBkgInfoVO(hblBkgInfoVO);
            hblVO.setHblCntrVOs(hblCntrVOs);
            hblVO.setBkgCntrMfDescVOs(cntrMfDescVOs);
            hblVO.setHblDtlInfoVOs(hblVOs);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return hblVO;
    }

    /**
     * House B/L, B/L Customer, Manifest 정보를 관리한다. -- UI_BKG-0366
     * @param HblVO hblVO
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHbl(HblVO hblVO, SignOnUserAccount account, String caFlg) throws EventException {
        //HblBkgInfoVO vo1 = hblVO.getHblBkgInfoVO();
        //List<BkgCntrMfDescVO> vo2 = hblVO.getBkgCntrMfDescVOs();
        List<HblDtlInfoVO> vo3 = hblVO.getHblDtlInfoVOs();
        try {
//            /* cm */
//            if(vo2 != null){
//                for(int i = 0; i < vo2.size(); i++) {
//                    log.debug("BkgCntrMfDescVO -> " + vo2.get(i).getCntrMfNo() + " : " + vo2.get(i).getIbflag());
//                    vo2.get(i).setCreUsrId(account.getUsr_id());
//                    vo2.get(i).setUpdUsrId(account.getUsr_id());
//                    if("I".equals(vo2.get(i).getIbflag())) {
//                        //insertCmList.add(vo2.get(i));
//                        dbDao.addCm(vo2.get(i), caFlg);
//                    } else if("U".equals(vo2.get(i).getIbflag())) {
//                        //updateCmList.add(vo2.get(i));
//                        dbDao.modifyCm(vo2.get(i), caFlg);
//                    } else if("D".equals(vo2.get(i).getIbflag())) {
//                        //deleteCmList.add(vo2.get(i));
//                        dbDao.removeCm(vo2.get(i), caFlg);
//                    }
//                }
//            }

            /* hbl */
            if(vo3 != null){
                List<BkgHblVO> updateHblList = new ArrayList<BkgHblVO>();
                List<BkgHblVO> deleteHblList = new ArrayList<BkgHblVO>();
                List<BkgHblCustVO> updateHblCustList = new ArrayList<BkgHblCustVO>();
                List<BkgHblCustVO> deleteHblCustList = new ArrayList<BkgHblCustVO>();
                for(int i = 0; i < vo3.size(); i++) {
                    log.debug("HblDtlInfoVO -> " + vo3.get(i).getHblSeq() + " : " + vo3.get(i).getIbflag());
                    BkgHblVO bkgHblVO = new BkgHblVO();
                    ObjectCloner.build(vo3.get(i), bkgHblVO);
                    bkgHblVO.setCreUsrId(account.getUsr_id());
                    bkgHblVO.setUpdUsrId(account.getUsr_id());
                    
                    BkgHblCustVO bkgHblShprVO = new BkgHblCustVO();
                    bkgHblShprVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblShprVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblShprVO.setBkgCustTpCd ("S");
                    bkgHblShprVO.setCustCntCd   ("");
                    bkgHblShprVO.setCustSeq     ("");
                    bkgHblShprVO.setCustNm      (vo3.get(i).getShprNm());
                    bkgHblShprVO.setCustAddr    (vo3.get(i).getShprAddr());
                    bkgHblShprVO.setCtyNm       (vo3.get(i).getShprCtyNm());
                    bkgHblShprVO.setSteCd       (vo3.get(i).getShprSteCd());
                    bkgHblShprVO.setCustCntCd   (vo3.get(i).getShprCntCd());
                    bkgHblShprVO.setCustZipId   (vo3.get(i).getShprZipCd());
                    bkgHblShprVO.setCreUsrId    (account.getUsr_id());
                    bkgHblShprVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblCneeVO = new BkgHblCustVO();
                    bkgHblCneeVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblCneeVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblCneeVO.setBkgCustTpCd ("C");
                    bkgHblCneeVO.setCustCntCd   ("");
                    bkgHblCneeVO.setCustSeq     ("");
                    bkgHblCneeVO.setCustNm      (vo3.get(i).getCneeNm());
                    bkgHblCneeVO.setCustAddr    (vo3.get(i).getCneeAddr());
                    bkgHblCneeVO.setCtyNm       (vo3.get(i).getCneeCtyNm());
                    bkgHblCneeVO.setSteCd       (vo3.get(i).getCneeSteCd());
                    bkgHblCneeVO.setCustCntCd   (vo3.get(i).getCneeCntCd());
                    bkgHblCneeVO.setCustZipId   (vo3.get(i).getCneeZipCd());
                    bkgHblCneeVO.setCreUsrId    (account.getUsr_id());
                    bkgHblCneeVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblNotiVO = new BkgHblCustVO();
                    bkgHblNotiVO.setBkgNo       (vo3.get(i).getBkgNo());
                    bkgHblNotiVO.setHblSeq      (vo3.get(i).getHblSeq());
                    bkgHblNotiVO.setBkgCustTpCd ("N");
                    bkgHblNotiVO.setCustCntCd   ("");
                    bkgHblNotiVO.setCustSeq     ("");
                    bkgHblNotiVO.setCustNm      (vo3.get(i).getNotiNm());
                    bkgHblNotiVO.setCustAddr    (vo3.get(i).getNotiAddr());
                    bkgHblNotiVO.setCtyNm       (vo3.get(i).getNotiCtyNm());
                    bkgHblNotiVO.setSteCd       (vo3.get(i).getNotiSteCd());
                    bkgHblNotiVO.setCustCntCd   (vo3.get(i).getNotiCntCd());
                    bkgHblNotiVO.setCustZipId   (vo3.get(i).getNotiZipCd());
                    bkgHblNotiVO.setCreUsrId    (account.getUsr_id());
                    bkgHblNotiVO.setUpdUsrId    (account.getUsr_id());

                    if("I".equals(vo3.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("U".equals(vo3.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("D".equals(vo3.get(i).getIbflag())) {
                        deleteHblList.add(bkgHblVO);
                        deleteHblCustList.add(bkgHblShprVO);
                    }
                }

                if(deleteHblCustList.size() > 0) {
                    dbDao.removeHblCusts(deleteHblCustList, caFlg);
                }
                if(deleteHblList.size() > 0) {
                    dbDao.removeHbls(deleteHblList, caFlg);
                }
                if(updateHblList.size() > 0) {
                    for(int i=0;i<updateHblList.size();i++){
                        dbDao.manageHbl(updateHblList.get(i), caFlg);
                    }                
                }
                if(updateHblCustList.size() > 0) {
                    for(int i=0;i<updateHblCustList.size();i++){
                        dbDao.manageHblCust(updateHblCustList.get(i), caFlg);
                    }                  
                }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * House B/L 정보를 저장가능한지 확인한다.-- UI_BKG-0366
     * @param hblVO
     * @exception EventException
     */
    public void validateHbl(HblVO hblVO) throws EventException {
        BookingUtil utilCmd = new BookingUtil();
        
        List<BkgCntrMfDescVO> vo2 = hblVO.getBkgCntrMfDescVOs();
        List<HblDtlInfoVO> vo3 = hblVO.getHblDtlInfoVOs();
        try {
            if(vo2 != null && vo2.size() > 0) {
                for(int i = 0; i < vo2.size(); i++) {
                    // 1. BookingUtil::validatePkgType ( pkgTpCd )
                    log.debug(" * PckTpCd : " + vo2.get(i).getPckTpCd());
                    boolean flag = utilCmd.validatePkgType(vo2.get(i).getPckTpCd());
                    if(!flag) {
                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"Package Type"}).getMessage());
                    }

//                     2. BookingUtil::searchHtsCodeDesc ( htsCd )
                    log.debug(" * HamoTrfCd : " + vo2.get(i).getHamoTrfCd());
                    if(vo2.get(i).getHamoTrfCd() != null && vo2.get(i).getHamoTrfCd().length() > 0) {
                        String extFlag = utilCmd.checkHtsCodeByCm("T", vo2.get(i).getHamoTrfCd());
                        if("N".equals(extFlag)) {
	                    	String msg = "\n'"+vo2.get(i).getHamoTrfCd()+"' for container " + vo2.get(i).getCntrNo();
	                        throw new EventException(new ErrorHandler("BKG01050", new String[]{"HTS",msg}).getMessage());
                        }
                    }
                    //CM과 동일하게 Validation 로직 삭제
                    // 3. BLDocumentationCMDBDAO::searchNcmCodeDesc ( ncmCd )
//                    log.debug(" * NcmNo : " + vo2.get(i).getNcmNo());
//                    if(vo2.get(i).getNcmNo() != null && vo2.get(i).getNcmNo().length() > 0) {
//                        String ncmDesc = utilCmd.searchNcmCodeDesc(vo2.get(i).getNcmNo());
//                        if(ncmDesc == null) {
//                            throw new EventException(new ErrorHandler("BKG01050", new String[]{"NCM"}).getMessage());
//                        }
//                    }
                }
            }
            
            if(vo3 != null && vo3.size() > 0) {
                for(int i = 0; i < vo3.size(); i++) {
                    // dbDao.validateCntSte ( cntCd , steCd );
                    boolean flag = utilCmd.validatePkgType(vo3.get(i).getPckTpCd());
                    if(!flag) {
                        throw new EventException(new ErrorHandler("BKG00530", new String[]{ vo3.get(i).getPckTpCd()}).getMessage());
                    }
          
                    // validateAmsRefNo
                    if(vo3.get(i).getCntrMfNo() != null && vo3.get(i).getCntrMfNo().length() > 0){
                        String amsRefNo = dbDao.validateCntrMfNo(vo3.get(i), "N");
                        log.debug("***** amsRefNo ***** : " + amsRefNo);
//                      if(amsRefNo == null || amsRefNo.length() == 0) {
//                          throw new EventException(new ErrorHandler("BKG00530", new String[]{ vo3.get(i).getHblMfTpCd()}).getMessage());
//                      }
                    }
                    log.debug("check shipper");
        			String shSteCd = vo3.get(i).getShprSteCd();
        			String shCntCd = vo3.get(i).getShprCntCd();
        			
                    //country code validation
        			if(shCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(shCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", shCntCd}).getMessage());
        				}
        			}
        			// State가 입력되었을경우 country와 state를 맞게 입력했는지 확인
        			if(shCntCd != null && shCntCd.length() > 0 && shSteCd != null && shSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(shCntCd, shSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{shSteCd, shCntCd}).getMessage());
        				}
        			}
        			
        			log.debug("check consignee");
        			String cnSteCd = vo3.get(i).getCneeSteCd();
        			String cnCntCd = vo3.get(i).getCneeCntCd();
        			
                    //country code validation
        			if(cnCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(cnCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Consignee", cnCntCd}).getMessage());
        				}
        			}
        			// State가 입력되었을경우 country와 state를 맞게 입력했는지 확인
        			if(cnCntCd != null && cnCntCd.length() > 0 && cnSteCd != null && cnSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(cnCntCd, cnSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{cnSteCd, cnCntCd}).getMessage());
        				}
        			}
        			
                    log.debug("check notify");
        			String nfSteCd = vo3.get(i).getNotiSteCd();
        			String nfCntCd = vo3.get(i).getNotiCntCd();
        			
                    //country code validation
        			if(nfCntCd.length()>0){
        				MdmCountryVO countryVO = utilCmd.searchCountryCode(nfCntCd);
        				if(countryVO == null){
        					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Notify", nfCntCd}).getMessage());
        				}
        			}
        			// State가 입력되었을경우 country와 state를 맞게 입력했는지 확인
        			if(nfCntCd != null && nfCntCd.length() > 0 && nfSteCd != null && nfSteCd.length() > 0){
        				if(utilCmd.searchStateByCountry(nfCntCd, nfSteCd).size() == 0 ){
        					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{nfSteCd, nfCntCd}).getMessage());
        				}
        			}
                }
            }
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }  
    }

    /**
     * bkg_bl_doc에 ORG_CNT_NM column을 update한다<br>
     * 
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String orgCntNm
     * @param       SignOnUserAccount account 
	 * @param 		String oldActCustCd
	 * @param 		String newActCustCd
     * @exception   EventException
     */
    public void modifyBkgBlDocByCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account, String oldActCustCd, String newActCustCd) throws EventException {
    	//BookingUtil utilBC = new BookingUtil();     
    	try {       
            dbDao.modifyBkgBlDocByCust(bkgBlNoVO, orgCntNm, account);
            
//2011.09.16 BKG_BL_MK_DESC update 제외-Exp Customer name             
//            if(!oldActCustCd.equals(newActCustCd)){
//            	
//            	String oldActCustNm = "";
//            	String newActCustNm = "";
//            	
//            	if(!oldActCustCd.equals("") && oldActCustCd.length() == 8){
//            		MdmCustVO oldMdmCustVO = utilBC.searchMdmCust(oldActCustCd.substring(0,2), oldActCustCd.substring(2,8), "N");
//            		
//            		if(oldMdmCustVO != null){
//            			oldActCustNm = oldMdmCustVO.getName();
//            		}
//         	}
//            	
//            	if(!newActCustCd.equals("") && newActCustCd.length() == 8){
//            		MdmCustVO newMdmCustVO = utilBC.searchMdmCust(newActCustCd.substring(0,2), newActCustCd.substring(2,8), "N");
//            		
//            		if(newMdmCustVO != null){
//            			newActCustNm = newMdmCustVO.getName();
//            		}
//            	}
//            	
//            	
//            	BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
//            	
//            	blMkDescVO.setBkgNo(bkgBlNoVO.getBkgNo());
//            	blMkDescVO.setUpdUsrId(account.getUsr_id());
//            	blMkDescVO.setBkgNoSplit(bkgBlNoVO.getCaFlg());
//            	int result = dbDao.modifyMndByCust(blMkDescVO, oldActCustCd, newActCustCd, oldActCustNm, newActCustNm);
//            	
//            	log.debug("result = "+ result);
//            	
//            	if(result == 0){
//
//                	log.debug("result = "+ result);
//                	
//            		blMkDescVO.setCreUsrId(account.getUsr_id());
//            		blMkDescVO.setCmdtDesc(!newActCustNm.equals("")?"exporter reference :"+newActCustNm:"");
//            		dbDao.addMndByCust(blMkDescVO);
//            	}
//            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * HBL에 Manifest File No를 생성하는 조건을 검사한다. -- UI_BKG-0366
     * @param BkgBlNoVO bkgBlNoVO
     * @exception EventException
     */
    public void validateMfNo(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            /*
             * 1. Canada를 경유하는 경우 Pass
             * 2. POD가 'IN'으로 시작하는 경우 Pass
             * 3. Pre Relay가 'IN'으로 시작하고 POD가 'US','CA','MX'일 때 filer가 '01'이 아니면 에러
             * 4. 나머지 경우 filer가 '01'이 아니면 에러
             */
            String cndFlg = dbDao.searchCanadaFlob(bkgBlNoVO);
            log.debug("=====> canada_flob : " + cndFlg);
            if("Y".equals(cndFlg)) return;

            MfNoVO mfNoVO = dbDao.validateMfNo(bkgBlNoVO);
            String pre_rly = mfNoVO.getPreRlyPortCd();
            String pod_cd  = mfNoVO.getPodCd();
            String usa_flg = mfNoVO.getUsaCstmsFileCd();
            String can_flg = mfNoVO.getCndCstmsFileCd();
            log.debug("=====> pre_rly   : " + pre_rly);
            log.debug("=====> pod_cd    : " + pod_cd);
            log.debug("=====> usa_flg   : " + usa_flg);
            log.debug("=====> can_flg   : " + can_flg);
            
            if(pod_cd.startsWith("IN")) return;

            if(pre_rly.startsWith("IN")){
                if(pod_cd.startsWith("US") ||
                   pod_cd.startsWith("CA") ||
                   pod_cd.startsWith("MX")){
                    if(!"1".equals(usa_flg) && !"1".equals(can_flg)){
                        throw new EventException(new ErrorHandler("BKG08032", new String[]{"can_flg=" +can_flg+ ", usa_flg="+usa_flg}).getMessage());
                    } 
                }
            }else{
                if(!"1".equals(usa_flg) && !"1".equals(can_flg)){
                    throw new EventException(new ErrorHandler("BKG08032", new String[]{"can_flg=" +can_flg+ ", usa_flg="+usa_flg}).getMessage());
                }   
            }
        } catch(EventException ex) {
            throw ex;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Nvocc File No 수정
     * @param bkgNo
     * @param hblSeq
     * @param nvoccFileNo
     * @param account
     * @param caFlg
     * @exception EventException
     */
    public void modifyNvoccFileNo(String bkgNo, String hblSeq, String nvoccFileNo, SignOnUserAccount account, String caFlg) throws EventException {
        try {
            /* house b/l에 filer number를 업데이트한다. */
            dbDao.modifyNvoccFileNo(bkgNo, hblSeq, nvoccFileNo, caFlg);
        } catch (DAOException ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } 
    }

    /**
     * Max HBL Manifest No를 생성한다.
     * @param bkgNo
     * @param blNo
     * @param caFlg
     * @return String
     * @exception EventException
     */
    public String searchMaxMfNo(String bkgNo, String blNo, String caFlg) throws EventException {
        String mfNo = null;
        try {
        	//Master B/L No.의 뒤에서 앞에서 9번째 자리까지 사용하며 10번째 자리를 A로 변경하고 
        	//두자리를 순서대로 01~99, A1~ZZ까지 (I,O 제외) 하여 순차적으로 생성한다.
            if(blNo == null || blNo.length() < 10){
                throw new EventException(new ErrorHandler("BKG08065").getMessage());
            }
            String maxMfNo = dbDao.searchMaxMfNo(bkgNo, caFlg);
            if(maxMfNo == null || "".equals(maxMfNo)) {
                String tmpHd = blNo.substring(0, 9);
                log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : ---");
                mfNo = tmpHd + "A01";
            } else {
                String tmpHd = maxMfNo.substring(0, 9);
                String tmpTl = maxMfNo.substring(9, 12);
                log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : " + tmpTl);
                mfNo = tmpHd + HblSeq.getHblSeq(tmpTl);
            }
            
            // 조회 결과가 N 일 때까지 반복수행
            boolean dupCheck = true;
            while(dupCheck) {
            	if("N".equals(checkMaxMfNoDup(mfNo))) {
            		dupCheck = false;
            	} else {
            		String tmpHd = mfNo.substring(0, 9);
                    String tmpTl = mfNo.substring(9, 12);
                    log.debug("** searchMaxMfNo : PREFIX : " + tmpHd + ", POSTFIX : " + tmpTl);
                    mfNo = tmpHd + HblSeq.getHblSeq(tmpTl);
            	}
            }
            
            if(mfNo == null || mfNo.endsWith("null")) {
                throw new EventException(new ErrorHandler("BKG08065").getMessage());
            }
        } catch(EventException ex) {
            throw ex;
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return mfNo;
    }   
    
    /**
     * MndTsSyFlg 를 생성한다.
     * @param bkgNo
     * @return String
     * @exception EventException
     */
    public String searchMndTsSyFlg(String bkgNo) throws EventException {
        String syFlg = null;
        try {
            
        	syFlg = dbDao.searchMndTsSyFlg(bkgNo);
      
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return syFlg;
    }   
    
    /**
     * Max HBL Manifest No의 Dup 검증.
     * @param mfNo
     * @return String
     * @exception EventException
     */
    public String checkMaxMfNoDup(String mfNo) throws EventException {
    	String maxMfNo = null;
        try {
        	maxMfNo = dbDao.checkMfNoDup(mfNo);            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return maxMfNo;
    }   

    /**
     * HBL Count를 수정한다.<br>
     * 
     * @author KimByungKyu
     * @param hblCount
     * @param bkgBlNoVO
     * @param account
     * @exception EventException
     */    
    public void modifyHblCount(int hblCount, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {       
            dbDao.modifyHblCount(hblCount, bkgBlNoVO, account);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     * bkg combine시 cancel되는 bkg의 package, measure, weight를 합산하여 master bkg에 더한다.
     * sourceBkg으로 bkg_bl_doc에서 pck_qty, meas_wgt, act_wgt를 차례로 읽어서 합한뒤 targetBkg의 bkg_bl_doc에 update한다.

     * @author KimByungKyu
     * @param sourceBkg
     * @param targetBkg
     * @param account
     * @exception EventException
     */
    public void combineBlDoc(BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
        try {
//          BookingUtil utilBC = new BookingUtil();

            if ( sourceBkg != null ) {
                WgtPkgMeasVO wgtPkgMeasVO = dbDao.searchPckMeasWgtSi(sourceBkg, targetBkg);

                for (int i=0;i<sourceBkg.length;i++) {
                    // combine시 house b/l 정보 전부 복사(정민정 과장님 확인, 20091013)
//                  String[] cntrNo = utilBC.searchCntrListByBkg(sourceBkg[i]);
//                  for (int j=0;j<cntrNo.length;j++) {
//                      SelectCntrVO selectCntrVO = new SelectCntrVO();
//                      selectCntrVO.setCntr_no(cntrNo[j]);
                        dbDao.copyHblByBkg(sourceBkg[i], targetBkg, "M", account);
                        dbDao.copyHblCustByBkg(sourceBkg[i], targetBkg, account);
//                  }
                }

                dbDao.modifyPkcMeasWgt(wgtPkgMeasVO, targetBkg, account);
            }

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }    

    /**
     * BlCopyOutVO을 조회합니다.<br>
     * 
     * @param String bkgNo
     * @return BlCopyOutVO
     * @exception EventException
     */
    public BlCopyOutVO searchForCopyBl(String bkgNo) throws EventException {
        BlCopyOutVO blCopyOutVo = null;
        BookingUtil utilCmd = null;
        BkgBlNoVO bkgBlNoVo = null;
        try {
            blCopyOutVo = dbDao.searchForCopyBl(bkgNo);
            if (null!=blCopyOutVo) {
                bkgBlNoVo = new BkgBlNoVO();
                bkgBlNoVo.setBkgNo(bkgNo);
                utilCmd = new BookingUtil();
                //bkgStatus조회
                blCopyOutVo.setBkgStatus(utilCmd.searchBkgStatusByBkg(bkgBlNoVo));
                //bdrFlg조회
                blCopyOutVo.setBdrFlg(utilCmd.searchBdrFlgByBkg(bkgBlNoVo));
                //shprCd조회
                blCopyOutVo.setShprCd(dbDao.searchShprCd(bkgNo));
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyOutVo;
    }

    /**
     * copy를 위한 BlCopyInVO을 확인합니다.<br>
     * 
     * @param BlCopyInVO blCopyInVo
     * @return BlCopyInVO
     * @exception EventException
     */
    public BlCopyInVO searchForCopyBl(BlCopyInVO blCopyInVo) throws EventException {
        BookingUtil utilCmd = null;
        BkgBlNoVO bkgBlNoVo = null;
        String bkgStatus = null;
        BlStatusVO blStatusVO = null;
        try {
            if (null!=blCopyInVo) {
                bkgBlNoVo = new BkgBlNoVO();
                bkgBlNoVo.setBkgNo(blCopyInVo.getCopyBkgNo());
                utilCmd = new BookingUtil();
                //10.searchBkgStatusByBkg
                bkgStatus = utilCmd.searchBkgStatusByBkg(bkgBlNoVo);
                //12.searchBlSts
                blStatusVO = dbDao.searchBlSts(blCopyInVo.getCopyBkgNo());
                if (null==bkgStatus) {
                    blCopyInVo.setResultMsg("BKG No. Not Found");
                } else if ("X".equalsIgnoreCase(bkgStatus)) {
                    blCopyInVo.setResultMsg("BKG Canceled");
                //11.searchBdrFlgByBkg
                } else if ("Y".equalsIgnoreCase(utilCmd.searchBdrFlgByBkg(bkgBlNoVo))) {
                    blCopyInVo.setResultMsg("BDR");
                } else if (null!=blStatusVO && "Y".equalsIgnoreCase(blStatusVO.getOblIssFlg())) {
                    blCopyInVo.setResultMsg("B/L Issued");
                //13.if custFlg='Y'
                } else if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg())) {
                    //14.searchShprCd
                    if (!blCopyInVo.getShprCd().equalsIgnoreCase(dbDao.searchShprCd(blCopyInVo.getCopyBkgNo()))) {
                        blCopyInVo.setResultMsg("Shipper Code Unmatched");
                    }
                }
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyInVo;
    }

    /**
     * BL Copy UI에서 호출 된다.
     * MND 정보를 복사한다. -- UI_BKG-0648
     * @param blCopyInVo
     * @param account
     * @return BlCopyInVO
     * @exception EventException
     */
    public BlCopyInVO copyDocByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException {
        int docUpdCnt = 0;
        int mndUpdCnt = 0;
        try {
            if (null!=blCopyInVo) {
                //21-1.if custFlg='Y' or descFlg='Y'
                if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg()) || "Y".equalsIgnoreCase(blCopyInVo.getDescFlg())) {
                    //21-2.update blDoc
                    docUpdCnt = dbDao.modifyBlDocByBlCopy(blCopyInVo, account);
                    if (0==docUpdCnt) {
                        blCopyInVo.setResultMsg("BKG NO NOT FOUND");
                    }
                }
                //22.if markFlg='Y' or descFlg='Y'
                if ("Y".equalsIgnoreCase(blCopyInVo.getMarkFlg()) || "Y".equalsIgnoreCase(blCopyInVo.getDescFlg())) {
                    //23.update mnd
                    mndUpdCnt = dbDao.modifyMndByBlCopy(blCopyInVo, account);
                    if (0==mndUpdCnt) {
                        //24.add mnd
                        dbDao.addMndByBlCopy(blCopyInVo, account);
                    }
                }
            }
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return blCopyInVo;
    }

    /**
     * bkg_bl_doc의 CA 시작 정보(C/A No, C/A User, office, date)를 수정함<br>
     * 
     * @author Lee NamKyung
     * @param bkgBlNoVO
     * @param account
     * @exception EventException
     */
    public void modifyCaStart(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
        try {       
            dbDao.modifyCaStart(bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    } 
    
    /**
     * C/A를 위해 booking 관련 BlDocumantationBC 책임table을 복사한다.
     * 
     * @author Lee NamKyung
     * @param bkgBlNoVO
     * @param copyTypeCd
     * @exception EventException
     */
    public void createBlCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            if ("BKG".equals(copyTypeCd)) {
                //01. 
                dbDao.modifyBlDocCA   (bkgBlNoVO, copyTypeCd);
                //02. 
                dbDao.removeMkDescCA  (bkgBlNoVO, copyTypeCd); 
                //03. 
                dbDao.removeHblCustCA (bkgBlNoVO, copyTypeCd);
                //04.  
                dbDao.removeHblCA     (bkgBlNoVO, copyTypeCd);
                //05. 
                dbDao.removeLicCA     (bkgBlNoVO, copyTypeCd);
                //06. 
                dbDao.removeCntrSealCA(bkgBlNoVO, copyTypeCd);
                //07.
                dbDao.removeCmDtlCA   (bkgBlNoVO, copyTypeCd);
                //08. 
                dbDao.removeCmCA      (bkgBlNoVO, copyTypeCd);                
                //09. 
                dbDao.removeCntrCA    (bkgBlNoVO, copyTypeCd);
            } else {
                //01. 
                dbDao.createBlDocCA(bkgBlNoVO, copyTypeCd);
            }

            //02. 
            dbDao.createMkDescCA  (bkgBlNoVO, copyTypeCd);
            //03. 
            dbDao.createHblCA     (bkgBlNoVO, copyTypeCd);
            //04. 
            dbDao.createHblCustCA (bkgBlNoVO, copyTypeCd);
            //05. 
            dbDao.createLicCA     (bkgBlNoVO, copyTypeCd);
            //06. 
            dbDao.createCntrCA    (bkgBlNoVO, copyTypeCd);
            //07. 
            dbDao.createCmCA      (bkgBlNoVO, copyTypeCd);
            //08. 
            dbDao.createCmDtlCA   (bkgBlNoVO, copyTypeCd);
            //09. 
            dbDao.createCntrSealCA(bkgBlNoVO, copyTypeCd);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * 이전에 기록했던 CA 시작 정보(C/A No, C/A User, office, date)를 bkg_bl_doc에서 지운다.<br>
     * 
     * @author Lee NamKyung
     * @param bkgBlNoVO
     * @exception EventException
     */ 
    public void modifyCaComplete(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            dbDao.modifyCaComplete(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * C/A를 위해 booking 관련 BlDocumantationBC 책임table을 삭제한다.
     * 
     * @author      Lee NamKyung
     * @param       bkgBlNoVO
     * @param       copyTypeCd
     * @exception   EventException
     */
    public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
        try {
            //01. 
            dbDao.removeLicCA     (bkgBlNoVO, copyTypeCd);              
            //02. 
            dbDao.removeMkDescCA  (bkgBlNoVO, copyTypeCd); 
            //03. 
            dbDao.removeCntrSealCA(bkgBlNoVO, copyTypeCd);              
            //04. 
            dbDao.removeCmDtlCA   (bkgBlNoVO, copyTypeCd);            
            //05. 
            dbDao.removeCmCA      (bkgBlNoVO, copyTypeCd);  
            //06. 
            dbDao.removeCntrCA    (bkgBlNoVO, copyTypeCd);
            //07. 
            dbDao.removeHblCustCA (bkgBlNoVO, copyTypeCd); 
            //08. 
            dbDao.removeHblCA     (bkgBlNoVO, copyTypeCd);
            //09. 
            dbDao.removeBlDocCA   (bkgBlNoVO, copyTypeCd);
            
            //10. 
            dbDao.modifyCaComplete(bkgBlNoVO);
            
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * empty repo Booking을 split한다.<br>
     * 
     * @author      KimByungKyu
     * @param       MtyBookingSplitVO mtyBookingSplitVO
     * @param       SignOnUserAccount account
     * @exception   EventException
     */
    public void splitMtyRepoBlCntr(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
        try {
            MtyCntrVO[] mtyCntrVOs = mtyBookingSplitVO.getMtyCntrVOs();
            String bkgNo    = mtyBookingSplitVO.getBkgBlNoVO().getBkgNo();
            String newBkgNo = mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo();
            
            BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
            newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
            newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());
            
            // 23. New Booking Bl Doc 저장
            dbDao.addMtyBkgBlDoc(newBkgNo, account);
            
            for(int i = 0 ; i < mtyCntrVOs.length ; i++){
                String cntrNo = mtyCntrVOs[i].getCntrNo();
                if(!"VL".equals(mtyCntrVOs[i].getCnmvStsCd())){
                    throw new EventException((String)new ErrorHandler("BKG00999",new String[]{cntrNo}).getMessage());
                }else{
                    // 17. searchMtyCntrCyc                 
                    MtyCntrCycVO mtyCntrCycVO = dbDao.searchMtyCntrCyc(bkgNo, cntrNo);
                    
                    BkgContainerVO bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(newBkgNo);
                    bkgContainerVO.setCntrNo(mtyCntrVOs[i].getCntrNo());
                    bkgContainerVO.setCnmvStsCd(mtyCntrCycVO.getCnmvStsCd());   
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());                

                    if(mtyCntrCycVO!=null){
                    	bkgContainerVO.setCntrTpszCd(mtyCntrVOs[i].getCntrTpszCd());
                    } else {
                        // 19. searchMtyCntrSts
                        MtyCntrStsVO mtyCntrStsVO = dbDao.searchMtyCntrSts(cntrNo, bkgNo);
                        
                        bkgContainerVO.setMcntrBdlNo(mtyCntrStsVO.getMcntrBdlNo());
                        bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());   
                    }                   
                    // 20. New Split Booking Container 저장.
                    dbDao.addMtyBkgContainer(bkgContainerVO, account);   
                    
                    // 21. 원본 Booking Container 삭제.
                    dbDao.removeMtyCntr(cntrNo, mtyBookingSplitVO.getBkgBlNoVO());
                }
            }            

            // 24.  searchMtyBlDesc
            String[] newBlDesc = dbDao.searchMtyBlDesc(newBkgBlNoVO);
            String cmdtDesc = "";
            for(int i = 0 ; i < newBlDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = newBlDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + newBlDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + newBlDesc[i];
                    }
                }
            }
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (SM Line)";
            
            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            blMkDescVO.setBkgNo(newBkgBlNoVO.getBkgNo());
            blMkDescVO.setMkDesc("N/A");
            blMkDescVO.setCmdtDesc(cmdtDesc);
            blMkDescVO.setMkSeq("1");
            blMkDescVO.setCreUsrId(account.getUsr_id());
            blMkDescVO.setUpdUsrId(account.getUsr_id());                
            
         // 25. addMnd
            dbDao.addMnd(blMkDescVO,"N");
            
            // 27. 원본 Booking removeMnd
            dbDao.removeMnd(bkgNo);
            
            // 28. 
            String[] orgBlDesc = dbDao.searchMtyBlDesc(mtyBookingSplitVO.getBkgBlNoVO());

            cmdtDesc = "";
            for(int i = 0 ; i < orgBlDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = orgBlDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + orgBlDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + orgBlDesc[i];
                    }
                }
            }
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (SM Line)";
            
            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO2 = new BkgBlMkDescVO();
            blMkDescVO2.setBkgNo(bkgNo);
            blMkDescVO2.setMkDesc("N/A");
            blMkDescVO2.setCmdtDesc(cmdtDesc);
            blMkDescVO2.setMkSeq("1");
            blMkDescVO2.setCreUsrId(account.getUsr_id());
            blMkDescVO2.setUpdUsrId(account.getUsr_id());               
            // 29. addMnd
            dbDao.addMnd(blMkDescVO2,"N");
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }           

    /**
     * empty Repo Booking의 container 정보, B/L 정보를 insert update delete한다.<br>
     * 
     * @author      KimByungKyu
     * @param       RepoBkgForUpdateVO repoBkgForUpdateVO
     * @param		String trunkVvd
     * @param       SignOnUserAccount account
     * @return		List<CusCtmMovementVO>
     * @exception   EventException
     */
    public List<CusCtmMovementVO> manageEmptyCntr(RepoBkgForUpdateVO repoBkgForUpdateVO, String trunkVvd, SignOnUserAccount account) throws EventException {

        String cntrNo = "";
        try {
            BookingUtil utilBC = new BookingUtil();             

            String bkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
            RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
            RepoBkgVO repoBkgVO = repoBkgForUpdateVO.getRepoBkgVO();   
            
            boolean isMasterBkgNo = false;
            String masterBkgNo = "";
            BkgBlNoVO masterBkgBlNoVO = new BkgBlNoVO();
            
            if(bkgNo.length() == 11){
                isMasterBkgNo = true;
                masterBkgNo = bkgNo;
            }else if(bkgNo.length() == 13){
                masterBkgNo = bkgNo.substring(0,11);
                masterBkgBlNoVO.setBkgNo(masterBkgNo);
            }else{
                // 진행되는 BKG의 master BKG을 조회하기 위해 searchMtyMasterBkg()를 실행한다             
                masterBkgNo = utilBC.searchSplitMstBkgNo(bkgNo);
                if(masterBkgNo == null || masterBkgNo.length() < 1){
                    isMasterBkgNo = true;
                }else{
                    masterBkgBlNoVO.setBkgNo(masterBkgNo);
                }
            }   
            
            String svrId = utilBC.searchSvrByOfc(account.getOfc_cd());
            
            String [] arrCntrList = utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
            //list로 변환(혹시 빠를까 싶어서)
            List<String> cntrList = new ArrayList<String>();
            for(int icnt=0;icnt<arrCntrList.length;icnt++){
            	cntrList.add(arrCntrList[icnt]);
            }
            
            boolean isInsertCntr = true;
//            String cntrNo = "";
            String cntrBkgNo = "";
			int cntrIdx = 0;
			int vlCntrCnt = 0;

            MtyCntrStsVO mtyCntrStsVO = null;
            BkgContainerVO bkgContainerVO = null;
            List<CusCtmMovementVO> ctmMvmtVOs = new ArrayList<CusCtmMovementVO>();

            if(repoCntrVOs == null || repoCntrVOs.length==0){
            	return ctmMvmtVOs;
            }
            for(int i = 0 ; i < repoCntrVOs.length ; i++){
                cntrNo = repoCntrVOs[i].getCntrNo() + repoCntrVOs[i].getCntrNoPst();

            	// 32. 전달받은 cntr의 상태를 확인하기 위해 searchMtyCntrSts()를 실행한다.
                mtyCntrStsVO = dbDao.searchMtyCntrSts(cntrNo, masterBkgNo);                               

                if("D".equals(repoCntrVOs[i].getIbflag())){
                	//master bkg일 때만 VL때 삭제금지, split BKG이라면 VL이어도 진행하여 master bkg으로 복사되게함
                	if(isMasterBkgNo){
						if("VL".equals(mtyCntrStsVO.getCnmvStsCd())){
							/*
							 * MTY Repo BKG에서의 CNTR detach 요건 변경(CHM-201004922)
							 * CNTR가 VL 상태일 때 mvmt의 event location과 BKG POL이 같은 지역인 경우 VL mvmt를 우선 삭제해야 BKG에서 CNTR detach 가능
							 */
							BkgBlNoVO polBkg = new BkgBlNoVO();
							polBkg.setBkgNo(bkgNo);
							if(mtyCntrStsVO.getSvrId().equals(utilBC.searchPolSvcByBkgNo(polBkg))){
								if("N".equals(mtyCntrStsVO.getPreStsFlg())){
									throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());
								}
							}
	                    }
                	} 
                    if(!isMasterBkgNo){
                    	// VD/MT 가 아닌것만 삭제 가능
                    	if("MT".equals(mtyCntrStsVO.getCnmvStsCd()) || "VD".equals(mtyCntrStsVO.getCnmvStsCd())){
                    		throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());
                    	}
                        // 38. split의 origin bkg으로 cntr를 보냄
                        dbDao.copyMtyCntrToMst(bkgNo, cntrNo, masterBkgBlNoVO, account);
                    }                     
                    // 39. cntr 삭제
                    dbDao.removeMtyCntr(cntrNo, repoBkgForUpdateVO.getBkgBlNoVO());                                  
                }else{
                    // pre_sts_flg = 'N' : bkg이 붙어있지 않음(업무상 미리 진행 시킨 Movement Status일 경우)
                    // 전달받은 cntr가 Shipper's Own인지 확인하기 위해 searchMtySocCntrCheck()를 실행한다. -> searchMtyCntrSts()에서 함께 조회
                    if("Y".equals(mtyCntrStsVO.getMtySocCntr())){
//                      if(dbDao.searchMtySocCntrCheck(cntrNo)){
                        throw new EventException((String)new ErrorHandler("BKG00948",new String[]{cntrNo}).getMessage());   
                    }       
                    if("Y".equals(mtyCntrStsVO.getImdtExtFlg())){
                    	throw new EventException((String)new ErrorHandler("BKG02025",new String[]{cntrNo}).getMessage());
                    }
                    // searchMtyCntrSts()의 결과에서 aciac_div_cd(active/inactive)가 'A':ACT가 아니면 [BKG00952]를 보여주고 중지한다.
                    if(!"A".equals(mtyCntrStsVO.getAciacDivCd())){
                        throw new EventException((String)new ErrorHandler("BKG00952",new String[]{cntrNo}).getMessage());
                    }                   

                	// UPDATE 일때는 적용하지 않음
                	if("I".equals(repoCntrVOs[i].getIbflag())){
	                	// Container의 Movement의 Location Check 추가.(20091117)
	                	if(!mtyCntrStsVO.getLocCd().equals(repoBkgVO.getBkgPolCd())){
	                		throw new EventException((String)new ErrorHandler("BKG02024",new String[]{cntrNo}).getMessage());
	                	}                		
	                	// 31. 전달받은 cntr가 이미 다른 Booking에 예약중인지 확인하기 위해 searchMtyCntrReserve()를 실행한다.
	                	cntrBkgNo = dbDao.searchMtyCntrReserve(cntrNo, repoBkgVO.getBkgNo(), repoBkgVO.getBkgPolCd(), repoBkgVO.getBkgTrunkVvd());
	                    if(cntrBkgNo != null && cntrBkgNo.length() > 0){
	                    	if(!cntrBkgNo.equals(masterBkgNo)){ //master bkg에 있는 cntr는 예약으로 판단하지 않고 가져온다.
	                    		throw new EventException((String)new ErrorHandler("BKG00949",new String[]{cntrNo,cntrBkgNo}).getMessage());
	                    	}
	                    }    

                		// master bkg에 있는 cntr를 넣을 경우 VL일 때만 가능함(masterBkg는 반드시 실제 bkg이어야함) -> split bkg일 때
                		if(cntrBkgNo != null && masterBkgNo != null && cntrBkgNo.equals(masterBkgNo) && masterBkgNo.length()>10){ 
                			if(!"VL".equals(mtyCntrStsVO.getCnmvStsCd())){
		                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
		                    }
                		} else {       			
    	                    // "VL"이면 bkg 없이 VL 된 것만 가능:PRE_STS_FLG = Y
		                    if("VL".equals(mtyCntrStsVO.getCnmvStsCd()) && "N".equals(mtyCntrStsVO.getPreStsFlg())){
		                    	throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());                    	
		                    }
		                    // cnmvStsCd = "ID"이거나 "MT"가 아니면 [BKG00951]를 보여주고 중지한다.
		                    if(!"ID".equals(mtyCntrStsVO.getCnmvStsCd()) && !"MT".equals(mtyCntrStsVO.getCnmvStsCd()) && !"VL".equals(mtyCntrStsVO.getCnmvStsCd()) && !"VL".equals(mtyCntrStsVO.getCnmvStsCd())){
		                        throw new EventException((String)new ErrorHandler("BKG00951",new String[]{cntrNo,mtyCntrStsVO.getCnmvStsCd()}).getMessage());
		                    }
                		}
                		
                		// searchMtyCntrSts()의 결과에서 cnmvStsCd, svrId를 받아서 svr_id와 searchSvrByOfc(login office)의 결과(server code)를 비교하여 다르면 [BKG00950]를 보여주고 중지한다.
	                    if(!svrId.equals(mtyCntrStsVO.getSvrId())){
	                        throw new EventException((String)new ErrorHandler("BKG00950",new String[]{cntrNo,mtyCntrStsVO.getSvrId()}).getMessage());
	                    } 
                	}
                    
                    // master BKG이 따로 있는 경우 removeMtyCntr()을 실행하여 master쪽에서 해당 cntr을 삭제한다
                    if(!isMasterBkgNo){
                        dbDao.removeMtyCntr(cntrNo, masterBkgBlNoVO);
                    }
                    // addMtyBkgContainer를 실행하여 실제 bkg_container에 insert를 실행한다.
                    bkgContainerVO = new BkgContainerVO();
                    bkgContainerVO.setBkgNo(bkgNo);
                    bkgContainerVO.setCntrNo(cntrNo);
                    bkgContainerVO.setCntrTpszCd(repoCntrVOs[i].getTpszCd());
                    bkgContainerVO.setCnmvStsCd(mtyCntrStsVO.getCnmvStsCd());
                    bkgContainerVO.setMcntrBdlNo(repoCntrVOs[i].getBdlNo());
                    if("Y".equals(repoCntrVOs[i].getBdlBtmFlg()) || "1".equals(repoCntrVOs[i].getBdlBtmFlg())){
                    	bkgContainerVO.setBdlBtmFlg("Y");
                    }else{
                    	bkgContainerVO.setBdlBtmFlg("N");
                    }
                    bkgContainerVO.setCreUsrId(account.getUsr_id());
                    bkgContainerVO.setUpdUsrId(account.getUsr_id());
                    
                    isInsertCntr = true;
                    
                    cntrIdx = -1;
                    cntrIdx = cntrList.indexOf(cntrNo);
                    if(-1<cntrIdx){
                    	isInsertCntr = false;
                    	cntrList.remove(cntrIdx);
                    }
//                    for(int icnt=0;icnt<cntrList.length;icnt++){
//                    	if(bkgContainerVO.getCntrNo().equals(cntrList[icnt])){
//                    		isInsertCntr = false;
//                    		break;
//                    	}
//                    }
                    
                    if(isInsertCntr){
                    	dbDao.addMtyBkgContainer(bkgContainerVO, account);                    	
                    } else {
                    	dbDao.modifyMtyBkgContainer(bkgContainerVO);
                    }
                    
					if("VL".equals(mtyCntrStsVO.getCnmvStsCd())){
						ctmMvmtVOs.add(vlCntrCnt, new CusCtmMovementVO());
						ctmMvmtVOs.get(vlCntrCnt).setBkgNo(bkgNo);
						ctmMvmtVOs.get(vlCntrCnt).setBlNo(repoBkgForUpdateVO.getBkgBlNoVO().getBlNo());
						ctmMvmtVOs.get(vlCntrCnt).setCntrNo(cntrNo);
						ctmMvmtVOs.get(vlCntrCnt).setMvmtStsCd(mtyCntrStsVO.getCnmvStsCd());
						ctmMvmtVOs.get(vlCntrCnt).setCnmvYr(mtyCntrStsVO.getCnmvYr());
						ctmMvmtVOs.get(vlCntrCnt).setCnmvIdNo(mtyCntrStsVO.getCnmvIdNo());
						ctmMvmtVOs.get(vlCntrCnt).setCrntVslCd(trunkVvd.substring(0, 4));
						ctmMvmtVOs.get(vlCntrCnt).setCrntSkdVoyNo(trunkVvd.substring(4, 8));
						ctmMvmtVOs.get(vlCntrCnt).setCrntSkdDirCd(trunkVvd.substring(8, 9));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkVslCd(trunkVvd.substring(0, 4));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkSkdVoyNo(trunkVvd.substring(4, 8));
						ctmMvmtVOs.get(vlCntrCnt).setTrnkSkdDirCd(trunkVvd.substring(8, 9));
						vlCntrCnt++;
					}
                }
            }
            
            // 40. searchMtyBlDesc() 결과를 string[]으로 받아 하나마다 공백을 넣어서 붙이되 4 row마다 new line을 추가한다.             
            String[] blDesc = dbDao.searchMtyBlDesc(repoBkgForUpdateVO.getBkgBlNoVO());
            String cmdtDesc = "";
            for(int i = 0 ; i < blDesc.length ; i++){
                if(i < 1){
                    cmdtDesc = blDesc[i];
                }else{
                    if(i > 1 && i%4 == 1){
                        cmdtDesc = cmdtDesc + "\n" + blDesc[i];
                    }else{
                        cmdtDesc = cmdtDesc + " " + blDesc[i];
                    }
                }
            }
            // 40의 결과 + new line + "       EMPTY CONTAINER (SM Line)"를 붙여서 bkg_bl_mk_desc.cmdt_desc에 넣는다.
            cmdtDesc = cmdtDesc + "\n" + "       EMPTY CONTAINER (SM Line)";

            /* bkgBlMkDescVO */
            BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            blMkDescVO.setBkgNo(bkgNo);
            blMkDescVO.setMkDesc("N/A");
            blMkDescVO.setCmdtDesc(cmdtDesc);
            blMkDescVO.setMkSeq("1");
            blMkDescVO.setCreUsrId(account.getUsr_id());
            blMkDescVO.setUpdUsrId(account.getUsr_id());                
            
            // 41. modifyMnd()를 실행하여 bkg_bl_mk_desc에 inser한다.
            dbDao.modifyMnd(blMkDescVO,"N");

            return ctmMvmtVOs;
        } catch (EventException ex) {
            throw ex;                   
        } catch (DAOException ex) {
        	log.error(cntrNo);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
	 * bkg_bl_doc 테이블를 update한다.<br>
	 * 
	 * @param BkgCoffTmVO[] bkgCoffTmVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgClose (BkgCoffTmVO[] bkgCoffTmVOs, SignOnUserAccount account)throws EventException{
		try {
			for ( int i=0; i<bkgCoffTmVOs.length; i++ ) {
				dbDao.modifyBkgCoffTm(bkgCoffTmVOs[i],account);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * BL DOC 정보 수정
	 * 
	 * @param bkgBlDocVO
	 * @throws EventException
	 */
	public void modifyBlDoc(BkgBlDocVO bkgBlDocVO) throws EventException {
		
		try {
			
			dbDao.modifyBlDoc(bkgBlDocVO);
			
		}catch (DAOException de) 
		{
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), de);
		} 
		catch (Exception ex) 
		{
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getMessage(), ex);
		}
	}
	
    /**미사용(20100402 류대영)
     * Booking Close 여부를 판단한다.(ESM_BKG_007901)<br>
     * @author KimByungKyu
     * @param  BkgBlNoVO bkgBlNoVO
     * @param  SignOnUserAccount account
     * @return  String
     * @exception EventException
     */
//    public String searchBkgClose(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
//    	String bkgClzFlg = "";
//        try {
//        	bkgClzFlg = dbDao.searchBkgClose(bkgBlNoVO);
//        	if("Y".equals(bkgClzFlg)){
//        		// Booking Close Change Flag 변경
//        		dbDao.modifyBkgCloseChange(bkgBlNoVO, account);
//
//        		// Save 성공이후 성공 Message를 보인 후, GW mail을 보내도록 처리한다
//        	}
//        } catch (DAOException ex) {
//         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        } catch (Exception ex) {
//         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//        }
//        return bkgClzFlg;
//    }
    
	/**
	 * 수정 이벤트 처리<br>
	 * 인도네시아 세관 전송 대상 데이터 수정<br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account)
			throws EventException {
		try {
			for (int i = 0; i < manifestModificationVOs.length; i++) {
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("I")) {
					((IndonesiaManifestModificationVO) manifestModificationVOs[i]).setCreUsrId(account.getUsr_id());
					dbDao.addManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i]);
				}
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("U")) {
					((IndonesiaManifestModificationVO) manifestModificationVOs[i]).setUpdUsrId(account.getUsr_id());
					dbDao.modifyManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i], account);
				}
				if (((IndonesiaManifestModificationVO) manifestModificationVOs[i]).getIbflag().equals("D")) {
					dbDao.removeManifest((IndonesiaManifestModificationVO) manifestModificationVOs[i]);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}    

	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * container BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String usrId
	 * @exception EventException
	 */	
	public void modifyCntrCFM(String bkgNo, String flag, String usrId) throws EventException {
		
		try {
			dbDao.modifyCntrCFM(bkgNo, flag, usrId);
			//dbDao.modifyBKGBDR(vos[i]);	
		} catch(EventException ex) {
			throw ex;
    
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}	
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596)<br>
	 * BKG_BL_DOC BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String hisFlg
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyBKGBDR(String bkgNo, String flag, String hisFlg, String usrId) throws EventException {
		
		try {
			dbDao.modifyBKGBDR(bkgNo, flag, hisFlg, usrId);
		} catch(EventException ex) {
			throw ex;
    
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}
	
	/**
	 * Vessel Schedule B/L Data Release 저장이벤트를 처리한다. (ESM_BKG_0596_01)<br>
	 * BKG_BL_DOC BDR을 처리.
	 * 
	 * @param String bkgNo
	 * @param String flag
	 * @param String hisFlg
	 * @param String usrId
	 * @param String bdrRsnCd
	 * @param String bdrRsnRmk
	 * @exception EventException
	 */
	public void modifyBKGBDRRHQ(String bkgNo, String flag, String hisFlg, String usrId, String bdrRsnCd, String bdrRsnRmk) throws EventException {
		
		try {
			dbDao.modifyBKGBDRRHQ(bkgNo, flag, hisFlg, usrId, bdrRsnCd, bdrRsnRmk);
		} catch(EventException ex) {
			throw ex;
    
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}

	/**
     * eBKG에서 House B/L, B/L Customer, Manifest 정보를 관리한다. -- UI_BKG-0366
     * @param HblVO hblVO
	 * @param XterRqstNoVO rqstNoVO 
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageHblByXter(HblVO hblVO, XterRqstNoVO rqstNoVO, SignOnUserAccount account, String caFlg) throws EventException{
        List<HblDtlInfoVO> hblDtlVO = hblVO.getHblDtlInfoVOs();
        try {
            /* hbl */
            if(hblDtlVO != null){
                List<BkgHblVO> updateHblList = new ArrayList<BkgHblVO>();
                List<BkgHblVO> deleteHblList = new ArrayList<BkgHblVO>();
                List<BkgHblCustVO> updateHblCustList = new ArrayList<BkgHblCustVO>();
                List<BkgHblCustVO> deleteHblCustList = new ArrayList<BkgHblCustVO>();
                for(int i = 0; i < hblDtlVO.size(); i++) {
                    BkgHblVO bkgHblVO = new BkgHblVO();
                    ObjectCloner.build(hblDtlVO.get(i), bkgHblVO);
                    bkgHblVO.setXterSiNo(hblDtlVO.get(i).getXterSiNo());
                    bkgHblVO.setXterSiSeq(hblDtlVO.get(i).getXterSiSeq());
                    bkgHblVO.setCreUsrId(account.getUsr_id());
                    bkgHblVO.setUpdUsrId(account.getUsr_id());
                    
                    BkgHblCustVO bkgHblShprVO = new BkgHblCustVO();
                    bkgHblShprVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblShprVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblShprVO.setBkgCustTpCd ("S");
                    bkgHblShprVO.setCustCntCd   ("");
                    bkgHblShprVO.setCustSeq     ("");
                    bkgHblShprVO.setCustNm      (hblDtlVO.get(i).getShprNm());
                    bkgHblShprVO.setCustAddr    (hblDtlVO.get(i).getShprAddr());
                    bkgHblShprVO.setCreUsrId    (account.getUsr_id());
                    bkgHblShprVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblCneeVO = new BkgHblCustVO();
                    bkgHblCneeVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblCneeVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblCneeVO.setBkgCustTpCd ("C");
                    bkgHblCneeVO.setCustCntCd   ("");
                    bkgHblCneeVO.setCustSeq     ("");
                    bkgHblCneeVO.setCustNm      (hblDtlVO.get(i).getCneeNm());
                    bkgHblCneeVO.setCustAddr    (hblDtlVO.get(i).getCneeAddr());
                    bkgHblCneeVO.setCreUsrId    (account.getUsr_id());
                    bkgHblCneeVO.setUpdUsrId    (account.getUsr_id());

                    BkgHblCustVO bkgHblNotiVO = new BkgHblCustVO();
                    bkgHblNotiVO.setBkgNo       (hblDtlVO.get(i).getBkgNo());
                    bkgHblNotiVO.setHblSeq      (hblDtlVO.get(i).getHblSeq());
                    bkgHblNotiVO.setBkgCustTpCd ("N");
                    bkgHblNotiVO.setCustCntCd   ("");
                    bkgHblNotiVO.setCustSeq     ("");
                    bkgHblNotiVO.setCustNm      (hblDtlVO.get(i).getNotiNm());
                    bkgHblNotiVO.setCustAddr    (hblDtlVO.get(i).getNotiAddr());
                    bkgHblNotiVO.setCreUsrId    (account.getUsr_id());
                    bkgHblNotiVO.setUpdUsrId    (account.getUsr_id());

                    if("I".equals(hblDtlVO.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("U".equals(hblDtlVO.get(i).getIbflag())) {
                        updateHblList.add(bkgHblVO);
                        updateHblCustList.add(bkgHblShprVO);
                        updateHblCustList.add(bkgHblCneeVO);
                        updateHblCustList.add(bkgHblNotiVO);
                    } else if("D".equals(hblDtlVO.get(i).getIbflag())) {
                        deleteHblList.add(bkgHblVO);
                        deleteHblCustList.add(bkgHblShprVO);
                    }
                }

                if(deleteHblCustList.size() > 0) {
                    dbDao.removeHblCusts(deleteHblCustList, caFlg);
                }
                if(deleteHblList.size() > 0) {
                    dbDao.removeHbls(deleteHblList, caFlg);
                }
                if(updateHblList.size() > 0) {
                    for(int i=0;i<updateHblList.size();i++){
                        dbDao.manageHblByXter(updateHblList.get(i), caFlg);
                    }                
                }
                if(updateHblCustList.size() > 0) {
                    for(int i=0;i<updateHblCustList.size();i++){
                        dbDao.manageHblCustByXter(updateHblCustList.get(i), caFlg);
                    }                  
                }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
     * eBKG에서 Export licens 정보를 관리한다. -- UI_BKG-0229-04
     * @param BkgBlNoVO bkgBlNoVO
	 * @param AlpsXptImpLicListVO[] alpsXptImpLicListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageXptLicByXter(BkgBlNoVO bkgBlNoVO, AlpsXptImpLicListVO[] alpsXptImpLicListVOs, SignOnUserAccount account) throws EventException{
        try {        	
            dbDao.removeXptLicNoByXter(bkgBlNoVO);
            if(alpsXptImpLicListVOs != null && alpsXptImpLicListVOs.length>0){
	            for(int i=0;i<alpsXptImpLicListVOs.length;i++){
	            	if(("US").equals(alpsXptImpLicListVOs[i].getCntCd()) && ("").equals(alpsXptImpLicListVOs[i].getAesTpCd()) && ("").equals(alpsXptImpLicListVOs[i].getAesExptCtnt())){
	            		continue;	
	            	}
	            	if(("CA").equals(alpsXptImpLicListVOs[i].getCntCd()) && ("").equals(alpsXptImpLicListVOs[i].getCaedTpCd()) && ("").equals(alpsXptImpLicListVOs[i].getNdrRefCtnt())){
	            		continue;	
	            	}
	            	dbDao.addXptLicNoByXter(bkgBlNoVO, alpsXptImpLicListVOs[i], account);
	            }
            }
        } catch(DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
	/**
     * eBKG에서 BL Rider 를 저장한다. -- UI_BKG-0229-04
     * @param BlRiderVO[] blRiderVOs
     * @param SignOnUserAccount account
	 * @param String bkgNo
     * @exception EventException
     */
	public void manageBlrider(BlRiderVO[] blRiderVOs,SignOnUserAccount account,String bkgNo) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == manageBlRider  ]==========");
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code

		try {
			List<BlRiderVO> insertVoList = new ArrayList<BlRiderVO>();
//			int save_id_cnt = 0;
			for (int i = 0; i < blRiderVOs.length; i++) {

				if (blRiderVOs[i].getIbflag().equals("I")) {

					insertVoList.add(blRiderVOs[i]);
				}
			}
			dbDao.addBlRider(insertVoList,use_id,ofc_cd,bkgNo);

		} catch (DAOException ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");


		
	}
	
	
	/**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * Last VVD POL이 VNSGN Y2 이고 POD 가 KHPNH Y4 인 모든 Booking 에 문구 삽입
     * 
     * @param MndVO mndVO
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageMndCmdtDescKHPNH(MndVO mndVO, SignOnUserAccount account, String caFlg) throws EventException {
 
        /* bkgBlMkDescVO */
        BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
        BkgBlMkDescVO blMkDescOutVO = new BkgBlMkDescVO();
        blMkDescVO.setBkgNo(mndVO.getBkgNo());
        blMkDescVO.setMkSeq("1");
        blMkDescVO.setCreUsrId(account.getUsr_id());
        blMkDescVO.setUpdUsrId(account.getUsr_id());
       
        try {
        	blMkDescOutVO = dbDao.searchMndCmdtDesc(mndVO.getBkgNo(), caFlg);
        	if(null == blMkDescOutVO){
            	blMkDescVO.setCmdtDesc(Constants.CMDT_DESC_ATTD_KHPNH);
        		dbDao.addMndCmdtDesc(blMkDescVO, caFlg);
        	}else if(null != blMkDescOutVO){
        		String cmdtDesc = blMkDescOutVO.getCmdtDesc();
        		cmdtDesc = ((blMkDescOutVO.getCmdtDesc() == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_KHPNH, ""));
            	blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_KHPNH);
        		dbDao.modifyMndCmdtDesc(blMkDescVO, caFlg);
        	}
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * MND 정보를 수정한다.-- UI_BKG-0079-06
     * POD 가 JOAQJ 일 경우  Tariff 항목 추가 (SC일경우 shipper 나 consignee가 NBCO , RFA일때는 Shipper가 NBCO 일때만)
     * 
     * @param String bkgNo
     * @param SignOnUserAccount account
     * @param String caFlg
     * @exception EventException
     */
    public void manageMndCmdtDescJOAQJ(String bkgNo, SignOnUserAccount account, String caFlg) throws EventException {
 
        /* bkgBlMkDescVO */
        BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
        BkgBlMkDescVO blMkDescOutVO = new BkgBlMkDescVO();
        blMkDescVO.setBkgNo(bkgNo);
        blMkDescVO.setMkSeq("1");
        blMkDescVO.setCreUsrId(account.getUsr_id());
        blMkDescVO.setUpdUsrId(account.getUsr_id());
        String custFlg = "";
        
        try {
        	blMkDescOutVO = dbDao.searchMndCmdtDesc(bkgNo, caFlg);
        	custFlg =  dbDao.searchRvisCntrCustTpCd(bkgNo, caFlg);
        	
        	if((null == blMkDescOutVO) && ("Y".equals(custFlg)||"K".equals(custFlg))){
        		log.debug("__________(add)SC-계약자가 NBCO일때만 RFA-shipper가 NBCO 일때만 문구가 보이도록함______(Showing)");
            	blMkDescVO.setCmdtDesc(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO);
        		dbDao.addMndCmdtDesc(blMkDescVO, caFlg);
        	}else if((null != blMkDescOutVO) && ("Y".equals(custFlg)||"K".equals(custFlg))){
        		log.debug("__________(Update)SC-계약자가 NBCO일때만 RFA-shipper가 NBCO 일때만 문구가 보이도록함______(Showing)");
        		String cmdtDesc = blMkDescOutVO.getCmdtDesc();
        		cmdtDesc = ((blMkDescOutVO.getCmdtDesc() == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO, ""));
        		cmdtDesc = ((blMkDescOutVO.getCmdtDesc() == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ, ""));

        		blMkDescVO.setCmdtDesc(cmdtDesc + Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO);

        		dbDao.modifyMndCmdtDesc(blMkDescVO, caFlg);
        	}
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
      
    /**
     * BKG Interface Management 조회.
     * 
     * @param BkgIfManageInVO bkgIfManageInVO
     * @return List<BkgIfManageListVO>
     * @exception EventException
     */
    public List<BkgIfManageListVO> searchBkgIfList(BkgIfManageInVO bkgIfManageInVO) throws EventException {
        try {
        	return dbDao.searchBkgIfList(bkgIfManageInVO);
            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * ESM_BKG_3004 에서 edi 전송 대상 리스트를 조회한다.
	 * 
	 * @author Kim tae kyoung
	 * @param BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO
	 * @param String msgTypeCd
	 * @return List<BkgIfManagerEdiVO>
	 * @throws EventException
	 */
	public List<BkgIfManagerEdiVO> searchBkgIfList01(BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO, String msgTypeCd) throws EventException{
		try {
			return dbDao.searchBkgIfList01(bkgIfManagerEdiInputVO, msgTypeCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_3004 : 310 EDI 전송 <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String bkgManagerEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = null;
		BkgManagerEdiMultiBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new BkgManagerEdiMultiBackEndJob(bkgBlNoVO, custTpIdVO, typeGbn, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "BkgManagerEdiMultiBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
	}
	
	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchBkgSendList(String key) throws EventException {
		String result = null;
		try {
			result = eaiDao.searchSendBkgCustEdiMulti(key);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
	}
	
	
    /**
     * P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String searchPoExist(String bkgNo) throws EventException {
        String poNm = null;
        try {
            
        	poNm = dbDao.searchPoExist(bkgNo);
      
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return poNm;
    }   
    
    
    /**
     * RVIS_CNTR_CUST_TP_CD 조회.
     * @param String bkgNo
     * @param String caFlg
     * @return String 
     * @throws EventException
     */
    public String searchRvisCntrCustTpCd(String bkgNo, String caFlg) throws EventException {
    	String custFlg = "N";
        try {
        	custFlg = dbDao.searchRvisCntrCustTpCd(bkgNo,caFlg);            
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return custFlg;
    } 
    
    
    /**
     * 위험화물 문구가 포함된 BKG의 문구중 가장 등급이 높은 문구를 조회한다.
     * @param BkgDescVO bkgDescVO
     * @return String[]
     * @throws EventException
     */
    public String[] searchkeywordByBkg(BkgDescVO bkgDescVO) throws EventException {
        String keyword[] = null;
        try { 
             
        	keyword = dbDao.searchkeywordByBkg(bkgDescVO);
      
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return keyword;
    }  
    
    
    /**
     * Booking Vvd 정보를 조회한다.(ESM_BKG_0079_06)<br>
     * @param String bkgNo
     * @param String caFlg
     * @return List<VslSkdVO>
     * @throws EventException
     */
    public List<VslSkdVO> searchVvdSkdForTsRouteKNPNH(String bkgNo, String caFlg) throws EventException {
        try {           
        	return dbDao.searchVvdSkdForTsRouteKNPNH(bkgNo, caFlg);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * POL이 나이지리아일 경우 EXS 데이터 존재여부<br>
     * POD이 나이지리아일 경우 ENS 데이터 존재여부<br>
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String []chkNgExsEnsNo(String bkgNo) throws EventException {
        try {           
        	return dbDao.chkNgExsEnsNo(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * POL이 토고일 경우 ECTN 데이터 존재여부<br>
     * POD이 토고일 경우 ECTN 데이터 존재여부<br>
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String []chkTgEctnNo(String bkgNo) throws EventException {
        try {           
        	return dbDao.chkTgEctnNo(bkgNo);
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
	/**
	 * BL body에 찍힐 WPM관련 문구를 생성한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String oldDesc
	 * @param String usrId
	 * @throws EventException
	 */
	public void modifyBlDescByWpm(BkgBlNoVO bkgBlNoVO, String oldDesc, String usrId) throws EventException {
		
		try {
			
			MndVO mndVO = dbDao.searchMnd(bkgBlNoVO);
			String polCd = mndVO.getPolCd();
			String podCd = mndVO.getPodCd();
            if((polCd !=null && polCd.length()> 2 && "BR".equals(polCd.substring(0, 2))) ||
                    (podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2)))){
            	
    			BLDocumentationCMDBDAO cmDao = new BLDocumentationCMDBDAO();
    			String newDesc = cmDao.searchWpmDescForBl(bkgBlNoVO, "N");
    			String cmdtDesc = mndVO.getDgCmdtDesc();
    			
    	        BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
    	        blMkDescVO.setBkgNo(mndVO.getBkgNo());	        
    	        cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(oldDesc, "") + newDesc;
    	        blMkDescVO.setCmdtDesc(cmdtDesc);

    	        dbDao.modifyBlDescByWpm(blMkDescVO, bkgBlNoVO.getCaFlg());
            }


			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
     
	}
    
	/**
	 * CNTR 콤보를 위해 컨테이너를 검색한다.
	 * @param String bkgNo
	 * @return List<CntrComboVO>
	 * @throws EventException
	 */
	public List<CntrComboVO> searchCntrList(String bkgNo) throws EventException{
		try{
			List<CntrComboVO> list = dbDao.searchCntrList(bkgNo);
			return list;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * US filer가 01이면서 C/M 탭에 Self가 찍혀있다면 
     * BKG Creation의 화면에 저장된 BKG,SI Contact 이메일로 notification을 보낸다
     * @param String bkgNo
     * @param String caFlg
     * @return String[]
     * @throws EventException
     */
    public String[] checkSelfFilingCM(String bkgNo, String caFlg) throws EventException {
        try {
        	return dbDao.checkSelfFilingCM(bkgNo,caFlg);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * 이메일 보내기
     * @param String bkgNo
     * @param String emailAdd
     * @param CmSelfMailVO cmSelfMailVO
     * @return BkgNtcHisVO
     * @throws EventException
     */
    public BkgNtcHisVO sendChkSelfCMByEmail (String bkgNo, String emailAdd, CmSelfMailVO cmSelfMailVO) throws EventException {
    	BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
    	String ntcKndCd = null;
    	//Container manifest Self Notification
    	ntcKndCd = "CS";
    	
    	try {
    		
			eaiDao.sendChkSelfCMByEmail(bkgNo, emailAdd, cmSelfMailVO);
    		bkgNtcHisVO.setBkgNo(bkgNo);
    		bkgNtcHisVO.setNtcKndCd(ntcKndCd);
    		bkgNtcHisVO.setNtcViaCd("M");
    		bkgNtcHisVO.setNtcEml(emailAdd);
    		bkgNtcHisVO.setSndId("SYSTEM");
			bkgNtcHisVO.setSndUsrId("SYSTEM");
			bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			bkgNtcHisVO.setCreUsrId("SYSTEM");
			bkgNtcHisVO.setUpdUsrId("SYSTEM");
			log.debug("@@@@@@ BCImpl : history log finish");
			
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
    	
    	return bkgNtcHisVO;
    }
    
    /**
     * Self auto notification 내용 검색
     * @param String bkgNo
     * @param String caFlg
     * @return CmSelfMailVO
     * @exception DAOException
     */
    public CmSelfMailVO searchContentsForSelfMail(String bkgNo, String caFlg) throws EventException {
        try {
        	return dbDao.searchContentsForSelfMail(bkgNo,caFlg);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * CM에서 Self로 인해 auto email이 나갔었는지 여부 체크
     * @param String bkgNo
     * @return String
     * @throws EventException
     */
    public String chkCsEmailHisoty(String bkgNo) throws EventException {
        try {
        	return dbDao.chkCsEmailHisoty(bkgNo);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * CM에서 Self가 있는지의 여부만 판단
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @exception DAOException
     */
    public String chkSelfFlgCM(String bkgNo, String caFlg) throws EventException {
        try {
        	return dbDao.chkSelfFlgCM(bkgNo,caFlg);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }	
	

	/**
	 * XTER VGM Request List 정보를 조회 한다.
	 * 
	 * @param XterVgmRqstListInputVO xterVgmRqstListInputVO
	 * @return List<XterVgmRqstListVO>
	 * @throws EventException
	 */
	public List<XterVgmRqstListVO> searchXterVgmList(XterVgmRqstListInputVO xterVgmRqstListInputVO) throws EventException {
		List<XterVgmRqstListVO> list = null;
		try {
			list = dbDao.searchXterVgmList(xterVgmRqstListInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * XTER VGM 정보를 Update 전 validation 확인 한다.
	 * 
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @return XterVgmInfoValidationVO
	 * @throws EventException
	 */
	public XterVgmInfoValidationVO searchXterVgmInfoValidation(XterVgmRqstListVO xterVgmRqstListVO) throws EventException {
		String rjctRsn = "";
		String vgmMinMax = "";
		String wgtCompare = "";
		String cntrTpszCd = "";
		
		XterVgmInfoValidationVO xterVgmInfoValidationVO = null;
		List<MstContainerVO> list = null;
		try {
			//validation
			xterVgmInfoValidationVO = dbDao.searchXterVgmInfoValidation(xterVgmRqstListVO);
			list = utilDao.searchTypeSizeByCntr(xterVgmRqstListVO.getCntrNo());
			if (list != null && list.size() > 0) {
				MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
				cntrTpszCd = mstContainerVO.getCntrTpszCd();
				
				//SOC cntr의 경우는 min/max 검사하지 않음
				if(!"Y".equalsIgnoreCase(cmDao.checkSocCntr(xterVgmRqstListVO.getCntrNo()))){
					vgmMinMax = cmDao.checkVGMMinMax(xterVgmRqstListVO.getVgmWgt(), cntrTpszCd, xterVgmRqstListVO.getVgmWgtUtCd());
				}else{
					vgmMinMax = "Y";
				}
			}
			wgtCompare = cmDao.checkCntrWgtWithVgmWgt(xterVgmRqstListVO.getBkgNo(), xterVgmRqstListVO.getCntrNo(), xterVgmRqstListVO.getVgmWgt());
			
			if(xterVgmInfoValidationVO.getBkgStsCd()==null || "".equals(xterVgmInfoValidationVO.getBkgStsCd())|| "N".equals(xterVgmInfoValidationVO.getBkgStsCd())){
				rjctRsn = "Booking no. is not Exists.";
			}else if("X".equals(xterVgmInfoValidationVO.getBkgStsCd())){
				rjctRsn = "Booking is canceled.";
			}else if(xterVgmInfoValidationVO.getCnmvStsCd()==null || "".equals(xterVgmInfoValidationVO.getCnmvStsCd())|| "N".equals(xterVgmInfoValidationVO.getCnmvStsCd())){
				rjctRsn = "Container no. is not Exists.";
			}else if("XX".equals(xterVgmInfoValidationVO.getCnmvStsCd())){
				rjctRsn = "Status of Container is XX.";
			}else if("N".equals(xterVgmInfoValidationVO.getBkgCntrExists())){
				xterVgmInfoValidationVO.setNeedAtchCntr("Y");//Container Attach 해야 함
				//rjctRsn = "Container is not attached Booking.";
			}else if(!"Y".equalsIgnoreCase(vgmMinMax)){
				if("MIN".equalsIgnoreCase(vgmMinMax))
					rjctRsn = "Inputted VGM is less than minimum weight.";
				else if("MAX".equalsIgnoreCase(vgmMinMax))
					rjctRsn = "Inputted VGM is more than maximum weight.";
				else
					rjctRsn = "VGM data/spec or CNTR does not exist.";
			}
			else if(!"Y".equalsIgnoreCase(wgtCompare)){
				rjctRsn = "VGM must be heavier than weight.";
			}
			xterVgmInfoValidationVO.setRjctRsnRmk(rjctRsn);
			 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return xterVgmInfoValidationVO;
	}
	
	/**
	 * XTER VGM 정보를 Update 한다.
	 * 
	 * @param XterVgmRqstListVO xterVgmRqstListVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void uploadXterVgmInfo(XterVgmRqstListVO xterVgmRqstListVO, SignOnUserAccount account) throws EventException {
		try {
			String rjtRsn = "";
			if(xterVgmRqstListVO.getRjctRsnRmk()!=null){
				rjtRsn = xterVgmRqstListVO.getRjctRsnRmk();
			}
			//vgm data update
			if("".equals(rjtRsn)){
				int updCnt = dbDao.uploadXterVgmInfo(xterVgmRqstListVO, account);
				if(updCnt > 0){
					xterVgmRqstListVO.setVgmUpldStsCd("F"); 
					xterVgmRqstListVO.setRjctRsnRmk("");
				}else{
					xterVgmRqstListVO.setVgmUpldStsCd("R"); 
					xterVgmRqstListVO.setRjctRsnRmk("Updating failed.");
				}
			}else{
				xterVgmRqstListVO.setVgmUpldStsCd("R"); 
				xterVgmRqstListVO.setRjctRsnRmk(rjtRsn);
			}
			//result update
			dbDao.modifyXterVgmUploadRslt(xterVgmRqstListVO, account);
			 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * Export Import 인바운드가 터키인 BKG의 Consignee, Notify tax id 데이터 유무 판단
     * @param String bkgNo
     * @param String caFlg
     * @return String
     * @throws DAOException
     */
    public String checkTurkeyTaxId(String bkgNo, String caFlg) throws EventException {
        try {
        	return dbDao.checkTurkeyTaxId(bkgNo,caFlg);  

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
}