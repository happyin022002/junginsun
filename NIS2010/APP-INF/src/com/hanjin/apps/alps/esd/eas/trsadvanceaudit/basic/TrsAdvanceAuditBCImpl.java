/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsAdvanceAuditBCImpl
*@FileTitle : Equipment Auto Audit
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration.TrsAdvanceAuditDBDAO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteCondVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudDtlListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TrsAdvanceAuditBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author 최종혁
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class TrsAdvanceAuditBCImpl  extends BasicCommandSupport implements TrsAdvanceAuditBC{
	
	private transient TrsAdvanceAuditDBDAO dbDao=null;

	/**
	 * TrsAdvanceAuditBCImpl 객체 생성<br>
	 * TrsAdvanceAuditDBDAO 생성한다.<br>
	 */
	public TrsAdvanceAuditBCImpl(){
		dbDao = new TrsAdvanceAuditDBDAO();
	}
	
	/**
	 * TRS Pre-Audit Criterion setting 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteListVO> searchTrsCrteList(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws EventException{
		try {
			return dbDao.searchTrsCrteList(trsPreAudCrteCondVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * ESD_EAS_0342 - Save<br>
	 * 
	 * @param TrsPreAudCrteListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiTrsCrte(TrsPreAudCrteListVO[] listVos, SignOnUserAccount account) throws EventException{ 
		try {
			List<TrsPreAudCrteListVO> updateVoList = new ArrayList<TrsPreAudCrteListVO>();
			for ( int i=0; i<listVos .length; i++ ) {
				if ( listVos[i].getIbflag().equals("I") || listVos[i].getIbflag().equals("U")){
					listVos[i].setUpdUsrId(account.getUsr_id());
					listVos[i].setCreOfcCd(account.getOfc_cd());
					updateVoList.add(listVos[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTrsCrte(updateVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_0342 - Delete<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @exception EventException
	 */
	public void removeTrsCrte(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws EventException{
		try {
			dbDao.removeTrsCrte(trsPreAudCrteCondVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * TRS Pre-Audit Criterion setting 조회한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudListVO> searchTrsPreAudList(TrsPreAudListVO trsPreAudListVO)  throws EventException {
		try {
			return dbDao.searchTrsPreAudList(trsPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Add office 시 등록된 office 인지 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteCondVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteCondVO> searchAddOffice(TrsPreAudCrteCondVO trsPreAudCrteCondVO)  throws EventException {
		try {
			return dbDao.searchAddOffice(trsPreAudCrteCondVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * TRS Pre-Audit Criterion setting-detail 조회한다.<br>
	 * 
	 * @param TrsPreAudDtlListVO trsPreAudDtlListVO
	 * @return List<TrsPreAudDtlListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudDtlListVO> searchTrsPreAudDtlList(TrsPreAudDtlListVO trsPreAudDtlListVO)  throws EventException {
		try {
			return dbDao.searchTrsPreAudDtlList(trsPreAudDtlListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	
	/**
	 *TRS Pre-Audit Criterion setting 를 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO[] trsPreAudListVOs
	 * @exception EventException
	 */
	public void confirmTrsPreAudit(TrsPreAudListVO[] trsPreAudListVOs) throws EventException {
		try {
			TrsPreAudListVO trsPreAudListVO = new TrsPreAudListVO();
			for ( int i=0; i<trsPreAudListVOs.length; i++ ) {
				trsPreAudListVO = trsPreAudListVOs[i];
				trsPreAudListVO.setSSaveTpCd(trsPreAudListVOs[0].getSSaveTpCd());
				dbDao.confirmTrsPreAudit(trsPreAudListVO);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Transportation Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudListVO> searchTrsAutoAudList(TrsPreAudListVO trsPreAudListVO)  throws EventException {
		try {
			return dbDao.searchTrsAutoAudList(trsPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(TrsPreAudListVO trsPreAudListVO) throws EventException {
		try {
			dbDao.addAutoAuditHis(trsPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(TrsPreAudListVO trsPreAudListVO) throws EventException {
		try {
			dbDao.removeAutoAudit(trsPreAudListVO);
			dbDao.removeAutoAuditDtl(trsPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void updateBatchStatus(TrsPreAudListVO trsPreAudListVO) throws EventException {
		try {
			dbDao.updateBatchStatus(trsPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO[] trsPreAudListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(TrsPreAudListVO[] trsPreAudListVOs) throws EventException {
		try {
			TrsPreAudListVO trsPreAudListVO = new TrsPreAudListVO();
			for ( int i=0; i<trsPreAudListVOs.length; i++ ) {
				trsPreAudListVO = trsPreAudListVOs[i];
				dbDao.saveReBatchTarget(trsPreAudListVO);
		    }
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}

