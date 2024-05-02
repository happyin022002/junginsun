/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TrsAdvanceAuditBC   
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

import java.util.List;

import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteCondVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudCrteListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudDtlListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TrsAdvanceAuditBC PDTO(Data Transfer Object including Parameters)<br>
 * @author 최종혁
 * @see TrsAdvanceAuditBCImpl  참조
 * @since J2EE 1.4
 */
public interface TrsAdvanceAuditBC {
	
	/**
	 * TRS Pre-Audit Criterion setting 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteListVO> searchTrsCrteList(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws EventException;	

	/**
	 * ESD_EAS_0342 - Save<br>
	 * 
	 * @param TrsPreAudCrteListVO[] listVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiTrsCrte(TrsPreAudCrteListVO[] listVos, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_EAS_0342 - Delete<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @exception EventException
	 */
	public void removeTrsCrte(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws EventException;
	
	
	
	/**
	 * Transportation Invoice Charge 조회한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudListVO> searchTrsPreAudList(TrsPreAudListVO trsPreAudListVO) throws EventException;
	
	/**
	 * Add office 시 등록된 office 인지 조회한다.<br>
	 * 
	 * @param TrsPreAudCrteCondVO trsPreAudCrteCondVO
	 * @return List<TrsPreAudCrteCondVO>
	 * @exception EventException
	 */
	public List<TrsPreAudCrteCondVO> searchAddOffice(TrsPreAudCrteCondVO trsPreAudCrteCondVO) throws EventException;

	/**
	 * Transportation Invoice Charge - detail 조회한다.<br>
	 * 
	 * @param TrsPreAudDtlListVO trsPreAudDtlListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudDtlListVO> searchTrsPreAudDtlList(TrsPreAudDtlListVO trsPreAudDtlListVO) throws EventException;

	/**
	 * Transportation Invoice Charge  를 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO[] trsPreAudListVOs
	 * @exception EventException
	 */
	public void confirmTrsPreAudit(TrsPreAudListVO[] trsPreAudListVOs) throws EventException;
	
	/**
	 * Transportation Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @return List<TrsPreAudListVO>
	 * @exception EventException
	 */
	public List<TrsPreAudListVO> searchTrsAutoAudList(TrsPreAudListVO trsPreAudListVO) throws EventException;
	
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(TrsPreAudListVO trsPreAudListVO) throws EventException;
	
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(TrsPreAudListVO trsPreAudListVO) throws EventException;
	
	/**
	 * 실시간 배치 대상의 상태코드를 완료로 변경한다.<br>
	 * 
	 * @param TrsPreAudListVO trsPreAudListVO
	 * @exception EventException
	 */
	public void updateBatchStatus(TrsPreAudListVO trsPreAudListVO) throws EventException;
	
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param TrsPreAudListVO[] trsPreAudListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(TrsPreAudListVO[] trsPreAudListVOs) throws EventException;
	
}
