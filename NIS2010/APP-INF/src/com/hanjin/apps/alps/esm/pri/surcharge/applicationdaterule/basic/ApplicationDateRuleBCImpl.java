/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleBCImpl.java
*@FileTitle : Application Date Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.07.07 김민아
* 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
                                                                      추가요건 - 조회 조건으로 access date 추가. Duration 중복 조건에 포함하여 그 날짜가 포함관계에 있으면 중복으로 처리.
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration.ApplicationDateRuleDBDAO;
import com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.vo.RsltPriScgAplyDtRuleVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgAplyDtRuleVO;

/**
 * NIS2010-ApplicationDateRule Business Logic Basic Command implementation<br>
 * - NIS2010-ApplicationDateRule에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Min Ah
 * @see ESM_PRI_4033EventResponse,ApplicationDateRuleBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ApplicationDateRuleBCImpl extends BasicCommandSupport implements ApplicationDateRuleBC {

	// Database Access Object
	private transient ApplicationDateRuleDBDAO dbDao = null;

	/**
	 * ApplicationDateRuleBCImpl 객체 생성<br>
	 * ApplicationDateRuleDBDAO 생성한다.<br>
	 */
	public ApplicationDateRuleBCImpl() {
		dbDao = new ApplicationDateRuleDBDAO();
	}
	
	/**
	 * Percentage Base Code를 조회합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO priScgAplyDtRuleVO
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriScgAplyDtRuleVO> searchApplicatoinDateRule(PriScgAplyDtRuleVO priScgAplyDtRuleVO) throws EventException {
		try {
			return dbDao.searchApplicatoinDateRule(priScgAplyDtRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Application Date Rule 을 저장합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageApplicationDateRule(PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriScgAplyDtRuleVO> insertVoList = new ArrayList<PriScgAplyDtRuleVO>();
			List<PriScgAplyDtRuleVO> updateVoList = new ArrayList<PriScgAplyDtRuleVO>();
			
			if(priScgAplyDtRuleVOs == null) {
				return;
			}
			
			for(int i=0; i<priScgAplyDtRuleVOs .length; i++) {
				if(priScgAplyDtRuleVOs[i].getIbflag().equals("I")) {
					priScgAplyDtRuleVOs[i].setCreUsrId(account.getUsr_id());
					priScgAplyDtRuleVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScgAplyDtRuleVOs[i]);
				} else if(priScgAplyDtRuleVOs[i].getIbflag().equals("U")) {
					priScgAplyDtRuleVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScgAplyDtRuleVOs[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyApplicatoinDateRule(updateVoList);
			}

            if ( insertVoList.size() > 0 ) {
                dbDao.addApplicatoinDateRule(insertVoList);
            }

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Location 체크 및 Location Type 을 조회합니다. <br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchLocationTypeAndName(RsltCdListVO rsltCdListVO) throws EventException {
		try {
			return dbDao.searchLocationTypeAndName(rsltCdListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
           throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SAVE전 중복 데이터를 조회합니다. <br>
	 * 
	 * @param PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs
	 * @return List<RsltPriScgAplyDtRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriScgAplyDtRuleVO> searchApplicationDateRuleDupCheck(PriScgAplyDtRuleVO[] priScgAplyDtRuleVOs) throws EventException {
		try {
			List<PriScgAplyDtRuleVO> checkVoList1 = new ArrayList<PriScgAplyDtRuleVO>();
			List<PriScgAplyDtRuleVO> checkVoList2 = new ArrayList<PriScgAplyDtRuleVO>();
			
			for(int i=0; i<priScgAplyDtRuleVOs .length; i++) {
				if(priScgAplyDtRuleVOs[i].getIbflag().equals("I")) {
					checkVoList1.add(priScgAplyDtRuleVOs[i]);
				} else if(priScgAplyDtRuleVOs[i].getIbflag().equals("U")) {
					checkVoList1.add(priScgAplyDtRuleVOs[i]);
					checkVoList2.add(priScgAplyDtRuleVOs[i]);
				}
			}
			return dbDao.searchApplicationDateRuleDupCheck(checkVoList1, checkVoList2);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
           throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}