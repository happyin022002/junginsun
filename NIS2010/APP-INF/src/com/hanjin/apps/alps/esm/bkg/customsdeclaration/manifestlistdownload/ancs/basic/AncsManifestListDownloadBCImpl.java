/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AncsManifestListDownloadBCImpl.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.25 정재엽
 * 1.0 Creation
 * -----------------------------------------------------
 * History
 * 2011.10.24 김보배 [CHM-201114022] [BKG] ANCS > BL inquiry< Download 버튼 제거
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration.AncsManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsBkgCstmsAnrCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsAnrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCmdtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsEdiHisInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsVesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.BkgCstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsMfDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCmdtVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCntrVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrNtfyVO;
import com.hanjin.syscommon.common.table.BkgCstmsAnrVvdVO;
import com.hanjin.syscommon.common.table.BkgCustomerVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Jeong jae yoeb
 * @see ESM_BKG_0551EventResponse,ManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AncsManifestListDownloadBCImpl extends ManifestListDownloadBCImpl {

	

	// Database Access Object
	private transient AncsManifestListDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public AncsManifestListDownloadBCImpl() {
		dbDao = new AncsManifestListDownloadDBDAO();
	}
	
	
	/**
     * 벨기에 세관 신고 대상 VVD 목록 조회
     * 
     * @param CstmsVvdListCondVO condVo
     * @return List<CstmsVvdVO>
     * @throws EventException
     */
	@Override
	public List<CstmsVvdVO> searchCstmsVvdList(CstmsVvdListCondVO condVo) throws EventException {
		
		try {
			return dbDao.searchAncsCstmsVvdList( (AncsCstmsVvdListCondVO)condVo );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * 벨기에 세관 신고 대상 VVD 목록 상세 조회
	 * 
	 * @param cstmsVvdDtlListCondVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CstmsVvdDtlVO> searchCstmsVvdDtlList(CstmsVvdDtlListCondVO cstmsVvdDtlListCondVO) throws EventException {
		try {
			return dbDao.searchAncsCstmsVvdDtlList( (AncsCstmsVvdDtlListCondVO)cstmsVvdDtlListCondVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ANCS 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 BL 테이블로 부터 다운 로드 받음
	 * 
	 * @param ManifestModificationVO manifestModificationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@Override
	public void manageManifest(ManifestModificationVO manifestModificationVO, SignOnUserAccount account) throws EventException {
		try { 
			AncsManifestModificationVO ancsMftMoVO = (AncsManifestModificationVO)manifestModificationVO;
			String sVvd = ancsMftMoVO.getVvd();
			ancsMftMoVO.setSndUsrId( account.getUpd_usr_id() );
			String isSsr = dbDao.checkIfSsrNoExist(sVvd.substring(0, 4), sVvd.substring(4, 8), sVvd.substring(8, 9));
			if ( !isSsr.equals("") ){
				
				ancsMftMoVO.setCreUsrId(account.getUsr_id());
				ancsMftMoVO.setUpdUsrId(account.getUsr_id());
				ancsMftMoVO.setCreOfcCd(account.getOfc_cd());
				ancsMftMoVO.setUpdOfcCd(account.getOfc_cd());
				
				if ( ancsMftMoVO.getSsrNo().equals("") )
					ancsMftMoVO.setSsrNo(isSsr);
				
				if("Y".equals(ancsMftMoVO.getChkDown())){
					//해당 데이타 전체를 Delete 한다.
					
					dbDao.deleteSelectBkgCstmsAnrCmdt(ancsMftMoVO);
					
					dbDao.deleteSelectBkgCstmsAnrCntr(ancsMftMoVO);
					
					dbDao.deleteSelectBkgCstmsAnrNtfy(ancsMftMoVO);
					
					dbDao.deleteSelectBkgCstmsAnrBl(ancsMftMoVO);
					
				}
				
				//해당 데이타 전체를 Download 받는다.
				dbDao.addSelectBkgCstmsAnrBl(ancsMftMoVO);
				
				dbDao.addSelectBkgCstmsAnrNtfy(ancsMftMoVO);
				
				dbDao.addSelectBkgCstmsAnrCntr(ancsMftMoVO);
				
				dbDao.addSelectBkgCstmsAnrCmdt(ancsMftMoVO);				
			}
			
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 벨기에 세관 입항 신고를 위한 VVD별 입항 정보 조회
	 * 
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return VesselArrivalVO
	 * @exception EventException
	 */
	@Override
	public VesselArrivalVO searchVesselArrival2(VesselArrivalCondVO vesselArrivalCondVO) throws EventException {
		
		try {
			List<AncsCstmsVesselArrivalVO> ancsCstmsVesselArrivalVOs = null;
			ancsCstmsVesselArrivalVOs = dbDao.searchAncsCstmsVesselArrival( (AncsCstmsVesselArrivalCondVO)vesselArrivalCondVO );
			if ( ancsCstmsVesselArrivalVOs.size() > 0 )
			 return (VesselArrivalVO)ancsCstmsVesselArrivalVOs.get(0);
			else
			 return null;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 벨기에 세관 VVD별 입항 정보를 관리
	 * 
	 * @param BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageAncsLane(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs, SignOnUserAccount account) throws EventException {
		try {
			
			BookingUtil command = new BookingUtil();
			for ( int i=0 ; i<bkgHrdCdgCtntVOs.length ; i++ )
			{
				bkgHrdCdgCtntVOs[i].setHrdCdgId("ANR_CSTMS_SLAN_CD");
				bkgHrdCdgCtntVOs[i].setCreUsrId(account.getUsr_id());
				bkgHrdCdgCtntVOs[i].setUpdUsrId(account.getUsr_id());
				bkgHrdCdgCtntVOs[i].setAttrCtnt2("A");
			}
			command.manageHardCoding(bkgHrdCdgCtntVOs);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}	

	/**
	 * 벨기에 세관 VVD별 입항 정보를 관리
	 * 
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException {
		try {
			
			AncsVesselArrivalVO avaVO = (AncsVesselArrivalVO)vesselArrivalVO;  
			BkgCstmsAnrVvdVO bkgCstmsAnrVvdVO = new BkgCstmsAnrVvdVO(); 
			AncsCstmsVesselArrivalVO ancsCstmsVesselArrivalVO = new AncsCstmsVesselArrivalVO();
			
			// Exception발생: BKG06015: The PRV Port is invaild
			ancsCstmsVesselArrivalVO.setVvd    ( avaVO.getVvd() );
			ancsCstmsVesselArrivalVO.setPrvProt( avaVO.getPrvProt() );
			
			Boolean boolean1 = dbDao.checkIfPrvPortValid(ancsCstmsVesselArrivalVO);
			if( ! boolean1 )
				throw new EventException(new ErrorHandler("BKG06015").getMessage());
		 	
			//화면단 콤보 select 값을 전환하기 위해서 처리하지만, 혹시라도 화면에서 처리가능하다면 .js 에서 처리되는게 좋음
			//화면에서 처리 2012.03.19
			bkgCstmsAnrVvdVO.setBrthDesc(avaVO.getSlanCd());
			/*
			if( "BEANRD8 (HNN913)".equals(slanCd) )
				bkgCstmsAnrVvdVO.setBrthDesc("S913");
			else if( "BEANRY1 (AIT1742)".equals(slanCd) )
				bkgCstmsAnrVvdVO.setBrthDesc("1742");
			else if( "BEANRY2 (AGT1700)".equals(slanCd) )
				bkgCstmsAnrVvdVO.setBrthDesc("1700");
			else if( "BEANRY5 (HNN869)".equals(slanCd) )
				bkgCstmsAnrVvdVO.setBrthDesc("S869");
			*/
			
			avaVO.getVvd();
			bkgCstmsAnrVvdVO.setVslCd   ( avaVO.getVvd().substring(0,4) );
			bkgCstmsAnrVvdVO.setSkdVoyNo( avaVO.getVvd().substring(4,8) );
			bkgCstmsAnrVvdVO.setSkdDirCd( avaVO.getVvd().substring(8,9) );
			
			bkgCstmsAnrVvdVO.setSvcRqstNo( avaVO.getSsrNo()    );
			bkgCstmsAnrVvdVO.setLloydTpCd( avaVO.getLloydType());
			bkgCstmsAnrVvdVO.setLloydNo  ( avaVO.getLloydNo()  );
			bkgCstmsAnrVvdVO.setVslCntCd( avaVO.getVslFlag() );
			bkgCstmsAnrVvdVO.setVvdNm    ( avaVO.getVslName()  );
			bkgCstmsAnrVvdVO.setDepLocCd ( avaVO.getPrvProt()  );
			bkgCstmsAnrVvdVO.setEtaDt    ( avaVO.getEtaCallDate());
			bkgCstmsAnrVvdVO.setDemFreeDt( avaVO.getDemdetFreeTime() );
			bkgCstmsAnrVvdVO.setDiffRmk  ( avaVO.getRemark()   );
			bkgCstmsAnrVvdVO.setDatCreFlg( ""                  );
			bkgCstmsAnrVvdVO.setGenOfcCd ( ""                  );
			bkgCstmsAnrVvdVO.setGenDt    ( ""                  );
			bkgCstmsAnrVvdVO.setAnrMsgStsCd( avaVO.getCrsrep() );
			bkgCstmsAnrVvdVO.setLstSeq   ( ""                  );
			bkgCstmsAnrVvdVO.setRgstUsrId( avaVO.getUserId()   );
			bkgCstmsAnrVvdVO.setCreOfcCd ( account.getOfc_cd() );
			bkgCstmsAnrVvdVO.setUpdOfcCd ( account.getOfc_cd() );
			bkgCstmsAnrVvdVO.setCreUsrId ( account.getUsr_id() );
			bkgCstmsAnrVvdVO.setUpdUsrId ( account.getUsr_id() );
			
			List<BkgCstmsAnrVvdVO> list = new ArrayList<BkgCstmsAnrVvdVO>();
			list.add(bkgCstmsAnrVvdVO);
			
			if(avaVO.getOldSsrNo() != null && !"".equals(avaVO.getOldSsrNo()) && !avaVO.getOldSsrNo().equals(avaVO.getSsrNo())) {
				dbDao.modifyAncsCstmsArtNo(list); // Article No 중복 방지
			}
			dbDao.modifyBkgCstmsAnrVvd(list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * ANCS 세관 신고용 VVD 정보 조회
	 * 
	 * @param cstmsVvdInfoCondVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<CstmsVvdInfoVO> searchCstmsVvdInfo(CstmsVvdInfoCondVO cstmsVvdInfoCondVO) throws EventException {
		try {
			return dbDao.searchAncsCstmsVvdInfo( (AncsCstmsVvdInfoCondVO)cstmsVvdInfoCondVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * 
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	@Override
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try {
			return dbDao.searchAncsCstmsMfList( (AncsCstmsMfListCondVO)manifestListCondVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  세관 적하 목록 상세 정보를 조회
	 * 
	 * @param CstmsMfDtlCondVO cstmsMfDtlListCondVO
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	@Override
	public List<ManifestListDetailVO> searchCstmsMfDtlList(CstmsMfDtlCondVO cstmsMfDtlListCondVO)
			throws EventException {
		try {
			return dbDao.searchAncsCstmsMfDtlList( (AncsCstmsMfDtlCondVO)cstmsMfDtlListCondVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 *  Customr, Container, Commodity(CM) 등의 BL 정보를 세관테이블 내로 다운로드 받고 이를 조회/확인한다.
	 * 
	 * @param cstmsBlCondVO CstmsBlCondVO
	 * @return AncsCstmsBlCVO
	 * @throws EventException
	 */
	@Override
	public AncsCstmsBlCVO inquiryBlData(CstmsBlCondVO cstmsBlCondVO) throws EventException {
		try {
			AncsCstmsBlCVO ancsCstmsBlCVO = new AncsCstmsBlCVO();
			AncsCstmsBlCondVO ancsCstmsBlCondVO = (AncsCstmsBlCondVO)cstmsBlCondVO;
			List<AncsCstmsBlInfoVO> ancsCstmsBlInfoVOs = dbDao.searchAncsCstmsBl( ancsCstmsBlCondVO );
			List<AncsCstmsCntrVO>   ancsCstmsCntrVOs   = dbDao.searchAncsCstmsCntr( ancsCstmsBlCondVO );
			if( ancsCstmsCntrVOs.size() > 0 ){
				AncsCstmsCntrVO ancsCstmsCntrVO = ancsCstmsCntrVOs.get(0);
				ancsCstmsBlCondVO.setVvd  (ancsCstmsCntrVO.getVvd());
				ancsCstmsBlCondVO.setBkgNo(ancsCstmsCntrVO.getBkgNo());
			}
			List<AncsCstmsCmdtVO>   ancsCstmsCmdtVOs   = dbDao.searchAncsCstmsCmdt( (AncsCstmsBlCondVO)cstmsBlCondVO );
			
			List<AncsCstmsBlInfoVO> ancsCstmsBlInfoVOs2 = new ArrayList<AncsCstmsBlInfoVO>();
			for (Iterator<AncsCstmsBlInfoVO> iterator = ancsCstmsBlInfoVOs.iterator(); iterator.hasNext();) {
				AncsCstmsBlInfoVO ancsCstmsBlInfoVO = iterator.next();
				
				String sShprNmAd = ancsCstmsBlInfoVO.getShprAddr();
				String sShprNm   = sShprNmAd.substring(0, sShprNmAd.indexOf("@@"));
				String sShprAddr = sShprNmAd.substring( (sShprNmAd.indexOf("@@")+2) );
				
				ancsCstmsBlInfoVO.setShprName(sShprNm);
				ancsCstmsBlInfoVO.setShprAddr(sShprAddr);
				
				String sCneeNmAd = ancsCstmsBlInfoVO.getCneeAddr();
				String sCneeNm   = sCneeNmAd.substring(0, sCneeNmAd.indexOf("@@"));
				String sCneeAddr = sCneeNmAd.substring( (sCneeNmAd.indexOf("@@")+2) );
				ancsCstmsBlInfoVO.setCneeName(sCneeNm);
				ancsCstmsBlInfoVO.setCneeAddr(sCneeAddr);
				ancsCstmsBlInfoVOs2.add(ancsCstmsBlInfoVO);
			}
			ancsCstmsBlCVO.setAncsCstmsBlInfoVOs(ancsCstmsBlInfoVOs2);
			ancsCstmsBlCVO.setAncsCstmsCntrVOs(ancsCstmsCntrVOs);
			ancsCstmsBlCVO.setAncsCstmsCmdtVOs(ancsCstmsCmdtVOs);
			return ancsCstmsBlCVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다
	 * @param cstmsBlVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException {
		try
		{
		
			AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = (AncsCstmsBlContainerVO[])cstmsBlVOs;
			BkgCstmsAnrNtfyVO bkgCstmsAnrNtfyVO = null;
			BkgCstmsAnrBlVO bkgCstmsAnrBlVO = null;
			List<BkgCstmsAnrBlVO> bkgCstmsAnrBlVOs = new ArrayList<BkgCstmsAnrBlVO>();
			List<BkgCstmsAnrCntrVO> bkgCstmsAnrCntrVOs = new ArrayList<BkgCstmsAnrCntrVO>();
			
			if( ancsCstmsBlContainerVOs.length > 0 ){
				
				// Flat 파일 수신시 처리.
				if( "Y".equals( ancsCstmsBlContainerVOs[0].getRcv() ) ){
					
					/*
					 * 2. BKG_CSTMS_ANR_EDI_HIS로 부터 SND_STS 조회
					 *     SELECT EDI_SND_STS_CD
					 *       INTO :$(SND_STS)
					 *       FROM BKG_CSTMS_ANR_EDI_HIS
					 *      WHERE MSG_TP_CD = 'C'
					 *        AND ANR_DECL_NO = $(DCLR_NO:)
					 *        AND REF_SEQ = $(REF_SEQ:)
					 */
					AncsCstmsAnrBlVO ancsCstmsAnrBlVO = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getAncsCstmsAnrBlVO();

					AncsCstmsEdiHisInfoCondVO ancsCstmsEdiHisInfoCondVO = new AncsCstmsEdiHisInfoCondVO();
					ancsCstmsEdiHisInfoCondVO.setAnrDeclNo( ancsCstmsAnrBlVO.getAnrDeclNo() );
					ancsCstmsEdiHisInfoCondVO.setMsgTpCd  ( ancsCstmsAnrBlVO.getMsgTpCd()   );
					ancsCstmsEdiHisInfoCondVO.setRefSeq   ( ancsCstmsAnrBlVO.getRefSeq()    );
					List<BkgCstmsAnrEdiHisVO> list= dbDao.searchAncsCstmsEdiHisInfo(ancsCstmsEdiHisInfoCondVO);
					
					if( list.size() > 0 ) {
					
						BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = list.get(0);
						String sSnd_Sts = bkgCstmsAnrEdiHisVO.getEdiSndStsCd();
						
						/*
						 * 9. $(SND_STS) <> 'O' 인 경우 BKG_CSTMS_ANR_BL 업데이트
						 *     UPDATE BKG_CSTMS_ANR_BL X
						 *        SET X.ANR_MSG_STS_CD = 'N',
						 *            VVD_SEQ = (SELECT NVL(MAX(B.VVD_SEQ) + 1
						 *                         FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_BL B
						 *                        WHERE A.SVC_RQST_NO = SUBSTR($(DCLR_NO:), 1, 6)
						 *                          AND B.VSL_CD = A.VSL_CD
						 *                          AND B.SKD_VOY_NO = A.SKD_VOY_NO
						 *                          AND B.SKD_DIR_CD = A.SKD_DIR_CD)
						 *      WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.BKG_NO) IN  (
						 *             SELECT Z.VSL_CD, Z.SKD_VOY_NO, Z.SKD_DIR_CD, Z.BKG_NO
						 *               FROM BKG_CSTMS_ANR_BL_LOG Z
						 *              WHERE Z.ANR_DECL_NO = $(DCLR_NO:)
						 *                AND Z.REF_SEQ = $(REF_SEQ:)
						 *                AND Z.EDI_RCV_STS_CD = 'A')
						 * 
						 * 10. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로 BKG_CSTMS_ANR_CNTR_LOG의 수신 결과 초기화
						 *     UPDATE BKG_CSTMS_ANR_CNTR_LOG
						 *        SET EDI_RCV_STS_CD = 'N',
						 *            MSG_LOC_CD = NULL,
						 *            EDI_MSG_ERR_ID = NULL,
						 *            ERR_DESC = NULL,
						 *            ERR_CTNT = NULL
						 *      WHERE MSG_TP_CD = 'C'
						 *        AND ANR_DECL_NO = $(DCLR_NO:)
						 *        AND REF_SEQ = $(REF_SEQ:)
						 */
						ancsCstmsAnrBlVO.setSndSts(sSnd_Sts);
						ancsCstmsAnrBlVO.setRcv( ancsCstmsBlContainerVOs[0].getRcv() );
						bkgCstmsAnrBlVOs.add(ancsCstmsAnrBlVO);
						dbDao.modifyBkgCstmsAnrBl( bkgCstmsAnrBlVOs );
						
						/*
						 * 13. $(SND_STS)에 따라 BKG_CSTMS_ANR_CNTR 업데이트
						 *     UPDATE BKG_CSTMS_ANR_CNTR X
						 *        SET X.ANR_MSG_STS_CD = CASE WHEN $(SND_STS) = 'O' THEN 'A'
						 *                                    WHEN $(SND_STS) = 'C' THEN 'N'
						 *                                    ELSE ANR_MSG_STS_CD
						 *                               END
						 *      WHERE (X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD, X.CNTR_NO) IN (
						 *             SELECT Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD, Y.CNTR_NO
						 *               FROM BKG_CSTMS_ANR_CNTR_LOG Y
						 *              WHERE MSG_TP_CD = 'C'
						 *                AND ANR_DECL_NO = $(DCLR_NO:)
						 *                AND REF_SEQ = $(REF_SEQ:)
	                     *                AND EDI_RCV_STS_CD = 'A')
						 */     
						AncsBkgCstmsAnrCntrVO ancsBkgCstmsAnrCntrVO = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getAncsBkgCstmsAnrCntrVO();
						ancsBkgCstmsAnrCntrVO.setRcv( ancsCstmsBlContainerVOs[0].getRcv() );
						ancsBkgCstmsAnrCntrVO.setSndSts(sSnd_Sts);
						bkgCstmsAnrCntrVOs.add( ancsBkgCstmsAnrCntrVO );
						dbDao.modifyBkgCstmsAnrCntr ( bkgCstmsAnrCntrVOs );
					}	
					
				} else {
				
					AncsCstmsBlNtfyVO ancsCstmsBlNtfyVO = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getAncsCstmsBlNtfyVO();
					AncsCstmsBlVO     ancsCstmsBlVO     = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getAncsCstmsBlVO();
					AncsCstmsCntrVO[]   ancsCstmsCntrVOs   = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getAncsCstmsCntrVOArrys();
					BkgCstmsAnrCmdtVO[] bkgCstmsAnrCmdtVOs = ((AncsCstmsBlContainerVO)cstmsBlVOs[0]).getBkgCstmsAnrCmdtVOs();
					
					if( ancsCstmsBlNtfyVO != null ) {
						bkgCstmsAnrNtfyVO = new BkgCstmsAnrNtfyVO();
						bkgCstmsAnrNtfyVO.setFaxNo   ( ancsCstmsBlNtfyVO.getFaxNo() );
						bkgCstmsAnrNtfyVO.setNtfyEml ( ancsCstmsBlNtfyVO.getNtfyEml() );
						bkgCstmsAnrNtfyVO.setNtfyNm  ( ancsCstmsBlNtfyVO.getNtfyNm() );
						bkgCstmsAnrNtfyVO.setNtfyNm  ( ancsCstmsBlNtfyVO.getNtfyName() );
						bkgCstmsAnrNtfyVO.setNtfyAddr( ancsCstmsBlNtfyVO.getNtfyAddr() );
						bkgCstmsAnrNtfyVO.setBkgNo   ( ancsCstmsBlVO.getBkgNo() );
						bkgCstmsAnrNtfyVO.setUpdUsrId(account.getUsr_id());
					}
					
					if( ancsCstmsBlVO != null ) {
						
						bkgCstmsAnrBlVO = new BkgCstmsAnrBlVO();
						bkgCstmsAnrBlVO.setShprAddr( ancsCstmsBlVO.getShprName() + "@@" + ancsCstmsBlVO.getShprAddr());
						bkgCstmsAnrBlVO.setCneeAddr( ancsCstmsBlVO.getCneeName() + "@@" + ancsCstmsBlVO.getCneeAddr() );
						bkgCstmsAnrBlVO.setVslCd   ( ancsCstmsBlVO.getVvd().substring(0,4) );
						bkgCstmsAnrBlVO.setSkdVoyNo( ancsCstmsBlVO.getVvd().substring(4,8) );
						bkgCstmsAnrBlVO.setSkdDirCd( ancsCstmsBlVO.getVvd().substring(8,9) );
						bkgCstmsAnrBlVO.setUpdUsrId( account.getUsr_id() );
						bkgCstmsAnrBlVO.setBkgNo   (ancsCstmsBlVO.getBkgNo());
						bkgCstmsAnrBlVOs.add(bkgCstmsAnrBlVO);
					}
					
					if( ancsCstmsCntrVOs != null ) {
						BkgCstmsAnrCntrVO bkgCstmsAnrCntrVO = null;
						for(int i=0; i<ancsCstmsCntrVOs.length; i++){
							
							bkgCstmsAnrCntrVO = new BkgCstmsAnrCntrVO();
							bkgCstmsAnrCntrVO.setCntrNo      ( ancsCstmsCntrVOs[i].getCntrNo() ); 
							bkgCstmsAnrCntrVO.setAnrMsgStsCd ( ancsCstmsCntrVOs[i].getAnrMsgStsCd() ); 
							bkgCstmsAnrCntrVO.setOrgRcvTermCd( ancsCstmsCntrVOs[i].getOrgRcvTermCd() );
							bkgCstmsAnrCntrVO.setDestDeTermCd( ancsCstmsCntrVOs[i].getDestDeTermCd() );
							bkgCstmsAnrCntrVO.setCntrTpszCd  ( ancsCstmsCntrVOs[i].getCntrTpszCd() );
							bkgCstmsAnrCntrVO.setPckQty      ( ancsCstmsCntrVOs[i].getPckQty() );
							bkgCstmsAnrCntrVO.setPckTpCd     ( ancsCstmsCntrVOs[i].getPckTpCd() );
							bkgCstmsAnrCntrVO.setCntrWgt     ( ancsCstmsCntrVOs[i].getCntrWgt() );
							bkgCstmsAnrCntrVO.setWgtUtCd     ( ancsCstmsCntrVOs[i].getWgtUtCd() );
							bkgCstmsAnrCntrVO.setVslCd       ( ancsCstmsCntrVOs[i].getVvd().substring(0,4) );
							bkgCstmsAnrCntrVO.setSkdVoyNo    ( ancsCstmsCntrVOs[i].getVvd().substring(4,8) );
							bkgCstmsAnrCntrVO.setSkdDirCd    ( ancsCstmsCntrVOs[i].getVvd().substring(8,9) );
							bkgCstmsAnrCntrVO.setBkgNo       ( ancsCstmsCntrVOs[i].getBkgNo() );
							bkgCstmsAnrCntrVO.setBkgNoSplit  ( ancsCstmsCntrVOs[i].getBkgNoSplit() );
							bkgCstmsAnrCntrVO.setUpdUsrId    ( account.getUsr_id() );
							
							bkgCstmsAnrCntrVOs.add(bkgCstmsAnrCntrVO);
							bkgCstmsAnrCntrVO = null;
						}
					}	
					
					if( bkgCstmsAnrBlVOs.size() > 0 )
						dbDao.modifyBkgCstmsAnrBl( bkgCstmsAnrBlVOs );
					
					if( bkgCstmsAnrNtfyVO != null )
						dbDao.modifyBkgCstmsRtmNtfyAddr( bkgCstmsAnrNtfyVO );
	
					if( bkgCstmsAnrCntrVOs.size() > 0 ){
						dbDao.modifyBkgCstmsAnrCntr( bkgCstmsAnrCntrVOs );
					}
					List<BkgCstmsAnrCmdtVO> insBkgCstmsAnrCmdtVOs = new ArrayList<BkgCstmsAnrCmdtVO>();
					List<BkgCstmsAnrCmdtVO> updBkgCstmsAnrCmdtVOs = new ArrayList<BkgCstmsAnrCmdtVO>();
					List<BkgCstmsAnrCmdtVO> delBkgCstmsAnrCmdtVOs = new ArrayList<BkgCstmsAnrCmdtVO>();
					if( bkgCstmsAnrCmdtVOs != null ) {
						BkgCstmsAnrCmdtVO bkgCstmsAnrCmdtVO = null;
						for (int i = 0; i < bkgCstmsAnrCmdtVOs.length; i++) {
							
							bkgCstmsAnrCmdtVOs[i].setUpdUsrId(account.getUsr_id());
							if( bkgCstmsAnrCmdtVOs[i].getIbflag().equals("I") ){
								bkgCstmsAnrCmdtVO = ( BkgCstmsAnrCmdtVO )bkgCstmsAnrCmdtVOs[i];
								
								bkgCstmsAnrCmdtVO.setCreOfcCd( account.getOfc_cd() );
								bkgCstmsAnrCmdtVO.setUpdOfcCd( account.getOfc_cd() );
								bkgCstmsAnrCmdtVO.setCreUsrId( account.getUsr_id() );
								bkgCstmsAnrCmdtVO.setUpdUsrId( account.getUsr_id() );
								insBkgCstmsAnrCmdtVOs.add( bkgCstmsAnrCmdtVO );
								
							}else if ( bkgCstmsAnrCmdtVOs[i].getIbflag().equals("U") ){
								bkgCstmsAnrCmdtVO = ( BkgCstmsAnrCmdtVO )bkgCstmsAnrCmdtVOs[i];
								bkgCstmsAnrCmdtVO.setUpdOfcCd( account.getOfc_cd() );
								bkgCstmsAnrCmdtVO.setUpdUsrId( account.getUsr_id() );
								updBkgCstmsAnrCmdtVOs.add(  bkgCstmsAnrCmdtVO );
							
							}else if ( bkgCstmsAnrCmdtVOs[i].getIbflag().equals("D") ){

								bkgCstmsAnrCmdtVO = ( BkgCstmsAnrCmdtVO )bkgCstmsAnrCmdtVOs[i];
								bkgCstmsAnrCmdtVO.setUpdOfcCd( account.getOfc_cd() );
								bkgCstmsAnrCmdtVO.setUpdUsrId( account.getUsr_id() );
								delBkgCstmsAnrCmdtVOs.add( bkgCstmsAnrCmdtVO );
							}	
						}
						
						if ( delBkgCstmsAnrCmdtVOs.size() > 0 )
							dbDao.removeBkgCstmsAnrCmdt( delBkgCstmsAnrCmdtVOs );
						if ( insBkgCstmsAnrCmdtVOs.size() > 0 )
							dbDao.addBkgCstmsAnrCmdt( insBkgCstmsAnrCmdtVOs );
						if ( updBkgCstmsAnrCmdtVOs.size() > 0 )
							dbDao.modifyBkgCstmsAnrCmdt( updBkgCstmsAnrCmdtVOs );
					}
					
					
					if( ancsCstmsBlNtfyVO != null && ancsCstmsBlVO != null ){
						GeneralBookingReceiptDBDAO dbDao2 = new GeneralBookingReceiptDBDAO();
						BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
						bkgCustomerVO.setCustNm  ( ancsCstmsBlNtfyVO.getNtfyName() );
						bkgCustomerVO.setCustAddr( ancsCstmsBlNtfyVO.getNtfyAddr() );
						bkgCustomerVO.setBkgNo   ( ancsCstmsBlVO.getBkgNo() );
						dbDao2.modifyIbCustNmAddr(bkgCustomerVO);
					}	
					
				}	
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	

	
	/**
	 * ANCS 세관 테이블에서 Notify Address 정보 조회
	 * 
	 * @param CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO
	 * @param SignOnUserAccount account
	 * @return List<CstmsNtfyAddrVO>
	 * @exception EventException
	 */
	@Override
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr (CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO, SignOnUserAccount account) throws EventException {
		try {
			BkgCstmsNtfyAddrCondVO bkgCstmsNtfyAddrCondVO = (BkgCstmsNtfyAddrCondVO)cstmsNtfyAddrCondVO;
			bkgCstmsNtfyAddrCondVO.setUpdOfcCd(account.getOfc_cd());
			List<CstmsNtfyAddrVO> list = dbDao.searchAncsCstmsNtfyAddr( (BkgCstmsNtfyAddrCondVO)cstmsNtfyAddrCondVO );
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * SendLog History
	 * 
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws EventException
	 */
	public List<BkgHrdCdgCtntVO> searchAncsLane() throws EventException {
		try
		{
			return dbDao.searchAncsLane();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * ANCS 세관 관련 Notify Address를 관리 한다
	 * 
	 * @param CstmsNtfyAddrVO[] cstmsNtfyAddrVOs
     * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	@Override
	public void manageCstmsNtfyAddr(CstmsNtfyAddrVO[] cstmsNtfyAddrVOs, SignOnUserAccount account) throws EventException {
		
		try {
			
			for ( int i=0; i<cstmsNtfyAddrVOs.length; i++ ) {
				
				if ( cstmsNtfyAddrVOs[i].getIbflag().equals("I")){
					
					BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO = (BkgCstmsNtfyAddrVO)cstmsNtfyAddrVOs[i];
					bkgCstmsNtfyAddrVO.setUpdUsrId(account.getUsr_id());
					bkgCstmsNtfyAddrVO.setUpdOfcCd(account.getOfc_cd());
					bkgCstmsNtfyAddrVO.setCreUsrId(account.getUsr_id());
					bkgCstmsNtfyAddrVO.setCreOfcCd(account.getOfc_cd());
					
					dbDao.addBkgCstmsNtfyAddr( bkgCstmsNtfyAddrVO );					
				} 
                else if ( cstmsNtfyAddrVOs[i].getIbflag().equals("U")){
                	BkgCstmsNtfyAddrVO bkgCstmsNtfyAddrVO = (BkgCstmsNtfyAddrVO)cstmsNtfyAddrVOs[i];
                	bkgCstmsNtfyAddrVO.setUpdUsrId(account.getUsr_id());
                	bkgCstmsNtfyAddrVO.setUpdOfcCd(account.getOfc_cd());
					dbDao.modifyBkgCstmsNtfyAddr( bkgCstmsNtfyAddrVO  );
				} 
				else if ( cstmsNtfyAddrVOs[i].getIbflag().equals("D")){
					dbDao.removeBkgCstmsNtfyAddr( (BkgCstmsNtfyAddrVO)cstmsNtfyAddrVOs[i] );
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 관련 선박 정보를 생성, 수정, 삭제 한다
	 * 
	 * @param vesselInfoVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageCstmsVesselInfo(VesselInfoVO[] vesselInfoVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<BkgCstmsAnrVvdVO>  bkgCstmsAnrVvdVOs  = new ArrayList<BkgCstmsAnrVvdVO>();
			AncsVesselInfoVO ancsVesselInfoVO = (AncsVesselInfoVO)vesselInfoVOs[0];
			BkgCstmsAnrVvdVO bkgCstmsAnrVvdVO = new BkgCstmsAnrVvdVO();
			bkgCstmsAnrVvdVO.setAnrDeclNo( ancsVesselInfoVO.getAnrDeclNo() );
			bkgCstmsAnrVvdVO.setRcv("Y"); //다이나믹 쿼리의 구분자.
			bkgCstmsAnrVvdVO.setAnrMsgStsCd( ancsVesselInfoVO.getAnrMsgStsCd() );
			bkgCstmsAnrVvdVO.setRefSeq( ancsVesselInfoVO.getRefSeq() );
			bkgCstmsAnrVvdVO.setUpdUsrId( "ANRACK" ); //UBIZHJS_ALPSBKG_ANRACK 에서 뒷자리만...
			bkgCstmsAnrVvdVOs.add(bkgCstmsAnrVvdVO);
			dbDao.modifyBkgCstmsAnrVvd(bkgCstmsAnrVvdVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}	
	
	
}