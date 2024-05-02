/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupCommodityCMPBGuidelineBCImpl.java
*@FileTitle : CMPB Guideline Creation - Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.vo.RsltDurationCreationOfficeVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.integration.GroupCommodityCMPBGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.GroupCommodityCmpbGuidelineVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.groupcommoditycmpbguideline.vo.RsltPriCmpbGrpCmdtDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCmpbGlineMnVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriCmpbGrpCmdtVO;

/**
 * ALPS-ProfitabilitySimulation Business Logic Basic Command implementation<br>
 * - ALPS-ProfitabilitySimulation에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6041EventResponse,GroupCommodityCMPBGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class GroupCommodityCMPBGuidelineBCImpl extends BasicCommandSupport implements GroupCommodityCMPBGuidelineBC {

	// Database Access Object
	private transient GroupCommodityCMPBGuidelineDBDAO dbDao = null;

	/**
	 * GroupCommodityCMPBGuidelineBCImpl 객체 생성<br>
	 * GroupCommodityCMPBGuidelineDBDAO를 생성한다.<br>
	 */
	public GroupCommodityCMPBGuidelineBCImpl() {
		dbDao = new GroupCommodityCMPBGuidelineDBDAO();
	}
	/**
	 * PRI_CMPB_GRP_CMDT_DTL 테이블을 조회한다.<br>
	 * 
	 * @param priCmpbGrpCmdtVO PriCmpbGrpCmdtVO 
	 * @return List<RsltPriCmpbGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriCmpbGrpCmdtDtlVO> searchCmpbGroupCommodityDetailList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchCmpbGroupCommodityDetailList(priCmpbGrpCmdtVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_CMPB_GRP_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param priCmpbGrpCmdtVO PriCmpbGrpCmdtVO
	 * @return List<PriCmpbGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriCmpbGrpCmdtVO> searchCmpbGroupCommodityList(PriCmpbGrpCmdtVO priCmpbGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchCmpbGroupCommodityList(priCmpbGrpCmdtVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * PRI_CMPB_GRP_CMDT, PRI_CMPB_GRP_CMDT_DTL을 입력 수정 삭제한다<br>
	 * 
	 * @param groupCommodityCmpbGuidelineVO GroupCommodityCmpbGuidelineVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageGroupCommodityCmpbGuideline(GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO, SignOnUserAccount account) 
		throws EventException{
		try {
			
			//컨테이너 vo에서 commodity, detail을 뺀다
			PriCmpbGrpCmdtVO[] priCmpbGrpCmdtVOs 		= groupCommodityCmpbGuidelineVO.getPriCmpbGrpCmdtVOs();
			PriCmpbGrpCmdtDtlVO[] priCmpbGrpCmdtDtlVOs 	= groupCommodityCmpbGuidelineVO.getPriCmpbGrpCmptDtlVOs();
			
			//commodity
			List<PriCmpbGrpCmdtVO> insertVoList = new ArrayList<PriCmpbGrpCmdtVO>();
			List<PriCmpbGrpCmdtVO> updateVoList = new ArrayList<PriCmpbGrpCmdtVO>();
			List<PriCmpbGrpCmdtVO> deleteVoList = new ArrayList<PriCmpbGrpCmdtVO>();
			//commodity detail 
			List<PriCmpbGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriCmpbGrpCmdtDtlVO>();
			List<PriCmpbGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriCmpbGrpCmdtDtlVO>();
			List<PriCmpbGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriCmpbGrpCmdtDtlVO>();

			
			
			////////////////////////////commodity / detail 저장/////////////////////////////////////	
			
			//Group Location
			for (int i = 0; priCmpbGrpCmdtVOs != null && i < priCmpbGrpCmdtVOs.length; i++) {
				
				if ( priCmpbGrpCmdtVOs[i].getIbflag().equals("I")){
					priCmpbGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priCmpbGrpCmdtVOs[i]);
				} else if ( priCmpbGrpCmdtVOs[i].getIbflag().equals("U")){
					priCmpbGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priCmpbGrpCmdtVOs[i]);
				} else if ( priCmpbGrpCmdtVOs[i].getIbflag().equals("D")){
					priCmpbGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priCmpbGrpCmdtVOs[i]);
					//본문별 디테일 삭제
//					if(i==0) {
						dbDao.removeCmpbGroupCommodityDetail(priCmpbGrpCmdtVOs[i]);
						//디테일을 이미 삭제 했으므로 널로 세팅
						priCmpbGrpCmdtDtlVOs = null;
//					}
					
				}
				
			}
			
			//detail
			for (int i = 0; priCmpbGrpCmdtDtlVOs != null && i < priCmpbGrpCmdtDtlVOs.length; i++) {
				
				if ( priCmpbGrpCmdtDtlVOs[i].getIbflag().equals("I")) {
					priCmpbGrpCmdtDtlVOs[i].setCreUsrId(account.getUsr_id());
					priCmpbGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(priCmpbGrpCmdtDtlVOs[i]);
				} else if ( priCmpbGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					priCmpbGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priCmpbGrpCmdtDtlVOs[i]);
				} else if ( priCmpbGrpCmdtDtlVOs[i].getIbflag().equals("D")){
					deleteDtlVoList.add(priCmpbGrpCmdtDtlVOs[i]);
				}
			}


			if (deleteDtlVoList.size() > 0) {
				dbDao.removeCmpbGroupCommodityDetailS(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCmpbGroupCommodityS(deleteVoList);
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addCmpbGroupCommodityS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addCmpbGroupCommodityDetailS(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyCmpbGroupCommodityS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyCmpbGroupCommodityDetailS(updateDtlVoList);
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
	 * 헤더 별 copy 등록한다<br>
	 * 
	 * @param rsltDurationCreationOfficeVO RsltDurationCreationOfficeVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void copyGroupCommodityCmpbGuideline(RsltDurationCreationOfficeVO rsltDurationCreationOfficeVO, SignOnUserAccount account) throws EventException{
		try {

			//헤더 별 모든 데이터를 복사 후 등록한다
			//gline_seq를 SC에서 미리 조회하여 세팅
			if(rsltDurationCreationOfficeVO != null) {
				
				rsltDurationCreationOfficeVO.setCreUsrId(account.getUsr_id());
				rsltDurationCreationOfficeVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addCopyCmpbGroupCommodity(rsltDurationCreationOfficeVO);
				dbDao.addCopyCmpbGroupCommodityDetail(rsltDurationCreationOfficeVO);
				
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
	 * 헤더 별 전체 삭제<br>
	 * 
	 * @param PriCmpbGlineMnVO priCmpbGlineMnVO
	 * @param SignOnUserAccount account  
	 * @exception EventException
	 */
	public void removeGroupCommodityCmpbGuideline (PriCmpbGlineMnVO priCmpbGlineMnVO, SignOnUserAccount account ) throws EventException{
		try {

			priCmpbGlineMnVO.setCreUsrId(account.getUsr_id());
			priCmpbGlineMnVO.setUpdUsrId(account.getUsr_id());
				
			dbDao.removeCmpbGroupCommodityDetail(priCmpbGlineMnVO);
			dbDao.removeCmpbGroupCommodity(priCmpbGlineMnVO);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Rate에서 사용하는 commodity 코드가 있는지 조회한다.
	 * @param GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(GroupCommodityCmpbGuidelineVO groupCommodityCmpbGuidelineVO) throws EventException {
		try {
			List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
			
			PriCmpbGrpCmdtVO[] priCmpbGrpCmdtVOs = groupCommodityCmpbGuidelineVO.getPriCmpbGrpCmdtVOs();
			
			String prs_cust_tp_cd = "";
			
			for (int i = 0; i < priCmpbGrpCmdtVOs.length; i++) {
				
				PriCmpbGrpCmdtVO row = priCmpbGrpCmdtVOs[i];

				if(i==0) prs_cust_tp_cd = row.getCreUsrId();
				
				row.setCreUsrId(prs_cust_tp_cd);
				
				RsltCdListVO cdVO = dbDao.searchCheckGroupCommodityInUse(row);
				
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