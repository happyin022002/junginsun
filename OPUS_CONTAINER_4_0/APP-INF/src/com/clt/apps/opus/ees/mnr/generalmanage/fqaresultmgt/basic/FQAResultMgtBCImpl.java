/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtBCImpl.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.integration.FQAResultMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see UI_MNR_0029EventResponse,FQAResultMgtBC DAO class reference
 * @since J2EE 1.4
 */
public class FQAResultMgtBCImpl extends BasicCommandSupport implements FQAResultMgtBC {

	// Database Access Object
	private transient FQAResultMgtDBDAO dbDao = null;

	/**
	 * creating FQAResultMgtBCImpl object<br>
	 * creating FQAResultMgtDBDAO <br>
	 */
	public FQAResultMgtBCImpl() {
		dbDao = new FQAResultMgtDBDAO();
	}
	/**
	 * [EES_MNR_0223] retrieving FQA Result Detail Pop Up. <br>
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
	 * [EES_MNR_0029] adding/modification/deletion FQA Result Creation. <br>
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

				// checking whether saving or not saving in case of initial saving 
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
	 * [EES_MNR_0029] deleting FQA Result Creation. <br>
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
	 * [EES_MNR_0222] retrieving FQA Result Inquiry. <br>
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