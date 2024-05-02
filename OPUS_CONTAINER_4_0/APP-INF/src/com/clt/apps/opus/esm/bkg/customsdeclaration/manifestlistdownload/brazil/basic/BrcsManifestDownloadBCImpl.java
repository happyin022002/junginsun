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
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration.BrcsManifestDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCmModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCnpiNcmByCntrModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ConatinerModificationtVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see BrcsManifestDownloadDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class BrcsManifestDownloadBCImpl extends BasicCommandSupport implements BrcsManifestDownloadBC {

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
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	@Override
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO, SignOnUserAccount account) throws EventException {

		try {
			
			return dbDao.searchBrManifestList((BrManifestListCondVO)manifestListCondVO, account);
			
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		
	}
	
	/**
	 * 신고대상 목록을 삭제 한다.<Br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String deleteManifest(ManifestModificationVO[] manifestModificationVOs) throws EventException {

		try {
			List<BrCmModiVO> addBLVOList = new ArrayList<BrCmModiVO>();

			for (int i = 0; i < manifestModificationVOs.length; i++) {
				BrCmModiVO vo = (BrCmModiVO) manifestModificationVOs[i];

				if( vo.getIbflag().equals("D") ) {
					addBLVOList.add(vo);
				}
			}
			if(addBLVOList.size() > 0) {
				dbDao.removeBrCMDtl(addBLVOList);
				dbDao.removeBrBl(addBLVOList);
			}
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return "Y";
	}
	
	
	/**
	 * OB쪽 정보를 세관쪽 테이블로 저장한다.(BKG_CSTMS_BRZ_BL, BKG_CSTMS_BRZ_CNTR_MF) <br>
	 * 
	 * @param ManifestModificationVO[] manifestModificationVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) throws EventException {
		
		try {
			List<BrCmModiVO> addBLVOList = new ArrayList<BrCmModiVO>();

			String oldBlNo = "";
			
			for (int i = 0; i < manifestModificationVOs.length; i++) {
				BrCmModiVO vo = (BrCmModiVO) manifestModificationVOs[i];
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());

				if(!oldBlNo.equals(vo.getBlNo()) ) {
					addBLVOList.add(vo);
				}
				oldBlNo = vo.getBlNo();
			}

			if(addBLVOList.size() > 0) {
				dbDao.removeBrCMDtl(addBLVOList);
				dbDao.removeBrBl(addBLVOList);
				
				dbDao.addBrBl(addBLVOList);
				dbDao.addBrCMDtl(addBLVOList);
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

		try {
			List<BrCnpiNcmByCntrModiVO> modBlList = new ArrayList<BrCnpiNcmByCntrModiVO>();
			List<BrCnpiNcmByCntrModiVO> delNcmNoList = new ArrayList<BrCnpiNcmByCntrModiVO>();
			List<BrCnpiNcmByCntrModiVO> addNcmNoList = new ArrayList<BrCnpiNcmByCntrModiVO>();

			String oldBlNo = "";
			String[] ncmNoArr = null;
			
			for (int i = 0; i < conatinerModificationtVOs.length; i++) {
				BrCnpiNcmByCntrModiVO vo = (BrCnpiNcmByCntrModiVO) conatinerModificationtVOs[i];
				vo.setUpdUsrId(account.getUsr_id());
				
				if(!oldBlNo.equals(vo.getBlNo()) ) {
					modBlList.add(vo);
				}
				delNcmNoList.add(vo);
				
				ncmNoArr = vo.getNcmMultiNo().split(",");
				for( int j = 0; j < ncmNoArr.length; j++ ) {
					BrCnpiNcmByCntrModiVO addNcmNo = new BrCnpiNcmByCntrModiVO();
					addNcmNo.setBlNo(vo.getBlNo());
					addNcmNo.setCntrNo(vo.getCntrNo());
					addNcmNo.setCntrMfSeq(vo.getCntrMfSeq());
					addNcmNo.setMfDtlSeq(Integer.toString(j + 1));
					addNcmNo.setNcmNo(ncmNoArr[j]);
					addNcmNo.setUpdUsrId(vo.getUpdUsrId());
					addNcmNoList.add(addNcmNo);
				}
				oldBlNo = vo.getBlNo();
			}
			
			if(modBlList.size() > 0) {
				dbDao.modifyCnpjNcmByBl(modBlList);
			}
			if(delNcmNoList.size() > 0) {
				dbDao.removeBrzCntrMfNcmDtl(delNcmNoList);
			}
			if(addNcmNoList.size() > 0) {
				dbDao.addBrzCntrMfNcmDtl(addNcmNoList);
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
	public void manageHSCode(BrHsCdDetailVO[] brHsCdDetailVOs, SignOnUserAccount account) 	throws EventException {
		
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