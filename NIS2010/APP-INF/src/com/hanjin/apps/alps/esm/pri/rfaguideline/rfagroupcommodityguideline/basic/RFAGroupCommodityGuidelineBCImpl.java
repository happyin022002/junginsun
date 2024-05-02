/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineBCImpl.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration.RFAGroupCommodityGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRgMnVO;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see UI_PRI_2001_02EventResponse,RFAGroupCommodityGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAGroupCommodityGuidelineBCImpl extends BasicCommandSupport implements RFAGroupCommodityGuidelineBC {

	// Database Access Object
	private transient RFAGroupCommodityGuidelineDBDAO dbDao = null;

	/**
	 * RFAGroupCommodityGuidelineBCImpl 객체 생성<br>
	 * RFAGroupCommodityGuidelineDBDAO를 생성한다.<br>
	 */
	public RFAGroupCommodityGuidelineBCImpl() {
		dbDao = new RFAGroupCommodityGuidelineDBDAO();
	}
	
	/**
	 * COMMODITY GROUP을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO  
	 * @return List<PriRgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtVO> searchGroupCommodityGuidelineList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException {
		try {
			List<PriRgGrpCmdtVO> priRgGrpCmdtVO1 	  = new ArrayList<PriRgGrpCmdtVO>();
			priRgGrpCmdtVO1 	= dbDao.searchGroupCommodityGuidelineList(priRgGrpCmdtVO);
			return priRgGrpCmdtVO1;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * COMMODITY GROUP DETAIL을 조회합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO  
	 * @return List<RsltPriRgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriRgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException {
		try {
			List<RsltPriRgGrpCmdtDtlVO> rsltPriRgGrpCmdtDtlVO = new ArrayList<RsltPriRgGrpCmdtDtlVO>();
			rsltPriRgGrpCmdtDtlVO 	= dbDao.searchGroupCommodityGuidelineDtlList(priRgGrpCmdtVO);			
			return rsltPriRgGrpCmdtDtlVO;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * COMMODITY GROUP을 저장합니다.
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO, SignOnUserAccount account) throws EventException{
		try {
			PriRgGrpCmdtVO[] vo = grpCmdtGlineVO.getPriRgGrpCmdtVOS();
			PriRgGrpCmdtDtlVO[] dtlvo = grpCmdtGlineVO.getPriRgGrpCmdtDtlVOS();

			List<PriRgGrpCmdtVO> insertVoList = new ArrayList<PriRgGrpCmdtVO>();
			List<PriRgGrpCmdtVO> updateVoList = new ArrayList<PriRgGrpCmdtVO>();
			List<PriRgGrpCmdtVO> deleteVoList = new ArrayList<PriRgGrpCmdtVO>();
			List<PriRgGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriRgGrpCmdtDtlVO>();
			List<PriRgGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriRgGrpCmdtDtlVO>();
			List<PriRgGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriRgGrpCmdtDtlVO>();	
			
			for (int i = 0; vo != null && i < vo.length; i++) {				
				if ( vo[i].getIbflag().equals("I")){
				
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				
				if ( dtlvo[i].getIbflag().equals("I")){			
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					deleteDtlVoList.add(dtlvo[i]);
				}
			}
			
			if (insertVoList.size() > 0) {
				dbDao.addmanageGroupCommodityGuidelineS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addmanageGroupCommodityGuidelineDtl(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifymanageGroupCommodityGuidelineS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifymanageGroupCommodityGuidelineDtl(updateDtlVoList);
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removemanageGroupCommodityGuidelineDtl(deleteDtlVoList);
			}

			if (deleteVoList.size() > 0) {				
				dbDao.removemanageGroupCommodityGuidelineDtlS(deleteVoList);
				dbDao.removemanageGroupCommodityGuidelineS(deleteVoList);
			}			
			

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Guideline Group Commodity 정보를 삭제합니다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO priRgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainGroupCommodityDetail(priRgMnVO);
			dbDao.removeGuidelineMainGroupCommodity(priRgMnVO);			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * TPW Group Commodity 조회 이벤트 처리<br>
	 *  RFAGroupCommodityGuideline화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param PriScgGrpCmdtVO priScgGrpCmdtVO  
	 * @return List<PriScgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priScgGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGRIGroupCommodityGuidelineList(priScgGrpCmdtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 선택한 TPW Group Commodity 로 Group Commodity 를 생성합니다.<br>
	 * 
	 * @param PriGriGrpCmdtVO[] priGriGrpCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createGRIGroupCommodityGuideline(PriGriGrpCmdtVO[] priGriGrpCmdtVOs, SignOnUserAccount account) throws EventException{
		try {
			int grpCmdtSeq = 0;
			StringBuffer sbPrcGrpCmdtCd = new StringBuffer(5);
			for (int i = 0; i < priGriGrpCmdtVOs.length; i++) {
				if (priGriGrpCmdtVOs[i].getIbflag().equals("I")) {
				    sbPrcGrpCmdtCd = new StringBuffer(5);
					++grpCmdtSeq;
					
					priGriGrpCmdtVOs[i].setGrpCmdtSeq(new Integer(grpCmdtSeq).toString());
					sbPrcGrpCmdtCd.append("GRP").append(JSPUtil.customString(grpCmdtSeq, 2));
					priGriGrpCmdtVOs[i].setPrcGrpCmdtCd(sbPrcGrpCmdtCd.toString());
					priGriGrpCmdtVOs[i].setPrcGrpCmdtDesc(priGriGrpCmdtVOs[i].getScgGrpCmdtDesc());
					priGriGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priGriGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addGroupCommodityGuideline(priGriGrpCmdtVOs[i]);
					dbDao.addGroupCommodityGuidelineDetail(priGriGrpCmdtVOs[i]);
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * rate 에서 사용하는 Commodity 를 조회한다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<RsltCdListVO> 
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityInUse(priRgGrpCmdtVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * RFA Guideline Group Commodity 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO rsltRfaGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineMain(RsltRfaGlineCopyVO rsltRfaGlineCopyVO, SignOnUserAccount account) throws EventException {
        try {
            rsltRfaGlineCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaGlineCopyVO.setUpdUsrId(account.getUsr_id());
            
            dbDao.addGlineCopyGroupCommodity(rsltRfaGlineCopyVO);
            dbDao.addGlineCopyGroupCommodityDetail(rsltRfaGlineCopyVO);
            
        } catch(DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 *  RFA Guideline Group Commodity 정보를 다운로드 합니다.<br>
	 * 
	 * @param PriRgGrpCmdtVO priRgGrpCmdtVO
	 * @return List<PriRgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriRgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriRgGrpCmdtVO priRgGrpCmdtVO) throws EventException {
		try {
			List<PriRgGrpCmdtExcelVO> vo = new ArrayList<PriRgGrpCmdtExcelVO>();
			vo 	= dbDao.searchGroupCommodityGuidelineExcelList(priRgGrpCmdtVO);			
			return vo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
}