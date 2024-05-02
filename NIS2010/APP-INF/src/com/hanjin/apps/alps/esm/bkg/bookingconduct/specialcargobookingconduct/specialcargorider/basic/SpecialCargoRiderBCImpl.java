/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SpecialCargoRiderBCImpl.java
 *@FileTitle : B/L Rider
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.16
 *@LastModifier : 이진서
 *@LastVersion : 1.0
 * 2009.06.16 이진서
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration.SpecialCargoRiderDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderOutVO;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgImgStoVO;

/**
 * ALPS-SpecialCargoBookingConduct Business Logic Basic Command
 * implementation<br>
 * - ALPS-SpecialCargoBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Jin Seo
 * @see UI_BKG_0207EventResponse,SpecialCargoRiderBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpecialCargoRiderBCImpl extends BasicCommandSupport implements SpecialCargoRiderBC {

	// Database Access Object
	private transient SpecialCargoRiderDBDAO dbDao = null;

	/**
	 * SpecialCargoRiderBCImpl 객체 생성<br>
	 * SpecialCargoRiderDBDAO를 생성한다.<br>
	 */
	public SpecialCargoRiderBCImpl() {
		dbDao = new SpecialCargoRiderDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0369 화면에 대한 조회 이벤트 처리<br>
	 * b/l의 rider image 정보 list를 조회함
	 *
	 * @author Lee Jin Seo
	 * @param AttachFileInVO attachFileInVO
	 * @return List<AttachFileOutVO>
	 * @exception EventException
	 */
	public List<AttachFileOutVO> searchAttachFileList(AttachFileInVO attachFileInVO) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == searchAttachFileList SEARCH ]==========");
		List<AttachFileOutVO> list = null;
		try {
			list = dbDao.searchAttachFileList(attachFileInVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
		return list;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0369 화면에 대한 조회 이벤트 처리<br>
	 * b/l의 rider image 정보 list를 조회함
	 *
	 * @author Lee Jin Seo
	 * @param BlRiderInVO blRiderIn
	 * @return List<BlRiderOutVO>
	 * @exception EventException
	 */
	public List<BlRiderOutVO> searchBlRiderList(BlRiderInVO blRiderIn) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == searchBlRiderList SEARCH ]==========");
		List<BlRiderOutVO> list = null;
		try {
			list = dbDao.searchBlRiderList(blRiderIn);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
		return list;
	}

	/**
	 * ESM_BKG_0369 멀티 이벤트 처리<br>
	 * ESM_BKG_0369 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * //1.UPDATE 상태를 확인한다. <br>
	 * //1-1 delete List 추가 <br>
	 * //1-1-1 UpdateFileMetaInfo file_meta 정보 삭제 (FILE_SAVE_ID)<br>
	 * //1-2 insert List 추가 <br>
	 * //2. DELETE 상태를 확인 <br>
	 * //2-1 delete List 추가 <br>
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제 (FILE_SAVE_ID)<br>
	 * //3. INSERT 상태를 확인 <br>
	 * //3-1 insert List 추가 <br>
	 * //4. 삭제먼저 수행하고 추가를 수행한다. <br>
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리 <br>
	 *
	 * @author Lee Jin Seo
	 * @param BlRiderInVO blRiderIn
	 * @exception EventException
	 */
	public void manageBlRider(BlRiderInVO blRiderIn) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == manageBlRider  ]==========");
		BkgImgStoVO[] bkgImgStoVO = blRiderIn.getBkgImgStoVOs();
		SignOnUserAccount account = blRiderIn.getAccount();
		String bkgNo = blRiderIn.getBkgNo();// booking number
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code
		String[] fileSavId = blRiderIn.getKeys();

		try {
			List<BkgImgStoVO> insertVoList = new ArrayList<BkgImgStoVO>();
			List<BkgImgStoVO> deleteVoList = new ArrayList<BkgImgStoVO>();
			List<BkgImgStoVO> updateVoList = new ArrayList<BkgImgStoVO>();
			int save_id_cnt = 0;
			for (int i = 0; i < bkgImgStoVO.length; i++) {

				if (bkgImgStoVO[i].getIbflag().equals("U")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] updateVoList=====" + bkgImgStoVO[i].getFileSavId());
					deleteVoList.add(bkgImgStoVO[i]);
					bkgImgStoVO[i].setIbflag("I");
				}

				if (bkgImgStoVO[i].getIbflag().equals("D")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] deleteVoList =====" + bkgImgStoVO[i].getFileSavId());
					bkgImgStoVO[i].setBkgNo(bkgNo);
					deleteVoList.add(bkgImgStoVO[i]);
					UpdateFileMetaInfo.delete(bkgImgStoVO[i].getFileSavId());

				} else if (bkgImgStoVO[i].getIbflag().equals("I")) {
					log.debug("[START:: SpecialCargoRiderBCImpl] insertVoList =====" + bkgImgStoVO[i].getFileSavId());
					bkgImgStoVO[i].setBkgNo(bkgNo);

					if (bkgImgStoVO[i].getFileSavId() == null || bkgImgStoVO[i].getFileSavId().length() == 0) {
						bkgImgStoVO[i].setFileSavId(fileSavId[save_id_cnt++]);
					}

					bkgImgStoVO[i].setCreUsrId(use_id);
					bkgImgStoVO[i].setRgstOfcCd(ofc_cd);
					bkgImgStoVO[i].setRgstUsrId(use_id);
					bkgImgStoVO[i].setUpdUsrId(use_id);

					insertVoList.add(bkgImgStoVO[i]);
				}
			}
			if (deleteVoList.size() > 0) {

				dbDao.removeBlRider(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addBlRider(insertVoList);

				// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
				updateVoList.add(bkgImgStoVO[0]);
				dbDao.modifyBlRider(updateVoList);
			}

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
	 * ESM_BKG_0207 조회 이벤트 처리<br>
	 * ESM_BKG_0207 화면에 대한 조회 이벤트 처리<br>
	 * b/l의 SpclRider image 정보 list를 조회함
	 *
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderIn
	 * @return SpclRiderOutVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public SpclRiderOutVO searchSpclRiderList(SpclRiderInVO spclRiderIn) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == searchSpclRiderList SEARCH ]==========");
		SpclRiderOutVO spclRiderOutVO = new SpclRiderOutVO();
		List spclRiderVO = null;
		List spclCntrListVO = null;

		try {
			// 파일 목록
			spclRiderVO = dbDao.searchSpclRiderList(spclRiderIn);
			spclRiderOutVO.setO_spclRiderVO(spclRiderVO);

			// booking번호에 따른 컨테이너 번호
			spclCntrListVO = dbDao.searchSpclRiderList1(spclRiderIn);
			spclRiderOutVO.setO_spclCntrListVO(spclCntrListVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);       
		}
		log.debug("[END::]==========");
		return spclRiderOutVO;
	}

	/**
	 * ESM_BKG_0207 멀티 이벤트 처리<br>
	 * ESM_BKG_0207 화면에 대한 멀티 이벤트 처리<br>
	 * //1.UPDATE 상태를 확인한다.
	 * //1-1 delete List 추가
	 * //1-1-1 UpdateFileMetaInfo
	 * file_meta 정보 삭제 (FILE_SAVE_ID)
	 * //1-2 insert List 추가
	 * //2. DELETE 상태를 확인
	 * //2-1 delete List 추가
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제
	 * (FILE_SAVE_ID)
	 * //3. INSERT 상태를 확인
	 * //3-1 insert List 추가
	 * //4. 삭제먼저 수행하고 추가를수행한다.
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderIn
	 * @exception EventException
	 */
	public void manageSpclRider(SpclRiderInVO spclRiderIn) throws EventException {
		log.debug("[START:: SpecialCargoRiderBCImpl == manageSpclRider  ]==========");
		BkgImgStoVO[] bkgImgStoVO = spclRiderIn.getBkgImgStoVOs();
		SignOnUserAccount account = spclRiderIn.getAccount();
		String bkgNo = spclRiderIn.getBkgNo();// booking number
		String ridrTpCd = spclRiderIn.getRidrTpCd();// rider type code
		String use_id = account.getUsr_id();// user id
		String ofc_cd = account.getOfc_cd();// user office code
		String[] fileSavId = spclRiderIn.getKeys();

		try {
			List<BkgImgStoVO> insertVoList = new ArrayList<BkgImgStoVO>();
			List<BkgImgStoVO> deleteVoList = new ArrayList<BkgImgStoVO>();
			List<BkgImgStoVO> updateVoList = new ArrayList<BkgImgStoVO>();
			int save_id_cnt = 0;
			for (int i = 0; i < bkgImgStoVO.length; i++) {
				if (bkgImgStoVO[i].getIbflag().equals("U")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]updateVoList=====" + bkgImgStoVO[i].getFileSavId());
					deleteVoList.add(bkgImgStoVO[i]);
					bkgImgStoVO[i].setIbflag("I");
				}

				if (bkgImgStoVO[i].getIbflag().equals("D")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]deleteVoList=====" + bkgImgStoVO[i].getFileSavId());
					bkgImgStoVO[i].setBkgNo(bkgNo);
					bkgImgStoVO[i].setRidrTpCd(ridrTpCd);
					deleteVoList.add(bkgImgStoVO[i]);
					UpdateFileMetaInfo.delete(bkgImgStoVO[i].getFileSavId());

				} else if (bkgImgStoVO[i].getIbflag().equals("I")) {
					log.debug("[START:: SpecialCargoRiderBCImpl]insertVoList=====" + bkgImgStoVO[i].getFileSavId());
					bkgImgStoVO[i].setBkgNo(bkgNo);
					bkgImgStoVO[i].setRidrTpCd(ridrTpCd);

					if (bkgImgStoVO[i].getFileSavId() == null || bkgImgStoVO[i].getFileSavId().length() == 0) {
						bkgImgStoVO[i].setFileSavId(fileSavId[save_id_cnt++]);
					}

					bkgImgStoVO[i].setCreUsrId(use_id);
					bkgImgStoVO[i].setRgstOfcCd(ofc_cd);
					bkgImgStoVO[i].setRgstUsrId(use_id);
					bkgImgStoVO[i].setUpdUsrId(use_id);
					insertVoList.add(bkgImgStoVO[i]);
				}
			}
			if (deleteVoList.size() > 0) {

				dbDao.removeSpclRider(deleteVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addSpclRider(insertVoList);

				// insert 있는 경우만 마지막처리 com_upload 테이블과 sync 맞추기
				updateVoList.add(bkgImgStoVO[0]);
				dbDao.modifySpclRider(updateVoList);
			}

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
	 * DG rider를 Master booking으로 이동.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO[] targetBkg
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copySpclRiderAfterCombine(BkgBlNoVO sourceBkg,BkgBlNoVO[] targetBkg, SignOnUserAccount account) throws EventException{
		try {
			if ( targetBkg != null ) {
				for(int i=0;i<targetBkg.length;i++){
					dbDao.copySpclRiderAfterCombine(targetBkg[i], sourceBkg, account);
				}
			}
		} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
     * DG rider를 Master booking에서 삭제
     * @param  BkgBlNoVO[] bkgBlNoVO
     * @exception EventException
     */
    public void removeSpclRiderAfterCombine(BkgBlNoVO[] bkgBlNoVO) throws EventException { 
    	try {
    		if ( bkgBlNoVO != null ) {
				for(int i=0;i<bkgBlNoVO.length;i++){
					dbDao.removeSpclRiderAfterCombine(bkgBlNoVO[i]);
				}
    		}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	@Override
	public void removeSpclRider(BkgImgStoVO vo) throws EventException {
		try {
				dbDao.removeSpclRider(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
}