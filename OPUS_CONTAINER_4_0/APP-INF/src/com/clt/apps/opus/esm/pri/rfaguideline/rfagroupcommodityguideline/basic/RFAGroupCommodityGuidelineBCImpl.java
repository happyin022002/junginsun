/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineBCImpl.java
*@FileTitle : Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.integration.RFAGroupCommodityGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.PriRgGrpCmdtExcelVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfagroupcommodityguideline.vo.RsltPriRgGrpCmdtDtlVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRgGrpCmdtVO;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 *
 * @author
 * @see UI_PRI_2001_02EventResponse,RFAGroupCommodityGuidelineBC - Refer to each DAO class
 * @since J2EE 1.4
 */

public class RFAGroupCommodityGuidelineBCImpl extends BasicCommandSupport implements RFAGroupCommodityGuidelineBC {

	// Database Access Object
	private transient RFAGroupCommodityGuidelineDBDAO dbDao = null;

	/**
	 * Creating RFAGroupCommodityGuidelineBCImpl objet<br>
	 * Creating RFAGroupCommodityGuidelineDBDAO<br>
	 */
	public RFAGroupCommodityGuidelineBCImpl() {
		dbDao = new RFAGroupCommodityGuidelineDBDAO();
	}
	
	/**
	 * Retrieving COMMODITY GROUP<br>
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
	 * Retrieving COMMODITY GROUP DETAIL<br>
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
	 * Saving COMMODITY GROUP
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
	 * Deleting Guideline Group Commodity information<br>
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
	 * Retrieving commodity in rate <br>
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
     * Copying RFA Guideline Group Commodity Information.<br>
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
	 *  Downloading RFA Guideline Group Commodity Information<br>
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