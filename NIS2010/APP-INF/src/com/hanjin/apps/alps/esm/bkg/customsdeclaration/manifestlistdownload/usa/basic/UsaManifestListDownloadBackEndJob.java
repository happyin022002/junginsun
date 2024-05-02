/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaManifestListDownloadBackEndJob.java
 *@FileTitle : UsaManifestListDownloadBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.17
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.07.17 이수빈
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2013.05.09 김보배 [CHM-201324329] AMS - CUSTOMS DATA DOWNLOAD 화면 오류 수정 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCmVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCntrSealNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaOldInbondModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Subin
 * @see ESM_BKG_0210EventResponse,UsaManifestListDownloadBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UsaManifestListDownloadBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestListDetailVO[] manifestListDetailVOs;
	private SignOnUserAccount account;
	private String pgmNo;

	private UsaOldInbondModiVO oldInbondModiVO = null;
	private List<UsaOldInbondModiVO> oldInbondModiVOs = new ArrayList<UsaOldInbondModiVO>();
//	private UsaOldCntrModiVO oldCntrModiVO = null;
//	private List<UsaOldCntrModiVO> oldCntrModiVOs = new ArrayList<UsaOldCntrModiVO>();

	// Database Access Object
	private UsaManifestListDownloadDBDAO dbDao = null;

	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * @param ManifestListDetailVO[] detailVOs
	 * @param SignOnUserAccount account
	 */
	public void setManifestListDetailVO(ManifestListDetailVO[] detailVOs, SignOnUserAccount account,
			UsaManifestListDownloadDBDAO dbDao) {
		if(detailVOs != null){
			ManifestListDetailVO[] tmpVOs = new ManifestListDetailVO[detailVOs.length];
			System.arraycopy(detailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
		this.account = account;
		this.dbDao = dbDao;
	}

	/**
	 * 화면ID세팅
	 * 
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndJob Start
	 * 
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		if (pgmNo.equals("ESM_BKG_0210"))
		{
			try
			{
				manageManifest(this.manifestListDetailVOs);
			}
			catch (EventException ee)
			{
				log.error("err " + ee.toString(), ee);
				throw ee;
			}
		}

		return null;
	}

	/**
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs) throws EventException {

		/*
		 *  1. 처리 대상에서 Master BL 문자열을 만든다. mblCondVOs > 일괄 삭제/등록을 위해 사용
		 *  2. 처리 대상에서 House Bl 문자열을 만든다.  hblCondVOs > 일괄 삭제/등록을 위해 사용
		 * */
		String result = "SUCCESS";
		
		try
		{
			UsaManifestListDetailVO usaVO = (UsaManifestListDetailVO) manifestListDetailVOs[0];
			UsaManifestListCondVO[] condVOs = new UsaManifestListCondVO[manifestListDetailVOs.length];
			UsaManifestListCondVO condVO = null;

			String vslCd = usaVO.getVslCd();
			String skdVoyNo = usaVO.getSkdVoyNo();
			String skdDirCd = usaVO.getSkdDirCd();
			String cstmsPortCd = null;
			String actFileSkdDirCd = usaVO.getIbflag();

			if (usaVO.getPodCd().startsWith("US") || usaVO.getVPod().startsWith("US"))
			{
				cstmsPortCd = usaVO.getPodCd();
			}
			else
			{
				cstmsPortCd = dbDao.searchCstmsPortCd(usaVO);
			}

			List<String> blNoList = null;
			List<String> bkgNoList = null;
			List<UsaManifestListCondVO> mblCondVOs = new ArrayList<UsaManifestListCondVO>();
			List<UsaManifestListCondVO> hblCondVOs = new ArrayList<UsaManifestListCondVO>();

			/*
			 * M.B/L BKG_NO,BL_NO List 구하고, ConditionVO 리스트 생성
			 * mblCondVOs 일괄 삭제/등록을 위해 BL No./BKG No.문자열 생성 'BOM214002300','BOM214545100','DLDT20044700'
			 */
			blNoList = generateBlBkgList(manifestListDetailVOs, "M", "BL");
			bkgNoList = generateBlBkgList(manifestListDetailVOs, "M", "BKG");
			for (int i = 0; i < bkgNoList.size(); i++)
			{
				condVO = new UsaManifestListCondVO();

				condVO.setVslCd(vslCd);
				condVO.setSkdVoyNo(skdVoyNo);
				condVO.setSkdDirCd(skdDirCd);
				condVO.setBlNo(blNoList.get(i));
				condVO.setBkgNo(bkgNoList.get(i));
				condVO.setBlType("M");

				mblCondVOs.add(condVO);
			}

			/*
			 * H.B/L BKG_NO,BL_NO List 구하고, ConditionVO 리스트 생성
			 * hblCondVOs 일괄 삭제를 위해 BL No./BKG No.문자열 생성 'SHUR50663A01','SHUR50663A02'
			 */
			blNoList = generateBlBkgList(manifestListDetailVOs, "H", "BL");
			bkgNoList = generateBlBkgList(manifestListDetailVOs, "H", "BKG");
			for (int i = 0; i < bkgNoList.size(); i++)
			{
				condVO = new UsaManifestListCondVO();

				condVO.setVslCd(vslCd);
				condVO.setSkdVoyNo(skdVoyNo);
				condVO.setSkdDirCd(skdDirCd);
				condVO.setBlNo(blNoList.get(i));
				condVO.setBkgNo(bkgNoList.get(i));
				condVO.setBlType("H");

				hblCondVOs.add(condVO);
			}

			for (int i = 0; i < manifestListDetailVOs.length; i++)
			{
				usaVO = (UsaManifestListDetailVO) manifestListDetailVOs[i];
				condVO = new UsaManifestListCondVO();

				condVO.setVslCd(vslCd);
				condVO.setSkdVoyNo(skdVoyNo);
				condVO.setSkdDirCd(skdDirCd);
				condVO.setCstmsPortCd(cstmsPortCd);
				condVO.setBlNo(usaVO.getBlNos());
				condVO.setBkgNo(usaVO.getBkgNo());
				condVO.setBlType(usaVO.getBlType());
				condVO.setCaNo(usaVO.getCaNo());
				condVO.setCaIssDt(usaVO.getCaIssDt());
				condVO.setCaFlg(usaVO.getCaFlg());
				condVO.setUsrId(account.getUsr_id());

				condVOs[i] = condVO;
			}

			List<UsaBlInfoVO> addBlInfoVOs = new ArrayList<UsaBlInfoVO>();
			List<UsaBlInfoVO> addHblInfoVOs = new ArrayList<UsaBlInfoVO>();
			List<UsaBlInfoVO> usaBlInfoVOs = new ArrayList<UsaBlInfoVO>();
			List<UsaBlInfoVO> usaHblInfoVOs = new ArrayList<UsaBlInfoVO>();
			UsaBlInfoVO usaBlInfoVO = null;
			UsaBlInfoVO usaHblInfoVO = null;

			/*
			 * M.B/L 다운로드
			 */
			for (int j = 0; j < condVOs.length; j++)
			{
				condVO = condVOs[j];

				if ("M".equals(condVO.getBlType()))
				{
					usaBlInfoVO = dbDao.searchBl(condVO);
					usaBlInfoVO.setActFileSkdDirCd(actFileSkdDirCd);

					// 조회된 B/L 데이터가 없을 경우
					if (usaBlInfoVO == null)
					{
						throw new EventException(new ErrorHandler("BKG00628", "B/L No. is " + condVO.getBlNo())
								.getMessage());
					}

					condVO.setPodCd(usaBlInfoVO.getPodCd());
					condVO.setDelCd(usaBlInfoVO.getDelCd());
					condVO.setPodNodCd(usaBlInfoVO.getPodNodCd());
					condVO.setDelNodCd(usaBlInfoVO.getDelNodCd());


					this.setInbondData(usaBlInfoVO, condVO);
					/**************************************************
					 * 2010.04.08 추가<BR>
					 * CSTMS_LOC_CD 판단
					 * Local의 경우 : BKG_BOOKING 의 POD_CD<BR>
					 * IPI의 경우 : BKG_CSTMS_ADV_BL의 HUB_LOC_CD
					 **************************************************/
//					usaBlInfoVO.setCstmsLocCd("");
					if("".equals(usaBlInfoVO.getCstmsLocCd())){
						if ("L".equals(oldInbondModiVO.getIbdClrTpCd()))
						{
							usaBlInfoVO.setCstmsLocCd(usaBlInfoVO.getPodCd());
						}
						else if ("I".equals(oldInbondModiVO.getIbdClrTpCd()))
						{
							usaBlInfoVO.setCstmsLocCd(usaBlInfoVO.getHubLocCd());
						}
					}
					
					usaBlInfoVOs.add(usaBlInfoVO);
					oldInbondModiVOs.add(oldInbondModiVO);
//					if (oldCntrModiVO != null && !"".equals(oldCntrModiVO.getHamoCmdtCd()))
//					{
//						oldCntrModiVOs.add(oldCntrModiVO);
//					}

				} // if end

			} // for end

			if (usaBlInfoVOs.size() > 0)
			{
				dbDao.removeCustomerByBl(mblCondVOs);
				dbDao.removeContainer(mblCondVOs);
				dbDao.removeContainerSealNo(mblCondVOs);
				dbDao.removeCMByBl(mblCondVOs);
				// dbDao.removeAdvancedBlByBl ( mblCondVOs );

				// BKG_BOOKING => BKG_CSTMS_ADV_BL
				for (int i = 0; i < usaBlInfoVOs.size(); i++)
				{
					if (dbDao.modifyAdvancedBlByBl(usaBlInfoVOs.get(i)) == 0)
					{
						addBlInfoVOs.add(usaBlInfoVOs.get(i));
					}
				}
				if (addBlInfoVOs.size() > 0)
				{
					dbDao.addAdvancedBlByBl(addBlInfoVOs);
				}

				// BKG_BOOKING => BKG_CSTMS_ADV_IBD
				dbDao.modifyOldInbondByBl(oldInbondModiVOs);

				// BKG_CUSTOMER => BKG_CSTMS_ADV_CUST
				List<UsaBkgCustomerVO> customerAddVOs = dbDao.searchBkgCustomerByBl(mblCondVOs, account);
				if (customerAddVOs.size() > 0)
				{
					dbDao.addAdvancedCustomerByBl(customerAddVOs);
				}

				// BKG_CONTAINER => BKG_CSTMS_ADV_CNTR
				List<UsaBkgCntrVO> cntrAddVOs = dbDao.searchBkgContainerByBl(mblCondVOs, account);
				if (cntrAddVOs.size() > 0)
				{
					dbDao.addAdvancedCntrByCntr(cntrAddVOs);
				}

				// BKG_CNTR_SEAL_NO => BKG_CSTMS_SEAL_NO
				List<UsaBkgCntrSealNoVO> cntrSealNoAddVOs = dbDao.searchBkgContainerSealNoByBl(mblCondVOs, account);
				if (cntrSealNoAddVOs.size() > 0)
				{
					dbDao.addAdvancedCntrSealNoByCntr(cntrSealNoAddVOs);
				}

				// BKG_CNTR_MF_DESC => BKG_CSTMS_ADV_CNTR_MF
				List<UsaBkgCmVO> cmAddVOs = dbDao.searchBkgCmByCntr(mblCondVOs, account);
				if (cmAddVOs.size() > 0)
				{
					dbDao.addAdvancedCmByCntr(cmAddVOs);
				}

				// BKG_BOOKING => BKG_CSTMS_ADV_CNTR_MF
//				if (oldCntrModiVOs.size() > 0)
//				{
//					dbDao.modifyOldCntrByCntr(oldCntrModiVOs);
//				}
			}

			/*
			 * H.B/L 다운로드
			 */
			oldInbondModiVOs.clear();
//			oldCntrModiVOs.clear();

			for (int j = 0; j < condVOs.length; j++)
			{
				condVO = condVOs[j];

				if ("H".equals(condVO.getBlType()))
				{
					usaHblInfoVO = dbDao.searchHblInfoByRefNo(condVO);
					usaHblInfoVO.setActFileSkdDirCd(actFileSkdDirCd);

					// 조회된 H.B/L 데이터가 없을 경우
					if (usaHblInfoVO == null)
					{
						throw new EventException(new ErrorHandler("BKG00628", "B/L No. is " + condVO.getBlNo())
								.getMessage());
					}

					condVO.setPodCd(usaHblInfoVO.getPodCd());
					condVO.setDelCd(usaHblInfoVO.getDelCd());
					condVO.setPodNodCd(usaHblInfoVO.getPodNodCd());
					condVO.setDelNodCd(usaHblInfoVO.getDelNodCd());

					this.setInbondData(usaHblInfoVO, condVO);
					/**************************************************
					 * 2010.04.08 추가<BR>
					 * CSTMS_LOC_CD 판단
					 * Local의 경우 : BKG_BOOKING 의 POD_CD<BR>
					 * IPI의 경우 : BKG_CSTMS_ADV_BL의 HUB_LOC_CD
					 **************************************************/
//					usaHblInfoVO.setCstmsLocCd("");
					if("".equals(usaHblInfoVO.getCstmsLocCd())){
						if ("L".equals(oldInbondModiVO.getIbdClrTpCd()))
						{
							usaHblInfoVO.setCstmsLocCd(usaHblInfoVO.getPodCd());
						}
						else if ("I".equals(oldInbondModiVO.getIbdClrTpCd()))
						{
							usaHblInfoVO.setCstmsLocCd(usaHblInfoVO.getHubLocCd());
						}
					}
					if (j == 0)
					{
						usaHblInfoVOs.add(usaHblInfoVO);
					}
					else
					{
						if (!usaHblInfoVO.getBlNo().equals(condVOs[j - 1].getBlNo()))
						{
							usaHblInfoVOs.add(usaHblInfoVO);
						}
					}
					oldInbondModiVOs.add(oldInbondModiVO);
//					if (oldCntrModiVO != null && !"".equals(oldCntrModiVO.getHamoCmdtCd()))
//					{
//						oldCntrModiVOs.add(oldCntrModiVO);
//					}
				}

			} // for end

			if (usaHblInfoVOs.size() > 0)
			{
				dbDao.removeCustomerByBl(hblCondVOs);
				dbDao.removeContainer(hblCondVOs);
				dbDao.removeContainerSealNo(hblCondVOs);
				dbDao.removeCMByBl(hblCondVOs);
				// dbDao.removeAdvancedBlByBl ( hblCondVOs );

				// BKG_HBL => BKG_CSTMS_ADV_BL
				for (int i = 0; i < usaHblInfoVOs.size(); i++)
				{
					if (dbDao.modifyAdvancedBlByBl(usaHblInfoVOs.get(i)) == 0)
					{
						addHblInfoVOs.add(usaHblInfoVOs.get(i));
					}
				}
				if (addHblInfoVOs.size() > 0)
				{
					dbDao.addAdvancedBlByBl(addHblInfoVOs);
				}

				// BKG_BOOKING => BKG_CSTMS_ADV_IBD
				dbDao.modifyOldInbondByBl(oldInbondModiVOs);

				// BKG_HBL_CUST => BKG_CSTMS_ADV_CUST
				List<UsaBkgCustomerVO> hblCustomerAddVOs = dbDao.searchHblCustomer(hblCondVOs, account);
				if (hblCustomerAddVOs.size() > 0)
				{
					dbDao.addAdvancedCustomerByBl(hblCustomerAddVOs);
				}

				// BKG_CONTAINER => BKG_CSTMS_ADV_CNTR
				List<UsaBkgCntrVO> hblCntrAddVOs = dbDao.searchContainerByBl(hblCondVOs, account);
				if (hblCntrAddVOs.size() > 0)
				{
					dbDao.addAdvancedCntrByCntr(hblCntrAddVOs);
				}

				// BKG_CNTR_SEAL_NO => BKG_CSTMS_SEAL_NO
				List<UsaBkgCntrSealNoVO> hblCntrSealNoAddVOs = dbDao.searchContainerSealNoByBl(hblCondVOs, account);
				if (hblCntrSealNoAddVOs.size() > 0)
				{
					dbDao.addAdvancedCntrSealNoByCntr(hblCntrSealNoAddVOs);
				}

				// BKG_CNTR_MF_DESC => BKG_CSTMS_ADV_CNTR_MF
				List<UsaBkgCmVO> hblCmAddVOs = dbDao.searchHblCmPkgWgtByBl(hblCondVOs, account);
				if (hblCmAddVOs.size() > 0)
				{
					dbDao.addAdvancedCmByCntr(hblCmAddVOs);
				}

				// BKG_BOOKING => BKG_CSTMS_ADV_CNTR_MF
//				if (oldCntrModiVOs.size() > 0)
//				{
//					dbDao.modifyOldCntrByCntr(oldCntrModiVOs);
//				}
			}

		}
		catch (EventException ee)
		{
			log.error("err " + ee.toString(), ee);
			result = "FAIL";
			throw ee;
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			result = "FAIL";
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			result = "FAIL";
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}

		return result;
	}

	/**
	 * BKG_CSTMS_ADV_IBD 테이블에 저장할 데이터 세팅
	 * 
	 * @param UsaBlInfoVO usaBlInfoVO
	 * @param UsaManifestListCondVO condVO
	 * @return UsaBlInfoVO
	 * @throws EventException
	 */
	private UsaBlInfoVO setInbondData(UsaBlInfoVO usaBlInfoVO, UsaManifestListCondVO condVO) throws EventException {

		/*
		 * 1.기 Download 데이타 존재시 
			1.1 IT No.(V5N...)가 존재하거나, Old 및 BKG데이타 IbdTrspTpCd 63일경우 기존 코드 유지
			    IbdTpCd (61/62/63)
			    HubLocCd
			    UsaLstLocCd
		
			1.2 그외의 경우
			  1.2.1 POD != DEL
			        HubLocCd >PRD_INLND_ROUT_MST 정보 이용: WD이면 ROUT_DEST_NOD_CD,아니면 HUB_NOD_CD >>정보가 없으면 DEL의 MDM_LOCATION의 SCC_CD
			                UsaManifestListDownloadDBDAOsearchHubLocRSQL.Query
					TRSP_MOD_CD TRANSPORTATION MODE CODE
					N	NOT
					RD	RAIL
					RT	RAIL TRUCK
					RW	RAIL WATER
					TD	TRUCK
					TR	TRUCK RAIL
					TW	TRUCK WATER
					VD	VESSEL
					WD	WATER
					WR	WATER RAIL
					WT	WATER TRUCK
		
			    UsaLstLocCd > TRS_DMST_LST_CTY의 Usa Last Loc Cd 조회 UsaManifestListDownloadDBDAOsearchLastUsaLocRSQL.Query
		
			  1.2.2 '1.2.1' 셋업과 별도로, BKG_CSTMS_ADV_CLR_TP CLR에 고객별로 hubLocCd,ibdTpCd가 정의 되어 있으면 그것을 우선적으로 세팅한다.
			      
		2. 신규 Download
		    2.1 1순위 BKG_CSTMS_ADV_CLR_TP CLR에 고객별로 clrtpCd,hubLocCd,ibdTpCd가 정의 되어 있으면 그것을 우선적으로 세팅한다.
		    2.2 2순위 param usaBlInfoVO 의 clrtpCd,hubLocCd,ibdTpCd 셋업
		    
		    2.3 POD가 US가 아니고, DEL가 US인 경우
		        HubLocCd >PRD_INLND_ROUT_MST 정보 이용: WD이면 ROUT_DEST_NOD_CD,아니면 HUB_NOD_CD >>정보가 없으면 DEL의 MDM_LOCATION의 SCC_CD
		 * */		
		String loclTrnsCd = "";
		UsaBlInfoVO vo=new UsaBlInfoVO();
		String[] result = new String[4];

		try
		{
			/**************************************************************************
			20060127 DJMIN :<br>
			아래와 같이 old 정보를 select 하여, update 하려는 B/L의 기존 IT_ITTYPE과<br>
			신규 IT_ITTYPE을 비교한다.<br>
			둘다 63일 경우, select한 old 정보들이 없어지지 않도록 보존해 준다.<br>
			그외는 기존 로직대로 업데이트 한다.<br>
			MGS 서비스를 위해, MI 후 IE 신고를 BDR전에 미리미리 하도록 업무가 바뀜.<br>
			BDR이후 다시 다운 받을 때, 기존 로직대로라면, IE를 위해 애써 입력한<br>
			정보들이 사라짐. 따라서 이러한 로직을 넣음.<br>
			**************************************************************************/ 
			oldInbondModiVO = dbDao.searchOldInbondInfoByBl(condVO);
			// 2010.05.12 추HUB_LOC_CD 유지 
		//	String hubLocCd = dbDao.searchClrHubLocCd(condVO);
			vo = dbDao.searchClrHubLocCd(condVO);
			
			result = vo.getResultStrArray();
			String hubLocCd = ""; //HUB_LOC_CD 값
			String clrtpCd = "";
			String ibdTpCd = "";
			String cstmsLocCd = "";
			if(result!=null){
				hubLocCd = result[0].toString(); //HUB_LOC_CD 값
				clrtpCd = result[1].toString(); // CSTMS_CLR_TP_CD 값 L/I/F/V/N
				ibdTpCd = result[2].toString(); // IBD_TRSP_TP_CD 값 61/62/63
				cstmsLocCd = result[3].toString(); // CSTMS_LOC_CD 값
			}
			//CSTMS_LOC_CD 값 대입
			usaBlInfoVO.setCstmsLocCd(cstmsLocCd);
			
			// MOVE
			// oldInbondModiVO.setIbdClrTpCd(usaBlInfoVO.getLoclTrnsCd());
			// oldInbondModiVO.setIbdTrspTpCd(usaBlInfoVO.getIbdTpCd());

			if (oldInbondModiVO != null)
			{
				/**************************************************************************
				 * [TO-BE] 2009.11.24 : <br>
				 * 0540에서 Local 로 등록되었더라도, P/MIB No.를 기 assign 한 경우 <br>
				 * 다시 download 를 하더라도 IbdTrspTpCd(IT_TYPE), IbdTrspNo(IT_NO), <br>
				 * UsaLstLocCd(LST_USA), HubLocCd(IT_HUB) 유지<br>
				 * 2010.04.28 추가 : 63일 경우 보존 - 이 경우는 T/S 화물일 경우인 듯함.
				 **************************************************************************/ 
				if (!"".equals(oldInbondModiVO.getIbdTrspNo()) || 
						("63".equals(oldInbondModiVO.getIbdTrspTpCd()) && "63".equals(usaBlInfoVO.getIbdTpCd())))
				{

					// IBD_TRSP_TP_CD 유지
					usaBlInfoVO.setIbdTpCd(oldInbondModiVO.getIbdTrspTpCd());
					// usaBlInfoVO.setIbdTpCd(oldInbondModiVO.getIbdTrspNo());
					//2011.07.21 유선오 고침
					loclTrnsCd = oldInbondModiVO.getIbdClrTpCd();// 기존코드

					// 2010.04.28 추가 : hub, last location 유지
					usaBlInfoVO.setHubLocCd(oldInbondModiVO.getAblHubLocCd());
					usaBlInfoVO.setUsaLstLocCd(oldInbondModiVO.getAblUsaLstLocCd());
				}
				else
				{
					/* ================================================================================
					 * [TO-BE] 2009.09.17 : 
					 * 위의 경우에 해당하지 않고, POD, DEL 이 같지 않을 경우
					 * HUB_LOC_CD, USA_LST_LOC_CD를 다시 조회하여 BKG_CSTMS_ADV_BL 테이블에 업데이트한다.
					 * ================================================================================ */
					if (!usaBlInfoVO.getPodCd().equals(usaBlInfoVO.getDelCd()))
					{
						usaBlInfoVO.setHubLocCd(dbDao.searchHubLoc(condVO));
						usaBlInfoVO.setUsaLstLocCd(dbDao.searchLastUsaLoc(condVO));
					}
					loclTrnsCd = usaBlInfoVO.getLoclTrnsCd();
					// HUB_LOC_CD 유지
					if (!"".equals(hubLocCd))
					{
						usaBlInfoVO.setHubLocCd(hubLocCd);
					}
					// IBD_TRSP_TP_CD 유지
					if (!"".equals(ibdTpCd))
					{
						usaBlInfoVO.setIbdTpCd(ibdTpCd);
					}
				}
				// oldCntrModiVO = dbDao.searchOldInbondInfoByCntr(condVO);
			}
			else
			{
				oldInbondModiVO = new UsaOldInbondModiVO();
				oldInbondModiVO.setBlNo(condVO.getBlNo());
				loclTrnsCd = usaBlInfoVO.getLoclTrnsCd();

				log.debug("clrtpCd========"+clrtpCd+"==old=="+oldInbondModiVO.getIbdClrTpCd());
				if(!"".equals(clrtpCd) ){
					loclTrnsCd = clrtpCd;	
				}else{
					loclTrnsCd = usaBlInfoVO.getLoclTrnsCd();
				}
				
				
				// HUB_LOC_CD 유지
				if (!"".equals(hubLocCd))
				{
					usaBlInfoVO.setHubLocCd(hubLocCd);
				}
				// IBD_TRSP_TP_CD 유지
				if (!"".equals(ibdTpCd))
				{
					usaBlInfoVO.setIbdTpCd(ibdTpCd);
				}
								
				/* =================================================================================
				 * [TO-BE] 2014.11.28 : 
				 * POD가 US가 아니고, DEL가 US인 경우로 POD와 DEL가 다른 경우
				 * customs location 은 PRD의 rail hub 여야 합니다
				 * IbdClrTpCd = V 로 customs location=hub
				 * ================================================================================= */				
				if (  ( "V".equals(loclTrnsCd) && condVO.getPodCd().indexOf("US") < 0) &&  ( condVO.getDelCd().indexOf("US") >= 0) && ( !condVO.getPodCd().equals(condVO.getDelCd()) ) ) {
					usaBlInfoVO.setHubLocCd(dbDao.searchHubLoc(condVO));
				}
				
			}

			// if(!"".equals(oldInbondModiVO.getIbdTrspNo())) {
			// loclTrnsCd = oldInbondModiVO.getIbdClrTpCd();
			// } else {
			// loclTrnsCd = usaBlInfoVO.getLoclTrnsCd();
			// }

			oldInbondModiVO.setIbdClrTpCd(loclTrnsCd);
			oldInbondModiVO.setIbdTrspTpCd(usaBlInfoVO.getIbdTpCd());

			/* =================================================================================
			 * [TO-BE] 2009.08.27 : 
			 * Entry Type Set-Up 에서 등록 된 Entry Type 데이터를 다운로드시 적용
			 * 
			 * BKG_CSTMS_ADV_CLR_TP 등록여부에 따라 
			 * BKG_CSTMS_ADV_CLR_TP.CNTR_TP_CD, BKG_CSTMS_ADV_CNTR.CNTR_TPSZ_CD 두 값이 동일하면
			 * BKG_CSTMS_ADV_CLR_TP 테이블의 
			 * CSTMS_CLR_TP_CD, FREE_TRD_ZN_FLG 데이터를 BKG_CSTMS_ADV_IBD 테이블에 업데이트
			 * ================================================================================= */
			String clrCntrTpCd = oldInbondModiVO.getClrCntrTpCd();
			String cntCntrTpCd = oldInbondModiVO.getCntCntrTpCd();

			// 2009.10.22 하단 로직으로 변경 
			// 소스 흐름상 기 등록된 B/L의 P/MIB NO.가 없으면  Customer가 Entry Type Setup 정보에 셋업 되어있을 경우 우선 셋업 정보를 우선 적용한다.
			// if (oldInbondModiVO != null) 문장 안으로 이동하는게 맞을 듯 하다.  
			if ("".equals(oldInbondModiVO.getIbdTrspNo())
					&& ("A".equals(clrCntrTpCd) || (clrCntrTpCd != null && clrCntrTpCd.equals(cntCntrTpCd))))
			{
				oldInbondModiVO.setIbdClrTpCd(oldInbondModiVO.getClrClrTpCd());
				oldInbondModiVO.setIbdFreeTrdZnFlg(oldInbondModiVO.getClrFreeTrdZnFlg());
			}
			oldInbondModiVO.setIbdDirDeFlg(oldInbondModiVO.getClrDirDeFlg());
			oldInbondModiVO.setCreUsrId(account.getUsr_id());
			oldInbondModiVO.setUpdUsrId(account.getUsr_id());

			return usaBlInfoVO;

		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
	}

	/**
	 * IN 절에 들어갈 BKG_NO, BL_NO 문자열로 생성 IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로 1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
	 * 
	 * @param ManifestListDetailVO[] detailVOs
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private List<String> generateBlBkgList(ManifestListDetailVO[] detailVOs, String blType, String noType)
			throws EventException {
		try
		{
			UsaManifestListDetailVO detailVO = null;
			String strNo = null;
			List<String> arrString = new ArrayList();
			StringBuffer sb = new StringBuffer();
			int noCnt = detailVOs.length;
			int quotaCnt = noCnt / 1000;
			int restCnt = noCnt % 1000;

			for (int i = 1; i <= quotaCnt; i++)
			{
				sb.delete(0, sb.length());
				for (int j = i * 1000 - 1000; j < i * 1000; j++)
				{
					detailVO = (UsaManifestListDetailVO) detailVOs[j];
					if ("BKG".equals(noType))
					{
						strNo = detailVO.getBkgNo();
					}
					else
					{
						strNo = detailVO.getBlNos();
					}

					if (!blType.equals(detailVO.getBlType()))
						continue;

					// if(j == i*1000-1000){
					if ("".equals(sb.toString()))
					{
						sb.append("'").append(strNo).append("'");
					}
					else
					{
						sb.append(",'").append(strNo).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			if (restCnt > 0)
			{
				sb.delete(0, sb.length());
				for (int i = quotaCnt * 1000; i < noCnt; i++)
				{
					detailVO = (UsaManifestListDetailVO) detailVOs[i];
					if ("BKG".equals(noType))
					{
						strNo = detailVO.getBkgNo();
					}
					else
					{
						strNo = detailVO.getBlNos();
					}

					if (!blType.equals(detailVO.getBlType()))
						continue;

					// if(i == quotaCnt*1000){
					if ("".equals(sb.toString()))
					{
						sb.append("'").append(strNo).append("'");
					}
					else
					{
						sb.append(",'").append(strNo).append("'");
					}
				}
				if(sb.length() > 0){
					arrString.add(sb.toString());
				}
			}

			return arrString;
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}
}