/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineBCImpl.java
*@FileTitle : Commondity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.integration.SCGroupCommodityGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.GrpCmdtGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriGriGrpCmdtVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.PriSgGrpCmdtExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtCustTypeVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.vo.RsltPriSgGrpCmdtDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see UI_PRI_0001_03EventResponse,SCGroupCommodityGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCGroupCommodityGuidelineBCImpl extends BasicCommandSupport implements SCGroupCommodityGuidelineBC {

	// Database Access Object
	private transient SCGroupCommodityGuidelineDBDAO dbDao = null;

	/**
	 * SCGroupCommodityGuidelineBCImpl 객체 생성<br>
	 * SCGroupCommodityGuidelineDBDAO를 생성한다.<br>
	 */
	public SCGroupCommodityGuidelineBCImpl() {
		dbDao = new SCGroupCommodityGuidelineDBDAO();
	}
	/**
	 * GroupCommodity Cust Type별 데이터 Count를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtCustTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtCustTypeVO> searchGroupCommodityGuideCustTypeCount(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException {
		try {			
			return dbDao.searchGroupCommodityGuideCustTypeCount(priSgGrpCmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Group Commodity 메인을 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtVO> searchGroupCommodityGuidelineList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException {
		try {
			List<PriSgGrpCmdtVO> priSgGrpCmdtVO1 	  = new ArrayList<PriSgGrpCmdtVO>();
			priSgGrpCmdtVO1 	= dbDao.searchGroupCommodityGuidelineList(priSgGrpCmdtVO);
			return priSgGrpCmdtVO1;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Group Commodity 상세를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltPriSgGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpCmdtDtlVO> searchGroupCommodityGuidelineDtlList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException {
		try {
			List<RsltPriSgGrpCmdtDtlVO> rsltPriSgGrpCmdtDtlVO = new ArrayList<RsltPriSgGrpCmdtDtlVO>();
			rsltPriSgGrpCmdtDtlVO 	= dbDao.searchGroupCommodityGuidelineDtlList(priSgGrpCmdtVO);			
			return rsltPriSgGrpCmdtDtlVO;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Group Commodity 를 저장합니다.<br>
	 * 
	 * @param GrpCmdtGlineVO grpCmdtGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodityGuideline(GrpCmdtGlineVO grpCmdtGlineVO, SignOnUserAccount account) throws EventException{
		try {
			PriSgGrpCmdtVO[] vo = grpCmdtGlineVO.getPriSgGrpCmdtVOS();
			PriSgGrpCmdtDtlVO[] dtlvo = grpCmdtGlineVO.getPriSgGrpCmdtDtlVOS();
			
			
			List<PriSgGrpCmdtVO> insertVoList = new ArrayList<PriSgGrpCmdtVO>();
			List<PriSgGrpCmdtVO> updateVoList = new ArrayList<PriSgGrpCmdtVO>();
			List<PriSgGrpCmdtVO> deleteVoList = new ArrayList<PriSgGrpCmdtVO>();
			List<PriSgGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriSgGrpCmdtDtlVO>();
			List<PriSgGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriSgGrpCmdtDtlVO>();
			List<PriSgGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriSgGrpCmdtDtlVO>();	
			
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
				dbDao.addGroupCommodityGuidelineS(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupCommodityGuidelineDtl(insertDtlVoList);
			}
			
			if (updateVoList.size() > 0) {
				dbDao.modifyGroupCommodityGuidelineS(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyGroupCommodityGuidelineDtl(updateDtlVoList);
			}
			
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGroupCommodityGuidelineDtl(deleteDtlVoList);
			}

			if (deleteVoList.size() > 0) {				
				dbDao.removeGroupCommodityGuidelineDtlS(deleteVoList);
				dbDao.removeGroupCommodityGuidelineS(deleteVoList);
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
	 * Group Commodity를 삭제합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainGroupCommodityDetail(priSgMnVO);
			dbDao.removeGuidelineMainGroupCommodity(priSgMnVO);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Excel로 Download하기위한 데이터를 조회합니다.<br>
	 * 
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<PriSgGrpCmdtExcelVO>
	 * @exception EventException
	 */
	public List<PriSgGrpCmdtExcelVO> searchGroupCommodityGuidelineExcelList(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException {
		try {
			List<PriSgGrpCmdtExcelVO> vo = new ArrayList<PriSgGrpCmdtExcelVO>();
			vo 	= dbDao.searchGroupCommodityGuidelineExcelList(priSgGrpCmdtVO);			
			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Surcharge Group Commodity 정보를 조회합니다.<br>
	 * 
	 * @param PriScgGrpCmdtVO priComGrpCmdtVO
	 * @return List<PriSgGrpCmdtVO>
	 * @exception EventException
	 */
	public List<PriScgGrpCmdtVO> searchGRIGroupCommodityGuidelineList(PriScgGrpCmdtVO priComGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGRIGroupCommodityGuidelineList(priComGrpCmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception de) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Guideline TPW Group Commodity 정보를 생성합니다.<br>
	 * 
	 * @param PriGriGrpCmdtVO[] priGriGrpCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createGRIGroupCommodityGuideline(PriGriGrpCmdtVO[] priGriGrpCmdtVOs, SignOnUserAccount account) throws EventException{
		try {
			int grpCmdtSeq = 0;
			StringBuilder sbPrcGrpCmdtCd = null;
			StringBuilder sbPrcGrpCmdtDesc = null;
			for (int i = 0; i < priGriGrpCmdtVOs.length; i++) {
				if (priGriGrpCmdtVOs[i].getIbflag().equals("I")) {
				    sbPrcGrpCmdtCd = new StringBuilder(5);
				    sbPrcGrpCmdtDesc = new StringBuilder();
					++grpCmdtSeq;
					
					priGriGrpCmdtVOs[i].setGrpCmdtSeq(new Integer(grpCmdtSeq).toString());
					sbPrcGrpCmdtCd.append("G").append(JSPUtil.customString(grpCmdtSeq, 4));
					sbPrcGrpCmdtDesc.append("Group ").append(grpCmdtSeq);
					priGriGrpCmdtVOs[i].setPrcGrpCmdtCd(sbPrcGrpCmdtCd.toString());
					priGriGrpCmdtVOs[i].setPrcGrpCmdtDesc(sbPrcGrpCmdtDesc.toString());
                    priGriGrpCmdtVOs[i].setCreUsrId(account.getUsr_id());
					priGriGrpCmdtVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.addGroupCommodityGuideline(priGriGrpCmdtVOs[i]);
					dbDao.addGroupCommodityGuidelineDetail(priGriGrpCmdtVOs[i]);
				}
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
	 * Commodity Guideline Copy를 처리합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.addGuidelineMainGroupCommodityCopy(glineMnCpVO);
			dbDao.addGuidelineMainGroupCommodityDetailCopy(glineMnCpVO);
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
	 * @param PriSgGrpCmdtVO priSgGrpCmdtVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupCommodityInUse(PriSgGrpCmdtVO priSgGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchCheckGroupCommodityInUse(priSgGrpCmdtVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
	
}