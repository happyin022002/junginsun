/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MqcRangeCMPBGuidelineBCImpl.java
*@FileTitle : CMPB Guideline- MQC Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.mqcrangecmpbguideline.integration.MqcRangeCMPBGuidelineDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGlineMqcRngVO;

/**
 * ALPS-ProfitabilitySimulation Business Logic Basic Command implementation<br>
 * - ALPS-ProfitabilitySimulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6003EventResponse,MqcRangeCMPBGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MqcRangeCMPBGuidelineBCImpl extends BasicCommandSupport implements MqcRangeCMPBGuidelineBC {

	// Database Access Object
	private transient MqcRangeCMPBGuidelineDBDAO dbDao = null;

	/**
	 * MqcRangeCMPBGuidelineBCImpl 객체 생성<br>
	 * MqcRangeCMPBGuidelineDBDAO를 생성한다.<br>
	 */
	public MqcRangeCMPBGuidelineBCImpl() {
		dbDao = new MqcRangeCMPBGuidelineDBDAO();
	}
	/**
	 * MQC RNG를 조회한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO
	 * @return List<PriCmpbGlineMqcRngVO>
	 * @exception EventException
	 */
	public List<PriCmpbGlineMqcRngVO> searchCmpbGlineMqcRangeList(PriCmpbGlineMqcRngVO priCmpbGlineMqcRngVO) throws EventException {
		try {
			return dbDao.searchCmpbGlineMqcRangeList(priCmpbGlineMqcRngVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * MQC RNG를 등록 수정 삭제 한다.(PRI_CMPB_GLINE_MQC_RNG)<br>
	 * 
	 * @param PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMqcRangeCmpbGuideline(PriCmpbGlineMqcRngVO[] priCmpbGlineMqcRngVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriCmpbGlineMqcRngVO> insertVoList = new ArrayList<PriCmpbGlineMqcRngVO>();
			List<PriCmpbGlineMqcRngVO> updateVoList = new ArrayList<PriCmpbGlineMqcRngVO>();
			List<PriCmpbGlineMqcRngVO> deleteVoList = new ArrayList<PriCmpbGlineMqcRngVO>();
			for ( int i=0; i<priCmpbGlineMqcRngVO .length; i++ ) {
				if ( priCmpbGlineMqcRngVO[i].getIbflag().equals("I")){
					priCmpbGlineMqcRngVO[i].setCreUsrId(account.getUsr_id());
					priCmpbGlineMqcRngVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priCmpbGlineMqcRngVO[i]);
				} else if ( priCmpbGlineMqcRngVO[i].getIbflag().equals("U")){
					priCmpbGlineMqcRngVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priCmpbGlineMqcRngVO[i]);
				} else if ( priCmpbGlineMqcRngVO[i].getIbflag().equals("D")){
					deleteVoList.add(priCmpbGlineMqcRngVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMqcRangeCmpbGuidelineS(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMqcRangeCmpbGuidelineS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMqcRangeCmpbGuidelineS(updateVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 헤더 별 copy 등록한다<br>
	 * 
	 * @param rsltDurationCreationOfficeVO RsltDurationCreationOfficeVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyMqcRangeCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException{
		try {

			//헤더 별 모든 데이터를 복사 후 등록한다
			//gline_seq를 SC에서 미리 조회하여 세팅
			if(rsltDurationCreationOfficeVO != null) {
				
				rsltDurationCreationOfficeVO.setCreUsrId(account.getUsr_id());
				rsltDurationCreationOfficeVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyMqcRangeCmpbGuideline(rsltDurationCreationOfficeVO);
				
			}	
			
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * PRI_CMPB_GLINE_MQC_RNG 테이블을 헤더 별 전체 삭제<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeMqcRangeCmpbGuideline(PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException{
		try {

			priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
				
			dbDao.removeMqcRangeCmpbGuideline(priCmpbGlineMnVO);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
}