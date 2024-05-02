/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupLocationCMPBGuidelineBCImpl.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.integration.GroupLocationCMPBGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.GroupLocationCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.grouplocationcmpbguideline.vo.RsltPriCmpbGrpLocDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpLocVO;

/**
 * ALPS-ProfitabilitySimulation Business Logic Basic Command implementation<br>
 * - ALPS-ProfitabilitySimulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6042EventResponse,GroupLocationCMPBGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class GroupLocationCMPBGuidelineBCImpl extends BasicCommandSupport implements GroupLocationCMPBGuidelineBC {

	// Database Access Object
	private transient GroupLocationCMPBGuidelineDBDAO dbDao = null;

	/**
	 * GroupLocationCMPBGuidelineBCImpl 객체 생성<br>
	 * GroupLocationCMPBGuidelineDBDAO를 생성한다.<br>
	 */
	public GroupLocationCMPBGuidelineBCImpl() {
		dbDao = new GroupLocationCMPBGuidelineDBDAO();
	}
	
	/**
	 * PRI_CMPB_GRP_LOC_DTL 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpLocVO priCmpbGrpLocVO 
	 * @return List<RsltPriCmpbGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGrpLocDtlVO> searchCmpbGlineGroupLocationDetailList(PriCmpbGrpLocVO priCmpbGrpLocVO) throws EventException {
		try {
			return dbDao.searchCmpbGlineGroupLocationDetailList(priCmpbGrpLocVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_CMPB_GRP_LOC 테이블을 조회한다.<br>
	 * 
	 * @param PriCmpbGrpLocVO priCmpbGrpLocVO
	 * @return List<PriCmpbGrpLocVO>
	 * @exception EventException
	 */
	public List<PriCmpbGrpLocVO> searchCmpbGlineGroupLocationList(PriCmpbGrpLocVO priCmpbGrpLocVO) throws EventException {
		try {
			return dbDao.searchCmpbGlineGroupLocationList(priCmpbGrpLocVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_CMPB_GRP_LOC, PRI_CMPB_GRP_LOC_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocationCmpbGuideline(GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 commodity, detail을 뺀다
			PriCmpbGrpLocVO[] priCmpbGrpLocVOs 			= groupLocationCmpbGuidelineVO.getPriCmpbGrpLocVOs();
			PriCmpbGrpLocDtlVO[] priCmpbGrpLocDtlVOs 	= groupLocationCmpbGuidelineVO.getPriCmpbGrpLocDtlVOs();
			
			//location
			List<PriCmpbGrpLocVO> insertVoList = new ArrayList<PriCmpbGrpLocVO>();
			List<PriCmpbGrpLocVO> updateVoList = new ArrayList<PriCmpbGrpLocVO>();
			List<PriCmpbGrpLocVO> deleteVoList = new ArrayList<PriCmpbGrpLocVO>();
			//location detail 
			List<PriCmpbGrpLocDtlVO> insertDtlVoList = new ArrayList<PriCmpbGrpLocDtlVO>();
			List<PriCmpbGrpLocDtlVO> updateDtlVoList = new ArrayList<PriCmpbGrpLocDtlVO>();
			List<PriCmpbGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriCmpbGrpLocDtlVO>();

			
			
			////////////////////////////location / detail 저장/////////////////////////////////////	
			
			//Group Location
			for (int i = 0; priCmpbGrpLocVOs != null && i < priCmpbGrpLocVOs.length; i++) {
				
				if ( priCmpbGrpLocVOs[i].getIbflag().equals("I")){
					priCmpbGrpLocVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priCmpbGrpLocVOs[i]);
				} else if ( priCmpbGrpLocVOs[i].getIbflag().equals("U")){
					priCmpbGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priCmpbGrpLocVOs[i]);
				} else if ( priCmpbGrpLocVOs[i].getIbflag().equals("D")){
					priCmpbGrpLocVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priCmpbGrpLocVOs[i]);
					//본문별 디테일 삭제
//					if(i==0) {
						dbDao.removeCmpbGlineGroupLocationDetail(priCmpbGrpLocVOs[i]);
						//디테일을 이미 삭제 했으므로 널로 세팅
						priCmpbGrpLocDtlVOs = null;
//					}
					
				}
				
			}
			
			//detail
			for (int i = 0; priCmpbGrpLocDtlVOs != null && i < priCmpbGrpLocDtlVOs.length; i++) {
				
				if ( priCmpbGrpLocDtlVOs[i].getIbflag().equals("I")) {
					priCmpbGrpLocDtlVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priCmpbGrpLocDtlVOs[i]);
					
					
				} else if ( priCmpbGrpLocDtlVOs[i].getIbflag().equals("U")){
					priCmpbGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priCmpbGrpLocDtlVOs[i]);
				} else if ( priCmpbGrpLocDtlVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priCmpbGrpLocDtlVOs[i]);
				}
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeCmpbGlineGroupLocationDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCmpbGlineGroupLocationS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addCmpbGlineGroupLocationS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addCmpbGlineGroupLocationDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyCmpbGlineGroupLocationS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyCmpbGlineGroupLocationDetailS(updateDtlVoList);
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
	 * 헤더 별 copy 등록한다.<br>
	 * 
	 * @param RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void copyGroupLocationCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException{
		try {

			//헤더 별 모든 데이터를 복사 후 등록한다
			//gline_seq를 SC에서 미리 조회하여 세팅
			if(rsltDurationCreationOfficeVO != null) {
				
				rsltDurationCreationOfficeVO.setCreUsrId(account.getUsr_id());
				rsltDurationCreationOfficeVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyCmpbGlineGroupLocation(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGlineGroupLocationDetail(rsltDurationCreationOfficeVO);
				
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
	 * 헤더 별 전체 삭제한다.<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void removeGroupLocationCmpbGuideline (PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException{
		try {

			priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
				
			dbDao.removeCmpbGroupLocationDetail(priCmpbGlineMnVO);
			dbDao.removeCmpbGroupLocation(priCmpbGlineMnVO);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	
	/**
	 * Rate에서 사용하는 Location 코드가 있는지 조회한다.
	 * @param GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(GroupLocationCmpbGuidelineVO groupLocationCmpbGuidelineVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriCmpbGrpLocVO[] priCmpbGrpLocVOs = groupLocationCmpbGuidelineVO.getPriCmpbGrpLocVOs();
			PriCmpbGrpLocVO priCmpbGrpLocVO = groupLocationCmpbGuidelineVO.getPriCmpbGrpLocVO();
			
			String prs_cust_tp_cd = "";
			
			if(priCmpbGrpLocVOs != null) {
			
				for (int i = 0; i < priCmpbGrpLocVOs.length; i++) {
					
					PriCmpbGrpLocVO row = priCmpbGrpLocVOs[i];
	
					if(i==0) prs_cust_tp_cd = row.getCreUsrId();
					
					row.setCreUsrId(prs_cust_tp_cd);
					
					RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(row);
					
					if (cdVO != null) {						
						rslt.add(cdVO);
					}
	
				}
				
			} else {
				
				RsltCdListVO cdVO = dbDao.searchCheckGroupLocationInUse(priCmpbGrpLocVO);
				
				if (cdVO != null) {						
					rslt.add(cdVO);
				}
				
			}
			
			return rslt;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
}