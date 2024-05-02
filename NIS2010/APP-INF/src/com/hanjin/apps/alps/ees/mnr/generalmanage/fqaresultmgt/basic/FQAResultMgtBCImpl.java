/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtBCImpl.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.20 성덕경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.integration.FQAResultMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SEONG DUK KYUNG
 * @see UI_MNR_0029EventResponse,FQAResultMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class FQAResultMgtBCImpl extends BasicCommandSupport implements FQAResultMgtBC {

	// Database Access Object
	private transient FQAResultMgtDBDAO dbDao = null;

	/**
	 * FQAResultMgtBCImpl 객체 생성<br>
	 * FQAResultMgtDBDAO를 생성한다.<br>
	 */
	public FQAResultMgtBCImpl() {
		dbDao = new FQAResultMgtDBDAO();
	}
	/**
	 * [EES_MNR_0223]FQA Result Detail Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAResultListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException {
		try {
			List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOS = dbDao.searchFQAResultListData(fQAResultMgtGRPVO.getFQAResultMgtINVO());
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOS(mnrFieldQualityAuditResultVOS);
			
			return fQAResultMgtGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0223] searchFQAResultListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0223] searchFQAResultListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<MnrFieldQualityAuditResultVO> insertVoList = new ArrayList<MnrFieldQualityAuditResultVO>();
			List<MnrFieldQualityAuditResultVO> updateVoList = new ArrayList<MnrFieldQualityAuditResultVO>();
			List<MnrFieldQualityAuditResultVO> deleteVoList = new ArrayList<MnrFieldQualityAuditResultVO>();
			
			MnrFieldQualityAuditResultVO[] mnrFieldQualityAuditResultVO = null;
			mnrFieldQualityAuditResultVO = fQAResultMgtGRPVO.getArrayMnrFieldQualityAuditResultVOs();
	
			for ( int i=0; i<mnrFieldQualityAuditResultVO.length; i++ ) {
				
				if ( mnrFieldQualityAuditResultVO[i].getIbflag().equals("U")){
					mnrFieldQualityAuditResultVO[i].setCreUsrId(account.getUsr_id());
					mnrFieldQualityAuditResultVO[i].setUpdUsrId(account.getUsr_id());
					mnrFieldQualityAuditResultVO[i].setFldAudDtlSeq(String.valueOf(i));
					if(mnrFieldQualityAuditResultVO[i].getFileSeq().equals("")){
						mnrFieldQualityAuditResultVO[i].setFileSeq("0");
					}
					int cnt	= dbDao.checkFQAResultDetailData(mnrFieldQualityAuditResultVO[i]);
					if(cnt>0) {
						updateVoList.add(mnrFieldQualityAuditResultVO[i]);
					}else{
						insertVoList.add(mnrFieldQualityAuditResultVO[i]);
					}
					
				}else if ( mnrFieldQualityAuditResultVO[i].getIbflag().equals("D")){	
					deleteVoList.add(mnrFieldQualityAuditResultVO[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addFQAResultDetailData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {

				String vndrSeq = fQAResultMgtGRPVO.getFQAResultMgtINVO().getVndrSeq();
				String ydcd = fQAResultMgtGRPVO.getFQAResultMgtINVO().getYdCd();
				String fldAudDt = fQAResultMgtGRPVO.getFQAResultMgtINVO().getFldAudDt();

				//최초저장시 저장여부확인
				if(fQAResultMgtGRPVO.getFQAResultMgtINVO().getKeyValue().equals("")){
					int cnt	= dbDao.checkFQAResultListData(vndrSeq, ydcd, fldAudDt);
					if(cnt>0) {
						throw new EventException(new ErrorHandler("MNR00185",new String[]{"Yard:"+ydcd+" "," S/Provider:"+vndrSeq+" "," Audit Date:"+fldAudDt+" "}).getMessage());
					}
				}
				dbDao.modifyFQAResultDetailData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeFQAResultDetailData(deleteVoList);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0029] manageFQAResultBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0029] manageFQAResultBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFQAResultBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			  FQAResultMgtINVO fQAResultMgtINVO = fQAResultMgtGRPVO.getFQAResultMgtINVO();
			  dbDao.removeFQAResultData(fQAResultMgtINVO.getVndrSeq(), fQAResultMgtINVO.getYdCd(), fQAResultMgtINVO.getFldAudDt());
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0029] removeFQAResultBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0029] removeFQAResultBasic"}).getMessage(),ex);
		}
	
	}

	/**
	 * [EES_MNR_0222]FQA Result Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtGRPVO fQAResultMgtGRPVO
	 * @return FQAResultMgtGRPVO
	 * @exception EventException
	 */
	public FQAResultMgtGRPVO searchFQAListBasic(FQAResultMgtGRPVO fQAResultMgtGRPVO) throws EventException {
		try {
			List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOS = dbDao.searchFQAListData(fQAResultMgtGRPVO.getFQAResultMgtINVO());
			fQAResultMgtGRPVO.setMnrFieldQualityAuditResultVOS(mnrFieldQualityAuditResultVOS);
			
			return fQAResultMgtGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0222] searchFQAListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0222] searchFQAListBasic"}).getMessage(),ex);
		}
	}
}