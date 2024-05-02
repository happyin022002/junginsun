/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestListDownloadBCImpl.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.04.29 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration.BrcsManifestDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCmModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCnpiNcmByCntrModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see BrcsManifestDownloadDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BrcsManifestDownloadBCImpl extends ManifestListDownloadBCImpl {

	// Database Access Object
	private transient BrcsManifestDownloadDBDAO dbDao = null;

	/**
	 * ManifestListDownloadBCImpl 객체 생성<br>
	 * ManifestListDownloadDBDAO를 생성한다.<br>
	 */
	public BrcsManifestDownloadBCImpl() {
		dbDao = new BrcsManifestDownloadDBDAO();
	}
	
	/**
	 * Harmonized Tariff code 입력을 위한 조회
	 * @param brHsCdCondVO
	 * @return List<BrHsCdDetailVO>
	 * @throws EventException
	 */
	public List<BrHsCdDetailVO> searchHsCdList(BrHsCdCondVO brHsCdCondVO) throws EventException {
		
		try {
			
			return dbDao.searchHsCdList((BrHsCdCondVO)brHsCdCondVO);
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	


	/**
	 * 신고대상 목록을 조회 해 온다.<Br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	@Override
	public List<ManifestListDetailVO> searchManifestList(
			ManifestListCondVO manifestListCondVO) throws EventException {

		try {
			
			return dbDao.searchBrManifestList((BrManifestListCondVO)manifestListCondVO);
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
	}

	/**
	 * OB쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_BRZ_BL, BKG_CSTMS_BRZ_CNTR_MF) <br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) 
		throws EventException {
		
		try {
			List<BrCmModiVO> addBLVOList = new ArrayList<BrCmModiVO>();
			List<BrCmModiVO> addCMVOList = new ArrayList<BrCmModiVO>();
			List<BrCmModiVO> addCMDtlVOList = new ArrayList<BrCmModiVO>();

			List<BrCmModiVO> reAddBLVOList = new ArrayList<BrCmModiVO>();
			List<BrCmModiVO> reAddCMVOList = new ArrayList<BrCmModiVO>();
			List<BrCmModiVO> reAddCMDtlVOList = new ArrayList<BrCmModiVO>();

			String oldBlNo = "";
			String currBlNo = "";
			
			// History 
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			HistoryLineVO historyLineVO = new HistoryLineVO();
			
			for (int i = 0; i < manifestModificationVOs.length; i++) {
				BrCmModiVO vo = (BrCmModiVO) manifestModificationVOs[i];
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				
				currBlNo = vo.getBlNo();
				
				if(vo.getIfFlag().equals("N") && !oldBlNo.equals(currBlNo) ) {
					addBLVOList.add(vo);
					addCMVOList.add(vo);
					addCMDtlVOList.add(vo);
				}

				if(vo.getIfFlag().equals("Y") && !oldBlNo.equals(currBlNo) ) {
					
//					vo.setShprTaxNo(vo.getObShprTaxNo());
//					vo.setCneeTaxNo(vo.getObCneeTaxNo());
//					vo.setNtfyTaxNo(vo.getObNtfyTaxNo());
//					vo.setBrzDeclNo(vo.getObBrzDeclNo());
					
					vo.setShprTaxNo("");
					vo.setCneeTaxNo("");
					vo.setNtfyTaxNo("");
					vo.setBrzDeclNo("");

					reAddBLVOList.add(vo);
					reAddCMVOList.add(vo);
					reAddCMDtlVOList.add(vo);					
				}
				
				if ( !oldBlNo.equals(currBlNo)) {
					historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(currBlNo);
					historyLineVO.setUiId("ESM_BKG_0127");
					historyLineVO.setCrntCtnt("Brazil DownLoad");
					historyLineVO.setHisCateNm("Brazil DownLoad"); 
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
				
				oldBlNo = currBlNo;
			}

			if(addBLVOList.size() > 0) {
				dbDao.addBrBl(addBLVOList);
			}
			if(addCMVOList.size() > 0) {
				dbDao.addBrCM(addCMVOList);
			}
			if(addCMVOList.size() > 0) {
				dbDao.addBrCMDtl(addCMDtlVOList);
			}

			if(reAddBLVOList.size() > 0) {
				dbDao.removeBrBl(reAddBLVOList);
				dbDao.addBrBl(reAddBLVOList);
			}
			if(reAddCMVOList.size() > 0) {
				dbDao.removeBrCM(reAddCMVOList);
				dbDao.addBrCM(reAddCMVOList);
			}
			if(reAddCMDtlVOList.size() > 0) {
				dbDao.removeBrCMDtl(reAddCMDtlVOList);
				dbDao.addBrCMDtl(reAddCMDtlVOList);
			}
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		
		
	}
	
	/**
	 * 세관쪽 테이블을 업테이트한다.(BKG_CSTMS_BRZ_BL, BKG_CSTMS_BRZ_CNTR_MF) <br>
	 * 
	 * @param ConatinerModificationtVO[] conatinerModificationtVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyContainerManifest(ConatinerModificationtVO[] conatinerModificationtVOs, SignOnUserAccount account) throws EventException {
		String[] ncmNoArr = null;
		
		try {
			List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVO1s = new ArrayList<BrCnpiNcmByCntrModiVO>();
			List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVO2s = new ArrayList<BrCnpiNcmByCntrModiVO>();
			List<BrCnpiNcmByCntrModiVO> brCnpiNcmByCntrModiVO3s = new ArrayList<BrCnpiNcmByCntrModiVO>();
			
			for (int idx = 0; idx < conatinerModificationtVOs.length; idx++) {
				BrCnpiNcmByCntrModiVO vo = (BrCnpiNcmByCntrModiVO) conatinerModificationtVOs[idx];
				vo.setUpdUsrId(account.getUsr_id());
	
				if( vo.getIfFlag().equals("Y") && !vo.getBlNo().equals("") ){
					brCnpiNcmByCntrModiVO1s.add(vo);
				}
				
				if( vo.getIfFlag().equals("Y") ){
					brCnpiNcmByCntrModiVO2s.add(vo);
				}
				
				if( !vo.getNcmMultiNo().equals("") ){
					ncmNoArr = vo.getNcmMultiNo().split(",");
					for( int jdx = 0; jdx < ncmNoArr.length; jdx++ ){
						BrCnpiNcmByCntrModiVO inputNcmDtlVO = new BrCnpiNcmByCntrModiVO();
						
						inputNcmDtlVO.setBlNo(vo.getBlNo());
						inputNcmDtlVO.setCntrNo(vo.getCntrNo());
						inputNcmDtlVO.setCntrMfSeq(vo.getCntrMfSeq());
						inputNcmDtlVO.setMfDtlSeq(Integer.toString(jdx+1));
						inputNcmDtlVO.setNcmNo(ncmNoArr[jdx]);
						inputNcmDtlVO.setUpdUsrId(vo.getUpdUsrId());
						
						brCnpiNcmByCntrModiVO3s.add(inputNcmDtlVO);
					}
				}
			}
			
			if(brCnpiNcmByCntrModiVO1s.size() > 0) {
				dbDao.modifyCnpjNcmByBl(brCnpiNcmByCntrModiVO1s);
			}
			
			if(brCnpiNcmByCntrModiVO2s.size() > 0) {
				dbDao.modifyCnpjNcmByCntr(brCnpiNcmByCntrModiVO2s);
				manageBrzCntrMfNCMList(brCnpiNcmByCntrModiVO2s, "D");
			}
			
			if(brCnpiNcmByCntrModiVO3s.size() > 0) {
				manageBrzCntrMfNCMList(brCnpiNcmByCntrModiVO3s, "C");
			}
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * @param inputListVO
	 * @param flg
	 * @throws EventException
	 */
	public void manageBrzCntrMfNCMList(List<BrCnpiNcmByCntrModiVO> inputListVO, String flg) throws EventException {
		try {
			if( "C".equals(flg) ){			//Insert
				dbDao.addBrzCntrMfNcmDtl(inputListVO);
			} else if( "D".equals(flg) ){	//Delete
				dbDao.removeBrzCntrMfNcmDtl(inputListVO);
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * HS CODE 를 입력,수정 삭제 한다. <br>
	 * 
	 * @param BrHsCdDetailVO[] brHsCdDetailVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageHSCode(BrHsCdDetailVO[] brHsCdDetailVOs, SignOnUserAccount account) 
		throws EventException {
		
		
		try {
			List<BrHsCdDetailVO> addVOList = new ArrayList<BrHsCdDetailVO>();
			List<BrHsCdDetailVO> modVOList = new ArrayList<BrHsCdDetailVO>();
			List<BrHsCdDetailVO> delVOList = new ArrayList<BrHsCdDetailVO>();

			BrHsCdDetailVO vo = null;
			
			for (int i = 0; i < brHsCdDetailVOs.length; i++) {
				vo = (BrHsCdDetailVO) brHsCdDetailVOs[i];
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				
				if ( vo.getIbflag().equals("I")){
					addVOList.add(vo);
				} else if ( vo.getIbflag().equals("U")){
					modVOList.add(vo);
				} else if ( vo.getIbflag().equals("D")){
					delVOList.add(vo);
				}
				
			}

			if(addVOList.size() > 0) {
				dbDao.addHSCode(addVOList);
			}
			if(modVOList.size() > 0) {
				dbDao.modifyHSCode(modVOList);
			}
			if(delVOList.size() > 0) {
				dbDao.removeHSCode(delVOList);
			}
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		
		
	}	
	
	

}