/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailBCImpl.java
*@FileTitle : Guideline Email
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration.CntrPlanGuidelineEmailDBDAO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-GuidelineEmail Business Logic Basic Command implementation<br>
 * - OPUS-GuidelineEmail에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author YONGCHAN SHIN
 * @see EES_EQR_1030EventResponse,CntrPlanGuidelineManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrPlanGuidelineEmailBCImpl extends BasicCommandSupport implements CntrPlanGuidelineEmailBC {
	/**
	 * Database Access Object
	 */
	private transient CntrPlanGuidelineEmailDBDAO dbDao = null;

	/**
	 * CntrPlanGuidelineEmailBCImpl 객체 생성<br> 
	 * CntrRepoExecutionPlanEstablishDBDAO를 생성한다.<br>
	 */
	public CntrPlanGuidelineEmailBCImpl() {
		dbDao = new CntrPlanGuidelineEmailDBDAO();
	}
	
	/**
	 * [ EES_EQR_1030 : Guideline Email 수신자 리스트 Search ] <br>
	 * @param EesEqr1030ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchGuidelineEmailList(EesEqr1030ConditionVO condVO) throws EventException {
		try {
			return dbDao.searchGuidelineEmailList(condVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-Up ]<br>
	 * 입력될 이메일 수신자 ID 의 검증 및 name/office/email 정보 조회
	 * @param String usr_id
	 * @return EesEqr1030MultiVO
	 * @exception EventException
	 */
	public EesEqr1030MultiVO searchGuidelineEmailUserInfo(String usr_id) throws EventException {
		try {
			return dbDao.searchGuidelineEmailUserInfo(usr_id);
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}			
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 입력/수정/삭제 처리
	 * 
	 * @param EesEqr1030MultiVO[] eesEqr1030MultiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiGuidelineEmailList(EesEqr1030MultiVO[] eesEqr1030MultiVOs, SignOnUserAccount account) throws EventException{
		try {
			List<Map<String, Object>> insertVoList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> updateVoList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> deleteVoList = new ArrayList<Map<String, Object>>();
				
			for ( int i=0; i<eesEqr1030MultiVOs.length; i++ ) {
				if ( eesEqr1030MultiVOs[i].getIbflag().equals("I")){
						
					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(eesEqr1030MultiVOs[i].getColumnValues());
					insertVoList.add(list);
					
					list.put("usr_id", account.getUsr_id());													
				
				} else if ( eesEqr1030MultiVOs[i].getIbflag().equals("U")){
					
					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(eesEqr1030MultiVOs[i].getColumnValues());
					updateVoList.add(list);
					
					list.put("usr_id", account.getUsr_id());				  					
					
				} else if ( eesEqr1030MultiVOs[i].getIbflag().equals("D")){

					Map<String, Object> list = new HashMap<String, Object>();
					list.putAll(eesEqr1030MultiVOs[i].getColumnValues());
					deleteVoList.add(list);

				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addGuidelineEmailList(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGuidelineEmailList(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGuidelineEmailList(deleteVoList);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * Guideline email 수신자조회
	 * @param EesEqr1031ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchGuidelineEmailContentsRecipient(EesEqr1031ConditionVO condVO) throws EventException {
		
		String recipient = "";
		try {
			
			recipient = dbDao.searchGuidelineEmailContentsRecipient(condVO);			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return recipient;
	}	
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * 최근 저장된 GUIDELINE LANE 조회
	 * @param EesEqr1031ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchGuidelineEmailContentsVslLaneCd(EesEqr1031ConditionVO condVO) throws EventException {
		
		String vsl_lane_cd = "";
		try {
			
			vsl_lane_cd = dbDao.searchGuidelineEmailContentsVslLaneCd(condVO);			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return vsl_lane_cd;
	}		
}