/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnsiteInspectionResultMgtBCImpl.java
*@FileTitle : OnsiteInspection Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.integration.OnsiteInspectionResultMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSite2VO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.vo.MnrOnSiteVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author LEE YULKYU
 * @see UI_MNR_0273EventResponse,OnsiteInspectionResultMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OnsiteInspectionResultMgtBCImpl extends BasicCommandSupport implements OnsiteInspectionResultMgtBC {

	// Database Access Object
	private transient OnsiteInspectionResultMgtDBDAO dbDao = null;

	/**
	 * OnsiteInspectionResultMgtBCImpl 객체 생성<br>
	 * OnsiteInspectionResultMgtDBDAO를 생성한다.<br>
	 */
	public OnsiteInspectionResultMgtBCImpl() {
		dbDao = new OnsiteInspectionResultMgtDBDAO();
	}

	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchMnrOnsiteInspectionResultDetail(MnrOnSiteVO mnrOnSiteVO) throws EventException {
		try {
			List<MnrOnSiteVO> mnrOnsiteInspectionResultVOS = dbDao.searchOnsiteInspectionResultDetailData(mnrOnSiteVO);
			
			return mnrOnsiteInspectionResultVOS;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] searchMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] searchMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 갱신 합니다. <br>
	 *
	 * @param MnrOnSiteVO[] mnrOnSiteVOs
	 * @exception EventException
	 */
	public void updateMnrOnsiteInspectionResultDetail(MnrOnSiteVO[] mnrOnSiteVOs) throws EventException {
		try {
			List<MnrOnSiteVO> list = new ArrayList<MnrOnSiteVO>();
			MnrOnSiteVO mnrOnSiteVO = new MnrOnSiteVO();
			mnrOnSiteVO.setVndrSeq(mnrOnSiteVOs[0].getVndrSeq());
			mnrOnSiteVO.setYdCd(mnrOnSiteVOs[0].getYdCd());
			mnrOnSiteVO.setFldInspDt(mnrOnSiteVOs[0].getFldInspDt());
			mnrOnSiteVO.setVndrSeqForSave(mnrOnSiteVOs[0].getVndrSeqForSave());
			mnrOnSiteVO.setYdCdForSave(mnrOnSiteVOs[0].getYdCdForSave());
			mnrOnSiteVO.setFldInspDtForSave(mnrOnSiteVOs[0].getFldInspDtForSave());
			mnrOnSiteVO.setUsrId(mnrOnSiteVOs[0].getUsrId());
			
			
			for(int i = 0; i < mnrOnSiteVOs.length; i++){
				mnrOnSiteVOs[i].setVndrSeq(mnrOnSiteVO.getVndrSeq());
				mnrOnSiteVOs[i].setYdCd(mnrOnSiteVO.getYdCd());
				mnrOnSiteVOs[i].setFldInspDt(mnrOnSiteVO.getFldInspDt());
				mnrOnSiteVOs[i].setVndrSeqForSave(mnrOnSiteVO.getVndrSeqForSave());
				mnrOnSiteVOs[i].setYdCdForSave(mnrOnSiteVO.getYdCdForSave());
				mnrOnSiteVOs[i].setFldInspDtForSave(mnrOnSiteVO.getFldInspDtForSave());
				mnrOnSiteVOs[i].setUsrId(mnrOnSiteVO.getUsrId());
				list.add(mnrOnSiteVOs[i]);
			}
			
			dbDao.updateOnsiteInspectionResultListData(list);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] updateMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] updateMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		}
		
	}

	/**
	 * [EES_MNR_0273]M&R Onsite Inspection Result Detail 의 정보를 삭제 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @exception EventException
	 */
	public void deleteMnrOnsiteInspectionResultDetail(MnrOnSiteVO mnrOnSiteVO) throws EventException {
		try {
			dbDao.deleteOnsiteInspectionResultListData(mnrOnSiteVO);
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] deleteMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0273] deleteMnrOnsiteInspectionResultDetail"}).getMessage(),ex);
		}
		
	}

	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchMnrOnsiteInspectionResultHeader(MnrOnSiteVO mnrOnSiteVO) throws EventException {
		try {
			List<MnrOnSiteVO> mnrOnsiteInspectionResultVOS = dbDao.searchOnsiteInspectionResultListData(mnrOnSiteVO);
			
			return mnrOnsiteInspectionResultVOS;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0271] searchMnrOnsiteInspectionResultHeader"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0271] searchMnrOnsiteInspectionResultHeader"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0271]M&R Onsite Inspection Result Header 의 정보를 조회 합니다. (직관적으로 수정)<br>
	 *
	 * @param MnrOnSite2VO mnrOnSite2VO
	 * @return List<MnrOnSite2VO>
	 * @exception EventException
	 */
	public List<MnrOnSite2VO> searchMnrOnsiteInspectionResultHeader2(MnrOnSite2VO mnrOnSite2VO) throws EventException {
		try {
			List<MnrOnSite2VO> mnrOnsiteInspectionResult2VOS = dbDao.searchOnsiteInspectionResultListData2(mnrOnSite2VO);
			
			return mnrOnsiteInspectionResult2VOS;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0271] searchMnrOnsiteInspectionResultHeader2"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0271] searchMnrOnsiteInspectionResultHeader2"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 조회 합니다. <br>
	 *
	 * @param MnrOnSiteVO mnrOnSiteVO
	 * @return List<MnrOnSiteVO>
	 * @exception EventException
	 */
	public List<MnrOnSiteVO> searchOnsiteInspectionResultItems(MnrOnSiteVO mnrOnSiteVO) throws EventException {
		try {
			List<MnrOnSiteVO> mnrOnsiteInspectionResultVOS = dbDao.searchOnsiteInspectionResultItems(mnrOnSiteVO);
			
			return mnrOnsiteInspectionResultVOS;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0274] searchOnsiteInspectionResultItems"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0274] searchOnsiteInspectionResultItems"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0274]M&R Onsite Inspection Result 의 설문항목들을 수정/삭제 합니다. <br>
	 *
	 * @param MnrOnSiteVO[] mnrOnSiteVOs
	 * @exception EventException
	 */
	public void insertOnsiteInspectionResultItems(MnrOnSiteVO[] mnrOnSiteVOs) throws EventException {
		try {
			// list: 사용자가 Delete 체크한 데이터들의 집합
			List<MnrOnSiteVO> list = new ArrayList<MnrOnSiteVO>();
			// list2: 사용자가 Insert 및 Update를 수행한 데이터들의 집합
			List<MnrOnSiteVO> list2 = new ArrayList<MnrOnSiteVO>();
			MnrOnSiteVO mnrOnSiteVO = new MnrOnSiteVO();
			mnrOnSiteVO.setVndrSeq(mnrOnSiteVOs[0].getVndrSeq());
			mnrOnSiteVO.setYdCd(mnrOnSiteVOs[0].getYdCd());
			mnrOnSiteVO.setFldInspDt(mnrOnSiteVOs[0].getFldInspDt());
			mnrOnSiteVO.setUsrId(mnrOnSiteVOs[0].getUsrId());
			
			
			for(int i = 0; i < mnrOnSiteVOs.length; i++){
				if("D".equals(mnrOnSiteVOs[i].getIbflag())){
					mnrOnSiteVOs[i].setVndrSeq(mnrOnSiteVO.getVndrSeq());
					mnrOnSiteVOs[i].setYdCd(mnrOnSiteVO.getYdCd());
					mnrOnSiteVOs[i].setFldInspDt(mnrOnSiteVO.getFldInspDt());
					mnrOnSiteVOs[i].setUsrId(mnrOnSiteVO.getUsrId());
					list.add(mnrOnSiteVOs[i]);	
				}else{
					mnrOnSiteVOs[i].setVndrSeq(mnrOnSiteVO.getVndrSeq());
					mnrOnSiteVOs[i].setYdCd(mnrOnSiteVO.getYdCd());
					mnrOnSiteVOs[i].setFldInspDt(mnrOnSiteVO.getFldInspDt());
					mnrOnSiteVOs[i].setUsrId(mnrOnSiteVO.getUsrId());
					list2.add(mnrOnSiteVOs[i]);
				}
			}
			dbDao.updateOnsiteInspectionResultItems(list); // DB상에서 영구 삭제하지 않고 Flag만 Y로 변경 (향후 복구 작업에 활용)
			dbDao.insertOnsiteInspectionResultItems(list2); // INSERT 및 UPDATE를 수행함.
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0274] insertOnsiteInspectionResultItems"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0274] insertOnsiteInspectionResultItems"}).getMessage(),ex);
		}
	}
}